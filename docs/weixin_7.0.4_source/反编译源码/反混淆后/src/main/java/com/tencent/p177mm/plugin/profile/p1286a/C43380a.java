package com.tencent.p177mm.plugin.profile.p1286a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.openim.p1210a.C32875c.C18734a;
import com.tencent.p177mm.openim.p1210a.C32875c.C26514b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.Preference.C23633b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.profile.a.a */
public final class C43380a {

    /* renamed from: com.tencent.mm.plugin.profile.a.a$1 */
    public static class C248031 implements C23633b {
        public final boolean car() {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.a$2 */
    public static class C250272 extends KeyValuePreference {
        final /* synthetic */ C26514b pkz;

        public C250272(Context context, C26514b c26514b) {
            this.pkz = c26514b;
            super(context);
        }

        public final void onBindView(View view) {
            AppMethodBeat.m2504i(23251);
            super.onBindView(view);
            if (this.pnu != null) {
                int i = (this.pkz.action == 2 || this.pkz.action == 3) ? 1 : 0;
                if (i != 0) {
                    this.pnu.setTextColor(C4996ah.getResources().getColorStateList(C25738R.color.a86));
                }
            }
            if (!(this.yCq == null || TextUtils.isEmpty(this.pkz.cIY))) {
                this.yCq.setVisibility(0);
                C32291o.ahp().mo43765a(this.pkz.cIY, this.yCq);
            }
            AppMethodBeat.m2505o(23251);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.a$3 */
    public static class C286803 implements C23633b {
        final /* synthetic */ C7616ad emj;
        final /* synthetic */ C18734a pkA;
        final /* synthetic */ C26514b pkz;
        final /* synthetic */ Context val$context;

        public C286803(C26514b c26514b, C7616ad c7616ad, C18734a c18734a, Context context) {
            this.pkz = c26514b;
            this.emj = c7616ad;
            this.pkA = c18734a;
            this.val$context = context;
        }

        public final boolean car() {
            AppMethodBeat.m2504i(23252);
            Object obj = this.pkz.geX;
            try {
                obj = new JSONObject(this.pkz.geX).optString("tel");
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", e, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
            }
            C7060h.pYm.mo8381e(15319, this.emj.field_openImAppid, Integer.valueOf(this.pkz.action), this.pkA.title);
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(obj))));
            intent.setFlags(268435456);
            this.val$context.startActivity(intent);
            AppMethodBeat.m2505o(23252);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.a$4 */
    public static class C394994 implements C23633b {
        final /* synthetic */ C7616ad emj;
        final /* synthetic */ C18734a pkA;
        final /* synthetic */ C26514b pkz;
        final /* synthetic */ Context val$context;

        public C394994(C26514b c26514b, C7616ad c7616ad, C18734a c18734a, Context context) {
            this.pkz = c26514b;
            this.emj = c7616ad;
            this.pkA = c18734a;
            this.val$context = context;
        }

        public final boolean car() {
            AppMethodBeat.m2504i(23253);
            Object obj = "";
            try {
                obj = new JSONObject(this.pkz.geX).optString("mailto");
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", e, "loadProfile", new Object[0]);
            }
            C7060h.pYm.mo8381e(15319, this.emj.field_openImAppid, Integer.valueOf(this.pkz.action), this.pkA.title);
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse(WebView.SCHEME_MAILTO.concat(String.valueOf(obj))));
            this.val$context.startActivity(intent);
            AppMethodBeat.m2505o(23253);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.a$6 */
    public static class C395006 implements C23633b {
        final /* synthetic */ C7616ad emj;
        final /* synthetic */ C18734a pkA;
        final /* synthetic */ C26514b pkz;

        public C395006(C26514b c26514b, C7616ad c7616ad, C18734a c18734a) {
            this.pkz = c26514b;
            this.emj = c7616ad;
            this.pkA = c18734a;
        }

        public final boolean car() {
            AppMethodBeat.m2504i(23255);
            try {
                JSONObject jSONObject = new JSONObject(this.pkz.geX);
                String optString = jSONObject.optString("name");
                String optString2 = jSONObject.optString("pagepath");
                C32628se c32628se = new C32628se();
                c32628se.cOf.userName = optString;
                c32628se.cOf.cOh = C5046bo.m7532bc(optString2, "");
                C4879a.xxA.mo10055m(c32628se);
                C7060h.pYm.mo8381e(15319, this.emj.field_openImAppid, Integer.valueOf(this.pkz.action), this.pkA.title);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", e, "loadProfile", new Object[0]);
            }
            AppMethodBeat.m2505o(23255);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.a$5 */
    public static class C433815 implements C23633b {
        final /* synthetic */ C7616ad emj;
        final /* synthetic */ C18734a pkA;
        final /* synthetic */ C26514b pkz;

        public C433815(C26514b c26514b, C7616ad c7616ad, C18734a c18734a) {
            this.pkz = c26514b;
            this.emj = c7616ad;
            this.pkA = c18734a;
        }

        public final boolean car() {
            AppMethodBeat.m2504i(23254);
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            String str = "";
            try {
                str = new JSONObject(this.pkz.geX).optString("url");
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", e, "loadProfile", new Object[0]);
            }
            C7060h.pYm.mo8381e(15319, this.emj.field_openImAppid, Integer.valueOf(this.pkz.action), this.pkA.title);
            intent.putExtra("geta8key_scene", 58);
            intent.putExtra("rawUrl", str);
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(23254);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.a$7 */
    public static class C433827 implements C23633b {
        final /* synthetic */ C7616ad emj;
        final /* synthetic */ String pkB;
        final /* synthetic */ String val$url;

        public C433827(String str, C7616ad c7616ad, String str2) {
            this.val$url = str;
            this.emj = c7616ad;
            this.pkB = str2;
        }

        public final boolean car() {
            AppMethodBeat.m2504i(23256);
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            intent.putExtra("rawUrl", this.val$url);
            intent.putExtra("geta8key_scene", 58);
            C4996ah.getContext().startActivity(intent);
            C7060h.pYm.mo8381e(15319, this.emj.field_openImAppid, Integer.valueOf(6), this.pkB);
            AppMethodBeat.m2505o(23256);
            return true;
        }
    }
}
