package com.montdeska.olddaggerapp.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.montdeska.olddaggerapp.di.Injector;

import java.util.UUID;

public abstract class BaseActivity extends Activity {

    private static String INSTANCE_ID_KEY = "instance_id";
    private String instanceId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) instanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        else instanceId = UUID.randomUUID().toString();
        Injector.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(INSTANCE_ID_KEY, instanceId);
    }

    public String getInstanceId() {
        return instanceId;
    }
}
