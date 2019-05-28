package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class i {
    public static Bitmap aW(byte[] bArr) {
        AppMethodBeat.i(62447);
        if (bo.cb(bArr)) {
            AppMethodBeat.o(62447);
            return null;
        }
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        long nativeInitWxAMDecoder = MMWXGFJNI.nativeInitWxAMDecoder();
        if (nativeInitWxAMDecoder == 0) {
            ab.w("MicroMsg.GIF.MMWXGFUtil", "Cpan init wxam decoder failed.");
        }
        if (MMWXGFJNI.nativeDecodeBufferHeader(nativeInitWxAMDecoder, bArr, bArr.length) != 0) {
            ab.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF decode buffer header failed. result:%d", Integer.valueOf(MMWXGFJNI.nativeDecodeBufferHeader(nativeInitWxAMDecoder, bArr, bArr.length)));
        }
        if (MMWXGFJNI.nativeGetOption(nativeInitWxAMDecoder, bArr, bArr.length, iArr) != 0) {
            ab.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF get option failed. result:%d", Integer.valueOf(MMWXGFJNI.nativeGetOption(nativeInitWxAMDecoder, bArr, bArr.length, iArr)));
        }
        int i = iArr[1];
        int i2 = iArr[2];
        if (i <= 0 || i2 <= 0) {
            AppMethodBeat.o(62447);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        MMWXGFJNI.nativeDecodeBufferFrame(nativeInitWxAMDecoder, null, 0, createBitmap, iArr2);
        MMWXGFJNI.nativeUninit(nativeInitWxAMDecoder);
        AppMethodBeat.o(62447);
        return createBitmap;
    }
}
