package com.tencent.mm.plugin.exdevice.b;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.i.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import junit.framework.Assert;

public final class k implements com.tencent.mm.ai.f {
    public static k lqI = null;
    private final HashMap<Long, e> lqH;
    public HashMap<String, Integer> lqJ;
    public ak mHandler;

    public static final class c {
        public byte[] mData;
        public long mSessionId;

        private c() {
            this.mSessionId = 0;
            this.mData = null;
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }

    final class d implements Runnable {
        private long lqN = -1;

        public d(long j) {
            AppMethodBeat.i(19055);
            Assert.assertTrue(j >= 0);
            this.lqN = j;
            AppMethodBeat.o(19055);
        }

        public final void run() {
            AppMethodBeat.i(19056);
            ab.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", Long.valueOf(this.lqN));
            k.this.mHandler.obtainMessage(0, Long.valueOf(this.lqN)).sendToTarget();
            AppMethodBeat.o(19056);
        }
    }

    static final class e {
        f lqO;
        private d lqP;
        int lqQ;

        private e() {
            this.lqO = null;
            this.lqP = null;
            this.lqQ = 0;
        }

        /* synthetic */ e(byte b) {
            this();
        }

        public final void a(f fVar) {
            AppMethodBeat.i(19057);
            Assert.assertNotNull(fVar);
            this.lqO = fVar;
            AppMethodBeat.o(19057);
        }

        public final void a(d dVar) {
            AppMethodBeat.i(19058);
            Assert.assertNotNull(dVar);
            this.lqP = dVar;
            AppMethodBeat.o(19058);
        }

        public final f box() {
            AppMethodBeat.i(19059);
            Assert.assertNotNull(this.lqO);
            f fVar = this.lqO;
            AppMethodBeat.o(19059);
            return fVar;
        }

        public final d boy() {
            AppMethodBeat.i(19060);
            Assert.assertNotNull(this.lqP);
            d dVar = this.lqP;
            AppMethodBeat.o(19060);
            return dVar;
        }
    }

    public static final class f {
        private static f lqS = null;
        private long lqR;

        public f() {
            long j = 0;
            AppMethodBeat.i(19061);
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("local_message_seq", 0);
                ab.i("MicroMsg.exdevice.Util", "lasted seq id is %d", Long.valueOf(j));
            }
            this.lqR = j;
            AppMethodBeat.o(19061);
        }

        public static long boz() {
            AppMethodBeat.i(19062);
            if (lqS == null) {
                lqS = new f();
            }
            f fVar = lqS;
            if (Long.MAX_VALUE == fVar.lqR) {
                ab.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
                fVar.lqR = 0;
            }
            long j = fVar.lqR + 1;
            fVar.lqR = j;
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                ab.i("MicroMsg.exdevice.Util", "save locall seq id : %d", Long.valueOf(j));
                sharedPreferences.edit().putLong("local_message_seq", j).commit();
            }
            AppMethodBeat.o(19062);
            return j;
        }
    }

    static final class b {
        public String hxN;
        public int lqL;
        public m lqM;
        public int lqz;

        private b() {
            this.lqz = 0;
            this.lqL = 0;
            this.hxN = null;
            this.lqM = null;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    class a extends ak {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(19054);
            ab.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", Integer.valueOf(message.what));
            e eVar;
            switch (message.what) {
                case 0:
                    long longValue = ((Long) message.obj).longValue();
                    e eVar2 = (e) k.this.lqH.get(Long.valueOf(longValue));
                    if (eVar2 == null) {
                        ab.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", Long.valueOf(longValue));
                        AppMethodBeat.o(19054);
                        return;
                    }
                    eVar2.box().f(-1, "", null);
                    u.bpy().a(new h(eVar2.box()));
                    k.this.lqH.remove(Long.valueOf(longValue));
                    AppMethodBeat.o(19054);
                    return;
                case 1:
                    f fVar = (f) message.obj;
                    if (!u.bpx().hX(fVar.jJa)) {
                        ab.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", Long.valueOf(fVar.jJa));
                        fVar.f(-2, "", new byte[0]);
                        u.bpy().a(new h(fVar));
                        AppMethodBeat.o(19054);
                        return;
                    } else if (-5 == message.arg1 || -3 == message.arg1 || -4 == message.arg1) {
                        ab.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", Integer.valueOf(message.arg1));
                        fVar.f(-1, "", new byte[0]);
                        u.bpy().a(new h(fVar));
                        AppMethodBeat.o(19054);
                        return;
                    } else {
                        com.tencent.mm.plugin.exdevice.h.b Ku = ad.boW().Ku(fVar.jJa);
                        if (Ku == null) {
                            ab.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                            AppMethodBeat.o(19054);
                            return;
                        }
                        if (System.currentTimeMillis() / 1000 < ((long) Ku.dFi)) {
                            ab.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
                            fVar.f(-5, "Device Is Block", null);
                            u.bpy().a(new h(fVar));
                            AppMethodBeat.o(19054);
                            return;
                        }
                        long boz = f.boz();
                        com.tencent.mm.plugin.exdevice.e.k kVar = (com.tencent.mm.plugin.exdevice.e.k) fVar.bou();
                        if (kVar == null) {
                            ab.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
                            fVar.f(-4, "Decode failed", null);
                            u.bpy().a(new h(fVar));
                            AppMethodBeat.o(19054);
                            return;
                        }
                        Integer num = (Integer) k.this.lqJ.get(Ku.field_deviceID);
                        if (num == null) {
                            num = Integer.valueOf(0);
                        }
                        ab.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", num);
                        d dVar;
                        e eVar3;
                        if (num.intValue() != 0) {
                            if ((num.intValue() & 1) != 0) {
                                ad.bph();
                                com.tencent.mm.plugin.exdevice.model.e.d(Ku.field_deviceID, Ku.field_brandName, kVar.jBi.toByteArray());
                            }
                            if ((num.intValue() & 2) != 0) {
                                aw.Rg().a(new w(fVar.jJa, Ku.field_deviceType, Ku.field_deviceID, boz, bo.anU(), kVar.jBi.toByteArray(), kVar.jCt), 0);
                                dVar = new d(boz);
                                k.this.mHandler.postDelayed(dVar, 30000);
                                eVar3 = new e();
                                eVar3.a(fVar);
                                eVar3.a(dVar);
                                eVar3.lqQ = 0;
                                k.this.lqH.put(Long.valueOf(boz), eVar3);
                            }
                            AppMethodBeat.o(19054);
                            return;
                        } else if (kVar.jCt == 10001) {
                            ad.bph();
                            com.tencent.mm.plugin.exdevice.model.e.d(Ku.field_deviceID, Ku.field_brandName, kVar.jBi.toByteArray());
                            AppMethodBeat.o(19054);
                            return;
                        } else {
                            aw.Rg().a(new w(fVar.jJa, Ku.field_deviceType, Ku.field_deviceID, boz, bo.anU(), kVar.jBi.toByteArray(), kVar.jCt), 0);
                            dVar = new d(boz);
                            k.this.mHandler.postDelayed(dVar, 30000);
                            eVar3 = new e();
                            eVar3.a(fVar);
                            eVar3.a(dVar);
                            eVar3.lqQ = 0;
                            k.this.lqH.put(Long.valueOf(boz), eVar3);
                            AppMethodBeat.o(19054);
                            return;
                        }
                    }
                case 2:
                    b bVar = (b) message.obj;
                    if (bVar.lqL == 0 && bVar.lqz == 0) {
                        AppMethodBeat.o(19054);
                        return;
                    }
                    w wVar = (w) bVar.lqM;
                    Assert.assertNotNull(wVar.lty);
                    long j = ((bwh) wVar.lty.fsG.fsP).wWW.wwE;
                    eVar = (e) k.this.lqH.get(Long.valueOf(j));
                    if (eVar == null) {
                        ab.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", Long.valueOf(j));
                        AppMethodBeat.o(19054);
                        return;
                    }
                    int i;
                    f box = eVar.box();
                    switch (bVar.lqz) {
                        case -417:
                            i = -5;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    box.f(i, bVar.hxN, null);
                    u.bpy().a(new h(eVar.box()));
                    k.this.mHandler.removeCallbacks(eVar.boy());
                    k.this.lqH.remove(Long.valueOf(j));
                    AppMethodBeat.o(19054);
                    return;
                case 3:
                    c cVar = (c) message.obj;
                    eVar = (e) k.this.lqH.get(Long.valueOf(cVar.mSessionId));
                    if (eVar == null) {
                        ab.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", Long.valueOf(cVar.mSessionId));
                        AppMethodBeat.o(19054);
                        return;
                    }
                    eVar.lqO.f(0, "", cVar.mData);
                    u.bpy().a(new h(eVar.box()));
                    k.this.mHandler.removeCallbacks(eVar.boy());
                    k.this.lqH.remove(Long.valueOf(cVar.mSessionId));
                    AppMethodBeat.o(19054);
                    return;
                default:
                    ab.f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", Integer.valueOf(message.what));
                    AppMethodBeat.o(19054);
                    return;
            }
        }
    }

    public static k bow() {
        AppMethodBeat.i(19063);
        k kVar;
        if (lqI != null) {
            kVar = lqI;
            AppMethodBeat.o(19063);
            return kVar;
        }
        kVar = new k();
        lqI = kVar;
        AppMethodBeat.o(19063);
        return kVar;
    }

    private k() {
        AppMethodBeat.i(19064);
        this.lqH = new HashMap();
        this.mHandler = null;
        this.lqJ = new HashMap();
        this.mHandler = new a(aw.RS().oAl.getLooper());
        AppMethodBeat.o(19064);
    }

    public final void b(int i, long j, int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(19065);
        this.mHandler.obtainMessage(1, i, 0, new f(j, i2, i3, bArr)).sendToTarget();
        AppMethodBeat.o(19065);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19066);
        ab.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        b bVar = new b();
        bVar.lqz = i2;
        bVar.lqL = i;
        bVar.hxN = str;
        bVar.lqM = mVar;
        this.mHandler.obtainMessage(2, bVar).sendToTarget();
        AppMethodBeat.o(19066);
    }
}
