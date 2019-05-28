package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Creator<SpliceScheduleCommand> CREATOR = new Creator<SpliceScheduleCommand>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95373);
            SpliceScheduleCommand spliceScheduleCommand = new SpliceScheduleCommand(parcel, (byte) 0);
            AppMethodBeat.o(95373);
            return spliceScheduleCommand;
        }
    };
    public final List<b> bfV;

    public static final class b {
        public final long bfF;
        public final boolean bfG;
        public final boolean bfH;
        public final boolean bfI;
        public final List<a> bfM;
        public final boolean bfN;
        public final long bfO;
        public final int bfP;
        public final int bfQ;
        public final int bfR;
        public final long bfW;

        private b(long j, boolean z, boolean z2, boolean z3, List<a> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            AppMethodBeat.i(95374);
            this.bfF = j;
            this.bfG = z;
            this.bfH = z2;
            this.bfI = z3;
            this.bfM = Collections.unmodifiableList(list);
            this.bfW = j2;
            this.bfN = z4;
            this.bfO = j3;
            this.bfP = i;
            this.bfQ = i2;
            this.bfR = i3;
            AppMethodBeat.o(95374);
        }

        b(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(95375);
            this.bfF = parcel.readLong();
            this.bfG = parcel.readByte() == (byte) 1;
            if (parcel.readByte() == (byte) 1) {
                z = true;
            } else {
                z = false;
            }
            this.bfH = z;
            if (parcel.readByte() == (byte) 1) {
                z = true;
            } else {
                z = false;
            }
            this.bfI = z;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                arrayList.add(new a(parcel.readInt(), parcel.readLong()));
            }
            this.bfM = Collections.unmodifiableList(arrayList);
            this.bfW = parcel.readLong();
            if (parcel.readByte() != (byte) 1) {
                z2 = false;
            }
            this.bfN = z2;
            this.bfO = parcel.readLong();
            this.bfP = parcel.readInt();
            this.bfQ = parcel.readInt();
            this.bfR = parcel.readInt();
            AppMethodBeat.o(95375);
        }

        static b z(l lVar) {
            long j;
            AppMethodBeat.i(95376);
            long cM = lVar.cM();
            boolean z = (lVar.readUnsignedByte() & 128) != 0;
            boolean z2 = false;
            boolean z3 = false;
            long j2 = -9223372036854775807L;
            List arrayList = new ArrayList();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            boolean z4 = false;
            if (z) {
                j = -9223372036854775807L;
            } else {
                Object obj;
                ArrayList arrayList2;
                long cM2;
                int readUnsignedByte = lVar.readUnsignedByte();
                z2 = (readUnsignedByte & 128) != 0;
                boolean z5 = (readUnsignedByte & 64) != 0;
                if ((readUnsignedByte & 32) != 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (z5) {
                    j2 = lVar.cM();
                }
                if (z5) {
                    arrayList2 = arrayList;
                } else {
                    int readUnsignedByte2 = lVar.readUnsignedByte();
                    ArrayList arrayList3 = new ArrayList(readUnsignedByte2);
                    for (readUnsignedByte = 0; readUnsignedByte < readUnsignedByte2; readUnsignedByte++) {
                        arrayList3.add(new a(lVar.readUnsignedByte(), lVar.cM(), (byte) 0));
                    }
                }
                if (obj != null) {
                    long readUnsignedByte3 = (long) lVar.readUnsignedByte();
                    cM2 = ((readUnsignedByte3 & 1) << 32) | lVar.cM();
                    z4 = (128 & readUnsignedByte3) != 0;
                } else {
                    cM2 = -9223372036854775807L;
                }
                i = lVar.readUnsignedShort();
                i2 = lVar.readUnsignedByte();
                i3 = lVar.readUnsignedByte();
                j = cM2;
                arrayList = arrayList2;
                z3 = z5;
            }
            b bVar = new b(cM, z, z2, z3, arrayList, j2, z4, j, i, i2, i3);
            AppMethodBeat.o(95376);
            return bVar;
        }
    }

    public static final class a {
        public final int bfS;
        public final long bfW;

        /* synthetic */ a(int i, long j, byte b) {
            this(i, j);
        }

        a(int i, long j) {
            this.bfS = i;
            this.bfW = j;
        }
    }

    /* synthetic */ SpliceScheduleCommand(Parcel parcel, byte b) {
        this(parcel);
    }

    private SpliceScheduleCommand(List<b> list) {
        AppMethodBeat.i(95377);
        this.bfV = Collections.unmodifiableList(list);
        AppMethodBeat.o(95377);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        AppMethodBeat.i(95378);
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(new b(parcel));
        }
        this.bfV = Collections.unmodifiableList(arrayList);
        AppMethodBeat.o(95378);
    }

    static SpliceScheduleCommand y(l lVar) {
        AppMethodBeat.i(95379);
        int readUnsignedByte = lVar.readUnsignedByte();
        List arrayList = new ArrayList(readUnsignedByte);
        for (int i = 0; i < readUnsignedByte; i++) {
            arrayList.add(b.z(lVar));
        }
        SpliceScheduleCommand spliceScheduleCommand = new SpliceScheduleCommand(arrayList);
        AppMethodBeat.o(95379);
        return spliceScheduleCommand;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95380);
        int size = this.bfV.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            int i3;
            b bVar = (b) this.bfV.get(i2);
            parcel.writeLong(bVar.bfF);
            parcel.writeByte((byte) (bVar.bfG ? 1 : 0));
            if (bVar.bfH) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            if (bVar.bfI) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            int size2 = bVar.bfM.size();
            parcel.writeInt(size2);
            for (int i4 = 0; i4 < size2; i4++) {
                a aVar = (a) bVar.bfM.get(i4);
                parcel.writeInt(aVar.bfS);
                parcel.writeLong(aVar.bfW);
            }
            parcel.writeLong(bVar.bfW);
            parcel.writeByte((byte) (bVar.bfN ? 1 : 0));
            parcel.writeLong(bVar.bfO);
            parcel.writeInt(bVar.bfP);
            parcel.writeInt(bVar.bfQ);
            parcel.writeInt(bVar.bfR);
        }
        AppMethodBeat.o(95380);
    }

    static {
        AppMethodBeat.i(95381);
        AppMethodBeat.o(95381);
    }
}
