package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.h.i;
import com.bumptech.glide.manager.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e implements c {
    private boolean aGA;
    private final BroadcastReceiver aGB = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(92378);
            boolean z = e.this.aGz;
            e.this.aGz = e.isConnected(context);
            if (z != e.this.aGz) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    new StringBuilder("connectivity changed, isConnected: ").append(e.this.aGz);
                }
                e.this.aGy.aw(e.this.aGz);
            }
            AppMethodBeat.o(92378);
        }
    };
    final a aGy;
    boolean aGz;
    private final Context context;

    e(Context context, a aVar) {
        AppMethodBeat.i(92379);
        this.context = context.getApplicationContext();
        this.aGy = aVar;
        AppMethodBeat.o(92379);
    }

    @SuppressLint({"MissingPermission"})
    static boolean isConnected(Context context) {
        AppMethodBeat.i(92380);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) i.d((ConnectivityManager) context.getSystemService("connectivity"), "Argument must not be null")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                AppMethodBeat.o(92380);
                return false;
            }
            AppMethodBeat.o(92380);
            return true;
        } catch (RuntimeException e) {
            Log.isLoggable("ConnectivityMonitor", 5);
            AppMethodBeat.o(92380);
            return true;
        }
    }

    public final void onDestroy() {
    }

    public final void onStart() {
        AppMethodBeat.i(92381);
        if (!this.aGA) {
            this.aGz = isConnected(this.context);
            try {
                this.context.registerReceiver(this.aGB, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.aGA = true;
                AppMethodBeat.o(92381);
                return;
            } catch (SecurityException e) {
                Log.isLoggable("ConnectivityMonitor", 5);
            }
        }
        AppMethodBeat.o(92381);
    }

    public final void onStop() {
        AppMethodBeat.i(92382);
        if (this.aGA) {
            this.context.unregisterReceiver(this.aGB);
            this.aGA = false;
        }
        AppMethodBeat.o(92382);
    }
}
