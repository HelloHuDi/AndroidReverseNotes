package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;

public interface c<VH extends v> {
    boolean O(VH vh);

    boolean P(VH vh);

    boolean R(VH vh);

    void a(RecyclerView recyclerView, VH vh, int i, Runnable runnable);

    void a(View view, float f, float f2, v vVar, int i);

    boolean a(RecyclerView recyclerView, VH vh, VH vh2, int i, int i2);

    View d(RecyclerView recyclerView, VH vh);

    void e(RecyclerView recyclerView, VH vh);

    void m(RecyclerView recyclerView);
}
