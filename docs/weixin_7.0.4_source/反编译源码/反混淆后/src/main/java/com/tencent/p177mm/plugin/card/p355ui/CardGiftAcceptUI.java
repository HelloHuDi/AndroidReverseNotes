package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.p057v4.p058a.p059a.C0280a;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.card.model.C27588q;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.plugin.card.model.C42847ag;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C45778m.C457773;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.card.ui.CardGiftAcceptUI */
public class CardGiftAcceptUI extends MMActivity implements OnClickListener, C1202f {
    private final String TAG = "MicroMsg.CardGiftAcceptUI";
    private String cFZ;
    private String cKE;
    private int fhF;
    private String fhG;
    private RelativeLayout kjT;
    private RelativeLayout kjU;
    private ImageView kjV;
    private TextView kjW;
    private TextView kjX;
    private ImageView kjY;
    private Button kjZ;
    private LinearLayout kka;
    private TextView kkb;
    private LinearLayout kkc;
    private TextView kkd;
    private ImageView kke;
    private ImageView kkf;
    private RelativeLayout kkg;
    private C42847ag kkh;
    private C27588q kki;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftAcceptUI$1 */
    class C387571 implements OnCancelListener {
        C387571() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(88382);
            if (CardGiftAcceptUI.this.tipDialog != null && CardGiftAcceptUI.this.tipDialog.isShowing()) {
                CardGiftAcceptUI.this.tipDialog.dismiss();
            }
            C4990ab.m7416i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
            CardGiftAcceptUI.this.finish();
            AppMethodBeat.m2505o(88382);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130968919;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88383);
        super.onCreate(bundle);
        this.fhG = getIntent().getStringExtra("key_order_id");
        this.fhF = getIntent().getIntExtra("key_biz_uin", -1);
        this.cKE = getIntent().getStringExtra("key_from_user_name");
        this.cFZ = getIntent().getStringExtra("key_chatroom_name");
        C4990ab.m7417i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", this.fhG, Integer.valueOf(this.fhF), this.cKE);
        if (this.fhF == -1) {
            C4990ab.m7412e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
            C42840d.m76036a(this, "", true);
            AppMethodBeat.m2505o(88383);
        } else if (this.fhG == null) {
            C4990ab.m7412e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
            C42840d.m76036a(this, "", true);
            AppMethodBeat.m2505o(88383);
        } else {
            if (!C5046bo.isNullOrNil(this.cKE)) {
                C7060h.pYm.mo8381e(13866, Integer.valueOf(1), this.fhG, C1183p.getString(this.fhF), this.cKE);
            }
            initView();
            C1720g.m3535RO().eJo.mo14539a(1171, (C1202f) this);
            C1720g.m3535RO().eJo.mo14539a(1136, (C1202f) this);
            AppMethodBeat.m2505o(88383);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88384);
        super.onDestroy();
        C1720g.m3535RO().eJo.mo14546b(1171, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1136, (C1202f) this);
        AppMethodBeat.m2505o(88384);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88385);
        this.kjT = (RelativeLayout) findViewById(2131822058);
        this.kjU = (RelativeLayout) findViewById(2131822052);
        this.kjV = (ImageView) findViewById(2131822053);
        this.kjW = (TextView) findViewById(2131822054);
        this.kjX = (TextView) findViewById(2131822055);
        this.kjY = (ImageView) findViewById(2131822059);
        this.kjZ = (Button) findViewById(2131822056);
        this.kkb = (TextView) findViewById(2131822064);
        this.kkd = (TextView) findViewById(2131822061);
        this.kkg = (RelativeLayout) findViewById(2131822057);
        this.kke = (ImageView) findViewById(2131822065);
        this.kkf = (ImageView) findViewById(2131822062);
        this.kka = (LinearLayout) findViewById(2131822063);
        this.kkc = (LinearLayout) findViewById(2131822060);
        this.kkg.setOnClickListener(this);
        this.kjT.setOnClickListener(this);
        this.kjU.setOnClickListener(this);
        this.kka.setOnClickListener(this);
        this.kkc.setOnClickListener(this);
        this.mController.contentView.setVisibility(8);
        this.tipDialog = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.cn5), true, new C387571());
        bcU();
        AppMethodBeat.m2505o(88385);
    }

    /* renamed from: b */
    private static Drawable m65759b(Drawable drawable, ColorStateList colorStateList) {
        AppMethodBeat.m2504i(88386);
        Drawable f = C0280a.m467f(drawable);
        C0280a.m457a(f, colorStateList);
        AppMethodBeat.m2505o(88386);
        return f;
    }

    /* renamed from: dF */
    private void m65760dF(int i, int i2) {
        AppMethodBeat.m2504i(88387);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setStroke(2, i);
        gradientDrawable.setCornerRadius(6.0f);
        this.kjZ.setBackground(gradientDrawable);
        AppMethodBeat.m2505o(88387);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(88388);
        if (view.getId() == 2131822056 || view.getId() == 2131822063) {
            if (this.kjZ.getVisibility() == 0) {
                int bS = C5046bo.m7530bS(this.kkh.ker, getResources().getColor(C25738R.color.f11844j4));
                m65760dF(bS, bS);
                this.kjZ.setTextColor(getResources().getColor(C25738R.color.a69));
            }
            bcV();
            if (!C5046bo.isNullOrNil(this.cKE)) {
                C7060h.pYm.mo8381e(13866, Integer.valueOf(2), this.fhG, C1183p.getString(this.fhF), this.cKE);
                AppMethodBeat.m2505o(88388);
                return;
            }
        } else if (view.getId() == 2131822057) {
            finish();
            AppMethodBeat.m2505o(88388);
            return;
        } else if (view.getId() == 2131822058) {
            finish();
            AppMethodBeat.m2505o(88388);
            return;
        } else if (view.getId() == 2131822060) {
            C1720g.m3535RO().eJo.mo14541a(new C27588q(this.fhF, this.fhG, this.cFZ, Boolean.TRUE), 0);
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
        }
        AppMethodBeat.m2505o(88388);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(88389);
        if (i != 0 || i2 != 0) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (c1207m instanceof C42847ag) {
                C4990ab.m7413e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                C42840d.m76036a(this, str, true);
                AppMethodBeat.m2505o(88389);
                return;
            } else if (c1207m instanceof C27588q) {
                C4990ab.m7413e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                C42840d.m76036a(this, str, true);
            }
        } else if (c1207m instanceof C42847ag) {
            this.kkh = (C42847ag) c1207m;
            C4990ab.m7417i("MicroMsg.CardGiftAcceptUI", "ignore:%b", Boolean.valueOf(this.kkh.kep));
            if (this.kkh.kep) {
                C4990ab.m7416i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
                bcV();
                AppMethodBeat.m2505o(88389);
                return;
            }
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (this.kkh == null) {
                C4990ab.m7412e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            } else {
                int fromDPToPix;
                MarginLayoutParams marginLayoutParams;
                this.kjX.setText(this.kkh.content);
                this.kjW.setText(C44089j.m79293b((Context) this, this.kkh.cKE, this.kjW.getTextSize()));
                if (this.kkh.status == 0) {
                    if (C5046bo.isNullOrNil(this.kkh.keo)) {
                        this.kjZ.setVisibility(0);
                        this.kjZ.setText(getResources().getString(C25738R.string.ae1));
                        this.kjZ.setOnClickListener(this);
                    } else {
                        this.kjZ.setVisibility(0);
                        this.kjZ.setText(this.kkh.keo);
                        this.kjZ.setOnClickListener(this);
                    }
                } else if (this.kkh.status == 1 || this.kkh.status != 2) {
                    this.kjZ.setVisibility(8);
                    this.kjZ.setOnClickListener(null);
                } else if (C5046bo.isNullOrNil(this.kkh.keo)) {
                    this.kjZ.setVisibility(8);
                    this.kjZ.setOnClickListener(null);
                } else {
                    this.kjZ.setVisibility(0);
                    this.kjZ.setBackgroundDrawable(null);
                    this.kjZ.setText(this.kkh.keo);
                    this.kjZ.setTextColor(getResources().getColor(C25738R.color.f11782h4));
                    this.kjZ.setTextSize(1, 17.0f);
                    this.kjZ.setOnClickListener(null);
                }
                if (!C5046bo.isNullOrNil(this.kkh.kes)) {
                    this.kjZ.setVisibility(8);
                    this.kkc.setVisibility(8);
                    this.kka.setVisibility(0);
                    this.kkb.setText(this.kkh.kes);
                }
                if (!C5046bo.isNullOrNil(this.kkh.ket)) {
                    this.kka.setVisibility(8);
                    this.kkc.setVisibility(0);
                    this.kkd.setText(this.kkh.ket);
                }
                if (!C5046bo.isNullOrNil(this.kkh.ken)) {
                    fromDPToPix = C1338a.fromDPToPix(this, 15);
                    C17927a c17927a = new C17927a();
                    c17927a.ePK = C6457e.eSn;
                    C32291o.ahq();
                    c17927a.ePY = null;
                    c17927a.ePJ = C33770m.m55183Gz(this.kkh.ken);
                    c17927a.ePH = true;
                    c17927a.eQf = true;
                    c17927a.eQg = (float) fromDPToPix;
                    c17927a.ePF = true;
                    c17927a.ePT = C25738R.drawable.bcm;
                    C32291o.ahp().mo43766a(this.kkh.ken, this.kjV, c17927a.ahG());
                }
                if (!C5046bo.isNullOrNil(this.kkh.keq)) {
                    C32291o.ahp().mo43765a(this.kkh.keq, this.kjY);
                }
                if (!C5046bo.isNullOrNil(this.kkh.ker) && this.kjZ.getVisibility() == 0) {
                    fromDPToPix = C5046bo.m7530bS(this.kkh.ker, getResources().getColor(C25738R.color.f11844j4));
                    m65760dF(fromDPToPix, getResources().getColor(C25738R.color.f11843j3));
                    this.kjZ.setTextColor(fromDPToPix);
                }
                if (!C5046bo.isNullOrNil(this.kkh.ker) && this.kkb.getVisibility() == 0) {
                    this.kkb.setTextColor(C5046bo.m7530bS(this.kkh.ker, getResources().getColor(C25738R.color.f11844j4)));
                    fromDPToPix = getResources().getColor(C25738R.color.f11844j4);
                    if (!C5046bo.isNullOrNil(this.kkh.ker)) {
                        fromDPToPix = C5046bo.m7530bS(this.kkh.ker, fromDPToPix);
                    }
                    this.kke.setImageDrawable(CardGiftAcceptUI.m65759b(this.kke.getDrawable(), ColorStateList.valueOf(fromDPToPix)));
                }
                if (!C5046bo.isNullOrNil(this.kkh.ker) && this.kkd.getVisibility() == 0) {
                    this.kkd.setTextColor(C5046bo.m7530bS(this.kkh.ker, getResources().getColor(C25738R.color.f11844j4)));
                    fromDPToPix = getResources().getColor(C25738R.color.f11844j4);
                    if (!C5046bo.isNullOrNil(this.kkh.ker)) {
                        fromDPToPix = C5046bo.m7530bS(this.kkh.ker, fromDPToPix);
                    }
                    this.kkf.setImageDrawable(CardGiftAcceptUI.m65759b(this.kkf.getDrawable(), ColorStateList.valueOf(fromDPToPix)));
                    marginLayoutParams = (MarginLayoutParams) this.kjZ.getLayoutParams();
                    marginLayoutParams.topMargin -= C1338a.fromDPToPix(this, 20);
                    this.kjZ.setLayoutParams(marginLayoutParams);
                }
                if (this.kjZ.getVisibility() == 0 && this.kkc.getVisibility() == 8) {
                    marginLayoutParams = (MarginLayoutParams) this.kjZ.getLayoutParams();
                    marginLayoutParams.bottomMargin += C1338a.fromDPToPix(this, 28);
                    this.kjZ.setLayoutParams(marginLayoutParams);
                }
            }
            RelativeLayout relativeLayout = this.kjU;
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300);
            scaleAnimation.setInterpolator(new OvershootInterpolator());
            scaleAnimation.setFillAfter(true);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(100);
            scaleAnimation2.setFillAfter(true);
            scaleAnimation.setAnimationListener(new C457773(relativeLayout, scaleAnimation2));
            if (relativeLayout != null) {
                relativeLayout.startAnimation(scaleAnimation);
            }
            this.mController.contentView.setVisibility(0);
            AppMethodBeat.m2505o(88389);
            return;
        } else if (c1207m instanceof C27588q) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            C4990ab.m7416i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
            this.kki = (C27588q) c1207m;
            Intent intent = new Intent(this, CardGiftReceiveUI.class);
            intent.putExtra("key_order_id", this.fhG);
            intent.putExtra("key_biz_uin", this.fhF);
            intent.putExtra("key_gift_into", this.kki.kdV);
            intent.putExtra("key_from_group_chat_room", !C5046bo.isNullOrNil(this.cFZ));
            startActivity(intent);
            finish();
            AppMethodBeat.m2505o(88389);
            return;
        }
        AppMethodBeat.m2505o(88389);
    }

    private void bcU() {
        AppMethodBeat.m2504i(88390);
        C1720g.m3535RO().eJo.mo14541a(new C42847ag(this.fhF, this.fhG, this.cFZ), 0);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
        AppMethodBeat.m2505o(88390);
    }

    private void bcV() {
        AppMethodBeat.m2504i(88391);
        C1720g.m3535RO().eJo.mo14541a(new C27588q(this.fhF, this.fhG, this.cFZ, Boolean.FALSE), 0);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
        AppMethodBeat.m2505o(88391);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(88392);
        if (i == 4) {
            C4990ab.m7412e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(88392);
        return onKeyDown;
    }
}
