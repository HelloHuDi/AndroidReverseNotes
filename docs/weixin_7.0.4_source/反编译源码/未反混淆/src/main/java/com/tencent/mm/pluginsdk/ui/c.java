package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.d;

public final class c extends i implements com.tencent.mm.ah.d.a {
    private a vgP;
    private int vgQ;

    static class a implements com.tencent.mm.pluginsdk.ui.i.a {
        Bitmap jMX = null;
        private com.tencent.mm.pluginsdk.ui.i.a pqK;

        public a(com.tencent.mm.pluginsdk.ui.i.a aVar) {
            this.pqK = aVar;
        }

        public final Bitmap b(String str, int i, int i2, int i3) {
            AppMethodBeat.i(79669);
            if (this.pqK != null) {
                Bitmap b = this.pqK.b(str, i, i2, i3);
                AppMethodBeat.o(79669);
                return b;
            }
            AppMethodBeat.o(79669);
            return null;
        }

        public final Bitmap cQ(String str) {
            AppMethodBeat.i(79670);
            if (this.pqK != null) {
                Bitmap cQ = this.pqK.cQ(str);
                AppMethodBeat.o(79670);
                return cQ;
            }
            AppMethodBeat.o(79670);
            return null;
        }

        public final Bitmap cR(String str) {
            AppMethodBeat.i(79671);
            if (this.pqK != null) {
                Bitmap cR = this.pqK.cR(str);
                AppMethodBeat.o(79671);
                return cR;
            }
            AppMethodBeat.o(79671);
            return null;
        }

        public final Bitmap AZ() {
            AppMethodBeat.i(79672);
            Bitmap bitmap;
            if (this.jMX != null && !this.jMX.isRecycled()) {
                bitmap = this.jMX;
                AppMethodBeat.o(79672);
                return bitmap;
            } else if (this.pqK != null) {
                bitmap = this.pqK.AZ();
                AppMethodBeat.o(79672);
                return bitmap;
            } else {
                AppMethodBeat.o(79672);
                return null;
            }
        }

        public final void a(i iVar) {
            AppMethodBeat.i(79673);
            if (this.pqK != null) {
                this.pqK.a(iVar);
            }
            AppMethodBeat.o(79673);
        }
    }

    public c(String str) {
        this(str, (byte) 0);
    }

    private c(String str, byte b) {
        super(new a(b.diS()), str, (byte) 0);
        AppMethodBeat.i(79674);
        this.vgP = (a) this.pqK;
        AppMethodBeat.o(79674);
    }

    public final void KL(int i) {
        AppMethodBeat.i(79675);
        if (this.vgQ != i || this.vgP == null || this.vgP.jMX == null || this.vgP.jMX.isRecycled()) {
            this.vgQ = i;
            af(d.LV(i));
            AppMethodBeat.o(79675);
            return;
        }
        AppMethodBeat.o(79675);
    }

    private void af(Bitmap bitmap) {
        if (this.vgP != null) {
            this.vgP.jMX = bitmap;
        }
    }
}
