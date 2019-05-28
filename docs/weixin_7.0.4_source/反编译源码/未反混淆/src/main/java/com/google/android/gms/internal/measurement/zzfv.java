package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfv {
    private final long zzabj;
    private final /* synthetic */ zzfr zzakq;
    @VisibleForTesting
    private final String zzaks;
    private final String zzakt;
    private final String zzaku;

    private zzfv(zzfr zzfr, String str, long j) {
        this.zzakq = zzfr;
        AppMethodBeat.i(68966);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.zzaks = String.valueOf(str).concat(":start");
        this.zzakt = String.valueOf(str).concat(":count");
        this.zzaku = String.valueOf(str).concat(":value");
        this.zzabj = j;
        AppMethodBeat.o(68966);
    }

    /* synthetic */ zzfv(zzfr zzfr, String str, long j, zzfs zzfs) {
        this(zzfr, str, j);
    }

    private final void zzfh() {
        AppMethodBeat.i(68967);
        this.zzakq.zzab();
        long currentTimeMillis = this.zzakq.zzbt().currentTimeMillis();
        Editor edit = zzfr.zza(this.zzakq).edit();
        edit.remove(this.zzakt);
        edit.remove(this.zzaku);
        edit.putLong(this.zzaks, currentTimeMillis);
        edit.apply();
        AppMethodBeat.o(68967);
    }

    private final long zzfj() {
        AppMethodBeat.i(68970);
        long j = zzfr.zza(this.zzakq).getLong(this.zzaks, 0);
        AppMethodBeat.o(68970);
        return j;
    }

    public final void zzc(String str, long j) {
        AppMethodBeat.i(68968);
        this.zzakq.zzab();
        if (zzfj() == 0) {
            zzfh();
        }
        if (str == null) {
            str = "";
        }
        long j2 = zzfr.zza(this.zzakq).getLong(this.zzakt, 0);
        if (j2 <= 0) {
            Editor edit = zzfr.zza(this.zzakq).edit();
            edit.putString(this.zzaku, str);
            edit.putLong(this.zzakt, 1);
            edit.apply();
            AppMethodBeat.o(68968);
            return;
        }
        Object obj = (this.zzakq.zzgb().zzlc().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / (j2 + 1) ? 1 : null;
        Editor edit2 = zzfr.zza(this.zzakq).edit();
        if (obj != null) {
            edit2.putString(this.zzaku, str);
        }
        edit2.putLong(this.zzakt, j2 + 1);
        edit2.apply();
        AppMethodBeat.o(68968);
    }

    public final Pair<String, Long> zzfi() {
        AppMethodBeat.i(68969);
        this.zzakq.zzab();
        this.zzakq.zzab();
        long zzfj = zzfj();
        if (zzfj == 0) {
            zzfh();
            zzfj = 0;
        } else {
            zzfj = Math.abs(zzfj - this.zzakq.zzbt().currentTimeMillis());
        }
        if (zzfj < this.zzabj) {
            AppMethodBeat.o(68969);
            return null;
        } else if (zzfj > (this.zzabj << 1)) {
            zzfh();
            AppMethodBeat.o(68969);
            return null;
        } else {
            String string = zzfr.zza(this.zzakq).getString(this.zzaku, null);
            long j = zzfr.zza(this.zzakq).getLong(this.zzakt, 0);
            zzfh();
            Pair pair;
            if (string == null || j <= 0) {
                pair = zzfr.zzajs;
                AppMethodBeat.o(68969);
                return pair;
            }
            pair = new Pair(string, Long.valueOf(j));
            AppMethodBeat.o(68969);
            return pair;
        }
    }
}
