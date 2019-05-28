package com.tencent.p177mm.p1099x;

import android.util.SparseArray;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

/* renamed from: com.tencent.mm.x.b */
public final class C30903b {
    SparseArray<C30902a> eFa = new SparseArray();
    HashMap<C5127a, C30902a> eFb = new HashMap();
    SparseArray<C30904b> eFc = new SparseArray();
    HashMap<C5127a, C30904b> eFd = new HashMap();
    private Random eFe = new Random();
    C7580z eFf = null;

    /* renamed from: com.tencent.mm.x.b$a */
    public class C30902a {
        String cxb;
        int eEW;
        C5127a eEX;
        int type;
        public String value;
    }

    /* renamed from: com.tencent.mm.x.b$b */
    public class C30904b {
        C5127a eEZ;
        int eFh;
        SparseArray<String> eFi = new SparseArray();
        HashMap<String, String> eFj = new HashMap();

        public C30904b() {
            AppMethodBeat.m2504i(77723);
            AppMethodBeat.m2505o(77723);
        }
    }

    public C30903b() {
        AppMethodBeat.m2504i(77724);
        AppMethodBeat.m2505o(77724);
    }

    private static String escape(String str) {
        AppMethodBeat.m2504i(77725);
        String replaceAll = str.replaceAll("\\|", "%7C");
        AppMethodBeat.m2505o(77725);
        return replaceAll;
    }

    private static String unescape(String str) {
        AppMethodBeat.m2504i(77726);
        String replaceAll = str.replaceAll("%7C", "|");
        AppMethodBeat.m2505o(77726);
        return replaceAll;
    }

    /* renamed from: a */
    private void m49323a(C30902a c30902a) {
        AppMethodBeat.m2504i(77727);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(c30902a.type);
        stringBuffer.append("|");
        stringBuffer.append(C30903b.escape(c30902a.value));
        stringBuffer.append("|");
        stringBuffer.append(C30903b.escape(c30902a.cxb));
        if (c30902a.eEX != null) {
            this.eFf.set(c30902a.eEX, stringBuffer.toString());
            AppMethodBeat.m2505o(77727);
            return;
        }
        this.eFf.set(c30902a.eEW, stringBuffer.toString());
        AppMethodBeat.m2505o(77727);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo49431a(C30904b c30904b) {
        String str;
        int i = 0;
        AppMethodBeat.m2504i(77728);
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        for (Entry entry : c30904b.eFj.entrySet()) {
            String str2 = (String) entry.getKey();
            str = (String) entry.getValue();
            if (i2 != 0) {
                stringBuffer.append("|");
            }
            stringBuffer.append(str2);
            stringBuffer.append("|");
            stringBuffer.append(C30903b.escape(str));
            i2++;
        }
        while (i < c30904b.eFi.size()) {
            int keyAt = c30904b.eFi.keyAt(i);
            str = (String) c30904b.eFi.get(keyAt);
            if (i2 != 0) {
                stringBuffer.append("|");
            }
            stringBuffer.append(keyAt);
            stringBuffer.append("|");
            stringBuffer.append(C30903b.escape(str));
            i2++;
            i++;
        }
        if (c30904b.eEZ != null) {
            this.eFf.set(c30904b.eEZ, stringBuffer.toString());
            AppMethodBeat.m2505o(77728);
            return;
        }
        this.eFf.set(c30904b.eFh, stringBuffer.toString());
        AppMethodBeat.m2505o(77728);
    }

    /* renamed from: ju */
    private C30902a m49328ju(int i) {
        AppMethodBeat.m2504i(77729);
        String str = (String) this.eFf.get(i, null);
        if (str == null) {
            AppMethodBeat.m2505o(77729);
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            C4990ab.m7413e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", str);
            AppMethodBeat.m2505o(77729);
            return null;
        }
        try {
            C30902a a = m49321a(i, Integer.valueOf(split[0]).intValue(), C30903b.unescape(split[1]), C30903b.unescape(split[2]));
            AppMethodBeat.m2505o(77729);
            return a;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NewBadgeDecoder", "exception:%s", C5046bo.m7574l(e));
            C4990ab.m7413e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", str);
            AppMethodBeat.m2505o(77729);
            return null;
        }
    }

    /* renamed from: c */
    private C30902a m49324c(C5127a c5127a) {
        AppMethodBeat.m2504i(77730);
        String str = (String) this.eFf.get(c5127a, null);
        if (str == null) {
            AppMethodBeat.m2505o(77730);
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            C4990ab.m7413e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", str);
            AppMethodBeat.m2505o(77730);
            return null;
        }
        try {
            C30902a a = m49322a(c5127a, Integer.valueOf(split[0]).intValue(), C30903b.unescape(split[1]), C30903b.unescape(split[2]));
            AppMethodBeat.m2505o(77730);
            return a;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NewBadgeDecoder", "exception:%s", C5046bo.m7574l(e));
            C4990ab.m7413e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", str);
            AppMethodBeat.m2505o(77730);
            return null;
        }
    }

    /* renamed from: lc */
    private static boolean m49330lc(String str) {
        AppMethodBeat.m2504i(77731);
        if (C5046bo.isNullOrNil(str) || !str.matches("^[\\d]+$")) {
            AppMethodBeat.m2505o(77731);
            return false;
        }
        AppMethodBeat.m2505o(77731);
        return true;
    }

    /* renamed from: jv */
    private C30904b m49329jv(int i) {
        AppMethodBeat.m2504i(77732);
        String str = (String) this.eFf.get(i, null);
        if (str == null) {
            C30904b jw = mo49437jw(i);
            AppMethodBeat.m2505o(77732);
            return jw;
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            C4990ab.m7413e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            AppMethodBeat.m2505o(77732);
            return null;
        }
        try {
            C30904b jw2 = mo49437jw(i);
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                if (C30903b.m49330lc(split[i2])) {
                    jw2.eFi.put(Integer.valueOf(split[i2]).intValue(), C30903b.unescape(split[i2 + 1]));
                } else {
                    jw2.eFj.put(split[i2], C30903b.unescape(split[i2 + 1]));
                }
            }
            AppMethodBeat.m2505o(77732);
            return jw2;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NewBadgeDecoder", "exception:%s", C5046bo.m7574l(e));
            C4990ab.m7413e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", str);
            AppMethodBeat.m2505o(77732);
            return null;
        }
    }

    /* renamed from: d */
    private C30904b m49327d(C5127a c5127a) {
        AppMethodBeat.m2504i(77733);
        String str = (String) this.eFf.get(c5127a, null);
        if (str == null) {
            C30904b e = mo49433e(c5127a);
            AppMethodBeat.m2505o(77733);
            return e;
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            C4990ab.m7413e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            AppMethodBeat.m2505o(77733);
            return null;
        }
        try {
            C30904b e2 = mo49433e(c5127a);
            for (int i = 0; i < split.length; i += 2) {
                if (C30903b.m49330lc(split[i])) {
                    e2.eFi.put(Integer.valueOf(split[i]).intValue(), C30903b.unescape(split[i + 1]));
                } else {
                    e2.eFj.put(split[i], C30903b.unescape(split[i + 1]));
                }
            }
            AppMethodBeat.m2505o(77733);
            return e2;
        } catch (Exception e3) {
            C4990ab.m7413e("MicroMsg.NewBadgeDecoder", "exception:%s", C5046bo.m7574l(e3));
            C4990ab.m7413e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", str);
            AppMethodBeat.m2505o(77733);
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: PI */
    public final String mo49429PI() {
        AppMethodBeat.m2504i(77734);
        long currentTimeMillis = System.currentTimeMillis();
        int nextInt = this.eFe.nextInt(Math.abs(this.eFe.nextInt(BaseClientBuilder.API_PRIORITY_OTHER))) % Downloads.MIN_WAIT_FOR_NETWORK;
        String format = String.format("%d%04d", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(nextInt)});
        AppMethodBeat.m2505o(77734);
        return format;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jw */
    public final C30904b mo49437jw(int i) {
        AppMethodBeat.m2504i(77735);
        C30904b c30904b = new C30904b();
        c30904b.eFh = i;
        AppMethodBeat.m2505o(77735);
        return c30904b;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final C30904b mo49433e(C5127a c5127a) {
        AppMethodBeat.m2504i(77736);
        C30904b c30904b = new C30904b();
        c30904b.eEZ = c5127a;
        AppMethodBeat.m2505o(77736);
        return c30904b;
    }

    /* renamed from: a */
    private C30902a m49321a(int i, int i2, String str, String str2) {
        AppMethodBeat.m2504i(77737);
        C30902a c30902a = new C30902a();
        c30902a.eEW = i;
        c30902a.type = i2;
        c30902a.value = str;
        c30902a.cxb = str2;
        AppMethodBeat.m2505o(77737);
        return c30902a;
    }

    /* renamed from: a */
    private C30902a m49322a(C5127a c5127a, int i, String str, String str2) {
        AppMethodBeat.m2504i(77738);
        C30902a c30902a = new C30902a();
        c30902a.eEX = c5127a;
        c30902a.type = i;
        c30902a.value = str;
        c30902a.cxb = str2;
        AppMethodBeat.m2505o(77738);
        return c30902a;
    }

    /* renamed from: ca */
    private C30902a m49326ca(int i, int i2) {
        AppMethodBeat.m2504i(77739);
        C30902a jx = mo49438jx(i);
        if (jx == null) {
            jx = m49321a(i, i2, "", "");
            this.eFa.put(i, jx);
            m49323a(jx);
        }
        AppMethodBeat.m2505o(77739);
        return jx;
    }

    /* renamed from: c */
    private C30902a m49325c(C5127a c5127a, int i) {
        AppMethodBeat.m2504i(77740);
        C30902a f = mo49434f(c5127a);
        if (f == null) {
            f = m49322a(c5127a, i, "", "");
            this.eFb.put(c5127a, f);
            m49323a(f);
        }
        AppMethodBeat.m2505o(77740);
        return f;
    }

    /* renamed from: jx */
    public final C30902a mo49438jx(int i) {
        AppMethodBeat.m2504i(77741);
        C30902a c30902a = (C30902a) this.eFa.get(i);
        if (c30902a == null) {
            c30902a = m49328ju(i);
            if (c30902a != null) {
                this.eFa.put(i, c30902a);
            }
        }
        AppMethodBeat.m2505o(77741);
        return c30902a;
    }

    /* renamed from: f */
    public final C30902a mo49434f(C5127a c5127a) {
        AppMethodBeat.m2504i(77742);
        C30902a c30902a = (C30902a) this.eFb.get(c5127a);
        if (c30902a == null) {
            c30902a = m49324c(c5127a);
            if (c30902a != null) {
                this.eFb.put(c5127a, c30902a);
            }
        }
        AppMethodBeat.m2505o(77742);
        return c30902a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jy */
    public final C30904b mo49439jy(int i) {
        AppMethodBeat.m2504i(77743);
        C30904b c30904b = (C30904b) this.eFc.get(i);
        if (c30904b == null) {
            c30904b = m49329jv(i);
            if (c30904b == null) {
                C4990ab.m7412e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
                AppMethodBeat.m2505o(77743);
                return null;
            }
            this.eFc.put(i, c30904b);
        }
        AppMethodBeat.m2505o(77743);
        return c30904b;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final C30904b mo49436g(C5127a c5127a) {
        AppMethodBeat.m2504i(77744);
        C30904b c30904b = (C30904b) this.eFd.get(c5127a);
        if (c30904b == null) {
            c30904b = m49327d(c5127a);
            if (c30904b == null) {
                C4990ab.m7412e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
                AppMethodBeat.m2505o(77744);
                return null;
            }
            this.eFd.put(c5127a, c30904b);
        }
        AppMethodBeat.m2505o(77744);
        return c30904b;
    }

    /* renamed from: f */
    public final void mo49435f(int i, int i2, String str) {
        AppMethodBeat.m2504i(77745);
        C4990ab.m7411d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        C30902a ca = m49326ca(i, i2);
        ca.value = str;
        ca.type = i2;
        ca.cxb = mo49429PI();
        m49323a(ca);
        AppMethodBeat.m2505o(77745);
    }

    /* renamed from: b */
    public final void mo49432b(C5127a c5127a, int i, String str) {
        AppMethodBeat.m2504i(77746);
        C4990ab.m7411d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", c5127a, Integer.valueOf(i), str);
        C30902a c = m49325c(c5127a, i);
        c.value = str;
        c.type = i;
        c.cxb = mo49429PI();
        m49323a(c);
        AppMethodBeat.m2505o(77746);
    }

    /* renamed from: F */
    public final C30902a mo49428F(int i, int i2, int i3) {
        AppMethodBeat.m2504i(77747);
        C4990ab.m7411d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        C30902a jx = mo49438jx(i);
        if (jx == null) {
            C4990ab.m7410d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            AppMethodBeat.m2505o(77747);
            return null;
        } else if ((jx.type & i3) == 0) {
            C4990ab.m7410d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            AppMethodBeat.m2505o(77747);
            return null;
        } else {
            C30904b jy = mo49439jy(i2);
            if (jy != null) {
                String str = (String) jy.eFi.get(i);
                if (str == null || !str.equals(jx.cxb)) {
                    if (str == null) {
                        jy.eFi.put(i, mo49429PI());
                        mo49431a(jy);
                    }
                    AppMethodBeat.m2505o(77747);
                    return jx;
                }
                AppMethodBeat.m2505o(77747);
                return null;
            }
            C4990ab.m7412e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            AppMethodBeat.m2505o(77747);
            return null;
        }
    }

    /* renamed from: a */
    public final C30902a mo49430a(C5127a c5127a, C5127a c5127a2, int i) {
        AppMethodBeat.m2504i(77748);
        C4990ab.m7411d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", c5127a, c5127a2, Integer.valueOf(i));
        C30902a f = mo49434f(c5127a);
        if (f == null) {
            C4990ab.m7410d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            AppMethodBeat.m2505o(77748);
            return null;
        } else if ((f.type & i) == 0) {
            C4990ab.m7410d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            AppMethodBeat.m2505o(77748);
            return null;
        } else {
            C30904b g = mo49436g(c5127a2);
            if (g != null) {
                String str = (String) g.eFj.get(c5127a.name());
                if (str == null || !str.equals(f.cxb)) {
                    if (str == null) {
                        g.eFj.put(c5127a.name(), mo49429PI());
                        mo49431a(g);
                    }
                    AppMethodBeat.m2505o(77748);
                    return f;
                }
                AppMethodBeat.m2505o(77748);
                return null;
            }
            C4990ab.m7412e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            AppMethodBeat.m2505o(77748);
            return null;
        }
    }
}
