package com.google.android.gms.common.internal;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.util.ThreadUtils;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Preconditions {
    private Preconditions() {
        AppMethodBeat.m2504i(89706);
        AssertionError assertionError = new AssertionError("Uninstantiable");
        AppMethodBeat.m2505o(89706);
        throw assertionError;
    }

    public static void checkArgument(boolean z) {
        AppMethodBeat.m2504i(89705);
        if (z) {
            AppMethodBeat.m2505o(89705);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        AppMethodBeat.m2505o(89705);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean z, Object obj) {
        AppMethodBeat.m2504i(89703);
        if (z) {
            AppMethodBeat.m2505o(89703);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj));
        AppMethodBeat.m2505o(89703);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        AppMethodBeat.m2504i(89704);
        if (z) {
            AppMethodBeat.m2505o(89704);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(str, objArr));
        AppMethodBeat.m2505o(89704);
        throw illegalArgumentException;
    }

    public static int checkElementIndex(int i, int i2) {
        AppMethodBeat.m2504i(89711);
        int checkElementIndex = checkElementIndex(i, i2, C8741b.INDEX);
        AppMethodBeat.m2505o(89711);
        return checkElementIndex;
    }

    public static int checkElementIndex(int i, int i2, String str) {
        AppMethodBeat.m2504i(89712);
        if (i < 0 || i >= i2) {
            String format;
            if (i < 0) {
                format = format("%s (%s) must not be negative", str, Integer.valueOf(i));
            } else if (i2 < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("negative size: " + i2);
                AppMethodBeat.m2505o(89712);
                throw illegalArgumentException;
            } else {
                format = format("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
            }
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(format);
            AppMethodBeat.m2505o(89712);
            throw indexOutOfBoundsException;
        }
        AppMethodBeat.m2505o(89712);
        return i;
    }

    public static void checkHandlerThread(Handler handler) {
        AppMethodBeat.m2504i(89710);
        if (Looper.myLooper() != handler.getLooper()) {
            IllegalStateException illegalStateException = new IllegalStateException("Must be called on the handler thread");
            AppMethodBeat.m2505o(89710);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(89710);
    }

    public static void checkMainThread(String str) {
        AppMethodBeat.m2504i(89707);
        if (ThreadUtils.isMainThread()) {
            AppMethodBeat.m2505o(89707);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str);
        AppMethodBeat.m2505o(89707);
        throw illegalStateException;
    }

    public static String checkNotEmpty(String str) {
        AppMethodBeat.m2504i(89692);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Given String is empty or null");
            AppMethodBeat.m2505o(89692);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(89692);
        return str;
    }

    public static String checkNotEmpty(String str, Object obj) {
        AppMethodBeat.m2504i(89693);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj));
            AppMethodBeat.m2505o(89693);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(89693);
        return str;
    }

    public static void checkNotMainThread() {
        AppMethodBeat.m2504i(89708);
        checkNotMainThread("Must not be called on the main application thread");
        AppMethodBeat.m2505o(89708);
    }

    public static void checkNotMainThread(String str) {
        AppMethodBeat.m2504i(89709);
        if (ThreadUtils.isMainThread()) {
            IllegalStateException illegalStateException = new IllegalStateException(str);
            AppMethodBeat.m2505o(89709);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(89709);
    }

    public static <T> T checkNotNull(T t) {
        AppMethodBeat.m2504i(89691);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("null reference");
            AppMethodBeat.m2505o(89691);
            throw nullPointerException;
        }
        AppMethodBeat.m2505o(89691);
        return t;
    }

    public static <T> T checkNotNull(T t, Object obj) {
        AppMethodBeat.m2504i(89694);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException(String.valueOf(obj));
            AppMethodBeat.m2505o(89694);
            throw nullPointerException;
        }
        AppMethodBeat.m2505o(89694);
        return t;
    }

    public static void checkNotNullIfPresent(String str, ContentValues contentValues) {
        AppMethodBeat.m2504i(89699);
        if (contentValues.containsKey(str) && contentValues.get(str) == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(str).concat(" cannot be set to null"));
            AppMethodBeat.m2505o(89699);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(89699);
    }

    public static int checkNotZero(int i) {
        AppMethodBeat.m2504i(89696);
        if (i == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Given Integer is zero");
            AppMethodBeat.m2505o(89696);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(89696);
        return i;
    }

    public static int checkNotZero(int i, Object obj) {
        AppMethodBeat.m2504i(89695);
        if (i == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj));
            AppMethodBeat.m2505o(89695);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(89695);
        return i;
    }

    public static long checkNotZero(long j) {
        AppMethodBeat.m2504i(89698);
        if (j == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Given Long is zero");
            AppMethodBeat.m2505o(89698);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(89698);
        return j;
    }

    public static long checkNotZero(long j, Object obj) {
        AppMethodBeat.m2504i(89697);
        if (j == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj));
            AppMethodBeat.m2505o(89697);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(89697);
        return j;
    }

    public static int checkPositionIndex(int i, int i2) {
        AppMethodBeat.m2504i(89713);
        int checkPositionIndex = checkPositionIndex(i, i2, C8741b.INDEX);
        AppMethodBeat.m2505o(89713);
        return checkPositionIndex;
    }

    public static int checkPositionIndex(int i, int i2, String str) {
        AppMethodBeat.m2504i(89714);
        if (i < 0 || i > i2) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(zza(i, i2, str));
            AppMethodBeat.m2505o(89714);
            throw indexOutOfBoundsException;
        }
        AppMethodBeat.m2505o(89714);
        return i;
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        AppMethodBeat.m2504i(89716);
        if (i < 0 || i2 < i || i2 > i3) {
            String zza;
            if (i < 0 || i > i3) {
                zza = zza(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                zza = zza(i2, i3, "end index");
            } else {
                zza = format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(zza);
            AppMethodBeat.m2505o(89716);
            throw indexOutOfBoundsException;
        }
        AppMethodBeat.m2505o(89716);
    }

    public static void checkState(boolean z) {
        AppMethodBeat.m2504i(89700);
        if (z) {
            AppMethodBeat.m2505o(89700);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        AppMethodBeat.m2505o(89700);
        throw illegalStateException;
    }

    public static void checkState(boolean z, Object obj) {
        AppMethodBeat.m2504i(89701);
        if (z) {
            AppMethodBeat.m2505o(89701);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(obj));
        AppMethodBeat.m2505o(89701);
        throw illegalStateException;
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        AppMethodBeat.m2504i(89702);
        if (z) {
            AppMethodBeat.m2505o(89702);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(String.format(str, objArr));
        AppMethodBeat.m2505o(89702);
        throw illegalStateException;
    }

    public static String checkTag(String str) {
        AppMethodBeat.m2504i(89717);
        IllegalArgumentException illegalArgumentException;
        if (TextUtils.isEmpty(str)) {
            illegalArgumentException = new IllegalArgumentException("Tag must not be empty or null");
            AppMethodBeat.m2505o(89717);
            throw illegalArgumentException;
        } else if (str.length() > 23) {
            illegalArgumentException = new IllegalArgumentException("Tag must not be greater than 23 chars.");
            AppMethodBeat.m2505o(89717);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.m2505o(89717);
            return str;
        }
    }

    private static String format(String str, Object... objArr) {
        int i;
        AppMethodBeat.m2504i(89718);
        StringBuilder stringBuilder = new StringBuilder(str.length() + (objArr.length * 16));
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length) {
            int indexOf = str.indexOf("%s", i3);
            if (indexOf == -1) {
                break;
            }
            stringBuilder.append(str.substring(i3, indexOf));
            i = i2 + 1;
            stringBuilder.append(objArr[i2]);
            i3 = indexOf + 2;
            i2 = i;
        }
        stringBuilder.append(str.substring(i3));
        if (i2 < objArr.length) {
            stringBuilder.append(" [");
            i = i2 + 1;
            stringBuilder.append(objArr[i2]);
            while (true) {
                i2 = i;
                if (i2 >= objArr.length) {
                    break;
                }
                stringBuilder.append(", ");
                i = i2 + 1;
                stringBuilder.append(objArr[i2]);
            }
            stringBuilder.append("]");
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(89718);
        return stringBuilder2;
    }

    private static String zza(int i, int i2, String str) {
        AppMethodBeat.m2504i(89715);
        String format;
        if (i < 0) {
            format = format("%s (%s) must not be negative", str, Integer.valueOf(i));
            AppMethodBeat.m2505o(89715);
            return format;
        } else if (i2 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("negative size: " + i2);
            AppMethodBeat.m2505o(89715);
            throw illegalArgumentException;
        } else {
            format = format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(89715);
            return format;
        }
    }
}
