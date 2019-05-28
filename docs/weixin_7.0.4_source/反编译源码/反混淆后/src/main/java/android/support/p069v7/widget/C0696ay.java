package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.p057v4.p058a.C0284b;
import android.util.TypedValue;

/* renamed from: android.support.v7.widget.ay */
final class C0696ay {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] FOCUSED_STATE_SET = new int[]{16842908};
    static final int[] PRESSED_STATE_SET = new int[]{16842919};
    static final int[] SELECTED_STATE_SET = new int[]{16842913};
    /* renamed from: Xk */
    private static final ThreadLocal<TypedValue> f1016Xk = new ThreadLocal();
    static final int[] atx = new int[]{16843518};
    static final int[] aty = new int[]{-16842919, -16842908};
    private static final int[] atz = new int[1];
    /* renamed from: kO */
    static final int[] f1017kO = new int[]{16842912};
    /* renamed from: mX */
    static final int[] f1018mX = new int[]{-16842910};

    /* renamed from: s */
    public static int m1549s(Context context, int i) {
        atz[0] = i;
        C0699bc a = C0699bc.m1554a(context, null, atz);
        try {
            int color = a.getColor(0, 0);
            return color;
        } finally {
            a.atG.recycle();
        }
    }

    /* renamed from: t */
    public static ColorStateList m1550t(Context context, int i) {
        atz[0] = i;
        C0699bc a = C0699bc.m1554a(context, null, atz);
        try {
            ColorStateList colorStateList = a.getColorStateList(0);
            return colorStateList;
        } finally {
            a.atG.recycle();
        }
    }

    /* renamed from: u */
    public static int m1551u(Context context, int i) {
        ColorStateList t = C0696ay.m1550t(context, i);
        if (t != null && t.isStateful()) {
            return t.getColorForState(f1018mX, t.getDefaultColor());
        }
        TypedValue typedValue = (TypedValue) f1016Xk.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f1016Xk.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f = typedValue.getFloat();
        int s = C0696ay.m1549s(context, i);
        return C0284b.m479u(s, Math.round(f * ((float) Color.alpha(s))));
    }
}
