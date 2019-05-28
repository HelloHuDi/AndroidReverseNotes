package com.tencent.p177mm.plugin.wepkg.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wepkg.ipc.C46473a.C46474a;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService */
public class WepkgMainProcessService extends Service {
    private static ServiceConnection huI;
    private static Map<Integer, WeakReference<WepkgMainProcessTask>> huK = new ConcurrentHashMap();
    private static Handler huL = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(63483);
            int i = message.what;
            WepkgMainProcessTask as = WepkgMainProcessService.m87658as(message.getData());
            WepkgMainProcessTask Kk = WepkgMainProcessService.m87652Kk(i);
            if (Kk == null) {
                C4990ab.m7413e("MicroMsg.Wepkg.WepkgMainProcessService", "receive client msg, get null task by id %s", Integer.valueOf(i));
                AppMethodBeat.m2505o(63483);
                return;
            }
            WepkgMainProcessService.m87659b(as, Kk);
            Kk.asQ();
            AppMethodBeat.m2505o(63483);
        }
    };
    private static Messenger huM = new Messenger(huL);
    private static C46473a uWG;
    private static final LinkedList<Message> uWH = new LinkedList();
    private final Messenger huF = new Messenger(this.mHandler);
    private final Handler mHandler = new Handler(C30022d.aNS().oAl.getLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(63480);
            WepkgMainProcessTask as = WepkgMainProcessService.m87658as(message.getData());
            Messenger messenger = message.replyTo;
            int i = message.what;
            as.hvF = messenger;
            as.mTaskId = i;
            as.asP();
            AppMethodBeat.m2505o(63480);
        }
    };
    private final C46474a uWF = new C232032();

    /* renamed from: com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService$2 */
    class C232032 extends C46474a {
        C232032() {
        }

        /* renamed from: r */
        public final void mo38825r(Message message) {
            AppMethodBeat.m2504i(63481);
            WepkgMainProcessService.this.huF.send(message);
            AppMethodBeat.m2505o(63481);
        }

        /* renamed from: x */
        public final void mo38826x(Bundle bundle) {
            AppMethodBeat.m2504i(63482);
            WepkgMainProcessService.m87658as(bundle).asP();
            AppMethodBeat.m2505o(63482);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService$4 */
    static class C440234 implements ServiceConnection {
        C440234() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(63484);
            WepkgMainProcessService.uWG = C46474a.m87666I(iBinder);
            WepkgMainProcessService.aLT();
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgMainProcessService", "onServiceConnected(%s)", C4996ah.getProcessName());
            AppMethodBeat.m2505o(63484);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(63485);
            WepkgMainProcessService.uWG = null;
            WepkgMainProcessService.access$600();
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgMainProcessService", "onServiceDisconnected(%s)", C4996ah.getProcessName());
            AppMethodBeat.m2505o(63485);
        }
    }

    public WepkgMainProcessService() {
        AppMethodBeat.m2504i(63486);
        AppMethodBeat.m2505o(63486);
    }

    static /* synthetic */ void access$600() {
        AppMethodBeat.m2504i(63499);
        WepkgMainProcessService.aBM();
        AppMethodBeat.m2505o(63499);
    }

    /* renamed from: as */
    static /* synthetic */ WepkgMainProcessTask m87658as(Bundle bundle) {
        AppMethodBeat.m2504i(63495);
        WepkgMainProcessTask ar = WepkgMainProcessService.m87657ar(bundle);
        AppMethodBeat.m2505o(63495);
        return ar;
    }

    /* renamed from: b */
    static /* synthetic */ void m87659b(WepkgMainProcessTask wepkgMainProcessTask, WepkgMainProcessTask wepkgMainProcessTask2) {
        AppMethodBeat.m2504i(63497);
        WepkgMainProcessService.m87656a(wepkgMainProcessTask, wepkgMainProcessTask2);
        AppMethodBeat.m2505o(63497);
    }

    public IBinder onBind(Intent intent) {
        return this.uWF;
    }

    static {
        AppMethodBeat.m2504i(63500);
        AppMethodBeat.m2505o(63500);
    }

    /* renamed from: b */
    public static boolean m87660b(WepkgMainProcessTask wepkgMainProcessTask) {
        AppMethodBeat.m2504i(63488);
        Bundle c = WepkgMainProcessService.m87661c(wepkgMainProcessTask);
        if (WepkgMainProcessService.m87663t(c)) {
            WepkgMainProcessService.m87656a(WepkgMainProcessService.m87657ar(c), wepkgMainProcessTask);
            wepkgMainProcessTask.asQ();
            AppMethodBeat.m2505o(63488);
            return true;
        }
        AppMethodBeat.m2505o(63488);
        return false;
    }

    /* renamed from: t */
    private static boolean m87663t(Bundle bundle) {
        AppMethodBeat.m2504i(63489);
        boolean z = true;
        if (uWG == null) {
            WepkgMainProcessService.aBM();
            AppMethodBeat.m2505o(63489);
            return false;
        }
        try {
            uWG.mo38826x(bundle);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.Wepkg.WepkgMainProcessService", e.getMessage());
            z = false;
        }
        AppMethodBeat.m2505o(63489);
        return z;
    }

    /* renamed from: s */
    private static void m87662s(Message message) {
        AppMethodBeat.m2504i(63490);
        message.replyTo = huM;
        if (uWG == null) {
            WepkgMainProcessService.aBM();
            synchronized (uWH) {
                try {
                    uWH.add(message);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(63490);
                }
            }
            return;
        }
        try {
            uWG.mo38825r(message);
            AppMethodBeat.m2505o(63490);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.Wepkg.WepkgMainProcessService", e.getMessage());
            AppMethodBeat.m2505o(63490);
        }
    }

    private static void aBM() {
        AppMethodBeat.m2504i(63491);
        if (huI == null) {
            huI = new C440234();
        }
        C4990ab.m7416i("MicroMsg.Wepkg.WepkgMainProcessService", "tryBindService");
        Context context = C4996ah.getContext();
        try {
            context.bindService(new Intent(context, WepkgMainProcessService.class), huI, 1);
            AppMethodBeat.m2505o(63491);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Wepkg.WepkgMainProcessService", "tryBind() Exception:%s", e.getMessage());
            AppMethodBeat.m2505o(63491);
        }
    }

    public static boolean isLive() {
        if (uWG != null) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    static Bundle m87661c(WepkgMainProcessTask wepkgMainProcessTask) {
        AppMethodBeat.m2504i(63492);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("task_object", wepkgMainProcessTask);
        AppMethodBeat.m2505o(63492);
        return bundle;
    }

    /* renamed from: ar */
    private static WepkgMainProcessTask m87657ar(Bundle bundle) {
        AppMethodBeat.m2504i(63493);
        bundle.setClassLoader(WepkgMainProcessTask.class.getClassLoader());
        WepkgMainProcessTask wepkgMainProcessTask = (WepkgMainProcessTask) bundle.getParcelable("task_object");
        AppMethodBeat.m2505o(63493);
        return wepkgMainProcessTask;
    }

    /* renamed from: a */
    private static void m87656a(WepkgMainProcessTask wepkgMainProcessTask, WepkgMainProcessTask wepkgMainProcessTask2) {
        AppMethodBeat.m2504i(63494);
        Parcel obtain = Parcel.obtain();
        wepkgMainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        wepkgMainProcessTask2.mo48259g(obtain);
        obtain.recycle();
        AppMethodBeat.m2505o(63494);
    }

    /* renamed from: a */
    public static void m87655a(WepkgMainProcessTask wepkgMainProcessTask) {
        AppMethodBeat.m2504i(63487);
        huK.put(Integer.valueOf(wepkgMainProcessTask.hashCode()), new WeakReference(wepkgMainProcessTask));
        Message obtain = Message.obtain();
        obtain.what = wepkgMainProcessTask.hashCode();
        obtain.replyTo = huM;
        obtain.setData(WepkgMainProcessService.m87661c(wepkgMainProcessTask));
        WepkgMainProcessService.m87662s(obtain);
        AppMethodBeat.m2505o(63487);
    }

    /* renamed from: Kk */
    static /* synthetic */ WepkgMainProcessTask m87652Kk(int i) {
        AppMethodBeat.m2504i(63496);
        if (!huK.containsKey(Integer.valueOf(i))) {
            AppMethodBeat.m2505o(63496);
            return null;
        } else if (((WeakReference) huK.get(Integer.valueOf(i))).get() == null) {
            AppMethodBeat.m2505o(63496);
            return null;
        } else {
            WepkgMainProcessTask wepkgMainProcessTask = (WepkgMainProcessTask) ((WeakReference) huK.get(Integer.valueOf(i))).get();
            AppMethodBeat.m2505o(63496);
            return wepkgMainProcessTask;
        }
    }

    static /* synthetic */ void aLT() {
        AppMethodBeat.m2504i(63498);
        if (uWG != null) {
            synchronized (uWH) {
                try {
                    Iterator it = uWH.iterator();
                    while (it.hasNext()) {
                        WepkgMainProcessService.m87662s((Message) it.next());
                    }
                    uWH.clear();
                } finally {
                    AppMethodBeat.m2505o(63498);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(63498);
    }
}
