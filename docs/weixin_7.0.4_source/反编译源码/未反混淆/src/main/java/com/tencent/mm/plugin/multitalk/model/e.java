package com.tencent.mm.plugin.multitalk.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class e {
    public static int oFV = 0;
    public static int oFW = 0;
    public static int oFX = 0;
    public static int oFY = 0;
    public static int oFZ = 0;

    public static final void a(boolean z, long j, String str) {
        int i;
        AppMethodBeat.i(53911);
        ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectSuccess %b %d %s", Boolean.valueOf(z), Long.valueOf(j), str);
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        h.pYm.e(12725, Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(j), str);
        AppMethodBeat.o(53911);
    }

    public static final void a(boolean z, long j, String str, int i) {
        int i2;
        AppMethodBeat.i(53912);
        ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectFail %b %d %s %d", Boolean.valueOf(z), Long.valueOf(j), str, Integer.valueOf(i));
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        h.pYm.e(12725, Integer.valueOf(2), Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i));
        AppMethodBeat.o(53912);
    }

    public static final void bRr() {
        AppMethodBeat.i(53913);
        ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailSuccess");
        h.pYm.e(12722, Integer.valueOf(1));
        AppMethodBeat.o(53913);
    }

    public static final void bRs() {
        AppMethodBeat.i(53914);
        ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailFail");
        h.pYm.e(12722, Integer.valueOf(2));
        AppMethodBeat.o(53914);
    }

    public static final void aR(int i, String str) {
        AppMethodBeat.i(53915);
        ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkReceiveCall %d %s", Integer.valueOf(i), str);
        h.pYm.e(12723, Integer.valueOf(i), str);
        AppMethodBeat.o(53915);
    }

    public static final void q(long j, String str) {
        AppMethodBeat.i(53916);
        ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMutliTalkDuration %d %s", Long.valueOf(j), str);
        h.pYm.e(12726, Long.valueOf(j), str);
        AppMethodBeat.o(53916);
    }

    public static final void a(int i, boolean z, int i2, String str, int i3) {
        int i4;
        AppMethodBeat.i(53917);
        ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkSelectContact %d %b %d %s %d", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3));
        if (z) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        h.pYm.e(12727, Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(i3));
        AppMethodBeat.o(53917);
    }

    public static final void r(long j, String str) {
        AppMethodBeat.i(53918);
        long j2 = j > 1000 ? j / 1000 : 1;
        ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkVideoDuration %d %s", Long.valueOf(j2), str);
        h.pYm.e(12728, Long.valueOf(j2), str);
        AppMethodBeat.o(53918);
    }

    public static final void Sh(String str) {
        AppMethodBeat.i(53919);
        ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkFunction %s %d %d %d %d %d", str, Integer.valueOf(oFV), Integer.valueOf(oFW), Integer.valueOf(oFX), Integer.valueOf(oFY), Integer.valueOf(oFZ));
        h.pYm.e(12729, str, Integer.valueOf(oFV), Integer.valueOf(oFW), Integer.valueOf(oFX), Integer.valueOf(oFY), Integer.valueOf(oFZ));
        eC(9, oFV);
        eC(10, oFZ);
        eC(11, oFW);
        eC(12, oFX);
        eC(13, oFY);
        oFV = 0;
        oFW = 0;
        oFX = 0;
        oFY = 0;
        oFZ = 0;
        AppMethodBeat.o(53919);
    }

    public static final void f(String str, boolean z, boolean z2) {
        AppMethodBeat.i(53920);
        if (z && z2) {
            h.pYm.e(12917, str, Integer.valueOf(2), Integer.valueOf(1));
            AppMethodBeat.o(53920);
        } else if (z) {
            h.pYm.e(12917, str, Integer.valueOf(2), Integer.valueOf(2));
            AppMethodBeat.o(53920);
        } else if (z2) {
            h.pYm.e(12917, str, Integer.valueOf(1), Integer.valueOf(1));
            AppMethodBeat.o(53920);
        } else {
            h.pYm.e(12917, str, Integer.valueOf(1), Integer.valueOf(2));
            AppMethodBeat.o(53920);
        }
    }

    public static final void bRt() {
        AppMethodBeat.i(53921);
        h.pYm.a(220, 0, 1, false);
        AppMethodBeat.o(53921);
    }

    public static final void jl(boolean z) {
        AppMethodBeat.i(53922);
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
        h.pYm.b(arrayList, false);
        AppMethodBeat.o(53922);
    }

    public static final void bRu() {
        AppMethodBeat.i(53923);
        h.pYm.a(220, 1, 1, false);
        AppMethodBeat.o(53923);
    }

    public static final void jm(boolean z) {
        AppMethodBeat.i(53924);
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
        h.pYm.b(arrayList, false);
        AppMethodBeat.o(53924);
    }

    public static final void zd(int i) {
        AppMethodBeat.i(53925);
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
        h.pYm.b(arrayList, false);
        AppMethodBeat.o(53925);
    }

    private static void eC(int i, int i2) {
        AppMethodBeat.i(53926);
        h.pYm.a(220, (long) i, (long) i2, false);
        AppMethodBeat.o(53926);
    }

    public static final void bRv() {
        AppMethodBeat.i(53927);
        h.pYm.e(14849, Integer.valueOf(1));
        AppMethodBeat.o(53927);
    }

    public static final void bRw() {
        AppMethodBeat.i(53928);
        h.pYm.e(14849, Integer.valueOf(2));
        AppMethodBeat.o(53928);
    }

    public static final void bRx() {
        AppMethodBeat.i(53929);
        h.pYm.e(14849, Integer.valueOf(3));
        AppMethodBeat.o(53929);
    }

    public static final void bRy() {
        AppMethodBeat.i(53930);
        h.pYm.e(14849, Integer.valueOf(4));
        AppMethodBeat.o(53930);
    }

    public static final void bRz() {
        AppMethodBeat.i(53931);
        h.pYm.e(14849, Integer.valueOf(5));
        AppMethodBeat.o(53931);
    }

    public static final void bRA() {
        AppMethodBeat.i(53932);
        h.pYm.e(14849, Integer.valueOf(6));
        AppMethodBeat.o(53932);
    }

    public static final void bRB() {
        AppMethodBeat.i(53933);
        h.pYm.e(14849, Integer.valueOf(7));
        AppMethodBeat.o(53933);
    }

    public static final void bRC() {
        AppMethodBeat.i(53934);
        h.pYm.e(14849, Integer.valueOf(8));
        AppMethodBeat.o(53934);
    }

    public static final void bRD() {
        AppMethodBeat.i(53935);
        h.pYm.e(14849, Integer.valueOf(9));
        AppMethodBeat.o(53935);
    }

    public static final void bRE() {
        AppMethodBeat.i(53936);
        h.pYm.e(14849, Integer.valueOf(10));
        AppMethodBeat.o(53936);
    }
}
