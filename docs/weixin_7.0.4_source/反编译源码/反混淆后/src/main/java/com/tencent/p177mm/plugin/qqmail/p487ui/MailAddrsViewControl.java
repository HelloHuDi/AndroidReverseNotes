package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.content.Context;
import android.content.Intent;
import android.support.p057v4.widget.C8415j;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.qqmail.p486b.C12884ac;
import com.tencent.p177mm.plugin.qqmail.p486b.C43404o;
import com.tencent.p177mm.plugin.qqmail.p486b.C46149p;
import com.tencent.p177mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl */
public class MailAddrsViewControl extends RelativeLayout {
    private static final Pattern pyE = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    private boolean gJL = false;
    private C7306ak handler = new C7306ak();
    private GestureDetector pxH;
    private C3661b pyA;
    private C3664c pyB;
    private View pyC;
    private C12919a pyD = null;
    private SimpleOnGestureListener pyF = new C129188();
    private LinkedList<C43404o> pyy = new LinkedList();
    AutoCompleteTextView pyz;

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$6 */
    class C36606 implements TextWatcher {
        C36606() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(68343);
            String charSequence2 = charSequence.toString();
            if (charSequence2.endsWith(IOUtils.LINE_SEPARATOR_UNIX) || charSequence2.endsWith(" ")) {
                MailAddrsViewControl.m57075a(MailAddrsViewControl.this, charSequence2, true);
            }
            MailAddrsViewControl.this.cdj();
            AppMethodBeat.m2505o(68343);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$b */
    public static class C3661b extends BaseAdapter implements Filterable {
        private List<C43404o> gAm;
        private ArrayList<C43404o> gAn;
        private Context mContext;
        private final Object mLock = new Object();
        private boolean pyJ = true;
        private C3662a pyK;

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$b$a */
        class C3662a extends Filter {
            private C3662a() {
            }

            /* synthetic */ C3662a(C3661b c3661b, byte b) {
                this();
            }

            /* Access modifiers changed, original: protected|final */
            public final FilterResults performFiltering(CharSequence charSequence) {
                AppMethodBeat.m2504i(68349);
                FilterResults filterResults = new FilterResults();
                if (C3661b.this.gAn == null) {
                    synchronized (C3661b.this.mLock) {
                        try {
                            C3661b.this.gAn = new ArrayList(C3661b.this.gAm);
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.m2505o(68349);
                            }
                        }
                    }
                }
                if (charSequence == null || charSequence.length() == 0) {
                    synchronized (C3661b.this.mLock) {
                        try {
                            ArrayList arrayList = new ArrayList(C3661b.this.gAn);
                            filterResults.values = arrayList;
                            filterResults.count = arrayList.size();
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.m2505o(68349);
                            }
                        }
                    }
                } else {
                    String toLowerCase = charSequence.toString().toLowerCase();
                    ArrayList a = C3661b.this.gAn;
                    int size = a.size();
                    ArrayList arrayList2 = new ArrayList(size);
                    for (int i = 0; i < size; i++) {
                        C43404o c43404o = (C43404o) a.get(i);
                        if (c43404o.name.toLowerCase().contains(toLowerCase) || c43404o.nJq.toLowerCase().contains(toLowerCase)) {
                            arrayList2.add(c43404o);
                        }
                    }
                    filterResults.values = arrayList2;
                    filterResults.count = arrayList2.size();
                }
                AppMethodBeat.m2505o(68349);
                return filterResults;
            }

            /* Access modifiers changed, original: protected|final */
            public final void publishResults(CharSequence charSequence, FilterResults filterResults) {
                AppMethodBeat.m2504i(68350);
                C3661b.this.gAm = (List) filterResults.values;
                if (filterResults.count > 0) {
                    C3661b.this.notifyDataSetChanged();
                    AppMethodBeat.m2505o(68350);
                    return;
                }
                C3661b.this.gAm = new ArrayList(C3661b.this.gAn);
                C3661b.this.notifyDataSetInvalidated();
                AppMethodBeat.m2505o(68350);
            }
        }

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$b$b */
        class C3663b {
            TextView gxi;
            CheckBox pyM;
            TextView pyu;

            private C3663b() {
            }

            /* synthetic */ C3663b(C3661b c3661b, byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(68357);
            C43404o Bu = mo8262Bu(i);
            AppMethodBeat.m2505o(68357);
            return Bu;
        }

        public C3661b(Context context, List<C43404o> list) {
            AppMethodBeat.m2504i(68351);
            this.mContext = context;
            this.gAm = list;
            AppMethodBeat.m2505o(68351);
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.m2504i(68352);
            super.notifyDataSetChanged();
            this.pyJ = true;
            AppMethodBeat.m2505o(68352);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(68353);
            int size = this.gAm.size();
            AppMethodBeat.m2505o(68353);
            return size;
        }

        /* renamed from: Bu */
        public final C43404o mo8262Bu(int i) {
            AppMethodBeat.m2504i(68354);
            C43404o c43404o = (C43404o) this.gAm.get(i);
            AppMethodBeat.m2505o(68354);
            return c43404o;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(68355);
            if (view == null) {
                view = View.inflate(this.mContext, 2130970427, null);
                C3663b c3663b = new C3663b(this, (byte) 0);
                c3663b.gxi = (TextView) view.findViewById(2131826689);
                c3663b.pyu = (TextView) view.findViewById(2131826690);
                c3663b.pyM = (CheckBox) view.findViewById(2131826691);
                view.setTag(c3663b);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) view;
            }
            C43404o Bu = mo8262Bu(i);
            C3663b c3663b2 = (C3663b) view.getTag();
            c3663b2.gxi.setText(Bu.name);
            c3663b2.pyu.setText(Bu.nJq);
            c3663b2.pyM.setVisibility(8);
            view.setBackgroundColor(-789517);
            AppMethodBeat.m2505o(68355);
            return view;
        }

        public final Filter getFilter() {
            AppMethodBeat.m2504i(68356);
            if (this.pyK == null) {
                this.pyK = new C3662a(this, (byte) 0);
            }
            C3662a c3662a = this.pyK;
            AppMethodBeat.m2505o(68356);
            return c3662a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$c */
    public static abstract class C3664c {
        /* renamed from: jW */
        public void mo8271jW(boolean z) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$7 */
    class C129177 implements OnFocusChangeListener {
        C129177() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(68344);
            if (MailAddrsViewControl.this.pyB != null) {
                MailAddrsViewControl.this.pyB.mo8271jW(z);
            }
            String obj = MailAddrsViewControl.this.pyz.getEditableText().toString();
            if (!z && obj.trim().length() > 0) {
                MailAddrsViewControl.m57075a(MailAddrsViewControl.this, obj, false);
            }
            if (MailAddrsViewControl.this.pyC != null && MailAddrsViewControl.this.pyC.isSelected()) {
                MailAddrsViewControl.this.pyC.setSelected(z);
                MailAddrsViewControl.this.pyC = null;
            }
            MailAddrsViewControl.this.cdj();
            AppMethodBeat.m2505o(68344);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$8 */
    class C129188 extends SimpleOnGestureListener {
        C129188() {
        }

        private void cdk() {
            AppMethodBeat.m2504i(68345);
            C43404o c43404o = (C43404o) MailAddrsViewControl.this.pyC.getTag();
            if (MailAddrsViewControl.this.pyB != null) {
                MailAddrsViewControl.this.pyB;
                MailAddrsViewControl.this.pyC;
            }
            Intent intent = new Intent(MailAddrsViewControl.this.getContext(), MailAddrProfileUI.class);
            intent.putExtra("name", c43404o.name);
            intent.putExtra("addr", c43404o.nJq);
            intent.putExtra("can_compose", !MailAddrsViewControl.this.gJL);
            MailAddrsViewControl.this.getContext().startActivity(intent);
            AppMethodBeat.m2505o(68345);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(68346);
            if (!MailAddrsViewControl.this.gJL) {
                cdk();
            }
            AppMethodBeat.m2505o(68346);
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(68347);
            if (!(MailAddrsViewControl.this.pyB == null || MailAddrsViewControl.this.pyC == null)) {
                MailAddrsViewControl.this.pyB;
                MailAddrsViewControl.this.pyC;
                MailAddrsViewControl.this.pyC.getTag();
            }
            AppMethodBeat.m2505o(68347);
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(68348);
            cdk();
            AppMethodBeat.m2505o(68348);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$a */
    public interface C12919a {
        /* renamed from: b */
        void mo24945b(MailAddrsViewControl mailAddrsViewControl);

        void ccV();
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$1 */
    class C287661 implements OnClickListener {
        C287661() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68337);
            MailAddrsViewControl.this.pyz.requestFocus();
            ((InputMethodManager) MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
            AppMethodBeat.m2505o(68337);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$4 */
    class C347514 implements OnEditorActionListener {
        C347514() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(68341);
            if (i == 5) {
                String obj = MailAddrsViewControl.this.pyz.getEditableText().toString();
                if (obj != null && obj.length() > 0) {
                    MailAddrsViewControl.m57075a(MailAddrsViewControl.this, obj, false);
                    MailAddrsViewControl.this.cdj();
                }
            }
            AppMethodBeat.m2505o(68341);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$3 */
    class C347523 implements OnItemClickListener {
        C347523() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(68340);
            MailAddrsViewControl.this.mo55354e(MailAddrsViewControl.this.pyA.mo8262Bu(i));
            MailAddrsViewControl.this.pyz.setText("");
            AppMethodBeat.m2505o(68340);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$5 */
    class C347535 implements OnKeyListener {
        C347535() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(68342);
            String obj;
            if (i == 67 && keyEvent.getAction() == 0) {
                obj = MailAddrsViewControl.this.pyz.getEditableText().toString();
                if (obj.length() == 0 && MailAddrsViewControl.this.pyC != null && MailAddrsViewControl.this.pyC.isSelected()) {
                    MailAddrsViewControl.this.mo55355f((C43404o) MailAddrsViewControl.this.pyC.getTag());
                    MailAddrsViewControl.this.pyC = null;
                    MailAddrsViewControl.this.cdj();
                } else if (obj.length() == 0 && MailAddrsViewControl.this.pyy.size() > 0) {
                    int size = MailAddrsViewControl.this.pyy.size() - 1;
                    View childAt = MailAddrsViewControl.this.getChildAt(size);
                    if (childAt.isSelected()) {
                        MailAddrsViewControl.this.mo55355f((C43404o) MailAddrsViewControl.this.pyy.get(size));
                        MailAddrsViewControl.this.cdj();
                    } else {
                        childAt.setSelected(true);
                    }
                }
            } else if (i == 66 && keyEvent.getAction() == 0) {
                obj = MailAddrsViewControl.this.pyz.getEditableText().toString();
                if (obj != null && obj.length() > 0) {
                    MailAddrsViewControl.m57075a(MailAddrsViewControl.this, obj, true);
                    MailAddrsViewControl.this.cdj();
                }
            }
            AppMethodBeat.m2505o(68342);
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m57075a(MailAddrsViewControl mailAddrsViewControl, String str, boolean z) {
        AppMethodBeat.m2504i(68375);
        mailAddrsViewControl.m57076ba(str, z);
        AppMethodBeat.m2505o(68375);
    }

    public void setInvalidMailAddrListener(C12919a c12919a) {
        this.pyD = c12919a;
    }

    public final boolean cdg() {
        AppMethodBeat.m2504i(68358);
        Editable text = this.pyz.getText();
        if (text == null) {
            AppMethodBeat.m2505o(68358);
            return true;
        } else if (text.toString().length() <= 0) {
            AppMethodBeat.m2505o(68358);
            return true;
        } else {
            AppMethodBeat.m2505o(68358);
            return false;
        }
    }

    public MailAddrsViewControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(68359);
        this.pxH = new GestureDetector(context, this.pyF);
        AppMethodBeat.m2505o(68359);
    }

    public void setEditable(boolean z) {
        AppMethodBeat.m2504i(68360);
        this.gJL = z;
        if (z && this.pyz == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (!(childAt instanceof AutoCompleteTextView)) {
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) childAt;
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            View childAt2 = viewGroup.getChildAt(i2);
                            if (childAt2 instanceof AutoCompleteTextView) {
                                this.pyz = (AutoCompleteTextView) childAt2;
                            }
                        }
                    }
                    if (this.pyz != null) {
                        break;
                    }
                    i++;
                } else {
                    this.pyz = (AutoCompleteTextView) childAt;
                    break;
                }
            }
            if (this.pyz != null) {
                this.pyz.setDropDownBackgroundResource(C25738R.drawable.aly);
                setOnClickListener(new C287661());
                this.pyz.setOnItemClickListener(new C347523());
                this.pyz.setOnEditorActionListener(new C347514());
                this.pyz.setOnKeyListener(new C347535());
                this.pyz.addTextChangedListener(new C36606());
                this.pyz.setOnFocusChangeListener(new C129177());
                AppMethodBeat.m2505o(68360);
                return;
            }
        } else if (!(z || this.pyz == null)) {
            this.pyz.setVisibility(8);
        }
        AppMethodBeat.m2505o(68360);
    }

    public void setAddrsAdapter(C3661b c3661b) {
        AppMethodBeat.m2504i(68361);
        if (!(this.pyz == null || c3661b == null)) {
            this.pyA = c3661b;
            this.pyz.setAdapter(c3661b);
        }
        AppMethodBeat.m2505o(68361);
    }

    public void setOnActionListener(C3664c c3664c) {
        this.pyB = c3664c;
    }

    public LinkedList<C43404o> getMailAddrs() {
        return this.pyy;
    }

    /* renamed from: a */
    public final String[] mo55347a(boolean z, C46607d c46607d) {
        int i = 0;
        AppMethodBeat.m2504i(68362);
        String userBindEmail;
        if (c46607d == null || !c46607d.isConnected()) {
            userBindEmail = C1853r.getUserBindEmail();
        } else {
            try {
                userBindEmail = (String) new ReadMailProxy(c46607d, null).REMOTE_CALL("getUserBindEmail", new Object[0]);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.QQMail.MailAddrsViewControl", "getMailAddrStringArray, getUserBindEmail fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(68362);
                return null;
            }
        }
        String[] strArr = new String[this.pyy.size()];
        while (i < this.pyy.size()) {
            C43404o c43404o = (C43404o) this.pyy.get(i);
            if (z && c43404o.nJq.equalsIgnoreCase(userBindEmail)) {
                strArr[i] = "";
            } else {
                strArr[i] = c43404o.name + " " + c43404o.nJq;
            }
            i++;
        }
        AppMethodBeat.m2505o(68362);
        return strArr;
    }

    public final boolean cdh() {
        AppMethodBeat.m2504i(68363);
        String trim = this.pyz.getEditableText().toString().trim();
        if (C5046bo.isNullOrNil(trim) || !MailAddrsViewControl.m57073Vs(trim)) {
            AppMethodBeat.m2505o(68363);
            return false;
        }
        AppMethodBeat.m2505o(68363);
        return true;
    }

    public String getAddrsString() {
        boolean z = false;
        AppMethodBeat.m2504i(68364);
        if (cdh()) {
            m57076ba(this.pyz.getEditableText().toString(), false);
        }
        String str = "";
        while (true) {
            boolean z2 = z;
            if (z2 < this.pyy.size()) {
                C43404o c43404o = (C43404o) this.pyy.get(z2);
                if (z2) {
                    str = str + ",";
                }
                str = str + c43404o.nJq;
                z = z2 + 1;
            } else {
                AppMethodBeat.m2505o(68364);
                return str;
            }
        }
    }

    public int getSize() {
        AppMethodBeat.m2504i(68365);
        int size = this.pyy.size();
        AppMethodBeat.m2505o(68365);
        return size;
    }

    /* renamed from: e */
    public final void mo55354e(C43404o c43404o) {
        AppMethodBeat.m2504i(68366);
        if (c43404o == null) {
            AppMethodBeat.m2505o(68366);
            return;
        }
        Object obj;
        Iterator it = this.pyy.iterator();
        while (it.hasNext()) {
            if (((C43404o) it.next()).nJq.equalsIgnoreCase(c43404o.nJq)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), 2130970425, null);
            final Button button = (Button) viewGroup.findViewById(2131826692);
            viewGroup.removeView((View) button.getParent());
            button.setText(c43404o.name);
            if (this.gJL) {
                button.setCompoundDrawables(null, null, null, null);
            }
            button.setTag(this.pyy.size());
            View view = (View) button.getParent();
            button.setTag(c43404o);
            view.setVisibility(4);
            view.setTag(c43404o);
            addView(view, this.pyy.size());
            this.pyy.add(c43404o);
            this.handler.postDelayed(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$2$1 */
                class C36591 implements OnTouchListener {
                    C36591() {
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.m2504i(68338);
                        if (!(MailAddrsViewControl.this.pyC == null || MailAddrsViewControl.this.pyC == view || !MailAddrsViewControl.this.pyC.isSelected())) {
                            MailAddrsViewControl.this.pyC.setSelected(false);
                            MailAddrsViewControl.this.pyC = null;
                        }
                        MailAddrsViewControl.this.pyC = view;
                        if (MailAddrsViewControl.this.pyz != null && motionEvent.getAction() == 0) {
                            button.setSelected(!button.isSelected());
                            MailAddrsViewControl.this.pyz.setVisibility(0);
                            MailAddrsViewControl.this.pyz.requestFocus();
                            ((InputMethodManager) MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                        }
                        boolean onTouchEvent = MailAddrsViewControl.this.pxH.onTouchEvent(motionEvent);
                        AppMethodBeat.m2505o(68338);
                        return onTouchEvent;
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(68339);
                    button.invalidate();
                    button.setOnTouchListener(new C36591());
                    MailAddrsViewControl.this.cdj();
                    MailAddrsViewControl.this.invalidate();
                    AppMethodBeat.m2505o(68339);
                }
            }, 100);
        }
        AppMethodBeat.m2505o(68366);
    }

    /* renamed from: b */
    public final void mo55348b(String[] strArr, boolean z) {
        AppMethodBeat.m2504i(68367);
        if (z) {
            removeAllViews();
            this.pyy.clear();
            cdj();
            invalidate();
        }
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.m2505o(68367);
            return;
        }
        for (String Vj : strArr) {
            C43404o Vj2 = C46149p.m86140Vj(Vj);
            if (Vj2 != null) {
                mo55354e(Vj2);
            }
        }
        AppMethodBeat.m2505o(68367);
    }

    /* renamed from: cJ */
    public final void mo55349cJ(List<C43404o> list) {
        AppMethodBeat.m2504i(68368);
        if (list == null) {
            AppMethodBeat.m2505o(68368);
            return;
        }
        for (C43404o e : list) {
            mo55354e(e);
        }
        AppMethodBeat.m2505o(68368);
    }

    public void setMailAdds(List<C43404o> list) {
        AppMethodBeat.m2504i(68369);
        if (list == null) {
            AppMethodBeat.m2505o(68369);
            return;
        }
        int i;
        C43404o c43404o;
        int i2;
        for (i = 0; i < this.pyy.size(); i++) {
            c43404o = (C43404o) this.pyy.get(i);
            i2 = 0;
            while (i2 < list.size()) {
                if (c43404o.nJq.equalsIgnoreCase(((C43404o) list.get(i2)).nJq)) {
                    break;
                }
                i2++;
            }
            if (i2 == list.size()) {
                mo55355f(c43404o);
            }
        }
        for (i = 0; i < list.size(); i++) {
            c43404o = (C43404o) list.get(i);
            i2 = 0;
            while (i2 < this.pyy.size()) {
                if (c43404o.nJq.equalsIgnoreCase(((C43404o) this.pyy.get(i2)).nJq)) {
                    break;
                }
                i2++;
            }
            if (i2 == this.pyy.size()) {
                mo55354e(c43404o);
            }
        }
        AppMethodBeat.m2505o(68369);
    }

    /* renamed from: f */
    public final void mo55355f(C43404o c43404o) {
        AppMethodBeat.m2504i(68370);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pyy.size()) {
                if (c43404o.nJq.equalsIgnoreCase(((C43404o) this.pyy.get(i2)).nJq)) {
                    removeViewAt(i2);
                    this.pyy.remove(i2);
                    cdj();
                    invalidate();
                    AppMethodBeat.m2505o(68370);
                    return;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(68370);
                return;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(68376);
        AppMethodBeat.m2505o(68376);
    }

    /* renamed from: Vs */
    private static boolean m57073Vs(String str) {
        AppMethodBeat.m2504i(68371);
        boolean matches = pyE.matcher(str).matches();
        AppMethodBeat.m2505o(68371);
        return matches;
    }

    public final boolean cdi() {
        AppMethodBeat.m2504i(68372);
        Iterator it = this.pyy.iterator();
        while (it.hasNext()) {
            if (!MailAddrsViewControl.m57073Vs(((C43404o) it.next()).nJq)) {
                AppMethodBeat.m2505o(68372);
                return false;
            }
        }
        AppMethodBeat.m2505o(68372);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void cdj() {
        AppMethodBeat.m2504i(68373);
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8 || (childAt instanceof AutoCompleteTextView)) {
                int i4;
                int width = childAt.getWidth();
                int height = childAt.getHeight();
                if (width == 0) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(getWidth(), C8415j.INVALID_ID), MeasureSpec.makeMeasureSpec(getHeight(), C8415j.INVALID_ID));
                    width = childAt.getMeasuredWidth();
                }
                if (this.pyz == null || i != childCount - 1 || this.pyz.isFocused()) {
                    i4 = width;
                } else {
                    i4 = 0;
                }
                if (i3 + i4 > measuredWidth) {
                    i2 += height;
                    i3 = 0;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.setMargins(i3, i2, layoutParams.rightMargin, layoutParams.bottomMargin);
                childAt.setLayoutParams(layoutParams);
                i3 += i4;
                childAt.setVisibility(0);
            }
            i++;
        }
        AppMethodBeat.m2505o(68373);
    }

    /* renamed from: ba */
    private void m57076ba(String str, boolean z) {
        AppMethodBeat.m2504i(68374);
        String trim = str.trim();
        if (trim.length() == 0) {
            AppMethodBeat.m2505o(68374);
            return;
        }
        List Vi = C12884ac.ccC().puD.mo74096Vi(trim);
        if (Vi.size() > 0) {
            mo55354e((C43404o) Vi.get(0));
            this.pyz.setText("");
            AppMethodBeat.m2505o(68374);
        } else if (MailAddrsViewControl.m57073Vs(trim)) {
            C43404o c43404o = new C43404o();
            c43404o.name = trim;
            c43404o.nJq = trim;
            c43404o.pug = 0;
            mo55354e(c43404o);
            this.pyz.setText("");
            AppMethodBeat.m2505o(68374);
        } else if (z) {
            if (this.pyD != null) {
                this.pyD.ccV();
            } else {
                Toast.makeText(getContext(), C25738R.string.dds, 2000).show();
            }
            this.pyz.setText(trim);
            this.pyz.setSelection(trim.length());
            AppMethodBeat.m2505o(68374);
        } else {
            if (this.pyD != null) {
                this.pyD.mo24945b(this);
            }
            AppMethodBeat.m2505o(68374);
        }
    }
}
