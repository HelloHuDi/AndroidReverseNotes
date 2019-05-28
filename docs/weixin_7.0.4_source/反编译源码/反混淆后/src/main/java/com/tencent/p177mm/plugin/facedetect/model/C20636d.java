package com.tencent.p177mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C18601a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.facedetect.model.d */
public final class C20636d {
    private static volatile C20636d lTB = null;
    public static final Object mLock = new Object();
    public List<C20635a> lTC = null;

    /* renamed from: com.tencent.mm.plugin.facedetect.model.d$a */
    class C20635a {
        byte[] data;
        C20637b lTD;

        C20635a(C20637b c20637b) {
            this.lTD = c20637b;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.model.d$b */
    public interface C20637b {
        /* renamed from: aT */
        void mo7298aT(byte[] bArr);

        C18601a<byte[]> bsr();
    }

    static {
        AppMethodBeat.m2504i(ErrorCode.NEEDDOWNLOAD_FALSE_6);
        AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_FALSE_6);
    }

    public static final C20636d bsq() {
        AppMethodBeat.m2504i(ErrorCode.NEEDDOWNLOAD_FALSE_2);
        C20636d c20636d;
        if (lTB == null) {
            synchronized (mLock) {
                try {
                    if (lTB == null) {
                        lTB = new C20636d();
                    }
                    c20636d = lTB;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_FALSE_2);
                }
            }
            return c20636d;
        }
        c20636d = lTB;
        AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_FALSE_2);
        return c20636d;
    }

    /* renamed from: a */
    public final synchronized void mo35921a(C20637b c20637b) {
        AppMethodBeat.m2504i(ErrorCode.NEEDDOWNLOAD_FALSE_3);
        if (c20637b == null) {
            C4990ab.m7420w("MicroMsg.FaceCameraDataCallbackHolder", "hy: invalid callbacker");
            AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_FALSE_3);
        } else {
            Object obj = mLock;
            synchronized (obj) {
                try {
                    if (this.lTC == null) {
                    }
                    this.lTC.add(new C20635a(c20637b));
                    AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_FALSE_3);
                } finally {
                    while (true) {
                    }
                    int obj2 = ErrorCode.NEEDDOWNLOAD_FALSE_3;
                    AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_FALSE_3);
                }
            }
        }
    }

    /* renamed from: aS */
    public final void mo35922aS(byte[] bArr) {
        AppMethodBeat.m2504i(ErrorCode.NEEDDOWNLOAD_FALSE_4);
        synchronized (mLock) {
            try {
                C4990ab.m7418v("MicroMsg.FaceCameraDataCallbackHolder", "hy: publish data:".concat(String.valueOf(bArr)));
                if (this.lTC == null || this.lTC.size() == 0) {
                    C4990ab.m7420w("MicroMsg.FaceCameraDataCallbackHolder", "hy: nothing's listening to preview data");
                } else {
                    if (bArr != null) {
                        if (bArr.length != 0) {
                            for (C20635a c20635a : this.lTC) {
                                int length = bArr.length;
                                c20635a.data = (byte[]) c20635a.lTD.bsr().mo33852d(Integer.valueOf(length));
                                System.arraycopy(bArr, 0, c20635a.data, 0, length);
                                c20635a.lTD.mo7298aT(c20635a.data);
                            }
                            AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_FALSE_4);
                            return;
                        }
                    }
                    C4990ab.m7420w("MicroMsg.FaceCameraDataCallbackHolder", "hy: null camera data got");
                    AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_FALSE_4);
                }
            } finally {
                AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_FALSE_4);
            }
        }
    }

    /* renamed from: b */
    public final void mo35923b(C20637b c20637b) {
        AppMethodBeat.m2504i(ErrorCode.NEEDDOWNLOAD_FALSE_5);
        synchronized (mLock) {
            try {
                if (this.lTC != null) {
                    this.lTC.remove(c20637b);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_FALSE_5);
            }
        }
    }
}
