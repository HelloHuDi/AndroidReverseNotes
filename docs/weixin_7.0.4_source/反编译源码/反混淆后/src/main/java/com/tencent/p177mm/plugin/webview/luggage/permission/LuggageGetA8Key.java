package com.tencent.p177mm.plugin.webview.luggage.permission;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.webview.luggage.permission.C46421a.C14504a;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.adp;
import com.tencent.p177mm.protocal.protobuf.atp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key */
public final class LuggageGetA8Key {
    private static final Pattern ule = Pattern.compile(".*#.*wechat_redirect");
    private int gOW = 0;
    private String igi = "";
    private String mAppId = "";
    private final HashSet<String> ukW = new HashSet();
    private byte[] ukX = new byte[0];
    private int ukY = ((int) System.currentTimeMillis());
    private boolean ukZ = true;
    private boolean ula = false;
    private C46421a ulb = new C46421a();
    private final HashMap<String, String> ulc = new HashMap();
    public RunCgiTask uld;

    /* renamed from: com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key$RunCgiTask */
    public static final class RunCgiTask extends MainProcessTask implements C1202f {
        public static final Creator<RunCgiTask> CREATOR = new C145031();
        String aIm;
        String appId;
        int boZ;
        byte[] cPB;
        int ctE;
        int errCode;
        int errType;
        int scene;
        adp uli;
        Runnable ulj;
        C6681h ulk;
        private byte[] ull;
        String url;
        String username;

        /* renamed from: com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key$RunCgiTask$1 */
        static class C145031 implements Creator<RunCgiTask> {
            C145031() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RunCgiTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(6459);
                RunCgiTask runCgiTask = new RunCgiTask();
                runCgiTask.mo6032g(parcel);
                AppMethodBeat.m2505o(6459);
                return runCgiTask;
            }
        }

        public RunCgiTask(String str, String str2, int i, int i2, int i3, String str3, byte[] bArr) {
            AppMethodBeat.m2504i(6460);
            this.url = str;
            this.username = str2;
            this.scene = i;
            this.boZ = i2;
            this.ctE = i3;
            this.appId = str3;
            this.cPB = bArr;
            aBV();
            AppMethodBeat.m2505o(6460);
        }

        public final void asP() {
            AppMethodBeat.m2504i(6461);
            C4990ab.m7417i("MicroMsg.LuggageGetA8Key.RunCgiTask", "start, url: %s", this.url);
            this.ulk = new C6681h(this.url, this.username, this.scene, this.boZ, 0, LuggageGetA8Key.access$200(), this.ctE, this.appId, "", 0, this.cPB);
            C1720g.m3535RO().eJo.mo14539a((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
            C1720g.m3535RO().eJo.mo14541a(this.ulk, 0);
            AppMethodBeat.m2505o(6461);
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(6462);
            if (c1207m != this.ulk) {
                AppMethodBeat.m2505o(6462);
                return;
            }
            C4990ab.m7417i("MicroMsg.LuggageGetA8Key.RunCgiTask", "onSceneEnd, url: %s", this.url);
            C1720g.m3535RO().eJo.mo14546b((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
            this.errType = i;
            this.errCode = i2;
            this.aIm = str;
            try {
                this.ull = ((C6681h) c1207m).ehh.fsH.fsP.toByteArray();
            } catch (Exception e) {
            }
            aCb();
            AppMethodBeat.m2505o(6462);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(6463);
            C4990ab.m7417i("MicroMsg.LuggageGetA8Key.RunCgiTask", "runInClientProcess: %s", this.url);
            try {
                aBW();
                if (this.ull != null) {
                    this.uli = new adp();
                    this.uli.parseFrom(this.ull);
                }
                this.ulj.run();
                AppMethodBeat.m2505o(6463);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.LuggageGetA8Key.RunCgiTask", e, "", new Object[0]);
                AppMethodBeat.m2505o(6463);
            }
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(6464);
            this.url = parcel.readString();
            this.username = parcel.readString();
            this.scene = parcel.readInt();
            this.boZ = parcel.readInt();
            this.ctE = parcel.readInt();
            this.appId = parcel.readString();
            this.cPB = parcel.createByteArray();
            this.ull = parcel.createByteArray();
            this.errType = parcel.readInt();
            this.errCode = parcel.readInt();
            this.aIm = parcel.readString();
            AppMethodBeat.m2505o(6464);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(6465);
            parcel.writeString(this.url);
            parcel.writeString(this.username);
            parcel.writeInt(this.scene);
            parcel.writeInt(this.boZ);
            parcel.writeInt(this.ctE);
            parcel.writeString(this.appId);
            parcel.writeByteArray(this.cPB);
            parcel.writeByteArray(this.ull);
            parcel.writeInt(this.errType);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.aIm);
            AppMethodBeat.m2505o(6465);
        }

        static {
            AppMethodBeat.m2504i(6466);
            AppMethodBeat.m2505o(6466);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key$a */
    public static class C22870a {
        /* renamed from: NN */
        public void mo23958NN(String str) {
        }

        public void cWY() {
        }

        /* renamed from: e */
        public void mo23960e(String str, String str2, Map<String, String> map) {
        }

        /* renamed from: ha */
        public void mo38469ha(String str, String str2) {
        }

        /* renamed from: a */
        public void mo23959a(int i, String str, int i2, int i3, String str2) {
        }
    }

    public LuggageGetA8Key() {
        AppMethodBeat.m2504i(6467);
        AppMethodBeat.m2505o(6467);
    }

    public final JsapiPermissionWrapper aei(String str) {
        AppMethodBeat.m2504i(6468);
        JsapiPermissionWrapper aei = this.ulb.aei(str);
        AppMethodBeat.m2505o(6468);
        return aei;
    }

    public final GeneralControlWrapper aej(String str) {
        AppMethodBeat.m2504i(6469);
        GeneralControlWrapper aej = this.ulb.aej(str);
        AppMethodBeat.m2505o(6469);
        return aej;
    }

    /* renamed from: dA */
    public final boolean mo74640dA(String str, int i) {
        AppMethodBeat.m2504i(6470);
        if (aei(str).mo69828Lx(i) == 1) {
            AppMethodBeat.m2505o(6470);
            return true;
        }
        AppMethodBeat.m2505o(6470);
        return false;
    }

    public final String aek(String str) {
        String str2;
        AppMethodBeat.m2504i(6471);
        synchronized (this.ulc) {
            try {
                C4990ab.m7416i("MicroMsg.LuggageGetA8Key", "getShareUrl, dropHashUrl = " + LuggageGetA8Key.aef(str));
                for (String str22 : this.ulc.keySet()) {
                    C4990ab.m7417i("MicroMsg.LuggageGetA8Key", "getShareUrl, Key = %s, value = %s", str22, this.ulc.get(str22));
                }
                str22 = (String) this.ulc.get(LuggageGetA8Key.aef(str));
            } finally {
                AppMethodBeat.m2505o(6471);
            }
        }
        return str22;
    }

    static {
        AppMethodBeat.m2504i(6480);
        AppMethodBeat.m2505o(6480);
    }

    public final int ael(String str) {
        AppMethodBeat.m2504i(6472);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.LuggageGetA8Key", "getReason fail, url is null");
            AppMethodBeat.m2505o(6472);
            return 0;
        } else if (this.ukZ) {
            this.ukZ = false;
            AppMethodBeat.m2505o(6472);
            return 0;
        } else if (ule.matcher(str).find()) {
            AppMethodBeat.m2505o(6472);
            return 2;
        } else {
            AppMethodBeat.m2505o(6472);
            return 1;
        }
    }

    public final boolean aem(String str) {
        AppMethodBeat.m2504i(6473);
        boolean contains = this.ukW.contains(str);
        AppMethodBeat.m2505o(6473);
        return contains;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A:{Catch:{ Exception -> 0x00c7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a A:{Catch:{ Exception -> 0x00c7 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final synchronized boolean mo74633a(final String str, int i, final C22870a c22870a) {
        boolean z;
        AppMethodBeat.m2504i(6474);
        if (aem(str)) {
            AppMethodBeat.m2505o(6474);
            z = true;
        } else {
            C46421a c46421a = this.ulb;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.LuggageGetA8KeyPermission", "has fail, url is null");
            } else {
                C14504a c14504a = (C14504a) c46421a.ulm.get(C46421a.aef(str));
                if (!(c14504a == null || c14504a.ulr == c46421a.ulp || c14504a.uls == c46421a.ulq)) {
                    int i2 = 1;
                    if (i2 == null) {
                        AppMethodBeat.m2505o(6474);
                        z = false;
                    } else if (i == 5 && this.ula) {
                        C4990ab.m7420w("MicroMsg.LuggageGetA8Key", "disable iframe request");
                        AppMethodBeat.m2505o(6474);
                        z = false;
                    } else {
                        int ael;
                        this.ukW.add(str);
                        if (c22870a != null) {
                            c22870a.mo23958NN(str);
                        }
                        if (this.uld != null) {
                            this.uld.aBW();
                            this.uld = null;
                            C4990ab.m7417i("MicroMsg.LuggageGetA8Key", "runCgiTask set null: %s", str);
                        }
                        if (i == -1) {
                            ael = ael(str);
                        } else {
                            ael = i;
                        }
                        C4990ab.m7417i("MicroMsg.LuggageGetA8Key", "startGetA8Key, url: %s", str);
                        try {
                            this.uld = new RunCgiTask(str, this.igi, this.gOW, ael, this.ukY, this.mAppId, this.ukX);
                            this.uld.ulj = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(6458);
                                    C4990ab.m7417i("MicroMsg.LuggageGetA8Key", "callback: %s", str);
                                    if (LuggageGetA8Key.this.uld != null) {
                                        LuggageGetA8Key.m87433a(LuggageGetA8Key.this, str, ael, LuggageGetA8Key.this.uld.errType, LuggageGetA8Key.this.uld.errCode, LuggageGetA8Key.this.uld.aIm, LuggageGetA8Key.this.uld.uli, c22870a);
                                    }
                                    AppMethodBeat.m2505o(6458);
                                }
                            };
                            AppBrandMainProcessService.m54349a(this.uld);
                            AppMethodBeat.m2505o(6474);
                            z = true;
                        } catch (Exception e) {
                            C4990ab.m7417i("MicroMsg.LuggageGetA8Key", "ERROR %s", e);
                            AppMethodBeat.m2505o(6474);
                            z = false;
                        }
                    }
                }
            }
            Object i22 = null;
            if (i22 == null) {
            }
        }
        return z;
    }

    /* renamed from: a */
    public final synchronized boolean mo74634a(String str, C22870a c22870a) {
        boolean a;
        AppMethodBeat.m2504i(6475);
        a = mo74633a(str, -1, c22870a);
        AppMethodBeat.m2505o(6475);
        return a;
    }

    private static String aef(String str) {
        AppMethodBeat.m2504i(6476);
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.m2505o(6476);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.m2505o(6476);
        return str;
    }

    /* renamed from: a */
    private static void m87434a(String str, adp adp, C22870a c22870a) {
        AppMethodBeat.m2504i(6477);
        int i = adp.vAS;
        String str2 = adp.ncM;
        LinkedList<atp> linkedList = adp.wlJ;
        HashMap hashMap = new HashMap();
        if (linkedList != null) {
            for (atp atp : linkedList) {
                hashMap.put(atp.vMU, atp.pXM);
            }
        }
        switch (i) {
            case 1:
                if (str2 == null || str2.length() == 0) {
                    C4990ab.m7412e("MicroMsg.LuggageGetA8Key", "getA8key-text fail, invalid content");
                    AppMethodBeat.m2505o(6477);
                    return;
                }
                c22870a.mo38469ha(str, str2);
                AppMethodBeat.m2505o(6477);
                return;
            case 2:
            case 7:
                c22870a.mo23960e(str, adp.wly, hashMap);
                AppMethodBeat.m2505o(6477);
                return;
            case 6:
                c22870a.mo23960e(str, adp.wly, hashMap);
                AppMethodBeat.m2505o(6477);
                return;
            default:
                AppMethodBeat.m2505o(6477);
                return;
        }
    }

    /* renamed from: gs */
    private static boolean m87435gs(int i, int i2) {
        return i == 0 && i2 == 0;
    }

    /* renamed from: gt */
    private static boolean m87436gt(int i, int i2) {
        return i == 4 && i2 == -2005;
    }

    /* renamed from: a */
    static /* synthetic */ void m87433a(LuggageGetA8Key luggageGetA8Key, String str, int i, int i2, int i3, String str2, adp adp, C22870a c22870a) {
        int i4 = 0;
        AppMethodBeat.m2504i(6478);
        C4990ab.m7417i("MicroMsg.LuggageGetA8Key", "onSceneEnd, reqUrl: %s", str);
        if (i3 == 0 && i2 == 0) {
            if (adp != null) {
                String str3 = adp.wly;
                luggageGetA8Key.ukW.remove(str);
                luggageGetA8Key.ukW.remove(str3);
                if (!C5046bo.isNullOrNil(adp.wlC)) {
                    synchronized (luggageGetA8Key.ulc) {
                        try {
                            luggageGetA8Key.ulc.put(LuggageGetA8Key.aef(str), adp.wlC);
                            luggageGetA8Key.ulc.put(LuggageGetA8Key.aef(str3), adp.wlC);
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.m2505o(6478);
                            }
                        }
                    }
                }
                JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(C1946aa.m4150a(adp.wlH));
                GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(adp.wlB);
                switch (i) {
                    case 0:
                    case 2:
                    case 8:
                    case 9:
                        if (LuggageGetA8Key.m87435gs(i2, i3) || LuggageGetA8Key.m87436gt(i2, i3)) {
                            luggageGetA8Key.ulb.mo74641a(str, jsapiPermissionWrapper, generalControlWrapper);
                            luggageGetA8Key.ulb.mo74641a(str3, jsapiPermissionWrapper, generalControlWrapper);
                            luggageGetA8Key.ukX = C1946aa.m4150a(adp.wlw);
                            LuggageGetA8Key.m87434a(str, adp, c22870a);
                            AppMethodBeat.m2505o(6478);
                            return;
                        }
                        c22870a.mo23959a(i, str, i2, i3, str2);
                        AppMethodBeat.m2505o(6478);
                        return;
                    case 1:
                    case 5:
                        if (!LuggageGetA8Key.m87435gs(i2, i3)) {
                            if (!LuggageGetA8Key.m87436gt(i2, i3)) {
                                if (i2 != 0 && i3 == -3300) {
                                    i4 = 1;
                                }
                                if (i4 == 0) {
                                    c22870a.mo23959a(i, str, i2, i3, str2);
                                    break;
                                }
                                luggageGetA8Key.ula = true;
                                AppMethodBeat.m2505o(6478);
                                return;
                            }
                            luggageGetA8Key.ulb.mo74641a(str, jsapiPermissionWrapper, generalControlWrapper);
                            luggageGetA8Key.ulb.mo74641a(str3, jsapiPermissionWrapper, generalControlWrapper);
                            LuggageGetA8Key.m87434a(str, adp, c22870a);
                            AppMethodBeat.m2505o(6478);
                            return;
                        }
                        luggageGetA8Key.ulb.mo74641a(str, jsapiPermissionWrapper, generalControlWrapper);
                        luggageGetA8Key.ulb.mo74641a(str3, jsapiPermissionWrapper, generalControlWrapper);
                        luggageGetA8Key.ukX = C1946aa.m4150a(adp.wlw);
                        c22870a.cWY();
                        AppMethodBeat.m2505o(6478);
                        return;
                }
            }
            AppMethodBeat.m2505o(6478);
            return;
        }
        c22870a.mo23959a(i, str, i2, i3, str2);
        AppMethodBeat.m2505o(6478);
    }

    static /* synthetic */ String access$200() {
        String str;
        AppMethodBeat.m2504i(6479);
        ConnectivityManager connectivityManager = (ConnectivityManager) C4996ah.getContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    str = "WIFI";
                    AppMethodBeat.m2505o(6479);
                    return str;
                } else if (activeNetworkInfo.getExtraInfo() != null) {
                    str = activeNetworkInfo.getExtraInfo().toLowerCase();
                    AppMethodBeat.m2505o(6479);
                    return str;
                }
            }
        }
        str = "no";
        AppMethodBeat.m2505o(6479);
        return str;
    }
}
