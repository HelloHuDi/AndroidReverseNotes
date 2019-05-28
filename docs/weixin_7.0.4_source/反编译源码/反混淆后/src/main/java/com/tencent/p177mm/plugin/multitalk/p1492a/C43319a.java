package com.tencent.p177mm.plugin.multitalk.p1492a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p203bg.C1310f;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p659pb.common.p1102c.C40956g;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.multitalk.a.a */
public final class C43319a extends C7563j<C1310f> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C1310f.ccO, "MultiTalkInfo"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkInfo_key  on MultiTalkInfo  (  wxGroupId )"};
    public static LinkedHashMap<String, Class> mxM = new C345641();

    /* renamed from: com.tencent.mm.plugin.multitalk.a.a$1 */
    static class C345641 extends LinkedHashMap<String, Class> {
        C345641() {
            AppMethodBeat.m2504i(54103);
            put("wxGroupId", String.class);
            put("groupId", String.class);
            put("roomId", Integer.TYPE);
            put("roomKey", Long.TYPE);
            put("routeId", Integer.TYPE);
            put("createTime", Long.TYPE);
            AppMethodBeat.m2505o(54103);
        }
    }

    static {
        AppMethodBeat.m2504i(54109);
        AppMethodBeat.m2505o(54109);
    }

    public C43319a(C4927e c4927e) {
        super(c4927e, C1310f.ccO, "MultiTalkInfo", null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0099 A:{REMOVE} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final LinkedList<C1310f> bSj() {
        AppMethodBeat.m2504i(54104);
        Cursor rawQuery = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, createTime from MultiTalkInfo", new String[0]);
        LinkedList<C1310f> linkedList = new LinkedList();
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                C1310f c1310f = new C1310f();
                c1310f.field_wxGroupId = rawQuery.getString(0);
                c1310f.field_groupId = rawQuery.getString(1);
                c1310f.field_roomId = rawQuery.getInt(2);
                c1310f.field_roomKey = rawQuery.getLong(3);
                c1310f.field_routeId = rawQuery.getInt(4);
                c1310f.field_createTime = rawQuery.getLong(5);
                C4990ab.m7417i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d, createTime=%d", c1310f.field_wxGroupId, c1310f.field_groupId, Integer.valueOf(c1310f.field_roomId), Long.valueOf(c1310f.field_roomKey), Integer.valueOf(c1310f.field_routeId), Long.valueOf(c1310f.field_createTime));
                linkedList.add(c1310f);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList error!");
                return linkedList;
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.m2505o(54104);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
    }

    /* renamed from: a */
    public final boolean mo68859a(C1310f c1310f) {
        AppMethodBeat.m2504i(54105);
        String str = c1310f.field_wxGroupId;
        if (C40956g.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. multiTalkInfo wxGroupId is empty!");
            AppMethodBeat.m2505o(54105);
            return false;
        }
        C4990ab.m7417i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d", str, c1310f.field_groupId, Integer.valueOf(c1310f.field_roomId), Long.valueOf(c1310f.field_roomKey), Integer.valueOf(c1310f.field_routeId), c1310f.field_inviteUserName, Integer.valueOf(c1310f.field_memberCount), Long.valueOf(c1310f.field_createTime));
        try {
            boolean b = mo10101b((C4925c) c1310f);
            C4990ab.m7416i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "insert ret " + b + " for id=%s" + str);
            AppMethodBeat.m2505o(54105);
            return b;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + e.toString());
            AppMethodBeat.m2505o(54105);
            return false;
        }
    }

    /* renamed from: b */
    public final boolean mo68860b(C1310f c1310f) {
        AppMethodBeat.m2504i(54106);
        String str = c1310f.field_wxGroupId;
        if (C40956g.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. multiTalkInfo wxGroupId is empty!");
            AppMethodBeat.m2505o(54106);
            return false;
        }
        C4990ab.m7417i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d,state=%d", str, c1310f.field_groupId, Integer.valueOf(c1310f.field_roomId), Long.valueOf(c1310f.field_roomKey), Integer.valueOf(c1310f.field_routeId), c1310f.field_inviteUserName, Integer.valueOf(c1310f.field_memberCount), Long.valueOf(c1310f.field_createTime), Integer.valueOf(c1310f.field_state));
        try {
            boolean c = mo10103c(c1310f, "wxGroupId");
            C4990ab.m7416i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update ret " + c + " for id=%s" + str);
            AppMethodBeat.m2505o(54106);
            return c;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + e.toString());
            AppMethodBeat.m2505o(54106);
            return false;
        }
    }

    /* renamed from: RW */
    public final C1310f mo68858RW(String str) {
        AppMethodBeat.m2504i(54107);
        C4990ab.m7417i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTaklInfo for wxGroupId = %s", str);
        Cursor rawQuery = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, inviteUserName,memberCount,createTime,state from MultiTalkInfo where wxGroupId = '" + str + "'", new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToNext()) {
                    C1310f c1310f = new C1310f();
                    c1310f.field_wxGroupId = rawQuery.getString(0);
                    c1310f.field_groupId = rawQuery.getString(1);
                    c1310f.field_roomId = rawQuery.getInt(2);
                    c1310f.field_roomKey = rawQuery.getLong(3);
                    c1310f.field_routeId = rawQuery.getInt(4);
                    c1310f.field_inviteUserName = rawQuery.getString(5);
                    c1310f.field_memberCount = rawQuery.getInt(6);
                    c1310f.field_createTime = rawQuery.getLong(7);
                    c1310f.field_state = rawQuery.getInt(8);
                    C4990ab.m7417i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d,inviteUser=%s,memberCount=%d, createTime=%d,field_state=%d", c1310f.field_wxGroupId, c1310f.field_groupId, Integer.valueOf(c1310f.field_roomId), Long.valueOf(c1310f.field_roomKey), Integer.valueOf(c1310f.field_routeId), c1310f.field_inviteUserName, Integer.valueOf(c1310f.field_memberCount), Long.valueOf(c1310f.field_createTime), Integer.valueOf(c1310f.field_state));
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.m2505o(54107);
                    return c1310f;
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo error! " + e.toString());
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.m2505o(54107);
                return null;
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.m2505o(54107);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        AppMethodBeat.m2505o(54107);
        return null;
    }

    /* renamed from: pI */
    public final boolean mo68862pI(String str) {
        AppMethodBeat.m2504i(54108);
        C4990ab.m7417i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete id = %s", str);
        try {
            super.mo16768hY("MultiTalkInfo", "delete from MultiTalkInfo where wxGroupId = \"" + str + "\"");
            AppMethodBeat.m2505o(54108);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete fail for wxGroupId = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(54108);
            return false;
        }
    }
}
