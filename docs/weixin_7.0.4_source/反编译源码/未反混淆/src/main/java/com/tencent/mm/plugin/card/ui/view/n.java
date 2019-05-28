package com.tencent.mm.plugin.card.ui.view;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class n extends h {
    public n(g gVar, MMActivity mMActivity) {
        super(gVar, mMActivity);
    }

    public final int getLayoutId() {
        return R.layout.i3;
    }

    public final boolean g(b bVar) {
        AppMethodBeat.i(88765);
        if (bVar.aZW().vSq) {
            tm tmVar = bVar.aZW().vSp;
            if (tmVar == null || bo.isNullOrNil(tmVar.title)) {
                AppMethodBeat.o(88765);
                return true;
            }
            ab.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : unavailable_qrcode_field is not null  !ban card show!");
            AppMethodBeat.o(88765);
            return false;
        }
        ab.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
        AppMethodBeat.o(88765);
        return false;
    }

    public final void l(ViewGroup viewGroup) {
        AppMethodBeat.i(88766);
        viewGroup.findViewById(R.id.aac).setVisibility(8);
        viewGroup.findViewById(R.id.aab).setVisibility(0);
        AppMethodBeat.o(88766);
    }

    public final void c(ViewGroup viewGroup, b bVar) {
        AppMethodBeat.i(88767);
        super.c(viewGroup, bVar);
        d(viewGroup, bVar);
        AppMethodBeat.o(88767);
    }

    /* Access modifiers changed, original: final */
    public final void d(final ViewGroup viewGroup, b bVar) {
        AppMethodBeat.i(88768);
        xt xtVar = bVar.aZV().vUB;
        View findViewById = viewGroup.findViewById(R.id.aa9);
        if (xtVar == null || !xtVar.wdv) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            if (!bo.isNullOrNil(xtVar.wdw)) {
                ((TextView) viewGroup.findViewById(R.id.aa_)).setText(xtVar.wdw);
                ((ImageView) viewGroup.findViewById(R.id.aaa)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(88762);
                        Button button = (Button) viewGroup.findViewById(R.id.aag);
                        View findViewById = viewGroup.findViewById(R.id.aac);
                        if (button.getVisibility() == 0 && findViewById.getVisibility() == 0) {
                            AppMethodBeat.o(88762);
                            return;
                        }
                        if (findViewById.getVisibility() == 0) {
                            if (l.isNetworkAvailable(n.this.jiE.mController.ylL)) {
                                findViewById.setVisibility(8);
                                viewGroup.findViewById(R.id.aab).setVisibility(0);
                            } else {
                                d.a(n.this.jiE, n.this.jiE.getString(R.string.adw), false);
                                AppMethodBeat.o(88762);
                                return;
                            }
                        }
                        n.this.kqH.d(c.CARDCODEREFRESHACTION_DOREFRESH);
                        AppMethodBeat.o(88762);
                    }
                });
                AppMethodBeat.o(88768);
                return;
            }
        }
        AppMethodBeat.o(88768);
    }

    public final boolean bet() {
        return false;
    }

    public final boolean beu() {
        return true;
    }

    public final void a(ViewGroup viewGroup, final b bVar) {
        AppMethodBeat.i(88769);
        am.bbm().bao();
        viewGroup.findViewById(R.id.aac).setVisibility(0);
        viewGroup.findViewById(R.id.aab).setVisibility(8);
        final tm tmVar = bVar.aZW().vSp;
        if (tmVar != null) {
            viewGroup.findViewById(R.id.aad).setVisibility(0);
            if (!bo.isNullOrNil(tmVar.title)) {
                Button button = (Button) viewGroup.findViewById(R.id.aag);
                button.setText(tmVar.title);
                button.setVisibility(0);
                a(button, bVar);
                button.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(88763);
                        if (!bo.isNullOrNil(tmVar.vTM) && !bo.isNullOrNil(tmVar.vTL)) {
                            int intExtra;
                            int intExtra2 = n.this.jiE.getIntent() != null ? n.this.jiE.getIntent().getIntExtra("key_from_scene", 3) : 3;
                            if (n.this.jiE.getIntent() != null) {
                                intExtra = n.this.jiE.getIntent().getIntExtra("key_from_appbrand_type", 0);
                            } else {
                                intExtra = 0;
                            }
                            com.tencent.mm.plugin.card.d.b.a(bVar.aZZ(), tmVar, intExtra2, intExtra);
                            h.pYm.e(11941, Integer.valueOf(20), bVar.aZZ(), bVar.baa(), "", tmVar.title);
                            AppMethodBeat.o(88763);
                        } else if (bo.isNullOrNil(tmVar.url)) {
                            d.a(n.this.jiE, n.this.jiE.getString(R.string.aih), true);
                            AppMethodBeat.o(88763);
                        } else {
                            com.tencent.mm.plugin.card.d.b.a(n.this.jiE, l.A(tmVar.url, tmVar.vUW), 1);
                            h hVar = h.pYm;
                            Object[] objArr = new Object[5];
                            objArr[0] = Integer.valueOf(9);
                            objArr[1] = bVar.aZZ();
                            objArr[2] = bVar.baa();
                            objArr[3] = "";
                            objArr[4] = tmVar.title != null ? tmVar.title : "";
                            hVar.e(11941, objArr);
                            AppMethodBeat.o(88763);
                        }
                    }
                });
                if (!bo.isNullOrNil(tmVar.kbW)) {
                    ((TextView) viewGroup.findViewById(R.id.aae)).setText(tmVar.kbW);
                }
                TextView textView = (TextView) viewGroup.findViewById(R.id.aaf);
                if (bo.isNullOrNil(tmVar.kbX)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(tmVar.kbX);
                    textView.setVisibility(0);
                    AppMethodBeat.o(88769);
                    return;
                }
            }
        }
        AppMethodBeat.o(88769);
    }

    public final void b(ViewGroup viewGroup, b bVar) {
        AppMethodBeat.i(88770);
        ab.i("MicroMsg.CardDynamicQrCodeController", "onScreenShot! ");
        final View findViewById = viewGroup.findViewById(R.id.aac);
        if (findViewById.getVisibility() == 0) {
            ab.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
            AppMethodBeat.o(88770);
            return;
        }
        findViewById.setVisibility(0);
        View findViewById2 = viewGroup.findViewById(R.id.aa9);
        if (findViewById2.getVisibility() == 0) {
            findViewById2.setVisibility(8);
        }
        final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.aab);
        imageView.setVisibility(8);
        final View findViewById3 = viewGroup.findViewById(R.id.aad);
        findViewById3.setVisibility(0);
        ((TextView) viewGroup.findViewById(R.id.aae)).setText(this.jiE.getResources().getString(R.string.ad3));
        final Button button = (Button) viewGroup.findViewById(R.id.aag);
        button.setVisibility(0);
        a(button, bVar);
        g bbm = am.bbm();
        if (bVar == null) {
            ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport do nothing return !cardInfo is null!");
        } else {
            bbm.bao();
            k Gy = am.bbk().Gy(bVar.aZZ());
            if (Gy != null) {
                ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", Gy.field_card_id, Gy.field_code_id);
                if (am.bbk().dm(bVar.aZZ(), Gy.field_code_id)) {
                    bbm.a(bVar.aZZ(), Gy.field_code_id, c.CARDCODEREFRESHACTION_SNAPSHOT);
                } else {
                    ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport delete failue! do not report! cardId =%s,codeId=%s", Gy.field_card_id, Gy.field_code_id);
                }
            } else {
                ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport  failue! currentCode is null!");
            }
        }
        final ViewGroup viewGroup2 = viewGroup;
        final b bVar2 = bVar;
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(88764);
                findViewById.setVisibility(8);
                findViewById3.setVisibility(8);
                imageView.setVisibility(0);
                button.setVisibility(8);
                n.this.kqH.d(c.CARDCODEREFRESHACTION_SNAPSHOT);
                n.this.d(viewGroup2, bVar2);
                AppMethodBeat.o(88764);
            }
        });
        AppMethodBeat.o(88770);
    }

    private void a(Button button, b bVar) {
        AppMethodBeat.i(88771);
        String str = bVar.aZV().color;
        if (!bo.isNullOrNil(str)) {
            int Hn = l.Hn(str);
            button.setText(this.jiE.getResources().getString(R.string.ad4));
            button.setTextColor(Hn);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.jiE.getResources().getColor(R.color.iv));
            gradientDrawable.setStroke(2, Hn);
            gradientDrawable.setCornerRadius(8.0f);
            button.setBackground(gradientDrawable);
        }
        AppMethodBeat.o(88771);
    }
}
