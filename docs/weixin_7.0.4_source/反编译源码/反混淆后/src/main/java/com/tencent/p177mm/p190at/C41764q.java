package com.tencent.p177mm.p190at;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.at.q */
public final class C41764q {
    private static String[] fGE = null;

    public static boolean ahs() {
        AppMethodBeat.m2504i(78405);
        if (fGE == null) {
            C41764q.aht();
        }
        if (VERSION.SDK_INT < 14 || fGE == null || fGE.length <= 0 || C1427q.etn.esF != 1) {
            AppMethodBeat.m2505o(78405);
            return false;
        }
        AppMethodBeat.m2505o(78405);
        return true;
    }

    private static void aht() {
        AppMethodBeat.m2504i(78406);
        try {
            String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("BizEnableWebpUrl");
            C4990ab.m7411d("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", value);
            if (!C5046bo.isNullOrNil(value)) {
                fGE = value.split(";");
                C4990ab.m7411d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", Integer.valueOf(fGE.length));
            }
            AppMethodBeat.m2505o(78406);
        } catch (C1819b e) {
            C4990ab.m7420w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
            AppMethodBeat.m2505o(78406);
        } catch (Exception e2) {
            C4990ab.m7411d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", e2.getMessage());
            AppMethodBeat.m2505o(78406);
        }
    }

    /* renamed from: sx */
    private static boolean m73702sx(String str) {
        AppMethodBeat.m2504i(78407);
        if (!(fGE == null || fGE.length <= 0 || C5046bo.isNullOrNil(str))) {
            for (String startsWith : fGE) {
                if (str.startsWith(startsWith)) {
                    AppMethodBeat.m2505o(78407);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(78407);
        return false;
    }

    /* renamed from: sy */
    public static String m73703sy(String str) {
        AppMethodBeat.m2504i(78408);
        if (fGE == null || fGE.length == 0) {
            C4990ab.m7410d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
            C41764q.aht();
        }
        if (C41764q.m73702sx(str)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("wxtype");
                if (C5046bo.isNullOrNil(queryParameter)) {
                    AppMethodBeat.m2505o(78408);
                } else {
                    queryParameter = queryParameter.toLowerCase();
                    if (queryParameter.equals("gif") || queryParameter.contains("gif")) {
                        AppMethodBeat.m2505o(78408);
                    } else {
                        String queryParameter2 = parse.getQueryParameter("tp");
                        if (!C5046bo.isNullOrNil(queryParameter2) && queryParameter2.equals("webp")) {
                            AppMethodBeat.m2505o(78408);
                        } else if (C5046bo.isNullOrNil(queryParameter)) {
                            AppMethodBeat.m2505o(78408);
                        } else {
                            str = parse.buildUpon().appendQueryParameter("tp", "webp").build().toString();
                            AppMethodBeat.m2505o(78408);
                        }
                    }
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(78408);
            }
        } else {
            C4990ab.m7410d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
            AppMethodBeat.m2505o(78408);
        }
        return str;
    }

    /* renamed from: sz */
    public static boolean m73704sz(String str) {
        AppMethodBeat.m2504i(78409);
        try {
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(78409);
                return false;
            } else if (C41764q.m73702sx(str)) {
                String queryParameter = Uri.parse(str).getQueryParameter("tp");
                if (C5046bo.isNullOrNil(queryParameter) || !queryParameter.equals("webp")) {
                    AppMethodBeat.m2505o(78409);
                    return false;
                }
                AppMethodBeat.m2505o(78409);
                return true;
            } else {
                AppMethodBeat.m2505o(78409);
                return false;
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(78409);
            return false;
        }
    }

    private static int ahu() {
        AppMethodBeat.m2504i(78410);
        Context context = C4996ah.getContext();
        if (C5023at.isWifi(context)) {
            AppMethodBeat.m2505o(78410);
            return 1;
        } else if (C5023at.is4G(context)) {
            AppMethodBeat.m2505o(78410);
            return 4;
        } else if (C5023at.is3G(context)) {
            AppMethodBeat.m2505o(78410);
            return 3;
        } else if (C5023at.is2G(context)) {
            AppMethodBeat.m2505o(78410);
            return 2;
        } else {
            AppMethodBeat.m2505o(78410);
            return 0;
        }
    }

    /* renamed from: lG */
    public static String m73699lG(int i) {
        AppMethodBeat.m2504i(78411);
        String format = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(C41764q.ahu()), Integer.valueOf(2)});
        AppMethodBeat.m2505o(78411);
        return format;
    }

    /* renamed from: lH */
    public static String m73700lH(int i) {
        AppMethodBeat.m2504i(78412);
        String format = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(C41764q.ahu()), Integer.valueOf(1)});
        AppMethodBeat.m2505o(78412);
        return format;
    }

    /* renamed from: sA */
    public static String m73701sA(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(78413);
        try {
            if (C41764q.m73702sx(str)) {
                String toLowerCase = Uri.parse(str).getQueryParameter("wxtype").toLowerCase();
                if (C5046bo.isNullOrNil(toLowerCase)) {
                    AppMethodBeat.m2505o(78413);
                } else {
                    str2 = toLowerCase.toLowerCase();
                    AppMethodBeat.m2505o(78413);
                }
            } else {
                AppMethodBeat.m2505o(78413);
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(78413);
        }
        return str2;
    }
}
