package com.facebook.login;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p057v4.app.DialogFragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.PermissionsPair;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient.Request;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceAuthDialog extends DialogFragment {
    private static final String DEVICE_LOGIN_ENDPOINT = "device/login";
    private static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;
    private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
    private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
    private static final String REQUEST_STATE_KEY = "request_state";
    private AtomicBoolean completed = new AtomicBoolean();
    private TextView confirmationCode;
    private volatile GraphRequestAsyncTask currentGraphRequestPoll;
    private volatile RequestState currentRequestState;
    private DeviceAuthMethodHandler deviceAuthMethodHandler;
    private Dialog dialog;
    private TextView instructions;
    private boolean isBeingDestroyed = false;
    private boolean isRetry = false;
    private Request mRequest = null;
    private View progressBar;
    private volatile ScheduledFuture scheduledPoll;

    /* renamed from: com.facebook.login.DeviceAuthDialog$5 */
    class C175975 implements OnClickListener {
        C175975() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(96715);
            DeviceAuthDialog.this.dialog.setContentView(DeviceAuthDialog.this.initializeContentView(false));
            DeviceAuthDialog.this.startLogin(DeviceAuthDialog.this.mRequest);
            AppMethodBeat.m2505o(96715);
        }
    }

    static class RequestState implements Parcelable {
        public static final Creator<RequestState> CREATOR = new C86081();
        private String authorizationUri;
        private long interval;
        private long lastPoll;
        private String requestCode;
        private String userCode;

        /* renamed from: com.facebook.login.DeviceAuthDialog$RequestState$1 */
        static class C86081 implements Creator<RequestState> {
            C86081() {
            }

            public final RequestState createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(96718);
                RequestState requestState = new RequestState(parcel);
                AppMethodBeat.m2505o(96718);
                return requestState;
            }

            public final RequestState[] newArray(int i) {
                return new RequestState[i];
            }
        }

        RequestState() {
        }

        public String getAuthorizationUri() {
            return this.authorizationUri;
        }

        public String getUserCode() {
            return this.userCode;
        }

        public void setUserCode(String str) {
            AppMethodBeat.m2504i(96721);
            this.userCode = str;
            this.authorizationUri = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", new Object[]{str});
            AppMethodBeat.m2505o(96721);
        }

        public String getRequestCode() {
            return this.requestCode;
        }

        public void setRequestCode(String str) {
            this.requestCode = str;
        }

        public long getInterval() {
            return this.interval;
        }

        public void setInterval(long j) {
            this.interval = j;
        }

        public void setLastPoll(long j) {
            this.lastPoll = j;
        }

        protected RequestState(Parcel parcel) {
            AppMethodBeat.m2504i(96722);
            this.authorizationUri = parcel.readString();
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
            AppMethodBeat.m2505o(96722);
        }

        public boolean withinLastRefreshWindow() {
            AppMethodBeat.m2504i(96723);
            if (this.lastPoll == 0) {
                AppMethodBeat.m2505o(96723);
                return false;
            } else if ((new Date().getTime() - this.lastPoll) - (this.interval * 1000) < 0) {
                AppMethodBeat.m2505o(96723);
                return true;
            } else {
                AppMethodBeat.m2505o(96723);
                return false;
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(96724);
            parcel.writeString(this.authorizationUri);
            parcel.writeString(this.userCode);
            parcel.writeString(this.requestCode);
            parcel.writeLong(this.interval);
            parcel.writeLong(this.lastPoll);
            AppMethodBeat.m2505o(96724);
        }

        static {
            AppMethodBeat.m2504i(96725);
            AppMethodBeat.m2505o(96725);
        }
    }

    /* renamed from: com.facebook.login.DeviceAuthDialog$1 */
    class C176001 implements Callback {
        C176001() {
        }

        public void onCompleted(GraphResponse graphResponse) {
            AppMethodBeat.m2504i(96711);
            if (DeviceAuthDialog.this.isBeingDestroyed) {
                AppMethodBeat.m2505o(96711);
            } else if (graphResponse.getError() != null) {
                DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                AppMethodBeat.m2505o(96711);
            } else {
                JSONObject jSONObject = graphResponse.getJSONObject();
                RequestState requestState = new RequestState();
                try {
                    requestState.setUserCode(jSONObject.getString("user_code"));
                    requestState.setRequestCode(jSONObject.getString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE));
                    requestState.setInterval(jSONObject.getLong("interval"));
                    DeviceAuthDialog.access$100(DeviceAuthDialog.this, requestState);
                    AppMethodBeat.m2505o(96711);
                } catch (JSONException e) {
                    DeviceAuthDialog.this.onError(new FacebookException(e));
                    AppMethodBeat.m2505o(96711);
                }
            }
        }
    }

    /* renamed from: com.facebook.login.DeviceAuthDialog$2 */
    class C176012 implements View.OnClickListener {
        C176012() {
        }

        public void onClick(View view) {
            AppMethodBeat.m2504i(96712);
            DeviceAuthDialog.this.onCancel();
            AppMethodBeat.m2505o(96712);
        }
    }

    /* renamed from: com.facebook.login.DeviceAuthDialog$4 */
    class C176024 implements Callback {
        C176024() {
        }

        public void onCompleted(GraphResponse graphResponse) {
            AppMethodBeat.m2504i(96714);
            if (DeviceAuthDialog.this.completed.get()) {
                AppMethodBeat.m2505o(96714);
                return;
            }
            FacebookRequestError error = graphResponse.getError();
            if (error != null) {
                switch (error.getSubErrorCode()) {
                    case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_CODE_EXPIRED /*1349152*/:
                        if (DeviceAuthDialog.this.currentRequestState != null) {
                            DeviceRequestsHelper.cleanUpAdvertisementService(DeviceAuthDialog.this.currentRequestState.getUserCode());
                        }
                        if (DeviceAuthDialog.this.mRequest != null) {
                            DeviceAuthDialog.this.startLogin(DeviceAuthDialog.this.mRequest);
                            AppMethodBeat.m2505o(96714);
                            return;
                        }
                        DeviceAuthDialog.this.onCancel();
                        AppMethodBeat.m2505o(96714);
                        return;
                    case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING /*1349172*/:
                    case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING /*1349174*/:
                        DeviceAuthDialog.access$400(DeviceAuthDialog.this);
                        AppMethodBeat.m2505o(96714);
                        return;
                    case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED /*1349173*/:
                        DeviceAuthDialog.this.onCancel();
                        AppMethodBeat.m2505o(96714);
                        return;
                    default:
                        DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                        AppMethodBeat.m2505o(96714);
                        return;
                }
            }
            try {
                JSONObject jSONObject = graphResponse.getJSONObject();
                DeviceAuthDialog.access$700(DeviceAuthDialog.this, jSONObject.getString("access_token"), Long.valueOf(jSONObject.getLong(AccessToken.EXPIRES_IN_KEY)), Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
                AppMethodBeat.m2505o(96714);
            } catch (JSONException e) {
                DeviceAuthDialog.this.onError(new FacebookException(e));
                AppMethodBeat.m2505o(96714);
            }
        }
    }

    /* renamed from: com.facebook.login.DeviceAuthDialog$3 */
    class C176033 implements Runnable {
        C176033() {
        }

        public void run() {
            AppMethodBeat.m2504i(96713);
            DeviceAuthDialog.access$200(DeviceAuthDialog.this);
            AppMethodBeat.m2505o(96713);
        }
    }

    public DeviceAuthDialog() {
        AppMethodBeat.m2504i(96726);
        AppMethodBeat.m2505o(96726);
    }

    static /* synthetic */ void access$100(DeviceAuthDialog deviceAuthDialog, RequestState requestState) {
        AppMethodBeat.m2504i(96743);
        deviceAuthDialog.setCurrentRequestState(requestState);
        AppMethodBeat.m2505o(96743);
    }

    static /* synthetic */ void access$1100(DeviceAuthDialog deviceAuthDialog, String str, PermissionsPair permissionsPair, String str2, String str3, Date date, Date date2) {
        AppMethodBeat.m2504i(96748);
        deviceAuthDialog.presentConfirmation(str, permissionsPair, str2, str3, date, date2);
        AppMethodBeat.m2505o(96748);
    }

    static /* synthetic */ void access$200(DeviceAuthDialog deviceAuthDialog) {
        AppMethodBeat.m2504i(96744);
        deviceAuthDialog.poll();
        AppMethodBeat.m2505o(96744);
    }

    static /* synthetic */ void access$400(DeviceAuthDialog deviceAuthDialog) {
        AppMethodBeat.m2504i(96745);
        deviceAuthDialog.schedulePoll();
        AppMethodBeat.m2505o(96745);
    }

    static /* synthetic */ void access$700(DeviceAuthDialog deviceAuthDialog, String str, Long l, Long l2) {
        AppMethodBeat.m2504i(96746);
        deviceAuthDialog.onSuccess(str, l, l2);
        AppMethodBeat.m2505o(96746);
    }

    static /* synthetic */ void access$900(DeviceAuthDialog deviceAuthDialog, String str, PermissionsPair permissionsPair, String str2, Date date, Date date2) {
        AppMethodBeat.m2504i(96747);
        deviceAuthDialog.completeLogin(str, permissionsPair, str2, date, date2);
        AppMethodBeat.m2505o(96747);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.m2504i(96727);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) ((LoginFragment) ((FacebookActivity) getActivity()).getCurrentFragment()).getLoginClient().getCurrentHandler();
        if (bundle != null) {
            RequestState requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY);
            if (requestState != null) {
                setCurrentRequestState(requestState);
            }
        }
        AppMethodBeat.m2505o(96727);
        return onCreateView;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.m2504i(96728);
        this.dialog = new Dialog(getActivity(), C25738R.style.f11397z8);
        boolean z = DeviceRequestsHelper.isAvailable() && !this.isRetry;
        this.dialog.setContentView(initializeContentView(z));
        Dialog dialog = this.dialog;
        AppMethodBeat.m2505o(96728);
        return dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        AppMethodBeat.m2504i(96729);
        super.onDismiss(dialogInterface);
        if (!this.isBeingDestroyed) {
            onCancel();
        }
        AppMethodBeat.m2505o(96729);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(96730);
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
        AppMethodBeat.m2505o(96730);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(96731);
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroy();
        if (this.currentGraphRequestPoll != null) {
            this.currentGraphRequestPoll.cancel(true);
        }
        if (this.scheduledPoll != null) {
            this.scheduledPoll.cancel(true);
        }
        AppMethodBeat.m2505o(96731);
    }

    public void startLogin(Request request) {
        AppMethodBeat.m2504i(96732);
        this.mRequest = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.getPermissions()));
        String deviceRedirectUriString = request.getDeviceRedirectUriString();
        if (deviceRedirectUriString != null) {
            bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, deviceRedirectUriString);
        }
        deviceRedirectUriString = request.getDeviceAuthTargetUserId();
        if (deviceRedirectUriString != null) {
            bundle.putString(DeviceRequestsHelper.DEVICE_TARGET_USER_ID, deviceRedirectUriString);
        }
        bundle.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
        bundle.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo());
        new GraphRequest(null, DEVICE_LOGIN_ENDPOINT, bundle, HttpMethod.POST, new C176001()).executeAsync();
        AppMethodBeat.m2505o(96732);
    }

    private void setCurrentRequestState(RequestState requestState) {
        AppMethodBeat.m2504i(96733);
        this.currentRequestState = requestState;
        this.confirmationCode.setText(requestState.getUserCode());
        this.instructions.setCompoundDrawablesWithIntrinsicBounds(null, new BitmapDrawable(getResources(), DeviceRequestsHelper.generateQRCode(requestState.getAuthorizationUri())), null, null);
        this.confirmationCode.setVisibility(0);
        this.progressBar.setVisibility(8);
        if (!this.isRetry && DeviceRequestsHelper.startAdvertisementService(requestState.getUserCode())) {
            AppEventsLogger.newLogger(getContext()).logSdkEvent(AnalyticsEvents.EVENT_SMART_LOGIN_SERVICE, null, null);
        }
        if (requestState.withinLastRefreshWindow()) {
            schedulePoll();
            AppMethodBeat.m2505o(96733);
            return;
        }
        poll();
        AppMethodBeat.m2505o(96733);
    }

    /* Access modifiers changed, original: protected */
    public View initializeContentView(boolean z) {
        AppMethodBeat.m2504i(96734);
        View inflate = getActivity().getLayoutInflater().inflate(getLayoutResId(z), null);
        this.progressBar = inflate.findViewById(2131821099);
        this.confirmationCode = (TextView) inflate.findViewById(2131822893);
        ((Button) inflate.findViewById(2131822895)).setOnClickListener(new C176012());
        this.instructions = (TextView) inflate.findViewById(2131822894);
        this.instructions.setText(Html.fromHtml(getString(C25738R.string.f8614u)));
        AppMethodBeat.m2505o(96734);
        return inflate;
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResId(boolean z) {
        return z ? 2130969170 : 2130969168;
    }

    private void poll() {
        AppMethodBeat.m2504i(96735);
        this.currentRequestState.setLastPoll(new Date().getTime());
        this.currentGraphRequestPoll = getPollRequest().executeAsync();
        AppMethodBeat.m2505o(96735);
    }

    private void schedulePoll() {
        AppMethodBeat.m2504i(96736);
        this.scheduledPoll = DeviceAuthMethodHandler.getBackgroundExecutor().schedule(new C176033(), this.currentRequestState.getInterval(), TimeUnit.SECONDS);
        AppMethodBeat.m2505o(96736);
    }

    private GraphRequest getPollRequest() {
        AppMethodBeat.m2504i(96737);
        Bundle bundle = new Bundle();
        bundle.putString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.currentRequestState.getRequestCode());
        GraphRequest graphRequest = new GraphRequest(null, DEVICE_LOGIN_STATUS_ENDPOINT, bundle, HttpMethod.POST, new C176024());
        AppMethodBeat.m2505o(96737);
        return graphRequest;
    }

    private void presentConfirmation(String str, PermissionsPair permissionsPair, String str2, String str3, Date date, Date date2) {
        AppMethodBeat.m2504i(96738);
        String string = getResources().getString(C25738R.string.f8631ae);
        String string2 = getResources().getString(C25738R.string.f8630ad);
        String string3 = getResources().getString(C25738R.string.f8629ac);
        String format = String.format(string2, new Object[]{str3});
        Builder builder = new Builder(getContext());
        final String str4 = str;
        final PermissionsPair permissionsPair2 = permissionsPair;
        final String str5 = str2;
        final Date date3 = date;
        final Date date4 = date2;
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(96716);
                DeviceAuthDialog.access$900(DeviceAuthDialog.this, str4, permissionsPair2, str5, date3, date4);
                AppMethodBeat.m2505o(96716);
            }
        }).setPositiveButton(string3, new C175975());
        builder.create().show();
        AppMethodBeat.m2505o(96738);
    }

    private void onSuccess(final String str, Long l, Long l2) {
        AppMethodBeat.m2504i(96739);
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,permissions,name");
        final Date date = l.longValue() != 0 ? new Date(new Date().getTime() + (l.longValue() * 1000)) : null;
        final Date date2 = (l2.longValue() == 0 || l2 == null) ? null : new Date(l2.longValue() * 1000);
        new GraphRequest(new AccessToken(str, FacebookSdk.getApplicationId(), AppEventsConstants.EVENT_PARAM_VALUE_NO, null, null, null, date, null, date2), "me", bundle, HttpMethod.GET, new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.m2504i(96717);
                if (DeviceAuthDialog.this.completed.get()) {
                    AppMethodBeat.m2505o(96717);
                } else if (graphResponse.getError() != null) {
                    DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                    AppMethodBeat.m2505o(96717);
                } else {
                    try {
                        JSONObject jSONObject = graphResponse.getJSONObject();
                        String string = jSONObject.getString("id");
                        PermissionsPair handlePermissionResponse = Utility.handlePermissionResponse(jSONObject);
                        String string2 = jSONObject.getString("name");
                        DeviceRequestsHelper.cleanUpAdvertisementService(DeviceAuthDialog.this.currentRequestState.getUserCode());
                        if (!FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.RequireConfirm) || DeviceAuthDialog.this.isRetry) {
                            DeviceAuthDialog.access$900(DeviceAuthDialog.this, string, handlePermissionResponse, str, date, date2);
                            AppMethodBeat.m2505o(96717);
                            return;
                        }
                        DeviceAuthDialog.this.isRetry = true;
                        DeviceAuthDialog.access$1100(DeviceAuthDialog.this, string, handlePermissionResponse, str, string2, date, date2);
                        AppMethodBeat.m2505o(96717);
                    } catch (JSONException e) {
                        DeviceAuthDialog.this.onError(new FacebookException(e));
                        AppMethodBeat.m2505o(96717);
                    }
                }
            }
        }).executeAsync();
        AppMethodBeat.m2505o(96739);
    }

    private void completeLogin(String str, PermissionsPair permissionsPair, String str2, Date date, Date date2) {
        AppMethodBeat.m2504i(96740);
        this.deviceAuthMethodHandler.onSuccess(str2, FacebookSdk.getApplicationId(), str, permissionsPair.getGrantedPermissions(), permissionsPair.getDeclinedPermissions(), AccessTokenSource.DEVICE_AUTH, date, null, date2);
        this.dialog.dismiss();
        AppMethodBeat.m2505o(96740);
    }

    /* Access modifiers changed, original: protected */
    public void onError(FacebookException facebookException) {
        AppMethodBeat.m2504i(96741);
        if (this.completed.compareAndSet(false, true)) {
            if (this.currentRequestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
            }
            this.deviceAuthMethodHandler.onError(facebookException);
            this.dialog.dismiss();
            AppMethodBeat.m2505o(96741);
            return;
        }
        AppMethodBeat.m2505o(96741);
    }

    /* Access modifiers changed, original: protected */
    public void onCancel() {
        AppMethodBeat.m2504i(96742);
        if (this.completed.compareAndSet(false, true)) {
            if (this.currentRequestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
            }
            if (this.deviceAuthMethodHandler != null) {
                this.deviceAuthMethodHandler.onCancel();
            }
            this.dialog.dismiss();
            AppMethodBeat.m2505o(96742);
            return;
        }
        AppMethodBeat.m2505o(96742);
    }
}
