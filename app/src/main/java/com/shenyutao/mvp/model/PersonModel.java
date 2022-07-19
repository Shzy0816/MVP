package com.shenyutao.mvp.model;

import com.shenyutao.mvp.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenyutao
 */
public class PersonModel implements PersonModelInterface {
    /**
     * presenter层将会调用loadPersonData并注册OnLoadListener
     * 所以onLoadListener.onComplete(loadPersons())这个语句的是回调给presenter层的
     * @param onLoadListener
     */
    @Override
    public void loadPersonData(OnLoadListener onLoadListener) {
        onLoadListener.onComplete(loadPersons());
    }

    /**
     * 模拟从数据库或者云端获取数据
     * @return
     */
    private List<Person> loadPersons() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setName("user " + i);
            persons.add(person);
        }
        return persons;
    }
}
