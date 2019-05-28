package com.tencent.mm.splash;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public class DexOptService extends Service {
    private HandlerThread mHandlerThread = new HandlerThread("DexOpt-Thread");
    private volatile Throwable xGA;
    private Handler xGx;
    private volatile boolean xGy = false;
    private Handler xGz = new Handler() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(114813);
            h.g("WxSplash.DexOptService", "dexopt process quit.", new Object[0]);
            DexOptService.this.stopSelf();
            AppMethodBeat.o(114813);
        }
    };

    public DexOptService() {
        AppMethodBeat.i(114815);
        AppMethodBeat.o(114815);
    }

    static /* synthetic */ boolean b(DexOptService dexOptService) {
        AppMethodBeat.i(114821);
        boolean dqX = dexOptService.dqX();
        AppMethodBeat.o(114821);
        return dqX;
    }

    public void onCreate() {
        AppMethodBeat.i(114816);
        h.g("WxSplash.DexOptService", "onCreate", new Object[0]);
        super.onCreate();
        this.mHandlerThread.start();
        this.xGx = new Handler(this.mHandlerThread.getLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(114814);
                if (DexOptService.this.xGy) {
                    h.g("WxSplash.DexOptService", "dex opt progressing.", new Object[0]);
                    AppMethodBeat.o(114814);
                    return;
                }
                DexOptService.this.xGy = true;
                if (DexOptService.b(DexOptService.this)) {
                    DexOptService.BK();
                } else {
                    DexOptService.BL();
                    DexOptService.c(DexOptService.this);
                }
                DexOptService.aLT();
                DexOptService.this.xGy = false;
                AppMethodBeat.o(114814);
            }
        };
        AppMethodBeat.o(114816);
    }

    private boolean dqX() {
        boolean aZ;
        AppMethodBeat.i(114817);
        h.g("WxSplash.DexOptService", "doDexOpt start", new Object[0]);
        try {
            aZ = h.xGH.aZ(getApplicationContext());
        } catch (Throwable th) {
            this.xGA = th;
            aZ = false;
        }
        h.g("WxSplash.DexOptService", "schedule to quit", new Object[0]);
        this.xGz.removeCallbacksAndMessages(null);
        this.xGz.sendEmptyMessageDelayed(0, 120000);
        h.g("WxSplash.DexOptService", "doDexOpt done, result %s", Boolean.valueOf(aZ));
        AppMethodBeat.o(114817);
        return aZ;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.i(114818);
        this.xGx.sendEmptyMessage(0);
        h.g("WxSplash.DexOptService", "onStartCommand", new Object[0]);
        int onStartCommand = super.onStartCommand(intent, i, i2);
        AppMethodBeat.o(114818);
        return onStartCommand;
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(114819);
        h.g("WxSplash.DexOptService", "onBind", new Object[0]);
        AppMethodBeat.o(114819);
        return null;
    }

    public void onDestroy() {
        AppMethodBeat.i(114820);
        h.g("WxSplash.DexOptService", "onDestroy", new Object[0]);
        super.onDestroy();
        AppMethodBeat.o(114820);
    }

    static /* synthetic */ void BK() {
        AppMethodBeat.i(114822);
        File file = new File(a.dqR() + "/DexOpt_Failed");
        if (file.exists()) {
            boolean delete = file.delete();
            h.g("WxSplash.DexOptService", "remove failed file %s result %s", file, Boolean.valueOf(delete));
        }
        h.g("WxSplash.DexOptService", "removeFailedFile", new Object[0]);
        AppMethodBeat.o(114822);
    }

    static /* synthetic */ void BL() {
        AppMethodBeat.i(114823);
        String dqR = a.dqR();
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
            h.g("WxSplash.DexOptService", "addFailedFile", new Object[0]);
            AppMethodBeat.o(114823);
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(114823);
            throw runtimeException;
        }
    }

    static /* synthetic */ void c(DexOptService dexOptService) {
        AppMethodBeat.i(114824);
        if (dexOptService.xGA != null) {
            RuntimeException runtimeException = new RuntimeException(dexOptService.xGA);
            AppMethodBeat.o(114824);
            throw runtimeException;
        }
        AppMethodBeat.o(114824);
    }

    static /* synthetic */ void aLT() {
        AppMethodBeat.i(114825);
        File file = new File(a.dqR());
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.exists() && file2.getName().startsWith("DexOpt_Request")) {
                    h.g("WxSplash.DexOptService", "remove temp file %s result %s", file2, Boolean.valueOf(file2.delete()));
                    if (!file2.delete()) {
                        RuntimeException runtimeException = new RuntimeException("remove temp file failed");
                        AppMethodBeat.o(114825);
                        throw runtimeException;
                    }
                }
            }
            h.g("WxSplash.DexOptService", "removeDexOptTempFiles", new Object[0]);
        }
        AppMethodBeat.o(114825);
    }
}
