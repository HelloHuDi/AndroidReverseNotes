package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.List;

public final class d {
    private static volatile d lTB = null;
    public static final Object mLock = new Object();
    public List<a> lTC = null;

    class a {
        byte[] data;
        b lTD;

        a(b bVar) {
            this.lTD = bVar;
        }
    }

    public interface b {
        void aT(byte[] bArr);

        com.tencent.mm.memory.a<byte[]> bsr();
    }

    static {
        AppMethodBeat.i(ErrorCode.NEEDDOWNLOAD_FALSE_6);
        AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_FALSE_6);
    }

    public static final d bsq() {
        AppMethodBeat.i(ErrorCode.NEEDDOWNLOAD_FALSE_2);
        d dVar;
        if (lTB == null) {
            synchronized (mLock) {
                try {
                    if (lTB == null) {
                        lTB = new d();
                    }
                    dVar = lTB;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_FALSE_2);
                }
            }
            return dVar;
        }
        dVar = lTB;
        AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_FALSE_2);
        return dVar;
    }

    public final synchronized void a(b bVar) {
        AppMethodBeat.i(ErrorCode.NEEDDOWNLOAD_FALSE_3);
        if (bVar == null) {
            ab.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: invalid callbacker");
            AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_FALSE_3);
        } else {
            Object obj = mLock;
            synchronized (obj) {
                try {
                    if (this.lTC == null) {
                    }
                    this.lTC.add(new a(bVar));
                    AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_FALSE_3);
                } finally {
                    while (true) {
                    }
                    int obj2 = ErrorCode.NEEDDOWNLOAD_FALSE_3;
                    AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_FALSE_3);
                }
            }
        }
    }

    public final void aS(byte[] bArr) {
        AppMethodBeat.i(ErrorCode.NEEDDOWNLOAD_FALSE_4);
        synchronized (mLock) {
            try {
                ab.v("MicroMsg.FaceCameraDataCallbackHolder", "hy: publish data:".concat(String.valueOf(bArr)));
                if (this.lTC == null || this.lTC.size() == 0) {
                    ab.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: nothing's listening to preview data");
                } else {
                    if (bArr != null) {
                        if (bArr.length != 0) {
                            for (a aVar : this.lTC) {
                                int length = bArr.length;
                                aVar.data = (byte[]) aVar.lTD.bsr().d(Integer.valueOf(length));
                                System.arraycopy(bArr, 0, aVar.data, 0, length);
                                aVar.lTD.aT(aVar.data);
                            }
                            AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_FALSE_4);
                            return;
                        }
                    }
                    ab.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: null camera data got");
                    AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_FALSE_4);
                }
            } finally {
                AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_FALSE_4);
            }
        }
    }

    public final void b(b bVar) {
        AppMethodBeat.i(ErrorCode.NEEDDOWNLOAD_FALSE_5);
        synchronized (mLock) {
            try {
                if (this.lTC != null) {
                    this.lTC.remove(bVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_FALSE_5);
            }
        }
    }
}
