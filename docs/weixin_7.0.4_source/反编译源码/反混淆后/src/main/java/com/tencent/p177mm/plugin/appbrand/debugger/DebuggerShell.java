package com.tencent.p177mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.kernel.p242c.C1695b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.DebuggerShell */
public final class DebuggerShell extends BroadcastReceiver implements C1694a, C1695b {
    private static boolean hjd;
    private final Map<String, C38172a> hjc = new HashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.DebuggerShell$a */
    public interface C38172a {
        /* renamed from: A */
        void mo21580A(Intent intent);

        String name();
    }

    public DebuggerShell() {
        AppMethodBeat.m2504i(129932);
        AppMethodBeat.m2505o(129932);
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(129933);
        String stringExtra = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        if (!C5046bo.isNullOrNil(stringExtra) && this.hjc.containsKey(stringExtra)) {
            ((C38172a) this.hjc.get(stringExtra)).mo21580A(intent);
        }
        AppMethodBeat.m2505o(129933);
    }

    /* renamed from: SH */
    public final void mo5202SH() {
        AppMethodBeat.m2504i(129934);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.appbrand.debugger");
        C4996ah.getContext().registerReceiver(this, intentFilter);
        for (C38172a c38172a : C10186a.hjb) {
            if (!(c38172a == null || C5046bo.isNullOrNil(c38172a.name()))) {
                this.hjc.put(c38172a.name(), c38172a);
            }
        }
        AppMethodBeat.m2505o(129934);
    }

    /* renamed from: SI */
    public final void mo5203SI() {
        AppMethodBeat.m2504i(129935);
        C4996ah.getContext().unregisterReceiver(this);
        this.hjc.clear();
        AppMethodBeat.m2505o(129935);
    }

    public static boolean ayT() {
        return hjd;
    }

    public static boolean ayU() {
        AppMethodBeat.m2504i(129936);
        if (hjd || C5047bp.dpL()) {
            AppMethodBeat.m2505o(129936);
            return true;
        }
        AppMethodBeat.m2505o(129936);
        return false;
    }

    static {
        AppMethodBeat.m2504i(129939);
        hjd = false;
        C4990ab.m7411d("MicroMsg.DebuggerShell", "<clinit> BuildConfig.ENABLE_APPBRAND_MONKEY_TEST=%b", Boolean.valueOf(hjd));
        if (!hjd && (C5058f.IS_FLAVOR_RED || C5047bp.dpL())) {
            hjd = C5018as.amF("ENABLE_APPBRAND_DEBUGGER").getBoolean("ENABLE_APPBRAND_DEBUGGER", false);
            C4990ab.m7411d("MicroMsg.DebuggerShell", "<clinit> ENABLE_MONKEY from mmkv = %b", Boolean.valueOf(hjd));
        }
        AppMethodBeat.m2505o(129939);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void ayV() {
        AppMethodBeat.m2504i(129937);
        C5018as.amF("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", true).commit();
        hjd = true;
        AppMethodBeat.m2505o(129937);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void ayW() {
        AppMethodBeat.m2504i(129938);
        C5018as.amF("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", false).commit();
        hjd = false;
        AppMethodBeat.m2505o(129938);
    }
}
