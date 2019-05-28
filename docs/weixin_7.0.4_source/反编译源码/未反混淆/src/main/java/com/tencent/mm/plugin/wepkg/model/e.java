package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.d.b;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.o;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
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

    public e(File file) {
        boolean z = false;
        AppMethodBeat.i(63525);
        this.gUc = file;
        if (avX()) {
            z = true;
        }
        this.gUe = z;
        AppMethodBeat.o(63525);
    }

    public final o hy(String str, String str2) {
        AppMethodBeat.i(63526);
        if (bo.ek(this.uWW) || this.uWU < uWR || bo.isNullOrNil(str)) {
            ab.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
            AppMethodBeat.o(63526);
            return null;
        }
        Iterator it = this.uWW.iterator();
        while (it.hasNext()) {
            acc acc = (acc) it.next();
            if (bo.nullAsNil(acc.wjQ).equals(str)) {
                Object obj;
                String str3 = acc.wjS;
                if (bo.isNullOrNil(str3) || !(str3.startsWith("video/") || str3.startsWith("audio/"))) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    ab.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", str);
                    AppMethodBeat.o(63526);
                    return null;
                } else if (((long) acc.jCo) <= 5242880) {
                    try {
                        ab.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", str);
                        o oVar = new o(acc.wjS, str2, new b(this.gUc, ((long) this.uWU) + acc.wjR, (long) acc.jCo));
                        AppMethodBeat.o(63526);
                        return oVar;
                    } catch (IOException e) {
                        ab.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", str, Long.valueOf(acc.wjR), Integer.valueOf(acc.jCo), acc.wjS, e.getMessage());
                    }
                } else {
                    ab.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", Integer.valueOf(acc.jCo), Long.valueOf(5242880), str, Long.valueOf(acc.wjR), acc.wjS);
                }
            }
        }
        AppMethodBeat.o(63526);
        return null;
    }

    private boolean avX() {
        boolean z = false;
        AppMethodBeat.i(63527);
        FileChannel fileChannel = null;
        try {
            fileChannel = new RandomAccessFile(this.gUc, "r").getChannel();
        } catch (Exception e) {
            ab.e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + e.getMessage());
        }
        if (fileChannel == null) {
            AppMethodBeat.o(63527);
        } else {
            try {
                fileChannel.position(0);
                ByteBuffer allocate = ByteBuffer.allocate(uWR);
                allocate.order(uWS);
                fileChannel.read(allocate);
                this.uWT = allocate.getInt(0);
                z = a(fileChannel);
            } catch (Exception e2) {
                ab.e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + e2.getMessage());
            } finally {
                b(fileChannel);
                AppMethodBeat.o(63527);
            }
        }
        return z;
    }

    private boolean a(FileChannel fileChannel) {
        AppMethodBeat.i(63528);
        if (this.uWT <= 0) {
            AppMethodBeat.o(63528);
            return false;
        }
        try {
            fileChannel.position((long) uWR);
            ByteBuffer allocate = ByteBuffer.allocate(this.uWT);
            allocate.order(uWS);
            fileChannel.read(allocate);
            byte[] array = allocate.array();
            if (array == null || array.length == 0) {
                AppMethodBeat.o(63528);
                return false;
            }
            this.uWV = new cte();
            this.uWV.parseFrom(array);
            this.uWW = this.uWV.xqk;
            this.uWX = this.uWV.xql;
            this.eeO = this.uWV.Desc;
            this.uWU = uWR + this.uWT;
            AppMethodBeat.o(63528);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + e.getMessage());
            AppMethodBeat.o(63528);
            return false;
        }
    }

    private static void b(FileChannel fileChannel) {
        AppMethodBeat.i(63529);
        if (fileChannel != null) {
            try {
                fileChannel.close();
                AppMethodBeat.o(63529);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(63529);
    }
}
