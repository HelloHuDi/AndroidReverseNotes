package com.tencent.p177mm.memory;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.ttpic.device.DeviceUtils;

/* renamed from: com.tencent.mm.memory.o */
public final class C9631o extends C42181e<Bitmap, C9633b> {
    public static C9631o fdT = new C9631o();

    /* renamed from: com.tencent.mm.memory.o$a */
    static class C9632a extends C42179d<Bitmap, C9633b> {
        public C9632a(C9633b c9633b) {
            super(c9633b);
        }
    }

    /* renamed from: com.tencent.mm.memory.o$b */
    public static class C9633b implements Comparable {
        private String fdU;
        public int height;
        public int width;

        public C9633b(int i, int i2) {
            AppMethodBeat.m2504i(115407);
            this.width = i;
            this.height = i2;
            this.fdU = String.format("SightBitmapSize: [%s, %s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            AppMethodBeat.m2505o(115407);
        }

        public final int compareTo(Object obj) {
            if (obj == null) {
                return 0;
            }
            if (!(obj instanceof C9633b)) {
                return 0;
            }
            if (this.width == ((C9633b) obj).width && this.height == ((C9633b) obj).height) {
                return 0;
            }
            if (this.height * this.width > ((C9633b) obj).width * ((C9633b) obj).height) {
                return 1;
            }
            return -1;
        }

        public final String toString() {
            return this.fdU;
        }
    }

    /* renamed from: aR */
    public final /* synthetic */ void mo20957aR(Object obj) {
        AppMethodBeat.m2504i(115411);
        mo20963f((Bitmap) obj);
        AppMethodBeat.m2505o(115411);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: aS */
    public final /* synthetic */ long mo20958aS(Object obj) {
        AppMethodBeat.m2504i(115412);
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            AppMethodBeat.m2505o(115412);
            return 0;
        }
        int byteCount;
        if (C1443d.m3067fP(19)) {
            byteCount = bitmap.getByteCount();
        } else {
            byteCount = bitmap.getAllocationByteCount();
        }
        long j = (long) byteCount;
        AppMethodBeat.m2505o(115412);
        return j;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: aT */
    public final /* synthetic */ Comparable mo20959aT(Object obj) {
        AppMethodBeat.m2504i(115413);
        Bitmap bitmap = (Bitmap) obj;
        C9633b c9633b = new C9633b(bitmap.getWidth(), bitmap.getHeight());
        AppMethodBeat.m2505o(115413);
        return c9633b;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: c */
    public final /* synthetic */ C42179d mo20961c(Comparable comparable) {
        AppMethodBeat.m2504i(115414);
        C9632a c9632a = new C9632a((C9633b) comparable);
        AppMethodBeat.m2505o(115414);
        return c9632a;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: d */
    public final /* synthetic */ Object mo20962d(Comparable comparable) {
        AppMethodBeat.m2504i(115415);
        Bitmap b = C9631o.m17153b((C9633b) comparable);
        AppMethodBeat.m2505o(115415);
        return b;
    }

    static {
        AppMethodBeat.m2504i(115417);
        AppMethodBeat.m2505o(115417);
    }

    private C9631o() {
    }

    /* renamed from: a */
    public final synchronized Bitmap mo20955a(C9633b c9633b) {
        Bitmap bitmap;
        AppMethodBeat.m2504i(115408);
        bitmap = (Bitmap) super.mo20956a((Comparable) c9633b);
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = C9631o.m17153b(c9633b);
        }
        AppMethodBeat.m2505o(115408);
        return bitmap;
    }

    /* renamed from: f */
    public final synchronized void mo20963f(Bitmap bitmap) {
        AppMethodBeat.m2504i(115409);
        if (!(bitmap == null || bitmap.isRecycled())) {
            super.mo20957aR(bitmap);
        }
        AppMethodBeat.m2505o(115409);
    }

    /* renamed from: b */
    private static Bitmap m17153b(C9633b c9633b) {
        AppMethodBeat.m2504i(115410);
        Bitmap createBitmap = Bitmap.createBitmap(c9633b.width, c9633b.height, C45433k.fdG);
        AppMethodBeat.m2505o(115410);
        return createBitmap;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: WW */
    public final long mo20953WW() {
        return 1228800;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: WX */
    public final long mo20954WX() {
        return DeviceUtils.LOW_END_SCREEN_SIZE;
    }
}
