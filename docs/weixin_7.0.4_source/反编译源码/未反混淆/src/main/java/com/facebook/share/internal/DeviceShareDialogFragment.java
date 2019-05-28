package com.facebook.share.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mm.R;
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
        public static final Creator<RequestState> CREATOR = new Creator<RequestState>() {
            public final RequestState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(96956);
                RequestState requestState = new RequestState(parcel);
                AppMethodBeat.o(96956);
                return requestState;
            }

            public final RequestState[] newArray(int i) {
                return new RequestState[i];
            }
        };
        private long expiresIn;
        private String userCode;

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
            AppMethodBeat.i(96959);
            this.userCode = parcel.readString();
            this.expiresIn = parcel.readLong();
            AppMethodBeat.o(96959);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(96960);
            parcel.writeString(this.userCode);
            parcel.writeLong(this.expiresIn);
            AppMethodBeat.o(96960);
        }

        static {
            AppMethodBeat.i(96961);
            AppMethodBeat.o(96961);
        }
    }

    static /* synthetic */ void access$100(DeviceShareDialogFragment deviceShareDialogFragment, FacebookRequestError facebookRequestError) {
        AppMethodBeat.i(96973);
        deviceShareDialogFragment.finishActivityWithError(facebookRequestError);
        AppMethodBeat.o(96973);
    }

    static /* synthetic */ void access$200(DeviceShareDialogFragment deviceShareDialogFragment, RequestState requestState) {
        AppMethodBeat.i(96974);
        deviceShareDialogFragment.setCurrentRequestState(requestState);
        AppMethodBeat.o(96974);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(96962);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (bundle != null) {
            RequestState requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY);
            if (requestState != null) {
                setCurrentRequestState(requestState);
            }
        }
        AppMethodBeat.o(96962);
        return onCreateView;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.i(96963);
        this.dialog = new Dialog(getActivity(), R.style.z8);
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.p9, null);
        this.progressBar = (ProgressBar) inflate.findViewById(R.id.oa);
        this.confirmationCode = (TextView) inflate.findViewById(R.id.azh);
        ((Button) inflate.findViewById(R.id.azj)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AppMethodBeat.i(96953);
                DeviceShareDialogFragment.this.dialog.dismiss();
                AppMethodBeat.o(96953);
            }
        });
        ((TextView) inflate.findViewById(R.id.azi)).setText(Html.fromHtml(getString(R.string.u)));
        this.dialog.setContentView(inflate);
        startShare();
        Dialog dialog = this.dialog;
        AppMethodBeat.o(96963);
        return dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        AppMethodBeat.i(96964);
        super.onDismiss(dialogInterface);
        if (this.codeExpiredFuture != null) {
            this.codeExpiredFuture.cancel(true);
        }
        finishActivity(-1, new Intent());
        AppMethodBeat.o(96964);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(96965);
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
        AppMethodBeat.o(96965);
    }

    private void finishActivity(int i, Intent intent) {
        AppMethodBeat.i(96966);
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
        AppMethodBeat.o(96966);
    }

    private void detach() {
        AppMethodBeat.i(96967);
        if (isAdded()) {
            getFragmentManager().beginTransaction().a(this).commit();
        }
        AppMethodBeat.o(96967);
    }

    public void setShareContent(ShareContent shareContent) {
        this.shareContent = shareContent;
    }

    private Bundle getGraphParametersForShareContent() {
        AppMethodBeat.i(96968);
        ShareContent shareContent = this.shareContent;
        Bundle create;
        if (shareContent == null) {
            AppMethodBeat.o(96968);
            return null;
        } else if (shareContent instanceof ShareLinkContent) {
            create = WebDialogParameters.create((ShareLinkContent) shareContent);
            AppMethodBeat.o(96968);
            return create;
        } else if (shareContent instanceof ShareOpenGraphContent) {
            create = WebDialogParameters.create((ShareOpenGraphContent) shareContent);
            AppMethodBeat.o(96968);
            return create;
        } else {
            AppMethodBeat.o(96968);
            return null;
        }
    }

    private void startShare() {
        AppMethodBeat.i(96969);
        Bundle graphParametersForShareContent = getGraphParametersForShareContent();
        if (graphParametersForShareContent == null || graphParametersForShareContent.size() == 0) {
            finishActivityWithError(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        graphParametersForShareContent.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
        graphParametersForShareContent.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo());
        new GraphRequest(null, DEVICE_SHARE_ENDPOINT, graphParametersForShareContent, HttpMethod.POST, new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(96954);
                FacebookRequestError error = graphResponse.getError();
                if (error != null) {
                    DeviceShareDialogFragment.access$100(DeviceShareDialogFragment.this, error);
                    AppMethodBeat.o(96954);
                    return;
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                RequestState requestState = new RequestState();
                try {
                    requestState.setUserCode(jSONObject.getString("user_code"));
                    requestState.setExpiresIn(jSONObject.getLong(AccessToken.EXPIRES_IN_KEY));
                    DeviceShareDialogFragment.access$200(DeviceShareDialogFragment.this, requestState);
                    AppMethodBeat.o(96954);
                } catch (JSONException e) {
                    DeviceShareDialogFragment.access$100(DeviceShareDialogFragment.this, new FacebookRequestError(0, "", "Malformed server response"));
                    AppMethodBeat.o(96954);
                }
            }
        }).executeAsync();
        AppMethodBeat.o(96969);
    }

    private void finishActivityWithError(FacebookRequestError facebookRequestError) {
        AppMethodBeat.i(96970);
        detach();
        Intent intent = new Intent();
        intent.putExtra("error", facebookRequestError);
        finishActivity(-1, intent);
        AppMethodBeat.o(96970);
    }

    private static synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceShareDialogFragment.class) {
            AppMethodBeat.i(96971);
            if (backgroundExecutor == null) {
                backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = backgroundExecutor;
            AppMethodBeat.o(96971);
        }
        return scheduledThreadPoolExecutor;
    }

    private void setCurrentRequestState(RequestState requestState) {
        AppMethodBeat.i(96972);
        this.currentRequestState = requestState;
        this.confirmationCode.setText(requestState.getUserCode());
        this.confirmationCode.setVisibility(0);
        this.progressBar.setVisibility(8);
        this.codeExpiredFuture = getBackgroundExecutor().schedule(new Runnable() {
            public void run() {
                AppMethodBeat.i(96955);
                DeviceShareDialogFragment.this.dialog.dismiss();
                AppMethodBeat.o(96955);
            }
        }, requestState.getExpiresIn(), TimeUnit.SECONDS);
        AppMethodBeat.o(96972);
    }
}
