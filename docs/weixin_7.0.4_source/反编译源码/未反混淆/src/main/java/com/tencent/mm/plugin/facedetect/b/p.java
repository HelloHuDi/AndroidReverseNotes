package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class p extends n implements k {
    static String lSV = null;
    protected f ehi = null;

    public abstract void Lo(String str);

    public abstract void c(int i, int i2, String str, q qVar);

    public abstract int g(e eVar);

    public abstract bdv g(q qVar);

    protected static String agg() {
        return lSV;
    }

    public static void Lp(String str) {
        lSV = str;
    }

    public final int a(e eVar, f fVar) {
        this.ehi = fVar;
        if (bo.isNullOrNil(lSV)) {
            return getType();
        }
        ab.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", lSV);
        Lo(lSV);
        return g(eVar);
    }

    public final lm c(q qVar) {
        bdv g = g(qVar);
        if (g != null) {
            return g.vLL;
        }
        return null;
    }

    public final bdu d(q qVar) {
        bdv g = g(qVar);
        if (g != null) {
            return g.vLM;
        }
        return null;
    }

    public final ato e(q qVar) {
        bdv g = g(qVar);
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

    public final f acQ() {
        return this.ehi;
    }

    public final void a(int i, int i2, String str, q qVar) {
        ab.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 4 && i2 == ZipJNI.UNZ_PARAMERROR) {
            final int i3 = qVar.acF().vyj.ver;
            ab.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i3));
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(94);
                    new i().a(p.this.ftf, new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(93);
                            ab.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                p.this.g(p.this.ftf);
                                AppMethodBeat.o(93);
                                return;
                            }
                            ab.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
                            p.lSV = null;
                            p.this.Lo(p.agg());
                            p.this.ehi.onSceneEnd(i, i2, "", p.this);
                            AppMethodBeat.o(93);
                        }
                    });
                    AppMethodBeat.o(94);
                }
            });
            return;
        }
        c(i, i2, str, qVar);
    }
}
