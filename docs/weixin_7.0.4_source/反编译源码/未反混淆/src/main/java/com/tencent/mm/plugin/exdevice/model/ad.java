package com.tencent.mm.plugin.exdevice.model;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.at.o;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bz;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.plugin.exdevice.f.b.b.a;
import com.tencent.mm.plugin.exdevice.f.b.b.b;
import com.tencent.mm.plugin.exdevice.f.b.b.e;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.i.g;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class ad implements at {
    private static HashMap<Integer, d> eaA;
    private ab lui = new ab();
    private b luj;
    private c luk;
    private com.tencent.mm.plugin.exdevice.f.b.b.d lul;
    private a lum;
    private b lun;
    private e luo;
    private e lup;
    private d luq;
    private com.tencent.mm.plugin.exdevice.f.b.c lur;
    private com.tencent.mm.plugin.exdevice.f.b.a lus;
    private com.tencent.mm.plugin.exdevice.f.a.c lut;
    private com.tencent.mm.at.a.a luu = null;
    private com.tencent.mm.at.a.a.c luv = null;
    private af luw;
    private h lux;
    private bz.a luy = new bz.a() {
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0031  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(19382);
            if (ad.bpc() != null) {
                Object obj;
                ad.bpc();
                cm cmVar = aVar.eAB;
                ab.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
                String a = aa.a(cmVar.vED);
                if (bo.isNullOrNil(a)) {
                    ab.e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
                } else {
                    Map z = br.z(a, "sysmsg");
                    if (z != null && z.size() > 0) {
                        a = (String) z.get(".sysmsg.$type");
                        if (!bo.isNullOrNil(a) && a.equalsIgnoreCase("wcdevicemsg")) {
                            a = (String) z.get(".sysmsg.wcdevicemsg.xml.ToUserName");
                            String str = (String) z.get(".sysmsg.wcdevicemsg.xml.FromUserName");
                            long j = bo.getLong((String) z.get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1);
                            String str2 = (String) z.get(".sysmsg.wcdevicemsg.xml.MsgType");
                            String str3 = (String) z.get(".sysmsg.wcdevicemsg.xml.DeviceType");
                            String str4 = (String) z.get(".sysmsg.wcdevicemsg.xml.DeviceID");
                            int i = bo.getInt((String) z.get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
                            ab.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + a + ",fromuser=" + str + ",createtime=" + j + ",msgtype=" + str2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
                            com.tencent.mm.plugin.exdevice.h.b Kv = ad.boW().Kv(str4);
                            if (Kv != null && bo.nullAsNil(Kv.field_connProto).contains("4") && bo.nullAsNil(str2).contains("device_status")) {
                                if (i != 0) {
                                    ad.bph();
                                    e.b(Kv.field_brandName, Kv.field_url, 2, Kv.field_deviceID);
                                } else {
                                    ad.bph();
                                    e.b(Kv.field_brandName, Kv.field_url, 4, Kv.field_deviceID);
                                }
                                obj = 1;
                                if (obj == null) {
                                    a = aa.a(cmVar.vED);
                                    if (bo.isNullOrNil(a)) {
                                        ab.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                                        AppMethodBeat.o(19382);
                                        return;
                                    }
                                    Map z2 = br.z(a, "sysmsg");
                                    if (z2 == null || z2.size() <= 0) {
                                        ab.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
                                        AppMethodBeat.o(19382);
                                        return;
                                    }
                                    a = (String) z2.get(".sysmsg.$type");
                                    if (bo.isNullOrNil(a) || !a.equalsIgnoreCase("wcdevicemsg")) {
                                        ab.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
                                        AppMethodBeat.o(19382);
                                        return;
                                    }
                                    ab.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", bo.nullAsNil((String) z2.get(".sysmsg.wcdevicemsg.xml.MsgType")));
                                    if (bo.nullAsNil((String) z2.get(".sysmsg.wcdevicemsg.xml.MsgType")).equals("device_relation")) {
                                        dk dkVar = new dk();
                                        dkVar.cwH.cwI = true;
                                        com.tencent.mm.sdk.b.a.xxA.m(dkVar);
                                        AppMethodBeat.o(19382);
                                        return;
                                    }
                                    a = (String) z2.get(".sysmsg.wcdevicemsg.xml.Content");
                                    ab.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", a);
                                    if (bo.isNullOrNil(a)) {
                                        ab.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
                                        AppMethodBeat.o(19382);
                                        return;
                                    }
                                    try {
                                        byte[] decode = Base64.decode(a, 0);
                                        if (bo.cb(decode)) {
                                            ab.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
                                            AppMethodBeat.o(19382);
                                            return;
                                        }
                                        long j2 = bo.getLong((String) z2.get(".sysmsg.wcdevicemsg.xml.SessionID"), -1);
                                        ab.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", Long.valueOf(j2), (String) z2.get(".sysmsg.wcdevicemsg.xml.DeviceID"), a, Integer.valueOf(decode.length));
                                        Kv = ad.boW().Kv(str);
                                        if (Kv == null) {
                                            ab.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                                            AppMethodBeat.o(19382);
                                            return;
                                        } else if (0 == j2) {
                                            u.bpy().a(new g(decode, 0, Kv.field_mac));
                                            AppMethodBeat.o(19382);
                                            return;
                                        } else {
                                            k bow = k.bow();
                                            ab.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", Long.valueOf(j2));
                                            Assert.assertTrue(j2 >= 0);
                                            k.c cVar = new k.c();
                                            cVar.mSessionId = j2;
                                            cVar.mData = decode;
                                            bow.mHandler.obtainMessage(3, cVar).sendToTarget();
                                        }
                                    } catch (Exception e) {
                                        ab.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", e.getMessage());
                                        ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", e, "", new Object[0]);
                                        AppMethodBeat.o(19382);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                }
            }
            AppMethodBeat.o(19382);
        }
    };
    n.b luz = new n.b() {
        public final void a(int i, n nVar, final Object obj) {
            AppMethodBeat.i(19384);
            try {
                if (aw.RK()) {
                    if (obj instanceof String) {
                        aw.RS().m(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(19383);
                                String str = (String) obj;
                                if (ad.boY().Kp(str)) {
                                    aw.ZK();
                                    if (!com.tencent.mm.model.c.XM().aoJ(str)) {
                                        aw.Rg().a(new h(str, null), 0);
                                    }
                                }
                                AppMethodBeat.o(19383);
                            }
                        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    }
                    AppMethodBeat.o(19384);
                    return;
                }
                ab.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
                AppMethodBeat.o(19384);
            } catch (Exception e) {
                ab.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", e.getMessage());
                AppMethodBeat.o(19384);
            }
        }
    };

    static {
        AppMethodBeat.i(19405);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("HARDDEVICEINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return c.fnj;
            }
        });
        eaA.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.exdevice.f.b.b.d.fnj;
            }
        });
        eaA.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return a.fnj;
            }
        });
        eaA.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return e.fnj;
            }
        });
        eaA.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        eaA.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.exdevice.f.b.b.c.fnj;
            }
        });
        AppMethodBeat.o(19405);
    }

    public ad() {
        AppMethodBeat.i(19386);
        if (this.luq == null) {
            this.luq = new d();
        }
        if (this.lup == null) {
            this.lup = new e();
        }
        ab.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
        com.tencent.mm.sdk.b.a.xxA.c(this.lup.lrZ);
        AppMethodBeat.o(19386);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    private static ad boV() {
        AppMethodBeat.i(19387);
        aw.ZE();
        ad adVar = (ad) bw.oJ("plugin.exdevice");
        if (adVar == null) {
            ab.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
            adVar = new ad();
            aw.ZE().a("plugin.exdevice", adVar);
        }
        AppMethodBeat.o(19387);
        return adVar;
    }

    public static c boW() {
        AppMethodBeat.i(19388);
        com.tencent.mm.kernel.g.RN().QU();
        if (boV().luk == null) {
            ad boV = boV();
            aw.ZK();
            boV.luk = new c(com.tencent.mm.model.c.Ru());
        }
        c cVar = boV().luk;
        AppMethodBeat.o(19388);
        return cVar;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.b.d boX() {
        AppMethodBeat.i(19389);
        com.tencent.mm.kernel.g.RN().QU();
        if (boV().lul == null) {
            ad boV = boV();
            aw.ZK();
            boV.lul = new com.tencent.mm.plugin.exdevice.f.b.b.d(com.tencent.mm.model.c.Ru());
        }
        com.tencent.mm.plugin.exdevice.f.b.b.d dVar = boV().lul;
        AppMethodBeat.o(19389);
        return dVar;
    }

    public static a boY() {
        AppMethodBeat.i(19390);
        com.tencent.mm.kernel.g.RN().QU();
        if (boV().lum == null) {
            ad boV = boV();
            aw.ZK();
            boV.lum = new a(com.tencent.mm.model.c.Ru());
        }
        a aVar = boV().lum;
        AppMethodBeat.o(19390);
        return aVar;
    }

    public static com.tencent.mm.at.a.a boZ() {
        AppMethodBeat.i(19391);
        if (boV().luu == null) {
            boV().luu = o.ahp();
        }
        com.tencent.mm.at.a.a aVar = boV().luu;
        AppMethodBeat.o(19391);
        return aVar;
    }

    public static com.tencent.mm.at.a.a.c Kk(String str) {
        AppMethodBeat.i(19392);
        com.tencent.mm.at.a.a.c cVar;
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
            ad boV = boV();
            if (boV.luv == null) {
                com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                o.ahq();
                aVar.ePY = null;
                aVar.ePO = 640;
                aVar.ePN = 640;
                aVar.ePF = false;
                aVar.ePH = true;
                boV.luv = aVar.ahG();
            }
            cVar = boV().luv;
            AppMethodBeat.o(19392);
            return cVar;
        }
        com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
        aVar2.ePO = 640;
        aVar2.ePN = 640;
        aVar2.ePF = false;
        aVar2.ePG = true;
        aw.ZK();
        aVar2.ePK = com.tencent.mm.model.c.XW();
        cVar = aVar2.ahG();
        AppMethodBeat.o(19392);
        return cVar;
    }

    public static b bpa() {
        AppMethodBeat.i(19393);
        com.tencent.mm.kernel.g.RN().QU();
        if (boV().lun == null) {
            ad boV = boV();
            aw.ZK();
            boV.lun = new b(com.tencent.mm.model.c.Ru());
        }
        b bVar = boV().lun;
        AppMethodBeat.o(19393);
        return bVar;
    }

    public static e bpb() {
        AppMethodBeat.i(19394);
        com.tencent.mm.kernel.g.RN().QU();
        if (boV().luo == null) {
            ad boV = boV();
            aw.ZK();
            boV.luo = new e(com.tencent.mm.model.c.Ru());
        }
        e eVar = boV().luo;
        AppMethodBeat.o(19394);
        return eVar;
    }

    public static b bpc() {
        AppMethodBeat.i(19395);
        com.tencent.mm.kernel.g.RN().QU();
        if (boV().luj == null) {
            boV().luj = new b();
        }
        b bVar = boV().luj;
        AppMethodBeat.o(19395);
        return bVar;
    }

    public static d bpd() {
        AppMethodBeat.i(19396);
        if (boV().luq == null) {
            boV().luq = new d();
        }
        d dVar = boV().luq;
        AppMethodBeat.o(19396);
        return dVar;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.c bpe() {
        AppMethodBeat.i(19397);
        if (boV().lur == null) {
            boV().lur = new com.tencent.mm.plugin.exdevice.f.b.c();
        }
        com.tencent.mm.plugin.exdevice.f.b.c cVar = boV().lur;
        AppMethodBeat.o(19397);
        return cVar;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.a bpf() {
        AppMethodBeat.i(19398);
        if (boV().lus == null) {
            boV().lus = new com.tencent.mm.plugin.exdevice.f.b.a();
        }
        com.tencent.mm.plugin.exdevice.f.b.a aVar = boV().lus;
        AppMethodBeat.o(19398);
        return aVar;
    }

    public static com.tencent.mm.plugin.exdevice.f.a.c bpg() {
        AppMethodBeat.i(19399);
        if (boV().lut == null) {
            boV().lut = new com.tencent.mm.plugin.exdevice.f.a.c();
        }
        com.tencent.mm.plugin.exdevice.f.a.c cVar = boV().lut;
        AppMethodBeat.o(19399);
        return cVar;
    }

    public static e bph() {
        AppMethodBeat.i(19400);
        if (boV().lup == null) {
            boV().lup = new e();
        }
        e eVar = boV().lup;
        AppMethodBeat.o(19400);
        return eVar;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(19401);
        aw.ZK();
        com.tencent.mm.model.c.XM().a(this.luz);
        aw.Rg().a(538, k.bow());
        this.luw = new af();
        com.tencent.mm.sdk.b.a.xxA.c(this.lui);
        aw.getSysCmdMsgExtension().a("wcdevicemsg", this.luy, true);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrA);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrB);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrC);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrV);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrz);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lry);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrD);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrE);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrF);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrW);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrG);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrH);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrI);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrK);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrJ);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrO);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrM);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrN);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrP);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrX);
        com.tencent.mm.sdk.b.a.xxA.c(bph().jDf);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrL);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrQ);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrR);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrS);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrT);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lsh);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lsi);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lsj);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lsl);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lsk);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lsa);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lsb);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lsc);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lsd);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lse);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lsg);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrY);
        com.tencent.mm.sdk.b.a.xxA.c(bph().lrZ);
        f fVar = i.lto;
        ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
        aw.Rg().a(539, fVar);
        com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a() {
            public final void run() {
                AppMethodBeat.i(19385);
                ad.a(ad.this);
                AppMethodBeat.o(19385);
            }
        });
        AppMethodBeat.o(19401);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(19402);
        aw.ZK();
        com.tencent.mm.model.c.XM().b(this.luz);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrA);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrB);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrC);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrV);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrX);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrz);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lry);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrD);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrE);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrF);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrW);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lsh);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lsi);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lsj);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lsl);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lsk);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lsa);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lsb);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lsc);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lsd);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lse);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lsg);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrH);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrY);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrZ);
        ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
        } else if (!sharedPreferences.edit().clear().commit()) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
        }
        com.tencent.mm.plugin.exdevice.service.f bpx = u.bpx();
        ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
        if (bpx.lwJ == null) {
            ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
        } else {
            for (Entry entry : bpx.lwJ.entrySet()) {
                com.tencent.mm.plugin.exdevice.service.f.a aVar = (com.tencent.mm.plugin.exdevice.service.f.a) entry.getValue();
                aVar.lwN = false;
                entry.setValue(aVar);
            }
        }
        aw.Rg().b(538, k.bow());
        k.lqI = null;
        com.tencent.mm.sdk.b.a.xxA.d(this.lui);
        aw.getSysCmdMsgExtension().b("wcdevicemsg", this.luy, true);
        com.tencent.mm.sdk.b.a.xxA.d(bph().lrG);
        if (boV().luj != null) {
            boV();
        }
        f fVar = i.lto;
        ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
        aw.Rg().b(539, fVar);
        d dVar = boV().luq;
        if (!(dVar.lre == null || dVar.lre.isEmpty())) {
            for (Entry entry2 : dVar.lre.entrySet()) {
                ((ap) entry2.getValue()).stopTimer();
            }
            dVar.lre.clear();
        }
        if (boV().lur != null) {
            fVar = boV().lur;
            aw.Rg().b(1042, fVar);
            aw.Rg().b(1041, fVar);
            aw.Rg().b((int) FilterEnum4Shaka.MIC_SHAKA_ADD2_8, fVar);
            aw.Rg().b(1040, fVar);
        }
        if (boV().luu != null) {
            boV().luu.detach();
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.luw.ecA);
        AppMethodBeat.o(19402);
    }

    public static h bpi() {
        AppMethodBeat.i(19403);
        if (boV().lux == null) {
            boV().lux = new h();
        }
        h hVar = boV().lux;
        AppMethodBeat.o(19403);
        return hVar;
    }

    static /* synthetic */ void a(ad adVar) {
        AppMethodBeat.i(19404);
        try {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(19381);
                    boolean hasSystemFeature = ah.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
                    boolean hasSystemFeature2 = ah.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
                    if (hasSystemFeature && hasSystemFeature2) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(11891, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, true, true);
                    } else if (hasSystemFeature) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(11891, "1", true, true);
                    } else if (hasSystemFeature2) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(11891, "2", true, true);
                    }
                    ab.i("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] deviceFeatures stepCounter %s, stepDetector %s", Boolean.valueOf(hasSystemFeature), Boolean.valueOf(hasSystemFeature2));
                    AppMethodBeat.o(19381);
                }
            }, 30000);
            AppMethodBeat.o(19404);
        } catch (Exception e) {
            ab.e("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] exception in deviceFeaturesKVStat, %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.SubCoreExDevice", e, "", new Object[0]);
            AppMethodBeat.o(19404);
        }
    }
}
