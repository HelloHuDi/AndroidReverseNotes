package com.tencent.p177mm.plugin.expt.roomexpt;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.expt.roomexpt.b */
public final class C11763b extends C7563j<C38992e> {
    public static final String[] diI = new String[0];
    public static final String[] fnj = new String[]{C7563j.m13217a(C38992e.ccO, "RoomMuteExpt"), "CREATE UNIQUE INDEX IF NOT EXISTS namedayIndex ON RoomMuteExpt( chatroom,daySec )"};
    C4927e bSd;

    static {
        AppMethodBeat.m2504i(73587);
        AppMethodBeat.m2505o(73587);
    }

    public C11763b(C4927e c4927e) {
        super(c4927e, C38992e.ccO, "RoomMuteExpt", diI);
        this.bSd = c4927e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: eh */
    public final C38992e mo23556eh(String str, String str2) {
        C38992e c38992e;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(73582);
        Cursor query;
        try {
            query = this.bSd.query("RoomMuteExpt", null, "chatroom=? AND daySec=?", new String[]{str, str2}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        c38992e = new C38992e();
                        try {
                            c38992e.mo8995d(query);
                            if (query != null) {
                                query.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                C4990ab.m7413e("MicroMsg.ChatRoomExptStorage", "getRoomExpt item error[%s]", e.toString());
                                if (query != null) {
                                }
                                AppMethodBeat.m2505o(73582);
                                return c38992e;
                            } catch (Throwable th2) {
                                th = th2;
                                if (query != null) {
                                    query.close();
                                }
                                AppMethodBeat.m2505o(73582);
                                throw th;
                            }
                        }
                        AppMethodBeat.m2505o(73582);
                        return c38992e;
                    }
                } catch (Exception e3) {
                    e = e3;
                    c38992e = null;
                    C4990ab.m7413e("MicroMsg.ChatRoomExptStorage", "getRoomExpt item error[%s]", e.toString());
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(73582);
                    return c38992e;
                }
            }
            c38992e = null;
            if (query != null) {
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            c38992e = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(73582);
            throw th;
        }
        AppMethodBeat.m2505o(73582);
        return c38992e;
    }

    /* renamed from: b */
    public final boolean mo23552b(C38992e c38992e) {
        AppMethodBeat.m2504i(73583);
        boolean a = super.mo16759a((C4925c) c38992e, false);
        AppMethodBeat.m2505o(73583);
        return a;
    }

    /* renamed from: c */
    public final boolean mo23555c(C38992e c38992e) {
        AppMethodBeat.m2504i(73584);
        if (c38992e == null) {
            AppMethodBeat.m2505o(73584);
            return false;
        }
        boolean b = super.mo16762b(c38992e, false, "chatroom", "daySec");
        AppMethodBeat.m2505o(73584);
        return b;
    }

    public final Cursor brm() {
        Cursor cursor = null;
        AppMethodBeat.m2504i(73585);
        try {
            cursor = this.bSd.rawQuery("SELECT chatroom, nickname, isMute, count(daySec), sum(score) FROM RoomMuteExpt group by chatroom", null);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ChatRoomExptStorage", e, "get calc cursor", new Object[0]);
        }
        AppMethodBeat.m2505o(73585);
        return cursor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<C38992e> brn() {
        Throwable e;
        AppMethodBeat.m2504i(73586);
        ArrayList arrayList = new ArrayList();
        Cursor query;
        try {
            query = this.bSd.query("RoomMuteExpt", null, null, null, null, null, "chatroom,daySec ASC");
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        C38992e c38992e = new C38992e();
                        c38992e.mo8995d(query);
                        arrayList.add(c38992e);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.ChatRoomExptStorage", e, "getAllExpt", new Object[0]);
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.m2505o(73586);
                            return arrayList;
                        } catch (Throwable th) {
                            e = th;
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.m2505o(73586);
                            throw e;
                        }
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(73586);
            throw e;
        }
        AppMethodBeat.m2505o(73586);
        return arrayList;
    }
}
