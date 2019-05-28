package com.tencent.p177mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.plugin.appbrand.appstorage.C31282o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.Closeable;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.a */
public abstract class C45510a implements C31282o {
    volatile String gSc;
    volatile String gSd;
    volatile String versionName;

    protected C45510a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String avk() {
        if (TextUtils.isEmpty(this.versionName)) {
            String str;
            String str2 = "";
            String str3 = "";
            Closeable closeable = null;
            try {
                closeable = openRead("WAVersion.json");
                C41726i c41726i = new C41726i(C32192i.convertStreamToString(closeable));
                str2 = c41726i.getString("version");
                str3 = c41726i.getString("updateTime");
                C4990ab.m7417i("MicroMsg.AppBrand.AbsReader", "AbsReader version parsed version = [%s] raw = [%s]", str2, str);
                str = str2;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.AbsReader", e, "get WAVersion.json failed.", new Object[0]);
                str = str2;
                if (str == null) {
                }
                this.versionName = str;
                this.gSc = str3;
                this.gSd = String.format(Locale.US, "%s (%s)", new Object[]{this.versionName, this.gSc});
                return this.versionName;
            } finally {
                C5046bo.m7527b(closeable);
            }
            if (str == null) {
                str = "";
            }
            this.versionName = str;
            this.gSc = str3;
            this.gSd = String.format(Locale.US, "%s (%s)", new Object[]{this.versionName, this.gSc});
        }
        return this.versionName;
    }

    public final String avl() {
        return this.gSd;
    }
}
