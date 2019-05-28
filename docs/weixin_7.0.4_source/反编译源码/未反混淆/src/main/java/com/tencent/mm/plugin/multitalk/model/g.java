package com.tencent.mm.plugin.multitalk.model;

import android.util.Base64;
import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.bg.f;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.bb;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g {
    private Map<String, Long> oGH = new ConcurrentHashMap();

    public g() {
        AppMethodBeat.i(54005);
        AppMethodBeat.o(54005);
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, a aVar) {
        AppMethodBeat.i(54006);
        String a = aa.a(aVar.eAB.vED);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + a + " buffer len " + decode.length);
        try {
            bb bbVar = (bb) e.a(new bb(), decode, decode.length);
            if (bbVar == null) {
                ab.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:".concat(String.valueOf(a)));
                AppMethodBeat.o(54006);
            } else if (this.oGH.get(bbVar.groupId) == null || ((Long) this.oGH.get(bbVar.groupId)).longValue() < bbVar.ApR) {
                this.oGH.put(bbVar.groupId, Long.valueOf(bbVar.ApR));
                cm cmVar = aVar.eAB;
                String a2 = aa.a(cmVar.vEB);
                String a3 = aa.a(cmVar.vEC);
                String str2 = (String) com.tencent.mm.kernel.g.RP().Ry().get(2, null);
                if (str2 == null) {
                    ab.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
                    AppMethodBeat.o(54006);
                    return;
                }
                String str3 = str2.equals(a2) ? a3 : a2;
                String str4 = bbVar.ApP;
                Object obj;
                String str5;
                Object obj2;
                if (bbVar.ApO == 1) {
                    ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
                    String[] strArr = bbVar.ApQ;
                    obj = null;
                    str5 = "";
                    for (av avVar : bbVar.AnQ) {
                        str5 = str5 + avVar.Aop + ",";
                        if (avVar.Aop != null && avVar.Aop.equals(str2)) {
                            ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(str5)));
                    obj2 = null;
                    for (String str6 : strArr) {
                        if (str6 != null && str6.equals(str2)) {
                            ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        p.bSh().Sk(str3);
                        p.bSh().bRS().remove(str3);
                    } else if (!(p.bSh().bRS().contains(str3) || obj2 == null)) {
                        p.bSh().bRS().add(str3);
                    }
                    if (str2.equals(str4)) {
                        p.bSf().c(str3, str4, false, false);
                    } else if (obj != null && obj2 == null) {
                        p.bSf().c(str3, str4, false, false);
                    } else if (obj == null || obj2 == null) {
                        p.bSf().c(str3, str4, true, false);
                    } else {
                        p.bSf().c(str3, str4, true, true);
                    }
                    p.bSh().a(str3, bbVar);
                    p.bSe().oFP.bR(bo.h((Integer) com.tencent.mm.kernel.g.RP().eJH.get(1)), r.Yz());
                    AppMethodBeat.o(54006);
                } else if (bbVar.ApO == 2) {
                    ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + bbVar.AnQ.length);
                    String[] strArr2 = bbVar.ApQ;
                    obj = null;
                    str5 = "";
                    for (av avVar2 : bbVar.AnQ) {
                        str5 = str5 + avVar2.Aop + ",";
                        if (avVar2.Aop != null && avVar2.Aop.equals(str2)) {
                            ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(str5)));
                    obj2 = null;
                    for (String str7 : strArr2) {
                        if (str7 != null && str7.equals(str2)) {
                            ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        if (!p.bSh().Sl(str3) && p.bSh().bRS().contains(str3) && p.bSh().ff(str3, str2)) {
                            p.bSf();
                            f.Si(str3);
                        }
                        p.bSh().Sk(str3);
                        p.bSh().bRS().remove(str3);
                    } else if (!(p.bSh().bRS().contains(str3) || r3 == null)) {
                        p.bSh().bRS().add(str3);
                    }
                    p.bSe().oFP.bR(bo.h((Integer) com.tencent.mm.kernel.g.RP().eJH.get(1)), r.Yz());
                    ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
                    h bSh = p.bSh();
                    ab.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", str3);
                    f RW = p.bSb().RW(str3);
                    if (RW == null) {
                        ab.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
                        bSh.a(str3, bbVar);
                        AppMethodBeat.o(54006);
                    } else if (RW.field_roomId != bbVar.sQS) {
                        ab.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + RW.field_roomId + "bannerinfo.roomid:" + bbVar.sQS);
                        AppMethodBeat.o(54006);
                    } else if (h.d(str3, bbVar)) {
                        bSh.Sm(str3);
                        AppMethodBeat.o(54006);
                    } else {
                        ab.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
                        AppMethodBeat.o(54006);
                    }
                } else if (bbVar.ApO == 0) {
                    ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
                    if (!p.bSh().Sl(str3) && p.bSh().bRS().contains(str3) && p.bSh().ff(str3, str2)) {
                        p.bSf();
                        f.Si(str3);
                    }
                    f bSf = p.bSf();
                    bi biVar = new bi();
                    biVar.setType(64);
                    biVar.eJ(System.currentTimeMillis());
                    biVar.setStatus(6);
                    biVar.setContent(ah.getContext().getString(R.string.d3c));
                    if (n.ms(str3)) {
                        biVar.ju(str3);
                        biVar.setContent(biVar.field_content);
                        ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Z(biVar);
                    }
                    if (!(bSf.oGu == null || !str3.equals(bSf.oGu.Aqe) || bSf.oGx.doT())) {
                        ab.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
                        bSf.oGu = null;
                        bSf.oGv = 0;
                        bSf.oGx.stopTimer();
                    }
                    p.bSh().Sc(str3);
                    p.bSh().Sk(str3);
                    p.bSh().bRS().remove(str3);
                    AppMethodBeat.o(54006);
                } else if (bbVar.ApO == 3) {
                    for (av avVar3 : bbVar.AnQ) {
                        if (avVar3.Aop != null && avVar3.Aop.equals(str2)) {
                            ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
                        }
                    }
                    AppMethodBeat.o(54006);
                } else {
                    ab.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + bbVar.ApO);
                    AppMethodBeat.o(54006);
                }
            } else {
                ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + bbVar.groupId + " is early than last msg, so we do not process,now return.");
                AppMethodBeat.o(54006);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:".concat(String.valueOf(a)), e.getMessage());
            AppMethodBeat.o(54006);
        }
    }
}
