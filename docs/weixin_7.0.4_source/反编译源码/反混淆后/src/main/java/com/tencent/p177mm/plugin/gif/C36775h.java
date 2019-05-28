package com.tencent.p177mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.p1526as.C37472a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.gif.h */
public final class C36775h extends C34323b {
    /* renamed from: Hx */
    private final Rect f15475Hx;
    private int ehv;
    private C7306ak lda;
    private float mDensity;
    private int mHeight;
    private boolean mIsRunning;
    private final Paint mPaint;
    private int mWidth;
    private boolean noA;
    private int[] noD;
    private float noE;
    private float noF;
    private boolean noG;
    private int noI;
    private int noJ;
    private long noK;
    private long noL;
    private long noM;
    private long noN;
    private long noO;
    private long noP;
    private boolean noV;
    private final Runnable noX;
    private final Runnable noY;
    private final Runnable noZ;
    private final Runnable npb;
    private volatile long npq;
    private int[] npr;
    private Bitmap nps;
    private boolean npt;

    /* renamed from: com.tencent.mm.plugin.gif.h$1 */
    class C32781 implements Runnable {
        C32781() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62425);
            if (!C36775h.this.noA && ((C36775h.this.isRunning() || C36775h.this.noJ == 0) && SystemClock.uptimeMillis() >= C36775h.this.noP)) {
                C36775h.this.noN = System.currentTimeMillis();
                C36775h.this.noV = true;
                C36775h.this.invalidateSelf();
            }
            AppMethodBeat.m2505o(62425);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gif.h$2 */
    class C343242 implements Runnable {
        C343242() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62426);
            C36775h.m61046a(C36775h.this, C36775h.this.noX, C36775h.this.noM);
            AppMethodBeat.m2505o(62426);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gif.h$3 */
    class C367763 implements Runnable {
        C367763() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62427);
            C36775h.this.noJ = -1;
            MMWXGFJNI.nativeRewindBuffer(C36775h.this.npq);
            C36775h.m61046a(C36775h.this, C36775h.this.noX, 0);
            AppMethodBeat.m2505o(62427);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gif.h$4 */
    class C367774 implements Runnable {
        C367774() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62428);
            if (C36775h.this.npt) {
                C4990ab.m7410d("MicroMsg.GIF.MMWXGFDrawable", "Cpan Render Task is Running.");
                AppMethodBeat.m2505o(62428);
            } else if (C36775h.this.noA) {
                C4990ab.m7416i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF had been recycle.");
                AppMethodBeat.m2505o(62428);
            } else if (C36775h.this.nps == null || C36775h.this.nps.isRecycled()) {
                C4990ab.m7416i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF is null or had been recycle.");
                AppMethodBeat.m2505o(62428);
            } else if (C36775h.this.npq == 0) {
                C4990ab.m7416i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF JNIHandle is null.");
                C7060h.pYm.mo8378a(401, 18, 1, false);
                AppMethodBeat.m2505o(62428);
            } else {
                C36775h.this.npt = true;
                long currentTimeMillis = System.currentTimeMillis();
                int nativeDecodeBufferFrame = MMWXGFJNI.nativeDecodeBufferFrame(C36775h.this.npq, null, 0, C36775h.this.nps, C36775h.this.npr);
                if (nativeDecodeBufferFrame == -904) {
                    C4990ab.m7416i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. func is null.");
                    C7060h.pYm.mo8378a(401, 8, 1, false);
                    AppMethodBeat.m2505o(62428);
                    return;
                }
                if (nativeDecodeBufferFrame == -909) {
                    C4990ab.m7416i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. frame is null.");
                    C7060h.pYm.mo8378a(401, 11, 1, false);
                } else if (nativeDecodeBufferFrame == -1) {
                    C4990ab.m7416i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed.");
                    AppMethodBeat.m2505o(62428);
                    return;
                }
                C36775h.this.noJ = C36775h.this.noJ + 1;
                if (C36775h.this.noJ >= C36775h.this.noI - 1 || nativeDecodeBufferFrame == 1) {
                    C36775h.this.noJ = -1;
                    nativeDecodeBufferFrame = MMWXGFJNI.nativeRewindBuffer(C36775h.this.npq);
                    if (nativeDecodeBufferFrame != 0) {
                        if (nativeDecodeBufferFrame == -905) {
                            C7060h.pYm.mo8378a(711, 9, 1, false);
                        }
                        C4990ab.m7420w("MicroMsg.GIF.MMWXGFDrawable", "Cpan Rewind buffer failed.");
                        AppMethodBeat.m2505o(62428);
                        return;
                    }
                }
                C36775h.this.noK = System.currentTimeMillis() - currentTimeMillis;
                if (C36775h.this.noL != 0) {
                    C36775h.this.noM = (C36775h.this.noL - C36775h.this.noK) - C36775h.this.noO;
                    if (C36775h.this.noM < 0) {
                        C4990ab.m7411d("MicroMsg.GIF.MMWXGFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", Long.valueOf(C36775h.this.noK), Long.valueOf(C36775h.this.noO), Long.valueOf(C36775h.this.noM), Long.valueOf(C36775h.this.noL), Integer.valueOf(C36775h.this.noJ));
                        if (C36775h.this.noM < -100) {
                            C7060h.pYm.mo8378a(401, 16, 1, false);
                            C7060h.pYm.mo8378a(401, 17, Math.abs(C36775h.this.noM), false);
                            boolean z = WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable;
                            WXHardCoderJNI.stopPerformance(z, C36775h.this.ehv);
                            C36775h.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifFrameEnable, WXHardCoderJNI.hcGifFrameDelay, WXHardCoderJNI.hcGifFrameCPU, WXHardCoderJNI.hcGifFrameIO, WXHardCoderJNI.hcGifFrameThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMWXGFDrawable");
                        }
                    }
                }
                C36775h.m61046a(C36775h.this, C36775h.this.noX, C36775h.this.noM > 0 ? C36775h.this.noM : 0);
                C36775h.this.noL = (long) (C36775h.this.npr[0] > 0 ? C36775h.this.npr[0] : 100);
                C36775h.this.npt = false;
                AppMethodBeat.m2505o(62428);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m61046a(C36775h c36775h, Runnable runnable, long j) {
        AppMethodBeat.m2504i(62445);
        c36775h.m61063k(runnable, j);
        AppMethodBeat.m2505o(62445);
    }

    /* renamed from: k */
    private void m61063k(Runnable runnable, long j) {
        AppMethodBeat.m2504i(62429);
        this.noP = SystemClock.uptimeMillis() + j;
        if (this.lda != null) {
            this.lda.postAtTime(runnable, this.noP);
        }
        AppMethodBeat.m2505o(62429);
    }

    public C36775h(String str) {
        this(C5730e.m8632e(str, 0, (int) C5730e.asZ(str)));
        AppMethodBeat.m2504i(62430);
        AppMethodBeat.m2505o(62430);
    }

    public C36775h(byte[] bArr) {
        AppMethodBeat.m2504i(62431);
        this.mIsRunning = false;
        this.noA = false;
        this.noD = new int[4];
        this.npr = new int[4];
        this.noE = 1.0f;
        this.noF = 1.0f;
        this.f15475Hx = new Rect();
        this.mPaint = new Paint(6);
        this.noI = 0;
        this.noJ = -1;
        this.noK = 0;
        this.noL = 0;
        this.noM = 0;
        this.noN = 0;
        this.noP = 0;
        this.npt = false;
        this.lda = new C7306ak(Looper.getMainLooper());
        this.noV = true;
        this.noX = new C32781();
        this.noY = new C343242();
        this.noZ = new C367763();
        this.npb = new C367774();
        if (bArr == null) {
            NullPointerException nullPointerException = new NullPointerException("bytes is null.");
            AppMethodBeat.m2505o(62431);
            throw nullPointerException;
        }
        this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifEnable, WXHardCoderJNI.hcGifDelay, WXHardCoderJNI.hcGifCPU, WXHardCoderJNI.hcGifIO, WXHardCoderJNI.hcGifThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMWXGFDrawable");
        this.npq = MMWXGFJNI.nativeInitWxAMDecoder();
        if (this.npq == 0 || this.npq == -901) {
            C4990ab.m7421w("MicroMsg.GIF.MMWXGFDrawable", "Cpan init wxam decoder failed. mWXGFJNIHandle:%d", Long.valueOf(this.npq));
            if (this.npq == -901) {
                C7060h.pYm.mo8378a(711, 5, 1, false);
            }
            C7060h.pYm.mo8378a(711, 4, 1, false);
            MMGIFException mMGIFException = new MMGIFException(201);
            AppMethodBeat.m2505o(62431);
            throw mMGIFException;
        }
        int nativeDecodeBufferHeader = MMWXGFJNI.nativeDecodeBufferHeader(this.npq, bArr, bArr.length);
        MMGIFException mMGIFException2;
        if (nativeDecodeBufferHeader != 0) {
            C4990ab.m7421w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF decode buffer header failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -904) {
                C7060h.pYm.mo8378a(711, 8, 1, false);
            } else {
                C7060h.pYm.mo8378a(711, 3, 1, false);
            }
            mMGIFException2 = new MMGIFException(nativeDecodeBufferHeader);
            AppMethodBeat.m2505o(62431);
            throw mMGIFException2;
        }
        nativeDecodeBufferHeader = MMWXGFJNI.nativeGetOption(this.npq, bArr, bArr.length, this.noD);
        if (nativeDecodeBufferHeader != 0) {
            C4990ab.m7421w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF get option failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -903) {
                C7060h.pYm.mo8378a(711, 7, 1, false);
            } else {
                C7060h.pYm.mo8378a(711, 3, 1, false);
            }
            mMGIFException2 = new MMGIFException(nativeDecodeBufferHeader);
            AppMethodBeat.m2505o(62431);
            throw mMGIFException2;
        }
        this.noI = this.noD[0];
        this.mWidth = this.noD[1];
        this.mHeight = this.noD[2];
        if (this.mWidth == 0 || this.mHeight == 0) {
            nativeDecodeBufferHeader = C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.a1h);
            this.mHeight = nativeDecodeBufferHeader;
            this.mWidth = nativeDecodeBufferHeader;
        }
        this.nps = Bitmap.createBitmap(this.mWidth, this.mHeight, Config.ARGB_8888);
        AppMethodBeat.m2505o(62431);
    }

    public final float getEmojiDensityScale() {
        AppMethodBeat.m2504i(62432);
        if (this.mDensity == 0.0f) {
            this.mDensity = C1338a.getDensity(C4996ah.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        float f = this.mDensity;
        AppMethodBeat.m2505o(62432);
        return f;
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.m2504i(62433);
        int emojiDensityScale = (int) (((float) this.mWidth) * getEmojiDensityScale());
        AppMethodBeat.m2505o(62433);
        return emojiDensityScale;
    }

    public final int getIntrinsicHeight() {
        AppMethodBeat.m2504i(62434);
        int emojiDensityScale = (int) (((float) this.mHeight) * getEmojiDensityScale());
        AppMethodBeat.m2505o(62434);
        return emojiDensityScale;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        AppMethodBeat.m2504i(62435);
        super.onBoundsChange(rect);
        this.noG = true;
        AppMethodBeat.m2505o(62435);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(62436);
        if (this.noG) {
            this.f15475Hx.set(getBounds());
            this.noE = ((float) this.f15475Hx.width()) / ((float) this.mWidth);
            this.noF = ((float) this.f15475Hx.height()) / ((float) this.mHeight);
            this.noG = false;
        }
        if (this.mPaint.getShader() == null) {
            if (this.noN == 0) {
                this.noN = System.currentTimeMillis();
            }
            canvas.scale(this.noE, this.noF);
            if (this.nps == null || this.nps.isRecycled() || this.noA) {
                C4990ab.m7412e("MicroMsg.GIF.MMWXGFDrawable", "Cpan draw bitmap failed. Bitmap buffer is null or recycle");
            } else {
                canvas.drawBitmap(this.nps, 0.0f, 0.0f, this.mPaint);
            }
            this.noO = System.currentTimeMillis() - this.noN;
            if (this.noV) {
                C37472a.m63215h(this.npb, 0);
                this.noV = false;
                AppMethodBeat.m2505o(62436);
                return;
            }
        }
        canvas.drawRect(this.f15475Hx, this.mPaint);
        AppMethodBeat.m2505o(62436);
    }

    public final void setAlpha(int i) {
        AppMethodBeat.m2504i(62437);
        this.mPaint.setAlpha(i);
        AppMethodBeat.m2505o(62437);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.m2504i(62438);
        this.mPaint.setColorFilter(colorFilter);
        AppMethodBeat.m2505o(62438);
    }

    public final int getOpacity() {
        return -2;
    }

    public final void start() {
        AppMethodBeat.m2504i(62439);
        this.mIsRunning = true;
        C37472a.m63215h(this.noY, 0);
        AppMethodBeat.m2505o(62439);
    }

    public final void stop() {
        boolean z = true;
        AppMethodBeat.m2504i(62440);
        this.mIsRunning = false;
        if (this.ehv != 0) {
            C4990ab.m7417i("MicroMsg.GIF.MMWXGFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", Integer.valueOf(this.ehv));
            if (!(WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable)) {
                z = false;
            }
            WXHardCoderJNI.stopPerformance(z, this.ehv);
            this.ehv = 0;
        }
        AppMethodBeat.m2505o(62440);
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(62441);
        try {
            recycle();
            AppMethodBeat.m2505o(62441);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.GIF.MMWXGFDrawable", th, "", new Object[0]);
            super.finalize();
            AppMethodBeat.m2505o(62441);
        }
    }

    public final void pause() {
        this.mIsRunning = false;
    }

    public final void resume() {
        AppMethodBeat.m2504i(62442);
        if (!this.noA) {
            this.mIsRunning = true;
            m61063k(this.noX, 0);
        }
        AppMethodBeat.m2505o(62442);
    }

    public final void reset() {
        AppMethodBeat.m2504i(62443);
        this.mIsRunning = true;
        C37472a.m63215h(this.noZ, 0);
        AppMethodBeat.m2505o(62443);
    }

    public final synchronized void recycle() {
        AppMethodBeat.m2504i(62444);
        C4990ab.m7419v("MicroMsg.GIF.MMWXGFDrawable", "Cpan recycle decode handle:%d", Long.valueOf(this.npq));
        this.noA = true;
        this.mIsRunning = false;
        long j = this.npq;
        this.npq = 0;
        this.lda.removeCallbacks(this.noX);
        int nativeUninit = MMWXGFJNI.nativeUninit(j);
        if (nativeUninit == -906) {
            C7060h.pYm.mo8378a(401, 10, 1, false);
        }
        C4990ab.m7411d("MicroMsg.GIF.MMWXGFDrawable", "nativeUninit result:%d mWXGFJNIHandle:%s mIsRender:%b", Integer.valueOf(nativeUninit), Long.valueOf(j), Boolean.valueOf(this.npt));
        if (!(j == 0 || nativeUninit != 0 || this.nps == null)) {
            this.nps.isRecycled();
        }
        this.nps = null;
        AppMethodBeat.m2505o(62444);
    }

    public final int bFO() {
        return this.noD[1];
    }

    public final int bFP() {
        return this.noD[2];
    }
}
