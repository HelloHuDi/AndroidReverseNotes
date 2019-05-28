package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;

public class UndefinedMirror extends ValueMirror {
    UndefinedMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isUndefined() {
        return true;
    }

    public String toString() {
        return "undefined";
    }
}
