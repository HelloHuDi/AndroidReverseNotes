package com.tencent.mm.svg.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.svg.b.b;
import com.tencent.mm.svg.b.d;

public final class c extends b {
    private a ydc;

    public static class a extends ConstantState {
        protected int sLo;
        protected Picture ydd;
        protected Bitmap yde;

        public a(Picture picture, int i) {
            this.ydd = picture;
            this.sLo = i;
        }

        public final Drawable newDrawable() {
            AppMethodBeat.i(70089);
            ab.i("MicroMsg.SVGPictureDrawable", "SVGPictureConstantState newDrawable %s", Integer.valueOf(this.sLo));
            c cVar = new c(this.ydd, this.sLo);
            AppMethodBeat.o(70089);
            return cVar;
        }

        public final Drawable newDrawable(Resources resources) {
            AppMethodBeat.i(70090);
            Drawable newDrawable = newDrawable();
            AppMethodBeat.o(70090);
            return newDrawable;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            AppMethodBeat.i(70091);
            Drawable newDrawable = newDrawable(resources);
            AppMethodBeat.o(70091);
            return newDrawable;
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    public c(Picture picture, int i) {
        int i2 = 0;
        int width = picture != null ? picture.getWidth() : 0;
        if (picture != null) {
            i2 = picture.getHeight();
        }
        super(width, i2, i);
        AppMethodBeat.i(70092);
        this.ydc = new a(picture, i);
        dvE();
        AppMethodBeat.o(70092);
    }

    public final ConstantState getConstantState() {
        return this.ydc;
    }

    public final void draw(Canvas canvas) {
        Object obj = 1;
        Object obj2 = null;
        AppMethodBeat.i(70093);
        long dvM = b.dvM();
        try {
            if (canvas.isHardwareAccelerated()) {
                if (this.ydc.ydd == null) {
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", Integer.valueOf(this.ycT));
                } else {
                    long nanoTime = System.nanoTime();
                    if (this.ydc.yde == null || this.ydc.yde.isRecycled()) {
                        if (getIntrinsicWidth() > 2048 || getIntrinsicHeight() > 2048) {
                            com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", Integer.valueOf(this.ycT));
                        } else if (getIntrinsicWidth() <= 0 || getIntrinsicHeight() <= 0) {
                            com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "width and height must > 0.", new Object[0]);
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap);
                            this.ydc.ydd.draw(canvas2);
                            this.ydc.yde = createBitmap;
                            b.mW(nanoTime);
                            d.dvN();
                            m(canvas2);
                        }
                    }
                }
                if (this.ydc.yde == null || this.ydc.yde.isRecycled()) {
                    obj = null;
                } else {
                    dvF();
                    canvas.drawBitmap(this.ydc.yde, null, this.Hx, this.ycV);
                }
                obj2 = obj;
            } else if (!(this.ydc.yde == null || this.ydc.yde.isRecycled())) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", this.ydc.yde.toString());
                this.ydc.yde.recycle();
                this.ydc.yde = null;
            }
            View dvH = dvH();
            if (dvH == null) {
                dvH = a.w(this);
                eC(dvH);
            }
            a.b(dvH, this.ycV);
            if (obj2 == null) {
                if (!canvas.isHardwareAccelerated() || VERSION.SDK_INT >= 16) {
                    Picture picture = this.ydc.ydd;
                    if (picture != null) {
                        dvF();
                        canvas.save();
                        canvas.drawPicture(picture, this.Hx);
                        canvas.restore();
                    }
                } else {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "Skip this draw.", new Object[0]);
                    return;
                }
            }
            this.mDuration = b.mW(dvM);
            d.dvO();
            m(canvas);
            AppMethodBeat.o(70093);
        } finally {
            this.mDuration = b.mW(dvM);
            d.dvO();
            m(canvas);
            AppMethodBeat.o(70093);
        }
    }
}
