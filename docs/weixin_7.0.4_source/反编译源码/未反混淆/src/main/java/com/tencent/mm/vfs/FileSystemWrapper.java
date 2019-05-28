package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.FileSystem.b;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public abstract class FileSystemWrapper extends AbstractFileSystem {
    protected final FileSystem zYO;

    protected FileSystemWrapper(FileSystem fileSystem) {
        this.zYO = fileSystem;
    }

    public final int aiR() {
        return this.zYO.aiR();
    }

    public final b tn(String str) {
        return this.zYO.tn(str);
    }

    public InputStream openRead(String str) {
        return this.zYO.openRead(str);
    }

    public OutputStream L(String str, boolean z) {
        return this.zYO.L(str, z);
    }

    public final boolean exists(String str) {
        return this.zYO.exists(str);
    }

    public final a to(String str) {
        return this.zYO.to(str);
    }

    public final boolean t(String str, long j) {
        return this.zYO.t(str, j);
    }

    public final boolean pI(String str) {
        return this.zYO.pI(str);
    }

    public final List<a> M(String str, boolean z) {
        return this.zYO.M(str, z);
    }

    public final boolean tf(String str) {
        return this.zYO.tf(str);
    }

    public final boolean N(String str, boolean z) {
        return this.zYO.N(str, z);
    }

    public final boolean aS(String str, String str2) {
        return this.zYO.aS(str, str2);
    }

    public final String O(String str, boolean z) {
        return this.zYO.O(str, z);
    }

    public final void p(Map<String, String> map) {
        this.zYO.p(map);
    }

    public void a(CancellationSignal cancellationSignal) {
        this.zYO.a(cancellationSignal);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.zYO, i);
    }
}
