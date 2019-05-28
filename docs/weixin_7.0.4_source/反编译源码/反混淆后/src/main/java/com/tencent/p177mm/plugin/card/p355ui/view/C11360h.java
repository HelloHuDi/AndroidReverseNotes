package com.tencent.p177mm.plugin.card.p355ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.p081b.p082a.p083a.C8501t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p352b.C20123j.C20125b;
import com.tencent.p177mm.plugin.card.p931d.C27577p;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42839c;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.card.ui.view.h */
public abstract class C11360h implements C45799ab {
    protected MMActivity jiE;
    protected C11358g kqH;

    public abstract boolean bet();

    public abstract boolean beu();

    public C11360h(C11358g c11358g, MMActivity mMActivity) {
        this.kqH = c11358g;
        this.jiE = mMActivity;
    }

    /* renamed from: c */
    public void mo23074c(ViewGroup viewGroup, final C42837b c42837b) {
        if (bet()) {
            TextView textView = (TextView) viewGroup.findViewById(2131821958);
            String str = this.kqH.code;
            if (c42837b.aZQ() || (!C5046bo.isNullOrNil(str) && str.length() <= 40)) {
                textView.setText(C45778m.m84640Hu(str));
                if (c42837b.aZL()) {
                    textView.setVisibility(0);
                    textView.setOnLongClickListener(new OnLongClickListener() {
                        public final boolean onLongClick(View view) {
                            AppMethodBeat.m2504i(88745);
                            if (view.getId() == 2131821958) {
                                C27577p.m43810wG(c42837b.aZW().code);
                                C30379h.m48465bQ(C11360h.this.jiE, C1183p.getString(C25738R.string.f9083oz));
                            }
                            AppMethodBeat.m2505o(88745);
                            return false;
                        }
                    });
                    this.kqH.mo23067d(C42839c.CARDCODEREFRESHACTION_ENTERCHANGE);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
        if (beu()) {
            LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(2131821970);
            if (c42837b == null || c42837b.aZV() == null || c42837b.aZV().vUA == null || C5046bo.isNullOrNil(c42837b.aZV().vUA.title)) {
                linearLayout.setVisibility(8);
                return;
            }
            viewGroup.findViewById(2131821969).setVisibility(8);
            linearLayout.setVisibility(0);
            C23446tm c23446tm = c42837b.aZV().vUA;
            TextView textView2 = (TextView) viewGroup.findViewById(2131821971);
            textView2.setText(c23446tm.title);
            String str2 = c42837b.aZV().color;
            if (!C5046bo.isNullOrNil(str2)) {
                textView2.setTextColor(C38736l.m65701Hn(str2));
            }
            textView2 = (TextView) viewGroup.findViewById(2131821972);
            String str3 = c23446tm.kbX;
            if (TextUtils.isEmpty(str3)) {
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else if (textView2 != null) {
                textView2.setText(str3);
                textView2.setVisibility(0);
            }
            linearLayout.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(88746);
                    if (c42837b.aZP()) {
                        C20125b c20125b = new C20125b();
                        C45774b.m84624a(C11360h.this.kqH.jiE, c20125b.kbK, c20125b.kbL, false, c42837b);
                    } else {
                        C23446tm c23446tm = c42837b.aZV().vUA;
                        if (c23446tm != null && !C5046bo.isNullOrNil(c23446tm.vTM) && !C5046bo.isNullOrNil(c23446tm.vTL)) {
                            int intExtra;
                            int intExtra2;
                            if (C11360h.this.jiE.getIntent() != null) {
                                intExtra = C11360h.this.jiE.getIntent().getIntExtra("key_from_scene", 3);
                            } else {
                                intExtra = 3;
                            }
                            if (C11360h.this.jiE.getIntent() != null) {
                                intExtra2 = C11360h.this.jiE.getIntent().getIntExtra("key_from_appbrand_type", 0);
                            } else {
                                intExtra2 = 0;
                            }
                            C45774b.m84629a(c42837b.aZZ(), c23446tm, intExtra, intExtra2);
                            C7060h.pYm.mo8381e(11941, Integer.valueOf(20), c42837b.aZZ(), c42837b.baa(), "", c23446tm.title);
                        } else if (!(c23446tm == null || TextUtils.isEmpty(c23446tm.url))) {
                            C45774b.m84626a(C11360h.this.kqH.jiE, C38736l.m65699A(c23446tm.url, c23446tm.vUW), 1);
                            C7060h.pYm.mo8381e(11941, Integer.valueOf(9), c42837b.aZZ(), c42837b.baa(), "", c23446tm.title);
                            if (C38736l.m65714a(c23446tm, c42837b.aZZ())) {
                                C38736l.m65706Hs(c42837b.aZZ());
                                C45774b.m84633b(C11360h.this.kqH.jiE, c42837b.aZV().kdg);
                            }
                        }
                    }
                    C8501t.finish();
                    AppMethodBeat.m2505o(88746);
                }
            });
        }
    }

    /* renamed from: g */
    public boolean mo23075g(C42837b c42837b) {
        return true;
    }

    /* renamed from: l */
    public void mo23076l(ViewGroup viewGroup) {
    }
}
