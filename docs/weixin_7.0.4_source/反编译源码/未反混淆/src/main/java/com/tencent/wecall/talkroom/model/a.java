package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.c;

public class a {
    private static a AIR = null;
    private f AIS = null;

    public static a dSQ() {
        AppMethodBeat.i(127764);
        if (AIR == null) {
            synchronized (a.class) {
                try {
                    if (AIR == null) {
                        AIR = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(127764);
                    }
                }
            }
        }
        a aVar = AIR;
        AppMethodBeat.o(127764);
        return aVar;
    }

    public static f dSR() {
        AppMethodBeat.i(127765);
        a dSQ = dSQ();
        if (dSQ.AIS == null) {
            synchronized (a.class) {
                try {
                    if (dSQ.AIS == null) {
                        dSQ.AIS = new f();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(127765);
                    }
                }
            }
        }
        f fVar = dSQ.AIS;
        AppMethodBeat.o(127765);
        return fVar;
    }

    public static void dSS() {
        AppMethodBeat.i(127766);
        c.d("MicroMsg.Voip", "registerEvents");
        dSR();
        AppMethodBeat.o(127766);
    }
}
