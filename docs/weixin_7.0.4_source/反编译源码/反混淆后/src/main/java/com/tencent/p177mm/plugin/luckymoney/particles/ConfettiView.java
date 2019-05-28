package com.tencent.p177mm.plugin.luckymoney.particles;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.luckymoney.particles.p1280a.C28430b;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.particles.ConfettiView */
public class ConfettiView extends View implements OnLayoutChangeListener {
    List<C28430b> nZJ;
    private boolean oas;
    private C28430b oat;
    boolean terminated;

    /* renamed from: es */
    public static ConfettiView m5673es(Context context) {
        AppMethodBeat.m2504i(42451);
        ConfettiView confettiView = new ConfettiView(context, null);
        confettiView.setLayoutParams(new LayoutParams(-1, -1));
        if (VERSION.SDK_INT >= 21) {
            confettiView.setElevation((float) context.getResources().getDimensionPixelOffset(C25738R.dimen.f10326y0));
        }
        AppMethodBeat.m2505o(42451);
        return confettiView;
    }

    public ConfettiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setTouchEnabled(boolean z) {
        this.oas = z;
    }

    public final void bLM() {
        AppMethodBeat.m2504i(42452);
        if (!this.terminated) {
            this.terminated = true;
            getParent().requestLayout();
        }
        AppMethodBeat.m2505o(42452);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(42453);
        super.onAttachedToWindow();
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.removeOnLayoutChangeListener(this);
        viewGroup.addOnLayoutChangeListener(this);
        if (this.nZJ == null) {
            bLM();
        }
        AppMethodBeat.m2505o(42453);
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.m2504i(42454);
        if (this.terminated) {
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeViewInLayout(this);
                viewGroup.removeOnLayoutChangeListener(this);
                viewGroup.invalidate();
            }
        }
        AppMethodBeat.m2505o(42454);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(42455);
        super.onDraw(canvas);
        if (!this.terminated) {
            canvas.save();
            for (C28430b c28430b : this.nZJ) {
                if (c28430b.oaP) {
                    Canvas canvas2 = canvas;
                    c28430b.mo46413a(canvas2, c28430b.oaT + c28430b.oaR, c28430b.oaU + c28430b.oaS, c28430b.oaN, c28430b.oaK);
                } else if (c28430b.oaO && !c28430b.terminated) {
                    c28430b.mo46413a(canvas, c28430b.oaL, c28430b.oaM, c28430b.oaN, c28430b.oaK);
                }
            }
            canvas.restore();
        }
        AppMethodBeat.m2505o(42455);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.m2504i(42456);
        if (this.oas) {
            C28430b c28430b;
            switch (motionEvent.getAction()) {
                case 0:
                    for (C28430b c28430b2 : this.nZJ) {
                        boolean z2;
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (c28430b2.oaL > x || x > c28430b2.oaL + ((float) c28430b2.getWidth()) || c28430b2.oaM > y || y > c28430b2.oaM + ((float) c28430b2.getHeight())) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            c28430b2.oaP = true;
                            c28430b2.oaR = x;
                            c28430b2.oaS = y;
                            c28430b2.oaT = c28430b2.oaL - x;
                            c28430b2.oaU = c28430b2.oaM - y;
                            c28430b2.oaQ = VelocityTracker.obtain();
                            c28430b2.oaQ.addMovement(motionEvent);
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            this.oat = c28430b2;
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    break;
                case 1:
                case 3:
                    if (this.oat != null) {
                        c28430b2 = this.oat;
                        c28430b2.oaQ.addMovement(motionEvent);
                        c28430b2.oaQ.computeCurrentVelocity(1);
                        c28430b2.oaz = -1;
                        c28430b2.oaA = motionEvent.getX() + c28430b2.oaT;
                        c28430b2.oaB = motionEvent.getY() + c28430b2.oaU;
                        c28430b2.oaC = c28430b2.oaQ.getXVelocity();
                        c28430b2.oaD = c28430b2.oaQ.getYVelocity();
                        c28430b2.oaG = c28430b2.oaN;
                        c28430b2.oaQ.recycle();
                        c28430b2.mo46414i(c28430b2.nZP);
                        c28430b2.oaP = false;
                        this.oat = null;
                        z = true;
                        break;
                    }
                case 2:
                    if (this.oat != null) {
                        c28430b2 = this.oat;
                        c28430b2.oaR = motionEvent.getX();
                        c28430b2.oaS = motionEvent.getY();
                        c28430b2.oaQ.addMovement(motionEvent);
                        z = true;
                        break;
                    }
            }
        }
        z = false;
        if (z || super.onTouchEvent(motionEvent)) {
            AppMethodBeat.m2505o(42456);
            return true;
        }
        AppMethodBeat.m2505o(42456);
        return false;
    }
}
