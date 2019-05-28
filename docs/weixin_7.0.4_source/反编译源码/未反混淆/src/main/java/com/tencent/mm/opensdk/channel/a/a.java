package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class a {

    public static class a {
        public String a;
        public String action;
        public long b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, a aVar) {
        AppMethodBeat.i(128139);
        if (context == null) {
            Log.e("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            AppMethodBeat.o(128139);
            return false;
        } else if (d.b(aVar.action)) {
            Log.e("MicroMsg.SDK.MMessage", "send fail, action is null");
            AppMethodBeat.o(128139);
            return false;
        } else {
            String str = null;
            if (!d.b(aVar.a)) {
                str = aVar.a + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(aVar.action);
            if (aVar.bundle != null) {
                intent.putExtras(aVar.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, aVar.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, aVar.b);
            intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(aVar.content, Build.SDK_INT, packageName));
            context.sendBroadcast(intent, str);
            Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            AppMethodBeat.o(128139);
            return true;
        }
    }
}
