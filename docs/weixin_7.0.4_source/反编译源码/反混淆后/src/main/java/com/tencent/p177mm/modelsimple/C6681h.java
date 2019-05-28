package com.tencent.p177mm.modelsimple;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C45604f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C19405n;
import com.tencent.p177mm.protocal.protobuf.C40541le;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.ado;
import com.tencent.p177mm.protocal.protobuf.adp;
import com.tencent.p177mm.protocal.protobuf.atp;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.modelsimple.h */
public final class C6681h extends C1207m implements C1918k {
    public final C7472b ehh;
    private C1202f ehi;
    public Object tag;

    /* renamed from: com.tencent.mm.modelsimple.h$a */
    static class C6683a {

        /* renamed from: com.tencent.mm.modelsimple.h$a$a */
        public enum C6684a {
            AutoRoute,
            GetA8Key,
            MpGetA8Key,
            PayGetA8Key,
            MinorGetA8Key,
            ThridGetA8Key;

            static {
                AppMethodBeat.m2505o(78567);
            }
        }

        /* renamed from: a */
        static C7472b m11099a(C6684a c6684a) {
            AppMethodBeat.m2504i(78568);
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new ado();
            c1196a.fsK = new adp();
            switch (c6684a) {
                case GetA8Key:
                    c1196a.uri = "/cgi-bin/micromsg-bin/geta8key";
                    c1196a.fsI = C31128d.MIC_PTU_MEISHI;
                    c1196a.fsL = 155;
                    c1196a.fsM = 1000000155;
                    break;
                case MpGetA8Key:
                    c1196a.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
                    c1196a.fsI = C31128d.MIC_PTU_SHIGUANG;
                    c1196a.fsL = 345;
                    c1196a.fsM = 1000000345;
                    break;
                case PayGetA8Key:
                    c1196a.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
                    c1196a.fsI = 835;
                    c1196a.fsL = C45604f.CTRL_INDEX;
                    c1196a.fsM = 1000000346;
                    break;
                case MinorGetA8Key:
                    c1196a.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
                    c1196a.fsI = 812;
                    c1196a.fsL = 387;
                    c1196a.fsM = 1000000387;
                    break;
                case ThridGetA8Key:
                    c1196a.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
                    c1196a.fsI = 226;
                    c1196a.fsL = C19405n.CTRL_INDEX;
                    c1196a.fsM = 1000000388;
                    break;
                default:
                    c1196a.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
                    c1196a.fsI = 226;
                    c1196a.fsL = C19405n.CTRL_INDEX;
                    c1196a.fsM = 1000000388;
                    break;
            }
            C7472b acD = c1196a.acD();
            AppMethodBeat.m2505o(78568);
            return acD;
        }

        /* renamed from: aa */
        static C6684a m11100aa(String str, int i) {
            AppMethodBeat.m2504i(78569);
            C6684a c6684a;
            if (i == 5) {
                c6684a = C6684a.MinorGetA8Key;
                AppMethodBeat.m2505o(78569);
                return c6684a;
            } else if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
                c6684a = C6684a.GetA8Key;
                AppMethodBeat.m2505o(78569);
                return c6684a;
            } else {
                try {
                    Uri parse = Uri.parse(str);
                    if (parse == null) {
                        c6684a = C6684a.ThridGetA8Key;
                        AppMethodBeat.m2505o(78569);
                        return c6684a;
                    }
                    String toLowerCase = C5046bo.nullAsNil(parse.getHost()).toLowerCase();
                    C4990ab.m7411d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", toLowerCase, C5046bo.isNullOrNil(parse.getFragment()) ? "" : "#" + parse.getFragment());
                    if (toLowerCase.equals("open.weixin.qq.com") || toLowerCase.equals("mp.weixin.qq.com") || toLowerCase.equals("mp.weixinbridge.com")) {
                        c6684a = C6684a.MpGetA8Key;
                        AppMethodBeat.m2505o(78569);
                        return c6684a;
                    } else if (r0.contains("wechat_pay")) {
                        c6684a = C6684a.PayGetA8Key;
                        AppMethodBeat.m2505o(78569);
                        return c6684a;
                    } else if (toLowerCase.contains(".qq.com") || toLowerCase.equals("qq.com") || toLowerCase.contains(".wechat.com") || toLowerCase.equals("wechat.com") || toLowerCase.contains(".tenpay.com") || toLowerCase.equals("tenpay.com") || toLowerCase.contains(".url.cn") || toLowerCase.equals("url.com") || !(str.startsWith("http://") || str.startsWith("https://"))) {
                        c6684a = C6684a.GetA8Key;
                        AppMethodBeat.m2505o(78569);
                        return c6684a;
                    } else {
                        c6684a = C6684a.ThridGetA8Key;
                        AppMethodBeat.m2505o(78569);
                        return c6684a;
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", e.getMessage());
                    c6684a = C6684a.GetA8Key;
                    AppMethodBeat.m2505o(78569);
                    return c6684a;
                }
            }
        }

        /* renamed from: d */
        static C7472b m11101d(C7472b c7472b) {
            AppMethodBeat.m2504i(78570);
            ado ado = (ado) c7472b.fsG.fsP;
            C1720g.m3537RQ();
            String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(46, null));
            ado.vHP = new SKBuiltinBuffer_t().setBuffer(C5046bo.anf(nullAsNil));
            C1720g.m3537RQ();
            String nullAsNil2 = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(72, null));
            ado.wlr = new SKBuiltinBuffer_t().setBuffer(C5046bo.anf(nullAsNil2));
            C4990ab.m7410d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + nullAsNil + " newa2=" + nullAsNil2);
            AppMethodBeat.m2505o(78570);
            return c7472b;
        }
    }

    private C6681h() {
        AppMethodBeat.m2504i(78571);
        this.ehh = C6683a.m11101d(C6683a.m11099a(C6684a.GetA8Key));
        AppMethodBeat.m2505o(78571);
    }

    private C6681h(String str, int i) {
        AppMethodBeat.m2504i(78572);
        C6684a c6684a = C6684a.AutoRoute;
        if (c6684a == C6684a.AutoRoute) {
            c6684a = C6683a.m11100aa(str, i);
        }
        C4990ab.m7417i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", str, c6684a, Integer.valueOf(i));
        this.ehh = C6683a.m11101d(C6683a.m11099a(c6684a));
        AppMethodBeat.m2505o(78572);
    }

    private C6681h(C6684a c6684a) {
        AppMethodBeat.m2504i(78573);
        this.ehh = C6683a.m11099a(c6684a);
        AppMethodBeat.m2505o(78573);
    }

    public C6681h(String str, String str2, String str3, int i) {
        this(C6684a.MpGetA8Key);
        AppMethodBeat.m2504i(78574);
        ado ado = (ado) this.ehh.fsG.fsP;
        ado.OpCode = 1;
        ado.wlk = new bts().alV(str);
        ado.wll = new bts().alV(str2);
        ado.wlm = new bts().alV(str3);
        ado.wlt = i;
        C4990ab.m7411d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", str, Integer.valueOf(i));
        AppMethodBeat.m2505o(78574);
    }

    public C6681h(String str, String str2, int i, int i2, int i3, byte[] bArr) {
        this(str, i2);
        AppMethodBeat.m2504i(78575);
        ado ado = (ado) this.ehh.fsG.fsP;
        ado.OpCode = 2;
        ado.wln = new bts().alV(str);
        ado.Scene = i;
        ado.jBB = str2;
        ado.vIw = i2;
        ado.wlt = i3;
        ado.wlw = new SKBuiltinBuffer_t().setBuffer(bArr);
        C4990ab.m7410d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + str2 + ", scene = " + i + ", reason = " + i2 + ", requestId = " + i3);
        C4990ab.m7411d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", C5046bo.m7543cd(bArr));
        AppMethodBeat.m2505o(78575);
    }

    public C6681h(String str, int i, int i2, int i3, String str2, int i4, byte[] bArr) {
        this(str, 0);
        AppMethodBeat.m2504i(78576);
        ado ado = (ado) this.ehh.fsG.fsP;
        ado.OpCode = 2;
        ado.wln = new bts().alV(str);
        ado.Scene = i;
        ado.jBB = null;
        ado.vIw = 0;
        ado.vXI = i2;
        ado.vXJ = i3;
        ado.wlt = i4;
        ado.wlk = new bts().alV(str2);
        ado.wlw = new SKBuiltinBuffer_t().setBuffer(bArr);
        C4990ab.m7410d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + null + ", scene = " + i + ", reason = 0, codeType = " + i2 + ", codeVersion = " + i3 + ", requestId = " + i4);
        C4990ab.m7411d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", C5046bo.m7543cd(bArr));
        AppMethodBeat.m2505o(78576);
    }

    public C6681h(String str, String str2, int i, int i2, int i3, String str3, int i4, String str4, String str5, int i5, byte[] bArr) {
        this(str, i2);
        AppMethodBeat.m2504i(78577);
        ado ado = (ado) this.ehh.fsG.fsP;
        ado.OpCode = 2;
        ado.wln = new bts().alV(str);
        ado.Scene = i;
        ado.jBB = str2;
        ado.vIw = i2;
        ado.vEq = i3;
        ado.vKt = str3;
        ado.wlt = i4;
        ado.wlu = str5;
        ado.wlv = i5;
        ado.wlk = new bts().alV(str4);
        ado.wlw = new SKBuiltinBuffer_t().setBuffer(bArr);
        C4990ab.m7417i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str3, Integer.valueOf(i4), str4, str5, Integer.valueOf(i5), C5046bo.m7543cd(bArr));
        AppMethodBeat.m2505o(78577);
    }

    public C6681h(int i, int i2) {
        this();
        AppMethodBeat.m2504i(78578);
        ado ado = (ado) this.ehh.fsG.fsP;
        ado.OpCode = 3;
        ado.Scene = 5;
        ado.wlp = i;
        ado.wlt = i2;
        C4990ab.m7411d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", Integer.valueOf(i), Integer.valueOf(ado.vHP.getILen()), Integer.valueOf(i2));
        AppMethodBeat.m2505o(78578);
    }

    public final int getType() {
        return C31128d.MIC_PTU_MEISHI;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78579);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78579);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78580);
        C4990ab.m7411d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", Integer.valueOf(i2), Integer.valueOf(i3), aiT(), ((adp) this.ehh.fsH.fsP).wlz);
        C4990ab.m7411d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", C5046bo.m7543cd(ajc()));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78580);
    }

    public final String aiT() {
        return ((adp) this.ehh.fsH.fsP).wly;
    }

    public final String aiU() {
        bts bts = ((ado) this.ehh.fsG.fsP).wln;
        if (bts != null) {
            return bts.wVI;
        }
        return null;
    }

    public final String getTitle() {
        return ((adp) this.ehh.fsH.fsP).Title;
    }

    public final String getContent() {
        return ((adp) this.ehh.fsH.fsP).ncM;
    }

    public final int aiV() {
        return ((adp) this.ehh.fsH.fsP).vAS;
    }

    public final byte[] aiW() {
        AppMethodBeat.m2504i(78581);
        adp adp = (adp) this.ehh.fsH.fsP;
        if (adp.wlH == null) {
            AppMethodBeat.m2505o(78581);
            return null;
        }
        try {
            byte[] a = C1946aa.m4150a(adp.wlH);
            AppMethodBeat.m2505o(78581);
            return a;
        } catch (Exception e) {
            AppMethodBeat.m2505o(78581);
            return null;
        }
    }

    public final String aiX() {
        return ((adp) this.ehh.fsH.fsP).wlC;
    }

    public final ArrayList<byte[]> aiY() {
        AppMethodBeat.m2504i(78582);
        adp adp = (adp) this.ehh.fsH.fsP;
        ArrayList<byte[]> arrayList = new ArrayList();
        if (adp == null || adp.wlE == null) {
            AppMethodBeat.m2505o(78582);
            return arrayList;
        }
        Iterator it = adp.wlE.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(((C40541le) it.next()).toByteArray());
            } catch (IOException e) {
                C4990ab.m7413e("MicroMsg.NetSceneGetA8Key", "exception:%s", C5046bo.m7574l(e));
            }
        }
        C4990ab.m7411d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", Integer.valueOf(arrayList.size()));
        AppMethodBeat.m2505o(78582);
        return arrayList;
    }

    public final long aiZ() {
        adp adp = (adp) this.ehh.fsH.fsP;
        return adp.wlG != null ? adp.wlG.wcz : -1;
    }

    public final List<atp> aja() {
        return ((adp) this.ehh.fsH.fsP).wlJ;
    }

    public final int ajb() {
        return ((ado) this.ehh.fsG.fsP).wlt;
    }

    public final byte[] ajc() {
        AppMethodBeat.m2504i(78583);
        adp adp = (adp) this.ehh.fsH.fsP;
        byte[] bArr;
        if (adp.wlw == null) {
            bArr = new byte[0];
            AppMethodBeat.m2505o(78583);
            return bArr;
        }
        try {
            bArr = C1946aa.m4150a(adp.wlw);
            AppMethodBeat.m2505o(78583);
            return bArr;
        } catch (Exception e) {
            bArr = new byte[0];
            AppMethodBeat.m2505o(78583);
            return bArr;
        }
    }

    /* renamed from: tq */
    public final void mo14920tq(String str) {
        ((ado) this.ehh.fsG.fsP).wlx = str;
    }

    /* renamed from: lV */
    public final void mo14919lV(int i) {
        ((ado) this.ehh.fsG.fsP).vGB = i;
    }
}
