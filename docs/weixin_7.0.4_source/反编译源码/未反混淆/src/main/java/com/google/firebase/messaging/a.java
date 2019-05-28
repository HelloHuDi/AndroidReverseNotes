package com.google.firebase.messaging;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public class a {
    private static final Pattern bxa = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private static a bxb;
    public final FirebaseInstanceId bwi;

    static {
        AppMethodBeat.i(77208);
        AppMethodBeat.o(77208);
    }

    private a(FirebaseInstanceId firebaseInstanceId) {
        this.bwi = firebaseInstanceId;
    }

    public static synchronized a va() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(77207);
            if (bxb == null) {
                bxb = new a(FirebaseInstanceId.uD());
            }
            aVar = bxb;
            AppMethodBeat.o(77207);
        }
        return aVar;
    }
}
