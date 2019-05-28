package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.mm.pluginsdk.model.s.a;

public abstract class r {
    public abstract boolean aix(String str);

    public abstract String anK();

    public abstract String dgX();

    public abstract a dgY();

    public abstract boolean fE(Context context);

    public boolean F(Context context, Intent intent) {
        return false;
    }

    public String a(Context context, ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
    }
}
