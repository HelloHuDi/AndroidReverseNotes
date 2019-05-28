package com.tencent.p177mm.p612ui.base;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.p627e.p628c.C5509b;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: com.tencent.mm.ui.base.MMTagPanel */
public class MMTagPanel extends FlowLayout {
    public boolean mXt = true;
    private boolean mjY = false;
    private int mlt = C25738R.color.f12212w4;
    private int mlu = C25738R.drawable.a31;
    private int nCZ = C25738R.drawable.a2v;
    private int nDa = C25738R.color.a61;
    private LinkedList<C44270d> wiH = new LinkedList();
    private boolean yxA = false;
    private OnClickListener yxB = new C442668();
    public boolean yxl = true;
    private boolean yxm = false;
    public boolean yxn = true;
    public boolean yxo = false;
    public boolean yxp = false;
    private int yxq = C25738R.drawable.bik;
    private int yxr = 0;
    private int yxs = C25738R.drawable.a2y;
    private int yxt = C25738R.color.a69;
    private C44270d yxu = null;
    private LinkedList<C44270d> yxv = new LinkedList();
    private C44799a yxw;
    private int yxx;
    private View yxy;
    MMEditText yxz;

    /* renamed from: com.tencent.mm.ui.base.MMTagPanel$3 */
    class C52643 implements OnFocusChangeListener {
        C52643() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(106812);
            C4990ab.m7411d("MicroMsg.MMTagPanel", "on edittext focus changed %B", Boolean.valueOf(z));
            if (z && MMTagPanel.this.yxw != null) {
                MMTagPanel.this.yxw.bmm();
            }
            AppMethodBeat.m2505o(106812);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMTagPanel$2 */
    class C155222 implements TextWatcher {
        C155222() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(106811);
            String obj = editable.toString();
            if (MMTagPanel.this.yxw != null) {
                MMTagPanel.this.yxw.mo23725JU(obj);
            }
            if (obj.length() > 0) {
                MMTagPanel.this.dAf();
            }
            AppMethodBeat.m2505o(106811);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMTagPanel$5 */
    class C155235 implements OnEditorActionListener {
        C155235() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(106814);
            C4990ab.m7411d("MicroMsg.MMTagPanel", "on action %d, %s", Integer.valueOf(i), keyEvent);
            AppMethodBeat.m2505o(106814);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMTagPanel$4 */
    class C303724 implements OnClickListener {
        C303724() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(106813);
            C4990ab.m7410d("MicroMsg.MMTagPanel", "on edittext click");
            MMTagPanel.this.dAf();
            if (MMTagPanel.this.yxw != null) {
                MMTagPanel.this.yxw.bmm();
            }
            AppMethodBeat.m2505o(106813);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMTagPanel$1 */
    class C360611 implements OnKeyListener {
        C360611() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(106810);
            if (keyEvent.getAction() == 0 && 67 == i) {
                int i2;
                C4990ab.m7411d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", Integer.valueOf(MMTagPanel.this.yxz.getSelectionStart()), Integer.valueOf(MMTagPanel.this.yxz.getSelectionEnd()));
                if (MMTagPanel.this.yxz.getSelectionStart() == 0 && MMTagPanel.this.yxz.getSelectionStart() == MMTagPanel.this.yxz.getSelectionEnd()) {
                    i2 = 1;
                } else {
                    boolean i22 = false;
                }
                if (i22 == 0) {
                    AppMethodBeat.m2505o(106810);
                } else {
                    MMTagPanel.this.bwC();
                    if (MMTagPanel.this.wiH == null || MMTagPanel.this.wiH.isEmpty()) {
                        AppMethodBeat.m2505o(106810);
                    } else if (!MMTagPanel.this.yxo && MMTagPanel.this.yxu == null) {
                        MMTagPanel.this.yxu = (C44270d) MMTagPanel.this.wiH.getLast();
                        MMTagPanel.this.mo71948a(MMTagPanel.this.yxu.yxN, false, true);
                        MMTagPanel.this.yxz.setCursorVisible(false);
                    } else if (MMTagPanel.this.yxu == null || MMTagPanel.this.wiH == null || MMTagPanel.this.wiH.getLast() == null || C5046bo.isNullOrNil(MMTagPanel.this.yxu.yxM) || C5046bo.isNullOrNil(((C44270d) MMTagPanel.this.wiH.getLast()).yxM) || MMTagPanel.this.yxu.yxM.equals(((C44270d) MMTagPanel.this.wiH.getLast()).yxM)) {
                        String str = ((C44270d) MMTagPanel.this.wiH.getLast()).yxM;
                        MMTagPanel.this.removeTag(str);
                        if (MMTagPanel.this.yxw != null) {
                            MMTagPanel.this.yxw.mo23724JT(str);
                        }
                        MMTagPanel.this.dAf();
                    } else {
                        C4990ab.m7416i("MicroMsg.MMTagPanel", "change hight");
                        MMTagPanel.this.dAf();
                        MMTagPanel.this.yxu = (C44270d) MMTagPanel.this.wiH.getLast();
                        MMTagPanel.this.mo71948a(MMTagPanel.this.yxu.yxN, false, true);
                        MMTagPanel.this.yxz.setCursorVisible(false);
                    }
                }
                return false;
            }
            AppMethodBeat.m2505o(106810);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMTagPanel$8 */
    class C442668 implements OnClickListener {
        C442668() {
        }

        public final void onClick(final View view) {
            AppMethodBeat.m2504i(106820);
            if (((Integer) view.getTag()).intValue() == 0) {
                MMTagPanel.this.mo71948a((TextView) view, true, false);
                if (MMTagPanel.this.yxw != null) {
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(106817);
                            MMTagPanel.this.yxw.mo23723JS(((TextView) view).getText().toString());
                            AppMethodBeat.m2505o(106817);
                        }
                    });
                    AppMethodBeat.m2505o(106820);
                    return;
                }
            } else if (!MMTagPanel.this.yxm || MMTagPanel.this.yxo) {
                MMTagPanel.this.mo71948a((TextView) view, false, false);
                if (MMTagPanel.this.yxw != null) {
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(106818);
                            MMTagPanel.this.yxw.mo23722JR(((TextView) view).getText().toString());
                            AppMethodBeat.m2505o(106818);
                        }
                    });
                    AppMethodBeat.m2505o(106820);
                    return;
                }
            } else if (MMTagPanel.this.yxu == null) {
                MMTagPanel.this.yxu = MMTagPanel.m81864a(MMTagPanel.this, ((TextView) view).getText().toString());
                if (MMTagPanel.this.yxu != null) {
                    MMTagPanel.this.mo71948a(MMTagPanel.this.yxu.yxN, false, true);
                    AppMethodBeat.m2505o(106820);
                    return;
                }
            } else if (MMTagPanel.this.yxu.yxN == view) {
                MMTagPanel.this.yxu = null;
                MMTagPanel.this.mo71948a((TextView) view, false, false);
                if (MMTagPanel.this.yxw != null) {
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(106819);
                            MMTagPanel.this.yxw.mo23722JR(((TextView) view).getText().toString());
                            AppMethodBeat.m2505o(106819);
                        }
                    });
                    AppMethodBeat.m2505o(106820);
                    return;
                }
            } else {
                MMTagPanel.this.dAf();
                MMTagPanel.this.yxu = MMTagPanel.m81864a(MMTagPanel.this, ((TextView) view).getText().toString());
                MMTagPanel.this.mo71948a(MMTagPanel.this.yxu.yxN, false, true);
            }
            AppMethodBeat.m2505o(106820);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMTagPanel$b */
    public class C44268b implements InputFilter {
        int mark;
        List<String> yxF = new LinkedList();

        public C44268b() {
            AppMethodBeat.m2504i(106824);
            AppMethodBeat.m2505o(106824);
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.m2504i(106825);
            C4990ab.m7411d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(MMTagPanel.this.mjY));
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
                    i5 = C5584f.asg(spanned.toString());
                    if (MMTagPanel.this.mjY && charSequence.equals(IOUtils.LINE_SEPARATOR_UNIX) && 36 < i5) {
                        this.yxF.clear();
                    }
                }
                if (this.yxF.isEmpty()) {
                    AppMethodBeat.m2505o(106825);
                    return null;
                }
                if (MMTagPanel.this.yxw != null) {
                    for (final String charSequence22 : this.yxF) {
                        if (charSequence22.length() > 0) {
                            MMTagPanel.this.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(106822);
                                    MMTagPanel.this.yxw.mo23726JV(charSequence22.trim());
                                    AppMethodBeat.m2505o(106822);
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
                        AppMethodBeat.m2504i(106823);
                        MMTagPanel.this.yxz.setText("");
                        MMTagPanel.this.yxz.append(charSequence22);
                        AppMethodBeat.m2505o(106823);
                    }
                });
                CharSequence charSequence3 = "";
                AppMethodBeat.m2505o(106825);
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
                        AppMethodBeat.m2504i(106821);
                        MMTagPanel.this.yxw.mo23726JV(stringBuilder.toString());
                        AppMethodBeat.m2505o(106821);
                    }
                });
                AppMethodBeat.m2505o(106825);
                return charSequence22;
            }
            AppMethodBeat.m2505o(106825);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMTagPanel$c */
    public class C44269c implements InputFilter {
        int yxI = 36;
        private int yxJ = 256;
        private int yxK;

        /* renamed from: com.tencent.mm.ui.base.MMTagPanel$c$1 */
        class C155241 implements Runnable {
            C155241() {
            }

            public final void run() {
                AppMethodBeat.m2504i(106826);
                MMTagPanel.this.yxw.mo23728q(MMTagPanel.this.mjY, C5584f.m8385bP(C44269c.this.yxK, ""));
                AppMethodBeat.m2505o(106826);
            }
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.m2504i(106827);
            int asg = C5584f.asg(spanned.toString()) + C5584f.asg(charSequence.toString());
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
                MMTagPanel.this.post(new C155241());
            }
            if (asg > this.yxJ) {
                String str = "";
                AppMethodBeat.m2505o(106827);
                return str;
            }
            AppMethodBeat.m2505o(106827);
            return charSequence;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMTagPanel$d */
    public static final class C44270d {
        public String yxM;
        public TextView yxN;
    }

    /* renamed from: com.tencent.mm.ui.base.MMTagPanel$6 */
    class C447986 implements OnClickListener {
        C447986() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(106815);
            C4990ab.m7411d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", Boolean.valueOf(MMTagPanel.this.yxm));
            if (MMTagPanel.this.yxm) {
                MMTagPanel.this.dAf();
                MMTagPanel.this.yxz.requestFocus();
                MMTagPanel.this.yxz.setSelection(MMTagPanel.this.yxz.getText().length());
                ((InputMethodManager) MMTagPanel.this.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.this.yxz, 0);
                C4990ab.m7410d("MicroMsg.MMTagPanel", "on content click");
                if (MMTagPanel.this.yxw != null) {
                    MMTagPanel.this.yxw.bmm();
                }
            }
            AppMethodBeat.m2505o(106815);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMTagPanel$a */
    public interface C44799a {
        /* renamed from: JR */
        void mo23722JR(String str);

        /* renamed from: JS */
        void mo23723JS(String str);

        /* renamed from: JT */
        void mo23724JT(String str);

        /* renamed from: JU */
        void mo23725JU(String str);

        /* renamed from: JV */
        void mo23726JV(String str);

        void bmm();

        /* renamed from: q */
        void mo23728q(boolean z, int i);
    }

    public MMTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106828);
        init();
        AppMethodBeat.m2505o(106828);
    }

    public MMTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106829);
        init();
        AppMethodBeat.m2505o(106829);
    }

    /* Access modifiers changed, original: protected */
    public void bwC() {
    }

    private void init() {
        AppMethodBeat.m2504i(106830);
        this.yxx = getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9936kr);
        this.yxy = LayoutInflater.from(getContext()).inflate(2130970223, null);
        this.yxz = (MMEditText) this.yxy.findViewById(2131820980);
        this.yxz.setOnKeyListener(new C360611());
        this.yxz.addTextChangedListener(new C155222());
        this.yxz.setOnFocusChangeListener(new C52643());
        this.yxz.setOnClickListener(new C303724());
        this.yxz.setOnEditorActionListener(new C155235());
        final C44269c c44269c = new C44269c();
        C44268b c44268b = new C44268b();
        this.yxz.setFilters(new InputFilter[]{c44269c, c44268b});
        dAd();
        setOnClickListener(new C447986());
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(106816);
                if (MMTagPanel.this.yxp) {
                    String editText = MMTagPanel.this.getEditText();
                    if (!C5046bo.isNullOrNil(editText)) {
                        if (c44269c != null && C5584f.asg(editText) > c44269c.yxI) {
                            int asi = c44269c.yxI - C5584f.asi(editText);
                            if (asi <= editText.length()) {
                                editText = editText.substring(0, asi);
                            }
                        }
                        MMTagPanel.this.mo71951cc(editText, true);
                        if (MMTagPanel.this.yxw != null) {
                            MMTagPanel.this.yxw.mo23726JV(editText);
                        }
                        MMTagPanel.this.dAb();
                    }
                }
                AppMethodBeat.m2505o(106816);
                return false;
            }
        });
        AppMethodBeat.m2505o(106830);
    }

    public void setTagEditTextBG(int i) {
        AppMethodBeat.m2504i(106831);
        this.yxr = i;
        if (this.yxz != null) {
            C1338a.fromDPToPix(getContext(), 6);
            getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
            this.yxz.setBackgroundResource(this.yxr);
        }
        AppMethodBeat.m2505o(106831);
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
        AppMethodBeat.m2504i(106832);
        if (this.yxz != null) {
            this.yxz.setTextColor(i);
        }
        AppMethodBeat.m2505o(106832);
    }

    public void setEditHint(String str) {
        AppMethodBeat.m2504i(106833);
        if (this.yxz != null) {
            this.yxz.setHint(str);
        }
        AppMethodBeat.m2505o(106833);
    }

    public String getEditText() {
        AppMethodBeat.m2504i(106834);
        String obj;
        if (this.yxz != null) {
            obj = this.yxz.getText().toString();
            AppMethodBeat.m2505o(106834);
            return obj;
        }
        obj = "";
        AppMethodBeat.m2505o(106834);
        return obj;
    }

    public final void dAb() {
        AppMethodBeat.m2504i(106835);
        if (this.yxz != null) {
            this.yxz.setText("");
        }
        AppMethodBeat.m2505o(106835);
    }

    public final void dAc() {
        AppMethodBeat.m2504i(106836);
        if (this.yxz == null || this.yxz.isFocused()) {
            AppMethodBeat.m2505o(106836);
            return;
        }
        this.yxz.requestFocus();
        AppMethodBeat.m2505o(106836);
    }

    public final void dAd() {
        AppMethodBeat.m2504i(106837);
        if (this.yxz != null && this.yxz.isFocused()) {
            C4990ab.m7410d("MicroMsg.MMTagPanel", "do clear edit focus");
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager == null) {
                AppMethodBeat.m2505o(106837);
                return;
            }
            IBinder windowToken = this.yxz.getWindowToken();
            if (windowToken == null) {
                AppMethodBeat.m2505o(106837);
                return;
            } else {
                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                this.yxz.clearFocus();
            }
        }
        AppMethodBeat.m2505o(106837);
    }

    /* renamed from: qe */
    public final void mo71963qe(boolean z) {
        AppMethodBeat.m2504i(106838);
        if (z == this.yxm) {
            AppMethodBeat.m2505o(106838);
            return;
        }
        this.yxm = z;
        removeView(this.yxy);
        if (this.yxm) {
            addView(this.yxy);
            dAd();
        }
        AppMethodBeat.m2505o(106838);
    }

    public void setCallBack(C44799a c44799a) {
        this.yxw = c44799a;
    }

    public Set<String> getTagSet() {
        AppMethodBeat.m2504i(106839);
        TreeSet treeSet = new TreeSet();
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            C44270d c44270d = (C44270d) it.next();
            if (!C5046bo.isNullOrNil(c44270d.yxM)) {
                treeSet.add(c44270d.yxM);
            }
        }
        AppMethodBeat.m2505o(106839);
        return treeSet;
    }

    public ArrayList<String> getTagList() {
        AppMethodBeat.m2504i(106840);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            C44270d c44270d = (C44270d) it.next();
            if (!C5046bo.isNullOrNil(c44270d.yxM)) {
                arrayList.add(c44270d.yxM);
            }
        }
        AppMethodBeat.m2505o(106840);
        return arrayList;
    }

    public int getTagCount() {
        AppMethodBeat.m2504i(106841);
        int size = this.wiH.size();
        AppMethodBeat.m2505o(106841);
        return size;
    }

    public void dzU() {
        AppMethodBeat.m2504i(106842);
        this.wiH.clear();
        removeAllViews();
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            m81866a((C44270d) it.next());
        }
        AppMethodBeat.m2505o(106842);
    }

    /* renamed from: a */
    public final void mo71950a(Collection<String> collection, List<String> list) {
        AppMethodBeat.m2504i(106843);
        dzU();
        if (this.yxm) {
            addView(this.yxy);
        }
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(106843);
            return;
        }
        for (String str : list) {
            mo71951cc(str, collection == null ? false : collection.contains(str));
        }
        AppMethodBeat.m2505o(106843);
    }

    /* Access modifiers changed, original: protected|final */
    public final C44270d dAe() {
        AppMethodBeat.m2504i(106844);
        if (this.yxv.isEmpty()) {
            C44270d c44270d = new C44270d();
            TextView textView = new TextView(getContext());
            textView.setBackgroundResource(this.mlu);
            textView.setTextColor(getResources().getColor(this.mlt));
            textView.setTag(Integer.valueOf(0));
            textView.setGravity(17);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.yxq, 0);
            textView.setOnClickListener(this.yxl ? this.yxB : null);
            textView.setEllipsize(TruncateAt.END);
            textView.setSingleLine();
            c44270d.yxN = textView;
            AppMethodBeat.m2505o(106844);
            return c44270d;
        }
        C44270d c44270d2 = (C44270d) this.yxv.removeFirst();
        AppMethodBeat.m2505o(106844);
        return c44270d2;
    }

    /* renamed from: a */
    private void m81866a(C44270d c44270d) {
        AppMethodBeat.m2504i(106845);
        c44270d.yxN.setOnClickListener(null);
        if (this.yxv.size() >= 16) {
            AppMethodBeat.m2505o(106845);
            return;
        }
        this.yxv.add(c44270d);
        AppMethodBeat.m2505o(106845);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo71949a(C44270d c44270d, String str, boolean z) {
        AppMethodBeat.m2504i(106846);
        c44270d.yxM = str;
        c44270d.yxN.setText(C5509b.m8296h(getContext(), str, this.yxx));
        c44270d.yxN.setOnClickListener(this.yxl ? this.yxB : null);
        mo71948a(c44270d.yxN, z, false);
        AppMethodBeat.m2505o(106846);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dAf() {
        AppMethodBeat.m2504i(106847);
        if (this.yxz != null) {
            C4990ab.m7411d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", Boolean.valueOf(this.yxz.isFocused()));
            this.yxz.setCursorVisible(true);
        }
        if (this.yxu == null) {
            AppMethodBeat.m2505o(106847);
            return;
        }
        boolean z;
        TextView textView = this.yxu.yxN;
        if (((Integer) this.yxu.yxN.getTag()).intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        mo71948a(textView, z, false);
        this.yxu = null;
        AppMethodBeat.m2505o(106847);
    }

    /* renamed from: a */
    public final void mo71948a(TextView textView, boolean z, boolean z2) {
        AppMethodBeat.m2504i(106848);
        textView.setTextSize(0, getContext().getResources().getDimension(C25738R.dimen.f9936kr) * C1338a.m2860dm(getContext()));
        if (z2) {
            textView.setBackgroundResource(this.yxs);
            textView.setTextColor(getResources().getColor(this.yxt));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.yxq, 0);
            AppMethodBeat.m2505o(106848);
        } else if (z) {
            textView.setTag(Integer.valueOf(1));
            textView.setBackgroundResource(this.nCZ);
            textView.setTextColor(getResources().getColor(this.nDa));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            AppMethodBeat.m2505o(106848);
        } else {
            textView.setTag(Integer.valueOf(0));
            textView.setBackgroundResource(this.mlu);
            textView.setTextColor(getResources().getColor(this.mlt));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            AppMethodBeat.m2505o(106848);
        }
    }

    /* renamed from: cc */
    public final void mo71951cc(String str, boolean z) {
        AppMethodBeat.m2504i(106849);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
            AppMethodBeat.m2505o(106849);
            return;
        }
        String trim = str.trim();
        C4990ab.m7411d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", trim);
        removeTag(trim);
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            if (trim.equals(((C44270d) it.next()).yxM)) {
                C4990ab.m7421w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", trim);
                AppMethodBeat.m2505o(106849);
                return;
            }
        }
        C44270d dAe = dAe();
        mo71949a(dAe, trim, z);
        this.wiH.add(dAe);
        if (this.yxm) {
            addView(dAe.yxN, getChildCount() - 1);
        } else {
            addView(dAe.yxN);
        }
        dAf();
        AppMethodBeat.m2505o(106849);
    }

    public final void removeTag(String str) {
        AppMethodBeat.m2504i(106850);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
            AppMethodBeat.m2505o(106850);
            return;
        }
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            C44270d c44270d = (C44270d) it.next();
            if (str.equals(c44270d.yxM)) {
                this.wiH.remove(c44270d);
                removeView(c44270d.yxN);
                m81866a(c44270d);
                dAf();
                AppMethodBeat.m2505o(106850);
                return;
            }
        }
        C4990ab.m7421w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", str);
        AppMethodBeat.m2505o(106850);
    }

    public final void dAg() {
        AppMethodBeat.m2504i(106851);
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            C44270d c44270d = (C44270d) it.next();
            removeView(c44270d.yxN);
            m81866a(c44270d);
        }
        this.wiH.clear();
        dAf();
        AppMethodBeat.m2505o(106851);
    }

    /* renamed from: cd */
    public final void mo71952cd(String str, boolean z) {
        AppMethodBeat.m2504i(106852);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
            AppMethodBeat.m2505o(106852);
            return;
        }
        Iterator it = this.wiH.iterator();
        while (it.hasNext()) {
            C44270d c44270d = (C44270d) it.next();
            if (str.equals(c44270d.yxM)) {
                mo71949a(c44270d, str, z);
                dAf();
                AppMethodBeat.m2505o(106852);
                return;
            }
        }
        C4990ab.m7421w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", str);
        AppMethodBeat.m2505o(106852);
    }

    public void setPanelClickable(boolean z) {
        this.mXt = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106853);
        if (this.mXt) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.m2505o(106853);
            return onInterceptTouchEvent;
        }
        AppMethodBeat.m2505o(106853);
        return true;
    }

    public void setEditTextHit(boolean z) {
        AppMethodBeat.m2504i(106854);
        if (this.yxz != null) {
            if (z) {
                this.yxz.setHint(C25738R.string.f8718d2);
                AppMethodBeat.m2505o(106854);
                return;
            }
            this.yxz.setHint("");
        }
        AppMethodBeat.m2505o(106854);
    }

    public void setIsAllowEnterCharacter(boolean z) {
        this.yxA = z;
    }
}
