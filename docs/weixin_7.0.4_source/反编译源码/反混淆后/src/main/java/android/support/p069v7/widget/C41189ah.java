package android.support.p069v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C37139r;
import android.support.p069v7.widget.RecyclerView.C37139r.C37138a;
import android.support.p069v7.widget.RecyclerView.C37139r.C37140b;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: android.support.v7.widget.ah */
public class C41189ah extends C37139r {
    /* renamed from: Sf */
    protected final DecelerateInterpolator f16584Sf = new DecelerateInterpolator();
    protected final LinearInterpolator ama = new LinearInterpolator();
    protected PointF amb;
    private final float amc;
    protected int amd = 0;
    protected int ame = 0;

    public C41189ah(Context context) {
        this.amc = mo9235c(context.getResources().getDisplayMetrics());
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo9234a(View view, C37138a c37138a) {
        int i;
        LayoutParams layoutParams;
        int i2 = 0;
        int iX = mo22753iX();
        C17480i c17480i = this.amP;
        if (c17480i == null || !c17480i.mo1776iG()) {
            i = 0;
        } else {
            layoutParams = (LayoutParams) view.getLayoutParams();
            i = mo35055e(C17480i.m27151bx(view) - layoutParams.leftMargin, C17480i.m27153bz(view) + layoutParams.rightMargin, c17480i.getPaddingLeft(), c17480i.mWidth - c17480i.getPaddingRight(), iX);
        }
        iX = (this.amb == null || this.amb.y == 0.0f) ? 0 : this.amb.y > 0.0f ? 1 : -1;
        c17480i = this.amP;
        if (c17480i != null && c17480i.mo1777iH()) {
            layoutParams = (LayoutParams) view.getLayoutParams();
            i2 = mo35055e(C17480i.m27152by(view) - layoutParams.topMargin, C17480i.m27143bA(view) + layoutParams.bottomMargin, c17480i.getPaddingTop(), c17480i.mHeight - c17480i.getPaddingBottom(), iX);
        }
        int ca = mo65816ca((int) Math.sqrt((double) ((i * i) + (i2 * i2))));
        if (ca > 0) {
            c37138a.mo59203a(-i, -i2, ca, this.f16584Sf);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo59205a(int i, int i2, C37138a c37138a) {
        if (this.aiB.ank.getChildCount() == 0) {
            stop();
            return;
        }
        this.amd = C41189ah.m71673aj(this.amd, i);
        this.ame = C41189ah.m71673aj(this.ame, i2);
        if (this.amd == 0 && this.ame == 0) {
            PointF bX = mo22752bX(this.ape);
            if (bX == null || (bX.x == 0.0f && bX.y == 0.0f)) {
                c37138a.apl = this.ape;
                stop();
                return;
            }
            float sqrt = (float) Math.sqrt((double) ((bX.x * bX.x) + (bX.y * bX.y)));
            bX.x /= sqrt;
            bX.y /= sqrt;
            this.amb = bX;
            this.amd = (int) (bX.x * 10000.0f);
            this.ame = (int) (bX.y * 10000.0f);
            c37138a.mo59203a((int) (((float) this.amd) * 1.2f), (int) (((float) this.ame) * 1.2f), (int) (((float) mo30874cb(Downloads.MIN_WAIT_FOR_NETWORK)) * 1.2f), this.ama);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        this.ame = 0;
        this.amd = 0;
        this.amb = null;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public float mo9235c(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ca */
    public final int mo65816ca(int i) {
        return (int) Math.ceil(((double) mo30874cb(i)) / 0.3356d);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: cb */
    public int mo30874cb(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.amc));
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: iX */
    public int mo22753iX() {
        if (this.amb == null || this.amb.x == 0.0f) {
            return 0;
        }
        return this.amb.x > 0.0f ? 1 : -1;
    }

    /* renamed from: aj */
    private static int m71673aj(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    /* renamed from: e */
    public int mo35055e(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? 0 : i6;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    /* renamed from: bX */
    public PointF mo22752bX(int i) {
        C17480i c17480i = this.amP;
        if (c17480i instanceof C37140b) {
            return ((C37140b) c17480i).mo1761bX(i);
        }
        new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ").append(C37140b.class.getCanonicalName());
        return null;
    }
}
