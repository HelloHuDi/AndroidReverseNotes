package com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.d */
public final class C19388d extends LinearLayout implements C33322h {
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

    public C19388d(Context context) {
        super(context);
        AppMethodBeat.m2504i(51235);
        this.context = context;
        this.hOq = (ImageView) View.inflate(this.context, 2130969265, this).findViewById(2131823251);
        this.hOq.requestFocus();
        AppMethodBeat.m2505o(51235);
    }

    public final double getLatitude() {
        return this.hOr;
    }

    public final double getLongitude() {
        return this.hOs;
    }

    /* renamed from: J */
    public final void mo34547J(float f, float f2) {
        AppMethodBeat.m2504i(51236);
        this.hOx = f2;
        m30064ao(getHeading());
        AppMethodBeat.m2505o(51236);
    }

    private float getHeading() {
        if (this.hOy) {
            return this.hOv;
        }
        return this.hOx;
    }

    /* renamed from: ao */
    private void m30064ao(float f) {
        AppMethodBeat.m2504i(51237);
        if (this.hNK != null) {
            C4990ab.m7419v("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", Float.valueOf(f));
            this.hNK.setRotation(f);
        }
        AppMethodBeat.m2505o(51237);
    }
}
