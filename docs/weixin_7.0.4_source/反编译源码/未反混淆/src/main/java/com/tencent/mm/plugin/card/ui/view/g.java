package com.tencent.mm.plugin.card.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bw.a.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.d.p;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public abstract class g extends i {
    String code;
    private Bitmap gKF;
    MMActivity jiE;
    protected b kaS;
    private Bitmap kgb;
    private OnLongClickListener kgk = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(88744);
            if (view.getId() == R.id.aa7) {
                p.wG(g.this.kaS.aZW().code);
                h.bQ(g.this.jiE, g.this.getString(R.string.oz));
            }
            AppMethodBeat.o(88744);
            return false;
        }
    };
    private j kjw;
    private ViewGroup kqD;
    private ab kqE;
    private ViewStub kqF;

    public abstract ab beA();

    public abstract ab bey();

    public abstract ab bez();

    public abstract String e(c cVar);

    public abstract boolean f(b bVar);

    public final void initView() {
        this.jiE = this.kqK.bcy();
        this.kjw = this.kqK.bcE();
        this.kaS = this.kqK.bcv();
        if (this.kaS == null) {
            ab.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
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
            ab.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
            return;
        }
        switch (this.kaS.aZW().vSb) {
            case 0:
                if (this.kqF == null) {
                    this.kqF = (ViewStub) findViewById(R.id.ac9);
                    break;
                }
                break;
            case 1:
                if (this.kqF == null) {
                    this.kqF = (ViewStub) findViewById(R.id.ac8);
                    break;
                }
                break;
            case 2:
                if (this.kqF == null) {
                    this.kqF = (ViewStub) findViewById(R.id.ac7);
                    break;
                }
                break;
            default:
                if (this.kqF == null) {
                    this.kqF = (ViewStub) findViewById(R.id.ac7);
                    break;
                }
                break;
        }
        if (this.kqF == null) {
            ab.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
        } else if (this.kqE == null) {
            ab.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
        } else if (this.kqE.getLayoutId() == 0) {
            ab.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
        } else {
            this.kqF.setLayoutResource(this.kqE.getLayoutId());
            if (this.kqD == null) {
                this.kqD = (ViewGroup) this.kqF.inflate();
            }
        }
        if (this.kqD == null) {
            ab.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
        }
    }

    public final void b(b bVar) {
        if (bVar == null) {
            ab.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
        } else {
            this.kaS = bVar;
        }
    }

    public final void destroy() {
        super.destroy();
        this.jiE = null;
        this.kjw = null;
        this.kaS = null;
        this.kqD = null;
        this.kqE = null;
        l.K(this.gKF);
        l.K(this.kgb);
    }

    public final void update() {
        if (this.kaS == null) {
            ab.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
        } else if (this.kqE == null) {
            ab.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
        } else if (this.kqD == null) {
            ab.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
        } else {
            this.kjw.bdp();
            d(c.CARDCODEREFRESHACTION_ENTERCHANGE);
            this.kqE.c(this.kqD, this.kaS);
        }
    }

    public final void d(c cVar) {
        if (this.kaS == null) {
            ab.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
        } else if (cVar == null) {
            ab.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
        } else if (this.kqE.g(this.kaS)) {
            this.kqE.l(this.kqD);
            ab.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", Integer.valueOf(cVar.action));
            this.code = e(cVar);
            if (bo.isNullOrNil(this.code)) {
                ab.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
                return;
            }
            switch (this.kaS.aZW().vSb) {
                case 0:
                    e(this.kqD, this.code);
                    return;
                case 1:
                    d(this.kqD, this.code);
                    return;
                case 2:
                    c(this.kqD, this.code);
                    return;
                default:
                    return;
            }
        } else {
            ab.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", Integer.valueOf(cVar.action));
            bev();
        }
    }

    public final void bev() {
        if (this.kqE != null && this.kaS != null && this.kqD != null) {
            this.kqE.a(this.kqD, this.kaS);
        }
    }

    public final void bew() {
        if (this.kaS == null || this.kqE == null || this.kqD == null) {
            ab.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
            return;
        }
        this.kqE.b(this.kqD, this.kaS);
        if (this.kaS.aZW().vSb == 2 && this.kjw != null) {
            j jVar = this.kjw;
            if (jVar.gKG != null && jVar.gKG.isShowing()) {
                jVar.gKG.dismiss();
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

    private void c(View view, String str) {
        try {
            ImageView imageView = (ImageView) view.findViewById(R.id.aab);
            l.K(this.gKF);
            int i = 1;
            if (!(this.kaS == null || this.kaS.aZV() == null)) {
                i = this.kaS.aZV().vUD;
            }
            this.gKF = a.b(this.jiE, str, 12, i);
            a(imageView, this.gKF);
            imageView.setOnClickListener(this.kqK.bcz());
            this.kjw.gKF = this.gKF;
            this.kjw.bdr();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CardBaseCodeView", e, "", new Object[0]);
        }
    }

    private void d(View view, String str) {
        try {
            ImageView imageView = (ImageView) view.findViewById(R.id.aa5);
            l.K(this.kgb);
            if (str != null && str.length() > 0) {
                this.kgb = a.b(this.jiE, str, 5, 0);
            }
            a(imageView, this.kgb);
            imageView.setOnClickListener(this.kqK.bcz());
            this.kjw.kgb = this.kgb;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CardBaseCodeView", e, "", new Object[0]);
        }
    }

    private void e(View view, String str) {
        TextView textView = (TextView) view.findViewById(R.id.aa7);
        textView.setText(m.Hu(str));
        textView.setOnLongClickListener(this.kgk);
        String str2 = this.kaS.aZV().color;
        if (!bo.isNullOrNil(str2)) {
            textView.setTextColor(l.Hn(str2));
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

    private static void a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
