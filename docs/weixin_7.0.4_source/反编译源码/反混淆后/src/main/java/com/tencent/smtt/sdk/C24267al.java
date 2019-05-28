package com.tencent.smtt.sdk;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.al */
class C24267al extends HandlerThread {
    /* renamed from: a */
    private static C24267al f4519a;

    public C24267al(String str) {
        super(str);
    }

    /* renamed from: a */
    public static synchronized C24267al m37429a() {
        C24267al c24267al;
        synchronized (C24267al.class) {
            AppMethodBeat.m2504i(64390);
            if (f4519a == null) {
                c24267al = new C24267al("TbsHandlerThread");
                f4519a = c24267al;
                c24267al.start();
            }
            c24267al = f4519a;
            AppMethodBeat.m2505o(64390);
        }
        return c24267al;
    }
}
