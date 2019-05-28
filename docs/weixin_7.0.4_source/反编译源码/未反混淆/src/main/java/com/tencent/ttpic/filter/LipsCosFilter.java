package com.tencent.ttpic.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.support.v4.widget.j;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.microrapid.opencv.CosmeticsHandle;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.view.g;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class LipsCosFilter {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/LipsCosFragment.dat");
    float[] cords = new float[8];
    int[][] fPoints = ((int[][]) Array.newInstance(Integer.TYPE, new int[]{83, 2}));
    private BaseFilter mCropFilter = null;
    private h mCropFrame = new h();
    byte[] mData = null;
    private BaseFilter mFilter = null;
    private h mFrame = new h();
    private int mHeight = 0;
    private Bitmap mLut;
    private float mScale = 1.0f;
    private int mTex = 0;
    private int mType = 1;
    private int mWidth = 0;

    static {
        AppMethodBeat.i(82649);
        if (FeatureManager.isSegmentationReady()) {
            try {
                FeatureManager.loadLibrary("algo_rithm_jni");
                AppMethodBeat.o(82649);
                return;
            } catch (UnsatisfiedLinkError e) {
                LogUtils.e(e);
                AppMethodBeat.o(82649);
                return;
            } catch (RuntimeException e2) {
                LogUtils.e(e2);
                AppMethodBeat.o(82649);
                return;
            } catch (Exception e3) {
                LogUtils.e(e3);
            }
        }
        AppMethodBeat.o(82649);
    }

    public LipsCosFilter() {
        AppMethodBeat.i(82642);
        AppMethodBeat.o(82642);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82643);
        this.mFilter = new BaseFilter(FRAGMENT_SHADER);
        this.mFilter.addParam(new i("type", this.mType));
        this.mFilter.addParam(new k("inputImageTexture2", this.mLut, 33986, true));
        this.mFilter.addParam(new f("adjustAlpha", 1.0f));
        this.mFilter.ApplyGLSLFilter(true, 0.0f, 0.0f);
        AppMethodBeat.o(82643);
    }

    public void clear() {
        AppMethodBeat.i(82644);
        this.mFilter.ClearGLSL();
        this.mFilter = null;
        this.mCropFrame.clear();
        this.mFrame.clear();
        AppMethodBeat.o(82644);
    }

    public void setTypeAndLut(int i, Bitmap bitmap) {
        this.mType = i;
        this.mLut = bitmap;
        if (this.mLut == null) {
            this.mType = 0;
        }
    }

    public h updateAndRender(h hVar, int i, int i2, List<PointF> list, float[] fArr, Map<Integer, FaceActionCounter> map) {
        AppMethodBeat.i(82645);
        try {
            int i3;
            int i4;
            int i5;
            initData(hVar.width, hVar.height);
            int i6 = BaseClientBuilder.API_PRIORITY_OTHER;
            int i7 = j.INVALID_ID;
            int i8 = BaseClientBuilder.API_PRIORITY_OTHER;
            int i9 = j.INVALID_ID;
            int i10 = 65;
            while (true) {
                i3 = i10;
                i4 = i9;
                i5 = i8;
                if (i3 > 82) {
                    break;
                }
                i6 = (int) Math.min((float) i6, ((PointF) list.get(i3)).x);
                i7 = (int) Math.max((float) i7, ((PointF) list.get(i3)).x);
                i8 = (int) Math.min((float) i5, ((PointF) list.get(i3)).y);
                i9 = (int) Math.max((float) i4, ((PointF) list.get(i3)).y);
                i10 = i3 + 1;
            }
            i10 = (i7 - i6) + 1;
            i8 = i6 - ((int) (((double) i10) * 0.3d));
            i3 = i5 - ((int) (((double) i10) * 0.25d));
            i9 = ((int) (((double) i10) * 0.3d)) + i7;
            i10 = ((int) (((double) i10) * 0.25d)) + i4;
            float f = ((float) i) * this.mScale;
            float f2 = this.mScale * ((float) i2);
            if (((float) i8) >= f || i9 < 0 || ((float) i3) >= f2 || i10 < 0) {
                AppMethodBeat.o(82645);
                return hVar;
            }
            if (i8 < 0) {
                i5 = 0;
            } else {
                i5 = i8;
            }
            if (((float) i9) >= f) {
                i8 = ((int) f) - 1;
            } else {
                i8 = i9;
            }
            if (i3 < 0) {
                i9 = 0;
            } else {
                i9 = i3;
            }
            if (((float) i10) >= f2) {
                i10 = ((int) f2) - 1;
            }
            this.cords[0] = ((float) i5) / f;
            this.cords[1] = ((float) i9) / f2;
            this.cords[2] = ((float) i5) / f;
            this.cords[3] = ((float) i10) / f2;
            this.cords[4] = ((float) i8) / f;
            this.cords[5] = ((float) i10) / f2;
            this.cords[6] = ((float) i8) / f;
            this.cords[7] = ((float) i9) / f2;
            i8 = (int) (((float) (i8 - i5)) / this.mScale);
            i4 = (int) (((float) (i10 - i9)) / this.mScale);
            i3 = (int) (((float) i5) / this.mScale);
            i9 = (int) (((float) i9) / this.mScale);
            GlUtil.saveTextureToRgbaBuffer(hVar.texture[0], i3, i9, i8, i4, this.mData, hVar.bJz[0]);
            i10 = 0;
            while (true) {
                i5 = i10;
                if (i5 >= this.fPoints.length) {
                    break;
                }
                this.fPoints[i5][0] = (int) ((((PointF) list.get(i5)).x / this.mScale) - ((float) i3));
                this.fPoints[i5][1] = (int) ((((PointF) list.get(i5)).y / this.mScale) - ((float) i9));
                i10 = i5 + 1;
            }
            CosmeticsHandle.a(this.mData, this.fPoints, i8, i4);
            this.mTex = GlUtil.createImageTexture(ByteBuffer.wrap(this.mData), i8, i4, GLFormat.GL_RGBA);
            GLES20.glBindFramebuffer(36160, hVar.bJz[0]);
            GLES20.glViewport(0, 0, hVar.width, hVar.height);
            for (i10 = 0; i10 < 8; i10++) {
                float[] fArr2 = this.cords;
                fArr2[i10] = (fArr2[i10] * 2.0f) - 1.0f;
            }
            this.mFilter.setPositions(this.cords);
            this.mFilter.OnDrawFrameGLSL();
            this.mFilter.renderTexture(this.mTex, i8, i4);
            g.Sk(this.mTex);
            AppMethodBeat.o(82645);
            return hVar;
        } catch (OutOfMemoryError e) {
            AppMethodBeat.o(82645);
        }
    }

    private void initData(int i, int i2) {
        try {
            if (this.mData == null || this.mData.length < (i * i2) * 4) {
                this.mData = new byte[((i * i2) * 4)];
            }
        } catch (OutOfMemoryError e) {
        }
    }

    public void setCosAlpha(float f) {
        AppMethodBeat.i(82646);
        this.mFilter.addParam(new f("adjustAlpha", f));
        AppMethodBeat.o(82646);
    }

    public void updateVideoSize(int i, int i2, double d) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mScale = (float) d;
    }

    public static Bitmap getBitmapFromAsset(Context context, String str) {
        AppMethodBeat.i(82647);
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(context.getAssets().open(str));
        } catch (IOException e) {
        }
        AppMethodBeat.o(82647);
        return bitmap;
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(82648);
        if (this.mFilter != null) {
            this.mFilter.setRenderMode(i);
        }
        AppMethodBeat.o(82648);
    }
}
