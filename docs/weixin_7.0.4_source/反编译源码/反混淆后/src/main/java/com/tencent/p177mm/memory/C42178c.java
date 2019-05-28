package com.tencent.p177mm.memory;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.memory.c */
public final class C42178c extends C18601a<Bitmap> {
    private static int fdw = 20971520;
    public static final C42178c fdx = new C42178c();

    /* renamed from: a */
    public final /* synthetic */ Object mo20956a(Comparable comparable) {
        AppMethodBeat.m2504i(115368);
        Bitmap f = mo67723f((Integer) comparable);
        AppMethodBeat.m2505o(115368);
        return f;
    }

    /* renamed from: aR */
    public final /* synthetic */ void mo20957aR(Object obj) {
        AppMethodBeat.m2504i(115362);
        mo67724f((Bitmap) obj);
        AppMethodBeat.m2505o(115362);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    @TargetApi(19)
    /* renamed from: aS */
    public final /* synthetic */ long mo20958aS(Object obj) {
        AppMethodBeat.m2504i(115364);
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            AppMethodBeat.m2505o(115364);
            return 0;
        }
        int byteCount;
        if (C1443d.m3067fP(19)) {
            byteCount = bitmap.getByteCount();
        } else {
            byteCount = bitmap.getAllocationByteCount();
        }
        long j = (long) byteCount;
        AppMethodBeat.m2505o(115364);
        return j;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: aT */
    public final /* synthetic */ Comparable mo20959aT(Object obj) {
        AppMethodBeat.m2504i(115365);
        Integer u = C42178c.m74379u((Bitmap) obj);
        AppMethodBeat.m2505o(115365);
        return u;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: b */
    public final /* synthetic */ Comparable mo20960b(Comparable comparable) {
        AppMethodBeat.m2504i(115363);
        Integer e = C42178c.m74378e((Integer) comparable);
        AppMethodBeat.m2505o(115363);
        return e;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: d */
    public final /* synthetic */ Object mo20962d(Comparable comparable) {
        AppMethodBeat.m2504i(115367);
        Bitmap createBitmap = Bitmap.createBitmap(1, ((Integer) comparable).intValue(), C45433k.fdG);
        AppMethodBeat.m2505o(115367);
        return createBitmap;
    }

    static {
        AppMethodBeat.m2504i(115369);
        AppMethodBeat.m2505o(115369);
    }

    private C42178c() {
        AppMethodBeat.m2504i(115355);
        int largeMemoryClass = ((ActivityManager) C4996ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        C4990ab.m7417i("MicroMsg.BitmapPool", "BitmapPool %dMB", Integer.valueOf(largeMemoryClass));
        if (largeMemoryClass > 256) {
            fdw = 20971520;
        } else if (largeMemoryClass > 128) {
            fdw = 10485760;
        } else {
            fdw = 5242880;
        }
        mo67729Dw();
        AppMethodBeat.m2505o(115355);
    }

    /* renamed from: e */
    protected static Integer m74378e(Integer num) {
        AppMethodBeat.m2504i(115356);
        Integer valueOf = Integer.valueOf(num.intValue() * 4);
        AppMethodBeat.m2505o(115356);
        return valueOf;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: WW */
    public final long mo20953WW() {
        return (long) fdw;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: WX */
    public final long mo20954WX() {
        return 1048576;
    }

    /* renamed from: f */
    public final synchronized Bitmap mo67723f(Integer num) {
        Bitmap bitmap;
        AppMethodBeat.m2504i(115357);
        bitmap = (Bitmap) super.mo20956a(num);
        if (bitmap == null || bitmap.isRecycled() || !bitmap.isMutable()) {
            bitmap = null;
            AppMethodBeat.m2505o(115357);
        } else {
            C4990ab.m7411d("MicroMsg.BitmapPool", "get stored element: %s, width: %s, height: %s, size: %s, requireSize: %s", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), C42178c.m74379u(bitmap), num);
            AppMethodBeat.m2505o(115357);
        }
        return bitmap;
    }

    /* renamed from: u */
    private static Integer m74379u(Bitmap bitmap) {
        AppMethodBeat.m2504i(115358);
        Integer valueOf;
        if (bitmap == null) {
            valueOf = Integer.valueOf(0);
            AppMethodBeat.m2505o(115358);
            return valueOf;
        }
        int byteCount;
        if (C1443d.m3067fP(19)) {
            byteCount = bitmap.getByteCount();
        } else {
            byteCount = bitmap.getAllocationByteCount();
        }
        valueOf = Integer.valueOf(byteCount);
        AppMethodBeat.m2505o(115358);
        return valueOf;
    }

    /* renamed from: f */
    public final synchronized void mo67724f(Bitmap bitmap) {
        AppMethodBeat.m2504i(115359);
        if (!(bitmap == null || !bitmap.isMutable() || bitmap.isRecycled())) {
            C4990ab.m7417i("MicroMsg.BitmapPool", "release: %s", bitmap);
            super.mo20957aR(bitmap);
        }
        AppMethodBeat.m2505o(115359);
    }

    /* renamed from: WY */
    public final void mo45830WY() {
        AppMethodBeat.m2504i(115360);
        super.mo45830WY();
        AppMethodBeat.m2505o(115360);
    }
}
