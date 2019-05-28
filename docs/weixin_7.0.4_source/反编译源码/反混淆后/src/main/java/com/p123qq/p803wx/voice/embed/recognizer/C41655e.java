package com.p123qq.p803wx.voice.embed.recognizer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;

/* renamed from: com.qq.wx.voice.embed.recognizer.e */
public final class C41655e {
    C37310g bCA;
    public Grammar bCz;
    /* renamed from: c */
    byte[] f16878c;
    /* renamed from: d */
    public boolean f16879d;
    /* renamed from: e */
    public boolean f16880e;

    /* renamed from: com.qq.wx.voice.embed.recognizer.e$a */
    class C8750a implements Runnable {
        private C8750a() {
        }

        /* synthetic */ C8750a(C41655e c41655e, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(123210);
            if (C41655e.this.bCz.begin() != 0) {
                C41655e.this.bCA.mo60016a(ZipJNI.UNZ_PARAMERROR);
                AppMethodBeat.m2505o(123210);
            } else if (C41655e.this.bCz.recognize(C41655e.this.f16878c, C41655e.this.f16878c.length) != 0) {
                C41655e.this.bCA.mo60016a(ZipJNI.UNZ_BADZIPFILE);
                AppMethodBeat.m2505o(123210);
            } else if (C41655e.this.bCz.end() != 0) {
                C41655e.this.bCA.mo60016a(ZipJNI.UNZ_INTERNALERROR);
                AppMethodBeat.m2505o(123210);
            } else {
                C25590a c25590a = new C25590a();
                if (C41655e.this.bCz.getResult(c25590a) != 0) {
                    C41655e.this.bCA.mo60016a(ZipJNI.UNZ_CRCERROR);
                }
                C37310g c37310g = C41655e.this.bCA;
                c37310g.f15850b.sendMessage(c37310g.f15850b.obtainMessage(200, c25590a));
                AppMethodBeat.m2505o(123210);
            }
        }
    }

    public C41655e() {
        AppMethodBeat.m2504i(123211);
        this.bCz = null;
        this.bCA = new C37310g();
        this.f16878c = null;
        this.f16879d = false;
        this.f16880e = false;
        this.bCz = new Grammar();
        AppMethodBeat.m2505o(123211);
    }

    /* renamed from: a */
    public final int mo67126a(C25591c c25591c, byte[] bArr) {
        AppMethodBeat.m2504i(123212);
        if (!this.f16879d) {
            AppMethodBeat.m2505o(123212);
            return -304;
        } else if (this.f16880e) {
            this.bCA.bCB = c25591c;
            this.f16878c = bArr;
            if (this.f16878c == null) {
                AppMethodBeat.m2505o(123212);
                return -301;
            }
            try {
                new Thread(new C8750a(this, (byte) 0)).start();
                AppMethodBeat.m2505o(123212);
                return 0;
            } catch (Exception e) {
                AppMethodBeat.m2505o(123212);
                return -302;
            }
        } else {
            AppMethodBeat.m2505o(123212);
            return -302;
        }
    }
}
