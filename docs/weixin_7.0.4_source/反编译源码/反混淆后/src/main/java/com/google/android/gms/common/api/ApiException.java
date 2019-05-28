package com.google.android.gms.common.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ApiException extends Exception {
    protected final Status mStatus;

    public ApiException(Status status) {
        int statusCode = status.getStatusCode();
        Object statusMessage = status.getStatusMessage() != null ? status.getStatusMessage() : "";
        super(new StringBuilder(String.valueOf(statusMessage).length() + 13).append(statusCode).append(": ").append(statusMessage).toString());
        AppMethodBeat.m2504i(89441);
        this.mStatus = status;
        AppMethodBeat.m2505o(89441);
    }

    public int getStatusCode() {
        AppMethodBeat.m2504i(89442);
        int statusCode = this.mStatus.getStatusCode();
        AppMethodBeat.m2505o(89442);
        return statusCode;
    }

    @Deprecated
    public String getStatusMessage() {
        AppMethodBeat.m2504i(89443);
        String statusMessage = this.mStatus.getStatusMessage();
        AppMethodBeat.m2505o(89443);
        return statusMessage;
    }
}
