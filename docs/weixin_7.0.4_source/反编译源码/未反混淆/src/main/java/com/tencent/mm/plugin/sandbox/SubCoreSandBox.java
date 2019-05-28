package com.tencent.mm.plugin.sandbox;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sandbox.updater.Updater;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public class SubCoreSandBox implements at, c {
    public static boolean pYG = false;
    public static boolean pYH = false;

    public SubCoreSandBox() {
        AppMethodBeat.i(24382);
        ab.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox constructor at: " + System.currentTimeMillis());
        AppMethodBeat.o(24382);
    }

    public final HashMap<Integer, d> Jx() {
        AppMethodBeat.i(24383);
        ab.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox getBaseDBFactories at: " + System.currentTimeMillis());
        AppMethodBeat.o(24383);
        return null;
    }

    public final void iy(int i) {
        AppMethodBeat.i(24384);
        ab.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox clearPluginData at: " + System.currentTimeMillis());
        AppMethodBeat.o(24384);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(24385);
        ab.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountPostReset at: " + System.currentTimeMillis());
        AppMethodBeat.o(24385);
    }

    public final void bA(boolean z) {
        AppMethodBeat.i(24386);
        ab.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onSdcardMount at: " + System.currentTimeMillis());
        AppMethodBeat.o(24386);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(24387);
        ab.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountRelease at: " + System.currentTimeMillis());
        AppMethodBeat.o(24387);
    }

    public final void bQS() {
        AppMethodBeat.i(24388);
        Updater.LS(16);
        AppMethodBeat.o(24388);
    }

    public final a c(Context context, OnCancelListener onCancelListener) {
        AppMethodBeat.i(24389);
        Updater e = Updater.e(context, onCancelListener);
        AppMethodBeat.o(24389);
        return e;
    }

    public final a d(Context context, OnCancelListener onCancelListener) {
        AppMethodBeat.i(24390);
        Updater f = Updater.f(context, onCancelListener);
        AppMethodBeat.o(24390);
        return f;
    }

    public final a ey(Context context) {
        AppMethodBeat.i(24391);
        Updater gh = Updater.gh(context);
        AppMethodBeat.o(24391);
        return gh;
    }

    public final void ez(Context context) {
        AppMethodBeat.i(24392);
        Updater.ez(context);
        AppMethodBeat.o(24392);
    }

    public final void e(String str, int i, String str2, String str3) {
        AppMethodBeat.i(24393);
        Updater.e(str, i, str2, str3);
        AppMethodBeat.o(24393);
    }

    public final b bQT() {
        AppMethodBeat.i(24394);
        com.tencent.mm.sandbox.a.a aVar = new com.tencent.mm.sandbox.a.a(2);
        AppMethodBeat.o(24394);
        return aVar;
    }

    public final String RP(String str) {
        AppMethodBeat.i(24395);
        String RP = com.tencent.mm.sandbox.monitor.c.RP(str);
        AppMethodBeat.o(24395);
        return RP;
    }

    public final void x(Context context, Intent intent) {
        AppMethodBeat.i(24396);
        if (context != null) {
            intent.setClass(context, ExceptionMonitorBroadcastReceiver.class);
            ah.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(24396);
    }

    public final void y(Context context, Intent intent) {
        AppMethodBeat.i(24397);
        intent.setClass(context, AppUpdaterUI.class);
        context.startActivity(intent);
        AppMethodBeat.o(24397);
    }

    public final void jd(boolean z) {
        pYG = true;
        pYH = z;
    }
}
