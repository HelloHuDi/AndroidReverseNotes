package com.tencent.p177mm.plugin.card.p355ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1529bw.p1530a.C37623a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p355ui.C2777j;
import com.tencent.p177mm.plugin.card.p931d.C27577p;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42839c;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.card.ui.view.g */
public abstract class C11358g extends C45800i {
    String code;
    private Bitmap gKF;
    MMActivity jiE;
    protected C42837b kaS;
    private Bitmap kgb;
    private OnLongClickListener kgk = new C113591();
    private C2777j kjw;
    private ViewGroup kqD;
    private C45799ab kqE;
    private ViewStub kqF;

    /* renamed from: com.tencent.mm.plugin.card.ui.view.g$1 */
    class C113591 implements OnLongClickListener {
        C113591() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(88744);
            if (view.getId() == 2131821958) {
                C27577p.m43810wG(C11358g.this.kaS.aZW().code);
                C30379h.m48465bQ(C11358g.this.jiE, C11358g.this.getString(C25738R.string.f9083oz));
            }
            AppMethodBeat.m2505o(88744);
            return false;
        }
    }

    public abstract C45799ab beA();

    public abstract C45799ab bey();

    public abstract C45799ab bez();

    /* renamed from: e */
    public abstract String mo23069e(C42839c c42839c);

    /* renamed from: f */
    public abstract boolean mo23070f(C42837b c42837b);

    public final void initView() {
        this.jiE = this.kqK.bcy();
        this.kjw = this.kqK.bcE();
        this.kaS = this.kqK.bcv();
        if (this.kaS == null) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
            return;
        }
        switch (this.kaS.aZW().vSb) {
            case 0:
                this.kqE = beA();
                break;
            case 1:
                this.kqE = bez();
                break;
            case 2:
                this.kqE = bey();
                break;
            default:
                this.kqE = bey();
                break;
        }
        if (this.kqE == null) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
            return;
        }
        switch (this.kaS.aZW().vSb) {
            case 0:
                if (this.kqF == null) {
                    this.kqF = (ViewStub) findViewById(2131822034);
                    break;
                }
                break;
            case 1:
                if (this.kqF == null) {
                    this.kqF = (ViewStub) findViewById(2131822033);
                    break;
                }
                break;
            case 2:
                if (this.kqF == null) {
                    this.kqF = (ViewStub) findViewById(2131822032);
                    break;
                }
                break;
            default:
                if (this.kqF == null) {
                    this.kqF = (ViewStub) findViewById(2131822032);
                    break;
                }
                break;
        }
        if (this.kqF == null) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
        } else if (this.kqE == null) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
        } else if (this.kqE.getLayoutId() == 0) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
        } else {
            this.kqF.setLayoutResource(this.kqE.getLayoutId());
            if (this.kqD == null) {
                this.kqD = (ViewGroup) this.kqF.inflate();
            }
        }
        if (this.kqD == null) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
        }
    }

    /* renamed from: b */
    public final void mo23060b(C42837b c42837b) {
        if (c42837b == null) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
        } else {
            this.kaS = c42837b;
        }
    }

    public final void destroy() {
        super.destroy();
        this.jiE = null;
        this.kjw = null;
        this.kaS = null;
        this.kqD = null;
        this.kqE = null;
        C38736l.m65709K(this.gKF);
        C38736l.m65709K(this.kgb);
    }

    public final void update() {
        if (this.kaS == null) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
        } else if (this.kqE == null) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
        } else if (this.kqD == null) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
        } else {
            this.kjw.bdp();
            mo23067d(C42839c.CARDCODEREFRESHACTION_ENTERCHANGE);
            this.kqE.mo23074c(this.kqD, this.kaS);
        }
    }

    /* renamed from: d */
    public final void mo23067d(C42839c c42839c) {
        if (this.kaS == null) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
        } else if (c42839c == null) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
        } else if (this.kqE.mo23075g(this.kaS)) {
            this.kqE.mo23076l(this.kqD);
            C4990ab.m7417i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", Integer.valueOf(c42839c.action));
            this.code = mo23069e(c42839c);
            if (C5046bo.isNullOrNil(this.code)) {
                C4990ab.m7412e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
                return;
            }
            switch (this.kaS.aZW().vSb) {
                case 0:
                    m19090e(this.kqD, this.code);
                    return;
                case 1:
                    m19089d(this.kqD, this.code);
                    return;
                case 2:
                    m19088c(this.kqD, this.code);
                    return;
                default:
                    return;
            }
        } else {
            C4990ab.m7413e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", Integer.valueOf(c42839c.action));
            bev();
        }
    }

    public final void bev() {
        if (this.kqE != null && this.kaS != null && this.kqD != null) {
            this.kqE.mo30694a(this.kqD, this.kaS);
        }
    }

    public final void bew() {
        if (this.kaS == null || this.kqE == null || this.kqD == null) {
            C4990ab.m7412e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
            return;
        }
        this.kqE.mo30695b(this.kqD, this.kaS);
        if (this.kaS.aZW().vSb == 2 && this.kjw != null) {
            C2777j c2777j = this.kjw;
            if (c2777j.gKG != null && c2777j.gKG.isShowing()) {
                c2777j.gKG.dismiss();
            }
        }
    }

    public final void bes() {
        bex();
    }

    public final void bex() {
        if (this.kqD != null) {
            this.kqD.setVisibility(8);
        }
    }

    /* renamed from: c */
    private void m19088c(View view, String str) {
        try {
            ImageView imageView = (ImageView) view.findViewById(2131821963);
            C38736l.m65709K(this.gKF);
            int i = 1;
            if (!(this.kaS == null || this.kaS.aZV() == null)) {
                i = this.kaS.aZV().vUD;
            }
            this.gKF = C37623a.m63542b(this.jiE, str, 12, i);
            C11358g.m19087a(imageView, this.gKF);
            imageView.setOnClickListener(this.kqK.bcz());
            this.kjw.gKF = this.gKF;
            this.kjw.bdr();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CardBaseCodeView", e, "", new Object[0]);
        }
    }

    /* renamed from: d */
    private void m19089d(View view, String str) {
        try {
            ImageView imageView = (ImageView) view.findViewById(2131821956);
            C38736l.m65709K(this.kgb);
            if (str != null && str.length() > 0) {
                this.kgb = C37623a.m63542b(this.jiE, str, 5, 0);
            }
            C11358g.m19087a(imageView, this.kgb);
            imageView.setOnClickListener(this.kqK.bcz());
            this.kjw.kgb = this.kgb;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CardBaseCodeView", e, "", new Object[0]);
        }
    }

    /* renamed from: e */
    private void m19090e(View view, String str) {
        TextView textView = (TextView) view.findViewById(2131821958);
        textView.setText(C45778m.m84640Hu(str));
        textView.setOnLongClickListener(this.kgk);
        String str2 = this.kaS.aZV().color;
        if (!C5046bo.isNullOrNil(str2)) {
            textView.setTextColor(C38736l.m65701Hn(str2));
        }
        if (str.length() <= 12) {
            textView.setTextSize(1, 33.0f);
        } else if (str.length() > 12 && str.length() <= 16) {
            textView.setTextSize(1, 30.0f);
        } else if (str.length() > 16 && str.length() <= 20) {
            textView.setTextSize(1, 24.0f);
        } else if (str.length() > 20 && str.length() <= 40) {
            textView.setTextSize(1, 18.0f);
        } else if (str.length() > 40) {
            textView.setVisibility(8);
        }
    }

    /* renamed from: a */
    private static void m19087a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
