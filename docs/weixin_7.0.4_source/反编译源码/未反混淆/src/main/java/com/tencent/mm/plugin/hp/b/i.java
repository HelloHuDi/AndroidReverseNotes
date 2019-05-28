package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.protocal.b.a.a;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class i {
    public static void a(String str, String str2, String str3, OnClickListener onClickListener, String str4, OnClickListener onClickListener2) {
        AppMethodBeat.i(90615);
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "msg is null");
            AppMethodBeat.o(90615);
            return;
        }
        ab.i("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "try to show dialog");
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final OnClickListener onClickListener3 = onClickListener;
        final OnClickListener onClickListener4 = onClickListener2;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(90614);
                ij ijVar = new ij();
                b bVar = new b();
                bVar.title = str5;
                bVar.bzH = str6;
                bVar.vzI = new LinkedList();
                a aVar = new a();
                aVar.vzG = str7;
                bVar.vzI.add(aVar);
                aVar = new a();
                aVar.vzG = str8;
                bVar.vzI.add(aVar);
                ijVar.cDv.type = 1;
                ijVar.cDv.cDw = bVar;
                ijVar.cDv.cDx = onClickListener3;
                ijVar.cDv.cDy = onClickListener4;
                com.tencent.mm.sdk.b.a.xxA.m(ijVar);
                AppMethodBeat.o(90614);
            }
        });
        AppMethodBeat.o(90615);
    }
}
