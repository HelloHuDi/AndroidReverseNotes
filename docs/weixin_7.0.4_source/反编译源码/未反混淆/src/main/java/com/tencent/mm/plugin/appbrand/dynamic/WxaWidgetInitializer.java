package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ad;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.AnonymousClass2;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import junit.framework.Assert;

public final class WxaWidgetInitializer {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ int fwD;
        final /* synthetic */ int gQG;
        final /* synthetic */ int hlL;
        final /* synthetic */ int hlM;
        final /* synthetic */ String hlN;
        final /* synthetic */ int hlO;
        final /* synthetic */ a hlP;
        final /* synthetic */ String hlQ;
        final /* synthetic */ String hlR;
        final /* synthetic */ String val$appId;
        final /* synthetic */ String val$id;

        AnonymousClass1(String str, int i, int i2, String str2, int i3, int i4, String str3, int i5, a aVar, String str4, String str5) {
            this.val$id = str;
            this.gQG = i;
            this.hlL = i2;
            this.val$appId = str2;
            this.hlM = i3;
            this.fwD = i4;
            this.hlN = str3;
            this.hlO = i5;
            this.hlP = aVar;
            this.hlQ = str4;
            this.hlR = str5;
        }

        public final void run() {
            AppMethodBeat.i(10718);
            ab.d("MicroMsg.WxaWidgetInitializer", "initialize(id : %s, pkgType : %s, version : %s)", this.val$id, Integer.valueOf(this.gQG), Integer.valueOf(this.hlL));
            u.i("MicroMsg.WxaWidgetInitializer", "initialize(id : %s, pkgType : %s, version : %s)", this.val$id, Integer.valueOf(this.gQG), Integer.valueOf(this.hlL));
            long currentTimeMillis = System.currentTimeMillis();
            v.kT(1);
            final d a = com.tencent.mm.plugin.appbrand.dynamic.j.a.a(this.val$appId, this.gQG, this.hlL, this.hlM, this.fwD, this.hlN);
            ad eZ;
            if (a == null) {
                ab.e("MicroMsg.WxaWidgetInitializer", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", this.val$id, Integer.valueOf(this.gQG), Integer.valueOf(this.hlL));
                v.kT(3);
                eZ = new ad().eY(this.val$id).eZ(u.pr(this.val$id));
                eZ.cYw = (long) this.hlO;
                eZ.cYs = 2;
                eZ.cYt = System.currentTimeMillis();
                eZ.cYu = 2;
                eZ.fa(at.gB(ah.getContext())).ajK();
                u.i("MicroMsg.WxaWidgetInitializer", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", this.val$id, Integer.valueOf(this.gQG), Integer.valueOf(this.hlL));
                if (this.hlP != null) {
                    this.hlP.a(this.val$id, this.val$appId, false, null);
                }
                AppMethodBeat.o(10718);
                return;
            }
            u.i("MicroMsg.WxaWidgetInitializer", "get lauch info , replace version %d with %d", Integer.valueOf(this.hlL), Integer.valueOf(a.hoY.vMG));
            eZ = new ad().eY(this.val$id).eZ(u.pr(this.val$id));
            eZ.cYw = (long) this.hlO;
            eZ.cYs = 2;
            eZ.cYt = System.currentTimeMillis();
            eZ.cYu = 1;
            eZ.fa(at.gB(ah.getContext())).ajK();
            v.kT(2);
            WxaPkgWrappingInfo a2 = com.tencent.mm.plugin.appbrand.dynamic.j.a.a(this.val$id, this.val$appId, this.hlQ, this.gQG, a.hoY.vMG, this.hlR);
            if (a2 != null) {
                u.i("MicroMsg.WxaWidgetInitializer", "get WxaPkgWrapping info", new Object[0]);
                WxaWidgetContextImpl a3 = WxaWidgetInitializer.a(this.val$id, this.val$appId, a2, a);
                if (this.hlP != null) {
                    boolean z;
                    a aVar = this.hlP;
                    String str = this.val$id;
                    String str2 = this.val$appId;
                    if (a3 != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aVar.a(str, str2, z, a3);
                }
                cr crVar = new cr();
                crVar.cTl = 1;
                crVar = crVar.hD(this.val$appId);
                crVar.dhm = System.currentTimeMillis() - currentTimeMillis;
                crVar.ajK();
                AppMethodBeat.o(10718);
                return;
            }
            u.i("MicroMsg.WxaWidgetInitializer", "get widget PkgWrappingInfo(id : %s, pkgType : %s, version : %s) return null.", this.val$id, Integer.valueOf(this.gQG), Integer.valueOf(a.hoY.vMG));
            if (this.hlP != null) {
                this.hlP.bI(this.val$id, this.val$appId);
            }
            String str3 = this.val$id;
            String str4 = this.val$appId;
            String str5 = this.hlQ;
            int i = this.gQG;
            AnonymousClass1 anonymousClass1 = new e() {
                public final void ac(String str, boolean z) {
                    boolean z2 = false;
                    AppMethodBeat.i(10717);
                    WxaWidgetContext wxaWidgetContext = null;
                    ab.d("MicroMsg.WxaWidgetInitializer", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", AnonymousClass1.this.val$id, Integer.valueOf(AnonymousClass1.this.gQG), Integer.valueOf(a.hoY.vMG), str, Boolean.valueOf(z));
                    u.i("MicroMsg.WxaWidgetInitializer", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", AnonymousClass1.this.val$id, Integer.valueOf(AnonymousClass1.this.gQG), Integer.valueOf(a.hoY.vMG), str, Boolean.valueOf(z));
                    if (z) {
                        WxaPkgWrappingInfo b = com.tencent.mm.plugin.appbrand.dynamic.j.a.b(AnonymousClass1.this.val$id, str, AnonymousClass1.this.hlQ, AnonymousClass1.this.gQG);
                        if (b != null) {
                            wxaWidgetContext = WxaWidgetInitializer.a(AnonymousClass1.this.val$id, str, b, a);
                        } else {
                            z = false;
                        }
                    }
                    if (AnonymousClass1.this.hlP != null) {
                        a aVar = AnonymousClass1.this.hlP;
                        String str2 = AnonymousClass1.this.val$id;
                        if (z && wxaWidgetContext != null) {
                            z2 = true;
                        }
                        aVar.a(str2, str, z2, wxaWidgetContext);
                    }
                    AppMethodBeat.o(10717);
                }
            };
            if (i != j.INVALID_ID && com.tencent.mm.plugin.appbrand.dynamic.j.a.b(str3, str4, str5, i) == null) {
                Bundle bundle = new Bundle();
                bundle.putString("id", str3);
                bundle.putString("appId", str4);
                bundle.putInt("debugType", i);
                f.a("com.tencent.mm", bundle, com.tencent.mm.plugin.appbrand.dynamic.j.a.d.class, new AnonymousClass2(anonymousClass1));
            }
            AppMethodBeat.o(10718);
        }
    }

    public interface a {
        void a(String str, String str2, boolean z, WxaWidgetContext wxaWidgetContext);

        void bI(String str, String str2);
    }

    static class WxaWidgetContextImpl implements WxaWidgetContext {
        public static final Creator<WxaWidgetContextImpl> CREATOR = new Creator<WxaWidgetContextImpl>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxaWidgetContextImpl[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(10719);
                WxaWidgetContextImpl wxaWidgetContextImpl = new WxaWidgetContextImpl(parcel);
                AppMethodBeat.o(10719);
                return wxaWidgetContextImpl;
            }
        };
        String eIq;
        WxaPkgWrappingInfo hlU;
        WxaPkgWrappingInfo hlV;
        byte[] hlW;
        int hlX;
        DebuggerInfo hlY;
        WidgetSysConfig hlZ;
        WidgetRuntimeConfig hma;
        String mAppId;

        public WxaWidgetContextImpl(Parcel parcel) {
            AppMethodBeat.i(10720);
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
            AppMethodBeat.o(10720);
        }

        public WxaWidgetContextImpl(WxaPkgWrappingInfo wxaPkgWrappingInfo, WxaPkgWrappingInfo wxaPkgWrappingInfo2) {
            AppMethodBeat.i(10721);
            Assert.assertNotNull(wxaPkgWrappingInfo);
            Assert.assertNotNull(wxaPkgWrappingInfo2);
            this.hlV = wxaPkgWrappingInfo;
            this.hlU = wxaPkgWrappingInfo2;
            AppMethodBeat.o(10721);
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
            AppMethodBeat.i(10722);
            parcel.writeString(this.eIq);
            parcel.writeString(this.mAppId);
            parcel.writeParcelable(this.hlV, i);
            parcel.writeParcelable(this.hlU, i);
            parcel.writeByteArray(this.hlW);
            parcel.writeInt(this.hlX);
            parcel.writeParcelable(this.hlY, i);
            parcel.writeParcelable(this.hlZ, i);
            parcel.writeParcelable(this.hma, i);
            AppMethodBeat.o(10722);
        }

        static {
            AppMethodBeat.i(10723);
            AppMethodBeat.o(10723);
        }
    }

    static WxaWidgetContextImpl a(String str, String str2, WxaPkgWrappingInfo wxaPkgWrappingInfo, d dVar) {
        int i = 1;
        AppMethodBeat.i(10724);
        ab.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", str);
        u.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", str);
        WxaPkgWrappingInfo avQ = WxaCommLibRuntimeReader.avQ();
        if (avQ == null) {
            ab.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
            AppMethodBeat.o(10724);
            return null;
        }
        WxaWidgetContextImpl wxaWidgetContextImpl = new WxaWidgetContextImpl(avQ, wxaPkgWrappingInfo);
        wxaWidgetContextImpl.eIq = str;
        wxaWidgetContextImpl.mAppId = str2;
        wxaWidgetContextImpl.hlY = dVar.hoT;
        if (wxaWidgetContextImpl.hlY == null) {
            wxaWidgetContextImpl.hlY = new DebuggerInfo();
        }
        wxaWidgetContextImpl.hlZ = dVar.hoU;
        wxaWidgetContextImpl.hma = dVar.hoV;
        try {
            byte[] toByteArray = (dVar.hoX == null || dVar.hoX.vYw == null) ? new byte[0] : dVar.hoX.vYw.toByteArray();
            wxaWidgetContextImpl.hlW = toByteArray;
        } catch (Exception e) {
            ab.e("MicroMsg.WxaWidgetInitializer", bo.l(e));
        }
        if (wxaWidgetContextImpl.hlY.hmF) {
            wxaWidgetContextImpl.hlX = 2;
            f.azA().aZ(str, TXLiveConstants.PLAY_WARNING_VIDEO_DECODE_FAIL);
            j.azE().E(str, JsApiShowImageOperateSheet.CTRL_INDEX, 5);
        } else {
            if (dVar.hoW != null) {
                i = dVar.hoW.vAS;
            }
            wxaWidgetContextImpl.hlX = i;
        }
        AppMethodBeat.o(10724);
        return wxaWidgetContextImpl;
    }

    public static String bL(String str, String str2) {
        AppMethodBeat.i(10725);
        String str3 = str + "#" + str2 + "#" + System.currentTimeMillis();
        AppMethodBeat.o(10725);
        return str3;
    }
}
