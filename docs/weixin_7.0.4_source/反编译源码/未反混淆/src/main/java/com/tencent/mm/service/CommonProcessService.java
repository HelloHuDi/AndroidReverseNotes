package com.tencent.mm.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.service.b.a;
import java.util.concurrent.ConcurrentHashMap;

public class CommonProcessService extends Service {
    private static ConcurrentHashMap<String, MMService> xEV = new ConcurrentHashMap();
    private Handler handler;
    private a xEW = new a() {
        public final void a(final Intent intent, final a aVar) {
            AppMethodBeat.i(115254);
            e.pXa.a(963, 38, 1, false);
            if (intent != null) {
                CommonProcessService.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(115250);
                        intent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
                        String stringExtra = intent.getStringExtra("class_name");
                        try {
                            ab.i(CommonProcessService.this.getTag(), "bindService() class_name = %s", stringExtra);
                            MMService mMService = (MMService) CommonProcessService.xEV.get(stringExtra);
                            if (mMService == null) {
                                mMService = (MMService) Class.forName(stringExtra).newInstance();
                                mMService.xEV = CommonProcessService.xEV;
                                mMService.xFe = CommonProcessService.this;
                                CommonProcessService.xEV.put(stringExtra, mMService);
                            }
                            e.pXa.a(963, 39, 1, false);
                            IBinder q = mMService.q(intent, "bind");
                            try {
                                if (aVar != null) {
                                    aVar.M(q);
                                }
                                AppMethodBeat.o(115250);
                            } catch (RemoteException e) {
                                ab.i(CommonProcessService.this.getTag(), "bindService() immserviceConnectionStubAIDL RemoteException: %s", e.getMessage());
                                AppMethodBeat.o(115250);
                            }
                        } catch (Exception e2) {
                            ab.i(CommonProcessService.this.getTag(), "bindService()  Class.forName(%s) Exception: %s", stringExtra, e2.getMessage());
                            AppMethodBeat.o(115250);
                        }
                    }
                });
                AppMethodBeat.o(115254);
                return;
            }
            ab.i(CommonProcessService.this.getTag(), "bindService() intent == null");
            AppMethodBeat.o(115254);
        }

        public final void aN(final Intent intent) {
            AppMethodBeat.i(115255);
            e.pXa.a(963, 53, 1, false);
            if (intent != null) {
                CommonProcessService.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(115251);
                        intent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
                        ab.i(CommonProcessService.this.getTag(), "unbindService() class_name = %s", intent.getStringExtra("class_name"));
                        MMService mMService = (MMService) CommonProcessService.xEV.get(r0);
                        if (mMService == null) {
                            AppMethodBeat.o(115251);
                            return;
                        }
                        e.pXa.a(963, 54, 1, false);
                        mMService.q(intent, "unbind");
                        AppMethodBeat.o(115251);
                    }
                });
                AppMethodBeat.o(115255);
                return;
            }
            ab.i(CommonProcessService.this.getTag(), "unbindService() intent == null");
            AppMethodBeat.o(115255);
        }

        public final void aH(final Intent intent) {
            AppMethodBeat.i(115256);
            e.pXa.a(963, 7, 1, false);
            if (intent != null) {
                CommonProcessService.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(115252);
                        intent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
                        String stringExtra = intent.getStringExtra("class_name");
                        try {
                            ab.i(CommonProcessService.this.getTag(), "startService() class_name = %s", stringExtra);
                            MMService mMService = (MMService) CommonProcessService.xEV.get(stringExtra);
                            if (mMService == null) {
                                mMService = (MMService) Class.forName(stringExtra).newInstance();
                                mMService.xEV = CommonProcessService.xEV;
                                mMService.xFe = CommonProcessService.this;
                                CommonProcessService.xEV.put(stringExtra, mMService);
                            }
                            e.pXa.a(963, 8, 1, false);
                            mMService.q(intent, "start");
                            AppMethodBeat.o(115252);
                        } catch (Exception e) {
                            ab.i(CommonProcessService.this.getTag(), "startService()  Class.forName(%s) Exception: %s", stringExtra, e.getMessage());
                            AppMethodBeat.o(115252);
                        }
                    }
                });
                AppMethodBeat.o(115256);
                return;
            }
            ab.i(CommonProcessService.this.getTag(), "startService() intent == null");
            AppMethodBeat.o(115256);
        }

        public final void aI(final Intent intent) {
            AppMethodBeat.i(115257);
            e.pXa.a(963, 23, 1, false);
            if (intent != null) {
                CommonProcessService.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(115253);
                        intent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
                        ab.i(CommonProcessService.this.getTag(), "stopService() class_name = %s", intent.getStringExtra("class_name"));
                        MMService mMService = (MMService) CommonProcessService.xEV.get(r0);
                        if (mMService == null) {
                            AppMethodBeat.o(115253);
                            return;
                        }
                        e.pXa.a(963, 24, 1, false);
                        mMService.q(intent, "stop");
                        AppMethodBeat.o(115253);
                    }
                });
                AppMethodBeat.o(115257);
                return;
            }
            ab.i(CommonProcessService.this.getTag(), "stopService() intent == null");
            AppMethodBeat.o(115257);
        }
    };

    public CommonProcessService() {
        AppMethodBeat.i(115258);
        AppMethodBeat.o(115258);
    }

    static {
        AppMethodBeat.i(115266);
        AppMethodBeat.o(115266);
    }

    public void onCreate() {
        AppMethodBeat.i(115259);
        ab.i(getTag(), "onCreate()");
        this.handler = new Handler();
        super.onCreate();
        AppMethodBeat.o(115259);
    }

    public void onStart(Intent intent, int i) {
        AppMethodBeat.i(115260);
        ab.i(getTag(), "onStart()");
        super.onStart(intent, i);
        AppMethodBeat.o(115260);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.i(115261);
        ab.i(getTag(), "onStartCommand()");
        AppMethodBeat.o(115261);
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.i(115262);
        ab.i(getTag(), "onDestroy()");
        super.onDestroy();
        AppMethodBeat.o(115262);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(115263);
        ab.i(getTag(), "onUnbind()");
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(115263);
        return onUnbind;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.i(115264);
        ab.i(getTag(), "onRebind()");
        super.onRebind(intent);
        AppMethodBeat.o(115264);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(115265);
        ab.i(getTag(), "onBind()");
        a aVar = this.xEW;
        AppMethodBeat.o(115265);
        return aVar;
    }

    public String getTag() {
        return "MicroMsg.MMProcessService";
    }
}
