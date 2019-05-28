package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookGraphResponseException extends FacebookException {
    private final GraphResponse graphResponse;

    public FacebookGraphResponseException(GraphResponse graphResponse, String str) {
        super(str);
        this.graphResponse = graphResponse;
    }

    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    public final String toString() {
        AppMethodBeat.i(71581);
        FacebookRequestError error = this.graphResponse != null ? this.graphResponse.getError() : null;
        StringBuilder stringBuilder = new StringBuilder("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            stringBuilder.append(message);
            stringBuilder.append(" ");
        }
        if (error != null) {
            stringBuilder.append("httpResponseCode: ").append(error.getRequestStatusCode()).append(", facebookErrorCode: ").append(error.getErrorCode()).append(", facebookErrorType: ").append(error.getErrorType()).append(", message: ").append(error.getErrorMessage()).append("}");
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(71581);
        return stringBuilder2;
    }
}
