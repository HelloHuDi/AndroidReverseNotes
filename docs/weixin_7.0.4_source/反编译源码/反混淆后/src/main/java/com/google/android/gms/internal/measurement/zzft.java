package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzft {
    private boolean value;
    private final boolean zzako = true;
    private boolean zzakp;
    private final /* synthetic */ zzfr zzakq;
    private final String zzny;

    public zzft(zzfr zzfr, String str, boolean z) {
        this.zzakq = zzfr;
        AppMethodBeat.m2504i(68960);
        Preconditions.checkNotEmpty(str);
        this.zzny = str;
        AppMethodBeat.m2505o(68960);
    }

    public final boolean get() {
        AppMethodBeat.m2504i(68961);
        if (!this.zzakp) {
            this.zzakp = true;
            this.value = zzfr.zza(this.zzakq).getBoolean(this.zzny, this.zzako);
        }
        boolean z = this.value;
        AppMethodBeat.m2505o(68961);
        return z;
    }

    public final void set(boolean z) {
        AppMethodBeat.m2504i(68962);
        Editor edit = zzfr.zza(this.zzakq).edit();
        edit.putBoolean(this.zzny, z);
        edit.apply();
        this.value = z;
        AppMethodBeat.m2505o(68962);
    }
}
