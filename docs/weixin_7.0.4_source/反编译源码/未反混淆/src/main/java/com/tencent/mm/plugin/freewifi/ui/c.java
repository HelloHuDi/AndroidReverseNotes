package com.tencent.mm.plugin.freewifi.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class c {
    private static String TAG = "MicroMsg.FreeWifi.FreeWifiGetLocation";
    private boolean isRunning;
    private com.tencent.mm.modelgeo.b mzn;
    private com.tencent.mm.modelgeo.b.a mzo;
    private ak mzp;

    static class b {
        private static c mzs = new c();

        static {
            AppMethodBeat.i(20995);
            AppMethodBeat.o(20995);
        }
    }

    public interface a {
        void Q(float f, float f2);
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        this.mzn = null;
        this.mzo = null;
        this.mzp = null;
        this.isRunning = false;
    }

    public static c bzM() {
        AppMethodBeat.i(20996);
        c bzN = b.mzs;
        AppMethodBeat.o(20996);
        return bzN;
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(20997);
        if (this.isRunning) {
            AppMethodBeat.o(20997);
            return;
        }
        this.isRunning = true;
        this.mzn = d.agz();
        if (this.mzn == null) {
            ab.e(TAG, "doGeoLocation fail, iGetLocation is null");
            AppMethodBeat.o(20997);
            return;
        }
        if (this.mzo == null) {
            this.mzo = new com.tencent.mm.modelgeo.b.a() {
                public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                    AppMethodBeat.i(20993);
                    if (z) {
                        ab.v(c.TAG, "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2));
                        if (c.this.mzn != null) {
                            c.this.mzn.c(c.this.mzo);
                        }
                        if (c.this.mzo == null) {
                            ab.w(c.TAG, "already callback");
                            AppMethodBeat.o(20993);
                            return false;
                        }
                        c.this.mzo = null;
                        aVar.Q(f, f2);
                        AppMethodBeat.o(20993);
                        return false;
                    }
                    AppMethodBeat.o(20993);
                    return true;
                }
            };
        }
        if (this.mzp == null) {
            this.mzp = new ak(Looper.myLooper());
        }
        this.mzp.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20994);
                c.this.isRunning = false;
                if (c.this.mzn != null) {
                    c.this.mzn.c(c.this.mzo);
                }
                if (c.this.mzo == null) {
                    ab.w(c.TAG, "already callback");
                    AppMethodBeat.o(20994);
                    return;
                }
                c.this.mzo = null;
                AppMethodBeat.o(20994);
            }
        }, 20000);
        this.mzn.a(this.mzo);
        AppMethodBeat.o(20997);
    }
}
