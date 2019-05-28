package com.tencent.mm.modelsfs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class SFSContext {
    long mNativePtr;

    public static class FileEntry {
        public String name;
        public long size;
        public long timestamp;
    }

    public static class Builder implements Parcelable {
        public static final Creator<Builder> CREATOR = new Creator<Builder>() {
            public final Builder createFromParcel(Parcel parcel) {
                AppMethodBeat.i(93211);
                Builder builder = new Builder(parcel, null);
                AppMethodBeat.o(93211);
                return builder;
            }

            public final Builder[] newArray(int i) {
                return new Builder[i];
            }
        };
        HashMap<Integer, Object> mConf;
        String mName;

        /* synthetic */ Builder(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setIndexDBPath(String str) {
            AppMethodBeat.i(93214);
            this.mConf.put(Integer.valueOf(1), str);
            AppMethodBeat.o(93214);
            return this;
        }

        public Builder setBlockFilePrefix(String str) {
            AppMethodBeat.i(93215);
            this.mConf.put(Integer.valueOf(2), str);
            AppMethodBeat.o(93215);
            return this;
        }

        public Builder setOverflowPrefix(String str) {
            AppMethodBeat.i(93216);
            this.mConf.put(Integer.valueOf(3), str);
            AppMethodBeat.o(93216);
            return this;
        }

        public Builder setIOMode(int i) {
            AppMethodBeat.i(93217);
            this.mConf.put(Integer.valueOf(9), Integer.valueOf(i));
            AppMethodBeat.o(93217);
            return this;
        }

        public Builder setBlockSizeArray(int[] iArr) {
            AppMethodBeat.i(93218);
            this.mConf.put(Integer.valueOf(5), iArr);
            AppMethodBeat.o(93218);
            return this;
        }

        public Builder setBlockFileMaxSize(int i) {
            AppMethodBeat.i(93219);
            this.mConf.put(Integer.valueOf(4), Integer.valueOf(i));
            AppMethodBeat.o(93219);
            return this;
        }

        public Builder setConnectionPool(int i) {
            AppMethodBeat.i(93220);
            this.mConf.put(Integer.valueOf(7), Integer.valueOf(i));
            AppMethodBeat.o(93220);
            return this;
        }

        public Builder setMaxConcurrentIO(int i) {
            AppMethodBeat.i(93221);
            this.mConf.put(Integer.valueOf(10), Integer.valueOf(i));
            AppMethodBeat.o(93221);
            return this;
        }

        public Builder setSyncMode(int i) {
            AppMethodBeat.i(93222);
            this.mConf.put(Integer.valueOf(11), Integer.valueOf(i));
            AppMethodBeat.o(93222);
            return this;
        }

        public Builder setStoragePath(String str) {
            AppMethodBeat.i(93223);
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            this.mConf.put(Integer.valueOf(2), str + "/%s.block");
            this.mConf.put(Integer.valueOf(3), str + "/%s/");
            AppMethodBeat.o(93223);
            return this;
        }

        public Builder setDBDirectory(String str) {
            AppMethodBeat.i(93224);
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            this.mConf.put(Integer.valueOf(1), str + "/%s.index");
            AppMethodBeat.o(93224);
            return this;
        }

        public Builder() {
            AppMethodBeat.i(93225);
            this.mName = null;
            this.mConf = new HashMap();
            AppMethodBeat.o(93225);
        }

        public SFSContext create() {
            AppMethodBeat.i(93226);
            SFSContext sFSContext = new SFSContext(this, (byte) 0);
            AppMethodBeat.o(93226);
            return sFSContext;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(93227);
            parcel.writeString(this.mName);
            Object[] objArr = new Object[12];
            for (Entry entry : this.mConf.entrySet()) {
                int intValue = ((Integer) entry.getKey()).intValue();
                if (intValue < 12 && intValue >= 0) {
                    objArr[intValue] = entry.getValue();
                }
            }
            parcel.writeArray(objArr);
            AppMethodBeat.o(93227);
        }

        static {
            AppMethodBeat.i(93229);
            AppMethodBeat.o(93229);
        }

        private Builder(Parcel parcel) {
            AppMethodBeat.i(93228);
            this.mName = parcel.readString();
            this.mConf = new HashMap();
            Object[] readArray = parcel.readArray(Builder.class.getClassLoader());
            if (readArray != null) {
                for (int i = 0; i < readArray.length; i++) {
                    if (readArray[i] != null) {
                        this.mConf.put(Integer.valueOf(i), readArray[i]);
                    }
                }
            }
            AppMethodBeat.o(93228);
        }
    }

    public static class Statistics implements Serializable {
        private static final long serialVersionUID = 1;
        public BlockFile[] blockFiles;
        public long blockSizeEmpty;
        public long blockSizeUsed;
        public BlockType[] blockTypes;
        public long overflowActualSize;
        public long totalActualSize;

        public static class BlockFile implements Serializable {
            private static final long serialVersionUID = 1;
            public int blockCount;
            public boolean deleted;
            public int emptyCount;
            public long fileSize;
            public long timestamp;
        }

        public static class BlockType implements Serializable {
            private static final long serialVersionUID = 1;
            public long actualSize;
            public int blockSize;
            public int emptyCount;
            public int usedCount;
        }

        public String toString() {
            int i = 0;
            AppMethodBeat.i(93230);
            StringBuilder stringBuilder = new StringBuilder(4096);
            stringBuilder.append("Total:\n\tActualSize: ").append(this.totalActualSize).append(10).append("\tUsedBlockSize: ").append(this.blockSizeUsed).append(10).append("\tEmptyBlockSize: ").append(this.blockSizeEmpty).append(10).append("\tOverflowSize: ").append(this.overflowActualSize).append(10);
            for (BlockType blockType : this.blockTypes) {
                stringBuilder.append("BlockType: ").append(blockType.blockSize).append(10).append("\tUsedCount: ").append(blockType.usedCount).append(10).append("\tEmptyCount: ").append(blockType.emptyCount).append(10).append("\tActualSize: ").append(blockType.actualSize).append(10);
            }
            while (i < this.blockFiles.length) {
                BlockFile blockFile = this.blockFiles[i];
                stringBuilder.append("BlockFile: ").append(i).append(10).append("\tFileSize: ").append(blockFile.fileSize).append(10).append("\tUsedBlockCount: ").append(blockFile.blockCount).append(10).append("\tEmptyBlockCount: ").append(blockFile.emptyCount).append(10).append("\tTimestamp: ").append(blockFile.timestamp).append(10).append("\tDeleted: ").append(blockFile.deleted).append(10);
                i++;
            }
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(93230);
            return stringBuilder2;
        }
    }

    static native int nativeClear(long j);

    static native String nativeErrorMessage();

    private static native boolean nativeExists(long j, String str);

    private static native long nativeInit(String str);

    private static native int nativeList(long j, String str, List<FileEntry> list);

    private static native long nativeOpenRead(long j, String str);

    private static native long nativeOpenWrite(long j, String str);

    private static native void nativeRelease(long j);

    private static native void nativeSetIntArrayConf(int i, int[] iArr);

    private static native void nativeSetIntConf(int i, int i2);

    private static native void nativeSetStringConf(int i, String str);

    private static native FileEntry nativeStat(long j, String str);

    static native Statistics nativeStatistics(long j);

    private static native boolean nativeUnlink(long j, String str);

    /* synthetic */ SFSContext(Builder builder, byte b) {
        this(builder);
    }

    private SFSContext(Builder builder) {
        AppMethodBeat.i(93231);
        for (Entry entry : builder.mConf.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                nativeSetIntConf(intValue, ((Integer) value).intValue());
            } else if (value instanceof String) {
                nativeSetStringConf(intValue, (String) value);
            } else if (value instanceof int[]) {
                nativeSetIntArrayConf(intValue, (int[]) value);
            }
        }
        long nativeInit = nativeInit(builder.mName);
        if (nativeInit == 0) {
            RuntimeException runtimeException = new RuntimeException(nativeErrorMessage());
            AppMethodBeat.o(93231);
            throw runtimeException;
        }
        this.mNativePtr = nativeInit;
        AppMethodBeat.o(93231);
    }

    public final void release() {
        AppMethodBeat.i(93232);
        nativeRelease(this.mNativePtr);
        this.mNativePtr = 0;
        AppMethodBeat.o(93232);
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.i(93233);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.o(93233);
            throw illegalArgumentException;
        }
        long tj;
        if (f.th(str)) {
            tj = f.tj(str);
            str = f.ti(str);
        } else {
            tj = 0;
        }
        long nativeOpenRead = nativeOpenRead(this.mNativePtr, str);
        if (nativeOpenRead == 0) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException(str + ": " + nativeErrorMessage());
            AppMethodBeat.o(93233);
            throw fileNotFoundException;
        } else if (tj != 0) {
            InputStream dVar = new d(nativeOpenRead, tj);
            AppMethodBeat.o(93233);
            return dVar;
        } else {
            InputStream sFSInputStream = new SFSInputStream(nativeOpenRead);
            AppMethodBeat.o(93233);
            return sFSInputStream;
        }
    }

    public final OutputStream pH(String str) {
        AppMethodBeat.i(93234);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.o(93234);
            throw illegalArgumentException;
        }
        String str2 = "";
        if (f.th(str)) {
            str2 = f.tk(str);
            str = f.ti(str);
        }
        OutputStream aR = aR(str, str2);
        AppMethodBeat.o(93234);
        return aR;
    }

    public final OutputStream aR(String str, String str2) {
        AppMethodBeat.i(93235);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.o(93235);
            throw illegalArgumentException;
        }
        long nativeOpenWrite = nativeOpenWrite(this.mNativePtr, str);
        if (nativeOpenWrite == 0) {
            IOException iOException = new IOException(str + ": " + nativeErrorMessage());
            AppMethodBeat.o(93235);
            throw iOException;
        } else if (TextUtils.isEmpty(str2)) {
            OutputStream sFSOutputStream = new SFSOutputStream(nativeOpenWrite);
            AppMethodBeat.o(93235);
            return sFSOutputStream;
        } else {
            e eVar = new e(nativeOpenWrite, str2);
            AppMethodBeat.o(93235);
            return eVar;
        }
    }

    public final List<FileEntry> tl(String str) {
        AppMethodBeat.i(93236);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.o(93236);
            throw illegalArgumentException;
        }
        ArrayList arrayList = new ArrayList();
        if (nativeList(this.mNativePtr, str, arrayList) != 0) {
            IOException iOException = new IOException(nativeErrorMessage());
            AppMethodBeat.o(93236);
            throw iOException;
        }
        AppMethodBeat.o(93236);
        return arrayList;
    }

    public final boolean exists(String str) {
        AppMethodBeat.i(93237);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.o(93237);
            throw illegalArgumentException;
        }
        if (f.th(str)) {
            f.tj(str);
            str = f.ti(str);
        }
        boolean nativeExists = nativeExists(this.mNativePtr, str);
        AppMethodBeat.o(93237);
        return nativeExists;
    }

    public final FileEntry tm(String str) {
        AppMethodBeat.i(93238);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.o(93238);
            throw illegalArgumentException;
        }
        if (f.th(str)) {
            f.tj(str);
            str = f.ti(str);
        }
        FileEntry nativeStat = nativeStat(this.mNativePtr, str);
        AppMethodBeat.o(93238);
        return nativeStat;
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(93239);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.o(93239);
            throw illegalArgumentException;
        }
        if (f.th(str)) {
            f.tj(str);
            str = f.ti(str);
        }
        boolean nativeUnlink = nativeUnlink(this.mNativePtr, str);
        AppMethodBeat.o(93239);
        return nativeUnlink;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(93240);
        if (this.mNativePtr != 0) {
            release();
        }
        super.finalize();
        AppMethodBeat.o(93240);
    }
}
