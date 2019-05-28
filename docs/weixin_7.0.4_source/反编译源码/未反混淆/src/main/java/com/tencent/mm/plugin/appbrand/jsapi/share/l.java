package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.luggage.sdk.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.File;
import java.io.IOException;

public final class l {
    public static String a(final a aVar, String str, boolean z) {
        String str2 = null;
        AppMethodBeat.i(131476);
        if (aVar == null) {
            AppMethodBeat.o(131476);
            return null;
        }
        String appId = aVar.getAppId();
        if (bo.isNullOrNil(str)) {
            if (z) {
                aVar.a(1, null, new Object[0]);
                if (aVar.asE() == null) {
                    ab.e("MicroMsg.ShareHelper", "tryToGetLocalFilePath NULL fs with appId(%s)", aVar.getAppId());
                    AppMethodBeat.o(131476);
                    return null;
                }
                b yh = aVar.asE().yh("share_" + System.currentTimeMillis());
                if (yh == null) {
                    AppMethodBeat.o(131476);
                    return null;
                }
                appId = j.w(yh.dMD());
                Bundle bundle = new Bundle();
                bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 1);
                f.a("com.tencent.mm", bundle, a.class, null);
                aVar.xR().a((d.b) new d.b<Bitmap>() {
                    public final /* synthetic */ void az(Object obj) {
                        AppMethodBeat.i(131475);
                        Bitmap bitmap = (Bitmap) obj;
                        if (bitmap != null) {
                            try {
                                if (!bitmap.isRecycled()) {
                                    final long currentTimeMillis = System.currentTimeMillis();
                                    com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.JPEG, appId, true);
                                    ab.i("MicroMsg.ShareHelper", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", aVar.getAppId(), Integer.valueOf(aVar.hashCode()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    final Bundle bundle = new Bundle();
                                    bundle.putString("delay_load_img_path", "file://" + appId);
                                    com.tencent.mm.ce.a.post(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(131474);
                                            ab.i("MicroMsg.ShareHelper", "notifyToRefreshImg(cost : %s)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                            bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 2);
                                            f.a("com.tencent.mm", bundle, a.class, null);
                                            AppMethodBeat.o(131474);
                                        }
                                    });
                                }
                            } catch (Exception e) {
                                ab.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", e);
                                if (!(bitmap == null || bitmap.isRecycled())) {
                                    ab.i("MicroMsg.ShareHelper", "bitmap recycle %s", bitmap);
                                    bitmap.recycle();
                                    AppMethodBeat.o(131475);
                                    return;
                                }
                            } catch (Throwable th) {
                                if (!(bitmap == null || bitmap.isRecycled())) {
                                    ab.i("MicroMsg.ShareHelper", "bitmap recycle %s", bitmap);
                                    bitmap.recycle();
                                }
                                AppMethodBeat.o(131475);
                            }
                        }
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            ab.i("MicroMsg.ShareHelper", "bitmap recycle %s", bitmap);
                            bitmap.recycle();
                            AppMethodBeat.o(131475);
                            return;
                        }
                        AppMethodBeat.o(131475);
                    }
                });
                str2 = "delayLoadFile://".concat(String.valueOf(appId));
                AppMethodBeat.o(131476);
                return str2;
            }
            AppMethodBeat.o(131476);
            return null;
        } else if (str.startsWith("wxfile://")) {
            File yg = aVar.asE().yg(str);
            if (yg != null && yg.exists()) {
                str2 = "file://" + yg.getAbsolutePath();
            }
            AppMethodBeat.o(131476);
            return str2;
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            AppMethodBeat.o(131476);
            return null;
        } else {
            appId = AppBrandLocalMediaObjectManager.genMediaFilePath(appId, "share_" + System.currentTimeMillis());
            Bitmap j = s.j(aVar.xL(), str);
            if (j == null || j.isRecycled()) {
                AppMethodBeat.o(131476);
                return null;
            }
            try {
                com.tencent.mm.sdk.platformtools.d.a(j, 100, CompressFormat.PNG, appId, true);
                if (!(j == null || j.isRecycled())) {
                    ab.i("MicroMsg.ShareHelper", "bitmap recycle %s", j);
                    j.recycle();
                }
            } catch (IOException e) {
                ab.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", e);
                if (!(j == null || j.isRecycled())) {
                    ab.i("MicroMsg.ShareHelper", "bitmap recycle %s", j);
                    j.recycle();
                }
            } catch (Throwable th) {
                if (!(j == null || j.isRecycled())) {
                    ab.i("MicroMsg.ShareHelper", "bitmap recycle %s", j);
                    j.recycle();
                }
                AppMethodBeat.o(131476);
            }
            str2 = "file://".concat(String.valueOf(appId));
            AppMethodBeat.o(131476);
            return str2;
        }
    }

    public static boolean BK(String str) {
        AppMethodBeat.i(131477);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(131477);
            return true;
        }
        AppMethodBeat.o(131477);
        return false;
    }

    public static String getRealPath(String str) {
        AppMethodBeat.i(131478);
        if (str == null) {
            AppMethodBeat.o(131478);
            return null;
        } else if (str.startsWith("file://")) {
            str = str.replace("file://", "");
            AppMethodBeat.o(131478);
            return str;
        } else if (str.startsWith("delayLoadFile://")) {
            str = str.replace("delayLoadFile://", "");
            AppMethodBeat.o(131478);
            return str;
        } else {
            AppMethodBeat.o(131478);
            return str;
        }
    }
}
