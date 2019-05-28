package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.ListView;

public interface ae {
    void Oq(int i);

    void Or(int i);

    void aWv();

    void addHeaderView(View view);

    void aj(boolean z, boolean z2);

    void bY(int i);

    void c(Context context, String str, OnCancelListener onCancelListener);

    void dCC();

    void dCD();

    void dCx();

    void dCy();

    void dismissDialog();

    View getChildAt(int i);

    int getFirstVisiblePosition();

    int getHeaderViewsCount();

    int getLastVisiblePosition();

    ListView getListView();

    boolean hideVKB();

    void ho(int i, int i2);

    void qp(boolean z);

    boolean removeOptionMenu(int i);

    void setKeepScreenOn(boolean z);

    void showOptionMenu(int i, boolean z);

    void showOptionMenu(boolean z);

    void showVKB();

    void updateOptionMenuIcon(int i, int i2);
}
