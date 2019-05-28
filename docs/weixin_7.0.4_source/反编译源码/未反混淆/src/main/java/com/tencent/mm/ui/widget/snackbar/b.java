package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.snackbar.a.a;
import com.tencent.mm.ui.widget.snackbar.a.c;

public final class b {
    private static boolean zTW = false;

    public static void a(Activity activity, String str, String str2, com.tencent.mm.ui.widget.snackbar.a.b bVar) {
        AppMethodBeat.i(112984);
        a aVar = new a(activity);
        aVar.nqb = str;
        aVar.zTI = str2;
        a(aVar.a(Short.valueOf((short) 2500)), bVar, null);
        AppMethodBeat.o(112984);
    }

    public static void a(Context context, View view, String str, String str2) {
        AppMethodBeat.i(112985);
        a aVar = new a(context, view);
        aVar.nqb = str;
        aVar.zTI = str2;
        a(aVar.a(Short.valueOf((short) 2500)), null, null);
        AppMethodBeat.o(112985);
    }

    public static void a(Activity activity, String str, String str2, com.tencent.mm.ui.widget.snackbar.a.b bVar, c cVar) {
        AppMethodBeat.i(112986);
        a aVar = new a(activity);
        aVar.nqb = str;
        aVar.zTI = str2;
        a(aVar.a(Short.valueOf((short) 2500)), bVar, cVar);
        AppMethodBeat.o(112986);
    }

    public static void a(Fragment fragment, String str, String str2, com.tencent.mm.ui.widget.snackbar.a.b bVar, c cVar) {
        AppMethodBeat.i(112987);
        a aVar = new a(fragment.getContext(), fragment.getView());
        aVar.nqb = str;
        aVar.zTI = str2;
        a(aVar.a(Short.valueOf((short) 2500)), bVar, cVar);
        AppMethodBeat.o(112987);
    }

    public static void a(Context context, View view, String str, c cVar) {
        AppMethodBeat.i(112988);
        a aVar = new a(context, view);
        aVar.nqb = str;
        aVar = aVar.a(Short.valueOf((short) 1500));
        if (cVar != null) {
            aVar.a(cVar);
        }
        aVar.dLw();
        AppMethodBeat.o(112988);
    }

    public static void i(Activity activity, String str) {
        AppMethodBeat.i(112989);
        a aVar = new a(activity);
        aVar.nqb = str;
        a(aVar.a(Short.valueOf((short) 1500)), null, null);
        AppMethodBeat.o(112989);
    }

    private static void a(a aVar, com.tencent.mm.ui.widget.snackbar.a.b bVar, c cVar) {
        AppMethodBeat.i(112990);
        if (bVar != null) {
            aVar.a(bVar);
        }
        if (cVar != null) {
            aVar.a(cVar);
        }
        aVar.dLw();
        AppMethodBeat.o(112990);
    }

    public static boolean aFF() {
        return zTW;
    }

    public static void rf(boolean z) {
        zTW = z;
    }
}
