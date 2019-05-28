package com.tencent.p177mm.plugin.appbrand.p1231o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.appbrand.p328r.C27278r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/* renamed from: com.tencent.mm.plugin.appbrand.o.d */
public final class C45661d {
    public static final C45661d iDE = new C45661d();

    static {
        AppMethodBeat.m2504i(132728);
        AppMethodBeat.m2505o(132728);
    }

    /* renamed from: cM */
    public static boolean m84315cM(String str, String str2) {
        InputStream open;
        OutputStream outputStream = null;
        AppMethodBeat.m2504i(132724);
        try {
            open = C4996ah.getContext().getAssets().open(str2);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            C4990ab.m7412e("MicroMsg.WxaFTSSearchLogic", "file inputStream is null.");
            AppMethodBeat.m2505o(132724);
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
            C4990ab.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = open.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        C1173e.m2573p(open);
                        C1173e.closeOutputStream(outputStream);
                        AppMethodBeat.m2505o(132724);
                        return true;
                    }
                }
            } catch (IOException e3) {
                C4990ab.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e3, "", new Object[0]);
                return false;
            } finally {
                C1173e.m2573p(open);
                C1173e.closeOutputStream(outputStream);
                AppMethodBeat.m2505o(132724);
            }
        } else {
            C1173e.m2573p(open);
            AppMethodBeat.m2505o(132724);
            return false;
        }
    }

    public static String aLD() {
        AppMethodBeat.m2504i(132725);
        String aLD = C27278r.aLD();
        AppMethodBeat.m2505o(132725);
        return aLD;
    }

    public static int aLE() {
        AppMethodBeat.m2504i(132726);
        int aLE = C27278r.aLE();
        AppMethodBeat.m2505o(132726);
        return aLE;
    }

    /* renamed from: J */
    public static Properties m84314J(File file) {
        AppMethodBeat.m2504i(132727);
        Properties J = C27278r.m43307J(file);
        AppMethodBeat.m2505o(132727);
        return J;
    }
}
