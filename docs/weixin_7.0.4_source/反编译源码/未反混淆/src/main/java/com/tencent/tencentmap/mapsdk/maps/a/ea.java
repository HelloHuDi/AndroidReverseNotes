package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ea extends dy {
    private dz a = new dz("HttpSchedulerHandler");

    public ea() {
        AppMethodBeat.i(98757);
        AppMethodBeat.o(98757);
    }

    public final String c() {
        return "accessscheduler";
    }

    public final void a() {
        AppMethodBeat.i(98758);
        bt.j().post(new eb(this, null, null));
        AppMethodBeat.o(98758);
    }

    public final void a(du duVar) {
        AppMethodBeat.i(98759);
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            dz dzVar = this.a;
            ce.e();
            byte[] a = dzVar.a(ce.b());
            if (eu.a(a)) {
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
                    jSONObject2.put(bt.c(), new JSONObject());
                }
            } else {
                jSONObject2.put(bt.c(), new JSONObject());
            }
            duVar.a.put("directScheduleCodes", jSONObject2);
            AppMethodBeat.o(98759);
        } catch (Exception e) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put(bt.c(), new JSONObject());
                duVar.a.put("directScheduleCodes", jSONObject);
                AppMethodBeat.o(98759);
            } catch (Exception e2) {
                AppMethodBeat.o(98759);
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        AppMethodBeat.i(98760);
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("AccessScheduleRsp");
            if (optJSONObject != null) {
                String jSONObject2 = optJSONObject.toString();
                if (!eu.a(jSONObject2)) {
                    byte[] bytes = jSONObject2.getBytes();
                    if (!eu.a(bytes)) {
                        String b = ce.b();
                        this.a.a(b, bytes);
                        bt.j().post(new eb(this, b, bytes));
                    }
                }
            }
            AppMethodBeat.o(98760);
        } catch (Throwable th) {
            AppMethodBeat.o(98760);
        }
    }
}
