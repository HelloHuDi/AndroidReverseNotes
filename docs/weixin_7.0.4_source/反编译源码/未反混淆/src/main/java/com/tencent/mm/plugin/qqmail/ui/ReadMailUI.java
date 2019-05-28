package com.tencent.mm.plugin.qqmail.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.a.m;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.webview.ui.tools.widget.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ReadMailUI extends MMActivity implements OnCreateContextMenuListener {
    private static String pzR = "var mail_css = document.createElement(\"style\");";
    private static String pzS = "";
    private static String pzT = "";
    private static float pzU;
    private static int pzV;
    private long cvx = -1;
    private SharedPreferences ehZ;
    private d ext = new d(this);
    private ProgressBar gtQ;
    private ak handler;
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
    private ap pzO;
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

    public class b {
    }

    class a extends com.tencent.mm.plugin.qqmail.b.v.a {
        int pAh;

        public a(int i) {
            this.pAh = i;
        }

        public final void onSuccess(String str, final Map<String, String> map) {
            AppMethodBeat.i(68444);
            ab.d("MicroMsg.ReadMailUI", "onSuccess userData = %d", Integer.valueOf(this.pAh));
            switch (this.pAh) {
                case 1:
                    ReadMailUI.a(ReadMailUI.this, new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(68439);
                            if (ReadMailUI.this.pzo.equals(ReadMailUI.this.ptI)) {
                                if (ReadMailUI.this.pzu.getSize() == 0) {
                                    ReadMailUI.this.pzu.b(ReadMailUI.c(map, ".Response.result.tolist", bo.getInt((String) map.get(".Response.result.tolistlen"), 0)), true);
                                }
                                if (ReadMailUI.this.pzt.getSize() == 0) {
                                    String[] c = ReadMailUI.c(map, ".Response.result.cclist", bo.getInt((String) map.get(".Response.result.cclistlen"), 0));
                                    LinearLayout e = ReadMailUI.this.pzx;
                                    int i = (c == null || c.length == 0) ? 8 : 0;
                                    e.setVisibility(i);
                                    ReadMailUI.this.pzt.b(c, true);
                                }
                                String str = (String) map.get(".Response.result.content");
                                ReadMailUI.a(ReadMailUI.this, map);
                                String str2 = (String) map.get(".Response.result.tips.wording");
                                if (!bo.isNullOrNil(str2)) {
                                    if ("1".equals((String) map.get(".Response.result.tips.color"))) {
                                        ReadMailUI.this.pzr.setBackgroundColor(-13627);
                                        ReadMailUI.this.pzr.setTextColor(-7515315);
                                    }
                                    ReadMailUI.this.pzr.setText(str2);
                                    ((View) ReadMailUI.this.pzr.getParent()).setVisibility(0);
                                }
                                ReadMailUI.this.pzp.loadDataWithBaseURL(v.ccw() + "?pageWidth=" + ReadMailUI.pzU, "<html style=\"margin-top:" + ReadMailUI.pzV + "px\">" + str + "</html>", "text/html", ProtocolPackage.ServerEncoding, null);
                            }
                            AppMethodBeat.o(68439);
                        }
                    });
                    AppMethodBeat.o(68444);
                    return;
                case 2:
                    ReadMailUI.this.handler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(68440);
                            ReadMailUI.this.pzz.setEnabled(false);
                            ReadMailUI.this.pzz.setText(R.string.dij);
                            ReadMailUI.this.pzz.setTextColor(-7829368);
                            ReadMailUI.this.pzz.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bz.a.g(ReadMailUI.this, R.drawable.anr), null, null, null);
                            AppMethodBeat.o(68440);
                        }
                    });
                    break;
            }
            ab.e("MicroMsg.ReadMailUI", "onSuccess, invalid userData = %d", Integer.valueOf(this.pAh));
            AppMethodBeat.o(68444);
        }

        public final void onError(final int i, final String str) {
            AppMethodBeat.i(68445);
            ab.d("MicroMsg.ReadMailUI", "onError errCode = %d, userData = %d", Integer.valueOf(i), Integer.valueOf(this.pAh));
            ReadMailUI.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(68441);
                    if (ReadMailUI.this.isFinishing()) {
                        AppMethodBeat.o(68441);
                        return;
                    }
                    Intent intent;
                    switch (a.this.pAh) {
                        case 1:
                            ReadMailUI.this.pzq.setVisibility(0);
                            if (i == -5) {
                                intent = new Intent(ReadMailUI.this, QQMailStubProxyUI.class);
                                intent.addFlags(268435456);
                                ReadMailUI.this.startActivityForResult(intent, 1);
                                AppMethodBeat.o(68441);
                                return;
                            }
                            if (i == -7) {
                                ReadMailUI.this.pzq.setVisibility(8);
                                try {
                                    new ReadMailProxy(ReadMailUI.this.ext, null).REMOTE_CALL("replaceMsgContent", Long.valueOf(ReadMailUI.this.cvx), str);
                                } catch (Exception e) {
                                    ab.w("MicroMsg.ReadMailUI", "replaceMsgContent fail, ex = %s", e.getMessage());
                                }
                            }
                            if (i == -10005 && !at.isConnected(ReadMailUI.this)) {
                                Toast.makeText(ReadMailUI.this, ReadMailUI.this.getString(R.string.bx9, new Object[]{Integer.valueOf(2), Integer.valueOf(i)}), 1).show();
                            }
                            ReadMailUI.this.pzp.loadDataWithBaseURL(v.ccw(), str + "(" + i + ")", "text/html", ProtocolPackage.ServerEncoding, null);
                            AppMethodBeat.o(68441);
                            return;
                        case 2:
                            if (i == -5) {
                                intent = new Intent(ReadMailUI.this, QQMailStubProxyUI.class);
                                intent.addFlags(268435456);
                                ReadMailUI.this.startActivityForResult(intent, 2);
                                AppMethodBeat.o(68441);
                                return;
                            }
                            Toast.makeText(ReadMailUI.this, str, 1).show();
                            AppMethodBeat.o(68441);
                            return;
                        default:
                            ab.e("MicroMsg.ReadMailUI", "onError invalid userData = %d", Integer.valueOf(a.this.pAh));
                            AppMethodBeat.o(68441);
                            return;
                    }
                }
            });
            AppMethodBeat.o(68445);
        }

        public final boolean onReady() {
            AppMethodBeat.i(68446);
            ReadMailUI.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(68442);
                    ReadMailUI.a(ReadMailUI.this, new HashMap());
                    AppMethodBeat.o(68442);
                }
            });
            AppMethodBeat.o(68446);
            return true;
        }

        public final void onComplete() {
            AppMethodBeat.i(68447);
            ReadMailUI.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(68443);
                    ReadMailUI.this.gtQ.setVisibility(8);
                    ReadMailUI.this.pzG = -2;
                    AppMethodBeat.o(68443);
                }
            });
            AppMethodBeat.o(68447);
        }
    }

    public class c {
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ReadMailUI() {
        AppMethodBeat.i(68448);
        AppMethodBeat.o(68448);
    }

    static /* synthetic */ void I(ReadMailUI readMailUI) {
        AppMethodBeat.i(68481);
        readMailUI.cdn();
        AppMethodBeat.o(68481);
    }

    static /* synthetic */ String[] c(Map map, String str, int i) {
        AppMethodBeat.i(68467);
        String[] b = b(map, str, i);
        AppMethodBeat.o(68467);
        return b;
    }

    static /* synthetic */ void p(ReadMailUI readMailUI) {
        AppMethodBeat.i(68470);
        readMailUI.cdl();
        AppMethodBeat.o(68470);
    }

    static /* synthetic */ boolean t(ReadMailUI readMailUI) {
        AppMethodBeat.i(68473);
        boolean cdo = readMailUI.cdo();
        AppMethodBeat.o(68473);
        return cdo;
    }

    static /* synthetic */ void u(ReadMailUI readMailUI) {
        AppMethodBeat.i(68474);
        readMailUI.cdp();
        AppMethodBeat.o(68474);
    }

    private void cdl() {
        AppMethodBeat.i(68449);
        switch (this.pzQ) {
            case 0:
                this.pzE.setText(R.string.dic);
                AppMethodBeat.o(68449);
                return;
            case 1:
                this.pzE.setText(R.string.dia);
                AppMethodBeat.o(68449);
                return;
            case 2:
                this.pzE.setText(R.string.dib);
                AppMethodBeat.o(68449);
                return;
            case 3:
                String str = "";
                if (this.pzY > 99) {
                    str = "99+";
                } else if (this.pzY > 0) {
                    str = Integer.toString(this.pzY);
                }
                if (!bo.isNullOrNil(str)) {
                    this.pzE.setText(String.format(com.tencent.mm.bz.a.an(this, R.string.die), new Object[]{str}));
                    break;
                }
                this.pzE.setText(R.string.did);
                AppMethodBeat.o(68449);
                return;
        }
        AppMethodBeat.o(68449);
    }

    public final int getLayoutId() {
        return R.layout.an6;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68450);
        super.onCreate(bundle);
        this.handler = new ak();
        this.cvx = getIntent().getLongExtra("msgid", -1);
        this.pzH = 0;
        this.pzI = 0;
        initView();
        this.ext.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.i(68419);
                ReadMailUI.q(ReadMailUI.this);
                if (ReadMailUI.this.pzI == 0) {
                    ReadMailUI.s(ReadMailUI.this);
                    if (!ReadMailUI.t(ReadMailUI.this)) {
                        ReadMailUI.u(ReadMailUI.this);
                    }
                    ReadMailUI.this.pzW = new ReadMailProxy(ReadMailUI.this.ext, null, new b(), new c());
                    ReadMailUI.this.pzW.REMOTE_CALL("addDownloadCallback", new Object[0]);
                }
                AppMethodBeat.o(68419);
            }
        });
        AppMethodBeat.o(68450);
    }

    public void onPause() {
        AppMethodBeat.i(68451);
        super.onPause();
        if (!(this.pzG == -1 || this.pzG == -2)) {
            try {
                new ReadMailProxy(this.ext, new a(0)).REMOTE_CALL("cancel", Long.valueOf(this.pzG));
                AppMethodBeat.o(68451);
                return;
            } catch (Exception e) {
                ab.w("MicroMsg.ReadMailUI", "cancel, ex = %s", e.getMessage());
            }
        }
        AppMethodBeat.o(68451);
    }

    public void onStop() {
        AppMethodBeat.i(68452);
        super.onStop();
        this.pzp.stopLoading();
        AppMethodBeat.o(68452);
    }

    public void onDestroy() {
        AppMethodBeat.i(68453);
        super.onDestroy();
        if (this.pzW != null) {
            this.pzW.REMOTE_CALL("removeDownloadCallback", new Object[0]);
        }
        this.ext.release();
        this.pzp.setVisibility(8);
        this.pzp.destroy();
        AppMethodBeat.o(68453);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(68454);
        if (i2 != -1) {
            AppMethodBeat.o(68454);
        } else if (i == 1) {
            ab.d("MicroMsg.ReadMailUI", "USER_DATA_READMAIL onAfterVerify");
            a(new com.tencent.mm.plugin.qqmail.b.v.c());
            AppMethodBeat.o(68454);
        } else {
            if (i == 2) {
                ab.d("MicroMsg.ReadMailUI", "USER_DATA_SETUNREAD onAfterVerify");
                cdn();
            }
            AppMethodBeat.o(68454);
        }
    }

    private static JsapiPermissionWrapper cdm() {
        AppMethodBeat.i(68455);
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
        AppMethodBeat.o(68455);
        return jsapiPermissionWrapper;
    }

    public final void initView() {
        AppMethodBeat.i(68456);
        this.pzs = (MailAddrsViewControl) findViewById(R.id.dve);
        this.pzu = (MailAddrsViewControl) findViewById(R.id.dvh);
        this.pzt = (MailAddrsViewControl) findViewById(R.id.dvj);
        this.pzv = (TextView) findViewById(R.id.dvf);
        this.pzw = findViewById(R.id.dvg);
        this.pzx = (LinearLayout) findViewById(R.id.dvi);
        this.pzy = (TextView) findViewById(R.id.dvk);
        this.timeTv = (TextView) findViewById(R.id.dvl);
        this.pzz = (TextView) findViewById(R.id.dvm);
        this.pzA = (LinearLayout) findViewById(R.id.dvn);
        this.pzB = (MailAttachListLinearLayout) findViewById(R.id.dvp);
        this.gtQ = (ProgressBar) findViewById(R.id.dvw);
        this.pzq = (ImageView) findViewById(R.id.dvx);
        this.pzr = (TextView) findViewById(R.id.dvq);
        this.pzp = com.tencent.mm.plugin.webview.ui.tools.widget.g.a.uJj.du(this);
        ((FrameLayout) findViewById(R.id.dvr)).addView(this.pzp);
        this.pzF = findViewById(R.id.dvd);
        this.pzC = findViewById(R.id.dvs);
        this.pzE = (TextView) findViewById(R.id.dvv);
        this.pzD = (TextView) findViewById(R.id.dvt);
        this.pzC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68426);
                switch (ReadMailUI.this.pzQ) {
                    case 0:
                        ReadMailUI.a(ReadMailUI.this, 2);
                        if (bo.isNullOrNil(ReadMailUI.this.pzK) || bo.isNullOrNil(ReadMailUI.this.pzL)) {
                            ReadMailUI.A(ReadMailUI.this);
                            AppMethodBeat.o(68426);
                            return;
                        }
                        ReadMailUI.z(ReadMailUI.this);
                        AppMethodBeat.o(68426);
                        return;
                    case 1:
                        ReadMailUI.a(ReadMailUI.this, 1);
                        int intValue = ((Integer) new ReadMailProxy(ReadMailUI.this.ext, null).REMOTE_CALL("removeDownloadQQMailAppTask", Long.valueOf(ReadMailUI.this.hxO))).intValue();
                        if (intValue == -1) {
                            ab.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", Long.valueOf(ReadMailUI.this.hxO));
                            AppMethodBeat.o(68426);
                            return;
                        } else if (intValue <= 0) {
                            ab.e("MicroMsg.ReadMailUI", "cancel_download_task:fail downloadId = %d", Long.valueOf(ReadMailUI.this.hxO));
                            AppMethodBeat.o(68426);
                            return;
                        } else {
                            ab.i("MicroMsg.ReadMailUI", "cancel_download_task:ok downloadId = %d", Long.valueOf(ReadMailUI.this.hxO));
                            ReadMailUI.this.pzO.stopTimer();
                            ReadMailUI.b(ReadMailUI.this, 0);
                            ReadMailUI.this.pzQ = 0;
                            ReadMailUI.p(ReadMailUI.this);
                            AppMethodBeat.o(68426);
                            return;
                        }
                    case 2:
                        ReadMailUI.a(ReadMailUI.this, 3);
                        ReadMailUI.E(ReadMailUI.this);
                        AppMethodBeat.o(68426);
                        return;
                    case 3:
                        ReadMailUI.a(ReadMailUI.this, 4);
                        ReadMailUI.F(ReadMailUI.this);
                        break;
                }
                AppMethodBeat.o(68426);
            }
        });
        this.pzv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68428);
                if (ReadMailUI.this.pzw.getVisibility() == 8) {
                    ReadMailUI.this.pzv.setText(R.string.di4);
                    ReadMailUI.this.pzw.setVisibility(0);
                    ReadMailUI.this.pzw.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(68427);
                            ReadMailUI.this.pzu.cdj();
                            ReadMailUI.this.pzt.cdj();
                            AppMethodBeat.o(68427);
                        }
                    });
                    ReadMailUI.this.pzz.setVisibility(0);
                    AppMethodBeat.o(68428);
                    return;
                }
                ReadMailUI.this.pzv.setText(R.string.di5);
                ReadMailUI.this.pzw.setVisibility(8);
                ReadMailUI.this.pzz.setVisibility(8);
                AppMethodBeat.o(68428);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68429);
                ReadMailUI.this.finish();
                AppMethodBeat.o(68429);
                return true;
            }
        });
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
        ((h) this.pzp).setEmbeddedTitleBarCompat(this.pzF);
        ((h) this.pzp).setEmbeddedBottomBar(this.pzC);
        Intent intent = this.mController.ylL.getIntent();
        intent.putExtra("hardcode_jspermission", cdm());
        this.mController.ylL.setIntent(intent);
        this.pzp.setWebViewClient(com.tencent.mm.plugin.webview.ui.tools.widget.c.a.uJh.a(this.pzp, true, new e() {
            public final boolean c(int i, Bundle bundle) {
                return false;
            }

            public final boolean oZ(String str) {
                AppMethodBeat.i(68432);
                ab.d("MicroMsg.ReadMailUI", "url:%s", str);
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
                    AppMethodBeat.o(68432);
                    return false;
                } else if (((h) ReadMailUI.this.pzp).dcQ()) {
                    ((h) ReadMailUI.this.pzp).dcR();
                    AppMethodBeat.o(68432);
                    return true;
                } else if (str.startsWith("http")) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    com.tencent.mm.bp.d.b(ReadMailUI.this, "webview", ".ui.tools.WebViewUI", intent);
                } else {
                    AppMethodBeat.o(68432);
                    return false;
                }
                AppMethodBeat.o(68432);
                return true;
            }

            public final boolean aba() {
                return false;
            }

            public final void abb() {
            }

            public final void a(MMWebView mMWebView) {
                AppMethodBeat.i(68433);
                mMWebView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
                mMWebView.evaluateJavascript("javascript:" + ReadMailUI.pzR, null);
                mMWebView.evaluateJavascript("javascript:" + ReadMailUI.pzS, null);
                mMWebView.evaluateJavascript("javascript:" + ReadMailUI.pzT, null);
                if (ReadMailUI.this.ext.isConnected()) {
                    if (!ReadMailUI.t(ReadMailUI.this)) {
                        ReadMailUI.u(ReadMailUI.this);
                    }
                    ReadMailUI.this.pzW = new ReadMailProxy(ReadMailUI.this.ext, null, new b(), new c());
                    ReadMailUI.this.pzW.REMOTE_CALL("addDownloadCallback", new Object[0]);
                }
                new ak(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(68430);
                        ReadMailUI.this.pzp.getSettings().setLoadsImagesAutomatically(true);
                        ReadMailUI.this.pzp.getSettings().setSupportZoom(true);
                        ReadMailUI.this.pzp.getSettings().setBuiltInZoomControls(true);
                        ((h) ReadMailUI.this.pzp).dcS();
                        ((h) ReadMailUI.this.pzp).dcT();
                        AppMethodBeat.o(68430);
                    }
                }, 200);
                new ak(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(68431);
                        int contentHeight = (int) (((float) ReadMailUI.this.pzp.getContentHeight()) * ReadMailUI.this.pzp.getScale());
                        ab.d("MicroMsg.ReadMailUI", ReadMailUI.this.pzp.getContentHeight() + "," + ReadMailUI.this.pzp.getHeight() + "," + ReadMailUI.this.pzp.getScale());
                        if (Math.abs(contentHeight - ReadMailUI.this.pzp.getHeight()) < 10) {
                            ((h) ReadMailUI.this.pzp).oe(true);
                        }
                        AppMethodBeat.o(68431);
                    }
                }, 400);
                AppMethodBeat.o(68433);
            }
        }));
        if (pzS.equals("")) {
            try {
                pzS += bo.convertStreamToString(getAssets().open("mail/lib.js"));
                pzT += bo.convertStreamToString(getAssets().open("mail/readmail.js"));
                pzR += "mail_css.innerHTML='" + bo.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.ReadMailUI", e, "", new Object[0]);
                ab.e("MicroMsg.ReadMailUI", "evaluateJavascript error " + e.getMessage());
            }
        }
        registerForContextMenu(this.pzp);
        new j(this).a(this.pzp, this, null);
        AppMethodBeat.o(68456);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(68457);
        if (view instanceof com.tencent.xweb.WebView) {
            final com.tencent.xweb.WebView.b hitTestResult = ((com.tencent.xweb.WebView) view).getHitTestResult();
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                boolean booleanValue;
                try {
                    booleanValue = ((Boolean) new ReadMailProxy(this.ext, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
                } catch (Exception e) {
                    ab.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", e.getMessage());
                    booleanValue = false;
                }
                if (booleanValue) {
                    contextMenu.setHeaderTitle(R.string.g2h);
                    contextMenu.add(0, 0, 0, getString(R.string.dwz)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            boolean booleanValue;
                            AppMethodBeat.i(68438);
                            String str = hitTestResult.mExtra;
                            if (str.contains("qqmail.weixin.qq.com") && !str.contains("qqmail.weixin.qq.com:443")) {
                                str = str.replace("qqmail.weixin.qq.com", "qqmail.weixin.qq.com:443");
                            }
                            String replaceFirst = str.replaceFirst("%p2p0", "%25p2p0");
                            try {
                                booleanValue = ((Boolean) new ReadMailProxy(ReadMailUI.this.ext, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
                            } catch (Exception e) {
                                ab.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", e.getMessage());
                                booleanValue = false;
                            }
                            u.a(ReadMailUI.this, replaceFirst, com.tencent.xweb.b.dTR().getCookie(v.ccw()), booleanValue);
                            AppMethodBeat.o(68438);
                            return true;
                        }
                    });
                } else {
                    AppMethodBeat.o(68457);
                    return;
                }
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AppMethodBeat.o(68457);
    }

    private static String[] b(Map<String, String> map, String str, int i) {
        AppMethodBeat.i(68458);
        if (map.get(str) == null) {
            AppMethodBeat.o(68458);
            return null;
        }
        String[] strArr = new String[i];
        int i2 = 0;
        while (i2 < i) {
            String str2 = str + ".item" + (i2 > 0 ? Integer.valueOf(i2) : "");
            strArr[i2] = ((String) map.get(str2 + ".name")) + " " + ((String) map.get(str2 + ".addr"));
            i2++;
        }
        AppMethodBeat.o(68458);
        return strArr;
    }

    private void a(com.tencent.mm.plugin.qqmail.b.v.c cVar) {
        AppMethodBeat.i(68459);
        if (this.ptI == null || this.ptI.length() == 0) {
            ab.e("MicroMsg.ReadMailUI", "doReadMail invalid argument");
            AppMethodBeat.o(68459);
            return;
        }
        this.pzq.setVisibility(8);
        this.gtQ.setVisibility(0);
        HashMap hashMap = new HashMap();
        hashMap.put("mailid", this.ptI);
        hashMap.put("texttype", "html");
        if (!(this.pzG == -1 || this.pzG == -2)) {
            try {
                new ReadMailProxy(this.ext, new a(0)).REMOTE_CALL("cancel", Long.valueOf(this.pzG));
            } catch (Exception e) {
                ab.w("MicroMsg.ReadMailUI", "cancel, ex = %s", e.getMessage());
            }
        }
        this.pzo = this.ptI;
        cVar.toBundle(new Bundle());
        try {
            this.pzG = ((Long) new ReadMailProxy(this.ext, new a(1)).REMOTE_CALL("get", "/cgi-bin/readmail", hashMap, new Bundle())).longValue();
            AppMethodBeat.o(68459);
        } catch (Exception e2) {
            ab.w("MicroMsg.ReadMailUI", "doReadMail get fail, ex = %s", e2.getMessage());
            AppMethodBeat.o(68459);
        }
    }

    private void cdn() {
        AppMethodBeat.i(68460);
        if (this.ptI == null || this.ptI.length() == 0) {
            ab.e("MicroMsg.ReadMailUI", "doSetUnread invalid argument");
            AppMethodBeat.o(68460);
            return;
        }
        new HashMap().put("mailid", this.ptI);
        com.tencent.mm.plugin.qqmail.b.v.c cVar = new com.tencent.mm.plugin.qqmail.b.v.c();
        cVar.puP = false;
        cVar.toBundle(new Bundle());
        try {
            new ReadMailProxy(this.ext, new a(2)).REMOTE_CALL("get", "/cgi-bin/setmailunread", new HashMap(), new Bundle());
            AppMethodBeat.o(68460);
        } catch (Exception e) {
            ab.w("MicroMsg.ReadMailUI", "doSetUnread, ex = %s", e.getMessage());
            AppMethodBeat.o(68460);
        }
    }

    private boolean cdo() {
        AppMethodBeat.i(68461);
        this.pzJ = (String) new ReadMailProxy(this.ext, null).REMOTE_CALL("getMailAppRedirectUrlAndroid", new Object[0]);
        this.pzX = (String) new ReadMailProxy(this.ext, null).REMOTE_CALL("getMailAppEnterUlAndroid", new Object[0]);
        try {
            this.pzY = ((Integer) new ReadMailProxy(this.ext, null).REMOTE_CALL("getUneradMailCountFromConfig", new Object[0])).intValue();
        } catch (NullPointerException e) {
            this.pzY = -1;
            ab.printErrStackTrace("MicroMsg.ReadMailUI", e, "getUneradMailCountFromConfig got an NullPointerException", new Object[0]);
        }
        new ReadMailProxy(this.ext, null).REMOTE_CALL("getUnreadMailCount", new Object[0]);
        Integer num = (Integer) new ReadMailProxy(this.ext, null).REMOTE_CALL("showMailAppRecommend", new Object[0]);
        if (num == null) {
            ab.e("MicroMsg.ReadMailUI", "Remote server Proxy not ready");
            AppMethodBeat.o(68461);
            return true;
        }
        this.pzI = 1;
        this.pzH = num.intValue();
        if (bo.isNullOrNil(this.pzX)) {
            AppMethodBeat.o(68461);
            return true;
        } else if (p.u(this, "com.tencent.androidqqmail")) {
            this.pzQ = 3;
            cdl();
            AppMethodBeat.o(68461);
            return true;
        } else {
            this.ehZ = ah.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.h.Mu());
            if (this.ehZ == null) {
                AppMethodBeat.o(68461);
                return true;
            }
            this.hxO = this.ehZ.getLong("qqmail_downloadid", -1);
            this.pzM = ((Integer) new ReadMailProxy(this.ext, null).REMOTE_CALL("getMailAppDownloadStatus", Long.valueOf(this.hxO))).intValue();
            this.pzN = this.ehZ.getString("qqmail_downloadpath", "");
            if (this.pzM == 3 && com.tencent.mm.vfs.e.ct(this.pzN)) {
                this.pzQ = 2;
                cdl();
                if (this.pzO != null) {
                    this.pzO.stopTimer();
                }
                AppMethodBeat.o(68461);
                return true;
            } else if (this.pzH != 1) {
                this.pzC.setVisibility(8);
                ab.e("MicroMsg.ReadMailUI", "promote qq mail error:MailAppRecomend = %d", Integer.valueOf(this.pzH));
                AppMethodBeat.o(68461);
                return true;
            } else {
                AppMethodBeat.o(68461);
                return false;
            }
        }
    }

    /* JADX WARNING: Missing block: B:8:0x004a, code skipped:
            if (com.tencent.mm.vfs.e.ct(r7.pzN) == false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cdp() {
        AppMethodBeat.i(68462);
        if (bo.isNullOrNil(this.pzJ)) {
            ab.e("MicroMsg.ReadMailUI", "mQQMailRedirectUrl = null");
            AppMethodBeat.o(68462);
            return;
        }
        Bw(0);
        ab.i("MicroMsg.ReadMailUI", "status:%d", Integer.valueOf(this.pzM));
        switch (this.pzM) {
            case 1:
            case 2:
                this.pzQ = 1;
                cdq();
                cdl();
                AppMethodBeat.o(68462);
                return;
            case 3:
                break;
            default:
                this.pzQ = 0;
                Bw(0);
                cdl();
                break;
        }
        AppMethodBeat.o(68462);
    }

    private void Bw(int i) {
        AppMethodBeat.i(68463);
        LayoutParams layoutParams = (LayoutParams) this.pzD.getLayoutParams();
        layoutParams.width = i;
        this.pzD.setLayoutParams(layoutParams);
        AppMethodBeat.o(68463);
    }

    private void cdq() {
        AppMethodBeat.i(68464);
        this.pzO = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(68423);
                if (ReadMailUI.this.ext.isConnected()) {
                    double doubleValue = ((Double) new ReadMailProxy(ReadMailUI.this.ext, null).REMOTE_CALL("getMailAppDownloadProgress", Long.valueOf(ReadMailUI.this.hxO))).doubleValue();
                    if (doubleValue == 1.0d) {
                        ReadMailUI.t(ReadMailUI.this);
                        AppMethodBeat.o(68423);
                        return false;
                    }
                    int i;
                    if (ReadMailUI.this.pzP == 0) {
                        ReadMailUI.this.pzP = ReadMailUI.this.pzC.getWidth();
                        i = 0;
                    } else {
                        i = (int) (((double) ReadMailUI.this.pzP) * doubleValue);
                    }
                    ReadMailUI.b(ReadMailUI.this, i);
                    AppMethodBeat.o(68423);
                    return true;
                }
                AppMethodBeat.o(68423);
                return false;
            }
        }, true);
        this.pzO.ae(500, 500);
        AppMethodBeat.o(68464);
    }

    private void fb(int i, int i2) {
        AppMethodBeat.i(68465);
        new ReadMailProxy(this.ext, null).REMOTE_CALL("reportKvState", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(68465);
    }

    public void onResume() {
        AppMethodBeat.i(68466);
        if (this.pzH == 1 && !cdo()) {
            cdp();
        }
        super.onResume();
        AppMethodBeat.o(68466);
    }

    static /* synthetic */ void q(ReadMailUI readMailUI) {
        AppMethodBeat.i(68471);
        readMailUI.pzz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68434);
                ReadMailUI.I(ReadMailUI.this);
                AppMethodBeat.o(68434);
            }
        });
        readMailUI.pzq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68435);
                ReadMailUI.this.pzq.setVisibility(8);
                ReadMailUI.a(ReadMailUI.this, new com.tencent.mm.plugin.qqmail.b.v.c());
                AppMethodBeat.o(68435);
            }
        });
        readMailUI.addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68437);
                com.tencent.mm.ui.base.h.a(ReadMailUI.this, null, ReadMailUI.this.getResources().getStringArray(R.array.r), ReadMailUI.this.getResources().getString(R.string.di9), false, new com.tencent.mm.ui.base.h.c() {
                    public final void iE(int i) {
                        int i2 = 0;
                        AppMethodBeat.i(68436);
                        if (i == 3) {
                            ReadMailUI.J(ReadMailUI.this);
                            AppMethodBeat.o(68436);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setClass(ReadMailUI.this, ComposeUI.class);
                        intent.putExtra("mailid", ReadMailUI.this.ptI);
                        intent.putExtra("subject", ReadMailUI.this.ptN);
                        String[] a = ReadMailUI.this.pzs.a(false, ReadMailUI.this.ext);
                        String[] a2 = ReadMailUI.this.pzu.a(true, ReadMailUI.this.ext);
                        String[] a3 = ReadMailUI.this.pzt.a(true, ReadMailUI.this.ext);
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
                                AppMethodBeat.o(68436);
                                return;
                        }
                        ReadMailUI.this.startActivity(intent);
                        AppMethodBeat.o(68436);
                    }
                });
                AppMethodBeat.o(68437);
                return false;
            }
        });
        if (readMailUI.pzG != -2) {
            String str;
            if (!(readMailUI.pzG == -1 || readMailUI.pzG == -2)) {
                try {
                    new ReadMailProxy(readMailUI.ext, new a(0)).REMOTE_CALL("cancel", Long.valueOf(readMailUI.pzG));
                } catch (Exception e) {
                    ab.w("MicroMsg.ReadMailUI", "render cancel, ex = %s", e.getMessage());
                }
            }
            try {
                str = (String) new ReadMailProxy(readMailUI.ext, null).REMOTE_CALL("getMsgContent", Long.valueOf(readMailUI.cvx));
            } catch (Exception e2) {
                ab.w("MicroMsg.ReadMailUI", "render, getMsgContent, ex = %s", e2.getMessage());
                str = null;
            }
            Map z = br.z(str, "msg");
            if (z == null) {
                ab.e("MicroMsg.ReadMailUI", "render fail, maps is null");
                AppMethodBeat.o(68471);
                return;
            }
            readMailUI.setMMTitle("");
            readMailUI.ptI = (String) z.get(".msg.pushmail.mailid");
            readMailUI.ptN = (String) z.get(".msg.pushmail.content.subject");
            readMailUI.pzs.b(new String[]{((String) z.get(".msg.pushmail.content.fromlist.item.name")) + " " + ((String) z.get(".msg.pushmail.content.fromlist.item.addr"))}, true);
            readMailUI.pzu.b(b(z, ".msg.pushmail.content.tolist", bo.getInt((String) z.get(".msg.pushmail.content.tolist.$count"), 0)), true);
            String[] b = b(z, ".msg.pushmail.content.cclist", bo.getInt((String) z.get(".msg.pushmail.content.cclist.$count"), 0));
            LinearLayout linearLayout = readMailUI.pzx;
            int i = (b == null || b.length == 0) ? 8 : 0;
            linearLayout.setVisibility(i);
            readMailUI.pzt.b(b, true);
            readMailUI.pzy.setText(readMailUI.ptN);
            readMailUI.timeTv.setText((CharSequence) z.get(".msg.pushmail.content.date"));
            readMailUI.pzz.setEnabled(true);
            readMailUI.a(new com.tencent.mm.plugin.qqmail.b.v.c());
        }
        AppMethodBeat.o(68471);
    }

    static /* synthetic */ void s(ReadMailUI readMailUI) {
        AppMethodBeat.i(68472);
        readMailUI.ehZ = ah.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.h.Mu());
        if (readMailUI.ehZ != null) {
            long j = readMailUI.ehZ.getLong("qqmail_info_report_time", -1);
            long currentTimeMillis = System.currentTimeMillis();
            if (j < 0 || currentTimeMillis - j > 86400000) {
                if (p.u(readMailUI, "com.tencent.androidqqmail")) {
                    int i = com.tencent.mm.plugin.appbrand.r.b.getPackageInfo(readMailUI, "com.tencent.androidqqmail").versionCode;
                    ab.d("MicroMsg.ReadMailUI", "is intalled:%d, version:%d", Integer.valueOf(1), Integer.valueOf(i));
                    new ReadMailProxy(readMailUI.ext, null).REMOTE_CALL("reportKvStates", Integer.valueOf(11389), Integer.valueOf(1), Integer.valueOf(i));
                } else {
                    ab.d("MicroMsg.ReadMailUI", "is intalled:%d", Integer.valueOf(0));
                    readMailUI.fb(11389, 0);
                }
                readMailUI.ehZ.edit().putLong("qqmail_info_report_time", currentTimeMillis).commit();
            }
        }
        AppMethodBeat.o(68472);
    }

    static /* synthetic */ void z(ReadMailUI readMailUI) {
        AppMethodBeat.i(68476);
        readMailUI.hxO = ((Long) new ReadMailProxy(readMailUI.ext, null).REMOTE_CALL("downloadQQMailApp", readMailUI.pzK, readMailUI.pzL)).longValue();
        if (readMailUI.hxO <= 0) {
            ab.e("MicroMsg.ReadMailUI", "doAddDownloadTask fail, downloadId = %d ", Long.valueOf(readMailUI.hxO));
            AppMethodBeat.o(68476);
            return;
        }
        readMailUI.ehZ = ah.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.h.Mu());
        if (readMailUI.ehZ != null) {
            readMailUI.ehZ.edit().putLong("qqmail_downloadid", readMailUI.hxO).commit();
        }
        readMailUI.pzQ = 1;
        readMailUI.pzM = ((Integer) new ReadMailProxy(readMailUI.ext, null).REMOTE_CALL("getMailAppDownloadStatus", Long.valueOf(readMailUI.hxO))).intValue();
        readMailUI.pzC.setVisibility(0);
        readMailUI.cdq();
        readMailUI.cdl();
        AppMethodBeat.o(68476);
    }

    static /* synthetic */ void A(ReadMailUI readMailUI) {
        AppMethodBeat.i(68477);
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:24:0x00cf  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x00c4  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                Throwable e;
                AppMethodBeat.i(68422);
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
                            ab.e("MicroMsg.ReadMailUI", "error content-length");
                            inputStream.close();
                            httpURLConnection2.disconnect();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            AppMethodBeat.o(68422);
                            return;
                        }
                        byte[] bArr = new byte[headerFieldInt];
                        inputStream.read(bArr);
                        inputStream.close();
                        ab.i("MicroMsg.ReadMailUI", "dz[mQQMailDownloadUrl:%s]", ReadMailUI.this.pzK);
                        ReadMailUI.this.pzL = new String(m.a(Base64.decode(bArr, 0), m.r(ReadMailUI.this.getApplicationContext(), "rsa_public_key_forwx.pem")));
                        ab.i("MicroMsg.ReadMailUI", "dz[mQQMailMD5:%s]", ReadMailUI.this.pzL);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(68421);
                                ReadMailUI.z(ReadMailUI.this);
                                AppMethodBeat.o(68421);
                            }
                        });
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            AppMethodBeat.o(68422);
                            return;
                        }
                        AppMethodBeat.o(68422);
                    } catch (Exception e2) {
                        e = e2;
                        httpURLConnection = httpURLConnection2;
                        try {
                            ab.printErrStackTrace("MicroMsg.ReadMailUI", e, "", new Object[0]);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                AppMethodBeat.o(68422);
                                return;
                            }
                            AppMethodBeat.o(68422);
                        } catch (Throwable th) {
                            e = th;
                            if (httpURLConnection != null) {
                            }
                            AppMethodBeat.o(68422);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        AppMethodBeat.o(68422);
                        throw e;
                    }
                } catch (Exception th3) {
                    e = th3;
                    ab.printErrStackTrace("MicroMsg.ReadMailUI", e, "", new Object[0]);
                    if (httpURLConnection != null) {
                    }
                    AppMethodBeat.o(68422);
                }
            }
        }, "initQQMailDownloadUrlAndMD5");
        AppMethodBeat.o(68477);
    }

    static /* synthetic */ void E(ReadMailUI readMailUI) {
        AppMethodBeat.i(68479);
        readMailUI.ehZ = ah.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.h.Mu());
        if (readMailUI.ehZ != null) {
            bo.k(readMailUI.ehZ.getString("qqmail_downloadpath", ""), (Context) readMailUI);
        }
        AppMethodBeat.o(68479);
    }

    static /* synthetic */ void F(ReadMailUI readMailUI) {
        AppMethodBeat.i(68480);
        final Intent intent = new Intent();
        if (bo.isNullOrNil(readMailUI.pzX)) {
            ab.w("MicroMsg.ReadMailUI", "mQQMailSchemeForUnread is null");
            readMailUI.startActivity(readMailUI.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"));
            AppMethodBeat.o(68480);
            return;
        }
        ab.d("MicroMsg.ReadMailUI", "qq mail scheme:%s", readMailUI.pzX.replace("$uin$", (String) new ReadMailProxy(readMailUI.ext, new a(1)).REMOTE_CALL("getBindUin", new Object[0])));
        intent.setData(Uri.parse(r0));
        intent.addFlags(268435456);
        if (VERSION.SDK_INT >= 11) {
            intent.addFlags(32768);
        }
        if (bo.k((Context) readMailUI, intent)) {
            com.tencent.mm.ce.a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(68424);
                    g.a(ReadMailUI.this, intent, ReadMailUI.this.getString(R.string.ajk), null);
                    AppMethodBeat.o(68424);
                }
            });
            AppMethodBeat.o(68480);
            return;
        }
        ab.w("MicroMsg.ReadMailUI", "schema failed");
        com.tencent.mm.ce.a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(68425);
                g.a(ReadMailUI.this, ReadMailUI.this.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"), ReadMailUI.this.getString(R.string.ajk), null);
                AppMethodBeat.o(68425);
            }
        });
        AppMethodBeat.o(68480);
    }

    static /* synthetic */ void J(ReadMailUI readMailUI) {
        AppMethodBeat.i(68483);
        try {
            new ReadMailProxy(readMailUI.ext, null).REMOTE_CALL("deleteMsgById", Long.valueOf(readMailUI.cvx));
        } catch (Exception e) {
            ab.w("MicroMsg.ReadMailUI", "doDelete fail, ex = %s", e.getMessage());
        }
        readMailUI.finish();
        AppMethodBeat.o(68483);
    }
}
