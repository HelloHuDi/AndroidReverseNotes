package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.p057v4.content.p062a.C0378b;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.view.C0449a;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.widget.C0540q;
import android.support.p069v7.view.menu.C0630p.C0629a;
import android.support.p069v7.view.menu.C6239j;
import android.support.p069v7.widget.C0701be;
import android.support.p069v7.widget.LinearLayoutCompat.LayoutParams;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import com.tencent.p177mm.C25738R;

public class NavigationMenuItemView extends ForegroundLinearLayout implements C0629a {
    /* renamed from: kO */
    private static final int[] f1717kO = new int[]{16842912};
    /* renamed from: kY */
    private C6239j f1718kY;
    /* renamed from: lA */
    private boolean f1719lA;
    /* renamed from: lB */
    boolean f1720lB;
    /* renamed from: lC */
    final CheckedTextView f1721lC;
    /* renamed from: lD */
    FrameLayout f1722lD;
    /* renamed from: lE */
    private ColorStateList f1723lE;
    /* renamed from: lF */
    private boolean f1724lF;
    /* renamed from: lG */
    private Drawable f1725lG;
    /* renamed from: lH */
    private final C0449a f1726lH;
    /* renamed from: lz */
    private final int f1727lz;

    /* renamed from: android.support.design.internal.NavigationMenuItemView$1 */
    class C61671 extends C0449a {
        C61671() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
            super.onInitializeAccessibilityNodeInfo(view, c0445b);
            c0445b.setCheckable(NavigationMenuItemView.this.f1720lB);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1726lH = new C61671();
        setOrientation(0);
        LayoutInflater.from(context).inflate(2130969283, this, true);
        this.f1727lz = context.getResources().getDimensionPixelSize(C25738R.dimen.f10358z1);
        this.f1721lC = (CheckedTextView) findViewById(2131823269);
        this.f1721lC.setDuplicateParentStateEnabled(true);
        C0477s.m905a(this.f1721lC, this.f1726lH);
    }

    /* renamed from: a */
    public final void mo1609a(C6239j c6239j) {
        boolean z;
        this.f1718kY = c6239j;
        setVisibility(c6239j.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            Drawable stateListDrawable;
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(C25738R.attr.f5685fq, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(f1717kO, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            C0477s.m904a((View) this, stateListDrawable);
        }
        setCheckable(c6239j.isCheckable());
        setChecked(c6239j.isChecked());
        setEnabled(c6239j.isEnabled());
        setTitle(c6239j.getTitle());
        setIcon(c6239j.getIcon());
        setActionView(c6239j.getActionView());
        setContentDescription(c6239j.getContentDescription());
        C0701be.m1558a(this, c6239j.getTooltipText());
        if (this.f1718kY.getTitle() == null && this.f1718kY.getIcon() == null && this.f1718kY.getActionView() != null) {
            z = true;
        } else {
            z = false;
        }
        LayoutParams layoutParams;
        if (z) {
            this.f1721lC.setVisibility(8);
            if (this.f1722lD != null) {
                layoutParams = (LayoutParams) this.f1722lD.getLayoutParams();
                layoutParams.width = -1;
                this.f1722lD.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f1721lC.setVisibility(0);
        if (this.f1722lD != null) {
            layoutParams = (LayoutParams) this.f1722lD.getLayoutParams();
            layoutParams.width = -2;
            this.f1722lD.setLayoutParams(layoutParams);
        }
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f1722lD == null) {
                this.f1722lD = (FrameLayout) ((ViewStub) findViewById(2131823270)).inflate();
            }
            this.f1722lD.removeAllViews();
            this.f1722lD.addView(view);
        }
    }

    public C6239j getItemData() {
        return this.f1718kY;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1721lC.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f1720lB != z) {
            this.f1720lB = z;
            this.f1726lH.sendAccessibilityEvent(this.f1721lC, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f1721lC.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f1724lF) {
                ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = C0280a.m467f(drawable).mutate();
                C0280a.m457a(drawable, this.f1723lE);
            }
            drawable.setBounds(0, 0, this.f1727lz, this.f1727lz);
        } else if (this.f1719lA) {
            if (this.f1725lG == null) {
                this.f1725lG = C0378b.m634b(getResources(), C25738R.drawable.f6937vz, getContext().getTheme());
                if (this.f1725lG != null) {
                    this.f1725lG.setBounds(0, 0, this.f1727lz, this.f1727lz);
                }
            }
            drawable = this.f1725lG;
        }
        C0540q.m1165a(this.f1721lC, drawable, null, null, null);
    }

    /* renamed from: br */
    public final boolean mo1610br() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f1718kY != null && this.f1718kY.isCheckable() && this.f1718kY.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f1717kO);
        }
        return onCreateDrawableState;
    }

    /* Access modifiers changed, original: 0000 */
    public void setIconTintList(ColorStateList colorStateList) {
        this.f1723lE = colorStateList;
        this.f1724lF = this.f1723lE != null;
        if (this.f1718kY != null) {
            setIcon(this.f1718kY.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        C0540q.m1167b(this.f1721lC, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f1721lC.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f1719lA = z;
    }
}
