package com.tencent.mm.plugin.performance.elf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a {
    public static HashMap<Class, AbstractProcessChecker> cag = new HashMap();

    static {
        AppMethodBeat.i(111068);
        AppMethodBeat.o(111068);
    }

    public static <T extends AbstractProcessChecker> T as(Class<? extends AbstractProcessChecker> cls) {
        AppMethodBeat.i(111067);
        AbstractProcessChecker abstractProcessChecker;
        if (cag.containsKey(cls)) {
            abstractProcessChecker = (AbstractProcessChecker) cag.get(cls);
            AppMethodBeat.o(111067);
            return abstractProcessChecker;
        }
        try {
            abstractProcessChecker = (AbstractProcessChecker) cls.newInstance();
            cag.put(cls, abstractProcessChecker);
            AppMethodBeat.o(111067);
            return abstractProcessChecker;
        } catch (IllegalAccessException | InstantiationException e) {
            AppMethodBeat.o(111067);
            return null;
        }
    }
}
