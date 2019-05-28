package com.tencent.p177mm.plugin.qqmail.stub;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.downloader.model.C11511k;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.qqmail.p486b.C12884ac;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C21523a;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C28746c;
import com.tencent.p177mm.plugin.qqmail.p487ui.ReadMailUI;
import com.tencent.p177mm.plugin.qqmail.p487ui.ReadMailUI.C21551b;
import com.tencent.p177mm.plugin.qqmail.p487ui.ReadMailUI.C28778c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C46509j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C46509j.C35896a;
import com.tencent.p177mm.remoteservice.C31577a;
import com.tencent.p177mm.remoteservice.C40602e;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.remoteservice.C46608f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import java.net.URI;
import java.net.URL;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.qqmail.stub.ReadMailProxy */
public class ReadMailProxy extends C31577a {
    private C21523a puV;
    private C21523a pvK;
    private C21551b pvL;
    private C28778c pvM;
    private C11511k pvN = new C215241();
    private C35896a pvO = new C215252();

    /* renamed from: com.tencent.mm.plugin.qqmail.stub.ReadMailProxy$1 */
    class C215241 implements C11511k {
        C215241() {
        }

        public final void onTaskStarted(long j, String str) {
            AppMethodBeat.m2504i(68079);
            ReadMailProxy.this.CLIENT_CALL("onTaskStarted", Long.valueOf(j), str);
            AppMethodBeat.m2505o(68079);
        }

        public final void onTaskRemoved(long j) {
            AppMethodBeat.m2504i(68080);
            ReadMailProxy.this.CLIENT_CALL("onTaskRemoved", Long.valueOf(j));
            AppMethodBeat.m2505o(68080);
        }

        /* renamed from: b */
        public final void mo7665b(long j, String str, boolean z) {
            AppMethodBeat.m2504i(68081);
            ReadMailProxy.this.CLIENT_CALL("onTaskFinished", Long.valueOf(j));
            AppMethodBeat.m2505o(68081);
        }

        /* renamed from: b */
        public final void mo7664b(long j, int i, boolean z) {
            AppMethodBeat.m2504i(68082);
            ReadMailProxy.this.CLIENT_CALL("onTaskFailed", Long.valueOf(j));
            AppMethodBeat.m2505o(68082);
        }

        public final void onTaskPaused(long j) {
            AppMethodBeat.m2504i(68083);
            ReadMailProxy.this.CLIENT_CALL("onTaskPaused", Long.valueOf(j));
            AppMethodBeat.m2505o(68083);
        }

        /* renamed from: gm */
        public final void mo7667gm(long j) {
        }

        /* renamed from: i */
        public final void mo7669i(long j, String str) {
        }

        /* renamed from: gn */
        public final void mo7668gn(long j) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.stub.ReadMailProxy$2 */
    class C215252 implements C35896a {
        C215252() {
        }

        public final void onSuccess(int i) {
            AppMethodBeat.m2504i(68084);
            ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadSuccess", Integer.valueOf(i));
            AppMethodBeat.m2505o(68084);
        }

        public final void ccH() {
            AppMethodBeat.m2504i(68085);
            ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
            AppMethodBeat.m2505o(68085);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.stub.ReadMailProxy$3 */
    class C248133 extends C21523a {
        C248133() {
        }

        public final boolean onReady() {
            AppMethodBeat.m2504i(68086);
            boolean booleanValue = ((Boolean) ReadMailProxy.this.CLIENT_CALL("onReady", new Object[0])).booleanValue();
            AppMethodBeat.m2505o(68086);
            return booleanValue;
        }

        public final void onSuccess(String str, Map<String, String> map) {
            AppMethodBeat.m2504i(68087);
            ReadMailProxy.this.CLIENT_CALL("onSuccess", str, map);
            AppMethodBeat.m2505o(68087);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(68088);
            ReadMailProxy.this.CLIENT_CALL("onError", Integer.valueOf(i), str);
            AppMethodBeat.m2505o(68088);
        }

        public final void onComplete() {
            AppMethodBeat.m2504i(68089);
            ReadMailProxy.this.CLIENT_CALL("onComplete", new Object[0]);
            AppMethodBeat.m2505o(68089);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.stub.ReadMailProxy$4 */
    class C315804 extends C21523a {
        C315804() {
        }

        public final boolean onReady() {
            AppMethodBeat.m2504i(68090);
            boolean booleanValue = ((Boolean) ReadMailProxy.this.CLIENT_CALL("onReady", new Object[0])).booleanValue();
            AppMethodBeat.m2505o(68090);
            return booleanValue;
        }

        public final void onSuccess(String str, Map<String, String> map) {
            AppMethodBeat.m2504i(68091);
            ReadMailProxy.this.CLIENT_CALL("onSuccess", str, map);
            AppMethodBeat.m2505o(68091);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(68092);
            ReadMailProxy.this.CLIENT_CALL("onError", Integer.valueOf(i), str);
            AppMethodBeat.m2505o(68092);
        }

        public final void onComplete() {
            AppMethodBeat.m2504i(68093);
            ReadMailProxy.this.CLIENT_CALL("onComplete", new Object[0]);
            AppMethodBeat.m2505o(68093);
        }
    }

    public ReadMailProxy(C46607d c46607d, C21523a c21523a) {
        super(c46607d);
        AppMethodBeat.m2504i(68096);
        this.puV = c21523a;
        this.pvK = new C248133();
        AppMethodBeat.m2505o(68096);
    }

    public ReadMailProxy(C46607d c46607d, C21523a c21523a, C21551b c21551b, C28778c c28778c) {
        super(c46607d);
        AppMethodBeat.m2504i(68097);
        this.puV = c21523a;
        this.pvL = c21551b;
        this.pvM = c28778c;
        this.pvK = new C315804();
        AppMethodBeat.m2505o(68097);
    }

    @C40602e
    public boolean onReady() {
        AppMethodBeat.m2504i(68098);
        if (this.puV == null) {
            AppMethodBeat.m2505o(68098);
            return true;
        }
        boolean onReady = this.puV.onReady();
        AppMethodBeat.m2505o(68098);
        return onReady;
    }

    @C40602e
    public void onSuccess(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(68099);
        if (this.puV != null) {
            this.puV.onSuccess(str, map);
        }
        AppMethodBeat.m2505o(68099);
    }

    @C40602e
    public void onError(int i, String str) {
        AppMethodBeat.m2504i(68100);
        if (this.puV != null) {
            this.puV.onError(i, str);
        }
        AppMethodBeat.m2505o(68100);
    }

    @C40602e
    public void onComplete() {
        AppMethodBeat.m2504i(68101);
        if (this.puV != null) {
            this.puV.onComplete();
        }
        AppMethodBeat.m2505o(68101);
    }

    @C40602e
    public void onTaskStarted(long j, String str) {
        AppMethodBeat.m2504i(68102);
        if (this.pvL != null) {
            C21551b c21551b = this.pvL;
            C4990ab.m7411d("MicroMsg.ReadMailUI", "onTaskStarted id:%d, saveFilePath:%s", Long.valueOf(j), str);
            ReadMailUI.this.ehZ = C4996ah.getContext().getSharedPreferences("QQMAIL", C1448h.m3078Mu());
            if (ReadMailUI.this.ehZ != null) {
                ReadMailUI.this.ehZ.edit().putString("qqmail_downloadpath", str).commit();
            }
        }
        AppMethodBeat.m2505o(68102);
    }

    @C40602e
    public void onTaskRemoved(long j) {
        AppMethodBeat.m2504i(68103);
        if (this.pvL != null) {
            C4990ab.m7411d("MicroMsg.ReadMailUI", "onTaskRemoved id:%d", Long.valueOf(j));
        }
        AppMethodBeat.m2505o(68103);
    }

    @C40602e
    public void onTaskPaused(long j) {
        AppMethodBeat.m2504i(68104);
        if (this.pvL != null) {
            C4990ab.m7411d("MicroMsg.ReadMailUI", "onTaskPaused id:%d", Long.valueOf(j));
        }
        AppMethodBeat.m2505o(68104);
    }

    @C40602e
    public void onTaskFinished(long j) {
        AppMethodBeat.m2504i(68105);
        if (this.pvL != null) {
            C4990ab.m7411d("MicroMsg.ReadMailUI", "onTaskFinished id:%d", Long.valueOf(j));
        }
        AppMethodBeat.m2505o(68105);
    }

    @C40602e
    public void onTaskFailed(long j) {
        AppMethodBeat.m2504i(68106);
        if (this.pvL != null) {
            C4990ab.m7411d("MicroMsg.ReadMailUI", "onTaskFailed id:%d", Long.valueOf(j));
        }
        AppMethodBeat.m2505o(68106);
    }

    @C46608f
    public long get(String str, Map map, Bundle bundle) {
        AppMethodBeat.m2504i(68107);
        C28746c c28746c = new C28746c();
        c28746c.fromBundle(bundle);
        long b = C12884ac.ccC().mo62494b(str, map, c28746c, this.pvK);
        AppMethodBeat.m2505o(68107);
        return b;
    }

    @C46608f
    public long post(String str, Map map, Bundle bundle) {
        AppMethodBeat.m2504i(68108);
        C28746c c28746c = new C28746c();
        c28746c.fromBundle(bundle);
        long a = C12884ac.ccC().mo62492a(str, map, c28746c, this.pvK);
        AppMethodBeat.m2505o(68108);
        return a;
    }

    @C46608f
    public void cancel(final long j) {
        AppMethodBeat.m2504i(68109);
        new C7306ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(68094);
                C12884ac.ccC().cancel(j);
                AppMethodBeat.m2505o(68094);
            }
        });
        AppMethodBeat.m2505o(68109);
    }

    @C46608f
    public boolean isSDCardAvailable() {
        AppMethodBeat.m2504i(68110);
        boolean isSDCardAvailable = C1720g.m3536RP().isSDCardAvailable();
        AppMethodBeat.m2505o(68110);
        return isSDCardAvailable;
    }

    @C46608f
    public String getMsgContent(long j) {
        AppMethodBeat.m2504i(68111);
        String str = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j).field_content;
        AppMethodBeat.m2505o(68111);
        return str;
    }

    @C46608f
    public void replaceMsgContent(final long j, final String str) {
        AppMethodBeat.m2504i(68112);
        new C7306ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(68095);
                C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
                jf.setContent(jf.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + str + "</digest>"));
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(j, jf);
                AppMethodBeat.m2505o(68095);
            }
        });
        AppMethodBeat.m2505o(68112);
    }

    @C46608f
    public Map getCookie() {
        AppMethodBeat.m2504i(68113);
        Map cookie = C12884ac.ccC().getCookie();
        AppMethodBeat.m2505o(68113);
        return cookie;
    }

    @C46608f
    public void deleteMsgById(long j) {
        AppMethodBeat.m2504i(68114);
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15341jg(j);
        AppMethodBeat.m2505o(68114);
    }

    @C46608f
    public String getUserBindEmail() {
        AppMethodBeat.m2504i(68115);
        String userBindEmail = C1853r.getUserBindEmail();
        AppMethodBeat.m2505o(68115);
        return userBindEmail;
    }

    @C46608f
    public void addDownloadCallback() {
        AppMethodBeat.m2504i(68116);
        C2896d.bij();
        C2886b.m5131c(this.pvN);
        AppMethodBeat.m2505o(68116);
    }

    @C46608f
    public void removeDownloadCallback() {
        AppMethodBeat.m2504i(68117);
        C2896d.bij();
        C2886b.bif();
        AppMethodBeat.m2505o(68117);
    }

    @C46608f
    public long downloadQQMailApp(String str, String str2) {
        long a;
        AppMethodBeat.m2504i(68118);
        try {
            URL url = new URL(str);
            URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
            C2901a c2901a = new C2901a();
            c2901a.mo7055It(toURL.toString());
            c2901a.mo7057Iv("qqmail.apk");
            c2901a.mo7058Iw(str2);
            c2901a.mo7063ga(true);
            c2901a.mo7069tN(1);
            a = C2896d.bij().mo7042a(c2901a.kNl);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", e.toString());
            C4990ab.printErrStackTrace("MicroMsg.ReadMailProxy", e, "", new Object[0]);
            a = -1;
        }
        AppMethodBeat.m2505o(68118);
        return a;
    }

    @C46608f
    public int removeDownloadQQMailAppTask(long j) {
        AppMethodBeat.m2504i(68119);
        int hl = C2896d.bij().mo7047hl(j);
        AppMethodBeat.m2505o(68119);
        return hl;
    }

    @C46608f
    public String getBindUin() {
        AppMethodBeat.m2504i(68120);
        String c1183p = new C1183p(C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(9, null))).toString();
        AppMethodBeat.m2505o(68120);
        return c1183p;
    }

    @C46608f
    public Integer showMailAppRecommend() {
        AppMethodBeat.m2504i(68121);
        Integer valueOf;
        if (C5059g.cdf == 1) {
            valueOf = Integer.valueOf(0);
            AppMethodBeat.m2505o(68121);
            return valueOf;
        }
        valueOf = Integer.valueOf(C5046bo.getInt(C26373g.m41965Nv().mo5301O("MailApp", "ShowMailAppRecommend"), 0));
        AppMethodBeat.m2505o(68121);
        return valueOf;
    }

    @C46608f
    public String getMailAppEnterUlAndroid() {
        AppMethodBeat.m2504i(68122);
        String mailAppEnterUlAndroid = C26373g.m41965Nv().getMailAppEnterUlAndroid();
        AppMethodBeat.m2505o(68122);
        return mailAppEnterUlAndroid;
    }

    @C46608f
    public String getMailAppRedirectUrlAndroid() {
        AppMethodBeat.m2504i(68123);
        String Nm = C26373g.m41965Nv().mo5300Nm();
        AppMethodBeat.m2505o(68123);
        return Nm;
    }

    @C46608f
    public Integer getMailAppDownloadStatus(long j) {
        AppMethodBeat.m2504i(68124);
        Integer valueOf = Integer.valueOf(C2896d.bij().mo7048hm(j).status);
        AppMethodBeat.m2505o(68124);
        return valueOf;
    }

    @C46608f
    public double getMailAppDownloadProgress(long j) {
        AppMethodBeat.m2504i(68125);
        FileDownloadTaskInfo hm = C2896d.bij().mo7048hm(j);
        if (hm.jrb <= 0) {
            AppMethodBeat.m2505o(68125);
            return 0.0d;
        }
        double d = (1.0d * ((double) hm.kNr)) / ((double) hm.jrb);
        AppMethodBeat.m2505o(68125);
        return d;
    }

    @C46608f
    public void reportKvState(int i, int i2) {
        AppMethodBeat.m2504i(68126);
        C7060h.pYm.mo8381e(i, Integer.valueOf(i2));
        AppMethodBeat.m2505o(68126);
    }

    @C46608f
    public void reportKvStates(int i, int i2, int i3) {
        AppMethodBeat.m2504i(68127);
        C7060h.pYm.mo8381e(i, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.m2505o(68127);
    }

    @C46608f
    public void getUnreadMailCount() {
        AppMethodBeat.m2504i(68128);
        C46509j.m87799a(this.pvO);
        AppMethodBeat.m2505o(68128);
    }

    @C46608f
    public Object getUneradMailCountFromConfig() {
        AppMethodBeat.m2504i(68129);
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1));
        AppMethodBeat.m2505o(68129);
        return obj;
    }
}
