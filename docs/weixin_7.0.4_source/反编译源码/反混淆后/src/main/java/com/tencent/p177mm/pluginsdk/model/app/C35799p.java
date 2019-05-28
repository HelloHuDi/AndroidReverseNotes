package com.tencent.p177mm.pluginsdk.model.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.appbrand.p328r.C19679b;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a.C3753a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedHashMap;

/* renamed from: com.tencent.mm.pluginsdk.model.app.p */
public final class C35799p {
    /* renamed from: f */
    public static String m58693f(Context context, String str, String str2) {
        AppMethodBeat.m2504i(79335);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppUtil", "buildSourceUrl fail, invalid arguments");
            AppMethodBeat.m2505o(79335);
            return null;
        }
        String g = C4988aa.m7402g(context.getSharedPreferences(C4996ah.doA(), 0));
        if (g == null || g.length() == 0) {
            g = "zh_CN";
        } else if (g.equals("en")) {
            g = "en_US";
        }
        g = context.getString(C25738R.string.dau, new Object[]{str, Integer.valueOf(C7243d.vxo), g, C7243d.eSg, str2});
        AppMethodBeat.m2505o(79335);
        return g;
    }

    /* renamed from: C */
    public static String m58685C(Context context, String str, String str2) {
        AppMethodBeat.m2504i(79336);
        if (str == null || str.length() == 0 || str2.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppUtil", "buildUnistallUrl fail, invalid arguments");
            AppMethodBeat.m2505o(79336);
            return null;
        }
        String g = C4988aa.m7402g(context.getSharedPreferences(C4996ah.doA(), 0));
        if (g == null || g.length() == 0) {
            g = "zh_CN";
        } else if (g.equals("en")) {
            g = "en_US";
        }
        g = context.getString(C25738R.string.dav, new Object[]{str, Integer.valueOf(C7243d.vxo), g, C7243d.eSg, str2, Integer.valueOf(0)});
        AppMethodBeat.m2505o(79336);
        return g;
    }

    /* renamed from: B */
    public static String m58684B(String str, String str2) {
        AppMethodBeat.m2504i(79337);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppUtil", "buildRedirectUrl fail, invalid arguments");
            AppMethodBeat.m2505o(79337);
            return null;
        }
        String str3;
        Object str22;
        int indexOf = str.indexOf("#");
        String str4 = "";
        if (indexOf >= 0) {
            str4 = str.substring(indexOf);
            str = str.substring(0, indexOf);
            str3 = str4;
        } else {
            str3 = str4;
        }
        int indexOf2 = str.indexOf("?");
        str4 = "";
        if (indexOf2 >= 0) {
            str4 = str.substring(indexOf2 + 1);
            str = str.substring(0, indexOf2);
        }
        C4990ab.m7419v("MicroMsg.AppUtil", "buildRedirectUrl, sharpStr = %s, paramStr = %s, srcUrl = %s", str3, str4, str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!C5046bo.isNullOrNil(str4)) {
            String[] split = str4.split("&");
            if (split != null && split.length > 0) {
                for (String str5 : split) {
                    if (!C5046bo.isNullOrNil(str5)) {
                        Object substring;
                        Object substring2;
                        int indexOf3 = str5.indexOf("=");
                        C4990ab.m7419v("MicroMsg.AppUtil", "buildRedirectUrl, equalIdx = %d", Integer.valueOf(indexOf3));
                        if (indexOf3 >= 0) {
                            substring = str5.substring(0, indexOf3 + 1);
                            substring2 = str5.substring(indexOf3 + 1);
                        } else {
                            substring2 = "";
                            str4 = str5;
                        }
                        linkedHashMap.put(substring, substring2);
                    }
                }
            }
        }
        str4 = "from=";
        if (str22 == null) {
            str22 = "";
        }
        linkedHashMap.put(str4, str22);
        C4990ab.m7419v("MicroMsg.AppUtil", "buildRedirectUrl, pMap size = %d", Integer.valueOf(linkedHashMap.size()));
        StringBuilder stringBuilder = new StringBuilder();
        for (String str42 : linkedHashMap.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(str42);
            stringBuilder.append((String) linkedHashMap.get(str42));
        }
        str42 = str + "?" + stringBuilder.toString();
        if (!C5046bo.isNullOrNil(str3)) {
            str42 = str42 + str3;
        }
        C4990ab.m7419v("MicroMsg.AppUtil", "buildRedirectUrl, ret url = %s", str42);
        AppMethodBeat.m2505o(79337);
        return str42;
    }

    /* renamed from: bw */
    public static String m58690bw(Context context, String str) {
        AppMethodBeat.m2504i(79339);
        Signature[] bx = C35799p.m58691bx(context, str);
        if (bx == null || bx.length == 0) {
            C4990ab.m7412e("MicroMsg.AppUtil", "signs is null");
            AppMethodBeat.m2505o(79339);
            return null;
        }
        String aiQ = C35800q.aiQ(C1178g.m2591x(bx[0].toByteArray()));
        AppMethodBeat.m2505o(79339);
        return aiQ;
    }

    public static String aiO(String str) {
        AppMethodBeat.m2504i(79340);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
            AppMethodBeat.m2505o(79340);
            return null;
        }
        String aiQ = C35800q.aiQ(str);
        AppMethodBeat.m2505o(79340);
        return aiQ;
    }

    /* renamed from: d */
    public static boolean m58692d(Context context, C40439f c40439f, String str) {
        AppMethodBeat.m2504i(139135);
        boolean a = C35799p.m58686a(context, c40439f, str, false);
        AppMethodBeat.m2505o(139135);
        return a;
    }

    /* renamed from: a */
    public static boolean m58686a(Context context, C40439f c40439f, String str, boolean z) {
        AppMethodBeat.m2504i(79342);
        C13114a bYQ = C3753a.bYQ();
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppUtil", "isAppValid, packageName is null");
            bYQ.mo25141c(c40439f);
            AppMethodBeat.m2505o(79342);
            return false;
        } else if (c40439f == null) {
            C4990ab.m7416i("MicroMsg.AppUtil", "app does not exist");
            AppMethodBeat.m2505o(79342);
            return true;
        } else if (c40439f.field_packageName == null || c40439f.field_packageName.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppUtil", "isAppValid fail, local packageName is null");
            bYQ.mo25141c(c40439f);
            AppMethodBeat.m2505o(79342);
            return false;
        } else if (c40439f.field_signature == null || c40439f.field_signature.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppUtil", "isAppValid fail, local signature is null");
            bYQ.mo25141c(c40439f);
            AppMethodBeat.m2505o(79342);
            return false;
        } else {
            Signature[] bx = C35799p.m58691bx(context, str);
            if (bx == null || bx.length == 0) {
                C4990ab.m7412e("MicroMsg.AppUtil", "isAppValid, apk signatures is null");
                bYQ.mo25141c(c40439f);
                AppMethodBeat.m2505o(79342);
                return false;
            } else if (c40439f.field_packageName.equals(str)) {
                C4990ab.m7417i("MicroMsg.AppUtil", "server signatures:%s", c40439f.field_signature);
                int length = bx.length;
                int i = 0;
                while (i < length) {
                    C4990ab.m7417i("MicroMsg.AppUtil", "local signatures:%s", C35800q.aiQ(C1178g.m2591x(bx[i].toByteArray())));
                    if (c40439f.field_signature == null || !c40439f.field_signature.equals(r6)) {
                        i++;
                    } else {
                        bYQ.mo25143d(c40439f);
                        AppMethodBeat.m2505o(79342);
                        return true;
                    }
                }
                if (z) {
                    Toast.makeText(context, context.getString(C25738R.string.dat), 1).show();
                }
                C4990ab.m7420w("MicroMsg.AppUtil", "isAppValid, signature is diff");
                bYQ.mo25141c(c40439f);
                AppMethodBeat.m2505o(79342);
                return false;
            } else {
                C4990ab.m7413e("MicroMsg.AppUtil", "isAppValid, packageName is diff, src:%s,local:%s", c40439f.field_packageName, str);
                bYQ.mo25141c(c40439f);
                if (z) {
                    Toast.makeText(context, context.getString(C25738R.string.das), 1).show();
                }
                AppMethodBeat.m2505o(79342);
                return false;
            }
        }
    }

    /* renamed from: at */
    public static void m58687at(Bundle bundle) {
        AppMethodBeat.m2504i(79343);
        if (bundle != null) {
            bundle.putString(Token.WX_TOKEN_KEY, Token.WX_TOKEN_VALUE_MSG);
        }
        AppMethodBeat.m2505o(79343);
    }

    /* renamed from: au */
    public static void m58688au(Bundle bundle) {
        AppMethodBeat.m2504i(79344);
        if (bundle != null) {
            bundle.putString(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
        }
        AppMethodBeat.m2505o(79344);
    }

    /* renamed from: j */
    public static void m58694j(Bundle bundle, String str) {
        AppMethodBeat.m2504i(79345);
        bundle.putString(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
        if (!C5046bo.isNullOrNil(str)) {
            bundle.putString(Token.WX_LAUNCH_PARAM_KEY, str);
        }
        AppMethodBeat.m2505o(79345);
    }

    /* renamed from: bx */
    public static Signature[] m58691bx(Context context, String str) {
        AppMethodBeat.m2504i(79346);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppUtil", "getSignature, packageName is null");
            AppMethodBeat.m2505o(79346);
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                C4990ab.m7412e("MicroMsg.AppUtil", "info is null, packageName = ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(79346);
                return null;
            }
            Signature[] signatureArr = packageInfo.signatures;
            AppMethodBeat.m2505o(79346);
            return signatureArr;
        } catch (NameNotFoundException e) {
            C4990ab.m7412e("MicroMsg.AppUtil", "NameNotFoundException");
            AppMethodBeat.m2505o(79346);
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m58689b(Context context, C40439f c40439f) {
        AppMethodBeat.m2504i(79347);
        C4990ab.m7416i("MicroMsg.AppUtil", "check the signature of the Application.");
        if (context == null) {
            C4990ab.m7412e("MicroMsg.AppUtil", "context is null.");
            AppMethodBeat.m2505o(79347);
            return true;
        } else if (c40439f == null) {
            C4990ab.m7412e("MicroMsg.AppUtil", "appInfo is null.");
            AppMethodBeat.m2505o(79347);
            return true;
        } else if (C5046bo.isNullOrNil(c40439f.field_packageName)) {
            C4990ab.m7412e("MicroMsg.AppUtil", "packageName is null.");
            AppMethodBeat.m2505o(79347);
            return true;
        } else if (C5046bo.isNullOrNil(c40439f.field_signature)) {
            C4990ab.m7413e("MicroMsg.AppUtil", "app.field_signature is null. app.field_packageName is %s", c40439f.field_packageName);
            AppMethodBeat.m2505o(79347);
            return true;
        } else {
            Signature[] bx = C35799p.m58691bx(context, c40439f.field_packageName);
            if (bx == null || bx.length == 0) {
                C4990ab.m7412e("MicroMsg.AppUtil", "apk signatures is null");
                AppMethodBeat.m2505o(79347);
                return false;
            }
            for (Signature toByteArray : bx) {
                if (c40439f.field_signature.equals(C35800q.aiQ(C1178g.m2591x(toByteArray.toByteArray())))) {
                    C4990ab.m7417i("MicroMsg.AppUtil", "app_name : %s ,signature : %s", c40439f.field_appName, c40439f.field_signature);
                    AppMethodBeat.m2505o(79347);
                    return true;
                }
            }
            C4990ab.m7421w("MicroMsg.AppUtil", "signature is diff.(app_name:%s)", c40439f.field_appName);
            AppMethodBeat.m2505o(79347);
            return false;
        }
    }

    public static void aiP(String str) {
        AppMethodBeat.m2504i(79348);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.AppUtil", "appid is null");
            AppMethodBeat.m2505o(79348);
            return;
        }
        SharedPreferences doB = C4996ah.doB();
        if (doB != null) {
            String string = doB.getString("key_app_ids_registion_while_not_login", "");
            if (string.contains(str)) {
                C4990ab.m7417i("MicroMsg.AppUtil", "this app has been saved : %s in %s", str, string);
                AppMethodBeat.m2505o(79348);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(string);
            doB.edit().putString("key_app_ids_registion_while_not_login", stringBuilder.toString()).commit();
        }
        AppMethodBeat.m2505o(79348);
    }

    public static void dhH() {
        C44058ao.vdg = null;
        C44058ao.vdh = -1;
    }

    public static void dhI() {
        AppMethodBeat.m2504i(79349);
        SharedPreferences doB = C4996ah.doB();
        if (doB != null) {
            doB.edit().putString("key_app_ids_registion_while_not_login", "").commit();
        }
        AppMethodBeat.m2505o(79349);
    }

    /* renamed from: u */
    public static boolean m58695u(Context context, String str) {
        AppMethodBeat.m2504i(79338);
        if (C19679b.getPackageInfo(context, str) != null) {
            AppMethodBeat.m2505o(79338);
            return true;
        }
        AppMethodBeat.m2505o(79338);
        return false;
    }
}
