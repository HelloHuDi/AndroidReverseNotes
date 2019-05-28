package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.dl */
public final class C44827dl extends C44506dk implements C24361cd {
    /* renamed from: a */
    private C5865dz f17581a = new C5865dz("HttpSchedulerClient");
    /* renamed from: b */
    private C24359cb f17582b;

    public C44827dl() {
        AppMethodBeat.m2504i(98717);
        AppMethodBeat.m2505o(98717);
    }

    /* renamed from: a */
    private static void m81997a(C24359cb c24359cb, JSONArray jSONArray) {
        AppMethodBeat.m2504i(98721);
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
                        C24360cc c24360cc = new C24360cc(optJSONArray.getString(i2), optString);
                        try {
                            c24360cc.f4656d = Integer.parseInt(optString2);
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                String string = optJSONArray2.getString(i3);
                                C41034bu c41034bu = new C41034bu();
                                if (c41034bu.mo65119a(string)) {
                                    c24360cc.f4655c.add(c41034bu);
                                }
                            }
                            c24359cb.mo40546a(c24360cc);
                        } catch (Throwable th) {
                        }
                    }
                }
                i++;
            } catch (Exception e) {
                AppMethodBeat.m2505o(98721);
                return;
            }
        }
        AppMethodBeat.m2505o(98721);
    }

    /* renamed from: b */
    public final String mo29272b() {
        return "accessscheduler";
    }

    /* renamed from: c */
    public final void mo29273c() {
        AppMethodBeat.m2504i(98718);
        C46780en.m88752d().mo12414a();
        AppMethodBeat.m2505o(98718);
    }

    /* renamed from: a */
    public final void mo50366a(String str, byte[] bArr, String str2) {
        AppMethodBeat.m2504i(98719);
        this.f17581a.mo40565a(str, bArr);
        C46772bt.m88746j().post(new C44507dm(this));
        AppMethodBeat.m2505o(98719);
    }

    /* renamed from: a */
    public final List<C24360cc> mo40548a() {
        AppMethodBeat.m2504i(98720);
        if (this.f17582b == null || !this.f17582b.mo40545a().equals(C31029ce.m49847b())) {
            C46772bt.m88746j().post(new C44507dm(this));
            AppMethodBeat.m2505o(98720);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Entry value : this.f17582b.mo40547b().entrySet()) {
            arrayList.add(value.getValue());
        }
        AppMethodBeat.m2505o(98720);
        return arrayList;
    }
}
