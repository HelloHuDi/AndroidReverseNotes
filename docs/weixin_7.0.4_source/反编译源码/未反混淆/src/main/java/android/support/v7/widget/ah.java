package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class ah extends r {
    protected final DecelerateInterpolator Sf = new DecelerateInterpolator();
    protected final LinearInterpolator ama = new LinearInterpolator();
    protected PointF amb;
    private final float amc;
    protected int amd = 0;
    protected int ame = 0;

    public ah(Context context) {
        this.amc = c(context.getResources().getDisplayMetrics());
    }

    /* Access modifiers changed, original: protected */
    public void a(View view, a aVar) {
        int i;
        LayoutParams layoutParams;
        int i2 = 0;
        int iX = iX();
        i iVar = this.amP;
        if (iVar == null || !iVar.iG()) {
            i = 0;
        } else {
            layoutParams = (LayoutParams) view.getLayoutParams();
            i = e(i.bx(view) - layoutParams.leftMargin, i.bz(view) + layoutParams.rightMargin, iVar.getPaddingLeft(), iVar.mWidth - iVar.getPaddingRight(), iX);
        }
        iX = (this.amb == null || this.amb.y == 0.0f) ? 0 : this.amb.y > 0.0f ? 1 : -1;
        iVar = this.amP;
        if (iVar != null && iVar.iH()) {
            layoutParams = (LayoutParams) view.getLayoutParams();
            i2 = e(i.by(view) - layoutParams.topMargin, i.bA(view) + layoutParams.bottomMargin, iVar.getPaddingTop(), iVar.mHeight - iVar.getPaddingBottom(), iX);
        }
        int ca = ca((int) Math.sqrt((double) ((i * i) + (i2 * i2))));
        if (ca > 0) {
            aVar.a(-i, -i2, ca, this.Sf);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(int i, int i2, a aVar) {
        if (this.aiB.ank.getChildCount() == 0) {
            stop();
            return;
        }
        this.amd = aj(this.amd, i);
        this.ame = aj(this.ame, i2);
        if (this.amd == 0 && this.ame == 0) {
            PointF bX = bX(this.ape);
            if (bX == null || (bX.x == 0.0f && bX.y == 0.0f)) {
                aVar.apl = this.ape;
                stop();
                return;
            }
            float sqrt = (float) Math.sqrt((double) ((bX.x * bX.x) + (bX.y * bX.y)));
            bX.x /= sqrt;
            bX.y /= sqrt;
            this.amb = bX;
            this.amd = (int) (bX.x * 10000.0f);
            this.ame = (int) (bX.y * 10000.0f);
            aVar.a((int) (((float) this.amd) * 1.2f), (int) (((float) this.ame) * 1.2f), (int) (((float) cb(Downloads.MIN_WAIT_FOR_NETWORK)) * 1.2f), this.ama);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        this.ame = 0;
        this.amd = 0;
        this.amb = null;
    }

    /* Access modifiers changed, original: protected */
    public float c(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    /* Access modifiers changed, original: protected|final */
    public final int ca(int i) {
        return (int) Math.ceil(((double) cb(i)) / 0.3356d);
    }

    /* Access modifiers changed, original: protected */
    public int cb(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.amc));
    }

    /* Access modifiers changed, original: protected */
    public int iX() {
        if (this.amb == null || this.amb.x == 0.0f) {
            return 0;
        }
        return this.amb.x > 0.0f ? 1 : -1;
    }

    private static int aj(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public int e(int i, int i2, int i3, int i4, int i5) {
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

    public PointF bX(int i) {
        i iVar = this.amP;
        if (iVar instanceof b) {
            return ((b) iVar).bX(i);
        }
        new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ").append(b.class.getCanonicalName());
        return null;
    }
}
