package com.tencent.mm.plugin.game.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.io.IOException;

public final class ai implements v {
    protected String mPicUrl;

    public ai(String str) {
        AppMethodBeat.i(111409);
        this.mPicUrl = str;
        File file = new File(e.euT);
        if (!file.exists()) {
            file.mkdir();
        }
        AppMethodBeat.o(111409);
    }

    public final b anI() {
        return null;
    }

    public final String anJ() {
        AppMethodBeat.i(111410);
        String str = e.euT + g.x(this.mPicUrl.getBytes());
        AppMethodBeat.o(111410);
        return str;
    }

    public final String anK() {
        return this.mPicUrl;
    }

    public final String anL() {
        AppMethodBeat.i(111411);
        String str = this.mPicUrl.hashCode();
        AppMethodBeat.o(111411);
        return str;
    }

    public final String getCacheKey() {
        AppMethodBeat.i(111412);
        String str = this.mPicUrl.hashCode();
        AppMethodBeat.o(111412);
        return str;
    }

    public final boolean anM() {
        return true;
    }

    public final boolean anN() {
        return false;
    }

    public final Bitmap anO() {
        AppMethodBeat.i(111413);
        Bitmap decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
        AppMethodBeat.o(111413);
        return decodeResource;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        AppMethodBeat.i(111414);
        if (a.DISK == aVar) {
            AppMethodBeat.o(111414);
        } else {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, anJ(), false);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.GetGamePicStrategy", e, "", new Object[0]);
            }
            AppMethodBeat.o(111414);
        }
        return bitmap;
    }

    public final void anP() {
    }

    public final void V(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }
}
