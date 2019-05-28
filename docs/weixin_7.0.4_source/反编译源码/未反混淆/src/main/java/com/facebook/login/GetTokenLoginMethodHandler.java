package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Creator<GetTokenLoginMethodHandler> CREATOR = new Creator() {
        public final GetTokenLoginMethodHandler createFromParcel(Parcel parcel) {
            AppMethodBeat.i(96770);
            GetTokenLoginMethodHandler getTokenLoginMethodHandler = new GetTokenLoginMethodHandler(parcel);
            AppMethodBeat.o(96770);
            return getTokenLoginMethodHandler;
        }

        public final GetTokenLoginMethodHandler[] newArray(int i) {
            return new GetTokenLoginMethodHandler[i];
        }
    };
    private GetTokenClient getTokenClient;

    GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* Access modifiers changed, original: 0000 */
    public String getNameForLogging() {
        return "get_token";
    }

    /* Access modifiers changed, original: 0000 */
    public void cancel() {
        AppMethodBeat.i(96773);
        if (this.getTokenClient != null) {
            this.getTokenClient.cancel();
            this.getTokenClient.setCompletedListener(null);
            this.getTokenClient = null;
        }
        AppMethodBeat.o(96773);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean tryAuthorize(final Request request) {
        AppMethodBeat.i(96774);
        this.getTokenClient = new GetTokenClient(this.loginClient.getActivity(), request.getApplicationId());
        if (this.getTokenClient.start()) {
            this.loginClient.notifyBackgroundProcessingStart();
            this.getTokenClient.setCompletedListener(new CompletedListener() {
                public void completed(Bundle bundle) {
                    AppMethodBeat.i(96767);
                    GetTokenLoginMethodHandler.this.getTokenCompleted(request, bundle);
                    AppMethodBeat.o(96767);
                }
            });
            AppMethodBeat.o(96774);
            return true;
        }
        AppMethodBeat.o(96774);
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public void getTokenCompleted(Request request, Bundle bundle) {
        AppMethodBeat.i(96775);
        if (this.getTokenClient != null) {
            this.getTokenClient.setCompletedListener(null);
        }
        this.getTokenClient = null;
        this.loginClient.notifyBackgroundProcessingStop();
        if (bundle != null) {
            ArrayList stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            Set<String> permissions = request.getPermissions();
            if (stringArrayList == null || !(permissions == null || stringArrayList.containsAll(permissions))) {
                HashSet hashSet = new HashSet();
                for (String str : permissions) {
                    if (!stringArrayList.contains(str)) {
                        hashSet.add(str);
                    }
                }
                if (!hashSet.isEmpty()) {
                    addLoggingExtra("new_permissions", TextUtils.join(",", hashSet));
                }
                request.setPermissions(hashSet);
            } else {
                complete(request, bundle);
                AppMethodBeat.o(96775);
                return;
            }
        }
        this.loginClient.tryNextHandler();
        AppMethodBeat.o(96775);
    }

    /* Access modifiers changed, original: 0000 */
    public void onComplete(Request request, Bundle bundle) {
        AppMethodBeat.i(96776);
        this.loginClient.completeAndValidate(Result.createTokenResult(this.loginClient.getPendingRequest(), LoginMethodHandler.createAccessTokenFromNativeLogin(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.getApplicationId())));
        AppMethodBeat.o(96776);
    }

    /* Access modifiers changed, original: 0000 */
    public void complete(final Request request, final Bundle bundle) {
        AppMethodBeat.i(96777);
        String string = bundle.getString(NativeProtocol.EXTRA_USER_ID);
        if (string == null || string.isEmpty()) {
            this.loginClient.notifyBackgroundProcessingStart();
            Utility.getGraphMeRequestWithCacheAsync(bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN), new GraphMeRequestWithCacheCallback() {
                public void onSuccess(JSONObject jSONObject) {
                    AppMethodBeat.i(96768);
                    try {
                        bundle.putString(NativeProtocol.EXTRA_USER_ID, jSONObject.getString("id"));
                        GetTokenLoginMethodHandler.this.onComplete(request, bundle);
                        AppMethodBeat.o(96768);
                    } catch (JSONException e) {
                        GetTokenLoginMethodHandler.this.loginClient.complete(Result.createErrorResult(GetTokenLoginMethodHandler.this.loginClient.getPendingRequest(), "Caught exception", e.getMessage()));
                        AppMethodBeat.o(96768);
                    }
                }

                public void onFailure(FacebookException facebookException) {
                    AppMethodBeat.i(96769);
                    GetTokenLoginMethodHandler.this.loginClient.complete(Result.createErrorResult(GetTokenLoginMethodHandler.this.loginClient.getPendingRequest(), "Caught exception", facebookException.getMessage()));
                    AppMethodBeat.o(96769);
                }
            });
            AppMethodBeat.o(96777);
            return;
        }
        onComplete(request, bundle);
        AppMethodBeat.o(96777);
    }

    GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(96778);
        super.writeToParcel(parcel, i);
        AppMethodBeat.o(96778);
    }

    static {
        AppMethodBeat.i(96779);
        AppMethodBeat.o(96779);
    }
}
