package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ap;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.j;
import java.util.HashMap;
import org.json.JSONObject;

public class h extends bd<d> {
    private a hvq = new a() {
        public final void c(int i, int i2, Intent intent) {
            AppMethodBeat.i(6291);
            if (i == (h.this.hashCode() & CdnLogic.kBizGeneric)) {
                switch (i2) {
                    case -1:
                        if (intent == null) {
                            ab.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA bundle is null,");
                            h.a(h.this, "fail");
                            AppMethodBeat.o(6291);
                            return;
                        }
                        int intExtra = intent.getIntExtra("key_pick_local_media_callback_type", 0);
                        String stringExtra;
                        HashMap hashMap;
                        if (intExtra == 1) {
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                            String stringExtra2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                            ab.i("MicroMsg.JsApiChooseMedia", "video localId:%s", stringExtra);
                            ab.i("MicroMsg.JsApiChooseMedia", "video thumbLocalId:%s", stringExtra2);
                            if (bo.isNullOrNil(stringExtra)) {
                                ab.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
                                h.a(h.this, "fail");
                                AppMethodBeat.o(6291);
                                return;
                            }
                            WebViewJSSDKFileItem aeo = c.aeo(stringExtra);
                            if (aeo == null || !(aeo instanceof WebViewJSSDKVideoItem)) {
                                ab.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
                                break;
                            }
                            WebViewJSSDKVideoItem webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) aeo;
                            ab.i("MicroMsg.JsApiChooseMedia", "after parse to json data : %s", ap.c(stringExtra, stringExtra2, webViewJSSDKVideoItem.duration, webViewJSSDKVideoItem.height, webViewJSSDKVideoItem.width, webViewJSSDKVideoItem.size));
                            hashMap = new HashMap();
                            hashMap.put("type", Integer.valueOf(1));
                            hashMap.put("localIds", stringExtra);
                            h.a(h.this, hashMap);
                            AppMethodBeat.o(6291);
                            return;
                        } else if (intExtra == 2) {
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_ids");
                            ab.i("MicroMsg.JsApiChooseMedia", "chooseMedia localIds:%s", stringExtra);
                            if (bo.isNullOrNil(stringExtra)) {
                                ab.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
                                h.a(h.this, "fail");
                                AppMethodBeat.o(6291);
                                return;
                            }
                            hashMap = new HashMap();
                            hashMap.put("type", Integer.valueOf(2));
                            hashMap.put("localIds", stringExtra);
                            h.a(h.this, hashMap);
                            AppMethodBeat.o(6291);
                            return;
                        } else {
                            ab.e("MicroMsg.JsApiChooseMedia", "type:%d is error", Integer.valueOf(intExtra));
                            h.a(h.this, "fail");
                            AppMethodBeat.o(6291);
                            return;
                        }
                        break;
                    case 0:
                        h.a(h.this, "cancel");
                        AppMethodBeat.o(6291);
                        return;
                }
                h.a(h.this, "fail");
            }
            AppMethodBeat.o(6291);
        }
    };
    private MMActivity hwd;
    private com.tencent.luggage.d.a.a ujY;

    public h() {
        AppMethodBeat.i(6292);
        AppMethodBeat.o(6292);
    }

    public final String name() {
        return JsApiChooseMedia.NAME;
    }

    public final int biG() {
        return 0;
    }

    public final void b(com.tencent.luggage.d.a.a aVar) {
        AppMethodBeat.i(6293);
        ab.i("MicroMsg.JsApiChooseMedia", "invoke");
        this.hwd = (MMActivity) ((d) aVar.bOZ).mContext;
        this.ujY = aVar;
        if (this.hwd == null) {
            b("fail", null);
            AppMethodBeat.o(6293);
            return;
        }
        JSONObject jSONObject = aVar.bPa.bOf;
        ab.i("MicroMsg.JsApiChooseMedia", " checkPermission checkcamera[%b]", Boolean.valueOf(b.a(this.hwd, "android.permission.CAMERA", com.tencent.view.d.MIC_AVROUND_BLUR, "", "")));
        ab.i("MicroMsg.JsApiChooseMedia", " checkPermission checkMicroPhone[%b]", Boolean.valueOf(b.a(this.hwd, "android.permission.RECORD_AUDIO", 120, "", "")));
        if (b.a(this.hwd, "android.permission.RECORD_AUDIO", 120, "", "") && r0) {
            String str;
            String nullAsNil = bo.nullAsNil(jSONObject.optString("sourceType"));
            String optString = jSONObject.optString("mediaType", "");
            int min = Math.min(jSONObject.optInt("maxDuration", 10), 10);
            final String optString2 = jSONObject.optString("camera", "");
            int optInt = jSONObject.optInt("count", 1);
            String optString3 = jSONObject.optString("sizeType", "");
            ab.i("MicroMsg.JsApiChooseMedia", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", nullAsNil, optString, Integer.valueOf(min), optString2, Integer.valueOf(optInt), optString3);
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
            if (bo.isNullOrNil(nullAsNil)) {
                str = "album|camera";
            } else {
                str = nullAsNil;
            }
            if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM) && str.contains("camera")) {
                j jVar = new j(this.hwd);
                jVar.b(null, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(6288);
                        contextMenu.add(0, 1, 0, h.this.hwd.getString(R.string.q4));
                        contextMenu.add(0, 2, 1, h.this.hwd.getString(R.string.qa));
                        AppMethodBeat.o(6288);
                    }
                }, new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(6289);
                        switch (menuItem.getItemId()) {
                            case 1:
                                h.a(h.this, optString2, intent);
                                AppMethodBeat.o(6289);
                                return;
                            case 2:
                                h.a(h.this, intent);
                                break;
                        }
                        AppMethodBeat.o(6289);
                    }
                });
                jVar.e(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(6290);
                        h.a(h.this, "cancel");
                        AppMethodBeat.o(6290);
                    }
                });
                jVar.cuu();
                AppMethodBeat.o(6293);
                return;
            } else if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                aA(intent);
                AppMethodBeat.o(6293);
                return;
            } else if (str.contains("camera")) {
                b(optString2, intent);
                AppMethodBeat.o(6293);
                return;
            } else {
                b("sourceType_error", null);
                AppMethodBeat.o(6293);
                return;
            }
        }
        b("no_user_permission", null);
        AppMethodBeat.o(6293);
    }

    private void b(String str, Intent intent) {
        int i;
        AppMethodBeat.i(6294);
        ab.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
        if (str.equals("front")) {
            i = 16;
        } else {
            i = 256;
        }
        intent.putExtra("key_pick_local_pic_capture", i);
        this.hwd.ifE = this.hvq;
        com.tencent.mm.bp.d.a(this.hwd, "webview", ".ui.tools.OpenFileChooserUI", intent, CdnLogic.kBizGeneric & hashCode(), false);
        AppMethodBeat.o(6294);
    }

    private void aA(Intent intent) {
        AppMethodBeat.i(6295);
        ab.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
        intent.putExtra("key_pick_local_pic_capture", 4096);
        this.hwd.ifE = this.hvq;
        com.tencent.mm.bp.d.a(this.hwd, "webview", ".ui.tools.OpenFileChooserUI", intent, CdnLogic.kBizGeneric & hashCode(), false);
        AppMethodBeat.o(6295);
    }

    private void b(String str, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(6296);
        if (this.ujY != null) {
            this.ujY.c(str, hashMap);
        }
        this.ujY = null;
        this.hwd = null;
        AppMethodBeat.o(6296);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
