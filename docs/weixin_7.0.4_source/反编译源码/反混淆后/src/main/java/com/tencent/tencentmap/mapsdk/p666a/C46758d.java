package com.tencent.tencentmap.mapsdk.p666a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16205ag;
import com.tencent.tencentmap.mapsdk.maps.p667a.C25011ax;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36541t;

/* renamed from: com.tencent.tencentmap.mapsdk.a.d */
public final class C46758d extends BroadcastReceiver {
    /* renamed from: a */
    private boolean f18038a = false;
    /* renamed from: b */
    private Context f18039b;
    /* renamed from: c */
    private Runnable f18040c = new C243421();

    /* renamed from: com.tencent.tencentmap.mapsdk.a.d$1 */
    class C243421 implements Runnable {
        C243421() {
        }

        public final void run() {
            AppMethodBeat.m2504i(97772);
            C16205ag.m24685b(" db events to up on netConnectChange", new Object[0]);
            try {
                C25011ax.m39273a(true);
                AppMethodBeat.m2505o(97772);
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                AppMethodBeat.m2505o(97772);
            }
        }
    }

    public C46758d() {
        AppMethodBeat.m2504i(97773);
        AppMethodBeat.m2505o(97773);
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(97774);
        if (context == null) {
            try {
                C16205ag.m24686c(" onReceive context is null!", new Object[0]);
                AppMethodBeat.m2505o(97774);
                return;
            } catch (Exception e) {
                C16205ag.m24684a(e);
                AppMethodBeat.m2505o(97774);
                return;
            }
        }
        if (this.f18039b == null) {
            this.f18039b = context;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            C16205ag.m24686c(" onReceive ConnectivityManager is null!", new Object[0]);
            AppMethodBeat.m2505o(97774);
            return;
        }
        State state;
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo != null) {
            state = networkInfo.getState();
        } else {
            state = null;
        }
        State state2;
        if (networkInfo2 != null) {
            state2 = networkInfo2.getState();
        } else {
            state2 = null;
        }
        if (!(state == null && state2 == null)) {
            C36541t a = C36541t.m60530a(context);
            if (!(a.mo57786a() || C25011ax.m39275d().mo41927h() == 0 || a.mo57794j() == 2)) {
                C46752b.m88622a().mo12298a(a.mo57788d());
            }
        }
        if (!(state == null && state2 == null) && (State.CONNECTED == state2 || State.CONNECTED == state)) {
            C46752b.m88622a().mo12298a(this.f18040c);
        }
        AppMethodBeat.m2505o(97774);
    }

    /* renamed from: a */
    public final void mo75309a(Context context) {
        AppMethodBeat.m2504i(97775);
        if (context == null) {
            C16205ag.m24686c(" Context is null!", new Object[0]);
            AppMethodBeat.m2505o(97775);
            return;
        }
        if (!this.f18038a) {
            this.f18038a = true;
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        AppMethodBeat.m2505o(97775);
    }
}
