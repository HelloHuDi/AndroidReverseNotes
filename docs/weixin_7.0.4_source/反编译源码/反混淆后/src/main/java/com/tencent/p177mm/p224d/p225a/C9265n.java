package com.tencent.p177mm.p224d.p225a;

import android.text.TextUtils;
import com.eclipsesource.p097v8.V8Object;
import com.eclipsesource.p097v8.V8Value;

/* renamed from: com.tencent.mm.d.a.n */
public abstract class C9265n {
    private final String mKey;

    /* renamed from: a */
    public abstract void mo4940a(C32488l c32488l, V8Object v8Object);

    public abstract void cleanup();

    public C9265n() {
        this("");
    }

    public C9265n(String str) {
        this.mKey = str;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C9265n mo20687a(C32488l c32488l) {
        if (TextUtils.isEmpty(this.mKey)) {
            mo4940a(c32488l, c32488l.mo53119CB().getGlobalObject());
        } else {
            V8Value newV8Object = c32488l.mo53119CB().newV8Object();
            c32488l.mo53119CB().add(this.mKey, newV8Object);
            mo4940a(c32488l, newV8Object);
            newV8Object.release();
        }
        return this;
    }
}
