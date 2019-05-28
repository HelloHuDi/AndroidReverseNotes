package com.tencent.mm.plugin.qqmail.stub;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.b;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.c;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy extends a {
    private v.a puV;
    private v.a pvK;
    private b pvL;
    private c pvM;
    private k pvN = new k() {
        public final void onTaskStarted(long j, String str) {
            AppMethodBeat.i(68079);
            ReadMailProxy.this.CLIENT_CALL("onTaskStarted", Long.valueOf(j), str);
            AppMethodBeat.o(68079);
        }

        public final void onTaskRemoved(long j) {
            AppMethodBeat.i(68080);
            ReadMailProxy.this.CLIENT_CALL("onTaskRemoved", Long.valueOf(j));
            AppMethodBeat.o(68080);
        }

        public final void b(long j, String str, boolean z) {
            AppMethodBeat.i(68081);
            ReadMailProxy.this.CLIENT_CALL("onTaskFinished", Long.valueOf(j));
            AppMethodBeat.o(68081);
        }

        public final void b(long j, int i, boolean z) {
            AppMethodBeat.i(68082);
            ReadMailProxy.this.CLIENT_CALL("onTaskFailed", Long.valueOf(j));
            AppMethodBeat.o(68082);
        }

        public final void onTaskPaused(long j) {
            AppMethodBeat.i(68083);
            ReadMailProxy.this.CLIENT_CALL("onTaskPaused", Long.valueOf(j));
            AppMethodBeat.o(68083);
        }

        public final void gm(long j) {
        }

        public final void i(long j, String str) {
        }

        public final void gn(long j) {
        }
    };
    private j.a pvO = new j.a() {
        public final void onSuccess(int i) {
            AppMethodBeat.i(68084);
            ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadSuccess", Integer.valueOf(i));
            AppMethodBeat.o(68084);
        }

        public final void ccH() {
            AppMethodBeat.i(68085);
            ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
            AppMethodBeat.o(68085);
        }
    };

    public ReadMailProxy(d dVar, v.a aVar) {
        super(dVar);
        AppMethodBeat.i(68096);
        this.puV = aVar;
        this.pvK = new v.a() {
            public final boolean onReady() {
                AppMethodBeat.i(68086);
                boolean booleanValue = ((Boolean) ReadMailProxy.this.CLIENT_CALL("onReady", new Object[0])).booleanValue();
                AppMethodBeat.o(68086);
                return booleanValue;
            }

            public final void onSuccess(String str, Map<String, String> map) {
                AppMethodBeat.i(68087);
                ReadMailProxy.this.CLIENT_CALL("onSuccess", str, map);
                AppMethodBeat.o(68087);
            }

            public final void onError(int i, String str) {
                AppMethodBeat.i(68088);
                ReadMailProxy.this.CLIENT_CALL("onError", Integer.valueOf(i), str);
                AppMethodBeat.o(68088);
            }

            public final void onComplete() {
                AppMethodBeat.i(68089);
                ReadMailProxy.this.CLIENT_CALL("onComplete", new Object[0]);
                AppMethodBeat.o(68089);
            }
        };
        AppMethodBeat.o(68096);
    }

    public ReadMailProxy(d dVar, v.a aVar, b bVar, c cVar) {
        super(dVar);
        AppMethodBeat.i(68097);
        this.puV = aVar;
        this.pvL = bVar;
        this.pvM = cVar;
        this.pvK = new v.a() {
            public final boolean onReady() {
                AppMethodBeat.i(68090);
                boolean booleanValue = ((Boolean) ReadMailProxy.this.CLIENT_CALL("onReady", new Object[0])).booleanValue();
                AppMethodBeat.o(68090);
                return booleanValue;
            }

            public final void onSuccess(String str, Map<String, String> map) {
                AppMethodBeat.i(68091);
                ReadMailProxy.this.CLIENT_CALL("onSuccess", str, map);
                AppMethodBeat.o(68091);
            }

            public final void onError(int i, String str) {
                AppMethodBeat.i(68092);
                ReadMailProxy.this.CLIENT_CALL("onError", Integer.valueOf(i), str);
                AppMethodBeat.o(68092);
            }

            public final void onComplete() {
                AppMethodBeat.i(68093);
                ReadMailProxy.this.CLIENT_CALL("onComplete", new Object[0]);
                AppMethodBeat.o(68093);
            }
        };
        AppMethodBeat.o(68097);
    }

    @e
    public boolean onReady() {
        AppMethodBeat.i(68098);
        if (this.puV == null) {
            AppMethodBeat.o(68098);
            return true;
        }
        boolean onReady = this.puV.onReady();
        AppMethodBeat.o(68098);
        return onReady;
    }

    @e
    public void onSuccess(String str, Map<String, String> map) {
        AppMethodBeat.i(68099);
        if (this.puV != null) {
            this.puV.onSuccess(str, map);
        }
        AppMethodBeat.o(68099);
    }

    @e
    public void onError(int i, String str) {
        AppMethodBeat.i(68100);
        if (this.puV != null) {
            this.puV.onError(i, str);
        }
        AppMethodBeat.o(68100);
    }

    @e
    public void onComplete() {
        AppMethodBeat.i(68101);
        if (this.puV != null) {
            this.puV.onComplete();
        }
        AppMethodBeat.o(68101);
    }

    @e
    public void onTaskStarted(long j, String str) {
        AppMethodBeat.i(68102);
        if (this.pvL != null) {
            b bVar = this.pvL;
            ab.d("MicroMsg.ReadMailUI", "onTaskStarted id:%d, saveFilePath:%s", Long.valueOf(j), str);
            ReadMailUI.this.ehZ = ah.getContext().getSharedPreferences("QQMAIL", h.Mu());
            if (ReadMailUI.this.ehZ != null) {
                ReadMailUI.this.ehZ.edit().putString("qqmail_downloadpath", str).commit();
            }
        }
        AppMethodBeat.o(68102);
    }

    @e
    public void onTaskRemoved(long j) {
        AppMethodBeat.i(68103);
        if (this.pvL != null) {
            ab.d("MicroMsg.ReadMailUI", "onTaskRemoved id:%d", Long.valueOf(j));
        }
        AppMethodBeat.o(68103);
    }

    @e
    public void onTaskPaused(long j) {
        AppMethodBeat.i(68104);
        if (this.pvL != null) {
            ab.d("MicroMsg.ReadMailUI", "onTaskPaused id:%d", Long.valueOf(j));
        }
        AppMethodBeat.o(68104);
    }

    @e
    public void onTaskFinished(long j) {
        AppMethodBeat.i(68105);
        if (this.pvL != null) {
            ab.d("MicroMsg.ReadMailUI", "onTaskFinished id:%d", Long.valueOf(j));
        }
        AppMethodBeat.o(68105);
    }

    @e
    public void onTaskFailed(long j) {
        AppMethodBeat.i(68106);
        if (this.pvL != null) {
            ab.d("MicroMsg.ReadMailUI", "onTaskFailed id:%d", Long.valueOf(j));
        }
        AppMethodBeat.o(68106);
    }

    @f
    public long get(String str, Map map, Bundle bundle) {
        AppMethodBeat.i(68107);
        v.c cVar = new v.c();
        cVar.fromBundle(bundle);
        long b = ac.ccC().b(str, map, cVar, this.pvK);
        AppMethodBeat.o(68107);
        return b;
    }

    @f
    public long post(String str, Map map, Bundle bundle) {
        AppMethodBeat.i(68108);
        v.c cVar = new v.c();
        cVar.fromBundle(bundle);
        long a = ac.ccC().a(str, map, cVar, this.pvK);
        AppMethodBeat.o(68108);
        return a;
    }

    @f
    public void cancel(final long j) {
        AppMethodBeat.i(68109);
        new ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(68094);
                ac.ccC().cancel(j);
                AppMethodBeat.o(68094);
            }
        });
        AppMethodBeat.o(68109);
    }

    @f
    public boolean isSDCardAvailable() {
        AppMethodBeat.i(68110);
        boolean isSDCardAvailable = g.RP().isSDCardAvailable();
        AppMethodBeat.o(68110);
        return isSDCardAvailable;
    }

    @f
    public String getMsgContent(long j) {
        AppMethodBeat.i(68111);
        String str = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(j).field_content;
        AppMethodBeat.o(68111);
        return str;
    }

    @f
    public void replaceMsgContent(final long j, final String str) {
        AppMethodBeat.i(68112);
        new ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(68095);
                bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(j);
                jf.setContent(jf.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + str + "</digest>"));
                ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(j, jf);
                AppMethodBeat.o(68095);
            }
        });
        AppMethodBeat.o(68112);
    }

    @f
    public Map getCookie() {
        AppMethodBeat.i(68113);
        Map cookie = ac.ccC().getCookie();
        AppMethodBeat.o(68113);
        return cookie;
    }

    @f
    public void deleteMsgById(long j) {
        AppMethodBeat.i(68114);
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jg(j);
        AppMethodBeat.o(68114);
    }

    @f
    public String getUserBindEmail() {
        AppMethodBeat.i(68115);
        String userBindEmail = r.getUserBindEmail();
        AppMethodBeat.o(68115);
        return userBindEmail;
    }

    @f
    public void addDownloadCallback() {
        AppMethodBeat.i(68116);
        com.tencent.mm.plugin.downloader.model.d.bij();
        com.tencent.mm.plugin.downloader.model.b.c(this.pvN);
        AppMethodBeat.o(68116);
    }

    @f
    public void removeDownloadCallback() {
        AppMethodBeat.i(68117);
        com.tencent.mm.plugin.downloader.model.d.bij();
        com.tencent.mm.plugin.downloader.model.b.bif();
        AppMethodBeat.o(68117);
    }

    @f
    public long downloadQQMailApp(String str, String str2) {
        long a;
        AppMethodBeat.i(68118);
        try {
            URL url = new URL(str);
            URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
            com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
            aVar.It(toURL.toString());
            aVar.Iv("qqmail.apk");
            aVar.Iw(str2);
            aVar.ga(true);
            aVar.tN(1);
            a = com.tencent.mm.plugin.downloader.model.d.bij().a(aVar.kNl);
        } catch (Exception e) {
            ab.e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", e.toString());
            ab.printErrStackTrace("MicroMsg.ReadMailProxy", e, "", new Object[0]);
            a = -1;
        }
        AppMethodBeat.o(68118);
        return a;
    }

    @f
    public int removeDownloadQQMailAppTask(long j) {
        AppMethodBeat.i(68119);
        int hl = com.tencent.mm.plugin.downloader.model.d.bij().hl(j);
        AppMethodBeat.o(68119);
        return hl;
    }

    @f
    public String getBindUin() {
        AppMethodBeat.i(68120);
        String pVar = new p(bo.h((Integer) g.RP().Ry().get(9, null))).toString();
        AppMethodBeat.o(68120);
        return pVar;
    }

    @f
    public Integer showMailAppRecommend() {
        AppMethodBeat.i(68121);
        Integer valueOf;
        if (com.tencent.mm.sdk.platformtools.g.cdf == 1) {
            valueOf = Integer.valueOf(0);
            AppMethodBeat.o(68121);
            return valueOf;
        }
        valueOf = Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nv().O("MailApp", "ShowMailAppRecommend"), 0));
        AppMethodBeat.o(68121);
        return valueOf;
    }

    @f
    public String getMailAppEnterUlAndroid() {
        AppMethodBeat.i(68122);
        String mailAppEnterUlAndroid = com.tencent.mm.m.g.Nv().getMailAppEnterUlAndroid();
        AppMethodBeat.o(68122);
        return mailAppEnterUlAndroid;
    }

    @f
    public String getMailAppRedirectUrlAndroid() {
        AppMethodBeat.i(68123);
        String Nm = com.tencent.mm.m.g.Nv().Nm();
        AppMethodBeat.o(68123);
        return Nm;
    }

    @f
    public Integer getMailAppDownloadStatus(long j) {
        AppMethodBeat.i(68124);
        Integer valueOf = Integer.valueOf(com.tencent.mm.plugin.downloader.model.d.bij().hm(j).status);
        AppMethodBeat.o(68124);
        return valueOf;
    }

    @f
    public double getMailAppDownloadProgress(long j) {
        AppMethodBeat.i(68125);
        FileDownloadTaskInfo hm = com.tencent.mm.plugin.downloader.model.d.bij().hm(j);
        if (hm.jrb <= 0) {
            AppMethodBeat.o(68125);
            return 0.0d;
        }
        double d = (1.0d * ((double) hm.kNr)) / ((double) hm.jrb);
        AppMethodBeat.o(68125);
        return d;
    }

    @f
    public void reportKvState(int i, int i2) {
        AppMethodBeat.i(68126);
        com.tencent.mm.plugin.report.service.h.pYm.e(i, Integer.valueOf(i2));
        AppMethodBeat.o(68126);
    }

    @f
    public void reportKvStates(int i, int i2, int i3) {
        AppMethodBeat.i(68127);
        com.tencent.mm.plugin.report.service.h.pYm.e(i, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(68127);
    }

    @f
    public void getUnreadMailCount() {
        AppMethodBeat.i(68128);
        j.a(this.pvO);
        AppMethodBeat.o(68128);
    }

    @f
    public Object getUneradMailCountFromConfig() {
        AppMethodBeat.i(68129);
        Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1));
        AppMethodBeat.o(68129);
        return obj;
    }
}
