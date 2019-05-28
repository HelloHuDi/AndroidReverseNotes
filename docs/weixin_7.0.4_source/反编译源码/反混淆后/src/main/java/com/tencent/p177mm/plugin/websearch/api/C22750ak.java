package com.tencent.p177mm.plugin.websearch.api;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p612ui.widget.MMWebView.C30798a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C44576b;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.websearch.api.ak */
public final class C22750ak implements C46403l {
    String TAG = "MicroMsg.WebSearch.WebSearchPreloadMgr";
    private C5004al fPG;
    private boolean gQm = false;
    private HashSet<Object> iEl = new HashSet();
    int uaJ;
    boolean uaK;
    List<C4513al> uaL = new LinkedList();
    long uaM;

    /* renamed from: com.tencent.mm.plugin.websearch.api.ak$2 */
    class C227512 extends C36592s {
        final /* synthetic */ MMWebView uaO;

        C227512(MMWebView mMWebView) {
            this.uaO = mMWebView;
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(124190);
            C4990ab.m7417i(C22750ak.this.TAG, "onPageFinished, view %s", webView.toString());
            C22750ak.this.mo38327b(this.uaO);
            AppMethodBeat.m2505o(124190);
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(124191);
            super.mo7562b(webView, str, bitmap);
            C4990ab.m7417i(C22750ak.this.TAG, "onPageStarted, view %s", webView.toString());
            C30152u.m47748d(this.uaO);
            AppMethodBeat.m2505o(124191);
        }

        /* renamed from: a */
        public final boolean mo4762a(WebView webView, String str) {
            AppMethodBeat.m2504i(124192);
            if (C30152u.m47751t(str, "weixin://private/setresult/")) {
                C4990ab.m7417i(C22750ak.this.TAG, "handleUrl %s ,view %s", str, webView.toString());
                this.uaO.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
                AppMethodBeat.m2505o(124192);
                return true;
            }
            AppMethodBeat.m2505o(124192);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.api.ak$a */
    public static class C22755a {
        /* renamed from: i */
        static String m34536i(String str, String str2, Map<String, Object> map) {
            AppMethodBeat.m2504i(124198);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("__msg_type", str);
                if (str.equals("event")) {
                    jSONObject.put("__event_id", str2);
                }
                jSONObject.put("__params", C22755a.m34535ao(map));
                String jSONObject2 = jSONObject.toString();
                AppMethodBeat.m2505o(124198);
                return jSONObject2;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewPreLoadMgr.Builder", "build fail, exception = " + e.getMessage());
                AppMethodBeat.m2505o(124198);
                return null;
            }
        }

        /* renamed from: ao */
        private static JSONObject m34535ao(Map<String, Object> map) {
            AppMethodBeat.m2504i(124199);
            if (map == null || map.size() == 0) {
                JSONObject jSONObject = new JSONObject();
                AppMethodBeat.m2505o(124199);
                return jSONObject;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (String str : map.keySet()) {
                    if (str != null) {
                        jSONObject2.put(str, map.get(str));
                    }
                }
                AppMethodBeat.m2505o(124199);
                return jSONObject2;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewPreLoadMgr.Builder", "convertMapToJSON fail, exception = " + e.getMessage());
                AppMethodBeat.m2505o(124199);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.api.ak$7 */
    class C227567 implements Runnable {
        final /* synthetic */ String val$url;

        C227567(String str) {
            this.val$url = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(124197);
            C22750ak c22750ak = C22750ak.this;
            String str = this.val$url;
            try {
                C4990ab.m7417i(c22750ak.TAG, "preLoadWebView cached webview size %d", Integer.valueOf(c22750ak.uaL.size()));
                if (c22750ak.uaL.size() <= 0) {
                    c22750ak.uaM = System.currentTimeMillis();
                    MMWebView aXX = c22750ak.aXX();
                    if (aXX == null) {
                        C4990ab.m7420w(c22750ak.TAG, "create webview fail");
                    } else {
                        c22750ak.uaK = false;
                        C4990ab.m7417i(c22750ak.TAG, "preload %s", aXX.toString());
                        aXX.setPreload(true);
                        aXX.setRandomStr(C5046bo.m7507Mb(16));
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
                        aXX.getSettings().setDatabasePath(C6457e.eSi + "databases/");
                        C44576b.dTR().dTS();
                        C44576b.dTR().mo71378f(aXX);
                        aXX.getSettings().setUserAgentString(C30152u.m47747bh(aXX.getContext(), aXX.getSettings().getUserAgentString()));
                        C35571ah c35571ah = new C35571ah();
                        aXX.addJavascriptInterface(c35571ah, "__wx");
                        aXX.loadUrl(str);
                        aXX.setWebViewClient(new C227512(aXX));
                        Uri parse = Uri.parse(str);
                        c22750ak.uaL.add(new C4513al(aXX, parse.getQueryParameter("sessionId"), parse.getQueryParameter("subSessionId"), c35571ah));
                        C7060h.pYm.mo8381e(15005, Integer.valueOf(c22750ak.uaJ), Integer.valueOf(1), Integer.valueOf(0));
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(c22750ak.TAG, e, "", new Object[0]);
            }
            C22750ak.this.done();
            AppMethodBeat.m2505o(124197);
        }
    }

    public C22750ak(int i) {
        AppMethodBeat.m2504i(124200);
        this.uaJ = i;
        this.TAG += "_" + i;
        this.fPG = new C5004al();
        AppMethodBeat.m2505o(124200);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void adF(final String str) {
        AppMethodBeat.m2504i(124201);
        if (C4996ah.doF()) {
            int i;
            if (this.uaJ == 2 || !C35575ap.cVF().cVG()) {
                boolean i2;
                Context context = C4996ah.getContext();
                if (WebView.isXWalk() || WebView.getUsingTbsCoreVersion(context) != 0) {
                    i2 = true;
                } else {
                    C4990ab.m7416i("XWebUtil", "can not preload without x5 or xwalk");
                    i2 = 0;
                }
                if (i2 == 0) {
                    C4990ab.m7416i(this.TAG, "isOpenRecommendPreload webview not support");
                    i2 = true;
                    if (i2 == 0) {
                        C4990ab.m7420w(this.TAG, " preload forbidden");
                        AppMethodBeat.m2505o(124201);
                        return;
                    } else if (!C4996ah.doF()) {
                        C4990ab.m7420w(this.TAG, "preload please call from tools proc");
                        AppMethodBeat.m2505o(124201);
                        return;
                    } else if (C5004al.isMainThread()) {
                        if (!this.gQm) {
                            this.gQm = true;
                            C4990ab.m7417i(this.TAG, "preloading %s ", str);
                            this.fPG.mo10302aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(124189);
                                    C4990ab.m7416i(C22750ak.this.TAG, "preload start");
                                    C227567 c227567 = new C227567(str);
                                    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                                        c227567.run();
                                        AppMethodBeat.m2505o(124189);
                                        return;
                                    }
                                    C5004al.m7441d(c227567);
                                    AppMethodBeat.m2505o(124189);
                                }
                            });
                        }
                        AppMethodBeat.m2505o(124201);
                        return;
                    } else {
                        C4990ab.m7420w(this.TAG, "preload please call from main thread");
                        AppMethodBeat.m2505o(124201);
                        return;
                    }
                }
            }
            C4990ab.m7416i(this.TAG, "use sys webview");
            C4990ab.m7416i(this.TAG, "use sys webview 2");
            i2 = 0;
            if (i2 == 0) {
            }
        } else {
            C4990ab.m7420w(this.TAG, "preload please call from tools proc");
            AppMethodBeat.m2505o(124201);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo38327b(final MMWebView mMWebView) {
        Object convertStreamToString;
        AppMethodBeat.m2504i(124202);
        C4990ab.m7417i(this.TAG, "begin jsapi init,wv %s", mMWebView.toString());
        try {
            convertStreamToString = C5046bo.convertStreamToString(mMWebView.getContext().getAssets().open("jsapi/wxjs.js"));
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            convertStreamToString = null;
        }
        if (convertStreamToString == null) {
            C4990ab.m7412e(this.TAG, "loadJavaScript fail, jsContent is null");
            AppMethodBeat.m2505o(124202);
            return false;
        } else if (mMWebView == null) {
            C4990ab.m7412e(this.TAG, "loadJavaScript, viewWV is null");
            AppMethodBeat.m2505o(124202);
            return false;
        } else {
            mMWebView.evaluateJavascript("javascript:".concat(String.valueOf(convertStreamToString)), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.m2504i(124193);
                    String str = (String) obj;
                    C4990ab.m7417i(C22750ak.this.TAG, "loadJavaScript, jsContent evaluateJavascript cb, ret = %s, view %s", str, mMWebView.toString());
                    AppMethodBeat.m2505o(124193);
                }
            });
            StringBuilder stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            HashMap hashMap = new HashMap();
            hashMap.put("webview_type", "1");
            hashMap.put("init_url", mMWebView.getUrl());
            hashMap.put("init_font_size", "1");
            mMWebView.getRandomStr();
            mMWebView.evaluateJavascript(stringBuilder.append(C22755a.m34536i("event", "sys:init", hashMap)).append(")").toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.m2504i(124194);
                    String str = (String) obj;
                    C4990ab.m7417i(C22750ak.this.TAG, "loadJS, sys:init callback %s,view %s", str, mMWebView.toString());
                    AppMethodBeat.m2505o(124194);
                }
            });
            stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            mMWebView.getRandomStr();
            mMWebView.evaluateJavascript(stringBuilder.append(C22755a.m34536i("event", "sys:bridged", null)).append(")").toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.m2504i(124195);
                    String str = (String) obj;
                    C4990ab.m7417i(C22750ak.this.TAG, "loadJS, sys:bridged callback %s,view %s", str, mMWebView.toString());
                    AppMethodBeat.m2505o(124195);
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
            if (!C5046bo.m7548ek(null)) {
                linkedList.addAll(null);
            }
            hashMap.put("__runOn3rd_apis", new JSONArray(linkedList));
            mMWebView.getRandomStr();
            mMWebView.evaluateJavascript(stringBuilder.append(C22755a.m34536i("event", str, hashMap)).append(")").toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    int i = 1;
                    AppMethodBeat.m2504i(124196);
                    String str = (String) obj;
                    C4990ab.m7417i(C22750ak.this.TAG, "loadJS, sys:attach_runOn3rd_apis callback %s,view %s", str, mMWebView.toString());
                    C22750ak.this.uaK = true;
                    long currentTimeMillis = System.currentTimeMillis() - C22750ak.this.uaM;
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(C22750ak.this.uaJ);
                    objArr[1] = Integer.valueOf(2);
                    objArr[2] = Long.valueOf(currentTimeMillis);
                    if (!C35575ap.cVF().cVG()) {
                        i = 2;
                    }
                    objArr[3] = Integer.valueOf(i);
                    c7060h.mo8381e(15005, objArr);
                    AppMethodBeat.m2505o(124196);
                }
            });
            C4990ab.m7416i(this.TAG, "jsapi init done");
            AppMethodBeat.m2505o(124202);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final MMWebView aXX() {
        AppMethodBeat.m2504i(124203);
        try {
            MutableContextWrapper mutableContextWrapper = new MutableContextWrapper(C4996ah.getContext());
            MMWebView in;
            if (this.uaJ == 2) {
                in = C30798a.m49145in(mutableContextWrapper);
                AppMethodBeat.m2505o(124203);
                return in;
            } else if (C35575ap.cVF().cVG()) {
                in = C30798a.m49144im(mutableContextWrapper);
                AppMethodBeat.m2505o(124203);
                return in;
            } else {
                in = C30798a.m49145in(mutableContextWrapper);
                AppMethodBeat.m2505o(124203);
                return in;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            AppMethodBeat.m2505o(124203);
            return null;
        }
    }

    /* renamed from: fn */
    public final Object mo38329fn(Context context) {
        AppMethodBeat.m2504i(124204);
        if (C4996ah.doF()) {
            C4990ab.m7417i(this.TAG, "getWebView cached webview size %d", Integer.valueOf(this.uaL.size()));
            if (this.uaL.size() <= 0) {
                AppMethodBeat.m2505o(124204);
                return null;
            } else if (this.uaK) {
                C4513al c4513al = (C4513al) this.uaL.get(0);
                if (c4513al == null) {
                    this.uaL.remove(0);
                    AppMethodBeat.m2505o(124204);
                    return null;
                }
                MMWebView mMWebView = (MMWebView) c4513al.uaQ;
                if (mMWebView.getContext() instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) mMWebView.getContext()).setBaseContext(context);
                }
                this.uaL.remove(c4513al);
                this.uaK = false;
                AppMethodBeat.m2505o(124204);
                return c4513al;
            } else {
                C4990ab.m7416i(this.TAG, "preload unfinished");
                AppMethodBeat.m2505o(124204);
                return null;
            }
        }
        C4990ab.m7420w(this.TAG, "getWebView please call from tools proc");
        AppMethodBeat.m2505o(124204);
        return null;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void done() {
        AppMethodBeat.m2504i(124205);
        C4990ab.m7416i(this.TAG, "preInit finished");
        this.gQm = false;
        Iterator it = this.iEl.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.iEl.clear();
        AppMethodBeat.m2505o(124205);
    }
}
