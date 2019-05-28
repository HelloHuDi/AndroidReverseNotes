package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PrivateCommand extends SpliceCommand {
    public static final Creator<PrivateCommand> CREATOR = new C87001();
    public final long bfB;
    public final long bfC;
    public final byte[] bfD;

    /* renamed from: com.google.android.exoplayer2.metadata.scte35.PrivateCommand$1 */
    static class C87001 implements Creator<PrivateCommand> {
        C87001() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PrivateCommand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95358);
            PrivateCommand privateCommand = new PrivateCommand(parcel, (byte) 0);
            AppMethodBeat.m2505o(95358);
            return privateCommand;
        }
    }

    /* synthetic */ PrivateCommand(Parcel parcel, byte b) {
        this(parcel);
    }

    private PrivateCommand(long j, byte[] bArr, long j2) {
        this.bfB = j2;
        this.bfC = j;
        this.bfD = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        AppMethodBeat.m2504i(95359);
        this.bfB = parcel.readLong();
        this.bfC = parcel.readLong();
        this.bfD = new byte[parcel.readInt()];
        parcel.readByteArray(this.bfD);
        AppMethodBeat.m2505o(95359);
    }

    /* renamed from: a */
    static PrivateCommand m27586a(C32065l c32065l, int i, long j) {
        AppMethodBeat.m2504i(95360);
        long cM = c32065l.mo52366cM();
        byte[] bArr = new byte[(i - 4)];
        c32065l.readBytes(bArr, 0, bArr.length);
        PrivateCommand privateCommand = new PrivateCommand(cM, bArr, j);
        AppMethodBeat.m2505o(95360);
        return privateCommand;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95361);
        parcel.writeLong(this.bfB);
        parcel.writeLong(this.bfC);
        parcel.writeInt(this.bfD.length);
        parcel.writeByteArray(this.bfD);
        AppMethodBeat.m2505o(95361);
    }

    static {
        AppMethodBeat.m2504i(95362);
        AppMethodBeat.m2505o(95362);
    }
}
