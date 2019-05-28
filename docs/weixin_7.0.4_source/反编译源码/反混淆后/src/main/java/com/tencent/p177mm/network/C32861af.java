package com.tencent.p177mm.network;

import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.ICallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C37973z.C379721;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.p188an.C41753a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.C4819i;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/* renamed from: com.tencent.mm.network.af */
public final class C32861af implements ICallBack {
    private static WakerLock ger = null;
    private static int ges = 1000000205;
    private static int get = 205;
    private static byte[] geu;
    private static byte[] gev;

    /* renamed from: com.tencent.mm.network.af$3 */
    class C187303 implements Runnable {
        C187303() {
        }

        public final void run() {
            AppMethodBeat.m2504i(58698);
            C1892aa.anq().onPush(24, C37432o.m63091fZ(7));
            AppMethodBeat.m2505o(58698);
        }
    }

    private static String exception2String(Exception exception) {
        AppMethodBeat.m2504i(58699);
        StringWriter stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.m2505o(58699);
        return stringWriter2;
    }

    public final boolean makesureAuthed() {
        boolean z = false;
        AppMethodBeat.m2504i(58700);
        if (C1892aa.ano() == null) {
            AppMethodBeat.m2505o(58700);
        } else {
            try {
                z = C1892aa.ano().amT();
                AppMethodBeat.m2505o(58700);
            } catch (Exception e) {
                C4990ab.m7412e("StnCallBack", C32861af.exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
                AppMethodBeat.m2505o(58700);
            }
        }
        return z;
    }

    public final String[] onNewDns(String str) {
        return new String[0];
    }

    public final void onPush(final int i, final byte[] bArr) {
        AppMethodBeat.m2504i(58701);
        if (C1892aa.anq() == null) {
            AppMethodBeat.m2505o(58701);
            return;
        }
        try {
            if (ger == null) {
                ger = new WakerLock(C1892aa.getContext(), "StnCallBack");
            }
            ger.lock(1000, "StnLogic.onNotify");
            C1892aa.anm().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(58696);
                    C1892aa.anq().onPush(i, bArr);
                    AppMethodBeat.m2505o(58696);
                }
            });
            AppMethodBeat.m2505o(58701);
        } catch (Exception e) {
            C4990ab.m7412e("StnCallBack", C32861af.exception2String(e));
            new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            AppMethodBeat.m2505o(58701);
        }
    }

    public final boolean req2Buf(int i, Object obj, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        boolean z = false;
        AppMethodBeat.m2504i(58702);
        if (C1892aa.anp() == null) {
            AppMethodBeat.m2505o(58702);
        } else {
            try {
                z = C1892aa.anp().mo60739a(i, byteArrayOutputStream, iArr, i2);
                AppMethodBeat.m2505o(58702);
            } catch (Exception e) {
                C4990ab.m7412e("StnCallBack", C32861af.exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
                AppMethodBeat.m2505o(58702);
            }
        }
        return z;
    }

    public final int buf2Resp(int i, Object obj, byte[] bArr, int[] iArr, int[] iArr2, int i2) {
        int i3 = -1;
        AppMethodBeat.m2504i(58703);
        if (C1892aa.anp() == null) {
            AppMethodBeat.m2505o(58703);
        } else {
            try {
                i3 = C1892aa.anp().mo60737a(i, bArr, iArr, iArr2);
                AppMethodBeat.m2505o(58703);
            } catch (Exception e) {
                C4990ab.m7412e("StnCallBack", C32861af.exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
                AppMethodBeat.m2505o(58703);
            }
        }
        return i3;
    }

    public final int onTaskEnd(int i, Object obj, int i2, int i3) {
        int i4;
        Exception e;
        AppMethodBeat.m2504i(58704);
        if (C1892aa.anp() == null) {
            AppMethodBeat.m2505o(58704);
            return 0;
        }
        try {
            int mC = C1892aa.anp().mo60746mC(i);
            try {
                final int i5 = i;
                final Object obj2 = obj;
                final int i6 = i2;
                final int i7 = i3;
                C1892aa.anm().post(new Runnable() {
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
                        AppMethodBeat.m2504i(58697);
                        C37973z anp = C1892aa.anp();
                        int i3 = i5;
                        int i4 = i6;
                        int i5 = i7;
                        synchronized (anp.gdP) {
                            int mD = anp.mo60747mD(i3);
                            if (-1 == mD) {
                                C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onGYNetEnd GET FROM QUEUE failed. native:[%d,%d] taskId:%d ", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3));
                            } else {
                                int i6;
                                int ady;
                                int type;
                                C32871t ano;
                                byte[] ada;
                                C4819i adu;
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
                                        C4990ab.m7415f("MicroMsg.MMNativeNetTaskAdapter", "c2JavaErrorType not exits c_errType:%d", Integer.valueOf(i4));
                                        break;
                                }
                                if (i8 == 0) {
                                    i5 = 0;
                                }
                                if (i8 == 3) {
                                    i5 = -1;
                                }
                                if (!C1892aa.ank().geh && i8 == 1) {
                                    C4990ab.m7416i("MicroMsg.MMNativeNetTaskAdapter", "network not available");
                                    i8 = 2;
                                    i5 = -1;
                                }
                                C1930r c1930r = anp.gdP[mD].gdT;
                                C1919l c1919l = anp.gdP[mD].gdU;
                                long j = anp.gdP[mD].startTime;
                                anp.gdP[mD] = null;
                                if (i8 == 0) {
                                    try {
                                        if (!(C37973z.m64251mB(c1930r.getType()) || c1930r.adu().ady() == 0)) {
                                            i6 = 4;
                                            ady = c1930r.adu().ady();
                                            type = c1930r.getType();
                                            try {
                                                ano = C1892aa.ano();
                                                ada = c1930r.adu().ada();
                                                C4990ab.m7410d("MicroMsg.MMAutoAuth", "summerauth onGYNetEnd threadId: 0 errType: " + i6 + " errCode: " + ady + " errMsg: " + null + " rr: " + c1930r + " type: " + c1930r.getType() + " netIdGetCertBeforeAutoAuth: " + ano.gcY);
                                                if (ady == 0) {
                                                    ano.gcP++;
                                                } else if (c1930r.getType() != 10) {
                                                    ano.gcP = 0;
                                                }
                                                adu = c1930r.adu();
                                                switch (c1930r.getType()) {
                                                    case 126:
                                                    case 252:
                                                    case 701:
                                                    case 702:
                                                    case 763:
                                                        C4990ab.m7417i("MicroMsg.MMAutoAuth", "summerauth end type: %d, ret:[%d,%d][%s]", Integer.valueOf(c1930r.getType()), Integer.valueOf(i6), Integer.valueOf(ady), null);
                                                        if (adu.ady() != 0 || i6 != 0 || ady != 0) {
                                                            if (c1930r.getType() != 126) {
                                                                switch (ady) {
                                                                    case -213:
                                                                    case -205:
                                                                    case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                                                                        C4996ah.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
                                                                        if (ady != -213) {
                                                                            if (ady != -100) {
                                                                                if (ady == -205) {
                                                                                    C7053e.pXa.mo8378a(148, 33, 1, false);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            C7053e.pXa.mo8378a(148, 32, 1, false);
                                                                            break;
                                                                        }
                                                                        C7053e.pXa.mo8378a(148, 31, 1, false);
                                                                        break;
                                                                        break;
                                                                }
                                                            }
                                                            C4990ab.m7412e("MicroMsg.MMAutoAuth", "net.end: reg err: type=" + c1930r.getType() + " err=" + i6 + "," + ady + " errmsg=" + null);
                                                            break;
                                                        }
                                                        C4990ab.m7417i("MicroMsg.MMAutoAuth", "summerauth accinfo doAuthEnd type:%d, ret:%d loginDecodeFailedTry:%d", Integer.valueOf(c1930r.getType()), Integer.valueOf(c1930r.adv()), Integer.valueOf(ano.fPj));
                                                        byte[] adz;
                                                        if (c1930r.adv() == 2) {
                                                            if (c1930r.getType() == 702 || c1930r.getType() == 763) {
                                                                C7053e.pXa.mo8378a(148, 34, 1, false);
                                                                ano.fPj++;
                                                                if (ano.fPj <= 1) {
                                                                    i8 = adu.mo9964QF();
                                                                    adz = adu.adz();
                                                                    if (ano.mo53437g(C5046bo.m7540cb(adz) ? "" : C5046bo.m7543cd(adz), C5046bo.m7540cb(ada) ? "" : C5046bo.m7543cd(ada), i8)) {
                                                                        ano.gcU.cPB = ada;
                                                                    } else {
                                                                        C4990ab.m7420w("MicroMsg.MMAutoAuth", "summerauth save serverid aak failed 1");
                                                                    }
                                                                    c1930r.mo5627a(ano.gcV, 0, 0);
                                                                    break;
                                                                }
                                                                C4990ab.m7420w("MicroMsg.MMAutoAuth", "summerauth loginDecodeFailedTry beyond 1 no more try!");
                                                                ano.mo53438h(i6, ady, "auth_decode_failed_" + C5046bo.m7532bc(null, ""));
                                                                break;
                                                            }
                                                        }
                                                        ano.fPj = 0;
                                                        C4990ab.m7417i("MicroMsg.MMAutoAuth", "summerauth accinfo %d: username:%s, wxusername:%s, ticket:%s, single session: %s client session:%s, server session:%s uin:%d", Integer.valueOf(c1930r.getType()), c1930r.adt().getUserName(), adu.adD(), C5046bo.anv(C5046bo.m7539ca(adu.adz())), C5046bo.anv(C5046bo.m7539ca(adu.mo9977jQ(1))), C5046bo.anv(C5046bo.m7539ca(adu.mo9977jQ(2))), C5046bo.anv(C5046bo.m7539ca(adu.mo9977jQ(3))), Integer.valueOf(adu.mo9964QF()));
                                                        QF = adu.mo9964QF();
                                                        adz = adu.adz();
                                                        if (ano.mo53437g(C5046bo.m7540cb(adz) ? "" : C5046bo.m7543cd(adz), C5046bo.m7540cb(ada) ? "" : C5046bo.m7543cd(ada), QF)) {
                                                            ano.gcU.cPB = ada;
                                                            ano.gcU.username = r5.getUserName();
                                                            ano.gcU.gcF = adu.adD();
                                                            ano.gcU.mo5497a(adu.mo9977jQ(1), adu.mo9977jQ(2), adu.mo9977jQ(3), adu.mo9964QF());
                                                            ano.gcU.gcE = adu.adc();
                                                            C1183p.getString(adu.mo9964QF());
                                                            C4872b.dnL();
                                                        } else {
                                                            C7053e.pXa.mo8378a(148, 35, 1, false);
                                                            C4990ab.m7420w("MicroMsg.MMAutoAuth", "summerauth save serverid aak failed 2");
                                                        }
                                                        C4990ab.m7416i("MicroMsg.MMAutoAuth", "summerauth decode and save ok!");
                                                        break;
                                                        break;
                                                    case 381:
                                                        if (i6 == 0 && ady == 0) {
                                                            C4851z.m7216O(c1930r.adu().adA(), c1930r.adu().adB(), c1930r.adu().adC());
                                                            ano.gcX = SystemClock.elapsedRealtime();
                                                        }
                                                        if (C1947ae.giz != 10003 || C1947ae.giA <= 0) {
                                                            i7 = i6;
                                                            i = ady;
                                                        } else {
                                                            if (C1947ae.giA <= 1) {
                                                                C1947ae.giA = 0;
                                                            }
                                                            i7 = 4;
                                                            i = 0;
                                                            C4851z.m7216O("", "", 0);
                                                        }
                                                        if (ano.gcY != -1) {
                                                            if (i7 == 0 && i == 0) {
                                                                ano.mo53431a(c1930r, 0, 0);
                                                            }
                                                            ano.gcY = -1;
                                                            break;
                                                        }
                                                        break;
                                                }
                                                i7 = c1930r.acO();
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
                                            C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", C5046bo.m7574l(e), Integer.valueOf(i3));
                                            i7 = 0;
                                            i = i2;
                                            i8 = i5;
                                            C4990ab.m7417i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onTaskEnd type:%d time:%d hash[%d,%d] [%d,%d]", Integer.valueOf(QF), Long.valueOf(C5046bo.m7566gb(j)), Integer.valueOf(i3), Integer.valueOf(i7), Integer.valueOf(i), Integer.valueOf(i8));
                                            if (4 == i && (-1 == i8 || -2 == i8 || -24 == i8 || -34 == i8)) {
                                                C1892aa.anm().post(new C379721(QF, i8));
                                            }
                                            try {
                                                String adx = c1930r.adu().adx();
                                                if (adx == null || adx.length() <= 0) {
                                                    c1919l.mo5606a(mD, i, i8, null, c1930r, c1930r.adu().ada());
                                                    AppMethodBeat.m2505o(58697);
                                                    return;
                                                }
                                                c1919l.mo5606a(mD, i, i8, adx, c1930r, c1930r.adu().ada());
                                                AppMethodBeat.m2505o(58697);
                                                return;
                                            } catch (Exception e4) {
                                                C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "onGYNetEnd cb %s", e4.getMessage());
                                                C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", C5046bo.m7574l(e4), Integer.valueOf(i3));
                                                AppMethodBeat.m2505o(58697);
                                                return;
                                            }
                                        } finally {
                                            while (true) {
                                                AppMethodBeat.m2505o(58697);
                                            }
                                        }
                                    }
                                }
                                i6 = i8;
                                ady = i5;
                                try {
                                    type = c1930r.getType();
                                    ano = C1892aa.ano();
                                    ada = c1930r.adu().ada();
                                    try {
                                        C4990ab.m7410d("MicroMsg.MMAutoAuth", "summerauth onGYNetEnd threadId: 0 errType: " + i6 + " errCode: " + ady + " errMsg: " + null + " rr: " + c1930r + " type: " + c1930r.getType() + " netIdGetCertBeforeAutoAuth: " + ano.gcY);
                                        if (ady == 0) {
                                        }
                                        adu = c1930r.adu();
                                        switch (c1930r.getType()) {
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
                                        C4990ab.printErrStackTrace("MicroMsg.MMAutoAuth", e5, "summerauth save serverid aak failed 2 cookie:" + C5046bo.m7543cd(ada), new Object[0]);
                                        C4990ab.dot();
                                        AppMethodBeat.m2505o(58697);
                                        throw e5;
                                    } catch (RemoteException e52) {
                                        C4990ab.printErrStackTrace("MicroMsg.MMAutoAuth", e52, "summerauth save serverid aak failed 1 cookie:" + C5046bo.m7543cd(ada), new Object[0]);
                                        C4990ab.dot();
                                        AppMethodBeat.m2505o(58697);
                                        throw e52;
                                    } catch (RemoteException e522) {
                                        C4990ab.m7413e("MicroMsg.MMAutoAuth", "exception:%s", C5046bo.m7574l(e522));
                                    }
                                    i7 = c1930r.acO();
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
                C4990ab.m7412e("StnCallBack", C32861af.exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
                AppMethodBeat.m2505o(58704);
                return i4;
            }
        } catch (Exception e3) {
            e = e3;
            i4 = 0;
        }
        AppMethodBeat.m2505o(58704);
        return i4;
    }

    public final void reportConnectInfo(int i, int i2) {
        AppMethodBeat.m2504i(58705);
        try {
            C1892aa.anl().mo53427mF(i);
            C41753a.m73608ln(i);
            AppMethodBeat.m2505o(58705);
        } catch (Exception e) {
            C4990ab.m7413e("StnCallBack", "reportConnectInfo :%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58705);
        }
    }

    public final int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr) {
        AppMethodBeat.m2504i(58706);
        iArr[0] = get;
        iArr[1] = ges;
        int i;
        if (C32861af.m53759a(byteArrayOutputStream, byteArrayOutputStream2) == 0 || byteArrayOutputStream.size() == 0 || byteArrayOutputStream2.size() == 0) {
            i = StnLogic.ECHECK_NEXT;
            AppMethodBeat.m2505o(58706);
            return i;
        }
        i = StnLogic.ECHECK_NOW;
        AppMethodBeat.m2505o(58706);
        return i;
    }

    public final boolean onLongLinkIdentifyResp(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(58707);
        if (!(bArr == null || bArr2 == null)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr2);
            } catch (IOException e) {
            }
            onPush(ges, byteArrayOutputStream.toByteArray());
        }
        AppMethodBeat.m2505o(58707);
        return true;
    }

    public final String[] requestNetCheckShortLinkHosts() {
        return new String[0];
    }

    /* renamed from: a */
    private static int m53759a(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2) {
        int i = 0;
        AppMethodBeat.m2504i(58708);
        if (C1892aa.ano() == null) {
            AppMethodBeat.m2505o(58708);
        } else {
            try {
                byte[] amU = C1892aa.ano().amU();
                if (amU != null) {
                    byteArrayOutputStream.write(amU);
                    geu = amU;
                }
                amU = C1892aa.ano().eJt;
                if (amU != null) {
                    byteArrayOutputStream2.write(amU);
                    gev = amU;
                }
                i = C1892aa.ano().gcU.mo5495QF();
                AppMethodBeat.m2505o(58708);
            } catch (Exception e) {
                C4990ab.m7412e("StnCallBack", C32861af.exception2String(e));
                if (!(geu == null || gev == null)) {
                    try {
                        byteArrayOutputStream.write(geu);
                        byteArrayOutputStream2.write(gev);
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.m2505o(58708);
            }
        }
        return i;
    }

    public final void requestDoSync() {
        AppMethodBeat.m2504i(58709);
        if (C1892aa.anq() == null) {
            AppMethodBeat.m2505o(58709);
            return;
        }
        try {
            C1892aa.anm().post(new C187303());
            AppMethodBeat.m2505o(58709);
        } catch (Exception e) {
            C4990ab.m7412e("StnCallBack", C32861af.exception2String(e));
            new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            AppMethodBeat.m2505o(58709);
        }
    }

    public final boolean isLogoned() {
        boolean z = false;
        AppMethodBeat.m2504i(58710);
        if (C1892aa.ano() == null) {
            AppMethodBeat.m2505o(58710);
        } else {
            try {
                z = C1892aa.ano().gcU.adb();
                AppMethodBeat.m2505o(58710);
            } catch (Exception e) {
                C4990ab.m7412e("StnCallBack", C32861af.exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
                AppMethodBeat.m2505o(58710);
            }
        }
        return z;
    }

    public final void networkAnalysisCallBack(int i, int i2, boolean z, String str) {
        AppMethodBeat.m2504i(58711);
        C4990ab.m7417i("StnCallBack", "networkAnalysisCallBack: status:%d, stage:%d, isDetectEnd:%b, kvInfo:%s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str);
        try {
            C1892aa.ano().gdc.networkAnalysisCallBack(i, i2, z, str);
            AppMethodBeat.m2505o(58711);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("StnCallBack", e, "", new Object[0]);
            new StringBuilder().append(e.getClass().getSimpleName()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            AppMethodBeat.m2505o(58711);
        }
    }
}
