package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.j;
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
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class MailAddrsViewControl extends RelativeLayout {
    private static final Pattern pyE = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    private boolean gJL = false;
    private ak handler = new ak();
    private GestureDetector pxH;
    private b pyA;
    private c pyB;
    private View pyC;
    private a pyD = null;
    private SimpleOnGestureListener pyF = new SimpleOnGestureListener() {
        private void cdk() {
            AppMethodBeat.i(68345);
            o oVar = (o) MailAddrsViewControl.this.pyC.getTag();
            if (MailAddrsViewControl.this.pyB != null) {
                MailAddrsViewControl.this.pyB;
                MailAddrsViewControl.this.pyC;
            }
            Intent intent = new Intent(MailAddrsViewControl.this.getContext(), MailAddrProfileUI.class);
            intent.putExtra("name", oVar.name);
            intent.putExtra("addr", oVar.nJq);
            intent.putExtra("can_compose", !MailAddrsViewControl.this.gJL);
            MailAddrsViewControl.this.getContext().startActivity(intent);
            AppMethodBeat.o(68345);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(68346);
            if (!MailAddrsViewControl.this.gJL) {
                cdk();
            }
            AppMethodBeat.o(68346);
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(68347);
            if (!(MailAddrsViewControl.this.pyB == null || MailAddrsViewControl.this.pyC == null)) {
                MailAddrsViewControl.this.pyB;
                MailAddrsViewControl.this.pyC;
                MailAddrsViewControl.this.pyC.getTag();
            }
            AppMethodBeat.o(68347);
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(68348);
            cdk();
            AppMethodBeat.o(68348);
            return true;
        }
    };
    private LinkedList<o> pyy = new LinkedList();
    AutoCompleteTextView pyz;

    public static class b extends BaseAdapter implements Filterable {
        private List<o> gAm;
        private ArrayList<o> gAn;
        private Context mContext;
        private final Object mLock = new Object();
        private boolean pyJ = true;
        private a pyK;

        class a extends Filter {
            private a() {
            }

            /* synthetic */ a(b bVar, byte b) {
                this();
            }

            /* Access modifiers changed, original: protected|final */
            public final FilterResults performFiltering(CharSequence charSequence) {
                AppMethodBeat.i(68349);
                FilterResults filterResults = new FilterResults();
                if (b.this.gAn == null) {
                    synchronized (b.this.mLock) {
                        try {
                            b.this.gAn = new ArrayList(b.this.gAm);
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.o(68349);
                            }
                        }
                    }
                }
                if (charSequence == null || charSequence.length() == 0) {
                    synchronized (b.this.mLock) {
                        try {
                            ArrayList arrayList = new ArrayList(b.this.gAn);
                            filterResults.values = arrayList;
                            filterResults.count = arrayList.size();
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.o(68349);
                            }
                        }
                    }
                } else {
                    String toLowerCase = charSequence.toString().toLowerCase();
                    ArrayList a = b.this.gAn;
                    int size = a.size();
                    ArrayList arrayList2 = new ArrayList(size);
                    for (int i = 0; i < size; i++) {
                        o oVar = (o) a.get(i);
                        if (oVar.name.toLowerCase().contains(toLowerCase) || oVar.nJq.toLowerCase().contains(toLowerCase)) {
                            arrayList2.add(oVar);
                        }
                    }
                    filterResults.values = arrayList2;
                    filterResults.count = arrayList2.size();
                }
                AppMethodBeat.o(68349);
                return filterResults;
            }

            /* Access modifiers changed, original: protected|final */
            public final void publishResults(CharSequence charSequence, FilterResults filterResults) {
                AppMethodBeat.i(68350);
                b.this.gAm = (List) filterResults.values;
                if (filterResults.count > 0) {
                    b.this.notifyDataSetChanged();
                    AppMethodBeat.o(68350);
                    return;
                }
                b.this.gAm = new ArrayList(b.this.gAn);
                b.this.notifyDataSetInvalidated();
                AppMethodBeat.o(68350);
            }
        }

        class b {
            TextView gxi;
            CheckBox pyM;
            TextView pyu;

            private b() {
            }

            /* synthetic */ b(b bVar, byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(68357);
            o Bu = Bu(i);
            AppMethodBeat.o(68357);
            return Bu;
        }

        public b(Context context, List<o> list) {
            AppMethodBeat.i(68351);
            this.mContext = context;
            this.gAm = list;
            AppMethodBeat.o(68351);
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.i(68352);
            super.notifyDataSetChanged();
            this.pyJ = true;
            AppMethodBeat.o(68352);
        }

        public final int getCount() {
            AppMethodBeat.i(68353);
            int size = this.gAm.size();
            AppMethodBeat.o(68353);
            return size;
        }

        public final o Bu(int i) {
            AppMethodBeat.i(68354);
            o oVar = (o) this.gAm.get(i);
            AppMethodBeat.o(68354);
            return oVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(68355);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.am7, null);
                b bVar = new b(this, (byte) 0);
                bVar.gxi = (TextView) view.findViewById(R.id.dr4);
                bVar.pyu = (TextView) view.findViewById(R.id.dr5);
                bVar.pyM = (CheckBox) view.findViewById(R.id.dr6);
                view.setTag(bVar);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) view;
            }
            o Bu = Bu(i);
            b bVar2 = (b) view.getTag();
            bVar2.gxi.setText(Bu.name);
            bVar2.pyu.setText(Bu.nJq);
            bVar2.pyM.setVisibility(8);
            view.setBackgroundColor(-789517);
            AppMethodBeat.o(68355);
            return view;
        }

        public final Filter getFilter() {
            AppMethodBeat.i(68356);
            if (this.pyK == null) {
                this.pyK = new a(this, (byte) 0);
            }
            a aVar = this.pyK;
            AppMethodBeat.o(68356);
            return aVar;
        }
    }

    public static abstract class c {
        public void jW(boolean z) {
        }
    }

    public interface a {
        void b(MailAddrsViewControl mailAddrsViewControl);

        void ccV();
    }

    static /* synthetic */ void a(MailAddrsViewControl mailAddrsViewControl, String str, boolean z) {
        AppMethodBeat.i(68375);
        mailAddrsViewControl.ba(str, z);
        AppMethodBeat.o(68375);
    }

    public void setInvalidMailAddrListener(a aVar) {
        this.pyD = aVar;
    }

    public final boolean cdg() {
        AppMethodBeat.i(68358);
        Editable text = this.pyz.getText();
        if (text == null) {
            AppMethodBeat.o(68358);
            return true;
        } else if (text.toString().length() <= 0) {
            AppMethodBeat.o(68358);
            return true;
        } else {
            AppMethodBeat.o(68358);
            return false;
        }
    }

    public MailAddrsViewControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(68359);
        this.pxH = new GestureDetector(context, this.pyF);
        AppMethodBeat.o(68359);
    }

    public void setEditable(boolean z) {
        AppMethodBeat.i(68360);
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
                this.pyz.setDropDownBackgroundResource(R.drawable.aly);
                setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(68337);
                        MailAddrsViewControl.this.pyz.requestFocus();
                        ((InputMethodManager) MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                        AppMethodBeat.o(68337);
                    }
                });
                this.pyz.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(68340);
                        MailAddrsViewControl.this.e(MailAddrsViewControl.this.pyA.Bu(i));
                        MailAddrsViewControl.this.pyz.setText("");
                        AppMethodBeat.o(68340);
                    }
                });
                this.pyz.setOnEditorActionListener(new OnEditorActionListener() {
                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        AppMethodBeat.i(68341);
                        if (i == 5) {
                            String obj = MailAddrsViewControl.this.pyz.getEditableText().toString();
                            if (obj != null && obj.length() > 0) {
                                MailAddrsViewControl.a(MailAddrsViewControl.this, obj, false);
                                MailAddrsViewControl.this.cdj();
                            }
                        }
                        AppMethodBeat.o(68341);
                        return true;
                    }
                });
                this.pyz.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                        AppMethodBeat.i(68342);
                        String obj;
                        if (i == 67 && keyEvent.getAction() == 0) {
                            obj = MailAddrsViewControl.this.pyz.getEditableText().toString();
                            if (obj.length() == 0 && MailAddrsViewControl.this.pyC != null && MailAddrsViewControl.this.pyC.isSelected()) {
                                MailAddrsViewControl.this.f((o) MailAddrsViewControl.this.pyC.getTag());
                                MailAddrsViewControl.this.pyC = null;
                                MailAddrsViewControl.this.cdj();
                            } else if (obj.length() == 0 && MailAddrsViewControl.this.pyy.size() > 0) {
                                int size = MailAddrsViewControl.this.pyy.size() - 1;
                                View childAt = MailAddrsViewControl.this.getChildAt(size);
                                if (childAt.isSelected()) {
                                    MailAddrsViewControl.this.f((o) MailAddrsViewControl.this.pyy.get(size));
                                    MailAddrsViewControl.this.cdj();
                                } else {
                                    childAt.setSelected(true);
                                }
                            }
                        } else if (i == 66 && keyEvent.getAction() == 0) {
                            obj = MailAddrsViewControl.this.pyz.getEditableText().toString();
                            if (obj != null && obj.length() > 0) {
                                MailAddrsViewControl.a(MailAddrsViewControl.this, obj, true);
                                MailAddrsViewControl.this.cdj();
                            }
                        }
                        AppMethodBeat.o(68342);
                        return false;
                    }
                });
                this.pyz.addTextChangedListener(new TextWatcher() {
                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        AppMethodBeat.i(68343);
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.endsWith(IOUtils.LINE_SEPARATOR_UNIX) || charSequence2.endsWith(" ")) {
                            MailAddrsViewControl.a(MailAddrsViewControl.this, charSequence2, true);
                        }
                        MailAddrsViewControl.this.cdj();
                        AppMethodBeat.o(68343);
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                    }
                });
                this.pyz.setOnFocusChangeListener(new OnFocusChangeListener() {
                    public final void onFocusChange(View view, boolean z) {
                        AppMethodBeat.i(68344);
                        if (MailAddrsViewControl.this.pyB != null) {
                            MailAddrsViewControl.this.pyB.jW(z);
                        }
                        String obj = MailAddrsViewControl.this.pyz.getEditableText().toString();
                        if (!z && obj.trim().length() > 0) {
                            MailAddrsViewControl.a(MailAddrsViewControl.this, obj, false);
                        }
                        if (MailAddrsViewControl.this.pyC != null && MailAddrsViewControl.this.pyC.isSelected()) {
                            MailAddrsViewControl.this.pyC.setSelected(z);
                            MailAddrsViewControl.this.pyC = null;
                        }
                        MailAddrsViewControl.this.cdj();
                        AppMethodBeat.o(68344);
                    }
                });
                AppMethodBeat.o(68360);
                return;
            }
        } else if (!(z || this.pyz == null)) {
            this.pyz.setVisibility(8);
        }
        AppMethodBeat.o(68360);
    }

    public void setAddrsAdapter(b bVar) {
        AppMethodBeat.i(68361);
        if (!(this.pyz == null || bVar == null)) {
            this.pyA = bVar;
            this.pyz.setAdapter(bVar);
        }
        AppMethodBeat.o(68361);
    }

    public void setOnActionListener(c cVar) {
        this.pyB = cVar;
    }

    public LinkedList<o> getMailAddrs() {
        return this.pyy;
    }

    public final String[] a(boolean z, d dVar) {
        int i = 0;
        AppMethodBeat.i(68362);
        String userBindEmail;
        if (dVar == null || !dVar.isConnected()) {
            userBindEmail = r.getUserBindEmail();
        } else {
            try {
                userBindEmail = (String) new ReadMailProxy(dVar, null).REMOTE_CALL("getUserBindEmail", new Object[0]);
            } catch (Exception e) {
                ab.e("MicroMsg.QQMail.MailAddrsViewControl", "getMailAddrStringArray, getUserBindEmail fail, ex = %s", e.getMessage());
                AppMethodBeat.o(68362);
                return null;
            }
        }
        String[] strArr = new String[this.pyy.size()];
        while (i < this.pyy.size()) {
            o oVar = (o) this.pyy.get(i);
            if (z && oVar.nJq.equalsIgnoreCase(userBindEmail)) {
                strArr[i] = "";
            } else {
                strArr[i] = oVar.name + " " + oVar.nJq;
            }
            i++;
        }
        AppMethodBeat.o(68362);
        return strArr;
    }

    public final boolean cdh() {
        AppMethodBeat.i(68363);
        String trim = this.pyz.getEditableText().toString().trim();
        if (bo.isNullOrNil(trim) || !Vs(trim)) {
            AppMethodBeat.o(68363);
            return false;
        }
        AppMethodBeat.o(68363);
        return true;
    }

    public String getAddrsString() {
        boolean z = false;
        AppMethodBeat.i(68364);
        if (cdh()) {
            ba(this.pyz.getEditableText().toString(), false);
        }
        String str = "";
        while (true) {
            boolean z2 = z;
            if (z2 < this.pyy.size()) {
                o oVar = (o) this.pyy.get(z2);
                if (z2) {
                    str = str + ",";
                }
                str = str + oVar.nJq;
                z = z2 + 1;
            } else {
                AppMethodBeat.o(68364);
                return str;
            }
        }
    }

    public int getSize() {
        AppMethodBeat.i(68365);
        int size = this.pyy.size();
        AppMethodBeat.o(68365);
        return size;
    }

    public final void e(o oVar) {
        AppMethodBeat.i(68366);
        if (oVar == null) {
            AppMethodBeat.o(68366);
            return;
        }
        Object obj;
        Iterator it = this.pyy.iterator();
        while (it.hasNext()) {
            if (((o) it.next()).nJq.equalsIgnoreCase(oVar.nJq)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.layout.am5, null);
            final Button button = (Button) viewGroup.findViewById(R.id.dr7);
            viewGroup.removeView((View) button.getParent());
            button.setText(oVar.name);
            if (this.gJL) {
                button.setCompoundDrawables(null, null, null, null);
            }
            button.setTag(this.pyy.size());
            View view = (View) button.getParent();
            button.setTag(oVar);
            view.setVisibility(4);
            view.setTag(oVar);
            addView(view, this.pyy.size());
            this.pyy.add(oVar);
            this.handler.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(68339);
                    button.invalidate();
                    button.setOnTouchListener(new OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(68338);
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
                            AppMethodBeat.o(68338);
                            return onTouchEvent;
                        }
                    });
                    MailAddrsViewControl.this.cdj();
                    MailAddrsViewControl.this.invalidate();
                    AppMethodBeat.o(68339);
                }
            }, 100);
        }
        AppMethodBeat.o(68366);
    }

    public final void b(String[] strArr, boolean z) {
        AppMethodBeat.i(68367);
        if (z) {
            removeAllViews();
            this.pyy.clear();
            cdj();
            invalidate();
        }
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(68367);
            return;
        }
        for (String Vj : strArr) {
            o Vj2 = p.Vj(Vj);
            if (Vj2 != null) {
                e(Vj2);
            }
        }
        AppMethodBeat.o(68367);
    }

    public final void cJ(List<o> list) {
        AppMethodBeat.i(68368);
        if (list == null) {
            AppMethodBeat.o(68368);
            return;
        }
        for (o e : list) {
            e(e);
        }
        AppMethodBeat.o(68368);
    }

    public void setMailAdds(List<o> list) {
        AppMethodBeat.i(68369);
        if (list == null) {
            AppMethodBeat.o(68369);
            return;
        }
        int i;
        o oVar;
        int i2;
        for (i = 0; i < this.pyy.size(); i++) {
            oVar = (o) this.pyy.get(i);
            i2 = 0;
            while (i2 < list.size()) {
                if (oVar.nJq.equalsIgnoreCase(((o) list.get(i2)).nJq)) {
                    break;
                }
                i2++;
            }
            if (i2 == list.size()) {
                f(oVar);
            }
        }
        for (i = 0; i < list.size(); i++) {
            oVar = (o) list.get(i);
            i2 = 0;
            while (i2 < this.pyy.size()) {
                if (oVar.nJq.equalsIgnoreCase(((o) this.pyy.get(i2)).nJq)) {
                    break;
                }
                i2++;
            }
            if (i2 == this.pyy.size()) {
                e(oVar);
            }
        }
        AppMethodBeat.o(68369);
    }

    public final void f(o oVar) {
        AppMethodBeat.i(68370);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pyy.size()) {
                if (oVar.nJq.equalsIgnoreCase(((o) this.pyy.get(i2)).nJq)) {
                    removeViewAt(i2);
                    this.pyy.remove(i2);
                    cdj();
                    invalidate();
                    AppMethodBeat.o(68370);
                    return;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(68370);
                return;
            }
        }
    }

    static {
        AppMethodBeat.i(68376);
        AppMethodBeat.o(68376);
    }

    private static boolean Vs(String str) {
        AppMethodBeat.i(68371);
        boolean matches = pyE.matcher(str).matches();
        AppMethodBeat.o(68371);
        return matches;
    }

    public final boolean cdi() {
        AppMethodBeat.i(68372);
        Iterator it = this.pyy.iterator();
        while (it.hasNext()) {
            if (!Vs(((o) it.next()).nJq)) {
                AppMethodBeat.o(68372);
                return false;
            }
        }
        AppMethodBeat.o(68372);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void cdj() {
        AppMethodBeat.i(68373);
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
                    childAt.measure(MeasureSpec.makeMeasureSpec(getWidth(), j.INVALID_ID), MeasureSpec.makeMeasureSpec(getHeight(), j.INVALID_ID));
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
        AppMethodBeat.o(68373);
    }

    private void ba(String str, boolean z) {
        AppMethodBeat.i(68374);
        String trim = str.trim();
        if (trim.length() == 0) {
            AppMethodBeat.o(68374);
            return;
        }
        List Vi = ac.ccC().puD.Vi(trim);
        if (Vi.size() > 0) {
            e((o) Vi.get(0));
            this.pyz.setText("");
            AppMethodBeat.o(68374);
        } else if (Vs(trim)) {
            o oVar = new o();
            oVar.name = trim;
            oVar.nJq = trim;
            oVar.pug = 0;
            e(oVar);
            this.pyz.setText("");
            AppMethodBeat.o(68374);
        } else if (z) {
            if (this.pyD != null) {
                this.pyD.ccV();
            } else {
                Toast.makeText(getContext(), R.string.dds, 2000).show();
            }
            this.pyz.setText(trim);
            this.pyz.setSelection(trim.length());
            AppMethodBeat.o(68374);
        } else {
            if (this.pyD != null) {
                this.pyD.b(this);
            }
            AppMethodBeat.o(68374);
        }
    }
}
