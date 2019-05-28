package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.a.a.b;
import android.support.constraint.b.a;
import android.util.AttributeSet;

public class Barrier extends ConstraintHelper {
    private int cT;
    private int cU;
    private b cV;

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
        return this.cT;
    }

    public void setType(int i) {
        this.cT = i;
        this.cU = i;
        if (VERSION.SDK_INT >= 17) {
            int i2;
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                if (this.cT == 5) {
                    this.cU = 1;
                } else if (this.cT == 6) {
                    this.cU = 0;
                }
            } else if (this.cT == 5) {
                this.cU = 0;
            } else if (this.cT == 6) {
                this.cU = 1;
            }
        } else if (this.cT == 5) {
            this.cU = 0;
        } else if (this.cT == 6) {
            this.cU = 1;
        }
        this.cV.hc = this.cU;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(AttributeSet attributeSet) {
        super.b(attributeSet);
        this.cV = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 6) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == 5) {
                    this.cV.he = obtainStyledAttributes.getBoolean(index, true);
                }
            }
        }
        this.cY = this.cV;
        ap();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.cV.he = z;
    }
}
