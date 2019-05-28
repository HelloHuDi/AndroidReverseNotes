package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedHashMap;

public final class p {
    public static String f(Context context, String str, String str2) {
        AppMethodBeat.i(79335);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            ab.e("MicroMsg.AppUtil", "buildSourceUrl fail, invalid arguments");
            AppMethodBeat.o(79335);
            return null;
        }
        String g = aa.g(context.getSharedPreferences(ah.doA(), 0));
        if (g == null || g.length() == 0) {
            g = "zh_CN";
        } else if (g.equals("en")) {
            g = "en_US";
        }
        g = context.getString(R.string.dau, new Object[]{str, Integer.valueOf(d.vxo), g, d.eSg, str2});
        AppMethodBeat.o(79335);
        return g;
    }

    public static String C(Context context, String str, String str2) {
        AppMethodBeat.i(79336);
        if (str == null || str.length() == 0 || str2.length() == 0) {
            ab.e("MicroMsg.AppUtil", "buildUnistallUrl fail, invalid arguments");
            AppMethodBeat.o(79336);
            return null;
        }
        String g = aa.g(context.getSharedPreferences(ah.doA(), 0));
        if (g == null || g.length() == 0) {
            g = "zh_CN";
        } else if (g.equals("en")) {
            g = "en_US";
        }
        g = context.getString(R.string.dav, new Object[]{str, Integer.valueOf(d.vxo), g, d.eSg, str2, Integer.valueOf(0)});
        AppMethodBeat.o(79336);
        return g;
    }

    public static String B(String str, String str2) {
        AppMethodBeat.i(79337);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppUtil", "buildRedirectUrl fail, invalid arguments");
            AppMethodBeat.o(79337);
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
        ab.v("MicroMsg.AppUtil", "buildRedirectUrl, sharpStr = %s, paramStr = %s, srcUrl = %s", str3, str4, str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!bo.isNullOrNil(str4)) {
            String[] split = str4.split("&");
            if (split != null && split.length > 0) {
                for (String str5 : split) {
                    if (!bo.isNullOrNil(str5)) {
                        Object substring;
                        Object substring2;
                        int indexOf3 = str5.indexOf("=");
                        ab.v("MicroMsg.AppUtil", "buildRedirectUrl, equalIdx = %d", Integer.valueOf(indexOf3));
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
        ab.v("MicroMsg.AppUtil", "buildRedirectUrl, pMap size = %d", Integer.valueOf(linkedHashMap.size()));
        StringBuilder stringBuilder = new StringBuilder();
        for (String str42 : linkedHashMap.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(str42);
            stringBuilder.append((String) linkedHashMap.get(str42));
        }
        str42 = str + "?" + stringBuilder.toString();
        if (!bo.isNullOrNil(str3)) {
            str42 = str42 + str3;
        }
        ab.v("MicroMsg.AppUtil", "buildRedirectUrl, ret url = %s", str42);
        AppMethodBeat.o(79337);
        return str42;
    }

    public static String bw(Context context, String str) {
        AppMethodBeat.i(79339);
        Signature[] bx = bx(context, str);
        if (bx == null || bx.length == 0) {
            ab.e("MicroMsg.AppUtil", "signs is null");
            AppMethodBeat.o(79339);
            return null;
        }
        String aiQ = q.aiQ(g.x(bx[0].toByteArray()));
        AppMethodBeat.o(79339);
        return aiQ;
    }

    public static String aiO(String str) {
        AppMethodBeat.i(79340);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
            AppMethodBeat.o(79340);
            return null;
        }
        String aiQ = q.aiQ(str);
        AppMethodBeat.o(79340);
        return aiQ;
    }

    public static boolean d(Context context, f fVar, String str) {
        AppMethodBeat.i(139135);
        boolean a = a(context, fVar, str, false);
        AppMethodBeat.o(139135);
        return a;
    }

    public static boolean a(Context context, f fVar, String str, boolean z) {
        AppMethodBeat.i(79342);
        a bYQ = a.a.bYQ();
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppUtil", "isAppValid, packageName is null");
            bYQ.c(fVar);
            AppMethodBeat.o(79342);
            return false;
        } else if (fVar == null) {
            ab.i("MicroMsg.AppUtil", "app does not exist");
            AppMethodBeat.o(79342);
            return true;
        } else if (fVar.field_packageName == null || fVar.field_packageName.length() == 0) {
            ab.e("MicroMsg.AppUtil", "isAppValid fail, local packageName is null");
            bYQ.c(fVar);
            AppMethodBeat.o(79342);
            return false;
        } else if (fVar.field_signature == null || fVar.field_signature.length() == 0) {
            ab.e("MicroMsg.AppUtil", "isAppValid fail, local signature is null");
            bYQ.c(fVar);
            AppMethodBeat.o(79342);
            return false;
        } else {
            Signature[] bx = bx(context, str);
            if (bx == null || bx.length == 0) {
                ab.e("MicroMsg.AppUtil", "isAppValid, apk signatures is null");
                bYQ.c(fVar);
                AppMethodBeat.o(79342);
                return false;
            } else if (fVar.field_packageName.equals(str)) {
                ab.i("MicroMsg.AppUtil", "server signatures:%s", fVar.field_signature);
                int length = bx.length;
                int i = 0;
                while (i < length) {
                    ab.i("MicroMsg.AppUtil", "local signatures:%s", q.aiQ(g.x(bx[i].toByteArray())));
                    if (fVar.field_signature == null || !fVar.field_signature.equals(r6)) {
                        i++;
                    } else {
                        bYQ.d(fVar);
                        AppMethodBeat.o(79342);
                        return true;
                    }
                }
                if (z) {
                    Toast.makeText(context, context.getString(R.string.dat), 1).show();
                }
                ab.w("MicroMsg.AppUtil", "isAppValid, signature is diff");
                bYQ.c(fVar);
                AppMethodBeat.o(79342);
                return false;
            } else {
                ab.e("MicroMsg.AppUtil", "isAppValid, packageName is diff, src:%s,local:%s", fVar.field_packageName, str);
                bYQ.c(fVar);
                if (z) {
                    Toast.makeText(context, context.getString(R.string.das), 1).show();
                }
                AppMethodBeat.o(79342);
                return false;
            }
        }
    }

    public static void at(Bundle bundle) {
        AppMethodBeat.i(79343);
        if (bundle != null) {
            bundle.putString(Token.WX_TOKEN_KEY, Token.WX_TOKEN_VALUE_MSG);
        }
        AppMethodBeat.o(79343);
    }

    public static void au(Bundle bundle) {
        AppMethodBeat.i(79344);
        if (bundle != null) {
            bundle.putString(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
        }
        AppMethodBeat.o(79344);
    }

    public static void j(Bundle bundle, String str) {
        AppMethodBeat.i(79345);
        bundle.putString(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
        if (!bo.isNullOrNil(str)) {
            bundle.putString(Token.WX_LAUNCH_PARAM_KEY, str);
        }
        AppMethodBeat.o(79345);
    }

    public static Signature[] bx(Context context, String str) {
        AppMethodBeat.i(79346);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppUtil", "getSignature, packageName is null");
            AppMethodBeat.o(79346);
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                ab.e("MicroMsg.AppUtil", "info is null, packageName = ".concat(String.valueOf(str)));
                AppMethodBeat.o(79346);
                return null;
            }
            Signature[] signatureArr = packageInfo.signatures;
            AppMethodBeat.o(79346);
            return signatureArr;
        } catch (NameNotFoundException e) {
            ab.e("MicroMsg.AppUtil", "NameNotFoundException");
            AppMethodBeat.o(79346);
            return null;
        }
    }

    public static boolean b(Context context, f fVar) {
        AppMethodBeat.i(79347);
        ab.i("MicroMsg.AppUtil", "check the signature of the Application.");
        if (context == null) {
            ab.e("MicroMsg.AppUtil", "context is null.");
            AppMethodBeat.o(79347);
            return true;
        } else if (fVar == null) {
            ab.e("MicroMsg.AppUtil", "appInfo is null.");
            AppMethodBeat.o(79347);
            return true;
        } else if (bo.isNullOrNil(fVar.field_packageName)) {
            ab.e("MicroMsg.AppUtil", "packageName is null.");
            AppMethodBeat.o(79347);
            return true;
        } else if (bo.isNullOrNil(fVar.field_signature)) {
            ab.e("MicroMsg.AppUtil", "app.field_signature is null. app.field_packageName is %s", fVar.field_packageName);
            AppMethodBeat.o(79347);
            return true;
        } else {
            Signature[] bx = bx(context, fVar.field_packageName);
            if (bx == null || bx.length == 0) {
                ab.e("MicroMsg.AppUtil", "apk signatures is null");
                AppMethodBeat.o(79347);
                return false;
            }
            for (Signature toByteArray : bx) {
                if (fVar.field_signature.equals(q.aiQ(g.x(toByteArray.toByteArray())))) {
                    ab.i("MicroMsg.AppUtil", "app_name : %s ,signature : %s", fVar.field_appName, fVar.field_signature);
                    AppMethodBeat.o(79347);
                    return true;
                }
            }
            ab.w("MicroMsg.AppUtil", "signature is diff.(app_name:%s)", fVar.field_appName);
            AppMethodBeat.o(79347);
            return false;
        }
    }

    public static void aiP(String str) {
        AppMethodBeat.i(79348);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppUtil", "appid is null");
            AppMethodBeat.o(79348);
            return;
        }
        SharedPreferences doB = ah.doB();
        if (doB != null) {
            String string = doB.getString("key_app_ids_registion_while_not_login", "");
            if (string.contains(str)) {
                ab.i("MicroMsg.AppUtil", "this app has been saved : %s in %s", str, string);
                AppMethodBeat.o(79348);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(string);
            doB.edit().putString("key_app_ids_registion_while_not_login", stringBuilder.toString()).commit();
        }
        AppMethodBeat.o(79348);
    }

    public static void dhH() {
        ao.vdg = null;
        ao.vdh = -1;
    }

    public static void dhI() {
        AppMethodBeat.i(79349);
        SharedPreferences doB = ah.doB();
        if (doB != null) {
            doB.edit().putString("key_app_ids_registion_while_not_login", "").commit();
        }
        AppMethodBeat.o(79349);
    }

    public static boolean u(Context context, String str) {
        AppMethodBeat.i(79338);
        if (b.getPackageInfo(context, str) != null) {
            AppMethodBeat.o(79338);
            return true;
        }
        AppMethodBeat.o(79338);
        return false;
    }
}
