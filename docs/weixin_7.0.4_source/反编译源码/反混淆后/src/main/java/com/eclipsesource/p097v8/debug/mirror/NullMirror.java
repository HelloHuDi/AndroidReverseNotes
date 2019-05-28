package com.eclipsesource.p097v8.debug.mirror;

import com.eclipsesource.p097v8.V8Object;
import com.tencent.p177mm.loader.BuildConfig;

/* renamed from: com.eclipsesource.v8.debug.mirror.NullMirror */
public class NullMirror extends ValueMirror {
    NullMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isNull() {
        return true;
    }

    public String toString() {
        return BuildConfig.COMMAND;
    }
}
