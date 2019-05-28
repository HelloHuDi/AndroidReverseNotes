package com.tencent.p177mm.plugin.downloader.p376d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p209c.C41916k;
import com.tencent.p177mm.p209c.C45276l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.plugin.downloader.d.j */
public final class C11508j {
    private static final C41916k cdq = new C41916k(101010256);

    static {
        AppMethodBeat.m2504i(2333);
        AppMethodBeat.m2505o(2333);
    }

    /* renamed from: Im */
    public static byte[] m19312Im(String str) {
        AppMethodBeat.m2504i(2332);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(2332);
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        if (randomAccessFile.length() == 0) {
            randomAccessFile.close();
            C4990ab.m7416i("MicroMsg.Channel.ZipEocdCommentTool", "apk file length is zero");
            AppMethodBeat.m2505o(2332);
            return null;
        }
        byte[] bArr;
        try {
            File file = new File(str);
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            randomAccessFile2.seek((((Long) C45830h.m84823N(file).second).longValue() + 22) - 2);
            bArr = new byte[2];
            randomAccessFile2.readFully(bArr);
            int i = new C45276l(bArr).value;
            if (i == 0) {
                bArr = null;
            } else {
                bArr = new byte[i];
                randomAccessFile2.read(bArr);
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Channel.ZipEocdCommentTool", "readComment, error: %s", e.getMessage());
            bArr = null;
        }
        randomAccessFile.close();
        AppMethodBeat.m2505o(2332);
        return bArr;
    }
}
