package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;

/* renamed from: android.support.v7.widget.ActionBarContainer */
public class ActionBarContainer extends FrameLayout {
    Drawable abb;
    private boolean acE;
    private View acF;
    private View acG;
    private View acH;
    Drawable acI;
    Drawable acJ;
    boolean acK;
    boolean acL;
    private int mHeight;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable c6258d;
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 21) {
            c6258d = new C6258d(this);
        } else {
            c6258d = new C0711c(this);
        }
        C0477s.m904a((View) this, c6258d);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0554a.ActionBar);
        this.abb = obtainStyledAttributes.getDrawable(10);
        this.acI = obtainStyledAttributes.getDrawable(11);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        if (getId() == 2131820667) {
            this.acK = true;
            this.acJ = obtainStyledAttributes.getDrawable(12);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.acK ? this.acJ == null : this.abb == null && this.acI == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.acG = findViewById(2131820941);
        this.acH = findViewById(2131820942);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.abb != null) {
            this.abb.setCallback(null);
            unscheduleDrawable(this.abb);
        }
        this.abb = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.acG != null) {
                this.abb.setBounds(this.acG.getLeft(), this.acG.getTop(), this.acG.getRight(), this.acG.getBottom());
            }
        }
        if (this.acK) {
            if (this.acJ != null) {
                z = false;
            }
        } else if (!(this.abb == null && this.acI == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.acI != null) {
            this.acI.setCallback(null);
            unscheduleDrawable(this.acI);
        }
        this.acI = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.acL && this.acI != null) {
                this.acI.setBounds(this.acF.getLeft(), this.acF.getTop(), this.acF.getRight(), this.acF.getBottom());
            }
        }
        if (this.acK) {
            if (this.acJ != null) {
                z = false;
            }
        } else if (!(this.abb == null && this.acI == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.acJ != null) {
            this.acJ.setCallback(null);
            unscheduleDrawable(this.acJ);
        }
        this.acJ = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.acK && this.acJ != null) {
                this.acJ.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.acK) {
            if (this.acJ != null) {
                z = false;
            }
        } else if (!(this.abb == null && this.acI == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.abb != null) {
            this.abb.setVisible(z, false);
        }
        if (this.acI != null) {
            this.acI.setVisible(z, false);
        }
        if (this.acJ != null) {
            this.acJ.setVisible(z, false);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.abb && !this.acK) || ((drawable == this.acI && this.acL) || ((drawable == this.acJ && this.acK) || super.verifyDrawable(drawable)));
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.abb != null && this.abb.isStateful()) {
            this.abb.setState(getDrawableState());
        }
        if (this.acI != null && this.acI.isStateful()) {
            this.acI.setState(getDrawableState());
        }
        if (this.acJ != null && this.acJ.isStateful()) {
            this.acJ.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.abb != null) {
            this.abb.jumpToCurrentState();
        }
        if (this.acI != null) {
            this.acI.jumpToCurrentState();
        }
        if (this.acJ != null) {
            this.acJ.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.acE = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.acE || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(C0695au c0695au) {
        if (this.acF != null) {
            removeView(this.acF);
        }
        this.acF = c0695au;
        if (c0695au != null) {
            addView(c0695au);
            LayoutParams layoutParams = c0695au.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            c0695au.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.acF;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    /* renamed from: aU */
    private static boolean m1361aU(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* renamed from: aV */
    private static int m1362aV(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.acG == null && MeasureSpec.getMode(i2) == C8415j.INVALID_ID && this.mHeight >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, MeasureSpec.getSize(i2)), C8415j.INVALID_ID);
        }
        super.onMeasure(i, i2);
        if (this.acG != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.acF != null && this.acF.getVisibility() != 8 && mode != ErrorDialogData.SUPPRESSED) {
                int aV;
                if (!ActionBarContainer.m1361aU(this.acG)) {
                    aV = ActionBarContainer.m1362aV(this.acG);
                } else if (ActionBarContainer.m1361aU(this.acH)) {
                    aV = 0;
                } else {
                    aV = ActionBarContainer.m1362aV(this.acH);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(aV + ActionBarContainer.m1362aV(this.acF), mode == C8415j.INVALID_ID ? MeasureSpec.getSize(i2) : BaseClientBuilder.API_PRIORITY_OTHER));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.acF;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.acK) {
            int i6;
            if (this.abb != null) {
                if (this.acG.getVisibility() == 0) {
                    this.abb.setBounds(this.acG.getLeft(), this.acG.getTop(), this.acG.getRight(), this.acG.getBottom());
                } else if (this.acH == null || this.acH.getVisibility() != 0) {
                    this.abb.setBounds(0, 0, 0, 0);
                } else {
                    this.abb.setBounds(this.acH.getLeft(), this.acH.getTop(), this.acH.getRight(), this.acH.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.acL = z2;
            if (!z2 || this.acI == null) {
                i5 = i6;
            } else {
                this.acI.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.acJ != null) {
            this.acJ.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}
