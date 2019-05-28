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
import com.tencent.tinker.lib.c.a;
import com.tencent.tinker.lib.util.TinkerJobIntentService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class TinkerPatchService extends TinkerJobIntentService {
    private static a ABx = null;
    private static Class<? extends AbstractResultService> ABy = null;
    private static AtomicBoolean ABz = new AtomicBoolean(false);
    private static int eee = -1119860829;

    public static class InnerService extends Service {
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(TinkerPatchService.eee, new Notification());
            } catch (Throwable th) {
                com.tencent.tinker.lib.util.a.e("Tinker.TinkerPatchService", "InnerService set service for push exception:%s.", th);
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

    public static void ce(Context context, String str) {
        com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchService", "run patch service...", new Object[0]);
        Intent intent = new Intent(context, TinkerPatchService.class);
        intent.putExtra("patch_path_extra", str);
        intent.putExtra("patch_result_class", ABy.getName());
        try {
            TinkerJobIntentService.a(context, new ComponentName(context, TinkerPatchService.class), -252579085, intent);
        } catch (Throwable th) {
            com.tencent.tinker.lib.util.a.e("Tinker.TinkerPatchService", "run patch service fail, exception:".concat(String.valueOf(th)), new Object[0]);
        }
    }

    public static void a(a aVar, Class<? extends AbstractResultService> cls) {
        ABx = aVar;
        ABy = cls;
        try {
            Class.forName(cls.getName());
        } catch (ClassNotFoundException e) {
        }
    }

    public static String bb(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.n(intent, "patch_path_extra");
        }
        throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }

    public final void l(Intent intent) {
        if (VERSION.SDK_INT >= 26) {
            com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchService", "for system version >= Android O, we just ignore increasingPriority job to avoid crash or toasts.", new Object[0]);
        } else if ("ZUK".equals(Build.MANUFACTURER)) {
            com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchService", "for ZUK device, we just ignore increasingPriority job to avoid crash.", new Object[0]);
        } else {
            com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchService", "try to increase patch process priority", new Object[0]);
            try {
                Notification notification = new Notification();
                if (VERSION.SDK_INT < 18) {
                    startForeground(eee, notification);
                } else {
                    startForeground(eee, notification);
                    startService(new Intent(this, InnerService.class));
                }
            } catch (Throwable th) {
                com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchService", "try to increase patch process priority error:".concat(String.valueOf(th)), new Object[0]);
            }
        }
        if (ABz.compareAndSet(false, true)) {
            com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(this);
            iX.ABF.ad(intent);
            if (intent == null) {
                com.tencent.tinker.lib.util.a.e("Tinker.TinkerPatchService", "TinkerPatchService received a null intent, ignoring.", new Object[0]);
                return;
            }
            String bb = bb(intent);
            if (bb == null) {
                com.tencent.tinker.lib.util.a.e("Tinker.TinkerPatchService", "TinkerPatchService can't get the path extra, ignoring.", new Object[0]);
                return;
            }
            File file = new File(bb);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Throwable th2 = null;
            a aVar = new a();
            boolean a;
            try {
                if (ABx == null) {
                    throw new TinkerRuntimeException("upgradePatchProcessor is null.");
                }
                a = ABx.a(this, bb, aVar);
                elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                iX.ABF.a(file, a, elapsedRealtime);
                aVar.cxT = a;
                aVar.ABv = bb;
                aVar.iBv = elapsedRealtime;
                aVar.Arh = th2;
                if (intent == null) {
                    throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
                }
                AbstractResultService.a(this, aVar, ShareIntentUtil.n(intent, "patch_result_class"));
                ABz.set(false);
            } catch (Throwable th3) {
                th2 = th3;
                iX.ABF.a(file, th2);
                a = false;
            }
        } else {
            com.tencent.tinker.lib.util.a.w("Tinker.TinkerPatchService", "TinkerPatchService doApplyPatch is running by another runner.", new Object[0]);
        }
    }
}
