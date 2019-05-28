package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45042s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Creator<TimeSignalCommand> CREATOR = new C255501();
    public final long bfX;
    public final long bfY;

    /* renamed from: com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand$1 */
    static class C255501 implements Creator<TimeSignalCommand> {
        C255501() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TimeSignalCommand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95382);
            TimeSignalCommand timeSignalCommand = new TimeSignalCommand(parcel.readLong(), parcel.readLong(), (byte) 0);
            AppMethodBeat.m2505o(95382);
            return timeSignalCommand;
        }
    }

    /* synthetic */ TimeSignalCommand(long j, long j2, byte b) {
        this(j, j2);
    }

    private TimeSignalCommand(long j, long j2) {
        this.bfX = j;
        this.bfY = j2;
    }

    /* renamed from: b */
    static TimeSignalCommand m40386b(C32065l c32065l, long j, C45042s c45042s) {
        AppMethodBeat.m2504i(95383);
        long c = m40387c(c32065l, j);
        TimeSignalCommand timeSignalCommand = new TimeSignalCommand(c, c45042s.mo72551ao(c));
        AppMethodBeat.m2505o(95383);
        return timeSignalCommand;
    }

    /* renamed from: c */
    static long m40387c(C32065l c32065l, long j) {
        AppMethodBeat.m2504i(95384);
        long readUnsignedByte = (long) c32065l.readUnsignedByte();
        long j2 = -9223372036854775807L;
        if ((128 & readUnsignedByte) != 0) {
            j2 = ((((1 & readUnsignedByte) << 32) | c32065l.mo52366cM()) + j) & 8589934591L;
        }
        AppMethodBeat.m2505o(95384);
        return j2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95385);
        parcel.writeLong(this.bfX);
        parcel.writeLong(this.bfY);
        AppMethodBeat.m2505o(95385);
    }

    static {
        AppMethodBeat.m2504i(95386);
        AppMethodBeat.m2505o(95386);
    }
}
