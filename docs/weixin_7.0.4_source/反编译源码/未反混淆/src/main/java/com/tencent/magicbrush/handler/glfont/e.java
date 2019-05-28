package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.magicbrush.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public final class e {
    HashMap<String, Typeface> bSV = new HashMap();
    public b bSW;

    e(b bVar) {
        AppMethodBeat.i(115916);
        this.bSW = bVar;
        AppMethodBeat.o(115916);
    }

    static String bV(String str) {
        Throwable th;
        AppMethodBeat.i(115917);
        if (c.isNullOrNil(str)) {
            AppMethodBeat.o(115917);
            return null;
        }
        if (!(str.endsWith("ttf") || a.yF() == null)) {
            a.yF().fR(1);
        }
        l lVar = new l();
        try {
            lVar.bTQ.clear();
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    lVar.b(randomAccessFile);
                    try {
                        randomAccessFile.close();
                    } catch (Exception e) {
                        com.tencent.magicbrush.a.c.c.a("TTFParser", e, "ttfparse error", new Object[0]);
                    }
                    String str2;
                    if (lVar.bTQ.containsKey(Integer.valueOf(l.bTL))) {
                        str2 = (String) lVar.bTQ.get(Integer.valueOf(l.bTL));
                        AppMethodBeat.o(115917);
                        return str2;
                    } else if (lVar.bTQ.containsKey(Integer.valueOf(l.bTP))) {
                        str2 = (String) lVar.bTQ.get(Integer.valueOf(l.bTP));
                        AppMethodBeat.o(115917);
                        return str2;
                    } else {
                        AppMethodBeat.o(115917);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                        com.tencent.magicbrush.a.c.c.a("TTFParser", e2, "ttfparse error", new Object[0]);
                    }
                    AppMethodBeat.o(115917);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                randomAccessFile.close();
                AppMethodBeat.o(115917);
                throw th;
            }
        } catch (IOException e3) {
            com.tencent.magicbrush.a.c.c.a("MicroMsg.MBFont", e3, "ttf parse error,path:%s", str);
            AppMethodBeat.o(115917);
            return null;
        }
    }
}
