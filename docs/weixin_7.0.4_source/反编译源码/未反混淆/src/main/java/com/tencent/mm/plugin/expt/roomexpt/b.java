package com.tencent.mm.plugin.expt.roomexpt;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class b extends j<e> {
    public static final String[] diI = new String[0];
    public static final String[] fnj = new String[]{j.a(e.ccO, "RoomMuteExpt"), "CREATE UNIQUE INDEX IF NOT EXISTS namedayIndex ON RoomMuteExpt( chatroom,daySec )"};
    e bSd;

    static {
        AppMethodBeat.i(73587);
        AppMethodBeat.o(73587);
    }

    public b(e eVar) {
        super(eVar, e.ccO, "RoomMuteExpt", diI);
        this.bSd = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final e eh(String str, String str2) {
        e eVar;
        Exception e;
        Throwable th;
        AppMethodBeat.i(73582);
        Cursor query;
        try {
            query = this.bSd.query("RoomMuteExpt", null, "chatroom=? AND daySec=?", new String[]{str, str2}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        eVar = new e();
                        try {
                            eVar.d(query);
                            if (query != null) {
                                query.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                ab.e("MicroMsg.ChatRoomExptStorage", "getRoomExpt item error[%s]", e.toString());
                                if (query != null) {
                                }
                                AppMethodBeat.o(73582);
                                return eVar;
                            } catch (Throwable th2) {
                                th = th2;
                                if (query != null) {
                                    query.close();
                                }
                                AppMethodBeat.o(73582);
                                throw th;
                            }
                        }
                        AppMethodBeat.o(73582);
                        return eVar;
                    }
                } catch (Exception e3) {
                    e = e3;
                    eVar = null;
                    ab.e("MicroMsg.ChatRoomExptStorage", "getRoomExpt item error[%s]", e.toString());
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.o(73582);
                    return eVar;
                }
            }
            eVar = null;
            if (query != null) {
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            eVar = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.o(73582);
            throw th;
        }
        AppMethodBeat.o(73582);
        return eVar;
    }

    public final boolean b(e eVar) {
        AppMethodBeat.i(73583);
        boolean a = super.a((c) eVar, false);
        AppMethodBeat.o(73583);
        return a;
    }

    public final boolean c(e eVar) {
        AppMethodBeat.i(73584);
        if (eVar == null) {
            AppMethodBeat.o(73584);
            return false;
        }
        boolean b = super.b(eVar, false, "chatroom", "daySec");
        AppMethodBeat.o(73584);
        return b;
    }

    public final Cursor brm() {
        Cursor cursor = null;
        AppMethodBeat.i(73585);
        try {
            cursor = this.bSd.rawQuery("SELECT chatroom, nickname, isMute, count(daySec), sum(score) FROM RoomMuteExpt group by chatroom", null);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ChatRoomExptStorage", e, "get calc cursor", new Object[0]);
        }
        AppMethodBeat.o(73585);
        return cursor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<e> brn() {
        Throwable e;
        AppMethodBeat.i(73586);
        ArrayList arrayList = new ArrayList();
        Cursor query;
        try {
            query = this.bSd.query("RoomMuteExpt", null, null, null, null, null, "chatroom,daySec ASC");
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        e eVar = new e();
                        eVar.d(query);
                        arrayList.add(eVar);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            ab.printErrStackTrace("MicroMsg.ChatRoomExptStorage", e, "getAllExpt", new Object[0]);
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.o(73586);
                            return arrayList;
                        } catch (Throwable th) {
                            e = th;
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.o(73586);
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
            AppMethodBeat.o(73586);
            throw e;
        }
        AppMethodBeat.o(73586);
        return arrayList;
    }
}
