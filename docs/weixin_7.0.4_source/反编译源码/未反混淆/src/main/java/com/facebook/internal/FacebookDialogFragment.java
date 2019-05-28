package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.OnCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookDialogFragment extends DialogFragment {
    public static final String TAG = "FacebookDialogFragment";
    private Dialog dialog;

    static /* synthetic */ void access$000(FacebookDialogFragment facebookDialogFragment, Bundle bundle, FacebookException facebookException) {
        AppMethodBeat.i(96638);
        facebookDialogFragment.onCompleteWebDialog(bundle, facebookException);
        AppMethodBeat.o(96638);
    }

    static /* synthetic */ void access$100(FacebookDialogFragment facebookDialogFragment, Bundle bundle) {
        AppMethodBeat.i(96639);
        facebookDialogFragment.onCompleteWebFallbackDialog(bundle);
        AppMethodBeat.o(96639);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(96631);
        super.onCreate(bundle);
        if (this.dialog == null) {
            Dialog newInstance;
            FragmentActivity activity = getActivity();
            Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(activity.getIntent());
            if (methodArgumentsFromIntent.getBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, false)) {
                String string = methodArgumentsFromIntent.getString("url");
                if (Utility.isNullOrEmpty(string)) {
                    Utility.logd(TAG, "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    AppMethodBeat.o(96631);
                    return;
                }
                newInstance = FacebookWebFallbackDialog.newInstance(activity, string, String.format("fb%s://bridge/", new Object[]{FacebookSdk.getApplicationId()}));
                newInstance.setOnCompleteListener(new OnCompleteListener() {
                    public void onComplete(Bundle bundle, FacebookException facebookException) {
                        AppMethodBeat.i(96630);
                        FacebookDialogFragment.access$100(FacebookDialogFragment.this, bundle);
                        AppMethodBeat.o(96630);
                    }
                });
            } else {
                String string2 = methodArgumentsFromIntent.getString(NativeProtocol.WEB_DIALOG_ACTION);
                methodArgumentsFromIntent = methodArgumentsFromIntent.getBundle("params");
                if (Utility.isNullOrEmpty(string2)) {
                    Utility.logd(TAG, "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    AppMethodBeat.o(96631);
                    return;
                }
                newInstance = new Builder(activity, string2, methodArgumentsFromIntent).setOnCompleteListener(new OnCompleteListener() {
                    public void onComplete(Bundle bundle, FacebookException facebookException) {
                        AppMethodBeat.i(96629);
                        FacebookDialogFragment.access$000(FacebookDialogFragment.this, bundle, facebookException);
                        AppMethodBeat.o(96629);
                    }
                }).build();
            }
            this.dialog = newInstance;
        }
        AppMethodBeat.o(96631);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.i(96632);
        if (this.dialog == null) {
            onCompleteWebDialog(null, null);
            setShowsDialog(false);
        }
        Dialog dialog = this.dialog;
        AppMethodBeat.o(96632);
        return dialog;
    }

    public void onResume() {
        AppMethodBeat.i(96633);
        super.onResume();
        if (this.dialog instanceof WebDialog) {
            ((WebDialog) this.dialog).resize();
        }
        AppMethodBeat.o(96633);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(96634);
        super.onConfigurationChanged(configuration);
        if ((this.dialog instanceof WebDialog) && isResumed()) {
            ((WebDialog) this.dialog).resize();
        }
        AppMethodBeat.o(96634);
    }

    public void onDestroyView() {
        AppMethodBeat.i(96635);
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
        AppMethodBeat.o(96635);
    }

    private void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        AppMethodBeat.i(96636);
        FragmentActivity activity = getActivity();
        activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(activity.getIntent(), bundle, facebookException));
        activity.finish();
        AppMethodBeat.o(96636);
    }

    private void onCompleteWebFallbackDialog(Bundle bundle) {
        AppMethodBeat.i(96637);
        FragmentActivity activity = getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
        AppMethodBeat.o(96637);
    }
}
