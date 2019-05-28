package com.tencent.smtt.utils;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.C44458d.C36444a;

/* renamed from: com.tencent.smtt.utils.e */
class C44459e implements C36444a {
    /* renamed from: a */
    final /* synthetic */ WebView f17309a;
    /* renamed from: b */
    final /* synthetic */ Context f17310b;
    /* renamed from: c */
    final /* synthetic */ RelativeLayout f17311c;
    /* renamed from: d */
    final /* synthetic */ String f17312d;
    /* renamed from: e */
    final /* synthetic */ TextView f17313e;
    /* renamed from: f */
    final /* synthetic */ C44458d f17314f;

    C44459e(C44458d c44458d, WebView webView, Context context, RelativeLayout relativeLayout, String str, TextView textView) {
        this.f17314f = c44458d;
        this.f17309a = webView;
        this.f17310b = context;
        this.f17311c = relativeLayout;
        this.f17312d = str;
        this.f17313e = textView;
    }

    /* renamed from: a */
    public void mo57628a() {
        AppMethodBeat.m2504i(65200);
        this.f17309a.post(new C44460f(this));
        AppMethodBeat.m2505o(65200);
    }

    /* renamed from: a */
    public void mo57629a(int i) {
        AppMethodBeat.m2504i(65201);
        this.f17309a.post(new C44461g(this, i));
        AppMethodBeat.m2505o(65201);
    }

    /* renamed from: a */
    public void mo57630a(Throwable th) {
        AppMethodBeat.m2504i(65202);
        this.f17309a.post(new C24274h(this));
        AppMethodBeat.m2505o(65202);
    }
}
