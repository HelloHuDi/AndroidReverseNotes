package com.tencent.p177mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.webview.stub.C40281e;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.pluginsdk.model.C30080q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.j */
public final class C46431j {
    private static long upy = 0;

    public static void cYL() {
        AppMethodBeat.m2504i(7022);
        upy = System.currentTimeMillis();
        AppMethodBeat.m2505o(7022);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m87454a(Bundle bundle, C40281e c40281e, boolean z) {
        boolean z2;
        Exception e;
        AppMethodBeat.m2504i(7023);
        if (System.currentTimeMillis() - upy < 1000) {
            AppMethodBeat.m2505o(7023);
            return;
        }
        String string = bundle.getString("url");
        String string2 = bundle.getString("filePath");
        String str = "";
        String[] strArr = new String[1];
        if (!C5046bo.isNullOrNil(string2)) {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = C5056d.decodeFile(string2, options);
            if (decodeFile != null) {
                C4990ab.m7417i("MicroMsg.WebViewPreviewImgHelper", "recycle bitmap:%s", decodeFile.toString());
                decodeFile.recycle();
                strArr[0] = string2;
                if (C5046bo.isNullOrNil(string2) || C5046bo.isNullOrNil(string)) {
                    C4990ab.m7420w("MicroMsg.WebViewPreviewImgHelper", "imagePreview failed url is null");
                    AppMethodBeat.m2505o(7023);
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
                    g = c40281e.mo6226g(90001, new Bundle());
                    if (g != null) {
                        string2 = g.getString("cookie", null);
                        if (!C5046bo.isNullOrNil(string2)) {
                            intent.putExtra("cookie", string2);
                        }
                    }
                    g = c40281e.mo6226g(18, null);
                    if (g != null) {
                        string = g.getString("preChatName");
                        String string3 = g.getString("preUsername");
                        String string4 = g.getString("rawUrl");
                        str = g.getString("url");
                        i = g.getInt("getA8KeyScene");
                        String nW = C37922v.m64078nW("ImgPreview");
                        C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                        y.mo53356j("preUsername", string);
                        y.mo53356j("preChatName", string3);
                        y.mo53356j("url", str);
                        y.mo53356j("rawUrl", string4);
                        if (i == 53 || i == 52) {
                            C4990ab.m7416i("MicroMsg.WebViewPreviewImgHelper", "not allow to ScanQRCode");
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        try {
                            intent.putExtra("img_gallery_session_id", nW);
                        } catch (Exception e2) {
                            e = e2;
                            C4990ab.m7413e("MicroMsg.WebViewPreviewImgHelper", "getCookie fail : %s", e.getMessage());
                            intent.putExtra("shouldShowScanQrCodeMenu", z2);
                            g = new Bundle();
                            g.putInt("stat_scene", 4);
                            g.putString("stat_url", str);
                            intent.putExtra("_stat_obj", g);
                            context = C4996ah.getContext();
                            if (C46431j.cYM()) {
                            }
                            C25985d.m41467b(C4996ah.getContext(), "subapp", ".ui.gallery.GestureGalleryUI", intent);
                            AppMethodBeat.m2505o(7023);
                            return;
                        }
                    }
                    z2 = true;
                } catch (Exception e3) {
                    e = e3;
                    z2 = true;
                    C4990ab.m7413e("MicroMsg.WebViewPreviewImgHelper", "getCookie fail : %s", e.getMessage());
                    intent.putExtra("shouldShowScanQrCodeMenu", z2);
                    g = new Bundle();
                    g.putInt("stat_scene", 4);
                    g.putString("stat_url", str);
                    intent.putExtra("_stat_obj", g);
                    context = C4996ah.getContext();
                    if (C46431j.cYM()) {
                    }
                    C25985d.m41467b(C4996ah.getContext(), "subapp", ".ui.gallery.GestureGalleryUI", intent);
                    AppMethodBeat.m2505o(7023);
                    return;
                }
                intent.putExtra("shouldShowScanQrCodeMenu", z2);
                g = new Bundle();
                g.putInt("stat_scene", 4);
                g.putString("stat_url", str);
                intent.putExtra("_stat_obj", g);
                context = C4996ah.getContext();
                if (C46431j.cYM()) {
                    int i2 = (int) bundle.getFloat("width");
                    int i3 = (int) bundle.getFloat("height");
                    int i4 = (int) bundle.getFloat("left");
                    i = (int) (((float) (z ? 0 : C5230ak.m7987de(context) + C5230ak.m7989hF(context))) + bundle.getFloat("top"));
                    int ge = C1338a.m2869ge(context);
                    C4990ab.m7411d("MicroMsg.WebViewPreviewImgHelper", "doPreviewImg left %d, top %d, w %d, h %d", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    intent.putExtra("img_gallery_width", i2).putExtra("img_gallery_height", i3).putExtra("img_gallery_left", i4).putExtra("img_gallery_top", i);
                    if (i2 > 0 && i3 > 0 && i3 < ge) {
                        intent.putExtra("shouldRunDragAnimation", true);
                    }
                }
                C25985d.m41467b(C4996ah.getContext(), "subapp", ".ui.gallery.GestureGalleryUI", intent);
                AppMethodBeat.m2505o(7023);
                return;
            }
            C4990ab.m7417i("MicroMsg.WebViewPreviewImgHelper", "decode fail %s", string2);
        }
        string2 = str;
        if (C5046bo.isNullOrNil(string2)) {
        }
        C4990ab.m7420w("MicroMsg.WebViewPreviewImgHelper", "imagePreview failed url is null");
        AppMethodBeat.m2505o(7023);
    }

    /* renamed from: d */
    public static void m87455d(C46434d c46434d) {
        AppMethodBeat.m2504i(7024);
        if (c46434d == null) {
            AppMethodBeat.m2505o(7024);
            return;
        }
        try {
            c46434d.mo15575g(108, new Bundle());
            AppMethodBeat.m2505o(7024);
        } catch (RemoteException e) {
            AppMethodBeat.m2505o(7024);
        }
    }

    public static boolean cYM() {
        AppMethodBeat.m2504i(7025);
        C4990ab.m7417i("MicroMsg.WebViewPreviewImgHelper", "shouldShowAnimation %d", Integer.valueOf(((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_webview_preview_img_with_ani, 1)));
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_webview_preview_img_with_ani, 1) == 1) {
            AppMethodBeat.m2505o(7025);
            return true;
        }
        AppMethodBeat.m2505o(7025);
        return false;
    }

    /* renamed from: a */
    public static String m87453a(String str, String[] strArr, JSONObject jSONObject) {
        AppMethodBeat.m2504i(138037);
        if (strArr == null || strArr.length == 0 || str == null) {
            AppMethodBeat.m2505o(138037);
            return str;
        }
        String optString = jSONObject.optString("data");
        if (C5046bo.isNullOrNil(optString)) {
            AppMethodBeat.m2505o(138037);
            return str;
        }
        String v = C30080q.m47642v(str, 0, "@T");
        if (!C5730e.m8628ct(v)) {
            try {
                byte[] decode = Base64.decode(optString.substring(optString.indexOf(44) + 1), 2);
                C5730e.m8624b(v, decode, decode.length);
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.WebViewPreviewImgHelper", "decode file fail: %s", e.getMessage());
                AppMethodBeat.m2505o(138037);
                return str;
            }
        }
        for (int i = 0; i < strArr.length; i++) {
            if (str.equals(strArr[i])) {
                strArr[i] = v;
                break;
            }
        }
        C4990ab.m7417i("MicroMsg.WebViewPreviewImgHelper", "use base64 data: %s", v);
        AppMethodBeat.m2505o(138037);
        return v;
    }
}
