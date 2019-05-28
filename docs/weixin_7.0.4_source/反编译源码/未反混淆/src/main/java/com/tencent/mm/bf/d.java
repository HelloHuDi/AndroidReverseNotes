package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.h;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.o;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.ba.n;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d implements f {
    public static int chatType = 0;
    private static final com.tencent.mm.a.f<Integer, a> emX = new h(5);
    private static d fQD;
    private int fLW = 3;
    public boolean fpA = false;

    public static class a {
        public int dtS = 0;
        public String fQE = "BeiJing;GuangZhou;ShangHai;";
        public int fQF = 0;
        public int fQG = 2;
        public int fQH = 2;
        public int fQI = 2;
        public int fQJ = 10240;
        public int fQK = 10240000;
        public int fQL = 100;
        public int fQM = 100;
        public int fQN = 100;
        private Random fQO = new Random();
        public List<String> fQP = null;

        public a() {
            AppMethodBeat.i(116543);
            AppMethodBeat.o(116543);
        }

        public final boolean ajT() {
            String str;
            AppMethodBeat.i(116544);
            ad Zd = r.Zd();
            String str2 = "upload";
            if ("  getRegionCode ".concat(String.valueOf(Zd)) != null) {
                str = Zd.dui;
            } else {
                str = "";
            }
            ab.d(str2, str);
            str = Zd.dui;
            if (str != null && str.length() > 0 && this.fQP != null && this.fQP.size() > 0) {
                String[] split = str.split("_");
                if (split != null && split.length > 0) {
                    int i = 0;
                    while (i < split.length) {
                        if (split[i] != null && split[i].length() > 0) {
                            for (String str3 : this.fQP) {
                                if (str3.trim().toLowerCase().equals(split[i].trim().toLowerCase())) {
                                    ab.d("upload", "isInRegion");
                                    AppMethodBeat.o(116544);
                                    return true;
                                }
                            }
                            continue;
                        }
                        i++;
                    }
                }
            }
            AppMethodBeat.o(116544);
            return false;
        }

        public final int ajU() {
            switch (d.chatType) {
                case 0:
                    return this.fQG;
                case 1:
                    return this.fQH;
                case 2:
                    return this.fQI;
                default:
                    return this.fQG;
            }
        }

        private int ajV() {
            switch (d.chatType) {
                case 0:
                    return this.fQL;
                case 1:
                    return this.fQM;
                case 2:
                    return this.fQN;
                default:
                    return this.fQL;
            }
        }

        public final boolean ajW() {
            AppMethodBeat.i(116545);
            if (1 == g.x("EnableSpeexVoiceUpload", 0)) {
                AppMethodBeat.o(116545);
                return true;
            }
            ab.d("upload", "type " + d.chatType);
            int ajV = ajV();
            int ajU = ajU();
            com.tencent.mm.kernel.g.RQ();
            Integer valueOf = Integer.valueOf(bo.h((Integer) com.tencent.mm.kernel.g.RP().Ry().get(16646145, null)));
            ab.d("upload", "daycount " + ajV() + "  count " + valueOf + " rate " + ajU);
            if (valueOf.intValue() > ajV) {
                AppMethodBeat.o(116545);
                return false;
            } else if (ajU == 0) {
                AppMethodBeat.o(116545);
                return false;
            } else if (at.isWifi(ah.getContext())) {
                com.tencent.mm.kernel.g.RQ();
                boolean z = this.dtS == 0 ? true : this.dtS == bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(12290, null), 0);
                ab.d("upload", "fitSex " + this.dtS + " " + z + " " + this.dtS);
                if (!z) {
                    AppMethodBeat.o(116545);
                    return false;
                } else if (ajT()) {
                    int nextInt = this.fQO.nextInt(ajU);
                    ab.d("upload", "luck ".concat(String.valueOf(nextInt)));
                    if (nextInt == ajU / 2) {
                        AppMethodBeat.o(116545);
                        return true;
                    }
                    AppMethodBeat.o(116545);
                    return false;
                } else {
                    AppMethodBeat.o(116545);
                    return false;
                }
            } else {
                AppMethodBeat.o(116545);
                return false;
            }
        }

        public static a ajX() {
            AppMethodBeat.i(116546);
            ab.d("upload", "parseFromFile");
            String str = n.aiu() + com.tencent.mm.ba.r.aix().cx(1, 9);
            int asZ = (int) e.asZ(str);
            if (asZ == -1) {
                ab.e("upload", "read file failed " + asZ + str);
                AppMethodBeat.o(116546);
                return null;
            }
            byte[] e = e.e(str, 0, asZ);
            if (e == null) {
                ab.e("upload", "read file failed " + asZ + str);
                AppMethodBeat.o(116546);
                return null;
            }
            str = new String(e);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(116546);
                return null;
            }
            String substring;
            asZ = str.indexOf(60);
            if (asZ > 0) {
                substring = str.substring(asZ);
            } else {
                substring = str;
            }
            int hashCode = substring.hashCode();
            a aVar = (a) d.emX.get(Integer.valueOf(hashCode));
            if (aVar != null) {
                AppMethodBeat.o(116546);
                return aVar;
            }
            Map z = br.z(substring, "Config");
            if (z == null) {
                ab.e("upload", "parse msg failed");
                AppMethodBeat.o(116546);
                return null;
            }
            try {
                a aVar2 = new a();
                int i = 0;
                while (true) {
                    str = (String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i)) + ".$key");
                    ab.d("upload", "key ".concat(String.valueOf(str)));
                    if (str != null) {
                        StringBuilder stringBuilder;
                        Object obj;
                        if (str.equals("region")) {
                            aVar2.fQE = (String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i)));
                            if (aVar2.fQE != null && aVar2.fQE.length() > 0) {
                                String[] split = aVar2.fQE.split(";");
                                aVar2.fQP = new ArrayList();
                                if (split != null && split.length > 0) {
                                    int i2 = 0;
                                    while (i2 < split.length) {
                                        if (split[i2] != null && split[i2].length() > 0) {
                                            aVar2.fQP.add(split[i2]);
                                        }
                                        i2++;
                                    }
                                }
                            }
                        } else if (str.equals("sex")) {
                            stringBuilder = new StringBuilder(".Config.Item");
                            if (i == 0) {
                                obj = "";
                            } else {
                                obj = Integer.valueOf(i);
                            }
                            aVar2.dtS = bo.getInt((String) z.get(stringBuilder.append(obj).toString()), 0);
                        } else if (str.equals("rate")) {
                            stringBuilder = new StringBuilder(".Config.Item");
                            if (i == 0) {
                                obj = "";
                            } else {
                                obj = Integer.valueOf(i);
                            }
                            aVar2.fQF = bo.getInt((String) z.get(stringBuilder.append(obj).toString()), 0);
                        } else if (str.equals("minsize")) {
                            aVar2.fQJ = bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("maxsize")) {
                            aVar2.fQK = bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("daycount_single")) {
                            aVar2.fQL = bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("daycount_chatroom")) {
                            aVar2.fQM = bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("daycount_app")) {
                            aVar2.fQN = bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("rate_single")) {
                            aVar2.fQG = bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("rate_chatroom")) {
                            aVar2.fQH = bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("rate_app")) {
                            aVar2.fQI = bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        }
                        i++;
                    } else {
                        ab.d("upload", "sex " + aVar2.dtS);
                        ab.d("upload", "rate_single " + aVar2.fQG);
                        ab.d("upload", "rate_chatroom " + aVar2.fQH);
                        ab.d("upload", "rate_app " + aVar2.fQI);
                        ab.d("upload", "rate " + aVar2.fQF);
                        ab.d("upload", "minsize " + aVar2.fQJ);
                        ab.d("upload", "maxsize " + aVar2.fQK);
                        ab.d("upload", "daycount_single " + aVar2.fQL);
                        ab.d("upload", "daycount_chatroom " + aVar2.fQM);
                        ab.d("upload", "daycount_app " + aVar2.fQN);
                        ab.d("upload", "region " + aVar2.fQE);
                        d.emX.k(Integer.valueOf(hashCode), aVar2);
                        AppMethodBeat.o(116546);
                        return aVar2;
                    }
                }
            } catch (Exception e2) {
                ab.e("upload", "exception:%s", bo.l(e2));
                AppMethodBeat.o(116546);
                return null;
            }
        }
    }

    public static final class b {
        public int aTg = 0;
        public String fNY = "";
        public int fQw = 0;
        public int sampleRate = 0;
    }

    static {
        AppMethodBeat.i(116553);
        AppMethodBeat.o(116553);
    }

    public static String getPrefix() {
        switch (chatType) {
            case 0:
                return "single_";
            case 1:
                return "chatroom_";
            case 2:
                return "app_";
            default:
                return "single_";
        }
    }

    public static int tF(String str) {
        int i = 5;
        AppMethodBeat.i(116547);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(116547);
        } else {
            if (str.startsWith("single")) {
            }
            if (str.startsWith("chatroom")) {
                i = 7;
            }
            if (str.startsWith("app")) {
                i = 8;
            }
            ab.d("upload", "type ".concat(String.valueOf(i)));
            AppMethodBeat.o(116547);
        }
        return i;
    }

    public static d ajP() {
        AppMethodBeat.i(116548);
        if (fQD == null) {
            fQD = new d();
        }
        d dVar = fQD;
        AppMethodBeat.o(116548);
        return dVar;
    }

    public final void release() {
        AppMethodBeat.i(116549);
        this.fpA = false;
        com.tencent.mm.kernel.g.Rg().b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (f) this);
        AppMethodBeat.o(116549);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(116550);
        if ((mVar instanceof o) && ((o) mVar).acR() == 9) {
            if (mVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RP().Ry().set(81944, Long.valueOf(bo.anT()));
                } else {
                    int i3 = this.fLW - 1;
                    this.fLW = i3;
                    if (i3 < 0) {
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RP().Ry().set(81944, Long.valueOf(((bo.anU() - 86400000) + 3600000) / 1000));
                        this.fLW = 3;
                    }
                }
                release();
            }
            AppMethodBeat.o(116550);
            return;
        }
        ab.d("upload", "another scene");
        AppMethodBeat.o(116550);
    }

    public static void ajQ() {
        AppMethodBeat.i(116551);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RP().Ry().set(16646145, Integer.valueOf(0));
        AppMethodBeat.o(116551);
    }

    public static void ajR() {
        AppMethodBeat.i(116552);
        com.tencent.mm.kernel.g.RQ();
        Integer valueOf = Integer.valueOf(bo.h((Integer) com.tencent.mm.kernel.g.RP().Ry().get(16646145, null)));
        if (valueOf.intValue() < 0) {
            valueOf = Integer.valueOf(0);
        }
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RP().Ry().set(16646145, Integer.valueOf(valueOf.intValue() + 1));
        AppMethodBeat.o(116552);
    }
}
