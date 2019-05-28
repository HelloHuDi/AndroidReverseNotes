package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Creator<DrmInitData> CREATOR = new Creator<DrmInitData>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrmInitData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(94754);
            DrmInitData drmInitData = new DrmInitData(parcel);
            AppMethodBeat.o(94754);
            return drmInitData;
        }
    };
    private int aBR;
    public final SchemeData[] aSw;
    public final int aSx;

    public static final class SchemeData implements Parcelable {
        public static final Creator<SchemeData> CREATOR = new Creator<SchemeData>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SchemeData[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(94755);
                SchemeData schemeData = new SchemeData(parcel);
                AppMethodBeat.o(94755);
                return schemeData;
            }
        };
        private int aBR;
        public final boolean aSy;
        public final byte[] data;
        public final String mimeType;
        public final String type;
        final UUID uuid;

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr, false);
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr, boolean z) {
            AppMethodBeat.i(94756);
            this.uuid = (UUID) a.checkNotNull(uuid);
            this.type = str;
            this.mimeType = (String) a.checkNotNull(str2);
            this.data = (byte[]) a.checkNotNull(bArr);
            this.aSy = z;
            AppMethodBeat.o(94756);
        }

        SchemeData(Parcel parcel) {
            AppMethodBeat.i(94757);
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.type = parcel.readString();
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.aSy = parcel.readByte() != (byte) 0;
            AppMethodBeat.o(94757);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(94758);
            if (!(obj instanceof SchemeData)) {
                AppMethodBeat.o(94758);
                return false;
            } else if (obj == this) {
                AppMethodBeat.o(94758);
                return true;
            } else {
                SchemeData schemeData = (SchemeData) obj;
                if (this.mimeType.equals(schemeData.mimeType) && v.j(this.uuid, schemeData.uuid) && v.j(this.type, schemeData.type) && Arrays.equals(this.data, schemeData.data)) {
                    AppMethodBeat.o(94758);
                    return true;
                }
                AppMethodBeat.o(94758);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(94759);
            if (this.aBR == 0) {
                this.aBR = (((((this.type == null ? 0 : this.type.hashCode()) + (this.uuid.hashCode() * 31)) * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            int i = this.aBR;
            AppMethodBeat.o(94759);
            return i;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(94760);
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.type);
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte((byte) (this.aSy ? 1 : 0));
            AppMethodBeat.o(94760);
        }

        static {
            AppMethodBeat.i(94761);
            AppMethodBeat.o(94761);
        }
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.i(94769);
        SchemeData schemeData = (SchemeData) obj;
        SchemeData schemeData2 = (SchemeData) obj2;
        if (!b.aMx.equals(schemeData.uuid)) {
            int compareTo = schemeData.uuid.compareTo(schemeData2.uuid);
            AppMethodBeat.o(94769);
            return compareTo;
        } else if (b.aMx.equals(schemeData2.uuid)) {
            AppMethodBeat.o(94769);
            return 0;
        } else {
            AppMethodBeat.o(94769);
            return 1;
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this(false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
        AppMethodBeat.i(94762);
        AppMethodBeat.o(94762);
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(true, schemeDataArr);
    }

    private DrmInitData(boolean z, SchemeData... schemeDataArr) {
        Object[] objArr;
        AppMethodBeat.i(94763);
        if (z) {
            objArr = (SchemeData[]) schemeDataArr.clone();
        } else {
            SchemeData[] objArr2 = schemeDataArr;
        }
        Arrays.sort(objArr2, this);
        for (int i = 1; i < objArr2.length; i++) {
            if (objArr2[i - 1].uuid.equals(objArr2[i].uuid)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Duplicate data for uuid: " + objArr2[i].uuid);
                AppMethodBeat.o(94763);
                throw illegalArgumentException;
            }
        }
        this.aSw = objArr2;
        this.aSx = objArr2.length;
        AppMethodBeat.o(94763);
    }

    DrmInitData(Parcel parcel) {
        AppMethodBeat.i(94764);
        this.aSw = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.aSx = this.aSw.length;
        AppMethodBeat.o(94764);
    }

    public final DrmInitData aw(String str) {
        int i;
        int i2 = 0;
        AppMethodBeat.i(94765);
        for (SchemeData schemeData : this.aSw) {
            if (!v.j(schemeData.type, str)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i != 0) {
            SchemeData[] schemeDataArr = new SchemeData[this.aSw.length];
            while (true) {
                int i3 = i2;
                if (i3 < schemeDataArr.length) {
                    SchemeData schemeData2;
                    SchemeData schemeData3 = this.aSw[i3];
                    if (v.j(schemeData3.type, str)) {
                        schemeData2 = schemeData3;
                    } else {
                        schemeData2 = new SchemeData(schemeData3.uuid, str, schemeData3.mimeType, schemeData3.data, schemeData3.aSy);
                    }
                    schemeDataArr[i3] = schemeData2;
                    i2 = i3 + 1;
                } else {
                    this = new DrmInitData(schemeDataArr);
                    AppMethodBeat.o(94765);
                    return this;
                }
            }
        }
        AppMethodBeat.o(94765);
        return this;
    }

    public final int hashCode() {
        AppMethodBeat.i(94766);
        if (this.aBR == 0) {
            this.aBR = Arrays.hashCode(this.aSw);
        }
        int i = this.aBR;
        AppMethodBeat.o(94766);
        return i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(94767);
        if (this == obj) {
            AppMethodBeat.o(94767);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(94767);
            return false;
        } else {
            boolean equals = Arrays.equals(this.aSw, ((DrmInitData) obj).aSw);
            AppMethodBeat.o(94767);
            return equals;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(94768);
        parcel.writeTypedArray(this.aSw, 0);
        AppMethodBeat.o(94768);
    }

    static {
        AppMethodBeat.i(94770);
        AppMethodBeat.o(94770);
    }
}
