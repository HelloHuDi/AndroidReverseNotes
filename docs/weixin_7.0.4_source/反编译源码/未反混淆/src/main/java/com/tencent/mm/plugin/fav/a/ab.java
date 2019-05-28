package com.tencent.mm.plugin.fav.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.af.j.b;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.q;

public interface ab extends a {
    int LU(String str);

    int a(b bVar, WXMediaMessage wXMediaMessage, String str);

    int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3);

    void a(Activity activity, String str, String str2);

    void a(Context context, String str, g gVar, boolean z, q.a aVar);

    void b(Activity activity, int i, int i2, Intent intent);
}
