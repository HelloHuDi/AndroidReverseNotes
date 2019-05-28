package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookServiceException extends FacebookException {
    private static final long serialVersionUID = 1;
    private final FacebookRequestError error;

    public FacebookServiceException(FacebookRequestError facebookRequestError, String str) {
        super(str);
        this.error = facebookRequestError;
    }

    public final FacebookRequestError getRequestError() {
        return this.error;
    }

    public final String toString() {
        AppMethodBeat.m2504i(71639);
        String str = "{FacebookServiceException: httpResponseCode: " + this.error.getRequestStatusCode() + ", facebookErrorCode: " + this.error.getErrorCode() + ", facebookErrorType: " + this.error.getErrorType() + ", message: " + this.error.getErrorMessage() + "}";
        AppMethodBeat.m2505o(71639);
        return str;
    }
}
