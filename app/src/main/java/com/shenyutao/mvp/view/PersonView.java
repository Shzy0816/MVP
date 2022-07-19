package com.shenyutao.mvp.view;

import com.shenyutao.mvp.bean.Person;

import java.util.List;

/**
 * @author shenytuao
 */
public interface PersonView extends BaseViewInterface{
    /**
     * 显示视图的接口方法
     * @param persons
     */
    void showView(List<Person> persons);
}
