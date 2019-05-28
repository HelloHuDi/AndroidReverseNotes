package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.r.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public final class d {
    public static final d iDE = new d();

    static {
        AppMethodBeat.i(132728);
        AppMethodBeat.o(132728);
    }

    public static boolean cM(String str, String str2) {
        InputStream open;
        OutputStream outputStream = null;
        AppMethodBeat.i(132724);
        try {
            open = ah.getContext().getAssets().open(str2);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            ab.e("MicroMsg.WxaFTSSearchLogic", "file inputStream is null.");
            AppMethodBeat.o(132724);
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e2) {
            ab.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = open.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        e.p(open);
                        e.closeOutputStream(outputStream);
                        AppMethodBeat.o(132724);
                        return true;
                    }
                }
            } catch (IOException e3) {
                ab.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e3, "", new Object[0]);
                return false;
            } finally {
                e.p(open);
                e.closeOutputStream(outputStream);
                AppMethodBeat.o(132724);
            }
        } else {
            e.p(open);
            AppMethodBeat.o(132724);
            return false;
        }
    }

    public static String aLD() {
        AppMethodBeat.i(132725);
        String aLD = r.aLD();
        AppMethodBeat.o(132725);
        return aLD;
    }

    public static int aLE() {
        AppMethodBeat.i(132726);
        int aLE = r.aLE();
        AppMethodBeat.o(132726);
        return aLE;
    }

    public static Properties J(File file) {
        AppMethodBeat.i(132727);
        Properties J = r.J(file);
        AppMethodBeat.o(132727);
        return J;
    }
}
