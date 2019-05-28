package com.tencent.mm.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.b.a;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static ConcurrentHashMap<String, b> xFh = new ConcurrentHashMap();
    private static Vector<Intent> xFi = new Vector();
    private static Vector<Intent> xFj = new Vector();
    private static ConcurrentHashMap<Integer, String> xFk = new ConcurrentHashMap();
    private static ConcurrentHashMap<Integer, IBinder> xFl = new ConcurrentHashMap();
    private static ConcurrentHashMap<Integer, DeathRecipient> xFm = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(115294);
        AppMethodBeat.o(115294);
    }

    public static void a(Intent intent, String str, boolean z, Intent intent2) {
        AppMethodBeat.i(115287);
        while (intent != null) {
            String className = intent.getComponent().getClassName();
            if (bo.isNullOrNil(className)) {
                ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = null processName = %s", str);
                AppMethodBeat.o(115287);
                return;
            }
            ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s", className, str);
            e.pXa.a(963, 0, 1, false);
            intent.putExtra("class_name", className);
            b bVar = (b) xFh.get(str);
            if (bVar == null) {
                e.pXa.a(963, 1, 1, false);
                xFi.add(intent);
                Context context = ah.getContext();
                h(context, str, intent2);
                try {
                    final String str2 = className;
                    final String str3 = str;
                    final Intent intent3 = intent;
                    final boolean z2 = z;
                    final Intent intent4 = intent2;
                    boolean bindService = context.bindService(intent2, new ServiceConnection() {
                        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            AppMethodBeat.i(115273);
                            ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected()", str2, str3);
                            e.pXa.a(963, 2, 1, false);
                            if (iBinder == null) {
                                ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected() service == null", str2, str3);
                                AppMethodBeat.o(115273);
                            } else if (c.xFi.contains(intent3)) {
                                try {
                                    b N = a.N(iBinder);
                                    N.aH(intent3);
                                    c.xFh.put(str3, N);
                                    c.xFi.remove(intent3);
                                    AppMethodBeat.o(115273);
                                } catch (Exception e) {
                                    e.pXa.a(963, 3, 1, false);
                                    ab.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", str2, str3, e.getMessage(), bo.dpG());
                                    if (z2) {
                                        e.pXa.a(963, 5, 1, false);
                                        c.a(intent3, str3, false, intent4);
                                    }
                                    c.xFi.remove(intent3);
                                    AppMethodBeat.o(115273);
                                } catch (Throwable th) {
                                    c.xFi.remove(intent3);
                                    AppMethodBeat.o(115273);
                                    throw th;
                                }
                            } else {
                                AppMethodBeat.o(115273);
                            }
                        }

                        public final void onServiceDisconnected(ComponentName componentName) {
                            AppMethodBeat.i(115274);
                            ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceDisconnected()", str2, str3);
                            e.pXa.a(963, 4, 1, false);
                            c.xFh.remove(str3);
                            AppMethodBeat.o(115274);
                        }
                    }, 1);
                    ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s bindService_result = %b", className, str, Boolean.valueOf(bindService));
                    AppMethodBeat.o(115287);
                    return;
                } catch (Exception e) {
                    ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", className, str, e.getMessage());
                    AppMethodBeat.o(115287);
                    return;
                }
            }
            e.pXa.a(963, 6, 1, false);
            try {
                ab.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, startService() ClassName = %s ProcessName = %s ", className, str);
                bVar.aH(intent);
                AppMethodBeat.o(115287);
                return;
            } catch (Exception e2) {
                ab.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", className, str, e2.getMessage(), bo.dpG());
                xFh.remove(str);
                if (z) {
                    e.pXa.a(963, 5, 1, false);
                    z = false;
                } else {
                    AppMethodBeat.o(115287);
                    return;
                }
            }
        }
        ab.i("MicroMsg.MMServiceHelper", "startService Intent == null");
        AppMethodBeat.o(115287);
    }

    public static void b(Intent intent, String str, boolean z, Intent intent2) {
        AppMethodBeat.i(115288);
        while (intent != null) {
            String className = intent.getComponent().getClassName();
            if (bo.isNullOrNil(className)) {
                ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = null processName = %s", str);
                AppMethodBeat.o(115288);
                return;
            }
            ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s", className, str);
            e.pXa.a(963, 16, 1, false);
            b bVar = (b) xFh.get(str);
            intent.putExtra("class_name", className);
            if (bVar == null) {
                e.pXa.a(963, 17, 1, false);
                Context context = ah.getContext();
                h(context, str, intent2);
                try {
                    final String str2 = className;
                    final String str3 = str;
                    final Intent intent3 = intent;
                    final boolean z2 = z;
                    final Intent intent4 = intent2;
                    boolean bindService = context.bindService(intent2, new ServiceConnection() {
                        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            AppMethodBeat.i(115275);
                            ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected()", str2, str3);
                            e.pXa.a(963, 18, 1, false);
                            if (iBinder == null) {
                                ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected() service == null", str2, str3);
                                AppMethodBeat.o(115275);
                                return;
                            }
                            try {
                                b N = a.N(iBinder);
                                N.aI(intent3);
                                c.xFh.put(str3, N);
                                AppMethodBeat.o(115275);
                            } catch (Exception e) {
                                ab.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", str2, str3, e.getMessage(), bo.dpG());
                                e.pXa.a(963, 19, 1, false);
                                if (z2) {
                                    e.pXa.a(963, 21, 1, false);
                                    c.b(intent3, str3, false, intent4);
                                }
                                AppMethodBeat.o(115275);
                            }
                        }

                        public final void onServiceDisconnected(ComponentName componentName) {
                            AppMethodBeat.i(115276);
                            ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceDisconnected()", str2, str3);
                            e.pXa.a(963, 20, 1, false);
                            c.xFh.remove(str3);
                            AppMethodBeat.o(115276);
                        }
                    }, 1);
                    ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s bindService_result = %b", className, str, Boolean.valueOf(bindService));
                    AppMethodBeat.o(115288);
                    return;
                } catch (Exception e) {
                    ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", className, str, e.getMessage());
                    AppMethodBeat.o(115288);
                    return;
                }
            }
            e.pXa.a(963, 22, 1, false);
            try {
                ab.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, stopService() ClassName = %s ProcessName = %s stack[%s]", className, str, bo.dpG());
                bVar.aI(intent);
                AppMethodBeat.o(115288);
                return;
            } catch (Exception e2) {
                ab.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s exception = %s", className, str, e2.getMessage());
                xFh.remove(str);
                if (z) {
                    e.pXa.a(963, 21, 1, false);
                    z = false;
                } else {
                    AppMethodBeat.o(115288);
                    return;
                }
            }
        }
        ab.i("MicroMsg.MMServiceHelper", "stopService Intent == null");
        AppMethodBeat.o(115288);
    }

    public static boolean a(Intent intent, final ServiceConnection serviceConnection, int i, final String str, boolean z, final Intent intent2) {
        AppMethodBeat.i(115289);
        if (intent == null) {
            ab.i("MicroMsg.MMServiceHelper", "bindService Intent == null");
            AppMethodBeat.o(115289);
            return false;
        }
        final String className = intent.getComponent().getClassName();
        if (bo.isNullOrNil(className)) {
            ab.i("MicroMsg.MMServiceHelper", "bindService() processName = %s", str);
            AppMethodBeat.o(115289);
            return false;
        }
        ab.i("MicroMsg.MMServiceHelper", "bindService() ClassName = %s ProcessName = %s", className, str);
        e.pXa.a(963, 31, 1, false);
        b bVar = (b) xFh.get(str);
        intent.putExtra("class_name", className);
        intent.putExtra("service_connection", serviceConnection.hashCode());
        xFk.put(Integer.valueOf(serviceConnection.hashCode()), className);
        if (bVar == null) {
            e.pXa.a(963, 32, 1, false);
            xFj.add(intent);
            Context context = ah.getContext();
            h(context, str, intent2);
            try {
                final Intent intent3 = intent2;
                final String str2 = className;
                final String str3 = str;
                final Intent intent4 = intent;
                final ServiceConnection serviceConnection2 = serviceConnection;
                final boolean z2 = z;
                final int i2 = i;
                boolean bindService = context.bindService(intent2, new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        AppMethodBeat.i(115279);
                        ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected()", intent3.getComponent().getClassName(), str2, str3);
                        e.pXa.a(963, 33, 1, false);
                        if (!c.xFj.contains(intent4)) {
                            AppMethodBeat.o(115279);
                        } else if (iBinder == null) {
                            ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() service == null", intent3.getComponent().getClassName(), str2, str3);
                            AppMethodBeat.o(115279);
                        } else {
                            try {
                                b N = a.N(iBinder);
                                N.a(intent4, new a.a() {
                                    public final void M(IBinder iBinder) {
                                        AppMethodBeat.i(115278);
                                        if (iBinder == null) {
                                            ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected() service == null", intent3.getComponent().getClassName(), str2, str3);
                                            AppMethodBeat.o(115278);
                                            return;
                                        }
                                        ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", intent3.getComponent().getClassName(), str2, str3);
                                        serviceConnection2.onServiceConnected(new ComponentName(ah.getContext(), str2), iBinder);
                                        c.xFl.put(Integer.valueOf(serviceConnection2.hashCode()), iBinder);
                                        AnonymousClass1 anonymousClass1 = new DeathRecipient() {
                                            public final void binderDied() {
                                                AppMethodBeat.i(115277);
                                                ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", intent3.getComponent().getClassName(), str2, str3);
                                                serviceConnection2.onServiceDisconnected(new ComponentName(ah.getContext(), str2));
                                                AppMethodBeat.o(115277);
                                            }
                                        };
                                        c.xFm.put(Integer.valueOf(serviceConnection2.hashCode()), anonymousClass1);
                                        iBinder.linkToDeath(anonymousClass1, 0);
                                        AppMethodBeat.o(115278);
                                    }
                                });
                                c.xFh.put(str3, N);
                                c.xFj.remove(intent4);
                                AppMethodBeat.o(115279);
                            } catch (Exception e) {
                                ab.i("MicroMsg.MMServiceHelper", "bindService()  ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", intent3.getComponent().getClassName(), str2, str3, e.getMessage(), bo.dpG());
                                e.pXa.a(963, 34, 1, false);
                                if (z2) {
                                    e.pXa.a(963, 36, 1, false);
                                    c.a(intent4, serviceConnection2, i2, str3, false, intent3);
                                }
                                c.xFj.remove(intent4);
                                AppMethodBeat.o(115279);
                            } catch (Throwable th) {
                                c.xFj.remove(intent4);
                                AppMethodBeat.o(115279);
                                throw th;
                            }
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        AppMethodBeat.i(115280);
                        ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceDisconnected()", intent3.getComponent().getClassName(), str2, str3);
                        e.pXa.a(963, 35, 1, false);
                        c.xFh.remove(str3);
                        AppMethodBeat.o(115280);
                    }
                }, 1);
                ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s bindService_result = %b", intent2.getComponent().getClassName(), className, str, Boolean.valueOf(bindService));
            } catch (Exception e) {
                ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s Context.bindService() Exception = %s", intent2.getComponent().getClassName(), className, str, e.getMessage());
            }
        } else {
            e.pXa.a(963, 37, 1, false);
            try {
                ab.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, bindService() ClassName = %s ProcessName = %s ", className, str);
                bVar.a(intent, new a.a() {
                    public final void M(IBinder iBinder) {
                        AppMethodBeat.i(115282);
                        ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", intent2.getComponent().getClassName(), className, str);
                        if (iBinder == null) {
                            AppMethodBeat.o(115282);
                            return;
                        }
                        serviceConnection.onServiceConnected(new ComponentName(ah.getContext(), className), iBinder);
                        c.xFl.put(Integer.valueOf(serviceConnection.hashCode()), iBinder);
                        iBinder.linkToDeath(new DeathRecipient() {
                            public final void binderDied() {
                                AppMethodBeat.i(115281);
                                ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", intent2.getComponent().getClassName(), className, str);
                                serviceConnection.onServiceDisconnected(new ComponentName(ah.getContext(), className));
                                AppMethodBeat.o(115281);
                            }
                        }, 0);
                        AppMethodBeat.o(115282);
                    }
                });
            } catch (Exception e2) {
                ab.i("MicroMsg.MMServiceHelper", "bindService ClassName = %s ProcessName = %s exception = %s stack[%s]", className, str, e2.getMessage(), bo.dpG());
                xFh.remove(str);
                if (z) {
                    e.pXa.a(963, 36, 1, false);
                    a(intent, serviceConnection, i, str, false, intent2);
                }
            }
        }
        AppMethodBeat.o(115289);
        return true;
    }

    public static void a(ServiceConnection serviceConnection, String str, boolean z, Intent intent) {
        AppMethodBeat.i(115290);
        while (serviceConnection != null) {
            String str2 = (String) xFk.remove(Integer.valueOf(serviceConnection.hashCode()));
            IBinder iBinder = (IBinder) xFl.remove(Integer.valueOf(serviceConnection.hashCode()));
            DeathRecipient deathRecipient = (DeathRecipient) xFm.remove(Integer.valueOf(serviceConnection.hashCode()));
            if (iBinder != null) {
                iBinder.unlinkToDeath(deathRecipient, 0);
            }
            if (bo.isNullOrNil(str2)) {
                ab.i("MicroMsg.MMServiceHelper", "unbindService() processName = %s", str);
                AppMethodBeat.o(115290);
                return;
            }
            ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s processName = %s", str2, str);
            e.pXa.a(963, 46, 1, false);
            Intent intent2 = new Intent();
            intent2.putExtra("class_name", str2);
            intent2.putExtra("service_connection", serviceConnection.hashCode());
            b bVar = (b) xFh.get(str);
            if (bVar == null) {
                e.pXa.a(963, 47, 1, false);
                Context context = ah.getContext();
                h(context, str, intent);
                try {
                    final String str3 = str2;
                    final String str4 = str;
                    final Intent intent3 = intent2;
                    final boolean z2 = z;
                    final ServiceConnection serviceConnection2 = serviceConnection;
                    final Intent intent4 = intent;
                    boolean bindService = context.bindService(intent, new ServiceConnection() {
                        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            AppMethodBeat.i(115283);
                            ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected()", str3, str4);
                            e.pXa.a(963, 48, 1, false);
                            if (iBinder == null) {
                                ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() service == null", str3, str4);
                                AppMethodBeat.o(115283);
                                return;
                            }
                            try {
                                b N = a.N(iBinder);
                                N.aN(intent3);
                                c.xFh.put(str4, N);
                                AppMethodBeat.o(115283);
                            } catch (Exception e) {
                                e.pXa.a(963, 49, 1, false);
                                ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", str3, str4, e.getMessage(), bo.dpG());
                                if (z2) {
                                    e.pXa.a(963, 51, 1, false);
                                    c.a(serviceConnection2, str4, false, intent4);
                                }
                                AppMethodBeat.o(115283);
                            }
                        }

                        public final void onServiceDisconnected(ComponentName componentName) {
                            AppMethodBeat.i(115284);
                            ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceDisconnected()", str3, str4);
                            e.pXa.a(963, 50, 1, false);
                            c.xFh.remove(str4);
                            AppMethodBeat.o(115284);
                        }
                    }, 1);
                    ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s bindService_result = %b", str2, str, Boolean.valueOf(bindService));
                    AppMethodBeat.o(115290);
                    return;
                } catch (Exception e) {
                    ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", str2, str, e.getMessage());
                    AppMethodBeat.o(115290);
                    return;
                }
            }
            e.pXa.a(963, 52, 1, false);
            try {
                ab.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, unbindService() ClassName = %s ProcessName = %s ", str2, str);
                bVar.aN(intent2);
                AppMethodBeat.o(115290);
                return;
            } catch (Exception e2) {
                ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s exception = %s stack[%s]", str2, str, e2.getMessage(), bo.dpG());
                xFh.remove(str);
                if (z) {
                    e.pXa.a(963, 51, 1, false);
                    z = false;
                } else {
                    AppMethodBeat.o(115290);
                    return;
                }
            }
        }
        ab.i("MicroMsg.MMServiceHelper", "unbindService ServiceConnection == null");
        AppMethodBeat.o(115290);
    }

    public static void a(final String str, final boolean z, final Intent intent) {
        AppMethodBeat.i(115291);
        Context context = ah.getContext();
        h(context, str, intent);
        ab.i("MicroMsg.MMServiceHelper", "startProcessService() processName = %s", str);
        context.bindService(intent, new ServiceConnection() {
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                AppMethodBeat.i(115285);
                ab.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected()", str);
                if (iBinder == null) {
                    ab.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected() service == null", str);
                    AppMethodBeat.o(115285);
                    return;
                }
                c.xFh.put(str, a.N(iBinder));
                AppMethodBeat.o(115285);
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                AppMethodBeat.i(115286);
                ab.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceDisconnected()", str);
                e.pXa.a(963, 4, 1, false);
                c.xFh.remove(str);
                if (z) {
                    c.a(str, false, intent);
                }
                AppMethodBeat.o(115286);
            }
        }, 1);
        AppMethodBeat.o(115291);
    }

    private static void h(Context context, String str, Intent intent) {
        AppMethodBeat.i(115292);
        if (anQ(str)) {
            try {
                context.startService(intent);
                AppMethodBeat.o(115292);
                return;
            } catch (Exception e) {
                ab.i("MicroMsg.MMServiceHelper", "startProcessService() Exception:%s %s", e.getClass().toString(), e.getMessage());
            }
        }
        AppMethodBeat.o(115292);
    }

    private static boolean anQ(String str) {
        AppMethodBeat.i(115293);
        if (!bo.isEqual(str, "mm")) {
            AppMethodBeat.o(115293);
            return false;
        } else if (d.iW(26)) {
            ab.i("MicroMsg.MMServiceHelper", "ifTarget26StartServiceHuawei() huaweiEnable : %s", Integer.valueOf(ah.getContext().getSharedPreferences("service_launch_way", 4).getInt("huawei_switch", 0)));
            if (bo.gW(ah.getContext().getSharedPreferences("service_launch_way", 4).getInt("huawei_switch", 0), 0)) {
                AppMethodBeat.o(115293);
                return false;
            }
            AppMethodBeat.o(115293);
            return true;
        } else {
            AppMethodBeat.o(115293);
            return true;
        }
    }
}
