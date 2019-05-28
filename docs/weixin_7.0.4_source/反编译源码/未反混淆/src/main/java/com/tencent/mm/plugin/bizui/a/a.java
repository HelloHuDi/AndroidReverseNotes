package com.tencent.mm.plugin.bizui.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.a.c;

public final class a {
    public static c a(q qVar, String str, String str2, String str3, final com.tencent.mm.pluginsdk.ui.applet.q.a aVar, final com.tencent.mm.pluginsdk.ui.applet.q.a aVar2) {
        CharSequence str32;
        CharSequence str22;
        AppMethodBeat.i(70044);
        com.tencent.mm.ui.widget.a.c.a aVar3 = new com.tencent.mm.ui.widget.a.c.a(qVar.ylL);
        aVar3.a(com.tencent.mm.compatible.g.a.decodeResource(qVar.ylL.getResources(), R.raw.dialog_successful_icon), false, 3);
        aVar3.rc(false);
        aVar3.rd(false);
        aVar3.asG(str).Qb(17);
        final c aMb = aVar3.aMb();
        AppCompatActivity appCompatActivity = qVar.ylL;
        if (bo.isNullOrNil(str32) || str32.length() == 0) {
            str32 = appCompatActivity.getResources().getString(R.string.atf);
        }
        if (bo.isNullOrNil(str22) || str22.length() == 0) {
            str22 = appCompatActivity.getResources().getString(R.string.or);
        }
        aMb.a(str32, true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(70042);
                aMb.dismiss();
                if (aVar2 != null) {
                    aVar2.a(true, aMb.dKV(), aMb.dKW());
                }
                AppMethodBeat.o(70042);
            }
        });
        aMb.b(str22, true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(70043);
                aMb.dismiss();
                if (aVar != null) {
                    aVar.a(false, null, 0);
                }
                AppMethodBeat.o(70043);
            }
        });
        aMb.PU(qVar.ylL.getResources().getColor(R.color.hi));
        aMb.show();
        AppMethodBeat.o(70044);
        return aMb;
    }
}
