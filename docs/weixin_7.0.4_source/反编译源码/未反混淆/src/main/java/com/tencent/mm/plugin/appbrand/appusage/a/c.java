package com.tencent.mm.plugin.appbrand.appusage.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.TimeUnit;

public final class c {
    private static float hba = 0.0f;
    private static float hbb = 0.0f;
    private static volatile long hbc = 0;
    private boolean hbd = false;
    private a hbe;

    public interface a {
        void G(float f, float f2);
    }

    public final void a(a aVar) {
        this.hbe = aVar;
    }

    public final boolean axS() {
        return this.hbe != null;
    }

    public static boolean axT() {
        AppMethodBeat.i(129740);
        if (hbb == -85.0f || hba == -1000.0f) {
            AppMethodBeat.o(129740);
            return false;
        }
        boolean z;
        if (bo.anU() - hbc < 300000) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(129740);
            return true;
        }
        AppMethodBeat.o(129740);
        return false;
    }

    public static float getLongitude() {
        return hba;
    }

    public static float getLatitude() {
        return hbb;
    }

    public final void axU() {
        AppMethodBeat.i(129741);
        if (this.hbd) {
            AppMethodBeat.o(129741);
            return;
        }
        ab.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "startLocation");
        this.hbd = true;
        final PBool pBool = new PBool();
        final PBool pBool2 = new PBool();
        pBool.value = false;
        pBool2.value = false;
        ap apVar = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(129738);
                if (pBool2.value) {
                    AppMethodBeat.o(129738);
                } else {
                    pBool.value = true;
                    c.this.hbd = false;
                    ab.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onTimerExpired");
                    if (c.this.hbe != null) {
                        c.this.hbe.G(c.hba, c.hbb);
                    }
                    AppMethodBeat.o(129738);
                }
                return false;
            }
        }, false);
        long toMillis = TimeUnit.SECONDS.toMillis(20);
        apVar.ae(toMillis, toMillis);
        d.agz().b((com.tencent.mm.modelgeo.b.a) e.bB(new com.tencent.mm.modelgeo.b.a() {
            private int gZI = 0;

            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                AppMethodBeat.i(129739);
                e.at(this);
                d.agz().c(this);
                int i2 = this.gZI + 1;
                this.gZI = i2;
                if (i2 > 1 || pBool.value) {
                    AppMethodBeat.o(129739);
                    return false;
                }
                pBool2.value = true;
                c.this.hbd = false;
                if (z) {
                    ab.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, success");
                    c.hbb = f2;
                    c.hba = f;
                    c.hbc = bo.anU();
                    if (c.this.hbe != null) {
                        c.this.hbe.G(f, f2);
                    }
                    AppMethodBeat.o(129739);
                    return true;
                }
                ab.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, fail");
                if (c.this.hbe != null) {
                    c.this.hbe.G(f, f2);
                }
                AppMethodBeat.o(129739);
                return false;
            }
        }), false);
        AppMethodBeat.o(129741);
    }
}
