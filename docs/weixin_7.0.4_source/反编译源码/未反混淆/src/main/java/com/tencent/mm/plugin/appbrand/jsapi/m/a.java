package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.widget.NumberPicker;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

final class a extends d {
    volatile a hTW;
    volatile Long hTX = null;
    volatile Long hTY = null;
    volatile int hTZ = -1;
    volatile int hUa = -1;
    volatile int hUb = -1;

    enum a {
        YEAR(new SimpleDateFormat("yyyy", Locale.US)),
        MONTH(new SimpleDateFormat("yyyy-MM", Locale.US)),
        DAY(new SimpleDateFormat("yyyy-MM-dd", Locale.US));
        
        final DateFormat hUg;

        static {
            AppMethodBeat.o(126342);
        }

        private a(DateFormat dateFormat) {
            this.hUg = dateFormat;
        }

        /* JADX WARNING: Missing block: B:6:0x0035, code skipped:
            if (r2.equals("year") != false) goto L_0x0025;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static a BJ(String str) {
            int i = 0;
            AppMethodBeat.i(126340);
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
            a aVar;
            switch (i) {
                case 0:
                    aVar = YEAR;
                    AppMethodBeat.o(126340);
                    return aVar;
                case 1:
                    aVar = MONTH;
                    AppMethodBeat.o(126340);
                    return aVar;
                case 2:
                    aVar = DAY;
                    AppMethodBeat.o(126340);
                    return aVar;
                default:
                    aVar = MONTH;
                    AppMethodBeat.o(126340);
                    return aVar;
            }
        }

        /* Access modifiers changed, original: final */
        public final Date parse(String str) {
            AppMethodBeat.i(126341);
            try {
                Date parse = this.hUg.parse(str);
                AppMethodBeat.o(126341);
                return parse;
            } catch (Exception e) {
                AppMethodBeat.o(126341);
                return null;
            }
        }
    }

    a() {
    }

    /* Access modifiers changed, original: final */
    public final void C(JSONObject jSONObject) {
        Date parse;
        Date parse2;
        Calendar instance;
        AppMethodBeat.i(126343);
        this.hTW = a.BJ(jSONObject.optString(GraphRequest.FIELDS_PARAM));
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
            instance = Calendar.getInstance(aa.xyO);
            instance.set(1900, 0, 1);
            this.hTX = Long.valueOf(instance.getTimeInMillis());
        }
        if (this.hTY == null) {
            instance = Calendar.getInstance(aa.xyO);
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
        al.d(new Runnable() {
            public final void run() {
                boolean z = true;
                int i = 0;
                AppMethodBeat.i(126336);
                a aVar = a.this;
                AppBrandDatePicker appBrandDatePicker = (AppBrandDatePicker) aVar.an(AppBrandDatePicker.class);
                if (appBrandDatePicker == null) {
                    aVar.l("fail cant init view", null);
                    AppMethodBeat.o(126336);
                    return;
                }
                boolean z2;
                com.tencent.mm.plugin.appbrand.widget.picker.a aVar2 = aVar.jks;
                aVar2.setOnResultListener(new com.tencent.mm.plugin.appbrand.widget.picker.d.a<String>() {
                    public final /* synthetic */ void b(boolean z, Object obj) {
                        AppMethodBeat.i(126337);
                        String str = (String) obj;
                        a aVar = a.this;
                        if (aVar.jks != null) {
                            if (!z) {
                                aVar.l("cancel", null);
                            }
                            if (bo.isNullOrNil(str)) {
                                aVar.l("fail", null);
                            } else {
                                HashMap hashMap = new HashMap(1);
                                hashMap.put("value", str);
                                aVar.l("ok", hashMap);
                            }
                            aVar.jks.hide();
                        }
                        AppMethodBeat.o(126337);
                    }
                });
                if (aVar.hTX != null) {
                    appBrandDatePicker.setMinDate(aVar.hTX.longValue());
                }
                if (aVar.hTY != null) {
                    appBrandDatePicker.setMaxDate(aVar.hTY.longValue());
                }
                appBrandDatePicker.a(aVar.hTZ, aVar.hUa, aVar.hUb, null);
                boolean z3 = aVar.hTW.ordinal() >= a.YEAR.ordinal();
                if (aVar.hTW.ordinal() >= a.MONTH.ordinal()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (aVar.hTW.ordinal() < a.DAY.ordinal()) {
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
                aVar2.show();
                AppMethodBeat.o(126336);
            }
        });
        AppMethodBeat.o(126343);
    }
}
