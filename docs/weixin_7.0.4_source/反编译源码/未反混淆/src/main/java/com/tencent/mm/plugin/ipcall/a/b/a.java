package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public boolean cFy = false;
    public c kzq = null;
    public final Object nxa = new Object();
    public int nxb = 0;
    public boolean nxc = false;

    public class a implements Runnable {
        private c nxe = null;

        public a(c cVar) {
            this.nxe = cVar;
        }

        public final void run() {
            AppMethodBeat.i(21799);
            if (this.nxe != null) {
                this.nxe.cIr();
                this.nxe.cIo();
                this.nxe = null;
                a.this.nxc = false;
            }
            aw.ZL().setMode(0);
            AppMethodBeat.o(21799);
        }
    }

    public a() {
        AppMethodBeat.i(21800);
        AppMethodBeat.o(21800);
    }

    public final void io(boolean z) {
        AppMethodBeat.i(21801);
        ab.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", Boolean.valueOf(this.nxc), Boolean.valueOf(z));
        aw.ZL().bF(z);
        i.bHr().io(z);
        if (z != this.nxc) {
            this.nxc = z;
            ip(z);
        }
        AppMethodBeat.o(21801);
    }

    private void ip(boolean z) {
        AppMethodBeat.i(21802);
        if (this.kzq != null && this.kzq.sNi) {
            this.kzq.mj(z);
        }
        AppMethodBeat.o(21802);
    }

    public static boolean KU() {
        AppMethodBeat.i(139021);
        boolean isSpeakerphoneOn = aw.ZL().eoY.isSpeakerphoneOn();
        AppMethodBeat.o(139021);
        return isSpeakerphoneOn;
    }
}
