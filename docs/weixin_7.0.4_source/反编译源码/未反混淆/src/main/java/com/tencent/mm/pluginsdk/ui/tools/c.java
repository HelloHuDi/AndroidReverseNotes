package com.tencent.mm.pluginsdk.ui.tools;

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
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class c implements v {
    private int height = 0;
    private String mii;
    private String url;
    private int width = 0;

    public c(String str, String str2) {
        this.mii = str;
        this.url = str2;
    }

    public final String anJ() {
        AppMethodBeat.i(79913);
        String str = com.tencent.mm.plugin.i.c.XW() + "/" + g.x(this.url.getBytes());
        AppMethodBeat.o(79913);
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
        AppMethodBeat.i(79914);
        Bitmap decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.akb);
        AppMethodBeat.o(79914);
        return decodeResource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060 A:{SYNTHETIC, Splitter:B:23:0x0060} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075 A:{SYNTHETIC, Splitter:B:30:0x0075} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        Throwable e;
        AppMethodBeat.i(79915);
        if (a.NET == aVar) {
            try {
                ab.v("MicroMsg.DefaultPicStrategy", "handlerBitmap get from net url:%s", this.url);
                if (this.width > 0 && this.height > 0) {
                    bitmap = d.b(bitmap, this.width, this.height, true);
                }
                File file = new File(anJ());
                file.createNewFile();
                FileOutputStream fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            ab.printErrStackTrace("MicroMsg.DefaultPicStrategy", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            AppMethodBeat.o(79915);
                            return bitmap;
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.o(79915);
                            throw e;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = null;
                    ab.printErrStackTrace("MicroMsg.DefaultPicStrategy", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.o(79915);
                    return bitmap;
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    AppMethodBeat.o(79915);
                    throw e;
                }
            } catch (IOException e4) {
                ab.printErrStackTrace("MicroMsg.DefaultPicStrategy", e4, "", new Object[0]);
            }
        }
        AppMethodBeat.o(79915);
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
