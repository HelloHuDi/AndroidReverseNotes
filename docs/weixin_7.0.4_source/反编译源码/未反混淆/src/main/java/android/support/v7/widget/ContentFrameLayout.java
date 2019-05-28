package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;

public class ContentFrameLayout extends FrameLayout {
    private TypedValue ahf;
    private TypedValue ahg;
    private TypedValue ahh;
    private TypedValue ahi;
    private TypedValue ahj;
    private TypedValue ahk;
    private final Rect ahl;
    private a ahm;

    public interface a {
        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahl = new Rect();
    }

    public final void g(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(a aVar) {
        this.ahm = aVar;
    }

    public final void j(int i, int i2, int i3, int i4) {
        this.ahl.set(i, i2, i3, i4);
        if (s.as(this)) {
            requestLayout();
        }
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A:{SYNTHETIC, RETURN} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int i, int i2) {
        int dimension;
        Object obj;
        TypedValue typedValue;
        int dimension2;
        Object obj2 = null;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Object obj3 = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode == j.INVALID_ID) {
            TypedValue typedValue2 = obj3 != null ? this.ahi : this.ahh;
            if (!(typedValue2 == null || typedValue2.type == 0)) {
                if (typedValue2.type == 5) {
                    dimension = (int) typedValue2.getDimension(displayMetrics);
                } else if (typedValue2.type == 6) {
                    dimension = (int) typedValue2.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
                } else {
                    dimension = 0;
                }
                if (dimension > 0) {
                    i = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.ahl.left + this.ahl.right), MeasureSpec.getSize(i)), ErrorDialogData.SUPPRESSED);
                    obj = 1;
                    if (mode2 == j.INVALID_ID) {
                        typedValue2 = obj3 != null ? this.ahj : this.ahk;
                        if (!(typedValue2 == null || typedValue2.type == 0)) {
                            if (typedValue2.type == 5) {
                                dimension = (int) typedValue2.getDimension(displayMetrics);
                            } else if (typedValue2.type == 6) {
                                dimension = (int) typedValue2.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
                            } else {
                                dimension = 0;
                            }
                            if (dimension > 0) {
                                i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.ahl.top + this.ahl.bottom), MeasureSpec.getSize(i2)), ErrorDialogData.SUPPRESSED);
                            }
                        }
                    }
                    super.onMeasure(i, i2);
                    mode2 = getMeasuredWidth();
                    dimension = MeasureSpec.makeMeasureSpec(mode2, ErrorDialogData.SUPPRESSED);
                    if (obj == null && mode == j.INVALID_ID) {
                        typedValue = obj3 == null ? this.ahg : this.ahf;
                        if (!(typedValue == null || typedValue.type == 0)) {
                            dimension2 = typedValue.type != 5 ? (int) typedValue.getDimension(displayMetrics) : typedValue.type == 6 ? (int) typedValue.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                            if (dimension2 > 0) {
                                dimension2 -= this.ahl.left + this.ahl.right;
                            }
                            if (mode2 < dimension2) {
                                dimension2 = MeasureSpec.makeMeasureSpec(dimension2, ErrorDialogData.SUPPRESSED);
                                obj2 = 1;
                                if (obj2 != null) {
                                    super.onMeasure(dimension2, i2);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    dimension2 = dimension;
                    if (obj2 != null) {
                    }
                }
            }
        }
        obj = null;
        if (mode2 == j.INVALID_ID) {
        }
        super.onMeasure(i, i2);
        mode2 = getMeasuredWidth();
        dimension = MeasureSpec.makeMeasureSpec(mode2, ErrorDialogData.SUPPRESSED);
        if (obj3 == null) {
        }
        if (typedValue.type != 5) {
        }
        if (dimension2 > 0) {
        }
        if (mode2 < dimension2) {
        }
        dimension2 = dimension;
        if (obj2 != null) {
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.ahf == null) {
            this.ahf = new TypedValue();
        }
        return this.ahf;
    }

    public TypedValue getMinWidthMinor() {
        if (this.ahg == null) {
            this.ahg = new TypedValue();
        }
        return this.ahg;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.ahh == null) {
            this.ahh = new TypedValue();
        }
        return this.ahh;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.ahi == null) {
            this.ahi = new TypedValue();
        }
        return this.ahi;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.ahj == null) {
            this.ahj = new TypedValue();
        }
        return this.ahj;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.ahk == null) {
            this.ahk = new TypedValue();
        }
        return this.ahk;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ahm != null) {
            this.ahm.onDetachedFromWindow();
        }
    }
}
