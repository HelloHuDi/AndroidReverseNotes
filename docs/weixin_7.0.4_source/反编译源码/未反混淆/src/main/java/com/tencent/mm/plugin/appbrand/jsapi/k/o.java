package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class o extends a<q> {
    public static final int CTRL_INDEX = 198;
    public static final String NAME = "setNavigationBarColor";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74767);
        q qVar = (q) cVar;
        try {
            int Ef = g.Ef(jSONObject.getString("frontColor"));
            int Ef2 = g.Ef(jSONObject.getString("backgroundColor"));
            double optDouble = jSONObject.optDouble("alpha", 1.0d);
            int i2 = 0;
            Object obj = "";
            JSONObject optJSONObject = jSONObject.optJSONObject("animation");
            if (optJSONObject != null) {
                i2 = optJSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                obj = optJSONObject.optString("timingFunc");
            }
            final u currentPageView = qVar.getCurrentPageView();
            if (currentPageView == null) {
                qVar.M(i, j("fail:page don't exist", null));
                AppMethodBeat.o(74767);
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
                    AppMethodBeat.i(74764);
                    currentPageView.nV(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    AppMethodBeat.o(74764);
                }
            });
            ValueAnimator valueAnimator2 = new ValueAnimator();
            valueAnimator2.setIntValues(new int[]{foregroundColor, Ef});
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            valueAnimator2.setDuration((long) i2);
            valueAnimator2.setInterpolator(linearInterpolator);
            valueAnimator2.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(74765);
                    currentPageView.nW(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    AppMethodBeat.o(74765);
                }
            });
            ValueAnimator valueAnimator3 = new ValueAnimator();
            valueAnimator3.setFloatValues(new float[]{(float) backgroundAlpha, (float) optDouble});
            valueAnimator3.setDuration((long) i2);
            valueAnimator3.setInterpolator(linearInterpolator);
            valueAnimator3.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(74766);
                    currentPageView.u((double) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                    AppMethodBeat.o(74766);
                }
            });
            valueAnimator.start();
            valueAnimator2.start();
            qVar.M(i, j("ok", null));
            AppMethodBeat.o(74767);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiSetNavigationBarColor", "Color parse error");
            qVar.M(i, j("fail:invalid color", null));
            AppMethodBeat.o(74767);
        }
    }
}
