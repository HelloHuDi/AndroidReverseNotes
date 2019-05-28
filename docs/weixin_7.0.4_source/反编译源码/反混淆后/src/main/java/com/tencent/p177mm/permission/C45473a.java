package com.tencent.p177mm.permission;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1188f.C32472a;
import com.tencent.p177mm.compatible.p1188f.C32472a.C18173b;
import com.tencent.p177mm.compatible.p1188f.C32472a.C26047a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p230g.p231a.C18327mh;
import com.tencent.p177mm.p230g.p231a.C18330mi;
import com.tencent.p177mm.p230g.p231a.C26177jx;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.permission.a */
public final class C45473a {
    static final String ceI;
    static final String ceJ;
    static Map<Integer, C45472a> ggv;
    C4884c ggw = new C265201();
    private C4884c ggx = new C379832();
    private C4884c ggy = new C454713();

    /* renamed from: com.tencent.mm.permission.a$1 */
    class C265201 extends C4884c<C18327mh> {
        C265201() {
            AppMethodBeat.m2504i(16635);
            this.xxI = C18327mh.class.getName().hashCode();
            AppMethodBeat.m2505o(16635);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(16636);
            C18327mh c18327mh = (C18327mh) c4883b;
            if (true == c18327mh.cIh.cIj) {
                if (!C45473a.m83800mI(c18327mh.cIh.type)) {
                    if (C32472a.euv == null) {
                        ArrayList<C18173b> arrayList = new ArrayList();
                        ArrayList<C26047a> arrayList2 = new ArrayList();
                        C32472a.m53157a(C6457e.eSj + "permissioncfg.cfg", arrayList, arrayList2);
                        PInt pInt = new PInt(0);
                        PBool pBool = new PBool();
                        for (C18173b c18173b : arrayList) {
                            pInt.value = 0;
                            pBool.value = true;
                            if (C32472a.m53158a(Build.MANUFACTURER, c18173b.euA, pInt, pBool) && C32472a.m53158a(Build.MODEL, c18173b.model, pInt, pBool)) {
                                C32472a.m53158a(VERSION.RELEASE, c18173b.version, pInt, pBool);
                            }
                            if (pBool.value && pInt.value > 0) {
                                C32472a.euv = Boolean.valueOf(1 == c18173b.euy);
                            }
                        }
                        if (C32472a.euv == null || true != C32472a.euv.booleanValue()) {
                            HashSet hashSet = new HashSet();
                            PackageManager packageManager = C4996ah.getContext().getPackageManager();
                            List list;
                            if (packageManager == null) {
                                list = null;
                            } else {
                                list = packageManager.getInstalledPackages(0);
                            }
                            for (PackageInfo packageInfo : list) {
                                for (C26047a c26047a : arrayList2) {
                                    pInt.value = 0;
                                    pBool.value = true;
                                    if (C32472a.m53158a(packageInfo.packageName, c26047a.ceO, pInt, pBool)) {
                                        if (c26047a.euw == 0 && c26047a.eux == 0) {
                                            pBool.value = true;
                                        } else if (c26047a.euw > packageInfo.versionCode || c26047a.eux < packageInfo.versionCode) {
                                            pBool.value = false;
                                        } else {
                                            pInt.value++;
                                            pBool.value = true;
                                        }
                                    }
                                    if (pBool.value && pInt.value > 0) {
                                        boolean z;
                                        if (1 == c26047a.euy) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        C32472a.euv = Boolean.valueOf(z);
                                    }
                                }
                                if (C32472a.euv != null && true == C32472a.euv.booleanValue()) {
                                    break;
                                }
                            }
                            if (C32472a.euv == null) {
                                C32472a.euv = Boolean.FALSE;
                            }
                        }
                    }
                    if (C32472a.euv.booleanValue()) {
                        c18327mh.cIi.cIl = C45473a.m83799D(c18327mh.cIh.type, true);
                    }
                }
                c18327mh.cIi.cIl = false;
            } else {
                c18327mh.cIi.cIl = false;
            }
            AppMethodBeat.m2505o(16636);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.permission.a$2 */
    class C379832 extends C4884c<C18330mi> {
        C379832() {
            AppMethodBeat.m2504i(16637);
            this.xxI = C18330mi.class.getName().hashCode();
            AppMethodBeat.m2505o(16637);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(16638);
            C18330mi c18330mi = (C18330mi) c4883b;
            c18330mi.cIn.cIl = C45473a.m83799D(c18330mi.cIm.type, false);
            AppMethodBeat.m2505o(16638);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.permission.a$3 */
    class C454713 extends C4884c<C26177jx> {
        C454713() {
            AppMethodBeat.m2504i(16639);
            this.xxI = C26177jx.class.getName().hashCode();
            AppMethodBeat.m2505o(16639);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(16640);
            C4990ab.m7416i("MicroMsg.PermissionMgr", "show mute dlg");
            PermissionWarningDialog.m4145ci(C4996ah.getContext());
            AppMethodBeat.m2505o(16640);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.permission.a$a */
    static class C45472a {
        public int ggA;
        public int ggB;
        public int ggC;
        public int ggD;
        public int ggE;

        public C45472a(int i, int i2, int i3, int i4, int i5) {
            this.ggA = i;
            this.ggB = i2;
            this.ggC = i3;
            this.ggD = i4;
            this.ggE = i5;
        }
    }

    static {
        AppMethodBeat.m2504i(16645);
        String LM = C1427q.m3028LM();
        ceI = LM;
        ceJ = C1183p.getString(LM.hashCode());
        HashMap hashMap = new HashMap();
        ggv = hashMap;
        hashMap.put(Integer.valueOf(1), new C45472a(38, 40, 41, C25738R.string.f9197sk, C25738R.string.f9193sc));
        ggv.put(Integer.valueOf(2), new C45472a(43, 44, 45, C25738R.string.f9196sj, C25738R.string.f9194sd));
        AppMethodBeat.m2505o(16645);
    }

    public C45473a() {
        AppMethodBeat.m2504i(16641);
        C4879a.xxA.mo10052c(this.ggw);
        C4879a.xxA.mo10052c(this.ggx);
        C4879a.xxA.mo10052c(this.ggy);
        AppMethodBeat.m2505o(16641);
    }

    /* renamed from: vn */
    private static int m83801vn(String str) {
        int i = 0;
        AppMethodBeat.m2504i(16642);
        try {
            i = C5046bo.getInt(C26373g.m41964Nu().getValue(str), 0);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(16642);
        return i;
    }

    /* renamed from: mI */
    static /* synthetic */ boolean m83800mI(int i) {
        AppMethodBeat.m2504i(16643);
        int Ml = C9638aw.m17188ZI().mo10573Ml(((C45472a) ggv.get(Integer.valueOf(i))).ggA);
        C4990ab.m7416i("MicroMsg.PermissionMgr", "current mark status: ".concat(String.valueOf(Ml)));
        if (Ml == 0) {
            AppMethodBeat.m2505o(16643);
            return true;
        }
        AppMethodBeat.m2505o(16643);
        return false;
    }

    /* renamed from: D */
    static /* synthetic */ boolean m83799D(int i, boolean z) {
        int vn;
        boolean z2;
        AppMethodBeat.m2504i(16644);
        C1446a c1446a = new C1446a();
        int i2 = 1;
        int i3 = 1;
        if (C9638aw.m17179RK()) {
            i2 = C45473a.m83801vn("ShowPermissionDialog");
            i3 = C45473a.m83801vn("OnlyScanRunningService");
            vn = C45473a.m83801vn("Interval4ShowPmsDialog");
        } else {
            vn = 3600000;
        }
        C4990ab.m7417i("MicroMsg.PermissionMgr", "showDlg: %d, filter: %d, interval: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(vn));
        long j = 0;
        for (C45472a c45472a : ggv.values()) {
            long j2 = C9638aw.m17188ZI().getLong(c45472a.ggB, 0);
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
            C9638aw.m17188ZI().setLong(((C45472a) ggv.get(Integer.valueOf(i))).ggB, System.currentTimeMillis());
            C4990ab.m7417i("MicroMsg.PermissionMgr", "tryDirectlyShowDefaultPermissionDialog, chkType: %s, filter: %s, dueToException: %s", Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z));
            if (1 == i) {
                boolean z3;
                C9638aw.m17188ZI().setLong(42, System.currentTimeMillis());
                Context context = C4996ah.getContext();
                if (1 == i3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                PermissionWarningDialog.m4144b(context, z3, z);
            }
        }
        C4990ab.m7416i("MicroMsg.PermissionMgr", "showPermissionDialog cost: " + c1446a.mo4908Mr() + ", needShowDlg: " + z2);
        AppMethodBeat.m2505o(16644);
        return false;
    }
}
