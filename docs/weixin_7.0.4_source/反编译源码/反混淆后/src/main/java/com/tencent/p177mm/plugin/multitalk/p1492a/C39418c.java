package com.tencent.p177mm.plugin.multitalk.p1492a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.multitalk.a.c */
public final class C39418c extends C7563j<C46087b> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C46087b.ccO, "MultiTalkMember"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkMember  on MultiTalkMember  (  wxGroupId )"};

    static {
        AppMethodBeat.m2504i(54116);
        AppMethodBeat.m2505o(54116);
    }

    public C39418c(C4927e c4927e) {
        super(c4927e, C46087b.ccO, "MultiTalkMember", null);
    }

    /* renamed from: fi */
    public final C46087b mo62360fi(String str, String str2) {
        AppMethodBeat.m2504i(54111);
        Cursor rawQuery = rawQuery("select memberUuid, wxGroupId, userName, inviteUserName, memberId, status,createTime  from MultiTalkMember  where wxGroupId = '" + str + "' and userName ='" + str2 + "'", new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToNext()) {
                    C46087b c46087b = new C46087b();
                    c46087b.field_memberUuid = (long) rawQuery.getInt(0);
                    c46087b.field_wxGroupId = rawQuery.getString(1);
                    c46087b.field_userName = rawQuery.getString(2);
                    c46087b.field_inviteUserName = rawQuery.getString(3);
                    c46087b.field_memberId = rawQuery.getLong(4);
                    c46087b.field_status = rawQuery.getInt(5);
                    c46087b.field_createTime = rawQuery.getLong(6);
                    C4990ab.m7417i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "getMultiTalkMember get value for memberUuid = %s, wxGroupId = %s, userName = %s, inviteUserName = %s, memberId = %d, status = %d,createTime = %d", Long.valueOf(c46087b.field_memberUuid), c46087b.field_wxGroupId, c46087b.field_userName, c46087b.field_inviteUserName, Long.valueOf(c46087b.field_memberId), Integer.valueOf(c46087b.field_status), Long.valueOf(c46087b.field_createTime));
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.m2505o(54111);
                    return c46087b;
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", e.toString());
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.m2505o(54111);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        AppMethodBeat.m2505o(54111);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00bc A:{REMOVE} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: So */
    public final LinkedList<C46087b> mo62357So(String str) {
        AppMethodBeat.m2504i(54112);
        Cursor rawQuery = rawQuery("select memberUuid, wxGroupId, userName, inviteUserName, memberId, status,createTime  from MultiTalkMember  where wxGroupId = '" + str + "'", new String[0]);
        LinkedList linkedList = new LinkedList();
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                C46087b c46087b = new C46087b();
                c46087b.field_memberUuid = (long) rawQuery.getInt(0);
                c46087b.field_wxGroupId = rawQuery.getString(1);
                c46087b.field_userName = rawQuery.getString(2);
                c46087b.field_inviteUserName = rawQuery.getString(3);
                c46087b.field_memberId = rawQuery.getLong(4);
                c46087b.field_status = rawQuery.getInt(5);
                c46087b.field_createTime = rawQuery.getLong(6);
                C4990ab.m7417i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "getMultiTalkMemberList get value for memberUuid = %s, wxGroupId = %s, userName = %s, inviteUserName = %s, memberId = %d, status = %d,createTime = %d", Long.valueOf(c46087b.field_memberUuid), c46087b.field_wxGroupId, c46087b.field_userName, c46087b.field_inviteUserName, Long.valueOf(c46087b.field_memberId), Integer.valueOf(c46087b.field_status), Long.valueOf(c46087b.field_createTime));
                linkedList.add(c46087b);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", e.toString());
                return linkedList;
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.m2505o(54112);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
    }

    /* renamed from: a */
    public final boolean mo62358a(C46087b c46087b) {
        AppMethodBeat.m2504i(54113);
        long j = c46087b.field_memberUuid;
        Cursor rawQuery = rawQuery("select * from MultiTalkMember where memberUuid = '" + j + "' and wxGroupId = '" + c46087b.field_wxGroupId + "'", new String[0]);
        boolean b;
        try {
            if (rawQuery.getCount() == 0) {
                b = mo10101b((C4925c) c46087b);
                C4990ab.m7416i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "insert ret " + b + " for memberUuid = " + j);
                return b;
            }
            b = mo10103c(c46087b, new String[0]);
            C4990ab.m7416i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "update ret " + b + " for memberUuid = " + j);
            rawQuery.close();
            AppMethodBeat.m2505o(54113);
            return b;
        } catch (Exception e) {
            b = e.toString();
            C4990ab.m7412e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", b);
            return false;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(54113);
        }
    }

    /* renamed from: dm */
    public final boolean mo62359dm(String str, String str2) {
        AppMethodBeat.m2504i(54114);
        C4990ab.m7416i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete where wxGroupId = " + str + ",member = " + str2);
        try {
            super.mo16768hY("MultiTalkMember", "delete from MultiTalkMember where wxGroupId = \"" + str + "\" and userName = \"" + str2 + "\"");
            AppMethodBeat.m2505o(54114);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete fail for wxGroupId = " + str + ",member = " + str2);
            AppMethodBeat.m2505o(54114);
            return false;
        }
    }

    /* renamed from: pI */
    public final boolean mo62361pI(String str) {
        AppMethodBeat.m2504i(54115);
        C4990ab.m7416i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete where wxGroupId = ".concat(String.valueOf(str)));
        try {
            super.mo16768hY("MultiTalkMember", "delete from MultiTalkMember where wxGroupId = \"" + str + "\"");
            AppMethodBeat.m2505o(54115);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete fail for wxGroupId = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(54115);
            return false;
        }
    }
}
