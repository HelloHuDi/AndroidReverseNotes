package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static void a(e eVar, final a aVar, JSONObject jSONObject) {
        AppMethodBeat.i(126630);
        if (aVar == null || jSONObject == null) {
            AppMethodBeat.o(126630);
            return;
        }
        try {
            String string = jSONObject.getString("iconPath");
            if (!TextUtils.isEmpty(string)) {
                ((com.tencent.mm.plugin.appbrand.d.a) eVar.B(com.tencent.mm.plugin.appbrand.d.a.class)).a(((com.tencent.mm.plugin.appbrand.d.b) eVar.B(com.tencent.mm.plugin.appbrand.d.b.class)).b(eVar, string), new com.tencent.mm.plugin.appbrand.d.a.a() {
                    public final void Q(final byte[] bArr) {
                        AppMethodBeat.i(126629);
                        AnonymousClass1 anonymousClass1 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(126628);
                                if (bArr == null || bArr.length == 0) {
                                    AppMethodBeat.o(126628);
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
                                    d.v("Util", "imageType:%s", str);
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
                                    aVar.setImageByteArray(bArr);
                                    AppMethodBeat.o(126628);
                                    return;
                                }
                                try {
                                    aVar.setImageBitmap(com.tencent.mm.sdk.platformtools.d.bQ(bArr));
                                    AppMethodBeat.o(126628);
                                } catch (Exception e) {
                                    d.c("Luggage.ViewAttributeHelper", "", e);
                                    AppMethodBeat.o(126628);
                                }
                            }
                        };
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            anonymousClass1.run();
                            AppMethodBeat.o(126629);
                            return;
                        }
                        al.d(anonymousClass1);
                        AppMethodBeat.o(126629);
                    }
                });
            }
            AppMethodBeat.o(126630);
        } catch (NullPointerException | JSONException e) {
            d.printErrStackTrace("Luggage.ViewAttributeHelper", e, "attachImageViewAttribute", new Object[0]);
            AppMethodBeat.o(126630);
        }
    }

    public static void a(TextView textView, JSONObject jSONObject) {
        AppMethodBeat.i(126631);
        if (textView == null || jSONObject == null) {
            AppMethodBeat.o(126631);
            return;
        }
        String string;
        try {
            string = jSONObject.getString("color");
            if (!bo.isNullOrNil(string)) {
                textView.setTextColor(g.Ee(string));
            }
        } catch (JSONException e) {
        }
        try {
            textView.setTextSize(0, g.av((float) jSONObject.getDouble("fontSize")));
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
        int a = g.a(jSONObject, "lineHeight", Math.round(textView.getTextSize() * 1.2f));
        if (textView instanceof com.tencent.mm.plugin.appbrand.widget.d) {
            ((com.tencent.mm.plugin.appbrand.widget.d) textView).setLineHeight(a);
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
            textView.setText(jSONObject.getString(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT));
            AppMethodBeat.o(126631);
        } catch (JSONException e6) {
            AppMethodBeat.o(126631);
        }
    }
}
