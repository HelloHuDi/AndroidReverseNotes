package com.tencent.mm.plugin.collect.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

public final class c implements v {
    private b kBF = new b() {
        public final Bitmap vt(String str) {
            AppMethodBeat.i(40922);
            Bitmap decodeFile = d.decodeFile(str, null);
            AppMethodBeat.o(40922);
            return decodeFile;
        }
    };
    private String url;

    public c(String str) {
        AppMethodBeat.i(40923);
        this.url = str;
        AppMethodBeat.o(40923);
    }

    public final String anJ() {
        AppMethodBeat.i(40924);
        String UK = com.tencent.mm.plugin.wallet_core.d.b.UK(this.url);
        AppMethodBeat.o(40924);
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
        AppMethodBeat.i(40925);
        if (a.NET == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, com.tencent.mm.plugin.wallet_core.d.b.UK(this.url), false);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(40925);
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
