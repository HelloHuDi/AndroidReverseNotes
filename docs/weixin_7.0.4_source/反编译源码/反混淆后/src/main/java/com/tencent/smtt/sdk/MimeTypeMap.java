package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MimeTypeMap {
    /* renamed from: a */
    private static MimeTypeMap f17282a;

    private MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String str) {
        AppMethodBeat.m2504i(63976);
        C40978bv a = C40978bv.m71073a();
        String fileExtensionFromUrl;
        if (a == null || !a.mo64921b()) {
            fileExtensionFromUrl = android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
            AppMethodBeat.m2505o(63976);
            return fileExtensionFromUrl;
        }
        fileExtensionFromUrl = a.mo64922c().mo57596h(str);
        AppMethodBeat.m2505o(63976);
        return fileExtensionFromUrl;
    }

    public static synchronized MimeTypeMap getSingleton() {
        MimeTypeMap mimeTypeMap;
        synchronized (MimeTypeMap.class) {
            AppMethodBeat.m2504i(63981);
            if (f17282a == null) {
                f17282a = new MimeTypeMap();
            }
            mimeTypeMap = f17282a;
            AppMethodBeat.m2505o(63981);
        }
        return mimeTypeMap;
    }

    public String getExtensionFromMimeType(String str) {
        AppMethodBeat.m2504i(63980);
        C40978bv a = C40978bv.m71073a();
        String extensionFromMimeType;
        if (a == null || !a.mo64921b()) {
            extensionFromMimeType = android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
            AppMethodBeat.m2505o(63980);
            return extensionFromMimeType;
        }
        extensionFromMimeType = a.mo64922c().mo57605l(str);
        AppMethodBeat.m2505o(63980);
        return extensionFromMimeType;
    }

    public String getMimeTypeFromExtension(String str) {
        AppMethodBeat.m2504i(63978);
        C40978bv a = C40978bv.m71073a();
        String mimeTypeFromExtension;
        if (a == null || !a.mo64921b()) {
            mimeTypeFromExtension = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
            AppMethodBeat.m2505o(63978);
            return mimeTypeFromExtension;
        }
        mimeTypeFromExtension = a.mo64922c().mo57602j(str);
        AppMethodBeat.m2505o(63978);
        return mimeTypeFromExtension;
    }

    public boolean hasExtension(String str) {
        AppMethodBeat.m2504i(63979);
        C40978bv a = C40978bv.m71073a();
        boolean hasExtension;
        if (a == null || !a.mo64921b()) {
            hasExtension = android.webkit.MimeTypeMap.getSingleton().hasExtension(str);
            AppMethodBeat.m2505o(63979);
            return hasExtension;
        }
        hasExtension = a.mo64922c().mo57604k(str);
        AppMethodBeat.m2505o(63979);
        return hasExtension;
    }

    public boolean hasMimeType(String str) {
        AppMethodBeat.m2504i(63977);
        C40978bv a = C40978bv.m71073a();
        boolean hasMimeType;
        if (a == null || !a.mo64921b()) {
            hasMimeType = android.webkit.MimeTypeMap.getSingleton().hasMimeType(str);
            AppMethodBeat.m2505o(63977);
            return hasMimeType;
        }
        hasMimeType = a.mo64922c().mo57600i(str);
        AppMethodBeat.m2505o(63977);
        return hasMimeType;
    }
}
