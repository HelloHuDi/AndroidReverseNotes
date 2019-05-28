package com.tencent.p177mm.plugin.appbrand.p896i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C45446k;
import com.tencent.p177mm.modelappbrand.C45446k.C26437a;
import com.tencent.p177mm.p181af.p1175a.C17871b;
import com.tencent.p177mm.p181af.p1175a.C25745c;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.protocal.protobuf.C35901ape;
import com.tencent.p177mm.protocal.protobuf.apf;
import com.tencent.p177mm.protocal.protobuf.bzk;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.mm.plugin.appbrand.i.e */
public final class C38240e implements C45446k {
    private static Map<String, Object> inw = new HashMap();
    private static Map<String, List<C26905a>> inx = new HashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.i.e$b */
    public enum C10267b {
        ;
        
        private AtomicBoolean cnv;
        Map<Integer, C26905a> inB;
        private Runnable inC;

        /* renamed from: com.tencent.mm.plugin.appbrand.i.e$b$1 */
        class C102681 implements Runnable {
            C102681() {
            }

            public final void run() {
                AppMethodBeat.m2504i(132279);
                LinkedList linkedList = new LinkedList();
                for (C26905a c26905a : C10267b.this.inB.values()) {
                    if (c26905a.aIv()) {
                        bzk bzk = new bzk();
                        bzk.wYs = c26905a.bQi;
                        bzk.csB = c26905a.appId;
                        linkedList.add(bzk);
                    }
                }
                C10267b c10267b = C10267b.this;
                if (linkedList.size() <= 0) {
                    C4990ab.m7410d("MicroMsg.WxaUpdateableMsgService", "shareKeyInfoList is null, return");
                    c10267b.aIx();
                    AppMethodBeat.m2505o(132279);
                    return;
                }
                C4990ab.m7411d("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg shareKeyInfoList.size:%d", Integer.valueOf(linkedList.size()));
                C1196a c1196a = new C1196a();
                c1196a.fsI = 2954;
                c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getupdatablemsginfo";
                C35901ape c35901ape = new C35901ape();
                c35901ape.wtf = linkedList;
                c1196a.fsJ = c35901ape;
                c1196a.fsK = new apf();
                C1226w.m2654a(c1196a.acD(), new C102692());
                AppMethodBeat.m2505o(132279);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.i.e$b$2 */
        class C102692 implements C1224a {
            C102692() {
            }

            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(132280);
                apf apf = (apf) c7472b.fsH.fsP;
                C4990ab.m7417i("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (i == 0 && i2 == 0 && apf.wtg != null && apf.wtg.size() > 0) {
                    C4990ab.m7417i("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg response.updatable_msg_list.size:%d", Integer.valueOf(apf.wtg.size()));
                    C10267b.m17918a(C10267b.this, apf);
                    C10267b.m17919a(apf);
                    C10267b.m17921b(C10267b.this, apf);
                    C10267b.m17920b(C10267b.this);
                }
                AppMethodBeat.m2505o(132280);
                return 0;
            }
        }

        private C10267b(String str) {
            AppMethodBeat.m2504i(132283);
            this.inB = new ConcurrentHashMap();
            this.cnv = new AtomicBoolean(true);
            this.inC = new C102681();
            AppMethodBeat.m2505o(132283);
        }

        static {
            AppMethodBeat.m2505o(132291);
        }

        public final synchronized void start() {
            AppMethodBeat.m2504i(132284);
            this.cnv.set(false);
            aIx();
            AppMethodBeat.m2505o(132284);
        }

        public final synchronized void stop() {
            AppMethodBeat.m2504i(132285);
            this.cnv.set(true);
            AppMethodBeat.m2505o(132285);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void aIx() {
            boolean z = false;
            boolean z2 = true;
            synchronized (this) {
                AppMethodBeat.m2504i(132286);
                C1720g.m3539RS();
                C5004al.m7439af(this.inC);
                if (this.cnv.get()) {
                    C4990ab.m7410d("MicroMsg.WxaUpdateableMsgService", "isPause, not sendUpdatableMsgRequest");
                    AppMethodBeat.m2505o(132286);
                } else if (this.inB.size() <= 0) {
                    C4990ab.m7410d("MicroMsg.WxaUpdateableMsgService", "sGetUpdatableMsgWorkerMap is empty, not sendUpdatableMsgRequest");
                    AppMethodBeat.m2505o(132286);
                } else {
                    long j;
                    long j2 = Long.MAX_VALUE;
                    for (C26905a c26905a : this.inB.values()) {
                        if (c26905a.aIv()) {
                            j = 0;
                            break;
                        } else if (c26905a.iny >= 0) {
                            j2 = Math.min((long) c26905a.iny, j2);
                            z = true;
                        }
                    }
                    j = j2;
                    z2 = z;
                    C4990ab.m7411d("MicroMsg.WxaUpdateableMsgService", "needUpdate:%b minDelayTime:%d", Boolean.valueOf(z2), Long.valueOf(j));
                    if (z2) {
                        C1720g.m3539RS().mo10310m(this.inC, j * 1000);
                        AppMethodBeat.m2505o(132286);
                    } else {
                        AppMethodBeat.m2505o(132286);
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i.e$a */
    static class C26905a {
        public String appId;
        public String bQi;
        public int iny;
        public C26437a inz;
        public long lastUpdateTime;

        private C26905a() {
        }

        /* synthetic */ C26905a(byte b) {
            this();
        }

        public final boolean aIv() {
            AppMethodBeat.m2504i(132277);
            if (this.iny < 0) {
                AppMethodBeat.m2505o(132277);
                return false;
            } else if (this.iny == 0) {
                if (aIw() > 10000) {
                    AppMethodBeat.m2505o(132277);
                    return true;
                }
                AppMethodBeat.m2505o(132277);
                return false;
            } else if (aIw() > ((long) this.iny) * 1000) {
                AppMethodBeat.m2505o(132277);
                return true;
            } else {
                AppMethodBeat.m2505o(132277);
                return false;
            }
        }

        private long aIw() {
            AppMethodBeat.m2504i(132278);
            C4990ab.m7411d("MicroMsg.WxaUpdateableMsgService", "consumeTime:%d", Long.valueOf(System.currentTimeMillis() - this.lastUpdateTime));
            AppMethodBeat.m2505o(132278);
            return System.currentTimeMillis() - this.lastUpdateTime;
        }
    }

    static {
        AppMethodBeat.m2504i(132299);
        AppMethodBeat.m2505o(132299);
    }

    /* renamed from: pn */
    public final C17871b mo60978pn(String str) {
        AppMethodBeat.m2504i(132292);
        C25745c auS = C42340f.auS();
        if (auS == null) {
            C4990ab.m7412e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null");
            AppMethodBeat.m2505o(132292);
            return null;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WxaUpdateableMsgService", "shareKey is null, return");
            AppMethodBeat.m2505o(132292);
            return null;
        } else {
            int hashCode = str.hashCode();
            C17871b c17871b = new C17871b();
            c17871b.field_shareKeyHash = hashCode;
            if (!auS.mo10102b((C4925c) c17871b, "shareKeyHash")) {
                C4990ab.m7412e("MicroMsg.WxaUpdateableMsgStorage", "WxaUpdateableMsg is null");
                c17871b = null;
            }
            if (c17871b == null) {
                C4990ab.m7413e("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, wxaUpdateableMsg is null", str, Integer.valueOf(str.hashCode()));
                AppMethodBeat.m2505o(132292);
                return null;
            }
            C4990ab.m7411d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d status:%s", str, Integer.valueOf(str.hashCode()), Integer.valueOf(c17871b.field_btnState));
            AppMethodBeat.m2505o(132292);
            return c17871b;
        }
    }

    /* renamed from: T */
    public final boolean mo60973T(String str, int i) {
        AppMethodBeat.m2504i(132293);
        C25745c auS = C42340f.auS();
        if (auS == null) {
            C4990ab.m7412e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
            AppMethodBeat.m2505o(132293);
            return false;
        }
        boolean z;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
            z = false;
        } else {
            C17871b c17871b = new C17871b();
            c17871b.field_shareKeyHash = str.hashCode();
            boolean b = auS.mo10102b((C4925c) c17871b, new String[0]);
            c17871b.field_btnState = i;
            z = b ? auS.mo10103c(c17871b, new String[0]) : auS.mo10101b((C4925c) c17871b);
        }
        C4990ab.m7411d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, btnState:%d isOk:%b", str, Integer.valueOf(str.hashCode()), Integer.valueOf(i), Boolean.valueOf(z));
        if (z) {
            inw.get(str);
        }
        AppMethodBeat.m2505o(132293);
        return z;
    }

    /* renamed from: a */
    public final boolean mo60975a(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(132294);
        C25745c auS = C42340f.auS();
        if (auS == null) {
            C4990ab.m7412e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
            AppMethodBeat.m2505o(132294);
            return false;
        }
        boolean z;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
            z = false;
        } else {
            C17871b c17871b = new C17871b();
            c17871b.field_shareKeyHash = str.hashCode();
            boolean b = auS.mo10102b((C4925c) c17871b, new String[0]);
            c17871b.field_updatePeroid = i;
            c17871b.field_msgState = i2;
            c17871b.field_content = str2;
            c17871b.field_contentColor = str3;
            z = b ? auS.mo10103c(c17871b, new String[0]) : auS.mo10101b((C4925c) c17871b);
        }
        C4990ab.m7411d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, content:%s contentColor:%s isOk:%b", str, Integer.valueOf(str.hashCode()), str2, str3, Boolean.valueOf(z));
        AppMethodBeat.m2505o(132294);
        return z;
    }

    /* renamed from: a */
    public final synchronized void mo60974a(String str, String str2, String str3, int i, C26437a c26437a) {
        AppMethodBeat.m2504i(132295);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
            C4990ab.m7412e("MicroMsg.WxaUpdateableMsgService", "token appId or shareKey is null, return");
            AppMethodBeat.m2505o(132295);
        } else {
            List list = (List) inx.get(str);
            if (list == null) {
                C4990ab.m7417i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange token:%s", str);
                list = new ArrayList();
                inx.put(str, list);
            }
            C4990ab.m7417i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKeyHash:%d", Integer.valueOf(str3.hashCode()));
            C4990ab.m7411d("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKey:%s", str3);
            C26905a c26905a = new C26905a();
            c26905a.appId = str2;
            c26905a.bQi = str3;
            c26905a.iny = i;
            c26905a.inz = c26437a;
            if (C5046bo.isNullOrNil(c26905a.appId) || C5046bo.isNullOrNil(c26905a.bQi)) {
                C4990ab.m7420w("MicroMsg.WxaUpdateableMsgService", "appId or shareKey is null, return");
            } else {
                C4990ab.m7411d("MicroMsg.WxaUpdateableMsgService", "[addWorker]getUpdatableMsgWorkerList size:%d", Integer.valueOf(C10267b.inA.inB.size()));
                r2.inB.put(Integer.valueOf(c26905a.bQi.hashCode()), c26905a);
            }
            list.add(c26905a);
            AppMethodBeat.m2505o(132295);
        }
    }

    /* renamed from: po */
    public final synchronized void mo60979po(String str) {
        AppMethodBeat.m2504i(132296);
        C4990ab.m7417i("MicroMsg.WxaUpdateableMsgService", "removeOnUpdatbleMsgInfoChange token:%s", str);
        List<C26905a> list = (List) inx.get(str);
        if (list == null) {
            C4990ab.m7420w("MicroMsg.WxaUpdateableMsgService", "[removeOnUpdatbleMsgInfoChange]getUpdatableMsgWorkers is null, err");
            AppMethodBeat.m2505o(132296);
        } else {
            for (C26905a c26905a : list) {
                C4990ab.m7411d("MicroMsg.WxaUpdateableMsgService", "[removeWorker]getUpdatableMsgWorkerList size:%d", Integer.valueOf(C10267b.inA.inB.size()));
                r2.inB.remove(Integer.valueOf(c26905a.bQi.hashCode()));
            }
            inx.remove(str);
            AppMethodBeat.m2505o(132296);
        }
    }

    public final void abC() {
        AppMethodBeat.m2504i(132297);
        C4990ab.m7416i("MicroMsg.WxaUpdateableMsgService", "startUpdatbleMsgInfoChange");
        C10267b.inA.start();
        AppMethodBeat.m2505o(132297);
    }

    public final void abD() {
        AppMethodBeat.m2504i(132298);
        C4990ab.m7416i("MicroMsg.WxaUpdateableMsgService", "stopOnUpdatbleMsgInfoChange");
        C10267b.inA.stop();
        AppMethodBeat.m2505o(132298);
    }
}
