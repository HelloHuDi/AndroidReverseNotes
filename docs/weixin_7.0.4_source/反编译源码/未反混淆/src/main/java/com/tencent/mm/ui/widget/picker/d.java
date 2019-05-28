package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import java.util.ArrayList;
import java.util.HashMap;

public final class d {
    public Button grC = ((Button) this.iym.findViewById(R.id.b7o));
    public View iym = View.inflate(this.mContext, R.layout.ahs, null);
    public Button jAH = ((Button) this.iym.findViewById(R.id.axh));
    public Context mContext;
    private BottomSheetBehavior nA;
    public c rBl;
    public com.tencent.mm.ui.base.n.d rBm;
    public l rBn = new l(this.mContext);
    public TextView rMl = ((TextView) this.iym.findViewById(R.id.br4));
    public ListView zSv = ((ListView) this.iym.findViewById(R.id.de8));
    public View zSw = this.iym.findViewById(R.id.de7);
    public ArrayList<Integer> zSx;
    public a zSy;
    public b zSz;
    public android.support.design.widget.c zaW = new android.support.design.widget.c(this.mContext);
    public int zaX;

    public interface b {
        void kg(boolean z);
    }

    public class a extends BaseAdapter {
        private Context context;
        public HashMap<Integer, Boolean> zSB = new HashMap();
        private ArrayList<Integer> zSC;

        class a {
            TextView gnB;
            TextView gnC;
            CheckBox moo;
            LinearLayout zQH;

            a() {
            }
        }

        public a(Context context) {
            AppMethodBeat.i(112843);
            this.context = context;
            AppMethodBeat.o(112843);
        }

        public final int getCount() {
            AppMethodBeat.i(112844);
            int size = d.this.rBn.size();
            AppMethodBeat.o(112844);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(112845);
            Object obj = d.this.rBn.yvT.get(i);
            AppMethodBeat.o(112845);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(112846);
            final m mVar = (m) d.this.rBn.yvT.get(i);
            LayoutInflater from = LayoutInflater.from(this.context);
            if (view == null) {
                view = from.inflate(R.layout.ahr, null);
                a aVar2 = new a();
                aVar2.zQH = (LinearLayout) view.findViewById(R.id.de4);
                aVar2.moo = (CheckBox) view.findViewById(R.id.de6);
                aVar2.gnB = (TextView) view.findViewById(R.id.bgm);
                aVar2.gnC = (TextView) view.findViewById(R.id.de5);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.gnB.setText(mVar.getTitle());
            aVar.zQH.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(112842);
                    if (d.this.rBm != null) {
                        d.this.rBm.onMMMenuItemSelected(d.this.rBn.getItem(i), i);
                    }
                    if (mVar.xeS) {
                        AppMethodBeat.o(112842);
                        return;
                    }
                    if (((Boolean) a.this.zSB.get(Integer.valueOf(i))).booleanValue()) {
                        a.this.zSB.put(Integer.valueOf(i), Boolean.FALSE);
                    } else {
                        a.this.zSB.put(Integer.valueOf(i), Boolean.TRUE);
                    }
                    a.this.zSB = a.this.zSB;
                    a.this.notifyDataSetChanged();
                    AppMethodBeat.o(112842);
                }
            });
            if (aVar.gnC != null) {
                if (mVar.mKB == null || mVar.mKB.length() <= 0) {
                    aVar.gnC.setVisibility(8);
                } else {
                    aVar.gnC.setVisibility(0);
                    aVar.gnC.setText(mVar.mKB);
                }
            }
            if (mVar.xeS) {
                aVar.gnB.setTextColor(d.this.mContext.getResources().getColor(R.color.hf));
                aVar.gnC.setTextColor(d.this.mContext.getResources().getColor(R.color.hf));
                aVar.moo.setChecked(((Boolean) this.zSB.get(Integer.valueOf(i))).booleanValue());
                aVar.moo.setEnabled(false);
            } else {
                aVar.gnB.setTextColor(d.this.mContext.getResources().getColor(R.color.he));
                aVar.gnC.setTextColor(d.this.mContext.getResources().getColor(R.color.hg));
                aVar.moo.setChecked(((Boolean) this.zSB.get(Integer.valueOf(i))).booleanValue());
                aVar.moo.setEnabled(true);
            }
            AppMethodBeat.o(112846);
            return view;
        }

        public final void dLm() {
            AppMethodBeat.i(112847);
            if (d.this.zSx == null) {
                AppMethodBeat.o(112847);
                return;
            }
            for (int i = 0; i < getCount(); i++) {
                if (d.this.zSx.contains(Integer.valueOf(i))) {
                    this.zSB.put(Integer.valueOf(i), Boolean.TRUE);
                } else {
                    this.zSB.put(Integer.valueOf(i), Boolean.FALSE);
                }
            }
            AppMethodBeat.o(112847);
        }

        public final ArrayList<Integer> dLn() {
            AppMethodBeat.i(112848);
            if (this.zSB == null) {
                AppMethodBeat.o(112848);
                return null;
            }
            this.zSC = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < getCount()) {
                    if (((Boolean) this.zSB.get(Integer.valueOf(i2))).booleanValue()) {
                        this.zSC.add(Integer.valueOf(i2));
                    }
                    i = i2 + 1;
                } else {
                    ArrayList<Integer> arrayList = this.zSC;
                    AppMethodBeat.o(112848);
                    return arrayList;
                }
            }
        }
    }

    public d(Context context) {
        AppMethodBeat.i(112849);
        this.mContext = context;
        this.zaW.setContentView(this.iym);
        this.zaX = aj.am(this.mContext, R.dimen.e2) + aj.am(this.mContext, R.dimen.e3);
        this.nA = BottomSheetBehavior.j((View) this.iym.getParent());
        if (this.nA != null) {
            this.nA.K(this.zaX);
            this.nA.nj = false;
        }
        this.zaW.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                d.this.zaW = null;
            }
        });
        AppMethodBeat.o(112849);
    }

    public final void hide() {
        AppMethodBeat.i(112850);
        if (this.zaW != null) {
            this.zaW.dismiss();
        }
        AppMethodBeat.o(112850);
    }

    static /* synthetic */ void a(d dVar, boolean z) {
        AppMethodBeat.i(112851);
        if (dVar.zSz != null) {
            dVar.zSz.kg(z);
        }
        AppMethodBeat.o(112851);
    }
}
