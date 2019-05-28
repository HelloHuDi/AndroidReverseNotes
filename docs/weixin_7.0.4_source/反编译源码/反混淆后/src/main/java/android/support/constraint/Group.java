package android.support.constraint;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.util.AttributeSet;
import android.view.View;

public class Group extends ConstraintHelper {
    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo18089b(AttributeSet attributeSet) {
        super.mo18089b(attributeSet);
        this.f16604cZ = false;
    }

    /* renamed from: a */
    public final void mo51784a(ConstraintLayout constraintLayout) {
        float elevation;
        int visibility = getVisibility();
        if (VERSION.SDK_INT >= 21) {
            elevation = getElevation();
        } else {
            elevation = 0.0f;
        }
        for (int i = 0; i < this.mCount; i++) {
            View q = constraintLayout.mo66130q(this.f16601cW[i]);
            if (q != null) {
                q.setVisibility(visibility);
                if (elevation > 0.0f && VERSION.SDK_INT >= 21) {
                    q.setElevation(elevation);
                }
            }
        }
    }

    /* renamed from: aq */
    public final void mo51785aq() {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.f14451eH.setWidth(0);
        layoutParams.f14451eH.setHeight(0);
    }
}
