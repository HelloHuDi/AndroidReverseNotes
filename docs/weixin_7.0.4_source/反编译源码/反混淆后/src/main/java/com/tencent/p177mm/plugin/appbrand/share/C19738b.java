package com.tencent.p177mm.plugin.appbrand.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.share.b */
public final class C19738b implements C37932f {
    private int mHeight;
    private int mWidth;

    public C19738b(int i, int i2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(132736);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertFalse(z);
        if (i2 != 0) {
            z2 = false;
        }
        Assert.assertFalse(z2);
        this.mWidth = i;
        this.mHeight = i2;
        AppMethodBeat.m2505o(132736);
    }

    /* renamed from: y */
    public final Bitmap mo22474y(Bitmap bitmap) {
        AppMethodBeat.m2504i(132737);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(132737);
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = ((float) this.mHeight) / ((float) this.mWidth);
        Bitmap createBitmap = C5056d.createBitmap(this.mWidth, this.mHeight, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        if (f <= ((float) height) / ((float) width)) {
            rect.right = width;
            rect.bottom = (int) (((float) width) * f);
        } else {
            rect.right = (int) (((float) height) / f);
            rect.bottom = height;
        }
        Rect rect2 = new Rect();
        rect2.left = 0;
        rect2.top = 0;
        rect2.right = this.mWidth;
        rect2.bottom = this.mHeight;
        canvas.drawBitmap(bitmap, rect, rect2, null);
        AppMethodBeat.m2505o(132737);
        return createBitmap;
    }

    /* renamed from: wP */
    public final String mo6523wP() {
        AppMethodBeat.m2504i(132738);
        String format = String.format("Transformation_w%s_h%s", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)});
        AppMethodBeat.m2505o(132738);
        return format;
    }
}
