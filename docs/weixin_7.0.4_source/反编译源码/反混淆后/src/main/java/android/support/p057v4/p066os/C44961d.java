package android.support.p057v4.p066os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

@Deprecated
/* renamed from: android.support.v4.os.d */
public final class C44961d {

    /* renamed from: android.support.v4.os.d$a */
    static class C37127a<T> implements ClassLoaderCreator<T> {
        /* renamed from: JY */
        private final C17451e<T> f15779JY;

        C37127a(C17451e<T> c17451e) {
            this.f15779JY = c17451e;
        }

        public final T createFromParcel(Parcel parcel) {
            return this.f15779JY.createFromParcel(parcel, null);
        }

        public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f15779JY.createFromParcel(parcel, classLoader);
        }

        public final T[] newArray(int i) {
            return this.f15779JY.newArray(i);
        }
    }

    @Deprecated
    /* renamed from: a */
    public static <T> Creator<T> m82262a(C17451e<T> c17451e) {
        return new C37127a(c17451e);
    }
}
