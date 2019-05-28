package com.tencent.mm.hardcoder;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h implements com.tencent.mm.hardcoder.g.a {
    public static Context context;
    public static int eEJ = -1;
    public static int eEK = -1;
    protected final Map<Integer, a> eEH = new TreeMap();
    protected int eEI = 0;

    public static class a {
        public final Map<Long, Integer> eEN = new TreeMap();

        public a() {
            AppMethodBeat.i(93964);
            AppMethodBeat.o(93964);
        }
    }

    public h(Context context) {
        AppMethodBeat.i(93965);
        context = context;
        AppMethodBeat.o(93965);
    }

    public final void PG() {
        AppMethodBeat.i(93966);
        this.eEH.clear();
        try {
            String str = Build.MODEL;
            if (str == null) {
                AppMethodBeat.o(93966);
                return;
            }
            Iterator keys;
            c.i("HardCoder.PowerConsumption", String.format("[oneliang] device model:%s", new Object[]{str}));
            str = str.toUpperCase();
            InputStream open = context.getAssets().open("hardcoder/power.json");
            final StringBuilder stringBuilder = new StringBuilder();
            g.a(open, new com.tencent.mm.hardcoder.g.a() {
                public final boolean kZ(String str) {
                    AppMethodBeat.i(93963);
                    stringBuilder.append(str);
                    AppMethodBeat.o(93963);
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
                        kZ(jSONArray.getString(i3));
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
            c.i("HardCoder.PowerConsumption", String.format("[oneliang] cluster0:%d,cluster1:%d", new Object[]{Integer.valueOf(eEJ), Integer.valueOf(eEK)}));
            for (Entry entry : this.eEH.entrySet()) {
                c.i("HardCoder.PowerConsumption", "config cpu:" + entry.getKey());
                for (Entry entry2 : ((a) entry2.getValue()).eEN.entrySet()) {
                    c.i("HardCoder.PowerConsumption", entry2.getKey() + "," + entry2.getValue());
                }
            }
            AppMethodBeat.o(93966);
        } catch (Exception e) {
            c.e("HardCoder.PowerConsumption", "initialize exception:" + e.getMessage());
            AppMethodBeat.o(93966);
        }
    }

    public final void PH() {
        AppMethodBeat.i(93967);
        this.eEH.clear();
        g.a("/sdcard/power.csv", (com.tencent.mm.hardcoder.g.a) this);
        update();
        g.a("/sdcard/power1.csv", (com.tencent.mm.hardcoder.g.a) this);
        for (Entry entry : this.eEH.entrySet()) {
            c.i("HardCoder.PowerConsumption", "cpu:" + entry.getKey());
            for (Entry entry2 : ((a) entry2.getValue()).eEN.entrySet()) {
                c.i("HardCoder.PowerConsumption", entry2.getKey() + "," + entry2.getValue());
            }
        }
        AppMethodBeat.o(93967);
    }

    private void update() {
        AppMethodBeat.i(93968);
        this.eEI = this.eEH.size();
        c.d("HardCoder.PowerConsumption", "update existCpuSize:" + this.eEI);
        AppMethodBeat.o(93968);
    }

    public final boolean kZ(String str) {
        AppMethodBeat.i(93969);
        String[] split = str.trim().split(",");
        if (split.length > 0) {
            long parseLong = Long.parseLong(split[0]);
            for (int i = 1; i < split.length; i++) {
                a aVar;
                Integer valueOf = Integer.valueOf((this.eEI + i) - 1);
                if (this.eEH.containsKey(valueOf)) {
                    aVar = (a) this.eEH.get(valueOf);
                } else {
                    aVar = new a();
                    this.eEH.put(valueOf, aVar);
                }
                aVar.eEN.put(Long.valueOf(parseLong), Integer.valueOf(Integer.parseInt(split[i], 0)));
            }
        }
        AppMethodBeat.o(93969);
        return true;
    }
}
