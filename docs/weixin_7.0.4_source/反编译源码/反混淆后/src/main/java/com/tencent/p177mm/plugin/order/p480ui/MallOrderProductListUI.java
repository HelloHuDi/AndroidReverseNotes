package com.tencent.p177mm.plugin.order.p480ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
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
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.order.model.ProductSectionItem;
import com.tencent.p177mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.p177mm.plugin.order.p1007a.C34656a;
import com.tencent.p177mm.plugin.order.p1008c.C12785c;
import com.tencent.p177mm.plugin.order.p1008c.C28657b;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.order.ui.MallOrderProductListUI */
public class MallOrderProductListUI extends WalletBaseUI {
    /* renamed from: Ej */
    private ListView f17210Ej;
    private String fhH = "";
    private List<ProductSectionItem> iJL = new ArrayList();
    private String kBE = "";
    private BaseAdapter khG;

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderProductListUI$a */
    class C3578a extends BaseAdapter {
        private C3578a() {
        }

        /* synthetic */ C3578a(MallOrderProductListUI mallOrderProductListUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(43839);
            ProductSectionItem AG = m5930AG(i);
            AppMethodBeat.m2505o(43839);
            return AG;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(43836);
            int size = MallOrderProductListUI.this.iJL.size();
            AppMethodBeat.m2505o(43836);
            return size;
        }

        /* renamed from: AG */
        private ProductSectionItem m5930AG(int i) {
            AppMethodBeat.m2504i(43837);
            ProductSectionItem productSectionItem = (ProductSectionItem) MallOrderProductListUI.this.iJL.get(i);
            AppMethodBeat.m2505o(43837);
            return productSectionItem;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C18765a c18765a;
            AppMethodBeat.m2504i(43838);
            if (view == null) {
                view = View.inflate(MallOrderProductListUI.this, 2130970060, null);
                C3579b c3579b = new C3579b(MallOrderProductListUI.this, (byte) 0);
                c3579b.knb = (ImageView) view.findViewById(2131825844);
                c3579b.pdT = (TextView) view.findViewById(2131825845);
                c3579b.pdU = (TextView) view.findViewById(2131825852);
                c3579b.pdV = (TextView) view.findViewById(2131825853);
                c3579b.pdW = (TextView) view.findViewById(2131825854);
                c3579b.pdX = (TextView) view.findViewById(2131825851);
                view.setTag(c3579b);
                c18765a = c3579b;
            } else {
                C3579b c18765a2 = (C3579b) view.getTag();
            }
            ProductSectionItem AG = m5930AG(i);
            c18765a2.kbV = AG.iconUrl;
            if (TextUtils.isEmpty(c18765a2.kbV) || !C36391e.ats(c18765a2.kbV)) {
                c18765a2.knb.setImageResource(C1318a.mall_order_detail_frame);
            } else {
                c18765a2.knb.setImageBitmap(C18764x.m29325a(new C28657b(c18765a2.kbV)));
            }
            c18765a2.pdT.setText(AG.name);
            c18765a2.pdU.setText(Skus.m56902ct(AG.pdy));
            c18765a2.pdV.setText(AG.pdz);
            c18765a2.pdW.setText("+" + AG.count);
            C18764x.m29326a(c18765a2);
            c18765a2.pdX.setVisibility(8);
            AppMethodBeat.m2505o(43838);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderProductListUI$b */
    class C3579b implements C18765a {
        String kbV;
        ImageView knb;
        TextView pdT;
        TextView pdU;
        TextView pdV;
        TextView pdW;
        TextView pdX;

        private C3579b() {
        }

        /* synthetic */ C3579b(MallOrderProductListUI mallOrderProductListUI, byte b) {
            this();
        }

        /* renamed from: m */
        public final void mo8136m(String str, final Bitmap bitmap) {
            AppMethodBeat.m2504i(43841);
            if (str != null && str.equals(this.kbV)) {
                this.knb.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(43840);
                        C3579b.this.knb.setImageBitmap(bitmap);
                        AppMethodBeat.m2505o(43840);
                    }
                });
            }
            AppMethodBeat.m2505o(43841);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderProductListUI$1 */
    class C433661 implements OnItemClickListener {
        C433661() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(43835);
            ProductSectionItem productSectionItem = (ProductSectionItem) MallOrderProductListUI.this.iJL.get(i);
            if (productSectionItem != null) {
                MallOrderProductListUI.m77388a(MallOrderProductListUI.this, productSectionItem);
                C12785c.m20786a(Boolean.FALSE, MallOrderProductListUI.this.fhH, MallOrderProductListUI.this.kBE, productSectionItem.name, productSectionItem.pdA);
            }
            AppMethodBeat.m2505o(43835);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MallOrderProductListUI() {
        AppMethodBeat.m2504i(43842);
        AppMethodBeat.m2505o(43842);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130970059;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(43843);
        super.onCreate(bundle);
        mo9439AM(0);
        initView();
        AppMethodBeat.m2505o(43843);
    }

    @Deprecated
    public final void initView() {
        AppMethodBeat.m2504i(43844);
        setMMTitle((int) C25738R.string.cx6);
        bZe();
        this.f17210Ej = (ListView) findViewById(2131825850);
        this.khG = new C3578a(this, (byte) 0);
        this.f17210Ej.setAdapter(this.khG);
        this.khG.notifyDataSetChanged();
        this.f17210Ej.setOnItemClickListener(new C433661());
        AppMethodBeat.m2505o(43844);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(43846);
        super.onDestroy();
        AppMethodBeat.m2505o(43846);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(43847);
        if (i == 4) {
            if (C24143a.m37112aE(this) instanceof C34656a) {
                C24143a.m37108aB(this);
            }
            AppMethodBeat.m2505o(43847);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(43847);
        return onKeyUp;
    }

    private void bZe() {
        AppMethodBeat.m2504i(43845);
        Bundle bundle = this.mBundle;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("order_product_list");
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            this.iJL.clear();
            this.iJL.addAll(parcelableArrayList);
        }
        this.kBE = bundle.getString("key_trans_id");
        this.fhH = bundle.getString("appname");
        AppMethodBeat.m2505o(43845);
    }

    /* renamed from: a */
    static /* synthetic */ void m77388a(MallOrderProductListUI mallOrderProductListUI, ProductSectionItem productSectionItem) {
        AppMethodBeat.m2504i(43848);
        if (!C12785c.m20788aM(mallOrderProductListUI, productSectionItem.jumpUrl)) {
            C12785c.m20789aN(mallOrderProductListUI, productSectionItem.pdA);
        }
        AppMethodBeat.m2505o(43848);
    }
}
