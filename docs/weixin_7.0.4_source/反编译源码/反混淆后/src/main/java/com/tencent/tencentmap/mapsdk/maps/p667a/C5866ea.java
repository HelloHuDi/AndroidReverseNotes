package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ea */
public final class C5866ea extends C16219dy {
    /* renamed from: a */
    private C5865dz f1574a = new C5865dz("HttpSchedulerHandler");

    public C5866ea() {
        AppMethodBeat.m2504i(98757);
        AppMethodBeat.m2505o(98757);
    }

    /* renamed from: c */
    public final String mo12417c() {
        return "accessscheduler";
    }

    /* renamed from: a */
    public final void mo12414a() {
        AppMethodBeat.m2504i(98758);
        C46772bt.m88746j().post(new C5867eb(this, null, null));
        AppMethodBeat.m2505o(98758);
    }

    /* renamed from: a */
    public final void mo12415a(C41043du c41043du) {
        AppMethodBeat.m2504i(98759);
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            C5865dz c5865dz = this.f1574a;
            C31029ce.m49850e();
            byte[] a = c5865dz.mo40566a(C31029ce.m49847b());
            if (C24373eu.m37739a(a)) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject(new String(a));
            }
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("resultMap");
                if (optJSONObject != null) {
                    Iterator keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        JSONArray optJSONArray = optJSONObject.optJSONArray(str);
                        if (optJSONArray != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject jSONObject4 = optJSONArray.getJSONObject(i);
                                jSONObject3.put(jSONObject4.optString("unit"), jSONObject4.optString("schedulecode"));
                            }
                            jSONObject2.put(str, jSONObject3);
                        }
                    }
                } else {
                    jSONObject2.put(C46772bt.m88739c(), new JSONObject());
                }
            } else {
                jSONObject2.put(C46772bt.m88739c(), new JSONObject());
            }
            c41043du.f16467a.put("directScheduleCodes", jSONObject2);
            AppMethodBeat.m2505o(98759);
        } catch (Exception e) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put(C46772bt.m88739c(), new JSONObject());
                c41043du.f16467a.put("directScheduleCodes", jSONObject);
                AppMethodBeat.m2505o(98759);
            } catch (Exception e2) {
                AppMethodBeat.m2505o(98759);
            }
        }
    }

    /* renamed from: a */
    public final void mo12416a(JSONObject jSONObject) {
        AppMethodBeat.m2504i(98760);
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("AccessScheduleRsp");
            if (optJSONObject != null) {
                String jSONObject2 = optJSONObject.toString();
                if (!C24373eu.m37738a(jSONObject2)) {
                    byte[] bytes = jSONObject2.getBytes();
                    if (!C24373eu.m37739a(bytes)) {
                        String b = C31029ce.m49847b();
                        this.f1574a.mo40565a(b, bytes);
                        C46772bt.m88746j().post(new C5867eb(this, b, bytes));
                    }
                }
            }
            AppMethodBeat.m2505o(98760);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(98760);
        }
    }
}
