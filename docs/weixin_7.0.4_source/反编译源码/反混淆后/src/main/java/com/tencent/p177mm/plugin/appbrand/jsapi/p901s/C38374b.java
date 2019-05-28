package com.tencent.p177mm.plugin.appbrand.jsapi.p901s;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19163a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C33139b;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.widget.C42702d;
import com.tencent.p177mm.plugin.appbrand.widget.p915c.C16699a;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s.b */
public final class C38374b {
    /* renamed from: a */
    public static void m64946a(C33303e c33303e, final C16699a c16699a, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126630);
        if (c16699a == null || jSONObject == null) {
            AppMethodBeat.m2505o(126630);
            return;
        }
        try {
            String string = jSONObject.getString("iconPath");
            if (!TextUtils.isEmpty(string)) {
                ((C19162a) c33303e.mo5936B(C19162a.class)).mo34402a(((C33139b) c33303e.mo5936B(C33139b.class)).mo22120b(c33303e, string), new C19163a() {
                    /* renamed from: Q */
                    public final void mo34404Q(final byte[] bArr) {
                        AppMethodBeat.m2504i(126629);
                        C105101 c105101 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(126628);
                                if (bArr == null || bArr.length == 0) {
                                    AppMethodBeat.m2505o(126628);
                                    return;
                                }
                                int i;
                                byte[] bArr = bArr;
                                if (bArr != null && bArr.length > 0) {
                                    boolean i2;
                                    Options options = new Options();
                                    options.inJustDecodeBounds = true;
                                    BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                                    String str = options.outMimeType;
                                    C45124d.m82932v("Util", "imageType:%s", str);
                                    i2 = -1;
                                    switch (str.hashCode()) {
                                        case -879299344:
                                            if (str.equals("image/GIF")) {
                                                i2 = true;
                                                break;
                                            }
                                            break;
                                        case -879267568:
                                            if (str.equals("image/gif")) {
                                                i2 = 0;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (i2) {
                                        case 0:
                                        case 1:
                                            i2 = true;
                                            break;
                                        default:
                                            i2 = 0;
                                            break;
                                    }
                                }
                                i2 = 0;
                                if (i2 != 0) {
                                    c16699a.setImageByteArray(bArr);
                                    AppMethodBeat.m2505o(126628);
                                    return;
                                }
                                try {
                                    c16699a.setImageBitmap(C5056d.m7652bQ(bArr));
                                    AppMethodBeat.m2505o(126628);
                                } catch (Exception e) {
                                    C45124d.m82924c("Luggage.ViewAttributeHelper", "", e);
                                    AppMethodBeat.m2505o(126628);
                                }
                            }
                        };
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            c105101.run();
                            AppMethodBeat.m2505o(126629);
                            return;
                        }
                        C5004al.m7441d(c105101);
                        AppMethodBeat.m2505o(126629);
                    }
                });
            }
            AppMethodBeat.m2505o(126630);
        } catch (NullPointerException | JSONException e) {
            C45124d.printErrStackTrace("Luggage.ViewAttributeHelper", e, "attachImageViewAttribute", new Object[0]);
            AppMethodBeat.m2505o(126630);
        }
    }

    /* renamed from: a */
    public static void m64945a(TextView textView, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126631);
        if (textView == null || jSONObject == null) {
            AppMethodBeat.m2505o(126631);
            return;
        }
        String string;
        try {
            string = jSONObject.getString("color");
            if (!C5046bo.isNullOrNil(string)) {
                textView.setTextColor(C42668g.m75551Ee(string));
            }
        } catch (JSONException e) {
        }
        try {
            textView.setTextSize(0, C42668g.m75557av((float) jSONObject.getDouble("fontSize")));
        } catch (JSONException e2) {
        }
        try {
            string = jSONObject.getString("textAlign");
            if ("left".equals(string)) {
                textView.setGravity(3);
            } else if ("center".equals(string)) {
                textView.setGravity(1);
            } else if ("right".equals(string)) {
                textView.setGravity(5);
            }
        } catch (JSONException e3) {
        }
        try {
            string = jSONObject.getString("fontWeight");
            if ("bold".equals(string)) {
                textView.getPaint().setFakeBoldText(true);
            } else if ("normal".equals(string)) {
                textView.getPaint().setFakeBoldText(false);
            }
        } catch (JSONException e4) {
        }
        int a = C42668g.m75555a(jSONObject, "lineHeight", Math.round(textView.getTextSize() * 1.2f));
        if (textView instanceof C42702d) {
            ((C42702d) textView).setLineHeight(a);
        }
        try {
            string = jSONObject.getString("lineBreak");
            if ("ellipsis".equals(string)) {
                textView.setEllipsize(TruncateAt.END);
                textView.setSingleLine(true);
            } else if ("clip".equals(string)) {
                textView.setSingleLine(true);
            } else if ("break-word".equals(string)) {
                textView.setSingleLine(false);
            } else if ("break-all".equals(string)) {
                textView.setSingleLine(false);
            }
        } catch (JSONException e5) {
        }
        try {
            textView.setText(jSONObject.getString(C8741b.CONTENT));
            AppMethodBeat.m2505o(126631);
        } catch (JSONException e6) {
            AppMethodBeat.m2505o(126631);
        }
    }
}
