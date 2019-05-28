package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C42401a;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C42401a.C10167a;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.sport.p1302a.C39858b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting */
public final class JsApiOpenWeRunSetting extends C10296a {
    public static final int CTRL_INDEX = 228;
    public static final String NAME = "openWeRunSetting";
    private OpenWeRunSetting hyr;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting$OpenWeRunSetting */
    static class OpenWeRunSetting extends MainProcessTask {
        public static final Creator<OpenWeRunSetting> CREATOR = new C192693();
        private boolean cPT = false;
        private int hwi;
        private C45608m hwz;
        private C2241c hxS;
        private boolean hys = false;
        private boolean hyt;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting$OpenWeRunSetting$3 */
        static class C192693 implements Creator<OpenWeRunSetting> {
            C192693() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OpenWeRunSetting[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130530);
                OpenWeRunSetting openWeRunSetting = new OpenWeRunSetting(parcel);
                AppMethodBeat.m2505o(130530);
                return openWeRunSetting;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting$OpenWeRunSetting$2 */
        class C192702 implements C5186a {
            C192702() {
            }

            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(130529);
                if (i != (OpenWeRunSetting.this.hashCode() & CdnLogic.kBizGeneric)) {
                    OpenWeRunSetting.this.aBW();
                    AppMethodBeat.m2505o(130529);
                } else if (i2 == -1) {
                    OpenWeRunSetting.this.hxS.mo6107M(OpenWeRunSetting.this.hwi, OpenWeRunSetting.this.hwz.mo73394j("ok", null));
                    OpenWeRunSetting.this.aBW();
                    AppMethodBeat.m2505o(130529);
                } else if (i2 == 0) {
                    OpenWeRunSetting.this.hxS.mo6107M(OpenWeRunSetting.this.hwi, OpenWeRunSetting.this.hwz.mo73394j("cancel", null));
                    OpenWeRunSetting.this.aBW();
                    AppMethodBeat.m2505o(130529);
                } else {
                    OpenWeRunSetting.this.hxS.mo6107M(OpenWeRunSetting.this.hwi, OpenWeRunSetting.this.hwz.mo73394j("fail", null));
                    OpenWeRunSetting.this.aBW();
                    AppMethodBeat.m2505o(130529);
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting$OpenWeRunSetting$1 */
        class C192711 implements C10167a {
            C192711() {
            }

            /* renamed from: q */
            public final void mo21549q(boolean z, boolean z2) {
                boolean z3;
                AppMethodBeat.m2504i(130528);
                OpenWeRunSetting openWeRunSetting = OpenWeRunSetting.this;
                if (z && z2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                openWeRunSetting.hys = z3;
                C4990ab.m7417i("MicroMsg.JsApiOpenWeRunSetting", "After getUserState requestOk %b, hasStep %b", Boolean.valueOf(z), Boolean.valueOf(z2));
                OpenWeRunSetting.m29923a(OpenWeRunSetting.this);
                AppMethodBeat.m2505o(130528);
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m29923a(OpenWeRunSetting openWeRunSetting) {
            AppMethodBeat.m2504i(130538);
            openWeRunSetting.aCk();
            AppMethodBeat.m2505o(130538);
        }

        public OpenWeRunSetting(C45608m c45608m, C2241c c2241c, int i, boolean z) {
            AppMethodBeat.m2504i(130531);
            C4990ab.m7416i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
            this.hwz = c45608m;
            this.hxS = c2241c;
            this.hwi = i;
            this.hyt = z;
            AppMethodBeat.m2505o(130531);
        }

        public OpenWeRunSetting(Parcel parcel) {
            AppMethodBeat.m2504i(130532);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130532);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130533);
            this.hys = ((C39858b) C1720g.m3528K(C39858b.class)).mo63057eU(C4996ah.getContext());
            if (!this.hyt || this.hys) {
                aCk();
                AppMethodBeat.m2505o(130533);
                return;
            }
            ((C42401a) C1720g.m3528K(C42401a.class)).mo21554a(new C192711());
            AppMethodBeat.m2505o(130533);
        }

        private void aCk() {
            AppMethodBeat.m2504i(130534);
            if (!this.hyt || this.hys) {
                this.cPT = ((C39858b) C1720g.m3528K(C39858b.class)).cvY();
                if (this.hyt && this.cPT) {
                    ((C39858b) C1720g.m3528K(C39858b.class)).cvX();
                }
            }
            aCb();
            AppMethodBeat.m2505o(130534);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130535);
            if (this.hyt && !this.hys) {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail device not support", null));
                aBW();
                AppMethodBeat.m2505o(130535);
            } else if (this.cPT) {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("ok", null));
                aBW();
                AppMethodBeat.m2505o(130535);
            } else {
                Context context = this.hxS.getContext();
                if (context == null || !(context instanceof MMActivity)) {
                    this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail", null));
                    aBW();
                    AppMethodBeat.m2505o(130535);
                    return;
                }
                C16597h c16597h = (C16597h) this.hxS.mo5937aa(C16597h.class);
                if (c16597h == null || C5046bo.isNullOrNil(c16597h.cwz)) {
                    this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail", null));
                    aBW();
                    AppMethodBeat.m2505o(130535);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("OpenWeRunSettingName", c16597h.cwz);
                ((MMActivity) context).ifE = new C192702();
                C25985d.m41453a(context, "appbrand", ".ui.AppBrandOpenWeRunSettingUI", intent, hashCode() & CdnLogic.kBizGeneric, false);
                aBW();
                AppMethodBeat.m2505o(130535);
            }
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(130536);
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hys = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.cPT = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.hyt = z2;
            AppMethodBeat.m2505o(130536);
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.m2504i(130537);
            if (this.hys) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.cPT) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.hyt) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            AppMethodBeat.m2505o(130537);
        }

        static {
            AppMethodBeat.m2504i(130539);
            AppMethodBeat.m2505o(130539);
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(130540);
        if (jSONObject != null) {
            z = jSONObject.optBoolean("checkSupport", true);
        }
        this.hyr = new OpenWeRunSetting(this, c2241c, i, z);
        this.hyr.aBV();
        AppBrandMainProcessService.m54349a(this.hyr);
        AppMethodBeat.m2505o(130540);
    }
}
