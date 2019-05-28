package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class q {
    public static int a = 1000;
    private volatile List<p> b;
    private s c;
    private int d = -1;

    public q(Context context, String str) {
        AppMethodBeat.i(98255);
        if (str == null) {
            this.c = w.a(context);
        } else {
            this.c = u.a(context, str);
        }
        b();
        AppMethodBeat.o(98255);
    }

    private void b() {
        AppMethodBeat.i(98256);
        this.b = new CopyOnWriteArrayList();
        String a = this.c.a("mapStyleList");
        if (a == null) {
            a = "[{\"id\":0,\"index\":0,\"order\":1},{\"id\":-1,\"index\":1,\"order\":-1},{\"id\":-1,\"index\":2,\"order\":-1},{\"id\":-1,\"index\":3,\"order\":-1},{\"id\":-1,\"index\":4,\"order\":-1},{\"id\":-1,\"index\":5,\"order\":-1},{\"id\":-1,\"index\":6,\"order\":-1},{\"id\":-1,\"index\":7,\"order\":-1},{\"id\":-1,\"index\":8,\"order\":-1},{\"id\":9,\"index\":9,\"order\":-1},{\"id\":10,\"index\":10,\"order\":-1},{\"id\":5,\"index\":11,\"order\":-1},{\"id\":4,\"index\":12,\"order\":-1},{\"id\":6,\"index\":13,\"order\":-1},{\"id\":7,\"index\":14,\"order\":-1},{\"id\":8,\"index\":15,\"order\":-1}]";
        }
        try {
            this.b.addAll(b(new JSONArray(a)));
            AppMethodBeat.o(98256);
        } catch (Exception e) {
            AppMethodBeat.o(98256);
        }
    }

    public void a(JSONArray jSONArray) {
        AppMethodBeat.i(98257);
        String a = this.c.a("mapStyleList");
        if (jSONArray != null) {
            List b = b(jSONArray);
            if (b != null) {
                this.b.clear();
                this.b.addAll(b);
                if (!jSONArray.toString().equals(a)) {
                    this.c.a();
                    this.c.a("mapStyleList", jSONArray.toString());
                }
            }
        }
        AppMethodBeat.o(98257);
    }

    private List<p> b(JSONArray jSONArray) {
        AppMethodBeat.i(98258);
        if (jSONArray == null) {
            AppMethodBeat.o(98258);
            return null;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        int i = 0;
        while (i < length) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                arrayList.add(new p(jSONObject.getInt(b.INDEX), jSONObject.getInt("id"), jSONObject.getInt("order")));
                i++;
            } catch (Exception e) {
                AppMethodBeat.o(98258);
                return null;
            }
        }
        Collections.sort(arrayList);
        AppMethodBeat.o(98258);
        return arrayList;
    }

    public String a() {
        AppMethodBeat.i(98259);
        if (this.b == null) {
            AppMethodBeat.o(98259);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(128);
        for (p pVar : this.b) {
            if (pVar.b != -1) {
                if (stringBuilder.length() == 0) {
                    stringBuilder.append(pVar.b);
                } else {
                    stringBuilder.append(",");
                    stringBuilder.append(pVar.b);
                }
            } else if (stringBuilder.length() == 0) {
                stringBuilder.append(0);
            } else {
                stringBuilder.append(",");
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(98259);
        return stringBuilder2;
    }

    public int a(int i) {
        AppMethodBeat.i(98260);
        if (this.b == null || this.b.size() == 0 || i < 0) {
            AppMethodBeat.o(98260);
            return i;
        }
        this.d = i;
        if (i >= a) {
            i -= a;
            AppMethodBeat.o(98260);
            return i;
        }
        for (p pVar : this.b) {
            if (pVar.c == i) {
                i = pVar.a;
                AppMethodBeat.o(98260);
                return i;
            }
        }
        AppMethodBeat.o(98260);
        return i;
    }

    public void a(f fVar) {
        AppMethodBeat.i(98261);
        if (fVar != null) {
            fVar.a(a(this.d));
        }
        AppMethodBeat.o(98261);
    }
}
