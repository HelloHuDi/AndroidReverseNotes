package com.tencent.mm.plugin.voip.model;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.c;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.model.i.a;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class q {
    private static boolean sSK = false;
    private static OnClickListener sSL = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(4578);
            q.access$000();
            AppMethodBeat.o(4578);
        }
    };

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(4591);
        cJW();
        AppMethodBeat.o(4591);
    }

    public static long a(String str, String str2, int i, int i2, String str3) {
        AppMethodBeat.i(4580);
        long a = a(str, str2, i, i2, str3, false);
        AppMethodBeat.o(4580);
        return a;
    }

    public static long a(String str, String str2, int i, int i2, String str3, boolean z) {
        AppMethodBeat.i(4581);
        bi biVar = new bi();
        biVar.eJ(bf.oC(str));
        biVar.hO(i);
        biVar.setType(50);
        biVar.ju(str);
        biVar.ix(str3);
        biVar.setContent(str2);
        biVar.setStatus(i2);
        if (z) {
            biVar.dtL();
        }
        long Z = ((j) g.K(j.class)).bOr().Z(biVar);
        if (Z < 0) {
            ab.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
        }
        ab.d("MicroMsg.VoipPluginManager", "inset voip  msgId ".concat(String.valueOf(Z)));
        AppMethodBeat.o(4581);
        return Z;
    }

    public static void cJU() {
        AppMethodBeat.i(4582);
        g.RP().Ry().set(20480, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(4582);
    }

    public static boolean cJV() {
        AppMethodBeat.i(4583);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long longValue = ((Long) g.RP().Ry().get(20480, Integer.valueOf(-1))).longValue();
            if (longValue < 0) {
                AppMethodBeat.o(4583);
                return false;
            }
            currentTimeMillis -= longValue;
            ab.d("MicroMsg.VoipPluginManager", "diff is".concat(String.valueOf(currentTimeMillis)));
            if (currentTimeMillis < 21600000) {
                AppMethodBeat.o(4583);
                return true;
            }
            AppMethodBeat.o(4583);
            return false;
        } catch (Exception e) {
        }
    }

    static {
        AppMethodBeat.i(4592);
        AppMethodBeat.o(4592);
    }

    public static void aW(final Context context, final String str) {
        AppMethodBeat.i(4584);
        new String[1][0] = context.getResources().getString(R.string.f3z);
        sSK = false;
        try {
            if (((j) g.K(j.class)).bOr().Rc(str) != null) {
                sSK = d.cLt();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.VoipPluginManager", "talker is null");
            AppMethodBeat.o(4584);
            return;
        }
        int acS = g.Rg().acS();
        ab.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(acS)));
        if (acS != 4 && acS != 6) {
            h.pYm.a(11518, true, true, Integer.valueOf(b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(b.cIj().sSP.sNl.cIK()), Integer.valueOf(4), Integer.valueOf(0));
            com.tencent.mm.ui.base.h.a(context, (int) R.string.f6c, (int) R.string.f6g, sSL);
            AppMethodBeat.o(4584);
        } else if (!sSK) {
            try {
                Map abV = a.abV((String) g.RP().Ry().get(77829, null));
                if (abV != null) {
                    a aVar;
                    if (abV != null && abV.size() > 0) {
                        if (abV.containsKey(str)) {
                            aVar = (a) abV.get(str);
                            aVar.hitCount++;
                            abV.put(str, aVar);
                        } else {
                            aVar = new a();
                            aVar.hitCount++;
                            abV.put(str, aVar);
                        }
                    }
                    g.RP().Ry().set(77829, a.ah(abV));
                    for (Entry entry : abV.entrySet()) {
                        aVar = (a) entry.getValue();
                        ab.d("MicroMsg.VoipPluginManager", "val1 " + aVar.hitCount + " " + aVar.fMk + "name " + ((String) entry.getKey()));
                    }
                } else {
                    HashMap hashMap = new HashMap();
                    a aVar2 = new a();
                    aVar2.hitCount++;
                    hashMap.put(str, aVar2);
                    g.RP().Ry().set(77829, a.ah(hashMap));
                    for (Entry entry2 : hashMap.entrySet()) {
                        aVar2 = (a) entry2.getValue();
                        ab.d("MicroMsg.VoipPluginManager", "val2 " + aVar2.hitCount + " " + aVar2.fMk + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
            }
            InviteRemindDialog.p(context, str, 0);
            cJW();
            AppMethodBeat.o(4584);
        } else if (at.isWap(context)) {
            com.tencent.mm.ui.base.h.a(context, (int) R.string.f79, 0, (int) R.string.f7_, (int) R.string.or, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(4577);
                    q.fb(context);
                    q.access$000();
                    AppMethodBeat.o(4577);
                }
            }, sSL);
            AppMethodBeat.o(4584);
        } else if (at.isWifi(context) || cJV()) {
            b.cIj().bb(context, str);
            AppMethodBeat.o(4584);
        } else {
            com.tencent.mm.ui.base.h.a(context, (int) R.string.f6f, (int) R.string.f6g, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(4576);
                    q.cJU();
                    b.cIj().bb(context, str);
                    AppMethodBeat.o(4576);
                }
            }, sSL);
            AppMethodBeat.o(4584);
        }
    }

    private static void cJW() {
        AppMethodBeat.i(4585);
        ui uiVar = new ui();
        uiVar.cQx.cAd = 8;
        com.tencent.mm.sdk.b.a.xxA.m(uiVar);
        AppMethodBeat.o(4585);
    }

    public static void fb(Context context) {
        AppMethodBeat.i(4586);
        try {
            Intent intent = new Intent("/");
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ApnSettings"));
            intent.setAction("android.intent.action.VIEW");
            context.startActivity(intent);
            AppMethodBeat.o(4586);
        } catch (Exception e) {
            searchIntentByClass(context, "ApnSettings");
            AppMethodBeat.o(4586);
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        AppMethodBeat.i(4587);
        try {
            PackageManager packageManager = context.getPackageManager();
            List installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                ab.e("MicroMsg.VoipPluginManager", "package  size" + installedPackages.size());
                for (int i = 0; i < installedPackages.size(); i++) {
                    try {
                        ab.e("MicroMsg.VoipPluginManager", "package " + ((PackageInfo) installedPackages.get(i)).packageName);
                        Intent intent = new Intent();
                        intent.setPackage(((PackageInfo) installedPackages.get(i)).packageName);
                        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            try {
                                ab.e("MicroMsg.VoipPluginManager", "activityName count ".concat(String.valueOf(size)));
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(i2)).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent("/");
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        context.startActivity(intent2);
                                        AppMethodBeat.o(4587);
                                        return intent2;
                                    }
                                }
                                continue;
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
                            }
                        } else {
                            continue;
                        }
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
                    }
                }
            }
        } catch (Exception e22) {
            ab.printErrStackTrace("MicroMsg.VoipPluginManager", e22, "", new Object[0]);
        }
        AppMethodBeat.o(4587);
        return null;
    }

    public static void aX(Context context, String str) {
        AppMethodBeat.i(4588);
        com.tencent.mm.m.g.Nv();
        int i = c.Ng() == 2 ? 1 : 0;
        com.tencent.mm.bp.d.dlL();
        if (i == 0) {
            ab.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", Boolean.FALSE, Boolean.FALSE);
        }
        sSK = false;
        try {
            if (((j) g.K(j.class)).bOr().Rc(str) != null) {
                sSK = d.cLt();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        aZ(context, str);
        AppMethodBeat.o(4588);
    }

    public static void aY(Context context, String str) {
        AppMethodBeat.i(4589);
        sSK = false;
        try {
            if (((j) g.K(j.class)).bOr().Rc(str) != null) {
                sSK = d.cLt();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        aZ(context, str);
        AppMethodBeat.o(4589);
    }

    private static void aZ(final Context context, String str) {
        AppMethodBeat.i(4590);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.VoipPluginManager", "talker is null");
            AppMethodBeat.o(4590);
            return;
        }
        int acS = g.Rg().acS();
        ab.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(acS)));
        if (acS != 4 && acS != 6) {
            h.pYm.a(11518, true, true, Integer.valueOf(b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(b.cIj().sSP.sNl.cIK()), Integer.valueOf(4), Integer.valueOf(0));
            com.tencent.mm.ui.base.h.a(context, (int) R.string.f6c, (int) R.string.f6g, sSL);
            AppMethodBeat.o(4590);
        } else if (!sSK) {
            try {
                Map abV = a.abV((String) g.RP().Ry().get(77829, null));
                if (abV != null) {
                    a aVar;
                    if (abV != null && abV.size() > 0) {
                        if (abV.containsKey(str)) {
                            aVar = (a) abV.get(str);
                            aVar.hitCount++;
                            abV.put(str, aVar);
                        } else {
                            aVar = new a();
                            aVar.hitCount++;
                            abV.put(str, aVar);
                        }
                    }
                    g.RP().Ry().set(77829, a.ah(abV));
                    for (Entry entry : abV.entrySet()) {
                        aVar = (a) entry.getValue();
                        ab.d("MicroMsg.VoipPluginManager", "val1 " + aVar.hitCount + " " + aVar.fMk + "name " + ((String) entry.getKey()));
                    }
                } else {
                    HashMap hashMap = new HashMap();
                    a aVar2 = new a();
                    aVar2.hitCount++;
                    hashMap.put(str, aVar2);
                    g.RP().Ry().set(77829, a.ah(hashMap));
                    for (Entry entry2 : hashMap.entrySet()) {
                        aVar2 = (a) entry2.getValue();
                        ab.d("MicroMsg.VoipPluginManager", "val2 " + aVar2.hitCount + " " + aVar2.fMk + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
            }
            InviteRemindDialog.p(context, str, 1);
            cJW();
            AppMethodBeat.o(4590);
        } else if (at.isWap(context)) {
            com.tencent.mm.ui.base.h.a(context, (int) R.string.f79, 0, (int) R.string.f7_, (int) R.string.or, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(4579);
                    q.fb(context);
                    AppMethodBeat.o(4579);
                }
            }, sSL);
            AppMethodBeat.o(4590);
        } else if (at.isWifi(context) || cJV()) {
            b.cIj().ba(context, str);
            AppMethodBeat.o(4590);
        } else {
            b.cIj().ba(context, str);
            AppMethodBeat.o(4590);
        }
    }
}
