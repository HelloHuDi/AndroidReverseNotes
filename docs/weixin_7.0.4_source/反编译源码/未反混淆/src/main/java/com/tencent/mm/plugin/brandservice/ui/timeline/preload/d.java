package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.v;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.at;
import java.util.Arrays;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t\u001a\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u0006\u0010\f\u001a\u00020\r\u001a\u001a\u0010\u000e\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\r\u001a\u0012\u0010\u000e\u001a\u00020\u0005*\u00020\r2\u0006\u0010\u0011\u001a\u00020\r\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0015\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\u0005¨\u0006\u0018"}, dWq = {"bundleToString", "", "bundle", "Landroid/os/Bundle;", "findProcess", "", "context", "Landroid/content/Context;", "predicate", "Lkotlin/Function1;", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "getNetWorkType", "now", "", "isExpire", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "key", "duration", "putNow", "", "toDebugString", "Landroid/content/Intent;", "toInt", "", "plugin-brandservice_release"})
public final class d {
    public static final boolean a(as asVar, String str, long j) {
        AppMethodBeat.i(14802);
        j.p(asVar, "receiver$0");
        j.p(str, "key");
        boolean C = C(asVar.getLong(str, 0), j);
        AppMethodBeat.o(14802);
        return C;
    }

    public static final boolean a(Context context, b<? super RunningAppProcessInfo, Boolean> bVar) {
        AppMethodBeat.i(14803);
        j.p(context, "context");
        j.p(bVar, "predicate");
        Object systemService = context.getSystemService("activity");
        if (systemService == null) {
            v vVar = new v("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.o(14803);
            throw vVar;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
            j.o(runningAppProcessInfo, "info");
            if (((Boolean) bVar.am(runningAppProcessInfo)).booleanValue()) {
                AppMethodBeat.o(14803);
                return true;
            }
        }
        AppMethodBeat.o(14803);
        return false;
    }

    public static final String aWX() {
        AppMethodBeat.i(14804);
        Context context = ah.getContext();
        String str;
        if (at.isWifi(context)) {
            str = "wifi";
            AppMethodBeat.o(14804);
            return str;
        } else if (at.is4G(context)) {
            str = "4g";
            AppMethodBeat.o(14804);
            return str;
        } else if (at.is3G(context)) {
            str = "3g";
            AppMethodBeat.o(14804);
            return str;
        } else if (at.is2G(context)) {
            str = "2g";
            AppMethodBeat.o(14804);
            return str;
        } else {
            str = "none";
            AppMethodBeat.o(14804);
            return str;
        }
    }

    public static final String Q(Intent intent) {
        AppMethodBeat.i(138512);
        j.p(intent, "receiver$0");
        String str = intent.toString() + " " + E(intent.getExtras());
        AppMethodBeat.o(138512);
        return str;
    }

    private static final String E(Bundle bundle) {
        AppMethodBeat.i(138513);
        StringBuilder stringBuilder = new StringBuilder("Bundle[");
        if (bundle == null) {
            stringBuilder.append(BuildConfig.COMMAND);
        } else {
            try {
                Object obj = 1;
                for (String str : bundle.keySet()) {
                    if (obj == null) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(str).append('=');
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Object[]) {
                        stringBuilder.append(Arrays.toString((Object[]) obj2));
                    } else if (obj2 instanceof Bundle) {
                        stringBuilder.append(E((Bundle) obj2));
                    } else {
                        stringBuilder.append(obj2);
                    }
                    obj = null;
                }
            } catch (Exception e) {
                stringBuilder.append("can not read bundle");
            }
        }
        stringBuilder.append("]");
        String str2 = stringBuilder.toString();
        j.o(str2, "out.toString()");
        AppMethodBeat.o(138513);
        return str2;
    }

    public static final boolean C(long j, long j2) {
        AppMethodBeat.i(14800);
        if (System.currentTimeMillis() - j > j2) {
            AppMethodBeat.o(14800);
            return true;
        }
        AppMethodBeat.o(14800);
        return false;
    }

    public static final void a(as asVar, String str) {
        AppMethodBeat.i(14801);
        j.p(asVar, "receiver$0");
        j.p(str, "key");
        asVar.putLong(str, System.currentTimeMillis());
        AppMethodBeat.o(14801);
    }
}
