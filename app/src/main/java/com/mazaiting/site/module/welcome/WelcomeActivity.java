package com.mazaiting.site.module.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mazaiting.easy.app.ApplicationComponent;
import com.mazaiting.easy.base.activity.BaseActivity;
import com.mazaiting.site.R;
import com.mazaiting.site.base.component.ApplicationComponentImpl;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.module.login.DaggerLoginComponent;
import com.mazaiting.site.module.login.LoginActivity;
import com.mazaiting.site.module.login.LoginContract;
import com.mazaiting.site.module.login.LoginPresenter;
import com.mazaiting.site.module.main.MainActivity;

import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 欢迎页
 *
 * @author mazaiting
 */
public class WelcomeActivity extends BaseActivity<LoginPresenter> implements LoginContract.View{
    /**跳过按钮*/
    @BindView(R.id.welcome_tv_time)
    TextView mTvTime;
    /**计数器*/
    private CountDownTimer mCountDownTimer;
    /**记录是否正在登录*/
    private boolean isLogin;
    /**记录是否为监管人员*/
    private boolean mIsDepart;
    /**记录计时器是否正在运行*/
    private boolean isCountTimer;
    /**记录是否登录成功*/
    private boolean isLoginSuccess;

    /**
     * 初始化计数器
     */
    private void initCountDownTimer() {
        isCountTimer = true;
        mCountDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
//                mTvTime.setText("跳过 " + millisUntilFinished / 1000 + "s");
                mTvTime.setText(String.format(Locale.CHINA,getResources().getString(R.string.count_timer), millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                isCountTimer = false;
                startLoginOrMain();
            }
        }.start();
    }

    /**
     * 开启登录界面或者主界面
     */
    private void startLoginOrMain() {
        isCountTimer = false;
        // 取消定时器
        mCountDownTimer.cancel();

        if (!isLogin) {
            autoLogin();
        }

        if (isLoginSuccess) {
            onShowSuccess();
        } else {
            onShowFailed("");
        }
    }

    /**
     * 自动登录
     */
    private void autoLogin() {
        // 判断是否自动登录
        boolean isAutoLogin = mPresenter.getAutoLogin();
        // 获取是否为监管部门
        mIsDepart = mPresenter.getDepart();
        if (isAutoLogin) {
            isLogin = true;
            mPresenter.login(mPresenter.getUserName(), mPresenter.getPassWord(), (mIsDepart ? 1 : 0));
        }
    }

    @OnClick({R.id.welcome_tv_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.welcome_tv_time:
                startLoginOrMain();
                break;
            default:
                break;
        }
    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onShowSuccess() {
        isLoginSuccess = true;
        if (!isCountTimer) {
            // 开启主页面
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            intent.putExtra(Config.LOGIN_IS_DEPART, mIsDepart);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onShowFailed(String message) {
        isLoginSuccess = false;
        if (!isCountTimer) {
            // 开启登录页面
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            finish();
        }
    }

    @Override
    public void onShowNoNet() {
        isLoginSuccess = false;
        if (!isCountTimer) {
            Toast.makeText(this, "无网络", Toast.LENGTH_SHORT).show();
            // 开启登录页面
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            finish();
        }
    }

    @Override
    public void onRetry() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void inject(ApplicationComponent applicationComponent) {
        DaggerLoginComponent
                .builder()
                .applicationComponentImpl((ApplicationComponentImpl) applicationComponent)
                .build()
                .inject(this);
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        initCountDownTimer();
    }

    @Override
    public void initData() {
        autoLogin();
    }
}
