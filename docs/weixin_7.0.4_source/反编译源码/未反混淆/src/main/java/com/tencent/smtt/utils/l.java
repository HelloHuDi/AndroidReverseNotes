package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.k.b;
import java.io.InputStream;
import java.util.zip.ZipEntry;

final class l implements b {
    final /* synthetic */ String a;

    l(String str) {
        this.a = str;
    }

    public final boolean a(InputStream inputStream, ZipEntry zipEntry, String str) {
        AppMethodBeat.i(65219);
        try {
            boolean a = k.a(inputStream, zipEntry, this.a, str);
            AppMethodBeat.o(65219);
            return a;
        } catch (Exception e) {
            Exception exception = new Exception("copyFileIfChanged Exception", e);
            AppMethodBeat.o(65219);
            throw exception;
        }
    }
}
