package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_ecard.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.hb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

public class WalletECardBindCardListUI extends WalletECardBaseUI {
    private int jSu;
    private boolean tQA = true;
    private com.tencent.mm.wallet_core.c.a tQB = new com.tencent.mm.wallet_core.c.a() {
        public final Intent n(int i, Bundle bundle) {
            AppMethodBeat.i(48116);
            ab.i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", Integer.valueOf(i), bundle);
            if (i == -1) {
                BindCardOrder bindCardOrder = (BindCardOrder) bundle.getParcelable("key_bindcard_value_result");
                if (bindCardOrder != null) {
                    hb hbVar = new hb();
                    hbVar.pbn = bundle.getString("key_bind_card_type");
                    hbVar.vJH = bindCardOrder.txK;
                    hbVar.tuk = bundle.getString("key_mobile");
                    if (!(bo.isNullOrNil(hbVar.vJH) || bo.isNullOrNil(hbVar.pbn) || bo.isNullOrNil(hbVar.tuk))) {
                        WalletECardBindCardListUI.this.dOE().p(hbVar);
                        AppMethodBeat.o(48116);
                        return null;
                    }
                }
                WalletECardBindCardListUI.c(WalletECardBindCardListUI.this);
            }
            WalletECardBindCardListUI.this.tQA = false;
            AppMethodBeat.o(48116);
            return null;
        }
    };
    private ListView tQw;
    private TextView tQx;
    private List<hb> tQy = new ArrayList();
    private c tQz;

    class d implements b {
        TextView iDT;
        TextView kiF;
        CdnImageView tQE;

        public d(View view) {
            AppMethodBeat.i(48123);
            this.tQE = (CdnImageView) view.findViewById(R.id.bb1);
            this.iDT = (TextView) view.findViewById(R.id.bb2);
            this.kiF = (TextView) view.findViewById(R.id.bb3);
            AppMethodBeat.o(48123);
        }

        public final void a(View view, hb hbVar) {
            AppMethodBeat.i(48124);
            if (hbVar != null) {
                this.tQE.setRoundCorner(true);
                this.tQE.setUrl(hbVar.vJI);
                this.iDT.setText(String.format("%s %s(%s)", new Object[]{hbVar.nuL, hbVar.kmu, hbVar.vJG}));
                if (bo.isNullOrNil(hbVar.vJK)) {
                    this.kiF.setText(String.format("%s", new Object[]{hbVar.tuk}));
                } else {
                    this.kiF.setText(String.format("%s，%s", new Object[]{hbVar.tuk, hbVar.vJK}));
                }
                if (hbVar.vJJ) {
                    ab.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", hbVar.nuL);
                    view.setEnabled(false);
                    this.iDT.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(R.color.gv));
                    this.kiF.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(R.color.gv));
                    AppMethodBeat.o(48124);
                    return;
                }
                view.setEnabled(true);
                this.iDT.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(R.color.h4));
                this.kiF.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(R.color.w0));
            }
            AppMethodBeat.o(48124);
        }
    }

    class c extends BaseAdapter {
        public final int rUc;
        public final int tQD;

        private c() {
            this.rUc = 0;
            this.tQD = 1;
        }

        /* synthetic */ c(WalletECardBindCardListUI walletECardBindCardListUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(48118);
            int size = WalletECardBindCardListUI.this.tQy.size() + 1;
            AppMethodBeat.o(48118);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(48119);
            if (i < WalletECardBindCardListUI.this.tQy.size()) {
                Object obj = WalletECardBindCardListUI.this.tQy.get(i);
                AppMethodBeat.o(48119);
                return obj;
            }
            AppMethodBeat.o(48119);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(48120);
            if (i >= WalletECardBindCardListUI.this.tQy.size()) {
                AppMethodBeat.o(48120);
                return 1;
            }
            AppMethodBeat.o(48120);
            return 0;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.i(48121);
            hb hbVar = (hb) getItem(i);
            if (hbVar == null) {
                boolean isEnabled = super.isEnabled(i);
                AppMethodBeat.o(48121);
                return isEnabled;
            } else if (hbVar.vJJ) {
                AppMethodBeat.o(48121);
                return false;
            } else {
                AppMethodBeat.o(48121);
                return true;
            }
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(48122);
            if (getItemViewType(i) == 1) {
                if (view == null) {
                    view = LayoutInflater.from(WalletECardBindCardListUI.this.mController.ylL).inflate(R.layout.t1, viewGroup, false);
                    view.setTag(new a(view));
                }
                ((a) view.getTag()).iUx.setText(R.string.b80);
            } else {
                if (view == null) {
                    view = LayoutInflater.from(WalletECardBindCardListUI.this.mController.ylL).inflate(R.layout.t0, viewGroup, false);
                    view.setTag(new d(view));
                }
                ((b) view.getTag()).a(view, (hb) getItem(i));
            }
            AppMethodBeat.o(48122);
            return view;
        }
    }

    interface b {
        void a(View view, hb hbVar);
    }

    class a {
        TextView iUx;

        public a(View view) {
            AppMethodBeat.i(48117);
            this.iUx = (TextView) view.findViewById(R.id.bb5);
            ImageView imageView = (ImageView) view.findViewById(R.id.bb4);
            Drawable f = android.support.v4.a.a.a.f(imageView.getDrawable());
            android.support.v4.a.a.a.a(f, ColorStateList.valueOf(ah.getResources().getColor(R.color.t7)));
            imageView.setImageDrawable(f);
            AppMethodBeat.o(48117);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletECardBindCardListUI() {
        AppMethodBeat.i(48125);
        AppMethodBeat.o(48125);
    }

    static /* synthetic */ void c(WalletECardBindCardListUI walletECardBindCardListUI) {
        AppMethodBeat.i(48132);
        walletECardBindCardListUI.arT();
        AppMethodBeat.o(48132);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48126);
        super.onCreate(bundle);
        xE(getResources().getColor(R.color.a69));
        dyb();
        this.Ahr.nf(1988);
        this.jSu = this.mBundle.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPH, 2);
        ab.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", Integer.valueOf(this.jSu));
        setMMTitle("");
        initView();
        this.tQA = true;
        arT();
        AppMethodBeat.o(48126);
    }

    public final void initView() {
        AppMethodBeat.i(48127);
        this.tQw = (ListView) findViewById(R.id.bay);
        View inflate = LayoutInflater.from(this).inflate(R.layout.sz, this.tQw, false);
        this.tQx = (TextView) inflate.findViewById(R.id.bb0);
        this.tQw.addHeaderView(inflate, null, false);
        this.tQz = new c(this, (byte) 0);
        this.tQw.setAdapter(this.tQz);
        this.tQw.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(48115);
                ab.i("MicroMsg.WalletECardBindCardListUI", "position: %d", Integer.valueOf(i));
                int itemViewType = adapterView.getAdapter().getItemViewType(i);
                WalletECardBindCardListUI.this.tQz.getClass();
                if (itemViewType == 1) {
                    ab.d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", Integer.valueOf(WalletECardBindCardListUI.this.jSu));
                    WalletECardBindCardListUI.this.cST();
                    AppMethodBeat.o(48115);
                    return;
                }
                if (((hb) adapterView.getAdapter().getItem(i)) == null) {
                    ab.w("MicroMsg.WalletECardBindCardListUI", "empty item");
                    AppMethodBeat.o(48115);
                    return;
                }
                WalletECardBindCardListUI.this.dOE().p(r0);
                AppMethodBeat.o(48115);
            }
        });
        AppMethodBeat.o(48127);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48128);
        if (mVar instanceof f) {
            f fVar = (f) mVar;
            if (i == 0 && i2 == 0) {
                if (!bo.isNullOrNil(fVar.tQn.wQc)) {
                    this.tQx.setText(fVar.tQn.wQc);
                }
                if (fVar.tQn.kdT == 0) {
                    ab.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", Integer.valueOf(fVar.tQn.wQd.size()));
                    ab.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", fVar.tQn.twd);
                    this.mBundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPY, fVar.tQn.twd);
                    if (fVar.tQn.wQd.size() == 0) {
                        ab.i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", Boolean.valueOf(this.tQA));
                        if (this.tQA) {
                            cST();
                        }
                    } else {
                        this.tQy.clear();
                        this.tQy.addAll(fVar.tQn.wQd);
                        this.tQz.notifyDataSetChanged();
                    }
                } else if (!com.tencent.mm.plugin.wallet_ecard.a.b.a(this, fVar.tQn.vLc)) {
                    h.b(this.mController.ylL, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.mController.ylL, fVar.tQn.kdU, str), "", false);
                }
            } else {
                ab.w("MicroMsg.WalletECardBindCardListUI", "net error: %s", fVar);
                h.b(this.mController.ylL, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.mController.ylL, str), "", false);
            }
            AppMethodBeat.o(48128);
            return true;
        }
        AppMethodBeat.o(48128);
        return false;
    }

    public final void cST() {
        AppMethodBeat.i(48129);
        Bundle bundle = new Bundle();
        if (this.jSu == 3) {
            bundle.putInt("key_bind_scene", 18);
        } else {
            bundle.putInt("key_bind_scene", 19);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putString("key_pwd1", this.mBundle.getString("key_pwd1"));
        ab.i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", Integer.valueOf(this.jSu));
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet_ecard.b.a.class, bundle, this.tQB);
        AppMethodBeat.o(48129);
    }

    public final int getLayoutId() {
        return R.layout.sy;
    }

    public void onDestroy() {
        AppMethodBeat.i(48130);
        super.onDestroy();
        this.Ahr.ng(1988);
        AppMethodBeat.o(48130);
    }

    public final boolean cNR() {
        return true;
    }

    private void arT() {
        AppMethodBeat.i(48131);
        ab.i("MicroMsg.WalletECardBindCardListUI", "load Data");
        a(new f("WEB_DEBIT", this.jSu), true, false);
        AppMethodBeat.o(48131);
    }
}
