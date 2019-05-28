package com.tencent.mm.plugin.voip_cs.c;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

public final class b {
    public ap gyS = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(135437);
            int i = b.this.sWC[b.this.sWE % b.this.sWC.length];
            if (b.this.sW != null) {
                if (-1 == i) {
                    b.this.sW.setText(null);
                } else {
                    b.this.sW.setText(i);
                }
            }
            b bVar = b.this;
            bVar.sWE++;
            AppMethodBeat.o(135437);
            return true;
        }
    }, true);
    public TextView sW;
    public int[] sWC;
    public int sWD;
    public int sWE;

    public b() {
        AppMethodBeat.i(135438);
        AppMethodBeat.o(135438);
    }

    public final void cLc() {
        AppMethodBeat.i(135439);
        if (this.gyS != null) {
            this.gyS.stopTimer();
        }
        ab.b("MicroMsg.DynamicTextWrap", "stop textview: " + this.sW, new Object[0]);
        this.sW = null;
        AppMethodBeat.o(135439);
    }
}
