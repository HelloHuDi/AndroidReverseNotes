package com.tencent.smtt.export.external.interfaces;

public abstract class NetworkException extends X5netException {
    public static final int ERROR_ADDRESS_UNREACHABLE = 9;
    public static final int ERROR_CONNECTION_CLOSED = 5;
    public static final int ERROR_CONNECTION_REFUSED = 7;
    public static final int ERROR_CONNECTION_RESET = 8;
    public static final int ERROR_CONNECTION_TIMED_OUT = 6;
    public static final int ERROR_HOSTNAME_NOT_RESOLVED = 1;
    public static final int ERROR_INTERNET_DISCONNECTED = 2;
    public static final int ERROR_NETWORK_CHANGED = 3;
    public static final int ERROR_OTHER = 11;
    public static final int ERROR_QUIC_PROTOCOL_FAILED = 10;
    public static final int ERROR_TIMED_OUT = 4;

    protected NetworkException(String str, Throwable th) {
        super(str, th);
    }

    public abstract int getCronetInternalErrorCode();

    public abstract int getErrorCode();

    public abstract boolean immediatelyRetryable();
}
