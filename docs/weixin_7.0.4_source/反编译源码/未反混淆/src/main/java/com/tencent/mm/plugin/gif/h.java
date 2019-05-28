package com.tencent.mm.plugin.gif;

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
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.e;

public final class h extends b {
    private final Rect Hx;
    private int ehv;
    private ak lda;
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

    static /* synthetic */ void a(h hVar, Runnable runnable, long j) {
        AppMethodBeat.i(62445);
        hVar.k(runnable, j);
        AppMethodBeat.o(62445);
    }

    private void k(Runnable runnable, long j) {
        AppMethodBeat.i(62429);
        this.noP = SystemClock.uptimeMillis() + j;
        if (this.lda != null) {
            this.lda.postAtTime(runnable, this.noP);
        }
        AppMethodBeat.o(62429);
    }

    public h(String str) {
        this(e.e(str, 0, (int) e.asZ(str)));
        AppMethodBeat.i(62430);
        AppMethodBeat.o(62430);
    }

    public h(byte[] bArr) {
        AppMethodBeat.i(62431);
        this.mIsRunning = false;
        this.noA = false;
        this.noD = new int[4];
        this.npr = new int[4];
        this.noE = 1.0f;
        this.noF = 1.0f;
        this.Hx = new Rect();
        this.mPaint = new Paint(6);
        this.noI = 0;
        this.noJ = -1;
        this.noK = 0;
        this.noL = 0;
        this.noM = 0;
        this.noN = 0;
        this.noP = 0;
        this.npt = false;
        this.lda = new ak(Looper.getMainLooper());
        this.noV = true;
        this.noX = new Runnable() {
            public final void run() {
                AppMethodBeat.i(62425);
                if (!h.this.noA && ((h.this.isRunning() || h.this.noJ == 0) && SystemClock.uptimeMillis() >= h.this.noP)) {
                    h.this.noN = System.currentTimeMillis();
                    h.this.noV = true;
                    h.this.invalidateSelf();
                }
                AppMethodBeat.o(62425);
            }
        };
        this.noY = new Runnable() {
            public final void run() {
                AppMethodBeat.i(62426);
                h.a(h.this, h.this.noX, h.this.noM);
                AppMethodBeat.o(62426);
            }
        };
        this.noZ = new Runnable() {
            public final void run() {
                AppMethodBeat.i(62427);
                h.this.noJ = -1;
                MMWXGFJNI.nativeRewindBuffer(h.this.npq);
                h.a(h.this, h.this.noX, 0);
                AppMethodBeat.o(62427);
            }
        };
        this.npb = new Runnable() {
            public final void run() {
                AppMethodBeat.i(62428);
                if (h.this.npt) {
                    ab.d("MicroMsg.GIF.MMWXGFDrawable", "Cpan Render Task is Running.");
                    AppMethodBeat.o(62428);
                } else if (h.this.noA) {
                    ab.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF had been recycle.");
                    AppMethodBeat.o(62428);
                } else if (h.this.nps == null || h.this.nps.isRecycled()) {
                    ab.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF is null or had been recycle.");
                    AppMethodBeat.o(62428);
                } else if (h.this.npq == 0) {
                    ab.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF JNIHandle is null.");
                    com.tencent.mm.plugin.report.service.h.pYm.a(401, 18, 1, false);
                    AppMethodBeat.o(62428);
                } else {
                    h.this.npt = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    int nativeDecodeBufferFrame = MMWXGFJNI.nativeDecodeBufferFrame(h.this.npq, null, 0, h.this.nps, h.this.npr);
                    if (nativeDecodeBufferFrame == -904) {
                        ab.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. func is null.");
                        com.tencent.mm.plugin.report.service.h.pYm.a(401, 8, 1, false);
                        AppMethodBeat.o(62428);
                        return;
                    }
                    if (nativeDecodeBufferFrame == -909) {
                        ab.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. frame is null.");
                        com.tencent.mm.plugin.report.service.h.pYm.a(401, 11, 1, false);
                    } else if (nativeDecodeBufferFrame == -1) {
                        ab.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed.");
                        AppMethodBeat.o(62428);
                        return;
                    }
                    h.this.noJ = h.this.noJ + 1;
                    if (h.this.noJ >= h.this.noI - 1 || nativeDecodeBufferFrame == 1) {
                        h.this.noJ = -1;
                        nativeDecodeBufferFrame = MMWXGFJNI.nativeRewindBuffer(h.this.npq);
                        if (nativeDecodeBufferFrame != 0) {
                            if (nativeDecodeBufferFrame == -905) {
                                com.tencent.mm.plugin.report.service.h.pYm.a(711, 9, 1, false);
                            }
                            ab.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan Rewind buffer failed.");
                            AppMethodBeat.o(62428);
                            return;
                        }
                    }
                    h.this.noK = System.currentTimeMillis() - currentTimeMillis;
                    if (h.this.noL != 0) {
                        h.this.noM = (h.this.noL - h.this.noK) - h.this.noO;
                        if (h.this.noM < 0) {
                            ab.d("MicroMsg.GIF.MMWXGFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", Long.valueOf(h.this.noK), Long.valueOf(h.this.noO), Long.valueOf(h.this.noM), Long.valueOf(h.this.noL), Integer.valueOf(h.this.noJ));
                            if (h.this.noM < -100) {
                                com.tencent.mm.plugin.report.service.h.pYm.a(401, 16, 1, false);
                                com.tencent.mm.plugin.report.service.h.pYm.a(401, 17, Math.abs(h.this.noM), false);
                                boolean z = WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable;
                                WXHardCoderJNI.stopPerformance(z, h.this.ehv);
                                h.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifFrameEnable, WXHardCoderJNI.hcGifFrameDelay, WXHardCoderJNI.hcGifFrameCPU, WXHardCoderJNI.hcGifFrameIO, WXHardCoderJNI.hcGifFrameThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMWXGFDrawable");
                            }
                        }
                    }
                    h.a(h.this, h.this.noX, h.this.noM > 0 ? h.this.noM : 0);
                    h.this.noL = (long) (h.this.npr[0] > 0 ? h.this.npr[0] : 100);
                    h.this.npt = false;
                    AppMethodBeat.o(62428);
                }
            }
        };
        if (bArr == null) {
            NullPointerException nullPointerException = new NullPointerException("bytes is null.");
            AppMethodBeat.o(62431);
            throw nullPointerException;
        }
        this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifEnable, WXHardCoderJNI.hcGifDelay, WXHardCoderJNI.hcGifCPU, WXHardCoderJNI.hcGifIO, WXHardCoderJNI.hcGifThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMWXGFDrawable");
        this.npq = MMWXGFJNI.nativeInitWxAMDecoder();
        if (this.npq == 0 || this.npq == -901) {
            ab.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan init wxam decoder failed. mWXGFJNIHandle:%d", Long.valueOf(this.npq));
            if (this.npq == -901) {
                com.tencent.mm.plugin.report.service.h.pYm.a(711, 5, 1, false);
            }
            com.tencent.mm.plugin.report.service.h.pYm.a(711, 4, 1, false);
            MMGIFException mMGIFException = new MMGIFException(201);
            AppMethodBeat.o(62431);
            throw mMGIFException;
        }
        int nativeDecodeBufferHeader = MMWXGFJNI.nativeDecodeBufferHeader(this.npq, bArr, bArr.length);
        MMGIFException mMGIFException2;
        if (nativeDecodeBufferHeader != 0) {
            ab.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF decode buffer header failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -904) {
                com.tencent.mm.plugin.report.service.h.pYm.a(711, 8, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.a(711, 3, 1, false);
            }
            mMGIFException2 = new MMGIFException(nativeDecodeBufferHeader);
            AppMethodBeat.o(62431);
            throw mMGIFException2;
        }
        nativeDecodeBufferHeader = MMWXGFJNI.nativeGetOption(this.npq, bArr, bArr.length, this.noD);
        if (nativeDecodeBufferHeader != 0) {
            ab.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF get option failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -903) {
                com.tencent.mm.plugin.report.service.h.pYm.a(711, 7, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.a(711, 3, 1, false);
            }
            mMGIFException2 = new MMGIFException(nativeDecodeBufferHeader);
            AppMethodBeat.o(62431);
            throw mMGIFException2;
        }
        this.noI = this.noD[0];
        this.mWidth = this.noD[1];
        this.mHeight = this.noD[2];
        if (this.mWidth == 0 || this.mHeight == 0) {
            nativeDecodeBufferHeader = a.al(ah.getContext(), R.dimen.a1h);
            this.mHeight = nativeDecodeBufferHeader;
            this.mWidth = nativeDecodeBufferHeader;
        }
        this.nps = Bitmap.createBitmap(this.mWidth, this.mHeight, Config.ARGB_8888);
        AppMethodBeat.o(62431);
    }

    public final float getEmojiDensityScale() {
        AppMethodBeat.i(62432);
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(ah.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        float f = this.mDensity;
        AppMethodBeat.o(62432);
        return f;
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.i(62433);
        int emojiDensityScale = (int) (((float) this.mWidth) * getEmojiDensityScale());
        AppMethodBeat.o(62433);
        return emojiDensityScale;
    }

    public final int getIntrinsicHeight() {
        AppMethodBeat.i(62434);
        int emojiDensityScale = (int) (((float) this.mHeight) * getEmojiDensityScale());
        AppMethodBeat.o(62434);
        return emojiDensityScale;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        AppMethodBeat.i(62435);
        super.onBoundsChange(rect);
        this.noG = true;
        AppMethodBeat.o(62435);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(62436);
        if (this.noG) {
            this.Hx.set(getBounds());
            this.noE = ((float) this.Hx.width()) / ((float) this.mWidth);
            this.noF = ((float) this.Hx.height()) / ((float) this.mHeight);
            this.noG = false;
        }
        if (this.mPaint.getShader() == null) {
            if (this.noN == 0) {
                this.noN = System.currentTimeMillis();
            }
            canvas.scale(this.noE, this.noF);
            if (this.nps == null || this.nps.isRecycled() || this.noA) {
                ab.e("MicroMsg.GIF.MMWXGFDrawable", "Cpan draw bitmap failed. Bitmap buffer is null or recycle");
            } else {
                canvas.drawBitmap(this.nps, 0.0f, 0.0f, this.mPaint);
            }
            this.noO = System.currentTimeMillis() - this.noN;
            if (this.noV) {
                com.tencent.mm.as.a.h(this.npb, 0);
                this.noV = false;
                AppMethodBeat.o(62436);
                return;
            }
        }
        canvas.drawRect(this.Hx, this.mPaint);
        AppMethodBeat.o(62436);
    }

    public final void setAlpha(int i) {
        AppMethodBeat.i(62437);
        this.mPaint.setAlpha(i);
        AppMethodBeat.o(62437);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(62438);
        this.mPaint.setColorFilter(colorFilter);
        AppMethodBeat.o(62438);
    }

    public final int getOpacity() {
        return -2;
    }

    public final void start() {
        AppMethodBeat.i(62439);
        this.mIsRunning = true;
        com.tencent.mm.as.a.h(this.noY, 0);
        AppMethodBeat.o(62439);
    }

    public final void stop() {
        boolean z = true;
        AppMethodBeat.i(62440);
        this.mIsRunning = false;
        if (this.ehv != 0) {
            ab.i("MicroMsg.GIF.MMWXGFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", Integer.valueOf(this.ehv));
            if (!(WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable)) {
                z = false;
            }
            WXHardCoderJNI.stopPerformance(z, this.ehv);
            this.ehv = 0;
        }
        AppMethodBeat.o(62440);
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(62441);
        try {
            recycle();
            AppMethodBeat.o(62441);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.GIF.MMWXGFDrawable", th, "", new Object[0]);
            super.finalize();
            AppMethodBeat.o(62441);
        }
    }

    public final void pause() {
        this.mIsRunning = false;
    }

    public final void resume() {
        AppMethodBeat.i(62442);
        if (!this.noA) {
            this.mIsRunning = true;
            k(this.noX, 0);
        }
        AppMethodBeat.o(62442);
    }

    public final void reset() {
        AppMethodBeat.i(62443);
        this.mIsRunning = true;
        com.tencent.mm.as.a.h(this.noZ, 0);
        AppMethodBeat.o(62443);
    }

    public final synchronized void recycle() {
        AppMethodBeat.i(62444);
        ab.v("MicroMsg.GIF.MMWXGFDrawable", "Cpan recycle decode handle:%d", Long.valueOf(this.npq));
        this.noA = true;
        this.mIsRunning = false;
        long j = this.npq;
        this.npq = 0;
        this.lda.removeCallbacks(this.noX);
        int nativeUninit = MMWXGFJNI.nativeUninit(j);
        if (nativeUninit == -906) {
            com.tencent.mm.plugin.report.service.h.pYm.a(401, 10, 1, false);
        }
        ab.d("MicroMsg.GIF.MMWXGFDrawable", "nativeUninit result:%d mWXGFJNIHandle:%s mIsRender:%b", Integer.valueOf(nativeUninit), Long.valueOf(j), Boolean.valueOf(this.npt));
        if (!(j == 0 || nativeUninit != 0 || this.nps == null)) {
            this.nps.isRecycled();
        }
        this.nps = null;
        AppMethodBeat.o(62444);
    }

    public final int bFO() {
        return this.noD[1];
    }

    public final int bFP() {
        return this.noD[2];
    }
}
