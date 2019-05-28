package com.tencent.p177mm.svg.p610a;

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
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.svg.p611b.C5157b;
import com.tencent.p177mm.svg.p611b.C5159c;
import com.tencent.p177mm.svg.p611b.C5161d;

/* renamed from: com.tencent.mm.svg.a.c */
public final class C7314c extends C5148b {
    private C5149a ydc;

    /* renamed from: com.tencent.mm.svg.a.c$a */
    public static class C5149a extends ConstantState {
        protected int sLo;
        protected Picture ydd;
        protected Bitmap yde;

        public C5149a(Picture picture, int i) {
            this.ydd = picture;
            this.sLo = i;
        }

        public final Drawable newDrawable() {
            AppMethodBeat.m2504i(70089);
            C4990ab.m7417i("MicroMsg.SVGPictureDrawable", "SVGPictureConstantState newDrawable %s", Integer.valueOf(this.sLo));
            C7314c c7314c = new C7314c(this.ydd, this.sLo);
            AppMethodBeat.m2505o(70089);
            return c7314c;
        }

        public final Drawable newDrawable(Resources resources) {
            AppMethodBeat.m2504i(70090);
            Drawable newDrawable = newDrawable();
            AppMethodBeat.m2505o(70090);
            return newDrawable;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            AppMethodBeat.m2504i(70091);
            Drawable newDrawable = newDrawable(resources);
            AppMethodBeat.m2505o(70091);
            return newDrawable;
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    public C7314c(Picture picture, int i) {
        int i2 = 0;
        int width = picture != null ? picture.getWidth() : 0;
        if (picture != null) {
            i2 = picture.getHeight();
        }
        super(width, i2, i);
        AppMethodBeat.m2504i(70092);
        this.ydc = new C5149a(picture, i);
        dvE();
        AppMethodBeat.m2505o(70092);
    }

    public final ConstantState getConstantState() {
        return this.ydc;
    }

    public final void draw(Canvas canvas) {
        Object obj = 1;
        Object obj2 = null;
        AppMethodBeat.m2504i(70093);
        long dvM = C5157b.dvM();
        try {
            if (canvas.isHardwareAccelerated()) {
                if (this.ydc.ydd == null) {
                    C5159c.m7868e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", Integer.valueOf(this.ycT));
                } else {
                    long nanoTime = System.nanoTime();
                    if (this.ydc.yde == null || this.ydc.yde.isRecycled()) {
                        if (getIntrinsicWidth() > 2048 || getIntrinsicHeight() > 2048) {
                            C5159c.m7868e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", Integer.valueOf(this.ycT));
                        } else if (getIntrinsicWidth() <= 0 || getIntrinsicHeight() <= 0) {
                            C5159c.m7868e("MicroMsg.SVGPictureDrawable", "width and height must > 0.", new Object[0]);
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap);
                            this.ydc.ydd.draw(canvas2);
                            this.ydc.yde = createBitmap;
                            C5157b.m7861mW(nanoTime);
                            C5161d.dvN();
                            mo10594m(canvas2);
                        }
                    }
                }
                if (this.ydc.yde == null || this.ydc.yde.isRecycled()) {
                    obj = null;
                } else {
                    dvF();
                    canvas.drawBitmap(this.ydc.yde, null, this.f1295Hx, this.ycV);
                }
                obj2 = obj;
            } else if (!(this.ydc.yde == null || this.ydc.yde.isRecycled())) {
                C5159c.m7869i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", this.ydc.yde.toString());
                this.ydc.yde.recycle();
                this.ydc.yde = null;
            }
            View dvH = dvH();
            if (dvH == null) {
                dvH = C5147a.m7838w(this);
                mo10590eC(dvH);
            }
            C5147a.m7832b(dvH, this.ycV);
            if (obj2 == null) {
                if (!canvas.isHardwareAccelerated() || VERSION.SDK_INT >= 16) {
                    Picture picture = this.ydc.ydd;
                    if (picture != null) {
                        dvF();
                        canvas.save();
                        canvas.drawPicture(picture, this.f1295Hx);
                        canvas.restore();
                    }
                } else {
                    C5159c.m7869i("MicroMsg.SVGPictureDrawable", "Skip this draw.", new Object[0]);
                    return;
                }
            }
            this.mDuration = C5157b.m7861mW(dvM);
            C5161d.dvO();
            mo10594m(canvas);
            AppMethodBeat.m2505o(70093);
        } finally {
            this.mDuration = C5157b.m7861mW(dvM);
            C5161d.dvO();
            mo10594m(canvas);
            AppMethodBeat.m2505o(70093);
        }
    }
}
