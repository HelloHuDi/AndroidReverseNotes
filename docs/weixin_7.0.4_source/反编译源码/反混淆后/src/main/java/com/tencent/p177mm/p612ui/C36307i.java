package com.tencent.p177mm.p612ui;

import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import java.util.List;

/* renamed from: com.tencent.mm.ui.i */
public abstract class C36307i implements OnTouchListener, OnScrollListener {
    protected List<C36308a> jdb;

    /* renamed from: com.tencent.mm.ui.i$a */
    public interface C36308a {
    }

    /* renamed from: a */
    public final void mo57177a(C36308a c36308a) {
        if (!this.jdb.contains(c36308a)) {
            this.jdb.add(c36308a);
        }
    }
}
