package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.z.b;
import com.tencent.mm.plugin.appbrand.launching.h;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class s implements b {
    private static final ConcurrentHashMap<String, Boolean> gST = new ConcurrentHashMap();

    static final class a implements com.tencent.mm.plugin.appbrand.appcache.z.a {
        private final com.tencent.mm.plugin.appbrand.appcache.a.a gSV;
        private final int gSW;
        private final boolean gSX;
        private a gSY;
        private ArrayList<IDKey> gSZ;
        private long gTa;
        private long gTb;
        private long gTc;
        private kv_14609 gTd;

        enum a {
            DOWNLOAD(1),
            UPDATE(4),
            LIB_UPDATE(7),
            INCREMENTAL_UPDATE(10),
            LIB_INCREMENTAL_UPDATE(13);
            
            final int value;

            static {
                AppMethodBeat.o(129371);
            }

            private a(int i) {
                this.value = i;
            }
        }

        /* synthetic */ a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar, byte b) {
            this(aVar);
        }

        private a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
            int i;
            AppMethodBeat.i(129372);
            this.gTa = 0;
            this.gTb = 0;
            this.gTc = 0;
            this.gSV = aVar;
            this.gSW = s.xq(aVar.appId) ? 776 : 368;
            String[] split = aVar.appId.split(Pattern.quote("$"));
            if (split == null) {
                i = -1;
            } else {
                i = split.length;
            }
            this.gSX = i == 2;
            AppMethodBeat.o(129372);
        }

        private void nr(int i) {
            AppMethodBeat.i(129373);
            cN(this.gSW, i);
            AppMethodBeat.o(129373);
        }

        private void cN(int i, int i2) {
            AppMethodBeat.i(129374);
            if (this.gSZ == null) {
                this.gSZ = new ArrayList();
            }
            this.gSZ.add(new IDKey(i, i2, 1));
            AppMethodBeat.o(129374);
        }

        private void avI() {
            AppMethodBeat.i(129375);
            try {
                e.pXa.b(this.gSZ, false);
                this.gSZ.clear();
                AppMethodBeat.o(129375);
            } catch (Exception e) {
                AppMethodBeat.o(129375);
            }
        }

        public final void avp() {
            int i = 0;
            AppMethodBeat.i(129376);
            if (this.gSV instanceof al) {
                this.gSY = "@LibraryAppId".equals(this.gSV.appId) ? a.LIB_INCREMENTAL_UPDATE : a.INCREMENTAL_UPDATE;
                this.gTd = new kv_14609(this.gSV.appId, ((al) this.gSV).gTP, ((al) this.gSV).gTQ);
                this.gTd.iCn = bo.anU();
            } else if ("@LibraryAppId".equals(this.gSV.appId)) {
                this.gSY = a.LIB_UPDATE;
            } else if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(this.gSV.cBc)) {
                WxaPkgWrappingInfo bm = h.bm(this.gSV.appId, 1);
                this.gSY = bm != null ? a.UPDATE : a.DOWNLOAD;
                this.gTd = new kv_14609(this.gSV.appId, bm == null ? 0 : bm.gVu, this.gSV.version);
                this.gTd.iCn = bo.anU();
            } else {
                this.gSY = a.DOWNLOAD;
            }
            switch (AnonymousClass1.gSU[this.gSY.ordinal()]) {
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
            nr(i);
            this.gTa = SystemClock.elapsedRealtime();
            AppMethodBeat.o(129376);
        }

        public final void avq() {
            AppMethodBeat.i(129377);
            nr(32);
            AppMethodBeat.o(129377);
        }

        public final void avr() {
            int i;
            AppMethodBeat.i(129378);
            switch (AnonymousClass1.gSU[this.gSY.ordinal()]) {
                case 3:
                case 5:
                    i = 30;
                    break;
                default:
                    i = 31;
                    break;
            }
            nr(i);
            AppMethodBeat.o(129378);
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x006b A:{Catch:{ Exception -> 0x0112 }} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(m mVar) {
            int i;
            String str;
            AppMethodBeat.i(129379);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.gTa;
            int i2 = (mVar == null || mVar.status != 2) ? 0 : 1;
            if (this.gSY != null) {
                switch (AnonymousClass1.gSU[this.gSY.ordinal()]) {
                    case 1:
                        nr(i2 != 0 ? 2 : 3);
                        break;
                    case 2:
                        nr(i2 != 0 ? 11 : 12);
                        break;
                    case 3:
                        nr(i2 != 0 ? 21 : 22);
                        break;
                    case 4:
                        nr(i2 != 0 ? 36 : 37);
                        break;
                    case 5:
                        nr(i2 != 0 ? 47 : 48);
                        break;
                }
            }
            if (!(i2 != 0 || "@LibraryAppId".equals(this.gSV.appId) || 999 == this.gSV.cBc)) {
                int i3;
                if (mVar == null || !(mVar.httpStatusCode == 404 || mVar.httpStatusCode == 403)) {
                    i3 = 19;
                } else {
                    i3 = 23;
                }
                c.K(this.gSV.appId, i3, this.gSV.cBc + 1);
            }
            if (mVar != null) {
                try {
                    if (mVar.status == 2) {
                        i = 1;
                        if (a.LIB_UPDATE != this.gSY || a.LIB_INCREMENTAL_UPDATE == this.gSY) {
                            str = "";
                        } else {
                            str = this.gSV.appId;
                        }
                        c.a(str, this.gSY.value, i, elapsedRealtime, this.gSX);
                        avI();
                        if (this.gTd != null) {
                            if (i2 == 0) {
                                this.gTd.aLx();
                                if (!(this.gSV instanceof al)) {
                                    this.gTd.pL(0);
                                } else if (mVar == null) {
                                    this.gTd.pL(3);
                                } else if (mVar.httpStatusCode == 410) {
                                    this.gTd.pL(1);
                                } else if (mVar.httpStatusCode == 404) {
                                    this.gTd.pL(2);
                                } else {
                                    this.gTd.pL(3);
                                }
                                if (this.gSV instanceof bc) {
                                    this.gTd.iCq = elapsedRealtime;
                                }
                                this.gTd.IF();
                            } else if (this.gSV instanceof al) {
                                this.gTd.iCm = com.tencent.mm.a.e.cs(this.gSV.getFilePath());
                            } else {
                                this.gTd.iCl = com.tencent.mm.a.e.cs(this.gSV.getFilePath());
                            }
                            if (!((this.gSV instanceof bc) || (this.gSV instanceof al))) {
                                this.gTd.iCp = elapsedRealtime;
                            }
                        }
                        AppMethodBeat.o(129379);
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", e, "report onEnd, appId %s", this.gSV.appId);
                }
            }
            if (mVar != null) {
                if (mVar.status == 4) {
                    i = 3;
                    if (a.LIB_UPDATE != this.gSY) {
                    }
                    str = "";
                    c.a(str, this.gSY.value, i, elapsedRealtime, this.gSX);
                    avI();
                    if (this.gTd != null) {
                    }
                    AppMethodBeat.o(129379);
                }
            }
            i = 2;
            if (a.LIB_UPDATE != this.gSY) {
            }
            str = "";
            c.a(str, this.gSY.value, i, elapsedRealtime, this.gSX);
            avI();
            if (this.gTd != null) {
            }
            AppMethodBeat.o(129379);
        }

        public final void avs() {
            AppMethodBeat.i(129380);
            this.gTc = SystemClock.elapsedRealtime();
            cN(697, 1);
            AppMethodBeat.o(129380);
        }

        public final void nq(int i) {
            AppMethodBeat.i(129381);
            SystemClock.elapsedRealtime();
            if (i == 0) {
                cN(697, 2);
            } else if (i < 0) {
                cN(697, -i);
            } else if (i == 1) {
                cN(697, 10);
            }
            avI();
            if (this.gTd != null) {
                if (i != 0) {
                    if (i == -4) {
                        this.gTd.pL(4);
                    } else {
                        this.gTd.pL(5);
                    }
                    this.gTd.aLx();
                    this.gTd.IF();
                    AppMethodBeat.o(129381);
                    return;
                }
                this.gTd.iCl = com.tencent.mm.a.e.cs(((al) this.gSV).avR());
            }
            AppMethodBeat.o(129381);
        }

        public final void avt() {
            AppMethodBeat.i(129382);
            if (!(a.LIB_UPDATE == this.gSY || a.LIB_INCREMENTAL_UPDATE == this.gSY)) {
                c.K(this.gSV.appId, 20, this.gSV.cBc + 1);
            }
            AppMethodBeat.o(129382);
        }

        public final void avu() {
            AppMethodBeat.i(129383);
            this.gTb = SystemClock.elapsedRealtime();
            switch (AnonymousClass1.gSU[this.gSY.ordinal()]) {
                case 1:
                    nr(5);
                    AppMethodBeat.o(129383);
                    return;
                case 2:
                    nr(14);
                    AppMethodBeat.o(129383);
                    return;
                case 3:
                    nr(24);
                    AppMethodBeat.o(129383);
                    return;
                case 4:
                    nr(41);
                    AppMethodBeat.o(129383);
                    return;
                case 5:
                    nr(49);
                    break;
            }
            AppMethodBeat.o(129383);
        }

        public final void dz(boolean z) {
            int i;
            String str;
            AppMethodBeat.i(129384);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.gTb;
            switch (AnonymousClass1.gSU[this.gSY.ordinal()]) {
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
            nr(i);
            avI();
            if (a.LIB_UPDATE == this.gSY || a.LIB_INCREMENTAL_UPDATE == this.gSY) {
                str = "";
            } else {
                str = this.gSV.appId;
            }
            c.a(str, this.gSY.value + 1, z ? 1 : 2, elapsedRealtime, this.gSX);
            if (!z) {
                c.K(this.gSV.appId, 22, this.gSV.cBc + 1);
            }
            if (this.gTd != null) {
                this.gTd.aLx();
                if (this.gSY != a.INCREMENTAL_UPDATE && this.gSY != a.LIB_INCREMENTAL_UPDATE) {
                    this.gTd.iCj = z;
                } else if (z) {
                    this.gTd.iCj = true;
                    this.gTd.iCk = true;
                } else {
                    this.gTd.pL(6);
                }
                this.gTd.IF();
            }
            AppMethodBeat.o(129384);
        }

        public final void avv() {
            AppMethodBeat.i(129385);
            nr(56);
            AppMethodBeat.o(129385);
        }

        public final void dA(boolean z) {
            AppMethodBeat.i(129386);
            if (!z) {
                nr(57);
            } else if (this.gTd != null && (this.gSV instanceof bc)) {
                this.gTd.iCl = com.tencent.mm.a.e.cs(((bc) this.gSV).aws());
            }
            if (this.gTd != null) {
                this.gTd.iCq = SystemClock.elapsedRealtime() - this.gTa;
            }
            AppMethodBeat.o(129386);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.s$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] gSU = new int[a.values().length];

        static {
            AppMethodBeat.i(129368);
            try {
                gSU[a.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gSU[a.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                gSU[a.LIB_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                gSU[a.INCREMENTAL_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                gSU[a.LIB_INCREMENTAL_UPDATE.ordinal()] = 5;
                AppMethodBeat.o(129368);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(129368);
            }
        }
    }

    public final com.tencent.mm.plugin.appbrand.appcache.z.a a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        AppMethodBeat.i(129387);
        if (aq.class == aVar.getClass() || ak.class == aVar.getClass() || al.class == aVar.getClass() || bc.class == aVar.getClass()) {
            a aVar2 = new a(aVar, (byte) 0);
            AppMethodBeat.o(129387);
            return aVar2;
        }
        AppMethodBeat.o(129387);
        return null;
    }

    static {
        AppMethodBeat.i(129390);
        AppMethodBeat.o(129390);
    }

    public static void xp(String str) {
        AppMethodBeat.i(129388);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129388);
            return;
        }
        gST.put(str, Boolean.TRUE);
        AppMethodBeat.o(129388);
    }

    static /* synthetic */ boolean xq(String str) {
        AppMethodBeat.i(129389);
        if (bo.isNullOrNil(str) || !Boolean.TRUE.equals(gST.get(str))) {
            AppMethodBeat.o(129389);
            return false;
        }
        AppMethodBeat.o(129389);
        return true;
    }
}
