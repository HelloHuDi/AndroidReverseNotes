package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C18674i;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.account.friend.p272a.C1990t.C1991a;
import com.tencent.p177mm.plugin.account.friend.p272a.C1990t.C1992b;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.aoq;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.wxmm.v2helper;

/* renamed from: com.tencent.mm.plugin.account.friend.a.ad */
public final class C6717ad extends C1207m implements C1918k {
    C1202f ehi = null;
    public final C1929q ftU = new C6720a();

    /* renamed from: com.tencent.mm.plugin.account.friend.a.ad$a */
    public static class C6720a extends C6297k {
        private final C1991a gwe = new C1991a();
        private final C1992b gwf = new C1992b();

        public C6720a() {
            AppMethodBeat.m2504i(108456);
            AppMethodBeat.m2505o(108456);
        }

        /* renamed from: ZR */
        public final C4834d mo14537ZR() {
            return this.gwe;
        }

        /* renamed from: ZS */
        public final C4835e mo5618ZS() {
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

    public C6717ad(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(108457);
        C1991a c1991a = (C1991a) this.ftU.acF();
        c1991a.gvI.wsI = str;
        c1991a.gvI.wsJ = str2;
        c1991a.gvI.jCH = str3;
        c1991a.gvI.wsK = str4;
        c1991a.gvI.wsL = str5;
        c1991a.gvI.wsM = str6;
        c1991a.gvI.wsN = i;
        c1991a.gvI.luQ = C4988aa.dor();
        aoq aoq = c1991a.gvI;
        C1720g.m3534RN();
        aoq.vIj = C1668a.m3397Rb();
        AppMethodBeat.m2505o(108457);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108458);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(108458);
        return a;
    }

    public final int getType() {
        return v2helper.EMethodSetIosMicAbCheckOff;
    }

    public final int acn() {
        return 3;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108459);
        if (i2 == 4 && i3 == ZipJNI.UNZ_PARAMERROR) {
            final int i4 = c1929q.acF().vyj.ver;
            C4990ab.m7411d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            C1720g.m3539RS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.account.friend.a.ad$1$1 */
                class C67191 implements C1202f {
                    C67191() {
                    }

                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(108454);
                        C4990ab.m7411d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            C6717ad.this.mo4456a(C6717ad.this.ftf, C6717ad.this.ehi);
                            AppMethodBeat.m2505o(108454);
                            return;
                        }
                        C6717ad.this.ehi.onSceneEnd(i, i2, "", C6717ad.this);
                        AppMethodBeat.m2505o(108454);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(108455);
                    new C18674i().mo4456a(C6717ad.this.ftf, new C67191());
                    AppMethodBeat.m2505o(108455);
                }
            });
            AppMethodBeat.m2505o(108459);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108459);
    }

    public final byte[] ajo() {
        AppMethodBeat.m2504i(108460);
        byte[] a = C1946aa.m4151a(((C1992b) this.ftU.mo5618ZS()).gvJ.wsO, new byte[0]);
        AppMethodBeat.m2505o(108460);
        return a;
    }

    public final String ajn() {
        AppMethodBeat.m2504i(108461);
        String str = ((C1992b) this.ftU.mo5618ZS()).gvJ.wsL;
        AppMethodBeat.m2505o(108461);
        return str;
    }
}
