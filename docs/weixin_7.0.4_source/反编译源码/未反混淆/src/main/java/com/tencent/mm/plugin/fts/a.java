package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Iterator;

public final class a extends CursorWrapper {
    private static HashSet<Cursor> mAI = new HashSet();

    static {
        AppMethodBeat.i(136516);
        AppMethodBeat.o(136516);
    }

    public a(Cursor cursor) {
        super(cursor);
        AppMethodBeat.i(136513);
        mAI.add(cursor);
        ab.v("MicroMsg.FTS.FTSCursor", "add cursor %d", Integer.valueOf(cursor.hashCode()));
        AppMethodBeat.o(136513);
    }

    public final void close() {
        AppMethodBeat.i(136514);
        super.close();
        mAI.remove(getWrappedCursor());
        ab.v("MicroMsg.FTS.FTSCursor", "remove cursor %d", Integer.valueOf(r0.hashCode()));
        AppMethodBeat.o(136514);
    }

    public static final void bzU() {
        AppMethodBeat.i(136515);
        Iterator it = mAI.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) it.next();
            if (!cursor.isClosed()) {
                try {
                    cursor.close();
                } catch (Exception e) {
                }
                ab.e("MicroMsg.FTS.FTSCursor", "not close cursor!!! %d", Integer.valueOf(cursor.hashCode()));
            }
        }
        mAI.clear();
        AppMethodBeat.o(136515);
    }
}
