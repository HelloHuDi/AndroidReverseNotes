package com.tencent.mm.plugin.webview.luggage.permission;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.view.d;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

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
    private a ulb = new a();
    private final HashMap<String, String> ulc = new HashMap();
    public RunCgiTask uld;

    public static final class RunCgiTask extends MainProcessTask implements f {
        public static final Creator<RunCgiTask> CREATOR = new Creator<RunCgiTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RunCgiTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(6459);
                RunCgiTask runCgiTask = new RunCgiTask();
                runCgiTask.g(parcel);
                AppMethodBeat.o(6459);
                return runCgiTask;
            }
        };
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
        h ulk;
        private byte[] ull;
        String url;
        String username;

        public RunCgiTask(String str, String str2, int i, int i2, int i3, String str3, byte[] bArr) {
            AppMethodBeat.i(6460);
            this.url = str;
            this.username = str2;
            this.scene = i;
            this.boZ = i2;
            this.ctE = i3;
            this.appId = str3;
            this.cPB = bArr;
            aBV();
            AppMethodBeat.o(6460);
        }

        public final void asP() {
            AppMethodBeat.i(6461);
            ab.i("MicroMsg.LuggageGetA8Key.RunCgiTask", "start, url: %s", this.url);
            this.ulk = new h(this.url, this.username, this.scene, this.boZ, 0, LuggageGetA8Key.access$200(), this.ctE, this.appId, "", 0, this.cPB);
            g.RO().eJo.a((int) d.MIC_PTU_MEISHI, (f) this);
            g.RO().eJo.a(this.ulk, 0);
            AppMethodBeat.o(6461);
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(6462);
            if (mVar != this.ulk) {
                AppMethodBeat.o(6462);
                return;
            }
            ab.i("MicroMsg.LuggageGetA8Key.RunCgiTask", "onSceneEnd, url: %s", this.url);
            g.RO().eJo.b((int) d.MIC_PTU_MEISHI, (f) this);
            this.errType = i;
            this.errCode = i2;
            this.aIm = str;
            try {
                this.ull = ((h) mVar).ehh.fsH.fsP.toByteArray();
            } catch (Exception e) {
            }
            aCb();
            AppMethodBeat.o(6462);
        }

        public final void asQ() {
            AppMethodBeat.i(6463);
            ab.i("MicroMsg.LuggageGetA8Key.RunCgiTask", "runInClientProcess: %s", this.url);
            try {
                aBW();
                if (this.ull != null) {
                    this.uli = new adp();
                    this.uli.parseFrom(this.ull);
                }
                this.ulj.run();
                AppMethodBeat.o(6463);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.LuggageGetA8Key.RunCgiTask", e, "", new Object[0]);
                AppMethodBeat.o(6463);
            }
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(6464);
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
            AppMethodBeat.o(6464);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(6465);
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
            AppMethodBeat.o(6465);
        }

        static {
            AppMethodBeat.i(6466);
            AppMethodBeat.o(6466);
        }
    }

    public static class a {
        public void NN(String str) {
        }

        public void cWY() {
        }

        public void e(String str, String str2, Map<String, String> map) {
        }

        public void ha(String str, String str2) {
        }

        public void a(int i, String str, int i2, int i3, String str2) {
        }
    }

    public LuggageGetA8Key() {
        AppMethodBeat.i(6467);
        AppMethodBeat.o(6467);
    }

    public final JsapiPermissionWrapper aei(String str) {
        AppMethodBeat.i(6468);
        JsapiPermissionWrapper aei = this.ulb.aei(str);
        AppMethodBeat.o(6468);
        return aei;
    }

    public final GeneralControlWrapper aej(String str) {
        AppMethodBeat.i(6469);
        GeneralControlWrapper aej = this.ulb.aej(str);
        AppMethodBeat.o(6469);
        return aej;
    }

    public final boolean dA(String str, int i) {
        AppMethodBeat.i(6470);
        if (aei(str).Lx(i) == 1) {
            AppMethodBeat.o(6470);
            return true;
        }
        AppMethodBeat.o(6470);
        return false;
    }

    public final String aek(String str) {
        String str2;
        AppMethodBeat.i(6471);
        synchronized (this.ulc) {
            try {
                ab.i("MicroMsg.LuggageGetA8Key", "getShareUrl, dropHashUrl = " + aef(str));
                for (String str22 : this.ulc.keySet()) {
                    ab.i("MicroMsg.LuggageGetA8Key", "getShareUrl, Key = %s, value = %s", str22, this.ulc.get(str22));
                }
                str22 = (String) this.ulc.get(aef(str));
            } finally {
                AppMethodBeat.o(6471);
            }
        }
        return str22;
    }

    static {
        AppMethodBeat.i(6480);
        AppMethodBeat.o(6480);
    }

    public final int ael(String str) {
        AppMethodBeat.i(6472);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.LuggageGetA8Key", "getReason fail, url is null");
            AppMethodBeat.o(6472);
            return 0;
        } else if (this.ukZ) {
            this.ukZ = false;
            AppMethodBeat.o(6472);
            return 0;
        } else if (ule.matcher(str).find()) {
            AppMethodBeat.o(6472);
            return 2;
        } else {
            AppMethodBeat.o(6472);
            return 1;
        }
    }

    public final boolean aem(String str) {
        AppMethodBeat.i(6473);
        boolean contains = this.ukW.contains(str);
        AppMethodBeat.o(6473);
        return contains;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A:{Catch:{ Exception -> 0x00c7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a A:{Catch:{ Exception -> 0x00c7 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(final String str, int i, final a aVar) {
        boolean z;
        AppMethodBeat.i(6474);
        if (aem(str)) {
            AppMethodBeat.o(6474);
            z = true;
        } else {
            a aVar2 = this.ulb;
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.LuggageGetA8KeyPermission", "has fail, url is null");
            } else {
                a aVar3 = (a) aVar2.ulm.get(a.aef(str));
                if (!(aVar3 == null || aVar3.ulr == aVar2.ulp || aVar3.uls == aVar2.ulq)) {
                    int i2 = 1;
                    if (i2 == null) {
                        AppMethodBeat.o(6474);
                        z = false;
                    } else if (i == 5 && this.ula) {
                        ab.w("MicroMsg.LuggageGetA8Key", "disable iframe request");
                        AppMethodBeat.o(6474);
                        z = false;
                    } else {
                        int ael;
                        this.ukW.add(str);
                        if (aVar != null) {
                            aVar.NN(str);
                        }
                        if (this.uld != null) {
                            this.uld.aBW();
                            this.uld = null;
                            ab.i("MicroMsg.LuggageGetA8Key", "runCgiTask set null: %s", str);
                        }
                        if (i == -1) {
                            ael = ael(str);
                        } else {
                            ael = i;
                        }
                        ab.i("MicroMsg.LuggageGetA8Key", "startGetA8Key, url: %s", str);
                        try {
                            this.uld = new RunCgiTask(str, this.igi, this.gOW, ael, this.ukY, this.mAppId, this.ukX);
                            this.uld.ulj = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(6458);
                                    ab.i("MicroMsg.LuggageGetA8Key", "callback: %s", str);
                                    if (LuggageGetA8Key.this.uld != null) {
                                        LuggageGetA8Key.a(LuggageGetA8Key.this, str, ael, LuggageGetA8Key.this.uld.errType, LuggageGetA8Key.this.uld.errCode, LuggageGetA8Key.this.uld.aIm, LuggageGetA8Key.this.uld.uli, aVar);
                                    }
                                    AppMethodBeat.o(6458);
                                }
                            };
                            AppBrandMainProcessService.a(this.uld);
                            AppMethodBeat.o(6474);
                            z = true;
                        } catch (Exception e) {
                            ab.i("MicroMsg.LuggageGetA8Key", "ERROR %s", e);
                            AppMethodBeat.o(6474);
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

    public final synchronized boolean a(String str, a aVar) {
        boolean a;
        AppMethodBeat.i(6475);
        a = a(str, -1, aVar);
        AppMethodBeat.o(6475);
        return a;
    }

    private static String aef(String str) {
        AppMethodBeat.i(6476);
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.o(6476);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.o(6476);
        return str;
    }

    private static void a(String str, adp adp, a aVar) {
        AppMethodBeat.i(6477);
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
                    ab.e("MicroMsg.LuggageGetA8Key", "getA8key-text fail, invalid content");
                    AppMethodBeat.o(6477);
                    return;
                }
                aVar.ha(str, str2);
                AppMethodBeat.o(6477);
                return;
            case 2:
            case 7:
                aVar.e(str, adp.wly, hashMap);
                AppMethodBeat.o(6477);
                return;
            case 6:
                aVar.e(str, adp.wly, hashMap);
                AppMethodBeat.o(6477);
                return;
            default:
                AppMethodBeat.o(6477);
                return;
        }
    }

    private static boolean gs(int i, int i2) {
        return i == 0 && i2 == 0;
    }

    private static boolean gt(int i, int i2) {
        return i == 4 && i2 == -2005;
    }

    static /* synthetic */ void a(LuggageGetA8Key luggageGetA8Key, String str, int i, int i2, int i3, String str2, adp adp, a aVar) {
        int i4 = 0;
        AppMethodBeat.i(6478);
        ab.i("MicroMsg.LuggageGetA8Key", "onSceneEnd, reqUrl: %s", str);
        if (i3 == 0 && i2 == 0) {
            if (adp != null) {
                String str3 = adp.wly;
                luggageGetA8Key.ukW.remove(str);
                luggageGetA8Key.ukW.remove(str3);
                if (!bo.isNullOrNil(adp.wlC)) {
                    synchronized (luggageGetA8Key.ulc) {
                        try {
                            luggageGetA8Key.ulc.put(aef(str), adp.wlC);
                            luggageGetA8Key.ulc.put(aef(str3), adp.wlC);
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.o(6478);
                            }
                        }
                    }
                }
                JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(aa.a(adp.wlH));
                GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(adp.wlB);
                switch (i) {
                    case 0:
                    case 2:
                    case 8:
                    case 9:
                        if (gs(i2, i3) || gt(i2, i3)) {
                            luggageGetA8Key.ulb.a(str, jsapiPermissionWrapper, generalControlWrapper);
                            luggageGetA8Key.ulb.a(str3, jsapiPermissionWrapper, generalControlWrapper);
                            luggageGetA8Key.ukX = aa.a(adp.wlw);
                            a(str, adp, aVar);
                            AppMethodBeat.o(6478);
                            return;
                        }
                        aVar.a(i, str, i2, i3, str2);
                        AppMethodBeat.o(6478);
                        return;
                    case 1:
                    case 5:
                        if (!gs(i2, i3)) {
                            if (!gt(i2, i3)) {
                                if (i2 != 0 && i3 == -3300) {
                                    i4 = 1;
                                }
                                if (i4 == 0) {
                                    aVar.a(i, str, i2, i3, str2);
                                    break;
                                }
                                luggageGetA8Key.ula = true;
                                AppMethodBeat.o(6478);
                                return;
                            }
                            luggageGetA8Key.ulb.a(str, jsapiPermissionWrapper, generalControlWrapper);
                            luggageGetA8Key.ulb.a(str3, jsapiPermissionWrapper, generalControlWrapper);
                            a(str, adp, aVar);
                            AppMethodBeat.o(6478);
                            return;
                        }
                        luggageGetA8Key.ulb.a(str, jsapiPermissionWrapper, generalControlWrapper);
                        luggageGetA8Key.ulb.a(str3, jsapiPermissionWrapper, generalControlWrapper);
                        luggageGetA8Key.ukX = aa.a(adp.wlw);
                        aVar.cWY();
                        AppMethodBeat.o(6478);
                        return;
                }
            }
            AppMethodBeat.o(6478);
            return;
        }
        aVar.a(i, str, i2, i3, str2);
        AppMethodBeat.o(6478);
    }

    static /* synthetic */ String access$200() {
        String str;
        AppMethodBeat.i(6479);
        ConnectivityManager connectivityManager = (ConnectivityManager) ah.getContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    str = "WIFI";
                    AppMethodBeat.o(6479);
                    return str;
                } else if (activeNetworkInfo.getExtraInfo() != null) {
                    str = activeNetworkInfo.getExtraInfo().toLowerCase();
                    AppMethodBeat.o(6479);
                    return str;
                }
            }
        }
        str = "no";
        AppMethodBeat.o(6479);
        return str;
    }
}
