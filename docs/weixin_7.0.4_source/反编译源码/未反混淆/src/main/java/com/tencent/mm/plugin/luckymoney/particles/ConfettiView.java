package com.tencent.mm.plugin.luckymoney.particles;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import java.util.List;

public class ConfettiView extends View implements OnLayoutChangeListener {
    List<b> nZJ;
    private boolean oas;
    private b oat;
    boolean terminated;

    public static ConfettiView es(Context context) {
        AppMethodBeat.i(42451);
        ConfettiView confettiView = new ConfettiView(context, null);
        confettiView.setLayoutParams(new LayoutParams(-1, -1));
        if (VERSION.SDK_INT >= 21) {
            confettiView.setElevation((float) context.getResources().getDimensionPixelOffset(R.dimen.y0));
        }
        AppMethodBeat.o(42451);
        return confettiView;
    }

    public ConfettiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setTouchEnabled(boolean z) {
        this.oas = z;
    }

    public final void bLM() {
        AppMethodBeat.i(42452);
        if (!this.terminated) {
            this.terminated = true;
            getParent().requestLayout();
        }
        AppMethodBeat.o(42452);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(42453);
        super.onAttachedToWindow();
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.removeOnLayoutChangeListener(this);
        viewGroup.addOnLayoutChangeListener(this);
        if (this.nZJ == null) {
            bLM();
        }
        AppMethodBeat.o(42453);
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.i(42454);
        if (this.terminated) {
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeViewInLayout(this);
                viewGroup.removeOnLayoutChangeListener(this);
                viewGroup.invalidate();
            }
        }
        AppMethodBeat.o(42454);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(42455);
        super.onDraw(canvas);
        if (!this.terminated) {
            canvas.save();
            for (b bVar : this.nZJ) {
                if (bVar.oaP) {
                    Canvas canvas2 = canvas;
                    bVar.a(canvas2, bVar.oaT + bVar.oaR, bVar.oaU + bVar.oaS, bVar.oaN, bVar.oaK);
                } else if (bVar.oaO && !bVar.terminated) {
                    bVar.a(canvas, bVar.oaL, bVar.oaM, bVar.oaN, bVar.oaK);
                }
            }
            canvas.restore();
        }
        AppMethodBeat.o(42455);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(42456);
        if (this.oas) {
            b bVar;
            switch (motionEvent.getAction()) {
                case 0:
                    for (b bVar2 : this.nZJ) {
                        boolean z2;
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (bVar2.oaL > x || x > bVar2.oaL + ((float) bVar2.getWidth()) || bVar2.oaM > y || y > bVar2.oaM + ((float) bVar2.getHeight())) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            bVar2.oaP = true;
                            bVar2.oaR = x;
                            bVar2.oaS = y;
                            bVar2.oaT = bVar2.oaL - x;
                            bVar2.oaU = bVar2.oaM - y;
                            bVar2.oaQ = VelocityTracker.obtain();
                            bVar2.oaQ.addMovement(motionEvent);
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            this.oat = bVar2;
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    break;
                case 1:
                case 3:
                    if (this.oat != null) {
                        bVar2 = this.oat;
                        bVar2.oaQ.addMovement(motionEvent);
                        bVar2.oaQ.computeCurrentVelocity(1);
                        bVar2.oaz = -1;
                        bVar2.oaA = motionEvent.getX() + bVar2.oaT;
                        bVar2.oaB = motionEvent.getY() + bVar2.oaU;
                        bVar2.oaC = bVar2.oaQ.getXVelocity();
                        bVar2.oaD = bVar2.oaQ.getYVelocity();
                        bVar2.oaG = bVar2.oaN;
                        bVar2.oaQ.recycle();
                        bVar2.i(bVar2.nZP);
                        bVar2.oaP = false;
                        this.oat = null;
                        z = true;
                        break;
                    }
                case 2:
                    if (this.oat != null) {
                        bVar2 = this.oat;
                        bVar2.oaR = motionEvent.getX();
                        bVar2.oaS = motionEvent.getY();
                        bVar2.oaQ.addMovement(motionEvent);
                        z = true;
                        break;
                    }
            }
        }
        z = false;
        if (z || super.onTouchEvent(motionEvent)) {
            AppMethodBeat.o(42456);
            return true;
        }
        AppMethodBeat.o(42456);
        return false;
    }
}
