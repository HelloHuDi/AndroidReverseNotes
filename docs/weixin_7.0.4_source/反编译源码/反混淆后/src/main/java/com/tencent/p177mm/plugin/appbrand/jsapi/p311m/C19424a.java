package com.tencent.p177mm.plugin.appbrand.jsapi.p311m;

import android.widget.NumberPicker;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.picker.AppBrandDatePicker;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C33642d.C33643a;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C36743a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.a */
final class C19424a extends C27024d {
    volatile C19426a hTW;
    volatile Long hTX = null;
    volatile Long hTY = null;
    volatile int hTZ = -1;
    volatile int hUa = -1;
    volatile int hUb = -1;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.a$1 */
    class C104581 implements Runnable {
        C104581() {
        }

        public final void run() {
            boolean z = true;
            int i = 0;
            AppMethodBeat.m2504i(126336);
            C19424a c19424a = C19424a.this;
            AppBrandDatePicker appBrandDatePicker = (AppBrandDatePicker) c19424a.mo54197an(AppBrandDatePicker.class);
            if (appBrandDatePicker == null) {
                c19424a.mo44711l("fail cant init view", null);
                AppMethodBeat.m2505o(126336);
                return;
            }
            boolean z2;
            C36743a c36743a = c19424a.jks;
            c36743a.setOnResultListener(new C194252());
            if (c19424a.hTX != null) {
                appBrandDatePicker.setMinDate(c19424a.hTX.longValue());
            }
            if (c19424a.hTY != null) {
                appBrandDatePicker.setMaxDate(c19424a.hTY.longValue());
            }
            appBrandDatePicker.mo28325a(c19424a.hTZ, c19424a.hUa, c19424a.hUb, null);
            boolean z3 = c19424a.hTW.ordinal() >= C19426a.YEAR.ordinal();
            if (c19424a.hTW.ordinal() >= C19426a.MONTH.ordinal()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (c19424a.hTW.ordinal() < C19426a.DAY.ordinal()) {
                z = false;
            }
            appBrandDatePicker.jqq = z3;
            appBrandDatePicker.jku = z2;
            appBrandDatePicker.jkv = z;
            if (appBrandDatePicker.jkw != null) {
                appBrandDatePicker.jkw.setEnabled(z3);
                appBrandDatePicker.jkw.setVisibility(z3 ? 0 : 8);
            }
            if (appBrandDatePicker.jkx != null) {
                int i2;
                appBrandDatePicker.jkx.setEnabled(z2);
                NumberPicker numberPicker = appBrandDatePicker.jkx;
                if (z2) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                numberPicker.setVisibility(i2);
            }
            if (appBrandDatePicker.jky != null) {
                appBrandDatePicker.jky.setEnabled(z);
                NumberPicker numberPicker2 = appBrandDatePicker.jky;
                if (!z) {
                    i = 8;
                }
                numberPicker2.setVisibility(i);
            }
            c36743a.show();
            AppMethodBeat.m2505o(126336);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.a$2 */
    class C194252 implements C33643a<String> {
        C194252() {
        }

        /* renamed from: b */
        public final /* synthetic */ void mo6189b(boolean z, Object obj) {
            AppMethodBeat.m2504i(126337);
            String str = (String) obj;
            C19424a c19424a = C19424a.this;
            if (c19424a.jks != null) {
                if (!z) {
                    c19424a.mo44711l("cancel", null);
                }
                if (C5046bo.isNullOrNil(str)) {
                    c19424a.mo44711l("fail", null);
                } else {
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("value", str);
                    c19424a.mo44711l("ok", hashMap);
                }
                c19424a.jks.hide();
            }
            AppMethodBeat.m2505o(126337);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.a$a */
    enum C19426a {
        YEAR(new SimpleDateFormat("yyyy", Locale.US)),
        MONTH(new SimpleDateFormat("yyyy-MM", Locale.US)),
        DAY(new SimpleDateFormat("yyyy-MM-dd", Locale.US));
        
        final DateFormat hUg;

        static {
            AppMethodBeat.m2505o(126342);
        }

        private C19426a(DateFormat dateFormat) {
            this.hUg = dateFormat;
        }

        /* JADX WARNING: Missing block: B:6:0x0035, code skipped:
            if (r2.equals("year") != false) goto L_0x0025;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: BJ */
        static C19426a m30097BJ(String str) {
            int i = 0;
            AppMethodBeat.m2504i(126340);
            String toLowerCase = str.substring(0, Math.max(0, Math.min(str.length(), 5))).toLowerCase();
            switch (toLowerCase.hashCode()) {
                case 99228:
                    if (toLowerCase.equals("day")) {
                        i = 2;
                        break;
                    }
                case 3704893:
                    break;
                case 104080000:
                    if (toLowerCase.equals("month")) {
                        i = 1;
                        break;
                    }
                default:
                    i = -1;
                    break;
            }
            C19426a c19426a;
            switch (i) {
                case 0:
                    c19426a = YEAR;
                    AppMethodBeat.m2505o(126340);
                    return c19426a;
                case 1:
                    c19426a = MONTH;
                    AppMethodBeat.m2505o(126340);
                    return c19426a;
                case 2:
                    c19426a = DAY;
                    AppMethodBeat.m2505o(126340);
                    return c19426a;
                default:
                    c19426a = MONTH;
                    AppMethodBeat.m2505o(126340);
                    return c19426a;
            }
        }

        /* Access modifiers changed, original: final */
        public final Date parse(String str) {
            AppMethodBeat.m2504i(126341);
            try {
                Date parse = this.hUg.parse(str);
                AppMethodBeat.m2505o(126341);
                return parse;
            } catch (Exception e) {
                AppMethodBeat.m2505o(126341);
                return null;
            }
        }
    }

    C19424a() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: C */
    public final void mo21974C(JSONObject jSONObject) {
        Date parse;
        Date parse2;
        Calendar instance;
        AppMethodBeat.m2504i(126343);
        this.hTW = C19426a.m30097BJ(jSONObject.optString(GraphRequest.FIELDS_PARAM));
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            parse = this.hTW.parse(optJSONObject.optString("start", ""));
            parse2 = this.hTW.parse(optJSONObject.optString("end", ""));
            if (parse != null) {
                this.hTX = Long.valueOf(parse.getTime());
            }
            if (parse2 != null) {
                this.hTY = Long.valueOf(parse2.getTime());
            }
        }
        if (this.hTX == null) {
            instance = Calendar.getInstance(C4988aa.xyO);
            instance.set(1900, 0, 1);
            this.hTX = Long.valueOf(instance.getTimeInMillis());
        }
        if (this.hTY == null) {
            instance = Calendar.getInstance(C4988aa.xyO);
            instance.set(2100, 11, 31);
            this.hTY = Long.valueOf(instance.getTimeInMillis());
        }
        parse2 = this.hTW.parse(jSONObject.optString("current", ""));
        if (parse2 == null) {
            Date date = new Date(System.currentTimeMillis());
            parse2 = new Date(this.hTY.longValue());
            parse = new Date(this.hTX.longValue());
            if (!date.after(parse2)) {
                if (date.before(parse)) {
                    parse2 = parse;
                } else {
                    parse2 = date;
                }
            }
        }
        this.hTZ = parse2.getYear() + 1900;
        this.hUa = parse2.getMonth() + 1;
        this.hUb = parse2.getDate();
        C5004al.m7441d(new C104581());
        AppMethodBeat.m2505o(126343);
    }
}
