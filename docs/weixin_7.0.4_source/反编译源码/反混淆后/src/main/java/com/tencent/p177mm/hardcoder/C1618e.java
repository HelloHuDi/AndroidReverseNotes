package com.tencent.p177mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1607a.C1605b;

/* renamed from: com.tencent.mm.hardcoder.e */
public final class C1618e {
    private static C1617a eEy = null;

    /* renamed from: com.tencent.mm.hardcoder.e$a */
    public interface C1617a {
        /* renamed from: a */
        void mo5073a(int[] iArr, int i, int i2, int i3, int i4, long j, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10, int i11, long j2, int[] iArr3, int[] iArr4);
    }

    /* renamed from: a */
    public static void m3277a(C1617a c1617a) {
        AppMethodBeat.m2504i(93931);
        if (eEy == null) {
            C1611c.m3271i("HardCoder.HardCoderReporter", String.format("hardcoder setReporter[%s]", new Object[]{c1617a}));
            eEy = c1617a;
        }
        AppMethodBeat.m2505o(93931);
    }

    /* renamed from: a */
    public static void m3276a(C1605b c1605b) {
        int i;
        AppMethodBeat.m2504i(93932);
        int i2 = (int) (c1605b.eDE - c1605b.eDK);
        int i3 = HardCoderJNI.isHcEnable() ? 1 : 0;
        int isRunning = HardCoderJNI.isRunning();
        int i4 = i2 - c1605b.delay <= 0 ? 1 : 0;
        int i5 = c1605b.scene;
        long j = c1605b.eDJ;
        int i6 = c1605b.eDF;
        int i7 = c1605b.eDH;
        int[] iArr = c1605b.eDR;
        int i8 = (int) (c1605b.eDL - c1605b.startTime);
        int i9 = c1605b.eDV;
        int i10 = 0;
        if (c1605b.eDX != null) {
            i10 = (int) (0 + c1605b.eDX.eEF);
        }
        if (c1605b.eDY != null) {
            i = (int) (((long) i10) + c1605b.eDY.eEF);
        } else {
            i = i10;
        }
        int i11 = HardCoderJNI.tickRate;
        long j2 = c1605b.eDW;
        int[] iArr2 = c1605b.eDP;
        int[] iArr3 = c1605b.eDQ;
        StringBuilder stringBuilder = new StringBuilder();
        if (iArr != null) {
            for (int i12 : iArr) {
                stringBuilder.append(i12 + "#");
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (iArr2 != null) {
            for (int i13 : iArr2) {
                stringBuilder2.append(i13 + "#");
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        if (iArr3 != null) {
            for (int i14 : iArr3) {
                stringBuilder3.append(i14 + "#");
            }
        }
        C1611c.m3269d("HardCoder.HardCoderReporter", String.format("[oneliang]performance report,hash:%s,threadId:%s,enable:%s, engineStatus:%s,cancelInDelay:%s,scene:%s,action:%s,lastCpuLevel:%s,cpuLevel:%s,lastIoLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[]{Integer.valueOf(c1605b.hashCode()), c1605b.mo5056PE(), Integer.valueOf(i3), Integer.valueOf(isRunning), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j), Integer.valueOf(c1605b.eDN), Integer.valueOf(i6), Integer.valueOf(c1605b.eDO), Integer.valueOf(i7), stringBuilder.toString(), Integer.valueOf(i8), Integer.valueOf(i2), Integer.valueOf(i9), Integer.valueOf(i), Integer.valueOf(i11), Long.valueOf(j2), stringBuilder2.toString(), stringBuilder3.toString()}));
        if (eEy != null) {
            eEy.mo5073a(c1605b.eDI, i3, isRunning, i4, i5, j, i6, i7, iArr, i8, i2, i9, i, i11, j2, iArr2, iArr3);
        }
        AppMethodBeat.m2505o(93932);
    }
}
