package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.b.a.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.d.p;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public abstract class h implements ab {
    protected MMActivity jiE;
    protected g kqH;

    public abstract boolean bet();

    public abstract boolean beu();

    public h(g gVar, MMActivity mMActivity) {
        this.kqH = gVar;
        this.jiE = mMActivity;
    }

    public void c(ViewGroup viewGroup, final b bVar) {
        if (bet()) {
            TextView textView = (TextView) viewGroup.findViewById(R.id.aa7);
            String str = this.kqH.code;
            if (bVar.aZQ() || (!bo.isNullOrNil(str) && str.length() <= 40)) {
                textView.setText(m.Hu(str));
                if (bVar.aZL()) {
                    textView.setVisibility(0);
                    textView.setOnLongClickListener(new OnLongClickListener() {
                        public final boolean onLongClick(View view) {
                            AppMethodBeat.i(88745);
                            if (view.getId() == R.id.aa7) {
                                p.wG(bVar.aZW().code);
                                com.tencent.mm.ui.base.h.bQ(h.this.jiE, com.tencent.mm.a.p.getString(R.string.oz));
                            }
                            AppMethodBeat.o(88745);
                            return false;
                        }
                    });
                    this.kqH.d(c.CARDCODEREFRESHACTION_ENTERCHANGE);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
        if (beu()) {
            LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.aai);
            if (bVar == null || bVar.aZV() == null || bVar.aZV().vUA == null || bo.isNullOrNil(bVar.aZV().vUA.title)) {
                linearLayout.setVisibility(8);
                return;
            }
            viewGroup.findViewById(R.id.aah).setVisibility(8);
            linearLayout.setVisibility(0);
            tm tmVar = bVar.aZV().vUA;
            TextView textView2 = (TextView) viewGroup.findViewById(R.id.aaj);
            textView2.setText(tmVar.title);
            String str2 = bVar.aZV().color;
            if (!bo.isNullOrNil(str2)) {
                textView2.setTextColor(l.Hn(str2));
            }
            textView2 = (TextView) viewGroup.findViewById(R.id.aak);
            String str3 = tmVar.kbX;
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
                    AppMethodBeat.i(88746);
                    if (bVar.aZP()) {
                        j.b bVar = new j.b();
                        com.tencent.mm.plugin.card.d.b.a(h.this.kqH.jiE, bVar.kbK, bVar.kbL, false, bVar);
                    } else {
                        tm tmVar = bVar.aZV().vUA;
                        if (tmVar != null && !bo.isNullOrNil(tmVar.vTM) && !bo.isNullOrNil(tmVar.vTL)) {
                            int intExtra;
                            int intExtra2;
                            if (h.this.jiE.getIntent() != null) {
                                intExtra = h.this.jiE.getIntent().getIntExtra("key_from_scene", 3);
                            } else {
                                intExtra = 3;
                            }
                            if (h.this.jiE.getIntent() != null) {
                                intExtra2 = h.this.jiE.getIntent().getIntExtra("key_from_appbrand_type", 0);
                            } else {
                                intExtra2 = 0;
                            }
                            com.tencent.mm.plugin.card.d.b.a(bVar.aZZ(), tmVar, intExtra, intExtra2);
                            com.tencent.mm.plugin.report.service.h.pYm.e(11941, Integer.valueOf(20), bVar.aZZ(), bVar.baa(), "", tmVar.title);
                        } else if (!(tmVar == null || TextUtils.isEmpty(tmVar.url))) {
                            com.tencent.mm.plugin.card.d.b.a(h.this.kqH.jiE, l.A(tmVar.url, tmVar.vUW), 1);
                            com.tencent.mm.plugin.report.service.h.pYm.e(11941, Integer.valueOf(9), bVar.aZZ(), bVar.baa(), "", tmVar.title);
                            if (l.a(tmVar, bVar.aZZ())) {
                                l.Hs(bVar.aZZ());
                                com.tencent.mm.plugin.card.d.b.b(h.this.kqH.jiE, bVar.aZV().kdg);
                            }
                        }
                    }
                    t.finish();
                    AppMethodBeat.o(88746);
                }
            });
        }
    }

    public boolean g(b bVar) {
        return true;
    }

    public void l(ViewGroup viewGroup) {
    }
}
