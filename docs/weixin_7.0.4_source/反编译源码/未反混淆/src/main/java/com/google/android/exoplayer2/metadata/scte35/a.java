package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.s;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class a implements com.google.android.exoplayer2.metadata.a {
    private s aYf;
    private final l bdm = new l();
    private final k bfE = new k();

    public a() {
        AppMethodBeat.i(95363);
        AppMethodBeat.o(95363);
    }

    public final Metadata a(d dVar) {
        Entry entry;
        AppMethodBeat.i(95364);
        if (this.aYf == null || dVar.aOr != this.aYf.tQ()) {
            this.aYf = new s(dVar.aSk);
            this.aYf.ap(dVar.aSk - dVar.aOr);
        }
        ByteBuffer byteBuffer = dVar.aEY;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.bdm.n(array, limit);
        this.bfE.n(array, limit);
        this.bfE.ee(39);
        long ed = ((long) this.bfE.ed(32)) | (((long) this.bfE.ed(1)) << 32);
        this.bfE.ee(20);
        int ed2 = this.bfE.ed(12);
        int ed3 = this.bfE.ed(8);
        this.bdm.eM(14);
        Object entry2;
        switch (ed3) {
            case 0:
                entry2 = new SpliceNullCommand();
                break;
            case 4:
                entry2 = SpliceScheduleCommand.y(this.bdm);
                break;
            case 5:
                entry2 = SpliceInsertCommand.a(this.bdm, ed, this.aYf);
                break;
            case 6:
                entry2 = TimeSignalCommand.b(this.bdm, ed, this.aYf);
                break;
            case 255:
                entry2 = PrivateCommand.a(this.bdm, ed2, ed);
                break;
            default:
                entry2 = null;
                break;
        }
        Metadata metadata;
        if (entry2 == null) {
            metadata = new Metadata(new Entry[0]);
            AppMethodBeat.o(95364);
            return metadata;
        }
        metadata = new Metadata(entry2);
        AppMethodBeat.o(95364);
        return metadata;
    }
}
