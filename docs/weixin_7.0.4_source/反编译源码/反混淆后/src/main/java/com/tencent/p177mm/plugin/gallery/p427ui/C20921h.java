package com.tencent.p177mm.plugin.gallery.p427ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.gallery.model.C20905d.C20907b;
import com.tencent.p177mm.plugin.gallery.model.C34237e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.gallery.ui.h */
public final class C20921h extends Drawable {
    private static final Paint feO = new Paint();
    private static Rect rect = null;
    protected int cyQ = 0;
    protected ImageView ikh;
    private Bitmap mBitmap;
    protected String mFilePath = "";
    protected String mNC = "";
    protected long mND = 0;
    protected boolean mSb = false;
    public C12100a mSc;
    long mSd;
    boolean mSe = false;
    private Rect mSf = new Rect();
    private int mWidth;

    /* renamed from: com.tencent.mm.plugin.gallery.ui.h$a */
    public interface C12100a {
        void bCx();
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.h$b */
    static final class C12101b implements Runnable {
        final WeakReference<ImageView> mSg;

        C12101b(ImageView imageView) {
            AppMethodBeat.m2504i(138612);
            this.mSg = new WeakReference(imageView);
            AppMethodBeat.m2505o(138612);
        }

        public final void run() {
            Drawable drawable;
            AppMethodBeat.m2504i(21606);
            ImageView imageView = (ImageView) this.mSg.get();
            if (imageView == null) {
                drawable = null;
            } else {
                drawable = imageView.getDrawable();
            }
            if (drawable == null || !(drawable instanceof C20921h)) {
                C4990ab.m7420w("MicroMsg.ThumbDrawable", "[tomys] ownerView is null or not a ThumbDrawable, ignore this task.");
                AppMethodBeat.m2505o(21606);
                return;
            }
            C4990ab.m7418v("MicroMsg.ThumbDrawable", "invalidateSelf");
            C20921h c20921h = (C20921h) drawable;
            c20921h.mBitmap = C34237e.bBY().mo68657Nz(c20921h.mFilePath);
            if (!(c20921h.mSc == null || c20921h.mBitmap == null || c20921h.mBitmap.isRecycled())) {
                c20921h.mSc.bCx();
            }
            if (c20921h.mBitmap == null || c20921h.mBitmap.isRecycled()) {
                C34237e.bBY().mo68659b(c20921h.mFilePath, c20921h.cyQ, c20921h.mNC, c20921h.mND);
                C4990ab.m7419v("MicroMsg.ThumbDrawable", "invalidateSelf! mBitmap is null! path:%s", c20921h.mFilePath);
            }
            c20921h.mSd = SystemClock.uptimeMillis();
            c20921h.invalidateSelf();
            AppMethodBeat.m2505o(21606);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.h$c */
    static final class C20922c implements C20907b {
        final ImageView mSh;

        C20922c(ImageView imageView) {
            this.mSh = imageView;
        }

        /* renamed from: NA */
        public final void mo23913NA(String str) {
            AppMethodBeat.m2504i(21608);
            ImageView imageView = this.mSh;
            if (imageView == null) {
                C4990ab.m7420w("MicroMsg.ThumbDrawable", "[tomys] ownerView is recycled, ignore this event.");
                AppMethodBeat.m2505o(21608);
            } else if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7410d("MicroMsg.ThumbDrawable", "filepath is null or nill");
                AppMethodBeat.m2505o(21608);
            } else {
                Drawable drawable = imageView.getDrawable();
                if (drawable == null) {
                    C4990ab.m7421w("MicroMsg.ThumbDrawable", "drawable in ownerView [%s] is null, ignore.", imageView);
                    AppMethodBeat.m2505o(21608);
                } else if (drawable instanceof C20921h) {
                    if (((C20921h) drawable).mFilePath.equals(str)) {
                        C4990ab.m7410d("MicroMsg.ThumbDrawable", "notify thumb get ".concat(String.valueOf(str)));
                        imageView.post(new C12101b(imageView));
                        AppMethodBeat.m2505o(21608);
                        return;
                    }
                    C4990ab.m7411d("MicroMsg.ThumbDrawable", "not current filepath, drawableFilePath: [%s], cbFilePath: [%s]", ((C20921h) drawable).mFilePath, str);
                    AppMethodBeat.m2505o(21608);
                } else {
                    C4990ab.m7421w("MicroMsg.ThumbDrawable", "drawable [%s] in ownerView [%s] is not a ThumbDrawable, ignore.", drawable, imageView);
                    AppMethodBeat.m2505o(21608);
                }
            }
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(21609);
            Drawable bCO = bCO();
            int hashCode;
            if (bCO != null) {
                hashCode = bCO.hashCode();
                AppMethodBeat.m2505o(21609);
                return hashCode;
            }
            hashCode = super.hashCode();
            AppMethodBeat.m2505o(21609);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(138169);
            if (obj == null) {
                AppMethodBeat.m2505o(138169);
                return false;
            }
            Drawable bCO = bCO();
            if (obj instanceof C20922c) {
                obj = ((C20922c) obj).bCO();
            } else if (obj instanceof C20921h) {
                Drawable drawable = (Drawable) obj;
            } else {
                AppMethodBeat.m2505o(138169);
                return false;
            }
            if (bCO == null && obj == null) {
                AppMethodBeat.m2505o(138169);
                return true;
            } else if (bCO == null || obj == null) {
                AppMethodBeat.m2505o(138169);
                return false;
            } else {
                boolean equals = bCO.equals(obj);
                AppMethodBeat.m2505o(138169);
                return equals;
            }
        }

        private Drawable bCO() {
            AppMethodBeat.m2504i(138613);
            ImageView imageView = this.mSh;
            if (imageView == null) {
                AppMethodBeat.m2505o(138613);
                return null;
            }
            Drawable drawable = imageView.getDrawable();
            AppMethodBeat.m2505o(138613);
            return drawable;
        }
    }

    static {
        AppMethodBeat.m2504i(21619);
        feO.setAntiAlias(true);
        feO.setFilterBitmap(true);
        AppMethodBeat.m2505o(21619);
    }

    private C20921h(ImageView imageView) {
        AppMethodBeat.m2504i(21610);
        this.ikh = imageView;
        this.mFilePath = "";
        AppMethodBeat.m2505o(21610);
    }

    /* renamed from: b */
    private void m32170b(int i, String str, String str2, long j) {
        boolean z = false;
        AppMethodBeat.m2504i(21611);
        String str3 = C5046bo.isNullOrNil(str) ? str2 : str;
        if (C5046bo.isNullOrNil(str3)) {
            C4990ab.m7412e("MicroMsg.ThumbDrawable", "filepath is null or nil");
            AppMethodBeat.m2505o(21611);
            return;
        }
        if (C5046bo.isNullOrNil(str)) {
            this.mSb = false;
        } else {
            this.mSb = true;
        }
        C34237e.bBY().mo68658a(new C20922c(this.ikh));
        String str4;
        String str5;
        Object[] objArr;
        if (!this.mFilePath.equals(str3) || this.mBitmap == null || this.mBitmap.isRecycled()) {
            this.mFilePath = str3;
            this.mNC = str2;
            this.mND = j;
            this.cyQ = i;
            this.mBitmap = C34237e.bBY().mo68657Nz(this.mFilePath);
            str4 = "MicroMsg.ThumbDrawable";
            str5 = "setMediaFeature ok filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
            objArr = new Object[3];
            objArr[0] = str3;
            objArr[1] = Boolean.valueOf(this.mBitmap == null);
            objArr[2] = Boolean.valueOf(this.mBitmap != null ? this.mBitmap.isRecycled() : false);
            C4990ab.m7411d(str4, str5, objArr);
            if (this.mBitmap == null || this.mBitmap.isRecycled()) {
                this.mSe = true;
                this.mSd = 0;
                this.mBitmap = C34237e.bBY().mo68659b(str3, i, str2, j);
            } else {
                this.mSe = false;
            }
            if (!(this.mSc == null || this.mBitmap == null || this.mBitmap.isRecycled())) {
                this.mSc.bCx();
            }
            this.ikh.invalidate();
            AppMethodBeat.m2505o(21611);
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
        C4990ab.m7411d(str4, str5, objArr);
        AppMethodBeat.m2505o(21611);
    }

    public final int getIntrinsicWidth() {
        return 400;
    }

    public final int getIntrinsicHeight() {
        return 400;
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(21612);
        C4990ab.m7419v("MicroMsg.ThumbDrawable", "setBountsLTRB:%d %d - %d %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        super.setBounds(i, i2, i3, i4);
        AppMethodBeat.m2505o(21612);
    }

    public final void setBounds(Rect rect) {
        AppMethodBeat.m2504i(21613);
        C4990ab.m7419v("MicroMsg.ThumbDrawable", "setBountsRECT:%s", rect.toString());
        super.setBounds(rect);
        AppMethodBeat.m2505o(21613);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(21614);
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mSd)) / 200.0f;
        if (this.mSd == 0) {
            C4990ab.m7411d("MicroMsg.ThumbDrawable", "[duanyi test]: draw:[%s] startTimeMillis is 0", this.mFilePath);
            uptimeMillis = 0.0f;
        }
        C4990ab.m7411d("MicroMsg.ThumbDrawable", "[duanyi test]: hash:[%s] draw:[%s] animating:[%s] normalized:[%s] alpha[%s]", Integer.valueOf(hashCode()), this.mFilePath, Boolean.valueOf(this.mSe), Float.valueOf(uptimeMillis), Integer.valueOf((int) (255.0f * uptimeMillis)));
        if (!this.mSe) {
            m32171d(canvas, 255);
            setAlpha(255);
            AppMethodBeat.m2505o(21614);
        } else if (uptimeMillis >= 1.0f) {
            this.mSe = false;
            m32171d(canvas, 255);
            AppMethodBeat.m2505o(21614);
        } else {
            if (m32171d(canvas, (int) (uptimeMillis * 255.0f))) {
                invalidateSelf();
            }
            AppMethodBeat.m2505o(21614);
        }
    }

    /* renamed from: d */
    private boolean m32171d(Canvas canvas, int i) {
        AppMethodBeat.m2504i(21615);
        if (this.mBitmap == null || this.mBitmap.isRecycled()) {
            C4990ab.m7410d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap is null: " + this.mFilePath);
            if (this.mBitmap != null && this.mBitmap.isRecycled()) {
                this.mSe = true;
                this.mSd = 0;
                this.mBitmap = C34237e.bBY().mo68659b(this.mFilePath, this.cyQ, this.mNC, this.mND);
                if (!(this.mSc == null || this.mBitmap == null || this.mBitmap.isRecycled())) {
                    this.mSc.bCx();
                }
            }
            AppMethodBeat.m2505o(21615);
            return false;
        }
        C4990ab.m7410d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap ok:" + this.mFilePath);
        C20921h.m32167a(this.mBitmap, this.mSf);
        feO.setAlpha(i);
        canvas.drawBitmap(this.mBitmap, this.mSf, getBounds(), feO);
        C4990ab.m7419v("MicroMsg.ThumbDrawable", "Bounts:%s", getBounds().toString());
        AppMethodBeat.m2505o(21615);
        return true;
    }

    /* renamed from: a */
    private static void m32167a(Bitmap bitmap, Rect rect) {
        AppMethodBeat.m2504i(21616);
        if (bitmap.getWidth() > bitmap.getHeight()) {
            rect.top = 0;
            rect.bottom = bitmap.getHeight();
            rect.left = (bitmap.getWidth() - bitmap.getHeight()) >> 1;
            rect.right = rect.left + bitmap.getHeight();
            AppMethodBeat.m2505o(21616);
            return;
        }
        rect.left = 0;
        rect.right = bitmap.getWidth();
        rect.top = (bitmap.getHeight() - bitmap.getWidth()) >> 1;
        rect.bottom = rect.top + bitmap.getWidth();
        AppMethodBeat.m2505o(21616);
    }

    /* renamed from: a */
    public static void m32168a(ImageView imageView, int i, String str, String str2, long j) {
        AppMethodBeat.m2504i(21617);
        C20921h.m32169a(imageView, i, str, str2, j, -1, null);
        AppMethodBeat.m2505o(21617);
    }

    /* renamed from: a */
    public static void m32169a(ImageView imageView, int i, String str, String str2, long j, int i2, C12100a c12100a) {
        C20921h c20921h;
        AppMethodBeat.m2504i(21618);
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof C20921h)) {
            c20921h = new C20921h(imageView);
        } else {
            c20921h = (C20921h) drawable;
        }
        if (i2 > 0) {
            c20921h.mWidth = i2;
        }
        c20921h.mSc = c12100a;
        c20921h.m32170b(i, str, str2, j);
        imageView.setImageDrawable(c20921h);
        AppMethodBeat.m2505o(21618);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }
}
