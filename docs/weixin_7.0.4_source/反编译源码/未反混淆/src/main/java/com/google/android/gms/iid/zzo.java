package com.google.android.gms.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;

final class zzo {
    private final KeyPair zzbw;
    private final long zzbx;

    @VisibleForTesting
    zzo(KeyPair keyPair, long j) {
        this.zzbw = keyPair;
        this.zzbx = j;
    }

    static /* synthetic */ String zzd(zzo zzo) {
        AppMethodBeat.i(57596);
        String zzo2 = zzo.zzo();
        AppMethodBeat.o(57596);
        return zzo2;
    }

    static /* synthetic */ String zze(zzo zzo) {
        AppMethodBeat.i(57597);
        String zzp = zzo.zzp();
        AppMethodBeat.o(57597);
        return zzp;
    }

    private final String zzo() {
        AppMethodBeat.i(57594);
        String encodeToString = Base64.encodeToString(this.zzbw.getPublic().getEncoded(), 11);
        AppMethodBeat.o(57594);
        return encodeToString;
    }

    private final String zzp() {
        AppMethodBeat.i(57595);
        String encodeToString = Base64.encodeToString(this.zzbw.getPrivate().getEncoded(), 11);
        AppMethodBeat.o(57595);
        return encodeToString;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(57592);
        if (obj instanceof zzo) {
            zzo zzo = (zzo) obj;
            if (this.zzbx == zzo.zzbx && this.zzbw.getPublic().equals(zzo.zzbw.getPublic()) && this.zzbw.getPrivate().equals(zzo.zzbw.getPrivate())) {
                AppMethodBeat.o(57592);
                return true;
            }
            AppMethodBeat.o(57592);
            return false;
        }
        AppMethodBeat.o(57592);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final long getCreationTime() {
        return this.zzbx;
    }

    /* Access modifiers changed, original: final */
    public final KeyPair getKeyPair() {
        return this.zzbw;
    }

    public final int hashCode() {
        AppMethodBeat.i(57593);
        int hashCode = Objects.hashCode(this.zzbw.getPublic(), this.zzbw.getPrivate(), Long.valueOf(this.zzbx));
        AppMethodBeat.o(57593);
        return hashCode;
    }
}
