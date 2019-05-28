package com.tencent.p177mm.plugin.appbrand.luggage.p908b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.bridge.impl.p1588a.C41702a;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37924e;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.luggage.p1227a.C27184a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19163a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19164c;
import com.tencent.p177mm.plugin.appbrand.p1219d.C33139b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.j */
public final class C19594j extends C41702a implements C33139b {
    private final C6750i gPI;

    public C19594j(C6750i c6750i) {
        this.gPI = c6750i;
    }

    /* renamed from: wP */
    public final String mo22122wP() {
        return "WxFileImageReader";
    }

    public final boolean match(String str) {
        AppMethodBeat.m2504i(86988);
        if (str == null || !str.startsWith("wxfile://")) {
            AppMethodBeat.m2505o(86988);
            return false;
        }
        AppMethodBeat.m2505o(86988);
        return true;
    }

    /* renamed from: b */
    public final Bitmap mo22119b(String str, Rect rect, C19164c c19164c) {
        C37924e c37924e = null;
        AppMethodBeat.m2504i(86989);
        if (match(str)) {
            C19092p asE = this.gPI.asE();
            if (asE == null) {
                AppMethodBeat.m2505o(86989);
                return null;
            }
            File yg = asE.mo34314yg(str.substring(0, str.lastIndexOf("?appId=")));
            if (yg == null || !yg.exists()) {
                AppMethodBeat.m2505o(86989);
                return null;
            }
            String absolutePath = yg.getAbsolutePath();
            if (!absolutePath.startsWith("file://")) {
                absolutePath = "file://".concat(String.valueOf(absolutePath));
            }
            if (rect != null) {
                c37924e = new C27184a(rect.left, rect.top, rect.width(), rect.height());
            }
            Bitmap a = C37926b.abR().mo60681a(absolutePath, c37924e);
            AppMethodBeat.m2505o(86989);
            return a;
        }
        AppMethodBeat.m2505o(86989);
        return null;
    }

    /* renamed from: a */
    public final boolean mo22118a(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(86990);
        if (c2241c == null || str == null || str.length() == 0) {
            AppMethodBeat.m2505o(86990);
            return false;
        }
        boolean startsWith = str.startsWith("wxfile://");
        AppMethodBeat.m2505o(86990);
        return startsWith;
    }

    /* renamed from: b */
    public final String mo22120b(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(86991);
        if (mo22118a(c2241c, str)) {
            str = str + "?appId=" + c2241c.getAppId();
            AppMethodBeat.m2505o(86991);
            return str;
        }
        AppMethodBeat.m2505o(86991);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo22117a(String str, C19163a c19163a) {
        byte[] bArr;
        Throwable th;
        Closeable closeable;
        AppMethodBeat.m2504i(86992);
        byte[] bArr2 = new byte[0];
        if (match(str)) {
            C19092p asE = this.gPI.asE();
            if (asE != null) {
                File yg = asE.mo34314yg(str.substring(0, str.lastIndexOf("?appId=")));
                if (yg != null && yg.exists()) {
                    String absolutePath = yg.getAbsolutePath();
                    if (!absolutePath.startsWith("file://")) {
                        absolutePath = "file://".concat(String.valueOf(absolutePath));
                    }
                    Closeable openRead;
                    try {
                        openRead = C5730e.openRead(absolutePath);
                        try {
                            byte[] k = C32192i.m52510k(openRead);
                            C32192i.m52507b(openRead);
                            bArr = k;
                        } catch (FileNotFoundException e) {
                            try {
                                C45124d.m82924c("Luggage.WxFileImageReader", "", new Object[0]);
                                C32192i.m52507b(openRead);
                                bArr = bArr2;
                                if (c19163a != null) {
                                }
                                AppMethodBeat.m2505o(86992);
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = openRead;
                                C32192i.m52507b(closeable);
                                AppMethodBeat.m2505o(86992);
                                throw th;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        openRead = null;
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = null;
                        C32192i.m52507b(closeable);
                        AppMethodBeat.m2505o(86992);
                        throw th;
                    }
                    if (c19163a != null) {
                        c19163a.mo34404Q(bArr);
                    }
                    AppMethodBeat.m2505o(86992);
                }
            }
        }
        bArr = bArr2;
        if (c19163a != null) {
        }
        AppMethodBeat.m2505o(86992);
    }
}
