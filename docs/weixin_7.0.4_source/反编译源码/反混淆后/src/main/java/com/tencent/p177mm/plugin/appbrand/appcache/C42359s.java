package com.tencent.p177mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.appbrand.appcache.C26751z.C19074a;
import com.tencent.p177mm.plugin.appbrand.appcache.C26751z.C26750b;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a;
import com.tencent.p177mm.plugin.appbrand.launching.C19573h;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.s */
public final class C42359s implements C26750b {
    private static final ConcurrentHashMap<String, Boolean> gST = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.s$a */
    static final class C24684a implements C19074a {
        private final C10065a gSV;
        private final int gSW;
        private final boolean gSX;
        private C19072a gSY;
        private ArrayList<IDKey> gSZ;
        private long gTa;
        private long gTb;
        private long gTc;
        private kv_14609 gTd;

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.s$a$a */
        enum C19072a {
            DOWNLOAD(1),
            UPDATE(4),
            LIB_UPDATE(7),
            INCREMENTAL_UPDATE(10),
            LIB_INCREMENTAL_UPDATE(13);
            
            final int value;

            static {
                AppMethodBeat.m2505o(129371);
            }

            private C19072a(int i) {
                this.value = i;
            }
        }

        /* synthetic */ C24684a(C10065a c10065a, byte b) {
            this(c10065a);
        }

        private C24684a(C10065a c10065a) {
            int i;
            AppMethodBeat.m2504i(129372);
            this.gTa = 0;
            this.gTb = 0;
            this.gTc = 0;
            this.gSV = c10065a;
            this.gSW = C42359s.m74914xq(c10065a.appId) ? 776 : 368;
            String[] split = c10065a.appId.split(Pattern.quote("$"));
            if (split == null) {
                i = -1;
            } else {
                i = split.length;
            }
            this.gSX = i == 2;
            AppMethodBeat.m2505o(129372);
        }

        /* renamed from: nr */
        private void m38523nr(int i) {
            AppMethodBeat.m2504i(129373);
            m38522cN(this.gSW, i);
            AppMethodBeat.m2505o(129373);
        }

        /* renamed from: cN */
        private void m38522cN(int i, int i2) {
            AppMethodBeat.m2504i(129374);
            if (this.gSZ == null) {
                this.gSZ = new ArrayList();
            }
            this.gSZ.add(new IDKey(i, i2, 1));
            AppMethodBeat.m2505o(129374);
        }

        private void avI() {
            AppMethodBeat.m2504i(129375);
            try {
                C7053e.pXa.mo8379b(this.gSZ, false);
                this.gSZ.clear();
                AppMethodBeat.m2505o(129375);
            } catch (Exception e) {
                AppMethodBeat.m2505o(129375);
            }
        }

        public final void avp() {
            int i = 0;
            AppMethodBeat.m2504i(129376);
            if (this.gSV instanceof C38103al) {
                this.gSY = "@LibraryAppId".equals(this.gSV.appId) ? C19072a.LIB_INCREMENTAL_UPDATE : C19072a.INCREMENTAL_UPDATE;
                this.gTd = new kv_14609(this.gSV.appId, ((C38103al) this.gSV).gTP, ((C38103al) this.gSV).gTQ);
                this.gTd.iCn = C5046bo.anU();
            } else if ("@LibraryAppId".equals(this.gSV.appId)) {
                this.gSY = C19072a.LIB_UPDATE;
            } else if (C33097a.m54090np(this.gSV.cBc)) {
                WxaPkgWrappingInfo bm = C19573h.m30345bm(this.gSV.appId, 1);
                this.gSY = bm != null ? C19072a.UPDATE : C19072a.DOWNLOAD;
                this.gTd = new kv_14609(this.gSV.appId, bm == null ? 0 : bm.gVu, this.gSV.version);
                this.gTd.iCn = C5046bo.anU();
            } else {
                this.gSY = C19072a.DOWNLOAD;
            }
            switch (C381181.gSU[this.gSY.ordinal()]) {
                case 1:
                    i = 1;
                    break;
                case 2:
                    i = 10;
                    break;
                case 3:
                    i = 20;
                    break;
                case 4:
                    i = 35;
                    break;
                case 5:
                    i = 46;
                    break;
            }
            m38523nr(i);
            this.gTa = SystemClock.elapsedRealtime();
            AppMethodBeat.m2505o(129376);
        }

        public final void avq() {
            AppMethodBeat.m2504i(129377);
            m38523nr(32);
            AppMethodBeat.m2505o(129377);
        }

        public final void avr() {
            int i;
            AppMethodBeat.m2504i(129378);
            switch (C381181.gSU[this.gSY.ordinal()]) {
                case 3:
                case 5:
                    i = 30;
                    break;
                default:
                    i = 31;
                    break;
            }
            m38523nr(i);
            AppMethodBeat.m2505o(129378);
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x006b A:{Catch:{ Exception -> 0x0112 }} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo34289a(C40432m c40432m) {
            int i;
            String str;
            AppMethodBeat.m2504i(129379);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.gTa;
            int i2 = (c40432m == null || c40432m.status != 2) ? 0 : 1;
            if (this.gSY != null) {
                switch (C381181.gSU[this.gSY.ordinal()]) {
                    case 1:
                        m38523nr(i2 != 0 ? 2 : 3);
                        break;
                    case 2:
                        m38523nr(i2 != 0 ? 11 : 12);
                        break;
                    case 3:
                        m38523nr(i2 != 0 ? 21 : 22);
                        break;
                    case 4:
                        m38523nr(i2 != 0 ? 36 : 37);
                        break;
                    case 5:
                        m38523nr(i2 != 0 ? 47 : 48);
                        break;
                }
            }
            if (!(i2 != 0 || "@LibraryAppId".equals(this.gSV.appId) || 999 == this.gSV.cBc)) {
                int i3;
                if (c40432m == null || !(c40432m.httpStatusCode == 404 || c40432m.httpStatusCode == 403)) {
                    i3 = 19;
                } else {
                    i3 = 23;
                }
                C19690c.m30494K(this.gSV.appId, i3, this.gSV.cBc + 1);
            }
            if (c40432m != null) {
                try {
                    if (c40432m.status == 2) {
                        i = 1;
                        if (C19072a.LIB_UPDATE != this.gSY || C19072a.LIB_INCREMENTAL_UPDATE == this.gSY) {
                            str = "";
                        } else {
                            str = this.gSV.appId;
                        }
                        C19690c.m30498a(str, this.gSY.value, i, elapsedRealtime, this.gSX);
                        avI();
                        if (this.gTd != null) {
                            if (i2 == 0) {
                                this.gTd.aLx();
                                if (!(this.gSV instanceof C38103al)) {
                                    this.gTd.mo61205pL(0);
                                } else if (c40432m == null) {
                                    this.gTd.mo61205pL(3);
                                } else if (c40432m.httpStatusCode == 410) {
                                    this.gTd.mo61205pL(1);
                                } else if (c40432m.httpStatusCode == 404) {
                                    this.gTd.mo61205pL(2);
                                } else {
                                    this.gTd.mo61205pL(3);
                                }
                                if (this.gSV instanceof C26746bc) {
                                    this.gTd.iCq = elapsedRealtime;
                                }
                                this.gTd.mo61202IF();
                            } else if (this.gSV instanceof C38103al) {
                                this.gTd.iCm = C1173e.m2560cs(this.gSV.getFilePath());
                            } else {
                                this.gTd.iCl = C1173e.m2560cs(this.gSV.getFilePath());
                            }
                            if (!((this.gSV instanceof C26746bc) || (this.gSV instanceof C38103al))) {
                                this.gTd.iCp = elapsedRealtime;
                            }
                        }
                        AppMethodBeat.m2505o(129379);
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", e, "report onEnd, appId %s", this.gSV.appId);
                }
            }
            if (c40432m != null) {
                if (c40432m.status == 4) {
                    i = 3;
                    if (C19072a.LIB_UPDATE != this.gSY) {
                    }
                    str = "";
                    C19690c.m30498a(str, this.gSY.value, i, elapsedRealtime, this.gSX);
                    avI();
                    if (this.gTd != null) {
                    }
                    AppMethodBeat.m2505o(129379);
                }
            }
            i = 2;
            if (C19072a.LIB_UPDATE != this.gSY) {
            }
            str = "";
            C19690c.m30498a(str, this.gSY.value, i, elapsedRealtime, this.gSX);
            avI();
            if (this.gTd != null) {
            }
            AppMethodBeat.m2505o(129379);
        }

        public final void avs() {
            AppMethodBeat.m2504i(129380);
            this.gTc = SystemClock.elapsedRealtime();
            m38522cN(697, 1);
            AppMethodBeat.m2505o(129380);
        }

        /* renamed from: nq */
        public final void mo34299nq(int i) {
            AppMethodBeat.m2504i(129381);
            SystemClock.elapsedRealtime();
            if (i == 0) {
                m38522cN(697, 2);
            } else if (i < 0) {
                m38522cN(697, -i);
            } else if (i == 1) {
                m38522cN(697, 10);
            }
            avI();
            if (this.gTd != null) {
                if (i != 0) {
                    if (i == -4) {
                        this.gTd.mo61205pL(4);
                    } else {
                        this.gTd.mo61205pL(5);
                    }
                    this.gTd.aLx();
                    this.gTd.mo61202IF();
                    AppMethodBeat.m2505o(129381);
                    return;
                }
                this.gTd.iCl = C1173e.m2560cs(((C38103al) this.gSV).avR());
            }
            AppMethodBeat.m2505o(129381);
        }

        public final void avt() {
            AppMethodBeat.m2504i(129382);
            if (!(C19072a.LIB_UPDATE == this.gSY || C19072a.LIB_INCREMENTAL_UPDATE == this.gSY)) {
                C19690c.m30494K(this.gSV.appId, 20, this.gSV.cBc + 1);
            }
            AppMethodBeat.m2505o(129382);
        }

        public final void avu() {
            AppMethodBeat.m2504i(129383);
            this.gTb = SystemClock.elapsedRealtime();
            switch (C381181.gSU[this.gSY.ordinal()]) {
                case 1:
                    m38523nr(5);
                    AppMethodBeat.m2505o(129383);
                    return;
                case 2:
                    m38523nr(14);
                    AppMethodBeat.m2505o(129383);
                    return;
                case 3:
                    m38523nr(24);
                    AppMethodBeat.m2505o(129383);
                    return;
                case 4:
                    m38523nr(41);
                    AppMethodBeat.m2505o(129383);
                    return;
                case 5:
                    m38523nr(49);
                    break;
            }
            AppMethodBeat.m2505o(129383);
        }

        /* renamed from: dz */
        public final void mo34298dz(boolean z) {
            int i;
            String str;
            AppMethodBeat.m2504i(129384);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.gTb;
            switch (C381181.gSU[this.gSY.ordinal()]) {
                case 1:
                    if (!z) {
                        i = 7;
                        break;
                    } else {
                        i = 6;
                        break;
                    }
                case 2:
                    if (!z) {
                        i = 16;
                        break;
                    } else {
                        i = 15;
                        break;
                    }
                case 3:
                    if (!z) {
                        i = 26;
                        break;
                    } else {
                        i = 25;
                        break;
                    }
                case 4:
                    if (!z) {
                        i = 43;
                        break;
                    } else {
                        i = 42;
                        break;
                    }
                case 5:
                    if (!z) {
                        i = 51;
                        break;
                    } else {
                        i = 50;
                        break;
                    }
                default:
                    i = 0;
                    break;
            }
            m38523nr(i);
            avI();
            if (C19072a.LIB_UPDATE == this.gSY || C19072a.LIB_INCREMENTAL_UPDATE == this.gSY) {
                str = "";
            } else {
                str = this.gSV.appId;
            }
            C19690c.m30498a(str, this.gSY.value + 1, z ? 1 : 2, elapsedRealtime, this.gSX);
            if (!z) {
                C19690c.m30494K(this.gSV.appId, 22, this.gSV.cBc + 1);
            }
            if (this.gTd != null) {
                this.gTd.aLx();
                if (this.gSY != C19072a.INCREMENTAL_UPDATE && this.gSY != C19072a.LIB_INCREMENTAL_UPDATE) {
                    this.gTd.iCj = z;
                } else if (z) {
                    this.gTd.iCj = true;
                    this.gTd.iCk = true;
                } else {
                    this.gTd.mo61205pL(6);
                }
                this.gTd.mo61202IF();
            }
            AppMethodBeat.m2505o(129384);
        }

        public final void avv() {
            AppMethodBeat.m2504i(129385);
            m38523nr(56);
            AppMethodBeat.m2505o(129385);
        }

        /* renamed from: dA */
        public final void mo34297dA(boolean z) {
            AppMethodBeat.m2504i(129386);
            if (!z) {
                m38523nr(57);
            } else if (this.gTd != null && (this.gSV instanceof C26746bc)) {
                this.gTd.iCl = C1173e.m2560cs(((C26746bc) this.gSV).aws());
            }
            if (this.gTd != null) {
                this.gTd.iCq = SystemClock.elapsedRealtime() - this.gTa;
            }
            AppMethodBeat.m2505o(129386);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.s$1 */
    static /* synthetic */ class C381181 {
        static final /* synthetic */ int[] gSU = new int[C19072a.values().length];

        static {
            AppMethodBeat.m2504i(129368);
            try {
                gSU[C19072a.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gSU[C19072a.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                gSU[C19072a.LIB_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                gSU[C19072a.INCREMENTAL_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                gSU[C19072a.LIB_INCREMENTAL_UPDATE.ordinal()] = 5;
                AppMethodBeat.m2505o(129368);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.m2505o(129368);
            }
        }
    }

    /* renamed from: a */
    public final C19074a mo44527a(C10065a c10065a) {
        AppMethodBeat.m2504i(129387);
        if (C2050aq.class == c10065a.getClass() || C26737ak.class == c10065a.getClass() || C38103al.class == c10065a.getClass() || C26746bc.class == c10065a.getClass()) {
            C24684a c24684a = new C24684a(c10065a, (byte) 0);
            AppMethodBeat.m2505o(129387);
            return c24684a;
        }
        AppMethodBeat.m2505o(129387);
        return null;
    }

    static {
        AppMethodBeat.m2504i(129390);
        AppMethodBeat.m2505o(129390);
    }

    /* renamed from: xp */
    public static void m74913xp(String str) {
        AppMethodBeat.m2504i(129388);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129388);
            return;
        }
        gST.put(str, Boolean.TRUE);
        AppMethodBeat.m2505o(129388);
    }

    /* renamed from: xq */
    static /* synthetic */ boolean m74914xq(String str) {
        AppMethodBeat.m2504i(129389);
        if (C5046bo.isNullOrNil(str) || !Boolean.TRUE.equals(gST.get(str))) {
            AppMethodBeat.m2505o(129389);
            return false;
        }
        AppMethodBeat.m2505o(129389);
        return true;
    }
}
