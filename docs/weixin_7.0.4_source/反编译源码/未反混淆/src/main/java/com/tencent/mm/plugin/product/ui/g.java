package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class g extends p {
    Context mContext;
    private ArrayList<b> piQ;
    private boolean piR;
    a piS;
    private List<String> piv;

    public interface a {
        void caa();
    }

    class b implements com.tencent.mm.platformtools.x.a {
        public ImageView cDh = null;
        public String url;

        public b(String str) {
            AppMethodBeat.i(44071);
            this.url = str;
            this.cDh = (ImageView) ((LayoutInflater) g.this.mContext.getSystemService("layout_inflater")).inflate(R.layout.al5, null);
            this.cDh.setImageBitmap(x.a(new c(str)));
            this.cDh.setOnClickListener(new OnClickListener(g.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(44069);
                    ab.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
                    if (g.this.piS != null) {
                        g.this.piS.caa();
                    }
                    AppMethodBeat.o(44069);
                }
            });
            x.a((com.tencent.mm.platformtools.x.a) this);
            AppMethodBeat.o(44071);
        }

        public final void m(String str, final Bitmap bitmap) {
            AppMethodBeat.i(44072);
            ab.d("MicroMsg.MallProductImageAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.url == null) {
                AppMethodBeat.o(44072);
                return;
            }
            if (str.equals(this.url)) {
                this.cDh.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(44070);
                        b.this.cDh.setImageBitmap(bitmap);
                        AppMethodBeat.o(44070);
                    }
                });
            }
            AppMethodBeat.o(44072);
        }
    }

    public g(Context context) {
        this(context, (byte) 0);
    }

    private g(Context context, byte b) {
        AppMethodBeat.i(44073);
        this.piR = false;
        this.piS = null;
        this.mContext = context;
        this.piv = null;
        setData(this.piv);
        AppMethodBeat.o(44073);
    }

    private void caf() {
        AppMethodBeat.i(44074);
        if (this.piQ == null) {
            this.piQ = new ArrayList();
        } else {
            this.piQ.clear();
        }
        for (String bVar : this.piv) {
            this.piQ.add(new b(bVar));
        }
        AppMethodBeat.o(44074);
    }

    public final void setData(List<String> list) {
        AppMethodBeat.i(44075);
        if (list != null) {
            if (list.size() > 0) {
                this.piv = list;
            }
            caf();
        }
        AppMethodBeat.o(44075);
    }

    public final int getCount() {
        AppMethodBeat.i(44076);
        if (this.piv == null) {
            AppMethodBeat.o(44076);
            return 0;
        } else if (this.piR) {
            AppMethodBeat.o(44076);
            return BaseClientBuilder.API_PRIORITY_OTHER;
        } else {
            int size = this.piv.size();
            AppMethodBeat.o(44076);
            return size;
        }
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        AppMethodBeat.i(44077);
        ab.d("MicroMsg.MallProductImageAdapter", "destroy item");
        if (this.piQ != null) {
            viewGroup.removeView(((b) this.piQ.get(i)).cDh);
        }
        AppMethodBeat.o(44077);
    }

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        AppMethodBeat.i(44078);
        if (this.piQ != null) {
            ab.d("MicroMsg.MallProductImageAdapter", "data valid");
            viewGroup.addView(((b) this.piQ.get(i)).cDh, 0);
            ImageView imageView = ((b) this.piQ.get(i)).cDh;
            AppMethodBeat.o(44078);
            return imageView;
        }
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        AppMethodBeat.o(44078);
        return instantiateItem;
    }
}
