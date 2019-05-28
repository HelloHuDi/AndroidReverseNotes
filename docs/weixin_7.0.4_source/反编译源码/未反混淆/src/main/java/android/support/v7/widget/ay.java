package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.a.b;
import android.util.TypedValue;

final class ay {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] FOCUSED_STATE_SET = new int[]{16842908};
    static final int[] PRESSED_STATE_SET = new int[]{16842919};
    static final int[] SELECTED_STATE_SET = new int[]{16842913};
    private static final ThreadLocal<TypedValue> Xk = new ThreadLocal();
    static final int[] atx = new int[]{16843518};
    static final int[] aty = new int[]{-16842919, -16842908};
    private static final int[] atz = new int[1];
    static final int[] kO = new int[]{16842912};
    static final int[] mX = new int[]{-16842910};

    public static int s(Context context, int i) {
        atz[0] = i;
        bc a = bc.a(context, null, atz);
        try {
            int color = a.getColor(0, 0);
            return color;
        } finally {
            a.atG.recycle();
        }
    }

    public static ColorStateList t(Context context, int i) {
        atz[0] = i;
        bc a = bc.a(context, null, atz);
        try {
            ColorStateList colorStateList = a.getColorStateList(0);
            return colorStateList;
        } finally {
            a.atG.recycle();
        }
    }

    public static int u(Context context, int i) {
        ColorStateList t = t(context, i);
        if (t != null && t.isStateful()) {
            return t.getColorForState(mX, t.getDefaultColor());
        }
        TypedValue typedValue = (TypedValue) Xk.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            Xk.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f = typedValue.getFloat();
        int s = s(context, i);
        return b.u(s, Math.round(f * ((float) Color.alpha(s))));
    }
}
