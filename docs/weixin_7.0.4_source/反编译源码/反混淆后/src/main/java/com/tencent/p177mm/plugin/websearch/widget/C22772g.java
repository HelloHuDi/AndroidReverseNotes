package com.tencent.p177mm.plugin.websearch.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.C26438t;
import com.tencent.p177mm.modelappbrand.C42203y;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.picker.C24105f;
import com.tencent.p177mm.p612ui.widget.picker.C40908b;
import com.tencent.p177mm.p612ui.widget.picker.C40908b.C40907a;
import com.tencent.p177mm.p612ui.widget.picker.C46701a;
import com.tencent.p177mm.p612ui.widget.picker.C46701a.C5669a;
import com.tencent.p177mm.p612ui.widget.picker.C46702c;
import com.tencent.p177mm.p612ui.widget.picker.C46702c.C40910a;
import com.tencent.p177mm.p612ui.widget.picker.CustomTimePicker;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.view.C31128d;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.websearch.widget.g */
public final class C22772g extends C42203y {
    Context context;

    /* renamed from: com.tencent.mm.plugin.websearch.widget.g$2 */
    class C227712 implements C40910a {
        final /* synthetic */ C26438t uds;
        final /* synthetic */ C46702c udu;
        final /* synthetic */ Bundle udv;

        C227712(C46702c c46702c, Bundle bundle, C26438t c26438t) {
            this.udu = c46702c;
            this.udv = bundle;
            this.uds = c26438t;
        }

        /* renamed from: b */
        public final void mo38363b(boolean z, Object obj) {
            AppMethodBeat.m2504i(91452);
            C46702c c46702c = this.udu;
            if (c46702c.zaW != null) {
                c46702c.zaW.dismiss();
            }
            this.udv.putString("value", z ? obj.toString() : "");
            if (this.uds != null) {
                this.uds.mo5959b(z, "", this.udv);
            }
            AppMethodBeat.m2505o(91452);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.g$3 */
    class C227733 implements C5669a {
        final /* synthetic */ C46701a tGk;
        final /* synthetic */ C26438t uds;
        final /* synthetic */ Bundle udv;
        final /* synthetic */ SimpleDateFormat udw;

        C227733(C46701a c46701a, SimpleDateFormat simpleDateFormat, Bundle bundle, C26438t c26438t) {
            this.tGk = c46701a;
            this.udw = simpleDateFormat;
            this.udv = bundle;
            this.uds = c26438t;
        }

        /* renamed from: b */
        public final void mo11538b(boolean z, int i, int i2, int i3) {
            AppMethodBeat.m2504i(91453);
            this.tGk.hide();
            String format = this.udw.format(new Date(i - 1900, i2 - 1, i3));
            Bundle bundle = this.udv;
            String str = "value";
            if (!z) {
                format = "";
            }
            bundle.putString(str, format);
            if (this.uds != null) {
                this.uds.mo5959b(z, "", this.udv);
            }
            AppMethodBeat.m2505o(91453);
        }
    }

    public C22772g(Context context) {
        this.context = context;
    }

    /* renamed from: a */
    public final void mo38364a(final String str, final String str2, final C26438t c26438t) {
        AppMethodBeat.m2504i(91455);
        C5004al.m7441d(new Runnable() {
            /* JADX WARNING: Unknown top exception splitter block from list: {B:70:0x01c0=Splitter:B:70:0x01c0, B:31:0x00c2=Splitter:B:31:0x00c2, B:72:0x01c4=Splitter:B:72:0x01c4, B:34:0x00c7=Splitter:B:34:0x00c7, B:37:0x00cc=Splitter:B:37:0x00cc} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                Date date = null;
                AppMethodBeat.m2504i(91451);
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
                    C26438t c26438t;
                    switch (i) {
                        case 0:
                            C22772g.m34556a(C22772g.this, jSONObject, bundle, c26438t);
                            AppMethodBeat.m2505o(91451);
                            return;
                        case 1:
                            Date parse;
                            Date parse2;
                            Date parse3;
                            C22772g c22772g = C22772g.this;
                            c26438t = c26438t;
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
                                C4990ab.printErrStackTrace("WxaShowPickerListenerImpl", e, "", new Object[0]);
                                parse = date;
                            }
                            try {
                                parse2 = simpleDateFormat.parse(optString3);
                            } catch (ParseException e2) {
                                C4990ab.printErrStackTrace("WxaShowPickerListenerImpl", e2, "", new Object[0]);
                                parse2 = date;
                            }
                            try {
                                parse3 = simpleDateFormat.parse(optString4);
                            } catch (ParseException e22) {
                                C4990ab.printErrStackTrace("WxaShowPickerListenerImpl", e22, "", new Object[0]);
                                parse3 = date;
                            }
                            C46701a c46701a = new C46701a(c22772g.context);
                            c46701a.zSj = new C227733(c46701a, simpleDateFormat, bundle, c26438t);
                            if (parse != null) {
                                c46701a.mo75044aB(parse.getYear() + 1900, parse.getMonth() + 1, parse.getDate());
                            }
                            if (parse2 != null) {
                                c46701a.mo75045aC(parse2.getYear() + 1900, parse2.getMonth() + 1, parse2.getDate());
                            }
                            if (parse3 != null) {
                                c46701a.mo75046aD(parse3.getYear() + 1900, parse3.getMonth() + 1, parse3.getDate());
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                if (optString5.equals("year")) {
                                    c46701a.mo75047al(false, false);
                                } else if (optString5.equals("month")) {
                                    c46701a.mo75047al(true, false);
                                }
                                if (optString5.equals("day")) {
                                    c46701a.mo75047al(true, true);
                                }
                            }
                            c46701a.show();
                            AppMethodBeat.m2505o(91451);
                            return;
                        case 2:
                            Date parse4;
                            Date parse5;
                            int minutes;
                            C22772g c22772g2 = C22772g.this;
                            c26438t = c26438t;
                            C46702c c46702c = new C46702c(c22772g2.context);
                            str = jSONObject.optString("value");
                            String optString6 = jSONObject.optString("start");
                            String optString7 = jSONObject.optString("end");
                            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm");
                            try {
                                parse4 = simpleDateFormat2.parse(str);
                            } catch (ParseException e3) {
                                C4990ab.printErrStackTrace("WxaShowPickerListenerImpl", e3, "", new Object[0]);
                                parse4 = date;
                            }
                            try {
                                parse5 = simpleDateFormat2.parse(optString6);
                            } catch (ParseException e32) {
                                C4990ab.printErrStackTrace("WxaShowPickerListenerImpl", e32, "", new Object[0]);
                                parse5 = date;
                            }
                            try {
                                date = simpleDateFormat2.parse(optString7);
                            } catch (ParseException e4) {
                                C4990ab.printErrStackTrace("WxaShowPickerListenerImpl", e4, "", new Object[0]);
                            }
                            if (parse4 != null) {
                                int hours = parse4.getHours();
                                minutes = parse4.getMinutes();
                                if (c46702c.zSs != null) {
                                    CustomTimePicker customTimePicker = c46702c.zSs;
                                    if (C24105f.m37076qS(hours) && C24105f.m37075qR(minutes)) {
                                        customTimePicker.setCurrentHour(Integer.valueOf(hours));
                                        customTimePicker.setCurrentMinute(Integer.valueOf(minutes));
                                    }
                                    customTimePicker.aRM();
                                }
                            }
                            if (parse5 != null) {
                                minutes = parse5.getHours();
                                i = parse5.getMinutes();
                                if (c46702c.zSs != null) {
                                    CustomTimePicker customTimePicker2 = c46702c.zSs;
                                    customTimePicker2.hUy = minutes;
                                    customTimePicker2.hUz = i;
                                    if (C24105f.m37076qS(customTimePicker2.hUy) && customTimePicker2.jkY != null) {
                                        customTimePicker2.jkY.setMinValue(customTimePicker2.hUy);
                                    }
                                }
                            }
                            if (date != null) {
                                i = date.getHours();
                                int minutes2 = date.getMinutes();
                                if (c46702c.zSs != null) {
                                    CustomTimePicker customTimePicker3 = c46702c.zSs;
                                    customTimePicker3.hUA = i;
                                    customTimePicker3.hUB = minutes2;
                                    if (C24105f.m37076qS(customTimePicker3.hUA) && customTimePicker3.jkY != null) {
                                        customTimePicker3.jkY.setMaxValue(customTimePicker3.hUA);
                                    }
                                }
                            }
                            c46702c.zSt = new C227712(c46702c, bundle, c26438t);
                            if (c46702c.zaW != null) {
                                if (c46702c.zSs != null) {
                                    c46702c.zSs.aRM();
                                }
                                c46702c.zaW.show();
                            }
                            AppMethodBeat.m2505o(91451);
                            return;
                        default:
                            C4990ab.m7417i("WxaShowPickerListenerImpl", "unknown mode %s", str);
                            AppMethodBeat.m2505o(91451);
                            return;
                    }
                } catch (JSONException e5) {
                    C4990ab.printErrStackTrace("WxaShowPickerListenerImpl", e5, "", new Object[0]);
                    AppMethodBeat.m2505o(91451);
                }
                C4990ab.printErrStackTrace("WxaShowPickerListenerImpl", e5, "", new Object[0]);
                AppMethodBeat.m2505o(91451);
            }
        });
        AppMethodBeat.m2505o(91455);
    }

    /* renamed from: a */
    static /* synthetic */ void m34556a(C22772g c22772g, JSONObject jSONObject, final Bundle bundle, final C26438t c26438t) {
        int i = 0;
        AppMethodBeat.m2504i(91456);
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
        final C40908b c40908b = new C40908b(c22772g.context, arrayList);
        c40908b.mo64522Qq(i);
        c40908b.zSq = new C40907a() {
            /* renamed from: d */
            public final void mo7219d(boolean z, Object obj) {
                AppMethodBeat.m2504i(91454);
                c40908b.hide();
                bundle.putString("value", z ? c40908b.dLl() : "-1");
                if (c26438t != null) {
                    c26438t.mo5959b(z, "", bundle);
                }
                AppMethodBeat.m2505o(91454);
            }
        };
        c40908b.mo64521Qp(C1338a.fromDPToPix(c22772g.context, C31128d.MIC_PTU_YOUJIALI));
        c40908b.show();
        AppMethodBeat.m2505o(91456);
    }
}
