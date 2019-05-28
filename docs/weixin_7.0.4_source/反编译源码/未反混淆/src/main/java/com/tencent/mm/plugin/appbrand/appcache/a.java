package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Closeable;
import java.util.Locale;

public abstract class a implements o {
    volatile String gSc;
    volatile String gSd;
    volatile String versionName;

    protected a() {
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
                i iVar = new i(com.tencent.luggage.g.i.convertStreamToString(closeable));
                str2 = iVar.getString("version");
                str3 = iVar.getString("updateTime");
                ab.i("MicroMsg.AppBrand.AbsReader", "AbsReader version parsed version = [%s] raw = [%s]", str2, str);
                str = str2;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrand.AbsReader", e, "get WAVersion.json failed.", new Object[0]);
                str = str2;
                if (str == null) {
                }
                this.versionName = str;
                this.gSc = str3;
                this.gSd = String.format(Locale.US, "%s (%s)", new Object[]{this.versionName, this.gSc});
                return this.versionName;
            } finally {
                bo.b(closeable);
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
