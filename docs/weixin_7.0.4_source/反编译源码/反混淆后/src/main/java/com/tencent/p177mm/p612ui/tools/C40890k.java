package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C40671n.C36072a;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C40670b;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;

/* renamed from: com.tencent.mm.ui.tools.k */
public final class C40890k extends C30763p {
    private LayoutInflater mInflater;
    public C36073c rBl;
    public C5279d rBm;
    private C44273l rBn;
    private boolean rpm = true;
    private C36072a zFT;
    private C40670b zFU;
    private C40891a zFY;

    /* renamed from: com.tencent.mm.ui.tools.k$a */
    class C40891a extends BaseAdapter {

        /* renamed from: com.tencent.mm.ui.tools.k$a$a */
        class C40892a {
            TextView gsf;
            ImageView iNr;
            View jWH;

            private C40892a() {
            }

            /* synthetic */ C40892a(C40891a c40891a, byte b) {
                this();
            }
        }

        private C40891a() {
        }

        /* synthetic */ C40891a(C40890k c40890k, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(107715);
            int size;
            if (C40890k.this.rpm) {
                size = C40890k.this.rBn.size() + 1;
                AppMethodBeat.m2505o(107715);
                return size;
            }
            size = C40890k.this.rBn.size();
            AppMethodBeat.m2505o(107715);
            return size;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(107716);
            if (!C40890k.this.rpm) {
                AppMethodBeat.m2505o(107716);
                return 1;
            } else if (i == 0) {
                AppMethodBeat.m2505o(107716);
                return 0;
            } else {
                AppMethodBeat.m2505o(107716);
                return 1;
            }
        }

        public final int getViewTypeCount() {
            AppMethodBeat.m2504i(107717);
            if (C40890k.this.rpm) {
                AppMethodBeat.m2505o(107717);
                return 2;
            }
            AppMethodBeat.m2505o(107717);
            return 1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(107718);
            C40892a c40892a;
            C40892a c40892a2;
            if (C40890k.this.rpm && i == 0) {
                if (view == null) {
                    view = C40890k.this.mInflater.inflate(2130970221, viewGroup, false);
                    c40892a = new C40892a(this, (byte) 0);
                    c40892a.gsf = (TextView) view.findViewById(2131820678);
                    c40892a.iNr = (ImageView) view.findViewById(2131820915);
                    view.setTag(c40892a);
                    c40892a2 = c40892a;
                } else {
                    c40892a2 = (C40892a) view.getTag();
                }
                c40892a2.gsf.setText(C40890k.m70866f(C40890k.this));
            } else {
                if (C40890k.this.rpm) {
                    i--;
                }
                if (view == null) {
                    view = C40890k.this.mInflater.inflate(2130970220, viewGroup, false);
                    c40892a = new C40892a(this, (byte) 0);
                    c40892a.gsf = (TextView) view.findViewById(2131820678);
                    c40892a.iNr = (ImageView) view.findViewById(2131820915);
                    c40892a.jWH = view.findViewById(2131820987);
                    view.setTag(c40892a);
                    c40892a2 = c40892a;
                } else {
                    c40892a2 = (C40892a) view.getTag();
                }
                MenuItem item = C40890k.this.rBn.getItem(i);
                c40892a2.gsf.setText(item.getTitle());
                if (item.getIcon() != null) {
                    c40892a2.iNr.setVisibility(0);
                    c40892a2.iNr.setImageDrawable(item.getIcon());
                } else if (C40890k.this.zFT != null) {
                    c40892a2.iNr.setVisibility(0);
                    C40890k.this.zFT.mo5750a(c40892a2.iNr, item);
                } else {
                    c40892a2.iNr.setVisibility(8);
                }
                if (C40890k.this.zFU != null) {
                    C40890k.this.zFU.mo5751a(c40892a2.gsf, item);
                }
                if (i == C40890k.this.rBn.size() - 1) {
                    c40892a2.jWH.setBackgroundResource(C25738R.drawable.a2r);
                } else {
                    c40892a2.jWH.setBackgroundResource(C25738R.drawable.a2q);
                }
            }
            AppMethodBeat.m2505o(107718);
            return view;
        }
    }

    public C40890k(Context context) {
        super(context);
        AppMethodBeat.m2504i(107719);
        this.mInflater = C5616v.m8409hu(context);
        this.rBn = new C44273l(context);
        AppMethodBeat.m2505o(107719);
    }

    /* renamed from: gP */
    public final boolean mo49182gP() {
        AppMethodBeat.m2504i(107720);
        if (this.rBl != null) {
            this.rBl.mo5746a(this.rBn);
        }
        boolean z = this.rBn.abz != null && this.rBn.abz.length() > 0;
        this.rpm = z;
        z = super.mo49182gP();
        AppMethodBeat.m2505o(107720);
        return z;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(107721);
        if (this.rpm && i == 0) {
            AppMethodBeat.m2505o(107721);
            return;
        }
        if (this.rpm) {
            i--;
        }
        if (this.rBm != null) {
            this.rBm.onMMMenuItemSelected(this.rBn.getItem(i), i);
        }
        dismiss();
        AppMethodBeat.m2505o(107721);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kw */
    public final BaseAdapter mo49180Kw() {
        AppMethodBeat.m2504i(107722);
        if (this.zFY == null) {
            this.zFY = new C40891a(this, (byte) 0);
        }
        C40891a c40891a = this.zFY;
        AppMethodBeat.m2505o(107722);
        return c40891a;
    }

    /* renamed from: f */
    static /* synthetic */ CharSequence m70866f(C40890k c40890k) {
        AppMethodBeat.m2504i(107723);
        if (c40890k.rBn.abz == null || c40890k.rBn.abz.length() == 0) {
            String string = c40890k.mContext.getResources().getString(C25738R.string.f9077ot);
            AppMethodBeat.m2505o(107723);
            return string;
        }
        CharSequence charSequence = c40890k.rBn.abz;
        AppMethodBeat.m2505o(107723);
        return charSequence;
    }
}
