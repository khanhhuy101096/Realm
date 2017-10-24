package com.example.khanhhuy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.khanhhuy.myapplication.model.Book;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "khanhhuy.nguyen";
    private static int count = 1;
    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRealm = Realm.getDefaultInstance();
        Log.e(TAG,""+mRealm.getPath());

        addBook(mRealm);
        
        RealmResults<Book> books = getAllBook(mRealm);
        Log.e(TAG,""+books.size());
        for (int i=0; i<books.size(); i++) {
            Book book = books.get(i);
            Log.e(TAG,""+book.getId());
        }

        //updateBook(mRealm,1);
        
        deleteBook(mRealm);
    }

    private void updateBook(Realm realm, int id) {
        realm.beginTransaction();
        Book book = realm.where(Book.class).equalTo("mId",id).findFirst();
        book.setTitle("Toi thay hoa vang tren co xanh");
        book.setAuthor("Toi");
        realm.commitTransaction();
    }

    private void deleteBook(Realm realm) {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    private RealmResults<Book> getAllBook(Realm realm) {
        return realm.where(Book.class).findAll();
    }

    private void addBook(Realm realm) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Book book = realm.createObject(Book.class,count);
                book.setTitle("Hoa vang tren co xanh");
                book.setAuthor("Nguyen Nhat Anh");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }
}
