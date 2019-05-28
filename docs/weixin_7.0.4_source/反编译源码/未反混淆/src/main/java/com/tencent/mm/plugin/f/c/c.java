package com.tencent.mm.plugin.f.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class c implements Runnable {
    public boolean isStop;
    private String kaj;
    private long kak;
    private a kal;
    private int limit;

    public interface a {
        void finish();
    }

    public c(String str, long j, int i, a aVar) {
        AppMethodBeat.i(18645);
        this.kaj = str;
        this.kak = j;
        this.limit = i;
        this.kal = aVar;
        ab.d("MicroMsg.ScanMsgTask", "%d scan msg[%d %d]", Integer.valueOf(hashCode()), Long.valueOf(this.kak), Integer.valueOf(this.limit));
        AppMethodBeat.o(18645);
    }

    public final void run() {
        int i = 0;
        AppMethodBeat.i(18646);
        if (this.isStop) {
            AppMethodBeat.o(18646);
            return;
        }
        long yz = bo.yz();
        Cursor cursor = null;
        try {
            aw.ZK();
            cursor = com.tencent.mm.model.c.XO().h(this.kaj, this.kak, this.limit);
            yz = bo.az(yz);
            b.aZc();
            b.C(this.limit, yz);
            while (cursor.moveToNext()) {
                i++;
                bi biVar = new bi();
                biVar.d(cursor);
                b.aZc().O(biVar);
                b.aZc().gS(biVar.field_msgId);
                if (this.isStop) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.o(18646);
                    return;
                }
            }
            ab.d("MicroMsg.ScanMsgTask", "%d scan msg count[%d] limit[%d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.limit));
            if (i < this.limit) {
                b aZc = b.aZc();
                b.aZc();
                aZc.gS(b.aZf());
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ScanMsgTask", e, "", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(18646);
        }
        if (this.kal != null) {
            this.kal.finish();
        }
        AppMethodBeat.o(18646);
    }
}
