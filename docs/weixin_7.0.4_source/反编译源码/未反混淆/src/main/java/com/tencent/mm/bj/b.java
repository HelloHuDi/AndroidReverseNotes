package com.tencent.mm.bj;

import android.app.ActivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.memory.d;
import com.tencent.mm.memory.f;
import com.tencent.mm.sdk.platformtools.ah;

public final class b extends a<byte[]> {
    public static final b fXS = new b();
    private static int fXT = 0;

    public final /* synthetic */ void aR(Object obj) {
        AppMethodBeat.i(50891);
        g((byte[]) obj);
        AppMethodBeat.o(50891);
    }

    public final /* bridge */ /* synthetic */ long aS(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    public final /* synthetic */ Comparable aT(Object obj) {
        AppMethodBeat.i(50892);
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length <= 0) {
            Integer valueOf = Integer.valueOf(0);
            AppMethodBeat.o(50892);
            return valueOf;
        }
        Comparable valueOf2 = Integer.valueOf(bArr.length);
        AppMethodBeat.o(50892);
        return valueOf2;
    }

    public final /* bridge */ /* synthetic */ Comparable b(Comparable comparable) {
        return (Integer) comparable;
    }

    public final /* synthetic */ d c(Comparable comparable) {
        AppMethodBeat.i(50893);
        f fVar = new f(((Integer) comparable).intValue());
        AppMethodBeat.o(50893);
        return fVar;
    }

    static {
        AppMethodBeat.i(50895);
        AppMethodBeat.o(50895);
    }

    private b() {
    }

    public final synchronized void g(byte[] bArr) {
        AppMethodBeat.i(50886);
        super.aR(bArr);
        AppMethodBeat.o(50886);
    }

    public final synchronized byte[] g(Integer num) {
        byte[] bArr;
        AppMethodBeat.i(50887);
        bArr = (byte[]) super.d(num);
        if (bArr == null) {
            bArr = new byte[num.intValue()];
        }
        AppMethodBeat.o(50887);
        return bArr;
    }

    public final long WW() {
        AppMethodBeat.i(50888);
        if (fXT <= 0) {
            fXT = ((ActivityManager) ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        }
        if (fXT >= 512) {
            AppMethodBeat.o(50888);
            return 41943040;
        }
        AppMethodBeat.o(50888);
        return 20971520;
    }

    public final long WX() {
        return 10485760;
    }

    public final void WY() {
        AppMethodBeat.i(50889);
        super.WY();
        AppMethodBeat.o(50889);
    }
}
