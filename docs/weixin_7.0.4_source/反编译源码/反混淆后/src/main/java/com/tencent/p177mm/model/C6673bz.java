package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3472n;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5035be;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.model.bz */
public final class C6673bz implements C1201e {
    private Map<String, List<C1837a>> fnI = new HashMap();
    private Map<String, List<C1837a>> fnJ = new HashMap();
    private Map<String, List<C3473o>> fnK = new HashMap();
    private Map<String, C3472n> fnL = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.model.bz$a */
    public interface C1837a {
        /* renamed from: a */
        void mo5414a(C1197a c1197a);
    }

    public C6673bz() {
        AppMethodBeat.m2504i(59932);
        AppMethodBeat.m2505o(59932);
    }

    @Deprecated
    /* renamed from: a */
    public final void mo14900a(String str, C1837a c1837a, boolean z) {
        AppMethodBeat.m2504i(59933);
        if (C5046bo.isNullOrNil(str) || c1837a == null) {
            AppMethodBeat.m2505o(59933);
            return;
        }
        List list;
        Map map = z ? this.fnJ : this.fnI;
        synchronized (map) {
            try {
                List list2 = (List) map.get(str);
                if (list2 == null) {
                    LinkedList linkedList = new LinkedList();
                    map.put(str, linkedList);
                    list = linkedList;
                } else {
                    list = list2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(59933);
            }
        }
        synchronized (list) {
            try {
                if (!list.contains(c1837a)) {
                    list.add(c1837a);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(59933);
                }
            }
        }
    }

    @Deprecated
    /* renamed from: b */
    public final void mo14903b(String str, C1837a c1837a, boolean z) {
        AppMethodBeat.m2504i(59934);
        if (C5046bo.isNullOrNil(str) || c1837a == null) {
            AppMethodBeat.m2505o(59934);
            return;
        }
        List list;
        Map map = z ? this.fnJ : this.fnI;
        synchronized (map) {
            try {
                list = (List) map.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(59934);
            }
        }
        if (list != null) {
            synchronized (list) {
                try {
                    list.remove(c1837a);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(59934);
                    }
                }
            }
            return;
        }
        AppMethodBeat.m2505o(59934);
    }

    /* renamed from: a */
    public final void mo14902a(String str, C3473o c3473o) {
        AppMethodBeat.m2504i(59935);
        if (C5046bo.isNullOrNil(str) || c3473o == null) {
            AppMethodBeat.m2505o(59935);
            return;
        }
        List list;
        synchronized (this.fnK) {
            try {
                List list2 = (List) this.fnK.get(str);
                if (list2 == null) {
                    LinkedList linkedList = new LinkedList();
                    this.fnK.put(str, linkedList);
                    list = linkedList;
                } else {
                    list = list2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(59935);
            }
        }
        synchronized (list) {
            try {
                if (!list.contains(c3473o)) {
                    list.add(c3473o);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(59935);
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo14905b(String str, C3473o c3473o) {
        AppMethodBeat.m2504i(59936);
        if (C5046bo.isNullOrNil(str) || c3473o == null) {
            AppMethodBeat.m2505o(59936);
            return;
        }
        List list;
        synchronized (this.fnK) {
            try {
                list = (List) this.fnK.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(59936);
            }
        }
        if (list != null) {
            synchronized (list) {
                try {
                    list.remove(c3473o);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(59936);
                    }
                }
            }
            return;
        }
        AppMethodBeat.m2505o(59936);
    }

    /* renamed from: a */
    public final void mo14901a(String str, C3472n c3472n) {
        AppMethodBeat.m2504i(59937);
        if (C5046bo.isNullOrNil(str) || c3472n == null) {
            AppMethodBeat.m2505o(59937);
            return;
        }
        if (this.fnL.containsKey(str)) {
            C4990ab.m7421w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", str, C5046bo.dpG());
        }
        this.fnL.put(str, c3472n);
        AppMethodBeat.m2505o(59937);
    }

    /* renamed from: b */
    public final void mo14904b(String str, C3472n c3472n) {
        AppMethodBeat.m2504i(59938);
        if (C5046bo.isNullOrNil(str) || c3472n == null) {
            AppMethodBeat.m2505o(59938);
            return;
        }
        synchronized (this.fnL) {
            try {
                this.fnL.remove(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(59938);
            }
        }
    }

    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(59939);
        C7254cm c7254cm = c1197a.eAB;
        switch (c7254cm.nao) {
            case 10001:
                m11073a(C1946aa.m4148a(c7254cm.vEB), c1197a, false);
                C7053e.pXa.mo8374X(10395, String.valueOf(c7254cm.ptF));
                AppMethodBeat.m2505o(59939);
                return null;
            case 10002:
                String a = C1946aa.m4148a(c7254cm.vED);
                if (C5046bo.isNullOrNil(a)) {
                    C4990ab.m7412e("MicroMsg.SysCmdMsgExtension", "null msg content");
                    AppMethodBeat.m2505o(59939);
                    return null;
                }
                Map map;
                String str;
                if (a.startsWith("~SEMI_XML~")) {
                    Map amR = C5035be.amR(a);
                    if (amR == null) {
                        C4990ab.m7413e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a);
                        AppMethodBeat.m2505o(59939);
                        return null;
                    }
                    map = amR;
                    str = "brand_service";
                } else {
                    int indexOf = a.indexOf("<sysmsg");
                    Map z;
                    if (indexOf != -1) {
                        C4990ab.m7411d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", a, a.substring(indexOf));
                        z = C5049br.m7595z(r0, "sysmsg");
                        if (z == null) {
                            C4990ab.m7413e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a);
                            AppMethodBeat.m2505o(59939);
                            return null;
                        }
                        map = z;
                        str = (String) z.get(".sysmsg.$type");
                    } else {
                        indexOf = a.indexOf("<appmsg");
                        if (indexOf != -1) {
                            C4990ab.m7416i("MicroMsg.SysCmdMsgExtension", "msgContent start with <appmsg");
                            C4990ab.m7411d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", a, a.substring(indexOf));
                            z = C5049br.m7595z(r0, "appmsg");
                            if (z == null) {
                                C4990ab.m7413e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a);
                                AppMethodBeat.m2505o(59939);
                                return null;
                            }
                            map = z;
                            str = (String) z.get(".appmsg.title");
                        } else {
                            C4990ab.m7412e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg or <appmsg");
                            AppMethodBeat.m2505o(59939);
                            return null;
                        }
                    }
                }
                C4990ab.m7411d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", a, str);
                if (str != null) {
                    List<C3473o> list;
                    m11073a(str, c1197a, true);
                    synchronized (this.fnK) {
                        try {
                            list = (List) this.fnK.get(str);
                        } finally {
                            while (true) {
                                AppMethodBeat.m2505o(59939);
                                break;
                            }
                        }
                    }
                    if (list == null || list.isEmpty()) {
                        C4990ab.m7420w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
                    } else {
                        C4990ab.m7417i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
                        synchronized (list) {
                            try {
                                for (C3473o onNewXmlReceived : list) {
                                    onNewXmlReceived.onNewXmlReceived(str, map, c1197a);
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(59939);
                            }
                        }
                    }
                    C3472n c3472n = (C3472n) this.fnL.get(str);
                    if (c3472n != null) {
                        C1198b a2 = c3472n.mo7932a(str, map, c1197a);
                        return a2;
                    }
                    C4990ab.m7413e("MicroMsg.SysCmdMsgExtension", "no NewXmlConsumer to consume cmd %s!!", str);
                }
                AppMethodBeat.m2505o(59939);
                return null;
            default:
                C4990ab.m7421w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", Integer.valueOf(c7254cm.nao));
                AppMethodBeat.m2505o(59939);
                return null;
        }
    }

    @Deprecated
    /* renamed from: a */
    private void m11073a(String str, C1197a c1197a, boolean z) {
        List<C1837a> list;
        AppMethodBeat.m2504i(59940);
        Map map = z ? this.fnJ : this.fnI;
        synchronized (map) {
            try {
                list = (List) map.get(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(59940);
                }
            }
        }
        if (list == null || list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            AppMethodBeat.m2505o(59940);
            return;
        }
        C4990ab.m7417i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
        for (C1837a a : list) {
            a.mo5414a(c1197a);
        }
        AppMethodBeat.m2505o(59940);
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }
}
