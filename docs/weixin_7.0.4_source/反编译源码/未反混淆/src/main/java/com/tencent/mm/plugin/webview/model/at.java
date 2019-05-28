package com.tencent.mm.plugin.webview.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.LinkedList;
import java.util.List;

public final class at {
    private static List<com.tencent.mm.ah.d.a> unz = new LinkedList();

    public interface a {
        void hJ(boolean z);
    }

    static class b implements com.tencent.mm.sdk.platformtools.ap.a {
        private Runnable fZM;

        b(Runnable runnable) {
            this.fZM = runnable;
        }

        public final boolean BI() {
            AppMethodBeat.i(6805);
            if (this.fZM != null) {
                this.fZM.run();
            }
            AppMethodBeat.o(6805);
            return false;
        }
    }

    static /* synthetic */ Bitmap bk(Context context, String str) {
        AppMethodBeat.i(6814);
        Bitmap bi = bi(context, str);
        AppMethodBeat.o(6814);
        return bi;
    }

    static {
        AppMethodBeat.i(6815);
        AppMethodBeat.o(6815);
    }

    public static void a(final Context context, final String str, final String str2, final a aVar) {
        AppMethodBeat.i(6806);
        if (context == null || bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WebviewShrotcutManager", "context or username is null");
            if (aVar != null) {
                aVar.hJ(false);
            }
            AppMethodBeat.o(6806);
            return;
        }
        ab.d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", str);
        if (g.RK()) {
            ad aoO = ((j) g.K(j.class)).XM().aoO(str);
            String str3 = "";
            if (aoO != null) {
                str3 = aoO.Oi();
            }
            if (bo.isNullOrNil(str3)) {
                ab.e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
                com.tencent.mm.model.ao.a.flu.a(str, "", new com.tencent.mm.model.ao.b.a() {
                    public final void o(String str, boolean z) {
                        AppMethodBeat.i(6802);
                        ab.i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", Boolean.valueOf(z));
                        if (z) {
                            ad aoO = ((j) g.K(j.class)).XM().aoO(str);
                            if (aoO != null && !bo.isNullOrNil(aoO.Oi())) {
                                at.a(context, str, str2, aoO.Oi(), aVar);
                            } else if (aVar != null) {
                                aVar.hJ(false);
                                AppMethodBeat.o(6802);
                                return;
                            }
                        } else if (aVar != null) {
                            aVar.hJ(false);
                            AppMethodBeat.o(6802);
                            return;
                        }
                        AppMethodBeat.o(6802);
                    }
                });
                AppMethodBeat.o(6806);
                return;
            }
            a(context, str, str2, str3, aVar);
            AppMethodBeat.o(6806);
            return;
        }
        ab.e("MicroMsg.WebviewShrotcutManager", "acc not ready");
        if (aVar != null) {
            aVar.hJ(false);
        }
        AppMethodBeat.o(6806);
    }

    public static void a(Context context, final String str, String str2, String str3, final a aVar) {
        AppMethodBeat.i(6807);
        if (bj(context, str3)) {
            ab.i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
            if (aVar != null) {
                aVar.hJ(true);
            }
            AppMethodBeat.o(6807);
            return;
        }
        final String str4 = str;
        final Context context2 = context;
        final a aVar2 = aVar;
        final String str5 = str2;
        final String str6 = str3;
        final com.tencent.mm.ah.d.a anonymousClass2 = new com.tencent.mm.ah.d.a() {
            public final void qj(String str) {
                AppMethodBeat.i(6803);
                if (str4.equals(str)) {
                    ab.i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", str);
                    at.unz.remove(this);
                    o.acd().b(this);
                    Bitmap bk = at.bk(context2, str4);
                    if (bk != null && !bk.isRecycled()) {
                        Intent a = at.a(context2, str4, str5, str6, bk, true);
                        if (a == null) {
                            ab.e("MicroMsg.WebviewShrotcutManager", "intent is null");
                            if (aVar2 != null) {
                                aVar2.hJ(false);
                                AppMethodBeat.o(6803);
                                return;
                            }
                        }
                        com.tencent.mm.plugin.base.model.b.r(context2, a);
                        if (aVar2 != null) {
                            aVar2.hJ(true);
                        }
                    } else if (aVar2 != null) {
                        aVar2.hJ(false);
                        AppMethodBeat.o(6803);
                        return;
                    }
                    AppMethodBeat.o(6803);
                    return;
                }
                AppMethodBeat.o(6803);
            }
        };
        unz.add(anonymousClass2);
        o.acd().a(anonymousClass2);
        Bitmap bi = bi(context, str);
        if (bi == null || bi.isRecycled()) {
            ab.e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
            new ap(new b(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6804);
                    ab.i("MicroMsg.WebviewShrotcutManager", "expired");
                    if (at.unz.contains(anonymousClass2)) {
                        at.unz.remove(anonymousClass2);
                        o.acd().b(anonymousClass2);
                        if (aVar != null) {
                            aVar.hJ(false);
                        }
                    }
                    AppMethodBeat.o(6804);
                }
            }), false).ae(5000, 5000);
            AppMethodBeat.o(6807);
            return;
        }
        unz.remove(anonymousClass2);
        o.acd().b(anonymousClass2);
        Intent a = a(context, str, str2, str3, bi, true);
        if (a == null) {
            ab.e("MicroMsg.WebviewShrotcutManager", "intent is null");
            if (aVar != null) {
                aVar.hJ(false);
            }
            AppMethodBeat.o(6807);
            return;
        }
        com.tencent.mm.plugin.base.model.b.r(context, a);
        if (aVar != null) {
            aVar.hJ(true);
        }
        AppMethodBeat.o(6807);
    }

    public static void f(Context context, String str, String str2, String str3) {
        AppMethodBeat.i(6809);
        if (context == null || bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
        }
        Intent a = a(context, str, str2, str3, null, false);
        if (a == null) {
            ab.e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
            AppMethodBeat.o(6809);
            return;
        }
        com.tencent.mm.plugin.base.model.b.s(context, a);
        AppMethodBeat.o(6809);
    }

    public static Intent a(Context context, String str, String str2, String str3, Bitmap bitmap, boolean z) {
        AppMethodBeat.i(6810);
        ab.i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", Boolean.valueOf(z));
        if (bitmap == null && z) {
            ab.e("MicroMsg.WebviewShrotcutManager", "no bmp");
            AppMethodBeat.o(6810);
            return null;
        }
        String Fv = Fv(str);
        if (bo.isNullOrNil(Fv)) {
            AppMethodBeat.o(6810);
            return null;
        }
        Intent intent = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", str3);
        intent.putExtra("duplicate", false);
        String str4 = "";
        h qo = o.act().qo(str);
        if (qo != null) {
            str4 = com.tencent.mm.a.g.x((str3 + qo.acl()).getBytes());
        }
        Intent intent2 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
        intent2.putExtra("type", 2);
        intent2.putExtra("id", Fv);
        intent2.putExtra("ext_info", Fv(str2));
        intent2.putExtra("ext_info_1", Fv(str3));
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        intent2.putExtra("token", db(str2, stringBuilder.append(com.tencent.mm.kernel.a.QF()).toString()));
        intent2.putExtra("digest", str4);
        intent2.setPackage(context.getPackageName());
        intent2.addFlags(67108864);
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        AppMethodBeat.o(6810);
        return intent;
    }

    private static String Fv(String str) {
        AppMethodBeat.i(6811);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(6811);
            return null;
        }
        String da = com.tencent.mm.plugin.base.model.b.da(str, q.LK());
        if (bo.isNullOrNil(da)) {
            AppMethodBeat.o(6811);
            return null;
        }
        String str2 = "shortcut_" + com.tencent.mm.plugin.base.model.b.V(da.getBytes());
        AppMethodBeat.o(6811);
        return str2;
    }

    public static String db(String str, String str2) {
        AppMethodBeat.i(6812);
        String x = com.tencent.mm.a.g.x((com.tencent.mm.a.g.x(str.getBytes()) + com.tencent.mm.plugin.base.model.b.da(str2, str)).getBytes());
        AppMethodBeat.o(6812);
        return x;
    }

    private static boolean bj(Context context, String str) {
        AppMethodBeat.i(6813);
        try {
            String str2;
            boolean z;
            ContentResolver contentResolver = context.getContentResolver();
            List<PackageInfo> installedPackages = ah.getContext().getPackageManager().getInstalledPackages(8);
            if (installedPackages != null) {
                loop0:
                for (PackageInfo packageInfo : installedPackages) {
                    ProviderInfo[] providerInfoArr = packageInfo.providers;
                    if (providerInfoArr != null) {
                        int length = providerInfoArr.length;
                        int i = 0;
                        while (i < length) {
                            ProviderInfo providerInfo = providerInfoArr[i];
                            if ("com.android.launcher.permission.READ_SETTINGS".equals(providerInfo.readPermission)) {
                                str2 = providerInfo.authority;
                                break loop0;
                            } else if ("com.android.launcher.permission.READ_SETTINGS".equals(providerInfo.writePermission)) {
                                str2 = providerInfo.authority;
                                break loop0;
                            } else {
                                i++;
                            }
                        }
                        continue;
                    }
                }
            }
            str2 = null;
            Cursor query = contentResolver.query(Uri.parse("content://" + str2 + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{str}, null);
            if (query != null) {
                z = query.getCount() > 0;
                query.close();
            } else {
                z = false;
            }
            AppMethodBeat.o(6813);
            return z;
        } catch (Exception e) {
            AppMethodBeat.o(6813);
            return false;
        }
    }

    private static Bitmap bi(Context context, String str) {
        AppMethodBeat.i(6808);
        Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
        if (a == null || a.isRecycled()) {
            AppMethodBeat.o(6808);
            return a;
        }
        int i = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        a = Bitmap.createScaledBitmap(a, i, i, false);
        AppMethodBeat.o(6808);
        return a;
    }
}
