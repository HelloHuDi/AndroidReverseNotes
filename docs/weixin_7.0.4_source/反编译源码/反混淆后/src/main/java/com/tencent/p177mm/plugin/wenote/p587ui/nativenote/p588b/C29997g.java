package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.g */
public final class C29997g {
    public static final int uUv = 2130970316;
    public static final int uUw = 2130970315;
    public static final int uUx = 2130970313;
    public SparseArray<Integer> uUy = new SparseArray();

    public C29997g() {
        AppMethodBeat.m2504i(27161);
        this.uUy.put(1, Integer.valueOf(uUv));
        this.uUy.put(2, Integer.valueOf(uUw));
        this.uUy.put(4, Integer.valueOf(uUw));
        this.uUy.put(3, Integer.valueOf(uUw));
        this.uUy.put(5, Integer.valueOf(uUw));
        this.uUy.put(6, Integer.valueOf(uUw));
        this.uUy.put(0, Integer.valueOf(uUw));
        this.uUy.put(-1, Integer.valueOf(uUw));
        this.uUy.put(-3, Integer.valueOf(uUx));
        this.uUy.put(-2, Integer.valueOf(uUw));
        this.uUy.put(-4, Integer.valueOf(uUw));
        this.uUy.put(20, Integer.valueOf(uUw));
        AppMethodBeat.m2505o(27161);
    }

    /* renamed from: a */
    public static C4689a m47477a(int i, View view, C46457k c46457k) {
        AppMethodBeat.m2504i(27162);
        C4689a c29998j;
        switch (i) {
            case -4:
                c29998j = new C29998j(view, c46457k);
                AppMethodBeat.m2505o(27162);
                return c29998j;
            case -3:
                c29998j = new C46461e(view, c46457k);
                AppMethodBeat.m2505o(27162);
                return c29998j;
            case -2:
                c29998j = new C4690b(view, c46457k);
                AppMethodBeat.m2505o(27162);
                return c29998j;
            case -1:
                c29998j = new C17005k(view, c46457k);
                AppMethodBeat.m2505o(27162);
                return c29998j;
            case 0:
                c29998j = new C40389m(view, c46457k);
                AppMethodBeat.m2505o(27162);
                return c29998j;
            case 1:
                c29998j = new C46462l(view, c46457k);
                AppMethodBeat.m2505o(27162);
                return c29998j;
            case 2:
                c29998j = new C40388f(view, c46457k);
                AppMethodBeat.m2505o(27162);
                return c29998j;
            case 3:
                c29998j = new C17004h(view, c46457k);
                AppMethodBeat.m2505o(27162);
                return c29998j;
            case 4:
                c29998j = new C44017o(view, c46457k);
                AppMethodBeat.m2505o(27162);
                return c29998j;
            case 5:
                c29998j = new C44015d(view, c46457k);
                AppMethodBeat.m2505o(27162);
                return c29998j;
            case 6:
                c29998j = new C46463n(view, c46457k);
                AppMethodBeat.m2505o(27162);
                return c29998j;
            case 20:
                c29998j = new C46460c(view, c46457k);
                AppMethodBeat.m2505o(27162);
                return c29998j;
            default:
                AppMethodBeat.m2505o(27162);
                return null;
        }
    }
}
