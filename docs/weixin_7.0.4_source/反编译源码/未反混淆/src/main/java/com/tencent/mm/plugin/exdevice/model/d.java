package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.de;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.e;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class d {
    private static int lrh = 0;
    c lrc;
    private w lrd;
    HashMap<Long, ap> lre;
    HashMap<Long, ap> lrf;
    HashMap<Long, Integer> lrg;
    private j lri = null;
    private Object lrj = new Object();

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ String lro;
        final /* synthetic */ boolean lrp;

        AnonymousClass5(String str, boolean z) {
            this.lro = str;
            this.lrp = z;
        }

        public final void run() {
            AppMethodBeat.i(19102);
            if (d.this.lrc == null) {
                d.this.lrc = new c();
                d.this.lrc.lwE = new a() {
                    public final void onServiceConnected() {
                        AppMethodBeat.i(19101);
                        d.this.lrc.lwE = null;
                        e.bpo().aB(AnonymousClass5.this.lro, AnonymousClass5.this.lrp);
                        AppMethodBeat.o(19101);
                    }
                };
                d.this.lrc.dH(ah.getContext());
                AppMethodBeat.o(19102);
                return;
            }
            e.bpo().aB(this.lro, this.lrp);
            AppMethodBeat.o(19102);
        }

        public final String toString() {
            AppMethodBeat.i(19103);
            String str = super.toString() + "|ranging";
            AppMethodBeat.o(19103);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$2 */
    class AnonymousClass2 extends a {
        final /* synthetic */ j lrl;

        AnonymousClass2(j jVar) {
            this.lrl = jVar;
            super(0);
        }

        public final void onServiceConnected() {
            AppMethodBeat.i(19098);
            if (!u.bpy().lqX.a(this.lrl)) {
                ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
            }
            AppMethodBeat.o(19098);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$3 */
    class AnonymousClass3 extends a {
        final /* synthetic */ long jGq;
        final /* synthetic */ k lrm;

        AnonymousClass3(long j, k kVar) {
            this.jGq = j;
            this.lrm = kVar;
            super(0);
        }

        public final void onServiceConnected() {
            AppMethodBeat.i(19099);
            if (!u.bpy().lqX.a(this.jGq, this.lrm)) {
                ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
            }
            AppMethodBeat.o(19099);
        }
    }

    public d() {
        AppMethodBeat.i(19111);
        if (this.lrd == null) {
            this.lrd = new w() {
                public final void a(long j, int i, int i2, int i3, long j2) {
                    AppMethodBeat.i(19108);
                    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", b.ie(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    if (ah.getContext() == null) {
                        ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
                        AppMethodBeat.o(19108);
                        return;
                    }
                    if (4 == i2) {
                        u.bpx().hW(j);
                        long[] Kt = com.tencent.mm.plugin.exdevice.h.a.Kt("shut_down_device");
                        if (!(Kt == null || Kt.length == 0)) {
                            for (long j3 : Kt) {
                                if (j3 == j) {
                                    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", Long.valueOf(j3));
                                    d.hH(j3);
                                    if (!com.tencent.mm.plugin.exdevice.h.a.E("shut_down_device", j3)) {
                                        ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
                                    }
                                }
                            }
                        }
                        if (d.this.lrg.get(Long.valueOf(j)) != null) {
                            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", d.this.lrg.get(Long.valueOf(j)));
                            de deVar = new de();
                            com.tencent.mm.sdk.b.a.xxA.m(deVar);
                            if (!(deVar.cwp.cgQ && (((Integer) d.this.lrg.get(Long.valueOf(j))).intValue() & 1) == 1)) {
                                d.hH(j);
                            }
                        } else {
                            d.hH(j);
                        }
                    }
                    if (i != i2) {
                        com.tencent.mm.plugin.exdevice.h.b Ku = ad.boW().Ku(String.valueOf(j));
                        if (Ku == null || bo.isNullOrNil(Ku.field_brandName)) {
                            ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", Long.valueOf(j));
                            AppMethodBeat.o(19108);
                            return;
                        }
                        f.a hT = u.bpx().hT(j);
                        if (hT != null) {
                            hT.cxs = i2;
                        } else {
                            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", Long.valueOf(j));
                        }
                        if (i2 == 2) {
                            ab.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                            AppMethodBeat.o(19108);
                            return;
                        }
                        ad.bph();
                        e.b(Ku.field_brandName, Ku.field_url, i2, Ku.field_deviceID);
                    }
                    AppMethodBeat.o(19108);
                }
            };
        }
        this.lre = new HashMap();
        this.lrf = new HashMap();
        this.lrg = new HashMap();
        AppMethodBeat.o(19111);
    }

    public static int boE() {
        return lrh;
    }

    public final synchronized void uI(int i) {
        AppMethodBeat.i(19112);
        ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", Integer.valueOf(i));
        lrh = i;
        AppMethodBeat.o(19112);
    }

    public final synchronized void a(Long l, int i) {
        AppMethodBeat.i(19113);
        this.lrg.put(l, Integer.valueOf(i));
        AppMethodBeat.o(19113);
    }

    public final void b(String str, long j, int i) {
        AppMethodBeat.i(19114);
        a(str, j, i, false);
        AppMethodBeat.o(19114);
    }

    public final void a(String str, long j, int i, boolean z) {
        AppMethodBeat.i(19115);
        com.tencent.mm.plugin.exdevice.h.a.E("shut_down_device", j);
        final String str2;
        final long j2;
        final boolean z2;
        if (this.lrc == null) {
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
            this.lrc = new c();
            str2 = str;
            j2 = j;
            z2 = z;
            this.lrc.lwE = new a(i) {
                public final void onServiceConnected() {
                    AppMethodBeat.i(19104);
                    d.this.lrc.lwE = null;
                    d.this.b(str2, j2, this.cxI, z2);
                    AppMethodBeat.o(19104);
                }
            };
            this.lrc.dH(ah.getContext());
            AppMethodBeat.o(19115);
        } else if (this.lrc == null || this.lrc.lwF) {
            b(str, j, i, z);
            AppMethodBeat.o(19115);
        } else {
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
            str2 = str;
            j2 = j;
            z2 = z;
            this.lrc.lwE = new a(i) {
                public final void onServiceConnected() {
                    AppMethodBeat.i(19105);
                    d.this.lrc.lwE = null;
                    d.this.b(str2, j2, this.cxI, z2);
                    AppMethodBeat.o(19105);
                }
            };
            this.lrc.dH(ah.getContext());
            AppMethodBeat.o(19115);
        }
    }

    public final void b(String str, long j, int i, boolean z) {
        boolean c;
        AppMethodBeat.i(19116);
        ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
        if (z) {
            c = c(str, j, i);
        } else {
            c = d(str, j, i);
        }
        ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", Boolean.valueOf(c));
        AppMethodBeat.o(19116);
    }

    public static void hH(long j) {
        AppMethodBeat.i(19117);
        if (u.bpy().lqX != null) {
            boolean hZ = u.bpy().lqX.hZ(j);
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", Long.valueOf(j), Boolean.valueOf(hZ));
        }
        AppMethodBeat.o(19117);
    }

    public final void boF() {
        AppMethodBeat.i(19118);
        if (this.lrc != null && this.lrc.lwF) {
            try {
                com.tencent.mm.bp.d.a(this.lrc, "exdevice");
                AppMethodBeat.o(19118);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(19118);
    }

    private synchronized boolean c(String str, long j, int i) {
        boolean z;
        AppMethodBeat.i(19119);
        int acS = aw.Rg().acS();
        if (acS != 4 && acS != 6) {
            ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            AppMethodBeat.o(19119);
            z = false;
        } else if (this.lrf.containsKey(Long.valueOf(j))) {
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", str, Long.valueOf(j));
            AppMethodBeat.o(19119);
            z = false;
        } else {
            final long j2 = j;
            final String str2 = str;
            final int i2 = i;
            ap apVar = new ap(Looper.getMainLooper(), new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(19106);
                    int hS = u.bpx().hS(j2);
                    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", str2, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(hS));
                    d.hH(j2);
                    d.this.lrf.remove(Long.valueOf(j2));
                    AppMethodBeat.o(19106);
                    return false;
                }
            }, false);
            long bqi = b.bqi();
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", Long.valueOf(bqi));
            apVar.ae(bqi, bqi);
            this.lrf.put(Long.valueOf(j), apVar);
            if (u.bpy().lqX != null) {
                ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", str, Long.valueOf(j));
                z = u.bpy().lqX.a(j, i, this.lrd);
                AppMethodBeat.o(19119);
            } else {
                ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
                AppMethodBeat.o(19119);
                z = false;
            }
        }
        return z;
    }

    private boolean d(String str, long j, int i) {
        AppMethodBeat.i(19120);
        if (aw.Rg().acS() != 4) {
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            AppMethodBeat.o(19120);
            return false;
        }
        if (this.lre.containsKey(Long.valueOf(j))) {
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", str, Long.valueOf(j), Integer.valueOf(i));
            ap apVar = (ap) this.lre.get(Long.valueOf(j));
            apVar.stopTimer();
            apVar.ae(30000, 30000);
        } else {
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", str, Long.valueOf(j), Integer.valueOf(i));
            final long j2 = j;
            final String str2 = str;
            final int i2 = i;
            ap apVar2 = new ap(Looper.getMainLooper(), new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(19107);
                    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", str2, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(u.bpx().hS(j2)));
                    if (u.bpx().hS(j2) != 2) {
                        ad.bph();
                        e.cc(str2, 2);
                    }
                    d.this.lre.remove(Long.valueOf(j2));
                    AppMethodBeat.o(19107);
                    return false;
                }
            }, false);
            apVar2.ae(30000, 30000);
            this.lre.put(Long.valueOf(j), apVar2);
        }
        if (u.bpy().lqX == null) {
            ab.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", str, Long.valueOf(j), Integer.valueOf(i));
            AppMethodBeat.o(19120);
            return false;
        }
        f.a hT = u.bpx().hT(j);
        if (hT == null) {
            ab.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", Long.valueOf(j));
            AppMethodBeat.o(19120);
            return false;
        }
        ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", Integer.valueOf(hT.cxs));
        if (!(hT.cxs == 2 || hT.cxs == 1)) {
            u.bpy().lqX.a(j, i, this.lrd);
        }
        AppMethodBeat.o(19120);
        return true;
    }

    public static boolean gL(boolean z) {
        AppMethodBeat.i(19121);
        if (u.bpy().lqX != null) {
            long[] bpl = u.bpy().lqX.bpl();
            if (bpl == null || bpl.length <= 0) {
                ab.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
                AppMethodBeat.o(19121);
                return false;
            }
            for (long j : bpl) {
                ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", Long.valueOf(j));
                com.tencent.mm.plugin.exdevice.h.b id = ad.boW().id(j);
                if (id == null) {
                    ab.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", Long.valueOf(j));
                } else if (z && (id.field_closeStrategy & 1) == 0) {
                    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", Long.valueOf(j));
                } else {
                    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", Long.valueOf(j));
                    u.bpy().lqX.hZ(j);
                }
            }
            AppMethodBeat.o(19121);
            return true;
        }
        ab.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
        AppMethodBeat.o(19121);
        return false;
    }

    public final void a(final int i, j jVar) {
        AppMethodBeat.i(19122);
        ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", Integer.valueOf(i));
        if (jVar == null) {
            ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
            AppMethodBeat.o(19122);
            return;
        }
        this.lri = jVar;
        if (this.lrc == null) {
            this.lrc = new c();
            this.lrc.lwE = new a(i) {
                public final void onServiceConnected() {
                    AppMethodBeat.i(19110);
                    if (!u.bpy().lqX.b(i, d.this.lri)) {
                        ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
                    }
                    AppMethodBeat.o(19110);
                }
            };
            this.lrc.dH(ah.getContext());
            AppMethodBeat.o(19122);
            return;
        }
        ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (u.bpy().lqX == null) {
            ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            AppMethodBeat.o(19122);
            return;
        }
        if (!u.bpy().lqX.b(i, this.lri)) {
            ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
        AppMethodBeat.o(19122);
    }

    public final void uJ(int i) {
        AppMethodBeat.i(19123);
        ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", Integer.valueOf(i));
        if (this.lrc == null) {
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            AppMethodBeat.o(19123);
        } else if (u.bpy().lqX == null) {
            ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            AppMethodBeat.o(19123);
        } else {
            if (!u.bpy().lqX.c(i, this.lri)) {
                ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            AppMethodBeat.o(19123);
        }
    }

    public final void T(final Runnable runnable) {
        AppMethodBeat.i(19124);
        ab.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
        if (this.lrc == null) {
            this.lrc = new c();
            this.lrc.lwE = new a() {
                public final void onServiceConnected() {
                    AppMethodBeat.i(19100);
                    runnable.run();
                    AppMethodBeat.o(19100);
                }
            };
            this.lrc.dH(ah.getContext());
            AppMethodBeat.o(19124);
            return;
        }
        this.lrc.U(runnable);
        AppMethodBeat.o(19124);
    }
}
