package com.tencent.p177mm.p612ui.statusbar;

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
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.statusbar.C5544c.C5543a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.ui.statusbar.b */
public class C7355b extends FrameLayout implements C5543a {
    static final boolean zzH = C5544c.zzP;
    private boolean anv = false;
    private int iJp;
    private final Activity mActivity;
    private final Paint mPaint;
    private int zzI = 0;
    private int zzJ = 0;
    private boolean zzK = false;
    private boolean zzL = false;
    private boolean zzM = false;

    /* renamed from: pO */
    public void mo11252pO(int i) {
        AppMethodBeat.m2504i(67833);
        m12533PH(i);
        AppMethodBeat.m2505o(67833);
    }

    /* renamed from: qM */
    public final void mo15854qM(boolean z) {
        AppMethodBeat.m2504i(67834);
        this.zzK = z;
        m12533PH(this.iJp);
        AppMethodBeat.m2505o(67834);
    }

    public C7355b(Context context) {
        super(context);
        AppMethodBeat.m2504i(67835);
        if (zzH) {
            this.mActivity = C5546d.m8371cY(context);
            C5544c.m8364az(this.mActivity).mo11253a(this);
            this.mPaint = new Paint(0);
            this.mPaint.setStyle(Style.FILL);
            setWillNotDraw(false);
            AppMethodBeat.m2505o(67835);
            return;
        }
        this.mActivity = null;
        this.mPaint = null;
        AppMethodBeat.m2505o(67835);
    }

    /* renamed from: PH */
    private void m12533PH(int i) {
        AppMethodBeat.m2504i(67836);
        C4990ab.m7411d("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b]", Integer.valueOf(i), Boolean.valueOf(this.anv));
        this.iJp = Math.max(0, i);
        if (this.anv) {
            this.zzL = true;
            AppMethodBeat.m2505o(67836);
            return;
        }
        try {
            setPadding(0, this.zzK ? 0 : this.iJp, 0, 0);
        } catch (IllegalStateException e) {
            C4990ab.m7421w("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight setPadding e=%s", e.getMessage());
        }
        dJn();
        AppMethodBeat.m2505o(67836);
    }

    private void dJn() {
        AppMethodBeat.m2504i(67837);
        if (C5004al.isMainThread()) {
            invalidate();
            AppMethodBeat.m2505o(67837);
            return;
        }
        postInvalidate();
        AppMethodBeat.m2505o(67837);
    }

    public void requestLayout() {
        AppMethodBeat.m2504i(67838);
        if (this.anv) {
            this.zzM = true;
            AppMethodBeat.m2505o(67838);
            return;
        }
        super.requestLayout();
        AppMethodBeat.m2505o(67838);
    }

    public void setStatusBarColor(int i) {
        AppMethodBeat.m2504i(67839);
        if (zzH) {
            mo15851K(i, C5546d.m8370b(this.mActivity.getWindow()));
            AppMethodBeat.m2505o(67839);
            return;
        }
        AppMethodBeat.m2505o(67839);
    }

    /* renamed from: K */
    public void mo15851K(int i, boolean z) {
        AppMethodBeat.m2504i(67840);
        mo15852a(i, z, true);
        AppMethodBeat.m2505o(67840);
    }

    /* renamed from: a */
    public final void mo15852a(int i, boolean z, boolean z2) {
        AppMethodBeat.m2504i(67841);
        int i2 = this.zzI;
        int i3 = this.zzJ;
        this.zzI = i;
        if (zzH) {
            C7355b c7355b;
            int argb;
            C7355b c7355b2;
            Window window = this.mActivity.getWindow();
            C5546d.m8368a(window);
            if (z2 ? C5546d.m8369a(window, z) : C5546d.dJo()) {
                this.zzI = i;
                c7355b = this;
            } else {
                if (VERSION.SDK_INT >= 21) {
                    if (z) {
                        i = C5222ae.m7932Jj(i);
                    }
                    this.zzI = i;
                    if (z) {
                        argb = Color.argb(51, 0, 0, 0);
                        c7355b2 = this;
                        c7355b2.zzJ = argb;
                    } else {
                        c7355b = this;
                    }
                }
                if (this.zzI == 0 || this.zzJ != 0) {
                    if (!(i2 == this.zzI && i3 == this.zzJ)) {
                        setWillNotDraw(false);
                        dJn();
                    }
                    AppMethodBeat.m2505o(67841);
                    return;
                }
                setWillNotDraw(true);
                dJn();
                AppMethodBeat.m2505o(67841);
                return;
            }
            argb = 0;
            c7355b2 = c7355b;
            c7355b2.zzJ = argb;
            if (this.zzI == 0) {
            }
            setWillNotDraw(false);
            dJn();
            AppMethodBeat.m2505o(67841);
            return;
        }
        AppMethodBeat.m2505o(67841);
    }

    public void setLayoutFrozen(final boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(67843);
        if (C5004al.isMainThread()) {
            C4990ab.m7411d("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b]", Boolean.valueOf(z), Boolean.valueOf(this.anv), Boolean.valueOf(this.zzM), Boolean.valueOf(this.zzL));
            if (z == this.anv) {
                i = 0;
            }
            this.anv = z;
            if (!(i == 0 || z || (!this.zzM && !this.zzL))) {
                m12533PH(this.iJp);
                this.zzM = false;
                this.zzL = false;
            }
            AppMethodBeat.m2505o(67843);
            return;
        }
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(67832);
                C7355b.this.setLayoutFrozen(z);
                AppMethodBeat.m2505o(67832);
            }
        });
        AppMethodBeat.m2505o(67843);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(67842);
        if (this.iJp > 0 && zzH && !this.zzK && !willNotDraw()) {
            this.mPaint.setColor(this.zzI);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) this.iJp, this.mPaint);
        }
        super.dispatchDraw(canvas);
        if (this.iJp <= 0 || !zzH || !this.zzK || willNotDraw()) {
            AppMethodBeat.m2505o(67842);
            return;
        }
        this.mPaint.setColor(this.zzJ);
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) this.iJp, this.mPaint);
        AppMethodBeat.m2505o(67842);
    }
}
