package com.tencent.p177mm.plugin.appbrand.p896i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C32810j;
import com.tencent.p177mm.modelappbrand.C45446k;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.p181af.p1175a.C17871b;
import com.tencent.p177mm.p181af.p1175a.C25744a;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C18452c;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C18453d;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C18454e;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C26289b;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C26290a;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.p328r.C45674o;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19693f;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.appbrand.service.C42686d.C38509a;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.appbrand.widget.p916h.C10982b;
import com.tencent.p177mm.plugin.messenger.p993a.C34529a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.appbrand.i.a */
public class C10263a implements C32810j {
    /* renamed from: a */
    public final CharSequence mo21700a(String str, Bundle bundle, final WeakReference<Context> weakReference, final WeakReference<NeatTextView> weakReference2) {
        AppMethodBeat.m2504i(132268);
        final C25744a mk = C25744a.m40872mk(str);
        if (((Context) weakReference.get()) == null) {
            C4990ab.m7420w("MicroMsg.WxaSubscribeMsgService", "context is null");
            AppMethodBeat.m2505o(132268);
            return null;
        }
        String str2 = mk.content;
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7420w("MicroMsg.WxaSubscribeMsgService", "content is null, return");
            AppMethodBeat.m2505o(132268);
            return null;
        }
        final String string = bundle.getString("conv_talker_username");
        final int i = bundle.getInt("scene");
        final long j = bundle.getLong("msg_sever_id");
        final String string2 = bundle.getString("send_msg_username");
        final CharSequence spannableString = new SpannableString(str2);
        spannableString.setSpan(new C34529a() {

            /* renamed from: com.tencent.mm.plugin.appbrand.i.a$1$1 */
            class C102661 implements C38509a {
                C102661() {
                }

                /* renamed from: d */
                public final void mo21701d(WxaAttributes wxaAttributes) {
                    C18452c c18452c;
                    AppMethodBeat.m2504i(132264);
                    C17871b pn = ((C45446k) C1720g.m3528K(C45446k.class)).mo60978pn(mk.bQi);
                    C18453d c18453d = C18453d.dhY;
                    C18454e c18454e = C18454e.dic;
                    if (pn != null) {
                        if (pn.field_msgState == 1) {
                            c18453d = C18453d.dia;
                        } else if (pn.field_msgState == 0) {
                            c18453d = C18453d.dhZ;
                        }
                        if (pn.field_btnState == 2) {
                            c18454e = C18454e.die;
                        } else if (pn.field_btnState == 0 || pn.field_btnState == 1) {
                            c18454e = C18454e.did;
                        }
                    }
                    int i = wxaAttributes.ayJ() == null ? 0 : wxaAttributes.ayJ().fmr;
                    C26288cs hH = new C26288cs().mo44049hE(mk.appId).mo44050hF(mk.path).mo44051hG(mk.path).mo44052hH(string);
                    if (string.toLowerCase().endsWith("@chatroom")) {
                        c18452c = C18452c.dhV;
                    } else {
                        c18452c = C18452c.dhW;
                    }
                    hH.dhB = c18452c;
                    hH.dhC = C26289b.dhS;
                    hH.cVR = 0;
                    C26288cs hI = hH.mo44053hI("");
                    hI.dhG = C26290a.m41777hp(i + 1000);
                    C26288cs Hk = hI.mo44048Hk();
                    Hk.dhE = c18453d;
                    Hk.dhF = c18454e;
                    Hk.ajK();
                    AppMethodBeat.m2505o(132264);
                }
            }

            public final void onClickImp(View view) {
                AppMethodBeat.m2504i(132265);
                C4990ab.m7417i("MicroMsg.WxaSubscribeMsgService", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", mk.content, mk.username, mk.path, string);
                Bundle bundle = new Bundle();
                bundle.putInt("stat_scene", i);
                bundle.putString("stat_msg_id", "msg_" + Long.toString(j));
                bundle.putString("stat_chat_talker_username", string);
                bundle.putString("stat_send_msg_user", string2);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE;
                appBrandStatObject.cst = "";
                appBrandStatObject.cOq = C19693f.m30514h(appBrandStatObject.scene, bundle);
                appBrandStatObject.cOr = C19693f.m30515i(appBrandStatObject.scene, bundle);
                String str = "";
                if (mk.path != null && mk.path.length() > 0) {
                    byte[] decode = Base64.decode(mk.path, 2);
                    if (decode != null) {
                        str = new String(decode);
                    }
                }
                ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(view.getContext(), mk.username, null, mk.type, 0, str, appBrandStatObject);
                ((C42686d) C1720g.m3528K(C42686d.class)).mo44615a(mk.username, new C102661());
                AppMethodBeat.m2505o(132265);
            }
        }, str2.indexOf(mk.title), str2.indexOf(mk.title) + mk.title.length(), 17);
        C4990ab.m7417i("MicroMsg.WxaSubscribeMsgService", "wxaSubscribeSysContent.forbids:%d", Integer.valueOf(mk.fjV));
        if (mk.fjV == 1) {
            AppMethodBeat.m2505o(132268);
            return spannableString;
        }
        WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(mk.username);
        String str3 = zb != null ? zb.field_brandIconURL : "";
        CharSequence concat;
        if (C37926b.abR().mo60681a(str3, null) == null) {
            C37926b.abR().mo60685a(new C9676i() {
                public final void abU() {
                }

                /* renamed from: x */
                public final void mo6524x(Bitmap bitmap) {
                    AppMethodBeat.m2504i(132266);
                    NeatTextView neatTextView = (NeatTextView) weakReference2.get();
                    Context context = (Context) weakReference.get();
                    if (!(context == null || neatTextView == null)) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
                        bitmapDrawable.setBounds(0, 0, C45674o.aNT(), C45674o.aNT());
                        C10982b c10982b = new C10982b(bitmapDrawable);
                        new SpannableString("@ ").setSpan(c10982b, 0, 1, 33);
                        neatTextView.mo15921ah(TextUtils.concat(new CharSequence[]{r2, spannableString}));
                        neatTextView.invalidate();
                    }
                    AppMethodBeat.m2505o(132266);
                }

                /* renamed from: mr */
                public final void mo6522mr() {
                }

                /* renamed from: wP */
                public final String mo6523wP() {
                    AppMethodBeat.m2504i(132267);
                    String simpleName = C10263a.class.getSimpleName();
                    AppMethodBeat.m2505o(132267);
                    return simpleName;
                }
            }, str3, null);
            concat = TextUtils.concat(new CharSequence[]{C10263a.m17911a(r0, mk.fjW, null), spannableString});
            AppMethodBeat.m2505o(132268);
            return concat;
        }
        concat = TextUtils.concat(new CharSequence[]{C10263a.m17911a(r0, mk.fjW, C37926b.abR().mo60681a(str3, null)), spannableString});
        AppMethodBeat.m2505o(132268);
        return concat;
    }

    /* renamed from: a */
    private static SpannableString m17911a(Context context, int i, Bitmap bitmap) {
        Drawable drawable;
        AppMethodBeat.m2504i(132269);
        if (bitmap == null) {
            drawable = context.getResources().getDrawable(i == 1 ? C1318a.spannable_wxa_game_link_logo : C1318a.spannable_app_brand_link_logo);
        } else {
            drawable = new BitmapDrawable(context.getResources(), bitmap);
        }
        drawable.setBounds(0, 0, C45674o.aNT(), C45674o.aNT());
        C10982b c10982b = new C10982b(drawable);
        SpannableString spannableString = new SpannableString("@ ");
        spannableString.setSpan(c10982b, 0, 1, 33);
        AppMethodBeat.m2505o(132269);
        return spannableString;
    }
}
