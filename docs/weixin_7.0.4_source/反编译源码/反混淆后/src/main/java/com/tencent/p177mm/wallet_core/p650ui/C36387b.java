package com.tencent.p177mm.wallet_core.p650ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;

/* renamed from: com.tencent.mm.wallet_core.ui.b */
public final class C36387b {
    /* renamed from: a */
    public static C5653c m59970a(Context context, int i, String str, String str2, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(49221);
        C5653c a = C30379h.m48441a(context, str, str2, ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null), onClickListener);
        AppMethodBeat.m2505o(49221);
        return a;
    }
}
