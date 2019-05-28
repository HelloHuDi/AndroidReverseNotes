package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginClient.Request;
import com.tencent.matrix.trace.core.AppMethodBeat;

class FacebookLiteLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Creator<FacebookLiteLoginMethodHandler> CREATOR = new Creator<FacebookLiteLoginMethodHandler>() {
        public final FacebookLiteLoginMethodHandler createFromParcel(Parcel parcel) {
            AppMethodBeat.i(96761);
            FacebookLiteLoginMethodHandler facebookLiteLoginMethodHandler = new FacebookLiteLoginMethodHandler(parcel);
            AppMethodBeat.o(96761);
            return facebookLiteLoginMethodHandler;
        }

        public final FacebookLiteLoginMethodHandler[] newArray(int i) {
            return new FacebookLiteLoginMethodHandler[i];
        }
    };

    FacebookLiteLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* Access modifiers changed, original: 0000 */
    public String getNameForLogging() {
        return "fb_lite_login";
    }

    /* Access modifiers changed, original: 0000 */
    public boolean tryAuthorize(Request request) {
        AppMethodBeat.i(96764);
        String e2e = LoginClient.getE2E();
        Intent createFacebookLiteIntent = NativeProtocol.createFacebookLiteIntent(this.loginClient.getActivity(), request.getApplicationId(), request.getPermissions(), e2e, request.isRerequest(), request.hasPublishPermission(), request.getDefaultAudience(), getClientState(request.getAuthId()), request.getAuthType());
        addLoggingExtra("e2e", e2e);
        boolean tryIntent = tryIntent(createFacebookLiteIntent, LoginClient.getLoginRequestCode());
        AppMethodBeat.o(96764);
        return tryIntent;
    }

    FacebookLiteLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(96765);
        super.writeToParcel(parcel, i);
        AppMethodBeat.o(96765);
    }

    static {
        AppMethodBeat.i(96766);
        AppMethodBeat.o(96766);
    }
}
