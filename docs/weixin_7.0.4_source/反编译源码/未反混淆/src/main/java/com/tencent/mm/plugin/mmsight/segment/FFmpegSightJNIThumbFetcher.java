package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

public class FFmpegSightJNIThumbFetcher implements d {
    private static final String TAG = "MicroMsg.FFmpegSightJNIThumbFetcher";
    private int mBufId;
    private int mDurationMs;
    private Bitmap mReusedBitmap;
    private int mScaledHeight;
    private int mScaledWidth;

    static class ReleaseRunnable implements Runnable {
        int mBufId;
        Bitmap mReusedBitmap;

        /* synthetic */ ReleaseRunnable(Bitmap bitmap, int i, AnonymousClass1 anonymousClass1) {
            this(bitmap, i);
        }

        private ReleaseRunnable(Bitmap bitmap, int i) {
            this.mReusedBitmap = bitmap;
            this.mBufId = i;
        }

        public void run() {
            AppMethodBeat.i(3628);
            if (!(this.mReusedBitmap == null || this.mReusedBitmap.isRecycled())) {
                o.fdT.f(this.mReusedBitmap);
            }
            SightVideoJNI.freeObj(this.mBufId);
            AppMethodBeat.o(3628);
        }
    }

    public void init(String str, int i, int i2, int i3) {
        AppMethodBeat.i(3629);
        ab.i(TAG, "init() called with: path = [" + str + "], segment_interval = [" + i + "], width = [" + i2 + "], height = [" + i3 + "]");
        this.mBufId = SightVideoJNI.openFile(str, 1, 16, false);
        if (this.mBufId < 0) {
            p pVar = new p("open file error.");
            AppMethodBeat.o(3629);
            throw pVar;
        }
        int videoWidth = SightVideoJNI.getVideoWidth(this.mBufId);
        int videoHeight = SightVideoJNI.getVideoHeight(this.mBufId);
        this.mDurationMs = (int) (SightVideoJNI.getVideoDuration(this.mBufId) * 1000.0d);
        Point calculateScaledLength = calculateScaledLength(i2, i3, videoWidth, videoHeight, new Point());
        this.mScaledWidth = calculateScaledLength.x;
        this.mScaledHeight = calculateScaledLength.y;
        ab.i(TAG, "FFmpegSightJNIThumbFetcher.init. scaled size is (%d, %d); raw size is (%d, %d)", Integer.valueOf(this.mScaledWidth), Integer.valueOf(this.mScaledHeight), Integer.valueOf(videoWidth), Integer.valueOf(videoHeight));
        AppMethodBeat.o(3629);
    }

    private Point calculateScaledLength(int i, int i2, int i3, int i4, Point point) {
        AppMethodBeat.i(3630);
        if (point == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("FFmpegThumbFetcherImpl : Point to calculateScaledLength can not be null.");
            AppMethodBeat.o(3630);
            throw illegalArgumentException;
        }
        if (i2 <= 0 && i <= 0) {
            point.x = i3;
            point.y = i4;
            AppMethodBeat.o(3630);
        } else if (i <= 0) {
            point.x = (int) ((((float) i2) / ((float) i4)) * ((float) i3));
            point.y = i2;
            AppMethodBeat.o(3630);
        } else if (i2 <= 0) {
            point.x = i;
            point.y = (int) ((((float) i) / ((float) i3)) * ((float) i4));
            AppMethodBeat.o(3630);
        } else {
            if (((float) i2) / ((float) i) > ((float) i4) / ((float) i3)) {
                point.x = (int) ((((float) i3) * ((float) i2)) / ((float) i4));
                point.y = i2;
            } else {
                point.x = i;
                point.y = (int) ((((float) i4) * ((float) i)) / ((float) i3));
            }
            AppMethodBeat.o(3630);
        }
        return point;
    }

    public void reuseBitmap(Bitmap bitmap) {
        AppMethodBeat.i(3631);
        ab.i(TAG, "reuseBitmap() called with: bitmap = [" + bitmap + "]");
        if (bitmap == null) {
            AppMethodBeat.o(3631);
            return;
        }
        this.mReusedBitmap = bitmap;
        AppMethodBeat.o(3631);
    }

    public Bitmap getFrameAtTime(long j) {
        long j2;
        long j3 = 0;
        AppMethodBeat.i(3632);
        ab.i(TAG, "getFrameAtTime() called with: timeMs = [%d], mBufId = [%d]", Long.valueOf(j), Integer.valueOf(this.mBufId));
        if (j > ((long) this.mDurationMs)) {
            j2 = (long) this.mDurationMs;
        } else {
            j2 = j;
        }
        if (j2 >= 0) {
            j3 = j2;
        }
        int seekStreamWithFlag = SightVideoJNI.seekStreamWithFlag((double) (((float) j3) / 1000.0f), 1, this.mBufId);
        ab.i(TAG, "getFrameAtTime() seekStream return %d", Integer.valueOf(seekStreamWithFlag));
        if (this.mReusedBitmap == null || this.mReusedBitmap.isRecycled() || this.mReusedBitmap.getWidth() != this.mScaledWidth || this.mReusedBitmap.getHeight() != this.mScaledHeight) {
            if (!(this.mReusedBitmap == null || this.mReusedBitmap.isRecycled())) {
                o.fdT.f(this.mReusedBitmap);
            }
            this.mReusedBitmap = o.fdT.a(new b(this.mScaledWidth, this.mScaledHeight));
        }
        seekStreamWithFlag = SightVideoJNI.drawScaledFrame(this.mBufId, this.mReusedBitmap, this.mScaledWidth, this.mScaledHeight);
        ab.i(TAG, "getFrameAtTime() dr return %d", Integer.valueOf(seekStreamWithFlag));
        Bitmap bitmap = this.mReusedBitmap;
        this.mReusedBitmap = null;
        AppMethodBeat.o(3632);
        return bitmap;
    }

    public int getDurationMs() {
        AppMethodBeat.i(3633);
        ab.i(TAG, "getDurationMs() returned: " + this.mDurationMs);
        int i = this.mDurationMs;
        AppMethodBeat.o(3633);
        return i;
    }

    public int getScaledWidth() {
        AppMethodBeat.i(3634);
        ab.i(TAG, "getScaledWidth() returned: " + this.mScaledWidth);
        int i = this.mScaledWidth;
        AppMethodBeat.o(3634);
        return i;
    }

    public int getScaledHeight() {
        AppMethodBeat.i(3635);
        ab.i(TAG, "getScaledHeight() returned: " + this.mScaledHeight);
        int i = this.mScaledHeight;
        AppMethodBeat.o(3635);
        return i;
    }

    public void release() {
        AppMethodBeat.i(3636);
        ab.i(TAG, "release() called");
        d.post(new ReleaseRunnable(this.mReusedBitmap, this.mBufId, null), "release");
        AppMethodBeat.o(3636);
    }
}
