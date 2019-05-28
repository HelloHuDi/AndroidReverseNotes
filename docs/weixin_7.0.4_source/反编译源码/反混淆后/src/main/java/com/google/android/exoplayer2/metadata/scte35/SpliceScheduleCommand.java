package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Creator<SpliceScheduleCommand> CREATOR = new C87011();
    public final List<C25548b> bfV;

    /* renamed from: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand$1 */
    static class C87011 implements Creator<SpliceScheduleCommand> {
        C87011() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95373);
            SpliceScheduleCommand spliceScheduleCommand = new SpliceScheduleCommand(parcel, (byte) 0);
            AppMethodBeat.m2505o(95373);
            return spliceScheduleCommand;
        }
    }

    /* renamed from: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand$b */
    public static final class C25548b {
        public final long bfF;
        public final boolean bfG;
        public final boolean bfH;
        public final boolean bfI;
        public final List<C25549a> bfM;
        public final boolean bfN;
        public final long bfO;
        public final int bfP;
        public final int bfQ;
        public final int bfR;
        public final long bfW;

        private C25548b(long j, boolean z, boolean z2, boolean z3, List<C25549a> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            AppMethodBeat.m2504i(95374);
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
            AppMethodBeat.m2505o(95374);
        }

        C25548b(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(95375);
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
                arrayList.add(new C25549a(parcel.readInt(), parcel.readLong()));
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
            AppMethodBeat.m2505o(95375);
        }

        /* renamed from: z */
        static C25548b m40385z(C32065l c32065l) {
            long j;
            AppMethodBeat.m2504i(95376);
            long cM = c32065l.mo52366cM();
            boolean z = (c32065l.readUnsignedByte() & 128) != 0;
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
                int readUnsignedByte = c32065l.readUnsignedByte();
                z2 = (readUnsignedByte & 128) != 0;
                boolean z5 = (readUnsignedByte & 64) != 0;
                if ((readUnsignedByte & 32) != 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (z5) {
                    j2 = c32065l.mo52366cM();
                }
                if (z5) {
                    arrayList2 = arrayList;
                } else {
                    int readUnsignedByte2 = c32065l.readUnsignedByte();
                    ArrayList arrayList3 = new ArrayList(readUnsignedByte2);
                    for (readUnsignedByte = 0; readUnsignedByte < readUnsignedByte2; readUnsignedByte++) {
                        arrayList3.add(new C25549a(c32065l.readUnsignedByte(), c32065l.mo52366cM(), (byte) 0));
                    }
                }
                if (obj != null) {
                    long readUnsignedByte3 = (long) c32065l.readUnsignedByte();
                    cM2 = ((readUnsignedByte3 & 1) << 32) | c32065l.mo52366cM();
                    z4 = (128 & readUnsignedByte3) != 0;
                } else {
                    cM2 = -9223372036854775807L;
                }
                i = c32065l.readUnsignedShort();
                i2 = c32065l.readUnsignedByte();
                i3 = c32065l.readUnsignedByte();
                j = cM2;
                arrayList = arrayList2;
                z3 = z5;
            }
            C25548b c25548b = new C25548b(cM, z, z2, z3, arrayList, j2, z4, j, i, i2, i3);
            AppMethodBeat.m2505o(95376);
            return c25548b;
        }
    }

    /* renamed from: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand$a */
    public static final class C25549a {
        public final int bfS;
        public final long bfW;

        /* synthetic */ C25549a(int i, long j, byte b) {
            this(i, j);
        }

        C25549a(int i, long j) {
            this.bfS = i;
            this.bfW = j;
        }
    }

    /* synthetic */ SpliceScheduleCommand(Parcel parcel, byte b) {
        this(parcel);
    }

    private SpliceScheduleCommand(List<C25548b> list) {
        AppMethodBeat.m2504i(95377);
        this.bfV = Collections.unmodifiableList(list);
        AppMethodBeat.m2505o(95377);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        AppMethodBeat.m2504i(95378);
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(new C25548b(parcel));
        }
        this.bfV = Collections.unmodifiableList(arrayList);
        AppMethodBeat.m2505o(95378);
    }

    /* renamed from: y */
    static SpliceScheduleCommand m40384y(C32065l c32065l) {
        AppMethodBeat.m2504i(95379);
        int readUnsignedByte = c32065l.readUnsignedByte();
        List arrayList = new ArrayList(readUnsignedByte);
        for (int i = 0; i < readUnsignedByte; i++) {
            arrayList.add(C25548b.m40385z(c32065l));
        }
        SpliceScheduleCommand spliceScheduleCommand = new SpliceScheduleCommand(arrayList);
        AppMethodBeat.m2505o(95379);
        return spliceScheduleCommand;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95380);
        int size = this.bfV.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            int i3;
            C25548b c25548b = (C25548b) this.bfV.get(i2);
            parcel.writeLong(c25548b.bfF);
            parcel.writeByte((byte) (c25548b.bfG ? 1 : 0));
            if (c25548b.bfH) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            if (c25548b.bfI) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            int size2 = c25548b.bfM.size();
            parcel.writeInt(size2);
            for (int i4 = 0; i4 < size2; i4++) {
                C25549a c25549a = (C25549a) c25548b.bfM.get(i4);
                parcel.writeInt(c25549a.bfS);
                parcel.writeLong(c25549a.bfW);
            }
            parcel.writeLong(c25548b.bfW);
            parcel.writeByte((byte) (c25548b.bfN ? 1 : 0));
            parcel.writeLong(c25548b.bfO);
            parcel.writeInt(c25548b.bfP);
            parcel.writeInt(c25548b.bfQ);
            parcel.writeInt(c25548b.bfR);
        }
        AppMethodBeat.m2505o(95380);
    }

    static {
        AppMethodBeat.m2504i(95381);
        AppMethodBeat.m2505o(95381);
    }
}
