package com.tencent.tinker.loader.hotplug.interceptor;

public class InterceptFailedException extends Exception {
    public InterceptFailedException(Throwable th) {
        super(th);
    }
}
