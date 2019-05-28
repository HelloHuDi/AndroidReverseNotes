package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends LinearLayout implements h {
    private Context context;
    Marker hNK;
    private ImageView hOq;
    double hOr = -1.0d;
    double hOs = -1.0d;
    double hOt = -1.0d;
    double hOu = -1.0d;
    float hOv = 900.0f;
    float hOw = 900.0f;
    private float hOx = 0.0f;
    boolean hOy;

    public d(Context context) {
        super(context);
        AppMethodBeat.i(51235);
        this.context = context;
        this.hOq = (ImageView) View.inflate(this.context, R.layout.rv, this).findViewById(R.id.b96);
        this.hOq.requestFocus();
        AppMethodBeat.o(51235);
    }

    public final double getLatitude() {
        return this.hOr;
    }

    public final double getLongitude() {
        return this.hOs;
    }

    public final void J(float f, float f2) {
        AppMethodBeat.i(51236);
        this.hOx = f2;
        ao(getHeading());
        AppMethodBeat.o(51236);
    }

    private float getHeading() {
        if (this.hOy) {
            return this.hOv;
        }
        return this.hOx;
    }

    private void ao(float f) {
        AppMethodBeat.i(51237);
        if (this.hNK != null) {
            ab.v("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", Float.valueOf(f));
            this.hNK.setRotation(f);
        }
        AppMethodBeat.o(51237);
    }
}
