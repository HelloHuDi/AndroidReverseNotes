package com.tencent.mm.plugin.priority.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;
import java.util.List;

public final class d {
    public List<Object> pgp = new LinkedList();
    public al pgq = new al("Priority.PriorityTaskRunner");
    public a pgr = new a(this.pgq.oAl.getLooper());

    public class a extends ak {
        a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(54898);
            switch (message.what) {
                case 0:
                    d.this.ju(120000);
                    if (com.tencent.mm.plugin.priority.a.a.a.bhI()) {
                        int i;
                        com.tencent.mm.plugin.priority.b.a.a c2CImgAutoDownloader = ((PluginPriority) g.M(PluginPriority.class)).getC2CImgAutoDownloader();
                        if (c2CImgAutoDownloader.pgt != 0) {
                            e fJ = o.ahl().fJ(c2CImgAutoDownloader.pgt);
                            i = o.ahm().a(fJ.fDy, c2CImgAutoDownloader.pgt, fJ.fDC) ? 1 : 0;
                        } else {
                            i = 0;
                        }
                        if (i == 0) {
                            ((PluginPriority) g.M(PluginPriority.class)).getC2CImgAutoDownloader();
                            if (com.tencent.mm.plugin.priority.b.a.a.bZz()) {
                                ((PluginPriority) g.M(PluginPriority.class)).getC2CImgAutoDownloader().start();
                                AppMethodBeat.o(54898);
                                return;
                            }
                        }
                    }
                    break;
                case 1:
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        ((com.tencent.mm.plugin.priority.b.b.a) message.obj).run();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", e, "MESSAGE_ONCE_RUN_TASK %s", r0.getName());
                    }
                    ab.i("MicroMsg.Priority.PriorityTaskRunner", "Once Run Task %s Use Time %d", r0.getName(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    break;
            }
            AppMethodBeat.o(54898);
        }
    }

    public d() {
        AppMethodBeat.i(54899);
        AppMethodBeat.o(54899);
    }

    public final void ju(long j) {
        AppMethodBeat.i(54900);
        if (this.pgr != null) {
            if (j == 0) {
                this.pgr.sendEmptyMessage(0);
                AppMethodBeat.o(54900);
                return;
            }
            this.pgr.sendEmptyMessageDelayed(0, j);
        }
        AppMethodBeat.o(54900);
    }

    public final void a(com.tencent.mm.plugin.priority.b.b.a aVar) {
        AppMethodBeat.i(54901);
        if (this.pgr != null) {
            this.pgr.sendMessage(this.pgr.obtainMessage(1, aVar));
        }
        AppMethodBeat.o(54901);
    }

    public final void b(com.tencent.mm.plugin.priority.b.b.a aVar) {
        AppMethodBeat.i(54902);
        if (this.pgr != null) {
            this.pgr.sendMessageDelayed(this.pgr.obtainMessage(1, aVar), 1000);
        }
        AppMethodBeat.o(54902);
    }
}
