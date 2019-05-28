package com.facebook.login;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.R;
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

    static class RequestState implements Parcelable {
        public static final Creator<RequestState> CREATOR = new Creator<RequestState>() {
            public final RequestState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(96718);
                RequestState requestState = new RequestState(parcel);
                AppMethodBeat.o(96718);
                return requestState;
            }

            public final RequestState[] newArray(int i) {
                return new RequestState[i];
            }
        };
        private String authorizationUri;
        private long interval;
        private long lastPoll;
        private String requestCode;
        private String userCode;

        RequestState() {
        }

        public String getAuthorizationUri() {
            return this.authorizationUri;
        }

        public String getUserCode() {
            return this.userCode;
        }

        public void setUserCode(String str) {
            AppMethodBeat.i(96721);
            this.userCode = str;
            this.authorizationUri = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", new Object[]{str});
            AppMethodBeat.o(96721);
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
            AppMethodBeat.i(96722);
            this.authorizationUri = parcel.readString();
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
            AppMethodBeat.o(96722);
        }

        public boolean withinLastRefreshWindow() {
            AppMethodBeat.i(96723);
            if (this.lastPoll == 0) {
                AppMethodBeat.o(96723);
                return false;
            } else if ((new Date().getTime() - this.lastPoll) - (this.interval * 1000) < 0) {
                AppMethodBeat.o(96723);
                return true;
            } else {
                AppMethodBeat.o(96723);
                return false;
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(96724);
            parcel.writeString(this.authorizationUri);
            parcel.writeString(this.userCode);
            parcel.writeString(this.requestCode);
            parcel.writeLong(this.interval);
            parcel.writeLong(this.lastPoll);
            AppMethodBeat.o(96724);
        }

        static {
            AppMethodBeat.i(96725);
            AppMethodBeat.o(96725);
        }
    }

    public DeviceAuthDialog() {
        AppMethodBeat.i(96726);
        AppMethodBeat.o(96726);
    }

    static /* synthetic */ void access$100(DeviceAuthDialog deviceAuthDialog, RequestState requestState) {
        AppMethodBeat.i(96743);
        deviceAuthDialog.setCurrentRequestState(requestState);
        AppMethodBeat.o(96743);
    }

    static /* synthetic */ void access$1100(DeviceAuthDialog deviceAuthDialog, String str, PermissionsPair permissionsPair, String str2, String str3, Date date, Date date2) {
        AppMethodBeat.i(96748);
        deviceAuthDialog.presentConfirmation(str, permissionsPair, str2, str3, date, date2);
        AppMethodBeat.o(96748);
    }

    static /* synthetic */ void access$200(DeviceAuthDialog deviceAuthDialog) {
        AppMethodBeat.i(96744);
        deviceAuthDialog.poll();
        AppMethodBeat.o(96744);
    }

    static /* synthetic */ void access$400(DeviceAuthDialog deviceAuthDialog) {
        AppMethodBeat.i(96745);
        deviceAuthDialog.schedulePoll();
        AppMethodBeat.o(96745);
    }

    static /* synthetic */ void access$700(DeviceAuthDialog deviceAuthDialog, String str, Long l, Long l2) {
        AppMethodBeat.i(96746);
        deviceAuthDialog.onSuccess(str, l, l2);
        AppMethodBeat.o(96746);
    }

    static /* synthetic */ void access$900(DeviceAuthDialog deviceAuthDialog, String str, PermissionsPair permissionsPair, String str2, Date date, Date date2) {
        AppMethodBeat.i(96747);
        deviceAuthDialog.completeLogin(str, permissionsPair, str2, date, date2);
        AppMethodBeat.o(96747);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(96727);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) ((LoginFragment) ((FacebookActivity) getActivity()).getCurrentFragment()).getLoginClient().getCurrentHandler();
        if (bundle != null) {
            RequestState requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY);
            if (requestState != null) {
                setCurrentRequestState(requestState);
            }
        }
        AppMethodBeat.o(96727);
        return onCreateView;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.i(96728);
        this.dialog = new Dialog(getActivity(), R.style.z8);
        boolean z = DeviceRequestsHelper.isAvailable() && !this.isRetry;
        this.dialog.setContentView(initializeContentView(z));
        Dialog dialog = this.dialog;
        AppMethodBeat.o(96728);
        return dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        AppMethodBeat.i(96729);
        super.onDismiss(dialogInterface);
        if (!this.isBeingDestroyed) {
            onCancel();
        }
        AppMethodBeat.o(96729);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(96730);
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
        AppMethodBeat.o(96730);
    }

    public void onDestroy() {
        AppMethodBeat.i(96731);
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroy();
        if (this.currentGraphRequestPoll != null) {
            this.currentGraphRequestPoll.cancel(true);
        }
        if (this.scheduledPoll != null) {
            this.scheduledPoll.cancel(true);
        }
        AppMethodBeat.o(96731);
    }

    public void startLogin(Request request) {
        AppMethodBeat.i(96732);
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
        new GraphRequest(null, DEVICE_LOGIN_ENDPOINT, bundle, HttpMethod.POST, new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(96711);
                if (DeviceAuthDialog.this.isBeingDestroyed) {
                    AppMethodBeat.o(96711);
                } else if (graphResponse.getError() != null) {
                    DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                    AppMethodBeat.o(96711);
                } else {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    RequestState requestState = new RequestState();
                    try {
                        requestState.setUserCode(jSONObject.getString("user_code"));
                        requestState.setRequestCode(jSONObject.getString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE));
                        requestState.setInterval(jSONObject.getLong("interval"));
                        DeviceAuthDialog.access$100(DeviceAuthDialog.this, requestState);
                        AppMethodBeat.o(96711);
                    } catch (JSONException e) {
                        DeviceAuthDialog.this.onError(new FacebookException(e));
                        AppMethodBeat.o(96711);
                    }
                }
            }
        }).executeAsync();
        AppMethodBeat.o(96732);
    }

    private void setCurrentRequestState(RequestState requestState) {
        AppMethodBeat.i(96733);
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
            AppMethodBeat.o(96733);
            return;
        }
        poll();
        AppMethodBeat.o(96733);
    }

    /* Access modifiers changed, original: protected */
    public View initializeContentView(boolean z) {
        AppMethodBeat.i(96734);
        View inflate = getActivity().getLayoutInflater().inflate(getLayoutResId(z), null);
        this.progressBar = inflate.findViewById(R.id.oa);
        this.confirmationCode = (TextView) inflate.findViewById(R.id.azh);
        ((Button) inflate.findViewById(R.id.azj)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AppMethodBeat.i(96712);
                DeviceAuthDialog.this.onCancel();
                AppMethodBeat.o(96712);
            }
        });
        this.instructions = (TextView) inflate.findViewById(R.id.azi);
        this.instructions.setText(Html.fromHtml(getString(R.string.u)));
        AppMethodBeat.o(96734);
        return inflate;
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResId(boolean z) {
        return z ? R.layout.pa : R.layout.p9;
    }

    private void poll() {
        AppMethodBeat.i(96735);
        this.currentRequestState.setLastPoll(new Date().getTime());
        this.currentGraphRequestPoll = getPollRequest().executeAsync();
        AppMethodBeat.o(96735);
    }

    private void schedulePoll() {
        AppMethodBeat.i(96736);
        this.scheduledPoll = DeviceAuthMethodHandler.getBackgroundExecutor().schedule(new Runnable() {
            public void run() {
                AppMethodBeat.i(96713);
                DeviceAuthDialog.access$200(DeviceAuthDialog.this);
                AppMethodBeat.o(96713);
            }
        }, this.currentRequestState.getInterval(), TimeUnit.SECONDS);
        AppMethodBeat.o(96736);
    }

    private GraphRequest getPollRequest() {
        AppMethodBeat.i(96737);
        Bundle bundle = new Bundle();
        bundle.putString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.currentRequestState.getRequestCode());
        GraphRequest graphRequest = new GraphRequest(null, DEVICE_LOGIN_STATUS_ENDPOINT, bundle, HttpMethod.POST, new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(96714);
                if (DeviceAuthDialog.this.completed.get()) {
                    AppMethodBeat.o(96714);
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
                                AppMethodBeat.o(96714);
                                return;
                            }
                            DeviceAuthDialog.this.onCancel();
                            AppMethodBeat.o(96714);
                            return;
                        case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING /*1349172*/:
                        case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING /*1349174*/:
                            DeviceAuthDialog.access$400(DeviceAuthDialog.this);
                            AppMethodBeat.o(96714);
                            return;
                        case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED /*1349173*/:
                            DeviceAuthDialog.this.onCancel();
                            AppMethodBeat.o(96714);
                            return;
                        default:
                            DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                            AppMethodBeat.o(96714);
                            return;
                    }
                }
                try {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    DeviceAuthDialog.access$700(DeviceAuthDialog.this, jSONObject.getString("access_token"), Long.valueOf(jSONObject.getLong(AccessToken.EXPIRES_IN_KEY)), Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
                    AppMethodBeat.o(96714);
                } catch (JSONException e) {
                    DeviceAuthDialog.this.onError(new FacebookException(e));
                    AppMethodBeat.o(96714);
                }
            }
        });
        AppMethodBeat.o(96737);
        return graphRequest;
    }

    private void presentConfirmation(String str, PermissionsPair permissionsPair, String str2, String str3, Date date, Date date2) {
        AppMethodBeat.i(96738);
        String string = getResources().getString(R.string.ae);
        String string2 = getResources().getString(R.string.ad);
        String string3 = getResources().getString(R.string.ac);
        String format = String.format(string2, new Object[]{str3});
        Builder builder = new Builder(getContext());
        final String str4 = str;
        final PermissionsPair permissionsPair2 = permissionsPair;
        final String str5 = str2;
        final Date date3 = date;
        final Date date4 = date2;
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(96716);
                DeviceAuthDialog.access$900(DeviceAuthDialog.this, str4, permissionsPair2, str5, date3, date4);
                AppMethodBeat.o(96716);
            }
        }).setPositiveButton(string3, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(96715);
                DeviceAuthDialog.this.dialog.setContentView(DeviceAuthDialog.this.initializeContentView(false));
                DeviceAuthDialog.this.startLogin(DeviceAuthDialog.this.mRequest);
                AppMethodBeat.o(96715);
            }
        });
        builder.create().show();
        AppMethodBeat.o(96738);
    }

    private void onSuccess(final String str, Long l, Long l2) {
        AppMethodBeat.i(96739);
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,permissions,name");
        final Date date = l.longValue() != 0 ? new Date(new Date().getTime() + (l.longValue() * 1000)) : null;
        final Date date2 = (l2.longValue() == 0 || l2 == null) ? null : new Date(l2.longValue() * 1000);
        new GraphRequest(new AccessToken(str, FacebookSdk.getApplicationId(), AppEventsConstants.EVENT_PARAM_VALUE_NO, null, null, null, date, null, date2), "me", bundle, HttpMethod.GET, new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(96717);
                if (DeviceAuthDialog.this.completed.get()) {
                    AppMethodBeat.o(96717);
                } else if (graphResponse.getError() != null) {
                    DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                    AppMethodBeat.o(96717);
                } else {
                    try {
                        JSONObject jSONObject = graphResponse.getJSONObject();
                        String string = jSONObject.getString("id");
                        PermissionsPair handlePermissionResponse = Utility.handlePermissionResponse(jSONObject);
                        String string2 = jSONObject.getString("name");
                        DeviceRequestsHelper.cleanUpAdvertisementService(DeviceAuthDialog.this.currentRequestState.getUserCode());
                        if (!FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.RequireConfirm) || DeviceAuthDialog.this.isRetry) {
                            DeviceAuthDialog.access$900(DeviceAuthDialog.this, string, handlePermissionResponse, str, date, date2);
                            AppMethodBeat.o(96717);
                            return;
                        }
                        DeviceAuthDialog.this.isRetry = true;
                        DeviceAuthDialog.access$1100(DeviceAuthDialog.this, string, handlePermissionResponse, str, string2, date, date2);
                        AppMethodBeat.o(96717);
                    } catch (JSONException e) {
                        DeviceAuthDialog.this.onError(new FacebookException(e));
                        AppMethodBeat.o(96717);
                    }
                }
            }
        }).executeAsync();
        AppMethodBeat.o(96739);
    }

    private void completeLogin(String str, PermissionsPair permissionsPair, String str2, Date date, Date date2) {
        AppMethodBeat.i(96740);
        this.deviceAuthMethodHandler.onSuccess(str2, FacebookSdk.getApplicationId(), str, permissionsPair.getGrantedPermissions(), permissionsPair.getDeclinedPermissions(), AccessTokenSource.DEVICE_AUTH, date, null, date2);
        this.dialog.dismiss();
        AppMethodBeat.o(96740);
    }

    /* Access modifiers changed, original: protected */
    public void onError(FacebookException facebookException) {
        AppMethodBeat.i(96741);
        if (this.completed.compareAndSet(false, true)) {
            if (this.currentRequestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
            }
            this.deviceAuthMethodHandler.onError(facebookException);
            this.dialog.dismiss();
            AppMethodBeat.o(96741);
            return;
        }
        AppMethodBeat.o(96741);
    }

    /* Access modifiers changed, original: protected */
    public void onCancel() {
        AppMethodBeat.i(96742);
        if (this.completed.compareAndSet(false, true)) {
            if (this.currentRequestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
            }
            if (this.deviceAuthMethodHandler != null) {
                this.deviceAuthMethodHandler.onCancel();
            }
            this.dialog.dismiss();
            AppMethodBeat.o(96742);
            return;
        }
        AppMethodBeat.o(96742);
    }
}
