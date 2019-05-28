package com.tencent.ttpic.filter;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.filter.m.b;
import com.tencent.filter.m.d;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.List;

public class DynamicStickerFilter extends NormalVideoFilter {
    private static final int LENTH_POINTS_ANGLE = 4;
    private String TAG = DynamicStickerFilter.class.getSimpleName();
    private Point canvasCenter;

    public DynamicStickerFilter(StickerItem stickerItem, String str) {
        super(stickerItem, str);
        AppMethodBeat.i(82173);
        AppMethodBeat.o(82173);
    }

    /* Access modifiers changed, original: protected */
    public void updatePositions(List<PointF> list, float[] fArr, float f) {
        AppMethodBeat.i(82174);
        if (BaseUtils.isEmpty(list) || fArr == null || fArr.length < 3 || !isValidItem(this.item)) {
            clearTextureParam();
            AppMethodBeat.o(82174);
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
        pointF3.x = (float) (((double) pointF3.x) / this.mFaceDetScale);
        pointF3.y = (float) (((double) pointF3.y) / this.mFaceDetScale);
        float f2 = pointF3.x - ((float) this.item.anchorPoint[0]);
        float f3 = pointF3.y - ((float) this.item.anchorPoint[1]);
        setPositions(AlgoUtils.adjustPosition(AlgoUtils.calPositions(f2, ((float) this.item.height) + f3, f2 + ((float) this.item.width), f3, this.width, this.height), (float) this.triggerCtrlItem.getAudioScaleFactor()));
        addParam(new b("texAnchor", pointF3.x - ((float) this.canvasCenter.x), pointF3.y - ((float) this.canvasCenter.y)));
        pointF2 = new PointF(((PointF) list.get(this.item.scalePivots[0])).x, ((PointF) list.get(this.item.scalePivots[0])).y);
        pointF2.x = (float) (((double) pointF2.x) / this.mFaceDetScale);
        pointF2.y = (float) (((double) pointF2.y) / this.mFaceDetScale);
        PointF pointF4 = new PointF(((PointF) list.get(this.item.scalePivots[1])).x, ((PointF) list.get(this.item.scalePivots[1])).y);
        pointF4.x = (float) (((double) pointF4.x) / this.mFaceDetScale);
        pointF4.y = (float) (((double) pointF4.y) / this.mFaceDetScale);
        addParam(new f("texScale", (float) (Math.sqrt(Math.pow((double) (pointF2.y - pointF4.y), 2.0d) + Math.pow((double) (pointF2.x - pointF4.x), 2.0d)) / ((double) this.item.scaleFactor))));
        if (this.item.support3D == 1) {
            addParam(new d("texRotate", fArr[0], fArr[1], (-fArr[2]) - this.item.angle));
            AppMethodBeat.o(82174);
            return;
        }
        addParam(new d("texRotate", 0.0f, 0.0f, (-fArr[2]) - this.item.angle));
        AppMethodBeat.o(82174);
    }

    /* Access modifiers changed, original: protected */
    public void updatePositions(List<PointF> list) {
        AppMethodBeat.i(82175);
        super.updatePositions(list);
        if (BaseUtils.isEmpty(list) || !isValidItem(this.item)) {
            clearTextureParam();
            AppMethodBeat.o(82175);
            return;
        }
        PointF pointF = (PointF) list.get(this.item.alignFacePoints[0]);
        PointF pointF2 = (PointF) list.get(this.item.alignFacePoints.length == 1 ? this.item.alignFacePoints[0] : this.item.alignFacePoints[1]);
        PointF pointF3 = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        pointF3.x = (float) (((double) pointF3.x) / this.mFaceDetScale);
        pointF3.y = (float) (((double) pointF3.y) / this.mFaceDetScale);
        float f = pointF3.x - ((float) this.item.anchorPoint[0]);
        float f2 = pointF3.y - ((float) this.item.anchorPoint[1]);
        setPositions(AlgoUtils.adjustPosition(AlgoUtils.calPositions(f, ((float) this.item.height) + f2, f + ((float) this.item.width), f2, this.width, this.height), (float) this.triggerCtrlItem.getAudioScaleFactor()));
        addParam(new b("texAnchor", pointF3.x - ((float) this.canvasCenter.x), pointF3.y - ((float) this.canvasCenter.y)));
        PointF pointF4 = new PointF(((PointF) list.get(this.item.scalePivots[0])).x, ((PointF) list.get(this.item.scalePivots[0])).y);
        pointF4.x = (float) (((double) pointF4.x) / this.mFaceDetScale);
        pointF4.y = (float) (((double) pointF4.y) / this.mFaceDetScale);
        PointF pointF5 = new PointF(((PointF) list.get(this.item.scalePivots[1])).x, ((PointF) list.get(this.item.scalePivots[1])).y);
        pointF5.x = (float) (((double) pointF5.x) / this.mFaceDetScale);
        pointF5.y = (float) (((double) pointF5.y) / this.mFaceDetScale);
        addParam(new f("texScale", (float) (Math.sqrt(Math.pow((double) (pointF4.y - pointF5.y), 2.0d) + Math.pow((double) (pointF4.x - pointF5.x), 2.0d)) / ((double) this.item.scaleFactor))));
        if (this.item.alignFacePoints.length > 1) {
            addParam(new d("texRotate", 0.0f, 0.0f, ((float) Math.atan2((double) (pointF.y - pointF2.y), (double) (pointF.x - pointF2.x))) - this.item.angle));
        }
        AppMethodBeat.o(82175);
    }

    public static boolean isValidItem(StickerItem stickerItem) {
        if (stickerItem == null || stickerItem.alignFacePoints == null || stickerItem.alignFacePoints.length <= 0 || stickerItem.anchorPoint == null || stickerItem.anchorPoint.length < 2 || stickerItem.scalePivots == null || stickerItem.scalePivots.length < 2) {
            return false;
        }
        return true;
    }

    private boolean isValidPoint(Point point) {
        if (point != null && point.x >= 0 && point.x <= this.width && point.y >= 0 && point.y <= this.height) {
            return true;
        }
        return false;
    }

    public void initParams() {
        AppMethodBeat.i(82176);
        super.initParams();
        addParam(new i("texNeedTransform", 1));
        addParam(new b("canvasSize", 0.0f, 0.0f));
        addParam(new b("texAnchor", 0.0f, 0.0f));
        addParam(new f("texScale", 1.0f));
        addParam(new d("texRotate", 0.0f, 0.0f, 0.0f));
        addParam(new j("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0f, 4.0f, 10.0f)));
        AppMethodBeat.o(82176);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82177);
        super.updateVideoSize(i, i2, d);
        this.canvasCenter = new Point(i / 2, i2 / 2);
        addParam(new b("canvasSize", (float) i, (float) i2));
        AppMethodBeat.o(82177);
    }

    public boolean isBodyNeeded() {
        if (this.item.type == POSITION_TYPE.BODY.type) {
            return true;
        }
        return false;
    }
}
