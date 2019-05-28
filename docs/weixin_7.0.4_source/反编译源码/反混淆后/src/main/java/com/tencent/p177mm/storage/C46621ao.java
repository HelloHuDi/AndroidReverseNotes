package com.tencent.p177mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3454c;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.storage.ao */
public final class C46621ao extends C7296k implements C3454c {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) ", "CREATE INDEX IF NOT EXISTS createTimeIndex  ON DeletedConversationInfo ( reserved2 )"};
    private final C1177f<String, Long> emX = new C7598c(50);
    private C7480h fni;

    public C46621ao(C7480h c7480h) {
        AppMethodBeat.m2504i(1273);
        this.fni = c7480h;
        AppMethodBeat.m2505o(1273);
    }

    /* renamed from: N */
    public final boolean mo7905N(String str, long j) {
        AppMethodBeat.m2504i(1274);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1274);
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", str);
        contentValues.put("lastSeq", Long.valueOf(j));
        contentValues.put("reserved2", Long.valueOf(mo7908QQ(str)));
        if (((int) this.fni.replace("DeletedConversationInfo", "userName", contentValues)) != -1) {
            anF(str);
            AppMethodBeat.m2505o(1274);
            return true;
        }
        AppMethodBeat.m2505o(1274);
        return false;
    }

    /* renamed from: QP */
    public final long mo7907QP(String str) {
        AppMethodBeat.m2504i(1275);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1275);
            return 0;
        }
        Cursor a = this.fni.mo10104a("select lastSeq from DeletedConversationInfo where userName = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            C4990ab.m7416i("MicroMsg.DeletedConversationInfoStorage", "getLastPushSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(1275);
            return 0;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.m2505o(1275);
            return j;
        } else {
            a.close();
            AppMethodBeat.m2505o(1275);
            return 0;
        }
    }

    /* renamed from: O */
    public final boolean mo7906O(String str, long j) {
        AppMethodBeat.m2504i(1276);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1276);
            return false;
        }
        this.emX.mo4412k(str, Long.valueOf(j));
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", str);
        contentValues.put("lastSeq", Long.valueOf(mo7907QP(str)));
        contentValues.put("reserved2", Long.valueOf(j));
        if (((int) this.fni.replace("DeletedConversationInfo", "userName", contentValues)) != -1) {
            anF(str);
            AppMethodBeat.m2505o(1276);
            return true;
        }
        AppMethodBeat.m2505o(1276);
        return false;
    }

    public final List<String> bOv() {
        AppMethodBeat.m2504i(1277);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.fni.mo10104a("select userName,reserved2 from DeletedConversationInfo where reserved2 > 0", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(1277);
        } else {
            if (a.moveToFirst()) {
                do {
                    String string = a.getString(0);
                    this.emX.mo4412k(string, Long.valueOf(a.getLong(1)));
                    arrayList.add(string);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.m2505o(1277);
        }
        return arrayList;
    }

    /* renamed from: QQ */
    public final long mo7908QQ(String str) {
        AppMethodBeat.m2504i(1278);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1278);
            return 0;
        }
        Long l = (Long) this.emX.get(str);
        long longValue;
        if (l != null) {
            longValue = l.longValue();
            AppMethodBeat.m2505o(1278);
            return longValue;
        }
        Cursor a = this.fni.mo10104a("select reserved2 from DeletedConversationInfo where userName = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            C4990ab.m7416i("MicroMsg.DeletedConversationInfoStorage", "getCreateTime failed ".concat(String.valueOf(str)));
            this.emX.mo4412k(str, Long.valueOf(0));
            AppMethodBeat.m2505o(1278);
            return 0;
        } else if (a.moveToFirst()) {
            longValue = a.getLong(0);
            this.emX.mo4412k(str, Long.valueOf(longValue));
            a.close();
            AppMethodBeat.m2505o(1278);
            return longValue;
        } else {
            a.close();
            AppMethodBeat.m2505o(1278);
            return 0;
        }
    }
}
