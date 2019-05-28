package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.a.b;
import android.support.v4.view.s;
import android.support.v4.widget.q;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.support.v7.widget.be;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import com.tencent.mm.R;

public class NavigationMenuItemView extends ForegroundLinearLayout implements a {
    private static final int[] kO = new int[]{16842912};
    private j kY;
    private boolean lA;
    boolean lB;
    final CheckedTextView lC;
    FrameLayout lD;
    private ColorStateList lE;
    private boolean lF;
    private Drawable lG;
    private final android.support.v4.view.a lH;
    private final int lz;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lH = new android.support.v4.view.a() {
            public final void onInitializeAccessibilityNodeInfo(View view, b bVar) {
                super.onInitializeAccessibilityNodeInfo(view, bVar);
                bVar.setCheckable(NavigationMenuItemView.this.lB);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.sc, this, true);
        this.lz = context.getResources().getDimensionPixelSize(R.dimen.z1);
        this.lC = (CheckedTextView) findViewById(R.id.b9n);
        this.lC.setDuplicateParentStateEnabled(true);
        s.a(this.lC, this.lH);
    }

    public final void a(j jVar) {
        boolean z;
        this.kY = jVar;
        setVisibility(jVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            Drawable stateListDrawable;
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.fq, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(kO, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            s.a((View) this, stateListDrawable);
        }
        setCheckable(jVar.isCheckable());
        setChecked(jVar.isChecked());
        setEnabled(jVar.isEnabled());
        setTitle(jVar.getTitle());
        setIcon(jVar.getIcon());
        setActionView(jVar.getActionView());
        setContentDescription(jVar.getContentDescription());
        be.a(this, jVar.getTooltipText());
        if (this.kY.getTitle() == null && this.kY.getIcon() == null && this.kY.getActionView() != null) {
            z = true;
        } else {
            z = false;
        }
        LayoutParams layoutParams;
        if (z) {
            this.lC.setVisibility(8);
            if (this.lD != null) {
                layoutParams = (LayoutParams) this.lD.getLayoutParams();
                layoutParams.width = -1;
                this.lD.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.lC.setVisibility(0);
        if (this.lD != null) {
            layoutParams = (LayoutParams) this.lD.getLayoutParams();
            layoutParams.width = -2;
            this.lD.setLayoutParams(layoutParams);
        }
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.lD == null) {
                this.lD = (FrameLayout) ((ViewStub) findViewById(R.id.b9o)).inflate();
            }
            this.lD.removeAllViews();
            this.lD.addView(view);
        }
    }

    public j getItemData() {
        return this.kY;
    }

    public void setTitle(CharSequence charSequence) {
        this.lC.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.lB != z) {
            this.lB = z;
            this.lH.sendAccessibilityEvent(this.lC, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.lC.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.lF) {
                ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = android.support.v4.a.a.a.f(drawable).mutate();
                android.support.v4.a.a.a.a(drawable, this.lE);
            }
            drawable.setBounds(0, 0, this.lz, this.lz);
        } else if (this.lA) {
            if (this.lG == null) {
                this.lG = android.support.v4.content.a.b.b(getResources(), R.drawable.vz, getContext().getTheme());
                if (this.lG != null) {
                    this.lG.setBounds(0, 0, this.lz, this.lz);
                }
            }
            drawable = this.lG;
        }
        q.a(this.lC, drawable, null, null, null);
    }

    public final boolean br() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.kY != null && this.kY.isCheckable() && this.kY.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, kO);
        }
        return onCreateDrawableState;
    }

    /* Access modifiers changed, original: 0000 */
    public void setIconTintList(ColorStateList colorStateList) {
        this.lE = colorStateList;
        this.lF = this.lE != null;
        if (this.kY != null) {
            setIcon(this.kY.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        q.b(this.lC, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.lC.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.lA = z;
    }
}
