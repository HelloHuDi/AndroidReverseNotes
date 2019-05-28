package com.tencent.p177mm.p202bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C32304g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C6294h;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C17895o;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.p707ba.C9067n;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* renamed from: com.tencent.mm.bf.d */
public final class C25858d implements C1202f {
    public static int chatType = 0;
    private static final C1177f<Integer, C9075a> emX = new C6294h(5);
    private static C25858d fQD;
    private int fLW = 3;
    public boolean fpA = false;

    /* renamed from: com.tencent.mm.bf.d$a */
    public static class C9075a {
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

        public C9075a() {
            AppMethodBeat.m2504i(116543);
            AppMethodBeat.m2505o(116543);
        }

        public final boolean ajT() {
            String str;
            AppMethodBeat.m2504i(116544);
            C7616ad Zd = C1853r.m3850Zd();
            String str2 = "upload";
            if ("  getRegionCode ".concat(String.valueOf(Zd)) != null) {
                str = Zd.dui;
            } else {
                str = "";
            }
            C4990ab.m7410d(str2, str);
            str = Zd.dui;
            if (str != null && str.length() > 0 && this.fQP != null && this.fQP.size() > 0) {
                String[] split = str.split("_");
                if (split != null && split.length > 0) {
                    int i = 0;
                    while (i < split.length) {
                        if (split[i] != null && split[i].length() > 0) {
                            for (String str3 : this.fQP) {
                                if (str3.trim().toLowerCase().equals(split[i].trim().toLowerCase())) {
                                    C4990ab.m7410d("upload", "isInRegion");
                                    AppMethodBeat.m2505o(116544);
                                    return true;
                                }
                            }
                            continue;
                        }
                        i++;
                    }
                }
            }
            AppMethodBeat.m2505o(116544);
            return false;
        }

        public final int ajU() {
            switch (C25858d.chatType) {
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
            switch (C25858d.chatType) {
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
            AppMethodBeat.m2504i(116545);
            if (1 == C32304g.m52780x("EnableSpeexVoiceUpload", 0)) {
                AppMethodBeat.m2505o(116545);
                return true;
            }
            C4990ab.m7410d("upload", "type " + C25858d.chatType);
            int ajV = ajV();
            int ajU = ajU();
            C1720g.m3537RQ();
            Integer valueOf = Integer.valueOf(C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(16646145, null)));
            C4990ab.m7410d("upload", "daycount " + ajV() + "  count " + valueOf + " rate " + ajU);
            if (valueOf.intValue() > ajV) {
                AppMethodBeat.m2505o(116545);
                return false;
            } else if (ajU == 0) {
                AppMethodBeat.m2505o(116545);
                return false;
            } else if (C5023at.isWifi(C4996ah.getContext())) {
                C1720g.m3537RQ();
                boolean z = this.dtS == 0 ? true : this.dtS == C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(12290, null), 0);
                C4990ab.m7410d("upload", "fitSex " + this.dtS + " " + z + " " + this.dtS);
                if (!z) {
                    AppMethodBeat.m2505o(116545);
                    return false;
                } else if (ajT()) {
                    int nextInt = this.fQO.nextInt(ajU);
                    C4990ab.m7410d("upload", "luck ".concat(String.valueOf(nextInt)));
                    if (nextInt == ajU / 2) {
                        AppMethodBeat.m2505o(116545);
                        return true;
                    }
                    AppMethodBeat.m2505o(116545);
                    return false;
                } else {
                    AppMethodBeat.m2505o(116545);
                    return false;
                }
            } else {
                AppMethodBeat.m2505o(116545);
                return false;
            }
        }

        public static C9075a ajX() {
            AppMethodBeat.m2504i(116546);
            C4990ab.m7410d("upload", "parseFromFile");
            String str = C9067n.aiu() + C41787r.aix().mo20542cx(1, 9);
            int asZ = (int) C5730e.asZ(str);
            if (asZ == -1) {
                C4990ab.m7412e("upload", "read file failed " + asZ + str);
                AppMethodBeat.m2505o(116546);
                return null;
            }
            byte[] e = C5730e.m8632e(str, 0, asZ);
            if (e == null) {
                C4990ab.m7412e("upload", "read file failed " + asZ + str);
                AppMethodBeat.m2505o(116546);
                return null;
            }
            str = new String(e);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(116546);
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
            C9075a c9075a = (C9075a) C25858d.emX.get(Integer.valueOf(hashCode));
            if (c9075a != null) {
                AppMethodBeat.m2505o(116546);
                return c9075a;
            }
            Map z = C5049br.m7595z(substring, "Config");
            if (z == null) {
                C4990ab.m7412e("upload", "parse msg failed");
                AppMethodBeat.m2505o(116546);
                return null;
            }
            try {
                C9075a c9075a2 = new C9075a();
                int i = 0;
                while (true) {
                    str = (String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i)) + ".$key");
                    C4990ab.m7410d("upload", "key ".concat(String.valueOf(str)));
                    if (str != null) {
                        StringBuilder stringBuilder;
                        Object obj;
                        if (str.equals("region")) {
                            c9075a2.fQE = (String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i)));
                            if (c9075a2.fQE != null && c9075a2.fQE.length() > 0) {
                                String[] split = c9075a2.fQE.split(";");
                                c9075a2.fQP = new ArrayList();
                                if (split != null && split.length > 0) {
                                    int i2 = 0;
                                    while (i2 < split.length) {
                                        if (split[i2] != null && split[i2].length() > 0) {
                                            c9075a2.fQP.add(split[i2]);
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
                            c9075a2.dtS = C5046bo.getInt((String) z.get(stringBuilder.append(obj).toString()), 0);
                        } else if (str.equals("rate")) {
                            stringBuilder = new StringBuilder(".Config.Item");
                            if (i == 0) {
                                obj = "";
                            } else {
                                obj = Integer.valueOf(i);
                            }
                            c9075a2.fQF = C5046bo.getInt((String) z.get(stringBuilder.append(obj).toString()), 0);
                        } else if (str.equals("minsize")) {
                            c9075a2.fQJ = C5046bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("maxsize")) {
                            c9075a2.fQK = C5046bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("daycount_single")) {
                            c9075a2.fQL = C5046bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("daycount_chatroom")) {
                            c9075a2.fQM = C5046bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("daycount_app")) {
                            c9075a2.fQN = C5046bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("rate_single")) {
                            c9075a2.fQG = C5046bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("rate_chatroom")) {
                            c9075a2.fQH = C5046bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("rate_app")) {
                            c9075a2.fQI = C5046bo.getInt((String) z.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        }
                        i++;
                    } else {
                        C4990ab.m7410d("upload", "sex " + c9075a2.dtS);
                        C4990ab.m7410d("upload", "rate_single " + c9075a2.fQG);
                        C4990ab.m7410d("upload", "rate_chatroom " + c9075a2.fQH);
                        C4990ab.m7410d("upload", "rate_app " + c9075a2.fQI);
                        C4990ab.m7410d("upload", "rate " + c9075a2.fQF);
                        C4990ab.m7410d("upload", "minsize " + c9075a2.fQJ);
                        C4990ab.m7410d("upload", "maxsize " + c9075a2.fQK);
                        C4990ab.m7410d("upload", "daycount_single " + c9075a2.fQL);
                        C4990ab.m7410d("upload", "daycount_chatroom " + c9075a2.fQM);
                        C4990ab.m7410d("upload", "daycount_app " + c9075a2.fQN);
                        C4990ab.m7410d("upload", "region " + c9075a2.fQE);
                        C25858d.emX.mo4412k(Integer.valueOf(hashCode), c9075a2);
                        AppMethodBeat.m2505o(116546);
                        return c9075a2;
                    }
                }
            } catch (Exception e2) {
                C4990ab.m7413e("upload", "exception:%s", C5046bo.m7574l(e2));
                AppMethodBeat.m2505o(116546);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.bf.d$b */
    public static final class C17980b {
        public int aTg = 0;
        public String fNY = "";
        public int fQw = 0;
        public int sampleRate = 0;
    }

    static {
        AppMethodBeat.m2504i(116553);
        AppMethodBeat.m2505o(116553);
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

    /* renamed from: tF */
    public static int m41166tF(String str) {
        int i = 5;
        AppMethodBeat.m2504i(116547);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(116547);
        } else {
            if (str.startsWith("single")) {
            }
            if (str.startsWith("chatroom")) {
                i = 7;
            }
            if (str.startsWith("app")) {
                i = 8;
            }
            C4990ab.m7410d("upload", "type ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(116547);
        }
        return i;
    }

    public static C25858d ajP() {
        AppMethodBeat.m2504i(116548);
        if (fQD == null) {
            fQD = new C25858d();
        }
        C25858d c25858d = fQD;
        AppMethodBeat.m2505o(116548);
        return c25858d;
    }

    public final void release() {
        AppMethodBeat.m2504i(116549);
        this.fpA = false;
        C1720g.m3540Rg().mo14546b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(116549);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(116550);
        if ((c1207m instanceof C17895o) && ((C17895o) c1207m).acR() == 9) {
            if (c1207m.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (i == 0 && i2 == 0) {
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(81944, Long.valueOf(C5046bo.anT()));
                } else {
                    int i3 = this.fLW - 1;
                    this.fLW = i3;
                    if (i3 < 0) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(81944, Long.valueOf(((C5046bo.anU() - 86400000) + 3600000) / 1000));
                        this.fLW = 3;
                    }
                }
                release();
            }
            AppMethodBeat.m2505o(116550);
            return;
        }
        C4990ab.m7410d("upload", "another scene");
        AppMethodBeat.m2505o(116550);
    }

    public static void ajQ() {
        AppMethodBeat.m2504i(116551);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(16646145, Integer.valueOf(0));
        AppMethodBeat.m2505o(116551);
    }

    public static void ajR() {
        AppMethodBeat.m2504i(116552);
        C1720g.m3537RQ();
        Integer valueOf = Integer.valueOf(C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(16646145, null)));
        if (valueOf.intValue() < 0) {
            valueOf = Integer.valueOf(0);
        }
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(16646145, Integer.valueOf(valueOf.intValue() + 1));
        AppMethodBeat.m2505o(116552);
    }
}
