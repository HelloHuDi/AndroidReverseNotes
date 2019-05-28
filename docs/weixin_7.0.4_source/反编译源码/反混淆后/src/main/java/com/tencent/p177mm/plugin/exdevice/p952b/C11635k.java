package com.tencent.p177mm.plugin.exdevice.p952b;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.exdevice.model.C20495e;
import com.tencent.p177mm.plugin.exdevice.model.C20539w;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1255e.C38933k;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.plugin.exdevice.p957i.C11650h;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.protocal.protobuf.bwh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.b.k */
public final class C11635k implements C1202f {
    public static C11635k lqI = null;
    private final HashMap<Long, C11638e> lqH;
    public HashMap<String, Integer> lqJ;
    public C7306ak mHandler;

    /* renamed from: com.tencent.mm.plugin.exdevice.b.k$c */
    public static final class C11636c {
        public byte[] mData;
        public long mSessionId;

        private C11636c() {
            this.mSessionId = 0;
            this.mData = null;
        }

        public /* synthetic */ C11636c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.b.k$d */
    final class C11637d implements Runnable {
        private long lqN = -1;

        public C11637d(long j) {
            AppMethodBeat.m2504i(19055);
            Assert.assertTrue(j >= 0);
            this.lqN = j;
            AppMethodBeat.m2505o(19055);
        }

        public final void run() {
            AppMethodBeat.m2504i(19056);
            C4990ab.m7421w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", Long.valueOf(this.lqN));
            C11635k.this.mHandler.obtainMessage(0, Long.valueOf(this.lqN)).sendToTarget();
            AppMethodBeat.m2505o(19056);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.b.k$e */
    static final class C11638e {
        C38928f lqO;
        private C11637d lqP;
        int lqQ;

        private C11638e() {
            this.lqO = null;
            this.lqP = null;
            this.lqQ = 0;
        }

        /* synthetic */ C11638e(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo23398a(C38928f c38928f) {
            AppMethodBeat.m2504i(19057);
            Assert.assertNotNull(c38928f);
            this.lqO = c38928f;
            AppMethodBeat.m2505o(19057);
        }

        /* renamed from: a */
        public final void mo23399a(C11637d c11637d) {
            AppMethodBeat.m2504i(19058);
            Assert.assertNotNull(c11637d);
            this.lqP = c11637d;
            AppMethodBeat.m2505o(19058);
        }

        public final C38928f box() {
            AppMethodBeat.m2504i(19059);
            Assert.assertNotNull(this.lqO);
            C38928f c38928f = this.lqO;
            AppMethodBeat.m2505o(19059);
            return c38928f;
        }

        public final C11637d boy() {
            AppMethodBeat.m2504i(19060);
            Assert.assertNotNull(this.lqP);
            C11637d c11637d = this.lqP;
            AppMethodBeat.m2505o(19060);
            return c11637d;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.b.k$f */
    public static final class C11639f {
        private static C11639f lqS = null;
        private long lqR;

        public C11639f() {
            long j = 0;
            AppMethodBeat.m2504i(19061);
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("local_message_seq", 0);
                C4990ab.m7417i("MicroMsg.exdevice.Util", "lasted seq id is %d", Long.valueOf(j));
            }
            this.lqR = j;
            AppMethodBeat.m2505o(19061);
        }

        public static long boz() {
            AppMethodBeat.m2504i(19062);
            if (lqS == null) {
                lqS = new C11639f();
            }
            C11639f c11639f = lqS;
            if (Long.MAX_VALUE == c11639f.lqR) {
                C4990ab.m7420w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
                c11639f.lqR = 0;
            }
            long j = c11639f.lqR + 1;
            c11639f.lqR = j;
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                C4990ab.m7417i("MicroMsg.exdevice.Util", "save locall seq id : %d", Long.valueOf(j));
                sharedPreferences.edit().putLong("local_message_seq", j).commit();
            }
            AppMethodBeat.m2505o(19062);
            return j;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.b.k$b */
    static final class C11640b {
        public String hxN;
        public int lqL;
        public C1207m lqM;
        public int lqz;

        private C11640b() {
            this.lqz = 0;
            this.lqL = 0;
            this.hxN = null;
            this.lqM = null;
        }

        /* synthetic */ C11640b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.b.k$a */
    class C11641a extends C7306ak {
        public C11641a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(19054);
            C4990ab.m7417i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", Integer.valueOf(message.what));
            C11638e c11638e;
            switch (message.what) {
                case 0:
                    long longValue = ((Long) message.obj).longValue();
                    C11638e c11638e2 = (C11638e) C11635k.this.lqH.get(Long.valueOf(longValue));
                    if (c11638e2 == null) {
                        C4990ab.m7421w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", Long.valueOf(longValue));
                        AppMethodBeat.m2505o(19054);
                        return;
                    }
                    c11638e2.box().mo61820f(-1, "", null);
                    C20548u.bpy().mo54568a(new C11650h(c11638e2.box()));
                    C11635k.this.lqH.remove(Long.valueOf(longValue));
                    AppMethodBeat.m2505o(19054);
                    return;
                case 1:
                    C38928f c38928f = (C38928f) message.obj;
                    if (!C20548u.bpx().mo45725hX(c38928f.jJa)) {
                        C4990ab.m7413e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", Long.valueOf(c38928f.jJa));
                        c38928f.mo61820f(-2, "", new byte[0]);
                        C20548u.bpy().mo54568a(new C11650h(c38928f));
                        AppMethodBeat.m2505o(19054);
                        return;
                    } else if (-5 == message.arg1 || -3 == message.arg1 || -4 == message.arg1) {
                        C4990ab.m7413e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", Integer.valueOf(message.arg1));
                        c38928f.mo61820f(-1, "", new byte[0]);
                        C20548u.bpy().mo54568a(new C11650h(c38928f));
                        AppMethodBeat.m2505o(19054);
                        return;
                    } else {
                        C11648b Ku = C45891ad.boW().mo45700Ku(c38928f.jJa);
                        if (Ku == null) {
                            C4990ab.m7412e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                            AppMethodBeat.m2505o(19054);
                            return;
                        }
                        if (System.currentTimeMillis() / 1000 < ((long) Ku.dFi)) {
                            C4990ab.m7412e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
                            c38928f.mo61820f(-5, "Device Is Block", null);
                            C20548u.bpy().mo54568a(new C11650h(c38928f));
                            AppMethodBeat.m2505o(19054);
                            return;
                        }
                        long boz = C11639f.boz();
                        C38933k c38933k = (C38933k) c38928f.bou();
                        if (c38933k == null) {
                            C4990ab.m7412e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
                            c38928f.mo61820f(-4, "Decode failed", null);
                            C20548u.bpy().mo54568a(new C11650h(c38928f));
                            AppMethodBeat.m2505o(19054);
                            return;
                        }
                        Integer num = (Integer) C11635k.this.lqJ.get(Ku.field_deviceID);
                        if (num == null) {
                            num = Integer.valueOf(0);
                        }
                        C4990ab.m7417i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", num);
                        C11637d c11637d;
                        C11638e c11638e3;
                        if (num.intValue() != 0) {
                            if ((num.intValue() & 1) != 0) {
                                C45891ad.bph();
                                C20495e.m31666d(Ku.field_deviceID, Ku.field_brandName, c38933k.jBi.toByteArray());
                            }
                            if ((num.intValue() & 2) != 0) {
                                C9638aw.m17182Rg().mo14541a(new C20539w(c38928f.jJa, Ku.field_deviceType, Ku.field_deviceID, boz, C5046bo.anU(), c38933k.jBi.toByteArray(), c38933k.jCt), 0);
                                c11637d = new C11637d(boz);
                                C11635k.this.mHandler.postDelayed(c11637d, 30000);
                                c11638e3 = new C11638e();
                                c11638e3.mo23398a(c38928f);
                                c11638e3.mo23399a(c11637d);
                                c11638e3.lqQ = 0;
                                C11635k.this.lqH.put(Long.valueOf(boz), c11638e3);
                            }
                            AppMethodBeat.m2505o(19054);
                            return;
                        } else if (c38933k.jCt == 10001) {
                            C45891ad.bph();
                            C20495e.m31666d(Ku.field_deviceID, Ku.field_brandName, c38933k.jBi.toByteArray());
                            AppMethodBeat.m2505o(19054);
                            return;
                        } else {
                            C9638aw.m17182Rg().mo14541a(new C20539w(c38928f.jJa, Ku.field_deviceType, Ku.field_deviceID, boz, C5046bo.anU(), c38933k.jBi.toByteArray(), c38933k.jCt), 0);
                            c11637d = new C11637d(boz);
                            C11635k.this.mHandler.postDelayed(c11637d, 30000);
                            c11638e3 = new C11638e();
                            c11638e3.mo23398a(c38928f);
                            c11638e3.mo23399a(c11637d);
                            c11638e3.lqQ = 0;
                            C11635k.this.lqH.put(Long.valueOf(boz), c11638e3);
                            AppMethodBeat.m2505o(19054);
                            return;
                        }
                    }
                case 2:
                    C11640b c11640b = (C11640b) message.obj;
                    if (c11640b.lqL == 0 && c11640b.lqz == 0) {
                        AppMethodBeat.m2505o(19054);
                        return;
                    }
                    C20539w c20539w = (C20539w) c11640b.lqM;
                    Assert.assertNotNull(c20539w.lty);
                    long j = ((bwh) c20539w.lty.fsG.fsP).wWW.wwE;
                    c11638e = (C11638e) C11635k.this.lqH.get(Long.valueOf(j));
                    if (c11638e == null) {
                        C4990ab.m7413e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", Long.valueOf(j));
                        AppMethodBeat.m2505o(19054);
                        return;
                    }
                    int i;
                    C38928f box = c11638e.box();
                    switch (c11640b.lqz) {
                        case -417:
                            i = -5;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    box.mo61820f(i, c11640b.hxN, null);
                    C20548u.bpy().mo54568a(new C11650h(c11638e.box()));
                    C11635k.this.mHandler.removeCallbacks(c11638e.boy());
                    C11635k.this.lqH.remove(Long.valueOf(j));
                    AppMethodBeat.m2505o(19054);
                    return;
                case 3:
                    C11636c c11636c = (C11636c) message.obj;
                    c11638e = (C11638e) C11635k.this.lqH.get(Long.valueOf(c11636c.mSessionId));
                    if (c11638e == null) {
                        C4990ab.m7421w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", Long.valueOf(c11636c.mSessionId));
                        AppMethodBeat.m2505o(19054);
                        return;
                    }
                    c11638e.lqO.mo61820f(0, "", c11636c.mData);
                    C20548u.bpy().mo54568a(new C11650h(c11638e.box()));
                    C11635k.this.mHandler.removeCallbacks(c11638e.boy());
                    C11635k.this.lqH.remove(Long.valueOf(c11636c.mSessionId));
                    AppMethodBeat.m2505o(19054);
                    return;
                default:
                    C4990ab.m7415f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", Integer.valueOf(message.what));
                    AppMethodBeat.m2505o(19054);
                    return;
            }
        }
    }

    public static C11635k bow() {
        AppMethodBeat.m2504i(19063);
        C11635k c11635k;
        if (lqI != null) {
            c11635k = lqI;
            AppMethodBeat.m2505o(19063);
            return c11635k;
        }
        c11635k = new C11635k();
        lqI = c11635k;
        AppMethodBeat.m2505o(19063);
        return c11635k;
    }

    private C11635k() {
        AppMethodBeat.m2504i(19064);
        this.lqH = new HashMap();
        this.mHandler = null;
        this.lqJ = new HashMap();
        this.mHandler = new C11641a(C9638aw.m17180RS().oAl.getLooper());
        AppMethodBeat.m2505o(19064);
    }

    /* renamed from: b */
    public final void mo23396b(int i, long j, int i2, int i3, byte[] bArr) {
        AppMethodBeat.m2504i(19065);
        this.mHandler.obtainMessage(1, i, 0, new C38928f(j, i2, i3, bArr)).sendToTarget();
        AppMethodBeat.m2505o(19065);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19066);
        C4990ab.m7417i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        C11640b c11640b = new C11640b();
        c11640b.lqz = i2;
        c11640b.lqL = i;
        c11640b.hxN = str;
        c11640b.lqM = c1207m;
        this.mHandler.obtainMessage(2, c11640b).sendToTarget();
        AppMethodBeat.m2505o(19066);
    }
}
