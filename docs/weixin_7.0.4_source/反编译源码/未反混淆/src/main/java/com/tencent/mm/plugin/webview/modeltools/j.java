package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.ak;
import org.json.JSONObject;

public final class j {
    private static long upy = 0;

    public static void cYL() {
        AppMethodBeat.i(7022);
        upy = System.currentTimeMillis();
        AppMethodBeat.o(7022);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(Bundle bundle, e eVar, boolean z) {
        boolean z2;
        Exception e;
        AppMethodBeat.i(7023);
        if (System.currentTimeMillis() - upy < 1000) {
            AppMethodBeat.o(7023);
            return;
        }
        String string = bundle.getString("url");
        String string2 = bundle.getString("filePath");
        String str = "";
        String[] strArr = new String[1];
        if (!bo.isNullOrNil(string2)) {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = d.decodeFile(string2, options);
            if (decodeFile != null) {
                ab.i("MicroMsg.WebViewPreviewImgHelper", "recycle bitmap:%s", decodeFile.toString());
                decodeFile.recycle();
                strArr[0] = string2;
                if (bo.isNullOrNil(string2) || bo.isNullOrNil(string)) {
                    ab.w("MicroMsg.WebViewPreviewImgHelper", "imagePreview failed url is null");
                    AppMethodBeat.o(7023);
                }
                Bundle g;
                int i;
                Context context;
                strArr[0] = string;
                Intent intent = new Intent();
                intent.putExtra("nowUrl", string);
                intent.putExtra("urlList", strArr);
                intent.putExtra("type", -255);
                intent.putExtra("isFromWebView", true);
                intent.putExtra("isOuntLink", true);
                str = "";
                try {
                    g = eVar.g(90001, new Bundle());
                    if (g != null) {
                        string2 = g.getString("cookie", null);
                        if (!bo.isNullOrNil(string2)) {
                            intent.putExtra("cookie", string2);
                        }
                    }
                    g = eVar.g(18, null);
                    if (g != null) {
                        string = g.getString("preChatName");
                        String string3 = g.getString("preUsername");
                        String string4 = g.getString("rawUrl");
                        str = g.getString("url");
                        i = g.getInt("getA8KeyScene");
                        String nW = v.nW("ImgPreview");
                        b y = v.Zp().y(nW, true);
                        y.j("preUsername", string);
                        y.j("preChatName", string3);
                        y.j("url", str);
                        y.j("rawUrl", string4);
                        if (i == 53 || i == 52) {
                            ab.i("MicroMsg.WebViewPreviewImgHelper", "not allow to ScanQRCode");
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        try {
                            intent.putExtra("img_gallery_session_id", nW);
                        } catch (Exception e2) {
                            e = e2;
                            ab.e("MicroMsg.WebViewPreviewImgHelper", "getCookie fail : %s", e.getMessage());
                            intent.putExtra("shouldShowScanQrCodeMenu", z2);
                            g = new Bundle();
                            g.putInt("stat_scene", 4);
                            g.putString("stat_url", str);
                            intent.putExtra("_stat_obj", g);
                            context = ah.getContext();
                            if (cYM()) {
                            }
                            com.tencent.mm.bp.d.b(ah.getContext(), "subapp", ".ui.gallery.GestureGalleryUI", intent);
                            AppMethodBeat.o(7023);
                            return;
                        }
                    }
                    z2 = true;
                } catch (Exception e3) {
                    e = e3;
                    z2 = true;
                    ab.e("MicroMsg.WebViewPreviewImgHelper", "getCookie fail : %s", e.getMessage());
                    intent.putExtra("shouldShowScanQrCodeMenu", z2);
                    g = new Bundle();
                    g.putInt("stat_scene", 4);
                    g.putString("stat_url", str);
                    intent.putExtra("_stat_obj", g);
                    context = ah.getContext();
                    if (cYM()) {
                    }
                    com.tencent.mm.bp.d.b(ah.getContext(), "subapp", ".ui.gallery.GestureGalleryUI", intent);
                    AppMethodBeat.o(7023);
                    return;
                }
                intent.putExtra("shouldShowScanQrCodeMenu", z2);
                g = new Bundle();
                g.putInt("stat_scene", 4);
                g.putString("stat_url", str);
                intent.putExtra("_stat_obj", g);
                context = ah.getContext();
                if (cYM()) {
                    int i2 = (int) bundle.getFloat("width");
                    int i3 = (int) bundle.getFloat("height");
                    int i4 = (int) bundle.getFloat("left");
                    i = (int) (((float) (z ? 0 : ak.de(context) + ak.hF(context))) + bundle.getFloat("top"));
                    int ge = a.ge(context);
                    ab.d("MicroMsg.WebViewPreviewImgHelper", "doPreviewImg left %d, top %d, w %d, h %d", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    intent.putExtra("img_gallery_width", i2).putExtra("img_gallery_height", i3).putExtra("img_gallery_left", i4).putExtra("img_gallery_top", i);
                    if (i2 > 0 && i3 > 0 && i3 < ge) {
                        intent.putExtra("shouldRunDragAnimation", true);
                    }
                }
                com.tencent.mm.bp.d.b(ah.getContext(), "subapp", ".ui.gallery.GestureGalleryUI", intent);
                AppMethodBeat.o(7023);
                return;
            }
            ab.i("MicroMsg.WebViewPreviewImgHelper", "decode fail %s", string2);
        }
        string2 = str;
        if (bo.isNullOrNil(string2)) {
        }
        ab.w("MicroMsg.WebViewPreviewImgHelper", "imagePreview failed url is null");
        AppMethodBeat.o(7023);
    }

    public static void d(com.tencent.mm.plugin.webview.stub.d dVar) {
        AppMethodBeat.i(7024);
        if (dVar == null) {
            AppMethodBeat.o(7024);
            return;
        }
        try {
            dVar.g(108, new Bundle());
            AppMethodBeat.o(7024);
        } catch (RemoteException e) {
            AppMethodBeat.o(7024);
        }
    }

    public static boolean cYM() {
        AppMethodBeat.i(7025);
        ab.i("MicroMsg.WebViewPreviewImgHelper", "shouldShowAnimation %d", Integer.valueOf(((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_webview_preview_img_with_ani, 1)));
        if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_webview_preview_img_with_ani, 1) == 1) {
            AppMethodBeat.o(7025);
            return true;
        }
        AppMethodBeat.o(7025);
        return false;
    }

    public static String a(String str, String[] strArr, JSONObject jSONObject) {
        AppMethodBeat.i(138037);
        if (strArr == null || strArr.length == 0 || str == null) {
            AppMethodBeat.o(138037);
            return str;
        }
        String optString = jSONObject.optString("data");
        if (bo.isNullOrNil(optString)) {
            AppMethodBeat.o(138037);
            return str;
        }
        String v = q.v(str, 0, "@T");
        if (!com.tencent.mm.vfs.e.ct(v)) {
            try {
                byte[] decode = Base64.decode(optString.substring(optString.indexOf(44) + 1), 2);
                com.tencent.mm.vfs.e.b(v, decode, decode.length);
            } catch (Exception e) {
                ab.w("MicroMsg.WebViewPreviewImgHelper", "decode file fail: %s", e.getMessage());
                AppMethodBeat.o(138037);
                return str;
            }
        }
        for (int i = 0; i < strArr.length; i++) {
            if (str.equals(strArr[i])) {
                strArr[i] = v;
                break;
            }
        }
        ab.i("MicroMsg.WebViewPreviewImgHelper", "use base64 data: %s", v);
        AppMethodBeat.o(138037);
        return v;
    }
}
