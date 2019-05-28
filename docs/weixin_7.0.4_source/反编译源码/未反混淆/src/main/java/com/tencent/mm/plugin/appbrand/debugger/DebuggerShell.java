package com.tencent.mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.f;
import java.util.HashMap;
import java.util.Map;

public final class DebuggerShell extends BroadcastReceiver implements com.tencent.mm.kernel.c.a, b {
    private static boolean hjd;
    private final Map<String, a> hjc = new HashMap();

    public interface a {
        void A(Intent intent);

        String name();
    }

    public DebuggerShell() {
        AppMethodBeat.i(129932);
        AppMethodBeat.o(129932);
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(129933);
        String stringExtra = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        if (!bo.isNullOrNil(stringExtra) && this.hjc.containsKey(stringExtra)) {
            ((a) this.hjc.get(stringExtra)).A(intent);
        }
        AppMethodBeat.o(129933);
    }

    public final void SH() {
        AppMethodBeat.i(129934);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.appbrand.debugger");
        ah.getContext().registerReceiver(this, intentFilter);
        for (a aVar : a.hjb) {
            if (!(aVar == null || bo.isNullOrNil(aVar.name()))) {
                this.hjc.put(aVar.name(), aVar);
            }
        }
        AppMethodBeat.o(129934);
    }

    public final void SI() {
        AppMethodBeat.i(129935);
        ah.getContext().unregisterReceiver(this);
        this.hjc.clear();
        AppMethodBeat.o(129935);
    }

    public static boolean ayT() {
        return hjd;
    }

    public static boolean ayU() {
        AppMethodBeat.i(129936);
        if (hjd || bp.dpL()) {
            AppMethodBeat.o(129936);
            return true;
        }
        AppMethodBeat.o(129936);
        return false;
    }

    static {
        AppMethodBeat.i(129939);
        hjd = false;
        ab.d("MicroMsg.DebuggerShell", "<clinit> BuildConfig.ENABLE_APPBRAND_MONKEY_TEST=%b", Boolean.valueOf(hjd));
        if (!hjd && (f.IS_FLAVOR_RED || bp.dpL())) {
            hjd = as.amF("ENABLE_APPBRAND_DEBUGGER").getBoolean("ENABLE_APPBRAND_DEBUGGER", false);
            ab.d("MicroMsg.DebuggerShell", "<clinit> ENABLE_MONKEY from mmkv = %b", Boolean.valueOf(hjd));
        }
        AppMethodBeat.o(129939);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void ayV() {
        AppMethodBeat.i(129937);
        as.amF("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", true).commit();
        hjd = true;
        AppMethodBeat.o(129937);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void ayW() {
        AppMethodBeat.i(129938);
        as.amF("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", false).commit();
        hjd = false;
        AppMethodBeat.o(129938);
    }
}
