package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.p210ca.C32432a;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C42013j;
import com.tencent.p177mm.p230g.p231a.C42040qg;
import com.tencent.p177mm.p249m.C1766d.C1765b;
import com.tencent.p177mm.p612ui.C5510e.C5506m;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C33279c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C38339e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C33345i;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C27077c;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b.C20024a;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.webview.C14445a;
import com.tencent.p177mm.plugin.webview.model.C22883an;
import com.tencent.p177mm.plugin.webview.model.C40259aq;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI.C16967d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI.C169746;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.GameWebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C2299761;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C230006;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C2993611;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C2993718;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C299415;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C299437;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C403384;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C4397220;
import com.tencent.p177mm.plugin.webview.p580ui.tools.p581a.C40288b;
import com.tencent.p177mm.plugin.webview.stub.C22913c;
import com.tencent.p177mm.plugin.webview.stub.C40281e.C40282a;
import com.tencent.p177mm.plugin.wepkg.C30003c;
import com.tencent.p177mm.protocal.C15045c;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5034bd;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import com.tencent.xweb.C24526c;
import com.tencent.xweb.C44576b;
import com.tencent.xweb.WebView.C44570d;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.n */
public final class C35698n extends C40282a {
    private final WeakReference<WebViewUI> uqV;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$41 */
    class C2314041 implements Runnable {
        C2314041() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7754);
            if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                AppMethodBeat.m2505o(7754);
                return;
            }
            ((WebViewUI) C35698n.this.uqV.get()).uwX.cZU();
            AppMethodBeat.m2505o(7754);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$49 */
    class C2314249 implements Runnable {
        C2314249() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7766);
            if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                AppMethodBeat.m2505o(7766);
                return;
            }
            if (((WebViewUI) C35698n.this.uqV.get()).uwf != null && ((WebViewUI) C35698n.this.uqV.get()).uwf.isShowing()) {
                ((WebViewUI) C35698n.this.uqV.get()).uwf.dismiss();
            }
            AppMethodBeat.m2505o(7766);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$38 */
    class C2995038 implements Runnable {
        C2995038() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7751);
            if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                AppMethodBeat.m2505o(7751);
                return;
            }
            ((WebViewUI) C35698n.this.uqV.get()).uwX.mo69669nM(true);
            AppMethodBeat.m2505o(7751);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$40 */
    class C2995140 implements Runnable {
        C2995140() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7753);
            if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                AppMethodBeat.m2505o(7753);
                return;
            }
            ((WebViewUI) C35698n.this.uqV.get()).uwX.stopLoading();
            AppMethodBeat.m2505o(7753);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$42 */
    class C2995242 implements Runnable {
        C2995242() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7755);
            if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                AppMethodBeat.m2505o(7755);
                return;
            }
            ((WebViewUI) C35698n.this.uqV.get()).uwX.startLoading();
            AppMethodBeat.m2505o(7755);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$43 */
    class C2995343 implements Runnable {
        C2995343() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7756);
            if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                AppMethodBeat.m2505o(7756);
                return;
            }
            WebViewUI webViewUI = (WebViewUI) C35698n.this.uqV.get();
            if (webViewUI.pzf != null) {
                webViewUI.pzf.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new C169746());
            }
            AppMethodBeat.m2505o(7756);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$39 */
    class C3569739 implements Runnable {
        C3569739() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7752);
            if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                AppMethodBeat.m2505o(7752);
                return;
            }
            ((WebViewUI) C35698n.this.uqV.get()).daj();
            AppMethodBeat.m2505o(7752);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$50 */
    class C3570450 implements Runnable {
        C3570450() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7767);
            if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                AppMethodBeat.m2505o(7767);
                return;
            }
            ((WebViewUI) C35698n.this.uqV.get()).uwe = null;
            AppMethodBeat.m2505o(7767);
        }
    }

    /* renamed from: b */
    static /* synthetic */ Intent m58534b(C35698n c35698n) {
        AppMethodBeat.m2504i(7799);
        Intent intent = c35698n.getIntent();
        AppMethodBeat.m2505o(7799);
        return intent;
    }

    public C35698n(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(7774);
        this.uqV = new WeakReference(webViewUI);
        AppMethodBeat.m2505o(7774);
    }

    /* renamed from: c */
    public final boolean mo26784c(int i, Bundle bundle) {
        AppMethodBeat.m2504i(7775);
        C4990ab.m7416i("MicroMsg.WebViewStubCallbackAIDLStub", "callback, actionCode = ".concat(String.valueOf(i)));
        final WebViewUI webViewUI = (WebViewUI) this.uqV.get();
        if (webViewUI == null || webViewUI.isFinishing()) {
            AppMethodBeat.m2505o(7775);
            return false;
        }
        final C44786d c44786d = webViewUI.uhz;
        final C40344k c40344k = webViewUI.icz;
        final String string;
        final WebViewUI webViewUI2;
        final String string2;
        final String string3;
        final boolean z;
        int length;
        final String string4;
        final Bundle bundle2;
        final String string5;
        final int i2;
        final HashMap hashMap;
        final int i3;
        switch (i) {
            case 13:
                if (bundle != null) {
                    bundle.putString("application_language", webViewUI.icy.getLanguage());
                    webViewUI.uwe = C16967d.m26292ad(bundle);
                    break;
                }
                break;
            case 15:
                string = bundle.getString("exdevice_device_id");
                final boolean z2 = bundle.getBoolean("exdevice_is_complete");
                final byte[] byteArray = bundle.getByteArray("exdevice_broadcast_data");
                final boolean z3 = bundle.getBoolean("exdevice_is_lan_device");
                webViewUI2 = webViewUI;
                final C44786d c44786d2 = c44786d;
                final C40344k c40344k2 = c40344k;
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7727);
                        if (webViewUI2 == null || webViewUI2.isFinishing()) {
                            AppMethodBeat.m2505o(7727);
                        } else if (c44786d2 != null) {
                            C44786d c44786d = c44786d2;
                            String str = string;
                            byte[] bArr = byteArray;
                            boolean z = z2;
                            boolean z2 = z3;
                            if (c44786d.ready) {
                                String str2 = "MicroMsg.JsApiHandler";
                                String str3 = "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s";
                                Object[] objArr = new Object[3];
                                objArr[0] = str;
                                objArr[1] = Boolean.valueOf(z);
                                objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                                C4990ab.m7417i(str2, str3, objArr);
                                if (C5046bo.isNullOrNil(str)) {
                                    C4990ab.m7412e("MicroMsg.JsApiHandler", "parameter error!!!");
                                    AppMethodBeat.m2505o(7727);
                                    return;
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    JSONArray jSONArray = new JSONArray();
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("deviceId", str);
                                    C40288b.dbr();
                                    if (C40288b.m69084bE(bArr) || (bArr != null && z2)) {
                                        jSONObject2.put("base64BroadcastData", Base64.encodeToString(bArr, 2));
                                    }
                                    jSONArray.put(jSONObject2);
                                    jSONObject.put("devices", jSONArray);
                                    if (z) {
                                        jSONObject.put("isCompleted", "1");
                                    } else {
                                        jSONObject.put("isCompleted", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                    }
                                } catch (Exception e) {
                                    C4990ab.m7413e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", e.getMessage());
                                }
                                try {
                                    C4990ab.m7417i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", C23124a.m35498a("onScanWXDeviceResult", jSONObject, c44786d.uFv, c44786d.uFw));
                                    c44786d.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + r0 + ")", null);
                                } catch (Exception e2) {
                                    C4990ab.m7421w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", e2.getMessage());
                                }
                                if (!z2) {
                                    C40288b.dbr().uAa = bArr;
                                }
                                AppMethodBeat.m2505o(7727);
                                return;
                            }
                            C4990ab.m7412e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
                            AppMethodBeat.m2505o(7727);
                        } else {
                            C4990ab.m7413e("MicroMsg.WebViewStubCallbackAIDLStub", "hakon can not call onScanWXDeviceResult, %s, %s", c44786d2, c40344k2);
                            AppMethodBeat.m2505o(7727);
                        }
                    }
                });
                break;
            case 16:
                string2 = bundle.getString("exdevice_device_id");
                string3 = bundle.getString("exdevice_brand_name");
                final byte[] byteArray2 = bundle.getByteArray("exdevice_data");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7728);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7728);
                            return;
                        }
                        if (c44786d != null) {
                            C44786d c44786d = c44786d;
                            String str = string2;
                            byte[] bArr = byteArray2;
                            String str2 = string3;
                            if (c44786d.ready) {
                                C4990ab.m7417i("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice: device id = %s, brandName = %s", str, str2);
                                if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || bArr == null) {
                                    C4990ab.m7412e("MicroMsg.JsApiHandler", "parameter error!!!");
                                    AppMethodBeat.m2505o(7728);
                                    return;
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put("deviceId", str);
                                hashMap.put("base64Data", Base64.encodeToString(bArr, 2));
                                C5004al.m7441d(new C403384(C23124a.m35500b("onReceiveDataFromWXDevice", hashMap, c44786d.uFv, c44786d.uFw)));
                            } else {
                                C4990ab.m7412e("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice fail, not ready");
                                AppMethodBeat.m2505o(7728);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(7728);
                    }
                });
                break;
            case 17:
                string2 = bundle.getString("exdevice_device_id");
                final boolean z4 = bundle.getBoolean("exdevice_is_bound");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7729);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7729);
                            return;
                        }
                        if (c44786d != null) {
                            C44786d c44786d = c44786d;
                            String str = string2;
                            boolean z = z4;
                            if (c44786d.ready) {
                                C4990ab.m7417i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", str, Boolean.valueOf(z));
                                if (C5046bo.isNullOrNil(str)) {
                                    C4990ab.m7412e("MicroMsg.JsApiHandler", "parameter error!!!");
                                    AppMethodBeat.m2505o(7729);
                                    return;
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put("deviceId", str);
                                if (z) {
                                    hashMap.put("state", "bind");
                                } else {
                                    hashMap.put("state", "unbind");
                                }
                                C5004al.m7441d(new C299415(C23124a.m35500b("onWXDeviceBindStateChange", hashMap, c44786d.uFv, c44786d.uFw)));
                            } else {
                                C4990ab.m7412e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
                                AppMethodBeat.m2505o(7729);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(7729);
                    }
                });
                break;
            case 18:
                z = bundle.getBoolean("exdevice_bt_state");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7730);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7730);
                            return;
                        }
                        if (c44786d != null) {
                            C44786d c44786d = c44786d;
                            boolean z = z;
                            if (c44786d.ready) {
                                C4990ab.m7417i("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange: state = %s", Boolean.valueOf(z));
                                HashMap hashMap = new HashMap();
                                if (z) {
                                    hashMap.put("state", "on");
                                } else {
                                    hashMap.put("state", "off");
                                }
                                C5004al.m7441d(new C230006(C23124a.m35500b("onWXDeviceBluetoothStateChange", hashMap, c44786d.uFv, c44786d.uFw)));
                            } else {
                                C4990ab.m7412e("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange fail, not ready");
                                AppMethodBeat.m2505o(7730);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(7730);
                    }
                });
                break;
            case 26:
            case 27:
            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case C2275g.CTRL_INDEX /*37*/:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
            case 46:
                break;
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                z = bundle.getBoolean("exdevice_lan_state");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7731);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7731);
                            return;
                        }
                        if (c44786d != null) {
                            C44786d c44786d = c44786d;
                            boolean z = z;
                            if (c44786d.ready) {
                                C4990ab.m7417i("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange: state = %s", Boolean.valueOf(z));
                                HashMap hashMap = new HashMap();
                                if (z) {
                                    hashMap.put("state", "on");
                                } else {
                                    hashMap.put("state", "off");
                                }
                                C5004al.m7441d(new C299437(C23124a.m35500b("onWXDeviceLanStateChange", hashMap, c44786d.uFv, c44786d.uFw)));
                            } else {
                                C4990ab.m7412e("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange fail, not ready");
                                AppMethodBeat.m2505o(7731);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(7731);
                    }
                });
                break;
            case 48:
                String[] stringArray = bundle.getStringArray("msgIds");
                String[] stringArray2 = bundle.getStringArray("contents");
                String[] stringArray3 = bundle.getStringArray("senders");
                int[] intArray = bundle.getIntArray("msgTypes");
                int[] intArray2 = bundle.getIntArray("msgTimes");
                final JSONArray jSONArray = new JSONArray();
                length = stringArray == null ? 0 : stringArray.length;
                for (int i4 = 0; i4 < length; i4++) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("newMsgId", stringArray[i4]);
                        jSONObject.put(C8741b.CONTENT, stringArray2[i4]);
                        jSONObject.put("sender", stringArray3[i4]);
                        jSONObject.put("msgType", intArray[i4]);
                        jSONObject.put("msgTime", intArray2[i4]);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        C4990ab.m7412e("MicroMsg.WebViewStubCallbackAIDLStub", "GetMsgProofItems exception " + e.getMessage());
                    }
                }
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7734);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7734);
                            return;
                        }
                        if (c44786d != null) {
                            C44786d c44786d = c44786d;
                            JSONArray jSONArray = jSONArray;
                            if (jSONArray == null) {
                                C4990ab.m7412e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
                                AppMethodBeat.m2505o(7734);
                                return;
                            }
                            C4990ab.m7416i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
                            HashMap hashMap = new HashMap();
                            hashMap.put("msgs", jSONArray);
                            C5004al.m7441d(new C2299761(C23124a.m35500b("onGetMsgProofItems", hashMap, c44786d.uFv, c44786d.uFw)));
                        }
                        AppMethodBeat.m2505o(7734);
                    }
                });
                break;
            case 60:
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
            case 62:
            case C31128d.MIC_AVROUND_BLUR /*119*/:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case C31128d.MIC_SketchMark /*127*/:
            case 128:
            case 130:
            case C19394e.CTRL_INDEX /*133*/:
            case C19392d.CTRL_INDEX /*134*/:
            case C44697b.CTRL_INDEX /*135*/:
            case C19395n.CTRL_INDEX /*136*/:
            case 137:
            case 138:
            case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
            case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
            case 144:
            case 145:
            case ErrorCode.NEEDDOWNLOAD_8 /*147*/:
            case 148:
            case 149:
            case 150:
            case 100001:
            case 100002:
            case 200000:
            case 200001:
            case 200002:
            case 200003:
                if (!(webViewUI == null || webViewUI.isFinishing())) {
                    webViewUI.mo9685j(i, bundle);
                    break;
                }
            case 70:
                C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, update tid = %s", bundle.getString("service_click_tid"));
                webViewUI.uwM = string4;
                webViewUI.uwN = System.currentTimeMillis();
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7738);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7738);
                            return;
                        }
                        if (webViewUI.pzf != null) {
                            C6998b.oTO.mo8094a(webViewUI.pzf, C42040qg.class);
                            if (webViewUI.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false)) {
                                C4990ab.m7416i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, test");
                                C4879a.xxA.mo10055m(new C42040qg());
                            }
                        }
                        AppMethodBeat.m2505o(7738);
                    }
                });
                break;
            case 71:
            case C33279c.CTRL_INDEX /*72*/:
                final Bundle bundle3 = bundle;
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7737);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7737);
                            return;
                        }
                        if (bundle3 != null) {
                            webViewUI.uie.afX(bundle3.getString("key_bag_icon"));
                        }
                        AppMethodBeat.m2505o(7737);
                    }
                });
                break;
            case 90:
                string4 = bundle.getString("webview_network_type");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7736);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7736);
                            return;
                        }
                        if (c44786d != null) {
                            c44786d.ags(string4);
                        }
                        AppMethodBeat.m2505o(7736);
                    }
                });
                break;
            case 1001:
                if (!webViewUI.isFinishing()) {
                    webViewUI.finish();
                    break;
                }
                break;
            case 1002:
                bundle2 = bundle;
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7713);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7713);
                            return;
                        }
                        if (!(c44786d == null || c40344k == null || c40344k.cZS() == null || !c40344k.cZS().mo69833jB(42))) {
                            c44786d.mo71933i(bundle2, "download_succ");
                        }
                        AppMethodBeat.m2505o(7713);
                    }
                });
                break;
            case 1003:
                bundle2 = bundle;
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7724);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7724);
                            return;
                        }
                        if (!(c44786d == null || c40344k == null || c40344k.cZS() == null || !c40344k.cZS().mo69833jB(42))) {
                            c44786d.mo71933i(bundle2, "download_fail");
                        }
                        AppMethodBeat.m2505o(7724);
                    }
                });
                break;
            case 1004:
                string5 = bundle.getString("exdevice_device_id");
                i2 = bundle.getInt("exdevice_on_state_change_state");
                final Boolean valueOf = Boolean.valueOf(bundle.getBoolean("exdevice_inner_call"));
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        boolean z = false;
                        AppMethodBeat.m2504i(7772);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7772);
                        } else if (c44786d != null && c40344k != null && c40344k.cZS() != null) {
                            c40344k.cZS();
                            c44786d.mo71913dG(string5, i2);
                            AppMethodBeat.m2505o(7772);
                        } else if (c44786d == null || !valueOf.booleanValue()) {
                            boolean z2;
                            String str = "MicroMsg.WebViewStubCallbackAIDLStub";
                            String str2 = "something null, %s, %s";
                            Object[] objArr = new Object[2];
                            if (c44786d == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objArr[0] = Boolean.valueOf(z2);
                            if (c40344k == null) {
                                z = true;
                            }
                            objArr[1] = Boolean.valueOf(z);
                            C4990ab.m7421w(str, str2, objArr);
                            AppMethodBeat.m2505o(7772);
                        } else {
                            c44786d.mo71913dG(string5, i2);
                            AppMethodBeat.m2505o(7772);
                        }
                    }
                });
                break;
            case 1006:
                if (c44786d != null) {
                    webViewUI2 = webViewUI;
                    final Bundle bundle4 = bundle;
                    final C40344k c40344k3 = c40344k;
                    final C44786d c44786d3 = c44786d;
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            boolean z = false;
                            AppMethodBeat.m2504i(7726);
                            if (webViewUI2 == null || webViewUI2.isFinishing()) {
                                AppMethodBeat.m2505o(7726);
                                return;
                            }
                            byte[] byteArray = bundle4.getByteArray("jsapi_control_bytes");
                            if (byteArray == null || c40344k3 == null || c40344k3.cZS() == null) {
                                String str = "MicroMsg.WebViewStubCallbackAIDLStub";
                                String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
                                Object[] objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(byteArray != null);
                                if (c40344k3 != null) {
                                    z = true;
                                }
                                objArr[1] = Boolean.valueOf(z);
                                C4990ab.m7413e(str, str2, objArr);
                            } else {
                                C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "update control bytes by preverify, %d", Integer.valueOf(byteArray.length));
                                c40344k3.cZS().vxM = byteArray;
                            }
                            if (c44786d3 != null) {
                                c44786d3.dcj();
                            }
                            AppMethodBeat.m2505o(7726);
                        }
                    });
                    break;
                }
                break;
            case 1007:
                final long j = bundle.getLong("download_manager_downloadid");
                final int i5 = bundle.getInt("download_manager_progress");
                string5 = bundle.getString("download_manager_appid", "");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7771);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7771);
                            return;
                        }
                        if (!(c44786d == null || c40344k == null || c40344k.cZS() == null || !c40344k.cZS().mo69833jB(42))) {
                            c44786d.mo71937n(string5, j, i5);
                        }
                        AppMethodBeat.m2505o(7771);
                    }
                });
                break;
            case 1008:
                bundle2 = bundle;
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7735);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7735);
                            return;
                        }
                        if (!(c44786d == null || c40344k == null || c40344k.cZS() == null || !c40344k.cZS().mo69833jB(42))) {
                            c44786d.mo71933i(bundle2, "download_removed");
                        }
                        AppMethodBeat.m2505o(7735);
                    }
                });
                break;
            case 1010:
                bundle2 = bundle;
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7747);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7747);
                            return;
                        }
                        if (!(c44786d == null || c40344k == null || c40344k.cZS() == null || !c40344k.cZS().mo69833jB(42))) {
                            c44786d.mo71933i(bundle2, "download_pause");
                        }
                        AppMethodBeat.m2505o(7747);
                    }
                });
                break;
            case 1011:
                bundle2 = bundle;
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7758);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7758);
                            return;
                        }
                        if (!(c44786d == null || c40344k == null || c40344k.cZS() == null || !c40344k.cZS().mo69833jB(42))) {
                            c44786d.mo71933i(bundle2, "download_resumed");
                        }
                        AppMethodBeat.m2505o(7758);
                    }
                });
                break;
            case 1012:
                bundle2 = bundle;
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7770);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7770);
                            return;
                        }
                        if (!(c44786d == null || c40344k == null || c40344k.cZS() == null || !c40344k.cZS().mo69833jB(42))) {
                            c44786d.mo71933i(bundle2, "download_start");
                        }
                        AppMethodBeat.m2505o(7770);
                    }
                });
                break;
            case 2002:
                hashMap = new HashMap();
                hashMap.put("err_msg", bundle.getString("playResult"));
                hashMap.put("localId", bundle.getString("localId"));
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7720);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7720);
                            return;
                        }
                        if (c44786d != null) {
                            c44786d.mo71896aM(hashMap);
                        }
                        AppMethodBeat.m2505o(7720);
                    }
                });
                break;
            case 2003:
                string2 = bundle.getString("webview_jssdk_file_item_local_id");
                i3 = bundle.getInt("webview_jssdk_file_item_progreess");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7714);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7714);
                            return;
                        }
                        if (c44786d != null) {
                            c44786d.mo71914dH(string2, i3);
                        }
                        AppMethodBeat.m2505o(7714);
                    }
                });
                break;
            case 2004:
                string2 = bundle.getString("webview_jssdk_file_item_local_id");
                i3 = bundle.getInt("webview_jssdk_file_item_progreess");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7716);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7716);
                            return;
                        }
                        if (c44786d != null) {
                            c44786d.mo71915dI(string2, i3);
                        }
                        AppMethodBeat.m2505o(7716);
                    }
                });
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                string2 = bundle.getString("webview_jssdk_file_item_local_id");
                i3 = bundle.getInt("webview_jssdk_file_item_progreess");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7717);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7717);
                            return;
                        }
                        if (c44786d != null) {
                            c44786d.mo71916dJ(string2, i3);
                        }
                        AppMethodBeat.m2505o(7717);
                    }
                });
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                string2 = bundle.getString("webview_jssdk_file_item_local_id");
                i3 = bundle.getInt("webview_jssdk_file_item_progreess");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7718);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7718);
                            return;
                        }
                        if (c44786d != null) {
                            c44786d.mo71917dK(string2, i3);
                        }
                        AppMethodBeat.m2505o(7718);
                    }
                });
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7722);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7722);
                            return;
                        }
                        webViewUI.setMMSubTitle((int) C25738R.string.fzc);
                        AppMethodBeat.m2505o(7722);
                    }
                });
                break;
            case 2008:
                hashMap = new HashMap();
                hashMap.put("localId", bundle.getString("localId"));
                hashMap.put("err_msg", bundle.getString("recordResult"));
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7723);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7723);
                            return;
                        }
                        webViewUI.setMMSubTitle(null);
                        if (c44786d != null) {
                            c44786d.mo71897aN(hashMap);
                        }
                        AppMethodBeat.m2505o(7723);
                    }
                });
                break;
            case 2009:
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7725);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7725);
                            return;
                        }
                        webViewUI.setMMSubTitle(null);
                        AppMethodBeat.m2505o(7725);
                    }
                });
                break;
            case 2010:
                string2 = bundle.getString("webview_jssdk_file_item_local_id");
                i3 = bundle.getInt("webview_jssdk_file_item_progreess");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7719);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7719);
                            return;
                        }
                        if (c44786d != null) {
                            c44786d.mo71918dL(string2, i3);
                        }
                        AppMethodBeat.m2505o(7719);
                    }
                });
                break;
            case 2011:
                string2 = bundle.getString("webview_jssdk_file_item_local_id");
                i3 = bundle.getInt("webview_jssdk_file_item_progreess");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7773);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7773);
                            return;
                        }
                        if (c44786d != null) {
                            C44786d c44786d = c44786d;
                            String str = string2;
                            int i = i3;
                            if (c44786d.ready) {
                                C4990ab.m7417i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
                                HashMap hashMap = new HashMap();
                                hashMap.put("localId", str);
                                hashMap.put("percent", Integer.valueOf(i));
                                C5004al.m7441d(new C2993611(C23124a.m35500b("onMediaFileUploadProgress", hashMap, c44786d.uFv, c44786d.uFw)));
                            } else {
                                C4990ab.m7412e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
                                AppMethodBeat.m2505o(7773);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(7773);
                    }
                });
                break;
            case 2100:
                string2 = bundle.getString("background_audio_state_player_state");
                i3 = bundle.getInt("background_audio_state_player_duration");
                string3 = bundle.getString("background_audio_state_player_src");
                final int i6 = bundle.getInt("background_audio_state_player_err_code");
                final String string6 = bundle.getString("background_audio_state_player_err_msg");
                string = bundle.getString("background_audio_state_player_src_id");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7715);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7715);
                            return;
                        }
                        if (c44786d != null) {
                            C44786d c44786d = c44786d;
                            String str = string2;
                            int i = i3;
                            String str2 = string3;
                            int i2 = i6;
                            String str3 = string6;
                            String str4 = string;
                            if (c44786d.ready) {
                                C4990ab.m7417i("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange, state : %s, duration : %d, src:%s, errCode:%d, errMsg:%s, srcId:%s", str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, str4);
                                HashMap hashMap = new HashMap();
                                hashMap.put("state", str);
                                hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
                                hashMap.put("src", str2);
                                hashMap.put("errCode", Integer.valueOf(i2));
                                hashMap.put("errMsg", str3);
                                hashMap.put("srcId ", str4);
                                C5004al.m7441d(new C2993718(C23124a.m35500b("onBackgroundAudioStateChange", hashMap, c44786d.uFv, c44786d.uFw)));
                            } else {
                                C4990ab.m7412e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, not ready");
                                AppMethodBeat.m2505o(7715);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(7715);
                    }
                });
                break;
            case WearableStatusCodes.UNKNOWN_CAPABILITY /*4007*/:
                length = bundle.getInt("nfc_key_on_touch_errcode", 0);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7721);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7721);
                            return;
                        }
                        if (c44786d != null) {
                            C44786d c44786d = c44786d;
                            int i = length;
                            if (c44786d.ready) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(i));
                                C5004al.m7441d(new C4397220(C23124a.m35500b("onNfcTouch", hashMap, c44786d.uFv, c44786d.uFw)));
                            } else {
                                C4990ab.m7412e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
                                AppMethodBeat.m2505o(7721);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(7721);
                    }
                });
                break;
            case CdnLogic.kMediaTypeStoryAudio /*40001*/:
                string4 = bundle.getString("err_msg");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7732);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7732);
                            return;
                        }
                        if (c44786d != null) {
                            c44786d.agp(string4);
                        }
                        AppMethodBeat.m2505o(7732);
                    }
                });
                break;
            case 40002:
                string2 = bundle.getString("uuid");
                i3 = bundle.getInt("major");
                i2 = bundle.getInt("minor");
                final double d = bundle.getDouble("accuracy");
                final double d2 = bundle.getDouble("rssi");
                final float f = bundle.getFloat("heading");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7733);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.m2505o(7733);
                            return;
                        }
                        if (c44786d != null) {
                            c44786d.mo71885a(string2, i3, i2, d, d2, f);
                        }
                        AppMethodBeat.m2505o(7733);
                    }
                });
                break;
            case XWalkCoreWrapper.INVOKE_RUNTIME_ID_CONTEXT_CHANGED /*80001*/:
            case 80002:
                webViewUI.mo9678t(i, bundle);
                break;
            default:
                C4990ab.m7412e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
                break;
        }
        AppMethodBeat.m2505o(7775);
        return true;
    }

    /* renamed from: a */
    public final boolean mo26780a(final C22913c c22913c) {
        AppMethodBeat.m2504i(7776);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7776);
            return false;
        }
        if (((WebViewUI) this.uqV.get()).uvS.daP() || ((WebViewUI) this.uqV.get()).uvT.daP() || ((WebViewUI) this.uqV.get()).uvU.daP() || ((WebViewUI) this.uqV.get()).uxl.cXH()) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(7739);
                    if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                        AppMethodBeat.m2505o(7739);
                        return;
                    }
                    ((WebViewUI) C35698n.this.uqV.get()).mo30968b(c22913c);
                    AppMethodBeat.m2505o(7739);
                }
            });
        }
        AppMethodBeat.m2505o(7776);
        return true;
    }

    /* renamed from: IZ */
    public final boolean mo26778IZ(final int i) {
        AppMethodBeat.m2504i(7777);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(7740);
                if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                    AppMethodBeat.m2505o(7740);
                    return;
                }
                ((WebViewUI) C35698n.this.uqV.get()).setProgressBarIndeterminateVisibility(false);
                C4990ab.m7411d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] set title pb visibility:%d", Integer.valueOf(i));
                if (i != 0) {
                    ((WebViewUI) C35698n.this.uqV.get()).uuX.finish();
                } else if (!(((WebViewUI) C35698n.this.uqV.get()).uwn || ((WebViewUI) C35698n.this.uqV.get()).uwp)) {
                    ((WebViewUI) C35698n.this.uqV.get()).uuX.start();
                    AppMethodBeat.m2505o(7740);
                    return;
                }
                AppMethodBeat.m2505o(7740);
            }
        });
        AppMethodBeat.m2505o(7777);
        return true;
    }

    /* renamed from: a */
    public final boolean mo26781a(String str, String str2, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(7778);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7778);
        } else {
            if (((WebViewUI) this.uqV.get()).uhz != null) {
                final String str3 = str;
                final String str4 = str2;
                final Bundle bundle2 = bundle;
                final boolean z2 = z;
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7741);
                        if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.m2505o(7741);
                            return;
                        }
                        ((WebViewUI) C35698n.this.uqV.get()).uhz.mo71886a(str3, str4, C29945i.m47403aq(bundle2), z2);
                        AppMethodBeat.m2505o(7741);
                    }
                });
            }
            AppMethodBeat.m2505o(7778);
        }
        return false;
    }

    public final String cYY() {
        AppMethodBeat.m2504i(7779);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7779);
            return null;
        }
        String str = ((WebViewUI) this.uqV.get()).cOG;
        AppMethodBeat.m2505o(7779);
        return str;
    }

    public final String getCurrentUrl() {
        AppMethodBeat.m2504i(7780);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7780);
            return null;
        }
        String dae = ((WebViewUI) this.uqV.get()).dae();
        AppMethodBeat.m2505o(7780);
        return dae;
    }

    public final String cYZ() {
        AppMethodBeat.m2504i(7781);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7781);
            return null;
        }
        String stringExtra = ((WebViewUI) this.uqV.get()).getIntent().getStringExtra("srcUsername");
        AppMethodBeat.m2505o(7781);
        return stringExtra;
    }

    public final int cZa() {
        AppMethodBeat.m2504i(7782);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7782);
            return 0;
        }
        int i = ((WebViewUI) this.uqV.get()).cSQ;
        AppMethodBeat.m2505o(7782);
        return i;
    }

    /* renamed from: nJ */
    public final void mo26794nJ(final boolean z) {
        AppMethodBeat.m2504i(7783);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7783);
            return;
        }
        final boolean booleanExtra = ((WebViewUI) this.uqV.get()).getIntent().getBooleanExtra("forceHideShare", false);
        C4990ab.m7411d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z), Boolean.valueOf(booleanExtra));
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(7742);
                if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                    AppMethodBeat.m2505o(7742);
                } else if (booleanExtra) {
                    if (!(((WebViewUI) C35698n.this.uqV.get()).pzf == null || C5046bo.isNullOrNil(((WebViewUI) C35698n.this.uqV.get()).pzf.getUrl()))) {
                        ((WebViewUI) C35698n.this.uqV.get()).uwa.put(((WebViewUI) C35698n.this.uqV.get()).pzf.getUrl(), Boolean.FALSE);
                    }
                    ((WebViewUI) C35698n.this.uqV.get()).mo31012nO(false);
                    AppMethodBeat.m2505o(7742);
                } else {
                    if (!(((WebViewUI) C35698n.this.uqV.get()).pzf == null || C5046bo.isNullOrNil(((WebViewUI) C35698n.this.uqV.get()).pzf.getUrl()))) {
                        ((WebViewUI) C35698n.this.uqV.get()).uwa.put(((WebViewUI) C35698n.this.uqV.get()).pzf.getUrl(), Boolean.valueOf(z));
                    }
                    ((WebViewUI) C35698n.this.uqV.get()).mo31012nO(z);
                    AppMethodBeat.m2505o(7742);
                }
            }
        });
        AppMethodBeat.m2505o(7783);
    }

    /* renamed from: nK */
    public final void mo26795nK(final boolean z) {
        AppMethodBeat.m2504i(7784);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7784);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(7743);
                if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                    AppMethodBeat.m2505o(7743);
                    return;
                }
                ((WebViewUI) C35698n.this.uqV.get()).mo31013nP(z);
                AppMethodBeat.m2505o(7743);
            }
        });
        AppMethodBeat.m2505o(7784);
    }

    public final void cZb() {
        AppMethodBeat.m2504i(7785);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7785);
            return;
        }
        if (((WebViewUI) this.uqV.get()).uhz != null) {
            ((WebViewUI) this.uqV.get()).uhz.cZb();
        }
        AppMethodBeat.m2505o(7785);
    }

    /* renamed from: W */
    public final void mo9706W(Bundle bundle) {
        AppMethodBeat.m2504i(7786);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7786);
            return;
        }
        C4990ab.m7416i("MicroMsg.WebViewStubCallbackAIDLStub", "IUIController, closeWindow");
        if (bundle != null) {
            Intent intent = new Intent();
            intent.putExtra("result_data", bundle);
            ((WebViewUI) this.uqV.get()).setResult(-1, intent);
        }
        ((WebViewUI) this.uqV.get()).finish();
        AppMethodBeat.m2505o(7786);
    }

    public final void afd(String str) {
        int i = 0;
        AppMethodBeat.m2504i(7787);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7787);
            return;
        }
        try {
            i = C5046bo.getInt(str, 0);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb, ex = " + e.getMessage());
        }
        if (((WebViewUI) this.uqV.get()).pzf == null) {
            C4990ab.m7412e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb fail, viewWV is null");
            AppMethodBeat.m2505o(7787);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(7744);
                if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                    AppMethodBeat.m2505o(7744);
                    return;
                }
                ((WebViewUI) C35698n.this.uqV.get()).mo30945Jw(i);
                AppMethodBeat.m2505o(7744);
            }
        });
        AppMethodBeat.m2505o(7787);
    }

    public final void cZc() {
        AppMethodBeat.m2504i(7788);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7788);
            return;
        }
        if (((WebViewUI) this.uqV.get()).uhz != null) {
            ((WebViewUI) this.uqV.get()).uhz.cZc();
        }
        AppMethodBeat.m2505o(7788);
    }

    /* renamed from: e */
    public final void mo6225e(String str, final String str2, int i, int i2) {
        AppMethodBeat.m2504i(7789);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7789);
            return;
        }
        C4990ab.m7410d("MicroMsg.WebViewStubCallbackAIDLStub", "result: ".concat(String.valueOf(str2)));
        if (((WebViewUI) this.uqV.get()).uwH.icE == null || str == null || !str.equals(((WebViewUI) this.uqV.get()).uwH.icE.upr)) {
            AppMethodBeat.m2505o(7789);
            return;
        }
        if (((WebViewUI) this.uqV.get()).uwH.icE != null) {
            ((WebViewUI) this.uqV.get()).uwH.icE.cYK();
        }
        ((WebViewUI) this.uqV.get()).uwH.icC = i;
        ((WebViewUI) this.uqV.get()).uwH.icD = i2;
        if (str2 == null || ((WebViewUI) this.uqV.get()).icA == null) {
            AppMethodBeat.m2505o(7789);
            return;
        }
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$33$1 */
            class C357021 implements OnCreateContextMenuListener {
                C357021() {
                }

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    AppMethodBeat.m2504i(7745);
                    if (((WebViewUI) C35698n.this.uqV.get()).uwH.icF != null) {
                        C4990ab.m7410d("MicroMsg.WebViewStubCallbackAIDLStub", "show webkit menu");
                        ((WebViewUI) C35698n.this.uqV.get()).uwH.mo74663b(contextMenu, ((WebViewUI) C35698n.this.uqV.get()).uwH.icF);
                        ((WebViewUI) C35698n.this.uqV.get()).uwH.icF = null;
                        AppMethodBeat.m2505o(7745);
                        return;
                    }
                    if (((WebViewUI) C35698n.this.uqV.get()).uwH.icG != null) {
                        C4990ab.m7410d("MicroMsg.WebViewStubCallbackAIDLStub", "show IX5 menu");
                        ((WebViewUI) C35698n.this.uqV.get()).uwH.mo74662a(contextMenu, ((WebViewUI) C35698n.this.uqV.get()).uwH.icG);
                        ((WebViewUI) C35698n.this.uqV.get()).uwH.icG = null;
                    }
                    AppMethodBeat.m2505o(7745);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(7746);
                if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing() || ((WebViewUI) C35698n.this.uqV.get()).pzf == null) {
                    AppMethodBeat.m2505o(7746);
                    return;
                }
                ((WebViewUI) C35698n.this.uqV.get()).uwH.icB = str2;
                ((WebViewUI) C35698n.this.uqV.get()).icA.mo75009b(((WebViewUI) C35698n.this.uqV.get()).pzf, new C357021(), null);
                ((WebViewUI) C35698n.this.uqV.get()).icA.cuu();
                AppMethodBeat.m2505o(7746);
            }
        });
        AppMethodBeat.m2505o(7789);
    }

    /* renamed from: q */
    public final void mo26797q(final int i, final Bundle bundle) {
        AppMethodBeat.m2504i(7790);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7790);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(7748);
                if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing() || ((WebViewUI) C35698n.this.uqV.get()).pzf == null) {
                    AppMethodBeat.m2505o(7748);
                    return;
                }
                C4990ab.m7416i("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible, actionCode = " + i);
                HashSet<Object> hashSet = new HashSet();
                if (i == 3003 || i == 3004) {
                    hashSet.add("menuItem:share:brand");
                    hashSet.add("menuItem:share:appMessage");
                    hashSet.add("menuItem:share:dataMessage");
                    hashSet.add("menuItem:share:timeline");
                    hashSet.add("menuItem:favorite");
                    hashSet.add("menuItem:profile");
                    hashSet.add("menuItem:addContact");
                    hashSet.add("menuItem:copyUrl");
                    hashSet.add("menuItem:openWithSafari");
                    hashSet.add("menuItem:share:email");
                    hashSet.add("menuItem:delete");
                    hashSet.add("menuItem:editTag");
                    hashSet.add("menuItem:readMode");
                    hashSet.add("menuItem:originPage");
                    hashSet.add("menuItem:share:qq");
                    hashSet.add("menuItem:share:weiboApp");
                    hashSet.add("menuItem:share:QZone");
                    hashSet.add("menuItem:share:Facebook");
                    hashSet.add("menuItem:share:enterprise");
                    hashSet.add("menuItem:share:wework");
                    hashSet.add("menuItem:share:weread");
                    hashSet.add("menuItem:addShortcut");
                } else if (bundle == null) {
                    C4990ab.m7420w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible data is null.");
                    AppMethodBeat.m2505o(7748);
                    return;
                } else {
                    ArrayList stringArrayList = bundle.getStringArrayList("menu_item_list");
                    if (stringArrayList == null || stringArrayList.size() == 0) {
                        C4990ab.m7420w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible menuItems is null or nil.");
                        AppMethodBeat.m2505o(7748);
                        return;
                    }
                    hashSet.addAll(stringArrayList);
                    hashSet.remove("menuItem:exposeArticle");
                    hashSet.remove("menuItem:setFont");
                    hashSet.remove("menuItem:keepTop");
                    hashSet.remove("menuItem:cancelKeepTop");
                    hashSet.remove("menuItem:profile");
                    hashSet.remove("menuItem:addContact");
                    hashSet.remove("menuItem:refresh");
                }
                String url = ((WebViewUI) C35698n.this.uqV.get()).pzf.getUrl();
                SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) ((WebViewUI) C35698n.this.uqV.get()).uwI.utA.get(url);
                switch (i) {
                    case 3001:
                    case 3003:
                        SparseBooleanArray sparseBooleanArray2;
                        if (sparseBooleanArray == null) {
                            sparseBooleanArray2 = new SparseBooleanArray();
                            ((WebViewUI) C35698n.this.uqV.get()).uwI.utA.put(url, sparseBooleanArray2);
                        } else {
                            sparseBooleanArray2 = sparseBooleanArray;
                        }
                        for (Object obj : hashSet) {
                            int a = C5046bo.m7512a((Integer) ((WebViewUI) C35698n.this.uqV.get()).uwI.utB.get(obj), -1);
                            if (a >= 0) {
                                sparseBooleanArray2.put(a, true);
                            }
                        }
                        ((WebViewUI) C35698n.this.uqV.get()).uwI.mo63679Kt();
                        AppMethodBeat.m2505o(7748);
                        return;
                    case 3002:
                    case 3004:
                        if (sparseBooleanArray != null) {
                            for (Object obj2 : hashSet) {
                                int a2 = C5046bo.m7512a((Integer) ((WebViewUI) C35698n.this.uqV.get()).uwI.utB.get(obj2), -1);
                                if (a2 >= 0) {
                                    sparseBooleanArray.delete(a2);
                                }
                            }
                            ((WebViewUI) C35698n.this.uqV.get()).uwI.mo63679Kt();
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(7748);
            }
        });
        AppMethodBeat.m2505o(7790);
    }

    /* renamed from: hd */
    public final void mo26792hd(final String str, String str2) {
        AppMethodBeat.m2504i(7791);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(7749);
                if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                    AppMethodBeat.m2505o(7749);
                } else if (C5046bo.isNullOrNil(((WebViewUI) C35698n.this.uqV.get()).pzf.getUrl())) {
                    C4990ab.m7416i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, null url");
                    AppMethodBeat.m2505o(7749);
                } else {
                    C4990ab.m7416i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, userName = " + str);
                    ((WebViewUI) C35698n.this.uqV.get()).uwb.put(((WebViewUI) C35698n.this.uqV.get()).pzf.getUrl(), str);
                    AppMethodBeat.m2505o(7749);
                }
            }
        });
        AppMethodBeat.m2505o(7791);
    }

    private Intent getIntent() {
        AppMethodBeat.m2504i(7792);
        Intent intent = ((WebViewUI) this.uqV.get()).getIntent();
        AppMethodBeat.m2505o(7792);
        return intent;
    }

    private int afH(String str) {
        AppMethodBeat.m2504i(7793);
        int afH = ((WebViewUI) this.uqV.get()).afH(str);
        AppMethodBeat.m2505o(7793);
        return afH;
    }

    /* renamed from: g */
    public final Bundle mo6226g(int i, final Bundle bundle) {
        AppMethodBeat.m2504i(7794);
        C4990ab.m7416i("MicroMsg.WebViewStubCallbackAIDLStub", "invokeAsResult, actionCode = ".concat(String.valueOf(i)));
        final Bundle bundle2 = new Bundle();
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7794);
            return bundle2;
        }
        C40344k c40344k = ((WebViewUI) this.uqV.get()).icz;
        Intent intent;
        int afH;
        WebViewUI webViewUI;
        final String string;
        final String string2;
        String string3;
        int i2;
        final String string4;
        final boolean z;
        final int bx;
        final int afy;
        CharSequence mMTitle;
        boolean z2;
        int i3;
        String string5;
        switch (i) {
            case 11:
                C5004al.m7441d(new C2314249());
                break;
            case 12:
                C5004al.m7441d(new C3570450());
                break;
            case 18:
                bundle2.putString("KPublisherId", ((WebViewUI) this.uqV.get()).cMm);
                intent = getIntent();
                if (intent != null) {
                    afH = afH(getIntent().getStringExtra("geta8key_username"));
                    bundle2.putString("preChatName", intent.getStringExtra("preChatName"));
                    bundle2.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
                    bundle2.putString("prePublishId", intent.getStringExtra("prePublishId"));
                    bundle2.putString("preUsername", intent.getStringExtra("preUsername"));
                    bundle2.putInt("getA8KeyScene", afH);
                    bundle2.putString("referUrl", ((WebViewUI) this.uqV.get()).unr);
                    bundle2.putString("url", ((WebViewUI) this.uqV.get()).dae());
                    bundle2.putString("rawUrl", ((WebViewUI) this.uqV.get()).cOG);
                    bundle2.putInt("preChatTYPE", getIntent().getIntExtra("preChatTYPE", 0));
                    webViewUI = (WebViewUI) this.uqV.get();
                    if (((C20023b) C1720g.m3528K(C20023b.class)).mo6748FC(webViewUI.cWL())) {
                        bundle2.putInt("_DATA_CENTER_ITEM_SHOW_TYPE", webViewUI.uvq);
                        break;
                    }
                }
                break;
            case 22:
                bundle2.putInt("pay_channel", getIntent().getIntExtra("pay_channel", -1));
                C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "key value: pay channel(%d)", Integer.valueOf(getIntent().getIntExtra("pay_channel", -1)));
                break;
            case 25:
                bundle2.putInt("scene", getIntent().getIntExtra("scene", -1));
                C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: Scene(%d)", Integer.valueOf(getIntent().getIntExtra("scene", 0)));
                break;
            case 33:
                intent = getIntent();
                if (intent != null) {
                    bundle2.putString("publishIdPrefix", intent.getStringExtra("publishIdPrefix"));
                    bundle2.putString("reportSessionId", intent.getStringExtra("reportSessionId"));
                    break;
                }
                break;
            case 34:
                C5004al.m7441d(new C3569739());
                break;
            case 35:
                C5004al.m7441d(new C2995242());
                break;
            case 36:
                C5004al.m7441d(new C2995140());
                break;
            case C2275g.CTRL_INDEX /*37*/:
                string = bundle.getString("show_kb_placeholder");
                afH = bundle.getInt("show_kb_max_length");
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7757);
                        if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.m2505o(7757);
                            return;
                        }
                        ((WebViewUI) C35698n.this.uqV.get()).mo30984dE(string, afH);
                        AppMethodBeat.m2505o(7757);
                    }
                });
                break;
            case 38:
                if (bundle.getInt("webview_disable_bounce_scroll_top", 0) > 0) {
                    C5004al.m7441d(new C2995038());
                    break;
                }
                break;
            case 39:
                C5004al.m7441d(new C2995343());
                break;
            case 43:
                string2 = bundle.getString("set_page_title_text");
                string3 = bundle.getString("set_page_title_color");
                webViewUI = (WebViewUI) this.uqV.get();
                if (C1443d.m3068iW(21) && webViewUI.dac()) {
                    i2 = WebView.NIGHT_MODE_COLOR;
                } else {
                    i2 = webViewUI.getResources().getColor(C25738R.color.f11696du);
                }
                C29916g.m47394bx(string3, i2);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7759);
                        if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.m2505o(7759);
                        } else if (((WebViewUI) C35698n.this.uqV.get()).rpm) {
                            if (string2 != null) {
                                ((WebViewUI) C35698n.this.uqV.get()).setMMTitle(string2);
                            }
                            AppMethodBeat.m2505o(7759);
                        } else {
                            AppMethodBeat.m2505o(7759);
                        }
                    }
                });
                break;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                Bitmap bitmap;
                string4 = bundle.getString("set_navigation_bar_buttons_text");
                string = bundle.getString("set_navigation_bar_buttons_icon_data");
                z = bundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
                if (C5046bo.isNullOrNil(string)) {
                    bitmap = null;
                } else {
                    try {
                        bitmap = C29916g.afz(string);
                    } catch (Exception e) {
                        bitmap = null;
                        C4990ab.m7413e("MicroMsg.WebViewStubCallbackAIDLStub", "setNavigationBarButtons, decode base64 image, exception = %s", e);
                    }
                }
                bx = C29916g.m47394bx(bundle.getString("set_navigation_bar_buttons_left_text_color"), WebView.NIGHT_MODE_COLOR);
                final boolean z3 = bundle.getBoolean("set_navigation_bar_buttons_need_click_event", false);
                afy = (int) C29916g.afy(bundle.getString("set_navigation_bar_buttons_text_color"));
                C5004al.m7441d(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$47$1 */
                    class C357191 implements OnMenuItemClickListener {
                        C357191() {
                        }

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.m2504i(7760);
                            C4990ab.m7411d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                            ((WebViewUI) C35698n.this.uqV.get()).uhz.dco();
                            AppMethodBeat.m2505o(7760);
                            return false;
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$47$3 */
                    class C357203 implements OnMenuItemClickListener {
                        C357203() {
                        }

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.m2504i(7762);
                            C4990ab.m7411d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                            ((WebViewUI) C35698n.this.uqV.get()).uhz.dco();
                            AppMethodBeat.m2505o(7762);
                            return false;
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$47$4 */
                    class C357214 implements OnMenuItemClickListener {
                        C357214() {
                        }

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.m2504i(7763);
                            C4990ab.m7411d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                            ((WebViewUI) C35698n.this.uqV.get()).uhz.dco();
                            AppMethodBeat.m2505o(7763);
                            return false;
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.n$47$2 */
                    class C357222 implements OnMenuItemClickListener {
                        C357222() {
                        }

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.m2504i(7761);
                            C4990ab.m7411d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                            ((WebViewUI) C35698n.this.uqV.get()).uhz.dco();
                            AppMethodBeat.m2505o(7761);
                            return false;
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(7764);
                        if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.m2505o(7764);
                        } else if (z) {
                            ((WebViewUI) C35698n.this.uqV.get()).mo31014nR(true);
                            AppMethodBeat.m2505o(7764);
                        } else {
                            Boolean bool;
                            String dae = ((WebViewUI) C35698n.this.uqV.get()).dae();
                            if (C5046bo.isNullOrNil(dae)) {
                                bool = null;
                            } else {
                                bool = (Boolean) ((WebViewUI) C35698n.this.uqV.get()).uwd.get(dae);
                            }
                            ((WebViewUI) C35698n.this.uqV.get()).mo31014nR(Boolean.valueOf(bool == null ? false : bool.booleanValue()).booleanValue());
                            if (bitmap != null && !bitmap.isRecycled()) {
                                ((WebViewUI) C35698n.this.uqV.get()).mo30971c(string4, new BitmapDrawable(((WebViewUI) C35698n.this.uqV.get()).getResources(), bitmap));
                                if (z3) {
                                    ((WebViewUI) C35698n.this.uqV.get()).mo17376a(0, (OnMenuItemClickListener) new C357191());
                                }
                            } else if (C5046bo.isNullOrNil(string4)) {
                                ((WebViewUI) C35698n.this.uqV.get()).mo17377a(((WebViewUI) C35698n.this.uqV.get()).dat(), (OnMenuItemClickListener) new C357214(), ((WebViewUI) C35698n.this.uqV.get()).uxc);
                            } else if (afy == -1) {
                                ((WebViewUI) C35698n.this.uqV.get()).addTextOptionMenu(0, string4, new C357222());
                            } else {
                                ((WebViewUI) C35698n.this.uqV.get()).mo17382a(string4, afy, (OnMenuItemClickListener) new C357203());
                            }
                            ((WebViewUI) C35698n.this.uqV.get()).mo30943Jt(bx);
                            AppMethodBeat.m2505o(7764);
                        }
                    }
                });
                break;
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7765);
                        if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.m2505o(7765);
                            return;
                        }
                        boolean z = bundle.getBoolean("enable_fullscreen_params_enable", false);
                        if (C35698n.m58534b(C35698n.this) != null) {
                            C35698n.m58534b(C35698n.this).removeExtra("show_full_screen");
                        }
                        ((WebViewUI) C35698n.this.uqV.get()).mo30946W(z, false);
                        AppMethodBeat.m2505o(7765);
                    }
                });
                break;
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                C5004al.m7441d(new C2314041());
                break;
            case 48:
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                break;
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7768);
                        if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.m2505o(7768);
                            return;
                        }
                        ((WebViewUI) C35698n.this.uqV.get()).mo30958ac(bundle);
                        AppMethodBeat.m2505o(7768);
                    }
                });
                break;
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                boolean z4 = bundle.getBoolean("add_shortcut_status");
                if (((WebViewUI) this.uqV.get()).uhz != null) {
                    ((WebViewUI) this.uqV.get()).uhz.mo71940oa(z4);
                    break;
                }
                break;
            case 71:
                if (bundle.getString("enterprise_action").equals("enterprise_get_context_bizchat")) {
                    bundle2.putString("enterprise_context_biz", getIntent().getStringExtra("enterprise_biz_name"));
                    bundle2.putLong("enterprise_context_bizchatid", getIntent().getLongExtra("biz_chat_chat_id", -1));
                    break;
                }
                break;
            case C33279c.CTRL_INDEX /*72*/:
                ((WebViewUI) this.uqV.get()).uwX.mo69666Jp(C29916g.m47394bx(bundle.getString("key_set_bounce_background_color"), ((WebViewUI) this.uqV.get()).getResources().getColor(C25738R.color.a5v)));
                break;
            case C27077c.CTRL_INDEX /*73*/:
                intent = getIntent();
                if (bundle != null) {
                    switch (bundle.getInt("scene")) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case C2275g.CTRL_INDEX /*37*/:
                        case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                            bundle2.putStringArrayList("proof", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                            break;
                        case 33:
                            bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                            break;
                        case 34:
                            if (!C5046bo.isNullOrNil(intent.getStringExtra("k_webview_img"))) {
                                string2 = intent.getStringExtra("k_webview_img");
                                byte[] e2 = C5730e.m8632e(string2, 0, (int) C5730e.asZ(string2));
                                C5730e.deleteFile(string2);
                                bundle2.putString("webviewImg", Base64.encodeToString(e2, 0));
                            }
                            if (intent.getStringExtra("k_webview_html") != null) {
                                bundle2.putString("webviewHtml", intent.getStringExtra("k_webview_html"));
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("<exposecontent>");
                            stringBuilder.append("<weburl>");
                            if (intent.getStringExtra("k_expose_url") != null) {
                                stringBuilder.append(intent.getStringExtra("k_expose_url"));
                            }
                            stringBuilder.append("</weburl>");
                            stringBuilder.append("<firstJumpUrl>");
                            if (intent.getStringExtra("k_expose_url") != null) {
                                stringBuilder.append(intent.getStringExtra("k_expose_url"));
                            }
                            stringBuilder.append("</firstJumpUrl>");
                            stringBuilder.append("<webscence>");
                            stringBuilder.append(intent.getIntExtra("k_expose_web_scene", 0));
                            stringBuilder.append("</webscence>");
                            stringBuilder.append("</exposecontent>");
                            bundle2.putString("url", stringBuilder.toString());
                            break;
                        case 35:
                        case 36:
                        case 38:
                        case 39:
                            break;
                        case 51:
                            bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                            bundle2.putStringArrayList("proof", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                            bundle2.putInt("msgType", intent.getIntExtra("k_expose_msg_type", 0));
                            break;
                        default:
                            C4990ab.m7411d("MicroMsg.WebViewStubCallbackAIDLStub", "unknown expose scene: %d", Integer.valueOf(bundle.getInt("scene")));
                            AppMethodBeat.m2505o(7794);
                            return bundle2;
                    }
                    bundle2.putString("username", intent.getStringExtra("k_username"));
                    break;
                }
                break;
            case 77:
                bundle2.putString("KSessionId", ((WebViewUI) this.uqV.get()).cvF);
                bundle2.putString("KUserAgent", ((WebViewUI) this.uqV.get()).ium);
                bundle2.putBoolean("KReportPage", ((WebViewUI) this.uqV.get()).uvr);
                bundle2.putString("KUrl", ((WebViewUI) this.uqV.get()).dae());
                i2 = afH(getIntent().getStringExtra("geta8key_username"));
                if (i2 == 7 || i2 == 56) {
                    bundle2.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
                    break;
                }
            case JsApiOperateWXData.CTRL_INDEX /*79*/:
                if (!(this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing())) {
                    bundle2.putInt("height", ((WebViewUI) this.uqV.get()).cWF());
                    break;
                }
            case 81:
                bundle2.putBoolean("from_shortcut", ((WebViewUI) this.uqV.get()).uvz);
                break;
            case C38339e.CTRL_INDEX /*84*/:
                mMTitle = ((WebViewUI) this.uqV.get()).mController.getMMTitle();
                string2 = getCurrentUrl();
                bundle2.putString("webview_current_url", string2);
                bundle2.putString("webview_current_title", mMTitle != null ? mMTitle.toString() : "");
                bundle2.putString("webview_current_desc", string2);
                break;
            case C33345i.CTRL_INDEX /*85*/:
                mMTitle = ((WebViewUI) this.uqV.get()).mController.getMMTitle();
                string2 = getCurrentUrl();
                Intent intent2 = getIntent();
                if (intent2 != null) {
                    bundle2.putString("share_report_pre_msg_url", intent2.getStringExtra("share_report_pre_msg_url"));
                    bundle2.putString("share_report_pre_msg_title", intent2.getStringExtra("share_report_pre_msg_title"));
                    bundle2.putString("share_report_pre_msg_desc", intent2.getStringExtra("share_report_pre_msg_desc"));
                    bundle2.putString("share_report_pre_msg_icon_url", intent2.getStringExtra("share_report_pre_msg_icon_url"));
                    bundle2.putString("share_report_pre_msg_appid", intent2.getStringExtra("share_report_pre_msg_appid"));
                    bundle2.putInt("share_report_from_scene", intent2.getIntExtra("share_report_from_scene", 0));
                    bundle2.putString("share_report_biz_username", intent2.getStringExtra("share_report_biz_username"));
                }
                bundle2.putString("share_report_current_url", string2);
                bundle2.putString("share_report_current_title", mMTitle != null ? mMTitle.toString() : "");
                break;
            case 86:
                bundle2.putBoolean("is_from_keep_top", getIntent().getBooleanExtra("is_from_keep_top", false));
                break;
            case C31128d.MIC_COLORPENCIL /*87*/:
                if (!((WebViewUI) this.uqV.get()).uwq) {
                    bundle2.putString("full_url", C5046bo.nullAsNil(((WebViewUI) this.uqV.get()).jUg));
                    if (((WebViewUI) this.uqV.get()).uws != null && ((WebViewUI) this.uqV.get()).uws.size() != 0) {
                        bundle2.putInt("set_cookie", 1);
                        C24526c.m38159jx(C4996ah.getContext());
                        C44576b dTR = C44576b.dTR();
                        for (String string6 : ((WebViewUI) this.uqV.get()).uws.keySet()) {
                            dTR.setCookie(C5046bo.anB(((WebViewUI) this.uqV.get()).jUg), string6 + "=" + ((String) ((WebViewUI) this.uqV.get()).uws.get(string6)));
                        }
                        dTR.setCookie(C5046bo.anB(((WebViewUI) this.uqV.get()).jUg), "httponly");
                        C24526c.dTT();
                        C24526c.sync();
                        C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "cookies:%s", dTR.getCookie(C5046bo.anB(((WebViewUI) this.uqV.get()).jUg)));
                        break;
                    }
                    bundle2.putInt("set_cookie", 0);
                    break;
                }
                bundle2.putString("result", "not_return");
                break;
            case 95:
                ((WebViewUI) this.uqV.get()).mo9701ab(bundle);
                break;
            case PlayerException.EXCEPTION_IN_RELEASE /*97*/:
                bundle2.putInt("web_page_count", WebViewUI.uwz);
                break;
            case 99:
                bundle2.putInt("geta8key_scene", getIntent().getIntExtra("geta8key_scene", 0));
                C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: getA8KeyScene(%d)", Integer.valueOf(i2));
                break;
            case 101:
                bundle.setClassLoader(WebViewUI.class.getClassLoader());
                C25985d.m41467b((Context) this.uqV.get(), bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", ((WebViewUI) this.uqV.get()).cMm));
                break;
            case 107:
                if (this.uqV.get() != null && !((WebViewUI) this.uqV.get()).isFinishing()) {
                    bundle2.putBoolean("isFullScreen", ((WebViewUI) this.uqV.get()).uvf);
                    break;
                }
                bundle2.putBoolean("isFullScreen", false);
                break;
                break;
            case 140:
                bundle2.putString("current_url", ((WebViewUI) this.uqV.get()).dae());
                bundle2.putString("raw_url", ((WebViewUI) this.uqV.get()).cOG);
                break;
            case 146:
                string3 = bundle.getString("_url");
                if (!(C5046bo.isNullOrNil(string3) || ((WebViewUI) this.uqV.get()).icz == null || c40344k == null)) {
                    JsapiPermissionWrapper aei = c40344k.aei(string3);
                    if (aei != null) {
                        bundle2.putParcelable("_permission_wrapper", aei);
                        break;
                    }
                }
                break;
            case 150:
                bundle2.putString("full_url", ((WebViewUI) this.uqV.get()).jUg);
                bundle2.putString("raw_url", ((WebViewUI) this.uqV.get()).cOG);
                bundle2.putString("page_key", (((WebViewUI) this.uqV.get()).hashCode() & BaseClientBuilder.API_PRIORITY_OTHER) + "_" + (((WebViewUI) this.uqV.get()).cOG.hashCode() & BaseClientBuilder.API_PRIORITY_OTHER));
                if (this.uqV.get() instanceof GameWebViewUI) {
                    C30003c c30003c = ((GameWebViewUI) this.uqV.get()).uDe;
                    if (c30003c != null) {
                        bundle2.putString("comm_js_version", C30003c.dgk());
                        bundle2.putString("wepkg_version", c30003c.dgj());
                        bundle2.putBoolean("is_used_wepkg", c30003c.uVv);
                        break;
                    }
                }
                break;
            case 200:
                C20024a c20024a = new C20024a();
                bundle2.putBoolean("success", ((C20023b) C1720g.m3528K(C20023b.class)).mo6751a((Context) this.uqV.get(), bundle.getString("url"), bundle.getInt("item_show_type"), bundle.getInt("scene"), bundle.getInt("openType"), c20024a));
                if (!(c20024a.success || c20024a.message == null)) {
                    bundle2.putString("desc", c20024a.message);
                    break;
                }
            case 203:
                ((WebViewUI) this.uqV.get()).uwI.cZK();
                break;
            case 252:
                if (this.uqV.get() instanceof GameWebViewUI) {
                    GameWebViewUI gameWebViewUI = (GameWebViewUI) this.uqV.get();
                    gameWebViewUI.mVc.uDQ = System.currentTimeMillis();
                    gameWebViewUI.mUN.eBQ = 1;
                    break;
                }
                break;
            case C31128d.MIC_PTU_ZIPAI_OKINAWA /*253*/:
                if (this.uqV.get() instanceof GameWebViewUI) {
                    ((GameWebViewUI) this.uqV.get()).mVc.uDR = System.currentTimeMillis();
                    break;
                }
                break;
            case 1009:
                if (((WebViewUI) this.uqV.get()).uvh != null) {
                    ((WebViewUI) this.uqV.get()).uvh.disable();
                }
                ((WebViewUI) this.uqV.get()).screenOrientation = bundle.getInt("screen_orientation", -1);
                if (((WebViewUI) this.uqV.get()).screenOrientation == 1001) {
                    ((WebViewUI) this.uqV.get()).screenOrientation = 0;
                    if (((WebViewUI) this.uqV.get()).uvh != null) {
                        C4990ab.m7416i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                        ((WebViewUI) this.uqV.get()).uvh.enable();
                    }
                } else if (((WebViewUI) this.uqV.get()).screenOrientation == 1002) {
                    ((WebViewUI) this.uqV.get()).screenOrientation = 1;
                    if (((WebViewUI) this.uqV.get()).uvh != null) {
                        C4990ab.m7416i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                        ((WebViewUI) this.uqV.get()).uvh.enable();
                    }
                }
                ((WebViewUI) this.uqV.get()).aBS();
                break;
            case WearableStatusCodes.DUPLICATE_LISTENER /*4001*/:
            case WearableStatusCodes.UNKNOWN_LISTENER /*4002*/:
            case WearableStatusCodes.DATA_ITEM_TOO_LARGE /*4003*/:
            case WearableStatusCodes.INVALID_TARGET_NODE /*4004*/:
            case WearableStatusCodes.ASSET_UNAVAILABLE /*4005*/:
            case WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED /*4008*/:
                final C42013j c42013j = new C42013j();
                c42013j.csb.context = ((WebViewUI) this.uqV.get()).mController.ylL;
                c42013j.csb.actionCode = i;
                if (WearableStatusCodes.DATA_ITEM_TOO_LARGE == i) {
                    c42013j.csb.csd = bundle.getString("apdu");
                } else if (WearableStatusCodes.INVALID_TARGET_NODE == i) {
                    string6 = bundle.getString("apdus");
                    z = bundle.getBoolean("breakIfFail", true);
                    boolean z5 = bundle.getBoolean("breakIfTrue", false);
                    c42013j.csb.csd = string6;
                    c42013j.csb.cse = z;
                    c42013j.csb.csf = z5;
                }
                c42013j.callback = new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7750);
                        bundle2.putAll(c42013j.csc.csg);
                        AppMethodBeat.m2505o(7750);
                    }
                };
                C4879a.xxA.mo10055m(c42013j);
                break;
            case ReaderCallback.HIDDEN_BAR /*5001*/:
                if (((WebViewUI) this.uqV.get()).icy.isSDCardAvailable()) {
                    C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "availableSize = %d", Long.valueOf(C5034bd.dpq()));
                    if (C5034bd.dpq() < 524288000) {
                        C4990ab.m7412e("MicroMsg.WebViewStubCallbackAIDLStub", "available size not enough");
                    } else {
                        File file = new File(C14445a.ueu);
                        z2 = true;
                        if (!file.exists()) {
                            z2 = file.mkdirs();
                            C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "create proxy cache path : %s, %b", file.getAbsolutePath(), Boolean.valueOf(z2));
                        }
                        if (z2) {
                            i2 = FactoryProxyManager.getPlayManager().init(C4996ah.getContext(), C14445a.ueu);
                            FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                            i3 = i2;
                        }
                    }
                    i3 = FactoryProxyManager.getPlayManager().init(C4996ah.getContext(), null);
                } else {
                    C4990ab.m7416i("MicroMsg.WebViewStubCallbackAIDLStub", "sdcard not available");
                    i3 = FactoryProxyManager.getPlayManager().init(C4996ah.getContext(), null);
                }
                if (i3 == 0) {
                    if (((WebViewUI) this.uqV.get()).uwJ == null) {
                        ((WebViewUI) this.uqV.get()).uwJ = new C22983h((WebViewUI) this.uqV.get());
                        FactoryProxyManager.getPlayManager().setUtilsObject(((WebViewUI) this.uqV.get()).uwJ);
                    }
                    afH = FactoryProxyManager.getPlayManager().getLocalServerPort();
                    C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "webview video init result = %d, local port = %d", Integer.valueOf(i3), Integer.valueOf(afH));
                    C22883an c22883an = ((WebViewUI) this.uqV.get()).uwP;
                    if (afH <= 0 || afH > CdnLogic.kBizGeneric) {
                        C4990ab.m7413e("MicroMsg.WebViewResourceInterrupter", "err port = %d", Integer.valueOf(afH));
                    }
                    if (!c22883an.umD.contains(Integer.valueOf(afH))) {
                        c22883an.umD.add(Integer.valueOf(afH));
                    }
                }
                bundle2.putInt("webview_video_proxy_init", i3);
                break;
            case ReaderCallback.SHOW_BAR /*5002*/:
                i2 = FactoryProxyManager.getPlayManager().startPlay(bundle.getString("webview_video_proxy_cdn_urls"), bundle.getInt("webview_video_proxy_file_type"), bundle.getString("webview_video_proxy_fileId"), (long) bundle.getInt("webview_video_proxy_file_size"), bundle.getInt("webview_video_proxy_file_duration"));
                C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", string2, string5, Integer.valueOf(bx), Integer.valueOf(afy), Integer.valueOf(i3), Integer.valueOf(i2), FactoryProxyManager.getPlayManager().buildPlayURLMp4(i2));
                bundle2.putInt("webview_video_proxy_play_data_id", i2);
                bundle2.putString("webview_video_proxy_local_url", string4);
                break;
            case ReaderCallback.COPY_SELECT_TEXT /*5003*/:
                i2 = bundle.getInt("webview_video_proxy_play_data_id");
                C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "webview proxy stop play, play id = %d", Integer.valueOf(i2));
                if (i2 > 0) {
                    FactoryProxyManager.getPlayManager().stopPlay(i2);
                    break;
                }
                break;
            case ReaderCallback.SEARCH_SELECT_TEXT /*5004*/:
                FactoryProxyManager.getPlayManager().setPlayerState(bundle.getInt("webview_video_proxy_play_state"));
                break;
            case ReaderCallback.READER_TOAST /*5005*/:
                FactoryProxyManager.getPlayManager().setNetWorkState(bundle.getInt("webview_video_proxy_net_state"));
                break;
            case ReaderCallback.SHOW_DIALOG /*5006*/:
                FactoryProxyManager.getPlayManager().setRemainTime(bundle.getInt("webview_video_proxy_play_data_id"), bundle.getInt("webview_video_proxy_play_remain_time"));
                break;
            case 5007:
                C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "playid = %d, duration = %d", Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration")));
                bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(i2, afH));
                break;
            case 6001:
                C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "includeCookie = %b", Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false)));
                Intent intent3 = new Intent();
                intent3.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                intent3.putExtra("tools_clean_webview_cache_ignore_cookie", z2);
                C45287c.m83504aZ(intent3);
                break;
            case 90000:
                bundle2.putStringArray("webview_get_route_url_list", ((WebViewUI) this.uqV.get()).uwG.cYO());
                bundle2.putInt("webview_get_route_url_geta8key_scene", afH(getIntent().getStringExtra("geta8key_username")));
                bundle2.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
                break;
            case 90001:
                Float valueOf;
                C4990ab.m7417i("MicroMsg.WebViewStubCallbackAIDLStub", "url = %s, cookie = %s", ((WebViewUI) this.uqV.get()).dae(), C44576b.dTR().getCookie(((WebViewUI) this.uqV.get()).dae()));
                bundle2.putString("cookie", string2);
                Float valueOf2 = Float.valueOf(C32432a.dmO());
                if (((WebViewUI) this.uqV.get()).pzf != null && ((WebViewUI) this.uqV.get()).pzf.getWebCoreType() == C44570d.WV_KIND_CW && XWalkEnvironment.getUsingCustomContext()) {
                    valueOf = Float.valueOf(((WebViewUI) this.uqV.get()).pzf.getResources().getDisplayMetrics().density);
                } else {
                    valueOf = valueOf2;
                }
                bundle2.putFloat(Constants.PARAM_DENSITY, valueOf.floatValue());
                break;
            case 90002:
                C40346m.uuj.mo63714hg(bundle.getString("traceid"), bundle.getString("username"));
                break;
            case 90003:
                bundle2.putString("geta8key_data_req_url", ((WebViewUI) this.uqV.get()).cWL());
                bundle2.putString("geta8key_data_username", getIntent().getStringExtra("geta8key_username"));
                bundle2.putInt("geta8key_data_scene", afH(getIntent().getStringExtra("geta8key_username")));
                bundle2.putInt("geta8key_data_reason", 8);
                if (((WebViewUI) this.uqV.get()).pzf.getIsX5Kernel()) {
                    bundle2.putInt("geta8key_data_flag", 1);
                } else {
                    bundle2.putInt("geta8key_data_flag", 0);
                }
                this.uqV.get();
                bundle2.putString("geta8key_data_net_type", C40259aq.cXS());
                bundle2.putInt("geta8key_session_id", ((WebViewUI) this.uqV.get()).uvB);
                bundle2.putInt("webview_binder_id", ((WebViewUI) this.uqV.get()).hashCode());
                bundle2.putByteArray("k_a8key_cookie", ((WebViewUI) this.uqV.get()).uvD);
                bundle2.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
                break;
            case 90004:
                string3 = bundle.getString("geta8key_result_req_url");
                string5 = bundle.getString("geta8key_result_full_url");
                if (!C5046bo.isNullOrNil(string5)) {
                    c40344k.mo63705a(string5.replaceFirst("http://", "https//"), new JsapiPermissionWrapper(bundle.getByteArray("geta8key_result_jsapi_perm_control_bytes")), new GeneralControlWrapper(bundle.getInt("geta8key_result_general_ctrl_b1")));
                    String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
                    String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
                    Map hashMap = new HashMap();
                    if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
                        for (i2 = 0; i2 < stringArray.length; i2++) {
                            hashMap.put(stringArray[i2], stringArray2[i2]);
                        }
                    }
                    ((WebViewUI) this.uqV.get()).mo30969b(string3, string5, hashMap);
                    break;
                }
                C4990ab.m7412e("MicroMsg.WebViewStubCallbackAIDLStub", "updatePageAuth fail fullUrl is null");
                break;
            case 90005:
                ((WebViewUI) this.uqV.get()).mo30940FY(bundle.getString(C5506m.ygh, ""));
                break;
            case 100000:
                ((WebViewUI) this.uqV.get()).uwD = true;
                break;
            default:
                C4990ab.m7412e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
                break;
        }
        AppMethodBeat.m2505o(7794);
        return bundle2;
    }

    /* renamed from: X */
    public final void mo26779X(Bundle bundle) {
        AppMethodBeat.m2504i(7795);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7795);
            return;
        }
        C4990ab.m7416i("MicroMsg.WebViewStubCallbackAIDLStub", "setCustomMenu");
        ArrayList stringArrayList = bundle.getStringArrayList("keys");
        ArrayList stringArrayList2 = bundle.getStringArrayList("titles");
        int size = stringArrayList.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList.add(new C1765b((String) stringArrayList.get(i), (String) stringArrayList2.get(i)));
        }
        if (stringArrayList.size() > 0) {
            String url = ((WebViewUI) this.uqV.get()).pzf.getUrl();
            if (((WebViewUI) this.uqV.get()).uwc.containsKey(url)) {
                ((WebViewUI) this.uqV.get()).uwc.remove(url);
            }
            ((WebViewUI) this.uqV.get()).uwc.put(url, arrayList);
        }
        AppMethodBeat.m2505o(7795);
    }

    /* renamed from: nL */
    public final void mo26796nL(boolean z) {
        AppMethodBeat.m2504i(7796);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.m2505o(7796);
            return;
        }
        ((WebViewUI) this.uqV.get()).mo31014nR(z);
        AppMethodBeat.m2505o(7796);
    }

    /* renamed from: he */
    public final void mo26793he(final String str, final String str2) {
        AppMethodBeat.m2504i(7797);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(7769);
                if (C35698n.this.uqV.get() == null || ((WebViewUI) C35698n.this.uqV.get()).isFinishing()) {
                    AppMethodBeat.m2505o(7769);
                    return;
                }
                if (!C5046bo.isNullOrNil(str)) {
                    if (!C5046bo.isNullOrNil(str2)) {
                        C35698n.m58534b(C35698n.this).putExtra("view_port_code", str2);
                    }
                    ((WebViewUI) C35698n.this.uqV.get()).loadUrl(str);
                }
                AppMethodBeat.m2505o(7769);
            }
        });
        AppMethodBeat.m2505o(7797);
    }

    /* renamed from: dj */
    public final Bundle mo26790dj(String str, String str2) {
        AppMethodBeat.m2504i(7798);
        Bundle akC = C15045c.akC(null);
        AppMethodBeat.m2505o(7798);
        return akC;
    }
}
