package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.g.c.aa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c extends aa {
    protected static a ccO;
    private Map<String, j> fxs = new HashMap();
    private List<String> fxt;

    public c() {
        AppMethodBeat.i(105488);
        AppMethodBeat.o(105488);
    }

    public final a Ag() {
        return ccO;
    }

    public final boolean lc(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    public final List<String> afg() {
        AppMethodBeat.i(105489);
        if (this.fxt != null) {
            List list = this.fxt;
            AppMethodBeat.o(105489);
            return list;
        }
        String str = this.field_userList;
        List<String> linkedList;
        if (bo.isNullOrNil(str)) {
            linkedList = new LinkedList();
            AppMethodBeat.o(105489);
            return linkedList;
        }
        this.fxt = bo.P(str.split(";"));
        linkedList = this.fxt;
        AppMethodBeat.o(105489);
        return linkedList;
    }

    public final String mJ(String str) {
        AppMethodBeat.i(105490);
        j ro = ro(str);
        String str2;
        if (ro == null) {
            str2 = "";
            AppMethodBeat.o(105490);
            return str2;
        }
        str2 = bo.bc(ro.field_userName, "");
        AppMethodBeat.o(105490);
        return str2;
    }

    public final j ro(String str) {
        AppMethodBeat.i(105491);
        if (!this.fxs.containsKey(str) || this.fxs.get(str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            rp(str);
            ab.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        if (this.fxs.containsKey(str)) {
            j jVar = (j) this.fxs.get(str);
            AppMethodBeat.o(105491);
            return jVar;
        }
        AppMethodBeat.o(105491);
        return null;
    }

    private void rp(String str) {
        AppMethodBeat.i(105492);
        j cH = ((i) g.K(i.class)).cH(str);
        if (cH != null) {
            this.fxs.put(cH.field_userId, cH);
        }
        AppMethodBeat.o(105492);
    }

    public final boolean isGroup() {
        AppMethodBeat.i(105493);
        if (this.field_bizChatServId == null) {
            AppMethodBeat.o(105493);
            return false;
        }
        boolean endsWith = this.field_bizChatServId.endsWith("@qy_g");
        AppMethodBeat.o(105493);
        return endsWith;
    }

    public final boolean afh() {
        AppMethodBeat.i(105494);
        if (this.field_needToUpdate) {
            AppMethodBeat.o(105494);
            return true;
        } else if (isGroup() && bo.isNullOrNil(this.field_userList)) {
            AppMethodBeat.o(105494);
            return true;
        } else if (!bo.isNullOrNil(this.field_chatNamePY) || bo.isNullOrNil(this.field_chatName)) {
            AppMethodBeat.o(105494);
            return false;
        } else {
            AppMethodBeat.o(105494);
            return true;
        }
    }

    static {
        AppMethodBeat.i(105495);
        a aVar = new a();
        aVar.xDb = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bizChatLocalId";
        aVar.xDd.put("bizChatLocalId", "LONG PRIMARY KEY ");
        stringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "bizChatLocalId";
        aVar.columns[1] = "bizChatServId";
        aVar.xDd.put("bizChatServId", "TEXT");
        stringBuilder.append(" bizChatServId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "brandUserName";
        aVar.xDd.put("brandUserName", "TEXT default '' ");
        stringBuilder.append(" brandUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "chatType";
        aVar.xDd.put("chatType", "INTEGER");
        stringBuilder.append(" chatType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "headImageUrl";
        aVar.xDd.put("headImageUrl", "TEXT");
        stringBuilder.append(" headImageUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "chatName";
        aVar.xDd.put("chatName", "TEXT default '' ");
        stringBuilder.append(" chatName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "chatNamePY";
        aVar.xDd.put("chatNamePY", "TEXT default '' ");
        stringBuilder.append(" chatNamePY TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "chatVersion";
        aVar.xDd.put("chatVersion", "INTEGER default '-1' ");
        stringBuilder.append(" chatVersion INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "needToUpdate";
        aVar.xDd.put("needToUpdate", "INTEGER default 'true' ");
        stringBuilder.append(" needToUpdate INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "bitFlag";
        aVar.xDd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "maxMemberCnt";
        aVar.xDd.put("maxMemberCnt", "INTEGER default '0' ");
        stringBuilder.append(" maxMemberCnt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "ownerUserId";
        aVar.xDd.put("ownerUserId", "TEXT");
        stringBuilder.append(" ownerUserId TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "userList";
        aVar.xDd.put("userList", "TEXT");
        stringBuilder.append(" userList TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "addMemberUrl";
        aVar.xDd.put("addMemberUrl", "TEXT");
        stringBuilder.append(" addMemberUrl TEXT");
        aVar.columns[14] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(105495);
    }
}
