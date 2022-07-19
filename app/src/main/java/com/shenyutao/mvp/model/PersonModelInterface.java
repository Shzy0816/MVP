package com.shenyutao.mvp.model;

import com.shenyutao.mvp.bean.Person;

import java.util.List;

/**
 * @author shenyutao
 * PersonModel的功能接口
 */
public interface PersonModelInterface {
    /**
     * PersonModel实现该方法
     * present层会调用PersonModel对象实现后的loadPersonData方法，并注册回调监听
     * @param onLoadListener
     */
    void loadPersonData(OnLoadListener onLoadListener);

    interface OnLoadListener{
        /**
         * 加载完成时的回调
         * @param persons
         */
        void onComplete(List<Person> persons);

        /**
         * 加载失败时的回调
         * @param message
         */
        void onError(String message);
    }
}
