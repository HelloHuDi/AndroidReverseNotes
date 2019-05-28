package com.tencent.p177mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.support.p057v4.app.C6184a.C0315a;
import android.view.View;
import com.tencent.luggage.p147g.C0991g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45577a;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView.C10450c;
import com.tencent.p177mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView.C33348b;
import com.tencent.p177mm.plugin.appbrand.p329s.C45682b;
import com.tencent.p177mm.plugin.appbrand.p329s.C45682b.C19711a;
import com.tencent.p177mm.plugin.appbrand.permission.C19663n;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.view.C31128d;
import java.math.BigDecimal;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.b */
public final class C42533b extends C45577a {
    private static final int CTRL_INDEX = 360;
    public static final String NAME = "insertLivePusher";
    private int hLw;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.b$b */
    static final class C2306b extends C42467ah {
        private static final int CTRL_INDEX = 514;
        private static final String NAME = "onLivePusherBGMProgress";

        private C2306b() {
        }

        /* synthetic */ C2306b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.b$c */
    static final class C2307c extends C42467ah {
        private static final int CTRL_INDEX = 513;
        private static final String NAME = "onLivePusherBGMStart";

        private C2307c() {
        }

        /* synthetic */ C2307c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.b$d */
    static final class C2308d extends C42467ah {
        private static final int CTRL_INDEX = 531;
        private static final String NAME = "onLivePusherError";

        private C2308d() {
        }

        /* synthetic */ C2308d(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.b$a */
    static final class C19422a extends C42467ah {
        private static final int CTRL_INDEX = 515;
        private static final String NAME = "onLivePusherBGMComplete";

        private C19422a() {
        }

        /* synthetic */ C19422a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.b$f */
    static final class C33352f extends C42467ah {
        private static final int CTRL_INDEX = 368;
        private static final String NAME = "onLivePusherEvent";

        private C33352f() {
        }

        /* synthetic */ C33352f(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.b$e */
    static final class C38331e extends C42467ah {
        private static final int CTRL_INDEX = 411;
        private static final String NAME = "onLivePusherNetStatus";

        private C38331e() {
        }

        /* synthetic */ C38331e(byte b) {
            this();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m75306a(C42533b c42533b, Activity activity, C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(96108);
        c42533b.m75305a(activity, c2241c, jSONObject, i);
        AppMethodBeat.m2505o(96108);
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(96103);
        C38335j.aDJ();
        if (c2241c.getContext() instanceof Activity) {
            this.hLw = 0;
            m75305a((Activity) c2241c.getContext(), c2241c, jSONObject, i);
            AppMethodBeat.m2505o(96103);
            return;
        }
        C4990ab.m7420w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
        c2241c.mo6107M(i, mo73394j("fail", null));
        C19663n.m30460Dr(c2241c.getAppId());
        AppMethodBeat.m2505o(96103);
    }

    /* renamed from: a */
    public final View mo6126a(C33303e c33303e, JSONObject jSONObject) {
        AppMethodBeat.m2504i(96104);
        CoverViewContainer coverViewContainer = new CoverViewContainer(c33303e.getContext(), new AppBrandLivePusherView(c33303e.getContext()));
        AppMethodBeat.m2505o(96104);
        return coverViewContainer;
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(96105);
        int i = jSONObject.getInt("livePusherId");
        AppMethodBeat.m2505o(96105);
        return i;
    }

    /* renamed from: a */
    public final void mo6140a(final C33303e c33303e, final int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(96106);
        C4990ab.m7417i("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[]{c33303e.getAppId()}));
            final AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) ((CoverViewContainer) view).mo60996ah(AppBrandLivePusherView.class);
            if (appBrandLivePusherView == null) {
                C4990ab.m7412e("MicroMsg.JsApiInsertLivePusher", "pusherView null");
                AppMethodBeat.m2505o(96106);
                return;
            }
            final C383281 c383281 = new C10381d() {
                /* renamed from: wU */
                public final void mo6095wU() {
                    AppMethodBeat.m2504i(96085);
                    AppBrandLivePusherView appBrandLivePusherView = appBrandLivePusherView;
                    C33353i aDK = appBrandLivePusherView.hLk.aDK();
                    C4990ab.m7417i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", Integer.valueOf(aDK.errorCode), aDK.hLF);
                    appBrandLivePusherView.hLh.enable();
                    AppMethodBeat.m2505o(96085);
                }
            };
            final C333514 c333514 = new C10379b() {
                /* renamed from: wW */
                public final void mo21857wW() {
                    AppMethodBeat.m2504i(96090);
                    AppBrandLivePusherView appBrandLivePusherView = appBrandLivePusherView;
                    C33353i eb = appBrandLivePusherView.hLk.mo6182eb(false);
                    C4990ab.m7417i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", Integer.valueOf(eb.errorCode), eb.hLF);
                    appBrandLivePusherView.hLh.disable();
                    AppMethodBeat.m2505o(96090);
                }
            };
            final C33186c c104535 = new C33186c() {
                /* renamed from: a */
                public final void mo6074a(C33184d c33184d) {
                    AppMethodBeat.m2504i(96091);
                    AppBrandLivePusherView appBrandLivePusherView = appBrandLivePusherView;
                    C4990ab.m7417i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", c33184d);
                    if (c33184d == C33184d.BACK || c33184d == C33184d.CLOSE || c33184d == C33184d.LAUNCH_MINI_PROGRAM) {
                        appBrandLivePusherView.hLk.mo6182eb(true);
                    }
                    AppMethodBeat.m2505o(96091);
                }

                public final void onResume() {
                    AppMethodBeat.m2504i(96092);
                    appBrandLivePusherView.hLk.aDK();
                    AppMethodBeat.m2505o(96092);
                }

                public final void onDestroy() {
                    AppMethodBeat.m2504i(96093);
                    C33183g.m54276b(c33303e.getAppId(), this);
                    AppMethodBeat.m2505o(96093);
                }
            };
            C166706 c166706 = new C10380c() {
                public final void onDestroy() {
                    AppMethodBeat.m2504i(96094);
                    appBrandLivePusherView.onExit();
                    c33303e.mo53833b((C10380c) this);
                    C33183g.m54276b(c33303e.getAppId(), c104535);
                    AppMethodBeat.m2505o(96094);
                }
            };
            c33303e.mo53829a((C10381d) c383281);
            c33303e.mo53827a((C10379b) c333514);
            c33303e.mo53828a((C10380c) c166706);
            appBrandLivePusherView.setOnExitListener(new C10450c() {
                public final void aDH() {
                    AppMethodBeat.m2504i(96095);
                    c33303e.mo53834b(c383281);
                    c33303e.mo53832b(c333514);
                    AppMethodBeat.m2505o(96095);
                }
            });
            C33183g.m54274a(c33303e.getAppId(), c104535);
            appBrandLivePusherView.setOnPushEventListener(new ITXLivePushListener() {
                public final void onPushEvent(int i, Bundle bundle) {
                    AppMethodBeat.m2504i(96096);
                    C4990ab.m7417i("MicroMsg.JsApiInsertLivePusher", "onPushEvent errCode:%d", Integer.valueOf(i));
                    C33352f c33352f = new C33352f();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errCode", i);
                        jSONObject.put("errMsg", bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
                        jSONObject.put("livePusherId", i);
                    } catch (JSONException e) {
                    }
                    c33303e.mo6115b(c33352f.mo61028AM(jSONObject.toString()));
                    AppMethodBeat.m2505o(96096);
                }

                public final void onNetStatus(Bundle bundle) {
                    AppMethodBeat.m2504i(96097);
                    C38331e c38331e = new C38331e();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("livePusherId", i);
                        JSONObject jSONObject2 = new JSONObject();
                        if (bundle != null) {
                            for (String str : bundle.keySet()) {
                                jSONObject2.put(str, bundle.get(str));
                            }
                        }
                        jSONObject.put("info", jSONObject2);
                    } catch (JSONException e) {
                    }
                    c33303e.mo6115b(c38331e.mo61028AM(jSONObject.toString()));
                    AppMethodBeat.m2505o(96097);
                }
            });
            appBrandLivePusherView.setBGMNotifyListener(new OnBGMNotify() {
                public final void onBGMStart() {
                    AppMethodBeat.m2504i(96098);
                    C4990ab.m7416i("MicroMsg.JsApiInsertLivePusher", "onBGMStart");
                    C2307c c2307c = new C2307c();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("livePusherId", i);
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiInsertLivePusher", "onBGMStart fail", e);
                    }
                    c33303e.mo6115b(c2307c.mo61028AM(jSONObject.toString()));
                    AppMethodBeat.m2505o(96098);
                }

                public final void onBGMProgress(long j, long j2) {
                    AppMethodBeat.m2504i(96099);
                    C2306b c2306b = new C2306b();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("progress", j);
                        jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, j2);
                        jSONObject.put("livePusherId", i);
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiInsertLivePusher", "onBGMProgress fail", e);
                    }
                    c33303e.mo6115b(c2306b.mo61028AM(jSONObject.toString()));
                    AppMethodBeat.m2505o(96099);
                }

                public final void onBGMComplete(int i) {
                    AppMethodBeat.m2504i(96100);
                    C4990ab.m7417i("MicroMsg.JsApiInsertLivePusher", "onBGMComplete, error:%s", Integer.valueOf(i));
                    C19422a c19422a = new C19422a();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errCode", i);
                        jSONObject.put("livePusherId", i);
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiInsertLivePusher", "onBGMComplete fail", e);
                    }
                    c33303e.mo6115b(c19422a.mo61028AM(jSONObject.toString()));
                    AppMethodBeat.m2505o(96100);
                }
            });
            appBrandLivePusherView.setOnErrorListener(new C33348b() {
                /* renamed from: a */
                public final void mo34560a(int i, String str, HashMap<String, Object> hashMap) {
                    AppMethodBeat.m2504i(96101);
                    C4990ab.m7417i("MicroMsg.JsApiInsertLivePusher", "onError, error:%s", Integer.valueOf(i));
                    C2308d c2308d = new C2308d();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errCode", i);
                        jSONObject.put("errMsg", C5046bo.nullAsNil(str));
                        jSONObject.put("livePusherId", i);
                        if (!(hashMap == null || hashMap.isEmpty())) {
                            jSONObject.put("data", new JSONObject(hashMap));
                        }
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiInsertLivePusher", "onError fail", e);
                    }
                    c33303e.mo6115b(c2308d.mo61028AM(jSONObject.toString()));
                    AppMethodBeat.m2505o(96101);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("pushUrl", jSONObject.optString("pushUrl"));
            bundle.putInt("mode", jSONObject.optInt("mode", 0));
            bundle.putBoolean("autopush", jSONObject.optBoolean("autopush", false));
            bundle.putBoolean("muted", jSONObject.optBoolean("muted", false));
            bundle.putBoolean("enableCamera", jSONObject.optBoolean("enableCamera", true));
            bundle.putInt("focusMode", jSONObject.optInt("focusMode", 0));
            bundle.putString("orientation", jSONObject.optString("orientation"));
            bundle.putInt("beauty", jSONObject.optInt("beauty", 0));
            bundle.putInt("whiteness", jSONObject.optInt("whiteness", 0));
            bundle.putString("audioQuality", jSONObject.optString("audioQuality", "high"));
            bundle.putInt("aspect", jSONObject.optInt("aspect", 0));
            bundle.putInt("minBitrate", jSONObject.optInt("minBitrate", 0));
            bundle.putInt("maxBitrate", jSONObject.optInt("maxBitrate", 0));
            bundle.putBoolean("backgroundMute", jSONObject.optBoolean("backgroundMute", false));
            bundle.putBoolean("zoom", jSONObject.optBoolean("zoom", true));
            bundle.putBoolean("needEvent", jSONObject.optBoolean("needEvent", false));
            bundle.putBoolean("debug", jSONObject.optBoolean("debug", false));
            bundle.putBoolean("mirror", jSONObject.optBoolean("mirror", false));
            bundle.putFloat("watermarkLeft", BigDecimal.valueOf(jSONObject.optDouble("watermarkLeft", 0.0d)).floatValue());
            bundle.putFloat("watermarkTop", BigDecimal.valueOf(jSONObject.optDouble("watermarkTop", 0.0d)).floatValue());
            bundle.putFloat("watermarkWidth", BigDecimal.valueOf(jSONObject.optDouble("watermarkWidth", 0.1d)).floatValue());
            bundle.putString("devicePosition", jSONObject.optString("devicePosition", "front"));
            bundle.putBoolean("needBGMEvent", jSONObject.optBoolean("needBGMEvent", false));
            C4990ab.m7417i("MicroMsg.JsApiInsertLivePusher", "convertParams pushUrl:%s", jSONObject.optString("pushUrl"));
            C2309l c2309l = appBrandLivePusherView.hLk;
            C2309l.m4530l("InitLivePusher", bundle);
            c2309l.hLH = appBrandLivePusherView;
            c2309l.hLH.disableLog(false);
            c2309l.hMc = bundle.getString("pushUrl", "");
            c2309l.mo6180c(bundle, true);
            c2309l.hMk = bundle.getBoolean("autopush", c2309l.hMk);
            if (!(!c2309l.hMk || c2309l.hMc == null || c2309l.hMc.isEmpty() || c2309l.hMa.isPushing())) {
                C4990ab.m7416i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
                c2309l.mo6181ea(c2309l.hMp);
                c2309l.hMa.startPusher(c2309l.hMc);
            }
            c2309l.mInited = true;
            C33353i c33353i = new C33353i();
            C4990ab.m7417i("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", Integer.valueOf(c33353i.errorCode), c33353i.hLF);
            final String optString = jSONObject.optString("backgroundImage");
            String optString2 = jSONObject.optString("backgroundMD5");
            if (C5046bo.isNullOrNil(optString)) {
                C4990ab.m7416i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, url is null");
            } else {
                C45682b.m84381a(c33303e, optString, optString2, new C19711a() {
                    /* renamed from: AN */
                    public final void mo21737AN(String str) {
                        AppMethodBeat.m2504i(96102);
                        if (C5046bo.isNullOrNil(str)) {
                            C4990ab.m7416i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
                            HashMap hashMap = new HashMap();
                            hashMap.put("url", optString);
                            appBrandLivePusherView.mo65882a(10004, "load background image fail", hashMap);
                            AppMethodBeat.m2505o(96102);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, localPath:%s", str);
                        Bundle bundle = new Bundle();
                        bundle.putString("backgroundImage", str);
                        appBrandLivePusherView.mo65891y(bundle);
                        AppMethodBeat.m2505o(96102);
                    }
                });
            }
            optString = jSONObject.optString("watermarkImage");
            optString2 = jSONObject.optString("watermarkMD5");
            if (C5046bo.isNullOrNil(optString)) {
                C4990ab.m7416i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, url is null");
            } else {
                C45682b.m84381a(c33303e, optString, optString2, new C19711a() {
                    /* renamed from: AN */
                    public final void mo21737AN(String str) {
                        AppMethodBeat.m2504i(96086);
                        if (!C5046bo.isNullOrNil(str)) {
                            C4990ab.m7417i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", str);
                            Bundle bundle = new Bundle();
                            bundle.putString("watermarkImage", str);
                            appBrandLivePusherView.mo65891y(bundle);
                        }
                        AppMethodBeat.m2505o(96086);
                    }
                });
            }
            appBrandLivePusherView.setContentDescription(view.getContext().getString(C25738R.string.f8831g9));
            AppMethodBeat.m2505o(96106);
            return;
        }
        C4990ab.m7421w("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(96106);
    }

    /* renamed from: a */
    private void m75305a(Activity activity, C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(96107);
        int i2 = this.hLw;
        this.hLw = i2 + 1;
        if (i2 > 5) {
            C4990ab.m7416i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
            AppMethodBeat.m2505o(96107);
            return;
        }
        final Activity activity2 = activity;
        final C2241c c2241c2 = c2241c;
        final JSONObject jSONObject2 = jSONObject;
        final int i3 = i;
        C19663n.m30463b(c2241c.getAppId(), new C0315a() {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.b$3$1 */
            class C194211 implements Runnable {
                C194211() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(96087);
                    C42533b.m75306a(C42533b.this, activity2, c2241c2, jSONObject2, i3);
                    AppMethodBeat.m2505o(96087);
                }
            }

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.b$3$2 */
            class C383302 implements Runnable {
                C383302() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(96088);
                    C42533b.m75306a(C42533b.this, activity2, c2241c2, jSONObject2, i3);
                    AppMethodBeat.m2505o(96088);
                }
            }

            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                AppMethodBeat.m2504i(96089);
                C4990ab.m7417i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", Integer.valueOf(i));
                if (i != C31128d.MIC_ALPHA_ADJUST_REAL) {
                    if (i == 118) {
                        if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            C4990ab.m7416i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
                            c2241c2.mo6107M(i3, C42533b.this.mo73394j("fail:system permission denied", null));
                        } else {
                            C5004al.m7442n(new C383302(), 50);
                            AppMethodBeat.m2505o(96089);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(96089);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    C4990ab.m7416i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
                    c2241c2.mo6107M(i3, C42533b.this.mo73394j("fail:system permission denied", null));
                    AppMethodBeat.m2505o(96089);
                } else {
                    C5004al.m7442n(new C194211(), 50);
                    AppMethodBeat.m2505o(96089);
                }
            }
        });
        if (!C0991g.m2252a(activity, "android.permission.CAMERA", C31128d.MIC_ALPHA_ADJUST_REAL, "", "")) {
            C4990ab.m7416i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
            AppMethodBeat.m2505o(96107);
        } else if (C0991g.m2252a(activity, "android.permission.RECORD_AUDIO", 118, "", "")) {
            C4990ab.m7416i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
            super.mo5994a(c2241c, jSONObject, i);
            AppMethodBeat.m2505o(96107);
        } else {
            C4990ab.m7416i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
            AppMethodBeat.m2505o(96107);
        }
    }
}
