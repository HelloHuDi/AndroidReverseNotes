package com.tencent.mm.memory;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.ttpic.device.DeviceUtils;

public final class o extends e<Bitmap, b> {
    public static o fdT = new o();

    static class a extends d<Bitmap, b> {
        public a(b bVar) {
            super(bVar);
        }
    }

    public static class b implements Comparable {
        private String fdU;
        public int height;
        public int width;

        public b(int i, int i2) {
            AppMethodBeat.i(115407);
            this.width = i;
            this.height = i2;
            this.fdU = String.format("SightBitmapSize: [%s, %s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            AppMethodBeat.o(115407);
        }

        public final int compareTo(Object obj) {
            if (obj == null) {
                return 0;
            }
            if (!(obj instanceof b)) {
                return 0;
            }
            if (this.width == ((b) obj).width && this.height == ((b) obj).height) {
                return 0;
            }
            if (this.height * this.width > ((b) obj).width * ((b) obj).height) {
                return 1;
            }
            return -1;
        }

        public final String toString() {
            return this.fdU;
        }
    }

    public final /* synthetic */ void aR(Object obj) {
        AppMethodBeat.i(115411);
        f((Bitmap) obj);
        AppMethodBeat.o(115411);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ long aS(Object obj) {
        AppMethodBeat.i(115412);
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            AppMethodBeat.o(115412);
            return 0;
        }
        int byteCount;
        if (d.fP(19)) {
            byteCount = bitmap.getByteCount();
        } else {
            byteCount = bitmap.getAllocationByteCount();
        }
        long j = (long) byteCount;
        AppMethodBeat.o(115412);
        return j;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable aT(Object obj) {
        AppMethodBeat.i(115413);
        Bitmap bitmap = (Bitmap) obj;
        b bVar = new b(bitmap.getWidth(), bitmap.getHeight());
        AppMethodBeat.o(115413);
        return bVar;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ d c(Comparable comparable) {
        AppMethodBeat.i(115414);
        a aVar = new a((b) comparable);
        AppMethodBeat.o(115414);
        return aVar;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object d(Comparable comparable) {
        AppMethodBeat.i(115415);
        Bitmap b = b((b) comparable);
        AppMethodBeat.o(115415);
        return b;
    }

    static {
        AppMethodBeat.i(115417);
        AppMethodBeat.o(115417);
    }

    private o() {
    }

    public final synchronized Bitmap a(b bVar) {
        Bitmap bitmap;
        AppMethodBeat.i(115408);
        bitmap = (Bitmap) super.a((Comparable) bVar);
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = b(bVar);
        }
        AppMethodBeat.o(115408);
        return bitmap;
    }

    public final synchronized void f(Bitmap bitmap) {
        AppMethodBeat.i(115409);
        if (!(bitmap == null || bitmap.isRecycled())) {
            super.aR(bitmap);
        }
        AppMethodBeat.o(115409);
    }

    private static Bitmap b(b bVar) {
        AppMethodBeat.i(115410);
        Bitmap createBitmap = Bitmap.createBitmap(bVar.width, bVar.height, k.fdG);
        AppMethodBeat.o(115410);
        return createBitmap;
    }

    /* Access modifiers changed, original: protected|final */
    public final long WW() {
        return 1228800;
    }

    /* Access modifiers changed, original: protected|final */
    public final long WX() {
        return DeviceUtils.LOW_END_SCREEN_SIZE;
    }
}
