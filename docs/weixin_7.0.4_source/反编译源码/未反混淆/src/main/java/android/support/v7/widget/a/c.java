package android.support.v7.widget.a;

import android.graphics.Canvas;
import android.support.v4.view.s;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.R;

final class c {

    static class a extends b {
        a() {
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (z && view.getTag(R.id.bo) == null) {
                Float valueOf = Float.valueOf(s.ag(view));
                int childCount = recyclerView.getChildCount();
                float f3 = 0.0f;
                int i2 = 0;
                while (i2 < childCount) {
                    float ag;
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt != view) {
                        ag = s.ag(childAt);
                        if (ag > f3) {
                            i2++;
                            f3 = ag;
                        }
                    }
                    ag = f3;
                    i2++;
                    f3 = ag;
                }
                s.h(view, 1.0f + f3);
                view.setTag(R.id.bo, valueOf);
            }
            super.a(canvas, recyclerView, view, f, f2, i, z);
        }

        public final void bZ(View view) {
            Object tag = view.getTag(R.id.bo);
            if (tag != null && (tag instanceof Float)) {
                s.h(view, ((Float) tag).floatValue());
            }
            view.setTag(R.id.bo, null);
            super.bZ(view);
        }
    }

    static class b implements b {
        b() {
        }

        public void bZ(View view) {
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            view.setTranslationX(f);
            view.setTranslationY(f2);
        }
    }
}
