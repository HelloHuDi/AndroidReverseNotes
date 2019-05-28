package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.b;
import com.tencent.filter.m.d;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.j;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.ArrayList;
import java.util.List;

public abstract class WMAnimationFilterBase extends BaseFilter {
    private static final String TAG = WMAnimationFilterBase.class.getSimpleName();
    protected List<AnimationTimePoint> mAnimationTimePoints = new ArrayList();
    private int mDuration;
    private long mStartTime;

    protected class AnimationTimePoint {
        public long timePoint;
        public float value;

        AnimationTimePoint(long j, float f) {
            this.timePoint = j;
            this.value = f;
        }
    }

    public abstract void initAnimationTimePoints();

    public abstract void setAnimationParams();

    public WMAnimationFilterBase(WMElement wMElement, int i, int i2, int i3) {
        super(FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/WMAnimationVertexShader.dat"), FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/WMAnimationFragmentShader.dat"));
        initParams(wMElement, i, i2, i3);
    }

    private void initParams(WMElement wMElement, int i, int i2, int i3) {
        addParam(new i("texNeedTransform", 1));
        addParam(new b("canvasSize", (float) i, (float) i2));
        addParam(new b("texAnchor", ((wMElement.finalContentRect.left + wMElement.finalContentRect.right) / 2.0f) - ((float) (i / 2)), ((wMElement.finalContentRect.top + wMElement.finalContentRect.bottom) / 2.0f) - ((float) (i2 / 2))));
        addParam(new f("texScale", 1.0f));
        addParam(new d("texRotate", 0.0f, 0.0f, 0.0f));
        addParam(new j("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0f, 4.0f, 10.0f)));
        this.mStartTime = System.currentTimeMillis();
        this.mDuration = i3;
        initAnimationTimePoints();
    }

    public void updateParams(WMElement wMElement, int i, int i2) {
        addParam(new b("canvasSize", (float) i, (float) i2));
        addParam(new b("texAnchor", ((wMElement.finalContentRect.left + wMElement.finalContentRect.right) / 2.0f) - ((float) (i / 2)), ((wMElement.finalContentRect.top + wMElement.finalContentRect.bottom) / 2.0f) - ((float) (i2 / 2))));
    }

    /* Access modifiers changed, original: protected */
    public float getAnimationValue() {
        long currentTimeMillis = (System.currentTimeMillis() - this.mStartTime) % ((long) this.mDuration);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.mAnimationTimePoints.size()) {
                return 0.0f;
            }
            AnimationTimePoint animationTimePoint = (AnimationTimePoint) this.mAnimationTimePoints.get(i2 - 1);
            AnimationTimePoint animationTimePoint2 = (AnimationTimePoint) this.mAnimationTimePoints.get(i2);
            if (currentTimeMillis <= animationTimePoint2.timePoint) {
                float f = (((float) (currentTimeMillis - animationTimePoint.timePoint)) * 1.0f) / ((float) (animationTimePoint2.timePoint - animationTimePoint.timePoint));
                return ((animationTimePoint2.value - animationTimePoint.value) * f) + animationTimePoint.value;
            }
            i = i2 + 1;
        }
    }

    public boolean renderTexture(int i, int i2, int i3) {
        setAnimationParams();
        return super.renderTexture(i, i2, i3);
    }
}
