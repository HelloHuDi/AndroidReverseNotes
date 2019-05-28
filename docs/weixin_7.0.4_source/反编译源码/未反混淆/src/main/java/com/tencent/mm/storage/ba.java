package com.tencent.mm.storage;

import a.e.b;
import a.l;
import a.y;
import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.f;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/storage/FunctionMsgStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/api/FunctionMsgItem;", "()V", "ALL_FUNCTION_MSG_ITEM_PROJECTION", "", "", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDb", "()Lcom/tencent/mm/storagebase/SqliteDB;", "deleteAllHandleFunctionMsg", "", "getAllNeedHandleFunctionMsg", "", "getByFunctionMsgId", "functionMsgId", "updateByFunctionMsgId", "newFunctionMsgItem", "plugin-functionmsg_release"})
public final class ba extends j<f> {
    private static final h fni;
    private static final String[] xYZ = new String[]{"*", "rowid"};
    public static final ba xZa = new ba();

    static {
        AppMethodBeat.i(35502);
        e RP = g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        h Ru = RP.Ru();
        if (Ru == null) {
            a.f.b.j.dWJ();
        }
        fni = Ru;
        AppMethodBeat.o(35502);
    }

    private ba() {
        e RP = g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        super(RP.Ru(), f.ccO, "FunctionMsgItem", new String[]{"CREATE INDEX IF NOT EXISTS functionIdIndex ON FunctionMsgItem(functionmsgid)"});
        AppMethodBeat.i(35501);
        AppMethodBeat.o(35501);
    }

    public static f apy(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(35497);
        a.f.b.j.p(str, "functionMsgId");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(35497);
            return null;
        }
        ab.i("FunctionMsg.FunctionMsgStorage", "getByFunctionMsgId, functionMsgId: %s", str);
        Cursor a = fni.a("FunctionMsgItem", xYZ, "functionmsgid=?", new String[]{str}, null, null, null, 2);
        Closeable closeable = a;
        if (a == null) {
            try {
                a.f.b.j.dWJ();
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                b.a(closeable, th2);
                AppMethodBeat.o(35497);
                throw th;
            }
        }
        if (a.moveToFirst()) {
            f fVar = new f();
            fVar.d(a);
            b.a(closeable, null);
            AppMethodBeat.o(35497);
            return fVar;
        }
        y yVar = y.AUy;
        b.a(closeable, null);
        AppMethodBeat.o(35497);
        return null;
    }

    public static void a(String str, f fVar) {
        AppMethodBeat.i(35498);
        a.f.b.j.p(str, "functionMsgId");
        a.f.b.j.p(fVar, "newFunctionMsgItem");
        ab.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s", str);
        f apy = apy(str);
        if (apy != null) {
            try {
                String str2 = "FunctionMsg.FunctionMsgStorage";
                String str3 = "updateByFunctionMsgId, functionMsgId: %s, newFunctionMsgItem.msgContent==null: %s,oldFunctionMsgItem.msgContent==null: %s";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(fVar.Al() == null);
                objArr[2] = Boolean.valueOf(apy.Al() == null);
                ab.i(str2, str3, objArr);
                ContentValues Hl = fVar.Hl();
                if (Hl.get("addMsg") == null && apy.Al() != null) {
                    str2 = "addMsg";
                    cm Al = apy.Al();
                    if (Al == null) {
                        a.f.b.j.dWJ();
                    }
                    Hl.put(str2, Al.toByteArray());
                }
                int update = fni.update("FunctionMsgItem", Hl, "functionmsgid=?", new String[]{str});
                ab.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, ret: %s", Integer.valueOf(update));
                AppMethodBeat.o(35498);
                return;
            } catch (Exception e) {
                ab.e("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(35498);
    }

    public static List<f> dtn() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(35499);
        Closeable a = fni.a("FunctionMsgItem", xYZ, "status<=? and opCode!= -1", new String[]{"2"}, null, null, null, 2);
        try {
            Cursor cursor = (Cursor) a;
            ArrayList arrayList = new ArrayList();
            cursor.moveToFirst();
            while (true) {
                a.f.b.j.o(cursor, "it");
                if (cursor.isAfterLast()) {
                    List<f> list = arrayList;
                    b.a(a, null);
                    AppMethodBeat.o(35499);
                    return list;
                }
                f fVar = new f();
                fVar.d(cursor);
                arrayList.add(fVar);
                cursor.moveToNext();
            }
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(a, th2);
            AppMethodBeat.o(35499);
            throw th;
        }
    }

    public static void dto() {
        AppMethodBeat.i(35500);
        int delete = fni.delete("FunctionMsgItem", "status=?", new String[]{"100"});
        ab.i("FunctionMsg.FunctionMsgStorage", "[deleteAllHandleFunctionMsg] ret1:" + delete + " ret2:" + fni.delete("FunctionMsgItem", "status=?", new String[]{TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL}));
        AppMethodBeat.o(35500);
    }
}
