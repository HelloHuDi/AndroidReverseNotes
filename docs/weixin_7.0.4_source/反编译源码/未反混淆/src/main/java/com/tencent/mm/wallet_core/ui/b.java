package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public final class b {
    public static c a(Context context, int i, String str, String str2, OnClickListener onClickListener) {
        AppMethodBeat.i(49221);
        c a = h.a(context, str, str2, ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null), onClickListener);
        AppMethodBeat.o(49221);
        return a;
    }
}
