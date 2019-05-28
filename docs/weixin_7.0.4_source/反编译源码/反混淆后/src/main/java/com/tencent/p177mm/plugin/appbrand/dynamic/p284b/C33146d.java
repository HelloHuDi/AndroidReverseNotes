package com.tencent.p177mm.plugin.appbrand.dynamic.p284b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.appcache.C26751z.C19074a;
import com.tencent.p177mm.plugin.appbrand.appcache.C26751z.C26750b;
import com.tencent.p177mm.plugin.appbrand.appcache.C38105ax;
import com.tencent.p177mm.plugin.appbrand.appcache.C38116bb;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.b.d */
public final class C33146d implements C26750b {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.b.d$a */
    static final class C33145a implements C19074a {
        private ArrayList<IDKey> gSZ;
        private long gTa;
        private long gTb;
        private final C38116bb hmu;
        private C19171a hmv;

        /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.b.d$a$a */
        enum C19171a {
            DOWNLOAD,
            UPDATE;

            static {
                AppMethodBeat.m2505o(10778);
            }
        }

        /* synthetic */ C33145a(C38116bb c38116bb, byte b) {
            this(c38116bb);
        }

        private C33145a(C38116bb c38116bb) {
            this.gTa = 0;
            this.gTb = 0;
            this.hmu = c38116bb;
        }

        /* renamed from: nL */
        private void m54183nL(int i) {
            AppMethodBeat.m2504i(10779);
            if (this.gSZ == null) {
                this.gSZ = new ArrayList();
            }
            this.gSZ.add(new IDKey(640, i, 1));
            AppMethodBeat.m2505o(10779);
        }

        private void avI() {
            AppMethodBeat.m2504i(10780);
            try {
                C7053e.pXa.mo8379b(this.gSZ, false);
                this.gSZ.clear();
                AppMethodBeat.m2505o(10780);
            } catch (Exception e) {
                AppMethodBeat.m2505o(10780);
            }
        }

        public final void avp() {
            int i = 0;
            AppMethodBeat.m2504i(10781);
            if (C33097a.m54090np(this.hmu.cBc)) {
                int i2;
                if (((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF() == null) {
                    i2 = 1;
                } else {
                    C38105ax xF = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF();
                    String str = this.hmu.appId;
                    int i3 = this.hmu.cBc;
                    Cursor a = xF.gVj.mo10104a(String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[]{"version", "AppBrandWxaPkgManifestRecord", "appId", "debugType"}), new String[]{str, String.valueOf(i3)}, 2);
                    if (a == null) {
                        i2 = 0;
                    } else {
                        if (a.moveToFirst()) {
                            i2 = a.getInt(0);
                        } else {
                            i2 = 0;
                        }
                        a.close();
                    }
                }
                this.hmv = i2 > 1 ? C19171a.UPDATE : C19171a.DOWNLOAD;
            } else {
                this.hmv = C19171a.DOWNLOAD;
            }
            switch (this.hmv) {
                case DOWNLOAD:
                    i = 1;
                    break;
                case UPDATE:
                    i = 10;
                    break;
            }
            m54183nL(i);
            this.gTa = SystemClock.elapsedRealtime();
            AppMethodBeat.m2505o(10781);
        }

        public final void avq() {
            AppMethodBeat.m2504i(10782);
            m54183nL(32);
            AppMethodBeat.m2505o(10782);
        }

        public final void avr() {
            AppMethodBeat.m2504i(10783);
            m54183nL(31);
            AppMethodBeat.m2505o(10783);
        }

        /* renamed from: a */
        public final void mo34289a(C40432m c40432m) {
            int i;
            boolean z = true;
            int i2 = 2;
            AppMethodBeat.m2504i(10784);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.gTa;
            if (elapsedRealtime <= 1000) {
                i = 0;
            } else if (elapsedRealtime <= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                i = 1;
            } else if (elapsedRealtime <= 3000) {
                i = 2;
            } else if (elapsedRealtime <= 4000) {
                i = 3;
            } else if (elapsedRealtime <= 5000) {
                i = 4;
            } else {
                i = 5;
            }
            C7053e.pXa.mo8378a(665, (long) i, 1, false);
            C7053e.pXa.mo8378a(665, 6, 1, false);
            if (c40432m == null || c40432m.status != 2) {
                z = false;
            }
            switch (this.hmv) {
                case DOWNLOAD:
                    if (!z) {
                        i2 = 3;
                    }
                    m54183nL(i2);
                    break;
                case UPDATE:
                    m54183nL(z ? 11 : 12);
                    break;
            }
            avI();
            AppMethodBeat.m2505o(10784);
        }

        public final void avs() {
        }

        /* renamed from: nq */
        public final void mo34299nq(int i) {
        }

        public final void avt() {
        }

        public final void avu() {
            AppMethodBeat.m2504i(10785);
            this.gTb = SystemClock.elapsedRealtime();
            switch (this.hmv) {
                case DOWNLOAD:
                    m54183nL(5);
                    AppMethodBeat.m2505o(10785);
                    return;
                case UPDATE:
                    m54183nL(14);
                    break;
            }
            AppMethodBeat.m2505o(10785);
        }

        /* renamed from: dz */
        public final void mo34298dz(boolean z) {
            int i;
            AppMethodBeat.m2504i(10786);
            SystemClock.elapsedRealtime();
            switch (this.hmv) {
                case DOWNLOAD:
                    if (!z) {
                        i = 7;
                        break;
                    } else {
                        i = 6;
                        break;
                    }
                case UPDATE:
                    if (!z) {
                        i = 16;
                        break;
                    } else {
                        i = 15;
                        break;
                    }
                default:
                    i = 0;
                    break;
            }
            m54183nL(i);
            avI();
            AppMethodBeat.m2505o(10786);
        }

        public final void avv() {
        }

        /* renamed from: dA */
        public final void mo34297dA(boolean z) {
        }
    }

    /* renamed from: a */
    public final C19074a mo44527a(C10065a c10065a) {
        AppMethodBeat.m2504i(10787);
        if (C38116bb.class == c10065a.getClass()) {
            C33145a c33145a = new C33145a((C38116bb) c10065a, (byte) 0);
            AppMethodBeat.m2505o(10787);
            return c33145a;
        }
        AppMethodBeat.m2505o(10787);
        return null;
    }
}
