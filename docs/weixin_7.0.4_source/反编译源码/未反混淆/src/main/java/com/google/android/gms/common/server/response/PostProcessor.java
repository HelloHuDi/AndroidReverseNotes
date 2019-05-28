package com.google.android.gms.common.server.response;

public interface PostProcessor<T extends FastJsonResponse> {
    T postProcess(T t);
}
