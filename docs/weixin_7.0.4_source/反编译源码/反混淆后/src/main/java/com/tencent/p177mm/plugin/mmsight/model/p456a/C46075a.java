package com.tencent.p177mm.plugin.mmsight.model.p456a;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43302b.C28498a;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.mmsight.model.a.a */
public final class C46075a {
    private static int ove = 4;
    static int ovf = 4;
    C7306ak handler;
    HandlerThread[] ovg;
    int ovh = 0;
    private int ovi = 0;
    private LinkedList<C43302b> ovj = new LinkedList();
    private C43301a ovk;
    boolean ovl = false;
    C28498a ovm = new C125401();

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.a$1 */
    class C125401 implements C28498a {
        C125401() {
        }

        /* renamed from: a */
        public final void mo24465a(final C43302b c43302b) {
            AppMethodBeat.m2504i(76563);
            C46075a.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(76562);
                    C46075a.m85843a(C46075a.this, c43302b);
                    AppMethodBeat.m2505o(76562);
                }
            });
            AppMethodBeat.m2505o(76563);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.a$a */
    public interface C43301a {
        void output(byte[] bArr);
    }

    public C46075a(C43301a c43301a) {
        AppMethodBeat.m2504i(76564);
        this.ovk = c43301a;
        ovf = -1;
        if (CaptureMMProxy.getInstance() != null) {
            ovf = CaptureMMProxy.getInstance().getInt(C5127a.USERINFO_LOCAL_SIGHT_THREADCOUNT_INT_SYNC, -1);
        }
        if (ovf == -1) {
            ovf = Runtime.getRuntime().availableProcessors();
            ovf = Math.min(ove, ovf);
            C4990ab.m7417i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", Integer.valueOf(ovf), Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        } else {
            C4990ab.m7417i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", Integer.valueOf(ovf));
        }
        this.ovg = new HandlerThread[ovf];
        SightVideoJNI.initScaleAndRoateBuffer(ovf);
        for (int i = 0; i < this.ovg.length; i++) {
            this.ovg[i] = C7305d.m12297ek("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_".concat(String.valueOf(i)), -1);
            this.ovg[i].start();
        }
        this.ovl = false;
        AppMethodBeat.m2505o(76564);
    }

    private void bPK() {
        AppMethodBeat.m2504i(76565);
        C4990ab.m7417i("MicroMsg.ForwardMgr", "processBufList %d %d", Integer.valueOf(this.ovj.size()), Integer.valueOf(this.ovi));
        while (this.ovj.size() != 0) {
            int i;
            C4990ab.m7417i("MicroMsg.ForwardMgr", "loop processBufList %d %d", Integer.valueOf(this.ovj.size()), Integer.valueOf(this.ovi));
            Iterator it = this.ovj.iterator();
            while (it.hasNext()) {
                C43302b c43302b = (C43302b) it.next();
                if (this.ovi == c43302b.ovt) {
                    this.ovi++;
                    this.ovk.output(c43302b.ovr);
                    this.ovj.remove(c43302b);
                    i = 1;
                    continue;
                    break;
                }
            }
            i = 0;
            continue;
            if (i == 0) {
                AppMethodBeat.m2505o(76565);
                return;
            }
        }
        AppMethodBeat.m2505o(76565);
    }

    public final boolean bPL() {
        return this.ovi == this.ovh;
    }

    public final void stop() {
        int i = 0;
        AppMethodBeat.m2504i(76566);
        C4990ab.m7417i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", C5046bo.dpG().toString());
        while (i < this.ovg.length) {
            if (this.ovg[i] != null) {
                this.ovg[i].quit();
                this.ovg[i] = null;
            }
            i++;
        }
        SightVideoJNI.releaseScaleAndRoateBuffer(ovf);
        this.ovl = true;
        AppMethodBeat.m2505o(76566);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(76567);
        try {
            stop();
        } catch (Throwable th) {
        }
        super.finalize();
        AppMethodBeat.m2505o(76567);
    }

    /* renamed from: a */
    static /* synthetic */ void m85843a(C46075a c46075a, C43302b c43302b) {
        AppMethodBeat.m2504i(76568);
        C4990ab.m7417i("MicroMsg.ForwardMgr", "receive buf bufIndex: %d receiveIndex: %d", Integer.valueOf(c43302b.ovt), Integer.valueOf(c46075a.ovi));
        if (c46075a.ovi == c43302b.ovt) {
            c46075a.ovi++;
            c46075a.ovk.output(c43302b.ovr);
            c46075a.bPK();
            AppMethodBeat.m2505o(76568);
            return;
        }
        c46075a.ovj.add(c43302b);
        c46075a.bPK();
        AppMethodBeat.m2505o(76568);
    }
}
