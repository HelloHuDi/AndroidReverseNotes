package android.support.v4.app;

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

public final class y {
    private static final Object FG = new Object();
    private static String FH;
    private static Set<String> FI = new HashSet();
    private static d FK;
    private static final Object sLock = new Object();
    public final NotificationManager FJ = ((NotificationManager) this.mContext.getSystemService("notification"));
    public final Context mContext;

    static class a implements e {
        final boolean FL = false;
        final int id;
        final String packageName;
        final String tag = null;

        a(String str, int i) {
            this.packageName = str;
            this.id = i;
        }

        public final void a(q qVar) {
            if (this.FL) {
                qVar.J(this.packageName);
            } else {
                qVar.b(this.packageName, this.id, this.tag);
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append(", all:").append(this.FL);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static class b implements e {
        final Notification FM;
        final int id;
        final String packageName;
        final String tag = null;

        public b(String str, int i, Notification notification) {
            this.packageName = str;
            this.id = i;
            this.FM = notification;
        }

        public final void a(q qVar) {
            qVar.a(this.packageName, this.id, this.tag, this.FM);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    static class d implements ServiceConnection, Callback {
        private final Map<ComponentName, a> FO = new HashMap();
        private Set<String> FP = new HashSet();
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;

        static class a {
            boolean FQ = false;
            q FR;
            ArrayDeque<e> FS = new ArrayDeque();
            final ComponentName componentName;
            int retryCount = 0;

            a(ComponentName componentName) {
                this.componentName = componentName;
            }
        }

        d(Context context) {
            this.mContext = context;
            this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
        }

        public final void b(e eVar) {
            this.mHandler.obtainMessage(0, eVar).sendToTarget();
        }

        public final boolean handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 0:
                    Iterator it;
                    e eVar = (e) message.obj;
                    Set M = y.M(this.mContext);
                    if (!M.equals(this.FP)) {
                        this.FP = M;
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
                            if (!this.FO.containsKey(componentName2)) {
                                if (Log.isLoggable("NotifManCompat", 3)) {
                                    new StringBuilder("Adding listener record for ").append(componentName2);
                                }
                                this.FO.put(componentName2, new a(componentName2));
                            }
                        }
                        it = this.FO.entrySet().iterator();
                        while (it.hasNext()) {
                            Entry entry = (Entry) it.next();
                            if (!hashSet.contains(entry.getKey())) {
                                if (Log.isLoggable("NotifManCompat", 3)) {
                                    new StringBuilder("Removing listener record for ").append(entry.getKey());
                                }
                                a((a) entry.getValue());
                                it.remove();
                            }
                        }
                    }
                    for (a aVar2 : this.FO.values()) {
                        aVar2.FS.add(eVar);
                        c(aVar2);
                    }
                    return true;
                case 1:
                    c cVar = (c) message.obj;
                    ComponentName componentName3 = cVar.componentName;
                    IBinder iBinder = cVar.FN;
                    aVar = (a) this.FO.get(componentName3);
                    if (aVar != null) {
                        aVar.FR = android.support.v4.app.q.a.b(iBinder);
                        aVar.retryCount = 0;
                        c(aVar);
                    }
                    return true;
                case 2:
                    aVar = (a) this.FO.get((ComponentName) message.obj);
                    if (aVar != null) {
                        a(aVar);
                    }
                    return true;
                case 3:
                    aVar = (a) this.FO.get((ComponentName) message.obj);
                    if (aVar != null) {
                        c(aVar);
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
            this.mHandler.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Disconnected from service ").append(componentName);
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        private void a(a aVar) {
            if (aVar.FQ) {
                this.mContext.unbindService(this);
                aVar.FQ = false;
            }
            aVar.FR = null;
        }

        private void b(a aVar) {
            if (!this.mHandler.hasMessages(3, aVar.componentName)) {
                aVar.retryCount++;
                if (aVar.retryCount > 6) {
                    new StringBuilder("Giving up on delivering ").append(aVar.FS.size()).append(" tasks to ").append(aVar.componentName).append(" after ").append(aVar.retryCount).append(" retries");
                    aVar.FS.clear();
                    return;
                }
                int i = (1 << (aVar.retryCount - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    new StringBuilder("Scheduling retry for ").append(i).append(" ms");
                }
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, aVar.componentName), (long) i);
            }
        }

        private void c(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Processing component ").append(aVar.componentName).append(", ").append(aVar.FS.size()).append(" queued tasks");
            }
            if (!aVar.FS.isEmpty()) {
                boolean z;
                if (aVar.FQ) {
                    z = true;
                } else {
                    aVar.FQ = this.mContext.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.componentName), this, 33);
                    if (aVar.FQ) {
                        aVar.retryCount = 0;
                    } else {
                        new StringBuilder("Unable to bind to listener ").append(aVar.componentName);
                        this.mContext.unbindService(this);
                    }
                    z = aVar.FQ;
                }
                if (!z || aVar.FR == null) {
                    b(aVar);
                    return;
                }
                while (true) {
                    e eVar = (e) aVar.FS.peek();
                    if (eVar == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            new StringBuilder("Sending task ").append(eVar);
                        }
                        eVar.a(aVar.FR);
                        aVar.FS.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            new StringBuilder("Remote service has died: ").append(aVar.componentName);
                        }
                    } catch (RemoteException e2) {
                        new StringBuilder("RemoteException communicating with ").append(aVar.componentName);
                    }
                }
                if (!aVar.FS.isEmpty()) {
                    b(aVar);
                }
            }
        }
    }

    static class c {
        final IBinder FN;
        final ComponentName componentName;

        c(ComponentName componentName, IBinder iBinder) {
            this.componentName = componentName;
            this.FN = iBinder;
        }
    }

    interface e {
        void a(q qVar);
    }

    public static y L(Context context) {
        return new y(context);
    }

    private y(Context context) {
        this.mContext = context;
    }

    public final boolean areNotificationsEnabled() {
        if (VERSION.SDK_INT >= 24) {
            return this.FJ.areNotificationsEnabled();
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
            return this.FJ.getImportance();
        }
        return -1000;
    }

    public static Set<String> M(Context context) {
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (FG) {
            if (string != null) {
                if (!string.equals(FH)) {
                    String[] split = string.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    HashSet hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    FI = hashSet;
                    FH = string;
                }
            }
        }
        return FI;
    }

    public final void a(e eVar) {
        synchronized (sLock) {
            if (FK == null) {
                FK = new d(this.mContext.getApplicationContext());
            }
            FK.b(eVar);
        }
    }

    public final void cancel(int i) {
        this.FJ.cancel(null, i);
        if (VERSION.SDK_INT <= 19) {
            a(new a(this.mContext.getPackageName(), i));
        }
    }
}
