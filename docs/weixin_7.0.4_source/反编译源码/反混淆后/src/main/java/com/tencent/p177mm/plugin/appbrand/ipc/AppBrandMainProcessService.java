package com.tencent.p177mm.plugin.appbrand.ipc;

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
import com.tencent.p177mm.plugin.appbrand.ipc.C26908c.C10274a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService */
public class AppBrandMainProcessService extends Service {
    private static C26908c huH;
    private static ServiceConnection huI;
    private static final LinkedList<Parcel> huJ = new LinkedList();
    private static Map<String, WeakReference<MainProcessTask>> huK = new ConcurrentHashMap();
    private static final Handler huL = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(90985);
            MainProcessTask b = AppBrandMainProcessService.m54351b(message.getData(), false);
            if (b == null) {
                AppMethodBeat.m2505o(90985);
                return;
            }
            MainProcessTask AE = AppBrandMainProcessService.m54343AE(b.hvr);
            if (AE == null) {
                C4990ab.m7413e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", b.hvr);
                AppMethodBeat.m2505o(90985);
                return;
            }
            AppBrandMainProcessService.m54354b(b, AE);
            AE.asQ();
            AppMethodBeat.m2505o(90985);
        }
    };
    private static Messenger huM = new Messenger(huL);
    private static final Set<C2172a> huN = Collections.newSetFromMap(new ConcurrentHashMap());
    private final HashMap<String, DeathRecipient> huE = new HashMap();
    private final Messenger huF = new Messenger(this.mHandler);
    private final C10274a huG = new C332162();
    private final Handler mHandler = new Handler(C45673m.aNS().oAl.getLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(90980);
            MainProcessTask b = AppBrandMainProcessService.m54351b(message.getData(), true);
            if (b != null) {
                b.asP();
            }
            AppMethodBeat.m2505o(90980);
        }
    };

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService$a */
    public static class C2172a {
        public void ats() {
        }

        public void att() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService$2 */
    class C332162 extends C10274a {
        C332162() {
        }

        /* renamed from: w */
        public final void mo21721w(Bundle bundle) {
            AppMethodBeat.m2504i(90982);
            Message obtain = Message.obtain();
            obtain.setData(bundle);
            AppBrandMainProcessService.this.huF.send(obtain);
            AppMethodBeat.m2505o(90982);
        }

        /* renamed from: x */
        public final void mo21722x(Bundle bundle) {
            AppMethodBeat.m2504i(90983);
            MainProcessTask b = AppBrandMainProcessService.m54351b(bundle, false);
            if (b != null) {
                b.asP();
            }
            AppMethodBeat.m2505o(90983);
        }

        /* renamed from: a */
        public final void mo21719a(final IBinder iBinder, final String str) {
            AppMethodBeat.m2504i(90984);
            C332171 c332171 = new DeathRecipient() {
                public final void binderDied() {
                    AppMethodBeat.m2504i(90981);
                    DeathRecipient deathRecipient = (DeathRecipient) AppBrandMainProcessService.this.huE.get(str);
                    if (deathRecipient == null) {
                        AppMethodBeat.m2505o(90981);
                        return;
                    }
                    iBinder.unlinkToDeath(deathRecipient, 0);
                    AppBrandMainProcessService.this.huE.remove(str);
                    AppBrandMainProcessService.aBN();
                    C4990ab.m7413e("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", str);
                    AppMethodBeat.m2505o(90981);
                }
            };
            try {
                iBinder.linkToDeath(c332171, 0);
                AppBrandMainProcessService.this.huE.put(str, c332171);
                AppBrandMainProcessService.aBO();
                AppMethodBeat.m2505o(90984);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrandMainProcessService", "registerDeathRecipient: %s", e);
                AppMethodBeat.m2505o(90984);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService$4 */
    static class C332184 implements ServiceConnection {
        C332184() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(90986);
            AppBrandMainProcessService.huH = C10274a.m17927r(iBinder);
            AppBrandMainProcessService.access$800();
            C4996ah.getPackageName();
            AppBrandMainProcessService.aBO();
            try {
                AppBrandMainProcessService.huH.mo21719a(new Binder(), C4996ah.getProcessName());
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrandMainProcessService", "onServiceConnected, registerDeathRecipient, %s", e);
            }
            C4990ab.m7417i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", C4996ah.getProcessName());
            AppMethodBeat.m2505o(90986);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(90987);
            AppBrandMainProcessService.huH = null;
            C4996ah.getPackageName();
            AppBrandMainProcessService.aBN();
            AppBrandMainProcessService.aBM();
            C4990ab.m7417i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", C4996ah.getProcessName());
            AppMethodBeat.m2505o(90987);
        }
    }

    public AppBrandMainProcessService() {
        AppMethodBeat.m2504i(90988);
        AppMethodBeat.m2505o(90988);
    }

    public IBinder onBind(Intent intent) {
        return this.huG;
    }

    static {
        AppMethodBeat.m2504i(91006);
        AppMethodBeat.m2505o(91006);
    }

    /* renamed from: b */
    public static boolean m54355b(MainProcessTask mainProcessTask) {
        AppMethodBeat.m2504i(90990);
        Bundle a = AppBrandMainProcessService.m54344a(mainProcessTask, false);
        if (AppBrandMainProcessService.m54356t(a)) {
            try {
                AppBrandMainProcessService.m54350a(AppBrandMainProcessService.m54346a(a, false), mainProcessTask);
                mainProcessTask.asQ();
                AppMethodBeat.m2505o(90990);
                return true;
            } catch (NullPointerException e) {
                AppMethodBeat.m2505o(90990);
                return false;
            }
        }
        AppMethodBeat.m2505o(90990);
        return false;
    }

    /* renamed from: t */
    private static boolean m54356t(Bundle bundle) {
        AppMethodBeat.m2504i(90991);
        boolean z = true;
        try {
            huH.mo21722x(bundle);
        } catch (Exception e) {
            Exception exception = e;
            z = false;
            C4990ab.m7412e("MicroMsg.AppBrandMainProcessService", exception.getMessage());
        }
        AppMethodBeat.m2505o(90991);
        return z;
    }

    /* renamed from: u */
    private static void m54357u(Bundle bundle) {
        AppMethodBeat.m2504i(90992);
        if (huH == null) {
            AppBrandMainProcessService.aBM();
            synchronized (huJ) {
                try {
                    huJ.add(AppBrandMainProcessService.m54358v(bundle));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(90992);
                }
            }
            return;
        }
        try {
            huH.mo21721w(bundle);
            AppMethodBeat.m2505o(90992);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.AppBrandMainProcessService", e.getMessage());
            AppMethodBeat.m2505o(90992);
        }
    }

    public static void aBM() {
        AppMethodBeat.m2504i(90993);
        if (huI == null) {
            huI = new C332184();
        }
        C4990ab.m7416i("MicroMsg.AppBrandMainProcessService", "tryBindService");
        Context context = C4996ah.getContext();
        try {
            context.bindService(new Intent(context, AppBrandMainProcessService.class), huI, 1);
            AppMethodBeat.m2505o(90993);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandMainProcessService", "bindService() Exception:%s", e.getMessage());
            AppMethodBeat.m2505o(90993);
        }
    }

    /* renamed from: a */
    public static void m54348a(C2172a c2172a) {
        AppMethodBeat.m2504i(90994);
        huN.add(c2172a);
        AppMethodBeat.m2505o(90994);
    }

    /* renamed from: b */
    public static void m54353b(C2172a c2172a) {
        AppMethodBeat.m2504i(90995);
        huN.remove(c2172a);
        AppMethodBeat.m2505o(90995);
    }

    /* renamed from: a */
    private static void m54350a(MainProcessTask mainProcessTask, MainProcessTask mainProcessTask2) {
        AppMethodBeat.m2504i(90996);
        Parcel obtain = Parcel.obtain();
        mainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        mainProcessTask2.mo6032g(obtain);
        obtain.recycle();
        AppMethodBeat.m2505o(90996);
    }

    /* renamed from: v */
    private static Parcel m54358v(Bundle bundle) {
        AppMethodBeat.m2504i(90997);
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        AppMethodBeat.m2505o(90997);
        return obtain;
    }

    /* renamed from: a */
    static Bundle m54344a(MainProcessTask mainProcessTask, boolean z) {
        AppMethodBeat.m2504i(90998);
        Bundle bundle = new Bundle(3);
        bundle.putParcelable("task_object", mainProcessTask);
        if (z) {
            bundle.putParcelable("task_client", huM);
        }
        bundle.putString("task_id", mainProcessTask.hvr);
        AppMethodBeat.m2505o(90998);
        return bundle;
    }

    /* renamed from: a */
    private static MainProcessTask m54346a(Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(90999);
        bundle.setClassLoader(MainProcessTask.class.getClassLoader());
        MainProcessTask mainProcessTask = (MainProcessTask) bundle.getParcelable("task_object");
        if (mainProcessTask == null) {
            AppMethodBeat.m2505o(90999);
            return null;
        }
        if (z) {
            mainProcessTask.hvF = (Messenger) bundle.getParcelable("task_client");
        }
        mainProcessTask.hvr = bundle.getString("task_id");
        AppMethodBeat.m2505o(90999);
        return mainProcessTask;
    }

    /* renamed from: a */
    public static void m54349a(MainProcessTask mainProcessTask) {
        AppMethodBeat.m2504i(90989);
        huK.put(mainProcessTask.hvr, new WeakReference(mainProcessTask));
        AppBrandMainProcessService.m54357u(AppBrandMainProcessService.m54344a(mainProcessTask, true));
        AppMethodBeat.m2505o(90989);
    }

    static /* synthetic */ void aBN() {
        AppMethodBeat.m2504i(91001);
        for (C2172a att : huN) {
            att.att();
        }
        AppMethodBeat.m2505o(91001);
    }

    static /* synthetic */ void aBO() {
        AppMethodBeat.m2504i(91002);
        for (C2172a ats : huN) {
            ats.ats();
        }
        AppMethodBeat.m2505o(91002);
    }

    /* renamed from: AE */
    static /* synthetic */ MainProcessTask m54343AE(String str) {
        AppMethodBeat.m2504i(91003);
        WeakReference weakReference = (WeakReference) huK.get(str);
        if (weakReference == null) {
            AppMethodBeat.m2505o(91003);
            return null;
        }
        MainProcessTask mainProcessTask = (MainProcessTask) weakReference.get();
        AppMethodBeat.m2505o(91003);
        return mainProcessTask;
    }

    static /* synthetic */ void access$800() {
        AppMethodBeat.m2504i(91005);
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
                        AppBrandMainProcessService.m54357u(bundle);
                        parcel.recycle();
                    }
                    huJ.clear();
                } finally {
                    AppMethodBeat.m2505o(91005);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(91005);
    }
}
