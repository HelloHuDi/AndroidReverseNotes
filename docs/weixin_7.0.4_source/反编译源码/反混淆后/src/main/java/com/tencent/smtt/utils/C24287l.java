package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.C30950k.C16158b;
import java.io.InputStream;
import java.util.zip.ZipEntry;

/* renamed from: com.tencent.smtt.utils.l */
final class C24287l implements C16158b {
    /* renamed from: a */
    final /* synthetic */ String f4580a;

    C24287l(String str) {
        this.f4580a = str;
    }

    /* renamed from: a */
    public final boolean mo28983a(InputStream inputStream, ZipEntry zipEntry, String str) {
        AppMethodBeat.m2504i(65219);
        try {
            boolean a = C30950k.m49558a(inputStream, zipEntry, this.f4580a, str);
            AppMethodBeat.m2505o(65219);
            return a;
        } catch (Exception e) {
            Exception exception = new Exception("copyFileIfChanged Exception", e);
            AppMethodBeat.m2505o(65219);
            throw exception;
        }
    }
}
