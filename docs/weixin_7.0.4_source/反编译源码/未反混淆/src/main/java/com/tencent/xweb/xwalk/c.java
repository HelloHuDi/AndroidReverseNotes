package com.tencent.xweb.xwalk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.d;
import com.tencent.xweb.c.k;
import com.tencent.xweb.i;
import com.tencent.xweb.m;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.a.e;
import com.tencent.xweb.xwalk.a.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public final class c implements d {
    Context AMr;
    WebView ARb;
    ScrollView ARc = null;
    TextView ARd = null;
    TextView ARe = null;
    TextView ARf = null;
    Button ARg = null;
    View ARh;
    boolean ARi = false;
    String ARj = "tools";

    class b extends n {
        boolean ARG = false;
        private ProgressDialog ARs;

        public b(Context context) {
            super(context);
        }

        public final void onXWalkUpdateProgress(int i) {
            AppMethodBeat.i(85177);
            super.onXWalkUpdateProgress(i);
            if (this.ARG) {
                AppMethodBeat.o(85177);
                return;
            }
            try {
                avt("正在下载runtime");
                if (this.ARs != null) {
                    this.ARs.setProgress(i);
                }
                AppMethodBeat.o(85177);
            } catch (Exception e) {
                Log.i("WebDebugPage", "may run in background failed to load alert:" + e.getMessage());
                AppMethodBeat.o(85177);
            }
        }

        public final void onXWalkUpdateFailed(int i) {
            AppMethodBeat.i(85178);
            super.onXWalkUpdateFailed(i);
            try {
                this.ARs.setCancelable(true);
                this.ARs.setCanceledOnTouchOutside(true);
                avt("更新失败, error code = :".concat(String.valueOf(i)));
                AppMethodBeat.o(85178);
            } catch (Exception e) {
                Log.i("WebDebugPage", "may run in background failed to load alert:" + e.getMessage());
                AppMethodBeat.o(85178);
            }
        }

        public final void onXWalkUpdateCancelled() {
            AppMethodBeat.i(85179);
            super.onXWalkUpdateCancelled();
            try {
                this.ARs.setCancelable(true);
                this.ARs.setCanceledOnTouchOutside(true);
                avt("更新失败, 更新被取消");
                AppMethodBeat.o(85179);
            } catch (Exception e) {
                Log.i("WebDebugPage", "may run in background failed to load alert:" + e.getMessage());
                AppMethodBeat.o(85179);
            }
        }

        public final void onXWalkUpdateCompleted() {
            AppMethodBeat.i(85180);
            super.onXWalkUpdateCompleted();
            try {
                avt("更新完成，点任意位置重启进程生效");
                this.ARs.setCancelable(true);
                this.ARs.setCanceledOnTouchOutside(true);
                this.ARs.setProgress(100);
                this.ARG = true;
                AppMethodBeat.o(85180);
            } catch (Exception e) {
                Log.i("WebDebugPage", "may run in background failed to load alert:" + e.getMessage());
                AppMethodBeat.o(85180);
            }
        }

        private void avt(String str) {
            AppMethodBeat.i(85181);
            if (this.ARs == null) {
                this.ARs = new ProgressDialog(this.mContext);
                this.ARs.setProgressStyle(1);
                this.ARs.setMessage(str);
                this.ARs.setOnCancelListener(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(85176);
                        c.this.aAe();
                        AppMethodBeat.o(85176);
                    }
                });
                this.ARs.setCancelable(false);
                this.ARs.show();
            }
            this.ARs.setMessage(str);
            AppMethodBeat.o(85181);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$38 */
    class AnonymousClass38 implements OnClickListener {
        final /* synthetic */ String ARB;
        final /* synthetic */ String ARy;

        AnonymousClass38(String str, String str2) {
            this.ARB = str;
            this.ARy = str2;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(85166);
            c cVar = c.this;
            String str = this.ARB;
            String str2 = this.ARy;
            o.iK(str, str2);
            String[] split = str2.split("\\.");
            if (split.length == 2) {
                cVar.ARb.loadUrl("file://" + split[0] + "/main.html");
            }
            cVar.ARh.setVisibility(8);
            AppMethodBeat.o(85166);
        }
    }

    static class a extends UpdateConfig {
        String ARF;

        public a(String str, String str2) {
            int i = 100000;
            int availableVersion = XWalkEnvironment.getAvailableVersion();
            if (availableVersion >= 100000) {
                i = availableVersion + 1;
            }
            this(i);
            AppMethodBeat.i(85175);
            this.ARF = str;
            this.isMatchMd5 = false;
            this.isPatchUpdate = false;
            this.versionDetail = "local:".concat(String.valueOf(str2));
            AppMethodBeat.o(85175);
        }

        public final boolean checkValid() {
            return true;
        }

        private a(int i) {
            super(null, false, i);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$33 */
    class AnonymousClass33 extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ String ARw;
        private ProgressDialog nBv = null;

        AnonymousClass33(String str) {
            this.ARw = str;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(85162);
            if (((Boolean) obj).booleanValue()) {
                c.a(c.this, "", com.tencent.xweb.d.a.XWEB);
                this.nBv.setMessage("安装完成，默认开启，请重启进程");
                this.nBv.getButton(-1).setVisibility(0);
                AppMethodBeat.o(85162);
                return;
            }
            this.nBv.setMessage("安装失败");
            this.nBv.getButton(-2).setVisibility(0);
            AppMethodBeat.o(85162);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.i(85161);
            this.nBv = new ProgressDialog(c.this.AMr);
            this.nBv.setProgressStyle(0);
            this.nBv.setMessage("安装中");
            this.nBv.setCancelable(false);
            this.nBv.setCanceledOnTouchOutside(false);
            this.nBv.setButton(-2, "取消", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(85159);
                    AnonymousClass33.this.nBv.hide();
                    AppMethodBeat.o(85159);
                }
            });
            this.nBv.setButton(-1, "重启", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(85160);
                    c.this.aAe();
                    AppMethodBeat.o(85160);
                }
            });
            this.nBv.show();
            this.nBv.getButton(-2).setVisibility(8);
            this.nBv.getButton(-1).setVisibility(8);
            AppMethodBeat.o(85161);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(85163);
            Boolean valueOf = Boolean.valueOf(c.avs(this.ARw));
            AppMethodBeat.o(85163);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$40 */
    class AnonymousClass40 implements Runnable {
        final /* synthetic */ String ARC;

        AnonymousClass40(String str) {
            this.ARC = str;
        }

        public final void run() {
            AppMethodBeat.i(85168);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            o.a(new File[]{new File(this.ARC)}, this.ARC + ".zip");
            AppMethodBeat.o(85168);
        }
    }

    static /* synthetic */ void b(c cVar, String str) {
        AppMethodBeat.i(85207);
        cVar.avr(str);
        AppMethodBeat.o(85207);
    }

    public c(WebView webView) {
        AppMethodBeat.i(85182);
        this.AMr = webView.getContext();
        this.ARb = webView;
        dVD();
        dVB();
        AppMethodBeat.o(85182);
    }

    public final void dUl() {
        AppMethodBeat.i(85183);
        if (m.dTZ().AMt) {
            a(m.dTZ().AMt, null, false);
        }
        AppMethodBeat.o(85183);
    }

    /* JADX WARNING: Removed duplicated region for block: B:96:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x024b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean avh(String str) {
        boolean z = false;
        AppMethodBeat.i(85184);
        if (str == null) {
            AppMethodBeat.o(85184);
            return false;
        }
        boolean z2;
        if (str.contains("debugmm.qq.com") || str.contains("debugxweb.qq.com")) {
            Uri parse = Uri.parse(str);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                String queryParameter;
                int i;
                boolean i2;
                int lastIndexOf;
                z2 = false;
                for (String queryParameter2 : queryParameterNames) {
                    if (queryParameter2 != null) {
                        switch (queryParameter2.hashCode()) {
                            case -1767214708:
                                if (queryParameter2.equals("encrpt_url")) {
                                    i2 = 4;
                                    break;
                                }
                            case -873960692:
                                if (queryParameter2.equals("ticket")) {
                                    i2 = 2;
                                    break;
                                }
                            case -677737752:
                                if (queryParameter2.equals("forcex5")) {
                                    i2 = 0;
                                    break;
                                }
                            case -82035977:
                                if (queryParameter2.equals("inspector")) {
                                    i2 = true;
                                    break;
                                }
                            case 624401059:
                                if (queryParameter2.equals("show_x5_ver")) {
                                    i2 = 3;
                                    break;
                                }
                            default:
                                i2 = -1;
                                break;
                        }
                        switch (i2) {
                            case 0:
                                if (parse.getBooleanQueryParameter("forcex5", false)) {
                                    m.dTZ().a("tools", WebView.d.WV_KIND_X5);
                                    m.dTZ().a("appbrand", WebView.d.WV_KIND_X5);
                                    m.dTZ().a("support", WebView.d.WV_KIND_X5);
                                    m.dTZ().a("mm", WebView.d.WV_KIND_X5);
                                    m.dTZ().a("toolsmp", WebView.d.WV_KIND_X5);
                                    m.dTZ().a(com.tencent.xweb.i.a.RT_TYPE_X5);
                                    ct("force use x5 switch is on ", true);
                                } else {
                                    m.dTZ().a("tools", WebView.d.WV_KIND_NONE);
                                    m.dTZ().a("appbrand", WebView.d.WV_KIND_NONE);
                                    m.dTZ().a("support", WebView.d.WV_KIND_NONE);
                                    m.dTZ().a("mm", WebView.d.WV_KIND_NONE);
                                    m.dTZ().a("toolsmp", WebView.d.WV_KIND_NONE);
                                    m.dTZ().a(com.tencent.xweb.i.a.RT_TYPE_AUTO);
                                    ct("force use x5 switch is off ", true);
                                }
                                AppMethodBeat.o(85184);
                                return true;
                            case 1:
                                i2 = parse.getBooleanQueryParameter("inspector", false);
                                m.dTZ().rw(i2);
                                a(i2, null, true);
                                AppMethodBeat.o(85184);
                                return true;
                            case 2:
                                queryParameter2 = parse.getQueryParameter("ticket");
                                String uri = parse.toString();
                                if (TextUtils.isEmpty(uri) || TextUtils.isEmpty(queryParameter2)) {
                                    i2 = false;
                                } else {
                                    uri = uri.trim();
                                    lastIndexOf = uri.lastIndexOf("ticket");
                                    if (lastIndexOf < 0 || lastIndexOf >= uri.length()) {
                                        i2 = false;
                                    } else {
                                        i2 = queryParameter2.equalsIgnoreCase(aaV((uri.substring(0, lastIndexOf) + "@check_permission@" + new SimpleDateFormat("yyyyMMdd").format(new Date())).toLowerCase()));
                                    }
                                }
                                if (!i2) {
                                    cs("权限校验失败", true);
                                    Log.e("WebDebugPage", "checkTempPerssion failed");
                                    z2 = i2;
                                    break;
                                }
                                Log.i("WebDebugPage", "checkTempPerssion suc");
                                z2 = i2;
                                break;
                                break;
                            case 3:
                                i2 = parse.getBooleanQueryParameter("show_x5_ver", false);
                                m dTZ = m.dTZ();
                                if (i2 != dTZ.AMv) {
                                    dTZ.AMv = i2;
                                    dTZ.AMr.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowX5Version", dTZ.AMv).commit();
                                }
                                if (i2) {
                                    cs("开启显示x5内核信息", true);
                                } else {
                                    cs("关闭显示x5内核信息", true);
                                }
                                AppMethodBeat.o(85184);
                                return true;
                            case 4:
                                try {
                                    queryParameter2 = com.tencent.xweb.util.a.a(parse.getQueryParameter("encrpt_url"), com.tencent.xweb.util.a.avj("b01d4598de5875eb9b86abdef32b811e9c55edcfb1673b5617cc0a6ab7dceaff"));
                                    if (TextUtils.isEmpty(queryParameter2)) {
                                        cs("解密失败", true);
                                        AppMethodBeat.o(85184);
                                        return true;
                                    }
                                    avh(queryParameter2);
                                    AppMethodBeat.o(85184);
                                    return true;
                                } catch (Throwable th) {
                                    cs("解密失败", true);
                                }
                            default:
                                break;
                        }
                    }
                }
                if (str.contains("public.debugxweb.qq.com")) {
                    int i3;
                    boolean z3;
                    int i4 = (m.dTZ().AMr.getSharedPreferences("wcwebview", 4).getBoolean("m_bEnableLocalDebug", false) || z2) ? true : 0;
                    if (str.contains("debugxweb.qq.com") || z2) {
                        Uri parse2 = Uri.parse(str);
                        queryParameterNames = parse2.getQueryParameterNames();
                        if (queryParameterNames == null || queryParameterNames.size() == 0) {
                            if (i4 != 0) {
                                dVF();
                            }
                            AppMethodBeat.o(85184);
                            return true;
                        }
                        i3 = 0;
                        lastIndexOf = 0;
                        for (String queryParameter22 : queryParameterNames) {
                            if (queryParameter22 != null) {
                                switch (queryParameter22.hashCode()) {
                                    case -1258153200:
                                        if (queryParameter22.equals("clear_cache")) {
                                            i2 = 6;
                                            break;
                                        }
                                    case -844092179:
                                        if (queryParameter22.equals("fix_dex")) {
                                            i2 = 8;
                                            break;
                                        }
                                    case -604633792:
                                        if (queryParameter22.equals("kill_all")) {
                                            i2 = 3;
                                            break;
                                        }
                                    case -82035977:
                                        if (queryParameter22.equals("inspector")) {
                                            i2 = 0;
                                            break;
                                        }
                                    case 176290201:
                                        if (queryParameter22.equals("clear_old_ver")) {
                                            i2 = 7;
                                            break;
                                        }
                                    case 184008721:
                                        if (queryParameter22.equals("save_page")) {
                                            i2 = 5;
                                            break;
                                        }
                                    case 386281809:
                                        if (queryParameter22.equals("set_grayvalue")) {
                                            i2 = 2;
                                            break;
                                        }
                                    case 724449292:
                                        if (queryParameter22.equals("use_testconfig")) {
                                            i2 = true;
                                            break;
                                        }
                                    case 971862549:
                                        if (queryParameter22.equals("ignore_crashwatch")) {
                                            i2 = 4;
                                            break;
                                        }
                                    default:
                                        i2 = -1;
                                        break;
                                }
                                switch (i2) {
                                    case 0:
                                        i2 = parse2.getBooleanQueryParameter("inspector", false);
                                        m.dTZ().rw(i2);
                                        a(i2, null, true);
                                        lastIndexOf = true;
                                        break;
                                    case 1:
                                        i2 = parse2.getBooleanQueryParameter("use_testconfig", false);
                                        m.dTZ().ry(i2);
                                        if (i2) {
                                            cs("使用测试config", true);
                                        } else {
                                            cs("使用正式config", true);
                                        }
                                        lastIndexOf = true;
                                        break;
                                    case 2:
                                        try {
                                            i2 = Integer.parseInt(parse2.getQueryParameter("set_grayvalue"));
                                            XWalkEnvironment.setGrayValueForTest(i2);
                                            cs("灰度值设为" + (i2 % Downloads.MIN_WAIT_FOR_NETWORK), true);
                                            lastIndexOf = true;
                                            break;
                                        } catch (Exception e) {
                                            cs("灰度值设置失败，参数解析错误", true);
                                            lastIndexOf = true;
                                            break;
                                        }
                                    case 3:
                                        i3 = true;
                                        lastIndexOf = true;
                                        break;
                                    case 4:
                                        i2 = parse2.getBooleanQueryParameter("ignore_crashwatch", false);
                                        m dTZ2 = m.dTZ();
                                        dTZ2.AMz = i2;
                                        dTZ2.AMr.getSharedPreferences("wcwebview", 0).edit().putBoolean("ignore_crashwatch", i2).commit();
                                        cs("忽略crash检测设为 = ".concat(String.valueOf(i2)), true);
                                        break;
                                    case 5:
                                        i2 = !m.dTZ().AMw;
                                        m.dTZ().rx(i2);
                                        if (!i2) {
                                            if (this.ARg == null) {
                                                break;
                                            }
                                            this.ARg.setVisibility(8);
                                            break;
                                        }
                                        dVB();
                                        this.ARg.setVisibility(0);
                                        break;
                                    case 6:
                                        w.clearAllWebViewCache(XWalkEnvironment.getApplicationContext(), true);
                                        cs("网页cache已经清理:", true);
                                        break;
                                    case 7:
                                        n.E(XWalkEnvironment.getApplicationContext(), true);
                                        cs("旧版本已经清理", true);
                                        break;
                                    case 8:
                                        n.dVL();
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        i2 = lastIndexOf;
                    } else {
                        i3 = 0;
                        i2 = false;
                    }
                    if (i4 != 0) {
                        if (cr(str, z2) || i2) {
                            z = true;
                        }
                        z3 = z;
                    } else {
                        z3 = i2;
                    }
                    if (i3 != 0) {
                        aAe();
                    }
                    AppMethodBeat.o(85184);
                    return z3;
                }
                Uri parse3 = Uri.parse(str);
                queryParameterNames = parse3.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String queryParameter222 : queryParameterNames) {
                        if (queryParameter222 != null) {
                            switch (queryParameter222.hashCode()) {
                                case -1157057597:
                                    if (queryParameter222.equals("enable_local_debug")) {
                                        i2 = 0;
                                        break;
                                    }
                                default:
                                    i2 = -1;
                                    break;
                            }
                            switch (i2) {
                                case 0:
                                    m.dTZ().AMr.getSharedPreferences("wcwebview", 4).edit().putBoolean("m_bEnableLocalDebug", parse3.getBooleanQueryParameter("enable_local_debug", false)).commit();
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
                AppMethodBeat.o(85184);
                return true;
            }
        }
        z2 = false;
        if (str.contains("public.debugxweb.qq.com")) {
        }
    }

    private static String aaV(String str) {
        AppMethodBeat.i(85185);
        String str2;
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            if (digest == null || digest.length == 0) {
                str2 = "";
                AppMethodBeat.o(85185);
                return str2;
            }
            StringBuilder stringBuilder = new StringBuilder(digest.length);
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() == 1) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(toHexString);
            }
            str2 = stringBuilder.toString().toUpperCase();
            AppMethodBeat.o(85185);
            return str2;
        } catch (Exception e) {
            str2 = "";
            AppMethodBeat.o(85185);
            return str2;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean cr(String str, boolean z) {
        AppMethodBeat.i(85186);
        if (str.contains("debugxweb.qq.com") || z) {
            Uri parse = Uri.parse(str);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames == null || queryParameterNames.size() == 0) {
                dVF();
                AppMethodBeat.o(85186);
                return true;
            }
            for (String str2 : queryParameterNames) {
                String str22;
                if (str22 != null) {
                    int i;
                    boolean i2;
                    switch (str22.hashCode()) {
                        case -1688684924:
                            if (str22.equals("set_apkver")) {
                                i2 = 9;
                                break;
                            }
                        case -1479708147:
                            if (str22.equals("set_config_peroid")) {
                                i2 = 13;
                                break;
                            }
                        case -1302829141:
                            if (str22.equals("wait_debugger")) {
                                i2 = 7;
                                break;
                            }
                        case -974615216:
                            if (str22.equals("show_webview_version")) {
                                i2 = 3;
                                break;
                            }
                        case -939528941:
                            if (str22.equals("revert_to_apk")) {
                                i2 = 12;
                                break;
                            }
                        case -748036674:
                            if (str22.equals("set_appbrand_config")) {
                                i2 = 2;
                                break;
                            }
                        case -83404669:
                            if (str22.equals("debug_process")) {
                                i2 = 8;
                                break;
                            }
                        case 208243139:
                            if (str22.equals("recheck_cmds")) {
                                i2 = 14;
                                break;
                            }
                        case 368659514:
                            if (str22.equals("clear_commands")) {
                                i2 = 4;
                                break;
                            }
                        case 603805332:
                            if (str22.equals("load_local_xwalk")) {
                                i2 = false;
                                break;
                            }
                        case 684429537:
                            if (str22.equals("set_plugin_config_url")) {
                                i2 = 11;
                                break;
                            }
                        case 989541982:
                            if (str22.equals("check_xwalk_update")) {
                                i2 = 6;
                                break;
                            }
                        case 1098980480:
                            if (str22.equals("check_files")) {
                                i2 = 10;
                                break;
                            }
                        case 1874228874:
                            if (str22.equals("set_web_config")) {
                                i2 = true;
                                break;
                            }
                        case 2135256815:
                            if (str22.equals("set_config_url")) {
                                i2 = 5;
                                break;
                            }
                        default:
                            i2 = -1;
                            break;
                    }
                    WebView.d valueOf;
                    switch (i2) {
                        case 0:
                            rD(false);
                            break;
                        case 1:
                            try {
                                valueOf = WebView.d.valueOf(parse.getQueryParameter("set_web_config"));
                                m.dTZ().a("tools", valueOf);
                                m.dTZ().a("toolsmp", valueOf);
                                cs("打开网页将使用:".concat(String.valueOf(valueOf)), true);
                                break;
                            } catch (Exception e) {
                                break;
                            }
                        case 2:
                            try {
                                valueOf = WebView.d.valueOf(parse.getQueryParameter("set_appbrand_config"));
                                m.dTZ().a("appbrand", valueOf);
                                m.dTZ().a("support", valueOf);
                                switch (valueOf) {
                                    case WV_KIND_CW:
                                        m.dTZ().a(com.tencent.xweb.i.a.RT_TYPE_MMV8);
                                        cs("打开小程序将使用:".concat(String.valueOf(valueOf)), true);
                                        break;
                                    case WV_KIND_X5:
                                        m.dTZ().a(com.tencent.xweb.i.a.RT_TYPE_X5);
                                        cs("打开小程序将使用:".concat(String.valueOf(valueOf)), true);
                                        break;
                                    case WV_KIND_SYS:
                                        m.dTZ().a(com.tencent.xweb.i.a.RT_TYPE_MMV8);
                                        cs("打开小程序将使用:".concat(String.valueOf(valueOf)), true);
                                        break;
                                    default:
                                        break;
                                }
                            } catch (Exception e2) {
                                break;
                            }
                        case 3:
                            if (this.ARf != null) {
                                break;
                            }
                            ScrollView scrollView = new ScrollView(this.AMr);
                            this.ARf = new TextView(this.AMr);
                            this.ARf.setBackgroundColor(-1);
                            scrollView.addView(this.ARf);
                            this.ARf.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(85133);
                                    c.this.dVC();
                                    AppMethodBeat.o(85133);
                                }
                            });
                            dVC();
                            this.ARb.getTopView().addView(scrollView);
                            break;
                        case 4:
                            com.tencent.xweb.a.a(null, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            break;
                        case 5:
                            try {
                                str22 = parse.getQueryParameter("set_config_url");
                                XWalkEnvironment.setTestDownLoadUrl(this.AMr, str22);
                                cs("测试连接设置为:".concat(String.valueOf(str22)), true);
                                break;
                            } catch (Exception e3) {
                                cs("测试连接设置失败，格式错误", true);
                                break;
                            }
                        case 6:
                            dVH();
                            break;
                        case 7:
                            i2 = parse.getBooleanQueryParameter("wait_debugger", false);
                            m dTZ = m.dTZ();
                            dTZ.AMy = i2;
                            dTZ.AMr.getSharedPreferences("wcwebview", 0).edit().putBoolean("bWaitforDebugger", i2).commit();
                            break;
                        case 8:
                            m.dTZ().AMr.getSharedPreferences("wcwebview", 4).edit().putString("strDebugProcess", parse.getQueryParameter("debug_process")).commit();
                            break;
                        case 9:
                            str22 = parse.getQueryParameter("set_apkver");
                            try {
                                XWalkEnvironment.setAvailableVersion(Integer.parseInt(str22), "1.0.".concat(String.valueOf(str22)));
                                ct("版本号设置到:" + str22 + " 点击空白处退出重启进程", true);
                                break;
                            } catch (Exception e4) {
                                cs("设置版本号失败:" + e4.getMessage(), true);
                                break;
                            }
                        case 10:
                            n.rE(true);
                            break;
                        case 11:
                            try {
                                str22 = parse.getQueryParameter("set_plugin_config_url");
                                XWalkEnvironment.setPluginTestConfigUrl(str22);
                                cs("插件测试连接设置为:".concat(String.valueOf(str22)), true);
                                break;
                            } catch (Exception e5) {
                                cs("插件测试连接设置失败，格式错误", true);
                                break;
                            }
                        case 12:
                            try {
                                ct("版本号回滚到:" + n.aE(XWalkEnvironment.getApplicationContext(), Integer.parseInt(parse.getQueryParameter("revert_to_apk"))) + " 点击空白处退出重启进程", true);
                                break;
                            } catch (Exception e42) {
                                cs("版本号回滚到失败:" + e42.getMessage(), true);
                                break;
                            }
                        case 13:
                            str22 = parse.getQueryParameter("set_config_peroid");
                            try {
                                com.tencent.xweb.a.Sv(Integer.parseInt(str22));
                                ct("设置配置拉取周期为:" + str22 + "分钟", false);
                                break;
                            } catch (Exception e422) {
                                cs("设置配置拉取周期失败:" + e422.getMessage(), true);
                                break;
                            }
                        case 14:
                            k.f(WebView.d.WV_KIND_CW).excute("STR_CMD_SET_RECHECK_COMMAND", null);
                            ct("重新跑了一遍命令配置 点击空白处退出重启进程", true);
                            break;
                        default:
                            break;
                    }
                }
            }
            AppMethodBeat.o(85186);
            return true;
        }
        AppMethodBeat.o(85186);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void dVB() {
        AppMethodBeat.i(85187);
        if (!m.dTZ().AMw) {
            AppMethodBeat.o(85187);
        } else if (this.ARg != null) {
            AppMethodBeat.o(85187);
        } else {
            this.ARg = new Button(this.AMr);
            this.ARg.setText("保存页面");
            this.ARg.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85122);
                    new Builder(c.this.AMr).setTitle("保存页面").setMessage("确定保存页面？").setPositiveButton("确定", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(85121);
                            c cVar = c.this;
                            Date date = new Date();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
                            String str = Environment.getExternalStorageDirectory().getPath() + "/xweb_dump/" + simpleDateFormat.format(date);
                            cVar.ARb.savePage(str + "/main.html", str + "/resource", 1);
                            new Thread(new AnonymousClass40(str)).start();
                            AppMethodBeat.o(85121);
                        }
                    }).setNegativeButton("取消", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).show();
                    AppMethodBeat.o(85122);
                }
            });
            this.ARb.getTopView().addView(this.ARg);
            AppMethodBeat.o(85187);
        }
    }

    /* Access modifiers changed, original: final */
    public final void dVC() {
        AppMethodBeat.i(85188);
        if (this.ARf == null) {
            AppMethodBeat.o(85188);
            return;
        }
        String xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
        String str = "\n\n" + this.ARb.getAbstractInfo();
        if (WebView.getCurWebType() != WebView.d.WV_KIND_CW) {
            str = str + "\n xwebsdk is = 190301 apk ver is " + XWalkEnvironment.getAvailableVersion();
        }
        StringBuilder append = new StringBuilder().append(str).append("\n\n current js engine: =  ").append(i.dTU()).append("\n prefered js engine =  ").append(i.a(com.tencent.xweb.i.a.RT_TYPE_AUTO, "appbrand", this.AMr)).append("\n isWaitingForUpdate = ");
        com.tencent.xweb.xwalk.b.c.dVV();
        CharSequence stringBuilder = append.append(com.tencent.xweb.xwalk.b.c.dVW()).append("\n local gray value = ").append(XWalkEnvironment.getGrayValue()).append("\n config url = ").append(xWalkUpdateConfigUrl).append("\n config period(minutes) = ").append(com.tencent.xweb.xwalk.b.c.dWb() / 60000).append("\n\n apilevel = ").append(VERSION.SDK_INT).append("\n device is  ").append(Build.BRAND).append(" ").append(Build.MODEL).append("\n usertype is ").append(XWalkEnvironment.getUserType()).toString();
        xWalkUpdateConfigUrl = com.tencent.xweb.a.getAbstractInfo();
        if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
            stringBuilder = stringBuilder + "\n\n ------dump commands start:------\n" + xWalkUpdateConfigUrl + "\n ------dump commands end------";
        }
        xWalkUpdateConfigUrl = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (com.tencent.xweb.xwalk.b.c.dVX()) {
                xWalkUpdateConfigUrl = ((((((xWalkUpdateConfigUrl + "going to update to apk ver = " + com.tencent.xweb.xwalk.b.c.dWd().ATn) + "\n update time is = " + simpleDateFormat.format(new Date(com.tencent.xweb.xwalk.b.c.dWd().ATv))) + "\n is patch update = " + com.tencent.xweb.xwalk.b.c.dWd().ATt) + "\n can use cellular = " + com.tencent.xweb.xwalk.b.c.dWd().ATh) + "\n try count = " + com.tencent.xweb.xwalk.b.c.dWd().ATx) + "\n try use shared core count = " + com.tencent.xweb.xwalk.b.c.dWd().ATy) + IOUtils.LINE_SEPARATOR_UNIX;
            }
            xWalkUpdateConfigUrl = xWalkUpdateConfigUrl + " last fetch config time = " + simpleDateFormat.format(new Date(com.tencent.xweb.xwalk.b.c.dWd().ATs));
        } catch (Exception e) {
        }
        if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
            stringBuilder = stringBuilder + "\n\n ------dump schedule updateInfo start:------\n" + xWalkUpdateConfigUrl + "\n ------dump schedule updateInfo end------";
        }
        xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkInitializeLog();
        if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
            stringBuilder = stringBuilder + "\n\n ------dump xweb log------\n" + xWalkUpdateConfigUrl;
        }
        this.ARf.setText(stringBuilder);
        AppMethodBeat.o(85188);
    }

    /* Access modifiers changed, original: final */
    public final void dVD() {
        AppMethodBeat.i(85189);
        if (!m.dTZ().AMu && (!m.dTZ().AMv || this.ARb.getWebCoreType() != WebView.d.WV_KIND_X5)) {
            AppMethodBeat.o(85189);
        } else if (this.ARe != null) {
            AppMethodBeat.o(85189);
        } else {
            this.ARe = new TextView(this.AMr);
            this.ARe.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(85144);
                    c.this.dVF();
                    AppMethodBeat.o(85144);
                    return true;
                }
            });
            dVE();
            this.ARb.getTopView().addView(this.ARe);
            AppMethodBeat.o(85189);
        }
    }

    /* Access modifiers changed, original: final */
    public final String rC(boolean z) {
        AppMethodBeat.i(85190);
        String versionInfo = this.ARb.getVersionInfo();
        if (z) {
            versionInfo = versionInfo + ", " + e.dVR() + " current process is " + XWalkEnvironment.getProcessName();
        } else {
            int indexOf = versionInfo.indexOf(",apkversion");
            if (indexOf > 0) {
                versionInfo = versionInfo.substring(0, indexOf);
            }
        }
        AppMethodBeat.o(85190);
        return versionInfo;
    }

    private void dVE() {
        AppMethodBeat.i(85191);
        if (this.ARe == null) {
            AppMethodBeat.o(85191);
            return;
        }
        this.ARe.setText(rC(false));
        AppMethodBeat.o(85191);
    }

    /* Access modifiers changed, original: final */
    public final void l(WebView.d dVar) {
        AppMethodBeat.i(85192);
        switch (dVar) {
            case WV_KIND_CW:
                ((RadioButton) this.ARh.findViewById(R.id.b89)).setChecked(true);
                AppMethodBeat.o(85192);
                return;
            case WV_KIND_X5:
                ((RadioButton) this.ARh.findViewById(R.id.b8a)).setChecked(true);
                AppMethodBeat.o(85192);
                return;
            case WV_KIND_SYS:
                ((RadioButton) this.ARh.findViewById(R.id.b8_)).setChecked(true);
                break;
            case WV_KIND_NONE:
                ((RadioButton) this.ARh.findViewById(R.id.b88)).setChecked(true);
                AppMethodBeat.o(85192);
                return;
        }
        AppMethodBeat.o(85192);
    }

    /* Access modifiers changed, original: final */
    public final boolean dVF() {
        AppMethodBeat.i(85193);
        if (this.ARh != null) {
            this.ARh.setVisibility(0);
            AppMethodBeat.o(85193);
        } else {
            this.ARh = ((LayoutInflater) this.AMr.getSystemService("layout_inflater")).inflate(R.layout.ru, this.ARb.getTopView(), true).findViewById(R.id.adk);
            ((Button) this.ARh.findViewById(R.id.b7x)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85164);
                    c.this.ARh.setVisibility(8);
                    AppMethodBeat.o(85164);
                }
            });
            final CheckBox checkBox = (CheckBox) this.ARh.findViewById(R.id.b7v);
            checkBox.setChecked(m.dTZ().AMu);
            checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(85170);
                    m dTZ = m.dTZ();
                    if (z != dTZ.AMu) {
                        dTZ.AMu = z;
                        dTZ.AMr.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", dTZ.AMu).commit();
                    }
                    if (z) {
                        c.this.dVD();
                        c.this.ARe.setVisibility(0);
                        AppMethodBeat.o(85170);
                        return;
                    }
                    if (c.this.ARe != null) {
                        c.this.ARe.setVisibility(8);
                    }
                    AppMethodBeat.o(85170);
                }
            });
            ((TextView) this.ARh.findViewById(R.id.b7w)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85171);
                    checkBox.setChecked(!checkBox.isChecked());
                    AppMethodBeat.o(85171);
                }
            });
            final EditText editText = (EditText) this.ARh.findViewById(R.id.b8h);
            if (editText != null) {
                editText.setInputType(2);
                editText.setText(XWalkEnvironment.getGrayValue());
                editText.addTextChangedListener(new TextWatcher() {
                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        AppMethodBeat.i(85172);
                        int i = 0;
                        try {
                            i = Integer.parseInt(editText.getText().toString());
                        } catch (Exception e) {
                        }
                        XWalkEnvironment.setGrayValueForTest(i);
                        AppMethodBeat.o(85172);
                    }
                });
            }
            ((Spinner) this.ARh.findViewById(R.id.b86)).setOnItemSelectedListener(new OnItemSelectedListener() {
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    int i2 = 1;
                    AppMethodBeat.i(85173);
                    String[] stringArray = c.this.AMr.getResources().getStringArray(R.array.ax);
                    c.this.ARj = stringArray[i];
                    c cVar = c.this;
                    cVar.ARi = true;
                    if (cVar.ARj.equals("all")) {
                        String[] stringArray2 = cVar.AMr.getResources().getStringArray(R.array.aw);
                        WebView.d avg = m.dTZ().avg(stringArray2[0]);
                        while (i2 < stringArray2.length) {
                            if (m.dTZ().avg(stringArray2[i2]) != avg) {
                                ((RadioButton) cVar.ARh.findViewById(R.id.b88)).setChecked(false);
                                ((RadioButton) cVar.ARh.findViewById(R.id.b89)).setChecked(false);
                                ((RadioButton) cVar.ARh.findViewById(R.id.b8a)).setChecked(false);
                                ((RadioButton) cVar.ARh.findViewById(R.id.b8_)).setChecked(false);
                                break;
                            }
                            i2++;
                        }
                        cVar.l(avg);
                    } else {
                        cVar.l(m.dTZ().avg(cVar.ARj));
                    }
                    cVar.ARi = false;
                    AppMethodBeat.o(85173);
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            ((RadioGroup) this.ARh.findViewById(R.id.b87)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                    AppMethodBeat.i(85174);
                    if (c.this.ARi) {
                        AppMethodBeat.o(85174);
                        return;
                    }
                    WebView.d dVar = WebView.d.WV_KIND_NONE;
                    if (i == R.id.b88) {
                        dVar = WebView.d.WV_KIND_NONE;
                    } else if (i == R.id.b89) {
                        dVar = WebView.d.WV_KIND_CW;
                    } else if (i == R.id.b8a) {
                        dVar = WebView.d.WV_KIND_X5;
                    } else if (i == R.id.b8_) {
                        dVar = WebView.d.WV_KIND_SYS;
                    }
                    if (c.this.ARj.equals("all")) {
                        String[] stringArray = c.this.AMr.getResources().getStringArray(R.array.aw);
                        for (int i2 = 0; i2 < stringArray.length; i2++) {
                            m.dTZ().a(stringArray[i2], dVar);
                            Log.d("WebDebugPage", "webview " + stringArray[i2] + " change to=" + dVar);
                        }
                        AppMethodBeat.o(85174);
                        return;
                    }
                    m.dTZ().a(c.this.ARj, dVar);
                    Log.d("WebDebugPage", "webview change to=".concat(String.valueOf(dVar)));
                    AppMethodBeat.o(85174);
                }
            });
            switch (m.dTZ().AMA) {
                case RT_TYPE_AUTO:
                    ((RadioButton) this.ARh.findViewById(R.id.b8c)).setChecked(true);
                    break;
                case RT_TYPE_SYS:
                    ((RadioButton) this.ARh.findViewById(R.id.b8e)).setChecked(true);
                    break;
                case RT_TYPE_X5:
                    ((RadioButton) this.ARh.findViewById(R.id.b8f)).setChecked(true);
                    break;
                case RT_TYPE_NATIVE_SCRIPT:
                    ((RadioButton) this.ARh.findViewById(R.id.b8d)).setChecked(true);
                    break;
                case RT_TYPE_MMV8:
                    ((RadioButton) this.ARh.findViewById(R.id.b8g)).setChecked(true);
                    break;
            }
            ((RadioGroup) this.ARh.findViewById(R.id.b8b)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                    AppMethodBeat.i(85123);
                    com.tencent.xweb.i.a aVar = com.tencent.xweb.i.a.RT_TYPE_AUTO;
                    if (i == R.id.b8c) {
                        aVar = com.tencent.xweb.i.a.RT_TYPE_AUTO;
                    } else if (i == R.id.b8e) {
                        aVar = com.tencent.xweb.i.a.RT_TYPE_SYS;
                    } else if (i == R.id.b8f) {
                        aVar = com.tencent.xweb.i.a.RT_TYPE_X5;
                    } else if (i == R.id.b8d) {
                        aVar = com.tencent.xweb.i.a.RT_TYPE_NATIVE_SCRIPT;
                    } else if (i == R.id.b8g) {
                        aVar = com.tencent.xweb.i.a.RT_TYPE_MMV8;
                    }
                    m.dTZ().a(aVar);
                    Log.d("WebDebugPage", "v8 type change to=".concat(String.valueOf(aVar)));
                    AppMethodBeat.o(85123);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b8i)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85124);
                    c.this.ARh.setVisibility(8);
                    c.this.aAe();
                    AppMethodBeat.o(85124);
                }
            });
            final Button button = (Button) this.ARh.findViewById(R.id.b8j);
            a(m.dTZ().AMt, button, false);
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85125);
                    boolean z = !m.dTZ().AMt;
                    m.dTZ().rw(z);
                    c.this.a(z, button, true);
                    AppMethodBeat.o(85125);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b8k)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85126);
                    XWalkEnvironment.clearAllVersion(c.this.AMr);
                    AppMethodBeat.o(85126);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b92)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85127);
                    ((TextView) c.this.ARh.findViewById(R.id.b95)).setText(c.this.rC(true) + IOUtils.LINE_SEPARATOR_UNIX + XWalkInitializer.getXWalkInitializeLog());
                    AppMethodBeat.o(85127);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b8n)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85128);
                    c.this.rD(true);
                    AppMethodBeat.o(85128);
                }
            });
            button = (Button) this.ARh.findViewById(R.id.b8l);
            button.setText(m.dTZ().AMB ? "使用正式版config" : "使用测试config");
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85129);
                    m.dTZ().ry(!m.dTZ().AMB);
                    button.setText(m.dTZ().AMB ? "使用正式版config" : "使用测试config");
                    AppMethodBeat.o(85129);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b8m)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85130);
                    c.this.dVH();
                    AppMethodBeat.o(85130);
                }
            });
            final LinearLayout linearLayout = (LinearLayout) this.ARh.findViewById(R.id.b8p);
            linearLayout.setVisibility(8);
            Button button2 = (Button) this.ARh.findViewById(R.id.b8o);
            button2.setText("插件设置");
            button2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85131);
                    if (linearLayout.getVisibility() == 8) {
                        linearLayout.setVisibility(0);
                        ((Button) view).setText("隐藏插件设置");
                        AppMethodBeat.o(85131);
                        return;
                    }
                    linearLayout.setVisibility(8);
                    ((Button) view).setText("插件设置");
                    AppMethodBeat.o(85131);
                }
            });
            button = (Button) this.ARh.findViewById(R.id.b8q);
            button.setText(XWalkEnvironment.hasPluginTestConfigUrl() ? "切换插件config，当前使用测试版" : "切换插件config，当前使用正式版");
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85132);
                    if (XWalkEnvironment.hasPluginTestConfigUrl()) {
                        if (XWalkEnvironment.setPluginTestConfigUrl("")) {
                            button.setText("切换插件config，当前使用正式版");
                            AppMethodBeat.o(85132);
                            return;
                        }
                        c.this.cs("切换失败", true);
                        AppMethodBeat.o(85132);
                    } else if (XWalkEnvironment.setPluginTestConfigUrl(XWalkEnvironment.DOWNLOAD_PLUGIN_UPDATE_TEST_CONFIG_DEFAULT_URL)) {
                        button.setText("切换插件config，当前使用测试版");
                        AppMethodBeat.o(85132);
                    } else {
                        c.this.cs("切换失败", true);
                        AppMethodBeat.o(85132);
                    }
                }
            });
            ((Button) this.ARh.findViewById(R.id.b8s)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85134);
                    f fVar = new f();
                    HashMap hashMap = new HashMap();
                    hashMap.put("UpdaterCheckType", "1");
                    fVar.a(c.this.AMr, hashMap);
                    Toast.makeText(c.this.AMr, "开始检测插件更新", 0).show();
                    AppMethodBeat.o(85134);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b8t)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85135);
                    c.a(c.this, XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO);
                    AppMethodBeat.o(85135);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b8r)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85136);
                    for (com.tencent.xweb.xwalk.a.c SD : e.dVQ()) {
                        SD.SD(-1);
                    }
                    String pluginBaseDir = XWalkEnvironment.getPluginBaseDir();
                    if (pluginBaseDir.isEmpty()) {
                        AppMethodBeat.o(85136);
                        return;
                    }
                    com.tencent.xweb.util.b.avl(pluginBaseDir);
                    c.this.aAe();
                    AppMethodBeat.o(85136);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b8u)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    int i = 100000;
                    AppMethodBeat.i(85137);
                    c cVar = c.this;
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    if (externalStorageDirectory == null) {
                        cVar.cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
                        AppMethodBeat.o(85137);
                    } else if (externalStorageDirectory.listFiles() == null) {
                        cVar.cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
                        AppMethodBeat.o(85137);
                    } else {
                        com.tencent.xweb.xwalk.a.c avu = e.avu(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO);
                        if (avu == null) {
                            cVar.cs("插件未准备好", true);
                            AppMethodBeat.o(85137);
                            return;
                        }
                        if (avu.ASG >= 100000) {
                            i = avu.ASG + 1;
                        }
                        File file = new File(externalStorageDirectory.getPath() + "/apkxwebtest/xweb_fullscreen_video.js");
                        externalStorageDirectory = new File(avu.aM(i, false));
                        if (externalStorageDirectory.exists()) {
                            externalStorageDirectory.delete();
                        }
                        if (com.tencent.xweb.util.b.m(file, externalStorageDirectory)) {
                            avu.SD(i);
                            new Builder(cVar.AMr).setMessage("加载成功，请重启进程").setCancelable(false).setPositiveButton("确定", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(85158);
                                    c.this.aAe();
                                    AppMethodBeat.o(85158);
                                }
                            }).create().show();
                            AppMethodBeat.o(85137);
                            return;
                        }
                        cVar.cs("加载失败，请检查文件是否存在", true);
                        AppMethodBeat.o(85137);
                    }
                }
            });
            ((Button) this.ARh.findViewById(R.id.b8v)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85138);
                    c.a(c.this, XWalkEnvironment.XWALK_PLUGIN_NAME_FILE_READER);
                    AppMethodBeat.o(85138);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b8w)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85139);
                    c cVar = c.this;
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    if (externalStorageDirectory == null) {
                        cVar.cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
                        AppMethodBeat.o(85139);
                    } else if (externalStorageDirectory.listFiles() == null) {
                        cVar.cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
                        AppMethodBeat.o(85139);
                    } else {
                        String str = externalStorageDirectory.getPath() + "/apkxwebtest/xweb_filereader.zip";
                        if (new File(str).exists()) {
                            new AnonymousClass33(str).execute(new Void[0]);
                            AppMethodBeat.o(85139);
                            return;
                        }
                        cVar.cs("文件不存在 /apkxwebtest/xweb_filereader.zip", true);
                        AppMethodBeat.o(85139);
                    }
                }
            });
            ((TextView) this.ARh.findViewById(R.id.b8x)).setText(dVG());
            editText = (EditText) this.ARh.findViewById(R.id.b8y);
            ((Button) this.ARh.findViewById(R.id.b8z)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85140);
                    c.a(c.this, editText.getText().toString(), com.tencent.xweb.d.a.XWEB);
                    AppMethodBeat.o(85140);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b90)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85141);
                    c.a(c.this, editText.getText().toString(), com.tencent.xweb.d.a.X5);
                    AppMethodBeat.o(85141);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b91)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85142);
                    c.a(c.this, editText.getText().toString(), com.tencent.xweb.d.a.NONE);
                    AppMethodBeat.o(85142);
                }
            });
            ((TextView) this.ARh.findViewById(R.id.b95)).setText(rC(true) + IOUtils.LINE_SEPARATOR_UNIX + XWalkInitializer.getXWalkInitializeLog());
            ((LinearLayout) this.ARh.findViewById(R.id.b84)).setVisibility(8);
            ((Button) this.ARh.findViewById(R.id.b7z)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85143);
                    XWalkEnvironment.setGrayValueForTest(1);
                    if (XWalkEnvironment.hasAvailableVersion()) {
                        m.dTZ().a("tools", WebView.d.WV_KIND_CW);
                        m.dTZ().a("toolsmp", WebView.d.WV_KIND_CW);
                        m.dTZ().a("appbrand", WebView.d.WV_KIND_CW);
                        m.dTZ().a("support", WebView.d.WV_KIND_CW);
                        m.dTZ().a("mm", WebView.d.WV_KIND_CW);
                        c.this.ct("已使用XWeb，点任意位置重启进程生效\n", true);
                        AppMethodBeat.o(85143);
                    } else if (XWalkEnvironment.isIaDevice()) {
                        c.this.avh("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml&check_xwalk_update");
                        AppMethodBeat.o(85143);
                    } else {
                        c.this.avh("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml&check_xwalk_update");
                        AppMethodBeat.o(85143);
                    }
                }
            });
            ((Button) this.ARh.findViewById(R.id.b80)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85145);
                    m.dTZ().a("tools", WebView.d.WV_KIND_X5);
                    m.dTZ().a("toolsmp", WebView.d.WV_KIND_X5);
                    m.dTZ().a("appbrand", WebView.d.WV_KIND_X5);
                    m.dTZ().a("support", WebView.d.WV_KIND_X5);
                    m.dTZ().a("mm", WebView.d.WV_KIND_X5);
                    if (WebView.getInstalledTbsCoreVersion(c.this.AMr) <= 0) {
                        c.this.cs("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
                        AppMethodBeat.o(85145);
                        return;
                    }
                    c.this.ct("已使用x5，点任意位置重启进程生效\n", true);
                    AppMethodBeat.o(85145);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b81)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85146);
                    m.dTZ().a("tools", WebView.d.WV_KIND_SYS);
                    m.dTZ().a("toolsmp", WebView.d.WV_KIND_SYS);
                    m.dTZ().a("appbrand", WebView.d.WV_KIND_SYS);
                    m.dTZ().a("support", WebView.d.WV_KIND_SYS);
                    m.dTZ().a("mm", WebView.d.WV_KIND_SYS);
                    c.this.ct("已使用system，点任意位置重启进程生效\n", true);
                    AppMethodBeat.o(85146);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b82)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85147);
                    XWalkEnvironment.setGrayValueForTest(0);
                    XWalkEnvironment.setTestDownLoadUrl(c.this.AMr, "");
                    m.dTZ().a("tools", WebView.d.WV_KIND_NONE);
                    m.dTZ().a("toolsmp", WebView.d.WV_KIND_NONE);
                    m.dTZ().a("appbrand", WebView.d.WV_KIND_NONE);
                    m.dTZ().a("support", WebView.d.WV_KIND_NONE);
                    m.dTZ().a("mm", WebView.d.WV_KIND_NONE);
                    c.this.ct("已使用AUTO，点任意位置重启进程生效\n", true);
                    AppMethodBeat.o(85147);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b83)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85148);
                    LinearLayout linearLayout = (LinearLayout) c.this.ARh.findViewById(R.id.b84);
                    if (linearLayout.getVisibility() == 8) {
                        linearLayout.setVisibility(0);
                        ((Button) view).setText("隐藏高级设置");
                        AppMethodBeat.o(85148);
                        return;
                    }
                    linearLayout.setVisibility(8);
                    ((Button) view).setText("高级设置");
                    AppMethodBeat.o(85148);
                }
            });
            ((Button) this.ARh.findViewById(R.id.b93)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85149);
                    boolean z = !m.dTZ().AMw;
                    m.dTZ().rx(z);
                    if (z) {
                        c.this.dVB();
                        c.this.ARg.setVisibility(0);
                        AppMethodBeat.o(85149);
                        return;
                    }
                    if (c.this.ARg != null) {
                        c.this.ARg.setVisibility(8);
                    }
                    AppMethodBeat.o(85149);
                }
            });
            button = (Button) this.ARh.findViewById(R.id.b94);
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(85150);
                    c cVar = c.this;
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    if (externalStorageDirectory == null) {
                        cVar.cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
                        AppMethodBeat.o(85150);
                    } else if (externalStorageDirectory.listFiles() == null) {
                        cVar.cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
                        AppMethodBeat.o(85150);
                    } else {
                        String str = externalStorageDirectory.getPath() + "/xweb_dump";
                        try {
                            File[] listFiles = new File(str).listFiles();
                            if (listFiles == null || listFiles.length == 0) {
                                cVar.cs("web_dump目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                                AppMethodBeat.o(85150);
                                return;
                            }
                            for (int i = 0; i < listFiles.length; i++) {
                                if (listFiles[i].getName().endsWith(".zip")) {
                                    String absolutePath = listFiles[i].getAbsolutePath();
                                    new Builder(cVar.AMr).setTitle("提示").setMessage("确定加载:" + listFiles[i].getName() + "?").setPositiveButton("确定", new AnonymousClass38(str, absolutePath)).setNegativeButton("取消", new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                        }
                                    }).show();
                                    AppMethodBeat.o(85150);
                                    return;
                                }
                            }
                            cVar.cs("web_dump目录下没有.zip文件", true);
                            AppMethodBeat.o(85150);
                        } catch (Exception e) {
                            cVar.cs("没有找到web_dump目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                            AppMethodBeat.o(85150);
                        }
                    }
                }
            });
            button.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(85152);
                    new Builder(c.this.AMr).setTitle("提示").setMessage("清空保存页面文件").setPositiveButton("确定", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(85151);
                            c.b(c.this, Environment.getExternalStorageDirectory() + "/xweb_dump");
                            AppMethodBeat.o(85151);
                        }
                    }).setNegativeButton("取消", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).show();
                    AppMethodBeat.o(85152);
                    return false;
                }
            });
            AppMethodBeat.o(85193);
        }
        return true;
    }

    private static String dVG() {
        AppMethodBeat.i(85194);
        StringBuilder stringBuilder = new StringBuilder("文件预览服务设置：\n");
        for (String str : com.tencent.xweb.d.ALV) {
            stringBuilder.append(str).append(": force-").append(com.tencent.xweb.a.avf(m.dTZ().AMr.getSharedPreferences("wcwebview", 4).getString("force_fr_" + str.toLowerCase(), ""))).append("  cmd-").append(com.tencent.xweb.a.auX(str)).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(85194);
        return stringBuilder2;
    }

    private void avr(String str) {
        AppMethodBeat.i(85195);
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    avr(str + "//" + str2);
                }
            }
        }
        file.delete();
        AppMethodBeat.o(85195);
    }

    /* Access modifiers changed, original: final */
    public final void dVH() {
        AppMethodBeat.i(85196);
        com.tencent.xweb.a.a(null, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", 0);
        edit.putBoolean("bCanUseCellular", true);
        edit.putLong("nTimeToUpdate", 100);
        edit.commit();
        com.tencent.xweb.xwalk.b.c.dWd().ATs = 100;
        com.tencent.xweb.xwalk.b.c.dWd().ATh = true;
        com.tencent.xweb.xwalk.b.c.dWd().ATv = 100;
        new b(this.AMr).s(null);
        AppMethodBeat.o(85196);
    }

    protected static void jB(Context context) {
        AppMethodBeat.i(85198);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid) {
                String str = runningAppProcessInfo.processName;
                if (str == null || !str.contains("com.tencent.mm") || runningAppProcessInfo.processName.contains("tools") || runningAppProcessInfo.processName.contains("appbrand") || runningAppProcessInfo.processName.contains("support")) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
        Process.killProcess(myPid);
        AppMethodBeat.o(85198);
    }

    public final void a(boolean z, Button button, boolean z2) {
        AppMethodBeat.i(85199);
        try {
            XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, z);
        } catch (Exception e) {
        }
        try {
            if (VERSION.SDK_INT >= 19) {
                android.webkit.WebView.setWebContentsDebuggingEnabled(z);
            }
        } catch (Exception e2) {
        }
        try {
            com.tencent.smtt.sdk.WebView.setWebContentsDebuggingEnabled(z);
        } catch (Exception e3) {
        }
        if (z2 && this.ARb.getX5WebViewExtension() != null) {
            if (z) {
                this.ARb.loadUrl("http://debugx5.qq.com/?inspector=true");
            } else {
                this.ARb.loadUrl("http://debugx5.qq.com/?inspector=false");
            }
        }
        if (button != null) {
            if (z) {
                button.setText("关闭远程调试模式");
                AppMethodBeat.o(85199);
                return;
            }
            button.setText("打开远程调试模式");
        }
        AppMethodBeat.o(85199);
    }

    public static boolean avs(String str) {
        int i = 99999;
        AppMethodBeat.i(85200);
        com.tencent.xweb.xwalk.a.c avu = e.avu(XWalkEnvironment.XWALK_PLUGIN_NAME_FILE_READER);
        if (avu == null) {
            AppMethodBeat.o(85200);
            return false;
        }
        try {
            if (avu.ASG >= 99999) {
                i = avu.ASG + 1;
            }
            com.tencent.xweb.xwalk.a.d dVar = new com.tencent.xweb.xwalk.a.d();
            dVar.version = i;
            dVar.isPatch = false;
            dVar.cvZ = com.tencent.xweb.util.d.cz(str);
            dVar.path = avu.aM(i, false);
            com.tencent.xweb.util.b.copyFile(str, dVar.path);
            if (avu.a(dVar) == 0) {
                AppMethodBeat.o(85200);
                return true;
            }
            AppMethodBeat.o(85200);
            return false;
        } catch (Exception e) {
            Log.e("WebDebugPage", "loadFileReaderFromLocalInternal error: " + e.getMessage());
            AppMethodBeat.o(85200);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final void rD(final boolean z) {
        AppMethodBeat.i(85201);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
            AppMethodBeat.o(85201);
        } else if (externalStorageDirectory.listFiles() == null) {
            cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
            AppMethodBeat.o(85201);
        } else {
            try {
                File[] listFiles = new File(externalStorageDirectory.getPath() + "/apkxwebtest").listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    cs("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                    AppMethodBeat.o(85201);
                    return;
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].getName().endsWith(".zip")) {
                        final String absolutePath = listFiles[i].getAbsolutePath();
                        final String name = listFiles[i].getName();
                        if (z) {
                            new Builder(this.AMr).setTitle("提示").setMessage("确定加载:" + name + "?").setPositiveButton("确定", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(85165);
                                    c.this.G(absolutePath, name, z);
                                    AppMethodBeat.o(85165);
                                }
                            }).setNegativeButton("取消", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).show();
                            AppMethodBeat.o(85201);
                            return;
                        }
                        G(absolutePath, name, z);
                        AppMethodBeat.o(85201);
                        return;
                    }
                }
                cs("apkxwebtest目录下没有.zip文件", true);
                AppMethodBeat.o(85201);
            } catch (Exception e) {
                cs("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                AppMethodBeat.o(85201);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void G(String str, String str2, boolean z) {
        AppMethodBeat.i(85202);
        a aVar = new a(str, str2);
        try {
            File file = new File(XWalkEnvironment.getDownloadZipDir(aVar.apkVer));
            if (file.exists()) {
                file.delete();
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
        }
        try {
            Integer onHandleFile = XWalkUpdater.onHandleFile(aVar);
            if (onHandleFile.intValue() == 0) {
                cs("安装" + str2 + "成功", z);
                AppMethodBeat.o(85202);
                return;
            }
            cs("安装" + str2 + "失败,错误码=" + onHandleFile, true);
            AppMethodBeat.o(85202);
        } catch (Exception e2) {
            cs("安装失败", true);
            Log.e("WebDebugPage", "install local apk failed : " + e2.getMessage());
            AppMethodBeat.o(85202);
        }
    }

    /* Access modifiers changed, original: final */
    public final void cs(String str, boolean z) {
        AppMethodBeat.i(85203);
        if (z) {
            try {
                Builder builder = new Builder(this.AMr);
                builder.setMessage(str);
                builder.create().show();
                AppMethodBeat.o(85203);
                return;
            } catch (Exception e) {
                Log.i("WebDebugPage", "show alert failed may be in abtets exe " + e.getMessage());
                AppMethodBeat.o(85203);
                return;
            }
        }
        Log.e("WebDebugPage", str);
        AppMethodBeat.o(85203);
    }

    /* Access modifiers changed, original: final */
    public final void ct(String str, boolean z) {
        AppMethodBeat.i(85204);
        try {
            Builder builder = new Builder(this.AMr);
            builder.setMessage(str);
            builder.create();
            builder.setCancelable(true);
            if (z) {
                builder.setOnCancelListener(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(85167);
                        c.this.aAe();
                        AppMethodBeat.o(85167);
                    }
                });
            }
            builder.show();
            AppMethodBeat.o(85204);
        } catch (Exception e) {
            Log.i("WebDebugPage", "show alert failed may be in abtets exe " + e.getMessage());
            AppMethodBeat.o(85204);
        }
    }

    /* Access modifiers changed, original: final */
    public final void aAe() {
        AppMethodBeat.i(85197);
        jB(this.AMr);
        AppMethodBeat.o(85197);
    }

    static /* synthetic */ void a(c cVar, final String str) {
        AppMethodBeat.i(85205);
        final f fVar = new f();
        AnonymousClass31 anonymousClass31 = new com.tencent.xweb.xwalk.a.f.a() {
            private ProgressDialog ARs = null;
            boolean mFinished = false;

            public final void dVI() {
                AppMethodBeat.i(85155);
                this.ARs = new ProgressDialog(c.this.AMr);
                this.ARs.setProgressStyle(1);
                this.ARs.setMessage("下载更新中");
                this.ARs.setCancelable(false);
                this.ARs.setCanceledOnTouchOutside(false);
                this.ARs.setButton(-2, "取消", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(85153);
                        if (!AnonymousClass31.this.mFinished) {
                            f fVar = fVar;
                            if (fVar.ASM != null) {
                                fVar.ASM.a(4, -1, null);
                            }
                        }
                        AppMethodBeat.o(85153);
                    }
                });
                this.ARs.setButton(-1, "重启", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(85154);
                        c.this.aAe();
                        AppMethodBeat.o(85154);
                    }
                });
                this.ARs.show();
                this.ARs.getButton(-1).setVisibility(8);
                AppMethodBeat.o(85155);
            }

            public final void Sy(int i) {
                AppMethodBeat.i(85156);
                if (this.mFinished || this.ARs == null) {
                    AppMethodBeat.o(85156);
                    return;
                }
                this.ARs.setProgress(i);
                AppMethodBeat.o(85156);
            }

            public final void Sz(int i) {
                AppMethodBeat.i(85157);
                this.mFinished = true;
                if (this.ARs == null) {
                    AppMethodBeat.o(85157);
                    return;
                }
                switch (i) {
                    case -9:
                        this.ARs.setMessage("更新失败，下载安装出错，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.o(85157);
                        return;
                    case -8:
                        this.ARs.setMessage("更新失败，未找到可用更新，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.o(85157);
                        return;
                    case -7:
                        this.ARs.setMessage("更新失败，配置中未包含插件信息，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.o(85157);
                        return;
                    case -6:
                        this.ARs.setMessage("更新失败，配置解析失败，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.o(85157);
                        return;
                    case -5:
                        this.ARs.setMessage("更新失败，配置下载失败，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.o(85157);
                        return;
                    case -4:
                        this.ARs.setMessage("更新失败，其它任务正在更新插件，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.o(85157);
                        return;
                    case -3:
                        this.ARs.setMessage("更新失败，未到检查时间，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.o(85157);
                        return;
                    case -2:
                        this.ARs.setMessage("更新失败，无网络，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.o(85157);
                        return;
                    case -1:
                        this.ARs.setMessage("更新被取消，ErrCode = ".concat(String.valueOf(i)));
                        Toast.makeText(c.this.AMr, "更新被取消，ErrCode = ".concat(String.valueOf(i)), 0).show();
                        AppMethodBeat.o(85157);
                        return;
                    case 0:
                        if (XWalkEnvironment.XWALK_PLUGIN_NAME_FILE_READER.equalsIgnoreCase(str)) {
                            c.a(c.this, "", com.tencent.xweb.d.a.XWEB);
                        }
                        this.ARs.setMessage("更新完成，请重启进程");
                        this.ARs.setProgress(100);
                        this.ARs.getButton(-2).setVisibility(8);
                        this.ARs.getButton(-1).setVisibility(0);
                        AppMethodBeat.o(85157);
                        return;
                    default:
                        this.ARs.setMessage("更新失败，未知错误，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.o(85157);
                        return;
                }
            }
        };
        fVar.ASK = str;
        fVar.ASL = anonymousClass31;
        HashMap hashMap = new HashMap();
        hashMap.put("UpdaterCheckType", "1");
        fVar.a(cVar.AMr, hashMap);
        AppMethodBeat.o(85205);
    }
}
