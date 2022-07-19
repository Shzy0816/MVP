package com.shenyutao.mvp.view;

/**
 * @author shenyutao
 * 最基础的视图接口
 */
public interface BaseViewInterface {
    /**
     * 假设所有的View层类都会实现onErrorMessage方法
     */
    void onErrorMessage();
}
