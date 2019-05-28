package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.C17628b;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Creator<DrmInitData> CREATOR = new C176491();
    private int aBR;
    public final SchemeData[] aSw;
    public final int aSx;

    public static final class SchemeData implements Parcelable {
        public static final Creator<SchemeData> CREATOR = new C176481();
        private int aBR;
        public final boolean aSy;
        public final byte[] data;
        public final String mimeType;
        public final String type;
        final UUID uuid;

        /* renamed from: com.google.android.exoplayer2.drm.DrmInitData$SchemeData$1 */
        static class C176481 implements Creator<SchemeData> {
            C176481() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SchemeData[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(94755);
                SchemeData schemeData = new SchemeData(parcel);
                AppMethodBeat.m2505o(94755);
                return schemeData;
            }
        }

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr, false);
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr, boolean z) {
            AppMethodBeat.m2504i(94756);
            this.uuid = (UUID) C45039a.checkNotNull(uuid);
            this.type = str;
            this.mimeType = (String) C45039a.checkNotNull(str2);
            this.data = (byte[]) C45039a.checkNotNull(bArr);
            this.aSy = z;
            AppMethodBeat.m2505o(94756);
        }

        SchemeData(Parcel parcel) {
            AppMethodBeat.m2504i(94757);
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.type = parcel.readString();
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.aSy = parcel.readByte() != (byte) 0;
            AppMethodBeat.m2505o(94757);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(94758);
            if (!(obj instanceof SchemeData)) {
                AppMethodBeat.m2505o(94758);
                return false;
            } else if (obj == this) {
                AppMethodBeat.m2505o(94758);
                return true;
            } else {
                SchemeData schemeData = (SchemeData) obj;
                if (this.mimeType.equals(schemeData.mimeType) && C17675v.m27574j(this.uuid, schemeData.uuid) && C17675v.m27574j(this.type, schemeData.type) && Arrays.equals(this.data, schemeData.data)) {
                    AppMethodBeat.m2505o(94758);
                    return true;
                }
                AppMethodBeat.m2505o(94758);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(94759);
            if (this.aBR == 0) {
                this.aBR = (((((this.type == null ? 0 : this.type.hashCode()) + (this.uuid.hashCode() * 31)) * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            int i = this.aBR;
            AppMethodBeat.m2505o(94759);
            return i;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(94760);
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.type);
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte((byte) (this.aSy ? 1 : 0));
            AppMethodBeat.m2505o(94760);
        }

        static {
            AppMethodBeat.m2504i(94761);
            AppMethodBeat.m2505o(94761);
        }
    }

    /* renamed from: com.google.android.exoplayer2.drm.DrmInitData$1 */
    static class C176491 implements Creator<DrmInitData> {
        C176491() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrmInitData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(94754);
            DrmInitData drmInitData = new DrmInitData(parcel);
            AppMethodBeat.m2505o(94754);
            return drmInitData;
        }
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.m2504i(94769);
        SchemeData schemeData = (SchemeData) obj;
        SchemeData schemeData2 = (SchemeData) obj2;
        if (!C17628b.aMx.equals(schemeData.uuid)) {
            int compareTo = schemeData.uuid.compareTo(schemeData2.uuid);
            AppMethodBeat.m2505o(94769);
            return compareTo;
        } else if (C17628b.aMx.equals(schemeData2.uuid)) {
            AppMethodBeat.m2505o(94769);
            return 0;
        } else {
            AppMethodBeat.m2505o(94769);
            return 1;
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this(false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
        AppMethodBeat.m2504i(94762);
        AppMethodBeat.m2505o(94762);
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(true, schemeDataArr);
    }

    private DrmInitData(boolean z, SchemeData... schemeDataArr) {
        Object[] objArr;
        AppMethodBeat.m2504i(94763);
        if (z) {
            objArr = (SchemeData[]) schemeDataArr.clone();
        } else {
            SchemeData[] objArr2 = schemeDataArr;
        }
        Arrays.sort(objArr2, this);
        for (int i = 1; i < objArr2.length; i++) {
            if (objArr2[i - 1].uuid.equals(objArr2[i].uuid)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Duplicate data for uuid: " + objArr2[i].uuid);
                AppMethodBeat.m2505o(94763);
                throw illegalArgumentException;
            }
        }
        this.aSw = objArr2;
        this.aSx = objArr2.length;
        AppMethodBeat.m2505o(94763);
    }

    DrmInitData(Parcel parcel) {
        AppMethodBeat.m2504i(94764);
        this.aSw = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.aSx = this.aSw.length;
        AppMethodBeat.m2505o(94764);
    }

    /* renamed from: aw */
    public final DrmInitData mo32330aw(String str) {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(94765);
        for (SchemeData schemeData : this.aSw) {
            if (!C17675v.m27574j(schemeData.type, str)) {
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
                    if (C17675v.m27574j(schemeData3.type, str)) {
                        schemeData2 = schemeData3;
                    } else {
                        schemeData2 = new SchemeData(schemeData3.uuid, str, schemeData3.mimeType, schemeData3.data, schemeData3.aSy);
                    }
                    schemeDataArr[i3] = schemeData2;
                    i2 = i3 + 1;
                } else {
                    this = new DrmInitData(schemeDataArr);
                    AppMethodBeat.m2505o(94765);
                    return this;
                }
            }
        }
        AppMethodBeat.m2505o(94765);
        return this;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(94766);
        if (this.aBR == 0) {
            this.aBR = Arrays.hashCode(this.aSw);
        }
        int i = this.aBR;
        AppMethodBeat.m2505o(94766);
        return i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(94767);
        if (this == obj) {
            AppMethodBeat.m2505o(94767);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(94767);
            return false;
        } else {
            boolean equals = Arrays.equals(this.aSw, ((DrmInitData) obj).aSw);
            AppMethodBeat.m2505o(94767);
            return equals;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(94768);
        parcel.writeTypedArray(this.aSw, 0);
        AppMethodBeat.m2505o(94768);
    }

    static {
        AppMethodBeat.m2504i(94770);
        AppMethodBeat.m2505o(94770);
    }
}
