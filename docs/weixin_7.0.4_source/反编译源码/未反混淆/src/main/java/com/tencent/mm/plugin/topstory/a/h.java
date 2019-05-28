package com.tencent.mm.plugin.topstory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.UnsupportedEncodingException;
import java.util.Set;

public final class h {
    public static void a(chv chv, chw chw, String str, String str2, String str3) {
        AppMethodBeat.i(96369);
        ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare 15035 %s", String.format("videosharereport=1&scene=%s&searchid=%s&docid=%s&videoid=%s&optype=%s&fromuser=%s&touser=%s&channelid=%s&optypes=%s&expand=%s", new Object[]{Integer.valueOf(chv.scene), chv.hlm, chw.ubA, chw.xgS, Integer.valueOf(0), str2, str3, Long.valueOf(chv.xgG), str, chw.xgV}));
        bsj bsj = new bsj();
        bsj.wUu = r0;
        g.Rg().a(new w(bsj), 0);
        AppMethodBeat.o(96369);
    }

    public static void a(chn chn, String str, long j) {
        long j2;
        AppMethodBeat.i(96370);
        if (chn.xgk.size() <= 0 || !"clickTopStory".equals(((chu) chn.xgk.get(0)).name)) {
            j2 = 0;
        } else {
            j2 = j - ((chu) chn.xgk.get(0)).timestamp;
        }
        int HV = aa.HV(1);
        ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(chn.scene), chn.xgj, chn.cvF, Integer.valueOf(HV), str, Long.valueOf(j), Integer.valueOf(chn.sBd), Integer.valueOf(chn.xgl), chn.xgn, Long.valueOf(j2), chn.xgo}));
        com.tencent.mm.plugin.report.service.h.pYm.X(15466, r0);
        AppMethodBeat.o(96370);
    }

    public static void Fz(int i) {
        AppMethodBeat.i(96372);
        switch (i) {
            case -21020:
                b.kT(b.ubS);
                break;
            case -21009:
                b.kT(b.ubR);
                break;
            case -10012:
                b.kT(b.ubP);
                break;
            case -10004:
                b.kT(b.ubQ);
                break;
            case -1010:
                b.kT(b.ubM);
                break;
            case -1007:
                b.kT(b.ubN);
                break;
            case -1004:
                b.kT(b.ubO);
                break;
            case 403:
                b.kT(b.ubU);
                break;
            case 404:
                b.kT(b.ubT);
                break;
            case 405:
                b.kT(b.ubY);
                break;
            case 416:
                b.kT(b.ubX);
                break;
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE /*502*/:
                b.kT(b.ubW);
                break;
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /*503*/:
                b.kT(b.ubV);
                break;
            default:
                b.kT(b.uca);
                break;
        }
        a.kT(7);
        AppMethodBeat.o(96372);
    }

    public static void a(chw chw, int i, String str, int i2) {
        int i3;
        AppMethodBeat.i(96373);
        if (at.isWifi(ah.getContext())) {
            i3 = 2;
        } else if (at.isConnected(ah.getContext())) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        String str2 = chw != null ? chw.ubA : "";
        ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", String.format("%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i3), Integer.valueOf(i2)}));
        e.pXa.X(15248, str2);
        AppMethodBeat.o(96373);
    }

    public static void a(chv chv, chw chw, Set<abz> set, int i) {
        AppMethodBeat.i(96374);
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
            stringBuffer.append(abz.id);
            stringBuffer.append("#");
        }
        stringBuffer.append("&reasonwording=");
        StringBuffer stringBuffer2 = new StringBuffer();
        for (abz abz2 : set) {
            stringBuffer2.append(abz2.cEh);
            stringBuffer2.append("#");
        }
        try {
            stringBuffer.append(q.encode(stringBuffer2.toString(), "utf8"));
        } catch (UnsupportedEncodingException e) {
        }
        stringBuffer.append("&offset=");
        stringBuffer.append(i);
        stringBuffer.append("&sessionid=");
        stringBuffer.append(aa.HP(chv.scene));
        stringBuffer.append("&reserveexpand=");
        stringBuffer.append(chw.xgX);
        ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", stringBuffer.toString());
        bsj bsj = new bsj();
        bsj.wUu = stringBuffer.toString();
        g.Rg().a(new w(bsj), 0);
        AppMethodBeat.o(96374);
    }

    public static final void a(chv chv, long j, chw chw) {
        AppMethodBeat.i(96375);
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
            ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", String.format(str, objArr));
            bsj bsj = new bsj();
            bsj.wUu = r0;
            g.Rg().a(new w(bsj), 0);
        }
        AppMethodBeat.o(96375);
    }

    /* renamed from: do */
    public static final void m25do(String str, int i) {
        AppMethodBeat.i(96376);
        if (!bo.isNullOrNil(str) && str.startsWith("wrd")) {
            com.tencent.mm.plugin.report.service.h.pYm.a(900, (long) i, 1, false);
        }
        AppMethodBeat.o(96376);
    }

    public static final void c(String str, String str2, int i, long j) {
        AppMethodBeat.i(96377);
        if (!bo.isNullOrNil(str) && str.startsWith("wrd")) {
            try {
                ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "kvReportTopStoryOpenWebViewError 15728 %s", String.format("%s,%s,%s,%s", new Object[]{q.encode(str2, "utf8"), Integer.valueOf(i), str, Long.valueOf(j)}));
                com.tencent.mm.plugin.report.service.h.pYm.X(15728, r0);
                AppMethodBeat.o(96377);
                return;
            } catch (UnsupportedEncodingException e) {
            }
        }
        AppMethodBeat.o(96377);
    }

    public static void a(cvi cvi, bi biVar) {
        String Yz;
        String str;
        int i;
        AppMethodBeat.i(96371);
        if (t.kH(biVar.field_talker)) {
            if (biVar.field_isSend == 1) {
                Yz = r.Yz();
            } else {
                Yz = bf.oy(biVar.field_content);
            }
            str = biVar.field_talker;
            i = 2;
        } else {
            String str2;
            if (biVar.field_isSend == 1) {
                Yz = r.Yz();
                str2 = biVar.field_talker;
            } else {
                Yz = biVar.field_talker;
                str2 = r.Yz();
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
        ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", stringBuffer.toString());
        bsj bsj = new bsj();
        bsj.wUu = stringBuffer.toString();
        g.Rg().a(new w(bsj), 0);
        AppMethodBeat.o(96371);
    }
}
