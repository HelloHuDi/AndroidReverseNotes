package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class s extends j<r> implements a {
    public static final String[] fnj = new String[]{j.a(r.ccO, "SmileyPanelConfigInfo")};
    private static final String[] ybf = new String[]{"position", "key"};
    public e bSd;

    static {
        AppMethodBeat.i(62890);
        AppMethodBeat.o(62890);
    }

    public s(e eVar) {
        this(eVar, r.ccO, "SmileyPanelConfigInfo");
    }

    private s(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.bSd = eVar;
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<r> bjP() {
        Throwable e;
        AppMethodBeat.i(62889);
        ArrayList arrayList = new ArrayList();
        Cursor a;
        try {
            a = this.bSd.a("SmileyPanelConfigInfo", ybf, null, null, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            r rVar = new r();
                            rVar.d(a);
                            arrayList.add(rVar);
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.emoji.SmileyPanelConfigInfoStorage", bo.l(e));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62889);
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62889);
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(62889);
            throw e;
        }
        AppMethodBeat.o(62889);
        return arrayList;
    }
}
