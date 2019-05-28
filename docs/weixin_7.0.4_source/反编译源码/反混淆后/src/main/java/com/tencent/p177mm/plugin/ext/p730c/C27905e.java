package com.tencent.p177mm.plugin.ext.p730c;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C45353oq;
import com.tencent.p177mm.plugin.ext.p730c.C38994d.C38995b;
import com.tencent.p177mm.plugin.ext.p730c.p963a.C11772a;
import com.tencent.p177mm.plugin.facedetect.model.C43038r;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1568d.p1569a.C40420a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.ext.c.e */
public class C27905e {
    public static C27905e lQY = null;
    public Context mContext = null;

    /* renamed from: com.tencent.mm.plugin.ext.c.e$2 */
    public class C68892 extends C5039bj<Boolean> {
        final /* synthetic */ int hHu;
        final /* synthetic */ int hHv;
        final /* synthetic */ String val$url;

        /* renamed from: com.tencent.mm.plugin.ext.c.e$2$1 */
        class C68901 implements C1202f {
            C68901() {
            }

            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                boolean z;
                AppMethodBeat.m2504i(20420);
                if (((C11772a) c1207m).lRf == 0) {
                    z = true;
                } else {
                    z = false;
                }
                C4990ab.m7417i("MicroMsg.ExtQrCodeHandler", "hy: check url done. errType: %d, errCode: %d, errMsg %s, scene: %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                C1720g.m3535RO().eJo.mo14546b(782, (C1202f) this);
                if (i == 0 && i2 == 0) {
                    C68892.this.mo10373cC(Boolean.valueOf(z));
                    AppMethodBeat.m2505o(20420);
                    return;
                }
                C68892.this.mo10373cC(Boolean.FALSE);
                AppMethodBeat.m2505o(20420);
            }
        }

        public C68892(Boolean bool, String str, int i, int i2) {
            this.val$url = str;
            this.hHu = i;
            this.hHv = i2;
            super(5000, bool);
        }

        public final /* synthetic */ Object run() {
            AppMethodBeat.m2504i(20422);
            Boolean aKg = aKg();
            AppMethodBeat.m2505o(20422);
            return aKg;
        }

        private Boolean aKg() {
            AppMethodBeat.m2504i(20421);
            C1720g.m3535RO().eJo.mo14539a(782, new C68901());
            C1720g.m3535RO().eJo.mo14541a(new C11772a(this.val$url, this.hHu, this.hHv), 0);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.m2505o(20421);
            return bool;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.c.e$a */
    public static class C27906a {
        public int lRd;
        private boolean lRe;
        public int type;
        public String url;

        public C27906a(int i, String str, int i2) {
            this.lRe = false;
            this.type = i;
            this.url = str;
            this.lRe = false;
            this.lRd = i2;
        }

        public C27906a() {
            this.lRe = false;
            this.lRe = true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(20423);
            String str = "QrCodeModel{type=" + this.type + ", url='" + this.url + '\'' + ", flagTimeout=" + this.lRe + '}';
            AppMethodBeat.m2505o(20423);
            return str;
        }
    }

    public static C27905e brW() {
        AppMethodBeat.m2504i(20424);
        C27905e c27905e;
        if (lQY == null) {
            synchronized (C27905e.class) {
                try {
                    if (lQY == null) {
                        lQY = new C27905e();
                    }
                    c27905e = lQY;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(20424);
                }
            }
            return c27905e;
        }
        c27905e = lQY;
        AppMethodBeat.m2505o(20424);
        return c27905e;
    }

    private C27905e() {
    }

    /* renamed from: Q */
    public static void m44383Q(String str, int i, int i2) {
        AppMethodBeat.m2504i(20425);
        C7060h.pYm.mo8381e(14869, str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(20425);
    }

    /* renamed from: R */
    public static void m44384R(String str, int i, int i2) {
        AppMethodBeat.m2504i(20426);
        C7060h.pYm.mo8381e(14868, str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(20426);
    }

    public static Cursor brX() {
        AppMethodBeat.m2504i(20427);
        C4990ab.m7416i("MicroMsg.ExtQrCodeHandler", "hy: release temp mapping");
        C45907c.clearCache();
        MatrixCursor Kn = C40420a.m69330Kn(1);
        AppMethodBeat.m2505o(20427);
        return Kn;
    }

    /* renamed from: aH */
    public static C38995b m44385aH(String str, boolean z) {
        AppMethodBeat.m2504i(20428);
        C38995b aG = C38994d.brV().mo61880aG(str, z);
        AppMethodBeat.m2505o(20428);
        return aG;
    }

    /* renamed from: a */
    public final C27906a mo45807a(final C38995b c38995b) {
        AppMethodBeat.m2504i(20429);
        long currentTimeMillis = System.currentTimeMillis();
        C27906a c27906a = (C27906a) new C5039bj<C27906a>(new C27906a()) {

            /* renamed from: com.tencent.mm.plugin.ext.c.e$1$1 */
            class C117751 implements C43038r {
                C117751() {
                }

                /* renamed from: S */
                public final void mo23565S(String str, int i, int i2) {
                    AppMethodBeat.m2504i(20417);
                    C4990ab.m7417i("MicroMsg.ExtQrCodeHandler", "hy: result: %s, code type: %d, code version: %d", str, Integer.valueOf(i), Integer.valueOf(i2));
                    if (C5046bo.isNullOrNil(str)) {
                        C4990ab.m7420w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved result!");
                        C117741.this.mo10373cC(null);
                        AppMethodBeat.m2505o(20417);
                        return;
                    }
                    C117741.this.mo10373cC(new C27906a(i, str, i2));
                    AppMethodBeat.m2505o(20417);
                }
            }

            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(20419);
                C27906a brZ = brZ();
                AppMethodBeat.m2505o(20419);
                return brZ;
            }

            private C27906a brZ() {
                AppMethodBeat.m2504i(20418);
                try {
                    C4990ab.m7410d("MicroMsg.ExtQrCodeHandler", "hy: start scan qrcode");
                    if (c38995b != null) {
                        C45353oq c45353oq = new C45353oq();
                        c45353oq.cKZ.width = c38995b.aIV;
                        c45353oq.cKZ.height = c38995b.aIW;
                        c45353oq.cKZ.cLb = c38995b.lQX;
                        c45353oq.cKZ.rotate = c38995b.rotate;
                        c45353oq.cKZ.cLa = c38995b.cLa;
                        c45353oq.cKZ.cLc = new C117751();
                        C4879a.xxA.mo10055m(c45353oq);
                    } else {
                        C4990ab.m7420w("MicroMsg.ExtQrCodeHandler", "hy: qrcode data not retrieved");
                        mo10373cC(null);
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ExtQrCodeHandler", e, "hy: error when syncTaskScanQrCode", new Object[0]);
                    mo10373cC(null);
                }
                AppMethodBeat.m2505o(20418);
                return null;
            }
        }.mo10372b(C27905e.brY());
        String str = "MicroMsg.ExtQrCodeHandler";
        String str2 = "hy: resolved qrcode: %s, using: %d ms";
        Object[] objArr = new Object[2];
        objArr[0] = c27906a != null ? c27906a.toString() : BuildConfig.COMMAND;
        objArr[1] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(20429);
        return c27906a;
    }

    public static C7306ak brY() {
        AppMethodBeat.m2504i(20430);
        C7306ak c7306ak = new C7306ak(Looper.getMainLooper());
        AppMethodBeat.m2505o(20430);
        return c7306ak;
    }
}
