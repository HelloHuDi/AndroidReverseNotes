package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.d;
import android.support.v4.view.s;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.R;

public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        i5 = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i6 = 8388615 & gravity;
        switch (gravity & 112) {
            case 16:
                i5 = (((i4 - i2) - i5) / 2) + getPaddingTop();
                break;
            case 80:
                i5 = ((getPaddingTop() + i4) - i2) - i5;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable == null) {
            gravity = 0;
        } else {
            gravity = dividerDrawable.getIntrinsicHeight();
        }
        int i7 = i5;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i9 = layoutParams.gravity;
                if (i9 < 0) {
                    i9 = i6;
                }
                switch (d.getAbsoluteGravity(i9, s.T(this)) & 7) {
                    case 1:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 5:
                        i9 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                    default:
                        i9 = layoutParams.leftMargin + paddingLeft;
                        break;
                }
                if (bV(i8)) {
                    i7 += gravity;
                }
                i7 += layoutParams.topMargin;
                childAt.layout(i9, i7, measuredWidth + i9, i7 + measuredHeight);
                i7 += layoutParams.bottomMargin + measuredHeight;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:56:0x0115, code skipped:
            r0 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int i, int i2) {
        int id;
        Object obj;
        View view;
        int i3;
        int measuredHeight;
        int i4;
        int combineMeasuredStates;
        int i5;
        View view2 = null;
        View view3 = null;
        View view4 = null;
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                id = childAt.getId();
                if (id != R.id.jn) {
                    if (id != R.id.jc) {
                        if (id != R.id.jf && id != R.id.jl) {
                            obj = null;
                            break;
                        } else if (view4 != null) {
                            obj = null;
                            break;
                        } else {
                            view = childAt;
                        }
                    } else {
                        view = view4;
                        view3 = childAt;
                    }
                } else {
                    view = view4;
                    view2 = childAt;
                }
            } else {
                view = view4;
            }
            i6++;
            view4 = view;
        }
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i);
        i6 = 0;
        id = getPaddingTop() + getPaddingBottom();
        if (view2 != null) {
            view2.measure(i, 0);
            id += view2.getMeasuredHeight();
            i6 = View.combineMeasuredStates(0, view2.getMeasuredState());
            i3 = id;
        } else {
            i3 = id;
        }
        int i7 = 0;
        if (view3 != null) {
            view3.measure(i, 0);
            view = view3;
            while (true) {
                i7 = s.aa(view);
                if (i7 <= 0) {
                    if (!(view instanceof ViewGroup)) {
                        break;
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (viewGroup.getChildCount() != 1) {
                        break;
                    }
                    view = viewGroup.getChildAt(0);
                } else {
                    id = i7;
                    break;
                }
            }
            measuredHeight = view3.getMeasuredHeight() - id;
            i3 += id;
            i6 = View.combineMeasuredStates(i6, view3.getMeasuredState());
            i4 = measuredHeight;
            i7 = id;
        } else {
            i4 = 0;
        }
        if (view4 != null) {
            if (mode == 0) {
                id = 0;
            } else {
                id = MeasureSpec.makeMeasureSpec(Math.max(0, size - i3), mode);
            }
            view4.measure(i, id);
            id = view4.getMeasuredHeight();
            i3 += id;
            i6 = View.combineMeasuredStates(i6, view4.getMeasuredState());
            measuredHeight = id;
        } else {
            measuredHeight = 0;
        }
        id = size - i3;
        if (view3 != null) {
            i3 -= i7;
            i4 = Math.min(id, i4);
            if (i4 > 0) {
                id -= i4;
                i7 += i4;
            }
            view3.measure(i, MeasureSpec.makeMeasureSpec(i7, ErrorDialogData.SUPPRESSED));
            i7 = view3.getMeasuredHeight() + i3;
            combineMeasuredStates = View.combineMeasuredStates(i6, view3.getMeasuredState());
        } else {
            i7 = i3;
            combineMeasuredStates = i6;
        }
        if (view4 == null || id <= 0) {
            id = i7;
            i5 = combineMeasuredStates;
        } else {
            i7 -= measuredHeight;
            view4.measure(i, MeasureSpec.makeMeasureSpec(id + measuredHeight, mode));
            id = view4.getMeasuredHeight() + i7;
            i5 = View.combineMeasuredStates(combineMeasuredStates, view4.getMeasuredState());
        }
        i7 = 0;
        for (combineMeasuredStates = 0; combineMeasuredStates < childCount; combineMeasuredStates++) {
            view2 = getChildAt(combineMeasuredStates);
            if (view2.getVisibility() != 8) {
                i7 = Math.max(i7, view2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i7 + (getPaddingLeft() + getPaddingRight()), i, i5), View.resolveSizeAndState(id, i2, 0));
        if (mode2 != ErrorDialogData.SUPPRESSED) {
            i7 = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), ErrorDialogData.SUPPRESSED);
            for (i4 = 0; i4 < childCount; i4++) {
                view4 = getChildAt(i4);
                if (view4.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) view4.getLayoutParams();
                    if (layoutParams.width == -1) {
                        mode = layoutParams.height;
                        layoutParams.height = view4.getMeasuredHeight();
                        measureChildWithMargins(view4, i7, 0, i2, 0);
                        layoutParams.height = mode;
                    }
                }
            }
        }
        obj = 1;
        if (obj == null) {
            super.onMeasure(i, i2);
        }
    }
}
