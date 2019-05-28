package com.tencent.mm.at;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class q {
    private static String[] fGE = null;

    public static boolean ahs() {
        AppMethodBeat.i(78405);
        if (fGE == null) {
            aht();
        }
        if (VERSION.SDK_INT < 14 || fGE == null || fGE.length <= 0 || com.tencent.mm.compatible.e.q.etn.esF != 1) {
            AppMethodBeat.o(78405);
            return false;
        }
        AppMethodBeat.o(78405);
        return true;
    }

    private static void aht() {
        AppMethodBeat.i(78406);
        try {
            String value = ((a) g.K(a.class)).Nu().getValue("BizEnableWebpUrl");
            ab.d("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", value);
            if (!bo.isNullOrNil(value)) {
                fGE = value.split(";");
                ab.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", Integer.valueOf(fGE.length));
            }
            AppMethodBeat.o(78406);
        } catch (b e) {
            ab.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
            AppMethodBeat.o(78406);
        } catch (Exception e2) {
            ab.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", e2.getMessage());
            AppMethodBeat.o(78406);
        }
    }

    private static boolean sx(String str) {
        AppMethodBeat.i(78407);
        if (!(fGE == null || fGE.length <= 0 || bo.isNullOrNil(str))) {
            for (String startsWith : fGE) {
                if (str.startsWith(startsWith)) {
                    AppMethodBeat.o(78407);
                    return true;
                }
            }
        }
        AppMethodBeat.o(78407);
        return false;
    }

    public static String sy(String str) {
        AppMethodBeat.i(78408);
        if (fGE == null || fGE.length == 0) {
            ab.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
            aht();
        }
        if (sx(str)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("wxtype");
                if (bo.isNullOrNil(queryParameter)) {
                    AppMethodBeat.o(78408);
                } else {
                    queryParameter = queryParameter.toLowerCase();
                    if (queryParameter.equals("gif") || queryParameter.contains("gif")) {
                        AppMethodBeat.o(78408);
                    } else {
                        String queryParameter2 = parse.getQueryParameter("tp");
                        if (!bo.isNullOrNil(queryParameter2) && queryParameter2.equals("webp")) {
                            AppMethodBeat.o(78408);
                        } else if (bo.isNullOrNil(queryParameter)) {
                            AppMethodBeat.o(78408);
                        } else {
                            str = parse.buildUpon().appendQueryParameter("tp", "webp").build().toString();
                            AppMethodBeat.o(78408);
                        }
                    }
                }
            } catch (Exception e) {
                AppMethodBeat.o(78408);
            }
        } else {
            ab.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
            AppMethodBeat.o(78408);
        }
        return str;
    }

    public static boolean sz(String str) {
        AppMethodBeat.i(78409);
        try {
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(78409);
                return false;
            } else if (sx(str)) {
                String queryParameter = Uri.parse(str).getQueryParameter("tp");
                if (bo.isNullOrNil(queryParameter) || !queryParameter.equals("webp")) {
                    AppMethodBeat.o(78409);
                    return false;
                }
                AppMethodBeat.o(78409);
                return true;
            } else {
                AppMethodBeat.o(78409);
                return false;
            }
        } catch (Exception e) {
            AppMethodBeat.o(78409);
            return false;
        }
    }

    private static int ahu() {
        AppMethodBeat.i(78410);
        Context context = ah.getContext();
        if (at.isWifi(context)) {
            AppMethodBeat.o(78410);
            return 1;
        } else if (at.is4G(context)) {
            AppMethodBeat.o(78410);
            return 4;
        } else if (at.is3G(context)) {
            AppMethodBeat.o(78410);
            return 3;
        } else if (at.is2G(context)) {
            AppMethodBeat.o(78410);
            return 2;
        } else {
            AppMethodBeat.o(78410);
            return 0;
        }
    }

    public static String lG(int i) {
        AppMethodBeat.i(78411);
        String format = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(ahu()), Integer.valueOf(2)});
        AppMethodBeat.o(78411);
        return format;
    }

    public static String lH(int i) {
        AppMethodBeat.i(78412);
        String format = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(ahu()), Integer.valueOf(1)});
        AppMethodBeat.o(78412);
        return format;
    }

    public static String sA(String str) {
        String str2 = null;
        AppMethodBeat.i(78413);
        try {
            if (sx(str)) {
                String toLowerCase = Uri.parse(str).getQueryParameter("wxtype").toLowerCase();
                if (bo.isNullOrNil(toLowerCase)) {
                    AppMethodBeat.o(78413);
                } else {
                    str2 = toLowerCase.toLowerCase();
                    AppMethodBeat.o(78413);
                }
            } else {
                AppMethodBeat.o(78413);
            }
        } catch (Exception e) {
            AppMethodBeat.o(78413);
        }
        return str2;
    }
}
