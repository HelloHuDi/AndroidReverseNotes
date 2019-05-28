package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.l.i;
import java.io.IOException;

final class r implements Runnable {
    private final f bvt;
    private final long bwg;
    private final WakeLock bwh = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId bwi;

    @VisibleForTesting
    r(FirebaseInstanceId firebaseInstanceId, f fVar, long j) {
        AppMethodBeat.i(108765);
        this.bwi = firebaseInstanceId;
        this.bvt = fVar;
        this.bwg = j;
        this.bwh.setReferenceCounted(false);
        AppMethodBeat.o(108765);
    }

    /* JADX WARNING: Missing block: B:12:0x001e, code skipped:
            if (bc(r0) != false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @VisibleForTesting
    private final boolean uV() {
        AppMethodBeat.i(108768);
        while (true) {
            String uT;
            synchronized (this.bwi) {
                try {
                    uT = FirebaseInstanceId.uG().uT();
                    if (uT == null) {
                        AppMethodBeat.o(108768);
                        return true;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(108768);
                }
            }
            FirebaseInstanceId.uG().zzf(uT);
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzaj() {
        AppMethodBeat.i(108771);
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            AppMethodBeat.o(108771);
            return false;
        }
        AppMethodBeat.o(108771);
        return true;
    }

    public final void run() {
        Object obj = 1;
        AppMethodBeat.i(108766);
        this.bwh.acquire();
        try {
            this.bwi.zza(true);
            if (this.bvt.zzx() == 0) {
                obj = null;
            }
            if (obj == null) {
                this.bwi.zza(false);
            } else if (zzaj()) {
                if (uU() && uV()) {
                    this.bwi.zza(false);
                } else {
                    this.bwi.zza(this.bwg);
                }
                this.bwh.release();
                AppMethodBeat.o(108766);
            } else {
                s sVar = new s(this);
                FirebaseInstanceId.uH();
                sVar.bwj.getContext().registerReceiver(sVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.bwh.release();
                AppMethodBeat.o(108766);
            }
        } finally {
            this.bwh.release();
            AppMethodBeat.o(108766);
        }
    }

    @VisibleForTesting
    private final boolean uU() {
        AppMethodBeat.i(108767);
        q uF = this.bwi.uF();
        if (uF == null || uF.bb(this.bvt.uO())) {
            String str;
            try {
                FirebaseInstanceId firebaseInstanceId = this.bwi;
                String b = f.b(firebaseInstanceId.bvs);
                str = "*";
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    IOException iOException = new IOException("MAIN_THREAD");
                    AppMethodBeat.o(108767);
                    throw iOException;
                }
                if (str.isEmpty() || str.equalsIgnoreCase(AppMeasurement.FCM_ORIGIN) || str.equalsIgnoreCase(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
                    str = "*";
                }
                q d = FirebaseInstanceId.bvq.d("", b, str);
                str = (d == null || d.bb(firebaseInstanceId.bvt.uO())) ? firebaseInstanceId.bvv.a(b, str, new aa(firebaseInstanceId, b, str)).zzp() : d.bwe;
                if (str == null) {
                    AppMethodBeat.o(108767);
                    return false;
                }
                Log.isLoggable("FirebaseInstanceId", 3);
                if (uF == null || !(uF == null || str.equals(uF.bwe))) {
                    Context context = getContext();
                    Intent intent = new Intent("com.google.firebase.iid.TOKEN_REFRESH");
                    Intent intent2 = new Intent("com.google.firebase.INSTANCE_ID_EVENT");
                    intent2.setClass(context, FirebaseInstanceIdReceiver.class);
                    intent2.putExtra("wrapped_intent", intent);
                    context.sendBroadcast(intent2);
                }
                AppMethodBeat.o(108767);
                return true;
            } catch (IOException | SecurityException e) {
                str = "Token retrieval failed: ";
                String valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() != 0) {
                    str.concat(valueOf);
                } else {
                    valueOf = new String(str);
                }
                AppMethodBeat.o(108767);
                return false;
            }
        }
        AppMethodBeat.o(108767);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d A:{Catch:{ IOException -> 0x0060 }} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c7 A:{Catch:{ IOException -> 0x0060 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean bc(String str) {
        AppMethodBeat.i(108769);
        String[] split = str.split("!");
        if (split.length == 2) {
            String str2 = split[0];
            Object obj = split[1];
            boolean z = true;
            String valueOf;
            IOException iOException;
            try {
                switch (str2.hashCode()) {
                    case 83:
                        if (str2.equals("S")) {
                            z = false;
                        }
                    case i.CTRL_INDEX /*85*/:
                        if (str2.equals("U")) {
                            z = true;
                        }
                        FirebaseInstanceId firebaseInstanceId;
                        q uF;
                        Bundle bundle;
                        String str3;
                        String valueOf2;
                        String str4;
                        switch (z) {
                            case false:
                                firebaseInstanceId = this.bwi;
                                uF = firebaseInstanceId.uF();
                                if (uF != null && !uF.bb(firebaseInstanceId.bvt.uO())) {
                                    bundle = new Bundle();
                                    str3 = "gcm.topic";
                                    valueOf2 = String.valueOf("/topics/");
                                    valueOf = String.valueOf(obj);
                                    bundle.putString(str3, valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
                                    str4 = uF.bwe;
                                    str3 = String.valueOf("/topics/");
                                    valueOf = String.valueOf(obj);
                                    firebaseInstanceId.b(str4, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), bundle);
                                    if (FirebaseInstanceId.uH()) {
                                        break;
                                    }
                                }
                                iOException = new IOException("token not available");
                                AppMethodBeat.o(108769);
                                throw iOException;
                                break;
                            case true:
                                firebaseInstanceId = this.bwi;
                                uF = firebaseInstanceId.uF();
                                if (uF != null && !uF.bb(firebaseInstanceId.bvt.uO())) {
                                    bundle = new Bundle();
                                    str3 = "gcm.topic";
                                    valueOf2 = String.valueOf("/topics/");
                                    valueOf = String.valueOf(obj);
                                    bundle.putString(str3, valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
                                    bundle.putString("delete", "1");
                                    str4 = uF.bwe;
                                    str3 = String.valueOf("/topics/");
                                    valueOf = String.valueOf(obj);
                                    firebaseInstanceId.b(str4, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), bundle);
                                    FirebaseInstanceId.uH();
                                    break;
                                }
                                iOException = new IOException("token not available");
                                AppMethodBeat.o(108769);
                                throw iOException;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        break;
                    case true:
                        break;
                }
            } catch (IOException iOException2) {
                valueOf = "Topic sync failed: ";
                String valueOf3 = String.valueOf(iOException2.getMessage());
                if (valueOf3.length() != 0) {
                    valueOf.concat(valueOf3);
                } else {
                    valueOf3 = new String(valueOf);
                }
                AppMethodBeat.o(108769);
                return false;
            }
        }
        AppMethodBeat.o(108769);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final Context getContext() {
        AppMethodBeat.i(108770);
        Context applicationContext = this.bwi.bvs.getApplicationContext();
        AppMethodBeat.o(108770);
        return applicationContext;
    }
}
