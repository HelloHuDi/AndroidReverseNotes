package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.sport.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class JsApiOpenWeRunSetting extends a {
    public static final int CTRL_INDEX = 228;
    public static final String NAME = "openWeRunSetting";
    private OpenWeRunSetting hyr;

    static class OpenWeRunSetting extends MainProcessTask {
        public static final Creator<OpenWeRunSetting> CREATOR = new Creator<OpenWeRunSetting>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OpenWeRunSetting[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130530);
                OpenWeRunSetting openWeRunSetting = new OpenWeRunSetting(parcel);
                AppMethodBeat.o(130530);
                return openWeRunSetting;
            }
        };
        private boolean cPT = false;
        private int hwi;
        private m hwz;
        private c hxS;
        private boolean hys = false;
        private boolean hyt;

        static /* synthetic */ void a(OpenWeRunSetting openWeRunSetting) {
            AppMethodBeat.i(130538);
            openWeRunSetting.aCk();
            AppMethodBeat.o(130538);
        }

        public OpenWeRunSetting(m mVar, c cVar, int i, boolean z) {
            AppMethodBeat.i(130531);
            ab.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
            this.hwz = mVar;
            this.hxS = cVar;
            this.hwi = i;
            this.hyt = z;
            AppMethodBeat.o(130531);
        }

        public OpenWeRunSetting(Parcel parcel) {
            AppMethodBeat.i(130532);
            g(parcel);
            AppMethodBeat.o(130532);
        }

        public final void asP() {
            AppMethodBeat.i(130533);
            this.hys = ((b) g.K(b.class)).eU(ah.getContext());
            if (!this.hyt || this.hys) {
                aCk();
                AppMethodBeat.o(130533);
                return;
            }
            ((a) g.K(a.class)).a(new a.a() {
                public final void q(boolean z, boolean z2) {
                    boolean z3;
                    AppMethodBeat.i(130528);
                    OpenWeRunSetting openWeRunSetting = OpenWeRunSetting.this;
                    if (z && z2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    openWeRunSetting.hys = z3;
                    ab.i("MicroMsg.JsApiOpenWeRunSetting", "After getUserState requestOk %b, hasStep %b", Boolean.valueOf(z), Boolean.valueOf(z2));
                    OpenWeRunSetting.a(OpenWeRunSetting.this);
                    AppMethodBeat.o(130528);
                }
            });
            AppMethodBeat.o(130533);
        }

        private void aCk() {
            AppMethodBeat.i(130534);
            if (!this.hyt || this.hys) {
                this.cPT = ((b) g.K(b.class)).cvY();
                if (this.hyt && this.cPT) {
                    ((b) g.K(b.class)).cvX();
                }
            }
            aCb();
            AppMethodBeat.o(130534);
        }

        public final void asQ() {
            AppMethodBeat.i(130535);
            if (this.hyt && !this.hys) {
                this.hxS.M(this.hwi, this.hwz.j("fail device not support", null));
                aBW();
                AppMethodBeat.o(130535);
            } else if (this.cPT) {
                this.hxS.M(this.hwi, this.hwz.j("ok", null));
                aBW();
                AppMethodBeat.o(130535);
            } else {
                Context context = this.hxS.getContext();
                if (context == null || !(context instanceof MMActivity)) {
                    this.hxS.M(this.hwi, this.hwz.j("fail", null));
                    aBW();
                    AppMethodBeat.o(130535);
                    return;
                }
                h hVar = (h) this.hxS.aa(h.class);
                if (hVar == null || bo.isNullOrNil(hVar.cwz)) {
                    this.hxS.M(this.hwi, this.hwz.j("fail", null));
                    aBW();
                    AppMethodBeat.o(130535);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("OpenWeRunSettingName", hVar.cwz);
                ((MMActivity) context).ifE = new MMActivity.a() {
                    public final void c(int i, int i2, Intent intent) {
                        AppMethodBeat.i(130529);
                        if (i != (OpenWeRunSetting.this.hashCode() & CdnLogic.kBizGeneric)) {
                            OpenWeRunSetting.this.aBW();
                            AppMethodBeat.o(130529);
                        } else if (i2 == -1) {
                            OpenWeRunSetting.this.hxS.M(OpenWeRunSetting.this.hwi, OpenWeRunSetting.this.hwz.j("ok", null));
                            OpenWeRunSetting.this.aBW();
                            AppMethodBeat.o(130529);
                        } else if (i2 == 0) {
                            OpenWeRunSetting.this.hxS.M(OpenWeRunSetting.this.hwi, OpenWeRunSetting.this.hwz.j("cancel", null));
                            OpenWeRunSetting.this.aBW();
                            AppMethodBeat.o(130529);
                        } else {
                            OpenWeRunSetting.this.hxS.M(OpenWeRunSetting.this.hwi, OpenWeRunSetting.this.hwz.j("fail", null));
                            OpenWeRunSetting.this.aBW();
                            AppMethodBeat.o(130529);
                        }
                    }
                };
                d.a(context, "appbrand", ".ui.AppBrandOpenWeRunSettingUI", intent, hashCode() & CdnLogic.kBizGeneric, false);
                aBW();
                AppMethodBeat.o(130535);
            }
        }

        public final void g(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(130536);
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
            AppMethodBeat.o(130536);
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.i(130537);
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
            AppMethodBeat.o(130537);
        }

        static {
            AppMethodBeat.i(130539);
            AppMethodBeat.o(130539);
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        boolean z = true;
        AppMethodBeat.i(130540);
        if (jSONObject != null) {
            z = jSONObject.optBoolean("checkSupport", true);
        }
        this.hyr = new OpenWeRunSetting(this, cVar, i, z);
        this.hyr.aBV();
        AppBrandMainProcessService.a(this.hyr);
        AppMethodBeat.o(130540);
    }
}
