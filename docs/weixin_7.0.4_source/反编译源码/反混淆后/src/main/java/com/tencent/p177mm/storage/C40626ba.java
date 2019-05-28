package com.tencent.p177mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C32248f;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;
import p000a.p1582e.C41372b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/storage/FunctionMsgStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/api/FunctionMsgItem;", "()V", "ALL_FUNCTION_MSG_ITEM_PROJECTION", "", "", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDb", "()Lcom/tencent/mm/storagebase/SqliteDB;", "deleteAllHandleFunctionMsg", "", "getAllNeedHandleFunctionMsg", "", "getByFunctionMsgId", "functionMsgId", "updateByFunctionMsgId", "newFunctionMsgItem", "plugin-functionmsg_release"})
/* renamed from: com.tencent.mm.storage.ba */
public final class C40626ba extends C7563j<C32248f> {
    private static final C7480h fni;
    private static final String[] xYZ = new String[]{"*", "rowid"};
    public static final C40626ba xZa = new C40626ba();

    static {
        AppMethodBeat.m2504i(35502);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        C7480h Ru = RP.mo5236Ru();
        if (Ru == null) {
            C25052j.dWJ();
        }
        fni = Ru;
        AppMethodBeat.m2505o(35502);
    }

    private C40626ba() {
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        super(RP.mo5236Ru(), C32248f.ccO, "FunctionMsgItem", new String[]{"CREATE INDEX IF NOT EXISTS functionIdIndex ON FunctionMsgItem(functionmsgid)"});
        AppMethodBeat.m2504i(35501);
        AppMethodBeat.m2505o(35501);
    }

    public static C32248f apy(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.m2504i(35497);
        C25052j.m39376p(str, "functionMsgId");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(35497);
            return null;
        }
        C4990ab.m7417i("FunctionMsg.FunctionMsgStorage", "getByFunctionMsgId, functionMsgId: %s", str);
        Cursor a = fni.mo10105a("FunctionMsgItem", xYZ, "functionmsgid=?", new String[]{str}, null, null, null, 2);
        Closeable closeable = a;
        if (a == null) {
            try {
                C25052j.dWJ();
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                C41372b.m72155a(closeable, th2);
                AppMethodBeat.m2505o(35497);
                throw th;
            }
        }
        if (a.moveToFirst()) {
            C32248f c32248f = new C32248f();
            c32248f.mo8995d(a);
            C41372b.m72155a(closeable, null);
            AppMethodBeat.m2505o(35497);
            return c32248f;
        }
        C37091y c37091y = C37091y.AUy;
        C41372b.m72155a(closeable, null);
        AppMethodBeat.m2505o(35497);
        return null;
    }

    /* renamed from: a */
    public static void m70154a(String str, C32248f c32248f) {
        AppMethodBeat.m2504i(35498);
        C25052j.m39376p(str, "functionMsgId");
        C25052j.m39376p(c32248f, "newFunctionMsgItem");
        C4990ab.m7417i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s", str);
        C32248f apy = C40626ba.apy(str);
        if (apy != null) {
            try {
                String str2 = "FunctionMsg.FunctionMsgStorage";
                String str3 = "updateByFunctionMsgId, functionMsgId: %s, newFunctionMsgItem.msgContent==null: %s,oldFunctionMsgItem.msgContent==null: %s";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(c32248f.mo52937Al() == null);
                objArr[2] = Boolean.valueOf(apy.mo52937Al() == null);
                C4990ab.m7417i(str2, str3, objArr);
                ContentValues Hl = c32248f.mo10098Hl();
                if (Hl.get("addMsg") == null && apy.mo52937Al() != null) {
                    str2 = "addMsg";
                    C7254cm Al = apy.mo52937Al();
                    if (Al == null) {
                        C25052j.dWJ();
                    }
                    Hl.put(str2, Al.toByteArray());
                }
                int update = fni.update("FunctionMsgItem", Hl, "functionmsgid=?", new String[]{str});
                C4990ab.m7417i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, ret: %s", Integer.valueOf(update));
                AppMethodBeat.m2505o(35498);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(35498);
    }

    public static List<C32248f> dtn() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.m2504i(35499);
        Closeable a = fni.mo10105a("FunctionMsgItem", xYZ, "status<=? and opCode!= -1", new String[]{"2"}, null, null, null, 2);
        try {
            Cursor cursor = (Cursor) a;
            ArrayList arrayList = new ArrayList();
            cursor.moveToFirst();
            while (true) {
                C25052j.m39375o(cursor, "it");
                if (cursor.isAfterLast()) {
                    List<C32248f> list = arrayList;
                    C41372b.m72155a(a, null);
                    AppMethodBeat.m2505o(35499);
                    return list;
                }
                C32248f c32248f = new C32248f();
                c32248f.mo8995d(cursor);
                arrayList.add(c32248f);
                cursor.moveToNext();
            }
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            C41372b.m72155a(a, th2);
            AppMethodBeat.m2505o(35499);
            throw th;
        }
    }

    public static void dto() {
        AppMethodBeat.m2504i(35500);
        int delete = fni.delete("FunctionMsgItem", "status=?", new String[]{"100"});
        C4990ab.m7416i("FunctionMsg.FunctionMsgStorage", "[deleteAllHandleFunctionMsg] ret1:" + delete + " ret2:" + fni.delete("FunctionMsgItem", "status=?", new String[]{TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL}));
        AppMethodBeat.m2505o(35500);
    }
}
