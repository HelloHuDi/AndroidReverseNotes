package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.FileSystemManager.d;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public final class b implements Comparable<b> {
    public final Uri mUri;
    private d zZK;

    public final /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.i(54622);
        int compareTo = j.w(this.mUri).compareTo(j.w(((b) obj).mUri));
        AppMethodBeat.o(54622);
        return compareTo;
    }

    public final d dMA() {
        AppMethodBeat.i(54590);
        this.zZK = FileSystemManager.dMy().a(this.mUri, this.zZK);
        d dVar = this.zZK;
        AppMethodBeat.o(54590);
        return dVar;
    }

    public b(String str) {
        this(j.parseUri(str));
        AppMethodBeat.i(54591);
        AppMethodBeat.o(54591);
    }

    private b(Uri uri) {
        AppMethodBeat.i(54592);
        this.zZK = null;
        if (uri == null) {
            NullPointerException nullPointerException = new NullPointerException("uri == null");
            AppMethodBeat.o(54592);
            throw nullPointerException;
        }
        String path = uri.getPath();
        if (path != null) {
            path = j.k(path, false, false);
            if (!uri.getPath().equals(path)) {
                uri = uri.buildUpon().path(path).build();
            }
        }
        this.mUri = uri;
        AppMethodBeat.o(54592);
    }

    public b(File file) {
        this(j.parseUri(file.getPath()));
        AppMethodBeat.i(54593);
        AppMethodBeat.o(54593);
    }

    public b(String str, String str2) {
        this(j.parseUri(str), str2);
        AppMethodBeat.i(54594);
        AppMethodBeat.o(54594);
    }

    public b(b bVar, String str) {
        Uri uri;
        if (bVar == null) {
            uri = null;
        } else {
            uri = bVar.mUri;
        }
        this(uri, str);
        AppMethodBeat.i(54595);
        AppMethodBeat.o(54595);
    }

    public b(File file, String str) {
        this(j.parseUri(file.getPath()), str);
        AppMethodBeat.i(54596);
        AppMethodBeat.o(54596);
    }

    private b(Uri uri, String str) {
        AppMethodBeat.i(54597);
        this.zZK = null;
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("name == null");
            AppMethodBeat.o(54597);
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
            path2 = j.k(path2, false, false);
            if (!build2.getPath().equals(path2)) {
                build = path.path(path2).build();
                this.mUri = build;
                AppMethodBeat.o(54597);
            }
        }
        build = build2;
        this.mUri = build;
        AppMethodBeat.o(54597);
    }

    public final String getPath() {
        AppMethodBeat.i(138984);
        String w = j.w(this.mUri);
        AppMethodBeat.o(138984);
        return w;
    }

    public final String getName() {
        AppMethodBeat.i(54599);
        String path = this.mUri.getPath();
        int lastIndexOf = path.lastIndexOf("/");
        if (lastIndexOf < 0) {
            AppMethodBeat.o(54599);
            return path;
        }
        path = path.substring(lastIndexOf + 1, path.length());
        AppMethodBeat.o(54599);
        return path;
    }

    private Uri dMB() {
        AppMethodBeat.i(54600);
        String path = this.mUri.getPath();
        int length = path.length();
        int lastIndexOf = path.lastIndexOf(47);
        if (lastIndexOf == -1 || path.charAt(length - 1) == IOUtils.DIR_SEPARATOR_UNIX) {
            AppMethodBeat.o(54600);
            return null;
        }
        if (path.indexOf(47) == lastIndexOf && path.charAt(0) == IOUtils.DIR_SEPARATOR_UNIX) {
            path = path.substring(0, lastIndexOf + 1);
        } else {
            path = path.substring(0, lastIndexOf);
        }
        Uri build = this.mUri.buildUpon().path(path).build();
        AppMethodBeat.o(54600);
        return build;
    }

    public final String getParent() {
        AppMethodBeat.i(54601);
        Uri dMB = dMB();
        if (dMB == null) {
            AppMethodBeat.o(54601);
            return null;
        }
        String w = j.w(dMB);
        AppMethodBeat.o(54601);
        return w;
    }

    public final b dMC() {
        AppMethodBeat.i(54602);
        Uri dMB = dMB();
        if (dMB == null) {
            AppMethodBeat.o(54602);
            return null;
        }
        b bVar = new b(dMB);
        AppMethodBeat.o(54602);
        return bVar;
    }

    public final boolean canRead() {
        AppMethodBeat.i(54603);
        d dMA = dMA();
        if (dMA.valid()) {
            FileSystem fileSystem = dMA.zZs;
            String O = fileSystem.O(dMA.path, false);
            boolean canRead;
            if (O != null) {
                canRead = new File(O).canRead();
                AppMethodBeat.o(54603);
                return canRead;
            }
            canRead = fileSystem.exists(dMA.path);
            AppMethodBeat.o(54603);
            return canRead;
        }
        AppMethodBeat.o(54603);
        return false;
    }

    public final boolean exists() {
        AppMethodBeat.i(54604);
        d dMA = dMA();
        if (dMA.valid()) {
            boolean exists = dMA.zZs.exists(dMA.path);
            AppMethodBeat.o(54604);
            return exists;
        }
        AppMethodBeat.o(54604);
        return false;
    }

    public final String getAbsolutePath() {
        AppMethodBeat.i(138985);
        String w = j.w(dMD());
        AppMethodBeat.o(138985);
        return w;
    }

    public final b dME() {
        AppMethodBeat.i(54607);
        b bVar = new b(dMD());
        AppMethodBeat.o(54607);
        return bVar;
    }

    public final boolean isDirectory() {
        AppMethodBeat.i(54608);
        d dMA = dMA();
        if (dMA.valid()) {
            a to = dMA.zZs.to(dMA.path);
            if (to == null || !to.zYN) {
                AppMethodBeat.o(54608);
                return false;
            }
            AppMethodBeat.o(54608);
            return true;
        }
        AppMethodBeat.o(54608);
        return false;
    }

    public final boolean isFile() {
        AppMethodBeat.i(54609);
        d dMA = dMA();
        if (dMA.valid()) {
            a to = dMA.zZs.to(dMA.path);
            if (to == null || to.zYN) {
                AppMethodBeat.o(54609);
                return false;
            }
            AppMethodBeat.o(54609);
            return true;
        }
        AppMethodBeat.o(54609);
        return false;
    }

    public final long lastModified() {
        AppMethodBeat.i(54610);
        d dMA = dMA();
        if (dMA.valid()) {
            a to = dMA.zZs.to(dMA.path);
            if (to == null) {
                AppMethodBeat.o(54610);
                return 0;
            }
            long j = to.zYM;
            AppMethodBeat.o(54610);
            return j;
        }
        AppMethodBeat.o(54610);
        return 0;
    }

    public final long length() {
        AppMethodBeat.i(54611);
        d dMA = dMA();
        if (dMA.valid()) {
            a to = dMA.zZs.to(dMA.path);
            if (to == null) {
                AppMethodBeat.o(54611);
                return 0;
            }
            long j = to.size;
            AppMethodBeat.o(54611);
            return j;
        }
        AppMethodBeat.o(54611);
        return 0;
    }

    public final String[] list() {
        AppMethodBeat.i(54612);
        d dMA = dMA();
        if (dMA.valid()) {
            List<a> M = dMA.zZs.M(dMA.path, false);
            if (M == null) {
                AppMethodBeat.o(54612);
                return null;
            }
            String[] strArr = new String[M.size()];
            int i = 0;
            for (a aVar : M) {
                int i2 = i + 1;
                strArr[i] = aVar.name;
                i = i2;
            }
            AppMethodBeat.o(54612);
            return strArr;
        }
        AppMethodBeat.o(54612);
        return null;
    }

    public final String[] a(i iVar) {
        AppMethodBeat.i(54613);
        d dMA = dMA();
        if (dMA.valid()) {
            List<a> M = dMA.zZs.M(dMA.path, false);
            if (M == null) {
                AppMethodBeat.o(54613);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (a aVar : M) {
                if (iVar.ml(aVar.name)) {
                    arrayList.add(aVar.name);
                }
            }
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            AppMethodBeat.o(54613);
            return strArr;
        }
        AppMethodBeat.o(54613);
        return null;
    }

    public final b[] dMF() {
        AppMethodBeat.i(54614);
        d dMA = dMA();
        if (dMA.valid()) {
            List<a> M = dMA.zZs.M(dMA.path, false);
            if (M == null) {
                AppMethodBeat.o(54614);
                return null;
            }
            b[] bVarArr = new b[M.size()];
            int i = 0;
            for (a aVar : M) {
                int i2 = i + 1;
                bVarArr[i] = new b(this, aVar.name);
                i = i2;
            }
            AppMethodBeat.o(54614);
            return bVarArr;
        }
        AppMethodBeat.o(54614);
        return null;
    }

    public final b[] a(c cVar) {
        AppMethodBeat.i(54615);
        d dMA = dMA();
        if (dMA.valid()) {
            List<a> M = dMA.zZs.M(dMA.path, false);
            if (M == null) {
                AppMethodBeat.o(54615);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (a aVar : M) {
                b bVar = new b(this, aVar.name);
                if (cVar.f(bVar)) {
                    arrayList.add(bVar);
                }
            }
            b[] bVarArr = (b[]) arrayList.toArray(new b[arrayList.size()]);
            AppMethodBeat.o(54615);
            return bVarArr;
        }
        AppMethodBeat.o(54615);
        return null;
    }

    public final boolean mkdirs() {
        AppMethodBeat.i(54616);
        d dMA = dMA();
        if (dMA.valid()) {
            boolean tf = dMA.zZs.tf(dMA.path);
            AppMethodBeat.o(54616);
            return tf;
        }
        AppMethodBeat.o(54616);
        return false;
    }

    public final boolean createNewFile() {
        AppMethodBeat.i(54617);
        d dMA = dMA();
        if (!dMA.valid()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: " + this.mUri);
            AppMethodBeat.o(54617);
            throw fileNotFoundException;
        } else if (dMA.zZs.exists(dMA.path)) {
            AppMethodBeat.o(54617);
            return false;
        } else {
            dMA.zZs.L(dMA.path, true).close();
            AppMethodBeat.o(54617);
            return true;
        }
    }

    public final boolean o(b bVar) {
        AppMethodBeat.i(54618);
        d dMA = dMA();
        d dMA2 = bVar.dMA();
        if (!dMA.valid() || !dMA2.valid()) {
            AppMethodBeat.o(54618);
            return false;
        } else if (dMA.zZs != dMA2.zZs) {
            AppMethodBeat.o(54618);
            return false;
        } else {
            boolean aS = dMA.zZs.aS(dMA.path, dMA2.path);
            AppMethodBeat.o(54618);
            return aS;
        }
    }

    public final boolean delete() {
        AppMethodBeat.i(54619);
        d dMA = dMA();
        if (dMA.valid() && dMA.zZs.pI(dMA.path)) {
            AppMethodBeat.o(54619);
            return true;
        }
        AppMethodBeat.o(54619);
        return false;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(54621);
        if (obj instanceof b) {
            boolean equals = this.mUri.equals(((b) obj).mUri);
            AppMethodBeat.o(54621);
            return equals;
        }
        AppMethodBeat.o(54621);
        return false;
    }

    public final Uri dMD() {
        int i = 0;
        AppMethodBeat.i(54605);
        String path = this.mUri.getPath();
        if (this.mUri.isAbsolute() || (path.length() > 0 && path.charAt(0) == IOUtils.DIR_SEPARATOR_UNIX)) {
            i = 1;
        }
        Uri uri;
        if (i != 0) {
            uri = this.mUri;
            AppMethodBeat.o(54605);
            return uri;
        }
        path = this.mUri.getPath();
        String property = System.getProperty("user.dir");
        if (!path.isEmpty()) {
            property = property + IOUtils.DIR_SEPARATOR_UNIX + path;
        }
        uri = this.mUri.buildUpon().path(property).build();
        AppMethodBeat.o(54605);
        return uri;
    }

    public final int hashCode() {
        AppMethodBeat.i(54620);
        int hashCode = j.w(this.mUri).hashCode() ^ 1234321;
        AppMethodBeat.o(54620);
        return hashCode;
    }
}
