package com.tencent.mm.plugin.wepkg.ipc;

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
import com.tencent.mm.plugin.wepkg.ipc.a.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WepkgMainProcessService extends Service {
    private static ServiceConnection huI;
    private static Map<Integer, WeakReference<WepkgMainProcessTask>> huK = new ConcurrentHashMap();
    private static Handler huL = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(63483);
            int i = message.what;
            WepkgMainProcessTask as = WepkgMainProcessService.as(message.getData());
            WepkgMainProcessTask Kk = WepkgMainProcessService.Kk(i);
            if (Kk == null) {
                ab.e("MicroMsg.Wepkg.WepkgMainProcessService", "receive client msg, get null task by id %s", Integer.valueOf(i));
                AppMethodBeat.o(63483);
                return;
            }
            WepkgMainProcessService.b(as, Kk);
            Kk.asQ();
            AppMethodBeat.o(63483);
        }
    };
    private static Messenger huM = new Messenger(huL);
    private static a uWG;
    private static final LinkedList<Message> uWH = new LinkedList();
    private final Messenger huF = new Messenger(this.mHandler);
    private final Handler mHandler = new Handler(d.aNS().oAl.getLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(63480);
            WepkgMainProcessTask as = WepkgMainProcessService.as(message.getData());
            Messenger messenger = message.replyTo;
            int i = message.what;
            as.hvF = messenger;
            as.mTaskId = i;
            as.asP();
            AppMethodBeat.o(63480);
        }
    };
    private final a uWF = new a() {
        public final void r(Message message) {
            AppMethodBeat.i(63481);
            WepkgMainProcessService.this.huF.send(message);
            AppMethodBeat.o(63481);
        }

        public final void x(Bundle bundle) {
            AppMethodBeat.i(63482);
            WepkgMainProcessService.as(bundle).asP();
            AppMethodBeat.o(63482);
        }
    };

    public WepkgMainProcessService() {
        AppMethodBeat.i(63486);
        AppMethodBeat.o(63486);
    }

    static /* synthetic */ void access$600() {
        AppMethodBeat.i(63499);
        aBM();
        AppMethodBeat.o(63499);
    }

    static /* synthetic */ WepkgMainProcessTask as(Bundle bundle) {
        AppMethodBeat.i(63495);
        WepkgMainProcessTask ar = ar(bundle);
        AppMethodBeat.o(63495);
        return ar;
    }

    static /* synthetic */ void b(WepkgMainProcessTask wepkgMainProcessTask, WepkgMainProcessTask wepkgMainProcessTask2) {
        AppMethodBeat.i(63497);
        a(wepkgMainProcessTask, wepkgMainProcessTask2);
        AppMethodBeat.o(63497);
    }

    public IBinder onBind(Intent intent) {
        return this.uWF;
    }

    static {
        AppMethodBeat.i(63500);
        AppMethodBeat.o(63500);
    }

    public static boolean b(WepkgMainProcessTask wepkgMainProcessTask) {
        AppMethodBeat.i(63488);
        Bundle c = c(wepkgMainProcessTask);
        if (t(c)) {
            a(ar(c), wepkgMainProcessTask);
            wepkgMainProcessTask.asQ();
            AppMethodBeat.o(63488);
            return true;
        }
        AppMethodBeat.o(63488);
        return false;
    }

    private static boolean t(Bundle bundle) {
        AppMethodBeat.i(63489);
        boolean z = true;
        if (uWG == null) {
            aBM();
            AppMethodBeat.o(63489);
            return false;
        }
        try {
            uWG.x(bundle);
        } catch (Exception e) {
            ab.e("MicroMsg.Wepkg.WepkgMainProcessService", e.getMessage());
            z = false;
        }
        AppMethodBeat.o(63489);
        return z;
    }

    private static void s(Message message) {
        AppMethodBeat.i(63490);
        message.replyTo = huM;
        if (uWG == null) {
            aBM();
            synchronized (uWH) {
                try {
                    uWH.add(message);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(63490);
                }
            }
            return;
        }
        try {
            uWG.r(message);
            AppMethodBeat.o(63490);
        } catch (Exception e) {
            ab.e("MicroMsg.Wepkg.WepkgMainProcessService", e.getMessage());
            AppMethodBeat.o(63490);
        }
    }

    private static void aBM() {
        AppMethodBeat.i(63491);
        if (huI == null) {
            huI = new ServiceConnection() {
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    AppMethodBeat.i(63484);
                    WepkgMainProcessService.uWG = a.I(iBinder);
                    WepkgMainProcessService.aLT();
                    ab.i("MicroMsg.Wepkg.WepkgMainProcessService", "onServiceConnected(%s)", ah.getProcessName());
                    AppMethodBeat.o(63484);
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                    AppMethodBeat.i(63485);
                    WepkgMainProcessService.uWG = null;
                    WepkgMainProcessService.access$600();
                    ab.i("MicroMsg.Wepkg.WepkgMainProcessService", "onServiceDisconnected(%s)", ah.getProcessName());
                    AppMethodBeat.o(63485);
                }
            };
        }
        ab.i("MicroMsg.Wepkg.WepkgMainProcessService", "tryBindService");
        Context context = ah.getContext();
        try {
            context.bindService(new Intent(context, WepkgMainProcessService.class), huI, 1);
            AppMethodBeat.o(63491);
        } catch (Exception e) {
            ab.e("MicroMsg.Wepkg.WepkgMainProcessService", "tryBind() Exception:%s", e.getMessage());
            AppMethodBeat.o(63491);
        }
    }

    public static boolean isLive() {
        if (uWG != null) {
            return true;
        }
        return false;
    }

    static Bundle c(WepkgMainProcessTask wepkgMainProcessTask) {
        AppMethodBeat.i(63492);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("task_object", wepkgMainProcessTask);
        AppMethodBeat.o(63492);
        return bundle;
    }

    private static WepkgMainProcessTask ar(Bundle bundle) {
        AppMethodBeat.i(63493);
        bundle.setClassLoader(WepkgMainProcessTask.class.getClassLoader());
        WepkgMainProcessTask wepkgMainProcessTask = (WepkgMainProcessTask) bundle.getParcelable("task_object");
        AppMethodBeat.o(63493);
        return wepkgMainProcessTask;
    }

    private static void a(WepkgMainProcessTask wepkgMainProcessTask, WepkgMainProcessTask wepkgMainProcessTask2) {
        AppMethodBeat.i(63494);
        Parcel obtain = Parcel.obtain();
        wepkgMainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        wepkgMainProcessTask2.g(obtain);
        obtain.recycle();
        AppMethodBeat.o(63494);
    }

    public static void a(WepkgMainProcessTask wepkgMainProcessTask) {
        AppMethodBeat.i(63487);
        huK.put(Integer.valueOf(wepkgMainProcessTask.hashCode()), new WeakReference(wepkgMainProcessTask));
        Message obtain = Message.obtain();
        obtain.what = wepkgMainProcessTask.hashCode();
        obtain.replyTo = huM;
        obtain.setData(c(wepkgMainProcessTask));
        s(obtain);
        AppMethodBeat.o(63487);
    }

    static /* synthetic */ WepkgMainProcessTask Kk(int i) {
        AppMethodBeat.i(63496);
        if (!huK.containsKey(Integer.valueOf(i))) {
            AppMethodBeat.o(63496);
            return null;
        } else if (((WeakReference) huK.get(Integer.valueOf(i))).get() == null) {
            AppMethodBeat.o(63496);
            return null;
        } else {
            WepkgMainProcessTask wepkgMainProcessTask = (WepkgMainProcessTask) ((WeakReference) huK.get(Integer.valueOf(i))).get();
            AppMethodBeat.o(63496);
            return wepkgMainProcessTask;
        }
    }

    static /* synthetic */ void aLT() {
        AppMethodBeat.i(63498);
        if (uWG != null) {
            synchronized (uWH) {
                try {
                    Iterator it = uWH.iterator();
                    while (it.hasNext()) {
                        s((Message) it.next());
                    }
                    uWH.clear();
                } finally {
                    AppMethodBeat.o(63498);
                }
            }
            return;
        }
        AppMethodBeat.o(63498);
    }
}
