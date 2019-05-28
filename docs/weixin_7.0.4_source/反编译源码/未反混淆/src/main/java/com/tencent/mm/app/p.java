package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class p {
    private static final Set<String> cfe;

    static {
        AppMethodBeat.i(137979);
        HashSet hashSet = new HashSet();
        cfe = hashSet;
        hashSet.add(":nospace");
        cfe.add(":cuploader");
        cfe.add(":dexopt");
        cfe.add(":recovery");
        cfe.add(":fallback");
        AppMethodBeat.o(137979);
    }

    public static boolean By() {
        return false;
    }

    public static boolean cX(String str) {
        Object substring;
        AppMethodBeat.i(137978);
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            substring = str.substring(indexOf);
        } else {
            substring = "";
        }
        boolean contains = cfe.contains(substring);
        AppMethodBeat.o(137978);
        return contains;
    }
}
