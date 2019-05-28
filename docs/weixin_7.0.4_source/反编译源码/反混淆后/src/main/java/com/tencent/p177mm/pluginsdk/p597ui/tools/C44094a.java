package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.choosemsgfile.compat.C9236a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.C5510e.C5505l;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C44065o;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.a */
public final class C44094a {
    private static Intent vsW;
    private static WeakReference<Activity> vsX;
    public static HashMap<String, String> vsY = new HashMap();
    public static HashMap<String, String> vsZ;

    /* JADX WARNING: Removed duplicated region for block: B:33:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: M */
    public static boolean m79366M(String str, String str2, int i) {
        AppMethodBeat.m2504i(125840);
        Context context = C4996ah.getContext();
        C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d fileExt: %s", str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length()), str2);
        if (new File(str).exists()) {
            Intent G;
            String ajT = C44094a.ajT(str2);
            String ajQ = C44094a.ajQ(ajT);
            if (ajQ.equals("com.baidu.searchbox")) {
                C44094a.ajR(ajT);
                ajQ = "";
            }
            if (!ajQ.equals("")) {
                C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", ajQ);
                Intent E = C44094a.m79363E(context, ajT, str);
                E.setPackage(ajQ);
                if (C5046bo.m7572k(context, E)) {
                    C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", ajT);
                    context.startActivity(E);
                    AppMethodBeat.m2505o(125840);
                    return false;
                }
                C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", ajT);
            }
            if (((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_qb_document_action_flag, true)) {
                G = C44094a.m79365G(context, str, str2);
                if (C5046bo.m7572k(context, G)) {
                    C4996ah.getContext().startActivity(G);
                    C7060h.pYm.mo8381e(11168, Integer.valueOf(5), Integer.valueOf(i));
                    AppMethodBeat.m2505o(125840);
                    return false;
                }
            }
            G = C44094a.m79364F(context, ajT, str);
            if (C5046bo.m7572k(context, G)) {
                C4996ah.getContext().startActivity(G);
                C7060h.pYm.mo8381e(11168, Integer.valueOf(5), Integer.valueOf(i));
                AppMethodBeat.m2505o(125840);
                return false;
            }
            int i2;
            if (!C5046bo.isNullOrNil(str2)) {
                ajQ = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, (Object) "");
                if (!C5046bo.isNullOrNil(ajQ) && ajQ.contains(str2)) {
                    i2 = 1;
                    if (i2 != 0) {
                        AppMethodBeat.m2505o(125840);
                        return true;
                    } else if (i == 7) {
                        AppMethodBeat.m2505o(125840);
                        return true;
                    } else {
                        C44094a.m79362D(context, str, str2);
                        AppMethodBeat.m2505o(125840);
                        return false;
                    }
                }
            }
            i2 = 0;
            if (i2 != 0) {
            }
        } else {
            C4990ab.m7412e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
            AppMethodBeat.m2505o(125840);
            return true;
        }
    }

    /* renamed from: a */
    public static void m79368a(Activity activity, String str, String str2, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(125841);
        C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length()));
        if (new File(str).exists()) {
            Intent E;
            Intent G;
            Context context = C4996ah.getContext();
            String ajT = C44094a.ajT(str2);
            String ajQ = C44094a.ajQ(ajT);
            if (ajQ.equals("com.baidu.searchbox")) {
                C44094a.ajR(ajT);
                ajQ = "";
            }
            if (!ajQ.equals("")) {
                C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", ajQ);
                E = C44094a.m79363E(C4996ah.getContext(), ajT, str);
                E.setPackage(ajQ);
                if (C5046bo.m7572k(context, E)) {
                    C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", ajT);
                    context.startActivity(E);
                    AppMethodBeat.m2505o(125841);
                    return;
                }
                C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", ajT);
            }
            if (((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_qb_document_action_flag, true)) {
                G = C44094a.m79365G(context, str, str2);
                if (C5046bo.m7572k(context, G)) {
                    C4996ah.getContext().startActivity(G);
                    C7060h.pYm.mo8381e(11168, Integer.valueOf(5), Integer.valueOf(i));
                    AppMethodBeat.m2505o(125841);
                    return;
                }
            }
            G = C44094a.m79364F(context, ajT, str);
            if (C5046bo.m7572k(context, G)) {
                C4996ah.getContext().startActivity(G);
                C7060h.pYm.mo8381e(11168, Integer.valueOf(5), Integer.valueOf(i));
                AppMethodBeat.m2505o(125841);
                return;
            }
            boolean z2;
            Intent E2 = C44094a.m79363E(context, ajT, str);
            if (C44065o.m79203fF(C4996ah.getContext())) {
                z2 = false;
            } else {
                z2 = true;
            }
            ajT = C44094a.ajT(str2);
            Uri fromFile = Uri.fromFile(new File(str));
            Bundle bundle = new Bundle();
            bundle.putString("targeturl", fromFile.toString());
            bundle.putString("filepath", str);
            bundle.putString("fileext", str2);
            bundle.putParcelable("targetintent", E2);
            E = new Intent();
            E.putExtra("type", 0);
            E.putExtra("title", activity.getResources().getString(C25738R.string.apd));
            E.putExtra("needupate", false);
            String str3 = "not_show_recommend_app";
            if (z2) {
                z = false;
            }
            E.putExtra(str3, z);
            E.putExtra("mimetype", ajT);
            E.putExtra("targetintent", E2);
            E.putExtra("transferback", bundle);
            E.putExtra("scene", i);
            if (i == 7) {
                ((C9236a) C1720g.m3528K(C9236a.class)).mo20658h(activity, str, str2);
            } else {
                C44094a.m79362D(activity, str, str2);
            }
            vsW = E;
            vsX = new WeakReference(activity);
            AppMethodBeat.m2505o(125841);
            return;
        }
        C4990ab.m7412e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
        AppMethodBeat.m2505o(125841);
    }

    /* renamed from: b */
    public static boolean m79370b(Activity activity, String str, String str2, int i) {
        AppMethodBeat.m2504i(125842);
        String ajT = C44094a.ajT(str2);
        Uri fromFile = Uri.fromFile(new File(str));
        Bundle bundle = new Bundle();
        Intent E = C44094a.m79363E(activity, ajT, str);
        bundle.putString("targeturl", fromFile.toString());
        bundle.putString("filepath", str);
        bundle.putString("fileext", str2);
        bundle.putParcelable("targetintent", E);
        Intent intent = new Intent(activity, AppChooserUI.class);
        intent.putExtra("type", 0);
        intent.putExtra("title", activity.getResources().getString(C25738R.string.apd));
        intent.putExtra("mimetype", ajT);
        intent.putExtra("targetintent", E);
        intent.putExtra("transferback", bundle);
        intent.putExtra("scene", i);
        intent.putExtra("openWay", true);
        activity.startActivityForResult(intent, 2);
        AppMethodBeat.m2505o(125842);
        return true;
    }

    /* renamed from: D */
    private static void m79362D(Context context, String str, String str2) {
        AppMethodBeat.m2504i(125843);
        Intent intent = new Intent();
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.addFlags(268435456);
        intent.setComponent(new ComponentName(C5505l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
        context.sendBroadcast(intent);
        AppMethodBeat.m2505o(125843);
    }

    /* renamed from: aF */
    public static void m79369aF(Intent intent) {
        AppMethodBeat.m2504i(125844);
        boolean booleanExtra = intent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
        intent.getStringExtra("file_path");
        String stringExtra = intent.getStringExtra("file_ext");
        C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", Boolean.valueOf(booleanExtra));
        if (C1720g.m3531RK()) {
            Object obj = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, (Object) "");
            if (!booleanExtra) {
                obj = obj.replace(stringExtra, "");
            } else if (!obj.contains(stringExtra)) {
                obj = obj.concat(stringExtra);
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, obj);
            if (!(booleanExtra || vsW == null || vsX == null || vsX.get() == null)) {
                vsW.setClass((Context) vsX.get(), AppChooserUI.class);
                ((Activity) vsX.get()).startActivityForResult(vsW, 2);
            }
            vsW = null;
            AppMethodBeat.m2505o(125844);
            return;
        }
        AppMethodBeat.m2505o(125844);
    }

    /* renamed from: a */
    public static void m79367a(Activity activity, int i, int i2, Intent intent, boolean z, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(125845);
        if (i == 2) {
            if (-1 == i2 && intent != null) {
                String stringExtra = intent.getStringExtra("selectpkg");
                Intent intent2 = (Intent) intent.getBundleExtra("transferback").getParcelable("targetintent");
                if (intent2 != null) {
                    C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", stringExtra);
                    Intent intent3 = new Intent(intent2);
                    intent3.setPackage(stringExtra);
                    if (C5046bo.m7572k((Context) activity, intent3)) {
                        activity.startActivity(intent3);
                        if (TbsConfig.APP_QB.equals(stringExtra)) {
                            C7060h.pYm.mo8381e(11168, Integer.valueOf(5), Integer.valueOf(i5));
                            AppMethodBeat.m2505o(125845);
                            return;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
                    if (z) {
                        C30379h.m48467g(activity, i3, i4);
                    }
                    AppMethodBeat.m2505o(125845);
                    return;
                }
                C4990ab.m7412e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
                if (z) {
                    C30379h.m48467g(activity, i3, i4);
                }
                AppMethodBeat.m2505o(125845);
                return;
            } else if (4098 == i2) {
                C4990ab.m7412e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
                if (z) {
                    C30379h.m48467g(activity, i3, i4);
                    AppMethodBeat.m2505o(125845);
                    return;
                }
            } else if (4097 == i2) {
                C4990ab.m7416i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
                if (z) {
                    C30379h.m48467g(activity, i3, i4);
                    AppMethodBeat.m2505o(125845);
                    return;
                }
            } else {
                C4990ab.m7416i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
            }
        }
        AppMethodBeat.m2505o(125845);
    }

    /* renamed from: E */
    private static Intent m79363E(Context context, String str, String str2) {
        AppMethodBeat.m2504i(125846);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        C15429k.m23713a(context, intent, new File(str2), str);
        try {
            C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "createNormalIntent %s %s %s", str, str2, intent.toString());
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(125846);
        return intent;
    }

    /* renamed from: F */
    private static Intent m79364F(Context context, String str, String str2) {
        AppMethodBeat.m2504i(125847);
        Intent intent = new Intent();
        intent.setPackage(TbsConfig.APP_QB);
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        C15429k.m23713a(context, intent, new File(str2), str);
        try {
            C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "createQQBrowserIntent %s %s %s", str, str2, intent.toString());
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(125847);
        return intent;
    }

    /* renamed from: G */
    private static Intent m79365G(Context context, String str, String str2) {
        AppMethodBeat.m2504i(125848);
        Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
        intent.setPackage(TbsConfig.APP_QB);
        intent.addFlags(268435456);
        intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 4);
        intent.putExtra("key_reader_sdk_id", 1);
        intent.putExtra("key_reader_sdk_type", 0);
        intent.putExtra("key_reader_sdk_format", str2);
        intent.putExtra("key_reader_sdk_path", str);
        String str3 = (String) vsZ.get(str2);
        if (C5046bo.isNullOrNil(str3)) {
            str3 = C44094a.ajT(str2);
        }
        C15429k.m23713a(context, intent, new File(str), str3);
        try {
            C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent %s %s %s %s", str3, str, intent.toString(), str2);
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(125848);
        return intent;
    }

    private static String ajQ(String str) {
        AppMethodBeat.m2504i(125849);
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C44094a.ajS(str), (Object) "");
        AppMethodBeat.m2505o(125849);
        return str2;
    }

    private static void ajR(String str) {
        AppMethodBeat.m2504i(125850);
        C1720g.m3536RP().mo5239Ry().set(C44094a.ajS(str), (Object) "");
        AppMethodBeat.m2505o(125850);
    }

    private static int ajS(String str) {
        AppMethodBeat.m2504i(125851);
        if (str != null) {
            int hashCode = 274528 + str.hashCode();
            AppMethodBeat.m2505o(125851);
            return hashCode;
        }
        AppMethodBeat.m2505o(125851);
        return 274528;
    }

    private static String ajT(String str) {
        String str2;
        AppMethodBeat.m2504i(125852);
        if (C5046bo.isNullOrNil(str)) {
            str2 = "application/octet-stream";
        } else {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
            if (C5046bo.isNullOrNil(str2)) {
                str2 = (String) vsY.get(str);
            }
            if (C5046bo.isNullOrNil(str2)) {
                if (str.startsWith("/")) {
                    str2 = "application/octet-stream";
                } else {
                    str2 = "application/".concat(String.valueOf(str));
                }
            }
        }
        C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "getMimeTypeByExt fileExt: %s mimeType: %s", str, str2);
        AppMethodBeat.m2505o(125852);
        return str2;
    }

    static {
        AppMethodBeat.m2504i(125853);
        long currentTimeMillis = System.currentTimeMillis();
        InputStream inputStream = null;
        try {
            inputStream = C4996ah.getContext().getAssets().open("mimetype.txt");
            for (String split : new String(C1173e.m2574q(inputStream)).split(IOUtils.LINE_SEPARATOR_UNIX)) {
                String[] split2 = split.split(",");
                if (split2 == null || split2.length <= 1 || C5046bo.isNullOrNil(split2[0]) || C5046bo.isNullOrNil(split2[1])) {
                    C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "mimeType %s", split);
                } else {
                    vsY.put(split2[0].trim(), split2[1].trim());
                }
            }
            C4990ab.m7417i("MicroMsg.AppChooserIntentUtil", "read from mimetype text %d %d %d", Integer.valueOf(r4.length), Integer.valueOf(vsY.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            C1173e.m2573p(inputStream);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.AppChooserIntentUtil", e, "read mimeType from asset", new Object[0]);
            C1173e.m2573p(inputStream);
        } catch (Throwable th) {
            C1173e.m2573p(inputStream);
            AppMethodBeat.m2505o(125853);
        }
        HashMap hashMap = new HashMap();
        vsZ = hashMap;
        hashMap.put("txt", "mtt/txt");
        vsZ.put("epub", "mtt/epub");
        vsZ.put("pdf", "mtt/pdf");
        vsZ.put("doc", "mtt/doc");
        vsZ.put("xls", "mtt/xls");
        vsZ.put("ppt", "mtt/ppt");
        vsZ.put("docx", "mtt/docx");
        vsZ.put("xlsx", "mtt/xlsx");
        vsZ.put("pptx", "mtt/pptx");
        vsZ.put("chm", "mtt/chm");
        vsZ.put("ini", "mtt/ini");
        vsZ.put("log", "mtt/log");
        vsZ.put("bat", "mtt/bat");
        vsZ.put("php", "mtt/php");
        vsZ.put("lrc", "mtt/lrc");
        vsZ.put("js", "mtt/js");
        AppMethodBeat.m2505o(125853);
    }
}
