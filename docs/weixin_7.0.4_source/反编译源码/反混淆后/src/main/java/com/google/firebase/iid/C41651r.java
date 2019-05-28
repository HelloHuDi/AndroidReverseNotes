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
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C33345i;
import java.io.IOException;

/* renamed from: com.google.firebase.iid.r */
final class C41651r implements Runnable {
    private final C32099f bvt;
    private final long bwg;
    private final WakeLock bwh = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId bwi;

    @VisibleForTesting
    C41651r(FirebaseInstanceId firebaseInstanceId, C32099f c32099f, long j) {
        AppMethodBeat.m2504i(108765);
        this.bwi = firebaseInstanceId;
        this.bvt = c32099f;
        this.bwg = j;
        this.bwh.setReferenceCounted(false);
        AppMethodBeat.m2505o(108765);
    }

    /* JADX WARNING: Missing block: B:12:0x001e, code skipped:
            if (m73036bc(r0) != false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @VisibleForTesting
    /* renamed from: uV */
    private final boolean m73038uV() {
        AppMethodBeat.m2504i(108768);
        while (true) {
            String uT;
            synchronized (this.bwi) {
                try {
                    uT = FirebaseInstanceId.m40568uG().mo19770uT();
                    if (uT == null) {
                        AppMethodBeat.m2505o(108768);
                        return true;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(108768);
                }
            }
            FirebaseInstanceId.m40568uG().zzf(uT);
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzaj() {
        AppMethodBeat.m2504i(108771);
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            AppMethodBeat.m2505o(108771);
            return false;
        }
        AppMethodBeat.m2505o(108771);
        return true;
    }

    public final void run() {
        Object obj = 1;
        AppMethodBeat.m2504i(108766);
        this.bwh.acquire();
        try {
            this.bwi.zza(true);
            if (this.bvt.zzx() == 0) {
                obj = null;
            }
            if (obj == null) {
                this.bwi.zza(false);
            } else if (zzaj()) {
                if (m73037uU() && m73038uV()) {
                    this.bwi.zza(false);
                } else {
                    this.bwi.zza(this.bwg);
                }
                this.bwh.release();
                AppMethodBeat.m2505o(108766);
            } else {
                C41652s c41652s = new C41652s(this);
                FirebaseInstanceId.m40569uH();
                c41652s.bwj.getContext().registerReceiver(c41652s, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.bwh.release();
                AppMethodBeat.m2505o(108766);
            }
        } finally {
            this.bwh.release();
            AppMethodBeat.m2505o(108766);
        }
    }

    @VisibleForTesting
    /* renamed from: uU */
    private final boolean m73037uU() {
        AppMethodBeat.m2504i(108767);
        C45074q uF = this.bwi.mo43238uF();
        if (uF == null || uF.mo72840bb(this.bvt.mo52664uO())) {
            String str;
            try {
                FirebaseInstanceId firebaseInstanceId = this.bwi;
                String b = C32099f.m52228b(firebaseInstanceId.bvs);
                str = "*";
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    IOException iOException = new IOException("MAIN_THREAD");
                    AppMethodBeat.m2505o(108767);
                    throw iOException;
                }
                if (str.isEmpty() || str.equalsIgnoreCase(AppMeasurement.FCM_ORIGIN) || str.equalsIgnoreCase(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
                    str = "*";
                }
                C45074q d = FirebaseInstanceId.bvq.mo19769d("", b, str);
                str = (d == null || d.mo72840bb(firebaseInstanceId.bvt.mo52664uO())) ? firebaseInstanceId.bvv.mo52668a(b, str, new C17706aa(firebaseInstanceId, b, str)).zzp() : d.bwe;
                if (str == null) {
                    AppMethodBeat.m2505o(108767);
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
                AppMethodBeat.m2505o(108767);
                return true;
            } catch (IOException | SecurityException e) {
                str = "Token retrieval failed: ";
                String valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() != 0) {
                    str.concat(valueOf);
                } else {
                    valueOf = new String(str);
                }
                AppMethodBeat.m2505o(108767);
                return false;
            }
        }
        AppMethodBeat.m2505o(108767);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d A:{Catch:{ IOException -> 0x0060 }} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c7 A:{Catch:{ IOException -> 0x0060 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: bc */
    private final boolean m73036bc(String str) {
        AppMethodBeat.m2504i(108769);
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
                    case C33345i.CTRL_INDEX /*85*/:
                        if (str2.equals("U")) {
                            z = true;
                        }
                        FirebaseInstanceId firebaseInstanceId;
                        C45074q uF;
                        Bundle bundle;
                        String str3;
                        String valueOf2;
                        String str4;
                        switch (z) {
                            case false:
                                firebaseInstanceId = this.bwi;
                                uF = firebaseInstanceId.mo43238uF();
                                if (uF != null && !uF.mo72840bb(firebaseInstanceId.bvt.mo52664uO())) {
                                    bundle = new Bundle();
                                    str3 = "gcm.topic";
                                    valueOf2 = String.valueOf("/topics/");
                                    valueOf = String.valueOf(obj);
                                    bundle.putString(str3, valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
                                    str4 = uF.bwe;
                                    str3 = String.valueOf("/topics/");
                                    valueOf = String.valueOf(obj);
                                    firebaseInstanceId.mo43234b(str4, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), bundle);
                                    if (FirebaseInstanceId.m40569uH()) {
                                        break;
                                    }
                                }
                                iOException = new IOException("token not available");
                                AppMethodBeat.m2505o(108769);
                                throw iOException;
                                break;
                            case true:
                                firebaseInstanceId = this.bwi;
                                uF = firebaseInstanceId.mo43238uF();
                                if (uF != null && !uF.mo72840bb(firebaseInstanceId.bvt.mo52664uO())) {
                                    bundle = new Bundle();
                                    str3 = "gcm.topic";
                                    valueOf2 = String.valueOf("/topics/");
                                    valueOf = String.valueOf(obj);
                                    bundle.putString(str3, valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
                                    bundle.putString("delete", "1");
                                    str4 = uF.bwe;
                                    str3 = String.valueOf("/topics/");
                                    valueOf = String.valueOf(obj);
                                    firebaseInstanceId.mo43234b(str4, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), bundle);
                                    FirebaseInstanceId.m40569uH();
                                    break;
                                }
                                iOException = new IOException("token not available");
                                AppMethodBeat.m2505o(108769);
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
                AppMethodBeat.m2505o(108769);
                return false;
            }
        }
        AppMethodBeat.m2505o(108769);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final Context getContext() {
        AppMethodBeat.m2504i(108770);
        Context applicationContext = this.bwi.bvs.getApplicationContext();
        AppMethodBeat.m2505o(108770);
        return applicationContext;
    }
}
