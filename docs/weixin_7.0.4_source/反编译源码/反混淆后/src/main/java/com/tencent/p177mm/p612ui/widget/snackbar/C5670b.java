package com.tencent.p177mm.p612ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.support.p057v4.app.Fragment;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24109b;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24111a;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24112c;

/* renamed from: com.tencent.mm.ui.widget.snackbar.b */
public final class C5670b {
    private static boolean zTW = false;

    /* renamed from: a */
    public static void m8517a(Activity activity, String str, String str2, C24109b c24109b) {
        AppMethodBeat.m2504i(112984);
        C24111a c24111a = new C24111a(activity);
        c24111a.nqb = str;
        c24111a.zTI = str2;
        C5670b.m8522a(c24111a.mo39917a(Short.valueOf((short) 2500)), c24109b, null);
        AppMethodBeat.m2505o(112984);
    }

    /* renamed from: a */
    public static void m8520a(Context context, View view, String str, String str2) {
        AppMethodBeat.m2504i(112985);
        C24111a c24111a = new C24111a(context, view);
        c24111a.nqb = str;
        c24111a.zTI = str2;
        C5670b.m8522a(c24111a.mo39917a(Short.valueOf((short) 2500)), null, null);
        AppMethodBeat.m2505o(112985);
    }

    /* renamed from: a */
    public static void m8518a(Activity activity, String str, String str2, C24109b c24109b, C24112c c24112c) {
        AppMethodBeat.m2504i(112986);
        C24111a c24111a = new C24111a(activity);
        c24111a.nqb = str;
        c24111a.zTI = str2;
        C5670b.m8522a(c24111a.mo39917a(Short.valueOf((short) 2500)), c24109b, c24112c);
        AppMethodBeat.m2505o(112986);
    }

    /* renamed from: a */
    public static void m8521a(Fragment fragment, String str, String str2, C24109b c24109b, C24112c c24112c) {
        AppMethodBeat.m2504i(112987);
        C24111a c24111a = new C24111a(fragment.getContext(), fragment.getView());
        c24111a.nqb = str;
        c24111a.zTI = str2;
        C5670b.m8522a(c24111a.mo39917a(Short.valueOf((short) 2500)), c24109b, c24112c);
        AppMethodBeat.m2505o(112987);
    }

    /* renamed from: a */
    public static void m8519a(Context context, View view, String str, C24112c c24112c) {
        AppMethodBeat.m2504i(112988);
        C24111a c24111a = new C24111a(context, view);
        c24111a.nqb = str;
        c24111a = c24111a.mo39917a(Short.valueOf((short) 1500));
        if (c24112c != null) {
            c24111a.mo39916a(c24112c);
        }
        c24111a.dLw();
        AppMethodBeat.m2505o(112988);
    }

    /* renamed from: i */
    public static void m8523i(Activity activity, String str) {
        AppMethodBeat.m2504i(112989);
        C24111a c24111a = new C24111a(activity);
        c24111a.nqb = str;
        C5670b.m8522a(c24111a.mo39917a(Short.valueOf((short) 1500)), null, null);
        AppMethodBeat.m2505o(112989);
    }

    /* renamed from: a */
    private static void m8522a(C24111a c24111a, C24109b c24109b, C24112c c24112c) {
        AppMethodBeat.m2504i(112990);
        if (c24109b != null) {
            c24111a.mo39915a(c24109b);
        }
        if (c24112c != null) {
            c24111a.mo39916a(c24112c);
        }
        c24111a.dLw();
        AppMethodBeat.m2505o(112990);
    }

    public static boolean aFF() {
        return zTW;
    }

    /* renamed from: rf */
    public static void m8524rf(boolean z) {
        zTW = z;
    }
}
