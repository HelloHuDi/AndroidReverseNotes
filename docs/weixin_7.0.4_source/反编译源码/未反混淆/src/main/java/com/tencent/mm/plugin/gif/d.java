package com.tencent.mm.plugin.gif;

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
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.InputStream;

public final class d extends b {
    private final Rect Hx;
    private int ehv;
    private ak lda;
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
    k noU;
    private boolean noV;
    private final Runnable noW;
    private final Runnable noX;
    private final Runnable noY;
    private final Runnable noZ;
    private final Runnable npa;
    private final Runnable npb;

    static /* synthetic */ void a(d dVar, Runnable runnable, long j) {
        AppMethodBeat.i(62406);
        dVar.k(runnable, j);
        AppMethodBeat.o(62406);
    }

    private void k(Runnable runnable, long j) {
        AppMethodBeat.i(62386);
        this.noP = SystemClock.uptimeMillis() + j;
        if (this.lda != null) {
            this.lda.postAtTime(runnable, this.noP);
        }
        AppMethodBeat.o(62386);
    }

    public d(Resources resources, int i) {
        this(resources.openRawResourceFd(i));
        AppMethodBeat.i(62387);
        AppMethodBeat.o(62387);
    }

    public d(String str) {
        int i = 0;
        AppMethodBeat.i(62388);
        this.mIsRunning = true;
        this.noA = false;
        this.noC = null;
        this.noD = new int[6];
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
        this.noR = false;
        this.noS = 0;
        this.noT = 0;
        this.lda = new ak(Looper.getMainLooper());
        this.noV = true;
        this.noW = new Runnable() {
            public final void run() {
                AppMethodBeat.i(62380);
                if (d.this.noU != null) {
                    d.this.noU;
                }
                AppMethodBeat.o(62380);
            }
        };
        this.noX = new Runnable() {
            public final void run() {
                AppMethodBeat.i(62381);
                if ((d.this.isRunning() || d.this.noJ == 0) && SystemClock.uptimeMillis() >= d.this.noP) {
                    d.this.noN = System.currentTimeMillis();
                    d.this.noV = true;
                    d.this.invalidateSelf();
                    if (d.this.noU != null) {
                        d.this.noU.invalidate();
                    }
                }
                AppMethodBeat.o(62381);
            }
        };
        this.noY = new Runnable() {
            public final void run() {
                AppMethodBeat.i(62382);
                MMGIFJNI.restoreRemainder(d.this.noB);
                d.a(d.this, d.this.noX, d.this.noM);
                AppMethodBeat.o(62382);
            }
        };
        this.noZ = new Runnable() {
            public final void run() {
                AppMethodBeat.i(62383);
                MMGIFJNI.reset(d.this.noB);
                d.this.noJ = -1;
                d.a(d.this, d.this.noX, 0);
                AppMethodBeat.o(62383);
            }
        };
        this.npa = new Runnable() {
            public final void run() {
                AppMethodBeat.i(62384);
                MMGIFJNI.saveRemainder(d.this.noB);
                AppMethodBeat.o(62384);
            }
        };
        this.npb = new Runnable() {
            public final void run() {
                AppMethodBeat.i(62385);
                if (d.this.noA) {
                    ab.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
                    AppMethodBeat.o(62385);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (d.this.noJ + 1 > d.this.noI - 1) {
                    d.this.noJ = -1;
                }
                d.this.noJ = d.this.noJ + 1;
                if (MMGIFJNI.drawFramePixels(d.this.noB, d.this.noH, d.this.noD)) {
                    d.this.noT = d.this.noT + 1;
                }
                d.this.noK = System.currentTimeMillis() - currentTimeMillis;
                if (d.this.noL != 0) {
                    d.this.noM = (d.this.noL - d.this.noK) - d.this.noO;
                    if (d.this.noM < 0) {
                        ab.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", Long.valueOf(d.this.noK), Long.valueOf(d.this.noO), Long.valueOf(d.this.noM), Long.valueOf(d.this.noL), Integer.valueOf(d.this.noD[5]));
                        h.pYm.a(401, 0, 1, false);
                        h.pYm.a(401, 1, Math.abs(d.this.noM), false);
                        if (d.this.noM < -100) {
                            boolean z = WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable;
                            WXHardCoderJNI.stopPerformance(z, d.this.ehv);
                            d.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifFrameEnable, WXHardCoderJNI.hcGifFrameDelay, WXHardCoderJNI.hcGifFrameCPU, WXHardCoderJNI.hcGifFrameIO, WXHardCoderJNI.hcGifFrameThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable");
                        }
                    }
                }
                d.a(d.this, d.this.noX, d.this.noM > 0 ? d.this.noM : 0);
                if (d.this.noD[2] == 1) {
                    d.this.noL = 5000;
                    AppMethodBeat.o(62385);
                    return;
                }
                d.this.noL = (long) d.this.noD[4];
                AppMethodBeat.o(62385);
            }
        };
        if (TextUtils.isEmpty(str)) {
            NullPointerException nullPointerException = new NullPointerException("file path is null.");
            AppMethodBeat.o(62388);
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
        AppMethodBeat.o(62388);
    }

    private d(AssetFileDescriptor assetFileDescriptor) {
        int i = 0;
        AppMethodBeat.i(62389);
        this.mIsRunning = true;
        this.noA = false;
        this.noC = null;
        this.noD = new int[6];
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
        this.noR = false;
        this.noS = 0;
        this.noT = 0;
        this.lda = new ak(Looper.getMainLooper());
        this.noV = true;
        this.noW = /* anonymous class already generated */;
        this.noX = /* anonymous class already generated */;
        this.noY = /* anonymous class already generated */;
        this.noZ = /* anonymous class already generated */;
        this.npa = /* anonymous class already generated */;
        this.npb = /* anonymous class already generated */;
        if (assetFileDescriptor == null) {
            NullPointerException nullPointerException = new NullPointerException("assert file Descriptor is null.");
            AppMethodBeat.o(62389);
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
        AppMethodBeat.o(62389);
    }

    public d(InputStream inputStream) {
        int i = 0;
        AppMethodBeat.i(62390);
        this.mIsRunning = true;
        this.noA = false;
        this.noC = null;
        this.noD = new int[6];
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
        this.noR = false;
        this.noS = 0;
        this.noT = 0;
        this.lda = new ak(Looper.getMainLooper());
        this.noV = true;
        this.noW = /* anonymous class already generated */;
        this.noX = /* anonymous class already generated */;
        this.noY = /* anonymous class already generated */;
        this.noZ = /* anonymous class already generated */;
        this.npa = /* anonymous class already generated */;
        this.npb = /* anonymous class already generated */;
        if (inputStream == null) {
            NullPointerException nullPointerException = new NullPointerException("input stream is null.");
            AppMethodBeat.o(62390);
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
        AppMethodBeat.o(62390);
    }

    public d(byte[] bArr) {
        int i = 0;
        AppMethodBeat.i(62391);
        this.mIsRunning = true;
        this.noA = false;
        this.noC = null;
        this.noD = new int[6];
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
        this.noR = false;
        this.noS = 0;
        this.noT = 0;
        this.lda = new ak(Looper.getMainLooper());
        this.noV = true;
        this.noW = /* anonymous class already generated */;
        this.noX = /* anonymous class already generated */;
        this.noY = /* anonymous class already generated */;
        this.noZ = /* anonymous class already generated */;
        this.npa = /* anonymous class already generated */;
        this.npb = /* anonymous class already generated */;
        if (bArr == null) {
            NullPointerException nullPointerException = new NullPointerException("bytes is null.");
            AppMethodBeat.o(62391);
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
        AppMethodBeat.o(62391);
    }

    private void init() {
        AppMethodBeat.i(62392);
        ab.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", Long.valueOf(this.noB));
        this.noI = this.noD[2];
        this.noQ = a.al(ah.getContext(), R.dimen.a1h);
        if (this.noD[0] > 1024 || this.noD[1] > 1024) {
            ab.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", Integer.valueOf(this.noD[0]), Integer.valueOf(this.noD[1]));
            this.noH = new int[(this.noQ * this.noQ)];
            this.noR = true;
            h.pYm.a(401, 2, 1, false);
            AppMethodBeat.o(62392);
            return;
        }
        this.noH = new int[(this.noD[0] * this.noD[1])];
        AppMethodBeat.o(62392);
    }

    public final float getEmojiDensityScale() {
        AppMethodBeat.i(62393);
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(ah.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        float f = this.mDensity;
        AppMethodBeat.o(62393);
        return f;
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.i(62394);
        int emojiDensityScale = (int) (((float) this.noD[0]) * getEmojiDensityScale());
        AppMethodBeat.o(62394);
        return emojiDensityScale;
    }

    public final int getIntrinsicHeight() {
        AppMethodBeat.i(62395);
        int emojiDensityScale = (int) (((float) this.noD[1]) * getEmojiDensityScale());
        AppMethodBeat.o(62395);
        return emojiDensityScale;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        AppMethodBeat.i(62396);
        super.onBoundsChange(rect);
        this.noG = true;
        AppMethodBeat.o(62396);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(62397);
        if (this.noG) {
            this.Hx.set(getBounds());
            this.noE = ((float) this.Hx.width()) / ((float) this.noD[0]);
            this.noF = ((float) this.Hx.height()) / ((float) this.noD[1]);
            this.noG = false;
        }
        if (this.mPaint.getShader() == null) {
            if (this.noN == 0) {
                this.noN = System.currentTimeMillis();
            }
            canvas.scale(this.noE, this.noF);
            int[] iArr = this.noH;
            if (iArr == null) {
                ab.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
            } else if (iArr.length == this.noD[0] * this.noD[1]) {
                canvas.drawBitmap(iArr, 0, this.noD[0], 0.0f, 0.0f, this.noD[0], this.noD[1], true, this.mPaint);
            } else {
                canvas.drawRGB(230, 230, 230);
                ab.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", Integer.valueOf(iArr.length), Integer.valueOf(this.noD[0]), Integer.valueOf(this.noD[1]));
            }
            this.noO = System.currentTimeMillis() - this.noN;
            if (this.noR || this.noD[2] <= 0) {
                ab.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", Integer.valueOf(this.noD[2]), Integer.valueOf(this.noD[4]), Boolean.valueOf(this.noR));
            } else {
                if (this.noD[4] < 0) {
                    ab.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
                }
                if (this.noS != 0 && this.noT > this.noS - 1) {
                    k(this.noW, 0);
                    AppMethodBeat.o(62397);
                    return;
                } else if (this.noV) {
                    com.tencent.mm.as.a.h(this.npb, 0);
                    this.noV = false;
                    AppMethodBeat.o(62397);
                    return;
                }
            }
            AppMethodBeat.o(62397);
            return;
        }
        ab.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
        canvas.drawRect(this.Hx, this.mPaint);
        AppMethodBeat.o(62397);
    }

    public final int getOpacity() {
        return -2;
    }

    public final void setAlpha(int i) {
        AppMethodBeat.i(62398);
        this.mPaint.setAlpha(i);
        AppMethodBeat.o(62398);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(62399);
        this.mPaint.setColorFilter(colorFilter);
        AppMethodBeat.o(62399);
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    public final void start() {
        AppMethodBeat.i(62400);
        this.mIsRunning = true;
        com.tencent.mm.as.a.h(this.noY, 0);
        AppMethodBeat.o(62400);
    }

    public final void stop() {
        boolean z = true;
        AppMethodBeat.i(62401);
        ab.d("MicroMsg.GIF.MMGIFDrawable", "stop");
        this.mIsRunning = false;
        if (this.ehv != 0) {
            ab.i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", Integer.valueOf(this.ehv));
            if (!(WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable)) {
                z = false;
            }
            WXHardCoderJNI.stopPerformance(z, this.ehv);
            this.ehv = 0;
        }
        com.tencent.mm.as.a.h(this.npa, 300);
        AppMethodBeat.o(62401);
    }

    public final void pause() {
        this.mIsRunning = false;
    }

    public final void resume() {
        AppMethodBeat.i(62402);
        if (!this.noA) {
            this.mIsRunning = true;
            k(this.noX, 0);
        }
        AppMethodBeat.o(62402);
    }

    public final void reset() {
        AppMethodBeat.i(62403);
        this.noA = false;
        this.mIsRunning = true;
        com.tencent.mm.as.a.h(this.noZ, 0);
        AppMethodBeat.o(62403);
    }

    public final void recycle() {
        AppMethodBeat.i(62404);
        ab.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
        this.noA = true;
        this.mIsRunning = false;
        long j = this.noB;
        this.noB = 0;
        MMGIFJNI.recycle(j);
        this.noH = null;
        if (this.noC != null) {
            try {
                this.noC.close();
                AppMethodBeat.o(62404);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(62404);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(62405);
        try {
            recycle();
            AppMethodBeat.o(62405);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.o(62405);
        }
    }

    public final int bFO() {
        return this.noD[0];
    }

    public final int bFP() {
        return this.noD[1];
    }
}
