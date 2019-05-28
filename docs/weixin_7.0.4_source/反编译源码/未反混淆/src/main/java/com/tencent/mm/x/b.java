package com.tencent.mm.x;

import android.util.SparseArray;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

public final class b {
    SparseArray<a> eFa = new SparseArray();
    HashMap<com.tencent.mm.storage.ac.a, a> eFb = new HashMap();
    SparseArray<b> eFc = new SparseArray();
    HashMap<com.tencent.mm.storage.ac.a, b> eFd = new HashMap();
    private Random eFe = new Random();
    z eFf = null;

    public class a {
        String cxb;
        int eEW;
        com.tencent.mm.storage.ac.a eEX;
        int type;
        public String value;
    }

    public class b {
        com.tencent.mm.storage.ac.a eEZ;
        int eFh;
        SparseArray<String> eFi = new SparseArray();
        HashMap<String, String> eFj = new HashMap();

        public b() {
            AppMethodBeat.i(77723);
            AppMethodBeat.o(77723);
        }
    }

    public b() {
        AppMethodBeat.i(77724);
        AppMethodBeat.o(77724);
    }

    private static String escape(String str) {
        AppMethodBeat.i(77725);
        String replaceAll = str.replaceAll("\\|", "%7C");
        AppMethodBeat.o(77725);
        return replaceAll;
    }

    private static String unescape(String str) {
        AppMethodBeat.i(77726);
        String replaceAll = str.replaceAll("%7C", "|");
        AppMethodBeat.o(77726);
        return replaceAll;
    }

    private void a(a aVar) {
        AppMethodBeat.i(77727);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(aVar.type);
        stringBuffer.append("|");
        stringBuffer.append(escape(aVar.value));
        stringBuffer.append("|");
        stringBuffer.append(escape(aVar.cxb));
        if (aVar.eEX != null) {
            this.eFf.set(aVar.eEX, stringBuffer.toString());
            AppMethodBeat.o(77727);
            return;
        }
        this.eFf.set(aVar.eEW, stringBuffer.toString());
        AppMethodBeat.o(77727);
    }

    /* Access modifiers changed, original: final */
    public final void a(b bVar) {
        String str;
        int i = 0;
        AppMethodBeat.i(77728);
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        for (Entry entry : bVar.eFj.entrySet()) {
            String str2 = (String) entry.getKey();
            str = (String) entry.getValue();
            if (i2 != 0) {
                stringBuffer.append("|");
            }
            stringBuffer.append(str2);
            stringBuffer.append("|");
            stringBuffer.append(escape(str));
            i2++;
        }
        while (i < bVar.eFi.size()) {
            int keyAt = bVar.eFi.keyAt(i);
            str = (String) bVar.eFi.get(keyAt);
            if (i2 != 0) {
                stringBuffer.append("|");
            }
            stringBuffer.append(keyAt);
            stringBuffer.append("|");
            stringBuffer.append(escape(str));
            i2++;
            i++;
        }
        if (bVar.eEZ != null) {
            this.eFf.set(bVar.eEZ, stringBuffer.toString());
            AppMethodBeat.o(77728);
            return;
        }
        this.eFf.set(bVar.eFh, stringBuffer.toString());
        AppMethodBeat.o(77728);
    }

    private a ju(int i) {
        AppMethodBeat.i(77729);
        String str = (String) this.eFf.get(i, null);
        if (str == null) {
            AppMethodBeat.o(77729);
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            ab.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", str);
            AppMethodBeat.o(77729);
            return null;
        }
        try {
            a a = a(i, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
            AppMethodBeat.o(77729);
            return a;
        } catch (Exception e) {
            ab.e("MicroMsg.NewBadgeDecoder", "exception:%s", bo.l(e));
            ab.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", str);
            AppMethodBeat.o(77729);
            return null;
        }
    }

    private a c(com.tencent.mm.storage.ac.a aVar) {
        AppMethodBeat.i(77730);
        String str = (String) this.eFf.get(aVar, null);
        if (str == null) {
            AppMethodBeat.o(77730);
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            ab.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", str);
            AppMethodBeat.o(77730);
            return null;
        }
        try {
            a a = a(aVar, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
            AppMethodBeat.o(77730);
            return a;
        } catch (Exception e) {
            ab.e("MicroMsg.NewBadgeDecoder", "exception:%s", bo.l(e));
            ab.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", str);
            AppMethodBeat.o(77730);
            return null;
        }
    }

    private static boolean lc(String str) {
        AppMethodBeat.i(77731);
        if (bo.isNullOrNil(str) || !str.matches("^[\\d]+$")) {
            AppMethodBeat.o(77731);
            return false;
        }
        AppMethodBeat.o(77731);
        return true;
    }

    private b jv(int i) {
        AppMethodBeat.i(77732);
        String str = (String) this.eFf.get(i, null);
        if (str == null) {
            b jw = jw(i);
            AppMethodBeat.o(77732);
            return jw;
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            ab.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            AppMethodBeat.o(77732);
            return null;
        }
        try {
            b jw2 = jw(i);
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                if (lc(split[i2])) {
                    jw2.eFi.put(Integer.valueOf(split[i2]).intValue(), unescape(split[i2 + 1]));
                } else {
                    jw2.eFj.put(split[i2], unescape(split[i2 + 1]));
                }
            }
            AppMethodBeat.o(77732);
            return jw2;
        } catch (Exception e) {
            ab.e("MicroMsg.NewBadgeDecoder", "exception:%s", bo.l(e));
            ab.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", str);
            AppMethodBeat.o(77732);
            return null;
        }
    }

    private b d(com.tencent.mm.storage.ac.a aVar) {
        AppMethodBeat.i(77733);
        String str = (String) this.eFf.get(aVar, null);
        if (str == null) {
            b e = e(aVar);
            AppMethodBeat.o(77733);
            return e;
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            ab.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            AppMethodBeat.o(77733);
            return null;
        }
        try {
            b e2 = e(aVar);
            for (int i = 0; i < split.length; i += 2) {
                if (lc(split[i])) {
                    e2.eFi.put(Integer.valueOf(split[i]).intValue(), unescape(split[i + 1]));
                } else {
                    e2.eFj.put(split[i], unescape(split[i + 1]));
                }
            }
            AppMethodBeat.o(77733);
            return e2;
        } catch (Exception e3) {
            ab.e("MicroMsg.NewBadgeDecoder", "exception:%s", bo.l(e3));
            ab.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", str);
            AppMethodBeat.o(77733);
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    public final String PI() {
        AppMethodBeat.i(77734);
        long currentTimeMillis = System.currentTimeMillis();
        int nextInt = this.eFe.nextInt(Math.abs(this.eFe.nextInt(BaseClientBuilder.API_PRIORITY_OTHER))) % Downloads.MIN_WAIT_FOR_NETWORK;
        String format = String.format("%d%04d", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(nextInt)});
        AppMethodBeat.o(77734);
        return format;
    }

    /* Access modifiers changed, original: final */
    public final b jw(int i) {
        AppMethodBeat.i(77735);
        b bVar = new b();
        bVar.eFh = i;
        AppMethodBeat.o(77735);
        return bVar;
    }

    /* Access modifiers changed, original: final */
    public final b e(com.tencent.mm.storage.ac.a aVar) {
        AppMethodBeat.i(77736);
        b bVar = new b();
        bVar.eEZ = aVar;
        AppMethodBeat.o(77736);
        return bVar;
    }

    private a a(int i, int i2, String str, String str2) {
        AppMethodBeat.i(77737);
        a aVar = new a();
        aVar.eEW = i;
        aVar.type = i2;
        aVar.value = str;
        aVar.cxb = str2;
        AppMethodBeat.o(77737);
        return aVar;
    }

    private a a(com.tencent.mm.storage.ac.a aVar, int i, String str, String str2) {
        AppMethodBeat.i(77738);
        a aVar2 = new a();
        aVar2.eEX = aVar;
        aVar2.type = i;
        aVar2.value = str;
        aVar2.cxb = str2;
        AppMethodBeat.o(77738);
        return aVar2;
    }

    private a ca(int i, int i2) {
        AppMethodBeat.i(77739);
        a jx = jx(i);
        if (jx == null) {
            jx = a(i, i2, "", "");
            this.eFa.put(i, jx);
            a(jx);
        }
        AppMethodBeat.o(77739);
        return jx;
    }

    private a c(com.tencent.mm.storage.ac.a aVar, int i) {
        AppMethodBeat.i(77740);
        a f = f(aVar);
        if (f == null) {
            f = a(aVar, i, "", "");
            this.eFb.put(aVar, f);
            a(f);
        }
        AppMethodBeat.o(77740);
        return f;
    }

    public final a jx(int i) {
        AppMethodBeat.i(77741);
        a aVar = (a) this.eFa.get(i);
        if (aVar == null) {
            aVar = ju(i);
            if (aVar != null) {
                this.eFa.put(i, aVar);
            }
        }
        AppMethodBeat.o(77741);
        return aVar;
    }

    public final a f(com.tencent.mm.storage.ac.a aVar) {
        AppMethodBeat.i(77742);
        a aVar2 = (a) this.eFb.get(aVar);
        if (aVar2 == null) {
            aVar2 = c(aVar);
            if (aVar2 != null) {
                this.eFb.put(aVar, aVar2);
            }
        }
        AppMethodBeat.o(77742);
        return aVar2;
    }

    /* Access modifiers changed, original: final */
    public final b jy(int i) {
        AppMethodBeat.i(77743);
        b bVar = (b) this.eFc.get(i);
        if (bVar == null) {
            bVar = jv(i);
            if (bVar == null) {
                ab.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
                AppMethodBeat.o(77743);
                return null;
            }
            this.eFc.put(i, bVar);
        }
        AppMethodBeat.o(77743);
        return bVar;
    }

    /* Access modifiers changed, original: final */
    public final b g(com.tencent.mm.storage.ac.a aVar) {
        AppMethodBeat.i(77744);
        b bVar = (b) this.eFd.get(aVar);
        if (bVar == null) {
            bVar = d(aVar);
            if (bVar == null) {
                ab.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
                AppMethodBeat.o(77744);
                return null;
            }
            this.eFd.put(aVar, bVar);
        }
        AppMethodBeat.o(77744);
        return bVar;
    }

    public final void f(int i, int i2, String str) {
        AppMethodBeat.i(77745);
        ab.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        a ca = ca(i, i2);
        ca.value = str;
        ca.type = i2;
        ca.cxb = PI();
        a(ca);
        AppMethodBeat.o(77745);
    }

    public final void b(com.tencent.mm.storage.ac.a aVar, int i, String str) {
        AppMethodBeat.i(77746);
        ab.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", aVar, Integer.valueOf(i), str);
        a c = c(aVar, i);
        c.value = str;
        c.type = i;
        c.cxb = PI();
        a(c);
        AppMethodBeat.o(77746);
    }

    public final a F(int i, int i2, int i3) {
        AppMethodBeat.i(77747);
        ab.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        a jx = jx(i);
        if (jx == null) {
            ab.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            AppMethodBeat.o(77747);
            return null;
        } else if ((jx.type & i3) == 0) {
            ab.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            AppMethodBeat.o(77747);
            return null;
        } else {
            b jy = jy(i2);
            if (jy != null) {
                String str = (String) jy.eFi.get(i);
                if (str == null || !str.equals(jx.cxb)) {
                    if (str == null) {
                        jy.eFi.put(i, PI());
                        a(jy);
                    }
                    AppMethodBeat.o(77747);
                    return jx;
                }
                AppMethodBeat.o(77747);
                return null;
            }
            ab.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            AppMethodBeat.o(77747);
            return null;
        }
    }

    public final a a(com.tencent.mm.storage.ac.a aVar, com.tencent.mm.storage.ac.a aVar2, int i) {
        AppMethodBeat.i(77748);
        ab.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", aVar, aVar2, Integer.valueOf(i));
        a f = f(aVar);
        if (f == null) {
            ab.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            AppMethodBeat.o(77748);
            return null;
        } else if ((f.type & i) == 0) {
            ab.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            AppMethodBeat.o(77748);
            return null;
        } else {
            b g = g(aVar2);
            if (g != null) {
                String str = (String) g.eFj.get(aVar.name());
                if (str == null || !str.equals(f.cxb)) {
                    if (str == null) {
                        g.eFj.put(aVar.name(), PI());
                        a(g);
                    }
                    AppMethodBeat.o(77748);
                    return f;
                }
                AppMethodBeat.o(77748);
                return null;
            }
            ab.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            AppMethodBeat.o(77748);
            return null;
        }
    }
}
