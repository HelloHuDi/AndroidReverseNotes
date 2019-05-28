package com.tencent.p177mm.plugin.p398f.p399c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.p398f.C45913b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.f.c.c */
public final class C3013c implements Runnable {
    public boolean isStop;
    private String kaj;
    private long kak;
    private C3014a kal;
    private int limit;

    /* renamed from: com.tencent.mm.plugin.f.c.c$a */
    public interface C3014a {
        void finish();
    }

    public C3013c(String str, long j, int i, C3014a c3014a) {
        AppMethodBeat.m2504i(18645);
        this.kaj = str;
        this.kak = j;
        this.limit = i;
        this.kal = c3014a;
        C4990ab.m7411d("MicroMsg.ScanMsgTask", "%d scan msg[%d %d]", Integer.valueOf(hashCode()), Long.valueOf(this.kak), Integer.valueOf(this.limit));
        AppMethodBeat.m2505o(18645);
    }

    public final void run() {
        int i = 0;
        AppMethodBeat.m2504i(18646);
        if (this.isStop) {
            AppMethodBeat.m2505o(18646);
            return;
        }
        long yz = C5046bo.m7588yz();
        Cursor cursor = null;
        try {
            C9638aw.m17190ZK();
            cursor = C18628c.m29080XO().mo15338h(this.kaj, this.kak, this.limit);
            yz = C5046bo.m7525az(yz);
            C45913b.aZc();
            C45913b.m85153C(this.limit, yz);
            while (cursor.moveToNext()) {
                i++;
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo8995d(cursor);
                C45913b.aZc().mo73748O(c7620bi);
                C45913b.aZc().mo73756gS(c7620bi.field_msgId);
                if (this.isStop) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.m2505o(18646);
                    return;
                }
            }
            C4990ab.m7411d("MicroMsg.ScanMsgTask", "%d scan msg count[%d] limit[%d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.limit));
            if (i < this.limit) {
                C45913b aZc = C45913b.aZc();
                C45913b.aZc();
                aZc.mo73756gS(C45913b.aZf());
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ScanMsgTask", e, "", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(18646);
        }
        if (this.kal != null) {
            this.kal.finish();
        }
        AppMethodBeat.m2505o(18646);
    }
}
