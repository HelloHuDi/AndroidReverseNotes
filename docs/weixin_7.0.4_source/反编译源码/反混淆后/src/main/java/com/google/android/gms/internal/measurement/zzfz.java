package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzfz implements ServiceConnection {
    final /* synthetic */ zzfx zzaky;

    private zzfz(zzfx zzfx) {
        this.zzaky = zzfx;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.m2504i(68978);
        if (iBinder == null) {
            this.zzaky.zzacw.zzge().zzip().log("Install Referrer connection returned with null binder");
            AppMethodBeat.m2505o(68978);
            return;
        }
        try {
            this.zzaky.zzakw = zzs.zza(iBinder);
            if (this.zzaky.zzakw == null) {
                this.zzaky.zzacw.zzge().zzip().log("Install Referrer Service implementation was not found");
                AppMethodBeat.m2505o(68978);
                return;
            }
            this.zzaky.zzacw.zzge().zzir().log("Install Referrer Service connected");
            this.zzaky.zzacw.zzgd().zzc(new zzga(this));
            AppMethodBeat.m2505o(68978);
        } catch (Exception e) {
            this.zzaky.zzacw.zzge().zzip().zzg("Exception occurred while calling Install Referrer API", e);
            AppMethodBeat.m2505o(68978);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.m2504i(68979);
        this.zzaky.zzakw = null;
        this.zzaky.zzacw.zzge().zzir().log("Install Referrer Service disconnected");
        AppMethodBeat.m2505o(68979);
    }
}
