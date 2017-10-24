package com.example.khanhhuy.myapplication.model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by yeu_thuong on 10/24/2017.
 */

public class Book extends RealmObject {
    private int mId;
    @Ignore
    private String mTitle;
    @Ignore
    private String mAuthor;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }
}
