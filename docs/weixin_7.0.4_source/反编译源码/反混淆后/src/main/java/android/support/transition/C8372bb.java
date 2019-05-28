package android.support.transition;

import android.view.View;

/* renamed from: android.support.transition.bb */
public abstract class C8372bb extends C37104af {
    /* renamed from: BM */
    private static final String[] f2329BM = new String[]{"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    /* renamed from: c */
    public final void mo18298c(C8368ah c8368ah) {
        View view = c8368ah.view;
        Object obj = (Integer) c8368ah.values.get("android:visibility:visibility");
        if (obj == null) {
            obj = Integer.valueOf(view.getVisibility());
        }
        c8368ah.values.put("android:visibilityPropagation:visibility", obj);
        r0 = new int[2];
        view.getLocationOnScreen(r0);
        r0[0] = r0[0] + Math.round(view.getTranslationX());
        r0[0] = r0[0] + (view.getWidth() / 2);
        r0[1] = r0[1] + Math.round(view.getTranslationY());
        r0[1] = (view.getHeight() / 2) + r0[1];
        c8368ah.values.put("android:visibilityPropagation:center", r0);
    }

    public final String[] getPropagationProperties() {
        return f2329BM;
    }

    /* renamed from: e */
    public static int m14779e(C8368ah c8368ah) {
        if (c8368ah == null) {
            return 8;
        }
        Integer num = (Integer) c8368ah.values.get("android:visibilityPropagation:visibility");
        if (num == null) {
            return 8;
        }
        return num.intValue();
    }

    /* renamed from: a */
    static int m14778a(C8368ah c8368ah, int i) {
        if (c8368ah == null) {
            return -1;
        }
        int[] iArr = (int[]) c8368ah.values.get("android:visibilityPropagation:center");
        if (iArr == null) {
            return -1;
        }
        return iArr[i];
    }
}
