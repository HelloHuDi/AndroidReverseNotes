package com.tencent.p177mm.plugin.clean.p362c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.clean.p362c.p363a.C11387b;
import com.tencent.p177mm.plugin.clean.p362c.p363a.C33819a;
import com.tencent.p177mm.plugin.clean.p362c.p363a.C33819a.C33820a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.clean.c.e */
public final class C41261e extends Thread implements C33820a {
    private long endTime = 0;
    private C7306ak fbD = new C7306ak(Looper.getMainLooper());
    private boolean isStop;
    private ArrayList<C11389a> kwA;
    private int kwB = 0;
    private C11387b kwh;
    private int kwj = 0;
    private int kwk = 0;
    private C33824h kwz;
    private long startTime = 0;

    /* renamed from: com.tencent.mm.plugin.clean.c.e$a */
    class C11390a extends C33819a {
        private C11389a kwD;

        public C11390a(C11389a c11389a) {
            super(C41261e.this);
            this.kwD = c11389a;
        }

        public final void execute() {
            AppMethodBeat.m2504i(18702);
            C9638aw.m17190ZK();
            C7620bi jf = C18628c.m29080XO().mo15340jf(this.kwD.cuQ);
            if (jf.field_msgId != 0) {
                jf.dtI();
                C9638aw.m17190ZK();
                C18628c.m29080XO().mo15284a(this.kwD.cuQ, jf);
            }
            File file = new File(this.kwD.filePath);
            C41261e.this.kwB = (int) (((long) C41261e.this.kwB) + file.length());
            file.delete();
            AppMethodBeat.m2505o(18702);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.c.e$1 */
    class C387971 implements Runnable {
        C387971() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18700);
            C41261e.this.kwz.mo23158dP(C41261e.this.kwk, C41261e.this.kwj);
            AppMethodBeat.m2505o(18700);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.c.e$2 */
    class C412622 implements Runnable {
        C412622() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18701);
            C41261e.this.kwz.mo23159hi((long) C41261e.this.kwB);
            AppMethodBeat.m2505o(18701);
        }
    }

    public C41261e(C11387b c11387b, C33824h c33824h, ArrayList<C11389a> arrayList) {
        AppMethodBeat.m2504i(18703);
        this.kwh = c11387b;
        this.kwz = c33824h;
        this.kwA = arrayList;
        AppMethodBeat.m2505o(18703);
    }

    public final void run() {
        AppMethodBeat.m2504i(18704);
        this.startTime = System.currentTimeMillis();
        this.kwj = this.kwA.size();
        C4990ab.m7411d("MicroMsg.DeleteFileController", "totalTaskCount=%d", Integer.valueOf(this.kwj));
        if (this.kwj == 0) {
            bfJ();
            AppMethodBeat.m2505o(18704);
            return;
        }
        int i = 0;
        while (!this.isStop && i < this.kwA.size()) {
            C4990ab.m7411d("MicroMsg.DeleteFileController", "while loop index=%d | filePath=%s", Integer.valueOf(i), ((C11389a) this.kwA.get(i)).filePath);
            C11390a c11390a = new C11390a(r0);
            while (!this.kwh.mo23131b(c11390a)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            C4990ab.m7411d("MicroMsg.DeleteFileController", "Start task： filePath＝%s", r0.filePath);
            i++;
        }
        AppMethodBeat.m2505o(18704);
    }

    private void bfJ() {
        AppMethodBeat.m2504i(18705);
        this.endTime = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.DeleteFileController", "totalUserTime:%d", Long.valueOf(bfK()));
        if (!(this.kwz == null || this.isStop)) {
            this.fbD.post(new C412622());
        }
        AppMethodBeat.m2505o(18705);
    }

    private long bfK() {
        return this.endTime - this.startTime;
    }

    public final void bgb() {
        AppMethodBeat.m2504i(18706);
        C4990ab.m7416i("MicroMsg.DeleteFileController", "stop analyseController");
        this.isStop = true;
        interrupt();
        AppMethodBeat.m2505o(18706);
    }

    /* renamed from: a */
    public final void mo35472a(C33819a c33819a) {
        AppMethodBeat.m2504i(18707);
        interrupt();
        this.kwk++;
        if (!(this.kwz == null || this.isStop)) {
            this.fbD.post(new C387971());
        }
        if (this.kwk == this.kwj) {
            bfJ();
        }
        AppMethodBeat.m2505o(18707);
    }
}
