package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public final class h extends Drawable {
    private static final Paint feO = new Paint();
    private static Rect rect = null;
    protected int cyQ = 0;
    protected ImageView ikh;
    private Bitmap mBitmap;
    protected String mFilePath = "";
    protected String mNC = "";
    protected long mND = 0;
    protected boolean mSb = false;
    public a mSc;
    long mSd;
    boolean mSe = false;
    private Rect mSf = new Rect();
    private int mWidth;

    public interface a {
        void bCx();
    }

    static final class b implements Runnable {
        final WeakReference<ImageView> mSg;

        b(ImageView imageView) {
            AppMethodBeat.i(138612);
            this.mSg = new WeakReference(imageView);
            AppMethodBeat.o(138612);
        }

        public final void run() {
            Drawable drawable;
            AppMethodBeat.i(21606);
            ImageView imageView = (ImageView) this.mSg.get();
            if (imageView == null) {
                drawable = null;
            } else {
                drawable = imageView.getDrawable();
            }
            if (drawable == null || !(drawable instanceof h)) {
                ab.w("MicroMsg.ThumbDrawable", "[tomys] ownerView is null or not a ThumbDrawable, ignore this task.");
                AppMethodBeat.o(21606);
                return;
            }
            ab.v("MicroMsg.ThumbDrawable", "invalidateSelf");
            h hVar = (h) drawable;
            hVar.mBitmap = e.bBY().Nz(hVar.mFilePath);
            if (!(hVar.mSc == null || hVar.mBitmap == null || hVar.mBitmap.isRecycled())) {
                hVar.mSc.bCx();
            }
            if (hVar.mBitmap == null || hVar.mBitmap.isRecycled()) {
                e.bBY().b(hVar.mFilePath, hVar.cyQ, hVar.mNC, hVar.mND);
                ab.v("MicroMsg.ThumbDrawable", "invalidateSelf! mBitmap is null! path:%s", hVar.mFilePath);
            }
            hVar.mSd = SystemClock.uptimeMillis();
            hVar.invalidateSelf();
            AppMethodBeat.o(21606);
        }
    }

    static final class c implements com.tencent.mm.plugin.gallery.model.d.b {
        final ImageView mSh;

        c(ImageView imageView) {
            this.mSh = imageView;
        }

        public final void NA(String str) {
            AppMethodBeat.i(21608);
            ImageView imageView = this.mSh;
            if (imageView == null) {
                ab.w("MicroMsg.ThumbDrawable", "[tomys] ownerView is recycled, ignore this event.");
                AppMethodBeat.o(21608);
            } else if (bo.isNullOrNil(str)) {
                ab.d("MicroMsg.ThumbDrawable", "filepath is null or nill");
                AppMethodBeat.o(21608);
            } else {
                Drawable drawable = imageView.getDrawable();
                if (drawable == null) {
                    ab.w("MicroMsg.ThumbDrawable", "drawable in ownerView [%s] is null, ignore.", imageView);
                    AppMethodBeat.o(21608);
                } else if (drawable instanceof h) {
                    if (((h) drawable).mFilePath.equals(str)) {
                        ab.d("MicroMsg.ThumbDrawable", "notify thumb get ".concat(String.valueOf(str)));
                        imageView.post(new b(imageView));
                        AppMethodBeat.o(21608);
                        return;
                    }
                    ab.d("MicroMsg.ThumbDrawable", "not current filepath, drawableFilePath: [%s], cbFilePath: [%s]", ((h) drawable).mFilePath, str);
                    AppMethodBeat.o(21608);
                } else {
                    ab.w("MicroMsg.ThumbDrawable", "drawable [%s] in ownerView [%s] is not a ThumbDrawable, ignore.", drawable, imageView);
                    AppMethodBeat.o(21608);
                }
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(21609);
            Drawable bCO = bCO();
            int hashCode;
            if (bCO != null) {
                hashCode = bCO.hashCode();
                AppMethodBeat.o(21609);
                return hashCode;
            }
            hashCode = super.hashCode();
            AppMethodBeat.o(21609);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(138169);
            if (obj == null) {
                AppMethodBeat.o(138169);
                return false;
            }
            Drawable bCO = bCO();
            if (obj instanceof c) {
                obj = ((c) obj).bCO();
            } else if (obj instanceof h) {
                Drawable drawable = (Drawable) obj;
            } else {
                AppMethodBeat.o(138169);
                return false;
            }
            if (bCO == null && obj == null) {
                AppMethodBeat.o(138169);
                return true;
            } else if (bCO == null || obj == null) {
                AppMethodBeat.o(138169);
                return false;
            } else {
                boolean equals = bCO.equals(obj);
                AppMethodBeat.o(138169);
                return equals;
            }
        }

        private Drawable bCO() {
            AppMethodBeat.i(138613);
            ImageView imageView = this.mSh;
            if (imageView == null) {
                AppMethodBeat.o(138613);
                return null;
            }
            Drawable drawable = imageView.getDrawable();
            AppMethodBeat.o(138613);
            return drawable;
        }
    }

    static {
        AppMethodBeat.i(21619);
        feO.setAntiAlias(true);
        feO.setFilterBitmap(true);
        AppMethodBeat.o(21619);
    }

    private h(ImageView imageView) {
        AppMethodBeat.i(21610);
        this.ikh = imageView;
        this.mFilePath = "";
        AppMethodBeat.o(21610);
    }

    private void b(int i, String str, String str2, long j) {
        boolean z = false;
        AppMethodBeat.i(21611);
        String str3 = bo.isNullOrNil(str) ? str2 : str;
        if (bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.ThumbDrawable", "filepath is null or nil");
            AppMethodBeat.o(21611);
            return;
        }
        if (bo.isNullOrNil(str)) {
            this.mSb = false;
        } else {
            this.mSb = true;
        }
        e.bBY().a(new c(this.ikh));
        String str4;
        String str5;
        Object[] objArr;
        if (!this.mFilePath.equals(str3) || this.mBitmap == null || this.mBitmap.isRecycled()) {
            this.mFilePath = str3;
            this.mNC = str2;
            this.mND = j;
            this.cyQ = i;
            this.mBitmap = e.bBY().Nz(this.mFilePath);
            str4 = "MicroMsg.ThumbDrawable";
            str5 = "setMediaFeature ok filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
            objArr = new Object[3];
            objArr[0] = str3;
            objArr[1] = Boolean.valueOf(this.mBitmap == null);
            objArr[2] = Boolean.valueOf(this.mBitmap != null ? this.mBitmap.isRecycled() : false);
            ab.d(str4, str5, objArr);
            if (this.mBitmap == null || this.mBitmap.isRecycled()) {
                this.mSe = true;
                this.mSd = 0;
                this.mBitmap = e.bBY().b(str3, i, str2, j);
            } else {
                this.mSe = false;
            }
            if (!(this.mSc == null || this.mBitmap == null || this.mBitmap.isRecycled())) {
                this.mSc.bCx();
            }
            this.ikh.invalidate();
            AppMethodBeat.o(21611);
            return;
        }
        boolean z2;
        str4 = "MicroMsg.ThumbDrawable";
        str5 = "setMediaFeature fuck filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
        objArr = new Object[3];
        objArr[0] = str3;
        if (this.mBitmap == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[1] = Boolean.valueOf(z2);
        if (this.mBitmap != null) {
            z = this.mBitmap.isRecycled();
        }
        objArr[2] = Boolean.valueOf(z);
        ab.d(str4, str5, objArr);
        AppMethodBeat.o(21611);
    }

    public final int getIntrinsicWidth() {
        return 400;
    }

    public final int getIntrinsicHeight() {
        return 400;
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(21612);
        ab.v("MicroMsg.ThumbDrawable", "setBountsLTRB:%d %d - %d %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        super.setBounds(i, i2, i3, i4);
        AppMethodBeat.o(21612);
    }

    public final void setBounds(Rect rect) {
        AppMethodBeat.i(21613);
        ab.v("MicroMsg.ThumbDrawable", "setBountsRECT:%s", rect.toString());
        super.setBounds(rect);
        AppMethodBeat.o(21613);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(21614);
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mSd)) / 200.0f;
        if (this.mSd == 0) {
            ab.d("MicroMsg.ThumbDrawable", "[duanyi test]: draw:[%s] startTimeMillis is 0", this.mFilePath);
            uptimeMillis = 0.0f;
        }
        ab.d("MicroMsg.ThumbDrawable", "[duanyi test]: hash:[%s] draw:[%s] animating:[%s] normalized:[%s] alpha[%s]", Integer.valueOf(hashCode()), this.mFilePath, Boolean.valueOf(this.mSe), Float.valueOf(uptimeMillis), Integer.valueOf((int) (255.0f * uptimeMillis)));
        if (!this.mSe) {
            d(canvas, 255);
            setAlpha(255);
            AppMethodBeat.o(21614);
        } else if (uptimeMillis >= 1.0f) {
            this.mSe = false;
            d(canvas, 255);
            AppMethodBeat.o(21614);
        } else {
            if (d(canvas, (int) (uptimeMillis * 255.0f))) {
                invalidateSelf();
            }
            AppMethodBeat.o(21614);
        }
    }

    private boolean d(Canvas canvas, int i) {
        AppMethodBeat.i(21615);
        if (this.mBitmap == null || this.mBitmap.isRecycled()) {
            ab.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap is null: " + this.mFilePath);
            if (this.mBitmap != null && this.mBitmap.isRecycled()) {
                this.mSe = true;
                this.mSd = 0;
                this.mBitmap = e.bBY().b(this.mFilePath, this.cyQ, this.mNC, this.mND);
                if (!(this.mSc == null || this.mBitmap == null || this.mBitmap.isRecycled())) {
                    this.mSc.bCx();
                }
            }
            AppMethodBeat.o(21615);
            return false;
        }
        ab.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap ok:" + this.mFilePath);
        a(this.mBitmap, this.mSf);
        feO.setAlpha(i);
        canvas.drawBitmap(this.mBitmap, this.mSf, getBounds(), feO);
        ab.v("MicroMsg.ThumbDrawable", "Bounts:%s", getBounds().toString());
        AppMethodBeat.o(21615);
        return true;
    }

    private static void a(Bitmap bitmap, Rect rect) {
        AppMethodBeat.i(21616);
        if (bitmap.getWidth() > bitmap.getHeight()) {
            rect.top = 0;
            rect.bottom = bitmap.getHeight();
            rect.left = (bitmap.getWidth() - bitmap.getHeight()) >> 1;
            rect.right = rect.left + bitmap.getHeight();
            AppMethodBeat.o(21616);
            return;
        }
        rect.left = 0;
        rect.right = bitmap.getWidth();
        rect.top = (bitmap.getHeight() - bitmap.getWidth()) >> 1;
        rect.bottom = rect.top + bitmap.getWidth();
        AppMethodBeat.o(21616);
    }

    public static void a(ImageView imageView, int i, String str, String str2, long j) {
        AppMethodBeat.i(21617);
        a(imageView, i, str, str2, j, -1, null);
        AppMethodBeat.o(21617);
    }

    public static void a(ImageView imageView, int i, String str, String str2, long j, int i2, a aVar) {
        h hVar;
        AppMethodBeat.i(21618);
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof h)) {
            hVar = new h(imageView);
        } else {
            hVar = (h) drawable;
        }
        if (i2 > 0) {
            hVar.mWidth = i2;
        }
        hVar.mSc = aVar;
        hVar.b(i, str, str2, j);
        imageView.setImageDrawable(hVar);
        AppMethodBeat.o(21618);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }
}
