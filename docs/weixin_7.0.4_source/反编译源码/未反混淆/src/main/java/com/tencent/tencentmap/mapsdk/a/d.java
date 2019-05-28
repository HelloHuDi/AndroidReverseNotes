package com.tencent.tencentmap.mapsdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ag;
import com.tencent.tencentmap.mapsdk.maps.a.ax;
import com.tencent.tencentmap.mapsdk.maps.a.t;

public final class d extends BroadcastReceiver {
    private boolean a = false;
    private Context b;
    private Runnable c = new Runnable() {
        public final void run() {
            AppMethodBeat.i(97772);
            ag.b(" db events to up on netConnectChange", new Object[0]);
            try {
                ax.a(true);
                AppMethodBeat.o(97772);
            } catch (Throwable th) {
                ag.a(th);
                AppMethodBeat.o(97772);
            }
        }
    };

    public d() {
        AppMethodBeat.i(97773);
        AppMethodBeat.o(97773);
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(97774);
        if (context == null) {
            try {
                ag.c(" onReceive context is null!", new Object[0]);
                AppMethodBeat.o(97774);
                return;
            } catch (Exception e) {
                ag.a(e);
                AppMethodBeat.o(97774);
                return;
            }
        }
        if (this.b == null) {
            this.b = context;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            ag.c(" onReceive ConnectivityManager is null!", new Object[0]);
            AppMethodBeat.o(97774);
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
            t a = t.a(context);
            if (!(a.a() || ax.d().h() == 0 || a.j() == 2)) {
                b.a().a(a.d());
            }
        }
        if (!(state == null && state2 == null) && (State.CONNECTED == state2 || State.CONNECTED == state)) {
            b.a().a(this.c);
        }
        AppMethodBeat.o(97774);
    }

    public final void a(Context context) {
        AppMethodBeat.i(97775);
        if (context == null) {
            ag.c(" Context is null!", new Object[0]);
            AppMethodBeat.o(97775);
            return;
        }
        if (!this.a) {
            this.a = true;
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        AppMethodBeat.o(97775);
    }
}
