package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;

public final class q extends j<SmileyInfo> implements a {
    public static final String[] fnj = new String[]{j.a(SmileyInfo.ccO, "SmileyInfo")};
    private static final String[] ybd = new String[]{"key", "cnValue", "qqValue", "enValue", "twValue", "thValue", "eggIndex", DownloadInfo.FILENAME};
    private static final String[] ybe = new String[]{"key"};
    private e bSd;

    static {
        AppMethodBeat.i(62886);
        AppMethodBeat.o(62886);
    }

    public q(e eVar) {
        this(eVar, SmileyInfo.ccO, "SmileyInfo");
    }

    private q(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.bSd = eVar;
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<SmileyInfo> bjO() {
        Throwable e;
        AppMethodBeat.i(62884);
        ArrayList arrayList = new ArrayList();
        Cursor a;
        try {
            a = this.bSd.a("SmileyInfo", ybd, "flag=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            SmileyInfo smileyInfo = new SmileyInfo();
                            smileyInfo.d(a);
                            smileyInfo.field_position = -1;
                            arrayList.add(smileyInfo);
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.emoji.NewSmileyInfoStorage", bo.l(e));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62884);
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62884);
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
            AppMethodBeat.o(62884);
            throw e;
        }
        AppMethodBeat.o(62884);
        return arrayList;
    }

    public final boolean an(ArrayList<SmileyInfo> arrayList) {
        AppMethodBeat.i(62885);
        if (arrayList == null || arrayList.size() <= 0) {
            ab.i("MicroMsg.emoji.NewSmileyInfoStorage", "insertSmileyInfoList failed. list is null.");
            AppMethodBeat.o(62885);
            return false;
        }
        long iV;
        h hVar;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            iV = hVar2.iV(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            iV = -1;
            hVar = null;
        }
        this.bSd.delete("SmileyInfo", null, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b((c) (SmileyInfo) it.next());
        }
        int i = -1;
        if (hVar != null) {
            i = hVar.mB(iV);
        }
        if (i >= 0) {
            AppMethodBeat.o(62885);
            return true;
        }
        AppMethodBeat.o(62885);
        return false;
    }
}
