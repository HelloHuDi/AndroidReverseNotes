package com.tencent.tencentmap.mapsdk.maps.a;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;

public final class ds {
    private static ds a = new ds();
    private Map<String, String> b = new dt(this, 8, 1.0f, true);

    static {
        AppMethodBeat.i(98744);
        AppMethodBeat.o(98744);
    }

    public static ds a() {
        return a;
    }

    public static String a(int i) {
        return i == 1 ? "cm" : i == 3 ? UserDataStore.CITY : i == 2 ? "uni" : "";
    }

    public final String a(String str) {
        String str2;
        AppMethodBeat.i(98743);
        if (eu.a(str) || "unknown".equals(str)) {
            str2 = "";
            AppMethodBeat.o(98743);
            return str2;
        }
        synchronized (this.b) {
            try {
                str2 = (String) this.b.get(str);
                if (eu.a(str2)) {
                    str2 = "";
                    AppMethodBeat.o(98743);
                    return str2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(98743);
            }
        }
        return str2;
    }

    public final String b() {
        AppMethodBeat.i(98742);
        StringBuilder stringBuilder = new StringBuilder();
        synchronized (this.b) {
            try {
                ArrayList arrayList = new ArrayList(this.b.keySet());
                ArrayList arrayList2 = new ArrayList(this.b.values());
                for (int i = 0; i < arrayList.size(); i++) {
                    String str = (String) arrayList2.get(i);
                    stringBuilder.append((String) arrayList.get(i)).append("h,l").append(str).append("h;l");
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(98742);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        return stringBuilder2;
    }

    private ds() {
        AppMethodBeat.i(98739);
        a(er.b("HalleyOperInfo_" + bt.c(), "", true), false);
        AppMethodBeat.o(98739);
    }

    public final void a(String str, boolean z) {
        AppMethodBeat.i(98740);
        try {
            if (!eu.a(str)) {
                synchronized (this.b) {
                    this.b.clear();
                    String[] split = str.split("h;l");
                    if (split != null) {
                        for (String split2 : split) {
                            String[] split3 = split2.split("h,l");
                            if (split3.length == 2) {
                                this.b.put(split3[0], split3[1]);
                            }
                        }
                    }
                }
                if (z) {
                    er.a("HalleyOperInfo_" + bt.c(), str, true);
                }
            }
            AppMethodBeat.o(98740);
        } catch (Exception e) {
            AppMethodBeat.o(98740);
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.o(98740);
            }
        }
    }

    public final void a(String str, String str2) {
        AppMethodBeat.i(98741);
        if (eu.a(str) || "unknown".equals(str) || eu.a(str2) || "unknown".equals(str2)) {
            AppMethodBeat.o(98741);
            return;
        }
        synchronized (this.b) {
            try {
                if (!str2.equals((String) this.b.get(str))) {
                    this.b.put(str, str2);
                    er.a("HalleyOperInfo_" + bt.c(), b(), true);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(98741);
            }
        }
    }
}
