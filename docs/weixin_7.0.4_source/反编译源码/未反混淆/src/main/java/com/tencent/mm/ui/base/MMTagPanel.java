package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MMTagPanel extends FlowLayout {
    public boolean mXt = true;
    private boolean mjY = false;
    private int mlt = R.color.w4;
    private int mlu = R.drawable.a31;
    private int nCZ = R.drawable.a2v;
    private int nDa = R.color.a61;
    private LinkedList<d> wiH = new LinkedList();
    private boolean yxA = false;
    private OnClickListener yxB = new OnClickListener() {
        public final void onClick(final View view) {
            AppMethodBeat.i(106820);
            if (((Integer) view.getTag()).intValue() == 0) {
                MMTagPanel.this.a((TextView) view, true, false);
                if (MMTagPanel.this.yxw != null) {
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(106817);
                            MMTagPanel.this.yxw.JS(((TextView) view).getText().toString());
                            AppMethodBeat.o(106817);
                        }
                    });
                    AppMethodBeat.o(106820);
                    return;
                }
            } else if (!MMTagPanel.this.yxm || MMTagPanel.this.yxo) {
                MMTagPanel.this.a((TextView) view, false, false);
                if (MMTagPanel.this.yxw != null) {
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(106818);
                            MMTagPanel.this.yxw.JR(((TextView) view).getText().toString());
                            AppMethodBeat.o(106818);
                        }
                    });
                    AppMethodBeat.o(106820);
                    return;
                }
            } else if (MMTagPanel.this.yxu == null) {
                MMTagPanel.this.yxu = MMTagPanel.a(MMTagPanel.this, ((TextView) view).getText().toString());
                if (MMTagPanel.this.yxu != null) {
                    MMTagPanel.this.a(MMTagPanel.this.yxu.yxN, false, true);
                    AppMethodBeat.o(106820);
                    return;
                }
            } else if (MMTagPanel.this.yxu.yxN == view) {
                MMTagPanel.this.yxu = null;
                MMTagPanel.this.a((TextView) view, false, false);
                if (MMTagPanel.this.yxw != null) {
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(106819);
                            MMTagPanel.this.yxw.JR(((TextView) view).getText().toString());
                            AppMethodBeat.o(106819);
                        }
                    });
                    AppMethodBeat.o(106820);
                    return;
                }
            } else {
                MMTagPanel.this.dAf();
                MMTagPanel.this.yxu = MMTagPanel.a(MMTagPanel.this, ((TextView) view).getText().toString());
                MMTagPanel.this.a(MMTagPanel.this.yxu.yxN, false, true);
            }
            AppMethodBeat.o(106820);
        }
    };
    public boolean yxl = true;
    private boolean yxm = false;
    public boolean yxn = true;
    public boolean yxo = false;
    public boolean yxp = false;
    private int yxq = R.drawable.bik;
    private int yxr = 0;
    private int yxs = R.drawable.a2y;
    private int yxt = R.color.a69;
    private d yxu = null;
    private LinkedList<d> yxv = new LinkedList();
    private a yxw;
    private int yxx;
    private View yxy;
    MMEditText yxz;

    public class b implements InputFilter {
        int mark;
        List<String> yxF = new LinkedList();

        public b() {
            AppMethodBeat.i(106824);
            AppMethodBeat.o(106824);
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.i(106825);
            ab.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(MMTagPanel.this.mjY));
            this.mark = -1;
            this.yxF.clear();
            char[] cArr = new char[(i2 - i)];
            TextUtils.getChars(charSequence, i, i2, cArr, 0);
            String charSequence2;
            if (MMTagPanel.this.yxn) {
                int i5 = i;
                while (i5 < i2) {
                    if (cArr[i5] == 10 || cArr[i5] == ',' || cArr[i5] == ';' || cArr[i5] == 12289 || cArr[i5] == 65292 || cArr[i5] == 65307) {
                        if (-1 == this.mark) {
                            this.yxF.add((spanned.subSequence(0, i3).toString() + charSequence.subSequence(i, i5)).trim());
                        } else {
                            this.yxF.add(charSequence.subSequence(this.mark, i5).toString().trim());
                        }
                        this.mark = i5 + 1;
                    }
                    i5++;
                }
                if (MMTagPanel.this.yxA) {
                    i5 = f.asg(spanned.toString());
                    if (MMTagPanel.this.mjY && charSequence.equals(IOUtils.LINE_SEPARATOR_UNIX) && 36 < i5) {
                        this.yxF.clear();
                    }
                }
                if (this.yxF.isEmpty()) {
                    AppMethodBeat.o(106825);
                    return null;
                }
                if (MMTagPanel.this.yxw != null) {
                    for (final String charSequence22 : this.yxF) {
                        if (charSequence22.length() > 0) {
                            MMTagPanel.this.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(106822);
                                    MMTagPanel.this.yxw.JV(charSequence22.trim());
                                    AppMethodBeat.o(106822);
                                }
                            });
                        }
                    }
                }
                if (this.mark >= i2) {
                    spanned.length();
                    charSequence22 = spanned.subSequence(i4, spanned.length()).toString();
                } else {
                    charSequence22 = charSequence.subSequence(this.mark, i2).toString() + spanned.subSequence(i4, spanned.length());
                }
                MMTagPanel.this.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(106823);
                        MMTagPanel.this.yxz.setText("");
                        MMTagPanel.this.yxz.append(charSequence22);
                        AppMethodBeat.o(106823);
                    }
                });
                CharSequence charSequence3 = "";
                AppMethodBeat.o(106825);
                return charSequence3;
            }
            Object obj = null;
            final StringBuilder stringBuilder = new StringBuilder();
            while (i < i2) {
                if (cArr[i] == 10) {
                    obj = 1;
                } else {
                    stringBuilder.append(cArr[i]);
                }
                i++;
            }
            if (obj != null) {
                charSequence22 = stringBuilder.toString();
                stringBuilder.insert(0, spanned.subSequence(0, i3));
                stringBuilder.append(spanned.subSequence(i4, spanned.length()));
                MMTagPanel.this.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(106821);
                        MMTagPanel.this.yxw.JV(stringBuilder.toString());
                        AppMethodBeat.o(106821);
                    }
                });
                AppMethodBeat.o(106825);
                return charSequence22;
            }
            AppMethodBeat.o(106825);
            return null;
        }
    }

    public class c implements InputFilter {
        int yxI = 36;
        private int yxJ = 256;
        private int yxK;

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.i(106827);
            int asg = f.asg(spanned.toString()) + f.asg(charSequence.toString());
            if (i4 > i3) {
                if (asg - (i4 - i3) > this.yxI) {
                    MMTagPanel.this.mjY = true;
                    this.yxK = (asg - (i4 - i3)) - this.yxI;
                } else {
                    MMTagPanel.this.mjY = false;
                }
            } else if (asg > this.yxI) {
                MMTagPanel.this.mjY = true;
                this.yxK = asg - this.yxI;
            } else {
                MMTagPanel.this.mjY = false;
            }
            if (MMTagPanel.this.yxA && 1 == this.yxK && charSequence.equals(IOUtils.LINE_SEPARATOR_UNIX)) {
                this.yxK = 0;
            }
            if (MMTagPanel.this.yxw != null) {
                MMTagPanel.this.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(106826);
                        MMTagPanel.this.yxw.q(MMTagPanel.this.mjY, f.bP(c.this.yxK, ""));
                        AppMethodBeat.o(106826);
                    }
                });
            }
            if (asg > this.yxJ) {
                String str = "";
                AppMethodBeat.o(106827);
                return str;
            }
            AppMethodBeat.o(106827);
            return charSequence;
        }
    }

    public static final class d {
        public String yxM;
        public TextView yxN;
    }

    public interface a {
        void JR(String str);

        void JS(String str);

        void JT(String str);

        void JU(String str);

        void JV(String str);

        void bmm();

        void q(boolean z, int i);
    }

    public MMTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106828);
        init();
        AppMethodBeat.o(106828);
    }

    public MMTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106829);
        init();
        AppMethodBeat.o(106829);
    }

    /* Access modifiers changed, original: protected */
    public void bwC() {
    }

    private void init() {
        AppMethodBeat.i(106830);
        this.yxx = getContext().getResources().getDimensionPixelSize(R.dimen.kr);
        this.yxy = LayoutInflater.from(getContext()).inflate(R.layout.agp, null);
        this.yxz = (MMEditText) this.yxy.findViewById(R.id.l3);
        this.yxz.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(106810);
                if (keyEvent.getAction() == 0 && 67 == i) {
                    int i2;
                    ab.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", Integer.valueOf(MMTagPanel.this.yxz.getSelectionStart()), Integer.valueOf(MMTagPanel.this.yxz.getSelectionEnd()));
                    if (MMTagPanel.this.yxz.getSelectionStart() == 0 && MMTagPanel.this.yxz.getSelectionStart() == MMTagPanel.this.yxz.getSelectionEnd()) {
                        i2 = 1;
                    } else {
                        boolean i22 = false;
                    }
                    if (i22 == 0) {
                        AppMethodBeat.o(106810);
                    } else {
                        MMTagPanel.this.bwC();
                        if (MMTagPanel.this.wiH == null || MMTagPanel.this.wiH.isEmpty()) {
                            AppMethodBeat.o(106810);
                        } else if (!MMTagPanel.this.yxo && MMTagPanel.this.yxu == null) {
                            MMTagPanel.this.yxu = (d) MMTagPanel.this.wiH.getLast();
                            MMTagPanel.this.a(MMTagPanel.this.yxu.yxN, false, true);
                            MMTagPanel.this.yxz.setCursorVisible(false);
                        } else if (MMTagPanel.this.yxu == null || MMTagPanel.this.wiH == null || MMTagPanel.this.wiH.getLast() == null || bo.isNullOrNil(MMTagPanel.this.yxu.yxM) || bo.isNullOrNil(((d) MMTagPanel.this.wiH.getLast()).yxM) || MMTagPanel.this.yxu.yxM.equals(((d) MMTagPanel.this.wiH.getLast()).yxM)) {
                            String str = ((d) MMTagPanel.this.wiH.getLast()).yxM;
                            MMTagPanel.this.removeTag(str);
                            if (MMTagPanel.this.yxw != null) {
                                MMTagPanel.this.yxw.JT(str);
                            }
                            MMTagPanel.this.dAf();
                        } else {
                            ab.i("MicroMsg.MMTagPanel", "change hight");
                            MMTagPanel.this.dAf();
                            MMTagPanel.this.yxu = (d) MMTagPanel.this.wiH.getLast();
                            MMTagPanel.this.a(MMTagPanel.this.yxu.yxN, false, true);
                            MMTagPanel.this.yxz.setCursorVisible(false);
                        }
                    }
                    return false;
                }
                AppMethodBeat.o(106810);
                return false;
            }
        });
        this.yxz.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(106811);
                String obj = editable.toString();
                if (MMTagPanel.this.yxw != null) {
                    MMTagPanel.this.yxw.JU(obj);
                }
                if (obj.length() > 0) {
                    MMTagPanel.this.dAf();
                }
                AppMethodBeat.o(106811);
            }
        });
        this.yxz.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(106812);
                ab.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", Boolean.valueOf(z));
                if (z && MMTagPanel.this.yxw != null) {
                    MMTagPanel.this.yxw.bmm();
                }
                AppMethodBeat.o(106812);
            }
        });
        this.yxz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(106813);
                ab.d("MicroMsg.MMTagPanel", "on edittext click");
                MMTagPanel.this.dAf();
                if (MMTagPanel.this.yxw != null) {
                    MMTagPanel.this.yxw.bmm();
                }
                AppMethodBeat.o(106813);
            }
        });
        this.yxz.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(106814);
                ab.d("MicroMsg.MMTagPanel", "on action %d, %s", Integer.valueOf(i), keyEvent);
                AppMethodBeat.o(106814);
                return false;
            }
        });
        final c cVar = new c();
        b bVar = new b();
        this.yxz.setFilters(new InputFilter[]{cVar, bVar});
        dAd();
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(106815);
                ab.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", Boolean.valueOf(MMTagPanel.this.yxm));
                if (MMTagPanel.this.yxm) {
                    MMTagPanel.this.dAf();
                    MMTagPanel.this.yxz.requestFocus();
                    MMTagPanel.this.yxz.setSelection(MMTagPanel.this.yxz.getText().length());
                    ((InputMethodManager) MMTagPanel.this.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.this.yxz, 0);
                    ab.d("MicroMsg.MMTagPanel", "on content click");
                    if (MMTagPanel.this.yxw != null) {
                        MMTagPanel.this.yxw.bmm();
                    }
                }
                AppMethodBeat.o(106815);
            }
        });
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(106816);
                if (MMTagPanel.this.yxp) {
                    String editText = MMTagPanel.this.getEditText();
                    if (!bo.isNullOrNil(editText)) {
                        if (cVar != null && f.asg(editText) > cVar.yxI) {
                            int asi = cVar.yxI - f.asi(editText);
                            if (asi <= editText.length()) {
                                editText = editText.substring(0, asi);
                            }
                        }
                        MMTagPanel.this.cc(editText, true);
                        if (MMTagPanel.this.yxw != null) {
                            MMTagPanel.this.yxw.JV(editText);
                        }
                        MMTagPanel.this.dAb();
                    }
                }
                AppMethodBeat.o(106816);
                return false;
            }
        });
        AppMethodBeat.o(106830);
    }

    public void setTagEditTextBG(int i) {
        AppMethodBeat.i(106831);
        this.yxr = i;
        if (this.yxz != null) {
            com.tencent.mm.bz.a.fromDPToPix(getContext(), 6);
            getResources().getDimensionPixelSize(R.dimen.m4);
            this.yxz.setBackgroundResource(this.yxr);
        }
        AppMethodBeat.o(106831);
    }

    public void setTagTipsDrawable(int i) {
        this.yxq = i;
    }

    public void setTagNormalBG(int i) {
        this.mlu = i;
    }

    public void setTagNormalTextColorRes(int i) {
        this.mlt = i;
    }

    public void setTagSelectedBG(int i) {
        this.nCZ = i;
    }

    public void setTagSelectedTextColorRes(int i) {
        this.nDa = i;
    }

    public void setTagHighlineBG(int i) {
        this.yxs = i;
    }

    public void setTaghighlineTextColorRes(int i) {
        this.yxt = i;
    }

    public void setEditTextColor(int i) {
        AppMethodBeat.i(106832);
        if (this.yxz != null) {
            this.yxz.setTextColor(i);
        }
        AppMethodBeat.o(106832);
    }

    public void setEditHint(String str) {
        AppMethodBeat.i(106833);
        if (this.yxz != null) {
            this.yxz.setHint(str);
        }
        AppMethodBeat.o(106833);
    }

    public String getEditText() {
        AppMethodBeat.i(106834);
        String obj;
        if (this.yxz != null) {
            obj = this.yxz.getText().toString();
            AppMethodBeat.o(106834);
            return obj;
        }
        obj = "";
        AppMethodBeat.o(106834);
        return obj;
    }

    public final void dAb() {
        AppMethodBeat.i(106835);
        if (this.yxz != null) {
            this.yxz.setText("");
        }
        AppMethodBeat.o(106835);
    }

    public final void dAc() {
        AppMethodBeat.i(106836);
        if (this.yxz == null || this.yxz.isFocused()) {
            AppMethodBeat.o(106836);
            return;
        }
        this.yxz.requestFocus();
        AppMethodBeat.o(106836);
    }

    public final void dAd() {
        AppMethodBeat.i(106837);
        if (this.yxz != null && this.yxz.isFocused()) {
            ab.d("MicroMsg.MMTagPanel", "do clear edit focus");
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager == null) {
                AppMethodBeat.o(106837);
                return;
            }
            IBinder windowToken = this.yxz.getWindowToken();
            if (windowToken == null) {
                AppMethodBeat.o(106837);
                return;
            } else {
                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                this.yxz.clearFocus();
            }
        }
        AppMethodBeat.o(106837);
    }

    public final void qe(boolean z) {
        AppMethodBeat.i(106838);
        if (z == this.yxm) {
            AppMethodBeat.o(106838);
            return;
        }
        this.yxm = z;
        removeView(this.yxy);
        if (this.yxm) {
            addView(this.yxy);
            dAd();
        }
        AppMethodBeat.o(106838);
    }

    public void setCallBack(a aVar) {
        this.yxw = aVar;
    }

    public Set<String> getTagSet() {
        AppMethodBeat.i(106839);
        TreeSet treeSet = new TreeSet();
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!bo.isNullOrNil(dVar.yxM)) {
                treeSet.add(dVar.yxM);
            }
        }
        AppMethodBeat.o(106839);
        return treeSet;
    }

    public ArrayList<String> getTagList() {
        AppMethodBeat.i(106840);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!bo.isNullOrNil(dVar.yxM)) {
                arrayList.add(dVar.yxM);
            }
        }
        AppMethodBeat.o(106840);
        return arrayList;
    }

    public int getTagCount() {
        AppMethodBeat.i(106841);
        int size = this.wiH.size();
        AppMethodBeat.o(106841);
        return size;
    }

    public void dzU() {
        AppMethodBeat.i(106842);
        this.wiH.clear();
        removeAllViews();
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            a((d) it.next());
        }
        AppMethodBeat.o(106842);
    }

    public final void a(Collection<String> collection, List<String> list) {
        AppMethodBeat.i(106843);
        dzU();
        if (this.yxm) {
            addView(this.yxy);
        }
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(106843);
            return;
        }
        for (String str : list) {
            cc(str, collection == null ? false : collection.contains(str));
        }
        AppMethodBeat.o(106843);
    }

    /* Access modifiers changed, original: protected|final */
    public final d dAe() {
        AppMethodBeat.i(106844);
        if (this.yxv.isEmpty()) {
            d dVar = new d();
            TextView textView = new TextView(getContext());
            textView.setBackgroundResource(this.mlu);
            textView.setTextColor(getResources().getColor(this.mlt));
            textView.setTag(Integer.valueOf(0));
            textView.setGravity(17);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.yxq, 0);
            textView.setOnClickListener(this.yxl ? this.yxB : null);
            textView.setEllipsize(TruncateAt.END);
            textView.setSingleLine();
            dVar.yxN = textView;
            AppMethodBeat.o(106844);
            return dVar;
        }
        d dVar2 = (d) this.yxv.removeFirst();
        AppMethodBeat.o(106844);
        return dVar2;
    }

    private void a(d dVar) {
        AppMethodBeat.i(106845);
        dVar.yxN.setOnClickListener(null);
        if (this.yxv.size() >= 16) {
            AppMethodBeat.o(106845);
            return;
        }
        this.yxv.add(dVar);
        AppMethodBeat.o(106845);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(d dVar, String str, boolean z) {
        AppMethodBeat.i(106846);
        dVar.yxM = str;
        dVar.yxN.setText(com.tencent.mm.ui.e.c.b.h(getContext(), str, this.yxx));
        dVar.yxN.setOnClickListener(this.yxl ? this.yxB : null);
        a(dVar.yxN, z, false);
        AppMethodBeat.o(106846);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dAf() {
        AppMethodBeat.i(106847);
        if (this.yxz != null) {
            ab.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", Boolean.valueOf(this.yxz.isFocused()));
            this.yxz.setCursorVisible(true);
        }
        if (this.yxu == null) {
            AppMethodBeat.o(106847);
            return;
        }
        boolean z;
        TextView textView = this.yxu.yxN;
        if (((Integer) this.yxu.yxN.getTag()).intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        a(textView, z, false);
        this.yxu = null;
        AppMethodBeat.o(106847);
    }

    public final void a(TextView textView, boolean z, boolean z2) {
        AppMethodBeat.i(106848);
        textView.setTextSize(0, getContext().getResources().getDimension(R.dimen.kr) * com.tencent.mm.bz.a.dm(getContext()));
        if (z2) {
            textView.setBackgroundResource(this.yxs);
            textView.setTextColor(getResources().getColor(this.yxt));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.yxq, 0);
            AppMethodBeat.o(106848);
        } else if (z) {
            textView.setTag(Integer.valueOf(1));
            textView.setBackgroundResource(this.nCZ);
            textView.setTextColor(getResources().getColor(this.nDa));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            AppMethodBeat.o(106848);
        } else {
            textView.setTag(Integer.valueOf(0));
            textView.setBackgroundResource(this.mlu);
            textView.setTextColor(getResources().getColor(this.mlt));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            AppMethodBeat.o(106848);
        }
    }

    public final void cc(String str, boolean z) {
        AppMethodBeat.i(106849);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
            AppMethodBeat.o(106849);
            return;
        }
        String trim = str.trim();
        ab.d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", trim);
        removeTag(trim);
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            if (trim.equals(((d) it.next()).yxM)) {
                ab.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", trim);
                AppMethodBeat.o(106849);
                return;
            }
        }
        d dAe = dAe();
        a(dAe, trim, z);
        this.wiH.add(dAe);
        if (this.yxm) {
            addView(dAe.yxN, getChildCount() - 1);
        } else {
            addView(dAe.yxN);
        }
        dAf();
        AppMethodBeat.o(106849);
    }

    public final void removeTag(String str) {
        AppMethodBeat.i(106850);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
            AppMethodBeat.o(106850);
            return;
        }
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.yxM)) {
                this.wiH.remove(dVar);
                removeView(dVar.yxN);
                a(dVar);
                dAf();
                AppMethodBeat.o(106850);
                return;
            }
        }
        ab.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", str);
        AppMethodBeat.o(106850);
    }

    public final void dAg() {
        AppMethodBeat.i(106851);
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            removeView(dVar.yxN);
            a(dVar);
        }
        this.wiH.clear();
        dAf();
        AppMethodBeat.o(106851);
    }

    public final void cd(String str, boolean z) {
        AppMethodBeat.i(106852);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
            AppMethodBeat.o(106852);
            return;
        }
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.yxM)) {
                a(dVar, str, z);
                dAf();
                AppMethodBeat.o(106852);
                return;
            }
        }
        ab.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", str);
        AppMethodBeat.o(106852);
    }

    public void setPanelClickable(boolean z) {
        this.mXt = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(106853);
        if (this.mXt) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(106853);
            return onInterceptTouchEvent;
        }
        AppMethodBeat.o(106853);
        return true;
    }

    public void setEditTextHit(boolean z) {
        AppMethodBeat.i(106854);
        if (this.yxz != null) {
            if (z) {
                this.yxz.setHint(R.string.d2);
                AppMethodBeat.o(106854);
                return;
            }
            this.yxz.setHint("");
        }
        AppMethodBeat.o(106854);
    }

    public void setIsAllowEnterCharacter(boolean z) {
        this.yxA = z;
    }
}
