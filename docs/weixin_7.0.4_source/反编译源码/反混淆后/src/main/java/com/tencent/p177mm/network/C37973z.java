package com.tencent.p177mm.network;

import android.os.RemoteException;
import com.tencent.mars.p150mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1930r.C1931a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19281ab;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19482c;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.C4819i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.network.z */
public final class C37973z {
    final C9765a[] gdP = new C9765a[100];

    /* renamed from: com.tencent.mm.network.z$a */
    static class C9765a {
        C1930r gdT;
        C1919l gdU;
        C1898c gdV;
        long startTime;
        int taskId;

        private C9765a() {
        }

        /* synthetic */ C9765a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.network.z$1 */
    class C379721 implements Runnable {
        final /* synthetic */ int gdQ;
        final /* synthetic */ int gdR;

        C379721(int i, int i2) {
            this.gdQ = i;
            this.gdR = i2;
        }

        public final void run() {
            AppMethodBeat.m2504i(58644);
            MMLogic.reportCGIServerError(this.gdQ, this.gdR);
            AppMethodBeat.m2505o(58644);
        }
    }

    public C37973z() {
        AppMethodBeat.m2504i(58645);
        AppMethodBeat.m2505o(58645);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(58646);
        reset();
        super.finalize();
        AppMethodBeat.m2505o(58646);
    }

    /* Access modifiers changed, original: final */
    public final boolean anc() {
        AppMethodBeat.m2504i(58647);
        synchronized (this.gdP) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.gdP[i] != null && (252 == this.gdP[i].gdT.getType() || 701 == this.gdP[i].gdT.getType() || 702 == this.gdP[i].gdT.getType() || 763 == this.gdP[i].gdT.getType())) {
                        C4990ab.m7420w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.gdP[i].gdT.getType());
                        AppMethodBeat.m2505o(58647);
                        return true;
                    }
                } catch (RemoteException e) {
                    this.gdP[i] = null;
                    C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", C5046bo.m7574l(e), Integer.valueOf(i));
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(58647);
                    }
                }
                i++;
            }
            AppMethodBeat.m2505o(58647);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean and() {
        AppMethodBeat.m2504i(58648);
        synchronized (this.gdP) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.gdP[i] != null && 1000 == this.gdP[i].gdT.getType()) {
                        C4990ab.m7420w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.gdP[i].gdT.getType());
                        AppMethodBeat.m2505o(58648);
                        return true;
                    }
                } catch (RemoteException e) {
                    this.gdP[i] = null;
                    C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", C5046bo.m7574l(e), Integer.valueOf(i));
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(58648);
                    }
                }
                i++;
            }
            AppMethodBeat.m2505o(58648);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: de */
    public final C1930r mo60743de(boolean z) {
        AppMethodBeat.m2504i(58649);
        synchronized (this.gdP) {
            int i = 0;
            C1930r c1930r = null;
            while (i < 100) {
                try {
                    if (this.gdP[i] != null) {
                        if (z) {
                            if (this.gdP[i].gdT instanceof C1931a) {
                                continue;
                            }
                        }
                        if (z || (this.gdP[i].gdT instanceof C1931a)) {
                            if (252 == this.gdP[i].gdT.getType() || 701 == this.gdP[i].gdT.getType() || 763 == this.gdP[i].gdT.getType() || 702 == this.gdP[i].gdT.getType()) {
                                C4990ab.m7412e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.gdP[i].gdT.getType());
                                AppMethodBeat.m2505o(58649);
                                return null;
                            } else if (c1930r == null) {
                                c1930r = this.gdP[i].gdT;
                            }
                        }
                    }
                } catch (RemoteException e) {
                    C4990ab.m7421w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", C5046bo.m7574l(e));
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(58649);
                }
                i++;
            }
            AppMethodBeat.m2505o(58649);
            return c1930r;
        }
    }

    public final int ane() {
        AppMethodBeat.m2504i(58650);
        int i = 0;
        for (int i2 = 0; i2 < 100; i2++) {
            try {
                if (this.gdP[i2] != null) {
                    this.gdP[i2].gdT.getType();
                }
            } catch (RemoteException e) {
                C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", C5046bo.m7574l(e), Integer.valueOf(i2));
                i++;
                this.gdP[i2] = null;
            }
        }
        AppMethodBeat.m2505o(58650);
        return i;
    }

    /* renamed from: mB */
    static boolean m64251mB(int i) {
        if (i == 10 || i == 268369922) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final int mo60738a(C1930r c1930r, C1919l c1919l, C1898c c1898c, int i) {
        AppMethodBeat.m2504i(58651);
        if (c1930r == null) {
            C4990ab.m7412e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
            AppMethodBeat.m2505o(58651);
            return -1;
        }
        int acB;
        c1930r.hashCode();
        Task task = new Task();
        synchronized (this.gdP) {
            int i2 = 0;
            while (i2 < 100) {
                try {
                    if (this.gdP[i2] == null) {
                        this.gdP[i2] = new C9765a();
                        this.gdP[i2].gdT = c1930r;
                        this.gdP[i2].gdU = c1919l;
                        this.gdP[i2].gdV = c1898c;
                        this.gdP[i2].startTime = C5046bo.anU();
                        this.gdP[i2].taskId = task.taskID;
                        task.cmdID = c1930r.adt().getCmdId();
                        task.cgi = c1930r.getUri();
                        int type = c1930r.getType();
                        task.needAuthed = (c1930r.acC() & 1) != 1;
                        if (type == 126 || type == 252 || type == 701 || type == 702 || type == 763) {
                            task.needAuthed = false;
                            if (type == 701 || type == 252) {
                                task.retryCount = 1;
                            }
                        }
                        task.limitFlow = true;
                        if (type == 149 || type == JsApiChooseMedia.CTRL_INDEX || type == 220 || type == 323 || type == C19281ab.CTRL_INDEX || type == ErrorCode.TEST_THROWABLE_IS_NULL || type == ErrorCode.TEST_THROWABLE_ISNOT_NULL || type == 703) {
                            task.limitFlow = false;
                        }
                        if (type == 703) {
                            task.limitFrequency = false;
                        }
                        task.channelStrategy = 0;
                        if (type == C31128d.MIC_PTU_MEISHI || type == 835 || type == C31128d.MIC_PTU_SHIGUANG) {
                            task.channelStrategy = 1;
                        }
                        task.sendOnly = false;
                        if (C37973z.m64251mB(type)) {
                            task.sendOnly = true;
                        }
                        if (c1930r.adt().adr() && c1930r.getUri() != null && c1930r.getUri().length() > 0) {
                            task.channelSelect |= 1;
                        }
                        if (task.cmdID != 0) {
                            task.channelSelect |= 2;
                        }
                        task.reportArg = String.valueOf(type);
                        if (type == C19482c.CTRL_INDEX) {
                            task.totalTimeout = 300000;
                            task.priority = 0;
                        }
                        if (type == 710) {
                            task.totalTimeout = 15000;
                            task.serverProcessCost = 0;
                        }
                        if (type == 2632) {
                            acB = c1930r.acB();
                            if (acB != 0) {
                                task.totalTimeout = acB;
                            }
                        }
                        C4990ab.m7417i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", Integer.valueOf(i2), Integer.valueOf(task.taskID), Integer.valueOf(c1930r.acO()), Integer.valueOf(task.channelSelect), task.cgi, Boolean.valueOf(task.needAuthed));
                        acB = i2;
                    } else {
                        i2++;
                    }
                } catch (RemoteException e) {
                    C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", C5046bo.m7574l(e));
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(58651);
                }
            }
            acB = -1;
        }
        if (-1 != acB) {
            if (i == 1) {
                task.retryCount = 0;
            }
            StnLogic.startTask(task);
        } else {
            C4990ab.m7412e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        C4990ab.m7410d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=".concat(String.valueOf(acB)));
        AppMethodBeat.m2505o(58651);
        return acB;
    }

    public final void reset() {
        int i = 0;
        AppMethodBeat.m2504i(58652);
        C4990ab.m7416i("MicroMsg.MMNativeNetTaskAdapter", "reset");
        StnLogic.reset();
        synchronized (this.gdP) {
            while (true) {
                int i2 = i;
                if (i2 < 100) {
                    try {
                        if (this.gdP[i2] != null) {
                            C4990ab.m7417i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i2), Integer.valueOf(this.gdP[i2].gdT.getType()), Integer.valueOf(this.gdP[i2].gdT.acO()));
                            this.gdP[i2] = null;
                        }
                    } catch (RemoteException e) {
                        C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", C5046bo.m7574l(e));
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(58652);
                    }
                    i = i2 + 1;
                }
            }
        }
        AppMethodBeat.m2505o(58652);
    }

    /* renamed from: i */
    public final void mo60745i(int i, int i2, String str) {
        AppMethodBeat.m2504i(58653);
        C4990ab.m7416i("MicroMsg.MMNativeNetTaskAdapter", "clearTaskAndCallback errType=" + i + ", errCode=" + i2 + ", errMsg=" + str);
        StnLogic.clearTask();
        StnLogic.reset();
        C9765a[] c9765aArr = new C9765a[100];
        synchronized (this.gdP) {
            int i3 = 0;
            while (i3 < 100) {
                try {
                    c9765aArr[i3] = this.gdP[i3];
                    this.gdP[i3] = null;
                    i3++;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(58653);
                    }
                }
            }
        }
        for (int i4 = 0; i4 < 100; i4++) {
            if (c9765aArr[i4] != null) {
                try {
                    C4990ab.m7417i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi clearTaskAndCallback outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i4), Integer.valueOf(c9765aArr[i4].gdT.getType()), Integer.valueOf(c9765aArr[i4].gdT.acO()));
                    c9765aArr[i4].gdU.mo5606a(i4, i, i2, str, c9765aArr[i4].gdT, null);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", C5046bo.m7574l(e));
                }
            }
        }
        AppMethodBeat.m2505o(58653);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mC */
    public final int mo60746mC(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(58654);
        synchronized (this.gdP) {
            try {
                int mD = mo60747mD(i);
                if (-1 == mD) {
                    C4990ab.m7412e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
                } else {
                    i2 = this.gdP[mD].gdT.adu().ady();
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", C5046bo.m7574l(e));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(58654);
            }
        }
        return i2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo60739a(int i, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        boolean z;
        AppMethodBeat.m2504i(58655);
        synchronized (this.gdP) {
            try {
                int mD = mo60747mD(i);
                if (-1 == mD) {
                    z = false;
                    AppMethodBeat.m2505o(58655);
                } else {
                    C4990ab.m7417i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s, type: %d", Integer.valueOf(i2), Boolean.valueOf(this.gdP[mD].gdV.ade()), C5046bo.m7543cd(this.gdP[mD].gdV.ada()), Integer.valueOf(this.gdP[mD].gdT.getType()));
                    int i3 = 1;
                    if (!this.gdP[mD].gdT.acH()) {
                        i3 = 2;
                        this.gdP[mD].gdT.adt().mo9941U(this.gdP[mD].gdV.mo5490jQ(3));
                        C4990ab.m7417i("MicroMsg.MMNativeNetTaskAdapter", "summerauths isSingleSession false type:[%s]", Integer.valueOf(this.gdP[mD].gdT.getType()));
                    }
                    int i4 = i3;
                    this.gdP[mD].gdT.adt().mo9940T(this.gdP[mD].gdV.mo5490jQ(i4));
                    this.gdP[mD].gdT.adt().mo9956hB(this.gdP[mD].gdV.mo5480QF());
                    z = this.gdP[mD].gdT.adt().mo9942a(this.gdP[mD].gdT.getType(), this.gdP[mD].gdV.mo5490jQ(i4), i4 == 2 ? 13 : 0, this.gdP[mD].gdV.ada(), this.gdP[mD].gdV.adc(), 0, this.gdP[mD].gdV.ade());
                    if (z) {
                        byteArrayOutputStream.write(this.gdP[mD].gdT.adt().adk());
                    } else {
                        iArr[0] = 0;
                        C7053e.pXa.mo8378a(162, (long) iArr[0], 1, false);
                        C4990ab.m7412e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
                    }
                    C4990ab.m7411d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", Boolean.valueOf(z));
                    AppMethodBeat.m2505o(58655);
                }
            } catch (RemoteException e) {
                iArr[0] = 1;
                C7053e.pXa.mo8378a(162, (long) iArr[0], 1, false);
                C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", C5046bo.m7574l(e));
                z = false;
            } catch (IOException e2) {
                iArr[0] = 2;
                C7053e.pXa.mo8378a(162, (long) iArr[0], 1, false);
                C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", C5046bo.m7574l(e2));
                z = false;
            } catch (Exception e3) {
                iArr[0] = 3;
                C7053e.pXa.mo8378a(162, (long) iArr[0], 1, false);
                C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", C5046bo.m7574l(e3));
                z = false;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(58655);
            }
        }
        return z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final int mo60737a(int i, byte[] bArr, int[] iArr, int[] iArr2) {
        int i2;
        Throwable e;
        AppMethodBeat.m2504i(58656);
        synchronized (this.gdP) {
            int mD = mo60747mD(i);
            if (-1 == mD) {
                i2 = -1;
                AppMethodBeat.m2505o(58656);
            } else {
                int i3 = StnLogic.RESP_FAIL_HANDLE_DEFAULT;
                try {
                    byte[] adp = this.gdP[mD].gdT.adt().adp();
                    long ads = this.gdP[mD].gdT.adt().ads();
                    C4819i adu = this.gdP[mD].gdT.adu();
                    if (adu.mo9965a(this.gdP[mD].gdT.getType(), bArr, adp, ads)) {
                        int adw = adu.adw();
                        iArr2[0] = 0;
                        if ((adw & 2) == 0) {
                            iArr2[0] = iArr2[0] | 2;
                            C7053e.pXa.mo8378a(656, 0, 1, false);
                        }
                        if ((adw & 4) == 0) {
                            iArr2[0] = iArr2[0] | 4;
                            C7053e.pXa.mo8378a(656, 1, 1, false);
                        }
                        if (!(adu.ada() == null || -13 != adu.ady() || C1892aa.ano() == null)) {
                            C1892aa.ano().amS();
                        }
                        if (-13 == adu.ady()) {
                            mD = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                            try {
                                iArr[0] = adu.ady();
                                i2 = mD;
                            } catch (RemoteException e2) {
                                e = e2;
                                i3 = mD;
                                C7053e.pXa.mo8378a(162, 5, 1, false);
                                C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", C5046bo.m7574l(e));
                                i2 = i3;
                                AppMethodBeat.m2505o(58656);
                                return i2;
                            } catch (Exception e3) {
                                e = e3;
                                i3 = mD;
                                C7053e.pXa.mo8378a(162, 7, 1, false);
                                C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", C5046bo.m7574l(e));
                                i2 = i3;
                                AppMethodBeat.m2505o(58656);
                                return i2;
                            }
                        } else if (-3002 == adu.ady() || -3003 == adu.ady()) {
                            mD = StnLogic.RESP_FAIL_HANDLE_TASK_END;
                            iArr[0] = adu.ady();
                            i2 = mD;
                        } else if (-3001 == adu.ady()) {
                            mD = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                            iArr[0] = adu.ady();
                            i2 = mD;
                        } else {
                            i2 = StnLogic.RESP_FAIL_HANDLE_NORMAL;
                        }
                    } else {
                        C7053e.pXa.mo8378a(162, 4, 1, false);
                        C4990ab.m7412e("MicroMsg.MMNativeNetTaskAdapter", "buf to resp failed, change server and try again");
                        i2 = i3;
                    }
                } catch (RemoteException e4) {
                    e = e4;
                    C7053e.pXa.mo8378a(162, 5, 1, false);
                    C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", C5046bo.m7574l(e));
                    i2 = i3;
                    AppMethodBeat.m2505o(58656);
                    return i2;
                } catch (Exception e5) {
                    e = e5;
                    C7053e.pXa.mo8378a(162, 7, 1, false);
                    C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", C5046bo.m7574l(e));
                    i2 = i3;
                    AppMethodBeat.m2505o(58656);
                    return i2;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(58656);
                }
                AppMethodBeat.m2505o(58656);
            }
        }
        return i2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mD */
    public final int mo60747mD(int i) {
        int i2 = 0;
        while (i2 < 100 && (this.gdP[i2] == null || i != this.gdP[i2].taskId)) {
            i2++;
        }
        if (100 <= i2) {
            return -1;
        }
        return i2;
    }
}
