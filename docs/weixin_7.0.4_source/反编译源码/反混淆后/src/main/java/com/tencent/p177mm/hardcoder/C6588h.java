package com.tencent.p177mm.hardcoder;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1623g.C1622a;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.hardcoder.h */
public final class C6588h implements C1622a {
    public static Context context;
    public static int eEJ = -1;
    public static int eEK = -1;
    protected final Map<Integer, C1624a> eEH = new TreeMap();
    protected int eEI = 0;

    /* renamed from: com.tencent.mm.hardcoder.h$a */
    public static class C1624a {
        public final Map<Long, Integer> eEN = new TreeMap();

        public C1624a() {
            AppMethodBeat.m2504i(93964);
            AppMethodBeat.m2505o(93964);
        }
    }

    public C6588h(Context context) {
        AppMethodBeat.m2504i(93965);
        context = context;
        AppMethodBeat.m2505o(93965);
    }

    /* renamed from: PG */
    public final void mo14804PG() {
        AppMethodBeat.m2504i(93966);
        this.eEH.clear();
        try {
            String str = Build.MODEL;
            if (str == null) {
                AppMethodBeat.m2505o(93966);
                return;
            }
            Iterator keys;
            C1611c.m3271i("HardCoder.PowerConsumption", String.format("[oneliang] device model:%s", new Object[]{str}));
            str = str.toUpperCase();
            InputStream open = context.getAssets().open("hardcoder/power.json");
            final StringBuilder stringBuilder = new StringBuilder();
            C1623g.m3284a(open, new C1622a() {
                /* renamed from: kZ */
                public final boolean mo5072kZ(String str) {
                    AppMethodBeat.m2504i(93963);
                    stringBuilder.append(str);
                    AppMethodBeat.m2505o(93963);
                    return true;
                }
            });
            JSONObject jSONObject = new JSONObject(stringBuilder.toString());
            if (jSONObject.has(str)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                keys = jSONObject2.keys();
                int i = 0;
                while (keys.hasNext()) {
                    keys.next();
                    i++;
                }
                int i2 = 0;
                while (i2 < i && jSONObject2.has("cluster".concat(String.valueOf(i2)))) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("cluster".concat(String.valueOf(i2)));
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        mo5072kZ(jSONArray.getString(i3));
                    }
                    update();
                    switch (i2) {
                        case 0:
                            eEJ = this.eEI - 1;
                            break;
                        case 1:
                            eEK = this.eEI - 1;
                            break;
                        default:
                            break;
                    }
                    i2++;
                }
            }
            C1611c.m3271i("HardCoder.PowerConsumption", String.format("[oneliang] cluster0:%d,cluster1:%d", new Object[]{Integer.valueOf(eEJ), Integer.valueOf(eEK)}));
            for (Entry entry : this.eEH.entrySet()) {
                C1611c.m3271i("HardCoder.PowerConsumption", "config cpu:" + entry.getKey());
                for (Entry entry2 : ((C1624a) entry2.getValue()).eEN.entrySet()) {
                    C1611c.m3271i("HardCoder.PowerConsumption", entry2.getKey() + "," + entry2.getValue());
                }
            }
            AppMethodBeat.m2505o(93966);
        } catch (Exception e) {
            C1611c.m3270e("HardCoder.PowerConsumption", "initialize exception:" + e.getMessage());
            AppMethodBeat.m2505o(93966);
        }
    }

    /* renamed from: PH */
    public final void mo14805PH() {
        AppMethodBeat.m2504i(93967);
        this.eEH.clear();
        C1623g.m3285a("/sdcard/power.csv", (C1622a) this);
        update();
        C1623g.m3285a("/sdcard/power1.csv", (C1622a) this);
        for (Entry entry : this.eEH.entrySet()) {
            C1611c.m3271i("HardCoder.PowerConsumption", "cpu:" + entry.getKey());
            for (Entry entry2 : ((C1624a) entry2.getValue()).eEN.entrySet()) {
                C1611c.m3271i("HardCoder.PowerConsumption", entry2.getKey() + "," + entry2.getValue());
            }
        }
        AppMethodBeat.m2505o(93967);
    }

    private void update() {
        AppMethodBeat.m2504i(93968);
        this.eEI = this.eEH.size();
        C1611c.m3269d("HardCoder.PowerConsumption", "update existCpuSize:" + this.eEI);
        AppMethodBeat.m2505o(93968);
    }

    /* renamed from: kZ */
    public final boolean mo5072kZ(String str) {
        AppMethodBeat.m2504i(93969);
        String[] split = str.trim().split(",");
        if (split.length > 0) {
            long parseLong = Long.parseLong(split[0]);
            for (int i = 1; i < split.length; i++) {
                C1624a c1624a;
                Integer valueOf = Integer.valueOf((this.eEI + i) - 1);
                if (this.eEH.containsKey(valueOf)) {
                    c1624a = (C1624a) this.eEH.get(valueOf);
                } else {
                    c1624a = new C1624a();
                    this.eEH.put(valueOf, c1624a);
                }
                c1624a.eEN.put(Long.valueOf(parseLong), Integer.valueOf(Integer.parseInt(split[i], 0)));
            }
        }
        AppMethodBeat.m2505o(93969);
        return true;
    }
}
