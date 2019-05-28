package com.tencent.p177mm.plugin.appbrand.jsapi.container;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45578c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.container.c */
public final class C26957c extends C45578c {
    public static final int CTRL_INDEX = 510;
    public static final String NAME = "updatePositioningContainer";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.container.c$a */
    public class C10369a implements Interpolator {
        /* renamed from: a */
        protected PointF f2871a;
        /* renamed from: b */
        protected PointF f2872b;
        private int hIQ;
        private final PointF hIR;
        private final PointF hIS;
        protected PointF hIT;
        protected PointF hIU;
        protected PointF hIV;

        private C10369a(PointF pointF, PointF pointF2) {
            AppMethodBeat.m2504i(126283);
            this.hIQ = 0;
            this.hIR = new PointF();
            this.hIS = new PointF();
            this.f2871a = new PointF();
            this.f2872b = new PointF();
            this.hIV = new PointF();
            IllegalArgumentException illegalArgumentException;
            if (pointF.x < 0.0f || pointF.x > 1.0f) {
                illegalArgumentException = new IllegalArgumentException("startX value must be in the range [0, 1]");
                AppMethodBeat.m2505o(126283);
                throw illegalArgumentException;
            } else if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
                illegalArgumentException = new IllegalArgumentException("endX value must be in the range [0, 1]");
                AppMethodBeat.m2505o(126283);
                throw illegalArgumentException;
            } else {
                this.hIT = pointF;
                this.hIU = pointF2;
                AppMethodBeat.m2505o(126283);
            }
        }

        public C10369a(C26957c c26957c) {
            this(new PointF(0.0f, 0.0f), new PointF(0.58f, 1.0f));
            AppMethodBeat.m2504i(126284);
            AppMethodBeat.m2505o(126284);
        }

        public final float getInterpolation(float f) {
            AppMethodBeat.m2504i(126285);
            float f2 = f;
            for (int i = 1; i < 14; i++) {
                this.hIV.x = this.hIT.x * 3.0f;
                this.f2872b.x = ((this.hIU.x - this.hIT.x) * 3.0f) - this.hIV.x;
                this.f2871a.x = (1.0f - this.hIV.x) - this.f2872b.x;
                float f3 = ((this.hIV.x + ((this.f2872b.x + (this.f2871a.x * f2)) * f2)) * f2) - f;
                if (((double) Math.abs(f3)) < 0.001d) {
                    break;
                }
                f2 -= f3 / (this.hIV.x + (((2.0f * this.f2872b.x) + ((this.f2871a.x * 3.0f) * f2)) * f2));
            }
            this.hIV.y = this.hIT.y * 3.0f;
            this.f2872b.y = ((this.hIU.y - this.hIT.y) * 3.0f) - this.hIV.y;
            this.f2871a.y = (1.0f - this.hIV.y) - this.f2872b.y;
            float f4 = (this.hIV.y + ((this.f2872b.y + (this.f2871a.y * f2)) * f2)) * f2;
            AppMethodBeat.m2505o(126285);
            return f4;
        }
    }

    /* renamed from: c */
    public final boolean mo6167c(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126286);
        if (view instanceof WrapperNativeContainerView) {
            int a = C42668g.m75555a(jSONObject, "contentOffsetLeft", 0);
            int a2 = C42668g.m75555a(jSONObject, "contentOffsetTop", 0);
            int optInt = jSONObject.optInt("animate", 0);
            WrapperNativeContainerView wrapperNativeContainerView = (WrapperNativeContainerView) view;
            try {
                wrapperNativeContainerView.setVisibility(jSONObject.getBoolean("visible") ? 0 : 4);
            } catch (JSONException e) {
            }
            final AppBrandNativeContainerView appBrandNativeContainerView = (AppBrandNativeContainerView) wrapperNativeContainerView.mo60996ah(AppBrandNativeContainerView.class);
            C4990ab.m7417i("MicroMsg.JsApiUpdatePositioningContainer", "scrollLeft:%d, scrollTop:%d, animation:%d", Integer.valueOf(a), Integer.valueOf(a2), Integer.valueOf(optInt));
            if (optInt == 1) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(appBrandNativeContainerView, VideoMaterialUtil.CRAZYFACE_X, new float[]{appBrandNativeContainerView.getX(), (float) (-a)});
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(appBrandNativeContainerView, VideoMaterialUtil.CRAZYFACE_Y, new float[]{appBrandNativeContainerView.getY(), (float) (-a2)});
                ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.m2504i(126281);
                        appBrandNativeContainerView.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        AppMethodBeat.m2505o(126281);
                    }
                });
                ofFloat2.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.m2504i(126282);
                        appBrandNativeContainerView.setY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        AppMethodBeat.m2505o(126282);
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(1000);
                animatorSet.setInterpolator(new C10369a(this));
                animatorSet.setTarget(appBrandNativeContainerView);
                animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
                animatorSet.start();
            } else {
                appBrandNativeContainerView.setX((float) (-a));
                appBrandNativeContainerView.setY((float) (-a2));
            }
            C4990ab.m7417i("MicroMsg.JsApiUpdatePositioningContainer", "innerHeight:%d, innerWidth:%d", Integer.valueOf(C42668g.m75555a(jSONObject, "innerHeight", appBrandNativeContainerView.getHeight())), Integer.valueOf(C42668g.m75555a(jSONObject, "innerWidth", appBrandNativeContainerView.getWidth())));
            LayoutParams layoutParams = appBrandNativeContainerView.getLayoutParams();
            layoutParams.height = a;
            layoutParams.width = a2;
            appBrandNativeContainerView.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(126286);
            return true;
        }
        AppMethodBeat.m2505o(126286);
        return false;
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126287);
        int i = jSONObject.getInt("containerId");
        AppMethodBeat.m2505o(126287);
        return i;
    }
}
