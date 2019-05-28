package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public abstract class c implements a, Runnable {
    private static long ktV = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    private int frO;
    protected com.tencent.mm.plugin.choosemsgfile.b.b.a ktT;
    protected a ktU;
    private boolean ktW = false;
    private Runnable ktX = new Runnable() {
        public final void run() {
            AppMethodBeat.i(54255);
            c.this.ktW = true;
            if (c.this.ktU != null) {
                c.this.ktU.dK(c.this.offset, c.this.frO);
            }
            AppMethodBeat.o(54255);
        }
    };
    private int offset;

    public abstract boolean bfh();

    public abstract void bfi();

    public abstract boolean checkValid();

    public c(com.tencent.mm.plugin.choosemsgfile.b.b.a aVar, a aVar2, b bVar) {
        this.ktT = aVar;
        this.ktU = aVar2;
        if (bVar != null) {
            bVar.keep(this);
        }
    }

    public void dead() {
    }

    public void run() {
        al.n(this.ktX, ktV);
        bfi();
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void b(MsgFile msgFile) {
        ab.i("MicroMsg.MsgFileWorker_Base", "onDownloadSuccess msgFile:%s", msgFile);
        if (this.ktU != null) {
            this.ktU.a(msgFile);
            this.ktU = null;
        }
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void bfj() {
        ab.i("MicroMsg.MsgFileWorker_Base", "onDownloadStop");
        if (this.ktU != null) {
            this.ktU.bff();
            this.ktU = null;
        }
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void bfk() {
        ab.i("MicroMsg.MsgFileWorker_Base", "onDownloadFail");
        if (this.ktU != null) {
            this.ktU.bfe();
            this.ktU = null;
        }
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void dL(int i, int i2) {
        ab.v("MicroMsg.MsgFileWorker_Base", "onDownloadProgress offset:%d totalLen:%d", Integer.valueOf(i), Integer.valueOf(i2));
        this.offset = i;
        this.frO = i2;
        if (this.ktW && this.ktU != null) {
            this.ktU.dK(i, i2);
        }
    }

    public String toString() {
        return "MsgFileWorker_Base{mMsgItem=" + this.ktT + '}';
    }
}
