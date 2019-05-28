package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.C25290b.C25291a;
import android.support.constraint.C37095a.C31827a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class Constraints extends ViewGroup {
    /* renamed from: fp */
    C37095a f2142fp;

    public static class LayoutParams extends android.support.constraint.ConstraintLayout.LayoutParams {
        public float alpha = 1.0f;
        /* renamed from: eR */
        public boolean f2143eR = false;
        /* renamed from: eS */
        public float f2144eS = 0.0f;
        /* renamed from: eT */
        public float f2145eT = 0.0f;
        /* renamed from: eU */
        public float f2146eU = 0.0f;
        /* renamed from: eV */
        public float f2147eV = 0.0f;
        /* renamed from: eW */
        public float f2148eW = 0.0f;
        /* renamed from: eX */
        public float f2149eX = 0.0f;
        /* renamed from: eY */
        public float f2150eY = 0.0f;
        /* renamed from: eZ */
        public float f2151eZ = 0.0f;
        public float rotation = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            int i = 0;
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C25291a.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            while (i < indexCount) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 13) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == 26) {
                    this.f2144eS = obtainStyledAttributes.getFloat(index, this.f2144eS);
                    this.f2143eR = true;
                } else if (index == 21) {
                    this.f2145eT = obtainStyledAttributes.getFloat(index, this.f2145eT);
                } else if (index == 22) {
                    this.f2146eU = obtainStyledAttributes.getFloat(index, this.f2146eU);
                } else if (index == 20) {
                    this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                } else if (index == 18) {
                    this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                } else if (index == 19) {
                    this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                } else if (index == 14) {
                    this.f2147eV = obtainStyledAttributes.getFloat(index, this.f2147eV);
                } else if (index == 15) {
                    this.f2148eW = obtainStyledAttributes.getFloat(index, this.f2148eW);
                } else if (index == 16) {
                    this.f2149eX = obtainStyledAttributes.getFloat(index, this.f2149eX);
                } else if (index == 17) {
                    this.f2150eY = obtainStyledAttributes.getFloat(index, this.f2150eY);
                } else if (index == 25) {
                    this.f2149eX = obtainStyledAttributes.getFloat(index, this.f2151eZ);
                }
                i++;
            }
        }
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new android.support.constraint.ConstraintLayout.LayoutParams(layoutParams);
    }

    public C37095a getConstraintSet() {
        if (this.f2142fp == null) {
            this.f2142fp = new C37095a();
        }
        C37095a c37095a = this.f2142fp;
        int childCount = getChildCount();
        c37095a.f15657eL.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!c37095a.f15657eL.containsKey(Integer.valueOf(id))) {
                c37095a.f15657eL.put(Integer.valueOf(id), new C31827a());
            }
            C31827a c31827a = (C31827a) c37095a.f15657eL.get(Integer.valueOf(id));
            if (childAt instanceof ConstraintHelper) {
                ConstraintHelper constraintHelper = (ConstraintHelper) childAt;
                c31827a.mo51786a(id, layoutParams);
                if (constraintHelper instanceof Barrier) {
                    c31827a.f14535fl = 1;
                    Barrier barrier = (Barrier) constraintHelper;
                    c31827a.f14534fk = barrier.getType();
                    c31827a.f14536fn = barrier.getReferencedIds();
                }
            }
            c31827a.mo51786a(id, layoutParams);
        }
        return this.f2142fp;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
