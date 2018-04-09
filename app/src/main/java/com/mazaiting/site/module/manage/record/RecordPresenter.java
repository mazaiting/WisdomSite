package com.mazaiting.site.module.manage.record;

import com.mazaiting.easy.base.presenter.BasePresenter;
import com.mazaiting.site.module.bean.Record;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * 记录 主持
 *
 * @author mazaiting
 * @date 2018/3/22
 */

public class RecordPresenter extends BasePresenter<RecordContract.View> implements RecordContract.Presenter {
    @Inject
    RecordPresenter() {}

    @Override
    public void loadData() {
        mView.onShowLoading();
        List<Record> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Record record = new Record();
            record.setLabelId("#123"+i);
            record.setEquipId("#qerw12"+i);
            record.setEntryTime("3月"+i+"日");
            list.add(record);
        }
        mView.onShowSuccess();
        mView.setData(list);
    }

    @Override
    public void loadMoreData() {
        mView.onShowLoading();
        List<Record> list = new ArrayList<>();
        for (int i = 20; i < 40; i++) {
            Record record = new Record();
            record.setLabelId("#123"+i);
            record.setEquipId("#qerw12"+i);
            record.setEntryTime("3月"+i+"日");
            list.add(record);
        }
        mView.onShowSuccess();
        mView.addData(list);
    }
}
