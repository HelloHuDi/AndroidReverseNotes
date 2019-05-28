package com.tencent.p177mm.plugin.multitalk.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.multitalk.model.e */
public final class C12626e {
    public static int oFV = 0;
    public static int oFW = 0;
    public static int oFX = 0;
    public static int oFY = 0;
    public static int oFZ = 0;

    /* renamed from: a */
    public static final void m20589a(boolean z, long j, String str) {
        int i;
        AppMethodBeat.m2504i(53911);
        C4990ab.m7419v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectSuccess %b %d %s", Boolean.valueOf(z), Long.valueOf(j), str);
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        C7060h.pYm.mo8381e(12725, Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(j), str);
        AppMethodBeat.m2505o(53911);
    }

    /* renamed from: a */
    public static final void m20590a(boolean z, long j, String str, int i) {
        int i2;
        AppMethodBeat.m2504i(53912);
        C4990ab.m7419v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectFail %b %d %s %d", Boolean.valueOf(z), Long.valueOf(j), str, Integer.valueOf(i));
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        C7060h.pYm.mo8381e(12725, Integer.valueOf(2), Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i));
        AppMethodBeat.m2505o(53912);
    }

    public static final void bRr() {
        AppMethodBeat.m2504i(53913);
        C4990ab.m7418v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailSuccess");
        C7060h.pYm.mo8381e(12722, Integer.valueOf(1));
        AppMethodBeat.m2505o(53913);
    }

    public static final void bRs() {
        AppMethodBeat.m2504i(53914);
        C4990ab.m7418v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailFail");
        C7060h.pYm.mo8381e(12722, Integer.valueOf(2));
        AppMethodBeat.m2505o(53914);
    }

    /* renamed from: aR */
    public static final void m20591aR(int i, String str) {
        AppMethodBeat.m2504i(53915);
        C4990ab.m7419v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkReceiveCall %d %s", Integer.valueOf(i), str);
        C7060h.pYm.mo8381e(12723, Integer.valueOf(i), str);
        AppMethodBeat.m2505o(53915);
    }

    /* renamed from: q */
    public static final void m20596q(long j, String str) {
        AppMethodBeat.m2504i(53916);
        C4990ab.m7419v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMutliTalkDuration %d %s", Long.valueOf(j), str);
        C7060h.pYm.mo8381e(12726, Long.valueOf(j), str);
        AppMethodBeat.m2505o(53916);
    }

    /* renamed from: a */
    public static final void m20588a(int i, boolean z, int i2, String str, int i3) {
        int i4;
        AppMethodBeat.m2504i(53917);
        C4990ab.m7419v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkSelectContact %d %b %d %s %d", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3));
        if (z) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        C7060h.pYm.mo8381e(12727, Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(i3));
        AppMethodBeat.m2505o(53917);
    }

    /* renamed from: r */
    public static final void m20597r(long j, String str) {
        AppMethodBeat.m2504i(53918);
        long j2 = j > 1000 ? j / 1000 : 1;
        C4990ab.m7419v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkVideoDuration %d %s", Long.valueOf(j2), str);
        C7060h.pYm.mo8381e(12728, Long.valueOf(j2), str);
        AppMethodBeat.m2505o(53918);
    }

    /* renamed from: Sh */
    public static final void m20587Sh(String str) {
        AppMethodBeat.m2504i(53919);
        C4990ab.m7419v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkFunction %s %d %d %d %d %d", str, Integer.valueOf(oFV), Integer.valueOf(oFW), Integer.valueOf(oFX), Integer.valueOf(oFY), Integer.valueOf(oFZ));
        C7060h.pYm.mo8381e(12729, str, Integer.valueOf(oFV), Integer.valueOf(oFW), Integer.valueOf(oFX), Integer.valueOf(oFY), Integer.valueOf(oFZ));
        C12626e.m20592eC(9, oFV);
        C12626e.m20592eC(10, oFZ);
        C12626e.m20592eC(11, oFW);
        C12626e.m20592eC(12, oFX);
        C12626e.m20592eC(13, oFY);
        oFV = 0;
        oFW = 0;
        oFX = 0;
        oFY = 0;
        oFZ = 0;
        AppMethodBeat.m2505o(53919);
    }

    /* renamed from: f */
    public static final void m20593f(String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(53920);
        if (z && z2) {
            C7060h.pYm.mo8381e(12917, str, Integer.valueOf(2), Integer.valueOf(1));
            AppMethodBeat.m2505o(53920);
        } else if (z) {
            C7060h.pYm.mo8381e(12917, str, Integer.valueOf(2), Integer.valueOf(2));
            AppMethodBeat.m2505o(53920);
        } else if (z2) {
            C7060h.pYm.mo8381e(12917, str, Integer.valueOf(1), Integer.valueOf(1));
            AppMethodBeat.m2505o(53920);
        } else {
            C7060h.pYm.mo8381e(12917, str, Integer.valueOf(1), Integer.valueOf(2));
            AppMethodBeat.m2505o(53920);
        }
    }

    public static final void bRt() {
        AppMethodBeat.m2504i(53921);
        C7060h.pYm.mo8378a(220, 0, 1, false);
        AppMethodBeat.m2505o(53921);
    }

    /* renamed from: jl */
    public static final void m20594jl(boolean z) {
        AppMethodBeat.m2504i(53922);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(3);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(220);
            iDKey.SetKey(4);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        C7060h.pYm.mo8379b(arrayList, false);
        AppMethodBeat.m2505o(53922);
    }

    public static final void bRu() {
        AppMethodBeat.m2504i(53923);
        C7060h.pYm.mo8378a(220, 1, 1, false);
        AppMethodBeat.m2505o(53923);
    }

    /* renamed from: jm */
    public static final void m20595jm(boolean z) {
        AppMethodBeat.m2504i(53924);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(5);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(220);
            iDKey.SetKey(6);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        C7060h.pYm.mo8379b(arrayList, false);
        AppMethodBeat.m2505o(53924);
    }

    /* renamed from: zd */
    public static final void m20598zd(int i) {
        AppMethodBeat.m2504i(53925);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(7);
        iDKey.SetValue((long) i);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(8);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        C7060h.pYm.mo8379b(arrayList, false);
        AppMethodBeat.m2505o(53925);
    }

    /* renamed from: eC */
    private static void m20592eC(int i, int i2) {
        AppMethodBeat.m2504i(53926);
        C7060h.pYm.mo8378a(220, (long) i, (long) i2, false);
        AppMethodBeat.m2505o(53926);
    }

    public static final void bRv() {
        AppMethodBeat.m2504i(53927);
        C7060h.pYm.mo8381e(14849, Integer.valueOf(1));
        AppMethodBeat.m2505o(53927);
    }

    public static final void bRw() {
        AppMethodBeat.m2504i(53928);
        C7060h.pYm.mo8381e(14849, Integer.valueOf(2));
        AppMethodBeat.m2505o(53928);
    }

    public static final void bRx() {
        AppMethodBeat.m2504i(53929);
        C7060h.pYm.mo8381e(14849, Integer.valueOf(3));
        AppMethodBeat.m2505o(53929);
    }

    public static final void bRy() {
        AppMethodBeat.m2504i(53930);
        C7060h.pYm.mo8381e(14849, Integer.valueOf(4));
        AppMethodBeat.m2505o(53930);
    }

    public static final void bRz() {
        AppMethodBeat.m2504i(53931);
        C7060h.pYm.mo8381e(14849, Integer.valueOf(5));
        AppMethodBeat.m2505o(53931);
    }

    public static final void bRA() {
        AppMethodBeat.m2504i(53932);
        C7060h.pYm.mo8381e(14849, Integer.valueOf(6));
        AppMethodBeat.m2505o(53932);
    }

    public static final void bRB() {
        AppMethodBeat.m2504i(53933);
        C7060h.pYm.mo8381e(14849, Integer.valueOf(7));
        AppMethodBeat.m2505o(53933);
    }

    public static final void bRC() {
        AppMethodBeat.m2504i(53934);
        C7060h.pYm.mo8381e(14849, Integer.valueOf(8));
        AppMethodBeat.m2505o(53934);
    }

    public static final void bRD() {
        AppMethodBeat.m2504i(53935);
        C7060h.pYm.mo8381e(14849, Integer.valueOf(9));
        AppMethodBeat.m2505o(53935);
    }

    public static final void bRE() {
        AppMethodBeat.m2504i(53936);
        C7060h.pYm.mo8381e(14849, Integer.valueOf(10));
        AppMethodBeat.m2505o(53936);
    }
}
