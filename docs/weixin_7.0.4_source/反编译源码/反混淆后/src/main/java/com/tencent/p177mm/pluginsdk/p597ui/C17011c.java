package com.tencent.p177mm.pluginsdk.p597ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.C46507i.C14947a;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.pluginsdk.ui.c */
public final class C17011c extends C46507i implements C8915a {
    private C17012a vgP;
    private int vgQ;

    /* renamed from: com.tencent.mm.pluginsdk.ui.c$a */
    static class C17012a implements C14947a {
        Bitmap jMX = null;
        private C14947a pqK;

        public C17012a(C14947a c14947a) {
            this.pqK = c14947a;
        }

        /* renamed from: b */
        public final Bitmap mo8231b(String str, int i, int i2, int i3) {
            AppMethodBeat.m2504i(79669);
            if (this.pqK != null) {
                Bitmap b = this.pqK.mo8231b(str, i, i2, i3);
                AppMethodBeat.m2505o(79669);
                return b;
            }
            AppMethodBeat.m2505o(79669);
            return null;
        }

        /* renamed from: cQ */
        public final Bitmap mo8232cQ(String str) {
            AppMethodBeat.m2504i(79670);
            if (this.pqK != null) {
                Bitmap cQ = this.pqK.mo8232cQ(str);
                AppMethodBeat.m2505o(79670);
                return cQ;
            }
            AppMethodBeat.m2505o(79670);
            return null;
        }

        /* renamed from: cR */
        public final Bitmap mo8233cR(String str) {
            AppMethodBeat.m2504i(79671);
            if (this.pqK != null) {
                Bitmap cR = this.pqK.mo8233cR(str);
                AppMethodBeat.m2505o(79671);
                return cR;
            }
            AppMethodBeat.m2505o(79671);
            return null;
        }

        /* renamed from: AZ */
        public final Bitmap mo8229AZ() {
            AppMethodBeat.m2504i(79672);
            Bitmap bitmap;
            if (this.jMX != null && !this.jMX.isRecycled()) {
                bitmap = this.jMX;
                AppMethodBeat.m2505o(79672);
                return bitmap;
            } else if (this.pqK != null) {
                bitmap = this.pqK.mo8229AZ();
                AppMethodBeat.m2505o(79672);
                return bitmap;
            } else {
                AppMethodBeat.m2505o(79672);
                return null;
            }
        }

        /* renamed from: a */
        public final void mo8230a(C46507i c46507i) {
            AppMethodBeat.m2504i(79673);
            if (this.pqK != null) {
                this.pqK.mo8230a(c46507i);
            }
            AppMethodBeat.m2505o(79673);
        }
    }

    public C17011c(String str) {
        this(str, (byte) 0);
    }

    private C17011c(String str, byte b) {
        super(new C17012a(C40460b.diS()), str, (byte) 0);
        AppMethodBeat.m2504i(79674);
        this.vgP = (C17012a) this.pqK;
        AppMethodBeat.m2505o(79674);
    }

    /* renamed from: KL */
    public final void mo31083KL(int i) {
        AppMethodBeat.m2504i(79675);
        if (this.vgQ != i || this.vgP == null || this.vgP.jMX == null || this.vgP.jMX.isRecycled()) {
            this.vgQ = i;
            m26315af(C5056d.m7610LV(i));
            AppMethodBeat.m2505o(79675);
            return;
        }
        AppMethodBeat.m2505o(79675);
    }

    /* renamed from: af */
    private void m26315af(Bitmap bitmap) {
        if (this.vgP != null) {
            this.vgP.jMX = bitmap;
        }
    }
}
