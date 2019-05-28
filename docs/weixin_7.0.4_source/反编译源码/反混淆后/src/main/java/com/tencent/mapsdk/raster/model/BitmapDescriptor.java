package com.tencent.mapsdk.raster.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BitmapDescriptor implements Cloneable {
    /* renamed from: h */
    int f4316h = 0;
    Bitmap mBitmap;
    /* renamed from: w */
    int f4317w = 0;

    public BitmapDescriptor(Bitmap bitmap) {
        AppMethodBeat.m2504i(101150);
        if (bitmap != null) {
            this.f4317w = bitmap.getWidth();
            this.f4316h = bitmap.getHeight();
            this.mBitmap = bitmap;
        }
        AppMethodBeat.m2505o(101150);
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2) {
        this.f4317w = i;
        this.f4316h = i2;
        this.mBitmap = bitmap;
    }

    public final BitmapDescriptor clone() {
        AppMethodBeat.m2504i(101151);
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(Bitmap.createBitmap(this.mBitmap), this.f4317w, this.f4316h);
        AppMethodBeat.m2505o(101151);
        return bitmapDescriptor;
    }

    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    public final int getWidth() {
        return this.f4317w;
    }

    public final int getHeight() {
        return this.f4316h;
    }
}
