package com.tencent.mm.plugin.appbrand.luggage.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.d;
import junit.framework.Assert;

public final class b implements f {
    private int iJ;
    private int iK;
    private int mHeight;
    private int mWidth;

    public b(int i, int i2, int i3, int i4) {
        boolean z = true;
        AppMethodBeat.i(86979);
        Assert.assertFalse(i3 == 0);
        if (i4 != 0) {
            z = false;
        }
        Assert.assertFalse(z);
        this.iJ = i;
        this.iK = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        AppMethodBeat.o(86979);
    }

    public final Bitmap y(Bitmap bitmap) {
        AppMethodBeat.i(86980);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(86980);
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = this.iJ;
        int i2 = this.iK;
        if (this.iJ < 0) {
            i = 0;
        } else if (this.iJ > width) {
            i = width;
        }
        if (this.iK < 0) {
            i2 = 0;
        } else if (this.iK > height) {
            i2 = height;
        }
        int i3 = (this.mWidth + this.iJ) - i;
        int i4 = (this.mHeight + this.iK) - i2;
        if (i + i3 > width) {
            i3 = width - i;
        }
        if (i2 + i4 > height) {
            height -= i2;
        } else {
            height = i4;
        }
        if (i3 <= 0 || height <= 0) {
            bitmap = d.createBitmap(1, 1, Config.ARGB_8888);
            AppMethodBeat.o(86980);
            return bitmap;
        }
        Bitmap createBitmap = d.createBitmap(i3, height, Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, new Rect(i, i2, i + i3, i2 + height), new Rect(0, 0, i3, height), null);
        AppMethodBeat.o(86980);
        return createBitmap;
    }

    public final String wP() {
        AppMethodBeat.i(86981);
        String format = String.format("Transformation_x%s_y%s_w%s_h%s", new Object[]{Integer.valueOf(this.iJ), Integer.valueOf(this.iK), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)});
        AppMethodBeat.o(86981);
        return format;
    }
}
