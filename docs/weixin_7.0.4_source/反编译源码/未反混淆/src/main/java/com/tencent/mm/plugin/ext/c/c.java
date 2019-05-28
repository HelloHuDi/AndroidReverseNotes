package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.c.e.a;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class c {
    private static com.tencent.mm.sdk.b.c gyU = new com.tencent.mm.sdk.b.c<bf>() {
        {
            AppMethodBeat.i(20395);
            this.xxI = bf.class.getName().hashCode();
            AppMethodBeat.o(20395);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(20396);
            bf bfVar = (bf) bVar;
            if (bfVar.cus.cut == 46 && bfVar.cus.cuu == 0) {
                ab.i("MicroMsg.ExtQbarDataManager", "hy: got ext qrcode config. trigger copy");
                c.jJ(bfVar.cus.filePath);
                c.access$100();
            }
            AppMethodBeat.o(20396);
            return false;
        }
    };
    private static HashSet<String> lQS = new HashSet();
    private static HashSet<String> lQT = new HashSet();
    private static ArrayList<a> lQU = new ArrayList();
    private static HashMap<String, a> lQV = new HashMap();

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(20410);
        brS();
        AppMethodBeat.o(20410);
    }

    static {
        AppMethodBeat.i(20411);
        AppMethodBeat.o(20411);
    }

    private static String brR() {
        String str;
        AppMethodBeat.i(20397);
        if (ExtControlProviderOpenApi.lPG) {
            str = h.getExternalStorageDirectory().getAbsolutePath() + File.separator + "extqbar";
        } else {
            str = ah.getContext().getFilesDir().getParent() + File.separator + "extqbar";
        }
        File file = new File(str);
        if (!file.exists()) {
            ab.i("MicroMsg.ExtQbarDataManager", "hy: face dir not exist. mk dir");
            file.mkdirs();
        }
        str = str + File.separator + "ext_qbar_config.csv";
        AppMethodBeat.o(20397);
        return str;
    }

    private static void brS() {
        AppMethodBeat.i(20398);
        if (e.ct(brR())) {
            try {
                String cy = e.cy(brR());
                ab.i("MicroMsg.ExtQbarDataManager", "hy: found qrcode config");
                ab.v("MicroMsg.ExtQbarDataManager", "hy: qrcode config is %s", cy);
                if (bo.isNullOrNil(cy)) {
                    ab.w("MicroMsg.ExtQbarDataManager", "hy: no preset black/white config");
                }
                BufferedReader bufferedReader = new BufferedReader(new StringReader(cy));
                long yz = bo.yz();
                while (true) {
                    try {
                        cy = bufferedReader.readLine();
                        if (cy == null) {
                            break;
                        }
                        ab.d("MicroMsg.ExtQbarDataManager", "hy: retrieving line");
                        String[] split = cy.split(",");
                        if (split.length < 3) {
                            ab.w("MicroMsg.ExtQbarDataManager", "hy: line %s not qualified length!", cy);
                        } else {
                            int i;
                            a aVar = new a();
                            aVar.url = split[2].toUpperCase();
                            if ("white".equalsIgnoreCase(split[0])) {
                                aVar.lQJ = b.b.WHITE;
                                if ("prefix".equalsIgnoreCase(split[1])) {
                                    aVar.lQI = a.PREFIX;
                                    i = 1;
                                } else if ("subdomain".equalsIgnoreCase(split[1])) {
                                    aVar.lQI = a.SUBDOMAIN;
                                    i = 1;
                                } else if ("domain".equalsIgnoreCase(split[1])) {
                                    aVar.lQI = a.DOMAIN;
                                    i = 1;
                                } else {
                                    ab.w("MicroMsg.ExtQbarDataManager", "hy: [white] 2nd not qualified! %s", split[1]);
                                    i = 0;
                                }
                            } else if ("black".equalsIgnoreCase(split[0])) {
                                aVar.lQJ = b.b.BLACK;
                                if ("prefix".equalsIgnoreCase(split[1])) {
                                    aVar.lQI = a.PREFIX;
                                    i = 1;
                                } else if ("subdomain".equalsIgnoreCase(split[1])) {
                                    aVar.lQI = a.SUBDOMAIN;
                                    i = 1;
                                } else if ("domain".equalsIgnoreCase(split[1])) {
                                    aVar.lQI = a.DOMAIN;
                                    i = 1;
                                } else {
                                    ab.w("MicroMsg.ExtQbarDataManager", "hy: [black] 2nd not qualified! %s", split[1]);
                                    i = 0;
                                }
                            } else {
                                ab.w("MicroMsg.ExtQbarDataManager", "hy: 1st not qualified! %s", split[0]);
                                i = 0;
                            }
                            if (i != 0) {
                                lQU.add(aVar);
                            }
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.ExtQbarDataManager", e, "hy: exception when parse config!", new Object[0]);
                    }
                }
                ab.i("MicroMsg.ExtQbarDataManager", "hy: qrcode config retrieved using %d ms", Long.valueOf(bo.az(yz)));
                AppMethodBeat.o(20398);
                return;
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.ExtQbarDataManager", e2, "hy: read config file failed!", new Object[0]);
                AppMethodBeat.o(20398);
                return;
            }
        }
        ab.w("MicroMsg.ExtQbarDataManager", "hy: not found csv file");
        g.Rg().a(new m(46), 0);
        AppMethodBeat.o(20398);
    }

    public static void brT() {
        AppMethodBeat.i(20399);
        brS();
        com.tencent.mm.sdk.b.a.xxA.c(gyU);
        AppMethodBeat.o(20399);
    }

    public static void brU() {
        AppMethodBeat.i(20400);
        com.tencent.mm.sdk.b.a.xxA.d(gyU);
        AppMethodBeat.o(20400);
    }

    public static void Lh(String str) {
        AppMethodBeat.i(20401);
        lQS.add(str);
        AppMethodBeat.o(20401);
    }

    public static void Li(String str) {
        AppMethodBeat.i(20402);
        lQT.add(str);
        AppMethodBeat.o(20402);
    }

    public static void a(String str, a aVar) {
        AppMethodBeat.i(20403);
        lQV.put(str, aVar);
        AppMethodBeat.o(20403);
    }

    public static a Lj(String str) {
        AppMethodBeat.i(20404);
        a aVar = (a) lQV.get(str);
        AppMethodBeat.o(20404);
        return aVar;
    }

    public static void clearCache() {
        AppMethodBeat.i(20405);
        lQV.clear();
        AppMethodBeat.o(20405);
    }

    public static boolean Lk(String str) {
        AppMethodBeat.i(20406);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
            AppMethodBeat.o(20406);
            return false;
        } else if (lQS.contains(str)) {
            ab.i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", str);
            AppMethodBeat.o(20406);
            return true;
        } else {
            AppMethodBeat.o(20406);
            return false;
        }
    }

    public static boolean Ll(String str) {
        AppMethodBeat.i(20407);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
            AppMethodBeat.o(20407);
            return false;
        } else if (lQT.contains(str)) {
            ab.i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", str);
            AppMethodBeat.o(20407);
            return true;
        } else {
            AppMethodBeat.o(20407);
            return false;
        }
    }

    public static b.b Lm(String str) {
        AppMethodBeat.i(20408);
        b.b bVar;
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
            bVar = b.b.NONE;
            AppMethodBeat.o(20408);
            return bVar;
        }
        Iterator it = lQU.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.lQI != a.PREFIX) {
                try {
                    String host = new URL(str).getHost();
                    ab.d("MicroMsg.ExtQbarDataManager", "hy: host is %s", host);
                    if (bo.Q(new String[0])) {
                        ab.w("MicroMsg.ExtQbarDataManager", "hy: no valid host");
                    } else if (aVar.lQI == a.DOMAIN) {
                        if (aVar.url.equals(host)) {
                            ab.i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", aVar.lQI);
                            bVar = aVar.lQJ;
                            AppMethodBeat.o(20408);
                            return bVar;
                        }
                    } else if (aVar.lQI == a.SUBDOMAIN) {
                        String[] split = aVar.url.split("\\.");
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
                                ab.i("MicroMsg.ExtQbarDataManager", "hy: match %s subdomain: %s", str, aVar.url);
                                bVar = aVar.lQJ;
                                AppMethodBeat.o(20408);
                                return bVar;
                            }
                        }
                    } else {
                        ab.e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
                    }
                } catch (MalformedURLException e) {
                    ab.printErrStackTrace("MicroMsg.ExtQbarDataManager", e, "hy: error in url convert: %s", str);
                }
            } else if (str.startsWith(aVar.url)) {
                ab.i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", aVar.url);
                bVar = aVar.lQJ;
                AppMethodBeat.o(20408);
                return bVar;
            }
        }
        bVar = b.b.NONE;
        AppMethodBeat.o(20408);
        return bVar;
    }

    static /* synthetic */ void jJ(String str) {
        AppMethodBeat.i(20409);
        e.y(str, brR());
        AppMethodBeat.o(20409);
    }
}
