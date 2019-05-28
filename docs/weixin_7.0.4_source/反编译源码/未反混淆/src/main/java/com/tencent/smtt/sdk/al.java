package com.tencent.smtt.sdk;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

class al extends HandlerThread {
    private static al a;

    public al(String str) {
        super(str);
    }

    public static synchronized al a() {
        al alVar;
        synchronized (al.class) {
            AppMethodBeat.i(64390);
            if (a == null) {
                alVar = new al("TbsHandlerThread");
                a = alVar;
                alVar.start();
            }
            alVar = a;
            AppMethodBeat.o(64390);
        }
        return alVar;
    }
}
