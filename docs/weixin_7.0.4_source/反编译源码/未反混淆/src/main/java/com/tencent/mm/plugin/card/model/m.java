package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.io.IOException;

public final class m implements v {
    public static final String kdH = (e.eSn + "card");
    public static final String kdI = (kdH + File.separator + "video");
    private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
    private String mPicUrl = null;

    static {
        AppMethodBeat.i(87853);
        AppMethodBeat.o(87853);
    }

    public m(String str) {
        this.mPicUrl = str;
    }

    public final b anI() {
        return null;
    }

    public final String anJ() {
        AppMethodBeat.i(87849);
        String format = String.format("%s/%s", new Object[]{kdH, g.x(this.mPicUrl.getBytes())});
        AppMethodBeat.o(87849);
        return format;
    }

    public static String Gz(String str) {
        AppMethodBeat.i(87850);
        String format = String.format("%s/%s", new Object[]{kdH, g.x(str.getBytes())});
        AppMethodBeat.o(87850);
        return format;
    }

    public final String anK() {
        return this.mPicUrl;
    }

    public final String anL() {
        return this.mPicUrl;
    }

    public final String getCacheKey() {
        return this.mPicUrl;
    }

    public final boolean anM() {
        return true;
    }

    public final boolean anN() {
        return false;
    }

    public final Bitmap anO() {
        AppMethodBeat.i(87851);
        ab.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
        AppMethodBeat.o(87851);
        return null;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        AppMethodBeat.i(87852);
        if (a.NET == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, anJ(), false);
            } catch (IOException e) {
                try {
                    File file = new File(anJ());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    ab.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
                    d.a(bitmap, 100, CompressFormat.PNG, anJ(), false);
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.CardSimpleGetPicStrategy", e2, "", new Object[0]);
                    ab.w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
                }
            }
        }
        ab.d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", aVar.toString());
        AppMethodBeat.o(87852);
        return bitmap;
    }

    public final void anP() {
    }

    public final void V(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }
}
