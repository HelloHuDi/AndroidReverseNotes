package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class l extends j<k> {
    public static final String[] fnj = new String[]{j.a(k.ccO, "BackupRecoverMsgListDataId")};
    public h fni;

    public final /* bridge */ /* synthetic */ boolean a(long j, c cVar) {
        AppMethodBeat.i(29016);
        boolean a = super.a(j, (k) cVar);
        AppMethodBeat.o(29016);
        return a;
    }

    static {
        AppMethodBeat.i(29017);
        AppMethodBeat.o(29017);
    }

    public l(h hVar) {
        super(hVar, k.ccO, "BackupRecoverMsgListDataId", null);
        this.fni = hVar;
    }

    public final String aoi(String str) {
        AppMethodBeat.i(29011);
        String str2 = "SELECT * FROM BackupRecoverMsgListDataId WHERE msgListDataId = \"" + str + "\" ";
        ab.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId:".concat(String.valueOf(str2)));
        Cursor a = this.fni.a(str2, null, 0);
        if (a == null) {
            ab.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId failed, msgListDataId:%s", str);
            AppMethodBeat.o(29011);
            return null;
        } else if (a.moveToFirst()) {
            k kVar = new k();
            kVar.d(a);
            a.close();
            String str3 = kVar.field_sessionName;
            AppMethodBeat.o(29011);
            return str3;
        } else {
            a.close();
            AppMethodBeat.o(29011);
            return null;
        }
    }

    public final HashMap<String, String> dry() {
        AppMethodBeat.i(29012);
        HashMap hashMap = new HashMap();
        Cursor baR = baR();
        if (baR == null) {
            ab.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getAllData failed.");
            AppMethodBeat.o(29012);
        } else {
            while (baR.moveToNext()) {
                k kVar = new k();
                kVar.d(baR);
                hashMap.put(kVar.field_msgListDataId, kVar.field_sessionName);
            }
            baR.close();
            AppMethodBeat.o(29012);
        }
        return hashMap;
    }

    public final boolean drz() {
        AppMethodBeat.i(29013);
        String str = "SELECT * FROM BackupRecoverMsgListDataId";
        ab.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist:".concat(String.valueOf(str)));
        Cursor a = this.fni.a(str, null, 0);
        if (a == null) {
            ab.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist failed.");
            AppMethodBeat.o(29013);
            return false;
        } else if (a.getCount() <= 0) {
            ab.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "No data in BackupRecoverMsgListDataIdStorage.");
            a.close();
            AppMethodBeat.o(29013);
            return false;
        } else {
            a.close();
            AppMethodBeat.o(29013);
            return true;
        }
    }

    public final int drA() {
        int i = 0;
        AppMethodBeat.i(29014);
        String str = "SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ";
        ab.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionCount:".concat(String.valueOf(str)));
        Cursor a = this.fni.a(str, null, 0);
        if (a.moveToLast()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(29014);
        return i;
    }

    public final boolean drx() {
        AppMethodBeat.i(29015);
        ab.i("MicroMsg.BackupRecoverMsgListDataIdStorage", "deleteAllData, result:%b", Boolean.valueOf(this.fni.hY("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId")));
        AppMethodBeat.o(29015);
        return this.fni.hY("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId");
    }
}
