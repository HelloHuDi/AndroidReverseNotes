package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.o */
public final class C27011o extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 198;
    public static final String NAME = "setNavigationBarColor";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74767);
        C38492q c38492q = (C38492q) c2241c;
        try {
            int Ef = C42668g.m75552Ef(jSONObject.getString("frontColor"));
            int Ef2 = C42668g.m75552Ef(jSONObject.getString("backgroundColor"));
            double optDouble = jSONObject.optDouble("alpha", 1.0d);
            int i2 = 0;
            Object obj = "";
            JSONObject optJSONObject = jSONObject.optJSONObject("animation");
            if (optJSONObject != null) {
                i2 = optJSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                obj = optJSONObject.optString("timingFunc");
            }
            final C44709u currentPageView = c38492q.getCurrentPageView();
            if (currentPageView == null) {
                c38492q.mo6107M(i, mo73394j("fail:page don't exist", null));
                AppMethodBeat.m2505o(74767);
                return;
            }
            int backgroundColor = currentPageView.getActionBar().getBackgroundColor();
            int foregroundColor = currentPageView.getActionBar().getForegroundColor();
            double backgroundAlpha = currentPageView.getActionBar().getBackgroundAlpha();
            TimeInterpolator linearInterpolator = "linear".equals(obj) ? new LinearInterpolator() : "easeIn".equals(obj) ? new AccelerateInterpolator() : "easeOut".equals(obj) ? new DecelerateInterpolator() : "easeInOut".equals(obj) ? new AccelerateDecelerateInterpolator() : null;
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{backgroundColor, Ef2});
            valueAnimator.setEvaluator(new ArgbEvaluator());
            valueAnimator.setDuration((long) i2);
            valueAnimator.setInterpolator(linearInterpolator);
            valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.m2504i(74764);
                    currentPageView.mo53751nV(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    AppMethodBeat.m2505o(74764);
                }
            });
            ValueAnimator valueAnimator2 = new ValueAnimator();
            valueAnimator2.setIntValues(new int[]{foregroundColor, Ef});
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            valueAnimator2.setDuration((long) i2);
            valueAnimator2.setInterpolator(linearInterpolator);
            valueAnimator2.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.m2504i(74765);
                    currentPageView.mo53752nW(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    AppMethodBeat.m2505o(74765);
                }
            });
            ValueAnimator valueAnimator3 = new ValueAnimator();
            valueAnimator3.setFloatValues(new float[]{(float) backgroundAlpha, (float) optDouble});
            valueAnimator3.setDuration((long) i2);
            valueAnimator3.setInterpolator(linearInterpolator);
            valueAnimator3.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.m2504i(74766);
                    currentPageView.mo71771u((double) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                    AppMethodBeat.m2505o(74766);
                }
            });
            valueAnimator.start();
            valueAnimator2.start();
            c38492q.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(74767);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiSetNavigationBarColor", "Color parse error");
            c38492q.mo6107M(i, mo73394j("fail:invalid color", null));
            AppMethodBeat.m2505o(74767);
        }
    }
}
