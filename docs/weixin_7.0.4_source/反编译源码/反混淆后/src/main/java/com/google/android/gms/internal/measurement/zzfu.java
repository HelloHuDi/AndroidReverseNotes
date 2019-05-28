package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfu {
    private long value;
    private boolean zzakp;
    private final /* synthetic */ zzfr zzakq;
    private final long zzakr;
    private final String zzny;

    public zzfu(zzfr zzfr, String str, long j) {
        this.zzakq = zzfr;
        AppMethodBeat.m2504i(68963);
        Preconditions.checkNotEmpty(str);
        this.zzny = str;
        this.zzakr = j;
        AppMethodBeat.m2505o(68963);
    }

    public final long get() {
        AppMethodBeat.m2504i(68964);
        if (!this.zzakp) {
            this.zzakp = true;
            this.value = zzfr.zza(this.zzakq).getLong(this.zzny, this.zzakr);
        }
        long j = this.value;
        AppMethodBeat.m2505o(68964);
        return j;
    }

    public final void set(long j) {
        AppMethodBeat.m2504i(68965);
        Editor edit = zzfr.zza(this.zzakq).edit();
        edit.putLong(this.zzny, j);
        edit.apply();
        this.value = j;
        AppMethodBeat.m2505o(68965);
    }
}
