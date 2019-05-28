package com.tencent.p177mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.modelappbrand.C26439v;
import com.tencent.p177mm.p230g.p232b.p233a.C26273ad;
import com.tencent.p177mm.p230g.p232b.p233a.C9513cr;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.p177mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.p177mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.p177mm.plugin.appbrand.dynamic.p289j.C19194a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p289j.C19194a.C19191d;
import com.tencent.p177mm.plugin.appbrand.dynamic.p289j.C19194a.C19193e;
import com.tencent.p177mm.plugin.appbrand.dynamic.p289j.C19194a.C191952;
import com.tencent.p177mm.plugin.appbrand.dynamic.p289j.C2152d;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer */
public final class WxaWidgetInitializer {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer$1 */
    static class C101921 implements Runnable {
        final /* synthetic */ int fwD;
        final /* synthetic */ int gQG;
        final /* synthetic */ int hlL;
        final /* synthetic */ int hlM;
        final /* synthetic */ String hlN;
        final /* synthetic */ int hlO;
        final /* synthetic */ C26854a hlP;
        final /* synthetic */ String hlQ;
        final /* synthetic */ String hlR;
        final /* synthetic */ String val$appId;
        final /* synthetic */ String val$id;

        C101921(String str, int i, int i2, String str2, int i3, int i4, String str3, int i5, C26854a c26854a, String str4, String str5) {
            this.val$id = str;
            this.gQG = i;
            this.hlL = i2;
            this.val$appId = str2;
            this.hlM = i3;
            this.fwD = i4;
            this.hlN = str3;
            this.hlO = i5;
            this.hlP = c26854a;
            this.hlQ = str4;
            this.hlR = str5;
        }

        public final void run() {
            AppMethodBeat.m2504i(10718);
            C4990ab.m7411d("MicroMsg.WxaWidgetInitializer", "initialize(id : %s, pkgType : %s, version : %s)", this.val$id, Integer.valueOf(this.gQG), Integer.valueOf(this.hlL));
            C18652u.m29151i("MicroMsg.WxaWidgetInitializer", "initialize(id : %s, pkgType : %s, version : %s)", this.val$id, Integer.valueOf(this.gQG), Integer.valueOf(this.hlL));
            long currentTimeMillis = System.currentTimeMillis();
            C26439v.m42099kT(1);
            final C2152d a = C19194a.m29851a(this.val$appId, this.gQG, this.hlL, this.hlM, this.fwD, this.hlN);
            C26273ad eZ;
            if (a == null) {
                C4990ab.m7413e("MicroMsg.WxaWidgetInitializer", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", this.val$id, Integer.valueOf(this.gQG), Integer.valueOf(this.hlL));
                C26439v.m42099kT(3);
                eZ = new C26273ad().mo43950eY(this.val$id).mo43951eZ(C18652u.m29154pr(this.val$id));
                eZ.cYw = (long) this.hlO;
                eZ.cYs = 2;
                eZ.cYt = System.currentTimeMillis();
                eZ.cYu = 2;
                eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                C18652u.m29151i("MicroMsg.WxaWidgetInitializer", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", this.val$id, Integer.valueOf(this.gQG), Integer.valueOf(this.hlL));
                if (this.hlP != null) {
                    this.hlP.mo44625a(this.val$id, this.val$appId, false, null);
                }
                AppMethodBeat.m2505o(10718);
                return;
            }
            C18652u.m29151i("MicroMsg.WxaWidgetInitializer", "get lauch info , replace version %d with %d", Integer.valueOf(this.hlL), Integer.valueOf(a.hoY.vMG));
            eZ = new C26273ad().mo43950eY(this.val$id).mo43951eZ(C18652u.m29154pr(this.val$id));
            eZ.cYw = (long) this.hlO;
            eZ.cYs = 2;
            eZ.cYt = System.currentTimeMillis();
            eZ.cYu = 1;
            eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
            C26439v.m42099kT(2);
            WxaPkgWrappingInfo a2 = C19194a.m29850a(this.val$id, this.val$appId, this.hlQ, this.gQG, a.hoY.vMG, this.hlR);
            if (a2 != null) {
                C18652u.m29151i("MicroMsg.WxaWidgetInitializer", "get WxaPkgWrapping info", new Object[0]);
                WxaWidgetContextImpl a3 = WxaWidgetInitializer.m42770a(this.val$id, this.val$appId, a2, a);
                if (this.hlP != null) {
                    boolean z;
                    C26854a c26854a = this.hlP;
                    String str = this.val$id;
                    String str2 = this.val$appId;
                    if (a3 != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    c26854a.mo44625a(str, str2, z, a3);
                }
                C9513cr c9513cr = new C9513cr();
                c9513cr.cTl = 1;
                c9513cr = c9513cr.mo20801hD(this.val$appId);
                c9513cr.dhm = System.currentTimeMillis() - currentTimeMillis;
                c9513cr.ajK();
                AppMethodBeat.m2505o(10718);
                return;
            }
            C18652u.m29151i("MicroMsg.WxaWidgetInitializer", "get widget PkgWrappingInfo(id : %s, pkgType : %s, version : %s) return null.", this.val$id, Integer.valueOf(this.gQG), Integer.valueOf(a.hoY.vMG));
            if (this.hlP != null) {
                this.hlP.mo44626bI(this.val$id, this.val$appId);
            }
            String str3 = this.val$id;
            String str4 = this.val$appId;
            String str5 = this.hlQ;
            int i = this.gQG;
            C101931 c101931 = new C19193e() {
                /* renamed from: ac */
                public final void mo21606ac(String str, boolean z) {
                    boolean z2 = false;
                    AppMethodBeat.m2504i(10717);
                    WxaWidgetContext wxaWidgetContext = null;
                    C4990ab.m7411d("MicroMsg.WxaWidgetInitializer", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", C101921.this.val$id, Integer.valueOf(C101921.this.gQG), Integer.valueOf(a.hoY.vMG), str, Boolean.valueOf(z));
                    C18652u.m29151i("MicroMsg.WxaWidgetInitializer", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", C101921.this.val$id, Integer.valueOf(C101921.this.gQG), Integer.valueOf(a.hoY.vMG), str, Boolean.valueOf(z));
                    if (z) {
                        WxaPkgWrappingInfo b = C19194a.m29852b(C101921.this.val$id, str, C101921.this.hlQ, C101921.this.gQG);
                        if (b != null) {
                            wxaWidgetContext = WxaWidgetInitializer.m42770a(C101921.this.val$id, str, b, a);
                        } else {
                            z = false;
                        }
                    }
                    if (C101921.this.hlP != null) {
                        C26854a c26854a = C101921.this.hlP;
                        String str2 = C101921.this.val$id;
                        if (z && wxaWidgetContext != null) {
                            z2 = true;
                        }
                        c26854a.mo44625a(str2, str, z2, wxaWidgetContext);
                    }
                    AppMethodBeat.m2505o(10717);
                }
            };
            if (i != C8415j.INVALID_ID && C19194a.m29852b(str3, str4, str5, i) == null) {
                Bundle bundle = new Bundle();
                bundle.putString("id", str3);
                bundle.putString("appId", str4);
                bundle.putInt("debugType", i);
                C9549f.m17012a("com.tencent.mm", bundle, C19191d.class, new C191952(c101931));
            }
            AppMethodBeat.m2505o(10718);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer$a */
    public interface C26854a {
        /* renamed from: a */
        void mo44625a(String str, String str2, boolean z, WxaWidgetContext wxaWidgetContext);

        /* renamed from: bI */
        void mo44626bI(String str, String str2);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer$WxaWidgetContextImpl */
    static class WxaWidgetContextImpl implements WxaWidgetContext {
        public static final Creator<WxaWidgetContextImpl> CREATOR = new C268551();
        String eIq;
        WxaPkgWrappingInfo hlU;
        WxaPkgWrappingInfo hlV;
        byte[] hlW;
        int hlX;
        DebuggerInfo hlY;
        WidgetSysConfig hlZ;
        WidgetRuntimeConfig hma;
        String mAppId;

        /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer$WxaWidgetContextImpl$1 */
        static class C268551 implements Creator<WxaWidgetContextImpl> {
            C268551() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxaWidgetContextImpl[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(10719);
                WxaWidgetContextImpl wxaWidgetContextImpl = new WxaWidgetContextImpl(parcel);
                AppMethodBeat.m2505o(10719);
                return wxaWidgetContextImpl;
            }
        }

        public WxaWidgetContextImpl(Parcel parcel) {
            AppMethodBeat.m2504i(10720);
            ClassLoader classLoader = getClass().getClassLoader();
            this.eIq = parcel.readString();
            this.mAppId = parcel.readString();
            this.hlV = (WxaPkgWrappingInfo) parcel.readParcelable(classLoader);
            this.hlU = (WxaPkgWrappingInfo) parcel.readParcelable(classLoader);
            this.hlW = parcel.createByteArray();
            this.hlX = parcel.readInt();
            this.hlY = (DebuggerInfo) parcel.readParcelable(classLoader);
            this.hlZ = (WidgetSysConfig) parcel.readParcelable(classLoader);
            this.hma = (WidgetRuntimeConfig) parcel.readParcelable(classLoader);
            AppMethodBeat.m2505o(10720);
        }

        public WxaWidgetContextImpl(WxaPkgWrappingInfo wxaPkgWrappingInfo, WxaPkgWrappingInfo wxaPkgWrappingInfo2) {
            AppMethodBeat.m2504i(10721);
            Assert.assertNotNull(wxaPkgWrappingInfo);
            Assert.assertNotNull(wxaPkgWrappingInfo2);
            this.hlV = wxaPkgWrappingInfo;
            this.hlU = wxaPkgWrappingInfo2;
            AppMethodBeat.m2505o(10721);
        }

        public final WxaPkgWrappingInfo azF() {
            return this.hlU;
        }

        public final WxaPkgWrappingInfo azG() {
            return this.hlV;
        }

        public final String getId() {
            return this.eIq;
        }

        public final String getAppId() {
            return this.mAppId;
        }

        public final int avn() {
            return this.hlU != null ? this.hlU.gVt : 0;
        }

        public final int azH() {
            return this.hlU != null ? this.hlU.gVu : 0;
        }

        public final byte[] azI() {
            return this.hlW;
        }

        public final int azJ() {
            return this.hlX;
        }

        public final DebuggerInfo azK() {
            return this.hlY;
        }

        public final WidgetSysConfig azL() {
            return this.hlZ;
        }

        public final WidgetRuntimeConfig azM() {
            return this.hma;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(10722);
            parcel.writeString(this.eIq);
            parcel.writeString(this.mAppId);
            parcel.writeParcelable(this.hlV, i);
            parcel.writeParcelable(this.hlU, i);
            parcel.writeByteArray(this.hlW);
            parcel.writeInt(this.hlX);
            parcel.writeParcelable(this.hlY, i);
            parcel.writeParcelable(this.hlZ, i);
            parcel.writeParcelable(this.hma, i);
            AppMethodBeat.m2505o(10722);
        }

        static {
            AppMethodBeat.m2504i(10723);
            AppMethodBeat.m2505o(10723);
        }
    }

    /* renamed from: a */
    static WxaWidgetContextImpl m42770a(String str, String str2, WxaPkgWrappingInfo wxaPkgWrappingInfo, C2152d c2152d) {
        int i = 1;
        AppMethodBeat.m2504i(10724);
        C4990ab.m7417i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", str);
        C18652u.m29151i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", str);
        WxaPkgWrappingInfo avQ = WxaCommLibRuntimeReader.avQ();
        if (avQ == null) {
            C4990ab.m7412e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
            AppMethodBeat.m2505o(10724);
            return null;
        }
        WxaWidgetContextImpl wxaWidgetContextImpl = new WxaWidgetContextImpl(avQ, wxaPkgWrappingInfo);
        wxaWidgetContextImpl.eIq = str;
        wxaWidgetContextImpl.mAppId = str2;
        wxaWidgetContextImpl.hlY = c2152d.hoT;
        if (wxaWidgetContextImpl.hlY == null) {
            wxaWidgetContextImpl.hlY = new DebuggerInfo();
        }
        wxaWidgetContextImpl.hlZ = c2152d.hoU;
        wxaWidgetContextImpl.hma = c2152d.hoV;
        try {
            byte[] toByteArray = (c2152d.hoX == null || c2152d.hoX.vYw == null) ? new byte[0] : c2152d.hoX.vYw.toByteArray();
            wxaWidgetContextImpl.hlW = toByteArray;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WxaWidgetInitializer", C5046bo.m7574l(e));
        }
        if (wxaWidgetContextImpl.hlY.hmF) {
            wxaWidgetContextImpl.hlX = 2;
            C10211f.azA().mo21628aZ(str, TXLiveConstants.PLAY_WARNING_VIDEO_DECODE_FAIL);
            C38203j.azE().mo60938E(str, JsApiShowImageOperateSheet.CTRL_INDEX, 5);
        } else {
            if (c2152d.hoW != null) {
                i = c2152d.hoW.vAS;
            }
            wxaWidgetContextImpl.hlX = i;
        }
        AppMethodBeat.m2505o(10724);
        return wxaWidgetContextImpl;
    }

    /* renamed from: bL */
    public static String m42771bL(String str, String str2) {
        AppMethodBeat.m2504i(10725);
        String str3 = str + "#" + str2 + "#" + System.currentTimeMillis();
        AppMethodBeat.m2505o(10725);
        return str3;
    }
}
