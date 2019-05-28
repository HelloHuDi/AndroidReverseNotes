package com.google.android.gms.common.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ApiException extends Exception {
    protected final Status mStatus;

    public ApiException(Status status) {
        int statusCode = status.getStatusCode();
        Object statusMessage = status.getStatusMessage() != null ? status.getStatusMessage() : "";
        super(new StringBuilder(String.valueOf(statusMessage).length() + 13).append(statusCode).append(": ").append(statusMessage).toString());
        AppMethodBeat.i(89441);
        this.mStatus = status;
        AppMethodBeat.o(89441);
    }

    public int getStatusCode() {
        AppMethodBeat.i(89442);
        int statusCode = this.mStatus.getStatusCode();
        AppMethodBeat.o(89442);
        return statusCode;
    }

    @Deprecated
    public String getStatusMessage() {
        AppMethodBeat.i(89443);
        String statusMessage = this.mStatus.getStatusMessage();
        AppMethodBeat.o(89443);
        return statusMessage;
    }
}
