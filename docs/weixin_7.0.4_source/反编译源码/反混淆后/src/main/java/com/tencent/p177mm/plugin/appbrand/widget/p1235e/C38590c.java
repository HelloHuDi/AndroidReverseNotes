package com.tencent.p177mm.plugin.appbrand.widget.p1235e;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.LinearInterpolator;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10409g;
import com.tencent.p177mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.tencentmap.mapsdk.map.Projection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.e.c */
public final class C38590c {
    private LinkedList<C10409g> jkb;
    Marker jkc;
    private SoSoMapView jkd;
    C27392f jke;
    /* renamed from: uB */
    public AnimatorSet f16155uB;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.e.c$2 */
    class C336102 implements AnimatorUpdateListener {
        C336102() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(51261);
            C38590c.this.jkc.setRotation((float) Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue())));
            AppMethodBeat.m2505o(51261);
        }
    }

    public C38590c(LinkedList<C10409g> linkedList, Marker marker, SoSoMapView soSoMapView) {
        AppMethodBeat.m2504i(51262);
        this.jkb = linkedList;
        this.jkc = marker;
        this.jkd = soSoMapView;
        init();
        AppMethodBeat.m2505o(51262);
    }

    private void init() {
        AppMethodBeat.m2504i(51263);
        this.f16155uB = new AnimatorSet();
        this.jke = new C27392f();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.jkb.iterator();
        while (it.hasNext()) {
            C10409g c10409g = (C10409g) it.next();
            if (c10409g.rotate != 0.0f) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.jkc.getRotation(), this.jkc.getRotation() + c10409g.rotate});
                ofFloat.setDuration((long) c10409g.duration);
                ofFloat.setInterpolator(new LinearInterpolator());
                ofFloat.addUpdateListener(new C336102());
                arrayList.add(ofFloat);
            } else {
                arrayList.add(m65396a(c10409g));
            }
        }
        this.f16155uB.playSequentially(arrayList);
        AppMethodBeat.m2505o(51263);
    }

    /* renamed from: a */
    private ValueAnimator m65396a(C10409g c10409g) {
        AppMethodBeat.m2504i(51264);
        LatLng[] latLngArr = new LatLng[]{new LatLng(c10409g.hNS, c10409g.hNR), new LatLng(c10409g.latitude, c10409g.longitude)};
        final C19855e b = this.jke.mo45130b(latLngArr[0]);
        final C19855e b2 = this.jke.mo45130b(latLngArr[1]);
        final double[] dArr = new double[1];
        Projection projection = this.jkd.getProjection();
        double d = 0.0d;
        for (int i = 0; i <= 0; i++) {
            dArr[0] = projection.distanceBetween(latLngArr[0], latLngArr[1]);
            d = dArr[0] + 0.0d;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration((long) ((((double) c10409g.duration) * dArr[0]) / d));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setFloatValues(new float[]{(float) dArr[0]});
        valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.m2504i(51260);
                if (b.equals(b2)) {
                    AppMethodBeat.m2505o(51260);
                    return;
                }
                double parseDouble = Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue()));
                double d = b.f4363x + (((b2.f4363x - b.f4363x) * parseDouble) / dArr[0]);
                parseDouble = ((parseDouble * (b2.f4364y - b.f4364y)) / dArr[0]) + b.f4364y;
                Marker marker = C38590c.this.jkc;
                C27392f c27392f = C38590c.this.jke;
                C19855e c19855e = new C19855e(d, parseDouble);
                marker.setPosition(new LatLng(90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (c19855e.f4364y / c27392f.jkq))) * 2.0d) * 3.141592653589793d)) * 2.0d), ((c19855e.f4363x / c27392f.jkq) - 0.5d) * 360.0d));
                AppMethodBeat.m2505o(51260);
            }
        });
        AppMethodBeat.m2505o(51264);
        return valueAnimator;
    }
}
