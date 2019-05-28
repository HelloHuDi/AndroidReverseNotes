package com.tencent.p177mm.pluginsdk.p597ui.p598e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C18176o;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14932m;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C30112r;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23303d.C23304a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44088i.C30131a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.pluginsdk.ui.e.p */
final class C40488p {
    private static Class<?>[] vsU = new Class[]{C5664a.class, C23322n.class, ForegroundColorSpan.class};
    private static final C1177f<String, SpannableString> vsy = new C7598c(500);
    String hcl;
    private Context mContext;
    /* renamed from: sW */
    private TextView f16201sW;
    private ArrayList<C35872a> vsA;
    private ArrayList<C30112r> vsB;
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
    private ArrayList<C14932m> vsz;

    /* renamed from: com.tencent.mm.pluginsdk.ui.e.p$a */
    class C35872a {
        private int end;
        private int start;

        C35872a(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo56662a(C35872a c35872a) {
            return this.end > c35872a.start && c35872a.end > this.start;
        }
    }

    static {
        AppMethodBeat.m2504i(79907);
        AppMethodBeat.m2505o(79907);
    }

    public C40488p(Context context) {
        AppMethodBeat.m2504i(79883);
        this.vsz = new ArrayList();
        this.vsA = new ArrayList();
        this.vsB = new ArrayList();
        this.f16201sW = null;
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
        AppMethodBeat.m2505o(79883);
    }

    /* renamed from: m */
    public final C40488p mo64022m(TextView textView) {
        AppMethodBeat.m2504i(79884);
        this.f16201sW = textView;
        if (textView != null) {
            this.mContext = this.f16201sW.getContext();
        }
        AppMethodBeat.m2505o(79884);
        return this;
    }

    /* renamed from: O */
    private String m69592O(CharSequence charSequence) {
        AppMethodBeat.m2504i(79885);
        String str = charSequence + "@" + this.vsR + "@" + this.vsC + "@" + this.vsF + "@" + this.vsG + "@" + this.vsH + "@" + this.vsQ + "@" + this.vsS + "@" + this.vsK + "@" + this.vsL + "@" + this.vsM;
        AppMethodBeat.m2505o(79885);
        return str;
    }

    /* renamed from: b */
    public final SpannableString mo64021b(CharSequence charSequence, int i, boolean z) {
        AppMethodBeat.m2504i(79886);
        SpannableString spannableString;
        if (charSequence == null) {
            spannableString = new SpannableString("");
            AppMethodBeat.m2505o(79886);
            return spannableString;
        }
        this.vsR = i;
        String O = m69592O(charSequence);
        if (z) {
            spannableString = (SpannableString) vsy.get(O);
            if (spannableString != null) {
                C40488p.m69610e(spannableString);
                m69611f(spannableString);
                m69604a(spannableString);
                AppMethodBeat.m2505o(79886);
                return spannableString;
            }
        }
        SpannableString P = m69593P(charSequence);
        if (this.vsS) {
            Iterator it = this.vsz.iterator();
            while (it.hasNext()) {
                C14932m c14932m = (C14932m) it.next();
                c14932m.hcl = this.hcl;
                if (C5046bo.isNullOrNil(c14932m.url)) {
                    P.setSpan(new ForegroundColorSpan(c14932m.linkColor), c14932m.start, c14932m.end, 33);
                } else if (c14932m.start <= P.length() && c14932m.end <= P.length()) {
                    P.setSpan(new C23322n(this.vsQ, c14932m), c14932m.start, c14932m.end, 33);
                }
            }
        }
        Iterator it2 = this.vsB.iterator();
        while (it2.hasNext()) {
            C30112r c30112r = (C30112r) it2.next();
            if (c30112r.start <= P.length() && c30112r.end <= P.length()) {
                Drawable drawable = this.mContext.getResources().getDrawable(c30112r.f13730id);
                if (c30112r.width <= 0 || c30112r.height <= 0) {
                    int i2;
                    if (this.f16201sW == null) {
                        i2 = (int) (((float) this.vsR) * 1.3f);
                    } else {
                        i2 = (int) (this.f16201sW.getTextSize() * 1.3f);
                    }
                    drawable.setBounds(0, 0, i2, i2);
                } else {
                    drawable.setBounds(0, 0, C1338a.fromDPToPix(this.mContext, c30112r.width), C1338a.fromDPToPix(this.mContext, c30112r.height));
                }
                C5664a c5664a = new C5664a(drawable);
                c5664a.zLT = C1338a.fromDPToPix(this.mContext, 2);
                P.setSpan(c5664a, c30112r.start, c30112r.start + 1, 18);
            }
        }
        m69611f(P);
        m69604a(P);
        if (z) {
            vsy.mo4412k(O, new SpannableString(P));
        }
        AppMethodBeat.m2505o(79886);
        return P;
    }

    /* renamed from: e */
    private static void m69610e(Spannable spannable) {
        AppMethodBeat.m2504i(79887);
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
        AppMethodBeat.m2505o(79887);
    }

    /* renamed from: P */
    private SpannableString m69593P(CharSequence charSequence) {
        CharSequence charSequence2;
        AppMethodBeat.m2504i(79888);
        this.vsz = new ArrayList();
        if (this.vsR <= 0) {
            if (this.f16201sW != null) {
                this.vsR = (int) this.f16201sW.getTextSize();
            } else {
                this.vsR = C1338a.m2856al(this.mContext, C25738R.dimen.f9980m5);
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
        if (C18176o.m28622t(charSequence) && this.vsN && C23304a.vrE != null && (C23304a.vrE.mo20621H(charSequence) || C23304a.vrE.mo20620G(charSequence))) {
            charSequence = charSequence.toString().replace(IOUtils.LINE_SEPARATOR_UNIX, "                                                                                                                                                                                                                                                                                                                        ");
        }
        if (this.vsC) {
            if (charSequence.toString().contains("data-miniprogram-appid")) {
                charSequence = m69596S(charSequence);
            } else {
                charSequence = m69595R(charSequence);
            }
        }
        if (this.vsK) {
            charSequence = m69594Q(charSequence);
        }
        if (this.vsM) {
            charSequence = m69609b(charSequence, this.vsP);
        }
        if (!this.vsN || C23304a.vrE == null) {
            charSequence2 = charSequence;
        } else {
            charSequence2 = C23304a.vrE.mo20623o(charSequence, this.vsR);
        }
        if (this.vsD) {
            m69597T(charSequence2);
        }
        if (charSequence2 instanceof Spannable) {
            SpannableString spannableString = (SpannableString) charSequence2;
            AppMethodBeat.m2505o(79888);
            return spannableString;
        }
        SpannableString spannableString2 = new SpannableString(charSequence2);
        AppMethodBeat.m2505o(79888);
        return spannableString2;
    }

    /* renamed from: Q */
    private CharSequence m69594Q(CharSequence charSequence) {
        AppMethodBeat.m2504i(79889);
        Matcher matcher = C30131a.vrM.matcher(charSequence.toString());
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
                    C30112r c30112r = new C30112r(start, i, identifier);
                    if (!C5046bo.isNullOrNil(group) && "original_label".equals(group)) {
                        c30112r.height = 15;
                        c30112r.width = 35;
                    }
                    this.vsB.add(c30112r);
                } else {
                    C4990ab.m7421w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", group);
                }
            }
            matcher = C30131a.vrH.matcher(replace);
            charSequence = replace;
        }
        AppMethodBeat.m2505o(79889);
        return charSequence;
    }

    /* renamed from: b */
    private CharSequence m69609b(CharSequence charSequence, boolean z) {
        String group;
        String group2;
        int parseColor;
        C14932m c14932m;
        AppMethodBeat.m2504i(79890);
        int i = 0;
        CharSequence charSequence2 = charSequence;
        Matcher matcher = C30131a.vrK.matcher(charSequence);
        while (matcher.find()) {
            group = matcher.group(0);
            String group3 = matcher.group(1);
            group2 = matcher.group(2);
            String group4 = matcher.group(3);
            String replace = charSequence2.toString().replace(group, group4);
            int start = matcher.start(0);
            int length = group4.length() + start;
            if (start < 0 || length > charSequence.length()) {
                C4990ab.m7413e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                charSequence2 = replace;
            } else {
                try {
                    parseColor = Color.parseColor(group3);
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s]", group3);
                    parseColor = 0;
                }
                if (C5046bo.isNullOrNil(group2)) {
                    c14932m = new C14932m(start, length);
                    c14932m.linkColor = parseColor;
                    this.vsz.add(c14932m);
                    this.vsA.add(new C35872a(start, length));
                } else {
                    c14932m = C46505a.m87787a(this.mContext, group2, start, length, parseColor, parseColor & -1711276033);
                    if (c14932m != null) {
                        if (this.vsT != null) {
                            c14932m.data = this.vsT;
                        }
                        this.vsz.add(c14932m);
                        this.vsA.add(new C35872a(start, length));
                    }
                }
                i = 1;
                charSequence2 = replace;
                matcher = C30131a.vrK.matcher(replace);
            }
        }
        if (i == 0) {
            Matcher matcher2 = C30131a.vrL.matcher(charSequence);
            while (matcher2.find()) {
                group2 = matcher2.group(0);
                group = matcher2.group(1);
                String group5 = matcher2.group(2);
                if (group.length() >= 2) {
                    charSequence2 = charSequence2.toString().replace(group2, group5);
                    int start2 = matcher2.start(0);
                    parseColor = group5.length() + start2;
                    if (start2 < 0 || parseColor > charSequence.length()) {
                        C4990ab.m7413e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start2), Integer.valueOf(parseColor), Integer.valueOf(charSequence.length()));
                    } else {
                        if (!m69608an(group, start2, parseColor) && z) {
                            c14932m = new C14932m(group, 2147483646, null);
                            if (this.vsT != null) {
                                c14932m.data = this.vsT;
                            }
                            c14932m.start = start2;
                            c14932m.end = parseColor;
                            if (!C40488p.m69605a(this.vsA, new C35872a(start2, parseColor))) {
                                this.vsz.add(c14932m);
                                this.vsA.add(new C35872a(start2, parseColor));
                            }
                        }
                        matcher2 = C30131a.vrK.matcher(charSequence2);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(79890);
        return charSequence2;
    }

    /* renamed from: R */
    private CharSequence m69595R(CharSequence charSequence) {
        Matcher matcher;
        AppMethodBeat.m2504i(79891);
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() < 1500) {
            matcher = C30131a.vrH.matcher(charSequence2);
        } else {
            matcher = C30131a.vrG.matcher(charSequence2);
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
                    C4990ab.m7413e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                } else {
                    m69608an(group, start, length);
                    if (charSequence2.length() < 1500) {
                        matcher = C30131a.vrH.matcher(charSequence2);
                    } else {
                        matcher = C30131a.vrG.matcher(charSequence2);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(79891);
        return charSequence2;
    }

    /* renamed from: S */
    private CharSequence m69596S(CharSequence charSequence) {
        Matcher matcher;
        String str;
        AppMethodBeat.m2504i(79892);
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() < 1500) {
            matcher = C30131a.vrJ.matcher(charSequence2);
            str = charSequence2;
        } else {
            matcher = C30131a.vrI.matcher(charSequence2);
            str = charSequence2;
        }
        while (matcher.find()) {
            String group = matcher.group(0);
            String group2 = matcher.group(1);
            String group3 = matcher.group(2);
            Map z = C5049br.m7595z(group.replace(group2, " ").replace(group3, " "), "a");
            if (z == null) {
                C4990ab.m7412e("MicroMsg.SpanProcessor", "XmlParser parse return null, so continue");
            } else {
                int i;
                String str2 = (String) z.get(".a.$data-miniprogram-appid");
                charSequence2 = (String) z.get(".a.$data-miniprogram-path");
                int i2 = !C5046bo.isNullOrNil(group2) ? 1 : 0;
                if (C5046bo.isNullOrNil(str2)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i2 == 0 || i != 0) {
                    int length;
                    if (i == 0) {
                        C4990ab.m7412e("MicroMsg.SpanProcessor", "url && appId is null, continue");
                    } else if (this.vsL) {
                        charSequence2 = str.toString().replace(group, group3);
                        int start = matcher.start(0);
                        length = group3.length() + start;
                        C14932m c14932m = new C14932m(group2, 45, null);
                        c14932m.start = start;
                        c14932m.end = length;
                        this.vsz.add(c14932m);
                    } else {
                        String concat = "    ".concat(String.valueOf(group3));
                        str = str.toString().replace(group, concat);
                        length = matcher.start(0);
                        i2 = concat.length() + length;
                        this.vsB.add(new C30112r(length + 1, length + 3, C1318a.spannable_app_brand_link_logo));
                        C14932m c14932m2 = new C14932m(str2, 45, charSequence2);
                        c14932m2.start = length + 4;
                        c14932m2.end = i2;
                        this.vsz.add(c14932m2);
                        charSequence2 = str;
                    }
                } else if (group2.length() >= 2) {
                    str2 = str.toString().replace(group, group3);
                    int start2 = matcher.start(0);
                    int length2 = group3.length() + start2;
                    if (start2 < 0 || length2 > charSequence.length()) {
                        C4990ab.m7413e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start2), Integer.valueOf(length2), Integer.valueOf(charSequence.length()));
                        str = str2;
                    } else {
                        m69608an(group2, start2, length2);
                        charSequence2 = str2;
                    }
                }
                if (charSequence2.length() < 1500) {
                    matcher = C30131a.vrJ.matcher(charSequence2);
                    str = charSequence2;
                } else {
                    matcher = C30131a.vrI.matcher(charSequence2);
                    str = charSequence2;
                }
            }
        }
        AppMethodBeat.m2505o(79892);
        return str;
    }

    /* renamed from: T */
    private void m69597T(CharSequence charSequence) {
        AppMethodBeat.m2504i(79893);
        if (this.vsG) {
            this.vsA.addAll(m69598U(charSequence));
        }
        if (this.vsC) {
            this.vsA.addAll(m69600W(charSequence));
        }
        if (this.vsE) {
            this.vsA.addAll(m69601X(charSequence));
        }
        if (this.vsJ) {
            this.vsA.addAll(m69607ab(charSequence));
        }
        if (this.vsH) {
            this.vsA.addAll(m69602Y(charSequence));
        }
        if (this.vsF) {
            this.vsA.addAll(m69603Z(charSequence));
        }
        if (this.vsI) {
            this.vsA.addAll(m69606aa(charSequence));
        }
        if (this.vsO) {
            this.vsA.addAll(m69599V(charSequence));
        }
        AppMethodBeat.m2505o(79893);
    }

    /* renamed from: U */
    private ArrayList<C35872a> m69598U(CharSequence charSequence) {
        int i = 2000;
        AppMethodBeat.m2504i(79894);
        ArrayList arrayList = new ArrayList();
        Pattern pattern = C30131a.vrQ;
        if (charSequence.length() <= 2000) {
            i = charSequence.length();
        }
        Matcher matcher = pattern.matcher(charSequence.subSequence(0, i));
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            C14932m c14932m = new C14932m(matcher.group(), 24, null);
            c14932m.start = start;
            c14932m.end = end;
            if (!C40488p.m69605a(this.vsA, new C35872a(start, end))) {
                this.vsz.add(c14932m);
                arrayList.add(new C35872a(start, end));
            }
        }
        AppMethodBeat.m2505o(79894);
        return arrayList;
    }

    /* renamed from: V */
    private ArrayList<C35872a> m69599V(CharSequence charSequence) {
        int i = 2000;
        AppMethodBeat.m2504i(79895);
        ArrayList arrayList = new ArrayList();
        Pattern pattern = C30131a.vrR;
        if (charSequence.length() <= 2000) {
            i = charSequence.length();
        }
        Matcher matcher = pattern.matcher(charSequence.subSequence(0, i));
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            C14932m c14932m = new C14932m(matcher.group(), 48, null);
            c14932m.start = start;
            c14932m.end = end;
            if (!C40488p.m69605a(this.vsA, new C35872a(start, end))) {
                this.vsz.add(c14932m);
                arrayList.add(new C35872a(start, end));
            }
        }
        AppMethodBeat.m2505o(79895);
        return arrayList;
    }

    /* renamed from: W */
    private ArrayList<C35872a> m69600W(CharSequence charSequence) {
        Matcher matcher;
        AppMethodBeat.m2504i(79896);
        ArrayList arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() > 500) {
            matcher = C30131a.vrP.matcher(charSequence2.toLowerCase());
        } else {
            matcher = C30131a.vrO.matcher(charSequence2.toLowerCase());
        }
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!C40488p.m69605a(this.vsA, new C35872a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                if (end < charSequence2.length()) {
                    char charAt = charSequence2.charAt(end);
                    if ('a' <= charAt && charAt <= 'z') {
                    }
                }
                C14932m c14932m = new C14932m(charSequence2.substring(start, end), 1, this.vsT);
                c14932m.start = start;
                c14932m.end = end;
                this.vsz.add(c14932m);
                arrayList.add(new C35872a(start, end));
            }
        }
        AppMethodBeat.m2505o(79896);
        return arrayList;
    }

    /* renamed from: X */
    private ArrayList<C35872a> m69601X(CharSequence charSequence) {
        AppMethodBeat.m2504i(79897);
        ArrayList arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() > 200) {
            AppMethodBeat.m2505o(79897);
        } else {
            Matcher matcher = C30131a.vrW.matcher(charSequence2);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (!C40488p.m69605a(this.vsA, new C35872a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                    C14932m c14932m = new C14932m(charSequence2.substring(start, end), 44, this.vsT);
                    c14932m.start = start;
                    c14932m.end = end;
                    this.vsz.add(c14932m);
                    arrayList.add(new C35872a(start, end));
                }
            }
            AppMethodBeat.m2505o(79897);
        }
        return arrayList;
    }

    /* renamed from: Y */
    private ArrayList<C35872a> m69602Y(CharSequence charSequence) {
        AppMethodBeat.m2504i(79898);
        ArrayList arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = C30131a.vrT.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!C40488p.m69605a(this.vsA, new C35872a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                C14932m c14932m = new C14932m(charSequence2.substring(start, end), 28, null);
                c14932m.start = start;
                c14932m.end = end;
                this.vsz.add(c14932m);
                arrayList.add(new C35872a(start, end));
            }
        }
        AppMethodBeat.m2505o(79898);
        return arrayList;
    }

    /* renamed from: Z */
    private ArrayList<C35872a> m69603Z(CharSequence charSequence) {
        AppMethodBeat.m2504i(79899);
        ArrayList arrayList = new ArrayList();
        Matcher matcher = C30131a.vrS.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group();
            int i = end - start;
            if (group.startsWith("+")) {
                i--;
            }
            if ((!(i == 6 || i == 5) || "+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567+95017".contains(group)) && i < 24 && !C40488p.m69605a(this.vsA, new C35872a(start, end))) {
                C14932m c14932m = new C14932m(group, 25, this.vsT);
                c14932m.start = start;
                c14932m.end = end;
                this.vsz.add(c14932m);
                arrayList.add(new C35872a(start, end));
            }
        }
        AppMethodBeat.m2505o(79899);
        return arrayList;
    }

    /* renamed from: aa */
    private ArrayList<C35872a> m69606aa(CharSequence charSequence) {
        AppMethodBeat.m2504i(79900);
        ArrayList arrayList = new ArrayList();
        Iterator it = C46505a.m87788bB(this.mContext, charSequence.toString()).iterator();
        while (it.hasNext()) {
            C14932m c14932m = (C14932m) it.next();
            C35872a c35872a = new C35872a(c14932m.start, c14932m.end);
            if (!C40488p.m69605a(this.vsA, c35872a)) {
                this.vsz.add(c14932m);
                arrayList.add(c35872a);
            }
        }
        AppMethodBeat.m2505o(79900);
        return arrayList;
    }

    /* renamed from: ab */
    private ArrayList<C35872a> m69607ab(CharSequence charSequence) {
        int start;
        int end;
        C35872a c35872a;
        C14932m c14932m;
        AppMethodBeat.m2504i(79901);
        ArrayList arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = C30131a.vrV.matcher(charSequence2);
        while (matcher.find()) {
            start = matcher.start();
            end = matcher.end();
            c35872a = new C35872a(start, end);
            if (!C40488p.m69605a(this.vsA, c35872a) && start >= 0 && end <= charSequence2.length()) {
                c14932m = new C14932m(charSequence2.substring(start, end), 30, null);
                c14932m.start = start;
                c14932m.end = end;
                this.vsz.add(c14932m);
                arrayList.add(c35872a);
            }
        }
        if (arrayList.size() <= 0) {
            matcher = C30131a.vrU.matcher(charSequence2);
            while (matcher.find()) {
                start = matcher.start();
                end = matcher.end();
                c35872a = new C35872a(start, end);
                if (!C40488p.m69605a(this.vsA, c35872a) && start >= 0 && end <= charSequence2.length()) {
                    c14932m = new C14932m(charSequence2.substring(start, end), 30, null);
                    c14932m.start = start;
                    c14932m.end = end;
                    this.vsz.add(c14932m);
                    arrayList.add(c35872a);
                }
            }
        }
        AppMethodBeat.m2505o(79901);
        return arrayList;
    }

    /* renamed from: an */
    private boolean m69608an(String str, int i, int i2) {
        AppMethodBeat.m2504i(79902);
        C14932m a = C46505a.m87786a(this.mContext, str, i, i2);
        if (a != null) {
            if (this.vsT != null) {
                a.data = this.vsT;
            }
            this.vsz.add(a);
            this.vsA.add(new C35872a(i, i2));
            AppMethodBeat.m2505o(79902);
            return true;
        }
        AppMethodBeat.m2505o(79902);
        return false;
    }

    /* renamed from: a */
    private static boolean m69605a(ArrayList<C35872a> arrayList, C35872a c35872a) {
        AppMethodBeat.m2504i(79903);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((C35872a) it.next()).mo56662a(c35872a)) {
                AppMethodBeat.m2505o(79903);
                return true;
            }
        }
        AppMethodBeat.m2505o(79903);
        return false;
    }

    /* renamed from: f */
    private void m69611f(Spannable spannable) {
        AppMethodBeat.m2504i(79904);
        if (!(this.f16201sW == null || C5046bo.isNullOrNil(spannable.toString()))) {
            if (C1947ae.giY) {
                this.f16201sW.setText(spannable, BufferType.SPANNABLE);
                AppMethodBeat.m2505o(79904);
                return;
            }
            this.f16201sW.setText(spannable);
        }
        AppMethodBeat.m2505o(79904);
    }

    /* renamed from: a */
    private void m69604a(SpannableString spannableString) {
        int i = 0;
        AppMethodBeat.m2504i(79905);
        if (this.f16201sW != null) {
            C30132m c30132m = new C30132m();
            c30132m.hcl = this.hcl;
            this.f16201sW.setOnTouchListener(c30132m);
            AppMethodBeat.m2505o(79905);
            return;
        }
        if (spannableString != null) {
            C23322n[] c23322nArr = (C23322n[]) spannableString.getSpans(0, spannableString.length(), C23322n.class);
            if (!(c23322nArr == null || c23322nArr.length <= 0 || this.hcl == null)) {
                int length = c23322nArr.length;
                while (i < length) {
                    c23322nArr[i].setSessionId(this.hcl);
                    i++;
                }
            }
        }
        AppMethodBeat.m2505o(79905);
    }

    public static void clearCache() {
        AppMethodBeat.m2504i(79906);
        vsy.clear();
        AppMethodBeat.m2505o(79906);
    }
}
