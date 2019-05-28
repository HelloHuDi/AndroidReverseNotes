package com.tencent.p177mm.plugin.priority.p1284b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.priority.PluginPriority;
import com.tencent.p177mm.plugin.priority.p1284b.p1285a.C43373a;
import com.tencent.p177mm.plugin.priority.p1284b.p1497b.C34675a;
import com.tencent.p177mm.plugin.priority.p1407a.p1408a.C43370a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.priority.b.d */
public final class C28670d {
    public List<Object> pgp = new LinkedList();
    public C5004al pgq = new C5004al("Priority.PriorityTaskRunner");
    public C21438a pgr = new C21438a(this.pgq.oAl.getLooper());

    /* renamed from: com.tencent.mm.plugin.priority.b.d$a */
    public class C21438a extends C7306ak {
        C21438a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(54898);
            switch (message.what) {
                case 0:
                    C28670d.this.mo46812ju(120000);
                    if (C43370a.bhI()) {
                        int i;
                        C43373a c2CImgAutoDownloader = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CImgAutoDownloader();
                        if (c2CImgAutoDownloader.pgt != 0) {
                            C25822e fJ = C32291o.ahl().mo73113fJ(c2CImgAutoDownloader.pgt);
                            i = C32291o.ahm().mo33466a(fJ.fDy, c2CImgAutoDownloader.pgt, fJ.fDC) ? 1 : 0;
                        } else {
                            i = 0;
                        }
                        if (i == 0) {
                            ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CImgAutoDownloader();
                            if (C43373a.bZz()) {
                                ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CImgAutoDownloader().start();
                                AppMethodBeat.m2505o(54898);
                                return;
                            }
                        }
                    }
                    break;
                case 1:
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        ((C34675a) message.obj).run();
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", e, "MESSAGE_ONCE_RUN_TASK %s", r0.getName());
                    }
                    C4990ab.m7417i("MicroMsg.Priority.PriorityTaskRunner", "Once Run Task %s Use Time %d", r0.getName(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    break;
            }
            AppMethodBeat.m2505o(54898);
        }
    }

    public C28670d() {
        AppMethodBeat.m2504i(54899);
        AppMethodBeat.m2505o(54899);
    }

    /* renamed from: ju */
    public final void mo46812ju(long j) {
        AppMethodBeat.m2504i(54900);
        if (this.pgr != null) {
            if (j == 0) {
                this.pgr.sendEmptyMessage(0);
                AppMethodBeat.m2505o(54900);
                return;
            }
            this.pgr.sendEmptyMessageDelayed(0, j);
        }
        AppMethodBeat.m2505o(54900);
    }

    /* renamed from: a */
    public final void mo46810a(C34675a c34675a) {
        AppMethodBeat.m2504i(54901);
        if (this.pgr != null) {
            this.pgr.sendMessage(this.pgr.obtainMessage(1, c34675a));
        }
        AppMethodBeat.m2505o(54901);
    }

    /* renamed from: b */
    public final void mo46811b(C34675a c34675a) {
        AppMethodBeat.m2504i(54902);
        if (this.pgr != null) {
            this.pgr.sendMessageDelayed(this.pgr.obtainMessage(1, c34675a), 1000);
        }
        AppMethodBeat.m2505o(54902);
    }
}
