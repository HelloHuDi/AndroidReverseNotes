package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.luckymoney.model.C43255as;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C23243g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40461n;
import com.tencent.p177mm.protocal.C46516g;
import com.tencent.p177mm.protocal.protobuf.atb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.h */
public final class C21249h {

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.h$a */
    static class C3428a implements C21255d {
        C21253c ogG;

        C3428a() {
        }

        /* renamed from: a */
        public final void mo7861a(final Context context, ViewGroup viewGroup, final C43255as c43255as) {
            AppMethodBeat.m2504i(42894);
            if (C5046bo.isNullOrNil(c43255as.name)) {
                C4990ab.m7420w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
                viewGroup.setVisibility(8);
                AppMethodBeat.m2505o(42894);
                return;
            }
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ScaleType.FIT_XY);
            C46063x.m85819h(imageView, c43255as.name);
            if (!C5046bo.isNullOrNil(c43255as.content)) {
                imageView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(42893);
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(c43255as.nZn));
                        if (C3428a.this.ogG != null) {
                            C46516g.m87805gu(C3428a.this.ogG.ogM, 1);
                        }
                        C36391e.m60016n(context, c43255as.content, true);
                        AppMethodBeat.m2505o(42893);
                    }
                });
            }
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            viewGroup.addView(imageView);
            viewGroup.setVisibility(0);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(c43255as.nZn));
            if (this.ogG != null) {
                C46516g.m87805gu(this.ogG.ogM, 0);
            }
            AppMethodBeat.m2505o(42894);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.h$b */
    static class C21250b implements C21255d {
        C21253c ogG;

        C21250b() {
        }

        /* renamed from: a */
        public final void mo7861a(final Context context, ViewGroup viewGroup, final C43255as c43255as) {
            AppMethodBeat.m2504i(42897);
            if (C5046bo.isNullOrNil(c43255as.name)) {
                AppMethodBeat.m2505o(42897);
                return;
            }
            TextView textView = new TextView(context);
            if (this.ogG == null || this.ogG.textColor == C8415j.INVALID_ID) {
                textView.setTextColor(context.getResources().getColor(C25738R.color.a4m));
            } else {
                textView.setTextColor(this.ogG.textColor);
            }
            if (this.ogG == null || this.ogG.textSize == C8415j.INVALID_ID) {
                textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(C25738R.dimen.f9936kr));
            } else {
                textView.setTextSize(0, (float) this.ogG.textSize);
            }
            textView.setGravity(17);
            textView.setText(c43255as.name);
            if (!C5046bo.isNullOrNil(c43255as.content)) {
                textView.setOnClickListener(new OnClickListener() {

                    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.h$b$1$1 */
                    class C212521 implements C40461n {
                        C212521() {
                        }

                        /* renamed from: nZ */
                        public final void mo6042nZ(int i) {
                            AppMethodBeat.m2504i(42895);
                            switch (i) {
                                case -2:
                                case 1:
                                    C36391e.m59993ag(context, c43255as.content);
                                    break;
                            }
                            AppMethodBeat.m2505o(42895);
                        }
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(42896);
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(c43255as.nZn));
                        if (c43255as.nZo != 1) {
                            ((C23243g) C1720g.m3528K(C23243g.class)).mo9882a(context, c43255as.content, new C212521()).show();
                            AppMethodBeat.m2505o(42896);
                            return;
                        }
                        C36391e.m59991ae(context, c43255as.content);
                        AppMethodBeat.m2505o(42896);
                    }
                });
            }
            viewGroup.addView(textView, new LayoutParams(-2, -2));
            viewGroup.setVisibility(0);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(c43255as.nZn));
            AppMethodBeat.m2505o(42897);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.h$c */
    public static final class C21253c {
        public boolean ogL = false;
        public int ogM = 0;
        public atb ogN;
        public int resourceId = 0;
        public int textColor = C8415j.INVALID_ID;
        public int textSize = C8415j.INVALID_ID;
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.h$e */
    static class C21254e implements C21255d {
        C21253c ogG;

        C21254e() {
        }

        /* renamed from: a */
        public final void mo7861a(final Context context, ViewGroup viewGroup, final C43255as c43255as) {
            AppMethodBeat.m2504i(42899);
            if (C5046bo.isNullOrNil(c43255as.name)) {
                AppMethodBeat.m2505o(42899);
                return;
            }
            View inflate = LayoutInflater.from(context).inflate(2130969999, viewGroup, true);
            TextView textView = (TextView) inflate.findViewById(2131825669);
            ImageView imageView = (ImageView) inflate.findViewById(2131825668);
            if (C5046bo.isNullOrNil(c43255as.iconUrl)) {
                imageView.setVisibility(8);
            } else {
                C46063x.m85819h(imageView, c43255as.iconUrl);
                imageView.setVisibility(0);
            }
            if (!(this.ogG == null || this.ogG.textColor == C8415j.INVALID_ID)) {
                textView.setTextColor(this.ogG.textColor);
            }
            if (this.ogG == null || this.ogG.textSize == C8415j.INVALID_ID) {
                textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(C25738R.dimen.f9936kr));
            } else {
                textView.setTextSize(0, (float) this.ogG.textSize);
            }
            textView.setGravity(17);
            textView.setText(c43255as.name);
            if (!C5046bo.isNullOrNil(c43255as.content)) {
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(42898);
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(c43255as.nZn));
                        if (C21254e.this.ogG != null) {
                            C46516g.m87805gu(C21254e.this.ogG.ogM, 1);
                        }
                        if (C21254e.this.ogG != null && C21254e.this.ogG.ogL) {
                            C7060h.pYm.mo8381e(13051, Integer.valueOf(C21254e.this.ogG.ogM), Integer.valueOf(2), "", "", "", c43255as.content, c43255as.type, "", "", Integer.valueOf(C21254e.this.ogG.resourceId));
                        }
                        if (c43255as.type.equals("Native")) {
                            C4990ab.m7416i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + c43255as.content);
                            if ("weixin://festival/gotoshake".equalsIgnoreCase(c43255as.content)) {
                                C4990ab.m7416i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                            }
                        } else {
                            C36391e.m60016n(context, c43255as.content, true);
                        }
                        C7060h c7060h = C7060h.pYm;
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(2);
                        objArr[1] = c43255as.content;
                        objArr[2] = C21254e.this.ogG.ogN != null ? C21254e.this.ogG.ogN.wwP : "";
                        c7060h.mo8381e(16589, objArr);
                        AppMethodBeat.m2505o(42898);
                    }
                });
            }
            viewGroup.setVisibility(0);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(c43255as.nZn));
            if (this.ogG != null) {
                C46516g.m87805gu(this.ogG.ogM, 0);
            }
            AppMethodBeat.m2505o(42899);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.h$d */
    interface C21255d {
        /* renamed from: a */
        void mo7861a(Context context, ViewGroup viewGroup, C43255as c43255as);
    }

    /* renamed from: a */
    public static void m32619a(Context context, ViewGroup viewGroup, C43255as c43255as, C21253c c21253c) {
        AppMethodBeat.m2504i(42900);
        if (c43255as == null) {
            AppMethodBeat.m2505o(42900);
            return;
        }
        C21249h.m32620a(context, viewGroup, c43255as, c21253c, c43255as.type);
        AppMethodBeat.m2505o(42900);
    }

    /* renamed from: a */
    public static void m32620a(Context context, ViewGroup viewGroup, C43255as c43255as, C21253c c21253c, String str) {
        AppMethodBeat.m2504i(42901);
        if (viewGroup == null || c43255as == null) {
            AppMethodBeat.m2505o(42901);
        } else if (c43255as.erD == 0) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + c43255as.erD);
            viewGroup.setVisibility(8);
            AppMethodBeat.m2505o(42901);
        } else if (!c43255as.type.equalsIgnoreCase(str)) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + c43255as.type + ", " + str);
            viewGroup.setVisibility(8);
            AppMethodBeat.m2505o(42901);
        } else if (str.equalsIgnoreCase("Text") || str.equalsIgnoreCase("Native")) {
            C21254e c21254e = new C21254e();
            c21254e.ogG = c21253c;
            c21254e.mo7861a(context, viewGroup, c43255as);
            AppMethodBeat.m2505o(42901);
        } else if (str.equalsIgnoreCase("Pic")) {
            C3428a c3428a = new C3428a();
            c3428a.ogG = c21253c;
            c3428a.mo7861a(context, viewGroup, c43255as);
            AppMethodBeat.m2505o(42901);
        } else {
            if (str.equalsIgnoreCase("Appid")) {
                C21250b c21250b = new C21250b();
                c21250b.ogG = c21253c;
                c21250b.mo7861a(context, viewGroup, c43255as);
            }
            AppMethodBeat.m2505o(42901);
        }
    }
}
