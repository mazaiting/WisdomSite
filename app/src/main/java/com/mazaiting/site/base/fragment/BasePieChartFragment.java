package com.mazaiting.site.base.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.mazaiting.site.R;
import com.mazaiting.site.base.config.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * 基类饼状图 Fragment
 *
 * @author mazaiting
 * @date 2018/3/23
 */

public abstract class BasePieChartFragment extends Fragment {
    /**
     * 饼图
     */
    private PieChart mPieChart;
    /**
     * 字体
     */
    private Typeface mTypeface;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        mPieChart = view.findViewById(R.id.pie_chart);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
        setListener();
    }

    /**
     * 设置监听
     */
    private void setListener() {
        // 设置值选择监听
        mPieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {}

            @Override
            public void onNothingSelected() {}
        });
        // 长按监听
        mPieChart.setOnLongClickListener(v -> {
            // 长按保存
            mPieChart.saveToGallery(System.currentTimeMillis() + ".jpg", 100);
            Toast.makeText(getActivity(), "保存图片成功", Toast.LENGTH_SHORT).show();
            return true;
        });
    }

    /**
     * 初始化View
     */
    private void initView() {
        // 获取字体
        mTypeface = Typeface.createFromAsset(getActivity().getAssets(), Config.OPEN_SANS_REGULAR);
        // 设置使用百分比
        mPieChart.setUsePercentValues(true);
        // 设置描述不可用
        mPieChart.getDescription().setEnabled(false);
        // 设置偏移
        mPieChart.setExtraOffsets(5, 10, 5, 5);
        // 设置拖拽摩擦系数
        mPieChart.setDragDecelerationFrictionCoef(0.95f);
        // 设置中心文本字体
        mPieChart.setCenterTextTypeface(Typeface.createFromAsset(getActivity().getAssets(), Config.OPEN_SANS_LIGHT));
        // 设置中心文本
        mPieChart.setCenterText(generateCenterSpannableText());
        // 设置偏移
        mPieChart.setExtraOffsets(20f, 0f, 20f, 0f);
        // 设置绘制洞可用
        mPieChart.setDrawHoleEnabled(true);
        // 绘制洞的颜色
        mPieChart.setHoleColor(Color.WHITE);
        // 设置透明圆颜色
        mPieChart.setTransparentCircleColor(Color.WHITE);
        // 设置透明圆透明度
        mPieChart.setTransparentCircleAlpha(110);
        // 设置洞的半径
        mPieChart.setHoleRadius(58f);
        // 设置透明圆半径
        mPieChart.setTransparentCircleRadius(61f);
        // 设置绘制中心文本
        mPieChart.setDrawCenterText(true);
        // 设置旋转角度
        mPieChart.setRotationAngle(0f);
        // 设置旋转可用
        mPieChart.setRotationEnabled(true);
        // 设置选择时高亮提示
        mPieChart.setHighlightPerTapEnabled(true);
        // 设置数据
        setData();
        // 设置Y轴动画
        mPieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // 图例
        Legend legend = mPieChart.getLegend();
        // 设置垂直方向
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        // 设置水平方向
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        // 设置方向
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        // 设置绘制位置
        legend.setDrawInside(false);
        // 设置是否可用
        legend.setEnabled(true);
    }


    /**
     * 设置数据
     */
    private void setData() {
        // 创建列表
        List<PieEntry> entries = new ArrayList<>();
        addData(entries);
        // 设置饼图数据
        PieDataSet dataSet = new PieDataSet(entries, setPieDataLabel());
        // 设置每份之间的间隔
        dataSet.setSliceSpace(3f);
        // 设置选择后放大的比例
        dataSet.setSelectionShift(5f);

        // 添加颜色
        List<Integer> colors = new ArrayList<>();
        // 添加颜色
        for (int c : ColorTemplate.MATERIAL_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.COLORFUL_COLORS) {
            colors.add(c);
        }
        // 设置颜色
        dataSet.setColors(colors);
        // 设置在饼图上的线段长度偏移百分比
        dataSet.setValueLinePart1OffsetPercentage(80f);
        // 设置在饼图上的线段1长度
        dataSet.setValueLinePart1Length(0.2f);
        // 设置在饼图上的线段线区域2长度
        dataSet.setValueLinePart2Length(0.4f);
        // 设置Y值位置
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        // 饼数据
        PieData data = new PieData(dataSet);
        // 设置值格式
        data.setValueFormatter(new PercentFormatter());
        // 设置文字大小
        data.setValueTextSize(11f);
        // 设置文字颜色
        data.setValueTextColor(Color.BLACK);
        // 设置值的字体
        data.setValueTypeface(mTypeface);
        // 设置数据
        mPieChart.setData(data);
        // 取消高亮
        mPieChart.highlightValues(null);
        // 更新数据
        mPieChart.invalidate();
    }

    /**
     * 获取多风格文本
     *
     * @return 多风格字符串
     */
    private SpannableString generateCenterSpannableText() {
//        SpannableString s = new SpannableString("MPAndroidChart\ndeveloped by Philipp Jahoda");
//        s.setSpan(new RelativeSizeSpan(1.5f), 0, 14, 0);
//        s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
//        s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
//        s.setSpan(new RelativeSizeSpan(.65f), 14, s.length() - 15, 0);
//        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
//        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return new SpannableString("考勤");
    }

    /**
     * 设置图例标题
     *
     * @return 图例标题
     */
    protected abstract String setPieDataLabel();

    /**
     * 添加数据
     *
     * @param entries 添加数据的列表
     */
    protected abstract void addData(List<PieEntry> entries);
}
