package com.tencent.p177mm.plugin.sandbox;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.p1283p.C21426a;
import com.tencent.p177mm.plugin.p1283p.C21427b;
import com.tencent.p177mm.plugin.p1283p.C21428c;
import com.tencent.p177mm.sandbox.monitor.C15412c;
import com.tencent.p177mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver;
import com.tencent.p177mm.sandbox.p758a.C7291a;
import com.tencent.p177mm.sandbox.updater.AppUpdaterUI;
import com.tencent.p177mm.sandbox.updater.Updater;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.sandbox.SubCoreSandBox */
public class SubCoreSandBox implements C1816at, C21428c {
    public static boolean pYG = false;
    public static boolean pYH = false;

    public SubCoreSandBox() {
        AppMethodBeat.m2504i(24382);
        C4990ab.m7416i("MicroMsg.SubCoreSandBox", "SubCoreSandBox constructor at: " + System.currentTimeMillis());
        AppMethodBeat.m2505o(24382);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        AppMethodBeat.m2504i(24383);
        C4990ab.m7416i("MicroMsg.SubCoreSandBox", "SubCoreSandBox getBaseDBFactories at: " + System.currentTimeMillis());
        AppMethodBeat.m2505o(24383);
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
        AppMethodBeat.m2504i(24384);
        C4990ab.m7416i("MicroMsg.SubCoreSandBox", "SubCoreSandBox clearPluginData at: " + System.currentTimeMillis());
        AppMethodBeat.m2505o(24384);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(24385);
        C4990ab.m7416i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountPostReset at: " + System.currentTimeMillis());
        AppMethodBeat.m2505o(24385);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
        AppMethodBeat.m2504i(24386);
        C4990ab.m7416i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onSdcardMount at: " + System.currentTimeMillis());
        AppMethodBeat.m2505o(24386);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(24387);
        C4990ab.m7416i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountRelease at: " + System.currentTimeMillis());
        AppMethodBeat.m2505o(24387);
    }

    public final void bQS() {
        AppMethodBeat.m2504i(24388);
        Updater.m79767LS(16);
        AppMethodBeat.m2505o(24388);
    }

    /* renamed from: c */
    public final C21426a mo36878c(Context context, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(24389);
        Updater e = Updater.m79774e(context, onCancelListener);
        AppMethodBeat.m2505o(24389);
        return e;
    }

    /* renamed from: d */
    public final C21426a mo36879d(Context context, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(24390);
        Updater f = Updater.m79779f(context, onCancelListener);
        AppMethodBeat.m2505o(24390);
        return f;
    }

    /* renamed from: ey */
    public final C21426a mo36881ey(Context context) {
        AppMethodBeat.m2504i(24391);
        Updater gh = Updater.m79781gh(context);
        AppMethodBeat.m2505o(24391);
        return gh;
    }

    /* renamed from: ez */
    public final void mo36882ez(Context context) {
        AppMethodBeat.m2504i(24392);
        Updater.m79777ez(context);
        AppMethodBeat.m2505o(24392);
    }

    /* renamed from: e */
    public final void mo36880e(String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(24393);
        Updater.m79775e(str, i, str2, str3);
        AppMethodBeat.m2505o(24393);
    }

    public final C21427b bQT() {
        AppMethodBeat.m2504i(24394);
        C7291a c7291a = new C7291a(2);
        AppMethodBeat.m2505o(24394);
        return c7291a;
    }

    /* renamed from: RP */
    public final String mo36875RP(String str) {
        AppMethodBeat.m2504i(24395);
        String RP = C15412c.m23693RP(str);
        AppMethodBeat.m2505o(24395);
        return RP;
    }

    /* renamed from: x */
    public final void mo36884x(Context context, Intent intent) {
        AppMethodBeat.m2504i(24396);
        if (context != null) {
            intent.setClass(context, ExceptionMonitorBroadcastReceiver.class);
            C4996ah.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.m2505o(24396);
    }

    /* renamed from: y */
    public final void mo36885y(Context context, Intent intent) {
        AppMethodBeat.m2504i(24397);
        intent.setClass(context, AppUpdaterUI.class);
        context.startActivity(intent);
        AppMethodBeat.m2505o(24397);
    }

    /* renamed from: jd */
    public final void mo36883jd(boolean z) {
        pYG = true;
        pYH = z;
    }
}
