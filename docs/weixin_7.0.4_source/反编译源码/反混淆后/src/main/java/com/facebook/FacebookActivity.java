package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p057v4.app.C0336i;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.app.FragmentActivity;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginFragment;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookActivity extends FragmentActivity {
    private static String FRAGMENT_TAG = "SingleFragment";
    public static String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    private static final String TAG = FacebookActivity.class.getName();
    private Fragment singleFragment;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static {
        AppMethodBeat.m2504i(96592);
        AppMethodBeat.m2505o(96592);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(96588);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!FacebookSdk.isInitialized()) {
            Utility.logd(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            FacebookSdk.sdkInitialize(getApplicationContext());
        }
        setContentView(2130969167);
        if (PASS_THROUGH_CANCEL_ACTION.equals(intent.getAction())) {
            handlePassThroughError();
            AppMethodBeat.m2505o(96588);
            return;
        }
        this.singleFragment = getFragment();
        AppMethodBeat.m2505o(96588);
    }

    /* Access modifiers changed, original: protected */
    public Fragment getFragment() {
        AppMethodBeat.m2504i(96589);
        Intent intent = getIntent();
        C0336i supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (findFragmentByTag == null) {
            if (FacebookDialogFragment.TAG.equals(intent.getAction())) {
                findFragmentByTag = new FacebookDialogFragment();
                findFragmentByTag.setRetainInstance(true);
                findFragmentByTag.show(supportFragmentManager, FRAGMENT_TAG);
            } else if (DeviceShareDialogFragment.TAG.equals(intent.getAction())) {
                Fragment deviceShareDialogFragment = new DeviceShareDialogFragment();
                deviceShareDialogFragment.setRetainInstance(true);
                deviceShareDialogFragment.setShareContent((ShareContent) intent.getParcelableExtra(C8741b.CONTENT));
                deviceShareDialogFragment.show(supportFragmentManager, FRAGMENT_TAG);
                findFragmentByTag = deviceShareDialogFragment;
            } else {
                findFragmentByTag = new LoginFragment();
                findFragmentByTag.setRetainInstance(true);
                supportFragmentManager.beginTransaction().mo553a(2131822892, findFragmentByTag, FRAGMENT_TAG).commit();
            }
        }
        AppMethodBeat.m2505o(96589);
        return findFragmentByTag;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(96590);
        super.onConfigurationChanged(configuration);
        if (this.singleFragment != null) {
            this.singleFragment.onConfigurationChanged(configuration);
        }
        AppMethodBeat.m2505o(96590);
    }

    public Fragment getCurrentFragment() {
        return this.singleFragment;
    }

    private void handlePassThroughError() {
        AppMethodBeat.m2504i(96591);
        setResult(0, NativeProtocol.createProtocolResultIntent(getIntent(), null, NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(getIntent()))));
        finish();
        AppMethodBeat.m2505o(96591);
    }
}
