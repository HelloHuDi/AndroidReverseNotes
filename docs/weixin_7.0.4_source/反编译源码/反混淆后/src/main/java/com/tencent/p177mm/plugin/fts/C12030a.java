package com.tencent.p177mm.plugin.fts;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.fts.a */
public final class C12030a extends CursorWrapper {
    private static HashSet<Cursor> mAI = new HashSet();

    static {
        AppMethodBeat.m2504i(136516);
        AppMethodBeat.m2505o(136516);
    }

    public C12030a(Cursor cursor) {
        super(cursor);
        AppMethodBeat.m2504i(136513);
        mAI.add(cursor);
        C4990ab.m7419v("MicroMsg.FTS.FTSCursor", "add cursor %d", Integer.valueOf(cursor.hashCode()));
        AppMethodBeat.m2505o(136513);
    }

    public final void close() {
        AppMethodBeat.m2504i(136514);
        super.close();
        mAI.remove(getWrappedCursor());
        C4990ab.m7419v("MicroMsg.FTS.FTSCursor", "remove cursor %d", Integer.valueOf(r0.hashCode()));
        AppMethodBeat.m2505o(136514);
    }

    public static final void bzU() {
        AppMethodBeat.m2504i(136515);
        Iterator it = mAI.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) it.next();
            if (!cursor.isClosed()) {
                try {
                    cursor.close();
                } catch (Exception e) {
                }
                C4990ab.m7413e("MicroMsg.FTS.FTSCursor", "not close cursor!!! %d", Integer.valueOf(cursor.hashCode()));
            }
        }
        mAI.clear();
        AppMethodBeat.m2505o(136515);
    }
}
