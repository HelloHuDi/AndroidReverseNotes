package com.tencent.mm.pluginsdk.ui.e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.o;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class p {
    private static Class<?>[] vsU = new Class[]{com.tencent.mm.ui.widget.a.class, n.class, ForegroundColorSpan.class};
    private static final f<String, SpannableString> vsy = new c(500);
    String hcl;
    private Context mContext;
    private TextView sW;
    private ArrayList<a> vsA;
    private ArrayList<r> vsB;
    boolean vsC;
    boolean vsD;
    boolean vsE;
    boolean vsF;
    boolean vsG;
    boolean vsH;
    boolean vsI;
    boolean vsJ;
    boolean vsK;
    boolean vsL;
    boolean vsM;
    boolean vsN;
    boolean vsO;
    boolean vsP;
    int vsQ;
    private int vsR;
    boolean vsS;
    Object vsT;
    private ArrayList<m> vsz;

    class a {
        private int end;
        private int start;

        a(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(a aVar) {
            return this.end > aVar.start && aVar.end > this.start;
        }
    }

    static {
        AppMethodBeat.i(79907);
        AppMethodBeat.o(79907);
    }

    public p(Context context) {
        AppMethodBeat.i(79883);
        this.vsz = new ArrayList();
        this.vsA = new ArrayList();
        this.vsB = new ArrayList();
        this.sW = null;
        this.vsC = false;
        this.vsD = true;
        this.vsE = false;
        this.vsF = false;
        this.vsG = true;
        this.vsH = true;
        this.vsI = false;
        this.vsJ = false;
        this.vsK = false;
        this.vsL = false;
        this.vsM = false;
        this.vsN = true;
        this.vsO = false;
        this.vsP = false;
        this.vsQ = 0;
        this.vsR = 0;
        this.mContext = null;
        this.vsS = false;
        this.vsz = new ArrayList();
        this.vsA = new ArrayList();
        this.vsB = new ArrayList();
        this.mContext = context;
        AppMethodBeat.o(79883);
    }

    public final p m(TextView textView) {
        AppMethodBeat.i(79884);
        this.sW = textView;
        if (textView != null) {
            this.mContext = this.sW.getContext();
        }
        AppMethodBeat.o(79884);
        return this;
    }

    private String O(CharSequence charSequence) {
        AppMethodBeat.i(79885);
        String str = charSequence + "@" + this.vsR + "@" + this.vsC + "@" + this.vsF + "@" + this.vsG + "@" + this.vsH + "@" + this.vsQ + "@" + this.vsS + "@" + this.vsK + "@" + this.vsL + "@" + this.vsM;
        AppMethodBeat.o(79885);
        return str;
    }

    public final SpannableString b(CharSequence charSequence, int i, boolean z) {
        AppMethodBeat.i(79886);
        SpannableString spannableString;
        if (charSequence == null) {
            spannableString = new SpannableString("");
            AppMethodBeat.o(79886);
            return spannableString;
        }
        this.vsR = i;
        String O = O(charSequence);
        if (z) {
            spannableString = (SpannableString) vsy.get(O);
            if (spannableString != null) {
                e(spannableString);
                f(spannableString);
                a(spannableString);
                AppMethodBeat.o(79886);
                return spannableString;
            }
        }
        SpannableString P = P(charSequence);
        if (this.vsS) {
            Iterator it = this.vsz.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                mVar.hcl = this.hcl;
                if (bo.isNullOrNil(mVar.url)) {
                    P.setSpan(new ForegroundColorSpan(mVar.linkColor), mVar.start, mVar.end, 33);
                } else if (mVar.start <= P.length() && mVar.end <= P.length()) {
                    P.setSpan(new n(this.vsQ, mVar), mVar.start, mVar.end, 33);
                }
            }
        }
        Iterator it2 = this.vsB.iterator();
        while (it2.hasNext()) {
            r rVar = (r) it2.next();
            if (rVar.start <= P.length() && rVar.end <= P.length()) {
                Drawable drawable = this.mContext.getResources().getDrawable(rVar.id);
                if (rVar.width <= 0 || rVar.height <= 0) {
                    int i2;
                    if (this.sW == null) {
                        i2 = (int) (((float) this.vsR) * 1.3f);
                    } else {
                        i2 = (int) (this.sW.getTextSize() * 1.3f);
                    }
                    drawable.setBounds(0, 0, i2, i2);
                } else {
                    drawable.setBounds(0, 0, com.tencent.mm.bz.a.fromDPToPix(this.mContext, rVar.width), com.tencent.mm.bz.a.fromDPToPix(this.mContext, rVar.height));
                }
                com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
                aVar.zLT = com.tencent.mm.bz.a.fromDPToPix(this.mContext, 2);
                P.setSpan(aVar, rVar.start, rVar.start + 1, 18);
            }
        }
        f(P);
        a(P);
        if (z) {
            vsy.k(O, new SpannableString(P));
        }
        AppMethodBeat.o(79886);
        return P;
    }

    private static void e(Spannable spannable) {
        AppMethodBeat.i(79887);
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            int i;
            for (Class isInstance : vsU) {
                if (isInstance.isInstance(obj)) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                spannable.removeSpan(obj);
            }
        }
        AppMethodBeat.o(79887);
    }

    private SpannableString P(CharSequence charSequence) {
        CharSequence charSequence2;
        AppMethodBeat.i(79888);
        this.vsz = new ArrayList();
        if (this.vsR <= 0) {
            if (this.sW != null) {
                this.vsR = (int) this.sW.getTextSize();
            } else {
                this.vsR = com.tencent.mm.bz.a.al(this.mContext, R.dimen.m5);
            }
        }
        if (this.vsz == null) {
            this.vsz = new ArrayList();
        }
        if (this.vsA == null) {
            this.vsA = new ArrayList();
        }
        this.vsz.clear();
        this.vsA.clear();
        if (o.t(charSequence) && this.vsN && com.tencent.mm.pluginsdk.ui.e.d.a.vrE != null && (com.tencent.mm.pluginsdk.ui.e.d.a.vrE.H(charSequence) || com.tencent.mm.pluginsdk.ui.e.d.a.vrE.G(charSequence))) {
            charSequence = charSequence.toString().replace(IOUtils.LINE_SEPARATOR_UNIX, "                                                                                                                                                                                                                                                                                                                        ");
        }
        if (this.vsC) {
            if (charSequence.toString().contains("data-miniprogram-appid")) {
                charSequence = S(charSequence);
            } else {
                charSequence = R(charSequence);
            }
        }
        if (this.vsK) {
            charSequence = Q(charSequence);
        }
        if (this.vsM) {
            charSequence = b(charSequence, this.vsP);
        }
        if (!this.vsN || com.tencent.mm.pluginsdk.ui.e.d.a.vrE == null) {
            charSequence2 = charSequence;
        } else {
            charSequence2 = com.tencent.mm.pluginsdk.ui.e.d.a.vrE.o(charSequence, this.vsR);
        }
        if (this.vsD) {
            T(charSequence2);
        }
        if (charSequence2 instanceof Spannable) {
            SpannableString spannableString = (SpannableString) charSequence2;
            AppMethodBeat.o(79888);
            return spannableString;
        }
        SpannableString spannableString2 = new SpannableString(charSequence2);
        AppMethodBeat.o(79888);
        return spannableString2;
    }

    private CharSequence Q(CharSequence charSequence) {
        AppMethodBeat.i(79889);
        Matcher matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrM.matcher(charSequence.toString());
        while (matcher.find()) {
            CharSequence replace;
            if (this.vsL) {
                replace = charSequence.toString().replace(matcher.group(0), "");
            } else {
                replace = charSequence.toString().replace(matcher.group(0), "  ");
                String group = matcher.group(1);
                int start = matcher.start();
                int i = start + 2;
                int identifier = this.mContext.getResources().getIdentifier(group.toLowerCase(), "drawable", this.mContext.getPackageName());
                if (identifier != 0) {
                    r rVar = new r(start, i, identifier);
                    if (!bo.isNullOrNil(group) && "original_label".equals(group)) {
                        rVar.height = 15;
                        rVar.width = 35;
                    }
                    this.vsB.add(rVar);
                } else {
                    ab.w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", group);
                }
            }
            matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrH.matcher(replace);
            charSequence = replace;
        }
        AppMethodBeat.o(79889);
        return charSequence;
    }

    private CharSequence b(CharSequence charSequence, boolean z) {
        String group;
        String group2;
        int parseColor;
        m mVar;
        AppMethodBeat.i(79890);
        int i = 0;
        CharSequence charSequence2 = charSequence;
        Matcher matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrK.matcher(charSequence);
        while (matcher.find()) {
            group = matcher.group(0);
            String group3 = matcher.group(1);
            group2 = matcher.group(2);
            String group4 = matcher.group(3);
            String replace = charSequence2.toString().replace(group, group4);
            int start = matcher.start(0);
            int length = group4.length() + start;
            if (start < 0 || length > charSequence.length()) {
                ab.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                charSequence2 = replace;
            } else {
                try {
                    parseColor = Color.parseColor(group3);
                } catch (Exception e) {
                    ab.w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s]", group3);
                    parseColor = 0;
                }
                if (bo.isNullOrNil(group2)) {
                    mVar = new m(start, length);
                    mVar.linkColor = parseColor;
                    this.vsz.add(mVar);
                    this.vsA.add(new a(start, length));
                } else {
                    mVar = a.a(this.mContext, group2, start, length, parseColor, parseColor & -1711276033);
                    if (mVar != null) {
                        if (this.vsT != null) {
                            mVar.data = this.vsT;
                        }
                        this.vsz.add(mVar);
                        this.vsA.add(new a(start, length));
                    }
                }
                i = 1;
                charSequence2 = replace;
                matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrK.matcher(replace);
            }
        }
        if (i == 0) {
            Matcher matcher2 = com.tencent.mm.pluginsdk.ui.e.i.a.vrL.matcher(charSequence);
            while (matcher2.find()) {
                group2 = matcher2.group(0);
                group = matcher2.group(1);
                String group5 = matcher2.group(2);
                if (group.length() >= 2) {
                    charSequence2 = charSequence2.toString().replace(group2, group5);
                    int start2 = matcher2.start(0);
                    parseColor = group5.length() + start2;
                    if (start2 < 0 || parseColor > charSequence.length()) {
                        ab.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start2), Integer.valueOf(parseColor), Integer.valueOf(charSequence.length()));
                    } else {
                        if (!an(group, start2, parseColor) && z) {
                            mVar = new m(group, 2147483646, null);
                            if (this.vsT != null) {
                                mVar.data = this.vsT;
                            }
                            mVar.start = start2;
                            mVar.end = parseColor;
                            if (!a(this.vsA, new a(start2, parseColor))) {
                                this.vsz.add(mVar);
                                this.vsA.add(new a(start2, parseColor));
                            }
                        }
                        matcher2 = com.tencent.mm.pluginsdk.ui.e.i.a.vrK.matcher(charSequence2);
                    }
                }
            }
        }
        AppMethodBeat.o(79890);
        return charSequence2;
    }

    private CharSequence R(CharSequence charSequence) {
        Matcher matcher;
        AppMethodBeat.i(79891);
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() < 1500) {
            matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrH.matcher(charSequence2);
        } else {
            matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrG.matcher(charSequence2);
        }
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group.length() >= 2) {
                StringBuilder stringBuilder = new StringBuilder();
                if (matcher.start(0) > 0) {
                    stringBuilder.append(charSequence2.substring(0, matcher.start(0)));
                }
                stringBuilder.append(group2);
                if (matcher.end(0) < charSequence2.length()) {
                    stringBuilder.append(charSequence2.substring(matcher.end(0), charSequence2.length()));
                }
                charSequence2 = stringBuilder.toString();
                int start = matcher.start(0);
                int length = group2.length() + start;
                if (start < 0 || length > charSequence.length()) {
                    ab.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                } else {
                    an(group, start, length);
                    if (charSequence2.length() < 1500) {
                        matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrH.matcher(charSequence2);
                    } else {
                        matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrG.matcher(charSequence2);
                    }
                }
            }
        }
        AppMethodBeat.o(79891);
        return charSequence2;
    }

    private CharSequence S(CharSequence charSequence) {
        Matcher matcher;
        String str;
        AppMethodBeat.i(79892);
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() < 1500) {
            matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrJ.matcher(charSequence2);
            str = charSequence2;
        } else {
            matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrI.matcher(charSequence2);
            str = charSequence2;
        }
        while (matcher.find()) {
            String group = matcher.group(0);
            String group2 = matcher.group(1);
            String group3 = matcher.group(2);
            Map z = br.z(group.replace(group2, " ").replace(group3, " "), "a");
            if (z == null) {
                ab.e("MicroMsg.SpanProcessor", "XmlParser parse return null, so continue");
            } else {
                int i;
                String str2 = (String) z.get(".a.$data-miniprogram-appid");
                charSequence2 = (String) z.get(".a.$data-miniprogram-path");
                int i2 = !bo.isNullOrNil(group2) ? 1 : 0;
                if (bo.isNullOrNil(str2)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i2 == 0 || i != 0) {
                    int length;
                    if (i == 0) {
                        ab.e("MicroMsg.SpanProcessor", "url && appId is null, continue");
                    } else if (this.vsL) {
                        charSequence2 = str.toString().replace(group, group3);
                        int start = matcher.start(0);
                        length = group3.length() + start;
                        m mVar = new m(group2, 45, null);
                        mVar.start = start;
                        mVar.end = length;
                        this.vsz.add(mVar);
                    } else {
                        String concat = "    ".concat(String.valueOf(group3));
                        str = str.toString().replace(group, concat);
                        length = matcher.start(0);
                        i2 = concat.length() + length;
                        this.vsB.add(new r(length + 1, length + 3, R.raw.spannable_app_brand_link_logo));
                        m mVar2 = new m(str2, 45, charSequence2);
                        mVar2.start = length + 4;
                        mVar2.end = i2;
                        this.vsz.add(mVar2);
                        charSequence2 = str;
                    }
                } else if (group2.length() >= 2) {
                    str2 = str.toString().replace(group, group3);
                    int start2 = matcher.start(0);
                    int length2 = group3.length() + start2;
                    if (start2 < 0 || length2 > charSequence.length()) {
                        ab.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start2), Integer.valueOf(length2), Integer.valueOf(charSequence.length()));
                        str = str2;
                    } else {
                        an(group2, start2, length2);
                        charSequence2 = str2;
                    }
                }
                if (charSequence2.length() < 1500) {
                    matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrJ.matcher(charSequence2);
                    str = charSequence2;
                } else {
                    matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrI.matcher(charSequence2);
                    str = charSequence2;
                }
            }
        }
        AppMethodBeat.o(79892);
        return str;
    }

    private void T(CharSequence charSequence) {
        AppMethodBeat.i(79893);
        if (this.vsG) {
            this.vsA.addAll(U(charSequence));
        }
        if (this.vsC) {
            this.vsA.addAll(W(charSequence));
        }
        if (this.vsE) {
            this.vsA.addAll(X(charSequence));
        }
        if (this.vsJ) {
            this.vsA.addAll(ab(charSequence));
        }
        if (this.vsH) {
            this.vsA.addAll(Y(charSequence));
        }
        if (this.vsF) {
            this.vsA.addAll(Z(charSequence));
        }
        if (this.vsI) {
            this.vsA.addAll(aa(charSequence));
        }
        if (this.vsO) {
            this.vsA.addAll(V(charSequence));
        }
        AppMethodBeat.o(79893);
    }

    private ArrayList<a> U(CharSequence charSequence) {
        int i = 2000;
        AppMethodBeat.i(79894);
        ArrayList arrayList = new ArrayList();
        Pattern pattern = com.tencent.mm.pluginsdk.ui.e.i.a.vrQ;
        if (charSequence.length() <= 2000) {
            i = charSequence.length();
        }
        Matcher matcher = pattern.matcher(charSequence.subSequence(0, i));
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            m mVar = new m(matcher.group(), 24, null);
            mVar.start = start;
            mVar.end = end;
            if (!a(this.vsA, new a(start, end))) {
                this.vsz.add(mVar);
                arrayList.add(new a(start, end));
            }
        }
        AppMethodBeat.o(79894);
        return arrayList;
    }

    private ArrayList<a> V(CharSequence charSequence) {
        int i = 2000;
        AppMethodBeat.i(79895);
        ArrayList arrayList = new ArrayList();
        Pattern pattern = com.tencent.mm.pluginsdk.ui.e.i.a.vrR;
        if (charSequence.length() <= 2000) {
            i = charSequence.length();
        }
        Matcher matcher = pattern.matcher(charSequence.subSequence(0, i));
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            m mVar = new m(matcher.group(), 48, null);
            mVar.start = start;
            mVar.end = end;
            if (!a(this.vsA, new a(start, end))) {
                this.vsz.add(mVar);
                arrayList.add(new a(start, end));
            }
        }
        AppMethodBeat.o(79895);
        return arrayList;
    }

    private ArrayList<a> W(CharSequence charSequence) {
        Matcher matcher;
        AppMethodBeat.i(79896);
        ArrayList arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() > 500) {
            matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrP.matcher(charSequence2.toLowerCase());
        } else {
            matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrO.matcher(charSequence2.toLowerCase());
        }
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.vsA, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                if (end < charSequence2.length()) {
                    char charAt = charSequence2.charAt(end);
                    if ('a' <= charAt && charAt <= 'z') {
                    }
                }
                m mVar = new m(charSequence2.substring(start, end), 1, this.vsT);
                mVar.start = start;
                mVar.end = end;
                this.vsz.add(mVar);
                arrayList.add(new a(start, end));
            }
        }
        AppMethodBeat.o(79896);
        return arrayList;
    }

    private ArrayList<a> X(CharSequence charSequence) {
        AppMethodBeat.i(79897);
        ArrayList arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() > 200) {
            AppMethodBeat.o(79897);
        } else {
            Matcher matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrW.matcher(charSequence2);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (!a(this.vsA, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                    m mVar = new m(charSequence2.substring(start, end), 44, this.vsT);
                    mVar.start = start;
                    mVar.end = end;
                    this.vsz.add(mVar);
                    arrayList.add(new a(start, end));
                }
            }
            AppMethodBeat.o(79897);
        }
        return arrayList;
    }

    private ArrayList<a> Y(CharSequence charSequence) {
        AppMethodBeat.i(79898);
        ArrayList arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrT.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.vsA, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                m mVar = new m(charSequence2.substring(start, end), 28, null);
                mVar.start = start;
                mVar.end = end;
                this.vsz.add(mVar);
                arrayList.add(new a(start, end));
            }
        }
        AppMethodBeat.o(79898);
        return arrayList;
    }

    private ArrayList<a> Z(CharSequence charSequence) {
        AppMethodBeat.i(79899);
        ArrayList arrayList = new ArrayList();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrS.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group();
            int i = end - start;
            if (group.startsWith("+")) {
                i--;
            }
            if ((!(i == 6 || i == 5) || "+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567+95017".contains(group)) && i < 24 && !a(this.vsA, new a(start, end))) {
                m mVar = new m(group, 25, this.vsT);
                mVar.start = start;
                mVar.end = end;
                this.vsz.add(mVar);
                arrayList.add(new a(start, end));
            }
        }
        AppMethodBeat.o(79899);
        return arrayList;
    }

    private ArrayList<a> aa(CharSequence charSequence) {
        AppMethodBeat.i(79900);
        ArrayList arrayList = new ArrayList();
        Iterator it = a.bB(this.mContext, charSequence.toString()).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            a aVar = new a(mVar.start, mVar.end);
            if (!a(this.vsA, aVar)) {
                this.vsz.add(mVar);
                arrayList.add(aVar);
            }
        }
        AppMethodBeat.o(79900);
        return arrayList;
    }

    private ArrayList<a> ab(CharSequence charSequence) {
        int start;
        int end;
        a aVar;
        m mVar;
        AppMethodBeat.i(79901);
        ArrayList arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrV.matcher(charSequence2);
        while (matcher.find()) {
            start = matcher.start();
            end = matcher.end();
            aVar = new a(start, end);
            if (!a(this.vsA, aVar) && start >= 0 && end <= charSequence2.length()) {
                mVar = new m(charSequence2.substring(start, end), 30, null);
                mVar.start = start;
                mVar.end = end;
                this.vsz.add(mVar);
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() <= 0) {
            matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrU.matcher(charSequence2);
            while (matcher.find()) {
                start = matcher.start();
                end = matcher.end();
                aVar = new a(start, end);
                if (!a(this.vsA, aVar) && start >= 0 && end <= charSequence2.length()) {
                    mVar = new m(charSequence2.substring(start, end), 30, null);
                    mVar.start = start;
                    mVar.end = end;
                    this.vsz.add(mVar);
                    arrayList.add(aVar);
                }
            }
        }
        AppMethodBeat.o(79901);
        return arrayList;
    }

    private boolean an(String str, int i, int i2) {
        AppMethodBeat.i(79902);
        m a = a.a(this.mContext, str, i, i2);
        if (a != null) {
            if (this.vsT != null) {
                a.data = this.vsT;
            }
            this.vsz.add(a);
            this.vsA.add(new a(i, i2));
            AppMethodBeat.o(79902);
            return true;
        }
        AppMethodBeat.o(79902);
        return false;
    }

    private static boolean a(ArrayList<a> arrayList, a aVar) {
        AppMethodBeat.i(79903);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).a(aVar)) {
                AppMethodBeat.o(79903);
                return true;
            }
        }
        AppMethodBeat.o(79903);
        return false;
    }

    private void f(Spannable spannable) {
        AppMethodBeat.i(79904);
        if (!(this.sW == null || bo.isNullOrNil(spannable.toString()))) {
            if (ae.giY) {
                this.sW.setText(spannable, BufferType.SPANNABLE);
                AppMethodBeat.o(79904);
                return;
            }
            this.sW.setText(spannable);
        }
        AppMethodBeat.o(79904);
    }

    private void a(SpannableString spannableString) {
        int i = 0;
        AppMethodBeat.i(79905);
        if (this.sW != null) {
            m mVar = new m();
            mVar.hcl = this.hcl;
            this.sW.setOnTouchListener(mVar);
            AppMethodBeat.o(79905);
            return;
        }
        if (spannableString != null) {
            n[] nVarArr = (n[]) spannableString.getSpans(0, spannableString.length(), n.class);
            if (!(nVarArr == null || nVarArr.length <= 0 || this.hcl == null)) {
                int length = nVarArr.length;
                while (i < length) {
                    nVarArr[i].setSessionId(this.hcl);
                    i++;
                }
            }
        }
        AppMethodBeat.o(79905);
    }

    public static void clearCache() {
        AppMethodBeat.i(79906);
        vsy.clear();
        AppMethodBeat.o(79906);
    }
}
