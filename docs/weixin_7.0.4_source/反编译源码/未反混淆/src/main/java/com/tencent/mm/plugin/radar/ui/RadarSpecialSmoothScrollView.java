package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001eB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0006\u0010\u001d\u001a\u00020\u0016R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isLayoutChanged", "", "()Z", "isOverScroll", "mLastMotionY", "", "mRect", "Landroid/graphics/Rect;", "mRootChildView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "mScrollInterpolator", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator;", "mTranslateAnimation", "Landroid/view/animation/TranslateAnimation;", "onFinishInflate", "", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "scaleOverScroll", "", "offset", "startAnimation", "WorkspaceOvershootInterpolator", "plugin-radar_release"})
public class RadarSpecialSmoothScrollView extends ScrollView {
    private float mLastMotionY;
    private final Rect mRect = new Rect();
    private RadarSpecialTableLayout pCL;
    private TranslateAnimation pCM;
    private final a pCN = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator;", "Landroid/view/animation/Interpolator;", "()V", "mTension", "", "getInterpolation", "t", "Companion", "plugin-radar_release"})
    static final class a implements Interpolator {
        private static final float pCP = pCP;
        public static final a pCQ = new a();
        private final float pCO = pCP;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator$Companion;", "", "()V", "DEFAULT_TENSION", "", "plugin-radar_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (((f2 * (this.pCO + 1.0f)) + this.pCO) * (f2 * f2)) + 1.0f;
        }

        static {
            AppMethodBeat.i(103008);
            AppMethodBeat.o(103008);
        }
    }

    public RadarSpecialSmoothScrollView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.i(103011);
        AppMethodBeat.o(103011);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(103009);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (!(childAt instanceof RadarSpecialTableLayout)) {
                childAt = null;
            }
            this.pCL = (RadarSpecialTableLayout) childAt;
        }
        AppMethodBeat.o(103009);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        AppMethodBeat.i(103010);
        j.p(motionEvent, "ev");
        boolean onTouchEvent;
        if (this.pCL == null) {
            onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(103010);
            return onTouchEvent;
        }
        RadarSpecialTableLayout radarSpecialTableLayout;
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastMotionY = motionEvent.getY();
                break;
            case 1:
                this.mLastMotionY = 0.0f;
                if (this.mRect.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    radarSpecialTableLayout = this.pCL;
                    if (radarSpecialTableLayout == null) {
                        j.dWJ();
                    }
                    this.pCM = new TranslateAnimation(0.0f, 0.0f, (float) (radarSpecialTableLayout.getTop() - this.mRect.top), 0.0f);
                    TranslateAnimation translateAnimation = this.pCM;
                    if (translateAnimation == null) {
                        j.dWJ();
                    }
                    translateAnimation.setInterpolator(this.pCN);
                    TranslateAnimation translateAnimation2 = this.pCM;
                    if (translateAnimation2 == null) {
                        j.dWJ();
                    }
                    radarSpecialTableLayout = this.pCL;
                    if (radarSpecialTableLayout == null) {
                        j.dWJ();
                    }
                    translateAnimation2.setDuration((long) Math.abs(radarSpecialTableLayout.getTop() - this.mRect.top));
                    radarSpecialTableLayout = this.pCL;
                    if (radarSpecialTableLayout == null) {
                        j.dWJ();
                    }
                    radarSpecialTableLayout.startAnimation(this.pCM);
                    RadarSpecialTableLayout radarSpecialTableLayout2 = this.pCL;
                    if (radarSpecialTableLayout2 == null) {
                        j.dWJ();
                    }
                    radarSpecialTableLayout2.D(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
                    this.mRect.setEmpty();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY();
                if (this.mLastMotionY == 0.0f) {
                    this.mLastMotionY = y;
                }
                RadarSpecialTableLayout radarSpecialTableLayout3 = this.pCL;
                if (radarSpecialTableLayout3 == null) {
                    j.dWJ();
                }
                int measuredHeight = radarSpecialTableLayout3.getMeasuredHeight() - getHeight();
                int scrollY = getScrollY();
                if (!(scrollY == 0 || scrollY == measuredHeight)) {
                    i = 0;
                }
                if (i != 0) {
                    RadarSpecialTableLayout radarSpecialTableLayout4;
                    RadarSpecialTableLayout radarSpecialTableLayout5;
                    int right;
                    RadarSpecialTableLayout radarSpecialTableLayout6;
                    i = (int) (this.mLastMotionY - y);
                    scrollBy(0, i);
                    if (this.mRect.isEmpty()) {
                        Rect rect = this.mRect;
                        radarSpecialTableLayout3 = this.pCL;
                        if (radarSpecialTableLayout3 == null) {
                            j.dWJ();
                        }
                        measuredHeight = radarSpecialTableLayout3.getLeft();
                        radarSpecialTableLayout4 = this.pCL;
                        if (radarSpecialTableLayout4 == null) {
                            j.dWJ();
                        }
                        scrollY = radarSpecialTableLayout4.getTop();
                        radarSpecialTableLayout5 = this.pCL;
                        if (radarSpecialTableLayout5 == null) {
                            j.dWJ();
                        }
                        right = radarSpecialTableLayout5.getRight();
                        radarSpecialTableLayout6 = this.pCL;
                        if (radarSpecialTableLayout6 == null) {
                            j.dWJ();
                        }
                        rect.set(measuredHeight, scrollY, right, radarSpecialTableLayout6.getBottom());
                    }
                    radarSpecialTableLayout = this.pCL;
                    if (radarSpecialTableLayout == null) {
                        j.dWJ();
                    }
                    radarSpecialTableLayout3 = this.pCL;
                    if (radarSpecialTableLayout3 == null) {
                        j.dWJ();
                    }
                    measuredHeight = radarSpecialTableLayout3.getLeft();
                    radarSpecialTableLayout4 = this.pCL;
                    if (radarSpecialTableLayout4 == null) {
                        j.dWJ();
                    }
                    scrollY = radarSpecialTableLayout4.getTop() - (i / 2);
                    radarSpecialTableLayout5 = this.pCL;
                    if (radarSpecialTableLayout5 == null) {
                        j.dWJ();
                    }
                    right = radarSpecialTableLayout5.getRight();
                    radarSpecialTableLayout6 = this.pCL;
                    if (radarSpecialTableLayout6 == null) {
                        j.dWJ();
                    }
                    radarSpecialTableLayout.D(measuredHeight, scrollY, right, radarSpecialTableLayout6.getBottom() - (i / 2));
                } else {
                    scrollBy(0, ((int) (this.mLastMotionY - y)) / 2);
                }
                this.mLastMotionY = y;
                break;
        }
        onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(103010);
        return onTouchEvent;
    }
}
