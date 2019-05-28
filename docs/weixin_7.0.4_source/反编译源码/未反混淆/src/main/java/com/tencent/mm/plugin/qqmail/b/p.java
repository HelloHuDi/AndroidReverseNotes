package com.tencent.mm.plugin.qqmail.b;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class p {
    List<a> callbacks;
    long pui = 0;
    private k puj;
    a puk;
    private int pul = 0;
    int pum = 1;
    private int pun = 2;
    int puo = 3;
    int status = this.pul;

    public static abstract class a {
        public abstract void onComplete();
    }

    p(String str) {
        AppMethodBeat.i(67964);
        this.puj = new k(str, 1);
        byte[] readFromFile = k.readFromFile(this.puj.ptQ + "address");
        if (readFromFile != null) {
            this.puj.a("address", null, readFromFile);
            e.deleteFile(this.puj.ptQ + "address");
        } else {
            readFromFile = this.puj.t("address", null);
        }
        if (readFromFile != null) {
            try {
                this.puk = new a().be(readFromFile);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
                this.puk = new a();
                this.puk.Vc("");
            }
        } else {
            this.puk = new a();
            this.puk.Vc("");
        }
        this.callbacks = new ArrayList();
        AppMethodBeat.o(67964);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(67965);
        this.callbacks.clear();
        AppMethodBeat.o(67965);
    }

    public final List<o> Vi(String str) {
        AppMethodBeat.i(67966);
        List<o> list = this.puk.ptp;
        if (this.status <= this.pum) {
            ccq();
            AppMethodBeat.o(67966);
            return list;
        } else if (str == null || str.length() == 0) {
            AppMethodBeat.o(67966);
            return list;
        } else {
            ArrayList arrayList = new ArrayList();
            for (o oVar : list) {
                if (oVar != null && ((oVar.name != null && oVar.name.contains(str)) || ((oVar.puh != null && oVar.puh.contains(str)) || (oVar.nJq != null && oVar.nJq.contains(str))))) {
                    a.b(oVar);
                    arrayList.add(oVar);
                }
            }
            AppMethodBeat.o(67966);
            return arrayList;
        }
    }

    public final void ccq() {
        AppMethodBeat.i(67967);
        if (this.status == this.pun) {
            AppMethodBeat.o(67967);
        } else if (bo.anU() - this.pui <= 600000) {
            for (a onComplete : this.callbacks) {
                onComplete.onComplete();
            }
            AppMethodBeat.o(67967);
        } else {
            Object obj;
            this.status = this.pun;
            HashMap hashMap = new HashMap();
            String str = "syncinfo";
            if (this.puk.ptn == null) {
                obj = "";
            } else {
                obj = this.puk.ptn;
            }
            hashMap.put(str, obj);
            ab.d("MicroMsg.Plugin.MailAddrMgr", "%s", "sync~~~");
            ac.ccC().b("/cgi-bin/syncaddrlist", hashMap, new com.tencent.mm.plugin.qqmail.b.v.a() {
                public final void onSuccess(String str, Map<String, String> map) {
                    AppMethodBeat.i(67962);
                    p pVar = p.this;
                    int i = bo.getInt((String) map.get(".Response.result.Count"), 0);
                    if (i > 0) {
                        int i2 = pVar.puk.ptp.size() == 0 ? 1 : 0;
                        int i3 = 0;
                        while (i3 < i) {
                            String str2 = ".Response.result.List.item" + (i3 > 0 ? String.valueOf(i3) : "") + ".";
                            String str3 = (String) map.get(str2 + "Del");
                            String str4 = (String) map.get(str2 + "Freq");
                            String str5 = (String) map.get(str2 + "Name");
                            str2 = (String) map.get(str2 + "Addr");
                            if (str2 != null && str2.length() != 0) {
                                if (str5 == null || str5.length() == 0) {
                                    str5 = str2;
                                }
                                int hashCode = str2.hashCode();
                                if (str3.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                    LinkedList linkedList = pVar.puk.ptp;
                                    int i4 = 0;
                                    while (i2 == 0 && i4 < linkedList.size() && ((o) linkedList.get(i4)).puf != hashCode) {
                                        i4++;
                                    }
                                    if (i4 >= linkedList.size() || i2 != 0) {
                                        o oVar = new o();
                                        oVar.puf = hashCode;
                                        oVar.name = str5;
                                        oVar.nJq = str2;
                                        oVar.pug = bo.getInt(str4, 0);
                                        pVar.puk.a(oVar);
                                    }
                                } else {
                                    Iterator it = pVar.puk.ptp.iterator();
                                    int i5 = 0;
                                    while (it.hasNext()) {
                                        if (((o) it.next()).puf == hashCode) {
                                            pVar.puk.Bo(i5);
                                            break;
                                        }
                                        i5++;
                                    }
                                }
                            }
                            i3++;
                        }
                        pVar.puk.Vc((String) map.get(".Response.result.SyncInfo"));
                        pVar.save();
                    }
                    if (((String) map.get(".Response.result.ContinueFlag")).equals("1")) {
                        new ak().postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(67961);
                                p.this.status = p.this.pum;
                                p.this.ccq();
                                AppMethodBeat.o(67961);
                            }
                        }, 0);
                        AppMethodBeat.o(67962);
                        return;
                    }
                    p.this.pui = bo.anU();
                    for (a onComplete : p.this.callbacks) {
                        onComplete.onComplete();
                    }
                    AppMethodBeat.o(67962);
                }

                public final void onError(int i, String str) {
                    AppMethodBeat.i(67963);
                    for (a onComplete : p.this.callbacks) {
                        onComplete.onComplete();
                    }
                    AppMethodBeat.o(67963);
                }

                public final void onComplete() {
                    p.this.status = p.this.puo;
                }
            });
            AppMethodBeat.o(67967);
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(67968);
        for (a aVar2 : this.callbacks) {
            if (aVar2 == aVar) {
                AppMethodBeat.o(67968);
                return;
            }
        }
        this.callbacks.add(aVar);
        AppMethodBeat.o(67968);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(67969);
        for (a aVar2 : this.callbacks) {
            if (aVar2 == aVar) {
                this.callbacks.remove(aVar2);
                AppMethodBeat.o(67969);
                return;
            }
        }
        AppMethodBeat.o(67969);
    }

    public final void cG(List<o> list) {
        AppMethodBeat.i(67970);
        a aVar = this.puk;
        if (!(list == null || list.size() == 0)) {
            for (o oVar : list) {
                int i = 0;
                Iterator it = aVar.ptp.iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    o oVar2 = (o) it.next();
                    if (oVar2.nJq.equalsIgnoreCase(oVar.nJq)) {
                        aVar.Bo(i2);
                        oVar2.pug++;
                        aVar.a(oVar2);
                        break;
                    }
                    i = i2 + 1;
                }
            }
        }
        save();
        AppMethodBeat.o(67970);
    }

    /* Access modifiers changed, original: final */
    public final void save() {
        AppMethodBeat.i(67971);
        try {
            this.puj.a("address", null, this.puk.toByteArray());
            AppMethodBeat.o(67971);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
            AppMethodBeat.o(67971);
        }
    }

    public static o Vj(String str) {
        AppMethodBeat.i(67972);
        if (str == null) {
            AppMethodBeat.o(67972);
            return null;
        }
        String trim = str.trim();
        int lastIndexOf = trim.trim().lastIndexOf(" ");
        if (lastIndexOf == -1) {
            AppMethodBeat.o(67972);
            return null;
        }
        o oVar = new o();
        oVar.name = trim.substring(0, lastIndexOf);
        oVar.nJq = trim.substring(lastIndexOf + 1);
        AppMethodBeat.o(67972);
        return oVar;
    }
}
