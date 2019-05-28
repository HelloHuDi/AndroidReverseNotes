package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.j.e;
import com.tencent.mm.plugin.sns.h.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.c;
import com.tencent.view.d;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g {
    private static int[] qGV = new int[]{50, 66, 68, 88, 99, 121, 123, 166, 168, 188, 199, d.MIC_PTU_MEISHI, d.MIC_PTU_ZIPAI_GRADIENT_LOLLY, d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI, d.MIC_PTU_YOUJIALI, 299, 369, 419, e.CTRL_INDEX, 666, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT};
    private static String qGp = "";
    private static g qGq = null;
    public long fKn = 0;
    public long jCF = 0;
    private StringBuffer jvt = new StringBuffer();
    public String qGA = "";
    public String qGB = "";
    public String qGC = "";
    public String qGD = "";
    public String qGE = "";
    public String qGF = "";
    public String qGG = "";
    public String qGH = "";
    public String qGI = "";
    public String qGJ = "";
    public String qGK = "";
    public String qGL = "";
    public String qGM = "";
    public String qGN = "";
    public String qGO = "";
    public String qGP = "";
    public String qGQ = "";
    public int qGR = -1;
    public String qGS = "";
    private List<List<Integer>> qGT = new LinkedList();
    private List<Integer> qGU = new LinkedList();
    private LinkedList<c> qGW = new LinkedList();
    public String qGn = "";
    public String qGr = "";
    public int qGs = 0;
    public int qGt = 0;
    public long qGu = 0;
    public long qGv = 0;
    public String qGw = "";
    public long qGx = 0;
    public long qGy = 0;
    public String qGz = "";

    public g() {
        AppMethodBeat.i(35883);
        AppMethodBeat.o(35883);
    }

    public static g cmv() {
        AppMethodBeat.i(35884);
        com.tencent.mm.kernel.g.RQ();
        g gVar;
        if (com.tencent.mm.kernel.g.RN().QY()) {
            c ll = com.tencent.mm.model.c.c.abi().ll("100068");
            String str = ll.field_rawXML;
            if (bo.isNullOrNil(str)) {
                str = "";
            }
            String x = com.tencent.mm.a.g.x(str.getBytes());
            if (qGq == null || !x.equals(qGp)) {
                ab.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
                qGq = new g();
                try {
                    Map dru = ll.dru();
                    str = "";
                    if (dru != null) {
                        str = (String) dru.get("SnsHBConfig");
                    }
                    if (bo.isNullOrNil(str)) {
                        str = "";
                    }
                    str = URLDecoder.decode(str, "UTF-8");
                    g gVar2 = qGq;
                    gVar2.jvt = new StringBuffer();
                    gVar2.qGW.clear();
                    Map z = br.z(str, "sysmsg");
                    if (z == null) {
                        ab.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", str);
                    } else {
                        gVar2.fKn = bo.anl((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
                        gVar2.jvt.append("BeginTime:" + gVar2.fKn + ";");
                        gVar2.jCF = bo.anl((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
                        gVar2.jvt.append("EndTime:" + gVar2.jCF + ";\n");
                        gVar2.qGs = bo.ank((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
                        gVar2.qGt = bo.ank((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
                        gVar2.jvt.append("SvrDownReqLimitLevelMin:" + gVar2.qGs + " SvrDownReqLimitLevelMax: " + gVar2.qGt + ";\n");
                        gVar2.qGx = bo.anl((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
                        gVar2.qGy = bo.anl((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
                        gVar2.qGz = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
                        gVar2.qGA = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
                        gVar2.qGB = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
                        gVar2.qGC = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
                        gVar2.qGD = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
                        gVar2.qGE = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
                        gVar2.qGG = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
                        gVar2.qGH = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
                        gVar2.qGF = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
                        gVar2.qGI = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
                        gVar2.qGJ = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
                        gVar2.qGQ = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
                        gVar2.qGR = bo.ank((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
                        gVar2.qGS = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
                        if (gVar2.qGR <= 0) {
                            ab.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + gVar2.qGR);
                            gVar2.qGR = 1;
                        }
                        gVar2.jvt.append("FullScreenID:" + gVar2.qGS + " BrowseBeginTime:" + gVar2.qGx + " BrowseEndTime:" + gVar2.qGy + " FullScreenTitle:" + gVar2.qGz + " FullScreenDescription:" + gVar2.qGA + " FullScreenQueryTips:" + gVar2.qGB + " FullScreenAcceptButtonText: " + gVar2.qGC);
                        gVar2.jvt.append("FullScreenRejectButtonText:" + gVar2.qGD + " ActionSheetOpenTips:" + gVar2.qGE + " ActionSheetOpenSuccTips:" + gVar2.qGG + " ActionSheetOpenFailTips:" + gVar2.qGH + " ActionSheetCloseTips:" + gVar2.qGF + " ActionSheetCloseSuccTips: " + gVar2.qGI + " ActionSheetCloseFailTips: " + gVar2.qGJ + "MaxPostFeedID: " + gVar2.qGQ + " MaxPostFeedCount:" + gVar2.qGR);
                        gVar2.qGK = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
                        gVar2.qGL = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
                        gVar2.qGM = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
                        gVar2.qGN = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
                        gVar2.qGO = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
                        gVar2.qGP = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
                        gVar2.jvt.append("AlertTipForHasUsed:" + gVar2.qGK + " AlertTipForObtainUsedRight:" + gVar2.qGL + " AlertTipForClosedBrowseSwitch:" + gVar2.qGM + " AlertButtonText:" + gVar2.qGN + " GoldenCameraTip:" + gVar2.qGO + " GoldenCameraTipID:" + gVar2.qGP);
                        int i = 0;
                        while (true) {
                            String str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                            Object[] objArr = new Object[2];
                            objArr[0] = i == 0 ? "" : String.valueOf(i);
                            objArr[1] = "RedPointID";
                            gVar2.qGn = bo.bc((String) z.get(String.format(str2, objArr)), "");
                            gVar2.jvt.append("RedPointID:" + gVar2.qGn + ";");
                            if (bo.isNullOrNil(gVar2.qGn)) {
                                break;
                            }
                            str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                            objArr = new Object[2];
                            objArr[0] = i == 0 ? "" : String.valueOf(i);
                            objArr[1] = "BeginTime";
                            gVar2.qGu = bo.anl((String) z.get(String.format(str2, objArr)));
                            gVar2.jvt.append("RedPointID_BeginTime:" + gVar2.qGu + ";");
                            str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                            objArr = new Object[2];
                            objArr[0] = i == 0 ? "" : String.valueOf(i);
                            objArr[1] = "EndTime";
                            gVar2.qGv = bo.anl((String) z.get(String.format(str2, objArr)));
                            gVar2.jvt.append("RedPointID_EndTime:" + gVar2.qGv + ";\n");
                            c cVar = new c();
                            cVar.qGn = gVar2.qGn;
                            cVar.fKn = gVar2.qGu;
                            cVar.jCF = gVar2.qGv;
                            gVar2.qGW.add(cVar);
                            i++;
                        }
                        gVar2.qGw = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
                        gVar2.jvt.append("PostTips:" + gVar2.qGw + ";");
                        gVar2.qGr = bo.bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
                        gVar2.jvt.append("EntranceTips:" + gVar2.qGr + ";");
                        gVar2.qGT.clear();
                        int i2 = 0;
                        while (true) {
                            int ank = bo.ank((String) z.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Count"));
                            gVar2.jvt.append("count: " + i2 + " | " + ank + ";\n");
                            if (ank == 0) {
                                break;
                            }
                            LinkedList linkedList = new LinkedList();
                            i = 0;
                            while (i < ank) {
                                int ank2 = bo.ank((String) z.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Amount" + (i == 0 ? "" : Integer.valueOf(i))));
                                linkedList.add(Integer.valueOf(ank2));
                                gVar2.jvt.append("AmountLevel : " + i2 + " index " + i + " val: " + ank2 + ";");
                                i++;
                            }
                            gVar2.qGT.add(linkedList);
                            i2++;
                        }
                        ab.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + gVar2.jvt.toString());
                    }
                    qGp = x;
                } catch (Exception e) {
                    ab.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + e.getMessage());
                }
            }
            gVar = qGq;
            AppMethodBeat.o(35884);
            return gVar;
        }
        gVar = new g();
        AppMethodBeat.o(35884);
        return gVar;
    }

    public static boolean cmw() {
        AppMethodBeat.i(35885);
        com.tencent.mm.kernel.g.RQ();
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
        AppMethodBeat.o(35885);
        return booleanValue;
    }

    public final void cmx() {
        AppMethodBeat.i(35886);
        i h = k.h(a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKPOST_STRING_SYNC);
        if (h.qQs == null || bo.isNullOrNil(h.qQs.postId)) {
            h.qQs = new com.tencent.mm.plugin.sns.h.g();
            h.qQs.postId = this.qGQ;
            h.qQs.qQq = 0;
        }
        if (bo.isNullOrNil(h.qQs.postId) || !h.qQs.postId.equals(this.qGQ)) {
            h.qQs = new com.tencent.mm.plugin.sns.h.g();
            h.qQs.postId = this.qGQ;
            h.qQs.qQq = 0;
        } else {
            com.tencent.mm.plugin.sns.h.g gVar = h.qQs;
            gVar.qQq--;
            if (h.qQs.qQq < 0) {
                h.qQs.qQq = 0;
            }
        }
        ab.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + h.qQs.qQq + " postId: " + this.qGQ + " " + bo.dpG().toString());
        try {
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKPOST_STRING_SYNC, new String(h.toByteArray(), Charset.forName("ISO-8859-1")));
        } catch (IOException e) {
            ab.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + e.getLocalizedMessage());
        }
        com.tencent.mm.sdk.b.a.xxA.m(new qy());
        AppMethodBeat.o(35886);
    }
}
