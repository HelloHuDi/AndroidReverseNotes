package com.tencent.mm.ui;

import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import java.util.List;

public abstract class i implements OnTouchListener, OnScrollListener {
    protected List<a> jdb;

    public interface a {
    }

    public final void a(a aVar) {
        if (!this.jdb.contains(aVar)) {
            this.jdb.add(aVar);
        }
    }
}
