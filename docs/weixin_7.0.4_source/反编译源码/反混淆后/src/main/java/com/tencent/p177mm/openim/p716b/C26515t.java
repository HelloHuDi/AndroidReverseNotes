package com.tencent.p177mm.openim.p716b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.openim.PluginOpenIM;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C32873b.C32874a;
import com.tencent.p177mm.openim.p877e.C42246c;
import com.tencent.p177mm.openim.p877e.C42248e;
import com.tencent.p177mm.openim.p877e.C9775a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.EllipsizeTextView;
import com.tencent.p177mm.p612ui.base.EllipsizeTextView.C30360a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C38317l;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.bha;
import com.tencent.p177mm.protocal.protobuf.bhb;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.openim.b.t */
public final class C26515t implements C32873b {
    private HashMap<String, C9772b> gfk = new HashMap();
    private C30360a gfl = new C265181();
    private C30360a gfm = new C265162();

    /* renamed from: com.tencent.mm.openim.b.t$a */
    class C9771a {
        Bitmap bitmap;

        private C9771a() {
        }

        /* synthetic */ C9771a(C26515t c26515t, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.openim.b.t$b */
    class C9772b {
        LinkedList<String> gfp;
        LinkedList<String> gfq;

        private C9772b() {
            AppMethodBeat.m2504i(78893);
            this.gfp = new LinkedList();
            this.gfq = new LinkedList();
            AppMethodBeat.m2505o(78893);
        }

        /* synthetic */ C9772b(C26515t c26515t, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.openim.b.t$2 */
    class C265162 implements C30360a {
        C265162() {
        }

        /* renamed from: a */
        public final CharSequence mo44312a(TextView textView, CharSequence charSequence, String str, int i, int i2) {
            AppMethodBeat.m2504i(78891);
            Drawable drawable = textView.getContext().getResources().getDrawable(C1318a.open_im_main_logo);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            CharSequence ellipsize = TextUtils.ellipsize(charSequence, textView.getPaint(), ((float) ((textView.getMeasuredWidth() - textView.getCompoundPaddingRight()) - textView.getCompoundPaddingLeft())) - (((float) drawable.getIntrinsicWidth()) + textView.getPaint().measureText(" ")), TruncateAt.END);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ellipsize);
            spannableStringBuilder.append(" ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), ellipsize.length(), ellipsize.length() + 1, 33);
            AppMethodBeat.m2505o(78891);
            return spannableStringBuilder;
        }
    }

    /* renamed from: com.tencent.mm.openim.b.t$1 */
    class C265181 implements C30360a {
        C265181() {
        }

        /* renamed from: a */
        public final CharSequence mo44312a(TextView textView, CharSequence charSequence, String str, int i, int i2) {
            Object str2;
            Object obj;
            AppMethodBeat.m2504i(78890);
            float measureText = textView.getPaint().measureText(" ".concat(String.valueOf(str2)));
            int measuredWidth = (textView.getMeasuredWidth() - textView.getCompoundPaddingRight()) - textView.getCompoundPaddingLeft();
            if (((double) measureText) >= ((double) measuredWidth) * 0.6d) {
                CharSequence ellipsize = TextUtils.ellipsize(charSequence, textView.getPaint(), (float) (((double) measuredWidth) * 0.4d), TruncateAt.END);
                str2 = TextUtils.ellipsize(str2, textView.getPaint(), (((float) measuredWidth) - textView.getPaint().measureText(ellipsize.toString())) - 20.0f, TruncateAt.END);
                obj = ellipsize;
            } else {
                CharSequence obj2 = TextUtils.ellipsize(charSequence, textView.getPaint(), ((float) measuredWidth) - measureText, TruncateAt.END);
            }
            SpannableString b = C44089j.m79292b(textView.getContext(), obj2 + " " + str2);
            ColorStateList h = C1338a.m2870h(textView.getContext(), i);
            b.setSpan(new TextAppearanceSpan(null, 0, i2, h, h), obj2.length() + 1, (obj2.length() + 1) + str2.length(), 33);
            AppMethodBeat.m2505o(78890);
            return b;
        }
    }

    public C26515t() {
        AppMethodBeat.m2504i(78894);
        C1173e.m2564cw(C26515t.anx());
        C42246c c42246c = new C42246c();
        c42246c.field_appid = "3552365301";
        c42246c.field_language = C4988aa.m7403gw(C4996ah.getContext());
        C1720g.m3537RQ();
        ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAppIdInfoStg().mo10102b((C4925c) c42246c, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        if (c42246c.xDa == -1) {
            m42322vl("3552365301");
            AppMethodBeat.m2505o(78894);
            return;
        }
        AppMethodBeat.m2505o(78894);
    }

    public static String anx() {
        AppMethodBeat.m2504i(78895);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("openim/").toString();
        AppMethodBeat.m2505o(78895);
        return stringBuilder2;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(78896);
        if (c1207m.getType() != C38317l.CTRL_INDEX) {
            AppMethodBeat.m2505o(78896);
        } else if (i == 0 && i2 == 0) {
            C32878i c32878i = (C32878i) c1207m;
            C9772b c9772b = (C9772b) this.gfk.get(c32878i.gfc + c32878i.aOt);
            if (c9772b.gfp.isEmpty()) {
                this.gfk.remove(c32878i.gfc + c32878i.aOt);
                AppMethodBeat.m2505o(78896);
                return;
            }
            while (c9772b.gfq.size() < 10 && !c9772b.gfp.isEmpty()) {
                c9772b.gfq.add(c9772b.gfp.removeFirst());
            }
            C1720g.m3535RO().eJo.mo14541a(new C32878i(c32878i.gfc, c32878i.aOt, c9772b.gfq), 0);
            AppMethodBeat.m2505o(78896);
        } else {
            AppMethodBeat.m2505o(78896);
        }
    }

    /* renamed from: a */
    public final CharSequence mo44298a(Context context, CharSequence charSequence) {
        AppMethodBeat.m2504i(78897);
        if (C5046bo.m7519ac(charSequence)) {
            charSequence = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.append(" ");
        Drawable drawable = context.getResources().getDrawable(C1318a.open_im_main_logo);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.setSpan(new ImageSpan(drawable), charSequence.length(), charSequence.length() + 1, 33);
        AppMethodBeat.m2505o(78897);
        return spannableStringBuilder;
    }

    /* renamed from: e */
    public final SpannableString mo44308e(Context context, String str, int i) {
        AppMethodBeat.m2504i(78898);
        SpannableString b = C44089j.m79294b(context, (CharSequence) str, i);
        AppMethodBeat.m2505o(78898);
        return b;
    }

    /* renamed from: a */
    public final void mo44302a(Context context, TextView textView, CharSequence charSequence, String str, String str2, int i) {
        AppMethodBeat.m2504i(78899);
        String ba;
        if (textView instanceof EllipsizeTextView) {
            EllipsizeTextView ellipsizeTextView = (EllipsizeTextView) textView;
            ba = ((C32873b) C1720g.m3528K(C32873b.class)).mo44306ba(str, str2);
            if (C5046bo.isNullOrNil(ba)) {
                ba = "";
            } else if ("3552365301".equals(str)) {
                ba = " @".concat(String.valueOf(ba));
            }
            ellipsizeTextView.setLayoutCallback(this.gfl);
            ellipsizeTextView.mo48669a(charSequence, ba, C25738R.color.f12217wf, i);
            AppMethodBeat.m2505o(78899);
            return;
        }
        CharSequence b;
        ba = ((C32873b) C1720g.m3528K(C32873b.class)).mo44306ba(str, str2);
        if (C5046bo.isNullOrNil(ba)) {
            b = C44089j.m79294b(context, charSequence, i);
        } else {
            CharSequence concat;
            if ("3552365301".equals(str)) {
                concat = " @".concat(String.valueOf(ba));
            } else {
                Object concat2 = ba;
            }
            SpannableString b2 = C44089j.m79294b(context, charSequence, i);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(b2);
            SpannableString spannableString = new SpannableString(concat2);
            ColorStateList h = C1338a.m2870h(context, (int) C25738R.color.f12217wf);
            spannableString.setSpan(new TextAppearanceSpan(null, 0, i, h, h), 0, concat2.length(), 33);
            spannableStringBuilder.append(spannableString);
            b = spannableStringBuilder;
        }
        textView.setText(b);
        AppMethodBeat.m2505o(78899);
    }

    /* renamed from: a */
    public final void mo44301a(Context context, TextView textView, CharSequence charSequence) {
        AppMethodBeat.m2504i(78900);
        if (textView instanceof EllipsizeTextView) {
            EllipsizeTextView ellipsizeTextView = (EllipsizeTextView) textView;
            ellipsizeTextView.setLayoutCallback(this.gfm);
            ellipsizeTextView.mo48669a(charSequence, " ", -1, (int) textView.getTextSize());
            AppMethodBeat.m2505o(78900);
            return;
        }
        textView.setText(((C32873b) C1720g.m3528K(C32873b.class)).mo44298a(context, charSequence));
        AppMethodBeat.m2505o(78900);
    }

    /* renamed from: a */
    public final CharSequence mo44299a(Context context, String str, String str2, float f) {
        AppMethodBeat.m2504i(78901);
        Bitmap vh = mo44310vh(str);
        if (vh != null) {
            SpannableString b = C44089j.m79293b(context, "  ".concat(String.valueOf(str2)), f);
            int fromDPToPix = (int) (((float) C1338a.fromDPToPix(context, 2)) + f);
            ImageSpan imageSpan = new ImageSpan(C4996ah.getContext(), vh);
            imageSpan.getDrawable().setBounds(0, 0, fromDPToPix, fromDPToPix);
            b.setSpan(imageSpan, 0, 1, 33);
            AppMethodBeat.m2505o(78901);
            return b;
        }
        AppMethodBeat.m2505o(78901);
        return str2;
    }

    /* renamed from: vh */
    public final Bitmap mo44310vh(String str) {
        AppMethodBeat.m2504i(78902);
        final C9771a c9771a = new C9771a(this, (byte) 0);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(78902);
            return null;
        }
        C17927a c17927a = new C17927a();
        c17927a.ePH = true;
        c17927a.ePJ = C26515t.anx() + C1178g.m2591x(str.getBytes());
        C32291o.ahp().mo43767a(str, null, c17927a.ahG(), new C9014g() {
            /* renamed from: sH */
            public final void mo7596sH(String str) {
            }

            /* renamed from: a */
            public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                return null;
            }

            /* renamed from: b */
            public final void mo7595b(String str, View view, C37477b c37477b) {
                AppMethodBeat.m2504i(78892);
                if (!(c37477b.status != 0 || c37477b.bitmap == null || c37477b.bitmap.isRecycled())) {
                    c9771a.bitmap = c37477b.bitmap;
                }
                AppMethodBeat.m2505o(78892);
            }
        });
        Bitmap bitmap = c9771a.bitmap;
        AppMethodBeat.m2505o(78902);
        return bitmap;
    }

    /* renamed from: vi */
    public final int mo44311vi(String str) {
        AppMethodBeat.m2504i(78903);
        C42246c c42246c = new C42246c();
        c42246c.field_appid = str;
        C1720g.m3537RQ();
        ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAppIdInfoStg().mo10102b((C4925c) c42246c, "appid");
        if (c42246c.xDa == -1) {
            m42322vl(str);
            AppMethodBeat.m2505o(78903);
            return 0;
        }
        int i = c42246c.field_appRec.vFv;
        AppMethodBeat.m2505o(78903);
        return i;
    }

    /* renamed from: a */
    public final String mo44300a(String str, String str2, C32874a c32874a) {
        AppMethodBeat.m2504i(78904);
        C42246c c42246c = new C42246c();
        c42246c.field_appid = str;
        C1720g.m3537RQ();
        ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAppIdInfoStg().mo10102b((C4925c) c42246c, "appid");
        if (c42246c.xDa == -1) {
            m42322vl(str);
            AppMethodBeat.m2505o(78904);
            return null;
        }
        String a = C26515t.m42318a(c42246c.field_acctTypeId, str2, c32874a, C4988aa.m7403gw(C4996ah.getContext()));
        if (a == null) {
            a = C26515t.m42318a(c42246c.field_acctTypeId, str2, c32874a, "en");
        }
        AppMethodBeat.m2505o(78904);
        return a;
    }

    /* renamed from: b */
    public final String mo44305b(String str, String str2, C32874a c32874a) {
        AppMethodBeat.m2504i(78905);
        String a = C26515t.m42318a(str, str2, c32874a, C4988aa.m7403gw(C4996ah.getContext()));
        if (a == null) {
            a = C26515t.m42318a(str, str2, c32874a, "en");
        }
        AppMethodBeat.m2505o(78905);
        return a;
    }

    /* renamed from: a */
    private static String m42318a(String str, String str2, C32874a c32874a, String str3) {
        AppMethodBeat.m2504i(78906);
        C9775a c9775a = new C9775a();
        c9775a.field_acctTypeId = str;
        c9775a.field_language = str3;
        C1720g.m3537RQ();
        ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAccTypeInfoStg().mo10102b((C4925c) c9775a, "acctTypeId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        Iterator it;
        String str4;
        if (c9775a.xDa == -1) {
            AppMethodBeat.m2505o(78906);
            return null;
        } else if (c32874a == C32874a.TYPE_WORDING) {
            it = c9775a.field_accTypeRec.vCr.iterator();
            while (it.hasNext()) {
                bhb bhb = (bhb) it.next();
                if (str2.equals(bhb.key)) {
                    str4 = bhb.cEh;
                    AppMethodBeat.m2505o(78906);
                    return str4;
                }
            }
            AppMethodBeat.m2505o(78906);
            return null;
        } else {
            it = c9775a.field_accTypeRec.ckO.iterator();
            while (it.hasNext()) {
                bha bha = (bha) it.next();
                if (str2.equals(bha.key)) {
                    str4 = bha.url;
                    AppMethodBeat.m2505o(78906);
                    return str4;
                }
            }
            AppMethodBeat.m2505o(78906);
            return null;
        }
    }

    /* renamed from: c */
    public final String mo44307c(String str, String str2, C32874a c32874a) {
        AppMethodBeat.m2504i(78907);
        String b = m42319b(str, str2, c32874a, C4988aa.m7403gw(C4996ah.getContext()));
        if (b == null) {
            b = m42319b(str, str2, c32874a, "en");
        }
        AppMethodBeat.m2505o(78907);
        return b;
    }

    /* renamed from: b */
    private String m42319b(String str, String str2, C32874a c32874a, String str3) {
        AppMethodBeat.m2504i(78908);
        C42246c c42246c = new C42246c();
        c42246c.field_appid = str;
        c42246c.field_language = str3;
        C1720g.m3537RQ();
        ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAppIdInfoStg().mo10102b((C4925c) c42246c, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        Iterator it;
        String str4;
        if (c42246c.xDa == -1) {
            m42320bb(str, str3);
            AppMethodBeat.m2505o(78908);
            return null;
        } else if (c32874a == C32874a.TYPE_WORDING) {
            it = c42246c.field_appRec.vCr.iterator();
            while (it.hasNext()) {
                bhb bhb = (bhb) it.next();
                if (str2.equals(bhb.key)) {
                    str4 = bhb.cEh;
                    AppMethodBeat.m2505o(78908);
                    return str4;
                }
            }
            AppMethodBeat.m2505o(78908);
            return null;
        } else {
            it = c42246c.field_appRec.ckO.iterator();
            while (it.hasNext()) {
                bha bha = (bha) it.next();
                if (str2.equals(bha.key)) {
                    str4 = bha.url;
                    AppMethodBeat.m2505o(78908);
                    return str4;
                }
            }
            AppMethodBeat.m2505o(78908);
            return null;
        }
    }

    /* renamed from: ba */
    public final String mo44306ba(String str, String str2) {
        AppMethodBeat.m2504i(78909);
        String v = m42321v(str, str2, C4988aa.m7403gw(C4996ah.getContext()));
        if (v == null) {
            v = m42321v(str, str2, "en");
        }
        AppMethodBeat.m2505o(78909);
        return v;
    }

    public final void anw() {
        AppMethodBeat.m2504i(78910);
        ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAppIdInfoStg().fni.delete("OpenIMAppIdInfo", null, null);
        ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAccTypeInfoStg().fni.delete("OpenIMAccTypeInfo", null, null);
        ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getWordingInfoStg().fni.delete("OpenIMWordingInfo", null, null);
        AppMethodBeat.m2505o(78910);
    }

    /* renamed from: v */
    private String m42321v(String str, String str2, String str3) {
        AppMethodBeat.m2504i(78911);
        C42248e c42248e = new C42248e();
        c42248e.field_appid = str;
        c42248e.field_language = str3;
        c42248e.field_wordingId = str2;
        C1720g.m3537RQ();
        ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getWordingInfoStg().mo10102b((C4925c) c42248e, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "wordingId");
        if (c42248e.xDa == -1) {
            mo44309u(str, str3, str2);
            AppMethodBeat.m2505o(78911);
            return null;
        }
        String str4 = c42248e.field_wording;
        AppMethodBeat.m2505o(78911);
        return str4;
    }

    /* renamed from: vl */
    private void m42322vl(String str) {
        AppMethodBeat.m2504i(78912);
        m42320bb(str, C4988aa.m7403gw(C4996ah.getContext()));
        AppMethodBeat.m2505o(78912);
    }

    /* renamed from: bb */
    private void m42320bb(String str, String str2) {
        AppMethodBeat.m2504i(78913);
        mo44309u(str, str2, "");
        AppMethodBeat.m2505o(78913);
    }

    /* renamed from: u */
    public final void mo44309u(String str, String str2, String str3) {
        AppMethodBeat.m2504i(78914);
        C4990ab.m7417i("MicroMsg.Openim.OpenImResourceMgr", "try checkDoSceneGetRec openimAppId %s language %s wordingid %s", str, str2, str3);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(78914);
            return;
        }
        C9772b c9772b;
        if (!this.gfk.containsKey(str + str2)) {
            c9772b = new C9772b(this, (byte) 0);
            if (!C5046bo.isNullOrNil(str3)) {
                c9772b.gfq.add(str3);
            }
            this.gfk.put(str + str2, c9772b);
            C1720g.m3535RO().eJo.mo14541a(new C32878i(str, str2, c9772b.gfq), 0);
        }
        if (C5046bo.isNullOrNil(str3)) {
            AppMethodBeat.m2505o(78914);
            return;
        }
        c9772b = (C9772b) this.gfk.get(str + str2);
        if (c9772b.gfp.contains(str3) || c9772b.gfq.contains(str3)) {
            AppMethodBeat.m2505o(78914);
            return;
        }
        c9772b.gfp.add(str3);
        AppMethodBeat.m2505o(78914);
    }

    /* renamed from: aZ */
    public final void mo44303aZ(String str, String str2) {
        boolean z;
        AppMethodBeat.m2504i(78915);
        StringBuffer stringBuffer = new StringBuffer();
        C42246c c42246c = new C42246c();
        c42246c.field_appid = str;
        c42246c.field_language = C4988aa.m7403gw(C4996ah.getContext());
        C1720g.m3537RQ();
        ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAppIdInfoStg().mo10102b((C4925c) c42246c, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        stringBuffer.append(String.format("openIMAppIdinfo.field_updateTime %s | ", new Object[]{Long.valueOf(c42246c.field_updateTime)}));
        if (c42246c.xDa == -1 || C5046bo.m7549fp(c42246c.field_updateTime) > 172800) {
            z = true;
        } else {
            z = false;
        }
        if (!(z || C5046bo.isNullOrNil(str2))) {
            boolean z2;
            C42248e c42248e = new C42248e();
            c42248e.field_appid = str;
            c42248e.field_language = C4988aa.m7403gw(C4996ah.getContext());
            c42248e.field_wordingId = str2;
            C1720g.m3537RQ();
            ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getWordingInfoStg().mo10102b((C4925c) c42248e, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "wordingId");
            if (c42248e.xDa == -1 || C5046bo.m7549fp(c42248e.field_updateTime) > 172800) {
                z2 = true;
            } else {
                z2 = z;
            }
            stringBuffer.append(String.format("wordingInfo.field_updateTime %s | ", new Object[]{Long.valueOf(c42248e.field_updateTime)}));
            z = z2;
        }
        C4990ab.m7417i("MicroMsg.Openim.OpenImResourceMgr", "checkRecUpdate openimAppId %s wordingId %s needUpdate %s logBuffer: %s", str, str2, Boolean.valueOf(z), stringBuffer.toString());
        if (z) {
            mo44309u(str, C4988aa.m7403gw(C4996ah.getContext()), str2);
        }
        AppMethodBeat.m2505o(78915);
    }
}
