package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.i;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginFragment;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class FacebookActivity extends FragmentActivity {
    private static String FRAGMENT_TAG = "SingleFragment";
    public static String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    private static final String TAG = FacebookActivity.class.getName();
    private Fragment singleFragment;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(96592);
        AppMethodBeat.o(96592);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(96588);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!FacebookSdk.isInitialized()) {
            Utility.logd(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            FacebookSdk.sdkInitialize(getApplicationContext());
        }
        setContentView(R.layout.p8);
        if (PASS_THROUGH_CANCEL_ACTION.equals(intent.getAction())) {
            handlePassThroughError();
            AppMethodBeat.o(96588);
            return;
        }
        this.singleFragment = getFragment();
        AppMethodBeat.o(96588);
    }

    /* Access modifiers changed, original: protected */
    public Fragment getFragment() {
        AppMethodBeat.i(96589);
        Intent intent = getIntent();
        i supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (findFragmentByTag == null) {
            if (FacebookDialogFragment.TAG.equals(intent.getAction())) {
                findFragmentByTag = new FacebookDialogFragment();
                findFragmentByTag.setRetainInstance(true);
                findFragmentByTag.show(supportFragmentManager, FRAGMENT_TAG);
            } else if (DeviceShareDialogFragment.TAG.equals(intent.getAction())) {
                Fragment deviceShareDialogFragment = new DeviceShareDialogFragment();
                deviceShareDialogFragment.setRetainInstance(true);
                deviceShareDialogFragment.setShareContent((ShareContent) intent.getParcelableExtra(b.CONTENT));
                deviceShareDialogFragment.show(supportFragmentManager, FRAGMENT_TAG);
                findFragmentByTag = deviceShareDialogFragment;
            } else {
                findFragmentByTag = new LoginFragment();
                findFragmentByTag.setRetainInstance(true);
                supportFragmentManager.beginTransaction().a(R.id.azg, findFragmentByTag, FRAGMENT_TAG).commit();
            }
        }
        AppMethodBeat.o(96589);
        return findFragmentByTag;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(96590);
        super.onConfigurationChanged(configuration);
        if (this.singleFragment != null) {
            this.singleFragment.onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(96590);
    }

    public Fragment getCurrentFragment() {
        return this.singleFragment;
    }

    private void handlePassThroughError() {
        AppMethodBeat.i(96591);
        setResult(0, NativeProtocol.createProtocolResultIntent(getIntent(), null, NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(getIntent()))));
        finish();
        AppMethodBeat.o(96591);
    }
}
