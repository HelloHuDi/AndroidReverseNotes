package com.tencent.smtt.utils;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.d.a;

class e implements a {
    final /* synthetic */ WebView a;
    final /* synthetic */ Context b;
    final /* synthetic */ RelativeLayout c;
    final /* synthetic */ String d;
    final /* synthetic */ TextView e;
    final /* synthetic */ d f;

    e(d dVar, WebView webView, Context context, RelativeLayout relativeLayout, String str, TextView textView) {
        this.f = dVar;
        this.a = webView;
        this.b = context;
        this.c = relativeLayout;
        this.d = str;
        this.e = textView;
    }

    public void a() {
        AppMethodBeat.i(65200);
        this.a.post(new f(this));
        AppMethodBeat.o(65200);
    }

    public void a(int i) {
        AppMethodBeat.i(65201);
        this.a.post(new g(this, i));
        AppMethodBeat.o(65201);
    }

    public void a(Throwable th) {
        AppMethodBeat.i(65202);
        this.a.post(new h(this));
        AppMethodBeat.o(65202);
    }
}
