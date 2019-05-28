package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.fav.a.h */
public final class C27968h {
    private static Map<Long, Long> meR = new HashMap();
    private static Map<Long, Long> meS = new HashMap();

    /* renamed from: com.tencent.mm.plugin.fav.a.h$a */
    public static class C27969a {
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
            AppMethodBeat.m2504i(102648);
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
            AppMethodBeat.m2505o(102648);
            return format;
        }
    }

    /* renamed from: vv */
    public static final void m44533vv(int i) {
        AppMethodBeat.m2504i(102649);
        C7053e.pXa.mo8378a(802, (long) i, 1, false);
        AppMethodBeat.m2505o(102649);
    }

    /* renamed from: vw */
    public static final void m44534vw(int i) {
        AppMethodBeat.m2504i(102650);
        C7053e.pXa.mo8378a(802, 4, (long) i, false);
        AppMethodBeat.m2505o(102650);
    }

    static {
        AppMethodBeat.m2504i(102657);
        AppMethodBeat.m2505o(102657);
    }

    /* renamed from: iw */
    public static void m44528iw(long j) {
        AppMethodBeat.m2504i(102651);
        if (meR.containsKey(Long.valueOf(j))) {
            AppMethodBeat.m2505o(102651);
            return;
        }
        meR.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(102651);
    }

    /* renamed from: ix */
    public static long m44529ix(long j) {
        AppMethodBeat.m2504i(102652);
        Long l = (Long) meR.get(Long.valueOf(j));
        if (l == null) {
            AppMethodBeat.m2505o(102652);
            return -1;
        }
        long currentTimeMillis = System.currentTimeMillis() - l.longValue();
        AppMethodBeat.m2505o(102652);
        return currentTimeMillis;
    }

    /* renamed from: iy */
    public static void m44530iy(long j) {
        AppMethodBeat.m2504i(102653);
        if (meS.containsKey(Long.valueOf(j))) {
            AppMethodBeat.m2505o(102653);
            return;
        }
        meS.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(102653);
    }

    /* renamed from: ed */
    public static int m44527ed(int i, int i2) {
        if (i2 == -401) {
            return -4;
        }
        if (i == 4) {
            return -2;
        }
        return -1;
    }

    /* renamed from: a */
    public static String m44526a(C27969a c27969a) {
        int i;
        int i2 = 1;
        AppMethodBeat.m2504i(102654);
        C4990ab.m7419v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", c27969a.toString());
        C7053e.pXa.mo8374X(15098, r0);
        String str = "scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]";
        Object[] objArr = new Object[18];
        objArr[0] = Integer.valueOf(c27969a.scene);
        objArr[1] = Integer.valueOf(c27969a.index);
        objArr[2] = Long.valueOf(c27969a.meT);
        objArr[3] = Integer.valueOf(c27969a.type);
        objArr[4] = c27969a.meU;
        objArr[5] = Integer.valueOf(c27969a.cvd);
        objArr[6] = Long.valueOf(c27969a.timestamp);
        objArr[7] = Long.valueOf(c27969a.meV);
        objArr[8] = Long.valueOf(c27969a.meW);
        if (c27969a.meX) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[9] = Integer.valueOf(i);
        objArr[10] = Integer.valueOf(c27969a.meY);
        objArr[11] = Integer.valueOf(c27969a.meZ);
        objArr[12] = Integer.valueOf(c27969a.mfa);
        objArr[13] = Integer.valueOf(c27969a.mfb);
        objArr[14] = Integer.valueOf(c27969a.mfc);
        if (c27969a.mfd) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[15] = Integer.valueOf(i);
        if (!c27969a.mfe) {
            i2 = 0;
        }
        objArr[16] = Integer.valueOf(i2);
        objArr[17] = Integer.valueOf(c27969a.jSW);
        String format = String.format(str, objArr);
        AppMethodBeat.m2505o(102654);
        return format;
    }

    /* renamed from: j */
    public static void m44531j(long j, int i, int i2) {
        AppMethodBeat.m2504i(102655);
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
        if (iE != null) {
            int i3 = iE.field_favProto.wit.cvp;
            String str = iE.field_favProto.wit.cEV;
            int i4 = 0;
            if (i == 1) {
                i4 = C1855t.m3896kH(iE.field_favProto.wit.cEV) ? 2 : 1;
            }
            C7060h.pYm.mo8381e(10651, Integer.valueOf(iE.field_type), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(iE.field_id), C39037b.m66418r(iE), Long.valueOf(iE.field_updateTime / 1000), Integer.valueOf(i3), str, Integer.valueOf(i4), "");
        }
        AppMethodBeat.m2505o(102655);
    }

    /* renamed from: k */
    public static void m44532k(long j, int i, int i2) {
        AppMethodBeat.m2504i(102656);
        if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23694iF(j) != null) {
            C7060h.pYm.mo8381e(11122, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().buE()), Integer.valueOf(i2), Integer.valueOf(r1.field_type), C39037b.m66418r(r1), Long.valueOf(r1.field_updateTime), Integer.valueOf(r1.field_favProto.wit.cvp), r1.field_favProto.wit.cEV);
        }
        AppMethodBeat.m2505o(102656);
    }
}
