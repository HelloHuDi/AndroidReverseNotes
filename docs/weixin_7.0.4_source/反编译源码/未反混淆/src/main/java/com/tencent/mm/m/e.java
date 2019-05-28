package com.tencent.mm.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e {
    private HashMap<String, String> ewb = new HashMap();
    protected boolean ewc = false;

    public e() {
        AppMethodBeat.i(57871);
        AppMethodBeat.o(57871);
    }

    public final synchronized String getValue(String str) {
        String str2;
        AppMethodBeat.i(57872);
        if (!this.ewc) {
            ab.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            sg();
        }
        ab.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", str.trim(), this.ewb.get(str));
        str2 = (String) this.ewb.get(str);
        AppMethodBeat.o(57872);
        return str2;
    }

    public final int getInt(String str, int i) {
        AppMethodBeat.i(57873);
        try {
            i = Integer.parseInt(getValue(str));
        } catch (Exception e) {
            ab.e("MicroMsg.DynamicConfig", "parseInt failed, val: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(57873);
        return i;
    }

    public final synchronized List<String> kC(String str) {
        ArrayList arrayList;
        AppMethodBeat.i(57874);
        if (!this.ewc) {
            ab.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            sg();
        }
        arrayList = new ArrayList();
        if (!bo.isNullOrNil(str)) {
            for (String str2 : this.ewb.keySet()) {
                if (str2.matches(str)) {
                    arrayList.add(this.ewb.get(str2));
                }
            }
        }
        ab.d("MicroMsg.DynamicConfig", "searchValues, entry:%s, size:%d", str, Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(57874);
        return arrayList;
    }

    @Deprecated
    public final synchronized void put(String str, String str2) {
        AppMethodBeat.i(57875);
        if (!(str == null || str2 == null)) {
            ab.d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", str.trim(), str2);
            this.ewb.put(str, str2);
        }
        AppMethodBeat.o(57875);
    }

    public synchronized void sg() {
        AppMethodBeat.i(57876);
        g.RQ();
        if (g.RP() != null) {
            g.RQ();
            if (g.RP().Ry() != null) {
                this.ewc = true;
                g.RQ();
                p((String) g.RP().Ry().get(278529, null), false);
            }
        }
        g.RQ();
        if (g.RP() != null) {
            g.RQ();
            if (g.RP().Ry() != null) {
                this.ewc = true;
                g.RQ();
                p((String) g.RP().Ry().get(278530, null), true);
            }
        }
        AppMethodBeat.o(57876);
    }

    public final synchronized void a(String str, Map<String, String> map, boolean z) {
        AppMethodBeat.i(57877);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(57877);
        } else {
            ab.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", Boolean.valueOf(z), com.tencent.mm.a.g.cz(str));
            if (z) {
                g.RQ();
                g.RP().Ry().set(278530, (Object) str);
            } else {
                g.RQ();
                g.RP().Ry().set(278529, (Object) str);
                g.RQ();
                g.RP().Ry().set(278530, (Object) "");
            }
            if (map != null) {
                b(map, z);
            } else {
                p(str, z);
            }
            a.xxA.m(new cq());
            AppMethodBeat.o(57877);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void p(String str, boolean z) {
        AppMethodBeat.i(57878);
        b(br.z(str, "sysmsg"), z);
        AppMethodBeat.o(57878);
    }

    private void b(Map<String, String> map, boolean z) {
        AppMethodBeat.i(57879);
        if (map == null) {
            AppMethodBeat.o(57879);
            return;
        }
        if (!z) {
            this.ewb.clear();
        }
        int i = 0;
        while (i < Downloads.MIN_WAIT_FOR_NETWORK) {
            String str;
            if (z) {
                str = ".sysmsg.dynacfg_split.Item" + (i == 0 ? "" : Integer.valueOf(i));
            } else {
                str = ".sysmsg.dynacfg.Item" + (i == 0 ? "" : Integer.valueOf(i));
            }
            String str2 = str + ".$key";
            str = (String) map.get(str);
            str2 = (String) map.get(str2);
            if (str2 == null || bo.isNullOrNil(str2.trim())) {
                break;
            }
            this.ewb.put(str2.trim(), str != null ? str : "");
            ab.d("MicroMsg.DynamicConfig", "put %s %s", str2.trim(), str);
            i++;
        }
        ab.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", this.ewb.toString());
        AppMethodBeat.o(57879);
    }
}
