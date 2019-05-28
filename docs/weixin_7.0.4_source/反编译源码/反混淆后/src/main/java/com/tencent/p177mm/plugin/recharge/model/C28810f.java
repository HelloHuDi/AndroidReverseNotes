package com.tencent.p177mm.plugin.recharge.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet.p748a.C14101p;
import com.tencent.p177mm.plugin.wallet.p748a.C29528q;
import com.tencent.p177mm.plugin.wallet.p748a.C40050e;
import com.tencent.p177mm.protocal.protobuf.bip;
import com.tencent.p177mm.protocal.protobuf.biq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.recharge.model.f */
public final class C28810f extends C1207m implements C1918k {
    public String aIm;
    public String appId;
    public int cmdId;
    public String desc;
    private C7472b ehh;
    private C1202f ehi;
    public int errCode;
    public String gDV;
    public boolean pGg;
    public ArrayList<C29528q> pGh;
    public ArrayList<C29528q> pGi;
    public C40050e pGj;
    public C40050e pGk;
    public C40050e pGl;
    public C40050e pGm;
    public C40050e pGn;
    public C14101p pGo;
    public List<C43420a> pGp;
    public boolean pGq;

    public C28810f(String str) {
        this(str, 0);
    }

    public C28810f(String str, int i) {
        AppMethodBeat.m2504i(44202);
        this.gDV = "";
        this.appId = "";
        this.pGg = false;
        this.desc = "";
        this.errCode = 0;
        this.aIm = "";
        this.pGq = false;
        this.gDV = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bip();
        c1196a.fsK = new biq();
        c1196a.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
        c1196a.fsI = 1571;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bip bip = (bip) this.ehh.fsG.fsP;
        bip.wat = i;
        this.cmdId = i;
        C4990ab.m7417i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", Integer.valueOf(i));
        if (!C5046bo.isNullOrNil(this.gDV)) {
            C4990ab.m7417i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", this.gDV);
            bip.wMa = String.format("phone=%s", new Object[]{this.gDV});
        }
        AppMethodBeat.m2505o(44202);
    }

    public final int getType() {
        return 1571;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44203);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44203);
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
    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44204);
        C4990ab.m7417i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.errCode = i3;
        if (i2 == 0 && i3 == 0) {
            try {
                int i4;
                String optString;
                String optString2;
                String optString3;
                String optString4;
                JSONArray optJSONArray;
                JSONObject jSONObject = new JSONObject(((biq) ((C7472b) c1929q).fsH.fsP).wMb);
                C4990ab.m7411d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", jSONObject.toString());
                this.appId = jSONObject.optString("appId");
                this.errCode = jSONObject.optInt("errCode", -1);
                this.aIm = jSONObject.optString("errMsg", C4996ah.getContext().getString(C25738R.string.fgv));
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
                        C29528q c29528q = new C29528q();
                        c29528q.desc = jSONObject2.optString("desc", "");
                        c29528q.f13716id = jSONObject2.optString("id", "");
                        c29528q.name = jSONObject2.optString("name", "");
                        c29528q.status = jSONObject2.optInt("status", 0);
                        c29528q.url = jSONObject2.optString("url", "");
                        c29528q.type = jSONObject2.optInt("type");
                        c29528q.tnt = jSONObject2.optString("typeName");
                        c29528q.tnv = jSONObject2.optString("isColor", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        c29528q.tnw = jSONObject2.optString("colorCode", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        c29528q.tnx = jSONObject2.optInt("isReConfirm", 0);
                        c29528q.tmN = jSONObject2.optString("weappID");
                        c29528q.fjD = jSONObject2.optString("weappPath");
                        c29528q.tny = jSONObject2.optInt("isRecommend", 0);
                        c29528q.tnz = jSONObject2.optString("recommendId", "");
                        if (c29528q.type == 1) {
                            this.pGh.add(c29528q);
                        } else {
                            c29528q.tnu = jSONObject2.optString("productAttr");
                            this.pGi.add(c29528q);
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
                    if (C5046bo.isNullOrNil(optString2)) {
                        C4990ab.m7420w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
                        this.pGm = null;
                    } else {
                        this.pGm = new C40050e();
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
                    if (C5046bo.isNullOrNil(optString2)) {
                        C4990ab.m7420w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
                    } else {
                        this.pGj = new C40050e();
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
                            if (C5046bo.isNullOrNil(optString2)) {
                                C4990ab.m7420w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
                            } else {
                                this.pGk = new C40050e();
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
                                    if (C5046bo.isNullOrNil(optString2)) {
                                        C4990ab.m7420w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                                    } else {
                                        this.pGl = new C40050e();
                                        this.pGl.url = optString;
                                        this.pGl.name = optString2;
                                        this.pGl.tmN = optString3;
                                        this.pGl.fjD = optString4;
                                        optJSONObject = jSONObject.optJSONObject("banner");
                                        if (optJSONObject == null) {
                                            this.pGo = new C14101p();
                                            this.pGo.f2951id = optJSONObject.getInt("id");
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
                                            if (C5046bo.isNullOrNil(optString)) {
                                                C4990ab.m7420w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                            } else {
                                                this.pGn = new C40050e();
                                                this.pGn.name = optString;
                                                this.pGn.url = optString2;
                                                this.pGn.tmN = optString3;
                                                this.pGn.fjD = optString4;
                                                optJSONArray = jSONObject.optJSONArray("numberList");
                                                if (optJSONArray != null) {
                                                    if (C5046bo.isNullOrNil(this.gDV)) {
                                                        this.pGq = true;
                                                    }
                                                    if (optJSONArray.length() <= 0) {
                                                        C4990ab.m7421w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", Integer.valueOf(optJSONArray.length()));
                                                        this.pGp = null;
                                                    } else {
                                                        this.pGp = new ArrayList();
                                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                                                            if (optJSONObject2 != null) {
                                                                optString2 = optJSONObject2.optString("number");
                                                                optString = optJSONObject2.optString("desc");
                                                                if (!C5046bo.isNullOrNil(optString2)) {
                                                                    this.pGp.add(new C43420a(optString2, "", optString, 2));
                                                                }
                                                            }
                                                        }
                                                        C4990ab.m7417i("MicroMsg.NetScenePayChargeProxy", "number list: %s", Integer.valueOf(this.pGp.size()));
                                                    }
                                                } else {
                                                    this.pGp = null;
                                                    C4990ab.m7420w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
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
                C4990ab.m7413e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", e.toString());
                this.pGg = true;
                this.aIm = C4996ah.getContext().getString(C25738R.string.fgv);
            }
        } else {
            this.pGg = true;
            if (C5046bo.isNullOrNil(str)) {
                str = C4996ah.getContext().getString(C25738R.string.fdx);
            }
            this.aIm = str;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(44204);
    }
}
