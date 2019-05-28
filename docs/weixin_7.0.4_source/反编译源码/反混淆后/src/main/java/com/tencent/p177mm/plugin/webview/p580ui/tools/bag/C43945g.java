package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.g */
public interface C43945g {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.g$b */
    public interface C43944b {
        /* renamed from: iH */
        void mo56357iH(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.g$a */
    public interface C43946a {
        /* renamed from: ba */
        boolean mo26832ba(boolean z);

        /* renamed from: bg */
        void mo26833bg(float f);

        /* renamed from: l */
        void mo26834l(MotionEvent motionEvent);
    }

    /* renamed from: a */
    void mo38458a(C43946a c43946a);

    /* renamed from: a */
    void mo38459a(C43944b c43944b);

    ViewGroup bSl();

    boolean cXe();

    Activity getActivity();

    View getContentView();

    Intent getIntent();

    String getUrl();

    /* renamed from: mu */
    void mo38466mu(boolean z);
}
