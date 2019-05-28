package com.tencent.p177mm.plugin.wallet_ecard.p563ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p057v4.p058a.p059a.C0280a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C22672b;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C40149f;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C43818a;
import com.tencent.p177mm.plugin.wallet_ecard.p562b.C31461a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.C35922hb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI */
public class WalletECardBindCardListUI extends WalletECardBaseUI {
    private int jSu;
    private boolean tQA = true;
    private C30857a tQB = new C143382();
    private ListView tQw;
    private TextView tQx;
    private List<C35922hb> tQy = new ArrayList();
    private C29688c tQz;

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI$1 */
    class C143371 implements OnItemClickListener {
        C143371() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(48115);
            C4990ab.m7417i("MicroMsg.WalletECardBindCardListUI", "position: %d", Integer.valueOf(i));
            int itemViewType = adapterView.getAdapter().getItemViewType(i);
            WalletECardBindCardListUI.this.tQz.getClass();
            if (itemViewType == 1) {
                C4990ab.m7411d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", Integer.valueOf(WalletECardBindCardListUI.this.jSu));
                WalletECardBindCardListUI.this.cST();
                AppMethodBeat.m2505o(48115);
                return;
            }
            if (((C35922hb) adapterView.getAdapter().getItem(i)) == null) {
                C4990ab.m7420w("MicroMsg.WalletECardBindCardListUI", "empty item");
                AppMethodBeat.m2505o(48115);
                return;
            }
            WalletECardBindCardListUI.this.dOE().mo9366p(r0);
            AppMethodBeat.m2505o(48115);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI$2 */
    class C143382 implements C30857a {
        C143382() {
        }

        /* renamed from: n */
        public final Intent mo7785n(int i, Bundle bundle) {
            AppMethodBeat.m2504i(48116);
            C4990ab.m7417i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", Integer.valueOf(i), bundle);
            if (i == -1) {
                BindCardOrder bindCardOrder = (BindCardOrder) bundle.getParcelable("key_bindcard_value_result");
                if (bindCardOrder != null) {
                    C35922hb c35922hb = new C35922hb();
                    c35922hb.pbn = bundle.getString("key_bind_card_type");
                    c35922hb.vJH = bindCardOrder.txK;
                    c35922hb.tuk = bundle.getString("key_mobile");
                    if (!(C5046bo.isNullOrNil(c35922hb.vJH) || C5046bo.isNullOrNil(c35922hb.pbn) || C5046bo.isNullOrNil(c35922hb.tuk))) {
                        WalletECardBindCardListUI.this.dOE().mo9366p(c35922hb);
                        AppMethodBeat.m2505o(48116);
                        return null;
                    }
                }
                WalletECardBindCardListUI.m50899c(WalletECardBindCardListUI.this);
            }
            WalletECardBindCardListUI.this.tQA = false;
            AppMethodBeat.m2505o(48116);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI$d */
    class C22685d implements C31462b {
        TextView iDT;
        TextView kiF;
        CdnImageView tQE;

        public C22685d(View view) {
            AppMethodBeat.m2504i(48123);
            this.tQE = (CdnImageView) view.findViewById(2131823357);
            this.iDT = (TextView) view.findViewById(2131823358);
            this.kiF = (TextView) view.findViewById(2131823359);
            AppMethodBeat.m2505o(48123);
        }

        /* renamed from: a */
        public final void mo38266a(View view, C35922hb c35922hb) {
            AppMethodBeat.m2504i(48124);
            if (c35922hb != null) {
                this.tQE.setRoundCorner(true);
                this.tQE.setUrl(c35922hb.vJI);
                this.iDT.setText(String.format("%s %s(%s)", new Object[]{c35922hb.nuL, c35922hb.kmu, c35922hb.vJG}));
                if (C5046bo.isNullOrNil(c35922hb.vJK)) {
                    this.kiF.setText(String.format("%s", new Object[]{c35922hb.tuk}));
                } else {
                    this.kiF.setText(String.format("%s，%s", new Object[]{c35922hb.tuk, c35922hb.vJK}));
                }
                if (c35922hb.vJJ) {
                    C4990ab.m7417i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", c35922hb.nuL);
                    view.setEnabled(false);
                    this.iDT.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(C25738R.color.f11773gv));
                    this.kiF.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(C25738R.color.f11773gv));
                    AppMethodBeat.m2505o(48124);
                    return;
                }
                view.setEnabled(true);
                this.iDT.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(C25738R.color.f11782h4));
                this.kiF.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(C25738R.color.f12208w0));
            }
            AppMethodBeat.m2505o(48124);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI$c */
    class C29688c extends BaseAdapter {
        public final int rUc;
        public final int tQD;

        private C29688c() {
            this.rUc = 0;
            this.tQD = 1;
        }

        /* synthetic */ C29688c(WalletECardBindCardListUI walletECardBindCardListUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(48118);
            int size = WalletECardBindCardListUI.this.tQy.size() + 1;
            AppMethodBeat.m2505o(48118);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(48119);
            if (i < WalletECardBindCardListUI.this.tQy.size()) {
                Object obj = WalletECardBindCardListUI.this.tQy.get(i);
                AppMethodBeat.m2505o(48119);
                return obj;
            }
            AppMethodBeat.m2505o(48119);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(48120);
            if (i >= WalletECardBindCardListUI.this.tQy.size()) {
                AppMethodBeat.m2505o(48120);
                return 1;
            }
            AppMethodBeat.m2505o(48120);
            return 0;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.m2504i(48121);
            C35922hb c35922hb = (C35922hb) getItem(i);
            if (c35922hb == null) {
                boolean isEnabled = super.isEnabled(i);
                AppMethodBeat.m2505o(48121);
                return isEnabled;
            } else if (c35922hb.vJJ) {
                AppMethodBeat.m2505o(48121);
                return false;
            } else {
                AppMethodBeat.m2505o(48121);
                return true;
            }
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(48122);
            if (getItemViewType(i) == 1) {
                if (view == null) {
                    view = LayoutInflater.from(WalletECardBindCardListUI.this.mController.ylL).inflate(2130969308, viewGroup, false);
                    view.setTag(new C31463a(view));
                }
                ((C31463a) view.getTag()).iUx.setText(C25738R.string.b80);
            } else {
                if (view == null) {
                    view = LayoutInflater.from(WalletECardBindCardListUI.this.mController.ylL).inflate(2130969307, viewGroup, false);
                    view.setTag(new C22685d(view));
                }
                ((C31462b) view.getTag()).mo38266a(view, (C35922hb) getItem(i));
            }
            AppMethodBeat.m2505o(48122);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI$b */
    interface C31462b {
        /* renamed from: a */
        void mo38266a(View view, C35922hb c35922hb);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI$a */
    class C31463a {
        TextView iUx;

        public C31463a(View view) {
            AppMethodBeat.m2504i(48117);
            this.iUx = (TextView) view.findViewById(2131823361);
            ImageView imageView = (ImageView) view.findViewById(2131823360);
            Drawable f = C0280a.m467f(imageView.getDrawable());
            C0280a.m457a(f, ColorStateList.valueOf(C4996ah.getResources().getColor(C25738R.color.f12123t7)));
            imageView.setImageDrawable(f);
            AppMethodBeat.m2505o(48117);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletECardBindCardListUI() {
        AppMethodBeat.m2504i(48125);
        AppMethodBeat.m2505o(48125);
    }

    /* renamed from: c */
    static /* synthetic */ void m50899c(WalletECardBindCardListUI walletECardBindCardListUI) {
        AppMethodBeat.m2504i(48132);
        walletECardBindCardListUI.arT();
        AppMethodBeat.m2505o(48132);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48126);
        super.onCreate(bundle);
        mo17446xE(getResources().getColor(C25738R.color.a69));
        dyb();
        this.Ahr.mo49372nf(1988);
        this.jSu = this.mBundle.getInt(C43818a.tPH, 2);
        C4990ab.m7417i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", Integer.valueOf(this.jSu));
        setMMTitle("");
        initView();
        this.tQA = true;
        arT();
        AppMethodBeat.m2505o(48126);
    }

    public final void initView() {
        AppMethodBeat.m2504i(48127);
        this.tQw = (ListView) findViewById(2131823354);
        View inflate = LayoutInflater.from(this).inflate(2130969306, this.tQw, false);
        this.tQx = (TextView) inflate.findViewById(2131823356);
        this.tQw.addHeaderView(inflate, null, false);
        this.tQz = new C29688c(this, (byte) 0);
        this.tQw.setAdapter(this.tQz);
        this.tQw.setOnItemClickListener(new C143371());
        AppMethodBeat.m2505o(48127);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48128);
        if (c1207m instanceof C40149f) {
            C40149f c40149f = (C40149f) c1207m;
            if (i == 0 && i2 == 0) {
                if (!C5046bo.isNullOrNil(c40149f.tQn.wQc)) {
                    this.tQx.setText(c40149f.tQn.wQc);
                }
                if (c40149f.tQn.kdT == 0) {
                    C4990ab.m7417i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", Integer.valueOf(c40149f.tQn.wQd.size()));
                    C4990ab.m7411d("MicroMsg.WalletECardBindCardListUI", "true name: %s", c40149f.tQn.twd);
                    this.mBundle.putString(C43818a.tPY, c40149f.tQn.twd);
                    if (c40149f.tQn.wQd.size() == 0) {
                        C4990ab.m7417i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", Boolean.valueOf(this.tQA));
                        if (this.tQA) {
                            cST();
                        }
                    } else {
                        this.tQy.clear();
                        this.tQy.addAll(c40149f.tQn.wQd);
                        this.tQz.notifyDataSetChanged();
                    }
                } else if (!C22672b.m34358a(this, c40149f.tQn.vLc)) {
                    C30379h.m48461b(this.mController.ylL, C22672b.m34359d(this.mController.ylL, c40149f.tQn.kdU, str), "", false);
                }
            } else {
                C4990ab.m7421w("MicroMsg.WalletECardBindCardListUI", "net error: %s", c40149f);
                C30379h.m48461b(this.mController.ylL, C22672b.m34359d(this.mController.ylL, str), "", false);
            }
            AppMethodBeat.m2505o(48128);
            return true;
        }
        AppMethodBeat.m2505o(48128);
        return false;
    }

    public final void cST() {
        AppMethodBeat.m2504i(48129);
        Bundle bundle = new Bundle();
        if (this.jSu == 3) {
            bundle.putInt("key_bind_scene", 18);
        } else {
            bundle.putInt("key_bind_scene", 19);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putString("key_pwd1", this.mBundle.getString("key_pwd1"));
        C4990ab.m7417i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", Integer.valueOf(this.jSu));
        C24143a.m37106a((Activity) this, C31461a.class, bundle, this.tQB);
        AppMethodBeat.m2505o(48129);
    }

    public final int getLayoutId() {
        return 2130969305;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(48130);
        super.onDestroy();
        this.Ahr.mo49373ng(1988);
        AppMethodBeat.m2505o(48130);
    }

    public final boolean cNR() {
        return true;
    }

    private void arT() {
        AppMethodBeat.m2504i(48131);
        C4990ab.m7416i("MicroMsg.WalletECardBindCardListUI", "load Data");
        mo39970a(new C40149f("WEB_DEBIT", this.jSu), true, false);
        AppMethodBeat.m2505o(48131);
    }
}
