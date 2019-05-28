package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.m.AnonymousClass3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;

@a(3)
public class CardGiftAcceptUI extends MMActivity implements OnClickListener, f {
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
    private ag kkh;
    private q kki;
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.ik;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88383);
        super.onCreate(bundle);
        this.fhG = getIntent().getStringExtra("key_order_id");
        this.fhF = getIntent().getIntExtra("key_biz_uin", -1);
        this.cKE = getIntent().getStringExtra("key_from_user_name");
        this.cFZ = getIntent().getStringExtra("key_chatroom_name");
        ab.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", this.fhG, Integer.valueOf(this.fhF), this.cKE);
        if (this.fhF == -1) {
            ab.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
            d.a(this, "", true);
            AppMethodBeat.o(88383);
        } else if (this.fhG == null) {
            ab.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
            d.a(this, "", true);
            AppMethodBeat.o(88383);
        } else {
            if (!bo.isNullOrNil(this.cKE)) {
                h.pYm.e(13866, Integer.valueOf(1), this.fhG, com.tencent.mm.a.p.getString(this.fhF), this.cKE);
            }
            initView();
            g.RO().eJo.a(1171, (f) this);
            g.RO().eJo.a(1136, (f) this);
            AppMethodBeat.o(88383);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(88384);
        super.onDestroy();
        g.RO().eJo.b(1171, (f) this);
        g.RO().eJo.b(1136, (f) this);
        AppMethodBeat.o(88384);
    }

    public final void initView() {
        AppMethodBeat.i(88385);
        this.kjT = (RelativeLayout) findViewById(R.id.acw);
        this.kjU = (RelativeLayout) findViewById(R.id.acq);
        this.kjV = (ImageView) findViewById(R.id.acr);
        this.kjW = (TextView) findViewById(R.id.acs);
        this.kjX = (TextView) findViewById(R.id.act);
        this.kjY = (ImageView) findViewById(R.id.acx);
        this.kjZ = (Button) findViewById(R.id.acu);
        this.kkb = (TextView) findViewById(R.id.ad2);
        this.kkd = (TextView) findViewById(R.id.acz);
        this.kkg = (RelativeLayout) findViewById(R.id.acv);
        this.kke = (ImageView) findViewById(R.id.ad3);
        this.kkf = (ImageView) findViewById(R.id.ad0);
        this.kka = (LinearLayout) findViewById(R.id.ad1);
        this.kkc = (LinearLayout) findViewById(R.id.acy);
        this.kkg.setOnClickListener(this);
        this.kjT.setOnClickListener(this);
        this.kjU.setOnClickListener(this);
        this.kka.setOnClickListener(this);
        this.kkc.setOnClickListener(this);
        this.mController.contentView.setVisibility(8);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(88382);
                if (CardGiftAcceptUI.this.tipDialog != null && CardGiftAcceptUI.this.tipDialog.isShowing()) {
                    CardGiftAcceptUI.this.tipDialog.dismiss();
                }
                ab.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
                CardGiftAcceptUI.this.finish();
                AppMethodBeat.o(88382);
            }
        });
        bcU();
        AppMethodBeat.o(88385);
    }

    private static Drawable b(Drawable drawable, ColorStateList colorStateList) {
        AppMethodBeat.i(88386);
        Drawable f = android.support.v4.a.a.a.f(drawable);
        android.support.v4.a.a.a.a(f, colorStateList);
        AppMethodBeat.o(88386);
        return f;
    }

    private void dF(int i, int i2) {
        AppMethodBeat.i(88387);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setStroke(2, i);
        gradientDrawable.setCornerRadius(6.0f);
        this.kjZ.setBackground(gradientDrawable);
        AppMethodBeat.o(88387);
    }

    public void onClick(View view) {
        AppMethodBeat.i(88388);
        if (view.getId() == R.id.acu || view.getId() == R.id.ad1) {
            if (this.kjZ.getVisibility() == 0) {
                int bS = bo.bS(this.kkh.ker, getResources().getColor(R.color.j4));
                dF(bS, bS);
                this.kjZ.setTextColor(getResources().getColor(R.color.a69));
            }
            bcV();
            if (!bo.isNullOrNil(this.cKE)) {
                h.pYm.e(13866, Integer.valueOf(2), this.fhG, com.tencent.mm.a.p.getString(this.fhF), this.cKE);
                AppMethodBeat.o(88388);
                return;
            }
        } else if (view.getId() == R.id.acv) {
            finish();
            AppMethodBeat.o(88388);
            return;
        } else if (view.getId() == R.id.acw) {
            finish();
            AppMethodBeat.o(88388);
            return;
        } else if (view.getId() == R.id.acy) {
            g.RO().eJo.a(new q(this.fhF, this.fhG, this.cFZ, Boolean.TRUE), 0);
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
        }
        AppMethodBeat.o(88388);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(88389);
        if (i != 0 || i2 != 0) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (mVar instanceof ag) {
                ab.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                d.a(this, str, true);
                AppMethodBeat.o(88389);
                return;
            } else if (mVar instanceof q) {
                ab.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                d.a(this, str, true);
            }
        } else if (mVar instanceof ag) {
            this.kkh = (ag) mVar;
            ab.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", Boolean.valueOf(this.kkh.kep));
            if (this.kkh.kep) {
                ab.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
                bcV();
                AppMethodBeat.o(88389);
                return;
            }
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (this.kkh == null) {
                ab.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            } else {
                int fromDPToPix;
                MarginLayoutParams marginLayoutParams;
                this.kjX.setText(this.kkh.content);
                this.kjW.setText(j.b((Context) this, this.kkh.cKE, this.kjW.getTextSize()));
                if (this.kkh.status == 0) {
                    if (bo.isNullOrNil(this.kkh.keo)) {
                        this.kjZ.setVisibility(0);
                        this.kjZ.setText(getResources().getString(R.string.ae1));
                        this.kjZ.setOnClickListener(this);
                    } else {
                        this.kjZ.setVisibility(0);
                        this.kjZ.setText(this.kkh.keo);
                        this.kjZ.setOnClickListener(this);
                    }
                } else if (this.kkh.status == 1 || this.kkh.status != 2) {
                    this.kjZ.setVisibility(8);
                    this.kjZ.setOnClickListener(null);
                } else if (bo.isNullOrNil(this.kkh.keo)) {
                    this.kjZ.setVisibility(8);
                    this.kjZ.setOnClickListener(null);
                } else {
                    this.kjZ.setVisibility(0);
                    this.kjZ.setBackgroundDrawable(null);
                    this.kjZ.setText(this.kkh.keo);
                    this.kjZ.setTextColor(getResources().getColor(R.color.h4));
                    this.kjZ.setTextSize(1, 17.0f);
                    this.kjZ.setOnClickListener(null);
                }
                if (!bo.isNullOrNil(this.kkh.kes)) {
                    this.kjZ.setVisibility(8);
                    this.kkc.setVisibility(8);
                    this.kka.setVisibility(0);
                    this.kkb.setText(this.kkh.kes);
                }
                if (!bo.isNullOrNil(this.kkh.ket)) {
                    this.kka.setVisibility(8);
                    this.kkc.setVisibility(0);
                    this.kkd.setText(this.kkh.ket);
                }
                if (!bo.isNullOrNil(this.kkh.ken)) {
                    fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this, 15);
                    c.a aVar = new c.a();
                    aVar.ePK = e.eSn;
                    o.ahq();
                    aVar.ePY = null;
                    aVar.ePJ = com.tencent.mm.plugin.card.model.m.Gz(this.kkh.ken);
                    aVar.ePH = true;
                    aVar.eQf = true;
                    aVar.eQg = (float) fromDPToPix;
                    aVar.ePF = true;
                    aVar.ePT = R.drawable.bcm;
                    o.ahp().a(this.kkh.ken, this.kjV, aVar.ahG());
                }
                if (!bo.isNullOrNil(this.kkh.keq)) {
                    o.ahp().a(this.kkh.keq, this.kjY);
                }
                if (!bo.isNullOrNil(this.kkh.ker) && this.kjZ.getVisibility() == 0) {
                    fromDPToPix = bo.bS(this.kkh.ker, getResources().getColor(R.color.j4));
                    dF(fromDPToPix, getResources().getColor(R.color.j3));
                    this.kjZ.setTextColor(fromDPToPix);
                }
                if (!bo.isNullOrNil(this.kkh.ker) && this.kkb.getVisibility() == 0) {
                    this.kkb.setTextColor(bo.bS(this.kkh.ker, getResources().getColor(R.color.j4)));
                    fromDPToPix = getResources().getColor(R.color.j4);
                    if (!bo.isNullOrNil(this.kkh.ker)) {
                        fromDPToPix = bo.bS(this.kkh.ker, fromDPToPix);
                    }
                    this.kke.setImageDrawable(b(this.kke.getDrawable(), ColorStateList.valueOf(fromDPToPix)));
                }
                if (!bo.isNullOrNil(this.kkh.ker) && this.kkd.getVisibility() == 0) {
                    this.kkd.setTextColor(bo.bS(this.kkh.ker, getResources().getColor(R.color.j4)));
                    fromDPToPix = getResources().getColor(R.color.j4);
                    if (!bo.isNullOrNil(this.kkh.ker)) {
                        fromDPToPix = bo.bS(this.kkh.ker, fromDPToPix);
                    }
                    this.kkf.setImageDrawable(b(this.kkf.getDrawable(), ColorStateList.valueOf(fromDPToPix)));
                    marginLayoutParams = (MarginLayoutParams) this.kjZ.getLayoutParams();
                    marginLayoutParams.topMargin -= com.tencent.mm.bz.a.fromDPToPix(this, 20);
                    this.kjZ.setLayoutParams(marginLayoutParams);
                }
                if (this.kjZ.getVisibility() == 0 && this.kkc.getVisibility() == 8) {
                    marginLayoutParams = (MarginLayoutParams) this.kjZ.getLayoutParams();
                    marginLayoutParams.bottomMargin += com.tencent.mm.bz.a.fromDPToPix(this, 28);
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
            scaleAnimation.setAnimationListener(new AnonymousClass3(relativeLayout, scaleAnimation2));
            if (relativeLayout != null) {
                relativeLayout.startAnimation(scaleAnimation);
            }
            this.mController.contentView.setVisibility(0);
            AppMethodBeat.o(88389);
            return;
        } else if (mVar instanceof q) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            ab.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
            this.kki = (q) mVar;
            Intent intent = new Intent(this, CardGiftReceiveUI.class);
            intent.putExtra("key_order_id", this.fhG);
            intent.putExtra("key_biz_uin", this.fhF);
            intent.putExtra("key_gift_into", this.kki.kdV);
            intent.putExtra("key_from_group_chat_room", !bo.isNullOrNil(this.cFZ));
            startActivity(intent);
            finish();
            AppMethodBeat.o(88389);
            return;
        }
        AppMethodBeat.o(88389);
    }

    private void bcU() {
        AppMethodBeat.i(88390);
        g.RO().eJo.a(new ag(this.fhF, this.fhG, this.cFZ), 0);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
        AppMethodBeat.o(88390);
    }

    private void bcV() {
        AppMethodBeat.i(88391);
        g.RO().eJo.a(new q(this.fhF, this.fhG, this.cFZ, Boolean.FALSE), 0);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
        AppMethodBeat.o(88391);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(88392);
        if (i == 4) {
            ab.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(88392);
        return onKeyDown;
    }
}
