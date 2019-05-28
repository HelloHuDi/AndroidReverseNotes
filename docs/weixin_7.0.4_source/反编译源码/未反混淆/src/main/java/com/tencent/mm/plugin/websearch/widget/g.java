package com.tencent.mm.plugin.websearch.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.y;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.widget.picker.CustomTimePicker;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.ui.widget.picker.f;
import com.tencent.view.d;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g extends y {
    Context context;

    /* renamed from: com.tencent.mm.plugin.websearch.widget.g$2 */
    class AnonymousClass2 implements a {
        final /* synthetic */ t uds;
        final /* synthetic */ c udu;
        final /* synthetic */ Bundle udv;

        AnonymousClass2(c cVar, Bundle bundle, t tVar) {
            this.udu = cVar;
            this.udv = bundle;
            this.uds = tVar;
        }

        public final void b(boolean z, Object obj) {
            AppMethodBeat.i(91452);
            c cVar = this.udu;
            if (cVar.zaW != null) {
                cVar.zaW.dismiss();
            }
            this.udv.putString("value", z ? obj.toString() : "");
            if (this.uds != null) {
                this.uds.b(z, "", this.udv);
            }
            AppMethodBeat.o(91452);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.g$3 */
    class AnonymousClass3 implements com.tencent.mm.ui.widget.picker.a.a {
        final /* synthetic */ com.tencent.mm.ui.widget.picker.a tGk;
        final /* synthetic */ t uds;
        final /* synthetic */ Bundle udv;
        final /* synthetic */ SimpleDateFormat udw;

        AnonymousClass3(com.tencent.mm.ui.widget.picker.a aVar, SimpleDateFormat simpleDateFormat, Bundle bundle, t tVar) {
            this.tGk = aVar;
            this.udw = simpleDateFormat;
            this.udv = bundle;
            this.uds = tVar;
        }

        public final void b(boolean z, int i, int i2, int i3) {
            AppMethodBeat.i(91453);
            this.tGk.hide();
            String format = this.udw.format(new Date(i - 1900, i2 - 1, i3));
            Bundle bundle = this.udv;
            String str = "value";
            if (!z) {
                format = "";
            }
            bundle.putString(str, format);
            if (this.uds != null) {
                this.uds.b(z, "", this.udv);
            }
            AppMethodBeat.o(91453);
        }
    }

    public g(Context context) {
        this.context = context;
    }

    public final void a(final String str, final String str2, final t tVar) {
        AppMethodBeat.i(91455);
        al.d(new Runnable() {
            /* JADX WARNING: Unknown top exception splitter block from list: {B:70:0x01c0=Splitter:B:70:0x01c0, B:31:0x00c2=Splitter:B:31:0x00c2, B:72:0x01c4=Splitter:B:72:0x01c4, B:34:0x00c7=Splitter:B:34:0x00c7, B:37:0x00cc=Splitter:B:37:0x00cc} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                Date date = null;
                AppMethodBeat.i(91451);
                try {
                    String optString;
                    JSONObject jSONObject = new JSONObject(str2);
                    Bundle bundle = new Bundle();
                    String str = str;
                    if (str.equals(FFmpegMetadataRetriever.METADATA_KEY_DATE)) {
                        optString = jSONObject.optString("mode");
                    } else {
                        optString = str;
                    }
                    int i = -1;
                    switch (optString.hashCode()) {
                        case 3076014:
                            if (optString.equals(FFmpegMetadataRetriever.METADATA_KEY_DATE)) {
                                i = 1;
                            }
                        case 3560141:
                            if (optString.equals("time")) {
                                i = 2;
                            }
                        case 1191572447:
                            if (optString.equals("selector")) {
                                i = 0;
                            }
                    }
                    t tVar;
                    switch (i) {
                        case 0:
                            g.a(g.this, jSONObject, bundle, tVar);
                            AppMethodBeat.o(91451);
                            return;
                        case 1:
                            Date parse;
                            Date parse2;
                            Date parse3;
                            g gVar = g.this;
                            tVar = tVar;
                            String optString2 = jSONObject.optString("value");
                            String optString3 = jSONObject.optString("start");
                            String optString4 = jSONObject.optString("end");
                            String optString5 = jSONObject.optString(GraphRequest.FIELDS_PARAM);
                            String str2 = "yyyy-MM-dd";
                            if ("month".equals(optString5)) {
                                str2 = "yyyy-MM";
                            } else if ("year".equals(optString5)) {
                                str2 = "yyyy";
                            }
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
                            try {
                                parse = simpleDateFormat.parse(optString2);
                            } catch (ParseException e) {
                                ab.printErrStackTrace("WxaShowPickerListenerImpl", e, "", new Object[0]);
                                parse = date;
                            }
                            try {
                                parse2 = simpleDateFormat.parse(optString3);
                            } catch (ParseException e2) {
                                ab.printErrStackTrace("WxaShowPickerListenerImpl", e2, "", new Object[0]);
                                parse2 = date;
                            }
                            try {
                                parse3 = simpleDateFormat.parse(optString4);
                            } catch (ParseException e22) {
                                ab.printErrStackTrace("WxaShowPickerListenerImpl", e22, "", new Object[0]);
                                parse3 = date;
                            }
                            com.tencent.mm.ui.widget.picker.a aVar = new com.tencent.mm.ui.widget.picker.a(gVar.context);
                            aVar.zSj = new AnonymousClass3(aVar, simpleDateFormat, bundle, tVar);
                            if (parse != null) {
                                aVar.aB(parse.getYear() + 1900, parse.getMonth() + 1, parse.getDate());
                            }
                            if (parse2 != null) {
                                aVar.aC(parse2.getYear() + 1900, parse2.getMonth() + 1, parse2.getDate());
                            }
                            if (parse3 != null) {
                                aVar.aD(parse3.getYear() + 1900, parse3.getMonth() + 1, parse3.getDate());
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                if (optString5.equals("year")) {
                                    aVar.al(false, false);
                                } else if (optString5.equals("month")) {
                                    aVar.al(true, false);
                                }
                                if (optString5.equals("day")) {
                                    aVar.al(true, true);
                                }
                            }
                            aVar.show();
                            AppMethodBeat.o(91451);
                            return;
                        case 2:
                            Date parse4;
                            Date parse5;
                            int minutes;
                            g gVar2 = g.this;
                            tVar = tVar;
                            c cVar = new c(gVar2.context);
                            str = jSONObject.optString("value");
                            String optString6 = jSONObject.optString("start");
                            String optString7 = jSONObject.optString("end");
                            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm");
                            try {
                                parse4 = simpleDateFormat2.parse(str);
                            } catch (ParseException e3) {
                                ab.printErrStackTrace("WxaShowPickerListenerImpl", e3, "", new Object[0]);
                                parse4 = date;
                            }
                            try {
                                parse5 = simpleDateFormat2.parse(optString6);
                            } catch (ParseException e32) {
                                ab.printErrStackTrace("WxaShowPickerListenerImpl", e32, "", new Object[0]);
                                parse5 = date;
                            }
                            try {
                                date = simpleDateFormat2.parse(optString7);
                            } catch (ParseException e4) {
                                ab.printErrStackTrace("WxaShowPickerListenerImpl", e4, "", new Object[0]);
                            }
                            if (parse4 != null) {
                                int hours = parse4.getHours();
                                minutes = parse4.getMinutes();
                                if (cVar.zSs != null) {
                                    CustomTimePicker customTimePicker = cVar.zSs;
                                    if (f.qS(hours) && f.qR(minutes)) {
                                        customTimePicker.setCurrentHour(Integer.valueOf(hours));
                                        customTimePicker.setCurrentMinute(Integer.valueOf(minutes));
                                    }
                                    customTimePicker.aRM();
                                }
                            }
                            if (parse5 != null) {
                                minutes = parse5.getHours();
                                i = parse5.getMinutes();
                                if (cVar.zSs != null) {
                                    CustomTimePicker customTimePicker2 = cVar.zSs;
                                    customTimePicker2.hUy = minutes;
                                    customTimePicker2.hUz = i;
                                    if (f.qS(customTimePicker2.hUy) && customTimePicker2.jkY != null) {
                                        customTimePicker2.jkY.setMinValue(customTimePicker2.hUy);
                                    }
                                }
                            }
                            if (date != null) {
                                i = date.getHours();
                                int minutes2 = date.getMinutes();
                                if (cVar.zSs != null) {
                                    CustomTimePicker customTimePicker3 = cVar.zSs;
                                    customTimePicker3.hUA = i;
                                    customTimePicker3.hUB = minutes2;
                                    if (f.qS(customTimePicker3.hUA) && customTimePicker3.jkY != null) {
                                        customTimePicker3.jkY.setMaxValue(customTimePicker3.hUA);
                                    }
                                }
                            }
                            cVar.zSt = new AnonymousClass2(cVar, bundle, tVar);
                            if (cVar.zaW != null) {
                                if (cVar.zSs != null) {
                                    cVar.zSs.aRM();
                                }
                                cVar.zaW.show();
                            }
                            AppMethodBeat.o(91451);
                            return;
                        default:
                            ab.i("WxaShowPickerListenerImpl", "unknown mode %s", str);
                            AppMethodBeat.o(91451);
                            return;
                    }
                } catch (JSONException e5) {
                    ab.printErrStackTrace("WxaShowPickerListenerImpl", e5, "", new Object[0]);
                    AppMethodBeat.o(91451);
                }
                ab.printErrStackTrace("WxaShowPickerListenerImpl", e5, "", new Object[0]);
                AppMethodBeat.o(91451);
            }
        });
        AppMethodBeat.o(91455);
    }

    static /* synthetic */ void a(g gVar, JSONObject jSONObject, final Bundle bundle, final t tVar) {
        int i = 0;
        AppMethodBeat.i(91456);
        ArrayList arrayList = new ArrayList();
        String optString = jSONObject.optString("rangeKey");
        if (TextUtils.isEmpty(optString)) {
            JSONArray optJSONArray = jSONObject.optJSONArray("range");
            while (i < optJSONArray.length()) {
                arrayList.add(optJSONArray.getString(i));
                i++;
            }
        } else {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("range");
            while (i < optJSONArray2.length()) {
                arrayList.add(optJSONArray2.getJSONObject(i).optString(optString));
                i++;
            }
        }
        i = jSONObject.optInt("value");
        final b bVar = new b(gVar.context, arrayList);
        bVar.Qq(i);
        bVar.zSq = new b.a() {
            public final void d(boolean z, Object obj) {
                AppMethodBeat.i(91454);
                bVar.hide();
                bundle.putString("value", z ? bVar.dLl() : "-1");
                if (tVar != null) {
                    tVar.b(z, "", bundle);
                }
                AppMethodBeat.o(91454);
            }
        };
        bVar.Qp(com.tencent.mm.bz.a.fromDPToPix(gVar.context, d.MIC_PTU_YOUJIALI));
        bVar.show();
        AppMethodBeat.o(91456);
    }
}
