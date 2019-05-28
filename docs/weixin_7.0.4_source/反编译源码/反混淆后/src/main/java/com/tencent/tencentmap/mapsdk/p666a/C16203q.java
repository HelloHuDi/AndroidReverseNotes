package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.map.lib.C8889f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.a.q */
public class C16203q {
    /* renamed from: a */
    public static int f3120a = 1000;
    /* renamed from: b */
    private volatile List<C16202p> f3121b;
    /* renamed from: c */
    private C41027s f3122c;
    /* renamed from: d */
    private int f3123d = -1;

    public C16203q(Context context, String str) {
        AppMethodBeat.m2504i(98255);
        if (str == null) {
            this.f3122c = C31016w.m49806a(context);
        } else {
            this.f3122c = C41355u.m72123a(context, str);
        }
        m24676b();
        AppMethodBeat.m2505o(98255);
    }

    /* renamed from: b */
    private void m24676b() {
        AppMethodBeat.m2504i(98256);
        this.f3121b = new CopyOnWriteArrayList();
        String a = this.f3122c.mo65080a("mapStyleList");
        if (a == null) {
            a = "[{\"id\":0,\"index\":0,\"order\":1},{\"id\":-1,\"index\":1,\"order\":-1},{\"id\":-1,\"index\":2,\"order\":-1},{\"id\":-1,\"index\":3,\"order\":-1},{\"id\":-1,\"index\":4,\"order\":-1},{\"id\":-1,\"index\":5,\"order\":-1},{\"id\":-1,\"index\":6,\"order\":-1},{\"id\":-1,\"index\":7,\"order\":-1},{\"id\":-1,\"index\":8,\"order\":-1},{\"id\":9,\"index\":9,\"order\":-1},{\"id\":10,\"index\":10,\"order\":-1},{\"id\":5,\"index\":11,\"order\":-1},{\"id\":4,\"index\":12,\"order\":-1},{\"id\":6,\"index\":13,\"order\":-1},{\"id\":7,\"index\":14,\"order\":-1},{\"id\":8,\"index\":15,\"order\":-1}]";
        }
        try {
            this.f3121b.addAll(m24675b(new JSONArray(a)));
            AppMethodBeat.m2505o(98256);
        } catch (Exception e) {
            AppMethodBeat.m2505o(98256);
        }
    }

    /* renamed from: a */
    public void mo29202a(JSONArray jSONArray) {
        AppMethodBeat.m2504i(98257);
        String a = this.f3122c.mo65080a("mapStyleList");
        if (jSONArray != null) {
            List b = m24675b(jSONArray);
            if (b != null) {
                this.f3121b.clear();
                this.f3121b.addAll(b);
                if (!jSONArray.toString().equals(a)) {
                    this.f3122c.mo65081a();
                    this.f3122c.mo65084a("mapStyleList", jSONArray.toString());
                }
            }
        }
        AppMethodBeat.m2505o(98257);
    }

    /* renamed from: b */
    private List<C16202p> m24675b(JSONArray jSONArray) {
        AppMethodBeat.m2504i(98258);
        if (jSONArray == null) {
            AppMethodBeat.m2505o(98258);
            return null;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        int i = 0;
        while (i < length) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                arrayList.add(new C16202p(jSONObject.getInt(C8741b.INDEX), jSONObject.getInt("id"), jSONObject.getInt("order")));
                i++;
            } catch (Exception e) {
                AppMethodBeat.m2505o(98258);
                return null;
            }
        }
        Collections.sort(arrayList);
        AppMethodBeat.m2505o(98258);
        return arrayList;
    }

    /* renamed from: a */
    public String mo29200a() {
        AppMethodBeat.m2504i(98259);
        if (this.f3121b == null) {
            AppMethodBeat.m2505o(98259);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(128);
        for (C16202p c16202p : this.f3121b) {
            if (c16202p.f3118b != -1) {
                if (stringBuilder.length() == 0) {
                    stringBuilder.append(c16202p.f3118b);
                } else {
                    stringBuilder.append(",");
                    stringBuilder.append(c16202p.f3118b);
                }
            } else if (stringBuilder.length() == 0) {
                stringBuilder.append(0);
            } else {
                stringBuilder.append(",");
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(98259);
        return stringBuilder2;
    }

    /* renamed from: a */
    public int mo29199a(int i) {
        AppMethodBeat.m2504i(98260);
        if (this.f3121b == null || this.f3121b.size() == 0 || i < 0) {
            AppMethodBeat.m2505o(98260);
            return i;
        }
        this.f3123d = i;
        if (i >= f3120a) {
            i -= f3120a;
            AppMethodBeat.m2505o(98260);
            return i;
        }
        for (C16202p c16202p : this.f3121b) {
            if (c16202p.f3119c == i) {
                i = c16202p.f3117a;
                AppMethodBeat.m2505o(98260);
                return i;
            }
        }
        AppMethodBeat.m2505o(98260);
        return i;
    }

    /* renamed from: a */
    public void mo29201a(C8889f c8889f) {
        AppMethodBeat.m2504i(98261);
        if (c8889f != null) {
            c8889f.mo20159a(mo29199a(this.f3123d));
        }
        AppMethodBeat.m2505o(98261);
    }
}
