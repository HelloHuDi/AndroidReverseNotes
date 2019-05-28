package com.tencent.mm.aj.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.b.a.b;
import com.tencent.mm.aj.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.api.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    public static String dqJ = null;
    public static final Object fxC = new Object();

    static {
        AppMethodBeat.i(11555);
        AppMethodBeat.o(11555);
    }

    public static boolean rr(String str) {
        AppMethodBeat.i(11532);
        if (str == null) {
            AppMethodBeat.o(11532);
            return false;
        } else if (str.endsWith("@qy_u") || str.endsWith("@qy_g")) {
            AppMethodBeat.o(11532);
            return true;
        } else {
            AppMethodBeat.o(11532);
            return false;
        }
    }

    public static boolean rs(String str) {
        AppMethodBeat.i(11533);
        if (str == null) {
            ab.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
            AppMethodBeat.o(11533);
            return false;
        }
        boolean endsWith = str.endsWith("@qy_g");
        AppMethodBeat.o(11533);
        return endsWith;
    }

    public static boolean c(c cVar) {
        AppMethodBeat.i(11534);
        if (cVar == null) {
            AppMethodBeat.o(11534);
            return false;
        }
        List<String> afg = cVar.afg();
        String cI = ((i) g.K(i.class)).cI(cVar.field_brandUserName);
        if (cI == null) {
            ab.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
            AppMethodBeat.o(11534);
            return false;
        }
        for (String equals : afg) {
            if (cI.equals(equals)) {
                AppMethodBeat.o(11534);
                return true;
            }
        }
        ab.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", cI);
        ab.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", Arrays.toString(afg.toArray()));
        AppMethodBeat.o(11534);
        return false;
    }

    public static int fB(long j) {
        AppMethodBeat.i(11535);
        List fC = fC(j);
        if (fC != null) {
            int size = fC.size();
            AppMethodBeat.o(11535);
            return size;
        }
        ab.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
        AppMethodBeat.o(11535);
        return 0;
    }

    public static List<String> fC(long j) {
        AppMethodBeat.i(11536);
        List afg = z.aeT().aK(j).afg();
        AppMethodBeat.o(11536);
        return afg;
    }

    public static String rt(String str) {
        AppMethodBeat.i(11537);
        if (str == null) {
            ab.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
            AppMethodBeat.o(11537);
            return null;
        }
        j cH = z.aeV().cH(str);
        if (cH != null) {
            String str2 = cH.field_userName;
            AppMethodBeat.o(11537);
            return str2;
        }
        ab.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
        AppMethodBeat.o(11537);
        return null;
    }

    public static String ru(String str) {
        AppMethodBeat.i(11538);
        j cH = z.aeV().cH(str);
        if (cH != null) {
            String str2 = cH.field_headImageUrl;
            AppMethodBeat.o(11538);
            return str2;
        }
        AppMethodBeat.o(11538);
        return null;
    }

    public static c a(c cVar, long j) {
        AppMethodBeat.i(11539);
        String str = "MicroMsg.BizChatInfoStorageLogic";
        String str2 = "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(cVar == null ? -1 : cVar.field_bizChatLocalId);
        ab.w(str, str2, objArr);
        if (cVar == null) {
            c cVar2 = new c();
            cVar2.field_bizChatLocalId = j;
            z.aeT().b(cVar2);
            cVar = z.aeT().aK(j);
        }
        AppMethodBeat.o(11539);
        return cVar;
    }

    public static j a(j jVar, String str) {
        AppMethodBeat.i(11540);
        String str2 = "MicroMsg.BizChatInfoStorageLogic";
        String str3 = "protectBizChatNotExist userId:%s BizChatUserInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = jVar == null ? Integer.valueOf(-1) : jVar.field_userId;
        ab.w(str2, str3, objArr);
        if (jVar == null) {
            j jVar2 = new j();
            jVar2.field_userId = str;
            z.aeV().b(jVar2);
            jVar = z.aeV().cH(str);
            if (jVar == null) {
                ab.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
                AppMethodBeat.o(11540);
                return jVar2;
            }
        }
        AppMethodBeat.o(11540);
        return jVar;
    }

    public static j rv(String str) {
        j jVar = null;
        AppMethodBeat.i(11541);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
            AppMethodBeat.o(11541);
        } else {
            f rA = z.aeW().rA(str);
            if (rA == null) {
                ab.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
                AppMethodBeat.o(11541);
            } else {
                jVar = z.aeV().cH(rA.field_userId);
                if (jVar == null) {
                    ab.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
                }
                AppMethodBeat.o(11541);
            }
        }
        return jVar;
    }

    public static String rw(String str) {
        AppMethodBeat.i(11542);
        if (str == null) {
            ab.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
            AppMethodBeat.o(11542);
            return null;
        }
        int indexOf = str.indexOf("<enterprise_info>") + 17;
        int indexOf2 = str.indexOf("</enterprise_info>");
        if (indexOf == -1 || indexOf2 == -1 || indexOf >= indexOf2) {
            ab.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", Integer.valueOf(indexOf), Integer.valueOf(indexOf2));
            AppMethodBeat.o(11542);
            return null;
        }
        String substring = str.substring(indexOf, indexOf2);
        substring = str.replace(substring, substring.replace("<", "&lt;").replace(">", "&gt;"));
        AppMethodBeat.o(11542);
        return substring;
    }

    public static String aae() {
        String str;
        synchronized (fxC) {
            str = dqJ;
        }
        return str;
    }

    public static String d(c cVar) {
        AppMethodBeat.i(11543);
        if (cVar == null) {
            ab.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
            AppMethodBeat.o(11543);
            return null;
        }
        ab.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
        if (cVar.field_bizChatServId == null) {
            ab.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", cVar.field_bizChatServId);
            AppMethodBeat.o(11543);
            return null;
        }
        j rv = rv(cVar.field_brandUserName);
        if (rv == null || rv.field_userId == null) {
            ab.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", cVar.field_bizChatServId);
            AppMethodBeat.o(11543);
            return null;
        }
        synchronized (fxC) {
            try {
                dqJ = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id></enterprise_info></msgsource>", new Object[]{Integer.valueOf(1), cVar.field_bizChatServId, Integer.valueOf(cVar.field_chatVersion), rv.field_userId});
            } finally {
                while (true) {
                }
                AppMethodBeat.o(11543);
            }
        }
        ab.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", dqJ);
        String str = dqJ;
        return str;
    }

    public static void rx(String str) {
        synchronized (fxC) {
            dqJ = str;
        }
    }

    /* JADX WARNING: Missing block: B:20:0x006c, code skipped:
            if (com.tencent.mm.aj.z.aeT().a(r5) == false) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static c e(c cVar) {
        AppMethodBeat.i(11544);
        if (cVar.field_bizChatServId == null) {
            AppMethodBeat.o(11544);
            return null;
        }
        c rq = z.aeT().rq(cVar.field_bizChatServId);
        if (rq != null) {
            if (cVar.field_chatVersion > rq.field_chatVersion || bo.isNullOrNil(rq.field_brandUserName)) {
                if (!bo.isNullOrNil(cVar.field_chatName)) {
                    rq.field_chatName = cVar.field_chatName;
                }
                rq.field_brandUserName = cVar.field_brandUserName;
                rq.field_needToUpdate = true;
                rq.field_chatType = cVar.field_chatType;
                z.aeT().b(rq);
                cVar = rq;
            }
            cVar = rq;
        } else {
            cVar.field_needToUpdate = true;
        }
        if (cVar.afh()) {
            if (cVar.isGroup()) {
                z.aeZ().aD(cVar.field_bizChatServId, cVar.field_brandUserName);
            } else {
                z.aeZ().aF(cVar.field_bizChatServId, cVar.field_brandUserName);
            }
        }
        AppMethodBeat.o(11544);
        return cVar;
    }

    public static boolean f(c cVar) {
        AppMethodBeat.i(11545);
        ab.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
        if (cVar == null) {
            ab.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
            AppMethodBeat.o(11545);
            return false;
        }
        List<String> afg = cVar.afg();
        if (afg == null) {
            ab.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
            AppMethodBeat.o(11545);
            return false;
        }
        LinkedList linkedList = new LinkedList();
        for (String str : afg) {
            j cH = z.aeV().cH(str);
            if (cH != null && cH.afh()) {
                linkedList.add(str);
            }
        }
        if (linkedList.size() > 0) {
            z.aeZ().b(linkedList, cVar.field_brandUserName);
            AppMethodBeat.o(11545);
            return true;
        }
        ab.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
        AppMethodBeat.o(11545);
        return false;
    }

    public static String fD(long j) {
        AppMethodBeat.i(11546);
        String str = z.aeT().aK(j).field_bizChatServId;
        AppMethodBeat.o(11546);
        return str;
    }

    public static long ry(String str) {
        AppMethodBeat.i(11547);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
            AppMethodBeat.o(11547);
            return -1;
        }
        c rq = z.aeT().rq(str);
        if (rq != null) {
            long j = rq.field_bizChatLocalId;
            AppMethodBeat.o(11547);
            return j;
        }
        ab.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
        AppMethodBeat.o(11547);
        return -1;
    }

    public static void G(final String str, final boolean z) {
        AppMethodBeat.i(11548);
        if (bo.isNullOrNil(str)) {
            ab.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
            AppMethodBeat.o(11548);
            return;
        }
        ab.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
        g.RS().aa(new Runnable() {
            final /* synthetic */ a fkF = null;

            public final void run() {
                AppMethodBeat.i(11529);
                b aeU = z.aeU();
                String str = str;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("delete from BizChatConversation");
                stringBuilder.append(" where brandUserName = '").append(str).append("' ");
                ab.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(aeU.bSd.hY("BizChatConversation", stringBuilder.toString())));
                if (aeU.bSd.hY("BizChatConversation", stringBuilder.toString())) {
                    a aVar = new a();
                    b bVar = new b();
                    bVar.fxq = -1;
                    bVar.cwz = str;
                    bVar.fxp = b.a.a.DELETE;
                    bVar.fxr = aVar;
                    aeU.fuL.cF(bVar);
                    aeU.fuL.doNotify();
                }
                ((j) g.K(j.class)).XR().aoX(str);
                d aeT = z.aeT();
                str = str;
                stringBuilder = new StringBuilder();
                stringBuilder.append("delete from BizChatInfo");
                stringBuilder.append(" where brandUserName = '").append(str).append("' ");
                ab.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(aeT.bSd.hY("BizChatInfo", stringBuilder.toString())));
                if (aeT.bSd.hY("BizChatInfo", stringBuilder.toString())) {
                    c cVar = new c();
                    d.a.b bVar2 = new d.a.b();
                    bVar2.fxq = -1;
                    bVar2.cwz = str;
                    bVar2.fxA = d.a.a.DELETE;
                    bVar2.fxB = cVar;
                    aeT.fuL.cF(bVar2);
                    aeT.fuL.doNotify();
                }
                com.tencent.mm.vfs.e.N(e.cC(str), true);
                if (z) {
                    k aeV = z.aeV();
                    str = str;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("delete from BizChatUserInfo");
                    stringBuilder.append(" where brandUserName = '").append(str).append("' ");
                    ab.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(aeV.bSd.hY("BizChatUserInfo", stringBuilder.toString())));
                    if (aeV.bSd.hY("BizChatUserInfo", stringBuilder.toString())) {
                        j jVar = new j();
                        k.a.b bVar3 = new k.a.b();
                        bVar3.fyc = k.a.a.DELETE;
                        bVar3.fyd = jVar;
                        aeV.fuL.cF(bVar3);
                        aeV.fuL.doNotify();
                    }
                    z.aeW().rB(str);
                    com.tencent.mm.vfs.e.N(e.rz(str), true);
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(11528);
                        if (AnonymousClass1.this.fkF != null) {
                            AnonymousClass1.this.fkF.JV();
                        }
                        AppMethodBeat.o(11528);
                    }
                });
                AppMethodBeat.o(11529);
            }

            public final String toString() {
                AppMethodBeat.i(11530);
                String str = super.toString() + "|deleteMsgByTalkers";
                AppMethodBeat.o(11530);
                return str;
            }
        });
        AppMethodBeat.o(11548);
    }

    public static void p(final String str, final String str2, final String str3) {
        AppMethodBeat.i(11549);
        ab.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", str, str2, str3);
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(11531);
                c rq = z.aeT().rq(str2);
                if (rq == null) {
                    AppMethodBeat.o(11531);
                    return;
                }
                if (rq.field_chatVersion < bo.getInt(str3, BaseClientBuilder.API_PRIORITY_OTHER)) {
                    rq.field_needToUpdate = true;
                    z.aeT().b(rq);
                }
                if (rq.isGroup()) {
                    z.aeZ().aD(rq.field_bizChatServId, str);
                    AppMethodBeat.o(11531);
                    return;
                }
                z.aeZ().aF(rq.field_bizChatServId, str);
                AppMethodBeat.o(11531);
            }
        });
        AppMethodBeat.o(11549);
    }

    public static String cC(String str) {
        AppMethodBeat.i(11550);
        String cC = com.tencent.mm.api.a.cC(str);
        AppMethodBeat.o(11550);
        return cC;
    }

    public static boolean a(c cVar, String str, String str2, acr acr) {
        AppMethodBeat.i(11552);
        if (!(str == null || bo.isNullOrNil(cVar.field_brandUserName))) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 1 && bo.isNullOrNil(str2)) {
                    boolean z;
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    String string = jSONObject.getString("id");
                    j cH = z.aeV().cH(string);
                    if (cH == null) {
                        cH = new j();
                        z = true;
                    } else {
                        z = false;
                    }
                    cH.field_userId = string;
                    cH.field_userName = jSONObject.getString("nick_name");
                    cH.field_headImageUrl = jSONObject.getString("head_img_url");
                    cH.field_profileUrl = jSONObject.getString("profile_url");
                    cH.field_UserVersion = jSONObject.getInt("ver");
                    if (cH.field_brandUserName == null || cH.field_brandUserName.length() == 0) {
                        cH.field_brandUserName = cVar.field_brandUserName;
                        z = true;
                    }
                    if (cH.field_addMemberUrl == null || cH.field_addMemberUrl.length() == 0) {
                        cH.field_addMemberUrl = cVar.field_addMemberUrl;
                        z = true;
                    }
                    if (!z.aeV().b(cH)) {
                        z.aeV().a(cH);
                    }
                    if (z) {
                        z.aeZ().aG(cH.field_userId, cH.field_brandUserName);
                    }
                    c cVar2 = new c();
                    cVar2.field_bizChatServId = cH.field_userId;
                    cVar2.field_brandUserName = cH.field_brandUserName;
                    cVar2.field_chatName = cH.field_userName;
                    cVar2.field_chatType = 1;
                    cVar2 = e(cVar2);
                    if (cVar2 != null) {
                        cVar.field_bizChatLocalId = cVar2.field_bizChatLocalId;
                        cVar.field_chatName = cH.field_userName;
                        AppMethodBeat.o(11552);
                        return true;
                    }
                    AppMethodBeat.o(11552);
                    return false;
                }
                LinkedList linkedList = new LinkedList();
                if (!bo.isNullOrNil(str2)) {
                    kf kfVar = new kf();
                    kfVar.vNc = str2;
                    linkedList.add(kfVar);
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    j jVar = new j();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    jVar.field_userId = jSONObject2.getString("id");
                    jVar.field_userName = jSONObject2.getString("nick_name");
                    jVar.field_brandUserName = cVar.field_brandUserName;
                    jVar.field_headImageUrl = jSONObject2.getString("head_img_url");
                    jVar.field_profileUrl = jSONObject2.getString("profile_url");
                    jVar.field_UserVersion = jSONObject2.getInt("ver");
                    jVar.field_addMemberUrl = cVar.field_addMemberUrl;
                    if (!z.aeV().b(jVar)) {
                        z.aeV().a(jVar);
                    }
                    kf kfVar2 = new kf();
                    kfVar2.vNc = jVar.field_userId;
                    linkedList.add(kfVar2);
                }
                acr.vNd = linkedList;
                cVar.field_bizChatLocalId = -1;
                AppMethodBeat.o(11552);
                return true;
            } catch (JSONException e) {
                ab.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", e.getMessage());
                ab.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(11552);
        return false;
    }

    public static void g(c cVar) {
        AppMethodBeat.i(11553);
        if (cVar == null) {
            ab.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
            AppMethodBeat.o(11553);
            return;
        }
        boolean fy = z.aeU().fy(cVar.field_bizChatLocalId);
        boolean lc = cVar.lc(16);
        ab.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", Boolean.valueOf(fy), Boolean.valueOf(lc), cVar.field_chatName);
        if (!lc || fy) {
            if (!lc && fy) {
                z.aeU().fA(cVar.field_bizChatLocalId);
            }
            AppMethodBeat.o(11553);
            return;
        }
        z.aeU().fz(cVar.field_bizChatLocalId);
        AppMethodBeat.o(11553);
    }

    public static void h(c cVar) {
        AppMethodBeat.i(11554);
        if (cVar == null) {
            ab.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
            AppMethodBeat.o(11554);
            return;
        }
        ak aoZ = ((j) g.K(j.class)).XR().aoZ(cVar.field_brandUserName);
        if (aoZ == null) {
            ab.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
            AppMethodBeat.o(11554);
            return;
        }
        bi Rb = ((j) g.K(j.class)).bOr().Rb(cVar.field_brandUserName);
        bi aM = ((o) g.K(o.class)).XP().aM(cVar.field_brandUserName, cVar.field_bizChatLocalId);
        if (!(Rb == null || aM == null || Rb.field_msgId != aM.field_msgId)) {
            String str = aoZ.field_digest;
            if (str != null) {
                int indexOf = str.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (indexOf != -1) {
                    String substring = str.substring(0, indexOf);
                    str = str.substring(indexOf + 1);
                    if (!(substring == null || substring.equals(cVar.field_chatName))) {
                        aoZ.jh(cVar.field_chatName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str);
                        ((j) g.K(j.class)).XR().a(aoZ, aoZ.field_username);
                    }
                }
            }
        }
        AppMethodBeat.o(11554);
    }

    public static String rz(String str) {
        AppMethodBeat.i(11551);
        if (bo.isNullOrNil(str)) {
            str = "tempUser";
        }
        StringBuilder stringBuilder = new StringBuilder(c.XX());
        stringBuilder.append(com.tencent.mm.a.g.x(str.getBytes())).append("/");
        stringBuilder.append("user/");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(11551);
        return stringBuilder2;
    }
}
