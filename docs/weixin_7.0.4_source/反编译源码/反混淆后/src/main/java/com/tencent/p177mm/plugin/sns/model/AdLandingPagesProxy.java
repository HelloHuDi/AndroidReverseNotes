package com.tencent.p177mm.plugin.sns.model;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p187al.C45150e;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C42065td;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45370tc;
import com.tencent.p177mm.p235i.C44686h;
import com.tencent.p177mm.p235i.C44686h.C26326a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.fav.p407a.C6893ad;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C39731e;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13341f;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C46209e;
import com.tencent.p177mm.plugin.sns.p520ui.SnsTransparentUI;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p1502a.C34965a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p1502a.C34966b;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p1502a.C46226c;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C39783a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C39783a.C21969d;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C39783a.C29088c;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C39783a.C29089e;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C39783a.C39782b;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C39787m;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.protocal.protobuf.C15374qc;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.axc;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.remoteservice.C31577a;
import com.tencent.p177mm.remoteservice.C40602e;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.remoteservice.C46608f;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy */
public class AdLandingPagesProxy extends C31577a {
    private static AdLandingPagesProxy qHk;
    public static C29043f qHn = new C29043f();
    private Map<Long, C34948e> callbacks = new HashMap();
    private C1202f fur = new C397431();
    private Map<C1207m, Long> qHl = new HashMap();
    private C46607d qHm;
    private Map<Long, C3880a> qHo = new HashMap();
    private C39782b qHp = new C133662();
    private Map<String, C21913g> qHq = new HashMap();
    private Map<String, C26326a> qHr = new HashMap();

    /* renamed from: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy$a */
    public interface C3880a {
        /* renamed from: CP */
        void mo8596CP(int i);

        void cmA();

        void cmB();

        void cmC();
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy$2 */
    class C133662 implements C39782b {
        C133662() {
        }

        public final void progress(long j, int i) {
            AppMethodBeat.m2504i(35912);
            C4990ab.m7419v("AdLandingPagesProxy", "progress %d", Integer.valueOf(i));
            AdLandingPagesProxy.this.CLIENT_CALL("progress", Long.valueOf(j), Integer.valueOf(i));
            AppMethodBeat.m2505o(35912);
        }

        public final void paused(long j) {
            AppMethodBeat.m2504i(35913);
            AdLandingPagesProxy.this.CLIENT_CALL("paused", Long.valueOf(j));
            AppMethodBeat.m2505o(35913);
        }

        public final void stopped(long j) {
            AppMethodBeat.m2504i(35914);
            AdLandingPagesProxy.this.CLIENT_CALL("stopped", Long.valueOf(j));
            AppMethodBeat.m2505o(35914);
        }

        public final void succeed(long j) {
            AppMethodBeat.m2504i(35915);
            AdLandingPagesProxy.this.CLIENT_CALL("succeed", Long.valueOf(j));
            AppMethodBeat.m2505o(35915);
        }

        public final void failed(long j) {
            AppMethodBeat.m2504i(35916);
            AdLandingPagesProxy.this.CLIENT_CALL("failed", Long.valueOf(j));
            AppMethodBeat.m2505o(35916);
        }

        public final void resumed(long j) {
            AppMethodBeat.m2504i(35917);
            AdLandingPagesProxy.this.CLIENT_CALL("resumed", Long.valueOf(j));
            AppMethodBeat.m2505o(35917);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy$g */
    public interface C21913g {
        void cmD();

        void cmE();
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy$f */
    public static class C29043f {
        long lastUpdateTime = 0;
        boolean qHu = false;
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy$b */
    class C34945b implements C29088c {
        /* renamed from: Iw */
        private String f15062Iw;
        private String appId;
        private boolean qHt;

        public C34945b(String str, String str2, boolean z) {
            this.f15062Iw = str2;
            this.appId = str;
            this.qHt = z;
        }

        /* renamed from: Xz */
        public final void mo47195Xz(String str) {
            AppMethodBeat.m2504i(35919);
            C4990ab.m7417i("AdLandingPagesProxy", "pkg %s installed", str);
            if (this.qHt) {
                C29089e.qVH.reportDownloadInfo(4, this.appId);
            }
            C29089e.qVH.reportDownloadInfo(5, this.appId);
            AppMethodBeat.m2505o(35919);
        }

        /* renamed from: XA */
        public final void mo47194XA(String str) {
            AppMethodBeat.m2504i(35920);
            C4990ab.m7417i("AdLandingPagesProxy", "pkg %s removed", str);
            if (!C5046bo.isNullOrNil(str) && str.equals(this.f15062Iw)) {
                AdLandingPagesProxy.this.deleteDeferredDeepLinkMM(str);
            }
            AppMethodBeat.m2505o(35920);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy$c */
    class C34946c implements C43559b {
        private String cHr;

        public C34946c(String str) {
            this.cHr = str;
        }

        /* renamed from: Xw */
        public final void mo17655Xw(String str) {
        }

        public final void cmu() {
        }

        /* renamed from: bk */
        public final void mo8772bk(String str, boolean z) {
        }

        /* renamed from: bj */
        public final void mo8771bj(String str, boolean z) {
            AppMethodBeat.m2504i(35921);
            if (!C5046bo.m7510Q(str, this.cHr) && str.equals(this.cHr)) {
                AdLandingPagesProxy.this.CLIENT_CALL("onImgDownloadCallback", str, Boolean.valueOf(z));
                C13373af.cnA().mo69142b((C43559b) this);
            }
            AppMethodBeat.m2505o(35921);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy$d */
    class C34947d implements C26326a {
        private String cHr;

        public C34947d(String str) {
            this.cHr = str;
        }

        public final void onMoovReady(String str, int i, int i2) {
            AppMethodBeat.m2504i(35922);
            if (str.equals(this.cHr)) {
                C7060h.pYm.mo15419k(955, 26, 1);
                AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoMoovReady", str, Integer.valueOf(i), Integer.valueOf(i2));
            }
            AppMethodBeat.m2505o(35922);
        }

        public final void onDataAvailable(String str, int i, int i2) {
            AppMethodBeat.m2504i(35923);
            if (str.equals(this.cHr)) {
                C7060h.pYm.mo15419k(955, 28, 1);
                AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoDataAvailable", str, Integer.valueOf(i), Integer.valueOf(i2));
            }
            AppMethodBeat.m2505o(35923);
        }

        /* renamed from: h */
        public final void mo8706h(String str, int i, int i2) {
            AppMethodBeat.m2504i(35924);
            if (str.equals(this.cHr)) {
                AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoProgress", str, Integer.valueOf(i), Integer.valueOf(i2));
            }
            AppMethodBeat.m2505o(35924);
        }

        /* renamed from: a */
        public final void mo8705a(String str, int i, C9545d c9545d) {
            AppMethodBeat.m2504i(35925);
            if (str.equals(this.cHr)) {
                C7060h.pYm.mo15419k(955, 30, 1);
                AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoFinish", str, Integer.valueOf(i));
            }
            AppMethodBeat.m2505o(35925);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy$e */
    public interface C34948e {
        /* renamed from: ao */
        void mo25548ao(Object obj);

        /* renamed from: f */
        void mo25549f(int i, int i2, Object obj);
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy$1 */
    class C397431 implements C1202f {
        C397431() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(35911);
            C4990ab.m7417i("AdLandingPagesProxy", "errType %d,errCode %d,errMsg %s,scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m.toString());
            String str2;
            long longValue;
            if (c1207m instanceof C46226c) {
                Object obj;
                str2 = "";
                if (i == 0 && i2 == 0) {
                    str2 = ((C46226c) c1207m).jsonString;
                    C4990ab.m7416i("AdLandingPagesProxy", "the dynamic string is " + str2 + ", sceneType is " + c1207m.getType());
                    obj = str2;
                } else {
                    C4990ab.m7412e("AdLandingPagesProxy", "the netscene is error ,error type is " + i + " error msg is " + str + " sceneType is " + c1207m.getType());
                    String obj2 = str2;
                }
                if (AdLandingPagesProxy.this.qHl.containsKey(c1207m)) {
                    longValue = ((Long) AdLandingPagesProxy.this.qHl.remove(c1207m)).longValue();
                    AdLandingPagesProxy.this.CLIENT_CALL("onDynamicUpdateEnd", Long.valueOf(longValue), obj2);
                    C1720g.m3540Rg().mo14546b(c1207m.getType(), AdLandingPagesProxy.this.fur);
                }
                AppMethodBeat.m2505o(35911);
                return;
            }
            if (c1207m instanceof C34965a) {
                if (AdLandingPagesProxy.this.qHl.containsKey(c1207m)) {
                    byte[] toByteArray;
                    longValue = ((Long) AdLandingPagesProxy.this.qHl.remove(c1207m)).longValue();
                    C4990ab.m7417i("AdLandingPagesProxy", "onSceneEnd id %d", Long.valueOf(longValue));
                    C15374qc c15374qc = (C15374qc) ((C7472b) c1207m.ftl).fsH.fsP;
                    if (i == 0 && i2 == 0 && c15374qc != null) {
                        try {
                            toByteArray = c15374qc.toByteArray();
                        } catch (IOException e) {
                            C4990ab.m7412e("AdLandingPagesProxy", C5046bo.m7574l(e));
                            AppMethodBeat.m2505o(35911);
                            return;
                        }
                    }
                    toByteArray = null;
                    AdLandingPagesProxy.this.CLIENT_CALL("onAdChannelEnd", Long.valueOf(longValue), Integer.valueOf(i), Integer.valueOf(i2), toByteArray);
                    C1720g.m3540Rg().mo14546b(c1207m.getType(), AdLandingPagesProxy.this.fur);
                    AppMethodBeat.m2505o(35911);
                    return;
                }
            } else if (c1207m instanceof C34966b) {
                if (AdLandingPagesProxy.this.qHl.containsKey(c1207m)) {
                    long longValue2 = ((Long) AdLandingPagesProxy.this.qHl.remove(c1207m)).longValue();
                    AdLandingPagesProxy adLandingPagesProxy = AdLandingPagesProxy.this;
                    String str3 = "onFavOfficialItemEnd";
                    Object[] objArr = new Object[4];
                    objArr[0] = Long.valueOf(longValue2);
                    C34966b c34966b = (C34966b) c1207m;
                    if (c34966b.rdB != null) {
                        str2 = c34966b.rdB;
                    } else {
                        str2 = "";
                    }
                    objArr[1] = str2;
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Integer.valueOf(i2);
                    adLandingPagesProxy.CLIENT_CALL(str3, objArr);
                    C1720g.m3540Rg().mo14546b(c1207m.getType(), AdLandingPagesProxy.this.fur);
                    AppMethodBeat.m2505o(35911);
                    return;
                }
            } else if (c1207m instanceof C46209e) {
                C4990ab.m7416i("AdLandingPagesProxy", "real time report done.");
                C1720g.m3540Rg().mo14546b(c1207m.getType(), AdLandingPagesProxy.this.fur);
            }
            AppMethodBeat.m2505o(35911);
        }
    }

    static {
        AppMethodBeat.m2504i(36061);
        AppMethodBeat.m2505o(36061);
    }

    public void connect(Runnable runnable) {
        AppMethodBeat.m2504i(35926);
        this.qHm.connect(runnable);
        AppMethodBeat.m2505o(35926);
    }

    public AdLandingPagesProxy(C46607d c46607d) {
        super(c46607d);
        AppMethodBeat.m2504i(35927);
        this.qHm = c46607d;
        AppMethodBeat.m2505o(35927);
    }

    public static AdLandingPagesProxy getInstance() {
        AppMethodBeat.m2504i(35928);
        if (qHk == null) {
            qHk = new AdLandingPagesProxy(new C46607d(C4996ah.getContext()));
        }
        AdLandingPagesProxy adLandingPagesProxy = qHk;
        AppMethodBeat.m2505o(35928);
        return adLandingPagesProxy;
    }

    public boolean isConnected() {
        AppMethodBeat.m2504i(35929);
        if (this.qHm == null) {
            AppMethodBeat.m2505o(35929);
            return false;
        }
        boolean isConnected = this.qHm.isConnected();
        AppMethodBeat.m2505o(35929);
        return isConnected;
    }

    public Object getCfg(int i, Object obj) {
        AppMethodBeat.m2504i(35930);
        Object REMOTE_CALL = REMOTE_CALL("getCfgMM", Integer.valueOf(i), obj);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(35930);
            return obj;
        }
        AppMethodBeat.m2505o(35930);
        return REMOTE_CALL;
    }

    @C46608f
    public Object getCfgMM(int i, Object obj) {
        AppMethodBeat.m2504i(35931);
        C1720g.m3537RQ();
        Object obj2 = C1720g.m3536RP().mo5239Ry().get(i, obj);
        AppMethodBeat.m2505o(35931);
        return obj2;
    }

    public int contactGetTypeTextFromUserName(String str) {
        AppMethodBeat.m2504i(35932);
        Object REMOTE_CALL = REMOTE_CALL("contactGetTypeTextFromUserNameMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(35932);
            return 0;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.m2505o(35932);
        return intValue;
    }

    @C46608f
    public int contactGetTypeTextFromUserNameMM(String str) {
        AppMethodBeat.m2504i(35933);
        int nK = C1855t.m3925nK(str);
        AppMethodBeat.m2505o(35933);
        return nK;
    }

    public String getSnsStatExtBySnsId(long j) {
        AppMethodBeat.m2504i(35934);
        String str = (String) REMOTE_CALL("getSnsStatExtBySnsIdMM", Long.valueOf(j));
        AppMethodBeat.m2505o(35934);
        return str;
    }

    public String getAccSnsPath() {
        AppMethodBeat.m2504i(35936);
        String str = (String) REMOTE_CALL("getAccSnsPathMM", new Object[0]);
        AppMethodBeat.m2505o(35936);
        return str;
    }

    @C46608f
    public String getAccSnsPathMM() {
        AppMethodBeat.m2504i(35937);
        String accSnsPath = C13373af.getAccSnsPath();
        AppMethodBeat.m2505o(35937);
        return accSnsPath;
    }

    public String getSnsAid(String str) {
        AppMethodBeat.m2504i(35938);
        String str2 = (String) REMOTE_CALL("getSnsAidMM", str);
        AppMethodBeat.m2505o(35938);
        return str2;
    }

    @C46608f
    public String getSnsAidMM(String str) {
        AppMethodBeat.m2504i(35939);
        C46236n YS = C13373af.cnF().mo62917YS(str);
        String cqZ;
        if (YS != null) {
            cqZ = YS.cqZ();
            AppMethodBeat.m2505o(35939);
            return cqZ;
        }
        cqZ = "";
        AppMethodBeat.m2505o(35939);
        return cqZ;
    }

    public int getSnsAdType(String str) {
        AppMethodBeat.m2504i(35940);
        int intValue = ((Integer) REMOTE_CALL("getSnsAdTypeMM", str)).intValue();
        AppMethodBeat.m2505o(35940);
        return intValue;
    }

    @C46608f
    public int getSnsAdTypeMM(String str) {
        AppMethodBeat.m2504i(35941);
        C46236n YS = C13373af.cnF().mo62917YS(str);
        if (YS != null) {
            int crf = YS.crf();
            AppMethodBeat.m2505o(35941);
            return crf;
        }
        AppMethodBeat.m2505o(35941);
        return 0;
    }

    public void confirmDialPhoneNum(Activity activity, String str) {
        AppMethodBeat.m2504i(35942);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(35942);
            return;
        }
        Intent intent = new Intent(C4996ah.getContext(), SnsTransparentUI.class);
        intent.putExtra("phoneNum", str);
        intent.putExtra("op", 4);
        activity.startActivity(intent);
        AppMethodBeat.m2505o(35942);
    }

    public String getSnsTraceid(String str) {
        AppMethodBeat.m2504i(35943);
        String str2 = (String) REMOTE_CALL("getSnsTraceidMM", str);
        AppMethodBeat.m2505o(35943);
        return str2;
    }

    @C46608f
    public String getSnsTraceidMM(String str) {
        AppMethodBeat.m2504i(35944);
        C46236n YS = C13373af.cnF().mo62917YS(str);
        String cra;
        if (YS != null) {
            cra = YS.cra();
            AppMethodBeat.m2505o(35944);
            return cra;
        }
        cra = "";
        AppMethodBeat.m2505o(35944);
        return cra;
    }

    public String getSnsUxInfo(String str) {
        AppMethodBeat.m2504i(35945);
        String str2 = (String) REMOTE_CALL("getSnsUxInfoMM", str);
        AppMethodBeat.m2505o(35945);
        return str2;
    }

    @C46608f
    public String getSnsUxInfoMM(String str) {
        AppMethodBeat.m2504i(35946);
        C46236n YS = C13373af.cnF().mo62917YS(str);
        String crc;
        if (YS != null) {
            crc = YS.crc();
            AppMethodBeat.m2505o(35946);
            return crc;
        }
        crc = "";
        AppMethodBeat.m2505o(35946);
        return crc;
    }

    public boolean isRecExpAd(String str) {
        AppMethodBeat.m2504i(35947);
        Object REMOTE_CALL = REMOTE_CALL("isRecExpAdMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(35947);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.m2505o(35947);
        return booleanValue;
    }

    @C46608f
    public boolean isRecExpAdMM(String str) {
        AppMethodBeat.m2504i(35948);
        C46236n YS = C13373af.cnF().mo62917YS(str);
        if (YS == null) {
            AppMethodBeat.m2505o(35948);
            return false;
        }
        boolean coX = YS.coX();
        AppMethodBeat.m2505o(35948);
        return coX;
    }

    public C46236n getSnsInfo(String str) {
        Bundle bundle = null;
        AppMethodBeat.m2504i(35949);
        try {
            Bundle bundle2 = (Bundle) REMOTE_CALL("getSnsInfoMM", str);
            if (bundle2 == null) {
                AppMethodBeat.m2505o(35949);
                return null;
            }
            bundle = bundle2;
            C46236n c46236n = new C46236n();
            if (bundle != null) {
                ContentValues contentValues = (ContentValues) bundle.getParcelable("values");
                c46236n.field_snsId = contentValues.getAsLong("snsId").longValue();
                c46236n.field_userName = contentValues.getAsString("userName");
                c46236n.field_localFlag = contentValues.getAsInteger("localFlag").intValue();
                c46236n.field_createTime = contentValues.getAsInteger("createTime").intValue();
                c46236n.field_head = contentValues.getAsInteger("head").intValue();
                c46236n.field_localPrivate = contentValues.getAsInteger("localPrivate").intValue();
                c46236n.field_type = contentValues.getAsInteger("type").intValue();
                c46236n.field_sourceType = contentValues.getAsInteger("sourceType").intValue();
                c46236n.field_likeFlag = contentValues.getAsInteger("likeFlag").intValue();
                c46236n.field_pravited = contentValues.getAsInteger("pravited").intValue();
                c46236n.field_stringSeq = contentValues.getAsString("stringSeq");
                c46236n.field_content = contentValues.getAsByteArray(C8741b.CONTENT);
                c46236n.field_attrBuf = contentValues.getAsByteArray("attrBuf");
                c46236n.field_postBuf = contentValues.getAsByteArray("postBuf");
                c46236n.field_subType = contentValues.getAsInteger("subType").intValue();
                if (contentValues.containsKey("rowid")) {
                    c46236n.xDa = contentValues.getAsLong("rowid").longValue();
                }
                c46236n.reX = bundle.getInt("localid");
                bundle2 = bundle.getBundle("adValues");
                if (bundle2 != null) {
                    C43570e c43570e = new C43570e();
                    c43570e.mo69149L(bundle2);
                    c46236n.rfh = c43570e;
                }
            }
            AppMethodBeat.m2505o(35949);
            return c46236n;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("AdLandingPagesProxy", e, "", new Object[0]);
        }
    }

    @C46608f
    public Bundle getSnsInfoMM(String str) {
        AppMethodBeat.m2504i(35950);
        C46236n YS = C13373af.cnF().mo62917YS(str);
        if (YS == null) {
            AppMethodBeat.m2505o(35950);
            return null;
        }
        Bundle cqC = YS.cqC();
        AppMethodBeat.m2505o(35950);
        return cqC;
    }

    public String getUin() {
        AppMethodBeat.m2504i(35951);
        Object REMOTE_CALL = REMOTE_CALL("getUinMM", new Object[0]);
        String str;
        if (REMOTE_CALL == null) {
            str = "";
            AppMethodBeat.m2505o(35951);
            return str;
        }
        str = (String) REMOTE_CALL;
        AppMethodBeat.m2505o(35951);
        return str;
    }

    @C46608f
    public String getUinMM() {
        AppMethodBeat.m2504i(35952);
        C1720g.m3534RN();
        String QG = C1668a.m3384QG();
        AppMethodBeat.m2505o(35952);
        return QG;
    }

    public boolean useOnlineStreamPlayer() {
        AppMethodBeat.m2504i(35953);
        Object REMOTE_CALL = REMOTE_CALL("useOnlineStreamPlayerMM", new Object[0]);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(35953);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.m2505o(35953);
        return booleanValue;
    }

    @C46608f
    public boolean useOnlineStreamPlayerMM() {
        AppMethodBeat.m2504i(35954);
        C5141c ll = C18624c.abi().mo17131ll("100208");
        if (ll.isValid()) {
            int i = C5046bo.getInt((String) ll.dru().get("useOnlineVideoPlayer"), 0);
            C4990ab.m7416i("AdLandingPagesProxy", "useOnlineVideoPlayer abtest=".concat(String.valueOf(i)));
            if (i == 1) {
                AppMethodBeat.m2505o(35954);
                return true;
            }
            AppMethodBeat.m2505o(35954);
            return false;
        }
        AppMethodBeat.m2505o(35954);
        return false;
    }

    @C46608f
    public int getExpValueByKeyMM(String str, int i) {
        AppMethodBeat.m2504i(35955);
        int en = C18624c.abj().mo39176en(str, i);
        AppMethodBeat.m2505o(35955);
        return en;
    }

    public int getExpValueByKey(String str, int i) {
        AppMethodBeat.m2504i(35956);
        Object REMOTE_CALL = REMOTE_CALL("getExpValueByKeyMM", str, Integer.valueOf(i));
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(35956);
            return -1;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.m2505o(35956);
        return intValue;
    }

    @C46608f
    public String getExpIdByKeyMM(String str) {
        AppMethodBeat.m2504i(35957);
        String expIdByKey = C18624c.abj().getExpIdByKey(str);
        AppMethodBeat.m2505o(35957);
        return expIdByKey;
    }

    public String getExpIdByKey(String str) {
        AppMethodBeat.m2504i(35958);
        String str2 = (String) REMOTE_CALL("getExpIdByKeyMM", str);
        AppMethodBeat.m2505o(35958);
        return str2;
    }

    public int isAutoAdDownload() {
        AppMethodBeat.m2504i(35959);
        Object REMOTE_CALL = REMOTE_CALL("isAutoAdDownloadMM", new Object[0]);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(35959);
            return 0;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.m2505o(35959);
        return intValue;
    }

    public void favEditTag() {
        AppMethodBeat.m2504i(35960);
        REMOTE_CALL("favEditTagMM", new Object[0]);
        AppMethodBeat.m2505o(35960);
    }

    @C46608f
    public void favEditTagMM() {
        AppMethodBeat.m2504i(35961);
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 35;
        C4879a.xxA.mo10055m(c37721gh);
        AppMethodBeat.m2505o(35961);
    }

    @C46608f
    public int isAutoAdDownloadMM() {
        AppMethodBeat.m2504i(35962);
        int b = C13373af.cnC().mo37453b(null, null);
        AppMethodBeat.m2505o(35962);
        return b;
    }

    public int doFavAdlanding(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8) {
        AppMethodBeat.m2504i(35963);
        Object REMOTE_CALL = REMOTE_CALL("doFavAdlandingMM", Long.valueOf(j), str, Integer.valueOf(i), str2, str3, str4, str5, str6, Integer.valueOf(i2), str7, str8);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(35963);
            return 0;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.m2505o(35963);
        return intValue;
    }

    @C46608f
    public int doFavAdlandingMM(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8) {
        AppMethodBeat.m2504i(35964);
        C45316cl c45316cl = new C45316cl();
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 9 || i == 10 || i == 11) {
            C5046bo.isNullOrNil(str);
        }
        ((C6893ad) C1720g.m3528K(C6893ad.class)).mo15155a(c45316cl, str6.hashCode(), C1853r.m3846Yz(), str4, str5, str6, str7, str2);
        c45316cl.cvA.cvF = C37922v.m64078nW(str3);
        c45316cl.cvA.title = str4;
        c45316cl.cvA.desc = str5;
        abf abf = c45316cl.cvA.cvC;
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
        c45316cl.cvA.cvH = i2;
        C4879a.xxA.mo10055m(c45316cl);
        int i3 = c45316cl.cvA.cvG;
        AppMethodBeat.m2505o(35964);
        return i3;
    }

    public int doFav(Intent intent, int i) {
        AppMethodBeat.m2504i(35965);
        Object REMOTE_CALL = REMOTE_CALL("doFavMM", intent, Integer.valueOf(i));
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(35965);
            return 0;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.m2505o(35965);
        return intValue;
    }

    @C46608f
    public int doFavMM(Intent intent, int i) {
        AppMethodBeat.m2504i(35966);
        C45316cl c45316cl = new C45316cl();
        ((C6893ad) C1720g.m3528K(C6893ad.class)).mo15154a(c45316cl, intent);
        c45316cl.cvA.cvH = i;
        C4879a.xxA.mo10055m(c45316cl);
        int i2 = c45316cl.cvA.cvG;
        AppMethodBeat.m2505o(35966);
        return i2;
    }

    public void doTransimt(Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(35967);
        Intent intent = new Intent(C4996ah.getContext(), SnsTransparentUI.class);
        intent.putExtra("adlandingXml", str);
        intent.putExtra("shareTitle", str2);
        intent.putExtra("shareThumbUrl", str3);
        intent.putExtra("shareDesc", str4);
        intent.putExtra("shareUrl", str5);
        intent.putExtra("statExtStr", str6);
        intent.putExtra("op", 2);
        activity.startActivity(intent);
        AppMethodBeat.m2505o(35967);
    }

    @C46608f
    public void doTransimtMM(String str, String str2, String str3, String str4, String str5) {
    }

    public void doDynamicUpdateScene(String str, String str2, String str3, C34948e c34948e) {
        AppMethodBeat.m2504i(35968);
        this.callbacks.put(Long.valueOf(System.currentTimeMillis()), c34948e);
        REMOTE_CALL("doDynamicUpdateSceneMM", Long.valueOf(r0), str, str2, str3);
        AppMethodBeat.m2505o(35968);
    }

    @C46608f
    public void doDynamicUpdateSceneMM(long j, String str, String str2, String str3) {
        AppMethodBeat.m2504i(35969);
        C1207m c46226c = new C46226c(str, str2, str3);
        this.qHl.put(c46226c, Long.valueOf(j));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c46226c, 0);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1337, this.fur);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(2721, this.fur);
        AppMethodBeat.m2505o(35969);
    }

    @C40602e
    public void onDynamicUpdateEnd(long j, String str) {
        AppMethodBeat.m2504i(35970);
        C34948e c34948e = (C34948e) this.callbacks.remove(Long.valueOf(j));
        if (!(c34948e == null || C5046bo.isNullOrNil(str))) {
            c34948e.mo25548ao(str);
        }
        AppMethodBeat.m2505o(35970);
    }

    public void doSearchDynamicUpdateScene(String str, C34948e c34948e) {
        AppMethodBeat.m2504i(35971);
        this.callbacks.put(Long.valueOf(System.currentTimeMillis()), c34948e);
        REMOTE_CALL("doSearchDynamicUpdateSceneMM", Long.valueOf(r0), str);
        AppMethodBeat.m2505o(35971);
    }

    @C46608f
    public void doSearchDynamicUpdateSceneMM(long j, String str) {
        AppMethodBeat.m2504i(35972);
        C1207m c46226c = new C46226c(str);
        this.qHl.put(c46226c, Long.valueOf(j));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c46226c, 0);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1337, this.fur);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(2721, this.fur);
        AppMethodBeat.m2505o(35972);
    }

    @C40602e
    public void onAdChannelEnd(long j, int i, int i2, Object obj) {
        AppMethodBeat.m2504i(35973);
        C34948e c34948e = (C34948e) this.callbacks.remove(Long.valueOf(j));
        if (c34948e != null) {
            c34948e.mo25549f(i, i2, obj);
        }
        AppMethodBeat.m2505o(35973);
    }

    public void doAdChannelScene(String str, String str2, C34948e c34948e) {
        AppMethodBeat.m2504i(35974);
        this.callbacks.put(Long.valueOf(System.currentTimeMillis()), c34948e);
        REMOTE_CALL("doAdChannelSceneMM", Long.valueOf(r0), str, str2);
        AppMethodBeat.m2505o(35974);
    }

    @C46608f
    public void doAdChannelSceneMM(long j, String str, String str2) {
        AppMethodBeat.m2504i(35975);
        C1207m c34965a = new C34965a(str, str2);
        this.qHl.put(c34965a, Long.valueOf(j));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c34965a, 0);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1210, this.fur);
        AppMethodBeat.m2505o(35975);
    }

    public void playTimelineClickAnimation(long j) {
        AppMethodBeat.m2504i(35976);
        this.callbacks.put(Long.valueOf(System.currentTimeMillis()), null);
        REMOTE_CALL("playTimelineClickAnimationMM", Long.valueOf(r0), Long.valueOf(j));
        AppMethodBeat.m2505o(35976);
    }

    @C46608f
    public void playTimelineClickAnimationMM(long j, long j2) {
        AppMethodBeat.m2504i(35977);
        C42065td c42065td = new C42065td();
        c42065td.cPq.cvc = j2;
        C4879a.xxA.mo10055m(c42065td);
        AppMethodBeat.m2505o(35977);
    }

    public void playTimelineBackAnimation(long j) {
        AppMethodBeat.m2504i(35978);
        this.callbacks.put(Long.valueOf(System.currentTimeMillis()), null);
        REMOTE_CALL("playTimelineBackAnimationMM", Long.valueOf(r0), Long.valueOf(j));
        AppMethodBeat.m2505o(35978);
    }

    @C46608f
    public void playTimelineBackAnimationMM(long j, long j2) {
        AppMethodBeat.m2504i(35979);
        C45370tc c45370tc = new C45370tc();
        c45370tc.cPp.cvc = j2;
        C4879a.xxA.mo10055m(c45370tc);
        AppMethodBeat.m2505o(35979);
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(35980);
        C4990ab.m7411d("AdLandingPagesProxy", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? C40602e.class : C46608f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() != Void.TYPE) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable("result_key", (Parcelable) invoke);
                            AppMethodBeat.m2505o(35980);
                            return;
                        }
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
            AppMethodBeat.m2505o(35980);
        } catch (Exception e) {
            C4990ab.m7413e("AdLandingPagesProxy", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(35980);
        }
    }

    @C40602e
    public boolean isApkExist(String str) {
        AppMethodBeat.m2504i(35981);
        Object REMOTE_CALL = REMOTE_CALL("isApkExistMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(35981);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.m2505o(35981);
        return booleanValue;
    }

    public boolean isDownloading(String str) {
        AppMethodBeat.m2504i(35984);
        Object REMOTE_CALL = REMOTE_CALL("isDownloadingMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(35984);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.m2505o(35984);
        return booleanValue;
    }

    public boolean isPkgInstalled(String str) {
        AppMethodBeat.m2504i(35986);
        Object REMOTE_CALL = REMOTE_CALL("isPkgInstalledMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(35986);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.m2505o(35986);
        return booleanValue;
    }

    public boolean isPaused(String str) {
        AppMethodBeat.m2504i(35988);
        Object REMOTE_CALL = REMOTE_CALL("isPausedMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(35988);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.m2505o(35988);
        return booleanValue;
    }

    @C40602e
    public void start(long j) {
        AppMethodBeat.m2504i(35989);
        this.qHo.get(Long.valueOf(j));
        AppMethodBeat.m2505o(35989);
    }

    @C40602e
    public void progress(long j, int i) {
        AppMethodBeat.m2504i(35990);
        C4990ab.m7419v("AdLandingPagesProxy", "progress client id %d , progress %d", Long.valueOf(j), Integer.valueOf(i));
        C3880a c3880a = (C3880a) this.qHo.get(Long.valueOf(j));
        if (c3880a != null) {
            c3880a.mo8596CP(i);
        }
        AppMethodBeat.m2505o(35990);
    }

    @C40602e
    public void paused(long j) {
        AppMethodBeat.m2504i(35991);
        C3880a c3880a = (C3880a) this.qHo.get(Long.valueOf(j));
        if (c3880a != null) {
            c3880a.cmA();
        }
        AppMethodBeat.m2505o(35991);
    }

    @C40602e
    public void stopped(long j) {
        AppMethodBeat.m2504i(35992);
        if (((C3880a) this.qHo.get(Long.valueOf(j))) != null) {
            this.qHo.remove(Long.valueOf(j));
        }
        AppMethodBeat.m2505o(35992);
    }

    @C40602e
    public void succeed(long j) {
        AppMethodBeat.m2504i(35993);
        C3880a c3880a = (C3880a) this.qHo.get(Long.valueOf(j));
        if (c3880a != null) {
            c3880a.cmB();
            this.qHo.remove(Long.valueOf(j));
        }
        AppMethodBeat.m2505o(35993);
    }

    @C40602e
    public void failed(long j) {
        AppMethodBeat.m2504i(35994);
        C3880a c3880a = (C3880a) this.qHo.get(Long.valueOf(j));
        if (c3880a != null) {
            c3880a.cmC();
            this.qHo.remove(Long.valueOf(j));
        }
        AppMethodBeat.m2505o(35994);
    }

    @C40602e
    public void resumed(long j) {
        AppMethodBeat.m2504i(35995);
        this.qHo.get(Long.valueOf(j));
        AppMethodBeat.m2505o(35995);
    }

    public long startDownload(String str, String str2, String str3, String str4, String str5, boolean z, C3880a c3880a, String str6, String str7) {
        AppMethodBeat.m2504i(35997);
        C4990ab.m7418v("AdLandingPagesProxy", "startDownload");
        Object REMOTE_CALL = REMOTE_CALL("startDownloadMM", str, str2, str3, str4, str5, Boolean.valueOf(z), str6, str7);
        long longValue = REMOTE_CALL == null ? -1 : ((Long) REMOTE_CALL).longValue();
        this.qHo.put(Long.valueOf(longValue), c3880a);
        AppMethodBeat.m2505o(35997);
        return longValue;
    }

    public void stopTask(String str) {
        AppMethodBeat.m2504i(35999);
        REMOTE_CALL("stopTaskMM", str);
        AppMethodBeat.m2505o(35999);
    }

    public long queryIdByAppid(String str) {
        AppMethodBeat.m2504i(36001);
        Object REMOTE_CALL = REMOTE_CALL("queryIdByAppidMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(36001);
            return -1;
        }
        long longValue = ((Long) REMOTE_CALL).longValue();
        AppMethodBeat.m2505o(36001);
        return longValue;
    }

    public boolean pauseTask(String str) {
        AppMethodBeat.m2504i(36003);
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(36003);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.m2505o(36003);
        return booleanValue;
    }

    public int getTaskProgress(String str) {
        AppMethodBeat.m2504i(36005);
        Object REMOTE_CALL = REMOTE_CALL("getTaskProgressMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(36005);
            return -1;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.m2505o(36005);
        return intValue;
    }

    public boolean resumeTask(String str, C3880a c3880a, String str2, String str3) {
        AppMethodBeat.m2504i(36007);
        Object REMOTE_CALL = REMOTE_CALL("resumeTaskMM", str, str2, str3);
        boolean booleanValue = REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
        if (booleanValue) {
            this.qHo.put(Long.valueOf(queryIdByAppid(str)), c3880a);
        }
        AppMethodBeat.m2505o(36007);
        return booleanValue;
    }

    public boolean installApp(Context context, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(36009);
        Object REMOTE_CALL = REMOTE_CALL("installAppMM", str, str2, str3, str4);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(36009);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.m2505o(36009);
        return booleanValue;
    }

    public void reportDownloadInfo(int i, String str) {
        AppMethodBeat.m2504i(36011);
        REMOTE_CALL("reportDownloadInfoMM", Integer.valueOf(i), str);
        AppMethodBeat.m2505o(36011);
    }

    public void addReportInfo(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36013);
        REMOTE_CALL("addReportInfoMM", str, str2, str3);
        AppMethodBeat.m2505o(36013);
    }

    public void writeDeferredDeepLink(String str, String str2) {
        AppMethodBeat.m2504i(36014);
        REMOTE_CALL("writeDeferredDeepLinkMM", str, str2);
        AppMethodBeat.m2505o(36014);
    }

    @C46608f
    public void writeDeferredDeepLinkMM(String str, String str2) {
        AppMethodBeat.m2504i(36015);
        AdLandingPagesProxy.m67973Ii().edit().putString(str, str2).commit();
        AppMethodBeat.m2505o(36015);
    }

    public void deleteDeferredDeepLink(String str) {
        AppMethodBeat.m2504i(36016);
        REMOTE_CALL("deleteDeferredDeepLinkMM", str);
        AppMethodBeat.m2505o(36016);
    }

    @C46608f
    public void deleteDeferredDeepLinkMM(String str) {
        AppMethodBeat.m2504i(36017);
        AdLandingPagesProxy.m67973Ii().edit().remove(str).commit();
        AppMethodBeat.m2505o(36017);
    }

    /* renamed from: Ii */
    private static SharedPreferences m67973Ii() {
        AppMethodBeat.m2504i(36018);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.getPackageName() + "_comm_preferences", 0);
        AppMethodBeat.m2505o(36018);
        return sharedPreferences;
    }

    @C40602e
    public void addCanvasCache(long j, String str) {
        AppMethodBeat.m2504i(36019);
        REMOTE_CALL("addCanvasCacheMM", Long.valueOf(j), str);
        AppMethodBeat.m2505o(36019);
    }

    @C46608f
    public void addCanvasCacheMM(long j, String str) {
        AppMethodBeat.m2504i(36020);
        C39787m.cqn().mo62909u(j, str);
        AppMethodBeat.m2505o(36020);
    }

    @C40602e
    public void asyncCacheXml(String str) {
        AppMethodBeat.m2504i(36021);
        REMOTE_CALL("asyncCacheXmlMM", str);
        AppMethodBeat.m2505o(36021);
    }

    @C46608f
    public void asyncCacheXmlMM(final String str) {
        AppMethodBeat.m2504i(36022);
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10310m(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(35918);
                if (C1720g.m3534RN().mo5161QY()) {
                    C46236n YS = C13373af.cnF().mo62917YS(str);
                    if (YS != null) {
                        C21984b cqo = YS.cqo();
                        if (cqo != null) {
                            AdLandingPagesProxy.m67974Xy(cqo.coT());
                            AdLandingPagesProxy.m67974Xy(cqo.coU());
                        }
                    }
                    AppMethodBeat.m2505o(35918);
                    return;
                }
                AppMethodBeat.m2505o(35918);
            }
        }, 5000);
        AppMethodBeat.m2505o(36022);
    }

    public int getAdVoteIndex(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36023);
        int intValue = ((Integer) REMOTE_CALL("getAdVoteIndexMM", str, str2, str3)).intValue();
        AppMethodBeat.m2505o(36023);
        return intValue;
    }

    @C46608f
    public int getAdVoteIndexMM(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36024);
        int ak = C35002v.m57487ak(str, str2, str3);
        AppMethodBeat.m2505o(36024);
        return ak;
    }

    public String getAdVoteInfo(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36025);
        String str4 = (String) REMOTE_CALL("getAdVoteInfoMM", str, str2, str3);
        AppMethodBeat.m2505o(36025);
        return str4;
    }

    @C46608f
    public String getAdVoteInfoMM(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36026);
        String al = C35002v.m57488al(str, str2, str3);
        AppMethodBeat.m2505o(36026);
        return al;
    }

    public void saveAdVoteInfo(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(36027);
        REMOTE_CALL("saveAdVoteInfoMM", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(36027);
    }

    @C46608f
    public void saveAdVoteInfoMM(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(36028);
        C35002v.m57492h(str, str2, str3, i, i2);
        AppMethodBeat.m2505o(36028);
    }

    public void doFavOfficialItemScene(String str, C34948e c34948e) {
        AppMethodBeat.m2504i(36029);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("AdLandingPagesProxy", "doFavOfficialItemScene with empty itemBuff, interrupted!");
            AppMethodBeat.m2505o(36029);
            return;
        }
        this.callbacks.put(Long.valueOf(System.currentTimeMillis()), c34948e);
        REMOTE_CALL("doFavOfficialItemSceneMM", Long.valueOf(r0), str);
        AppMethodBeat.m2505o(36029);
    }

    @C46608f
    public void doFavOfficialItemSceneMM(long j, String str) {
        AppMethodBeat.m2504i(36030);
        C1207m c34966b = new C34966b(str);
        this.qHl.put(c34966b, Long.valueOf(j));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c34966b, 0);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(2874, this.fur);
        AppMethodBeat.m2505o(36030);
    }

    @C40602e
    public void onFavOfficialItemEnd(long j, String str, int i, int i2) {
        AppMethodBeat.m2504i(36031);
        C34948e c34948e = (C34948e) this.callbacks.remove(Long.valueOf(j));
        if (i == 0 && i2 == 0) {
            C4990ab.m7417i("AdLandingPagesProxy", "FavOfficialItem succeed, item_buff[%s]", str);
        } else {
            C4990ab.m7413e("AdLandingPagesProxy", "FavOfficialItem fail, errrType[%d], errCode[%d], item_buff[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
        }
        if (c34948e != null) {
            c34948e.mo25549f(i, i2, null);
        }
        AppMethodBeat.m2505o(36031);
    }

    public String getSnsAdCanvasExtXml(String str) {
        AppMethodBeat.m2504i(36032);
        String str2 = (String) REMOTE_CALL("getSnsAdCanvasExtXmlMM", str);
        AppMethodBeat.m2505o(36032);
        return str2;
    }

    @C46608f
    public String getSnsAdCanvasExtXmlMM(String str) {
        AppMethodBeat.m2504i(36033);
        C46236n YS = C13373af.cnF().mo62917YS(str);
        String str2;
        if (YS != null) {
            str2 = YS.cqq().qTM;
            AppMethodBeat.m2505o(36033);
            return str2;
        }
        str2 = "";
        AppMethodBeat.m2505o(36033);
        return str2;
    }

    public void doCgiReportCanvasBrowseInfo(int i, String str) {
        AppMethodBeat.m2504i(36034);
        REMOTE_CALL("doCgiReportCanvasBrowseInfoMM", Integer.valueOf(i), str);
        AppMethodBeat.m2505o(36034);
    }

    @C46608f
    public void doCgiReportCanvasBrowseInfoMM(int i, String str) {
        AppMethodBeat.m2504i(36035);
        axc axc = new axc();
        axc.wBd = i;
        axc.wBl = (int) (System.currentTimeMillis() / 1000);
        axc.jBv = 1;
        axc.wBe = new C1332b(str.getBytes());
        ArrayList arrayList = new ArrayList();
        arrayList.add(axc);
        C1207m c46209e = new C46209e(arrayList);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c46209e, 0);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1802, this.fur);
        AppMethodBeat.m2505o(36035);
    }

    public int getStreamVideoPlayerConfig() {
        AppMethodBeat.m2504i(36036);
        int intValue = ((Integer) REMOTE_CALL("getStreamVideoPlayerConfigMM", new Object[0])).intValue();
        AppMethodBeat.m2505o(36036);
        return intValue;
    }

    @C46608f
    public int getStreamVideoPlayerConfigMM() {
        AppMethodBeat.m2504i(36037);
        int a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_ad_landing_page_new_stream_video, 0);
        AppMethodBeat.m2505o(36037);
        return a;
    }

    @C46608f
    public void clearCallbackMM() {
        AppMethodBeat.m2504i(36038);
        this.qHl.clear();
        this.qHp = null;
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1337, this.fur);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1210, this.fur);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(2874, this.fur);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(2721, this.fur);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1802, this.fur);
        AppMethodBeat.m2505o(36038);
    }

    @C40602e
    public void clearCallback() {
        AppMethodBeat.m2504i(36039);
        REMOTE_CALL("clearCallbackMM", new Object[0]);
        this.qHq.clear();
        this.callbacks.clear();
        this.qHo.clear();
        AppMethodBeat.m2505o(36039);
    }

    public void downloadLandingPagesImage(String str, String str2, String str3, C21913g c21913g) {
        AppMethodBeat.m2504i(36040);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
            if (c21913g != null) {
                c21913g.cmD();
            }
            AppMethodBeat.m2505o(36040);
            return;
        }
        if (c21913g != null) {
            this.qHq.put(str2, c21913g);
        }
        REMOTE_CALL("downloadLandingPagesImageMM", str, str2, str3);
        AppMethodBeat.m2505o(36040);
    }

    @C46608f
    public void downloadLandingPagesImageMM(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36041);
        downloadLandingPagesImageMMImpl(str, str2, str3);
        AppMethodBeat.m2505o(36041);
    }

    public void downloadLandingPagesImageMMImpl(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36042);
        C4990ab.m7416i("AdLandingPagesProxy", "downloadLandingPagesImageMMImpl");
        bau a = C37953e.m64185a(str2, 2, str3, str3, 1, 1, "");
        C39731e c39731e = new C39731e(a);
        c39731e.qFQ = 3;
        c39731e.nQB = a.f17915Id;
        C13373af.cnA().mo69136a(new C34946c(a.f17915Id));
        C43558b cnA = C13373af.cnA();
        C44222az dtg = C44222az.dtg();
        dtg.oyB = (int) (System.currentTimeMillis() / 1000);
        cnA.mo69139a(a, c39731e, dtg, str, str2);
        AppMethodBeat.m2505o(36042);
    }

    @C40602e
    public void onImgDownloadCallback(String str, boolean z) {
        AppMethodBeat.m2504i(36043);
        C4990ab.m7416i("AdLandingPagesProxy", "onImgDownloadCallback");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(36043);
            return;
        }
        C21913g c21913g = (C21913g) this.qHq.remove(str);
        if (c21913g != null) {
            if (z) {
                c21913g.cmE();
                AppMethodBeat.m2505o(36043);
                return;
            }
            c21913g.cmD();
        }
        AppMethodBeat.m2505o(36043);
    }

    public void downloadLandingPageVideo(String str, String str2, String str3, C26326a c26326a) {
        AppMethodBeat.m2504i(36044);
        if (C5046bo.m7510Q(str, str2, str3)) {
            if (c26326a != null) {
                c26326a.mo8705a(str, -1, null);
            }
            AppMethodBeat.m2505o(36044);
            return;
        }
        C7060h.pYm.mo15419k(955, 20, 1);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
        boolean z = sharedPreferences.getBoolean(str, false);
        if (C5730e.m8628ct(str3)) {
            C4990ab.m7417i("AdLandingPagesProxy", "is already download %s", Boolean.valueOf(z));
            if (z) {
                C7060h.pYm.mo15419k(955, 21, 1);
                c26326a.mo8705a(str, 0, null);
                AppMethodBeat.m2505o(36044);
                return;
            }
            C7060h.pYm.mo15419k(955, 22, 1);
        } else if (z) {
            C4990ab.m7416i("AdLandingPagesProxy", "last download file was deleted");
            C7060h.pYm.mo15419k(955, 23, 1);
            sharedPreferences.edit().putBoolean(str, false).commit();
        } else {
            C7060h.pYm.mo15419k(955, 24, 1);
        }
        if (this.qHr.containsKey(str)) {
            C4990ab.m7416i("%s is already in downloading", str2);
            AppMethodBeat.m2505o(36044);
            return;
        }
        if (c26326a != null) {
            this.qHr.put(str, c26326a);
        }
        REMOTE_CALL("downloadLandingPageVideoMM", str, str2, str3);
        AppMethodBeat.m2505o(36044);
    }

    public void stopDownloadLandingPageVideo(String str) {
        AppMethodBeat.m2504i(36045);
        if (this.qHr.containsKey(str)) {
            this.qHr.remove(str);
            C4990ab.m7417i("AdLandingPagesProxy", "stop download video %s", str);
            C7060h.pYm.mo15419k(955, 34, 1);
            C4996ah.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(str, false).commit();
        }
        REMOTE_CALL("stopDownloadLandingPageVideoMM", str);
        AppMethodBeat.m2505o(36045);
    }

    @C46608f
    public void stopDownloadLandingPageVideoMM(String str) {
        AppMethodBeat.m2504i(36046);
        C13373af.cnA();
        C43558b.m77890XC(str);
        AppMethodBeat.m2505o(36046);
    }

    public long[] queryVideoMoov(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36047);
        C4990ab.m7417i("AdLandingPagesProxy", "mediaId %s, path %s, url %s", str, str2, str3);
        if (C5046bo.m7510Q(str, str2, str3)) {
            AppMethodBeat.m2505o(36047);
            return null;
        }
        long[] jArr = (long[]) REMOTE_CALL("queryVideoMoovMM", str, str2, str3);
        AppMethodBeat.m2505o(36047);
        return jArr;
    }

    @C46608f
    public long[] queryVideoMoovMM(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36048);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.fileType = 100;
        c2CDownloadRequest.url = str3;
        c2CDownloadRequest.savePath = str2;
        long[] jArr = new long[2];
        if (CdnLogic.queryVideoMoovInfo(c2CDownloadRequest, jArr)) {
            AppMethodBeat.m2505o(36048);
            return jArr;
        }
        AppMethodBeat.m2505o(36048);
        return null;
    }

    @C46608f
    public void downloadLandingPageVideoMM(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36049);
        C4990ab.m7417i("AdLandingPagesProxy", "add online video task [%s] url[%s] path[%s]", str, str2, str3);
        C7060h.pYm.mo15419k(955, 25, 1);
        C43558b cnA = C13373af.cnA();
        C34947d c34947d = new C34947d(str);
        C44686h c44686h = new C44686h();
        c44686h.field_mediaId = str;
        c44686h.url = str2;
        c44686h.egD = 1;
        c44686h.field_fileType = 100;
        c44686h.egy = 5;
        c44686h.concurrentCount = 3;
        c44686h.field_fullpath = str3;
        c44686h.egK = c34947d;
        cnA.qHI.put(str, str3);
        C37961o.alm().mo73060a(c44686h, false);
        AppMethodBeat.m2505o(36049);
    }

    public void requestVideoData(String str, int i, int i2) {
        AppMethodBeat.m2504i(36050);
        C7060h.pYm.mo15419k(955, 32, 1);
        REMOTE_CALL("requestVideoDataMM", str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(36050);
    }

    @C46608f
    public void requestVideoDataMM(String str, int i, int i2) {
        AppMethodBeat.m2504i(36051);
        C7060h.pYm.mo15419k(955, 33, 1);
        C37961o.alm();
        C45150e.m83031k(str, i, i2);
        AppMethodBeat.m2505o(36051);
    }

    public boolean isVideoDataAvailable(String str, int i, int i2) {
        AppMethodBeat.m2504i(36052);
        Object REMOTE_CALL = REMOTE_CALL("isVideoDataAvailableMM", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(36052);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.m2505o(36052);
        return booleanValue;
    }

    @C46608f
    public boolean isVideoDataAvailableMM(String str, int i, int i2) {
        AppMethodBeat.m2504i(36053);
        C4990ab.m7417i("AdLandingPagesProxy", "is video data avaiable %s %d %d %s", str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(C37961o.alm().isVideoDataAvailable(str, i, i2)));
        AppMethodBeat.m2505o(36053);
        return C37961o.alm().isVideoDataAvailable(str, i, i2);
    }

    @C40602e
    public void onCdnVideoMoovReady(String str, int i, int i2) {
        AppMethodBeat.m2504i(36054);
        C4990ab.m7417i("AdLandingPagesProxy", "cdn video moov ready %s %d %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.qHr.containsKey(str)) {
            ((C26326a) this.qHr.get(str)).onMoovReady(str, i, i2);
        }
        AppMethodBeat.m2505o(36054);
    }

    @C40602e
    public void onCdnVideoDataAvailable(String str, int i, int i2) {
        AppMethodBeat.m2504i(36055);
        C4990ab.m7417i("AdLandingPagesProxy", "cdn video data available %s %d %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.qHr.containsKey(str)) {
            ((C26326a) this.qHr.get(str)).onDataAvailable(str, i, i2);
        }
        AppMethodBeat.m2505o(36055);
    }

    @C40602e
    public void onCdnVideoProgress(String str, int i, int i2) {
        AppMethodBeat.m2504i(36056);
        C4990ab.m7417i("AdLandingPagesProxy", "cdn video progress %s %d %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.qHr.containsKey(str)) {
            ((C26326a) this.qHr.get(str)).mo8706h(str, i, i2);
        }
        AppMethodBeat.m2505o(36056);
    }

    @C40602e
    public void onCdnVideoFinish(String str, int i) {
        AppMethodBeat.m2504i(36057);
        C4990ab.m7417i("AdLandingPagesProxy", "cdn video finish %s, %d", str, Integer.valueOf(i));
        if (i == 0) {
            C4996ah.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(str, true).commit();
        }
        if (this.qHr.containsKey(str)) {
            ((C26326a) this.qHr.remove(str)).mo8705a(str, i, null);
        }
        AppMethodBeat.m2505o(36057);
    }

    public boolean isUseSnsDownloadImage() {
        AppMethodBeat.m2504i(36058);
        Object REMOTE_CALL = REMOTE_CALL("isUseSnsDownloadImageMM", new Object[0]);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(36058);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.m2505o(36058);
        return booleanValue;
    }

    @C46608f
    public boolean isUseSnsDownloadImageMM() {
        boolean z;
        AppMethodBeat.m2504i(36059);
        C29043f c29043f = qHn;
        if (C5046bo.m7588yz() - c29043f.lastUpdateTime > 3600) {
            c29043f.qHu = false;
            try {
                if (C1720g.m3531RK()) {
                    C5141c ll = C18624c.abi().mo17131ll("100348");
                    if (ll.isValid()) {
                        if (C5046bo.getInt((String) ll.dru().get("downloadMode"), 0) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c29043f.qHu = z;
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("AdLandingPagesProxy", e, "get abtest failed!", new Object[0]);
            }
            c29043f.lastUpdateTime = C5046bo.m7588yz();
        }
        z = qHn.qHu;
        AppMethodBeat.m2505o(36059);
        return z;
    }

    @C46608f
    public String getSnsStatExtBySnsIdMM(long j) {
        AppMethodBeat.m2504i(35935);
        C43570e ku = C13373af.cnI().mo69174ku(j);
        String a;
        if (ku != null) {
            a = C13341f.m21439a(ku.cqu());
            AppMethodBeat.m2505o(35935);
            return a;
        }
        C4990ab.m7419v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", Long.valueOf(j));
        a = "";
        AppMethodBeat.m2505o(35935);
        return a;
    }

    @C46608f
    public boolean isApkExistMM(String str) {
        AppMethodBeat.m2504i(35982);
        C39783a c39783a = C29089e.qVH;
        FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str);
        if (Ir == null || TextUtils.isEmpty(Ir.path) || !C5730e.m8628ct(Ir.path)) {
            AppMethodBeat.m2505o(35982);
            return false;
        }
        AppMethodBeat.m2505o(35982);
        return true;
    }

    @C46608f
    public boolean isDownloadingMM(String str) {
        AppMethodBeat.m2504i(35983);
        C39783a c39783a = C29089e.qVH;
        FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str);
        if (Ir == null || Ir.status != 1) {
            AppMethodBeat.m2505o(35983);
            return false;
        }
        AppMethodBeat.m2505o(35983);
        return true;
    }

    @C46608f
    public boolean isPkgInstalledMM(String str) {
        AppMethodBeat.m2504i(35985);
        C39783a c39783a = C29089e.qVH;
        Context context = C4996ah.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(35985);
            return false;
        }
        boolean u = C35799p.m58695u(context, str);
        AppMethodBeat.m2505o(35985);
        return u;
    }

    @C46608f
    public boolean isPausedMM(String str) {
        AppMethodBeat.m2504i(35987);
        C39783a c39783a = C29089e.qVH;
        FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str);
        if (Ir == null || Ir.status != 2) {
            AppMethodBeat.m2505o(35987);
            return false;
        }
        AppMethodBeat.m2505o(35987);
        return true;
    }

    @C46608f
    public long startDownloadMM(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        AppMethodBeat.m2504i(35996);
        C39783a c39783a = C29089e.qVH;
        C34945b c34945b = new C34945b(str, str2, z);
        C39782b c39782b = this.qHp;
        C2901a c2901a = new C2901a();
        c2901a.setAppId(str);
        c2901a.mo7062cY(str2);
        c2901a.mo7058Iw(str3);
        c2901a.mo7055It(str4);
        c2901a.mo7057Iv(str5);
        c2901a.mo7063ga(z);
        long a = C2896d.bij().mo7042a(c2901a.kNl);
        if (c39782b != null) {
            c39783a.qHp = c39782b;
        }
        if (z) {
            c39783a.mo62902a(str2, c34945b);
        }
        c39783a.qVD.put(str, new C21969d(str6, str7));
        C2896d.bij();
        C2886b.m5129a(c39783a.qVE);
        C4990ab.m7417i("AdLandingPagesProxy", "startDownloadMM, id %d", Long.valueOf(a));
        AppMethodBeat.m2505o(35996);
        return a;
    }

    @C46608f
    public void stopTaskMM(String str) {
        AppMethodBeat.m2504i(35998);
        C39783a c39783a = C29089e.qVH;
        FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str);
        if (Ir != null) {
            C2896d.bij().mo7047hl(Ir.f16167id);
        }
        AppMethodBeat.m2505o(35998);
    }

    @C46608f
    public long queryIdByAppidMM(String str) {
        AppMethodBeat.m2504i(36000);
        C39783a c39783a = C29089e.qVH;
        long queryIdByAppid = C39783a.queryIdByAppid(str);
        AppMethodBeat.m2505o(36000);
        return queryIdByAppid;
    }

    @C46608f
    public boolean pauseTaskMM(String str) {
        AppMethodBeat.m2504i(36002);
        C39783a c39783a = C29089e.qVH;
        boolean hn = C2896d.bij().mo7049hn(C39783a.queryIdByAppid(str));
        AppMethodBeat.m2505o(36002);
        return hn;
    }

    @C46608f
    public int getTaskProgressMM(String str) {
        AppMethodBeat.m2504i(36004);
        C39783a c39783a = C29089e.qVH;
        FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str);
        if (Ir.jrb != 0) {
            int i = (int) ((Ir.kNr * 100) / Ir.jrb);
            AppMethodBeat.m2505o(36004);
            return i;
        }
        AppMethodBeat.m2505o(36004);
        return 0;
    }

    @C46608f
    public boolean resumeTaskMM(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36006);
        C39783a c39783a = C29089e.qVH;
        C39782b c39782b = this.qHp;
        FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str);
        if (Ir != null) {
            if (c39782b != null) {
                c39783a.qHp = c39782b;
            }
            c39783a.qVD.put(str, new C21969d(str2, str3));
            boolean ho = C2896d.bij().mo7050ho(Ir.f16167id);
            AppMethodBeat.m2505o(36006);
            return ho;
        }
        AppMethodBeat.m2505o(36006);
        return false;
    }

    @C46608f
    public boolean installAppMM(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(36008);
        C39783a c39783a = C29089e.qVH;
        Context context = C4996ah.getContext();
        C34945b c34945b = new C34945b(str, str2, false);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(36008);
            return false;
        }
        FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str);
        if (Ir == null || Ir.status != 3 || TextUtils.isEmpty(Ir.path)) {
            AppMethodBeat.m2505o(36008);
            return false;
        }
        Uri fromFile = Uri.fromFile(new File(Ir.path));
        c39783a.mo62901Z(4, Ir.f16167id);
        C35800q.m58697a(context, fromFile, null);
        c39783a.mo62902a(str2, c34945b);
        AppMethodBeat.m2505o(36008);
        return true;
    }

    @C46608f
    public void reportDownloadInfoMM(int i, String str) {
        AppMethodBeat.m2504i(36010);
        C29089e.qVH.reportDownloadInfo(i, str);
        AppMethodBeat.m2505o(36010);
    }

    @C46608f
    public void addReportInfoMM(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36012);
        C39783a c39783a = C29089e.qVH;
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(36012);
            return;
        }
        c39783a.qVD.put(str, new C21969d(str2, str3));
        AppMethodBeat.m2505o(36012);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Xy */
    static /* synthetic */ void m67974Xy(String str) {
        long ank;
        AppMethodBeat.m2504i(36060);
        int indexOf = str.indexOf("<canvasId>");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf("</canvasId>");
            if (indexOf2 > indexOf) {
                ank = (long) C5046bo.ank(str.substring(indexOf + 10, indexOf2));
                if (ank > 0) {
                    C4990ab.m7417i("AdLandingPagesProxy", "caching canvasId %d", Long.valueOf(ank));
                    C39787m.cqn().mo62909u(ank, str);
                }
                AppMethodBeat.m2505o(36060);
            }
        }
        ank = 0;
        if (ank > 0) {
        }
        AppMethodBeat.m2505o(36060);
    }
}
