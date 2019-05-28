package com.tencent.mm.memory;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class c extends a<Bitmap> {
    private static int fdw = 20971520;
    public static final c fdx = new c();

    public final /* synthetic */ Object a(Comparable comparable) {
        AppMethodBeat.i(115368);
        Bitmap f = f((Integer) comparable);
        AppMethodBeat.o(115368);
        return f;
    }

    public final /* synthetic */ void aR(Object obj) {
        AppMethodBeat.i(115362);
        f((Bitmap) obj);
        AppMethodBeat.o(115362);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    @TargetApi(19)
    public final /* synthetic */ long aS(Object obj) {
        AppMethodBeat.i(115364);
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            AppMethodBeat.o(115364);
            return 0;
        }
        int byteCount;
        if (d.fP(19)) {
            byteCount = bitmap.getByteCount();
        } else {
            byteCount = bitmap.getAllocationByteCount();
        }
        long j = (long) byteCount;
        AppMethodBeat.o(115364);
        return j;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable aT(Object obj) {
        AppMethodBeat.i(115365);
        Integer u = u((Bitmap) obj);
        AppMethodBeat.o(115365);
        return u;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable b(Comparable comparable) {
        AppMethodBeat.i(115363);
        Integer e = e((Integer) comparable);
        AppMethodBeat.o(115363);
        return e;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object d(Comparable comparable) {
        AppMethodBeat.i(115367);
        Bitmap createBitmap = Bitmap.createBitmap(1, ((Integer) comparable).intValue(), k.fdG);
        AppMethodBeat.o(115367);
        return createBitmap;
    }

    static {
        AppMethodBeat.i(115369);
        AppMethodBeat.o(115369);
    }

    private c() {
        AppMethodBeat.i(115355);
        int largeMemoryClass = ((ActivityManager) ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        ab.i("MicroMsg.BitmapPool", "BitmapPool %dMB", Integer.valueOf(largeMemoryClass));
        if (largeMemoryClass > 256) {
            fdw = 20971520;
        } else if (largeMemoryClass > 128) {
            fdw = 10485760;
        } else {
            fdw = 5242880;
        }
        Dw();
        AppMethodBeat.o(115355);
    }

    protected static Integer e(Integer num) {
        AppMethodBeat.i(115356);
        Integer valueOf = Integer.valueOf(num.intValue() * 4);
        AppMethodBeat.o(115356);
        return valueOf;
    }

    /* Access modifiers changed, original: protected|final */
    public final long WW() {
        return (long) fdw;
    }

    /* Access modifiers changed, original: protected|final */
    public final long WX() {
        return 1048576;
    }

    public final synchronized Bitmap f(Integer num) {
        Bitmap bitmap;
        AppMethodBeat.i(115357);
        bitmap = (Bitmap) super.a(num);
        if (bitmap == null || bitmap.isRecycled() || !bitmap.isMutable()) {
            bitmap = null;
            AppMethodBeat.o(115357);
        } else {
            ab.d("MicroMsg.BitmapPool", "get stored element: %s, width: %s, height: %s, size: %s, requireSize: %s", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), u(bitmap), num);
            AppMethodBeat.o(115357);
        }
        return bitmap;
    }

    private static Integer u(Bitmap bitmap) {
        AppMethodBeat.i(115358);
        Integer valueOf;
        if (bitmap == null) {
            valueOf = Integer.valueOf(0);
            AppMethodBeat.o(115358);
            return valueOf;
        }
        int byteCount;
        if (d.fP(19)) {
            byteCount = bitmap.getByteCount();
        } else {
            byteCount = bitmap.getAllocationByteCount();
        }
        valueOf = Integer.valueOf(byteCount);
        AppMethodBeat.o(115358);
        return valueOf;
    }

    public final synchronized void f(Bitmap bitmap) {
        AppMethodBeat.i(115359);
        if (!(bitmap == null || !bitmap.isMutable() || bitmap.isRecycled())) {
            ab.i("MicroMsg.BitmapPool", "release: %s", bitmap);
            super.aR(bitmap);
        }
        AppMethodBeat.o(115359);
    }

    public final void WY() {
        AppMethodBeat.i(115360);
        super.WY();
        AppMethodBeat.o(115360);
    }
}
