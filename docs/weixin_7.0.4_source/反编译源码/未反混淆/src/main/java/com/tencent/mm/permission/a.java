package com.tencent.mm.permission;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class a {
    static final String ceI;
    static final String ceJ;
    static Map<Integer, a> ggv;
    c ggw = new c<mh>() {
        {
            AppMethodBeat.i(16635);
            this.xxI = mh.class.getName().hashCode();
            AppMethodBeat.o(16635);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(16636);
            mh mhVar = (mh) bVar;
            if (true == mhVar.cIh.cIj) {
                if (!a.mI(mhVar.cIh.type)) {
                    if (com.tencent.mm.compatible.f.a.euv == null) {
                        ArrayList<com.tencent.mm.compatible.f.a.b> arrayList = new ArrayList();
                        ArrayList<com.tencent.mm.compatible.f.a.a> arrayList2 = new ArrayList();
                        com.tencent.mm.compatible.f.a.a(e.eSj + "permissioncfg.cfg", arrayList, arrayList2);
                        PInt pInt = new PInt(0);
                        PBool pBool = new PBool();
                        for (com.tencent.mm.compatible.f.a.b bVar2 : arrayList) {
                            pInt.value = 0;
                            pBool.value = true;
                            if (com.tencent.mm.compatible.f.a.a(Build.MANUFACTURER, bVar2.euA, pInt, pBool) && com.tencent.mm.compatible.f.a.a(Build.MODEL, bVar2.model, pInt, pBool)) {
                                com.tencent.mm.compatible.f.a.a(VERSION.RELEASE, bVar2.version, pInt, pBool);
                            }
                            if (pBool.value && pInt.value > 0) {
                                com.tencent.mm.compatible.f.a.euv = Boolean.valueOf(1 == bVar2.euy);
                            }
                        }
                        if (com.tencent.mm.compatible.f.a.euv == null || true != com.tencent.mm.compatible.f.a.euv.booleanValue()) {
                            HashSet hashSet = new HashSet();
                            PackageManager packageManager = ah.getContext().getPackageManager();
                            List list;
                            if (packageManager == null) {
                                list = null;
                            } else {
                                list = packageManager.getInstalledPackages(0);
                            }
                            for (PackageInfo packageInfo : list) {
                                for (com.tencent.mm.compatible.f.a.a aVar : arrayList2) {
                                    pInt.value = 0;
                                    pBool.value = true;
                                    if (com.tencent.mm.compatible.f.a.a(packageInfo.packageName, aVar.ceO, pInt, pBool)) {
                                        if (aVar.euw == 0 && aVar.eux == 0) {
                                            pBool.value = true;
                                        } else if (aVar.euw > packageInfo.versionCode || aVar.eux < packageInfo.versionCode) {
                                            pBool.value = false;
                                        } else {
                                            pInt.value++;
                                            pBool.value = true;
                                        }
                                    }
                                    if (pBool.value && pInt.value > 0) {
                                        boolean z;
                                        if (1 == aVar.euy) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        com.tencent.mm.compatible.f.a.euv = Boolean.valueOf(z);
                                    }
                                }
                                if (com.tencent.mm.compatible.f.a.euv != null && true == com.tencent.mm.compatible.f.a.euv.booleanValue()) {
                                    break;
                                }
                            }
                            if (com.tencent.mm.compatible.f.a.euv == null) {
                                com.tencent.mm.compatible.f.a.euv = Boolean.FALSE;
                            }
                        }
                    }
                    if (com.tencent.mm.compatible.f.a.euv.booleanValue()) {
                        mhVar.cIi.cIl = a.D(mhVar.cIh.type, true);
                    }
                }
                mhVar.cIi.cIl = false;
            } else {
                mhVar.cIi.cIl = false;
            }
            AppMethodBeat.o(16636);
            return false;
        }
    };
    private c ggx = new c<mi>() {
        {
            AppMethodBeat.i(16637);
            this.xxI = mi.class.getName().hashCode();
            AppMethodBeat.o(16637);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(16638);
            mi miVar = (mi) bVar;
            miVar.cIn.cIl = a.D(miVar.cIm.type, false);
            AppMethodBeat.o(16638);
            return false;
        }
    };
    private c ggy = new c<jx>() {
        {
            AppMethodBeat.i(16639);
            this.xxI = jx.class.getName().hashCode();
            AppMethodBeat.o(16639);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(16640);
            ab.i("MicroMsg.PermissionMgr", "show mute dlg");
            PermissionWarningDialog.ci(ah.getContext());
            AppMethodBeat.o(16640);
            return false;
        }
    };

    static class a {
        public int ggA;
        public int ggB;
        public int ggC;
        public int ggD;
        public int ggE;

        public a(int i, int i2, int i3, int i4, int i5) {
            this.ggA = i;
            this.ggB = i2;
            this.ggC = i3;
            this.ggD = i4;
            this.ggE = i5;
        }
    }

    static {
        AppMethodBeat.i(16645);
        String LM = q.LM();
        ceI = LM;
        ceJ = p.getString(LM.hashCode());
        HashMap hashMap = new HashMap();
        ggv = hashMap;
        hashMap.put(Integer.valueOf(1), new a(38, 40, 41, R.string.sk, R.string.sc));
        ggv.put(Integer.valueOf(2), new a(43, 44, 45, R.string.sj, R.string.sd));
        AppMethodBeat.o(16645);
    }

    public a() {
        AppMethodBeat.i(16641);
        com.tencent.mm.sdk.b.a.xxA.c(this.ggw);
        com.tencent.mm.sdk.b.a.xxA.c(this.ggx);
        com.tencent.mm.sdk.b.a.xxA.c(this.ggy);
        AppMethodBeat.o(16641);
    }

    private static int vn(String str) {
        int i = 0;
        AppMethodBeat.i(16642);
        try {
            i = bo.getInt(g.Nu().getValue(str), 0);
        } catch (Exception e) {
            ab.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(16642);
        return i;
    }

    static /* synthetic */ boolean mI(int i) {
        AppMethodBeat.i(16643);
        int Ml = aw.ZI().Ml(((a) ggv.get(Integer.valueOf(i))).ggA);
        ab.i("MicroMsg.PermissionMgr", "current mark status: ".concat(String.valueOf(Ml)));
        if (Ml == 0) {
            AppMethodBeat.o(16643);
            return true;
        }
        AppMethodBeat.o(16643);
        return false;
    }

    static /* synthetic */ boolean D(int i, boolean z) {
        int vn;
        boolean z2;
        AppMethodBeat.i(16644);
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        int i2 = 1;
        int i3 = 1;
        if (aw.RK()) {
            i2 = vn("ShowPermissionDialog");
            i3 = vn("OnlyScanRunningService");
            vn = vn("Interval4ShowPmsDialog");
        } else {
            vn = 3600000;
        }
        ab.i("MicroMsg.PermissionMgr", "showDlg: %d, filter: %d, interval: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(vn));
        long j = 0;
        for (a aVar2 : ggv.values()) {
            long j2 = aw.ZI().getLong(aVar2.ggB, 0);
            if (j < j2) {
                j = j2;
            }
        }
        if (1 != i2 || System.currentTimeMillis() - j < ((long) vn)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            aw.ZI().setLong(((a) ggv.get(Integer.valueOf(i))).ggB, System.currentTimeMillis());
            ab.i("MicroMsg.PermissionMgr", "tryDirectlyShowDefaultPermissionDialog, chkType: %s, filter: %s, dueToException: %s", Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z));
            if (1 == i) {
                boolean z3;
                aw.ZI().setLong(42, System.currentTimeMillis());
                Context context = ah.getContext();
                if (1 == i3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                PermissionWarningDialog.b(context, z3, z);
            }
        }
        ab.i("MicroMsg.PermissionMgr", "showPermissionDialog cost: " + aVar.Mr() + ", needShowDlg: " + z2);
        AppMethodBeat.o(16644);
        return false;
    }
}
