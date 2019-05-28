package com.tencent.p177mm.plugin.webview.model;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C46210i;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C29916g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C35641b;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.webview.model.aq */
public final class C40259aq {
    private static int umY = 0;
    private static int umZ = 0;
    public C22886o umJ;
    public C40262m umK;
    public C40263n umL;
    public C40261l umM;
    private C14510a umN;
    public C14511h umO;
    public C40256c umP;
    public C22884i umQ;
    public C40265e umR;
    private C40258f umS;
    private C40260k umT;
    private C22885j umU;
    private C40257d umV;
    public C40264b umW;
    private C35609g umX;

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$a */
    public static class C14510a {
        public long edh = System.currentTimeMillis();
        public String fjS;
        public long iBA;
        public long lastResumeTime = -1;
        public int rCb = C1338a.m2869ge(C4996ah.getContext());
        public int scene;
        public int una = C1338a.m2869ge(C4996ah.getContext());

        public C14510a() {
            AppMethodBeat.m2504i(6759);
            AppMethodBeat.m2505o(6759);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$h */
    public class C14511h {
        public int cSQ;
        public boolean cph = false;
        public long startTime = C5046bo.anU();
        public String uni;
        public String url;

        public C14511h() {
            AppMethodBeat.m2504i(6767);
            AppMethodBeat.m2505o(6767);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$i */
    public static class C22884i {
        public Object[] une = null;

        /* renamed from: b */
        public final void mo38482b(C46434d c46434d) {
            AppMethodBeat.m2504i(6768);
            if (c46434d != null) {
                C29916g.m47392a(c46434d, 11576, this.une);
            }
            AppMethodBeat.m2505o(6768);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$j */
    public static class C22885j {
        public List<String> unk;
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$o */
    public class C22886o {
        public int cSQ;
        public boolean cxT = true;
        public long iBv;
        public String uni;
        public String url;
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$g */
    public static class C35609g {
        public int errCode;
        public SnsAdClick pmI;
        private ArrayList<String> unj = new ArrayList();

        public C35609g() {
            AppMethodBeat.m2504i(6764);
            AppMethodBeat.m2505o(6764);
        }

        /* renamed from: L */
        public final void mo56328L(String... strArr) {
            AppMethodBeat.m2504i(6765);
            for (int i = 0; i < 3; i++) {
                this.unj.add(strArr[i]);
            }
            AppMethodBeat.m2505o(6765);
        }

        /* renamed from: b */
        public final void mo56329b(C46434d c46434d) {
            AppMethodBeat.m2504i(6766);
            try {
                if (!this.unj.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("reportAdH5Load", this.unj);
                    bundle.putInt("errCode", this.errCode);
                    bundle.putParcelable("snsAdClick", this.pmI);
                    c46434d.mo15575g(204, bundle);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WebviewReporter", e, "", new Object[0]);
            }
            this.pmI = null;
            this.unj.clear();
            AppMethodBeat.m2505o(6766);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$c */
    public static class C40256c {
        public String cOG;
        public boolean loadFinished = false;
        public boolean unc = false;
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$d */
    public static class C40257d {
        public boolean mlA = false;
        public boolean und = false;
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$f */
    public class C40258f {
        public int cSQ;
        public String iCz = "";
        public HashMap<String, Long> unf = new HashMap();
        public HashMap<String, Long> ung = new HashMap();
        public boolean unh = true;
        public String uni;

        public C40258f() {
            AppMethodBeat.m2504i(6762);
            AppMethodBeat.m2505o(6762);
        }

        /* renamed from: b */
        public final void mo63601b(C46434d c46434d) {
            AppMethodBeat.m2504i(6763);
            if (c46434d != null) {
                String str;
                long longValue;
                String str2;
                Object[] objArr;
                int aEn = C40259aq.aEn();
                for (Entry entry : this.unf.entrySet()) {
                    str = (String) entry.getKey();
                    longValue = ((Long) entry.getValue()).longValue();
                    if (longValue < 0 || longValue > 180000) {
                        AppMethodBeat.m2505o(6763);
                        return;
                    }
                    str2 = this.uni;
                    objArr = new Object[11];
                    objArr[0] = Integer.valueOf(5);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(aEn);
                    if (str != null) {
                        str = str.replace(",", "!");
                    }
                    objArr[3] = str;
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(C40259aq.umY);
                    objArr[8] = Integer.valueOf(C40259aq.umZ);
                    objArr[9] = Integer.valueOf(this.cSQ);
                    objArr[10] = this.uni;
                    C40259aq.m69040b(c46434d, str2, objArr);
                    if (C40259aq.umY == 1) {
                        C7060h.pYm.mo8378a(32, 18, 1, true);
                        C7060h.pYm.mo8378a(32, 19, longValue, true);
                    }
                    C7060h.pYm.mo8378a(32, 8, 1, true);
                    C7060h.pYm.mo8378a(32, 9, longValue, true);
                    C4990ab.m7417i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", Long.valueOf(longValue), Integer.valueOf(aEn), Integer.valueOf(C40259aq.umY), Integer.valueOf(C40259aq.umZ), Integer.valueOf(this.cSQ), this.uni);
                }
                for (Entry entry2 : this.ung.entrySet()) {
                    str = (String) entry2.getKey();
                    longValue = ((Long) entry2.getValue()).longValue();
                    if (longValue < 0 || longValue > 180000) {
                        AppMethodBeat.m2505o(6763);
                        return;
                    }
                    str2 = this.uni;
                    objArr = new Object[11];
                    objArr[0] = Integer.valueOf(6);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(aEn);
                    if (str != null) {
                        str = str.replace(",", "!");
                    }
                    objArr[3] = str;
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(C40259aq.umY);
                    objArr[8] = Integer.valueOf(C40259aq.umZ);
                    objArr[9] = Integer.valueOf(this.cSQ);
                    objArr[10] = this.uni;
                    C40259aq.m69040b(c46434d, str2, objArr);
                    if (C40259aq.umY == 1) {
                        C7060h.pYm.mo8378a(32, 20, 1, true);
                        C7060h.pYm.mo8378a(32, 21, longValue, true);
                    }
                    C7060h.pYm.mo8378a(32, 10, 1, true);
                    C7060h.pYm.mo8378a(32, 11, longValue, true);
                    C4990ab.m7417i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", Long.valueOf(longValue), Integer.valueOf(aEn), Integer.valueOf(C40259aq.umY), Integer.valueOf(C40259aq.umZ), Integer.valueOf(this.cSQ), this.uni);
                }
            }
            AppMethodBeat.m2505o(6763);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$k */
    public static class C40260k {
        public List<String> unk;
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$l */
    public static class C40261l {
        public String appId;
        public String cOG;
        public String dJE;
        long edh = (System.currentTimeMillis() / 1000);
        public String fjS;
        public long iBA;
        public long lastResumeTime = -1;
        public String rjC;
        public int scene;
        public String title;
        public String unl;
        public String unm;
        public long unn;
        public int uno;
        public String unp;
        public String unq;
        public String unr;
        public int uns;
        public int unt;
        public String username;

        public C40261l() {
            AppMethodBeat.m2504i(6769);
            AppMethodBeat.m2505o(6769);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$m */
    public class C40262m {
        public int cSQ;
        public String uni;
        public HashMap<String, Long> unu = new HashMap();

        public C40262m() {
            AppMethodBeat.m2504i(6770);
            AppMethodBeat.m2505o(6770);
        }

        /* renamed from: bE */
        public final void mo63620bE(String str, boolean z) {
            AppMethodBeat.m2504i(6771);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
                AppMethodBeat.m2505o(6771);
                return;
            }
            if (this.unu.containsKey(str)) {
                if (z) {
                    this.unu.put(str, Long.valueOf(C5046bo.anU() - ((Long) this.unu.get(str)).longValue()));
                    AppMethodBeat.m2505o(6771);
                    return;
                }
                this.unu.put(str, Long.valueOf(-1));
            }
            AppMethodBeat.m2505o(6771);
        }

        /* renamed from: b */
        public final void mo63619b(C46434d c46434d) {
            AppMethodBeat.m2504i(6772);
            if (c46434d == null) {
                AppMethodBeat.m2505o(6772);
                return;
            }
            int aEn = C40259aq.aEn();
            for (Entry entry : this.unu.entrySet()) {
                String str = (String) entry.getKey();
                long longValue = ((Long) entry.getValue()).longValue();
                C7060h.pYm.mo8378a(32, 2, 1, true);
                if (longValue == -1) {
                    C7060h.pYm.mo8378a(32, 13, 1, true);
                    C4990ab.m7417i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", str, Integer.valueOf(aEn));
                }
                if (longValue >= 0 && longValue <= 60000) {
                    String str2 = this.uni;
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(2);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(aEn);
                    objArr[3] = str == null ? str : str.replace(",", "!");
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(C40259aq.umY);
                    objArr[8] = Integer.valueOf(C40259aq.umZ);
                    objArr[9] = Integer.valueOf(this.cSQ);
                    objArr[10] = this.uni;
                    C40259aq.m69040b(c46434d, str2, objArr);
                    C4990ab.m7417i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", str, Long.valueOf(longValue), Integer.valueOf(aEn), Integer.valueOf(this.cSQ), this.uni);
                    C7060h.pYm.mo8378a(32, 6, longValue, true);
                }
            }
            AppMethodBeat.m2505o(6772);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$n */
    public class C40263n {
        public int cSQ;
        public String uni;
        public HashMap<String, Long> unv = new HashMap();

        public C40263n() {
            AppMethodBeat.m2504i(6773);
            AppMethodBeat.m2505o(6773);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$b */
    public class C40264b {
        public Bundle mqu = null;

        public C40264b(Bundle bundle) {
            this.mqu = bundle;
        }

        public final void putValue(String str, Object obj) {
            AppMethodBeat.m2504i(6760);
            if (this.mqu != null) {
                if (obj instanceof String) {
                    this.mqu.putString(str, (String) obj);
                    AppMethodBeat.m2505o(6760);
                    return;
                } else if (obj instanceof Boolean) {
                    this.mqu.putBoolean(str, ((Boolean) obj).booleanValue());
                    AppMethodBeat.m2505o(6760);
                    return;
                } else if (obj instanceof Integer) {
                    this.mqu.putInt(str, ((Integer) obj).intValue());
                    AppMethodBeat.m2505o(6760);
                    return;
                } else {
                    C4990ab.m7420w("MicroMsg.WebviewReporter", "put unknow type value.");
                }
            }
            AppMethodBeat.m2505o(6760);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.aq$e */
    public static class C40265e {
        public Object[] une = null;

        /* renamed from: b */
        public final void mo63622b(C46434d c46434d) {
            AppMethodBeat.m2504i(6761);
            if (c46434d != null) {
                C29916g.m47392a(c46434d, 11577, this.une);
            }
            AppMethodBeat.m2505o(6761);
        }
    }

    /* renamed from: b */
    public static /* synthetic */ void m69040b(C46434d c46434d, String str, Object[] objArr) {
        AppMethodBeat.m2504i(6795);
        C40259aq.m69039a(c46434d, str, objArr);
        AppMethodBeat.m2505o(6795);
    }

    public static int aEn() {
        AppMethodBeat.m2504i(6774);
        if (C5023at.is4G(C4996ah.getContext())) {
            AppMethodBeat.m2505o(6774);
            return 5;
        }
        switch (C5023at.getNetType(C4996ah.getContext())) {
            case -1:
                AppMethodBeat.m2505o(6774);
                return 255;
            case 0:
                AppMethodBeat.m2505o(6774);
                return 1;
            case 1:
            case 6:
            case 8:
                AppMethodBeat.m2505o(6774);
                return 3;
            case 2:
            case 5:
            case 7:
                AppMethodBeat.m2505o(6774);
                return 2;
            case 3:
            case 4:
                AppMethodBeat.m2505o(6774);
                return 4;
            default:
                AppMethodBeat.m2505o(6774);
                return 6;
        }
    }

    public static String cXS() {
        AppMethodBeat.m2504i(6775);
        ConnectivityManager connectivityManager = (ConnectivityManager) C4996ah.getContext().getSystemService("connectivity");
        String str;
        if (connectivityManager == null) {
            str = "no";
            AppMethodBeat.m2505o(6775);
            return str;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            str = "no";
            AppMethodBeat.m2505o(6775);
            return str;
        } else if (activeNetworkInfo.getType() == 1) {
            str = "WIFI";
            AppMethodBeat.m2505o(6775);
            return str;
        } else {
            C4990ab.m7411d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo());
            if (activeNetworkInfo.getExtraInfo() != null) {
                str = activeNetworkInfo.getExtraInfo().toLowerCase();
                AppMethodBeat.m2505o(6775);
                return str;
            }
            str = "no";
            AppMethodBeat.m2505o(6775);
            return str;
        }
    }

    public final C22886o cXT() {
        AppMethodBeat.m2504i(6776);
        if (this.umJ == null) {
            this.umJ = new C22886o();
        }
        C22886o c22886o = this.umJ;
        AppMethodBeat.m2505o(6776);
        return c22886o;
    }

    public final C40262m cXU() {
        AppMethodBeat.m2504i(6777);
        if (this.umK == null) {
            this.umK = new C40262m();
        }
        C40262m c40262m = this.umK;
        AppMethodBeat.m2505o(6777);
        return c40262m;
    }

    public final C40263n cXV() {
        AppMethodBeat.m2504i(6778);
        if (this.umL == null) {
            this.umL = new C40263n();
        }
        C40263n c40263n = this.umL;
        AppMethodBeat.m2505o(6778);
        return c40263n;
    }

    public final C40258f cXW() {
        AppMethodBeat.m2504i(6779);
        if (this.umS == null) {
            this.umS = new C40258f();
        }
        C40258f c40258f = this.umS;
        AppMethodBeat.m2505o(6779);
        return c40258f;
    }

    public final C40261l cXX() {
        AppMethodBeat.m2504i(6780);
        if (this.umM == null) {
            this.umM = new C40261l();
        }
        C40261l c40261l = this.umM;
        AppMethodBeat.m2505o(6780);
        return c40261l;
    }

    public final C14510a cXY() {
        AppMethodBeat.m2504i(6781);
        if (this.umN == null) {
            this.umN = new C14510a();
        }
        C14510a c14510a = this.umN;
        AppMethodBeat.m2505o(6781);
        return c14510a;
    }

    public final C14511h cXZ() {
        AppMethodBeat.m2504i(6782);
        if (this.umO == null) {
            this.umO = new C14511h();
        }
        C14511h c14511h = this.umO;
        AppMethodBeat.m2505o(6782);
        return c14511h;
    }

    public final C40256c cYa() {
        AppMethodBeat.m2504i(6783);
        if (this.umP == null) {
            this.umP = new C40256c();
        }
        C40256c c40256c = this.umP;
        AppMethodBeat.m2505o(6783);
        return c40256c;
    }

    public final C22884i cYb() {
        AppMethodBeat.m2504i(6784);
        if (this.umQ == null) {
            this.umQ = new C22884i();
        }
        C22884i c22884i = this.umQ;
        AppMethodBeat.m2505o(6784);
        return c22884i;
    }

    public final C40265e cYc() {
        AppMethodBeat.m2504i(6785);
        if (this.umR == null) {
            this.umR = new C40265e();
        }
        C40265e c40265e = this.umR;
        AppMethodBeat.m2505o(6785);
        return c40265e;
    }

    public final C40260k cYd() {
        AppMethodBeat.m2504i(6786);
        if (this.umT == null) {
            this.umT = new C40260k();
        }
        C40260k c40260k = this.umT;
        AppMethodBeat.m2505o(6786);
        return c40260k;
    }

    public final C22885j cYe() {
        AppMethodBeat.m2504i(6787);
        if (this.umU == null) {
            this.umU = new C22885j();
        }
        C22885j c22885j = this.umU;
        AppMethodBeat.m2505o(6787);
        return c22885j;
    }

    public final C40257d cYf() {
        AppMethodBeat.m2504i(6788);
        if (this.umV == null) {
            this.umV = new C40257d();
        }
        C40257d c40257d = this.umV;
        AppMethodBeat.m2505o(6788);
        return c40257d;
    }

    public final C35609g cYg() {
        AppMethodBeat.m2504i(6789);
        if (this.umX == null) {
            this.umX = new C35609g();
        }
        C35609g c35609g = this.umX;
        AppMethodBeat.m2505o(6789);
        return c35609g;
    }

    /* renamed from: q */
    public final void mo63618q(String str, Object obj) {
        AppMethodBeat.m2504i(6790);
        if (this.umW != null) {
            try {
                this.umW.putValue(str, obj);
                AppMethodBeat.m2505o(6790);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(6790);
    }

    public final void aeG(String str) {
        AppMethodBeat.m2504i(6791);
        if (this.umW != null) {
            try {
                C40264b c40264b = this.umW;
                if (c40264b.mqu.containsKey(str)) {
                    try {
                        c40264b.putValue(str, Integer.valueOf(c40264b.mqu.getInt(str) + 1));
                        AppMethodBeat.m2505o(6791);
                        return;
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(6791);
                        return;
                    }
                }
                c40264b.putValue(str, Integer.valueOf(1));
                AppMethodBeat.m2505o(6791);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.m2505o(6791);
    }

    /* renamed from: V */
    public static void m69038V(boolean z, boolean z2) {
        if (z) {
            umY = 1;
        } else {
            umY = 0;
        }
        if (z2) {
            umZ = 1;
        } else {
            umZ = 0;
        }
    }

    /* renamed from: b */
    public final void mo63603b(C46434d c46434d) {
        String str;
        String str2;
        AppMethodBeat.m2504i(6792);
        C40263n cXV = cXV();
        if (c46434d != null) {
            int aEn = C40259aq.aEn();
            for (Entry entry : cXV.unv.entrySet()) {
                String str3 = (String) entry.getKey();
                long longValue = ((Long) entry.getValue()).longValue();
                C7060h.pYm.mo8378a(32, 0, 1, true);
                if (longValue >= 0 && longValue <= 180000) {
                    str = cXV.uni;
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(aEn);
                    if (str3 == null) {
                        str2 = str3;
                    } else {
                        str2 = str3.replace(",", "!");
                    }
                    objArr[3] = str2;
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(umY);
                    objArr[8] = Integer.valueOf(umZ);
                    objArr[9] = Integer.valueOf(cXV.cSQ);
                    objArr[10] = cXV.uni;
                    C40259aq.m69039a(c46434d, str, objArr);
                    C7060h.pYm.mo8378a(160, 0, 1, false);
                    if (-1 != C35641b.m58495lS(longValue)) {
                        C7060h.pYm.mo8378a(160, (long) C35641b.m58495lS(longValue), 1, false);
                    }
                    C7060h.pYm.mo8378a(32, 3, 1, true);
                    C7060h.pYm.mo8378a(32, 7, longValue, true);
                    if (umZ == 1) {
                        C7060h.pYm.mo8378a(32, 16, 1, true);
                        C7060h.pYm.mo8378a(32, 17, longValue, true);
                    }
                    C4990ab.m7417i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", str3, Long.valueOf(longValue), Integer.valueOf(aEn), Integer.valueOf(umY), Integer.valueOf(umZ), Integer.valueOf(cXV.cSQ), cXV.uni);
                }
            }
        }
        C40261l cXX = cXX();
        if (!C5046bo.isNullOrNil(cXX.unm)) {
            C4990ab.m7411d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", cXX.unm);
        }
        if (c46434d != null) {
            Object obj;
            str2 = "";
            try {
                Bundle g = c46434d.mo15575g(23, new Bundle(0));
                if (g != null) {
                    str2 = g.getString("config_info_username");
                }
                obj = str2;
            } catch (RemoteException e) {
                C4990ab.m7421w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", e);
                str = str2;
            }
            PString pString = new PString();
            C4990ab.m7411d("MicroMsg.WebviewReporter", "report 10643(%s), username : %s, msgId : %s, msgIndex : %s, scene : %s, enterTime : %s, stayTime : %s, rawUrl : %s, publisher : %s, viewId : %s, publishId : %s,appId : %s, newMsgId : %s, preUsername : %s, curUsername : %s, referUrl : %s, statExtStr:%s(%s), chatType:%d, title:%s, expidstr[chatting_exp]:%s, sourceAppId:%s, allStayTime %d", Integer.valueOf(10643), cXX.username, Long.valueOf(cXX.unn), Integer.valueOf(cXX.uno), Integer.valueOf(cXX.scene), Long.valueOf(cXX.edh), Long.valueOf(cXX.iBA), cXX.cOG, cXX.unl, cXX.unm, cXX.fjS, cXX.appId, cXX.unp, cXX.unq, obj, cXX.unr, cXX.rjC, ((C46210i) C1720g.m3528K(C46210i.class)).mo55529a(cXX.rjC, pString), Integer.valueOf(cXX.uns), cXX.title, cXX.dJE, pString.value, Long.valueOf(System.currentTimeMillis() - cXX.edh));
            str2 = cXX.title;
            try {
                str2 = URLEncoder.encode(cXX.title, "UTF-8");
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.WebviewReporter", e2, "", new Object[0]);
            }
            Object[] objArr2 = new Object[26];
            objArr2[0] = cXX.username;
            objArr2[1] = Long.valueOf(cXX.unn);
            objArr2[2] = Integer.valueOf(cXX.uno);
            objArr2[3] = Integer.valueOf(cXX.scene);
            objArr2[4] = Long.valueOf(cXX.edh);
            objArr2[5] = Long.valueOf(cXX.iBA);
            objArr2[6] = cXX.cOG == null ? cXX.cOG : cXX.cOG.replace(",", "!");
            objArr2[7] = cXX.unl;
            objArr2[8] = cXX.unm;
            objArr2[9] = cXX.fjS;
            objArr2[10] = cXX.appId;
            objArr2[11] = cXX.unp;
            objArr2[12] = cXX.unq;
            objArr2[13] = obj;
            if (cXX.unr == null) {
                str = cXX.unr;
            } else {
                str = cXX.unr.replace(",", "!");
            }
            objArr2[14] = str;
            objArr2[15] = r7;
            objArr2[16] = Integer.valueOf(cXX.uns);
            objArr2[17] = str2;
            objArr2[18] = cXX.dJE;
            objArr2[19] = pString.value;
            objArr2[20] = "";
            objArr2[21] = "";
            objArr2[22] = "";
            objArr2[23] = Long.valueOf(System.currentTimeMillis() - cXX.edh);
            objArr2[24] = Long.valueOf(System.currentTimeMillis());
            objArr2[25] = Integer.valueOf(cXX.unt);
            C29916g.m47392a(c46434d, 10643, objArr2);
        }
        C14510a cXY = cXY();
        if (!C5046bo.isNullOrNil(cXY.fjS) && cXY.fjS.startsWith("wrd")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("iswebviewreadtime=1");
            stringBuffer.append("&publishid=");
            stringBuffer.append(cXY.fjS);
            stringBuffer.append("&staytime=");
            stringBuffer.append(cXY.iBA);
            stringBuffer.append("&allstaytime=");
            stringBuffer.append(System.currentTimeMillis() - cXY.edh);
            stringBuffer.append("&maxscrolly=");
            stringBuffer.append(cXY.una);
            stringBuffer.append("&totalscrolly=");
            stringBuffer.append(cXY.rCb);
            stringBuffer.append("&scene=");
            stringBuffer.append(cXY.scene);
            stringBuffer.append("&entertime=");
            stringBuffer.append(cXY.edh);
            stringBuffer.append("&screenheight=");
            stringBuffer.append(C1338a.m2869ge(C4996ah.getContext()));
            Bundle bundle = new Bundle();
            bundle.putString("reportString", stringBuffer.toString());
            try {
                c46434d.mo15582j(6, bundle);
            } catch (Exception e3) {
                C4990ab.printErrStackTrace("MicroMsg.WebviewReporter", e3, "TopStory report", new Object[0]);
            }
        }
        cXU().mo63619b(c46434d);
        cXW().mo63601b(c46434d);
        C40256c cYa = cYa();
        if (c46434d != null) {
            int aEn2 = C40259aq.aEn();
            if (!cYa.unc) {
                C29916g.m47392a(c46434d, 11575, cYa.cOG, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(aEn2));
            } else if (cYa.loadFinished) {
                C29916g.m47392a(c46434d, 11575, cYa.cOG, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(aEn2));
                AppMethodBeat.m2505o(6792);
                return;
            } else {
                C29916g.m47392a(c46434d, 11575, cYa.cOG, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(aEn2));
                AppMethodBeat.m2505o(6792);
                return;
            }
        }
        AppMethodBeat.m2505o(6792);
    }

    /* renamed from: lP */
    public static void m69041lP(long j) {
        AppMethodBeat.m2504i(6793);
        if (j <= 0) {
            AppMethodBeat.m2505o(6793);
            return;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - j);
        if (currentTimeMillis >= 0 && currentTimeMillis < C1625i.sHCENCODEVIDEOTIMEOUT) {
            C7060h.pYm.mo8381e(16269, Integer.valueOf(currentTimeMillis), Integer.valueOf((int) (j / 1000)));
        }
        AppMethodBeat.m2505o(6793);
    }

    /* renamed from: a */
    private static void m69039a(C46434d c46434d, String str, Object... objArr) {
        AppMethodBeat.m2504i(6794);
        if (c46434d == null) {
            AppMethodBeat.m2505o(6794);
            return;
        }
        C29916g.m47392a(c46434d, 11215, objArr);
        if (str != null && str.startsWith("official_mall")) {
            C29916g.m47392a(c46434d, 14919, objArr);
        }
        AppMethodBeat.m2505o(6794);
    }
}
