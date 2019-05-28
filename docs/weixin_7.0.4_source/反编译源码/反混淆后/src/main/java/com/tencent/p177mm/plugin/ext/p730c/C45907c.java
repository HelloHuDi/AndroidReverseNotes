package com.tencent.p177mm.plugin.ext.p730c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.p177mm.plugin.ext.p730c.C27905e.C27906a;
import com.tencent.p177mm.plugin.ext.p730c.C38993b.C11773b;
import com.tencent.p177mm.plugin.ext.p730c.C38993b.C27904a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C44796m;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.ext.c.c */
public final class C45907c {
    private static C4884c gyU = new C430151();
    private static HashSet<String> lQS = new HashSet();
    private static HashSet<String> lQT = new HashSet();
    private static ArrayList<C34085a> lQU = new ArrayList();
    private static HashMap<String, C27906a> lQV = new HashMap();

    /* renamed from: com.tencent.mm.plugin.ext.c.c$1 */
    static class C430151 extends C4884c<C32519bf> {
        C430151() {
            AppMethodBeat.m2504i(20395);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(20395);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(20396);
            C32519bf c32519bf = (C32519bf) c4883b;
            if (c32519bf.cus.cut == 46 && c32519bf.cus.cuu == 0) {
                C4990ab.m7416i("MicroMsg.ExtQbarDataManager", "hy: got ext qrcode config. trigger copy");
                C45907c.m85126jJ(c32519bf.cus.filePath);
                C45907c.access$100();
            }
            AppMethodBeat.m2505o(20396);
            return false;
        }
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.m2504i(20410);
        C45907c.brS();
        AppMethodBeat.m2505o(20410);
    }

    static {
        AppMethodBeat.m2504i(20411);
        AppMethodBeat.m2505o(20411);
    }

    private static String brR() {
        String str;
        AppMethodBeat.m2504i(20397);
        if (ExtControlProviderOpenApi.lPG) {
            str = C1448h.getExternalStorageDirectory().getAbsolutePath() + File.separator + "extqbar";
        } else {
            str = C4996ah.getContext().getFilesDir().getParent() + File.separator + "extqbar";
        }
        File file = new File(str);
        if (!file.exists()) {
            C4990ab.m7416i("MicroMsg.ExtQbarDataManager", "hy: face dir not exist. mk dir");
            file.mkdirs();
        }
        str = str + File.separator + "ext_qbar_config.csv";
        AppMethodBeat.m2505o(20397);
        return str;
    }

    private static void brS() {
        AppMethodBeat.m2504i(20398);
        if (C1173e.m2561ct(C45907c.brR())) {
            try {
                String cy = C1173e.m2566cy(C45907c.brR());
                C4990ab.m7416i("MicroMsg.ExtQbarDataManager", "hy: found qrcode config");
                C4990ab.m7419v("MicroMsg.ExtQbarDataManager", "hy: qrcode config is %s", cy);
                if (C5046bo.isNullOrNil(cy)) {
                    C4990ab.m7420w("MicroMsg.ExtQbarDataManager", "hy: no preset black/white config");
                }
                BufferedReader bufferedReader = new BufferedReader(new StringReader(cy));
                long yz = C5046bo.m7588yz();
                while (true) {
                    try {
                        cy = bufferedReader.readLine();
                        if (cy == null) {
                            break;
                        }
                        C4990ab.m7410d("MicroMsg.ExtQbarDataManager", "hy: retrieving line");
                        String[] split = cy.split(",");
                        if (split.length < 3) {
                            C4990ab.m7421w("MicroMsg.ExtQbarDataManager", "hy: line %s not qualified length!", cy);
                        } else {
                            int i;
                            C34085a c34085a = new C34085a();
                            c34085a.url = split[2].toUpperCase();
                            if ("white".equalsIgnoreCase(split[0])) {
                                c34085a.lQJ = C11773b.WHITE;
                                if ("prefix".equalsIgnoreCase(split[1])) {
                                    c34085a.lQI = C27904a.PREFIX;
                                    i = 1;
                                } else if ("subdomain".equalsIgnoreCase(split[1])) {
                                    c34085a.lQI = C27904a.SUBDOMAIN;
                                    i = 1;
                                } else if ("domain".equalsIgnoreCase(split[1])) {
                                    c34085a.lQI = C27904a.DOMAIN;
                                    i = 1;
                                } else {
                                    C4990ab.m7421w("MicroMsg.ExtQbarDataManager", "hy: [white] 2nd not qualified! %s", split[1]);
                                    i = 0;
                                }
                            } else if ("black".equalsIgnoreCase(split[0])) {
                                c34085a.lQJ = C11773b.BLACK;
                                if ("prefix".equalsIgnoreCase(split[1])) {
                                    c34085a.lQI = C27904a.PREFIX;
                                    i = 1;
                                } else if ("subdomain".equalsIgnoreCase(split[1])) {
                                    c34085a.lQI = C27904a.SUBDOMAIN;
                                    i = 1;
                                } else if ("domain".equalsIgnoreCase(split[1])) {
                                    c34085a.lQI = C27904a.DOMAIN;
                                    i = 1;
                                } else {
                                    C4990ab.m7421w("MicroMsg.ExtQbarDataManager", "hy: [black] 2nd not qualified! %s", split[1]);
                                    i = 0;
                                }
                            } else {
                                C4990ab.m7421w("MicroMsg.ExtQbarDataManager", "hy: 1st not qualified! %s", split[0]);
                                i = 0;
                            }
                            if (i != 0) {
                                lQU.add(c34085a);
                            }
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.ExtQbarDataManager", e, "hy: exception when parse config!", new Object[0]);
                    }
                }
                C4990ab.m7417i("MicroMsg.ExtQbarDataManager", "hy: qrcode config retrieved using %d ms", Long.valueOf(C5046bo.m7525az(yz)));
                AppMethodBeat.m2505o(20398);
                return;
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.ExtQbarDataManager", e2, "hy: read config file failed!", new Object[0]);
                AppMethodBeat.m2505o(20398);
                return;
            }
        }
        C4990ab.m7420w("MicroMsg.ExtQbarDataManager", "hy: not found csv file");
        C1720g.m3540Rg().mo14541a(new C44796m(46), 0);
        AppMethodBeat.m2505o(20398);
    }

    public static void brT() {
        AppMethodBeat.m2504i(20399);
        C45907c.brS();
        C4879a.xxA.mo10052c(gyU);
        AppMethodBeat.m2505o(20399);
    }

    public static void brU() {
        AppMethodBeat.m2504i(20400);
        C4879a.xxA.mo10053d(gyU);
        AppMethodBeat.m2505o(20400);
    }

    /* renamed from: Lh */
    public static void m85119Lh(String str) {
        AppMethodBeat.m2504i(20401);
        lQS.add(str);
        AppMethodBeat.m2505o(20401);
    }

    /* renamed from: Li */
    public static void m85120Li(String str) {
        AppMethodBeat.m2504i(20402);
        lQT.add(str);
        AppMethodBeat.m2505o(20402);
    }

    /* renamed from: a */
    public static void m85125a(String str, C27906a c27906a) {
        AppMethodBeat.m2504i(20403);
        lQV.put(str, c27906a);
        AppMethodBeat.m2505o(20403);
    }

    /* renamed from: Lj */
    public static C27906a m85121Lj(String str) {
        AppMethodBeat.m2504i(20404);
        C27906a c27906a = (C27906a) lQV.get(str);
        AppMethodBeat.m2505o(20404);
        return c27906a;
    }

    public static void clearCache() {
        AppMethodBeat.m2504i(20405);
        lQV.clear();
        AppMethodBeat.m2505o(20405);
    }

    /* renamed from: Lk */
    public static boolean m85122Lk(String str) {
        AppMethodBeat.m2504i(20406);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
            AppMethodBeat.m2505o(20406);
            return false;
        } else if (lQS.contains(str)) {
            C4990ab.m7417i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", str);
            AppMethodBeat.m2505o(20406);
            return true;
        } else {
            AppMethodBeat.m2505o(20406);
            return false;
        }
    }

    /* renamed from: Ll */
    public static boolean m85123Ll(String str) {
        AppMethodBeat.m2504i(20407);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
            AppMethodBeat.m2505o(20407);
            return false;
        } else if (lQT.contains(str)) {
            C4990ab.m7417i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", str);
            AppMethodBeat.m2505o(20407);
            return true;
        } else {
            AppMethodBeat.m2505o(20407);
            return false;
        }
    }

    /* renamed from: Lm */
    public static C11773b m85124Lm(String str) {
        AppMethodBeat.m2504i(20408);
        C11773b c11773b;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
            c11773b = C11773b.NONE;
            AppMethodBeat.m2505o(20408);
            return c11773b;
        }
        Iterator it = lQU.iterator();
        while (it.hasNext()) {
            C34085a c34085a = (C34085a) it.next();
            if (c34085a.lQI != C27904a.PREFIX) {
                try {
                    String host = new URL(str).getHost();
                    C4990ab.m7411d("MicroMsg.ExtQbarDataManager", "hy: host is %s", host);
                    if (C5046bo.m7510Q(new String[0])) {
                        C4990ab.m7420w("MicroMsg.ExtQbarDataManager", "hy: no valid host");
                    } else if (c34085a.lQI == C27904a.DOMAIN) {
                        if (c34085a.url.equals(host)) {
                            C4990ab.m7417i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", c34085a.lQI);
                            c11773b = c34085a.lQJ;
                            AppMethodBeat.m2505o(20408);
                            return c11773b;
                        }
                    } else if (c34085a.lQI == C27904a.SUBDOMAIN) {
                        String[] split = c34085a.url.split("\\.");
                        String[] split2 = host.split("\\.");
                        if (split.length > 0 && split2.length > 0 && split.length <= split2.length) {
                            int length = split.length - 1;
                            int length2 = split2.length - 1;
                            int i = 1;
                            while (length >= 0 && length2 >= 0) {
                                if (!split[length].equals(split2[length2])) {
                                    i = 0;
                                }
                                length--;
                                length2--;
                            }
                            if (i != 0) {
                                C4990ab.m7417i("MicroMsg.ExtQbarDataManager", "hy: match %s subdomain: %s", str, c34085a.url);
                                c11773b = c34085a.lQJ;
                                AppMethodBeat.m2505o(20408);
                                return c11773b;
                            }
                        }
                    } else {
                        C4990ab.m7412e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
                    }
                } catch (MalformedURLException e) {
                    C4990ab.printErrStackTrace("MicroMsg.ExtQbarDataManager", e, "hy: error in url convert: %s", str);
                }
            } else if (str.startsWith(c34085a.url)) {
                C4990ab.m7417i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", c34085a.url);
                c11773b = c34085a.lQJ;
                AppMethodBeat.m2505o(20408);
                return c11773b;
            }
        }
        c11773b = C11773b.NONE;
        AppMethodBeat.m2505o(20408);
        return c11773b;
    }

    /* renamed from: jJ */
    static /* synthetic */ void m85126jJ(String str) {
        AppMethodBeat.m2504i(20409);
        C1173e.m2577y(str, C45907c.brR());
        AppMethodBeat.m2505o(20409);
    }
}
