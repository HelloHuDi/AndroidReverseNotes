package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.List;

public final class d {

    static class a extends BaseAdapter {
        List<String> aEB;
        private final Context context;
        int piC = -1;
        private final int style;

        public a(Context context) {
            this.context = context;
            this.style = 1;
        }

        public final int getCount() {
            AppMethodBeat.i(44050);
            if (this.aEB != null) {
                int size = this.aEB.size();
                AppMethodBeat.o(44050);
                return size;
            }
            AppMethodBeat.o(44050);
            return 0;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            AppMethodBeat.i(44051);
            if (view == null) {
                view = View.inflate(this.context, R.layout.afe, null);
                b bVar = new b();
                bVar.piD = (TextView) view.findViewById(R.id.ct);
                bVar.piE = (CheckBox) view.findViewById(R.id.da1);
                bVar.piF = (RadioButton) view.findViewById(R.id.ju);
                view.setTag(bVar);
            }
            b bVar2 = (b) view.getTag();
            bVar2.piD.setText((CharSequence) this.aEB.get(i));
            switch (this.style) {
                case 1:
                    bVar2.piE.setVisibility(8);
                    bVar2.piF.setVisibility(0);
                    bVar2.piF.setChecked(i == this.piC);
                    break;
                case 2:
                    bVar2.piE.setVisibility(0);
                    bVar2.piF.setVisibility(8);
                    CheckBox checkBox = bVar2.piE;
                    if (i != this.piC) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    break;
                default:
                    bVar2.piE.setVisibility(8);
                    bVar2.piF.setVisibility(8);
                    break;
            }
            AppMethodBeat.o(44051);
            return view;
        }
    }

    static class b {
        TextView piD;
        CheckBox piE;
        RadioButton piF;

        b() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.d$1 */
    static class AnonymousClass1 implements OnItemClickListener {
        final /* synthetic */ OnItemClickListener piA;
        final /* synthetic */ a piB;

        AnonymousClass1(OnItemClickListener onItemClickListener, a aVar) {
            this.piA = onItemClickListener;
            this.piB = aVar;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(44049);
            if (this.piA != null) {
                this.piA.onItemClick(adapterView, view, i, j);
            }
            this.piB.piC = i;
            this.piB.notifyDataSetChanged();
            AppMethodBeat.o(44049);
        }
    }
}
