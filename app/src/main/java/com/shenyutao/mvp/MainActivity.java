package com.shenyutao.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shenyutao.mvp.bean.Person;
import com.shenyutao.mvp.databinding.ActivityMainBinding;
import com.shenyutao.mvp.present.PersonPresenter;
import com.shenyutao.mvp.view.PersonView;

import java.util.List;

/**
 * @author shenyutao
 * 该份代码主要展示了MVP模式的实现方式
 * View层负责显示
 * Model层负责加载数据(从云端或者数据库)
 * present层同时持有view层和model层接口，并负责将model层获取到的数据传给view层
 * 而其中的回调关系是 ：
 * 1.view层在present层注册回调 ， present层再到model层注册回调
 * 2.model层拿到数据后回调给present层 ， present再将数据回调给view层
 * 用流程概括就是:
 * 1. view ----(注册回调监听)----> present ----(注册回调监听)----> model
 * 2. view <----(回调数据)---- present <----(回调数据)---- model
 */
public class MainActivity extends AppCompatActivity implements PersonView {
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        PersonPresenter<MainActivity> personPresenter = new PersonPresenter<>(this);
        personPresenter.fetch();
    }

    @Override
    public void showView(List<Person> persons) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : persons) {
            stringBuilder.append(person.getName());
            stringBuilder.append("\n");
        }
        activityMainBinding.textView.setText(stringBuilder.toString());
    }

    /**
     * 这个方法可以用适配器模式隐藏
     */
    @Override
    public void onErrorMessage() {

    }
}