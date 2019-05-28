package com.tencent.p177mm.plugin.location.p446ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelgeo.Addr;
import com.tencent.p177mm.modelgeo.C18657c;
import com.tencent.p177mm.modelgeo.C18657c.C18660a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.location.ui.impl.PickPoi */
public class PickPoi extends RelativeLayout {
    /* renamed from: De */
    Animation f17899De;
    private Context context;
    View nLu;
    protected C18657c nOO;
    public C18660a nOV = new C123841();
    private double nQe;
    private double nQf;
    private C43245f nQg = new C43245f();
    boolean nQh = true;
    private C46052e nQi = null;

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.PickPoi$1 */
    class C123841 implements C18660a {
        C123841() {
        }

        /* renamed from: b */
        public final void mo8746b(Addr addr) {
            AppMethodBeat.m2504i(113648);
            C4990ab.m7411d("MicroMsg.PickPoi", "onGetAddrss  %s", addr.toString());
            if (PickPoi.this.nQg == null) {
                C4990ab.m7416i("MicroMsg.PickPoi", "error, empty poi!");
                AppMethodBeat.m2505o(113648);
                return;
            }
            C43245f a = PickPoi.this.nQg;
            a.nQz = addr;
            a.nQp = addr.fBg;
            a.bDG = (double) addr.fBr;
            a.bDH = (double) addr.fBs;
            a.nQt = addr.fBh;
            a.nQu = addr.fBi;
            a.nQw = addr.fBm;
            a.nQy = addr.fBo;
            a.nQB = addr.fBq;
            C4990ab.m7411d("poidata", "roughAddr %s", addr.toString());
            if (PickPoi.this.nQi != null) {
                PickPoi.this.nQi.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(113648);
        }
    }

    public PickPoi(Context context) {
        super(context);
        AppMethodBeat.m2504i(113649);
        this.context = context;
        init();
        AppMethodBeat.m2505o(113649);
    }

    public PickPoi(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113650);
        this.context = context;
        init();
        AppMethodBeat.m2505o(113650);
    }

    public PickPoi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(113651);
        this.context = context;
        init();
        AppMethodBeat.m2505o(113651);
    }

    public void setAdapter(C46052e c46052e) {
        this.nQi = c46052e;
    }

    private void init() {
        AppMethodBeat.m2504i(113652);
        this.nOO = C18657c.agw();
        this.f17899De = AnimationUtils.loadAnimation(this.context, C25738R.anim.f8416dx);
        this.nLu = LayoutInflater.from(this.context).inflate(2130969945, this, true).findViewById(2131825273);
        AppMethodBeat.m2505o(113652);
    }

    /* renamed from: l */
    public final void mo73944l(double d, double d2) {
        AppMethodBeat.m2504i(113653);
        this.nQe = d;
        this.nQf = d2;
        this.nQg = new C43245f();
        this.nQg.type = 3;
        this.nQg.mName = this.context.getResources().getString(C25738R.string.cnn);
        this.nQg.bDG = d;
        this.nQg.bDH = d2;
        this.nQg.nQp = "";
        this.nOO.mo33925a(this.nOV);
        this.nOO.mo33923a(d, d2, this.nOV);
        this.nQh = true;
        AppMethodBeat.m2505o(113653);
    }

    /* renamed from: m */
    public final void mo73945m(double d, double d2) {
        AppMethodBeat.m2504i(113654);
        mo73944l(d, d2);
        this.nQh = false;
        AppMethodBeat.m2505o(113654);
    }

    public C43245f getPoi() {
        return this.nQg;
    }

    public void setLocationArrow(int i) {
        AppMethodBeat.m2504i(113655);
        ((ImageView) this.nLu).setImageResource(i);
        AppMethodBeat.m2505o(113655);
    }
}
