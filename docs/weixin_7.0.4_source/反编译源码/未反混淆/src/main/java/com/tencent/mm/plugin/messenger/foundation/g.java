package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class g implements r {
    public final void a(tb tbVar, byte[] bArr, boolean z, t tVar) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_RUOZHU);
        switch (tbVar.wat) {
            case 1:
                ad adVar;
                bcr bcr = (bcr) new bcr().parseFrom(bArr);
                com.tencent.mm.kernel.g.RP().Ry().get(2, null);
                z Ry = com.tencent.mm.kernel.g.RP().Ry();
                ab.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", Integer.valueOf(bcr.wGW), Integer.valueOf(bcr.jBT), Integer.valueOf(bcr.vCi), Integer.valueOf(bcr.wHd));
                Object a = aa.a(bcr.wcB);
                Object a2 = aa.a(bcr.wyX);
                Object a3 = aa.a(bcr.wGX);
                Object a4 = aa.a(bcr.wGY);
                int i = bcr.vCf;
                ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(a);
                if (aoO == null || aoO.field_username == null || !aoO.field_username.equals(a)) {
                    adVar = new ad(a);
                } else {
                    adVar = aoO;
                }
                adVar.iy(bcr.guS);
                adVar.iB(a2);
                adVar.iW(RegionCodeDecoder.aC(bcr.guW, bcr.guO, bcr.guP));
                adVar.hA(bcr.guN);
                adVar.iQ(bcr.guQ);
                adVar.hv(bcr.wBX);
                adVar.iU(bcr.wBV);
                adVar.iE(bcr.wBW);
                adVar.hB(i);
                ((j) com.tencent.mm.kernel.g.K(j.class)).XM().Y(adVar);
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
                ab.d(str, stringBuilder.append(str2).toString());
                Ry.set(7, Integer.valueOf(bcr.jBT));
                if (bcr.guR != 0) {
                    bp bpVar = new bp();
                    bpVar.dub = 1;
                    bpVar.dtS = bcr.guN;
                    bpVar.signature = bcr.guQ;
                    bpVar.countryCode = bcr.guW;
                    bpVar.fnp = bcr.guO;
                    bpVar.fno = bcr.guP;
                    bpVar.dug = bcr.wBV;
                    ab.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + bpVar.dug + " nickName :" + bcr.wBW);
                    bp.a(bpVar);
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
                ab.i(str, stringBuilder.append(str2).toString());
                Ry.set(34, Integer.valueOf(bcr.vCi));
                Ry.set(8200, Boolean.valueOf(bo.a(Boolean.valueOf(1 == bcr.wGB.wcX), false)));
                Ry.set(8201, Integer.valueOf(bo.a(Integer.valueOf(bcr.wGB.wcY.wdb), 22)));
                Ry.set(8208, Integer.valueOf(bo.a(Integer.valueOf(bcr.wGB.wcY.wdc), 8)));
                Ry.set(66049, Integer.valueOf(bcr.wBT));
                Ry.set(66050, bcr.wBU);
                Ry.set(40, Integer.valueOf(bcr.wHd));
                av.fly.ak("last_login_use_voice", bcr.wHd);
                Ry.set(41, Integer.valueOf(bcr.wBX));
                Ry.set(43, bcr.wBW);
                ab.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + bcr.wHd + " WeiboFlag:" + bcr.wBX);
                Ry.set(868518889, Integer.valueOf(bcr.wGO));
                ab.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + bcr.wGO);
                Ry.set(42, bcr.guS);
                ab.d("MicroMsg.UserInfoSyncExtension", "userid:" + bcr.wfm + " username:" + bcr.wfn);
                Ry.set(65825, bcr.wfm);
                Ry.set(65826, bcr.wfn);
                ab.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + bcr.guT);
                ab.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + bcr.guU);
                ab.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + bcr.guV);
                str2 = bo.nullAsNil((String) com.tencent.mm.kernel.g.RP().Ry().get(65830, null));
                if (str2 == null || str2.length() == 0) {
                    Object obj = bcr.wHg;
                    if (obj != null && obj.length() > 0) {
                        com.tencent.mm.kernel.g.RP().Ry().set(65830, obj);
                    }
                }
                u.b(1, bcr);
                break;
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_RUOZHU);
    }
}
