package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C0540q;
import android.support.p057v4.widget.C8415j;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.decode.C26076b;
import com.tencent.p177mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.p177mm.emoji.view.BaseEmojiView;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p232b.p233a.C9499aa;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.emoji.model.C20378d.C11556a;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p726f.C27737e;
import com.tencent.p177mm.plugin.gif.MMAnimateView;
import com.tencent.p177mm.plugin.luckymoney.model.C12425af;
import com.tencent.p177mm.plugin.luckymoney.model.C12428k;
import com.tencent.p177mm.plugin.luckymoney.model.C36786an;
import com.tencent.p177mm.plugin.luckymoney.model.C36787aq;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C43285k.C28461a;
import com.tencent.p177mm.plugin.luckymoney.p987a.C12405a;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22583ab;
import com.tencent.p177mm.pluginsdk.wallet.C30158b;
import com.tencent.p177mm.protocal.protobuf.C23399hv;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.protocal.protobuf.atb;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.wallet_core.p649c.C16077f;
import java.io.IOException;

@C5271a(7)
@C18524i
/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI */
public class LuckyMoneyNotHookReceiveUI extends LuckyMoneyBaseUI {
    private ViewGroup ius;
    private TextView kGq;
    private C11556a kVj = new C344831();
    private String kWO;
    private EmojiInfo kZa;
    private String mXq;
    private int maxSize = 0;
    private ImageView nSM;
    private TextView nTD;
    Button nTE;
    private View nTF;
    private ImageView nTG;
    private TextView nTH;
    private ImageView nVJ;
    public int nZk = 0;
    C36787aq nZs;
    private TextView nsq;
    private String ocI;
    private String ocK;
    private RelativeLayout odG;
    private BaseEmojiView odH;
    private TextView odI;
    private LinearLayout odJ;
    private MMAnimateView odK;
    private int odX;
    private C9499aa oec;
    private long oes = 0;
    private int oeu = 3;
    private C1202f oev = new C344879();
    private int oex = 0;
    private LinearLayout ogp;
    private View ogq;
    private ImageView ogr;
    private ImageView ogs;
    private RelativeLayout ogt;
    private C22583ab ogu = null;
    private String ogv;
    private boolean ogw = false;
    private int textSize = 0;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI$10 */
    class C1244810 implements Runnable {
        C1244810() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42857);
            LuckyMoneyNotHookReceiveUI.m56519h(LuckyMoneyNotHookReceiveUI.this);
            AppMethodBeat.m2505o(42857);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI$4 */
    class C212344 implements OnClickListener {
        C212344() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI$6 */
    class C212366 implements View.OnClickListener {
        C212366() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42853);
            LuckyMoneyNotHookReceiveUI.this.finish();
            AppMethodBeat.m2505o(42853);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI$7 */
    class C212377 implements View.OnClickListener {
        C212377() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42854);
            LuckyMoneyNotHookReceiveUI.m56511a(LuckyMoneyNotHookReceiveUI.this, true);
            AppMethodBeat.m2505o(42854);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI$11 */
    class C2844011 implements View.OnClickListener {
        C2844011() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42858);
            ((C30158b) C1720g.m3528K(C30158b.class)).mo48437eA(10, 3);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(5), Integer.valueOf(LuckyMoneyNotHookReceiveUI.m56526yi(LuckyMoneyNotHookReceiveUI.this.nZs.cRT)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.m56522j(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(2));
            C4990ab.m7416i("MicroMsg.LuckyMoneyNotHookReceiveUI", "open btn click!");
            LuckyMoneyNotHookReceiveUI.this.nTE.setClickable(false);
            LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI = LuckyMoneyNotHookReceiveUI.this;
            luckyMoneyNotHookReceiveUI.mo24301b(new C36786an(luckyMoneyNotHookReceiveUI.nZs.msgType, luckyMoneyNotHookReceiveUI.nZs.cdf, luckyMoneyNotHookReceiveUI.nZs.nSX, luckyMoneyNotHookReceiveUI.nZs.cRS, C46063x.bLC(), C1853r.m3820YB(), luckyMoneyNotHookReceiveUI.getIntent().getStringExtra("key_username"), "v1.0", luckyMoneyNotHookReceiveUI.nZs.nZl), false);
            C46063x.m85812c(luckyMoneyNotHookReceiveUI.nTE);
            AppMethodBeat.m2505o(42858);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI$1 */
    class C344831 implements C11556a {
        C344831() {
        }

        /* renamed from: a */
        public final void mo23264a(final boolean z, final EmojiInfo emojiInfo) {
            AppMethodBeat.m2504i(42850);
            C5004al.m7441d(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI$1$1$1 */
                class C344821 implements Runnable {
                    C344821() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(42848);
                        if (!(emojiInfo == null || LuckyMoneyNotHookReceiveUI.this.kZa == null || !LuckyMoneyNotHookReceiveUI.this.kZa.mo20410Aq().equals(emojiInfo.mo20410Aq()))) {
                            if (z) {
                                C4990ab.m7416i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings success.");
                                LuckyMoneyNotHookReceiveUI.this.kZa = C42952j.getEmojiStorageMgr().xYn.aqi(LuckyMoneyNotHookReceiveUI.this.kZa.mo20410Aq());
                                LuckyMoneyNotHookReceiveUI.this.odJ.setVisibility(8);
                                LuckyMoneyNotHookReceiveUI.this.odH.setVisibility(0);
                                LuckyMoneyNotHookReceiveUI.m56509a(LuckyMoneyNotHookReceiveUI.this, 3);
                                LuckyMoneyNotHookReceiveUI.m56513b(LuckyMoneyNotHookReceiveUI.this, LuckyMoneyNotHookReceiveUI.this.kZa);
                                AppMethodBeat.m2505o(42848);
                                return;
                            }
                            C4990ab.m7416i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings error.");
                            LuckyMoneyNotHookReceiveUI.this.odJ.setVisibility(8);
                            LuckyMoneyNotHookReceiveUI.this.odI.setVisibility(0);
                            LuckyMoneyNotHookReceiveUI.m56509a(LuckyMoneyNotHookReceiveUI.this, 1);
                        }
                        AppMethodBeat.m2505o(42848);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(42849);
                    C5004al.m7441d(new C344821());
                    AppMethodBeat.m2505o(42849);
                }
            });
            AppMethodBeat.m2505o(42850);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI$2 */
    class C344852 implements OnDismissListener {
        C344852() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI$8 */
    class C344868 implements OnCancelListener {
        C344868() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(42855);
            if (LuckyMoneyNotHookReceiveUI.this.tipDialog != null && LuckyMoneyNotHookReceiveUI.this.tipDialog.isShowing()) {
                LuckyMoneyNotHookReceiveUI.this.tipDialog.dismiss();
            }
            LuckyMoneyNotHookReceiveUI.this.ocz.bLz();
            if (LuckyMoneyNotHookReceiveUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyNotHookReceiveUI.this.mController.contentView.getVisibility() == 4) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyNotHookReceiveUI", "user cancel & finish");
                LuckyMoneyNotHookReceiveUI.this.finish();
            }
            AppMethodBeat.m2505o(42855);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI$9 */
    class C344879 implements C1202f {
        C344879() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(42856);
            if (C5046bo.m7563gW(c1207m.getType(), 697) && (c1207m instanceof C27737e)) {
                C27737e c27737e = (C27737e) c1207m;
                if (i == 0 && i2 == 0) {
                    C23399hv bku = c27737e.bku();
                    if (bku != null && bku.vKl != null && bku.vKl.size() > 0 && C5046bo.isEqual(((C40588xx) bku.vKl.get(0)).Md5, LuckyMoneyNotHookReceiveUI.this.kZa.mo20410Aq())) {
                        LuckyMoneyNotHookReceiveUI.m56511a(LuckyMoneyNotHookReceiveUI.this, false);
                    }
                }
            }
            AppMethodBeat.m2505o(42856);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LuckyMoneyNotHookReceiveUI() {
        AppMethodBeat.m2504i(42860);
        AppMethodBeat.m2505o(42860);
    }

    /* renamed from: b */
    static /* synthetic */ void m56513b(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI, EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(42875);
        luckyMoneyNotHookReceiveUI.m56527z(emojiInfo);
        AppMethodBeat.m2505o(42875);
    }

    /* renamed from: j */
    static /* synthetic */ int m56522j(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI) {
        AppMethodBeat.m2504i(42879);
        int bMH = luckyMoneyNotHookReceiveUI.bMH();
        AppMethodBeat.m2505o(42879);
        return bMH;
    }

    /* renamed from: yi */
    static /* synthetic */ int m56526yi(int i) {
        AppMethodBeat.m2504i(42878);
        int yh = LuckyMoneyNotHookReceiveUI.m56525yh(i);
        AppMethodBeat.m2505o(42878);
        return yh;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42862);
        super.onDestroy();
        if (this.oex == 1 || this.oex == 2) {
            this.oec = new C9499aa();
            this.oec.cVT = 9;
            this.oec.ajK();
        }
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        C42952j.bkh().kVj = null;
        C1720g.m3535RO().eJo.mo14546b(697, this.oev);
        AppMethodBeat.m2505o(42862);
    }

    public void onResume() {
        AppMethodBeat.m2504i(42863);
        super.onResume();
        this.oes = C5046bo.anT();
        AppMethodBeat.m2505o(42863);
    }

    public void onPause() {
        AppMethodBeat.m2504i(42864);
        super.onPause();
        C26483d.m42198h("LuckyMoneyReceiveUI", this.oes, C5046bo.anT());
        AppMethodBeat.m2505o(42864);
    }

    public void finish() {
        AppMethodBeat.m2504i(42865);
        super.finish();
        overridePendingTransition(0, C25738R.anim.f8331b4);
        AppMethodBeat.m2505o(42865);
    }

    public boolean enableActivityAnimation() {
        return false;
    }

    public final void initView() {
        int i;
        AppMethodBeat.m2504i(42866);
        mo17446xE(-839716110);
        this.ogq = findViewById(2131825642);
        this.ius = (ViewGroup) findViewById(2131825641);
        this.ogp = (LinearLayout) findViewById(2131825649);
        this.nSM = (ImageView) findViewById(2131825516);
        this.nTD = (TextView) findViewById(2131825517);
        this.kGq = (TextView) findViewById(2131825522);
        this.nsq = (TextView) findViewById(2131825650);
        this.odG = (RelativeLayout) findViewById(2131825469);
        this.odH = (BaseEmojiView) findViewById(2131825470);
        this.odI = (TextView) findViewById(2131825471);
        this.odJ = (LinearLayout) findViewById(2131825472);
        this.odK = (MMAnimateView) findViewById(2131825473);
        this.nTE = (Button) findViewById(2131825651);
        this.nTH = (TextView) findViewById(2131825653);
        this.nTF = findViewById(2131825652);
        this.nTG = (ImageView) findViewById(2131825523);
        this.ogr = (ImageView) findViewById(2131825643);
        this.nVJ = (ImageView) findViewById(2131825524);
        this.nVJ.setOnClickListener(new C212366());
        this.ogs = (ImageView) findViewById(2131825648);
        this.ogt = (RelativeLayout) findViewById(2131825645);
        this.odI.setOnClickListener(new C212377());
        this.kGq.setLines(2);
        C0540q.m1169d(this.kGq);
        this.maxSize = (int) (((float) C1338a.m2857am(this.mController.ylL, C25738R.dimen.a4j)) * 1.375f);
        this.textSize = C1338a.m2856al(this.mController.ylL, C25738R.dimen.a4j);
        if (this.textSize > this.maxSize) {
            i = this.maxSize;
        } else {
            i = this.textSize;
        }
        this.textSize = i;
        this.mController.contentView.setVisibility(8);
        this.tipDialog = C30379h.m48426a(this.mController.ylL, 3, (int) C25738R.style.f10970kd, getString(C25738R.string.cn5), true, new C344868());
        bLf();
        AppMethodBeat.m2505o(42866);
    }

    private void bLf() {
        AppMethodBeat.m2504i(42867);
        if (this.nTE == null) {
            AppMethodBeat.m2505o(42867);
            return;
        }
        C6998b.oTO.mo8084Ao(this.nTE.getId());
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
        C4996ah.getContext();
        String g = C4988aa.m7402g(sharedPreferences);
        if (g == null || g.length() <= 0 || !(g.equals("zh_CN") || g.equals("zh_TW") || g.equals("zh_HK"))) {
            this.nTE.setBackgroundResource(C25738R.drawable.f6846sx);
            this.nTE.setText(C25738R.string.csa);
            AppMethodBeat.m2505o(42867);
            return;
        }
        AppMethodBeat.m2505o(42867);
    }

    /* renamed from: iK */
    private void m56521iK(boolean z) {
        AppMethodBeat.m2504i(42868);
        C4990ab.m7417i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle:%s", Boolean.TRUE);
        this.odI.setVisibility(8);
        this.oex = 1;
        if (z) {
            this.oeu = 3;
        } else {
            this.oeu--;
            if (this.oeu == 0) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle fail!");
                this.odJ.setVisibility(8);
                this.odI.setVisibility(0);
                m56524yg(1);
                this.oex = 2;
                AppMethodBeat.m2505o(42868);
                return;
            }
        }
        this.kZa = C42952j.getEmojiStorageMgr().xYn.aqi(this.kWO);
        if (this.kZa == null) {
            this.kZa = new EmojiInfo();
            this.kZa.field_md5 = this.kWO;
            this.kZa.field_type = this.odX;
        } else if (C5730e.asZ(this.kZa.dve()) > 0 || this.kZa.mo48552xy() || this.kZa.duS()) {
            this.odH.setVisibility(0);
            m56527z(this.kZa);
            m56524yg(3);
            AppMethodBeat.m2505o(42868);
            return;
        }
        if (z) {
            this.odH.setVisibility(8);
            m56524yg(2);
            this.odJ.setVisibility(0);
            this.odK.setImageResource(C1318a.lucky_money_newyear_creat_loading);
            C42952j.bkh().kVj = this.kVj;
        }
        C42952j.bkh().mo35676s(this.kZa);
        C1720g.m3535RO().eJo.mo14539a(697, this.oev);
        AppMethodBeat.m2505o(42868);
    }

    /* renamed from: z */
    private void m56527z(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(42869);
        this.oex = 4;
        this.odH.setEmojiInfo(emojiInfo);
        this.ogs.setVisibility(0);
        this.oec = new C9499aa();
        this.oec.cVT = 8;
        this.oec.ajK();
        AppMethodBeat.m2505o(42869);
    }

    /* renamed from: yg */
    private void m56524yg(int i) {
        int b;
        AppMethodBeat.m2504i(42870);
        LayoutParams layoutParams = (LayoutParams) this.ogp.getLayoutParams();
        switch (i) {
            case 1:
                b = C4977b.m7371b((Context) this, 113.0f);
                break;
            case 2:
                b = C4977b.m7371b((Context) this, 97.0f);
                break;
            case 3:
                C26076b decoder = MMGIFJNIFactory.Companion.getDecoder(this.kZa);
                int Ov = (int) (((float) decoder.mo33673Ov()) * this.odH.getEmojiDensityScale());
                decoder.destroy();
                b = C4977b.m7371b((Context) this, 150.0f);
                if (Ov < b && !C5046bo.m7563gW(Ov, 0)) {
                    b = ((b - Ov) / 2) + C4977b.m7371b((Context) this, 53.0f);
                    break;
                }
                b = C4977b.m7371b((Context) this, 53.0f);
                break;
            default:
                b = C4977b.m7371b((Context) this, 53.0f);
                break;
        }
        layoutParams.topMargin = b;
        this.ogp.setLayoutParams(layoutParams);
        this.ogp.invalidate();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ogt.getLayoutParams();
        layoutParams2.topMargin = b - C4977b.m7371b((Context) this, 53.0f);
        this.ogt.setLayoutParams(layoutParams2);
        this.ogt.invalidate();
        AppMethodBeat.m2505o(42870);
    }

    public final int getLayoutId() {
        return 2130969995;
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(42871);
        C4990ab.m7416i("MicroMsg.LuckyMoneyNotHookReceiveUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + c1207m.getType());
        boolean a;
        if (!(c1207m instanceof C36787aq)) {
            if (c1207m instanceof C36786an) {
                C46063x.m85814d(this.nTE);
                this.nTE.setClickable(true);
                bLf();
                if (i == 0 && i2 == 0) {
                    final C36786an c36786an = (C36786an) c1207m;
                    C43285k.m77151a(this, C28461a.NOTSET);
                    if (c36786an.bLD() && c36786an.nYe.mo39946a((Activity) this, new C16077f() {
                        public final void bMI() {
                            AppMethodBeat.m2504i(42851);
                            LuckyMoneyNotHookReceiveUI.m56510a(LuckyMoneyNotHookReceiveUI.this, c36786an);
                            AppMethodBeat.m2505o(42851);
                        }
                    })) {
                        AppMethodBeat.m2505o(42871);
                        return true;
                    }
                    m56508a(c36786an);
                    if (this.ogw) {
                        C7060h.pYm.mo15419k(991, 13, 1);
                    }
                    AppMethodBeat.m2505o(42871);
                    return true;
                } else if (i2 == 416) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.dismiss();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNotHookReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    this.nTE.setBackgroundResource(C25738R.drawable.b5t);
                    C212344 c212344 = new C212344();
                    a = C46063x.m85808a(this, i2, c1207m, bundle, false, null, 1003);
                    AppMethodBeat.m2505o(42871);
                    return a;
                }
            } else if (c1207m instanceof C12425af) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    C12425af c12425af = (C12425af) c1207m;
                    Intent intent = new Intent();
                    intent.setClass(this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
                    intent.putExtra("key_lucky_money_can_received", true);
                    try {
                        intent.putExtra("key_detail_info", c12425af.nYn.toByteArray());
                        intent.putExtra("key_jump_from", 2);
                    } catch (IOException e) {
                        C4990ab.m7420w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                    }
                    intent.putExtra("key_native_url", this.ocK);
                    intent.putExtra("key_sendid", this.ocI);
                    intent.putExtra("key_anim_slide", true);
                    intent.putExtra("key_detail_emoji_md5", c12425af.nYA);
                    intent.putExtra("key_detail_emoji_type", c12425af.nYB);
                    intent.putExtra("key_username", getIntent().getStringExtra("key_username"));
                    intent.putExtra("key_emoji_switch", c12425af.nYC);
                    startActivity(intent);
                    finish();
                    AppMethodBeat.m2505o(42871);
                    return true;
                }
                C30379h.m48465bQ(this, str);
                finish();
                AppMethodBeat.m2505o(42871);
                return true;
            }
            AppMethodBeat.m2505o(42871);
            return false;
        } else if (i == 0 && i2 == 0) {
            this.nZs = (C36787aq) c1207m;
            this.nZk = this.nZs.nZk;
            C7060h.pYm.mo8381e(11701, Integer.valueOf(5), Integer.valueOf(LuckyMoneyNotHookReceiveUI.m56525yh(this.nZs.cRT)), Integer.valueOf(bMH()), Integer.valueOf(0), Integer.valueOf(1));
            C22583ab c22583ab = new C22583ab();
            c22583ab.field_mNativeUrl = this.ocK;
            c22583ab.field_hbType = this.nZs.cRT;
            c22583ab.field_hbStatus = this.nZs.cRU;
            c22583ab.field_receiveStatus = this.nZs.cRV;
            C14241r.cPF().mo38091a(c22583ab);
            if (this.nZs.cRV == 2) {
                mo24301b(new C12425af(this.ocI, 11, 0, this.ocK, "v1.0"), false);
            } else {
                if (!C5046bo.isNullOrNil(this.nZs.nYA)) {
                    this.oec = new C9499aa();
                    this.oec.cVT = 7;
                    this.oec.ajK();
                }
                C46063x.m85811b(this.nSM, this.nZs.nWR, this.nZs.nXl);
                C46063x.m85800a(this.mController.ylL, this.nTD, getString(C25738R.string.cts, new Object[]{this.nZs.nZg}));
                this.ogp.post(new C1244810());
                LayoutParams layoutParams;
                RelativeLayout.LayoutParams layoutParams2;
                if (this.nZs.cRV == 1 || this.nZs.cRU == 4 || this.nZs.cRU == 5 || this.nZs.cRU == 1) {
                    this.nTE.setVisibility(8);
                    if (C5046bo.isNullOrNil(this.nZs.nUk)) {
                        this.kGq.setVisibility(8);
                    } else {
                        this.kGq.setText(this.nZs.nUk);
                        this.kGq.setVisibility(0);
                    }
                    if (C5046bo.isNullOrNil(this.nZs.nWO)) {
                        this.nsq.setVisibility(8);
                    } else {
                        this.nsq.setText(this.nZs.nWO);
                        this.nsq.setVisibility(0);
                        this.nsq.setSingleLine(false);
                    }
                    layoutParams = (LayoutParams) this.ogp.getLayoutParams();
                    layoutParams.topMargin = C4977b.m7371b(this.mController.ylL, 106.0f);
                    this.ogp.setLayoutParams(layoutParams);
                    layoutParams2 = (RelativeLayout.LayoutParams) this.nTF.getLayoutParams();
                    layoutParams2.bottomMargin = C4977b.m7371b(this.mController.ylL, 30.0f);
                    this.nTF.setLayoutParams(layoutParams2);
                    layoutParams2 = (RelativeLayout.LayoutParams) this.ogt.getLayoutParams();
                    layoutParams2.topMargin = layoutParams.topMargin - C4977b.m7371b((Context) this, 53.0f);
                    this.ogt.setLayoutParams(layoutParams2);
                    this.ogt.invalidate();
                    a = true;
                } else {
                    if (!C5046bo.isNullOrNil(this.nZs.nWO)) {
                        this.kGq.setText(this.nZs.nWO);
                        this.kGq.setVisibility(0);
                    }
                    if (!C5046bo.isNullOrNil(this.nZs.nSd)) {
                        C46063x.m85800a(this.mController.ylL, this.nsq, this.nZs.nSd);
                        this.nsq.setVisibility(0);
                        this.kGq.setVisibility(8);
                    }
                    if (C5046bo.isNullOrNil(this.nZs.nYA) || !C5046bo.m7563gW(this.nZk, 1)) {
                        layoutParams = (LayoutParams) this.ogp.getLayoutParams();
                        layoutParams.topMargin = C4977b.m7371b(this.mController.ylL, 106.0f);
                        this.ogp.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) this.ogt.getLayoutParams();
                        layoutParams2.topMargin = layoutParams.topMargin - C4977b.m7371b((Context) this, 53.0f);
                        this.ogt.setLayoutParams(layoutParams2);
                        this.ogt.invalidate();
                    } else {
                        layoutParams = (LayoutParams) this.ogp.getLayoutParams();
                        layoutParams.topMargin = C4977b.m7371b(this.mController.ylL, 53.0f);
                        this.ogp.setLayoutParams(layoutParams);
                        this.kWO = this.nZs.nYA;
                        this.odX = this.nZs.nYB;
                        this.odG.setVisibility(0);
                        m56521iK(true);
                    }
                    this.nTE.setOnClickListener(new C2844011());
                    a = false;
                }
                if (C1853r.m3846Yz().equals(this.mXq) || (this.nZs.cRT == 1 && a)) {
                    if (this.nZs.cRT == 1) {
                        this.nTH.setText(C25738R.string.cqh);
                    }
                    this.nTF.setVisibility(0);
                    this.nTF.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(42859);
                            if (a) {
                                C7060h.pYm.mo8381e(11701, Integer.valueOf(6), Integer.valueOf(LuckyMoneyNotHookReceiveUI.m56526yi(LuckyMoneyNotHookReceiveUI.this.nZs.cRT)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.m56522j(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(1));
                            }
                            Intent intent = new Intent();
                            intent.setClass(LuckyMoneyNotHookReceiveUI.this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
                            intent.putExtra("key_native_url", LuckyMoneyNotHookReceiveUI.this.nZs.cRS);
                            intent.putExtra("key_sendid", LuckyMoneyNotHookReceiveUI.this.nZs.nSX);
                            intent.putExtra("key_lucky_money_can_received", true);
                            intent.putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
                            LuckyMoneyNotHookReceiveUI.this.startActivity(intent);
                            LuckyMoneyNotHookReceiveUI.this.finish();
                            AppMethodBeat.m2505o(42859);
                        }
                    });
                    this.nTG.setVisibility(8);
                } else {
                    this.nTF.setVisibility(8);
                    this.nTG.setVisibility(0);
                }
                if (!(this.nZs.nZm == null || this.nZs.nZm.nZq == null)) {
                    atb atb = this.nZs.nZm.nZq;
                    C4990ab.m7416i("MicroMsg.LuckyMoneyNotHookReceiveUI", "render envelope");
                    if (atb != null) {
                        ((C12405a) C1720g.m3528K(C12405a.class)).mo24255a(this.ogr, atb, null);
                        this.ogr.setVisibility(0);
                        this.nTG.setVisibility(8);
                        this.ogw = true;
                    }
                    String str2 = this.nZs.nZm.nZq.wwQ != null ? this.nZs.nZm.nZq.wwQ.wwW : "";
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (!C5046bo.isNullOrNil(this.nZs.nZm.nZq.wwP)) {
                        this.ogv = this.nZs.nZm.nZq.wwP;
                    }
                    C7060h.pYm.mo8381e(16598, Integer.valueOf(2), this.ogv, str2, stringExtra);
                }
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.setOnDismissListener(new C344852());
                    this.tipDialog.dismiss();
                }
                this.ius.setBackgroundResource(C25738R.color.f12146tz);
                C5222ae.m7955m(this, getResources().getColor(C25738R.color.f12146tz));
                this.mController.contentView.setVisibility(0);
                this.ogq.setVisibility(0);
                C46063x.m85815dn(this.ogq);
            }
            AppMethodBeat.m2505o(42871);
            return true;
        } else {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            AppMethodBeat.m2505o(42871);
            return false;
        }
    }

    /* renamed from: a */
    private void m56508a(final C36786an c36786an) {
        AppMethodBeat.m2504i(42872);
        C12428k c12428k = c36786an.nYn;
        if (c12428k.cRV == 2) {
            Intent intent = new Intent();
            intent.setClass(this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
            intent.putExtra("key_lucky_money_can_received", true);
            try {
                intent.putExtra("key_detail_info", c36786an.nYn.toByteArray());
                intent.putExtra("key_jump_from", 2);
            } catch (IOException e) {
                C4990ab.m7420w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
            }
            intent.putExtra("key_native_url", c36786an.cRS);
            intent.putExtra("key_sendid", c36786an.nSX);
            if (C26373g.m41964Nu().getInt("PlayCoinSound", 0) > 0) {
                intent.putExtra("play_sound", true);
            }
            if (c36786an.nTN != null) {
                intent.putExtra("key_realname_guide_helper", c36786an.nTN);
            }
            intent.putExtra("key_username", getIntent().getStringExtra("key_username"));
            intent.putExtra("key_emoji_switch", c36786an.nYC);
            intent.putExtra("key_detail_emoji_md5", c36786an.nYA);
            intent.putExtra("key_detail_emoji_type", c36786an.nYB);
            startActivity(intent);
            finish();
            C22583ab c22583ab = new C22583ab();
            c22583ab.field_mNativeUrl = this.ocK;
            c22583ab.field_hbType = c12428k.cRT;
            c22583ab.field_receiveAmount = c12428k.cSh;
            c22583ab.field_receiveTime = System.currentTimeMillis();
            c22583ab.field_hbStatus = c12428k.cRU;
            c22583ab.field_receiveStatus = c12428k.cRV;
            if (c22583ab.field_receiveAmount > 0) {
                C14241r.cPF().mo38091a(c22583ab);
            }
            AppMethodBeat.m2505o(42872);
            return;
        }
        this.nTE.setBackgroundResource(C25738R.drawable.ban);
        this.nTE.setText(C25738R.string.cs8);
        this.nTE.setOnClickListener(null);
        this.nTE.setVisibility(8);
        if (C5046bo.isNullOrNil(c12428k.nUk)) {
            this.kGq.setVisibility(8);
        } else {
            this.kGq.setText(c12428k.nUk);
            this.kGq.setVisibility(0);
        }
        this.nsq.setText(c12428k.nWO);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nTF.getLayoutParams();
        layoutParams.bottomMargin = C4977b.m7371b(this.mController.ylL, 30.0f);
        this.nTF.setLayoutParams(layoutParams);
        if (C1853r.m3846Yz().equals(this.mXq) || c12428k.cRT == 1) {
            this.nTF.setVisibility(0);
            this.nTF.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(42852);
                    Intent intent = new Intent();
                    if (c36786an.nTN != null) {
                        intent.putExtra("key_realname_guide_helper", c36786an.nTN);
                    }
                    intent.setClass(LuckyMoneyNotHookReceiveUI.this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
                    intent.putExtra("key_lucky_money_can_received", true);
                    intent.putExtra("key_native_url", c36786an.cRS);
                    intent.putExtra("key_sendid", c36786an.nSX);
                    intent.putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
                    intent.putExtra("key_emoji_switch", c36786an.nYC);
                    intent.putExtra("key_detail_emoji_md5", c36786an.nYA);
                    intent.putExtra("key_detail_emoji_type", c36786an.nYB);
                    LuckyMoneyNotHookReceiveUI.this.startActivity(intent);
                    LuckyMoneyNotHookReceiveUI.this.finish();
                    AppMethodBeat.m2505o(42852);
                }
            });
            this.nTG.setVisibility(8);
            AppMethodBeat.m2505o(42872);
            return;
        }
        this.nTF.setVisibility(8);
        this.nTG.setVisibility(0);
        AppMethodBeat.m2505o(42872);
    }

    private int bMH() {
        AppMethodBeat.m2504i(42873);
        if (C1853r.m3846Yz().equals(this.mXq)) {
            AppMethodBeat.m2505o(42873);
            return 1;
        }
        AppMethodBeat.m2505o(42873);
        return 0;
    }

    /* renamed from: yh */
    private static int m56525yh(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 0) {
            return 2;
        }
        return 0;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42861);
        this.yll = true;
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(C25738R.color.a3p));
        }
        this.ocK = getIntent().getStringExtra("key_native_url");
        this.ogv = getIntent().getStringExtra("key_cropname");
        C4990ab.m7416i("MicroMsg.LuckyMoneyNotHookReceiveUI", "nativeUrl= " + C5046bo.nullAsNil(this.ocK));
        initView();
        Uri parse = Uri.parse(C5046bo.nullAsNil(this.ocK));
        try {
            this.ocI = parse.getQueryParameter("sendid");
        } catch (Exception e) {
        }
        this.ogu = C14241r.cPF().acN(this.ocK);
        if (this.ogu != null && this.ogu.field_receiveAmount > 0 && C5046bo.m7566gb(this.ogu.field_receiveTime) < 86400000) {
            C4990ab.m7417i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache this item %s %s", Long.valueOf(this.ogu.field_receiveTime), C5046bo.nullAsNil(this.ocK));
            Intent intent = new Intent();
            intent.setClass(this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
            intent.putExtra("key_native_url", this.ogu.field_mNativeUrl);
            intent.putExtra("key_sendid", this.ocI);
            intent.putExtra("key_anim_slide", true);
            intent.putExtra("key_lucky_money_can_received", true);
            intent.putExtra("key_username", getIntent().getStringExtra("key_username"));
            startActivity(intent);
            finish();
            AppMethodBeat.m2505o(42861);
        } else if (C5046bo.isNullOrNil(this.ocI)) {
            finish();
            C4990ab.m7420w("MicroMsg.LuckyMoneyNotHookReceiveUI", "sendid null & finish");
            AppMethodBeat.m2505o(42861);
        } else {
            int i = C5046bo.getInt(parse.getQueryParameter("channelid"), 1);
            this.mXq = parse.getQueryParameter("sendusername");
            mo24301b(new C36787aq(i, this.ocI, this.ocK, getIntent().getIntExtra("key_way", 0), "v1.0"), false);
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
            AppMethodBeat.m2505o(42861);
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m56519h(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI) {
        AppMethodBeat.m2504i(42877);
        ImageView imageView = (ImageView) luckyMoneyNotHookReceiveUI.findViewById(2131825647);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = luckyMoneyNotHookReceiveUI.nsq.getMeasuredWidth() + 130;
        imageView.setLayoutParams(layoutParams);
        imageView = (ImageView) luckyMoneyNotHookReceiveUI.findViewById(2131825646);
        layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = luckyMoneyNotHookReceiveUI.ogp.getMeasuredWidth() + 130;
        imageView.setLayoutParams(layoutParams);
        luckyMoneyNotHookReceiveUI.ogt.setVisibility(0);
        luckyMoneyNotHookReceiveUI.ogt.invalidate();
        AppMethodBeat.m2505o(42877);
    }
}
