package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader_app.a.c;
import com.tencent.mm.pointers.PBool;

public final class a implements c {
    public final void a(Context context, final String str, final OnClickListener onClickListener, final OnClickListener onClickListener2, final OnCancelListener onCancelListener) {
        AppMethodBeat.i(136011);
        final PBool pBool = new PBool();
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.PV(R.string.cuh);
        aVar.PZ(R.string.cuf);
        aVar.Qc(R.string.cui);
        aVar.a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(136005);
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i);
                }
                pBool.value = true;
                com.tencent.mm.plugin.downloader_app.c.a.a(15, 1501, 1, 23, str, "", "");
                AppMethodBeat.o(136005);
            }
        });
        aVar.Qd(R.string.cue);
        aVar.b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(136006);
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, i);
                }
                pBool.value = true;
                com.tencent.mm.plugin.downloader_app.c.a.a(15, 1501, 1, 3, str, "", "");
                AppMethodBeat.o(136006);
            }
        });
        aVar.rc(true);
        aVar.f(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(136007);
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
                if (!pBool.value) {
                    com.tencent.mm.plugin.downloader_app.c.a.a(15, 1501, 1, 2, str, "", "");
                }
                AppMethodBeat.o(136007);
            }
        });
        aVar.aMb().show();
        com.tencent.mm.plugin.downloader_app.c.a.a(15, 1501, 1, 1, str, "", "");
        AppMethodBeat.o(136011);
    }

    public final void b(Context context, final String str, final OnClickListener onClickListener, final OnClickListener onClickListener2, final OnCancelListener onCancelListener) {
        AppMethodBeat.i(136012);
        final PBool pBool = new PBool();
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.PV(R.string.cuj);
        aVar.PZ(R.string.cuk);
        aVar.Qc(R.string.cui);
        aVar.a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(136008);
                pBool.value = true;
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i);
                }
                pBool.value = true;
                com.tencent.mm.plugin.downloader_app.c.a.a(15, 1502, 1, 23, str, "", "");
                AppMethodBeat.o(136008);
            }
        });
        aVar.Qd(R.string.cug);
        aVar.b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(136009);
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, i);
                }
                pBool.value = true;
                com.tencent.mm.plugin.downloader_app.c.a.a(15, 1502, 1, 3, str, "", "");
                AppMethodBeat.o(136009);
            }
        });
        aVar.rc(true);
        aVar.f(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(136010);
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
                if (!pBool.value) {
                    com.tencent.mm.plugin.downloader_app.c.a.a(15, 1502, 1, 2, str, "", "");
                }
                AppMethodBeat.o(136010);
            }
        });
        aVar.aMb().show();
        com.tencent.mm.plugin.downloader_app.c.a.a(15, 1502, 1, 1, str, "", "");
        AppMethodBeat.o(136012);
    }
}
