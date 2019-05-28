package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.manager.C31979c.C31980a;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.manager.e */
final class C45003e implements C31979c {
    private boolean aGA;
    private final BroadcastReceiver aGB = new C371991();
    final C31980a aGy;
    boolean aGz;
    private final Context context;

    /* renamed from: com.bumptech.glide.manager.e$1 */
    class C371991 extends BroadcastReceiver {
        C371991() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(92378);
            boolean z = C45003e.this.aGz;
            C45003e.this.aGz = C45003e.isConnected(context);
            if (z != C45003e.this.aGz) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    new StringBuilder("connectivity changed, isConnected: ").append(C45003e.this.aGz);
                }
                C45003e.this.aGy.mo18673aw(C45003e.this.aGz);
            }
            AppMethodBeat.m2505o(92378);
        }
    }

    C45003e(Context context, C31980a c31980a) {
        AppMethodBeat.m2504i(92379);
        this.context = context.getApplicationContext();
        this.aGy = c31980a;
        AppMethodBeat.m2505o(92379);
    }

    @SuppressLint({"MissingPermission"})
    static boolean isConnected(Context context) {
        AppMethodBeat.m2504i(92380);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C8561i.m15217d((ConnectivityManager) context.getSystemService("connectivity"), "Argument must not be null")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                AppMethodBeat.m2505o(92380);
                return false;
            }
            AppMethodBeat.m2505o(92380);
            return true;
        } catch (RuntimeException e) {
            Log.isLoggable("ConnectivityMonitor", 5);
            AppMethodBeat.m2505o(92380);
            return true;
        }
    }

    public final void onDestroy() {
    }

    public final void onStart() {
        AppMethodBeat.m2504i(92381);
        if (!this.aGA) {
            this.aGz = C45003e.isConnected(this.context);
            try {
                this.context.registerReceiver(this.aGB, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.aGA = true;
                AppMethodBeat.m2505o(92381);
                return;
            } catch (SecurityException e) {
                Log.isLoggable("ConnectivityMonitor", 5);
            }
        }
        AppMethodBeat.m2505o(92381);
    }

    public final void onStop() {
        AppMethodBeat.m2504i(92382);
        if (this.aGA) {
            this.context.unregisterReceiver(this.aGB);
            this.aGA = false;
        }
        AppMethodBeat.m2505o(92382);
    }
}
