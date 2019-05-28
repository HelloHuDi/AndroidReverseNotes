package com.tencent.p177mm.plugin.webview.p580ui.tools;

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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.p249m.C1766d.C1764a;
import com.tencent.p177mm.p249m.C1766d.C1765b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p612ui.base.C40671n.C36072a;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C40670b;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.C14447b;
import com.tencent.p177mm.plugin.webview.C14447b.C144482;
import com.tencent.p177mm.plugin.webview.C14447b.C144491;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C40265e;
import com.tencent.p177mm.plugin.webview.modeltools.C35618a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI.C16951o;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.GameWebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C1462219;
import com.tencent.p177mm.plugin.webview.stub.C14550a;
import com.tencent.p177mm.plugin.webview.stub.C29853b;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23306f;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.platformtools.C30292bc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4993ae;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.view.C31128d;
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

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.j */
public final class C40326j extends C35640a {
    int height;
    C36356d iHZ;
    protected Map<String, SparseBooleanArray> utA = new HashMap();
    protected Map<String, Integer> utB = new HashMap();
    C4993ae<String, Bitmap> utC = new C4993ae(12);
    HashMap<String, String> utD = new HashMap();
    String utE = "";
    public String utF;
    HashMap<String, Integer> utG = new HashMap();
    public boolean utH = true;
    public boolean utI = false;
    public boolean utJ = false;
    Set<Integer> utK = new HashSet();
    ArrayList<C1765b> utL;
    Boolean utM;
    int width;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$7 */
    class C146197 implements C30382d {
        C146197() {
        }

        /* renamed from: bV */
        public final void mo4975bV(int i, int i2) {
            AppMethodBeat.m2504i(7648);
            switch (i2) {
                case -1:
                    Bundle bundle = new Bundle();
                    bundle.putLong("fav_local_id", C40326j.this.cZv().getIntent().getLongExtra("fav_local_id", -1));
                    try {
                        if (C40326j.this.cZv().icy.mo15535aa(bundle)) {
                            C4990ab.m7416i("MicroMsg.WebViewMenuHelper", "del fav web url ok, finish webview ui");
                            C40326j.this.cZv().ulI.mo63618q("mm_del_fav", Boolean.TRUE);
                            C40326j.this.cZv().finish();
                            AppMethodBeat.m2505o(7648);
                            return;
                        }
                        C4990ab.m7420w("MicroMsg.WebViewMenuHelper", "try to del web url fail");
                        AppMethodBeat.m2505o(7648);
                        return;
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e, "", new Object[0]);
                        C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "try to del web url crash");
                        AppMethodBeat.m2505o(7648);
                        return;
                    }
                default:
                    C4990ab.m7416i("MicroMsg.WebViewMenuHelper", "do del cancel");
                    AppMethodBeat.m2505o(7648);
                    return;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$10 */
    class C2298410 implements C5279d {

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$10$1 */
        class C229851 implements AnimationListener {
            C229851() {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(7651);
                C40326j.this.cZv().uvb.setVisibility(8);
                AppMethodBeat.m2505o(7651);
            }
        }

        C2298410() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:212:0x113a  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00ef  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            int i2;
            int i3;
            Throwable e;
            int i4 = 0;
            AppMethodBeat.m2504i(7652);
            C40326j.this.utJ = false;
            C44786d c44786d;
            if (C40326j.m69175g(menuItem)) {
                C1765b c1765b = (C1765b) menuItem.getMenuInfo();
                if (c1765b != null) {
                    c44786d = C40326j.this.cZv().uhz;
                    C4990ab.m7416i("MicroMsg.JsApiHandler", "onCustomMenuClick");
                    HashMap hashMap = new HashMap();
                    hashMap.put("key", c1765b.key);
                    hashMap.put("title", c1765b.title);
                    c44786d.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:custom", hashMap, c44786d.uFv, c44786d.uFw) + ")", null);
                }
                AppMethodBeat.m2505o(7652);
                return;
            }
            String stringExtra;
            String stringExtra2;
            String stringExtra3;
            C40265e cYc;
            C40265e cYc2;
            C40326j c40326j;
            C40326j c40326j2;
            C40326j c40326j3;
            C44786d c44786d2;
            Intent intent;
            Bundle JL;
            Bundle bundle;
            switch (menuItem.getItemId()) {
                case 1:
                    stringExtra = C40326j.this.cZv().getIntent().getStringExtra("KPublisherId");
                    stringExtra2 = C40326j.this.cZv().getIntent().getStringExtra("KAppId");
                    stringExtra3 = C40326j.this.cZv().getIntent().getStringExtra("srcUsername");
                    cYc = C40326j.this.cZv().ulI.cYc();
                    cYc.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(1), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                    cYc.mo63622b(C40326j.this.cZv().icy);
                    C40326j.this.cZv().uvr = C40326j.this.cZv().icz.cZT().dmm();
                    C40326j.this.cZv().clH();
                    AppMethodBeat.m2505o(7652);
                    return;
                case 2:
                    stringExtra = C40326j.this.cZv().getIntent().getStringExtra("KPublisherId");
                    stringExtra2 = C40326j.this.cZv().getIntent().getStringExtra("KAppId");
                    stringExtra3 = C40326j.this.cZv().getIntent().getStringExtra("srcUsername");
                    cYc = C40326j.this.cZv().ulI.cYc();
                    cYc.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(2), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                    cYc.mo63622b(C40326j.this.cZv().icy);
                    C40326j.this.cZv().uvr = C40326j.this.cZv().icz.cZT().dmm();
                    if (C40326j.this.utG.containsKey(C40326j.this.cZv().pzf.getUrl())) {
                        i4 = ((Integer) C40326j.this.utG.get(C40326j.this.cZv().pzf.getUrl())).intValue();
                    }
                    C40326j.m69166a(C40326j.this, i4);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 3:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(3), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C7060h.pYm.mo8378a(157, 6, 1, false);
                    C40326j.this.cZv().uvr = C40326j.this.cZv().icz.cZT().dmm();
                    C40326j.this.cZO();
                    AppMethodBeat.m2505o(7652);
                    return;
                case 5:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(4), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    stringExtra = (String) C40326j.this.cZv().uwb.get(C40326j.this.cZv().pzf.getUrl());
                    if (stringExtra == null) {
                        stringExtra = C40326j.this.cZv().getIntent().getStringExtra("srcUsername");
                    }
                    c40326j = C40326j.this;
                    stringExtra3 = "Contact_Scene";
                    if (c40326j.cZv().uhz != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt(stringExtra3, 43);
                        c44786d = c40326j.cZv().uhz;
                        try {
                            c44786d.icy.mo15526a(21, bundle2, c44786d.uqj);
                        } catch (Exception e2) {
                            C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                            C4990ab.m7420w("MicroMsg.JsApiHandler", "updateJsapiArgsBundleKV, ex = ".concat(String.valueOf(e2)));
                        }
                    }
                    C40326j.this.cZv().afK(stringExtra);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 6:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(5), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    c40326j2 = C40326j.this;
                    if (c40326j2.cZv().pzf == null) {
                        C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "copyLink fail, viewWV is null");
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                    CharSequence url = c40326j2.cZv().pzf.getUrl();
                    if (url == null || url.length() == 0) {
                        C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "copyLink fail, url is null");
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                    CharSequence aek;
                    try {
                        aek = c40326j2.cZv().icy.aek(url);
                    } catch (Exception e3) {
                        C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "copy link failed");
                        aek = url;
                    }
                    ClipboardManager clipboardManager = (ClipboardManager) c40326j2.cZv().getApplication().getSystemService("clipboard");
                    if (clipboardManager != null) {
                        try {
                            clipboardManager.setText(aek);
                            Toast.makeText(c40326j2.cZv(), c40326j2.cZv().getString(C25738R.string.g1w), 0).show();
                            AppMethodBeat.m2505o(7652);
                            return;
                        } catch (Exception e4) {
                            C4990ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e4, "clip.setText error", new Object[0]);
                            AppMethodBeat.m2505o(7652);
                            return;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "clipboard manager is null");
                    AppMethodBeat.m2505o(7652);
                    return;
                case 7:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(13), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    WebViewUI cZv = C40326j.this.cZv();
                    C46434d c46434d = cZv.icy;
                    if (!cZv.isFinishing()) {
                        stringExtra = cZv.dae();
                        if (C5046bo.isNullOrNil(stringExtra)) {
                            C4990ab.m7412e("MicroMsg.BrowserChooserHelper", "open in browser fail, url is null");
                            AppMethodBeat.m2505o(7652);
                            return;
                        }
                        if (c46434d != null) {
                            try {
                                stringExtra = c46434d.aek(stringExtra);
                            } catch (Exception e5) {
                                C4990ab.m7413e("MicroMsg.BrowserChooserHelper", "showAndOpenInBrowser, getShareUrl, exception = %s", e5);
                            }
                        }
                        if (!(stringExtra.startsWith("http://") || stringExtra.startsWith("https://"))) {
                            stringExtra = "http://".concat(String.valueOf(stringExtra));
                        }
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(stringExtra));
                        try {
                            if (C5046bo.m7558gT(cZv) || C5059g.dnY()) {
                                cZv.startActivity(intent2);
                                AppMethodBeat.m2505o(7652);
                                return;
                            }
                            cZv.startActivityForResult(C35618a.m58461a(cZv, intent2, stringExtra), 2);
                            AppMethodBeat.m2505o(7652);
                            return;
                        } catch (Exception e42) {
                            C4990ab.m7413e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", e42.getMessage());
                        }
                    }
                    AppMethodBeat.m2505o(7652);
                    return;
                case 8:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(15), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    c40326j3 = C40326j.this;
                    c40326j3.cZv().uhz.mo71910bJ("sendEmail", true);
                    c44786d2 = c40326j3.cZv().uhz;
                    if (c44786d2.ready) {
                        c44786d2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:share:email", new HashMap(), c44786d2.uFv, c44786d2.uFw) + ")", null);
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.JsApiHandler", "onSendMail fail, not ready");
                    AppMethodBeat.m2505o(7652);
                    return;
                case 9:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(7), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j c40326j4 = C40326j.this;
                    C30379h.m48419a(c40326j4.cZv(), c40326j4.cZv().getString(C25738R.string.f9089p5), null, null, c40326j4.cZv().getString(C25738R.string.f9088p4), new C146197());
                    AppMethodBeat.m2505o(7652);
                    return;
                case 10:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(11), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.this.afG(null);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 11:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(8), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    if (C40326j.this.cZv().uvb.getVisibility() == 8) {
                        C40326j.this.cZv().uvb.startAnimation(AnimationUtils.loadAnimation(C40326j.this.cZv(), C25738R.anim.f8336b9));
                        C40326j.this.cZv().uvb.setVisibility(0);
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                    Animation loadAnimation = AnimationUtils.loadAnimation(C40326j.this.cZv(), C25738R.anim.f8337b_);
                    loadAnimation.setAnimationListener(new C229851());
                    C40326j.this.cZv().uvb.startAnimation(loadAnimation);
                    C40326j.this.cZv().uvb.setVisibility(8);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 12:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(6), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    intent = new Intent();
                    intent.putExtra("key_fav_scene", 2);
                    intent.putExtra("key_fav_item_id", C40326j.this.cZv().getIntent().getLongExtra("fav_local_id", -1));
                    C39037b.m66371b(C40326j.this.cZv(), ".ui.FavTagEditUI", intent);
                    C40326j.this.cZv().ulI.aeG("mm_edit_fav_count");
                    AppMethodBeat.m2505o(7652);
                    return;
                case 14:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(9), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    if (C40326j.this.cZv().uvZ) {
                        C40326j.m69168a(C40326j.this, C40326j.this.utE);
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                    C40326j.m69169a(C40326j.this, C40326j.this.cZv().pzf.getUrl(), C40326j.this.cZv().pzf.getSettings().getUserAgentString(), C40326j.this.width, C40326j.this.height);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 15:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(19), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.m69167a(C40326j.this, menuItem);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 16:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(21), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.m69167a(C40326j.this, menuItem);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 17:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(20), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.m69167a(C40326j.this, menuItem);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 18:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(22), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.m69167a(C40326j.this, menuItem);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 19:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(23), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.m69167a(C40326j.this, menuItem);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 20:
                    C40326j.this.cZv().uvr = C40326j.this.cZv().icz.cZT().dmm();
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(17), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    c40326j3 = C40326j.this;
                    c40326j3.cZv().uhz.mo71910bJ("shareQQ", true);
                    c44786d2 = c40326j3.cZv().uhz;
                    if (c44786d2.ready) {
                        JL = c44786d2.mo71878JL(1);
                        if (JL == null || !JL.getBoolean("WebViewShare_reslut", false)) {
                            c44786d2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:share:qq", new HashMap(), c44786d2.uFv, c44786d2.uFw) + ")", null);
                            AppMethodBeat.m2505o(7652);
                            return;
                        }
                        c44786d2.mo71930h(JL, "shareQQ");
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.JsApiHandler", "onShareQQ fail, not ready");
                    AppMethodBeat.m2505o(7652);
                    return;
                case 21:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(18), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    c40326j3 = C40326j.this;
                    c40326j3.cZv().uhz.mo71910bJ("shareWeiboApp", true);
                    c44786d2 = c40326j3.cZv().uhz;
                    if (c44786d2.ready) {
                        c44786d2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:share:weiboApp", new HashMap(), c44786d2.uFv, c44786d2.uFw) + ")", null);
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.JsApiHandler", "onShareWeiboApp fail, not ready");
                    AppMethodBeat.m2505o(7652);
                    return;
                case 22:
                    C40326j.this.cZv().uvr = C40326j.this.cZv().icz.cZT().dmm();
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(24), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    c40326j3 = C40326j.this;
                    c40326j3.cZv().uhz.mo71910bJ("shareQZone", true);
                    c44786d2 = c40326j3.cZv().uhz;
                    if (c44786d2.ready) {
                        JL = c44786d2.mo71878JL(1);
                        if (JL == null || !JL.getBoolean("WebViewShare_reslut", false)) {
                            c44786d2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:share:QZone", new HashMap(), c44786d2.uFv, c44786d2.uFw) + ")", null);
                            AppMethodBeat.m2505o(7652);
                            return;
                        }
                        c44786d2.mo71930h(JL, "shareQZone");
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.JsApiHandler", "onShareQzone fail, not ready");
                    AppMethodBeat.m2505o(7652);
                    return;
                case 23:
                    intent = new Intent();
                    stringExtra2 = C40326j.this.cZv().getIntent().getStringExtra("sns_local_id");
                    if (stringExtra2 != null) {
                        intent.putExtra("sns_send_data_ui_activity", true);
                        intent.putExtra("sns_local_id", stringExtra2);
                    } else {
                        intent.putExtra("Retr_Msg_Id", Long.valueOf(C40326j.this.cZv().getIntent().getLongExtra("msg_id", Long.MIN_VALUE)));
                    }
                    C25985d.m41473f(C40326j.this.cZv(), ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 24:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(16), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    c40326j = C40326j.this;
                    try {
                        bundle = new Bundle();
                        bundle.putString("enterprise_action", "enterprise_connectors");
                        ArrayList stringArrayList = c40326j.cZv().icy.mo15575g(71, bundle).getStringArrayList("enterprise_connectors");
                        if (stringArrayList == null || stringArrayList.size() <= 0) {
                            AppMethodBeat.m2505o(7652);
                            return;
                        } else if (stringArrayList.size() == 1) {
                            c40326j.afF((String) stringArrayList.get(0));
                            AppMethodBeat.m2505o(7652);
                            return;
                        } else {
                            c40326j.mo63692ec(stringArrayList);
                            C46696j c46696j = new C46696j(c40326j.cZv());
                            c46696j.mo75005a(c40326j.cZv().pzf, c40326j.cZv(), null);
                            c46696j.zFT = new C2992916();
                            c46696j.zFU = new C356852();
                            c46696j.mo75009b(c40326j.cZv().pzf, new C403253(stringArrayList), new C299304());
                            c46696j.cuu();
                            AppMethodBeat.m2505o(7652);
                            return;
                        }
                    } catch (Exception e422) {
                        C4990ab.m7420w("MicroMsg.WebViewMenuHelper", "builder add, ex = " + e422.getMessage());
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                case 25:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(26), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    c40326j3 = C40326j.this;
                    c40326j3.cZv().uhz.mo71910bJ("sendAppMessage", true);
                    c44786d2 = c40326j3.cZv().uhz;
                    if (c44786d2.ready) {
                        c44786d2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:share:appmessage", new HashMap(), c44786d2.uFv, c44786d2.uFw) + ")", null);
                        try {
                            c44786d2.icy.mo15522L("scene", "wework", c44786d2.uqj);
                            AppMethodBeat.m2505o(7652);
                            return;
                        } catch (Exception e4222) {
                            C4990ab.m7420w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e4222.getMessage());
                            AppMethodBeat.m2505o(7652);
                            return;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.JsApiHandler", "onShareWeWork fail, not ready");
                    AppMethodBeat.m2505o(7652);
                    return;
                case 26:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(27), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    c40326j2 = C40326j.this;
                    stringExtra = null;
                    try {
                        stringExtra = c40326j2.cZv().icy.aek(c40326j2.cZv().pzf.getUrl());
                    } catch (Exception e22) {
                        C4990ab.m7413e("MicroMsg.WebViewMenuHelper", "getShareUrl failed : %s", e22.getMessage());
                    }
                    if (C5046bo.isNullOrNil(stringExtra)) {
                        stringExtra = c40326j2.cZv().cOG;
                    }
                    try {
                        stringExtra = "weread://mp?url=" + C18178q.encode(stringExtra, ProtocolPackage.ServerEncoding);
                    } catch (Exception e222) {
                        C4990ab.m7413e("MicroMsg.WebViewMenuHelper", "encode url failed ; %s", e222.getMessage());
                    }
                    C4990ab.m7417i("MicroMsg.WebViewMenuHelper", "now url = %s", stringExtra);
                    Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(stringExtra));
                    intent3.addFlags(268435456);
                    if (C5046bo.m7572k(c40326j2.cZv(), intent3)) {
                        c40326j2.cZv().startActivity(intent3);
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "not availble app match this intent");
                    AppMethodBeat.m2505o(7652);
                    return;
                case 27:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(32), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    if (!C40326j.this.cZv().cWG()) {
                        C40326j.this.cZv().finish();
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                    break;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(10), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.this.cZv().aYe();
                    AppMethodBeat.m2505o(7652);
                    return;
                case 29:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(31), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.this.cZR();
                    AppMethodBeat.m2505o(7652);
                    return;
                case 31:
                    C7060h.pYm.mo8378a(480, 1, 1, false);
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(28), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    if (!C40326j.this.cZv().uvj.isShown()) {
                        C40326j.this.cZv().uvj.reset();
                        C40326j.this.cZv().uvj.dcX();
                        C40326j.this.cZv().uvj.show();
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                    break;
                case 33:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(14), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    c40326j3 = C40326j.this;
                    c40326j3.cZv().uhz.mo71910bJ("sendAppMessage", true);
                    c44786d2 = c40326j3.cZv().uhz;
                    if (c44786d2.ready) {
                        c44786d2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:share:appmessage", new HashMap(), c44786d2.uFv, c44786d2.uFw) + ")", null);
                        try {
                            c44786d2.icy.mo15522L("scene", "facebook", c44786d2.uqj);
                            AppMethodBeat.m2505o(7652);
                            return;
                        } catch (Exception e42222) {
                            C4990ab.m7420w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e42222.getMessage());
                            AppMethodBeat.m2505o(7652);
                            return;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.JsApiHandler", "onShareFaceBook fail, not ready");
                    AppMethodBeat.m2505o(7652);
                    return;
                case 34:
                    c40326j3 = C40326j.this;
                    C4990ab.m7416i("MicroMsg.WebViewMenuHelper", "JumpToReadArticle");
                    if (c40326j3.cZv().uhz != null) {
                        c44786d2 = c40326j3.cZv().uhz;
                        if (c44786d2.ready) {
                            C4990ab.m7416i("MicroMsg.JsApiHandler", "onArticleReadBtnClicked");
                            C5004al.m7441d(new C1462219(C23124a.m35500b("onArticleReadingBtnClicked", new HashMap(), c44786d2.uFv, c44786d2.uFw)));
                        } else {
                            C4990ab.m7412e("MicroMsg.JsApiHandler", "onArticleReadBtnClicked fail, not ready");
                            AppMethodBeat.m2505o(7652);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(7652);
                    return;
                case 35:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(33), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.this.cZv().uie.mo38532nT(false);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 36:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(34), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.this.cZv().uie.mo38532nT(true);
                    AppMethodBeat.m2505o(7652);
                    return;
                case C2275g.CTRL_INDEX /*37*/:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(35), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.m69165a(C40326j.this);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 38:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(36), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.m69172b(C40326j.this, 1);
                    AppMethodBeat.m2505o(7652);
                    return;
                case 39:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(37), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    C40326j.m69172b(C40326j.this, 0);
                    AppMethodBeat.m2505o(7652);
                    return;
                default:
                    cYc2 = C40326j.this.cZv().ulI.cYc();
                    cYc2.une = new Object[]{C40326j.this.cZv().cOG, Integer.valueOf(16), Integer.valueOf(1)};
                    cYc2.mo63622b(C40326j.this.cZv().icy);
                    stringExtra3 = menuItem.getTitle();
                    if (!C5046bo.isNullOrNil(stringExtra3)) {
                        try {
                            bundle = new Bundle();
                            bundle.putString("data", stringExtra3);
                            bundle = C40326j.this.cZv().icy.mo15575g(50, bundle);
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
                            C4990ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e, "", new Object[0]);
                            i3 = i2;
                            if (i3 != 0) {
                            }
                        }
                        if (i3 != 0) {
                            c40326j3 = C40326j.this;
                            c40326j3.cZv().uhz.mo71910bJ("sendAppMessage", false);
                            c44786d2 = c40326j3.cZv().uhz;
                            if (c44786d2.ready) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("scene", "connector");
                                c44786d2.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:share:appmessage", hashMap2, c44786d2.uFv, c44786d2.uFw) + ")", null);
                                try {
                                    c44786d2.icy.mo15522L("connector_local_send", stringExtra3, c44786d2.uqj);
                                    c44786d2.icy.mo15522L("scene", "connector", c44786d2.uqj);
                                    AppMethodBeat.m2505o(7652);
                                    return;
                                } catch (Exception e422222) {
                                    C4990ab.m7420w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e422222.getMessage());
                                    break;
                                }
                            }
                            C4990ab.m7412e("MicroMsg.JsApiHandler", "onSendToConnector fail, not ready");
                            AppMethodBeat.m2505o(7652);
                            return;
                        }
                        C40326j.this.afF(stringExtra3);
                        AppMethodBeat.m2505o(7652);
                        return;
                    }
                    break;
            }
            AppMethodBeat.m2505o(7652);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$15 */
    class C2992815 implements Runnable {
        C2992815() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7656);
            if (C40326j.this.cZv().isFinishing() || C40326j.this.cZv().uwA) {
                C4990ab.m7416i("MicroMsg.WebViewMenuHelper", "tryShow bottom sheet failed, the activity has been destroyed.");
                AppMethodBeat.m2505o(7656);
                return;
            }
            C40326j.this.iHZ.cpD();
            AppMethodBeat.m2505o(7656);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$16 */
    class C2992916 implements C36072a {
        C2992916() {
        }

        /* renamed from: a */
        public final void mo5750a(ImageView imageView, MenuItem menuItem) {
            AppMethodBeat.m2504i(7657);
            if (C40326j.m69175g(menuItem)) {
                imageView.setVisibility(8);
                AppMethodBeat.m2505o(7657);
                return;
            }
            String str = menuItem.getTitle();
            if (C40326j.this.utC.get(str) == null || ((Bitmap) C40326j.this.utC.get(str)).isRecycled()) {
                C4990ab.m7420w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
                try {
                    String aff = C40326j.this.cZv().icy.aff(str);
                    if (!C5046bo.isNullOrNil(aff)) {
                        Bitmap afx = C29916g.afx(aff);
                        if (!(afx == null || afx.isRecycled())) {
                            imageView.setImageBitmap(afx);
                            C40326j.this.utC.put(str, afx);
                        }
                    }
                    AppMethodBeat.m2505o(7657);
                    return;
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + e.getMessage());
                    AppMethodBeat.m2505o(7657);
                    return;
                }
            }
            imageView.setImageBitmap((Bitmap) C40326j.this.utC.get(str));
            AppMethodBeat.m2505o(7657);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$4 */
    class C299304 implements C5279d {
        C299304() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(7645);
            C40326j.this.afF(menuItem.getTitle().toString());
            AppMethodBeat.m2505o(7645);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$2 */
    class C356852 implements C40670b {
        C356852() {
        }

        /* renamed from: a */
        public final void mo5751a(TextView textView, MenuItem menuItem) {
            AppMethodBeat.m2504i(7643);
            String str = menuItem.getTitle();
            if (textView != null) {
                CharSequence charSequence = (String) C40326j.this.utD.get(str);
                if (C5046bo.isNullOrNil(charSequence)) {
                    textView.setText(str);
                    AppMethodBeat.m2505o(7643);
                    return;
                }
                textView.setText(C44089j.m79293b(C40326j.this.cZv(), charSequence, textView.getTextSize()));
            }
            AppMethodBeat.m2505o(7643);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$12 */
    class C4032212 implements C36073c {
        C4032212() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:172:0x05a5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(7653);
            C7060h.pYm.mo8378a(480, 0, 1, false);
            c44273l.clear();
            int i;
            C44274m c44274m;
            if (C40326j.this.utM.booleanValue()) {
                int size = C40326j.this.utL.size();
                for (i = 0; i < size; i++) {
                    C1765b c1765b = (C1765b) C40326j.this.utL.get(i);
                    c44274m = (C44274m) c44273l.mo70068e(c1765b.f1236id, c1765b.title);
                    c44274m.yvW = c1765b;
                    c44274m.setIcon(null);
                    c44274m.setIcon(0);
                }
                AppMethodBeat.m2505o(7653);
                return;
            }
            try {
                LinkedList dar = C40326j.this.cZv().dar();
                if (dar != null) {
                    i = 0;
                    while (i < dar.size() && i < 8) {
                        C1764a c1764a = (C1764a) dar.get(i);
                        c44274m = null;
                        if (C8741b.INDEX.equals(C5046bo.nullAsNil(c1764a.f1235id))) {
                            c44274m = (C44274m) c44273l.mo70049a(15, C40326j.this.cZv().getString(C25738R.string.fyh), (int) C1318a.bottomsheet_icon_jd_index);
                        } else if ("categories".equals(C5046bo.nullAsNil(c1764a.f1235id))) {
                            c44274m = (C44274m) c44273l.mo70049a(16, C40326j.this.cZv().getString(C25738R.string.fyg), (int) C1318a.bottomsheet_icon_jd_collect_list);
                        } else if ("cart".equals(C5046bo.nullAsNil(c1764a.f1235id))) {
                            c44274m = (C44274m) c44273l.mo70049a(17, C40326j.this.cZv().getString(C25738R.string.fyf), (int) C1318a.bottomsheet_icon_jd_cart);
                        } else if (Scopes.PROFILE.equals(C5046bo.nullAsNil(c1764a.f1235id))) {
                            c44274m = (C44274m) c44273l.mo70049a(18, C40326j.this.cZv().getString(C25738R.string.fyj), (int) C1318a.bottomsheet_icon_profile);
                        } else if ("member".equals(C5046bo.nullAsNil(c1764a.f1235id))) {
                            c44274m = (C44274m) c44273l.mo70049a(19, C40326j.this.cZv().getString(C25738R.string.fyi), (int) C1318a.bottomsheet_icon_jd_member);
                        }
                        if (c44274m != null) {
                            c44274m.hAh = c1764a.url;
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "exception in add jd menu, " + e.getMessage());
            }
            if (C40326j.this.cZv().icz == null || C40326j.this.cZv().icz.cZS() == null) {
                C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "get permission failed");
                AppMethodBeat.m2505o(7653);
                return;
            }
            boolean mZ;
            JsapiPermissionWrapper cZS = C40326j.this.cZv().icz.cZS();
            if (C40326j.this.cZv().cWO()) {
                if (C40326j.m69174c(C40326j.this, 35) && C40326j.this.mo63678Jn(35) && !C40326j.this.cZv().uie.dbd()) {
                    c44273l.mo70049a(35, C40326j.this.cZv().getString(C25738R.string.dhw), (int) C1318a.bottomsheet_icon_webview_minimize);
                } else if (C40326j.this.mo63678Jn(36) && C40326j.this.cZv().uie.dbd()) {
                    c44273l.mo70049a(36, C40326j.this.cZv().getString(C25738R.string.dhm), (int) C1318a.bottomsheet_icon_webview_cancel_minimize);
                }
            }
            if (C40326j.m69174c(C40326j.this, 1) && C40326j.m69171a(cZS, 21) && C40326j.this.mo63678Jn(1)) {
                c44273l.mo70050a(1, C40326j.this.cZv().getString(C25738R.string.dhh), C1318a.bottomsheet_icon_transmit, C40326j.m69173b(cZS, 21));
            }
            if (C40326j.m69174c(C40326j.this, 2) && C40326j.m69171a(cZS, 23) && C40326j.this.mo63678Jn(2)) {
                c44273l.mo70050a(2, C40326j.this.cZv().getString(C25738R.string.dhi), C1318a.bottomsheet_icon_moment, C40326j.m69173b(cZS, 23));
            }
            int i2 = -1;
            int i3 = -1;
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("WebViewShare_BinderID", C40326j.this.cZv().hashCode());
                bundle.putString("WebViewShare_wv_url", C40326j.this.cZv().pzf.getUrl());
                bundle = C40326j.this.cZv().icy.mo15575g(109, bundle);
                if (bundle != null) {
                    i2 = bundle.getInt("key_hao_kan_permission", 0);
                    i3 = bundle.getInt("key_hao_kan_recommand", -1);
                }
            } catch (RemoteException e2) {
                C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "isSetHaoKan, e = " + e2.getMessage());
            }
            if (i2 == 1) {
                if (C40326j.m69174c(C40326j.this, 38) && C40326j.this.mo63678Jn(38) && i3 == 0) {
                    c44273l.mo70049a(38, C40326j.this.cZv().getString(C25738R.string.dhr), (int) C1318a.bottomsheet_icon_hao_kan);
                } else if (C40326j.this.mo63678Jn(39) && i3 == 1) {
                    c44273l.mo70049a(39, C40326j.this.cZv().getString(C25738R.string.dhj), (int) C1318a.bottomsheet_icon_cancel_hao_kan);
                }
            }
            if (C40326j.m69174c(C40326j.this, 3) && (!(C40326j.this.cZv().uvu && (C5046bo.isNullOrNil(C40326j.this.cZv().uxf) || C5046bo.isNullOrNil(C40326j.this.cZv().uxe) || C40326j.this.cZv().uxf.startsWith(C40326j.this.cZv().uxe))) && C40326j.m69171a(cZS, 323) && C40326j.this.cZQ() && C40326j.this.mo63678Jn(3))) {
                c44273l.mo70050a(3, C40326j.this.cZv().getString(C25738R.string.dcq), C1318a.bottomsheet_icon_fav, C40326j.m69173b(cZS, 323));
            }
            String stringExtra = C40326j.this.cZv().getIntent().getStringExtra("sns_local_id");
            long longExtra = C40326j.this.cZv().getIntent().getLongExtra("msg_id", Long.MIN_VALUE);
            try {
                if (C40326j.m69174c(C40326j.this, 23) && C40326j.this.cZv().icy.mo15591x(longExtra, stringExtra)) {
                    c44273l.mo70049a(23, C40326j.this.cZv().getString(C25738R.string.b6w), (int) C1318a.bottomsheet_icon_other_mode);
                }
            } catch (Exception e3) {
                C4990ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e3, "", new Object[0]);
            }
            if (C40326j.m69174c(C40326j.this, 31)) {
                c44273l.mo70049a(31, C40326j.this.cZv().getString(C25738R.string.g2s), (int) C1318a.bottomsheet_icon_search);
            }
            if (C40326j.m69174c(C40326j.this, 6) && C40326j.m69171a(cZS, 44) && C40326j.this.mo63678Jn(6)) {
                c44273l.mo70050a(6, C40326j.this.cZv().getString(C25738R.string.g1v), C1318a.bottomsheet_icon_copy, C40326j.m69173b(cZS, 44));
            }
            if (cZS.vxM != null && C40326j.this.cZv().uvu && !C5046bo.isNullOrNil(C40326j.this.cZv().uxf) && !C5046bo.isNullOrNil(C40326j.this.cZv().uxe) && C40326j.this.cZv().uxf.startsWith(C40326j.this.cZv().uxe) && C40326j.this.cZv().getIntent().getBooleanExtra("key_detail_can_delete", true) && C40326j.this.cZQ()) {
                if (C40326j.m69174c(C40326j.this, 12) && C40326j.this.mo63678Jn(12)) {
                    c44273l.mo70049a(12, C40326j.this.cZv().getString(C25738R.string.bnm), (int) C1318a.bottomsheet_icon_addtag);
                }
                if (C40326j.m69174c(C40326j.this, 9) && C40326j.this.mo63678Jn(9)) {
                    c44273l.mo70049a(9, C40326j.this.cZv().getString(C25738R.string.f9088p4), (int) C1318a.bottomsheet_icon_del);
                }
            }
            String stringExtra2 = C40326j.this.cZv().getIntent().getStringExtra("srcUsername");
            if (!C5046bo.isNullOrNil(stringExtra2)) {
                try {
                    mZ = C40326j.this.cZv().icy.mo15586mZ(stringExtra2);
                } catch (Exception e32) {
                    C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "sharebtn click fail isBizContact, ex = " + e32.getMessage());
                    mZ = false;
                }
                if (mZ) {
                    boolean mY;
                    try {
                        mY = C40326j.this.cZv().icy.mo15585mY(stringExtra2);
                    } catch (Exception e322) {
                        C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "sharebtn click fail, ex = " + e322.getMessage());
                        mY = false;
                    }
                    boolean a;
                    if (mY) {
                        a = C40326j.m69171a(cZS, 19);
                        mZ = C40326j.m69173b(cZS, 19);
                    } else {
                        a = C40326j.m69171a(cZS, 20);
                        mZ = C40326j.m69173b(cZS, 20);
                    }
                    boolean das = C40326j.this.cZv().das();
                    if (C40326j.m69174c(C40326j.this, 5) && ((a && C40326j.this.mo63678Jn(5)) || das)) {
                        i2 = mY ? C25738R.string.g26 : C25738R.string.g1x;
                        if (das) {
                            i2 = C25738R.string.g27;
                        }
                        c44273l.mo70050a(5, C40326j.this.cZv().getString(i2), C1318a.bottomsheet_icon_brand_profile, mZ);
                    }
                } else {
                    try {
                        C40326j.this.cZv().icy.afl(stringExtra2);
                    } catch (Exception e3222) {
                        C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "sharebtn click fail triggerGetContact, ex = " + e3222.getMessage());
                    }
                }
            }
            if (C40326j.m69174c(C40326j.this, 34) && C40326j.m69171a(cZS, 313) && C40326j.this.mo63678Jn(34)) {
                c44273l.mo70050a(34, C40326j.this.cZv().getString(C25738R.string.g2o), C1318a.bottomsheet_icon_reading, C40326j.m69173b(cZS, 313));
            }
            if (C40326j.m69174c(C40326j.this, 7) && C40326j.m69171a(cZS, 45) && C40326j.this.mo63678Jn(7)) {
                c44273l.mo70050a(7, C40326j.this.cZv().getString(C25738R.string.g20), C1318a.bottomsheet_icon_brower, C40326j.m69173b(cZS, 45));
            }
            if (C40326j.m69174c(C40326j.this, 37)) {
                C40326j.this.cZv();
                if (C14447b.m22672b(C40326j.this.cZv().pzf) && C40326j.this.mo63678Jn(37)) {
                    c44273l.mo70049a(37, C40326j.this.cZv().getString(C25738R.string.fz6), (int) C1318a.bottomsheet_icon_translate);
                }
            }
            if (C40326j.m69174c(C40326j.this, 24) && C40326j.m69171a(cZS, 43) && C40326j.this.mo63678Jn(24) && !C35799p.m58695u(C40326j.this.cZv(), "com.tencent.wework")) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("enterprise_action", "enterprise_has_connector");
                    bundle2 = C40326j.this.cZv().icy.mo15575g(71, bundle2);
                    if (bundle2 != null) {
                        mZ = bundle2.getBoolean("enterprise_has_connector");
                        if (mZ) {
                            c44273l.mo70050a(24, C40326j.this.cZv().getString(C25738R.string.dhy), C1318a.bottomsheet_icon_enterprise, C40326j.m69173b(cZS, 43));
                        }
                    }
                } catch (Exception e32222) {
                    C4990ab.m7420w("MicroMsg.WebViewMenuHelper", "builder add, ex = " + e32222.getMessage());
                }
                mZ = false;
                if (mZ) {
                }
            }
            if (C40326j.m69174c(C40326j.this, 11) && C40326j.m69171a(cZS, 18) && C40326j.this.mo63678Jn(11)) {
                c44273l.mo70050a(11, C40326j.this.cZv().getString(C25738R.string.dhg), C1318a.bottomsheet_icon_font, C40326j.m69173b(cZS, 18));
            }
            if (C40326j.m69174c(C40326j.this, 28) && C40326j.this.mo63678Jn(28)) {
                c44273l.mo70049a(28, C40326j.this.cZv().getString(C25738R.string.fxx), (int) C1318a.bottomsheet_icon_refresh);
            }
            if (C40326j.m69174c(C40326j.this, 14) && C40326j.m69171a(cZS, 73) && C40326j.this.mo63678Jn(14) && !C40326j.this.cZv().uvZ) {
                c44273l.mo70050a(14, C40326j.this.cZv().getString(C25738R.string.g2p), C1318a.bottomsheet_icon_reader, C40326j.m69173b(cZS, 73));
            }
            if (C40326j.m69174c(C40326j.this, 14) && C40326j.this.cZv().uvZ && C40326j.this.mo63678Jn(14)) {
                c44273l.mo70049a(14, C40326j.this.cZv().getString(C25738R.string.g2n), (int) C1318a.bottomsheet_icon_other_mode);
            }
            if (C40326j.m69174c(C40326j.this, 10) && C40326j.m69171a(cZS, 47) && C40326j.this.mo63678Jn(10)) {
                c44273l.mo70050a(10, C40326j.this.cZv().getString(C25738R.string.a9n), C1318a.bottomsheet_icon_complain, C40326j.m69173b(cZS, 47));
            }
            if (C40326j.m69174c(C40326j.this, 8) && C40326j.m69171a(cZS, 36) && C40326j.this.mo63678Jn(8)) {
                stringExtra = null;
                try {
                    stringExtra = C40326j.this.cZv().icy.cZf();
                } catch (Exception e4) {
                }
                if (C5046bo.isNullOrNil(stringExtra)) {
                    C4990ab.m7416i("MicroMsg.WebViewMenuHelper", "get mail session key is null or nil, should not show send mail menu");
                } else {
                    c44273l.mo70050a(8, C40326j.this.cZv().getString(C25738R.string.g22), C1318a.bottomsheet_icon_mail, C40326j.m69173b(cZS, 36));
                }
            }
            if (C40326j.m69174c(C40326j.this, 33) && C40326j.m69171a(cZS, 31) && C40326j.this.mo63678Jn(30)) {
                try {
                    if (C40326j.this.cZv().icy.mo15575g(78, null).getBoolean("isOpenForFaceBook", false)) {
                        c44273l.mo70050a(33, C40326j.this.cZv().getString(C25738R.string.g2y), C1318a.default_facebookapp, C40326j.m69173b(cZS, 31));
                    }
                } catch (Exception e322222) {
                    C4990ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e322222, "", new Object[0]);
                }
            }
            if (C40326j.m69174c(C40326j.this, 25) && C40326j.m69171a(cZS, (int) ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02) && WWAPIFactory.m50230jv(C40326j.this.cZv()).dTK() && C40326j.this.mo63678Jn(25)) {
                c44273l.mo70050a(25, C40326j.this.cZv().getString(C25738R.string.dhz, new Object[]{"企业微信"}), C1318a.bottomsheet_icon_wework, C40326j.m69173b(cZS, (int) ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02));
            }
            if (C40326j.m69174c(C40326j.this, 26) && C40326j.m69171a(cZS, (int) C31128d.MIC_PTU_TRANS_XINGYE) && C14550a.m22751bl(C40326j.this.cZv(), C40326j.this.cZv().pzf.getUrl()) && C40326j.this.mo63678Jn(26)) {
                c44273l.mo70050a(26, C40326j.this.cZv().getString(C25738R.string.g2v), C1318a.bottomsheet_icon_weread, C40326j.m69173b(cZS, (int) C31128d.MIC_PTU_TRANS_XINGYE));
            }
            if (C40326j.m69174c(C40326j.this, 20) && C40326j.m69171a(cZS, 91) && C14550a.m22752fq(C40326j.this.cZv()) && C40326j.this.mo63678Jn(20)) {
                c44273l.mo70050a(20, C40326j.this.cZv().getString(C25738R.string.g2z), C1318a.bottomsheet_icon_qq, C40326j.m69173b(cZS, 91));
            }
            if (C40326j.m69174c(C40326j.this, 22) && C40326j.m69171a(cZS, (int) C19394e.CTRL_INDEX) && C14550a.m22752fq(C40326j.this.cZv()) && C40326j.this.mo63678Jn(22)) {
                c44273l.mo70050a(22, C40326j.this.cZv().getString(C25738R.string.g30), C1318a.bottomsheet_icon_qzone, C40326j.m69173b(cZS, (int) C19394e.CTRL_INDEX));
            }
            try {
                if (C40326j.m69174c(C40326j.this, 0) && C40326j.m69171a(cZS, 43) && C40326j.this.mo63678Jn(0) && C40326j.this.cZv().icy.aeD()) {
                    List<CharSequence> aeC = C40326j.this.cZv().icy.aeC();
                    for (CharSequence add : aeC) {
                        c44273l.add(add);
                    }
                    C40326j.m69170a(C40326j.this, (List) aeC);
                }
            } catch (Exception e3222222) {
                C4990ab.m7420w("MicroMsg.WebViewMenuHelper", "builder add, ex = " + e3222222.getMessage());
            }
            if (C40326j.m69174c(C40326j.this, 27) && C40326j.this.cZv().uve != null && C40326j.this.cZv().uve.getVisibility() == 0) {
                c44273l.mo70049a(27, C40326j.this.cZv().getString(C25738R.string.dhq), (int) C1318a.bottomsheet_icon_exit);
            }
            stringExtra = C40326j.this.cZv().afN(C40326j.this.cZv().uxf);
            stringExtra2 = C40326j.this.cZv().getIntent().getStringExtra("shortcut_user_name");
            if (!C40326j.this.cZv().uvz && !C5046bo.isNullOrNil(stringExtra) && !C5046bo.isNullOrNil(stringExtra2) && C40326j.m69171a(cZS, 255) && C40326j.this.mo63678Jn(29) && C40326j.m69174c(C40326j.this, 29)) {
                c44273l.mo70050a(29, C40326j.this.cZv().getString(C25738R.string.dhf), C1318a.webview_add_shortcut, C40326j.m69173b(cZS, 255));
            }
            C40326j.this.utJ = true;
            C40326j.this.iHZ.dKX();
            AppMethodBeat.m2505o(7653);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$14 */
    class C4032314 implements Runnable {
        C4032314() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7655);
            if (C40326j.this.cZv().isFinishing() || C40326j.this.cZv().uwA) {
                C4990ab.m7416i("MicroMsg.WebViewMenuHelper", "tryShow bottom sheet failed, the activity has been destroyed.");
                AppMethodBeat.m2505o(7655);
                return;
            }
            C40326j.this.iHZ.cpD();
            AppMethodBeat.m2505o(7655);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$1 */
    class C403241 implements C36072a {
        C403241() {
        }

        /* renamed from: a */
        public final void mo5750a(ImageView imageView, MenuItem menuItem) {
            AppMethodBeat.m2504i(7642);
            if (C40326j.m69175g(menuItem)) {
                imageView.setVisibility(8);
                AppMethodBeat.m2505o(7642);
                return;
            }
            String str = menuItem.getTitle();
            if (C40326j.this.utC.get(str) == null || ((Bitmap) C40326j.this.utC.get(str)).isRecycled()) {
                C4990ab.m7420w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
                try {
                    String aff = C40326j.this.cZv().icy.aff(str);
                    if (!C5046bo.isNullOrNil(aff)) {
                        Bitmap afx = C29916g.afx(aff);
                        if (!(afx == null || afx.isRecycled())) {
                            imageView.setImageBitmap(afx);
                            C40326j.this.utC.put(str, afx);
                        }
                    }
                    AppMethodBeat.m2505o(7642);
                    return;
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + e.getMessage());
                    AppMethodBeat.m2505o(7642);
                    return;
                }
            }
            imageView.setImageBitmap((Bitmap) C40326j.this.utC.get(str));
            AppMethodBeat.m2505o(7642);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$3 */
    class C403253 implements OnCreateContextMenuListener {
        final /* synthetic */ ArrayList utO;

        C403253(ArrayList arrayList) {
            this.utO = arrayList;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(7644);
            Iterator it = this.utO.iterator();
            while (it.hasNext()) {
                contextMenu.add((String) it.next());
            }
            AppMethodBeat.m2505o(7644);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$9 */
    class C403279 implements C40670b {
        C403279() {
        }

        /* renamed from: a */
        public final void mo5751a(TextView textView, MenuItem menuItem) {
            AppMethodBeat.m2504i(7650);
            String str = menuItem.getTitle();
            if (textView != null) {
                CharSequence charSequence = (String) C40326j.this.utD.get(str);
                if (C5046bo.isNullOrNil(charSequence)) {
                    textView.setText(str);
                    AppMethodBeat.m2505o(7650);
                    return;
                }
                textView.setText(C44089j.m79293b(C40326j.this.cZv(), charSequence, textView.getTextSize()));
            }
            AppMethodBeat.m2505o(7650);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.j$11 */
    class C4032811 implements C15994a {
        C4032811() {
        }

        public final void onDismiss() {
            C40326j.this.utJ = false;
        }
    }

    public C40326j(WebViewUI webViewUI) {
        super(webViewUI);
        AppMethodBeat.m2504i(7658);
        this.width = webViewUI.getResources().getDisplayMetrics().widthPixels;
        this.height = webViewUI.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.m2505o(7658);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(7659);
        for (SparseBooleanArray sparseBooleanArray : this.utA.values()) {
            if (sparseBooleanArray != null) {
                sparseBooleanArray.clear();
            }
        }
        this.utA.clear();
        this.utG.clear();
        AppMethodBeat.m2505o(7659);
    }

    public final void cZI() {
        AppMethodBeat.m2504i(7660);
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
        AppMethodBeat.m2505o(7660);
    }

    public final void afE(String str) {
        AppMethodBeat.m2504i(7661);
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.utA.get(str);
        if (sparseBooleanArray == null) {
            sparseBooleanArray = new SparseBooleanArray();
            this.utA.put(str, sparseBooleanArray);
        }
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(34, true);
        }
        AppMethodBeat.m2505o(7661);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Jn */
    public final boolean mo63678Jn(int i) {
        AppMethodBeat.m2504i(7662);
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.utA.get(cZv().pzf.getUrl());
        if (sparseBooleanArray == null || !sparseBooleanArray.get(i, false)) {
            AppMethodBeat.m2505o(7662);
            return true;
        }
        AppMethodBeat.m2505o(7662);
        return false;
    }

    /* renamed from: a */
    protected static boolean m69171a(JsapiPermissionWrapper jsapiPermissionWrapper, int i) {
        AppMethodBeat.m2504i(7663);
        if (jsapiPermissionWrapper == null) {
            AppMethodBeat.m2505o(7663);
            return false;
        }
        int Lx = jsapiPermissionWrapper.mo69828Lx(i);
        if (Lx == 1 || Lx == 10) {
            AppMethodBeat.m2505o(7663);
            return true;
        }
        AppMethodBeat.m2505o(7663);
        return false;
    }

    /* renamed from: b */
    protected static boolean m69173b(JsapiPermissionWrapper jsapiPermissionWrapper, int i) {
        AppMethodBeat.m2504i(7664);
        if (jsapiPermissionWrapper == null) {
            AppMethodBeat.m2505o(7664);
            return false;
        } else if (jsapiPermissionWrapper.mo69828Lx(i) == 10) {
            AppMethodBeat.m2505o(7664);
            return true;
        } else {
            AppMethodBeat.m2505o(7664);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cZJ() {
        AppMethodBeat.m2504i(7665);
        if (this.utI) {
            this.utH = false;
            cZv().uxb = false;
            this.utI = false;
            if (this.utJ) {
                cZM();
            }
            AppMethodBeat.m2505o(7665);
            return;
        }
        AppMethodBeat.m2505o(7665);
    }

    /* renamed from: Kt */
    public final void mo63679Kt() {
        AppMethodBeat.m2504i(138038);
        if (this.utJ) {
            cZM();
        }
        AppMethodBeat.m2505o(138038);
    }

    public final void cZK() {
        AppMethodBeat.m2504i(7666);
        if (this.utJ) {
            cZM();
        }
        AppMethodBeat.m2505o(7666);
    }

    public final void cZL() {
        AppMethodBeat.m2504i(7667);
        this.utH = true;
        this.utK.clear();
        if (cZv() instanceof GameWebViewUI) {
            this.utK.add(Integer.valueOf(11));
            this.utK.add(Integer.valueOf(28));
            AppMethodBeat.m2505o(7667);
            return;
        }
        this.utK.add(Integer.valueOf(7));
        this.utK.add(Integer.valueOf(11));
        this.utK.add(Integer.valueOf(28));
        AppMethodBeat.m2505o(7667);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cZM() {
        AppMethodBeat.m2504i(7668);
        this.utL = cZN();
        boolean z = this.utL != null && this.utL.size() > 0;
        this.utM = Boolean.valueOf(z);
        if (!this.utJ) {
            if (this.utM.booleanValue()) {
                this.iHZ = new C36356d(cZv(), 1, false);
            } else {
                this.iHZ = new C36356d(cZv(), 0, true);
            }
        }
        this.iHZ.zFT = new C403241();
        this.iHZ.zFU = new C403279();
        this.iHZ.rBm = new C2298410();
        this.iHZ.zQf = new C4032811();
        this.iHZ.rBl = new C4032212();
        final String url = cZv().pzf != null ? cZv().pzf.getUrl() : null;
        if (C5046bo.isNullOrNil(url)) {
            this.iHZ.mo57242q(" ", 1);
        } else {
            String string = cZv().getString(C25738R.string.fyz, new Object[]{Uri.parse(url).getHost()});
            if (!C5046bo.isNullOrNil(this.utF)) {
                View inflate = LayoutInflater.from(cZv()).inflate(2130970229, null);
                TextView textView = (TextView) inflate.findViewById(2131822938);
                MMNeat7extView mMNeat7extView = (MMNeat7extView) inflate.findViewById(2131824646);
                this.iHZ.mo57234F(inflate, false);
                textView.setText(string);
                SpannableString g = C44089j.m79306g(mMNeat7extView.getContext(), C5046bo.nullAsNil(this.utF), (int) mMNeat7extView.getTextSize());
                mMNeat7extView.mo15921ah(g);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) g.getSpans(0, g.length(), ClickableSpan.class);
                if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                    C4990ab.m7416i("MicroMsg.WebViewMenuHelper", "terry h5 apply show");
                    C7060h.pYm.mo8381e(16337, url, Integer.valueOf(1), Integer.valueOf(0));
                    mMNeat7extView.setOnTouchListener(new C23306f(mMNeat7extView, new C30132m(mMNeat7extView.getContext())) {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.m2504i(7654);
                            boolean onTouch = super.onTouch(view, motionEvent);
                            if (onTouch) {
                                C4990ab.m7416i("MMNeatTouchListener", "terry h5 apply click");
                                C7060h.pYm.mo8381e(16337, url, Integer.valueOf(1), Integer.valueOf(1));
                            }
                            AppMethodBeat.m2505o(7654);
                            return onTouch;
                        }
                    });
                }
            } else if (!C5046bo.isNullOrNil(r0)) {
                this.iHZ.mo57242q(string, 1);
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
            C5004al.m7442n(new C2992815(), 100);
            AppMethodBeat.m2505o(7668);
            return;
        }
        cZv().uvj.hide();
        C5004al.m7442n(new C4032314(), 100);
        AppMethodBeat.m2505o(7668);
    }

    private ArrayList<C1765b> cZN() {
        AppMethodBeat.m2504i(7669);
        String url = cZv().pzf.getUrl();
        if (cZv().uwc.containsKey(url)) {
            ArrayList arrayList = (ArrayList) cZv().uwc.get(url);
            AppMethodBeat.m2505o(7669);
            return arrayList;
        }
        AppMethodBeat.m2505o(7669);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void afF(String str) {
        AppMethodBeat.m2504i(7670);
        cZv().uhz.mo71910bJ("sendAppMessage", false);
        C44786d c44786d = cZv().uhz;
        if (c44786d.ready) {
            HashMap hashMap = new HashMap();
            hashMap.put("scene", "enterprise");
            c44786d.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:share:appmessage", hashMap, c44786d.uFv, c44786d.uFw) + ")", null);
            try {
                c44786d.icy.mo15522L("connector_local_send", str, c44786d.uqj);
                c44786d.icy.mo15522L("scene", "enterprise", c44786d.uqj);
                AppMethodBeat.m2505o(7670);
                return;
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                AppMethodBeat.m2505o(7670);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
        AppMethodBeat.m2505o(7670);
    }

    /* renamed from: Jo */
    private void m69164Jo(int i) {
        AppMethodBeat.m2504i(7672);
        String afN = cZv().afN(cZv().uxh);
        if (TextUtils.isEmpty(cZv().uxh) || TextUtils.isEmpty(afN)) {
            C4990ab.m7416i("MicroMsg.WebViewMenuHelper", "stev appId is null or empty");
            AppMethodBeat.m2505o(7672);
            return;
        }
        C4990ab.m7417i("MicroMsg.WebViewMenuHelper", "stev appId %s", afN);
        long anT = C5046bo.anT();
        C4990ab.m7411d("MicroMsg.WebViewMenuHelper", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", Integer.valueOf(13377), Long.valueOf(anT), afN, cZv().uxh, cZv().cvF, Integer.valueOf(3), Integer.valueOf(i));
        String str = "";
        try {
            str = C18178q.encode(cZv().uxh, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e, "", new Object[0]);
        }
        int afH = cZv().afH(cZv().getIntent().getStringExtra("geta8key_username"));
        String str2 = "";
        if (afH == 7 || afH == 56) {
            str2 = cZv().getIntent().getStringExtra("geta8key_username");
        }
        C7060h.pYm.mo8381e(13377, Long.valueOf(anT), afN, str, cZv().cvF, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(0), str2);
        AppMethodBeat.m2505o(7672);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cZO() {
        AppMethodBeat.m2504i(7673);
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", cZv().getIntent().getLongExtra("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", cZv().getIntent().getStringExtra("sns_local_id"));
        bundle.putInt("news_svr_id", cZv().getIntent().getIntExtra("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", cZv().getIntent().getStringExtra("news_svr_tweetid"));
        bundle.putInt("message_index", cZv().getIntent().getIntExtra("message_index", 0));
        bundle.putString("rawUrl", cZv().cOG);
        if (!C5046bo.isNullOrNil(cZv().cOG) && cZv().cOG.endsWith("#rd")) {
            String substring = cZv().cOG.substring(0, cZv().cOG.length() - 3);
            if (!(C5046bo.isNullOrNil(cZv().uxh) || cZv().uxh.startsWith(substring))) {
                bundle.putString("rawUrl", cZv().uxh);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!(C5046bo.isNullOrNil(cZv().uxh) || cZv().uxh.startsWith(cZv().cOG))) {
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
            C29853b Z = cZv().icy.mo15524Z(bundle);
            if (Z.cYV()) {
                cZv().uhz.mo71910bJ("sendAppMessage", false);
                C44786d c44786d = cZv().uhz;
                HashMap cZP = cZP();
                if (c44786d.ready) {
                    Bundle JL = c44786d.mo71878JL(1);
                    if (JL == null || !JL.getBoolean("WebViewShare_reslut", false)) {
                        cZP = new HashMap();
                        cZP.put("scene", "favorite");
                        c44786d.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:share:appmessage", cZP, c44786d.uFv, c44786d.uFw) + ")", null);
                        try {
                            c44786d.icy.mo15522L("scene", "favorite", c44786d.uqj);
                        } catch (Exception e) {
                            C4990ab.m7420w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                        }
                    } else {
                        try {
                            c44786d.icy.mo15522L("scene", "favorite", c44786d.uqj);
                        } catch (Exception e2) {
                            C4990ab.m7420w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e2.getMessage());
                        }
                        c44786d.mo71930h(JL, "sendAppMessage");
                    }
                } else {
                    try {
                        c44786d.icy.mo15522L("scene", "favorite", c44786d.uqj);
                        c44786d.mo71930h(c44786d.mo71895aL(cZP), "sendAppMessage");
                    } catch (Exception e22) {
                        C4990ab.m7420w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e22.getMessage());
                    }
                }
                C4990ab.m7416i("MicroMsg.WebViewMenuHelper", "on favorite simple url");
                AppMethodBeat.m2505o(7673);
                return;
            }
            C45932c.m85258a(Z.getRet(), cZv(), cZv().mUw);
            if (Z.getRet() == 0) {
                m69164Jo(1);
                AppMethodBeat.m2505o(7673);
                return;
            }
            m69164Jo(2);
            AppMethodBeat.m2505o(7673);
        } catch (Exception e222) {
            C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "edw, favoriteUrl fail, ex = " + e222.getMessage());
            AppMethodBeat.m2505o(7673);
        }
    }

    public final HashMap<String, String> cZP() {
        AppMethodBeat.m2504i(7674);
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
            AppMethodBeat.m2505o(7674);
            return hashMap;
        }
        AppMethodBeat.m2505o(7674);
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ec */
    public final void mo63692ec(List<String> list) {
        AppMethodBeat.m2504i(7675);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(7675);
            return;
        }
        for (String str : list) {
            if (this.utC.get(str) != null) {
                C4990ab.m7417i("MicroMsg.WebViewMenuHelper", "find %s icon from cache ok", str);
            } else {
                C4990ab.m7421w("MicroMsg.WebViewMenuHelper", "not found %s icon from cache, try to load", str);
                try {
                    String aff = cZv().icy.aff(str);
                    if (!C5046bo.isNullOrNil(aff)) {
                        Bitmap afx = C29916g.afx(aff);
                        if (afx != null) {
                            C4990ab.m7416i("MicroMsg.WebViewMenuHelper", "load ok, and cache it");
                            this.utC.put(str, afx);
                        }
                    }
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + e.getMessage());
                }
            }
            if (this.utD.containsKey(str)) {
                C4990ab.m7417i("MicroMsg.WebViewMenuHelper", "find %s nick from cache ok", str);
            } else {
                C4990ab.m7421w("MicroMsg.WebViewMenuHelper", "not found %s nick from cache, try to load", str);
                Object obj = null;
                try {
                    obj = cZv().icy.mo15584mJ(str);
                    C4990ab.m7416i("MicroMsg.WebViewMenuHelper", "load nick ok");
                } catch (Exception e2) {
                    C4990ab.m7420w("MicroMsg.WebViewMenuHelper", "onAttach, ex = " + e2.getMessage());
                }
                this.utD.put(str, obj);
            }
        }
        AppMethodBeat.m2505o(7675);
    }

    /* Access modifiers changed, original: final */
    public final boolean cZQ() {
        boolean z = false;
        AppMethodBeat.m2504i(7676);
        try {
            z = cZv().icy.afj("favorite");
            AppMethodBeat.m2505o(7676);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e, "", new Object[z]);
            AppMethodBeat.m2505o(7676);
        }
        return z;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cZR() {
        AppMethodBeat.m2504i(7677);
        String afN = cZv().afN(cZv().uxf);
        String stringExtra = cZv().getIntent().getStringExtra("shortcut_user_name");
        if (C5046bo.isNullOrNil(afN) || C5046bo.isNullOrNil(stringExtra)) {
            C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "addShortcut, appid or username is null");
            AppMethodBeat.m2505o(7677);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("KAppId", afN);
        bundle.putString("shortcut_user_name", stringExtra);
        bundle.putInt("webviewui_binder_id", hashCode());
        try {
            cZv().icy.mo15575g(80, bundle);
            AppMethodBeat.m2505o(7677);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "addShortcut, e = " + e.getMessage());
            AppMethodBeat.m2505o(7677);
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
        AppMethodBeat.m2504i(7671);
        String stringExtra = cZv().getIntent().getStringExtra("geta8key_username");
        String dae = cZv().dae();
        String str3 = null;
        if (!C5046bo.isNullOrNil(dae)) {
            str3 = Uri.parse(dae).getHost();
        }
        if (!C5046bo.isNullOrNil(str3) && str3.startsWith("mp.weixin.qq.com")) {
            try {
                str3 = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", new Object[]{C18178q.encode(dae, ProtocolPackage.ServerEncoding)});
            } catch (UnsupportedEncodingException e) {
                C4990ab.m7412e("MicroMsg.WebViewMenuHelper", e.getMessage());
            }
            afN = cZv().afN(cZv().pzf.getUrl());
            C4990ab.m7411d("MicroMsg.WebViewMenuHelper", "doExpose enableReportPageEvent %s", Boolean.valueOf(cZv().icz.cZT().dmm()));
            if (!(TextUtils.isEmpty(afN) || !r1 || TextUtils.isEmpty(cZv().pzf.getUrl()))) {
                anT = C5046bo.anT();
                C4990ab.m7411d("MicroMsg.WebViewMenuHelper", "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", Integer.valueOf(13377), Long.valueOf(anT), afN, cZv().pzf.getUrl(), cZv().cvF, Integer.valueOf(4), Integer.valueOf(1));
                str2 = "";
                str2 = C18178q.encode(cZv().pzf.getUrl(), "UTF-8");
                C7060h.pYm.mo8381e(13377, Long.valueOf(anT), afN, str2, cZv().cvF, Integer.valueOf(4), Integer.valueOf(1));
            }
            if (C5046bo.isNullOrNil(str3)) {
                str3 = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)});
            }
            intent = new Intent();
            if (!C5046bo.isNullOrNil(str)) {
                try {
                    intent.putExtra("k_webview_html", Base64.encodeToString(str.getBytes("UTF-8"), 11));
                } catch (UnsupportedEncodingException e2) {
                    C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "[oneliang]html get byte error, ex = " + e2.getMessage());
                }
            }
            intent.putExtra("rawUrl", str3);
            intent.putExtra("k_expose_url", dae);
            intent.putExtra("k_expose_url", cZv().cWL());
            intent.putExtra("k_expose_web_scene", cZv().afH(stringExtra));
            intent.putExtra("showShare", false);
            C30379h.m48445a(cZv(), cZv().getString(C25738R.string.gb2), "", cZv().getString(C25738R.string.f8818fw), cZv().getString(C25738R.string.f9091p7), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(7646);
                    try {
                        File dir = C40326j.this.cZv().getDir("expose", 0);
                        dir.mkdirs();
                        String str = dir.getAbsolutePath() + "/screenshot.jpg";
                        C5056d.m7625a(C30292bc.m48193am(C40326j.this.cZv()), 75, CompressFormat.JPEG, str, true);
                        intent.putExtra("k_webview_img", str);
                        C25985d.m41467b(C40326j.this.cZv(), "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.m2505o(7646);
                    } catch (IOException e) {
                        C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "[oneliang]save screen shot to file error, ex = " + e.getMessage());
                        AppMethodBeat.m2505o(7646);
                    }
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(7647);
                    C25985d.m41467b(C40326j.this.cZv(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(7647);
                }
            });
            AppMethodBeat.m2505o(7671);
        }
        str3 = null;
        afN = cZv().afN(cZv().pzf.getUrl());
        C4990ab.m7411d("MicroMsg.WebViewMenuHelper", "doExpose enableReportPageEvent %s", Boolean.valueOf(cZv().icz.cZT().dmm()));
        anT = C5046bo.anT();
        C4990ab.m7411d("MicroMsg.WebViewMenuHelper", "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", Integer.valueOf(13377), Long.valueOf(anT), afN, cZv().pzf.getUrl(), cZv().cvF, Integer.valueOf(4), Integer.valueOf(1));
        str2 = "";
        try {
            str2 = C18178q.encode(cZv().pzf.getUrl(), "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            C4990ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", e3, "", new Object[0]);
        }
        C7060h.pYm.mo8381e(13377, Long.valueOf(anT), afN, str2, cZv().cvF, Integer.valueOf(4), Integer.valueOf(1));
        if (C5046bo.isNullOrNil(str3)) {
        }
        intent = new Intent();
        if (C5046bo.isNullOrNil(str)) {
        }
        intent.putExtra("rawUrl", str3);
        intent.putExtra("k_expose_url", dae);
        intent.putExtra("k_expose_url", cZv().cWL());
        intent.putExtra("k_expose_web_scene", cZv().afH(stringExtra));
        intent.putExtra("showShare", false);
        C30379h.m48445a(cZv(), cZv().getString(C25738R.string.gb2), "", cZv().getString(C25738R.string.f8818fw), cZv().getString(C25738R.string.f9091p7), false, /* anonymous class already generated */, /* anonymous class already generated */);
        AppMethodBeat.m2505o(7671);
    }

    /* renamed from: g */
    static /* synthetic */ boolean m69175g(MenuItem menuItem) {
        AppMethodBeat.m2504i(7678);
        if (menuItem.getItemId() >= Downloads.MIN_WAIT_FOR_NETWORK) {
            AppMethodBeat.m2505o(7678);
            return true;
        }
        AppMethodBeat.m2505o(7678);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m69165a(C40326j c40326j) {
        AppMethodBeat.m2504i(7681);
        C14447b c14447b = c40326j.cZv().uwL;
        Context cZv = c40326j.cZv();
        MMWebView mMWebView = c40326j.cZv().pzf;
        String dae = c40326j.cZv().dae();
        C41930g.dOW().mo60492h(new C144482(cZv, mMWebView, c40326j.cZv().aYf())).mo60487b(new C144491(cZv, dae));
        if (c14447b.tipDialog != null && c14447b.tipDialog.isShowing()) {
            c14447b.tipDialog.dismiss();
            c14447b.tipDialog = null;
        }
        cZv.getString(C25738R.string.f9238tz);
        c14447b.tipDialog = C30379h.m48458b(cZv, cZv.getString(C25738R.string.f9260un), true, null);
        AppMethodBeat.m2505o(7681);
    }

    /* renamed from: a */
    static /* synthetic */ void m69169a(C40326j c40326j, String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(7682);
        if (c40326j.cZv().icz == null) {
            C4990ab.m7412e("MicroMsg.WebViewMenuHelper", "startGetReadingModeInfo fail, after onDestroy");
            AppMethodBeat.m2505o(7682);
            return;
        }
        C16951o c16951o = c40326j.cZv().uvT;
        if (c16951o.uxO == 0) {
            WebViewUI.m26221d(WebViewUI.this, 673);
        }
        c16951o.uxO++;
        c40326j.utE = str;
        c40326j.cZv().uvZ = true;
        Bundle bundle = new Bundle();
        bundle.putString("reading_mode_data_url", str);
        bundle.putString("reading_mode_data_useragent", str2);
        bundle.putInt("reading_mode_data_width", i);
        bundle.putInt("reading_mode_data_height", i2);
        bundle.putInt("webview_binder_id", c40326j.cZv().hashCode());
        boolean z = false;
        try {
            z = c40326j.cZv().icy.mo15590s(673, bundle);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.WebViewMenuHelper", "startGetReadingModeInfo, ex = " + e.getMessage());
        }
        C4990ab.m7410d("MicroMsg.WebViewMenuHelper", "startGetReadingModeInfo, doScene ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(7682);
    }

    /* renamed from: c */
    static /* synthetic */ boolean m69174c(C40326j c40326j, int i) {
        AppMethodBeat.m2504i(7685);
        if (!c40326j.utH || c40326j.utK.contains(Integer.valueOf(i))) {
            AppMethodBeat.m2505o(7685);
            return true;
        }
        AppMethodBeat.m2505o(7685);
        return false;
    }
}
