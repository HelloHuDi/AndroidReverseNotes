package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.sortview.C46635a;
import com.tencent.p177mm.p612ui.base.sortview.C46635a.C36082b;
import com.tencent.p177mm.p612ui.base.sortview.C46635a.C40676a;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.g */
public final class C27515g extends C46635a {
    private static C36082b jKQ;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.g$a */
    public static class C11209a implements C40676a {
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.g$1 */
    class C275161 extends C36082b {
        C275161() {
        }

        /* renamed from: a */
        public final boolean mo22881a(Context context, C46635a c46635a, Object... objArr) {
            return true;
        }

        /* renamed from: c */
        public final View mo22882c(Context context, View view) {
            AppMethodBeat.m2504i(14055);
            if (view == null) {
                view = new View(context);
            }
            AppMethodBeat.m2505o(14055);
            return view;
        }

        /* renamed from: a */
        public final void mo22879a(Context context, C40676a c40676a, C46635a c46635a) {
        }

        /* renamed from: a */
        public final void mo22880a(View view, C40676a c40676a) {
        }
    }

    public C27515g(Object obj) {
        super(0, obj);
        this.yDq = true;
    }

    public final C36082b aVY() {
        AppMethodBeat.m2504i(14056);
        if (jKQ == null) {
            jKQ = new C275161();
        }
        C36082b c36082b = jKQ;
        AppMethodBeat.m2505o(14056);
        return c36082b;
    }

    public final C40676a aVZ() {
        AppMethodBeat.m2504i(14057);
        C11209a c11209a = new C11209a();
        AppMethodBeat.m2505o(14057);
        return c11209a;
    }

    /* renamed from: a */
    public final void mo35282a(Context context, C40676a c40676a, Object... objArr) {
    }
}
