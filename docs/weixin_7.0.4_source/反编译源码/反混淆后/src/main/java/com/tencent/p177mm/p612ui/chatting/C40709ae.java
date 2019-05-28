package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.ListView;

/* renamed from: com.tencent.mm.ui.chatting.ae */
public interface C40709ae {
    /* renamed from: Oq */
    void mo56960Oq(int i);

    /* renamed from: Or */
    void mo56961Or(int i);

    void aWv();

    void addHeaderView(View view);

    /* renamed from: aj */
    void mo56963aj(boolean z, boolean z2);

    /* renamed from: bY */
    void mo56966bY(int i);

    /* renamed from: c */
    void mo56967c(Context context, String str, OnCancelListener onCancelListener);

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

    /* renamed from: ho */
    void mo56980ho(int i, int i2);

    /* renamed from: qp */
    void mo56982qp(boolean z);

    boolean removeOptionMenu(int i);

    void setKeepScreenOn(boolean z);

    void showOptionMenu(int i, boolean z);

    void showOptionMenu(boolean z);

    void showVKB();

    void updateOptionMenuIcon(int i, int i2);
}
