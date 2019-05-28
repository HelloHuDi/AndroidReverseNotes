package com.eclipsesource.v8;

public class V8ResultUndefined extends V8RuntimeException {
    V8ResultUndefined(String str) {
        super(str);
    }

    V8ResultUndefined() {
    }
}
