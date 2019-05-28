package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@VisibleForTesting
public final class SafeParcelableSerializer {
    public static <T extends SafeParcelable> T deserializeFromBytes(byte[] bArr, Creator<T> creator) {
        AppMethodBeat.m2504i(89852);
        Preconditions.checkNotNull(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        AppMethodBeat.m2505o(89852);
        return safeParcelable;
    }

    public static <T extends SafeParcelable> T deserializeFromIntentExtra(Intent intent, String str, Creator<T> creator) {
        AppMethodBeat.m2504i(89858);
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            AppMethodBeat.m2505o(89858);
            return null;
        }
        SafeParcelable deserializeFromBytes = deserializeFromBytes(byteArrayExtra, creator);
        AppMethodBeat.m2505o(89858);
        return deserializeFromBytes;
    }

    public static <T extends SafeParcelable> T deserializeFromString(String str, Creator<T> creator) {
        AppMethodBeat.m2504i(89856);
        SafeParcelable deserializeFromBytes = deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
        AppMethodBeat.m2505o(89856);
        return deserializeFromBytes;
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(Bundle bundle, String str, Creator<T> creator) {
        AppMethodBeat.m2504i(89854);
        ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            AppMethodBeat.m2505o(89854);
            return null;
        }
        ArrayList<T> arrayList2 = new ArrayList(arrayList.size());
        arrayList = arrayList;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(deserializeFromBytes((byte[]) obj, creator));
        }
        AppMethodBeat.m2505o(89854);
        return arrayList2;
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(Intent intent, String str, Creator<T> creator) {
        AppMethodBeat.m2504i(89860);
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            AppMethodBeat.m2505o(89860);
            return null;
        }
        ArrayList<T> arrayList2 = new ArrayList(arrayList.size());
        arrayList = arrayList;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(deserializeFromBytes((byte[]) obj, creator));
        }
        AppMethodBeat.m2505o(89860);
        return arrayList2;
    }

    public static <T extends SafeParcelable> void serializeIterableToBundle(Iterable<T> iterable, Bundle bundle, String str) {
        AppMethodBeat.m2504i(89853);
        ArrayList arrayList = new ArrayList();
        for (T serializeToBytes : iterable) {
            arrayList.add(serializeToBytes(serializeToBytes));
        }
        bundle.putSerializable(str, arrayList);
        AppMethodBeat.m2505o(89853);
    }

    public static <T extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<T> iterable, Intent intent, String str) {
        AppMethodBeat.m2504i(89859);
        ArrayList arrayList = new ArrayList();
        for (T serializeToBytes : iterable) {
            arrayList.add(serializeToBytes(serializeToBytes));
        }
        intent.putExtra(str, arrayList);
        AppMethodBeat.m2505o(89859);
    }

    public static <T extends SafeParcelable> byte[] serializeToBytes(T t) {
        AppMethodBeat.m2504i(89851);
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        AppMethodBeat.m2505o(89851);
        return marshall;
    }

    public static <T extends SafeParcelable> void serializeToIntentExtra(T t, Intent intent, String str) {
        AppMethodBeat.m2504i(89857);
        intent.putExtra(str, serializeToBytes(t));
        AppMethodBeat.m2505o(89857);
    }

    public static <T extends SafeParcelable> String serializeToString(T t) {
        AppMethodBeat.m2504i(89855);
        String encodeUrlSafe = Base64Utils.encodeUrlSafe(serializeToBytes(t));
        AppMethodBeat.m2505o(89855);
        return encodeUrlSafe;
    }
}
