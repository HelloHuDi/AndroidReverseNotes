package com.tencent.p177mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.luggage.sdk.p819a.p820a.C37402a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.p177mm.plugin.appbrand.page.C38475s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vending.p641g.C5692d.C5691b;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5736j;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.l */
public final class C27080l {
    /* renamed from: a */
    public static String m43031a(final C37402a c37402a, String str, boolean z) {
        String str2 = null;
        AppMethodBeat.m2504i(131476);
        if (c37402a == null) {
            AppMethodBeat.m2505o(131476);
            return null;
        }
        String appId = c37402a.getAppId();
        if (C5046bo.isNullOrNil(str)) {
            if (z) {
                c37402a.mo53736a(1, null, new Object[0]);
                if (c37402a.asE() == null) {
                    C4990ab.m7413e("MicroMsg.ShareHelper", "tryToGetLocalFilePath NULL fs with appId(%s)", c37402a.getAppId());
                    AppMethodBeat.m2505o(131476);
                    return null;
                }
                C5728b yh = c37402a.asE().mo34315yh("share_" + System.currentTimeMillis());
                if (yh == null) {
                    AppMethodBeat.m2505o(131476);
                    return null;
                }
                appId = C5736j.m8649w(yh.dMD());
                Bundle bundle = new Bundle();
                bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 1);
                C9549f.m17012a("com.tencent.mm", bundle, C10513a.class, null);
                c37402a.mo53754xR().mo11587a((C5691b) new C5691b<Bitmap>() {
                    /* renamed from: az */
                    public final /* synthetic */ void mo5270az(Object obj) {
                        AppMethodBeat.m2504i(131475);
                        Bitmap bitmap = (Bitmap) obj;
                        if (bitmap != null) {
                            try {
                                if (!bitmap.isRecycled()) {
                                    final long currentTimeMillis = System.currentTimeMillis();
                                    C5056d.m7625a(bitmap, 100, CompressFormat.JPEG, appId, true);
                                    C4990ab.m7417i("MicroMsg.ShareHelper", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", c37402a.getAppId(), Integer.valueOf(c37402a.hashCode()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    final Bundle bundle = new Bundle();
                                    bundle.putString("delay_load_img_path", "file://" + appId);
                                    C26006a.post(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.m2504i(131474);
                                            C4990ab.m7417i("MicroMsg.ShareHelper", "notifyToRefreshImg(cost : %s)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                            bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 2);
                                            C9549f.m17012a("com.tencent.mm", bundle, C10513a.class, null);
                                            AppMethodBeat.m2505o(131474);
                                        }
                                    });
                                }
                            } catch (Exception e) {
                                C4990ab.m7421w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", e);
                                if (!(bitmap == null || bitmap.isRecycled())) {
                                    C4990ab.m7417i("MicroMsg.ShareHelper", "bitmap recycle %s", bitmap);
                                    bitmap.recycle();
                                    AppMethodBeat.m2505o(131475);
                                    return;
                                }
                            } catch (Throwable th) {
                                if (!(bitmap == null || bitmap.isRecycled())) {
                                    C4990ab.m7417i("MicroMsg.ShareHelper", "bitmap recycle %s", bitmap);
                                    bitmap.recycle();
                                }
                                AppMethodBeat.m2505o(131475);
                            }
                        }
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            C4990ab.m7417i("MicroMsg.ShareHelper", "bitmap recycle %s", bitmap);
                            bitmap.recycle();
                            AppMethodBeat.m2505o(131475);
                            return;
                        }
                        AppMethodBeat.m2505o(131475);
                    }
                });
                str2 = "delayLoadFile://".concat(String.valueOf(appId));
                AppMethodBeat.m2505o(131476);
                return str2;
            }
            AppMethodBeat.m2505o(131476);
            return null;
        } else if (str.startsWith("wxfile://")) {
            File yg = c37402a.asE().mo34314yg(str);
            if (yg != null && yg.exists()) {
                str2 = "file://" + yg.getAbsolutePath();
            }
            AppMethodBeat.m2505o(131476);
            return str2;
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            AppMethodBeat.m2505o(131476);
            return null;
        } else {
            appId = AppBrandLocalMediaObjectManager.genMediaFilePath(appId, "share_" + System.currentTimeMillis());
            Bitmap j = C38475s.m65114j(c37402a.mo44922xL(), str);
            if (j == null || j.isRecycled()) {
                AppMethodBeat.m2505o(131476);
                return null;
            }
            try {
                C5056d.m7625a(j, 100, CompressFormat.PNG, appId, true);
                if (!(j == null || j.isRecycled())) {
                    C4990ab.m7417i("MicroMsg.ShareHelper", "bitmap recycle %s", j);
                    j.recycle();
                }
            } catch (IOException e) {
                C4990ab.m7421w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", e);
                if (!(j == null || j.isRecycled())) {
                    C4990ab.m7417i("MicroMsg.ShareHelper", "bitmap recycle %s", j);
                    j.recycle();
                }
            } catch (Throwable th) {
                if (!(j == null || j.isRecycled())) {
                    C4990ab.m7417i("MicroMsg.ShareHelper", "bitmap recycle %s", j);
                    j.recycle();
                }
                AppMethodBeat.m2505o(131476);
            }
            str2 = "file://".concat(String.valueOf(appId));
            AppMethodBeat.m2505o(131476);
            return str2;
        }
    }

    /* renamed from: BK */
    public static boolean m43030BK(String str) {
        AppMethodBeat.m2504i(131477);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(131477);
            return true;
        }
        AppMethodBeat.m2505o(131477);
        return false;
    }

    public static String getRealPath(String str) {
        AppMethodBeat.m2504i(131478);
        if (str == null) {
            AppMethodBeat.m2505o(131478);
            return null;
        } else if (str.startsWith("file://")) {
            str = str.replace("file://", "");
            AppMethodBeat.m2505o(131478);
            return str;
        } else if (str.startsWith("delayLoadFile://")) {
            str = str.replace("delayLoadFile://", "");
            AppMethodBeat.m2505o(131478);
            return str;
        } else {
            AppMethodBeat.m2505o(131478);
            return str;
        }
    }
}
