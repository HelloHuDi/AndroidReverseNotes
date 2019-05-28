package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.LinearInterpolator;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.g;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.tencentmap.mapsdk.map.Projection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    private LinkedList<g> jkb;
    Marker jkc;
    private SoSoMapView jkd;
    f jke;
    public AnimatorSet uB;

    public c(LinkedList<g> linkedList, Marker marker, SoSoMapView soSoMapView) {
        AppMethodBeat.i(51262);
        this.jkb = linkedList;
        this.jkc = marker;
        this.jkd = soSoMapView;
        init();
        AppMethodBeat.o(51262);
    }

    private void init() {
        AppMethodBeat.i(51263);
        this.uB = new AnimatorSet();
        this.jke = new f();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.jkb.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (gVar.rotate != 0.0f) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.jkc.getRotation(), this.jkc.getRotation() + gVar.rotate});
                ofFloat.setDuration((long) gVar.duration);
                ofFloat.setInterpolator(new LinearInterpolator());
                ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(51261);
                        c.this.jkc.setRotation((float) Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue())));
                        AppMethodBeat.o(51261);
                    }
                });
                arrayList.add(ofFloat);
            } else {
                arrayList.add(a(gVar));
            }
        }
        this.uB.playSequentially(arrayList);
        AppMethodBeat.o(51263);
    }

    private ValueAnimator a(g gVar) {
        AppMethodBeat.i(51264);
        LatLng[] latLngArr = new LatLng[]{new LatLng(gVar.hNS, gVar.hNR), new LatLng(gVar.latitude, gVar.longitude)};
        final e b = this.jke.b(latLngArr[0]);
        final e b2 = this.jke.b(latLngArr[1]);
        final double[] dArr = new double[1];
        Projection projection = this.jkd.getProjection();
        double d = 0.0d;
        for (int i = 0; i <= 0; i++) {
            dArr[0] = projection.distanceBetween(latLngArr[0], latLngArr[1]);
            d = dArr[0] + 0.0d;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration((long) ((((double) gVar.duration) * dArr[0]) / d));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setFloatValues(new float[]{(float) dArr[0]});
        valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(51260);
                if (b.equals(b2)) {
                    AppMethodBeat.o(51260);
                    return;
                }
                double parseDouble = Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue()));
                double d = b.x + (((b2.x - b.x) * parseDouble) / dArr[0]);
                parseDouble = ((parseDouble * (b2.y - b.y)) / dArr[0]) + b.y;
                Marker marker = c.this.jkc;
                f fVar = c.this.jke;
                e eVar = new e(d, parseDouble);
                marker.setPosition(new LatLng(90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (eVar.y / fVar.jkq))) * 2.0d) * 3.141592653589793d)) * 2.0d), ((eVar.x / fVar.jkq) - 0.5d) * 360.0d));
                AppMethodBeat.o(51260);
            }
        });
        AppMethodBeat.o(51264);
        return valueAnimator;
    }
}
