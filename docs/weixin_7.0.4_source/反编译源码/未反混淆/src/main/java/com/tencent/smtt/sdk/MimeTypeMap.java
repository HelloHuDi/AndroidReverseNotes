package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MimeTypeMap {
    private static MimeTypeMap a;

    private MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String str) {
        AppMethodBeat.i(63976);
        bv a = bv.a();
        String fileExtensionFromUrl;
        if (a == null || !a.b()) {
            fileExtensionFromUrl = android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
            AppMethodBeat.o(63976);
            return fileExtensionFromUrl;
        }
        fileExtensionFromUrl = a.c().h(str);
        AppMethodBeat.o(63976);
        return fileExtensionFromUrl;
    }

    public static synchronized MimeTypeMap getSingleton() {
        MimeTypeMap mimeTypeMap;
        synchronized (MimeTypeMap.class) {
            AppMethodBeat.i(63981);
            if (a == null) {
                a = new MimeTypeMap();
            }
            mimeTypeMap = a;
            AppMethodBeat.o(63981);
        }
        return mimeTypeMap;
    }

    public String getExtensionFromMimeType(String str) {
        AppMethodBeat.i(63980);
        bv a = bv.a();
        String extensionFromMimeType;
        if (a == null || !a.b()) {
            extensionFromMimeType = android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
            AppMethodBeat.o(63980);
            return extensionFromMimeType;
        }
        extensionFromMimeType = a.c().l(str);
        AppMethodBeat.o(63980);
        return extensionFromMimeType;
    }

    public String getMimeTypeFromExtension(String str) {
        AppMethodBeat.i(63978);
        bv a = bv.a();
        String mimeTypeFromExtension;
        if (a == null || !a.b()) {
            mimeTypeFromExtension = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
            AppMethodBeat.o(63978);
            return mimeTypeFromExtension;
        }
        mimeTypeFromExtension = a.c().j(str);
        AppMethodBeat.o(63978);
        return mimeTypeFromExtension;
    }

    public boolean hasExtension(String str) {
        AppMethodBeat.i(63979);
        bv a = bv.a();
        boolean hasExtension;
        if (a == null || !a.b()) {
            hasExtension = android.webkit.MimeTypeMap.getSingleton().hasExtension(str);
            AppMethodBeat.o(63979);
            return hasExtension;
        }
        hasExtension = a.c().k(str);
        AppMethodBeat.o(63979);
        return hasExtension;
    }

    public boolean hasMimeType(String str) {
        AppMethodBeat.i(63977);
        bv a = bv.a();
        boolean hasMimeType;
        if (a == null || !a.b()) {
            hasMimeType = android.webkit.MimeTypeMap.getSingleton().hasMimeType(str);
            AppMethodBeat.o(63977);
            return hasMimeType;
        }
        hasMimeType = a.c().i(str);
        AppMethodBeat.o(63977);
        return hasMimeType;
    }
}
