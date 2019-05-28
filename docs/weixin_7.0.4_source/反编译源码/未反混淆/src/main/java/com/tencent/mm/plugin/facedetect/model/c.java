package com.tencent.mm.plugin.facedetect.model;

import android.app.ActivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.memory.d;
import com.tencent.mm.memory.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class c extends a<byte[]> {
    private static int fXT = 0;
    public static final c lTA = new c();

    public final /* synthetic */ void aR(Object obj) {
        AppMethodBeat.i(ErrorCode.STARTDOWNLOAD_8);
        g((byte[]) obj);
        AppMethodBeat.o(ErrorCode.STARTDOWNLOAD_8);
    }

    public final /* bridge */ /* synthetic */ long aS(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    public final /* synthetic */ Comparable aT(Object obj) {
        AppMethodBeat.i(168);
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length <= 0) {
            Integer valueOf = Integer.valueOf(0);
            AppMethodBeat.o(168);
            return valueOf;
        }
        Comparable valueOf2 = Integer.valueOf(bArr.length);
        AppMethodBeat.o(168);
        return valueOf2;
    }

    public final /* bridge */ /* synthetic */ Comparable b(Comparable comparable) {
        return (Integer) comparable;
    }

    public final /* synthetic */ d c(Comparable comparable) {
        AppMethodBeat.i(169);
        f fVar = new f(((Integer) comparable).intValue());
        AppMethodBeat.o(169);
        return fVar;
    }

    static {
        AppMethodBeat.i(ErrorCode.NEEDDOWNLOAD_FALSE_1);
        AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_FALSE_1);
    }

    public static void ea(int i, int i2) {
        AppMethodBeat.i(161);
        ab.i("MicroMsg.FaceByteArrayPool", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(5));
        long yz = bo.yz();
        for (int i3 = 0; i3 < 5; i3++) {
            lTA.g(new byte[(((i * i2) * 3) / 2)]);
        }
        ab.i("MicroMsg.FaceByteArrayPool", "preloadCameraData used %sms", Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(161);
    }

    private c() {
    }

    public final synchronized void g(byte[] bArr) {
        AppMethodBeat.i(ErrorCode.STARTDOWNLOAD_3);
        super.aR(bArr);
        AppMethodBeat.o(ErrorCode.STARTDOWNLOAD_3);
    }

    public final synchronized byte[] g(Integer num) {
        byte[] bArr;
        AppMethodBeat.i(ErrorCode.STARTDOWNLOAD_4);
        bArr = (byte[]) super.d(num);
        if (bArr == null) {
            ab.v("MicroMsg.FaceByteArrayPool", "hy: getExactSize no data");
            bArr = new byte[num.intValue()];
        } else {
            ab.v("MicroMsg.FaceByteArrayPool", "hy: got exactSize data");
        }
        AppMethodBeat.o(ErrorCode.STARTDOWNLOAD_4);
        return bArr;
    }

    public final long WW() {
        AppMethodBeat.i(ErrorCode.STARTDOWNLOAD_5);
        if (fXT <= 0) {
            fXT = ((ActivityManager) ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        }
        if (fXT >= 512) {
            AppMethodBeat.o(ErrorCode.STARTDOWNLOAD_5);
            return 20971520;
        }
        AppMethodBeat.o(ErrorCode.STARTDOWNLOAD_5);
        return 10485760;
    }

    public final long WX() {
        return 20971520;
    }

    public final void WY() {
        AppMethodBeat.i(ErrorCode.STARTDOWNLOAD_6);
        super.WY();
        AppMethodBeat.o(ErrorCode.STARTDOWNLOAD_6);
    }
}
