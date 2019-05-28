package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.g */
public class C43901g extends C46419bd<C24905d> {
    public final String name() {
        return JsApiChooseImage.NAME;
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(final C32183a c32183a) {
        int i;
        int i2;
        Serializable serializable;
        AppMethodBeat.m2504i(6287);
        C4990ab.m7416i("MicroMsg.JsApiChooseImage", "invoke");
        JSONObject jSONObject = c32183a.bPa.bOf;
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        if (optJSONArray != null) {
            C4990ab.m7416i("MicroMsg.JsApiChooseImage", "sourceType = " + optJSONArray.toString());
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
        C4990ab.m7417i("MicroMsg.JsApiChooseImage", "real scene = %d", Integer.valueOf(i));
        if (i == 2 || i == 3) {
            C4990ab.m7411d("MicroMsg.JsApiChooseImage", " checkPermission checkcamera[%b]", Boolean.valueOf(C35805b.m58707a((Activity) ((C24905d) c32183a.bOZ).mContext, "android.permission.CAMERA", 113, "", "")));
            if (!C35805b.m58707a((Activity) ((C24905d) c32183a.bOZ).mContext, "android.permission.CAMERA", 113, "", "")) {
                c32183a.mo52824a("android_permission_denied", null);
                AppMethodBeat.m2505o(6287);
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
        C4990ab.m7417i("MicroMsg.JsApiChooseImage", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", Integer.valueOf(i), Integer.valueOf(optInt), Integer.valueOf(i2), serializable2);
        ((MMActivity) ((C24905d) c32183a.bOZ).mContext).ifE = new C5186a() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(6286);
                if (i == (C43901g.this.hashCode() & CdnLogic.kBizGeneric)) {
                    boolean z;
                    if (intent == null) {
                        z = false;
                    } else {
                        z = intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false);
                    }
                    C4990ab.m7417i("MicroMsg.JsApiChooseImage", "request to open file chooser, result code = %d, hasShowMemoryWarning = %b", Integer.valueOf(i2), Boolean.valueOf(z));
                    HashMap hashMap = new HashMap();
                    if (z) {
                        hashMap.put("memoryWarning", Boolean.TRUE);
                    }
                    switch (i2) {
                        case -1:
                            String stringExtra = intent != null ? intent.getStringExtra("key_pick_local_pic_callback_local_ids") : null;
                            if (!C5046bo.isNullOrNil(stringExtra)) {
                                C4990ab.m7417i("MicroMsg.JsApiChooseImage", "localIds = %s", stringExtra);
                                hashMap.put("localIds", stringExtra);
                                stringExtra = intent.getStringExtra("key_pick_local_pic_source_type");
                                if (stringExtra != null) {
                                    hashMap.put("sourceType", stringExtra);
                                }
                                c32183a.mo52825c("", hashMap);
                                break;
                            }
                        case 0:
                            c32183a.mo52825c("cancel", hashMap);
                            break;
                        default:
                            c32183a.mo52825c("fail", hashMap);
                            break;
                    }
                    ((MMActivity) ((C24905d) c32183a.bOZ).mContext).ifE = null;
                }
                AppMethodBeat.m2505o(6286);
            }
        };
        C25985d.m41453a(((C24905d) c32183a.bOZ).mContext, "webview", ".ui.tools.OpenFileChooserUI", intent, hashCode() & CdnLogic.kBizGeneric, false);
        AppMethodBeat.m2505o(6287);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
