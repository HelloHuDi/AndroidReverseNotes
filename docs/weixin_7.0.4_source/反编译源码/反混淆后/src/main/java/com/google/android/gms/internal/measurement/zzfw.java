package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfw {
    private String value;
    private boolean zzakp;
    private final /* synthetic */ zzfr zzakq;
    private final String zzakv = null;
    private final String zzny;

    public zzfw(zzfr zzfr, String str, String str2) {
        this.zzakq = zzfr;
        AppMethodBeat.m2504i(68971);
        Preconditions.checkNotEmpty(str);
        this.zzny = str;
        AppMethodBeat.m2505o(68971);
    }

    public final void zzbs(String str) {
        AppMethodBeat.m2504i(68973);
        if (zzka.zzs(str, this.value)) {
            AppMethodBeat.m2505o(68973);
            return;
        }
        Editor edit = zzfr.zza(this.zzakq).edit();
        edit.putString(this.zzny, str);
        edit.apply();
        this.value = str;
        AppMethodBeat.m2505o(68973);
    }

    public final String zzjg() {
        AppMethodBeat.m2504i(68972);
        if (!this.zzakp) {
            this.zzakp = true;
            this.value = zzfr.zza(this.zzakq).getString(this.zzny, null);
        }
        String str = this.value;
        AppMethodBeat.m2505o(68972);
        return str;
    }
}
