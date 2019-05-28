package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PrivateCommand extends SpliceCommand {
    public static final Creator<PrivateCommand> CREATOR = new Creator<PrivateCommand>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PrivateCommand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95358);
            PrivateCommand privateCommand = new PrivateCommand(parcel, (byte) 0);
            AppMethodBeat.o(95358);
            return privateCommand;
        }
    };
    public final long bfB;
    public final long bfC;
    public final byte[] bfD;

    /* synthetic */ PrivateCommand(Parcel parcel, byte b) {
        this(parcel);
    }

    private PrivateCommand(long j, byte[] bArr, long j2) {
        this.bfB = j2;
        this.bfC = j;
        this.bfD = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        AppMethodBeat.i(95359);
        this.bfB = parcel.readLong();
        this.bfC = parcel.readLong();
        this.bfD = new byte[parcel.readInt()];
        parcel.readByteArray(this.bfD);
        AppMethodBeat.o(95359);
    }

    static PrivateCommand a(l lVar, int i, long j) {
        AppMethodBeat.i(95360);
        long cM = lVar.cM();
        byte[] bArr = new byte[(i - 4)];
        lVar.readBytes(bArr, 0, bArr.length);
        PrivateCommand privateCommand = new PrivateCommand(cM, bArr, j);
        AppMethodBeat.o(95360);
        return privateCommand;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95361);
        parcel.writeLong(this.bfB);
        parcel.writeLong(this.bfC);
        parcel.writeInt(this.bfD.length);
        parcel.writeByteArray(this.bfD);
        AppMethodBeat.o(95361);
    }

    static {
        AppMethodBeat.i(95362);
        AppMethodBeat.o(95362);
    }
}
