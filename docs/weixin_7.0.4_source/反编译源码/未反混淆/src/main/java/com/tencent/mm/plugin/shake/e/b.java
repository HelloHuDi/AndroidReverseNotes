package com.tencent.mm.plugin.shake.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

public final class b implements v {
    private a qwR = null;
    private String thumburl = "";

    public b(a aVar) {
        this.qwR = aVar;
    }

    public b(String str) {
        this.thumburl = str;
    }

    public final String anJ() {
        AppMethodBeat.i(24948);
        String fQ;
        if (this.qwR != null && this.qwR.field_thumburl != null) {
            fQ = m.fQ(this.qwR.field_thumburl, "@S");
            AppMethodBeat.o(24948);
            return fQ;
        } else if (this.thumburl != null) {
            fQ = m.fQ(this.thumburl, "@S");
            AppMethodBeat.o(24948);
            return fQ;
        } else {
            fQ = "";
            AppMethodBeat.o(24948);
            return fQ;
        }
    }

    public final String anK() {
        if (this.qwR == null || this.qwR.field_thumburl == null) {
            return this.thumburl;
        }
        return this.qwR.field_thumburl;
    }

    public final String anL() {
        AppMethodBeat.i(24949);
        String str = anK() + "_tv";
        AppMethodBeat.o(24949);
        return str;
    }

    public final String getCacheKey() {
        AppMethodBeat.i(24950);
        String str = anK() + "_tv";
        AppMethodBeat.o(24950);
        return str;
    }

    public final boolean anM() {
        return false;
    }

    public final boolean anN() {
        return false;
    }

    public final Bitmap a(Bitmap bitmap, v.a aVar, String str) {
        AppMethodBeat.i(24951);
        if (v.a.NET == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, anJ(), false);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.TVImgGetStrategy", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(24951);
        return bitmap;
    }

    public final void anP() {
    }

    public final void V(String str, boolean z) {
    }

    public final void a(v.a aVar, String str) {
    }

    public final Bitmap anO() {
        AppMethodBeat.i(24952);
        if (ah.getContext() == null) {
            AppMethodBeat.o(24952);
            return null;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
        AppMethodBeat.o(24952);
        return decodeResource;
    }

    public final com.tencent.mm.platformtools.v.b anI() {
        return null;
    }
}
