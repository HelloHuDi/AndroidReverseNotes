package com.tencent.p177mm.plugin.wallet_core.id_verify.model;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.protocal.protobuf.ang;
import com.tencent.p177mm.protocal.protobuf.anh;
import com.tencent.p177mm.protocal.protobuf.awr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C24147k;
import com.tencent.p177mm.wallet_core.p649c.C24147k.C24153a;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.model.b */
public final class C40107b extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public C24147k nYe;
    public boolean ttQ = false;
    private long tvA = 10;

    public C40107b() {
        AppMethodBeat.m2504i(46636);
        C4990ab.m7416i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call");
        C1196a c1196a = new C1196a();
        ang ang = new ang();
        ang.vRP = C22594k.cPy();
        if (!C46512f.dlH()) {
            ang.vWV = C46512f.dlI();
        }
        c1196a.fsJ = ang;
        c1196a.fsK = new anh();
        c1196a.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
        c1196a.fsI = 1666;
        this.ehh = c1196a.acD();
        this.ehh.ftb = true;
        AppMethodBeat.m2505o(46636);
    }

    public final int getType() {
        return 1666;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46637);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(46637);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(46638);
        C4990ab.m7416i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            long j;
            anh anh = (anh) ((C7472b) c1929q).fsH.fsP;
            if (anh.wrT <= 0) {
                j = this.tvA;
            } else {
                j = anh.wrT;
            }
            this.ttQ = anh.ttQ;
            C4990ab.m7417i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", Boolean.valueOf(this.ttQ));
            JSONObject jSONObject = new JSONObject();
            try {
                C24147k c24147k;
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
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_REALNAME_SWITCH_WORDING_STRING_SYNC, jSONObject.toString());
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().dsb();
                awr awr = anh.wsd;
                if (awr == null) {
                    c24147k = null;
                } else {
                    c24147k = new C24147k();
                    c24147k.wAV = awr.wAV;
                    c24147k.ttd = awr.ttd;
                    c24147k.cEh = awr.cEh;
                    c24147k.nZb = awr.nZb;
                    c24147k.nZc = awr.nZc;
                    c24147k.title = awr.title;
                    c24147k.Afp = new C24153a();
                    if (awr.wAW != null) {
                        c24147k.Afp.type = awr.wAW.type;
                        c24147k.Afp.csB = awr.wAW.csB;
                        c24147k.Afp.wTe = awr.wAW.wTe;
                        c24147k.Afp.path = awr.wAW.path;
                        c24147k.Afp.tff = awr.wAW.tff;
                    }
                }
                this.nYe = c24147k;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", e, "", new Object[0]);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(46638);
    }
}
