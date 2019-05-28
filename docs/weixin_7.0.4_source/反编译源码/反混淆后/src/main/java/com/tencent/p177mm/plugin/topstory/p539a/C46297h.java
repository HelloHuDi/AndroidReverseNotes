package com.tencent.p177mm.plugin.topstory.p539a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.C46405w;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C14419a;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C29735b;
import com.tencent.p177mm.protocal.protobuf.abz;
import com.tencent.p177mm.protocal.protobuf.bsj;
import com.tencent.p177mm.protocal.protobuf.chn;
import com.tencent.p177mm.protocal.protobuf.chu;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.protocal.protobuf.cvi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.UnsupportedEncodingException;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.topstory.a.h */
public final class C46297h {
    /* renamed from: a */
    public static void m86863a(chv chv, chw chw, String str, String str2, String str3) {
        AppMethodBeat.m2504i(96369);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare 15035 %s", String.format("videosharereport=1&scene=%s&searchid=%s&docid=%s&videoid=%s&optype=%s&fromuser=%s&touser=%s&channelid=%s&optypes=%s&expand=%s", new Object[]{Integer.valueOf(chv.scene), chv.hlm, chw.ubA, chw.xgS, Integer.valueOf(0), str2, str3, Long.valueOf(chv.xgG), str, chw.xgV}));
        bsj bsj = new bsj();
        bsj.wUu = r0;
        C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
        AppMethodBeat.m2505o(96369);
    }

    /* renamed from: a */
    public static void m86861a(chn chn, String str, long j) {
        long j2;
        AppMethodBeat.m2504i(96370);
        if (chn.xgk.size() <= 0 || !"clickTopStory".equals(((chu) chn.xgk.get(0)).name)) {
            j2 = 0;
        } else {
            j2 = j - ((chu) chn.xgk.get(0)).timestamp;
        }
        int HV = C46400aa.m87305HV(1);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(chn.scene), chn.xgj, chn.cvF, Integer.valueOf(HV), str, Long.valueOf(j), Integer.valueOf(chn.sBd), Integer.valueOf(chn.xgl), chn.xgn, Long.valueOf(j2), chn.xgo}));
        C7060h.pYm.mo8374X(15466, r0);
        AppMethodBeat.m2505o(96370);
    }

    /* renamed from: Fz */
    public static void m86860Fz(int i) {
        AppMethodBeat.m2504i(96372);
        switch (i) {
            case -21020:
                C29735b.m47142kT(C29735b.ubS);
                break;
            case -21009:
                C29735b.m47142kT(C29735b.ubR);
                break;
            case -10012:
                C29735b.m47142kT(C29735b.ubP);
                break;
            case -10004:
                C29735b.m47142kT(C29735b.ubQ);
                break;
            case -1010:
                C29735b.m47142kT(C29735b.ubM);
                break;
            case -1007:
                C29735b.m47142kT(C29735b.ubN);
                break;
            case -1004:
                C29735b.m47142kT(C29735b.ubO);
                break;
            case 403:
                C29735b.m47142kT(C29735b.ubU);
                break;
            case 404:
                C29735b.m47142kT(C29735b.ubT);
                break;
            case 405:
                C29735b.m47142kT(C29735b.ubY);
                break;
            case 416:
                C29735b.m47142kT(C29735b.ubX);
                break;
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE /*502*/:
                C29735b.m47142kT(C29735b.ubW);
                break;
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /*503*/:
                C29735b.m47142kT(C29735b.ubV);
                break;
            default:
                C29735b.m47142kT(C29735b.uca);
                break;
        }
        C14419a.m22633kT(7);
        AppMethodBeat.m2505o(96372);
    }

    /* renamed from: a */
    public static void m86865a(chw chw, int i, String str, int i2) {
        int i3;
        AppMethodBeat.m2504i(96373);
        if (C5023at.isWifi(C4996ah.getContext())) {
            i3 = 2;
        } else if (C5023at.isConnected(C4996ah.getContext())) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        String str2 = chw != null ? chw.ubA : "";
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", String.format("%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i3), Integer.valueOf(i2)}));
        C7053e.pXa.mo8374X(15248, str2);
        AppMethodBeat.m2505o(96373);
    }

    /* renamed from: a */
    public static void m86864a(chv chv, chw chw, Set<abz> set, int i) {
        AppMethodBeat.m2504i(96374);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("isfeedback=1");
        stringBuffer.append("&feedtype=0");
        stringBuffer.append("&businesstype=2");
        stringBuffer.append("&itemtype=");
        stringBuffer.append(chw.xgW);
        stringBuffer.append("&scene=");
        stringBuffer.append(chv.scene);
        stringBuffer.append("&searchid=");
        stringBuffer.append(chv.hlm);
        stringBuffer.append("&clicktime=");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("&docid=");
        stringBuffer.append(chw.ubA);
        stringBuffer.append("&docpos=");
        stringBuffer.append(i);
        stringBuffer.append("&reasonid=");
        for (abz abz : set) {
            stringBuffer.append(abz.f16202id);
            stringBuffer.append("#");
        }
        stringBuffer.append("&reasonwording=");
        StringBuffer stringBuffer2 = new StringBuffer();
        for (abz abz2 : set) {
            stringBuffer2.append(abz2.cEh);
            stringBuffer2.append("#");
        }
        try {
            stringBuffer.append(C18178q.encode(stringBuffer2.toString(), "utf8"));
        } catch (UnsupportedEncodingException e) {
        }
        stringBuffer.append("&offset=");
        stringBuffer.append(i);
        stringBuffer.append("&sessionid=");
        stringBuffer.append(C46400aa.m87299HP(chv.scene));
        stringBuffer.append("&reserveexpand=");
        stringBuffer.append(chw.xgX);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", stringBuffer.toString());
        bsj bsj = new bsj();
        bsj.wUu = stringBuffer.toString();
        C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
        AppMethodBeat.m2505o(96374);
    }

    /* renamed from: a */
    public static final void m86862a(chv chv, long j, chw chw) {
        AppMethodBeat.m2504i(96375);
        if (j > 0) {
            String str = "videoflowbrowsereport=1&scene=%s&staytime=%s&channelid=%s&pageid=%s&nettype=%s&source=%s&expand=%s&searchid=%s";
            Object[] objArr = new Object[8];
            objArr[0] = Integer.valueOf(chv.scene);
            objArr[1] = Long.valueOf(j / 1000);
            objArr[2] = Long.valueOf(chv.xgG);
            objArr[3] = Integer.valueOf(3);
            objArr[4] = "";
            objArr[5] = Integer.valueOf(2);
            objArr[6] = chw != null ? chw.xgV : chv.xgD;
            objArr[7] = chv.hlm;
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", String.format(str, objArr));
            bsj bsj = new bsj();
            bsj.wUu = r0;
            C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
        }
        AppMethodBeat.m2505o(96375);
    }

    /* renamed from: do */
    public static final void m86868do(String str, int i) {
        AppMethodBeat.m2504i(96376);
        if (!C5046bo.isNullOrNil(str) && str.startsWith("wrd")) {
            C7060h.pYm.mo8378a(900, (long) i, 1, false);
        }
        AppMethodBeat.m2505o(96376);
    }

    /* renamed from: c */
    public static final void m86867c(String str, String str2, int i, long j) {
        AppMethodBeat.m2504i(96377);
        if (!C5046bo.isNullOrNil(str) && str.startsWith("wrd")) {
            try {
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryReportApiLogic", "kvReportTopStoryOpenWebViewError 15728 %s", String.format("%s,%s,%s,%s", new Object[]{C18178q.encode(str2, "utf8"), Integer.valueOf(i), str, Long.valueOf(j)}));
                C7060h.pYm.mo8374X(15728, r0);
                AppMethodBeat.m2505o(96377);
                return;
            } catch (UnsupportedEncodingException e) {
            }
        }
        AppMethodBeat.m2505o(96377);
    }

    /* renamed from: a */
    public static void m86866a(cvi cvi, C7620bi c7620bi) {
        String Yz;
        String str;
        int i;
        AppMethodBeat.m2504i(96371);
        if (C1855t.m3896kH(c7620bi.field_talker)) {
            if (c7620bi.field_isSend == 1) {
                Yz = C1853r.m3846Yz();
            } else {
                Yz = C1829bf.m3762oy(c7620bi.field_content);
            }
            str = c7620bi.field_talker;
            i = 2;
        } else {
            String str2;
            if (c7620bi.field_isSend == 1) {
                Yz = C1853r.m3846Yz();
                str2 = c7620bi.field_talker;
            } else {
                Yz = c7620bi.field_talker;
                str2 = C1853r.m3846Yz();
            }
            i = 1;
            str = str2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("isShareClick=1");
        stringBuffer.append("&relevant_vid=");
        stringBuffer.append(cvi.uaa);
        stringBuffer.append("&relevant_pre_searchid=");
        stringBuffer.append(cvi.uac);
        stringBuffer.append("&relevant_shared_openid=");
        stringBuffer.append(cvi.uad);
        stringBuffer.append("&rec_category=");
        if (cvi.uam > 0) {
            stringBuffer.append(cvi.uam);
        } else {
            stringBuffer.append(cvi.uae);
        }
        stringBuffer.append("&source=");
        stringBuffer.append(cvi.source);
        stringBuffer.append("&fromUser=");
        stringBuffer.append(Yz);
        stringBuffer.append("&fromScene=");
        stringBuffer.append(i);
        stringBuffer.append("&targetInfo=");
        stringBuffer.append(str);
        stringBuffer.append("&expand=");
        stringBuffer.append(cvi.uab);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", stringBuffer.toString());
        bsj bsj = new bsj();
        bsj.wUu = stringBuffer.toString();
        C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
        AppMethodBeat.m2505o(96371);
    }
}
