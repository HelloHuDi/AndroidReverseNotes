package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.sdk.platformtools.ab;

public class PickPoi extends RelativeLayout {
    Animation De;
    private Context context;
    View nLu;
    protected c nOO;
    public a nOV = new a() {
        public final void b(Addr addr) {
            AppMethodBeat.i(113648);
            ab.d("MicroMsg.PickPoi", "onGetAddrss  %s", addr.toString());
            if (PickPoi.this.nQg == null) {
                ab.i("MicroMsg.PickPoi", "error, empty poi!");
                AppMethodBeat.o(113648);
                return;
            }
            f a = PickPoi.this.nQg;
            a.nQz = addr;
            a.nQp = addr.fBg;
            a.bDG = (double) addr.fBr;
            a.bDH = (double) addr.fBs;
            a.nQt = addr.fBh;
            a.nQu = addr.fBi;
            a.nQw = addr.fBm;
            a.nQy = addr.fBo;
            a.nQB = addr.fBq;
            ab.d("poidata", "roughAddr %s", addr.toString());
            if (PickPoi.this.nQi != null) {
                PickPoi.this.nQi.notifyDataSetChanged();
            }
            AppMethodBeat.o(113648);
        }
    };
    private double nQe;
    private double nQf;
    private f nQg = new f();
    boolean nQh = true;
    private e nQi = null;

    public PickPoi(Context context) {
        super(context);
        AppMethodBeat.i(113649);
        this.context = context;
        init();
        AppMethodBeat.o(113649);
    }

    public PickPoi(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113650);
        this.context = context;
        init();
        AppMethodBeat.o(113650);
    }

    public PickPoi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(113651);
        this.context = context;
        init();
        AppMethodBeat.o(113651);
    }

    public void setAdapter(e eVar) {
        this.nQi = eVar;
    }

    private void init() {
        AppMethodBeat.i(113652);
        this.nOO = c.agw();
        this.De = AnimationUtils.loadAnimation(this.context, R.anim.dx);
        this.nLu = LayoutInflater.from(this.context).inflate(R.layout.a_7, this, true).findViewById(R.id.cpu);
        AppMethodBeat.o(113652);
    }

    public final void l(double d, double d2) {
        AppMethodBeat.i(113653);
        this.nQe = d;
        this.nQf = d2;
        this.nQg = new f();
        this.nQg.type = 3;
        this.nQg.mName = this.context.getResources().getString(R.string.cnn);
        this.nQg.bDG = d;
        this.nQg.bDH = d2;
        this.nQg.nQp = "";
        this.nOO.a(this.nOV);
        this.nOO.a(d, d2, this.nOV);
        this.nQh = true;
        AppMethodBeat.o(113653);
    }

    public final void m(double d, double d2) {
        AppMethodBeat.i(113654);
        l(d, d2);
        this.nQh = false;
        AppMethodBeat.o(113654);
    }

    public f getPoi() {
        return this.nQg;
    }

    public void setLocationArrow(int i) {
        AppMethodBeat.i(113655);
        ((ImageView) this.nLu).setImageResource(i);
        AppMethodBeat.o(113655);
    }
}
