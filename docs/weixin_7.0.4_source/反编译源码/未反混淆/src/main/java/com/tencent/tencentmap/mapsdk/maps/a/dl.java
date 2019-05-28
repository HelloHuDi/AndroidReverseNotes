package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dl extends dk implements cd {
    private dz a = new dz("HttpSchedulerClient");
    private cb b;

    public dl() {
        AppMethodBeat.i(98717);
        AppMethodBeat.o(98717);
    }

    private static void a(cb cbVar, JSONArray jSONArray) {
        AppMethodBeat.i(98721);
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONArray optJSONArray = jSONObject.optJSONArray("domains");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("resultlist");
                String optString = jSONObject.optString("schedulecode");
                String optString2 = jSONObject.optString("httpsport");
                if (!(optJSONArray == null || optJSONArray2 == null)) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        cc ccVar = new cc(optJSONArray.getString(i2), optString);
                        try {
                            ccVar.d = Integer.parseInt(optString2);
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                String string = optJSONArray2.getString(i3);
                                bu buVar = new bu();
                                if (buVar.a(string)) {
                                    ccVar.c.add(buVar);
                                }
                            }
                            cbVar.a(ccVar);
                        } catch (Throwable th) {
                        }
                    }
                }
                i++;
            } catch (Exception e) {
                AppMethodBeat.o(98721);
                return;
            }
        }
        AppMethodBeat.o(98721);
    }

    public final String b() {
        return "accessscheduler";
    }

    public final void c() {
        AppMethodBeat.i(98718);
        en.d().a();
        AppMethodBeat.o(98718);
    }

    public final void a(String str, byte[] bArr, String str2) {
        AppMethodBeat.i(98719);
        this.a.a(str, bArr);
        bt.j().post(new dm(this));
        AppMethodBeat.o(98719);
    }

    public final List<cc> a() {
        AppMethodBeat.i(98720);
        if (this.b == null || !this.b.a().equals(ce.b())) {
            bt.j().post(new dm(this));
            AppMethodBeat.o(98720);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Entry value : this.b.b().entrySet()) {
            arrayList.add(value.getValue());
        }
        AppMethodBeat.o(98720);
        return arrayList;
    }
}
