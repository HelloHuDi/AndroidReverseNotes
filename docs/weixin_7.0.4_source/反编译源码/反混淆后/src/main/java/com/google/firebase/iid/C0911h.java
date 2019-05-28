package com.google.firebase.iid;

import com.google.firebase.components.C41647d;
import com.google.firebase.components.C45069b;
import com.google.firebase.iid.Registrar.C44652a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.iid.h */
final /* synthetic */ class C0911h implements C41647d {
    static final C41647d bvI = new C0911h();

    static {
        AppMethodBeat.m2504i(108727);
        AppMethodBeat.m2505o(108727);
    }

    private C0911h() {
    }

    /* renamed from: a */
    public final Object mo3695a(C45069b c45069b) {
        AppMethodBeat.m2504i(108726);
        C44652a c44652a = new C44652a((FirebaseInstanceId) c45069b.mo19762x(FirebaseInstanceId.class));
        AppMethodBeat.m2505o(108726);
        return c44652a;
    }
}
