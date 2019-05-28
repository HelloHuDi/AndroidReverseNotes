package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm implements zzn {
    private final PendingIntent zzat;
    private final Context zzk;

    zzm(Context context) {
        AppMethodBeat.m2504i(70037);
        this.zzk = context;
        this.zzat = PendingIntent.getBroadcast(context, 0, new Intent().setPackage("com.google.example.invalidpackage"), 0);
        AppMethodBeat.m2505o(70037);
    }

    private final Intent zzh(String str) {
        AppMethodBeat.m2504i(70041);
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("app", this.zzat);
        intent.putExtra("source", 4);
        intent.putExtra("source_version", 12451000);
        intent.putExtra("scheduler_action", str);
        AppMethodBeat.m2505o(70041);
        return intent;
    }

    public final boolean zzd(ComponentName componentName) {
        AppMethodBeat.m2504i(70040);
        Intent zzh = zzh("CANCEL_ALL");
        zzh.putExtra("component", componentName);
        this.zzk.sendBroadcast(zzh);
        AppMethodBeat.m2505o(70040);
        return true;
    }

    public final boolean zzd(ComponentName componentName, String str) {
        AppMethodBeat.m2504i(70039);
        Intent zzh = zzh("CANCEL_TASK");
        zzh.putExtra("component", componentName);
        zzh.putExtra("tag", str);
        this.zzk.sendBroadcast(zzh);
        AppMethodBeat.m2505o(70039);
        return true;
    }

    public final boolean zzd(Task task) {
        AppMethodBeat.m2504i(70038);
        Intent zzh = zzh("SCHEDULE_TASK");
        Bundle bundle = new Bundle();
        task.toBundle(bundle);
        zzh.putExtras(bundle);
        this.zzk.sendBroadcast(zzh);
        AppMethodBeat.m2505o(70038);
        return true;
    }
}
