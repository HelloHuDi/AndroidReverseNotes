package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;

final class ag {
    final KeyPair bwM;
    final long bwN;

    @VisibleForTesting
    ag(KeyPair keyPair, long j) {
        this.bwM = keyPair;
        this.bwN = j;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(108813);
        if (obj instanceof ag) {
            ag agVar = (ag) obj;
            if (this.bwN == agVar.bwN && this.bwM.getPublic().equals(agVar.bwM.getPublic()) && this.bwM.getPrivate().equals(agVar.bwM.getPrivate())) {
                AppMethodBeat.o(108813);
                return true;
            }
            AppMethodBeat.o(108813);
            return false;
        }
        AppMethodBeat.o(108813);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(108814);
        int hashCode = Objects.hashCode(this.bwM.getPublic(), this.bwM.getPrivate(), Long.valueOf(this.bwN));
        AppMethodBeat.o(108814);
        return hashCode;
    }

    /* Access modifiers changed, original: final */
    public final String uW() {
        AppMethodBeat.i(108816);
        String encodeToString = Base64.encodeToString(this.bwM.getPrivate().getEncoded(), 11);
        AppMethodBeat.o(108816);
        return encodeToString;
    }

    /* Access modifiers changed, original: final */
    public final String zzq() {
        AppMethodBeat.i(108815);
        String encodeToString = Base64.encodeToString(this.bwM.getPublic().getEncoded(), 11);
        AppMethodBeat.o(108815);
        return encodeToString;
    }
}
