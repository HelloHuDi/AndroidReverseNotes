package android.support.v4.os;

import android.os.Parcel;

@Deprecated
public interface e<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i);
}
