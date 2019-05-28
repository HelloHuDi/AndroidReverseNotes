package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.login.LoginClient.OnCompletedListener;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class LoginFragment extends Fragment {
    static final String EXTRA_REQUEST = "request";
    private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
    static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";
    static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
    private static final String SAVED_LOGIN_CLIENT = "loginClient";
    private static final String TAG = "LoginFragment";
    private String callingPackage;
    private LoginClient loginClient;
    private Request request;

    static /* synthetic */ void access$000(LoginFragment loginFragment, Result result) {
        AppMethodBeat.i(96856);
        loginFragment.onLoginClientCompleted(result);
        AppMethodBeat.o(96856);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(96846);
        super.onCreate(bundle);
        if (bundle != null) {
            this.loginClient = (LoginClient) bundle.getParcelable(SAVED_LOGIN_CLIENT);
            this.loginClient.setFragment(this);
        } else {
            this.loginClient = createLoginClient();
        }
        this.loginClient.setOnCompletedListener(new OnCompletedListener() {
            public void onCompleted(Result result) {
                AppMethodBeat.i(96843);
                LoginFragment.access$000(LoginFragment.this, result);
                AppMethodBeat.o(96843);
            }
        });
        FragmentActivity activity = getActivity();
        if (activity == null) {
            AppMethodBeat.o(96846);
            return;
        }
        initializeCallingPackage(activity);
        Intent intent = activity.getIntent();
        if (intent != null) {
            Bundle bundleExtra = intent.getBundleExtra(REQUEST_KEY);
            if (bundleExtra != null) {
                this.request = (Request) bundleExtra.getParcelable("request");
            }
        }
        AppMethodBeat.o(96846);
    }

    /* Access modifiers changed, original: protected */
    public LoginClient createLoginClient() {
        AppMethodBeat.i(96847);
        LoginClient loginClient = new LoginClient((Fragment) this);
        AppMethodBeat.o(96847);
        return loginClient;
    }

    public void onDestroy() {
        AppMethodBeat.i(96848);
        this.loginClient.cancelCurrentHandler();
        super.onDestroy();
        AppMethodBeat.o(96848);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(96849);
        View inflate = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        final View findViewById = inflate.findViewById(R.id.azk);
        this.loginClient.setBackgroundProcessingListener(new BackgroundProcessingListener() {
            public void onBackgroundProcessingStarted() {
                AppMethodBeat.i(96844);
                findViewById.setVisibility(0);
                AppMethodBeat.o(96844);
            }

            public void onBackgroundProcessingStopped() {
                AppMethodBeat.i(96845);
                findViewById.setVisibility(8);
                AppMethodBeat.o(96845);
            }
        });
        AppMethodBeat.o(96849);
        return inflate;
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResId() {
        return R.layout.p_;
    }

    private void onLoginClientCompleted(Result result) {
        AppMethodBeat.i(96850);
        this.request = null;
        int i = result.code == Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_KEY, result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i, intent);
            getActivity().finish();
        }
        AppMethodBeat.o(96850);
    }

    public void onResume() {
        AppMethodBeat.i(96851);
        super.onResume();
        if (this.callingPackage == null) {
            getActivity().finish();
            AppMethodBeat.o(96851);
            return;
        }
        this.loginClient.startOrContinueAuth(this.request);
        AppMethodBeat.o(96851);
    }

    public void onPause() {
        View view;
        AppMethodBeat.i(96852);
        super.onPause();
        if (getView() == null) {
            view = null;
        } else {
            view = getView().findViewById(R.id.azk);
        }
        if (view != null) {
            view.setVisibility(8);
        }
        AppMethodBeat.o(96852);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(96853);
        super.onActivityResult(i, i2, intent);
        this.loginClient.onActivityResult(i, i2, intent);
        AppMethodBeat.o(96853);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(96854);
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(SAVED_LOGIN_CLIENT, this.loginClient);
        AppMethodBeat.o(96854);
    }

    private void initializeCallingPackage(Activity activity) {
        AppMethodBeat.i(96855);
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            AppMethodBeat.o(96855);
            return;
        }
        this.callingPackage = callingActivity.getPackageName();
        AppMethodBeat.o(96855);
    }

    /* Access modifiers changed, original: 0000 */
    public LoginClient getLoginClient() {
        return this.loginClient;
    }
}
