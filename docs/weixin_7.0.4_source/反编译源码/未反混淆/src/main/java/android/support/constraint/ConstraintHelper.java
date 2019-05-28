package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.constraint.R.id;
import android.support.constraint.a.a.j;
import android.support.constraint.b.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.Arrays;

public abstract class ConstraintHelper extends View {
    protected int[] cW;
    protected Context cX;
    protected j cY;
    protected boolean cZ;
    private String da;
    protected int mCount;

    public ConstraintHelper(Context context) {
        super(context);
        this.cW = new int[32];
        this.cZ = false;
        this.cX = context;
        b(null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cW = new int[32];
        this.cZ = false;
        this.cX = context;
        b(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cW = new int[32];
        this.cZ = false;
        this.cX = context;
        b(attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 9) {
                    this.da = obtainStyledAttributes.getString(index);
                    setIds(this.da);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.cW, this.mCount);
    }

    public void setReferencedIds(int[] iArr) {
        int i = 0;
        this.mCount = 0;
        while (i < iArr.length) {
            setTag(iArr[i], null);
            i++;
        }
    }

    public void setTag(int i, Object obj) {
        if (this.mCount + 1 > this.cW.length) {
            this.cW = Arrays.copyOf(this.cW, this.cW.length * 2);
        }
        this.cW[this.mCount] = i;
        this.mCount++;
    }

    public void onDraw(Canvas canvas) {
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (this.cZ) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public final void ap() {
        if (this.cY != null) {
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).eH = this.cY;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A(String str) {
        if (str != null && this.cX != null) {
            int intValue;
            String trim = str.trim();
            int i = 0;
            try {
                i = id.class.getField(trim).getInt(null);
            } catch (Exception e) {
            }
            if (i == 0) {
                i = this.cX.getResources().getIdentifier(trim, "id", this.cX.getPackageName());
            }
            if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout)) {
                Object f = ((ConstraintLayout) getParent()).f(trim);
                if (f != null && (f instanceof Integer)) {
                    intValue = ((Integer) f).intValue();
                    if (intValue == 0) {
                        setTag(intValue, null);
                        return;
                    } else {
                        new StringBuilder("Could not find id of \"").append(trim).append("\"");
                        return;
                    }
                }
            }
            intValue = i;
            if (intValue == 0) {
            }
        }
    }

    private void setIds(String str) {
        if (str != null) {
            int i = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    A(str.substring(i));
                    return;
                } else {
                    A(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.da);
        }
        if (this.cY != null) {
            this.cY.bd();
            for (int i = 0; i < this.mCount; i++) {
                View q = constraintLayout.q(this.cW[i]);
                if (q != null) {
                    this.cY.e(constraintLayout.b(q));
                }
            }
        }
    }

    public void aq() {
    }
}
