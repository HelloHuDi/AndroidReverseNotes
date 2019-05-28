package com.tencent.p177mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wepkg.p1567d.C46471b;
import com.tencent.p177mm.protocal.protobuf.acc;
import com.tencent.p177mm.protocal.protobuf.cte;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C31147o;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.wepkg.model.e */
public final class C46475e {
    private static int uWR = 4;
    private static ByteOrder uWS = ByteOrder.BIG_ENDIAN;
    private volatile String eeO = "";
    private File gUc;
    volatile boolean gUe = false;
    private volatile int uWT;
    private volatile int uWU = 0;
    volatile cte uWV = null;
    private volatile LinkedList<acc> uWW = null;
    private volatile String uWX = "";

    public C46475e(File file) {
        boolean z = false;
        AppMethodBeat.m2504i(63525);
        this.gUc = file;
        if (avX()) {
            z = true;
        }
        this.gUe = z;
        AppMethodBeat.m2505o(63525);
    }

    /* renamed from: hy */
    public final C31147o mo74704hy(String str, String str2) {
        AppMethodBeat.m2504i(63526);
        if (C5046bo.m7548ek(this.uWW) || this.uWU < uWR || C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
            AppMethodBeat.m2505o(63526);
            return null;
        }
        Iterator it = this.uWW.iterator();
        while (it.hasNext()) {
            acc acc = (acc) it.next();
            if (C5046bo.nullAsNil(acc.wjQ).equals(str)) {
                Object obj;
                String str3 = acc.wjS;
                if (C5046bo.isNullOrNil(str3) || !(str3.startsWith("video/") || str3.startsWith("audio/"))) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    C4990ab.m7417i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", str);
                    AppMethodBeat.m2505o(63526);
                    return null;
                } else if (((long) acc.jCo) <= 5242880) {
                    try {
                        C4990ab.m7417i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", str);
                        C31147o c31147o = new C31147o(acc.wjS, str2, new C46471b(this.gUc, ((long) this.uWU) + acc.wjR, (long) acc.jCo));
                        AppMethodBeat.m2505o(63526);
                        return c31147o;
                    } catch (IOException e) {
                        C4990ab.m7413e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", str, Long.valueOf(acc.wjR), Integer.valueOf(acc.jCo), acc.wjS, e.getMessage());
                    }
                } else {
                    C4990ab.m7417i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", Integer.valueOf(acc.jCo), Long.valueOf(5242880), str, Long.valueOf(acc.wjR), acc.wjS);
                }
            }
        }
        AppMethodBeat.m2505o(63526);
        return null;
    }

    private boolean avX() {
        boolean z = false;
        AppMethodBeat.m2504i(63527);
        FileChannel fileChannel = null;
        try {
            fileChannel = new RandomAccessFile(this.gUc, "r").getChannel();
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + e.getMessage());
        }
        if (fileChannel == null) {
            AppMethodBeat.m2505o(63527);
        } else {
            try {
                fileChannel.position(0);
                ByteBuffer allocate = ByteBuffer.allocate(uWR);
                allocate.order(uWS);
                fileChannel.read(allocate);
                this.uWT = allocate.getInt(0);
                z = m87667a(fileChannel);
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + e2.getMessage());
            } finally {
                C46475e.m87668b(fileChannel);
                AppMethodBeat.m2505o(63527);
            }
        }
        return z;
    }

    /* renamed from: a */
    private boolean m87667a(FileChannel fileChannel) {
        AppMethodBeat.m2504i(63528);
        if (this.uWT <= 0) {
            AppMethodBeat.m2505o(63528);
            return false;
        }
        try {
            fileChannel.position((long) uWR);
            ByteBuffer allocate = ByteBuffer.allocate(this.uWT);
            allocate.order(uWS);
            fileChannel.read(allocate);
            byte[] array = allocate.array();
            if (array == null || array.length == 0) {
                AppMethodBeat.m2505o(63528);
                return false;
            }
            this.uWV = new cte();
            this.uWV.parseFrom(array);
            this.uWW = this.uWV.xqk;
            this.uWX = this.uWV.xql;
            this.eeO = this.uWV.Desc;
            this.uWU = uWR + this.uWT;
            AppMethodBeat.m2505o(63528);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + e.getMessage());
            AppMethodBeat.m2505o(63528);
            return false;
        }
    }

    /* renamed from: b */
    private static void m87668b(FileChannel fileChannel) {
        AppMethodBeat.m2504i(63529);
        if (fileChannel != null) {
            try {
                fileChannel.close();
                AppMethodBeat.m2505o(63529);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(63529);
    }
}
