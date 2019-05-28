package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandMainProcessService extends Service {
    private static c huH;
    private static ServiceConnection huI;
    private static final LinkedList<Parcel> huJ = new LinkedList();
    private static Map<String, WeakReference<MainProcessTask>> huK = new ConcurrentHashMap();
    private static final Handler huL = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(90985);
            MainProcessTask b = AppBrandMainProcessService.b(message.getData(), false);
            if (b == null) {
                AppMethodBeat.o(90985);
                return;
            }
            MainProcessTask AE = AppBrandMainProcessService.AE(b.hvr);
            if (AE == null) {
                ab.e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", b.hvr);
                AppMethodBeat.o(90985);
                return;
            }
            AppBrandMainProcessService.b(b, AE);
            AE.asQ();
            AppMethodBeat.o(90985);
        }
    };
    private static Messenger huM = new Messenger(huL);
    private static final Set<a> huN = Collections.newSetFromMap(new ConcurrentHashMap());
    private final HashMap<String, DeathRecipient> huE = new HashMap();
    private final Messenger huF = new Messenger(this.mHandler);
    private final com.tencent.mm.plugin.appbrand.ipc.c.a huG = new com.tencent.mm.plugin.appbrand.ipc.c.a() {
        public final void w(Bundle bundle) {
            AppMethodBeat.i(90982);
            Message obtain = Message.obtain();
            obtain.setData(bundle);
            AppBrandMainProcessService.this.huF.send(obtain);
            AppMethodBeat.o(90982);
        }

        public final void x(Bundle bundle) {
            AppMethodBeat.i(90983);
            MainProcessTask b = AppBrandMainProcessService.b(bundle, false);
            if (b != null) {
                b.asP();
            }
            AppMethodBeat.o(90983);
        }

        public final void a(final IBinder iBinder, final String str) {
            AppMethodBeat.i(90984);
            AnonymousClass1 anonymousClass1 = new DeathRecipient() {
                public final void binderDied() {
                    AppMethodBeat.i(90981);
                    DeathRecipient deathRecipient = (DeathRecipient) AppBrandMainProcessService.this.huE.get(str);
                    if (deathRecipient == null) {
                        AppMethodBeat.o(90981);
                        return;
                    }
                    iBinder.unlinkToDeath(deathRecipient, 0);
                    AppBrandMainProcessService.this.huE.remove(str);
                    AppBrandMainProcessService.aBN();
                    ab.e("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", str);
                    AppMethodBeat.o(90981);
                }
            };
            try {
                iBinder.linkToDeath(anonymousClass1, 0);
                AppBrandMainProcessService.this.huE.put(str, anonymousClass1);
                AppBrandMainProcessService.aBO();
                AppMethodBeat.o(90984);
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrandMainProcessService", "registerDeathRecipient: %s", e);
                AppMethodBeat.o(90984);
            }
        }
    };
    private final Handler mHandler = new Handler(m.aNS().oAl.getLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(90980);
            MainProcessTask b = AppBrandMainProcessService.b(message.getData(), true);
            if (b != null) {
                b.asP();
            }
            AppMethodBeat.o(90980);
        }
    };

    public static class a {
        public void ats() {
        }

        public void att() {
        }
    }

    public AppBrandMainProcessService() {
        AppMethodBeat.i(90988);
        AppMethodBeat.o(90988);
    }

    public IBinder onBind(Intent intent) {
        return this.huG;
    }

    static {
        AppMethodBeat.i(91006);
        AppMethodBeat.o(91006);
    }

    public static boolean b(MainProcessTask mainProcessTask) {
        AppMethodBeat.i(90990);
        Bundle a = a(mainProcessTask, false);
        if (t(a)) {
            try {
                a(a(a, false), mainProcessTask);
                mainProcessTask.asQ();
                AppMethodBeat.o(90990);
                return true;
            } catch (NullPointerException e) {
                AppMethodBeat.o(90990);
                return false;
            }
        }
        AppMethodBeat.o(90990);
        return false;
    }

    private static boolean t(Bundle bundle) {
        AppMethodBeat.i(90991);
        boolean z = true;
        try {
            huH.x(bundle);
        } catch (Exception e) {
            Exception exception = e;
            z = false;
            ab.e("MicroMsg.AppBrandMainProcessService", exception.getMessage());
        }
        AppMethodBeat.o(90991);
        return z;
    }

    private static void u(Bundle bundle) {
        AppMethodBeat.i(90992);
        if (huH == null) {
            aBM();
            synchronized (huJ) {
                try {
                    huJ.add(v(bundle));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(90992);
                }
            }
            return;
        }
        try {
            huH.w(bundle);
            AppMethodBeat.o(90992);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandMainProcessService", e.getMessage());
            AppMethodBeat.o(90992);
        }
    }

    public static void aBM() {
        AppMethodBeat.i(90993);
        if (huI == null) {
            huI = new ServiceConnection() {
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    AppMethodBeat.i(90986);
                    AppBrandMainProcessService.huH = com.tencent.mm.plugin.appbrand.ipc.c.a.r(iBinder);
                    AppBrandMainProcessService.access$800();
                    ah.getPackageName();
                    AppBrandMainProcessService.aBO();
                    try {
                        AppBrandMainProcessService.huH.a(new Binder(), ah.getProcessName());
                    } catch (Exception e) {
                        ab.e("MicroMsg.AppBrandMainProcessService", "onServiceConnected, registerDeathRecipient, %s", e);
                    }
                    ab.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", ah.getProcessName());
                    AppMethodBeat.o(90986);
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                    AppMethodBeat.i(90987);
                    AppBrandMainProcessService.huH = null;
                    ah.getPackageName();
                    AppBrandMainProcessService.aBN();
                    AppBrandMainProcessService.aBM();
                    ab.i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", ah.getProcessName());
                    AppMethodBeat.o(90987);
                }
            };
        }
        ab.i("MicroMsg.AppBrandMainProcessService", "tryBindService");
        Context context = ah.getContext();
        try {
            context.bindService(new Intent(context, AppBrandMainProcessService.class), huI, 1);
            AppMethodBeat.o(90993);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandMainProcessService", "bindService() Exception:%s", e.getMessage());
            AppMethodBeat.o(90993);
        }
    }

    public static void a(a aVar) {
        AppMethodBeat.i(90994);
        huN.add(aVar);
        AppMethodBeat.o(90994);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(90995);
        huN.remove(aVar);
        AppMethodBeat.o(90995);
    }

    private static void a(MainProcessTask mainProcessTask, MainProcessTask mainProcessTask2) {
        AppMethodBeat.i(90996);
        Parcel obtain = Parcel.obtain();
        mainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        mainProcessTask2.g(obtain);
        obtain.recycle();
        AppMethodBeat.o(90996);
    }

    private static Parcel v(Bundle bundle) {
        AppMethodBeat.i(90997);
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        AppMethodBeat.o(90997);
        return obtain;
    }

    static Bundle a(MainProcessTask mainProcessTask, boolean z) {
        AppMethodBeat.i(90998);
        Bundle bundle = new Bundle(3);
        bundle.putParcelable("task_object", mainProcessTask);
        if (z) {
            bundle.putParcelable("task_client", huM);
        }
        bundle.putString("task_id", mainProcessTask.hvr);
        AppMethodBeat.o(90998);
        return bundle;
    }

    private static MainProcessTask a(Bundle bundle, boolean z) {
        AppMethodBeat.i(90999);
        bundle.setClassLoader(MainProcessTask.class.getClassLoader());
        MainProcessTask mainProcessTask = (MainProcessTask) bundle.getParcelable("task_object");
        if (mainProcessTask == null) {
            AppMethodBeat.o(90999);
            return null;
        }
        if (z) {
            mainProcessTask.hvF = (Messenger) bundle.getParcelable("task_client");
        }
        mainProcessTask.hvr = bundle.getString("task_id");
        AppMethodBeat.o(90999);
        return mainProcessTask;
    }

    public static void a(MainProcessTask mainProcessTask) {
        AppMethodBeat.i(90989);
        huK.put(mainProcessTask.hvr, new WeakReference(mainProcessTask));
        u(a(mainProcessTask, true));
        AppMethodBeat.o(90989);
    }

    static /* synthetic */ void aBN() {
        AppMethodBeat.i(91001);
        for (a att : huN) {
            att.att();
        }
        AppMethodBeat.o(91001);
    }

    static /* synthetic */ void aBO() {
        AppMethodBeat.i(91002);
        for (a ats : huN) {
            ats.ats();
        }
        AppMethodBeat.o(91002);
    }

    static /* synthetic */ MainProcessTask AE(String str) {
        AppMethodBeat.i(91003);
        WeakReference weakReference = (WeakReference) huK.get(str);
        if (weakReference == null) {
            AppMethodBeat.o(91003);
            return null;
        }
        MainProcessTask mainProcessTask = (MainProcessTask) weakReference.get();
        AppMethodBeat.o(91003);
        return mainProcessTask;
    }

    static /* synthetic */ void access$800() {
        AppMethodBeat.i(91005);
        if (huH != null) {
            synchronized (huJ) {
                try {
                    Iterator it = huJ.iterator();
                    while (it.hasNext()) {
                        Parcel parcel = (Parcel) it.next();
                        Bundle bundle = new Bundle();
                        bundle.setClassLoader(MainProcessTask.class.getClassLoader());
                        parcel.setDataPosition(0);
                        bundle.readFromParcel(parcel);
                        u(bundle);
                        parcel.recycle();
                    }
                    huJ.clear();
                } finally {
                    AppMethodBeat.o(91005);
                }
            }
            return;
        }
        AppMethodBeat.o(91005);
    }
}
