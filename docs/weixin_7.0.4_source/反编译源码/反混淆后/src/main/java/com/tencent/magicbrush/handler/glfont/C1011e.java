package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.magicbrush.C37414c;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

/* renamed from: com.tencent.magicbrush.handler.glfont.e */
public final class C1011e {
    HashMap<String, Typeface> bSV = new HashMap();
    public C45129b bSW;

    C1011e(C45129b c45129b) {
        AppMethodBeat.m2504i(115916);
        this.bSW = c45129b;
        AppMethodBeat.m2505o(115916);
    }

    /* renamed from: bV */
    static String m2280bV(String str) {
        Throwable th;
        AppMethodBeat.m2504i(115917);
        if (C37414c.isNullOrNil(str)) {
            AppMethodBeat.m2505o(115917);
            return null;
        }
        if (!(str.endsWith("ttf") || C37416a.m63046yF() == null)) {
            C37416a.m63046yF().mo33012fR(1);
        }
        C32201l c32201l = new C32201l();
        try {
            c32201l.bTQ.clear();
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    c32201l.mo52868b(randomAccessFile);
                    try {
                        randomAccessFile.close();
                    } catch (Exception e) {
                        C17837c.m27913a("TTFParser", e, "ttfparse error", new Object[0]);
                    }
                    String str2;
                    if (c32201l.bTQ.containsKey(Integer.valueOf(C32201l.bTL))) {
                        str2 = (String) c32201l.bTQ.get(Integer.valueOf(C32201l.bTL));
                        AppMethodBeat.m2505o(115917);
                        return str2;
                    } else if (c32201l.bTQ.containsKey(Integer.valueOf(C32201l.bTP))) {
                        str2 = (String) c32201l.bTQ.get(Integer.valueOf(C32201l.bTP));
                        AppMethodBeat.m2505o(115917);
                        return str2;
                    } else {
                        AppMethodBeat.m2505o(115917);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                        C17837c.m27913a("TTFParser", e2, "ttfparse error", new Object[0]);
                    }
                    AppMethodBeat.m2505o(115917);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                randomAccessFile.close();
                AppMethodBeat.m2505o(115917);
                throw th;
            }
        } catch (IOException e3) {
            C17837c.m27913a("MicroMsg.MBFont", e3, "ttf parse error,path:%s", str);
            AppMethodBeat.m2505o(115917);
            return null;
        }
    }
}
