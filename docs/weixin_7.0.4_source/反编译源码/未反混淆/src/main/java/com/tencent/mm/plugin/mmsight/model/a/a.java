package com.tencent.mm.plugin.mmsight.model.a;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static int ove = 4;
    static int ovf = 4;
    ak handler;
    HandlerThread[] ovg;
    int ovh = 0;
    private int ovi = 0;
    private LinkedList<b> ovj = new LinkedList();
    private a ovk;
    boolean ovl = false;
    com.tencent.mm.plugin.mmsight.model.a.b.a ovm = new com.tencent.mm.plugin.mmsight.model.a.b.a() {
        public final void a(final b bVar) {
            AppMethodBeat.i(76563);
            a.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(76562);
                    a.a(a.this, bVar);
                    AppMethodBeat.o(76562);
                }
            });
            AppMethodBeat.o(76563);
        }
    };

    public interface a {
        void output(byte[] bArr);
    }

    public a(a aVar) {
        AppMethodBeat.i(76564);
        this.ovk = aVar;
        ovf = -1;
        if (CaptureMMProxy.getInstance() != null) {
            ovf = CaptureMMProxy.getInstance().getInt(com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_THREADCOUNT_INT_SYNC, -1);
        }
        if (ovf == -1) {
            ovf = Runtime.getRuntime().availableProcessors();
            ovf = Math.min(ove, ovf);
            ab.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", Integer.valueOf(ovf), Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        } else {
            ab.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", Integer.valueOf(ovf));
        }
        this.ovg = new HandlerThread[ovf];
        SightVideoJNI.initScaleAndRoateBuffer(ovf);
        for (int i = 0; i < this.ovg.length; i++) {
            this.ovg[i] = d.ek("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_".concat(String.valueOf(i)), -1);
            this.ovg[i].start();
        }
        this.ovl = false;
        AppMethodBeat.o(76564);
    }

    private void bPK() {
        AppMethodBeat.i(76565);
        ab.i("MicroMsg.ForwardMgr", "processBufList %d %d", Integer.valueOf(this.ovj.size()), Integer.valueOf(this.ovi));
        while (this.ovj.size() != 0) {
            int i;
            ab.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", Integer.valueOf(this.ovj.size()), Integer.valueOf(this.ovi));
            Iterator it = this.ovj.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (this.ovi == bVar.ovt) {
                    this.ovi++;
                    this.ovk.output(bVar.ovr);
                    this.ovj.remove(bVar);
                    i = 1;
                    continue;
                    break;
                }
            }
            i = 0;
            continue;
            if (i == 0) {
                AppMethodBeat.o(76565);
                return;
            }
        }
        AppMethodBeat.o(76565);
    }

    public final boolean bPL() {
        return this.ovi == this.ovh;
    }

    public final void stop() {
        int i = 0;
        AppMethodBeat.i(76566);
        ab.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", bo.dpG().toString());
        while (i < this.ovg.length) {
            if (this.ovg[i] != null) {
                this.ovg[i].quit();
                this.ovg[i] = null;
            }
            i++;
        }
        SightVideoJNI.releaseScaleAndRoateBuffer(ovf);
        this.ovl = true;
        AppMethodBeat.o(76566);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(76567);
        try {
            stop();
        } catch (Throwable th) {
        }
        super.finalize();
        AppMethodBeat.o(76567);
    }

    static /* synthetic */ void a(a aVar, b bVar) {
        AppMethodBeat.i(76568);
        ab.i("MicroMsg.ForwardMgr", "receive buf bufIndex: %d receiveIndex: %d", Integer.valueOf(bVar.ovt), Integer.valueOf(aVar.ovi));
        if (aVar.ovi == bVar.ovt) {
            aVar.ovi++;
            aVar.ovk.output(bVar.ovr);
            aVar.bPK();
            AppMethodBeat.o(76568);
            return;
        }
        aVar.ovj.add(bVar);
        aVar.bPK();
        AppMethodBeat.o(76568);
    }
}
