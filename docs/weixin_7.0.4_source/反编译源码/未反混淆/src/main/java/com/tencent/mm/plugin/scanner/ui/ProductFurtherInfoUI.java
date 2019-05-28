package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.p;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.util.o.a.a.b;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductFurtherInfoUI extends MMPreference {
    private ViewPager MI;
    protected f iFE;
    private MMPageControlView qcC;
    private com.tencent.mm.plugin.scanner.util.o.a.a qcD;
    private String qcE;

    class a extends p implements com.tencent.mm.platformtools.x.a {
        private Context mContext;
        private List<String> qcH = new ArrayList();
        private Map<String, ImageView> qcI = new HashMap();
        private int qcJ;

        public a(Context context) {
            AppMethodBeat.i(81049);
            this.mContext = context;
            x.a((com.tencent.mm.platformtools.x.a) this);
            this.qcJ = this.mContext.getResources().getColor(R.color.s1);
            AppMethodBeat.o(81049);
        }

        public final void cW(List<String> list) {
            AppMethodBeat.i(81050);
            this.qcH = list;
            ProductFurtherInfoUI.this.qcC.hj(list.size(), 0);
            notifyDataSetChanged();
            AppMethodBeat.o(81050);
        }

        private ImageView Wh(String str) {
            AppMethodBeat.i(81051);
            ImageView imageView;
            if (this.qcI.containsKey(str)) {
                imageView = (ImageView) this.qcI.get(str);
                AppMethodBeat.o(81051);
                return imageView;
            }
            imageView = new ImageView(this.mContext);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            this.qcI.put(str, imageView);
            AppMethodBeat.o(81051);
            return imageView;
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(81052);
            String str = (String) this.qcH.get(i);
            ImageView Wh = Wh(str);
            Bitmap a = x.a(new q(str));
            if (a == null || a.isRecycled()) {
                Wh.setImageBitmap(null);
                Wh.setBackgroundColor(this.qcJ);
            } else {
                Wh.setImageBitmap(a);
                Wh.setBackgroundColor(0);
            }
            try {
                viewGroup.addView(Wh);
            } catch (Exception e) {
                ab.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + e.getMessage());
            }
            AppMethodBeat.o(81052);
            return Wh;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.i(81053);
            viewGroup.removeView((ImageView) obj);
            String str = (String) this.qcH.get(i);
            if (this.qcI.containsKey(str)) {
                this.qcI.remove(str);
            }
            AppMethodBeat.o(81053);
        }

        public final int getCount() {
            AppMethodBeat.i(81054);
            int size = this.qcH.size();
            AppMethodBeat.o(81054);
            return size;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public final void m(String str, final Bitmap bitmap) {
            AppMethodBeat.i(81055);
            if (!(bitmap == null || bitmap.isRecycled() || bo.isNullOrNil(str))) {
                final ImageView Wh = Wh(str);
                if (Wh != null) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(81048);
                            Wh.setImageBitmap(bitmap);
                            Wh.setBackgroundColor(0);
                            AppMethodBeat.o(81048);
                        }
                    });
                }
            }
            AppMethodBeat.o(81055);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(81056);
        super.onCreate(bundle);
        com.tencent.mm.plugin.scanner.util.o.a cV = j.cV(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (cV == null || cV.qiM == null) {
            ab.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
            finish();
            AppMethodBeat.o(81056);
            return;
        }
        this.qcD = cV.qiM;
        this.qcE = cV.field_feedbackurl;
        initView();
        AppMethodBeat.o(81056);
    }

    public final void initView() {
        int i = 0;
        AppMethodBeat.i(81057);
        setMMTitle(getIntent().getStringExtra("key_title"));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(81043);
                ProductFurtherInfoUI.this.finish();
                AppMethodBeat.o(81043);
                return false;
            }
        });
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(81045);
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(ProductFurtherInfoUI.this.getString(R.string.dyi));
                linkedList2.add(Integer.valueOf(0));
                h.a(ProductFurtherInfoUI.this.mController.ylL, "", linkedList, linkedList2, "", false, new d() {
                    public final void bV(int i, int i2) {
                        AppMethodBeat.i(81044);
                        switch (i2) {
                            case 0:
                                if (!bo.isNullOrNil(ProductFurtherInfoUI.this.qcE)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", ProductFurtherInfoUI.this.qcE);
                                    com.tencent.mm.bp.d.b(ProductFurtherInfoUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.o(81044);
                    }
                });
                AppMethodBeat.o(81045);
                return true;
            }
        });
        this.iFE = this.yCw;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.qcD.qiN.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.tencent.mm.plugin.scanner.util.o.a.a.a) it.next()).link);
        }
        this.MI = (ViewPager) findViewById(R.id.bns);
        this.qcC = (MMPageControlView) findViewById(R.id.wa);
        this.qcC.setIndicatorLayoutRes(R.layout.ajw);
        this.qcC.setVisibility(0);
        this.MI.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(81046);
                if (!(view == null || view.getParent() == null)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                AppMethodBeat.o(81046);
                return false;
            }
        });
        this.MI.setOnPageChangeListener(new OnPageChangeListener() {
            public final void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageSelected(int i) {
                AppMethodBeat.i(81047);
                if (ProductFurtherInfoUI.this.MI.getParent() != null) {
                    ProductFurtherInfoUI.this.MI.getParent().requestDisallowInterceptTouchEvent(true);
                }
                ProductFurtherInfoUI.this.qcC.setPage(i);
                AppMethodBeat.o(81047);
            }

            public final void onPageScrollStateChanged(int i) {
            }
        });
        a aVar = new a(this);
        this.MI.setAdapter(aVar);
        if (arrayList.size() > 0) {
            aVar.cW(arrayList);
            this.MI.setVisibility(0);
        }
        while (i < this.qcD.qiO.size()) {
            b bVar = (b) this.qcD.qiO.get(i);
            Preference preference = new Preference(this);
            preference.setKey(String.valueOf(i));
            preference.setLayoutResource(R.layout.aht);
            preference.setTitle(bVar.title);
            preference.setSummary(bVar.desc);
            this.iFE.b(preference);
            i++;
        }
        this.iFE.notifyDataSetChanged();
        AppMethodBeat.o(81057);
    }

    public final int JC() {
        return R.xml.ba;
    }

    public final int getLayoutId() {
        return R.layout.akz;
    }

    public final int aWi() {
        return R.layout.al0;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }
}
