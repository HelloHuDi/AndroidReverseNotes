package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import com.tencent.mm.R;

public final class u {
    static final c No;

    static class c {
        c() {
        }

        public int d(ViewGroup viewGroup) {
            return 0;
        }

        public boolean e(ViewGroup viewGroup) {
            Boolean bool = (Boolean) viewGroup.getTag(R.id.cs);
            return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && s.ai(viewGroup) == null) ? false : true;
        }
    }

    static class a extends c {
        a() {
        }

        public final int d(ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }
    }

    static class b extends a {
        b() {
        }

        public final boolean e(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            No = new b();
        } else if (VERSION.SDK_INT >= 18) {
            No = new a();
        } else {
            No = new c();
        }
    }

    public static int d(ViewGroup viewGroup) {
        return No.d(viewGroup);
    }

    public static boolean e(ViewGroup viewGroup) {
        return No.e(viewGroup);
    }
}
