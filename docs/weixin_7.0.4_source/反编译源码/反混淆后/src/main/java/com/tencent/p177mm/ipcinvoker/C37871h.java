package com.tencent.p177mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.ipcinvoker.h */
public class C37871h {
    private static volatile C37871h eGe;
    Map<String, BaseIPCService> eGf = new HashMap();

    private C37871h() {
        AppMethodBeat.m2504i(114042);
        AppMethodBeat.m2505o(114042);
    }

    /* renamed from: PO */
    public static C37871h m63909PO() {
        AppMethodBeat.m2504i(114043);
        if (eGe == null) {
            synchronized (C37871h.class) {
                try {
                    if (eGe == null) {
                        eGe = new C37871h();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(114043);
                    }
                }
            }
        }
        C37871h c37871h = eGe;
        AppMethodBeat.m2505o(114043);
        return c37871h;
    }

    /* renamed from: lj */
    public final BaseIPCService mo60593lj(String str) {
        AppMethodBeat.m2504i(114044);
        BaseIPCService baseIPCService = (BaseIPCService) this.eGf.get(str);
        AppMethodBeat.m2505o(114044);
        return baseIPCService;
    }
}
