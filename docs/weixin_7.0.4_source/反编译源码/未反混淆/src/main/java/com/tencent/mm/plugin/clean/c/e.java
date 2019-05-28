package com.tencent.mm.plugin.clean.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bi;
import java.io.File;
import java.util.ArrayList;

public final class e extends Thread implements com.tencent.mm.plugin.clean.c.a.a.a {
    private long endTime = 0;
    private ak fbD = new ak(Looper.getMainLooper());
    private boolean isStop;
    private ArrayList<a> kwA;
    private int kwB = 0;
    private b kwh;
    private int kwj = 0;
    private int kwk = 0;
    private h kwz;
    private long startTime = 0;

    class a extends com.tencent.mm.plugin.clean.c.a.a {
        private a kwD;

        public a(a aVar) {
            super(e.this);
            this.kwD = aVar;
        }

        public final void execute() {
            AppMethodBeat.i(18702);
            aw.ZK();
            bi jf = c.XO().jf(this.kwD.cuQ);
            if (jf.field_msgId != 0) {
                jf.dtI();
                aw.ZK();
                c.XO().a(this.kwD.cuQ, jf);
            }
            File file = new File(this.kwD.filePath);
            e.this.kwB = (int) (((long) e.this.kwB) + file.length());
            file.delete();
            AppMethodBeat.o(18702);
        }
    }

    public e(b bVar, h hVar, ArrayList<a> arrayList) {
        AppMethodBeat.i(18703);
        this.kwh = bVar;
        this.kwz = hVar;
        this.kwA = arrayList;
        AppMethodBeat.o(18703);
    }

    public final void run() {
        AppMethodBeat.i(18704);
        this.startTime = System.currentTimeMillis();
        this.kwj = this.kwA.size();
        ab.d("MicroMsg.DeleteFileController", "totalTaskCount=%d", Integer.valueOf(this.kwj));
        if (this.kwj == 0) {
            bfJ();
            AppMethodBeat.o(18704);
            return;
        }
        int i = 0;
        while (!this.isStop && i < this.kwA.size()) {
            ab.d("MicroMsg.DeleteFileController", "while loop index=%d | filePath=%s", Integer.valueOf(i), ((a) this.kwA.get(i)).filePath);
            a aVar = new a(r0);
            while (!this.kwh.b(aVar)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            ab.d("MicroMsg.DeleteFileController", "Start task： filePath＝%s", r0.filePath);
            i++;
        }
        AppMethodBeat.o(18704);
    }

    private void bfJ() {
        AppMethodBeat.i(18705);
        this.endTime = System.currentTimeMillis();
        ab.i("MicroMsg.DeleteFileController", "totalUserTime:%d", Long.valueOf(bfK()));
        if (!(this.kwz == null || this.isStop)) {
            this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18701);
                    e.this.kwz.hi((long) e.this.kwB);
                    AppMethodBeat.o(18701);
                }
            });
        }
        AppMethodBeat.o(18705);
    }

    private long bfK() {
        return this.endTime - this.startTime;
    }

    public final void bgb() {
        AppMethodBeat.i(18706);
        ab.i("MicroMsg.DeleteFileController", "stop analyseController");
        this.isStop = true;
        interrupt();
        AppMethodBeat.o(18706);
    }

    public final void a(com.tencent.mm.plugin.clean.c.a.a aVar) {
        AppMethodBeat.i(18707);
        interrupt();
        this.kwk++;
        if (!(this.kwz == null || this.isStop)) {
            this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18700);
                    e.this.kwz.dP(e.this.kwk, e.this.kwj);
                    AppMethodBeat.o(18700);
                }
            });
        }
        if (this.kwk == this.kwj) {
            bfJ();
        }
        AppMethodBeat.o(18707);
    }
}
