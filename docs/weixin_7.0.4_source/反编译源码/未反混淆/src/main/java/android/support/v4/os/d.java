package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

@Deprecated
public final class d {

    static class a<T> implements ClassLoaderCreator<T> {
        private final e<T> JY;

        a(e<T> eVar) {
            this.JY = eVar;
        }

        public final T createFromParcel(Parcel parcel) {
            return this.JY.createFromParcel(parcel, null);
        }

        public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.JY.createFromParcel(parcel, classLoader);
        }

        public final T[] newArray(int i) {
            return this.JY.newArray(i);
        }
    }

    @Deprecated
    public static <T> Creator<T> a(e<T> eVar) {
        return new a(eVar);
    }
}
