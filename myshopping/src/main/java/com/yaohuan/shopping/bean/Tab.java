package com.yaohuan.shopping.bean;

/**
 * Created by yh on 2016/1/19.
 */
public class Tab {
    private int title;
    private int image;
    private Class fragmentClass;

    public Tab(int title, int image, Class fragmentClass) {
        this.title = title;
        this.image = image;
        this.fragmentClass = fragmentClass;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Class getFragmentClass() {
        return fragmentClass;
    }

    public void setFragmentClass(Class fragmentClass) {
        this.fragmentClass = fragmentClass;
    }
}
