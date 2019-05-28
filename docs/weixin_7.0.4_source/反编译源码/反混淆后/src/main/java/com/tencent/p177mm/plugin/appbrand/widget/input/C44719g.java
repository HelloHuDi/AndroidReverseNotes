package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.page.C19625ar;
import com.tencent.p177mm.plugin.appbrand.page.C2408ao;
import com.tencent.p177mm.plugin.appbrand.page.C2408ao.C2409a;
import com.tencent.p177mm.plugin.appbrand.page.C27221aj;
import com.tencent.p177mm.plugin.appbrand.page.C33469au;
import com.tencent.p177mm.plugin.appbrand.page.C33481y.C33484b;
import com.tencent.p177mm.plugin.appbrand.page.C38459ad;
import com.tencent.p177mm.plugin.appbrand.page.C42644af;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.p177mm.plugin.appbrand.widget.base.C33590d;
import com.tencent.p177mm.plugin.appbrand.widget.base.C33591e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.g */
public final class C44719g extends AbsoluteLayout implements C38459ad, C42644af, C2408ao, C19625ar, C33484b, C33590d {
    private final List<C2409a> jdA = new LinkedList();
    final C33591e jdB;
    private final AbsoluteLayout jdC;
    private final C44709u jdD;
    private boolean jdE;
    private int jdF;
    private int jdG;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.g$1 */
    class C110181 implements Runnable {
        C110181() {
        }

        public final void run() {
            AppMethodBeat.m2504i(123599);
            C44719g.m81417a(C44719g.this);
            AppMethodBeat.m2505o(123599);
        }
    }

    public C44719g(C44709u c44709u) {
        super(c44709u.mContext);
        AppMethodBeat.m2504i(123600);
        super.setId(2131820570);
        this.jdD = c44709u;
        this.jdC = this;
        this.jdB = new C33591e(this.jdC);
        AppMethodBeat.m2505o(123600);
    }

    public final void setId(int i) {
    }

    /* renamed from: a */
    public final <Input extends View & C38595ab> boolean mo71784a(C27221aj c27221aj, Input input, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(123601);
        boolean b = m81418b(c27221aj, input, i, i2, i3, i4);
        AppMethodBeat.m2505o(123601);
        return b;
    }

    /* renamed from: b */
    private <Input extends View & C38595ab> boolean m81418b(C27221aj c27221aj, Input input, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(123602);
        if (c27221aj == null || c27221aj.getWrapperView() == null || input == null) {
            AppMethodBeat.m2505o(123602);
            return false;
        }
        m81416a(c27221aj);
        this.jdC.addView(input, new LayoutParams(i, i2, i3, i4));
        ((C38595ab) input).mo6620y(this.jdD);
        AppMethodBeat.m2505o(123602);
        return true;
    }

    /* renamed from: a */
    private void m81416a(C27221aj c27221aj) {
        AppMethodBeat.m2504i(123603);
        View wrapperView = c27221aj.getWrapperView();
        if (!(this.jdC.getWidth() == wrapperView.getWidth() && this.jdC.getHeight() == wrapperView.getHeight())) {
            ViewGroup.LayoutParams layoutParams = this.jdC.getLayoutParams();
            layoutParams.width = wrapperView.getWidth();
            layoutParams.height = wrapperView.getHeight();
            this.jdC.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(123603);
    }

    /* renamed from: c */
    public final <Input extends View & C38595ab> boolean mo71785c(C27221aj c27221aj, Input input, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(123604);
        if (c27221aj == null || c27221aj.getWrapperView() == null || input == null) {
            AppMethodBeat.m2505o(123604);
            return false;
        } else if (m81420cE(input)) {
            m81416a(c27221aj);
            if (input.getLayoutParams() == null || !(input.getLayoutParams() instanceof LayoutParams)) {
                AppMethodBeat.m2505o(123604);
                return false;
            }
            if (!(input.getWidth() == i && input.getHeight() == i2 && input.getLeft() == i3 && input.getTop() == i4)) {
                LayoutParams layoutParams = (LayoutParams) input.getLayoutParams();
                layoutParams.x = i3;
                layoutParams.y = i4;
                layoutParams.width = i;
                layoutParams.height = i2;
                input.setLayoutParams(layoutParams);
            }
            AppMethodBeat.m2505o(123604);
            return true;
        } else {
            AppMethodBeat.m2505o(123604);
            return false;
        }
    }

    /* renamed from: cE */
    private <Input extends View & C38595ab> boolean m81420cE(Input input) {
        AppMethodBeat.m2504i(123605);
        if (input == null) {
            AppMethodBeat.m2505o(123605);
            return false;
        } else if (this.jdC == null) {
            AppMethodBeat.m2505o(123605);
            return false;
        } else {
            for (int i = 0; i < this.jdC.getChildCount(); i++) {
                if (input == this.jdC.getChildAt(i)) {
                    AppMethodBeat.m2505o(123605);
                    return true;
                }
            }
            AppMethodBeat.m2505o(123605);
            return false;
        }
    }

    /* renamed from: cF */
    public final <Input extends View & C38595ab> void mo71786cF(Input input) {
        AppMethodBeat.m2504i(123606);
        if (input == null) {
            AppMethodBeat.m2505o(123606);
            return;
        }
        input.setVisibility(8);
        C4990ab.m7419v("MicroMsg.AppBrandInputContainer", "clearWebView imm active = %b", Boolean.valueOf(C45720aj.m84475cS(this).isActive()));
        this.jdC.removeView(input);
        ((C38595ab) input).mo6621z(this.jdD);
        AppMethodBeat.m2505o(123606);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.m2504i(123607);
        C4990ab.m7419v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.jdC != null) {
            m81419c(false, view.getWidth(), view.getHeight());
            this.jdC.scrollTo(i, i2);
        }
        for (C2409a dk : this.jdA) {
            dk.mo6321dk(i, i2);
        }
        AppMethodBeat.m2505o(123607);
    }

    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    /* renamed from: nT */
    public final void mo21652nT(int i) {
        AppMethodBeat.m2504i(123608);
        setTranslationY((float) i);
        AppMethodBeat.m2505o(123608);
    }

    public final boolean aOQ() {
        AppMethodBeat.m2504i(123609);
        if (getChildCount() <= 0) {
            AppMethodBeat.m2505o(123609);
            return false;
        }
        for (int i = 0; i <= getChildCount(); i++) {
            if (AppBrandViewMotionCompat.m43426cB(getChildAt(i))) {
                AppMethodBeat.m2505o(123609);
                return true;
            }
        }
        AppMethodBeat.m2505o(123609);
        return false;
    }

    /* renamed from: E */
    public final boolean mo54104E(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(123610);
        if (motionEvent == null || motionEvent.getActionMasked() != 0) {
            AppMethodBeat.m2505o(123610);
            return false;
        }
        C33591e c33591e = this.jdB;
        if (motionEvent == null || motionEvent.getActionMasked() != 0 || c33591e.iVl == null) {
            AppMethodBeat.m2505o(123610);
            return false;
        } else if (motionEvent.getDownTime() == c33591e.iVl.iVm && motionEvent.getEventTime() == c33591e.iVl.iVn) {
            AppMethodBeat.m2505o(123610);
            return true;
        } else {
            AppMethodBeat.m2505o(123610);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo6319a(C2409a c2409a) {
        AppMethodBeat.m2504i(123611);
        if (c2409a == null) {
            AppMethodBeat.m2505o(123611);
        } else if (this.jdA.contains(c2409a)) {
            AppMethodBeat.m2505o(123611);
        } else {
            this.jdA.add(c2409a);
            AppMethodBeat.m2505o(123611);
        }
    }

    /* renamed from: b */
    public final void mo6320b(C2409a c2409a) {
        AppMethodBeat.m2504i(123612);
        if (c2409a == null) {
            AppMethodBeat.m2505o(123612);
            return;
        }
        this.jdA.remove(c2409a);
        AppMethodBeat.m2505o(123612);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(123613);
        boolean z = (!isLayoutRequested() && i == this.jdF && i2 == this.jdG) ? false : true;
        this.jdE = z;
        this.jdF = i;
        this.jdG = i2;
        super.onMeasure(i, i2);
        this.jdE = false;
        AppMethodBeat.m2505o(123613);
    }

    /* Access modifiers changed, original: protected|final */
    public final void measureChild(View view, int i, int i2) {
        AppMethodBeat.m2504i(123614);
        if (this.jdE) {
            view.forceLayout();
        }
        super.measureChild(view, i, i2);
        AppMethodBeat.m2505o(123614);
    }

    /* renamed from: c */
    public final void mo21650c(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(123615);
        if (m81419c(z, i3 - i, i4 - i2)) {
            post(new C110181());
        }
        AppMethodBeat.m2505o(123615);
    }

    /* renamed from: c */
    private boolean m81419c(boolean z, int i, int i2) {
        AppMethodBeat.m2504i(123616);
        if (this.jdC == null) {
            AppMethodBeat.m2505o(123616);
            return false;
        }
        ViewGroup.LayoutParams layoutParams = this.jdC.getLayoutParams();
        if (layoutParams == null) {
            this.jdC.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            AppMethodBeat.m2505o(123616);
            return true;
        } else if (i == layoutParams.width && i2 == layoutParams.height) {
            AppMethodBeat.m2505o(123616);
            return z;
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
            this.jdC.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(123616);
            return true;
        }
    }

    /* renamed from: g */
    public final boolean mo22183g(Canvas canvas) {
        AppMethodBeat.m2504i(123617);
        canvas.save();
        canvas.translate((float) (-getScrollX()), (float) (-getScrollY()));
        if (C33469au.m54679i(this)) {
            C33469au.m54678a(canvas, this, 0.0f, 0.0f);
        } else {
            C5056d.m7626a(canvas, (View) this);
        }
        canvas.restore();
        AppMethodBeat.m2505o(123617);
        return true;
    }
}
