package com.tencent.p177mm.plugin.facedetect.model;

import android.app.ActivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C18601a;
import com.tencent.p177mm.memory.C18604f;
import com.tencent.p177mm.memory.C42179d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.facedetect.model.c */
public final class C27931c extends C18601a<byte[]> {
    private static int fXT = 0;
    public static final C27931c lTA = new C27931c();

    /* renamed from: aR */
    public final /* synthetic */ void mo20957aR(Object obj) {
        AppMethodBeat.m2504i(ErrorCode.STARTDOWNLOAD_8);
        mo45831g((byte[]) obj);
        AppMethodBeat.m2505o(ErrorCode.STARTDOWNLOAD_8);
    }

    /* renamed from: aS */
    public final /* bridge */ /* synthetic */ long mo20958aS(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    /* renamed from: aT */
    public final /* synthetic */ Comparable mo20959aT(Object obj) {
        AppMethodBeat.m2504i(168);
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length <= 0) {
            Integer valueOf = Integer.valueOf(0);
            AppMethodBeat.m2505o(168);
            return valueOf;
        }
        Comparable valueOf2 = Integer.valueOf(bArr.length);
        AppMethodBeat.m2505o(168);
        return valueOf2;
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ Comparable mo20960b(Comparable comparable) {
        return (Integer) comparable;
    }

    /* renamed from: c */
    public final /* synthetic */ C42179d mo20961c(Comparable comparable) {
        AppMethodBeat.m2504i(169);
        C18604f c18604f = new C18604f(((Integer) comparable).intValue());
        AppMethodBeat.m2505o(169);
        return c18604f;
    }

    static {
        AppMethodBeat.m2504i(ErrorCode.NEEDDOWNLOAD_FALSE_1);
        AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_FALSE_1);
    }

    /* renamed from: ea */
    public static void m44448ea(int i, int i2) {
        AppMethodBeat.m2504i(161);
        C4990ab.m7417i("MicroMsg.FaceByteArrayPool", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(5));
        long yz = C5046bo.m7588yz();
        for (int i3 = 0; i3 < 5; i3++) {
            lTA.mo45831g(new byte[(((i * i2) * 3) / 2)]);
        }
        C4990ab.m7417i("MicroMsg.FaceByteArrayPool", "preloadCameraData used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(161);
    }

    private C27931c() {
    }

    /* renamed from: g */
    public final synchronized void mo45831g(byte[] bArr) {
        AppMethodBeat.m2504i(ErrorCode.STARTDOWNLOAD_3);
        super.mo20957aR(bArr);
        AppMethodBeat.m2505o(ErrorCode.STARTDOWNLOAD_3);
    }

    /* renamed from: g */
    public final synchronized byte[] mo45832g(Integer num) {
        byte[] bArr;
        AppMethodBeat.m2504i(ErrorCode.STARTDOWNLOAD_4);
        bArr = (byte[]) super.mo33852d(num);
        if (bArr == null) {
            C4990ab.m7418v("MicroMsg.FaceByteArrayPool", "hy: getExactSize no data");
            bArr = new byte[num.intValue()];
        } else {
            C4990ab.m7418v("MicroMsg.FaceByteArrayPool", "hy: got exactSize data");
        }
        AppMethodBeat.m2505o(ErrorCode.STARTDOWNLOAD_4);
        return bArr;
    }

    /* renamed from: WW */
    public final long mo20953WW() {
        AppMethodBeat.m2504i(ErrorCode.STARTDOWNLOAD_5);
        if (fXT <= 0) {
            fXT = ((ActivityManager) C4996ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        }
        if (fXT >= 512) {
            AppMethodBeat.m2505o(ErrorCode.STARTDOWNLOAD_5);
            return 20971520;
        }
        AppMethodBeat.m2505o(ErrorCode.STARTDOWNLOAD_5);
        return 10485760;
    }

    /* renamed from: WX */
    public final long mo20954WX() {
        return 20971520;
    }

    /* renamed from: WY */
    public final void mo45830WY() {
        AppMethodBeat.m2504i(ErrorCode.STARTDOWNLOAD_6);
        super.mo45830WY();
        AppMethodBeat.m2505o(ErrorCode.STARTDOWNLOAD_6);
    }
}
