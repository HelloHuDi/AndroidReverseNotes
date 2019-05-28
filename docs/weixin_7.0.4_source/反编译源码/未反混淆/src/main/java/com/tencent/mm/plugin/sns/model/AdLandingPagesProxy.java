package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.tc;
import com.tencent.mm.g.a.td;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdLandingPagesProxy extends com.tencent.mm.remoteservice.a {
    private static AdLandingPagesProxy qHk;
    public static f qHn = new f();
    private Map<Long, e> callbacks = new HashMap();
    private com.tencent.mm.ai.f fur = new com.tencent.mm.ai.f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(35911);
            ab.i("AdLandingPagesProxy", "errType %d,errCode %d,errMsg %s,scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar.toString());
            String str2;
            long longValue;
            if (mVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c) {
                Object obj;
                str2 = "";
                if (i == 0 && i2 == 0) {
                    str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c) mVar).jsonString;
                    ab.i("AdLandingPagesProxy", "the dynamic string is " + str2 + ", sceneType is " + mVar.getType());
                    obj = str2;
                } else {
                    ab.e("AdLandingPagesProxy", "the netscene is error ,error type is " + i + " error msg is " + str + " sceneType is " + mVar.getType());
                    String obj2 = str2;
                }
                if (AdLandingPagesProxy.this.qHl.containsKey(mVar)) {
                    longValue = ((Long) AdLandingPagesProxy.this.qHl.remove(mVar)).longValue();
                    AdLandingPagesProxy.this.CLIENT_CALL("onDynamicUpdateEnd", Long.valueOf(longValue), obj2);
                    com.tencent.mm.kernel.g.Rg().b(mVar.getType(), AdLandingPagesProxy.this.fur);
                }
                AppMethodBeat.o(35911);
                return;
            }
            if (mVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a) {
                if (AdLandingPagesProxy.this.qHl.containsKey(mVar)) {
                    byte[] toByteArray;
                    longValue = ((Long) AdLandingPagesProxy.this.qHl.remove(mVar)).longValue();
                    ab.i("AdLandingPagesProxy", "onSceneEnd id %d", Long.valueOf(longValue));
                    qc qcVar = (qc) ((com.tencent.mm.ai.b) mVar.ftl).fsH.fsP;
                    if (i == 0 && i2 == 0 && qcVar != null) {
                        try {
                            toByteArray = qcVar.toByteArray();
                        } catch (IOException e) {
                            ab.e("AdLandingPagesProxy", bo.l(e));
                            AppMethodBeat.o(35911);
                            return;
                        }
                    }
                    toByteArray = null;
                    AdLandingPagesProxy.this.CLIENT_CALL("onAdChannelEnd", Long.valueOf(longValue), Integer.valueOf(i), Integer.valueOf(i2), toByteArray);
                    com.tencent.mm.kernel.g.Rg().b(mVar.getType(), AdLandingPagesProxy.this.fur);
                    AppMethodBeat.o(35911);
                    return;
                }
            } else if (mVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) {
                if (AdLandingPagesProxy.this.qHl.containsKey(mVar)) {
                    long longValue2 = ((Long) AdLandingPagesProxy.this.qHl.remove(mVar)).longValue();
                    AdLandingPagesProxy adLandingPagesProxy = AdLandingPagesProxy.this;
                    String str3 = "onFavOfficialItemEnd";
                    Object[] objArr = new Object[4];
                    objArr[0] = Long.valueOf(longValue2);
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) mVar;
                    if (bVar.rdB != null) {
                        str2 = bVar.rdB;
                    } else {
                        str2 = "";
                    }
                    objArr[1] = str2;
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Integer.valueOf(i2);
                    adLandingPagesProxy.CLIENT_CALL(str3, objArr);
                    com.tencent.mm.kernel.g.Rg().b(mVar.getType(), AdLandingPagesProxy.this.fur);
                    AppMethodBeat.o(35911);
                    return;
                }
            } else if (mVar instanceof com.tencent.mm.plugin.sns.a.b.e) {
                ab.i("AdLandingPagesProxy", "real time report done.");
                com.tencent.mm.kernel.g.Rg().b(mVar.getType(), AdLandingPagesProxy.this.fur);
            }
            AppMethodBeat.o(35911);
        }
    };
    private Map<m, Long> qHl = new HashMap();
    private com.tencent.mm.remoteservice.d qHm;
    private Map<Long, a> qHo = new HashMap();
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b qHp = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b() {
        public final void progress(long j, int i) {
            AppMethodBeat.i(35912);
            ab.v("AdLandingPagesProxy", "progress %d", Integer.valueOf(i));
            AdLandingPagesProxy.this.CLIENT_CALL("progress", Long.valueOf(j), Integer.valueOf(i));
            AppMethodBeat.o(35912);
        }

        public final void paused(long j) {
            AppMethodBeat.i(35913);
            AdLandingPagesProxy.this.CLIENT_CALL("paused", Long.valueOf(j));
            AppMethodBeat.o(35913);
        }

        public final void stopped(long j) {
            AppMethodBeat.i(35914);
            AdLandingPagesProxy.this.CLIENT_CALL("stopped", Long.valueOf(j));
            AppMethodBeat.o(35914);
        }

        public final void succeed(long j) {
            AppMethodBeat.i(35915);
            AdLandingPagesProxy.this.CLIENT_CALL("succeed", Long.valueOf(j));
            AppMethodBeat.o(35915);
        }

        public final void failed(long j) {
            AppMethodBeat.i(35916);
            AdLandingPagesProxy.this.CLIENT_CALL("failed", Long.valueOf(j));
            AppMethodBeat.o(35916);
        }

        public final void resumed(long j) {
            AppMethodBeat.i(35917);
            AdLandingPagesProxy.this.CLIENT_CALL("resumed", Long.valueOf(j));
            AppMethodBeat.o(35917);
        }
    };
    private Map<String, g> qHq = new HashMap();
    private Map<String, com.tencent.mm.i.h.a> qHr = new HashMap();

    public interface a {
        void CP(int i);

        void cmA();

        void cmB();

        void cmC();
    }

    public interface g {
        void cmD();

        void cmE();
    }

    public static class f {
        long lastUpdateTime = 0;
        boolean qHu = false;
    }

    class b implements com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c {
        private String Iw;
        private String appId;
        private boolean qHt;

        public b(String str, String str2, boolean z) {
            this.Iw = str2;
            this.appId = str;
            this.qHt = z;
        }

        public final void Xz(String str) {
            AppMethodBeat.i(35919);
            ab.i("AdLandingPagesProxy", "pkg %s installed", str);
            if (this.qHt) {
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH.reportDownloadInfo(4, this.appId);
            }
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH.reportDownloadInfo(5, this.appId);
            AppMethodBeat.o(35919);
        }

        public final void XA(String str) {
            AppMethodBeat.i(35920);
            ab.i("AdLandingPagesProxy", "pkg %s removed", str);
            if (!bo.isNullOrNil(str) && str.equals(this.Iw)) {
                AdLandingPagesProxy.this.deleteDeferredDeepLinkMM(str);
            }
            AppMethodBeat.o(35920);
        }
    }

    class c implements com.tencent.mm.plugin.sns.model.b.b {
        private String cHr;

        public c(String str) {
            this.cHr = str;
        }

        public final void Xw(String str) {
        }

        public final void cmu() {
        }

        public final void bk(String str, boolean z) {
        }

        public final void bj(String str, boolean z) {
            AppMethodBeat.i(35921);
            if (!bo.Q(str, this.cHr) && str.equals(this.cHr)) {
                AdLandingPagesProxy.this.CLIENT_CALL("onImgDownloadCallback", str, Boolean.valueOf(z));
                af.cnA().b((com.tencent.mm.plugin.sns.model.b.b) this);
            }
            AppMethodBeat.o(35921);
        }
    }

    class d implements com.tencent.mm.i.h.a {
        private String cHr;

        public d(String str) {
            this.cHr = str;
        }

        public final void onMoovReady(String str, int i, int i2) {
            AppMethodBeat.i(35922);
            if (str.equals(this.cHr)) {
                h.pYm.k(955, 26, 1);
                AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoMoovReady", str, Integer.valueOf(i), Integer.valueOf(i2));
            }
            AppMethodBeat.o(35922);
        }

        public final void onDataAvailable(String str, int i, int i2) {
            AppMethodBeat.i(35923);
            if (str.equals(this.cHr)) {
                h.pYm.k(955, 28, 1);
                AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoDataAvailable", str, Integer.valueOf(i), Integer.valueOf(i2));
            }
            AppMethodBeat.o(35923);
        }

        public final void h(String str, int i, int i2) {
            AppMethodBeat.i(35924);
            if (str.equals(this.cHr)) {
                AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoProgress", str, Integer.valueOf(i), Integer.valueOf(i2));
            }
            AppMethodBeat.o(35924);
        }

        public final void a(String str, int i, com.tencent.mm.i.d dVar) {
            AppMethodBeat.i(35925);
            if (str.equals(this.cHr)) {
                h.pYm.k(955, 30, 1);
                AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoFinish", str, Integer.valueOf(i));
            }
            AppMethodBeat.o(35925);
        }
    }

    public interface e {
        void ao(Object obj);

        void f(int i, int i2, Object obj);
    }

    static {
        AppMethodBeat.i(36061);
        AppMethodBeat.o(36061);
    }

    public void connect(Runnable runnable) {
        AppMethodBeat.i(35926);
        this.qHm.connect(runnable);
        AppMethodBeat.o(35926);
    }

    public AdLandingPagesProxy(com.tencent.mm.remoteservice.d dVar) {
        super(dVar);
        AppMethodBeat.i(35927);
        this.qHm = dVar;
        AppMethodBeat.o(35927);
    }

    public static AdLandingPagesProxy getInstance() {
        AppMethodBeat.i(35928);
        if (qHk == null) {
            qHk = new AdLandingPagesProxy(new com.tencent.mm.remoteservice.d(ah.getContext()));
        }
        AdLandingPagesProxy adLandingPagesProxy = qHk;
        AppMethodBeat.o(35928);
        return adLandingPagesProxy;
    }

    public boolean isConnected() {
        AppMethodBeat.i(35929);
        if (this.qHm == null) {
            AppMethodBeat.o(35929);
            return false;
        }
        boolean isConnected = this.qHm.isConnected();
        AppMethodBeat.o(35929);
        return isConnected;
    }

    public Object getCfg(int i, Object obj) {
        AppMethodBeat.i(35930);
        Object REMOTE_CALL = REMOTE_CALL("getCfgMM", Integer.valueOf(i), obj);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(35930);
            return obj;
        }
        AppMethodBeat.o(35930);
        return REMOTE_CALL;
    }

    @com.tencent.mm.remoteservice.f
    public Object getCfgMM(int i, Object obj) {
        AppMethodBeat.i(35931);
        com.tencent.mm.kernel.g.RQ();
        Object obj2 = com.tencent.mm.kernel.g.RP().Ry().get(i, obj);
        AppMethodBeat.o(35931);
        return obj2;
    }

    public int contactGetTypeTextFromUserName(String str) {
        AppMethodBeat.i(35932);
        Object REMOTE_CALL = REMOTE_CALL("contactGetTypeTextFromUserNameMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(35932);
            return 0;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.o(35932);
        return intValue;
    }

    @com.tencent.mm.remoteservice.f
    public int contactGetTypeTextFromUserNameMM(String str) {
        AppMethodBeat.i(35933);
        int nK = t.nK(str);
        AppMethodBeat.o(35933);
        return nK;
    }

    public String getSnsStatExtBySnsId(long j) {
        AppMethodBeat.i(35934);
        String str = (String) REMOTE_CALL("getSnsStatExtBySnsIdMM", Long.valueOf(j));
        AppMethodBeat.o(35934);
        return str;
    }

    public String getAccSnsPath() {
        AppMethodBeat.i(35936);
        String str = (String) REMOTE_CALL("getAccSnsPathMM", new Object[0]);
        AppMethodBeat.o(35936);
        return str;
    }

    @com.tencent.mm.remoteservice.f
    public String getAccSnsPathMM() {
        AppMethodBeat.i(35937);
        String accSnsPath = af.getAccSnsPath();
        AppMethodBeat.o(35937);
        return accSnsPath;
    }

    public String getSnsAid(String str) {
        AppMethodBeat.i(35938);
        String str2 = (String) REMOTE_CALL("getSnsAidMM", str);
        AppMethodBeat.o(35938);
        return str2;
    }

    @com.tencent.mm.remoteservice.f
    public String getSnsAidMM(String str) {
        AppMethodBeat.i(35939);
        n YS = af.cnF().YS(str);
        String cqZ;
        if (YS != null) {
            cqZ = YS.cqZ();
            AppMethodBeat.o(35939);
            return cqZ;
        }
        cqZ = "";
        AppMethodBeat.o(35939);
        return cqZ;
    }

    public int getSnsAdType(String str) {
        AppMethodBeat.i(35940);
        int intValue = ((Integer) REMOTE_CALL("getSnsAdTypeMM", str)).intValue();
        AppMethodBeat.o(35940);
        return intValue;
    }

    @com.tencent.mm.remoteservice.f
    public int getSnsAdTypeMM(String str) {
        AppMethodBeat.i(35941);
        n YS = af.cnF().YS(str);
        if (YS != null) {
            int crf = YS.crf();
            AppMethodBeat.o(35941);
            return crf;
        }
        AppMethodBeat.o(35941);
        return 0;
    }

    public void confirmDialPhoneNum(Activity activity, String str) {
        AppMethodBeat.i(35942);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(35942);
            return;
        }
        Intent intent = new Intent(ah.getContext(), SnsTransparentUI.class);
        intent.putExtra("phoneNum", str);
        intent.putExtra("op", 4);
        activity.startActivity(intent);
        AppMethodBeat.o(35942);
    }

    public String getSnsTraceid(String str) {
        AppMethodBeat.i(35943);
        String str2 = (String) REMOTE_CALL("getSnsTraceidMM", str);
        AppMethodBeat.o(35943);
        return str2;
    }

    @com.tencent.mm.remoteservice.f
    public String getSnsTraceidMM(String str) {
        AppMethodBeat.i(35944);
        n YS = af.cnF().YS(str);
        String cra;
        if (YS != null) {
            cra = YS.cra();
            AppMethodBeat.o(35944);
            return cra;
        }
        cra = "";
        AppMethodBeat.o(35944);
        return cra;
    }

    public String getSnsUxInfo(String str) {
        AppMethodBeat.i(35945);
        String str2 = (String) REMOTE_CALL("getSnsUxInfoMM", str);
        AppMethodBeat.o(35945);
        return str2;
    }

    @com.tencent.mm.remoteservice.f
    public String getSnsUxInfoMM(String str) {
        AppMethodBeat.i(35946);
        n YS = af.cnF().YS(str);
        String crc;
        if (YS != null) {
            crc = YS.crc();
            AppMethodBeat.o(35946);
            return crc;
        }
        crc = "";
        AppMethodBeat.o(35946);
        return crc;
    }

    public boolean isRecExpAd(String str) {
        AppMethodBeat.i(35947);
        Object REMOTE_CALL = REMOTE_CALL("isRecExpAdMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(35947);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(35947);
        return booleanValue;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isRecExpAdMM(String str) {
        AppMethodBeat.i(35948);
        n YS = af.cnF().YS(str);
        if (YS == null) {
            AppMethodBeat.o(35948);
            return false;
        }
        boolean coX = YS.coX();
        AppMethodBeat.o(35948);
        return coX;
    }

    public n getSnsInfo(String str) {
        Bundle bundle = null;
        AppMethodBeat.i(35949);
        try {
            Bundle bundle2 = (Bundle) REMOTE_CALL("getSnsInfoMM", str);
            if (bundle2 == null) {
                AppMethodBeat.o(35949);
                return null;
            }
            bundle = bundle2;
            n nVar = new n();
            if (bundle != null) {
                ContentValues contentValues = (ContentValues) bundle.getParcelable("values");
                nVar.field_snsId = contentValues.getAsLong("snsId").longValue();
                nVar.field_userName = contentValues.getAsString("userName");
                nVar.field_localFlag = contentValues.getAsInteger("localFlag").intValue();
                nVar.field_createTime = contentValues.getAsInteger("createTime").intValue();
                nVar.field_head = contentValues.getAsInteger("head").intValue();
                nVar.field_localPrivate = contentValues.getAsInteger("localPrivate").intValue();
                nVar.field_type = contentValues.getAsInteger("type").intValue();
                nVar.field_sourceType = contentValues.getAsInteger("sourceType").intValue();
                nVar.field_likeFlag = contentValues.getAsInteger("likeFlag").intValue();
                nVar.field_pravited = contentValues.getAsInteger("pravited").intValue();
                nVar.field_stringSeq = contentValues.getAsString("stringSeq");
                nVar.field_content = contentValues.getAsByteArray(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT);
                nVar.field_attrBuf = contentValues.getAsByteArray("attrBuf");
                nVar.field_postBuf = contentValues.getAsByteArray("postBuf");
                nVar.field_subType = contentValues.getAsInteger("subType").intValue();
                if (contentValues.containsKey("rowid")) {
                    nVar.xDa = contentValues.getAsLong("rowid").longValue();
                }
                nVar.reX = bundle.getInt("localid");
                bundle2 = bundle.getBundle("adValues");
                if (bundle2 != null) {
                    com.tencent.mm.plugin.sns.storage.e eVar = new com.tencent.mm.plugin.sns.storage.e();
                    eVar.L(bundle2);
                    nVar.rfh = eVar;
                }
            }
            AppMethodBeat.o(35949);
            return nVar;
        } catch (Exception e) {
            ab.printErrStackTrace("AdLandingPagesProxy", e, "", new Object[0]);
        }
    }

    @com.tencent.mm.remoteservice.f
    public Bundle getSnsInfoMM(String str) {
        AppMethodBeat.i(35950);
        n YS = af.cnF().YS(str);
        if (YS == null) {
            AppMethodBeat.o(35950);
            return null;
        }
        Bundle cqC = YS.cqC();
        AppMethodBeat.o(35950);
        return cqC;
    }

    public String getUin() {
        AppMethodBeat.i(35951);
        Object REMOTE_CALL = REMOTE_CALL("getUinMM", new Object[0]);
        String str;
        if (REMOTE_CALL == null) {
            str = "";
            AppMethodBeat.o(35951);
            return str;
        }
        str = (String) REMOTE_CALL;
        AppMethodBeat.o(35951);
        return str;
    }

    @com.tencent.mm.remoteservice.f
    public String getUinMM() {
        AppMethodBeat.i(35952);
        com.tencent.mm.kernel.g.RN();
        String QG = com.tencent.mm.kernel.a.QG();
        AppMethodBeat.o(35952);
        return QG;
    }

    public boolean useOnlineStreamPlayer() {
        AppMethodBeat.i(35953);
        Object REMOTE_CALL = REMOTE_CALL("useOnlineStreamPlayerMM", new Object[0]);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(35953);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(35953);
        return booleanValue;
    }

    @com.tencent.mm.remoteservice.f
    public boolean useOnlineStreamPlayerMM() {
        AppMethodBeat.i(35954);
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100208");
        if (ll.isValid()) {
            int i = bo.getInt((String) ll.dru().get("useOnlineVideoPlayer"), 0);
            ab.i("AdLandingPagesProxy", "useOnlineVideoPlayer abtest=".concat(String.valueOf(i)));
            if (i == 1) {
                AppMethodBeat.o(35954);
                return true;
            }
            AppMethodBeat.o(35954);
            return false;
        }
        AppMethodBeat.o(35954);
        return false;
    }

    @com.tencent.mm.remoteservice.f
    public int getExpValueByKeyMM(String str, int i) {
        AppMethodBeat.i(35955);
        int en = com.tencent.mm.model.c.c.abj().en(str, i);
        AppMethodBeat.o(35955);
        return en;
    }

    public int getExpValueByKey(String str, int i) {
        AppMethodBeat.i(35956);
        Object REMOTE_CALL = REMOTE_CALL("getExpValueByKeyMM", str, Integer.valueOf(i));
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(35956);
            return -1;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.o(35956);
        return intValue;
    }

    @com.tencent.mm.remoteservice.f
    public String getExpIdByKeyMM(String str) {
        AppMethodBeat.i(35957);
        String expIdByKey = com.tencent.mm.model.c.c.abj().getExpIdByKey(str);
        AppMethodBeat.o(35957);
        return expIdByKey;
    }

    public String getExpIdByKey(String str) {
        AppMethodBeat.i(35958);
        String str2 = (String) REMOTE_CALL("getExpIdByKeyMM", str);
        AppMethodBeat.o(35958);
        return str2;
    }

    public int isAutoAdDownload() {
        AppMethodBeat.i(35959);
        Object REMOTE_CALL = REMOTE_CALL("isAutoAdDownloadMM", new Object[0]);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(35959);
            return 0;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.o(35959);
        return intValue;
    }

    public void favEditTag() {
        AppMethodBeat.i(35960);
        REMOTE_CALL("favEditTagMM", new Object[0]);
        AppMethodBeat.o(35960);
    }

    @com.tencent.mm.remoteservice.f
    public void favEditTagMM() {
        AppMethodBeat.i(35961);
        gh ghVar = new gh();
        ghVar.cAH.type = 35;
        com.tencent.mm.sdk.b.a.xxA.m(ghVar);
        AppMethodBeat.o(35961);
    }

    @com.tencent.mm.remoteservice.f
    public int isAutoAdDownloadMM() {
        AppMethodBeat.i(35962);
        int b = af.cnC().b(null, null);
        AppMethodBeat.o(35962);
        return b;
    }

    public int doFavAdlanding(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8) {
        AppMethodBeat.i(35963);
        Object REMOTE_CALL = REMOTE_CALL("doFavAdlandingMM", Long.valueOf(j), str, Integer.valueOf(i), str2, str3, str4, str5, str6, Integer.valueOf(i2), str7, str8);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(35963);
            return 0;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.o(35963);
        return intValue;
    }

    @com.tencent.mm.remoteservice.f
    public int doFavAdlandingMM(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8) {
        AppMethodBeat.i(35964);
        cl clVar = new cl();
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 9 || i == 10 || i == 11) {
            bo.isNullOrNil(str);
        }
        ((ad) com.tencent.mm.kernel.g.K(ad.class)).a(clVar, str6.hashCode(), r.Yz(), str4, str5, str6, str7, str2);
        clVar.cvA.cvF = v.nW(str3);
        clVar.cvA.title = str4;
        clVar.cvA.desc = str5;
        abf abf = clVar.cvA.cvC;
        if (!(abf == null || abf.wiv == null || abf.wiv.size() <= 0 || abf.wiv.get(0) == null)) {
            ((aar) abf.wiv.get(0)).alg(str6);
            ((aar) abf.wiv.get(0)).akH(str4);
            ((aar) abf.wiv.get(0)).akI(str5);
            ((aar) abf.wiv.get(0)).alf(str8);
        }
        if (abf != null) {
            abf.alB(str4);
            abf.alC(str5);
        }
        clVar.cvA.cvH = i2;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        int i3 = clVar.cvA.cvG;
        AppMethodBeat.o(35964);
        return i3;
    }

    public int doFav(Intent intent, int i) {
        AppMethodBeat.i(35965);
        Object REMOTE_CALL = REMOTE_CALL("doFavMM", intent, Integer.valueOf(i));
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(35965);
            return 0;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.o(35965);
        return intValue;
    }

    @com.tencent.mm.remoteservice.f
    public int doFavMM(Intent intent, int i) {
        AppMethodBeat.i(35966);
        cl clVar = new cl();
        ((ad) com.tencent.mm.kernel.g.K(ad.class)).a(clVar, intent);
        clVar.cvA.cvH = i;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        int i2 = clVar.cvA.cvG;
        AppMethodBeat.o(35966);
        return i2;
    }

    public void doTransimt(Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(35967);
        Intent intent = new Intent(ah.getContext(), SnsTransparentUI.class);
        intent.putExtra("adlandingXml", str);
        intent.putExtra("shareTitle", str2);
        intent.putExtra("shareThumbUrl", str3);
        intent.putExtra("shareDesc", str4);
        intent.putExtra("shareUrl", str5);
        intent.putExtra("statExtStr", str6);
        intent.putExtra("op", 2);
        activity.startActivity(intent);
        AppMethodBeat.o(35967);
    }

    @com.tencent.mm.remoteservice.f
    public void doTransimtMM(String str, String str2, String str3, String str4, String str5) {
    }

    public void doDynamicUpdateScene(String str, String str2, String str3, e eVar) {
        AppMethodBeat.i(35968);
        this.callbacks.put(Long.valueOf(System.currentTimeMillis()), eVar);
        REMOTE_CALL("doDynamicUpdateSceneMM", Long.valueOf(r0), str, str2, str3);
        AppMethodBeat.o(35968);
    }

    @com.tencent.mm.remoteservice.f
    public void doDynamicUpdateSceneMM(long j, String str, String str2, String str3) {
        AppMethodBeat.i(35969);
        m cVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(str, str2, str3);
        this.qHl.put(cVar, Long.valueOf(j));
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(cVar, 0);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(1337, this.fur);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(2721, this.fur);
        AppMethodBeat.o(35969);
    }

    @com.tencent.mm.remoteservice.e
    public void onDynamicUpdateEnd(long j, String str) {
        AppMethodBeat.i(35970);
        e eVar = (e) this.callbacks.remove(Long.valueOf(j));
        if (!(eVar == null || bo.isNullOrNil(str))) {
            eVar.ao(str);
        }
        AppMethodBeat.o(35970);
    }

    public void doSearchDynamicUpdateScene(String str, e eVar) {
        AppMethodBeat.i(35971);
        this.callbacks.put(Long.valueOf(System.currentTimeMillis()), eVar);
        REMOTE_CALL("doSearchDynamicUpdateSceneMM", Long.valueOf(r0), str);
        AppMethodBeat.o(35971);
    }

    @com.tencent.mm.remoteservice.f
    public void doSearchDynamicUpdateSceneMM(long j, String str) {
        AppMethodBeat.i(35972);
        m cVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(str);
        this.qHl.put(cVar, Long.valueOf(j));
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(cVar, 0);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(1337, this.fur);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(2721, this.fur);
        AppMethodBeat.o(35972);
    }

    @com.tencent.mm.remoteservice.e
    public void onAdChannelEnd(long j, int i, int i2, Object obj) {
        AppMethodBeat.i(35973);
        e eVar = (e) this.callbacks.remove(Long.valueOf(j));
        if (eVar != null) {
            eVar.f(i, i2, obj);
        }
        AppMethodBeat.o(35973);
    }

    public void doAdChannelScene(String str, String str2, e eVar) {
        AppMethodBeat.i(35974);
        this.callbacks.put(Long.valueOf(System.currentTimeMillis()), eVar);
        REMOTE_CALL("doAdChannelSceneMM", Long.valueOf(r0), str, str2);
        AppMethodBeat.o(35974);
    }

    @com.tencent.mm.remoteservice.f
    public void doAdChannelSceneMM(long j, String str, String str2) {
        AppMethodBeat.i(35975);
        m aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a(str, str2);
        this.qHl.put(aVar, Long.valueOf(j));
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(aVar, 0);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(1210, this.fur);
        AppMethodBeat.o(35975);
    }

    public void playTimelineClickAnimation(long j) {
        AppMethodBeat.i(35976);
        this.callbacks.put(Long.valueOf(System.currentTimeMillis()), null);
        REMOTE_CALL("playTimelineClickAnimationMM", Long.valueOf(r0), Long.valueOf(j));
        AppMethodBeat.o(35976);
    }

    @com.tencent.mm.remoteservice.f
    public void playTimelineClickAnimationMM(long j, long j2) {
        AppMethodBeat.i(35977);
        td tdVar = new td();
        tdVar.cPq.cvc = j2;
        com.tencent.mm.sdk.b.a.xxA.m(tdVar);
        AppMethodBeat.o(35977);
    }

    public void playTimelineBackAnimation(long j) {
        AppMethodBeat.i(35978);
        this.callbacks.put(Long.valueOf(System.currentTimeMillis()), null);
        REMOTE_CALL("playTimelineBackAnimationMM", Long.valueOf(r0), Long.valueOf(j));
        AppMethodBeat.o(35978);
    }

    @com.tencent.mm.remoteservice.f
    public void playTimelineBackAnimationMM(long j, long j2) {
        AppMethodBeat.i(35979);
        tc tcVar = new tc();
        tcVar.cPp.cvc = j2;
        com.tencent.mm.sdk.b.a.xxA.m(tcVar);
        AppMethodBeat.o(35979);
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(35980);
        ab.d("AdLandingPagesProxy", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? com.tencent.mm.remoteservice.e.class : com.tencent.mm.remoteservice.f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() != Void.TYPE) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable("result_key", (Parcelable) invoke);
                            AppMethodBeat.o(35980);
                            return;
                        }
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
            AppMethodBeat.o(35980);
        } catch (Exception e) {
            ab.e("AdLandingPagesProxy", "exception:%s", bo.l(e));
            AppMethodBeat.o(35980);
        }
    }

    @com.tencent.mm.remoteservice.e
    public boolean isApkExist(String str) {
        AppMethodBeat.i(35981);
        Object REMOTE_CALL = REMOTE_CALL("isApkExistMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(35981);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(35981);
        return booleanValue;
    }

    public boolean isDownloading(String str) {
        AppMethodBeat.i(35984);
        Object REMOTE_CALL = REMOTE_CALL("isDownloadingMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(35984);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(35984);
        return booleanValue;
    }

    public boolean isPkgInstalled(String str) {
        AppMethodBeat.i(35986);
        Object REMOTE_CALL = REMOTE_CALL("isPkgInstalledMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(35986);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(35986);
        return booleanValue;
    }

    public boolean isPaused(String str) {
        AppMethodBeat.i(35988);
        Object REMOTE_CALL = REMOTE_CALL("isPausedMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(35988);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(35988);
        return booleanValue;
    }

    @com.tencent.mm.remoteservice.e
    public void start(long j) {
        AppMethodBeat.i(35989);
        this.qHo.get(Long.valueOf(j));
        AppMethodBeat.o(35989);
    }

    @com.tencent.mm.remoteservice.e
    public void progress(long j, int i) {
        AppMethodBeat.i(35990);
        ab.v("AdLandingPagesProxy", "progress client id %d , progress %d", Long.valueOf(j), Integer.valueOf(i));
        a aVar = (a) this.qHo.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.CP(i);
        }
        AppMethodBeat.o(35990);
    }

    @com.tencent.mm.remoteservice.e
    public void paused(long j) {
        AppMethodBeat.i(35991);
        a aVar = (a) this.qHo.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.cmA();
        }
        AppMethodBeat.o(35991);
    }

    @com.tencent.mm.remoteservice.e
    public void stopped(long j) {
        AppMethodBeat.i(35992);
        if (((a) this.qHo.get(Long.valueOf(j))) != null) {
            this.qHo.remove(Long.valueOf(j));
        }
        AppMethodBeat.o(35992);
    }

    @com.tencent.mm.remoteservice.e
    public void succeed(long j) {
        AppMethodBeat.i(35993);
        a aVar = (a) this.qHo.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.cmB();
            this.qHo.remove(Long.valueOf(j));
        }
        AppMethodBeat.o(35993);
    }

    @com.tencent.mm.remoteservice.e
    public void failed(long j) {
        AppMethodBeat.i(35994);
        a aVar = (a) this.qHo.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.cmC();
            this.qHo.remove(Long.valueOf(j));
        }
        AppMethodBeat.o(35994);
    }

    @com.tencent.mm.remoteservice.e
    public void resumed(long j) {
        AppMethodBeat.i(35995);
        this.qHo.get(Long.valueOf(j));
        AppMethodBeat.o(35995);
    }

    public long startDownload(String str, String str2, String str3, String str4, String str5, boolean z, a aVar, String str6, String str7) {
        AppMethodBeat.i(35997);
        ab.v("AdLandingPagesProxy", "startDownload");
        Object REMOTE_CALL = REMOTE_CALL("startDownloadMM", str, str2, str3, str4, str5, Boolean.valueOf(z), str6, str7);
        long longValue = REMOTE_CALL == null ? -1 : ((Long) REMOTE_CALL).longValue();
        this.qHo.put(Long.valueOf(longValue), aVar);
        AppMethodBeat.o(35997);
        return longValue;
    }

    public void stopTask(String str) {
        AppMethodBeat.i(35999);
        REMOTE_CALL("stopTaskMM", str);
        AppMethodBeat.o(35999);
    }

    public long queryIdByAppid(String str) {
        AppMethodBeat.i(36001);
        Object REMOTE_CALL = REMOTE_CALL("queryIdByAppidMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(36001);
            return -1;
        }
        long longValue = ((Long) REMOTE_CALL).longValue();
        AppMethodBeat.o(36001);
        return longValue;
    }

    public boolean pauseTask(String str) {
        AppMethodBeat.i(36003);
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(36003);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(36003);
        return booleanValue;
    }

    public int getTaskProgress(String str) {
        AppMethodBeat.i(36005);
        Object REMOTE_CALL = REMOTE_CALL("getTaskProgressMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(36005);
            return -1;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.o(36005);
        return intValue;
    }

    public boolean resumeTask(String str, a aVar, String str2, String str3) {
        AppMethodBeat.i(36007);
        Object REMOTE_CALL = REMOTE_CALL("resumeTaskMM", str, str2, str3);
        boolean booleanValue = REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
        if (booleanValue) {
            this.qHo.put(Long.valueOf(queryIdByAppid(str)), aVar);
        }
        AppMethodBeat.o(36007);
        return booleanValue;
    }

    public boolean installApp(Context context, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(36009);
        Object REMOTE_CALL = REMOTE_CALL("installAppMM", str, str2, str3, str4);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(36009);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(36009);
        return booleanValue;
    }

    public void reportDownloadInfo(int i, String str) {
        AppMethodBeat.i(36011);
        REMOTE_CALL("reportDownloadInfoMM", Integer.valueOf(i), str);
        AppMethodBeat.o(36011);
    }

    public void addReportInfo(String str, String str2, String str3) {
        AppMethodBeat.i(36013);
        REMOTE_CALL("addReportInfoMM", str, str2, str3);
        AppMethodBeat.o(36013);
    }

    public void writeDeferredDeepLink(String str, String str2) {
        AppMethodBeat.i(36014);
        REMOTE_CALL("writeDeferredDeepLinkMM", str, str2);
        AppMethodBeat.o(36014);
    }

    @com.tencent.mm.remoteservice.f
    public void writeDeferredDeepLinkMM(String str, String str2) {
        AppMethodBeat.i(36015);
        Ii().edit().putString(str, str2).commit();
        AppMethodBeat.o(36015);
    }

    public void deleteDeferredDeepLink(String str) {
        AppMethodBeat.i(36016);
        REMOTE_CALL("deleteDeferredDeepLinkMM", str);
        AppMethodBeat.o(36016);
    }

    @com.tencent.mm.remoteservice.f
    public void deleteDeferredDeepLinkMM(String str) {
        AppMethodBeat.i(36017);
        Ii().edit().remove(str).commit();
        AppMethodBeat.o(36017);
    }

    private static SharedPreferences Ii() {
        AppMethodBeat.i(36018);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(ah.getPackageName() + "_comm_preferences", 0);
        AppMethodBeat.o(36018);
        return sharedPreferences;
    }

    @com.tencent.mm.remoteservice.e
    public void addCanvasCache(long j, String str) {
        AppMethodBeat.i(36019);
        REMOTE_CALL("addCanvasCacheMM", Long.valueOf(j), str);
        AppMethodBeat.o(36019);
    }

    @com.tencent.mm.remoteservice.f
    public void addCanvasCacheMM(long j, String str) {
        AppMethodBeat.i(36020);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.cqn().u(j, str);
        AppMethodBeat.o(36020);
    }

    @com.tencent.mm.remoteservice.e
    public void asyncCacheXml(String str) {
        AppMethodBeat.i(36021);
        REMOTE_CALL("asyncCacheXmlMM", str);
        AppMethodBeat.o(36021);
    }

    @com.tencent.mm.remoteservice.f
    public void asyncCacheXmlMM(final String str) {
        AppMethodBeat.i(36022);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RS().m(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35918);
                if (com.tencent.mm.kernel.g.RN().QY()) {
                    n YS = af.cnF().YS(str);
                    if (YS != null) {
                        com.tencent.mm.plugin.sns.storage.b cqo = YS.cqo();
                        if (cqo != null) {
                            AdLandingPagesProxy.Xy(cqo.coT());
                            AdLandingPagesProxy.Xy(cqo.coU());
                        }
                    }
                    AppMethodBeat.o(35918);
                    return;
                }
                AppMethodBeat.o(35918);
            }
        }, 5000);
        AppMethodBeat.o(36022);
    }

    public int getAdVoteIndex(String str, String str2, String str3) {
        AppMethodBeat.i(36023);
        int intValue = ((Integer) REMOTE_CALL("getAdVoteIndexMM", str, str2, str3)).intValue();
        AppMethodBeat.o(36023);
        return intValue;
    }

    @com.tencent.mm.remoteservice.f
    public int getAdVoteIndexMM(String str, String str2, String str3) {
        AppMethodBeat.i(36024);
        int ak = com.tencent.mm.plugin.sns.storage.v.ak(str, str2, str3);
        AppMethodBeat.o(36024);
        return ak;
    }

    public String getAdVoteInfo(String str, String str2, String str3) {
        AppMethodBeat.i(36025);
        String str4 = (String) REMOTE_CALL("getAdVoteInfoMM", str, str2, str3);
        AppMethodBeat.o(36025);
        return str4;
    }

    @com.tencent.mm.remoteservice.f
    public String getAdVoteInfoMM(String str, String str2, String str3) {
        AppMethodBeat.i(36026);
        String al = com.tencent.mm.plugin.sns.storage.v.al(str, str2, str3);
        AppMethodBeat.o(36026);
        return al;
    }

    public void saveAdVoteInfo(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(36027);
        REMOTE_CALL("saveAdVoteInfoMM", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(36027);
    }

    @com.tencent.mm.remoteservice.f
    public void saveAdVoteInfoMM(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(36028);
        com.tencent.mm.plugin.sns.storage.v.h(str, str2, str3, i, i2);
        AppMethodBeat.o(36028);
    }

    public void doFavOfficialItemScene(String str, e eVar) {
        AppMethodBeat.i(36029);
        if (bo.isNullOrNil(str)) {
            ab.e("AdLandingPagesProxy", "doFavOfficialItemScene with empty itemBuff, interrupted!");
            AppMethodBeat.o(36029);
            return;
        }
        this.callbacks.put(Long.valueOf(System.currentTimeMillis()), eVar);
        REMOTE_CALL("doFavOfficialItemSceneMM", Long.valueOf(r0), str);
        AppMethodBeat.o(36029);
    }

    @com.tencent.mm.remoteservice.f
    public void doFavOfficialItemSceneMM(long j, String str) {
        AppMethodBeat.i(36030);
        m bVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b(str);
        this.qHl.put(bVar, Long.valueOf(j));
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(bVar, 0);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(2874, this.fur);
        AppMethodBeat.o(36030);
    }

    @com.tencent.mm.remoteservice.e
    public void onFavOfficialItemEnd(long j, String str, int i, int i2) {
        AppMethodBeat.i(36031);
        e eVar = (e) this.callbacks.remove(Long.valueOf(j));
        if (i == 0 && i2 == 0) {
            ab.i("AdLandingPagesProxy", "FavOfficialItem succeed, item_buff[%s]", str);
        } else {
            ab.e("AdLandingPagesProxy", "FavOfficialItem fail, errrType[%d], errCode[%d], item_buff[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
        }
        if (eVar != null) {
            eVar.f(i, i2, null);
        }
        AppMethodBeat.o(36031);
    }

    public String getSnsAdCanvasExtXml(String str) {
        AppMethodBeat.i(36032);
        String str2 = (String) REMOTE_CALL("getSnsAdCanvasExtXmlMM", str);
        AppMethodBeat.o(36032);
        return str2;
    }

    @com.tencent.mm.remoteservice.f
    public String getSnsAdCanvasExtXmlMM(String str) {
        AppMethodBeat.i(36033);
        n YS = af.cnF().YS(str);
        String str2;
        if (YS != null) {
            str2 = YS.cqq().qTM;
            AppMethodBeat.o(36033);
            return str2;
        }
        str2 = "";
        AppMethodBeat.o(36033);
        return str2;
    }

    public void doCgiReportCanvasBrowseInfo(int i, String str) {
        AppMethodBeat.i(36034);
        REMOTE_CALL("doCgiReportCanvasBrowseInfoMM", Integer.valueOf(i), str);
        AppMethodBeat.o(36034);
    }

    @com.tencent.mm.remoteservice.f
    public void doCgiReportCanvasBrowseInfoMM(int i, String str) {
        AppMethodBeat.i(36035);
        axc axc = new axc();
        axc.wBd = i;
        axc.wBl = (int) (System.currentTimeMillis() / 1000);
        axc.jBv = 1;
        axc.wBe = new com.tencent.mm.bt.b(str.getBytes());
        ArrayList arrayList = new ArrayList();
        arrayList.add(axc);
        m eVar = new com.tencent.mm.plugin.sns.a.b.e(arrayList);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(eVar, 0);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(1802, this.fur);
        AppMethodBeat.o(36035);
    }

    public int getStreamVideoPlayerConfig() {
        AppMethodBeat.i(36036);
        int intValue = ((Integer) REMOTE_CALL("getStreamVideoPlayerConfigMM", new Object[0])).intValue();
        AppMethodBeat.o(36036);
        return intValue;
    }

    @com.tencent.mm.remoteservice.f
    public int getStreamVideoPlayerConfigMM() {
        AppMethodBeat.i(36037);
        int a = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_ad_landing_page_new_stream_video, 0);
        AppMethodBeat.o(36037);
        return a;
    }

    @com.tencent.mm.remoteservice.f
    public void clearCallbackMM() {
        AppMethodBeat.i(36038);
        this.qHl.clear();
        this.qHp = null;
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(1337, this.fur);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(1210, this.fur);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(2874, this.fur);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(2721, this.fur);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(1802, this.fur);
        AppMethodBeat.o(36038);
    }

    @com.tencent.mm.remoteservice.e
    public void clearCallback() {
        AppMethodBeat.i(36039);
        REMOTE_CALL("clearCallbackMM", new Object[0]);
        this.qHq.clear();
        this.callbacks.clear();
        this.qHo.clear();
        AppMethodBeat.o(36039);
    }

    public void downloadLandingPagesImage(String str, String str2, String str3, g gVar) {
        AppMethodBeat.i(36040);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
            if (gVar != null) {
                gVar.cmD();
            }
            AppMethodBeat.o(36040);
            return;
        }
        if (gVar != null) {
            this.qHq.put(str2, gVar);
        }
        REMOTE_CALL("downloadLandingPagesImageMM", str, str2, str3);
        AppMethodBeat.o(36040);
    }

    @com.tencent.mm.remoteservice.f
    public void downloadLandingPagesImageMM(String str, String str2, String str3) {
        AppMethodBeat.i(36041);
        downloadLandingPagesImageMMImpl(str, str2, str3);
        AppMethodBeat.o(36041);
    }

    public void downloadLandingPagesImageMMImpl(String str, String str2, String str3) {
        AppMethodBeat.i(36042);
        ab.i("AdLandingPagesProxy", "downloadLandingPagesImageMMImpl");
        bau a = com.tencent.mm.modelsns.e.a(str2, 2, str3, str3, 1, 1, "");
        com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(a);
        eVar.qFQ = 3;
        eVar.nQB = a.Id;
        af.cnA().a(new c(a.Id));
        b cnA = af.cnA();
        az dtg = az.dtg();
        dtg.oyB = (int) (System.currentTimeMillis() / 1000);
        cnA.a(a, eVar, dtg, str, str2);
        AppMethodBeat.o(36042);
    }

    @com.tencent.mm.remoteservice.e
    public void onImgDownloadCallback(String str, boolean z) {
        AppMethodBeat.i(36043);
        ab.i("AdLandingPagesProxy", "onImgDownloadCallback");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(36043);
            return;
        }
        g gVar = (g) this.qHq.remove(str);
        if (gVar != null) {
            if (z) {
                gVar.cmE();
                AppMethodBeat.o(36043);
                return;
            }
            gVar.cmD();
        }
        AppMethodBeat.o(36043);
    }

    public void downloadLandingPageVideo(String str, String str2, String str3, com.tencent.mm.i.h.a aVar) {
        AppMethodBeat.i(36044);
        if (bo.Q(str, str2, str3)) {
            if (aVar != null) {
                aVar.a(str, -1, null);
            }
            AppMethodBeat.o(36044);
            return;
        }
        h.pYm.k(955, 20, 1);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
        boolean z = sharedPreferences.getBoolean(str, false);
        if (com.tencent.mm.vfs.e.ct(str3)) {
            ab.i("AdLandingPagesProxy", "is already download %s", Boolean.valueOf(z));
            if (z) {
                h.pYm.k(955, 21, 1);
                aVar.a(str, 0, null);
                AppMethodBeat.o(36044);
                return;
            }
            h.pYm.k(955, 22, 1);
        } else if (z) {
            ab.i("AdLandingPagesProxy", "last download file was deleted");
            h.pYm.k(955, 23, 1);
            sharedPreferences.edit().putBoolean(str, false).commit();
        } else {
            h.pYm.k(955, 24, 1);
        }
        if (this.qHr.containsKey(str)) {
            ab.i("%s is already in downloading", str2);
            AppMethodBeat.o(36044);
            return;
        }
        if (aVar != null) {
            this.qHr.put(str, aVar);
        }
        REMOTE_CALL("downloadLandingPageVideoMM", str, str2, str3);
        AppMethodBeat.o(36044);
    }

    public void stopDownloadLandingPageVideo(String str) {
        AppMethodBeat.i(36045);
        if (this.qHr.containsKey(str)) {
            this.qHr.remove(str);
            ab.i("AdLandingPagesProxy", "stop download video %s", str);
            h.pYm.k(955, 34, 1);
            ah.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(str, false).commit();
        }
        REMOTE_CALL("stopDownloadLandingPageVideoMM", str);
        AppMethodBeat.o(36045);
    }

    @com.tencent.mm.remoteservice.f
    public void stopDownloadLandingPageVideoMM(String str) {
        AppMethodBeat.i(36046);
        af.cnA();
        b.XC(str);
        AppMethodBeat.o(36046);
    }

    public long[] queryVideoMoov(String str, String str2, String str3) {
        AppMethodBeat.i(36047);
        ab.i("AdLandingPagesProxy", "mediaId %s, path %s, url %s", str, str2, str3);
        if (bo.Q(str, str2, str3)) {
            AppMethodBeat.o(36047);
            return null;
        }
        long[] jArr = (long[]) REMOTE_CALL("queryVideoMoovMM", str, str2, str3);
        AppMethodBeat.o(36047);
        return jArr;
    }

    @com.tencent.mm.remoteservice.f
    public long[] queryVideoMoovMM(String str, String str2, String str3) {
        AppMethodBeat.i(36048);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.fileType = 100;
        c2CDownloadRequest.url = str3;
        c2CDownloadRequest.savePath = str2;
        long[] jArr = new long[2];
        if (CdnLogic.queryVideoMoovInfo(c2CDownloadRequest, jArr)) {
            AppMethodBeat.o(36048);
            return jArr;
        }
        AppMethodBeat.o(36048);
        return null;
    }

    @com.tencent.mm.remoteservice.f
    public void downloadLandingPageVideoMM(String str, String str2, String str3) {
        AppMethodBeat.i(36049);
        ab.i("AdLandingPagesProxy", "add online video task [%s] url[%s] path[%s]", str, str2, str3);
        h.pYm.k(955, 25, 1);
        b cnA = af.cnA();
        d dVar = new d(str);
        com.tencent.mm.i.h hVar = new com.tencent.mm.i.h();
        hVar.field_mediaId = str;
        hVar.url = str2;
        hVar.egD = 1;
        hVar.field_fileType = 100;
        hVar.egy = 5;
        hVar.concurrentCount = 3;
        hVar.field_fullpath = str3;
        hVar.egK = dVar;
        cnA.qHI.put(str, str3);
        o.alm().a(hVar, false);
        AppMethodBeat.o(36049);
    }

    public void requestVideoData(String str, int i, int i2) {
        AppMethodBeat.i(36050);
        h.pYm.k(955, 32, 1);
        REMOTE_CALL("requestVideoDataMM", str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(36050);
    }

    @com.tencent.mm.remoteservice.f
    public void requestVideoDataMM(String str, int i, int i2) {
        AppMethodBeat.i(36051);
        h.pYm.k(955, 33, 1);
        o.alm();
        com.tencent.mm.al.e.k(str, i, i2);
        AppMethodBeat.o(36051);
    }

    public boolean isVideoDataAvailable(String str, int i, int i2) {
        AppMethodBeat.i(36052);
        Object REMOTE_CALL = REMOTE_CALL("isVideoDataAvailableMM", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(36052);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(36052);
        return booleanValue;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isVideoDataAvailableMM(String str, int i, int i2) {
        AppMethodBeat.i(36053);
        ab.i("AdLandingPagesProxy", "is video data avaiable %s %d %d %s", str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(o.alm().isVideoDataAvailable(str, i, i2)));
        AppMethodBeat.o(36053);
        return o.alm().isVideoDataAvailable(str, i, i2);
    }

    @com.tencent.mm.remoteservice.e
    public void onCdnVideoMoovReady(String str, int i, int i2) {
        AppMethodBeat.i(36054);
        ab.i("AdLandingPagesProxy", "cdn video moov ready %s %d %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.qHr.containsKey(str)) {
            ((com.tencent.mm.i.h.a) this.qHr.get(str)).onMoovReady(str, i, i2);
        }
        AppMethodBeat.o(36054);
    }

    @com.tencent.mm.remoteservice.e
    public void onCdnVideoDataAvailable(String str, int i, int i2) {
        AppMethodBeat.i(36055);
        ab.i("AdLandingPagesProxy", "cdn video data available %s %d %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.qHr.containsKey(str)) {
            ((com.tencent.mm.i.h.a) this.qHr.get(str)).onDataAvailable(str, i, i2);
        }
        AppMethodBeat.o(36055);
    }

    @com.tencent.mm.remoteservice.e
    public void onCdnVideoProgress(String str, int i, int i2) {
        AppMethodBeat.i(36056);
        ab.i("AdLandingPagesProxy", "cdn video progress %s %d %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.qHr.containsKey(str)) {
            ((com.tencent.mm.i.h.a) this.qHr.get(str)).h(str, i, i2);
        }
        AppMethodBeat.o(36056);
    }

    @com.tencent.mm.remoteservice.e
    public void onCdnVideoFinish(String str, int i) {
        AppMethodBeat.i(36057);
        ab.i("AdLandingPagesProxy", "cdn video finish %s, %d", str, Integer.valueOf(i));
        if (i == 0) {
            ah.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(str, true).commit();
        }
        if (this.qHr.containsKey(str)) {
            ((com.tencent.mm.i.h.a) this.qHr.remove(str)).a(str, i, null);
        }
        AppMethodBeat.o(36057);
    }

    public boolean isUseSnsDownloadImage() {
        AppMethodBeat.i(36058);
        Object REMOTE_CALL = REMOTE_CALL("isUseSnsDownloadImageMM", new Object[0]);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(36058);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(36058);
        return booleanValue;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isUseSnsDownloadImageMM() {
        boolean z;
        AppMethodBeat.i(36059);
        f fVar = qHn;
        if (bo.yz() - fVar.lastUpdateTime > 3600) {
            fVar.qHu = false;
            try {
                if (com.tencent.mm.kernel.g.RK()) {
                    com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100348");
                    if (ll.isValid()) {
                        if (bo.getInt((String) ll.dru().get("downloadMode"), 0) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        fVar.qHu = z;
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("AdLandingPagesProxy", e, "get abtest failed!", new Object[0]);
            }
            fVar.lastUpdateTime = bo.yz();
        }
        z = qHn.qHu;
        AppMethodBeat.o(36059);
        return z;
    }

    @com.tencent.mm.remoteservice.f
    public String getSnsStatExtBySnsIdMM(long j) {
        AppMethodBeat.i(35935);
        com.tencent.mm.plugin.sns.storage.e ku = af.cnI().ku(j);
        String a;
        if (ku != null) {
            a = com.tencent.mm.plugin.sns.a.b.f.a(ku.cqu());
            AppMethodBeat.o(35935);
            return a;
        }
        ab.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", Long.valueOf(j));
        a = "";
        AppMethodBeat.o(35935);
        return a;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isApkExistMM(String str) {
        AppMethodBeat.i(35982);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        FileDownloadTaskInfo Ir = com.tencent.mm.plugin.downloader.model.d.bij().Ir(str);
        if (Ir == null || TextUtils.isEmpty(Ir.path) || !com.tencent.mm.vfs.e.ct(Ir.path)) {
            AppMethodBeat.o(35982);
            return false;
        }
        AppMethodBeat.o(35982);
        return true;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isDownloadingMM(String str) {
        AppMethodBeat.i(35983);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        FileDownloadTaskInfo Ir = com.tencent.mm.plugin.downloader.model.d.bij().Ir(str);
        if (Ir == null || Ir.status != 1) {
            AppMethodBeat.o(35983);
            return false;
        }
        AppMethodBeat.o(35983);
        return true;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isPkgInstalledMM(String str) {
        AppMethodBeat.i(35985);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        Context context = ah.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(35985);
            return false;
        }
        boolean u = p.u(context, str);
        AppMethodBeat.o(35985);
        return u;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isPausedMM(String str) {
        AppMethodBeat.i(35987);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        FileDownloadTaskInfo Ir = com.tencent.mm.plugin.downloader.model.d.bij().Ir(str);
        if (Ir == null || Ir.status != 2) {
            AppMethodBeat.o(35987);
            return false;
        }
        AppMethodBeat.o(35987);
        return true;
    }

    @com.tencent.mm.remoteservice.f
    public long startDownloadMM(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        AppMethodBeat.i(35996);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        b bVar = new b(str, str2, z);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b bVar2 = this.qHp;
        com.tencent.mm.plugin.downloader.model.e.a aVar2 = new com.tencent.mm.plugin.downloader.model.e.a();
        aVar2.setAppId(str);
        aVar2.cY(str2);
        aVar2.Iw(str3);
        aVar2.It(str4);
        aVar2.Iv(str5);
        aVar2.ga(z);
        long a = com.tencent.mm.plugin.downloader.model.d.bij().a(aVar2.kNl);
        if (bVar2 != null) {
            aVar.qHp = bVar2;
        }
        if (z) {
            aVar.a(str2, bVar);
        }
        aVar.qVD.put(str, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.d(str6, str7));
        com.tencent.mm.plugin.downloader.model.d.bij();
        com.tencent.mm.plugin.downloader.model.b.a(aVar.qVE);
        ab.i("AdLandingPagesProxy", "startDownloadMM, id %d", Long.valueOf(a));
        AppMethodBeat.o(35996);
        return a;
    }

    @com.tencent.mm.remoteservice.f
    public void stopTaskMM(String str) {
        AppMethodBeat.i(35998);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        FileDownloadTaskInfo Ir = com.tencent.mm.plugin.downloader.model.d.bij().Ir(str);
        if (Ir != null) {
            com.tencent.mm.plugin.downloader.model.d.bij().hl(Ir.id);
        }
        AppMethodBeat.o(35998);
    }

    @com.tencent.mm.remoteservice.f
    public long queryIdByAppidMM(String str) {
        AppMethodBeat.i(36000);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        long queryIdByAppid = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str);
        AppMethodBeat.o(36000);
        return queryIdByAppid;
    }

    @com.tencent.mm.remoteservice.f
    public boolean pauseTaskMM(String str) {
        AppMethodBeat.i(36002);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        boolean hn = com.tencent.mm.plugin.downloader.model.d.bij().hn(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str));
        AppMethodBeat.o(36002);
        return hn;
    }

    @com.tencent.mm.remoteservice.f
    public int getTaskProgressMM(String str) {
        AppMethodBeat.i(36004);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        FileDownloadTaskInfo Ir = com.tencent.mm.plugin.downloader.model.d.bij().Ir(str);
        if (Ir.jrb != 0) {
            int i = (int) ((Ir.kNr * 100) / Ir.jrb);
            AppMethodBeat.o(36004);
            return i;
        }
        AppMethodBeat.o(36004);
        return 0;
    }

    @com.tencent.mm.remoteservice.f
    public boolean resumeTaskMM(String str, String str2, String str3) {
        AppMethodBeat.i(36006);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b bVar = this.qHp;
        FileDownloadTaskInfo Ir = com.tencent.mm.plugin.downloader.model.d.bij().Ir(str);
        if (Ir != null) {
            if (bVar != null) {
                aVar.qHp = bVar;
            }
            aVar.qVD.put(str, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.d(str2, str3));
            boolean ho = com.tencent.mm.plugin.downloader.model.d.bij().ho(Ir.id);
            AppMethodBeat.o(36006);
            return ho;
        }
        AppMethodBeat.o(36006);
        return false;
    }

    @com.tencent.mm.remoteservice.f
    public boolean installAppMM(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(36008);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        Context context = ah.getContext();
        b bVar = new b(str, str2, false);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(36008);
            return false;
        }
        FileDownloadTaskInfo Ir = com.tencent.mm.plugin.downloader.model.d.bij().Ir(str);
        if (Ir == null || Ir.status != 3 || TextUtils.isEmpty(Ir.path)) {
            AppMethodBeat.o(36008);
            return false;
        }
        Uri fromFile = Uri.fromFile(new File(Ir.path));
        aVar.Z(4, Ir.id);
        q.a(context, fromFile, null);
        aVar.a(str2, bVar);
        AppMethodBeat.o(36008);
        return true;
    }

    @com.tencent.mm.remoteservice.f
    public void reportDownloadInfoMM(int i, String str) {
        AppMethodBeat.i(36010);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH.reportDownloadInfo(i, str);
        AppMethodBeat.o(36010);
    }

    @com.tencent.mm.remoteservice.f
    public void addReportInfoMM(String str, String str2, String str3) {
        AppMethodBeat.i(36012);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(36012);
            return;
        }
        aVar.qVD.put(str, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.d(str2, str3));
        AppMethodBeat.o(36012);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void Xy(String str) {
        long ank;
        AppMethodBeat.i(36060);
        int indexOf = str.indexOf("<canvasId>");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf("</canvasId>");
            if (indexOf2 > indexOf) {
                ank = (long) bo.ank(str.substring(indexOf + 10, indexOf2));
                if (ank > 0) {
                    ab.i("AdLandingPagesProxy", "caching canvasId %d", Long.valueOf(ank));
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.cqn().u(ank, str);
                }
                AppMethodBeat.o(36060);
            }
        }
        ank = 0;
        if (ank > 0) {
        }
        AppMethodBeat.o(36060);
    }
}
