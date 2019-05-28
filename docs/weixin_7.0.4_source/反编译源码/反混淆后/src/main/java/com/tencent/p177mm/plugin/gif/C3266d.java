package com.tencent.p177mm.plugin.gif;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.p1526as.C37472a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.gif.d */
public final class C3266d extends C34323b {
    /* renamed from: Hx */
    private final Rect f1266Hx;
    private int ehv;
    private C7306ak lda;
    private float mDensity;
    private boolean mIsRunning;
    private final Paint mPaint;
    private boolean noA;
    private volatile long noB;
    private AssetFileDescriptor noC;
    private final int[] noD;
    private float noE;
    private float noF;
    private boolean noG;
    private int[] noH;
    private int noI;
    private int noJ;
    private long noK;
    private long noL;
    private long noM;
    private long noN;
    private long noO;
    private long noP;
    private int noQ;
    private boolean noR;
    int noS;
    private int noT;
    C39243k noU;
    private boolean noV;
    private final Runnable noW;
    private final Runnable noX;
    private final Runnable noY;
    private final Runnable noZ;
    private final Runnable npa;
    private final Runnable npb;

    /* renamed from: com.tencent.mm.plugin.gif.d$5 */
    class C32675 implements Runnable {
        C32675() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62384);
            MMGIFJNI.saveRemainder(C3266d.this.noB);
            AppMethodBeat.m2505o(62384);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gif.d$6 */
    class C32686 implements Runnable {
        C32686() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62385);
            if (C3266d.this.noA) {
                C4990ab.m7416i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
                AppMethodBeat.m2505o(62385);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (C3266d.this.noJ + 1 > C3266d.this.noI - 1) {
                C3266d.this.noJ = -1;
            }
            C3266d.this.noJ = C3266d.this.noJ + 1;
            if (MMGIFJNI.drawFramePixels(C3266d.this.noB, C3266d.this.noH, C3266d.this.noD)) {
                C3266d.this.noT = C3266d.this.noT + 1;
            }
            C3266d.this.noK = System.currentTimeMillis() - currentTimeMillis;
            if (C3266d.this.noL != 0) {
                C3266d.this.noM = (C3266d.this.noL - C3266d.this.noK) - C3266d.this.noO;
                if (C3266d.this.noM < 0) {
                    C4990ab.m7411d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", Long.valueOf(C3266d.this.noK), Long.valueOf(C3266d.this.noO), Long.valueOf(C3266d.this.noM), Long.valueOf(C3266d.this.noL), Integer.valueOf(C3266d.this.noD[5]));
                    C7060h.pYm.mo8378a(401, 0, 1, false);
                    C7060h.pYm.mo8378a(401, 1, Math.abs(C3266d.this.noM), false);
                    if (C3266d.this.noM < -100) {
                        boolean z = WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable;
                        WXHardCoderJNI.stopPerformance(z, C3266d.this.ehv);
                        C3266d.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifFrameEnable, WXHardCoderJNI.hcGifFrameDelay, WXHardCoderJNI.hcGifFrameCPU, WXHardCoderJNI.hcGifFrameIO, WXHardCoderJNI.hcGifFrameThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable");
                    }
                }
            }
            C3266d.m5577a(C3266d.this, C3266d.this.noX, C3266d.this.noM > 0 ? C3266d.this.noM : 0);
            if (C3266d.this.noD[2] == 1) {
                C3266d.this.noL = 5000;
                AppMethodBeat.m2505o(62385);
                return;
            }
            C3266d.this.noL = (long) C3266d.this.noD[4];
            AppMethodBeat.m2505o(62385);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gif.d$3 */
    class C32693 implements Runnable {
        C32693() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62382);
            MMGIFJNI.restoreRemainder(C3266d.this.noB);
            C3266d.m5577a(C3266d.this, C3266d.this.noX, C3266d.this.noM);
            AppMethodBeat.m2505o(62382);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gif.d$1 */
    class C32701 implements Runnable {
        C32701() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62380);
            if (C3266d.this.noU != null) {
                C3266d.this.noU;
            }
            AppMethodBeat.m2505o(62380);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gif.d$2 */
    class C32712 implements Runnable {
        C32712() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62381);
            if ((C3266d.this.isRunning() || C3266d.this.noJ == 0) && SystemClock.uptimeMillis() >= C3266d.this.noP) {
                C3266d.this.noN = System.currentTimeMillis();
                C3266d.this.noV = true;
                C3266d.this.invalidateSelf();
                if (C3266d.this.noU != null) {
                    C3266d.this.noU.invalidate();
                }
            }
            AppMethodBeat.m2505o(62381);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gif.d$4 */
    class C32724 implements Runnable {
        C32724() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62383);
            MMGIFJNI.reset(C3266d.this.noB);
            C3266d.this.noJ = -1;
            C3266d.m5577a(C3266d.this, C3266d.this.noX, 0);
            AppMethodBeat.m2505o(62383);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m5577a(C3266d c3266d, Runnable runnable, long j) {
        AppMethodBeat.m2504i(62406);
        c3266d.m5591k(runnable, j);
        AppMethodBeat.m2505o(62406);
    }

    /* renamed from: k */
    private void m5591k(Runnable runnable, long j) {
        AppMethodBeat.m2504i(62386);
        this.noP = SystemClock.uptimeMillis() + j;
        if (this.lda != null) {
            this.lda.postAtTime(runnable, this.noP);
        }
        AppMethodBeat.m2505o(62386);
    }

    public C3266d(Resources resources, int i) {
        this(resources.openRawResourceFd(i));
        AppMethodBeat.m2504i(62387);
        AppMethodBeat.m2505o(62387);
    }

    public C3266d(String str) {
        int i = 0;
        AppMethodBeat.m2504i(62388);
        this.mIsRunning = true;
        this.noA = false;
        this.noC = null;
        this.noD = new int[6];
        this.noE = 1.0f;
        this.noF = 1.0f;
        this.f1266Hx = new Rect();
        this.mPaint = new Paint(6);
        this.noI = 0;
        this.noJ = -1;
        this.noK = 0;
        this.noL = 0;
        this.noM = 0;
        this.noN = 0;
        this.noP = 0;
        this.noR = false;
        this.noS = 0;
        this.noT = 0;
        this.lda = new C7306ak(Looper.getMainLooper());
        this.noV = true;
        this.noW = new C32701();
        this.noX = new C32712();
        this.noY = new C32693();
        this.noZ = new C32724();
        this.npa = new C32675();
        this.npb = new C32686();
        if (TextUtils.isEmpty(str)) {
            NullPointerException nullPointerException = new NullPointerException("file path is null.");
            AppMethodBeat.m2505o(62388);
            throw nullPointerException;
        }
        boolean z = WXHardCoderJNI.hcGifEnable;
        int i2 = WXHardCoderJNI.hcGifDelay;
        int i3 = WXHardCoderJNI.hcGifCPU;
        int i4 = WXHardCoderJNI.hcGifIO;
        if (WXHardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.ehv = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.noB = MMGIFJNI.openByFilePath(str, this.noD);
        init();
        AppMethodBeat.m2505o(62388);
    }

    private C3266d(AssetFileDescriptor assetFileDescriptor) {
        int i = 0;
        AppMethodBeat.m2504i(62389);
        this.mIsRunning = true;
        this.noA = false;
        this.noC = null;
        this.noD = new int[6];
        this.noE = 1.0f;
        this.noF = 1.0f;
        this.f1266Hx = new Rect();
        this.mPaint = new Paint(6);
        this.noI = 0;
        this.noJ = -1;
        this.noK = 0;
        this.noL = 0;
        this.noM = 0;
        this.noN = 0;
        this.noP = 0;
        this.noR = false;
        this.noS = 0;
        this.noT = 0;
        this.lda = new C7306ak(Looper.getMainLooper());
        this.noV = true;
        this.noW = new C32701();
        this.noX = new C32712();
        this.noY = new C32693();
        this.noZ = new C32724();
        this.npa = new C32675();
        this.npb = new C32686();
        if (assetFileDescriptor == null) {
            NullPointerException nullPointerException = new NullPointerException("assert file Descriptor is null.");
            AppMethodBeat.m2505o(62389);
            throw nullPointerException;
        }
        boolean z = WXHardCoderJNI.hcGifEnable;
        int i2 = WXHardCoderJNI.hcGifDelay;
        int i3 = WXHardCoderJNI.hcGifCPU;
        int i4 = WXHardCoderJNI.hcGifIO;
        if (WXHardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.ehv = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.noC = assetFileDescriptor;
        this.noB = MMGIFJNI.openByFileDescroptor(this.noC.getFileDescriptor(), assetFileDescriptor.getStartOffset(), this.noD);
        init();
        AppMethodBeat.m2505o(62389);
    }

    public C3266d(InputStream inputStream) {
        int i = 0;
        AppMethodBeat.m2504i(62390);
        this.mIsRunning = true;
        this.noA = false;
        this.noC = null;
        this.noD = new int[6];
        this.noE = 1.0f;
        this.noF = 1.0f;
        this.f1266Hx = new Rect();
        this.mPaint = new Paint(6);
        this.noI = 0;
        this.noJ = -1;
        this.noK = 0;
        this.noL = 0;
        this.noM = 0;
        this.noN = 0;
        this.noP = 0;
        this.noR = false;
        this.noS = 0;
        this.noT = 0;
        this.lda = new C7306ak(Looper.getMainLooper());
        this.noV = true;
        this.noW = new C32701();
        this.noX = new C32712();
        this.noY = new C32693();
        this.noZ = new C32724();
        this.npa = new C32675();
        this.npb = new C32686();
        if (inputStream == null) {
            NullPointerException nullPointerException = new NullPointerException("input stream is null.");
            AppMethodBeat.m2505o(62390);
            throw nullPointerException;
        }
        boolean z = WXHardCoderJNI.hcGifEnable;
        int i2 = WXHardCoderJNI.hcGifDelay;
        int i3 = WXHardCoderJNI.hcGifCPU;
        int i4 = WXHardCoderJNI.hcGifIO;
        if (WXHardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.ehv = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.noB = MMGIFJNI.openByInputStrem(inputStream, this.noD);
        init();
        AppMethodBeat.m2505o(62390);
    }

    public C3266d(byte[] bArr) {
        int i = 0;
        AppMethodBeat.m2504i(62391);
        this.mIsRunning = true;
        this.noA = false;
        this.noC = null;
        this.noD = new int[6];
        this.noE = 1.0f;
        this.noF = 1.0f;
        this.f1266Hx = new Rect();
        this.mPaint = new Paint(6);
        this.noI = 0;
        this.noJ = -1;
        this.noK = 0;
        this.noL = 0;
        this.noM = 0;
        this.noN = 0;
        this.noP = 0;
        this.noR = false;
        this.noS = 0;
        this.noT = 0;
        this.lda = new C7306ak(Looper.getMainLooper());
        this.noV = true;
        this.noW = new C32701();
        this.noX = new C32712();
        this.noY = new C32693();
        this.noZ = new C32724();
        this.npa = new C32675();
        this.npb = new C32686();
        if (bArr == null) {
            NullPointerException nullPointerException = new NullPointerException("bytes is null.");
            AppMethodBeat.m2505o(62391);
            throw nullPointerException;
        }
        boolean z = WXHardCoderJNI.hcGifEnable;
        int i2 = WXHardCoderJNI.hcGifDelay;
        int i3 = WXHardCoderJNI.hcGifCPU;
        int i4 = WXHardCoderJNI.hcGifIO;
        if (WXHardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.ehv = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.noB = MMGIFJNI.openByByteArray(bArr, this.noD);
        init();
        AppMethodBeat.m2505o(62391);
    }

    private void init() {
        AppMethodBeat.m2504i(62392);
        C4990ab.m7417i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", Long.valueOf(this.noB));
        this.noI = this.noD[2];
        this.noQ = C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.a1h);
        if (this.noD[0] > 1024 || this.noD[1] > 1024) {
            C4990ab.m7421w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", Integer.valueOf(this.noD[0]), Integer.valueOf(this.noD[1]));
            this.noH = new int[(this.noQ * this.noQ)];
            this.noR = true;
            C7060h.pYm.mo8378a(401, 2, 1, false);
            AppMethodBeat.m2505o(62392);
            return;
        }
        this.noH = new int[(this.noD[0] * this.noD[1])];
        AppMethodBeat.m2505o(62392);
    }

    public final float getEmojiDensityScale() {
        AppMethodBeat.m2504i(62393);
        if (this.mDensity == 0.0f) {
            this.mDensity = C1338a.getDensity(C4996ah.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        float f = this.mDensity;
        AppMethodBeat.m2505o(62393);
        return f;
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.m2504i(62394);
        int emojiDensityScale = (int) (((float) this.noD[0]) * getEmojiDensityScale());
        AppMethodBeat.m2505o(62394);
        return emojiDensityScale;
    }

    public final int getIntrinsicHeight() {
        AppMethodBeat.m2504i(62395);
        int emojiDensityScale = (int) (((float) this.noD[1]) * getEmojiDensityScale());
        AppMethodBeat.m2505o(62395);
        return emojiDensityScale;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        AppMethodBeat.m2504i(62396);
        super.onBoundsChange(rect);
        this.noG = true;
        AppMethodBeat.m2505o(62396);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(62397);
        if (this.noG) {
            this.f1266Hx.set(getBounds());
            this.noE = ((float) this.f1266Hx.width()) / ((float) this.noD[0]);
            this.noF = ((float) this.f1266Hx.height()) / ((float) this.noD[1]);
            this.noG = false;
        }
        if (this.mPaint.getShader() == null) {
            if (this.noN == 0) {
                this.noN = System.currentTimeMillis();
            }
            canvas.scale(this.noE, this.noF);
            int[] iArr = this.noH;
            if (iArr == null) {
                C4990ab.m7412e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
            } else if (iArr.length == this.noD[0] * this.noD[1]) {
                canvas.drawBitmap(iArr, 0, this.noD[0], 0.0f, 0.0f, this.noD[0], this.noD[1], true, this.mPaint);
            } else {
                canvas.drawRGB(230, 230, 230);
                C4990ab.m7421w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", Integer.valueOf(iArr.length), Integer.valueOf(this.noD[0]), Integer.valueOf(this.noD[1]));
            }
            this.noO = System.currentTimeMillis() - this.noN;
            if (this.noR || this.noD[2] <= 0) {
                C4990ab.m7413e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", Integer.valueOf(this.noD[2]), Integer.valueOf(this.noD[4]), Boolean.valueOf(this.noR));
            } else {
                if (this.noD[4] < 0) {
                    C4990ab.m7416i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
                }
                if (this.noS != 0 && this.noT > this.noS - 1) {
                    m5591k(this.noW, 0);
                    AppMethodBeat.m2505o(62397);
                    return;
                } else if (this.noV) {
                    C37472a.m63215h(this.npb, 0);
                    this.noV = false;
                    AppMethodBeat.m2505o(62397);
                    return;
                }
            }
            AppMethodBeat.m2505o(62397);
            return;
        }
        C4990ab.m7416i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
        canvas.drawRect(this.f1266Hx, this.mPaint);
        AppMethodBeat.m2505o(62397);
    }

    public final int getOpacity() {
        return -2;
    }

    public final void setAlpha(int i) {
        AppMethodBeat.m2504i(62398);
        this.mPaint.setAlpha(i);
        AppMethodBeat.m2505o(62398);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.m2504i(62399);
        this.mPaint.setColorFilter(colorFilter);
        AppMethodBeat.m2505o(62399);
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    public final void start() {
        AppMethodBeat.m2504i(62400);
        this.mIsRunning = true;
        C37472a.m63215h(this.noY, 0);
        AppMethodBeat.m2505o(62400);
    }

    public final void stop() {
        boolean z = true;
        AppMethodBeat.m2504i(62401);
        C4990ab.m7410d("MicroMsg.GIF.MMGIFDrawable", "stop");
        this.mIsRunning = false;
        if (this.ehv != 0) {
            C4990ab.m7417i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", Integer.valueOf(this.ehv));
            if (!(WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable)) {
                z = false;
            }
            WXHardCoderJNI.stopPerformance(z, this.ehv);
            this.ehv = 0;
        }
        C37472a.m63215h(this.npa, 300);
        AppMethodBeat.m2505o(62401);
    }

    public final void pause() {
        this.mIsRunning = false;
    }

    public final void resume() {
        AppMethodBeat.m2504i(62402);
        if (!this.noA) {
            this.mIsRunning = true;
            m5591k(this.noX, 0);
        }
        AppMethodBeat.m2505o(62402);
    }

    public final void reset() {
        AppMethodBeat.m2504i(62403);
        this.noA = false;
        this.mIsRunning = true;
        C37472a.m63215h(this.noZ, 0);
        AppMethodBeat.m2505o(62403);
    }

    public final void recycle() {
        AppMethodBeat.m2504i(62404);
        C4990ab.m7410d("MicroMsg.GIF.MMGIFDrawable", "recycle");
        this.noA = true;
        this.mIsRunning = false;
        long j = this.noB;
        this.noB = 0;
        MMGIFJNI.recycle(j);
        this.noH = null;
        if (this.noC != null) {
            try {
                this.noC.close();
                AppMethodBeat.m2505o(62404);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(62404);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(62405);
        try {
            recycle();
            AppMethodBeat.m2505o(62405);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.m2505o(62405);
        }
    }

    public final int bFO() {
        return this.noD[0];
    }

    public final int bFP() {
        return this.noD[1];
    }
}
