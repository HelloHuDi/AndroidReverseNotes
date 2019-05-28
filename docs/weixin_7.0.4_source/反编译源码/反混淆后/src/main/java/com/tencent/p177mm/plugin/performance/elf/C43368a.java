package com.tencent.p177mm.plugin.performance.elf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.performance.elf.a */
public final class C43368a {
    public static HashMap<Class, AbstractProcessChecker> cag = new HashMap();

    static {
        AppMethodBeat.m2504i(111068);
        AppMethodBeat.m2505o(111068);
    }

    /* renamed from: as */
    public static <T extends AbstractProcessChecker> T m77392as(Class<? extends AbstractProcessChecker> cls) {
        AppMethodBeat.m2504i(111067);
        AbstractProcessChecker abstractProcessChecker;
        if (cag.containsKey(cls)) {
            abstractProcessChecker = (AbstractProcessChecker) cag.get(cls);
            AppMethodBeat.m2505o(111067);
            return abstractProcessChecker;
        }
        try {
            abstractProcessChecker = (AbstractProcessChecker) cls.newInstance();
            cag.put(cls, abstractProcessChecker);
            AppMethodBeat.m2505o(111067);
            return abstractProcessChecker;
        } catch (IllegalAccessException | InstantiationException e) {
            AppMethodBeat.m2505o(111067);
            return null;
        }
    }
}
