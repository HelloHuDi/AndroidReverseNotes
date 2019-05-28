package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzgb {
    private final zzge zzala;

    public zzgb(zzge zzge) {
        AppMethodBeat.i(68981);
        Preconditions.checkNotNull(zzge);
        this.zzala = zzge;
        AppMethodBeat.o(68981);
    }

    public static boolean zza(Context context) {
        AppMethodBeat.i(68982);
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                AppMethodBeat.o(68982);
                return false;
            }
            ActivityInfo receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
            if (receiverInfo != null && receiverInfo.enabled) {
                AppMethodBeat.o(68982);
                return true;
            }
            AppMethodBeat.o(68982);
            return false;
        } catch (NameNotFoundException e) {
        }
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(68983);
        zzgl zzg = zzgl.zzg(context);
        zzfg zzge = zzg.zzge();
        if (intent == null) {
            zzge.zzip().log("Receiver called with null intent");
            AppMethodBeat.o(68983);
            return;
        }
        String action = intent.getAction();
        zzge.zzit().zzg("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzge.zzit().log("Starting wakeful intent.");
            this.zzala.doStartService(context, className);
            AppMethodBeat.o(68983);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                zzg.zzgd().zzc(new zzgc(this, zzg, zzge));
            } catch (Exception e) {
                zzge.zzip().zzg("Install Referrer Reporter encountered a problem", e);
            }
            PendingResult doGoAsync = this.zzala.doGoAsync();
            action = intent.getStringExtra("referrer");
            if (action == null) {
                zzge.zzit().log("Install referrer extras are null");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                }
                AppMethodBeat.o(68983);
                return;
            }
            zzge.zzir().zzg("Install referrer extras are", action);
            if (!action.contains("?")) {
                String str = "?";
                action = String.valueOf(action);
                action = action.length() != 0 ? str.concat(action) : new String(str);
            }
            Bundle zza = zzg.zzgb().zza(Uri.parse(action));
            if (zza == null) {
                zzge.zzit().log("No campaign defined in install referrer broadcast");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    AppMethodBeat.o(68983);
                    return;
                }
            }
            long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0);
            if (longExtra == 0) {
                zzge.zzip().log("Install referrer is missing timestamp");
            }
            zzg.zzgd().zzc(new zzgd(this, zzg, longExtra, zza, context, zzge, doGoAsync));
        }
        AppMethodBeat.o(68983);
    }
}
