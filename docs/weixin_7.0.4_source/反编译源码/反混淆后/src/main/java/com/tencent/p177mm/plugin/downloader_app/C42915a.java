package com.tencent.p177mm.plugin.downloader_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C45832c;
import com.tencent.p177mm.plugin.downloader_app.p1646c.C45838a;
import com.tencent.p177mm.pointers.PBool;

/* renamed from: com.tencent.mm.plugin.downloader_app.a */
public final class C42915a implements C45832c {
    /* renamed from: a */
    public final void mo68447a(Context context, final String str, final OnClickListener onClickListener, final OnClickListener onClickListener2, final OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(136011);
        final PBool pBool = new PBool();
        C5652a c5652a = new C5652a(context);
        c5652a.mo11446PV(C25738R.string.cuh);
        c5652a.mo11450PZ(C25738R.string.cuf);
        c5652a.mo11453Qc(C25738R.string.cui);
        c5652a.mo11457a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(136005);
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i);
                }
                pBool.value = true;
                C45838a.m84850a(15, 1501, 1, 23, str, "", "");
                AppMethodBeat.m2505o(136005);
            }
        });
        c5652a.mo11454Qd(C25738R.string.cue);
        c5652a.mo11476b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(136006);
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, i);
                }
                pBool.value = true;
                C45838a.m84850a(15, 1501, 1, 3, str, "", "");
                AppMethodBeat.m2505o(136006);
            }
        });
        c5652a.mo11482rc(true);
        c5652a.mo11478f(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(136007);
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
                if (!pBool.value) {
                    C45838a.m84850a(15, 1501, 1, 2, str, "", "");
                }
                AppMethodBeat.m2505o(136007);
            }
        });
        c5652a.aMb().show();
        C45838a.m84850a(15, 1501, 1, 1, str, "", "");
        AppMethodBeat.m2505o(136011);
    }

    /* renamed from: b */
    public final void mo68448b(Context context, final String str, final OnClickListener onClickListener, final OnClickListener onClickListener2, final OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(136012);
        final PBool pBool = new PBool();
        C5652a c5652a = new C5652a(context);
        c5652a.mo11446PV(C25738R.string.cuj);
        c5652a.mo11450PZ(C25738R.string.cuk);
        c5652a.mo11453Qc(C25738R.string.cui);
        c5652a.mo11457a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(136008);
                pBool.value = true;
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i);
                }
                pBool.value = true;
                C45838a.m84850a(15, 1502, 1, 23, str, "", "");
                AppMethodBeat.m2505o(136008);
            }
        });
        c5652a.mo11454Qd(C25738R.string.cug);
        c5652a.mo11476b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(136009);
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, i);
                }
                pBool.value = true;
                C45838a.m84850a(15, 1502, 1, 3, str, "", "");
                AppMethodBeat.m2505o(136009);
            }
        });
        c5652a.mo11482rc(true);
        c5652a.mo11478f(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(136010);
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
                if (!pBool.value) {
                    C45838a.m84850a(15, 1502, 1, 2, str, "", "");
                }
                AppMethodBeat.m2505o(136010);
            }
        });
        c5652a.aMb().show();
        C45838a.m84850a(15, 1502, 1, 1, str, "", "");
        AppMethodBeat.m2505o(136012);
    }
}
