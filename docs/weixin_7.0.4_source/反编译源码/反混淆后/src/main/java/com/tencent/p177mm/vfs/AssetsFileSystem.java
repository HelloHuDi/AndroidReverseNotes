package com.tencent.p177mm.vfs;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import com.tencent.p177mm.vfs.FileSystem.C5713b;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.vfs.AssetsFileSystem */
final class AssetsFileSystem extends AbstractFileSystem {
    public static final Creator<AssetsFileSystem> CREATOR = null;
    private AssetManager zYA;

    AssetsFileSystem(Context context) {
        AppMethodBeat.m2504i(54474);
        this.zYA = context.getAssets();
        AppMethodBeat.m2505o(54474);
    }

    public final int aiR() {
        return 40;
    }

    /* renamed from: tn */
    public final C5713b mo11620tn(String str) {
        AppMethodBeat.m2504i(54475);
        C5713b c5713b = new C5713b();
        AppMethodBeat.m2505o(54475);
        return c5713b;
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.m2504i(54476);
        InputStream open = this.zYA.open(str);
        AppMethodBeat.m2505o(54476);
        return open;
    }

    /* renamed from: L */
    public final OutputStream mo11607L(String str, boolean z) {
        AppMethodBeat.m2504i(54477);
        IOException iOException = new IOException("Cannot open files for writing on read-only file systems");
        AppMethodBeat.m2505o(54477);
        throw iOException;
    }

    public final boolean exists(String str) {
        AppMethodBeat.m2504i(54478);
        try {
            openRead(str).close();
            AppMethodBeat.m2505o(54478);
            return true;
        } catch (IOException e) {
            AppMethodBeat.m2505o(54478);
            return false;
        }
    }

    /* renamed from: to */
    public final C5712a mo11621to(String str) {
        AppMethodBeat.m2504i(54479);
        try {
            InputStream openRead = openRead(str);
            int available = openRead.available();
            openRead.close();
            int lastIndexOf = str.lastIndexOf(47);
            C5712a c5712a = new C5712a(this, str, lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1), (long) available, 0, 0, false);
            AppMethodBeat.m2505o(54479);
            return c5712a;
        } catch (IOException e) {
            AppMethodBeat.m2505o(54479);
            return null;
        }
    }

    /* renamed from: t */
    public final boolean mo11618t(String str, long j) {
        return false;
    }

    /* renamed from: pI */
    public final boolean mo11617pI(String str) {
        return false;
    }

    /* renamed from: b */
    private void m13446b(String str, String str2, ArrayList<C5712a> arrayList) {
        String str3;
        AppMethodBeat.m2504i(54480);
        if (str2 == null || str2.isEmpty()) {
            str3 = str;
        } else {
            str3 = str + IOUtils.DIR_SEPARATOR_UNIX + str2;
        }
        String[] list = this.zYA.list(str3);
        if (list != null && list.length != 0) {
            if (str2 != null) {
                arrayList.add(new C5712a(this, str3, str2, 0, 0, 0, true));
            }
            for (String str4 : list) {
                if (!(str4 == null || str4.isEmpty())) {
                    m13446b(str3, str4, arrayList);
                }
            }
        } else if (str2 != null) {
            arrayList.add(new C5712a(this, str3, str2, 0, 0, 0, false));
            AppMethodBeat.m2505o(54480);
            return;
        }
        AppMethodBeat.m2505o(54480);
    }

    /* renamed from: M */
    public final List<C5712a> mo11608M(String str, boolean z) {
        AppMethodBeat.m2504i(54481);
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        if (z) {
            try {
                ArrayList arrayList = new ArrayList();
                m13446b(str, null, arrayList);
                AppMethodBeat.m2505o(54481);
                return arrayList;
            } catch (IOException e) {
                AppMethodBeat.m2505o(54481);
                return null;
            }
        }
        String[] list = this.zYA.list(str);
        if (list == null) {
            AppMethodBeat.m2505o(54481);
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
                arrayList2.add(new C5712a(this, str4, str3, 0, 0, 0, z2));
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(54481);
                return arrayList2;
            }
        }
    }

    /* renamed from: tf */
    public final boolean mo11619tf(String str) {
        return false;
    }

    /* renamed from: N */
    public final boolean mo11609N(String str, boolean z) {
        return false;
    }

    /* renamed from: aS */
    public final boolean mo11612aS(String str, String str2) {
        return false;
    }

    /* renamed from: O */
    public final String mo11610O(String str, boolean z) {
        return null;
    }

    public final String toString() {
        return "AssetsFS";
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(54482);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.m2505o(54482);
        throw unsupportedOperationException;
    }
}
