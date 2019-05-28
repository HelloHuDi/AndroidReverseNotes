package com.tencent.p177mm.plugin.collect.reward.p367ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.base.MMGridView;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.collect.reward.p366a.C20269g;
import com.tencent.p177mm.plugin.collect.reward.p366a.C33863a.C33864a;
import com.tencent.p177mm.plugin.collect.reward.p937b.C11434b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI */
public class QrRewardSetMoneyUI extends QrRewardBaseUI {
    private String desc;
    private String hHN;
    private TextView iDT;
    private MMGridView kEY;
    private Button kEZ;
    private int kEb;
    private ImageView kEn;
    private MMEditText kFa;
    private TextView kFb;
    private TextView kFc;
    private SparseArray<WalletFormView> kFd;
    private List<Integer> kFe;
    private List<Integer> kFf;
    private boolean kFg = false;
    private Runnable kFh = new C276865();
    private TextWatcher kFi = new C276876();

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI$2 */
    class C114482 implements C33864a {
        C114482() {
        }

        /* renamed from: j */
        public final void mo6956j(C1207m c1207m) {
            AppMethodBeat.m2504i(41150);
            C4990ab.m7413e("MicroMsg.QrRewardSetMoneyUI", "net error: %s", c1207m);
            AppMethodBeat.m2505o(41150);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI$1 */
    class C276851 extends C24019s {
        C276851() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(41149);
            if (QrRewardSetMoneyUI.m44003a(QrRewardSetMoneyUI.this)) {
                C4990ab.m7416i("MicroMsg.QrRewardSetMoneyUI", "amt error!");
            } else {
                QrRewardSetMoneyUI.m44005b(QrRewardSetMoneyUI.this);
            }
            C7060h.pYm.mo8381e(14721, Integer.valueOf(1), Integer.valueOf(2));
            AppMethodBeat.m2505o(41149);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI$5 */
    class C276865 implements Runnable {
        C276865() {
        }

        public final void run() {
            AppMethodBeat.m2504i(41153);
            QrRewardSetMoneyUI.m44003a(QrRewardSetMoneyUI.this);
            AppMethodBeat.m2505o(41153);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI$6 */
    class C276876 implements TextWatcher {
        C276876() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(41154);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 3) {
                editable.delete(indexOf + 3, length);
            } else if (indexOf > 6) {
                editable.delete(6, indexOf);
            } else if (indexOf == -1 && length > 6) {
                editable.delete(6, length);
            }
            C5004al.m7439af(QrRewardSetMoneyUI.this.kFh);
            C5004al.m7442n(QrRewardSetMoneyUI.this.kFh, 50);
            AppMethodBeat.m2505o(41154);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI$a */
    class C27690a extends BaseAdapter {
        private C27690a() {
        }

        /* synthetic */ C27690a(QrRewardSetMoneyUI qrRewardSetMoneyUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(41155);
            int size = QrRewardSetMoneyUI.this.kFf.size();
            AppMethodBeat.m2505o(41155);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(41156);
            Object obj = QrRewardSetMoneyUI.this.kFf.get(i);
            AppMethodBeat.m2505o(41156);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            AppMethodBeat.m2504i(41157);
            if (view == null) {
                view2 = (View) QrRewardSetMoneyUI.this.kFd.get(i);
            } else {
                view2 = view;
            }
            AppMethodBeat.m2505o(41157);
            return view2;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public QrRewardSetMoneyUI() {
        AppMethodBeat.m2504i(41158);
        AppMethodBeat.m2505o(41158);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41159);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.dg6);
        mo39992nf(1562);
        List<String> hT = C5046bo.m7569hT((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, (Object) ""), ",");
        this.kFe = new ArrayList();
        if (hT.isEmpty()) {
            C4990ab.m7416i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
            this.kFe = Arrays.asList(C11434b.kDG);
        } else {
            for (String str : hT) {
                this.kFe.add(Integer.valueOf(C5046bo.getInt(str, 0)));
            }
        }
        this.kFf = new ArrayList(this.kFe);
        this.kEb = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_QR_REWARD_MAX_AMT_INT_SYNC, Integer.valueOf(C1625i.sHCENCODEVIDEOTIMEOUT))).intValue();
        this.kFg = getIntent().getBooleanExtra("key_first_flag", false);
        this.desc = getIntent().getStringExtra("key_desc_word");
        this.kFd = new SparseArray();
        bhg();
        initView();
        AppMethodBeat.m2505o(41159);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41160);
        this.kEY = (MMGridView) findViewById(2131826776);
        this.kEZ = (Button) findViewById(2131826777);
        this.kFb = (TextView) findViewById(2131826779);
        this.kEn = (ImageView) findViewById(2131826773);
        this.kFa = (MMEditText) findViewById(2131826775);
        this.iDT = (TextView) findViewById(2131826774);
        this.kFc = (TextView) findViewById(2131826778);
        CharSequence YB = C1853r.m3820YB();
        if (C5046bo.isNullOrNil(YB)) {
            YB = C1853r.m3821YC();
        }
        this.iDT.setText(C44089j.m79292b(this.mController.ylL, YB));
        C40460b.m69433a(this.kEn, C1853r.m3846Yz(), 0.06f, false);
        this.kEY.setAdapter(new C27690a(this, (byte) 0));
        if (!C5046bo.isNullOrNil(this.desc)) {
            this.kFa.setText(C44089j.m79293b((Context) this, this.desc, this.kFa.getTextSize()));
        }
        this.kFb.setText(getString(C25738R.string.dg3, new Object[]{Math.round(((float) this.kEb) / 100.0f)}));
        if (this.kFg) {
            this.kEZ.setText(C25738R.string.dfk);
            this.kFc.setVisibility(8);
        }
        this.kEZ.setOnClickListener(new C276851());
        AppMethodBeat.m2505o(41160);
    }

    public final int getLayoutId() {
        return 2130970437;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41161);
        super.onDestroy();
        mo39993ng(1562);
        C5004al.m7439af(this.kFh);
        AppMethodBeat.m2505o(41161);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41162);
        if (c1207m instanceof C20269g) {
            final C20269g c20269g = (C20269g) c1207m;
            c20269g.mo54407a(new C33864a() {
                /* renamed from: j */
                public final void mo6956j(C1207m c1207m) {
                    AppMethodBeat.m2504i(41152);
                    QrRewardSetMoneyUI.this.hHN = c20269g.kDA.pOy;
                    QrRewardSetMoneyUI.this.desc = c20269g.kDA.desc;
                    Intent intent = new Intent();
                    intent.putExtra("key_desc", c20269g.kDA.desc);
                    intent.putExtra("key_photo_url", c20269g.kDA.pOy);
                    intent.putExtra("key_photo_aeskey", c20269g.kDA.vWr);
                    intent.putExtra("key_photo_width", c20269g.kDA.vWw);
                    intent.putExtra("key_icon_width", c20269g.kDA.vWs);
                    intent.putExtra("key_return_from_first", QrRewardSetMoneyUI.this.kFg);
                    QrRewardSetMoneyUI.this.setResult(-1, intent);
                    QrRewardSetMoneyUI.this.finish();
                    AppMethodBeat.m2505o(41152);
                }
            }).mo54408b(new C33864a() {
                /* renamed from: j */
                public final void mo6956j(C1207m c1207m) {
                    AppMethodBeat.m2504i(41151);
                    C4990ab.m7413e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", Integer.valueOf(c20269g.kDA.kCl), c20269g.kDA.kCm);
                    if (C5046bo.isNullOrNil(c20269g.kDA.kCm)) {
                        Toast.makeText(QrRewardSetMoneyUI.this, C25738R.string.dg1, 1).show();
                        AppMethodBeat.m2505o(41151);
                        return;
                    }
                    Toast.makeText(QrRewardSetMoneyUI.this, c20269g.kDA.kCm, 1).show();
                    AppMethodBeat.m2505o(41151);
                }
            }).mo54410c(new C114482());
        }
        AppMethodBeat.m2505o(41162);
        return false;
    }

    private boolean bhf() {
        AppMethodBeat.m2504i(41163);
        int i = 0;
        while (i < this.kFe.size()) {
            if (((Integer) this.kFe.get(i)).equals(this.kFf.get(i))) {
                i++;
            } else {
                C4990ab.m7417i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", this.kFe.get(i), this.kFf.get(i));
                AppMethodBeat.m2505o(41163);
                return true;
            }
        }
        AppMethodBeat.m2505o(41163);
        return false;
    }

    private void bhg() {
        AppMethodBeat.m2504i(41164);
        for (int i = 0; i < this.kFf.size(); i++) {
            WalletFormView walletFormView = (WalletFormView) LayoutInflater.from(this.mController.ylL).inflate(2130970435, null);
            walletFormView.mo64594a(this.kFi);
            int intValue = ((Integer) this.kFf.get(i)).intValue();
            if (((double) intValue) / 100.0d > ((double) (intValue / 100))) {
                walletFormView.setText(String.format("%.2f", new Object[]{Double.valueOf(((double) intValue) / 100.0d)}));
            } else {
                walletFormView.setText(String.format("%d", new Object[]{Integer.valueOf(intValue / 100)}));
            }
            mo39989e(walletFormView, 2, false);
            this.kFd.put(i, walletFormView);
        }
        AppMethodBeat.m2505o(41164);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m44003a(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        AppMethodBeat.m2504i(41165);
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < qrRewardSetMoneyUI.kFd.size(); i2++) {
            WalletFormView walletFormView = (WalletFormView) qrRewardSetMoneyUI.kFd.get(i2);
            int round = (int) Math.round(C5046bo.getDouble(walletFormView.getText(), 0.0d) * 100.0d);
            qrRewardSetMoneyUI.kFf.set(i2, Integer.valueOf(round));
            if (round > qrRewardSetMoneyUI.kEb) {
                walletFormView.setContentTextColorRes(C25738R.color.f11667cn);
                z = true;
            } else {
                if (round <= 0) {
                    i = true;
                }
                walletFormView.setContentTextColorRes(C25738R.color.f11782h4);
            }
        }
        if (z) {
            if (!qrRewardSetMoneyUI.kFb.isShown()) {
                qrRewardSetMoneyUI.kFb.startAnimation(AnimationUtils.loadAnimation(qrRewardSetMoneyUI, C25738R.anim.f8343bh));
                qrRewardSetMoneyUI.kFb.setVisibility(0);
            }
            qrRewardSetMoneyUI.kEZ.setEnabled(false);
        } else if (i != 0) {
            qrRewardSetMoneyUI.kEZ.setEnabled(false);
        } else {
            if (qrRewardSetMoneyUI.kFb.isShown()) {
                qrRewardSetMoneyUI.kFb.startAnimation(AnimationUtils.loadAnimation(qrRewardSetMoneyUI, C25738R.anim.f8359c1));
                qrRewardSetMoneyUI.kFb.setVisibility(8);
            }
            qrRewardSetMoneyUI.kEZ.setEnabled(true);
        }
        AppMethodBeat.m2505o(41165);
        return z;
    }

    /* renamed from: b */
    static /* synthetic */ void m44005b(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        AppMethodBeat.m2504i(41166);
        C4990ab.m7416i("MicroMsg.QrRewardSetMoneyUI", "do set code");
        C1207m c20269g = new C20269g(new LinkedList(qrRewardSetMoneyUI.kFf), qrRewardSetMoneyUI.kFa.getText().toString().replace(IOUtils.LINE_SEPARATOR_UNIX, ""), qrRewardSetMoneyUI.kFg, qrRewardSetMoneyUI.bhf());
        c20269g.mo54411z(qrRewardSetMoneyUI);
        qrRewardSetMoneyUI.mo39970a(c20269g, true, false);
        AppMethodBeat.m2505o(41166);
    }
}
