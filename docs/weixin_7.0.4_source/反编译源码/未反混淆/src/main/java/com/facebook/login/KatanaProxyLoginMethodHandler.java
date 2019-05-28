package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginClient.Request;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Creator<KatanaProxyLoginMethodHandler> CREATOR = new Creator<KatanaProxyLoginMethodHandler>() {
        public final KatanaProxyLoginMethodHandler createFromParcel(Parcel parcel) {
            AppMethodBeat.i(96780);
            KatanaProxyLoginMethodHandler katanaProxyLoginMethodHandler = new KatanaProxyLoginMethodHandler(parcel);
            AppMethodBeat.o(96780);
            return katanaProxyLoginMethodHandler;
        }

        public final KatanaProxyLoginMethodHandler[] newArray(int i) {
            return new KatanaProxyLoginMethodHandler[i];
        }
    };

    KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* Access modifiers changed, original: 0000 */
    public String getNameForLogging() {
        return "katana_proxy_auth";
    }

    /* Access modifiers changed, original: 0000 */
    public boolean tryAuthorize(Request request) {
        AppMethodBeat.i(96783);
        String e2e = LoginClient.getE2E();
        Intent createProxyAuthIntent = NativeProtocol.createProxyAuthIntent(this.loginClient.getActivity(), request.getApplicationId(), request.getPermissions(), e2e, request.isRerequest(), request.hasPublishPermission(), request.getDefaultAudience(), getClientState(request.getAuthId()), request.getAuthType());
        addLoggingExtra("e2e", e2e);
        boolean tryIntent = tryIntent(createProxyAuthIntent, LoginClient.getLoginRequestCode());
        AppMethodBeat.o(96783);
        return tryIntent;
    }

    KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(96784);
        super.writeToParcel(parcel, i);
        AppMethodBeat.o(96784);
    }

    static {
        AppMethodBeat.i(96785);
        AppMethodBeat.o(96785);
    }
}
