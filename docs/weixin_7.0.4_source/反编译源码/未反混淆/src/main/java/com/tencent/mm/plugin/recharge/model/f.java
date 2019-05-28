package com.tencent.mm.plugin.recharge.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.biq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends m implements k {
    public String aIm;
    public String appId;
    public int cmdId;
    public String desc;
    private b ehh;
    private com.tencent.mm.ai.f ehi;
    public int errCode;
    public String gDV;
    public boolean pGg;
    public ArrayList<q> pGh;
    public ArrayList<q> pGi;
    public e pGj;
    public e pGk;
    public e pGl;
    public e pGm;
    public e pGn;
    public p pGo;
    public List<a> pGp;
    public boolean pGq;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i) {
        AppMethodBeat.i(44202);
        this.gDV = "";
        this.appId = "";
        this.pGg = false;
        this.desc = "";
        this.errCode = 0;
        this.aIm = "";
        this.pGq = false;
        this.gDV = str;
        a aVar = new a();
        aVar.fsJ = new bip();
        aVar.fsK = new biq();
        aVar.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
        aVar.fsI = 1571;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bip bip = (bip) this.ehh.fsG.fsP;
        bip.wat = i;
        this.cmdId = i;
        ab.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", Integer.valueOf(i));
        if (!bo.isNullOrNil(this.gDV)) {
            ab.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", this.gDV);
            bip.wMa = String.format("phone=%s", new Object[]{this.gDV});
        }
        AppMethodBeat.o(44202);
    }

    public final int getType() {
        return 1571;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(44203);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44203);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x03fd A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02fa A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x038b A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x027c A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x02c3 A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02fa A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x03fd A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0245 A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x027c A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x038b A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x02c3 A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x03fd A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02fa A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x020e A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0245 A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x038b A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x027c A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x02c3 A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02fa A:{Catch:{ Exception -> 0x0152 }} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x03fd A:{Catch:{ Exception -> 0x0152 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(44204);
        ab.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.errCode = i3;
        if (i2 == 0 && i3 == 0) {
            try {
                int i4;
                String optString;
                String optString2;
                String optString3;
                String optString4;
                JSONArray optJSONArray;
                JSONObject jSONObject = new JSONObject(((biq) ((b) qVar).fsH.fsP).wMb);
                ab.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", jSONObject.toString());
                this.appId = jSONObject.optString("appId");
                this.errCode = jSONObject.optInt("errCode", -1);
                this.aIm = jSONObject.optString("errMsg", ah.getContext().getString(R.string.fgv));
                if (this.errCode < 0) {
                    this.pGg = true;
                } else {
                    this.pGg = false;
                }
                this.desc = jSONObject.optString("desc");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("productList");
                if (optJSONArray2 != null) {
                    this.pGh = new ArrayList();
                    this.pGi = new ArrayList();
                    for (i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i4);
                        q qVar2 = new q();
                        qVar2.desc = jSONObject2.optString("desc", "");
                        qVar2.id = jSONObject2.optString("id", "");
                        qVar2.name = jSONObject2.optString("name", "");
                        qVar2.status = jSONObject2.optInt("status", 0);
                        qVar2.url = jSONObject2.optString("url", "");
                        qVar2.type = jSONObject2.optInt("type");
                        qVar2.tnt = jSONObject2.optString("typeName");
                        qVar2.tnv = jSONObject2.optString("isColor", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        qVar2.tnw = jSONObject2.optString("colorCode", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        qVar2.tnx = jSONObject2.optInt("isReConfirm", 0);
                        qVar2.tmN = jSONObject2.optString("weappID");
                        qVar2.fjD = jSONObject2.optString("weappPath");
                        qVar2.tny = jSONObject2.optInt("isRecommend", 0);
                        qVar2.tnz = jSONObject2.optString("recommendId", "");
                        if (qVar2.type == 1) {
                            this.pGh.add(qVar2);
                        } else {
                            qVar2.tnu = jSONObject2.optString("productAttr");
                            this.pGi.add(qVar2);
                        }
                    }
                } else {
                    this.pGh = null;
                    this.pGi = null;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("weSim");
                if (optJSONObject != null) {
                    optString = optJSONObject.optString("url");
                    optString2 = optJSONObject.optString("name");
                    optString3 = optJSONObject.optString("weappID");
                    optString4 = optJSONObject.optString("weappPath");
                    if (bo.isNullOrNil(optString2)) {
                        ab.w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
                        this.pGm = null;
                    } else {
                        this.pGm = new e();
                        this.pGm.url = optString;
                        this.pGm.name = optString2;
                        this.pGm.tmN = optString3;
                        this.pGm.fjD = optString4;
                    }
                }
                optJSONObject = jSONObject.optJSONObject("wxRemind");
                if (optJSONObject != null) {
                    optString = optJSONObject.optString("url");
                    optString2 = optJSONObject.optString("name");
                    optString3 = optJSONObject.optString("weappID");
                    optString4 = optJSONObject.optString("weappPath");
                    if (bo.isNullOrNil(optString2)) {
                        ab.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
                    } else {
                        this.pGj = new e();
                        this.pGj.url = optString;
                        this.pGj.name = optString2;
                        this.pGj.tmN = optString3;
                        this.pGj.fjD = optString4;
                        optJSONObject = jSONObject.optJSONObject("wxCard");
                        if (optJSONObject != null) {
                            optString = optJSONObject.optString("url");
                            optString2 = optJSONObject.optString("name");
                            optString3 = optJSONObject.optString("weappID");
                            optString4 = optJSONObject.optString("weappPath");
                            if (bo.isNullOrNil(optString2)) {
                                ab.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
                            } else {
                                this.pGk = new e();
                                this.pGk.url = optString;
                                this.pGk.name = optString2;
                                this.pGk.tmN = optString3;
                                this.pGk.fjD = optString4;
                                optJSONObject = jSONObject.optJSONObject("wxWt");
                                if (optJSONObject != null) {
                                    optString = optJSONObject.optString("url");
                                    optString2 = optJSONObject.optString("name");
                                    optString3 = optJSONObject.optString("weappID");
                                    optString4 = optJSONObject.optString("weappPath");
                                    if (bo.isNullOrNil(optString2)) {
                                        ab.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                                    } else {
                                        this.pGl = new e();
                                        this.pGl.url = optString;
                                        this.pGl.name = optString2;
                                        this.pGl.tmN = optString3;
                                        this.pGl.fjD = optString4;
                                        optJSONObject = jSONObject.optJSONObject("banner");
                                        if (optJSONObject == null) {
                                            this.pGo = new p();
                                            this.pGo.id = optJSONObject.getInt("id");
                                            this.pGo.name = optJSONObject.optString("name");
                                            this.pGo.url = optJSONObject.optString("url");
                                            this.pGo.tmN = optJSONObject.optString("weappID");
                                            this.pGo.fjD = optJSONObject.optString("weappPath");
                                        } else {
                                            this.pGo = null;
                                        }
                                        optJSONObject = jSONObject.optJSONObject("headEnter");
                                        if (optJSONObject != null) {
                                            optString = optJSONObject.optString("name");
                                            optString2 = optJSONObject.optString("url");
                                            optString3 = optJSONObject.optString("weappID");
                                            optString4 = optJSONObject.optString("weappPath");
                                            if (bo.isNullOrNil(optString)) {
                                                ab.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                            } else {
                                                this.pGn = new e();
                                                this.pGn.name = optString;
                                                this.pGn.url = optString2;
                                                this.pGn.tmN = optString3;
                                                this.pGn.fjD = optString4;
                                                optJSONArray = jSONObject.optJSONArray("numberList");
                                                if (optJSONArray != null) {
                                                    if (bo.isNullOrNil(this.gDV)) {
                                                        this.pGq = true;
                                                    }
                                                    if (optJSONArray.length() <= 0) {
                                                        ab.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", Integer.valueOf(optJSONArray.length()));
                                                        this.pGp = null;
                                                    } else {
                                                        this.pGp = new ArrayList();
                                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                                                            if (optJSONObject2 != null) {
                                                                optString2 = optJSONObject2.optString("number");
                                                                optString = optJSONObject2.optString("desc");
                                                                if (!bo.isNullOrNil(optString2)) {
                                                                    this.pGp.add(new a(optString2, "", optString, 2));
                                                                }
                                                            }
                                                        }
                                                        ab.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", Integer.valueOf(this.pGp.size()));
                                                    }
                                                } else {
                                                    this.pGp = null;
                                                    ab.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                                }
                                            }
                                        }
                                        this.pGn = null;
                                        optJSONArray = jSONObject.optJSONArray("numberList");
                                        if (optJSONArray != null) {
                                        }
                                    }
                                }
                                this.pGl = null;
                                optJSONObject = jSONObject.optJSONObject("banner");
                                if (optJSONObject == null) {
                                }
                                optJSONObject = jSONObject.optJSONObject("headEnter");
                                if (optJSONObject != null) {
                                }
                                this.pGn = null;
                                optJSONArray = jSONObject.optJSONArray("numberList");
                                if (optJSONArray != null) {
                                }
                            }
                        }
                        this.pGk = null;
                        optJSONObject = jSONObject.optJSONObject("wxWt");
                        if (optJSONObject != null) {
                        }
                        this.pGl = null;
                        optJSONObject = jSONObject.optJSONObject("banner");
                        if (optJSONObject == null) {
                        }
                        optJSONObject = jSONObject.optJSONObject("headEnter");
                        if (optJSONObject != null) {
                        }
                        this.pGn = null;
                        optJSONArray = jSONObject.optJSONArray("numberList");
                        if (optJSONArray != null) {
                        }
                    }
                }
                this.pGj = null;
                optJSONObject = jSONObject.optJSONObject("wxCard");
                if (optJSONObject != null) {
                }
                this.pGk = null;
                optJSONObject = jSONObject.optJSONObject("wxWt");
                if (optJSONObject != null) {
                }
                this.pGl = null;
                optJSONObject = jSONObject.optJSONObject("banner");
                if (optJSONObject == null) {
                }
                optJSONObject = jSONObject.optJSONObject("headEnter");
                if (optJSONObject != null) {
                }
                this.pGn = null;
                optJSONArray = jSONObject.optJSONArray("numberList");
                if (optJSONArray != null) {
                }
            } catch (Exception e) {
                ab.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", e.toString());
                this.pGg = true;
                this.aIm = ah.getContext().getString(R.string.fgv);
            }
        } else {
            this.pGg = true;
            if (bo.isNullOrNil(str)) {
                str = ah.getContext().getString(R.string.fdx);
            }
            this.aIm = str;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(44204);
    }
}
