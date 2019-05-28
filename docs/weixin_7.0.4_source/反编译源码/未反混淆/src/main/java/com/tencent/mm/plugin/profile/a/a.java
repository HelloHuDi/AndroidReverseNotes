package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.se;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: com.tencent.mm.plugin.profile.a.a$2 */
    public static class AnonymousClass2 extends KeyValuePreference {
        final /* synthetic */ b pkz;

        public AnonymousClass2(Context context, b bVar) {
            this.pkz = bVar;
            super(context);
        }

        public final void onBindView(View view) {
            AppMethodBeat.i(23251);
            super.onBindView(view);
            if (this.pnu != null) {
                int i = (this.pkz.action == 2 || this.pkz.action == 3) ? 1 : 0;
                if (i != 0) {
                    this.pnu.setTextColor(ah.getResources().getColorStateList(R.color.a86));
                }
            }
            if (!(this.yCq == null || TextUtils.isEmpty(this.pkz.cIY))) {
                this.yCq.setVisibility(0);
                o.ahp().a(this.pkz.cIY, this.yCq);
            }
            AppMethodBeat.o(23251);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.a$3 */
    public static class AnonymousClass3 implements Preference.b {
        final /* synthetic */ ad emj;
        final /* synthetic */ com.tencent.mm.openim.a.c.a pkA;
        final /* synthetic */ b pkz;
        final /* synthetic */ Context val$context;

        public AnonymousClass3(b bVar, ad adVar, com.tencent.mm.openim.a.c.a aVar, Context context) {
            this.pkz = bVar;
            this.emj = adVar;
            this.pkA = aVar;
            this.val$context = context;
        }

        public final boolean car() {
            AppMethodBeat.i(23252);
            Object obj = this.pkz.geX;
            try {
                obj = new JSONObject(this.pkz.geX).optString("tel");
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", e, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
            }
            h.pYm.e(15319, this.emj.field_openImAppid, Integer.valueOf(this.pkz.action), this.pkA.title);
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(obj))));
            intent.setFlags(268435456);
            this.val$context.startActivity(intent);
            AppMethodBeat.o(23252);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.a$4 */
    public static class AnonymousClass4 implements Preference.b {
        final /* synthetic */ ad emj;
        final /* synthetic */ com.tencent.mm.openim.a.c.a pkA;
        final /* synthetic */ b pkz;
        final /* synthetic */ Context val$context;

        public AnonymousClass4(b bVar, ad adVar, com.tencent.mm.openim.a.c.a aVar, Context context) {
            this.pkz = bVar;
            this.emj = adVar;
            this.pkA = aVar;
            this.val$context = context;
        }

        public final boolean car() {
            AppMethodBeat.i(23253);
            Object obj = "";
            try {
                obj = new JSONObject(this.pkz.geX).optString("mailto");
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", e, "loadProfile", new Object[0]);
            }
            h.pYm.e(15319, this.emj.field_openImAppid, Integer.valueOf(this.pkz.action), this.pkA.title);
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse(WebView.SCHEME_MAILTO.concat(String.valueOf(obj))));
            this.val$context.startActivity(intent);
            AppMethodBeat.o(23253);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.a$6 */
    public static class AnonymousClass6 implements Preference.b {
        final /* synthetic */ ad emj;
        final /* synthetic */ com.tencent.mm.openim.a.c.a pkA;
        final /* synthetic */ b pkz;

        public AnonymousClass6(b bVar, ad adVar, com.tencent.mm.openim.a.c.a aVar) {
            this.pkz = bVar;
            this.emj = adVar;
            this.pkA = aVar;
        }

        public final boolean car() {
            AppMethodBeat.i(23255);
            try {
                JSONObject jSONObject = new JSONObject(this.pkz.geX);
                String optString = jSONObject.optString("name");
                String optString2 = jSONObject.optString("pagepath");
                se seVar = new se();
                seVar.cOf.userName = optString;
                seVar.cOf.cOh = bo.bc(optString2, "");
                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                h.pYm.e(15319, this.emj.field_openImAppid, Integer.valueOf(this.pkz.action), this.pkA.title);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", e, "loadProfile", new Object[0]);
            }
            AppMethodBeat.o(23255);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.a$5 */
    public static class AnonymousClass5 implements Preference.b {
        final /* synthetic */ ad emj;
        final /* synthetic */ com.tencent.mm.openim.a.c.a pkA;
        final /* synthetic */ b pkz;

        public AnonymousClass5(b bVar, ad adVar, com.tencent.mm.openim.a.c.a aVar) {
            this.pkz = bVar;
            this.emj = adVar;
            this.pkA = aVar;
        }

        public final boolean car() {
            AppMethodBeat.i(23254);
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            String str = "";
            try {
                str = new JSONObject(this.pkz.geX).optString("url");
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", e, "loadProfile", new Object[0]);
            }
            h.pYm.e(15319, this.emj.field_openImAppid, Integer.valueOf(this.pkz.action), this.pkA.title);
            intent.putExtra("geta8key_scene", 58);
            intent.putExtra("rawUrl", str);
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(23254);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.a$7 */
    public static class AnonymousClass7 implements Preference.b {
        final /* synthetic */ ad emj;
        final /* synthetic */ String pkB;
        final /* synthetic */ String val$url;

        public AnonymousClass7(String str, ad adVar, String str2) {
            this.val$url = str;
            this.emj = adVar;
            this.pkB = str2;
        }

        public final boolean car() {
            AppMethodBeat.i(23256);
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            intent.putExtra("rawUrl", this.val$url);
            intent.putExtra("geta8key_scene", 58);
            ah.getContext().startActivity(intent);
            h.pYm.e(15319, this.emj.field_openImAppid, Integer.valueOf(6), this.pkB);
            AppMethodBeat.o(23256);
            return true;
        }
    }
}
