package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p057v4.app.DialogFragment;
import android.support.p057v4.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.OnCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookDialogFragment extends DialogFragment {
    public static final String TAG = "FacebookDialogFragment";
    private Dialog dialog;

    /* renamed from: com.facebook.internal.FacebookDialogFragment$2 */
    class C175952 implements OnCompleteListener {
        C175952() {
        }

        public void onComplete(Bundle bundle, FacebookException facebookException) {
            AppMethodBeat.m2504i(96630);
            FacebookDialogFragment.access$100(FacebookDialogFragment.this, bundle);
            AppMethodBeat.m2505o(96630);
        }
    }

    /* renamed from: com.facebook.internal.FacebookDialogFragment$1 */
    class C312461 implements OnCompleteListener {
        C312461() {
        }

        public void onComplete(Bundle bundle, FacebookException facebookException) {
            AppMethodBeat.m2504i(96629);
            FacebookDialogFragment.access$000(FacebookDialogFragment.this, bundle, facebookException);
            AppMethodBeat.m2505o(96629);
        }
    }

    static /* synthetic */ void access$000(FacebookDialogFragment facebookDialogFragment, Bundle bundle, FacebookException facebookException) {
        AppMethodBeat.m2504i(96638);
        facebookDialogFragment.onCompleteWebDialog(bundle, facebookException);
        AppMethodBeat.m2505o(96638);
    }

    static /* synthetic */ void access$100(FacebookDialogFragment facebookDialogFragment, Bundle bundle) {
        AppMethodBeat.m2504i(96639);
        facebookDialogFragment.onCompleteWebFallbackDialog(bundle);
        AppMethodBeat.m2505o(96639);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(96631);
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
                    AppMethodBeat.m2505o(96631);
                    return;
                }
                newInstance = FacebookWebFallbackDialog.newInstance(activity, string, String.format("fb%s://bridge/", new Object[]{FacebookSdk.getApplicationId()}));
                newInstance.setOnCompleteListener(new C175952());
            } else {
                String string2 = methodArgumentsFromIntent.getString(NativeProtocol.WEB_DIALOG_ACTION);
                methodArgumentsFromIntent = methodArgumentsFromIntent.getBundle("params");
                if (Utility.isNullOrEmpty(string2)) {
                    Utility.logd(TAG, "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    AppMethodBeat.m2505o(96631);
                    return;
                }
                newInstance = new Builder(activity, string2, methodArgumentsFromIntent).setOnCompleteListener(new C312461()).build();
            }
            this.dialog = newInstance;
        }
        AppMethodBeat.m2505o(96631);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.m2504i(96632);
        if (this.dialog == null) {
            onCompleteWebDialog(null, null);
            setShowsDialog(false);
        }
        Dialog dialog = this.dialog;
        AppMethodBeat.m2505o(96632);
        return dialog;
    }

    public void onResume() {
        AppMethodBeat.m2504i(96633);
        super.onResume();
        if (this.dialog instanceof WebDialog) {
            ((WebDialog) this.dialog).resize();
        }
        AppMethodBeat.m2505o(96633);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(96634);
        super.onConfigurationChanged(configuration);
        if ((this.dialog instanceof WebDialog) && isResumed()) {
            ((WebDialog) this.dialog).resize();
        }
        AppMethodBeat.m2505o(96634);
    }

    public void onDestroyView() {
        AppMethodBeat.m2504i(96635);
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
        AppMethodBeat.m2505o(96635);
    }

    private void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        AppMethodBeat.m2504i(96636);
        FragmentActivity activity = getActivity();
        activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(activity.getIntent(), bundle, facebookException));
        activity.finish();
        AppMethodBeat.m2505o(96636);
    }

    private void onCompleteWebFallbackDialog(Bundle bundle) {
        AppMethodBeat.m2504i(96637);
        FragmentActivity activity = getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
        AppMethodBeat.m2505o(96637);
    }
}
