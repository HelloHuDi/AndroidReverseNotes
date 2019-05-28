package com.tencent.mm.plugin.scanner.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h extends Preference {
    private Context mContext = null;
    private View mView = null;
    List<com.tencent.mm.plugin.scanner.a.a.a> pil = null;

    static final class a implements v {
        private String mPicUrl = null;

        public a(String str) {
            this.mPicUrl = str;
        }

        public final String anJ() {
            AppMethodBeat.i(81058);
            String fQ = e.cgy().fQ(this.mPicUrl, "@S");
            AppMethodBeat.o(81058);
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

        public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.v.a aVar, String str) {
            AppMethodBeat.i(81059);
            if (com.tencent.mm.platformtools.v.a.NET == aVar) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, anJ(), false);
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.ProductGridPreference", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(81059);
            return bitmap;
        }

        public final void anP() {
        }

        public final void V(String str, boolean z) {
        }

        public final void a(com.tencent.mm.platformtools.v.a aVar, String str) {
        }

        public final Bitmap anO() {
            AppMethodBeat.i(81060);
            if (ah.getContext() == null) {
                AppMethodBeat.o(81060);
                return null;
            }
            Bitmap decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
            AppMethodBeat.o(81060);
            return decodeResource;
        }

        public final com.tencent.mm.platformtools.v.b anI() {
            return null;
        }
    }

    final class b extends BaseAdapter implements com.tencent.mm.platformtools.x.a {
        private LayoutInflater mInflater = null;
        private Map<String, WeakReference<ImageView>> qcI = new HashMap();
        private int qcL;
        private List<com.tencent.mm.plugin.scanner.a.a.a> qcM = new ArrayList();

        class a {
            TextView kEq;
            ImageView qaL;

            a() {
            }
        }

        public b() {
            AppMethodBeat.i(81063);
            this.mInflater = LayoutInflater.from(h.this.mContext);
            x.a((com.tencent.mm.platformtools.x.a) this);
            this.qcL = h.this.mContext.getResources().getColor(R.color.rq);
            AppMethodBeat.o(81063);
        }

        public final void setItemList(List<com.tencent.mm.plugin.scanner.a.a.a> list) {
            AppMethodBeat.i(81064);
            this.qcI.clear();
            this.qcM.clear();
            this.qcM = list;
            notifyDataSetChanged();
            AppMethodBeat.o(81064);
        }

        public final int getCount() {
            AppMethodBeat.i(81065);
            int size = this.qcM.size();
            AppMethodBeat.o(81065);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(81066);
            Object obj = this.qcM.get(i);
            AppMethodBeat.o(81066);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(81067);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.al3, viewGroup, false);
                aVar = new a();
                aVar.qaL = (ImageView) view.findViewById(R.id.do6);
                aVar.kEq = (TextView) view.findViewById(R.id.do7);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            final com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) this.qcM.get(i);
            Bitmap a = x.a(new a(aVar2.iconUrl));
            if (a == null || a.isRecycled()) {
                aVar.qaL.setBackgroundColor(this.qcL);
                aVar.qaL.setImageBitmap(null);
            } else {
                aVar.qaL.setImageBitmap(a);
                aVar.qaL.setBackgroundColor(0);
            }
            final String str = aVar2.pZp;
            aVar.qaL.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(81061);
                    g.Rg().a(new i(str, aVar2.pZo, aVar2.type, str, b.this.getCount(), aVar2.showType), 0);
                    if (!bo.isNullOrNil(str)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_Product_ID", str);
                        com.tencent.mm.bp.d.b(h.this.mContext, "scanner", ".ui.ProductUI", intent);
                    }
                    AppMethodBeat.o(81061);
                }
            });
            aVar.qaL.setTag(aVar2.iconUrl);
            this.qcI.put(aVar2.iconUrl, new WeakReference(aVar.qaL));
            aVar.kEq.setText(aVar2.name);
            AppMethodBeat.o(81067);
            return view;
        }

        public final void m(String str, final Bitmap bitmap) {
            AppMethodBeat.i(81068);
            if (!(bitmap == null || bitmap.isRecycled() || bo.isNullOrNil(str))) {
                ab.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=".concat(String.valueOf(str)));
                if (((WeakReference) this.qcI.get(str)) != null) {
                    final ImageView imageView = (ImageView) ((WeakReference) this.qcI.get(str)).get();
                    if (imageView != null && str.equals((String) imageView.getTag())) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(81062);
                                imageView.setImageBitmap(bitmap);
                                imageView.setBackgroundColor(0);
                                AppMethodBeat.o(81062);
                            }
                        });
                    }
                }
            }
            AppMethodBeat.o(81068);
        }
    }

    public h(Context context) {
        super(context);
        AppMethodBeat.i(81069);
        this.mContext = context;
        setLayoutResource(R.layout.al2);
        AppMethodBeat.o(81069);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(81070);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(81070);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(81071);
        super.onBindView(view);
        GridView gridView = (GridView) this.mView.findViewById(R.id.do5);
        b bVar = new b();
        gridView.setAdapter(bVar);
        if (this.pil != null) {
            bVar.setItemList(this.pil);
        }
        AppMethodBeat.o(81071);
    }
}
