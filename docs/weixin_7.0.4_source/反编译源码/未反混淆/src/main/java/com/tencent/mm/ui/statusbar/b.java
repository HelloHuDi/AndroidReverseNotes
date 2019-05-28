package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.statusbar.c.a;

public class b extends FrameLayout implements a {
    static final boolean zzH = c.zzP;
    private boolean anv = false;
    private int iJp;
    private final Activity mActivity;
    private final Paint mPaint;
    private int zzI = 0;
    private int zzJ = 0;
    private boolean zzK = false;
    private boolean zzL = false;
    private boolean zzM = false;

    public void pO(int i) {
        AppMethodBeat.i(67833);
        PH(i);
        AppMethodBeat.o(67833);
    }

    public final void qM(boolean z) {
        AppMethodBeat.i(67834);
        this.zzK = z;
        PH(this.iJp);
        AppMethodBeat.o(67834);
    }

    public b(Context context) {
        super(context);
        AppMethodBeat.i(67835);
        if (zzH) {
            this.mActivity = d.cY(context);
            c.az(this.mActivity).a(this);
            this.mPaint = new Paint(0);
            this.mPaint.setStyle(Style.FILL);
            setWillNotDraw(false);
            AppMethodBeat.o(67835);
            return;
        }
        this.mActivity = null;
        this.mPaint = null;
        AppMethodBeat.o(67835);
    }

    private void PH(int i) {
        AppMethodBeat.i(67836);
        ab.d("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b]", Integer.valueOf(i), Boolean.valueOf(this.anv));
        this.iJp = Math.max(0, i);
        if (this.anv) {
            this.zzL = true;
            AppMethodBeat.o(67836);
            return;
        }
        try {
            setPadding(0, this.zzK ? 0 : this.iJp, 0, 0);
        } catch (IllegalStateException e) {
            ab.w("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight setPadding e=%s", e.getMessage());
        }
        dJn();
        AppMethodBeat.o(67836);
    }

    private void dJn() {
        AppMethodBeat.i(67837);
        if (al.isMainThread()) {
            invalidate();
            AppMethodBeat.o(67837);
            return;
        }
        postInvalidate();
        AppMethodBeat.o(67837);
    }

    public void requestLayout() {
        AppMethodBeat.i(67838);
        if (this.anv) {
            this.zzM = true;
            AppMethodBeat.o(67838);
            return;
        }
        super.requestLayout();
        AppMethodBeat.o(67838);
    }

    public void setStatusBarColor(int i) {
        AppMethodBeat.i(67839);
        if (zzH) {
            K(i, d.b(this.mActivity.getWindow()));
            AppMethodBeat.o(67839);
            return;
        }
        AppMethodBeat.o(67839);
    }

    public void K(int i, boolean z) {
        AppMethodBeat.i(67840);
        a(i, z, true);
        AppMethodBeat.o(67840);
    }

    public final void a(int i, boolean z, boolean z2) {
        AppMethodBeat.i(67841);
        int i2 = this.zzI;
        int i3 = this.zzJ;
        this.zzI = i;
        if (zzH) {
            b bVar;
            int argb;
            b bVar2;
            Window window = this.mActivity.getWindow();
            d.a(window);
            if (z2 ? d.a(window, z) : d.dJo()) {
                this.zzI = i;
                bVar = this;
            } else {
                if (VERSION.SDK_INT >= 21) {
                    if (z) {
                        i = ae.Jj(i);
                    }
                    this.zzI = i;
                    if (z) {
                        argb = Color.argb(51, 0, 0, 0);
                        bVar2 = this;
                        bVar2.zzJ = argb;
                    } else {
                        bVar = this;
                    }
                }
                if (this.zzI == 0 || this.zzJ != 0) {
                    if (!(i2 == this.zzI && i3 == this.zzJ)) {
                        setWillNotDraw(false);
                        dJn();
                    }
                    AppMethodBeat.o(67841);
                    return;
                }
                setWillNotDraw(true);
                dJn();
                AppMethodBeat.o(67841);
                return;
            }
            argb = 0;
            bVar2 = bVar;
            bVar2.zzJ = argb;
            if (this.zzI == 0) {
            }
            setWillNotDraw(false);
            dJn();
            AppMethodBeat.o(67841);
            return;
        }
        AppMethodBeat.o(67841);
    }

    public void setLayoutFrozen(final boolean z) {
        int i = 1;
        AppMethodBeat.i(67843);
        if (al.isMainThread()) {
            ab.d("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b]", Boolean.valueOf(z), Boolean.valueOf(this.anv), Boolean.valueOf(this.zzM), Boolean.valueOf(this.zzL));
            if (z == this.anv) {
                i = 0;
            }
            this.anv = z;
            if (!(i == 0 || z || (!this.zzM && !this.zzL))) {
                PH(this.iJp);
                this.zzM = false;
                this.zzL = false;
            }
            AppMethodBeat.o(67843);
            return;
        }
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(67832);
                b.this.setLayoutFrozen(z);
                AppMethodBeat.o(67832);
            }
        });
        AppMethodBeat.o(67843);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(67842);
        if (this.iJp > 0 && zzH && !this.zzK && !willNotDraw()) {
            this.mPaint.setColor(this.zzI);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) this.iJp, this.mPaint);
        }
        super.dispatchDraw(canvas);
        if (this.iJp <= 0 || !zzH || !this.zzK || willNotDraw()) {
            AppMethodBeat.o(67842);
            return;
        }
        this.mPaint.setColor(this.zzJ);
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) this.iJp, this.mPaint);
        AppMethodBeat.o(67842);
    }
}
