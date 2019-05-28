package com.tencent.mm.plugin.multitalk.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class c extends j<b> {
    public static final String[] fnj = new String[]{j.a(b.ccO, "MultiTalkMember"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkMember  on MultiTalkMember  (  wxGroupId )"};

    static {
        AppMethodBeat.i(54116);
        AppMethodBeat.o(54116);
    }

    public c(e eVar) {
        super(eVar, b.ccO, "MultiTalkMember", null);
    }

    public final b fi(String str, String str2) {
        AppMethodBeat.i(54111);
        Cursor rawQuery = rawQuery("select memberUuid, wxGroupId, userName, inviteUserName, memberId, status,createTime  from MultiTalkMember  where wxGroupId = '" + str + "' and userName ='" + str2 + "'", new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToNext()) {
                    b bVar = new b();
                    bVar.field_memberUuid = (long) rawQuery.getInt(0);
                    bVar.field_wxGroupId = rawQuery.getString(1);
                    bVar.field_userName = rawQuery.getString(2);
                    bVar.field_inviteUserName = rawQuery.getString(3);
                    bVar.field_memberId = rawQuery.getLong(4);
                    bVar.field_status = rawQuery.getInt(5);
                    bVar.field_createTime = rawQuery.getLong(6);
                    ab.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "getMultiTalkMember get value for memberUuid = %s, wxGroupId = %s, userName = %s, inviteUserName = %s, memberId = %d, status = %d,createTime = %d", Long.valueOf(bVar.field_memberUuid), bVar.field_wxGroupId, bVar.field_userName, bVar.field_inviteUserName, Long.valueOf(bVar.field_memberId), Integer.valueOf(bVar.field_status), Long.valueOf(bVar.field_createTime));
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.o(54111);
                    return bVar;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", e.toString());
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(54111);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        AppMethodBeat.o(54111);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00bc A:{REMOVE} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final LinkedList<b> So(String str) {
        AppMethodBeat.i(54112);
        Cursor rawQuery = rawQuery("select memberUuid, wxGroupId, userName, inviteUserName, memberId, status,createTime  from MultiTalkMember  where wxGroupId = '" + str + "'", new String[0]);
        LinkedList linkedList = new LinkedList();
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                b bVar = new b();
                bVar.field_memberUuid = (long) rawQuery.getInt(0);
                bVar.field_wxGroupId = rawQuery.getString(1);
                bVar.field_userName = rawQuery.getString(2);
                bVar.field_inviteUserName = rawQuery.getString(3);
                bVar.field_memberId = rawQuery.getLong(4);
                bVar.field_status = rawQuery.getInt(5);
                bVar.field_createTime = rawQuery.getLong(6);
                ab.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "getMultiTalkMemberList get value for memberUuid = %s, wxGroupId = %s, userName = %s, inviteUserName = %s, memberId = %d, status = %d,createTime = %d", Long.valueOf(bVar.field_memberUuid), bVar.field_wxGroupId, bVar.field_userName, bVar.field_inviteUserName, Long.valueOf(bVar.field_memberId), Integer.valueOf(bVar.field_status), Long.valueOf(bVar.field_createTime));
                linkedList.add(bVar);
            } catch (Exception e) {
                ab.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", e.toString());
                return linkedList;
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(54112);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(54113);
        long j = bVar.field_memberUuid;
        Cursor rawQuery = rawQuery("select * from MultiTalkMember where memberUuid = '" + j + "' and wxGroupId = '" + bVar.field_wxGroupId + "'", new String[0]);
        boolean b;
        try {
            if (rawQuery.getCount() == 0) {
                b = b((com.tencent.mm.sdk.e.c) bVar);
                ab.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "insert ret " + b + " for memberUuid = " + j);
                return b;
            }
            b = c(bVar, new String[0]);
            ab.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "update ret " + b + " for memberUuid = " + j);
            rawQuery.close();
            AppMethodBeat.o(54113);
            return b;
        } catch (Exception e) {
            b = e.toString();
            ab.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", b);
            return false;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(54113);
        }
    }

    public final boolean dm(String str, String str2) {
        AppMethodBeat.i(54114);
        ab.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete where wxGroupId = " + str + ",member = " + str2);
        try {
            super.hY("MultiTalkMember", "delete from MultiTalkMember where wxGroupId = \"" + str + "\" and userName = \"" + str2 + "\"");
            AppMethodBeat.o(54114);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete fail for wxGroupId = " + str + ",member = " + str2);
            AppMethodBeat.o(54114);
            return false;
        }
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(54115);
        ab.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete where wxGroupId = ".concat(String.valueOf(str)));
        try {
            super.hY("MultiTalkMember", "delete from MultiTalkMember where wxGroupId = \"" + str + "\"");
            AppMethodBeat.o(54115);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete fail for wxGroupId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(54115);
            return false;
        }
    }
}
