package com.tencent.p177mm.plugin.product.p482ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.p057v4.view.C25365p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.product.ui.g */
public final class C31385g extends C25365p {
    Context mContext;
    private ArrayList<C31387b> piQ;
    private boolean piR;
    C31386a piS;
    private List<String> piv;

    /* renamed from: com.tencent.mm.plugin.product.ui.g$a */
    public interface C31386a {
        void caa();
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.g$b */
    class C31387b implements C18765a {
        public ImageView cDh = null;
        public String url;

        public C31387b(String str) {
            AppMethodBeat.m2504i(44071);
            this.url = str;
            this.cDh = (ImageView) ((LayoutInflater) C31385g.this.mContext.getSystemService("layout_inflater")).inflate(2130970388, null);
            this.cDh.setImageBitmap(C18764x.m29325a(new C39492c(str)));
            this.cDh.setOnClickListener(new OnClickListener(C31385g.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(44069);
                    C4990ab.m7416i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
                    if (C31385g.this.piS != null) {
                        C31385g.this.piS.caa();
                    }
                    AppMethodBeat.m2505o(44069);
                }
            });
            C18764x.m29326a((C18765a) this);
            AppMethodBeat.m2505o(44071);
        }

        /* renamed from: m */
        public final void mo8136m(String str, final Bitmap bitmap) {
            AppMethodBeat.m2504i(44072);
            C4990ab.m7410d("MicroMsg.MallProductImageAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.url == null) {
                AppMethodBeat.m2505o(44072);
                return;
            }
            if (str.equals(this.url)) {
                this.cDh.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(44070);
                        C31387b.this.cDh.setImageBitmap(bitmap);
                        AppMethodBeat.m2505o(44070);
                    }
                });
            }
            AppMethodBeat.m2505o(44072);
        }
    }

    public C31385g(Context context) {
        this(context, (byte) 0);
    }

    private C31385g(Context context, byte b) {
        AppMethodBeat.m2504i(44073);
        this.piR = false;
        this.piS = null;
        this.mContext = context;
        this.piv = null;
        setData(this.piv);
        AppMethodBeat.m2505o(44073);
    }

    private void caf() {
        AppMethodBeat.m2504i(44074);
        if (this.piQ == null) {
            this.piQ = new ArrayList();
        } else {
            this.piQ.clear();
        }
        for (String c31387b : this.piv) {
            this.piQ.add(new C31387b(c31387b));
        }
        AppMethodBeat.m2505o(44074);
    }

    public final void setData(List<String> list) {
        AppMethodBeat.m2504i(44075);
        if (list != null) {
            if (list.size() > 0) {
                this.piv = list;
            }
            caf();
        }
        AppMethodBeat.m2505o(44075);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(44076);
        if (this.piv == null) {
            AppMethodBeat.m2505o(44076);
            return 0;
        } else if (this.piR) {
            AppMethodBeat.m2505o(44076);
            return BaseClientBuilder.API_PRIORITY_OTHER;
        } else {
            int size = this.piv.size();
            AppMethodBeat.m2505o(44076);
            return size;
        }
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        AppMethodBeat.m2504i(44077);
        C4990ab.m7410d("MicroMsg.MallProductImageAdapter", "destroy item");
        if (this.piQ != null) {
            viewGroup.removeView(((C31387b) this.piQ.get(i)).cDh);
        }
        AppMethodBeat.m2505o(44077);
    }

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        AppMethodBeat.m2504i(44078);
        if (this.piQ != null) {
            C4990ab.m7410d("MicroMsg.MallProductImageAdapter", "data valid");
            viewGroup.addView(((C31387b) this.piQ.get(i)).cDh, 0);
            ImageView imageView = ((C31387b) this.piQ.get(i)).cDh;
            AppMethodBeat.m2505o(44078);
            return imageView;
        }
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        AppMethodBeat.m2505o(44078);
        return instantiateItem;
    }
}
