package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bz implements e {
    private Map<String, List<a>> fnI = new HashMap();
    private Map<String, List<a>> fnJ = new HashMap();
    private Map<String, List<o>> fnK = new HashMap();
    private Map<String, n> fnL = new ConcurrentHashMap();

    public interface a {
        void a(com.tencent.mm.ai.e.a aVar);
    }

    public bz() {
        AppMethodBeat.i(59932);
        AppMethodBeat.o(59932);
    }

    @Deprecated
    public final void a(String str, a aVar, boolean z) {
        AppMethodBeat.i(59933);
        if (bo.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(59933);
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
                AppMethodBeat.o(59933);
            }
        }
        synchronized (list) {
            try {
                if (!list.contains(aVar)) {
                    list.add(aVar);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(59933);
                }
            }
        }
    }

    @Deprecated
    public final void b(String str, a aVar, boolean z) {
        AppMethodBeat.i(59934);
        if (bo.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(59934);
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
                AppMethodBeat.o(59934);
            }
        }
        if (list != null) {
            synchronized (list) {
                try {
                    list.remove(aVar);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(59934);
                    }
                }
            }
            return;
        }
        AppMethodBeat.o(59934);
    }

    public final void a(String str, o oVar) {
        AppMethodBeat.i(59935);
        if (bo.isNullOrNil(str) || oVar == null) {
            AppMethodBeat.o(59935);
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
                AppMethodBeat.o(59935);
            }
        }
        synchronized (list) {
            try {
                if (!list.contains(oVar)) {
                    list.add(oVar);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(59935);
                }
            }
        }
    }

    public final void b(String str, o oVar) {
        AppMethodBeat.i(59936);
        if (bo.isNullOrNil(str) || oVar == null) {
            AppMethodBeat.o(59936);
            return;
        }
        List list;
        synchronized (this.fnK) {
            try {
                list = (List) this.fnK.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(59936);
            }
        }
        if (list != null) {
            synchronized (list) {
                try {
                    list.remove(oVar);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(59936);
                    }
                }
            }
            return;
        }
        AppMethodBeat.o(59936);
    }

    public final void a(String str, n nVar) {
        AppMethodBeat.i(59937);
        if (bo.isNullOrNil(str) || nVar == null) {
            AppMethodBeat.o(59937);
            return;
        }
        if (this.fnL.containsKey(str)) {
            ab.w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", str, bo.dpG());
        }
        this.fnL.put(str, nVar);
        AppMethodBeat.o(59937);
    }

    public final void b(String str, n nVar) {
        AppMethodBeat.i(59938);
        if (bo.isNullOrNil(str) || nVar == null) {
            AppMethodBeat.o(59938);
            return;
        }
        synchronized (this.fnL) {
            try {
                this.fnL.remove(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(59938);
            }
        }
    }

    public final b b(com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(59939);
        cm cmVar = aVar.eAB;
        switch (cmVar.nao) {
            case 10001:
                a(aa.a(cmVar.vEB), aVar, false);
                com.tencent.mm.plugin.report.e.pXa.X(10395, String.valueOf(cmVar.ptF));
                AppMethodBeat.o(59939);
                return null;
            case 10002:
                String a = aa.a(cmVar.vED);
                if (bo.isNullOrNil(a)) {
                    ab.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                    AppMethodBeat.o(59939);
                    return null;
                }
                Map map;
                String str;
                if (a.startsWith("~SEMI_XML~")) {
                    Map amR = be.amR(a);
                    if (amR == null) {
                        ab.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a);
                        AppMethodBeat.o(59939);
                        return null;
                    }
                    map = amR;
                    str = "brand_service";
                } else {
                    int indexOf = a.indexOf("<sysmsg");
                    Map z;
                    if (indexOf != -1) {
                        ab.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", a, a.substring(indexOf));
                        z = br.z(r0, "sysmsg");
                        if (z == null) {
                            ab.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a);
                            AppMethodBeat.o(59939);
                            return null;
                        }
                        map = z;
                        str = (String) z.get(".sysmsg.$type");
                    } else {
                        indexOf = a.indexOf("<appmsg");
                        if (indexOf != -1) {
                            ab.i("MicroMsg.SysCmdMsgExtension", "msgContent start with <appmsg");
                            ab.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", a, a.substring(indexOf));
                            z = br.z(r0, "appmsg");
                            if (z == null) {
                                ab.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a);
                                AppMethodBeat.o(59939);
                                return null;
                            }
                            map = z;
                            str = (String) z.get(".appmsg.title");
                        } else {
                            ab.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg or <appmsg");
                            AppMethodBeat.o(59939);
                            return null;
                        }
                    }
                }
                ab.d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", a, str);
                if (str != null) {
                    List<o> list;
                    a(str, aVar, true);
                    synchronized (this.fnK) {
                        try {
                            list = (List) this.fnK.get(str);
                        } finally {
                            while (true) {
                                AppMethodBeat.o(59939);
                                break;
                            }
                        }
                    }
                    if (list == null || list.isEmpty()) {
                        ab.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
                    } else {
                        ab.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
                        synchronized (list) {
                            try {
                                for (o onNewXmlReceived : list) {
                                    onNewXmlReceived.onNewXmlReceived(str, map, aVar);
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(59939);
                            }
                        }
                    }
                    n nVar = (n) this.fnL.get(str);
                    if (nVar != null) {
                        b a2 = nVar.a(str, map, aVar);
                        return a2;
                    }
                    ab.e("MicroMsg.SysCmdMsgExtension", "no NewXmlConsumer to consume cmd %s!!", str);
                }
                AppMethodBeat.o(59939);
                return null;
            default:
                ab.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", Integer.valueOf(cmVar.nao));
                AppMethodBeat.o(59939);
                return null;
        }
    }

    @Deprecated
    private void a(String str, com.tencent.mm.ai.e.a aVar, boolean z) {
        List<a> list;
        AppMethodBeat.i(59940);
        Map map = z ? this.fnJ : this.fnI;
        synchronized (map) {
            try {
                list = (List) map.get(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(59940);
                }
            }
        }
        if (list == null || list.isEmpty()) {
            ab.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            AppMethodBeat.o(59940);
            return;
        }
        ab.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
        for (a a : list) {
            a.a(aVar);
        }
        AppMethodBeat.o(59940);
    }

    public final void a(c cVar) {
    }
}
