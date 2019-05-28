package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.a.b;

public final class e {
    private static a eEy = null;

    public interface a {
        void a(int[] iArr, int i, int i2, int i3, int i4, long j, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10, int i11, long j2, int[] iArr3, int[] iArr4);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(93931);
        if (eEy == null) {
            c.i("HardCoder.HardCoderReporter", String.format("hardcoder setReporter[%s]", new Object[]{aVar}));
            eEy = aVar;
        }
        AppMethodBeat.o(93931);
    }

    public static void a(b bVar) {
        int i;
        AppMethodBeat.i(93932);
        int i2 = (int) (bVar.eDE - bVar.eDK);
        int i3 = HardCoderJNI.isHcEnable() ? 1 : 0;
        int isRunning = HardCoderJNI.isRunning();
        int i4 = i2 - bVar.delay <= 0 ? 1 : 0;
        int i5 = bVar.scene;
        long j = bVar.eDJ;
        int i6 = bVar.eDF;
        int i7 = bVar.eDH;
        int[] iArr = bVar.eDR;
        int i8 = (int) (bVar.eDL - bVar.startTime);
        int i9 = bVar.eDV;
        int i10 = 0;
        if (bVar.eDX != null) {
            i10 = (int) (0 + bVar.eDX.eEF);
        }
        if (bVar.eDY != null) {
            i = (int) (((long) i10) + bVar.eDY.eEF);
        } else {
            i = i10;
        }
        int i11 = HardCoderJNI.tickRate;
        long j2 = bVar.eDW;
        int[] iArr2 = bVar.eDP;
        int[] iArr3 = bVar.eDQ;
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
        c.d("HardCoder.HardCoderReporter", String.format("[oneliang]performance report,hash:%s,threadId:%s,enable:%s, engineStatus:%s,cancelInDelay:%s,scene:%s,action:%s,lastCpuLevel:%s,cpuLevel:%s,lastIoLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[]{Integer.valueOf(bVar.hashCode()), bVar.PE(), Integer.valueOf(i3), Integer.valueOf(isRunning), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j), Integer.valueOf(bVar.eDN), Integer.valueOf(i6), Integer.valueOf(bVar.eDO), Integer.valueOf(i7), stringBuilder.toString(), Integer.valueOf(i8), Integer.valueOf(i2), Integer.valueOf(i9), Integer.valueOf(i), Integer.valueOf(i11), Long.valueOf(j2), stringBuilder2.toString(), stringBuilder3.toString()}));
        if (eEy != null) {
            eEy.a(bVar.eDI, i3, isRunning, i4, i5, j, i6, i7, iArr, i8, i2, i9, i, i11, j2, iArr2, iArr3);
        }
        AppMethodBeat.o(93932);
    }
}
