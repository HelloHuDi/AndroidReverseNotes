package com.tencent.p177mm.modelsfs;

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

/* renamed from: com.tencent.mm.modelsfs.SFSContext */
public class SFSContext {
    long mNativePtr;

    /* renamed from: com.tencent.mm.modelsfs.SFSContext$FileEntry */
    public static class FileEntry {
        public String name;
        public long size;
        public long timestamp;
    }

    /* renamed from: com.tencent.mm.modelsfs.SFSContext$Builder */
    public static class Builder implements Parcelable {
        public static final Creator<Builder> CREATOR = new C97001();
        HashMap<Integer, Object> mConf;
        String mName;

        /* renamed from: com.tencent.mm.modelsfs.SFSContext$Builder$1 */
        static class C97001 implements Creator<Builder> {
            C97001() {
            }

            public final Builder createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(93211);
                Builder builder = new Builder(parcel, null);
                AppMethodBeat.m2505o(93211);
                return builder;
            }

            public final Builder[] newArray(int i) {
                return new Builder[i];
            }
        }

        /* synthetic */ Builder(Parcel parcel, C264651 c264651) {
            this(parcel);
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setIndexDBPath(String str) {
            AppMethodBeat.m2504i(93214);
            this.mConf.put(Integer.valueOf(1), str);
            AppMethodBeat.m2505o(93214);
            return this;
        }

        public Builder setBlockFilePrefix(String str) {
            AppMethodBeat.m2504i(93215);
            this.mConf.put(Integer.valueOf(2), str);
            AppMethodBeat.m2505o(93215);
            return this;
        }

        public Builder setOverflowPrefix(String str) {
            AppMethodBeat.m2504i(93216);
            this.mConf.put(Integer.valueOf(3), str);
            AppMethodBeat.m2505o(93216);
            return this;
        }

        public Builder setIOMode(int i) {
            AppMethodBeat.m2504i(93217);
            this.mConf.put(Integer.valueOf(9), Integer.valueOf(i));
            AppMethodBeat.m2505o(93217);
            return this;
        }

        public Builder setBlockSizeArray(int[] iArr) {
            AppMethodBeat.m2504i(93218);
            this.mConf.put(Integer.valueOf(5), iArr);
            AppMethodBeat.m2505o(93218);
            return this;
        }

        public Builder setBlockFileMaxSize(int i) {
            AppMethodBeat.m2504i(93219);
            this.mConf.put(Integer.valueOf(4), Integer.valueOf(i));
            AppMethodBeat.m2505o(93219);
            return this;
        }

        public Builder setConnectionPool(int i) {
            AppMethodBeat.m2504i(93220);
            this.mConf.put(Integer.valueOf(7), Integer.valueOf(i));
            AppMethodBeat.m2505o(93220);
            return this;
        }

        public Builder setMaxConcurrentIO(int i) {
            AppMethodBeat.m2504i(93221);
            this.mConf.put(Integer.valueOf(10), Integer.valueOf(i));
            AppMethodBeat.m2505o(93221);
            return this;
        }

        public Builder setSyncMode(int i) {
            AppMethodBeat.m2504i(93222);
            this.mConf.put(Integer.valueOf(11), Integer.valueOf(i));
            AppMethodBeat.m2505o(93222);
            return this;
        }

        public Builder setStoragePath(String str) {
            AppMethodBeat.m2504i(93223);
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            this.mConf.put(Integer.valueOf(2), str + "/%s.block");
            this.mConf.put(Integer.valueOf(3), str + "/%s/");
            AppMethodBeat.m2505o(93223);
            return this;
        }

        public Builder setDBDirectory(String str) {
            AppMethodBeat.m2504i(93224);
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            this.mConf.put(Integer.valueOf(1), str + "/%s.index");
            AppMethodBeat.m2505o(93224);
            return this;
        }

        public Builder() {
            AppMethodBeat.m2504i(93225);
            this.mName = null;
            this.mConf = new HashMap();
            AppMethodBeat.m2505o(93225);
        }

        public SFSContext create() {
            AppMethodBeat.m2504i(93226);
            SFSContext sFSContext = new SFSContext(this, (byte) 0);
            AppMethodBeat.m2505o(93226);
            return sFSContext;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(93227);
            parcel.writeString(this.mName);
            Object[] objArr = new Object[12];
            for (Entry entry : this.mConf.entrySet()) {
                int intValue = ((Integer) entry.getKey()).intValue();
                if (intValue < 12 && intValue >= 0) {
                    objArr[intValue] = entry.getValue();
                }
            }
            parcel.writeArray(objArr);
            AppMethodBeat.m2505o(93227);
        }

        static {
            AppMethodBeat.m2504i(93229);
            AppMethodBeat.m2505o(93229);
        }

        private Builder(Parcel parcel) {
            AppMethodBeat.m2504i(93228);
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
            AppMethodBeat.m2505o(93228);
        }
    }

    /* renamed from: com.tencent.mm.modelsfs.SFSContext$Statistics */
    public static class Statistics implements Serializable {
        private static final long serialVersionUID = 1;
        public BlockFile[] blockFiles;
        public long blockSizeEmpty;
        public long blockSizeUsed;
        public BlockType[] blockTypes;
        public long overflowActualSize;
        public long totalActualSize;

        /* renamed from: com.tencent.mm.modelsfs.SFSContext$Statistics$BlockFile */
        public static class BlockFile implements Serializable {
            private static final long serialVersionUID = 1;
            public int blockCount;
            public boolean deleted;
            public int emptyCount;
            public long fileSize;
            public long timestamp;
        }

        /* renamed from: com.tencent.mm.modelsfs.SFSContext$Statistics$BlockType */
        public static class BlockType implements Serializable {
            private static final long serialVersionUID = 1;
            public long actualSize;
            public int blockSize;
            public int emptyCount;
            public int usedCount;
        }

        public String toString() {
            int i = 0;
            AppMethodBeat.m2504i(93230);
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
            AppMethodBeat.m2505o(93230);
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
        AppMethodBeat.m2504i(93231);
        for (Entry entry : builder.mConf.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                SFSContext.nativeSetIntConf(intValue, ((Integer) value).intValue());
            } else if (value instanceof String) {
                SFSContext.nativeSetStringConf(intValue, (String) value);
            } else if (value instanceof int[]) {
                SFSContext.nativeSetIntArrayConf(intValue, (int[]) value);
            }
        }
        long nativeInit = SFSContext.nativeInit(builder.mName);
        if (nativeInit == 0) {
            RuntimeException runtimeException = new RuntimeException(SFSContext.nativeErrorMessage());
            AppMethodBeat.m2505o(93231);
            throw runtimeException;
        }
        this.mNativePtr = nativeInit;
        AppMethodBeat.m2505o(93231);
    }

    public final void release() {
        AppMethodBeat.m2504i(93232);
        SFSContext.nativeRelease(this.mNativePtr);
        this.mNativePtr = 0;
        AppMethodBeat.m2505o(93232);
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.m2504i(93233);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.m2505o(93233);
            throw illegalArgumentException;
        }
        long tj;
        if (C1869f.m3981th(str)) {
            tj = C1869f.m3983tj(str);
            str = C1869f.m3982ti(str);
        } else {
            tj = 0;
        }
        long nativeOpenRead = SFSContext.nativeOpenRead(this.mNativePtr, str);
        if (nativeOpenRead == 0) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException(str + ": " + SFSContext.nativeErrorMessage());
            AppMethodBeat.m2505o(93233);
            throw fileNotFoundException;
        } else if (tj != 0) {
            InputStream c32821d = new C32821d(nativeOpenRead, tj);
            AppMethodBeat.m2505o(93233);
            return c32821d;
        } else {
            InputStream sFSInputStream = new SFSInputStream(nativeOpenRead);
            AppMethodBeat.m2505o(93233);
            return sFSInputStream;
        }
    }

    /* renamed from: pH */
    public final OutputStream mo44222pH(String str) {
        AppMethodBeat.m2504i(93234);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.m2505o(93234);
            throw illegalArgumentException;
        }
        String str2 = "";
        if (C1869f.m3981th(str)) {
            str2 = C1869f.m3984tk(str);
            str = C1869f.m3982ti(str);
        }
        OutputStream aR = mo44218aR(str, str2);
        AppMethodBeat.m2505o(93234);
        return aR;
    }

    /* renamed from: aR */
    public final OutputStream mo44218aR(String str, String str2) {
        AppMethodBeat.m2504i(93235);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.m2505o(93235);
            throw illegalArgumentException;
        }
        long nativeOpenWrite = SFSContext.nativeOpenWrite(this.mNativePtr, str);
        if (nativeOpenWrite == 0) {
            IOException iOException = new IOException(str + ": " + SFSContext.nativeErrorMessage());
            AppMethodBeat.m2505o(93235);
            throw iOException;
        } else if (TextUtils.isEmpty(str2)) {
            OutputStream sFSOutputStream = new SFSOutputStream(nativeOpenWrite);
            AppMethodBeat.m2505o(93235);
            return sFSOutputStream;
        } else {
            C1868e c1868e = new C1868e(nativeOpenWrite, str2);
            AppMethodBeat.m2505o(93235);
            return c1868e;
        }
    }

    /* renamed from: tl */
    public final List<FileEntry> mo44225tl(String str) {
        AppMethodBeat.m2504i(93236);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.m2505o(93236);
            throw illegalArgumentException;
        }
        ArrayList arrayList = new ArrayList();
        if (SFSContext.nativeList(this.mNativePtr, str, arrayList) != 0) {
            IOException iOException = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.m2505o(93236);
            throw iOException;
        }
        AppMethodBeat.m2505o(93236);
        return arrayList;
    }

    public final boolean exists(String str) {
        AppMethodBeat.m2504i(93237);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.m2505o(93237);
            throw illegalArgumentException;
        }
        if (C1869f.m3981th(str)) {
            C1869f.m3983tj(str);
            str = C1869f.m3982ti(str);
        }
        boolean nativeExists = SFSContext.nativeExists(this.mNativePtr, str);
        AppMethodBeat.m2505o(93237);
        return nativeExists;
    }

    /* renamed from: tm */
    public final FileEntry mo44226tm(String str) {
        AppMethodBeat.m2504i(93238);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.m2505o(93238);
            throw illegalArgumentException;
        }
        if (C1869f.m3981th(str)) {
            C1869f.m3983tj(str);
            str = C1869f.m3982ti(str);
        }
        FileEntry nativeStat = SFSContext.nativeStat(this.mNativePtr, str);
        AppMethodBeat.m2505o(93238);
        return nativeStat;
    }

    /* renamed from: pI */
    public final boolean mo44223pI(String str) {
        AppMethodBeat.m2504i(93239);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.m2505o(93239);
            throw illegalArgumentException;
        }
        if (C1869f.m3981th(str)) {
            C1869f.m3983tj(str);
            str = C1869f.m3982ti(str);
        }
        boolean nativeUnlink = SFSContext.nativeUnlink(this.mNativePtr, str);
        AppMethodBeat.m2505o(93239);
        return nativeUnlink;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(93240);
        if (this.mNativePtr != 0) {
            release();
        }
        super.finalize();
        AppMethodBeat.m2505o(93240);
    }
}
