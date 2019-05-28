package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends m implements k {
    private com.tencent.mm.ai.b ehh;
    private f ehi;
    public com.tencent.mm.wallet_core.c.k nYe;
    public boolean ttQ = false;
    private long tvA = 10;

    public b() {
        AppMethodBeat.i(46636);
        ab.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call");
        a aVar = new a();
        ang ang = new ang();
        ang.vRP = com.tencent.mm.plugin.wallet_core.model.k.cPy();
        if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
            ang.vWV = com.tencent.mm.pluginsdk.wallet.f.dlI();
        }
        aVar.fsJ = ang;
        aVar.fsK = new anh();
        aVar.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
        aVar.fsI = 1666;
        this.ehh = aVar.acD();
        this.ehh.ftb = true;
        AppMethodBeat.o(46636);
    }

    public final int getType() {
        return 1666;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46637);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(46637);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(46638);
        ab.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            long j;
            anh anh = (anh) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
            if (anh.wrT <= 0) {
                j = this.tvA;
            } else {
                j = anh.wrT;
            }
            this.ttQ = anh.ttQ;
            ab.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", Boolean.valueOf(this.ttQ));
            JSONObject jSONObject = new JSONObject();
            try {
                com.tencent.mm.wallet_core.c.k kVar;
                jSONObject.put("bindcardTitle", anh.wrM);
                jSONObject.put("bindcardSubTitle", anh.wrN);
                jSONObject.put("bindIdTitle", anh.wrO);
                jSONObject.put("bindIdSubTitle", anh.wrP);
                jSONObject.put("extral_wording", anh.wrQ);
                jSONObject.put("question_answer_switch", anh.wrR);
                jSONObject.put("question_answer_url", anh.wrS);
                jSONObject.put("cache_time", j);
                jSONObject.put(Param.TIMESTAMP, Long.valueOf(System.currentTimeMillis() / 1000));
                jSONObject.put("isShowBindCard", anh.wrU);
                jSONObject.put("isShowBindCardVerify", anh.wrW);
                jSONObject.put("isShowBindId", anh.wrV);
                jSONObject.put("bindCardVerifyTitle", anh.wrX);
                jSONObject.put("bindCardVerifySubtitle", anh.wrY);
                jSONObject.put("bindCardVerifyAlertViewRightBtnTxt", anh.wrZ);
                jSONObject.put("bindCardVerifyAlertViewContent", anh.wsa);
                jSONObject.put("isShowBindCardVerifyAlertView", anh.wsb);
                if (anh.wsc != null && anh.wsc.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Object obj = null;
                    Iterator it = anh.wsc.iterator();
                    while (true) {
                        Object obj2 = obj;
                        if (!it.hasNext()) {
                            break;
                        }
                        String str2 = (String) it.next();
                        if (obj2 != null) {
                            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        stringBuffer.append(str2);
                        obj = 1;
                    }
                    jSONObject.put("cache_header_titles", stringBuffer.toString());
                }
                jSONObject.put("isShowCapitalSecurity", anh.wse);
                g.RQ();
                g.RP().Ry().set(ac.a.USERINFO_WALLET_REALNAME_SWITCH_WORDING_STRING_SYNC, jSONObject.toString());
                g.RQ();
                g.RP().Ry().dsb();
                awr awr = anh.wsd;
                if (awr == null) {
                    kVar = null;
                } else {
                    kVar = new com.tencent.mm.wallet_core.c.k();
                    kVar.wAV = awr.wAV;
                    kVar.ttd = awr.ttd;
                    kVar.cEh = awr.cEh;
                    kVar.nZb = awr.nZb;
                    kVar.nZc = awr.nZc;
                    kVar.title = awr.title;
                    kVar.Afp = new com.tencent.mm.wallet_core.c.k.a();
                    if (awr.wAW != null) {
                        kVar.Afp.type = awr.wAW.type;
                        kVar.Afp.csB = awr.wAW.csB;
                        kVar.Afp.wTe = awr.wAW.wTe;
                        kVar.Afp.path = awr.wAW.path;
                        kVar.Afp.tff = awr.wAW.tff;
                    }
                }
                this.nYe = kVar;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", e, "", new Object[0]);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(46638);
    }
}
