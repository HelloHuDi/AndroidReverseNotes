package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataSourceException extends Exception {
    private final int errorCode;

    public DataSourceException(int i, String str, Throwable th) {
        super(str, th);
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String toString() {
        AppMethodBeat.i(105508);
        String str = "DataSourceException{errorCode=" + this.errorCode + "\nmessage=" + getMessage() + '}';
        AppMethodBeat.o(105508);
        return str;
    }
}
