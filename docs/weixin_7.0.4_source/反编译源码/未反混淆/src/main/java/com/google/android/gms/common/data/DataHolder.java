package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.sqlite.CursorWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@KeepName
@Class(creator = "DataHolderCreator", validate = true)
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Creator<DataHolder> CREATOR = new DataHolderCreator();
    private static final Builder zznt = new zza(new String[0], null);
    private boolean mClosed;
    @VersionField(id = 1000)
    private final int zzal;
    @Field(getter = "getStatusCode", id = 3)
    private final int zzam;
    @Field(getter = "getColumns", id = 1)
    private final String[] zznm;
    private Bundle zznn;
    @Field(getter = "getWindows", id = 2)
    private final CursorWindow[] zzno;
    @Field(getter = "getMetadata", id = 4)
    private final Bundle zznp;
    private int[] zznq;
    private int zznr;
    private boolean zzns;

    public static class Builder {
        private final String[] zznm;
        private final ArrayList<HashMap<String, Object>> zznu;
        private final String zznv;
        private final HashMap<Object, Integer> zznw;
        private boolean zznx;
        private String zzny;

        private Builder(String[] strArr, String str) {
            AppMethodBeat.i(61073);
            this.zznm = (String[]) Preconditions.checkNotNull(strArr);
            this.zznu = new ArrayList();
            this.zznv = str;
            this.zznw = new HashMap();
            this.zznx = false;
            this.zzny = null;
            AppMethodBeat.o(61073);
        }

        /* synthetic */ Builder(String[] strArr, String str, zza zza) {
            this(strArr, str);
        }

        private final boolean zzg(String str) {
            AppMethodBeat.i(61081);
            Asserts.checkNotNull(str);
            if (this.zznx && str.equals(this.zzny)) {
                AppMethodBeat.o(61081);
                return true;
            }
            AppMethodBeat.o(61081);
            return false;
        }

        public DataHolder build(int i) {
            AppMethodBeat.i(61083);
            DataHolder dataHolder = new DataHolder(this, i, null, null);
            AppMethodBeat.o(61083);
            return dataHolder;
        }

        public DataHolder build(int i, Bundle bundle) {
            AppMethodBeat.i(61084);
            DataHolder dataHolder = new DataHolder(this, i, bundle, -1, null);
            AppMethodBeat.o(61084);
            return dataHolder;
        }

        public DataHolder build(int i, Bundle bundle, int i2) {
            AppMethodBeat.i(61085);
            DataHolder dataHolder = new DataHolder(this, i, bundle, i2, null);
            AppMethodBeat.o(61085);
            return dataHolder;
        }

        public boolean containsRowWithValue(String str, Object obj) {
            AppMethodBeat.i(61077);
            int size = this.zznu.size();
            for (int i = 0; i < size; i++) {
                if (Objects.equal(((HashMap) this.zznu.get(i)).get(str), obj)) {
                    AppMethodBeat.o(61077);
                    return true;
                }
            }
            AppMethodBeat.o(61077);
            return false;
        }

        public Builder descendingSort(String str) {
            AppMethodBeat.i(61080);
            if (zzg(str)) {
                AppMethodBeat.o(61080);
            } else {
                sort(str);
                Collections.reverse(this.zznu);
                AppMethodBeat.o(61080);
            }
            return this;
        }

        public int getCount() {
            AppMethodBeat.i(61082);
            int size = this.zznu.size();
            AppMethodBeat.o(61082);
            return size;
        }

        public void modifyUniqueRowValue(Object obj, String str, Object obj2) {
            AppMethodBeat.i(61075);
            if (this.zznv == null) {
                AppMethodBeat.o(61075);
                return;
            }
            Integer num = (Integer) this.zznw.get(obj);
            if (num == null) {
                AppMethodBeat.o(61075);
                return;
            }
            ((HashMap) this.zznu.get(num.intValue())).put(str, obj2);
            AppMethodBeat.o(61075);
        }

        public Builder removeRowsWithValue(String str, Object obj) {
            AppMethodBeat.i(61078);
            for (int size = this.zznu.size() - 1; size >= 0; size--) {
                if (Objects.equal(((HashMap) this.zznu.get(size)).get(str), obj)) {
                    this.zznu.remove(size);
                }
            }
            AppMethodBeat.o(61078);
            return this;
        }

        public Builder sort(String str) {
            AppMethodBeat.i(61079);
            if (zzg(str)) {
                AppMethodBeat.o(61079);
            } else {
                Collections.sort(this.zznu, new zza(str));
                if (this.zznv != null) {
                    this.zznw.clear();
                    int size = this.zznu.size();
                    for (int i = 0; i < size; i++) {
                        Object obj = ((HashMap) this.zznu.get(i)).get(this.zznv);
                        if (obj != null) {
                            this.zznw.put(obj, Integer.valueOf(i));
                        }
                    }
                }
                this.zznx = true;
                this.zzny = str;
                AppMethodBeat.o(61079);
            }
            return this;
        }

        public Builder withRow(ContentValues contentValues) {
            AppMethodBeat.i(61076);
            Asserts.checkNotNull(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Entry entry : contentValues.valueSet()) {
                hashMap.put((String) entry.getKey(), entry.getValue());
            }
            Builder withRow = withRow(hashMap);
            AppMethodBeat.o(61076);
            return withRow;
        }

        public Builder withRow(HashMap<String, Object> hashMap) {
            int i;
            AppMethodBeat.i(61074);
            Asserts.checkNotNull(hashMap);
            if (this.zznv == null) {
                i = -1;
            } else {
                Object obj = hashMap.get(this.zznv);
                if (obj == null) {
                    i = -1;
                } else {
                    Integer num = (Integer) this.zznw.get(obj);
                    if (num == null) {
                        this.zznw.put(obj, Integer.valueOf(this.zznu.size()));
                        i = -1;
                    } else {
                        i = num.intValue();
                    }
                }
            }
            if (i == -1) {
                this.zznu.add(hashMap);
            } else {
                this.zznu.remove(i);
                this.zznu.add(i, hashMap);
            }
            this.zznx = false;
            AppMethodBeat.o(61074);
            return this;
        }
    }

    static final class zza implements Comparator<HashMap<String, Object>> {
        private final String zznz;

        zza(String str) {
            AppMethodBeat.i(61086);
            this.zznz = (String) Preconditions.checkNotNull(str);
            AppMethodBeat.o(61086);
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.i(61087);
            HashMap hashMap = (HashMap) obj2;
            Object checkNotNull = Preconditions.checkNotNull(((HashMap) obj).get(this.zznz));
            Object checkNotNull2 = Preconditions.checkNotNull(hashMap.get(this.zznz));
            int compareTo;
            if (checkNotNull.equals(checkNotNull2)) {
                AppMethodBeat.o(61087);
                return 0;
            } else if (checkNotNull instanceof Boolean) {
                compareTo = ((Boolean) checkNotNull).compareTo((Boolean) checkNotNull2);
                AppMethodBeat.o(61087);
                return compareTo;
            } else if (checkNotNull instanceof Long) {
                compareTo = ((Long) checkNotNull).compareTo((Long) checkNotNull2);
                AppMethodBeat.o(61087);
                return compareTo;
            } else if (checkNotNull instanceof Integer) {
                compareTo = ((Integer) checkNotNull).compareTo((Integer) checkNotNull2);
                AppMethodBeat.o(61087);
                return compareTo;
            } else if (checkNotNull instanceof String) {
                compareTo = ((String) checkNotNull).compareTo((String) checkNotNull2);
                AppMethodBeat.o(61087);
                return compareTo;
            } else if (checkNotNull instanceof Double) {
                compareTo = ((Double) checkNotNull).compareTo((Double) checkNotNull2);
                AppMethodBeat.o(61087);
                return compareTo;
            } else if (checkNotNull instanceof Float) {
                compareTo = ((Float) checkNotNull).compareTo((Float) checkNotNull2);
                AppMethodBeat.o(61087);
                return compareTo;
            } else {
                String valueOf = String.valueOf(checkNotNull);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Unknown type for lValue ").append(valueOf).toString());
                AppMethodBeat.o(61087);
                throw illegalArgumentException;
            }
        }
    }

    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String str) {
            super(str);
        }
    }

    static {
        AppMethodBeat.i(61122);
        AppMethodBeat.o(61122);
    }

    @Constructor
    DataHolder(@Param(id = 1000) int i, @Param(id = 1) String[] strArr, @Param(id = 2) CursorWindow[] cursorWindowArr, @Param(id = 3) int i2, @Param(id = 4) Bundle bundle) {
        this.mClosed = false;
        this.zzns = true;
        this.zzal = i;
        this.zznm = strArr;
        this.zzno = cursorWindowArr;
        this.zzam = i2;
        this.zznp = bundle;
    }

    public DataHolder(Cursor cursor, int i, Bundle bundle) {
        this(new CursorWrapper(cursor), i, bundle);
        AppMethodBeat.i(61090);
        AppMethodBeat.o(61090);
    }

    private DataHolder(Builder builder, int i, Bundle bundle) {
        this(builder.zznm, zza(builder, -1), i, bundle);
        AppMethodBeat.i(61091);
        AppMethodBeat.o(61091);
    }

    private DataHolder(Builder builder, int i, Bundle bundle, int i2) {
        this(builder.zznm, zza(builder, i2), i, bundle);
        AppMethodBeat.i(61092);
        AppMethodBeat.o(61092);
    }

    public DataHolder(CursorWrapper cursorWrapper, int i, Bundle bundle) {
        this(cursorWrapper.getColumnNames(), zza(cursorWrapper), i, bundle);
        AppMethodBeat.i(61089);
        AppMethodBeat.o(61089);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        AppMethodBeat.i(61088);
        this.mClosed = false;
        this.zzns = true;
        this.zzal = 1;
        this.zznm = (String[]) Preconditions.checkNotNull(strArr);
        this.zzno = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.zzam = i;
        this.zznp = bundle;
        validateContents();
        AppMethodBeat.o(61088);
    }

    public static Builder builder(String[] strArr) {
        AppMethodBeat.i(61118);
        Builder builder = new Builder(strArr, null, null);
        AppMethodBeat.o(61118);
        return builder;
    }

    public static Builder builder(String[] strArr, String str) {
        AppMethodBeat.i(61119);
        Preconditions.checkNotNull(str);
        Builder builder = new Builder(strArr, str, null);
        AppMethodBeat.o(61119);
        return builder;
    }

    public static DataHolder empty(int i) {
        AppMethodBeat.i(61120);
        DataHolder empty = empty(i, null);
        AppMethodBeat.o(61120);
        return empty;
    }

    public static DataHolder empty(int i, Bundle bundle) {
        AppMethodBeat.i(61121);
        DataHolder dataHolder = new DataHolder(zznt, i, bundle);
        AppMethodBeat.o(61121);
        return dataHolder;
    }

    private final void zza(String str, int i) {
        AppMethodBeat.i(61098);
        if (this.zznn == null || !this.zznn.containsKey(str)) {
            String str2 = "No such column: ";
            String valueOf = String.valueOf(str);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            AppMethodBeat.o(61098);
            throw illegalArgumentException;
        } else if (isClosed()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Buffer is closed.");
            AppMethodBeat.o(61098);
            throw illegalArgumentException2;
        } else if (i < 0 || i >= this.zznr) {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException(i, this.zznr);
            AppMethodBeat.o(61098);
            throw cursorIndexOutOfBoundsException;
        } else {
            AppMethodBeat.o(61098);
        }
    }

    private static CursorWindow[] zza(Builder builder, int i) {
        int i2 = 0;
        AppMethodBeat.i(61097);
        CursorWindow[] cursorWindowArr;
        if (builder.zznm.length == 0) {
            cursorWindowArr = new CursorWindow[0];
            AppMethodBeat.o(61097);
            return cursorWindowArr;
        }
        List zzb = (i < 0 || i >= builder.zznu.size()) ? builder.zznu : builder.zznu.subList(0, i);
        int size = zzb.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(builder.zznm.length);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            try {
                int i5;
                int i6;
                if (!cursorWindow.allocRow()) {
                    new StringBuilder(72).append("Allocating additional cursor window for large data set (row ").append(i3).append(")");
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(builder.zznm.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        arrayList.remove(cursorWindow);
                        cursorWindowArr = (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                        AppMethodBeat.o(61097);
                        return cursorWindowArr;
                    }
                }
                Map map = (Map) zzb.get(i3);
                boolean z = true;
                for (int i7 = 0; i7 < builder.zznm.length && z; i7++) {
                    Object obj = builder.zznm[i7];
                    Object obj2 = map.get(obj);
                    if (obj2 == null) {
                        z = cursorWindow.putNull(i3, i7);
                    } else if (obj2 instanceof String) {
                        z = cursorWindow.putString((String) obj2, i3, i7);
                    } else if (obj2 instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj2).longValue(), i3, i7);
                    } else if (obj2 instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj2).intValue(), i3, i7);
                    } else if (obj2 instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj2).booleanValue() ? 1 : 0, i3, i7);
                    } else if (obj2 instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj2, i3, i7);
                    } else if (obj2 instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj2).doubleValue(), i3, i7);
                    } else if (obj2 instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj2).floatValue(), i3, i7);
                    } else {
                        String valueOf = String.valueOf(obj2);
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder((String.valueOf(obj).length() + 32) + String.valueOf(valueOf).length()).append("Unsupported object for column ").append(obj).append(": ").append(valueOf).toString());
                        AppMethodBeat.o(61097);
                        throw illegalArgumentException;
                    }
                }
                if (z) {
                    i5 = i3;
                    i6 = 0;
                } else if (i4 != 0) {
                    DataHolderException dataHolderException = new DataHolderException("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                    AppMethodBeat.o(61097);
                    throw dataHolderException;
                } else {
                    new StringBuilder(74).append("Couldn't populate window data for row ").append(i3).append(" - allocating new window.");
                    cursorWindow.freeLastRow();
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(builder.zznm.length);
                    arrayList.add(cursorWindow);
                    i5 = i3 - 1;
                    i6 = 1;
                }
                i3 = i5 + 1;
                i4 = i6;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                int size2 = arrayList.size();
                while (i2 < size2) {
                    ((CursorWindow) arrayList.get(i2)).close();
                    i2++;
                }
                AppMethodBeat.o(61097);
                throw runtimeException;
            }
        }
        cursorWindowArr = (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        AppMethodBeat.o(61097);
        return cursorWindowArr;
    }

    private static CursorWindow[] zza(CursorWrapper cursorWrapper) {
        AppMethodBeat.i(61096);
        ArrayList arrayList = new ArrayList();
        try {
            int i;
            int count = cursorWrapper.getCount();
            CursorWindow window = cursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i = 0;
            } else {
                window.acquireReference();
                cursorWrapper.setWindow(null);
                arrayList.add(window);
                i = window.getNumRows();
            }
            while (i < count && cursorWrapper.moveToPosition(i)) {
                CursorWindow window2 = cursorWrapper.getWindow();
                if (window2 != null) {
                    window2.acquireReference();
                    cursorWrapper.setWindow(null);
                } else {
                    window2 = new CursorWindow(false);
                    window2.setStartPosition(i);
                    cursorWrapper.fillWindow(i, window2);
                }
                if (window2.getNumRows() == 0) {
                    break;
                }
                arrayList.add(window2);
                i = window2.getNumRows() + window2.getStartPosition();
            }
            cursorWrapper.close();
            CursorWindow[] cursorWindowArr = (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
            AppMethodBeat.o(61096);
            return cursorWindowArr;
        } catch (Throwable th) {
            cursorWrapper.close();
            AppMethodBeat.o(61096);
        }
    }

    public final void clearColumn(String str, int i, int i2) {
        AppMethodBeat.i(61110);
        zza(str, i);
        this.zzno[i2].putNull(i, this.zznn.getInt(str));
        AppMethodBeat.o(61110);
    }

    public final void close() {
        AppMethodBeat.i(61116);
        synchronized (this) {
            try {
                if (!this.mClosed) {
                    this.mClosed = true;
                    for (CursorWindow close : this.zzno) {
                        close.close();
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(61116);
            }
        }
    }

    public final void copyToBuffer(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        AppMethodBeat.i(61108);
        zza(str, i);
        this.zzno[i2].copyStringToBuffer(i, this.zznn.getInt(str), charArrayBuffer);
        AppMethodBeat.o(61108);
    }

    public final void disableLeakDetection() {
        this.zzns = false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(61117);
        try {
            if (this.zzns && this.zzno.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                new StringBuilder(String.valueOf(obj).length() + 178).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ").append(obj).append(")");
            }
            super.finalize();
            AppMethodBeat.o(61117);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.o(61117);
        }
    }

    public final boolean getBoolean(String str, int i, int i2) {
        AppMethodBeat.i(61103);
        zza(str, i);
        if (this.zzno[i2].getLong(i, this.zznn.getInt(str)) == 1) {
            AppMethodBeat.o(61103);
            return true;
        }
        AppMethodBeat.o(61103);
        return false;
    }

    public final byte[] getByteArray(String str, int i, int i2) {
        AppMethodBeat.i(61106);
        zza(str, i);
        byte[] blob = this.zzno[i2].getBlob(i, this.zznn.getInt(str));
        AppMethodBeat.o(61106);
        return blob;
    }

    public final int getCount() {
        return this.zznr;
    }

    public final double getDouble(String str, int i, int i2) {
        AppMethodBeat.i(61105);
        zza(str, i);
        double d = this.zzno[i2].getDouble(i, this.zznn.getInt(str));
        AppMethodBeat.o(61105);
        return d;
    }

    public final float getFloat(String str, int i, int i2) {
        AppMethodBeat.i(61104);
        zza(str, i);
        float f = this.zzno[i2].getFloat(i, this.zznn.getInt(str));
        AppMethodBeat.o(61104);
        return f;
    }

    public final int getInteger(String str, int i, int i2) {
        AppMethodBeat.i(61101);
        zza(str, i);
        int i3 = this.zzno[i2].getInt(i, this.zznn.getInt(str));
        AppMethodBeat.o(61101);
        return i3;
    }

    public final long getLong(String str, int i, int i2) {
        AppMethodBeat.i(61100);
        zza(str, i);
        long j = this.zzno[i2].getLong(i, this.zznn.getInt(str));
        AppMethodBeat.o(61100);
        return j;
    }

    public final Bundle getMetadata() {
        return this.zznp;
    }

    public final int getStatusCode() {
        return this.zzam;
    }

    public final String getString(String str, int i, int i2) {
        AppMethodBeat.i(61102);
        zza(str, i);
        String string = this.zzno[i2].getString(i, this.zznn.getInt(str));
        AppMethodBeat.o(61102);
        return string;
    }

    public final int getWindowIndex(int i) {
        int i2 = 0;
        AppMethodBeat.i(61115);
        boolean z = i >= 0 && i < this.zznr;
        Preconditions.checkState(z);
        while (i2 < this.zznq.length) {
            if (i < this.zznq[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        if (i2 == this.zznq.length) {
            i2--;
        }
        AppMethodBeat.o(61115);
        return i2;
    }

    public final boolean hasColumn(String str) {
        AppMethodBeat.i(61099);
        boolean containsKey = this.zznn.containsKey(str);
        AppMethodBeat.o(61099);
        return containsKey;
    }

    public final boolean hasNull(String str, int i, int i2) {
        AppMethodBeat.i(61109);
        zza(str, i);
        boolean isNull = this.zzno[i2].isNull(i, this.zznn.getInt(str));
        AppMethodBeat.o(61109);
        return isNull;
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final void logCursorMetadataForDebugging() {
        AppMethodBeat.i(61095);
        new StringBuilder(32).append("num cursor windows : ").append(this.zzno.length);
        new StringBuilder(46).append("total number of objects in holder: ").append(this.zznr);
        new StringBuilder(42).append("total mumber of windowOffsets: ").append(this.zznq.length);
        for (int i = 0; i < this.zznq.length; i++) {
            new StringBuilder(43).append("offset for window ").append(i).append(" : ").append(this.zznq[i]);
            new StringBuilder(45).append("num rows for window ").append(i).append(" : ").append(this.zzno[i].getNumRows());
            new StringBuilder(46).append("start pos for window ").append(i).append(" : ").append(this.zzno[i].getStartPosition());
        }
        AppMethodBeat.o(61095);
    }

    public final Uri parseUri(String str, int i, int i2) {
        AppMethodBeat.i(61107);
        String string = getString(str, i, i2);
        if (string == null) {
            AppMethodBeat.o(61107);
            return null;
        }
        Uri parse = Uri.parse(string);
        AppMethodBeat.o(61107);
        return parse;
    }

    public final void replaceValue(String str, int i, int i2, double d) {
        AppMethodBeat.i(61112);
        zza(str, i);
        this.zzno[i2].putDouble(d, i, this.zznn.getInt(str));
        AppMethodBeat.o(61112);
    }

    public final void replaceValue(String str, int i, int i2, long j) {
        AppMethodBeat.i(61113);
        zza(str, i);
        this.zzno[i2].putLong(j, i, this.zznn.getInt(str));
        AppMethodBeat.o(61113);
    }

    public final void replaceValue(String str, int i, int i2, String str2) {
        AppMethodBeat.i(61111);
        zza(str, i);
        this.zzno[i2].putString(str2, i, this.zznn.getInt(str));
        AppMethodBeat.o(61111);
    }

    public final void replaceValue(String str, int i, int i2, byte[] bArr) {
        AppMethodBeat.i(61114);
        zza(str, i);
        this.zzno[i2].putBlob(bArr, i, this.zznn.getInt(str));
        AppMethodBeat.o(61114);
    }

    public final void validateContents() {
        int i;
        AppMethodBeat.i(61093);
        this.zznn = new Bundle();
        for (i = 0; i < this.zznm.length; i++) {
            this.zznn.putInt(this.zznm[i], i);
        }
        this.zznq = new int[this.zzno.length];
        int i2 = 0;
        for (i = 0; i < this.zzno.length; i++) {
            this.zznq[i] = i2;
            i2 += this.zzno[i].getNumRows() - (i2 - this.zzno[i].getStartPosition());
        }
        this.zznr = i2;
        AppMethodBeat.o(61093);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(61094);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zznm, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzno, i, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzal);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
        AppMethodBeat.o(61094);
    }
}
