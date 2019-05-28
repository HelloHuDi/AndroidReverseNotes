package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.storage.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class z {
    final a[] gdP = new a[100];

    static class a {
        r gdT;
        l gdU;
        c gdV;
        long startTime;
        int taskId;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.network.z$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int gdQ;
        final /* synthetic */ int gdR;

        AnonymousClass1(int i, int i2) {
            this.gdQ = i;
            this.gdR = i2;
        }

        public final void run() {
            AppMethodBeat.i(58644);
            MMLogic.reportCGIServerError(this.gdQ, this.gdR);
            AppMethodBeat.o(58644);
        }
    }

    public z() {
        AppMethodBeat.i(58645);
        AppMethodBeat.o(58645);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(58646);
        reset();
        super.finalize();
        AppMethodBeat.o(58646);
    }

    /* Access modifiers changed, original: final */
    public final boolean anc() {
        AppMethodBeat.i(58647);
        synchronized (this.gdP) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.gdP[i] != null && (252 == this.gdP[i].gdT.getType() || 701 == this.gdP[i].gdT.getType() || 702 == this.gdP[i].gdT.getType() || 763 == this.gdP[i].gdT.getType())) {
                        ab.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.gdP[i].gdT.getType());
                        AppMethodBeat.o(58647);
                        return true;
                    }
                } catch (RemoteException e) {
                    this.gdP[i] = null;
                    ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", bo.l(e), Integer.valueOf(i));
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(58647);
                    }
                }
                i++;
            }
            AppMethodBeat.o(58647);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean and() {
        AppMethodBeat.i(58648);
        synchronized (this.gdP) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.gdP[i] != null && 1000 == this.gdP[i].gdT.getType()) {
                        ab.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.gdP[i].gdT.getType());
                        AppMethodBeat.o(58648);
                        return true;
                    }
                } catch (RemoteException e) {
                    this.gdP[i] = null;
                    ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", bo.l(e), Integer.valueOf(i));
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(58648);
                    }
                }
                i++;
            }
            AppMethodBeat.o(58648);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final r de(boolean z) {
        AppMethodBeat.i(58649);
        synchronized (this.gdP) {
            int i = 0;
            r rVar = null;
            while (i < 100) {
                try {
                    if (this.gdP[i] != null) {
                        if (z) {
                            if (this.gdP[i].gdT instanceof com.tencent.mm.network.r.a) {
                                continue;
                            }
                        }
                        if (z || (this.gdP[i].gdT instanceof com.tencent.mm.network.r.a)) {
                            if (252 == this.gdP[i].gdT.getType() || 701 == this.gdP[i].gdT.getType() || 763 == this.gdP[i].gdT.getType() || 702 == this.gdP[i].gdT.getType()) {
                                ab.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.gdP[i].gdT.getType());
                                AppMethodBeat.o(58649);
                                return null;
                            } else if (rVar == null) {
                                rVar = this.gdP[i].gdT;
                            }
                        }
                    }
                } catch (RemoteException e) {
                    ab.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bo.l(e));
                } catch (Throwable th) {
                    AppMethodBeat.o(58649);
                }
                i++;
            }
            AppMethodBeat.o(58649);
            return rVar;
        }
    }

    public final int ane() {
        AppMethodBeat.i(58650);
        int i = 0;
        for (int i2 = 0; i2 < 100; i2++) {
            try {
                if (this.gdP[i2] != null) {
                    this.gdP[i2].gdT.getType();
                }
            } catch (RemoteException e) {
                ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", bo.l(e), Integer.valueOf(i2));
                i++;
                this.gdP[i2] = null;
            }
        }
        AppMethodBeat.o(58650);
        return i;
    }

    static boolean mB(int i) {
        if (i == 10 || i == 268369922) {
            return true;
        }
        return false;
    }

    public final int a(r rVar, l lVar, c cVar, int i) {
        AppMethodBeat.i(58651);
        if (rVar == null) {
            ab.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
            AppMethodBeat.o(58651);
            return -1;
        }
        int acB;
        rVar.hashCode();
        Task task = new Task();
        synchronized (this.gdP) {
            int i2 = 0;
            while (i2 < 100) {
                try {
                    if (this.gdP[i2] == null) {
                        this.gdP[i2] = new a();
                        this.gdP[i2].gdT = rVar;
                        this.gdP[i2].gdU = lVar;
                        this.gdP[i2].gdV = cVar;
                        this.gdP[i2].startTime = bo.anU();
                        this.gdP[i2].taskId = task.taskID;
                        task.cmdID = rVar.adt().getCmdId();
                        task.cgi = rVar.getUri();
                        int type = rVar.getType();
                        task.needAuthed = (rVar.acC() & 1) != 1;
                        if (type == 126 || type == 252 || type == 701 || type == 702 || type == 763) {
                            task.needAuthed = false;
                            if (type == 701 || type == 252) {
                                task.retryCount = 1;
                            }
                        }
                        task.limitFlow = true;
                        if (type == 149 || type == JsApiChooseMedia.CTRL_INDEX || type == 220 || type == 323 || type == com.tencent.mm.plugin.appbrand.jsapi.ab.CTRL_INDEX || type == ErrorCode.TEST_THROWABLE_IS_NULL || type == ErrorCode.TEST_THROWABLE_ISNOT_NULL || type == 703) {
                            task.limitFlow = false;
                        }
                        if (type == 703) {
                            task.limitFrequency = false;
                        }
                        task.channelStrategy = 0;
                        if (type == d.MIC_PTU_MEISHI || type == 835 || type == d.MIC_PTU_SHIGUANG) {
                            task.channelStrategy = 1;
                        }
                        task.sendOnly = false;
                        if (mB(type)) {
                            task.sendOnly = true;
                        }
                        if (rVar.adt().adr() && rVar.getUri() != null && rVar.getUri().length() > 0) {
                            task.channelSelect |= 1;
                        }
                        if (task.cmdID != 0) {
                            task.channelSelect |= 2;
                        }
                        task.reportArg = String.valueOf(type);
                        if (type == c.CTRL_INDEX) {
                            task.totalTimeout = 300000;
                            task.priority = 0;
                        }
                        if (type == 710) {
                            task.totalTimeout = 15000;
                            task.serverProcessCost = 0;
                        }
                        if (type == 2632) {
                            acB = rVar.acB();
                            if (acB != 0) {
                                task.totalTimeout = acB;
                            }
                        }
                        ab.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", Integer.valueOf(i2), Integer.valueOf(task.taskID), Integer.valueOf(rVar.acO()), Integer.valueOf(task.channelSelect), task.cgi, Boolean.valueOf(task.needAuthed));
                        acB = i2;
                    } else {
                        i2++;
                    }
                } catch (RemoteException e) {
                    ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bo.l(e));
                } catch (Throwable th) {
                    AppMethodBeat.o(58651);
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
            ab.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        ab.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=".concat(String.valueOf(acB)));
        AppMethodBeat.o(58651);
        return acB;
    }

    public final void reset() {
        int i = 0;
        AppMethodBeat.i(58652);
        ab.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
        StnLogic.reset();
        synchronized (this.gdP) {
            while (true) {
                int i2 = i;
                if (i2 < 100) {
                    try {
                        if (this.gdP[i2] != null) {
                            ab.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i2), Integer.valueOf(this.gdP[i2].gdT.getType()), Integer.valueOf(this.gdP[i2].gdT.acO()));
                            this.gdP[i2] = null;
                        }
                    } catch (RemoteException e) {
                        ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bo.l(e));
                    } catch (Throwable th) {
                        AppMethodBeat.o(58652);
                    }
                    i = i2 + 1;
                }
            }
        }
        AppMethodBeat.o(58652);
    }

    public final void i(int i, int i2, String str) {
        AppMethodBeat.i(58653);
        ab.i("MicroMsg.MMNativeNetTaskAdapter", "clearTaskAndCallback errType=" + i + ", errCode=" + i2 + ", errMsg=" + str);
        StnLogic.clearTask();
        StnLogic.reset();
        a[] aVarArr = new a[100];
        synchronized (this.gdP) {
            int i3 = 0;
            while (i3 < 100) {
                try {
                    aVarArr[i3] = this.gdP[i3];
                    this.gdP[i3] = null;
                    i3++;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(58653);
                    }
                }
            }
        }
        for (int i4 = 0; i4 < 100; i4++) {
            if (aVarArr[i4] != null) {
                try {
                    ab.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi clearTaskAndCallback outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i4), Integer.valueOf(aVarArr[i4].gdT.getType()), Integer.valueOf(aVarArr[i4].gdT.acO()));
                    aVarArr[i4].gdU.a(i4, i, i2, str, aVarArr[i4].gdT, null);
                } catch (Exception e) {
                    ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bo.l(e));
                }
            }
        }
        AppMethodBeat.o(58653);
    }

    /* Access modifiers changed, original: final */
    public final int mC(int i) {
        int i2 = 0;
        AppMethodBeat.i(58654);
        synchronized (this.gdP) {
            try {
                int mD = mD(i);
                if (-1 == mD) {
                    ab.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
                } else {
                    i2 = this.gdP[mD].gdT.adu().ady();
                }
            } catch (Exception e) {
                ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bo.l(e));
            } finally {
                while (true) {
                }
                AppMethodBeat.o(58654);
            }
        }
        return i2;
    }

    /* Access modifiers changed, original: final */
    public final boolean a(int i, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        boolean z;
        AppMethodBeat.i(58655);
        synchronized (this.gdP) {
            try {
                int mD = mD(i);
                if (-1 == mD) {
                    z = false;
                    AppMethodBeat.o(58655);
                } else {
                    ab.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s, type: %d", Integer.valueOf(i2), Boolean.valueOf(this.gdP[mD].gdV.ade()), bo.cd(this.gdP[mD].gdV.ada()), Integer.valueOf(this.gdP[mD].gdT.getType()));
                    int i3 = 1;
                    if (!this.gdP[mD].gdT.acH()) {
                        i3 = 2;
                        this.gdP[mD].gdT.adt().U(this.gdP[mD].gdV.jQ(3));
                        ab.i("MicroMsg.MMNativeNetTaskAdapter", "summerauths isSingleSession false type:[%s]", Integer.valueOf(this.gdP[mD].gdT.getType()));
                    }
                    int i4 = i3;
                    this.gdP[mD].gdT.adt().T(this.gdP[mD].gdV.jQ(i4));
                    this.gdP[mD].gdT.adt().hB(this.gdP[mD].gdV.QF());
                    z = this.gdP[mD].gdT.adt().a(this.gdP[mD].gdT.getType(), this.gdP[mD].gdV.jQ(i4), i4 == 2 ? 13 : 0, this.gdP[mD].gdV.ada(), this.gdP[mD].gdV.adc(), 0, this.gdP[mD].gdV.ade());
                    if (z) {
                        byteArrayOutputStream.write(this.gdP[mD].gdT.adt().adk());
                    } else {
                        iArr[0] = 0;
                        e.pXa.a(162, (long) iArr[0], 1, false);
                        ab.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
                    }
                    ab.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", Boolean.valueOf(z));
                    AppMethodBeat.o(58655);
                }
            } catch (RemoteException e) {
                iArr[0] = 1;
                e.pXa.a(162, (long) iArr[0], 1, false);
                ab.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", bo.l(e));
                z = false;
            } catch (IOException e2) {
                iArr[0] = 2;
                e.pXa.a(162, (long) iArr[0], 1, false);
                ab.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", bo.l(e2));
                z = false;
            } catch (Exception e3) {
                iArr[0] = 3;
                e.pXa.a(162, (long) iArr[0], 1, false);
                ab.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", bo.l(e3));
                z = false;
            } catch (Throwable th) {
                AppMethodBeat.o(58655);
            }
        }
        return z;
    }

    /* Access modifiers changed, original: final */
    public final int a(int i, byte[] bArr, int[] iArr, int[] iArr2) {
        int i2;
        Throwable e;
        AppMethodBeat.i(58656);
        synchronized (this.gdP) {
            int mD = mD(i);
            if (-1 == mD) {
                i2 = -1;
                AppMethodBeat.o(58656);
            } else {
                int i3 = StnLogic.RESP_FAIL_HANDLE_DEFAULT;
                try {
                    byte[] adp = this.gdP[mD].gdT.adt().adp();
                    long ads = this.gdP[mD].gdT.adt().ads();
                    i adu = this.gdP[mD].gdT.adu();
                    if (adu.a(this.gdP[mD].gdT.getType(), bArr, adp, ads)) {
                        int adw = adu.adw();
                        iArr2[0] = 0;
                        if ((adw & 2) == 0) {
                            iArr2[0] = iArr2[0] | 2;
                            e.pXa.a(656, 0, 1, false);
                        }
                        if ((adw & 4) == 0) {
                            iArr2[0] = iArr2[0] | 4;
                            e.pXa.a(656, 1, 1, false);
                        }
                        if (!(adu.ada() == null || -13 != adu.ady() || aa.ano() == null)) {
                            aa.ano().amS();
                        }
                        if (-13 == adu.ady()) {
                            mD = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                            try {
                                iArr[0] = adu.ady();
                                i2 = mD;
                            } catch (RemoteException e2) {
                                e = e2;
                                i3 = mD;
                                e.pXa.a(162, 5, 1, false);
                                ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bo.l(e));
                                i2 = i3;
                                AppMethodBeat.o(58656);
                                return i2;
                            } catch (Exception e3) {
                                e = e3;
                                i3 = mD;
                                e.pXa.a(162, 7, 1, false);
                                ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bo.l(e));
                                i2 = i3;
                                AppMethodBeat.o(58656);
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
                        e.pXa.a(162, 4, 1, false);
                        ab.e("MicroMsg.MMNativeNetTaskAdapter", "buf to resp failed, change server and try again");
                        i2 = i3;
                    }
                } catch (RemoteException e4) {
                    e = e4;
                    e.pXa.a(162, 5, 1, false);
                    ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bo.l(e));
                    i2 = i3;
                    AppMethodBeat.o(58656);
                    return i2;
                } catch (Exception e5) {
                    e = e5;
                    e.pXa.a(162, 7, 1, false);
                    ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bo.l(e));
                    i2 = i3;
                    AppMethodBeat.o(58656);
                    return i2;
                } catch (Throwable th) {
                    AppMethodBeat.o(58656);
                }
                AppMethodBeat.o(58656);
            }
        }
        return i2;
    }

    /* Access modifiers changed, original: final */
    public final int mD(int i) {
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
