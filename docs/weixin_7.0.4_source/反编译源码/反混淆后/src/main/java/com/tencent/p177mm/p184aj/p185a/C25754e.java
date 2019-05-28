package com.tencent.p177mm.p184aj.p185a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C25781a;
import com.tencent.p177mm.api.C8954i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C8939o;
import com.tencent.p177mm.p184aj.p185a.C37446b.C37447a.C32233b;
import com.tencent.p177mm.p184aj.p185a.C37446b.C37447a.C8922a;
import com.tencent.p177mm.p184aj.p185a.C37448d.C25753a.C8923a;
import com.tencent.p177mm.p184aj.p185a.C37448d.C25753a.C8924b;
import com.tencent.p177mm.p184aj.p185a.C37449k.C37450a.C32235a;
import com.tencent.p177mm.p184aj.p185a.C37449k.C37450a.C32236b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.protocal.protobuf.C23406kf;
import com.tencent.p177mm.protocal.protobuf.acr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.aj.a.e */
public final class C25754e {
    public static String dqJ = null;
    public static final Object fxC = new Object();

    static {
        AppMethodBeat.m2504i(11555);
        AppMethodBeat.m2505o(11555);
    }

    /* renamed from: rr */
    public static boolean m40904rr(String str) {
        AppMethodBeat.m2504i(11532);
        if (str == null) {
            AppMethodBeat.m2505o(11532);
            return false;
        } else if (str.endsWith("@qy_u") || str.endsWith("@qy_g")) {
            AppMethodBeat.m2505o(11532);
            return true;
        } else {
            AppMethodBeat.m2505o(11532);
            return false;
        }
    }

    /* renamed from: rs */
    public static boolean m40905rs(String str) {
        AppMethodBeat.m2504i(11533);
        if (str == null) {
            C4990ab.m7416i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
            AppMethodBeat.m2505o(11533);
            return false;
        }
        boolean endsWith = str.endsWith("@qy_g");
        AppMethodBeat.m2505o(11533);
        return endsWith;
    }

    /* renamed from: c */
    public static boolean m40893c(C45142c c45142c) {
        AppMethodBeat.m2504i(11534);
        if (c45142c == null) {
            AppMethodBeat.m2505o(11534);
            return false;
        }
        List<String> afg = c45142c.afg();
        String cI = ((C8954i) C1720g.m3528K(C8954i.class)).mo20409cI(c45142c.field_brandUserName);
        if (cI == null) {
            C4990ab.m7420w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
            AppMethodBeat.m2505o(11534);
            return false;
        }
        for (String equals : afg) {
            if (cI.equals(equals)) {
                AppMethodBeat.m2505o(11534);
                return true;
            }
        }
        C4990ab.m7421w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", cI);
        C4990ab.m7421w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", Arrays.toString(afg.toArray()));
        AppMethodBeat.m2505o(11534);
        return false;
    }

    /* renamed from: fB */
    public static int m40898fB(long j) {
        AppMethodBeat.m2504i(11535);
        List fC = C25754e.m40899fC(j);
        if (fC != null) {
            int size = fC.size();
            AppMethodBeat.m2505o(11535);
            return size;
        }
        C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
        AppMethodBeat.m2505o(11535);
        return 0;
    }

    /* renamed from: fC */
    public static List<String> m40899fC(long j) {
        AppMethodBeat.m2504i(11536);
        List afg = C41747z.aeT().mo60349aK(j).afg();
        AppMethodBeat.m2505o(11536);
        return afg;
    }

    /* renamed from: rt */
    public static String m40906rt(String str) {
        AppMethodBeat.m2504i(11537);
        if (str == null) {
            C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
            AppMethodBeat.m2505o(11537);
            return null;
        }
        C45143j cH = C41747z.aeV().mo60356cH(str);
        if (cH != null) {
            String str2 = cH.field_userName;
            AppMethodBeat.m2505o(11537);
            return str2;
        }
        C4990ab.m7416i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
        AppMethodBeat.m2505o(11537);
        return null;
    }

    /* renamed from: ru */
    public static String m40907ru(String str) {
        AppMethodBeat.m2504i(11538);
        C45143j cH = C41747z.aeV().mo60356cH(str);
        if (cH != null) {
            String str2 = cH.field_headImageUrl;
            AppMethodBeat.m2505o(11538);
            return str2;
        }
        AppMethodBeat.m2505o(11538);
        return null;
    }

    /* renamed from: a */
    public static C45142c m40890a(C45142c c45142c, long j) {
        AppMethodBeat.m2504i(11539);
        String str = "MicroMsg.BizChatInfoStorageLogic";
        String str2 = "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(c45142c == null ? -1 : c45142c.field_bizChatLocalId);
        C4990ab.m7421w(str, str2, objArr);
        if (c45142c == null) {
            C45142c c45142c2 = new C45142c();
            c45142c2.field_bizChatLocalId = j;
            C41747z.aeT().mo60350b(c45142c2);
            c45142c = C41747z.aeT().mo60349aK(j);
        }
        AppMethodBeat.m2505o(11539);
        return c45142c;
    }

    /* renamed from: a */
    public static C45143j m40891a(C45143j c45143j, String str) {
        AppMethodBeat.m2504i(11540);
        String str2 = "MicroMsg.BizChatInfoStorageLogic";
        String str3 = "protectBizChatNotExist userId:%s BizChatUserInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = c45143j == null ? Integer.valueOf(-1) : c45143j.field_userId;
        C4990ab.m7421w(str2, str3, objArr);
        if (c45143j == null) {
            C45143j c45143j2 = new C45143j();
            c45143j2.field_userId = str;
            C41747z.aeV().mo60354b(c45143j2);
            c45143j = C41747z.aeV().mo60356cH(str);
            if (c45143j == null) {
                C4990ab.m7412e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
                AppMethodBeat.m2505o(11540);
                return c45143j2;
            }
        }
        AppMethodBeat.m2505o(11540);
        return c45143j;
    }

    /* renamed from: rv */
    public static C45143j m40908rv(String str) {
        C45143j c45143j = null;
        AppMethodBeat.m2504i(11541);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
            AppMethodBeat.m2505o(11541);
        } else {
            C8925f rA = C41747z.aeW().mo43711rA(str);
            if (rA == null) {
                C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
                AppMethodBeat.m2505o(11541);
            } else {
                c45143j = C41747z.aeV().mo60356cH(rA.field_userId);
                if (c45143j == null) {
                    C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
                }
                AppMethodBeat.m2505o(11541);
            }
        }
        return c45143j;
    }

    /* renamed from: rw */
    public static String m40909rw(String str) {
        AppMethodBeat.m2504i(11542);
        if (str == null) {
            C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
            AppMethodBeat.m2505o(11542);
            return null;
        }
        int indexOf = str.indexOf("<enterprise_info>") + 17;
        int indexOf2 = str.indexOf("</enterprise_info>");
        if (indexOf == -1 || indexOf2 == -1 || indexOf >= indexOf2) {
            C4990ab.m7421w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", Integer.valueOf(indexOf), Integer.valueOf(indexOf2));
            AppMethodBeat.m2505o(11542);
            return null;
        }
        String substring = str.substring(indexOf, indexOf2);
        substring = str.replace(substring, substring.replace("<", "&lt;").replace(">", "&gt;"));
        AppMethodBeat.m2505o(11542);
        return substring;
    }

    public static String aae() {
        String str;
        synchronized (fxC) {
            str = dqJ;
        }
        return str;
    }

    /* renamed from: d */
    public static String m40895d(C45142c c45142c) {
        AppMethodBeat.m2504i(11543);
        if (c45142c == null) {
            C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
            AppMethodBeat.m2505o(11543);
            return null;
        }
        C4990ab.m7410d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
        if (c45142c.field_bizChatServId == null) {
            C4990ab.m7411d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", c45142c.field_bizChatServId);
            AppMethodBeat.m2505o(11543);
            return null;
        }
        C45143j rv = C25754e.m40908rv(c45142c.field_brandUserName);
        if (rv == null || rv.field_userId == null) {
            C4990ab.m7411d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", c45142c.field_bizChatServId);
            AppMethodBeat.m2505o(11543);
            return null;
        }
        synchronized (fxC) {
            try {
                dqJ = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id></enterprise_info></msgsource>", new Object[]{Integer.valueOf(1), c45142c.field_bizChatServId, Integer.valueOf(c45142c.field_chatVersion), rv.field_userId});
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(11543);
            }
        }
        C4990ab.m7411d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", dqJ);
        String str = dqJ;
        return str;
    }

    /* renamed from: rx */
    public static void m40910rx(String str) {
        synchronized (fxC) {
            dqJ = str;
        }
    }

    /* JADX WARNING: Missing block: B:20:0x006c, code skipped:
            if (com.tencent.p177mm.p184aj.C41747z.aeT().mo60348a(r5) == false) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public static C45142c m40896e(C45142c c45142c) {
        AppMethodBeat.m2504i(11544);
        if (c45142c.field_bizChatServId == null) {
            AppMethodBeat.m2505o(11544);
            return null;
        }
        C45142c rq = C41747z.aeT().mo60352rq(c45142c.field_bizChatServId);
        if (rq != null) {
            if (c45142c.field_chatVersion > rq.field_chatVersion || C5046bo.isNullOrNil(rq.field_brandUserName)) {
                if (!C5046bo.isNullOrNil(c45142c.field_chatName)) {
                    rq.field_chatName = c45142c.field_chatName;
                }
                rq.field_brandUserName = c45142c.field_brandUserName;
                rq.field_needToUpdate = true;
                rq.field_chatType = c45142c.field_chatType;
                C41747z.aeT().mo60350b(rq);
                c45142c = rq;
            }
            c45142c = rq;
        } else {
            c45142c.field_needToUpdate = true;
        }
        if (c45142c.afh()) {
            if (c45142c.isGroup()) {
                C41747z.aeZ().mo43714aD(c45142c.field_bizChatServId, c45142c.field_brandUserName);
            } else {
                C41747z.aeZ().mo43715aF(c45142c.field_bizChatServId, c45142c.field_brandUserName);
            }
        }
        AppMethodBeat.m2505o(11544);
        return c45142c;
    }

    /* renamed from: f */
    public static boolean m40897f(C45142c c45142c) {
        AppMethodBeat.m2504i(11545);
        C4990ab.m7410d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
        if (c45142c == null) {
            C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
            AppMethodBeat.m2505o(11545);
            return false;
        }
        List<String> afg = c45142c.afg();
        if (afg == null) {
            C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
            AppMethodBeat.m2505o(11545);
            return false;
        }
        LinkedList linkedList = new LinkedList();
        for (String str : afg) {
            C45143j cH = C41747z.aeV().mo60356cH(str);
            if (cH != null && cH.afh()) {
                linkedList.add(str);
            }
        }
        if (linkedList.size() > 0) {
            C41747z.aeZ().mo43717b(linkedList, c45142c.field_brandUserName);
            AppMethodBeat.m2505o(11545);
            return true;
        }
        C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
        AppMethodBeat.m2505o(11545);
        return false;
    }

    /* renamed from: fD */
    public static String m40900fD(long j) {
        AppMethodBeat.m2504i(11546);
        String str = C41747z.aeT().mo60349aK(j).field_bizChatServId;
        AppMethodBeat.m2505o(11546);
        return str;
    }

    /* renamed from: ry */
    public static long m40911ry(String str) {
        AppMethodBeat.m2504i(11547);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
            AppMethodBeat.m2505o(11547);
            return -1;
        }
        C45142c rq = C41747z.aeT().mo60352rq(str);
        if (rq != null) {
            long j = rq.field_bizChatLocalId;
            AppMethodBeat.m2505o(11547);
            return j;
        }
        C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
        AppMethodBeat.m2505o(11547);
        return -1;
    }

    /* renamed from: G */
    public static void m40889G(final String str, final boolean z) {
        AppMethodBeat.m2504i(11548);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7410d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
            AppMethodBeat.m2505o(11548);
            return;
        }
        C4990ab.m7410d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
        C1720g.m3539RS().mo10302aa(new Runnable() {
            final /* synthetic */ C1827a fkF = null;

            /* renamed from: com.tencent.mm.aj.a.e$1$1 */
            class C12331 implements Runnable {
                C12331() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(11528);
                    if (C257551.this.fkF != null) {
                        C257551.this.fkF.mo5406JV();
                    }
                    AppMethodBeat.m2505o(11528);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(11529);
                C37446b aeU = C41747z.aeU();
                String str = str;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("delete from BizChatConversation");
                stringBuilder.append(" where brandUserName = '").append(str).append("' ");
                C4990ab.m7417i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(aeU.bSd.mo10108hY("BizChatConversation", stringBuilder.toString())));
                if (aeU.bSd.mo10108hY("BizChatConversation", stringBuilder.toString())) {
                    C32232a c32232a = new C32232a();
                    C32233b c32233b = new C32233b();
                    c32233b.fxq = -1;
                    c32233b.cwz = str;
                    c32233b.fxp = C8922a.DELETE;
                    c32233b.fxr = c32232a;
                    aeU.fuL.mo10126cF(c32233b);
                    aeU.fuL.doNotify();
                }
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX(str);
                C37448d aeT = C41747z.aeT();
                str = str;
                stringBuilder = new StringBuilder();
                stringBuilder.append("delete from BizChatInfo");
                stringBuilder.append(" where brandUserName = '").append(str).append("' ");
                C4990ab.m7417i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(aeT.bSd.mo10108hY("BizChatInfo", stringBuilder.toString())));
                if (aeT.bSd.mo10108hY("BizChatInfo", stringBuilder.toString())) {
                    C45142c c45142c = new C45142c();
                    C8924b c8924b = new C8924b();
                    c8924b.fxq = -1;
                    c8924b.cwz = str;
                    c8924b.fxA = C8923a.DELETE;
                    c8924b.fxB = c45142c;
                    aeT.fuL.mo10126cF(c8924b);
                    aeT.fuL.doNotify();
                }
                C5730e.m8618N(C25754e.m40894cC(str), true);
                if (z) {
                    C37449k aeV = C41747z.aeV();
                    str = str;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("delete from BizChatUserInfo");
                    stringBuilder.append(" where brandUserName = '").append(str).append("' ");
                    C4990ab.m7417i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(aeV.bSd.mo10108hY("BizChatUserInfo", stringBuilder.toString())));
                    if (aeV.bSd.mo10108hY("BizChatUserInfo", stringBuilder.toString())) {
                        C45143j c45143j = new C45143j();
                        C32236b c32236b = new C32236b();
                        c32236b.fyc = C32235a.DELETE;
                        c32236b.fyd = c45143j;
                        aeV.fuL.mo10126cF(c32236b);
                        aeV.fuL.doNotify();
                    }
                    C41747z.aeW().mo43712rB(str);
                    C5730e.m8618N(C25754e.m40912rz(str), true);
                }
                C5004al.m7441d(new C12331());
                AppMethodBeat.m2505o(11529);
            }

            public final String toString() {
                AppMethodBeat.m2504i(11530);
                String str = super.toString() + "|deleteMsgByTalkers";
                AppMethodBeat.m2505o(11530);
                return str;
            }
        });
        AppMethodBeat.m2505o(11548);
    }

    /* renamed from: p */
    public static void m40903p(final String str, final String str2, final String str3) {
        AppMethodBeat.m2504i(11549);
        C4990ab.m7417i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", str, str2, str3);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(11531);
                C45142c rq = C41747z.aeT().mo60352rq(str2);
                if (rq == null) {
                    AppMethodBeat.m2505o(11531);
                    return;
                }
                if (rq.field_chatVersion < C5046bo.getInt(str3, BaseClientBuilder.API_PRIORITY_OTHER)) {
                    rq.field_needToUpdate = true;
                    C41747z.aeT().mo60350b(rq);
                }
                if (rq.isGroup()) {
                    C41747z.aeZ().mo43714aD(rq.field_bizChatServId, str);
                    AppMethodBeat.m2505o(11531);
                    return;
                }
                C41747z.aeZ().mo43715aF(rq.field_bizChatServId, str);
                AppMethodBeat.m2505o(11531);
            }
        });
        AppMethodBeat.m2505o(11549);
    }

    /* renamed from: cC */
    public static String m40894cC(String str) {
        AppMethodBeat.m2504i(11550);
        String cC = C25781a.m40991cC(str);
        AppMethodBeat.m2505o(11550);
        return cC;
    }

    /* renamed from: a */
    public static boolean m40892a(C45142c c45142c, String str, String str2, acr acr) {
        AppMethodBeat.m2504i(11552);
        if (!(str == null || C5046bo.isNullOrNil(c45142c.field_brandUserName))) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 1 && C5046bo.isNullOrNil(str2)) {
                    boolean z;
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    String string = jSONObject.getString("id");
                    C45143j cH = C41747z.aeV().mo60356cH(string);
                    if (cH == null) {
                        cH = new C45143j();
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
                        cH.field_brandUserName = c45142c.field_brandUserName;
                        z = true;
                    }
                    if (cH.field_addMemberUrl == null || cH.field_addMemberUrl.length() == 0) {
                        cH.field_addMemberUrl = c45142c.field_addMemberUrl;
                        z = true;
                    }
                    if (!C41747z.aeV().mo60354b(cH)) {
                        C41747z.aeV().mo60353a(cH);
                    }
                    if (z) {
                        C41747z.aeZ().mo43716aG(cH.field_userId, cH.field_brandUserName);
                    }
                    C45142c c45142c2 = new C45142c();
                    c45142c2.field_bizChatServId = cH.field_userId;
                    c45142c2.field_brandUserName = cH.field_brandUserName;
                    c45142c2.field_chatName = cH.field_userName;
                    c45142c2.field_chatType = 1;
                    c45142c2 = C25754e.m40896e(c45142c2);
                    if (c45142c2 != null) {
                        c45142c.field_bizChatLocalId = c45142c2.field_bizChatLocalId;
                        c45142c.field_chatName = cH.field_userName;
                        AppMethodBeat.m2505o(11552);
                        return true;
                    }
                    AppMethodBeat.m2505o(11552);
                    return false;
                }
                LinkedList linkedList = new LinkedList();
                if (!C5046bo.isNullOrNil(str2)) {
                    C23406kf c23406kf = new C23406kf();
                    c23406kf.vNc = str2;
                    linkedList.add(c23406kf);
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    C45143j c45143j = new C45143j();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    c45143j.field_userId = jSONObject2.getString("id");
                    c45143j.field_userName = jSONObject2.getString("nick_name");
                    c45143j.field_brandUserName = c45142c.field_brandUserName;
                    c45143j.field_headImageUrl = jSONObject2.getString("head_img_url");
                    c45143j.field_profileUrl = jSONObject2.getString("profile_url");
                    c45143j.field_UserVersion = jSONObject2.getInt("ver");
                    c45143j.field_addMemberUrl = c45142c.field_addMemberUrl;
                    if (!C41747z.aeV().mo60354b(c45143j)) {
                        C41747z.aeV().mo60353a(c45143j);
                    }
                    C23406kf c23406kf2 = new C23406kf();
                    c23406kf2.vNc = c45143j.field_userId;
                    linkedList.add(c23406kf2);
                }
                acr.vNd = linkedList;
                c45142c.field_bizChatLocalId = -1;
                AppMethodBeat.m2505o(11552);
                return true;
            } catch (JSONException e) {
                C4990ab.m7417i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(11552);
        return false;
    }

    /* renamed from: g */
    public static void m40901g(C45142c c45142c) {
        AppMethodBeat.m2504i(11553);
        if (c45142c == null) {
            C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
            AppMethodBeat.m2505o(11553);
            return;
        }
        boolean fy = C41747z.aeU().mo60343fy(c45142c.field_bizChatLocalId);
        boolean lc = c45142c.mo73052lc(16);
        C4990ab.m7411d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", Boolean.valueOf(fy), Boolean.valueOf(lc), c45142c.field_chatName);
        if (!lc || fy) {
            if (!lc && fy) {
                C41747z.aeU().mo60338fA(c45142c.field_bizChatLocalId);
            }
            AppMethodBeat.m2505o(11553);
            return;
        }
        C41747z.aeU().mo60344fz(c45142c.field_bizChatLocalId);
        AppMethodBeat.m2505o(11553);
    }

    /* renamed from: h */
    public static void m40902h(C45142c c45142c) {
        AppMethodBeat.m2504i(11554);
        if (c45142c == null) {
            C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
            AppMethodBeat.m2505o(11554);
            return;
        }
        C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(c45142c.field_brandUserName);
        if (aoZ == null) {
            C4990ab.m7420w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
            AppMethodBeat.m2505o(11554);
            return;
        }
        C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(c45142c.field_brandUserName);
        C7620bi aM = ((C8939o) C1720g.m3528K(C8939o.class)).mo20357XP().mo74792aM(c45142c.field_brandUserName, c45142c.field_bizChatLocalId);
        if (!(Rb == null || aM == null || Rb.field_msgId != aM.field_msgId)) {
            String str = aoZ.field_digest;
            if (str != null) {
                int indexOf = str.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (indexOf != -1) {
                    String substring = str.substring(0, indexOf);
                    str = str.substring(indexOf + 1);
                    if (!(substring == null || substring.equals(c45142c.field_chatName))) {
                        aoZ.mo14758jh(c45142c.field_chatName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str);
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, aoZ.field_username);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(11554);
    }

    /* renamed from: rz */
    public static String m40912rz(String str) {
        AppMethodBeat.m2504i(11551);
        if (C5046bo.isNullOrNil(str)) {
            str = "tempUser";
        }
        StringBuilder stringBuilder = new StringBuilder(C43217c.m76864XX());
        stringBuilder.append(C1178g.m2591x(str.getBytes())).append("/");
        stringBuilder.append("user/");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(11551);
        return stringBuilder2;
    }
}
