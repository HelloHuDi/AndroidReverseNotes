package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cl */
public final class C31030cl {
    /* renamed from: a */
    private JSONObject f14084a;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cl$a */
    final class C31031a {
        /* renamed from: a */
        public String f14085a;
        /* renamed from: b */
        public boolean f14086b = true;
        /* renamed from: c */
        public boolean f14087c = false;
        /* renamed from: d */
        public boolean f14088d = false;
        /* renamed from: e */
        public boolean f14089e = false;
        /* renamed from: f */
        public boolean f14090f = false;
        /* renamed from: g */
        public boolean f14091g = false;
        /* renamed from: h */
        private String[] f14092h;

        public C31031a(C31030cl c31030cl, String str, int i, String str2, String str3, String str4, String str5) {
            AppMethodBeat.m2504i(98642);
            this.f14085a = str;
            String[] split = str.split("-");
            if (split.length < 5) {
                this.f14092h = new String[]{"all", "all", "all", "all", "all"};
                for (int i2 = 0; i2 < split.length; i2++) {
                    this.f14092h[i2] = split[i2];
                }
            } else {
                this.f14092h = split;
            }
            this.f14087c = m49863a(0, String.valueOf(i));
            this.f14088d = m49863a(1, str2);
            this.f14089e = m49863a(2, str3);
            this.f14090f = m49863a(3, str4);
            this.f14091g = m49863a(4, str5);
            this.f14092h = null;
            AppMethodBeat.m2505o(98642);
        }

        /* renamed from: a */
        private boolean m49863a(int i, String str) {
            boolean equals;
            AppMethodBeat.m2504i(98643);
            if (this.f14092h.length >= i + 1) {
                equals = this.f14092h[i].equals(str);
                if (!(equals || this.f14092h[i].equals("all"))) {
                    this.f14086b = false;
                }
            } else {
                equals = false;
            }
            AppMethodBeat.m2505o(98643);
            return equals;
        }
    }

    /* renamed from: a */
    public final synchronized String mo50351a() {
        String str;
        AppMethodBeat.m2504i(98644);
        if (this.f14084a == null) {
            str = "";
            AppMethodBeat.m2505o(98644);
        } else {
            str = this.f14084a.toString();
            AppMethodBeat.m2505o(98644);
        }
        return str;
    }

    /* renamed from: a */
    public final synchronized void mo50353a(String str) {
        AppMethodBeat.m2504i(98645);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(98645);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (this.f14084a == null) {
                    this.f14084a = jSONObject;
                    AppMethodBeat.m2505o(98645);
                } else {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    String optString = jSONObject.optString("version");
                    if (!(optJSONObject == null || TextUtils.isEmpty(optString))) {
                        JSONObject optJSONObject2 = this.f14084a.optJSONObject("data");
                        if (optJSONObject2 == null) {
                            this.f14084a.putOpt("data", optJSONObject);
                        } else {
                            Iterator keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String str2 = (String) keys.next();
                                if (!TextUtils.isEmpty(str2)) {
                                    JSONObject optJSONObject3 = optJSONObject.optJSONObject(str2);
                                    if (optJSONObject3 != null) {
                                        optJSONObject2.putOpt(str2, optJSONObject3);
                                    }
                                }
                            }
                        }
                        this.f14084a.putOpt("version", optString);
                    }
                    AppMethodBeat.m2505o(98645);
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(98645);
            }
        }
        return;
    }

    /* renamed from: b */
    public final synchronized void mo50354b() {
        this.f14084a = null;
    }

    /* renamed from: c */
    public final synchronized String mo50355c() {
        String optString;
        AppMethodBeat.m2504i(98646);
        if (this.f14084a != null) {
            optString = this.f14084a.optString("version");
            AppMethodBeat.m2505o(98646);
        } else {
            optString = "";
            AppMethodBeat.m2505o(98646);
        }
        return optString;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00da A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final synchronized String mo50352a(String str, int i, String str2, String str3, String str4, String str5) {
        String str6;
        AppMethodBeat.m2504i(98647);
        if (this.f14084a == null || TextUtils.isEmpty(str)) {
            str6 = "";
            AppMethodBeat.m2505o(98647);
        } else {
            JSONObject optJSONObject = this.f14084a.optJSONObject("data");
            if (optJSONObject == null) {
                str6 = "";
                AppMethodBeat.m2505o(98647);
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
                if (optJSONObject2 == null) {
                    str6 = "";
                    AppMethodBeat.m2505o(98647);
                } else {
                    C31031a c31031a;
                    ArrayList arrayList = new ArrayList();
                    Iterator keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String str7 = (String) keys.next();
                        if (!TextUtils.isEmpty(str7)) {
                            if (str7.equals("deviceid")) {
                                str6 = optJSONObject2.optString("deviceid");
                                AppMethodBeat.m2505o(98647);
                                break;
                            }
                            c31031a = new C31031a(this, str7, i, str2, str3, str4, str5);
                            if (c31031a.f14086b) {
                                arrayList.add(c31031a);
                            }
                        }
                    }
                    if (arrayList.size() == 0) {
                        str6 = "";
                        AppMethodBeat.m2505o(98647);
                    } else if (arrayList.size() == 1) {
                        str6 = optJSONObject2.optString(((C31031a) arrayList.get(0)).f14085a);
                        AppMethodBeat.m2505o(98647);
                    } else {
                        int i2 = 1;
                        C31031a c31031a2 = (C31031a) arrayList.get(0);
                        while (i2 < arrayList.size()) {
                            boolean z;
                            c31031a = (C31031a) arrayList.get(i2);
                            if (c31031a2.f14086b) {
                                if (c31031a.f14087c != c31031a2.f14087c) {
                                    z = c31031a.f14087c;
                                } else if (c31031a.f14088d != c31031a2.f14088d) {
                                    z = c31031a.f14088d;
                                } else if (c31031a.f14089e != c31031a2.f14089e) {
                                    z = c31031a.f14089e;
                                } else if (c31031a.f14090f != c31031a2.f14090f) {
                                    z = c31031a.f14090f;
                                } else if (c31031a.f14091g != c31031a2.f14091g) {
                                    z = c31031a.f14091g;
                                }
                                if (z) {
                                    c31031a = c31031a2;
                                }
                                i2++;
                                c31031a2 = c31031a;
                            }
                            z = true;
                            if (z) {
                            }
                            i2++;
                            c31031a2 = c31031a;
                        }
                        str6 = optJSONObject2.optString(c31031a2.f14085a);
                        AppMethodBeat.m2505o(98647);
                    }
                }
            }
        }
        return str6;
    }
}
