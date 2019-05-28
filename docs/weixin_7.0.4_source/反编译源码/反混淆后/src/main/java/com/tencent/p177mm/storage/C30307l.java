package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.storage.l */
public final class C30307l extends C7563j<C15442k> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C15442k.ccO, "BackupRecoverMsgListDataId")};
    public C7480h fni;

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo16757a(long j, C4925c c4925c) {
        AppMethodBeat.m2504i(29016);
        boolean a = super.mo16757a(j, (C15442k) c4925c);
        AppMethodBeat.m2505o(29016);
        return a;
    }

    static {
        AppMethodBeat.m2504i(29017);
        AppMethodBeat.m2505o(29017);
    }

    public C30307l(C7480h c7480h) {
        super(c7480h, C15442k.ccO, "BackupRecoverMsgListDataId", null);
        this.fni = c7480h;
    }

    public final String aoi(String str) {
        AppMethodBeat.m2504i(29011);
        String str2 = "SELECT * FROM BackupRecoverMsgListDataId WHERE msgListDataId = \"" + str + "\" ";
        C4990ab.m7410d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId:".concat(String.valueOf(str2)));
        Cursor a = this.fni.mo10104a(str2, null, 0);
        if (a == null) {
            C4990ab.m7413e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId failed, msgListDataId:%s", str);
            AppMethodBeat.m2505o(29011);
            return null;
        } else if (a.moveToFirst()) {
            C15442k c15442k = new C15442k();
            c15442k.mo8995d(a);
            a.close();
            String str3 = c15442k.field_sessionName;
            AppMethodBeat.m2505o(29011);
            return str3;
        } else {
            a.close();
            AppMethodBeat.m2505o(29011);
            return null;
        }
    }

    public final HashMap<String, String> dry() {
        AppMethodBeat.m2504i(29012);
        HashMap hashMap = new HashMap();
        Cursor baR = baR();
        if (baR == null) {
            C4990ab.m7412e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getAllData failed.");
            AppMethodBeat.m2505o(29012);
        } else {
            while (baR.moveToNext()) {
                C15442k c15442k = new C15442k();
                c15442k.mo8995d(baR);
                hashMap.put(c15442k.field_msgListDataId, c15442k.field_sessionName);
            }
            baR.close();
            AppMethodBeat.m2505o(29012);
        }
        return hashMap;
    }

    public final boolean drz() {
        AppMethodBeat.m2504i(29013);
        String str = "SELECT * FROM BackupRecoverMsgListDataId";
        C4990ab.m7410d("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist:".concat(String.valueOf(str)));
        Cursor a = this.fni.mo10104a(str, null, 0);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist failed.");
            AppMethodBeat.m2505o(29013);
            return false;
        } else if (a.getCount() <= 0) {
            C4990ab.m7412e("MicroMsg.BackupRecoverMsgListDataIdStorage", "No data in BackupRecoverMsgListDataIdStorage.");
            a.close();
            AppMethodBeat.m2505o(29013);
            return false;
        } else {
            a.close();
            AppMethodBeat.m2505o(29013);
            return true;
        }
    }

    public final int drA() {
        int i = 0;
        AppMethodBeat.m2504i(29014);
        String str = "SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ";
        C4990ab.m7410d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionCount:".concat(String.valueOf(str)));
        Cursor a = this.fni.mo10104a(str, null, 0);
        if (a.moveToLast()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(29014);
        return i;
    }

    public final boolean drx() {
        AppMethodBeat.m2504i(29015);
        C4990ab.m7417i("MicroMsg.BackupRecoverMsgListDataIdStorage", "deleteAllData, result:%b", Boolean.valueOf(this.fni.mo10108hY("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId")));
        AppMethodBeat.m2505o(29015);
        return this.fni.mo10108hY("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId");
    }
}
