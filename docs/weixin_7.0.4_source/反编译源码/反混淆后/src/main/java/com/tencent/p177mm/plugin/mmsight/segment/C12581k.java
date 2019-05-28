package com.tencent.p177mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.k */
public final class C12581k implements C3493d {
    private Paint aFY = new Paint(1);
    private Matrix aKk;
    private Canvas bmG = new Canvas();
    private MediaMetadataRetriever oyl;
    private int oym;
    private int oyn;
    private Bitmap reuse = null;

    public C12581k() {
        AppMethodBeat.m2504i(3678);
        AppMethodBeat.m2505o(3678);
    }

    public final void init(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(3679);
        if (i2 <= 0 || i3 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(Locale.CHINA, "destination width and height error, width %d, height %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            AppMethodBeat.m2505o(3679);
            throw illegalArgumentException;
        }
        try {
            this.oyl = new MediaMetadataRetriever();
            this.oyl.setDataSource(str);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MediaCodecThumbFetcher", e, "init error:%s", e.getMessage());
        }
        this.oym = i2;
        this.oyn = i3;
        AppMethodBeat.m2505o(3679);
    }

    public final void reuseBitmap(Bitmap bitmap) {
        this.reuse = bitmap;
    }

    public final Bitmap getFrameAtTime(long j) {
        Bitmap bitmap;
        AppMethodBeat.m2504i(3680);
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap frameAtTime = this.oyl.getFrameAtTime(1000 * j);
        int i = this.oym;
        int i2 = this.oyn;
        if (frameAtTime == null || frameAtTime.isRecycled() || i <= 0 || i2 <= 0) {
            bitmap = null;
        } else {
            C4990ab.m7411d("MediaCodecThumbFetcher", "scaleBitmap(60) largeBitmap(width : %d, height : %d)", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
            Bitmap ex = C12581k.m20518ex(i, i2);
            if (ex == null) {
                bitmap = null;
            } else {
                if (this.aKk == null) {
                    float f;
                    int width = frameAtTime.getWidth();
                    int height = frameAtTime.getHeight();
                    Matrix matrix = new Matrix();
                    matrix.reset();
                    matrix.setTranslate(((float) (i - width)) / 2.0f, ((float) (i2 - height)) / 2.0f);
                    if (((float) height) / ((float) width) > ((float) i2) / ((float) i)) {
                        f = ((float) i) / ((float) width);
                    } else {
                        f = ((float) i2) / ((float) height);
                    }
                    matrix.postScale(f, f, ((float) i) / 2.0f, ((float) i2) / 2.0f);
                    this.aKk = matrix;
                }
                this.bmG.setBitmap(ex);
                this.bmG.drawBitmap(frameAtTime, this.aKk, this.aFY);
                bitmap = ex;
            }
        }
        frameAtTime.recycle();
        C4990ab.m7411d("MediaCodecThumbFetcher", "time flee : get video thumb bitmap cost time %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(3680);
        return bitmap;
    }

    public final int getDurationMs() {
        AppMethodBeat.m2504i(3681);
        int duration = getDuration();
        AppMethodBeat.m2505o(3681);
        return duration;
    }

    private int getDuration() {
        int i = 0;
        AppMethodBeat.m2504i(3682);
        String extractMetadata = this.oyl.extractMetadata(9);
        if (extractMetadata == null) {
            AppMethodBeat.m2505o(3682);
        } else {
            try {
                i = Integer.valueOf(extractMetadata).intValue();
                AppMethodBeat.m2505o(3682);
            } catch (Exception e) {
                C4990ab.m7413e("MediaCodecThumbFetcher", "getDuration error %s", e.getMessage());
                AppMethodBeat.m2505o(3682);
            }
        }
        return i;
    }

    public final int getScaledWidth() {
        return this.oym;
    }

    public final int getScaledHeight() {
        return this.oyn;
    }

    public final void release() {
        AppMethodBeat.m2504i(3683);
        if (this.oyl != null) {
            this.oyl.release();
        }
        this.aKk = null;
        this.aFY = null;
        this.bmG = null;
        AppMethodBeat.m2505o(3683);
    }

    /* renamed from: ex */
    private static Bitmap m20518ex(int i, int i2) {
        Bitmap createBitmap;
        AppMethodBeat.m2504i(3684);
        try {
            createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            C4990ab.m7413e("MediaCodecThumbFetcher", "%s OutOfMemory %s", C1447g.m3075Mq(), e.getMessage());
            System.gc();
            try {
                createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            } catch (Exception e2) {
                C4990ab.m7413e("MediaCodecThumbFetcher", "%s try again Exception %s", C1447g.m3075Mq(), e2.getMessage());
                createBitmap = null;
            }
        }
        AppMethodBeat.m2505o(3684);
        return createBitmap;
    }
}
