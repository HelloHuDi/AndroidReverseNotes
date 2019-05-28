package com.tencent.mm.storage;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.aj.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.at;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;

public final class p implements e, f {
    private be xHS;

    public p(be beVar) {
        AppMethodBeat.i(11844);
        z.aff();
        this.xHS = beVar;
        this.xHS.a((f) this);
        this.xHS.a((e) this);
        AppMethodBeat.o(11844);
    }

    public final void a(bi biVar, ak akVar, boolean z, c cVar) {
        AppMethodBeat.i(11846);
        if (cVar == null) {
            ab.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
            AppMethodBeat.o(11846);
            return;
        }
        String str = cVar.talker;
        if (z) {
            if (!(biVar == null || biVar.field_isSend == 1 || (bh.n(biVar) & 1) == 0)) {
                ab.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
                akVar.jj(4194304);
            }
            if (biVar != null && com.tencent.mm.aj.f.kq(str)) {
                ab.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
                akVar.jj(8388608);
            }
        } else {
            ad aoO = ((j) g.K(j.class)).XM().aoO(str);
            if (!(aoO == null || !aoO.dsf() || a.jh(aoO.field_type) || biVar == null || biVar.field_isSend == 1 || akVar.jl(4194304) || (akVar.field_conversationTime >= z.aff() && (bh.n(biVar) & 1) == 0))) {
                akVar.jj(4194304);
                ab.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", str);
            }
            if (biVar != null && com.tencent.mm.aj.f.kq(str)) {
                ab.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", str);
                akVar.jj(8388608);
            }
        }
        if (!(cVar == null || cVar.oqK.isEmpty() || cVar.oqK.get(0) == null)) {
            akVar.hO(((bi) cVar.oqK.get(0)).field_isSend);
            if (cVar.oqJ.equals("insert")) {
                akVar.xXq = (bi) cVar.oqK.get(cVar.oqK.size() - 1);
            }
        }
        AppMethodBeat.o(11846);
    }

    public final void b(bi biVar, ak akVar, boolean z, c cVar) {
        int i;
        int i2;
        AppMethodBeat.i(11847);
        be XR = ((j) g.K(j.class)).XR();
        String str = cVar == null ? null : cVar.talker;
        if (cVar == null || !cVar.oqJ.equals("delete") || cVar.oqN <= 0) {
            i = 0;
        } else {
            i = cVar.oqN;
        }
        if (cVar == null || !cVar.oqJ.equals("insert") || cVar.oqM <= 0) {
            i2 = 0;
        } else {
            i2 = cVar.oqM;
        }
        if (!bo.isNullOrNil(akVar.field_parentRef)) {
            ak aoZ = XR.aoZ(akVar.field_parentRef);
            if (aoZ != null && aoZ.jl(2097152)) {
                if (i2 > 0) {
                    if ((cVar.oqJ.equals("insert") && cVar.oqL > 0) || (cVar.oqJ.equals("update") && aoZ.field_unReadCount + cVar.oqL >= 0)) {
                        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
                        if (aoO == null || !aoO.DX()) {
                            aoZ.hM(aoZ.field_unReadCount + i2);
                        } else {
                            aoZ.hS(aoZ.field_unReadMuteCount + i2);
                        }
                    }
                    XR.a(akVar, i, i2);
                }
                bi Rb = ((j) g.K(j.class)).bOr().Rb(((j) g.K(j.class)).XR().apm(akVar.field_parentRef));
                if (Rb == null || Rb.field_msgId <= 0) {
                    aoZ.dsI();
                } else {
                    aoZ.ap(Rb);
                    aoZ.setContent(Rb.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rb.field_content);
                    aoZ.jg(Integer.toString(Rb.getType()));
                    if (XR.Cb() != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        Rb.ju(akVar.field_parentRef);
                        Rb.setContent(aoZ.field_content);
                        XR.Cb().a(Rb, pString, pString2, pInt, true);
                        String ac = XR.ac(Rb.getType(), Rb.field_content);
                        aoZ.jh(bo.nullAsNil(pString.value).concat(bo.isNullOrNil(ac) ? "" : " " + bo.nullAsNil(ac)));
                        aoZ.ji(pString2.value);
                        aoZ.hP(pInt.value);
                    }
                }
                if (XR.a(aoZ, akVar.field_parentRef) > 0) {
                    ab.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", akVar.field_parentRef, Integer.valueOf(aoZ.field_unReadCount + i2));
                    XR.b(3, (n) XR, akVar.field_parentRef);
                }
            } else if (aoZ == null || !"officialaccounts".equals(aoZ.field_username)) {
                if (aoZ != null && "appbrandcustomerservicemsg".equals(aoZ.field_username) && i2 > 0) {
                    if ((cVar.oqJ.equals("insert") && cVar.oqL > 0) || (cVar.oqJ.equals("update") && aoZ.field_unReadCount + cVar.oqL >= 0)) {
                        aoZ.hM(aoZ.field_unReadCount + i2);
                    }
                    XR.a(akVar, i, i2);
                    XR.a(aoZ, akVar.field_parentRef);
                }
            } else if (i2 > 0 && !s.aVO() && ((cVar.oqJ.equals("insert") && cVar.oqL > 0) || (cVar.oqJ.equals("update") && aoZ.field_unReadCount + cVar.oqL >= 0))) {
                aoZ.hM(aoZ.field_unReadCount + i2);
                XR.a(aoZ, akVar.field_parentRef);
            }
        }
        a(str, akVar, i2, i, cVar);
        AppMethodBeat.o(11847);
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0270 A:{SYNTHETIC, EDGE_INSN: B:87:0x0270->B:77:0x0270 ?: BREAK  , EDGE_INSN: B:87:0x0270->B:77:0x0270 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(String str, ak akVar, int i, int i2, c cVar) {
        AppMethodBeat.i(11848);
        if (!(akVar == null || cVar == null || cVar.jMj == -1 || !akVar.jl(8388608))) {
            bi aM = ((o) g.K(o.class)).XP().aM(str, cVar.jMj);
            com.tencent.mm.aj.a.a fv = z.aeU().fv(cVar.jMj);
            com.tencent.mm.aj.a.c aK = z.aeT().aK(cVar.jMj);
            if (aK.field_bizChatServId == null) {
                ab.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
                AppMethodBeat.o(11848);
                return;
            } else if (aM == null || aM.field_msgId == 0) {
                ab.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker ".concat(String.valueOf(str)));
                fv.field_status = 0;
                fv.field_isSend = 0;
                fv.field_content = "";
                fv.field_msgType = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                fv.field_unReadCount = 0;
                fv.field_digest = "";
                fv.field_digestUser = "";
                z.aeU();
                b.a(fv, i2, i);
                z.aeU().b(fv);
                AppMethodBeat.o(11848);
                return;
            } else {
                com.tencent.mm.aj.a.a aVar;
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
                this.xHS.Cb().a(aM, pString, new PString(), new PInt(), false);
                String str2 = pString.value;
                com.tencent.mm.aj.a.j cH = z.aeV().cH(aM.field_bizChatUserId);
                if (!isGroup) {
                    fv.field_digest = str2;
                    str2 = null;
                } else if (aM.field_isSend == 1 && cH != null) {
                    fv.field_digest = ah.getContext().getString(R.string.ri) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2;
                    cH.field_userName = ah.getContext().getString(R.string.ri);
                    str2 = null;
                } else if (cH == null || bo.isNullOrNil(cH.field_userName)) {
                    fv.field_digest = str2;
                    str2 = null;
                } else {
                    fv.field_digest = cH.field_userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2;
                    str2 = cH.field_userName;
                }
                String ac = this.xHS.ac(aM.getType(), aM.field_content);
                String nullAsNil = bo.nullAsNil(fv.field_digest);
                if (bo.isNullOrNil(ac)) {
                    ac = "";
                } else {
                    ac = " " + bo.nullAsNil(ac);
                }
                fv.field_digest = nullAsNil.concat(ac);
                fv.field_digestUser = "";
                fv.field_chatType = aK.field_chatType;
                fv.field_lastMsgID = aM.field_msgId;
                if (aM.bwt()) {
                    aVar = fv;
                } else if (aM.field_status == 1) {
                    j = Long.MAX_VALUE;
                    aVar = fv;
                    aVar.field_lastMsgTime = j;
                    fv.field_status = aM.field_status;
                    fv.field_isSend = aM.field_isSend;
                    fv.field_msgType = Integer.toString(aM.getType());
                    fv.field_flag = b.a(fv, 1, aM.field_createTime);
                    obj = null;
                    if ((cVar.oqJ.equals("insert") && cVar.oqL > 0) || (cVar.oqJ.equals("update") && fv.field_unReadCount + cVar.oqL >= 0)) {
                        fv.field_unReadCount += cVar.oqL;
                        fv.field_newUnReadCount += cVar.oqL;
                        if (cVar.oqL > 0 && aK.lc(1)) {
                            i3 = akVar.field_unReadCount - cVar.oqL;
                            if (i3 > 0) {
                                akVar.hM(0);
                            } else {
                                akVar.hM(i3);
                            }
                            akVar.hS(akVar.field_unReadMuteCount + cVar.oqL);
                            obj = 1;
                        }
                    }
                    if (cVar.oqJ.equals("insert") && cVar.oqK.size() > 0 && aK.isGroup()) {
                        cI = z.aeV().cI(aM.field_talker);
                        it = cVar.oqK.iterator();
                        while (true) {
                            obj2 = obj;
                            if (it.hasNext()) {
                                break;
                            }
                            bi biVar = (bi) it.next();
                            if (cI == null || biVar.field_isSend == 1 || !biVar.isText() || !biVar.apB(cI)) {
                                obj = obj2;
                            } else {
                                fv.field_atCount++;
                                akVar.hR(akVar.field_atCount + 1);
                                obj = 1;
                            }
                        }
                        obj = obj2;
                    }
                    z.aeU();
                    b.a(fv, i2, i);
                    if (bo.isNullOrNil(str2)) {
                        str2 = aK.mJ(aM.field_bizChatUserId);
                    }
                    ab.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", str, aK.field_bizChatServId, aM.field_bizChatUserId, str2);
                    z.aeU().b(fv);
                    if (obj != null) {
                        this.xHS.a(akVar, str);
                    }
                } else {
                    aVar = fv;
                }
                j = aM.field_createTime;
                aVar.field_lastMsgTime = j;
                fv.field_status = aM.field_status;
                fv.field_isSend = aM.field_isSend;
                fv.field_msgType = Integer.toString(aM.getType());
                fv.field_flag = b.a(fv, 1, aM.field_createTime);
                obj = null;
                fv.field_unReadCount += cVar.oqL;
                fv.field_newUnReadCount += cVar.oqL;
                i3 = akVar.field_unReadCount - cVar.oqL;
                if (i3 > 0) {
                }
                akVar.hS(akVar.field_unReadMuteCount + cVar.oqL);
                obj = 1;
                cI = z.aeV().cI(aM.field_talker);
                it = cVar.oqK.iterator();
                while (true) {
                    obj2 = obj;
                    if (it.hasNext()) {
                    }
                }
                obj = obj2;
                z.aeU();
                b.a(fv, i2, i);
                if (bo.isNullOrNil(str2)) {
                }
                ab.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", str, aK.field_bizChatServId, aM.field_bizChatUserId, str2);
                z.aeU().b(fv);
                if (obj != null) {
                }
            }
        }
        AppMethodBeat.o(11848);
    }

    public final void aoj(String str) {
        AppMethodBeat.i(11849);
        if (str != null && t.mZ(str) && com.tencent.mm.aj.f.rc(str)) {
            ak aoZ = this.xHS.aoZ(str);
            if (aoZ == null) {
                AppMethodBeat.o(11849);
                return;
            }
            bi Rb = ((j) g.K(j.class)).bOr().Rb(((j) g.K(j.class)).XR().apm(str));
            if (Rb != null && Rb.field_msgId > 0) {
                aoZ.ap(Rb);
                aoZ.setContent(Rb.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rb.field_content);
                aoZ.jg(Integer.toString(Rb.getType()));
                be.b Cb = this.xHS.Cb();
                if (Cb != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    Rb.ju(str);
                    Rb.setContent(aoZ.field_content);
                    Cb.a(Rb, pString, pString2, pInt, true);
                    aoZ.jh(pString.value);
                    aoZ.ji(pString2.value);
                    aoZ.hP(pInt.value);
                } else {
                    aoZ.dsI();
                }
                this.xHS.a(aoZ, aoZ.field_username);
            }
            AppMethodBeat.o(11849);
            return;
        }
        AppMethodBeat.o(11849);
    }

    public static void aok(String str) {
        AppMethodBeat.i(11850);
        be XR = ((j) g.K(j.class)).XR();
        ak akVar = new ak(str);
        akVar.jj("officialaccounts");
        b(akVar, XR);
        AppMethodBeat.o(11850);
    }

    public static void b(ak akVar, be beVar) {
        AppMethodBeat.i(11851);
        if (akVar == null || beVar == null) {
            AppMethodBeat.o(11851);
            return;
        }
        if (t.mZ(akVar.field_username) && !bo.isNullOrNil(akVar.field_parentRef)) {
            if (s.aVO() && t.ny(akVar.field_parentRef)) {
                AppMethodBeat.o(11851);
                return;
            }
            Object obj;
            ak akVar2;
            Object obj2;
            at aoZ = beVar.aoZ(akVar.field_parentRef);
            ab.v("MicroMsg.BizConversationStorage", "postConvExt, username = %s, parentRef = %s", akVar.field_username, akVar.field_parentRef);
            if (akVar.field_parentRef.equals("officialaccounts")) {
                obj = null;
            } else {
                obj = 1;
            }
            if (aoZ == null) {
                aoZ = new ak(akVar.field_parentRef);
                if (obj != null) {
                    aoZ.jj(2097152);
                }
                akVar2 = aoZ;
                obj2 = 1;
            } else {
                at akVar22 = aoZ;
                obj2 = null;
            }
            if (obj != null && akVar22.field_attrflag == 0) {
                akVar22.jj(2097152);
                ab.v("MicroMsg.BizConversationStorage", "Enterprise cvs reset attr flag!");
            }
            ab.i("MicroMsg.BizConversationStorage", "enterprise cvs count is %d", Integer.valueOf(akVar22.field_unReadCount));
            bi Rb = ((j) g.K(j.class)).bOr().Rb(((j) g.K(j.class)).XR().apm(akVar.field_parentRef));
            if (Rb == null || Rb.field_msgId <= 0) {
                akVar22.dsI();
                ab.i("MicroMsg.BizConversationStorage", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", r2);
            } else {
                akVar22.ap(Rb);
                akVar22.setContent(Rb.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rb.field_content);
                akVar22.jg(Integer.toString(Rb.getType()));
                be.b Cb = beVar.Cb();
                if (Cb != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    Rb.ju(akVar.field_parentRef);
                    Rb.setContent(akVar22.field_content);
                    Cb.a(Rb, pString, pString2, pInt, true);
                    akVar22.jh(pString.value);
                    akVar22.ji(pString2.value);
                    akVar22.hP(pInt.value);
                }
            }
            Object obj3 = null;
            if (obj != null && beVar.apl(akVar22.field_username) <= 0) {
                obj3 = 1;
            }
            if (obj3 != null) {
                beVar.aoX(akVar22.field_username);
                AppMethodBeat.o(11851);
                return;
            } else if (obj2 != null) {
                beVar.d(akVar22);
                AppMethodBeat.o(11851);
                return;
            } else {
                beVar.a(akVar22, akVar22.field_username);
            }
        }
        AppMethodBeat.o(11851);
    }

    public final void a(bi biVar, ak akVar) {
        String str = null;
        AppMethodBeat.i(11845);
        if (!(akVar == null || biVar == null || biVar.field_bizChatId == -1 || !akVar.jl(8388608))) {
            com.tencent.mm.aj.a.c aK = z.aeT().aK(biVar.field_bizChatId);
            String str2 = akVar.field_digest;
            if (bo.isNullOrNil(biVar.field_bizChatUserId)) {
                ab.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", aK.field_bizChatServId, aK.field_chatName);
            } else {
                String str3;
                com.tencent.mm.aj.a.j cH = z.aeV().cH(biVar.field_bizChatUserId);
                if (cH != null) {
                    str3 = cH.field_userName;
                } else {
                    str3 = null;
                }
                boolean equals = biVar.field_bizChatUserId.equals(z.aeV().cI(biVar.field_talker));
                if (cH != null && equals) {
                    akVar.jh(ah.getContext().getString(R.string.ri) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2);
                } else if (!(cH == null || bo.isNullOrNil(cH.field_userName))) {
                    akVar.jh(cH.field_userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2);
                }
                if (!aK.isGroup()) {
                    if (equals || str3 == null || str3.length() <= 0 || str3.equals(aK.field_chatName)) {
                        com.tencent.mm.aj.a.j cH2 = z.aeV().cH(aK.field_bizChatServId);
                        if (cH2 != null) {
                            str = cH2.field_userName;
                        }
                        if (!(str == null || str.length() <= 0 || str.equals(aK.field_chatName))) {
                            aK.field_chatName = str;
                            z.aeT().b(aK);
                        }
                    } else {
                        aK.field_chatName = str3;
                        z.aeT().b(aK);
                        AppMethodBeat.o(11845);
                        return;
                    }
                }
                AppMethodBeat.o(11845);
                return;
            }
        }
        AppMethodBeat.o(11845);
    }
}
