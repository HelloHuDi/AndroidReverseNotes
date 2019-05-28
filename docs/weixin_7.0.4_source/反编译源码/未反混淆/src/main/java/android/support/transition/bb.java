package android.support.transition;

import android.view.View;

public abstract class bb extends af {
    private static final String[] BM = new String[]{"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    public final void c(ah ahVar) {
        View view = ahVar.view;
        Object obj = (Integer) ahVar.values.get("android:visibility:visibility");
        if (obj == null) {
            obj = Integer.valueOf(view.getVisibility());
        }
        ahVar.values.put("android:visibilityPropagation:visibility", obj);
        r0 = new int[2];
        view.getLocationOnScreen(r0);
        r0[0] = r0[0] + Math.round(view.getTranslationX());
        r0[0] = r0[0] + (view.getWidth() / 2);
        r0[1] = r0[1] + Math.round(view.getTranslationY());
        r0[1] = (view.getHeight() / 2) + r0[1];
        ahVar.values.put("android:visibilityPropagation:center", r0);
    }

    public final String[] getPropagationProperties() {
        return BM;
    }

    public static int e(ah ahVar) {
        if (ahVar == null) {
            return 8;
        }
        Integer num = (Integer) ahVar.values.get("android:visibilityPropagation:visibility");
        if (num == null) {
            return 8;
        }
        return num.intValue();
    }

    static int a(ah ahVar, int i) {
        if (ahVar == null) {
            return -1;
        }
        int[] iArr = (int[]) ahVar.values.get("android:visibilityPropagation:center");
        if (iArr == null) {
            return -1;
        }
        return iArr[i];
    }
}
