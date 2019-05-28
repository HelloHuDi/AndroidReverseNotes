package com.tencent.p177mm.storage;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C8939o;
import com.tencent.p177mm.p184aj.p185a.C32232a;
import com.tencent.p177mm.p184aj.p185a.C37446b;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p230g.p711c.C6563at;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3469e;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3470f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7310be.C5133b;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;

/* renamed from: com.tencent.mm.storage.p */
public final class C40631p implements C3469e, C3470f {
    private C7310be xHS;

    public C40631p(C7310be c7310be) {
        AppMethodBeat.m2504i(11844);
        C41747z.aff();
        this.xHS = c7310be;
        this.xHS.mo15772a((C3470f) this);
        this.xHS.mo15773a((C3469e) this);
        AppMethodBeat.m2505o(11844);
    }

    /* renamed from: a */
    public final void mo7929a(C7620bi c7620bi, C7617ak c7617ak, boolean z, C3460c c3460c) {
        AppMethodBeat.m2504i(11846);
        if (c3460c == null) {
            C4990ab.m7412e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
            AppMethodBeat.m2505o(11846);
            return;
        }
        String str = c3460c.talker;
        if (z) {
            if (!(c7620bi == null || c7620bi.field_isSend == 1 || (C1831bh.m3769n(c7620bi) & 1) == 0)) {
                C4990ab.m7416i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
                c7617ak.mo16712jj(4194304);
            }
            if (c7620bi != null && C17903f.m28103kq(str)) {
                C4990ab.m7416i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
                c7617ak.mo16712jj(8388608);
            }
        } else {
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            if (!(aoO == null || !aoO.dsf() || C7486a.m12942jh(aoO.field_type) || c7620bi == null || c7620bi.field_isSend == 1 || c7617ak.mo16714jl(4194304) || (c7617ak.field_conversationTime >= C41747z.aff() && (C1831bh.m3769n(c7620bi) & 1) == 0))) {
                c7617ak.mo16712jj(4194304);
                C4990ab.m7417i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", str);
            }
            if (c7620bi != null && C17903f.m28103kq(str)) {
                C4990ab.m7417i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", str);
                c7617ak.mo16712jj(8388608);
            }
        }
        if (!(c3460c == null || c3460c.oqK.isEmpty() || c3460c.oqK.get(0) == null)) {
            c7617ak.mo14750hO(((C7620bi) c3460c.oqK.get(0)).field_isSend);
            if (c3460c.oqJ.equals("insert")) {
                c7617ak.xXq = (C7620bi) c3460c.oqK.get(c3460c.oqK.size() - 1);
            }
        }
        AppMethodBeat.m2505o(11846);
    }

    /* renamed from: b */
    public final void mo7930b(C7620bi c7620bi, C7617ak c7617ak, boolean z, C3460c c3460c) {
        int i;
        int i2;
        AppMethodBeat.m2504i(11847);
        C7310be XR = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR();
        String str = c3460c == null ? null : c3460c.talker;
        if (c3460c == null || !c3460c.oqJ.equals("delete") || c3460c.oqN <= 0) {
            i = 0;
        } else {
            i = c3460c.oqN;
        }
        if (c3460c == null || !c3460c.oqJ.equals("insert") || c3460c.oqM <= 0) {
            i2 = 0;
        } else {
            i2 = c3460c.oqM;
        }
        if (!C5046bo.isNullOrNil(c7617ak.field_parentRef)) {
            C7617ak aoZ = XR.aoZ(c7617ak.field_parentRef);
            if (aoZ != null && aoZ.mo16714jl(2097152)) {
                if (i2 > 0) {
                    if ((c3460c.oqJ.equals("insert") && c3460c.oqL > 0) || (c3460c.oqJ.equals("update") && aoZ.field_unReadCount + c3460c.oqL >= 0)) {
                        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                        if (aoO == null || !aoO.mo16673DX()) {
                            aoZ.mo14748hM(aoZ.field_unReadCount + i2);
                        } else {
                            aoZ.mo14754hS(aoZ.field_unReadMuteCount + i2);
                        }
                    }
                    XR.mo15774a(c7617ak, i, i2);
                }
                C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apm(c7617ak.field_parentRef));
                if (Rb == null || Rb.field_msgId <= 0) {
                    aoZ.dsI();
                } else {
                    aoZ.mo17068ap(Rb);
                    aoZ.setContent(Rb.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rb.field_content);
                    aoZ.mo14757jg(Integer.toString(Rb.getType()));
                    if (XR.mo15765Cb() != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        Rb.mo14794ju(c7617ak.field_parentRef);
                        Rb.setContent(aoZ.field_content);
                        XR.mo15765Cb().mo10533a(Rb, pString, pString2, pInt, true);
                        String ac = XR.mo15779ac(Rb.getType(), Rb.field_content);
                        aoZ.mo14758jh(C5046bo.nullAsNil(pString.value).concat(C5046bo.isNullOrNil(ac) ? "" : " " + C5046bo.nullAsNil(ac)));
                        aoZ.mo14759ji(pString2.value);
                        aoZ.mo14751hP(pInt.value);
                    }
                }
                if (XR.mo15767a(aoZ, c7617ak.field_parentRef) > 0) {
                    C4990ab.m7411d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", c7617ak.field_parentRef, Integer.valueOf(aoZ.field_unReadCount + i2));
                    XR.mo10120b(3, (C7298n) XR, c7617ak.field_parentRef);
                }
            } else if (aoZ == null || !"officialaccounts".equals(aoZ.field_username)) {
                if (aoZ != null && "appbrandcustomerservicemsg".equals(aoZ.field_username) && i2 > 0) {
                    if ((c3460c.oqJ.equals("insert") && c3460c.oqL > 0) || (c3460c.oqJ.equals("update") && aoZ.field_unReadCount + c3460c.oqL >= 0)) {
                        aoZ.mo14748hM(aoZ.field_unReadCount + i2);
                    }
                    XR.mo15774a(c7617ak, i, i2);
                    XR.mo15767a(aoZ, c7617ak.field_parentRef);
                }
            } else if (i2 > 0 && !C30309s.aVO() && ((c3460c.oqJ.equals("insert") && c3460c.oqL > 0) || (c3460c.oqJ.equals("update") && aoZ.field_unReadCount + c3460c.oqL >= 0))) {
                aoZ.mo14748hM(aoZ.field_unReadCount + i2);
                XR.mo15767a(aoZ, c7617ak.field_parentRef);
            }
        }
        m70168a(str, c7617ak, i2, i, c3460c);
        AppMethodBeat.m2505o(11847);
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0270 A:{SYNTHETIC, EDGE_INSN: B:87:0x0270->B:77:0x0270 ?: BREAK  , EDGE_INSN: B:87:0x0270->B:77:0x0270 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m70168a(String str, C7617ak c7617ak, int i, int i2, C3460c c3460c) {
        AppMethodBeat.m2504i(11848);
        if (!(c7617ak == null || c3460c == null || c3460c.jMj == -1 || !c7617ak.mo16714jl(8388608))) {
            C7620bi aM = ((C8939o) C1720g.m3528K(C8939o.class)).mo20357XP().mo74792aM(str, c3460c.jMj);
            C32232a fv = C41747z.aeU().mo60340fv(c3460c.jMj);
            C45142c aK = C41747z.aeT().mo60349aK(c3460c.jMj);
            if (aK.field_bizChatServId == null) {
                C4990ab.m7420w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
                AppMethodBeat.m2505o(11848);
                return;
            } else if (aM == null || aM.field_msgId == 0) {
                C4990ab.m7416i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker ".concat(String.valueOf(str)));
                fv.field_status = 0;
                fv.field_isSend = 0;
                fv.field_content = "";
                fv.field_msgType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                fv.field_unReadCount = 0;
                fv.field_digest = "";
                fv.field_digestUser = "";
                C41747z.aeU();
                C37446b.m63111a(fv, i2, i);
                C41747z.aeU().mo60337b(fv);
                AppMethodBeat.m2505o(11848);
                return;
            } else {
                C32232a c32232a;
                long j;
                Object obj;
                int i3;
                String cI;
                Iterator it;
                Object obj2;
                boolean isGroup = aK.isGroup();
                fv.field_brandUserName = str;
                if (aM.dtv()) {
                    fv.field_content = aM.dtW();
                } else {
                    fv.field_content = aM.field_content;
                }
                PString pString = new PString();
                this.xHS.mo15765Cb().mo10533a(aM, pString, new PString(), new PInt(), false);
                String str2 = pString.value;
                C45143j cH = C41747z.aeV().mo60356cH(aM.field_bizChatUserId);
                if (!isGroup) {
                    fv.field_digest = str2;
                    str2 = null;
                } else if (aM.field_isSend == 1 && cH != null) {
                    fv.field_digest = C4996ah.getContext().getString(C25738R.string.f9164ri) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2;
                    cH.field_userName = C4996ah.getContext().getString(C25738R.string.f9164ri);
                    str2 = null;
                } else if (cH == null || C5046bo.isNullOrNil(cH.field_userName)) {
                    fv.field_digest = str2;
                    str2 = null;
                } else {
                    fv.field_digest = cH.field_userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2;
                    str2 = cH.field_userName;
                }
                String ac = this.xHS.mo15779ac(aM.getType(), aM.field_content);
                String nullAsNil = C5046bo.nullAsNil(fv.field_digest);
                if (C5046bo.isNullOrNil(ac)) {
                    ac = "";
                } else {
                    ac = " " + C5046bo.nullAsNil(ac);
                }
                fv.field_digest = nullAsNil.concat(ac);
                fv.field_digestUser = "";
                fv.field_chatType = aK.field_chatType;
                fv.field_lastMsgID = aM.field_msgId;
                if (aM.bwt()) {
                    c32232a = fv;
                } else if (aM.field_status == 1) {
                    j = Long.MAX_VALUE;
                    c32232a = fv;
                    c32232a.field_lastMsgTime = j;
                    fv.field_status = aM.field_status;
                    fv.field_isSend = aM.field_isSend;
                    fv.field_msgType = Integer.toString(aM.getType());
                    fv.field_flag = C37446b.m63109a(fv, 1, aM.field_createTime);
                    obj = null;
                    if ((c3460c.oqJ.equals("insert") && c3460c.oqL > 0) || (c3460c.oqJ.equals("update") && fv.field_unReadCount + c3460c.oqL >= 0)) {
                        fv.field_unReadCount += c3460c.oqL;
                        fv.field_newUnReadCount += c3460c.oqL;
                        if (c3460c.oqL > 0 && aK.mo73052lc(1)) {
                            i3 = c7617ak.field_unReadCount - c3460c.oqL;
                            if (i3 > 0) {
                                c7617ak.mo14748hM(0);
                            } else {
                                c7617ak.mo14748hM(i3);
                            }
                            c7617ak.mo14754hS(c7617ak.field_unReadMuteCount + c3460c.oqL);
                            obj = 1;
                        }
                    }
                    if (c3460c.oqJ.equals("insert") && c3460c.oqK.size() > 0 && aK.isGroup()) {
                        cI = C41747z.aeV().mo60357cI(aM.field_talker);
                        it = c3460c.oqK.iterator();
                        while (true) {
                            obj2 = obj;
                            if (it.hasNext()) {
                                break;
                            }
                            C7620bi c7620bi = (C7620bi) it.next();
                            if (cI == null || c7620bi.field_isSend == 1 || !c7620bi.isText() || !c7620bi.apB(cI)) {
                                obj = obj2;
                            } else {
                                fv.field_atCount++;
                                c7617ak.mo14753hR(c7617ak.field_atCount + 1);
                                obj = 1;
                            }
                        }
                        obj = obj2;
                    }
                    C41747z.aeU();
                    C37446b.m63111a(fv, i2, i);
                    if (C5046bo.isNullOrNil(str2)) {
                        str2 = aK.mo73053mJ(aM.field_bizChatUserId);
                    }
                    C4990ab.m7417i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", str, aK.field_bizChatServId, aM.field_bizChatUserId, str2);
                    C41747z.aeU().mo60337b(fv);
                    if (obj != null) {
                        this.xHS.mo15767a(c7617ak, str);
                    }
                } else {
                    c32232a = fv;
                }
                j = aM.field_createTime;
                c32232a.field_lastMsgTime = j;
                fv.field_status = aM.field_status;
                fv.field_isSend = aM.field_isSend;
                fv.field_msgType = Integer.toString(aM.getType());
                fv.field_flag = C37446b.m63109a(fv, 1, aM.field_createTime);
                obj = null;
                fv.field_unReadCount += c3460c.oqL;
                fv.field_newUnReadCount += c3460c.oqL;
                i3 = c7617ak.field_unReadCount - c3460c.oqL;
                if (i3 > 0) {
                }
                c7617ak.mo14754hS(c7617ak.field_unReadMuteCount + c3460c.oqL);
                obj = 1;
                cI = C41747z.aeV().mo60357cI(aM.field_talker);
                it = c3460c.oqK.iterator();
                while (true) {
                    obj2 = obj;
                    if (it.hasNext()) {
                    }
                }
                obj = obj2;
                C41747z.aeU();
                C37446b.m63111a(fv, i2, i);
                if (C5046bo.isNullOrNil(str2)) {
                }
                C4990ab.m7417i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", str, aK.field_bizChatServId, aM.field_bizChatUserId, str2);
                C41747z.aeU().mo60337b(fv);
                if (obj != null) {
                }
            }
        }
        AppMethodBeat.m2505o(11848);
    }

    public final void aoj(String str) {
        AppMethodBeat.m2504i(11849);
        if (str != null && C1855t.m3913mZ(str) && C17903f.m28109rc(str)) {
            C7617ak aoZ = this.xHS.aoZ(str);
            if (aoZ == null) {
                AppMethodBeat.m2505o(11849);
                return;
            }
            C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apm(str));
            if (Rb != null && Rb.field_msgId > 0) {
                aoZ.mo17068ap(Rb);
                aoZ.setContent(Rb.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rb.field_content);
                aoZ.mo14757jg(Integer.toString(Rb.getType()));
                C5133b Cb = this.xHS.mo15765Cb();
                if (Cb != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    Rb.mo14794ju(str);
                    Rb.setContent(aoZ.field_content);
                    Cb.mo10533a(Rb, pString, pString2, pInt, true);
                    aoZ.mo14758jh(pString.value);
                    aoZ.mo14759ji(pString2.value);
                    aoZ.mo14751hP(pInt.value);
                } else {
                    aoZ.dsI();
                }
                this.xHS.mo15767a(aoZ, aoZ.field_username);
            }
            AppMethodBeat.m2505o(11849);
            return;
        }
        AppMethodBeat.m2505o(11849);
    }

    public static void aok(String str) {
        AppMethodBeat.m2504i(11850);
        C7310be XR = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR();
        C7617ak c7617ak = new C7617ak(str);
        c7617ak.mo14760jj("officialaccounts");
        C40631p.m70169b(c7617ak, XR);
        AppMethodBeat.m2505o(11850);
    }

    /* renamed from: b */
    public static void m70169b(C7617ak c7617ak, C7310be c7310be) {
        AppMethodBeat.m2504i(11851);
        if (c7617ak == null || c7310be == null) {
            AppMethodBeat.m2505o(11851);
            return;
        }
        if (C1855t.m3913mZ(c7617ak.field_username) && !C5046bo.isNullOrNil(c7617ak.field_parentRef)) {
            if (C30309s.aVO() && C1855t.m3956ny(c7617ak.field_parentRef)) {
                AppMethodBeat.m2505o(11851);
                return;
            }
            Object obj;
            C7617ak c7617ak2;
            Object obj2;
            C6563at aoZ = c7310be.aoZ(c7617ak.field_parentRef);
            C4990ab.m7419v("MicroMsg.BizConversationStorage", "postConvExt, username = %s, parentRef = %s", c7617ak.field_username, c7617ak.field_parentRef);
            if (c7617ak.field_parentRef.equals("officialaccounts")) {
                obj = null;
            } else {
                obj = 1;
            }
            if (aoZ == null) {
                aoZ = new C7617ak(c7617ak.field_parentRef);
                if (obj != null) {
                    aoZ.mo16712jj(2097152);
                }
                c7617ak2 = aoZ;
                obj2 = 1;
            } else {
                C6563at c7617ak22 = aoZ;
                obj2 = null;
            }
            if (obj != null && c7617ak22.field_attrflag == 0) {
                c7617ak22.mo16712jj(2097152);
                C4990ab.m7418v("MicroMsg.BizConversationStorage", "Enterprise cvs reset attr flag!");
            }
            C4990ab.m7417i("MicroMsg.BizConversationStorage", "enterprise cvs count is %d", Integer.valueOf(c7617ak22.field_unReadCount));
            C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apm(c7617ak.field_parentRef));
            if (Rb == null || Rb.field_msgId <= 0) {
                c7617ak22.dsI();
                C4990ab.m7417i("MicroMsg.BizConversationStorage", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", r2);
            } else {
                c7617ak22.mo17068ap(Rb);
                c7617ak22.setContent(Rb.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rb.field_content);
                c7617ak22.mo14757jg(Integer.toString(Rb.getType()));
                C5133b Cb = c7310be.mo15765Cb();
                if (Cb != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    Rb.mo14794ju(c7617ak.field_parentRef);
                    Rb.setContent(c7617ak22.field_content);
                    Cb.mo10533a(Rb, pString, pString2, pInt, true);
                    c7617ak22.mo14758jh(pString.value);
                    c7617ak22.mo14759ji(pString2.value);
                    c7617ak22.mo14751hP(pInt.value);
                }
            }
            Object obj3 = null;
            if (obj != null && c7310be.apl(c7617ak22.field_username) <= 0) {
                obj3 = 1;
            }
            if (obj3 != null) {
                c7310be.aoX(c7617ak22.field_username);
                AppMethodBeat.m2505o(11851);
                return;
            } else if (obj2 != null) {
                c7310be.mo15807d(c7617ak22);
                AppMethodBeat.m2505o(11851);
                return;
            } else {
                c7310be.mo15767a(c7617ak22, c7617ak22.field_username);
            }
        }
        AppMethodBeat.m2505o(11851);
    }

    /* renamed from: a */
    public final void mo7928a(C7620bi c7620bi, C7617ak c7617ak) {
        String str = null;
        AppMethodBeat.m2504i(11845);
        if (!(c7617ak == null || c7620bi == null || c7620bi.field_bizChatId == -1 || !c7617ak.mo16714jl(8388608))) {
            C45142c aK = C41747z.aeT().mo60349aK(c7620bi.field_bizChatId);
            String str2 = c7617ak.field_digest;
            if (C5046bo.isNullOrNil(c7620bi.field_bizChatUserId)) {
                C4990ab.m7421w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", aK.field_bizChatServId, aK.field_chatName);
            } else {
                String str3;
                C45143j cH = C41747z.aeV().mo60356cH(c7620bi.field_bizChatUserId);
                if (cH != null) {
                    str3 = cH.field_userName;
                } else {
                    str3 = null;
                }
                boolean equals = c7620bi.field_bizChatUserId.equals(C41747z.aeV().mo60357cI(c7620bi.field_talker));
                if (cH != null && equals) {
                    c7617ak.mo14758jh(C4996ah.getContext().getString(C25738R.string.f9164ri) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2);
                } else if (!(cH == null || C5046bo.isNullOrNil(cH.field_userName))) {
                    c7617ak.mo14758jh(cH.field_userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2);
                }
                if (!aK.isGroup()) {
                    if (equals || str3 == null || str3.length() <= 0 || str3.equals(aK.field_chatName)) {
                        C45143j cH2 = C41747z.aeV().mo60356cH(aK.field_bizChatServId);
                        if (cH2 != null) {
                            str = cH2.field_userName;
                        }
                        if (!(str == null || str.length() <= 0 || str.equals(aK.field_chatName))) {
                            aK.field_chatName = str;
                            C41747z.aeT().mo60350b(aK);
                        }
                    } else {
                        aK.field_chatName = str3;
                        C41747z.aeT().mo60350b(aK);
                        AppMethodBeat.m2505o(11845);
                        return;
                    }
                }
                AppMethodBeat.m2505o(11845);
                return;
            }
        }
        AppMethodBeat.m2505o(11845);
    }
}
