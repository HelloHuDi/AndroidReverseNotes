package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.ViewGroup;

abstract class u<_Data, _ViewHolder extends v> {
    public abstract _ViewHolder a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public abstract long bA(_Data _data);

    public abstract void c(_ViewHolder _viewholder, _Data _data);

    u() {
    }

    public boolean b(_ViewHolder _viewholder, Object obj) {
        return false;
    }
}
