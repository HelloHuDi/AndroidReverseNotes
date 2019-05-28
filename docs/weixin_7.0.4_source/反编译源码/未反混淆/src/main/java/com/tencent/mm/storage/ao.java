package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.cd.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class ao extends k implements c {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) ", "CREATE INDEX IF NOT EXISTS createTimeIndex  ON DeletedConversationInfo ( reserved2 )"};
    private final f<String, Long> emX = new com.tencent.mm.memory.a.c(50);
    private h fni;

    public ao(h hVar) {
        AppMethodBeat.i(1273);
        this.fni = hVar;
        AppMethodBeat.o(1273);
    }

    public final boolean N(String str, long j) {
        AppMethodBeat.i(1274);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1274);
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", str);
        contentValues.put("lastSeq", Long.valueOf(j));
        contentValues.put("reserved2", Long.valueOf(QQ(str)));
        if (((int) this.fni.replace("DeletedConversationInfo", "userName", contentValues)) != -1) {
            anF(str);
            AppMethodBeat.o(1274);
            return true;
        }
        AppMethodBeat.o(1274);
        return false;
    }

    public final long QP(String str) {
        AppMethodBeat.i(1275);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1275);
            return 0;
        }
        Cursor a = this.fni.a("select lastSeq from DeletedConversationInfo where userName = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            ab.i("MicroMsg.DeletedConversationInfoStorage", "getLastPushSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(1275);
            return 0;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.o(1275);
            return j;
        } else {
            a.close();
            AppMethodBeat.o(1275);
            return 0;
        }
    }

    public final boolean O(String str, long j) {
        AppMethodBeat.i(1276);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1276);
            return false;
        }
        this.emX.k(str, Long.valueOf(j));
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", str);
        contentValues.put("lastSeq", Long.valueOf(QP(str)));
        contentValues.put("reserved2", Long.valueOf(j));
        if (((int) this.fni.replace("DeletedConversationInfo", "userName", contentValues)) != -1) {
            anF(str);
            AppMethodBeat.o(1276);
            return true;
        }
        AppMethodBeat.o(1276);
        return false;
    }

    public final List<String> bOv() {
        AppMethodBeat.i(1277);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.fni.a("select userName,reserved2 from DeletedConversationInfo where reserved2 > 0", null, 2);
        if (a == null) {
            AppMethodBeat.o(1277);
        } else {
            if (a.moveToFirst()) {
                do {
                    String string = a.getString(0);
                    this.emX.k(string, Long.valueOf(a.getLong(1)));
                    arrayList.add(string);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.o(1277);
        }
        return arrayList;
    }

    public final long QQ(String str) {
        AppMethodBeat.i(1278);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1278);
            return 0;
        }
        Long l = (Long) this.emX.get(str);
        long longValue;
        if (l != null) {
            longValue = l.longValue();
            AppMethodBeat.o(1278);
            return longValue;
        }
        Cursor a = this.fni.a("select reserved2 from DeletedConversationInfo where userName = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            ab.i("MicroMsg.DeletedConversationInfoStorage", "getCreateTime failed ".concat(String.valueOf(str)));
            this.emX.k(str, Long.valueOf(0));
            AppMethodBeat.o(1278);
            return 0;
        } else if (a.moveToFirst()) {
            longValue = a.getLong(0);
            this.emX.k(str, Long.valueOf(longValue));
            a.close();
            AppMethodBeat.o(1278);
            return longValue;
        } else {
            a.close();
            AppMethodBeat.o(1278);
            return 0;
        }
    }
}
