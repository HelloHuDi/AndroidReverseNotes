package com.tencent.mm.openim.b;

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
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bhb;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.EllipsizeTextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class t implements com.tencent.mm.openim.a.b {
    private HashMap<String, b> gfk = new HashMap();
    private com.tencent.mm.ui.base.EllipsizeTextView.a gfl = new com.tencent.mm.ui.base.EllipsizeTextView.a() {
        public final CharSequence a(TextView textView, CharSequence charSequence, String str, int i, int i2) {
            Object str2;
            Object obj;
            AppMethodBeat.i(78890);
            float measureText = textView.getPaint().measureText(" ".concat(String.valueOf(str2)));
            int measuredWidth = (textView.getMeasuredWidth() - textView.getCompoundPaddingRight()) - textView.getCompoundPaddingLeft();
            if (((double) measureText) >= ((double) measuredWidth) * 0.6d) {
                CharSequence ellipsize = TextUtils.ellipsize(charSequence, textView.getPaint(), (float) (((double) measuredWidth) * 0.4d), TruncateAt.END);
                str2 = TextUtils.ellipsize(str2, textView.getPaint(), (((float) measuredWidth) - textView.getPaint().measureText(ellipsize.toString())) - 20.0f, TruncateAt.END);
                obj = ellipsize;
            } else {
                CharSequence obj2 = TextUtils.ellipsize(charSequence, textView.getPaint(), ((float) measuredWidth) - measureText, TruncateAt.END);
            }
            SpannableString b = j.b(textView.getContext(), obj2 + " " + str2);
            ColorStateList h = com.tencent.mm.bz.a.h(textView.getContext(), i);
            b.setSpan(new TextAppearanceSpan(null, 0, i2, h, h), obj2.length() + 1, (obj2.length() + 1) + str2.length(), 33);
            AppMethodBeat.o(78890);
            return b;
        }
    };
    private com.tencent.mm.ui.base.EllipsizeTextView.a gfm = new com.tencent.mm.ui.base.EllipsizeTextView.a() {
        public final CharSequence a(TextView textView, CharSequence charSequence, String str, int i, int i2) {
            AppMethodBeat.i(78891);
            Drawable drawable = textView.getContext().getResources().getDrawable(R.raw.open_im_main_logo);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            CharSequence ellipsize = TextUtils.ellipsize(charSequence, textView.getPaint(), ((float) ((textView.getMeasuredWidth() - textView.getCompoundPaddingRight()) - textView.getCompoundPaddingLeft())) - (((float) drawable.getIntrinsicWidth()) + textView.getPaint().measureText(" ")), TruncateAt.END);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ellipsize);
            spannableStringBuilder.append(" ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), ellipsize.length(), ellipsize.length() + 1, 33);
            AppMethodBeat.o(78891);
            return spannableStringBuilder;
        }
    };

    class a {
        Bitmap bitmap;

        private a() {
        }

        /* synthetic */ a(t tVar, byte b) {
            this();
        }
    }

    class b {
        LinkedList<String> gfp;
        LinkedList<String> gfq;

        private b() {
            AppMethodBeat.i(78893);
            this.gfp = new LinkedList();
            this.gfq = new LinkedList();
            AppMethodBeat.o(78893);
        }

        /* synthetic */ b(t tVar, byte b) {
            this();
        }
    }

    public t() {
        AppMethodBeat.i(78894);
        e.cw(anx());
        c cVar = new c();
        cVar.field_appid = "3552365301";
        cVar.field_language = aa.gw(ah.getContext());
        g.RQ();
        ((PluginOpenIM) g.M(PluginOpenIM.class)).getAppIdInfoStg().b((com.tencent.mm.sdk.e.c) cVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        if (cVar.xDa == -1) {
            vl("3552365301");
            AppMethodBeat.o(78894);
            return;
        }
        AppMethodBeat.o(78894);
    }

    public static String anx() {
        AppMethodBeat.i(78895);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("openim/").toString();
        AppMethodBeat.o(78895);
        return stringBuilder2;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(78896);
        if (mVar.getType() != l.CTRL_INDEX) {
            AppMethodBeat.o(78896);
        } else if (i == 0 && i2 == 0) {
            i iVar = (i) mVar;
            b bVar = (b) this.gfk.get(iVar.gfc + iVar.aOt);
            if (bVar.gfp.isEmpty()) {
                this.gfk.remove(iVar.gfc + iVar.aOt);
                AppMethodBeat.o(78896);
                return;
            }
            while (bVar.gfq.size() < 10 && !bVar.gfp.isEmpty()) {
                bVar.gfq.add(bVar.gfp.removeFirst());
            }
            g.RO().eJo.a(new i(iVar.gfc, iVar.aOt, bVar.gfq), 0);
            AppMethodBeat.o(78896);
        } else {
            AppMethodBeat.o(78896);
        }
    }

    public final CharSequence a(Context context, CharSequence charSequence) {
        AppMethodBeat.i(78897);
        if (bo.ac(charSequence)) {
            charSequence = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.append(" ");
        Drawable drawable = context.getResources().getDrawable(R.raw.open_im_main_logo);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.setSpan(new ImageSpan(drawable), charSequence.length(), charSequence.length() + 1, 33);
        AppMethodBeat.o(78897);
        return spannableStringBuilder;
    }

    public final SpannableString e(Context context, String str, int i) {
        AppMethodBeat.i(78898);
        SpannableString b = j.b(context, (CharSequence) str, i);
        AppMethodBeat.o(78898);
        return b;
    }

    public final void a(Context context, TextView textView, CharSequence charSequence, String str, String str2, int i) {
        AppMethodBeat.i(78899);
        String ba;
        if (textView instanceof EllipsizeTextView) {
            EllipsizeTextView ellipsizeTextView = (EllipsizeTextView) textView;
            ba = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).ba(str, str2);
            if (bo.isNullOrNil(ba)) {
                ba = "";
            } else if ("3552365301".equals(str)) {
                ba = " @".concat(String.valueOf(ba));
            }
            ellipsizeTextView.setLayoutCallback(this.gfl);
            ellipsizeTextView.a(charSequence, ba, R.color.wf, i);
            AppMethodBeat.o(78899);
            return;
        }
        CharSequence b;
        ba = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).ba(str, str2);
        if (bo.isNullOrNil(ba)) {
            b = j.b(context, charSequence, i);
        } else {
            CharSequence concat;
            if ("3552365301".equals(str)) {
                concat = " @".concat(String.valueOf(ba));
            } else {
                Object concat2 = ba;
            }
            SpannableString b2 = j.b(context, charSequence, i);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(b2);
            SpannableString spannableString = new SpannableString(concat2);
            ColorStateList h = com.tencent.mm.bz.a.h(context, (int) R.color.wf);
            spannableString.setSpan(new TextAppearanceSpan(null, 0, i, h, h), 0, concat2.length(), 33);
            spannableStringBuilder.append(spannableString);
            b = spannableStringBuilder;
        }
        textView.setText(b);
        AppMethodBeat.o(78899);
    }

    public final void a(Context context, TextView textView, CharSequence charSequence) {
        AppMethodBeat.i(78900);
        if (textView instanceof EllipsizeTextView) {
            EllipsizeTextView ellipsizeTextView = (EllipsizeTextView) textView;
            ellipsizeTextView.setLayoutCallback(this.gfm);
            ellipsizeTextView.a(charSequence, " ", -1, (int) textView.getTextSize());
            AppMethodBeat.o(78900);
            return;
        }
        textView.setText(((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).a(context, charSequence));
        AppMethodBeat.o(78900);
    }

    public final CharSequence a(Context context, String str, String str2, float f) {
        AppMethodBeat.i(78901);
        Bitmap vh = vh(str);
        if (vh != null) {
            SpannableString b = j.b(context, "  ".concat(String.valueOf(str2)), f);
            int fromDPToPix = (int) (((float) com.tencent.mm.bz.a.fromDPToPix(context, 2)) + f);
            ImageSpan imageSpan = new ImageSpan(ah.getContext(), vh);
            imageSpan.getDrawable().setBounds(0, 0, fromDPToPix, fromDPToPix);
            b.setSpan(imageSpan, 0, 1, 33);
            AppMethodBeat.o(78901);
            return b;
        }
        AppMethodBeat.o(78901);
        return str2;
    }

    public final Bitmap vh(String str) {
        AppMethodBeat.i(78902);
        final a aVar = new a(this, (byte) 0);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(78902);
            return null;
        }
        com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
        aVar2.ePH = true;
        aVar2.ePJ = anx() + com.tencent.mm.a.g.x(str.getBytes());
        o.ahp().a(str, null, aVar2.ahG(), new com.tencent.mm.at.a.c.g() {
            public final void sH(String str) {
            }

            public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                return null;
            }

            public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                AppMethodBeat.i(78892);
                if (!(bVar.status != 0 || bVar.bitmap == null || bVar.bitmap.isRecycled())) {
                    aVar.bitmap = bVar.bitmap;
                }
                AppMethodBeat.o(78892);
            }
        });
        Bitmap bitmap = aVar.bitmap;
        AppMethodBeat.o(78902);
        return bitmap;
    }

    public final int vi(String str) {
        AppMethodBeat.i(78903);
        c cVar = new c();
        cVar.field_appid = str;
        g.RQ();
        ((PluginOpenIM) g.M(PluginOpenIM.class)).getAppIdInfoStg().b((com.tencent.mm.sdk.e.c) cVar, "appid");
        if (cVar.xDa == -1) {
            vl(str);
            AppMethodBeat.o(78903);
            return 0;
        }
        int i = cVar.field_appRec.vFv;
        AppMethodBeat.o(78903);
        return i;
    }

    public final String a(String str, String str2, com.tencent.mm.openim.a.b.a aVar) {
        AppMethodBeat.i(78904);
        c cVar = new c();
        cVar.field_appid = str;
        g.RQ();
        ((PluginOpenIM) g.M(PluginOpenIM.class)).getAppIdInfoStg().b((com.tencent.mm.sdk.e.c) cVar, "appid");
        if (cVar.xDa == -1) {
            vl(str);
            AppMethodBeat.o(78904);
            return null;
        }
        String a = a(cVar.field_acctTypeId, str2, aVar, aa.gw(ah.getContext()));
        if (a == null) {
            a = a(cVar.field_acctTypeId, str2, aVar, "en");
        }
        AppMethodBeat.o(78904);
        return a;
    }

    public final String b(String str, String str2, com.tencent.mm.openim.a.b.a aVar) {
        AppMethodBeat.i(78905);
        String a = a(str, str2, aVar, aa.gw(ah.getContext()));
        if (a == null) {
            a = a(str, str2, aVar, "en");
        }
        AppMethodBeat.o(78905);
        return a;
    }

    private static String a(String str, String str2, com.tencent.mm.openim.a.b.a aVar, String str3) {
        AppMethodBeat.i(78906);
        com.tencent.mm.openim.e.a aVar2 = new com.tencent.mm.openim.e.a();
        aVar2.field_acctTypeId = str;
        aVar2.field_language = str3;
        g.RQ();
        ((PluginOpenIM) g.M(PluginOpenIM.class)).getAccTypeInfoStg().b((com.tencent.mm.sdk.e.c) aVar2, "acctTypeId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        Iterator it;
        String str4;
        if (aVar2.xDa == -1) {
            AppMethodBeat.o(78906);
            return null;
        } else if (aVar == com.tencent.mm.openim.a.b.a.TYPE_WORDING) {
            it = aVar2.field_accTypeRec.vCr.iterator();
            while (it.hasNext()) {
                bhb bhb = (bhb) it.next();
                if (str2.equals(bhb.key)) {
                    str4 = bhb.cEh;
                    AppMethodBeat.o(78906);
                    return str4;
                }
            }
            AppMethodBeat.o(78906);
            return null;
        } else {
            it = aVar2.field_accTypeRec.ckO.iterator();
            while (it.hasNext()) {
                bha bha = (bha) it.next();
                if (str2.equals(bha.key)) {
                    str4 = bha.url;
                    AppMethodBeat.o(78906);
                    return str4;
                }
            }
            AppMethodBeat.o(78906);
            return null;
        }
    }

    public final String c(String str, String str2, com.tencent.mm.openim.a.b.a aVar) {
        AppMethodBeat.i(78907);
        String b = b(str, str2, aVar, aa.gw(ah.getContext()));
        if (b == null) {
            b = b(str, str2, aVar, "en");
        }
        AppMethodBeat.o(78907);
        return b;
    }

    private String b(String str, String str2, com.tencent.mm.openim.a.b.a aVar, String str3) {
        AppMethodBeat.i(78908);
        c cVar = new c();
        cVar.field_appid = str;
        cVar.field_language = str3;
        g.RQ();
        ((PluginOpenIM) g.M(PluginOpenIM.class)).getAppIdInfoStg().b((com.tencent.mm.sdk.e.c) cVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        Iterator it;
        String str4;
        if (cVar.xDa == -1) {
            bb(str, str3);
            AppMethodBeat.o(78908);
            return null;
        } else if (aVar == com.tencent.mm.openim.a.b.a.TYPE_WORDING) {
            it = cVar.field_appRec.vCr.iterator();
            while (it.hasNext()) {
                bhb bhb = (bhb) it.next();
                if (str2.equals(bhb.key)) {
                    str4 = bhb.cEh;
                    AppMethodBeat.o(78908);
                    return str4;
                }
            }
            AppMethodBeat.o(78908);
            return null;
        } else {
            it = cVar.field_appRec.ckO.iterator();
            while (it.hasNext()) {
                bha bha = (bha) it.next();
                if (str2.equals(bha.key)) {
                    str4 = bha.url;
                    AppMethodBeat.o(78908);
                    return str4;
                }
            }
            AppMethodBeat.o(78908);
            return null;
        }
    }

    public final String ba(String str, String str2) {
        AppMethodBeat.i(78909);
        String v = v(str, str2, aa.gw(ah.getContext()));
        if (v == null) {
            v = v(str, str2, "en");
        }
        AppMethodBeat.o(78909);
        return v;
    }

    public final void anw() {
        AppMethodBeat.i(78910);
        ((PluginOpenIM) g.M(PluginOpenIM.class)).getAppIdInfoStg().fni.delete("OpenIMAppIdInfo", null, null);
        ((PluginOpenIM) g.M(PluginOpenIM.class)).getAccTypeInfoStg().fni.delete("OpenIMAccTypeInfo", null, null);
        ((PluginOpenIM) g.M(PluginOpenIM.class)).getWordingInfoStg().fni.delete("OpenIMWordingInfo", null, null);
        AppMethodBeat.o(78910);
    }

    private String v(String str, String str2, String str3) {
        AppMethodBeat.i(78911);
        com.tencent.mm.openim.e.e eVar = new com.tencent.mm.openim.e.e();
        eVar.field_appid = str;
        eVar.field_language = str3;
        eVar.field_wordingId = str2;
        g.RQ();
        ((PluginOpenIM) g.M(PluginOpenIM.class)).getWordingInfoStg().b((com.tencent.mm.sdk.e.c) eVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "wordingId");
        if (eVar.xDa == -1) {
            u(str, str3, str2);
            AppMethodBeat.o(78911);
            return null;
        }
        String str4 = eVar.field_wording;
        AppMethodBeat.o(78911);
        return str4;
    }

    private void vl(String str) {
        AppMethodBeat.i(78912);
        bb(str, aa.gw(ah.getContext()));
        AppMethodBeat.o(78912);
    }

    private void bb(String str, String str2) {
        AppMethodBeat.i(78913);
        u(str, str2, "");
        AppMethodBeat.o(78913);
    }

    public final void u(String str, String str2, String str3) {
        AppMethodBeat.i(78914);
        ab.i("MicroMsg.Openim.OpenImResourceMgr", "try checkDoSceneGetRec openimAppId %s language %s wordingid %s", str, str2, str3);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(78914);
            return;
        }
        b bVar;
        if (!this.gfk.containsKey(str + str2)) {
            bVar = new b(this, (byte) 0);
            if (!bo.isNullOrNil(str3)) {
                bVar.gfq.add(str3);
            }
            this.gfk.put(str + str2, bVar);
            g.RO().eJo.a(new i(str, str2, bVar.gfq), 0);
        }
        if (bo.isNullOrNil(str3)) {
            AppMethodBeat.o(78914);
            return;
        }
        bVar = (b) this.gfk.get(str + str2);
        if (bVar.gfp.contains(str3) || bVar.gfq.contains(str3)) {
            AppMethodBeat.o(78914);
            return;
        }
        bVar.gfp.add(str3);
        AppMethodBeat.o(78914);
    }

    public final void aZ(String str, String str2) {
        boolean z;
        AppMethodBeat.i(78915);
        StringBuffer stringBuffer = new StringBuffer();
        c cVar = new c();
        cVar.field_appid = str;
        cVar.field_language = aa.gw(ah.getContext());
        g.RQ();
        ((PluginOpenIM) g.M(PluginOpenIM.class)).getAppIdInfoStg().b((com.tencent.mm.sdk.e.c) cVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        stringBuffer.append(String.format("openIMAppIdinfo.field_updateTime %s | ", new Object[]{Long.valueOf(cVar.field_updateTime)}));
        if (cVar.xDa == -1 || bo.fp(cVar.field_updateTime) > 172800) {
            z = true;
        } else {
            z = false;
        }
        if (!(z || bo.isNullOrNil(str2))) {
            boolean z2;
            com.tencent.mm.openim.e.e eVar = new com.tencent.mm.openim.e.e();
            eVar.field_appid = str;
            eVar.field_language = aa.gw(ah.getContext());
            eVar.field_wordingId = str2;
            g.RQ();
            ((PluginOpenIM) g.M(PluginOpenIM.class)).getWordingInfoStg().b((com.tencent.mm.sdk.e.c) eVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "wordingId");
            if (eVar.xDa == -1 || bo.fp(eVar.field_updateTime) > 172800) {
                z2 = true;
            } else {
                z2 = z;
            }
            stringBuffer.append(String.format("wordingInfo.field_updateTime %s | ", new Object[]{Long.valueOf(eVar.field_updateTime)}));
            z = z2;
        }
        ab.i("MicroMsg.Openim.OpenImResourceMgr", "checkRecUpdate openimAppId %s wordingId %s needUpdate %s logBuffer: %s", str, str2, Boolean.valueOf(z), stringBuffer.toString());
        if (z) {
            u(str, aa.gw(ah.getContext()), str2);
        }
        AppMethodBeat.o(78915);
    }
}
