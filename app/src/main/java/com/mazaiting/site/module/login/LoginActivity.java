package com.mazaiting.site.module.login;

import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.mazaiting.easy.app.ApplicationComponent;
import com.mazaiting.site.R;
import com.mazaiting.site.base.activity.BaseLoadingActivity;
import com.mazaiting.site.base.component.ApplicationComponentImpl;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.module.main.MainActivity;
import com.mazaiting.widget.fragment.PnDialogFragment;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录界面
 *
 * @author mazaiting
 */
public class LoginActivity extends BaseLoadingActivity<LoginPresenter> implements LoginContract.View {
    /**用户名输入框*/
    @BindView(R.id.login_et_username)
    EditText mEtUsername;
    /**密码输入框*/
    @BindView(R.id.login_et_password)
    EditText mEtPassword;
    /**自动登录复选框*/
    @BindView(R.id.login_cb_auto_login)
    CheckBox mCbAutoLogin;
    /**监管部门复选框*/
    @BindView(R.id.login_cb_depart)
    CheckBox mCbDepart;
    /**用户名*/
    private String mUserName;
    /**密码*/
    private String mPassWord;
    /**是否为监管部门*/
    private boolean mIsDepart;

    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
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
    public void initData() {
        // 初始化数据
        // 设置用户名和密码及复选框状态
        mUserName = mPresenter.getUserName();
        mPassWord = mPresenter.getPassWord();
        Logger.e(mUserName + ": " + mPassWord);
        boolean isAutoLogin = mPresenter.getAutoLogin();
        mIsDepart = mPresenter.getDepart();
        // 设置控件属性
        mEtUsername.setText(mUserName);
        mEtPassword.setText(mPassWord);
        mCbAutoLogin.setChecked(isAutoLogin);
        mCbDepart.setChecked(mIsDepart);
        mEtUsername.setSelection(mUserName.length());
    }

    @Override
    public void onShowFailed(String message) {
        super.onShowFailed(message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.login_btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_btn_login:
                login();
                break;
            default:
                break;
        }
    }

    /**
     * 登录
     */
    private void login() {
        // 获取用户名
        mUserName = mEtUsername.getText().toString();
        // 获取密码
        mPassWord = mEtPassword.getText().toString();
        // 获取是否为监管部门
        mIsDepart = mCbDepart.isChecked();
        // 检测用户名是否合法
        if (TextUtils.isEmpty(mUserName)) {
            Toast.makeText(this, "用户名不能为空，请输入用户名!", Toast.LENGTH_SHORT).show();
            return;
        }
        // 检测密码是否合法
        if (TextUtils.isEmpty(mPassWord)) {
            Toast.makeText(this, "密码不能为空，请输入密码!", Toast.LENGTH_SHORT).show();
            return;
        }
        // 登录
        mPresenter.login(mUserName, mPassWord, (mIsDepart ? 1 : 0));
    }

    @Override
    public void update() {
        // 检测是否保存用户名
        boolean isAutoLogin = mCbAutoLogin.isChecked();
        // 如果为true，则保存用户名和密码
        if (isAutoLogin) {
            mPresenter.saveUserNameAndPassWord(mUserName, mPassWord);
            mPresenter.saveAutoLogin(true);
        }

        // 检测是否是监管部门
        boolean isDepart = mCbDepart.isChecked();
        // 判断是否为监管部门
        if (isDepart) {
            mPresenter.saveDepart(true);
        }
        // 开启主页面
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra(Config.LOGIN_IS_DEPART, isDepart);
        startActivity(intent);
        finish();
    }

    @Override
    public void onShowNoNet() {
        super.onShowNoNet();
    }
}
