package com.example.yiheng.pd_3;

import com.firebase.client.Firebase;
import android.os.Bundle;
import android.os.PersistableBundle;

public class Database extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
