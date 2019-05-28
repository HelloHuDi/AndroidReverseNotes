package com.tencent.mm.plugin.collect.reward.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.collect.reward.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
    private Runnable kFh = new Runnable() {
        public final void run() {
            AppMethodBeat.i(41153);
            QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this);
            AppMethodBeat.o(41153);
        }
    };
    private TextWatcher kFi = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(41154);
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
            al.af(QrRewardSetMoneyUI.this.kFh);
            al.n(QrRewardSetMoneyUI.this.kFh, 50);
            AppMethodBeat.o(41154);
        }
    };

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(QrRewardSetMoneyUI qrRewardSetMoneyUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(41155);
            int size = QrRewardSetMoneyUI.this.kFf.size();
            AppMethodBeat.o(41155);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(41156);
            Object obj = QrRewardSetMoneyUI.this.kFf.get(i);
            AppMethodBeat.o(41156);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            AppMethodBeat.i(41157);
            if (view == null) {
                view2 = (View) QrRewardSetMoneyUI.this.kFd.get(i);
            } else {
                view2 = view;
            }
            AppMethodBeat.o(41157);
            return view2;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public QrRewardSetMoneyUI() {
        AppMethodBeat.i(41158);
        AppMethodBeat.o(41158);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41159);
        super.onCreate(bundle);
        setMMTitle((int) R.string.dg6);
        nf(1562);
        List<String> hT = bo.hT((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, (Object) ""), ",");
        this.kFe = new ArrayList();
        if (hT.isEmpty()) {
            ab.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
            this.kFe = Arrays.asList(b.kDG);
        } else {
            for (String str : hT) {
                this.kFe.add(Integer.valueOf(bo.getInt(str, 0)));
            }
        }
        this.kFf = new ArrayList(this.kFe);
        this.kEb = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_QR_REWARD_MAX_AMT_INT_SYNC, Integer.valueOf(i.sHCENCODEVIDEOTIMEOUT))).intValue();
        this.kFg = getIntent().getBooleanExtra("key_first_flag", false);
        this.desc = getIntent().getStringExtra("key_desc_word");
        this.kFd = new SparseArray();
        bhg();
        initView();
        AppMethodBeat.o(41159);
    }

    public final void initView() {
        AppMethodBeat.i(41160);
        this.kEY = (MMGridView) findViewById(R.id.dtg);
        this.kEZ = (Button) findViewById(R.id.dth);
        this.kFb = (TextView) findViewById(R.id.dtj);
        this.kEn = (ImageView) findViewById(R.id.dtd);
        this.kFa = (MMEditText) findViewById(R.id.dtf);
        this.iDT = (TextView) findViewById(R.id.dte);
        this.kFc = (TextView) findViewById(R.id.dti);
        CharSequence YB = r.YB();
        if (bo.isNullOrNil(YB)) {
            YB = r.YC();
        }
        this.iDT.setText(j.b(this.mController.ylL, YB));
        com.tencent.mm.pluginsdk.ui.a.b.a(this.kEn, r.Yz(), 0.06f, false);
        this.kEY.setAdapter(new a(this, (byte) 0));
        if (!bo.isNullOrNil(this.desc)) {
            this.kFa.setText(j.b((Context) this, this.desc, this.kFa.getTextSize()));
        }
        this.kFb.setText(getString(R.string.dg3, new Object[]{Math.round(((float) this.kEb) / 100.0f)}));
        if (this.kFg) {
            this.kEZ.setText(R.string.dfk);
            this.kFc.setVisibility(8);
        }
        this.kEZ.setOnClickListener(new s() {
            public final void bgW() {
                AppMethodBeat.i(41149);
                if (QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this)) {
                    ab.i("MicroMsg.QrRewardSetMoneyUI", "amt error!");
                } else {
                    QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this);
                }
                h.pYm.e(14721, Integer.valueOf(1), Integer.valueOf(2));
                AppMethodBeat.o(41149);
            }
        });
        AppMethodBeat.o(41160);
    }

    public final int getLayoutId() {
        return R.layout.amg;
    }

    public void onDestroy() {
        AppMethodBeat.i(41161);
        super.onDestroy();
        ng(1562);
        al.af(this.kFh);
        AppMethodBeat.o(41161);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41162);
        if (mVar instanceof com.tencent.mm.plugin.collect.reward.a.g) {
            final com.tencent.mm.plugin.collect.reward.a.g gVar = (com.tencent.mm.plugin.collect.reward.a.g) mVar;
            gVar.a(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void j(m mVar) {
                    AppMethodBeat.i(41152);
                    QrRewardSetMoneyUI.this.hHN = gVar.kDA.pOy;
                    QrRewardSetMoneyUI.this.desc = gVar.kDA.desc;
                    Intent intent = new Intent();
                    intent.putExtra("key_desc", gVar.kDA.desc);
                    intent.putExtra("key_photo_url", gVar.kDA.pOy);
                    intent.putExtra("key_photo_aeskey", gVar.kDA.vWr);
                    intent.putExtra("key_photo_width", gVar.kDA.vWw);
                    intent.putExtra("key_icon_width", gVar.kDA.vWs);
                    intent.putExtra("key_return_from_first", QrRewardSetMoneyUI.this.kFg);
                    QrRewardSetMoneyUI.this.setResult(-1, intent);
                    QrRewardSetMoneyUI.this.finish();
                    AppMethodBeat.o(41152);
                }
            }).b(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void j(m mVar) {
                    AppMethodBeat.i(41151);
                    ab.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", Integer.valueOf(gVar.kDA.kCl), gVar.kDA.kCm);
                    if (bo.isNullOrNil(gVar.kDA.kCm)) {
                        Toast.makeText(QrRewardSetMoneyUI.this, R.string.dg1, 1).show();
                        AppMethodBeat.o(41151);
                        return;
                    }
                    Toast.makeText(QrRewardSetMoneyUI.this, gVar.kDA.kCm, 1).show();
                    AppMethodBeat.o(41151);
                }
            }).c(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void j(m mVar) {
                    AppMethodBeat.i(41150);
                    ab.e("MicroMsg.QrRewardSetMoneyUI", "net error: %s", mVar);
                    AppMethodBeat.o(41150);
                }
            });
        }
        AppMethodBeat.o(41162);
        return false;
    }

    private boolean bhf() {
        AppMethodBeat.i(41163);
        int i = 0;
        while (i < this.kFe.size()) {
            if (((Integer) this.kFe.get(i)).equals(this.kFf.get(i))) {
                i++;
            } else {
                ab.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", this.kFe.get(i), this.kFf.get(i));
                AppMethodBeat.o(41163);
                return true;
            }
        }
        AppMethodBeat.o(41163);
        return false;
    }

    private void bhg() {
        AppMethodBeat.i(41164);
        for (int i = 0; i < this.kFf.size(); i++) {
            WalletFormView walletFormView = (WalletFormView) LayoutInflater.from(this.mController.ylL).inflate(R.layout.ame, null);
            walletFormView.a(this.kFi);
            int intValue = ((Integer) this.kFf.get(i)).intValue();
            if (((double) intValue) / 100.0d > ((double) (intValue / 100))) {
                walletFormView.setText(String.format("%.2f", new Object[]{Double.valueOf(((double) intValue) / 100.0d)}));
            } else {
                walletFormView.setText(String.format("%d", new Object[]{Integer.valueOf(intValue / 100)}));
            }
            e(walletFormView, 2, false);
            this.kFd.put(i, walletFormView);
        }
        AppMethodBeat.o(41164);
    }

    static /* synthetic */ boolean a(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        AppMethodBeat.i(41165);
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < qrRewardSetMoneyUI.kFd.size(); i2++) {
            WalletFormView walletFormView = (WalletFormView) qrRewardSetMoneyUI.kFd.get(i2);
            int round = (int) Math.round(bo.getDouble(walletFormView.getText(), 0.0d) * 100.0d);
            qrRewardSetMoneyUI.kFf.set(i2, Integer.valueOf(round));
            if (round > qrRewardSetMoneyUI.kEb) {
                walletFormView.setContentTextColorRes(R.color.cn);
                z = true;
            } else {
                if (round <= 0) {
                    i = true;
                }
                walletFormView.setContentTextColorRes(R.color.h4);
            }
        }
        if (z) {
            if (!qrRewardSetMoneyUI.kFb.isShown()) {
                qrRewardSetMoneyUI.kFb.startAnimation(AnimationUtils.loadAnimation(qrRewardSetMoneyUI, R.anim.bh));
                qrRewardSetMoneyUI.kFb.setVisibility(0);
            }
            qrRewardSetMoneyUI.kEZ.setEnabled(false);
        } else if (i != 0) {
            qrRewardSetMoneyUI.kEZ.setEnabled(false);
        } else {
            if (qrRewardSetMoneyUI.kFb.isShown()) {
                qrRewardSetMoneyUI.kFb.startAnimation(AnimationUtils.loadAnimation(qrRewardSetMoneyUI, R.anim.c1));
                qrRewardSetMoneyUI.kFb.setVisibility(8);
            }
            qrRewardSetMoneyUI.kEZ.setEnabled(true);
        }
        AppMethodBeat.o(41165);
        return z;
    }

    static /* synthetic */ void b(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        AppMethodBeat.i(41166);
        ab.i("MicroMsg.QrRewardSetMoneyUI", "do set code");
        m gVar = new com.tencent.mm.plugin.collect.reward.a.g(new LinkedList(qrRewardSetMoneyUI.kFf), qrRewardSetMoneyUI.kFa.getText().toString().replace(IOUtils.LINE_SEPARATOR_UNIX, ""), qrRewardSetMoneyUI.kFg, qrRewardSetMoneyUI.bhf());
        gVar.z(qrRewardSetMoneyUI);
        qrRewardSetMoneyUI.a(gVar, true, false);
        AppMethodBeat.o(41166);
    }
}
