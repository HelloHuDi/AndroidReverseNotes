package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

public final class q implements v {
    private String mPicUrl = null;

    public q(String str) {
        this.mPicUrl = str;
    }

    public final String anJ() {
        AppMethodBeat.i(81490);
        String fQ = e.cgy().fQ(this.mPicUrl, "@S");
        AppMethodBeat.o(81490);
        return fQ;
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
        return false;
    }

    public final boolean anN() {
        return false;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        AppMethodBeat.i(81491);
        if (a.NET == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, anJ(), false);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.ScannerGetPicStrategy", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(81491);
        return bitmap;
    }

    public final void anP() {
    }

    public final void V(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public final Bitmap anO() {
        AppMethodBeat.i(81492);
        if (ah.getContext() == null) {
            AppMethodBeat.o(81492);
            return null;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
        AppMethodBeat.o(81492);
        return decodeResource;
    }

    public final b anI() {
        return null;
    }
}
