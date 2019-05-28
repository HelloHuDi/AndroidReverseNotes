package com.tencent.p177mm.plugin.collect.reward.p367ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C33325s;
import com.tencent.p177mm.plugin.collect.reward.p366a.C2836h;
import com.tencent.p177mm.plugin.collect.reward.p366a.C33863a.C33864a;
import com.tencent.p177mm.plugin.collect.reward.p366a.C36753b;
import com.tencent.p177mm.plugin.collect.reward.p937b.C45820a;
import com.tencent.p177mm.plugin.collect.reward.p937b.C45820a.C11433a;
import com.tencent.p177mm.plugin.emoji.p725b.C45845a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o.C35502a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.bpt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI */
public class QrRewardMainUI extends QrRewardBaseUI {
    private int cIZ;
    private String cQY;
    private String desc;
    private String hHN;
    private boolean kEA;
    private final int kEg = C1338a.fromDPToPix(this.mController.ylL, 200);
    private RelativeLayout kEh;
    private Button kEi;
    private ViewGroup kEj;
    private ViewGroup kEk;
    private RelativeLayout kEl;
    private CdnImageView kEm;
    private ImageView kEn;
    private ImageView kEo;
    private MMEditText kEp;
    private TextView kEq;
    private TextView kEr;
    private TextView kEs;
    private TextView kEt;
    private ScrollView kEu;
    private String kEv;
    private String kEw;
    private String kEx;
    private int kEy;
    private boolean kEz;
    private boolean mIsOpen = false;
    private String username;

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$5 */
    class C114475 implements C5279d {
        C114475() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(41087);
            switch (menuItem.getItemId()) {
                case 1:
                    QrRewardMainUI.this.kEv = "";
                    QrRewardMainUI.m84801o(QrRewardMainUI.this);
                    QrRewardMainUI.m84783c(QrRewardMainUI.this, true);
                    C7060h.pYm.mo8381e(14721, Integer.valueOf(1), Integer.valueOf(3));
                    AppMethodBeat.m2505o(41087);
                    return;
                case 2:
                    QrRewardMainUI.m84783c(QrRewardMainUI.this, false);
                    QrRewardMainUI.m84802p(QrRewardMainUI.this);
                    C7060h.pYm.mo8381e(14721, Integer.valueOf(1), Integer.valueOf(4));
                    AppMethodBeat.m2505o(41087);
                    return;
                default:
                    C4990ab.m7417i("MicroMsg.QrRewardMainUI", "unknown menu: %s", Integer.valueOf(menuItem.getItemId()));
                    QrRewardMainUI.m84783c(QrRewardMainUI.this, true);
                    AppMethodBeat.m2505o(41087);
                    return;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$17 */
    class C2027017 implements C33864a {
        C2027017() {
        }

        /* renamed from: j */
        public final void mo6956j(C1207m c1207m) {
            AppMethodBeat.m2504i(41101);
            C4990ab.m7413e("MicroMsg.QrRewardMainUI", "net error: %s", c1207m);
            QrRewardMainUI.this.kEv = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, (Object) "");
            QrRewardMainUI.m84783c(QrRewardMainUI.this, QrRewardMainUI.m84797l(QrRewardMainUI.this));
            QrRewardMainUI.this.kEp.setText("");
            QrRewardMainUI.m84795j(QrRewardMainUI.this);
            AppMethodBeat.m2505o(41101);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$6 */
    class C276836 implements C11433a {

        /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$6$1 */
        class C276841 implements Runnable {
            C276841() {
            }

            public final void run() {
                AppMethodBeat.m2504i(41088);
                QrRewardMainUI.m84803q(QrRewardMainUI.this);
                AppMethodBeat.m2505o(41088);
            }
        }

        C276836() {
        }

        /* renamed from: P */
        public final void mo23175P(String str, int i, int i2) {
            AppMethodBeat.m2504i(41089);
            C4990ab.m7417i("MicroMsg.QrRewardMainUI", "callback ret: %s, %s, %s", str, Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                C5004al.m7441d(new C276841());
            }
            AppMethodBeat.m2505o(41089);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$10 */
    class C3386610 implements OnEditorActionListener {
        C3386610() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(41093);
            C4990ab.m7417i("MicroMsg.QrRewardMainUI", "action: %s", Integer.valueOf(i));
            QrRewardMainUI.this.aqX();
            AppMethodBeat.m2505o(41093);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$11 */
    class C3386711 implements OnClickListener {
        C3386711() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41094);
            C4990ab.m7410d("MicroMsg.QrRewardMainUI", "click avatar");
            QrRewardMainUI.this.aqX();
            QrRewardMainUI.m84775a(QrRewardMainUI.this);
            AppMethodBeat.m2505o(41094);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$9 */
    class C338699 implements OnClickListener {
        C338699() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41092);
            C4990ab.m7410d("MicroMsg.QrRewardMainUI", "open click");
            QrRewardMainUI.m84777a(QrRewardMainUI.this, true);
            C7060h.pYm.mo8381e(14721, Integer.valueOf(1), Integer.valueOf(1));
            AppMethodBeat.m2505o(41092);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$12 */
    class C3675512 implements C35502a {
        C3675512() {
        }

        /* renamed from: df */
        public final void mo9537df(View view) {
            AppMethodBeat.m2504i(41095);
            C4990ab.m7416i("MicroMsg.QrRewardMainUI", "click save code");
            QrRewardMainUI.m84780b(QrRewardMainUI.this);
            C7060h.pYm.mo8381e(14721, Integer.valueOf(1), Integer.valueOf(5));
            AppMethodBeat.m2505o(41095);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$13 */
    class C3675613 implements C35502a {
        C3675613() {
        }

        /* renamed from: df */
        public final void mo9537df(View view) {
            AppMethodBeat.m2504i(41096);
            C4990ab.m7417i("MicroMsg.QrRewardMainUI", "click set code, %s", Boolean.valueOf(QrRewardMainUI.this.kEA));
            QrRewardMainUI.m84777a(QrRewardMainUI.this, false);
            AppMethodBeat.m2505o(41096);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$4 */
    class C367574 implements C36073c {
        C367574() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(41086);
            c44273l.mo70052a(1, QrRewardMainUI.this.getString(C25738R.string.dfs), QrRewardMainUI.m84797l(QrRewardMainUI.this) ? QrRewardMainUI.this.getString(C25738R.string.dfy) : "");
            c44273l.mo70052a(2, QrRewardMainUI.this.getString(C25738R.string.dft), !QrRewardMainUI.m84797l(QrRewardMainUI.this) ? QrRewardMainUI.this.getString(C25738R.string.dfy) : "");
            AppMethodBeat.m2505o(41086);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$7 */
    class C367587 implements C35502a {
        C367587() {
        }

        /* renamed from: df */
        public final void mo9537df(View view) {
            AppMethodBeat.m2504i(41090);
            C4990ab.m7411d("MicroMsg.QrRewardMainUI", "go to: %s", QrRewardMainUI.this.kEx);
            C36391e.m60016n(QrRewardMainUI.this.mController.ylL, QrRewardMainUI.this.kEx, false);
            C7060h.pYm.mo8381e(14721, Integer.valueOf(1), Integer.valueOf(6));
            AppMethodBeat.m2505o(41090);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$1 */
    class C388101 implements TextWatcher {
        int kEB = 0;

        C388101() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(41083);
            C4990ab.m7411d("MicroMsg.QrRewardMainUI", "s: %s, %s", editable.toString(), Integer.valueOf(editable.length()));
            String obj = editable.toString();
            if (C5046bo.isNullOrNil(obj)) {
                this.kEB = 0;
            } else if (this.kEB == 0) {
                if (((C45845a) C1720g.m3528K(C45845a.class)).mo68460G(obj) || ((C45845a) C1720g.m3528K(C45845a.class)).mo68461H(obj)) {
                    this.kEB = editable.length();
                } else {
                    this.kEB = 1;
                }
            }
            editable.delete(this.kEB, editable.length());
            AppMethodBeat.m2505o(41083);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public QrRewardMainUI() {
        AppMethodBeat.m2504i(41102);
        AppMethodBeat.m2505o(41102);
    }

    /* renamed from: a */
    static /* synthetic */ void m84776a(QrRewardMainUI qrRewardMainUI, String str, String str2) {
        AppMethodBeat.m2504i(41123);
        qrRewardMainUI.m84800n(str, str2, false);
        AppMethodBeat.m2505o(41123);
    }

    static /* synthetic */ void bhe() {
    }

    /* renamed from: f */
    static /* synthetic */ void m84790f(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.m2504i(41121);
        qrRewardMainUI.bhb();
        AppMethodBeat.m2505o(41121);
    }

    /* renamed from: i */
    static /* synthetic */ void m84794i(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.m2504i(41124);
        qrRewardMainUI.bha();
        AppMethodBeat.m2505o(41124);
    }

    /* renamed from: j */
    static /* synthetic */ void m84795j(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.m2504i(41125);
        qrRewardMainUI.bhc();
        AppMethodBeat.m2505o(41125);
    }

    /* renamed from: o */
    static /* synthetic */ void m84801o(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.m2504i(41128);
        qrRewardMainUI.bhd();
        AppMethodBeat.m2505o(41128);
    }

    /* renamed from: q */
    static /* synthetic */ void m84803q(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.m2504i(41130);
        qrRewardMainUI.bgX();
        AppMethodBeat.m2505o(41130);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.m2504i(41103);
        super.onCreate(bundle);
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        mo39992nf(1323);
        mo39992nf(1649);
        this.kEy = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_QR_REWARD_PHOTO_WIDTH_INT_SYNC, Integer.valueOf(TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR))).intValue();
        this.cIZ = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_QR_REWARD_ICON_WIDTH_INT_SYNC, Integer.valueOf(C33325s.CTRL_INDEX))).intValue();
        this.desc = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_QR_REWARD_DESC_STRING_SYNC, (Object) "");
        this.kEv = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, (Object) "");
        this.kEw = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_QR_REWARD_BOTTOM_STR_STRING_SYNC, (Object) "");
        this.kEx = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_QR_REWARD_BOTTOM_URL_STRING_SYNC, (Object) "");
        this.hHN = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_QR_REWARD_LAST_PHOTO_URL_STRING_SYNC, (Object) "");
        if (!C5046bo.isNullOrNil((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, (Object) ""))) {
            this.kEA = true;
        }
        this.username = C1853r.m3846Yz();
        setMMTitle((int) C25738R.string.dfr);
        initView();
        if (C45820a.bgS().bgT() && this.kEA) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.QrRewardMainUI", "do get code: %s", Boolean.valueOf(z));
        C1207m c36753b = new C36753b(z);
        c36753b.mo54411z(this);
        if (z) {
            mo39970a(c36753b, false, false);
            AppMethodBeat.m2505o(41103);
            return;
        }
        mo39970a(c36753b, true, false);
        AppMethodBeat.m2505o(41103);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41104);
        this.kEh = (RelativeLayout) findViewById(2131826741);
        this.kEi = (Button) findViewById(2131826744);
        this.kEj = (ViewGroup) findViewById(2131826743);
        this.kEk = (ViewGroup) findViewById(2131826745);
        this.kEm = (CdnImageView) findViewById(2131826747);
        this.kEq = (TextView) findViewById(2131826751);
        this.kEn = (ImageView) findViewById(2131826748);
        this.kEo = (ImageView) findViewById(2131826750);
        this.kEl = (RelativeLayout) findViewById(2131826746);
        this.kEp = (MMEditText) findViewById(2131826749);
        this.kEr = (TextView) findViewById(2131826753);
        this.kEt = (TextView) findViewById(2131826754);
        this.kEs = (TextView) findViewById(2131826755);
        C40460b.m69433a(this.kEn, this.username, 0.03f, true);
        try {
            this.kEp.setText(C44089j.m79293b(this.mController.ylL, this.kEv, this.kEp.getTextSize()));
            this.kEp.setSelection(this.kEv.length());
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.QrRewardMainUI", e, "", new Object[0]);
        }
        this.kEp.addTextChangedListener(new C388101());
        this.kEp.setOnEditorActionListener(new C3386610());
        this.kEo.setOnClickListener(new C3386711());
        this.kEr.setClickable(true);
        this.kEr.setOnTouchListener(new C30132m(this));
        C35503o c35503o = new C35503o(new C3675512());
        SpannableString spannableString = new SpannableString(getString(C25738R.string.dfw));
        spannableString.setSpan(c35503o, 0, spannableString.length(), 18);
        this.kEr.setText(spannableString);
        this.kEt.setClickable(true);
        this.kEt.setOnTouchListener(new C30132m(this));
        c35503o = new C35503o(new C3675613());
        spannableString = new SpannableString(getString(C25738R.string.dg6));
        spannableString.setSpan(c35503o, 0, spannableString.length(), 18);
        this.kEt.setText(spannableString);
        bgX();
        bha();
        bhc();
        bhb();
        AppMethodBeat.m2505o(41104);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41105);
        if (c1207m instanceof C36753b) {
            final C36753b c36753b = (C36753b) c1207m;
            c36753b.mo54407a(new C33864a() {
                /* renamed from: j */
                public final void mo6956j(C1207m c1207m) {
                    AppMethodBeat.m2504i(41100);
                    QrRewardMainUI.this.kEv = c36753b.kDu.jMS;
                    QrRewardMainUI.this.kEy = c36753b.kDu.vWw;
                    QrRewardMainUI.this.cIZ = c36753b.kDu.vWs;
                    QrRewardMainUI.this.desc = c36753b.kDu.desc;
                    QrRewardMainUI.this.cQY = c36753b.kDu.twd;
                    QrRewardMainUI.this.mIsOpen = !c36753b.kDu.vWq;
                    QrRewardMainUI.this.kEw = c36753b.kDu.kdE;
                    QrRewardMainUI.this.kEx = c36753b.kDu.vWu;
                    QrRewardMainUI.this.kEA = true;
                    QrRewardMainUI.m84790f(QrRewardMainUI.this);
                    if (QrRewardMainUI.this.mIsOpen) {
                        QrRewardMainUI.m84776a(QrRewardMainUI.this, c36753b.kDu.pOy, c36753b.kDu.vWr);
                        QrRewardMainUI.m84794i(QrRewardMainUI.this);
                        QrRewardMainUI.m84795j(QrRewardMainUI.this);
                    } else {
                        QrRewardMainUI.m84793h(QrRewardMainUI.this);
                    }
                    QrRewardMainUI.this.hHN = c36753b.kDu.pOy;
                    QrRewardMainUI.bhe();
                    C4990ab.m7411d("MicroMsg.QrRewardMainUI", "url: %s", QrRewardMainUI.this.hHN);
                    AppMethodBeat.m2505o(41100);
                }
            }).mo54408b(new C33864a() {

                /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI$15$1 */
                class C28391 implements DialogInterface.OnClickListener {
                    C28391() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(41098);
                        C4990ab.m7416i("MicroMsg.QrRewardMainUI", "RealnameVerifyUtil cancel");
                        AppMethodBeat.m2505o(41098);
                    }
                }

                /* renamed from: j */
                public final void mo6956j(C1207m c1207m) {
                    boolean z = true;
                    AppMethodBeat.m2504i(41099);
                    C4990ab.m7413e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", Integer.valueOf(c36753b.kDu.kCl), c36753b.kDu.kCm);
                    if (c36753b.kDu.kCl == 416) {
                        String str = "MicroMsg.QrRewardMainUI";
                        String str2 = "realNameInfo:%s";
                        Object[] objArr = new Object[1];
                        if (c36753b.kDu.vWf != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        C4990ab.m7411d(str, str2, objArr);
                        QrRewardMainUI.this.kEh.setVisibility(4);
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".reward.ui.CollectMainUI");
                        bundle.putString("realname_verify_process_jump_plugin", "collect");
                        Activity activity = QrRewardMainUI.this;
                        int i = c36753b.kDu.kCl;
                        bpt bpt = c36753b.kDu.vWf;
                        C28391 c28391 = new C28391();
                        C43795a.m78491a(activity, i, bpt, bundle, 1011);
                        AppMethodBeat.m2505o(41099);
                        return;
                    }
                    if (!C5046bo.isNullOrNil(c36753b.kDu.kCm)) {
                        Toast.makeText(QrRewardMainUI.this, c36753b.kDu.kCm, 0).show();
                    }
                    if (!c36753b.kDv) {
                        QrRewardMainUI.m84777a(QrRewardMainUI.this, false);
                    }
                    AppMethodBeat.m2505o(41099);
                }
            }).mo54410c(new C33864a() {
                /* renamed from: j */
                public final void mo6956j(C1207m c1207m) {
                    AppMethodBeat.m2504i(41097);
                    C4990ab.m7413e("MicroMsg.QrRewardMainUI", "net error: %s", c1207m);
                    if (!c36753b.kDv) {
                        QrRewardMainUI.m84777a(QrRewardMainUI.this, false);
                    }
                    AppMethodBeat.m2505o(41097);
                }
            });
            AppMethodBeat.m2505o(41105);
        } else {
            if (c1207m instanceof C2836h) {
                final C2836h c2836h = (C2836h) c1207m;
                c2836h.mo54407a(new C33864a() {
                    /* renamed from: j */
                    public final void mo6956j(C1207m c1207m) {
                        AppMethodBeat.m2504i(41085);
                        C4990ab.m7417i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", c2836h.jMS, QrRewardMainUI.this.kEp.getText());
                        if (c2836h.jMS.equals(QrRewardMainUI.this.kEv)) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, QrRewardMainUI.this.kEv);
                            QrRewardMainUI.m84795j(QrRewardMainUI.this);
                        }
                        AppMethodBeat.m2505o(41085);
                    }
                }).mo54408b(new C33864a() {
                    /* renamed from: j */
                    public final void mo6956j(C1207m c1207m) {
                        AppMethodBeat.m2504i(41084);
                        C4990ab.m7413e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", Integer.valueOf(c2836h.kDB.kCl), c2836h.kDB.kCm);
                        QrRewardMainUI.this.kEv = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, (Object) "");
                        QrRewardMainUI.m84783c(QrRewardMainUI.this, QrRewardMainUI.m84797l(QrRewardMainUI.this));
                        QrRewardMainUI.this.kEp.setText("");
                        QrRewardMainUI.m84795j(QrRewardMainUI.this);
                        if (!C5046bo.isNullOrNil(c2836h.kDB.kCm)) {
                            Toast.makeText(QrRewardMainUI.this, c2836h.kDB.kCm, 0).show();
                        }
                        AppMethodBeat.m2505o(41084);
                    }
                }).mo54410c(new C2027017());
                this.kEp.clearFocus();
                this.kEp.setCursorVisible(false);
            }
            AppMethodBeat.m2505o(41105);
        }
        return true;
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.m2504i(41106);
        super.onKeyboardStateChanged();
        C4990ab.m7417i("MicroMsg.QrRewardMainUI", "key board changed: %s", Integer.valueOf(this.mController.ymc));
        if (this.mController.ymc == 2) {
            this.kEv = this.kEp.getText().toString();
            bhd();
            if (C5046bo.isNullOrNil(this.kEv)) {
                m84791fV(true);
            }
        }
        AppMethodBeat.m2505o(41106);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(41107);
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            this.desc = intent.getStringExtra("key_desc");
            this.kEy = intent.getIntExtra("key_photo_width", TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
            this.cIZ = intent.getIntExtra("key_icon_width", C33325s.CTRL_INDEX);
            C4990ab.m7417i("MicroMsg.QrRewardMainUI", "return from first: %s", Boolean.valueOf(intent.getBooleanExtra("key_return_from_first", true)));
            if (intent.getBooleanExtra("key_return_from_first", true)) {
                this.kEk.setVisibility(0);
                this.kEj.setVisibility(8);
            }
            this.kEA = true;
            bha();
            String stringExtra = intent.getStringExtra("key_photo_url");
            m84800n(stringExtra, intent.getStringExtra("key_photo_aeskey"), true);
            this.hHN = stringExtra;
            AppMethodBeat.m2505o(41107);
            return;
        }
        AppMethodBeat.m2505o(41107);
    }

    public final int getLayoutId() {
        return 2130970431;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41108);
        super.onDestroy();
        mo39993ng(1323);
        mo39993ng(1649);
        C45820a bgS = C45820a.bgS();
        C4990ab.m7410d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
        if (bgS.jxd != null) {
            C4990ab.m7417i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", Integer.valueOf(bgS.jxd.size()));
            bgS.jxd.clear();
        }
        AppMethodBeat.m2505o(41108);
    }

    public final boolean aoE() {
        return false;
    }

    /* renamed from: n */
    private void m84800n(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(41109);
        boolean z2 = this.hHN != null && this.hHN.equals(str);
        C4990ab.m7417i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(C45820a.bgS().bgT()));
        if (!(!z && z2 && r3)) {
            C45820a.bgS().mo73622a(str, str2, new C276836());
        }
        AppMethodBeat.m2505o(41109);
    }

    private void bgX() {
        AppMethodBeat.m2504i(41110);
        if (C45820a.bgS().bgT()) {
            this.kEm.mo11120am(C45820a.bgS().bgV(), this.kEg, this.kEg);
            this.kEl.setVisibility(0);
            AppMethodBeat.m2505o(41110);
            return;
        }
        this.kEl.setVisibility(4);
        AppMethodBeat.m2505o(41110);
    }

    private void bgY() {
        AppMethodBeat.m2504i(41111);
        int round = Math.round(((float) this.kEg) * ((((float) this.cIZ) * 1.0f) / ((float) this.kEy)));
        if (round <= 0) {
            round = C31128d.MIC_PTU_ZIPAI_THURSDAY;
        }
        ViewGroup.LayoutParams layoutParams = this.kEo.getLayoutParams();
        layoutParams.width = round;
        layoutParams.height = round;
        this.kEo.setLayoutParams(layoutParams);
        layoutParams = this.kEn.getLayoutParams();
        layoutParams.width = round;
        layoutParams.height = round;
        this.kEn.setLayoutParams(layoutParams);
        layoutParams = this.kEp.getLayoutParams();
        layoutParams.width = round - 30;
        layoutParams.height = round - 30;
        this.kEp.setLayoutParams(layoutParams);
        this.kEp.setTextSize(0, (float) ((round * 2) / 3));
        this.kEk.requestLayout();
        AppMethodBeat.m2505o(41111);
    }

    private void bgZ() {
        AppMethodBeat.m2504i(41112);
        if (C5046bo.isNullOrNil(this.desc)) {
            this.kEq.setText("");
            AppMethodBeat.m2505o(41112);
            return;
        }
        this.kEq.setText(C44089j.m79293b((Context) this, getString(C25738R.string.dg8, new Object[]{this.desc}), this.kEq.getTextSize()));
        AppMethodBeat.m2505o(41112);
    }

    private void bha() {
        AppMethodBeat.m2504i(41113);
        bgY();
        bgZ();
        m84791fV(C5046bo.isNullOrNil(this.kEv));
        AppMethodBeat.m2505o(41113);
    }

    private void bhb() {
        AppMethodBeat.m2504i(41114);
        if (C5046bo.isNullOrNil(this.kEw)) {
            this.kEs.setVisibility(8);
            AppMethodBeat.m2505o(41114);
            return;
        }
        this.kEs.setClickable(true);
        this.kEs.setOnTouchListener(new C30132m(this));
        C35503o c35503o = new C35503o(new C367587());
        SpannableString spannableString = new SpannableString(this.kEw);
        spannableString.setSpan(c35503o, 0, spannableString.length(), 18);
        this.kEs.setText(spannableString);
        this.kEs.setVisibility(0);
        AppMethodBeat.m2505o(41114);
    }

    /* renamed from: fV */
    private void m84791fV(boolean z) {
        AppMethodBeat.m2504i(41115);
        C4990ab.m7417i("MicroMsg.QrRewardMainUI", "switch mode: %s", Boolean.valueOf(z));
        if (z) {
            this.kEn.setVisibility(0);
            this.kEp.setVisibility(4);
            C40460b.m69433a(this.kEn, this.username, 0.03f, true);
            AppMethodBeat.m2505o(41115);
            return;
        }
        this.kEn.setVisibility(4);
        this.kEp.setVisibility(0);
        AppMethodBeat.m2505o(41115);
    }

    private void bhd() {
        AppMethodBeat.m2504i(41117);
        C4990ab.m7416i("MicroMsg.QrRewardMainUI", "do set photo word");
        C1207m c2836h = new C2836h(this.kEv);
        c2836h.mo54411z(this);
        mo39970a(c2836h, true, false);
        AppMethodBeat.m2505o(41117);
    }

    private void bhc() {
        AppMethodBeat.m2504i(41116);
        if (!C5046bo.isNullOrNil(this.kEv)) {
            this.kEp.setText(C44089j.m79293b(this.mController.ylL, this.kEv, this.kEp.getTextSize()));
            this.kEp.setSelection(this.kEv.length());
        }
        AppMethodBeat.m2505o(41116);
    }

    /* renamed from: a */
    static /* synthetic */ void m84775a(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.m2504i(41118);
        C36356d c36356d = new C36356d(qrRewardMainUI, 1, false);
        c36356d.rBl = new C367574();
        c36356d.rBm = new C114475();
        c36356d.cpD();
        AppMethodBeat.m2505o(41118);
    }

    /* renamed from: b */
    static /* synthetic */ void m84780b(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.m2504i(41119);
        if (!qrRewardMainUI.kEz) {
            qrRewardMainUI.kEu = (ScrollView) ((ViewStub) qrRewardMainUI.findViewById(2131826756)).inflate();
            TextView textView = (TextView) qrRewardMainUI.kEu.findViewById(2131826764);
            textView.setText(C44089j.m79293b((Context) qrRewardMainUI, qrRewardMainUI.getString(C25738R.string.dfx, new Object[]{C36391e.m60007eK(C36391e.m60015mJ(qrRewardMainUI.username), 10)}), textView.getTextSize()));
            qrRewardMainUI.kEz = true;
        }
        final ImageView imageView = (ImageView) qrRewardMainUI.kEu.findViewById(2131826762);
        final ViewGroup viewGroup = (ViewGroup) qrRewardMainUI.kEu.findViewById(2131826758);
        if (!C5046bo.isNullOrNil(qrRewardMainUI.desc)) {
            ((TextView) qrRewardMainUI.kEu.findViewById(2131826763)).setText(C44089j.m79293b((Context) qrRewardMainUI, qrRewardMainUI.getString(C25738R.string.dg8, new Object[]{qrRewardMainUI.desc}), qrRewardMainUI.kEq.getTextSize()));
        }
        qrRewardMainUI.kEu.setVisibility(4);
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(41091);
                C4990ab.m7411d("MicroMsg.QrRewardMainUI", "height: %d, width: %d", Integer.valueOf(viewGroup.getHeight()), Integer.valueOf(viewGroup.getWidth()));
                Bitmap createBitmap = Bitmap.createBitmap(QrRewardMainUI.this.kEl.getWidth(), QrRewardMainUI.this.kEl.getHeight(), Config.ARGB_8888);
                QrRewardMainUI.this.kEl.draw(new Canvas(createBitmap));
                imageView.setImageBitmap(createBitmap);
                Bitmap createBitmap2 = Bitmap.createBitmap(viewGroup.getWidth(), viewGroup.getHeight(), Config.ARGB_8888);
                viewGroup.draw(new Canvas(createBitmap2));
                try {
                    String str = C14987n.dly() + "mm_reward_qrcode_" + System.currentTimeMillis() + ".png";
                    C5056d.m7625a(createBitmap2, 100, CompressFormat.PNG, str, false);
                    Toast.makeText(QrRewardMainUI.this.mController.ylL, QrRewardMainUI.this.getString(C25738R.string.b3r, new Object[]{str}), 1).show();
                    C14987n.m23300a(str, QrRewardMainUI.this.mController.ylL);
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.QrRewardMainUI", "save fixed amount qrcode failed!" + e.getMessage());
                }
                QrRewardMainUI.this.kEu.setVisibility(8);
                C4990ab.m7417i("MicroMsg.QrRewardMainUI", "bitmap recycle %s", createBitmap2.toString());
                createBitmap2.recycle();
                AppMethodBeat.m2505o(41091);
            }
        }, 250);
        AppMethodBeat.m2505o(41119);
    }

    /* renamed from: h */
    static /* synthetic */ void m84793h(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.m2504i(41122);
        C4990ab.m7416i("MicroMsg.QrRewardMainUI", "show first guide view");
        qrRewardMainUI.kEk.setVisibility(8);
        qrRewardMainUI.kEj.setVisibility(0);
        qrRewardMainUI.kEi.setOnClickListener(new C338699());
        AppMethodBeat.m2505o(41122);
    }

    /* renamed from: l */
    static /* synthetic */ boolean m84797l(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.m2504i(41126);
        boolean isNullOrNil = C5046bo.isNullOrNil(qrRewardMainUI.kEv);
        AppMethodBeat.m2505o(41126);
        return isNullOrNil;
    }

    /* renamed from: p */
    static /* synthetic */ void m84802p(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.m2504i(41129);
        qrRewardMainUI.kEp.setCursorVisible(true);
        qrRewardMainUI.kEp.requestFocus();
        qrRewardMainUI.kEp.requestFocusFromTouch();
        qrRewardMainUI.showVKB();
        AppMethodBeat.m2505o(41129);
    }
}
