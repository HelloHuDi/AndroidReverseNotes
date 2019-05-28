package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;

/* renamed from: com.tencent.wecall.talkroom.model.a */
public class C41112a {
    private static C41112a AIR = null;
    private C24507f AIS = null;

    public static C41112a dSQ() {
        AppMethodBeat.m2504i(127764);
        if (AIR == null) {
            synchronized (C41112a.class) {
                try {
                    if (AIR == null) {
                        AIR = new C41112a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(127764);
                    }
                }
            }
        }
        C41112a c41112a = AIR;
        AppMethodBeat.m2505o(127764);
        return c41112a;
    }

    public static C24507f dSR() {
        AppMethodBeat.m2504i(127765);
        C41112a dSQ = C41112a.dSQ();
        if (dSQ.AIS == null) {
            synchronized (C41112a.class) {
                try {
                    if (dSQ.AIS == null) {
                        dSQ.AIS = new C24507f();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(127765);
                    }
                }
            }
        }
        C24507f c24507f = dSQ.AIS;
        AppMethodBeat.m2505o(127765);
        return c24507f;
    }

    public static void dSS() {
        AppMethodBeat.m2504i(127766);
        C44443c.m80389d("MicroMsg.Voip", "registerEvents");
        C41112a.dSR();
        AppMethodBeat.m2505o(127766);
    }
}
