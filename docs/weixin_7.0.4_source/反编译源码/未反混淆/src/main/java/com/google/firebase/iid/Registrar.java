package com.google.firebase.iid;

import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.e;
import com.google.firebase.components.f;
import com.google.firebase.components.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
public final class Registrar implements e {

    static class a implements com.google.firebase.iid.a.a {
        private final FirebaseInstanceId bvB;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.bvB = firebaseInstanceId;
        }
    }

    @Keep
    public final List<com.google.firebase.components.a<?>> getComponents() {
        AppMethodBeat.i(108712);
        com.google.firebase.components.a.a a = com.google.firebase.components.a.y(FirebaseInstanceId.class).a(f.A(com.google.firebase.a.class)).a(g.bvI);
        r.c(a.zzad == 0, "Instantiation type has already been set.");
        a.zzad = 1;
        com.google.firebase.components.a uA = a.uA();
        com.google.firebase.components.a uA2 = com.google.firebase.components.a.y(com.google.firebase.iid.a.a.class).a(f.A(FirebaseInstanceId.class)).a(h.bvI).uA();
        List asList = Arrays.asList(new com.google.firebase.components.a[]{uA, uA2});
        AppMethodBeat.o(108712);
        return asList;
    }
}
