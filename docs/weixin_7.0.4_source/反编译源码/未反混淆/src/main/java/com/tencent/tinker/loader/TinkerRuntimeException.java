package com.tencent.tinker.loader;

public class TinkerRuntimeException extends RuntimeException {
    public TinkerRuntimeException(String str) {
        super("Tinker Exception:".concat(String.valueOf(str)));
    }

    public TinkerRuntimeException(String str, Throwable th) {
        super("Tinker Exception:".concat(String.valueOf(str)), th);
    }
}
