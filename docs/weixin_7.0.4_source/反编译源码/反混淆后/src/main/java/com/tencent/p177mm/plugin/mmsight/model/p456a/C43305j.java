package com.tencent.p177mm.plugin.mmsight.model.p456a;

import android.app.ActivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C18601a;
import com.tencent.p177mm.memory.C18604f;
import com.tencent.p177mm.memory.C42179d;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.mmsight.model.a.j */
public final class C43305j extends C18601a<byte[]> {
    private static int fXT = 0;
    public static final C43305j owk = new C43305j();

    /* renamed from: aR */
    public final /* synthetic */ void mo20957aR(Object obj) {
        AppMethodBeat.m2504i(60321);
        mo68845g((byte[]) obj);
        AppMethodBeat.m2505o(60321);
    }

    /* renamed from: aS */
    public final /* bridge */ /* synthetic */ long mo20958aS(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    /* renamed from: aT */
    public final /* synthetic */ Comparable mo20959aT(Object obj) {
        AppMethodBeat.m2504i(60322);
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length <= 0) {
            Integer valueOf = Integer.valueOf(0);
            AppMethodBeat.m2505o(60322);
            return valueOf;
        }
        Comparable valueOf2 = Integer.valueOf(bArr.length);
        AppMethodBeat.m2505o(60322);
        return valueOf2;
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ Comparable mo20960b(Comparable comparable) {
        return (Integer) comparable;
    }

    /* renamed from: c */
    public final /* synthetic */ C42179d mo20961c(Comparable comparable) {
        AppMethodBeat.m2504i(60323);
        C18604f c18604f = new C18604f(((Integer) comparable).intValue());
        AppMethodBeat.m2505o(60323);
        return c18604f;
    }

    static {
        AppMethodBeat.m2504i(60325);
        AppMethodBeat.m2505o(60325);
    }

    private C43305j() {
    }

    /* renamed from: g */
    public final synchronized void mo68845g(byte[] bArr) {
        AppMethodBeat.m2504i(60316);
        super.mo20957aR(bArr);
        AppMethodBeat.m2505o(60316);
    }

    /* renamed from: g */
    public final synchronized byte[] mo68846g(Integer num) {
        byte[] bArr;
        AppMethodBeat.m2504i(60317);
        bArr = (byte[]) super.mo33852d(num);
        if (bArr == null) {
            bArr = new byte[num.intValue()];
        }
        AppMethodBeat.m2505o(60317);
        return bArr;
    }

    /* renamed from: WW */
    public final long mo20953WW() {
        AppMethodBeat.m2504i(60318);
        if (fXT <= 0) {
            fXT = ((ActivityManager) C4996ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        }
        if (fXT >= 512) {
            AppMethodBeat.m2505o(60318);
            return 41943040;
        }
        AppMethodBeat.m2505o(60318);
        return 20971520;
    }

    /* renamed from: WX */
    public final long mo20954WX() {
        return 10485760;
    }

    /* renamed from: WY */
    public final void mo45830WY() {
        AppMethodBeat.m2504i(60319);
        super.mo45830WY();
        AppMethodBeat.m2505o(60319);
    }
}
