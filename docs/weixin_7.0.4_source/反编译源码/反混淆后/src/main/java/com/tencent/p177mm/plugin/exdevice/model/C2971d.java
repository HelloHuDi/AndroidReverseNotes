package com.tencent.p177mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C41974de;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.exdevice.model.C34034c.C34035a;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.plugin.exdevice.p956h.C27836a;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.plugin.exdevice.service.C20550w;
import com.tencent.p177mm.plugin.exdevice.service.C27859f.C27860a;
import com.tencent.p177mm.plugin.exdevice.service.C2988e;
import com.tencent.p177mm.plugin.exdevice.service.C34050c;
import com.tencent.p177mm.plugin.exdevice.service.C34050c.C27858a;
import com.tencent.p177mm.plugin.exdevice.service.C38959k;
import com.tencent.p177mm.plugin.exdevice.service.C43000j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.exdevice.model.d */
public final class C2971d {
    private static int lrh = 0;
    C34050c lrc;
    private C20550w lrd;
    HashMap<Long, C7564ap> lre;
    HashMap<Long, C7564ap> lrf;
    HashMap<Long, Integer> lrg;
    private C43000j lri = null;
    private Object lrj = new Object();

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$5 */
    class C29725 implements Runnable {
        final /* synthetic */ String lro;
        final /* synthetic */ boolean lrp;

        /* renamed from: com.tencent.mm.plugin.exdevice.model.d$5$1 */
        class C29731 extends C27858a {
            C29731() {
                super(0);
            }

            public final void onServiceConnected() {
                AppMethodBeat.m2504i(19101);
                C2971d.this.lrc.lwE = null;
                C2988e.bpo().mo7192aB(C29725.this.lro, C29725.this.lrp);
                AppMethodBeat.m2505o(19101);
            }
        }

        C29725(String str, boolean z) {
            this.lro = str;
            this.lrp = z;
        }

        public final void run() {
            AppMethodBeat.m2504i(19102);
            if (C2971d.this.lrc == null) {
                C2971d.this.lrc = new C34050c();
                C2971d.this.lrc.lwE = new C29731();
                C2971d.this.lrc.mo54583dH(C4996ah.getContext());
                AppMethodBeat.m2505o(19102);
                return;
            }
            C2988e.bpo().mo7192aB(this.lro, this.lrp);
            AppMethodBeat.m2505o(19102);
        }

        public final String toString() {
            AppMethodBeat.m2504i(19103);
            String str = super.toString() + "|ranging";
            AppMethodBeat.m2505o(19103);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$10 */
    class C297710 extends C20550w {
        C297710() {
        }

        /* renamed from: a */
        public final void mo7187a(long j, int i, int i2, int i3, long j2) {
            AppMethodBeat.m2504i(19108);
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", C42992b.m76358ie(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            if (C4996ah.getContext() == null) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
                AppMethodBeat.m2505o(19108);
                return;
            }
            if (4 == i2) {
                C20548u.bpx().mo45724hW(j);
                long[] Kt = C27836a.m44245Kt("shut_down_device");
                if (!(Kt == null || Kt.length == 0)) {
                    for (long j3 : Kt) {
                        if (j3 == j) {
                            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", Long.valueOf(j3));
                            C2971d.m5266hH(j3);
                            if (!C27836a.m44244E("shut_down_device", j3)) {
                                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
                            }
                        }
                    }
                }
                if (C2971d.this.lrg.get(Long.valueOf(j)) != null) {
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", C2971d.this.lrg.get(Long.valueOf(j)));
                    C41974de c41974de = new C41974de();
                    C4879a.xxA.mo10055m(c41974de);
                    if (!(c41974de.cwp.cgQ && (((Integer) C2971d.this.lrg.get(Long.valueOf(j))).intValue() & 1) == 1)) {
                        C2971d.m5266hH(j);
                    }
                } else {
                    C2971d.m5266hH(j);
                }
            }
            if (i != i2) {
                C11648b Ku = C45891ad.boW().mo45700Ku(String.valueOf(j));
                if (Ku == null || C5046bo.isNullOrNil(Ku.field_brandName)) {
                    C4990ab.m7413e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", Long.valueOf(j));
                    AppMethodBeat.m2505o(19108);
                    return;
                }
                C27860a hT = C20548u.bpx().mo45721hT(j);
                if (hT != null) {
                    hT.cxs = i2;
                } else {
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", Long.valueOf(j));
                }
                if (i2 == 2) {
                    C4990ab.m7420w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                    AppMethodBeat.m2505o(19108);
                    return;
                }
                C45891ad.bph();
                C20495e.m31663b(Ku.field_brandName, Ku.field_url, i2, Ku.field_deviceID);
            }
            AppMethodBeat.m2505o(19108);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$2 */
    class C29802 extends C27858a {
        final /* synthetic */ C43000j lrl;

        C29802(C43000j c43000j) {
            this.lrl = c43000j;
            super(0);
        }

        public final void onServiceConnected() {
            AppMethodBeat.m2504i(19098);
            if (!C20548u.bpy().lqX.mo45754a(this.lrl)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
            }
            AppMethodBeat.m2505o(19098);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$3 */
    class C29813 extends C27858a {
        final /* synthetic */ long jGq;
        final /* synthetic */ C38959k lrm;

        C29813(long j, C38959k c38959k) {
            this.jGq = j;
            this.lrm = c38959k;
            super(0);
        }

        public final void onServiceConnected() {
            AppMethodBeat.m2504i(19099);
            if (!C20548u.bpy().lqX.mo45753a(this.jGq, this.lrm)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
            }
            AppMethodBeat.m2505o(19099);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$11 */
    class C298311 extends C27858a {
        C298311() {
            super(0);
        }

        public final void onServiceConnected() {
            AppMethodBeat.m2504i(19109);
            C4990ab.m7410d("MicroMsg.exdevice.ExdeviceConnectManager", "onServiceConnected");
            AppMethodBeat.m2505o(19109);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$1 */
    class C29841 implements C34035a {
        C29841() {
        }

        public final void boD() {
            AppMethodBeat.m2504i(19097);
            if (C2971d.this.lrc == null) {
                C2971d.this.lrc = new C34050c();
                C2971d.this.lrc.lwE = null;
            }
            C2971d.this.lrc.mo54583dH(C4996ah.getContext());
            AppMethodBeat.m2505o(19097);
        }
    }

    public C2971d() {
        AppMethodBeat.m2504i(19111);
        if (this.lrd == null) {
            this.lrd = new C297710();
        }
        this.lre = new HashMap();
        this.lrf = new HashMap();
        this.lrg = new HashMap();
        AppMethodBeat.m2505o(19111);
    }

    public static int boE() {
        return lrh;
    }

    /* renamed from: uI */
    public final synchronized void mo7182uI(int i) {
        AppMethodBeat.m2504i(19112);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", Integer.valueOf(i));
        lrh = i;
        AppMethodBeat.m2505o(19112);
    }

    /* renamed from: a */
    public final synchronized void mo7177a(Long l, int i) {
        AppMethodBeat.m2504i(19113);
        this.lrg.put(l, Integer.valueOf(i));
        AppMethodBeat.m2505o(19113);
    }

    /* renamed from: b */
    public final void mo7179b(String str, long j, int i) {
        AppMethodBeat.m2504i(19114);
        mo7178a(str, j, i, false);
        AppMethodBeat.m2505o(19114);
    }

    /* renamed from: a */
    public final void mo7178a(String str, long j, int i, boolean z) {
        AppMethodBeat.m2504i(19115);
        C27836a.m44244E("shut_down_device", j);
        final String str2;
        final long j2;
        final boolean z2;
        if (this.lrc == null) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
            this.lrc = new C34050c();
            str2 = str;
            j2 = j;
            z2 = z;
            this.lrc.lwE = new C27858a(i) {
                public final void onServiceConnected() {
                    AppMethodBeat.m2504i(19104);
                    C2971d.this.lrc.lwE = null;
                    C2971d.this.mo7180b(str2, j2, this.cxI, z2);
                    AppMethodBeat.m2505o(19104);
                }
            };
            this.lrc.mo54583dH(C4996ah.getContext());
            AppMethodBeat.m2505o(19115);
        } else if (this.lrc == null || this.lrc.lwF) {
            mo7180b(str, j, i, z);
            AppMethodBeat.m2505o(19115);
        } else {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
            str2 = str;
            j2 = j;
            z2 = z;
            this.lrc.lwE = new C27858a(i) {
                public final void onServiceConnected() {
                    AppMethodBeat.m2504i(19105);
                    C2971d.this.lrc.lwE = null;
                    C2971d.this.mo7180b(str2, j2, this.cxI, z2);
                    AppMethodBeat.m2505o(19105);
                }
            };
            this.lrc.mo54583dH(C4996ah.getContext());
            AppMethodBeat.m2505o(19115);
        }
    }

    /* renamed from: b */
    public final void mo7180b(String str, long j, int i, boolean z) {
        boolean c;
        AppMethodBeat.m2504i(19116);
        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
        if (z) {
            c = m5261c(str, j, i);
        } else {
            c = m5263d(str, j, i);
        }
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", Boolean.valueOf(c));
        AppMethodBeat.m2505o(19116);
    }

    /* renamed from: hH */
    public static void m5266hH(long j) {
        AppMethodBeat.m2504i(19117);
        if (C20548u.bpy().lqX != null) {
            boolean hZ = C20548u.bpy().lqX.mo45761hZ(j);
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", Long.valueOf(j), Boolean.valueOf(hZ));
        }
        AppMethodBeat.m2505o(19117);
    }

    public final void boF() {
        AppMethodBeat.m2504i(19118);
        if (this.lrc != null && this.lrc.lwF) {
            try {
                C25985d.m41456a(this.lrc, "exdevice");
                AppMethodBeat.m2505o(19118);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(19118);
    }

    /* renamed from: c */
    private synchronized boolean m5261c(String str, long j, int i) {
        boolean z;
        AppMethodBeat.m2504i(19119);
        int acS = C9638aw.m17182Rg().acS();
        if (acS != 4 && acS != 6) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            AppMethodBeat.m2505o(19119);
            z = false;
        } else if (this.lrf.containsKey(Long.valueOf(j))) {
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", str, Long.valueOf(j));
            AppMethodBeat.m2505o(19119);
            z = false;
        } else {
            final long j2 = j;
            final String str2 = str;
            final int i2 = i;
            C7564ap c7564ap = new C7564ap(Looper.getMainLooper(), new C5015a() {
                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(19106);
                    int hS = C20548u.bpx().mo45720hS(j2);
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", str2, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(hS));
                    C2971d.m5266hH(j2);
                    C2971d.this.lrf.remove(Long.valueOf(j2));
                    AppMethodBeat.m2505o(19106);
                    return false;
                }
            }, false);
            long bqi = C42992b.bqi();
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", Long.valueOf(bqi));
            c7564ap.mo16770ae(bqi, bqi);
            this.lrf.put(Long.valueOf(j), c7564ap);
            if (C20548u.bpy().lqX != null) {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", str, Long.valueOf(j));
                z = C20548u.bpy().lqX.mo45752a(j, i, this.lrd);
                AppMethodBeat.m2505o(19119);
            } else {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
                AppMethodBeat.m2505o(19119);
                z = false;
            }
        }
        return z;
    }

    /* renamed from: d */
    private boolean m5263d(String str, long j, int i) {
        AppMethodBeat.m2504i(19120);
        if (C9638aw.m17182Rg().acS() != 4) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            AppMethodBeat.m2505o(19120);
            return false;
        }
        if (this.lre.containsKey(Long.valueOf(j))) {
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", str, Long.valueOf(j), Integer.valueOf(i));
            C7564ap c7564ap = (C7564ap) this.lre.get(Long.valueOf(j));
            c7564ap.stopTimer();
            c7564ap.mo16770ae(30000, 30000);
        } else {
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", str, Long.valueOf(j), Integer.valueOf(i));
            final long j2 = j;
            final String str2 = str;
            final int i2 = i;
            C7564ap c7564ap2 = new C7564ap(Looper.getMainLooper(), new C5015a() {
                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(19107);
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", str2, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(C20548u.bpx().mo45720hS(j2)));
                    if (C20548u.bpx().mo45720hS(j2) != 2) {
                        C45891ad.bph();
                        C20495e.m31665cc(str2, 2);
                    }
                    C2971d.this.lre.remove(Long.valueOf(j2));
                    AppMethodBeat.m2505o(19107);
                    return false;
                }
            }, false);
            c7564ap2.mo16770ae(30000, 30000);
            this.lre.put(Long.valueOf(j), c7564ap2);
        }
        if (C20548u.bpy().lqX == null) {
            C4990ab.m7421w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", str, Long.valueOf(j), Integer.valueOf(i));
            AppMethodBeat.m2505o(19120);
            return false;
        }
        C27860a hT = C20548u.bpx().mo45721hT(j);
        if (hT == null) {
            C4990ab.m7421w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", Long.valueOf(j));
            AppMethodBeat.m2505o(19120);
            return false;
        }
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", Integer.valueOf(hT.cxs));
        if (!(hT.cxs == 2 || hT.cxs == 1)) {
            C20548u.bpy().lqX.mo45752a(j, i, this.lrd);
        }
        AppMethodBeat.m2505o(19120);
        return true;
    }

    /* renamed from: gL */
    public static boolean m5265gL(boolean z) {
        AppMethodBeat.m2504i(19121);
        if (C20548u.bpy().lqX != null) {
            long[] bpl = C20548u.bpy().lqX.bpl();
            if (bpl == null || bpl.length <= 0) {
                C4990ab.m7420w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
                AppMethodBeat.m2505o(19121);
                return false;
            }
            for (long j : bpl) {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", Long.valueOf(j));
                C11648b id = C45891ad.boW().mo45710id(j);
                if (id == null) {
                    C4990ab.m7421w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", Long.valueOf(j));
                } else if (z && (id.field_closeStrategy & 1) == 0) {
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", Long.valueOf(j));
                } else {
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", Long.valueOf(j));
                    C20548u.bpy().lqX.mo45761hZ(j);
                }
            }
            AppMethodBeat.m2505o(19121);
            return true;
        }
        C4990ab.m7420w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
        AppMethodBeat.m2505o(19121);
        return false;
    }

    /* renamed from: a */
    public final void mo7176a(final int i, C43000j c43000j) {
        AppMethodBeat.m2504i(19122);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", Integer.valueOf(i));
        if (c43000j == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
            AppMethodBeat.m2505o(19122);
            return;
        }
        this.lri = c43000j;
        if (this.lrc == null) {
            this.lrc = new C34050c();
            this.lrc.lwE = new C27858a(i) {
                public final void onServiceConnected() {
                    AppMethodBeat.m2504i(19110);
                    if (!C20548u.bpy().lqX.mo45756b(i, C2971d.this.lri)) {
                        C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
                    }
                    AppMethodBeat.m2505o(19110);
                }
            };
            this.lrc.mo54583dH(C4996ah.getContext());
            AppMethodBeat.m2505o(19122);
            return;
        }
        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (C20548u.bpy().lqX == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            AppMethodBeat.m2505o(19122);
            return;
        }
        if (!C20548u.bpy().lqX.mo45756b(i, this.lri)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
        AppMethodBeat.m2505o(19122);
    }

    /* renamed from: uJ */
    public final void mo7183uJ(int i) {
        AppMethodBeat.m2504i(19123);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", Integer.valueOf(i));
        if (this.lrc == null) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            AppMethodBeat.m2505o(19123);
        } else if (C20548u.bpy().lqX == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            AppMethodBeat.m2505o(19123);
        } else {
            if (!C20548u.bpy().lqX.mo45760c(i, this.lri)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            AppMethodBeat.m2505o(19123);
        }
    }

    /* renamed from: T */
    public final void mo7175T(final Runnable runnable) {
        AppMethodBeat.m2504i(19124);
        C4990ab.m7410d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
        if (this.lrc == null) {
            this.lrc = new C34050c();
            this.lrc.lwE = new C27858a() {
                public final void onServiceConnected() {
                    AppMethodBeat.m2504i(19100);
                    runnable.run();
                    AppMethodBeat.m2505o(19100);
                }
            };
            this.lrc.mo54583dH(C4996ah.getContext());
            AppMethodBeat.m2505o(19124);
            return;
        }
        this.lrc.mo54582U(runnable);
        AppMethodBeat.m2505o(19124);
    }
}
