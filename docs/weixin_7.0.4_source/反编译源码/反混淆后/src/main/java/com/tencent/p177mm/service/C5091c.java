package com.tencent.p177mm.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.service.C5077a.C5078a;
import com.tencent.p177mm.service.C5080b.C5081a;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.service.c */
public final class C5091c {
    private static ConcurrentHashMap<String, C5080b> xFh = new ConcurrentHashMap();
    private static Vector<Intent> xFi = new Vector();
    private static Vector<Intent> xFj = new Vector();
    private static ConcurrentHashMap<Integer, String> xFk = new ConcurrentHashMap();
    private static ConcurrentHashMap<Integer, IBinder> xFl = new ConcurrentHashMap();
    private static ConcurrentHashMap<Integer, DeathRecipient> xFm = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(115294);
        AppMethodBeat.m2505o(115294);
    }

    /* renamed from: a */
    public static void m7718a(Intent intent, String str, boolean z, Intent intent2) {
        AppMethodBeat.m2504i(115287);
        while (intent != null) {
            String className = intent.getComponent().getClassName();
            if (C5046bo.isNullOrNil(className)) {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "startService() ClassName = null processName = %s", str);
                AppMethodBeat.m2505o(115287);
                return;
            }
            C4990ab.m7417i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s", className, str);
            C7053e.pXa.mo8378a(963, 0, 1, false);
            intent.putExtra("class_name", className);
            C5080b c5080b = (C5080b) xFh.get(str);
            if (c5080b == null) {
                C7053e.pXa.mo8378a(963, 1, 1, false);
                xFi.add(intent);
                Context context = C4996ah.getContext();
                C5091c.m7723h(context, str, intent2);
                try {
                    final String str2 = className;
                    final String str3 = str;
                    final Intent intent3 = intent;
                    final boolean z2 = z;
                    final Intent intent4 = intent2;
                    boolean bindService = context.bindService(intent2, new ServiceConnection() {
                        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            AppMethodBeat.m2504i(115273);
                            C4990ab.m7417i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected()", str2, str3);
                            C7053e.pXa.mo8378a(963, 2, 1, false);
                            if (iBinder == null) {
                                C4990ab.m7417i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected() service == null", str2, str3);
                                AppMethodBeat.m2505o(115273);
                            } else if (C5091c.xFi.contains(intent3)) {
                                try {
                                    C5080b N = C5081a.m7712N(iBinder);
                                    N.mo10417aH(intent3);
                                    C5091c.xFh.put(str3, N);
                                    C5091c.xFi.remove(intent3);
                                    AppMethodBeat.m2505o(115273);
                                } catch (Exception e) {
                                    C7053e.pXa.mo8378a(963, 3, 1, false);
                                    C4990ab.m7417i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", str2, str3, e.getMessage(), C5046bo.dpG());
                                    if (z2) {
                                        C7053e.pXa.mo8378a(963, 5, 1, false);
                                        C5091c.m7718a(intent3, str3, false, intent4);
                                    }
                                    C5091c.xFi.remove(intent3);
                                    AppMethodBeat.m2505o(115273);
                                } catch (Throwable th) {
                                    C5091c.xFi.remove(intent3);
                                    AppMethodBeat.m2505o(115273);
                                    throw th;
                                }
                            } else {
                                AppMethodBeat.m2505o(115273);
                            }
                        }

                        public final void onServiceDisconnected(ComponentName componentName) {
                            AppMethodBeat.m2504i(115274);
                            C4990ab.m7417i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceDisconnected()", str2, str3);
                            C7053e.pXa.mo8378a(963, 4, 1, false);
                            C5091c.xFh.remove(str3);
                            AppMethodBeat.m2505o(115274);
                        }
                    }, 1);
                    C4990ab.m7417i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s bindService_result = %b", className, str, Boolean.valueOf(bindService));
                    AppMethodBeat.m2505o(115287);
                    return;
                } catch (Exception e) {
                    C4990ab.m7417i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", className, str, e.getMessage());
                    AppMethodBeat.m2505o(115287);
                    return;
                }
            }
            C7053e.pXa.mo8378a(963, 6, 1, false);
            try {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, startService() ClassName = %s ProcessName = %s ", className, str);
                c5080b.mo10417aH(intent);
                AppMethodBeat.m2505o(115287);
                return;
            } catch (Exception e2) {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", className, str, e2.getMessage(), C5046bo.dpG());
                xFh.remove(str);
                if (z) {
                    C7053e.pXa.mo8378a(963, 5, 1, false);
                    z = false;
                } else {
                    AppMethodBeat.m2505o(115287);
                    return;
                }
            }
        }
        C4990ab.m7416i("MicroMsg.MMServiceHelper", "startService Intent == null");
        AppMethodBeat.m2505o(115287);
    }

    /* renamed from: b */
    public static void m7722b(Intent intent, String str, boolean z, Intent intent2) {
        AppMethodBeat.m2504i(115288);
        while (intent != null) {
            String className = intent.getComponent().getClassName();
            if (C5046bo.isNullOrNil(className)) {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "stopService() ClassName = null processName = %s", str);
                AppMethodBeat.m2505o(115288);
                return;
            }
            C4990ab.m7417i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s", className, str);
            C7053e.pXa.mo8378a(963, 16, 1, false);
            C5080b c5080b = (C5080b) xFh.get(str);
            intent.putExtra("class_name", className);
            if (c5080b == null) {
                C7053e.pXa.mo8378a(963, 17, 1, false);
                Context context = C4996ah.getContext();
                C5091c.m7723h(context, str, intent2);
                try {
                    final String str2 = className;
                    final String str3 = str;
                    final Intent intent3 = intent;
                    final boolean z2 = z;
                    final Intent intent4 = intent2;
                    boolean bindService = context.bindService(intent2, new ServiceConnection() {
                        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            AppMethodBeat.m2504i(115275);
                            C4990ab.m7417i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected()", str2, str3);
                            C7053e.pXa.mo8378a(963, 18, 1, false);
                            if (iBinder == null) {
                                C4990ab.m7417i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected() service == null", str2, str3);
                                AppMethodBeat.m2505o(115275);
                                return;
                            }
                            try {
                                C5080b N = C5081a.m7712N(iBinder);
                                N.mo10418aI(intent3);
                                C5091c.xFh.put(str3, N);
                                AppMethodBeat.m2505o(115275);
                            } catch (Exception e) {
                                C4990ab.m7417i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", str2, str3, e.getMessage(), C5046bo.dpG());
                                C7053e.pXa.mo8378a(963, 19, 1, false);
                                if (z2) {
                                    C7053e.pXa.mo8378a(963, 21, 1, false);
                                    C5091c.m7722b(intent3, str3, false, intent4);
                                }
                                AppMethodBeat.m2505o(115275);
                            }
                        }

                        public final void onServiceDisconnected(ComponentName componentName) {
                            AppMethodBeat.m2504i(115276);
                            C4990ab.m7417i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceDisconnected()", str2, str3);
                            C7053e.pXa.mo8378a(963, 20, 1, false);
                            C5091c.xFh.remove(str3);
                            AppMethodBeat.m2505o(115276);
                        }
                    }, 1);
                    C4990ab.m7417i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s bindService_result = %b", className, str, Boolean.valueOf(bindService));
                    AppMethodBeat.m2505o(115288);
                    return;
                } catch (Exception e) {
                    C4990ab.m7417i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", className, str, e.getMessage());
                    AppMethodBeat.m2505o(115288);
                    return;
                }
            }
            C7053e.pXa.mo8378a(963, 22, 1, false);
            try {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, stopService() ClassName = %s ProcessName = %s stack[%s]", className, str, C5046bo.dpG());
                c5080b.mo10418aI(intent);
                AppMethodBeat.m2505o(115288);
                return;
            } catch (Exception e2) {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s exception = %s", className, str, e2.getMessage());
                xFh.remove(str);
                if (z) {
                    C7053e.pXa.mo8378a(963, 21, 1, false);
                    z = false;
                } else {
                    AppMethodBeat.m2505o(115288);
                    return;
                }
            }
        }
        C4990ab.m7416i("MicroMsg.MMServiceHelper", "stopService Intent == null");
        AppMethodBeat.m2505o(115288);
    }

    /* renamed from: a */
    public static boolean m7721a(Intent intent, final ServiceConnection serviceConnection, int i, final String str, boolean z, final Intent intent2) {
        AppMethodBeat.m2504i(115289);
        if (intent == null) {
            C4990ab.m7416i("MicroMsg.MMServiceHelper", "bindService Intent == null");
            AppMethodBeat.m2505o(115289);
            return false;
        }
        final String className = intent.getComponent().getClassName();
        if (C5046bo.isNullOrNil(className)) {
            C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService() processName = %s", str);
            AppMethodBeat.m2505o(115289);
            return false;
        }
        C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService() ClassName = %s ProcessName = %s", className, str);
        C7053e.pXa.mo8378a(963, 31, 1, false);
        C5080b c5080b = (C5080b) xFh.get(str);
        intent.putExtra("class_name", className);
        intent.putExtra("service_connection", serviceConnection.hashCode());
        xFk.put(Integer.valueOf(serviceConnection.hashCode()), className);
        if (c5080b == null) {
            C7053e.pXa.mo8378a(963, 32, 1, false);
            xFj.add(intent);
            Context context = C4996ah.getContext();
            C5091c.m7723h(context, str, intent2);
            try {
                final Intent intent3 = intent2;
                final String str2 = className;
                final String str3 = str;
                final Intent intent4 = intent;
                final ServiceConnection serviceConnection2 = serviceConnection;
                final boolean z2 = z;
                final int i2 = i;
                boolean bindService = context.bindService(intent2, new ServiceConnection() {

                    /* renamed from: com.tencent.mm.service.c$3$1 */
                    class C50871 extends C5078a {

                        /* renamed from: com.tencent.mm.service.c$3$1$1 */
                        class C50851 implements DeathRecipient {
                            C50851() {
                            }

                            public final void binderDied() {
                                AppMethodBeat.m2504i(115277);
                                C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", intent3.getComponent().getClassName(), str2, str3);
                                serviceConnection2.onServiceDisconnected(new ComponentName(C4996ah.getContext(), str2));
                                AppMethodBeat.m2505o(115277);
                            }
                        }

                        C50871() {
                        }

                        /* renamed from: M */
                        public final void mo10433M(IBinder iBinder) {
                            AppMethodBeat.m2504i(115278);
                            if (iBinder == null) {
                                C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected() service == null", intent3.getComponent().getClassName(), str2, str3);
                                AppMethodBeat.m2505o(115278);
                                return;
                            }
                            C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", intent3.getComponent().getClassName(), str2, str3);
                            serviceConnection2.onServiceConnected(new ComponentName(C4996ah.getContext(), str2), iBinder);
                            C5091c.xFl.put(Integer.valueOf(serviceConnection2.hashCode()), iBinder);
                            C50851 c50851 = new C50851();
                            C5091c.xFm.put(Integer.valueOf(serviceConnection2.hashCode()), c50851);
                            iBinder.linkToDeath(c50851, 0);
                            AppMethodBeat.m2505o(115278);
                        }
                    }

                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        AppMethodBeat.m2504i(115279);
                        C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected()", intent3.getComponent().getClassName(), str2, str3);
                        C7053e.pXa.mo8378a(963, 33, 1, false);
                        if (!C5091c.xFj.contains(intent4)) {
                            AppMethodBeat.m2505o(115279);
                        } else if (iBinder == null) {
                            C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() service == null", intent3.getComponent().getClassName(), str2, str3);
                            AppMethodBeat.m2505o(115279);
                        } else {
                            try {
                                C5080b N = C5081a.m7712N(iBinder);
                                N.mo10416a(intent4, new C50871());
                                C5091c.xFh.put(str3, N);
                                C5091c.xFj.remove(intent4);
                                AppMethodBeat.m2505o(115279);
                            } catch (Exception e) {
                                C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService()  ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", intent3.getComponent().getClassName(), str2, str3, e.getMessage(), C5046bo.dpG());
                                C7053e.pXa.mo8378a(963, 34, 1, false);
                                if (z2) {
                                    C7053e.pXa.mo8378a(963, 36, 1, false);
                                    C5091c.m7721a(intent4, serviceConnection2, i2, str3, false, intent3);
                                }
                                C5091c.xFj.remove(intent4);
                                AppMethodBeat.m2505o(115279);
                            } catch (Throwable th) {
                                C5091c.xFj.remove(intent4);
                                AppMethodBeat.m2505o(115279);
                                throw th;
                            }
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        AppMethodBeat.m2504i(115280);
                        C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceDisconnected()", intent3.getComponent().getClassName(), str2, str3);
                        C7053e.pXa.mo8378a(963, 35, 1, false);
                        C5091c.xFh.remove(str3);
                        AppMethodBeat.m2505o(115280);
                    }
                }, 1);
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s bindService_result = %b", intent2.getComponent().getClassName(), className, str, Boolean.valueOf(bindService));
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s Context.bindService() Exception = %s", intent2.getComponent().getClassName(), className, str, e.getMessage());
            }
        } else {
            C7053e.pXa.mo8378a(963, 37, 1, false);
            try {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, bindService() ClassName = %s ProcessName = %s ", className, str);
                c5080b.mo10416a(intent, new C5078a() {

                    /* renamed from: com.tencent.mm.service.c$4$1 */
                    class C50881 implements DeathRecipient {
                        C50881() {
                        }

                        public final void binderDied() {
                            AppMethodBeat.m2504i(115281);
                            C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", intent2.getComponent().getClassName(), className, str);
                            serviceConnection.onServiceDisconnected(new ComponentName(C4996ah.getContext(), className));
                            AppMethodBeat.m2505o(115281);
                        }
                    }

                    /* renamed from: M */
                    public final void mo10433M(IBinder iBinder) {
                        AppMethodBeat.m2504i(115282);
                        C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", intent2.getComponent().getClassName(), className, str);
                        if (iBinder == null) {
                            AppMethodBeat.m2505o(115282);
                            return;
                        }
                        serviceConnection.onServiceConnected(new ComponentName(C4996ah.getContext(), className), iBinder);
                        C5091c.xFl.put(Integer.valueOf(serviceConnection.hashCode()), iBinder);
                        iBinder.linkToDeath(new C50881(), 0);
                        AppMethodBeat.m2505o(115282);
                    }
                });
            } catch (Exception e2) {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "bindService ClassName = %s ProcessName = %s exception = %s stack[%s]", className, str, e2.getMessage(), C5046bo.dpG());
                xFh.remove(str);
                if (z) {
                    C7053e.pXa.mo8378a(963, 36, 1, false);
                    C5091c.m7721a(intent, serviceConnection, i, str, false, intent2);
                }
            }
        }
        AppMethodBeat.m2505o(115289);
        return true;
    }

    /* renamed from: a */
    public static void m7719a(ServiceConnection serviceConnection, String str, boolean z, Intent intent) {
        AppMethodBeat.m2504i(115290);
        while (serviceConnection != null) {
            String str2 = (String) xFk.remove(Integer.valueOf(serviceConnection.hashCode()));
            IBinder iBinder = (IBinder) xFl.remove(Integer.valueOf(serviceConnection.hashCode()));
            DeathRecipient deathRecipient = (DeathRecipient) xFm.remove(Integer.valueOf(serviceConnection.hashCode()));
            if (iBinder != null) {
                iBinder.unlinkToDeath(deathRecipient, 0);
            }
            if (C5046bo.isNullOrNil(str2)) {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "unbindService() processName = %s", str);
                AppMethodBeat.m2505o(115290);
                return;
            }
            C4990ab.m7417i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s processName = %s", str2, str);
            C7053e.pXa.mo8378a(963, 46, 1, false);
            Intent intent2 = new Intent();
            intent2.putExtra("class_name", str2);
            intent2.putExtra("service_connection", serviceConnection.hashCode());
            C5080b c5080b = (C5080b) xFh.get(str);
            if (c5080b == null) {
                C7053e.pXa.mo8378a(963, 47, 1, false);
                Context context = C4996ah.getContext();
                C5091c.m7723h(context, str, intent);
                try {
                    final String str3 = str2;
                    final String str4 = str;
                    final Intent intent3 = intent2;
                    final boolean z2 = z;
                    final ServiceConnection serviceConnection2 = serviceConnection;
                    final Intent intent4 = intent;
                    boolean bindService = context.bindService(intent, new ServiceConnection() {
                        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            AppMethodBeat.m2504i(115283);
                            C4990ab.m7417i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected()", str3, str4);
                            C7053e.pXa.mo8378a(963, 48, 1, false);
                            if (iBinder == null) {
                                C4990ab.m7417i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() service == null", str3, str4);
                                AppMethodBeat.m2505o(115283);
                                return;
                            }
                            try {
                                C5080b N = C5081a.m7712N(iBinder);
                                N.mo10419aN(intent3);
                                C5091c.xFh.put(str4, N);
                                AppMethodBeat.m2505o(115283);
                            } catch (Exception e) {
                                C7053e.pXa.mo8378a(963, 49, 1, false);
                                C4990ab.m7417i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", str3, str4, e.getMessage(), C5046bo.dpG());
                                if (z2) {
                                    C7053e.pXa.mo8378a(963, 51, 1, false);
                                    C5091c.m7719a(serviceConnection2, str4, false, intent4);
                                }
                                AppMethodBeat.m2505o(115283);
                            }
                        }

                        public final void onServiceDisconnected(ComponentName componentName) {
                            AppMethodBeat.m2504i(115284);
                            C4990ab.m7417i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceDisconnected()", str3, str4);
                            C7053e.pXa.mo8378a(963, 50, 1, false);
                            C5091c.xFh.remove(str4);
                            AppMethodBeat.m2505o(115284);
                        }
                    }, 1);
                    C4990ab.m7417i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s bindService_result = %b", str2, str, Boolean.valueOf(bindService));
                    AppMethodBeat.m2505o(115290);
                    return;
                } catch (Exception e) {
                    C4990ab.m7417i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", str2, str, e.getMessage());
                    AppMethodBeat.m2505o(115290);
                    return;
                }
            }
            C7053e.pXa.mo8378a(963, 52, 1, false);
            try {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, unbindService() ClassName = %s ProcessName = %s ", str2, str);
                c5080b.mo10419aN(intent2);
                AppMethodBeat.m2505o(115290);
                return;
            } catch (Exception e2) {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s exception = %s stack[%s]", str2, str, e2.getMessage(), C5046bo.dpG());
                xFh.remove(str);
                if (z) {
                    C7053e.pXa.mo8378a(963, 51, 1, false);
                    z = false;
                } else {
                    AppMethodBeat.m2505o(115290);
                    return;
                }
            }
        }
        C4990ab.m7416i("MicroMsg.MMServiceHelper", "unbindService ServiceConnection == null");
        AppMethodBeat.m2505o(115290);
    }

    /* renamed from: a */
    public static void m7720a(final String str, final boolean z, final Intent intent) {
        AppMethodBeat.m2504i(115291);
        Context context = C4996ah.getContext();
        C5091c.m7723h(context, str, intent);
        C4990ab.m7417i("MicroMsg.MMServiceHelper", "startProcessService() processName = %s", str);
        context.bindService(intent, new ServiceConnection() {
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                AppMethodBeat.m2504i(115285);
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected()", str);
                if (iBinder == null) {
                    C4990ab.m7417i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected() service == null", str);
                    AppMethodBeat.m2505o(115285);
                    return;
                }
                C5091c.xFh.put(str, C5081a.m7712N(iBinder));
                AppMethodBeat.m2505o(115285);
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                AppMethodBeat.m2504i(115286);
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceDisconnected()", str);
                C7053e.pXa.mo8378a(963, 4, 1, false);
                C5091c.xFh.remove(str);
                if (z) {
                    C5091c.m7720a(str, false, intent);
                }
                AppMethodBeat.m2505o(115286);
            }
        }, 1);
        AppMethodBeat.m2505o(115291);
    }

    /* renamed from: h */
    private static void m7723h(Context context, String str, Intent intent) {
        AppMethodBeat.m2504i(115292);
        if (C5091c.anQ(str)) {
            try {
                context.startService(intent);
                AppMethodBeat.m2505o(115292);
                return;
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.MMServiceHelper", "startProcessService() Exception:%s %s", e.getClass().toString(), e.getMessage());
            }
        }
        AppMethodBeat.m2505o(115292);
    }

    private static boolean anQ(String str) {
        AppMethodBeat.m2504i(115293);
        if (!C5046bo.isEqual(str, "mm")) {
            AppMethodBeat.m2505o(115293);
            return false;
        } else if (C1443d.m3068iW(26)) {
            C4990ab.m7417i("MicroMsg.MMServiceHelper", "ifTarget26StartServiceHuawei() huaweiEnable : %s", Integer.valueOf(C4996ah.getContext().getSharedPreferences("service_launch_way", 4).getInt("huawei_switch", 0)));
            if (C5046bo.m7563gW(C4996ah.getContext().getSharedPreferences("service_launch_way", 4).getInt("huawei_switch", 0), 0)) {
                AppMethodBeat.m2505o(115293);
                return false;
            }
            AppMethodBeat.m2505o(115293);
            return true;
        } else {
            AppMethodBeat.m2505o(115293);
            return true;
        }
    }
}
