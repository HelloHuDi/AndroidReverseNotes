package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public interface zzbp {
    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    void connect();

    void disconnect();

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t);

    <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t);

    ConnectionResult getConnectionResult(Api<?> api);

    boolean isConnected();

    boolean isConnecting();

    boolean maybeSignIn(SignInConnectionListener signInConnectionListener);

    void maybeSignOut();

    void zzz();
}
