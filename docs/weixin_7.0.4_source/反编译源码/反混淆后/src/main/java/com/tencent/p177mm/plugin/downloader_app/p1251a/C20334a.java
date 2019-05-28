package com.tencent.p177mm.plugin.downloader_app.p1251a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.downloader_app.a.a */
public interface C20334a {

    /* renamed from: com.tencent.mm.plugin.downloader_app.a.a$a */
    public enum C20331a {
        OK,
        FAIL,
        WAIT_FOR_WIFI,
        CANCEL;

        static {
            AppMethodBeat.m2505o(35545);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.a.a$b */
    public interface C20332b {
        /* renamed from: a */
        void mo9713a(C20331a c20331a, long j);
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.a.a$c */
    public interface C20333c {
        void biB();
    }
}
