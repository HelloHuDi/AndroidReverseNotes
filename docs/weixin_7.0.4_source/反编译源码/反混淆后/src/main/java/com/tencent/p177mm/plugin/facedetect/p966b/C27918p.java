package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C18674i;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C17894n;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.protocal.protobuf.C7270lm;
import com.tencent.p177mm.protocal.protobuf.ato;
import com.tencent.p177mm.protocal.protobuf.bdu;
import com.tencent.p177mm.protocal.protobuf.bdv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.facedetect.b.p */
public abstract class C27918p extends C17894n implements C1918k {
    static String lSV = null;
    protected C1202f ehi = null;

    /* renamed from: Lo */
    public abstract void mo23582Lo(String str);

    /* renamed from: c */
    public abstract void mo23585c(int i, int i2, String str, C1929q c1929q);

    /* renamed from: g */
    public abstract int mo23586g(C1902e c1902e);

    /* renamed from: g */
    public abstract bdv mo23587g(C1929q c1929q);

    protected static String agg() {
        return lSV;
    }

    /* renamed from: Lp */
    public static void m44395Lp(String str) {
        lSV = str;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        this.ehi = c1202f;
        if (C5046bo.isNullOrNil(lSV)) {
            return getType();
        }
        C4990ab.m7417i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", lSV);
        mo23582Lo(lSV);
        return mo23586g(c1902e);
    }

    /* renamed from: c */
    public final C7270lm mo33417c(C1929q c1929q) {
        bdv g = mo23587g(c1929q);
        if (g != null) {
            return g.vLL;
        }
        return null;
    }

    /* renamed from: d */
    public final bdu mo33418d(C1929q c1929q) {
        bdv g = mo23587g(c1929q);
        if (g != null) {
            return g.vLM;
        }
        return null;
    }

    /* renamed from: e */
    public final ato mo33419e(C1929q c1929q) {
        bdv g = mo23587g(c1929q);
        if (g != null) {
            return g.vLK;
        }
        return null;
    }

    public final void acP() {
        if (this.ehi != null) {
            this.ehi.onSceneEnd(3, -1, "", this);
        }
    }

    public final C1202f acQ() {
        return this.ehi;
    }

    /* renamed from: a */
    public final void mo33414a(int i, int i2, String str, C1929q c1929q) {
        C4990ab.m7417i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 4 && i2 == ZipJNI.UNZ_PARAMERROR) {
            final int i3 = c1929q.acF().vyj.ver;
            C4990ab.m7411d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i3));
            C1720g.m3539RS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.facedetect.b.p$1$1 */
                class C117921 implements C1202f {
                    C117921() {
                    }

                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(93);
                        C4990ab.m7411d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            C27918p.this.mo23586g(C27918p.this.ftf);
                            AppMethodBeat.m2505o(93);
                            return;
                        }
                        C4990ab.m7412e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
                        C27918p.lSV = null;
                        C27918p.this.mo23582Lo(C27918p.agg());
                        C27918p.this.ehi.onSceneEnd(i, i2, "", C27918p.this);
                        AppMethodBeat.m2505o(93);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(94);
                    new C18674i().mo4456a(C27918p.this.ftf, new C117921());
                    AppMethodBeat.m2505o(94);
                }
            });
            return;
        }
        mo23585c(i, i2, str, c1929q);
    }
}
