package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class aa implements l {
    private final FirebaseInstanceId bwE;
    private final String bwF;
    private final String bwG;

    aa(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.bwE = firebaseInstanceId;
        this.bwF = str;
        this.bwG = str2;
    }

    public final String zzp() {
        AppMethodBeat.i(108793);
        FirebaseInstanceId firebaseInstanceId = this.bwE;
        String str = this.bwF;
        String str2 = this.bwG;
        String str3 = (String) FirebaseInstanceId.a(firebaseInstanceId.bvu.q(str, str2));
        FirebaseInstanceId.bvq.b("", str, str2, str3, firebaseInstanceId.bvt.uO());
        AppMethodBeat.o(108793);
        return str3;
    }
}
