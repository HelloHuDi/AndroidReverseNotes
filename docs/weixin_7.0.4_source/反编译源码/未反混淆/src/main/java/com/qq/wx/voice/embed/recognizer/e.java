package com.qq.wx.voice.embed.recognizer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;

public final class e {
    g bCA;
    public Grammar bCz;
    byte[] c;
    public boolean d;
    public boolean e;

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(123210);
            if (e.this.bCz.begin() != 0) {
                e.this.bCA.a(ZipJNI.UNZ_PARAMERROR);
                AppMethodBeat.o(123210);
            } else if (e.this.bCz.recognize(e.this.c, e.this.c.length) != 0) {
                e.this.bCA.a(ZipJNI.UNZ_BADZIPFILE);
                AppMethodBeat.o(123210);
            } else if (e.this.bCz.end() != 0) {
                e.this.bCA.a(ZipJNI.UNZ_INTERNALERROR);
                AppMethodBeat.o(123210);
            } else {
                a aVar = new a();
                if (e.this.bCz.getResult(aVar) != 0) {
                    e.this.bCA.a(ZipJNI.UNZ_CRCERROR);
                }
                g gVar = e.this.bCA;
                gVar.b.sendMessage(gVar.b.obtainMessage(200, aVar));
                AppMethodBeat.o(123210);
            }
        }
    }

    public e() {
        AppMethodBeat.i(123211);
        this.bCz = null;
        this.bCA = new g();
        this.c = null;
        this.d = false;
        this.e = false;
        this.bCz = new Grammar();
        AppMethodBeat.o(123211);
    }

    public final int a(c cVar, byte[] bArr) {
        AppMethodBeat.i(123212);
        if (!this.d) {
            AppMethodBeat.o(123212);
            return -304;
        } else if (this.e) {
            this.bCA.bCB = cVar;
            this.c = bArr;
            if (this.c == null) {
                AppMethodBeat.o(123212);
                return -301;
            }
            try {
                new Thread(new a(this, (byte) 0)).start();
                AppMethodBeat.o(123212);
                return 0;
            } catch (Exception e) {
                AppMethodBeat.o(123212);
                return -302;
            }
        } else {
            AppMethodBeat.o(123212);
            return -302;
        }
    }
}
