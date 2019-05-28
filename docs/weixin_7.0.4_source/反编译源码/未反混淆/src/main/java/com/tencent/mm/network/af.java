package com.tencent.mm.network;

import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.ICallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.o;
import com.tencent.mm.a.p;
import com.tencent.mm.an.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class af implements ICallBack {
    private static WakerLock ger = null;
    private static int ges = 1000000205;
    private static int get = 205;
    private static byte[] geu;
    private static byte[] gev;

    private static String exception2String(Exception exception) {
        AppMethodBeat.i(58699);
        StringWriter stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(58699);
        return stringWriter2;
    }

    public final boolean makesureAuthed() {
        boolean z = false;
        AppMethodBeat.i(58700);
        if (aa.ano() == null) {
            AppMethodBeat.o(58700);
        } else {
            try {
                z = aa.ano().amT();
                AppMethodBeat.o(58700);
            } catch (Exception e) {
                ab.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
                AppMethodBeat.o(58700);
            }
        }
        return z;
    }

    public final String[] onNewDns(String str) {
        return new String[0];
    }

    public final void onPush(final int i, final byte[] bArr) {
        AppMethodBeat.i(58701);
        if (aa.anq() == null) {
            AppMethodBeat.o(58701);
            return;
        }
        try {
            if (ger == null) {
                ger = new WakerLock(aa.getContext(), "StnCallBack");
            }
            ger.lock(1000, "StnLogic.onNotify");
            aa.anm().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(58696);
                    aa.anq().onPush(i, bArr);
                    AppMethodBeat.o(58696);
                }
            });
            AppMethodBeat.o(58701);
        } catch (Exception e) {
            ab.e("StnCallBack", exception2String(e));
            new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            AppMethodBeat.o(58701);
        }
    }

    public final boolean req2Buf(int i, Object obj, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        boolean z = false;
        AppMethodBeat.i(58702);
        if (aa.anp() == null) {
            AppMethodBeat.o(58702);
        } else {
            try {
                z = aa.anp().a(i, byteArrayOutputStream, iArr, i2);
                AppMethodBeat.o(58702);
            } catch (Exception e) {
                ab.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
                AppMethodBeat.o(58702);
            }
        }
        return z;
    }

    public final int buf2Resp(int i, Object obj, byte[] bArr, int[] iArr, int[] iArr2, int i2) {
        int i3 = -1;
        AppMethodBeat.i(58703);
        if (aa.anp() == null) {
            AppMethodBeat.o(58703);
        } else {
            try {
                i3 = aa.anp().a(i, bArr, iArr, iArr2);
                AppMethodBeat.o(58703);
            } catch (Exception e) {
                ab.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
                AppMethodBeat.o(58703);
            }
        }
        return i3;
    }

    public final int onTaskEnd(int i, Object obj, int i2, int i3) {
        int i4;
        Exception e;
        AppMethodBeat.i(58704);
        if (aa.anp() == null) {
            AppMethodBeat.o(58704);
            return 0;
        }
        try {
            int mC = aa.anp().mC(i);
            try {
                final int i5 = i;
                final Object obj2 = obj;
                final int i6 = i2;
                final int i7 = i3;
                aa.anm().post(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:82:0x022c A:{SYNTHETIC, Splitter:B:82:0x022c} */
                    /* JADX WARNING: Removed duplicated region for block: B:37:0x012b A:{Catch:{ RemoteException -> 0x0564, RemoteException -> 0x0409, RemoteException -> 0x023b }} */
                    /* JADX WARNING: Removed duplicated region for block: B:94:0x0274 A:{SYNTHETIC, Splitter:B:94:0x0274} */
                    /* JADX WARNING: Removed duplicated region for block: B:168:0x058c A:{SKIP, Catch:{ RemoteException -> 0x0564, RemoteException -> 0x0409, RemoteException -> 0x023b }} */
                    /* JADX WARNING: Missing block: B:198:?, code skipped:
            return;
     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        int i;
                        Throwable e;
                        int i2;
                        AppMethodBeat.i(58697);
                        z anp = aa.anp();
                        int i3 = i5;
                        int i4 = i6;
                        int i5 = i7;
                        synchronized (anp.gdP) {
                            int mD = anp.mD(i3);
                            if (-1 == mD) {
                                ab.e("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onGYNetEnd GET FROM QUEUE failed. native:[%d,%d] taskId:%d ", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3));
                            } else {
                                int i6;
                                int ady;
                                int type;
                                t ano;
                                byte[] ada;
                                i adu;
                                int QF;
                                int i7;
                                int i8 = 0;
                                switch (i4) {
                                    case 0:
                                        i8 = 0;
                                        break;
                                    case 1:
                                        i8 = 2;
                                        break;
                                    case 2:
                                        i8 = 2;
                                        break;
                                    case 3:
                                        i8 = 1;
                                        break;
                                    case 4:
                                        i8 = 1;
                                        break;
                                    case 5:
                                        i8 = 1;
                                        break;
                                    case 6:
                                        i8 = 1;
                                        break;
                                    case 7:
                                        if (-3002 != i5 && -3003 != i5) {
                                            if (-10001 != i5) {
                                                i8 = 5;
                                                break;
                                            } else {
                                                i8 = 6;
                                                break;
                                            }
                                        }
                                        i8 = 4;
                                        break;
                                        break;
                                    case 8:
                                        i8 = 4;
                                        break;
                                    case 9:
                                        i8 = 1;
                                        break;
                                    default:
                                        ab.f("MicroMsg.MMNativeNetTaskAdapter", "c2JavaErrorType not exits c_errType:%d", Integer.valueOf(i4));
                                        break;
                                }
                                if (i8 == 0) {
                                    i5 = 0;
                                }
                                if (i8 == 3) {
                                    i5 = -1;
                                }
                                if (!aa.ank().geh && i8 == 1) {
                                    ab.i("MicroMsg.MMNativeNetTaskAdapter", "network not available");
                                    i8 = 2;
                                    i5 = -1;
                                }
                                r rVar = anp.gdP[mD].gdT;
                                l lVar = anp.gdP[mD].gdU;
                                long j = anp.gdP[mD].startTime;
                                anp.gdP[mD] = null;
                                if (i8 == 0) {
                                    try {
                                        if (!(z.mB(rVar.getType()) || rVar.adu().ady() == 0)) {
                                            i6 = 4;
                                            ady = rVar.adu().ady();
                                            type = rVar.getType();
                                            try {
                                                ano = aa.ano();
                                                ada = rVar.adu().ada();
                                                ab.d("MicroMsg.MMAutoAuth", "summerauth onGYNetEnd threadId: 0 errType: " + i6 + " errCode: " + ady + " errMsg: " + null + " rr: " + rVar + " type: " + rVar.getType() + " netIdGetCertBeforeAutoAuth: " + ano.gcY);
                                                if (ady == 0) {
                                                    ano.gcP++;
                                                } else if (rVar.getType() != 10) {
                                                    ano.gcP = 0;
                                                }
                                                adu = rVar.adu();
                                                switch (rVar.getType()) {
                                                    case 126:
                                                    case 252:
                                                    case 701:
                                                    case 702:
                                                    case 763:
                                                        ab.i("MicroMsg.MMAutoAuth", "summerauth end type: %d, ret:[%d,%d][%s]", Integer.valueOf(rVar.getType()), Integer.valueOf(i6), Integer.valueOf(ady), null);
                                                        if (adu.ady() != 0 || i6 != 0 || ady != 0) {
                                                            if (rVar.getType() != 126) {
                                                                switch (ady) {
                                                                    case -213:
                                                                    case -205:
                                                                    case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                                                                        ah.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
                                                                        if (ady != -213) {
                                                                            if (ady != -100) {
                                                                                if (ady == -205) {
                                                                                    e.pXa.a(148, 33, 1, false);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            e.pXa.a(148, 32, 1, false);
                                                                            break;
                                                                        }
                                                                        e.pXa.a(148, 31, 1, false);
                                                                        break;
                                                                        break;
                                                                }
                                                            }
                                                            ab.e("MicroMsg.MMAutoAuth", "net.end: reg err: type=" + rVar.getType() + " err=" + i6 + "," + ady + " errmsg=" + null);
                                                            break;
                                                        }
                                                        ab.i("MicroMsg.MMAutoAuth", "summerauth accinfo doAuthEnd type:%d, ret:%d loginDecodeFailedTry:%d", Integer.valueOf(rVar.getType()), Integer.valueOf(rVar.adv()), Integer.valueOf(ano.fPj));
                                                        byte[] adz;
                                                        if (rVar.adv() == 2) {
                                                            if (rVar.getType() == 702 || rVar.getType() == 763) {
                                                                e.pXa.a(148, 34, 1, false);
                                                                ano.fPj++;
                                                                if (ano.fPj <= 1) {
                                                                    i8 = adu.QF();
                                                                    adz = adu.adz();
                                                                    if (ano.g(bo.cb(adz) ? "" : bo.cd(adz), bo.cb(ada) ? "" : bo.cd(ada), i8)) {
                                                                        ano.gcU.cPB = ada;
                                                                    } else {
                                                                        ab.w("MicroMsg.MMAutoAuth", "summerauth save serverid aak failed 1");
                                                                    }
                                                                    rVar.a(ano.gcV, 0, 0);
                                                                    break;
                                                                }
                                                                ab.w("MicroMsg.MMAutoAuth", "summerauth loginDecodeFailedTry beyond 1 no more try!");
                                                                ano.h(i6, ady, "auth_decode_failed_" + bo.bc(null, ""));
                                                                break;
                                                            }
                                                        }
                                                        ano.fPj = 0;
                                                        ab.i("MicroMsg.MMAutoAuth", "summerauth accinfo %d: username:%s, wxusername:%s, ticket:%s, single session: %s client session:%s, server session:%s uin:%d", Integer.valueOf(rVar.getType()), rVar.adt().getUserName(), adu.adD(), bo.anv(bo.ca(adu.adz())), bo.anv(bo.ca(adu.jQ(1))), bo.anv(bo.ca(adu.jQ(2))), bo.anv(bo.ca(adu.jQ(3))), Integer.valueOf(adu.QF()));
                                                        QF = adu.QF();
                                                        adz = adu.adz();
                                                        if (ano.g(bo.cb(adz) ? "" : bo.cd(adz), bo.cb(ada) ? "" : bo.cd(ada), QF)) {
                                                            ano.gcU.cPB = ada;
                                                            ano.gcU.username = r5.getUserName();
                                                            ano.gcU.gcF = adu.adD();
                                                            ano.gcU.a(adu.jQ(1), adu.jQ(2), adu.jQ(3), adu.QF());
                                                            ano.gcU.gcE = adu.adc();
                                                            p.getString(adu.QF());
                                                            b.dnL();
                                                        } else {
                                                            e.pXa.a(148, 35, 1, false);
                                                            ab.w("MicroMsg.MMAutoAuth", "summerauth save serverid aak failed 2");
                                                        }
                                                        ab.i("MicroMsg.MMAutoAuth", "summerauth decode and save ok!");
                                                        break;
                                                        break;
                                                    case 381:
                                                        if (i6 == 0 && ady == 0) {
                                                            z.O(rVar.adu().adA(), rVar.adu().adB(), rVar.adu().adC());
                                                            ano.gcX = SystemClock.elapsedRealtime();
                                                        }
                                                        if (ae.giz != 10003 || ae.giA <= 0) {
                                                            i7 = i6;
                                                            i = ady;
                                                        } else {
                                                            if (ae.giA <= 1) {
                                                                ae.giA = 0;
                                                            }
                                                            i7 = 4;
                                                            i = 0;
                                                            z.O("", "", 0);
                                                        }
                                                        if (ano.gcY != -1) {
                                                            if (i7 == 0 && i == 0) {
                                                                ano.a(rVar, 0, 0);
                                                            }
                                                            ano.gcY = -1;
                                                            break;
                                                        }
                                                        break;
                                                }
                                                i7 = rVar.acO();
                                                QF = type;
                                                i = i6;
                                                i8 = ady;
                                            } catch (RemoteException e2) {
                                                e = e2;
                                                QF = type;
                                                i2 = i6;
                                                i5 = ady;
                                            }
                                        }
                                    } catch (RemoteException e3) {
                                        e = e3;
                                        QF = -1;
                                        i2 = i8;
                                        try {
                                            ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", bo.l(e), Integer.valueOf(i3));
                                            i7 = 0;
                                            i = i2;
                                            i8 = i5;
                                            ab.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onTaskEnd type:%d time:%d hash[%d,%d] [%d,%d]", Integer.valueOf(QF), Long.valueOf(bo.gb(j)), Integer.valueOf(i3), Integer.valueOf(i7), Integer.valueOf(i), Integer.valueOf(i8));
                                            if (4 == i && (-1 == i8 || -2 == i8 || -24 == i8 || -34 == i8)) {
                                                aa.anm().post(new com.tencent.mm.network.z.AnonymousClass1(QF, i8));
                                            }
                                            try {
                                                String adx = rVar.adu().adx();
                                                if (adx == null || adx.length() <= 0) {
                                                    lVar.a(mD, i, i8, null, rVar, rVar.adu().ada());
                                                    AppMethodBeat.o(58697);
                                                    return;
                                                }
                                                lVar.a(mD, i, i8, adx, rVar, rVar.adu().ada());
                                                AppMethodBeat.o(58697);
                                                return;
                                            } catch (Exception e4) {
                                                ab.e("MicroMsg.MMNativeNetTaskAdapter", "onGYNetEnd cb %s", e4.getMessage());
                                                ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", bo.l(e4), Integer.valueOf(i3));
                                                AppMethodBeat.o(58697);
                                                return;
                                            }
                                        } finally {
                                            while (true) {
                                                AppMethodBeat.o(58697);
                                            }
                                        }
                                    }
                                }
                                i6 = i8;
                                ady = i5;
                                try {
                                    type = rVar.getType();
                                    ano = aa.ano();
                                    ada = rVar.adu().ada();
                                    try {
                                        ab.d("MicroMsg.MMAutoAuth", "summerauth onGYNetEnd threadId: 0 errType: " + i6 + " errCode: " + ady + " errMsg: " + null + " rr: " + rVar + " type: " + rVar.getType() + " netIdGetCertBeforeAutoAuth: " + ano.gcY);
                                        if (ady == 0) {
                                        }
                                        adu = rVar.adu();
                                        switch (rVar.getType()) {
                                            case 126:
                                            case 252:
                                            case 701:
                                            case 702:
                                            case 763:
                                                break;
                                            case 381:
                                                break;
                                        }
                                    } catch (RemoteException e5) {
                                        ab.printErrStackTrace("MicroMsg.MMAutoAuth", e5, "summerauth save serverid aak failed 2 cookie:" + bo.cd(ada), new Object[0]);
                                        ab.dot();
                                        AppMethodBeat.o(58697);
                                        throw e5;
                                    } catch (RemoteException e52) {
                                        ab.printErrStackTrace("MicroMsg.MMAutoAuth", e52, "summerauth save serverid aak failed 1 cookie:" + bo.cd(ada), new Object[0]);
                                        ab.dot();
                                        AppMethodBeat.o(58697);
                                        throw e52;
                                    } catch (RemoteException e522) {
                                        ab.e("MicroMsg.MMAutoAuth", "exception:%s", bo.l(e522));
                                    }
                                    i7 = rVar.acO();
                                    QF = type;
                                    i = i6;
                                    i8 = ady;
                                } catch (RemoteException e6) {
                                    e = e6;
                                    QF = -1;
                                    i2 = i6;
                                    i5 = ady;
                                }
                            }
                        }
                    }
                });
                i4 = mC;
            } catch (Exception e2) {
                e = e2;
                i4 = mC;
                ab.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
                AppMethodBeat.o(58704);
                return i4;
            }
        } catch (Exception e3) {
            e = e3;
            i4 = 0;
        }
        AppMethodBeat.o(58704);
        return i4;
    }

    public final void reportConnectInfo(int i, int i2) {
        AppMethodBeat.i(58705);
        try {
            aa.anl().mF(i);
            a.ln(i);
            AppMethodBeat.o(58705);
        } catch (Exception e) {
            ab.e("StnCallBack", "reportConnectInfo :%s", bo.l(e));
            AppMethodBeat.o(58705);
        }
    }

    public final int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr) {
        AppMethodBeat.i(58706);
        iArr[0] = get;
        iArr[1] = ges;
        int i;
        if (a(byteArrayOutputStream, byteArrayOutputStream2) == 0 || byteArrayOutputStream.size() == 0 || byteArrayOutputStream2.size() == 0) {
            i = StnLogic.ECHECK_NEXT;
            AppMethodBeat.o(58706);
            return i;
        }
        i = StnLogic.ECHECK_NOW;
        AppMethodBeat.o(58706);
        return i;
    }

    public final boolean onLongLinkIdentifyResp(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(58707);
        if (!(bArr == null || bArr2 == null)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr2);
            } catch (IOException e) {
            }
            onPush(ges, byteArrayOutputStream.toByteArray());
        }
        AppMethodBeat.o(58707);
        return true;
    }

    public final String[] requestNetCheckShortLinkHosts() {
        return new String[0];
    }

    private static int a(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2) {
        int i = 0;
        AppMethodBeat.i(58708);
        if (aa.ano() == null) {
            AppMethodBeat.o(58708);
        } else {
            try {
                byte[] amU = aa.ano().amU();
                if (amU != null) {
                    byteArrayOutputStream.write(amU);
                    geu = amU;
                }
                amU = aa.ano().eJt;
                if (amU != null) {
                    byteArrayOutputStream2.write(amU);
                    gev = amU;
                }
                i = aa.ano().gcU.QF();
                AppMethodBeat.o(58708);
            } catch (Exception e) {
                ab.e("StnCallBack", exception2String(e));
                if (!(geu == null || gev == null)) {
                    try {
                        byteArrayOutputStream.write(geu);
                        byteArrayOutputStream2.write(gev);
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.o(58708);
            }
        }
        return i;
    }

    public final void requestDoSync() {
        AppMethodBeat.i(58709);
        if (aa.anq() == null) {
            AppMethodBeat.o(58709);
            return;
        }
        try {
            aa.anm().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(58698);
                    aa.anq().onPush(24, o.fZ(7));
                    AppMethodBeat.o(58698);
                }
            });
            AppMethodBeat.o(58709);
        } catch (Exception e) {
            ab.e("StnCallBack", exception2String(e));
            new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            AppMethodBeat.o(58709);
        }
    }

    public final boolean isLogoned() {
        boolean z = false;
        AppMethodBeat.i(58710);
        if (aa.ano() == null) {
            AppMethodBeat.o(58710);
        } else {
            try {
                z = aa.ano().gcU.adb();
                AppMethodBeat.o(58710);
            } catch (Exception e) {
                ab.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
                AppMethodBeat.o(58710);
            }
        }
        return z;
    }

    public final void networkAnalysisCallBack(int i, int i2, boolean z, String str) {
        AppMethodBeat.i(58711);
        ab.i("StnCallBack", "networkAnalysisCallBack: status:%d, stage:%d, isDetectEnd:%b, kvInfo:%s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str);
        try {
            aa.ano().gdc.networkAnalysisCallBack(i, i2, z, str);
            AppMethodBeat.o(58711);
        } catch (Exception e) {
            ab.printErrStackTrace("StnCallBack", e, "", new Object[0]);
            new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            AppMethodBeat.o(58711);
        }
    }
}
