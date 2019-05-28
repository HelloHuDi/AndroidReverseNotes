package com.tencent.mm.pluginsdk.ui.e;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import java.util.List;

public interface c {

    public static class a {
        public static c vrD;
    }

    void a(Context context, String str, OnDismissListener onDismissListener, Bundle bundle);

    void a(Context context, List<String> list, OnDismissListener onDismissListener);
}
