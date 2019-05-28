package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.page.ao.a;
import com.tencent.mm.plugin.appbrand.page.ar;
import com.tencent.mm.plugin.appbrand.page.au;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y.b;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class g extends AbsoluteLayout implements ad, af, ao, ar, b, d {
    private final List<a> jdA = new LinkedList();
    final e jdB;
    private final AbsoluteLayout jdC;
    private final u jdD;
    private boolean jdE;
    private int jdF;
    private int jdG;

    public g(u uVar) {
        super(uVar.mContext);
        AppMethodBeat.i(123600);
        super.setId(R.id.a0);
        this.jdD = uVar;
        this.jdC = this;
        this.jdB = new e(this.jdC);
        AppMethodBeat.o(123600);
    }

    public final void setId(int i) {
    }

    public final <Input extends View & ab> boolean a(aj ajVar, Input input, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(123601);
        boolean b = b(ajVar, input, i, i2, i3, i4);
        AppMethodBeat.o(123601);
        return b;
    }

    private <Input extends View & ab> boolean b(aj ajVar, Input input, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(123602);
        if (ajVar == null || ajVar.getWrapperView() == null || input == null) {
            AppMethodBeat.o(123602);
            return false;
        }
        a(ajVar);
        this.jdC.addView(input, new LayoutParams(i, i2, i3, i4));
        ((ab) input).y(this.jdD);
        AppMethodBeat.o(123602);
        return true;
    }

    private void a(aj ajVar) {
        AppMethodBeat.i(123603);
        View wrapperView = ajVar.getWrapperView();
        if (!(this.jdC.getWidth() == wrapperView.getWidth() && this.jdC.getHeight() == wrapperView.getHeight())) {
            ViewGroup.LayoutParams layoutParams = this.jdC.getLayoutParams();
            layoutParams.width = wrapperView.getWidth();
            layoutParams.height = wrapperView.getHeight();
            this.jdC.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(123603);
    }

    public final <Input extends View & ab> boolean c(aj ajVar, Input input, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(123604);
        if (ajVar == null || ajVar.getWrapperView() == null || input == null) {
            AppMethodBeat.o(123604);
            return false;
        } else if (cE(input)) {
            a(ajVar);
            if (input.getLayoutParams() == null || !(input.getLayoutParams() instanceof LayoutParams)) {
                AppMethodBeat.o(123604);
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
            AppMethodBeat.o(123604);
            return true;
        } else {
            AppMethodBeat.o(123604);
            return false;
        }
    }

    private <Input extends View & ab> boolean cE(Input input) {
        AppMethodBeat.i(123605);
        if (input == null) {
            AppMethodBeat.o(123605);
            return false;
        } else if (this.jdC == null) {
            AppMethodBeat.o(123605);
            return false;
        } else {
            for (int i = 0; i < this.jdC.getChildCount(); i++) {
                if (input == this.jdC.getChildAt(i)) {
                    AppMethodBeat.o(123605);
                    return true;
                }
            }
            AppMethodBeat.o(123605);
            return false;
        }
    }

    public final <Input extends View & ab> void cF(Input input) {
        AppMethodBeat.i(123606);
        if (input == null) {
            AppMethodBeat.o(123606);
            return;
        }
        input.setVisibility(8);
        ab.v("MicroMsg.AppBrandInputContainer", "clearWebView imm active = %b", Boolean.valueOf(aj.cS(this).isActive()));
        this.jdC.removeView(input);
        ((ab) input).z(this.jdD);
        AppMethodBeat.o(123606);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.i(123607);
        ab.v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.jdC != null) {
            c(false, view.getWidth(), view.getHeight());
            this.jdC.scrollTo(i, i2);
        }
        for (a dk : this.jdA) {
            dk.dk(i, i2);
        }
        AppMethodBeat.o(123607);
    }

    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void nT(int i) {
        AppMethodBeat.i(123608);
        setTranslationY((float) i);
        AppMethodBeat.o(123608);
    }

    public final boolean aOQ() {
        AppMethodBeat.i(123609);
        if (getChildCount() <= 0) {
            AppMethodBeat.o(123609);
            return false;
        }
        for (int i = 0; i <= getChildCount(); i++) {
            if (AppBrandViewMotionCompat.cB(getChildAt(i))) {
                AppMethodBeat.o(123609);
                return true;
            }
        }
        AppMethodBeat.o(123609);
        return false;
    }

    public final boolean E(MotionEvent motionEvent) {
        AppMethodBeat.i(123610);
        if (motionEvent == null || motionEvent.getActionMasked() != 0) {
            AppMethodBeat.o(123610);
            return false;
        }
        e eVar = this.jdB;
        if (motionEvent == null || motionEvent.getActionMasked() != 0 || eVar.iVl == null) {
            AppMethodBeat.o(123610);
            return false;
        } else if (motionEvent.getDownTime() == eVar.iVl.iVm && motionEvent.getEventTime() == eVar.iVl.iVn) {
            AppMethodBeat.o(123610);
            return true;
        } else {
            AppMethodBeat.o(123610);
            return false;
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(123611);
        if (aVar == null) {
            AppMethodBeat.o(123611);
        } else if (this.jdA.contains(aVar)) {
            AppMethodBeat.o(123611);
        } else {
            this.jdA.add(aVar);
            AppMethodBeat.o(123611);
        }
    }

    public final void b(a aVar) {
        AppMethodBeat.i(123612);
        if (aVar == null) {
            AppMethodBeat.o(123612);
            return;
        }
        this.jdA.remove(aVar);
        AppMethodBeat.o(123612);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(123613);
        boolean z = (!isLayoutRequested() && i == this.jdF && i2 == this.jdG) ? false : true;
        this.jdE = z;
        this.jdF = i;
        this.jdG = i2;
        super.onMeasure(i, i2);
        this.jdE = false;
        AppMethodBeat.o(123613);
    }

    /* Access modifiers changed, original: protected|final */
    public final void measureChild(View view, int i, int i2) {
        AppMethodBeat.i(123614);
        if (this.jdE) {
            view.forceLayout();
        }
        super.measureChild(view, i, i2);
        AppMethodBeat.o(123614);
    }

    public final void c(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(123615);
        if (c(z, i3 - i, i4 - i2)) {
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(123599);
                    g.a(g.this);
                    AppMethodBeat.o(123599);
                }
            });
        }
        AppMethodBeat.o(123615);
    }

    private boolean c(boolean z, int i, int i2) {
        AppMethodBeat.i(123616);
        if (this.jdC == null) {
            AppMethodBeat.o(123616);
            return false;
        }
        ViewGroup.LayoutParams layoutParams = this.jdC.getLayoutParams();
        if (layoutParams == null) {
            this.jdC.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            AppMethodBeat.o(123616);
            return true;
        } else if (i == layoutParams.width && i2 == layoutParams.height) {
            AppMethodBeat.o(123616);
            return z;
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
            this.jdC.setLayoutParams(layoutParams);
            AppMethodBeat.o(123616);
            return true;
        }
    }

    public final boolean g(Canvas canvas) {
        AppMethodBeat.i(123617);
        canvas.save();
        canvas.translate((float) (-getScrollX()), (float) (-getScrollY()));
        if (au.i(this)) {
            au.a(canvas, this, 0.0f, 0.0f);
        } else {
            com.tencent.mm.sdk.platformtools.d.a(canvas, (View) this);
        }
        canvas.restore();
        AppMethodBeat.o(123617);
        return true;
    }
}
