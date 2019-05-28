package com.tencent.p177mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.tencent.mm.memory.g */
public final class C32771g extends C18601a<byte[]> {
    public static final C32771g fdE = new C32771g();

    /* renamed from: aR */
    public final /* synthetic */ void mo20957aR(Object obj) {
        AppMethodBeat.m2504i(115373);
        mo53316g((byte[]) obj);
        AppMethodBeat.m2505o(115373);
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    /* renamed from: aS */
    public final /* bridge */ /* synthetic */ long mo20958aS(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: aT */
    public final /* synthetic */ Comparable mo20959aT(Object obj) {
        AppMethodBeat.m2504i(115374);
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length <= 0) {
            Integer valueOf = Integer.valueOf(0);
            AppMethodBeat.m2505o(115374);
            return valueOf;
        }
        Comparable valueOf2 = Integer.valueOf(bArr.length);
        AppMethodBeat.m2505o(115374);
        return valueOf2;
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ Comparable mo20960b(Comparable comparable) {
        return (Integer) comparable;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: c */
    public final /* synthetic */ C42179d mo20961c(Comparable comparable) {
        AppMethodBeat.m2504i(115375);
        C18604f c18604f = new C18604f(((Integer) comparable).intValue());
        AppMethodBeat.m2505o(115375);
        return c18604f;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: d */
    public final /* synthetic */ Object mo20962d(Comparable comparable) {
        AppMethodBeat.m2504i(115376);
        byte[] bArr = new byte[((Integer) comparable).intValue()];
        AppMethodBeat.m2505o(115376);
        return bArr;
    }

    static {
        AppMethodBeat.m2504i(115377);
        AppMethodBeat.m2505o(115377);
    }

    private C32771g() {
    }

    /* renamed from: g */
    public final synchronized void mo53316g(byte[] bArr) {
        AppMethodBeat.m2504i(115372);
        Arrays.fill(bArr, (byte) 0);
        super.mo20957aR(bArr);
        AppMethodBeat.m2505o(115372);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: WW */
    public final long mo20953WW() {
        return 5242880;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: WX */
    public final long mo20954WX() {
        return 1048576;
    }
}
