package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.px;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements e {
    private f fur = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(65454);
            if (mVar.equals(b.this.sAq)) {
                g.Rg().b(b.this.sAq.getType(), (f) this);
                b.this.sAq = null;
                com.tencent.mm.plugin.topstory.a.c.b bVar = (com.tencent.mm.plugin.topstory.a.c.b) mVar;
                if (i == 0 && i2 == 0) {
                    g.RP().Ry().set(a.USERINFO_TOP_STORY_RED_DOT_RESULT_STRING, bVar.cFt().vOy);
                    g.RP().Ry().dsb();
                    com.tencent.mm.sdk.b.a.xxA.m(new px());
                    AppMethodBeat.o(65454);
                    return;
                }
                ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "netscene topstory error");
                AppMethodBeat.o(65454);
                return;
            }
            AppMethodBeat.o(65454);
        }
    };
    public cht sAm;
    LinkedList<cht> sAn = new LinkedList();
    e.a sAo;
    o sAp = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(65453);
            if (!(map == null || str == null || !str.equals("mmsearch_reddot_new"))) {
                int ank = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.entry"));
                if (ank == 2) {
                    cht cht = new cht();
                    b.c(cht);
                    ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recv %s, %s", "mmsearch_reddot_new", map.toString());
                    cht.xgA = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.clear"));
                    cht.uaU = ank;
                    cht.cJb = bo.t((String) map.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
                    cht.uaW = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.discovery"));
                    cht.uaV = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
                    cht.fRS = bo.anl((String) map.get(".sysmsg.mmsearch_reddot_new.expire_time"));
                    cht.tZU = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.h5_version"));
                    cht.type = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
                    cht.text = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_text");
                    cht.cIY = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
                    cht.xgz = bo.anl((String) map.get(".sysmsg.mmsearch_reddot_new.timestamp"));
                    cht.xgB = System.currentTimeMillis();
                    cht.fQi = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.seq"));
                    cht.extInfo = bo.t((String) map.get(".sysmsg.mmsearch_reddot_new.ext_info"), new Object[0]);
                    if (cht.xgA != 1) {
                        switch (cht.type) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                an.a(cht, 100, 1, 0, 0, "");
                                b.this.a(cht);
                                AppMethodBeat.o(65453);
                                return;
                            case 7:
                                an.a(cht, 100, 2, b.this.sAn.size(), 0, "");
                                b.this.b(cht);
                                AppMethodBeat.o(65453);
                                return;
                            case 8:
                                an.a(cht, 100, 3, 0, 0, "");
                                b.abx(cht.cJb);
                                AppMethodBeat.o(65453);
                                return;
                            case 9:
                                if (b.this.sAo != null) {
                                    b.this.sAo.aby(cht.extInfo);
                                    an.a(cht, 100, 4, 0, 0, "");
                                    AppMethodBeat.o(65453);
                                    return;
                                }
                                break;
                            case 10:
                                an.a(cht, 100, 5, 0, 0, "");
                                b.this.m(cht.cJb, cht.extInfo, cht.xgz);
                                AppMethodBeat.o(65453);
                                return;
                            default:
                                an.a(cht, 109, 0, 0, 0, "r12|" + cht.type);
                                break;
                        }
                    }
                    b bVar = b.this;
                    switch (cht.type) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            bVar.A(cht.xgz, false);
                            com.tencent.mm.sdk.b.a.xxA.m(new px());
                            break;
                        case 7:
                            bVar.a(cht.xgz, true, cht.fQi, false);
                            com.tencent.mm.sdk.b.a.xxA.m(new px());
                            break;
                        case 8:
                            b.abx("");
                            break;
                        case 10:
                            bVar.m("", "", 0);
                            break;
                    }
                    switch (cht.type) {
                        case 7:
                            ank = 2;
                            break;
                        case 8:
                            ank = 3;
                            break;
                        case 9:
                            ank = 4;
                            break;
                        default:
                            ank = 1;
                            break;
                    }
                    an.a(cht, 100, ank, 0, 0, "");
                    AppMethodBeat.o(65453);
                    return;
                }
            }
            AppMethodBeat.o(65453);
        }
    };
    com.tencent.mm.plugin.topstory.a.c.b sAq;
    final String sAr = "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}";
    String sAs = "";
    c<fa> sAt = new c<fa>() {
        {
            AppMethodBeat.i(65455);
            this.xxI = fa.class.getName().hashCode();
            AppMethodBeat.o(65455);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(65456);
            b.this.sAs = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_topstory_top_tab_params, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
            AppMethodBeat.o(65456);
            return false;
        }
    };

    public b() {
        AppMethodBeat.i(65457);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.sAp);
        this.sAm = new cht();
        c(this.sAm);
        cht cht = this.sAm;
        String str = (String) g.RP().Ry().get(a.USERINFO_TOP_STORY_RED_XML_REC_STRING, (Object) "");
        if (!bo.isNullOrNil(str)) {
            String[] split = str.split(",");
            if (split != null) {
                try {
                    if (split.length >= 13) {
                        a(cht, split);
                    }
                } catch (Exception e) {
                    g.RP().Ry().set(a.USERINFO_TOP_STORY_RED_XML_REC_STRING, (Object) "");
                    g.RP().Ry().dsb();
                }
            }
            g.RP().Ry().set(a.USERINFO_TOP_STORY_RED_XML_REC_STRING, (Object) "");
            g.RP().Ry().dsb();
        }
        cES();
        com.tencent.mm.sdk.b.a.xxA.b(this.sAt);
        AppMethodBeat.o(65457);
    }

    public final boolean cEN() {
        AppMethodBeat.i(65458);
        if (cFj()) {
            boolean z;
            if (bo.isNullOrNil(this.sAm.cJb)) {
                z = true;
            } else if (this.sAm.xgA == 1) {
                z = true;
            } else if (this.sAm.uaV > d.vxo) {
                ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", this.sAm.cJb, Integer.valueOf(this.sAm.uaV), Integer.valueOf(d.vxo));
                z = true;
            } else {
                int i;
                if (this.sAm.fRS != 0) {
                    if (System.currentTimeMillis() > this.sAm.xgB + (this.sAm.fRS * 1000)) {
                        ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", this.sAm.cJb);
                        z = true;
                    }
                }
                String str = "MicroMsg.TopStory.TopStoryRedDotImpl";
                String str2 = "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
                Object[] objArr = new Object[5];
                if (aa.HV(1) >= this.sAm.tZU) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = Integer.valueOf(this.sAm.tZU);
                objArr[2] = Integer.valueOf(aa.HV(1));
                objArr[3] = Long.valueOf(this.sAm.xgz);
                objArr[4] = Long.valueOf(cEZ());
                ab.i(str, str2, objArr);
                if (aa.HV(1) < this.sAm.tZU || this.sAm.xgz <= cEZ()) {
                    z = false;
                } else {
                    i = 1;
                }
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                if (z) {
                    an.a(this.sAm, 104, 1, 0, 0, "");
                    bNs();
                }
            } else if (cFi()) {
                AppMethodBeat.o(65458);
                return true;
            }
            AppMethodBeat.o(65458);
            return false;
        }
        AppMethodBeat.o(65458);
        return false;
    }

    public final boolean cEO() {
        AppMethodBeat.i(65459);
        if (!cFj()) {
            AppMethodBeat.o(65459);
            return false;
        } else if (((cht) this.sAn.getLast()) == null) {
            AppMethodBeat.o(65459);
            return false;
        } else {
            AppMethodBeat.o(65459);
            return true;
        }
    }

    private void bNs() {
        AppMethodBeat.i(65460);
        this.sAm = new cht();
        c(this.sAm);
        g.RP().Ry().set(a.USERINFO_TOP_STORY_RED_XML_REC_STRING, (Object) "");
        g.RP().Ry().dsb();
        if (this.sAo != null) {
            e.a aVar = this.sAo;
            cEZ();
            aVar.cFk();
        }
        AppMethodBeat.o(65460);
    }

    public final void Fx(int i) {
        AppMethodBeat.i(65461);
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                bNs();
                com.tencent.mm.sdk.b.a.xxA.m(new px());
                AppMethodBeat.o(65461);
                return;
            case 7:
                synchronized (this.sAn) {
                    try {
                        this.sAn.clear();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(65461);
                            break;
                        }
                    }
                }
                cER();
                if (this.sAo != null) {
                    this.sAo.a(0, "", "", 0, 0, "", true);
                }
                com.tencent.mm.sdk.b.a.xxA.m(new px());
                AppMethodBeat.o(65461);
                return;
            case 8:
                abx("");
                AppMethodBeat.o(65461);
                return;
            case 10:
                m("", "", 0);
                break;
        }
        AppMethodBeat.o(65461);
    }

    public final cht cEP() {
        return this.sAm;
    }

    public final void cEQ() {
        AppMethodBeat.i(65462);
        if (this.sAm != null) {
            an.a(this.sAm.cJb, this.sAm.xgz, 1, 0, "", 0);
        }
        AppMethodBeat.o(65462);
    }

    public final void A(long j, boolean z) {
        AppMethodBeat.i(65463);
        if (this.sAm == null || bo.isNullOrNil(this.sAm.cJb)) {
            AppMethodBeat.o(65463);
            return;
        }
        ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d, cur %d", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000));
        if (j < cEZ() || j <= 0 || r0 + 3600 < j) {
            ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, getRedDotTimestamp:%s", Long.valueOf(cEZ()));
            AppMethodBeat.o(65463);
        } else if (this.sAm == null || j >= this.sAm.xgz) {
            if (z) {
                an.a(this.sAm, 106, 1, 0, j, "");
            }
            bNs();
            g.RP().Ry().set(a.USERINFO_TOP_STORY_REDDOT_TIMESTAMP_LONG, Long.valueOf(j));
            g.RP().Ry().dsb();
            AppMethodBeat.o(65463);
        } else {
            ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, showTime:%s", Long.valueOf(this.sAm.xgz));
            AppMethodBeat.o(65463);
        }
    }

    public final void lC(long j) {
        AppMethodBeat.i(65464);
        A(j, true);
        AppMethodBeat.o(65464);
    }

    public final void a(cht cht) {
        AppMethodBeat.i(65465);
        if (!cFi()) {
            an.a(cht, 108, 1, 0, 0, "");
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String str = "MicroMsg.TopStory.TopStoryRedDotImpl";
        String str2 = "setTopStoryRedDot showTime new:%s, cur:%s, curTime:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(cht.xgz);
        objArr[1] = this.sAm == null ? BuildConfig.COMMAND : this.sAm.xgz;
        objArr[2] = Long.valueOf(currentTimeMillis);
        ab.i(str, str2, objArr);
        if (cht.xgz <= cEZ()) {
            an.a(cht, 103, 1, 0, 0, "");
            an.a(cht, 109, 1, 0, 0, "r6|" + cht.xgz + "|" + cEZ());
            AppMethodBeat.o(65465);
        } else if (cht.xgz > 3600 + currentTimeMillis) {
            an.a(cht, 109, 1, 0, 0, "r10|" + cht.xgz + "|" + currentTimeMillis);
            AppMethodBeat.o(65465);
        } else if (this.sAm == null || bo.isNullOrNil(this.sAm.cJb) || this.sAm.xgz <= cht.xgz) {
            if (!(this.sAm == null || bo.isNullOrNil(this.sAm.cJb))) {
                an.a(cht, 105, 1, 0, 0, cht.cJb);
            }
            ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot valid");
            this.sAm = cht;
            g.RP().Ry().set(a.USERINFO_TOP_STORY_RED_XML_REC_STRING, d(this.sAm));
            g.RP().Ry().dsb();
            if (cFi()) {
                an.a(this.sAm, 101, 1, 0, 0, "");
            }
            if (this.sAo != null) {
                this.sAo.as(this.sAm.cJb, this.sAm.xgz);
            }
            com.tencent.mm.sdk.b.a.xxA.m(new px());
            AppMethodBeat.o(65465);
        } else {
            an.a(cht, 105, 1, 0, 0, this.sAm.cJb);
            an.a(cht, 109, 1, 0, 0, "r9|" + cht.xgz + "|" + cEZ());
            AppMethodBeat.o(65465);
        }
    }

    /* JADX WARNING: Missing block: B:29:0x011d, code skipped:
            cER();
     */
    /* JADX WARNING: Missing block: B:30:0x0122, code skipped:
            if (r10.sAo == null) goto L_0x0161;
     */
    /* JADX WARNING: Missing block: B:31:0x0124, code skipped:
            r10.sAo.a(r10.sAn.size(), ((com.tencent.mm.protocal.protobuf.cht) r10.sAn.getFirst()).cJb, ((com.tencent.mm.protocal.protobuf.cht) r10.sAn.getLast()).cJb, ((com.tencent.mm.protocal.protobuf.cht) r10.sAn.getFirst()).fQi, ((com.tencent.mm.protocal.protobuf.cht) r10.sAn.getLast()).fQi, ((com.tencent.mm.protocal.protobuf.cht) r10.sAn.getLast()).extInfo);
     */
    /* JADX WARNING: Missing block: B:32:0x0161, code skipped:
            com.tencent.mm.sdk.b.a.xxA.m(new com.tencent.mm.g.a.px());
            com.tencent.matrix.trace.core.AppMethodBeat.o(65466);
     */
    /* JADX WARNING: Missing block: B:47:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(cht cht) {
        AppMethodBeat.i(65466);
        ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "start addCmtRedDot: %s", Integer.valueOf(cht.fQi));
        if (!cFi()) {
            an.a(cht, 108, 2, this.sAn.size(), 0, "");
        }
        if (cht.fQi <= cFa()) {
            ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid1, %s, %s", Integer.valueOf(cht.fQi), Integer.valueOf(cFa()));
            an.a(cht, 103, 2, cEV(), 0, "");
            an.a(cht, 109, 2, cEV(), 0, "r6|" + cht.fQi + "|" + cFa());
            AppMethodBeat.o(65466);
            return;
        }
        synchronized (this.sAn) {
            try {
                int i;
                if (bo.ek(this.sAn)) {
                    i = 0;
                } else {
                    int i2 = 0;
                    while (i2 < this.sAn.size()) {
                        cht cht2 = (cht) this.sAn.get(i2);
                        if (!cht2.cJb.equals(cht.cJb)) {
                            if (cht2.fQi > cht.fQi) {
                                break;
                            }
                            i2++;
                        } else {
                            ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid3");
                            an.a(cht, 109, 2, cEV(), 0, "r11");
                            AppMethodBeat.o(65466);
                            return;
                        }
                    }
                    i = i2;
                }
                this.sAn.add(i, cht);
                if (cFi()) {
                    an.a(cEW(), 101, 2, this.sAn.size(), 0, "");
                }
                ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot msgId:%s, showTime:%s", cht.cJb, Long.valueOf(cht.xgz));
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(65466);
                }
            }
        }
    }

    private void cER() {
        AppMethodBeat.i(65467);
        synchronized (this.sAn) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                Iterator it = this.sAn.iterator();
                while (it.hasNext()) {
                    stringBuilder.append(d((cht) it.next())).append(";");
                }
                g.RP().Ry().set(a.USERINFO_TOP_STORY_CMT_RED_XML_REC_STRING, stringBuilder.toString());
                g.RP().Ry().dsb();
            } finally {
                AppMethodBeat.o(65467);
            }
        }
    }

    public static void abx(String str) {
        AppMethodBeat.i(65468);
        ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setHomeTabRedDot %s", str);
        g.RP().Ry().set(a.USERINFO_TOP_STORY_HOME_TAB_RED_XML_REC_STRING, (Object) str);
        g.RP().Ry().dsb();
        AppMethodBeat.o(65468);
    }

    static void c(cht cht) {
        cht.cIY = "";
        cht.cJb = "";
        cht.text = "";
    }

    public static String d(cht cht) {
        AppMethodBeat.i(65469);
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{cht.cJb, Integer.valueOf(cht.xgA), Integer.valueOf(cht.uaV), Integer.valueOf(cht.uaW), Integer.valueOf(cht.uaU), Long.valueOf(cht.fRS), Integer.valueOf(cht.tZU), Long.valueOf(cht.xgB), cht.text, Integer.valueOf(cht.type), Integer.valueOf(cht.dtW), Long.valueOf(cht.xgz), cht.cIY, Integer.valueOf(cht.fQi), cht.extInfo});
        AppMethodBeat.o(65469);
        return format;
    }

    private static void a(cht cht, String[] strArr) {
        AppMethodBeat.i(65470);
        cht.cJb = strArr[0];
        cht.xgA = Integer.valueOf(strArr[1]).intValue();
        cht.uaV = Integer.valueOf(strArr[2]).intValue();
        cht.uaW = Integer.valueOf(strArr[3]).intValue();
        cht.uaU = Integer.valueOf(strArr[4]).intValue();
        cht.fRS = Long.valueOf(strArr[5]).longValue();
        cht.tZU = Integer.valueOf(strArr[6]).intValue();
        cht.xgB = Long.valueOf(strArr[7]).longValue();
        cht.text = strArr[8];
        cht.type = Integer.valueOf(strArr[9]).intValue();
        cht.dtW = Integer.valueOf(strArr[10]).intValue();
        cht.xgz = Long.valueOf(strArr[11]).longValue();
        cht.cIY = strArr[12];
        if (strArr.length > 13) {
            cht.fQi = Integer.valueOf(strArr[13]).intValue();
        } else {
            cht.fQi = 0;
            if (cht.type == 7) {
                ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "no seq");
            }
        }
        if (strArr.length > 14) {
            cht.extInfo = strArr[14];
            AppMethodBeat.o(65470);
            return;
        }
        cht.extInfo = "";
        AppMethodBeat.o(65470);
    }

    private void cES() {
        AppMethodBeat.i(65471);
        String str = (String) g.RP().Ry().get(a.USERINFO_TOP_STORY_CMT_RED_XML_REC_STRING, (Object) "");
        if (!bo.isNullOrNil(str)) {
            try {
                for (String str2 : str.split(";")) {
                    if (!bo.isNullOrNil(str2)) {
                        String[] split = str2.split(",");
                        cht cht = new cht();
                        a(cht, split);
                        this.sAn.addLast(cht);
                    }
                }
                AppMethodBeat.o(65471);
                return;
            } catch (Exception e) {
                g.RP().Ry().set(a.USERINFO_TOP_STORY_CMT_RED_XML_REC_STRING, (Object) "");
                g.RP().Ry().dsb();
            }
        }
        AppMethodBeat.o(65471);
    }

    public final boolean cET() {
        if (this.sAm == null) {
            return false;
        }
        if (this.sAm.uaW == 1) {
            return true;
        }
        return false;
    }

    public final int cEU() {
        AppMethodBeat.i(65472);
        if (cFj()) {
            ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", Integer.valueOf(this.sAn.size()));
            int size = this.sAn.size();
            AppMethodBeat.o(65472);
            return size;
        }
        ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", Integer.valueOf(0));
        AppMethodBeat.o(65472);
        return 0;
    }

    private int cEV() {
        AppMethodBeat.i(65473);
        if (cFj()) {
            ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", Integer.valueOf(this.sAn.size()));
            int size = this.sAn.size();
            AppMethodBeat.o(65473);
            return size;
        }
        ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", Integer.valueOf(0));
        AppMethodBeat.o(65473);
        return 0;
    }

    public final cht cEW() {
        cht cht;
        AppMethodBeat.i(65474);
        synchronized (this.sAn) {
            try {
                if (bo.ek(this.sAn)) {
                    cht = null;
                } else {
                    cht = (cht) this.sAn.getLast();
                    AppMethodBeat.o(65474);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(65474);
            }
        }
        return cht;
    }

    public final cht cEX() {
        cht cht;
        AppMethodBeat.i(65475);
        synchronized (this.sAn) {
            try {
                if (bo.ek(this.sAn)) {
                    cht = null;
                } else {
                    cht = (cht) this.sAn.getFirst();
                    AppMethodBeat.o(65475);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(65475);
            }
        }
        return cht;
    }

    public final void a(long j, boolean z, int i, boolean z2) {
        AppMethodBeat.i(65476);
        if (this.sAn.size() == 0) {
            AppMethodBeat.o(65476);
        } else if (i <= cFa()) {
            ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickCmtRedDot invalid, seq:%s, curSeq:%s", Integer.valueOf(i), Integer.valueOf(cFa()));
            AppMethodBeat.o(65476);
        } else {
            String str;
            int size = this.sAn.size();
            String str2 = "";
            synchronized (this.sAn) {
                str = str2;
                while (this.sAn.size() > 0 && ((cht) this.sAn.getFirst()).fQi <= i) {
                    try {
                        str2 = ((cht) this.sAn.getFirst()).cJb;
                        this.sAn.removeFirst();
                        str = str2;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(65476);
                        }
                    }
                }
            }
            if (size != this.sAn.size()) {
                cER();
            }
            if (this.sAo != null) {
                if (this.sAn.size() > 0) {
                    this.sAo.a(this.sAn.size(), ((cht) this.sAn.getFirst()).cJb, ((cht) this.sAn.getLast()).cJb, ((cht) this.sAn.getFirst()).fQi, ((cht) this.sAn.getLast()).fQi, ((cht) this.sAn.getLast()).extInfo, z);
                } else {
                    this.sAo.a(0, "", "", 0, 0, "", z);
                }
            }
            if (z2) {
                cht cht = new cht();
                cht.cJb = str;
                cht.xgz = j;
                cht.fQi = i;
                an.a(cht, 106, 2, size, j, "");
            }
            g.RP().Ry().set(a.USERINFO_TOP_STORY_CMTREDDOT_TIMESTAMP_LONG, Long.valueOf(j));
            g.RP().Ry().dsb();
            ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateCmtRedDotSeq %s", Integer.valueOf(i));
            g.RP().Ry().set(a.USERINFO_TOP_STORY_CMTREDDOT_SEQ_INT, Integer.valueOf(i));
            g.RP().Ry().dsb();
            AppMethodBeat.o(65476);
        }
    }

    public final void i(long j, int i, boolean z) {
        AppMethodBeat.i(65477);
        a(j, z, i, true);
        AppMethodBeat.o(65477);
    }

    public final boolean cEY() {
        AppMethodBeat.i(65478);
        if (bo.ek(this.sAn)) {
            AppMethodBeat.o(65478);
            return false;
        } else if (((cht) this.sAn.getLast()).uaW == 1) {
            AppMethodBeat.o(65478);
            return true;
        } else {
            AppMethodBeat.o(65478);
            return false;
        }
    }

    public final void Fy(int i) {
        AppMethodBeat.i(65479);
        cht cEW = cEW();
        if (cEW != null) {
            an.a(cEW.cJb, cEW.xgz, 2, i, "", cEW.fQi);
        }
        AppMethodBeat.o(65479);
    }

    public final void a(e.a aVar) {
        this.sAo = aVar;
    }

    public final void b(e.a aVar) {
        if (this.sAo == aVar) {
            this.sAo = null;
        }
    }

    public static long cEZ() {
        AppMethodBeat.i(65480);
        Object obj = g.RP().Ry().get(a.USERINFO_TOP_STORY_REDDOT_TIMESTAMP_LONG, null);
        if (obj == null) {
            AppMethodBeat.o(65480);
            return 0;
        }
        long longValue = ((Long) obj).longValue();
        AppMethodBeat.o(65480);
        return longValue;
    }

    private static int cFa() {
        AppMethodBeat.i(65481);
        Object obj = g.RP().Ry().get(a.USERINFO_TOP_STORY_CMTREDDOT_SEQ_INT, null);
        if (obj == null) {
            AppMethodBeat.o(65481);
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        AppMethodBeat.o(65481);
        return intValue;
    }

    public final String cFc() {
        AppMethodBeat.i(65483);
        String str = (String) g.RP().Ry().get(a.USERINFO_TOP_STORY_HOME_TAB_RED_XML_REC_STRING, (Object) "");
        AppMethodBeat.o(65483);
        return str;
    }

    public final void cFd() {
        AppMethodBeat.i(65484);
        cht cht = new cht();
        cht.cJb = cFc();
        an.a(cht, 106, 3, 0, 0, "");
        abx("");
        AppMethodBeat.o(65484);
    }

    public final void m(String str, String str2, long j) {
        AppMethodBeat.i(65485);
        ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setUserIconRedDot %s, extInfo %s", str, str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", str);
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, str2);
            jSONObject.put("ts", j);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryRedDotImpl", e, "setUserIconRedDot error", new Object[0]);
        }
        g.RP().Ry().set(a.USERINFO_TOP_STORY_USER_ICON_RED_XML_REC_STRING, jSONObject.toString());
        g.RP().Ry().dsb();
        if (!(bo.isNullOrNil(str) || this.sAo == null)) {
            this.sAo.at(str, j);
        }
        AppMethodBeat.o(65485);
    }

    public final String cFe() {
        AppMethodBeat.i(65486);
        String str = (String) g.RP().Ry().get(a.USERINFO_TOP_STORY_USER_ICON_RED_XML_REC_STRING, (Object) "");
        if (bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(65486);
            return str;
        }
        try {
            str = new JSONObject(str).optString("msgId", "");
            AppMethodBeat.o(65486);
            return str;
        } catch (JSONException e) {
            str = "";
            AppMethodBeat.o(65486);
            return str;
        }
    }

    public final long cFf() {
        AppMethodBeat.i(65487);
        String str = (String) g.RP().Ry().get(a.USERINFO_TOP_STORY_USER_ICON_RED_XML_REC_STRING, (Object) "");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(65487);
            return 0;
        }
        try {
            long optInt = (long) new JSONObject(str).optInt("ts", 0);
            AppMethodBeat.o(65487);
            return optInt;
        } catch (JSONException e) {
            AppMethodBeat.o(65487);
            return 0;
        }
    }

    public final String cFg() {
        AppMethodBeat.i(65488);
        String str = (String) g.RP().Ry().get(a.USERINFO_TOP_STORY_USER_ICON_RED_XML_REC_STRING, (Object) "");
        if (bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(65488);
            return str;
        }
        try {
            str = new JSONObject(str).optString(IssueStorage.COLUMN_EXT_INFO);
            AppMethodBeat.o(65488);
            return str;
        } catch (JSONException e) {
            str = "";
            AppMethodBeat.o(65488);
            return str;
        }
    }

    public final void cFh() {
        AppMethodBeat.i(65489);
        m("", "", 0);
        AppMethodBeat.o(65489);
    }

    public final boolean cFi() {
        boolean z;
        AppMethodBeat.i(65490);
        JSONObject adL = ac.adL("discoverRecommendEntry");
        if (((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).agO("labs_browse")) {
            if (((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).xj("labs_browse")) {
                z = true;
            }
            z = false;
        } else {
            if (adL.optInt("entrySwitch") == 1) {
                z = true;
            }
            z = false;
        }
        ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recommend show %b", Boolean.valueOf(z));
        AppMethodBeat.o(65490);
        return z;
    }

    public final boolean cFj() {
        AppMethodBeat.i(65491);
        if ((d.vxo >= 654311424 || d.vxs) && com.tencent.magicbrush.c.isNullOrNil(this.sAs)) {
            this.sAs = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_topstory_top_tab_params, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
        }
        try {
            JSONArray jSONArray = new JSONObject(this.sAs).getJSONArray("tabs");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getJSONObject(i).getInt("category") == 110) {
                    AppMethodBeat.o(65491);
                    return true;
                }
            }
        } catch (Exception e) {
            ab.w("MicroMsg.TopStory.TopStoryRedDotImpl", "parse tabconfig failed: %s", e.getMessage());
        }
        AppMethodBeat.o(65491);
        return false;
    }

    public final boolean cFb() {
        AppMethodBeat.i(65482);
        if (bo.isNullOrNil((String) g.RP().Ry().get(a.USERINFO_TOP_STORY_HOME_TAB_RED_XML_REC_STRING, (Object) ""))) {
            AppMethodBeat.o(65482);
            return false;
        }
        AppMethodBeat.o(65482);
        return true;
    }
}
