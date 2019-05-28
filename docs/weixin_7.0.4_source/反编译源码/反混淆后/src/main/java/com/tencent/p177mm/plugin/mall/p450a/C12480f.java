package com.tencent.p177mm.plugin.mall.p450a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bio.face.C33253d;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C14237a;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C29636b;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C40113c;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.p177mm.protocal.protobuf.aly;
import com.tencent.p177mm.protocal.protobuf.alz;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.mall.a.f */
public final class C12480f extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    private String okO;
    public ArrayList<MallFunction> okP;
    public ArrayList<MallNews> okQ;
    public ArrayList<C14237a> okR;
    public SparseArray<String> okS;
    public int okT;

    public C12480f(int i, String str, int i2) {
        this(i, str, null, null, i2);
    }

    public C12480f(int i, String str, String str2, String str3, String str4) {
        this(i, str, str3, String.format("appid=%s&funcid=%s&url=%s", new Object[]{str2, str3, URLEncoder.encode(str4, "ISO-8859-1").toString()}), 0);
        AppMethodBeat.m2504i(43098);
        AppMethodBeat.m2505o(43098);
    }

    private C12480f(int i, String str, String str2, String str3, int i2) {
        List cQU;
        AppMethodBeat.m2504i(43099);
        this.okP = null;
        this.okQ = null;
        this.okR = null;
        this.okS = null;
        this.okT = 0;
        this.okT = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aly();
        c1196a.fsK = new alz();
        c1196a.uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
        c1196a.fsI = C33253d.CTRL_INDEX;
        c1196a.fsL = 227;
        c1196a.fsM = 1000000227;
        this.ehh = c1196a.acD();
        aly aly = (aly) this.ehh.fsG.fsP;
        aly.wqY = str;
        LinkedList linkedList = new LinkedList();
        if (C5046bo.isNullOrNil(str2)) {
            cQU = C40113c.cQT().cQU();
        } else {
            ArrayList arrayList;
            MallNews mallNews = (MallNews) C40113c.cQT().tDE.get(str2);
            if (mallNews == null || C5046bo.isNullOrNil(mallNews.cxb)) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(mallNews.cxb);
                arrayList = arrayList2;
            }
            cQU = arrayList;
        }
        if (cQU != null && cQU.size() > 0) {
            String str4;
            String str5 = "";
            Iterator it = cQU.iterator();
            while (true) {
                str4 = str5;
                if (!it.hasNext()) {
                    break;
                }
                str5 = (String) it.next();
                bts bts = new bts();
                bts.alV(str5);
                linkedList.add(bts);
                str5 = str4 + "; + " + str5;
            }
            C4990ab.m7410d("MicroMsg.NetSceneGetPayFunctionList", "post with list : ".concat(String.valueOf(str4)));
        }
        aly.wra = linkedList;
        aly.wqZ = linkedList.size();
        if (C5046bo.isNullOrNil(str3)) {
            aly.ndT = String.format("tpa_country=%s", new Object[]{Integer.valueOf(i)});
        } else {
            aly.ndT = String.format("%s&tpa_country=%s", new Object[]{str3, Integer.valueOf(i)});
        }
        aly.wrb = i2;
        this.okO = str2;
        C4990ab.m7410d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + str + " ExtInfo: " + aly.ndT);
        AppMethodBeat.m2505o(43099);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(43100);
        C4990ab.m7416i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            alz alz = (alz) ((C7472b) c1929q).fsH.fsP;
            C4990ab.m7416i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.okT + " " + alz.wrc);
            try {
                if (!C5046bo.isNullOrNil(alz.wrc)) {
                    JSONObject jSONObject = new JSONObject(alz.wrc);
                    String optString = jSONObject.optString("pay_func_list");
                    this.okP = C29636b.m47008F(new JSONArray(optString));
                    C14241r.cPN().mo69473b(this.okT, optString, jSONObject.optString("global_activity_list"), jSONObject.optString("pay_banner_list"), jSONObject.optString("type_info_list"), alz.wre);
                    C43288j.bMV().ola.clear();
                }
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", e, "", new Object[0]);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(43100);
    }

    public final int getType() {
        return C33253d.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43101);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(43101);
        return a;
    }
}
