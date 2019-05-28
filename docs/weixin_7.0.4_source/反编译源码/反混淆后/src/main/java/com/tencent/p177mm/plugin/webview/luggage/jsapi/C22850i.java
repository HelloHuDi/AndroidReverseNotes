package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseVideo;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.i */
public class C22850i extends C46419bd<C24905d> {
    public final String name() {
        return JsApiChooseVideo.NAME;
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6302);
        C4990ab.m7416i("MicroMsg.JsApiChooseVideo", "invokeInOwn");
        C22850i.m34676a(c32183a, 0);
        AppMethodBeat.m2505o(6302);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }

    /* renamed from: a */
    public static void m34676a(final C32183a c32183a, int i) {
        AppMethodBeat.m2504i(6303);
        final Context context = (MMActivity) ((C24905d) c32183a.bOZ).mContext;
        if (context == null) {
            C4990ab.m7412e("MicroMsg.JsApiChooseVideo", "activity is null");
            AppMethodBeat.m2505o(6303);
            return;
        }
        int i2;
        int i3;
        int i4;
        JSONObject jSONObject = c32183a.bPa.bOf;
        String optString = jSONObject.optString("sourceType", "");
        C4990ab.m7417i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d", optString, jSONObject.optString("camera", ""), Integer.valueOf(i));
        int optInt = jSONObject.optInt("maxDuration", 60);
        if (optString.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
            i2 = 4096;
        } else {
            i2 = 0;
        }
        if (optString.contains("camera")) {
            if (optInt <= 0) {
                c32183a.mo52824a("fail", null);
                AppMethodBeat.m2505o(6303);
                return;
            } else if (r7.equals("front")) {
                i2 |= 16;
            } else {
                i2 |= 256;
            }
        }
        if (i2 == 0) {
            i3 = 4352;
        } else {
            i3 = i2;
        }
        if (i3 == 16 || i3 == 256 || i3 == 4352) {
            if (i == 1) {
                C4990ab.m7411d("MicroMsg.JsApiChooseVideo", " checkPermission checkcamera[%b]", Boolean.valueOf(C35805b.m58707a(context, "android.permission.CAMERA", C31128d.MIC_ALPHA_ADJUST_REAL, "", "")));
                if (C35805b.m58707a(context, "android.permission.CAMERA", C31128d.MIC_ALPHA_ADJUST_REAL, "", "")) {
                    C4990ab.m7411d("MicroMsg.JsApiChooseVideo", " checkPermission checkMicroPhone[%b]", Boolean.valueOf(C35805b.m58707a(context, "android.permission.RECORD_AUDIO", 118, "", "")));
                    if (!C35805b.m58707a(context, "android.permission.RECORD_AUDIO", 118, "", "")) {
                        AppMethodBeat.m2505o(6303);
                        return;
                    }
                }
                AppMethodBeat.m2505o(6303);
                return;
            }
            C4990ab.m7411d("MicroMsg.JsApiChooseVideo", " checkPermission checkcamera[%b]", Boolean.valueOf(C35805b.m58707a(context, "android.permission.CAMERA", 115, "", "")));
            if (!C35805b.m58707a(context, "android.permission.CAMERA", 115, "", "")) {
                AppMethodBeat.m2505o(6303);
                return;
            }
        }
        i2 = jSONObject.optInt("quality", 1);
        if (i2 == 0 || i2 == 1) {
            i4 = i2;
        } else {
            i4 = 1;
        }
        if (optInt > 60) {
            i2 = 60;
        } else {
            i2 = optInt;
        }
        C4990ab.m7417i("MicroMsg.JsApiChooseVideo", "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d", Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(i4), Integer.valueOf(i2));
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i3);
        intent.putExtra("key_pick_local_pic_count", 1);
        intent.putExtra("key_pick_local_pic_query_source_type", 7);
        intent.putExtra("key_pick_local_media_quality", i4);
        intent.putExtra("key_pick_local_media_duration", i2);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("key_pick_local_media_video_type", i);
        C4990ab.m7417i("MicroMsg.JsApiChooseVideo", "doChooseVideo: realScene: %d, count: %d, querySourceType: %d", Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(7));
        context.ifE = new C5186a() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(6301);
                String stringExtra;
                WebViewJSSDKFileItem aeo;
                WebViewJSSDKVideoItem webViewJSSDKVideoItem;
                if (i == 45) {
                    switch (i2) {
                        case -1:
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                            String stringExtra2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                            C4990ab.m7417i("MicroMsg.JsApiChooseVideo", "localId:%s", stringExtra);
                            C4990ab.m7417i("MicroMsg.JsApiChooseVideo", "thumbLocalId:%s", stringExtra2);
                            if (!C5046bo.isNullOrNil(stringExtra)) {
                                aeo = C29782c.aeo(stringExtra);
                                if (aeo != null && (aeo instanceof WebViewJSSDKVideoItem)) {
                                    webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) aeo;
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("localId", stringExtra);
                                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(webViewJSSDKVideoItem.duration));
                                    hashMap.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                                    hashMap.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                                    hashMap.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                                    hashMap.put("thumbLocalId", stringExtra2);
                                    c32183a.mo52825c("", hashMap);
                                    break;
                                }
                                c32183a.mo52824a("fail", null);
                                break;
                            }
                            break;
                        case 0:
                            c32183a.mo52824a("cancel", null);
                            break;
                        default:
                            c32183a.mo52824a("fail", null);
                            break;
                    }
                    context.ifE = null;
                    AppMethodBeat.m2505o(6301);
                    return;
                }
                if (i == 32) {
                    switch (i2) {
                        case -1:
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                            if (!C5046bo.isNullOrNil(stringExtra)) {
                                aeo = C29782c.aeo(stringExtra);
                                if (aeo != null && (aeo instanceof WebViewJSSDKVideoItem)) {
                                    webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) aeo;
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("localId", stringExtra);
                                    hashMap2.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(webViewJSSDKVideoItem.duration));
                                    hashMap2.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                                    hashMap2.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                                    hashMap2.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                                    c32183a.mo52825c("", hashMap2);
                                    break;
                                }
                                c32183a.mo52824a("fail", null);
                                break;
                            }
                            break;
                        case 0:
                            c32183a.mo52824a("cancel", null);
                            break;
                        default:
                            c32183a.mo52824a("fail", null);
                            break;
                    }
                    context.ifE = null;
                }
                AppMethodBeat.m2505o(6301);
            }
        };
        if (i == 1) {
            C25985d.m41453a(context, "webview", ".ui.tools.OpenFileChooserUI", intent, 45, false);
            AppMethodBeat.m2505o(6303);
            return;
        }
        C25985d.m41453a(context, "webview", ".ui.tools.OpenFileChooserUI", intent, 32, false);
        AppMethodBeat.m2505o(6303);
    }
}
