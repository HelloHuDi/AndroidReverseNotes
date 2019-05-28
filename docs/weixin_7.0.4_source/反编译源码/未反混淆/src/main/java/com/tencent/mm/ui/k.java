package com.tencent.mm.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.widget.AbsListView;

public abstract class k {
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
