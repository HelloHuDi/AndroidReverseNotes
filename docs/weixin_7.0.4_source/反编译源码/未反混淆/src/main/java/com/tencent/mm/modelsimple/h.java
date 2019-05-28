package com.tencent.mm.modelsimple;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.jsapi.k.n;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.le;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.view.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h extends m implements k {
    public final b ehh;
    private f ehi;
    public Object tag;

    static class a {

        public enum a {
            AutoRoute,
            GetA8Key,
            MpGetA8Key,
            PayGetA8Key,
            MinorGetA8Key,
            ThridGetA8Key;

            static {
                AppMethodBeat.o(78567);
            }
        }

        static b a(a aVar) {
            AppMethodBeat.i(78568);
            com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
            aVar2.fsJ = new ado();
            aVar2.fsK = new adp();
            switch (aVar) {
                case GetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/geta8key";
                    aVar2.fsI = d.MIC_PTU_MEISHI;
                    aVar2.fsL = 155;
                    aVar2.fsM = 1000000155;
                    break;
                case MpGetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
                    aVar2.fsI = d.MIC_PTU_SHIGUANG;
                    aVar2.fsL = 345;
                    aVar2.fsM = 1000000345;
                    break;
                case PayGetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
                    aVar2.fsI = 835;
                    aVar2.fsL = com.tencent.mm.plugin.appbrand.jsapi.i.f.CTRL_INDEX;
                    aVar2.fsM = 1000000346;
                    break;
                case MinorGetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
                    aVar2.fsI = 812;
                    aVar2.fsL = 387;
                    aVar2.fsM = 1000000387;
                    break;
                case ThridGetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
                    aVar2.fsI = 226;
                    aVar2.fsL = n.CTRL_INDEX;
                    aVar2.fsM = 1000000388;
                    break;
                default:
                    aVar2.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
                    aVar2.fsI = 226;
                    aVar2.fsL = n.CTRL_INDEX;
                    aVar2.fsM = 1000000388;
                    break;
            }
            b acD = aVar2.acD();
            AppMethodBeat.o(78568);
            return acD;
        }

        static a aa(String str, int i) {
            AppMethodBeat.i(78569);
            a aVar;
            if (i == 5) {
                aVar = a.MinorGetA8Key;
                AppMethodBeat.o(78569);
                return aVar;
            } else if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
                aVar = a.GetA8Key;
                AppMethodBeat.o(78569);
                return aVar;
            } else {
                try {
                    Uri parse = Uri.parse(str);
                    if (parse == null) {
                        aVar = a.ThridGetA8Key;
                        AppMethodBeat.o(78569);
                        return aVar;
                    }
                    String toLowerCase = bo.nullAsNil(parse.getHost()).toLowerCase();
                    ab.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", toLowerCase, bo.isNullOrNil(parse.getFragment()) ? "" : "#" + parse.getFragment());
                    if (toLowerCase.equals("open.weixin.qq.com") || toLowerCase.equals("mp.weixin.qq.com") || toLowerCase.equals("mp.weixinbridge.com")) {
                        aVar = a.MpGetA8Key;
                        AppMethodBeat.o(78569);
                        return aVar;
                    } else if (r0.contains("wechat_pay")) {
                        aVar = a.PayGetA8Key;
                        AppMethodBeat.o(78569);
                        return aVar;
                    } else if (toLowerCase.contains(".qq.com") || toLowerCase.equals("qq.com") || toLowerCase.contains(".wechat.com") || toLowerCase.equals("wechat.com") || toLowerCase.contains(".tenpay.com") || toLowerCase.equals("tenpay.com") || toLowerCase.contains(".url.cn") || toLowerCase.equals("url.com") || !(str.startsWith("http://") || str.startsWith("https://"))) {
                        aVar = a.GetA8Key;
                        AppMethodBeat.o(78569);
                        return aVar;
                    } else {
                        aVar = a.ThridGetA8Key;
                        AppMethodBeat.o(78569);
                        return aVar;
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", e.getMessage());
                    aVar = a.GetA8Key;
                    AppMethodBeat.o(78569);
                    return aVar;
                }
            }
        }

        static b d(b bVar) {
            AppMethodBeat.i(78570);
            ado ado = (ado) bVar.fsG.fsP;
            g.RQ();
            String nullAsNil = bo.nullAsNil((String) g.RP().Ry().get(46, null));
            ado.vHP = new SKBuiltinBuffer_t().setBuffer(bo.anf(nullAsNil));
            g.RQ();
            String nullAsNil2 = bo.nullAsNil((String) g.RP().Ry().get(72, null));
            ado.wlr = new SKBuiltinBuffer_t().setBuffer(bo.anf(nullAsNil2));
            ab.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + nullAsNil + " newa2=" + nullAsNil2);
            AppMethodBeat.o(78570);
            return bVar;
        }
    }

    private h() {
        AppMethodBeat.i(78571);
        this.ehh = a.d(a.a(a.GetA8Key));
        AppMethodBeat.o(78571);
    }

    private h(String str, int i) {
        AppMethodBeat.i(78572);
        a aVar = a.AutoRoute;
        if (aVar == a.AutoRoute) {
            aVar = a.aa(str, i);
        }
        ab.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", str, aVar, Integer.valueOf(i));
        this.ehh = a.d(a.a(aVar));
        AppMethodBeat.o(78572);
    }

    private h(a aVar) {
        AppMethodBeat.i(78573);
        this.ehh = a.a(aVar);
        AppMethodBeat.o(78573);
    }

    public h(String str, String str2, String str3, int i) {
        this(a.MpGetA8Key);
        AppMethodBeat.i(78574);
        ado ado = (ado) this.ehh.fsG.fsP;
        ado.OpCode = 1;
        ado.wlk = new bts().alV(str);
        ado.wll = new bts().alV(str2);
        ado.wlm = new bts().alV(str3);
        ado.wlt = i;
        ab.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", str, Integer.valueOf(i));
        AppMethodBeat.o(78574);
    }

    public h(String str, String str2, int i, int i2, int i3, byte[] bArr) {
        this(str, i2);
        AppMethodBeat.i(78575);
        ado ado = (ado) this.ehh.fsG.fsP;
        ado.OpCode = 2;
        ado.wln = new bts().alV(str);
        ado.Scene = i;
        ado.jBB = str2;
        ado.vIw = i2;
        ado.wlt = i3;
        ado.wlw = new SKBuiltinBuffer_t().setBuffer(bArr);
        ab.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + str2 + ", scene = " + i + ", reason = " + i2 + ", requestId = " + i3);
        ab.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", bo.cd(bArr));
        AppMethodBeat.o(78575);
    }

    public h(String str, int i, int i2, int i3, String str2, int i4, byte[] bArr) {
        this(str, 0);
        AppMethodBeat.i(78576);
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
        ab.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + null + ", scene = " + i + ", reason = 0, codeType = " + i2 + ", codeVersion = " + i3 + ", requestId = " + i4);
        ab.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", bo.cd(bArr));
        AppMethodBeat.o(78576);
    }

    public h(String str, String str2, int i, int i2, int i3, String str3, int i4, String str4, String str5, int i5, byte[] bArr) {
        this(str, i2);
        AppMethodBeat.i(78577);
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
        ab.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str3, Integer.valueOf(i4), str4, str5, Integer.valueOf(i5), bo.cd(bArr));
        AppMethodBeat.o(78577);
    }

    public h(int i, int i2) {
        this();
        AppMethodBeat.i(78578);
        ado ado = (ado) this.ehh.fsG.fsP;
        ado.OpCode = 3;
        ado.Scene = 5;
        ado.wlp = i;
        ado.wlt = i2;
        ab.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", Integer.valueOf(i), Integer.valueOf(ado.vHP.getILen()), Integer.valueOf(i2));
        AppMethodBeat.o(78578);
    }

    public final int getType() {
        return d.MIC_PTU_MEISHI;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78579);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78579);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78580);
        ab.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", Integer.valueOf(i2), Integer.valueOf(i3), aiT(), ((adp) this.ehh.fsH.fsP).wlz);
        ab.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", bo.cd(ajc()));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78580);
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
        AppMethodBeat.i(78581);
        adp adp = (adp) this.ehh.fsH.fsP;
        if (adp.wlH == null) {
            AppMethodBeat.o(78581);
            return null;
        }
        try {
            byte[] a = aa.a(adp.wlH);
            AppMethodBeat.o(78581);
            return a;
        } catch (Exception e) {
            AppMethodBeat.o(78581);
            return null;
        }
    }

    public final String aiX() {
        return ((adp) this.ehh.fsH.fsP).wlC;
    }

    public final ArrayList<byte[]> aiY() {
        AppMethodBeat.i(78582);
        adp adp = (adp) this.ehh.fsH.fsP;
        ArrayList<byte[]> arrayList = new ArrayList();
        if (adp == null || adp.wlE == null) {
            AppMethodBeat.o(78582);
            return arrayList;
        }
        Iterator it = adp.wlE.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(((le) it.next()).toByteArray());
            } catch (IOException e) {
                ab.e("MicroMsg.NetSceneGetA8Key", "exception:%s", bo.l(e));
            }
        }
        ab.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(78582);
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
        AppMethodBeat.i(78583);
        adp adp = (adp) this.ehh.fsH.fsP;
        byte[] bArr;
        if (adp.wlw == null) {
            bArr = new byte[0];
            AppMethodBeat.o(78583);
            return bArr;
        }
        try {
            bArr = aa.a(adp.wlw);
            AppMethodBeat.o(78583);
            return bArr;
        } catch (Exception e) {
            bArr = new byte[0];
            AppMethodBeat.o(78583);
            return bArr;
        }
    }

    public final void tq(String str) {
        ((ado) this.ehh.fsG.fsP).wlx = str;
    }

    public final void lV(int i) {
        ((ado) this.ehh.fsG.fsP).vGB = i;
    }
}
