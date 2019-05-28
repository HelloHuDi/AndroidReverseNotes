package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.constraint.C25290b.C25291a;
import android.support.constraint.R.id;
import android.support.constraint.p780a.p781a.C41473j;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.Arrays;

public abstract class ConstraintHelper extends View {
    /* renamed from: cW */
    protected int[] f16601cW;
    /* renamed from: cX */
    protected Context f16602cX;
    /* renamed from: cY */
    protected C41473j f16603cY;
    /* renamed from: cZ */
    protected boolean f16604cZ;
    /* renamed from: da */
    private String f16605da;
    protected int mCount;

    public ConstraintHelper(Context context) {
        super(context);
        this.f16601cW = new int[32];
        this.f16604cZ = false;
        this.f16602cX = context;
        mo18089b(null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16601cW = new int[32];
        this.f16604cZ = false;
        this.f16602cX = context;
        mo18089b(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16601cW = new int[32];
        this.f16604cZ = false;
        this.f16602cX = context;
        mo18089b(attributeSet);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo18089b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C25291a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 9) {
                    this.f16605da = obtainStyledAttributes.getString(index);
                    setIds(this.f16605da);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f16601cW, this.mCount);
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
        if (this.mCount + 1 > this.f16601cW.length) {
            this.f16601cW = Arrays.copyOf(this.f16601cW, this.f16601cW.length * 2);
        }
        this.f16601cW[this.mCount] = i;
        this.mCount++;
    }

    public void onDraw(Canvas canvas) {
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (this.f16604cZ) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    /* renamed from: ap */
    public final void mo66107ap() {
        if (this.f16603cY != null) {
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).f14451eH = this.f16603cY;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: A */
    private void m72355A(String str) {
        if (str != null && this.f16602cX != null) {
            int intValue;
            String trim = str.trim();
            int i = 0;
            try {
                i = id.class.getField(trim).getInt(null);
            } catch (Exception e) {
            }
            if (i == 0) {
                i = this.f16602cX.getResources().getIdentifier(trim, "id", this.f16602cX.getPackageName());
            }
            if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout)) {
                Object f = ((ConstraintLayout) getParent()).mo66117f(trim);
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
                    m72355A(str.substring(i));
                    return;
                } else {
                    m72355A(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo51784a(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f16605da);
        }
        if (this.f16603cY != null) {
            this.f16603cY.mo66145bd();
            for (int i = 0; i < this.mCount; i++) {
                View q = constraintLayout.mo66130q(this.f16601cW[i]);
                if (q != null) {
                    this.f16603cY.mo66146e(constraintLayout.mo66114b(q));
                }
            }
        }
    }

    /* renamed from: aq */
    public void mo51785aq() {
    }
}
