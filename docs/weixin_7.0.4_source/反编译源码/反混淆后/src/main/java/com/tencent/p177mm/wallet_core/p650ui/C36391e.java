package com.tencent.p177mm.wallet_core.p650ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.C46516g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4993ae;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
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

/* renamed from: com.tencent.mm.wallet_core.ui.e */
public final class C36391e {
    private static final C4993ae<Integer, Typeface> AhE = new C4993ae(4);
    private static SimpleDateFormat kIy = null;
    private static final String[] tGn = new String[]{"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "COMM_DEBIT", "HSBC_DEBIT"};
    protected static final Pattern vrO = Pattern.compile("((?:(http|https|Http|Https):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9][a-zA-Z0-9\\-\\_]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnrwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eouw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agkmsyz]|v[aceginu]|w[fs]|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");

    /* renamed from: com.tencent.mm.wallet_core.ui.e$b */
    public interface C16099b {
        /* renamed from: bZ */
        void mo28534bZ(Object obj);
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.e$4 */
    static class C241784 implements C1835a {
        C241784() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(49259);
            c1902e.adi();
            AppMethodBeat.m2505o(49259);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.e$a */
    public interface C30881a {
        /* renamed from: ak */
        void mo49394ak(Map<String, Object> map);
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.e$c */
    public static class C30882c {
        public String key = null;
        public Object xBi = null;

        public C30882c(String str, Object obj) {
            this.key = str;
            this.xBi = obj;
        }
    }

    static /* synthetic */ int arI(String str) {
        AppMethodBeat.m2504i(49327);
        int atz = C36391e.atz(str);
        AppMethodBeat.m2505o(49327);
        return atz;
    }

    static {
        AppMethodBeat.m2504i(49328);
        AppMethodBeat.m2505o(49328);
    }

    /* renamed from: ex */
    public static Typeface m60009ex(Context context) {
        AppMethodBeat.m2504i(49263);
        Typeface aA = C36391e.m59989aA(context, 4);
        AppMethodBeat.m2505o(49263);
        return aA;
    }

    /* renamed from: aA */
    public static Typeface m59989aA(Context context, int i) {
        AppMethodBeat.m2504i(49265);
        Typeface typeface;
        if (i == 8) {
            typeface = Typeface.DEFAULT;
            AppMethodBeat.m2505o(49265);
            return typeface;
        } else if (VERSION.SDK_INT > 23) {
            typeface = Typeface.createFromAsset(context.getAssets(), C36391e.m59976QQ(i));
            AppMethodBeat.m2505o(49265);
            return typeface;
        } else {
            typeface = (Typeface) AhE.get(Integer.valueOf(i));
            if (typeface == null) {
                typeface = Typeface.createFromAsset(context.getAssets(), C36391e.m59976QQ(i));
                AhE.put(Integer.valueOf(i), typeface);
            }
            AppMethodBeat.m2505o(49265);
            return typeface;
        }
    }

    /* renamed from: QQ */
    public static String m59976QQ(int i) {
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
        AppMethodBeat.m2504i(49266);
        if (VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            AppMethodBeat.m2505o(49266);
            return;
        }
        Class cls = EditText.class;
        try {
            Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
            method.setAccessible(false);
            method.invoke(editText, new Object[]{Boolean.FALSE});
            AppMethodBeat.m2505o(49266);
        } catch (NoSuchMethodException e) {
            C4990ab.m7412e("erik", "setShowSoftInputOnFocus exception!");
            try {
                Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                method2.setAccessible(false);
                method2.invoke(editText, new Object[]{Boolean.FALSE});
                AppMethodBeat.m2505o(49266);
            } catch (Exception e2) {
                editText.setInputType(0);
                C4990ab.printErrStackTrace("MicroMsg.WalletBaseUtil ", e2, "", new Object[0]);
                AppMethodBeat.m2505o(49266);
            }
        } catch (Exception e22) {
            C4990ab.printErrStackTrace("MicroMsg.WalletBaseUtil ", e22, "", new Object[0]);
            AppMethodBeat.m2505o(49266);
        }
    }

    public static void dOJ() {
    }

    /* renamed from: e */
    public static String m60006e(double d, String str) {
        AppMethodBeat.m2504i(49267);
        String format;
        if ("CNY".equals(str)) {
            format = String.format("¥%.2f", new Object[]{Double.valueOf(d)});
            AppMethodBeat.m2505o(49267);
            return format;
        } else if ("ZAR".equals(str)) {
            format = String.format("R%.2f", new Object[]{Double.valueOf(d)});
            AppMethodBeat.m2505o(49267);
            return format;
        } else if ("1".equals(str) || C5046bo.isNullOrNil(str)) {
            format = String.format(C44423ae.dOd() + "%.2f", new Object[]{Double.valueOf(d)});
            AppMethodBeat.m2505o(49267);
            return format;
        } else {
            format = String.format(str + "%.2f", new Object[]{Double.valueOf(d)});
            AppMethodBeat.m2505o(49267);
            return format;
        }
    }

    public static String atq(String str) {
        AppMethodBeat.m2504i(49268);
        if ("CNY".equals(str)) {
            str = "¥";
            AppMethodBeat.m2505o(49268);
            return str;
        } else if ("ZAR".equals(str)) {
            str = "R";
            AppMethodBeat.m2505o(49268);
            return str;
        } else if ("1".equals(str) || C5046bo.isNullOrNil(str)) {
            str = C44423ae.dOd();
            AppMethodBeat.m2505o(49268);
            return str;
        } else {
            AppMethodBeat.m2505o(49268);
            return str;
        }
    }

    /* renamed from: G */
    public static String m59972G(double d) {
        AppMethodBeat.m2504i(49269);
        String e = C36391e.m60006e(d, "");
        AppMethodBeat.m2505o(49269);
        return e;
    }

    /* renamed from: F */
    public static String m59971F(double d) {
        AppMethodBeat.m2504i(49270);
        String format = String.format("%.2f", new Object[]{Double.valueOf(d)});
        AppMethodBeat.m2505o(49270);
        return format;
    }

    public static String atr(String str) {
        AppMethodBeat.m2504i(49271);
        if ("CNY".equals(str) || "1".equals(str) || C5046bo.isNullOrNil(str)) {
            str = "¥";
            AppMethodBeat.m2505o(49271);
            return str;
        }
        AppMethodBeat.m2505o(49271);
        return str;
    }

    /* renamed from: kC */
    public static String m60014kC(int i) {
        AppMethodBeat.m2504i(49272);
        if (kIy == null) {
            kIy = new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm);
        }
        String format = kIy.format(new Date(((long) i) * 1000));
        AppMethodBeat.m2505o(49272);
        return format;
    }

    /* renamed from: QR */
    public static String m59977QR(int i) {
        AppMethodBeat.m2504i(49273);
        String a = C36391e.m59980a(i, new SimpleDateFormat("MM-dd HH:mm"), new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm));
        AppMethodBeat.m2505o(49273);
        return a;
    }

    /* renamed from: a */
    public static String m59980a(int i, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
        AppMethodBeat.m2504i(49274);
        long j = ((long) i) * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j);
        String format;
        if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
            format = simpleDateFormat.format(new Date(j));
            AppMethodBeat.m2505o(49274);
            return format;
        }
        format = simpleDateFormat2.format(new Date(j));
        AppMethodBeat.m2505o(49274);
        return format;
    }

    /* renamed from: af */
    public static void m59992af(Context context, String str) {
        AppMethodBeat.m2504i(49275);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7418v("MicroMsg.WalletBaseUtil ", "username is null");
            AppMethodBeat.m2505o(49275);
        } else if (C1855t.m3912mY(str)) {
            C36391e.m59993ag(context, str);
            AppMethodBeat.m2505o(49275);
        } else {
            C36391e.m59991ae(context, str);
            AppMethodBeat.m2505o(49275);
        }
    }

    /* renamed from: n */
    public static void m60016n(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(49276);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", z);
        C25985d.m41467b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(49276);
    }

    /* renamed from: a */
    public static void m59984a(Context context, String str, boolean z, int i) {
        AppMethodBeat.m2504i(49277);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", z);
        C25985d.m41468b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, i);
        AppMethodBeat.m2505o(49277);
    }

    /* renamed from: ae */
    public static void m59991ae(Context context, String str) {
        AppMethodBeat.m2504i(49278);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7418v("MicroMsg.WalletBaseUtil ", "username is null");
            AppMethodBeat.m2505o(49278);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        intent.putExtra("force_get_contact", true);
        C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.m2505o(49278);
    }

    /* renamed from: iu */
    public static void m60010iu(Context context) {
        AppMethodBeat.m2504i(49279);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.WalletBaseUtil ", "hy: jump to preference error. context is null");
            AppMethodBeat.m2505o(49279);
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        C25985d.m41473f(context, "com.tencent.mm.ui.LauncherUI", intent);
        AppMethodBeat.m2505o(49279);
    }

    /* renamed from: ag */
    public static void m59993ag(Context context, String str) {
        AppMethodBeat.m2504i(49280);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7418v("MicroMsg.WalletBaseUtil ", "username is null");
            AppMethodBeat.m2505o(49280);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        C25985d.m41473f(context, ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.m2505o(49280);
    }

    public static boolean ats(String str) {
        AppMethodBeat.m2504i(49281);
        if (vrO.matcher(str).matches()) {
            AppMethodBeat.m2505o(49281);
            return true;
        }
        AppMethodBeat.m2505o(49281);
        return false;
    }

    public static String att(String str) {
        AppMethodBeat.m2504i(49282);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(49282);
            return str;
        }
        String str2 = "";
        for (int i = 0; i < str.length() - 1; i++) {
            str2 = str2 + "*";
        }
        str = str2 + str.substring(str.length() - 1, str.length());
        AppMethodBeat.m2505o(49282);
        return str;
    }

    /* renamed from: n */
    public static boolean m60017n(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(49283);
        boolean equals = "1".equals(jSONObject.optString(str, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        AppMethodBeat.m2505o(49283);
        return equals;
    }

    public static String getUsername() {
        AppMethodBeat.m2504i(49284);
        C1720g.m3534RN().mo5159QU();
        String Yz = C1853r.m3846Yz();
        AppMethodBeat.m2505o(49284);
        return Yz;
    }

    public static String atu(String str) {
        AppMethodBeat.m2504i(49285);
        if (str == null || str.length() <= 8) {
            AppMethodBeat.m2505o(49285);
            return str;
        }
        int length = str.length();
        String substring = str.substring(0, length - 8);
        str = substring + "****" + str.substring(length - 4);
        AppMethodBeat.m2505o(49285);
        return str;
    }

    public static String atv(String str) {
        AppMethodBeat.m2504i(49286);
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = "";
            AppMethodBeat.m2505o(49286);
            return str2;
        }
        str2 = str.substring(1, str.length());
        C4990ab.m7410d("MicroMsg.WalletBaseUtil ", "tail : ".concat(String.valueOf(str2)));
        String substring = str.substring(0, 1);
        C4990ab.m7410d("MicroMsg.WalletBaseUtil ", "head : ".concat(String.valueOf(substring)));
        C4990ab.m7410d("MicroMsg.WalletBaseUtil ", "after : ".concat(String.valueOf(substring)));
        str2 = "*".concat(String.valueOf(str2));
        AppMethodBeat.m2505o(49286);
        return str2;
    }

    public static String atw(String str) {
        AppMethodBeat.m2504i(49287);
        String atv;
        if (str == null || str.length() < 2) {
            atv = C36391e.atv(str);
            AppMethodBeat.m2505o(49287);
            return atv;
        }
        atv = "**".concat(String.valueOf(str.substring(str.length() - 1, str.length())));
        AppMethodBeat.m2505o(49287);
        return atv;
    }

    /* renamed from: a */
    public static void m59983a(final Context context, final String str, String str2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(49288);
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(context.getString(C25738R.string.faa));
        linkedList2.add(Integer.valueOf(0));
        if (str != null && z2) {
            linkedList.add(context.getString(C25738R.string.fa9));
            linkedList2.add(Integer.valueOf(1));
        }
        if (z && !C5046bo.isNullOrNil(str2)) {
            linkedList.add(context.getString(C25738R.string.fab, new Object[]{str2}));
            linkedList2.add(Integer.valueOf(2));
            linkedList.add(context.getString(C25738R.string.fac, new Object[]{str2}));
            linkedList2.add(Integer.valueOf(3));
        }
        C30379h.m48419a(context, "", linkedList, linkedList2, "", new C30382d() {
            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(49256);
                Intent intent = new Intent();
                switch (i) {
                    case 0:
                        intent.putExtra("rawUrl", context.getString(C25738R.string.f84, new Object[]{C4988aa.dor()}));
                        break;
                    case 1:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(C25738R.string.f82, new Object[]{C4988aa.dor(), str}));
                            break;
                        }
                        break;
                    case 2:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(C25738R.string.f85, new Object[]{C4988aa.dor(), str}));
                            break;
                        }
                        break;
                    case 3:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(C25738R.string.f86, new Object[]{C4988aa.dor(), str}));
                            break;
                        }
                        break;
                }
                intent.putExtra("showShare", false);
                C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(49256);
            }
        });
        AppMethodBeat.m2505o(49288);
    }

    /* renamed from: d */
    public static void m60005d(MMActivity mMActivity, String str) {
        AppMethodBeat.m2504i(49289);
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("bank_card_owner", str);
        C25985d.m41467b((Context) mMActivity, "scanner", ".ui.BaseScanUI", intent);
        AppMethodBeat.m2505o(49289);
    }

    /* renamed from: mJ */
    public static String m60015mJ(String str) {
        String Oj;
        AppMethodBeat.m2504i(49290);
        C1720g.m3537RQ();
        C7616ad aoN = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(str);
        if (aoN != null) {
            Oj = aoN.mo16707Oj();
        } else {
            Oj = null;
        }
        if (!C5046bo.isNullOrNil(Oj)) {
            str = Oj;
        }
        AppMethodBeat.m2505o(49290);
        return str;
    }

    /* renamed from: bU */
    public static void m59999bU(Context context, String str) {
        AppMethodBeat.m2504i(49291);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(49291);
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
        intent.addFlags(268435456);
        context.startActivity(intent);
        AppMethodBeat.m2505o(49291);
    }

    /* renamed from: H */
    public static long m59973H(double d) {
        AppMethodBeat.m2504i(49292);
        long round = Math.round(100.0d * d);
        AppMethodBeat.m2505o(49292);
        return round;
    }

    /* renamed from: a */
    public static void m59987a(final C30882c... c30882cArr) {
        AppMethodBeat.m2504i(49293);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(new C6668bk(new C1835a() {
            /* renamed from: a */
            public final void mo4918a(C1902e c1902e) {
                AppMethodBeat.m2504i(49257);
                if (c1902e == null || c1902e.adg() == null) {
                    AppMethodBeat.m2505o(49257);
                } else if (c30882cArr == null || c30882cArr.length == 0) {
                    C4990ab.m7420w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
                    AppMethodBeat.m2505o(49257);
                } else {
                    try {
                        for (C30882c c30882c : c30882cArr) {
                            if (!(c30882c == null || C5046bo.isNullOrNil(c30882c.key))) {
                                c1902e.adg().mo5491o(c30882c.key, C36391e.m60002cZ(c30882c.xBi));
                            }
                        }
                        AppMethodBeat.m2505o(49257);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", e.toString());
                        AppMethodBeat.m2505o(49257);
                    }
                }
            }
        }), 0);
        AppMethodBeat.m2505o(49293);
    }

    /* renamed from: a */
    public static void m59986a(final String str, final C16099b c16099b) {
        AppMethodBeat.m2504i(49294);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(new C6668bk(new C1835a() {
            /* renamed from: a */
            public final void mo4918a(C1902e c1902e) {
                AppMethodBeat.m2504i(49258);
                if (c1902e == null || c1902e.adg() == null) {
                    AppMethodBeat.m2505o(49258);
                } else if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7420w("MicroMsg.WalletBaseUtil ", "hy: key is null");
                    AppMethodBeat.m2505o(49258);
                } else {
                    try {
                        byte[] qr = c1902e.adg().mo5492qr(str);
                        if (c16099b != null) {
                            if (qr != null) {
                                c16099b.mo28534bZ(C36391e.m60003cg(qr));
                                AppMethodBeat.m2505o(49258);
                                return;
                            }
                            c16099b.mo28534bZ(null);
                        }
                        AppMethodBeat.m2505o(49258);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", e.toString());
                        if (c16099b != null) {
                            c16099b.mo28534bZ(null);
                        }
                        AppMethodBeat.m2505o(49258);
                    }
                }
            }
        }), 0);
        AppMethodBeat.m2505o(49294);
    }

    public static void dOK() {
        AppMethodBeat.m2504i(49295);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(new C6668bk(new C241784()), 0);
        AppMethodBeat.m2505o(49295);
    }

    public static String aty(String str) {
        AppMethodBeat.m2504i(49297);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.m2505o(49297);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length() / 4;
        for (int i = 0; i < length; i++) {
            int min = Math.min((i + 1) * 4, str.length());
            if (min + 4 > str.length()) {
                min = str.length();
            }
            stringBuilder.append(C36391e.m60011ix(str.substring(i * 4, min), " "));
            if (min - (i * 4) == 4) {
                for (min = 0; min < 6; min++) {
                    stringBuilder.append(" ");
                }
            }
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.m2505o(49297);
        return str2;
    }

    /* renamed from: ar */
    public static void m59995ar(ArrayList<Bitmap> arrayList) {
        AppMethodBeat.m2504i(49298);
        if (arrayList != null && arrayList.size() > 0) {
            for (int size = arrayList.size() - 1; size > 0; size--) {
                C36391e.m59975K((Bitmap) arrayList.remove(size));
            }
        }
        AppMethodBeat.m2505o(49298);
    }

    /* renamed from: K */
    public static void m59975K(Bitmap bitmap) {
        AppMethodBeat.m2504i(49299);
        if (!(bitmap == null || bitmap.isRecycled())) {
            bitmap.recycle();
        }
        AppMethodBeat.m2505o(49299);
    }

    /* renamed from: J */
    public static Bitmap m59974J(Bitmap bitmap) {
        boolean z = true;
        AppMethodBeat.m2504i(49300);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        String str = "MicroMsg.WalletBaseUtil ";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        C4990ab.m7410d(str, stringBuilder.append(z).append("  degree:90.0").toString());
        AppMethodBeat.m2505o(49300);
        return createBitmap;
    }

    /* renamed from: ix */
    private static String m60011ix(String str, String str2) {
        AppMethodBeat.m2504i(49301);
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
            AppMethodBeat.m2505o(49301);
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
        AppMethodBeat.m2505o(49301);
        return str3;
    }

    /* renamed from: a */
    public static void m59988a(final String[] strArr, final C30881a c30881a) {
        AppMethodBeat.m2504i(49303);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(new C6668bk(new C1835a() {
            /* renamed from: a */
            public final void mo4918a(C1902e c1902e) {
                AppMethodBeat.m2504i(49260);
                if (c1902e == null || c1902e.adg() == null) {
                    AppMethodBeat.m2505o(49260);
                } else if (strArr == null || strArr.length == 0) {
                    C4990ab.m7420w("MicroMsg.WalletBaseUtil ", "hy: keys is null");
                    AppMethodBeat.m2505o(49260);
                } else {
                    HashMap hashMap = new HashMap();
                    int i = 0;
                    while (i < strArr.length) {
                        try {
                            String str = strArr[i];
                            if (C5046bo.isNullOrNil(str)) {
                                C4990ab.m7412e("MicroMsg.WalletBaseUtil ", "hy: key is null");
                            } else {
                                byte[] qr = c1902e.adg().mo5492qr(str);
                                if (qr != null) {
                                    hashMap.put(str, C36391e.m60003cg(qr));
                                }
                            }
                            i++;
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", e.toString());
                            if (c30881a != null) {
                                c30881a.mo49394ak(null);
                            }
                            AppMethodBeat.m2505o(49260);
                            return;
                        }
                    }
                    if (c30881a != null) {
                        c30881a.mo49394ak(hashMap);
                    }
                    AppMethodBeat.m2505o(49260);
                }
            }
        }), 0);
        AppMethodBeat.m2505o(49303);
    }

    /* renamed from: QS */
    public static void m59978QS(int i) {
        AppMethodBeat.m2504i(49304);
        C7060h.pYm.mo8381e(12719, Integer.valueOf(i), Integer.valueOf(1));
        AppMethodBeat.m2505o(49304);
    }

    /* renamed from: a */
    public static void m59985a(final TextView textView, final String str, String str2, final String str3) {
        AppMethodBeat.m2504i(49305);
        if (textView == null) {
            C4990ab.m7412e("MicroMsg.WalletBaseUtil ", "hy: text view is null.");
            AppMethodBeat.m2505o(49305);
        } else if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7420w("MicroMsg.WalletBaseUtil ", "hy: msg is null. set text view to gone");
            textView.setVisibility(8);
            AppMethodBeat.m2505o(49305);
        } else {
            textView.setVisibility(0);
            textView.setText(str2);
            C46516g.m87805gu(C36391e.atz(str), 0);
            if (!C5046bo.isNullOrNil(str3)) {
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(49261);
                        C4990ab.m7416i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str3);
                        intent.putExtra("showShare", false);
                        C25985d.m41467b(textView.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                        C46516g.m87805gu(C36391e.arI(str), 1);
                        AppMethodBeat.m2505o(49261);
                    }
                });
            }
            AppMethodBeat.m2505o(49305);
        }
    }

    private static int atz(String str) {
        AppMethodBeat.m2504i(49306);
        if ("1".equals(str)) {
            AppMethodBeat.m2505o(49306);
            return 0;
        } else if ("2".equals(str)) {
            AppMethodBeat.m2505o(49306);
            return 4;
        } else if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str)) {
            AppMethodBeat.m2505o(49306);
            return 12;
        } else if ("4".equals(str)) {
            AppMethodBeat.m2505o(49306);
            return 2;
        } else if ("5".equals(str)) {
            AppMethodBeat.m2505o(49306);
            return 8;
        } else if ("6".equals(str)) {
            AppMethodBeat.m2505o(49306);
            return 14;
        } else if ("7".equals(str)) {
            AppMethodBeat.m2505o(49306);
            return 16;
        } else if ("8".equals(str)) {
            AppMethodBeat.m2505o(49306);
            return 10;
        } else {
            AppMethodBeat.m2505o(49306);
            return -1;
        }
    }

    /* renamed from: a */
    public static void m59982a(int i, long j, int i2) {
        AppMethodBeat.m2504i(49307);
        C7060h.pYm.mo8381e(13375, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(j), Integer.valueOf(i2));
        AppMethodBeat.m2505o(49307);
    }

    public static String atA(String str) {
        AppMethodBeat.m2504i(49308);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(49308);
            return str;
        } else if (str.length() > 14) {
            str = str.substring(0, 14) + "...";
            AppMethodBeat.m2505o(49308);
            return str;
        } else {
            AppMethodBeat.m2505o(49308);
            return str;
        }
    }

    /* renamed from: eK */
    public static String m60007eK(String str, int i) {
        AppMethodBeat.m2504i(49309);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(49309);
            return str;
        } else if (str.length() > i) {
            str = str.substring(0, i) + "...";
            AppMethodBeat.m2505o(49309);
            return str;
        } else {
            AppMethodBeat.m2505o(49309);
            return str;
        }
    }

    /* renamed from: eL */
    public static String m60008eL(String str, int i) {
        AppMethodBeat.m2504i(49310);
        String eK = C36391e.m60007eK(C36391e.m60015mJ(str), i);
        AppMethodBeat.m2505o(49310);
        return eK;
    }

    /* renamed from: d */
    public static void m60004d(TextView textView, String str) {
        AppMethodBeat.m2504i(49311);
        textView.setText(C44089j.m79293b(textView.getContext(), C36391e.m60008eL(str, 10), textView.getTextSize()));
        AppMethodBeat.m2505o(49311);
    }

    /* renamed from: a */
    public static long m59979a(String str, String str2, RoundingMode roundingMode) {
        AppMethodBeat.m2504i(49312);
        long longValue = C36391e.m59981a(str, str2, 0, roundingMode).longValue();
        AppMethodBeat.m2505o(49312);
        return longValue;
    }

    /* renamed from: b */
    public static double m59996b(String str, String str2, RoundingMode roundingMode) {
        AppMethodBeat.m2504i(49313);
        double doubleValue = C36391e.m59981a(str, str2, 2, roundingMode).doubleValue();
        AppMethodBeat.m2505o(49313);
        return doubleValue;
    }

    /* renamed from: a */
    public static BigDecimal m59981a(String str, String str2, int i, RoundingMode roundingMode) {
        AppMethodBeat.m2504i(49314);
        BigDecimal divide;
        try {
            divide = new BigDecimal(C5046bo.getDouble(str, 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), i, roundingMode);
            AppMethodBeat.m2505o(49314);
            return divide;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletBaseUtil ", e, "", new Object[0]);
            divide = new BigDecimal(0);
            AppMethodBeat.m2505o(49314);
            return divide;
        }
    }

    /* renamed from: c */
    public static double m60001c(String str, String str2, RoundingMode roundingMode) {
        AppMethodBeat.m2504i(49315);
        double doubleValue = C36391e.m59997b(str, str2, 2, roundingMode).doubleValue();
        AppMethodBeat.m2505o(49315);
        return doubleValue;
    }

    /* renamed from: iy */
    public static int m60012iy(String str, String str2) {
        AppMethodBeat.m2504i(49316);
        int intValue = C36391e.m59997b(str, str2, 0, RoundingMode.HALF_UP).intValue();
        AppMethodBeat.m2505o(49316);
        return intValue;
    }

    /* renamed from: iz */
    public static long m60013iz(String str, String str2) {
        AppMethodBeat.m2504i(49317);
        long longValue = C36391e.m59997b(str, str2, 0, RoundingMode.HALF_UP).longValue();
        AppMethodBeat.m2505o(49317);
        return longValue;
    }

    /* renamed from: b */
    public static BigDecimal m59997b(String str, String str2, int i, RoundingMode roundingMode) {
        AppMethodBeat.m2504i(49318);
        BigDecimal scale;
        try {
            scale = new BigDecimal(C5046bo.getDouble(str, 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).multiply(new BigDecimal(C5046bo.getDouble(str2, 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str2.trim())).setScale(i, roundingMode);
            AppMethodBeat.m2505o(49318);
            return scale;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletBaseUtil ", e, "", new Object[0]);
            scale = new BigDecimal(0);
            AppMethodBeat.m2505o(49318);
            return scale;
        }
    }

    public static boolean dOL() {
        AppMethodBeat.m2504i(49319);
        C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        if (c30052l == null) {
            C4990ab.m7420w("MicroMsg.WalletBaseUtil ", "bio no finger mgr!");
            AppMethodBeat.m2505o(49319);
            return false;
        }
        C4990ab.m7417i("MicroMsg.WalletBaseUtil ", "has fp: %s, has faceid: %s", Boolean.valueOf(c30052l.bxo()), Boolean.valueOf(c30052l.bxB()));
        if (c30052l.bxo() || r0) {
            AppMethodBeat.m2505o(49319);
            return true;
        }
        AppMethodBeat.m2505o(49319);
        return false;
    }

    /* renamed from: aA */
    public static void m59990aA(final View view, final int i) {
        AppMethodBeat.m2504i(49320);
        final View view2 = (View) view.getParent();
        view2.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(49262);
                Rect rect = new Rect();
                view.getHitRect(rect);
                rect.top -= i;
                rect.bottom += i;
                rect.left -= i;
                rect.right += i;
                view2.setTouchDelegate(new TouchDelegate(rect, view));
                AppMethodBeat.m2505o(49262);
            }
        });
        AppMethodBeat.m2505o(49320);
    }

    public static int atB(String str) {
        AppMethodBeat.m2504i(49321);
        if (C5046bo.isNullOrNil(str) || str.length() < 2) {
            C4990ab.m7421w("MicroMsg.WalletBaseUtil ", "illegal reqkey: %s", str);
            AppMethodBeat.m2505o(49321);
            return 0;
        }
        C5141c ll = C18624c.abi().mo17131ll("100456");
        if (!ll.isValid()) {
            C4990ab.m7420w("MicroMsg.WalletBaseUtil ", "invalid abtest value");
            AppMethodBeat.m2505o(49321);
            return 0;
        } else if (C5046bo.getInt((String) ll.dru().get("open"), 0) == 0) {
            C4990ab.m7416i("MicroMsg.WalletBaseUtil ", "abtest unopened");
            AppMethodBeat.m2505o(49321);
            return 0;
        } else {
            int i;
            if (str.startsWith("ts_wx") || str.startsWith("offline_wx") || str.startsWith("up_wx") || str.startsWith("wx")) {
                i = C5046bo.getInt(str.substring(str.length() - 2), 0);
            } else {
                i = 0;
            }
            C4990ab.m7411d("MicroMsg.WalletBaseUtil ", "parse group id: %s, reqKey: %s", Integer.valueOf(i), str);
            AppMethodBeat.m2505o(49321);
            return i;
        }
    }

    public static void atC(String str) {
        CharSequence str2;
        AppMethodBeat.m2504i(49322);
        if (C5046bo.isNullOrNil(str2)) {
            str2 = C4996ah.getContext().getString(C25738R.string.fu2);
        }
        Toast.makeText(C4996ah.getContext(), str2, 1).show();
        AppMethodBeat.m2505o(49322);
    }

    /* renamed from: aj */
    public static void m59994aj(Context context, String str) {
        AppMethodBeat.m2504i(49323);
        if (C5046bo.isNullOrNil(str)) {
            str = C4996ah.getContext().getString(C25738R.string.fu2);
        }
        C30379h.m48461b(context, str, "", true);
        AppMethodBeat.m2505o(49323);
    }

    /* renamed from: p */
    public static void m60018p(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(49324);
        C32628se c32628se = new C32628se();
        c32628se.cOf.userName = str;
        c32628se.cOf.cOh = C5046bo.m7532bc(str2, "");
        c32628se.cOf.axy = i;
        c32628se.cOf.scene = i2;
        c32628se.cOf.cOi = 0;
        C4879a.xxA.mo10055m(c32628se);
        AppMethodBeat.m2505o(49324);
    }

    /* renamed from: bT */
    public static Typeface m59998bT(Context context, String str) {
        int i = 0;
        AppMethodBeat.m2504i(49264);
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
        Typeface aA = C36391e.m59989aA(context, i);
        AppMethodBeat.m2505o(49264);
        return aA;
    }

    public static String atx(String str) {
        AppMethodBeat.m2504i(49296);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.m2505o(49296);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length() / 4;
        for (int i = 0; i < length + 1; i++) {
            int min = Math.min((i + 1) * 4, str.length());
            stringBuilder.append(C36391e.m60011ix(str.substring(i * 4, min), ""));
            if (min - (i * 4) == 4) {
                for (min = 0; min < 4; min++) {
                    stringBuilder.append(" ");
                }
            }
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.m2505o(49296);
        return str2;
    }

    /* renamed from: bV */
    public static void m60000bV(Context context, String str) {
        AppMethodBeat.m2504i(49302);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("pay_channel", 1);
        C25985d.m41467b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(49302);
    }

    /* renamed from: cZ */
    static /* synthetic */ byte[] m60002cZ(Object obj) {
        AppMethodBeat.m2504i(49325);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(49325);
        return toByteArray;
    }

    /* renamed from: cg */
    static /* synthetic */ Object m60003cg(byte[] bArr) {
        AppMethodBeat.m2504i(49326);
        Object readObject = new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
        AppMethodBeat.m2505o(49326);
        return readObject;
    }
}
