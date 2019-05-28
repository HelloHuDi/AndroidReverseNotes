package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.h */
final class C40979h extends Thread {
    /* renamed from: a */
    final /* synthetic */ Context f16302a;
    /* renamed from: b */
    final /* synthetic */ String f16303b;
    /* renamed from: c */
    final /* synthetic */ ValueCallback f16304c;

    C40979h(Context context, String str, ValueCallback valueCallback) {
        this.f16302a = context;
        this.f16303b = str;
        this.f16304c = valueCallback;
    }

    public final void run() {
        AppMethodBeat.m2504i(63986);
        C40978bv a = C40978bv.m71073a();
        a.mo64920a(this.f16302a, null);
        boolean z = false;
        if (a.mo64921b()) {
            z = a.mo64922c().mo57569a(this.f16302a, this.f16303b);
        }
        new Handler(Looper.getMainLooper()).post(new C44457i(this, z));
        AppMethodBeat.m2505o(63986);
    }
}
