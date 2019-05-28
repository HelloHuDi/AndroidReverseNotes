package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.filter.h;
import com.tencent.filter.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.gles.GLConfig;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.util.i;
import com.tencent.view.g;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class ActVideoDecoder {
    private static final String TAG = ActVideoDecoder.class.getSimpleName();
    private static final int TIMEOUT_MS = 2500;
    private static final int TIMEOUT_US = 10000;
    private BufferInfo info = new BufferInfo();
    private ByteBuffer[] inputBuffers;
    private volatile boolean isDecoding;
    private boolean isEOS = false;
    private long mCurFrameIndex = -1;
    private MediaCodec mDecoder;
    private Surface mDecoderSurface;
    private int mDstTex;
    private long mDuration;
    private MediaExtractor mExtractor;
    private String mFilename;
    private h mFrame = new h();
    private boolean mFrameAvailable;
    private Handler mHandler;
    private boolean mHasNewFrame;
    private int mHeight;
    private final Object mInitLock = new Object();
    private boolean mInited;
    private long mLastFrameIndex = -1;
    private o mSurfaceTexFilter = new o();
    private SurfaceTexture mSurfaceTexture;
    private int mTempTex;
    private final float[] mTransformMatrix = new float[16];
    private final Object mUpdateFrameLock = new Object();
    private int mWidth;

    static /* synthetic */ int access$700(ActVideoDecoder actVideoDecoder) {
        AppMethodBeat.i(83691);
        int decodeNext = actVideoDecoder.decodeNext();
        AppMethodBeat.o(83691);
        return decodeNext;
    }

    static {
        AppMethodBeat.i(83692);
        AppMethodBeat.o(83692);
    }

    public ActVideoDecoder(String str, int i) {
        AppMethodBeat.i(83681);
        this.mFilename = str;
        this.mDstTex = i;
        this.mTempTex = g.dSO();
        this.mSurfaceTexFilter.ApplyGLSLFilter();
        this.mSurfaceTexFilter.nativeSetRotationAndFlip(0, 0, 1);
        HandlerThread handlerThread = new HandlerThread("ActVideoDecoder rt");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(83677);
                ActVideoDecoder.this.mSurfaceTexture = new SurfaceTexture(ActVideoDecoder.this.mTempTex);
                ActVideoDecoder.this.mSurfaceTexture.setOnFrameAvailableListener(new OnFrameAvailableListener() {
                    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                        AppMethodBeat.i(83676);
                        synchronized (ActVideoDecoder.this.mUpdateFrameLock) {
                            try {
                                if (ActVideoDecoder.this.mFrameAvailable) {
                                    Object runtimeException = new RuntimeException("mFrameAvailable already set, frame could be dropped");
                                    throw runtimeException;
                                }
                                ActVideoDecoder.this.mFrameAvailable = true;
                                ActVideoDecoder.this.mUpdateFrameLock.notifyAll();
                            } finally {
                                AppMethodBeat.o(83676);
                            }
                        }
                        AppMethodBeat.o(83676);
                    }
                });
                synchronized (ActVideoDecoder.this.mInitLock) {
                    try {
                        ActVideoDecoder.this.mInitLock.notifyAll();
                        ActVideoDecoder.this.mInited = true;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(83677);
                    }
                }
            }
        });
        synchronized (this.mInitLock) {
            while (!this.mInited) {
                try {
                    try {
                        this.mInitLock.wait();
                    } catch (InterruptedException e) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(83681);
                }
            }
        }
        this.mDecoderSurface = new Surface(this.mSurfaceTexture);
        this.mExtractor = new MediaExtractor();
        try {
            setExtractorDataSource(this.mExtractor, this.mFilename);
            prepare();
        } catch (IOException e2) {
            AppMethodBeat.o(83681);
        }
    }

    private static void setExtractorDataSource(MediaExtractor mediaExtractor, String str) {
        AppMethodBeat.i(83682);
        if (str.startsWith("assets://")) {
            AssetFileDescriptor openFd = VideoGlobalContext.getContext().getAssets().openFd(str.substring(9));
            mediaExtractor.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            openFd.close();
            AppMethodBeat.o(83682);
            return;
        }
        mediaExtractor.setDataSource(str);
        AppMethodBeat.o(83682);
    }

    private void prepare() {
        AppMethodBeat.i(83683);
        for (int i = 0; i < this.mExtractor.getTrackCount(); i++) {
            MediaFormat trackFormat = this.mExtractor.getTrackFormat(i);
            String string = trackFormat.getString("mime");
            if (string.startsWith("video/")) {
                this.mExtractor.selectTrack(i);
                i.k(TAG, "extractor video track selected");
                this.mWidth = trackFormat.getInteger("width");
                this.mHeight = trackFormat.getInteger("height");
                this.mDuration = trackFormat.getLong("durationUs") / 1000;
                i.k(TAG, "width = " + this.mWidth + ", height = " + this.mHeight + ", mDuration = " + this.mDuration);
                this.mDecoder = MediaCodec.createDecoderByType(string);
                trackFormat.setInteger("max-input-size", 0);
                this.mDecoder.configure(trackFormat, this.mDecoderSurface, null, 0);
                break;
            }
        }
        if (this.mDecoder == null) {
            i.m(TAG, "Can't find video info!");
            AppMethodBeat.o(83683);
            return;
        }
        try {
            this.mDecoder.start();
            this.inputBuffers = this.mDecoder.getInputBuffers();
        } catch (Exception e) {
        }
        this.isEOS = false;
        AppMethodBeat.o(83683);
    }

    /* JADX WARNING: Missing block: B:29:0x00db, code skipped:
            r7 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int decodeNext() {
        AppMethodBeat.i(83684);
        if (this.mDecoder != null) {
            int dequeueOutputBuffer;
            int i = 0;
            while (!Thread.interrupted()) {
                BenchUtil.benchStart("[decodeNext] dequeueInputBuffer");
                if (!this.isEOS) {
                    int dequeueInputBuffer = this.mDecoder.dequeueInputBuffer(10000);
                    if (dequeueInputBuffer >= 0) {
                        int readSampleData = this.mExtractor.readSampleData(this.inputBuffers[dequeueInputBuffer], 0);
                        if (readSampleData < 0) {
                            i.k(TAG, "extractor read sample to EOS");
                            this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                            this.isEOS = true;
                        } else {
                            this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.mExtractor.getSampleTime(), 0);
                            this.mExtractor.advance();
                        }
                    }
                }
                BenchUtil.benchEnd("[decodeNext] dequeueInputBuffer");
                BenchUtil.benchStart("[decodeNext] wait");
                dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(this.info, 10000);
                BenchUtil.benchEnd("[decodeNext] wait");
                if ((this.info.flags & 4) == 0) {
                    switch (dequeueOutputBuffer) {
                        case -3:
                        case -2:
                            break;
                        case -1:
                            dequeueOutputBuffer = i + 1;
                            if (dequeueOutputBuffer > 10) {
                                new StringBuilder("dequeueOutputBuffer timed out! eos = ").append(this.isEOS);
                                dequeueOutputBuffer = -1;
                                break;
                            }
                            break;
                        default:
                            this.mCurFrameIndex++;
                            if (this.mCurFrameIndex != this.mLastFrameIndex) {
                                this.mDecoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                                dequeueOutputBuffer = i;
                                break;
                            }
                            this.mHasNewFrame = true;
                            this.mDecoder.releaseOutputBuffer(dequeueOutputBuffer, true);
                            dequeueOutputBuffer = 0;
                            break;
                    }
                }
                dequeueOutputBuffer = 0;
                AppMethodBeat.o(83684);
                return dequeueOutputBuffer;
            }
            dequeueOutputBuffer = 0;
            AppMethodBeat.o(83684);
            return dequeueOutputBuffer;
        } else if (GLConfig.DEBUG) {
            RuntimeException runtimeException = new RuntimeException("ActVideoDecoder init fail!");
            AppMethodBeat.o(83684);
            throw runtimeException;
        } else {
            AppMethodBeat.o(83684);
            return -1;
        }
    }

    public void decodeFrame(long j) {
        AppMethodBeat.i(83685);
        if (this.mDecoderSurface == null) {
            RuntimeException runtimeException = new RuntimeException("You haven't set surfaceTexture?!");
            AppMethodBeat.o(83685);
            throw runtimeException;
        } else if (j <= this.mLastFrameIndex) {
            AppMethodBeat.o(83685);
        } else {
            this.mLastFrameIndex = j;
            try {
                BenchUtil.benchStart(TAG + "[decodeNext]");
                decodeNext();
                BenchUtil.benchEnd(TAG + "[decodeNext]");
                AppMethodBeat.o(83685);
            } catch (Exception e) {
                i.a(TAG, "decodeNext error: ", e);
                AppMethodBeat.o(83685);
            }
        }
    }

    public void decodeFrameAsync(long j) {
        AppMethodBeat.i(83686);
        if (this.mDecoderSurface == null) {
            RuntimeException runtimeException = new RuntimeException("You haven't set surfaceTexture?!");
            AppMethodBeat.o(83686);
            throw runtimeException;
        } else if (this.isDecoding || j <= this.mLastFrameIndex) {
            AppMethodBeat.o(83686);
        } else {
            this.isDecoding = true;
            this.mLastFrameIndex = j;
            this.mHandler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(83678);
                    try {
                        BenchUtil.benchStart(ActVideoDecoder.TAG + "[decodeNext]");
                        ActVideoDecoder.access$700(ActVideoDecoder.this);
                        BenchUtil.benchEnd(ActVideoDecoder.TAG + "[decodeNext]");
                    } catch (Exception e) {
                        i.a(ActVideoDecoder.TAG, "decodeNext error: ", e);
                        if (GLConfig.DEBUG) {
                            AppMethodBeat.o(83678);
                            throw e;
                        }
                    }
                    ActVideoDecoder.this.isDecoding = false;
                    AppMethodBeat.o(83678);
                }
            });
            AppMethodBeat.o(83686);
        }
    }

    /* JADX WARNING: Missing block: B:23:0x005c, code skipped:
            com.tencent.ttpic.util.BenchUtil.benchEnd(TAG + "[updateFrame] wait");
            com.tencent.ttpic.util.BenchUtil.benchStart(TAG + "[updateFrame] render");
     */
    /* JADX WARNING: Missing block: B:25:?, code skipped:
            r11.mSurfaceTexture.updateTexImage();
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean updateFrame() {
        boolean z = false;
        int i = 83687;
        AppMethodBeat.i(83687);
        boolean z2 = this.mHasNewFrame;
        if (this.mHasNewFrame) {
            String str = "[updateFrame] wait";
            BenchUtil.benchStart(TAG + str);
            synchronized (this.mUpdateFrameLock) {
                while (!this.mFrameAvailable) {
                    try {
                        this.mUpdateFrameLock.wait(2500);
                        str = this.mFrameAvailable;
                        if (str == null) {
                            str = TAG;
                            LogUtils.e(str, "frame wait timed out");
                        }
                    } catch (InterruptedException e) {
                        str = new RuntimeException(e);
                        z = true;
                        throw str;
                    } finally {
                        AppMethodBeat.o(
/*
Method generation error in method: com.tencent.ttpic.recorder.ActVideoDecoder.updateFrame():boolean, dex: classes6.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0054: INVOKE  (wrap: int
  ?: MERGE  (r10_1 int) = (r10_0 'i' int), (r0_8 'z' boolean)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.ttpic.recorder.ActVideoDecoder.updateFrame():boolean, dex: classes6.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:220)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:120)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r10_1 int) = (r10_0 'i' int), (r0_8 'z' boolean) in method: com.tencent.ttpic.recorder.ActVideoDecoder.updateFrame():boolean, dex: classes6.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 37 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 42 more

*/

    public void reset() {
        AppMethodBeat.i(83688);
        try {
            if (this.mExtractor != null) {
                this.mExtractor.seekTo(0, 0);
            }
            if (this.mDecoder != null) {
                this.mDecoder.flush();
            }
        } catch (Exception e) {
            if (!TextUtils.isEmpty(e.getMessage())) {
                i.k(TAG, e.getMessage());
            }
        }
        this.isEOS = false;
        this.mCurFrameIndex = -1;
        this.mLastFrameIndex = -1;
        AppMethodBeat.o(83688);
    }

    public void resetAsync() {
        AppMethodBeat.i(83689);
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(83679);
                    if (ActVideoDecoder.this.mExtractor != null) {
                        ActVideoDecoder.this.mExtractor.seekTo(0, 0);
                    }
                    if (ActVideoDecoder.this.mDecoder != null) {
                        ActVideoDecoder.this.mDecoder.flush();
                    }
                    ActVideoDecoder.this.isEOS = false;
                    ActVideoDecoder.this.mCurFrameIndex = -1;
                    ActVideoDecoder.this.mLastFrameIndex = -1;
                    AppMethodBeat.o(83679);
                }
            });
        }
        AppMethodBeat.o(83689);
    }

    public void release() {
        AppMethodBeat.i(83690);
        g.Sk(this.mTempTex);
        this.mSurfaceTexFilter.clearGLSLSelf();
        this.mFrame.clear();
        if (this.mDecoderSurface != null) {
            this.mDecoderSurface.release();
        }
        if (this.mExtractor != null) {
            this.mExtractor.release();
        }
        if (this.mDecoder != null) {
            this.mDecoder.stop();
            this.mDecoder.release();
            i.j(TAG, "mDecoder stop and release");
            this.mDecoder = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(83680);
                    if (ActVideoDecoder.this.mSurfaceTexture != null) {
                        ActVideoDecoder.this.mSurfaceTexture.release();
                    }
                    ActVideoDecoder.this.mHandler.getLooper().quit();
                    ActVideoDecoder.this.mHandler = null;
                    AppMethodBeat.o(83680);
                }
            });
        }
        AppMethodBeat.o(83690);
    }

    public boolean isLive() {
        return this.mDecoder != null;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public long getDuration() {
        return this.mDuration;
    }
}
