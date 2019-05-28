package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C8954i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p711c.C32680aa;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.aj.a.c */
public final class C45142c extends C32680aa {
    protected static C4924a ccO;
    private Map<String, C45143j> fxs = new HashMap();
    private List<String> fxt;

    public C45142c() {
        AppMethodBeat.m2504i(105488);
        AppMethodBeat.m2505o(105488);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: lc */
    public final boolean mo73052lc(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    public final List<String> afg() {
        AppMethodBeat.m2504i(105489);
        if (this.fxt != null) {
            List list = this.fxt;
            AppMethodBeat.m2505o(105489);
            return list;
        }
        String str = this.field_userList;
        List<String> linkedList;
        if (C5046bo.isNullOrNil(str)) {
            linkedList = new LinkedList();
            AppMethodBeat.m2505o(105489);
            return linkedList;
        }
        this.fxt = C5046bo.m7508P(str.split(";"));
        linkedList = this.fxt;
        AppMethodBeat.m2505o(105489);
        return linkedList;
    }

    /* renamed from: mJ */
    public final String mo73053mJ(String str) {
        AppMethodBeat.m2504i(105490);
        C45143j ro = mo73054ro(str);
        String str2;
        if (ro == null) {
            str2 = "";
            AppMethodBeat.m2505o(105490);
            return str2;
        }
        str2 = C5046bo.m7532bc(ro.field_userName, "");
        AppMethodBeat.m2505o(105490);
        return str2;
    }

    /* renamed from: ro */
    public final C45143j mo73054ro(String str) {
        AppMethodBeat.m2504i(105491);
        if (!this.fxs.containsKey(str) || this.fxs.get(str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            m83009rp(str);
            C4990ab.m7411d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        if (this.fxs.containsKey(str)) {
            C45143j c45143j = (C45143j) this.fxs.get(str);
            AppMethodBeat.m2505o(105491);
            return c45143j;
        }
        AppMethodBeat.m2505o(105491);
        return null;
    }

    /* renamed from: rp */
    private void m83009rp(String str) {
        AppMethodBeat.m2504i(105492);
        C45143j cH = ((C8954i) C1720g.m3528K(C8954i.class)).mo20408cH(str);
        if (cH != null) {
            this.fxs.put(cH.field_userId, cH);
        }
        AppMethodBeat.m2505o(105492);
    }

    public final boolean isGroup() {
        AppMethodBeat.m2504i(105493);
        if (this.field_bizChatServId == null) {
            AppMethodBeat.m2505o(105493);
            return false;
        }
        boolean endsWith = this.field_bizChatServId.endsWith("@qy_g");
        AppMethodBeat.m2505o(105493);
        return endsWith;
    }

    public final boolean afh() {
        AppMethodBeat.m2504i(105494);
        if (this.field_needToUpdate) {
            AppMethodBeat.m2505o(105494);
            return true;
        } else if (isGroup() && C5046bo.isNullOrNil(this.field_userList)) {
            AppMethodBeat.m2505o(105494);
            return true;
        } else if (!C5046bo.isNullOrNil(this.field_chatNamePY) || C5046bo.isNullOrNil(this.field_chatName)) {
            AppMethodBeat.m2505o(105494);
            return false;
        } else {
            AppMethodBeat.m2505o(105494);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(105495);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[14];
        c4924a.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "bizChatLocalId";
        c4924a.xDd.put("bizChatLocalId", "LONG PRIMARY KEY ");
        stringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "bizChatLocalId";
        c4924a.columns[1] = "bizChatServId";
        c4924a.xDd.put("bizChatServId", "TEXT");
        stringBuilder.append(" bizChatServId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "brandUserName";
        c4924a.xDd.put("brandUserName", "TEXT default '' ");
        stringBuilder.append(" brandUserName TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "chatType";
        c4924a.xDd.put("chatType", "INTEGER");
        stringBuilder.append(" chatType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "headImageUrl";
        c4924a.xDd.put("headImageUrl", "TEXT");
        stringBuilder.append(" headImageUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "chatName";
        c4924a.xDd.put("chatName", "TEXT default '' ");
        stringBuilder.append(" chatName TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "chatNamePY";
        c4924a.xDd.put("chatNamePY", "TEXT default '' ");
        stringBuilder.append(" chatNamePY TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = "chatVersion";
        c4924a.xDd.put("chatVersion", "INTEGER default '-1' ");
        stringBuilder.append(" chatVersion INTEGER default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[8] = "needToUpdate";
        c4924a.xDd.put("needToUpdate", "INTEGER default 'true' ");
        stringBuilder.append(" needToUpdate INTEGER default 'true' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "bitFlag";
        c4924a.xDd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[10] = "maxMemberCnt";
        c4924a.xDd.put("maxMemberCnt", "INTEGER default '0' ");
        stringBuilder.append(" maxMemberCnt INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[11] = "ownerUserId";
        c4924a.xDd.put("ownerUserId", "TEXT");
        stringBuilder.append(" ownerUserId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[12] = "userList";
        c4924a.xDd.put("userList", "TEXT");
        stringBuilder.append(" userList TEXT");
        stringBuilder.append(", ");
        c4924a.columns[13] = "addMemberUrl";
        c4924a.xDd.put("addMemberUrl", "TEXT");
        stringBuilder.append(" addMemberUrl TEXT");
        c4924a.columns[14] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(105495);
    }
}
