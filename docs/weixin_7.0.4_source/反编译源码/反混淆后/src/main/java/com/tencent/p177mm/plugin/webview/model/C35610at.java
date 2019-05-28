package com.tencent.p177mm.plugin.webview.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.webview.model.at */
public final class C35610at {
    private static List<C8915a> unz = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.webview.model.at$a */
    public interface C14514a {
        /* renamed from: hJ */
        void mo26754hJ(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.at$b */
    static class C29819b implements C5015a {
        private Runnable fZM;

        C29819b(Runnable runnable) {
            this.fZM = runnable;
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(6805);
            if (this.fZM != null) {
                this.fZM.run();
            }
            AppMethodBeat.m2505o(6805);
            return false;
        }
    }

    /* renamed from: bk */
    static /* synthetic */ Bitmap m58452bk(Context context, String str) {
        AppMethodBeat.m2504i(6814);
        Bitmap bi = C35610at.m58450bi(context, str);
        AppMethodBeat.m2505o(6814);
        return bi;
    }

    static {
        AppMethodBeat.m2504i(6815);
        AppMethodBeat.m2505o(6815);
    }

    /* renamed from: a */
    public static void m58448a(final Context context, final String str, final String str2, final C14514a c14514a) {
        AppMethodBeat.m2504i(6806);
        if (context == null || C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WebviewShrotcutManager", "context or username is null");
            if (c14514a != null) {
                c14514a.mo26754hJ(false);
            }
            AppMethodBeat.m2505o(6806);
            return;
        }
        C4990ab.m7411d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", str);
        if (C1720g.m3531RK()) {
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            String str3 = "";
            if (aoO != null) {
                str3 = aoO.mo16706Oi();
            }
            if (C5046bo.isNullOrNil(str3)) {
                C4990ab.m7412e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
                C26417a.flu.mo20966a(str, "", new C9636a() {
                    /* renamed from: o */
                    public final void mo6218o(String str, boolean z) {
                        AppMethodBeat.m2504i(6802);
                        C4990ab.m7417i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", Boolean.valueOf(z));
                        if (z) {
                            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                            if (aoO != null && !C5046bo.isNullOrNil(aoO.mo16706Oi())) {
                                C35610at.m58449a(context, str, str2, aoO.mo16706Oi(), c14514a);
                            } else if (c14514a != null) {
                                c14514a.mo26754hJ(false);
                                AppMethodBeat.m2505o(6802);
                                return;
                            }
                        } else if (c14514a != null) {
                            c14514a.mo26754hJ(false);
                            AppMethodBeat.m2505o(6802);
                            return;
                        }
                        AppMethodBeat.m2505o(6802);
                    }
                });
                AppMethodBeat.m2505o(6806);
                return;
            }
            C35610at.m58449a(context, str, str2, str3, c14514a);
            AppMethodBeat.m2505o(6806);
            return;
        }
        C4990ab.m7412e("MicroMsg.WebviewShrotcutManager", "acc not ready");
        if (c14514a != null) {
            c14514a.mo26754hJ(false);
        }
        AppMethodBeat.m2505o(6806);
    }

    /* renamed from: a */
    public static void m58449a(Context context, final String str, String str2, String str3, final C14514a c14514a) {
        AppMethodBeat.m2504i(6807);
        if (C35610at.m58451bj(context, str3)) {
            C4990ab.m7416i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
            if (c14514a != null) {
                c14514a.mo26754hJ(true);
            }
            AppMethodBeat.m2505o(6807);
            return;
        }
        final String str4 = str;
        final Context context2 = context;
        final C14514a c14514a2 = c14514a;
        final String str5 = str2;
        final String str6 = str3;
        final C8915a c356112 = new C8915a() {
            /* renamed from: qj */
            public final void mo20342qj(String str) {
                AppMethodBeat.m2504i(6803);
                if (str4.equals(str)) {
                    C4990ab.m7417i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", str);
                    C35610at.unz.remove(this);
                    C17884o.acd().mo67500b(this);
                    Bitmap bk = C35610at.m58452bk(context2, str4);
                    if (bk != null && !bk.isRecycled()) {
                        Intent a = C35610at.m58447a(context2, str4, str5, str6, bk, true);
                        if (a == null) {
                            C4990ab.m7412e("MicroMsg.WebviewShrotcutManager", "intent is null");
                            if (c14514a2 != null) {
                                c14514a2.mo26754hJ(false);
                                AppMethodBeat.m2505o(6803);
                                return;
                            }
                        }
                        C42781b.m75869r(context2, a);
                        if (c14514a2 != null) {
                            c14514a2.mo26754hJ(true);
                        }
                    } else if (c14514a2 != null) {
                        c14514a2.mo26754hJ(false);
                        AppMethodBeat.m2505o(6803);
                        return;
                    }
                    AppMethodBeat.m2505o(6803);
                    return;
                }
                AppMethodBeat.m2505o(6803);
            }
        };
        unz.add(c356112);
        C17884o.acd().mo67498a(c356112);
        Bitmap bi = C35610at.m58450bi(context, str);
        if (bi == null || bi.isRecycled()) {
            C4990ab.m7412e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
            new C7564ap(new C29819b(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(6804);
                    C4990ab.m7416i("MicroMsg.WebviewShrotcutManager", "expired");
                    if (C35610at.unz.contains(c356112)) {
                        C35610at.unz.remove(c356112);
                        C17884o.acd().mo67500b(c356112);
                        if (c14514a != null) {
                            c14514a.mo26754hJ(false);
                        }
                    }
                    AppMethodBeat.m2505o(6804);
                }
            }), false).mo16770ae(5000, 5000);
            AppMethodBeat.m2505o(6807);
            return;
        }
        unz.remove(c356112);
        C17884o.acd().mo67500b(c356112);
        Intent a = C35610at.m58447a(context, str, str2, str3, bi, true);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.WebviewShrotcutManager", "intent is null");
            if (c14514a != null) {
                c14514a.mo26754hJ(false);
            }
            AppMethodBeat.m2505o(6807);
            return;
        }
        C42781b.m75869r(context, a);
        if (c14514a != null) {
            c14514a.mo26754hJ(true);
        }
        AppMethodBeat.m2505o(6807);
    }

    /* renamed from: f */
    public static void m58454f(Context context, String str, String str2, String str3) {
        AppMethodBeat.m2504i(6809);
        if (context == null || C5046bo.isNullOrNil(str3)) {
            C4990ab.m7412e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
        }
        Intent a = C35610at.m58447a(context, str, str2, str3, null, false);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
            AppMethodBeat.m2505o(6809);
            return;
        }
        C42781b.m75870s(context, a);
        AppMethodBeat.m2505o(6809);
    }

    /* renamed from: a */
    public static Intent m58447a(Context context, String str, String str2, String str3, Bitmap bitmap, boolean z) {
        AppMethodBeat.m2504i(6810);
        C4990ab.m7417i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", Boolean.valueOf(z));
        if (bitmap == null && z) {
            C4990ab.m7412e("MicroMsg.WebviewShrotcutManager", "no bmp");
            AppMethodBeat.m2505o(6810);
            return null;
        }
        String Fv = C35610at.m58445Fv(str);
        if (C5046bo.isNullOrNil(Fv)) {
            AppMethodBeat.m2505o(6810);
            return null;
        }
        Intent intent = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", str3);
        intent.putExtra("duplicate", false);
        String str4 = "";
        C17880h qo = C17884o.act().mo33392qo(str);
        if (qo != null) {
            str4 = C1178g.m2591x((str3 + qo.acl()).getBytes());
        }
        Intent intent2 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
        intent2.putExtra("type", 2);
        intent2.putExtra("id", Fv);
        intent2.putExtra("ext_info", C35610at.m58445Fv(str2));
        intent2.putExtra("ext_info_1", C35610at.m58445Fv(str3));
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        intent2.putExtra("token", C35610at.m58453db(str2, stringBuilder.append(C1668a.m3383QF()).toString()));
        intent2.putExtra("digest", str4);
        intent2.setPackage(context.getPackageName());
        intent2.addFlags(67108864);
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        AppMethodBeat.m2505o(6810);
        return intent;
    }

    /* renamed from: Fv */
    private static String m58445Fv(String str) {
        AppMethodBeat.m2504i(6811);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(6811);
            return null;
        }
        String da = C42781b.m75867da(str, C1427q.m3026LK());
        if (C5046bo.isNullOrNil(da)) {
            AppMethodBeat.m2505o(6811);
            return null;
        }
        String str2 = "shortcut_" + C42781b.m75858V(da.getBytes());
        AppMethodBeat.m2505o(6811);
        return str2;
    }

    /* renamed from: db */
    public static String m58453db(String str, String str2) {
        AppMethodBeat.m2504i(6812);
        String x = C1178g.m2591x((C1178g.m2591x(str.getBytes()) + C42781b.m75867da(str2, str)).getBytes());
        AppMethodBeat.m2505o(6812);
        return x;
    }

    /* renamed from: bj */
    private static boolean m58451bj(Context context, String str) {
        AppMethodBeat.m2504i(6813);
        try {
            String str2;
            boolean z;
            ContentResolver contentResolver = context.getContentResolver();
            List<PackageInfo> installedPackages = C4996ah.getContext().getPackageManager().getInstalledPackages(8);
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
            AppMethodBeat.m2505o(6813);
            return z;
        } catch (Exception e) {
            AppMethodBeat.m2505o(6813);
            return false;
        }
    }

    /* renamed from: bi */
    private static Bitmap m58450bi(Context context, String str) {
        AppMethodBeat.m2504i(6808);
        Bitmap a = C41730b.m73490a(str, false, -1);
        if (a == null || a.isRecycled()) {
            AppMethodBeat.m2505o(6808);
            return a;
        }
        int i = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        a = Bitmap.createScaledBitmap(a, i, i, false);
        AppMethodBeat.m2505o(6808);
        return a;
    }
}
