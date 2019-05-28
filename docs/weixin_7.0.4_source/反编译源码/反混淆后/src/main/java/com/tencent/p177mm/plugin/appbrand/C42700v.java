package com.tencent.p177mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.v */
public enum C42700v {
    ;

    /* renamed from: xf */
    public static String m75634xf(String str) {
        AppMethodBeat.m2504i(129125);
        String format = String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=overseas#wechat_redirect", new Object[]{str});
        AppMethodBeat.m2505o(129125);
        return format;
    }

    /* renamed from: a */
    public static String m75631a(WxaExposedParams wxaExposedParams) {
        AppMethodBeat.m2504i(129126);
        String str = "";
        if (wxaExposedParams == null || C5046bo.isNullOrNil(wxaExposedParams.appId)) {
            C4990ab.m7412e("MicroMsg.AppBrandUrlBuilders", "buildFeedbackUrl fail, null or nil appId");
            AppMethodBeat.m2505o(129126);
        } else {
            try {
                str = String.format("https://mp.weixin.qq.com/wxawap/wapreportwxadevlog?action=complain_feedback&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{wxaExposedParams.appId, C18178q.encode(C5046bo.nullAsNil(wxaExposedParams.pageId), "UTF-8"), Integer.valueOf(wxaExposedParams.from), Integer.valueOf(C5046bo.m7550g(Integer.valueOf(wxaExposedParams.gVt), -1)), Integer.valueOf(C5046bo.m7550g(Integer.valueOf(wxaExposedParams.gVu), -1))});
                AppMethodBeat.m2505o(129126);
            } catch (UnsupportedEncodingException e) {
                C4990ab.m7412e("MicroMsg.AppBrandUrlBuilders", "buildFeedbackUrl encode fail, invalid arguments");
                AppMethodBeat.m2505o(129126);
            }
        }
        return str;
    }

    /* renamed from: b */
    public static String m75632b(WxaExposedParams wxaExposedParams) {
        AppMethodBeat.m2504i(129127);
        String str = "";
        if (wxaExposedParams == null || C5046bo.isNullOrNil(wxaExposedParams.appId)) {
            C4990ab.m7412e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl fail, null or nil appId");
            AppMethodBeat.m2505o(129127);
        } else {
            try {
                str = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{wxaExposedParams.appId, C18178q.encode(C5046bo.nullAsNil(wxaExposedParams.pageId), "UTF-8"), Integer.valueOf(wxaExposedParams.from), Integer.valueOf(C5046bo.m7550g(Integer.valueOf(wxaExposedParams.gVt), -1)), Integer.valueOf(C5046bo.m7550g(Integer.valueOf(wxaExposedParams.gVu), -1))});
                AppMethodBeat.m2505o(129127);
            } catch (UnsupportedEncodingException e) {
                C4990ab.m7412e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl encode fail, invalid arguments");
                AppMethodBeat.m2505o(129127);
            }
        }
        return str;
    }

    /* renamed from: xg */
    public static String m75635xg(String str) {
        AppMethodBeat.m2504i(129128);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.AppBrandUrlBuilders", "buildEntityUrl fail, null or nil appId");
            str2 = "";
            AppMethodBeat.m2505o(129128);
            return str2;
        }
        str2 = String.format("https://mp.weixin.qq.com/mp/waverifyinfo?action=get&appid=%s#wechat_redirect", new Object[]{str});
        AppMethodBeat.m2505o(129128);
        return str2;
    }

    /* renamed from: bp */
    public static String m75633bp(String str, String str2) {
        String str3;
        AppMethodBeat.m2504i(129130);
        URI uri = new URI(str);
        String query = uri.getQuery();
        if (query == null) {
            str3 = str2;
        } else {
            str3 = query + "&" + str2;
        }
        query = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), str3, uri.getFragment()).toString();
        AppMethodBeat.m2505o(129130);
        return query;
    }

    /* renamed from: xh */
    public static String m75636xh(String str) {
        AppMethodBeat.m2504i(129129);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.AppBrandUrlBuilders", "buildLowVersionUrl fail, invalid arguments");
            str2 = "";
            AppMethodBeat.m2505o(129129);
            return str2;
        }
        str2 = String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect", new Object[]{str, Integer.valueOf(3)});
        AppMethodBeat.m2505o(129129);
        return str2;
    }
}
