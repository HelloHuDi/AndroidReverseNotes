package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;

public abstract class GcmTaskService extends Service {
    public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
    public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
    public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
    private ComponentName componentName;
    private final Object lock = new Object();
    @GuardedBy("lock")
    private int zzt;
    private ExecutorService zzu;
    private Messenger zzv;
    private GcmNetworkManager zzw;

    @TargetApi(21)
    @VisibleForTesting
    class zzd extends Handler {
        zzd(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(69955);
            if (UidVerifier.uidHasPackageName(GcmTaskService.this, message.sendingUid, "com.google.android.gms")) {
                String valueOf;
                switch (message.what) {
                    case 1:
                        Bundle data = message.getData();
                        if (!data.isEmpty()) {
                            Messenger messenger = message.replyTo;
                            if (messenger != null) {
                                String string = data.getString("tag");
                                List parcelableArrayList = data.getParcelableArrayList("triggered_uris");
                                if (!GcmTaskService.this.zzg(string)) {
                                    GcmTaskService.this.zzd(new zze(string, messenger, data.getBundle("extras"), parcelableArrayList));
                                }
                            }
                        }
                        AppMethodBeat.o(69955);
                        return;
                    case 2:
                        if (Log.isLoggable("GcmTaskService", 3)) {
                            valueOf = String.valueOf(message);
                            new StringBuilder(String.valueOf(valueOf).length() + 45).append("ignoring unimplemented stop message for now: ").append(valueOf);
                        }
                        AppMethodBeat.o(69955);
                        return;
                    case 4:
                        GcmTaskService.this.onInitializeTasks();
                        AppMethodBeat.o(69955);
                        return;
                    default:
                        valueOf = String.valueOf(message);
                        new StringBuilder(String.valueOf(valueOf).length() + 31).append("Unrecognized message received: ").append(valueOf);
                        AppMethodBeat.o(69955);
                        return;
                }
            }
            AppMethodBeat.o(69955);
        }
    }

    class zze implements Runnable {
        private final Bundle extras;
        private final String tag;
        private final zzg zzaa;
        private final Messenger zzab;
        private final List<Uri> zzz;

        zze(String str, IBinder iBinder, Bundle bundle, List<Uri> list) {
            zzg zzg;
            AppMethodBeat.i(69956);
            this.tag = str;
            if (iBinder == null) {
                zzg = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
                zzg = queryLocalInterface instanceof zzg ? (zzg) queryLocalInterface : new zzh(iBinder);
            }
            this.zzaa = zzg;
            this.extras = bundle;
            this.zzz = list;
            this.zzab = null;
            AppMethodBeat.o(69956);
        }

        zze(String str, Messenger messenger, Bundle bundle, List<Uri> list) {
            this.tag = str;
            this.zzab = messenger;
            this.extras = bundle;
            this.zzz = list;
            this.zzaa = null;
        }

        static /* synthetic */ void zzd(zze zze, int i) {
            AppMethodBeat.i(69959);
            zze.zze(1);
            AppMethodBeat.o(69959);
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x00f0=Splitter:B:32:0x00f0, B:17:0x0096=Splitter:B:17:0x0096} */
        /* JADX WARNING: Missing block: B:12:0x0062, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(69958);
     */
        /* JADX WARNING: Missing block: B:24:0x00d3, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(69958);
     */
        /* JADX WARNING: Missing block: B:53:?, code skipped:
            return;
     */
        /* JADX WARNING: Missing block: B:54:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void zze(int i) {
            AppMethodBeat.i(69958);
            synchronized (GcmTaskService.this.lock) {
                try {
                    if (GcmTaskService.this.zzw.zzf(this.tag, GcmTaskService.this.componentName.getClassName())) {
                        GcmTaskService.this.zzw.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                        if (!(zzf() || GcmTaskService.this.zzw.zzf(GcmTaskService.this.componentName.getClassName()))) {
                            GcmTaskService.this.stopSelf(GcmTaskService.this.zzt);
                        }
                    } else {
                        if (zzf()) {
                            Messenger messenger = this.zzab;
                            Message obtain = Message.obtain();
                            obtain.what = 3;
                            obtain.arg1 = i;
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("component", GcmTaskService.this.componentName);
                            bundle.putString("tag", this.tag);
                            obtain.setData(bundle);
                            messenger.send(obtain);
                        } else {
                            this.zzaa.zzf(i);
                        }
                        GcmTaskService.this.zzw.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                        if (!(zzf() || GcmTaskService.this.zzw.zzf(GcmTaskService.this.componentName.getClassName()))) {
                            GcmTaskService.this.stopSelf(GcmTaskService.this.zzt);
                        }
                    }
                } catch (RemoteException e) {
                    String str = "Error reporting result of operation to scheduler for ";
                    String valueOf = String.valueOf(this.tag);
                    if (valueOf.length() != 0) {
                        str.concat(valueOf);
                    } else {
                        valueOf = new String(str);
                    }
                    GcmTaskService.this.zzw.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                    if (!(zzf() || GcmTaskService.this.zzw.zzf(GcmTaskService.this.componentName.getClassName()))) {
                        GcmTaskService.this.stopSelf(GcmTaskService.this.zzt);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(69958);
                }
            }
        }

        private final boolean zzf() {
            return this.zzab != null;
        }

        public final void run() {
            AppMethodBeat.i(69957);
            zze(GcmTaskService.this.onRunTask(new TaskParams(this.tag, this.extras, this.zzz)));
            AppMethodBeat.o(69957);
        }
    }

    private final void zzd(int i) {
        synchronized (this.lock) {
            this.zzt = i;
            if (!this.zzw.zzf(this.componentName.getClassName())) {
                stopSelf(this.zzt);
            }
        }
    }

    private final void zzd(zze zze) {
        try {
            this.zzu.execute(zze);
        } catch (RejectedExecutionException e) {
            zze.zzd(zze, 1);
        }
    }

    private final boolean zzg(String str) {
        boolean z;
        synchronized (this.lock) {
            z = !this.zzw.zzd(str, this.componentName.getClassName());
            if (z) {
                String packageName = getPackageName();
                new StringBuilder((String.valueOf(packageName).length() + 44) + String.valueOf(str).length()).append(packageName).append(" ").append(str).append(": Task already running, won't start another");
            }
        }
        return z;
    }

    public IBinder onBind(Intent intent) {
        return (intent != null && PlatformVersion.isAtLeastLollipop() && SERVICE_ACTION_EXECUTE_TASK.equals(intent.getAction())) ? this.zzv.getBinder() : null;
    }

    public void onCreate() {
        super.onCreate();
        this.zzw = GcmNetworkManager.getInstance(this);
        this.zzu = Executors.newFixedThreadPool(2, new zze(this));
        this.zzv = new Messenger(new zzd(Looper.getMainLooper()));
        this.componentName = new ComponentName(this, getClass());
    }

    public void onDestroy() {
        super.onDestroy();
        List shutdownNow = this.zzu.shutdownNow();
        if (!shutdownNow.isEmpty()) {
            new StringBuilder(79).append("Shutting down, but not all tasks are finished executing. Remaining: ").append(shutdownNow.size());
        }
    }

    public void onInitializeTasks() {
    }

    public abstract int onRunTask(TaskParams taskParams);

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            zzd(i2);
        } else {
            try {
                intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
                String action = intent.getAction();
                if (SERVICE_ACTION_EXECUTE_TASK.equals(action)) {
                    String stringExtra = intent.getStringExtra("tag");
                    Parcelable parcelableExtra = intent.getParcelableExtra("callback");
                    Bundle bundleExtra = intent.getBundleExtra("extras");
                    List parcelableArrayListExtra = intent.getParcelableArrayListExtra("triggered_uris");
                    if (!(parcelableExtra instanceof PendingCallback)) {
                        action = getPackageName();
                        new StringBuilder((String.valueOf(action).length() + 47) + String.valueOf(stringExtra).length()).append(action).append(" ").append(stringExtra).append(": Could not process request, invalid callback.");
                    } else if (zzg(stringExtra)) {
                        zzd(i2);
                    } else {
                        zzd(new zze(stringExtra, ((PendingCallback) parcelableExtra).zzal, bundleExtra, parcelableArrayListExtra));
                    }
                } else if (SERVICE_ACTION_INITIALIZE.equals(action)) {
                    onInitializeTasks();
                } else {
                    new StringBuilder(String.valueOf(action).length() + 37).append("Unknown action received ").append(action).append(", terminating");
                }
                zzd(i2);
            } finally {
                zzd(i2);
            }
        }
        return 2;
    }
}
