package com.tencent.p177mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.app.p */
public final class C1261p {
    private static final Set<String> cfe;

    static {
        AppMethodBeat.m2504i(137979);
        HashSet hashSet = new HashSet();
        cfe = hashSet;
        hashSet.add(":nospace");
        cfe.add(":cuploader");
        cfe.add(":dexopt");
        cfe.add(":recovery");
        cfe.add(":fallback");
        AppMethodBeat.m2505o(137979);
    }

    /* renamed from: By */
    public static boolean m2700By() {
        return false;
    }

    /* renamed from: cX */
    public static boolean m2701cX(String str) {
        Object substring;
        AppMethodBeat.m2504i(137978);
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            substring = str.substring(indexOf);
        } else {
            substring = "";
        }
        boolean contains = cfe.contains(substring);
        AppMethodBeat.m2505o(137978);
        return contains;
    }
}
