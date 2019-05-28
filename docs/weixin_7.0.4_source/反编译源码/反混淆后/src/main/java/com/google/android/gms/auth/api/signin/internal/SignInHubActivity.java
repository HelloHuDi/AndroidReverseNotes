package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.p057v4.app.C0354r.C0353a;
import android.support.p057v4.app.FragmentActivity;
import android.support.p057v4.content.C0383c;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

@KeepName
public class SignInHubActivity extends FragmentActivity {
    private static boolean zzfg = false;
    private boolean zzfh = false;
    private SignInConfiguration zzfi;
    private boolean zzfj;
    private int zzfk;
    private Intent zzfl;

    class zzd implements C0353a<Void> {
        private zzd() {
        }

        /* synthetic */ zzd(SignInHubActivity signInHubActivity, zzz zzz) {
            this();
        }

        public final C0383c<Void> onCreateLoader(int i, Bundle bundle) {
            AppMethodBeat.m2504i(50407);
            zzf zzf = new zzf(SignInHubActivity.this, GoogleApiClient.getAllClients());
            AppMethodBeat.m2505o(50407);
            return zzf;
        }

        public final /* synthetic */ void onLoadFinished(C0383c c0383c, Object obj) {
            AppMethodBeat.m2504i(50408);
            SignInHubActivity.this.setResult(SignInHubActivity.this.zzfk, SignInHubActivity.this.zzfl);
            SignInHubActivity.this.finish();
            AppMethodBeat.m2505o(50408);
        }

        public final void onLoaderReset(C0383c<Void> c0383c) {
        }
    }

    private final void zzd(int i) {
        AppMethodBeat.m2504i(50413);
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zzfg = false;
        AppMethodBeat.m2505o(50413);
    }

    private final void zzu() {
        AppMethodBeat.m2504i(50412);
        getSupportLoaderManager().mo607a(new zzd(this, null));
        zzfg = false;
        AppMethodBeat.m2505o(50412);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(50411);
        if (this.zzfh) {
            AppMethodBeat.m2505o(50411);
            return;
        }
        setResult(0);
        switch (i) {
            case 40962:
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                    if (signInAccount != null && signInAccount.getGoogleSignInAccount() != null) {
                        GoogleSignInAccount googleSignInAccount = signInAccount.getGoogleSignInAccount();
                        zzq.zze(this).zzd(this.zzfi.zzt(), googleSignInAccount);
                        intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                        intent.putExtra("googleSignInAccount", googleSignInAccount);
                        this.zzfj = true;
                        this.zzfk = i2;
                        this.zzfl = intent;
                        zzu();
                        AppMethodBeat.m2505o(50411);
                        return;
                    } else if (intent.hasExtra(OpenSDKTool4Assistant.EXTRA_ERROR_CODE)) {
                        zzd(intent.getIntExtra(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, 8));
                        AppMethodBeat.m2505o(50411);
                        return;
                    }
                }
                zzd(8);
                break;
        }
        AppMethodBeat.m2505o(50411);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(50409);
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            zzd((int) GoogleSignInStatusCodes.SIGN_IN_FAILED);
            AppMethodBeat.m2505o(50409);
        } else if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            this.zzfi = (SignInConfiguration) intent.getBundleExtra("config").getParcelable("config");
            if (this.zzfi == null) {
                setResult(0);
                finish();
                AppMethodBeat.m2505o(50409);
                return;
            }
            if (!(bundle == null)) {
                this.zzfj = bundle.getBoolean("signingInGoogleApiClients");
                if (this.zzfj) {
                    this.zzfk = bundle.getInt("signInResultCode");
                    this.zzfl = (Intent) bundle.getParcelable("signInResultData");
                    zzu();
                }
                AppMethodBeat.m2505o(50409);
            } else if (zzfg) {
                setResult(0);
                zzd((int) GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
                AppMethodBeat.m2505o(50409);
            } else {
                zzfg = true;
                intent = new Intent(action);
                if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                    intent.setPackage("com.google.android.gms");
                } else {
                    intent.setPackage(getPackageName());
                }
                intent.putExtra("config", this.zzfi);
                try {
                    startActivityForResult(intent, 40962);
                    AppMethodBeat.m2505o(50409);
                } catch (ActivityNotFoundException e) {
                    this.zzfh = true;
                    zzd(17);
                    AppMethodBeat.m2505o(50409);
                }
            }
        } else {
            String str = "Unknown action: ";
            String valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                valueOf = new String(str);
            }
            finish();
            AppMethodBeat.m2505o(50409);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(50410);
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zzfj);
        if (this.zzfj) {
            bundle.putInt("signInResultCode", this.zzfk);
            bundle.putParcelable("signInResultData", this.zzfl);
        }
        AppMethodBeat.m2505o(50410);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }
}
