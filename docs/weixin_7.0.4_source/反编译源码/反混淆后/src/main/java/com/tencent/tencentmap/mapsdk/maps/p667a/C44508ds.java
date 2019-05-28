package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ds */
public final class C44508ds {
    /* renamed from: a */
    private static C44508ds f17408a = new C44508ds();
    /* renamed from: b */
    private Map<String, String> f17409b = new C46777dt(this, 8, 1.0f, true);

    static {
        AppMethodBeat.m2504i(98744);
        AppMethodBeat.m2505o(98744);
    }

    /* renamed from: a */
    public static C44508ds m80717a() {
        return f17408a;
    }

    /* renamed from: a */
    public static String m80718a(int i) {
        return i == 1 ? "cm" : i == 3 ? UserDataStore.CITY : i == 2 ? "uni" : "";
    }

    /* renamed from: a */
    public final String mo70876a(String str) {
        String str2;
        AppMethodBeat.m2504i(98743);
        if (C24373eu.m37738a(str) || "unknown".equals(str)) {
            str2 = "";
            AppMethodBeat.m2505o(98743);
            return str2;
        }
        synchronized (this.f17409b) {
            try {
                str2 = (String) this.f17409b.get(str);
                if (C24373eu.m37738a(str2)) {
                    str2 = "";
                    AppMethodBeat.m2505o(98743);
                    return str2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(98743);
            }
        }
        return str2;
    }

    /* renamed from: b */
    public final String mo70879b() {
        AppMethodBeat.m2504i(98742);
        StringBuilder stringBuilder = new StringBuilder();
        synchronized (this.f17409b) {
            try {
                ArrayList arrayList = new ArrayList(this.f17409b.keySet());
                ArrayList arrayList2 = new ArrayList(this.f17409b.values());
                for (int i = 0; i < arrayList.size(); i++) {
                    String str = (String) arrayList2.get(i);
                    stringBuilder.append((String) arrayList.get(i)).append("h,l").append(str).append("h;l");
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(98742);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        return stringBuilder2;
    }

    private C44508ds() {
        AppMethodBeat.m2504i(98739);
        mo70878a(C24370er.m37716b("HalleyOperInfo_" + C46772bt.m88739c(), "", true), false);
        AppMethodBeat.m2505o(98739);
    }

    /* renamed from: a */
    public final void mo70878a(String str, boolean z) {
        AppMethodBeat.m2504i(98740);
        try {
            if (!C24373eu.m37738a(str)) {
                synchronized (this.f17409b) {
                    this.f17409b.clear();
                    String[] split = str.split("h;l");
                    if (split != null) {
                        for (String split2 : split) {
                            String[] split3 = split2.split("h,l");
                            if (split3.length == 2) {
                                this.f17409b.put(split3[0], split3[1]);
                            }
                        }
                    }
                }
                if (z) {
                    C24370er.m37713a("HalleyOperInfo_" + C46772bt.m88739c(), str, true);
                }
            }
            AppMethodBeat.m2505o(98740);
        } catch (Exception e) {
            AppMethodBeat.m2505o(98740);
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.m2505o(98740);
            }
        }
    }

    /* renamed from: a */
    public final void mo70877a(String str, String str2) {
        AppMethodBeat.m2504i(98741);
        if (C24373eu.m37738a(str) || "unknown".equals(str) || C24373eu.m37738a(str2) || "unknown".equals(str2)) {
            AppMethodBeat.m2505o(98741);
            return;
        }
        synchronized (this.f17409b) {
            try {
                if (!str2.equals((String) this.f17409b.get(str))) {
                    this.f17409b.put(str, str2);
                    C24370er.m37713a("HalleyOperInfo_" + C46772bt.m88739c(), mo70879b(), true);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(98741);
            }
        }
    }
}
