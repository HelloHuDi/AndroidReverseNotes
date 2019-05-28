package com.tencent.mm.plugin.appbrand.i;

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
import com.tencent.mm.R;
import com.tencent.mm.af.a.b;
import com.tencent.mm.g.b.a.cs;
import com.tencent.mm.g.b.a.cs.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.r.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.lang.ref.WeakReference;

public class a implements j {
    public final CharSequence a(String str, Bundle bundle, final WeakReference<Context> weakReference, final WeakReference<NeatTextView> weakReference2) {
        AppMethodBeat.i(132268);
        final com.tencent.mm.af.a.a mk = com.tencent.mm.af.a.a.mk(str);
        if (((Context) weakReference.get()) == null) {
            ab.w("MicroMsg.WxaSubscribeMsgService", "context is null");
            AppMethodBeat.o(132268);
            return null;
        }
        String str2 = mk.content;
        if (bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.WxaSubscribeMsgService", "content is null, return");
            AppMethodBeat.o(132268);
            return null;
        }
        final String string = bundle.getString("conv_talker_username");
        final int i = bundle.getInt("scene");
        final long j = bundle.getLong("msg_sever_id");
        final String string2 = bundle.getString("send_msg_username");
        final CharSequence spannableString = new SpannableString(str2);
        spannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
            public final void onClickImp(View view) {
                AppMethodBeat.i(132265);
                ab.i("MicroMsg.WxaSubscribeMsgService", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", mk.content, mk.username, mk.path, string);
                Bundle bundle = new Bundle();
                bundle.putInt("stat_scene", i);
                bundle.putString("stat_msg_id", "msg_" + Long.toString(j));
                bundle.putString("stat_chat_talker_username", string);
                bundle.putString("stat_send_msg_user", string2);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE;
                appBrandStatObject.cst = "";
                appBrandStatObject.cOq = f.h(appBrandStatObject.scene, bundle);
                appBrandStatObject.cOr = f.i(appBrandStatObject.scene, bundle);
                String str = "";
                if (mk.path != null && mk.path.length() > 0) {
                    byte[] decode = Base64.decode(mk.path, 2);
                    if (decode != null) {
                        str = new String(decode);
                    }
                }
                ((e) g.K(e.class)).a(view.getContext(), mk.username, null, mk.type, 0, str, appBrandStatObject);
                ((d) g.K(d.class)).a(mk.username, new com.tencent.mm.plugin.appbrand.service.d.a() {
                    public final void d(WxaAttributes wxaAttributes) {
                        c cVar;
                        AppMethodBeat.i(132264);
                        b pn = ((k) g.K(k.class)).pn(mk.bQi);
                        cs.d dVar = cs.d.dhY;
                        cs.e eVar = cs.e.dic;
                        if (pn != null) {
                            if (pn.field_msgState == 1) {
                                dVar = cs.d.dia;
                            } else if (pn.field_msgState == 0) {
                                dVar = cs.d.dhZ;
                            }
                            if (pn.field_btnState == 2) {
                                eVar = cs.e.die;
                            } else if (pn.field_btnState == 0 || pn.field_btnState == 1) {
                                eVar = cs.e.did;
                            }
                        }
                        int i = wxaAttributes.ayJ() == null ? 0 : wxaAttributes.ayJ().fmr;
                        cs hH = new cs().hE(mk.appId).hF(mk.path).hG(mk.path).hH(string);
                        if (string.toLowerCase().endsWith("@chatroom")) {
                            cVar = c.dhV;
                        } else {
                            cVar = c.dhW;
                        }
                        hH.dhB = cVar;
                        hH.dhC = cs.b.dhS;
                        hH.cVR = 0;
                        cs hI = hH.hI("");
                        hI.dhG = com.tencent.mm.g.b.a.cs.a.hp(i + 1000);
                        cs Hk = hI.Hk();
                        Hk.dhE = dVar;
                        Hk.dhF = eVar;
                        Hk.ajK();
                        AppMethodBeat.o(132264);
                    }
                });
                AppMethodBeat.o(132265);
            }
        }, str2.indexOf(mk.title), str2.indexOf(mk.title) + mk.title.length(), 17);
        ab.i("MicroMsg.WxaSubscribeMsgService", "wxaSubscribeSysContent.forbids:%d", Integer.valueOf(mk.fjV));
        if (mk.fjV == 1) {
            AppMethodBeat.o(132268);
            return spannableString;
        }
        WxaAttributes zb = ((d) g.K(d.class)).zb(mk.username);
        String str3 = zb != null ? zb.field_brandIconURL : "";
        CharSequence concat;
        if (com.tencent.mm.modelappbrand.a.b.abR().a(str3, null) == null) {
            com.tencent.mm.modelappbrand.a.b.abR().a(new i() {
                public final void abU() {
                }

                public final void x(Bitmap bitmap) {
                    AppMethodBeat.i(132266);
                    NeatTextView neatTextView = (NeatTextView) weakReference2.get();
                    Context context = (Context) weakReference.get();
                    if (!(context == null || neatTextView == null)) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
                        bitmapDrawable.setBounds(0, 0, o.aNT(), o.aNT());
                        com.tencent.mm.plugin.appbrand.widget.h.b bVar = new com.tencent.mm.plugin.appbrand.widget.h.b(bitmapDrawable);
                        new SpannableString("@ ").setSpan(bVar, 0, 1, 33);
                        neatTextView.ah(TextUtils.concat(new CharSequence[]{r2, spannableString}));
                        neatTextView.invalidate();
                    }
                    AppMethodBeat.o(132266);
                }

                public final void mr() {
                }

                public final String wP() {
                    AppMethodBeat.i(132267);
                    String simpleName = a.class.getSimpleName();
                    AppMethodBeat.o(132267);
                    return simpleName;
                }
            }, str3, null);
            concat = TextUtils.concat(new CharSequence[]{a(r0, mk.fjW, null), spannableString});
            AppMethodBeat.o(132268);
            return concat;
        }
        concat = TextUtils.concat(new CharSequence[]{a(r0, mk.fjW, com.tencent.mm.modelappbrand.a.b.abR().a(str3, null)), spannableString});
        AppMethodBeat.o(132268);
        return concat;
    }

    private static SpannableString a(Context context, int i, Bitmap bitmap) {
        Drawable drawable;
        AppMethodBeat.i(132269);
        if (bitmap == null) {
            drawable = context.getResources().getDrawable(i == 1 ? R.raw.spannable_wxa_game_link_logo : R.raw.spannable_app_brand_link_logo);
        } else {
            drawable = new BitmapDrawable(context.getResources(), bitmap);
        }
        drawable.setBounds(0, 0, o.aNT(), o.aNT());
        com.tencent.mm.plugin.appbrand.widget.h.b bVar = new com.tencent.mm.plugin.appbrand.widget.h.b(drawable);
        SpannableString spannableString = new SpannableString("@ ");
        spannableString.setSpan(bVar, 0, 1, 33);
        AppMethodBeat.o(132269);
        return spannableString;
    }
}
