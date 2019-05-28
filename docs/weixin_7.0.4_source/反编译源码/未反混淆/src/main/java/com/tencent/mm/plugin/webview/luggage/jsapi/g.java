package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class g extends bd<d> {
    public final String name() {
        return JsApiChooseImage.NAME;
    }

    public final int biG() {
        return 0;
    }

    public final void b(final a aVar) {
        int i;
        int i2;
        Serializable serializable;
        AppMethodBeat.i(6287);
        ab.i("MicroMsg.JsApiChooseImage", "invoke");
        JSONObject jSONObject = aVar.bPa.bOf;
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        if (optJSONArray != null) {
            ab.i("MicroMsg.JsApiChooseImage", "sourceType = " + optJSONArray.toString());
            i = 0;
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (optJSONArray.optString(i2).equals(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                    i |= 1;
                } else if (optJSONArray.optString(i2).equals("camera")) {
                    i |= 2;
                }
            }
            i2 = i;
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            i = 3;
        } else {
            i = i2;
        }
        ab.i("MicroMsg.JsApiChooseImage", "real scene = %d", Integer.valueOf(i));
        if (i == 2 || i == 3) {
            ab.d("MicroMsg.JsApiChooseImage", " checkPermission checkcamera[%b]", Boolean.valueOf(b.a((Activity) ((d) aVar.bOZ).mContext, "android.permission.CAMERA", 113, "", "")));
            if (!b.a((Activity) ((d) aVar.bOZ).mContext, "android.permission.CAMERA", 113, "", "")) {
                aVar.a("android_permission_denied", null);
                AppMethodBeat.o(6287);
                return;
            }
        }
        int optInt = jSONObject.optInt("count", 0);
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = Boolean.FALSE;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sizeType");
        if (optJSONArray2 != null) {
            for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                if (optJSONArray2.optString(i2).equals("original")) {
                    bool = Boolean.TRUE;
                } else if (optJSONArray2.optString(i2).equals("compressed")) {
                    bool2 = Boolean.TRUE;
                }
            }
        }
        Object serializable2;
        if (bool.booleanValue() && !bool2.booleanValue()) {
            i2 = 7;
            serializable2 = Boolean.TRUE;
        } else if (bool.booleanValue() || !bool2.booleanValue()) {
            i2 = 8;
            serializable2 = Boolean.FALSE;
        } else {
            i2 = 7;
            serializable2 = Boolean.FALSE;
        }
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i);
        intent.putExtra("key_pick_local_pic_count", optInt);
        intent.putExtra("key_pick_local_pic_query_source_type", i2);
        intent.putExtra("key_pick_local_pic_send_raw", serializable2);
        intent.putExtra("query_media_type", 1);
        ab.i("MicroMsg.JsApiChooseImage", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", Integer.valueOf(i), Integer.valueOf(optInt), Integer.valueOf(i2), serializable2);
        ((MMActivity) ((d) aVar.bOZ).mContext).ifE = new MMActivity.a() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(6286);
                if (i == (g.this.hashCode() & CdnLogic.kBizGeneric)) {
                    boolean z;
                    if (intent == null) {
                        z = false;
                    } else {
                        z = intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false);
                    }
                    ab.i("MicroMsg.JsApiChooseImage", "request to open file chooser, result code = %d, hasShowMemoryWarning = %b", Integer.valueOf(i2), Boolean.valueOf(z));
                    HashMap hashMap = new HashMap();
                    if (z) {
                        hashMap.put("memoryWarning", Boolean.TRUE);
                    }
                    switch (i2) {
                        case -1:
                            String stringExtra = intent != null ? intent.getStringExtra("key_pick_local_pic_callback_local_ids") : null;
                            if (!bo.isNullOrNil(stringExtra)) {
                                ab.i("MicroMsg.JsApiChooseImage", "localIds = %s", stringExtra);
                                hashMap.put("localIds", stringExtra);
                                stringExtra = intent.getStringExtra("key_pick_local_pic_source_type");
                                if (stringExtra != null) {
                                    hashMap.put("sourceType", stringExtra);
                                }
                                aVar.c("", hashMap);
                                break;
                            }
                        case 0:
                            aVar.c("cancel", hashMap);
                            break;
                        default:
                            aVar.c("fail", hashMap);
                            break;
                    }
                    ((MMActivity) ((d) aVar.bOZ).mContext).ifE = null;
                }
                AppMethodBeat.o(6286);
            }
        };
        com.tencent.mm.bp.d.a(((d) aVar.bOZ).mContext, "webview", ".ui.tools.OpenFileChooserUI", intent, hashCode() & CdnLogic.kBizGeneric, false);
        AppMethodBeat.o(6287);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
