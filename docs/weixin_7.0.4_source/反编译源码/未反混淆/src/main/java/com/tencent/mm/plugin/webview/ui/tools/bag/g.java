package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public interface g {

    public interface b {
        void iH(boolean z);
    }

    public interface a {
        boolean ba(boolean z);

        void bg(float f);

        void l(MotionEvent motionEvent);
    }

    void a(a aVar);

    void a(b bVar);

    ViewGroup bSl();

    boolean cXe();

    Activity getActivity();

    View getContentView();

    Intent getIntent();

    String getUrl();

    void mu(boolean z);
}
