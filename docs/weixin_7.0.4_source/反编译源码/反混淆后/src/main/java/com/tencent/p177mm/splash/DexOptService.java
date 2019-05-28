package com.tencent.p177mm.splash;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.mm.splash.DexOptService */
public class DexOptService extends Service {
    private HandlerThread mHandlerThread = new HandlerThread("DexOpt-Thread");
    private volatile Throwable xGA;
    private Handler xGx;
    private volatile boolean xGy = false;
    private Handler xGz = new C50931();

    /* renamed from: com.tencent.mm.splash.DexOptService$1 */
    class C50931 extends Handler {
        C50931() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(114813);
            C5115h.m7780g("WxSplash.DexOptService", "dexopt process quit.", new Object[0]);
            DexOptService.this.stopSelf();
            AppMethodBeat.m2505o(114813);
        }
    }

    public DexOptService() {
        AppMethodBeat.m2504i(114815);
        AppMethodBeat.m2505o(114815);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m7729b(DexOptService dexOptService) {
        AppMethodBeat.m2504i(114821);
        boolean dqX = dexOptService.dqX();
        AppMethodBeat.m2505o(114821);
        return dqX;
    }

    public void onCreate() {
        AppMethodBeat.m2504i(114816);
        C5115h.m7780g("WxSplash.DexOptService", "onCreate", new Object[0]);
        super.onCreate();
        this.mHandlerThread.start();
        this.xGx = new Handler(this.mHandlerThread.getLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(114814);
                if (DexOptService.this.xGy) {
                    C5115h.m7780g("WxSplash.DexOptService", "dex opt progressing.", new Object[0]);
                    AppMethodBeat.m2505o(114814);
                    return;
                }
                DexOptService.this.xGy = true;
                if (DexOptService.m7729b(DexOptService.this)) {
                    DexOptService.m7725BK();
                } else {
                    DexOptService.m7726BL();
                    DexOptService.m7730c(DexOptService.this);
                }
                DexOptService.aLT();
                DexOptService.this.xGy = false;
                AppMethodBeat.m2505o(114814);
            }
        };
        AppMethodBeat.m2505o(114816);
    }

    private boolean dqX() {
        boolean aZ;
        AppMethodBeat.m2504i(114817);
        C5115h.m7780g("WxSplash.DexOptService", "doDexOpt start", new Object[0]);
        try {
            aZ = C5115h.xGH.mo4568aZ(getApplicationContext());
        } catch (Throwable th) {
            this.xGA = th;
            aZ = false;
        }
        C5115h.m7780g("WxSplash.DexOptService", "schedule to quit", new Object[0]);
        this.xGz.removeCallbacksAndMessages(null);
        this.xGz.sendEmptyMessageDelayed(0, 120000);
        C5115h.m7780g("WxSplash.DexOptService", "doDexOpt done, result %s", Boolean.valueOf(aZ));
        AppMethodBeat.m2505o(114817);
        return aZ;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(114818);
        this.xGx.sendEmptyMessage(0);
        C5115h.m7780g("WxSplash.DexOptService", "onStartCommand", new Object[0]);
        int onStartCommand = super.onStartCommand(intent, i, i2);
        AppMethodBeat.m2505o(114818);
        return onStartCommand;
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(114819);
        C5115h.m7780g("WxSplash.DexOptService", "onBind", new Object[0]);
        AppMethodBeat.m2505o(114819);
        return null;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(114820);
        C5115h.m7780g("WxSplash.DexOptService", "onDestroy", new Object[0]);
        super.onDestroy();
        AppMethodBeat.m2505o(114820);
    }

    /* renamed from: BK */
    static /* synthetic */ void m7725BK() {
        AppMethodBeat.m2504i(114822);
        File file = new File(C5102a.dqR() + "/DexOpt_Failed");
        if (file.exists()) {
            boolean delete = file.delete();
            C5115h.m7780g("WxSplash.DexOptService", "remove failed file %s result %s", file, Boolean.valueOf(delete));
        }
        C5115h.m7780g("WxSplash.DexOptService", "removeFailedFile", new Object[0]);
        AppMethodBeat.m2505o(114822);
    }

    /* renamed from: BL */
    static /* synthetic */ void m7726BL() {
        AppMethodBeat.m2504i(114823);
        String dqR = C5102a.dqR();
        File file = new File(dqR);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(dqR + "/DexOpt_Failed");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            C5115h.m7780g("WxSplash.DexOptService", "addFailedFile", new Object[0]);
            AppMethodBeat.m2505o(114823);
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(114823);
            throw runtimeException;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m7730c(DexOptService dexOptService) {
        AppMethodBeat.m2504i(114824);
        if (dexOptService.xGA != null) {
            RuntimeException runtimeException = new RuntimeException(dexOptService.xGA);
            AppMethodBeat.m2505o(114824);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(114824);
    }

    static /* synthetic */ void aLT() {
        AppMethodBeat.m2504i(114825);
        File file = new File(C5102a.dqR());
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.exists() && file2.getName().startsWith("DexOpt_Request")) {
                    C5115h.m7780g("WxSplash.DexOptService", "remove temp file %s result %s", file2, Boolean.valueOf(file2.delete()));
                    if (!file2.delete()) {
                        RuntimeException runtimeException = new RuntimeException("remove temp file failed");
                        AppMethodBeat.m2505o(114825);
                        throw runtimeException;
                    }
                }
            }
            C5115h.m7780g("WxSplash.DexOptService", "removeDexOptTempFiles", new Object[0]);
        }
        AppMethodBeat.m2505o(114825);
    }
}
