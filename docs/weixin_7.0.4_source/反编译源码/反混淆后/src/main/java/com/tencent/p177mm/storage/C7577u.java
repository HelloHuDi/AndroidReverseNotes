package com.tencent.p177mm.storage;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p711c.C6560am;
import com.tencent.p177mm.p712j.p713a.p714a.C6592a;
import com.tencent.p177mm.p712j.p713a.p714a.C6593b;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.protocal.protobuf.C7281qf;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.storage.u */
public final class C7577u extends C6560am {
    protected static C4924a ccO;
    private Map<String, C6593b> fxs = new ConcurrentHashMap();
    private C6592a xIn = new C6592a();
    public C6592a xIo = this.xIn;
    private List<String> xIp = new LinkedList();

    public C7577u() {
        AppMethodBeat.m2504i(60074);
        AppMethodBeat.m2505o(60074);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final C6592a drR() {
        AppMethodBeat.m2504i(60075);
        if (mo16794b(this.xIo)) {
            drS();
        }
        C6592a c6592a = this.xIo;
        AppMethodBeat.m2505o(60075);
        return c6592a;
    }

    public final List<String> afg() {
        AppMethodBeat.m2504i(60076);
        if (this.xIp == null || this.xIp.size() == 0) {
            this.xIp = C7577u.aor(this.field_memberlist);
        }
        List list = this.xIp;
        AppMethodBeat.m2505o(60076);
        return list;
    }

    /* renamed from: a */
    private void m13371a(C6592a c6592a) {
        AppMethodBeat.m2504i(60077);
        if (this.field_roomdata == null) {
            c6592a = new C6592a();
        }
        Iterator it = c6592a.eow.iterator();
        while (it.hasNext()) {
            C6593b c6593b = (C6593b) it.next();
            if (!(c6593b == null || c6593b.userName == null)) {
                this.fxs.put(c6593b.userName, c6593b);
            }
        }
        AppMethodBeat.m2505o(60077);
    }

    public final void drS() {
        AppMethodBeat.m2504i(60078);
        if (C5046bo.m7540cb(this.field_roomdata)) {
            AppMethodBeat.m2505o(60078);
            return;
        }
        try {
            this.xIo = (C6592a) new C6592a().parseFrom(this.field_roomdata);
        } catch (Exception e) {
            this.xIo = new C6592a();
        }
        m13371a(this.xIo);
        AppMethodBeat.m2505o(60078);
    }

    /* renamed from: b */
    public final boolean mo16794b(C6592a c6592a) {
        AppMethodBeat.m2504i(60079);
        if (this.xIn.computeSize() == c6592a.computeSize()) {
            AppMethodBeat.m2505o(60079);
            return true;
        }
        AppMethodBeat.m2505o(60079);
        return false;
    }

    public final C6593b aon(String str) {
        AppMethodBeat.m2504i(60080);
        if (this.fxs == null) {
            C4990ab.m7412e("MicroMsg.ChatRoomMember", "getChatroomData hashMap is null!");
            AppMethodBeat.m2505o(60080);
            return null;
        }
        if (this.fxs.size() <= 0) {
            drS();
        }
        C6593b c6593b = (C6593b) this.fxs.get(str);
        AppMethodBeat.m2505o(60080);
        return c6593b;
    }

    public final int drT() {
        AppMethodBeat.m2504i(60081);
        if (mo16794b(this.xIo)) {
            drS();
        }
        int i = this.xIo.cGj;
        AppMethodBeat.m2505o(60081);
        return i;
    }

    /* renamed from: Mk */
    public final void mo16787Mk(int i) {
        AppMethodBeat.m2504i(60082);
        if (mo16794b(this.xIo)) {
            drS();
        }
        this.xIo.cGj = i;
        try {
            this.field_roomdata = this.xIo.toByteArray();
            AppMethodBeat.m2505o(60082);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ChatRoomMember", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(60082);
        }
    }

    public final boolean drU() {
        AppMethodBeat.m2504i(60083);
        if (mo16794b(this.xIo)) {
            drS();
        }
        if (this.xIo.cGj < this.xIo.eoy) {
            AppMethodBeat.m2505o(60083);
            return true;
        }
        AppMethodBeat.m2505o(60083);
        return false;
    }

    /* renamed from: ji */
    public final void mo16806ji(int i) {
        AppMethodBeat.m2504i(60084);
        if (mo16794b(this.xIo)) {
            drS();
        }
        this.field_chatroomdataflag = (this.xIo.bJt & -3) | (i & 2);
        AppMethodBeat.m2505o(60084);
    }

    public final int drV() {
        AppMethodBeat.m2504i(60085);
        if (mo16794b(this.xIo)) {
            drS();
        }
        int i = this.xIo.type;
        AppMethodBeat.m2505o(60085);
        return i;
    }

    public final boolean aoo(String str) {
        AppMethodBeat.m2504i(60086);
        C6593b aon = aon(str);
        if (aon == null) {
            AppMethodBeat.m2505o(60086);
            return false;
        } else if ((aon.eoA & 2048) != 0) {
            AppMethodBeat.m2505o(60086);
            return true;
        } else {
            AppMethodBeat.m2505o(60086);
            return false;
        }
    }

    public final int drW() {
        AppMethodBeat.m2504i(60087);
        if (mo16794b(this.xIo)) {
            drS();
        }
        int i = this.xIo.ehD;
        AppMethodBeat.m2505o(60087);
        return i;
    }

    public final String aop(String str) {
        AppMethodBeat.m2504i(60088);
        C6593b aon = aon(str);
        String str2;
        if (aon == null) {
            str2 = "";
            AppMethodBeat.m2505o(60088);
            return str2;
        }
        str2 = C5046bo.m7532bc(aon.eoB, "");
        AppMethodBeat.m2505o(60088);
        return str2;
    }

    /* renamed from: mJ */
    public final String mo16807mJ(String str) {
        AppMethodBeat.m2504i(60089);
        C6593b aon = aon(str);
        String str2;
        if (aon == null) {
            str2 = "";
            AppMethodBeat.m2505o(60089);
            return str2;
        }
        str2 = C5046bo.m7532bc(aon.eoz, "");
        AppMethodBeat.m2505o(60089);
        return str2;
    }

    /* renamed from: pq */
    public final C7577u mo16808pq(boolean z) {
        this.field_isShowname = z ? 1 : 0;
        return this;
    }

    public final boolean drX() {
        return this.field_isShowname > 0;
    }

    /* renamed from: YC */
    private static int m13370YC(String str) {
        int i = 0;
        AppMethodBeat.m2504i(60090);
        try {
            i = C5046bo.getInt(str, 0);
        } catch (Exception e) {
            if (str != null) {
                C4990ab.m7412e("MicroMsg.ChatRoomMember", "parserInt error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.m2505o(60090);
        return i;
    }

    private static C6592a aoq(String str) {
        AppMethodBeat.m2504i(60091);
        C6592a c6592a = new C6592a();
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(60091);
            return c6592a;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map z = C5049br.m7595z(str, "RoomData");
        if (z == null) {
            C4990ab.m7412e("MicroMsg.ChatRoomMember", "parse RoomData failed");
            AppMethodBeat.m2505o(60091);
            return null;
        }
        int i = 0;
        while (true) {
            try {
                Object obj;
                Object obj2;
                Object obj3;
                C6593b c6593b = new C6593b();
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
                String bc = C5046bo.m7532bc((String) z.get(obj), "");
                if (C5046bo.isNullOrNil(bc)) {
                    c6592a.type = C7577u.m13370YC((String) z.get(".RoomData.Type"));
                    c6592a.status = C7577u.m13370YC((String) z.get(".RoomData.Status"));
                    c6592a.ehD = C7577u.m13370YC((String) z.get(".RoomData.MaxCount"));
                    c6592a.eox = C5046bo.m7532bc((String) z.get(".RoomData.ExtInfo.Upgrader"), "");
                    AppMethodBeat.m2505o(60091);
                    return c6592a;
                }
                c6593b.userName = bc;
                c6593b.eoz = C5046bo.m7532bc((String) z.get(obj2), "");
                c6593b.eoA = C7577u.m13370YC((String) z.get(obj32));
                c6592a.eow.add(c6593b);
                i++;
            } catch (Exception e) {
                AppMethodBeat.m2505o(60091);
                return c6592a;
            }
        }
    }

    /* renamed from: de */
    private static String m13372de(List<String> list) {
        AppMethodBeat.m2504i(60092);
        String str;
        if (list == null || list.size() == 0) {
            str = "";
            AppMethodBeat.m2505o(60092);
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
        AppMethodBeat.m2505o(60092);
        return str;
    }

    public static List<String> aor(String str) {
        AppMethodBeat.m2504i(60093);
        LinkedList linkedList = new LinkedList();
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(60093);
            return linkedList;
        }
        String[] split = str.split(";");
        for (Object add : split) {
            linkedList.add(add);
        }
        AppMethodBeat.m2505o(60093);
        return linkedList;
    }

    /* renamed from: ep */
    public final C7577u mo16804ep(List<String> list) {
        AppMethodBeat.m2504i(60094);
        this.field_memberlist = C7577u.m13372de(list);
        AppMethodBeat.m2505o(60094);
        return this;
    }

    /* renamed from: c */
    public final void mo16795c(C6592a c6592a) {
        AppMethodBeat.m2504i(60095);
        try {
            this.field_roomdata = c6592a.toByteArray();
            AppMethodBeat.m2505o(60095);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ChatRoomMember", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(60095);
        }
    }

    /* renamed from: ib */
    public final C7577u mo16805ib(String str, String str2) {
        AppMethodBeat.m2504i(60096);
        C7577u a = mo16788a(str, C7577u.aoq(str2), false);
        AppMethodBeat.m2505o(60096);
        return a;
    }

    /* renamed from: a */
    public final C7577u mo16788a(String str, C6592a c6592a, boolean z) {
        AppMethodBeat.m2504i(60097);
        this.field_modifytime = System.currentTimeMillis();
        if (!z) {
            int i;
            C6593b c6593b = null;
            Iterator it = c6592a.eow.iterator();
            while (it.hasNext()) {
                C6593b c6593b2 = (C6593b) it.next();
                if (c6593b2.userName == null || !c6593b2.userName.equals(str)) {
                    c6593b2 = c6593b;
                }
                c6593b = c6593b2;
            }
            if (c6593b != null) {
                this.field_selfDisplayName = c6593b.eoz;
                this.field_isShowname = c6593b.eoA & 1;
                i = c6593b.eoA;
            } else {
                i = 0;
            }
            C4990ab.m7411d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i));
            c6592a.bJt = (i & 2) | (c6592a.bJt & -3);
            this.field_chatroomdataflag = c6592a.bJt;
        }
        try {
            this.field_roomdata = c6592a.toByteArray();
            this.xIo = c6592a;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ChatRoomMember", "exception:%s", C5046bo.m7574l(e));
        }
        m13371a(c6592a);
        AppMethodBeat.m2505o(60097);
        return this;
    }

    /* renamed from: v */
    public final void mo16809v(String str, List<C7281qf> list) {
        AppMethodBeat.m2504i(60098);
        if (mo16794b(this.xIo)) {
            drS();
        }
        for (C7281qf c7281qf : list) {
            if (this.fxs.containsKey(c7281qf.jBB)) {
                C6593b c6593b = (C6593b) this.fxs.get(c7281qf.jBB);
                c6593b.eoz = c7281qf.vXl;
                c6593b.eoA = c7281qf.vXo;
                c6593b.eoB = c7281qf.vXp;
            }
        }
        this.xIo.eow.clear();
        for (String str2 : this.fxs.keySet()) {
            this.xIo.eow.add(this.fxs.get(str2));
        }
        mo16788a(str, this.xIo, false);
        AppMethodBeat.m2505o(60098);
    }

    public final C6592a drY() {
        AppMethodBeat.m2504i(60099);
        if (mo16794b(this.xIo)) {
            drS();
        }
        C6592a c6592a = this.xIo;
        AppMethodBeat.m2505o(60099);
        return c6592a;
    }

    /* renamed from: JR */
    public final boolean mo16786JR() {
        AppMethodBeat.m2504i(60100);
        if (C5046bo.isNullOrNil(this.field_roomowner)) {
            AppMethodBeat.m2505o(60100);
            return false;
        }
        boolean z;
        String Yz = C1853r.m3846Yz();
        if (((C6822c) C1720g.m3528K(C6822c.class)).mo15089HH(this.field_chatroomname) && aoo(Yz)) {
            z = true;
        } else {
            z = false;
        }
        boolean equals = this.field_roomowner.equals(Yz);
        if (z || equals) {
            AppMethodBeat.m2505o(60100);
            return true;
        }
        AppMethodBeat.m2505o(60100);
        return false;
    }

    public final boolean aos(String str) {
        AppMethodBeat.m2504i(60101);
        if (C5046bo.isNullOrNil(this.field_roomowner) || !this.field_roomowner.equals(str)) {
            AppMethodBeat.m2505o(60101);
            return false;
        }
        AppMethodBeat.m2505o(60101);
        return true;
    }

    static {
        AppMethodBeat.m2504i(60102);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[20];
        c4924a.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "chatroomname";
        c4924a.xDd.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "chatroomname";
        c4924a.columns[1] = "addtime";
        c4924a.xDd.put("addtime", "LONG");
        stringBuilder.append(" addtime LONG");
        stringBuilder.append(", ");
        c4924a.columns[2] = "memberlist";
        c4924a.xDd.put("memberlist", "TEXT");
        stringBuilder.append(" memberlist TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "displayname";
        c4924a.xDd.put("displayname", "TEXT");
        stringBuilder.append(" displayname TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "chatroomnick";
        c4924a.xDd.put("chatroomnick", "TEXT");
        stringBuilder.append(" chatroomnick TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "roomflag";
        c4924a.xDd.put("roomflag", "INTEGER");
        stringBuilder.append(" roomflag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "roomowner";
        c4924a.xDd.put("roomowner", "TEXT");
        stringBuilder.append(" roomowner TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "roomdata";
        c4924a.xDd.put("roomdata", "BLOB");
        stringBuilder.append(" roomdata BLOB");
        stringBuilder.append(", ");
        c4924a.columns[8] = "isShowname";
        c4924a.xDd.put("isShowname", "INTEGER");
        stringBuilder.append(" isShowname INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "selfDisplayName";
        c4924a.xDd.put("selfDisplayName", "TEXT");
        stringBuilder.append(" selfDisplayName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE;
        c4924a.xDd.put(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "INTEGER");
        stringBuilder.append(" style INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[11] = "chatroomdataflag";
        c4924a.xDd.put("chatroomdataflag", "INTEGER");
        stringBuilder.append(" chatroomdataflag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[12] = "modifytime";
        c4924a.xDd.put("modifytime", "LONG");
        stringBuilder.append(" modifytime LONG");
        stringBuilder.append(", ");
        c4924a.columns[13] = "chatroomnotice";
        c4924a.xDd.put("chatroomnotice", "TEXT");
        stringBuilder.append(" chatroomnotice TEXT");
        stringBuilder.append(", ");
        c4924a.columns[14] = "chatroomVersion";
        c4924a.xDd.put("chatroomVersion", "INTEGER");
        stringBuilder.append(" chatroomVersion INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[15] = "chatroomnoticeEditor";
        c4924a.xDd.put("chatroomnoticeEditor", "TEXT");
        stringBuilder.append(" chatroomnoticeEditor TEXT");
        stringBuilder.append(", ");
        c4924a.columns[16] = "chatroomnoticePublishTime";
        c4924a.xDd.put("chatroomnoticePublishTime", "LONG");
        stringBuilder.append(" chatroomnoticePublishTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[17] = "chatroomLocalVersion";
        c4924a.xDd.put("chatroomLocalVersion", "LONG");
        stringBuilder.append(" chatroomLocalVersion LONG");
        stringBuilder.append(", ");
        c4924a.columns[18] = "chatroomStatus";
        c4924a.xDd.put("chatroomStatus", "INTEGER default '0' ");
        stringBuilder.append(" chatroomStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[19] = "memberCount";
        c4924a.xDd.put("memberCount", "INTEGER default '-1' ");
        stringBuilder.append(" memberCount INTEGER default '-1' ");
        c4924a.columns[20] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(60102);
    }
}
