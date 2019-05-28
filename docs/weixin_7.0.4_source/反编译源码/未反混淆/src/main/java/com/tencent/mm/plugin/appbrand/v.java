package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Locale;

public enum v {
    ;

    public static String xf(String str) {
        AppMethodBeat.i(129125);
        String format = String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=overseas#wechat_redirect", new Object[]{str});
        AppMethodBeat.o(129125);
        return format;
    }

    public static String a(WxaExposedParams wxaExposedParams) {
        AppMethodBeat.i(129126);
        String str = "";
        if (wxaExposedParams == null || bo.isNullOrNil(wxaExposedParams.appId)) {
            ab.e("MicroMsg.AppBrandUrlBuilders", "buildFeedbackUrl fail, null or nil appId");
            AppMethodBeat.o(129126);
        } else {
            try {
                str = String.format("https://mp.weixin.qq.com/wxawap/wapreportwxadevlog?action=complain_feedback&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{wxaExposedParams.appId, q.encode(bo.nullAsNil(wxaExposedParams.pageId), "UTF-8"), Integer.valueOf(wxaExposedParams.from), Integer.valueOf(bo.g(Integer.valueOf(wxaExposedParams.gVt), -1)), Integer.valueOf(bo.g(Integer.valueOf(wxaExposedParams.gVu), -1))});
                AppMethodBeat.o(129126);
            } catch (UnsupportedEncodingException e) {
                ab.e("MicroMsg.AppBrandUrlBuilders", "buildFeedbackUrl encode fail, invalid arguments");
                AppMethodBeat.o(129126);
            }
        }
        return str;
    }

    public static String b(WxaExposedParams wxaExposedParams) {
        AppMethodBeat.i(129127);
        String str = "";
        if (wxaExposedParams == null || bo.isNullOrNil(wxaExposedParams.appId)) {
            ab.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl fail, null or nil appId");
            AppMethodBeat.o(129127);
        } else {
            try {
                str = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{wxaExposedParams.appId, q.encode(bo.nullAsNil(wxaExposedParams.pageId), "UTF-8"), Integer.valueOf(wxaExposedParams.from), Integer.valueOf(bo.g(Integer.valueOf(wxaExposedParams.gVt), -1)), Integer.valueOf(bo.g(Integer.valueOf(wxaExposedParams.gVu), -1))});
                AppMethodBeat.o(129127);
            } catch (UnsupportedEncodingException e) {
                ab.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl encode fail, invalid arguments");
                AppMethodBeat.o(129127);
            }
        }
        return str;
    }

    public static String xg(String str) {
        AppMethodBeat.i(129128);
        String str2;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppBrandUrlBuilders", "buildEntityUrl fail, null or nil appId");
            str2 = "";
            AppMethodBeat.o(129128);
            return str2;
        }
        str2 = String.format("https://mp.weixin.qq.com/mp/waverifyinfo?action=get&appid=%s#wechat_redirect", new Object[]{str});
        AppMethodBeat.o(129128);
        return str2;
    }

    public static String bp(String str, String str2) {
        String str3;
        AppMethodBeat.i(129130);
        URI uri = new URI(str);
        String query = uri.getQuery();
        if (query == null) {
            str3 = str2;
        } else {
            str3 = query + "&" + str2;
        }
        query = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), str3, uri.getFragment()).toString();
        AppMethodBeat.o(129130);
        return query;
    }

    public static String xh(String str) {
        AppMethodBeat.i(129129);
        String str2;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppBrandUrlBuilders", "buildLowVersionUrl fail, invalid arguments");
            str2 = "";
            AppMethodBeat.o(129129);
            return str2;
        }
        str2 = String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect", new Object[]{str, Integer.valueOf(3)});
        AppMethodBeat.o(129129);
        return str2;
    }
}
