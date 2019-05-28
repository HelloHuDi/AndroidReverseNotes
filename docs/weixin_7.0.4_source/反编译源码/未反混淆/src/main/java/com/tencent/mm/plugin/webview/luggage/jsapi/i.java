package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public class i extends bd<d> {
    public final String name() {
        return JsApiChooseVideo.NAME;
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6302);
        ab.i("MicroMsg.JsApiChooseVideo", "invokeInOwn");
        a(aVar, 0);
        AppMethodBeat.o(6302);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }

    public static void a(final a aVar, int i) {
        AppMethodBeat.i(6303);
        final Context context = (MMActivity) ((d) aVar.bOZ).mContext;
        if (context == null) {
            ab.e("MicroMsg.JsApiChooseVideo", "activity is null");
            AppMethodBeat.o(6303);
            return;
        }
        int i2;
        int i3;
        int i4;
        JSONObject jSONObject = aVar.bPa.bOf;
        String optString = jSONObject.optString("sourceType", "");
        ab.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d", optString, jSONObject.optString("camera", ""), Integer.valueOf(i));
        int optInt = jSONObject.optInt("maxDuration", 60);
        if (optString.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
            i2 = 4096;
        } else {
            i2 = 0;
        }
        if (optString.contains("camera")) {
            if (optInt <= 0) {
                aVar.a("fail", null);
                AppMethodBeat.o(6303);
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
                ab.d("MicroMsg.JsApiChooseVideo", " checkPermission checkcamera[%b]", Boolean.valueOf(b.a(context, "android.permission.CAMERA", com.tencent.view.d.MIC_ALPHA_ADJUST_REAL, "", "")));
                if (b.a(context, "android.permission.CAMERA", com.tencent.view.d.MIC_ALPHA_ADJUST_REAL, "", "")) {
                    ab.d("MicroMsg.JsApiChooseVideo", " checkPermission checkMicroPhone[%b]", Boolean.valueOf(b.a(context, "android.permission.RECORD_AUDIO", 118, "", "")));
                    if (!b.a(context, "android.permission.RECORD_AUDIO", 118, "", "")) {
                        AppMethodBeat.o(6303);
                        return;
                    }
                }
                AppMethodBeat.o(6303);
                return;
            }
            ab.d("MicroMsg.JsApiChooseVideo", " checkPermission checkcamera[%b]", Boolean.valueOf(b.a(context, "android.permission.CAMERA", 115, "", "")));
            if (!b.a(context, "android.permission.CAMERA", 115, "", "")) {
                AppMethodBeat.o(6303);
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
        ab.i("MicroMsg.JsApiChooseVideo", "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d", Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(i4), Integer.valueOf(i2));
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i3);
        intent.putExtra("key_pick_local_pic_count", 1);
        intent.putExtra("key_pick_local_pic_query_source_type", 7);
        intent.putExtra("key_pick_local_media_quality", i4);
        intent.putExtra("key_pick_local_media_duration", i2);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("key_pick_local_media_video_type", i);
        ab.i("MicroMsg.JsApiChooseVideo", "doChooseVideo: realScene: %d, count: %d, querySourceType: %d", Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(7));
        context.ifE = new MMActivity.a() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(6301);
                String stringExtra;
                WebViewJSSDKFileItem aeo;
                WebViewJSSDKVideoItem webViewJSSDKVideoItem;
                if (i == 45) {
                    switch (i2) {
                        case -1:
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                            String stringExtra2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                            ab.i("MicroMsg.JsApiChooseVideo", "localId:%s", stringExtra);
                            ab.i("MicroMsg.JsApiChooseVideo", "thumbLocalId:%s", stringExtra2);
                            if (!bo.isNullOrNil(stringExtra)) {
                                aeo = c.aeo(stringExtra);
                                if (aeo != null && (aeo instanceof WebViewJSSDKVideoItem)) {
                                    webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) aeo;
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("localId", stringExtra);
                                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(webViewJSSDKVideoItem.duration));
                                    hashMap.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                                    hashMap.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                                    hashMap.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                                    hashMap.put("thumbLocalId", stringExtra2);
                                    aVar.c("", hashMap);
                                    break;
                                }
                                aVar.a("fail", null);
                                break;
                            }
                            break;
                        case 0:
                            aVar.a("cancel", null);
                            break;
                        default:
                            aVar.a("fail", null);
                            break;
                    }
                    context.ifE = null;
                    AppMethodBeat.o(6301);
                    return;
                }
                if (i == 32) {
                    switch (i2) {
                        case -1:
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                            if (!bo.isNullOrNil(stringExtra)) {
                                aeo = c.aeo(stringExtra);
                                if (aeo != null && (aeo instanceof WebViewJSSDKVideoItem)) {
                                    webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) aeo;
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("localId", stringExtra);
                                    hashMap2.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(webViewJSSDKVideoItem.duration));
                                    hashMap2.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                                    hashMap2.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                                    hashMap2.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                                    aVar.c("", hashMap2);
                                    break;
                                }
                                aVar.a("fail", null);
                                break;
                            }
                            break;
                        case 0:
                            aVar.a("cancel", null);
                            break;
                        default:
                            aVar.a("fail", null);
                            break;
                    }
                    context.ifE = null;
                }
                AppMethodBeat.o(6301);
            }
        };
        if (i == 1) {
            com.tencent.mm.bp.d.a(context, "webview", ".ui.tools.OpenFileChooserUI", intent, 45, false);
            AppMethodBeat.o(6303);
            return;
        }
        com.tencent.mm.bp.d.a(context, "webview", ".ui.tools.OpenFileChooserUI", intent, 32, false);
        AppMethodBeat.o(6303);
    }
}
