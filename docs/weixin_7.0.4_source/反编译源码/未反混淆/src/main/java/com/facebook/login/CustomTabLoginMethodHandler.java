package com.facebook.login;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient.Request;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int CHALLENGE_LENGTH = 20;
    private static final String[] CHROME_PACKAGES = new String[]{"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
    public static final Creator<CustomTabLoginMethodHandler> CREATOR = new Creator() {
        public final CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
            AppMethodBeat.i(96695);
            CustomTabLoginMethodHandler customTabLoginMethodHandler = new CustomTabLoginMethodHandler(parcel);
            AppMethodBeat.o(96695);
            return customTabLoginMethodHandler;
        }

        public final CustomTabLoginMethodHandler[] newArray(int i) {
            return new CustomTabLoginMethodHandler[i];
        }
    };
    private static final String CUSTOM_TABS_SERVICE_ACTION = "android.support.customtabs.action.CustomTabsService";
    private static final int CUSTOM_TAB_REQUEST_CODE = 1;
    private String currentPackage;
    private String expectedChallenge;

    static {
        AppMethodBeat.i(96710);
        AppMethodBeat.o(96710);
    }

    CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        AppMethodBeat.i(96698);
        this.expectedChallenge = Utility.generateRandomString(20);
        AppMethodBeat.o(96698);
    }

    /* Access modifiers changed, original: 0000 */
    public String getNameForLogging() {
        return "custom_tab";
    }

    /* Access modifiers changed, original: 0000 */
    public AccessTokenSource getTokenSource() {
        return AccessTokenSource.CHROME_CUSTOM_TAB;
    }

    /* Access modifiers changed, original: protected */
    public String getSSODevice() {
        return "chrome_custom_tab";
    }

    /* Access modifiers changed, original: 0000 */
    public boolean tryAuthorize(Request request) {
        AppMethodBeat.i(96699);
        if (isCustomTabsAllowed()) {
            Bundle addExtraParameters = addExtraParameters(getParameters(request), request);
            Intent intent = new Intent(this.loginClient.getActivity(), CustomTabMainActivity.class);
            intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, addExtraParameters);
            intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, getChromePackage());
            this.loginClient.getFragment().startActivityForResult(intent, 1);
            AppMethodBeat.o(96699);
            return true;
        }
        AppMethodBeat.o(96699);
        return false;
    }

    private boolean isCustomTabsAllowed() {
        AppMethodBeat.i(96700);
        if (isCustomTabsEnabled() && getChromePackage() != null && isCustomTabsCompatibleWithAutofill() && Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext())) {
            AppMethodBeat.o(96700);
            return true;
        }
        AppMethodBeat.o(96700);
        return false;
    }

    private boolean isCustomTabsEnabled() {
        AppMethodBeat.i(96701);
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(Utility.getMetadataApplicationId(this.loginClient.getActivity()));
        if (appSettingsWithoutQuery == null || !appSettingsWithoutQuery.getCustomTabsEnabled()) {
            AppMethodBeat.o(96701);
            return false;
        }
        AppMethodBeat.o(96701);
        return true;
    }

    private String getChromePackage() {
        AppMethodBeat.i(96702);
        String str;
        if (this.currentPackage != null) {
            str = this.currentPackage;
            AppMethodBeat.o(96702);
            return str;
        }
        FragmentActivity activity = this.loginClient.getActivity();
        List<ResolveInfo> queryIntentServices = activity.getPackageManager().queryIntentServices(new Intent(CUSTOM_TABS_SERVICE_ACTION), 0);
        if (queryIntentServices != null) {
            HashSet hashSet = new HashSet(Arrays.asList(CHROME_PACKAGES));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                    this.currentPackage = serviceInfo.packageName;
                    str = this.currentPackage;
                    AppMethodBeat.o(96702);
                    return str;
                }
            }
        }
        AppMethodBeat.o(96702);
        return null;
    }

    private boolean isCustomTabsCompatibleWithAutofill() {
        AppMethodBeat.i(96703);
        if (Utility.isAutofillAvailable(this.loginClient.getActivity())) {
            AppMethodBeat.o(96703);
            return false;
        }
        AppMethodBeat.o(96703);
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(96704);
        if (i != 1) {
            boolean onActivityResult = super.onActivityResult(i, i2, intent);
            AppMethodBeat.o(96704);
            return onActivityResult;
        }
        Request pendingRequest = this.loginClient.getPendingRequest();
        if (i2 == -1) {
            onCustomTabComplete(intent.getStringExtra(CustomTabMainActivity.EXTRA_URL), pendingRequest);
            AppMethodBeat.o(96704);
            return true;
        }
        super.onComplete(pendingRequest, null, new FacebookOperationCanceledException());
        AppMethodBeat.o(96704);
        return false;
    }

    private void onCustomTabComplete(String str, Request request) {
        AppMethodBeat.i(96705);
        if (str != null && str.startsWith(CustomTabMainActivity.getRedirectUrl())) {
            Uri parse = Uri.parse(str);
            Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
            parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
            if (validateChallengeParam(parseUrlQueryString)) {
                int i;
                String string = parseUrlQueryString.getString("error");
                if (string == null) {
                    string = parseUrlQueryString.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
                }
                String string2 = parseUrlQueryString.getString("error_msg");
                if (string2 == null) {
                    string2 = parseUrlQueryString.getString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE);
                }
                if (string2 == null) {
                    string2 = parseUrlQueryString.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                }
                String string3 = parseUrlQueryString.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
                if (Utility.isNullOrEmpty(string3)) {
                    i = -1;
                } else {
                    try {
                        i = Integer.parseInt(string3);
                    } catch (NumberFormatException e) {
                        i = -1;
                    }
                }
                if (Utility.isNullOrEmpty(string) && Utility.isNullOrEmpty(string2) && i == -1) {
                    super.onComplete(request, parseUrlQueryString, null);
                    AppMethodBeat.o(96705);
                    return;
                } else if (string != null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                    super.onComplete(request, null, new FacebookOperationCanceledException());
                    AppMethodBeat.o(96705);
                    return;
                } else if (i == API_EC_DIALOG_CANCEL) {
                    super.onComplete(request, null, new FacebookOperationCanceledException());
                    AppMethodBeat.o(96705);
                    return;
                } else {
                    super.onComplete(request, null, new FacebookServiceException(new FacebookRequestError(i, string, string2), string2));
                }
            } else {
                super.onComplete(request, null, new FacebookException("Invalid state parameter"));
                AppMethodBeat.o(96705);
                return;
            }
        }
        AppMethodBeat.o(96705);
    }

    /* Access modifiers changed, original: protected */
    public void putChallengeParam(JSONObject jSONObject) {
        AppMethodBeat.i(96706);
        jSONObject.put("7_challenge", this.expectedChallenge);
        AppMethodBeat.o(96706);
    }

    private boolean validateChallengeParam(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(96707);
        try {
            String string = bundle.getString("state");
            if (string == null) {
                AppMethodBeat.o(96707);
            } else {
                z = new JSONObject(string).getString("7_challenge").equals(this.expectedChallenge);
                AppMethodBeat.o(96707);
            }
        } catch (JSONException e) {
            AppMethodBeat.o(96707);
        }
        return z;
    }

    public int describeContents() {
        return 0;
    }

    CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(96708);
        this.expectedChallenge = parcel.readString();
        AppMethodBeat.o(96708);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(96709);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.expectedChallenge);
        AppMethodBeat.o(96709);
    }
}
