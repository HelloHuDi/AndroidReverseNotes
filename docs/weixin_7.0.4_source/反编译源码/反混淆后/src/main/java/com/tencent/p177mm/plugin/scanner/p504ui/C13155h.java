package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.plugin.scanner.C43488e;
import com.tencent.p177mm.plugin.scanner.p740a.C43482a.C34833a;
import com.tencent.p177mm.plugin.scanner.p740a.C43485i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.scanner.ui.h */
public final class C13155h extends Preference {
    private Context mContext = null;
    private View mView = null;
    List<C34833a> pil = null;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.h$a */
    static final class C13156a implements C9791v {
        private String mPicUrl = null;

        public C13156a(String str) {
            this.mPicUrl = str;
        }

        public final String anJ() {
            AppMethodBeat.m2504i(81058);
            String fQ = C43488e.cgy().mo69040fQ(this.mPicUrl, "@S");
            AppMethodBeat.m2505o(81058);
            return fQ;
        }

        public final String anK() {
            return this.mPicUrl;
        }

        public final String anL() {
            return this.mPicUrl;
        }

        public final String getCacheKey() {
            return this.mPicUrl;
        }

        public final boolean anM() {
            return false;
        }

        public final boolean anN() {
            return false;
        }

        /* renamed from: a */
        public final Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str) {
            AppMethodBeat.m2504i(81059);
            if (C9793a.NET == c9793a) {
                try {
                    C5056d.m7625a(bitmap, 100, CompressFormat.PNG, anJ(), false);
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.ProductGridPreference", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(81059);
            return bitmap;
        }

        public final void anP() {
        }

        /* renamed from: V */
        public final void mo9516V(String str, boolean z) {
        }

        /* renamed from: a */
        public final void mo9518a(C9793a c9793a, String str) {
        }

        public final Bitmap anO() {
            AppMethodBeat.m2504i(81060);
            if (C4996ah.getContext() == null) {
                AppMethodBeat.m2505o(81060);
                return null;
            }
            Bitmap decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
            AppMethodBeat.m2505o(81060);
            return decodeResource;
        }

        public final C9792b anI() {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.h$b */
    final class C13157b extends BaseAdapter implements C18765a {
        private LayoutInflater mInflater = null;
        private Map<String, WeakReference<ImageView>> qcI = new HashMap();
        private int qcL;
        private List<C34833a> qcM = new ArrayList();

        /* renamed from: com.tencent.mm.plugin.scanner.ui.h$b$a */
        class C13160a {
            TextView kEq;
            ImageView qaL;

            C13160a() {
            }
        }

        public C13157b() {
            AppMethodBeat.m2504i(81063);
            this.mInflater = LayoutInflater.from(C13155h.this.mContext);
            C18764x.m29326a((C18765a) this);
            this.qcL = C13155h.this.mContext.getResources().getColor(C25738R.color.f12083rq);
            AppMethodBeat.m2505o(81063);
        }

        public final void setItemList(List<C34833a> list) {
            AppMethodBeat.m2504i(81064);
            this.qcI.clear();
            this.qcM.clear();
            this.qcM = list;
            notifyDataSetChanged();
            AppMethodBeat.m2505o(81064);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(81065);
            int size = this.qcM.size();
            AppMethodBeat.m2505o(81065);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(81066);
            Object obj = this.qcM.get(i);
            AppMethodBeat.m2505o(81066);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C13160a c13160a;
            AppMethodBeat.m2504i(81067);
            if (view == null) {
                view = this.mInflater.inflate(2130970386, viewGroup, false);
                c13160a = new C13160a();
                c13160a.qaL = (ImageView) view.findViewById(2131826580);
                c13160a.kEq = (TextView) view.findViewById(2131826581);
                view.setTag(c13160a);
            } else {
                c13160a = (C13160a) view.getTag();
            }
            final C34833a c34833a = (C34833a) this.qcM.get(i);
            Bitmap a = C18764x.m29325a(new C13156a(c34833a.iconUrl));
            if (a == null || a.isRecycled()) {
                c13160a.qaL.setBackgroundColor(this.qcL);
                c13160a.qaL.setImageBitmap(null);
            } else {
                c13160a.qaL.setImageBitmap(a);
                c13160a.qaL.setBackgroundColor(0);
            }
            final String str = c34833a.pZp;
            c13160a.qaL.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(81061);
                    C1720g.m3540Rg().mo14541a(new C43485i(str, c34833a.pZo, c34833a.type, str, C13157b.this.getCount(), c34833a.showType), 0);
                    if (!C5046bo.isNullOrNil(str)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_Product_ID", str);
                        C25985d.m41467b(C13155h.this.mContext, "scanner", ".ui.ProductUI", intent);
                    }
                    AppMethodBeat.m2505o(81061);
                }
            });
            c13160a.qaL.setTag(c34833a.iconUrl);
            this.qcI.put(c34833a.iconUrl, new WeakReference(c13160a.qaL));
            c13160a.kEq.setText(c34833a.name);
            AppMethodBeat.m2505o(81067);
            return view;
        }

        /* renamed from: m */
        public final void mo8136m(String str, final Bitmap bitmap) {
            AppMethodBeat.m2504i(81068);
            if (!(bitmap == null || bitmap.isRecycled() || C5046bo.isNullOrNil(str))) {
                C4990ab.m7418v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=".concat(String.valueOf(str)));
                if (((WeakReference) this.qcI.get(str)) != null) {
                    final ImageView imageView = (ImageView) ((WeakReference) this.qcI.get(str)).get();
                    if (imageView != null && str.equals((String) imageView.getTag())) {
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(81062);
                                imageView.setImageBitmap(bitmap);
                                imageView.setBackgroundColor(0);
                                AppMethodBeat.m2505o(81062);
                            }
                        });
                    }
                }
            }
            AppMethodBeat.m2505o(81068);
        }
    }

    public C13155h(Context context) {
        super(context);
        AppMethodBeat.m2504i(81069);
        this.mContext = context;
        setLayoutResource(2130970385);
        AppMethodBeat.m2505o(81069);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(81070);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(81070);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(81071);
        super.onBindView(view);
        GridView gridView = (GridView) this.mView.findViewById(2131826579);
        C13157b c13157b = new C13157b();
        gridView.setAdapter(c13157b);
        if (this.pil != null) {
            c13157b.setItemList(this.pil);
        }
        AppMethodBeat.m2505o(81071);
    }
}
