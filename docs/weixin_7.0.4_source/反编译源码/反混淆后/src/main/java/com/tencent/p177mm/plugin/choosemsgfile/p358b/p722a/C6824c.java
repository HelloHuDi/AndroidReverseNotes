package com.tencent.p177mm.plugin.choosemsgfile.p358b.p722a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.choosemsgfile.compat.MsgFile;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.vending.p639e.C5684a;
import com.tencent.p177mm.vending.p639e.C5685b;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a.c */
public abstract class C6824c implements C5684a, Runnable {
    private static long ktV = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    private int frO;
    protected C11376a ktT;
    protected C11372a ktU;
    private boolean ktW = false;
    private Runnable ktX = new C68251();
    private int offset;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a.c$1 */
    class C68251 implements Runnable {
        C68251() {
        }

        public final void run() {
            AppMethodBeat.m2504i(54255);
            C6824c.this.ktW = true;
            if (C6824c.this.ktU != null) {
                C6824c.this.ktU.mo23107dK(C6824c.this.offset, C6824c.this.frO);
            }
            AppMethodBeat.m2505o(54255);
        }
    }

    public abstract boolean bfh();

    public abstract void bfi();

    public abstract boolean checkValid();

    public C6824c(C11376a c11376a, C11372a c11372a, C5685b c5685b) {
        this.ktT = c11376a;
        this.ktU = c11372a;
        if (c5685b != null) {
            c5685b.keep(this);
        }
    }

    public void dead() {
    }

    public void run() {
        C5004al.m7442n(this.ktX, ktV);
        bfi();
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    /* renamed from: b */
    public final synchronized void mo15093b(MsgFile msgFile) {
        C4990ab.m7417i("MicroMsg.MsgFileWorker_Base", "onDownloadSuccess msgFile:%s", msgFile);
        if (this.ktU != null) {
            this.ktU.mo23103a(msgFile);
            this.ktU = null;
        }
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void bfj() {
        C4990ab.m7416i("MicroMsg.MsgFileWorker_Base", "onDownloadStop");
        if (this.ktU != null) {
            this.ktU.bff();
            this.ktU = null;
        }
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void bfk() {
        C4990ab.m7416i("MicroMsg.MsgFileWorker_Base", "onDownloadFail");
        if (this.ktU != null) {
            this.ktU.bfe();
            this.ktU = null;
        }
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    /* renamed from: dL */
    public final synchronized void mo15099dL(int i, int i2) {
        C4990ab.m7419v("MicroMsg.MsgFileWorker_Base", "onDownloadProgress offset:%d totalLen:%d", Integer.valueOf(i), Integer.valueOf(i2));
        this.offset = i;
        this.frO = i2;
        if (this.ktW && this.ktU != null) {
            this.ktU.mo23107dK(i, i2);
        }
    }

    public String toString() {
        return "MsgFileWorker_Base{mMsgItem=" + this.ktT + '}';
    }
}
