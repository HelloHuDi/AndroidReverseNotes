package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import java.util.ArrayList;
import java.util.List;

public class StaticStickerFilter extends NormalVideoFilter {
    private boolean initialized = false;
    private RATIO_MODE ratioMode = RATIO_MODE.RATIO_MODE_16_9;
    private List<PointF> relativePivotsPts_16_9;
    private List<PointF> relativePivotsPts_1_1;
    private List<PointF> relativePivotsPts_4_3;
    private List<PointF> relativePosPts_16_9;
    private List<PointF> relativePosPts_1_1;
    private List<PointF> relativePosPts_4_3;

    public StaticStickerFilter(StickerItem stickerItem, String str) {
        super(stickerItem, str);
    }

    public void initParams() {
        AppMethodBeat.i(82964);
        super.initParams();
        addParam(new i("texNeedTransform", -1));
        initRelativeParams();
        AppMethodBeat.o(82964);
    }

    public void updateFabbyProgress(long j) {
        AppMethodBeat.i(82965);
        if (!this.triggered) {
            this.triggerCtrlItem.setFrameStartTime(j);
        }
        this.triggered = true;
        updateTextureParam(((int) (((double) (j - this.triggerCtrlItem.getFrameStartTime())) / Math.max(this.item.frameDuration, 1.0d))) % Math.max(this.item.frames, 1), j);
        initFabbyPositionAdjust();
        AppMethodBeat.o(82965);
    }

    public void resetFabbyProgress() {
        this.triggered = false;
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82966);
        super.updateVideoSize(i, i2, d);
        if (this.item.isFabbyMvItem) {
            initFabbyPositionAdjust();
            AppMethodBeat.o(82966);
            return;
        }
        initPositionAdjusted();
        AppMethodBeat.o(82966);
    }

    /* Access modifiers changed, original: protected */
    public void updatePositions(List<PointF> list, float[] fArr, float f) {
        AppMethodBeat.i(82967);
        if (this.initialized) {
            AppMethodBeat.o(82967);
        } else if (this.item.isFabbyMvItem) {
            initFabbyPositionAdjust();
            AppMethodBeat.o(82967);
        } else {
            initPositionAdjusted();
            AppMethodBeat.o(82967);
        }
    }

    public void clearTextureParam() {
        AppMethodBeat.i(82968);
        super.clearTextureParam();
        this.initialized = false;
        AppMethodBeat.o(82968);
    }

    public void initPositions() {
        AppMethodBeat.i(82969);
        if (this.item == null || this.item.position == null || this.item.position.length < 2) {
            setPositions(GlUtil.EMPTY_POSITIONS);
            AppMethodBeat.o(82969);
            return;
        }
        double d = ((double) this.width) / 720.0d;
        int i = (int) (((double) this.height) * (1.0d - this.item.position[1]));
        int i2 = (int) (((double) this.width) * this.item.position[0]);
        setPositions(AlgoUtils.calPositions((float) i2, (float) i, (float) (i2 + ((int) (((double) this.item.width) * d))), (float) ((int) (((double) i) - (d * ((double) this.item.height)))), this.width, this.height));
        this.initialized = true;
        AppMethodBeat.o(82969);
    }

    public void initPositionAdjusted() {
        AppMethodBeat.i(82970);
        if (this.item == null || this.item.position == null || this.item.position.length < 2) {
            setPositions(GlUtil.EMPTY_POSITIONS);
            AppMethodBeat.o(82970);
            return;
        }
        int i = this.item.width;
        int i2 = this.item.height;
        if (this.item.type == POSITION_TYPE.RELATIVE.type) {
            List list = this.ratioMode == RATIO_MODE.RATIO_MODE_4_3 ? this.relativePivotsPts_4_3 : this.ratioMode == RATIO_MODE.RATIO_MODE_16_9 ? this.relativePivotsPts_16_9 : this.relativePivotsPts_1_1;
            List list2 = this.ratioMode == RATIO_MODE.RATIO_MODE_4_3 ? this.relativePosPts_4_3 : this.ratioMode == RATIO_MODE.RATIO_MODE_16_9 ? this.relativePosPts_16_9 : this.relativePosPts_1_1;
            float distance = AlgoUtils.getDistance((PointF) list.get(this.item.scalePivots[0]), (PointF) list.get(this.item.scalePivots[1])) / ((float) this.item.scaleFactor);
            i = (int) (((float) i) * distance);
            i2 = (int) (((float) i2) * distance);
            double[] dArr = new double[2];
            if (this.item.alignFacePoints != null && this.item.alignFacePoints.length > 0) {
                if (this.item.alignFacePoints.length == 1) {
                    if (this.item.alignFacePoints[0] < list2.size()) {
                        dArr = new double[]{(double) ((PointF) list2.get(this.item.alignFacePoints[0])).x, (double) ((PointF) list2.get(this.item.alignFacePoints[0])).y};
                    }
                } else if (this.item.alignFacePoints.length == 2 && this.item.alignFacePoints[0] < list2.size() && this.item.alignFacePoints[1] < list2.size()) {
                    r1 = new double[2];
                    r1[0] = (double) ((((PointF) list2.get(this.item.alignFacePoints[1])).x + ((PointF) list2.get(this.item.alignFacePoints[0])).x) / 2.0f);
                    r1[1] = (double) ((((PointF) list2.get(this.item.alignFacePoints[1])).y + ((PointF) list2.get(this.item.alignFacePoints[0])).y) / 2.0f);
                    dArr = r1;
                }
            }
            if (this.item.anchorPoint != null && this.item.anchorPoint.length >= 2) {
                this.item.position[0] = dArr[0] - ((double) ((((float) this.item.anchorPoint[0]) * distance) / 720.0f));
                this.item.position[1] = dArr[1] - ((double) ((((float) this.item.anchorPoint[1]) * distance) / 960.0f));
            }
        }
        int i3 = i2;
        int i4 = i;
        double d;
        int i5;
        int i6;
        float[] calPositions;
        if (((double) this.width) / ((double) this.height) >= 0.75d) {
            d = ((double) this.width) / 720.0d;
            i5 = (int) (((double) this.width) / 0.75d);
            i6 = (int) (((double) this.width) * this.item.position[0]);
            i2 = ((int) (((double) i5) * this.item.position[1])) - ((i5 - this.height) / 2);
            calPositions = AlgoUtils.calPositions((float) i6, (float) (((double) i2) + (((double) i3) * d)), (float) ((d * ((double) i4)) + ((double) i6)), (float) i2, this.width, this.height);
            if (this.item.scaleDirection == 0) {
                setPositions(AlgoUtils.adjustPosition(calPositions, (float) this.triggerCtrlItem.getAudioScaleFactor()));
                AppMethodBeat.o(82970);
                return;
            }
            setPositions(AlgoUtils.adjustPosition(calPositions, (float) this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection));
            AppMethodBeat.o(82970);
            return;
        }
        d = ((double) this.height) / 960.0d;
        i5 = (int) (((double) this.height) * 0.75d);
        i2 = (int) (((double) this.height) * this.item.position[1]);
        i6 = ((int) (((double) i5) * this.item.position[0])) - ((i5 - this.width) / 2);
        calPositions = AlgoUtils.calPositions((float) i6, (float) (((double) i2) + (((double) i3) * d)), (float) ((d * ((double) i4)) + ((double) i6)), (float) i2, this.width, this.height);
        if (this.item.scaleDirection == 0) {
            setPositions(AlgoUtils.adjustPosition(calPositions, (float) this.triggerCtrlItem.getAudioScaleFactor()));
            AppMethodBeat.o(82970);
            return;
        }
        setPositions(AlgoUtils.adjustPosition(calPositions, (float) this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection));
        AppMethodBeat.o(82970);
    }

    private void initFabbyPositionAdjust() {
        AppMethodBeat.i(82971);
        if (this.item.aspectMode == 1) {
            setPositions(GlUtil.ORIGIN_POSITION_COORDS);
            AppMethodBeat.o(82971);
            return;
        }
        double d = ((double) this.item.width) / ((double) this.item.height);
        double d2;
        int i;
        int i2;
        int i3;
        if (((double) this.width) / ((double) this.height) >= d) {
            d2 = ((double) this.width) / 720.0d;
            i = (int) (((double) this.width) / d);
            i2 = (int) (((double) this.width) * this.item.position[0]);
            i3 = ((int) (((double) i) * this.item.position[1])) - ((i - this.height) / 2);
            setPositions(AlgoUtils.calPositions((float) i2, (float) (((double) i3) + (((double) this.item.height) * d2)), (float) ((d2 * ((double) this.item.width)) + ((double) i2)), (float) i3, this.width, this.height));
            AppMethodBeat.o(82971);
            return;
        }
        d2 = (((double) this.height) / 720.0d) * d;
        i = (int) (((double) this.height) * d);
        i3 = (int) (((double) this.height) * this.item.position[1]);
        i2 = ((int) (((double) i) * this.item.position[0])) - ((i - this.width) / 2);
        setPositions(AlgoUtils.calPositions((float) i2, (float) (((double) i3) + (((double) this.item.height) * d2)), (float) ((d2 * ((double) this.item.width)) + ((double) i2)), (float) i3, this.width, this.height));
        AppMethodBeat.o(82971);
    }

    public void setRatioMode(RATIO_MODE ratio_mode) {
        this.ratioMode = ratio_mode;
    }

    private void initRelativeParams() {
        AppMethodBeat.i(82972);
        this.relativePivotsPts_4_3 = new ArrayList();
        this.relativePivotsPts_4_3.add(new PointF(360.0f, 480.0f));
        this.relativePivotsPts_4_3.add(new PointF(0.0f, 0.0f));
        this.relativePivotsPts_4_3.add(new PointF(360.0f, 0.0f));
        this.relativePivotsPts_4_3.add(new PointF(720.0f, 0.0f));
        this.relativePivotsPts_4_3.add(new PointF(0.0f, 480.0f));
        this.relativePivotsPts_4_3.add(new PointF(720.0f, 480.0f));
        this.relativePivotsPts_4_3.add(new PointF(0.0f, 960.0f));
        this.relativePivotsPts_4_3.add(new PointF(360.0f, 960.0f));
        this.relativePivotsPts_4_3.add(new PointF(720.0f, 960.0f));
        this.relativePivotsPts_16_9 = new ArrayList();
        this.relativePivotsPts_16_9.add(new PointF(360.0f, 480.0f));
        this.relativePivotsPts_16_9.add(new PointF(90.0f, 0.0f));
        this.relativePivotsPts_16_9.add(new PointF(360.0f, 0.0f));
        this.relativePivotsPts_16_9.add(new PointF(630.0f, 0.0f));
        this.relativePivotsPts_16_9.add(new PointF(90.0f, 480.0f));
        this.relativePivotsPts_16_9.add(new PointF(630.0f, 480.0f));
        this.relativePivotsPts_16_9.add(new PointF(90.0f, 960.0f));
        this.relativePivotsPts_16_9.add(new PointF(360.0f, 960.0f));
        this.relativePivotsPts_16_9.add(new PointF(630.0f, 960.0f));
        this.relativePivotsPts_1_1 = new ArrayList();
        this.relativePivotsPts_1_1.add(new PointF(360.0f, 480.0f));
        this.relativePivotsPts_1_1.add(new PointF(0.0f, 120.0f));
        this.relativePivotsPts_1_1.add(new PointF(360.0f, 120.0f));
        this.relativePivotsPts_1_1.add(new PointF(720.0f, 120.0f));
        this.relativePivotsPts_1_1.add(new PointF(0.0f, 480.0f));
        this.relativePivotsPts_1_1.add(new PointF(720.0f, 480.0f));
        this.relativePivotsPts_1_1.add(new PointF(0.0f, 840.0f));
        this.relativePivotsPts_1_1.add(new PointF(360.0f, 840.0f));
        this.relativePivotsPts_1_1.add(new PointF(720.0f, 840.0f));
        this.relativePosPts_4_3 = new ArrayList();
        this.relativePosPts_4_3.add(new PointF(0.5f, 0.5f));
        this.relativePosPts_4_3.add(new PointF(0.0f, 0.0f));
        this.relativePosPts_4_3.add(new PointF(0.5f, 0.0f));
        this.relativePosPts_4_3.add(new PointF(1.0f, 0.0f));
        this.relativePosPts_4_3.add(new PointF(0.0f, 0.5f));
        this.relativePosPts_4_3.add(new PointF(1.0f, 0.5f));
        this.relativePosPts_4_3.add(new PointF(0.0f, 1.0f));
        this.relativePosPts_4_3.add(new PointF(0.5f, 1.0f));
        this.relativePosPts_4_3.add(new PointF(1.0f, 1.0f));
        this.relativePosPts_16_9 = new ArrayList();
        this.relativePosPts_16_9.add(new PointF(0.5f, 0.5f));
        this.relativePosPts_16_9.add(new PointF(0.125f, 0.0f));
        this.relativePosPts_16_9.add(new PointF(0.5f, 0.0f));
        this.relativePosPts_16_9.add(new PointF(0.875f, 0.0f));
        this.relativePosPts_16_9.add(new PointF(0.125f, 0.5f));
        this.relativePosPts_16_9.add(new PointF(0.875f, 0.5f));
        this.relativePosPts_16_9.add(new PointF(0.125f, 1.0f));
        this.relativePosPts_16_9.add(new PointF(0.5f, 1.0f));
        this.relativePosPts_16_9.add(new PointF(0.875f, 1.0f));
        this.relativePosPts_1_1 = new ArrayList();
        this.relativePosPts_1_1.add(new PointF(0.5f, 0.5f));
        this.relativePosPts_1_1.add(new PointF(0.0f, 0.125f));
        this.relativePosPts_1_1.add(new PointF(0.5f, 0.125f));
        this.relativePosPts_1_1.add(new PointF(1.0f, 0.125f));
        this.relativePosPts_1_1.add(new PointF(0.0f, 0.5f));
        this.relativePosPts_1_1.add(new PointF(1.0f, 0.5f));
        this.relativePosPts_1_1.add(new PointF(0.0f, 0.875f));
        this.relativePosPts_1_1.add(new PointF(0.5f, 0.875f));
        this.relativePosPts_1_1.add(new PointF(1.0f, 0.875f));
        AppMethodBeat.o(82972);
    }
}
