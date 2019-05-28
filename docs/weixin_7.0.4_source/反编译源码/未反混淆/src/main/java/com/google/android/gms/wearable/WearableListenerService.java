package com.google.android.gms.wearable;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelClient.Channel;
import com.google.android.gms.wearable.ChannelClient.ChannelCallback;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.internal.zzah;
import com.google.android.gms.wearable.internal.zzas;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.internal.zzen;
import com.google.android.gms.wearable.internal.zzfe;
import com.google.android.gms.wearable.internal.zzfo;
import com.google.android.gms.wearable.internal.zzhp;
import com.google.android.gms.wearable.internal.zzi;
import com.google.android.gms.wearable.internal.zzl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class WearableListenerService extends Service implements CapabilityListener, ChannelListener, DataListener, MessageListener {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private ComponentName service;
    private zzc zzad;
    private IBinder zzae;
    private Intent zzaf;
    private Looper zzag;
    private final Object zzah = new Object();
    private boolean zzai;
    private zzas zzaj = new zzas(new zza(this, null));

    class zzb implements ServiceConnection {
        private zzb(WearableListenerService wearableListenerService) {
        }

        /* synthetic */ zzb(WearableListenerService wearableListenerService, zzk zzk) {
            this(wearableListenerService);
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    final class zzc extends Handler {
        private boolean started;
        private final zzb zzal = new zzb(WearableListenerService.this, null);

        zzc(Looper looper) {
            super(looper);
            AppMethodBeat.i(70918);
            AppMethodBeat.o(70918);
        }

        @SuppressLint({"UntrackedBindService"})
        private final synchronized void zzb() {
            AppMethodBeat.i(70921);
            if (this.started) {
                AppMethodBeat.o(70921);
            } else {
                if (Log.isLoggable("WearableLS", 2)) {
                    String valueOf = String.valueOf(WearableListenerService.this.service);
                    new StringBuilder(String.valueOf(valueOf).length() + 13).append("bindService: ").append(valueOf);
                }
                WearableListenerService.this.bindService(WearableListenerService.this.zzaf, this.zzal, 1);
                this.started = true;
                AppMethodBeat.o(70921);
            }
        }

        @SuppressLint({"UntrackedBindService"})
        private final synchronized void zzb(String str) {
            AppMethodBeat.i(70922);
            if (this.started) {
                if (Log.isLoggable("WearableLS", 2)) {
                    String valueOf = String.valueOf(WearableListenerService.this.service);
                    new StringBuilder((String.valueOf(str).length() + 17) + String.valueOf(valueOf).length()).append("unbindService: ").append(str).append(", ").append(valueOf);
                }
                try {
                    WearableListenerService.this.unbindService(this.zzal);
                } catch (RuntimeException e) {
                }
                this.started = false;
                AppMethodBeat.o(70922);
            } else {
                AppMethodBeat.o(70922);
            }
        }

        public final void dispatchMessage(Message message) {
            AppMethodBeat.i(70919);
            zzb();
            try {
                super.dispatchMessage(message);
                if (hasMessages(0)) {
                    AppMethodBeat.o(70919);
                    return;
                }
                zzb("dispatch");
                AppMethodBeat.o(70919);
            } catch (Throwable th) {
                if (!hasMessages(0)) {
                    zzb("dispatch");
                }
                AppMethodBeat.o(70919);
            }
        }

        /* Access modifiers changed, original: final */
        public final void quit() {
            AppMethodBeat.i(70920);
            getLooper().quit();
            zzb("quit");
            AppMethodBeat.o(70920);
        }
    }

    class zza extends ChannelCallback {
        private zza() {
        }

        /* synthetic */ zza(WearableListenerService wearableListenerService, zzk zzk) {
            this();
        }

        public final void onChannelClosed(Channel channel, int i, int i2) {
            AppMethodBeat.i(70915);
            WearableListenerService.this.onChannelClosed(channel, i, i2);
            AppMethodBeat.o(70915);
        }

        public final void onChannelOpened(Channel channel) {
            AppMethodBeat.i(70914);
            WearableListenerService.this.onChannelOpened(channel);
            AppMethodBeat.o(70914);
        }

        public final void onInputClosed(Channel channel, int i, int i2) {
            AppMethodBeat.i(70916);
            WearableListenerService.this.onInputClosed(channel, i, i2);
            AppMethodBeat.o(70916);
        }

        public final void onOutputClosed(Channel channel, int i, int i2) {
            AppMethodBeat.i(70917);
            WearableListenerService.this.onOutputClosed(channel, i, i2);
            AppMethodBeat.o(70917);
        }
    }

    final class zzd extends zzen {
        private volatile int zzam;

        private zzd() {
            this.zzam = -1;
        }

        /* synthetic */ zzd(WearableListenerService wearableListenerService, zzk zzk) {
            this();
        }

        private final boolean zza(Runnable runnable, String str, Object obj) {
            AppMethodBeat.i(70932);
            if (Log.isLoggable("WearableLS", 3)) {
                String.format("%s: %s %s", new Object[]{str, WearableListenerService.this.service.toString(), obj});
            }
            int callingUid = Binder.getCallingUid();
            if (callingUid == this.zzam) {
                callingUid = 1;
            } else if (zzhp.zza(WearableListenerService.this).zze("com.google.android.wearable.app.cn") && UidVerifier.uidHasPackageName(WearableListenerService.this, callingUid, "com.google.android.wearable.app.cn")) {
                this.zzam = callingUid;
                callingUid = 1;
            } else if (UidVerifier.isGooglePlayServicesUid(WearableListenerService.this, callingUid)) {
                this.zzam = callingUid;
                callingUid = 1;
            } else {
                new StringBuilder(57).append("Caller is not GooglePlayServices; caller UID: ").append(callingUid);
                boolean z = false;
            }
            if (callingUid == 0) {
                AppMethodBeat.o(70932);
                return false;
            }
            synchronized (WearableListenerService.this.zzah) {
                try {
                    if (WearableListenerService.this.zzai) {
                    } else {
                        WearableListenerService.this.zzad.post(runnable);
                        AppMethodBeat.o(70932);
                        return true;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(70932);
                }
            }
            return false;
        }

        public final void onConnectedNodes(List<zzfo> list) {
            AppMethodBeat.i(70927);
            zza(new zzp(this, list), "onConnectedNodes", list);
            AppMethodBeat.o(70927);
        }

        public final void zza(DataHolder dataHolder) {
            AppMethodBeat.i(70923);
            zzl zzl = new zzl(this, dataHolder);
            try {
                String valueOf = String.valueOf(dataHolder);
                if (zza(zzl, "onDataItemChanged", new StringBuilder(String.valueOf(valueOf).length() + 18).append(valueOf).append(", rows=").append(dataHolder.getCount()).toString())) {
                    AppMethodBeat.o(70923);
                }
            } finally {
                dataHolder.close();
                AppMethodBeat.o(70923);
            }
        }

        public final void zza(zzah zzah) {
            AppMethodBeat.i(70928);
            zza(new zzq(this, zzah), "onConnectedCapabilityChanged", zzah);
            AppMethodBeat.o(70928);
        }

        public final void zza(zzaw zzaw) {
            AppMethodBeat.i(70931);
            zza(new zzt(this, zzaw), "onChannelEvent", zzaw);
            AppMethodBeat.o(70931);
        }

        public final void zza(zzfe zzfe) {
            AppMethodBeat.i(70924);
            zza(new zzm(this, zzfe), "onMessageReceived", zzfe);
            AppMethodBeat.o(70924);
        }

        public final void zza(zzfo zzfo) {
            AppMethodBeat.i(70925);
            zza(new zzn(this, zzfo), "onPeerConnected", zzfo);
            AppMethodBeat.o(70925);
        }

        public final void zza(zzi zzi) {
            AppMethodBeat.i(70930);
            zza(new zzs(this, zzi), "onEntityUpdate", zzi);
            AppMethodBeat.o(70930);
        }

        public final void zza(zzl zzl) {
            AppMethodBeat.i(70929);
            zza(new zzr(this, zzl), "onNotificationReceived", zzl);
            AppMethodBeat.o(70929);
        }

        public final void zzb(zzfo zzfo) {
            AppMethodBeat.i(70926);
            zza(new zzo(this, zzfo), "onPeerDisconnected", zzfo);
            AppMethodBeat.o(70926);
        }
    }

    public WearableListenerService() {
        AppMethodBeat.i(70933);
        AppMethodBeat.o(70933);
    }

    public Looper getLooper() {
        AppMethodBeat.i(70937);
        if (this.zzag == null) {
            HandlerThread handlerThread = new HandlerThread("WearableListenerService");
            handlerThread.start();
            this.zzag = handlerThread.getLooper();
        }
        Looper looper = this.zzag;
        AppMethodBeat.o(70937);
        return looper;
    }

    public final IBinder onBind(Intent intent) {
        AppMethodBeat.i(70936);
        if (BIND_LISTENER_INTENT_ACTION.equals(intent.getAction())) {
            IBinder iBinder = this.zzae;
            AppMethodBeat.o(70936);
            return iBinder;
        }
        AppMethodBeat.o(70936);
        return null;
    }

    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
    }

    public void onChannelClosed(Channel channel, int i, int i2) {
    }

    public void onChannelClosed(Channel channel, int i, int i2) {
    }

    public void onChannelOpened(Channel channel) {
    }

    public void onChannelOpened(Channel channel) {
    }

    public void onConnectedNodes(List<Node> list) {
    }

    public void onCreate() {
        AppMethodBeat.i(70934);
        super.onCreate();
        this.service = new ComponentName(this, getClass().getName());
        if (Log.isLoggable("WearableLS", 3)) {
            String valueOf = String.valueOf(this.service);
            new StringBuilder(String.valueOf(valueOf).length() + 10).append("onCreate: ").append(valueOf);
        }
        this.zzad = new zzc(getLooper());
        this.zzaf = new Intent(BIND_LISTENER_INTENT_ACTION);
        this.zzaf.setComponent(this.service);
        this.zzae = new zzd(this, null);
        AppMethodBeat.o(70934);
    }

    public void onDataChanged(DataEventBuffer dataEventBuffer) {
    }

    public void onDestroy() {
        AppMethodBeat.i(70935);
        if (Log.isLoggable("WearableLS", 3)) {
            String valueOf = String.valueOf(this.service);
            new StringBuilder(String.valueOf(valueOf).length() + 11).append("onDestroy: ").append(valueOf);
        }
        synchronized (this.zzah) {
            try {
                this.zzai = true;
                if (this.zzad == null) {
                    String valueOf2 = String.valueOf(this.service);
                    Object illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf2).length() + 111).append("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=").append(valueOf2).toString());
                    throw illegalStateException;
                }
                this.zzad.quit();
            } finally {
                AppMethodBeat.o(70935);
            }
        }
        super.onDestroy();
        AppMethodBeat.o(70935);
    }

    public void onEntityUpdate(zzb zzb) {
    }

    public void onInputClosed(Channel channel, int i, int i2) {
    }

    public void onInputClosed(Channel channel, int i, int i2) {
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onNotificationReceived(zzd zzd) {
    }

    public void onOutputClosed(Channel channel, int i, int i2) {
    }

    public void onOutputClosed(Channel channel, int i, int i2) {
    }

    public void onPeerConnected(Node node) {
    }

    public void onPeerDisconnected(Node node) {
    }
}
