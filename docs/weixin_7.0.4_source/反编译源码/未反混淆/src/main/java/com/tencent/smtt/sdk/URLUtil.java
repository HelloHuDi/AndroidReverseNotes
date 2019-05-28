package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class URLUtil {
    public static String composeSearchUrl(String str, String str2, String str3) {
        AppMethodBeat.i(64650);
        bv a = bv.a();
        String composeSearchUrl;
        if (a == null || !a.b()) {
            composeSearchUrl = android.webkit.URLUtil.composeSearchUrl(str, str2, str3);
            AppMethodBeat.o(64650);
            return composeSearchUrl;
        }
        composeSearchUrl = a.c().a(str, str2, str3);
        AppMethodBeat.o(64650);
        return composeSearchUrl;
    }

    public static byte[] decode(byte[] bArr) {
        AppMethodBeat.i(64651);
        bv a = bv.a();
        byte[] decode;
        if (a == null || !a.b()) {
            decode = android.webkit.URLUtil.decode(bArr);
            AppMethodBeat.o(64651);
            return decode;
        }
        decode = a.c().a(bArr);
        AppMethodBeat.o(64651);
        return decode;
    }

    public static final String guessFileName(String str, String str2, String str3) {
        AppMethodBeat.i(64664);
        bv a = bv.a();
        String guessFileName;
        if (a == null || !a.b()) {
            guessFileName = android.webkit.URLUtil.guessFileName(str, str2, str3);
            AppMethodBeat.o(64664);
            return guessFileName;
        }
        guessFileName = a.c().b(str, str2, str3);
        AppMethodBeat.o(64664);
        return guessFileName;
    }

    public static String guessUrl(String str) {
        AppMethodBeat.i(64649);
        bv a = bv.a();
        String guessUrl;
        if (a == null || !a.b()) {
            guessUrl = android.webkit.URLUtil.guessUrl(str);
            AppMethodBeat.o(64649);
            return guessUrl;
        }
        guessUrl = a.c().m(str);
        AppMethodBeat.o(64649);
        return guessUrl;
    }

    public static boolean isAboutUrl(String str) {
        AppMethodBeat.i(64655);
        bv a = bv.a();
        boolean isAboutUrl;
        if (a == null || !a.b()) {
            isAboutUrl = android.webkit.URLUtil.isAboutUrl(str);
            AppMethodBeat.o(64655);
            return isAboutUrl;
        }
        isAboutUrl = a.c().q(str);
        AppMethodBeat.o(64655);
        return isAboutUrl;
    }

    public static boolean isAssetUrl(String str) {
        AppMethodBeat.i(64652);
        bv a = bv.a();
        boolean isAssetUrl;
        if (a == null || !a.b()) {
            isAssetUrl = android.webkit.URLUtil.isAssetUrl(str);
            AppMethodBeat.o(64652);
            return isAssetUrl;
        }
        isAssetUrl = a.c().n(str);
        AppMethodBeat.o(64652);
        return isAssetUrl;
    }

    public static boolean isContentUrl(String str) {
        AppMethodBeat.i(64661);
        bv a = bv.a();
        boolean isContentUrl;
        if (a == null || !a.b()) {
            isContentUrl = android.webkit.URLUtil.isContentUrl(str);
            AppMethodBeat.o(64661);
            return isContentUrl;
        }
        isContentUrl = a.c().w(str);
        AppMethodBeat.o(64661);
        return isContentUrl;
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String str) {
        AppMethodBeat.i(64653);
        bv a = bv.a();
        boolean isCookielessProxyUrl;
        if (a == null || !a.b()) {
            isCookielessProxyUrl = android.webkit.URLUtil.isCookielessProxyUrl(str);
            AppMethodBeat.o(64653);
            return isCookielessProxyUrl;
        }
        isCookielessProxyUrl = a.c().o(str);
        AppMethodBeat.o(64653);
        return isCookielessProxyUrl;
    }

    public static boolean isDataUrl(String str) {
        AppMethodBeat.i(64656);
        bv a = bv.a();
        boolean isDataUrl;
        if (a == null || !a.b()) {
            isDataUrl = android.webkit.URLUtil.isDataUrl(str);
            AppMethodBeat.o(64656);
            return isDataUrl;
        }
        isDataUrl = a.c().r(str);
        AppMethodBeat.o(64656);
        return isDataUrl;
    }

    public static boolean isFileUrl(String str) {
        AppMethodBeat.i(64654);
        bv a = bv.a();
        boolean isFileUrl;
        if (a == null || !a.b()) {
            isFileUrl = android.webkit.URLUtil.isFileUrl(str);
            AppMethodBeat.o(64654);
            return isFileUrl;
        }
        isFileUrl = a.c().p(str);
        AppMethodBeat.o(64654);
        return isFileUrl;
    }

    public static boolean isHttpUrl(String str) {
        AppMethodBeat.i(64658);
        bv a = bv.a();
        boolean isHttpUrl;
        if (a == null || !a.b()) {
            isHttpUrl = android.webkit.URLUtil.isHttpUrl(str);
            AppMethodBeat.o(64658);
            return isHttpUrl;
        }
        isHttpUrl = a.c().t(str);
        AppMethodBeat.o(64658);
        return isHttpUrl;
    }

    public static boolean isHttpsUrl(String str) {
        AppMethodBeat.i(64659);
        bv a = bv.a();
        boolean isHttpsUrl;
        if (a == null || !a.b()) {
            isHttpsUrl = android.webkit.URLUtil.isHttpsUrl(str);
            AppMethodBeat.o(64659);
            return isHttpsUrl;
        }
        isHttpsUrl = a.c().u(str);
        AppMethodBeat.o(64659);
        return isHttpsUrl;
    }

    public static boolean isJavaScriptUrl(String str) {
        AppMethodBeat.i(64657);
        bv a = bv.a();
        boolean isJavaScriptUrl;
        if (a == null || !a.b()) {
            isJavaScriptUrl = android.webkit.URLUtil.isJavaScriptUrl(str);
            AppMethodBeat.o(64657);
            return isJavaScriptUrl;
        }
        isJavaScriptUrl = a.c().s(str);
        AppMethodBeat.o(64657);
        return isJavaScriptUrl;
    }

    public static boolean isNetworkUrl(String str) {
        AppMethodBeat.i(64660);
        bv a = bv.a();
        boolean isNetworkUrl;
        if (a == null || !a.b()) {
            isNetworkUrl = android.webkit.URLUtil.isNetworkUrl(str);
            AppMethodBeat.o(64660);
            return isNetworkUrl;
        }
        isNetworkUrl = a.c().v(str);
        AppMethodBeat.o(64660);
        return isNetworkUrl;
    }

    public static boolean isValidUrl(String str) {
        AppMethodBeat.i(64662);
        bv a = bv.a();
        boolean isValidUrl;
        if (a == null || !a.b()) {
            isValidUrl = android.webkit.URLUtil.isValidUrl(str);
            AppMethodBeat.o(64662);
            return isValidUrl;
        }
        isValidUrl = a.c().x(str);
        AppMethodBeat.o(64662);
        return isValidUrl;
    }

    public static String stripAnchor(String str) {
        AppMethodBeat.i(64663);
        bv a = bv.a();
        String stripAnchor;
        if (a == null || !a.b()) {
            stripAnchor = android.webkit.URLUtil.stripAnchor(str);
            AppMethodBeat.o(64663);
            return stripAnchor;
        }
        stripAnchor = a.c().y(str);
        AppMethodBeat.o(64663);
        return stripAnchor;
    }
}
