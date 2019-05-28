package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public final class w {
    public static String a(ao aoVar, String str) {
        String str2 = null;
        AppMethodBeat.i(86801);
        if (aoVar == null || bo.isNullOrNil(str)) {
            AppMethodBeat.o(86801);
        } else {
            aoVar.avW();
            InputStream xy = aoVar.xy(str);
            if (xy == null) {
                AppMethodBeat.o(86801);
            } else {
                try {
                    xy.mark(xy.available());
                    String b = g.b(xy, 4096);
                    xy.reset();
                    File file = new File(aoVar.gUc.getAbsolutePath() + "_xdir/" + str);
                    File parentFile = file.getParentFile();
                    if (parentFile.exists() && parentFile.isFile()) {
                        parentFile.delete();
                    }
                    parentFile.mkdirs();
                    if (!b.equals(g.v(file))) {
                        if (file.isDirectory()) {
                            Runtime.getRuntime().exec("rm -r " + file.getAbsolutePath());
                        } else {
                            file.delete();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        e.copyStream(xy, fileOutputStream);
                        bo.b(fileOutputStream);
                    }
                    str2 = file.getAbsolutePath();
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.PkgPartialCopy", e, "copy failed", new Object[0]);
                } finally {
                    bo.b(xy);
                    AppMethodBeat.o(86801);
                }
            }
        }
        return str2;
    }
}
