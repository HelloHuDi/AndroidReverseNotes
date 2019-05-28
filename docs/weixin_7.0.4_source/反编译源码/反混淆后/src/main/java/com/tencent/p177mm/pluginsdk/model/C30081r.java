package com.tencent.p177mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.p177mm.pluginsdk.model.C14893s.C14894a;

/* renamed from: com.tencent.mm.pluginsdk.model.r */
public abstract class C30081r {
    public abstract boolean aix(String str);

    public abstract String anK();

    public abstract String dgX();

    public abstract C14894a dgY();

    /* renamed from: fE */
    public abstract boolean mo27192fE(Context context);

    /* renamed from: F */
    public boolean mo48338F(Context context, Intent intent) {
        return false;
    }

    /* renamed from: a */
    public String mo27187a(Context context, ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
    }
}
