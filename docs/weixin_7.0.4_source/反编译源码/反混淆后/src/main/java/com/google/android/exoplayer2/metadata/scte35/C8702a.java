package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.C17679a;
import com.google.android.exoplayer2.metadata.C36689d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.p111i.C32064k;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45042s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.metadata.scte35.a */
public final class C8702a implements C17679a {
    private C45042s aYf;
    private final C32065l bdm = new C32065l();
    private final C32064k bfE = new C32064k();

    public C8702a() {
        AppMethodBeat.m2504i(95363);
        AppMethodBeat.m2505o(95363);
    }

    /* renamed from: a */
    public final Metadata mo19234a(C36689d c36689d) {
        Entry entry;
        AppMethodBeat.m2504i(95364);
        if (this.aYf == null || c36689d.aOr != this.aYf.mo72553tQ()) {
            this.aYf = new C45042s(c36689d.aSk);
            this.aYf.mo72552ap(c36689d.aSk - c36689d.aOr);
        }
        ByteBuffer byteBuffer = c36689d.aEY;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.bdm.mo52371n(array, limit);
        this.bfE.mo52356n(array, limit);
        this.bfE.mo52355ee(39);
        long ed = ((long) this.bfE.mo52354ed(32)) | (((long) this.bfE.mo52354ed(1)) << 32);
        this.bfE.mo52355ee(20);
        int ed2 = this.bfE.mo52354ed(12);
        int ed3 = this.bfE.mo52354ed(8);
        this.bdm.mo52369eM(14);
        Object entry2;
        switch (ed3) {
            case 0:
                entry2 = new SpliceNullCommand();
                break;
            case 4:
                entry2 = SpliceScheduleCommand.m40384y(this.bdm);
                break;
            case 5:
                entry2 = SpliceInsertCommand.m62538a(this.bdm, ed, this.aYf);
                break;
            case 6:
                entry2 = TimeSignalCommand.m40386b(this.bdm, ed, this.aYf);
                break;
            case 255:
                entry2 = PrivateCommand.m27586a(this.bdm, ed2, ed);
                break;
            default:
                entry2 = null;
                break;
        }
        Metadata metadata;
        if (entry2 == null) {
            metadata = new Metadata(new Entry[0]);
            AppMethodBeat.m2505o(95364);
            return metadata;
        }
        metadata = new Metadata(entry2);
        AppMethodBeat.m2505o(95364);
        return metadata;
    }
}
