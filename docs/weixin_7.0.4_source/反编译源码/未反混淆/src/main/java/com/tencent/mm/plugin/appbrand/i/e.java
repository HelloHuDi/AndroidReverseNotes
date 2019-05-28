package com.tencent.mm.plugin.appbrand.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e implements k {
    private static Map<String, Object> inw = new HashMap();
    private static Map<String, List<a>> inx = new HashMap();

    public enum b {
        ;
        
        private AtomicBoolean cnv;
        Map<Integer, a> inB;
        private Runnable inC;

        private b(String str) {
            AppMethodBeat.i(132283);
            this.inB = new ConcurrentHashMap();
            this.cnv = new AtomicBoolean(true);
            this.inC = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132279);
                    LinkedList linkedList = new LinkedList();
                    for (a aVar : b.this.inB.values()) {
                        if (aVar.aIv()) {
                            bzk bzk = new bzk();
                            bzk.wYs = aVar.bQi;
                            bzk.csB = aVar.appId;
                            linkedList.add(bzk);
                        }
                    }
                    b bVar = b.this;
                    if (linkedList.size() <= 0) {
                        ab.d("MicroMsg.WxaUpdateableMsgService", "shareKeyInfoList is null, return");
                        bVar.aIx();
                        AppMethodBeat.o(132279);
                        return;
                    }
                    ab.d("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg shareKeyInfoList.size:%d", Integer.valueOf(linkedList.size()));
                    com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
                    aVar2.fsI = 2954;
                    aVar2.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getupdatablemsginfo";
                    ape ape = new ape();
                    ape.wtf = linkedList;
                    aVar2.fsJ = ape;
                    aVar2.fsK = new apf();
                    w.a(aVar2.acD(), new com.tencent.mm.ai.w.a() {
                        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                            AppMethodBeat.i(132280);
                            apf apf = (apf) bVar.fsH.fsP;
                            ab.i("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0 && apf.wtg != null && apf.wtg.size() > 0) {
                                ab.i("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg response.updatable_msg_list.size:%d", Integer.valueOf(apf.wtg.size()));
                                b.a(b.this, apf);
                                b.a(apf);
                                b.b(b.this, apf);
                                b.b(b.this);
                            }
                            AppMethodBeat.o(132280);
                            return 0;
                        }
                    });
                    AppMethodBeat.o(132279);
                }
            };
            AppMethodBeat.o(132283);
        }

        static {
            AppMethodBeat.o(132291);
        }

        public final synchronized void start() {
            AppMethodBeat.i(132284);
            this.cnv.set(false);
            aIx();
            AppMethodBeat.o(132284);
        }

        public final synchronized void stop() {
            AppMethodBeat.i(132285);
            this.cnv.set(true);
            AppMethodBeat.o(132285);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void aIx() {
            boolean z = false;
            boolean z2 = true;
            synchronized (this) {
                AppMethodBeat.i(132286);
                g.RS();
                al.af(this.inC);
                if (this.cnv.get()) {
                    ab.d("MicroMsg.WxaUpdateableMsgService", "isPause, not sendUpdatableMsgRequest");
                    AppMethodBeat.o(132286);
                } else if (this.inB.size() <= 0) {
                    ab.d("MicroMsg.WxaUpdateableMsgService", "sGetUpdatableMsgWorkerMap is empty, not sendUpdatableMsgRequest");
                    AppMethodBeat.o(132286);
                } else {
                    long j;
                    long j2 = Long.MAX_VALUE;
                    for (a aVar : this.inB.values()) {
                        if (aVar.aIv()) {
                            j = 0;
                            break;
                        } else if (aVar.iny >= 0) {
                            j2 = Math.min((long) aVar.iny, j2);
                            z = true;
                        }
                    }
                    j = j2;
                    z2 = z;
                    ab.d("MicroMsg.WxaUpdateableMsgService", "needUpdate:%b minDelayTime:%d", Boolean.valueOf(z2), Long.valueOf(j));
                    if (z2) {
                        g.RS().m(this.inC, j * 1000);
                        AppMethodBeat.o(132286);
                    } else {
                        AppMethodBeat.o(132286);
                    }
                }
            }
        }
    }

    static class a {
        public String appId;
        public String bQi;
        public int iny;
        public com.tencent.mm.modelappbrand.k.a inz;
        public long lastUpdateTime;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean aIv() {
            AppMethodBeat.i(132277);
            if (this.iny < 0) {
                AppMethodBeat.o(132277);
                return false;
            } else if (this.iny == 0) {
                if (aIw() > 10000) {
                    AppMethodBeat.o(132277);
                    return true;
                }
                AppMethodBeat.o(132277);
                return false;
            } else if (aIw() > ((long) this.iny) * 1000) {
                AppMethodBeat.o(132277);
                return true;
            } else {
                AppMethodBeat.o(132277);
                return false;
            }
        }

        private long aIw() {
            AppMethodBeat.i(132278);
            ab.d("MicroMsg.WxaUpdateableMsgService", "consumeTime:%d", Long.valueOf(System.currentTimeMillis() - this.lastUpdateTime));
            AppMethodBeat.o(132278);
            return System.currentTimeMillis() - this.lastUpdateTime;
        }
    }

    static {
        AppMethodBeat.i(132299);
        AppMethodBeat.o(132299);
    }

    public final com.tencent.mm.af.a.b pn(String str) {
        AppMethodBeat.i(132292);
        c auS = f.auS();
        if (auS == null) {
            ab.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null");
            AppMethodBeat.o(132292);
            return null;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WxaUpdateableMsgService", "shareKey is null, return");
            AppMethodBeat.o(132292);
            return null;
        } else {
            int hashCode = str.hashCode();
            com.tencent.mm.af.a.b bVar = new com.tencent.mm.af.a.b();
            bVar.field_shareKeyHash = hashCode;
            if (!auS.b((com.tencent.mm.sdk.e.c) bVar, "shareKeyHash")) {
                ab.e("MicroMsg.WxaUpdateableMsgStorage", "WxaUpdateableMsg is null");
                bVar = null;
            }
            if (bVar == null) {
                ab.e("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, wxaUpdateableMsg is null", str, Integer.valueOf(str.hashCode()));
                AppMethodBeat.o(132292);
                return null;
            }
            ab.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d status:%s", str, Integer.valueOf(str.hashCode()), Integer.valueOf(bVar.field_btnState));
            AppMethodBeat.o(132292);
            return bVar;
        }
    }

    public final boolean T(String str, int i) {
        AppMethodBeat.i(132293);
        c auS = f.auS();
        if (auS == null) {
            ab.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
            AppMethodBeat.o(132293);
            return false;
        }
        boolean z;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
            z = false;
        } else {
            com.tencent.mm.af.a.b bVar = new com.tencent.mm.af.a.b();
            bVar.field_shareKeyHash = str.hashCode();
            boolean b = auS.b((com.tencent.mm.sdk.e.c) bVar, new String[0]);
            bVar.field_btnState = i;
            z = b ? auS.c(bVar, new String[0]) : auS.b((com.tencent.mm.sdk.e.c) bVar);
        }
        ab.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, btnState:%d isOk:%b", str, Integer.valueOf(str.hashCode()), Integer.valueOf(i), Boolean.valueOf(z));
        if (z) {
            inw.get(str);
        }
        AppMethodBeat.o(132293);
        return z;
    }

    public final boolean a(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(132294);
        c auS = f.auS();
        if (auS == null) {
            ab.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
            AppMethodBeat.o(132294);
            return false;
        }
        boolean z;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
            z = false;
        } else {
            com.tencent.mm.af.a.b bVar = new com.tencent.mm.af.a.b();
            bVar.field_shareKeyHash = str.hashCode();
            boolean b = auS.b((com.tencent.mm.sdk.e.c) bVar, new String[0]);
            bVar.field_updatePeroid = i;
            bVar.field_msgState = i2;
            bVar.field_content = str2;
            bVar.field_contentColor = str3;
            z = b ? auS.c(bVar, new String[0]) : auS.b((com.tencent.mm.sdk.e.c) bVar);
        }
        ab.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, content:%s contentColor:%s isOk:%b", str, Integer.valueOf(str.hashCode()), str2, str3, Boolean.valueOf(z));
        AppMethodBeat.o(132294);
        return z;
    }

    public final synchronized void a(String str, String str2, String str3, int i, com.tencent.mm.modelappbrand.k.a aVar) {
        AppMethodBeat.i(132295);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.WxaUpdateableMsgService", "token appId or shareKey is null, return");
            AppMethodBeat.o(132295);
        } else {
            List list = (List) inx.get(str);
            if (list == null) {
                ab.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange token:%s", str);
                list = new ArrayList();
                inx.put(str, list);
            }
            ab.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKeyHash:%d", Integer.valueOf(str3.hashCode()));
            ab.d("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKey:%s", str3);
            a aVar2 = new a();
            aVar2.appId = str2;
            aVar2.bQi = str3;
            aVar2.iny = i;
            aVar2.inz = aVar;
            if (bo.isNullOrNil(aVar2.appId) || bo.isNullOrNil(aVar2.bQi)) {
                ab.w("MicroMsg.WxaUpdateableMsgService", "appId or shareKey is null, return");
            } else {
                ab.d("MicroMsg.WxaUpdateableMsgService", "[addWorker]getUpdatableMsgWorkerList size:%d", Integer.valueOf(b.inA.inB.size()));
                r2.inB.put(Integer.valueOf(aVar2.bQi.hashCode()), aVar2);
            }
            list.add(aVar2);
            AppMethodBeat.o(132295);
        }
    }

    public final synchronized void po(String str) {
        AppMethodBeat.i(132296);
        ab.i("MicroMsg.WxaUpdateableMsgService", "removeOnUpdatbleMsgInfoChange token:%s", str);
        List<a> list = (List) inx.get(str);
        if (list == null) {
            ab.w("MicroMsg.WxaUpdateableMsgService", "[removeOnUpdatbleMsgInfoChange]getUpdatableMsgWorkers is null, err");
            AppMethodBeat.o(132296);
        } else {
            for (a aVar : list) {
                ab.d("MicroMsg.WxaUpdateableMsgService", "[removeWorker]getUpdatableMsgWorkerList size:%d", Integer.valueOf(b.inA.inB.size()));
                r2.inB.remove(Integer.valueOf(aVar.bQi.hashCode()));
            }
            inx.remove(str);
            AppMethodBeat.o(132296);
        }
    }

    public final void abC() {
        AppMethodBeat.i(132297);
        ab.i("MicroMsg.WxaUpdateableMsgService", "startUpdatbleMsgInfoChange");
        b.inA.start();
        AppMethodBeat.o(132297);
    }

    public final void abD() {
        AppMethodBeat.i(132298);
        ab.i("MicroMsg.WxaUpdateableMsgService", "stopOnUpdatbleMsgInfoChange");
        b.inA.stop();
        AppMethodBeat.o(132298);
    }
}
