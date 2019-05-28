package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import java.math.BigDecimal;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 360;
    public static final String NAME = "insertLivePusher";
    private int hLw;

    static final class b extends ah {
        private static final int CTRL_INDEX = 514;
        private static final String NAME = "onLivePusherBGMProgress";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static final class c extends ah {
        private static final int CTRL_INDEX = 513;
        private static final String NAME = "onLivePusherBGMStart";

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    static final class d extends ah {
        private static final int CTRL_INDEX = 531;
        private static final String NAME = "onLivePusherError";

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    static final class a extends ah {
        private static final int CTRL_INDEX = 515;
        private static final String NAME = "onLivePusherBGMComplete";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static final class f extends ah {
        private static final int CTRL_INDEX = 368;
        private static final String NAME = "onLivePusherEvent";

        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }
    }

    static final class e extends ah {
        private static final int CTRL_INDEX = 411;
        private static final String NAME = "onLivePusherNetStatus";

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    static /* synthetic */ void a(b bVar, Activity activity, com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(96108);
        bVar.a(activity, cVar, jSONObject, i);
        AppMethodBeat.o(96108);
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(96103);
        j.aDJ();
        if (cVar.getContext() instanceof Activity) {
            this.hLw = 0;
            a((Activity) cVar.getContext(), cVar, jSONObject, i);
            AppMethodBeat.o(96103);
            return;
        }
        ab.w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
        cVar.M(i, j("fail", null));
        n.Dr(cVar.getAppId());
        AppMethodBeat.o(96103);
    }

    public final View a(com.tencent.mm.plugin.appbrand.jsapi.e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(96104);
        CoverViewContainer coverViewContainer = new CoverViewContainer(eVar.getContext(), new AppBrandLivePusherView(eVar.getContext()));
        AppMethodBeat.o(96104);
        return coverViewContainer;
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(96105);
        int i = jSONObject.getInt("livePusherId");
        AppMethodBeat.o(96105);
        return i;
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e eVar, final int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(96106);
        ab.i("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[]{eVar.getAppId()}));
            final AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) ((CoverViewContainer) view).ah(AppBrandLivePusherView.class);
            if (appBrandLivePusherView == null) {
                ab.e("MicroMsg.JsApiInsertLivePusher", "pusherView null");
                AppMethodBeat.o(96106);
                return;
            }
            final AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.jsapi.f.d() {
                public final void wU() {
                    AppMethodBeat.i(96085);
                    AppBrandLivePusherView appBrandLivePusherView = appBrandLivePusherView;
                    i aDK = appBrandLivePusherView.hLk.aDK();
                    ab.i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", Integer.valueOf(aDK.errorCode), aDK.hLF);
                    appBrandLivePusherView.hLh.enable();
                    AppMethodBeat.o(96085);
                }
            };
            final AnonymousClass4 anonymousClass4 = new com.tencent.mm.plugin.appbrand.jsapi.f.b() {
                public final void wW() {
                    AppMethodBeat.i(96090);
                    AppBrandLivePusherView appBrandLivePusherView = appBrandLivePusherView;
                    i eb = appBrandLivePusherView.hLk.eb(false);
                    ab.i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", Integer.valueOf(eb.errorCode), eb.hLF);
                    appBrandLivePusherView.hLh.disable();
                    AppMethodBeat.o(96090);
                }
            };
            final com.tencent.mm.plugin.appbrand.g.c anonymousClass5 = new com.tencent.mm.plugin.appbrand.g.c() {
                public final void a(com.tencent.mm.plugin.appbrand.g.d dVar) {
                    AppMethodBeat.i(96091);
                    AppBrandLivePusherView appBrandLivePusherView = appBrandLivePusherView;
                    ab.i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", dVar);
                    if (dVar == com.tencent.mm.plugin.appbrand.g.d.BACK || dVar == com.tencent.mm.plugin.appbrand.g.d.CLOSE || dVar == com.tencent.mm.plugin.appbrand.g.d.LAUNCH_MINI_PROGRAM) {
                        appBrandLivePusherView.hLk.eb(true);
                    }
                    AppMethodBeat.o(96091);
                }

                public final void onResume() {
                    AppMethodBeat.i(96092);
                    appBrandLivePusherView.hLk.aDK();
                    AppMethodBeat.o(96092);
                }

                public final void onDestroy() {
                    AppMethodBeat.i(96093);
                    g.b(eVar.getAppId(), this);
                    AppMethodBeat.o(96093);
                }
            };
            AnonymousClass6 anonymousClass6 = new com.tencent.mm.plugin.appbrand.jsapi.f.c() {
                public final void onDestroy() {
                    AppMethodBeat.i(96094);
                    appBrandLivePusherView.onExit();
                    eVar.b((com.tencent.mm.plugin.appbrand.jsapi.f.c) this);
                    g.b(eVar.getAppId(), anonymousClass5);
                    AppMethodBeat.o(96094);
                }
            };
            eVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.d) anonymousClass1);
            eVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.b) anonymousClass4);
            eVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.c) anonymousClass6);
            appBrandLivePusherView.setOnExitListener(new com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView.c() {
                public final void aDH() {
                    AppMethodBeat.i(96095);
                    eVar.b(anonymousClass1);
                    eVar.b(anonymousClass4);
                    AppMethodBeat.o(96095);
                }
            });
            g.a(eVar.getAppId(), anonymousClass5);
            appBrandLivePusherView.setOnPushEventListener(new ITXLivePushListener() {
                public final void onPushEvent(int i, Bundle bundle) {
                    AppMethodBeat.i(96096);
                    ab.i("MicroMsg.JsApiInsertLivePusher", "onPushEvent errCode:%d", Integer.valueOf(i));
                    f fVar = new f();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errCode", i);
                        jSONObject.put("errMsg", bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
                        jSONObject.put("livePusherId", i);
                    } catch (JSONException e) {
                    }
                    eVar.b(fVar.AM(jSONObject.toString()));
                    AppMethodBeat.o(96096);
                }

                public final void onNetStatus(Bundle bundle) {
                    AppMethodBeat.i(96097);
                    e eVar = new e();
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
                    eVar.b(eVar.AM(jSONObject.toString()));
                    AppMethodBeat.o(96097);
                }
            });
            appBrandLivePusherView.setBGMNotifyListener(new OnBGMNotify() {
                public final void onBGMStart() {
                    AppMethodBeat.i(96098);
                    ab.i("MicroMsg.JsApiInsertLivePusher", "onBGMStart");
                    c cVar = new c();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("livePusherId", i);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiInsertLivePusher", "onBGMStart fail", e);
                    }
                    eVar.b(cVar.AM(jSONObject.toString()));
                    AppMethodBeat.o(96098);
                }

                public final void onBGMProgress(long j, long j2) {
                    AppMethodBeat.i(96099);
                    b bVar = new b();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("progress", j);
                        jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, j2);
                        jSONObject.put("livePusherId", i);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiInsertLivePusher", "onBGMProgress fail", e);
                    }
                    eVar.b(bVar.AM(jSONObject.toString()));
                    AppMethodBeat.o(96099);
                }

                public final void onBGMComplete(int i) {
                    AppMethodBeat.i(96100);
                    ab.i("MicroMsg.JsApiInsertLivePusher", "onBGMComplete, error:%s", Integer.valueOf(i));
                    a aVar = new a();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errCode", i);
                        jSONObject.put("livePusherId", i);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiInsertLivePusher", "onBGMComplete fail", e);
                    }
                    eVar.b(aVar.AM(jSONObject.toString()));
                    AppMethodBeat.o(96100);
                }
            });
            appBrandLivePusherView.setOnErrorListener(new com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView.b() {
                public final void a(int i, String str, HashMap<String, Object> hashMap) {
                    AppMethodBeat.i(96101);
                    ab.i("MicroMsg.JsApiInsertLivePusher", "onError, error:%s", Integer.valueOf(i));
                    d dVar = new d();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errCode", i);
                        jSONObject.put("errMsg", bo.nullAsNil(str));
                        jSONObject.put("livePusherId", i);
                        if (!(hashMap == null || hashMap.isEmpty())) {
                            jSONObject.put("data", new JSONObject(hashMap));
                        }
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiInsertLivePusher", "onError fail", e);
                    }
                    eVar.b(dVar.AM(jSONObject.toString()));
                    AppMethodBeat.o(96101);
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
            ab.i("MicroMsg.JsApiInsertLivePusher", "convertParams pushUrl:%s", jSONObject.optString("pushUrl"));
            l lVar = appBrandLivePusherView.hLk;
            l.l("InitLivePusher", bundle);
            lVar.hLH = appBrandLivePusherView;
            lVar.hLH.disableLog(false);
            lVar.hMc = bundle.getString("pushUrl", "");
            lVar.c(bundle, true);
            lVar.hMk = bundle.getBoolean("autopush", lVar.hMk);
            if (!(!lVar.hMk || lVar.hMc == null || lVar.hMc.isEmpty() || lVar.hMa.isPushing())) {
                ab.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
                lVar.ea(lVar.hMp);
                lVar.hMa.startPusher(lVar.hMc);
            }
            lVar.mInited = true;
            i iVar = new i();
            ab.i("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.hLF);
            final String optString = jSONObject.optString("backgroundImage");
            String optString2 = jSONObject.optString("backgroundMD5");
            if (bo.isNullOrNil(optString)) {
                ab.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, url is null");
            } else {
                com.tencent.mm.plugin.appbrand.s.b.a(eVar, optString, optString2, new com.tencent.mm.plugin.appbrand.s.b.a() {
                    public final void AN(String str) {
                        AppMethodBeat.i(96102);
                        if (bo.isNullOrNil(str)) {
                            ab.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
                            HashMap hashMap = new HashMap();
                            hashMap.put("url", optString);
                            appBrandLivePusherView.a(10004, "load background image fail", hashMap);
                            AppMethodBeat.o(96102);
                            return;
                        }
                        ab.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, localPath:%s", str);
                        Bundle bundle = new Bundle();
                        bundle.putString("backgroundImage", str);
                        appBrandLivePusherView.y(bundle);
                        AppMethodBeat.o(96102);
                    }
                });
            }
            optString = jSONObject.optString("watermarkImage");
            optString2 = jSONObject.optString("watermarkMD5");
            if (bo.isNullOrNil(optString)) {
                ab.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, url is null");
            } else {
                com.tencent.mm.plugin.appbrand.s.b.a(eVar, optString, optString2, new com.tencent.mm.plugin.appbrand.s.b.a() {
                    public final void AN(String str) {
                        AppMethodBeat.i(96086);
                        if (!bo.isNullOrNil(str)) {
                            ab.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", str);
                            Bundle bundle = new Bundle();
                            bundle.putString("watermarkImage", str);
                            appBrandLivePusherView.y(bundle);
                        }
                        AppMethodBeat.o(96086);
                    }
                });
            }
            appBrandLivePusherView.setContentDescription(view.getContext().getString(R.string.g9));
            AppMethodBeat.o(96106);
            return;
        }
        ab.w("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(96106);
    }

    private void a(Activity activity, com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(96107);
        int i2 = this.hLw;
        this.hLw = i2 + 1;
        if (i2 > 5) {
            ab.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
            AppMethodBeat.o(96107);
            return;
        }
        final Activity activity2 = activity;
        final com.tencent.mm.plugin.appbrand.jsapi.c cVar2 = cVar;
        final JSONObject jSONObject2 = jSONObject;
        final int i3 = i;
        n.b(cVar.getAppId(), new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                AppMethodBeat.i(96089);
                ab.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", Integer.valueOf(i));
                if (i != com.tencent.view.d.MIC_ALPHA_ADJUST_REAL) {
                    if (i == 118) {
                        if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            ab.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
                            cVar2.M(i3, b.this.j("fail:system permission denied", null));
                        } else {
                            al.n(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(96088);
                                    b.a(b.this, activity2, cVar2, jSONObject2, i3);
                                    AppMethodBeat.o(96088);
                                }
                            }, 50);
                            AppMethodBeat.o(96089);
                            return;
                        }
                    }
                    AppMethodBeat.o(96089);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    ab.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
                    cVar2.M(i3, b.this.j("fail:system permission denied", null));
                    AppMethodBeat.o(96089);
                } else {
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(96087);
                            b.a(b.this, activity2, cVar2, jSONObject2, i3);
                            AppMethodBeat.o(96087);
                        }
                    }, 50);
                    AppMethodBeat.o(96089);
                }
            }
        });
        if (!com.tencent.luggage.g.g.a(activity, "android.permission.CAMERA", com.tencent.view.d.MIC_ALPHA_ADJUST_REAL, "", "")) {
            ab.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
            AppMethodBeat.o(96107);
        } else if (com.tencent.luggage.g.g.a(activity, "android.permission.RECORD_AUDIO", 118, "", "")) {
            ab.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
            super.a(cVar, jSONObject, i);
            AppMethodBeat.o(96107);
        } else {
            ab.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
            AppMethodBeat.o(96107);
        }
    }
}
