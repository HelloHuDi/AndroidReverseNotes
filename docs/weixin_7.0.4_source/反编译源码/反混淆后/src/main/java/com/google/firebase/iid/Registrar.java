package com.google.firebase.iid;

import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.C41642a;
import com.google.firebase.components.C25581f;
import com.google.firebase.components.C32092r;
import com.google.firebase.components.C41645a;
import com.google.firebase.components.C41645a.C8742a;
import com.google.firebase.components.C41648e;
import com.google.firebase.iid.p1448a.C32093a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
public final class Registrar implements C41648e {

    /* renamed from: com.google.firebase.iid.Registrar$a */
    static class C44652a implements C32093a {
        private final FirebaseInstanceId bvB;

        public C44652a(FirebaseInstanceId firebaseInstanceId) {
            this.bvB = firebaseInstanceId;
        }
    }

    @Keep
    public final List<C41645a<?>> getComponents() {
        AppMethodBeat.m2504i(108712);
        C8742a a = C41645a.m73015y(FirebaseInstanceId.class).mo19759a(C25581f.m40563A(C41642a.class)).mo19758a(C0910g.bvI);
        C32092r.m52219c(a.zzad == 0, "Instantiation type has already been set.");
        a.zzad = 1;
        C41645a uA = a.mo19760uA();
        C41645a uA2 = C41645a.m73015y(C32093a.class).mo19759a(C25581f.m40563A(FirebaseInstanceId.class)).mo19758a(C0911h.bvI).mo19760uA();
        List asList = Arrays.asList(new C41645a[]{uA, uA2});
        AppMethodBeat.m2505o(108712);
        return asList;
    }
}
