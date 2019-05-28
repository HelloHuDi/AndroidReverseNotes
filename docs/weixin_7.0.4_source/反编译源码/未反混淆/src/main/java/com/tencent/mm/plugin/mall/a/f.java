package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.d;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.protocal.protobuf.aly;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends m implements k {
    private b ehh;
    private com.tencent.mm.ai.f ehi;
    private String okO;
    public ArrayList<MallFunction> okP;
    public ArrayList<MallNews> okQ;
    public ArrayList<a> okR;
    public SparseArray<String> okS;
    public int okT;

    public f(int i, String str, int i2) {
        this(i, str, null, null, i2);
    }

    public f(int i, String str, String str2, String str3, String str4) {
        this(i, str, str3, String.format("appid=%s&funcid=%s&url=%s", new Object[]{str2, str3, URLEncoder.encode(str4, "ISO-8859-1").toString()}), 0);
        AppMethodBeat.i(43098);
        AppMethodBeat.o(43098);
    }

    private f(int i, String str, String str2, String str3, int i2) {
        List cQU;
        AppMethodBeat.i(43099);
        this.okP = null;
        this.okQ = null;
        this.okR = null;
        this.okS = null;
        this.okT = 0;
        this.okT = i;
        b.a aVar = new b.a();
        aVar.fsJ = new aly();
        aVar.fsK = new alz();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
        aVar.fsI = d.CTRL_INDEX;
        aVar.fsL = 227;
        aVar.fsM = 1000000227;
        this.ehh = aVar.acD();
        aly aly = (aly) this.ehh.fsG.fsP;
        aly.wqY = str;
        LinkedList linkedList = new LinkedList();
        if (bo.isNullOrNil(str2)) {
            cQU = c.cQT().cQU();
        } else {
            ArrayList arrayList;
            MallNews mallNews = (MallNews) c.cQT().tDE.get(str2);
            if (mallNews == null || bo.isNullOrNil(mallNews.cxb)) {
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
            ab.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : ".concat(String.valueOf(str4)));
        }
        aly.wra = linkedList;
        aly.wqZ = linkedList.size();
        if (bo.isNullOrNil(str3)) {
            aly.ndT = String.format("tpa_country=%s", new Object[]{Integer.valueOf(i)});
        } else {
            aly.ndT = String.format("%s&tpa_country=%s", new Object[]{str3, Integer.valueOf(i)});
        }
        aly.wrb = i2;
        this.okO = str2;
        ab.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + str + " ExtInfo: " + aly.ndT);
        AppMethodBeat.o(43099);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(43100);
        ab.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            alz alz = (alz) ((b) qVar).fsH.fsP;
            ab.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.okT + " " + alz.wrc);
            try {
                if (!bo.isNullOrNil(alz.wrc)) {
                    JSONObject jSONObject = new JSONObject(alz.wrc);
                    String optString = jSONObject.optString("pay_func_list");
                    this.okP = com.tencent.mm.plugin.wallet_core.model.mall.b.F(new JSONArray(optString));
                    r.cPN().b(this.okT, optString, jSONObject.optString("global_activity_list"), jSONObject.optString("pay_banner_list"), jSONObject.optString("type_info_list"), alz.wre);
                    j.bMV().ola.clear();
                }
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", e, "", new Object[0]);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(43100);
    }

    public final int getType() {
        return d.CTRL_INDEX;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(43101);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(43101);
        return a;
    }
}
