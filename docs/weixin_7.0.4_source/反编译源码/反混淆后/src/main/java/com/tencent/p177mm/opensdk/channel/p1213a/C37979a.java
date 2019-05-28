package com.tencent.p177mm.opensdk.channel.p1213a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.utils.C18754d;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.channel.a.a */
public final class C37979a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a */
    public static class C32882a {
        /* renamed from: a */
        public String f15023a;
        public String action;
        /* renamed from: b */
        public long f15024b;
        public Bundle bundle;
        public String content;
    }

    /* renamed from: a */
    public static boolean m64269a(Context context, C32882a c32882a) {
        AppMethodBeat.m2504i(128139);
        if (context == null) {
            Log.m4140e("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            AppMethodBeat.m2505o(128139);
            return false;
        } else if (C18754d.m29305b(c32882a.action)) {
            Log.m4140e("MicroMsg.SDK.MMessage", "send fail, action is null");
            AppMethodBeat.m2505o(128139);
            return false;
        } else {
            String str = null;
            if (!C18754d.m29305b(c32882a.f15023a)) {
                str = c32882a.f15023a + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(c32882a.action);
            if (c32882a.bundle != null) {
                intent.putExtras(c32882a.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c32882a.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c32882a.f15024b);
            intent.putExtra(ConstantsAPI.CHECK_SUM, C18744b.m29297a(c32882a.content, Build.SDK_INT, packageName));
            context.sendBroadcast(intent, str);
            Log.m4139d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            AppMethodBeat.m2505o(128139);
            return true;
        }
    }
}
