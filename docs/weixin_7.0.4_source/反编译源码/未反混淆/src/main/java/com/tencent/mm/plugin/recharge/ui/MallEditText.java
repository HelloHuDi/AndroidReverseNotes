package com.tencent.mm.plugin.recharge.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    private b pGs;
    AutoCompleteTextView pGt;
    boolean pGu;
    private a pGv;
    private List<String[]> pGw;
    private com.tencent.mm.plugin.recharge.model.a pGx;
    private Runnable pGy;
    private boolean pGz;

    class a extends BaseAdapter implements Filterable {
        public List<com.tencent.mm.plugin.recharge.model.a> pGC;
        public boolean pGD;
        private List<com.tencent.mm.plugin.recharge.model.a> pGE;
        private a pGF;
        private String pGG;

        class a extends Filter {
            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }

            /* Access modifiers changed, original: protected|final|declared_synchronized */
            public final synchronized FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults;
                AppMethodBeat.i(44217);
                FilterResults filterResults2 = new FilterResults();
                ArrayList arrayList = new ArrayList();
                String ws = charSequence != null ? com.tencent.mm.plugin.recharge.model.b.ws(charSequence.toString()) : "";
                if (ws.equals(a.this.pGG)) {
                    MallEditText.this.pGt.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(44214);
                            MallEditText.this.pGt.dismissDropDown();
                            AppMethodBeat.o(44214);
                        }
                    });
                    AppMethodBeat.o(44217);
                    filterResults = filterResults2;
                } else {
                    final com.tencent.mm.plugin.recharge.model.a aVar;
                    boolean z;
                    boolean z2;
                    a.this.pGG = ws;
                    if (MallEditText.this.asa()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        ab.d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(charSequence)));
                        for (com.tencent.mm.plugin.recharge.model.a aVar2 : a.this.pGE) {
                            if (aVar2.pFM.equals(a.this.pGG)) {
                                aVar2.pFO = com.tencent.mm.plugin.recharge.model.a.pFK;
                                arrayList.clear();
                                arrayList.add(aVar2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            if (MallEditText.this.pGw == null) {
                                try {
                                    MallEditText.this.pGw = com.tencent.mm.pluginsdk.a.cJ(MallEditText.this.getContext());
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.MallEditText", e, "", new Object[0]);
                                }
                            }
                            if (MallEditText.this.pGw != null) {
                                for (String[] strArr : MallEditText.this.pGw) {
                                    String ws2 = com.tencent.mm.plugin.recharge.model.b.ws(strArr[2]);
                                    int[] fJ = fJ(a.this.pGG, ws2);
                                    if (com.tencent.mm.plugin.recharge.model.a.pFK.equals(fJ)) {
                                        com.tencent.mm.plugin.recharge.model.a aVar3 = new com.tencent.mm.plugin.recharge.model.a(ws2, strArr[1], 1);
                                        aVar3.pFO = com.tencent.mm.plugin.recharge.model.a.pFK;
                                        arrayList.clear();
                                        arrayList.add(aVar3);
                                        break;
                                    } else if (!com.tencent.mm.plugin.recharge.model.a.pFL.equals(fJ) && arrayList.size() < 5) {
                                        com.tencent.mm.plugin.recharge.model.a aVar4 = new com.tencent.mm.plugin.recharge.model.a(ws2, strArr[1], 1);
                                        aVar4.pFO = fJ;
                                        arrayList.add(aVar4);
                                    }
                                }
                            }
                        }
                        ab.d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else if (bo.isNullOrNil(a.this.pGG)) {
                        arrayList.addAll(a.this.pGE);
                        z = false;
                    } else {
                        ab.d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(charSequence)));
                        for (com.tencent.mm.plugin.recharge.model.a aVar22 : a.this.pGE) {
                            if (aVar22.pFM.startsWith(a.this.pGG)) {
                                arrayList.add(aVar22);
                            }
                        }
                        z = false;
                    }
                    if (arrayList.size() == 0) {
                        MallEditText.this.pGt.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(44215);
                                MallEditText.this.pGt.dismissDropDown();
                                AppMethodBeat.o(44215);
                            }
                        });
                        z2 = false;
                    } else {
                        if (arrayList.size() == 1 && MallEditText.this.asa()) {
                            aVar22 = (com.tencent.mm.plugin.recharge.model.a) arrayList.get(0);
                            if (com.tencent.mm.plugin.recharge.model.a.pFK.equals(aVar22.pFO)) {
                                MallEditText.this.pGt.post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(44216);
                                        MallEditText.this.pGx = aVar22;
                                        if (bo.isNullOrNil(MallEditText.this.pGx.name)) {
                                            MallEditText.this.goa.setText("");
                                            MallEditText.this.goa.setVisibility(8);
                                        } else {
                                            MallEditText.this.goa.setText(MallEditText.this.pGx.name);
                                            MallEditText.this.goa.setVisibility(0);
                                        }
                                        MallEditText.this.pGt.dismissDropDown();
                                        AppMethodBeat.o(44216);
                                    }
                                });
                                z2 = false;
                            }
                        }
                        z2 = z;
                    }
                    List list = a.this.pGC;
                    a.this.pGC = arrayList;
                    a.this.pGD = z2;
                    filterResults2.count = a.this.pGC.size();
                    filterResults2.values = a.this.pGC;
                    ab.d("MicroMsg.MallEditText", "results.count " + filterResults2.count);
                    list.clear();
                    AppMethodBeat.o(44217);
                    filterResults = filterResults2;
                }
                return filterResults;
            }

            /* Access modifiers changed, original: protected|final */
            public final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            }

            private static int[] fJ(String str, String str2) {
                AppMethodBeat.i(44218);
                int[] iArr;
                if (str.equals(str2)) {
                    iArr = com.tencent.mm.plugin.recharge.model.a.pFK;
                    AppMethodBeat.o(44218);
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
                        AppMethodBeat.o(44218);
                        return iArr2;
                    }
                }
                iArr = com.tencent.mm.plugin.recharge.model.a.pFL;
                AppMethodBeat.o(44218);
                return iArr;
            }
        }

        private a() {
            AppMethodBeat.i(44219);
            this.pGC = new ArrayList();
            this.pGD = false;
            AppMethodBeat.o(44219);
        }

        /* synthetic */ a(MallEditText mallEditText, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(44226);
            com.tencent.mm.plugin.recharge.model.a BA = BA(i);
            AppMethodBeat.o(44226);
            return BA;
        }

        public final void cK(List<com.tencent.mm.plugin.recharge.model.a> list) {
            AppMethodBeat.i(44220);
            this.pGE = list;
            this.pGC.clear();
            this.pGD = false;
            AppMethodBeat.o(44220);
        }

        public final Filter getFilter() {
            AppMethodBeat.i(44221);
            ab.d("MicroMsg.MallEditText", "getFilter");
            if (this.pGF == null) {
                this.pGF = new a(this, (byte) 0);
            }
            a aVar = this.pGF;
            AppMethodBeat.o(44221);
            return aVar;
        }

        public final int getCount() {
            AppMethodBeat.i(44222);
            int size;
            if (this.pGD) {
                size = this.pGC.size() + 2;
                AppMethodBeat.o(44222);
                return size;
            } else if (this.pGC.size() > 0) {
                size = this.pGC.size() + 1;
                AppMethodBeat.o(44222);
                return size;
            } else {
                AppMethodBeat.o(44222);
                return 0;
            }
        }

        public final synchronized com.tencent.mm.plugin.recharge.model.a BA(int i) {
            com.tencent.mm.plugin.recharge.model.a aVar = null;
            synchronized (this) {
                AppMethodBeat.i(44223);
                if (this.pGD) {
                    if (i == 0) {
                        AppMethodBeat.o(44223);
                    } else if (i <= this.pGC.size()) {
                        aVar = (com.tencent.mm.plugin.recharge.model.a) this.pGC.get(i - 1);
                        AppMethodBeat.o(44223);
                    } else {
                        AppMethodBeat.o(44223);
                    }
                } else if (i < this.pGC.size()) {
                    aVar = (com.tencent.mm.plugin.recharge.model.a) this.pGC.get(i);
                    AppMethodBeat.o(44223);
                } else {
                    AppMethodBeat.o(44223);
                }
            }
            return aVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(44224);
            switch (getItemViewType(i)) {
                case 0:
                    c cVar;
                    if (view == null) {
                        view = View.inflate(MallEditText.this.getContext(), R.layout.ane, null);
                        c cVar2 = new c(MallEditText.this, (byte) 0);
                        cVar2.pGK = (TextView) view.findViewById(R.id.dw9);
                        cVar2.gtb = (TextView) view.findViewById(R.id.dw_);
                        view.setTag(cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (c) view.getTag();
                    }
                    com.tencent.mm.plugin.recharge.model.a BA = BA(i);
                    if (!(BA == null || cVar == null || cVar.pGK == null || cVar.gtb == null)) {
                        String VB = com.tencent.mm.plugin.recharge.model.b.VB(BA.pFM);
                        ab.d("MicroMsg.MallEditText", "record.record " + VB + ", record.name " + BA.name);
                        if (com.tencent.mm.plugin.recharge.model.a.pFK.equals(BA.pFO)) {
                            cVar.pGK.setText(VB);
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
                            cVar.pGK.setText(spannableStringBuilder);
                        }
                        if (BA.name == null || bo.isNullOrNil(BA.name.trim())) {
                            cVar.gtb.setText("");
                        } else {
                            cVar.gtb.setText(MallEditText.this.getResources().getString(R.string.cym, new Object[]{BA.name}));
                        }
                        view.setBackgroundResource(R.drawable.k5);
                        break;
                    }
                    break;
                case 1:
                    view = View.inflate(MallEditText.this.getContext(), R.layout.anf, null);
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(44212);
                            com.tencent.mm.plugin.recharge.a.a.cea().cK(null);
                            MallEditText.this.setInput(null);
                            MallEditText.this.pGv.cK(new LinkedList());
                            MallEditText.this.pGv.notifyDataSetChanged();
                            AppMethodBeat.o(44212);
                        }
                    });
                    break;
                case 2:
                    view = View.inflate(MallEditText.this.getContext(), R.layout.and, null);
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(44211);
                            MallEditText.this.pGt.dismissDropDown();
                            AppMethodBeat.o(44211);
                        }
                    });
                    break;
                case 3:
                    View inflate = View.inflate(MallEditText.this.getContext(), R.layout.anf, null);
                    ((TextView) inflate).setText(R.string.cyb);
                    inflate.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(44213);
                            MallEditText.this.pGt.dismissDropDown();
                            AppMethodBeat.o(44213);
                        }
                    });
                    view = inflate;
                    break;
            }
            AppMethodBeat.o(44224);
            return view;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(44225);
            if (this.pGD) {
                if (i == 0) {
                    AppMethodBeat.o(44225);
                    return 2;
                } else if (i <= this.pGC.size()) {
                    AppMethodBeat.o(44225);
                    return 0;
                } else {
                    AppMethodBeat.o(44225);
                    return 3;
                }
            } else if (i < this.pGC.size()) {
                AppMethodBeat.o(44225);
                return 0;
            } else {
                AppMethodBeat.o(44225);
                return 1;
            }
        }

        public final int getViewTypeCount() {
            return 4;
        }
    }

    class c {
        TextView gtb;
        TextView pGK;

        private c() {
        }

        /* synthetic */ c(MallEditText mallEditText, byte b) {
            this();
        }
    }

    public interface b {
        void ceg();

        void hY(boolean z);
    }

    static /* synthetic */ void c(MallEditText mallEditText) {
        AppMethodBeat.i(44245);
        mallEditText.cee();
        AppMethodBeat.o(44245);
    }

    public MallEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(44227);
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.plugin.wxpay.a.a.MallEditText, i, 0);
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.anb, this, true);
        this.goa = (TextView) inflate.findViewById(R.id.dw7);
        this.pGt = (AutoCompleteTextView) inflate.findViewById(R.id.n1);
        if (com.tencent.mm.bz.a.ga(context)) {
            this.pGt.setTextSize(0, ((float) context.getResources().getDimensionPixelSize(R.dimen.m5)) * 1.25f);
        } else {
            this.pGt.setTextSize(0, (float) com.tencent.mm.bz.a.al(context, R.dimen.m5));
        }
        this.gJG = (ImageView) inflate.findViewById(R.id.n2);
        ab.d("MicroMsg.MallEditText", "setFormat editType:" + this.gJJ);
        this.pGt.setImeOptions(this.imeOptions);
        switch (this.gJJ) {
            case 0:
                if (!this.gJL) {
                    this.gJG.setImageResource(R.drawable.uq);
                    this.gJG.setVisibility(0);
                    break;
                }
                break;
            case 1:
                this.gJO = 13;
                this.gJP = 13;
                this.inputType = 2;
                setInfoTvImageResource(R.drawable.yb);
                this.gJG.setVisibility(0);
                break;
        }
        this.inputType = 1;
        this.pGt.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(44208);
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
                    MallEditText.c(MallEditText.this);
                    AppMethodBeat.o(44208);
                    return;
                }
                MallEditText.this.pGt.setText(obj);
                if (selectionStart < MallEditText.this.pGA) {
                    MallEditText.this.pGt.setSelection(selectionStart);
                    AppMethodBeat.o(44208);
                    return;
                }
                MallEditText.this.pGt.setSelection(MallEditText.this.pGA);
                AppMethodBeat.o(44208);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.pGt.setOnFocusChangeListener(this);
        if (!bo.isNullOrNil(this.gJH)) {
            this.pGt.setHint(this.gJH);
        }
        if (this.inputType == 2) {
            this.pGt.setKeyListener(new NumberKeyListener() {
                public final int getInputType() {
                    return 3;
                }

                /* Access modifiers changed, original: protected|final */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' '};
                }
            });
        } else {
            this.pGt.setInputType(this.inputType);
            this.pGt.setRawInputType(this.inputType);
        }
        this.pGt.setGravity(this.gravity);
        if (!this.hNO) {
            this.pGt.setEnabled(false);
            this.pGt.setTextColor(getResources().getColor(R.color.h4));
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
        ab.d("MicroMsg.MallEditText", "initData editType:" + this.gJJ);
        switch (this.gJJ) {
            case 1:
                ab.d("MicroMsg.MallEditText", "setMobileEditTv");
                List ceb = com.tencent.mm.plugin.recharge.a.a.cea().ceb();
                this.pGv = new a(this, (byte) 0);
                this.pGv.cK(ceb);
                if (ceb != null && ceb.size() > 0) {
                    this.pGx = (com.tencent.mm.plugin.recharge.model.a) ceb.get(0);
                    setInput(this.pGx);
                } else if (this.pGw == null) {
                    new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(44209);
                            try {
                                MallEditText.this.pGw = com.tencent.mm.pluginsdk.a.cJ(MallEditText.this.getContext());
                                AppMethodBeat.o(44209);
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.MallEditText", e, "", new Object[0]);
                                AppMethodBeat.o(44209);
                            }
                        }
                    }.run();
                }
                if (ceb == null || ceb.size() == 0) {
                    g.RQ();
                    this.pGt.setText((String) g.RP().Ry().get(6, null));
                    this.pGt.setSelection(this.pGt.getText().length());
                    cee();
                }
                this.pGt.setAdapter(this.pGv);
                this.pGt.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(44210);
                        MallEditText.this.pGx = MallEditText.this.pGv.BA(i);
                        if (MallEditText.this.pGx != null) {
                            ab.d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.this.pGx.pFM + ", record.name " + MallEditText.this.pGx.name);
                            MallEditText.this.setInput(MallEditText.this.pGx);
                        }
                        MallEditText.this.pGt.dismissDropDown();
                        AppMethodBeat.o(44210);
                    }
                });
                break;
        }
        AppMethodBeat.o(44227);
    }

    public MallEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(b bVar) {
        this.pGs = bVar;
    }

    public void setHintStr(String str) {
        AppMethodBeat.i(44228);
        this.pGt.setHint(str);
        AppMethodBeat.o(44228);
    }

    public void setInfoTvOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(44229);
        this.gJG.setOnClickListener(onClickListener);
        AppMethodBeat.o(44229);
    }

    public void setInfoTvImageResource(int i) {
        AppMethodBeat.i(44230);
        this.pGu = i == R.drawable.r8;
        this.gJG.setImageResource(i);
        AppMethodBeat.o(44230);
    }

    public void setInput(com.tencent.mm.plugin.recharge.model.a aVar) {
        AppMethodBeat.i(44231);
        this.pGx = aVar;
        if (aVar != null) {
            this.pGt.setText(aVar.pFM);
            this.pGt.setSelection(this.pGt.getText().length());
            cee();
            ab.d("MicroMsg.MallEditText", "editTv.setText " + aVar.pFM + ", name " + aVar.name + ", isInputValid " + this.gJN);
            if (bo.isNullOrNil(aVar.name) || !this.gJN) {
                this.goa.setText("");
                this.goa.setVisibility(8);
                AppMethodBeat.o(44231);
                return;
            }
            this.goa.setText(aVar.name);
            this.goa.setVisibility(0);
            AppMethodBeat.o(44231);
            return;
        }
        this.pGt.setText("");
        cee();
        ab.d("MicroMsg.MallEditText", "editTv.setText null");
        this.goa.setText("");
        this.goa.setVisibility(8);
        AppMethodBeat.o(44231);
    }

    private void setInputForce(com.tencent.mm.plugin.recharge.model.a aVar) {
        AppMethodBeat.i(44232);
        this.pGx = aVar;
        if (aVar != null) {
            KeyListener keyListener = this.pGt.getKeyListener();
            this.pGt.setKeyListener(null);
            this.pGt.setText(aVar.pFM);
            this.pGt.setSelection(this.pGt.getText().length());
            this.pGt.setKeyListener(keyListener);
            cee();
            ab.d("MicroMsg.MallEditText", "editTv.setText " + aVar.pFM + ", name " + aVar.name + ", isInputValid " + this.gJN);
            if (bo.isNullOrNil(aVar.name) || !this.gJN) {
                this.goa.setText("");
                this.goa.setVisibility(8);
                AppMethodBeat.o(44232);
                return;
            }
            this.goa.setText(aVar.name);
            this.goa.setVisibility(0);
            AppMethodBeat.o(44232);
            return;
        }
        this.pGt.setText("");
        cee();
        ab.d("MicroMsg.MallEditText", "editTv.setText null");
        this.goa.setText("");
        this.goa.setVisibility(8);
        AppMethodBeat.o(44232);
    }

    private void cee() {
        AppMethodBeat.i(44233);
        boolean asa = asa();
        if (asa != this.gJN) {
            ab.d("MicroMsg.MallEditText", "View:" + this.gJI + ", editType:" + this.gJJ + " inputValid change to " + asa);
            this.gJN = asa;
            if (this.pGs != null) {
                this.pGs.hY(this.gJN);
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
        AppMethodBeat.o(44233);
    }

    public String getText() {
        AppMethodBeat.i(44234);
        String bc;
        switch (this.gJJ) {
            case 1:
                bc = bo.bc(this.pGt.getText().toString(), "");
                AppMethodBeat.o(44234);
                return bc;
            default:
                bc = bo.bc(this.pGt.getText().toString(), "");
                AppMethodBeat.o(44234);
                return bc;
        }
    }

    public final boolean asa() {
        AppMethodBeat.i(44235);
        switch (this.gJJ) {
            case 1:
                String obj = this.pGt.getText().toString();
                if (obj.length() < this.gJO || obj.length() > this.gJP || !PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.ws(obj))) {
                    AppMethodBeat.o(44235);
                    return false;
                }
                AppMethodBeat.o(44235);
                return true;
            default:
                if (this.pGt.getText().length() >= this.gJO) {
                    AppMethodBeat.o(44235);
                    return true;
                }
                AppMethodBeat.o(44235);
                return false;
        }
    }

    public void setEllipsize(TruncateAt truncateAt) {
        AppMethodBeat.i(44236);
        this.pGt.setEllipsize(truncateAt);
        AppMethodBeat.o(44236);
    }

    public final boolean cef() {
        AppMethodBeat.i(44237);
        if (getVisibility() != 0) {
            AppMethodBeat.o(44237);
            return true;
        } else if (bo.isNullOrNil(getText())) {
            ab.d("MicroMsg.MallEditText", "View:" + this.gJI + ", editType:" + this.gJJ + " checkInputValid : empty ");
            AppMethodBeat.o(44237);
            return false;
        } else if (this.gJN) {
            AppMethodBeat.o(44237);
            return true;
        } else {
            ab.d("MicroMsg.MallEditText", "View:" + this.gJI + ", editType:" + this.gJJ + " checkInputValid : illegal ");
            AppMethodBeat.o(44237);
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
        AppMethodBeat.i(44238);
        super.setOnClickListener(onClickListener);
        this.pGt.setOnClickListener(onClickListener);
        AppMethodBeat.o(44238);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(44239);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.gJD = onFocusChangeListener;
        AppMethodBeat.o(44239);
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(44240);
        if (this.gJD != null) {
            this.gJD.onFocusChange(this, z);
        }
        if (!((!this.pGz) != z || z || this.pGy == null)) {
            this.pGy.run();
        }
        this.pGz = z;
        ab.d("MicroMsg.MallEditText", "View:" + this.gJI + ", editType:" + this.gJJ + " onFocusChange to " + z);
        if (this.pGs != null) {
            this.pGs.hY(this.gJN);
        }
        AppMethodBeat.o(44240);
    }

    public void setImeOptions(int i) {
        AppMethodBeat.i(44241);
        this.pGt.setImeOptions(i);
        AppMethodBeat.o(44241);
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.i(44242);
        this.pGt.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.o(44242);
    }

    public com.tencent.mm.plugin.recharge.model.a getInputRecord() {
        AppMethodBeat.i(44243);
        com.tencent.mm.plugin.recharge.model.a aVar;
        if (this.pGx != null) {
            aVar = this.pGx;
            AppMethodBeat.o(44243);
            return aVar;
        }
        this.pGx = new com.tencent.mm.plugin.recharge.model.a(getText(), this.goa.getText().toString(), 0);
        aVar = this.pGx;
        AppMethodBeat.o(44243);
        return aVar;
    }

    public void getFocus() {
        AppMethodBeat.i(44244);
        this.pGt.findFocus();
        AppMethodBeat.o(44244);
    }
}
