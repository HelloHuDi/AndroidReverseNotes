package com.tencent.mm.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.v;

public final class k extends p {
    private LayoutInflater mInflater;
    public c rBl;
    public d rBm;
    private l rBn;
    private boolean rpm = true;
    private com.tencent.mm.ui.base.n.a zFT;
    private b zFU;
    private a zFY;

    class a extends BaseAdapter {

        class a {
            TextView gsf;
            ImageView iNr;
            View jWH;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        private a() {
        }

        /* synthetic */ a(k kVar, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(107715);
            int size;
            if (k.this.rpm) {
                size = k.this.rBn.size() + 1;
                AppMethodBeat.o(107715);
                return size;
            }
            size = k.this.rBn.size();
            AppMethodBeat.o(107715);
            return size;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(107716);
            if (!k.this.rpm) {
                AppMethodBeat.o(107716);
                return 1;
            } else if (i == 0) {
                AppMethodBeat.o(107716);
                return 0;
            } else {
                AppMethodBeat.o(107716);
                return 1;
            }
        }

        public final int getViewTypeCount() {
            AppMethodBeat.i(107717);
            if (k.this.rpm) {
                AppMethodBeat.o(107717);
                return 2;
            }
            AppMethodBeat.o(107717);
            return 1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(107718);
            a aVar;
            a aVar2;
            if (k.this.rpm && i == 0) {
                if (view == null) {
                    view = k.this.mInflater.inflate(R.layout.agn, viewGroup, false);
                    aVar = new a(this, (byte) 0);
                    aVar.gsf = (TextView) view.findViewById(R.id.cx);
                    aVar.iNr = (ImageView) view.findViewById(R.id.jb);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                aVar2.gsf.setText(k.f(k.this));
            } else {
                if (k.this.rpm) {
                    i--;
                }
                if (view == null) {
                    view = k.this.mInflater.inflate(R.layout.agm, viewGroup, false);
                    aVar = new a(this, (byte) 0);
                    aVar.gsf = (TextView) view.findViewById(R.id.cx);
                    aVar.iNr = (ImageView) view.findViewById(R.id.jb);
                    aVar.jWH = view.findViewById(R.id.l_);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                MenuItem item = k.this.rBn.getItem(i);
                aVar2.gsf.setText(item.getTitle());
                if (item.getIcon() != null) {
                    aVar2.iNr.setVisibility(0);
                    aVar2.iNr.setImageDrawable(item.getIcon());
                } else if (k.this.zFT != null) {
                    aVar2.iNr.setVisibility(0);
                    k.this.zFT.a(aVar2.iNr, item);
                } else {
                    aVar2.iNr.setVisibility(8);
                }
                if (k.this.zFU != null) {
                    k.this.zFU.a(aVar2.gsf, item);
                }
                if (i == k.this.rBn.size() - 1) {
                    aVar2.jWH.setBackgroundResource(R.drawable.a2r);
                } else {
                    aVar2.jWH.setBackgroundResource(R.drawable.a2q);
                }
            }
            AppMethodBeat.o(107718);
            return view;
        }
    }

    public k(Context context) {
        super(context);
        AppMethodBeat.i(107719);
        this.mInflater = v.hu(context);
        this.rBn = new l(context);
        AppMethodBeat.o(107719);
    }

    public final boolean gP() {
        AppMethodBeat.i(107720);
        if (this.rBl != null) {
            this.rBl.a(this.rBn);
        }
        boolean z = this.rBn.abz != null && this.rBn.abz.length() > 0;
        this.rpm = z;
        z = super.gP();
        AppMethodBeat.o(107720);
        return z;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(107721);
        if (this.rpm && i == 0) {
            AppMethodBeat.o(107721);
            return;
        }
        if (this.rpm) {
            i--;
        }
        if (this.rBm != null) {
            this.rBm.onMMMenuItemSelected(this.rBn.getItem(i), i);
        }
        dismiss();
        AppMethodBeat.o(107721);
    }

    /* Access modifiers changed, original: protected|final */
    public final BaseAdapter Kw() {
        AppMethodBeat.i(107722);
        if (this.zFY == null) {
            this.zFY = new a(this, (byte) 0);
        }
        a aVar = this.zFY;
        AppMethodBeat.o(107722);
        return aVar;
    }

    static /* synthetic */ CharSequence f(k kVar) {
        AppMethodBeat.i(107723);
        if (kVar.rBn.abz == null || kVar.rBn.abz.length() == 0) {
            String string = kVar.mContext.getResources().getString(R.string.ot);
            AppMethodBeat.o(107723);
            return string;
        }
        CharSequence charSequence = kVar.rBn.abz;
        AppMethodBeat.o(107723);
        return charSequence;
    }
}
