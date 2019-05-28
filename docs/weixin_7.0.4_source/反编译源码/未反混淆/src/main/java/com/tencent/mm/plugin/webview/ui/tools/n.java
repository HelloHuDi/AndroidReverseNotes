package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.webkit.ValueCallback;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.j;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.plugin.webview.stub.e.a;
import com.tencent.mm.plugin.webview.ui.tools.a.b;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass61;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e.m;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.wav.WavFileHeader;
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

public final class n extends a {
    private final WeakReference<WebViewUI> uqV;

    static /* synthetic */ Intent b(n nVar) {
        AppMethodBeat.i(7799);
        Intent intent = nVar.getIntent();
        AppMethodBeat.o(7799);
        return intent;
    }

    public n(WebViewUI webViewUI) {
        AppMethodBeat.i(7774);
        this.uqV = new WeakReference(webViewUI);
        AppMethodBeat.o(7774);
    }

    public final boolean c(int i, Bundle bundle) {
        AppMethodBeat.i(7775);
        ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "callback, actionCode = ".concat(String.valueOf(i)));
        final WebViewUI webViewUI = (WebViewUI) this.uqV.get();
        if (webViewUI == null || webViewUI.isFinishing()) {
            AppMethodBeat.o(7775);
            return false;
        }
        final d dVar = webViewUI.uhz;
        final k kVar = webViewUI.icz;
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
                    webViewUI.uwe = d.ad(bundle);
                    break;
                }
                break;
            case 15:
                string = bundle.getString("exdevice_device_id");
                final boolean z2 = bundle.getBoolean("exdevice_is_complete");
                final byte[] byteArray = bundle.getByteArray("exdevice_broadcast_data");
                final boolean z3 = bundle.getBoolean("exdevice_is_lan_device");
                webViewUI2 = webViewUI;
                final d dVar2 = dVar;
                final k kVar2 = kVar;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7727);
                        if (webViewUI2 == null || webViewUI2.isFinishing()) {
                            AppMethodBeat.o(7727);
                        } else if (dVar2 != null) {
                            d dVar = dVar2;
                            String str = string;
                            byte[] bArr = byteArray;
                            boolean z = z2;
                            boolean z2 = z3;
                            if (dVar.ready) {
                                String str2 = "MicroMsg.JsApiHandler";
                                String str3 = "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s";
                                Object[] objArr = new Object[3];
                                objArr[0] = str;
                                objArr[1] = Boolean.valueOf(z);
                                objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                                ab.i(str2, str3, objArr);
                                if (bo.isNullOrNil(str)) {
                                    ab.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                    AppMethodBeat.o(7727);
                                    return;
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    JSONArray jSONArray = new JSONArray();
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("deviceId", str);
                                    b.dbr();
                                    if (b.bE(bArr) || (bArr != null && z2)) {
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
                                    ab.e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", e.getMessage());
                                }
                                try {
                                    ab.i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", i.a.a("onScanWXDeviceResult", jSONObject, dVar.uFv, dVar.uFw));
                                    dVar.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + r0 + ")", null);
                                } catch (Exception e2) {
                                    ab.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", e2.getMessage());
                                }
                                if (!z2) {
                                    b.dbr().uAa = bArr;
                                }
                                AppMethodBeat.o(7727);
                                return;
                            }
                            ab.e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
                            AppMethodBeat.o(7727);
                        } else {
                            ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "hakon can not call onScanWXDeviceResult, %s, %s", dVar2, kVar2);
                            AppMethodBeat.o(7727);
                        }
                    }
                });
                break;
            case 16:
                string2 = bundle.getString("exdevice_device_id");
                string3 = bundle.getString("exdevice_brand_name");
                final byte[] byteArray2 = bundle.getByteArray("exdevice_data");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7728);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7728);
                            return;
                        }
                        if (dVar != null) {
                            d dVar = dVar;
                            String str = string2;
                            byte[] bArr = byteArray2;
                            String str2 = string3;
                            if (dVar.ready) {
                                ab.i("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice: device id = %s, brandName = %s", str, str2);
                                if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bArr == null) {
                                    ab.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                    AppMethodBeat.o(7728);
                                    return;
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put("deviceId", str);
                                hashMap.put("base64Data", Base64.encodeToString(bArr, 2));
                                al.d(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass4(i.a.b("onReceiveDataFromWXDevice", hashMap, dVar.uFv, dVar.uFw)));
                            } else {
                                ab.e("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice fail, not ready");
                                AppMethodBeat.o(7728);
                                return;
                            }
                        }
                        AppMethodBeat.o(7728);
                    }
                });
                break;
            case 17:
                string2 = bundle.getString("exdevice_device_id");
                final boolean z4 = bundle.getBoolean("exdevice_is_bound");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7729);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7729);
                            return;
                        }
                        if (dVar != null) {
                            d dVar = dVar;
                            String str = string2;
                            boolean z = z4;
                            if (dVar.ready) {
                                ab.i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", str, Boolean.valueOf(z));
                                if (bo.isNullOrNil(str)) {
                                    ab.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                    AppMethodBeat.o(7729);
                                    return;
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put("deviceId", str);
                                if (z) {
                                    hashMap.put("state", "bind");
                                } else {
                                    hashMap.put("state", "unbind");
                                }
                                al.d(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass5(i.a.b("onWXDeviceBindStateChange", hashMap, dVar.uFv, dVar.uFw)));
                            } else {
                                ab.e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
                                AppMethodBeat.o(7729);
                                return;
                            }
                        }
                        AppMethodBeat.o(7729);
                    }
                });
                break;
            case 18:
                z = bundle.getBoolean("exdevice_bt_state");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7730);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7730);
                            return;
                        }
                        if (dVar != null) {
                            d dVar = dVar;
                            boolean z = z;
                            if (dVar.ready) {
                                ab.i("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange: state = %s", Boolean.valueOf(z));
                                HashMap hashMap = new HashMap();
                                if (z) {
                                    hashMap.put("state", "on");
                                } else {
                                    hashMap.put("state", "off");
                                }
                                al.d(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass6(i.a.b("onWXDeviceBluetoothStateChange", hashMap, dVar.uFv, dVar.uFw)));
                            } else {
                                ab.e("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange fail, not ready");
                                AppMethodBeat.o(7730);
                                return;
                            }
                        }
                        AppMethodBeat.o(7730);
                    }
                });
                break;
            case 26:
            case 27:
            case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case g.CTRL_INDEX /*37*/:
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
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7731);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7731);
                            return;
                        }
                        if (dVar != null) {
                            d dVar = dVar;
                            boolean z = z;
                            if (dVar.ready) {
                                ab.i("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange: state = %s", Boolean.valueOf(z));
                                HashMap hashMap = new HashMap();
                                if (z) {
                                    hashMap.put("state", "on");
                                } else {
                                    hashMap.put("state", "off");
                                }
                                al.d(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass7(i.a.b("onWXDeviceLanStateChange", hashMap, dVar.uFv, dVar.uFw)));
                            } else {
                                ab.e("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange fail, not ready");
                                AppMethodBeat.o(7731);
                                return;
                            }
                        }
                        AppMethodBeat.o(7731);
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
                        jSONObject.put(FirebaseAnalytics.b.CONTENT, stringArray2[i4]);
                        jSONObject.put("sender", stringArray3[i4]);
                        jSONObject.put("msgType", intArray[i4]);
                        jSONObject.put("msgTime", intArray2[i4]);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "GetMsgProofItems exception " + e.getMessage());
                    }
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7734);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7734);
                            return;
                        }
                        if (dVar != null) {
                            d dVar = dVar;
                            JSONArray jSONArray = jSONArray;
                            if (jSONArray == null) {
                                ab.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
                                AppMethodBeat.o(7734);
                                return;
                            }
                            ab.i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
                            HashMap hashMap = new HashMap();
                            hashMap.put("msgs", jSONArray);
                            al.d(new AnonymousClass61(i.a.b("onGetMsgProofItems", hashMap, dVar.uFv, dVar.uFw)));
                        }
                        AppMethodBeat.o(7734);
                    }
                });
                break;
            case 60:
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
            case 62:
            case com.tencent.view.d.MIC_AVROUND_BLUR /*119*/:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case com.tencent.view.d.MIC_SketchMark /*127*/:
            case 128:
            case 130:
            case e.CTRL_INDEX /*133*/:
            case com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX /*134*/:
            case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*135*/:
            case com.tencent.mm.plugin.appbrand.jsapi.g.n.CTRL_INDEX /*136*/:
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
                    webViewUI.j(i, bundle);
                    break;
                }
            case 70:
                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, update tid = %s", bundle.getString("service_click_tid"));
                webViewUI.uwM = string4;
                webViewUI.uwN = System.currentTimeMillis();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7738);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7738);
                            return;
                        }
                        if (webViewUI.pzf != null) {
                            com.tencent.mm.plugin.normsg.a.b.oTO.a(webViewUI.pzf, qg.class);
                            if (webViewUI.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false)) {
                                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "on service click, test");
                                com.tencent.mm.sdk.b.a.xxA.m(new qg());
                            }
                        }
                        AppMethodBeat.o(7738);
                    }
                });
                break;
            case 71:
            case c.CTRL_INDEX /*72*/:
                final Bundle bundle3 = bundle;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7737);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7737);
                            return;
                        }
                        if (bundle3 != null) {
                            webViewUI.uie.afX(bundle3.getString("key_bag_icon"));
                        }
                        AppMethodBeat.o(7737);
                    }
                });
                break;
            case 90:
                string4 = bundle.getString("webview_network_type");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7736);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7736);
                            return;
                        }
                        if (dVar != null) {
                            dVar.ags(string4);
                        }
                        AppMethodBeat.o(7736);
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
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7713);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7713);
                            return;
                        }
                        if (!(dVar == null || kVar == null || kVar.cZS() == null || !kVar.cZS().jB(42))) {
                            dVar.i(bundle2, "download_succ");
                        }
                        AppMethodBeat.o(7713);
                    }
                });
                break;
            case 1003:
                bundle2 = bundle;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7724);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7724);
                            return;
                        }
                        if (!(dVar == null || kVar == null || kVar.cZS() == null || !kVar.cZS().jB(42))) {
                            dVar.i(bundle2, "download_fail");
                        }
                        AppMethodBeat.o(7724);
                    }
                });
                break;
            case 1004:
                string5 = bundle.getString("exdevice_device_id");
                i2 = bundle.getInt("exdevice_on_state_change_state");
                final Boolean valueOf = Boolean.valueOf(bundle.getBoolean("exdevice_inner_call"));
                al.d(new Runnable() {
                    public final void run() {
                        boolean z = false;
                        AppMethodBeat.i(7772);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7772);
                        } else if (dVar != null && kVar != null && kVar.cZS() != null) {
                            kVar.cZS();
                            dVar.dG(string5, i2);
                            AppMethodBeat.o(7772);
                        } else if (dVar == null || !valueOf.booleanValue()) {
                            boolean z2;
                            String str = "MicroMsg.WebViewStubCallbackAIDLStub";
                            String str2 = "something null, %s, %s";
                            Object[] objArr = new Object[2];
                            if (dVar == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objArr[0] = Boolean.valueOf(z2);
                            if (kVar == null) {
                                z = true;
                            }
                            objArr[1] = Boolean.valueOf(z);
                            ab.w(str, str2, objArr);
                            AppMethodBeat.o(7772);
                        } else {
                            dVar.dG(string5, i2);
                            AppMethodBeat.o(7772);
                        }
                    }
                });
                break;
            case 1006:
                if (dVar != null) {
                    webViewUI2 = webViewUI;
                    final Bundle bundle4 = bundle;
                    final k kVar3 = kVar;
                    final d dVar3 = dVar;
                    al.d(new Runnable() {
                        public final void run() {
                            boolean z = false;
                            AppMethodBeat.i(7726);
                            if (webViewUI2 == null || webViewUI2.isFinishing()) {
                                AppMethodBeat.o(7726);
                                return;
                            }
                            byte[] byteArray = bundle4.getByteArray("jsapi_control_bytes");
                            if (byteArray == null || kVar3 == null || kVar3.cZS() == null) {
                                String str = "MicroMsg.WebViewStubCallbackAIDLStub";
                                String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
                                Object[] objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(byteArray != null);
                                if (kVar3 != null) {
                                    z = true;
                                }
                                objArr[1] = Boolean.valueOf(z);
                                ab.e(str, str2, objArr);
                            } else {
                                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "update control bytes by preverify, %d", Integer.valueOf(byteArray.length));
                                kVar3.cZS().vxM = byteArray;
                            }
                            if (dVar3 != null) {
                                dVar3.dcj();
                            }
                            AppMethodBeat.o(7726);
                        }
                    });
                    break;
                }
                break;
            case 1007:
                final long j = bundle.getLong("download_manager_downloadid");
                final int i5 = bundle.getInt("download_manager_progress");
                string5 = bundle.getString("download_manager_appid", "");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7771);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7771);
                            return;
                        }
                        if (!(dVar == null || kVar == null || kVar.cZS() == null || !kVar.cZS().jB(42))) {
                            dVar.n(string5, j, i5);
                        }
                        AppMethodBeat.o(7771);
                    }
                });
                break;
            case 1008:
                bundle2 = bundle;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7735);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7735);
                            return;
                        }
                        if (!(dVar == null || kVar == null || kVar.cZS() == null || !kVar.cZS().jB(42))) {
                            dVar.i(bundle2, "download_removed");
                        }
                        AppMethodBeat.o(7735);
                    }
                });
                break;
            case 1010:
                bundle2 = bundle;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7747);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7747);
                            return;
                        }
                        if (!(dVar == null || kVar == null || kVar.cZS() == null || !kVar.cZS().jB(42))) {
                            dVar.i(bundle2, "download_pause");
                        }
                        AppMethodBeat.o(7747);
                    }
                });
                break;
            case 1011:
                bundle2 = bundle;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7758);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7758);
                            return;
                        }
                        if (!(dVar == null || kVar == null || kVar.cZS() == null || !kVar.cZS().jB(42))) {
                            dVar.i(bundle2, "download_resumed");
                        }
                        AppMethodBeat.o(7758);
                    }
                });
                break;
            case 1012:
                bundle2 = bundle;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7770);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7770);
                            return;
                        }
                        if (!(dVar == null || kVar == null || kVar.cZS() == null || !kVar.cZS().jB(42))) {
                            dVar.i(bundle2, "download_start");
                        }
                        AppMethodBeat.o(7770);
                    }
                });
                break;
            case 2002:
                hashMap = new HashMap();
                hashMap.put("err_msg", bundle.getString("playResult"));
                hashMap.put("localId", bundle.getString("localId"));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7720);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7720);
                            return;
                        }
                        if (dVar != null) {
                            dVar.aM(hashMap);
                        }
                        AppMethodBeat.o(7720);
                    }
                });
                break;
            case 2003:
                string2 = bundle.getString("webview_jssdk_file_item_local_id");
                i3 = bundle.getInt("webview_jssdk_file_item_progreess");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7714);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7714);
                            return;
                        }
                        if (dVar != null) {
                            dVar.dH(string2, i3);
                        }
                        AppMethodBeat.o(7714);
                    }
                });
                break;
            case 2004:
                string2 = bundle.getString("webview_jssdk_file_item_local_id");
                i3 = bundle.getInt("webview_jssdk_file_item_progreess");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7716);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7716);
                            return;
                        }
                        if (dVar != null) {
                            dVar.dI(string2, i3);
                        }
                        AppMethodBeat.o(7716);
                    }
                });
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                string2 = bundle.getString("webview_jssdk_file_item_local_id");
                i3 = bundle.getInt("webview_jssdk_file_item_progreess");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7717);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7717);
                            return;
                        }
                        if (dVar != null) {
                            dVar.dJ(string2, i3);
                        }
                        AppMethodBeat.o(7717);
                    }
                });
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                string2 = bundle.getString("webview_jssdk_file_item_local_id");
                i3 = bundle.getInt("webview_jssdk_file_item_progreess");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7718);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7718);
                            return;
                        }
                        if (dVar != null) {
                            dVar.dK(string2, i3);
                        }
                        AppMethodBeat.o(7718);
                    }
                });
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7722);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7722);
                            return;
                        }
                        webViewUI.setMMSubTitle((int) R.string.fzc);
                        AppMethodBeat.o(7722);
                    }
                });
                break;
            case 2008:
                hashMap = new HashMap();
                hashMap.put("localId", bundle.getString("localId"));
                hashMap.put("err_msg", bundle.getString("recordResult"));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7723);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7723);
                            return;
                        }
                        webViewUI.setMMSubTitle(null);
                        if (dVar != null) {
                            dVar.aN(hashMap);
                        }
                        AppMethodBeat.o(7723);
                    }
                });
                break;
            case 2009:
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7725);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7725);
                            return;
                        }
                        webViewUI.setMMSubTitle(null);
                        AppMethodBeat.o(7725);
                    }
                });
                break;
            case 2010:
                string2 = bundle.getString("webview_jssdk_file_item_local_id");
                i3 = bundle.getInt("webview_jssdk_file_item_progreess");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7719);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7719);
                            return;
                        }
                        if (dVar != null) {
                            dVar.dL(string2, i3);
                        }
                        AppMethodBeat.o(7719);
                    }
                });
                break;
            case 2011:
                string2 = bundle.getString("webview_jssdk_file_item_local_id");
                i3 = bundle.getInt("webview_jssdk_file_item_progreess");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7773);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7773);
                            return;
                        }
                        if (dVar != null) {
                            d dVar = dVar;
                            String str = string2;
                            int i = i3;
                            if (dVar.ready) {
                                ab.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
                                HashMap hashMap = new HashMap();
                                hashMap.put("localId", str);
                                hashMap.put("percent", Integer.valueOf(i));
                                al.d(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass11(i.a.b("onMediaFileUploadProgress", hashMap, dVar.uFv, dVar.uFw)));
                            } else {
                                ab.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
                                AppMethodBeat.o(7773);
                                return;
                            }
                        }
                        AppMethodBeat.o(7773);
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
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7715);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7715);
                            return;
                        }
                        if (dVar != null) {
                            d dVar = dVar;
                            String str = string2;
                            int i = i3;
                            String str2 = string3;
                            int i2 = i6;
                            String str3 = string6;
                            String str4 = string;
                            if (dVar.ready) {
                                ab.i("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange, state : %s, duration : %d, src:%s, errCode:%d, errMsg:%s, srcId:%s", str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, str4);
                                HashMap hashMap = new HashMap();
                                hashMap.put("state", str);
                                hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
                                hashMap.put("src", str2);
                                hashMap.put("errCode", Integer.valueOf(i2));
                                hashMap.put("errMsg", str3);
                                hashMap.put("srcId ", str4);
                                al.d(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass18(i.a.b("onBackgroundAudioStateChange", hashMap, dVar.uFv, dVar.uFw)));
                            } else {
                                ab.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, not ready");
                                AppMethodBeat.o(7715);
                                return;
                            }
                        }
                        AppMethodBeat.o(7715);
                    }
                });
                break;
            case WearableStatusCodes.UNKNOWN_CAPABILITY /*4007*/:
                length = bundle.getInt("nfc_key_on_touch_errcode", 0);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7721);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7721);
                            return;
                        }
                        if (dVar != null) {
                            d dVar = dVar;
                            int i = length;
                            if (dVar.ready) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(i));
                                al.d(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass20(i.a.b("onNfcTouch", hashMap, dVar.uFv, dVar.uFw)));
                            } else {
                                ab.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
                                AppMethodBeat.o(7721);
                                return;
                            }
                        }
                        AppMethodBeat.o(7721);
                    }
                });
                break;
            case CdnLogic.kMediaTypeStoryAudio /*40001*/:
                string4 = bundle.getString("err_msg");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7732);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7732);
                            return;
                        }
                        if (dVar != null) {
                            dVar.agp(string4);
                        }
                        AppMethodBeat.o(7732);
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
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7733);
                        if (webViewUI == null || webViewUI.isFinishing()) {
                            AppMethodBeat.o(7733);
                            return;
                        }
                        if (dVar != null) {
                            dVar.a(string2, i3, i2, d, d2, f);
                        }
                        AppMethodBeat.o(7733);
                    }
                });
                break;
            case XWalkCoreWrapper.INVOKE_RUNTIME_ID_CONTEXT_CHANGED /*80001*/:
            case 80002:
                webViewUI.t(i, bundle);
                break;
            default:
                ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
                break;
        }
        AppMethodBeat.o(7775);
        return true;
    }

    public final boolean a(final com.tencent.mm.plugin.webview.stub.c cVar) {
        AppMethodBeat.i(7776);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7776);
            return false;
        }
        if (((WebViewUI) this.uqV.get()).uvS.daP() || ((WebViewUI) this.uqV.get()).uvT.daP() || ((WebViewUI) this.uqV.get()).uvU.daP() || ((WebViewUI) this.uqV.get()).uxl.cXH()) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(7739);
                    if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                        AppMethodBeat.o(7739);
                        return;
                    }
                    ((WebViewUI) n.this.uqV.get()).b(cVar);
                    AppMethodBeat.o(7739);
                }
            });
        }
        AppMethodBeat.o(7776);
        return true;
    }

    public final boolean IZ(final int i) {
        AppMethodBeat.i(7777);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(7740);
                if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                    AppMethodBeat.o(7740);
                    return;
                }
                ((WebViewUI) n.this.uqV.get()).setProgressBarIndeterminateVisibility(false);
                ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] set title pb visibility:%d", Integer.valueOf(i));
                if (i != 0) {
                    ((WebViewUI) n.this.uqV.get()).uuX.finish();
                } else if (!(((WebViewUI) n.this.uqV.get()).uwn || ((WebViewUI) n.this.uqV.get()).uwp)) {
                    ((WebViewUI) n.this.uqV.get()).uuX.start();
                    AppMethodBeat.o(7740);
                    return;
                }
                AppMethodBeat.o(7740);
            }
        });
        AppMethodBeat.o(7777);
        return true;
    }

    public final boolean a(String str, String str2, Bundle bundle, boolean z) {
        AppMethodBeat.i(7778);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7778);
        } else {
            if (((WebViewUI) this.uqV.get()).uhz != null) {
                final String str3 = str;
                final String str4 = str2;
                final Bundle bundle2 = bundle;
                final boolean z2 = z;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7741);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7741);
                            return;
                        }
                        ((WebViewUI) n.this.uqV.get()).uhz.a(str3, str4, i.aq(bundle2), z2);
                        AppMethodBeat.o(7741);
                    }
                });
            }
            AppMethodBeat.o(7778);
        }
        return false;
    }

    public final String cYY() {
        AppMethodBeat.i(7779);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7779);
            return null;
        }
        String str = ((WebViewUI) this.uqV.get()).cOG;
        AppMethodBeat.o(7779);
        return str;
    }

    public final String getCurrentUrl() {
        AppMethodBeat.i(7780);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7780);
            return null;
        }
        String dae = ((WebViewUI) this.uqV.get()).dae();
        AppMethodBeat.o(7780);
        return dae;
    }

    public final String cYZ() {
        AppMethodBeat.i(7781);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7781);
            return null;
        }
        String stringExtra = ((WebViewUI) this.uqV.get()).getIntent().getStringExtra("srcUsername");
        AppMethodBeat.o(7781);
        return stringExtra;
    }

    public final int cZa() {
        AppMethodBeat.i(7782);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7782);
            return 0;
        }
        int i = ((WebViewUI) this.uqV.get()).cSQ;
        AppMethodBeat.o(7782);
        return i;
    }

    public final void nJ(final boolean z) {
        AppMethodBeat.i(7783);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7783);
            return;
        }
        final boolean booleanExtra = ((WebViewUI) this.uqV.get()).getIntent().getBooleanExtra("forceHideShare", false);
        ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z), Boolean.valueOf(booleanExtra));
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(7742);
                if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                    AppMethodBeat.o(7742);
                } else if (booleanExtra) {
                    if (!(((WebViewUI) n.this.uqV.get()).pzf == null || bo.isNullOrNil(((WebViewUI) n.this.uqV.get()).pzf.getUrl()))) {
                        ((WebViewUI) n.this.uqV.get()).uwa.put(((WebViewUI) n.this.uqV.get()).pzf.getUrl(), Boolean.FALSE);
                    }
                    ((WebViewUI) n.this.uqV.get()).nO(false);
                    AppMethodBeat.o(7742);
                } else {
                    if (!(((WebViewUI) n.this.uqV.get()).pzf == null || bo.isNullOrNil(((WebViewUI) n.this.uqV.get()).pzf.getUrl()))) {
                        ((WebViewUI) n.this.uqV.get()).uwa.put(((WebViewUI) n.this.uqV.get()).pzf.getUrl(), Boolean.valueOf(z));
                    }
                    ((WebViewUI) n.this.uqV.get()).nO(z);
                    AppMethodBeat.o(7742);
                }
            }
        });
        AppMethodBeat.o(7783);
    }

    public final void nK(final boolean z) {
        AppMethodBeat.i(7784);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7784);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(7743);
                if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                    AppMethodBeat.o(7743);
                    return;
                }
                ((WebViewUI) n.this.uqV.get()).nP(z);
                AppMethodBeat.o(7743);
            }
        });
        AppMethodBeat.o(7784);
    }

    public final void cZb() {
        AppMethodBeat.i(7785);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7785);
            return;
        }
        if (((WebViewUI) this.uqV.get()).uhz != null) {
            ((WebViewUI) this.uqV.get()).uhz.cZb();
        }
        AppMethodBeat.o(7785);
    }

    public final void W(Bundle bundle) {
        AppMethodBeat.i(7786);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7786);
            return;
        }
        ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "IUIController, closeWindow");
        if (bundle != null) {
            Intent intent = new Intent();
            intent.putExtra("result_data", bundle);
            ((WebViewUI) this.uqV.get()).setResult(-1, intent);
        }
        ((WebViewUI) this.uqV.get()).finish();
        AppMethodBeat.o(7786);
    }

    public final void afd(String str) {
        int i = 0;
        AppMethodBeat.i(7787);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7787);
            return;
        }
        try {
            i = bo.getInt(str, 0);
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb, ex = " + e.getMessage());
        }
        if (((WebViewUI) this.uqV.get()).pzf == null) {
            ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "setFontSizeCb fail, viewWV is null");
            AppMethodBeat.o(7787);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(7744);
                if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                    AppMethodBeat.o(7744);
                    return;
                }
                ((WebViewUI) n.this.uqV.get()).Jw(i);
                AppMethodBeat.o(7744);
            }
        });
        AppMethodBeat.o(7787);
    }

    public final void cZc() {
        AppMethodBeat.i(7788);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7788);
            return;
        }
        if (((WebViewUI) this.uqV.get()).uhz != null) {
            ((WebViewUI) this.uqV.get()).uhz.cZc();
        }
        AppMethodBeat.o(7788);
    }

    public final void e(String str, final String str2, int i, int i2) {
        AppMethodBeat.i(7789);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7789);
            return;
        }
        ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "result: ".concat(String.valueOf(str2)));
        if (((WebViewUI) this.uqV.get()).uwH.icE == null || str == null || !str.equals(((WebViewUI) this.uqV.get()).uwH.icE.upr)) {
            AppMethodBeat.o(7789);
            return;
        }
        if (((WebViewUI) this.uqV.get()).uwH.icE != null) {
            ((WebViewUI) this.uqV.get()).uwH.icE.cYK();
        }
        ((WebViewUI) this.uqV.get()).uwH.icC = i;
        ((WebViewUI) this.uqV.get()).uwH.icD = i2;
        if (str2 == null || ((WebViewUI) this.uqV.get()).icA == null) {
            AppMethodBeat.o(7789);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(7746);
                if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing() || ((WebViewUI) n.this.uqV.get()).pzf == null) {
                    AppMethodBeat.o(7746);
                    return;
                }
                ((WebViewUI) n.this.uqV.get()).uwH.icB = str2;
                ((WebViewUI) n.this.uqV.get()).icA.b(((WebViewUI) n.this.uqV.get()).pzf, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(7745);
                        if (((WebViewUI) n.this.uqV.get()).uwH.icF != null) {
                            ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "show webkit menu");
                            ((WebViewUI) n.this.uqV.get()).uwH.b(contextMenu, ((WebViewUI) n.this.uqV.get()).uwH.icF);
                            ((WebViewUI) n.this.uqV.get()).uwH.icF = null;
                            AppMethodBeat.o(7745);
                            return;
                        }
                        if (((WebViewUI) n.this.uqV.get()).uwH.icG != null) {
                            ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "show IX5 menu");
                            ((WebViewUI) n.this.uqV.get()).uwH.a(contextMenu, ((WebViewUI) n.this.uqV.get()).uwH.icG);
                            ((WebViewUI) n.this.uqV.get()).uwH.icG = null;
                        }
                        AppMethodBeat.o(7745);
                    }
                }, null);
                ((WebViewUI) n.this.uqV.get()).icA.cuu();
                AppMethodBeat.o(7746);
            }
        });
        AppMethodBeat.o(7789);
    }

    public final void q(final int i, final Bundle bundle) {
        AppMethodBeat.i(7790);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7790);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(7748);
                if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing() || ((WebViewUI) n.this.uqV.get()).pzf == null) {
                    AppMethodBeat.o(7748);
                    return;
                }
                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible, actionCode = " + i);
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
                    ab.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible data is null.");
                    AppMethodBeat.o(7748);
                    return;
                } else {
                    ArrayList stringArrayList = bundle.getStringArrayList("menu_item_list");
                    if (stringArrayList == null || stringArrayList.size() == 0) {
                        ab.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible menuItems is null or nil.");
                        AppMethodBeat.o(7748);
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
                String url = ((WebViewUI) n.this.uqV.get()).pzf.getUrl();
                SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) ((WebViewUI) n.this.uqV.get()).uwI.utA.get(url);
                switch (i) {
                    case 3001:
                    case 3003:
                        SparseBooleanArray sparseBooleanArray2;
                        if (sparseBooleanArray == null) {
                            sparseBooleanArray2 = new SparseBooleanArray();
                            ((WebViewUI) n.this.uqV.get()).uwI.utA.put(url, sparseBooleanArray2);
                        } else {
                            sparseBooleanArray2 = sparseBooleanArray;
                        }
                        for (Object obj : hashSet) {
                            int a = bo.a((Integer) ((WebViewUI) n.this.uqV.get()).uwI.utB.get(obj), -1);
                            if (a >= 0) {
                                sparseBooleanArray2.put(a, true);
                            }
                        }
                        ((WebViewUI) n.this.uqV.get()).uwI.Kt();
                        AppMethodBeat.o(7748);
                        return;
                    case 3002:
                    case 3004:
                        if (sparseBooleanArray != null) {
                            for (Object obj2 : hashSet) {
                                int a2 = bo.a((Integer) ((WebViewUI) n.this.uqV.get()).uwI.utB.get(obj2), -1);
                                if (a2 >= 0) {
                                    sparseBooleanArray.delete(a2);
                                }
                            }
                            ((WebViewUI) n.this.uqV.get()).uwI.Kt();
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(7748);
            }
        });
        AppMethodBeat.o(7790);
    }

    public final void hd(final String str, String str2) {
        AppMethodBeat.i(7791);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(7749);
                if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                    AppMethodBeat.o(7749);
                } else if (bo.isNullOrNil(((WebViewUI) n.this.uqV.get()).pzf.getUrl())) {
                    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, null url");
                    AppMethodBeat.o(7749);
                } else {
                    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, userName = " + str);
                    ((WebViewUI) n.this.uqV.get()).uwb.put(((WebViewUI) n.this.uqV.get()).pzf.getUrl(), str);
                    AppMethodBeat.o(7749);
                }
            }
        });
        AppMethodBeat.o(7791);
    }

    private Intent getIntent() {
        AppMethodBeat.i(7792);
        Intent intent = ((WebViewUI) this.uqV.get()).getIntent();
        AppMethodBeat.o(7792);
        return intent;
    }

    private int afH(String str) {
        AppMethodBeat.i(7793);
        int afH = ((WebViewUI) this.uqV.get()).afH(str);
        AppMethodBeat.o(7793);
        return afH;
    }

    public final Bundle g(int i, final Bundle bundle) {
        AppMethodBeat.i(7794);
        ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "invokeAsResult, actionCode = ".concat(String.valueOf(i)));
        final Bundle bundle2 = new Bundle();
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7794);
            return bundle2;
        }
        k kVar = ((WebViewUI) this.uqV.get()).icz;
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
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7766);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7766);
                            return;
                        }
                        if (((WebViewUI) n.this.uqV.get()).uwf != null && ((WebViewUI) n.this.uqV.get()).uwf.isShowing()) {
                            ((WebViewUI) n.this.uqV.get()).uwf.dismiss();
                        }
                        AppMethodBeat.o(7766);
                    }
                });
                break;
            case 12:
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7767);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7767);
                            return;
                        }
                        ((WebViewUI) n.this.uqV.get()).uwe = null;
                        AppMethodBeat.o(7767);
                    }
                });
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
                    if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).FC(webViewUI.cWL())) {
                        bundle2.putInt("_DATA_CENTER_ITEM_SHOW_TYPE", webViewUI.uvq);
                        break;
                    }
                }
                break;
            case 22:
                bundle2.putInt("pay_channel", getIntent().getIntExtra("pay_channel", -1));
                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "key value: pay channel(%d)", Integer.valueOf(getIntent().getIntExtra("pay_channel", -1)));
                break;
            case 25:
                bundle2.putInt("scene", getIntent().getIntExtra("scene", -1));
                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: Scene(%d)", Integer.valueOf(getIntent().getIntExtra("scene", 0)));
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
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7752);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7752);
                            return;
                        }
                        ((WebViewUI) n.this.uqV.get()).daj();
                        AppMethodBeat.o(7752);
                    }
                });
                break;
            case 35:
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7755);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7755);
                            return;
                        }
                        ((WebViewUI) n.this.uqV.get()).uwX.startLoading();
                        AppMethodBeat.o(7755);
                    }
                });
                break;
            case 36:
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7753);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7753);
                            return;
                        }
                        ((WebViewUI) n.this.uqV.get()).uwX.stopLoading();
                        AppMethodBeat.o(7753);
                    }
                });
                break;
            case g.CTRL_INDEX /*37*/:
                string = bundle.getString("show_kb_placeholder");
                afH = bundle.getInt("show_kb_max_length");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7757);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7757);
                            return;
                        }
                        ((WebViewUI) n.this.uqV.get()).dE(string, afH);
                        AppMethodBeat.o(7757);
                    }
                });
                break;
            case 38:
                if (bundle.getInt("webview_disable_bounce_scroll_top", 0) > 0) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(7751);
                            if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                                AppMethodBeat.o(7751);
                                return;
                            }
                            ((WebViewUI) n.this.uqV.get()).uwX.nM(true);
                            AppMethodBeat.o(7751);
                        }
                    });
                    break;
                }
                break;
            case 39:
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7756);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7756);
                            return;
                        }
                        WebViewUI webViewUI = (WebViewUI) n.this.uqV.get();
                        if (webViewUI.pzf != null) {
                            webViewUI.pzf.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new ValueCallback<String>() {
                                public final /* synthetic */ void onReceiveValue(Object obj) {
                                    AppMethodBeat.i(7813);
                                    String str = (String) obj;
                                    ab.d("MicroMsg.WebViewUI", "get background color s = %s", str);
                                    if (!bo.isNullOrNil(str)) {
                                        int color = WebViewUI.this.getResources().getColor(R.color.a5v);
                                        String[] split;
                                        if (WebViewUI.uiv.matcher(str).matches()) {
                                            split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                                            if (split.length == 4) {
                                                try {
                                                    color = Color.argb(bo.getInt(bo.nullAsNil(split[3]).trim(), 0), bo.getInt(bo.nullAsNil(split[0]).trim(), 0), bo.getInt(bo.nullAsNil(split[1]).trim(), 0), bo.getInt(bo.nullAsNil(split[2]).trim(), 0));
                                                } catch (Exception e) {
                                                    ab.e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", str, e);
                                                    AppMethodBeat.o(7813);
                                                    return;
                                                }
                                            }
                                        } else if (WebViewUI.uiw.matcher(str).matches()) {
                                            split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                                            if (split.length == 3) {
                                                try {
                                                    color = Color.argb(255, bo.getInt(bo.nullAsNil(split[0]).trim(), 0), bo.getInt(bo.nullAsNil(split[1]).trim(), 0), bo.getInt(bo.nullAsNil(split[2]).trim(), 0));
                                                } catch (Exception e2) {
                                                    ab.e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", str, e2);
                                                    AppMethodBeat.o(7813);
                                                    return;
                                                }
                                            }
                                        } else {
                                            ab.d("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, can not match", str);
                                        }
                                        WebViewUI.this.uwX.Jp(color);
                                    }
                                    AppMethodBeat.o(7813);
                                }
                            });
                        }
                        AppMethodBeat.o(7756);
                    }
                });
                break;
            case 43:
                string2 = bundle.getString("set_page_title_text");
                string3 = bundle.getString("set_page_title_color");
                webViewUI = (WebViewUI) this.uqV.get();
                if (com.tencent.mm.compatible.util.d.iW(21) && webViewUI.dac()) {
                    i2 = WebView.NIGHT_MODE_COLOR;
                } else {
                    i2 = webViewUI.getResources().getColor(R.color.du);
                }
                g.bx(string3, i2);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7759);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7759);
                        } else if (((WebViewUI) n.this.uqV.get()).rpm) {
                            if (string2 != null) {
                                ((WebViewUI) n.this.uqV.get()).setMMTitle(string2);
                            }
                            AppMethodBeat.o(7759);
                        } else {
                            AppMethodBeat.o(7759);
                        }
                    }
                });
                break;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                Bitmap bitmap;
                string4 = bundle.getString("set_navigation_bar_buttons_text");
                string = bundle.getString("set_navigation_bar_buttons_icon_data");
                z = bundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
                if (bo.isNullOrNil(string)) {
                    bitmap = null;
                } else {
                    try {
                        bitmap = g.afz(string);
                    } catch (Exception e) {
                        bitmap = null;
                        ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "setNavigationBarButtons, decode base64 image, exception = %s", e);
                    }
                }
                bx = g.bx(bundle.getString("set_navigation_bar_buttons_left_text_color"), WebView.NIGHT_MODE_COLOR);
                final boolean z3 = bundle.getBoolean("set_navigation_bar_buttons_need_click_event", false);
                afy = (int) g.afy(bundle.getString("set_navigation_bar_buttons_text_color"));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7764);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7764);
                        } else if (z) {
                            ((WebViewUI) n.this.uqV.get()).nR(true);
                            AppMethodBeat.o(7764);
                        } else {
                            Boolean bool;
                            String dae = ((WebViewUI) n.this.uqV.get()).dae();
                            if (bo.isNullOrNil(dae)) {
                                bool = null;
                            } else {
                                bool = (Boolean) ((WebViewUI) n.this.uqV.get()).uwd.get(dae);
                            }
                            ((WebViewUI) n.this.uqV.get()).nR(Boolean.valueOf(bool == null ? false : bool.booleanValue()).booleanValue());
                            if (bitmap != null && !bitmap.isRecycled()) {
                                ((WebViewUI) n.this.uqV.get()).c(string4, new BitmapDrawable(((WebViewUI) n.this.uqV.get()).getResources(), bitmap));
                                if (z3) {
                                    ((WebViewUI) n.this.uqV.get()).a(0, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                                        public final boolean onMenuItemClick(MenuItem menuItem) {
                                            AppMethodBeat.i(7760);
                                            ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                                            ((WebViewUI) n.this.uqV.get()).uhz.dco();
                                            AppMethodBeat.o(7760);
                                            return false;
                                        }
                                    });
                                }
                            } else if (bo.isNullOrNil(string4)) {
                                ((WebViewUI) n.this.uqV.get()).a(((WebViewUI) n.this.uqV.get()).dat(), (OnMenuItemClickListener) new OnMenuItemClickListener() {
                                    public final boolean onMenuItemClick(MenuItem menuItem) {
                                        AppMethodBeat.i(7763);
                                        ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                                        ((WebViewUI) n.this.uqV.get()).uhz.dco();
                                        AppMethodBeat.o(7763);
                                        return false;
                                    }
                                }, ((WebViewUI) n.this.uqV.get()).uxc);
                            } else if (afy == -1) {
                                ((WebViewUI) n.this.uqV.get()).addTextOptionMenu(0, string4, new OnMenuItemClickListener() {
                                    public final boolean onMenuItemClick(MenuItem menuItem) {
                                        AppMethodBeat.i(7761);
                                        ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                                        ((WebViewUI) n.this.uqV.get()).uhz.dco();
                                        AppMethodBeat.o(7761);
                                        return false;
                                    }
                                });
                            } else {
                                ((WebViewUI) n.this.uqV.get()).a(string4, afy, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                                    public final boolean onMenuItemClick(MenuItem menuItem) {
                                        AppMethodBeat.i(7762);
                                        ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                                        ((WebViewUI) n.this.uqV.get()).uhz.dco();
                                        AppMethodBeat.o(7762);
                                        return false;
                                    }
                                });
                            }
                            ((WebViewUI) n.this.uqV.get()).Jt(bx);
                            AppMethodBeat.o(7764);
                        }
                    }
                });
                break;
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7765);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7765);
                            return;
                        }
                        boolean z = bundle.getBoolean("enable_fullscreen_params_enable", false);
                        if (n.b(n.this) != null) {
                            n.b(n.this).removeExtra("show_full_screen");
                        }
                        ((WebViewUI) n.this.uqV.get()).W(z, false);
                        AppMethodBeat.o(7765);
                    }
                });
                break;
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7754);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7754);
                            return;
                        }
                        ((WebViewUI) n.this.uqV.get()).uwX.cZU();
                        AppMethodBeat.o(7754);
                    }
                });
                break;
            case 48:
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                break;
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7768);
                        if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                            AppMethodBeat.o(7768);
                            return;
                        }
                        ((WebViewUI) n.this.uqV.get()).ac(bundle);
                        AppMethodBeat.o(7768);
                    }
                });
                break;
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                boolean z4 = bundle.getBoolean("add_shortcut_status");
                if (((WebViewUI) this.uqV.get()).uhz != null) {
                    ((WebViewUI) this.uqV.get()).uhz.oa(z4);
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
            case c.CTRL_INDEX /*72*/:
                ((WebViewUI) this.uqV.get()).uwX.Jp(g.bx(bundle.getString("key_set_bounce_background_color"), ((WebViewUI) this.uqV.get()).getResources().getColor(R.color.a5v)));
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.share.c.CTRL_INDEX /*73*/:
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
                        case g.CTRL_INDEX /*37*/:
                        case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                            bundle2.putStringArrayList("proof", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                            break;
                        case 33:
                            bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                            break;
                        case 34:
                            if (!bo.isNullOrNil(intent.getStringExtra("k_webview_img"))) {
                                string2 = intent.getStringExtra("k_webview_img");
                                byte[] e2 = com.tencent.mm.vfs.e.e(string2, 0, (int) com.tencent.mm.vfs.e.asZ(string2));
                                com.tencent.mm.vfs.e.deleteFile(string2);
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
                            ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "unknown expose scene: %d", Integer.valueOf(bundle.getInt("scene")));
                            AppMethodBeat.o(7794);
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
            case com.tencent.mm.plugin.appbrand.jsapi.m.e.CTRL_INDEX /*84*/:
                mMTitle = ((WebViewUI) this.uqV.get()).mController.getMMTitle();
                string2 = getCurrentUrl();
                bundle2.putString("webview_current_url", string2);
                bundle2.putString("webview_current_title", mMTitle != null ? mMTitle.toString() : "");
                bundle2.putString("webview_current_desc", string2);
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.l.i.CTRL_INDEX /*85*/:
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
            case com.tencent.view.d.MIC_COLORPENCIL /*87*/:
                if (!((WebViewUI) this.uqV.get()).uwq) {
                    bundle2.putString("full_url", bo.nullAsNil(((WebViewUI) this.uqV.get()).jUg));
                    if (((WebViewUI) this.uqV.get()).uws != null && ((WebViewUI) this.uqV.get()).uws.size() != 0) {
                        bundle2.putInt("set_cookie", 1);
                        com.tencent.xweb.c.jx(ah.getContext());
                        com.tencent.xweb.b dTR = com.tencent.xweb.b.dTR();
                        for (String string6 : ((WebViewUI) this.uqV.get()).uws.keySet()) {
                            dTR.setCookie(bo.anB(((WebViewUI) this.uqV.get()).jUg), string6 + "=" + ((String) ((WebViewUI) this.uqV.get()).uws.get(string6)));
                        }
                        dTR.setCookie(bo.anB(((WebViewUI) this.uqV.get()).jUg), "httponly");
                        com.tencent.xweb.c.dTT();
                        com.tencent.xweb.c.sync();
                        ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "cookies:%s", dTR.getCookie(bo.anB(((WebViewUI) this.uqV.get()).jUg)));
                        break;
                    }
                    bundle2.putInt("set_cookie", 0);
                    break;
                }
                bundle2.putString("result", "not_return");
                break;
            case 95:
                ((WebViewUI) this.uqV.get()).ab(bundle);
                break;
            case PlayerException.EXCEPTION_IN_RELEASE /*97*/:
                bundle2.putInt("web_page_count", WebViewUI.uwz);
                break;
            case 99:
                bundle2.putInt("geta8key_scene", getIntent().getIntExtra("geta8key_scene", 0));
                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "Key value: getA8KeyScene(%d)", Integer.valueOf(i2));
                break;
            case 101:
                bundle.setClassLoader(WebViewUI.class.getClassLoader());
                com.tencent.mm.bp.d.b((Context) this.uqV.get(), bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", ((WebViewUI) this.uqV.get()).cMm));
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
                if (!(bo.isNullOrNil(string3) || ((WebViewUI) this.uqV.get()).icz == null || kVar == null)) {
                    JsapiPermissionWrapper aei = kVar.aei(string3);
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
                    com.tencent.mm.plugin.wepkg.c cVar = ((GameWebViewUI) this.uqV.get()).uDe;
                    if (cVar != null) {
                        bundle2.putString("comm_js_version", com.tencent.mm.plugin.wepkg.c.dgk());
                        bundle2.putString("wepkg_version", cVar.dgj());
                        bundle2.putBoolean("is_used_wepkg", cVar.uVv);
                        break;
                    }
                }
                break;
            case 200:
                com.tencent.mm.plugin.brandservice.a.b.a aVar = new com.tencent.mm.plugin.brandservice.a.b.a();
                bundle2.putBoolean("success", ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).a((Context) this.uqV.get(), bundle.getString("url"), bundle.getInt("item_show_type"), bundle.getInt("scene"), bundle.getInt("openType"), aVar));
                if (!(aVar.success || aVar.message == null)) {
                    bundle2.putString("desc", aVar.message);
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
            case com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA /*253*/:
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
                        ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
                        ((WebViewUI) this.uqV.get()).uvh.enable();
                    }
                } else if (((WebViewUI) this.uqV.get()).screenOrientation == 1002) {
                    ((WebViewUI) this.uqV.get()).screenOrientation = 1;
                    if (((WebViewUI) this.uqV.get()).uvh != null) {
                        ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "OrientationListener, start listen orientation change");
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
                final j jVar = new j();
                jVar.csb.context = ((WebViewUI) this.uqV.get()).mController.ylL;
                jVar.csb.actionCode = i;
                if (WearableStatusCodes.DATA_ITEM_TOO_LARGE == i) {
                    jVar.csb.csd = bundle.getString("apdu");
                } else if (WearableStatusCodes.INVALID_TARGET_NODE == i) {
                    string6 = bundle.getString("apdus");
                    z = bundle.getBoolean("breakIfFail", true);
                    boolean z5 = bundle.getBoolean("breakIfTrue", false);
                    jVar.csb.csd = string6;
                    jVar.csb.cse = z;
                    jVar.csb.csf = z5;
                }
                jVar.callback = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7750);
                        bundle2.putAll(jVar.csc.csg);
                        AppMethodBeat.o(7750);
                    }
                };
                com.tencent.mm.sdk.b.a.xxA.m(jVar);
                break;
            case ReaderCallback.HIDDEN_BAR /*5001*/:
                if (((WebViewUI) this.uqV.get()).icy.isSDCardAvailable()) {
                    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "availableSize = %d", Long.valueOf(bd.dpq()));
                    if (bd.dpq() < 524288000) {
                        ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "available size not enough");
                    } else {
                        File file = new File(com.tencent.mm.plugin.webview.a.ueu);
                        z2 = true;
                        if (!file.exists()) {
                            z2 = file.mkdirs();
                            ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "create proxy cache path : %s, %b", file.getAbsolutePath(), Boolean.valueOf(z2));
                        }
                        if (z2) {
                            i2 = FactoryProxyManager.getPlayManager().init(ah.getContext(), com.tencent.mm.plugin.webview.a.ueu);
                            FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                            i3 = i2;
                        }
                    }
                    i3 = FactoryProxyManager.getPlayManager().init(ah.getContext(), null);
                } else {
                    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "sdcard not available");
                    i3 = FactoryProxyManager.getPlayManager().init(ah.getContext(), null);
                }
                if (i3 == 0) {
                    if (((WebViewUI) this.uqV.get()).uwJ == null) {
                        ((WebViewUI) this.uqV.get()).uwJ = new h((WebViewUI) this.uqV.get());
                        FactoryProxyManager.getPlayManager().setUtilsObject(((WebViewUI) this.uqV.get()).uwJ);
                    }
                    afH = FactoryProxyManager.getPlayManager().getLocalServerPort();
                    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview video init result = %d, local port = %d", Integer.valueOf(i3), Integer.valueOf(afH));
                    an anVar = ((WebViewUI) this.uqV.get()).uwP;
                    if (afH <= 0 || afH > CdnLogic.kBizGeneric) {
                        ab.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", Integer.valueOf(afH));
                    }
                    if (!anVar.umD.contains(Integer.valueOf(afH))) {
                        anVar.umD.add(Integer.valueOf(afH));
                    }
                }
                bundle2.putInt("webview_video_proxy_init", i3);
                break;
            case ReaderCallback.SHOW_BAR /*5002*/:
                i2 = FactoryProxyManager.getPlayManager().startPlay(bundle.getString("webview_video_proxy_cdn_urls"), bundle.getInt("webview_video_proxy_file_type"), bundle.getString("webview_video_proxy_fileId"), (long) bundle.getInt("webview_video_proxy_file_size"), bundle.getInt("webview_video_proxy_file_duration"));
                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", string2, string5, Integer.valueOf(bx), Integer.valueOf(afy), Integer.valueOf(i3), Integer.valueOf(i2), FactoryProxyManager.getPlayManager().buildPlayURLMp4(i2));
                bundle2.putInt("webview_video_proxy_play_data_id", i2);
                bundle2.putString("webview_video_proxy_local_url", string4);
                break;
            case ReaderCallback.COPY_SELECT_TEXT /*5003*/:
                i2 = bundle.getInt("webview_video_proxy_play_data_id");
                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "webview proxy stop play, play id = %d", Integer.valueOf(i2));
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
                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "playid = %d, duration = %d", Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration")));
                bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(i2, afH));
                break;
            case 6001:
                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "includeCookie = %b", Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false)));
                Intent intent3 = new Intent();
                intent3.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                intent3.putExtra("tools_clean_webview_cache_ignore_cookie", z2);
                com.tencent.mm.cj.c.aZ(intent3);
                break;
            case 90000:
                bundle2.putStringArray("webview_get_route_url_list", ((WebViewUI) this.uqV.get()).uwG.cYO());
                bundle2.putInt("webview_get_route_url_geta8key_scene", afH(getIntent().getStringExtra("geta8key_username")));
                bundle2.putString("geta8key_username", getIntent().getStringExtra("geta8key_username"));
                break;
            case 90001:
                Float valueOf;
                ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "url = %s, cookie = %s", ((WebViewUI) this.uqV.get()).dae(), com.tencent.xweb.b.dTR().getCookie(((WebViewUI) this.uqV.get()).dae()));
                bundle2.putString("cookie", string2);
                Float valueOf2 = Float.valueOf(com.tencent.mm.ca.a.dmO());
                if (((WebViewUI) this.uqV.get()).pzf != null && ((WebViewUI) this.uqV.get()).pzf.getWebCoreType() == com.tencent.xweb.WebView.d.WV_KIND_CW && XWalkEnvironment.getUsingCustomContext()) {
                    valueOf = Float.valueOf(((WebViewUI) this.uqV.get()).pzf.getResources().getDisplayMetrics().density);
                } else {
                    valueOf = valueOf2;
                }
                bundle2.putFloat(Constants.PARAM_DENSITY, valueOf.floatValue());
                break;
            case 90002:
                m.uuj.hg(bundle.getString("traceid"), bundle.getString("username"));
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
                bundle2.putString("geta8key_data_net_type", aq.cXS());
                bundle2.putInt("geta8key_session_id", ((WebViewUI) this.uqV.get()).uvB);
                bundle2.putInt("webview_binder_id", ((WebViewUI) this.uqV.get()).hashCode());
                bundle2.putByteArray("k_a8key_cookie", ((WebViewUI) this.uqV.get()).uvD);
                bundle2.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
                break;
            case 90004:
                string3 = bundle.getString("geta8key_result_req_url");
                string5 = bundle.getString("geta8key_result_full_url");
                if (!bo.isNullOrNil(string5)) {
                    kVar.a(string5.replaceFirst("http://", "https//"), new JsapiPermissionWrapper(bundle.getByteArray("geta8key_result_jsapi_perm_control_bytes")), new GeneralControlWrapper(bundle.getInt("geta8key_result_general_ctrl_b1")));
                    String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
                    String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
                    Map hashMap = new HashMap();
                    if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
                        for (i2 = 0; i2 < stringArray.length; i2++) {
                            hashMap.put(stringArray[i2], stringArray2[i2]);
                        }
                    }
                    ((WebViewUI) this.uqV.get()).b(string3, string5, hashMap);
                    break;
                }
                ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "updatePageAuth fail fullUrl is null");
                break;
            case 90005:
                ((WebViewUI) this.uqV.get()).FY(bundle.getString(m.ygh, ""));
                break;
            case 100000:
                ((WebViewUI) this.uqV.get()).uwD = true;
                break;
            default:
                ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "undefine action code!!!");
                break;
        }
        AppMethodBeat.o(7794);
        return bundle2;
    }

    public final void X(Bundle bundle) {
        AppMethodBeat.i(7795);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7795);
            return;
        }
        ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "setCustomMenu");
        ArrayList stringArrayList = bundle.getStringArrayList("keys");
        ArrayList stringArrayList2 = bundle.getStringArrayList("titles");
        int size = stringArrayList.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tencent.mm.m.d.b((String) stringArrayList.get(i), (String) stringArrayList2.get(i)));
        }
        if (stringArrayList.size() > 0) {
            String url = ((WebViewUI) this.uqV.get()).pzf.getUrl();
            if (((WebViewUI) this.uqV.get()).uwc.containsKey(url)) {
                ((WebViewUI) this.uqV.get()).uwc.remove(url);
            }
            ((WebViewUI) this.uqV.get()).uwc.put(url, arrayList);
        }
        AppMethodBeat.o(7795);
    }

    public final void nL(boolean z) {
        AppMethodBeat.i(7796);
        if (this.uqV.get() == null || ((WebViewUI) this.uqV.get()).isFinishing()) {
            AppMethodBeat.o(7796);
            return;
        }
        ((WebViewUI) this.uqV.get()).nR(z);
        AppMethodBeat.o(7796);
    }

    public final void he(final String str, final String str2) {
        AppMethodBeat.i(7797);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(7769);
                if (n.this.uqV.get() == null || ((WebViewUI) n.this.uqV.get()).isFinishing()) {
                    AppMethodBeat.o(7769);
                    return;
                }
                if (!bo.isNullOrNil(str)) {
                    if (!bo.isNullOrNil(str2)) {
                        n.b(n.this).putExtra("view_port_code", str2);
                    }
                    ((WebViewUI) n.this.uqV.get()).loadUrl(str);
                }
                AppMethodBeat.o(7769);
            }
        });
        AppMethodBeat.o(7797);
    }

    public final Bundle dj(String str, String str2) {
        AppMethodBeat.i(7798);
        Bundle akC = com.tencent.mm.protocal.c.akC(null);
        AppMethodBeat.o(7798);
        return akC;
    }
}
