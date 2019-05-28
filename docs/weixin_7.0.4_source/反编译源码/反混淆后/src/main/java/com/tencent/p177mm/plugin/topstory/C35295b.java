package com.tencent.p177mm.plugin.topstory;

import com.tencent.magicbrush.C37414c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32622px;
import com.tencent.p177mm.p230g.p231a.C9333fa;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.topstory.p539a.C43691e;
import com.tencent.p177mm.plugin.topstory.p539a.C43691e.C35294a;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C39961b;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C29736ac;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C23167a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.cht;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.topstory.b */
public final class C35295b implements C43691e {
    private C1202f fur = new C294322();
    public cht sAm;
    LinkedList<cht> sAn = new LinkedList();
    C35294a sAo;
    C3473o sAp = new C139451();
    C39961b sAq;
    final String sAr = "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}";
    String sAs = "";
    C4884c<C9333fa> sAt = new C352963();

    /* renamed from: com.tencent.mm.plugin.topstory.b$1 */
    class C139451 implements C3473o {
        C139451() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(65453);
            if (!(map == null || str == null || !str.equals("mmsearch_reddot_new"))) {
                int ank = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.entry"));
                if (ank == 2) {
                    cht cht = new cht();
                    C35295b.m57965c(cht);
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "recv %s, %s", "mmsearch_reddot_new", map.toString());
                    cht.xgA = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.clear"));
                    cht.uaU = ank;
                    cht.cJb = C5046bo.m7584t((String) map.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
                    cht.uaW = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.discovery"));
                    cht.uaV = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
                    cht.fRS = C5046bo.anl((String) map.get(".sysmsg.mmsearch_reddot_new.expire_time"));
                    cht.tZU = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.h5_version"));
                    cht.type = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
                    cht.text = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_text");
                    cht.cIY = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
                    cht.xgz = C5046bo.anl((String) map.get(".sysmsg.mmsearch_reddot_new.timestamp"));
                    cht.xgB = System.currentTimeMillis();
                    cht.fQi = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.seq"));
                    cht.extInfo = C5046bo.m7584t((String) map.get(".sysmsg.mmsearch_reddot_new.ext_info"), new Object[0]);
                    if (cht.xgA != 1) {
                        switch (cht.type) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                C14423an.m22644a(cht, 100, 1, 0, 0, "");
                                C35295b.this.mo56016a(cht);
                                AppMethodBeat.m2505o(65453);
                                return;
                            case 7:
                                C14423an.m22644a(cht, 100, 2, C35295b.this.sAn.size(), 0, "");
                                C35295b.this.mo56018b(cht);
                                AppMethodBeat.m2505o(65453);
                                return;
                            case 8:
                                C14423an.m22644a(cht, 100, 3, 0, 0, "");
                                C35295b.abx(cht.cJb);
                                AppMethodBeat.m2505o(65453);
                                return;
                            case 9:
                                if (C35295b.this.sAo != null) {
                                    C35295b.this.sAo.aby(cht.extInfo);
                                    C14423an.m22644a(cht, 100, 4, 0, 0, "");
                                    AppMethodBeat.m2505o(65453);
                                    return;
                                }
                                break;
                            case 10:
                                C14423an.m22644a(cht, 100, 5, 0, 0, "");
                                C35295b.this.mo56039m(cht.cJb, cht.extInfo, cht.xgz);
                                AppMethodBeat.m2505o(65453);
                                return;
                            default:
                                C14423an.m22644a(cht, 109, 0, 0, 0, "r12|" + cht.type);
                                break;
                        }
                    }
                    C35295b c35295b = C35295b.this;
                    switch (cht.type) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            c35295b.mo56011A(cht.xgz, false);
                            C4879a.xxA.mo10055m(new C32622px());
                            break;
                        case 7:
                            c35295b.mo56014a(cht.xgz, true, cht.fQi, false);
                            C4879a.xxA.mo10055m(new C32622px());
                            break;
                        case 8:
                            C35295b.abx("");
                            break;
                        case 10:
                            c35295b.mo56039m("", "", 0);
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
                    C14423an.m22644a(cht, 100, ank, 0, 0, "");
                    AppMethodBeat.m2505o(65453);
                    return;
                }
            }
            AppMethodBeat.m2505o(65453);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.b$2 */
    class C294322 implements C1202f {
        C294322() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(65454);
            if (c1207m.equals(C35295b.this.sAq)) {
                C1720g.m3540Rg().mo14546b(C35295b.this.sAq.getType(), (C1202f) this);
                C35295b.this.sAq = null;
                C39961b c39961b = (C39961b) c1207m;
                if (i == 0 && i2 == 0) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_RED_DOT_RESULT_STRING, c39961b.cFt().vOy);
                    C1720g.m3536RP().mo5239Ry().dsb();
                    C4879a.xxA.mo10055m(new C32622px());
                    AppMethodBeat.m2505o(65454);
                    return;
                }
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryRedDotImpl", "netscene topstory error");
                AppMethodBeat.m2505o(65454);
                return;
            }
            AppMethodBeat.m2505o(65454);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.b$3 */
    class C352963 extends C4884c<C9333fa> {
        C352963() {
            AppMethodBeat.m2504i(65455);
            this.xxI = C9333fa.class.getName().hashCode();
            AppMethodBeat.m2505o(65455);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(65456);
            C35295b.this.sAs = ((C34069a) C1720g.m3528K(C34069a.class)).mo54613a(C11745a.clicfg_topstory_top_tab_params, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
            AppMethodBeat.m2505o(65456);
            return false;
        }
    }

    public C35295b() {
        AppMethodBeat.m2504i(65457);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("mmsearch_reddot_new", this.sAp);
        this.sAm = new cht();
        C35295b.m57965c(this.sAm);
        cht cht = this.sAm;
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TOP_STORY_RED_XML_REC_STRING, (Object) "");
        if (!C5046bo.isNullOrNil(str)) {
            String[] split = str.split(",");
            if (split != null) {
                try {
                    if (split.length >= 13) {
                        C35295b.m57964a(cht, split);
                    }
                } catch (Exception e) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_RED_XML_REC_STRING, (Object) "");
                    C1720g.m3536RP().mo5239Ry().dsb();
                }
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_RED_XML_REC_STRING, (Object) "");
            C1720g.m3536RP().mo5239Ry().dsb();
        }
        cES();
        C4879a.xxA.mo10051b(this.sAt);
        AppMethodBeat.m2505o(65457);
    }

    public final boolean cEN() {
        AppMethodBeat.m2504i(65458);
        if (cFj()) {
            boolean z;
            if (C5046bo.isNullOrNil(this.sAm.cJb)) {
                z = true;
            } else if (this.sAm.xgA == 1) {
                z = true;
            } else if (this.sAm.uaV > C7243d.vxo) {
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", this.sAm.cJb, Integer.valueOf(this.sAm.uaV), Integer.valueOf(C7243d.vxo));
                z = true;
            } else {
                int i;
                if (this.sAm.fRS != 0) {
                    if (System.currentTimeMillis() > this.sAm.xgB + (this.sAm.fRS * 1000)) {
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", this.sAm.cJb);
                        z = true;
                    }
                }
                String str = "MicroMsg.TopStory.TopStoryRedDotImpl";
                String str2 = "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
                Object[] objArr = new Object[5];
                if (C46400aa.m87305HV(1) >= this.sAm.tZU) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = Integer.valueOf(this.sAm.tZU);
                objArr[2] = Integer.valueOf(C46400aa.m87305HV(1));
                objArr[3] = Long.valueOf(this.sAm.xgz);
                objArr[4] = Long.valueOf(C35295b.cEZ());
                C4990ab.m7417i(str, str2, objArr);
                if (C46400aa.m87305HV(1) < this.sAm.tZU || this.sAm.xgz <= C35295b.cEZ()) {
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
                    C14423an.m22644a(this.sAm, 104, 1, 0, 0, "");
                    bNs();
                }
            } else if (cFi()) {
                AppMethodBeat.m2505o(65458);
                return true;
            }
            AppMethodBeat.m2505o(65458);
            return false;
        }
        AppMethodBeat.m2505o(65458);
        return false;
    }

    public final boolean cEO() {
        AppMethodBeat.m2504i(65459);
        if (!cFj()) {
            AppMethodBeat.m2505o(65459);
            return false;
        } else if (((cht) this.sAn.getLast()) == null) {
            AppMethodBeat.m2505o(65459);
            return false;
        } else {
            AppMethodBeat.m2505o(65459);
            return true;
        }
    }

    private void bNs() {
        AppMethodBeat.m2504i(65460);
        this.sAm = new cht();
        C35295b.m57965c(this.sAm);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_RED_XML_REC_STRING, (Object) "");
        C1720g.m3536RP().mo5239Ry().dsb();
        if (this.sAo != null) {
            C35294a c35294a = this.sAo;
            C35295b.cEZ();
            c35294a.cFk();
        }
        AppMethodBeat.m2505o(65460);
    }

    /* renamed from: Fx */
    public final void mo56012Fx(int i) {
        AppMethodBeat.m2504i(65461);
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                bNs();
                C4879a.xxA.mo10055m(new C32622px());
                AppMethodBeat.m2505o(65461);
                return;
            case 7:
                synchronized (this.sAn) {
                    try {
                        this.sAn.clear();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(65461);
                            break;
                        }
                    }
                }
                cER();
                if (this.sAo != null) {
                    this.sAo.mo56006a(0, "", "", 0, 0, "", true);
                }
                C4879a.xxA.mo10055m(new C32622px());
                AppMethodBeat.m2505o(65461);
                return;
            case 8:
                C35295b.abx("");
                AppMethodBeat.m2505o(65461);
                return;
            case 10:
                mo56039m("", "", 0);
                break;
        }
        AppMethodBeat.m2505o(65461);
    }

    public final cht cEP() {
        return this.sAm;
    }

    public final void cEQ() {
        AppMethodBeat.m2504i(65462);
        if (this.sAm != null) {
            C14423an.m22645a(this.sAm.cJb, this.sAm.xgz, 1, 0, "", 0);
        }
        AppMethodBeat.m2505o(65462);
    }

    /* renamed from: A */
    public final void mo56011A(long j, boolean z) {
        AppMethodBeat.m2504i(65463);
        if (this.sAm == null || C5046bo.isNullOrNil(this.sAm.cJb)) {
            AppMethodBeat.m2505o(65463);
            return;
        }
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d, cur %d", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000));
        if (j < C35295b.cEZ() || j <= 0 || r0 + 3600 < j) {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, getRedDotTimestamp:%s", Long.valueOf(C35295b.cEZ()));
            AppMethodBeat.m2505o(65463);
        } else if (this.sAm == null || j >= this.sAm.xgz) {
            if (z) {
                C14423an.m22644a(this.sAm, 106, 1, 0, j, "");
            }
            bNs();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_REDDOT_TIMESTAMP_LONG, Long.valueOf(j));
            C1720g.m3536RP().mo5239Ry().dsb();
            AppMethodBeat.m2505o(65463);
        } else {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, showTime:%s", Long.valueOf(this.sAm.xgz));
            AppMethodBeat.m2505o(65463);
        }
    }

    /* renamed from: lC */
    public final void mo56038lC(long j) {
        AppMethodBeat.m2504i(65464);
        mo56011A(j, true);
        AppMethodBeat.m2505o(65464);
    }

    /* renamed from: a */
    public final void mo56016a(cht cht) {
        AppMethodBeat.m2504i(65465);
        if (!cFi()) {
            C14423an.m22644a(cht, 108, 1, 0, 0, "");
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String str = "MicroMsg.TopStory.TopStoryRedDotImpl";
        String str2 = "setTopStoryRedDot showTime new:%s, cur:%s, curTime:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(cht.xgz);
        objArr[1] = this.sAm == null ? BuildConfig.COMMAND : this.sAm.xgz;
        objArr[2] = Long.valueOf(currentTimeMillis);
        C4990ab.m7417i(str, str2, objArr);
        if (cht.xgz <= C35295b.cEZ()) {
            C14423an.m22644a(cht, 103, 1, 0, 0, "");
            C14423an.m22644a(cht, 109, 1, 0, 0, "r6|" + cht.xgz + "|" + C35295b.cEZ());
            AppMethodBeat.m2505o(65465);
        } else if (cht.xgz > 3600 + currentTimeMillis) {
            C14423an.m22644a(cht, 109, 1, 0, 0, "r10|" + cht.xgz + "|" + currentTimeMillis);
            AppMethodBeat.m2505o(65465);
        } else if (this.sAm == null || C5046bo.isNullOrNil(this.sAm.cJb) || this.sAm.xgz <= cht.xgz) {
            if (!(this.sAm == null || C5046bo.isNullOrNil(this.sAm.cJb))) {
                C14423an.m22644a(cht, 105, 1, 0, 0, cht.cJb);
            }
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot valid");
            this.sAm = cht;
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_RED_XML_REC_STRING, C35295b.m57966d(this.sAm));
            C1720g.m3536RP().mo5239Ry().dsb();
            if (cFi()) {
                C14423an.m22644a(this.sAm, 101, 1, 0, 0, "");
            }
            if (this.sAo != null) {
                this.sAo.mo56008as(this.sAm.cJb, this.sAm.xgz);
            }
            C4879a.xxA.mo10055m(new C32622px());
            AppMethodBeat.m2505o(65465);
        } else {
            C14423an.m22644a(cht, 105, 1, 0, 0, this.sAm.cJb);
            C14423an.m22644a(cht, 109, 1, 0, 0, "r9|" + cht.xgz + "|" + C35295b.cEZ());
            AppMethodBeat.m2505o(65465);
        }
    }

    /* JADX WARNING: Missing block: B:29:0x011d, code skipped:
            cER();
     */
    /* JADX WARNING: Missing block: B:30:0x0122, code skipped:
            if (r10.sAo == null) goto L_0x0161;
     */
    /* JADX WARNING: Missing block: B:31:0x0124, code skipped:
            r10.sAo.mo56005a(r10.sAn.size(), ((com.tencent.p177mm.protocal.protobuf.cht) r10.sAn.getFirst()).cJb, ((com.tencent.p177mm.protocal.protobuf.cht) r10.sAn.getLast()).cJb, ((com.tencent.p177mm.protocal.protobuf.cht) r10.sAn.getFirst()).fQi, ((com.tencent.p177mm.protocal.protobuf.cht) r10.sAn.getLast()).fQi, ((com.tencent.p177mm.protocal.protobuf.cht) r10.sAn.getLast()).extInfo);
     */
    /* JADX WARNING: Missing block: B:32:0x0161, code skipped:
            com.tencent.p177mm.sdk.p600b.C4879a.xxA.mo10055m(new com.tencent.p177mm.p230g.p231a.C32622px());
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(65466);
     */
    /* JADX WARNING: Missing block: B:47:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final void mo56018b(cht cht) {
        AppMethodBeat.m2504i(65466);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "start addCmtRedDot: %s", Integer.valueOf(cht.fQi));
        if (!cFi()) {
            C14423an.m22644a(cht, 108, 2, this.sAn.size(), 0, "");
        }
        if (cht.fQi <= C35295b.cFa()) {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid1, %s, %s", Integer.valueOf(cht.fQi), Integer.valueOf(C35295b.cFa()));
            C14423an.m22644a(cht, 103, 2, cEV(), 0, "");
            C14423an.m22644a(cht, 109, 2, cEV(), 0, "r6|" + cht.fQi + "|" + C35295b.cFa());
            AppMethodBeat.m2505o(65466);
            return;
        }
        synchronized (this.sAn) {
            try {
                int i;
                if (C5046bo.m7548ek(this.sAn)) {
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
                            C4990ab.m7416i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid3");
                            C14423an.m22644a(cht, 109, 2, cEV(), 0, "r11");
                            AppMethodBeat.m2505o(65466);
                            return;
                        }
                    }
                    i = i2;
                }
                this.sAn.add(i, cht);
                if (cFi()) {
                    C14423an.m22644a(cEW(), 101, 2, this.sAn.size(), 0, "");
                }
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot msgId:%s, showTime:%s", cht.cJb, Long.valueOf(cht.xgz));
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(65466);
                }
            }
        }
    }

    private void cER() {
        AppMethodBeat.m2504i(65467);
        synchronized (this.sAn) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                Iterator it = this.sAn.iterator();
                while (it.hasNext()) {
                    stringBuilder.append(C35295b.m57966d((cht) it.next())).append(";");
                }
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_CMT_RED_XML_REC_STRING, stringBuilder.toString());
                C1720g.m3536RP().mo5239Ry().dsb();
            } finally {
                AppMethodBeat.m2505o(65467);
            }
        }
    }

    public static void abx(String str) {
        AppMethodBeat.m2504i(65468);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "setHomeTabRedDot %s", str);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_HOME_TAB_RED_XML_REC_STRING, (Object) str);
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(65468);
    }

    /* renamed from: c */
    static void m57965c(cht cht) {
        cht.cIY = "";
        cht.cJb = "";
        cht.text = "";
    }

    /* renamed from: d */
    public static String m57966d(cht cht) {
        AppMethodBeat.m2504i(65469);
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{cht.cJb, Integer.valueOf(cht.xgA), Integer.valueOf(cht.uaV), Integer.valueOf(cht.uaW), Integer.valueOf(cht.uaU), Long.valueOf(cht.fRS), Integer.valueOf(cht.tZU), Long.valueOf(cht.xgB), cht.text, Integer.valueOf(cht.type), Integer.valueOf(cht.dtW), Long.valueOf(cht.xgz), cht.cIY, Integer.valueOf(cht.fQi), cht.extInfo});
        AppMethodBeat.m2505o(65469);
        return format;
    }

    /* renamed from: a */
    private static void m57964a(cht cht, String[] strArr) {
        AppMethodBeat.m2504i(65470);
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
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryRedDotImpl", "no seq");
            }
        }
        if (strArr.length > 14) {
            cht.extInfo = strArr[14];
            AppMethodBeat.m2505o(65470);
            return;
        }
        cht.extInfo = "";
        AppMethodBeat.m2505o(65470);
    }

    private void cES() {
        AppMethodBeat.m2504i(65471);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TOP_STORY_CMT_RED_XML_REC_STRING, (Object) "");
        if (!C5046bo.isNullOrNil(str)) {
            try {
                for (String str2 : str.split(";")) {
                    if (!C5046bo.isNullOrNil(str2)) {
                        String[] split = str2.split(",");
                        cht cht = new cht();
                        C35295b.m57964a(cht, split);
                        this.sAn.addLast(cht);
                    }
                }
                AppMethodBeat.m2505o(65471);
                return;
            } catch (Exception e) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_CMT_RED_XML_REC_STRING, (Object) "");
                C1720g.m3536RP().mo5239Ry().dsb();
            }
        }
        AppMethodBeat.m2505o(65471);
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
        AppMethodBeat.m2504i(65472);
        if (cFj()) {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", Integer.valueOf(this.sAn.size()));
            int size = this.sAn.size();
            AppMethodBeat.m2505o(65472);
            return size;
        }
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", Integer.valueOf(0));
        AppMethodBeat.m2505o(65472);
        return 0;
    }

    private int cEV() {
        AppMethodBeat.m2504i(65473);
        if (cFj()) {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", Integer.valueOf(this.sAn.size()));
            int size = this.sAn.size();
            AppMethodBeat.m2505o(65473);
            return size;
        }
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", Integer.valueOf(0));
        AppMethodBeat.m2505o(65473);
        return 0;
    }

    public final cht cEW() {
        cht cht;
        AppMethodBeat.m2504i(65474);
        synchronized (this.sAn) {
            try {
                if (C5046bo.m7548ek(this.sAn)) {
                    cht = null;
                } else {
                    cht = (cht) this.sAn.getLast();
                    AppMethodBeat.m2505o(65474);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(65474);
            }
        }
        return cht;
    }

    public final cht cEX() {
        cht cht;
        AppMethodBeat.m2504i(65475);
        synchronized (this.sAn) {
            try {
                if (C5046bo.m7548ek(this.sAn)) {
                    cht = null;
                } else {
                    cht = (cht) this.sAn.getFirst();
                    AppMethodBeat.m2505o(65475);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(65475);
            }
        }
        return cht;
    }

    /* renamed from: a */
    public final void mo56014a(long j, boolean z, int i, boolean z2) {
        AppMethodBeat.m2504i(65476);
        if (this.sAn.size() == 0) {
            AppMethodBeat.m2505o(65476);
        } else if (i <= C35295b.cFa()) {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickCmtRedDot invalid, seq:%s, curSeq:%s", Integer.valueOf(i), Integer.valueOf(C35295b.cFa()));
            AppMethodBeat.m2505o(65476);
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
                            AppMethodBeat.m2505o(65476);
                        }
                    }
                }
            }
            if (size != this.sAn.size()) {
                cER();
            }
            if (this.sAo != null) {
                if (this.sAn.size() > 0) {
                    this.sAo.mo56006a(this.sAn.size(), ((cht) this.sAn.getFirst()).cJb, ((cht) this.sAn.getLast()).cJb, ((cht) this.sAn.getFirst()).fQi, ((cht) this.sAn.getLast()).fQi, ((cht) this.sAn.getLast()).extInfo, z);
                } else {
                    this.sAo.mo56006a(0, "", "", 0, 0, "", z);
                }
            }
            if (z2) {
                cht cht = new cht();
                cht.cJb = str;
                cht.xgz = j;
                cht.fQi = i;
                C14423an.m22644a(cht, 106, 2, size, j, "");
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_CMTREDDOT_TIMESTAMP_LONG, Long.valueOf(j));
            C1720g.m3536RP().mo5239Ry().dsb();
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateCmtRedDotSeq %s", Integer.valueOf(i));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_CMTREDDOT_SEQ_INT, Integer.valueOf(i));
            C1720g.m3536RP().mo5239Ry().dsb();
            AppMethodBeat.m2505o(65476);
        }
    }

    /* renamed from: i */
    public final void mo56037i(long j, int i, boolean z) {
        AppMethodBeat.m2504i(65477);
        mo56014a(j, z, i, true);
        AppMethodBeat.m2505o(65477);
    }

    public final boolean cEY() {
        AppMethodBeat.m2504i(65478);
        if (C5046bo.m7548ek(this.sAn)) {
            AppMethodBeat.m2505o(65478);
            return false;
        } else if (((cht) this.sAn.getLast()).uaW == 1) {
            AppMethodBeat.m2505o(65478);
            return true;
        } else {
            AppMethodBeat.m2505o(65478);
            return false;
        }
    }

    /* renamed from: Fy */
    public final void mo56013Fy(int i) {
        AppMethodBeat.m2504i(65479);
        cht cEW = cEW();
        if (cEW != null) {
            C14423an.m22645a(cEW.cJb, cEW.xgz, 2, i, "", cEW.fQi);
        }
        AppMethodBeat.m2505o(65479);
    }

    /* renamed from: a */
    public final void mo56015a(C35294a c35294a) {
        this.sAo = c35294a;
    }

    /* renamed from: b */
    public final void mo56017b(C35294a c35294a) {
        if (this.sAo == c35294a) {
            this.sAo = null;
        }
    }

    public static long cEZ() {
        AppMethodBeat.m2504i(65480);
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TOP_STORY_REDDOT_TIMESTAMP_LONG, null);
        if (obj == null) {
            AppMethodBeat.m2505o(65480);
            return 0;
        }
        long longValue = ((Long) obj).longValue();
        AppMethodBeat.m2505o(65480);
        return longValue;
    }

    private static int cFa() {
        AppMethodBeat.m2504i(65481);
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TOP_STORY_CMTREDDOT_SEQ_INT, null);
        if (obj == null) {
            AppMethodBeat.m2505o(65481);
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        AppMethodBeat.m2505o(65481);
        return intValue;
    }

    public final String cFc() {
        AppMethodBeat.m2504i(65483);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TOP_STORY_HOME_TAB_RED_XML_REC_STRING, (Object) "");
        AppMethodBeat.m2505o(65483);
        return str;
    }

    public final void cFd() {
        AppMethodBeat.m2504i(65484);
        cht cht = new cht();
        cht.cJb = cFc();
        C14423an.m22644a(cht, 106, 3, 0, 0, "");
        C35295b.abx("");
        AppMethodBeat.m2505o(65484);
    }

    /* renamed from: m */
    public final void mo56039m(String str, String str2, long j) {
        AppMethodBeat.m2504i(65485);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "setUserIconRedDot %s, extInfo %s", str, str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", str);
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, str2);
            jSONObject.put("ts", j);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryRedDotImpl", e, "setUserIconRedDot error", new Object[0]);
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_USER_ICON_RED_XML_REC_STRING, jSONObject.toString());
        C1720g.m3536RP().mo5239Ry().dsb();
        if (!(C5046bo.isNullOrNil(str) || this.sAo == null)) {
            this.sAo.mo56009at(str, j);
        }
        AppMethodBeat.m2505o(65485);
    }

    public final String cFe() {
        AppMethodBeat.m2504i(65486);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TOP_STORY_USER_ICON_RED_XML_REC_STRING, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(65486);
            return str;
        }
        try {
            str = new JSONObject(str).optString("msgId", "");
            AppMethodBeat.m2505o(65486);
            return str;
        } catch (JSONException e) {
            str = "";
            AppMethodBeat.m2505o(65486);
            return str;
        }
    }

    public final long cFf() {
        AppMethodBeat.m2504i(65487);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TOP_STORY_USER_ICON_RED_XML_REC_STRING, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(65487);
            return 0;
        }
        try {
            long optInt = (long) new JSONObject(str).optInt("ts", 0);
            AppMethodBeat.m2505o(65487);
            return optInt;
        } catch (JSONException e) {
            AppMethodBeat.m2505o(65487);
            return 0;
        }
    }

    public final String cFg() {
        AppMethodBeat.m2504i(65488);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TOP_STORY_USER_ICON_RED_XML_REC_STRING, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(65488);
            return str;
        }
        try {
            str = new JSONObject(str).optString(IssueStorage.COLUMN_EXT_INFO);
            AppMethodBeat.m2505o(65488);
            return str;
        } catch (JSONException e) {
            str = "";
            AppMethodBeat.m2505o(65488);
            return str;
        }
    }

    public final void cFh() {
        AppMethodBeat.m2504i(65489);
        mo56039m("", "", 0);
        AppMethodBeat.m2505o(65489);
    }

    public final boolean cFi() {
        boolean z;
        AppMethodBeat.m2504i(65490);
        JSONObject adL = C29736ac.adL("discoverRecommendEntry");
        if (((C23167a) C1720g.m3528K(C23167a.class)).agO("labs_browse")) {
            if (((C23167a) C1720g.m3528K(C23167a.class)).mo38786xj("labs_browse")) {
                z = true;
            }
            z = false;
        } else {
            if (adL.optInt("entrySwitch") == 1) {
                z = true;
            }
            z = false;
        }
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryRedDotImpl", "recommend show %b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(65490);
        return z;
    }

    public final boolean cFj() {
        AppMethodBeat.m2504i(65491);
        if ((C7243d.vxo >= 654311424 || C7243d.vxs) && C37414c.isNullOrNil(this.sAs)) {
            this.sAs = ((C34069a) C1720g.m3528K(C34069a.class)).mo54613a(C11745a.clicfg_topstory_top_tab_params, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
        }
        try {
            JSONArray jSONArray = new JSONObject(this.sAs).getJSONArray("tabs");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getJSONObject(i).getInt("category") == 110) {
                    AppMethodBeat.m2505o(65491);
                    return true;
                }
            }
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.TopStory.TopStoryRedDotImpl", "parse tabconfig failed: %s", e.getMessage());
        }
        AppMethodBeat.m2505o(65491);
        return false;
    }

    public final boolean cFb() {
        AppMethodBeat.m2504i(65482);
        if (C5046bo.isNullOrNil((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TOP_STORY_HOME_TAB_RED_XML_REC_STRING, (Object) ""))) {
            AppMethodBeat.m2505o(65482);
            return false;
        }
        AppMethodBeat.m2505o(65482);
        return true;
    }
}
