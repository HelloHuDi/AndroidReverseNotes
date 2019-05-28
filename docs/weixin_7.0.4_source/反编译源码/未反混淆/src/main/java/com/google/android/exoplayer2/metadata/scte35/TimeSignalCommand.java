package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Creator<TimeSignalCommand> CREATOR = new Creator<TimeSignalCommand>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TimeSignalCommand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95382);
            TimeSignalCommand timeSignalCommand = new TimeSignalCommand(parcel.readLong(), parcel.readLong(), (byte) 0);
            AppMethodBeat.o(95382);
            return timeSignalCommand;
        }
    };
    public final long bfX;
    public final long bfY;

    /* synthetic */ TimeSignalCommand(long j, long j2, byte b) {
        this(j, j2);
    }

    private TimeSignalCommand(long j, long j2) {
        this.bfX = j;
        this.bfY = j2;
    }

    static TimeSignalCommand b(l lVar, long j, s sVar) {
        AppMethodBeat.i(95383);
        long c = c(lVar, j);
        TimeSignalCommand timeSignalCommand = new TimeSignalCommand(c, sVar.ao(c));
        AppMethodBeat.o(95383);
        return timeSignalCommand;
    }

    static long c(l lVar, long j) {
        AppMethodBeat.i(95384);
        long readUnsignedByte = (long) lVar.readUnsignedByte();
        long j2 = -9223372036854775807L;
        if ((128 & readUnsignedByte) != 0) {
            j2 = ((((1 & readUnsignedByte) << 32) | lVar.cM()) + j) & 8589934591L;
        }
        AppMethodBeat.o(95384);
        return j2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95385);
        parcel.writeLong(this.bfX);
        parcel.writeLong(this.bfY);
        AppMethodBeat.o(95385);
    }

    static {
        AppMethodBeat.i(95386);
        AppMethodBeat.o(95386);
    }
}
