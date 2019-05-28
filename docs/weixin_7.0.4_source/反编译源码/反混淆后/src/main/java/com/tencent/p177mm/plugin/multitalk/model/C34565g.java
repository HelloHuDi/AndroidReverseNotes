package com.tencent.p177mm.plugin.multitalk.model;

import android.util.Base64;
import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p203bg.C1310f;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24193av;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24215bb;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.multitalk.model.g */
public final class C34565g {
    private Map<String, Long> oGH = new ConcurrentHashMap();

    public C34565g() {
        AppMethodBeat.m2504i(54005);
        AppMethodBeat.m2505o(54005);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo55108a(String str, C1197a c1197a) {
        AppMethodBeat.m2504i(54006);
        String a = C1946aa.m4148a(c1197a.eAB.vED);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + a + " buffer len " + decode.length);
        try {
            C24215bb c24215bb = (C24215bb) C25510e.m40292a(new C24215bb(), decode, decode.length);
            if (c24215bb == null) {
                C4990ab.m7412e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:".concat(String.valueOf(a)));
                AppMethodBeat.m2505o(54006);
            } else if (this.oGH.get(c24215bb.groupId) == null || ((Long) this.oGH.get(c24215bb.groupId)).longValue() < c24215bb.ApR) {
                this.oGH.put(c24215bb.groupId, Long.valueOf(c24215bb.ApR));
                C7254cm c7254cm = c1197a.eAB;
                String a2 = C1946aa.m4148a(c7254cm.vEB);
                String a3 = C1946aa.m4148a(c7254cm.vEC);
                String str2 = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
                if (str2 == null) {
                    C4990ab.m7412e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
                    AppMethodBeat.m2505o(54006);
                    return;
                }
                String str3 = str2.equals(a2) ? a3 : a2;
                String str4 = c24215bb.ApP;
                Object obj;
                String str5;
                Object obj2;
                if (c24215bb.ApO == 1) {
                    C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
                    String[] strArr = c24215bb.ApQ;
                    obj = null;
                    str5 = "";
                    for (C24193av c24193av : c24215bb.AnQ) {
                        str5 = str5 + c24193av.Aop + ",";
                        if (c24193av.Aop != null && c24193av.Aop.equals(str2)) {
                            C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(str5)));
                    obj2 = null;
                    for (String str6 : strArr) {
                        if (str6 != null && str6.equals(str2)) {
                            C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        C34572p.bSh().mo55120Sk(str3);
                        C34572p.bSh().bRS().remove(str3);
                    } else if (!(C34572p.bSh().bRS().contains(str3) || obj2 == null)) {
                        C34572p.bSh().bRS().add(str3);
                    }
                    if (str2.equals(str4)) {
                        C34572p.bSf().mo24580c(str3, str4, false, false);
                    } else if (obj != null && obj2 == null) {
                        C34572p.bSf().mo24580c(str3, str4, false, false);
                    } else if (obj == null || obj2 == null) {
                        C34572p.bSf().mo24580c(str3, str4, true, false);
                    } else {
                        C34572p.bSf().mo24580c(str3, str4, true, true);
                    }
                    C34572p.bSh().mo55124a(str3, c24215bb);
                    C34572p.bSe().oFP.mo58364bR(C5046bo.m7567h((Integer) C1720g.m3536RP().eJH.get(1)), C1853r.m3846Yz());
                    AppMethodBeat.m2505o(54006);
                } else if (c24215bb.ApO == 2) {
                    C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + c24215bb.AnQ.length);
                    String[] strArr2 = c24215bb.ApQ;
                    obj = null;
                    str5 = "";
                    for (C24193av c24193av2 : c24215bb.AnQ) {
                        str5 = str5 + c24193av2.Aop + ",";
                        if (c24193av2.Aop != null && c24193av2.Aop.equals(str2)) {
                            C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(str5)));
                    obj2 = null;
                    for (String str7 : strArr2) {
                        if (str7 != null && str7.equals(str2)) {
                            C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        if (!C34572p.bSh().mo55121Sl(str3) && C34572p.bSh().bRS().contains(str3) && C34572p.bSh().mo55133ff(str3, str2)) {
                            C34572p.bSf();
                            C12630f.m20601Si(str3);
                        }
                        C34572p.bSh().mo55120Sk(str3);
                        C34572p.bSh().bRS().remove(str3);
                    } else if (!(C34572p.bSh().bRS().contains(str3) || r3 == null)) {
                        C34572p.bSh().bRS().add(str3);
                    }
                    C34572p.bSe().oFP.mo58364bR(C5046bo.m7567h((Integer) C1720g.m3536RP().eJH.get(1)), C1853r.m3846Yz());
                    C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
                    C34566h bSh = C34572p.bSh();
                    C4990ab.m7417i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", str3);
                    C1310f RW = C34572p.bSb().mo68858RW(str3);
                    if (RW == null) {
                        C4990ab.m7416i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
                        bSh.mo55124a(str3, c24215bb);
                        AppMethodBeat.m2505o(54006);
                    } else if (RW.field_roomId != c24215bb.sQS) {
                        C4990ab.m7416i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + RW.field_roomId + "bannerinfo.roomid:" + c24215bb.sQS);
                        AppMethodBeat.m2505o(54006);
                    } else if (C34566h.m56672d(str3, c24215bb)) {
                        bSh.mo55122Sm(str3);
                        AppMethodBeat.m2505o(54006);
                    } else {
                        C4990ab.m7412e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
                        AppMethodBeat.m2505o(54006);
                    }
                } else if (c24215bb.ApO == 0) {
                    C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
                    if (!C34572p.bSh().mo55121Sl(str3) && C34572p.bSh().bRS().contains(str3) && C34572p.bSh().mo55133ff(str3, str2)) {
                        C34572p.bSf();
                        C12630f.m20601Si(str3);
                    }
                    C12630f bSf = C34572p.bSf();
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.setType(64);
                    c7620bi.mo14775eJ(System.currentTimeMillis());
                    c7620bi.setStatus(6);
                    c7620bi.setContent(C4996ah.getContext().getString(C25738R.string.d3c));
                    if (C37921n.m64068ms(str3)) {
                        c7620bi.mo14794ju(str3);
                        c7620bi.setContent(c7620bi.field_content);
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
                    }
                    if (!(bSf.oGu == null || !str3.equals(bSf.oGu.Aqe) || bSf.oGx.doT())) {
                        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
                        bSf.oGu = null;
                        bSf.oGv = 0;
                        bSf.oGx.stopTimer();
                    }
                    C34572p.bSh().mo55117Sc(str3);
                    C34572p.bSh().mo55120Sk(str3);
                    C34572p.bSh().bRS().remove(str3);
                    AppMethodBeat.m2505o(54006);
                } else if (c24215bb.ApO == 3) {
                    for (C24193av c24193av3 : c24215bb.AnQ) {
                        if (c24193av3.Aop != null && c24193av3.Aop.equals(str2)) {
                            C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
                        }
                    }
                    AppMethodBeat.m2505o(54006);
                } else {
                    C4990ab.m7412e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + c24215bb.ApO);
                    AppMethodBeat.m2505o(54006);
                }
            } else {
                C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + c24215bb.groupId + " is early than last msg, so we do not process,now return.");
                AppMethodBeat.m2505o(54006);
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:".concat(String.valueOf(a)), e.getMessage());
            AppMethodBeat.m2505o(54006);
        }
    }
}
