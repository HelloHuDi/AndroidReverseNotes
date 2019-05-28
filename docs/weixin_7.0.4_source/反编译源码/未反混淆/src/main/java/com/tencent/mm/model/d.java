package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class d {
    private Context Gn = ah.getContext();
    private com.tencent.mm.compatible.util.b cqx;
    private com.tencent.mm.compatible.util.b.a fko;
    a fkp;
    private boolean fkq = false;

    public interface a {
    }

    class b implements com.tencent.mm.compatible.util.b.a {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b) {
            this();
        }

        public final void gF(int i) {
            AppMethodBeat.i(77794);
            switch (i) {
                case -3:
                    ab.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    if (d.this.fkp != null) {
                        AppMethodBeat.o(77794);
                        return;
                    }
                    break;
                case -2:
                    ab.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
                    if (d.this.fkp != null) {
                        AppMethodBeat.o(77794);
                        return;
                    }
                    break;
                case -1:
                    ab.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
                    if (d.this.fkp != null) {
                        AppMethodBeat.o(77794);
                        return;
                    }
                    break;
                case 1:
                    ab.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
                    if (d.this.fkp != null) {
                        AppMethodBeat.o(77794);
                        return;
                    }
                    break;
                default:
                    ab.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
                    break;
            }
            AppMethodBeat.o(77794);
        }
    }

    public d() {
        AppMethodBeat.i(77795);
        AppMethodBeat.o(77795);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(77796);
        this.fkp = aVar;
        com.tencent.mm.compatible.util.b.a bVar = new b(this, (byte) 0);
        if (this.cqx == null) {
            this.cqx = new com.tencent.mm.compatible.util.b(this.Gn);
        }
        if (this.fko != bVar) {
            this.fko = bVar;
        }
        this.cqx.a(this.fko);
        if (this.cqx == null) {
            AppMethodBeat.o(77796);
            return false;
        } else if (this.fkq) {
            AppMethodBeat.o(77796);
            return false;
        } else {
            this.cqx.requestFocus();
            this.fkq = true;
            boolean z = this.fkq;
            AppMethodBeat.o(77796);
            return z;
        }
    }

    public final boolean cy(boolean z) {
        boolean Mm;
        AppMethodBeat.i(77797);
        if (this.cqx != null) {
            Mm = this.cqx.Mm();
        } else {
            Mm = false;
        }
        this.fkq = false;
        if (z) {
            this.cqx = null;
            this.fko = null;
            this.fkp = null;
        }
        AppMethodBeat.o(77797);
        return Mm;
    }
}
