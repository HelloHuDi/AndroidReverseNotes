package com.tencent.p177mm.plugin.qqmail.p486b;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C21523a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.qqmail.b.p */
public final class C46149p {
    List<C43405a> callbacks;
    long pui = 0;
    private C28741k puj;
    C12876a puk;
    private int pul = 0;
    int pum = 1;
    private int pun = 2;
    int puo = 3;
    int status = this.pul;

    /* renamed from: com.tencent.mm.plugin.qqmail.b.p$1 */
    class C128881 extends C21523a {

        /* renamed from: com.tencent.mm.plugin.qqmail.b.p$1$1 */
        class C128891 implements Runnable {
            C128891() {
            }

            public final void run() {
                AppMethodBeat.m2504i(67961);
                C46149p.this.status = C46149p.this.pum;
                C46149p.this.ccq();
                AppMethodBeat.m2505o(67961);
            }
        }

        C128881() {
        }

        public final void onSuccess(String str, Map<String, String> map) {
            AppMethodBeat.m2504i(67962);
            C46149p c46149p = C46149p.this;
            int i = C5046bo.getInt((String) map.get(".Response.result.Count"), 0);
            if (i > 0) {
                int i2 = c46149p.puk.ptp.size() == 0 ? 1 : 0;
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
                            LinkedList linkedList = c46149p.puk.ptp;
                            int i4 = 0;
                            while (i2 == 0 && i4 < linkedList.size() && ((C43404o) linkedList.get(i4)).puf != hashCode) {
                                i4++;
                            }
                            if (i4 >= linkedList.size() || i2 != 0) {
                                C43404o c43404o = new C43404o();
                                c43404o.puf = hashCode;
                                c43404o.name = str5;
                                c43404o.nJq = str2;
                                c43404o.pug = C5046bo.getInt(str4, 0);
                                c46149p.puk.mo24904a(c43404o);
                            }
                        } else {
                            Iterator it = c46149p.puk.ptp.iterator();
                            int i5 = 0;
                            while (it.hasNext()) {
                                if (((C43404o) it.next()).puf == hashCode) {
                                    c46149p.puk.mo24902Bo(i5);
                                    break;
                                }
                                i5++;
                            }
                        }
                    }
                    i3++;
                }
                c46149p.puk.mo24903Vc((String) map.get(".Response.result.SyncInfo"));
                c46149p.save();
            }
            if (((String) map.get(".Response.result.ContinueFlag")).equals("1")) {
                new C7306ak().postDelayed(new C128891(), 0);
                AppMethodBeat.m2505o(67962);
                return;
            }
            C46149p.this.pui = C5046bo.anU();
            for (C43405a onComplete : C46149p.this.callbacks) {
                onComplete.onComplete();
            }
            AppMethodBeat.m2505o(67962);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(67963);
            for (C43405a onComplete : C46149p.this.callbacks) {
                onComplete.onComplete();
            }
            AppMethodBeat.m2505o(67963);
        }

        public final void onComplete() {
            C46149p.this.status = C46149p.this.puo;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.p$a */
    public static abstract class C43405a {
        public abstract void onComplete();
    }

    C46149p(String str) {
        AppMethodBeat.m2504i(67964);
        this.puj = new C28741k(str, 1);
        byte[] readFromFile = C28741k.readFromFile(this.puj.ptQ + "address");
        if (readFromFile != null) {
            this.puj.mo46893a("address", null, readFromFile);
            C5730e.deleteFile(this.puj.ptQ + "address");
        } else {
            readFromFile = this.puj.mo46895t("address", null);
        }
        if (readFromFile != null) {
            try {
                this.puk = new C12876a().mo24905be(readFromFile);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
                this.puk = new C12876a();
                this.puk.mo24903Vc("");
            }
        } else {
            this.puk = new C12876a();
            this.puk.mo24903Vc("");
        }
        this.callbacks = new ArrayList();
        AppMethodBeat.m2505o(67964);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(67965);
        this.callbacks.clear();
        AppMethodBeat.m2505o(67965);
    }

    /* renamed from: Vi */
    public final List<C43404o> mo74096Vi(String str) {
        AppMethodBeat.m2504i(67966);
        List<C43404o> list = this.puk.ptp;
        if (this.status <= this.pum) {
            ccq();
            AppMethodBeat.m2505o(67966);
            return list;
        } else if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(67966);
            return list;
        } else {
            ArrayList arrayList = new ArrayList();
            for (C43404o c43404o : list) {
                if (c43404o != null && ((c43404o.name != null && c43404o.name.contains(str)) || ((c43404o.puh != null && c43404o.puh.contains(str)) || (c43404o.nJq != null && c43404o.nJq.contains(str))))) {
                    C12876a.m20872b(c43404o);
                    arrayList.add(c43404o);
                }
            }
            AppMethodBeat.m2505o(67966);
            return arrayList;
        }
    }

    public final void ccq() {
        AppMethodBeat.m2504i(67967);
        if (this.status == this.pun) {
            AppMethodBeat.m2505o(67967);
        } else if (C5046bo.anU() - this.pui <= 600000) {
            for (C43405a onComplete : this.callbacks) {
                onComplete.onComplete();
            }
            AppMethodBeat.m2505o(67967);
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
            C4990ab.m7411d("MicroMsg.Plugin.MailAddrMgr", "%s", "sync~~~");
            C12884ac.ccC().mo62493b("/cgi-bin/syncaddrlist", hashMap, new C128881());
            AppMethodBeat.m2505o(67967);
        }
    }

    /* renamed from: a */
    public final void mo74097a(C43405a c43405a) {
        AppMethodBeat.m2504i(67968);
        for (C43405a c43405a2 : this.callbacks) {
            if (c43405a2 == c43405a) {
                AppMethodBeat.m2505o(67968);
                return;
            }
        }
        this.callbacks.add(c43405a);
        AppMethodBeat.m2505o(67968);
    }

    /* renamed from: b */
    public final void mo74098b(C43405a c43405a) {
        AppMethodBeat.m2504i(67969);
        for (C43405a c43405a2 : this.callbacks) {
            if (c43405a2 == c43405a) {
                this.callbacks.remove(c43405a2);
                AppMethodBeat.m2505o(67969);
                return;
            }
        }
        AppMethodBeat.m2505o(67969);
    }

    /* renamed from: cG */
    public final void mo74099cG(List<C43404o> list) {
        AppMethodBeat.m2504i(67970);
        C12876a c12876a = this.puk;
        if (!(list == null || list.size() == 0)) {
            for (C43404o c43404o : list) {
                int i = 0;
                Iterator it = c12876a.ptp.iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    C43404o c43404o2 = (C43404o) it.next();
                    if (c43404o2.nJq.equalsIgnoreCase(c43404o.nJq)) {
                        c12876a.mo24902Bo(i2);
                        c43404o2.pug++;
                        c12876a.mo24904a(c43404o2);
                        break;
                    }
                    i = i2 + 1;
                }
            }
        }
        save();
        AppMethodBeat.m2505o(67970);
    }

    /* Access modifiers changed, original: final */
    public final void save() {
        AppMethodBeat.m2504i(67971);
        try {
            this.puj.mo46893a("address", null, this.puk.toByteArray());
            AppMethodBeat.m2505o(67971);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
            AppMethodBeat.m2505o(67971);
        }
    }

    /* renamed from: Vj */
    public static C43404o m86140Vj(String str) {
        AppMethodBeat.m2504i(67972);
        if (str == null) {
            AppMethodBeat.m2505o(67972);
            return null;
        }
        String trim = str.trim();
        int lastIndexOf = trim.trim().lastIndexOf(" ");
        if (lastIndexOf == -1) {
            AppMethodBeat.m2505o(67972);
            return null;
        }
        C43404o c43404o = new C43404o();
        c43404o.name = trim.substring(0, lastIndexOf);
        c43404o.nJq = trim.substring(lastIndexOf + 1);
        AppMethodBeat.m2505o(67972);
        return c43404o;
    }
}
