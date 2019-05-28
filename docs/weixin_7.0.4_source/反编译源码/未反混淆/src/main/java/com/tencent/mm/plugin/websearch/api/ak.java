package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import com.tencent.xweb.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ak implements l {
    String TAG = "MicroMsg.WebSearch.WebSearchPreloadMgr";
    private al fPG;
    private boolean gQm = false;
    private HashSet<Object> iEl = new HashSet();
    int uaJ;
    boolean uaK;
    List<al> uaL = new LinkedList();
    long uaM;

    /* renamed from: com.tencent.mm.plugin.websearch.api.ak$2 */
    class AnonymousClass2 extends s {
        final /* synthetic */ MMWebView uaO;

        AnonymousClass2(MMWebView mMWebView) {
            this.uaO = mMWebView;
        }

        public final void b(WebView webView, String str) {
            AppMethodBeat.i(124190);
            ab.i(ak.this.TAG, "onPageFinished, view %s", webView.toString());
            ak.this.b(this.uaO);
            AppMethodBeat.o(124190);
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(124191);
            super.b(webView, str, bitmap);
            ab.i(ak.this.TAG, "onPageStarted, view %s", webView.toString());
            u.d(this.uaO);
            AppMethodBeat.o(124191);
        }

        public final boolean a(WebView webView, String str) {
            AppMethodBeat.i(124192);
            if (u.t(str, "weixin://private/setresult/")) {
                ab.i(ak.this.TAG, "handleUrl %s ,view %s", str, webView.toString());
                this.uaO.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
                AppMethodBeat.o(124192);
                return true;
            }
            AppMethodBeat.o(124192);
            return false;
        }
    }

    public static class a {
        static String i(String str, String str2, Map<String, Object> map) {
            AppMethodBeat.i(124198);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("__msg_type", str);
                if (str.equals("event")) {
                    jSONObject.put("__event_id", str2);
                }
                jSONObject.put("__params", ao(map));
                String jSONObject2 = jSONObject.toString();
                AppMethodBeat.o(124198);
                return jSONObject2;
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewPreLoadMgr.Builder", "build fail, exception = " + e.getMessage());
                AppMethodBeat.o(124198);
                return null;
            }
        }

        private static JSONObject ao(Map<String, Object> map) {
            AppMethodBeat.i(124199);
            if (map == null || map.size() == 0) {
                JSONObject jSONObject = new JSONObject();
                AppMethodBeat.o(124199);
                return jSONObject;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (String str : map.keySet()) {
                    if (str != null) {
                        jSONObject2.put(str, map.get(str));
                    }
                }
                AppMethodBeat.o(124199);
                return jSONObject2;
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewPreLoadMgr.Builder", "convertMapToJSON fail, exception = " + e.getMessage());
                AppMethodBeat.o(124199);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.api.ak$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ String val$url;

        AnonymousClass7(String str) {
            this.val$url = str;
        }

        public final void run() {
            AppMethodBeat.i(124197);
            ak akVar = ak.this;
            String str = this.val$url;
            try {
                ab.i(akVar.TAG, "preLoadWebView cached webview size %d", Integer.valueOf(akVar.uaL.size()));
                if (akVar.uaL.size() <= 0) {
                    akVar.uaM = System.currentTimeMillis();
                    MMWebView aXX = akVar.aXX();
                    if (aXX == null) {
                        ab.w(akVar.TAG, "create webview fail");
                    } else {
                        akVar.uaK = false;
                        ab.i(akVar.TAG, "preload %s", aXX.toString());
                        aXX.setPreload(true);
                        aXX.setRandomStr(bo.Mb(16));
                        aXX.getSettings().setJavaScriptEnabled(true);
                        aXX.getSettings().setPluginsEnabled(true);
                        aXX.getSettings().dUh();
                        aXX.getSettings().setBuiltInZoomControls(false);
                        aXX.getSettings().setUseWideViewPort(true);
                        aXX.getSettings().setLoadWithOverviewMode(true);
                        aXX.getSettings().dUc();
                        aXX.getSettings().dUb();
                        aXX.getSettings().setGeolocationEnabled(true);
                        aXX.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                        aXX.getSettings().dUj();
                        aXX.getSettings().dUf();
                        aXX.getSettings().setAppCachePath(aXX.getContext().getDir("webviewcache", 0).getAbsolutePath());
                        aXX.getSettings().dUe();
                        aXX.getSettings().dUg();
                        aXX.getSettings().setDatabasePath(e.eSi + "databases/");
                        b.dTR().dTS();
                        b.dTR().f(aXX);
                        aXX.getSettings().setUserAgentString(u.bh(aXX.getContext(), aXX.getSettings().getUserAgentString()));
                        ah ahVar = new ah();
                        aXX.addJavascriptInterface(ahVar, "__wx");
                        aXX.loadUrl(str);
                        aXX.setWebViewClient(new AnonymousClass2(aXX));
                        Uri parse = Uri.parse(str);
                        akVar.uaL.add(new al(aXX, parse.getQueryParameter("sessionId"), parse.getQueryParameter("subSessionId"), ahVar));
                        h.pYm.e(15005, Integer.valueOf(akVar.uaJ), Integer.valueOf(1), Integer.valueOf(0));
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace(akVar.TAG, e, "", new Object[0]);
            }
            ak.this.done();
            AppMethodBeat.o(124197);
        }
    }

    public ak(int i) {
        AppMethodBeat.i(124200);
        this.uaJ = i;
        this.TAG += "_" + i;
        this.fPG = new al();
        AppMethodBeat.o(124200);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void adF(final String str) {
        AppMethodBeat.i(124201);
        if (ah.doF()) {
            int i;
            if (this.uaJ == 2 || !ap.cVF().cVG()) {
                boolean i2;
                Context context = ah.getContext();
                if (WebView.isXWalk() || WebView.getUsingTbsCoreVersion(context) != 0) {
                    i2 = true;
                } else {
                    ab.i("XWebUtil", "can not preload without x5 or xwalk");
                    i2 = 0;
                }
                if (i2 == 0) {
                    ab.i(this.TAG, "isOpenRecommendPreload webview not support");
                    i2 = true;
                    if (i2 == 0) {
                        ab.w(this.TAG, " preload forbidden");
                        AppMethodBeat.o(124201);
                        return;
                    } else if (!ah.doF()) {
                        ab.w(this.TAG, "preload please call from tools proc");
                        AppMethodBeat.o(124201);
                        return;
                    } else if (al.isMainThread()) {
                        if (!this.gQm) {
                            this.gQm = true;
                            ab.i(this.TAG, "preloading %s ", str);
                            this.fPG.aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(124189);
                                    ab.i(ak.this.TAG, "preload start");
                                    AnonymousClass7 anonymousClass7 = new AnonymousClass7(str);
                                    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                                        anonymousClass7.run();
                                        AppMethodBeat.o(124189);
                                        return;
                                    }
                                    al.d(anonymousClass7);
                                    AppMethodBeat.o(124189);
                                }
                            });
                        }
                        AppMethodBeat.o(124201);
                        return;
                    } else {
                        ab.w(this.TAG, "preload please call from main thread");
                        AppMethodBeat.o(124201);
                        return;
                    }
                }
            }
            ab.i(this.TAG, "use sys webview");
            ab.i(this.TAG, "use sys webview 2");
            i2 = 0;
            if (i2 == 0) {
            }
        } else {
            ab.w(this.TAG, "preload please call from tools proc");
            AppMethodBeat.o(124201);
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean b(final MMWebView mMWebView) {
        Object convertStreamToString;
        AppMethodBeat.i(124202);
        ab.i(this.TAG, "begin jsapi init,wv %s", mMWebView.toString());
        try {
            convertStreamToString = bo.convertStreamToString(mMWebView.getContext().getAssets().open("jsapi/wxjs.js"));
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            convertStreamToString = null;
        }
        if (convertStreamToString == null) {
            ab.e(this.TAG, "loadJavaScript fail, jsContent is null");
            AppMethodBeat.o(124202);
            return false;
        } else if (mMWebView == null) {
            ab.e(this.TAG, "loadJavaScript, viewWV is null");
            AppMethodBeat.o(124202);
            return false;
        } else {
            mMWebView.evaluateJavascript("javascript:".concat(String.valueOf(convertStreamToString)), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(124193);
                    String str = (String) obj;
                    ab.i(ak.this.TAG, "loadJavaScript, jsContent evaluateJavascript cb, ret = %s, view %s", str, mMWebView.toString());
                    AppMethodBeat.o(124193);
                }
            });
            StringBuilder stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            HashMap hashMap = new HashMap();
            hashMap.put("webview_type", "1");
            hashMap.put("init_url", mMWebView.getUrl());
            hashMap.put("init_font_size", "1");
            mMWebView.getRandomStr();
            mMWebView.evaluateJavascript(stringBuilder.append(a.i("event", "sys:init", hashMap)).append(")").toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(124194);
                    String str = (String) obj;
                    ab.i(ak.this.TAG, "loadJS, sys:init callback %s,view %s", str, mMWebView.toString());
                    AppMethodBeat.o(124194);
                }
            });
            stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            mMWebView.getRandomStr();
            mMWebView.evaluateJavascript(stringBuilder.append(a.i("event", "sys:bridged", null)).append(")").toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(124195);
                    String str = (String) obj;
                    ab.i(ak.this.TAG, "loadJS, sys:bridged callback %s,view %s", str, mMWebView.toString());
                    AppMethodBeat.o(124195);
                }
            });
            stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            String str = "sys:attach_runOn3rd_apis";
            hashMap = new HashMap();
            LinkedList linkedList = new LinkedList();
            linkedList.add("menu:share:timeline");
            linkedList.add("menu:share:appmessage");
            linkedList.add("menu:share:weiboApp");
            linkedList.add("menu:share:QZone");
            linkedList.add("menu:share:qq");
            linkedList.add("onVoiceRecordEnd");
            linkedList.add("onVoicePlayBegin");
            linkedList.add("onVoicePlayEnd");
            linkedList.add("onLocalImageUploadProgress");
            linkedList.add("onImageDownloadProgress");
            linkedList.add("onVoiceUploadProgress");
            linkedList.add("onVoiceDownloadProgress");
            linkedList.add("onVideoUploadProgress");
            linkedList.add("onMediaFileUploadProgress");
            linkedList.add("menu:setfont");
            linkedList.add("menu:share:weibo");
            linkedList.add("menu:share:email");
            linkedList.add("wxdownload:state_change");
            linkedList.add("wxdownload:progress_change");
            linkedList.add("hdOnDeviceStateChanged");
            linkedList.add("activity:state_change");
            linkedList.add("onWXDeviceBluetoothStateChange");
            linkedList.add("onWXDeviceLanStateChange");
            linkedList.add("onWXDeviceBindStateChange");
            linkedList.add("onReceiveDataFromWXDevice");
            linkedList.add("onScanWXDeviceResult");
            linkedList.add("onWXDeviceStateChange");
            linkedList.add("onNfcTouch");
            linkedList.add("onBeaconMonitoring");
            linkedList.add("onBeaconsInRange");
            linkedList.add("menu:custom");
            linkedList.add("onSearchWAWidgetOpenApp");
            linkedList.add("onSearchDataReady");
            linkedList.add("onSearchHistoryReady");
            linkedList.add("onSearchWAWidgetOnTapCallback");
            linkedList.add("onSearchImageListReady");
            linkedList.add("onTeachSearchDataReady");
            linkedList.add("onSearchGuideDataReady");
            linkedList.add("onSearchInputChange");
            linkedList.add("onSearchInputConfirm");
            linkedList.add("onSearchSuggestionDataReady");
            linkedList.add("onMusicStatusChanged");
            linkedList.add("switchToTabSearch");
            linkedList.add("onVideoPlayerCallback");
            linkedList.add("onSelectContact");
            linkedList.add("onSearchWAWidgetAttrChanged");
            linkedList.add("onSearchWAWidgetReloadData");
            linkedList.add("onSearchWAWidgetReloadDataFinish");
            linkedList.add("onSearchWAWidgetStateChange");
            linkedList.add("onSearchWAWidgetDataPush");
            linkedList.add("onPullDownRefresh");
            linkedList.add("onPageStateChange");
            linkedList.add("onGetKeyboardHeight");
            linkedList.add("onGetSmiley");
            linkedList.add("onAddShortcutStatus");
            linkedList.add("onFocusSearchInput");
            linkedList.add("onGetA8KeyUrl");
            linkedList.add("deleteAccountSuccess");
            linkedList.add("onGetMsgProofItems");
            linkedList.add("WNJSHandlerInsert");
            linkedList.add("WNJSHandlerMultiInsert");
            linkedList.add("WNJSHandlerExportData");
            linkedList.add("WNJSHandlerHeaderAndFooterChange");
            linkedList.add("WNJSHandlerEditableChange");
            linkedList.add("WNJSHandlerEditingChange");
            linkedList.add("WNJSHandlerSaveSelectionRange");
            linkedList.add("WNJSHandlerLoadSelectionRange");
            linkedList.add("onCustomGameMenuClicked");
            linkedList.add("showLoading");
            linkedList.add("getSearchEmotionDataCallBack");
            linkedList.add("onNavigationBarRightButtonClick");
            linkedList.add("onSearchActionSheetClick");
            linkedList.add("onGetMatchContactList");
            linkedList.add("onUiInit");
            linkedList.add("onNetWorkChange");
            linkedList.add("onBackgroundAudioStateChange");
            if (!bo.ek(null)) {
                linkedList.addAll(null);
            }
            hashMap.put("__runOn3rd_apis", new JSONArray(linkedList));
            mMWebView.getRandomStr();
            mMWebView.evaluateJavascript(stringBuilder.append(a.i("event", str, hashMap)).append(")").toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    int i = 1;
                    AppMethodBeat.i(124196);
                    String str = (String) obj;
                    ab.i(ak.this.TAG, "loadJS, sys:attach_runOn3rd_apis callback %s,view %s", str, mMWebView.toString());
                    ak.this.uaK = true;
                    long currentTimeMillis = System.currentTimeMillis() - ak.this.uaM;
                    h hVar = h.pYm;
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(ak.this.uaJ);
                    objArr[1] = Integer.valueOf(2);
                    objArr[2] = Long.valueOf(currentTimeMillis);
                    if (!ap.cVF().cVG()) {
                        i = 2;
                    }
                    objArr[3] = Integer.valueOf(i);
                    hVar.e(15005, objArr);
                    AppMethodBeat.o(124196);
                }
            });
            ab.i(this.TAG, "jsapi init done");
            AppMethodBeat.o(124202);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final MMWebView aXX() {
        AppMethodBeat.i(124203);
        try {
            MutableContextWrapper mutableContextWrapper = new MutableContextWrapper(ah.getContext());
            MMWebView in;
            if (this.uaJ == 2) {
                in = com.tencent.mm.ui.widget.MMWebView.a.in(mutableContextWrapper);
                AppMethodBeat.o(124203);
                return in;
            } else if (ap.cVF().cVG()) {
                in = com.tencent.mm.ui.widget.MMWebView.a.im(mutableContextWrapper);
                AppMethodBeat.o(124203);
                return in;
            } else {
                in = com.tencent.mm.ui.widget.MMWebView.a.in(mutableContextWrapper);
                AppMethodBeat.o(124203);
                return in;
            }
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            AppMethodBeat.o(124203);
            return null;
        }
    }

    public final Object fn(Context context) {
        AppMethodBeat.i(124204);
        if (ah.doF()) {
            ab.i(this.TAG, "getWebView cached webview size %d", Integer.valueOf(this.uaL.size()));
            if (this.uaL.size() <= 0) {
                AppMethodBeat.o(124204);
                return null;
            } else if (this.uaK) {
                al alVar = (al) this.uaL.get(0);
                if (alVar == null) {
                    this.uaL.remove(0);
                    AppMethodBeat.o(124204);
                    return null;
                }
                MMWebView mMWebView = (MMWebView) alVar.uaQ;
                if (mMWebView.getContext() instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) mMWebView.getContext()).setBaseContext(context);
                }
                this.uaL.remove(alVar);
                this.uaK = false;
                AppMethodBeat.o(124204);
                return alVar;
            } else {
                ab.i(this.TAG, "preload unfinished");
                AppMethodBeat.o(124204);
                return null;
            }
        }
        ab.w(this.TAG, "getWebView please call from tools proc");
        AppMethodBeat.o(124204);
        return null;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void done() {
        AppMethodBeat.i(124205);
        ab.i(this.TAG, "preInit finished");
        this.gQm = false;
        Iterator it = this.iEl.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.iEl.clear();
        AppMethodBeat.o(124205);
    }
}
