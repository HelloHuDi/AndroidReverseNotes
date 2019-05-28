package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.m.a;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.filter.VideoFilterBase.SHADER_FIELD;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.List;

public class CustomVideoFilter extends VideoFilterBase {
    private static final String TAG = CustomVideoFilter.class.getSimpleName();
    private long frameStartTime;
    private List<NormalVideoFilter> normalFilters;
    private PTExpression triggerType;

    static {
        AppMethodBeat.i(82150);
        AppMethodBeat.o(82150);
    }

    public CustomVideoFilter(String str, String str2, List<String> list, PTExpression pTExpression, String str3) {
        super(str, str2);
        AppMethodBeat.i(82143);
        this.dataPath = str3;
        this.triggerType = pTExpression;
        if (this.triggerType == null) {
            this.triggerType = PTExpression.UNKNOW;
        }
        initParams();
        initTextureParams(list);
        AppMethodBeat.o(82143);
    }

    private void initTextureParams(List<String> list) {
        AppMethodBeat.i(82144);
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.o(82144);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                Bitmap decodeSampledBitmapFromAssets;
                String str = this.dataPath + File.separator + ((String) list.get(i2));
                if (str.startsWith("assets://")) {
                    decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(str), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
                } else {
                    decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromFile(str, MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
                }
                if (BitmapUtils.isLegal(decodeSampledBitmapFromAssets)) {
                    addParam(new k("inputImageTexture" + (i2 + 1), decodeSampledBitmapFromAssets, 33985 + i2, true));
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(82144);
                return;
            }
        }
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        int i;
        int i2 = 0;
        AppMethodBeat.i(82145);
        if (pTDetectInfo.triggeredExpression.contains(Integer.valueOf(this.triggerType.value))) {
            i = this.triggerType.value;
        } else if (pTDetectInfo.triggeredExpression.contains(Integer.valueOf(PTExpression.FACE_DETECT.value))) {
            i = PTExpression.FACE_DETECT.value;
        } else {
            i = 0;
        }
        addParam(new i(SHADER_FIELD.FACE_ACTION_TYPE.name, i));
        addParam(new f(SHADER_FIELD.FRAME_DURATION.name, ((float) (System.currentTimeMillis() - this.frameStartTime)) / 1000.0f));
        float[] toFlatArray;
        if (pTDetectInfo.facePoints != null) {
            toFlatArray = VideoMaterialUtil.toFlatArray(pTDetectInfo.facePoints);
            if (toFlatArray != null) {
                addParam(new a(SHADER_FIELD.FACE_POINT.name, VideoMaterialUtil.flipYPoints(toFlatArray, (int) (((double) this.height) * this.mFaceDetScale))));
            }
        } else {
            toFlatArray = new float[180];
            while (i2 < 180) {
                toFlatArray[i2] = 0.0f;
                i2++;
            }
            addParam(new a(SHADER_FIELD.FACE_POINT.name, toFlatArray));
        }
        addParam(new a(SHADER_FIELD.ELEMENT_DURATIONS.name, getElementDurations(pTDetectInfo.timestamp)));
        AppMethodBeat.o(82145);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82146);
        super.ApplyGLSLFilter();
        setTexCords(GlUtil.ORIGIN_TEX_COORDS);
        this.frameStartTime = System.currentTimeMillis();
        AppMethodBeat.o(82146);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82147);
        super.updateVideoSize(i, i2, d);
        addParam(new b(SHADER_FIELD.CANVAS_SIZE.name, (float) i, (float) i2));
        addParam(new b(SHADER_FIELD.FACE_DETECT_IMAGE_SIZE.name, (float) (((double) this.width) * this.mFaceDetScale), (float) (((double) this.height) * this.mFaceDetScale)));
        AppMethodBeat.o(82147);
    }

    public void initParams() {
        AppMethodBeat.i(82148);
        addParam(new b(SHADER_FIELD.CANVAS_SIZE.name, 0.0f, 0.0f));
        addParam(new b(SHADER_FIELD.FACE_DETECT_IMAGE_SIZE.name, 0.0f, 0.0f));
        addParam(new a(SHADER_FIELD.FACE_POINT.name, new float[0]));
        addParam(new i(SHADER_FIELD.FACE_ACTION_TYPE.name, 0));
        addParam(new f(SHADER_FIELD.FRAME_DURATION.name, 0.0f));
        addParam(new a(SHADER_FIELD.ELEMENT_DURATIONS.name, new float[0]));
        addParam(new f(SHADER_FIELD.AUDIO_POWER_SCALE.name, 0.0f));
        AppMethodBeat.o(82148);
    }

    public void setNormalFilters(List<NormalVideoFilter> list) {
        this.normalFilters = list;
    }

    public float[] getElementDurations(long j) {
        int i = 0;
        AppMethodBeat.i(82149);
        if (BaseUtils.isEmpty(this.normalFilters)) {
            float[] fArr = new float[0];
            AppMethodBeat.o(82149);
            return fArr;
        }
        float[] fArr2 = new float[this.normalFilters.size()];
        while (true) {
            int i2 = i;
            if (i2 < this.normalFilters.size()) {
                fArr2[i2] = ((NormalVideoFilter) this.normalFilters.get(i2)).getFrameDuration(j);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(82149);
                return fArr2;
            }
        }
    }
}
