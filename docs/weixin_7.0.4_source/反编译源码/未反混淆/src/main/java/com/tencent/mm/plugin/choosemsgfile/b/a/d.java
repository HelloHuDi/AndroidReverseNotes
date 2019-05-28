package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.b.e;
import com.tencent.mm.plugin.choosemsgfile.b.b.j;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vending.e.b;

public final class d extends c {
    private int Lp = 0;
    private int alq;
    private ap gyS;

    static /* synthetic */ void c(d dVar) {
        AppMethodBeat.i(54261);
        dVar.wM();
        AppMethodBeat.o(54261);
    }

    public d(a aVar, a aVar2, b bVar) {
        super(aVar, aVar2, bVar);
        AppMethodBeat.i(54257);
        this.alq = aVar.bfp();
        AppMethodBeat.o(54257);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bfh() {
        AppMethodBeat.i(54258);
        if (bfl()) {
            wM();
        }
        boolean bfl = bfl();
        AppMethodBeat.o(54258);
        return bfl;
    }

    private boolean bfl() {
        if (this.ktT instanceof j) {
            return ((j) this.ktT).kuq;
        }
        if (this.ktT instanceof e) {
            return ((e) this.ktT).kuq;
        }
        return false;
    }

    private void wM() {
        AppMethodBeat.i(54260);
        if (bfm()) {
            MsgFile msgFile = new MsgFile();
            msgFile.fileSize = this.ktT.bfp();
            msgFile.filePath = "only for test";
            msgFile.fileName = this.ktT.getFileName() + "." + msgFile.eov;
            msgFile.type = "file";
            msgFile.eov = this.ktT.bfo();
            msgFile.timeStamp = this.ktT.getTimeStamp();
            b(msgFile);
            AppMethodBeat.o(54260);
            return;
        }
        bfk();
        AppMethodBeat.o(54260);
    }

    private boolean bfm() {
        if (this.ktT instanceof j) {
            return ((j) this.ktT).kus;
        }
        if (this.ktT instanceof e) {
            return ((e) this.ktT).kus;
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean checkValid() {
        if (this.ktT instanceof j) {
            return ((j) this.ktT).kup;
        }
        if (this.ktT instanceof e) {
            return ((e) this.ktT).kup;
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bfi() {
        boolean z;
        AppMethodBeat.i(54259);
        if (this.ktT instanceof j) {
            z = ((j) this.ktT).kur;
        } else if (this.ktT instanceof e) {
            z = ((e) this.ktT).kur;
        } else {
            z = false;
        }
        if (z) {
            long j;
            if (this.gyS == null) {
                this.gyS = new ap(g.RS().oAl.getLooper(), new ap.a() {
                    public final boolean BI() {
                        AppMethodBeat.i(54256);
                        d.this.Lp = d.this.Lp + 1048576;
                        if (d.this.Lp > d.this.alq) {
                            d.this.Lp = d.this.alq;
                        }
                        d.this.dL(d.this.Lp, d.this.alq);
                        if (d.this.Lp == d.this.alq) {
                            d.c(d.this);
                            d.this.gyS.stopTimer();
                            d.this.gyS = null;
                        }
                        AppMethodBeat.o(54256);
                        return true;
                    }
                }, true);
            }
            ap apVar = this.gyS;
            if (this.ktT instanceof j) {
                j = ((j) this.ktT).kut;
            } else if (this.ktT instanceof e) {
                j = ((e) this.ktT).kut;
            } else {
                j = 1000;
            }
            apVar.ae(j, j);
            AppMethodBeat.o(54259);
            return;
        }
        wM();
        AppMethodBeat.o(54259);
    }
}
