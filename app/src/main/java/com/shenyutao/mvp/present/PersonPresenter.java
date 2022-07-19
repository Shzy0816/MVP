package com.shenyutao.mvp.present;

import com.shenyutao.mvp.bean.Person;
import com.shenyutao.mvp.model.PersonModel;
import com.shenyutao.mvp.model.PersonModelInterface;
import com.shenyutao.mvp.view.BaseViewInterface;
import com.shenyutao.mvp.view.PersonView;

import java.util.List;

/**
 * @author shenyutao
 */
public class PersonPresenter<T extends BaseViewInterface> {
    /**
     * 持有以及获取PersonModel对象
     */
    PersonModelInterface personModel = new PersonModel();

    /**
     * 持有View层对象
     */
    PersonView personView;

    /**
     * 构造方法中获取View层对象
     * @param view
     */
    public PersonPresenter(T view){
        personView = (PersonView) view;
    }

    /**
     * 执行业务逻辑
     */
    public void fetch(){
        if( personModel != null && personView != null){
            personModel.loadPersonData(new PersonModelInterface.OnLoadListener() {
                @Override
                public void onComplete(List<Person> persons) {
                    personView.showView(persons);
                }

                @Override
                public void onError(String message) {

                }
            });
        }
    }

}
