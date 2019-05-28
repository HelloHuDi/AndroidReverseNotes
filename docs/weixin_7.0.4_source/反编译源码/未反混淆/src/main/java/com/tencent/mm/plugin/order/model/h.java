package com.tencent.mm.plugin.order.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends m {
    public MallOrderDetailObject pcS;
    private int pcT;

    public h(String str) {
        this(str, null, -1);
    }

    public h(String str, String str2) {
        this(str, str2, -1);
    }

    public h(String str, String str2, int i) {
        AppMethodBeat.i(43781);
        this.pcS = null;
        this.pcT = -1;
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        if (!bo.isNullOrNil(str2)) {
            hashMap.put("bill_id", str2);
        }
        if (this.pcT >= 0) {
            this.pcT = i;
        }
        M(hashMap);
        AppMethodBeat.o(43781);
    }

    public final int bgI() {
        return 108;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43782);
        if (jSONObject != null) {
            this.pcS = new MallOrderDetailObject();
            MallOrderDetailObject mallOrderDetailObject = this.pcS;
            if (jSONObject != null) {
                try {
                    mallOrderDetailObject.pbI = MallTransactionObject.ae(jSONObject);
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e, "", new Object[0]);
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
                }
                try {
                    b bVar;
                    JSONObject jSONObject2 = jSONObject.getJSONObject("status_section");
                    if (jSONObject2 != null) {
                        bVar = new b();
                        bVar.pbR = jSONObject2.optString("last_status_name");
                        bVar.oyB = jSONObject2.optInt("time");
                        bVar.thumbUrl = jSONObject2.optString("thumb_url");
                        bVar.mZj = jSONObject2.optString("jump_url");
                        bVar.pbS = jSONObject2.optString("last_status_desc");
                    } else {
                        bVar = null;
                    }
                    mallOrderDetailObject.pbJ = bVar;
                } catch (JSONException e3) {
                    ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e3, "", new Object[0]);
                } catch (Exception e22) {
                    ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e22, "", new Object[0]);
                }
                try {
                    mallOrderDetailObject.pbK = MallOrderDetailObject.ac(jSONObject);
                } catch (JSONException e32) {
                    ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e32, "", new Object[0]);
                } catch (Exception e222) {
                    ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e222, "", new Object[0]);
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
                            a aVar = new a();
                            if (jSONObject3.optInt("is_bar") == 0) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            aVar.kch = z2;
                            aVar.name = jSONObject3.optString("name");
                            if (TextUtils.isEmpty(aVar.name)) {
                                z2 = aVar.kch;
                            } else {
                                if (z) {
                                    aVar.kch = z;
                                }
                                z2 = aVar.kch;
                                aVar.value = jSONObject3.optString("value");
                                aVar.jumpUrl = jSONObject3.optString("jump_url");
                                aVar.jumpType = jSONObject3.optInt("jump_type");
                                arrayList.add(aVar);
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
                        a aVar2 = new a();
                        if (optJSONObject.has("value")) {
                            aVar2.value = optJSONObject.optString("value");
                            aVar2.type = 2;
                        } else {
                            aVar2.type = 1;
                        }
                        i2 = optJSONObject.optInt("order", 0);
                        if (i2 >= 0 && i2 <= optJSONObject.length() + 1) {
                            list2.add(i2, aVar2);
                        }
                    }
                } catch (JSONException e322) {
                    ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e322, "", new Object[0]);
                } catch (Exception e2222) {
                    ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2222, "", new Object[0]);
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
        AppMethodBeat.o(43782);
    }
}
