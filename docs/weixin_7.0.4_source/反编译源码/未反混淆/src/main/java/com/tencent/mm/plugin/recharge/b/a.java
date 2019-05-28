package com.tencent.mm.plugin.recharge.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.io.IOException;

public final class a implements v {
    private static final String kdH = (e.eSn + "wallet");
    private String url;

    public a(String str) {
        this.url = str;
    }

    public final String anJ() {
        AppMethodBeat.i(44418);
        if (bo.isNullOrNil(this.url)) {
            ab.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
            AppMethodBeat.o(44418);
            return null;
        }
        String format = String.format("%s/%s", new Object[]{kdH, g.x(this.url.getBytes())});
        AppMethodBeat.o(44418);
        return format;
    }

    public final String anK() {
        return this.url;
    }

    public final String anL() {
        return this.url;
    }

    public final String getCacheKey() {
        return this.url;
    }

    public final boolean anM() {
        return true;
    }

    public final boolean anN() {
        return false;
    }

    public final Bitmap anO() {
        return null;
    }

    public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.v.a aVar, String str) {
        AppMethodBeat.i(44419);
        if (com.tencent.mm.platformtools.v.a.NET == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, anJ(), false);
            } catch (IOException e) {
                try {
                    File file = new File(kdH);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    ab.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
                    d.a(bitmap, 100, CompressFormat.PNG, anJ(), false);
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e2, "", new Object[0]);
                    ab.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
                }
            }
        }
        ab.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", aVar.toString());
        AppMethodBeat.o(44419);
        return bitmap;
    }

    public final void anP() {
    }

    public final void V(String str, boolean z) {
    }

    public final void a(com.tencent.mm.platformtools.v.a aVar, String str) {
    }

    static {
        AppMethodBeat.i(44420);
        AppMethodBeat.o(44420);
    }

    public final b anI() {
        return null;
    }
}
