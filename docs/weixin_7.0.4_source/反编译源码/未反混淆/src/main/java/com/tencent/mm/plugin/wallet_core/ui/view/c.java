package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.io.IOException;

public final class c implements v {
    private b kBF = new b() {
        public final Bitmap vt(String str) {
            AppMethodBeat.i(47904);
            Bitmap decodeFile = d.decodeFile(str, null);
            AppMethodBeat.o(47904);
            return decodeFile;
        }
    };
    private String url;

    public c(String str) {
        AppMethodBeat.i(47905);
        this.url = str;
        AppMethodBeat.o(47905);
    }

    public final String anJ() {
        AppMethodBeat.i(47906);
        String UK = com.tencent.mm.plugin.wallet_core.d.b.UK(this.url);
        AppMethodBeat.o(47906);
        return UK;
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

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        AppMethodBeat.i(47907);
        if (a.NET == aVar) {
            if (bitmap == null || bitmap.getNinePatchChunk() == null) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, com.tencent.mm.plugin.wallet_core.d.b.UK(this.url), false);
                } catch (IOException e) {
                    try {
                        e.tf(com.tencent.mm.plugin.wallet_core.d.b.cRb());
                        ab.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
                        d.a(bitmap, 100, CompressFormat.PNG, com.tencent.mm.plugin.wallet_core.d.b.UK(this.url), false);
                    } catch (IOException e2) {
                        ab.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e2, "", new Object[0]);
                        ab.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
                    }
                }
            } else {
                ab.v("MicroMsg.WalletGetPicStrategy", " get the ninePathchChunk");
                e.y(str, com.tencent.mm.plugin.wallet_core.d.b.UK(this.url));
                AppMethodBeat.o(47907);
                return bitmap;
            }
        }
        ab.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", aVar.toString());
        AppMethodBeat.o(47907);
        return bitmap;
    }

    public final void anP() {
    }

    public final void V(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public final b anI() {
        return this.kBF;
    }
}
