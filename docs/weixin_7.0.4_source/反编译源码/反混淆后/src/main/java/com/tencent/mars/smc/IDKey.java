package com.tencent.mars.smc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IDKey implements Parcelable {
    public static final Creator<IDKey> CREATOR = new C10211();
    /* renamed from: id */
    private long f1212id;
    private long key;
    private long value;

    /* renamed from: com.tencent.mars.smc.IDKey$1 */
    static class C10211 implements Creator<IDKey> {
        C10211() {
        }

        public final IDKey createFromParcel(Parcel parcel) {
            return new IDKey(parcel);
        }

        public final IDKey[] newArray(int i) {
            return new IDKey[i];
        }
    }

    public IDKey(int i, int i2, int i3) {
        this.f1212id = (long) i;
        this.key = (long) i2;
        this.value = (long) i3;
    }

    public IDKey(long j, long j2, long j3) {
        this.f1212id = j;
        this.key = j2;
        this.value = j3;
    }

    public IDKey() {
        this.f1212id = 0;
        this.key = 0;
        this.value = 0;
    }

    protected IDKey(Parcel parcel) {
        this.f1212id = parcel.readLong();
        this.key = parcel.readLong();
        this.value = parcel.readLong();
    }

    public long GetID() {
        return this.f1212id;
    }

    public void SetID(int i) {
        this.f1212id = (long) i;
    }

    public long GetKey() {
        return this.key;
    }

    public void SetKey(int i) {
        this.key = (long) i;
    }

    public long GetValue() {
        return this.value;
    }

    public void SetValue(long j) {
        this.value = j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f1212id);
        parcel.writeLong(this.key);
        parcel.writeLong(this.value);
    }
}
