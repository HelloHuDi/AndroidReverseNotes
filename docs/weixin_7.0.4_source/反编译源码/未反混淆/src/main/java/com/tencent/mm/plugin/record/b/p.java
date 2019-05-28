package com.tencent.mm.plugin.record.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

final class p implements v {
    private int height;
    private String mii;
    private String url;
    private int width;

    public p(String str, String str2, int i, int i2) {
        AppMethodBeat.i(24175);
        this.mii = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        File file = new File(stringBuilder.append(c.Yg()).append("web/").toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(24175);
    }

    public final String anJ() {
        AppMethodBeat.i(24176);
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        String stringBuilder2 = stringBuilder.append(c.Yg()).append("web/").append(g.x(this.url.getBytes())).toString();
        AppMethodBeat.o(24176);
        return stringBuilder2;
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
        AppMethodBeat.i(24177);
        Bitmap decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.akb);
        AppMethodBeat.o(24177);
        return decodeResource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0074 A:{SYNTHETIC, Splitter:B:30:0x0074} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f A:{SYNTHETIC, Splitter:B:23:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        Throwable e;
        AppMethodBeat.i(24178);
        if (a.NET == aVar) {
            try {
                ab.v("MicroMsg.FavGetPicStrategy", "handlerBitmap get from net url:%s", this.url);
                if (this.width > 0 && this.height > 0) {
                    bitmap = d.b(bitmap, this.width, this.height, true);
                }
                File file = new File(anJ());
                file.createNewFile();
                FileOutputStream fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            ab.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.o(24178);
                            return bitmap;
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.o(24178);
                            throw e;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = null;
                    ab.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    AppMethodBeat.o(24178);
                    return bitmap;
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    AppMethodBeat.o(24178);
                    throw e;
                }
            } catch (IOException e4) {
                ab.printErrStackTrace("MicroMsg.FavGetPicStrategy", e4, "", new Object[0]);
            }
        }
        AppMethodBeat.o(24178);
        return bitmap;
    }

    public final void anP() {
    }

    public final void V(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public final b anI() {
        return null;
    }
}
