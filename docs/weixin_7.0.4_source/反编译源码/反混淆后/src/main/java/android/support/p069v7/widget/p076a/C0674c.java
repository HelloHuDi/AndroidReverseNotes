package android.support.p069v7.widget.p076a;

import android.graphics.Canvas;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.widget.RecyclerView;
import android.view.View;

/* renamed from: android.support.v7.widget.a.c */
final class C0674c {

    /* renamed from: android.support.v7.widget.a.c$a */
    static class C0675a extends C0676b {
        C0675a() {
        }

        /* renamed from: a */
        public final void mo1918a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (z && view.getTag(2131820632) == null) {
                Float valueOf = Float.valueOf(C0477s.m915ag(view));
                int childCount = recyclerView.getChildCount();
                float f3 = 0.0f;
                int i2 = 0;
                while (i2 < childCount) {
                    float ag;
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt != view) {
                        ag = C0477s.m915ag(childAt);
                        if (ag > f3) {
                            i2++;
                            f3 = ag;
                        }
                    }
                    ag = f3;
                    i2++;
                    f3 = ag;
                }
                C0477s.m945h(view, 1.0f + f3);
                view.setTag(2131820632, valueOf);
            }
            super.mo1918a(canvas, recyclerView, view, f, f2, i, z);
        }

        /* renamed from: bZ */
        public final void mo1919bZ(View view) {
            Object tag = view.getTag(2131820632);
            if (tag != null && (tag instanceof Float)) {
                C0477s.m945h(view, ((Float) tag).floatValue());
            }
            view.setTag(2131820632, null);
            super.mo1919bZ(view);
        }
    }

    /* renamed from: android.support.v7.widget.a.c$b */
    static class C0676b implements C8461b {
        C0676b() {
        }

        /* renamed from: bZ */
        public void mo1919bZ(View view) {
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }

        /* renamed from: a */
        public void mo1918a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            view.setTranslationX(f);
            view.setTranslationY(f2);
        }
    }
}
