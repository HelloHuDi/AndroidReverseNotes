package com.tencent.p177mm.plugin.recharge.p491ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.recharge.model.C43420a;
import com.tencent.p177mm.plugin.recharge.model.C43421b;
import com.tencent.p177mm.plugin.recharge.p1655a.C46158a;
import com.tencent.p177mm.plugin.wxpay.C23226a.C23227a;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText */
public class MallEditText extends LinearLayout implements OnFocusChangeListener {
    private OnFocusChangeListener gJD;
    private ImageView gJG;
    private String gJH;
    private String gJI;
    private int gJJ;
    public boolean gJL;
    private boolean gJN;
    private int gJO;
    private int gJP;
    private TextView goa;
    private int gravity;
    private boolean hNO;
    private int imeOptions;
    private int inputType;
    private int pGA;
    private C12970b pGs;
    AutoCompleteTextView pGt;
    boolean pGu;
    private C12960a pGv;
    private List<String[]> pGw;
    private C43420a pGx;
    private Runnable pGy;
    private boolean pGz;

    /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$3 */
    class C129573 implements Runnable {
        C129573() {
        }

        public final void run() {
            AppMethodBeat.m2504i(44209);
            try {
                MallEditText.this.pGw = C46482a.m87692cJ(MallEditText.this.getContext());
                AppMethodBeat.m2505o(44209);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MallEditText", e, "", new Object[0]);
                AppMethodBeat.m2505o(44209);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$4 */
    class C129584 implements OnItemClickListener {
        C129584() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44210);
            MallEditText.this.pGx = MallEditText.this.pGv.mo24988BA(i);
            if (MallEditText.this.pGx != null) {
                C4990ab.m7410d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.this.pGx.pFM + ", record.name " + MallEditText.this.pGx.name);
                MallEditText.this.setInput(MallEditText.this.pGx);
            }
            MallEditText.this.pGt.dismissDropDown();
            AppMethodBeat.m2505o(44210);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$a */
    class C12960a extends BaseAdapter implements Filterable {
        public List<C43420a> pGC;
        public boolean pGD;
        private List<C43420a> pGE;
        private C12961a pGF;
        private String pGG;

        /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$a$1 */
        class C129591 implements OnClickListener {
            C129591() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(44211);
                MallEditText.this.pGt.dismissDropDown();
                AppMethodBeat.m2505o(44211);
            }
        }

        /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$a$a */
        class C12961a extends Filter {

            /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$a$a$1 */
            class C129621 implements Runnable {
                C129621() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(44214);
                    MallEditText.this.pGt.dismissDropDown();
                    AppMethodBeat.m2505o(44214);
                }
            }

            /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$a$a$2 */
            class C129632 implements Runnable {
                C129632() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(44215);
                    MallEditText.this.pGt.dismissDropDown();
                    AppMethodBeat.m2505o(44215);
                }
            }

            private C12961a() {
            }

            /* synthetic */ C12961a(C12960a c12960a, byte b) {
                this();
            }

            /* Access modifiers changed, original: protected|final|declared_synchronized */
            public final synchronized FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults;
                AppMethodBeat.m2504i(44217);
                FilterResults filterResults2 = new FilterResults();
                ArrayList arrayList = new ArrayList();
                String ws = charSequence != null ? C43421b.m77507ws(charSequence.toString()) : "";
                if (ws.equals(C12960a.this.pGG)) {
                    MallEditText.this.pGt.post(new C129621());
                    AppMethodBeat.m2505o(44217);
                    filterResults = filterResults2;
                } else {
                    final C43420a c43420a;
                    boolean z;
                    boolean z2;
                    C12960a.this.pGG = ws;
                    if (MallEditText.this.asa()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        C4990ab.m7410d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(charSequence)));
                        for (C43420a c43420a2 : C12960a.this.pGE) {
                            if (c43420a2.pFM.equals(C12960a.this.pGG)) {
                                c43420a2.pFO = C43420a.pFK;
                                arrayList.clear();
                                arrayList.add(c43420a2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            if (MallEditText.this.pGw == null) {
                                try {
                                    MallEditText.this.pGw = C46482a.m87692cJ(MallEditText.this.getContext());
                                } catch (Exception e) {
                                    C4990ab.printErrStackTrace("MicroMsg.MallEditText", e, "", new Object[0]);
                                }
                            }
                            if (MallEditText.this.pGw != null) {
                                for (String[] strArr : MallEditText.this.pGw) {
                                    String ws2 = C43421b.m77507ws(strArr[2]);
                                    int[] fJ = C12961a.m20938fJ(C12960a.this.pGG, ws2);
                                    if (C43420a.pFK.equals(fJ)) {
                                        C43420a c43420a3 = new C43420a(ws2, strArr[1], 1);
                                        c43420a3.pFO = C43420a.pFK;
                                        arrayList.clear();
                                        arrayList.add(c43420a3);
                                        break;
                                    } else if (!C43420a.pFL.equals(fJ) && arrayList.size() < 5) {
                                        C43420a c43420a4 = new C43420a(ws2, strArr[1], 1);
                                        c43420a4.pFO = fJ;
                                        arrayList.add(c43420a4);
                                    }
                                }
                            }
                        }
                        C4990ab.m7410d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else if (C5046bo.isNullOrNil(C12960a.this.pGG)) {
                        arrayList.addAll(C12960a.this.pGE);
                        z = false;
                    } else {
                        C4990ab.m7410d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(charSequence)));
                        for (C43420a c43420a22 : C12960a.this.pGE) {
                            if (c43420a22.pFM.startsWith(C12960a.this.pGG)) {
                                arrayList.add(c43420a22);
                            }
                        }
                        z = false;
                    }
                    if (arrayList.size() == 0) {
                        MallEditText.this.pGt.post(new C129632());
                        z2 = false;
                    } else {
                        if (arrayList.size() == 1 && MallEditText.this.asa()) {
                            c43420a22 = (C43420a) arrayList.get(0);
                            if (C43420a.pFK.equals(c43420a22.pFO)) {
                                MallEditText.this.pGt.post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(44216);
                                        MallEditText.this.pGx = c43420a22;
                                        if (C5046bo.isNullOrNil(MallEditText.this.pGx.name)) {
                                            MallEditText.this.goa.setText("");
                                            MallEditText.this.goa.setVisibility(8);
                                        } else {
                                            MallEditText.this.goa.setText(MallEditText.this.pGx.name);
                                            MallEditText.this.goa.setVisibility(0);
                                        }
                                        MallEditText.this.pGt.dismissDropDown();
                                        AppMethodBeat.m2505o(44216);
                                    }
                                });
                                z2 = false;
                            }
                        }
                        z2 = z;
                    }
                    List list = C12960a.this.pGC;
                    C12960a.this.pGC = arrayList;
                    C12960a.this.pGD = z2;
                    filterResults2.count = C12960a.this.pGC.size();
                    filterResults2.values = C12960a.this.pGC;
                    C4990ab.m7410d("MicroMsg.MallEditText", "results.count " + filterResults2.count);
                    list.clear();
                    AppMethodBeat.m2505o(44217);
                    filterResults = filterResults2;
                }
                return filterResults;
            }

            /* Access modifiers changed, original: protected|final */
            public final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            }

            /* renamed from: fJ */
            private static int[] m20938fJ(String str, String str2) {
                AppMethodBeat.m2504i(44218);
                int[] iArr;
                if (str.equals(str2)) {
                    iArr = C43420a.pFK;
                    AppMethodBeat.m2505o(44218);
                    return iArr;
                }
                if (str2 != null && str.length() == str2.length()) {
                    int i = 0;
                    int[] iArr2 = new int[]{-1, -1};
                    for (int length = str.length() - 1; length > 0; length--) {
                        if (str2.charAt(length) != str.charAt(length)) {
                            i++;
                            if (i > 2) {
                                break;
                            }
                            iArr2[i - 1] = length;
                        }
                    }
                    if (i <= 2) {
                        AppMethodBeat.m2505o(44218);
                        return iArr2;
                    }
                }
                iArr = C43420a.pFL;
                AppMethodBeat.m2505o(44218);
                return iArr;
            }
        }

        /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$a$3 */
        class C129653 implements OnClickListener {
            C129653() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(44213);
                MallEditText.this.pGt.dismissDropDown();
                AppMethodBeat.m2505o(44213);
            }
        }

        /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$a$2 */
        class C129662 implements OnClickListener {
            C129662() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(44212);
                C46158a.cea().mo74109cK(null);
                MallEditText.this.setInput(null);
                MallEditText.this.pGv.mo24989cK(new LinkedList());
                MallEditText.this.pGv.notifyDataSetChanged();
                AppMethodBeat.m2505o(44212);
            }
        }

        private C12960a() {
            AppMethodBeat.m2504i(44219);
            this.pGC = new ArrayList();
            this.pGD = false;
            AppMethodBeat.m2505o(44219);
        }

        /* synthetic */ C12960a(MallEditText mallEditText, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(44226);
            C43420a BA = mo24988BA(i);
            AppMethodBeat.m2505o(44226);
            return BA;
        }

        /* renamed from: cK */
        public final void mo24989cK(List<C43420a> list) {
            AppMethodBeat.m2504i(44220);
            this.pGE = list;
            this.pGC.clear();
            this.pGD = false;
            AppMethodBeat.m2505o(44220);
        }

        public final Filter getFilter() {
            AppMethodBeat.m2504i(44221);
            C4990ab.m7410d("MicroMsg.MallEditText", "getFilter");
            if (this.pGF == null) {
                this.pGF = new C12961a(this, (byte) 0);
            }
            C12961a c12961a = this.pGF;
            AppMethodBeat.m2505o(44221);
            return c12961a;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(44222);
            int size;
            if (this.pGD) {
                size = this.pGC.size() + 2;
                AppMethodBeat.m2505o(44222);
                return size;
            } else if (this.pGC.size() > 0) {
                size = this.pGC.size() + 1;
                AppMethodBeat.m2505o(44222);
                return size;
            } else {
                AppMethodBeat.m2505o(44222);
                return 0;
            }
        }

        /* renamed from: BA */
        public final synchronized C43420a mo24988BA(int i) {
            C43420a c43420a = null;
            synchronized (this) {
                AppMethodBeat.m2504i(44223);
                if (this.pGD) {
                    if (i == 0) {
                        AppMethodBeat.m2505o(44223);
                    } else if (i <= this.pGC.size()) {
                        c43420a = (C43420a) this.pGC.get(i - 1);
                        AppMethodBeat.m2505o(44223);
                    } else {
                        AppMethodBeat.m2505o(44223);
                    }
                } else if (i < this.pGC.size()) {
                    c43420a = (C43420a) this.pGC.get(i);
                    AppMethodBeat.m2505o(44223);
                } else {
                    AppMethodBeat.m2505o(44223);
                }
            }
            return c43420a;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(44224);
            switch (getItemViewType(i)) {
                case 0:
                    C12969c c12969c;
                    if (view == null) {
                        view = View.inflate(MallEditText.this.getContext(), 2130970472, null);
                        C12969c c12969c2 = new C12969c(MallEditText.this, (byte) 0);
                        c12969c2.pGK = (TextView) view.findViewById(2131826879);
                        c12969c2.gtb = (TextView) view.findViewById(2131826880);
                        view.setTag(c12969c2);
                        c12969c = c12969c2;
                    } else {
                        c12969c = (C12969c) view.getTag();
                    }
                    C43420a BA = mo24988BA(i);
                    if (!(BA == null || c12969c == null || c12969c.pGK == null || c12969c.gtb == null)) {
                        String VB = C43421b.m77503VB(BA.pFM);
                        C4990ab.m7410d("MicroMsg.MallEditText", "record.record " + VB + ", record.name " + BA.name);
                        if (C43420a.pFK.equals(BA.pFO)) {
                            c12969c.pGK.setText(VB);
                        } else {
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(VB);
                            for (int i2 : BA.pFO) {
                                int i22;
                                if (i22 >= 0) {
                                    if (i22 >= 7) {
                                        i22 += 2;
                                    } else if (i22 >= 3) {
                                        i22++;
                                    }
                                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), i22, i22 + 1, 34);
                                }
                            }
                            c12969c.pGK.setText(spannableStringBuilder);
                        }
                        if (BA.name == null || C5046bo.isNullOrNil(BA.name.trim())) {
                            c12969c.gtb.setText("");
                        } else {
                            c12969c.gtb.setText(MallEditText.this.getResources().getString(C25738R.string.cym, new Object[]{BA.name}));
                        }
                        view.setBackgroundResource(C25738R.drawable.f6623k5);
                        break;
                    }
                    break;
                case 1:
                    view = View.inflate(MallEditText.this.getContext(), 2130970473, null);
                    view.setOnClickListener(new C129662());
                    break;
                case 2:
                    view = View.inflate(MallEditText.this.getContext(), 2130970471, null);
                    view.setOnClickListener(new C129591());
                    break;
                case 3:
                    View inflate = View.inflate(MallEditText.this.getContext(), 2130970473, null);
                    ((TextView) inflate).setText(C25738R.string.cyb);
                    inflate.setOnClickListener(new C129653());
                    view = inflate;
                    break;
            }
            AppMethodBeat.m2505o(44224);
            return view;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(44225);
            if (this.pGD) {
                if (i == 0) {
                    AppMethodBeat.m2505o(44225);
                    return 2;
                } else if (i <= this.pGC.size()) {
                    AppMethodBeat.m2505o(44225);
                    return 0;
                } else {
                    AppMethodBeat.m2505o(44225);
                    return 3;
                }
            } else if (i < this.pGC.size()) {
                AppMethodBeat.m2505o(44225);
                return 0;
            } else {
                AppMethodBeat.m2505o(44225);
                return 1;
            }
        }

        public final int getViewTypeCount() {
            return 4;
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$1 */
    class C129671 implements TextWatcher {
        C129671() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(44208);
            String charSequence2 = charSequence.toString();
            int selectionStart = MallEditText.this.pGt.getSelectionStart();
            Object obj = "";
            if (charSequence2 != null) {
                StringBuilder stringBuilder = new StringBuilder(charSequence2.replaceAll(" ", ""));
                int length = stringBuilder.length();
                if (length >= 4) {
                    stringBuilder.insert(3, ' ');
                }
                if (length >= 8) {
                    stringBuilder.insert(8, ' ');
                }
                obj = stringBuilder.toString();
                length = obj.length();
                if (length > MallEditText.this.pGA) {
                    if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                        selectionStart++;
                    } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                        selectionStart += i3;
                    }
                } else if (length < MallEditText.this.pGA && (selectionStart == 4 || selectionStart == 9)) {
                    selectionStart--;
                }
                MallEditText.this.pGA = length;
            }
            if (charSequence2.equals(obj)) {
                MallEditText.m20944c(MallEditText.this);
                AppMethodBeat.m2505o(44208);
                return;
            }
            MallEditText.this.pGt.setText(obj);
            if (selectionStart < MallEditText.this.pGA) {
                MallEditText.this.pGt.setSelection(selectionStart);
                AppMethodBeat.m2505o(44208);
                return;
            }
            MallEditText.this.pGt.setSelection(MallEditText.this.pGA);
            AppMethodBeat.m2505o(44208);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$2 */
    class C129682 extends NumberKeyListener {
        C129682() {
        }

        public final int getInputType() {
            return 3;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' '};
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$c */
    class C12969c {
        TextView gtb;
        TextView pGK;

        private C12969c() {
        }

        /* synthetic */ C12969c(MallEditText mallEditText, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$b */
    public interface C12970b {
        void ceg();

        /* renamed from: hY */
        void mo25027hY(boolean z);
    }

    /* renamed from: c */
    static /* synthetic */ void m20944c(MallEditText mallEditText) {
        AppMethodBeat.m2504i(44245);
        mallEditText.cee();
        AppMethodBeat.m2505o(44245);
    }

    public MallEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(44227);
        this.pGv = null;
        this.gJH = "";
        this.gJI = "";
        this.inputType = 1;
        this.hNO = true;
        this.gJP = -1;
        this.gJO = 1;
        this.gravity = 19;
        this.gJJ = -1;
        this.gJN = false;
        this.pGx = null;
        this.gJL = true;
        this.pGy = null;
        this.pGz = false;
        this.pGA = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C23227a.MallEditText, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(6, 0);
        if (resourceId != 0) {
            this.gJH = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(7, 0);
        if (resourceId != 0) {
            this.gJI = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(4, 1);
        this.gJL = obtainStyledAttributes.getBoolean(3, true);
        this.gravity = obtainStyledAttributes.getInt(0, 19);
        this.hNO = obtainStyledAttributes.getBoolean(1, true);
        this.gJP = obtainStyledAttributes.getInteger(2, -1);
        this.gJJ = obtainStyledAttributes.getInteger(8, 0);
        this.imeOptions = obtainStyledAttributes.getInteger(5, 5);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(2130970469, this, true);
        this.goa = (TextView) inflate.findViewById(2131826877);
        this.pGt = (AutoCompleteTextView) inflate.findViewById(2131821052);
        if (C1338a.m2865ga(context)) {
            this.pGt.setTextSize(0, ((float) context.getResources().getDimensionPixelSize(C25738R.dimen.f9980m5)) * 1.25f);
        } else {
            this.pGt.setTextSize(0, (float) C1338a.m2856al(context, C25738R.dimen.f9980m5));
        }
        this.gJG = (ImageView) inflate.findViewById(2131821053);
        C4990ab.m7410d("MicroMsg.MallEditText", "setFormat editType:" + this.gJJ);
        this.pGt.setImeOptions(this.imeOptions);
        switch (this.gJJ) {
            case 0:
                if (!this.gJL) {
                    this.gJG.setImageResource(C25738R.drawable.f6898uq);
                    this.gJG.setVisibility(0);
                    break;
                }
                break;
            case 1:
                this.gJO = 13;
                this.gJP = 13;
                this.inputType = 2;
                setInfoTvImageResource(C25738R.drawable.f7006yb);
                this.gJG.setVisibility(0);
                break;
        }
        this.inputType = 1;
        this.pGt.addTextChangedListener(new C129671());
        this.pGt.setOnFocusChangeListener(this);
        if (!C5046bo.isNullOrNil(this.gJH)) {
            this.pGt.setHint(this.gJH);
        }
        if (this.inputType == 2) {
            this.pGt.setKeyListener(new C129682());
        } else {
            this.pGt.setInputType(this.inputType);
            this.pGt.setRawInputType(this.inputType);
        }
        this.pGt.setGravity(this.gravity);
        if (!this.hNO) {
            this.pGt.setEnabled(false);
            this.pGt.setTextColor(getResources().getColor(C25738R.color.f11782h4));
            this.pGt.setFocusable(false);
            this.pGt.setClickable(false);
        }
        if (this.gJL) {
            this.gJN = false;
        } else {
            this.gJN = true;
            this.pGt.setEnabled(false);
            this.pGt.setFocusable(false);
            this.pGt.setClickable(false);
        }
        if (this.gJP != -1) {
            this.pGt.setFilters(new InputFilter[]{new LengthFilter(this.gJP)});
        }
        C4990ab.m7410d("MicroMsg.MallEditText", "initData editType:" + this.gJJ);
        switch (this.gJJ) {
            case 1:
                C4990ab.m7410d("MicroMsg.MallEditText", "setMobileEditTv");
                List ceb = C46158a.cea().ceb();
                this.pGv = new C12960a(this, (byte) 0);
                this.pGv.mo24989cK(ceb);
                if (ceb != null && ceb.size() > 0) {
                    this.pGx = (C43420a) ceb.get(0);
                    setInput(this.pGx);
                } else if (this.pGw == null) {
                    new C129573().run();
                }
                if (ceb == null || ceb.size() == 0) {
                    C1720g.m3537RQ();
                    this.pGt.setText((String) C1720g.m3536RP().mo5239Ry().get(6, null));
                    this.pGt.setSelection(this.pGt.getText().length());
                    cee();
                }
                this.pGt.setAdapter(this.pGv);
                this.pGt.setOnItemClickListener(new C129584());
                break;
        }
        AppMethodBeat.m2505o(44227);
    }

    public MallEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(C12970b c12970b) {
        this.pGs = c12970b;
    }

    public void setHintStr(String str) {
        AppMethodBeat.m2504i(44228);
        this.pGt.setHint(str);
        AppMethodBeat.m2505o(44228);
    }

    public void setInfoTvOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(44229);
        this.gJG.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(44229);
    }

    public void setInfoTvImageResource(int i) {
        AppMethodBeat.m2504i(44230);
        this.pGu = i == C25738R.drawable.f6801r8;
        this.gJG.setImageResource(i);
        AppMethodBeat.m2505o(44230);
    }

    public void setInput(C43420a c43420a) {
        AppMethodBeat.m2504i(44231);
        this.pGx = c43420a;
        if (c43420a != null) {
            this.pGt.setText(c43420a.pFM);
            this.pGt.setSelection(this.pGt.getText().length());
            cee();
            C4990ab.m7410d("MicroMsg.MallEditText", "editTv.setText " + c43420a.pFM + ", name " + c43420a.name + ", isInputValid " + this.gJN);
            if (C5046bo.isNullOrNil(c43420a.name) || !this.gJN) {
                this.goa.setText("");
                this.goa.setVisibility(8);
                AppMethodBeat.m2505o(44231);
                return;
            }
            this.goa.setText(c43420a.name);
            this.goa.setVisibility(0);
            AppMethodBeat.m2505o(44231);
            return;
        }
        this.pGt.setText("");
        cee();
        C4990ab.m7410d("MicroMsg.MallEditText", "editTv.setText null");
        this.goa.setText("");
        this.goa.setVisibility(8);
        AppMethodBeat.m2505o(44231);
    }

    private void setInputForce(C43420a c43420a) {
        AppMethodBeat.m2504i(44232);
        this.pGx = c43420a;
        if (c43420a != null) {
            KeyListener keyListener = this.pGt.getKeyListener();
            this.pGt.setKeyListener(null);
            this.pGt.setText(c43420a.pFM);
            this.pGt.setSelection(this.pGt.getText().length());
            this.pGt.setKeyListener(keyListener);
            cee();
            C4990ab.m7410d("MicroMsg.MallEditText", "editTv.setText " + c43420a.pFM + ", name " + c43420a.name + ", isInputValid " + this.gJN);
            if (C5046bo.isNullOrNil(c43420a.name) || !this.gJN) {
                this.goa.setText("");
                this.goa.setVisibility(8);
                AppMethodBeat.m2505o(44232);
                return;
            }
            this.goa.setText(c43420a.name);
            this.goa.setVisibility(0);
            AppMethodBeat.m2505o(44232);
            return;
        }
        this.pGt.setText("");
        cee();
        C4990ab.m7410d("MicroMsg.MallEditText", "editTv.setText null");
        this.goa.setText("");
        this.goa.setVisibility(8);
        AppMethodBeat.m2505o(44232);
    }

    private void cee() {
        AppMethodBeat.m2504i(44233);
        boolean asa = asa();
        if (asa != this.gJN) {
            C4990ab.m7410d("MicroMsg.MallEditText", "View:" + this.gJI + ", editType:" + this.gJJ + " inputValid change to " + asa);
            this.gJN = asa;
            if (this.pGs != null) {
                this.pGs.mo25027hY(this.gJN);
            }
            if (!asa) {
                if (this.goa.getVisibility() == 0) {
                    this.goa.setText("");
                    this.goa.setVisibility(8);
                }
                this.pGx = null;
            }
        }
        if (this.pGs != null) {
            this.pGs.ceg();
        }
        AppMethodBeat.m2505o(44233);
    }

    public String getText() {
        AppMethodBeat.m2504i(44234);
        String bc;
        switch (this.gJJ) {
            case 1:
                bc = C5046bo.m7532bc(this.pGt.getText().toString(), "");
                AppMethodBeat.m2505o(44234);
                return bc;
            default:
                bc = C5046bo.m7532bc(this.pGt.getText().toString(), "");
                AppMethodBeat.m2505o(44234);
                return bc;
        }
    }

    public final boolean asa() {
        AppMethodBeat.m2504i(44235);
        switch (this.gJJ) {
            case 1:
                String obj = this.pGt.getText().toString();
                if (obj.length() < this.gJO || obj.length() > this.gJP || !PhoneNumberUtils.isGlobalPhoneNumber(C43421b.m77507ws(obj))) {
                    AppMethodBeat.m2505o(44235);
                    return false;
                }
                AppMethodBeat.m2505o(44235);
                return true;
            default:
                if (this.pGt.getText().length() >= this.gJO) {
                    AppMethodBeat.m2505o(44235);
                    return true;
                }
                AppMethodBeat.m2505o(44235);
                return false;
        }
    }

    public void setEllipsize(TruncateAt truncateAt) {
        AppMethodBeat.m2504i(44236);
        this.pGt.setEllipsize(truncateAt);
        AppMethodBeat.m2505o(44236);
    }

    public final boolean cef() {
        AppMethodBeat.m2504i(44237);
        if (getVisibility() != 0) {
            AppMethodBeat.m2505o(44237);
            return true;
        } else if (C5046bo.isNullOrNil(getText())) {
            C4990ab.m7410d("MicroMsg.MallEditText", "View:" + this.gJI + ", editType:" + this.gJJ + " checkInputValid : empty ");
            AppMethodBeat.m2505o(44237);
            return false;
        } else if (this.gJN) {
            AppMethodBeat.m2505o(44237);
            return true;
        } else {
            C4990ab.m7410d("MicroMsg.MallEditText", "View:" + this.gJI + ", editType:" + this.gJJ + " checkInputValid : illegal ");
            AppMethodBeat.m2505o(44237);
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gJL) {
            return false;
        }
        return true;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(44238);
        super.setOnClickListener(onClickListener);
        this.pGt.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(44238);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.m2504i(44239);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.gJD = onFocusChangeListener;
        AppMethodBeat.m2505o(44239);
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.m2504i(44240);
        if (this.gJD != null) {
            this.gJD.onFocusChange(this, z);
        }
        if (!((!this.pGz) != z || z || this.pGy == null)) {
            this.pGy.run();
        }
        this.pGz = z;
        C4990ab.m7410d("MicroMsg.MallEditText", "View:" + this.gJI + ", editType:" + this.gJJ + " onFocusChange to " + z);
        if (this.pGs != null) {
            this.pGs.mo25027hY(this.gJN);
        }
        AppMethodBeat.m2505o(44240);
    }

    public void setImeOptions(int i) {
        AppMethodBeat.m2504i(44241);
        this.pGt.setImeOptions(i);
        AppMethodBeat.m2505o(44241);
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.m2504i(44242);
        this.pGt.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.m2505o(44242);
    }

    public C43420a getInputRecord() {
        AppMethodBeat.m2504i(44243);
        C43420a c43420a;
        if (this.pGx != null) {
            c43420a = this.pGx;
            AppMethodBeat.m2505o(44243);
            return c43420a;
        }
        this.pGx = new C43420a(getText(), this.goa.getText().toString(), 0);
        c43420a = this.pGx;
        AppMethodBeat.m2505o(44243);
        return c43420a;
    }

    public void getFocus() {
        AppMethodBeat.m2504i(44244);
        this.pGt.findFocus();
        AppMethodBeat.m2505o(44244);
    }
}
