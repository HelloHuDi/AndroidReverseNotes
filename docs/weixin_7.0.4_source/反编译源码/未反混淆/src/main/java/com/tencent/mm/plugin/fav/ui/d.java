package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.f;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class d implements v {
    private int height;
    private String mii;
    private String url;
    private int width;

    public d(String str, String str2, int i, int i2) {
        this.mii = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
    }

    public final b anI() {
        return null;
    }

    public final String anJ() {
        AppMethodBeat.i(73997);
        String str = com.tencent.mm.plugin.fav.a.b.bue() + g.x(this.url.getBytes());
        AppMethodBeat.o(73997);
        return str;
    }

    public final String anK() {
        return this.url;
    }

    public final String anL() {
        return this.mii;
    }

    public final String getCacheKey() {
        return this.mii;
    }

    public final boolean anM() {
        return true;
    }

    public final boolean anN() {
        return false;
    }

    public final Bitmap anO() {
        AppMethodBeat.i(73998);
        Bitmap decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.akb);
        AppMethodBeat.o(73998);
        return decodeResource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072 A:{SYNTHETIC, Splitter:B:26:0x0072} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087 A:{SYNTHETIC, Splitter:B:33:0x0087} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        Throwable e;
        AppMethodBeat.i(73999);
        if (a.NET == aVar) {
            try {
                ab.v("MicroMsg.FavGetPicStrategy", "handlerBitmap get from net url:%s", this.url);
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bue());
                if (!bVar.exists()) {
                    bVar.mkdirs();
                }
                if (this.width > 0 && this.height > 0) {
                    bitmap = com.tencent.mm.sdk.platformtools.d.b(bitmap, this.width, this.height, true);
                }
                com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(anJ());
                bVar2.createNewFile();
                f fVar;
                try {
                    fVar = new f(bVar2);
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, fVar);
                        fVar.flush();
                        fVar.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            ab.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                            if (fVar != null) {
                                fVar.close();
                            }
                            AppMethodBeat.o(73999);
                            return bitmap;
                        } catch (Throwable th) {
                            e = th;
                            if (fVar != null) {
                                fVar.close();
                            }
                            AppMethodBeat.o(73999);
                            throw e;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fVar = null;
                    ab.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                    if (fVar != null) {
                    }
                    AppMethodBeat.o(73999);
                    return bitmap;
                } catch (Throwable th2) {
                    e = th2;
                    fVar = null;
                    if (fVar != null) {
                    }
                    AppMethodBeat.o(73999);
                    throw e;
                }
            } catch (IOException e4) {
                ab.printErrStackTrace("MicroMsg.FavGetPicStrategy", e4, "", new Object[0]);
            }
        }
        AppMethodBeat.o(73999);
        return bitmap;
    }

    public final void anP() {
    }

    public final void V(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }
}
