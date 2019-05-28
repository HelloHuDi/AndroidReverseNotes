package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IGmsServiceBroker.Stub;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public abstract class BaseGmsClient<T extends IInterface> {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final int CONNECT_STATE_LOCAL_CONNECTING = 3;
    public static final int CONNECT_STATE_REMOTE_CONNECTING = 2;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String FEATURE_GOOGLE_ME = "service_googleme";
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = new String[]{"service_esmobile", FEATURE_GOOGLE_ME};
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zzqz = new Feature[0];
    @VisibleForTesting
    protected ConnectionProgressReportCallbacks mConnectionProgressReportCallbacks;
    private final Context mContext;
    @VisibleForTesting
    protected AtomicInteger mDisconnectCount;
    final Handler mHandler;
    private final Object mLock;
    private final Looper zzcn;
    private final GoogleApiAvailabilityLight zzgk;
    private int zzra;
    private long zzrb;
    private long zzrc;
    private int zzrd;
    private long zzre;
    @VisibleForTesting
    private GmsServiceEndpoint zzrf;
    private final GmsClientSupervisor zzrg;
    private final Object zzrh;
    @GuardedBy("mServiceBrokerLock")
    private IGmsServiceBroker zzri;
    @GuardedBy("mLock")
    private T zzrj;
    private final ArrayList<CallbackProxy<?>> zzrk;
    @GuardedBy("mLock")
    private GmsServiceConnection zzrl;
    @GuardedBy("mLock")
    private int zzrm;
    private final BaseConnectionCallbacks zzrn;
    private final BaseOnConnectionFailedListener zzro;
    private final int zzrp;
    private final String zzrq;
    private ConnectionResult zzrr;
    private boolean zzrs;
    private volatile ConnectionInfo zzrt;

    public interface BaseConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    protected abstract class CallbackProxy<TListener> {
        private TListener zzli;
        private boolean zzrv = false;

        public CallbackProxy(TListener tListener) {
            this.zzli = tListener;
        }

        public void deliverCallback() {
            Object obj;
            synchronized (this) {
                obj = this.zzli;
                if (this.zzrv) {
                    String valueOf = String.valueOf(this);
                    new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    deliverCallback(obj);
                } catch (RuntimeException e) {
                    onDeliverCallbackFailed();
                    throw e;
                }
            }
            onDeliverCallbackFailed();
            synchronized (this) {
                this.zzrv = true;
            }
            unregister();
        }

        public abstract void deliverCallback(TListener tListener);

        public abstract void onDeliverCallbackFailed();

        public void removeListener() {
            synchronized (this) {
                this.zzli = null;
            }
        }

        public void unregister() {
            removeListener();
            synchronized (BaseGmsClient.this.zzrk) {
                BaseGmsClient.this.zzrk.remove(this);
            }
        }
    }

    public interface ConnectionProgressReportCallbacks {
        void onReportServiceBinding(ConnectionResult connectionResult);
    }

    @VisibleForTesting
    public final class GmsServiceConnection implements ServiceConnection {
        private final int zzrx;

        public GmsServiceConnection(int i) {
            this.zzrx = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(89573);
            if (iBinder == null) {
                BaseGmsClient.this.zzj(16);
                AppMethodBeat.o(89573);
                return;
            }
            synchronized (BaseGmsClient.this.zzrh) {
                try {
                    BaseGmsClient.this.zzri = Stub.asInterface(iBinder);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(89573);
                }
            }
            BaseGmsClient.this.onPostServiceBindingHandler(0, null, this.zzrx);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(89574);
            synchronized (BaseGmsClient.this.zzrh) {
                try {
                    BaseGmsClient.this.zzri = null;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(89574);
                }
            }
            BaseGmsClient.this.mHandler.sendMessage(BaseGmsClient.this.mHandler.obtainMessage(6, this.zzrx, 1));
        }
    }

    public interface SignOutCallbacks {
        void onSignOutComplete();
    }

    final class zzb extends Handler {
        public zzb(Looper looper) {
            super(looper);
        }

        private static void zza(Message message) {
            AppMethodBeat.i(89581);
            CallbackProxy callbackProxy = (CallbackProxy) message.obj;
            callbackProxy.onDeliverCallbackFailed();
            callbackProxy.unregister();
            AppMethodBeat.o(89581);
        }

        private static boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 7;
        }

        public final void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            AppMethodBeat.i(89580);
            ConnectionResult zzd;
            if (BaseGmsClient.this.mDisconnectCount.get() != message.arg1) {
                if (zzb(message)) {
                    zza(message);
                }
                AppMethodBeat.o(89580);
            } else if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !BaseGmsClient.this.isConnecting()) {
                zza(message);
                AppMethodBeat.o(89580);
            } else if (message.what == 4) {
                BaseGmsClient.this.zzrr = new ConnectionResult(message.arg2);
                if (!BaseGmsClient.this.zzcr() || BaseGmsClient.this.zzrs) {
                    zzd = BaseGmsClient.this.zzrr != null ? BaseGmsClient.this.zzrr : new ConnectionResult(8);
                    BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(zzd);
                    BaseGmsClient.this.onConnectionFailed(zzd);
                    AppMethodBeat.o(89580);
                    return;
                }
                BaseGmsClient.this.zza(3, null);
                AppMethodBeat.o(89580);
            } else if (message.what == 5) {
                zzd = BaseGmsClient.this.zzrr != null ? BaseGmsClient.this.zzrr : new ConnectionResult(8);
                BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(zzd);
                BaseGmsClient.this.onConnectionFailed(zzd);
                AppMethodBeat.o(89580);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(connectionResult);
                BaseGmsClient.this.onConnectionFailed(connectionResult);
                AppMethodBeat.o(89580);
            } else if (message.what == 6) {
                BaseGmsClient.this.zza(5, null);
                if (BaseGmsClient.this.zzrn != null) {
                    BaseGmsClient.this.zzrn.onConnectionSuspended(message.arg2);
                }
                BaseGmsClient.this.onConnectionSuspended(message.arg2);
                BaseGmsClient.this.zza(5, 1, null);
                AppMethodBeat.o(89580);
            } else if (message.what == 2 && !BaseGmsClient.this.isConnected()) {
                zza(message);
                AppMethodBeat.o(89580);
            } else if (zzb(message)) {
                ((CallbackProxy) message.obj).deliverCallback();
                AppMethodBeat.o(89580);
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
                AppMethodBeat.o(89580);
            }
        }
    }

    public class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        public void onReportServiceBinding(ConnectionResult connectionResult) {
            AppMethodBeat.i(89575);
            if (connectionResult.isSuccess()) {
                BaseGmsClient.this.getRemoteService(null, BaseGmsClient.this.getScopes());
                AppMethodBeat.o(89575);
                return;
            }
            if (BaseGmsClient.this.zzro != null) {
                BaseGmsClient.this.zzro.onConnectionFailed(connectionResult);
            }
            AppMethodBeat.o(89575);
        }
    }

    abstract class zza extends CallbackProxy<Boolean> {
        public final Bundle resolution;
        public final int statusCode;

        protected zza(int i, Bundle bundle) {
            super(Boolean.TRUE);
            this.statusCode = i;
            this.resolution = bundle;
        }

        /* Access modifiers changed, original: protected */
        public void deliverCallback(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                BaseGmsClient.this.zza(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!handleServiceSuccess()) {
                        BaseGmsClient.this.zza(1, null);
                        handleServiceFailure(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    BaseGmsClient.this.zza(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    BaseGmsClient.this.zza(1, null);
                    if (this.resolution != null) {
                        pendingIntent = (PendingIntent) this.resolution.getParcelable(BaseGmsClient.KEY_PENDING_INTENT);
                    }
                    handleServiceFailure(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        public abstract void handleServiceFailure(ConnectionResult connectionResult);

        public abstract boolean handleServiceSuccess();

        /* Access modifiers changed, original: protected */
        public void onDeliverCallbackFailed() {
        }
    }

    @VisibleForTesting
    public static final class GmsCallbacks extends IGmsCallbacks.Stub {
        private BaseGmsClient zzrw;
        private final int zzrx;

        public GmsCallbacks(BaseGmsClient baseGmsClient, int i) {
            this.zzrw = baseGmsClient;
            this.zzrx = i;
        }

        public final void onAccountValidationComplete(int i, Bundle bundle) {
            AppMethodBeat.i(89570);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
            AppMethodBeat.o(89570);
        }

        public final void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) {
            AppMethodBeat.i(89571);
            Preconditions.checkNotNull(this.zzrw, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzrw.onPostInitHandler(i, iBinder, bundle, this.zzrx);
            this.zzrw = null;
            AppMethodBeat.o(89571);
        }

        public final void onPostInitCompleteWithConnectionInfo(int i, IBinder iBinder, ConnectionInfo connectionInfo) {
            AppMethodBeat.i(89572);
            Preconditions.checkNotNull(this.zzrw, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Preconditions.checkNotNull(connectionInfo);
            this.zzrw.zza(connectionInfo);
            onPostInitComplete(i, iBinder, connectionInfo.getResolutionBundle());
            AppMethodBeat.o(89572);
        }
    }

    protected final class PostInitCallback extends zza {
        public final IBinder service;

        public PostInitCallback(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.service = iBinder;
        }

        /* Access modifiers changed, original: protected|final */
        public final void handleServiceFailure(ConnectionResult connectionResult) {
            AppMethodBeat.i(89576);
            if (BaseGmsClient.this.zzro != null) {
                BaseGmsClient.this.zzro.onConnectionFailed(connectionResult);
            }
            BaseGmsClient.this.onConnectionFailed(connectionResult);
            AppMethodBeat.o(89576);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean handleServiceSuccess() {
            AppMethodBeat.i(89577);
            try {
                String interfaceDescriptor = this.service.getInterfaceDescriptor();
                if (BaseGmsClient.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    IInterface createServiceInterface = BaseGmsClient.this.createServiceInterface(this.service);
                    if (createServiceInterface == null || !(BaseGmsClient.this.zza(2, 4, createServiceInterface) || BaseGmsClient.this.zza(3, 4, createServiceInterface))) {
                        AppMethodBeat.o(89577);
                        return false;
                    }
                    BaseGmsClient.this.zzrr = null;
                    Bundle connectionHint = BaseGmsClient.this.getConnectionHint();
                    if (BaseGmsClient.this.zzrn != null) {
                        BaseGmsClient.this.zzrn.onConnected(connectionHint);
                    }
                    AppMethodBeat.o(89577);
                    return true;
                }
                String serviceDescriptor = BaseGmsClient.this.getServiceDescriptor();
                new StringBuilder((String.valueOf(serviceDescriptor).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(serviceDescriptor).append(" vs. ").append(interfaceDescriptor);
                AppMethodBeat.o(89577);
                return false;
            } catch (RemoteException e) {
                AppMethodBeat.o(89577);
                return false;
            }
        }
    }

    protected final class PostServiceBindingCallback extends zza {
        public PostServiceBindingCallback(int i, Bundle bundle) {
            super(i, bundle);
        }

        /* Access modifiers changed, original: protected|final */
        public final void handleServiceFailure(ConnectionResult connectionResult) {
            AppMethodBeat.i(89578);
            BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(connectionResult);
            BaseGmsClient.this.onConnectionFailed(connectionResult);
            AppMethodBeat.o(89578);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean handleServiceSuccess() {
            AppMethodBeat.i(89579);
            BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
            AppMethodBeat.o(89579);
            return true;
        }
    }

    @VisibleForTesting
    protected BaseGmsClient(Context context, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.mLock = new Object();
        this.zzrh = new Object();
        this.zzrk = new ArrayList();
        this.zzrm = 1;
        this.zzrr = null;
        this.zzrs = false;
        this.zzrt = null;
        this.mDisconnectCount = new AtomicInteger(0);
        this.mContext = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.mHandler = (Handler) Preconditions.checkNotNull(handler, "Handler must not be null");
        this.zzcn = handler.getLooper();
        this.zzrg = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzgk = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzrp = i;
        this.zzrn = baseConnectionCallbacks;
        this.zzro = baseOnConnectionFailedListener;
        this.zzrq = null;
    }

    protected BaseGmsClient(Context context, Looper looper, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailabilityLight.getInstance(), i, (BaseConnectionCallbacks) Preconditions.checkNotNull(baseConnectionCallbacks), (BaseOnConnectionFailedListener) Preconditions.checkNotNull(baseOnConnectionFailedListener), str);
    }

    @VisibleForTesting
    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.mLock = new Object();
        this.zzrh = new Object();
        this.zzrk = new ArrayList();
        this.zzrm = 1;
        this.zzrr = null;
        this.zzrs = false;
        this.zzrt = null;
        this.mDisconnectCount = new AtomicInteger(0);
        this.mContext = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.zzcn = (Looper) Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzrg = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzgk = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.mHandler = new zzb(looper);
        this.zzrp = i;
        this.zzrn = baseConnectionCallbacks;
        this.zzro = baseOnConnectionFailedListener;
        this.zzrq = str;
    }

    private final void zza(int i, T t) {
        boolean z = true;
        if ((i == 4) != (t != null)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        synchronized (this.mLock) {
            this.zzrm = i;
            this.zzrj = t;
            onSetConnectState(i, t);
            switch (i) {
                case 1:
                    if (this.zzrl != null) {
                        this.zzrg.unbindService(getStartServiceAction(), getStartServicePackage(), getServiceBindFlags(), this.zzrl, getRealClientName());
                        this.zzrl = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    String zzcw;
                    String packageName;
                    if (!(this.zzrl == null || this.zzrf == null)) {
                        zzcw = this.zzrf.zzcw();
                        packageName = this.zzrf.getPackageName();
                        new StringBuilder((String.valueOf(zzcw).length() + 70) + String.valueOf(packageName).length()).append("Calling connect() while still connected, missing disconnect() for ").append(zzcw).append(" on ").append(packageName);
                        this.zzrg.unbindService(this.zzrf.zzcw(), this.zzrf.getPackageName(), this.zzrf.getBindFlags(), this.zzrl, getRealClientName());
                        this.mDisconnectCount.incrementAndGet();
                    }
                    this.zzrl = new GmsServiceConnection(this.mDisconnectCount.get());
                    GmsServiceEndpoint gmsServiceEndpoint = (this.zzrm != 3 || getLocalStartServiceAction() == null) ? new GmsServiceEndpoint(getStartServicePackage(), getStartServiceAction(), false, getServiceBindFlags()) : new GmsServiceEndpoint(getContext().getPackageName(), getLocalStartServiceAction(), true, getServiceBindFlags());
                    this.zzrf = gmsServiceEndpoint;
                    if (!this.zzrg.bindService(this.zzrf.zzcw(), this.zzrf.getPackageName(), this.zzrf.getBindFlags(), this.zzrl, getRealClientName())) {
                        zzcw = this.zzrf.zzcw();
                        packageName = this.zzrf.getPackageName();
                        new StringBuilder((String.valueOf(zzcw).length() + 34) + String.valueOf(packageName).length()).append("unable to connect to service: ").append(zzcw).append(" on ").append(packageName);
                        onPostServiceBindingHandler(16, null, this.mDisconnectCount.get());
                        break;
                    }
                    break;
                case 4:
                    onConnectedLocked(t);
                    break;
            }
        }
    }

    private final void zza(ConnectionInfo connectionInfo) {
        this.zzrt = connectionInfo;
    }

    private final boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.mLock) {
            if (this.zzrm != i) {
                z = false;
            } else {
                zza(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    private final boolean zzcq() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzrm == 3;
        }
        return z;
    }

    private final boolean zzcr() {
        if (this.zzrs || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private final void zzj(int i) {
        int i2;
        if (zzcq()) {
            i2 = 5;
            this.zzrs = true;
        } else {
            i2 = 4;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(i2, this.mDisconnectCount.get(), 16));
    }

    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.zzgk.isGooglePlayServicesAvailable(this.mContext, getMinApkVersion());
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, null);
            return;
        }
        connect(new LegacyClientCallbackAdapter());
    }

    /* Access modifiers changed, original: protected|final */
    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.mConnectionProgressReportCallbacks = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        zza(2, null);
    }

    public abstract T createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.mDisconnectCount.incrementAndGet();
        synchronized (this.zzrk) {
            int size = this.zzrk.size();
            for (int i = 0; i < size; i++) {
                ((CallbackProxy) this.zzrk.get(i)).removeListener();
            }
            this.zzrk.clear();
        }
        synchronized (this.zzrh) {
            this.zzri = null;
        }
        zza(1, null);
    }

    @Deprecated
    public final void doCallbackDEPRECATED(CallbackProxy<?> callbackProxy) {
        synchronized (this.zzrk) {
            this.zzrk.add(callbackProxy);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, this.mDisconnectCount.get(), -1, callbackProxy));
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        IInterface iInterface;
        IGmsServiceBroker iGmsServiceBroker;
        PrintWriter append;
        long j;
        String format;
        synchronized (this.mLock) {
            i = this.zzrm;
            iInterface = this.zzrj;
        }
        synchronized (this.zzrh) {
            iGmsServiceBroker = this.zzri;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("REMOTE_CONNECTING");
                break;
            case 3:
                printWriter.print("LOCAL_CONNECTING");
                break;
            case 4:
                printWriter.print("CONNECTED");
                break;
            case 5:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append(BuildConfig.COMMAND);
        } else {
            printWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println(BuildConfig.COMMAND);
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzrc > 0) {
            append = printWriter.append(str).append("lastConnectedTime=");
            j = this.zzrc;
            format = simpleDateFormat.format(new Date(this.zzrc));
            append.println(new StringBuilder(String.valueOf(format).length() + 21).append(j).append(" ").append(format).toString());
        }
        if (this.zzrb > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.zzra) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.zzra));
                    break;
            }
            append = printWriter.append(" lastSuspendedTime=");
            j = this.zzrb;
            format = simpleDateFormat.format(new Date(this.zzrb));
            append.println(new StringBuilder(String.valueOf(format).length() + 21).append(j).append(" ").append(format).toString());
        }
        if (this.zzre > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzrd));
            append = printWriter.append(" lastFailedTime=");
            j = this.zzre;
            String format2 = simpleDateFormat.format(new Date(this.zzre));
            append.println(new StringBuilder(String.valueOf(format2).length() + 21).append(j).append(" ").append(format2).toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Account getAccountOrDefault() {
        return getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
    }

    public Feature[] getApiFeatures() {
        return zzqz;
    }

    public final Feature[] getAvailableFeatures() {
        ConnectionInfo connectionInfo = this.zzrt;
        return connectionInfo == null ? null : connectionInfo.getAvailableFeatures();
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public String getEndpointPackageName() {
        if (isConnected() && this.zzrf != null) {
            return this.zzrf.getPackageName();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    /* Access modifiers changed, original: protected */
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @VisibleForTesting
    public final Handler getHandlerForTesting() {
        return this.mHandler;
    }

    /* Access modifiers changed, original: protected */
    public String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzcn;
    }

    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getRealClientName() {
        return this.zzrq == null ? this.mContext.getClass().getName() : this.zzrq;
    }

    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        GetServiceRequest extraArgs = new GetServiceRequest(this.zzrp).setCallingPackage(this.mContext.getPackageName()).setExtraArgs(getGetServiceRequestExtraArgs());
        if (set != null) {
            extraArgs.setScopes(set);
        }
        if (requiresSignIn()) {
            extraArgs.setClientRequestedAccount(getAccountOrDefault()).setAuthenticatedAccount(iAccountAccessor);
        } else if (requiresAccount()) {
            extraArgs.setClientRequestedAccount(getAccount());
        }
        extraArgs.setClientRequiredFeatures(getRequiredFeatures());
        extraArgs.setClientApiFeatures(getApiFeatures());
        try {
            synchronized (this.zzrh) {
                if (this.zzri != null) {
                    this.zzri.getService(new GmsCallbacks(this, this.mDisconnectCount.get()), extraArgs);
                }
            }
        } catch (DeadObjectException e) {
            triggerConnectionSuspended(1);
        } catch (SecurityException e2) {
            throw e2;
        } catch (RemoteException | RuntimeException e3) {
            onPostInitHandler(8, null, null, this.mDisconnectCount.get());
        }
    }

    public Feature[] getRequiredFeatures() {
        return zzqz;
    }

    /* Access modifiers changed, original: protected */
    public Set<Scope> getScopes() {
        return Collections.EMPTY_SET;
    }

    public final T getService() {
        IInterface iInterface;
        synchronized (this.mLock) {
            if (this.zzrm == 5) {
                throw new DeadObjectException();
            }
            checkConnected();
            Preconditions.checkState(this.zzrj != null, "Client is connected but service is null");
            iInterface = this.zzrj;
        }
        return iInterface;
    }

    /* Access modifiers changed, original: protected */
    public int getServiceBindFlags() {
        return GmsClientSupervisor.DEFAULT_BIND_FLAGS;
    }

    public IBinder getServiceBrokerBinder() {
        IBinder iBinder;
        synchronized (this.zzrh) {
            if (this.zzri == null) {
                iBinder = null;
            } else {
                iBinder = this.zzri.asBinder();
            }
        }
        return iBinder;
    }

    @VisibleForTesting
    public final IGmsServiceBroker getServiceBrokerForTesting() {
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.zzrh) {
            iGmsServiceBroker = this.zzri;
        }
        return iGmsServiceBroker;
    }

    public abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public abstract String getStartServiceAction();

    /* Access modifiers changed, original: protected */
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzrm == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzrm == 2 || this.zzrm == 3;
        }
        return z;
    }

    /* Access modifiers changed, original: protected */
    public void onConnectedLocked(T t) {
        this.zzrc = System.currentTimeMillis();
    }

    /* Access modifiers changed, original: protected */
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzrd = connectionResult.getErrorCode();
        this.zzre = System.currentTimeMillis();
    }

    /* Access modifiers changed, original: protected */
    public void onConnectionSuspended(int i) {
        this.zzra = i;
        this.zzrb = System.currentTimeMillis();
    }

    /* Access modifiers changed, original: protected */
    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new PostInitCallback(i, iBinder, bundle)));
    }

    /* Access modifiers changed, original: protected */
    public void onPostServiceBindingHandler(int i, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, i2, -1, new PostServiceBindingCallback(i, bundle)));
    }

    /* Access modifiers changed, original: 0000 */
    public void onSetConnectState(int i, T t) {
    }

    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    @VisibleForTesting
    public void setConnectionInfoForTesting(ConnectionInfo connectionInfo) {
        this.zzrt = connectionInfo;
    }

    @VisibleForTesting
    public final void setServiceBrokerForTesting(IGmsServiceBroker iGmsServiceBroker) {
        synchronized (this.zzrh) {
            this.zzri = iGmsServiceBroker;
        }
    }

    @VisibleForTesting
    public final void setServiceForTesting(T t) {
        zza(t != null ? 4 : 1, (IInterface) t);
    }

    public void triggerConnectionSuspended(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, this.mDisconnectCount.get(), i));
    }

    /* Access modifiers changed, original: protected */
    @VisibleForTesting
    public void triggerNotAvailable(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, PendingIntent pendingIntent) {
        this.mConnectionProgressReportCallbacks = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.mDisconnectCount.get(), i, pendingIntent));
    }
}
