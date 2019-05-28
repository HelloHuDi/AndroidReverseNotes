package com.tencent.ttpic.filter;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.FaceCropItem;
import com.tencent.ttpic.model.FaceCropItem.CropFrame;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.List;

public class FaceCropFilter extends VideoFilterBase {
    private float[] attrPositions = new float[8];
    private float[] attrTexCoords = new float[8];
    private FaceCropItem faceCropItem;
    private boolean needRender;
    private List<NormalVideoFilter> normalFilters;

    public FaceCropFilter(VideoMaterial videoMaterial) {
        super(PROGRAM_TYPE.FACE_CROP);
        AppMethodBeat.m2504i(82337);
        this.faceCropItem = videoMaterial.getFaceCropItem();
        AppMethodBeat.m2505o(82337);
    }

    public void initParams() {
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.m2504i(82338);
        if (this.faceCropItem == null || pTDetectInfo.facePoints == null || pTDetectInfo.facePoints.size() < 90 || pTDetectInfo.faceAngles == null || pTDetectInfo.faceAngles.length < 3) {
            this.needRender = false;
            AppMethodBeat.m2505o(82338);
            return;
        }
        int i;
        this.needRender = !BaseUtils.isEmpty(this.normalFilters);
        if (this.normalFilters != null) {
            i = 0;
            for (NormalVideoFilter normalVideoFilter : this.normalFilters) {
                boolean z;
                normalVideoFilter.updatePreview(pTDetectInfo);
                if (this.needRender && normalVideoFilter.isRenderReady()) {
                    z = true;
                } else {
                    z = false;
                }
                this.needRender = z;
                i = normalVideoFilter.getLastFrameIndex();
            }
        } else {
            i = 0;
        }
        if (!this.needRender || BaseUtils.indexOutOfBounds(this.faceCropItem.frameList, i)) {
            AppMethodBeat.m2505o(82338);
            return;
        }
        updateParams(VideoMaterialUtil.copyList(pTDetectInfo.facePoints), pTDetectInfo.faceAngles, pTDetectInfo.phoneAngle, i);
        AppMethodBeat.m2505o(82338);
    }

    private void updateParams(List<PointF> list, float[] fArr, float f, int i) {
        PointF pointF;
        AppMethodBeat.m2504i(82339);
        CropFrame cropFrame = (CropFrame) this.faceCropItem.frameList.get(i);
        float min = (float) Math.min(cropFrame.width / ((double) this.width), cropFrame.height / ((double) this.height));
        PointF pointF2 = new PointF((((float) (cropFrame.width / ((double) min))) - ((float) this.width)) / 2.0f, (((float) (cropFrame.height / ((double) min))) - ((float) this.height)) / 2.0f);
        float f2 = (float) (cropFrame.faceWidth / ((double) min));
        float f3 = (float) ((cropFrame.noseX / ((double) min)) - ((double) pointF2.x));
        float f4 = (float) ((cropFrame.noseY / ((double) min)) - ((double) pointF2.y));
        List<PointF> fullCoords = FaceOffUtil.getFullCoords(list, 3.0f);
        for (PointF pointF3 : fullCoords) {
            pointF3.x = (float) (((double) pointF3.x) / this.mFaceDetScale);
            pointF3.y = (float) (((double) pointF3.y) / this.mFaceDetScale);
        }
        float DISTANCE_OF = DISTANCE_OF((PointF) fullCoords.get(0), (PointF) fullCoords.get(18));
        float f5 = ((PointF) fullCoords.get(64)).x;
        min = ((PointF) fullCoords.get(64)).y;
        ArrayList<PointF> arrayList = new ArrayList();
        arrayList.add(fullCoords.get(99));
        arrayList.add(fullCoords.get(105));
        arrayList.add(fullCoords.get(101));
        arrayList.add(fullCoords.get(103));
        DISTANCE_OF = f2 / DISTANCE_OF;
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.postRotate(RADIANS2DEGREES((float) (((double) fArr[2]) - cropFrame.faceAngle)), f5, min);
        matrix.postScale(DISTANCE_OF, DISTANCE_OF, f5, min);
        matrix.postTranslate(f3 - f5, f4 - min);
        ArrayList arrayList2 = new ArrayList();
        for (PointF pointF4 : arrayList) {
            r4 = new float[2];
            matrix.mapPoints(r4, new float[]{pointF4.x, pointF4.y});
            arrayList2.add(new PointF(r4[0], r4[1]));
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < 4) {
                pointF4 = (PointF) arrayList2.get(i4);
                this.attrPositions[i2] = ((2.0f * pointF4.x) / ((float) this.width)) - 1.0f;
                this.attrPositions[i2 + 1] = ((pointF4.y * 2.0f) / ((float) this.height)) - 1.0f;
                pointF4 = (PointF) arrayList.get(i4);
                this.attrTexCoords[i2] = pointF4.x / ((float) this.width);
                this.attrTexCoords[i2 + 1] = pointF4.y / ((float) this.height);
                i2 += 2;
                i3 = i4 + 1;
            } else {
                setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
                setPositions(this.attrPositions);
                setTexCords(this.attrTexCoords);
                AppMethodBeat.m2505o(82339);
                return;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final float RADIANS2DEGREES(float f) {
        return (180.0f * f) / 3.14159f;
    }

    /* Access modifiers changed, original: final */
    public final float DISTANCE_OF(PointF pointF, PointF pointF2) {
        AppMethodBeat.m2504i(82340);
        float f = pointF2.x - pointF.x;
        float f2 = pointF2.y - pointF.y;
        f = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        AppMethodBeat.m2505o(82340);
        return f;
    }

    public void setNormalFilters(List<NormalVideoFilter> list) {
        this.normalFilters = list;
    }

    public boolean isNeedRender() {
        return this.needRender;
    }
}
