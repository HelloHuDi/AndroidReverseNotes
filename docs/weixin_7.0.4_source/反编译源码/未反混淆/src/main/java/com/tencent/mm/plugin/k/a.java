package com.tencent.mm.plugin.k;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

public abstract class a {
    public abstract boolean bKn();

    public abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    public abstract boolean dispatchTouchEvent(MotionEvent motionEvent);

    public abstract void onBackPressed();

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();

    public void onActivityResult(int i, int i2, Intent intent) {
    }
}
