package com.tencent.p177mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import com.tencent.p177mm.vfs.FileSystemManager.C5718d;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.vfs.b */
public final class C5728b implements Comparable<C5728b> {
    public final Uri mUri;
    private C5718d zZK;

    public final /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.m2504i(54622);
        int compareTo = C5736j.m8649w(this.mUri).compareTo(C5736j.m8649w(((C5728b) obj).mUri));
        AppMethodBeat.m2505o(54622);
        return compareTo;
    }

    public final C5718d dMA() {
        AppMethodBeat.m2504i(54590);
        this.zZK = FileSystemManager.dMy().mo11633a(this.mUri, this.zZK);
        C5718d c5718d = this.zZK;
        AppMethodBeat.m2505o(54590);
        return c5718d;
    }

    public C5728b(String str) {
        this(C5736j.parseUri(str));
        AppMethodBeat.m2504i(54591);
        AppMethodBeat.m2505o(54591);
    }

    private C5728b(Uri uri) {
        AppMethodBeat.m2504i(54592);
        this.zZK = null;
        if (uri == null) {
            NullPointerException nullPointerException = new NullPointerException("uri == null");
            AppMethodBeat.m2505o(54592);
            throw nullPointerException;
        }
        String path = uri.getPath();
        if (path != null) {
            path = C5736j.m8648k(path, false, false);
            if (!uri.getPath().equals(path)) {
                uri = uri.buildUpon().path(path).build();
            }
        }
        this.mUri = uri;
        AppMethodBeat.m2505o(54592);
    }

    public C5728b(File file) {
        this(C5736j.parseUri(file.getPath()));
        AppMethodBeat.m2504i(54593);
        AppMethodBeat.m2505o(54593);
    }

    public C5728b(String str, String str2) {
        this(C5736j.parseUri(str), str2);
        AppMethodBeat.m2504i(54594);
        AppMethodBeat.m2505o(54594);
    }

    public C5728b(C5728b c5728b, String str) {
        Uri uri;
        if (c5728b == null) {
            uri = null;
        } else {
            uri = c5728b.mUri;
        }
        this(uri, str);
        AppMethodBeat.m2504i(54595);
        AppMethodBeat.m2505o(54595);
    }

    public C5728b(File file, String str) {
        this(C5736j.parseUri(file.getPath()), str);
        AppMethodBeat.m2504i(54596);
        AppMethodBeat.m2505o(54596);
    }

    private C5728b(Uri uri, String str) {
        AppMethodBeat.m2504i(54597);
        this.zZK = null;
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("name == null");
            AppMethodBeat.m2505o(54597);
            throw nullPointerException;
        }
        Builder path;
        Uri build;
        if (uri == null) {
            path = new Builder().path(str);
        } else {
            path = uri.buildUpon();
            if (!str.isEmpty()) {
                path.appendPath(str);
            }
        }
        Uri build2 = path.build();
        String path2 = build2.getPath();
        if (path2 != null) {
            path2 = C5736j.m8648k(path2, false, false);
            if (!build2.getPath().equals(path2)) {
                build = path.path(path2).build();
                this.mUri = build;
                AppMethodBeat.m2505o(54597);
            }
        }
        build = build2;
        this.mUri = build;
        AppMethodBeat.m2505o(54597);
    }

    public final String getPath() {
        AppMethodBeat.m2504i(138984);
        String w = C5736j.m8649w(this.mUri);
        AppMethodBeat.m2505o(138984);
        return w;
    }

    public final String getName() {
        AppMethodBeat.m2504i(54599);
        String path = this.mUri.getPath();
        int lastIndexOf = path.lastIndexOf("/");
        if (lastIndexOf < 0) {
            AppMethodBeat.m2505o(54599);
            return path;
        }
        path = path.substring(lastIndexOf + 1, path.length());
        AppMethodBeat.m2505o(54599);
        return path;
    }

    private Uri dMB() {
        AppMethodBeat.m2504i(54600);
        String path = this.mUri.getPath();
        int length = path.length();
        int lastIndexOf = path.lastIndexOf(47);
        if (lastIndexOf == -1 || path.charAt(length - 1) == IOUtils.DIR_SEPARATOR_UNIX) {
            AppMethodBeat.m2505o(54600);
            return null;
        }
        if (path.indexOf(47) == lastIndexOf && path.charAt(0) == IOUtils.DIR_SEPARATOR_UNIX) {
            path = path.substring(0, lastIndexOf + 1);
        } else {
            path = path.substring(0, lastIndexOf);
        }
        Uri build = this.mUri.buildUpon().path(path).build();
        AppMethodBeat.m2505o(54600);
        return build;
    }

    public final String getParent() {
        AppMethodBeat.m2504i(54601);
        Uri dMB = dMB();
        if (dMB == null) {
            AppMethodBeat.m2505o(54601);
            return null;
        }
        String w = C5736j.m8649w(dMB);
        AppMethodBeat.m2505o(54601);
        return w;
    }

    public final C5728b dMC() {
        AppMethodBeat.m2504i(54602);
        Uri dMB = dMB();
        if (dMB == null) {
            AppMethodBeat.m2505o(54602);
            return null;
        }
        C5728b c5728b = new C5728b(dMB);
        AppMethodBeat.m2505o(54602);
        return c5728b;
    }

    public final boolean canRead() {
        AppMethodBeat.m2504i(54603);
        C5718d dMA = dMA();
        if (dMA.valid()) {
            FileSystem fileSystem = dMA.zZs;
            String O = fileSystem.mo11610O(dMA.path, false);
            boolean canRead;
            if (O != null) {
                canRead = new File(O).canRead();
                AppMethodBeat.m2505o(54603);
                return canRead;
            }
            canRead = fileSystem.exists(dMA.path);
            AppMethodBeat.m2505o(54603);
            return canRead;
        }
        AppMethodBeat.m2505o(54603);
        return false;
    }

    public final boolean exists() {
        AppMethodBeat.m2504i(54604);
        C5718d dMA = dMA();
        if (dMA.valid()) {
            boolean exists = dMA.zZs.exists(dMA.path);
            AppMethodBeat.m2505o(54604);
            return exists;
        }
        AppMethodBeat.m2505o(54604);
        return false;
    }

    public final String getAbsolutePath() {
        AppMethodBeat.m2504i(138985);
        String w = C5736j.m8649w(dMD());
        AppMethodBeat.m2505o(138985);
        return w;
    }

    public final C5728b dME() {
        AppMethodBeat.m2504i(54607);
        C5728b c5728b = new C5728b(dMD());
        AppMethodBeat.m2505o(54607);
        return c5728b;
    }

    public final boolean isDirectory() {
        AppMethodBeat.m2504i(54608);
        C5718d dMA = dMA();
        if (dMA.valid()) {
            C5712a to = dMA.zZs.mo11621to(dMA.path);
            if (to == null || !to.zYN) {
                AppMethodBeat.m2505o(54608);
                return false;
            }
            AppMethodBeat.m2505o(54608);
            return true;
        }
        AppMethodBeat.m2505o(54608);
        return false;
    }

    public final boolean isFile() {
        AppMethodBeat.m2504i(54609);
        C5718d dMA = dMA();
        if (dMA.valid()) {
            C5712a to = dMA.zZs.mo11621to(dMA.path);
            if (to == null || to.zYN) {
                AppMethodBeat.m2505o(54609);
                return false;
            }
            AppMethodBeat.m2505o(54609);
            return true;
        }
        AppMethodBeat.m2505o(54609);
        return false;
    }

    public final long lastModified() {
        AppMethodBeat.m2504i(54610);
        C5718d dMA = dMA();
        if (dMA.valid()) {
            C5712a to = dMA.zZs.mo11621to(dMA.path);
            if (to == null) {
                AppMethodBeat.m2505o(54610);
                return 0;
            }
            long j = to.zYM;
            AppMethodBeat.m2505o(54610);
            return j;
        }
        AppMethodBeat.m2505o(54610);
        return 0;
    }

    public final long length() {
        AppMethodBeat.m2504i(54611);
        C5718d dMA = dMA();
        if (dMA.valid()) {
            C5712a to = dMA.zZs.mo11621to(dMA.path);
            if (to == null) {
                AppMethodBeat.m2505o(54611);
                return 0;
            }
            long j = to.size;
            AppMethodBeat.m2505o(54611);
            return j;
        }
        AppMethodBeat.m2505o(54611);
        return 0;
    }

    public final String[] list() {
        AppMethodBeat.m2504i(54612);
        C5718d dMA = dMA();
        if (dMA.valid()) {
            List<C5712a> M = dMA.zZs.mo11608M(dMA.path, false);
            if (M == null) {
                AppMethodBeat.m2505o(54612);
                return null;
            }
            String[] strArr = new String[M.size()];
            int i = 0;
            for (C5712a c5712a : M) {
                int i2 = i + 1;
                strArr[i] = c5712a.name;
                i = i2;
            }
            AppMethodBeat.m2505o(54612);
            return strArr;
        }
        AppMethodBeat.m2505o(54612);
        return null;
    }

    /* renamed from: a */
    public final String[] mo11652a(C5734i c5734i) {
        AppMethodBeat.m2504i(54613);
        C5718d dMA = dMA();
        if (dMA.valid()) {
            List<C5712a> M = dMA.zZs.mo11608M(dMA.path, false);
            if (M == null) {
                AppMethodBeat.m2505o(54613);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (C5712a c5712a : M) {
                if (c5734i.mo11677ml(c5712a.name)) {
                    arrayList.add(c5712a.name);
                }
            }
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            AppMethodBeat.m2505o(54613);
            return strArr;
        }
        AppMethodBeat.m2505o(54613);
        return null;
    }

    public final C5728b[] dMF() {
        AppMethodBeat.m2504i(54614);
        C5718d dMA = dMA();
        if (dMA.valid()) {
            List<C5712a> M = dMA.zZs.mo11608M(dMA.path, false);
            if (M == null) {
                AppMethodBeat.m2505o(54614);
                return null;
            }
            C5728b[] c5728bArr = new C5728b[M.size()];
            int i = 0;
            for (C5712a c5712a : M) {
                int i2 = i + 1;
                c5728bArr[i] = new C5728b(this, c5712a.name);
                i = i2;
            }
            AppMethodBeat.m2505o(54614);
            return c5728bArr;
        }
        AppMethodBeat.m2505o(54614);
        return null;
    }

    /* renamed from: a */
    public final C5728b[] mo11651a(C5729c c5729c) {
        AppMethodBeat.m2504i(54615);
        C5718d dMA = dMA();
        if (dMA.valid()) {
            List<C5712a> M = dMA.zZs.mo11608M(dMA.path, false);
            if (M == null) {
                AppMethodBeat.m2505o(54615);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (C5712a c5712a : M) {
                C5728b c5728b = new C5728b(this, c5712a.name);
                if (c5729c.mo11676f(c5728b)) {
                    arrayList.add(c5728b);
                }
            }
            C5728b[] c5728bArr = (C5728b[]) arrayList.toArray(new C5728b[arrayList.size()]);
            AppMethodBeat.m2505o(54615);
            return c5728bArr;
        }
        AppMethodBeat.m2505o(54615);
        return null;
    }

    public final boolean mkdirs() {
        AppMethodBeat.m2504i(54616);
        C5718d dMA = dMA();
        if (dMA.valid()) {
            boolean tf = dMA.zZs.mo11619tf(dMA.path);
            AppMethodBeat.m2505o(54616);
            return tf;
        }
        AppMethodBeat.m2505o(54616);
        return false;
    }

    public final boolean createNewFile() {
        AppMethodBeat.m2504i(54617);
        C5718d dMA = dMA();
        if (!dMA.valid()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: " + this.mUri);
            AppMethodBeat.m2505o(54617);
            throw fileNotFoundException;
        } else if (dMA.zZs.exists(dMA.path)) {
            AppMethodBeat.m2505o(54617);
            return false;
        } else {
            dMA.zZs.mo11607L(dMA.path, true).close();
            AppMethodBeat.m2505o(54617);
            return true;
        }
    }

    /* renamed from: o */
    public final boolean mo11675o(C5728b c5728b) {
        AppMethodBeat.m2504i(54618);
        C5718d dMA = dMA();
        C5718d dMA2 = c5728b.dMA();
        if (!dMA.valid() || !dMA2.valid()) {
            AppMethodBeat.m2505o(54618);
            return false;
        } else if (dMA.zZs != dMA2.zZs) {
            AppMethodBeat.m2505o(54618);
            return false;
        } else {
            boolean aS = dMA.zZs.mo11612aS(dMA.path, dMA2.path);
            AppMethodBeat.m2505o(54618);
            return aS;
        }
    }

    public final boolean delete() {
        AppMethodBeat.m2504i(54619);
        C5718d dMA = dMA();
        if (dMA.valid() && dMA.zZs.mo11617pI(dMA.path)) {
            AppMethodBeat.m2505o(54619);
            return true;
        }
        AppMethodBeat.m2505o(54619);
        return false;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(54621);
        if (obj instanceof C5728b) {
            boolean equals = this.mUri.equals(((C5728b) obj).mUri);
            AppMethodBeat.m2505o(54621);
            return equals;
        }
        AppMethodBeat.m2505o(54621);
        return false;
    }

    public final Uri dMD() {
        int i = 0;
        AppMethodBeat.m2504i(54605);
        String path = this.mUri.getPath();
        if (this.mUri.isAbsolute() || (path.length() > 0 && path.charAt(0) == IOUtils.DIR_SEPARATOR_UNIX)) {
            i = 1;
        }
        Uri uri;
        if (i != 0) {
            uri = this.mUri;
            AppMethodBeat.m2505o(54605);
            return uri;
        }
        path = this.mUri.getPath();
        String property = System.getProperty("user.dir");
        if (!path.isEmpty()) {
            property = property + IOUtils.DIR_SEPARATOR_UNIX + path;
        }
        uri = this.mUri.buildUpon().path(property).build();
        AppMethodBeat.m2505o(54605);
        return uri;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(54620);
        int hashCode = C5736j.m8649w(this.mUri).hashCode() ^ 1234321;
        AppMethodBeat.m2505o(54620);
        return hashCode;
    }
}
