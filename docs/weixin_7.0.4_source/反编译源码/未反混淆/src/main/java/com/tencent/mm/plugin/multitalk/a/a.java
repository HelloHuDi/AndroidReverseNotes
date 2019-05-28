package com.tencent.mm.plugin.multitalk.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.f;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.pb.common.c.g;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class a extends j<f> {
    public static final String[] fnj = new String[]{j.a(f.ccO, "MultiTalkInfo"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkInfo_key  on MultiTalkInfo  (  wxGroupId )"};
    public static LinkedHashMap<String, Class> mxM = new LinkedHashMap<String, Class>() {
        {
            AppMethodBeat.i(54103);
            put("wxGroupId", String.class);
            put("groupId", String.class);
            put("roomId", Integer.TYPE);
            put("roomKey", Long.TYPE);
            put("routeId", Integer.TYPE);
            put("createTime", Long.TYPE);
            AppMethodBeat.o(54103);
        }
    };

    static {
        AppMethodBeat.i(54109);
        AppMethodBeat.o(54109);
    }

    public a(e eVar) {
        super(eVar, f.ccO, "MultiTalkInfo", null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0099 A:{REMOVE} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final LinkedList<f> bSj() {
        AppMethodBeat.i(54104);
        Cursor rawQuery = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, createTime from MultiTalkInfo", new String[0]);
        LinkedList<f> linkedList = new LinkedList();
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                f fVar = new f();
                fVar.field_wxGroupId = rawQuery.getString(0);
                fVar.field_groupId = rawQuery.getString(1);
                fVar.field_roomId = rawQuery.getInt(2);
                fVar.field_roomKey = rawQuery.getLong(3);
                fVar.field_routeId = rawQuery.getInt(4);
                fVar.field_createTime = rawQuery.getLong(5);
                ab.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d, createTime=%d", fVar.field_wxGroupId, fVar.field_groupId, Integer.valueOf(fVar.field_roomId), Long.valueOf(fVar.field_roomKey), Integer.valueOf(fVar.field_routeId), Long.valueOf(fVar.field_createTime));
                linkedList.add(fVar);
            } catch (Exception e) {
                ab.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList error!");
                return linkedList;
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(54104);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(54105);
        String str = fVar.field_wxGroupId;
        if (g.isEmpty(str)) {
            ab.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. multiTalkInfo wxGroupId is empty!");
            AppMethodBeat.o(54105);
            return false;
        }
        ab.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d", str, fVar.field_groupId, Integer.valueOf(fVar.field_roomId), Long.valueOf(fVar.field_roomKey), Integer.valueOf(fVar.field_routeId), fVar.field_inviteUserName, Integer.valueOf(fVar.field_memberCount), Long.valueOf(fVar.field_createTime));
        try {
            boolean b = b((c) fVar);
            ab.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "insert ret " + b + " for id=%s" + str);
            AppMethodBeat.o(54105);
            return b;
        } catch (Exception e) {
            ab.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + e.toString());
            AppMethodBeat.o(54105);
            return false;
        }
    }

    public final boolean b(f fVar) {
        AppMethodBeat.i(54106);
        String str = fVar.field_wxGroupId;
        if (g.isEmpty(str)) {
            ab.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. multiTalkInfo wxGroupId is empty!");
            AppMethodBeat.o(54106);
            return false;
        }
        ab.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d,state=%d", str, fVar.field_groupId, Integer.valueOf(fVar.field_roomId), Long.valueOf(fVar.field_roomKey), Integer.valueOf(fVar.field_routeId), fVar.field_inviteUserName, Integer.valueOf(fVar.field_memberCount), Long.valueOf(fVar.field_createTime), Integer.valueOf(fVar.field_state));
        try {
            boolean c = c(fVar, "wxGroupId");
            ab.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update ret " + c + " for id=%s" + str);
            AppMethodBeat.o(54106);
            return c;
        } catch (Exception e) {
            ab.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + e.toString());
            AppMethodBeat.o(54106);
            return false;
        }
    }

    public final f RW(String str) {
        AppMethodBeat.i(54107);
        ab.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTaklInfo for wxGroupId = %s", str);
        Cursor rawQuery = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, inviteUserName,memberCount,createTime,state from MultiTalkInfo where wxGroupId = '" + str + "'", new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToNext()) {
                    f fVar = new f();
                    fVar.field_wxGroupId = rawQuery.getString(0);
                    fVar.field_groupId = rawQuery.getString(1);
                    fVar.field_roomId = rawQuery.getInt(2);
                    fVar.field_roomKey = rawQuery.getLong(3);
                    fVar.field_routeId = rawQuery.getInt(4);
                    fVar.field_inviteUserName = rawQuery.getString(5);
                    fVar.field_memberCount = rawQuery.getInt(6);
                    fVar.field_createTime = rawQuery.getLong(7);
                    fVar.field_state = rawQuery.getInt(8);
                    ab.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d,inviteUser=%s,memberCount=%d, createTime=%d,field_state=%d", fVar.field_wxGroupId, fVar.field_groupId, Integer.valueOf(fVar.field_roomId), Long.valueOf(fVar.field_roomKey), Integer.valueOf(fVar.field_routeId), fVar.field_inviteUserName, Integer.valueOf(fVar.field_memberCount), Long.valueOf(fVar.field_createTime), Integer.valueOf(fVar.field_state));
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.o(54107);
                    return fVar;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo error! " + e.toString());
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(54107);
                return null;
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(54107);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        AppMethodBeat.o(54107);
        return null;
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(54108);
        ab.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete id = %s", str);
        try {
            super.hY("MultiTalkInfo", "delete from MultiTalkInfo where wxGroupId = \"" + str + "\"");
            AppMethodBeat.o(54108);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete fail for wxGroupId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(54108);
            return false;
        }
    }
}
