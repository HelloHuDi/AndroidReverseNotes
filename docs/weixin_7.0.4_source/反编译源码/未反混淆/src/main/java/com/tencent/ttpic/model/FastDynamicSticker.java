package com.tencent.ttpic.model;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;

public class FastDynamicSticker extends FastSticker {
    private Point canvasCenter;

    public FastDynamicSticker(StickerItem stickerItem, String str) {
        super(stickerItem, str);
    }

    /* Access modifiers changed, original: protected */
    public void updatePositions(List<PointF> list, float[] fArr) {
        AppMethodBeat.i(83488);
        if (BaseUtils.isEmpty(list) || fArr == null || fArr.length < 3 || !isValidItem(this.item)) {
            clearTextureParam();
            AppMethodBeat.o(83488);
            return;
        }
        int i;
        PointF pointF = (PointF) list.get(this.item.alignFacePoints[0]);
        if (this.item.alignFacePoints.length == 1) {
            i = this.item.alignFacePoints[0];
        } else {
            i = this.item.alignFacePoints[1];
        }
        PointF pointF2 = (PointF) list.get(i);
        PointF pointF3 = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        pointF3.x = (float) (((double) pointF3.x) * (1.0d / this.mScreenScale));
        pointF3.y = (float) (((double) pointF3.y) * (1.0d / this.mScreenScale));
        float f = pointF3.x - ((float) this.item.anchorPoint[0]);
        float f2 = pointF3.y - ((float) this.item.anchorPoint[1]);
        float f3 = f + ((float) this.item.width);
        float f4 = ((float) this.item.height) + f2;
        this.renderParam.position = AlgoUtils.calPositionsTriangles(f, f4, f3, f2, this.width, this.height);
        this.renderParam.texAnchor[0] = pointF3.x - ((float) this.canvasCenter.x);
        this.renderParam.texAnchor[1] = pointF3.y - ((float) this.canvasCenter.y);
        pointF2 = new PointF(((PointF) list.get(this.item.scalePivots[0])).x, ((PointF) list.get(this.item.scalePivots[0])).y);
        pointF2.x = (float) (((double) pointF2.x) * (1.0d / this.mScreenScale));
        pointF2.y = (float) (((double) pointF2.y) * (1.0d / this.mScreenScale));
        PointF pointF4 = new PointF(((PointF) list.get(this.item.scalePivots[1])).x, ((PointF) list.get(this.item.scalePivots[1])).y);
        pointF4.x = (float) (((double) pointF4.x) * (1.0d / this.mScreenScale));
        pointF4.y = (float) (((double) pointF4.y) * (1.0d / this.mScreenScale));
        this.renderParam.texScale = (float) (Math.sqrt(Math.pow((double) (pointF2.y - pointF4.y), 2.0d) + Math.pow((double) (pointF2.x - pointF4.x), 2.0d)) / ((double) this.item.scaleFactor));
        if (this.item.support3D == 1) {
            this.renderParam.texRotate[0] = fArr[0];
            this.renderParam.texRotate[1] = fArr[1];
            this.renderParam.texRotate[2] = -fArr[2];
            AppMethodBeat.o(83488);
            return;
        }
        this.renderParam.texRotate[0] = 0.0f;
        this.renderParam.texRotate[1] = 0.0f;
        this.renderParam.texRotate[2] = -fArr[2];
        AppMethodBeat.o(83488);
    }

    public void updatePositions(List<PointF> list) {
        AppMethodBeat.i(83489);
        if (BaseUtils.isEmpty(list) || !isValidItem(this.item)) {
            clearTextureParam();
            AppMethodBeat.o(83489);
            return;
        }
        PointF pointF = (PointF) list.get(this.item.alignFacePoints[0]);
        PointF pointF2 = (PointF) list.get(this.item.alignFacePoints.length == 1 ? this.item.alignFacePoints[0] : this.item.alignFacePoints[1]);
        PointF pointF3 = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        pointF3.x = (float) (((double) pointF3.x) * (1.0d / this.mScreenScale));
        pointF3.y = (float) (((double) pointF3.y) * (1.0d / this.mScreenScale));
        float f = pointF3.x - ((float) this.item.anchorPoint[0]);
        float f2 = pointF3.y - ((float) this.item.anchorPoint[1]);
        float f3 = ((float) this.item.height) + f2;
        this.renderParam.position = AlgoUtils.calPositionsTriangles(f, f3, f + ((float) this.item.width), f2, this.width, this.height);
        this.renderParam.texAnchor[0] = pointF3.x - ((float) this.canvasCenter.x);
        this.renderParam.texAnchor[1] = pointF3.y - ((float) this.canvasCenter.y);
        PointF pointF4 = new PointF(((PointF) list.get(this.item.scalePivots[0])).x, ((PointF) list.get(this.item.scalePivots[0])).y);
        pointF4.x = (float) (((double) pointF4.x) * (1.0d / this.mScreenScale));
        pointF4.y = (float) (((double) pointF4.y) * (1.0d / this.mScreenScale));
        PointF pointF5 = new PointF(((PointF) list.get(this.item.scalePivots[1])).x, ((PointF) list.get(this.item.scalePivots[1])).y);
        pointF5.x = (float) (((double) pointF5.x) * (1.0d / this.mScreenScale));
        pointF5.y = (float) (((double) pointF5.y) * (1.0d / this.mScreenScale));
        this.renderParam.texScale = (float) (Math.sqrt(Math.pow((double) (pointF4.y - pointF5.y), 2.0d) + Math.pow((double) (pointF4.x - pointF5.x), 2.0d)) / ((double) this.item.scaleFactor));
        if (this.item.alignFacePoints.length > 1) {
            f = (float) Math.atan2((double) (pointF.y - pointF2.y), (double) (pointF.x - pointF2.x));
            this.renderParam.texRotate[0] = 0.0f;
            this.renderParam.texRotate[1] = 0.0f;
            this.renderParam.texRotate[2] = f - this.item.angle;
        }
        AppMethodBeat.o(83489);
    }

    public static boolean isValidItem(StickerItem stickerItem) {
        if (stickerItem == null || stickerItem.alignFacePoints == null || stickerItem.alignFacePoints.length <= 0 || stickerItem.anchorPoint == null || stickerItem.anchorPoint.length < 2 || stickerItem.scalePivots == null || stickerItem.scalePivots.length < 2) {
            return false;
        }
        return true;
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(83490);
        super.updateVideoSize(i, i2, d);
        this.canvasCenter = new Point(i / 2, i2 / 2);
        AppMethodBeat.o(83490);
    }
}
