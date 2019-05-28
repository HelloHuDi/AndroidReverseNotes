package com.tencent.p177mm.plugin.voip.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p249m.C1763c;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.model.C29498i.C22459a;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.plugin.voip.p546ui.InviteRemindDialog;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.voip.model.q */
public final class C14055q {
    private static boolean sSK = false;
    private static OnClickListener sSL = new C140543();

    /* renamed from: com.tencent.mm.plugin.voip.model.q$3 */
    static class C140543 implements OnClickListener {
        C140543() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(4578);
            C14055q.access$000();
            AppMethodBeat.m2505o(4578);
        }
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.m2504i(4591);
        C14055q.cJW();
        AppMethodBeat.m2505o(4591);
    }

    /* renamed from: a */
    public static long m22208a(String str, String str2, int i, int i2, String str3) {
        AppMethodBeat.m2504i(4580);
        long a = C14055q.m22209a(str, str2, i, i2, str3, false);
        AppMethodBeat.m2505o(4580);
        return a;
    }

    /* renamed from: a */
    public static long m22209a(String str, String str2, int i, int i2, String str3, boolean z) {
        AppMethodBeat.m2504i(4581);
        C7620bi c7620bi = new C7620bi();
        c7620bi.mo14775eJ(C1829bf.m3756oC(str));
        c7620bi.mo14781hO(i);
        c7620bi.setType(50);
        c7620bi.mo14794ju(str);
        c7620bi.mo14791ix(str3);
        c7620bi.setContent(str2);
        c7620bi.setStatus(i2);
        if (z) {
            c7620bi.dtL();
        }
        long Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
        if (Z < 0) {
            C4990ab.m7412e("MicroMsg.VoipPluginManager", "inset voip  failed!");
        }
        C4990ab.m7410d("MicroMsg.VoipPluginManager", "inset voip  msgId ".concat(String.valueOf(Z)));
        AppMethodBeat.m2505o(4581);
        return Z;
    }

    public static void cJU() {
        AppMethodBeat.m2504i(4582);
        C1720g.m3536RP().mo5239Ry().set(20480, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(4582);
    }

    public static boolean cJV() {
        AppMethodBeat.m2504i(4583);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(20480, Integer.valueOf(-1))).longValue();
            if (longValue < 0) {
                AppMethodBeat.m2505o(4583);
                return false;
            }
            currentTimeMillis -= longValue;
            C4990ab.m7410d("MicroMsg.VoipPluginManager", "diff is".concat(String.valueOf(currentTimeMillis)));
            if (currentTimeMillis < 21600000) {
                AppMethodBeat.m2505o(4583);
                return true;
            }
            AppMethodBeat.m2505o(4583);
            return false;
        } catch (Exception e) {
        }
    }

    static {
        AppMethodBeat.m2504i(4592);
        AppMethodBeat.m2505o(4592);
    }

    /* renamed from: aW */
    public static void m22210aW(final Context context, final String str) {
        AppMethodBeat.m2504i(4584);
        new String[1][0] = context.getResources().getString(C25738R.string.f3z);
        sSK = false;
        try {
            if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15249Rc(str) != null) {
                sSK = C29488d.cLt();
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.VoipPluginManager", "talker is null");
            AppMethodBeat.m2505o(4584);
            return;
        }
        int acS = C1720g.m3540Rg().acS();
        C4990ab.m7410d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(acS)));
        if (acS != 4 && acS != 6) {
            C7060h.pYm.mo8377a(11518, true, true, Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(C43727b.cIj().sSP.sNl.cIK()), Integer.valueOf(4), Integer.valueOf(0));
            C30379h.m48431a(context, (int) C25738R.string.f6c, (int) C25738R.string.f6g, sSL);
            AppMethodBeat.m2505o(4584);
        } else if (!sSK) {
            try {
                Map abV = C22459a.abV((String) C1720g.m3536RP().mo5239Ry().get(77829, null));
                if (abV != null) {
                    C22459a c22459a;
                    if (abV != null && abV.size() > 0) {
                        if (abV.containsKey(str)) {
                            c22459a = (C22459a) abV.get(str);
                            c22459a.hitCount++;
                            abV.put(str, c22459a);
                        } else {
                            c22459a = new C22459a();
                            c22459a.hitCount++;
                            abV.put(str, c22459a);
                        }
                    }
                    C1720g.m3536RP().mo5239Ry().set(77829, C22459a.m34142ah(abV));
                    for (Entry entry : abV.entrySet()) {
                        c22459a = (C22459a) entry.getValue();
                        C4990ab.m7410d("MicroMsg.VoipPluginManager", "val1 " + c22459a.hitCount + " " + c22459a.fMk + "name " + ((String) entry.getKey()));
                    }
                } else {
                    HashMap hashMap = new HashMap();
                    C22459a c22459a2 = new C22459a();
                    c22459a2.hitCount++;
                    hashMap.put(str, c22459a2);
                    C1720g.m3536RP().mo5239Ry().set(77829, C22459a.m34142ah(hashMap));
                    for (Entry entry2 : hashMap.entrySet()) {
                        c22459a2 = (C22459a) entry2.getValue();
                        C4990ab.m7410d("MicroMsg.VoipPluginManager", "val2 " + c22459a2.hitCount + " " + c22459a2.fMk + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
            }
            InviteRemindDialog.m78402p(context, str, 0);
            C14055q.cJW();
            AppMethodBeat.m2505o(4584);
        } else if (C5023at.isWap(context)) {
            C30379h.m48428a(context, (int) C25738R.string.f79, 0, (int) C25738R.string.f7_, (int) C25738R.string.f9076or, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(4577);
                    C14055q.m22214fb(context);
                    C14055q.access$000();
                    AppMethodBeat.m2505o(4577);
                }
            }, sSL);
            AppMethodBeat.m2505o(4584);
        } else if (C5023at.isWifi(context) || C14055q.cJV()) {
            C43727b.cIj().mo26352bb(context, str);
            AppMethodBeat.m2505o(4584);
        } else {
            C30379h.m48432a(context, (int) C25738R.string.f6f, (int) C25738R.string.f6g, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(4576);
                    C14055q.cJU();
                    C43727b.cIj().mo26352bb(context, str);
                    AppMethodBeat.m2505o(4576);
                }
            }, sSL);
            AppMethodBeat.m2505o(4584);
        }
    }

    private static void cJW() {
        AppMethodBeat.m2504i(4585);
        C26250ui c26250ui = new C26250ui();
        c26250ui.cQx.cAd = 8;
        C4879a.xxA.mo10055m(c26250ui);
        AppMethodBeat.m2505o(4585);
    }

    /* renamed from: fb */
    public static void m22214fb(Context context) {
        AppMethodBeat.m2504i(4586);
        try {
            Intent intent = new Intent("/");
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ApnSettings"));
            intent.setAction("android.intent.action.VIEW");
            context.startActivity(intent);
            AppMethodBeat.m2505o(4586);
        } catch (Exception e) {
            C14055q.searchIntentByClass(context, "ApnSettings");
            AppMethodBeat.m2505o(4586);
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        AppMethodBeat.m2504i(4587);
        try {
            PackageManager packageManager = context.getPackageManager();
            List installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                C4990ab.m7412e("MicroMsg.VoipPluginManager", "package  size" + installedPackages.size());
                for (int i = 0; i < installedPackages.size(); i++) {
                    try {
                        C4990ab.m7412e("MicroMsg.VoipPluginManager", "package " + ((PackageInfo) installedPackages.get(i)).packageName);
                        Intent intent = new Intent();
                        intent.setPackage(((PackageInfo) installedPackages.get(i)).packageName);
                        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            try {
                                C4990ab.m7412e("MicroMsg.VoipPluginManager", "activityName count ".concat(String.valueOf(size)));
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(i2)).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent("/");
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        context.startActivity(intent2);
                                        AppMethodBeat.m2505o(4587);
                                        return intent2;
                                    }
                                }
                                continue;
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
                            }
                        } else {
                            continue;
                        }
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
                    }
                }
            }
        } catch (Exception e22) {
            C4990ab.printErrStackTrace("MicroMsg.VoipPluginManager", e22, "", new Object[0]);
        }
        AppMethodBeat.m2505o(4587);
        return null;
    }

    /* renamed from: aX */
    public static void m22211aX(Context context, String str) {
        AppMethodBeat.m2504i(4588);
        C26373g.m41965Nv();
        int i = C1763c.m3627Ng() == 2 ? 1 : 0;
        C25985d.dlL();
        if (i == 0) {
            C4990ab.m7417i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", Boolean.FALSE, Boolean.FALSE);
        }
        sSK = false;
        try {
            if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15249Rc(str) != null) {
                sSK = C29488d.cLt();
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        C14055q.m22213aZ(context, str);
        AppMethodBeat.m2505o(4588);
    }

    /* renamed from: aY */
    public static void m22212aY(Context context, String str) {
        AppMethodBeat.m2504i(4589);
        sSK = false;
        try {
            if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15249Rc(str) != null) {
                sSK = C29488d.cLt();
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        C14055q.m22213aZ(context, str);
        AppMethodBeat.m2505o(4589);
    }

    /* renamed from: aZ */
    private static void m22213aZ(final Context context, String str) {
        AppMethodBeat.m2504i(4590);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.VoipPluginManager", "talker is null");
            AppMethodBeat.m2505o(4590);
            return;
        }
        int acS = C1720g.m3540Rg().acS();
        C4990ab.m7410d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(acS)));
        if (acS != 4 && acS != 6) {
            C7060h.pYm.mo8377a(11518, true, true, Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(C43727b.cIj().sSP.sNl.cIK()), Integer.valueOf(4), Integer.valueOf(0));
            C30379h.m48431a(context, (int) C25738R.string.f6c, (int) C25738R.string.f6g, sSL);
            AppMethodBeat.m2505o(4590);
        } else if (!sSK) {
            try {
                Map abV = C22459a.abV((String) C1720g.m3536RP().mo5239Ry().get(77829, null));
                if (abV != null) {
                    C22459a c22459a;
                    if (abV != null && abV.size() > 0) {
                        if (abV.containsKey(str)) {
                            c22459a = (C22459a) abV.get(str);
                            c22459a.hitCount++;
                            abV.put(str, c22459a);
                        } else {
                            c22459a = new C22459a();
                            c22459a.hitCount++;
                            abV.put(str, c22459a);
                        }
                    }
                    C1720g.m3536RP().mo5239Ry().set(77829, C22459a.m34142ah(abV));
                    for (Entry entry : abV.entrySet()) {
                        c22459a = (C22459a) entry.getValue();
                        C4990ab.m7410d("MicroMsg.VoipPluginManager", "val1 " + c22459a.hitCount + " " + c22459a.fMk + "name " + ((String) entry.getKey()));
                    }
                } else {
                    HashMap hashMap = new HashMap();
                    C22459a c22459a2 = new C22459a();
                    c22459a2.hitCount++;
                    hashMap.put(str, c22459a2);
                    C1720g.m3536RP().mo5239Ry().set(77829, C22459a.m34142ah(hashMap));
                    for (Entry entry2 : hashMap.entrySet()) {
                        c22459a2 = (C22459a) entry2.getValue();
                        C4990ab.m7410d("MicroMsg.VoipPluginManager", "val2 " + c22459a2.hitCount + " " + c22459a2.fMk + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
            }
            InviteRemindDialog.m78402p(context, str, 1);
            C14055q.cJW();
            AppMethodBeat.m2505o(4590);
        } else if (C5023at.isWap(context)) {
            C30379h.m48428a(context, (int) C25738R.string.f79, 0, (int) C25738R.string.f7_, (int) C25738R.string.f9076or, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(4579);
                    C14055q.m22214fb(context);
                    AppMethodBeat.m2505o(4579);
                }
            }, sSL);
            AppMethodBeat.m2505o(4590);
        } else if (C5023at.isWifi(context) || C14055q.cJV()) {
            C43727b.cIj().mo26351ba(context, str);
            AppMethodBeat.m2505o(4590);
        } else {
            C43727b.cIj().mo26351ba(context, str);
            AppMethodBeat.m2505o(4590);
        }
    }
}
