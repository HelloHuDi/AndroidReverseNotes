package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.b.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class Constraints extends ViewGroup {
    a fp;

    public static class LayoutParams extends android.support.constraint.ConstraintLayout.LayoutParams {
        public float alpha = 1.0f;
        public boolean eR = false;
        public float eS = 0.0f;
        public float eT = 0.0f;
        public float eU = 0.0f;
        public float eV = 0.0f;
        public float eW = 0.0f;
        public float eX = 0.0f;
        public float eY = 0.0f;
        public float eZ = 0.0f;
        public float rotation = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            int i = 0;
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            while (i < indexCount) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 13) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == 26) {
                    this.eS = obtainStyledAttributes.getFloat(index, this.eS);
                    this.eR = true;
                } else if (index == 21) {
                    this.eT = obtainStyledAttributes.getFloat(index, this.eT);
                } else if (index == 22) {
                    this.eU = obtainStyledAttributes.getFloat(index, this.eU);
                } else if (index == 20) {
                    this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                } else if (index == 18) {
                    this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                } else if (index == 19) {
                    this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                } else if (index == 14) {
                    this.eV = obtainStyledAttributes.getFloat(index, this.eV);
                } else if (index == 15) {
                    this.eW = obtainStyledAttributes.getFloat(index, this.eW);
                } else if (index == 16) {
                    this.eX = obtainStyledAttributes.getFloat(index, this.eX);
                } else if (index == 17) {
                    this.eY = obtainStyledAttributes.getFloat(index, this.eY);
                } else if (index == 25) {
                    this.eX = obtainStyledAttributes.getFloat(index, this.eZ);
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

    public a getConstraintSet() {
        if (this.fp == null) {
            this.fp = new a();
        }
        a aVar = this.fp;
        int childCount = getChildCount();
        aVar.eL.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!aVar.eL.containsKey(Integer.valueOf(id))) {
                aVar.eL.put(Integer.valueOf(id), new a());
            }
            a aVar2 = (a) aVar.eL.get(Integer.valueOf(id));
            if (childAt instanceof ConstraintHelper) {
                ConstraintHelper constraintHelper = (ConstraintHelper) childAt;
                aVar2.a(id, layoutParams);
                if (constraintHelper instanceof Barrier) {
                    aVar2.fl = 1;
                    Barrier barrier = (Barrier) constraintHelper;
                    aVar2.fk = barrier.getType();
                    aVar2.fn = barrier.getReferencedIds();
                }
            }
            aVar2.a(id, layoutParams);
        }
        return this.fp;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
