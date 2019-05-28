package com.tencent.mm.storage;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.am;
import com.tencent.mm.j.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class u extends am {
    protected static a ccO;
    private Map<String, b> fxs = new ConcurrentHashMap();
    private com.tencent.mm.j.a.a.a xIn = new com.tencent.mm.j.a.a.a();
    public com.tencent.mm.j.a.a.a xIo = this.xIn;
    private List<String> xIp = new LinkedList();

    public u() {
        AppMethodBeat.i(60074);
        AppMethodBeat.o(60074);
    }

    public final a Ag() {
        return ccO;
    }

    public final com.tencent.mm.j.a.a.a drR() {
        AppMethodBeat.i(60075);
        if (b(this.xIo)) {
            drS();
        }
        com.tencent.mm.j.a.a.a aVar = this.xIo;
        AppMethodBeat.o(60075);
        return aVar;
    }

    public final List<String> afg() {
        AppMethodBeat.i(60076);
        if (this.xIp == null || this.xIp.size() == 0) {
            this.xIp = aor(this.field_memberlist);
        }
        List list = this.xIp;
        AppMethodBeat.o(60076);
        return list;
    }

    private void a(com.tencent.mm.j.a.a.a aVar) {
        AppMethodBeat.i(60077);
        if (this.field_roomdata == null) {
            aVar = new com.tencent.mm.j.a.a.a();
        }
        Iterator it = aVar.eow.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (!(bVar == null || bVar.userName == null)) {
                this.fxs.put(bVar.userName, bVar);
            }
        }
        AppMethodBeat.o(60077);
    }

    public final void drS() {
        AppMethodBeat.i(60078);
        if (bo.cb(this.field_roomdata)) {
            AppMethodBeat.o(60078);
            return;
        }
        try {
            this.xIo = (com.tencent.mm.j.a.a.a) new com.tencent.mm.j.a.a.a().parseFrom(this.field_roomdata);
        } catch (Exception e) {
            this.xIo = new com.tencent.mm.j.a.a.a();
        }
        a(this.xIo);
        AppMethodBeat.o(60078);
    }

    public final boolean b(com.tencent.mm.j.a.a.a aVar) {
        AppMethodBeat.i(60079);
        if (this.xIn.computeSize() == aVar.computeSize()) {
            AppMethodBeat.o(60079);
            return true;
        }
        AppMethodBeat.o(60079);
        return false;
    }

    public final b aon(String str) {
        AppMethodBeat.i(60080);
        if (this.fxs == null) {
            ab.e("MicroMsg.ChatRoomMember", "getChatroomData hashMap is null!");
            AppMethodBeat.o(60080);
            return null;
        }
        if (this.fxs.size() <= 0) {
            drS();
        }
        b bVar = (b) this.fxs.get(str);
        AppMethodBeat.o(60080);
        return bVar;
    }

    public final int drT() {
        AppMethodBeat.i(60081);
        if (b(this.xIo)) {
            drS();
        }
        int i = this.xIo.cGj;
        AppMethodBeat.o(60081);
        return i;
    }

    public final void Mk(int i) {
        AppMethodBeat.i(60082);
        if (b(this.xIo)) {
            drS();
        }
        this.xIo.cGj = i;
        try {
            this.field_roomdata = this.xIo.toByteArray();
            AppMethodBeat.o(60082);
        } catch (Exception e) {
            ab.e("MicroMsg.ChatRoomMember", "exception:%s", bo.l(e));
            AppMethodBeat.o(60082);
        }
    }

    public final boolean drU() {
        AppMethodBeat.i(60083);
        if (b(this.xIo)) {
            drS();
        }
        if (this.xIo.cGj < this.xIo.eoy) {
            AppMethodBeat.o(60083);
            return true;
        }
        AppMethodBeat.o(60083);
        return false;
    }

    public final void ji(int i) {
        AppMethodBeat.i(60084);
        if (b(this.xIo)) {
            drS();
        }
        this.field_chatroomdataflag = (this.xIo.bJt & -3) | (i & 2);
        AppMethodBeat.o(60084);
    }

    public final int drV() {
        AppMethodBeat.i(60085);
        if (b(this.xIo)) {
            drS();
        }
        int i = this.xIo.type;
        AppMethodBeat.o(60085);
        return i;
    }

    public final boolean aoo(String str) {
        AppMethodBeat.i(60086);
        b aon = aon(str);
        if (aon == null) {
            AppMethodBeat.o(60086);
            return false;
        } else if ((aon.eoA & 2048) != 0) {
            AppMethodBeat.o(60086);
            return true;
        } else {
            AppMethodBeat.o(60086);
            return false;
        }
    }

    public final int drW() {
        AppMethodBeat.i(60087);
        if (b(this.xIo)) {
            drS();
        }
        int i = this.xIo.ehD;
        AppMethodBeat.o(60087);
        return i;
    }

    public final String aop(String str) {
        AppMethodBeat.i(60088);
        b aon = aon(str);
        String str2;
        if (aon == null) {
            str2 = "";
            AppMethodBeat.o(60088);
            return str2;
        }
        str2 = bo.bc(aon.eoB, "");
        AppMethodBeat.o(60088);
        return str2;
    }

    public final String mJ(String str) {
        AppMethodBeat.i(60089);
        b aon = aon(str);
        String str2;
        if (aon == null) {
            str2 = "";
            AppMethodBeat.o(60089);
            return str2;
        }
        str2 = bo.bc(aon.eoz, "");
        AppMethodBeat.o(60089);
        return str2;
    }

    public final u pq(boolean z) {
        this.field_isShowname = z ? 1 : 0;
        return this;
    }

    public final boolean drX() {
        return this.field_isShowname > 0;
    }

    private static int YC(String str) {
        int i = 0;
        AppMethodBeat.i(60090);
        try {
            i = bo.getInt(str, 0);
        } catch (Exception e) {
            if (str != null) {
                ab.e("MicroMsg.ChatRoomMember", "parserInt error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.o(60090);
        return i;
    }

    private static com.tencent.mm.j.a.a.a aoq(String str) {
        AppMethodBeat.i(60091);
        com.tencent.mm.j.a.a.a aVar = new com.tencent.mm.j.a.a.a();
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(60091);
            return aVar;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map z = br.z(str, "RoomData");
        if (z == null) {
            ab.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
            AppMethodBeat.o(60091);
            return null;
        }
        int i = 0;
        while (true) {
            try {
                Object obj;
                Object obj2;
                Object obj3;
                b bVar = new b();
                if (i == 0) {
                    obj = ".RoomData.Member.$UserName";
                    obj2 = ".RoomData.Member.DisplayName";
                    obj3 = ".RoomData.Member.Flag";
                } else if (i != 0) {
                    obj = ".RoomData.Member" + i + ".$UserName";
                    obj2 = ".RoomData.Member" + i + ".DisplayName";
                    String obj32 = ".RoomData.Member" + i + ".Flag";
                } else {
                    obj32 = null;
                    obj2 = null;
                    obj = null;
                }
                String bc = bo.bc((String) z.get(obj), "");
                if (bo.isNullOrNil(bc)) {
                    aVar.type = YC((String) z.get(".RoomData.Type"));
                    aVar.status = YC((String) z.get(".RoomData.Status"));
                    aVar.ehD = YC((String) z.get(".RoomData.MaxCount"));
                    aVar.eox = bo.bc((String) z.get(".RoomData.ExtInfo.Upgrader"), "");
                    AppMethodBeat.o(60091);
                    return aVar;
                }
                bVar.userName = bc;
                bVar.eoz = bo.bc((String) z.get(obj2), "");
                bVar.eoA = YC((String) z.get(obj32));
                aVar.eow.add(bVar);
                i++;
            } catch (Exception e) {
                AppMethodBeat.o(60091);
                return aVar;
            }
        }
    }

    private static String de(List<String> list) {
        AppMethodBeat.i(60092);
        String str;
        if (list == null || list.size() == 0) {
            str = "";
            AppMethodBeat.o(60092);
            return str;
        }
        str = "";
        int i = 0;
        while (i < list.size()) {
            String str2 = str + ((String) list.get(i));
            if (i < list.size() - 1) {
                str2 = str2 + ";";
            }
            i++;
            str = str2;
        }
        AppMethodBeat.o(60092);
        return str;
    }

    public static List<String> aor(String str) {
        AppMethodBeat.i(60093);
        LinkedList linkedList = new LinkedList();
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(60093);
            return linkedList;
        }
        String[] split = str.split(";");
        for (Object add : split) {
            linkedList.add(add);
        }
        AppMethodBeat.o(60093);
        return linkedList;
    }

    public final u ep(List<String> list) {
        AppMethodBeat.i(60094);
        this.field_memberlist = de(list);
        AppMethodBeat.o(60094);
        return this;
    }

    public final void c(com.tencent.mm.j.a.a.a aVar) {
        AppMethodBeat.i(60095);
        try {
            this.field_roomdata = aVar.toByteArray();
            AppMethodBeat.o(60095);
        } catch (Exception e) {
            ab.e("MicroMsg.ChatRoomMember", "exception:%s", bo.l(e));
            AppMethodBeat.o(60095);
        }
    }

    public final u ib(String str, String str2) {
        AppMethodBeat.i(60096);
        u a = a(str, aoq(str2), false);
        AppMethodBeat.o(60096);
        return a;
    }

    public final u a(String str, com.tencent.mm.j.a.a.a aVar, boolean z) {
        AppMethodBeat.i(60097);
        this.field_modifytime = System.currentTimeMillis();
        if (!z) {
            int i;
            b bVar = null;
            Iterator it = aVar.eow.iterator();
            while (it.hasNext()) {
                b bVar2 = (b) it.next();
                if (bVar2.userName == null || !bVar2.userName.equals(str)) {
                    bVar2 = bVar;
                }
                bVar = bVar2;
            }
            if (bVar != null) {
                this.field_selfDisplayName = bVar.eoz;
                this.field_isShowname = bVar.eoA & 1;
                i = bVar.eoA;
            } else {
                i = 0;
            }
            ab.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i));
            aVar.bJt = (i & 2) | (aVar.bJt & -3);
            this.field_chatroomdataflag = aVar.bJt;
        }
        try {
            this.field_roomdata = aVar.toByteArray();
            this.xIo = aVar;
        } catch (Exception e) {
            ab.e("MicroMsg.ChatRoomMember", "exception:%s", bo.l(e));
        }
        a(aVar);
        AppMethodBeat.o(60097);
        return this;
    }

    public final void v(String str, List<qf> list) {
        AppMethodBeat.i(60098);
        if (b(this.xIo)) {
            drS();
        }
        for (qf qfVar : list) {
            if (this.fxs.containsKey(qfVar.jBB)) {
                b bVar = (b) this.fxs.get(qfVar.jBB);
                bVar.eoz = qfVar.vXl;
                bVar.eoA = qfVar.vXo;
                bVar.eoB = qfVar.vXp;
            }
        }
        this.xIo.eow.clear();
        for (String str2 : this.fxs.keySet()) {
            this.xIo.eow.add(this.fxs.get(str2));
        }
        a(str, this.xIo, false);
        AppMethodBeat.o(60098);
    }

    public final com.tencent.mm.j.a.a.a drY() {
        AppMethodBeat.i(60099);
        if (b(this.xIo)) {
            drS();
        }
        com.tencent.mm.j.a.a.a aVar = this.xIo;
        AppMethodBeat.o(60099);
        return aVar;
    }

    public final boolean JR() {
        AppMethodBeat.i(60100);
        if (bo.isNullOrNil(this.field_roomowner)) {
            AppMethodBeat.o(60100);
            return false;
        }
        boolean z;
        String Yz = r.Yz();
        if (((c) g.K(c.class)).HH(this.field_chatroomname) && aoo(Yz)) {
            z = true;
        } else {
            z = false;
        }
        boolean equals = this.field_roomowner.equals(Yz);
        if (z || equals) {
            AppMethodBeat.o(60100);
            return true;
        }
        AppMethodBeat.o(60100);
        return false;
    }

    public final boolean aos(String str) {
        AppMethodBeat.i(60101);
        if (bo.isNullOrNil(this.field_roomowner) || !this.field_roomowner.equals(str)) {
            AppMethodBeat.o(60101);
            return false;
        }
        AppMethodBeat.o(60101);
        return true;
    }

    static {
        AppMethodBeat.i(60102);
        a aVar = new a();
        aVar.xDb = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "chatroomname";
        aVar.xDd.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "chatroomname";
        aVar.columns[1] = "addtime";
        aVar.xDd.put("addtime", "LONG");
        stringBuilder.append(" addtime LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "memberlist";
        aVar.xDd.put("memberlist", "TEXT");
        stringBuilder.append(" memberlist TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "displayname";
        aVar.xDd.put("displayname", "TEXT");
        stringBuilder.append(" displayname TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "chatroomnick";
        aVar.xDd.put("chatroomnick", "TEXT");
        stringBuilder.append(" chatroomnick TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "roomflag";
        aVar.xDd.put("roomflag", "INTEGER");
        stringBuilder.append(" roomflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "roomowner";
        aVar.xDd.put("roomowner", "TEXT");
        stringBuilder.append(" roomowner TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "roomdata";
        aVar.xDd.put("roomdata", "BLOB");
        stringBuilder.append(" roomdata BLOB");
        stringBuilder.append(", ");
        aVar.columns[8] = "isShowname";
        aVar.xDd.put("isShowname", "INTEGER");
        stringBuilder.append(" isShowname INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "selfDisplayName";
        aVar.xDd.put("selfDisplayName", "TEXT");
        stringBuilder.append(" selfDisplayName TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE;
        aVar.xDd.put(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "INTEGER");
        stringBuilder.append(" style INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "chatroomdataflag";
        aVar.xDd.put("chatroomdataflag", "INTEGER");
        stringBuilder.append(" chatroomdataflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "modifytime";
        aVar.xDd.put("modifytime", "LONG");
        stringBuilder.append(" modifytime LONG");
        stringBuilder.append(", ");
        aVar.columns[13] = "chatroomnotice";
        aVar.xDd.put("chatroomnotice", "TEXT");
        stringBuilder.append(" chatroomnotice TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "chatroomVersion";
        aVar.xDd.put("chatroomVersion", "INTEGER");
        stringBuilder.append(" chatroomVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "chatroomnoticeEditor";
        aVar.xDd.put("chatroomnoticeEditor", "TEXT");
        stringBuilder.append(" chatroomnoticeEditor TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "chatroomnoticePublishTime";
        aVar.xDd.put("chatroomnoticePublishTime", "LONG");
        stringBuilder.append(" chatroomnoticePublishTime LONG");
        stringBuilder.append(", ");
        aVar.columns[17] = "chatroomLocalVersion";
        aVar.xDd.put("chatroomLocalVersion", "LONG");
        stringBuilder.append(" chatroomLocalVersion LONG");
        stringBuilder.append(", ");
        aVar.columns[18] = "chatroomStatus";
        aVar.xDd.put("chatroomStatus", "INTEGER default '0' ");
        stringBuilder.append(" chatroomStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "memberCount";
        aVar.xDd.put("memberCount", "INTEGER default '-1' ");
        stringBuilder.append(" memberCount INTEGER default '-1' ");
        aVar.columns[20] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(60102);
    }
}
