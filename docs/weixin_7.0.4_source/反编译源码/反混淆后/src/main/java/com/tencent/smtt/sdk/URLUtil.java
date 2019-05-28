package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class URLUtil {
    public static String composeSearchUrl(String str, String str2, String str3) {
        AppMethodBeat.m2504i(64650);
        C40978bv a = C40978bv.m71073a();
        String composeSearchUrl;
        if (a == null || !a.mo64921b()) {
            composeSearchUrl = android.webkit.URLUtil.composeSearchUrl(str, str2, str3);
            AppMethodBeat.m2505o(64650);
            return composeSearchUrl;
        }
        composeSearchUrl = a.mo64922c().mo57561a(str, str2, str3);
        AppMethodBeat.m2505o(64650);
        return composeSearchUrl;
    }

    public static byte[] decode(byte[] bArr) {
        AppMethodBeat.m2504i(64651);
        C40978bv a = C40978bv.m71073a();
        byte[] decode;
        if (a == null || !a.mo64921b()) {
            decode = android.webkit.URLUtil.decode(bArr);
            AppMethodBeat.m2505o(64651);
            return decode;
        }
        decode = a.mo64922c().mo57571a(bArr);
        AppMethodBeat.m2505o(64651);
        return decode;
    }

    public static final String guessFileName(String str, String str2, String str3) {
        AppMethodBeat.m2504i(64664);
        C40978bv a = C40978bv.m71073a();
        String guessFileName;
        if (a == null || !a.mo64921b()) {
            guessFileName = android.webkit.URLUtil.guessFileName(str, str2, str3);
            AppMethodBeat.m2505o(64664);
            return guessFileName;
        }
        guessFileName = a.mo64922c().mo57574b(str, str2, str3);
        AppMethodBeat.m2505o(64664);
        return guessFileName;
    }

    public static String guessUrl(String str) {
        AppMethodBeat.m2504i(64649);
        C40978bv a = C40978bv.m71073a();
        String guessUrl;
        if (a == null || !a.mo64921b()) {
            guessUrl = android.webkit.URLUtil.guessUrl(str);
            AppMethodBeat.m2505o(64649);
            return guessUrl;
        }
        guessUrl = a.mo64922c().mo57607m(str);
        AppMethodBeat.m2505o(64649);
        return guessUrl;
    }

    public static boolean isAboutUrl(String str) {
        AppMethodBeat.m2504i(64655);
        C40978bv a = C40978bv.m71073a();
        boolean isAboutUrl;
        if (a == null || !a.mo64921b()) {
            isAboutUrl = android.webkit.URLUtil.isAboutUrl(str);
            AppMethodBeat.m2505o(64655);
            return isAboutUrl;
        }
        isAboutUrl = a.mo64922c().mo57615q(str);
        AppMethodBeat.m2505o(64655);
        return isAboutUrl;
    }

    public static boolean isAssetUrl(String str) {
        AppMethodBeat.m2504i(64652);
        C40978bv a = C40978bv.m71073a();
        boolean isAssetUrl;
        if (a == null || !a.mo64921b()) {
            isAssetUrl = android.webkit.URLUtil.isAssetUrl(str);
            AppMethodBeat.m2505o(64652);
            return isAssetUrl;
        }
        isAssetUrl = a.mo64922c().mo57610n(str);
        AppMethodBeat.m2505o(64652);
        return isAssetUrl;
    }

    public static boolean isContentUrl(String str) {
        AppMethodBeat.m2504i(64661);
        C40978bv a = C40978bv.m71073a();
        boolean isContentUrl;
        if (a == null || !a.mo64921b()) {
            isContentUrl = android.webkit.URLUtil.isContentUrl(str);
            AppMethodBeat.m2505o(64661);
            return isContentUrl;
        }
        isContentUrl = a.mo64922c().mo57621w(str);
        AppMethodBeat.m2505o(64661);
        return isContentUrl;
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String str) {
        AppMethodBeat.m2504i(64653);
        C40978bv a = C40978bv.m71073a();
        boolean isCookielessProxyUrl;
        if (a == null || !a.mo64921b()) {
            isCookielessProxyUrl = android.webkit.URLUtil.isCookielessProxyUrl(str);
            AppMethodBeat.m2505o(64653);
            return isCookielessProxyUrl;
        }
        isCookielessProxyUrl = a.mo64922c().mo57612o(str);
        AppMethodBeat.m2505o(64653);
        return isCookielessProxyUrl;
    }

    public static boolean isDataUrl(String str) {
        AppMethodBeat.m2504i(64656);
        C40978bv a = C40978bv.m71073a();
        boolean isDataUrl;
        if (a == null || !a.mo64921b()) {
            isDataUrl = android.webkit.URLUtil.isDataUrl(str);
            AppMethodBeat.m2505o(64656);
            return isDataUrl;
        }
        isDataUrl = a.mo64922c().mo57616r(str);
        AppMethodBeat.m2505o(64656);
        return isDataUrl;
    }

    public static boolean isFileUrl(String str) {
        AppMethodBeat.m2504i(64654);
        C40978bv a = C40978bv.m71073a();
        boolean isFileUrl;
        if (a == null || !a.mo64921b()) {
            isFileUrl = android.webkit.URLUtil.isFileUrl(str);
            AppMethodBeat.m2505o(64654);
            return isFileUrl;
        }
        isFileUrl = a.mo64922c().mo57614p(str);
        AppMethodBeat.m2505o(64654);
        return isFileUrl;
    }

    public static boolean isHttpUrl(String str) {
        AppMethodBeat.m2504i(64658);
        C40978bv a = C40978bv.m71073a();
        boolean isHttpUrl;
        if (a == null || !a.mo64921b()) {
            isHttpUrl = android.webkit.URLUtil.isHttpUrl(str);
            AppMethodBeat.m2505o(64658);
            return isHttpUrl;
        }
        isHttpUrl = a.mo64922c().mo57618t(str);
        AppMethodBeat.m2505o(64658);
        return isHttpUrl;
    }

    public static boolean isHttpsUrl(String str) {
        AppMethodBeat.m2504i(64659);
        C40978bv a = C40978bv.m71073a();
        boolean isHttpsUrl;
        if (a == null || !a.mo64921b()) {
            isHttpsUrl = android.webkit.URLUtil.isHttpsUrl(str);
            AppMethodBeat.m2505o(64659);
            return isHttpsUrl;
        }
        isHttpsUrl = a.mo64922c().mo57619u(str);
        AppMethodBeat.m2505o(64659);
        return isHttpsUrl;
    }

    public static boolean isJavaScriptUrl(String str) {
        AppMethodBeat.m2504i(64657);
        C40978bv a = C40978bv.m71073a();
        boolean isJavaScriptUrl;
        if (a == null || !a.mo64921b()) {
            isJavaScriptUrl = android.webkit.URLUtil.isJavaScriptUrl(str);
            AppMethodBeat.m2505o(64657);
            return isJavaScriptUrl;
        }
        isJavaScriptUrl = a.mo64922c().mo57617s(str);
        AppMethodBeat.m2505o(64657);
        return isJavaScriptUrl;
    }

    public static boolean isNetworkUrl(String str) {
        AppMethodBeat.m2504i(64660);
        C40978bv a = C40978bv.m71073a();
        boolean isNetworkUrl;
        if (a == null || !a.mo64921b()) {
            isNetworkUrl = android.webkit.URLUtil.isNetworkUrl(str);
            AppMethodBeat.m2505o(64660);
            return isNetworkUrl;
        }
        isNetworkUrl = a.mo64922c().mo57620v(str);
        AppMethodBeat.m2505o(64660);
        return isNetworkUrl;
    }

    public static boolean isValidUrl(String str) {
        AppMethodBeat.m2504i(64662);
        C40978bv a = C40978bv.m71073a();
        boolean isValidUrl;
        if (a == null || !a.mo64921b()) {
            isValidUrl = android.webkit.URLUtil.isValidUrl(str);
            AppMethodBeat.m2505o(64662);
            return isValidUrl;
        }
        isValidUrl = a.mo64922c().mo57622x(str);
        AppMethodBeat.m2505o(64662);
        return isValidUrl;
    }

    public static String stripAnchor(String str) {
        AppMethodBeat.m2504i(64663);
        C40978bv a = C40978bv.m71073a();
        String stripAnchor;
        if (a == null || !a.mo64921b()) {
            stripAnchor = android.webkit.URLUtil.stripAnchor(str);
            AppMethodBeat.m2505o(64663);
            return stripAnchor;
        }
        stripAnchor = a.mo64922c().mo57623y(str);
        AppMethodBeat.m2505o(64663);
        return stripAnchor;
    }
}
