package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.util.Arrays;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t\u001a\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u0006\u0010\f\u001a\u00020\r\u001a\u001a\u0010\u000e\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\r\u001a\u0012\u0010\u000e\u001a\u00020\u0005*\u00020\r2\u0006\u0010\u0011\u001a\u00020\r\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0015\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\u0005¨\u0006\u0018"}, dWq = {"bundleToString", "", "bundle", "Landroid/os/Bundle;", "findProcess", "", "context", "Landroid/content/Context;", "predicate", "Lkotlin/Function1;", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "getNetWorkType", "now", "", "isExpire", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "key", "duration", "putNow", "", "toDebugString", "Landroid/content/Intent;", "toInt", "", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.d */
public final class C2710d {
    /* renamed from: a */
    public static final boolean m4957a(C5018as c5018as, String str, long j) {
        AppMethodBeat.m2504i(14802);
        C25052j.m39376p(c5018as, "receiver$0");
        C25052j.m39376p(str, "key");
        boolean C = C2710d.m4952C(c5018as.getLong(str, 0), j);
        AppMethodBeat.m2505o(14802);
        return C;
    }

    /* renamed from: a */
    public static final boolean m4956a(Context context, C17126b<? super RunningAppProcessInfo, Boolean> c17126b) {
        AppMethodBeat.m2504i(14803);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(c17126b, "predicate");
        Object systemService = context.getSystemService("activity");
        if (systemService == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.m2505o(14803);
            throw c44941v;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
            C25052j.m39375o(runningAppProcessInfo, "info");
            if (((Boolean) c17126b.mo50am(runningAppProcessInfo)).booleanValue()) {
                AppMethodBeat.m2505o(14803);
                return true;
            }
        }
        AppMethodBeat.m2505o(14803);
        return false;
    }

    public static final String aWX() {
        AppMethodBeat.m2504i(14804);
        Context context = C4996ah.getContext();
        String str;
        if (C5023at.isWifi(context)) {
            str = "wifi";
            AppMethodBeat.m2505o(14804);
            return str;
        } else if (C5023at.is4G(context)) {
            str = "4g";
            AppMethodBeat.m2505o(14804);
            return str;
        } else if (C5023at.is3G(context)) {
            str = "3g";
            AppMethodBeat.m2505o(14804);
            return str;
        } else if (C5023at.is2G(context)) {
            str = "2g";
            AppMethodBeat.m2505o(14804);
            return str;
        } else {
            str = "none";
            AppMethodBeat.m2505o(14804);
            return str;
        }
    }

    /* renamed from: Q */
    public static final String m4954Q(Intent intent) {
        AppMethodBeat.m2504i(138512);
        C25052j.m39376p(intent, "receiver$0");
        String str = intent.toString() + " " + C2710d.m4953E(intent.getExtras());
        AppMethodBeat.m2505o(138512);
        return str;
    }

    /* renamed from: E */
    private static final String m4953E(Bundle bundle) {
        AppMethodBeat.m2504i(138513);
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
                        stringBuilder.append(C2710d.m4953E((Bundle) obj2));
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
        C25052j.m39375o(str2, "out.toString()");
        AppMethodBeat.m2505o(138513);
        return str2;
    }

    /* renamed from: C */
    public static final boolean m4952C(long j, long j2) {
        AppMethodBeat.m2504i(14800);
        if (System.currentTimeMillis() - j > j2) {
            AppMethodBeat.m2505o(14800);
            return true;
        }
        AppMethodBeat.m2505o(14800);
        return false;
    }

    /* renamed from: a */
    public static final void m4955a(C5018as c5018as, String str) {
        AppMethodBeat.m2504i(14801);
        C25052j.m39376p(c5018as, "receiver$0");
        C25052j.m39376p(str, "key");
        c5018as.putLong(str, System.currentTimeMillis());
        AppMethodBeat.m2505o(14801);
    }
}
