package com.google.android.gms.auth;

import android.os.IBinder;
import com.google.android.gms.internal.auth.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class zzj implements zzm<List<AccountChangeEvent>> {
    private final /* synthetic */ String zzu;
    private final /* synthetic */ int zzv;

    zzj(String str, int i) {
        this.zzu = str;
        this.zzv = i;
    }

    public final /* synthetic */ Object zze(IBinder iBinder) {
        AppMethodBeat.i(77076);
        List events = ((AccountChangeEventsResponse) zzg.zze(zzi.zzd(iBinder).zzd(new AccountChangeEventsRequest().setAccountName(this.zzu).setEventIndex(this.zzv)))).getEvents();
        AppMethodBeat.o(77076);
        return events;
    }
}
