package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginClient.Request;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Creator<KatanaProxyLoginMethodHandler> CREATOR = new C86091();

    /* renamed from: com.facebook.login.KatanaProxyLoginMethodHandler$1 */
    static class C86091 implements Creator<KatanaProxyLoginMethodHandler> {
        C86091() {
        }

        public final KatanaProxyLoginMethodHandler createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(96780);
            KatanaProxyLoginMethodHandler katanaProxyLoginMethodHandler = new KatanaProxyLoginMethodHandler(parcel);
            AppMethodBeat.m2505o(96780);
            return katanaProxyLoginMethodHandler;
        }

        public final KatanaProxyLoginMethodHandler[] newArray(int i) {
            return new KatanaProxyLoginMethodHandler[i];
        }
    }

    KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* Access modifiers changed, original: 0000 */
    public String getNameForLogging() {
        return "katana_proxy_auth";
    }

    /* Access modifiers changed, original: 0000 */
    public boolean tryAuthorize(Request request) {
        AppMethodBeat.m2504i(96783);
        String e2e = LoginClient.getE2E();
        Intent createProxyAuthIntent = NativeProtocol.createProxyAuthIntent(this.loginClient.getActivity(), request.getApplicationId(), request.getPermissions(), e2e, request.isRerequest(), request.hasPublishPermission(), request.getDefaultAudience(), getClientState(request.getAuthId()), request.getAuthType());
        addLoggingExtra("e2e", e2e);
        boolean tryIntent = tryIntent(createProxyAuthIntent, LoginClient.getLoginRequestCode());
        AppMethodBeat.m2505o(96783);
        return tryIntent;
    }

    KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(96784);
        super.writeToParcel(parcel, i);
        AppMethodBeat.m2505o(96784);
    }

    static {
        AppMethodBeat.m2504i(96785);
        AppMethodBeat.m2505o(96785);
    }
}
