package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p178a.C37431m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.p328r.C19679b;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C21523a;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C28746c;
import com.tencent.p177mm.plugin.qqmail.stub.QQMailStubProxyUI;
import com.tencent.p177mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C23153g.C23154a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29960h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C36860e;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C40347c.C40348a;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.C44576b;
import com.tencent.xweb.WebView.C41116b;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI */
public class ReadMailUI extends MMActivity implements OnCreateContextMenuListener {
    private static String pzR = "var mail_css = document.createElement(\"style\");";
    private static String pzS = "";
    private static String pzT = "";
    private static float pzU;
    private static int pzV;
    private long cvx = -1;
    private SharedPreferences ehZ;
    private C46607d ext = new C46607d(this);
    private ProgressBar gtQ;
    private C7306ak handler;
    private long hxO = -1;
    private String ptI;
    private String ptN;
    private LinearLayout pzA;
    private MailAttachListLinearLayout pzB;
    private View pzC;
    private TextView pzD;
    private TextView pzE;
    private View pzF;
    private long pzG = -1;
    private int pzH;
    private int pzI;
    private String pzJ;
    private String pzK;
    private String pzL;
    private int pzM = 0;
    private String pzN;
    private C7564ap pzO;
    private int pzP = 0;
    private int pzQ = 0;
    private ReadMailProxy pzW;
    private String pzX;
    private int pzY;
    private String pzo;
    private MMWebView pzp;
    private ImageView pzq;
    private TextView pzr;
    private MailAddrsViewControl pzs;
    private MailAddrsViewControl pzt;
    private MailAddrsViewControl pzu;
    private TextView pzv;
    private View pzw;
    private LinearLayout pzx;
    private TextView pzy;
    private TextView pzz;
    private TextView timeTv;

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$4 */
    class C129224 implements C5015a {
        C129224() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(68423);
            if (ReadMailUI.this.ext.isConnected()) {
                double doubleValue = ((Double) new ReadMailProxy(ReadMailUI.this.ext, null).REMOTE_CALL("getMailAppDownloadProgress", Long.valueOf(ReadMailUI.this.hxO))).doubleValue();
                if (doubleValue == 1.0d) {
                    ReadMailUI.m45790t(ReadMailUI.this);
                    AppMethodBeat.m2505o(68423);
                    return false;
                }
                int i;
                if (ReadMailUI.this.pzP == 0) {
                    ReadMailUI.this.pzP = ReadMailUI.this.pzC.getWidth();
                    i = 0;
                } else {
                    i = (int) (((double) ReadMailUI.this.pzP) * doubleValue);
                }
                ReadMailUI.m45768b(ReadMailUI.this, i);
                AppMethodBeat.m2505o(68423);
                return true;
            }
            AppMethodBeat.m2505o(68423);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$7 */
    class C129237 implements OnClickListener {
        C129237() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68426);
            switch (ReadMailUI.this.pzQ) {
                case 0:
                    ReadMailUI.m45762a(ReadMailUI.this, 2);
                    if (C5046bo.isNullOrNil(ReadMailUI.this.pzK) || C5046bo.isNullOrNil(ReadMailUI.this.pzL)) {
                        ReadMailUI.m45741A(ReadMailUI.this);
                        AppMethodBeat.m2505o(68426);
                        return;
                    }
                    ReadMailUI.m45796z(ReadMailUI.this);
                    AppMethodBeat.m2505o(68426);
                    return;
                case 1:
                    ReadMailUI.m45762a(ReadMailUI.this, 1);
                    int intValue = ((Integer) new ReadMailProxy(ReadMailUI.this.ext, null).REMOTE_CALL("removeDownloadQQMailAppTask", Long.valueOf(ReadMailUI.this.hxO))).intValue();
                    if (intValue == -1) {
                        C4990ab.m7413e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", Long.valueOf(ReadMailUI.this.hxO));
                        AppMethodBeat.m2505o(68426);
                        return;
                    } else if (intValue <= 0) {
                        C4990ab.m7413e("MicroMsg.ReadMailUI", "cancel_download_task:fail downloadId = %d", Long.valueOf(ReadMailUI.this.hxO));
                        AppMethodBeat.m2505o(68426);
                        return;
                    } else {
                        C4990ab.m7417i("MicroMsg.ReadMailUI", "cancel_download_task:ok downloadId = %d", Long.valueOf(ReadMailUI.this.hxO));
                        ReadMailUI.this.pzO.stopTimer();
                        ReadMailUI.m45768b(ReadMailUI.this, 0);
                        ReadMailUI.this.pzQ = 0;
                        ReadMailUI.m45786p(ReadMailUI.this);
                        AppMethodBeat.m2505o(68426);
                        return;
                    }
                case 2:
                    ReadMailUI.m45762a(ReadMailUI.this, 3);
                    ReadMailUI.m45746E(ReadMailUI.this);
                    AppMethodBeat.m2505o(68426);
                    return;
                case 3:
                    ReadMailUI.m45762a(ReadMailUI.this, 4);
                    ReadMailUI.m45747F(ReadMailUI.this);
                    break;
            }
            AppMethodBeat.m2505o(68426);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$10 */
    class C2154610 implements C36860e {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$10$1 */
        class C215471 implements Runnable {
            C215471() {
            }

            public final void run() {
                AppMethodBeat.m2504i(68430);
                ReadMailUI.this.pzp.getSettings().setLoadsImagesAutomatically(true);
                ReadMailUI.this.pzp.getSettings().setSupportZoom(true);
                ReadMailUI.this.pzp.getSettings().setBuiltInZoomControls(true);
                ((C29960h) ReadMailUI.this.pzp).dcS();
                ((C29960h) ReadMailUI.this.pzp).dcT();
                AppMethodBeat.m2505o(68430);
            }
        }

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$10$2 */
        class C215482 implements Runnable {
            C215482() {
            }

            public final void run() {
                AppMethodBeat.m2504i(68431);
                int contentHeight = (int) (((float) ReadMailUI.this.pzp.getContentHeight()) * ReadMailUI.this.pzp.getScale());
                C4990ab.m7410d("MicroMsg.ReadMailUI", ReadMailUI.this.pzp.getContentHeight() + "," + ReadMailUI.this.pzp.getHeight() + "," + ReadMailUI.this.pzp.getScale());
                if (Math.abs(contentHeight - ReadMailUI.this.pzp.getHeight()) < 10) {
                    ((C29960h) ReadMailUI.this.pzp).mo38753oe(true);
                }
                AppMethodBeat.m2505o(68431);
            }
        }

        C2154610() {
        }

        /* renamed from: c */
        public final boolean mo20984c(int i, Bundle bundle) {
            return false;
        }

        /* renamed from: oZ */
        public final boolean mo20985oZ(String str) {
            AppMethodBeat.m2504i(68432);
            C4990ab.m7411d("MicroMsg.ReadMailUI", "url:%s", str);
            Intent intent;
            if (str != null && str.startsWith(WebView.SCHEME_MAILTO)) {
                String replace = str.trim().replace(WebView.SCHEME_MAILTO, "");
                Intent intent2 = new Intent(ReadMailUI.this, ComposeUI.class);
                intent2.putExtra("composeType", 4);
                intent2.putExtra("toList", new String[]{replace + " " + replace});
                ReadMailUI.this.startActivity(intent2);
            } else if (str != null && str.startsWith(WebView.SCHEME_TEL)) {
                intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
                intent.addFlags(268435456);
                ReadMailUI.this.startActivity(intent);
            } else if (str == null || str.startsWith("data:")) {
                AppMethodBeat.m2505o(68432);
                return false;
            } else if (((C29960h) ReadMailUI.this.pzp).dcQ()) {
                ((C29960h) ReadMailUI.this.pzp).dcR();
                AppMethodBeat.m2505o(68432);
                return true;
            } else if (str.startsWith("http")) {
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                C25985d.m41467b(ReadMailUI.this, "webview", ".ui.tools.WebViewUI", intent);
            } else {
                AppMethodBeat.m2505o(68432);
                return false;
            }
            AppMethodBeat.m2505o(68432);
            return true;
        }

        public final boolean aba() {
            return false;
        }

        public final void abb() {
        }

        /* renamed from: a */
        public final void mo20981a(MMWebView mMWebView) {
            AppMethodBeat.m2504i(68433);
            mMWebView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
            mMWebView.evaluateJavascript("javascript:" + ReadMailUI.pzR, null);
            mMWebView.evaluateJavascript("javascript:" + ReadMailUI.pzS, null);
            mMWebView.evaluateJavascript("javascript:" + ReadMailUI.pzT, null);
            if (ReadMailUI.this.ext.isConnected()) {
                if (!ReadMailUI.m45790t(ReadMailUI.this)) {
                    ReadMailUI.m45791u(ReadMailUI.this);
                }
                ReadMailUI.this.pzW = new ReadMailProxy(ReadMailUI.this.ext, null, new C21551b(), new C28778c());
                ReadMailUI.this.pzW.REMOTE_CALL("addDownloadCallback", new Object[0]);
            }
            new C7306ak(ReadMailUI.this.getMainLooper()).postDelayed(new C215471(), 200);
            new C7306ak(ReadMailUI.this.getMainLooper()).postDelayed(new C215482(), 400);
            AppMethodBeat.m2505o(68433);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$b */
    public class C21551b {
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$11 */
    class C2876911 implements OnClickListener {
        C2876911() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68434);
            ReadMailUI.m45750I(ReadMailUI.this);
            AppMethodBeat.m2505o(68434);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$6 */
    class C287716 implements Runnable {
        C287716() {
        }

        public final void run() {
            AppMethodBeat.m2504i(68425);
            C46494g.m87724a(ReadMailUI.this, ReadMailUI.this.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"), ReadMailUI.this.getString(C25738R.string.ajk), null);
            AppMethodBeat.m2505o(68425);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$8 */
    class C287728 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$8$1 */
        class C215491 implements Runnable {
            C215491() {
            }

            public final void run() {
                AppMethodBeat.m2504i(68427);
                ReadMailUI.this.pzu.cdj();
                ReadMailUI.this.pzt.cdj();
                AppMethodBeat.m2505o(68427);
            }
        }

        C287728() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68428);
            if (ReadMailUI.this.pzw.getVisibility() == 8) {
                ReadMailUI.this.pzv.setText(C25738R.string.di4);
                ReadMailUI.this.pzw.setVisibility(0);
                ReadMailUI.this.pzw.post(new C215491());
                ReadMailUI.this.pzz.setVisibility(0);
                AppMethodBeat.m2505o(68428);
                return;
            }
            ReadMailUI.this.pzv.setText(C25738R.string.di5);
            ReadMailUI.this.pzw.setVisibility(8);
            ReadMailUI.this.pzz.setVisibility(8);
            AppMethodBeat.m2505o(68428);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$a */
    class C28773a extends C21523a {
        int pAh;

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$a$2 */
        class C215502 implements Runnable {
            C215502() {
            }

            public final void run() {
                AppMethodBeat.m2504i(68440);
                ReadMailUI.this.pzz.setEnabled(false);
                ReadMailUI.this.pzz.setText(C25738R.string.dij);
                ReadMailUI.this.pzz.setTextColor(-7829368);
                ReadMailUI.this.pzz.setCompoundDrawablesWithIntrinsicBounds(C1338a.m2864g(ReadMailUI.this, C25738R.drawable.anr), null, null, null);
                AppMethodBeat.m2505o(68440);
            }
        }

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$a$4 */
        class C287764 implements Runnable {
            C287764() {
            }

            public final void run() {
                AppMethodBeat.m2504i(68442);
                ReadMailUI.m45765a(ReadMailUI.this, new HashMap());
                AppMethodBeat.m2505o(68442);
            }
        }

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$a$5 */
        class C287775 implements Runnable {
            C287775() {
            }

            public final void run() {
                AppMethodBeat.m2504i(68443);
                ReadMailUI.this.gtQ.setVisibility(8);
                ReadMailUI.this.pzG = -2;
                AppMethodBeat.m2505o(68443);
            }
        }

        public C28773a(int i) {
            this.pAh = i;
        }

        public final void onSuccess(String str, final Map<String, String> map) {
            AppMethodBeat.m2504i(68444);
            C4990ab.m7411d("MicroMsg.ReadMailUI", "onSuccess userData = %d", Integer.valueOf(this.pAh));
            switch (this.pAh) {
                case 1:
                    ReadMailUI.m45764a(ReadMailUI.this, new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(68439);
                            if (ReadMailUI.this.pzo.equals(ReadMailUI.this.ptI)) {
                                if (ReadMailUI.this.pzu.getSize() == 0) {
                                    ReadMailUI.this.pzu.mo55348b(ReadMailUI.m45772c(map, ".Response.result.tolist", C5046bo.getInt((String) map.get(".Response.result.tolistlen"), 0)), true);
                                }
                                if (ReadMailUI.this.pzt.getSize() == 0) {
                                    String[] c = ReadMailUI.m45772c(map, ".Response.result.cclist", C5046bo.getInt((String) map.get(".Response.result.cclistlen"), 0));
                                    LinearLayout e = ReadMailUI.this.pzx;
                                    int i = (c == null || c.length == 0) ? 8 : 0;
                                    e.setVisibility(i);
                                    ReadMailUI.this.pzt.mo55348b(c, true);
                                }
                                String str = (String) map.get(".Response.result.content");
                                ReadMailUI.m45765a(ReadMailUI.this, map);
                                String str2 = (String) map.get(".Response.result.tips.wording");
                                if (!C5046bo.isNullOrNil(str2)) {
                                    if ("1".equals((String) map.get(".Response.result.tips.color"))) {
                                        ReadMailUI.this.pzr.setBackgroundColor(-13627);
                                        ReadMailUI.this.pzr.setTextColor(-7515315);
                                    }
                                    ReadMailUI.this.pzr.setText(str2);
                                    ((View) ReadMailUI.this.pzr.getParent()).setVisibility(0);
                                }
                                ReadMailUI.this.pzp.loadDataWithBaseURL(C39540v.ccw() + "?pageWidth=" + ReadMailUI.pzU, "<html style=\"margin-top:" + ReadMailUI.pzV + "px\">" + str + "</html>", "text/html", ProtocolPackage.ServerEncoding, null);
                            }
                            AppMethodBeat.m2505o(68439);
                        }
                    });
                    AppMethodBeat.m2505o(68444);
                    return;
                case 2:
                    ReadMailUI.this.handler.post(new C215502());
                    break;
            }
            C4990ab.m7413e("MicroMsg.ReadMailUI", "onSuccess, invalid userData = %d", Integer.valueOf(this.pAh));
            AppMethodBeat.m2505o(68444);
        }

        public final void onError(final int i, final String str) {
            AppMethodBeat.m2504i(68445);
            C4990ab.m7411d("MicroMsg.ReadMailUI", "onError errCode = %d, userData = %d", Integer.valueOf(i), Integer.valueOf(this.pAh));
            ReadMailUI.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(68441);
                    if (ReadMailUI.this.isFinishing()) {
                        AppMethodBeat.m2505o(68441);
                        return;
                    }
                    Intent intent;
                    switch (C28773a.this.pAh) {
                        case 1:
                            ReadMailUI.this.pzq.setVisibility(0);
                            if (i == -5) {
                                intent = new Intent(ReadMailUI.this, QQMailStubProxyUI.class);
                                intent.addFlags(268435456);
                                ReadMailUI.this.startActivityForResult(intent, 1);
                                AppMethodBeat.m2505o(68441);
                                return;
                            }
                            if (i == -7) {
                                ReadMailUI.this.pzq.setVisibility(8);
                                try {
                                    new ReadMailProxy(ReadMailUI.this.ext, null).REMOTE_CALL("replaceMsgContent", Long.valueOf(ReadMailUI.this.cvx), str);
                                } catch (Exception e) {
                                    C4990ab.m7421w("MicroMsg.ReadMailUI", "replaceMsgContent fail, ex = %s", e.getMessage());
                                }
                            }
                            if (i == -10005 && !C5023at.isConnected(ReadMailUI.this)) {
                                Toast.makeText(ReadMailUI.this, ReadMailUI.this.getString(C25738R.string.bx9, new Object[]{Integer.valueOf(2), Integer.valueOf(i)}), 1).show();
                            }
                            ReadMailUI.this.pzp.loadDataWithBaseURL(C39540v.ccw(), str + "(" + i + ")", "text/html", ProtocolPackage.ServerEncoding, null);
                            AppMethodBeat.m2505o(68441);
                            return;
                        case 2:
                            if (i == -5) {
                                intent = new Intent(ReadMailUI.this, QQMailStubProxyUI.class);
                                intent.addFlags(268435456);
                                ReadMailUI.this.startActivityForResult(intent, 2);
                                AppMethodBeat.m2505o(68441);
                                return;
                            }
                            Toast.makeText(ReadMailUI.this, str, 1).show();
                            AppMethodBeat.m2505o(68441);
                            return;
                        default:
                            C4990ab.m7413e("MicroMsg.ReadMailUI", "onError invalid userData = %d", Integer.valueOf(C28773a.this.pAh));
                            AppMethodBeat.m2505o(68441);
                            return;
                    }
                }
            });
            AppMethodBeat.m2505o(68445);
        }

        public final boolean onReady() {
            AppMethodBeat.m2504i(68446);
            ReadMailUI.this.handler.post(new C287764());
            AppMethodBeat.m2505o(68446);
            return true;
        }

        public final void onComplete() {
            AppMethodBeat.m2504i(68447);
            ReadMailUI.this.handler.post(new C287775());
            AppMethodBeat.m2505o(68447);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$c */
    public class C28778c {
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$9 */
    class C287809 implements OnMenuItemClickListener {
        C287809() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68429);
            ReadMailUI.this.finish();
            AppMethodBeat.m2505o(68429);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$12 */
    class C2878112 implements OnClickListener {
        C2878112() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68435);
            ReadMailUI.this.pzq.setVisibility(8);
            ReadMailUI.m45763a(ReadMailUI.this, new C28746c());
            AppMethodBeat.m2505o(68435);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$13 */
    class C2878213 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$13$1 */
        class C36651 implements C30391c {
            C36651() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                int i2 = 0;
                AppMethodBeat.m2504i(68436);
                if (i == 3) {
                    ReadMailUI.m45751J(ReadMailUI.this);
                    AppMethodBeat.m2505o(68436);
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(ReadMailUI.this, ComposeUI.class);
                intent.putExtra("mailid", ReadMailUI.this.ptI);
                intent.putExtra("subject", ReadMailUI.this.ptN);
                String[] a = ReadMailUI.this.pzs.mo55347a(false, ReadMailUI.this.ext);
                String[] a2 = ReadMailUI.this.pzu.mo55347a(true, ReadMailUI.this.ext);
                String[] a3 = ReadMailUI.this.pzt.mo55347a(true, ReadMailUI.this.ext);
                switch (i) {
                    case 0:
                        intent.putExtra("composeType", 2);
                        intent.putExtra("toList", a);
                        break;
                    case 1:
                        int i3;
                        intent.putExtra("composeType", 2);
                        String[] strArr = new String[(a.length + a2.length)];
                        int length = a.length;
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < length) {
                            i3 = i5 + 1;
                            strArr[i5] = a[i4];
                            i4++;
                            i5 = i3;
                        }
                        i3 = a2.length;
                        while (i2 < i3) {
                            i4 = i5 + 1;
                            strArr[i5] = a2[i2];
                            i2++;
                            i5 = i4;
                        }
                        intent.putExtra("toList", strArr);
                        intent.putExtra("ccList", a3);
                        break;
                    case 2:
                        intent.putExtra("composeType", 3);
                        break;
                    default:
                        AppMethodBeat.m2505o(68436);
                        return;
                }
                ReadMailUI.this.startActivity(intent);
                AppMethodBeat.m2505o(68436);
            }
        }

        C2878213() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68437);
            C30379h.m48424a(ReadMailUI.this, null, ReadMailUI.this.getResources().getStringArray(C25738R.array.f12617r), ReadMailUI.this.getResources().getString(C25738R.string.di9), false, new C36651());
            AppMethodBeat.m2505o(68437);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$1 */
    class C287841 implements Runnable {
        C287841() {
        }

        public final void run() {
            AppMethodBeat.m2504i(68419);
            ReadMailUI.m45787q(ReadMailUI.this);
            if (ReadMailUI.this.pzI == 0) {
                ReadMailUI.m45789s(ReadMailUI.this);
                if (!ReadMailUI.m45790t(ReadMailUI.this)) {
                    ReadMailUI.m45791u(ReadMailUI.this);
                }
                ReadMailUI.this.pzW = new ReadMailProxy(ReadMailUI.this.ext, null, new C21551b(), new C28778c());
                ReadMailUI.this.pzW.REMOTE_CALL("addDownloadCallback", new Object[0]);
            }
            AppMethodBeat.m2505o(68419);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$3 */
    class C287853 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ReadMailUI$3$1 */
        class C129211 implements Runnable {
            C129211() {
            }

            public final void run() {
                AppMethodBeat.m2504i(68421);
                ReadMailUI.m45796z(ReadMailUI.this);
                AppMethodBeat.m2505o(68421);
            }
        }

        C287853() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00c4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            AppMethodBeat.m2504i(68422);
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(ReadMailUI.this.pzJ).openConnection();
                try {
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.connect();
                    ReadMailUI.this.pzK = httpURLConnection2.getHeaderField("Location");
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    int headerFieldInt = httpURLConnection2.getHeaderFieldInt("Content-Length", -1);
                    if (headerFieldInt <= 0) {
                        C4990ab.m7412e("MicroMsg.ReadMailUI", "error content-length");
                        inputStream.close();
                        httpURLConnection2.disconnect();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        AppMethodBeat.m2505o(68422);
                        return;
                    }
                    byte[] bArr = new byte[headerFieldInt];
                    inputStream.read(bArr);
                    inputStream.close();
                    C4990ab.m7417i("MicroMsg.ReadMailUI", "dz[mQQMailDownloadUrl:%s]", ReadMailUI.this.pzK);
                    ReadMailUI.this.pzL = new String(C37431m.m63088a(Base64.decode(bArr, 0), C37431m.m63089r(ReadMailUI.this.getApplicationContext(), "rsa_public_key_forwx.pem")));
                    C4990ab.m7417i("MicroMsg.ReadMailUI", "dz[mQQMailMD5:%s]", ReadMailUI.this.pzL);
                    C5004al.m7441d(new C129211());
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                        AppMethodBeat.m2505o(68422);
                        return;
                    }
                    AppMethodBeat.m2505o(68422);
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.ReadMailUI", e, "", new Object[0]);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            AppMethodBeat.m2505o(68422);
                            return;
                        }
                        AppMethodBeat.m2505o(68422);
                    } catch (Throwable th) {
                        e = th;
                        if (httpURLConnection != null) {
                        }
                        AppMethodBeat.m2505o(68422);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.m2505o(68422);
                    throw e;
                }
            } catch (Exception th3) {
                e = th3;
                C4990ab.printErrStackTrace("MicroMsg.ReadMailUI", e, "", new Object[0]);
                if (httpURLConnection != null) {
                }
                AppMethodBeat.m2505o(68422);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ReadMailUI() {
        AppMethodBeat.m2504i(68448);
        AppMethodBeat.m2505o(68448);
    }

    /* renamed from: I */
    static /* synthetic */ void m45750I(ReadMailUI readMailUI) {
        AppMethodBeat.m2504i(68481);
        readMailUI.cdn();
        AppMethodBeat.m2505o(68481);
    }

    /* renamed from: c */
    static /* synthetic */ String[] m45772c(Map map, String str, int i) {
        AppMethodBeat.m2504i(68467);
        String[] b = ReadMailUI.m45769b(map, str, i);
        AppMethodBeat.m2505o(68467);
        return b;
    }

    /* renamed from: p */
    static /* synthetic */ void m45786p(ReadMailUI readMailUI) {
        AppMethodBeat.m2504i(68470);
        readMailUI.cdl();
        AppMethodBeat.m2505o(68470);
    }

    /* renamed from: t */
    static /* synthetic */ boolean m45790t(ReadMailUI readMailUI) {
        AppMethodBeat.m2504i(68473);
        boolean cdo = readMailUI.cdo();
        AppMethodBeat.m2505o(68473);
        return cdo;
    }

    /* renamed from: u */
    static /* synthetic */ void m45791u(ReadMailUI readMailUI) {
        AppMethodBeat.m2504i(68474);
        readMailUI.cdp();
        AppMethodBeat.m2505o(68474);
    }

    private void cdl() {
        AppMethodBeat.m2504i(68449);
        switch (this.pzQ) {
            case 0:
                this.pzE.setText(C25738R.string.dic);
                AppMethodBeat.m2505o(68449);
                return;
            case 1:
                this.pzE.setText(C25738R.string.dia);
                AppMethodBeat.m2505o(68449);
                return;
            case 2:
                this.pzE.setText(C25738R.string.dib);
                AppMethodBeat.m2505o(68449);
                return;
            case 3:
                String str = "";
                if (this.pzY > 99) {
                    str = "99+";
                } else if (this.pzY > 0) {
                    str = Integer.toString(this.pzY);
                }
                if (!C5046bo.isNullOrNil(str)) {
                    this.pzE.setText(String.format(C1338a.m2858an(this, C25738R.string.die), new Object[]{str}));
                    break;
                }
                this.pzE.setText(C25738R.string.did);
                AppMethodBeat.m2505o(68449);
                return;
        }
        AppMethodBeat.m2505o(68449);
    }

    public final int getLayoutId() {
        return 2130970463;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(68450);
        super.onCreate(bundle);
        this.handler = new C7306ak();
        this.cvx = getIntent().getLongExtra("msgid", -1);
        this.pzH = 0;
        this.pzI = 0;
        initView();
        this.ext.connect(new C287841());
        AppMethodBeat.m2505o(68450);
    }

    public void onPause() {
        AppMethodBeat.m2504i(68451);
        super.onPause();
        if (!(this.pzG == -1 || this.pzG == -2)) {
            try {
                new ReadMailProxy(this.ext, new C28773a(0)).REMOTE_CALL("cancel", Long.valueOf(this.pzG));
                AppMethodBeat.m2505o(68451);
                return;
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.ReadMailUI", "cancel, ex = %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(68451);
    }

    public void onStop() {
        AppMethodBeat.m2504i(68452);
        super.onStop();
        this.pzp.stopLoading();
        AppMethodBeat.m2505o(68452);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(68453);
        super.onDestroy();
        if (this.pzW != null) {
            this.pzW.REMOTE_CALL("removeDownloadCallback", new Object[0]);
        }
        this.ext.release();
        this.pzp.setVisibility(8);
        this.pzp.destroy();
        AppMethodBeat.m2505o(68453);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(68454);
        if (i2 != -1) {
            AppMethodBeat.m2505o(68454);
        } else if (i == 1) {
            C4990ab.m7410d("MicroMsg.ReadMailUI", "USER_DATA_READMAIL onAfterVerify");
            m45761a(new C28746c());
            AppMethodBeat.m2505o(68454);
        } else {
            if (i == 2) {
                C4990ab.m7410d("MicroMsg.ReadMailUI", "USER_DATA_SETUNREAD onAfterVerify");
                cdn();
            }
            AppMethodBeat.m2505o(68454);
        }
    }

    private static JsapiPermissionWrapper cdm() {
        AppMethodBeat.m2504i(68455);
        byte[] bArr = new byte[112];
        bArr[25] = (byte) 1;
        bArr[16] = (byte) 1;
        bArr[57] = (byte) 1;
        bArr[63] = (byte) 1;
        bArr[61] = (byte) 1;
        bArr[70] = (byte) 1;
        bArr[68] = (byte) 1;
        bArr[82] = (byte) 1;
        bArr[111] = (byte) 1;
        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(bArr);
        AppMethodBeat.m2505o(68455);
        return jsapiPermissionWrapper;
    }

    public final void initView() {
        AppMethodBeat.m2504i(68456);
        this.pzs = (MailAddrsViewControl) findViewById(2131826848);
        this.pzu = (MailAddrsViewControl) findViewById(2131826851);
        this.pzt = (MailAddrsViewControl) findViewById(2131826853);
        this.pzv = (TextView) findViewById(2131826849);
        this.pzw = findViewById(2131826850);
        this.pzx = (LinearLayout) findViewById(2131826852);
        this.pzy = (TextView) findViewById(2131826854);
        this.timeTv = (TextView) findViewById(2131826855);
        this.pzz = (TextView) findViewById(2131826856);
        this.pzA = (LinearLayout) findViewById(2131826857);
        this.pzB = (MailAttachListLinearLayout) findViewById(2131826859);
        this.gtQ = (ProgressBar) findViewById(2131826866);
        this.pzq = (ImageView) findViewById(2131826867);
        this.pzr = (TextView) findViewById(2131826860);
        this.pzp = C23154a.uJj.mo30688du(this);
        ((FrameLayout) findViewById(2131826861)).addView(this.pzp);
        this.pzF = findViewById(2131826847);
        this.pzC = findViewById(2131826862);
        this.pzE = (TextView) findViewById(2131826865);
        this.pzD = (TextView) findViewById(2131826863);
        this.pzC.setOnClickListener(new C129237());
        this.pzv.setOnClickListener(new C287728());
        setBackBtn(new C287809());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        pzU = ((float) displayMetrics.widthPixels) / displayMetrics.scaledDensity;
        pzV = displayMetrics.heightPixels;
        this.pzp.getSettings().setDefaultTextEncodingName(ProtocolPackage.ServerEncoding);
        this.pzp.getSettings().setSupportZoom(false);
        this.pzp.getSettings().setBuiltInZoomControls(false);
        this.pzp.getSettings().dUa();
        this.pzp.getSettings().setLoadsImagesAutomatically(false);
        this.pzp.getSettings().setUseWideViewPort(true);
        this.pzp.dKH();
        ((C29960h) this.pzp).setEmbeddedTitleBarCompat(this.pzF);
        ((C29960h) this.pzp).setEmbeddedBottomBar(this.pzC);
        Intent intent = this.mController.ylL.getIntent();
        intent.putExtra("hardcode_jspermission", ReadMailUI.cdm());
        this.mController.ylL.setIntent(intent);
        this.pzp.setWebViewClient(C40348a.uJh.mo30693a(this.pzp, true, new C2154610()));
        if (pzS.equals("")) {
            try {
                pzS += C5046bo.convertStreamToString(getAssets().open("mail/lib.js"));
                pzT += C5046bo.convertStreamToString(getAssets().open("mail/readmail.js"));
                pzR += "mail_css.innerHTML='" + C5046bo.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.ReadMailUI", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.ReadMailUI", "evaluateJavascript error " + e.getMessage());
            }
        }
        registerForContextMenu(this.pzp);
        new C46696j(this).mo75005a(this.pzp, this, null);
        AppMethodBeat.m2505o(68456);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(68457);
        if (view instanceof com.tencent.xweb.WebView) {
            final C41116b hitTestResult = ((com.tencent.xweb.WebView) view).getHitTestResult();
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                boolean booleanValue;
                try {
                    booleanValue = ((Boolean) new ReadMailProxy(this.ext, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", e.getMessage());
                    booleanValue = false;
                }
                if (booleanValue) {
                    contextMenu.setHeaderTitle(C25738R.string.g2h);
                    contextMenu.add(0, 0, 0, getString(C25738R.string.dwz)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            boolean booleanValue;
                            AppMethodBeat.m2504i(68438);
                            String str = hitTestResult.mExtra;
                            if (str.contains("qqmail.weixin.qq.com") && !str.contains("qqmail.weixin.qq.com:443")) {
                                str = str.replace("qqmail.weixin.qq.com", "qqmail.weixin.qq.com:443");
                            }
                            String replaceFirst = str.replaceFirst("%p2p0", "%25p2p0");
                            try {
                                booleanValue = ((Boolean) new ReadMailProxy(ReadMailUI.this.ext, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
                            } catch (Exception e) {
                                C4990ab.m7421w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", e.getMessage());
                                booleanValue = false;
                            }
                            C30152u.m47740a(ReadMailUI.this, replaceFirst, C44576b.dTR().getCookie(C39540v.ccw()), booleanValue);
                            AppMethodBeat.m2505o(68438);
                            return true;
                        }
                    });
                } else {
                    AppMethodBeat.m2505o(68457);
                    return;
                }
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AppMethodBeat.m2505o(68457);
    }

    /* renamed from: b */
    private static String[] m45769b(Map<String, String> map, String str, int i) {
        AppMethodBeat.m2504i(68458);
        if (map.get(str) == null) {
            AppMethodBeat.m2505o(68458);
            return null;
        }
        String[] strArr = new String[i];
        int i2 = 0;
        while (i2 < i) {
            String str2 = str + ".item" + (i2 > 0 ? Integer.valueOf(i2) : "");
            strArr[i2] = ((String) map.get(str2 + ".name")) + " " + ((String) map.get(str2 + ".addr"));
            i2++;
        }
        AppMethodBeat.m2505o(68458);
        return strArr;
    }

    /* renamed from: a */
    private void m45761a(C28746c c28746c) {
        AppMethodBeat.m2504i(68459);
        if (this.ptI == null || this.ptI.length() == 0) {
            C4990ab.m7412e("MicroMsg.ReadMailUI", "doReadMail invalid argument");
            AppMethodBeat.m2505o(68459);
            return;
        }
        this.pzq.setVisibility(8);
        this.gtQ.setVisibility(0);
        HashMap hashMap = new HashMap();
        hashMap.put("mailid", this.ptI);
        hashMap.put("texttype", "html");
        if (!(this.pzG == -1 || this.pzG == -2)) {
            try {
                new ReadMailProxy(this.ext, new C28773a(0)).REMOTE_CALL("cancel", Long.valueOf(this.pzG));
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.ReadMailUI", "cancel, ex = %s", e.getMessage());
            }
        }
        this.pzo = this.ptI;
        c28746c.toBundle(new Bundle());
        try {
            this.pzG = ((Long) new ReadMailProxy(this.ext, new C28773a(1)).REMOTE_CALL("get", "/cgi-bin/readmail", hashMap, new Bundle())).longValue();
            AppMethodBeat.m2505o(68459);
        } catch (Exception e2) {
            C4990ab.m7421w("MicroMsg.ReadMailUI", "doReadMail get fail, ex = %s", e2.getMessage());
            AppMethodBeat.m2505o(68459);
        }
    }

    private void cdn() {
        AppMethodBeat.m2504i(68460);
        if (this.ptI == null || this.ptI.length() == 0) {
            C4990ab.m7412e("MicroMsg.ReadMailUI", "doSetUnread invalid argument");
            AppMethodBeat.m2505o(68460);
            return;
        }
        new HashMap().put("mailid", this.ptI);
        C28746c c28746c = new C28746c();
        c28746c.puP = false;
        c28746c.toBundle(new Bundle());
        try {
            new ReadMailProxy(this.ext, new C28773a(2)).REMOTE_CALL("get", "/cgi-bin/setmailunread", new HashMap(), new Bundle());
            AppMethodBeat.m2505o(68460);
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.ReadMailUI", "doSetUnread, ex = %s", e.getMessage());
            AppMethodBeat.m2505o(68460);
        }
    }

    private boolean cdo() {
        AppMethodBeat.m2504i(68461);
        this.pzJ = (String) new ReadMailProxy(this.ext, null).REMOTE_CALL("getMailAppRedirectUrlAndroid", new Object[0]);
        this.pzX = (String) new ReadMailProxy(this.ext, null).REMOTE_CALL("getMailAppEnterUlAndroid", new Object[0]);
        try {
            this.pzY = ((Integer) new ReadMailProxy(this.ext, null).REMOTE_CALL("getUneradMailCountFromConfig", new Object[0])).intValue();
        } catch (NullPointerException e) {
            this.pzY = -1;
            C4990ab.printErrStackTrace("MicroMsg.ReadMailUI", e, "getUneradMailCountFromConfig got an NullPointerException", new Object[0]);
        }
        new ReadMailProxy(this.ext, null).REMOTE_CALL("getUnreadMailCount", new Object[0]);
        Integer num = (Integer) new ReadMailProxy(this.ext, null).REMOTE_CALL("showMailAppRecommend", new Object[0]);
        if (num == null) {
            C4990ab.m7412e("MicroMsg.ReadMailUI", "Remote server Proxy not ready");
            AppMethodBeat.m2505o(68461);
            return true;
        }
        this.pzI = 1;
        this.pzH = num.intValue();
        if (C5046bo.isNullOrNil(this.pzX)) {
            AppMethodBeat.m2505o(68461);
            return true;
        } else if (C35799p.m58695u(this, "com.tencent.androidqqmail")) {
            this.pzQ = 3;
            cdl();
            AppMethodBeat.m2505o(68461);
            return true;
        } else {
            this.ehZ = C4996ah.getContext().getSharedPreferences("QQMAIL", C1448h.m3078Mu());
            if (this.ehZ == null) {
                AppMethodBeat.m2505o(68461);
                return true;
            }
            this.hxO = this.ehZ.getLong("qqmail_downloadid", -1);
            this.pzM = ((Integer) new ReadMailProxy(this.ext, null).REMOTE_CALL("getMailAppDownloadStatus", Long.valueOf(this.hxO))).intValue();
            this.pzN = this.ehZ.getString("qqmail_downloadpath", "");
            if (this.pzM == 3 && C5730e.m8628ct(this.pzN)) {
                this.pzQ = 2;
                cdl();
                if (this.pzO != null) {
                    this.pzO.stopTimer();
                }
                AppMethodBeat.m2505o(68461);
                return true;
            } else if (this.pzH != 1) {
                this.pzC.setVisibility(8);
                C4990ab.m7413e("MicroMsg.ReadMailUI", "promote qq mail error:MailAppRecomend = %d", Integer.valueOf(this.pzH));
                AppMethodBeat.m2505o(68461);
                return true;
            } else {
                AppMethodBeat.m2505o(68461);
                return false;
            }
        }
    }

    /* JADX WARNING: Missing block: B:8:0x004a, code skipped:
            if (com.tencent.p177mm.vfs.C5730e.m8628ct(r7.pzN) == false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cdp() {
        AppMethodBeat.m2504i(68462);
        if (C5046bo.isNullOrNil(this.pzJ)) {
            C4990ab.m7412e("MicroMsg.ReadMailUI", "mQQMailRedirectUrl = null");
            AppMethodBeat.m2505o(68462);
            return;
        }
        m45743Bw(0);
        C4990ab.m7417i("MicroMsg.ReadMailUI", "status:%d", Integer.valueOf(this.pzM));
        switch (this.pzM) {
            case 1:
            case 2:
                this.pzQ = 1;
                cdq();
                cdl();
                AppMethodBeat.m2505o(68462);
                return;
            case 3:
                break;
            default:
                this.pzQ = 0;
                m45743Bw(0);
                cdl();
                break;
        }
        AppMethodBeat.m2505o(68462);
    }

    /* renamed from: Bw */
    private void m45743Bw(int i) {
        AppMethodBeat.m2504i(68463);
        LayoutParams layoutParams = (LayoutParams) this.pzD.getLayoutParams();
        layoutParams.width = i;
        this.pzD.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(68463);
    }

    private void cdq() {
        AppMethodBeat.m2504i(68464);
        this.pzO = new C7564ap(Looper.getMainLooper(), new C129224(), true);
        this.pzO.mo16770ae(500, 500);
        AppMethodBeat.m2505o(68464);
    }

    /* renamed from: fb */
    private void m45776fb(int i, int i2) {
        AppMethodBeat.m2504i(68465);
        new ReadMailProxy(this.ext, null).REMOTE_CALL("reportKvState", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(68465);
    }

    public void onResume() {
        AppMethodBeat.m2504i(68466);
        if (this.pzH == 1 && !cdo()) {
            cdp();
        }
        super.onResume();
        AppMethodBeat.m2505o(68466);
    }

    /* renamed from: q */
    static /* synthetic */ void m45787q(ReadMailUI readMailUI) {
        AppMethodBeat.m2504i(68471);
        readMailUI.pzz.setOnClickListener(new C2876911());
        readMailUI.pzq.setOnClickListener(new C2878112());
        readMailUI.addIconOptionMenu(0, C25738R.drawable.f6899uu, new C2878213());
        if (readMailUI.pzG != -2) {
            String str;
            if (!(readMailUI.pzG == -1 || readMailUI.pzG == -2)) {
                try {
                    new ReadMailProxy(readMailUI.ext, new C28773a(0)).REMOTE_CALL("cancel", Long.valueOf(readMailUI.pzG));
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.ReadMailUI", "render cancel, ex = %s", e.getMessage());
                }
            }
            try {
                str = (String) new ReadMailProxy(readMailUI.ext, null).REMOTE_CALL("getMsgContent", Long.valueOf(readMailUI.cvx));
            } catch (Exception e2) {
                C4990ab.m7421w("MicroMsg.ReadMailUI", "render, getMsgContent, ex = %s", e2.getMessage());
                str = null;
            }
            Map z = C5049br.m7595z(str, "msg");
            if (z == null) {
                C4990ab.m7412e("MicroMsg.ReadMailUI", "render fail, maps is null");
                AppMethodBeat.m2505o(68471);
                return;
            }
            readMailUI.setMMTitle("");
            readMailUI.ptI = (String) z.get(".msg.pushmail.mailid");
            readMailUI.ptN = (String) z.get(".msg.pushmail.content.subject");
            readMailUI.pzs.mo55348b(new String[]{((String) z.get(".msg.pushmail.content.fromlist.item.name")) + " " + ((String) z.get(".msg.pushmail.content.fromlist.item.addr"))}, true);
            readMailUI.pzu.mo55348b(ReadMailUI.m45769b(z, ".msg.pushmail.content.tolist", C5046bo.getInt((String) z.get(".msg.pushmail.content.tolist.$count"), 0)), true);
            String[] b = ReadMailUI.m45769b(z, ".msg.pushmail.content.cclist", C5046bo.getInt((String) z.get(".msg.pushmail.content.cclist.$count"), 0));
            LinearLayout linearLayout = readMailUI.pzx;
            int i = (b == null || b.length == 0) ? 8 : 0;
            linearLayout.setVisibility(i);
            readMailUI.pzt.mo55348b(b, true);
            readMailUI.pzy.setText(readMailUI.ptN);
            readMailUI.timeTv.setText((CharSequence) z.get(".msg.pushmail.content.date"));
            readMailUI.pzz.setEnabled(true);
            readMailUI.m45761a(new C28746c());
        }
        AppMethodBeat.m2505o(68471);
    }

    /* renamed from: s */
    static /* synthetic */ void m45789s(ReadMailUI readMailUI) {
        AppMethodBeat.m2504i(68472);
        readMailUI.ehZ = C4996ah.getContext().getSharedPreferences("QQMAIL", C1448h.m3078Mu());
        if (readMailUI.ehZ != null) {
            long j = readMailUI.ehZ.getLong("qqmail_info_report_time", -1);
            long currentTimeMillis = System.currentTimeMillis();
            if (j < 0 || currentTimeMillis - j > 86400000) {
                if (C35799p.m58695u(readMailUI, "com.tencent.androidqqmail")) {
                    int i = C19679b.getPackageInfo(readMailUI, "com.tencent.androidqqmail").versionCode;
                    C4990ab.m7411d("MicroMsg.ReadMailUI", "is intalled:%d, version:%d", Integer.valueOf(1), Integer.valueOf(i));
                    new ReadMailProxy(readMailUI.ext, null).REMOTE_CALL("reportKvStates", Integer.valueOf(11389), Integer.valueOf(1), Integer.valueOf(i));
                } else {
                    C4990ab.m7411d("MicroMsg.ReadMailUI", "is intalled:%d", Integer.valueOf(0));
                    readMailUI.m45776fb(11389, 0);
                }
                readMailUI.ehZ.edit().putLong("qqmail_info_report_time", currentTimeMillis).commit();
            }
        }
        AppMethodBeat.m2505o(68472);
    }

    /* renamed from: z */
    static /* synthetic */ void m45796z(ReadMailUI readMailUI) {
        AppMethodBeat.m2504i(68476);
        readMailUI.hxO = ((Long) new ReadMailProxy(readMailUI.ext, null).REMOTE_CALL("downloadQQMailApp", readMailUI.pzK, readMailUI.pzL)).longValue();
        if (readMailUI.hxO <= 0) {
            C4990ab.m7413e("MicroMsg.ReadMailUI", "doAddDownloadTask fail, downloadId = %d ", Long.valueOf(readMailUI.hxO));
            AppMethodBeat.m2505o(68476);
            return;
        }
        readMailUI.ehZ = C4996ah.getContext().getSharedPreferences("QQMAIL", C1448h.m3078Mu());
        if (readMailUI.ehZ != null) {
            readMailUI.ehZ.edit().putLong("qqmail_downloadid", readMailUI.hxO).commit();
        }
        readMailUI.pzQ = 1;
        readMailUI.pzM = ((Integer) new ReadMailProxy(readMailUI.ext, null).REMOTE_CALL("getMailAppDownloadStatus", Long.valueOf(readMailUI.hxO))).intValue();
        readMailUI.pzC.setVisibility(0);
        readMailUI.cdq();
        readMailUI.cdl();
        AppMethodBeat.m2505o(68476);
    }

    /* renamed from: A */
    static /* synthetic */ void m45741A(ReadMailUI readMailUI) {
        AppMethodBeat.m2504i(68477);
        C7305d.post(new C287853(), "initQQMailDownloadUrlAndMD5");
        AppMethodBeat.m2505o(68477);
    }

    /* renamed from: E */
    static /* synthetic */ void m45746E(ReadMailUI readMailUI) {
        AppMethodBeat.m2504i(68479);
        readMailUI.ehZ = C4996ah.getContext().getSharedPreferences("QQMAIL", C1448h.m3078Mu());
        if (readMailUI.ehZ != null) {
            C5046bo.m7571k(readMailUI.ehZ.getString("qqmail_downloadpath", ""), (Context) readMailUI);
        }
        AppMethodBeat.m2505o(68479);
    }

    /* renamed from: F */
    static /* synthetic */ void m45747F(ReadMailUI readMailUI) {
        AppMethodBeat.m2504i(68480);
        final Intent intent = new Intent();
        if (C5046bo.isNullOrNil(readMailUI.pzX)) {
            C4990ab.m7420w("MicroMsg.ReadMailUI", "mQQMailSchemeForUnread is null");
            readMailUI.startActivity(readMailUI.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"));
            AppMethodBeat.m2505o(68480);
            return;
        }
        C4990ab.m7411d("MicroMsg.ReadMailUI", "qq mail scheme:%s", readMailUI.pzX.replace("$uin$", (String) new ReadMailProxy(readMailUI.ext, new C28773a(1)).REMOTE_CALL("getBindUin", new Object[0])));
        intent.setData(Uri.parse(r0));
        intent.addFlags(268435456);
        if (VERSION.SDK_INT >= 11) {
            intent.addFlags(32768);
        }
        if (C5046bo.m7572k((Context) readMailUI, intent)) {
            C26006a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(68424);
                    C46494g.m87724a(ReadMailUI.this, intent, ReadMailUI.this.getString(C25738R.string.ajk), null);
                    AppMethodBeat.m2505o(68424);
                }
            });
            AppMethodBeat.m2505o(68480);
            return;
        }
        C4990ab.m7420w("MicroMsg.ReadMailUI", "schema failed");
        C26006a.post(new C287716());
        AppMethodBeat.m2505o(68480);
    }

    /* renamed from: J */
    static /* synthetic */ void m45751J(ReadMailUI readMailUI) {
        AppMethodBeat.m2504i(68483);
        try {
            new ReadMailProxy(readMailUI.ext, null).REMOTE_CALL("deleteMsgById", Long.valueOf(readMailUI.cvx));
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.ReadMailUI", "doDelete fail, ex = %s", e.getMessage());
        }
        readMailUI.finish();
        AppMethodBeat.m2505o(68483);
    }
}
