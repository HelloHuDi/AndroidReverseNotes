package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.z.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.Locale;

public final class d implements b {

    static final class a implements com.tencent.mm.plugin.appbrand.appcache.z.a {
        private ArrayList<IDKey> gSZ;
        private long gTa;
        private long gTb;
        private final bb hmu;
        private a hmv;

        enum a {
            DOWNLOAD,
            UPDATE;

            static {
                AppMethodBeat.o(10778);
            }
        }

        /* synthetic */ a(bb bbVar, byte b) {
            this(bbVar);
        }

        private a(bb bbVar) {
            this.gTa = 0;
            this.gTb = 0;
            this.hmu = bbVar;
        }

        private void nL(int i) {
            AppMethodBeat.i(10779);
            if (this.gSZ == null) {
                this.gSZ = new ArrayList();
            }
            this.gSZ.add(new IDKey(640, i, 1));
            AppMethodBeat.o(10779);
        }

        private void avI() {
            AppMethodBeat.i(10780);
            try {
                e.pXa.b(this.gSZ, false);
                this.gSZ.clear();
                AppMethodBeat.o(10780);
            } catch (Exception e) {
                AppMethodBeat.o(10780);
            }
        }

        public final void avp() {
            int i = 0;
            AppMethodBeat.i(10781);
            if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(this.hmu.cBc)) {
                int i2;
                if (((com.tencent.mm.plugin.appbrand.a.d) g.K(com.tencent.mm.plugin.appbrand.a.d.class)).xF() == null) {
                    i2 = 1;
                } else {
                    ax xF = ((com.tencent.mm.plugin.appbrand.a.d) g.K(com.tencent.mm.plugin.appbrand.a.d.class)).xF();
                    String str = this.hmu.appId;
                    int i3 = this.hmu.cBc;
                    Cursor a = xF.gVj.a(String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[]{"version", "AppBrandWxaPkgManifestRecord", "appId", "debugType"}), new String[]{str, String.valueOf(i3)}, 2);
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
                this.hmv = i2 > 1 ? a.UPDATE : a.DOWNLOAD;
            } else {
                this.hmv = a.DOWNLOAD;
            }
            switch (this.hmv) {
                case DOWNLOAD:
                    i = 1;
                    break;
                case UPDATE:
                    i = 10;
                    break;
            }
            nL(i);
            this.gTa = SystemClock.elapsedRealtime();
            AppMethodBeat.o(10781);
        }

        public final void avq() {
            AppMethodBeat.i(10782);
            nL(32);
            AppMethodBeat.o(10782);
        }

        public final void avr() {
            AppMethodBeat.i(10783);
            nL(31);
            AppMethodBeat.o(10783);
        }

        public final void a(m mVar) {
            int i;
            boolean z = true;
            int i2 = 2;
            AppMethodBeat.i(10784);
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
            e.pXa.a(665, (long) i, 1, false);
            e.pXa.a(665, 6, 1, false);
            if (mVar == null || mVar.status != 2) {
                z = false;
            }
            switch (this.hmv) {
                case DOWNLOAD:
                    if (!z) {
                        i2 = 3;
                    }
                    nL(i2);
                    break;
                case UPDATE:
                    nL(z ? 11 : 12);
                    break;
            }
            avI();
            AppMethodBeat.o(10784);
        }

        public final void avs() {
        }

        public final void nq(int i) {
        }

        public final void avt() {
        }

        public final void avu() {
            AppMethodBeat.i(10785);
            this.gTb = SystemClock.elapsedRealtime();
            switch (this.hmv) {
                case DOWNLOAD:
                    nL(5);
                    AppMethodBeat.o(10785);
                    return;
                case UPDATE:
                    nL(14);
                    break;
            }
            AppMethodBeat.o(10785);
        }

        public final void dz(boolean z) {
            int i;
            AppMethodBeat.i(10786);
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
            nL(i);
            avI();
            AppMethodBeat.o(10786);
        }

        public final void avv() {
        }

        public final void dA(boolean z) {
        }
    }

    public final com.tencent.mm.plugin.appbrand.appcache.z.a a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        AppMethodBeat.i(10787);
        if (bb.class == aVar.getClass()) {
            a aVar2 = new a((bb) aVar, (byte) 0);
            AppMethodBeat.o(10787);
            return aVar2;
        }
        AppMethodBeat.o(10787);
        return null;
    }
}
