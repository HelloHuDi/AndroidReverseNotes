package com.tencent.p177mm.p612ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.C17391c;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ui.widget.picker.d */
public final class C44403d {
    public Button grC = ((Button) this.iym.findViewById(2131823196));
    public View iym = View.inflate(this.mContext, 2130970263, null);
    public Button jAH = ((Button) this.iym.findViewById(2131822819));
    public Context mContext;
    /* renamed from: nA */
    private BottomSheetBehavior f17261nA;
    public C36073c rBl;
    public C5279d rBm;
    public C44273l rBn = new C44273l(this.mContext);
    public TextView rMl = ((TextView) this.iym.findViewById(2131823952));
    public ListView zSv = ((ListView) this.iym.findViewById(2131826212));
    public View zSw = this.iym.findViewById(2131826211);
    public ArrayList<Integer> zSx;
    public C44401a zSy;
    public C24103b zSz;
    public C17391c zaW = new C17391c(this.mContext);
    public int zaX;

    /* renamed from: com.tencent.mm.ui.widget.picker.d$1 */
    class C241021 implements OnDismissListener {
        C241021() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            C44403d.this.zaW = null;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.d$b */
    public interface C24103b {
        /* renamed from: kg */
        void mo25108kg(boolean z);
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.d$2 */
    public class C443992 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(112840);
            C44403d c44403d = C44403d.this;
            C44403d.this.zSy.dLn();
            C44403d.m80263a(c44403d, true);
            C44403d.this.hide();
            AppMethodBeat.m2505o(112840);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.d$3 */
    public class C444003 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(112841);
            C44403d.m80263a(C44403d.this, false);
            C44403d.this.hide();
            AppMethodBeat.m2505o(112841);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.d$a */
    public class C44401a extends BaseAdapter {
        private Context context;
        public HashMap<Integer, Boolean> zSB = new HashMap();
        private ArrayList<Integer> zSC;

        /* renamed from: com.tencent.mm.ui.widget.picker.d$a$a */
        class C44402a {
            TextView gnB;
            TextView gnC;
            CheckBox moo;
            LinearLayout zQH;

            C44402a() {
            }
        }

        public C44401a(Context context) {
            AppMethodBeat.m2504i(112843);
            this.context = context;
            AppMethodBeat.m2505o(112843);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(112844);
            int size = C44403d.this.rBn.size();
            AppMethodBeat.m2505o(112844);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(112845);
            Object obj = C44403d.this.rBn.yvT.get(i);
            AppMethodBeat.m2505o(112845);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            C44402a c44402a;
            AppMethodBeat.m2504i(112846);
            final C44274m c44274m = (C44274m) C44403d.this.rBn.yvT.get(i);
            LayoutInflater from = LayoutInflater.from(this.context);
            if (view == null) {
                view = from.inflate(2130970262, null);
                C44402a c44402a2 = new C44402a();
                c44402a2.zQH = (LinearLayout) view.findViewById(2131826208);
                c44402a2.moo = (CheckBox) view.findViewById(2131826210);
                c44402a2.gnB = (TextView) view.findViewById(2131823564);
                c44402a2.gnC = (TextView) view.findViewById(2131826209);
                view.setTag(c44402a2);
                c44402a = c44402a2;
            } else {
                c44402a = (C44402a) view.getTag();
            }
            c44402a.gnB.setText(c44274m.getTitle());
            c44402a.zQH.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(112842);
                    if (C44403d.this.rBm != null) {
                        C44403d.this.rBm.onMMMenuItemSelected(C44403d.this.rBn.getItem(i), i);
                    }
                    if (c44274m.xeS) {
                        AppMethodBeat.m2505o(112842);
                        return;
                    }
                    if (((Boolean) C44401a.this.zSB.get(Integer.valueOf(i))).booleanValue()) {
                        C44401a.this.zSB.put(Integer.valueOf(i), Boolean.FALSE);
                    } else {
                        C44401a.this.zSB.put(Integer.valueOf(i), Boolean.TRUE);
                    }
                    C44401a.this.zSB = C44401a.this.zSB;
                    C44401a.this.notifyDataSetChanged();
                    AppMethodBeat.m2505o(112842);
                }
            });
            if (c44402a.gnC != null) {
                if (c44274m.mKB == null || c44274m.mKB.length() <= 0) {
                    c44402a.gnC.setVisibility(8);
                } else {
                    c44402a.gnC.setVisibility(0);
                    c44402a.gnC.setText(c44274m.mKB);
                }
            }
            if (c44274m.xeS) {
                c44402a.gnB.setTextColor(C44403d.this.mContext.getResources().getColor(C25738R.color.f11792hf));
                c44402a.gnC.setTextColor(C44403d.this.mContext.getResources().getColor(C25738R.color.f11792hf));
                c44402a.moo.setChecked(((Boolean) this.zSB.get(Integer.valueOf(i))).booleanValue());
                c44402a.moo.setEnabled(false);
            } else {
                c44402a.gnB.setTextColor(C44403d.this.mContext.getResources().getColor(C25738R.color.f11791he));
                c44402a.gnC.setTextColor(C44403d.this.mContext.getResources().getColor(C25738R.color.f11793hg));
                c44402a.moo.setChecked(((Boolean) this.zSB.get(Integer.valueOf(i))).booleanValue());
                c44402a.moo.setEnabled(true);
            }
            AppMethodBeat.m2505o(112846);
            return view;
        }

        public final void dLm() {
            AppMethodBeat.m2504i(112847);
            if (C44403d.this.zSx == null) {
                AppMethodBeat.m2505o(112847);
                return;
            }
            for (int i = 0; i < getCount(); i++) {
                if (C44403d.this.zSx.contains(Integer.valueOf(i))) {
                    this.zSB.put(Integer.valueOf(i), Boolean.TRUE);
                } else {
                    this.zSB.put(Integer.valueOf(i), Boolean.FALSE);
                }
            }
            AppMethodBeat.m2505o(112847);
        }

        public final ArrayList<Integer> dLn() {
            AppMethodBeat.m2504i(112848);
            if (this.zSB == null) {
                AppMethodBeat.m2505o(112848);
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
                    AppMethodBeat.m2505o(112848);
                    return arrayList;
                }
            }
        }
    }

    public C44403d(Context context) {
        AppMethodBeat.m2504i(112849);
        this.mContext = context;
        this.zaW.setContentView(this.iym);
        this.zaX = C5229aj.m7981am(this.mContext, C25738R.dimen.f9736e2) + C5229aj.m7981am(this.mContext, C25738R.dimen.f9737e3);
        this.f17261nA = BottomSheetBehavior.m38322j((View) this.iym.getParent());
        if (this.f17261nA != null) {
            this.f17261nA.mo41462K(this.zaX);
            this.f17261nA.f4913nj = false;
        }
        this.zaW.setOnDismissListener(new C241021());
        AppMethodBeat.m2505o(112849);
    }

    public final void hide() {
        AppMethodBeat.m2504i(112850);
        if (this.zaW != null) {
            this.zaW.dismiss();
        }
        AppMethodBeat.m2505o(112850);
    }

    /* renamed from: a */
    static /* synthetic */ void m80263a(C44403d c44403d, boolean z) {
        AppMethodBeat.m2504i(112851);
        if (c44403d.zSz != null) {
            c44403d.zSz.mo25108kg(z);
        }
        AppMethodBeat.m2505o(112851);
    }
}
