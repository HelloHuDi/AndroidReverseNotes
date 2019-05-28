package com.tencent.p177mm.plugin.sns.lucky.p1298a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C37791qy;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C41234e;
import com.tencent.p177mm.plugin.sns.p1025h.C29037i;
import com.tencent.p177mm.plugin.sns.p1025h.C43547g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.lucky.a.g */
public final class C21905g {
    private static int[] qGV = new int[]{50, 66, 68, 88, 99, 121, 123, 166, 168, 188, 199, C31128d.MIC_PTU_MEISHI, C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY, C31128d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI, C31128d.MIC_PTU_YOUJIALI, 299, 369, 419, C41234e.CTRL_INDEX, 666, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT};
    private static String qGp = "";
    private static C21905g qGq = null;
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
    private LinkedList<C43551c> qGW = new LinkedList();
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

    public C21905g() {
        AppMethodBeat.m2504i(35883);
        AppMethodBeat.m2505o(35883);
    }

    public static C21905g cmv() {
        AppMethodBeat.m2504i(35884);
        C1720g.m3537RQ();
        C21905g c21905g;
        if (C1720g.m3534RN().mo5161QY()) {
            C5141c ll = C18624c.abi().mo17131ll("100068");
            String str = ll.field_rawXML;
            if (C5046bo.isNullOrNil(str)) {
                str = "";
            }
            String x = C1178g.m2591x(str.getBytes());
            if (qGq == null || !x.equals(qGp)) {
                C4990ab.m7416i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
                qGq = new C21905g();
                try {
                    Map dru = ll.dru();
                    str = "";
                    if (dru != null) {
                        str = (String) dru.get("SnsHBConfig");
                    }
                    if (C5046bo.isNullOrNil(str)) {
                        str = "";
                    }
                    str = URLDecoder.decode(str, "UTF-8");
                    C21905g c21905g2 = qGq;
                    c21905g2.jvt = new StringBuffer();
                    c21905g2.qGW.clear();
                    Map z = C5049br.m7595z(str, "sysmsg");
                    if (z == null) {
                        C4990ab.m7417i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", str);
                    } else {
                        c21905g2.fKn = C5046bo.anl((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
                        c21905g2.jvt.append("BeginTime:" + c21905g2.fKn + ";");
                        c21905g2.jCF = C5046bo.anl((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
                        c21905g2.jvt.append("EndTime:" + c21905g2.jCF + ";\n");
                        c21905g2.qGs = C5046bo.ank((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
                        c21905g2.qGt = C5046bo.ank((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
                        c21905g2.jvt.append("SvrDownReqLimitLevelMin:" + c21905g2.qGs + " SvrDownReqLimitLevelMax: " + c21905g2.qGt + ";\n");
                        c21905g2.qGx = C5046bo.anl((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
                        c21905g2.qGy = C5046bo.anl((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
                        c21905g2.qGz = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
                        c21905g2.qGA = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
                        c21905g2.qGB = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
                        c21905g2.qGC = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
                        c21905g2.qGD = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
                        c21905g2.qGE = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
                        c21905g2.qGG = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
                        c21905g2.qGH = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
                        c21905g2.qGF = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
                        c21905g2.qGI = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
                        c21905g2.qGJ = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
                        c21905g2.qGQ = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
                        c21905g2.qGR = C5046bo.ank((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
                        c21905g2.qGS = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
                        if (c21905g2.qGR <= 0) {
                            C4990ab.m7416i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + c21905g2.qGR);
                            c21905g2.qGR = 1;
                        }
                        c21905g2.jvt.append("FullScreenID:" + c21905g2.qGS + " BrowseBeginTime:" + c21905g2.qGx + " BrowseEndTime:" + c21905g2.qGy + " FullScreenTitle:" + c21905g2.qGz + " FullScreenDescription:" + c21905g2.qGA + " FullScreenQueryTips:" + c21905g2.qGB + " FullScreenAcceptButtonText: " + c21905g2.qGC);
                        c21905g2.jvt.append("FullScreenRejectButtonText:" + c21905g2.qGD + " ActionSheetOpenTips:" + c21905g2.qGE + " ActionSheetOpenSuccTips:" + c21905g2.qGG + " ActionSheetOpenFailTips:" + c21905g2.qGH + " ActionSheetCloseTips:" + c21905g2.qGF + " ActionSheetCloseSuccTips: " + c21905g2.qGI + " ActionSheetCloseFailTips: " + c21905g2.qGJ + "MaxPostFeedID: " + c21905g2.qGQ + " MaxPostFeedCount:" + c21905g2.qGR);
                        c21905g2.qGK = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
                        c21905g2.qGL = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
                        c21905g2.qGM = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
                        c21905g2.qGN = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
                        c21905g2.qGO = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
                        c21905g2.qGP = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
                        c21905g2.jvt.append("AlertTipForHasUsed:" + c21905g2.qGK + " AlertTipForObtainUsedRight:" + c21905g2.qGL + " AlertTipForClosedBrowseSwitch:" + c21905g2.qGM + " AlertButtonText:" + c21905g2.qGN + " GoldenCameraTip:" + c21905g2.qGO + " GoldenCameraTipID:" + c21905g2.qGP);
                        int i = 0;
                        while (true) {
                            String str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                            Object[] objArr = new Object[2];
                            objArr[0] = i == 0 ? "" : String.valueOf(i);
                            objArr[1] = "RedPointID";
                            c21905g2.qGn = C5046bo.m7532bc((String) z.get(String.format(str2, objArr)), "");
                            c21905g2.jvt.append("RedPointID:" + c21905g2.qGn + ";");
                            if (C5046bo.isNullOrNil(c21905g2.qGn)) {
                                break;
                            }
                            str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                            objArr = new Object[2];
                            objArr[0] = i == 0 ? "" : String.valueOf(i);
                            objArr[1] = "BeginTime";
                            c21905g2.qGu = C5046bo.anl((String) z.get(String.format(str2, objArr)));
                            c21905g2.jvt.append("RedPointID_BeginTime:" + c21905g2.qGu + ";");
                            str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                            objArr = new Object[2];
                            objArr[0] = i == 0 ? "" : String.valueOf(i);
                            objArr[1] = "EndTime";
                            c21905g2.qGv = C5046bo.anl((String) z.get(String.format(str2, objArr)));
                            c21905g2.jvt.append("RedPointID_EndTime:" + c21905g2.qGv + ";\n");
                            C43551c c43551c = new C43551c();
                            c43551c.qGn = c21905g2.qGn;
                            c43551c.fKn = c21905g2.qGu;
                            c43551c.jCF = c21905g2.qGv;
                            c21905g2.qGW.add(c43551c);
                            i++;
                        }
                        c21905g2.qGw = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
                        c21905g2.jvt.append("PostTips:" + c21905g2.qGw + ";");
                        c21905g2.qGr = C5046bo.m7532bc((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
                        c21905g2.jvt.append("EntranceTips:" + c21905g2.qGr + ";");
                        c21905g2.qGT.clear();
                        int i2 = 0;
                        while (true) {
                            int ank = C5046bo.ank((String) z.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Count"));
                            c21905g2.jvt.append("count: " + i2 + " | " + ank + ";\n");
                            if (ank == 0) {
                                break;
                            }
                            LinkedList linkedList = new LinkedList();
                            i = 0;
                            while (i < ank) {
                                int ank2 = C5046bo.ank((String) z.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Amount" + (i == 0 ? "" : Integer.valueOf(i))));
                                linkedList.add(Integer.valueOf(ank2));
                                c21905g2.jvt.append("AmountLevel : " + i2 + " index " + i + " val: " + ank2 + ";");
                                i++;
                            }
                            c21905g2.qGT.add(linkedList);
                            i2++;
                        }
                        C4990ab.m7416i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + c21905g2.jvt.toString());
                    }
                    qGp = x;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + e.getMessage());
                }
            }
            c21905g = qGq;
            AppMethodBeat.m2505o(35884);
            return c21905g;
        }
        c21905g = new C21905g();
        AppMethodBeat.m2505o(35884);
        return c21905g;
    }

    public static boolean cmw() {
        AppMethodBeat.m2504i(35885);
        C1720g.m3537RQ();
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
        AppMethodBeat.m2505o(35885);
        return booleanValue;
    }

    public final void cmx() {
        AppMethodBeat.m2504i(35886);
        C29037i h = C39741k.m67966h(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKPOST_STRING_SYNC);
        if (h.qQs == null || C5046bo.isNullOrNil(h.qQs.postId)) {
            h.qQs = new C43547g();
            h.qQs.postId = this.qGQ;
            h.qQs.qQq = 0;
        }
        if (C5046bo.isNullOrNil(h.qQs.postId) || !h.qQs.postId.equals(this.qGQ)) {
            h.qQs = new C43547g();
            h.qQs.postId = this.qGQ;
            h.qQs.qQq = 0;
        } else {
            C43547g c43547g = h.qQs;
            c43547g.qQq--;
            if (h.qQs.qQq < 0) {
                h.qQs.qQq = 0;
            }
        }
        C4990ab.m7416i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + h.qQs.qQq + " postId: " + this.qGQ + " " + C5046bo.dpG().toString());
        try {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKPOST_STRING_SYNC, new String(h.toByteArray(), Charset.forName("ISO-8859-1")));
        } catch (IOException e) {
            C4990ab.m7420w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + e.getLocalizedMessage());
        }
        C4879a.xxA.mo10055m(new C37791qy());
        AppMethodBeat.m2505o(35886);
    }
}
