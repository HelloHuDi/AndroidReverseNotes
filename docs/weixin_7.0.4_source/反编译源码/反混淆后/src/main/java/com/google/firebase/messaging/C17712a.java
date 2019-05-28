package com.google.firebase.messaging;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

/* renamed from: com.google.firebase.messaging.a */
public class C17712a {
    private static final Pattern bxa = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private static C17712a bxb;
    public final FirebaseInstanceId bwi;

    static {
        AppMethodBeat.m2504i(77208);
        AppMethodBeat.m2505o(77208);
    }

    private C17712a(FirebaseInstanceId firebaseInstanceId) {
        this.bwi = firebaseInstanceId;
    }

    /* renamed from: va */
    public static synchronized C17712a m27643va() {
        C17712a c17712a;
        synchronized (C17712a.class) {
            AppMethodBeat.m2504i(77207);
            if (bxb == null) {
                bxb = new C17712a(FirebaseInstanceId.m40567uD());
            }
            c17712a = bxb;
            AppMethodBeat.m2505o(77207);
        }
        return c17712a;
    }
}
