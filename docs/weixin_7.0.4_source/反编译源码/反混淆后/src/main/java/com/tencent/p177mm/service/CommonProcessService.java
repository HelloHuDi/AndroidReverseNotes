package com.tencent.p177mm.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.service.C5080b.C5081a;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.service.CommonProcessService */
public class CommonProcessService extends Service {
    private static ConcurrentHashMap<String, MMService> xEV = new ConcurrentHashMap();
    private Handler handler;
    private C5081a xEW = new C50751();

    /* renamed from: com.tencent.mm.service.CommonProcessService$1 */
    class C50751 extends C5081a {
        C50751() {
        }

        /* renamed from: a */
        public final void mo10416a(final Intent intent, final C5077a c5077a) {
            AppMethodBeat.m2504i(115254);
            C7053e.pXa.mo8378a(963, 38, 1, false);
            if (intent != null) {
                CommonProcessService.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(115250);
                        intent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
                        String stringExtra = intent.getStringExtra("class_name");
                        try {
                            C4990ab.m7417i(CommonProcessService.this.getTag(), "bindService() class_name = %s", stringExtra);
                            MMService mMService = (MMService) CommonProcessService.xEV.get(stringExtra);
                            if (mMService == null) {
                                mMService = (MMService) Class.forName(stringExtra).newInstance();
                                mMService.xEV = CommonProcessService.xEV;
                                mMService.xFe = CommonProcessService.this;
                                CommonProcessService.xEV.put(stringExtra, mMService);
                            }
                            C7053e.pXa.mo8378a(963, 39, 1, false);
                            IBinder q = mMService.mo10429q(intent, "bind");
                            try {
                                if (c5077a != null) {
                                    c5077a.mo10433M(q);
                                }
                                AppMethodBeat.m2505o(115250);
                            } catch (RemoteException e) {
                                C4990ab.m7417i(CommonProcessService.this.getTag(), "bindService() immserviceConnectionStubAIDL RemoteException: %s", e.getMessage());
                                AppMethodBeat.m2505o(115250);
                            }
                        } catch (Exception e2) {
                            C4990ab.m7417i(CommonProcessService.this.getTag(), "bindService()  Class.forName(%s) Exception: %s", stringExtra, e2.getMessage());
                            AppMethodBeat.m2505o(115250);
                        }
                    }
                });
                AppMethodBeat.m2505o(115254);
                return;
            }
            C4990ab.m7416i(CommonProcessService.this.getTag(), "bindService() intent == null");
            AppMethodBeat.m2505o(115254);
        }

        /* renamed from: aN */
        public final void mo10419aN(final Intent intent) {
            AppMethodBeat.m2504i(115255);
            C7053e.pXa.mo8378a(963, 53, 1, false);
            if (intent != null) {
                CommonProcessService.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(115251);
                        intent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
                        C4990ab.m7417i(CommonProcessService.this.getTag(), "unbindService() class_name = %s", intent.getStringExtra("class_name"));
                        MMService mMService = (MMService) CommonProcessService.xEV.get(r0);
                        if (mMService == null) {
                            AppMethodBeat.m2505o(115251);
                            return;
                        }
                        C7053e.pXa.mo8378a(963, 54, 1, false);
                        mMService.mo10429q(intent, "unbind");
                        AppMethodBeat.m2505o(115251);
                    }
                });
                AppMethodBeat.m2505o(115255);
                return;
            }
            C4990ab.m7416i(CommonProcessService.this.getTag(), "unbindService() intent == null");
            AppMethodBeat.m2505o(115255);
        }

        /* renamed from: aH */
        public final void mo10417aH(final Intent intent) {
            AppMethodBeat.m2504i(115256);
            C7053e.pXa.mo8378a(963, 7, 1, false);
            if (intent != null) {
                CommonProcessService.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(115252);
                        intent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
                        String stringExtra = intent.getStringExtra("class_name");
                        try {
                            C4990ab.m7417i(CommonProcessService.this.getTag(), "startService() class_name = %s", stringExtra);
                            MMService mMService = (MMService) CommonProcessService.xEV.get(stringExtra);
                            if (mMService == null) {
                                mMService = (MMService) Class.forName(stringExtra).newInstance();
                                mMService.xEV = CommonProcessService.xEV;
                                mMService.xFe = CommonProcessService.this;
                                CommonProcessService.xEV.put(stringExtra, mMService);
                            }
                            C7053e.pXa.mo8378a(963, 8, 1, false);
                            mMService.mo10429q(intent, "start");
                            AppMethodBeat.m2505o(115252);
                        } catch (Exception e) {
                            C4990ab.m7417i(CommonProcessService.this.getTag(), "startService()  Class.forName(%s) Exception: %s", stringExtra, e.getMessage());
                            AppMethodBeat.m2505o(115252);
                        }
                    }
                });
                AppMethodBeat.m2505o(115256);
                return;
            }
            C4990ab.m7416i(CommonProcessService.this.getTag(), "startService() intent == null");
            AppMethodBeat.m2505o(115256);
        }

        /* renamed from: aI */
        public final void mo10418aI(final Intent intent) {
            AppMethodBeat.m2504i(115257);
            C7053e.pXa.mo8378a(963, 23, 1, false);
            if (intent != null) {
                CommonProcessService.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(115253);
                        intent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
                        C4990ab.m7417i(CommonProcessService.this.getTag(), "stopService() class_name = %s", intent.getStringExtra("class_name"));
                        MMService mMService = (MMService) CommonProcessService.xEV.get(r0);
                        if (mMService == null) {
                            AppMethodBeat.m2505o(115253);
                            return;
                        }
                        C7053e.pXa.mo8378a(963, 24, 1, false);
                        mMService.mo10429q(intent, "stop");
                        AppMethodBeat.m2505o(115253);
                    }
                });
                AppMethodBeat.m2505o(115257);
                return;
            }
            C4990ab.m7416i(CommonProcessService.this.getTag(), "stopService() intent == null");
            AppMethodBeat.m2505o(115257);
        }
    }

    public CommonProcessService() {
        AppMethodBeat.m2504i(115258);
        AppMethodBeat.m2505o(115258);
    }

    static {
        AppMethodBeat.m2504i(115266);
        AppMethodBeat.m2505o(115266);
    }

    public void onCreate() {
        AppMethodBeat.m2504i(115259);
        C4990ab.m7416i(getTag(), "onCreate()");
        this.handler = new Handler();
        super.onCreate();
        AppMethodBeat.m2505o(115259);
    }

    public void onStart(Intent intent, int i) {
        AppMethodBeat.m2504i(115260);
        C4990ab.m7416i(getTag(), "onStart()");
        super.onStart(intent, i);
        AppMethodBeat.m2505o(115260);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(115261);
        C4990ab.m7416i(getTag(), "onStartCommand()");
        AppMethodBeat.m2505o(115261);
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(115262);
        C4990ab.m7416i(getTag(), "onDestroy()");
        super.onDestroy();
        AppMethodBeat.m2505o(115262);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.m2504i(115263);
        C4990ab.m7416i(getTag(), "onUnbind()");
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.m2505o(115263);
        return onUnbind;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.m2504i(115264);
        C4990ab.m7416i(getTag(), "onRebind()");
        super.onRebind(intent);
        AppMethodBeat.m2505o(115264);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(115265);
        C4990ab.m7416i(getTag(), "onBind()");
        C5081a c5081a = this.xEW;
        AppMethodBeat.m2505o(115265);
        return c5081a;
    }

    public String getTag() {
        return "MicroMsg.MMProcessService";
    }
}
