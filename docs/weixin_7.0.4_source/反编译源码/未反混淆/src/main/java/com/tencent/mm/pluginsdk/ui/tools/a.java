package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.e.l;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a {
    private static Intent vsW;
    private static WeakReference<Activity> vsX;
    public static HashMap<String, String> vsY = new HashMap();
    public static HashMap<String, String> vsZ;

    /* JADX WARNING: Removed duplicated region for block: B:33:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean M(String str, String str2, int i) {
        AppMethodBeat.i(125840);
        Context context = ah.getContext();
        ab.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d fileExt: %s", str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length()), str2);
        if (new File(str).exists()) {
            Intent G;
            String ajT = ajT(str2);
            String ajQ = ajQ(ajT);
            if (ajQ.equals("com.baidu.searchbox")) {
                ajR(ajT);
                ajQ = "";
            }
            if (!ajQ.equals("")) {
                ab.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", ajQ);
                Intent E = E(context, ajT, str);
                E.setPackage(ajQ);
                if (bo.k(context, E)) {
                    ab.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", ajT);
                    context.startActivity(E);
                    AppMethodBeat.o(125840);
                    return false;
                }
                ab.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", ajT);
            }
            if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_qb_document_action_flag, true)) {
                G = G(context, str, str2);
                if (bo.k(context, G)) {
                    ah.getContext().startActivity(G);
                    h.pYm.e(11168, Integer.valueOf(5), Integer.valueOf(i));
                    AppMethodBeat.o(125840);
                    return false;
                }
            }
            G = F(context, ajT, str);
            if (bo.k(context, G)) {
                ah.getContext().startActivity(G);
                h.pYm.e(11168, Integer.valueOf(5), Integer.valueOf(i));
                AppMethodBeat.o(125840);
                return false;
            }
            int i2;
            if (!bo.isNullOrNil(str2)) {
                ajQ = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, (Object) "");
                if (!bo.isNullOrNil(ajQ) && ajQ.contains(str2)) {
                    i2 = 1;
                    if (i2 != 0) {
                        AppMethodBeat.o(125840);
                        return true;
                    } else if (i == 7) {
                        AppMethodBeat.o(125840);
                        return true;
                    } else {
                        D(context, str, str2);
                        AppMethodBeat.o(125840);
                        return false;
                    }
                }
            }
            i2 = 0;
            if (i2 != 0) {
            }
        } else {
            ab.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
            AppMethodBeat.o(125840);
            return true;
        }
    }

    public static void a(Activity activity, String str, String str2, int i) {
        boolean z = true;
        AppMethodBeat.i(125841);
        ab.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length()));
        if (new File(str).exists()) {
            Intent E;
            Intent G;
            Context context = ah.getContext();
            String ajT = ajT(str2);
            String ajQ = ajQ(ajT);
            if (ajQ.equals("com.baidu.searchbox")) {
                ajR(ajT);
                ajQ = "";
            }
            if (!ajQ.equals("")) {
                ab.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", ajQ);
                E = E(ah.getContext(), ajT, str);
                E.setPackage(ajQ);
                if (bo.k(context, E)) {
                    ab.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", ajT);
                    context.startActivity(E);
                    AppMethodBeat.o(125841);
                    return;
                }
                ab.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", ajT);
            }
            if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_qb_document_action_flag, true)) {
                G = G(context, str, str2);
                if (bo.k(context, G)) {
                    ah.getContext().startActivity(G);
                    h.pYm.e(11168, Integer.valueOf(5), Integer.valueOf(i));
                    AppMethodBeat.o(125841);
                    return;
                }
            }
            G = F(context, ajT, str);
            if (bo.k(context, G)) {
                ah.getContext().startActivity(G);
                h.pYm.e(11168, Integer.valueOf(5), Integer.valueOf(i));
                AppMethodBeat.o(125841);
                return;
            }
            boolean z2;
            Intent E2 = E(context, ajT, str);
            if (o.fF(ah.getContext())) {
                z2 = false;
            } else {
                z2 = true;
            }
            ajT = ajT(str2);
            Uri fromFile = Uri.fromFile(new File(str));
            Bundle bundle = new Bundle();
            bundle.putString("targeturl", fromFile.toString());
            bundle.putString("filepath", str);
            bundle.putString("fileext", str2);
            bundle.putParcelable("targetintent", E2);
            E = new Intent();
            E.putExtra("type", 0);
            E.putExtra("title", activity.getResources().getString(R.string.apd));
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
                ((com.tencent.mm.choosemsgfile.compat.a) g.K(com.tencent.mm.choosemsgfile.compat.a.class)).h(activity, str, str2);
            } else {
                D(activity, str, str2);
            }
            vsW = E;
            vsX = new WeakReference(activity);
            AppMethodBeat.o(125841);
            return;
        }
        ab.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
        AppMethodBeat.o(125841);
    }

    public static boolean b(Activity activity, String str, String str2, int i) {
        AppMethodBeat.i(125842);
        String ajT = ajT(str2);
        Uri fromFile = Uri.fromFile(new File(str));
        Bundle bundle = new Bundle();
        Intent E = E(activity, ajT, str);
        bundle.putString("targeturl", fromFile.toString());
        bundle.putString("filepath", str);
        bundle.putString("fileext", str2);
        bundle.putParcelable("targetintent", E);
        Intent intent = new Intent(activity, AppChooserUI.class);
        intent.putExtra("type", 0);
        intent.putExtra("title", activity.getResources().getString(R.string.apd));
        intent.putExtra("mimetype", ajT);
        intent.putExtra("targetintent", E);
        intent.putExtra("transferback", bundle);
        intent.putExtra("scene", i);
        intent.putExtra("openWay", true);
        activity.startActivityForResult(intent, 2);
        AppMethodBeat.o(125842);
        return true;
    }

    private static void D(Context context, String str, String str2) {
        AppMethodBeat.i(125843);
        Intent intent = new Intent();
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.addFlags(268435456);
        intent.setComponent(new ComponentName(l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
        context.sendBroadcast(intent);
        AppMethodBeat.o(125843);
    }

    public static void aF(Intent intent) {
        AppMethodBeat.i(125844);
        boolean booleanExtra = intent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
        intent.getStringExtra("file_path");
        String stringExtra = intent.getStringExtra("file_ext");
        ab.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", Boolean.valueOf(booleanExtra));
        if (g.RK()) {
            Object obj = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, (Object) "");
            if (!booleanExtra) {
                obj = obj.replace(stringExtra, "");
            } else if (!obj.contains(stringExtra)) {
                obj = obj.concat(stringExtra);
            }
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, obj);
            if (!(booleanExtra || vsW == null || vsX == null || vsX.get() == null)) {
                vsW.setClass((Context) vsX.get(), AppChooserUI.class);
                ((Activity) vsX.get()).startActivityForResult(vsW, 2);
            }
            vsW = null;
            AppMethodBeat.o(125844);
            return;
        }
        AppMethodBeat.o(125844);
    }

    public static void a(Activity activity, int i, int i2, Intent intent, boolean z, int i3, int i4, int i5) {
        AppMethodBeat.i(125845);
        if (i == 2) {
            if (-1 == i2 && intent != null) {
                String stringExtra = intent.getStringExtra("selectpkg");
                Intent intent2 = (Intent) intent.getBundleExtra("transferback").getParcelable("targetintent");
                if (intent2 != null) {
                    ab.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", stringExtra);
                    Intent intent3 = new Intent(intent2);
                    intent3.setPackage(stringExtra);
                    if (bo.k((Context) activity, intent3)) {
                        activity.startActivity(intent3);
                        if (TbsConfig.APP_QB.equals(stringExtra)) {
                            h.pYm.e(11168, Integer.valueOf(5), Integer.valueOf(i5));
                            AppMethodBeat.o(125845);
                            return;
                        }
                    }
                    ab.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
                    if (z) {
                        com.tencent.mm.ui.base.h.g(activity, i3, i4);
                    }
                    AppMethodBeat.o(125845);
                    return;
                }
                ab.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
                if (z) {
                    com.tencent.mm.ui.base.h.g(activity, i3, i4);
                }
                AppMethodBeat.o(125845);
                return;
            } else if (4098 == i2) {
                ab.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
                if (z) {
                    com.tencent.mm.ui.base.h.g(activity, i3, i4);
                    AppMethodBeat.o(125845);
                    return;
                }
            } else if (4097 == i2) {
                ab.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
                if (z) {
                    com.tencent.mm.ui.base.h.g(activity, i3, i4);
                    AppMethodBeat.o(125845);
                    return;
                }
            } else {
                ab.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
            }
        }
        AppMethodBeat.o(125845);
    }

    private static Intent E(Context context, String str, String str2) {
        AppMethodBeat.i(125846);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        k.a(context, intent, new File(str2), str);
        try {
            ab.i("MicroMsg.AppChooserIntentUtil", "createNormalIntent %s %s %s", str, str2, intent.toString());
        } catch (Exception e) {
        }
        AppMethodBeat.o(125846);
        return intent;
    }

    private static Intent F(Context context, String str, String str2) {
        AppMethodBeat.i(125847);
        Intent intent = new Intent();
        intent.setPackage(TbsConfig.APP_QB);
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        k.a(context, intent, new File(str2), str);
        try {
            ab.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserIntent %s %s %s", str, str2, intent.toString());
        } catch (Exception e) {
        }
        AppMethodBeat.o(125847);
        return intent;
    }

    private static Intent G(Context context, String str, String str2) {
        AppMethodBeat.i(125848);
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
        if (bo.isNullOrNil(str3)) {
            str3 = ajT(str2);
        }
        k.a(context, intent, new File(str), str3);
        try {
            ab.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent %s %s %s %s", str3, str, intent.toString(), str2);
        } catch (Exception e) {
        }
        AppMethodBeat.o(125848);
        return intent;
    }

    private static String ajQ(String str) {
        AppMethodBeat.i(125849);
        String str2 = (String) g.RP().Ry().get(ajS(str), (Object) "");
        AppMethodBeat.o(125849);
        return str2;
    }

    private static void ajR(String str) {
        AppMethodBeat.i(125850);
        g.RP().Ry().set(ajS(str), (Object) "");
        AppMethodBeat.o(125850);
    }

    private static int ajS(String str) {
        AppMethodBeat.i(125851);
        if (str != null) {
            int hashCode = 274528 + str.hashCode();
            AppMethodBeat.o(125851);
            return hashCode;
        }
        AppMethodBeat.o(125851);
        return 274528;
    }

    private static String ajT(String str) {
        String str2;
        AppMethodBeat.i(125852);
        if (bo.isNullOrNil(str)) {
            str2 = "application/octet-stream";
        } else {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
            if (bo.isNullOrNil(str2)) {
                str2 = (String) vsY.get(str);
            }
            if (bo.isNullOrNil(str2)) {
                if (str.startsWith("/")) {
                    str2 = "application/octet-stream";
                } else {
                    str2 = "application/".concat(String.valueOf(str));
                }
            }
        }
        ab.i("MicroMsg.AppChooserIntentUtil", "getMimeTypeByExt fileExt: %s mimeType: %s", str, str2);
        AppMethodBeat.o(125852);
        return str2;
    }

    static {
        AppMethodBeat.i(125853);
        long currentTimeMillis = System.currentTimeMillis();
        InputStream inputStream = null;
        try {
            inputStream = ah.getContext().getAssets().open("mimetype.txt");
            for (String split : new String(e.q(inputStream)).split(IOUtils.LINE_SEPARATOR_UNIX)) {
                String[] split2 = split.split(",");
                if (split2 == null || split2.length <= 1 || bo.isNullOrNil(split2[0]) || bo.isNullOrNil(split2[1])) {
                    ab.i("MicroMsg.AppChooserIntentUtil", "mimeType %s", split);
                } else {
                    vsY.put(split2[0].trim(), split2[1].trim());
                }
            }
            ab.i("MicroMsg.AppChooserIntentUtil", "read from mimetype text %d %d %d", Integer.valueOf(r4.length), Integer.valueOf(vsY.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            e.p(inputStream);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.AppChooserIntentUtil", e, "read mimeType from asset", new Object[0]);
            e.p(inputStream);
        } catch (Throwable th) {
            e.p(inputStream);
            AppMethodBeat.o(125853);
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
        AppMethodBeat.o(125853);
    }
}
