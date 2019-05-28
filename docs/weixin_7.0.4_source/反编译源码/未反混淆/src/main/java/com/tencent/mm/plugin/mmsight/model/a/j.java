package com.tencent.mm.plugin.mmsight.model.a;

import android.app.ActivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.memory.d;
import com.tencent.mm.memory.f;
import com.tencent.mm.sdk.platformtools.ah;

public final class j extends a<byte[]> {
    private static int fXT = 0;
    public static final j owk = new j();

    public final /* synthetic */ void aR(Object obj) {
        AppMethodBeat.i(60321);
        g((byte[]) obj);
        AppMethodBeat.o(60321);
    }

    public final /* bridge */ /* synthetic */ long aS(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    public final /* synthetic */ Comparable aT(Object obj) {
        AppMethodBeat.i(60322);
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length <= 0) {
            Integer valueOf = Integer.valueOf(0);
            AppMethodBeat.o(60322);
            return valueOf;
        }
        Comparable valueOf2 = Integer.valueOf(bArr.length);
        AppMethodBeat.o(60322);
        return valueOf2;
    }

    public final /* bridge */ /* synthetic */ Comparable b(Comparable comparable) {
        return (Integer) comparable;
    }

    public final /* synthetic */ d c(Comparable comparable) {
        AppMethodBeat.i(60323);
        f fVar = new f(((Integer) comparable).intValue());
        AppMethodBeat.o(60323);
        return fVar;
    }

    static {
        AppMethodBeat.i(60325);
        AppMethodBeat.o(60325);
    }

    private j() {
    }

    public final synchronized void g(byte[] bArr) {
        AppMethodBeat.i(60316);
        super.aR(bArr);
        AppMethodBeat.o(60316);
    }

    public final synchronized byte[] g(Integer num) {
        byte[] bArr;
        AppMethodBeat.i(60317);
        bArr = (byte[]) super.d(num);
        if (bArr == null) {
            bArr = new byte[num.intValue()];
        }
        AppMethodBeat.o(60317);
        return bArr;
    }

    public final long WW() {
        AppMethodBeat.i(60318);
        if (fXT <= 0) {
            fXT = ((ActivityManager) ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        }
        if (fXT >= 512) {
            AppMethodBeat.o(60318);
            return 41943040;
        }
        AppMethodBeat.o(60318);
        return 20971520;
    }

    public final long WX() {
        return 10485760;
    }

    public final void WY() {
        AppMethodBeat.i(60319);
        super.WY();
        AppMethodBeat.o(60319);
    }
}
