package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public final class cl {
    private JSONObject a;

    final class a {
        public String a;
        public boolean b = true;
        public boolean c = false;
        public boolean d = false;
        public boolean e = false;
        public boolean f = false;
        public boolean g = false;
        private String[] h;

        public a(cl clVar, String str, int i, String str2, String str3, String str4, String str5) {
            AppMethodBeat.i(98642);
            this.a = str;
            String[] split = str.split("-");
            if (split.length < 5) {
                this.h = new String[]{"all", "all", "all", "all", "all"};
                for (int i2 = 0; i2 < split.length; i2++) {
                    this.h[i2] = split[i2];
                }
            } else {
                this.h = split;
            }
            this.c = a(0, String.valueOf(i));
            this.d = a(1, str2);
            this.e = a(2, str3);
            this.f = a(3, str4);
            this.g = a(4, str5);
            this.h = null;
            AppMethodBeat.o(98642);
        }

        private boolean a(int i, String str) {
            boolean equals;
            AppMethodBeat.i(98643);
            if (this.h.length >= i + 1) {
                equals = this.h[i].equals(str);
                if (!(equals || this.h[i].equals("all"))) {
                    this.b = false;
                }
            } else {
                equals = false;
            }
            AppMethodBeat.o(98643);
            return equals;
        }
    }

    public final synchronized String a() {
        String str;
        AppMethodBeat.i(98644);
        if (this.a == null) {
            str = "";
            AppMethodBeat.o(98644);
        } else {
            str = this.a.toString();
            AppMethodBeat.o(98644);
        }
        return str;
    }

    public final synchronized void a(String str) {
        AppMethodBeat.i(98645);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(98645);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (this.a == null) {
                    this.a = jSONObject;
                    AppMethodBeat.o(98645);
                } else {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    String optString = jSONObject.optString("version");
                    if (!(optJSONObject == null || TextUtils.isEmpty(optString))) {
                        JSONObject optJSONObject2 = this.a.optJSONObject("data");
                        if (optJSONObject2 == null) {
                            this.a.putOpt("data", optJSONObject);
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
                        this.a.putOpt("version", optString);
                    }
                    AppMethodBeat.o(98645);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(98645);
            }
        }
        return;
    }

    public final synchronized void b() {
        this.a = null;
    }

    public final synchronized String c() {
        String optString;
        AppMethodBeat.i(98646);
        if (this.a != null) {
            optString = this.a.optString("version");
            AppMethodBeat.o(98646);
        } else {
            optString = "";
            AppMethodBeat.o(98646);
        }
        return optString;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00da A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized String a(String str, int i, String str2, String str3, String str4, String str5) {
        String str6;
        AppMethodBeat.i(98647);
        if (this.a == null || TextUtils.isEmpty(str)) {
            str6 = "";
            AppMethodBeat.o(98647);
        } else {
            JSONObject optJSONObject = this.a.optJSONObject("data");
            if (optJSONObject == null) {
                str6 = "";
                AppMethodBeat.o(98647);
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
                if (optJSONObject2 == null) {
                    str6 = "";
                    AppMethodBeat.o(98647);
                } else {
                    a aVar;
                    ArrayList arrayList = new ArrayList();
                    Iterator keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String str7 = (String) keys.next();
                        if (!TextUtils.isEmpty(str7)) {
                            if (str7.equals("deviceid")) {
                                str6 = optJSONObject2.optString("deviceid");
                                AppMethodBeat.o(98647);
                                break;
                            }
                            aVar = new a(this, str7, i, str2, str3, str4, str5);
                            if (aVar.b) {
                                arrayList.add(aVar);
                            }
                        }
                    }
                    if (arrayList.size() == 0) {
                        str6 = "";
                        AppMethodBeat.o(98647);
                    } else if (arrayList.size() == 1) {
                        str6 = optJSONObject2.optString(((a) arrayList.get(0)).a);
                        AppMethodBeat.o(98647);
                    } else {
                        int i2 = 1;
                        a aVar2 = (a) arrayList.get(0);
                        while (i2 < arrayList.size()) {
                            boolean z;
                            aVar = (a) arrayList.get(i2);
                            if (aVar2.b) {
                                if (aVar.c != aVar2.c) {
                                    z = aVar.c;
                                } else if (aVar.d != aVar2.d) {
                                    z = aVar.d;
                                } else if (aVar.e != aVar2.e) {
                                    z = aVar.e;
                                } else if (aVar.f != aVar2.f) {
                                    z = aVar.f;
                                } else if (aVar.g != aVar2.g) {
                                    z = aVar.g;
                                }
                                if (z) {
                                    aVar = aVar2;
                                }
                                i2++;
                                aVar2 = aVar;
                            }
                            z = true;
                            if (z) {
                            }
                            i2++;
                            aVar2 = aVar;
                        }
                        str6 = optJSONObject2.optString(aVar2.a);
                        AppMethodBeat.o(98647);
                    }
                }
            }
        }
        return str6;
    }
}
