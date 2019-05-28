package com.tencent.p177mm.plugin.order.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.order.model.MallOrderDetailObject.C34660a;
import com.tencent.p177mm.plugin.order.model.MallOrderDetailObject.C34661b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.order.model.h */
public final class C43363h extends C5749m {
    public MallOrderDetailObject pcS;
    private int pcT;

    public C43363h(String str) {
        this(str, null, -1);
    }

    public C43363h(String str, String str2) {
        this(str, str2, -1);
    }

    public C43363h(String str, String str2, int i) {
        AppMethodBeat.m2504i(43781);
        this.pcS = null;
        this.pcT = -1;
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        if (!C5046bo.isNullOrNil(str2)) {
            hashMap.put("bill_id", str2);
        }
        if (this.pcT >= 0) {
            this.pcT = i;
        }
        mo70323M(hashMap);
        AppMethodBeat.m2505o(43781);
    }

    public final int bgI() {
        return 108;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43782);
        if (jSONObject != null) {
            this.pcS = new MallOrderDetailObject();
            MallOrderDetailObject mallOrderDetailObject = this.pcS;
            if (jSONObject != null) {
                try {
                    mallOrderDetailObject.pbI = MallTransactionObject.m45542ae(jSONObject);
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e, "", new Object[0]);
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
                }
                try {
                    C34661b c34661b;
                    JSONObject jSONObject2 = jSONObject.getJSONObject("status_section");
                    if (jSONObject2 != null) {
                        c34661b = new C34661b();
                        c34661b.pbR = jSONObject2.optString("last_status_name");
                        c34661b.oyB = jSONObject2.optInt("time");
                        c34661b.thumbUrl = jSONObject2.optString("thumb_url");
                        c34661b.mZj = jSONObject2.optString("jump_url");
                        c34661b.pbS = jSONObject2.optString("last_status_desc");
                    } else {
                        c34661b = null;
                    }
                    mallOrderDetailObject.pbJ = c34661b;
                } catch (JSONException e3) {
                    C4990ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e3, "", new Object[0]);
                } catch (Exception e22) {
                    C4990ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e22, "", new Object[0]);
                }
                try {
                    mallOrderDetailObject.pbK = MallOrderDetailObject.m56900ac(jSONObject);
                } catch (JSONException e32) {
                    C4990ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e32, "", new Object[0]);
                } catch (Exception e222) {
                    C4990ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e222, "", new Object[0]);
                }
                try {
                    List list;
                    int i2;
                    JSONArray jSONArray = jSONObject.getJSONArray("normal_sections");
                    if (jSONArray == null || jSONArray.length() == 0) {
                        list = null;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        i2 = 0;
                        boolean z = false;
                        while (i2 < jSONArray.length()) {
                            boolean z2;
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            C34660a c34660a = new C34660a();
                            if (jSONObject3.optInt("is_bar") == 0) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            c34660a.kch = z2;
                            c34660a.name = jSONObject3.optString("name");
                            if (TextUtils.isEmpty(c34660a.name)) {
                                z2 = c34660a.kch;
                            } else {
                                if (z) {
                                    c34660a.kch = z;
                                }
                                z2 = c34660a.kch;
                                c34660a.value = jSONObject3.optString("value");
                                c34660a.jumpUrl = jSONObject3.optString("jump_url");
                                c34660a.jumpType = jSONObject3.optInt("jump_type");
                                arrayList.add(c34660a);
                            }
                            i2++;
                            z = z2;
                        }
                        Object list2 = arrayList;
                    }
                    mallOrderDetailObject.pbL = list2;
                    list2 = mallOrderDetailObject.pbL;
                    JSONObject optJSONObject = jSONObject.optJSONObject("evaluate_section");
                    if (optJSONObject != null) {
                        if (list2 == null) {
                            list2 = new ArrayList();
                        }
                        C34660a c34660a2 = new C34660a();
                        if (optJSONObject.has("value")) {
                            c34660a2.value = optJSONObject.optString("value");
                            c34660a2.type = 2;
                        } else {
                            c34660a2.type = 1;
                        }
                        i2 = optJSONObject.optInt("order", 0);
                        if (i2 >= 0 && i2 <= optJSONObject.length() + 1) {
                            list2.add(i2, c34660a2);
                        }
                    }
                } catch (JSONException e322) {
                    C4990ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e322, "", new Object[0]);
                } catch (Exception e2222) {
                    C4990ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2222, "", new Object[0]);
                }
                mallOrderDetailObject.pbO = jSONObject.optString("safeguard_url");
                mallOrderDetailObject.lCb = jSONObject.optString("share_url");
                mallOrderDetailObject.pbQ = jSONObject.optInt("modifyTimeStamp");
                if (mallOrderDetailObject.pbJ != null && mallOrderDetailObject.pbQ <= 0) {
                    mallOrderDetailObject.pbQ = mallOrderDetailObject.pbJ.oyB;
                }
                if (mallOrderDetailObject.pbI != null) {
                    mallOrderDetailObject.pbP = mallOrderDetailObject.pbI.pbP;
                    mallOrderDetailObject.cBb = mallOrderDetailObject.pbI.pcm;
                    mallOrderDetailObject.pbN = mallOrderDetailObject.pbI.pbN;
                    mallOrderDetailObject.pbM = mallOrderDetailObject.pbI.pbM;
                }
            }
        }
        AppMethodBeat.m2505o(43782);
    }
}
