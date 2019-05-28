package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.C25290b.C25291a;
import android.support.constraint.p780a.p781a.C37093b;
import android.util.AttributeSet;

public class Barrier extends ConstraintHelper {
    /* renamed from: cT */
    private int f2139cT;
    /* renamed from: cU */
    private int f2140cU;
    /* renamed from: cV */
    private C37093b f2141cV;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }

    public int getType() {
        return this.f2139cT;
    }

    public void setType(int i) {
        this.f2139cT = i;
        this.f2140cU = i;
        if (VERSION.SDK_INT >= 17) {
            int i2;
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                if (this.f2139cT == 5) {
                    this.f2140cU = 1;
                } else if (this.f2139cT == 6) {
                    this.f2140cU = 0;
                }
            } else if (this.f2139cT == 5) {
                this.f2140cU = 0;
            } else if (this.f2139cT == 6) {
                this.f2140cU = 1;
            }
        } else if (this.f2139cT == 5) {
            this.f2140cU = 0;
        } else if (this.f2139cT == 6) {
            this.f2140cU = 1;
        }
        this.f2141cV.f15636hc = this.f2140cU;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo18089b(AttributeSet attributeSet) {
        super.mo18089b(attributeSet);
        this.f2141cV = new C37093b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C25291a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 6) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == 5) {
                    this.f2141cV.f15638he = obtainStyledAttributes.getBoolean(index, true);
                }
            }
        }
        this.f16603cY = this.f2141cV;
        mo66107ap();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f2141cV.f15638he = z;
    }
}
