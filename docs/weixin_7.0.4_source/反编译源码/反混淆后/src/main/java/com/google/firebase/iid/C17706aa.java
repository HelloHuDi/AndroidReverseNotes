package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.iid.aa */
final /* synthetic */ class C17706aa implements C37307l {
    private final FirebaseInstanceId bwE;
    private final String bwF;
    private final String bwG;

    C17706aa(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.bwE = firebaseInstanceId;
        this.bwF = str;
        this.bwG = str2;
    }

    public final String zzp() {
        AppMethodBeat.m2504i(108793);
        FirebaseInstanceId firebaseInstanceId = this.bwE;
        String str = this.bwF;
        String str2 = this.bwG;
        String str3 = (String) FirebaseInstanceId.m40565a(firebaseInstanceId.bvu.mo52659q(str, str2));
        FirebaseInstanceId.bvq.mo19768b("", str, str2, str3, firebaseInstanceId.bvt.mo52664uO());
        AppMethodBeat.m2505o(108793);
        return str3;
    }
}
