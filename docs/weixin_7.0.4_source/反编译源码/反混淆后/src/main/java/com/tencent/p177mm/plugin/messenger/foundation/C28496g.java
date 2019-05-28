package com.tencent.p177mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21279r;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21280t;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21281u;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.bcr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.messenger.foundation.g */
public final class C28496g implements C21279r {
    /* renamed from: a */
    public final void mo36640a(C40573tb c40573tb, byte[] bArr, boolean z, C21280t c21280t) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_RUOZHU);
        switch (c40573tb.wat) {
            case 1:
                C7616ad c7616ad;
                bcr bcr = (bcr) new bcr().parseFrom(bArr);
                C1720g.m3536RP().mo5239Ry().get(2, null);
                C7580z Ry = C1720g.m3536RP().mo5239Ry();
                C4990ab.m7417i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", Integer.valueOf(bcr.wGW), Integer.valueOf(bcr.jBT), Integer.valueOf(bcr.vCi), Integer.valueOf(bcr.wHd));
                Object a = C1946aa.m4148a(bcr.wcB);
                Object a2 = C1946aa.m4148a(bcr.wyX);
                Object a3 = C1946aa.m4148a(bcr.wGX);
                Object a4 = C1946aa.m4148a(bcr.wGY);
                int i = bcr.vCf;
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(a);
                if (aoO == null || aoO.field_username == null || !aoO.field_username.equals(a)) {
                    c7616ad = new C7616ad(a);
                } else {
                    c7616ad = aoO;
                }
                c7616ad.mo14728iy(bcr.guS);
                c7616ad.mo14703iB(a2);
                c7616ad.mo14724iW(RegionCodeDecoder.m7796aC(bcr.guW, bcr.guO, bcr.guP));
                c7616ad.mo14685hA(bcr.guN);
                c7616ad.mo14718iQ(bcr.guQ);
                c7616ad.mo14697hv(bcr.wBX);
                c7616ad.mo14722iU(bcr.wBV);
                c7616ad.mo14706iE(bcr.wBW);
                c7616ad.mo14686hB(i);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15701Y(c7616ad);
                Ry.set(2, a);
                Ry.set(4, a2);
                Ry.set(5, a3);
                Ry.set(6, a4);
                Ry.set(9, Integer.valueOf(i));
                String str = "MicroMsg.UserInfoSyncExtension";
                StringBuilder stringBuilder = new StringBuilder("doCmd : status ");
                int i2 = bcr.jBT;
                String str2 = "code=" + Integer.toHexString(i2) + ", status = " + i2;
                if ((i2 & 1) != 0) {
                    str2 = str2 + ", open";
                }
                if ((i2 & 2) != 0) {
                    str2 = str2 + ", email-verified";
                }
                if ((i2 & 4) != 0) {
                    str2 = str2 + ", mobile-verified";
                }
                if ((i2 & 8) != 0) {
                    str2 = str2 + ", hide-qq-search";
                }
                if ((i2 & 16) != 0) {
                    str2 = str2 + ", hide-qq-promote";
                }
                if ((i2 & 32) != 0) {
                    str2 = str2 + ", need-verify";
                }
                if ((i2 & 64) != 0) {
                    str2 = str2 + ", has-qq-msg";
                }
                if ((i2 & 128) != 0) {
                    str2 = str2 + ", no-qq-promote";
                }
                if ((i2 & 256) != 0) {
                    str2 = str2 + ", no-mobile-promote";
                }
                if ((i2 & 512) != 0) {
                    str2 = str2 + ", hide-mobile_search";
                }
                if ((i2 & 4096) != 0) {
                    str2 = str2 + ", open-float-bottle";
                }
                if ((i2 & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                    str2 = str2 + ", bind but not upload";
                }
                C4990ab.m7410d(str, stringBuilder.append(str2).toString());
                Ry.set(7, Integer.valueOf(bcr.jBT));
                if (bcr.guR != 0) {
                    C32782bp c32782bp = new C32782bp();
                    c32782bp.dub = 1;
                    c32782bp.dtS = bcr.guN;
                    c32782bp.signature = bcr.guQ;
                    c32782bp.countryCode = bcr.guW;
                    c32782bp.fnp = bcr.guO;
                    c32782bp.fno = bcr.guP;
                    c32782bp.dug = bcr.wBV;
                    C4990ab.m7410d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + c32782bp.dug + " nickName :" + bcr.wBW);
                    C32782bp.m53559a(c32782bp);
                }
                str = "MicroMsg.UserInfoSyncExtension";
                stringBuilder = new StringBuilder("userinfo Plugstate: ");
                i2 = bcr.vCi;
                str2 = "code=" + Integer.toHexString(i2) + ", pluginFlag = " + i2;
                if ((i2 & 1) != 0) {
                    str2 = str2 + ", QQMAIL_UNINSTALL";
                } else {
                    str2 = str2 + ", QQMAIL_INSTALL";
                }
                if ((i2 & 2) != 0) {
                    str2 = str2 + ", PM_UNINSTALL";
                } else {
                    str2 = str2 + ", PM_INSTALL";
                }
                if ((i2 & 4) != 0) {
                    str2 = str2 + ", FM_UNINSTALL";
                } else {
                    str2 = str2 + ", FM_INSTALL";
                }
                if ((i2 & 8) != 0) {
                    str2 = str2 + ", WEIBO_UNINSTALL";
                } else {
                    str2 = str2 + ", WEIBO_INSTALL";
                }
                if ((i2 & 16) != 0) {
                    str2 = str2 + ", MEDIANOTE_UNINSTALL";
                } else {
                    str2 = str2 + ", MEDIANOTE_INSTALL";
                }
                if ((i2 & 32) != 0) {
                    str2 = str2 + ", QMSG_UNINSTALL";
                } else {
                    str2 = str2 + ", QMSG_INSTALL";
                }
                if ((i2 & 64) != 0) {
                    str2 = str2 + ", BOTTLE_UNINSTALL";
                } else {
                    str2 = str2 + ", BOTTLE_INSTALL";
                }
                if ((i2 & 128) != 0) {
                    str2 = str2 + ", QSYNC_UNISTALL";
                } else {
                    str2 = str2 + ", QSYNC_INSTALL";
                }
                if ((i2 & 256) != 0) {
                    str2 = str2 + ", SHAKE_UNISTALL";
                } else {
                    str2 = str2 + ", SHAKE_INSTALL";
                }
                if ((i2 & 512) != 0) {
                    str2 = str2 + ", LBS_UNISTALL";
                } else {
                    str2 = str2 + ", LBS_INSTALL";
                }
                if ((i2 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                    str2 = str2 + ", BOTTLE_CHART_INSTALL";
                } else {
                    str2 = str2 + ", BOTTLE_CHART_INSTALL";
                }
                if ((i2 & 4096) != 0) {
                    str2 = str2 + ",CHECKQQF_UNINSTALL";
                } else {
                    str2 = str2 + ",CHECKQQF_INSTALL";
                }
                if ((i2 & 32768) != 0) {
                    str2 = str2 + ",MM_FEEDSAPP_UNINSTALL";
                } else {
                    str2 = str2 + ",MM_FEEDSAPP_INSTALL";
                }
                C4990ab.m7416i(str, stringBuilder.append(str2).toString());
                Ry.set(34, Integer.valueOf(bcr.vCi));
                Ry.set(8200, Boolean.valueOf(C5046bo.m7517a(Boolean.valueOf(1 == bcr.wGB.wcX), false)));
                Ry.set(8201, Integer.valueOf(C5046bo.m7512a(Integer.valueOf(bcr.wGB.wcY.wdb), 22)));
                Ry.set(8208, Integer.valueOf(C5046bo.m7512a(Integer.valueOf(bcr.wGB.wcY.wdc), 8)));
                Ry.set(66049, Integer.valueOf(bcr.wBT));
                Ry.set(66050, bcr.wBU);
                Ry.set(40, Integer.valueOf(bcr.wHd));
                C6665av.fly.mo14897ak("last_login_use_voice", bcr.wHd);
                Ry.set(41, Integer.valueOf(bcr.wBX));
                Ry.set(43, bcr.wBW);
                C4990ab.m7410d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + bcr.wHd + " WeiboFlag:" + bcr.wBX);
                Ry.set(868518889, Integer.valueOf(bcr.wGO));
                C4990ab.m7410d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + bcr.wGO);
                Ry.set(42, bcr.guS);
                C4990ab.m7410d("MicroMsg.UserInfoSyncExtension", "userid:" + bcr.wfm + " username:" + bcr.wfn);
                Ry.set(65825, bcr.wfm);
                Ry.set(65826, bcr.wfn);
                C4990ab.m7410d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + bcr.guT);
                C4990ab.m7410d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + bcr.guU);
                C4990ab.m7410d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + bcr.guV);
                str2 = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(65830, null));
                if (str2 == null || str2.length() == 0) {
                    Object obj = bcr.wHg;
                    if (obj != null && obj.length() > 0) {
                        C1720g.m3536RP().mo5239Ry().set(65830, obj);
                    }
                }
                C21281u.m32653b(1, bcr);
                break;
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_RUOZHU);
    }
}
