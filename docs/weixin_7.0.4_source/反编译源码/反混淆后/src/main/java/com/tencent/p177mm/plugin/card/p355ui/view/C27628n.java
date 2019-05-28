package com.tencent.p177mm.plugin.card.p355ui.view;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C11288k;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p352b.C33753g;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42839c;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.protocal.protobuf.C30244xt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.card.ui.view.n */
public final class C27628n extends C11360h {
    public C27628n(C11358g c11358g, MMActivity mMActivity) {
        super(c11358g, mMActivity);
    }

    public final int getLayoutId() {
        return 2130968901;
    }

    /* renamed from: g */
    public final boolean mo23075g(C42837b c42837b) {
        AppMethodBeat.m2504i(88765);
        if (c42837b.aZW().vSq) {
            C23446tm c23446tm = c42837b.aZW().vSp;
            if (c23446tm == null || C5046bo.isNullOrNil(c23446tm.title)) {
                AppMethodBeat.m2505o(88765);
                return true;
            }
            C4990ab.m7412e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : unavailable_qrcode_field is not null  !ban card show!");
            AppMethodBeat.m2505o(88765);
            return false;
        }
        C4990ab.m7412e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
        AppMethodBeat.m2505o(88765);
        return false;
    }

    /* renamed from: l */
    public final void mo23076l(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(88766);
        viewGroup.findViewById(2131821964).setVisibility(8);
        viewGroup.findViewById(2131821963).setVisibility(0);
        AppMethodBeat.m2505o(88766);
    }

    /* renamed from: c */
    public final void mo23074c(ViewGroup viewGroup, C42837b c42837b) {
        AppMethodBeat.m2504i(88767);
        super.mo23074c(viewGroup, c42837b);
        mo45476d(viewGroup, c42837b);
        AppMethodBeat.m2505o(88767);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo45476d(final ViewGroup viewGroup, C42837b c42837b) {
        AppMethodBeat.m2504i(88768);
        C30244xt c30244xt = c42837b.aZV().vUB;
        View findViewById = viewGroup.findViewById(2131821960);
        if (c30244xt == null || !c30244xt.wdv) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            if (!C5046bo.isNullOrNil(c30244xt.wdw)) {
                ((TextView) viewGroup.findViewById(2131821961)).setText(c30244xt.wdw);
                ((ImageView) viewGroup.findViewById(2131821962)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(88762);
                        Button button = (Button) viewGroup.findViewById(2131821968);
                        View findViewById = viewGroup.findViewById(2131821964);
                        if (button.getVisibility() == 0 && findViewById.getVisibility() == 0) {
                            AppMethodBeat.m2505o(88762);
                            return;
                        }
                        if (findViewById.getVisibility() == 0) {
                            if (C38736l.isNetworkAvailable(C27628n.this.jiE.mController.ylL)) {
                                findViewById.setVisibility(8);
                                viewGroup.findViewById(2131821963).setVisibility(0);
                            } else {
                                C42840d.m76036a(C27628n.this.jiE, C27628n.this.jiE.getString(C25738R.string.adw), false);
                                AppMethodBeat.m2505o(88762);
                                return;
                            }
                        }
                        C27628n.this.kqH.mo23067d(C42839c.CARDCODEREFRESHACTION_DOREFRESH);
                        AppMethodBeat.m2505o(88762);
                    }
                });
                AppMethodBeat.m2505o(88768);
                return;
            }
        }
        AppMethodBeat.m2505o(88768);
    }

    public final boolean bet() {
        return false;
    }

    public final boolean beu() {
        return true;
    }

    /* renamed from: a */
    public final void mo30694a(ViewGroup viewGroup, final C42837b c42837b) {
        AppMethodBeat.m2504i(88769);
        C42852am.bbm().bao();
        viewGroup.findViewById(2131821964).setVisibility(0);
        viewGroup.findViewById(2131821963).setVisibility(8);
        final C23446tm c23446tm = c42837b.aZW().vSp;
        if (c23446tm != null) {
            viewGroup.findViewById(2131821965).setVisibility(0);
            if (!C5046bo.isNullOrNil(c23446tm.title)) {
                Button button = (Button) viewGroup.findViewById(2131821968);
                button.setText(c23446tm.title);
                button.setVisibility(0);
                m43892a(button, c42837b);
                button.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(88763);
                        if (!C5046bo.isNullOrNil(c23446tm.vTM) && !C5046bo.isNullOrNil(c23446tm.vTL)) {
                            int intExtra;
                            int intExtra2 = C27628n.this.jiE.getIntent() != null ? C27628n.this.jiE.getIntent().getIntExtra("key_from_scene", 3) : 3;
                            if (C27628n.this.jiE.getIntent() != null) {
                                intExtra = C27628n.this.jiE.getIntent().getIntExtra("key_from_appbrand_type", 0);
                            } else {
                                intExtra = 0;
                            }
                            C45774b.m84629a(c42837b.aZZ(), c23446tm, intExtra2, intExtra);
                            C7060h.pYm.mo8381e(11941, Integer.valueOf(20), c42837b.aZZ(), c42837b.baa(), "", c23446tm.title);
                            AppMethodBeat.m2505o(88763);
                        } else if (C5046bo.isNullOrNil(c23446tm.url)) {
                            C42840d.m76036a(C27628n.this.jiE, C27628n.this.jiE.getString(C25738R.string.aih), true);
                            AppMethodBeat.m2505o(88763);
                        } else {
                            C45774b.m84626a(C27628n.this.jiE, C38736l.m65699A(c23446tm.url, c23446tm.vUW), 1);
                            C7060h c7060h = C7060h.pYm;
                            Object[] objArr = new Object[5];
                            objArr[0] = Integer.valueOf(9);
                            objArr[1] = c42837b.aZZ();
                            objArr[2] = c42837b.baa();
                            objArr[3] = "";
                            objArr[4] = c23446tm.title != null ? c23446tm.title : "";
                            c7060h.mo8381e(11941, objArr);
                            AppMethodBeat.m2505o(88763);
                        }
                    }
                });
                if (!C5046bo.isNullOrNil(c23446tm.kbW)) {
                    ((TextView) viewGroup.findViewById(2131821966)).setText(c23446tm.kbW);
                }
                TextView textView = (TextView) viewGroup.findViewById(2131821967);
                if (C5046bo.isNullOrNil(c23446tm.kbX)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(c23446tm.kbX);
                    textView.setVisibility(0);
                    AppMethodBeat.m2505o(88769);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(88769);
    }

    /* renamed from: b */
    public final void mo30695b(ViewGroup viewGroup, C42837b c42837b) {
        AppMethodBeat.m2504i(88770);
        C4990ab.m7416i("MicroMsg.CardDynamicQrCodeController", "onScreenShot! ");
        final View findViewById = viewGroup.findViewById(2131821964);
        if (findViewById.getVisibility() == 0) {
            C4990ab.m7412e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
            AppMethodBeat.m2505o(88770);
            return;
        }
        findViewById.setVisibility(0);
        View findViewById2 = viewGroup.findViewById(2131821960);
        if (findViewById2.getVisibility() == 0) {
            findViewById2.setVisibility(8);
        }
        final ImageView imageView = (ImageView) viewGroup.findViewById(2131821963);
        imageView.setVisibility(8);
        final View findViewById3 = viewGroup.findViewById(2131821965);
        findViewById3.setVisibility(0);
        ((TextView) viewGroup.findViewById(2131821966)).setText(this.jiE.getResources().getString(C25738R.string.ad3));
        final Button button = (Button) viewGroup.findViewById(2131821968);
        button.setVisibility(0);
        m43892a(button, c42837b);
        C33753g bbm = C42852am.bbm();
        if (c42837b == null) {
            C4990ab.m7412e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport do nothing return !cardInfo is null!");
        } else {
            bbm.bao();
            C11288k Gy = C42852am.bbk().mo22985Gy(c42837b.aZZ());
            if (Gy != null) {
                C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", Gy.field_card_id, Gy.field_code_id);
                if (C42852am.bbk().mo22986dm(c42837b.aZZ(), Gy.field_code_id)) {
                    bbm.mo54287a(c42837b.aZZ(), Gy.field_code_id, C42839c.CARDCODEREFRESHACTION_SNAPSHOT);
                } else {
                    C4990ab.m7413e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport delete failue! do not report! cardId =%s,codeId=%s", Gy.field_card_id, Gy.field_code_id);
                }
            } else {
                C4990ab.m7412e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport  failue! currentCode is null!");
            }
        }
        final ViewGroup viewGroup2 = viewGroup;
        final C42837b c42837b2 = c42837b;
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(88764);
                findViewById.setVisibility(8);
                findViewById3.setVisibility(8);
                imageView.setVisibility(0);
                button.setVisibility(8);
                C27628n.this.kqH.mo23067d(C42839c.CARDCODEREFRESHACTION_SNAPSHOT);
                C27628n.this.mo45476d(viewGroup2, c42837b2);
                AppMethodBeat.m2505o(88764);
            }
        });
        AppMethodBeat.m2505o(88770);
    }

    /* renamed from: a */
    private void m43892a(Button button, C42837b c42837b) {
        AppMethodBeat.m2504i(88771);
        String str = c42837b.aZV().color;
        if (!C5046bo.isNullOrNil(str)) {
            int Hn = C38736l.m65701Hn(str);
            button.setText(this.jiE.getResources().getString(C25738R.string.ad4));
            button.setTextColor(Hn);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.jiE.getResources().getColor(C25738R.color.f11838iv));
            gradientDrawable.setStroke(2, Hn);
            gradientDrawable.setCornerRadius(8.0f);
            button.setBackground(gradientDrawable);
        }
        AppMethodBeat.m2505o(88771);
    }
}
