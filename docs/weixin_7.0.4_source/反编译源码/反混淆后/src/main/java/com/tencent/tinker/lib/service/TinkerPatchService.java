package com.tencent.tinker.lib.service;

import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.tinker.lib.p1112c.C46817a;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.lib.util.TinkerJobIntentService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class TinkerPatchService extends TinkerJobIntentService {
    private static C46817a ABx = null;
    private static Class<? extends AbstractResultService> ABy = null;
    private static AtomicBoolean ABz = new AtomicBoolean(false);
    private static int eee = -1119860829;

    public static class InnerService extends Service {
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(TinkerPatchService.eee, new Notification());
            } catch (Throwable th) {
                C5952a.m9283e("Tinker.TinkerPatchService", "InnerService set service for push exception:%s.", th);
            }
            stopSelf();
        }

        public void onDestroy() {
            stopForeground(true);
            super.onDestroy();
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    /* renamed from: ce */
    public static void m80934ce(Context context, String str) {
        C5952a.m9284i("Tinker.TinkerPatchService", "run patch service...", new Object[0]);
        Intent intent = new Intent(context, TinkerPatchService.class);
        intent.putExtra("patch_path_extra", str);
        intent.putExtra("patch_result_class", ABy.getName());
        try {
            TinkerJobIntentService.m9262a(context, new ComponentName(context, TinkerPatchService.class), -252579085, intent);
        } catch (Throwable th) {
            C5952a.m9283e("Tinker.TinkerPatchService", "run patch service fail, exception:".concat(String.valueOf(th)), new Object[0]);
        }
    }

    /* renamed from: a */
    public static void m80932a(C46817a c46817a, Class<? extends AbstractResultService> cls) {
        ABx = c46817a;
        ABy = cls;
        try {
            Class.forName(cls.getName());
        } catch (ClassNotFoundException e) {
        }
    }

    /* renamed from: bb */
    public static String m80933bb(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.m9362n(intent, "patch_path_extra");
        }
        throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }

    /* renamed from: l */
    public final void mo12631l(Intent intent) {
        if (VERSION.SDK_INT >= 26) {
            C5952a.m9284i("Tinker.TinkerPatchService", "for system version >= Android O, we just ignore increasingPriority job to avoid crash or toasts.", new Object[0]);
        } else if ("ZUK".equals(Build.MANUFACTURER)) {
            C5952a.m9284i("Tinker.TinkerPatchService", "for ZUK device, we just ignore increasingPriority job to avoid crash.", new Object[0]);
        } else {
            C5952a.m9284i("Tinker.TinkerPatchService", "try to increase patch process priority", new Object[0]);
            try {
                Notification notification = new Notification();
                if (VERSION.SDK_INT < 18) {
                    startForeground(eee, notification);
                } else {
                    startForeground(eee, notification);
                    startService(new Intent(this, InnerService.class));
                }
            } catch (Throwable th) {
                C5952a.m9284i("Tinker.TinkerPatchService", "try to increase patch process priority error:".concat(String.valueOf(th)), new Object[0]);
            }
        }
        if (ABz.compareAndSet(false, true)) {
            C31097a iX = C31097a.m50180iX(this);
            iX.ABF.mo40783ad(intent);
            if (intent == null) {
                C5952a.m9283e("Tinker.TinkerPatchService", "TinkerPatchService received a null intent, ignoring.", new Object[0]);
                return;
            }
            String bb = m80933bb(intent);
            if (bb == null) {
                C5952a.m9283e("Tinker.TinkerPatchService", "TinkerPatchService can't get the path extra, ignoring.", new Object[0]);
                return;
            }
            File file = new File(bb);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Throwable th2 = null;
            C46819a c46819a = new C46819a();
            boolean a;
            try {
                if (ABx == null) {
                    throw new TinkerRuntimeException("upgradePatchProcessor is null.");
                }
                a = ABx.mo57836a(this, bb, c46819a);
                elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                iX.ABF.mo40782a(file, a, elapsedRealtime);
                c46819a.cxT = a;
                c46819a.ABv = bb;
                c46819a.iBv = elapsedRealtime;
                c46819a.Arh = th2;
                if (intent == null) {
                    throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
                }
                AbstractResultService.m71514a(this, c46819a, ShareIntentUtil.m9362n(intent, "patch_result_class"));
                ABz.set(false);
            } catch (Throwable th3) {
                th2 = th3;
                iX.ABF.mo40780a(file, th2);
                a = false;
            }
        } else {
            C5952a.m9285w("Tinker.TinkerPatchService", "TinkerPatchService doApplyPatch is running by another runner.", new Object[0]);
        }
    }
}
