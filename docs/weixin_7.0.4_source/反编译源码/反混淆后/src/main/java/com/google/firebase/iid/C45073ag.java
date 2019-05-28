package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;

/* renamed from: com.google.firebase.iid.ag */
final class C45073ag {
    final KeyPair bwM;
    final long bwN;

    @VisibleForTesting
    C45073ag(KeyPair keyPair, long j) {
        this.bwM = keyPair;
        this.bwN = j;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(108813);
        if (obj instanceof C45073ag) {
            C45073ag c45073ag = (C45073ag) obj;
            if (this.bwN == c45073ag.bwN && this.bwM.getPublic().equals(c45073ag.bwM.getPublic()) && this.bwM.getPrivate().equals(c45073ag.bwM.getPrivate())) {
                AppMethodBeat.m2505o(108813);
                return true;
            }
            AppMethodBeat.m2505o(108813);
            return false;
        }
        AppMethodBeat.m2505o(108813);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(108814);
        int hashCode = Objects.hashCode(this.bwM.getPublic(), this.bwM.getPrivate(), Long.valueOf(this.bwN));
        AppMethodBeat.m2505o(108814);
        return hashCode;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: uW */
    public final String mo72838uW() {
        AppMethodBeat.m2504i(108816);
        String encodeToString = Base64.encodeToString(this.bwM.getPrivate().getEncoded(), 11);
        AppMethodBeat.m2505o(108816);
        return encodeToString;
    }

    /* Access modifiers changed, original: final */
    public final String zzq() {
        AppMethodBeat.m2504i(108815);
        String encodeToString = Base64.encodeToString(this.bwM.getPublic().getEncoded(), 11);
        AppMethodBeat.m2505o(108815);
        return encodeToString;
    }
}
