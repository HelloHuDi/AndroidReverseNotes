package com.tencent.mm.plugin.order.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderProductListUI extends WalletBaseUI {
    private ListView Ej;
    private String fhH = "";
    private List<ProductSectionItem> iJL = new ArrayList();
    private String kBE = "";
    private BaseAdapter khG;

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(MallOrderProductListUI mallOrderProductListUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(43839);
            ProductSectionItem AG = AG(i);
            AppMethodBeat.o(43839);
            return AG;
        }

        public final int getCount() {
            AppMethodBeat.i(43836);
            int size = MallOrderProductListUI.this.iJL.size();
            AppMethodBeat.o(43836);
            return size;
        }

        private ProductSectionItem AG(int i) {
            AppMethodBeat.i(43837);
            ProductSectionItem productSectionItem = (ProductSectionItem) MallOrderProductListUI.this.iJL.get(i);
            AppMethodBeat.o(43837);
            return productSectionItem;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            com.tencent.mm.platformtools.x.a aVar;
            AppMethodBeat.i(43838);
            if (view == null) {
                view = View.inflate(MallOrderProductListUI.this, R.layout.aca, null);
                b bVar = new b(MallOrderProductListUI.this, (byte) 0);
                bVar.knb = (ImageView) view.findViewById(R.id.d5_);
                bVar.pdT = (TextView) view.findViewById(R.id.d5a);
                bVar.pdU = (TextView) view.findViewById(R.id.d5h);
                bVar.pdV = (TextView) view.findViewById(R.id.d5i);
                bVar.pdW = (TextView) view.findViewById(R.id.d5j);
                bVar.pdX = (TextView) view.findViewById(R.id.d5g);
                view.setTag(bVar);
                aVar = bVar;
            } else {
                b aVar2 = (b) view.getTag();
            }
            ProductSectionItem AG = AG(i);
            aVar2.kbV = AG.iconUrl;
            if (TextUtils.isEmpty(aVar2.kbV) || !e.ats(aVar2.kbV)) {
                aVar2.knb.setImageResource(R.raw.mall_order_detail_frame);
            } else {
                aVar2.knb.setImageBitmap(x.a(new com.tencent.mm.plugin.order.c.b(aVar2.kbV)));
            }
            aVar2.pdT.setText(AG.name);
            aVar2.pdU.setText(Skus.ct(AG.pdy));
            aVar2.pdV.setText(AG.pdz);
            aVar2.pdW.setText("+" + AG.count);
            x.a(aVar2);
            aVar2.pdX.setVisibility(8);
            AppMethodBeat.o(43838);
            return view;
        }
    }

    class b implements com.tencent.mm.platformtools.x.a {
        String kbV;
        ImageView knb;
        TextView pdT;
        TextView pdU;
        TextView pdV;
        TextView pdW;
        TextView pdX;

        private b() {
        }

        /* synthetic */ b(MallOrderProductListUI mallOrderProductListUI, byte b) {
            this();
        }

        public final void m(String str, final Bitmap bitmap) {
            AppMethodBeat.i(43841);
            if (str != null && str.equals(this.kbV)) {
                this.knb.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(43840);
                        b.this.knb.setImageBitmap(bitmap);
                        AppMethodBeat.o(43840);
                    }
                });
            }
            AppMethodBeat.o(43841);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallOrderProductListUI() {
        AppMethodBeat.i(43842);
        AppMethodBeat.o(43842);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.ac_;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(43843);
        super.onCreate(bundle);
        AM(0);
        initView();
        AppMethodBeat.o(43843);
    }

    @Deprecated
    public final void initView() {
        AppMethodBeat.i(43844);
        setMMTitle((int) R.string.cx6);
        bZe();
        this.Ej = (ListView) findViewById(R.id.d5f);
        this.khG = new a(this, (byte) 0);
        this.Ej.setAdapter(this.khG);
        this.khG.notifyDataSetChanged();
        this.Ej.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(43835);
                ProductSectionItem productSectionItem = (ProductSectionItem) MallOrderProductListUI.this.iJL.get(i);
                if (productSectionItem != null) {
                    MallOrderProductListUI.a(MallOrderProductListUI.this, productSectionItem);
                    c.a(Boolean.FALSE, MallOrderProductListUI.this.fhH, MallOrderProductListUI.this.kBE, productSectionItem.name, productSectionItem.pdA);
                }
                AppMethodBeat.o(43835);
            }
        });
        AppMethodBeat.o(43844);
    }

    public void onDestroy() {
        AppMethodBeat.i(43846);
        super.onDestroy();
        AppMethodBeat.o(43846);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(43847);
        if (i == 4) {
            if (com.tencent.mm.wallet_core.a.aE(this) instanceof com.tencent.mm.plugin.order.a.a) {
                com.tencent.mm.wallet_core.a.aB(this);
            }
            AppMethodBeat.o(43847);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(43847);
        return onKeyUp;
    }

    private void bZe() {
        AppMethodBeat.i(43845);
        Bundle bundle = this.mBundle;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("order_product_list");
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            this.iJL.clear();
            this.iJL.addAll(parcelableArrayList);
        }
        this.kBE = bundle.getString("key_trans_id");
        this.fhH = bundle.getString("appname");
        AppMethodBeat.o(43845);
    }

    static /* synthetic */ void a(MallOrderProductListUI mallOrderProductListUI, ProductSectionItem productSectionItem) {
        AppMethodBeat.i(43848);
        if (!c.aM(mallOrderProductListUI, productSectionItem.jumpUrl)) {
            c.aN(mallOrderProductListUI, productSectionItem.pdA);
        }
        AppMethodBeat.o(43848);
    }
}
