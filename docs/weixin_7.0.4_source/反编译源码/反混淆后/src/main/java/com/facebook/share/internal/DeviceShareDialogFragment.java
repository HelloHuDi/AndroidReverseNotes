package com.facebook.share.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p057v4.app.DialogFragment;
import android.support.p057v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceShareDialogFragment extends DialogFragment {
    private static final String DEVICE_SHARE_ENDPOINT = "device/share";
    private static final String EXTRA_ERROR = "error";
    private static final String REQUEST_STATE_KEY = "request_state";
    public static final String TAG = "DeviceShareDialogFragment";
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private volatile ScheduledFuture codeExpiredFuture;
    private TextView confirmationCode;
    private volatile RequestState currentRequestState;
    private Dialog dialog;
    private ProgressBar progressBar;
    private ShareContent shareContent;

    static class RequestState implements Parcelable {
        public static final Creator<RequestState> CREATOR = new C176121();
        private long expiresIn;
        private String userCode;

        /* renamed from: com.facebook.share.internal.DeviceShareDialogFragment$RequestState$1 */
        static class C176121 implements Creator<RequestState> {
            C176121() {
            }

            public final RequestState createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(96956);
                RequestState requestState = new RequestState(parcel);
                AppMethodBeat.m2505o(96956);
                return requestState;
            }

            public final RequestState[] newArray(int i) {
                return new RequestState[i];
            }
        }

        RequestState() {
        }

        public String getUserCode() {
            return this.userCode;
        }

        public void setUserCode(String str) {
            this.userCode = str;
        }

        public long getExpiresIn() {
            return this.expiresIn;
        }

        public void setExpiresIn(long j) {
            this.expiresIn = j;
        }

        protected RequestState(Parcel parcel) {
            AppMethodBeat.m2504i(96959);
            this.userCode = parcel.readString();
            this.expiresIn = parcel.readLong();
            AppMethodBeat.m2505o(96959);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(96960);
            parcel.writeString(this.userCode);
            parcel.writeLong(this.expiresIn);
            AppMethodBeat.m2505o(96960);
        }

        static {
            AppMethodBeat.m2504i(96961);
            AppMethodBeat.m2505o(96961);
        }
    }

    /* renamed from: com.facebook.share.internal.DeviceShareDialogFragment$1 */
    class C176131 implements OnClickListener {
        C176131() {
        }

        public void onClick(View view) {
            AppMethodBeat.m2504i(96953);
            DeviceShareDialogFragment.this.dialog.dismiss();
            AppMethodBeat.m2505o(96953);
        }
    }

    /* renamed from: com.facebook.share.internal.DeviceShareDialogFragment$2 */
    class C176142 implements Callback {
        C176142() {
        }

        public void onCompleted(GraphResponse graphResponse) {
            AppMethodBeat.m2504i(96954);
            FacebookRequestError error = graphResponse.getError();
            if (error != null) {
                DeviceShareDialogFragment.access$100(DeviceShareDialogFragment.this, error);
                AppMethodBeat.m2505o(96954);
                return;
            }
            JSONObject jSONObject = graphResponse.getJSONObject();
            RequestState requestState = new RequestState();
            try {
                requestState.setUserCode(jSONObject.getString("user_code"));
                requestState.setExpiresIn(jSONObject.getLong(AccessToken.EXPIRES_IN_KEY));
                DeviceShareDialogFragment.access$200(DeviceShareDialogFragment.this, requestState);
                AppMethodBeat.m2505o(96954);
            } catch (JSONException e) {
                DeviceShareDialogFragment.access$100(DeviceShareDialogFragment.this, new FacebookRequestError(0, "", "Malformed server response"));
                AppMethodBeat.m2505o(96954);
            }
        }
    }

    /* renamed from: com.facebook.share.internal.DeviceShareDialogFragment$3 */
    class C176153 implements Runnable {
        C176153() {
        }

        public void run() {
            AppMethodBeat.m2504i(96955);
            DeviceShareDialogFragment.this.dialog.dismiss();
            AppMethodBeat.m2505o(96955);
        }
    }

    static /* synthetic */ void access$100(DeviceShareDialogFragment deviceShareDialogFragment, FacebookRequestError facebookRequestError) {
        AppMethodBeat.m2504i(96973);
        deviceShareDialogFragment.finishActivityWithError(facebookRequestError);
        AppMethodBeat.m2505o(96973);
    }

    static /* synthetic */ void access$200(DeviceShareDialogFragment deviceShareDialogFragment, RequestState requestState) {
        AppMethodBeat.m2504i(96974);
        deviceShareDialogFragment.setCurrentRequestState(requestState);
        AppMethodBeat.m2505o(96974);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.m2504i(96962);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (bundle != null) {
            RequestState requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY);
            if (requestState != null) {
                setCurrentRequestState(requestState);
            }
        }
        AppMethodBeat.m2505o(96962);
        return onCreateView;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.m2504i(96963);
        this.dialog = new Dialog(getActivity(), C25738R.style.f11397z8);
        View inflate = getActivity().getLayoutInflater().inflate(2130969168, null);
        this.progressBar = (ProgressBar) inflate.findViewById(2131821099);
        this.confirmationCode = (TextView) inflate.findViewById(2131822893);
        ((Button) inflate.findViewById(2131822895)).setOnClickListener(new C176131());
        ((TextView) inflate.findViewById(2131822894)).setText(Html.fromHtml(getString(C25738R.string.f8614u)));
        this.dialog.setContentView(inflate);
        startShare();
        Dialog dialog = this.dialog;
        AppMethodBeat.m2505o(96963);
        return dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        AppMethodBeat.m2504i(96964);
        super.onDismiss(dialogInterface);
        if (this.codeExpiredFuture != null) {
            this.codeExpiredFuture.cancel(true);
        }
        finishActivity(-1, new Intent());
        AppMethodBeat.m2505o(96964);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(96965);
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
        AppMethodBeat.m2505o(96965);
    }

    private void finishActivity(int i, Intent intent) {
        AppMethodBeat.m2504i(96966);
        if (this.currentRequestState != null) {
            DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
        }
        FacebookRequestError facebookRequestError = (FacebookRequestError) intent.getParcelableExtra("error");
        if (facebookRequestError != null) {
            Toast.makeText(getContext(), facebookRequestError.getErrorMessage(), 0).show();
        }
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            activity.setResult(i, intent);
            activity.finish();
        }
        AppMethodBeat.m2505o(96966);
    }

    private void detach() {
        AppMethodBeat.m2504i(96967);
        if (isAdded()) {
            getFragmentManager().beginTransaction().mo554a(this).commit();
        }
        AppMethodBeat.m2505o(96967);
    }

    public void setShareContent(ShareContent shareContent) {
        this.shareContent = shareContent;
    }

    private Bundle getGraphParametersForShareContent() {
        AppMethodBeat.m2504i(96968);
        ShareContent shareContent = this.shareContent;
        Bundle create;
        if (shareContent == null) {
            AppMethodBeat.m2505o(96968);
            return null;
        } else if (shareContent instanceof ShareLinkContent) {
            create = WebDialogParameters.create((ShareLinkContent) shareContent);
            AppMethodBeat.m2505o(96968);
            return create;
        } else if (shareContent instanceof ShareOpenGraphContent) {
            create = WebDialogParameters.create((ShareOpenGraphContent) shareContent);
            AppMethodBeat.m2505o(96968);
            return create;
        } else {
            AppMethodBeat.m2505o(96968);
            return null;
        }
    }

    private void startShare() {
        AppMethodBeat.m2504i(96969);
        Bundle graphParametersForShareContent = getGraphParametersForShareContent();
        if (graphParametersForShareContent == null || graphParametersForShareContent.size() == 0) {
            finishActivityWithError(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        graphParametersForShareContent.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
        graphParametersForShareContent.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo());
        new GraphRequest(null, DEVICE_SHARE_ENDPOINT, graphParametersForShareContent, HttpMethod.POST, new C176142()).executeAsync();
        AppMethodBeat.m2505o(96969);
    }

    private void finishActivityWithError(FacebookRequestError facebookRequestError) {
        AppMethodBeat.m2504i(96970);
        detach();
        Intent intent = new Intent();
        intent.putExtra("error", facebookRequestError);
        finishActivity(-1, intent);
        AppMethodBeat.m2505o(96970);
    }

    private static synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceShareDialogFragment.class) {
            AppMethodBeat.m2504i(96971);
            if (backgroundExecutor == null) {
                backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = backgroundExecutor;
            AppMethodBeat.m2505o(96971);
        }
        return scheduledThreadPoolExecutor;
    }

    private void setCurrentRequestState(RequestState requestState) {
        AppMethodBeat.m2504i(96972);
        this.currentRequestState = requestState;
        this.confirmationCode.setText(requestState.getUserCode());
        this.confirmationCode.setVisibility(0);
        this.progressBar.setVisibility(8);
        this.codeExpiredFuture = getBackgroundExecutor().schedule(new C176153(), requestState.getExpiresIn(), TimeUnit.SECONDS);
        AppMethodBeat.m2505o(96972);
    }
}
