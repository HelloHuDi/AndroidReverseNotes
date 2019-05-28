package com.tencent.p177mm.plugin.appbrand.luggage.p1227a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.a.b */
public final class C27185b implements C37932f {
    /* renamed from: iJ */
    private int f13675iJ;
    /* renamed from: iK */
    private int f13676iK;
    private int mHeight;
    private int mWidth;

    public C27185b(int i, int i2, int i3, int i4) {
        boolean z = true;
        AppMethodBeat.m2504i(86979);
        Assert.assertFalse(i3 == 0);
        if (i4 != 0) {
            z = false;
        }
        Assert.assertFalse(z);
        this.f13675iJ = i;
        this.f13676iK = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        AppMethodBeat.m2505o(86979);
    }

    /* renamed from: y */
    public final Bitmap mo22474y(Bitmap bitmap) {
        AppMethodBeat.m2504i(86980);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(86980);
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = this.f13675iJ;
        int i2 = this.f13676iK;
        if (this.f13675iJ < 0) {
            i = 0;
        } else if (this.f13675iJ > width) {
            i = width;
        }
        if (this.f13676iK < 0) {
            i2 = 0;
        } else if (this.f13676iK > height) {
            i2 = height;
        }
        int i3 = (this.mWidth + this.f13675iJ) - i;
        int i4 = (this.mHeight + this.f13676iK) - i2;
        if (i + i3 > width) {
            i3 = width - i;
        }
        if (i2 + i4 > height) {
            height -= i2;
        } else {
            height = i4;
        }
        if (i3 <= 0 || height <= 0) {
            bitmap = C5056d.createBitmap(1, 1, Config.ARGB_8888);
            AppMethodBeat.m2505o(86980);
            return bitmap;
        }
        Bitmap createBitmap = C5056d.createBitmap(i3, height, Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, new Rect(i, i2, i + i3, i2 + height), new Rect(0, 0, i3, height), null);
        AppMethodBeat.m2505o(86980);
        return createBitmap;
    }

    /* renamed from: wP */
    public final String mo6523wP() {
        AppMethodBeat.m2504i(86981);
        String format = String.format("Transformation_x%s_y%s_w%s_h%s", new Object[]{Integer.valueOf(this.f13675iJ), Integer.valueOf(this.f13676iK), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)});
        AppMethodBeat.m2505o(86981);
        return format;
    }
}
