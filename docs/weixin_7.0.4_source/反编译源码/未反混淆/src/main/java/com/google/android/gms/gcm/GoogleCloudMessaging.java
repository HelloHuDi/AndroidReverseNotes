package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.f.a;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzaf;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String INSTANCE_ID_SCOPE = "GCM";
    @Deprecated
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    @Deprecated
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    @Deprecated
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    @Deprecated
    public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
    private static GoogleCloudMessaging zzac;
    private static final AtomicInteger zzaf = new AtomicInteger(1);
    private PendingIntent zzad;
    private final Map<String, Handler> zzae = Collections.synchronizedMap(new a());
    private final BlockingQueue<Intent> zzag = new LinkedBlockingQueue();
    private final Messenger zzah = new Messenger(new zzf(this, Looper.getMainLooper()));
    private Context zzk;

    static {
        AppMethodBeat.i(69976);
        AppMethodBeat.o(69976);
    }

    public GoogleCloudMessaging() {
        AppMethodBeat.i(69962);
        AppMethodBeat.o(69962);
    }

    @Deprecated
    public static synchronized GoogleCloudMessaging getInstance(Context context) {
        GoogleCloudMessaging googleCloudMessaging;
        synchronized (GoogleCloudMessaging.class) {
            AppMethodBeat.i(69960);
            if (zzac == null) {
                zze(context);
                googleCloudMessaging = new GoogleCloudMessaging();
                zzac = googleCloudMessaging;
                googleCloudMessaging.zzk = context.getApplicationContext();
            }
            googleCloudMessaging = zzac;
            AppMethodBeat.o(69960);
        }
        return googleCloudMessaging;
    }

    @Deprecated
    private final Intent zzd(Bundle bundle, boolean z) {
        AppMethodBeat.i(69970);
        IOException iOException;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            iOException = new IOException("MAIN_THREAD");
            AppMethodBeat.o(69970);
            throw iOException;
        } else if (zzf(this.zzk) < 0) {
            iOException = new IOException("Google Play Services missing");
            AppMethodBeat.o(69970);
            throw iOException;
        } else {
            Intent intent = new Intent(z ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzaf.zzl(this.zzk));
            zze(intent);
            intent.putExtra("google.message_id", "google.rpc" + zzaf.getAndIncrement());
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.zzah);
            if (z) {
                this.zzk.sendBroadcast(intent);
            } else {
                this.zzk.startService(intent);
            }
            try {
                Intent intent2 = (Intent) this.zzag.poll(30000, TimeUnit.MILLISECONDS);
                AppMethodBeat.o(69970);
                return intent2;
            } catch (InterruptedException e) {
                IOException iOException2 = new IOException(e.getMessage());
                AppMethodBeat.o(69970);
                throw iOException2;
            }
        }
    }

    @Deprecated
    @VisibleForTesting
    private final synchronized String zzd(boolean z, String... strArr) {
        String stringBuilder;
        AppMethodBeat.i(69969);
        String zzl = zzaf.zzl(this.zzk);
        IOException iOException;
        if (zzl == null) {
            iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.o(69969);
            throw iOException;
        }
        if (strArr != null) {
            if (strArr.length != 0) {
                StringBuilder stringBuilder2 = new StringBuilder(strArr[0]);
                for (int i = 1; i < strArr.length; i++) {
                    stringBuilder2.append(',').append(strArr[i]);
                }
                stringBuilder = stringBuilder2.toString();
                Bundle bundle = new Bundle();
                if (zzl.contains(".gsf")) {
                    bundle.putString("legacy.sender", stringBuilder);
                    stringBuilder = InstanceID.getInstance(this.zzk).getToken(stringBuilder, "GCM", bundle);
                    AppMethodBeat.o(69969);
                } else {
                    bundle.putString("sender", stringBuilder);
                    Intent zzd = zzd(bundle, z);
                    stringBuilder = "registration_id";
                    if (zzd == null) {
                        iOException = new IOException("SERVICE_NOT_AVAILABLE");
                        AppMethodBeat.o(69969);
                        throw iOException;
                    }
                    stringBuilder = zzd.getStringExtra(stringBuilder);
                    if (stringBuilder != null) {
                        AppMethodBeat.o(69969);
                    } else {
                        stringBuilder = zzd.getStringExtra("error");
                        if (stringBuilder != null) {
                            IOException iOException2 = new IOException(stringBuilder);
                            AppMethodBeat.o(69969);
                            throw iOException2;
                        }
                        iOException = new IOException("SERVICE_NOT_AVAILABLE");
                        AppMethodBeat.o(69969);
                        throw iOException;
                    }
                }
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No senderIds");
        AppMethodBeat.o(69969);
        throw illegalArgumentException;
        return stringBuilder;
    }

    private final boolean zzd(Intent intent) {
        AppMethodBeat.i(69966);
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) this.zzae.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                boolean sendMessage = handler.sendMessage(obtain);
                AppMethodBeat.o(69966);
                return sendMessage;
            }
        }
        AppMethodBeat.o(69966);
        return false;
    }

    static void zze(Context context) {
        AppMethodBeat.i(69961);
        String packageName = context.getPackageName();
        new StringBuilder(String.valueOf(packageName).length() + 48).append("GCM SDK is deprecated, ").append(packageName).append(" should update to use FCM");
        AppMethodBeat.o(69961);
    }

    private final synchronized void zze(Intent intent) {
        AppMethodBeat.i(69972);
        if (this.zzad == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzad = PendingIntent.getBroadcast(this.zzk, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzad);
        AppMethodBeat.o(69972);
    }

    public static int zzf(Context context) {
        AppMethodBeat.i(69974);
        String zzl = zzaf.zzl(context);
        if (zzl != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(zzl, 0);
                if (packageInfo != null) {
                    int i = packageInfo.versionCode;
                    AppMethodBeat.o(69974);
                    return i;
                }
            } catch (NameNotFoundException e) {
            }
        }
        AppMethodBeat.o(69974);
        return -1;
    }

    private final synchronized void zzg() {
        AppMethodBeat.i(69973);
        if (this.zzad != null) {
            this.zzad.cancel();
            this.zzad = null;
        }
        AppMethodBeat.o(69973);
    }

    @Deprecated
    public void close() {
        AppMethodBeat.i(69963);
        zzac = null;
        zzd.zzj = null;
        zzg();
        AppMethodBeat.o(69963);
    }

    @Deprecated
    public String getMessageType(Intent intent) {
        AppMethodBeat.i(69971);
        if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("message_type");
            if (stringExtra != null) {
                AppMethodBeat.o(69971);
                return stringExtra;
            }
            stringExtra = MESSAGE_TYPE_MESSAGE;
            AppMethodBeat.o(69971);
            return stringExtra;
        }
        AppMethodBeat.o(69971);
        return null;
    }

    @Deprecated
    public synchronized String register(String... strArr) {
        String zzd;
        AppMethodBeat.i(69968);
        zzd = zzd(zzaf.zzk(this.zzk), strArr);
        AppMethodBeat.o(69968);
        return zzd;
    }

    @Deprecated
    public void send(String str, String str2, long j, Bundle bundle) {
        AppMethodBeat.i(69965);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Missing 'to'");
            AppMethodBeat.o(69965);
            throw illegalArgumentException;
        }
        String zzl = zzaf.zzl(this.zzk);
        if (zzl == null) {
            IOException iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.o(69965);
            throw iOException;
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        zze(intent);
        intent.setPackage(zzl);
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(j));
        String str3 = "google.from";
        int indexOf = str.indexOf(64);
        String substring = indexOf > 0 ? str.substring(0, indexOf) : str;
        InstanceID.getInstance(this.zzk);
        intent.putExtra(str3, InstanceID.zzn().zze("", substring, "GCM"));
        if (zzl.contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String zzl2 : bundle.keySet()) {
                Object obj = bundle.get(zzl2);
                if (obj instanceof String) {
                    String str4 = "gcm.";
                    zzl2 = String.valueOf(zzl2);
                    bundle2.putString(zzl2.length() != 0 ? str4.concat(zzl2) : new String(str4), (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            InstanceID.getInstance(this.zzk).zze("GCM", "upstream", bundle2);
            AppMethodBeat.o(69965);
            return;
        }
        this.zzk.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
        AppMethodBeat.o(69965);
    }

    @Deprecated
    public void send(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(69964);
        send(str, str2, -1, bundle);
        AppMethodBeat.o(69964);
    }

    @Deprecated
    public synchronized void unregister() {
        AppMethodBeat.i(69967);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            IOException iOException = new IOException("MAIN_THREAD");
            AppMethodBeat.o(69967);
            throw iOException;
        }
        InstanceID.getInstance(this.zzk).deleteInstanceID();
        AppMethodBeat.o(69967);
    }
}
