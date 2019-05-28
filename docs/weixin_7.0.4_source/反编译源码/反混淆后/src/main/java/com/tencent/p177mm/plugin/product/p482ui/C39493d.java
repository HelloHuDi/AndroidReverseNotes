package com.tencent.p177mm.plugin.product.p482ui;

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
import java.util.List;

/* renamed from: com.tencent.mm.plugin.product.ui.d */
public final class C39493d {

    /* renamed from: com.tencent.mm.plugin.product.ui.d$a */
    static class C12827a extends BaseAdapter {
        List<String> aEB;
        private final Context context;
        int piC = -1;
        private final int style;

        public C12827a(Context context) {
            this.context = context;
            this.style = 1;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(44050);
            if (this.aEB != null) {
                int size = this.aEB.size();
                AppMethodBeat.m2505o(44050);
                return size;
            }
            AppMethodBeat.m2505o(44050);
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
            AppMethodBeat.m2504i(44051);
            if (view == null) {
                view = View.inflate(this.context, 2130970175, null);
                C28675b c28675b = new C28675b();
                c28675b.piD = (TextView) view.findViewById(2131820674);
                c28675b.piE = (CheckBox) view.findViewById(2131826057);
                c28675b.piF = (RadioButton) view.findViewById(2131820934);
                view.setTag(c28675b);
            }
            C28675b c28675b2 = (C28675b) view.getTag();
            c28675b2.piD.setText((CharSequence) this.aEB.get(i));
            switch (this.style) {
                case 1:
                    c28675b2.piE.setVisibility(8);
                    c28675b2.piF.setVisibility(0);
                    c28675b2.piF.setChecked(i == this.piC);
                    break;
                case 2:
                    c28675b2.piE.setVisibility(0);
                    c28675b2.piF.setVisibility(8);
                    CheckBox checkBox = c28675b2.piE;
                    if (i != this.piC) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    break;
                default:
                    c28675b2.piE.setVisibility(8);
                    c28675b2.piF.setVisibility(8);
                    break;
            }
            AppMethodBeat.m2505o(44051);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.d$b */
    static class C28675b {
        TextView piD;
        CheckBox piE;
        RadioButton piF;

        C28675b() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.d$1 */
    static class C394941 implements OnItemClickListener {
        final /* synthetic */ OnItemClickListener piA;
        final /* synthetic */ C12827a piB;

        C394941(OnItemClickListener onItemClickListener, C12827a c12827a) {
            this.piA = onItemClickListener;
            this.piB = c12827a;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44049);
            if (this.piA != null) {
                this.piA.onItemClick(adapterView, view, i, j);
            }
            this.piB.piC = i;
            this.piB.notifyDataSetChanged();
            AppMethodBeat.m2505o(44049);
        }
    }
}
