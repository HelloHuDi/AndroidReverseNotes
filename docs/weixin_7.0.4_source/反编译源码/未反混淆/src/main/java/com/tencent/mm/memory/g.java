package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class g extends a<byte[]> {
    public static final g fdE = new g();

    public final /* synthetic */ void aR(Object obj) {
        AppMethodBeat.i(115373);
        g((byte[]) obj);
        AppMethodBeat.o(115373);
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ long aS(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable aT(Object obj) {
        AppMethodBeat.i(115374);
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length <= 0) {
            Integer valueOf = Integer.valueOf(0);
            AppMethodBeat.o(115374);
            return valueOf;
        }
        Comparable valueOf2 = Integer.valueOf(bArr.length);
        AppMethodBeat.o(115374);
        return valueOf2;
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ Comparable b(Comparable comparable) {
        return (Integer) comparable;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ d c(Comparable comparable) {
        AppMethodBeat.i(115375);
        f fVar = new f(((Integer) comparable).intValue());
        AppMethodBeat.o(115375);
        return fVar;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object d(Comparable comparable) {
        AppMethodBeat.i(115376);
        byte[] bArr = new byte[((Integer) comparable).intValue()];
        AppMethodBeat.o(115376);
        return bArr;
    }

    static {
        AppMethodBeat.i(115377);
        AppMethodBeat.o(115377);
    }

    private g() {
    }

    public final synchronized void g(byte[] bArr) {
        AppMethodBeat.i(115372);
        Arrays.fill(bArr, (byte) 0);
        super.aR(bArr);
        AppMethodBeat.o(115372);
    }

    /* Access modifiers changed, original: protected|final */
    public final long WW() {
        return 5242880;
    }

    /* Access modifiers changed, original: protected|final */
    public final long WX() {
        return 1048576;
    }
}
