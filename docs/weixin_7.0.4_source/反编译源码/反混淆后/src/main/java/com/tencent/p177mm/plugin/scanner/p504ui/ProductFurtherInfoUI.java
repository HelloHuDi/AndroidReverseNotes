package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p057v4.view.C25365p;
import android.support.p057v4.view.ViewPager;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p612ui.base.MMPageControlView;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.scanner.p740a.C43486j;
import com.tencent.p177mm.plugin.scanner.util.C43494o.C13185a;
import com.tencent.p177mm.plugin.scanner.util.C43494o.C13185a.C13186a;
import com.tencent.p177mm.plugin.scanner.util.C43494o.C13185a.C13186a.C13184b;
import com.tencent.p177mm.plugin.scanner.util.C43494o.C13185a.C13186a.C13187a;
import com.tencent.p177mm.plugin.scanner.util.C43498q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI */
public class ProductFurtherInfoUI extends MMPreference {
    /* renamed from: MI */
    private ViewPager f4392MI;
    protected C15541f iFE;
    private MMPageControlView qcC;
    private C13186a qcD;
    private String qcE;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI$1 */
    class C37571 implements OnMenuItemClickListener {
        C37571() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(81043);
            ProductFurtherInfoUI.this.finish();
            AppMethodBeat.m2505o(81043);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI$2 */
    class C37582 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI$2$1 */
        class C37591 implements C30382d {
            C37591() {
            }

            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(81044);
                switch (i2) {
                    case 0:
                        if (!C5046bo.isNullOrNil(ProductFurtherInfoUI.this.qcE)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", ProductFurtherInfoUI.this.qcE);
                            C25985d.m41467b(ProductFurtherInfoUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(81044);
            }
        }

        C37582() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(81045);
            List linkedList = new LinkedList();
            List linkedList2 = new LinkedList();
            linkedList.add(ProductFurtherInfoUI.this.getString(C25738R.string.dyi));
            linkedList2.add(Integer.valueOf(0));
            C30379h.m48420a(ProductFurtherInfoUI.this.mController.ylL, "", linkedList, linkedList2, "", false, new C37591());
            AppMethodBeat.m2505o(81045);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI$3 */
    class C131343 implements OnTouchListener {
        C131343() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(81046);
            if (!(view == null || view.getParent() == null)) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
            }
            AppMethodBeat.m2505o(81046);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI$4 */
    class C216934 implements OnPageChangeListener {
        C216934() {
        }

        public final void onPageScrolled(int i, float f, int i2) {
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.m2504i(81047);
            if (ProductFurtherInfoUI.this.f4392MI.getParent() != null) {
                ProductFurtherInfoUI.this.f4392MI.getParent().requestDisallowInterceptTouchEvent(true);
            }
            ProductFurtherInfoUI.this.qcC.setPage(i);
            AppMethodBeat.m2505o(81047);
        }

        public final void onPageScrollStateChanged(int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI$a */
    class C21694a extends C25365p implements C18765a {
        private Context mContext;
        private List<String> qcH = new ArrayList();
        private Map<String, ImageView> qcI = new HashMap();
        private int qcJ;

        public C21694a(Context context) {
            AppMethodBeat.m2504i(81049);
            this.mContext = context;
            C18764x.m29326a((C18765a) this);
            this.qcJ = this.mContext.getResources().getColor(C25738R.color.f12093s1);
            AppMethodBeat.m2505o(81049);
        }

        /* renamed from: cW */
        public final void mo37170cW(List<String> list) {
            AppMethodBeat.m2504i(81050);
            this.qcH = list;
            ProductFurtherInfoUI.this.qcC.mo69952hj(list.size(), 0);
            notifyDataSetChanged();
            AppMethodBeat.m2505o(81050);
        }

        /* renamed from: Wh */
        private ImageView m33214Wh(String str) {
            AppMethodBeat.m2504i(81051);
            ImageView imageView;
            if (this.qcI.containsKey(str)) {
                imageView = (ImageView) this.qcI.get(str);
                AppMethodBeat.m2505o(81051);
                return imageView;
            }
            imageView = new ImageView(this.mContext);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            this.qcI.put(str, imageView);
            AppMethodBeat.m2505o(81051);
            return imageView;
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(81052);
            String str = (String) this.qcH.get(i);
            ImageView Wh = m33214Wh(str);
            Bitmap a = C18764x.m29325a(new C43498q(str));
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
                C4990ab.m7412e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + e.getMessage());
            }
            AppMethodBeat.m2505o(81052);
            return Wh;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.m2504i(81053);
            viewGroup.removeView((ImageView) obj);
            String str = (String) this.qcH.get(i);
            if (this.qcI.containsKey(str)) {
                this.qcI.remove(str);
            }
            AppMethodBeat.m2505o(81053);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(81054);
            int size = this.qcH.size();
            AppMethodBeat.m2505o(81054);
            return size;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        /* renamed from: m */
        public final void mo8136m(String str, final Bitmap bitmap) {
            AppMethodBeat.m2504i(81055);
            if (!(bitmap == null || bitmap.isRecycled() || C5046bo.isNullOrNil(str))) {
                final ImageView Wh = m33214Wh(str);
                if (Wh != null) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(81048);
                            Wh.setImageBitmap(bitmap);
                            Wh.setBackgroundColor(0);
                            AppMethodBeat.m2505o(81048);
                        }
                    });
                }
            }
            AppMethodBeat.m2505o(81055);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(81056);
        super.onCreate(bundle);
        C13185a cV = C43486j.m77691cV(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (cV == null || cV.qiM == null) {
            C4990ab.m7412e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
            finish();
            AppMethodBeat.m2505o(81056);
            return;
        }
        this.qcD = cV.qiM;
        this.qcE = cV.field_feedbackurl;
        initView();
        AppMethodBeat.m2505o(81056);
    }

    public final void initView() {
        int i = 0;
        AppMethodBeat.m2504i(81057);
        setMMTitle(getIntent().getStringExtra("key_title"));
        setBackBtn(new C37571());
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C37582());
        this.iFE = this.yCw;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.qcD.qiN.iterator();
        while (it.hasNext()) {
            arrayList.add(((C13187a) it.next()).link);
        }
        this.f4392MI = (ViewPager) findViewById(2131823829);
        this.qcC = (MMPageControlView) findViewById(2131821395);
        this.qcC.setIndicatorLayoutRes(2130970342);
        this.qcC.setVisibility(0);
        this.f4392MI.setOnTouchListener(new C131343());
        this.f4392MI.setOnPageChangeListener(new C216934());
        C21694a c21694a = new C21694a(this);
        this.f4392MI.setAdapter(c21694a);
        if (arrayList.size() > 0) {
            c21694a.mo37170cW(arrayList);
            this.f4392MI.setVisibility(0);
        }
        while (i < this.qcD.qiO.size()) {
            C13184b c13184b = (C13184b) this.qcD.qiO.get(i);
            Preference preference = new Preference(this);
            preference.setKey(String.valueOf(i));
            preference.setLayoutResource(2130970264);
            preference.setTitle(c13184b.title);
            preference.setSummary(c13184b.desc);
            this.iFE.mo27713b(preference);
            i++;
        }
        this.iFE.notifyDataSetChanged();
        AppMethodBeat.m2505o(81057);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8526ba;
    }

    public final int getLayoutId() {
        return 2130970382;
    }

    public final int aWi() {
        return 2130970383;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        return false;
    }
}
