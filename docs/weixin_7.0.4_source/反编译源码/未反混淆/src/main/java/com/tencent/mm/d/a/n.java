package com.tencent.mm.d.a;

import android.text.TextUtils;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;

public abstract class n {
    private final String mKey;

    public abstract void a(l lVar, V8Object v8Object);

    public abstract void cleanup();

    public n() {
        this("");
    }

    public n(String str) {
        this.mKey = str;
    }

    /* Access modifiers changed, original: final */
    public final n a(l lVar) {
        if (TextUtils.isEmpty(this.mKey)) {
            a(lVar, lVar.CB().getGlobalObject());
        } else {
            V8Value newV8Object = lVar.CB().newV8Object();
            lVar.CB().add(this.mKey, newV8Object);
            a(lVar, newV8Object);
            newV8Object.release();
        }
        return this;
    }
}
