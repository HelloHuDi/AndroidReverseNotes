package com.tencent.mm.plugin.ext.c;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.ext.c.d.b;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;

public class e {
    public static e lQY = null;
    public Context mContext = null;

    /* renamed from: com.tencent.mm.plugin.ext.c.e$2 */
    public class AnonymousClass2 extends bj<Boolean> {
        final /* synthetic */ int hHu;
        final /* synthetic */ int hHv;
        final /* synthetic */ String val$url;

        public AnonymousClass2(Boolean bool, String str, int i, int i2) {
            this.val$url = str;
            this.hHu = i;
            this.hHv = i2;
            super(5000, bool);
        }

        public final /* synthetic */ Object run() {
            AppMethodBeat.i(20422);
            Boolean aKg = aKg();
            AppMethodBeat.o(20422);
            return aKg;
        }

        private Boolean aKg() {
            AppMethodBeat.i(20421);
            g.RO().eJo.a(782, new f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    boolean z;
                    AppMethodBeat.i(20420);
                    if (((com.tencent.mm.plugin.ext.c.a.a) mVar).lRf == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ab.i("MicroMsg.ExtQrCodeHandler", "hy: check url done. errType: %d, errCode: %d, errMsg %s, scene: %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                    g.RO().eJo.b(782, (f) this);
                    if (i == 0 && i2 == 0) {
                        AnonymousClass2.this.cC(Boolean.valueOf(z));
                        AppMethodBeat.o(20420);
                        return;
                    }
                    AnonymousClass2.this.cC(Boolean.FALSE);
                    AppMethodBeat.o(20420);
                }
            });
            g.RO().eJo.a(new com.tencent.mm.plugin.ext.c.a.a(this.val$url, this.hHu, this.hHv), 0);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(20421);
            return bool;
        }
    }

    public static class a {
        public int lRd;
        private boolean lRe;
        public int type;
        public String url;

        public a(int i, String str, int i2) {
            this.lRe = false;
            this.type = i;
            this.url = str;
            this.lRe = false;
            this.lRd = i2;
        }

        public a() {
            this.lRe = false;
            this.lRe = true;
        }

        public final String toString() {
            AppMethodBeat.i(20423);
            String str = "QrCodeModel{type=" + this.type + ", url='" + this.url + '\'' + ", flagTimeout=" + this.lRe + '}';
            AppMethodBeat.o(20423);
            return str;
        }
    }

    public static e brW() {
        AppMethodBeat.i(20424);
        e eVar;
        if (lQY == null) {
            synchronized (e.class) {
                try {
                    if (lQY == null) {
                        lQY = new e();
                    }
                    eVar = lQY;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(20424);
                }
            }
            return eVar;
        }
        eVar = lQY;
        AppMethodBeat.o(20424);
        return eVar;
    }

    private e() {
    }

    public static void Q(String str, int i, int i2) {
        AppMethodBeat.i(20425);
        h.pYm.e(14869, str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(20425);
    }

    public static void R(String str, int i, int i2) {
        AppMethodBeat.i(20426);
        h.pYm.e(14868, str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(20426);
    }

    public static Cursor brX() {
        AppMethodBeat.i(20427);
        ab.i("MicroMsg.ExtQrCodeHandler", "hy: release temp mapping");
        c.clearCache();
        MatrixCursor Kn = com.tencent.mm.pluginsdk.d.a.a.Kn(1);
        AppMethodBeat.o(20427);
        return Kn;
    }

    public static b aH(String str, boolean z) {
        AppMethodBeat.i(20428);
        b aG = d.brV().aG(str, z);
        AppMethodBeat.o(20428);
        return aG;
    }

    public final a a(final b bVar) {
        AppMethodBeat.i(20429);
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = (a) new bj<a>(new a()) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(20419);
                a brZ = brZ();
                AppMethodBeat.o(20419);
                return brZ;
            }

            private a brZ() {
                AppMethodBeat.i(20418);
                try {
                    ab.d("MicroMsg.ExtQrCodeHandler", "hy: start scan qrcode");
                    if (bVar != null) {
                        oq oqVar = new oq();
                        oqVar.cKZ.width = bVar.aIV;
                        oqVar.cKZ.height = bVar.aIW;
                        oqVar.cKZ.cLb = bVar.lQX;
                        oqVar.cKZ.rotate = bVar.rotate;
                        oqVar.cKZ.cLa = bVar.cLa;
                        oqVar.cKZ.cLc = new r() {
                            public final void S(String str, int i, int i2) {
                                AppMethodBeat.i(20417);
                                ab.i("MicroMsg.ExtQrCodeHandler", "hy: result: %s, code type: %d, code version: %d", str, Integer.valueOf(i), Integer.valueOf(i2));
                                if (bo.isNullOrNil(str)) {
                                    ab.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved result!");
                                    AnonymousClass1.this.cC(null);
                                    AppMethodBeat.o(20417);
                                    return;
                                }
                                AnonymousClass1.this.cC(new a(i, str, i2));
                                AppMethodBeat.o(20417);
                            }
                        };
                        com.tencent.mm.sdk.b.a.xxA.m(oqVar);
                    } else {
                        ab.w("MicroMsg.ExtQrCodeHandler", "hy: qrcode data not retrieved");
                        cC(null);
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ExtQrCodeHandler", e, "hy: error when syncTaskScanQrCode", new Object[0]);
                    cC(null);
                }
                AppMethodBeat.o(20418);
                return null;
            }
        }.b(brY());
        String str = "MicroMsg.ExtQrCodeHandler";
        String str2 = "hy: resolved qrcode: %s, using: %d ms";
        Object[] objArr = new Object[2];
        objArr[0] = aVar != null ? aVar.toString() : BuildConfig.COMMAND;
        objArr[1] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        ab.i(str, str2, objArr);
        AppMethodBeat.o(20429);
        return aVar;
    }

    public static ak brY() {
        AppMethodBeat.i(20430);
        ak akVar = new ak(Looper.getMainLooper());
        AppMethodBeat.o(20430);
        return akVar;
    }
}
