package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c;
import com.tencent.p177mm.plugin.webview.model.C43914ap;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.h */
public class C22846h extends C46419bd<C24905d> {
    private C5186a hvq = new C228494();
    private MMActivity hwd;
    private C32183a ujY;

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.h$1 */
    class C228451 implements OnCreateContextMenuListener {
        C228451() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(6288);
            contextMenu.add(0, 1, 0, C22846h.this.hwd.getString(C25738R.string.f9121q4));
            contextMenu.add(0, 2, 1, C22846h.this.hwd.getString(C25738R.string.f9126qa));
            AppMethodBeat.m2505o(6288);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.h$3 */
    class C228483 implements OnCancelListener {
        C228483() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(6290);
            C22846h.m34667a(C22846h.this, "cancel");
            AppMethodBeat.m2505o(6290);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.h$4 */
    class C228494 implements C5186a {
        C228494() {
        }

        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(6291);
            if (i == (C22846h.this.hashCode() & CdnLogic.kBizGeneric)) {
                switch (i2) {
                    case -1:
                        if (intent == null) {
                            C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA bundle is null,");
                            C22846h.m34667a(C22846h.this, "fail");
                            AppMethodBeat.m2505o(6291);
                            return;
                        }
                        int intExtra = intent.getIntExtra("key_pick_local_media_callback_type", 0);
                        String stringExtra;
                        HashMap hashMap;
                        if (intExtra == 1) {
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                            String stringExtra2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                            C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "video localId:%s", stringExtra);
                            C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "video thumbLocalId:%s", stringExtra2);
                            if (C5046bo.isNullOrNil(stringExtra)) {
                                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
                                C22846h.m34667a(C22846h.this, "fail");
                                AppMethodBeat.m2505o(6291);
                                return;
                            }
                            WebViewJSSDKFileItem aeo = C29782c.aeo(stringExtra);
                            if (aeo == null || !(aeo instanceof WebViewJSSDKVideoItem)) {
                                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
                                break;
                            }
                            WebViewJSSDKVideoItem webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) aeo;
                            C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "after parse to json data : %s", C43914ap.m78770c(stringExtra, stringExtra2, webViewJSSDKVideoItem.duration, webViewJSSDKVideoItem.height, webViewJSSDKVideoItem.width, webViewJSSDKVideoItem.size));
                            hashMap = new HashMap();
                            hashMap.put("type", Integer.valueOf(1));
                            hashMap.put("localIds", stringExtra);
                            C22846h.m34669a(C22846h.this, hashMap);
                            AppMethodBeat.m2505o(6291);
                            return;
                        } else if (intExtra == 2) {
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_ids");
                            C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "chooseMedia localIds:%s", stringExtra);
                            if (C5046bo.isNullOrNil(stringExtra)) {
                                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
                                C22846h.m34667a(C22846h.this, "fail");
                                AppMethodBeat.m2505o(6291);
                                return;
                            }
                            hashMap = new HashMap();
                            hashMap.put("type", Integer.valueOf(2));
                            hashMap.put("localIds", stringExtra);
                            C22846h.m34669a(C22846h.this, hashMap);
                            AppMethodBeat.m2505o(6291);
                            return;
                        } else {
                            C4990ab.m7413e("MicroMsg.JsApiChooseMedia", "type:%d is error", Integer.valueOf(intExtra));
                            C22846h.m34667a(C22846h.this, "fail");
                            AppMethodBeat.m2505o(6291);
                            return;
                        }
                        break;
                    case 0:
                        C22846h.m34667a(C22846h.this, "cancel");
                        AppMethodBeat.m2505o(6291);
                        return;
                }
                C22846h.m34667a(C22846h.this, "fail");
            }
            AppMethodBeat.m2505o(6291);
        }
    }

    public C22846h() {
        AppMethodBeat.m2504i(6292);
        AppMethodBeat.m2505o(6292);
    }

    public final String name() {
        return JsApiChooseMedia.NAME;
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6293);
        C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "invoke");
        this.hwd = (MMActivity) ((C24905d) c32183a.bOZ).mContext;
        this.ujY = c32183a;
        if (this.hwd == null) {
            m34672b("fail", null);
            AppMethodBeat.m2505o(6293);
            return;
        }
        JSONObject jSONObject = c32183a.bPa.bOf;
        C4990ab.m7417i("MicroMsg.JsApiChooseMedia", " checkPermission checkcamera[%b]", Boolean.valueOf(C35805b.m58707a(this.hwd, "android.permission.CAMERA", C31128d.MIC_AVROUND_BLUR, "", "")));
        C4990ab.m7417i("MicroMsg.JsApiChooseMedia", " checkPermission checkMicroPhone[%b]", Boolean.valueOf(C35805b.m58707a(this.hwd, "android.permission.RECORD_AUDIO", 120, "", "")));
        if (C35805b.m58707a(this.hwd, "android.permission.RECORD_AUDIO", 120, "", "") && r0) {
            String str;
            String nullAsNil = C5046bo.nullAsNil(jSONObject.optString("sourceType"));
            String optString = jSONObject.optString("mediaType", "");
            int min = Math.min(jSONObject.optInt("maxDuration", 10), 10);
            final String optString2 = jSONObject.optString("camera", "");
            int optInt = jSONObject.optInt("count", 1);
            String optString3 = jSONObject.optString("sizeType", "");
            C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", nullAsNil, optString, Integer.valueOf(min), optString2, Integer.valueOf(optInt), optString3);
            final Intent intent = new Intent();
            intent.putExtra("key_pick_local_pic_count", optInt);
            if (min <= 0) {
                min = 10;
            }
            intent.putExtra("key_pick_local_media_duration", min);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("key_pick_local_media_video_type", 2);
            intent.putExtra("key_pick_local_media_sight_type", optString);
            intent.putExtra("key_pick_local_pic_query_source_type", (optString3.contains("original") ^ optString3.contains("compressed")) != 0 ? 7 : 8);
            intent.putExtra("key_pick_local_pic_send_raw", Boolean.valueOf(optString3.contains("compressed")));
            if (C5046bo.isNullOrNil(nullAsNil)) {
                str = "album|camera";
            } else {
                str = nullAsNil;
            }
            if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM) && str.contains("camera")) {
                C46696j c46696j = new C46696j(this.hwd);
                c46696j.mo75009b(null, new C228451(), new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(6289);
                        switch (menuItem.getItemId()) {
                            case 1:
                                C22846h.m34668a(C22846h.this, optString2, intent);
                                AppMethodBeat.m2505o(6289);
                                return;
                            case 2:
                                C22846h.m34666a(C22846h.this, intent);
                                break;
                        }
                        AppMethodBeat.m2505o(6289);
                    }
                });
                c46696j.mo75012e(new C228483());
                c46696j.cuu();
                AppMethodBeat.m2505o(6293);
                return;
            } else if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                m34670aA(intent);
                AppMethodBeat.m2505o(6293);
                return;
            } else if (str.contains("camera")) {
                m34671b(optString2, intent);
                AppMethodBeat.m2505o(6293);
                return;
            } else {
                m34672b("sourceType_error", null);
                AppMethodBeat.m2505o(6293);
                return;
            }
        }
        m34672b("no_user_permission", null);
        AppMethodBeat.m2505o(6293);
    }

    /* renamed from: b */
    private void m34671b(String str, Intent intent) {
        int i;
        AppMethodBeat.m2504i(6294);
        C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
        if (str.equals("front")) {
            i = 16;
        } else {
            i = 256;
        }
        intent.putExtra("key_pick_local_pic_capture", i);
        this.hwd.ifE = this.hvq;
        C25985d.m41453a(this.hwd, "webview", ".ui.tools.OpenFileChooserUI", intent, CdnLogic.kBizGeneric & hashCode(), false);
        AppMethodBeat.m2505o(6294);
    }

    /* renamed from: aA */
    private void m34670aA(Intent intent) {
        AppMethodBeat.m2504i(6295);
        C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
        intent.putExtra("key_pick_local_pic_capture", 4096);
        this.hwd.ifE = this.hvq;
        C25985d.m41453a(this.hwd, "webview", ".ui.tools.OpenFileChooserUI", intent, CdnLogic.kBizGeneric & hashCode(), false);
        AppMethodBeat.m2505o(6295);
    }

    /* renamed from: b */
    private void m34672b(String str, HashMap<String, Object> hashMap) {
        AppMethodBeat.m2504i(6296);
        if (this.ujY != null) {
            this.ujY.mo52825c(str, hashMap);
        }
        this.ujY = null;
        this.hwd = null;
        AppMethodBeat.m2505o(6296);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
