package com.tencent.p177mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import com.tencent.p177mm.vfs.FileSystem.C5713b;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.vfs.FileSystemWrapper */
public abstract class FileSystemWrapper extends AbstractFileSystem {
    protected final FileSystem zYO;

    protected FileSystemWrapper(FileSystem fileSystem) {
        this.zYO = fileSystem;
    }

    public final int aiR() {
        return this.zYO.aiR();
    }

    /* renamed from: tn */
    public final C5713b mo11620tn(String str) {
        return this.zYO.mo11620tn(str);
    }

    public InputStream openRead(String str) {
        return this.zYO.openRead(str);
    }

    /* renamed from: L */
    public OutputStream mo11607L(String str, boolean z) {
        return this.zYO.mo11607L(str, z);
    }

    public final boolean exists(String str) {
        return this.zYO.exists(str);
    }

    /* renamed from: to */
    public final C5712a mo11621to(String str) {
        return this.zYO.mo11621to(str);
    }

    /* renamed from: t */
    public final boolean mo11618t(String str, long j) {
        return this.zYO.mo11618t(str, j);
    }

    /* renamed from: pI */
    public final boolean mo11617pI(String str) {
        return this.zYO.mo11617pI(str);
    }

    /* renamed from: M */
    public final List<C5712a> mo11608M(String str, boolean z) {
        return this.zYO.mo11608M(str, z);
    }

    /* renamed from: tf */
    public final boolean mo11619tf(String str) {
        return this.zYO.mo11619tf(str);
    }

    /* renamed from: N */
    public final boolean mo11609N(String str, boolean z) {
        return this.zYO.mo11609N(str, z);
    }

    /* renamed from: aS */
    public final boolean mo11612aS(String str, String str2) {
        return this.zYO.mo11612aS(str, str2);
    }

    /* renamed from: O */
    public final String mo11610O(String str, boolean z) {
        return this.zYO.mo11610O(str, z);
    }

    /* renamed from: p */
    public final void mo11616p(Map<String, String> map) {
        this.zYO.mo11616p(map);
    }

    /* renamed from: a */
    public void mo11611a(CancellationSignal cancellationSignal) {
        this.zYO.mo11611a(cancellationSignal);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.zYO, i);
    }
}
