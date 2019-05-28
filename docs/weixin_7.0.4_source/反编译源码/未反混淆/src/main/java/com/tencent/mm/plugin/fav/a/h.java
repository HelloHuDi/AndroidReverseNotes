package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class h {
    private static Map<Long, Long> meR = new HashMap();
    private static Map<Long, Long> meS = new HashMap();

    public static class a {
        public int cvd;
        public int index;
        public int jSW;
        public long meT;
        public String meU;
        public long meV;
        public long meW;
        public boolean meX;
        public int meY;
        public int meZ;
        public int mfa;
        public int mfb;
        public int mfc;
        public boolean mfd;
        public boolean mfe;
        public int mff;
        public String mfg;
        public String query;
        public int scene;
        public String sid;
        public long timestamp;
        public int type;

        public final String toString() {
            int i;
            int i2 = 1;
            AppMethodBeat.i(102648);
            String str = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
            Object[] objArr = new Object[22];
            objArr[0] = Integer.valueOf(this.scene);
            objArr[1] = Integer.valueOf(this.index);
            objArr[2] = Long.valueOf(this.meT);
            objArr[3] = Integer.valueOf(this.type);
            objArr[4] = this.meU;
            objArr[5] = Integer.valueOf(this.cvd);
            objArr[6] = Long.valueOf(this.timestamp);
            objArr[7] = Long.valueOf(this.meV);
            objArr[8] = Long.valueOf(this.meW);
            if (this.meX) {
                i = 1;
            } else {
                i = 0;
            }
            objArr[9] = Integer.valueOf(i);
            objArr[10] = Integer.valueOf(this.meY);
            objArr[11] = Integer.valueOf(this.meZ);
            objArr[12] = Integer.valueOf(this.mfa);
            objArr[13] = Integer.valueOf(this.mfb);
            objArr[14] = Integer.valueOf(this.mfc);
            if (this.mfd) {
                i = 1;
            } else {
                i = 0;
            }
            objArr[15] = Integer.valueOf(i);
            if (!this.mfe) {
                i2 = 0;
            }
            objArr[16] = Integer.valueOf(i2);
            objArr[17] = Integer.valueOf(this.jSW);
            objArr[18] = this.sid;
            objArr[19] = Integer.valueOf(this.mff);
            objArr[20] = this.query;
            objArr[21] = this.mfg;
            String format = String.format(str, objArr);
            AppMethodBeat.o(102648);
            return format;
        }
    }

    public static final void vv(int i) {
        AppMethodBeat.i(102649);
        e.pXa.a(802, (long) i, 1, false);
        AppMethodBeat.o(102649);
    }

    public static final void vw(int i) {
        AppMethodBeat.i(102650);
        e.pXa.a(802, 4, (long) i, false);
        AppMethodBeat.o(102650);
    }

    static {
        AppMethodBeat.i(102657);
        AppMethodBeat.o(102657);
    }

    public static void iw(long j) {
        AppMethodBeat.i(102651);
        if (meR.containsKey(Long.valueOf(j))) {
            AppMethodBeat.o(102651);
            return;
        }
        meR.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(102651);
    }

    public static long ix(long j) {
        AppMethodBeat.i(102652);
        Long l = (Long) meR.get(Long.valueOf(j));
        if (l == null) {
            AppMethodBeat.o(102652);
            return -1;
        }
        long currentTimeMillis = System.currentTimeMillis() - l.longValue();
        AppMethodBeat.o(102652);
        return currentTimeMillis;
    }

    public static void iy(long j) {
        AppMethodBeat.i(102653);
        if (meS.containsKey(Long.valueOf(j))) {
            AppMethodBeat.o(102653);
            return;
        }
        meS.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(102653);
    }

    public static int ed(int i, int i2) {
        if (i2 == -401) {
            return -4;
        }
        if (i == 4) {
            return -2;
        }
        return -1;
    }

    public static String a(a aVar) {
        int i;
        int i2 = 1;
        AppMethodBeat.i(102654);
        ab.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", aVar.toString());
        e.pXa.X(15098, r0);
        String str = "scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]";
        Object[] objArr = new Object[18];
        objArr[0] = Integer.valueOf(aVar.scene);
        objArr[1] = Integer.valueOf(aVar.index);
        objArr[2] = Long.valueOf(aVar.meT);
        objArr[3] = Integer.valueOf(aVar.type);
        objArr[4] = aVar.meU;
        objArr[5] = Integer.valueOf(aVar.cvd);
        objArr[6] = Long.valueOf(aVar.timestamp);
        objArr[7] = Long.valueOf(aVar.meV);
        objArr[8] = Long.valueOf(aVar.meW);
        if (aVar.meX) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[9] = Integer.valueOf(i);
        objArr[10] = Integer.valueOf(aVar.meY);
        objArr[11] = Integer.valueOf(aVar.meZ);
        objArr[12] = Integer.valueOf(aVar.mfa);
        objArr[13] = Integer.valueOf(aVar.mfb);
        objArr[14] = Integer.valueOf(aVar.mfc);
        if (aVar.mfd) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[15] = Integer.valueOf(i);
        if (!aVar.mfe) {
            i2 = 0;
        }
        objArr[16] = Integer.valueOf(i2);
        objArr[17] = Integer.valueOf(aVar.jSW);
        String format = String.format(str, objArr);
        AppMethodBeat.o(102654);
        return format;
    }

    public static void j(long j, int i, int i2) {
        AppMethodBeat.i(102655);
        g iE = ((ae) g.M(ae.class)).getFavItemInfoStorage().iE(j);
        if (iE != null) {
            int i3 = iE.field_favProto.wit.cvp;
            String str = iE.field_favProto.wit.cEV;
            int i4 = 0;
            if (i == 1) {
                i4 = t.kH(iE.field_favProto.wit.cEV) ? 2 : 1;
            }
            com.tencent.mm.plugin.report.service.h.pYm.e(10651, Integer.valueOf(iE.field_type), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(iE.field_id), b.r(iE), Long.valueOf(iE.field_updateTime / 1000), Integer.valueOf(i3), str, Integer.valueOf(i4), "");
        }
        AppMethodBeat.o(102655);
    }

    public static void k(long j, int i, int i2) {
        AppMethodBeat.i(102656);
        if (((ae) g.M(ae.class)).getFavItemInfoStorage().iF(j) != null) {
            com.tencent.mm.plugin.report.service.h.pYm.e(11122, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(((ae) g.M(ae.class)).getFavTagSetMgr().buE()), Integer.valueOf(i2), Integer.valueOf(r1.field_type), b.r(r1), Long.valueOf(r1.field_updateTime), Integer.valueOf(r1.field_favProto.wit.cvp), r1.field_favProto.wit.cEV);
        }
        AppMethodBeat.o(102656);
    }
}
