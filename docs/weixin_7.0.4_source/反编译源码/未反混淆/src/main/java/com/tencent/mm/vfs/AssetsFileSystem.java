package com.tencent.mm.vfs;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.FileSystem.b;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

final class AssetsFileSystem extends AbstractFileSystem {
    public static final Creator<AssetsFileSystem> CREATOR = null;
    private AssetManager zYA;

    AssetsFileSystem(Context context) {
        AppMethodBeat.i(54474);
        this.zYA = context.getAssets();
        AppMethodBeat.o(54474);
    }

    public final int aiR() {
        return 40;
    }

    public final b tn(String str) {
        AppMethodBeat.i(54475);
        b bVar = new b();
        AppMethodBeat.o(54475);
        return bVar;
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.i(54476);
        InputStream open = this.zYA.open(str);
        AppMethodBeat.o(54476);
        return open;
    }

    public final OutputStream L(String str, boolean z) {
        AppMethodBeat.i(54477);
        IOException iOException = new IOException("Cannot open files for writing on read-only file systems");
        AppMethodBeat.o(54477);
        throw iOException;
    }

    public final boolean exists(String str) {
        AppMethodBeat.i(54478);
        try {
            openRead(str).close();
            AppMethodBeat.o(54478);
            return true;
        } catch (IOException e) {
            AppMethodBeat.o(54478);
            return false;
        }
    }

    public final a to(String str) {
        AppMethodBeat.i(54479);
        try {
            InputStream openRead = openRead(str);
            int available = openRead.available();
            openRead.close();
            int lastIndexOf = str.lastIndexOf(47);
            a aVar = new a(this, str, lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1), (long) available, 0, 0, false);
            AppMethodBeat.o(54479);
            return aVar;
        } catch (IOException e) {
            AppMethodBeat.o(54479);
            return null;
        }
    }

    public final boolean t(String str, long j) {
        return false;
    }

    public final boolean pI(String str) {
        return false;
    }

    private void b(String str, String str2, ArrayList<a> arrayList) {
        String str3;
        AppMethodBeat.i(54480);
        if (str2 == null || str2.isEmpty()) {
            str3 = str;
        } else {
            str3 = str + IOUtils.DIR_SEPARATOR_UNIX + str2;
        }
        String[] list = this.zYA.list(str3);
        if (list != null && list.length != 0) {
            if (str2 != null) {
                arrayList.add(new a(this, str3, str2, 0, 0, 0, true));
            }
            for (String str4 : list) {
                if (!(str4 == null || str4.isEmpty())) {
                    b(str3, str4, arrayList);
                }
            }
        } else if (str2 != null) {
            arrayList.add(new a(this, str3, str2, 0, 0, 0, false));
            AppMethodBeat.o(54480);
            return;
        }
        AppMethodBeat.o(54480);
    }

    public final List<a> M(String str, boolean z) {
        AppMethodBeat.i(54481);
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        if (z) {
            try {
                ArrayList arrayList = new ArrayList();
                b(str, null, arrayList);
                AppMethodBeat.o(54481);
                return arrayList;
            } catch (IOException e) {
                AppMethodBeat.o(54481);
                return null;
            }
        }
        String[] list = this.zYA.list(str);
        if (list == null) {
            AppMethodBeat.o(54481);
            return null;
        }
        String str2 = str + IOUtils.DIR_SEPARATOR_UNIX;
        ArrayList arrayList2 = new ArrayList(list.length);
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < length) {
                String str3 = list[i2];
                String str4 = str2 + str3;
                String[] list2 = this.zYA.list(str4);
                boolean z2 = list2 != null && list2.length > 0;
                arrayList2.add(new a(this, str4, str3, 0, 0, 0, z2));
                i = i2 + 1;
            } else {
                AppMethodBeat.o(54481);
                return arrayList2;
            }
        }
    }

    public final boolean tf(String str) {
        return false;
    }

    public final boolean N(String str, boolean z) {
        return false;
    }

    public final boolean aS(String str, String str2) {
        return false;
    }

    public final String O(String str, boolean z) {
        return null;
    }

    public final String toString() {
        return "AssetsFS";
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(54482);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(54482);
        throw unsupportedOperationException;
    }
}
