package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.se;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class e {
    private static final ae<Integer, Typeface> AhE = new ae(4);
    private static SimpleDateFormat kIy = null;
    private static final String[] tGn = new String[]{"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "COMM_DEBIT", "HSBC_DEBIT"};
    protected static final Pattern vrO = Pattern.compile("((?:(http|https|Http|Https):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9][a-zA-Z0-9\\-\\_]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnrwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eouw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agkmsyz]|v[aceginu]|w[fs]|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");

    public interface b {
        void bZ(Object obj);
    }

    public interface a {
        void ak(Map<String, Object> map);
    }

    public static class c {
        public String key = null;
        public Object xBi = null;

        public c(String str, Object obj) {
            this.key = str;
            this.xBi = obj;
        }
    }

    static /* synthetic */ int arI(String str) {
        AppMethodBeat.i(49327);
        int atz = atz(str);
        AppMethodBeat.o(49327);
        return atz;
    }

    static {
        AppMethodBeat.i(49328);
        AppMethodBeat.o(49328);
    }

    public static Typeface ex(Context context) {
        AppMethodBeat.i(49263);
        Typeface aA = aA(context, 4);
        AppMethodBeat.o(49263);
        return aA;
    }

    public static Typeface aA(Context context, int i) {
        AppMethodBeat.i(49265);
        Typeface typeface;
        if (i == 8) {
            typeface = Typeface.DEFAULT;
            AppMethodBeat.o(49265);
            return typeface;
        } else if (VERSION.SDK_INT > 23) {
            typeface = Typeface.createFromAsset(context.getAssets(), QQ(i));
            AppMethodBeat.o(49265);
            return typeface;
        } else {
            typeface = (Typeface) AhE.get(Integer.valueOf(i));
            if (typeface == null) {
                typeface = Typeface.createFromAsset(context.getAssets(), QQ(i));
                AhE.put(Integer.valueOf(i), typeface);
            }
            AppMethodBeat.o(49265);
            return typeface;
        }
    }

    public static String QQ(int i) {
        switch (i) {
            case 0:
                return "fonts/WeChatSansSS-Medium.ttf";
            case 1:
                return "fonts/WeChatSansSS-Bold.ttf";
            case 2:
                return "fonts/WeChatSansSS-Light.ttf";
            case 3:
                return "fonts/WeChatSansSS-Regular.ttf";
            case 4:
                return "fonts/WeChatSansStd-Medium.ttf";
            case 5:
                return "fonts/WeChatSansStd-Bold.ttf";
            case 6:
                return "fonts/WeChatSansStd-Light.ttf";
            case 7:
                return "fonts/WeChatSansStd-Regular.ttf";
            default:
                return "fonts/WeChatSansSS-Medium.ttf";
        }
    }

    public static void setNoSystemInputOnEditText(EditText editText) {
        AppMethodBeat.i(49266);
        if (VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            AppMethodBeat.o(49266);
            return;
        }
        Class cls = EditText.class;
        try {
            Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
            method.setAccessible(false);
            method.invoke(editText, new Object[]{Boolean.FALSE});
            AppMethodBeat.o(49266);
        } catch (NoSuchMethodException e) {
            ab.e("erik", "setShowSoftInputOnFocus exception!");
            try {
                Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                method2.setAccessible(false);
                method2.invoke(editText, new Object[]{Boolean.FALSE});
                AppMethodBeat.o(49266);
            } catch (Exception e2) {
                editText.setInputType(0);
                ab.printErrStackTrace("MicroMsg.WalletBaseUtil ", e2, "", new Object[0]);
                AppMethodBeat.o(49266);
            }
        } catch (Exception e22) {
            ab.printErrStackTrace("MicroMsg.WalletBaseUtil ", e22, "", new Object[0]);
            AppMethodBeat.o(49266);
        }
    }

    public static void dOJ() {
    }

    public static String e(double d, String str) {
        AppMethodBeat.i(49267);
        String format;
        if ("CNY".equals(str)) {
            format = String.format("¥%.2f", new Object[]{Double.valueOf(d)});
            AppMethodBeat.o(49267);
            return format;
        } else if ("ZAR".equals(str)) {
            format = String.format("R%.2f", new Object[]{Double.valueOf(d)});
            AppMethodBeat.o(49267);
            return format;
        } else if ("1".equals(str) || bo.isNullOrNil(str)) {
            format = String.format(com.tencent.mm.wallet_core.c.ae.dOd() + "%.2f", new Object[]{Double.valueOf(d)});
            AppMethodBeat.o(49267);
            return format;
        } else {
            format = String.format(str + "%.2f", new Object[]{Double.valueOf(d)});
            AppMethodBeat.o(49267);
            return format;
        }
    }

    public static String atq(String str) {
        AppMethodBeat.i(49268);
        if ("CNY".equals(str)) {
            str = "¥";
            AppMethodBeat.o(49268);
            return str;
        } else if ("ZAR".equals(str)) {
            str = "R";
            AppMethodBeat.o(49268);
            return str;
        } else if ("1".equals(str) || bo.isNullOrNil(str)) {
            str = com.tencent.mm.wallet_core.c.ae.dOd();
            AppMethodBeat.o(49268);
            return str;
        } else {
            AppMethodBeat.o(49268);
            return str;
        }
    }

    public static String G(double d) {
        AppMethodBeat.i(49269);
        String e = e(d, "");
        AppMethodBeat.o(49269);
        return e;
    }

    public static String F(double d) {
        AppMethodBeat.i(49270);
        String format = String.format("%.2f", new Object[]{Double.valueOf(d)});
        AppMethodBeat.o(49270);
        return format;
    }

    public static String atr(String str) {
        AppMethodBeat.i(49271);
        if ("CNY".equals(str) || "1".equals(str) || bo.isNullOrNil(str)) {
            str = "¥";
            AppMethodBeat.o(49271);
            return str;
        }
        AppMethodBeat.o(49271);
        return str;
    }

    public static String kC(int i) {
        AppMethodBeat.i(49272);
        if (kIy == null) {
            kIy = new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm);
        }
        String format = kIy.format(new Date(((long) i) * 1000));
        AppMethodBeat.o(49272);
        return format;
    }

    public static String QR(int i) {
        AppMethodBeat.i(49273);
        String a = a(i, new SimpleDateFormat("MM-dd HH:mm"), new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm));
        AppMethodBeat.o(49273);
        return a;
    }

    public static String a(int i, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
        AppMethodBeat.i(49274);
        long j = ((long) i) * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j);
        String format;
        if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
            format = simpleDateFormat.format(new Date(j));
            AppMethodBeat.o(49274);
            return format;
        }
        format = simpleDateFormat2.format(new Date(j));
        AppMethodBeat.o(49274);
        return format;
    }

    public static void af(Context context, String str) {
        AppMethodBeat.i(49275);
        if (TextUtils.isEmpty(str)) {
            ab.v("MicroMsg.WalletBaseUtil ", "username is null");
            AppMethodBeat.o(49275);
        } else if (t.mY(str)) {
            ag(context, str);
            AppMethodBeat.o(49275);
        } else {
            ae(context, str);
            AppMethodBeat.o(49275);
        }
    }

    public static void n(Context context, String str, boolean z) {
        AppMethodBeat.i(49276);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", z);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(49276);
    }

    public static void a(Context context, String str, boolean z, int i) {
        AppMethodBeat.i(49277);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", z);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, i);
        AppMethodBeat.o(49277);
    }

    public static void ae(Context context, String str) {
        AppMethodBeat.i(49278);
        if (TextUtils.isEmpty(str)) {
            ab.v("MicroMsg.WalletBaseUtil ", "username is null");
            AppMethodBeat.o(49278);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        intent.putExtra("force_get_contact", true);
        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(49278);
    }

    public static void iu(Context context) {
        AppMethodBeat.i(49279);
        if (context == null) {
            ab.e("MicroMsg.WalletBaseUtil ", "hy: jump to preference error. context is null");
            AppMethodBeat.o(49279);
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        d.f(context, "com.tencent.mm.ui.LauncherUI", intent);
        AppMethodBeat.o(49279);
    }

    public static void ag(Context context, String str) {
        AppMethodBeat.i(49280);
        if (TextUtils.isEmpty(str)) {
            ab.v("MicroMsg.WalletBaseUtil ", "username is null");
            AppMethodBeat.o(49280);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        d.f(context, ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.o(49280);
    }

    public static boolean ats(String str) {
        AppMethodBeat.i(49281);
        if (vrO.matcher(str).matches()) {
            AppMethodBeat.o(49281);
            return true;
        }
        AppMethodBeat.o(49281);
        return false;
    }

    public static String att(String str) {
        AppMethodBeat.i(49282);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(49282);
            return str;
        }
        String str2 = "";
        for (int i = 0; i < str.length() - 1; i++) {
            str2 = str2 + "*";
        }
        str = str2 + str.substring(str.length() - 1, str.length());
        AppMethodBeat.o(49282);
        return str;
    }

    public static boolean n(JSONObject jSONObject, String str) {
        AppMethodBeat.i(49283);
        boolean equals = "1".equals(jSONObject.optString(str, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        AppMethodBeat.o(49283);
        return equals;
    }

    public static String getUsername() {
        AppMethodBeat.i(49284);
        g.RN().QU();
        String Yz = r.Yz();
        AppMethodBeat.o(49284);
        return Yz;
    }

    public static String atu(String str) {
        AppMethodBeat.i(49285);
        if (str == null || str.length() <= 8) {
            AppMethodBeat.o(49285);
            return str;
        }
        int length = str.length();
        String substring = str.substring(0, length - 8);
        str = substring + "****" + str.substring(length - 4);
        AppMethodBeat.o(49285);
        return str;
    }

    public static String atv(String str) {
        AppMethodBeat.i(49286);
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = "";
            AppMethodBeat.o(49286);
            return str2;
        }
        str2 = str.substring(1, str.length());
        ab.d("MicroMsg.WalletBaseUtil ", "tail : ".concat(String.valueOf(str2)));
        String substring = str.substring(0, 1);
        ab.d("MicroMsg.WalletBaseUtil ", "head : ".concat(String.valueOf(substring)));
        ab.d("MicroMsg.WalletBaseUtil ", "after : ".concat(String.valueOf(substring)));
        str2 = "*".concat(String.valueOf(str2));
        AppMethodBeat.o(49286);
        return str2;
    }

    public static String atw(String str) {
        AppMethodBeat.i(49287);
        String atv;
        if (str == null || str.length() < 2) {
            atv = atv(str);
            AppMethodBeat.o(49287);
            return atv;
        }
        atv = "**".concat(String.valueOf(str.substring(str.length() - 1, str.length())));
        AppMethodBeat.o(49287);
        return atv;
    }

    public static void a(final Context context, final String str, String str2, boolean z, boolean z2) {
        AppMethodBeat.i(49288);
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(context.getString(R.string.faa));
        linkedList2.add(Integer.valueOf(0));
        if (str != null && z2) {
            linkedList.add(context.getString(R.string.fa9));
            linkedList2.add(Integer.valueOf(1));
        }
        if (z && !bo.isNullOrNil(str2)) {
            linkedList.add(context.getString(R.string.fab, new Object[]{str2}));
            linkedList2.add(Integer.valueOf(2));
            linkedList.add(context.getString(R.string.fac, new Object[]{str2}));
            linkedList2.add(Integer.valueOf(3));
        }
        h.a(context, "", linkedList, linkedList2, "", new h.d() {
            public final void bV(int i, int i2) {
                AppMethodBeat.i(49256);
                Intent intent = new Intent();
                switch (i) {
                    case 0:
                        intent.putExtra("rawUrl", context.getString(R.string.f84, new Object[]{aa.dor()}));
                        break;
                    case 1:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(R.string.f82, new Object[]{aa.dor(), str}));
                            break;
                        }
                        break;
                    case 2:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(R.string.f85, new Object[]{aa.dor(), str}));
                            break;
                        }
                        break;
                    case 3:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(R.string.f86, new Object[]{aa.dor(), str}));
                            break;
                        }
                        break;
                }
                intent.putExtra("showShare", false);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(49256);
            }
        });
        AppMethodBeat.o(49288);
    }

    public static void d(MMActivity mMActivity, String str) {
        AppMethodBeat.i(49289);
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("bank_card_owner", str);
        d.b((Context) mMActivity, "scanner", ".ui.BaseScanUI", intent);
        AppMethodBeat.o(49289);
    }

    public static String mJ(String str) {
        String Oj;
        AppMethodBeat.i(49290);
        g.RQ();
        ad aoN = ((j) g.K(j.class)).XM().aoN(str);
        if (aoN != null) {
            Oj = aoN.Oj();
        } else {
            Oj = null;
        }
        if (!bo.isNullOrNil(Oj)) {
            str = Oj;
        }
        AppMethodBeat.o(49290);
        return str;
    }

    public static void bU(Context context, String str) {
        AppMethodBeat.i(49291);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(49291);
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
        intent.addFlags(268435456);
        context.startActivity(intent);
        AppMethodBeat.o(49291);
    }

    public static long H(double d) {
        AppMethodBeat.i(49292);
        long round = Math.round(100.0d * d);
        AppMethodBeat.o(49292);
        return round;
    }

    public static void a(final c... cVarArr) {
        AppMethodBeat.i(49293);
        g.RQ();
        g.RO().eJo.a(new bk(new com.tencent.mm.model.bk.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                AppMethodBeat.i(49257);
                if (eVar == null || eVar.adg() == null) {
                    AppMethodBeat.o(49257);
                } else if (cVarArr == null || cVarArr.length == 0) {
                    ab.w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
                    AppMethodBeat.o(49257);
                } else {
                    try {
                        for (c cVar : cVarArr) {
                            if (!(cVar == null || bo.isNullOrNil(cVar.key))) {
                                eVar.adg().o(cVar.key, e.cZ(cVar.xBi));
                            }
                        }
                        AppMethodBeat.o(49257);
                    } catch (Exception e) {
                        ab.e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", e.toString());
                        AppMethodBeat.o(49257);
                    }
                }
            }
        }), 0);
        AppMethodBeat.o(49293);
    }

    public static void a(final String str, final b bVar) {
        AppMethodBeat.i(49294);
        g.RQ();
        g.RO().eJo.a(new bk(new com.tencent.mm.model.bk.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                AppMethodBeat.i(49258);
                if (eVar == null || eVar.adg() == null) {
                    AppMethodBeat.o(49258);
                } else if (bo.isNullOrNil(str)) {
                    ab.w("MicroMsg.WalletBaseUtil ", "hy: key is null");
                    AppMethodBeat.o(49258);
                } else {
                    try {
                        byte[] qr = eVar.adg().qr(str);
                        if (bVar != null) {
                            if (qr != null) {
                                bVar.bZ(e.cg(qr));
                                AppMethodBeat.o(49258);
                                return;
                            }
                            bVar.bZ(null);
                        }
                        AppMethodBeat.o(49258);
                    } catch (Exception e) {
                        ab.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", e.toString());
                        if (bVar != null) {
                            bVar.bZ(null);
                        }
                        AppMethodBeat.o(49258);
                    }
                }
            }
        }), 0);
        AppMethodBeat.o(49294);
    }

    public static void dOK() {
        AppMethodBeat.i(49295);
        g.RQ();
        g.RO().eJo.a(new bk(new com.tencent.mm.model.bk.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                AppMethodBeat.i(49259);
                eVar.adi();
                AppMethodBeat.o(49259);
            }
        }), 0);
        AppMethodBeat.o(49295);
    }

    public static String aty(String str) {
        AppMethodBeat.i(49297);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.o(49297);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length() / 4;
        for (int i = 0; i < length; i++) {
            int min = Math.min((i + 1) * 4, str.length());
            if (min + 4 > str.length()) {
                min = str.length();
            }
            stringBuilder.append(ix(str.substring(i * 4, min), " "));
            if (min - (i * 4) == 4) {
                for (min = 0; min < 6; min++) {
                    stringBuilder.append(" ");
                }
            }
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.o(49297);
        return str2;
    }

    public static void ar(ArrayList<Bitmap> arrayList) {
        AppMethodBeat.i(49298);
        if (arrayList != null && arrayList.size() > 0) {
            for (int size = arrayList.size() - 1; size > 0; size--) {
                K((Bitmap) arrayList.remove(size));
            }
        }
        AppMethodBeat.o(49298);
    }

    public static void K(Bitmap bitmap) {
        AppMethodBeat.i(49299);
        if (!(bitmap == null || bitmap.isRecycled())) {
            bitmap.recycle();
        }
        AppMethodBeat.o(49299);
    }

    public static Bitmap J(Bitmap bitmap) {
        boolean z = true;
        AppMethodBeat.i(49300);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        String str = "MicroMsg.WalletBaseUtil ";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        ab.d(str, stringBuilder.append(z).append("  degree:90.0").toString());
        AppMethodBeat.o(49300);
        return createBitmap;
    }

    private static String ix(String str, String str2) {
        AppMethodBeat.i(49301);
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
            AppMethodBeat.o(49301);
            return str3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.substring(i, i + 1));
            if (i != str.length() - 1) {
                stringBuilder.append(str2);
            }
        }
        str3 = stringBuilder.toString();
        AppMethodBeat.o(49301);
        return str3;
    }

    public static void a(final String[] strArr, final a aVar) {
        AppMethodBeat.i(49303);
        g.RQ();
        g.RO().eJo.a(new bk(new com.tencent.mm.model.bk.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                AppMethodBeat.i(49260);
                if (eVar == null || eVar.adg() == null) {
                    AppMethodBeat.o(49260);
                } else if (strArr == null || strArr.length == 0) {
                    ab.w("MicroMsg.WalletBaseUtil ", "hy: keys is null");
                    AppMethodBeat.o(49260);
                } else {
                    HashMap hashMap = new HashMap();
                    int i = 0;
                    while (i < strArr.length) {
                        try {
                            String str = strArr[i];
                            if (bo.isNullOrNil(str)) {
                                ab.e("MicroMsg.WalletBaseUtil ", "hy: key is null");
                            } else {
                                byte[] qr = eVar.adg().qr(str);
                                if (qr != null) {
                                    hashMap.put(str, e.cg(qr));
                                }
                            }
                            i++;
                        } catch (Exception e) {
                            ab.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", e.toString());
                            if (aVar != null) {
                                aVar.ak(null);
                            }
                            AppMethodBeat.o(49260);
                            return;
                        }
                    }
                    if (aVar != null) {
                        aVar.ak(hashMap);
                    }
                    AppMethodBeat.o(49260);
                }
            }
        }), 0);
        AppMethodBeat.o(49303);
    }

    public static void QS(int i) {
        AppMethodBeat.i(49304);
        com.tencent.mm.plugin.report.service.h.pYm.e(12719, Integer.valueOf(i), Integer.valueOf(1));
        AppMethodBeat.o(49304);
    }

    public static void a(final TextView textView, final String str, String str2, final String str3) {
        AppMethodBeat.i(49305);
        if (textView == null) {
            ab.e("MicroMsg.WalletBaseUtil ", "hy: text view is null.");
            AppMethodBeat.o(49305);
        } else if (bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.WalletBaseUtil ", "hy: msg is null. set text view to gone");
            textView.setVisibility(8);
            AppMethodBeat.o(49305);
        } else {
            textView.setVisibility(0);
            textView.setText(str2);
            com.tencent.mm.protocal.g.gu(atz(str), 0);
            if (!bo.isNullOrNil(str3)) {
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(49261);
                        ab.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str3);
                        intent.putExtra("showShare", false);
                        d.b(textView.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                        com.tencent.mm.protocal.g.gu(e.arI(str), 1);
                        AppMethodBeat.o(49261);
                    }
                });
            }
            AppMethodBeat.o(49305);
        }
    }

    private static int atz(String str) {
        AppMethodBeat.i(49306);
        if ("1".equals(str)) {
            AppMethodBeat.o(49306);
            return 0;
        } else if ("2".equals(str)) {
            AppMethodBeat.o(49306);
            return 4;
        } else if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str)) {
            AppMethodBeat.o(49306);
            return 12;
        } else if ("4".equals(str)) {
            AppMethodBeat.o(49306);
            return 2;
        } else if ("5".equals(str)) {
            AppMethodBeat.o(49306);
            return 8;
        } else if ("6".equals(str)) {
            AppMethodBeat.o(49306);
            return 14;
        } else if ("7".equals(str)) {
            AppMethodBeat.o(49306);
            return 16;
        } else if ("8".equals(str)) {
            AppMethodBeat.o(49306);
            return 10;
        } else {
            AppMethodBeat.o(49306);
            return -1;
        }
    }

    public static void a(int i, long j, int i2) {
        AppMethodBeat.i(49307);
        com.tencent.mm.plugin.report.service.h.pYm.e(13375, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(j), Integer.valueOf(i2));
        AppMethodBeat.o(49307);
    }

    public static String atA(String str) {
        AppMethodBeat.i(49308);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(49308);
            return str;
        } else if (str.length() > 14) {
            str = str.substring(0, 14) + "...";
            AppMethodBeat.o(49308);
            return str;
        } else {
            AppMethodBeat.o(49308);
            return str;
        }
    }

    public static String eK(String str, int i) {
        AppMethodBeat.i(49309);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(49309);
            return str;
        } else if (str.length() > i) {
            str = str.substring(0, i) + "...";
            AppMethodBeat.o(49309);
            return str;
        } else {
            AppMethodBeat.o(49309);
            return str;
        }
    }

    public static String eL(String str, int i) {
        AppMethodBeat.i(49310);
        String eK = eK(mJ(str), i);
        AppMethodBeat.o(49310);
        return eK;
    }

    public static void d(TextView textView, String str) {
        AppMethodBeat.i(49311);
        textView.setText(com.tencent.mm.pluginsdk.ui.e.j.b(textView.getContext(), eL(str, 10), textView.getTextSize()));
        AppMethodBeat.o(49311);
    }

    public static long a(String str, String str2, RoundingMode roundingMode) {
        AppMethodBeat.i(49312);
        long longValue = a(str, str2, 0, roundingMode).longValue();
        AppMethodBeat.o(49312);
        return longValue;
    }

    public static double b(String str, String str2, RoundingMode roundingMode) {
        AppMethodBeat.i(49313);
        double doubleValue = a(str, str2, 2, roundingMode).doubleValue();
        AppMethodBeat.o(49313);
        return doubleValue;
    }

    public static BigDecimal a(String str, String str2, int i, RoundingMode roundingMode) {
        AppMethodBeat.i(49314);
        BigDecimal divide;
        try {
            divide = new BigDecimal(bo.getDouble(str, 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), i, roundingMode);
            AppMethodBeat.o(49314);
            return divide;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletBaseUtil ", e, "", new Object[0]);
            divide = new BigDecimal(0);
            AppMethodBeat.o(49314);
            return divide;
        }
    }

    public static double c(String str, String str2, RoundingMode roundingMode) {
        AppMethodBeat.i(49315);
        double doubleValue = b(str, str2, 2, roundingMode).doubleValue();
        AppMethodBeat.o(49315);
        return doubleValue;
    }

    public static int iy(String str, String str2) {
        AppMethodBeat.i(49316);
        int intValue = b(str, str2, 0, RoundingMode.HALF_UP).intValue();
        AppMethodBeat.o(49316);
        return intValue;
    }

    public static long iz(String str, String str2) {
        AppMethodBeat.i(49317);
        long longValue = b(str, str2, 0, RoundingMode.HALF_UP).longValue();
        AppMethodBeat.o(49317);
        return longValue;
    }

    public static BigDecimal b(String str, String str2, int i, RoundingMode roundingMode) {
        AppMethodBeat.i(49318);
        BigDecimal scale;
        try {
            scale = new BigDecimal(bo.getDouble(str, 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).multiply(new BigDecimal(bo.getDouble(str2, 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str2.trim())).setScale(i, roundingMode);
            AppMethodBeat.o(49318);
            return scale;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletBaseUtil ", e, "", new Object[0]);
            scale = new BigDecimal(0);
            AppMethodBeat.o(49318);
            return scale;
        }
    }

    public static boolean dOL() {
        AppMethodBeat.i(49319);
        l lVar = (l) g.K(l.class);
        if (lVar == null) {
            ab.w("MicroMsg.WalletBaseUtil ", "bio no finger mgr!");
            AppMethodBeat.o(49319);
            return false;
        }
        ab.i("MicroMsg.WalletBaseUtil ", "has fp: %s, has faceid: %s", Boolean.valueOf(lVar.bxo()), Boolean.valueOf(lVar.bxB()));
        if (lVar.bxo() || r0) {
            AppMethodBeat.o(49319);
            return true;
        }
        AppMethodBeat.o(49319);
        return false;
    }

    public static void aA(final View view, final int i) {
        AppMethodBeat.i(49320);
        final View view2 = (View) view.getParent();
        view2.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(49262);
                Rect rect = new Rect();
                view.getHitRect(rect);
                rect.top -= i;
                rect.bottom += i;
                rect.left -= i;
                rect.right += i;
                view2.setTouchDelegate(new TouchDelegate(rect, view));
                AppMethodBeat.o(49262);
            }
        });
        AppMethodBeat.o(49320);
    }

    public static int atB(String str) {
        AppMethodBeat.i(49321);
        if (bo.isNullOrNil(str) || str.length() < 2) {
            ab.w("MicroMsg.WalletBaseUtil ", "illegal reqkey: %s", str);
            AppMethodBeat.o(49321);
            return 0;
        }
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100456");
        if (!ll.isValid()) {
            ab.w("MicroMsg.WalletBaseUtil ", "invalid abtest value");
            AppMethodBeat.o(49321);
            return 0;
        } else if (bo.getInt((String) ll.dru().get("open"), 0) == 0) {
            ab.i("MicroMsg.WalletBaseUtil ", "abtest unopened");
            AppMethodBeat.o(49321);
            return 0;
        } else {
            int i;
            if (str.startsWith("ts_wx") || str.startsWith("offline_wx") || str.startsWith("up_wx") || str.startsWith("wx")) {
                i = bo.getInt(str.substring(str.length() - 2), 0);
            } else {
                i = 0;
            }
            ab.d("MicroMsg.WalletBaseUtil ", "parse group id: %s, reqKey: %s", Integer.valueOf(i), str);
            AppMethodBeat.o(49321);
            return i;
        }
    }

    public static void atC(String str) {
        CharSequence str2;
        AppMethodBeat.i(49322);
        if (bo.isNullOrNil(str2)) {
            str2 = ah.getContext().getString(R.string.fu2);
        }
        Toast.makeText(ah.getContext(), str2, 1).show();
        AppMethodBeat.o(49322);
    }

    public static void aj(Context context, String str) {
        AppMethodBeat.i(49323);
        if (bo.isNullOrNil(str)) {
            str = ah.getContext().getString(R.string.fu2);
        }
        h.b(context, str, "", true);
        AppMethodBeat.o(49323);
    }

    public static void p(String str, String str2, int i, int i2) {
        AppMethodBeat.i(49324);
        se seVar = new se();
        seVar.cOf.userName = str;
        seVar.cOf.cOh = bo.bc(str2, "");
        seVar.cOf.axy = i;
        seVar.cOf.scene = i2;
        seVar.cOf.cOi = 0;
        com.tencent.mm.sdk.b.a.xxA.m(seVar);
        AppMethodBeat.o(49324);
    }

    public static Typeface bT(Context context, String str) {
        int i = 0;
        AppMethodBeat.i(49264);
        int i2 = -1;
        switch (str.hashCode()) {
            case 1865844108:
                if (str.equals("sans_ss")) {
                    i2 = 0;
                    break;
                }
                break;
            case 2006592631:
                if (str.equals("sans_std")) {
                    i2 = 1;
                    break;
                }
                break;
        }
        switch (i2) {
            case 0:
                break;
            case 1:
                i = 4;
                break;
            default:
                i = 8;
                break;
        }
        Typeface aA = aA(context, i);
        AppMethodBeat.o(49264);
        return aA;
    }

    public static String atx(String str) {
        AppMethodBeat.i(49296);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.o(49296);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length() / 4;
        for (int i = 0; i < length + 1; i++) {
            int min = Math.min((i + 1) * 4, str.length());
            stringBuilder.append(ix(str.substring(i * 4, min), ""));
            if (min - (i * 4) == 4) {
                for (min = 0; min < 4; min++) {
                    stringBuilder.append(" ");
                }
            }
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.o(49296);
        return str2;
    }

    public static void bV(Context context, String str) {
        AppMethodBeat.i(49302);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("pay_channel", 1);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(49302);
    }

    static /* synthetic */ byte[] cZ(Object obj) {
        AppMethodBeat.i(49325);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(49325);
        return toByteArray;
    }

    static /* synthetic */ Object cg(byte[] bArr) {
        AppMethodBeat.i(49326);
        Object readObject = new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
        AppMethodBeat.o(49326);
        return readObject;
    }
}
