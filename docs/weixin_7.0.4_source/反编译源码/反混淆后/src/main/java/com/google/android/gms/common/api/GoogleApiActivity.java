package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleApiActivity extends Activity implements OnCancelListener {
    @VisibleForTesting
    private int zzct = 0;

    public static PendingIntent zza(Context context, PendingIntent pendingIntent, int i) {
        AppMethodBeat.m2504i(60528);
        PendingIntent activity = PendingIntent.getActivity(context, 0, zza(context, pendingIntent, i, true), 134217728);
        AppMethodBeat.m2505o(60528);
        return activity;
    }

    public static Intent zza(Context context, PendingIntent pendingIntent, int i, boolean z) {
        AppMethodBeat.m2504i(60529);
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        AppMethodBeat.m2505o(60529);
        return intent;
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(60531);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.zzct = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                GoogleApiManager zzb = GoogleApiManager.zzb((Context) this);
                switch (i2) {
                    case -1:
                        zzb.zzr();
                        break;
                    case 0:
                        zzb.zza(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                        break;
                }
            }
        } else if (i == 2) {
            this.zzct = 0;
            setResult(i2, intent);
        }
        finish();
        AppMethodBeat.m2505o(60531);
    }

    public void onCancel(DialogInterface dialogInterface) {
        AppMethodBeat.m2504i(60533);
        this.zzct = 0;
        setResult(0);
        finish();
        AppMethodBeat.m2505o(60533);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(60530);
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzct = bundle.getInt("resolution");
        }
        if (this.zzct != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                AppMethodBeat.m2505o(60530);
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
            if (pendingIntent == null && num == null) {
                finish();
                AppMethodBeat.m2505o(60530);
                return;
            } else if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.zzct = 1;
                    AppMethodBeat.m2505o(60530);
                    return;
                } catch (SendIntentException e) {
                    finish();
                    AppMethodBeat.m2505o(60530);
                    return;
                }
            } else {
                GoogleApiAvailability.getInstance().showErrorDialogFragment(this, num.intValue(), 2, this);
                this.zzct = 1;
            }
        }
        AppMethodBeat.m2505o(60530);
    }

    /* Access modifiers changed, original: protected */
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(60532);
        bundle.putInt("resolution", this.zzct);
        super.onSaveInstanceState(bundle);
        AppMethodBeat.m2505o(60532);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }
}
