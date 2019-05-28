package android.support.p057v4.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.support.p057v4.app.C44957q.C25333a;
import android.util.Log;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.app.y */
public final class C17432y {
    /* renamed from: FG */
    private static final Object f3887FG = new Object();
    /* renamed from: FH */
    private static String f3888FH;
    /* renamed from: FI */
    private static Set<String> f3889FI = new HashSet();
    /* renamed from: FK */
    private static C17430d f3890FK;
    private static final Object sLock = new Object();
    /* renamed from: FJ */
    public final NotificationManager f3891FJ = ((NotificationManager) this.mContext.getSystemService("notification"));
    public final Context mContext;

    /* renamed from: android.support.v4.app.y$a */
    static class C8379a implements C17434e {
        /* renamed from: FL */
        final boolean f2337FL = false;
        /* renamed from: id */
        final int f2338id;
        final String packageName;
        final String tag = null;

        C8379a(String str, int i) {
            this.packageName = str;
            this.f2338id = i;
        }

        /* renamed from: a */
        public final void mo18302a(C44957q c44957q) {
            if (this.f2337FL) {
                c44957q.mo42298J(this.packageName);
            } else {
                c44957q.mo42301b(this.packageName, this.f2338id, this.tag);
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.f2338id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append(", all:").append(this.f2337FL);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* renamed from: android.support.v4.app.y$b */
    public static class C8380b implements C17434e {
        /* renamed from: FM */
        final Notification f2339FM;
        /* renamed from: id */
        final int f2340id;
        final String packageName;
        final String tag = null;

        public C8380b(String str, int i, Notification notification) {
            this.packageName = str;
            this.f2340id = i;
            this.f2339FM = notification;
        }

        /* renamed from: a */
        public final void mo18302a(C44957q c44957q) {
            c44957q.mo42299a(this.packageName, this.f2340id, this.tag, this.f2339FM);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.f2340id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* renamed from: android.support.v4.app.y$d */
    static class C17430d implements ServiceConnection, Callback {
        /* renamed from: FO */
        private final Map<ComponentName, C17431a> f3882FO = new HashMap();
        /* renamed from: FP */
        private Set<String> f3883FP = new HashSet();
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;

        /* renamed from: android.support.v4.app.y$d$a */
        static class C17431a {
            /* renamed from: FQ */
            boolean f3884FQ = false;
            /* renamed from: FR */
            C44957q f3885FR;
            /* renamed from: FS */
            ArrayDeque<C17434e> f3886FS = new ArrayDeque();
            final ComponentName componentName;
            int retryCount = 0;

            C17431a(ComponentName componentName) {
                this.componentName = componentName;
            }
        }

        C17430d(Context context) {
            this.mContext = context;
            this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
        }

        /* renamed from: b */
        public final void mo31696b(C17434e c17434e) {
            this.mHandler.obtainMessage(0, c17434e).sendToTarget();
        }

        public final boolean handleMessage(Message message) {
            C17431a c17431a;
            switch (message.what) {
                case 0:
                    Iterator it;
                    C17434e c17434e = (C17434e) message.obj;
                    Set M = C17432y.m27075M(this.mContext);
                    if (!M.equals(this.f3883FP)) {
                        this.f3883FP = M;
                        List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                        HashSet<ComponentName> hashSet = new HashSet();
                        for (ResolveInfo resolveInfo : queryIntentServices) {
                            if (M.contains(resolveInfo.serviceInfo.packageName)) {
                                ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                                if (resolveInfo.serviceInfo.permission != null) {
                                    new StringBuilder("Permission present on component ").append(componentName).append(", not adding listener record.");
                                } else {
                                    hashSet.add(componentName);
                                }
                            }
                        }
                        for (ComponentName componentName2 : hashSet) {
                            if (!this.f3882FO.containsKey(componentName2)) {
                                if (Log.isLoggable("NotifManCompat", 3)) {
                                    new StringBuilder("Adding listener record for ").append(componentName2);
                                }
                                this.f3882FO.put(componentName2, new C17431a(componentName2));
                            }
                        }
                        it = this.f3882FO.entrySet().iterator();
                        while (it.hasNext()) {
                            Entry entry = (Entry) it.next();
                            if (!hashSet.contains(entry.getKey())) {
                                if (Log.isLoggable("NotifManCompat", 3)) {
                                    new StringBuilder("Removing listener record for ").append(entry.getKey());
                                }
                                m27070a((C17431a) entry.getValue());
                                it.remove();
                            }
                        }
                    }
                    for (C17431a c17431a2 : this.f3882FO.values()) {
                        c17431a2.f3886FS.add(c17434e);
                        m27072c(c17431a2);
                    }
                    return true;
                case 1:
                    C17433c c17433c = (C17433c) message.obj;
                    ComponentName componentName3 = c17433c.componentName;
                    IBinder iBinder = c17433c.f3892FN;
                    c17431a = (C17431a) this.f3882FO.get(componentName3);
                    if (c17431a != null) {
                        c17431a.f3885FR = C25333a.m39979b(iBinder);
                        c17431a.retryCount = 0;
                        m27072c(c17431a);
                    }
                    return true;
                case 2:
                    c17431a = (C17431a) this.f3882FO.get((ComponentName) message.obj);
                    if (c17431a != null) {
                        m27070a(c17431a);
                    }
                    return true;
                case 3:
                    c17431a = (C17431a) this.f3882FO.get((ComponentName) message.obj);
                    if (c17431a != null) {
                        m27072c(c17431a);
                    }
                    return true;
                default:
                    return false;
            }
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Connected to service ").append(componentName);
            }
            this.mHandler.obtainMessage(1, new C17433c(componentName, iBinder)).sendToTarget();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Disconnected from service ").append(componentName);
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        /* renamed from: a */
        private void m27070a(C17431a c17431a) {
            if (c17431a.f3884FQ) {
                this.mContext.unbindService(this);
                c17431a.f3884FQ = false;
            }
            c17431a.f3885FR = null;
        }

        /* renamed from: b */
        private void m27071b(C17431a c17431a) {
            if (!this.mHandler.hasMessages(3, c17431a.componentName)) {
                c17431a.retryCount++;
                if (c17431a.retryCount > 6) {
                    new StringBuilder("Giving up on delivering ").append(c17431a.f3886FS.size()).append(" tasks to ").append(c17431a.componentName).append(" after ").append(c17431a.retryCount).append(" retries");
                    c17431a.f3886FS.clear();
                    return;
                }
                int i = (1 << (c17431a.retryCount - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    new StringBuilder("Scheduling retry for ").append(i).append(" ms");
                }
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, c17431a.componentName), (long) i);
            }
        }

        /* renamed from: c */
        private void m27072c(C17431a c17431a) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Processing component ").append(c17431a.componentName).append(", ").append(c17431a.f3886FS.size()).append(" queued tasks");
            }
            if (!c17431a.f3886FS.isEmpty()) {
                boolean z;
                if (c17431a.f3884FQ) {
                    z = true;
                } else {
                    c17431a.f3884FQ = this.mContext.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(c17431a.componentName), this, 33);
                    if (c17431a.f3884FQ) {
                        c17431a.retryCount = 0;
                    } else {
                        new StringBuilder("Unable to bind to listener ").append(c17431a.componentName);
                        this.mContext.unbindService(this);
                    }
                    z = c17431a.f3884FQ;
                }
                if (!z || c17431a.f3885FR == null) {
                    m27071b(c17431a);
                    return;
                }
                while (true) {
                    C17434e c17434e = (C17434e) c17431a.f3886FS.peek();
                    if (c17434e == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            new StringBuilder("Sending task ").append(c17434e);
                        }
                        c17434e.mo18302a(c17431a.f3885FR);
                        c17431a.f3886FS.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            new StringBuilder("Remote service has died: ").append(c17431a.componentName);
                        }
                    } catch (RemoteException e2) {
                        new StringBuilder("RemoteException communicating with ").append(c17431a.componentName);
                    }
                }
                if (!c17431a.f3886FS.isEmpty()) {
                    m27071b(c17431a);
                }
            }
        }
    }

    /* renamed from: android.support.v4.app.y$c */
    static class C17433c {
        /* renamed from: FN */
        final IBinder f3892FN;
        final ComponentName componentName;

        C17433c(ComponentName componentName, IBinder iBinder) {
            this.componentName = componentName;
            this.f3892FN = iBinder;
        }
    }

    /* renamed from: android.support.v4.app.y$e */
    interface C17434e {
        /* renamed from: a */
        void mo18302a(C44957q c44957q);
    }

    /* renamed from: L */
    public static C17432y m27074L(Context context) {
        return new C17432y(context);
    }

    private C17432y(Context context) {
        this.mContext = context;
    }

    public final boolean areNotificationsEnabled() {
        if (VERSION.SDK_INT >= 24) {
            return this.f3891FJ.areNotificationsEnabled();
        }
        if (VERSION.SDK_INT < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService("appops");
        ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        String packageName = this.mContext.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            return ((Integer) Class.forName(AppOpsManager.class.getName()).getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) Class.forName(AppOpsManager.class.getName()).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName})).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException e) {
            return true;
        }
    }

    public final int getImportance() {
        if (VERSION.SDK_INT >= 24) {
            return this.f3891FJ.getImportance();
        }
        return -1000;
    }

    /* renamed from: M */
    public static Set<String> m27075M(Context context) {
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f3887FG) {
            if (string != null) {
                if (!string.equals(f3888FH)) {
                    String[] split = string.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    HashSet hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    f3889FI = hashSet;
                    f3888FH = string;
                }
            }
        }
        return f3889FI;
    }

    /* renamed from: a */
    public final void mo31700a(C17434e c17434e) {
        synchronized (sLock) {
            if (f3890FK == null) {
                f3890FK = new C17430d(this.mContext.getApplicationContext());
            }
            f3890FK.mo31696b(c17434e);
        }
    }

    public final void cancel(int i) {
        this.f3891FJ.cancel(null, i);
        if (VERSION.SDK_INT <= 19) {
            mo31700a(new C8379a(this.mContext.getPackageName(), i));
        }
    }
}
