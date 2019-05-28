package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.kernel.c.a;

public interface q extends a {
    boolean a(Context context, String str, OnDismissListener onDismissListener);

    boolean dq(String str);

    String x(Context context, String str);
}
