package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.account.friend.a.t.b;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wxmm.v2helper;

public final class ad extends m implements k {
    f ehi = null;
    public final q ftU = new a();

    public static class a extends com.tencent.mm.ai.k {
        private final com.tencent.mm.plugin.account.friend.a.t.a gwe = new com.tencent.mm.plugin.account.friend.a.t.a();
        private final b gwf = new b();

        public a() {
            AppMethodBeat.i(108456);
            AppMethodBeat.o(108456);
        }

        public final d ZR() {
            return this.gwe;
        }

        public final e ZS() {
            return this.gwf;
        }

        public final int getType() {
            return v2helper.EMethodSetIosMicAbCheckOff;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/getsuggestalias";
        }

        public final int acC() {
            return 1;
        }
    }

    public ad(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(108457);
        com.tencent.mm.plugin.account.friend.a.t.a aVar = (com.tencent.mm.plugin.account.friend.a.t.a) this.ftU.acF();
        aVar.gvI.wsI = str;
        aVar.gvI.wsJ = str2;
        aVar.gvI.jCH = str3;
        aVar.gvI.wsK = str4;
        aVar.gvI.wsL = str5;
        aVar.gvI.wsM = str6;
        aVar.gvI.wsN = i;
        aVar.gvI.luQ = aa.dor();
        aoq aoq = aVar.gvI;
        g.RN();
        aoq.vIj = com.tencent.mm.kernel.a.Rb();
        AppMethodBeat.o(108457);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(108458);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(108458);
        return a;
    }

    public final int getType() {
        return v2helper.EMethodSetIosMicAbCheckOff;
    }

    public final int acn() {
        return 3;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final void a(com.tencent.mm.ai.m.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108459);
        if (i2 == 4 && i3 == ZipJNI.UNZ_PARAMERROR) {
            final int i4 = qVar.acF().vyj.ver;
            ab.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(108455);
                    new i().a(ad.this.ftf, new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(108454);
                            ab.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                ad.this.a(ad.this.ftf, ad.this.ehi);
                                AppMethodBeat.o(108454);
                                return;
                            }
                            ad.this.ehi.onSceneEnd(i, i2, "", ad.this);
                            AppMethodBeat.o(108454);
                        }
                    });
                    AppMethodBeat.o(108455);
                }
            });
            AppMethodBeat.o(108459);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108459);
    }

    public final byte[] ajo() {
        AppMethodBeat.i(108460);
        byte[] a = com.tencent.mm.platformtools.aa.a(((b) this.ftU.ZS()).gvJ.wsO, new byte[0]);
        AppMethodBeat.o(108460);
        return a;
    }

    public final String ajn() {
        AppMethodBeat.i(108461);
        String str = ((b) this.ftU.ZS()).gvJ.wsL;
        AppMethodBeat.o(108461);
        return str;
    }
}
