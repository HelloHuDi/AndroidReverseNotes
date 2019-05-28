package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.m.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.aq.e;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass19;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.e.f;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wework.api.WWAPIFactory;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j extends a {
    int height;
    d iHZ;
    protected Map<String, SparseBooleanArray> utA = new HashMap();
    protected Map<String, Integer> utB = new HashMap();
    ae<String, Bitmap> utC = new ae(12);
    HashMap<String, String> utD = new HashMap();
    String utE = "";
    public String utF;
    HashMap<String, Integer> utG = new HashMap();
    public boolean utH = true;
    public boolean utI = false;
    public boolean utJ = false;
    Set<Integer> utK = new HashSet();
    ArrayList<b> utL;
    Boolean utM;
    int width;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$3 */
    class AnonymousClass3 implements OnCreateContextMenuListener {
        final /* synthetic */ ArrayList utO;

        AnonymousClass3(ArrayList arrayList) {
            this.utO = arrayList;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(7644);
            Iterator it = this.utO.iterator();
            while (it.hasNext()) {
                contextMenu.add((String) it.next());
            }
            AppMethodBeat.o(7644);
        }
    }

    public j(WebViewUI webViewUI) {
        super(webViewUI);
        AppMethodBeat.i(7658);
        this.width = webViewUI.getResources().getDisplayMetrics().widthPixels;
        this.height = webViewUI.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.o(7658);
    }

    public final void onDestroy() {
        AppMethodBeat.i(7659);
        for (SparseBooleanArray sparseBooleanArray : this.utA.values()) {
            if (sparseBooleanArray != null) {
                sparseBooleanArray.clear();
            }
        }
        this.utA.clear();
        this.utG.clear();
        AppMethodBeat.o(7659);
    }

    public final void cZI() {
        AppMethodBeat.i(7660);
        this.utB.clear();
        this.utB.put("menuItem:share:brand", Integer.valueOf(0));
        this.utB.put("menuItem:share:appMessage", Integer.valueOf(1));
        this.utB.put("menuItem:share:dataMessage", Integer.valueOf(23));
        this.utB.put("menuItem:share:timeline", Integer.valueOf(2));
        this.utB.put("menuItem:favorite", Integer.valueOf(3));
        this.utB.put("menuItem:profile", Integer.valueOf(5));
        this.utB.put("menuItem:addContact", Integer.valueOf(5));
        this.utB.put("menuItem:copyUrl", Integer.valueOf(6));
        this.utB.put("menuItem:openWithSafari", Integer.valueOf(7));
        this.utB.put("menuItem:share:email", Integer.valueOf(8));
        this.utB.put("menuItem:delete", Integer.valueOf(9));
        this.utB.put("menuItem:exposeArticle", Integer.valueOf(10));
        this.utB.put("menuItem:setFont", Integer.valueOf(11));
        this.utB.put("menuItem:editTag", Integer.valueOf(12));
        this.utB.put("menuItem:readMode", Integer.valueOf(14));
        this.utB.put("menuItem:originPage", Integer.valueOf(14));
        this.utB.put("menuItem:share:qq", Integer.valueOf(20));
        this.utB.put("menuItem:share:weiboApp", Integer.valueOf(21));
        this.utB.put("menuItem:share:QZone", Integer.valueOf(22));
        this.utB.put("menuItem:share:Facebook", Integer.valueOf(33));
        this.utB.put("menuItem:share:enterprise", Integer.valueOf(24));
        this.utB.put("menuItem:refresh", Integer.valueOf(28));
        this.utB.put("menuItem:share:wework", Integer.valueOf(25));
        this.utB.put("menuItem:share:weread", Integer.valueOf(26));
        this.utB.put("menuItem:addShortcut", Integer.valueOf(29));
        this.utB.put("menuItem:search", Integer.valueOf(31));
        this.utB.put("menuItem:readArticle", Integer.valueOf(34));
        this.utB.put("menuItem:minimize", Integer.valueOf(35));
        this.utB.put("menuItem:cancelMinimize", Integer.valueOf(36));
        this.utB.put("menuItem:translate", Integer.valueOf(37));
        this.utB.put("menuItem:haoKan", Integer.valueOf(38));
        this.utB.put("menuItem:cancelHaoKan", Integer.valueOf(39));
        AppMethodBeat.o(7660);
    }

    public final void afE(String str) {
        AppMethodBeat.i(7661);
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.utA.get(str);
        if (sparseBooleanArray == null) {
            sparseBooleanArray = new SparseBooleanArray();
            this.utA.put(str, sparseBooleanArray);
        }
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(34, true);
        }
        AppMethodBeat.o(7661);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean Jn(int i) {
        AppMethodBeat.i(7662);
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.utA.get(cZv().pzf.getUrl());
        if (sparseBooleanArray == null || !sparseBooleanArray.get(i, false)) {
            AppMethodBeat.o(7662);
            return true;
        }
        AppMethodBeat.o(7662);
        return false;
    }

    protected static boolean a(JsapiPermissionWrapper jsapiPermissionWrapper, int i) {
        AppMethodBeat.i(7663);
        if (jsapiPermissionWrapper == null) {
            AppMethodBeat.o(7663);
            return false;
        }
        int Lx = jsapiPermissionWrapper.Lx(i);
        if (Lx == 1 || Lx == 10) {
            AppMethodBeat.o(7663);
            return true;
        }
        AppMethodBeat.o(7663);
        return false;
    }

    protected static boolean b(JsapiPermissionWrapper jsapiPermissionWrapper, int i) {
        AppMethodBeat.i(7664);
        if (jsapiPermissionWrapper == null) {
            AppMethodBeat.o(7664);
            return false;
        } else if (jsapiPermissionWrapper.Lx(i) == 10) {
            AppMethodBeat.o(7664);
            return true;
        } else {
            AppMethodBeat.o(7664);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cZJ() {
        AppMethodBeat.i(7665);
        if (this.utI) {
            this.utH = false;
            cZv().uxb = false;
            this.utI = false;
            if (this.utJ) {
                cZM();
            }
            AppMethodBeat.o(7665);
            return;
        }
        AppMethodBeat.o(7665);
    }

    public final void Kt() {
        AppMethodBeat.i(138038);
        if (this.utJ) {
            cZM();
        }
        AppMethodBeat.o(138038);
    }

    public final void cZK() {
        AppMethodBeat.i(7666);
        if (this.utJ) {
            cZM();
        }
        AppMethodBeat.o(7666);
    }

    public final void cZL() {
        AppMethodBeat.i(7667);
        this.utH = true;
        this.utK.clear();
        if (cZv() instanceof GameWebViewUI) {
            this.utK.add(Integer.valueOf(11));
            this.utK.add(Integer.valueOf(28));
            AppMethodBeat.o(7667);
            return;
        }
        this.utK.add(Integer.valueOf(7));
        this.utK.add(Integer.valueOf(11));
        this.utK.add(Integer.valueOf(28));
        AppMethodBeat.o(7667);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cZM() {
        AppMethodBeat.i(7668);
        this.utL = cZN();
        boolean z = this.utL != null && this.utL.size() > 0;
        this.utM = Boolean.valueOf(z);
        if (!this.utJ) {
            if (this.utM.booleanValue()) {
                this.iHZ = new d(cZv(), 1, false);
            } else {
                this.iHZ = new d(cZv(), 0, true);
            }
        }
        this.iHZ.zFT = new a() {
            public final void a(ImageView imageView, MenuItem menuItem) {
                AppMethodBeat.i(7642);
                if (j.g(menuItem)) {
                    imageView.setVisibility(8);
                    AppMethodBeat.o(7642);
                    return;
                }
                String str = menuItem.getTitle();
                if (j.this.utC.get(str) == null || ((Bitmap) j.this.utC.get(str)).isRecycled()) {
                    ab.w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
                    try {
                        String aff = j.this.cZv().icy.aff(str);
                        if (!bo.isNullOrNil(aff)) {
                            Bitmap afx = g.afx(aff);
                            if (!(afx == null || afx.isRecycled())) {
                                imageView.setImageBitmap(afx);
                                j.this.utC.put(str, afx);
                            }
                        }
                        AppMethodBeat.o(7642);
                        return;
                    } catch (Exception e) {
                        ab.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + e.getMessage());
                        AppMethodBeat.o(7642);
                        return;
                    }
                }
                imageView.setImageBitmap((Bitmap) j.this.utC.get(str));
                AppMethodBeat.o(7642);
            }
        };
        this.iHZ.zFU = new n.b() {
            public final void a(TextView textView, MenuItem menuItem) {
                AppMethodBeat.i(7650);
                String str = menuItem.getTitle();
                if (textView != null) {
                    CharSequence charSequence = (String) j.this.utD.get(str);
                    if (bo.isNullOrNil(charSequence)) {
                        textView.setText(str);
                        AppMethodBeat.o(7650);
                        return;
                    }
                    textView.setText(com.tencent.mm.pluginsdk.ui.e.j.b(j.this.cZv(), charSequence, textView.getTextSize()));
                }
                AppMethodBeat.o(7650);
            }
        };
        this.iHZ.rBm = new n.d() {
            /* JADX WARNING: Removed duplicated region for block: B:212:0x113a  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x00ef  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                int i2;
                int i3;
                Throwable e;
                int i4 = 0;
                AppMethodBeat.i(7652);
                j.this.utJ = false;
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar;
                if (j.g(menuItem)) {
                    b bVar = (b) menuItem.getMenuInfo();
                    if (bVar != null) {
                        dVar = j.this.cZv().uhz;
                        ab.i("MicroMsg.JsApiHandler", "onCustomMenuClick");
                        HashMap hashMap = new HashMap();
                        hashMap.put("key", bVar.key);
                        hashMap.put("title", bVar.title);
                        dVar.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("menu:custom", hashMap, dVar.uFv, dVar.uFw) + ")", null);
                    }
                    AppMethodBeat.o(7652);
                    return;
                }
                String stringExtra;
                String stringExtra2;
                String stringExtra3;
                e cYc;
                e cYc2;
                j jVar;
                j jVar2;
                j jVar3;
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar2;
                Intent intent;
                Bundle JL;
                Bundle bundle;
                switch (menuItem.getItemId()) {
                    case 1:
                        stringExtra = j.this.cZv().getIntent().getStringExtra("KPublisherId");
                        stringExtra2 = j.this.cZv().getIntent().getStringExtra("KAppId");
                        stringExtra3 = j.this.cZv().getIntent().getStringExtra("srcUsername");
                        cYc = j.this.cZv().ulI.cYc();
                        cYc.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(1), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                        cYc.b(j.this.cZv().icy);
                        j.this.cZv().uvr = j.this.cZv().icz.cZT().dmm();
                        j.this.cZv().clH();
                        AppMethodBeat.o(7652);
                        return;
                    case 2:
                        stringExtra = j.this.cZv().getIntent().getStringExtra("KPublisherId");
                        stringExtra2 = j.this.cZv().getIntent().getStringExtra("KAppId");
                        stringExtra3 = j.this.cZv().getIntent().getStringExtra("srcUsername");
                        cYc = j.this.cZv().ulI.cYc();
                        cYc.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(2), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                        cYc.b(j.this.cZv().icy);
                        j.this.cZv().uvr = j.this.cZv().icz.cZT().dmm();
                        if (j.this.utG.containsKey(j.this.cZv().pzf.getUrl())) {
                            i4 = ((Integer) j.this.utG.get(j.this.cZv().pzf.getUrl())).intValue();
                        }
                        j.a(j.this, i4);
                        AppMethodBeat.o(7652);
                        return;
                    case 3:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(3), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        h.pYm.a(157, 6, 1, false);
                        j.this.cZv().uvr = j.this.cZv().icz.cZT().dmm();
                        j.this.cZO();
                        AppMethodBeat.o(7652);
                        return;
                    case 5:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(4), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        stringExtra = (String) j.this.cZv().uwb.get(j.this.cZv().pzf.getUrl());
                        if (stringExtra == null) {
                            stringExtra = j.this.cZv().getIntent().getStringExtra("srcUsername");
                        }
                        jVar = j.this;
                        stringExtra3 = "Contact_Scene";
                        if (jVar.cZv().uhz != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt(stringExtra3, 43);
                            dVar = jVar.cZv().uhz;
                            try {
                                dVar.icy.a(21, bundle2, dVar.uqj);
                            } catch (Exception e2) {
                                ab.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                                ab.w("MicroMsg.JsApiHandler", "updateJsapiArgsBundleKV, ex = ".concat(String.valueOf(e2)));
                            }
                        }
                        j.this.cZv().afK(stringExtra);
                        AppMethodBeat.o(7652);
                        return;
                    case 6:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(5), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        jVar2 = j.this;
                        if (jVar2.cZv().pzf == null) {
                            ab.e("MicroMsg.WebViewMenuHelper", "copyLink fail, viewWV is null");
                            AppMethodBeat.o(7652);
                            return;
                        }
                        CharSequence url = jVar2.cZv().pzf.getUrl();
                        if (url == null || url.length() == 0) {
                            ab.e("MicroMsg.WebViewMenuHelper", "copyLink fail, url is null");
                            AppMethodBeat.o(7652);
                            return;
                        }
                        CharSequence aek;
                        try {
                            aek = jVar2.cZv().icy.aek(url);
                        } catch (Exception e3) {
                            ab.e("MicroMsg.WebViewMenuHelper", "copy link failed");
                            aek = url;
                        }
                        ClipboardManager clipboardManager = (ClipboardManager) jVar2.cZv().getApplication().getSystemService("clipboard");
                        if (clipboardManager != null) {
                            try {
                                clipboardManager.setText(aek);
                                Toast.makeText(jVar2.cZv(), jVar2.cZv().getString(R.string.g1w), 0).show();
                                AppMethodBeat.o(7652);
                                return;
                            } catch (Exception e4) {
                                ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e4, "clip.setText error", new Object[0]);
                                AppMethodBeat.o(7652);
                                return;
                            }
                        }
                        ab.e("MicroMsg.WebViewMenuHelper", "clipboard manager is null");
                        AppMethodBeat.o(7652);
                        return;
                    case 7:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(13), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        WebViewUI cZv = j.this.cZv();
                        com.tencent.mm.plugin.webview.stub.d dVar3 = cZv.icy;
                        if (!cZv.isFinishing()) {
                            stringExtra = cZv.dae();
                            if (bo.isNullOrNil(stringExtra)) {
                                ab.e("MicroMsg.BrowserChooserHelper", "open in browser fail, url is null");
                                AppMethodBeat.o(7652);
                                return;
                            }
                            if (dVar3 != null) {
                                try {
                                    stringExtra = dVar3.aek(stringExtra);
                                } catch (Exception e5) {
                                    ab.e("MicroMsg.BrowserChooserHelper", "showAndOpenInBrowser, getShareUrl, exception = %s", e5);
                                }
                            }
                            if (!(stringExtra.startsWith("http://") || stringExtra.startsWith("https://"))) {
                                stringExtra = "http://".concat(String.valueOf(stringExtra));
                            }
                            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(stringExtra));
                            try {
                                if (bo.gT(cZv) || g.dnY()) {
                                    cZv.startActivity(intent2);
                                    AppMethodBeat.o(7652);
                                    return;
                                }
                                cZv.startActivityForResult(com.tencent.mm.plugin.webview.modeltools.a.a(cZv, intent2, stringExtra), 2);
                                AppMethodBeat.o(7652);
                                return;
                            } catch (Exception e42) {
                                ab.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", e42.getMessage());
                            }
                        }
                        AppMethodBeat.o(7652);
                        return;
                    case 8:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(15), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        jVar3 = j.this;
                        jVar3.cZv().uhz.bJ("sendEmail", true);
                        dVar2 = jVar3.cZv().uhz;
                        if (dVar2.ready) {
                            dVar2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("menu:share:email", new HashMap(), dVar2.uFv, dVar2.uFw) + ")", null);
                            AppMethodBeat.o(7652);
                            return;
                        }
                        ab.e("MicroMsg.JsApiHandler", "onSendMail fail, not ready");
                        AppMethodBeat.o(7652);
                        return;
                    case 9:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(7), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j jVar4 = j.this;
                        com.tencent.mm.ui.base.h.a(jVar4.cZv(), jVar4.cZv().getString(R.string.p5), null, null, jVar4.cZv().getString(R.string.p4), new com.tencent.mm.ui.base.h.d() {
                            public final void bV(int i, int i2) {
                                AppMethodBeat.i(7648);
                                switch (i2) {
                                    case -1:
                                        Bundle bundle = new Bundle();
                                        bundle.putLong("fav_local_id", j.this.cZv().getIntent().getLongExtra("fav_local_id", -1));
                                        try {
                                            if (j.this.cZv().icy.aa(bundle)) {
                                                ab.i("MicroMsg.WebViewMenuHelper", "del fav web url ok, finish webview ui");
                                                j.this.cZv().ulI.q("mm_del_fav", Boolean.TRUE);
                                                j.this.cZv().finish();
                                                AppMethodBeat.o(7648);
                                                return;
                                            }
                                            ab.w("MicroMsg.WebViewMenuHelper", "try to del web url fail");
                                            AppMethodBeat.o(7648);
                                            return;
                                        } catch (Exception e) {
                                            ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e, "", new Object[0]);
                                            ab.e("MicroMsg.WebViewMenuHelper", "try to del web url crash");
                                            AppMethodBeat.o(7648);
                                            return;
                                        }
                                    default:
                                        ab.i("MicroMsg.WebViewMenuHelper", "do del cancel");
                                        AppMethodBeat.o(7648);
                                        return;
                                }
                            }
                        });
                        AppMethodBeat.o(7652);
                        return;
                    case 10:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(11), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.this.afG(null);
                        AppMethodBeat.o(7652);
                        return;
                    case 11:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(8), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        if (j.this.cZv().uvb.getVisibility() == 8) {
                            j.this.cZv().uvb.startAnimation(AnimationUtils.loadAnimation(j.this.cZv(), R.anim.b9));
                            j.this.cZv().uvb.setVisibility(0);
                            AppMethodBeat.o(7652);
                            return;
                        }
                        Animation loadAnimation = AnimationUtils.loadAnimation(j.this.cZv(), R.anim.b_);
                        loadAnimation.setAnimationListener(new AnimationListener() {
                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                AppMethodBeat.i(7651);
                                j.this.cZv().uvb.setVisibility(8);
                                AppMethodBeat.o(7651);
                            }
                        });
                        j.this.cZv().uvb.startAnimation(loadAnimation);
                        j.this.cZv().uvb.setVisibility(8);
                        AppMethodBeat.o(7652);
                        return;
                    case 12:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(6), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        intent = new Intent();
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", j.this.cZv().getIntent().getLongExtra("fav_local_id", -1));
                        com.tencent.mm.plugin.fav.a.b.b(j.this.cZv(), ".ui.FavTagEditUI", intent);
                        j.this.cZv().ulI.aeG("mm_edit_fav_count");
                        AppMethodBeat.o(7652);
                        return;
                    case 14:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(9), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        if (j.this.cZv().uvZ) {
                            j.a(j.this, j.this.utE);
                            AppMethodBeat.o(7652);
                            return;
                        }
                        j.a(j.this, j.this.cZv().pzf.getUrl(), j.this.cZv().pzf.getSettings().getUserAgentString(), j.this.width, j.this.height);
                        AppMethodBeat.o(7652);
                        return;
                    case 15:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(19), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.a(j.this, menuItem);
                        AppMethodBeat.o(7652);
                        return;
                    case 16:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(21), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.a(j.this, menuItem);
                        AppMethodBeat.o(7652);
                        return;
                    case 17:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(20), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.a(j.this, menuItem);
                        AppMethodBeat.o(7652);
                        return;
                    case 18:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(22), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.a(j.this, menuItem);
                        AppMethodBeat.o(7652);
                        return;
                    case 19:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(23), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.a(j.this, menuItem);
                        AppMethodBeat.o(7652);
                        return;
                    case 20:
                        j.this.cZv().uvr = j.this.cZv().icz.cZT().dmm();
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(17), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        jVar3 = j.this;
                        jVar3.cZv().uhz.bJ("shareQQ", true);
                        dVar2 = jVar3.cZv().uhz;
                        if (dVar2.ready) {
                            JL = dVar2.JL(1);
                            if (JL == null || !JL.getBoolean("WebViewShare_reslut", false)) {
                                dVar2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("menu:share:qq", new HashMap(), dVar2.uFv, dVar2.uFw) + ")", null);
                                AppMethodBeat.o(7652);
                                return;
                            }
                            dVar2.h(JL, "shareQQ");
                            AppMethodBeat.o(7652);
                            return;
                        }
                        ab.e("MicroMsg.JsApiHandler", "onShareQQ fail, not ready");
                        AppMethodBeat.o(7652);
                        return;
                    case 21:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(18), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        jVar3 = j.this;
                        jVar3.cZv().uhz.bJ("shareWeiboApp", true);
                        dVar2 = jVar3.cZv().uhz;
                        if (dVar2.ready) {
                            dVar2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("menu:share:weiboApp", new HashMap(), dVar2.uFv, dVar2.uFw) + ")", null);
                            AppMethodBeat.o(7652);
                            return;
                        }
                        ab.e("MicroMsg.JsApiHandler", "onShareWeiboApp fail, not ready");
                        AppMethodBeat.o(7652);
                        return;
                    case 22:
                        j.this.cZv().uvr = j.this.cZv().icz.cZT().dmm();
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(24), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        jVar3 = j.this;
                        jVar3.cZv().uhz.bJ("shareQZone", true);
                        dVar2 = jVar3.cZv().uhz;
                        if (dVar2.ready) {
                            JL = dVar2.JL(1);
                            if (JL == null || !JL.getBoolean("WebViewShare_reslut", false)) {
                                dVar2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("menu:share:QZone", new HashMap(), dVar2.uFv, dVar2.uFw) + ")", null);
                                AppMethodBeat.o(7652);
                                return;
                            }
                            dVar2.h(JL, "shareQZone");
                            AppMethodBeat.o(7652);
                            return;
                        }
                        ab.e("MicroMsg.JsApiHandler", "onShareQzone fail, not ready");
                        AppMethodBeat.o(7652);
                        return;
                    case 23:
                        intent = new Intent();
                        stringExtra2 = j.this.cZv().getIntent().getStringExtra("sns_local_id");
                        if (stringExtra2 != null) {
                            intent.putExtra("sns_send_data_ui_activity", true);
                            intent.putExtra("sns_local_id", stringExtra2);
                        } else {
                            intent.putExtra("Retr_Msg_Id", Long.valueOf(j.this.cZv().getIntent().getLongExtra("msg_id", Long.MIN_VALUE)));
                        }
                        com.tencent.mm.bp.d.f(j.this.cZv(), ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        AppMethodBeat.o(7652);
                        return;
                    case 24:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(16), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        jVar = j.this;
                        try {
                            bundle = new Bundle();
                            bundle.putString("enterprise_action", "enterprise_connectors");
                            ArrayList stringArrayList = jVar.cZv().icy.g(71, bundle).getStringArrayList("enterprise_connectors");
                            if (stringArrayList == null || stringArrayList.size() <= 0) {
                                AppMethodBeat.o(7652);
                                return;
                            } else if (stringArrayList.size() == 1) {
                                jVar.afF((String) stringArrayList.get(0));
                                AppMethodBeat.o(7652);
                                return;
                            } else {
                                jVar.ec(stringArrayList);
                                com.tencent.mm.ui.tools.j jVar5 = new com.tencent.mm.ui.tools.j(jVar.cZv());
                                jVar5.a(jVar.cZv().pzf, jVar.cZv(), null);
                                jVar5.zFT = new a() {
                                    public final void a(ImageView imageView, MenuItem menuItem) {
                                        AppMethodBeat.i(7657);
                                        if (j.g(menuItem)) {
                                            imageView.setVisibility(8);
                                            AppMethodBeat.o(7657);
                                            return;
                                        }
                                        String str = menuItem.getTitle();
                                        if (j.this.utC.get(str) == null || ((Bitmap) j.this.utC.get(str)).isRecycled()) {
                                            ab.w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
                                            try {
                                                String aff = j.this.cZv().icy.aff(str);
                                                if (!bo.isNullOrNil(aff)) {
                                                    Bitmap afx = g.afx(aff);
                                                    if (!(afx == null || afx.isRecycled())) {
                                                        imageView.setImageBitmap(afx);
                                                        j.this.utC.put(str, afx);
                                                    }
                                                }
                                                AppMethodBeat.o(7657);
                                                return;
                                            } catch (Exception e) {
                                                ab.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + e.getMessage());
                                                AppMethodBeat.o(7657);
                                                return;
                                            }
                                        }
                                        imageView.setImageBitmap((Bitmap) j.this.utC.get(str));
                                        AppMethodBeat.o(7657);
                                    }
                                };
                                jVar5.zFU = new n.b() {
                                    public final void a(TextView textView, MenuItem menuItem) {
                                        AppMethodBeat.i(7643);
                                        String str = menuItem.getTitle();
                                        if (textView != null) {
                                            CharSequence charSequence = (String) j.this.utD.get(str);
                                            if (bo.isNullOrNil(charSequence)) {
                                                textView.setText(str);
                                                AppMethodBeat.o(7643);
                                                return;
                                            }
                                            textView.setText(com.tencent.mm.pluginsdk.ui.e.j.b(j.this.cZv(), charSequence, textView.getTextSize()));
                                        }
                                        AppMethodBeat.o(7643);
                                    }
                                };
                                jVar5.b(jVar.cZv().pzf, new AnonymousClass3(stringArrayList), new n.d() {
                                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                        AppMethodBeat.i(7645);
                                        j.this.afF(menuItem.getTitle().toString());
                                        AppMethodBeat.o(7645);
                                    }
                                });
                                jVar5.cuu();
                                AppMethodBeat.o(7652);
                                return;
                            }
                        } catch (Exception e422) {
                            ab.w("MicroMsg.WebViewMenuHelper", "builder add, ex = " + e422.getMessage());
                            AppMethodBeat.o(7652);
                            return;
                        }
                    case 25:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(26), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        jVar3 = j.this;
                        jVar3.cZv().uhz.bJ("sendAppMessage", true);
                        dVar2 = jVar3.cZv().uhz;
                        if (dVar2.ready) {
                            dVar2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("menu:share:appmessage", new HashMap(), dVar2.uFv, dVar2.uFw) + ")", null);
                            try {
                                dVar2.icy.L("scene", "wework", dVar2.uqj);
                                AppMethodBeat.o(7652);
                                return;
                            } catch (Exception e4222) {
                                ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e4222.getMessage());
                                AppMethodBeat.o(7652);
                                return;
                            }
                        }
                        ab.e("MicroMsg.JsApiHandler", "onShareWeWork fail, not ready");
                        AppMethodBeat.o(7652);
                        return;
                    case 26:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(27), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        jVar2 = j.this;
                        stringExtra = null;
                        try {
                            stringExtra = jVar2.cZv().icy.aek(jVar2.cZv().pzf.getUrl());
                        } catch (Exception e22) {
                            ab.e("MicroMsg.WebViewMenuHelper", "getShareUrl failed : %s", e22.getMessage());
                        }
                        if (bo.isNullOrNil(stringExtra)) {
                            stringExtra = jVar2.cZv().cOG;
                        }
                        try {
                            stringExtra = "weread://mp?url=" + q.encode(stringExtra, ProtocolPackage.ServerEncoding);
                        } catch (Exception e222) {
                            ab.e("MicroMsg.WebViewMenuHelper", "encode url failed ; %s", e222.getMessage());
                        }
                        ab.i("MicroMsg.WebViewMenuHelper", "now url = %s", stringExtra);
                        Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(stringExtra));
                        intent3.addFlags(268435456);
                        if (bo.k(jVar2.cZv(), intent3)) {
                            jVar2.cZv().startActivity(intent3);
                            AppMethodBeat.o(7652);
                            return;
                        }
                        ab.e("MicroMsg.WebViewMenuHelper", "not availble app match this intent");
                        AppMethodBeat.o(7652);
                        return;
                    case 27:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(32), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        if (!j.this.cZv().cWG()) {
                            j.this.cZv().finish();
                            AppMethodBeat.o(7652);
                            return;
                        }
                        break;
                    case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(10), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.this.cZv().aYe();
                        AppMethodBeat.o(7652);
                        return;
                    case 29:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(31), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.this.cZR();
                        AppMethodBeat.o(7652);
                        return;
                    case 31:
                        h.pYm.a(480, 1, 1, false);
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(28), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        if (!j.this.cZv().uvj.isShown()) {
                            j.this.cZv().uvj.reset();
                            j.this.cZv().uvj.dcX();
                            j.this.cZv().uvj.show();
                            AppMethodBeat.o(7652);
                            return;
                        }
                        break;
                    case 33:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(14), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        jVar3 = j.this;
                        jVar3.cZv().uhz.bJ("sendAppMessage", true);
                        dVar2 = jVar3.cZv().uhz;
                        if (dVar2.ready) {
                            dVar2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("menu:share:appmessage", new HashMap(), dVar2.uFv, dVar2.uFw) + ")", null);
                            try {
                                dVar2.icy.L("scene", "facebook", dVar2.uqj);
                                AppMethodBeat.o(7652);
                                return;
                            } catch (Exception e42222) {
                                ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e42222.getMessage());
                                AppMethodBeat.o(7652);
                                return;
                            }
                        }
                        ab.e("MicroMsg.JsApiHandler", "onShareFaceBook fail, not ready");
                        AppMethodBeat.o(7652);
                        return;
                    case 34:
                        jVar3 = j.this;
                        ab.i("MicroMsg.WebViewMenuHelper", "JumpToReadArticle");
                        if (jVar3.cZv().uhz != null) {
                            dVar2 = jVar3.cZv().uhz;
                            if (dVar2.ready) {
                                ab.i("MicroMsg.JsApiHandler", "onArticleReadBtnClicked");
                                al.d(new AnonymousClass19(i.a.b("onArticleReadingBtnClicked", new HashMap(), dVar2.uFv, dVar2.uFw)));
                            } else {
                                ab.e("MicroMsg.JsApiHandler", "onArticleReadBtnClicked fail, not ready");
                                AppMethodBeat.o(7652);
                                return;
                            }
                        }
                        AppMethodBeat.o(7652);
                        return;
                    case 35:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(33), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.this.cZv().uie.nT(false);
                        AppMethodBeat.o(7652);
                        return;
                    case 36:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(34), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.this.cZv().uie.nT(true);
                        AppMethodBeat.o(7652);
                        return;
                    case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(35), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.a(j.this);
                        AppMethodBeat.o(7652);
                        return;
                    case 38:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(36), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.b(j.this, 1);
                        AppMethodBeat.o(7652);
                        return;
                    case 39:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(37), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        j.b(j.this, 0);
                        AppMethodBeat.o(7652);
                        return;
                    default:
                        cYc2 = j.this.cZv().ulI.cYc();
                        cYc2.une = new Object[]{j.this.cZv().cOG, Integer.valueOf(16), Integer.valueOf(1)};
                        cYc2.b(j.this.cZv().icy);
                        stringExtra3 = menuItem.getTitle();
                        if (!bo.isNullOrNil(stringExtra3)) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("data", stringExtra3);
                                bundle = j.this.cZv().icy.g(50, bundle);
                                if (bundle != null) {
                                    i2 = bundle.getInt("key_biz_type") == 2 ? 1 : 0;
                                    try {
                                        if (bundle.getInt("key_biz_type") == 3) {
                                            i3 = 1;
                                        } else {
                                            i3 = 0;
                                        }
                                    } catch (RemoteException e6) {
                                        e = e6;
                                    }
                                } else {
                                    i3 = 0;
                                }
                            } catch (RemoteException e7) {
                                e = e7;
                                i2 = 0;
                                ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e, "", new Object[0]);
                                i3 = i2;
                                if (i3 != 0) {
                                }
                            }
                            if (i3 != 0) {
                                jVar3 = j.this;
                                jVar3.cZv().uhz.bJ("sendAppMessage", false);
                                dVar2 = jVar3.cZv().uhz;
                                if (dVar2.ready) {
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("scene", "connector");
                                    dVar2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("menu:share:appmessage", hashMap2, dVar2.uFv, dVar2.uFw) + ")", null);
                                    try {
                                        dVar2.icy.L("connector_local_send", stringExtra3, dVar2.uqj);
                                        dVar2.icy.L("scene", "connector", dVar2.uqj);
                                        AppMethodBeat.o(7652);
                                        return;
                                    } catch (Exception e422222) {
                                        ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e422222.getMessage());
                                        break;
                                    }
                                }
                                ab.e("MicroMsg.JsApiHandler", "onSendToConnector fail, not ready");
                                AppMethodBeat.o(7652);
                                return;
                            }
                            j.this.afF(stringExtra3);
                            AppMethodBeat.o(7652);
                            return;
                        }
                        break;
                }
                AppMethodBeat.o(7652);
            }
        };
        this.iHZ.zQf = new d.a() {
            public final void onDismiss() {
                j.this.utJ = false;
            }
        };
        this.iHZ.rBl = new c() {
            /* JADX WARNING: Removed duplicated region for block: B:172:0x05a5  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(l lVar) {
                AppMethodBeat.i(7653);
                h.pYm.a(480, 0, 1, false);
                lVar.clear();
                int i;
                m mVar;
                if (j.this.utM.booleanValue()) {
                    int size = j.this.utL.size();
                    for (i = 0; i < size; i++) {
                        b bVar = (b) j.this.utL.get(i);
                        mVar = (m) lVar.e(bVar.id, bVar.title);
                        mVar.yvW = bVar;
                        mVar.setIcon(null);
                        mVar.setIcon(0);
                    }
                    AppMethodBeat.o(7653);
                    return;
                }
                try {
                    LinkedList dar = j.this.cZv().dar();
                    if (dar != null) {
                        i = 0;
                        while (i < dar.size() && i < 8) {
                            com.tencent.mm.m.d.a aVar = (com.tencent.mm.m.d.a) dar.get(i);
                            mVar = null;
                            if (FirebaseAnalytics.b.INDEX.equals(bo.nullAsNil(aVar.id))) {
                                mVar = (m) lVar.a(15, j.this.cZv().getString(R.string.fyh), (int) R.raw.bottomsheet_icon_jd_index);
                            } else if ("categories".equals(bo.nullAsNil(aVar.id))) {
                                mVar = (m) lVar.a(16, j.this.cZv().getString(R.string.fyg), (int) R.raw.bottomsheet_icon_jd_collect_list);
                            } else if ("cart".equals(bo.nullAsNil(aVar.id))) {
                                mVar = (m) lVar.a(17, j.this.cZv().getString(R.string.fyf), (int) R.raw.bottomsheet_icon_jd_cart);
                            } else if (Scopes.PROFILE.equals(bo.nullAsNil(aVar.id))) {
                                mVar = (m) lVar.a(18, j.this.cZv().getString(R.string.fyj), (int) R.raw.bottomsheet_icon_profile);
                            } else if ("member".equals(bo.nullAsNil(aVar.id))) {
                                mVar = (m) lVar.a(19, j.this.cZv().getString(R.string.fyi), (int) R.raw.bottomsheet_icon_jd_member);
                            }
                            if (mVar != null) {
                                mVar.hAh = aVar.url;
                            }
                            i++;
                        }
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.WebViewMenuHelper", "exception in add jd menu, " + e.getMessage());
                }
                if (j.this.cZv().icz == null || j.this.cZv().icz.cZS() == null) {
                    ab.e("MicroMsg.WebViewMenuHelper", "get permission failed");
                    AppMethodBeat.o(7653);
                    return;
                }
                boolean mZ;
                JsapiPermissionWrapper cZS = j.this.cZv().icz.cZS();
                if (j.this.cZv().cWO()) {
                    if (j.c(j.this, 35) && j.this.Jn(35) && !j.this.cZv().uie.dbd()) {
                        lVar.a(35, j.this.cZv().getString(R.string.dhw), (int) R.raw.bottomsheet_icon_webview_minimize);
                    } else if (j.this.Jn(36) && j.this.cZv().uie.dbd()) {
                        lVar.a(36, j.this.cZv().getString(R.string.dhm), (int) R.raw.bottomsheet_icon_webview_cancel_minimize);
                    }
                }
                if (j.c(j.this, 1) && j.a(cZS, 21) && j.this.Jn(1)) {
                    lVar.a(1, j.this.cZv().getString(R.string.dhh), R.raw.bottomsheet_icon_transmit, j.b(cZS, 21));
                }
                if (j.c(j.this, 2) && j.a(cZS, 23) && j.this.Jn(2)) {
                    lVar.a(2, j.this.cZv().getString(R.string.dhi), R.raw.bottomsheet_icon_moment, j.b(cZS, 23));
                }
                int i2 = -1;
                int i3 = -1;
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("WebViewShare_BinderID", j.this.cZv().hashCode());
                    bundle.putString("WebViewShare_wv_url", j.this.cZv().pzf.getUrl());
                    bundle = j.this.cZv().icy.g(109, bundle);
                    if (bundle != null) {
                        i2 = bundle.getInt("key_hao_kan_permission", 0);
                        i3 = bundle.getInt("key_hao_kan_recommand", -1);
                    }
                } catch (RemoteException e2) {
                    ab.e("MicroMsg.WebViewMenuHelper", "isSetHaoKan, e = " + e2.getMessage());
                }
                if (i2 == 1) {
                    if (j.c(j.this, 38) && j.this.Jn(38) && i3 == 0) {
                        lVar.a(38, j.this.cZv().getString(R.string.dhr), (int) R.raw.bottomsheet_icon_hao_kan);
                    } else if (j.this.Jn(39) && i3 == 1) {
                        lVar.a(39, j.this.cZv().getString(R.string.dhj), (int) R.raw.bottomsheet_icon_cancel_hao_kan);
                    }
                }
                if (j.c(j.this, 3) && (!(j.this.cZv().uvu && (bo.isNullOrNil(j.this.cZv().uxf) || bo.isNullOrNil(j.this.cZv().uxe) || j.this.cZv().uxf.startsWith(j.this.cZv().uxe))) && j.a(cZS, 323) && j.this.cZQ() && j.this.Jn(3))) {
                    lVar.a(3, j.this.cZv().getString(R.string.dcq), R.raw.bottomsheet_icon_fav, j.b(cZS, 323));
                }
                String stringExtra = j.this.cZv().getIntent().getStringExtra("sns_local_id");
                long longExtra = j.this.cZv().getIntent().getLongExtra("msg_id", Long.MIN_VALUE);
                try {
                    if (j.c(j.this, 23) && j.this.cZv().icy.x(longExtra, stringExtra)) {
                        lVar.a(23, j.this.cZv().getString(R.string.b6w), (int) R.raw.bottomsheet_icon_other_mode);
                    }
                } catch (Exception e3) {
                    ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e3, "", new Object[0]);
                }
                if (j.c(j.this, 31)) {
                    lVar.a(31, j.this.cZv().getString(R.string.g2s), (int) R.raw.bottomsheet_icon_search);
                }
                if (j.c(j.this, 6) && j.a(cZS, 44) && j.this.Jn(6)) {
                    lVar.a(6, j.this.cZv().getString(R.string.g1v), R.raw.bottomsheet_icon_copy, j.b(cZS, 44));
                }
                if (cZS.vxM != null && j.this.cZv().uvu && !bo.isNullOrNil(j.this.cZv().uxf) && !bo.isNullOrNil(j.this.cZv().uxe) && j.this.cZv().uxf.startsWith(j.this.cZv().uxe) && j.this.cZv().getIntent().getBooleanExtra("key_detail_can_delete", true) && j.this.cZQ()) {
                    if (j.c(j.this, 12) && j.this.Jn(12)) {
                        lVar.a(12, j.this.cZv().getString(R.string.bnm), (int) R.raw.bottomsheet_icon_addtag);
                    }
                    if (j.c(j.this, 9) && j.this.Jn(9)) {
                        lVar.a(9, j.this.cZv().getString(R.string.p4), (int) R.raw.bottomsheet_icon_del);
                    }
                }
                String stringExtra2 = j.this.cZv().getIntent().getStringExtra("srcUsername");
                if (!bo.isNullOrNil(stringExtra2)) {
                    try {
                        mZ = j.this.cZv().icy.mZ(stringExtra2);
                    } catch (Exception e32) {
                        ab.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail isBizContact, ex = " + e32.getMessage());
                        mZ = false;
                    }
                    if (mZ) {
                        boolean mY;
                        try {
                            mY = j.this.cZv().icy.mY(stringExtra2);
                        } catch (Exception e322) {
                            ab.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail, ex = " + e322.getMessage());
                            mY = false;
                        }
                        boolean a;
                        if (mY) {
                            a = j.a(cZS, 19);
                            mZ = j.b(cZS, 19);
                        } else {
                            a = j.a(cZS, 20);
                            mZ = j.b(cZS, 20);
                        }
                        boolean das = j.this.cZv().das();
                        if (j.c(j.this, 5) && ((a && j.this.Jn(5)) || das)) {
                            i2 = mY ? R.string.g26 : R.string.g1x;
                            if (das) {
                                i2 = R.string.g27;
                            }
                            lVar.a(5, j.this.cZv().getString(i2), R.raw.bottomsheet_icon_brand_profile, mZ);
                        }
                    } else {
                        try {
                            j.this.cZv().icy.afl(stringExtra2);
                        } catch (Exception e3222) {
                            ab.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail triggerGetContact, ex = " + e3222.getMessage());
                        }
                    }
                }
                if (j.c(j.this, 34) && j.a(cZS, 313) && j.this.Jn(34)) {
                    lVar.a(34, j.this.cZv().getString(R.string.g2o), R.raw.bottomsheet_icon_reading, j.b(cZS, 313));
                }
                if (j.c(j.this, 7) && j.a(cZS, 45) && j.this.Jn(7)) {
                    lVar.a(7, j.this.cZv().getString(R.string.g20), R.raw.bottomsheet_icon_brower, j.b(cZS, 45));
                }
                if (j.c(j.this, 37)) {
                    j.this.cZv();
                    if (com.tencent.mm.plugin.webview.b.b(j.this.cZv().pzf) && j.this.Jn(37)) {
                        lVar.a(37, j.this.cZv().getString(R.string.fz6), (int) R.raw.bottomsheet_icon_translate);
                    }
                }
                if (j.c(j.this, 24) && j.a(cZS, 43) && j.this.Jn(24) && !p.u(j.this.cZv(), "com.tencent.wework")) {
                    try {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("enterprise_action", "enterprise_has_connector");
                        bundle2 = j.this.cZv().icy.g(71, bundle2);
                        if (bundle2 != null) {
                            mZ = bundle2.getBoolean("enterprise_has_connector");
                            if (mZ) {
                                lVar.a(24, j.this.cZv().getString(R.string.dhy), R.raw.bottomsheet_icon_enterprise, j.b(cZS, 43));
                            }
                        }
                    } catch (Exception e32222) {
                        ab.w("MicroMsg.WebViewMenuHelper", "builder add, ex = " + e32222.getMessage());
                    }
                    mZ = false;
                    if (mZ) {
                    }
                }
                if (j.c(j.this, 11) && j.a(cZS, 18) && j.this.Jn(11)) {
                    lVar.a(11, j.this.cZv().getString(R.string.dhg), R.raw.bottomsheet_icon_font, j.b(cZS, 18));
                }
                if (j.c(j.this, 28) && j.this.Jn(28)) {
                    lVar.a(28, j.this.cZv().getString(R.string.fxx), (int) R.raw.bottomsheet_icon_refresh);
                }
                if (j.c(j.this, 14) && j.a(cZS, 73) && j.this.Jn(14) && !j.this.cZv().uvZ) {
                    lVar.a(14, j.this.cZv().getString(R.string.g2p), R.raw.bottomsheet_icon_reader, j.b(cZS, 73));
                }
                if (j.c(j.this, 14) && j.this.cZv().uvZ && j.this.Jn(14)) {
                    lVar.a(14, j.this.cZv().getString(R.string.g2n), (int) R.raw.bottomsheet_icon_other_mode);
                }
                if (j.c(j.this, 10) && j.a(cZS, 47) && j.this.Jn(10)) {
                    lVar.a(10, j.this.cZv().getString(R.string.a9n), R.raw.bottomsheet_icon_complain, j.b(cZS, 47));
                }
                if (j.c(j.this, 8) && j.a(cZS, 36) && j.this.Jn(8)) {
                    stringExtra = null;
                    try {
                        stringExtra = j.this.cZv().icy.cZf();
                    } catch (Exception e4) {
                    }
                    if (bo.isNullOrNil(stringExtra)) {
                        ab.i("MicroMsg.WebViewMenuHelper", "get mail session key is null or nil, should not show send mail menu");
                    } else {
                        lVar.a(8, j.this.cZv().getString(R.string.g22), R.raw.bottomsheet_icon_mail, j.b(cZS, 36));
                    }
                }
                if (j.c(j.this, 33) && j.a(cZS, 31) && j.this.Jn(30)) {
                    try {
                        if (j.this.cZv().icy.g(78, null).getBoolean("isOpenForFaceBook", false)) {
                            lVar.a(33, j.this.cZv().getString(R.string.g2y), R.raw.default_facebookapp, j.b(cZS, 31));
                        }
                    } catch (Exception e322222) {
                        ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e322222, "", new Object[0]);
                    }
                }
                if (j.c(j.this, 25) && j.a(cZS, (int) ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02) && WWAPIFactory.jv(j.this.cZv()).dTK() && j.this.Jn(25)) {
                    lVar.a(25, j.this.cZv().getString(R.string.dhz, new Object[]{"企业微信"}), R.raw.bottomsheet_icon_wework, j.b(cZS, (int) ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02));
                }
                if (j.c(j.this, 26) && j.a(cZS, (int) com.tencent.view.d.MIC_PTU_TRANS_XINGYE) && com.tencent.mm.plugin.webview.stub.a.bl(j.this.cZv(), j.this.cZv().pzf.getUrl()) && j.this.Jn(26)) {
                    lVar.a(26, j.this.cZv().getString(R.string.g2v), R.raw.bottomsheet_icon_weread, j.b(cZS, (int) com.tencent.view.d.MIC_PTU_TRANS_XINGYE));
                }
                if (j.c(j.this, 20) && j.a(cZS, 91) && com.tencent.mm.plugin.webview.stub.a.fq(j.this.cZv()) && j.this.Jn(20)) {
                    lVar.a(20, j.this.cZv().getString(R.string.g2z), R.raw.bottomsheet_icon_qq, j.b(cZS, 91));
                }
                if (j.c(j.this, 22) && j.a(cZS, (int) com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX) && com.tencent.mm.plugin.webview.stub.a.fq(j.this.cZv()) && j.this.Jn(22)) {
                    lVar.a(22, j.this.cZv().getString(R.string.g30), R.raw.bottomsheet_icon_qzone, j.b(cZS, (int) com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX));
                }
                try {
                    if (j.c(j.this, 0) && j.a(cZS, 43) && j.this.Jn(0) && j.this.cZv().icy.aeD()) {
                        List<CharSequence> aeC = j.this.cZv().icy.aeC();
                        for (CharSequence add : aeC) {
                            lVar.add(add);
                        }
                        j.a(j.this, (List) aeC);
                    }
                } catch (Exception e3222222) {
                    ab.w("MicroMsg.WebViewMenuHelper", "builder add, ex = " + e3222222.getMessage());
                }
                if (j.c(j.this, 27) && j.this.cZv().uve != null && j.this.cZv().uve.getVisibility() == 0) {
                    lVar.a(27, j.this.cZv().getString(R.string.dhq), (int) R.raw.bottomsheet_icon_exit);
                }
                stringExtra = j.this.cZv().afN(j.this.cZv().uxf);
                stringExtra2 = j.this.cZv().getIntent().getStringExtra("shortcut_user_name");
                if (!j.this.cZv().uvz && !bo.isNullOrNil(stringExtra) && !bo.isNullOrNil(stringExtra2) && j.a(cZS, 255) && j.this.Jn(29) && j.c(j.this, 29)) {
                    lVar.a(29, j.this.cZv().getString(R.string.dhf), R.raw.webview_add_shortcut, j.b(cZS, 255));
                }
                j.this.utJ = true;
                j.this.iHZ.dKX();
                AppMethodBeat.o(7653);
            }
        };
        final String url = cZv().pzf != null ? cZv().pzf.getUrl() : null;
        if (bo.isNullOrNil(url)) {
            this.iHZ.q(" ", 1);
        } else {
            String string = cZv().getString(R.string.fyz, new Object[]{Uri.parse(url).getHost()});
            if (!bo.isNullOrNil(this.utF)) {
                View inflate = LayoutInflater.from(cZv()).inflate(R.layout.agv, null);
                TextView textView = (TextView) inflate.findViewById(R.id.b0p);
                MMNeat7extView mMNeat7extView = (MMNeat7extView) inflate.findViewById(R.id.c9v);
                this.iHZ.F(inflate, false);
                textView.setText(string);
                SpannableString g = com.tencent.mm.pluginsdk.ui.e.j.g(mMNeat7extView.getContext(), bo.nullAsNil(this.utF), (int) mMNeat7extView.getTextSize());
                mMNeat7extView.ah(g);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) g.getSpans(0, g.length(), ClickableSpan.class);
                if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                    ab.i("MicroMsg.WebViewMenuHelper", "terry h5 apply show");
                    h.pYm.e(16337, url, Integer.valueOf(1), Integer.valueOf(0));
                    mMNeat7extView.setOnTouchListener(new f(mMNeat7extView, new com.tencent.mm.pluginsdk.ui.e.m(mMNeat7extView.getContext())) {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(7654);
                            boolean onTouch = super.onTouch(view, motionEvent);
                            if (onTouch) {
                                ab.i("MMNeatTouchListener", "terry h5 apply click");
                                h.pYm.e(16337, url, Integer.valueOf(1), Integer.valueOf(1));
                            }
                            AppMethodBeat.o(7654);
                            return onTouch;
                        }
                    });
                }
            } else if (!bo.isNullOrNil(r0)) {
                this.iHZ.q(string, 1);
            }
        }
        if (cZv().uvf) {
            this.iHZ.uEO = true;
            this.iHZ.uEP = true;
        } else {
            this.iHZ.uEO = false;
            this.iHZ.uEP = false;
        }
        if (cZv().uvj == null || !cZv().uvj.isShown()) {
            cZv().aqX();
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(7656);
                    if (j.this.cZv().isFinishing() || j.this.cZv().uwA) {
                        ab.i("MicroMsg.WebViewMenuHelper", "tryShow bottom sheet failed, the activity has been destroyed.");
                        AppMethodBeat.o(7656);
                        return;
                    }
                    j.this.iHZ.cpD();
                    AppMethodBeat.o(7656);
                }
            }, 100);
            AppMethodBeat.o(7668);
            return;
        }
        cZv().uvj.hide();
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(7655);
                if (j.this.cZv().isFinishing() || j.this.cZv().uwA) {
                    ab.i("MicroMsg.WebViewMenuHelper", "tryShow bottom sheet failed, the activity has been destroyed.");
                    AppMethodBeat.o(7655);
                    return;
                }
                j.this.iHZ.cpD();
                AppMethodBeat.o(7655);
            }
        }, 100);
        AppMethodBeat.o(7668);
    }

    private ArrayList<b> cZN() {
        AppMethodBeat.i(7669);
        String url = cZv().pzf.getUrl();
        if (cZv().uwc.containsKey(url)) {
            ArrayList arrayList = (ArrayList) cZv().uwc.get(url);
            AppMethodBeat.o(7669);
            return arrayList;
        }
        AppMethodBeat.o(7669);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void afF(String str) {
        AppMethodBeat.i(7670);
        cZv().uhz.bJ("sendAppMessage", false);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = cZv().uhz;
        if (dVar.ready) {
            HashMap hashMap = new HashMap();
            hashMap.put("scene", "enterprise");
            dVar.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("menu:share:appmessage", hashMap, dVar.uFv, dVar.uFw) + ")", null);
            try {
                dVar.icy.L("connector_local_send", str, dVar.uqj);
                dVar.icy.L("scene", "enterprise", dVar.uqj);
                AppMethodBeat.o(7670);
                return;
            } catch (Exception e) {
                ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                AppMethodBeat.o(7670);
                return;
            }
        }
        ab.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
        AppMethodBeat.o(7670);
    }

    private void Jo(int i) {
        AppMethodBeat.i(7672);
        String afN = cZv().afN(cZv().uxh);
        if (TextUtils.isEmpty(cZv().uxh) || TextUtils.isEmpty(afN)) {
            ab.i("MicroMsg.WebViewMenuHelper", "stev appId is null or empty");
            AppMethodBeat.o(7672);
            return;
        }
        ab.i("MicroMsg.WebViewMenuHelper", "stev appId %s", afN);
        long anT = bo.anT();
        ab.d("MicroMsg.WebViewMenuHelper", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", Integer.valueOf(13377), Long.valueOf(anT), afN, cZv().uxh, cZv().cvF, Integer.valueOf(3), Integer.valueOf(i));
        String str = "";
        try {
            str = q.encode(cZv().uxh, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e, "", new Object[0]);
        }
        int afH = cZv().afH(cZv().getIntent().getStringExtra("geta8key_username"));
        String str2 = "";
        if (afH == 7 || afH == 56) {
            str2 = cZv().getIntent().getStringExtra("geta8key_username");
        }
        h.pYm.e(13377, Long.valueOf(anT), afN, str, cZv().cvF, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(0), str2);
        AppMethodBeat.o(7672);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cZO() {
        AppMethodBeat.i(7673);
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", cZv().getIntent().getLongExtra("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", cZv().getIntent().getStringExtra("sns_local_id"));
        bundle.putInt("news_svr_id", cZv().getIntent().getIntExtra("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", cZv().getIntent().getStringExtra("news_svr_tweetid"));
        bundle.putInt("message_index", cZv().getIntent().getIntExtra("message_index", 0));
        bundle.putString("rawUrl", cZv().cOG);
        if (!bo.isNullOrNil(cZv().cOG) && cZv().cOG.endsWith("#rd")) {
            String substring = cZv().cOG.substring(0, cZv().cOG.length() - 3);
            if (!(bo.isNullOrNil(cZv().uxh) || cZv().uxh.startsWith(substring))) {
                bundle.putString("rawUrl", cZv().uxh);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!(bo.isNullOrNil(cZv().uxh) || cZv().uxh.startsWith(cZv().cOG))) {
            bundle.putString("rawUrl", cZv().uxh);
            bundle.putLong("msg_id", Long.MIN_VALUE);
        }
        Intent intent = cZv().getIntent();
        if (intent != null) {
            bundle.putString("preChatName", intent.getStringExtra("preChatName"));
            bundle.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
            bundle.putString("prePublishId", intent.getStringExtra("prePublishId"));
            bundle.putString("preUsername", intent.getStringExtra("preUsername"));
        }
        try {
            com.tencent.mm.plugin.webview.stub.b Z = cZv().icy.Z(bundle);
            if (Z.cYV()) {
                cZv().uhz.bJ("sendAppMessage", false);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = cZv().uhz;
                HashMap cZP = cZP();
                if (dVar.ready) {
                    Bundle JL = dVar.JL(1);
                    if (JL == null || !JL.getBoolean("WebViewShare_reslut", false)) {
                        cZP = new HashMap();
                        cZP.put("scene", "favorite");
                        dVar.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("menu:share:appmessage", cZP, dVar.uFv, dVar.uFw) + ")", null);
                        try {
                            dVar.icy.L("scene", "favorite", dVar.uqj);
                        } catch (Exception e) {
                            ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                        }
                    } else {
                        try {
                            dVar.icy.L("scene", "favorite", dVar.uqj);
                        } catch (Exception e2) {
                            ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e2.getMessage());
                        }
                        dVar.h(JL, "sendAppMessage");
                    }
                } else {
                    try {
                        dVar.icy.L("scene", "favorite", dVar.uqj);
                        dVar.h(dVar.aL(cZP), "sendAppMessage");
                    } catch (Exception e22) {
                        ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e22.getMessage());
                    }
                }
                ab.i("MicroMsg.WebViewMenuHelper", "on favorite simple url");
                AppMethodBeat.o(7673);
                return;
            }
            com.tencent.mm.plugin.fav.ui.c.a(Z.getRet(), cZv(), cZv().mUw);
            if (Z.getRet() == 0) {
                Jo(1);
                AppMethodBeat.o(7673);
                return;
            }
            Jo(2);
            AppMethodBeat.o(7673);
        } catch (Exception e222) {
            ab.e("MicroMsg.WebViewMenuHelper", "edw, favoriteUrl fail, ex = " + e222.getMessage());
            AppMethodBeat.o(7673);
        }
    }

    public final HashMap<String, String> cZP() {
        AppMethodBeat.i(7674);
        if (cZv().uxb) {
            Intent intent = cZv().getIntent();
            String stringExtra = intent.getStringExtra("share_report_pre_msg_url");
            String stringExtra2 = intent.getStringExtra("share_report_pre_msg_title");
            String stringExtra3 = intent.getStringExtra("share_report_pre_msg_icon_url");
            HashMap<String, String> hashMap = new HashMap();
            hashMap.put("share_report_pre_msg_url", stringExtra);
            hashMap.put("share_report_pre_msg_title", stringExtra2);
            hashMap.put("share_report_pre_msg_desc", intent.getStringExtra("share_report_pre_msg_desc"));
            hashMap.put("share_report_pre_msg_icon_url", stringExtra3);
            AppMethodBeat.o(7674);
            return hashMap;
        }
        AppMethodBeat.o(7674);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void ec(List<String> list) {
        AppMethodBeat.i(7675);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(7675);
            return;
        }
        for (String str : list) {
            if (this.utC.get(str) != null) {
                ab.i("MicroMsg.WebViewMenuHelper", "find %s icon from cache ok", str);
            } else {
                ab.w("MicroMsg.WebViewMenuHelper", "not found %s icon from cache, try to load", str);
                try {
                    String aff = cZv().icy.aff(str);
                    if (!bo.isNullOrNil(aff)) {
                        Bitmap afx = g.afx(aff);
                        if (afx != null) {
                            ab.i("MicroMsg.WebViewMenuHelper", "load ok, and cache it");
                            this.utC.put(str, afx);
                        }
                    }
                } catch (Exception e) {
                    ab.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + e.getMessage());
                }
            }
            if (this.utD.containsKey(str)) {
                ab.i("MicroMsg.WebViewMenuHelper", "find %s nick from cache ok", str);
            } else {
                ab.w("MicroMsg.WebViewMenuHelper", "not found %s nick from cache, try to load", str);
                Object obj = null;
                try {
                    obj = cZv().icy.mJ(str);
                    ab.i("MicroMsg.WebViewMenuHelper", "load nick ok");
                } catch (Exception e2) {
                    ab.w("MicroMsg.WebViewMenuHelper", "onAttach, ex = " + e2.getMessage());
                }
                this.utD.put(str, obj);
            }
        }
        AppMethodBeat.o(7675);
    }

    /* Access modifiers changed, original: final */
    public final boolean cZQ() {
        boolean z = false;
        AppMethodBeat.i(7676);
        try {
            z = cZv().icy.afj("favorite");
            AppMethodBeat.o(7676);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e, "", new Object[z]);
            AppMethodBeat.o(7676);
        }
        return z;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cZR() {
        AppMethodBeat.i(7677);
        String afN = cZv().afN(cZv().uxf);
        String stringExtra = cZv().getIntent().getStringExtra("shortcut_user_name");
        if (bo.isNullOrNil(afN) || bo.isNullOrNil(stringExtra)) {
            ab.e("MicroMsg.WebViewMenuHelper", "addShortcut, appid or username is null");
            AppMethodBeat.o(7677);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("KAppId", afN);
        bundle.putString("shortcut_user_name", stringExtra);
        bundle.putInt("webviewui_binder_id", hashCode());
        try {
            cZv().icy.g(80, bundle);
            AppMethodBeat.o(7677);
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewMenuHelper", "addShortcut, e = " + e.getMessage());
            AppMethodBeat.o(7677);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x014b A:{SYNTHETIC, Splitter:B:23:0x014b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void afG(String str) {
        String afN;
        long anT;
        String str2;
        final Intent intent;
        AppMethodBeat.i(7671);
        String stringExtra = cZv().getIntent().getStringExtra("geta8key_username");
        String dae = cZv().dae();
        String str3 = null;
        if (!bo.isNullOrNil(dae)) {
            str3 = Uri.parse(dae).getHost();
        }
        if (!bo.isNullOrNil(str3) && str3.startsWith("mp.weixin.qq.com")) {
            try {
                str3 = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", new Object[]{q.encode(dae, ProtocolPackage.ServerEncoding)});
            } catch (UnsupportedEncodingException e) {
                ab.e("MicroMsg.WebViewMenuHelper", e.getMessage());
            }
            afN = cZv().afN(cZv().pzf.getUrl());
            ab.d("MicroMsg.WebViewMenuHelper", "doExpose enableReportPageEvent %s", Boolean.valueOf(cZv().icz.cZT().dmm()));
            if (!(TextUtils.isEmpty(afN) || !r1 || TextUtils.isEmpty(cZv().pzf.getUrl()))) {
                anT = bo.anT();
                ab.d("MicroMsg.WebViewMenuHelper", "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", Integer.valueOf(13377), Long.valueOf(anT), afN, cZv().pzf.getUrl(), cZv().cvF, Integer.valueOf(4), Integer.valueOf(1));
                str2 = "";
                str2 = q.encode(cZv().pzf.getUrl(), "UTF-8");
                h.pYm.e(13377, Long.valueOf(anT), afN, str2, cZv().cvF, Integer.valueOf(4), Integer.valueOf(1));
            }
            if (bo.isNullOrNil(str3)) {
                str3 = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)});
            }
            intent = new Intent();
            if (!bo.isNullOrNil(str)) {
                try {
                    intent.putExtra("k_webview_html", Base64.encodeToString(str.getBytes("UTF-8"), 11));
                } catch (UnsupportedEncodingException e2) {
                    ab.e("MicroMsg.WebViewMenuHelper", "[oneliang]html get byte error, ex = " + e2.getMessage());
                }
            }
            intent.putExtra("rawUrl", str3);
            intent.putExtra("k_expose_url", dae);
            intent.putExtra("k_expose_url", cZv().cWL());
            intent.putExtra("k_expose_web_scene", cZv().afH(stringExtra));
            intent.putExtra("showShare", false);
            com.tencent.mm.ui.base.h.a(cZv(), cZv().getString(R.string.gb2), "", cZv().getString(R.string.fw), cZv().getString(R.string.p7), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(7646);
                    try {
                        File dir = j.this.cZv().getDir("expose", 0);
                        dir.mkdirs();
                        String str = dir.getAbsolutePath() + "/screenshot.jpg";
                        com.tencent.mm.sdk.platformtools.d.a(bc.am(j.this.cZv()), 75, CompressFormat.JPEG, str, true);
                        intent.putExtra("k_webview_img", str);
                        com.tencent.mm.bp.d.b(j.this.cZv(), "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(7646);
                    } catch (IOException e) {
                        ab.e("MicroMsg.WebViewMenuHelper", "[oneliang]save screen shot to file error, ex = " + e.getMessage());
                        AppMethodBeat.o(7646);
                    }
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(7647);
                    com.tencent.mm.bp.d.b(j.this.cZv(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(7647);
                }
            });
            AppMethodBeat.o(7671);
        }
        str3 = null;
        afN = cZv().afN(cZv().pzf.getUrl());
        ab.d("MicroMsg.WebViewMenuHelper", "doExpose enableReportPageEvent %s", Boolean.valueOf(cZv().icz.cZT().dmm()));
        anT = bo.anT();
        ab.d("MicroMsg.WebViewMenuHelper", "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", Integer.valueOf(13377), Long.valueOf(anT), afN, cZv().pzf.getUrl(), cZv().cvF, Integer.valueOf(4), Integer.valueOf(1));
        str2 = "";
        try {
            str2 = q.encode(cZv().pzf.getUrl(), "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e3, "", new Object[0]);
        }
        h.pYm.e(13377, Long.valueOf(anT), afN, str2, cZv().cvF, Integer.valueOf(4), Integer.valueOf(1));
        if (bo.isNullOrNil(str3)) {
        }
        intent = new Intent();
        if (bo.isNullOrNil(str)) {
        }
        intent.putExtra("rawUrl", str3);
        intent.putExtra("k_expose_url", dae);
        intent.putExtra("k_expose_url", cZv().cWL());
        intent.putExtra("k_expose_web_scene", cZv().afH(stringExtra));
        intent.putExtra("showShare", false);
        com.tencent.mm.ui.base.h.a(cZv(), cZv().getString(R.string.gb2), "", cZv().getString(R.string.fw), cZv().getString(R.string.p7), false, /* anonymous class already generated */, /* anonymous class already generated */);
        AppMethodBeat.o(7671);
    }

    static /* synthetic */ boolean g(MenuItem menuItem) {
        AppMethodBeat.i(7678);
        if (menuItem.getItemId() >= Downloads.MIN_WAIT_FOR_NETWORK) {
            AppMethodBeat.o(7678);
            return true;
        }
        AppMethodBeat.o(7678);
        return false;
    }

    static /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(7681);
        com.tencent.mm.plugin.webview.b bVar = jVar.cZv().uwL;
        Context cZv = jVar.cZv();
        MMWebView mMWebView = jVar.cZv().pzf;
        String dae = jVar.cZv().dae();
        com.tencent.mm.ci.g.dOW().h(new com.tencent.mm.plugin.webview.b.AnonymousClass2(cZv, mMWebView, jVar.cZv().aYf())).b(new com.tencent.mm.plugin.webview.b.AnonymousClass1(cZv, dae));
        if (bVar.tipDialog != null && bVar.tipDialog.isShowing()) {
            bVar.tipDialog.dismiss();
            bVar.tipDialog = null;
        }
        cZv.getString(R.string.tz);
        bVar.tipDialog = com.tencent.mm.ui.base.h.b(cZv, cZv.getString(R.string.un), true, null);
        AppMethodBeat.o(7681);
    }

    static /* synthetic */ void a(j jVar, String str, String str2, int i, int i2) {
        AppMethodBeat.i(7682);
        if (jVar.cZv().icz == null) {
            ab.e("MicroMsg.WebViewMenuHelper", "startGetReadingModeInfo fail, after onDestroy");
            AppMethodBeat.o(7682);
            return;
        }
        o oVar = jVar.cZv().uvT;
        if (oVar.uxO == 0) {
            WebViewUI.d(WebViewUI.this, 673);
        }
        oVar.uxO++;
        jVar.utE = str;
        jVar.cZv().uvZ = true;
        Bundle bundle = new Bundle();
        bundle.putString("reading_mode_data_url", str);
        bundle.putString("reading_mode_data_useragent", str2);
        bundle.putInt("reading_mode_data_width", i);
        bundle.putInt("reading_mode_data_height", i2);
        bundle.putInt("webview_binder_id", jVar.cZv().hashCode());
        boolean z = false;
        try {
            z = jVar.cZv().icy.s(673, bundle);
        } catch (Exception e) {
            ab.w("MicroMsg.WebViewMenuHelper", "startGetReadingModeInfo, ex = " + e.getMessage());
        }
        ab.d("MicroMsg.WebViewMenuHelper", "startGetReadingModeInfo, doScene ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(7682);
    }

    static /* synthetic */ boolean c(j jVar, int i) {
        AppMethodBeat.i(7685);
        if (!jVar.utH || jVar.utK.contains(Integer.valueOf(i))) {
            AppMethodBeat.o(7685);
            return true;
        }
        AppMethodBeat.o(7685);
        return false;
    }
}
