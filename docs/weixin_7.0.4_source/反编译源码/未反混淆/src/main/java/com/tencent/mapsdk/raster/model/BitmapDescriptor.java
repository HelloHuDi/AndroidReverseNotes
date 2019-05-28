package com.tencent.mapsdk.raster.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BitmapDescriptor implements Cloneable {
    int h = 0;
    Bitmap mBitmap;
    int w = 0;

    public BitmapDescriptor(Bitmap bitmap) {
        AppMethodBeat.i(101150);
        if (bitmap != null) {
            this.w = bitmap.getWidth();
            this.h = bitmap.getHeight();
            this.mBitmap = bitmap;
        }
        AppMethodBeat.o(101150);
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2) {
        this.w = i;
        this.h = i2;
        this.mBitmap = bitmap;
    }

    public final BitmapDescriptor clone() {
        AppMethodBeat.i(101151);
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(Bitmap.createBitmap(this.mBitmap), this.w, this.h);
        AppMethodBeat.o(101151);
        return bitmapDescriptor;
    }

    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    public final int getWidth() {
        return this.w;
    }

    public final int getHeight() {
        return this.h;
    }
}
