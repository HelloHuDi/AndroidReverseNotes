package com.tencent.p177mm.plugin.sight.encode.p513ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.p612ui.contact.C36251l;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.sight.encode.p513ui.C21856d.C21857a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView */
public class MainSightSelectContactView extends FrameLayout implements OnScrollListener, C21857a, C36251l {
    public MMFragmentActivity iWA;
    public ListView mListView;
    boolean qAC = false;
    public int qBf;
    public C21856d qBg;
    Animation qBh;
    public C46207c qBi;
    private View qBj;
    public C43533a qBk;
    public LinearLayout qBl;
    private View qBm;
    private int qBn = -1;
    private int qBo = -1;
    public HashSet<String> qBp;
    public HashSet<String> qBq;

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView$1 */
    class C218531 implements Runnable {
        C218531() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25083);
            if (MainSightSelectContactView.this.qBn != MainSightSelectContactView.this.qBi.getCount() || MainSightSelectContactView.this.qBk.getViewHeight() < MainSightSelectContactView.this.qBo) {
                if (MainSightSelectContactView.this.qBm != null) {
                    MainSightSelectContactView.this.mListView.removeFooterView(MainSightSelectContactView.this.qBm);
                }
                int d = MainSightSelectContactView.this.qBo;
                if (MainSightSelectContactView.this.qBo < 0 || MainSightSelectContactView.this.qBo > MainSightSelectContactView.this.qBk.getViewHeight()) {
                    d = MainSightSelectContactView.this.qBk.getViewHeight();
                }
                MainSightSelectContactView.this.qBn = MainSightSelectContactView.this.qBi.getCount();
                MainSightSelectContactView.this.qBo = d;
                int i = 0;
                for (int i2 = 0; i2 < MainSightSelectContactView.this.qBi.getCount(); i2++) {
                    View view = MainSightSelectContactView.this.qBi.getView(i2, null, MainSightSelectContactView.this.mListView);
                    view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    i += view.getMeasuredHeight();
                    if (i >= d) {
                        AppMethodBeat.m2505o(25083);
                        return;
                    }
                }
                d -= i;
                if (d > 0) {
                    MainSightSelectContactView.this.qBm = new View(MainSightSelectContactView.this.getContext());
                    MainSightSelectContactView.this.qBm.setLayoutParams(new LayoutParams(-1, d));
                    MainSightSelectContactView.this.qBm.setBackgroundResource(C25738R.color.f11782h4);
                    MainSightSelectContactView.this.mListView.addFooterView(MainSightSelectContactView.this.qBm);
                }
                AppMethodBeat.m2505o(25083);
                return;
            }
            AppMethodBeat.m2505o(25083);
        }
    }

    public MainSightSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainSightSelectContactView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMainSightContentView(C43533a c43533a) {
        this.qBk = c43533a;
    }

    public void setEmptyBgView(View view) {
        this.qBj = view;
    }

    public void setSearchView(View view) {
        AppMethodBeat.m2504i(25084);
        C21856d c21856d = this.qBg;
        c21856d.qAX = view;
        c21856d.qAV = (EditText) view.findViewById(2131820980);
        c21856d.qAW = (TextView) view.findViewById(2131825724);
        c21856d.qAV.setOnFocusChangeListener(c21856d);
        c21856d.qAV.addTextChangedListener(c21856d);
        c21856d.qAW.setOnClickListener(c21856d);
        c21856d.qAZ = (InputMethodManager) view.getContext().getSystemService("input_method");
        AppMethodBeat.m2505o(25084);
    }

    public ListView getListView() {
        return this.mListView;
    }

    public final void clP() {
        AppMethodBeat.m2504i(25085);
        if (this.qBl == null) {
            AppMethodBeat.m2505o(25085);
            return;
        }
        this.qBl.getChildAt(0).setVisibility(0);
        this.qBj.setVisibility(8);
        mo69087I(true, false);
        this.qBk.clC();
        AppMethodBeat.m2505o(25085);
    }

    public final void clO() {
        AppMethodBeat.m2504i(25086);
        if (this.qBl == null) {
            AppMethodBeat.m2505o(25086);
            return;
        }
        this.qBl.getChildAt(0).setVisibility(8);
        this.qBj.setVisibility(0);
        List list = this.qBi.qAO;
        list.remove("@search.tencent");
        list.remove("@sns.tencent");
        list.remove("@draft.tencent");
        m77800b(list, false, true);
        this.qBk.clD();
        if (!this.qBk.mo62684DX()) {
            this.qBk.clE();
        }
        this.qBk.clF();
        AppMethodBeat.m2505o(25086);
    }

    public final void clQ() {
        AppMethodBeat.m2504i(25087);
        this.mListView.post(new C218531());
        AppMethodBeat.m2505o(25087);
    }

    /* renamed from: b */
    private void m77800b(List<String> list, boolean z, boolean z2) {
        AppMethodBeat.m2504i(25088);
        if (this.qAC) {
            AppMethodBeat.m2505o(25088);
        } else if (list == null) {
            AppMethodBeat.m2505o(25088);
        } else {
            if (z) {
                this.qBq.clear();
                this.qBp.clear();
                C46207c.qAQ = true;
                C46207c.qAR = false;
            }
            if (this.qBi != null) {
                this.qBi.mo74228aZ(list);
            }
            if (z2) {
                clQ();
                AppMethodBeat.m2505o(25088);
                return;
            }
            if (this.qBm != null) {
                this.mListView.removeFooterView(this.qBm);
            }
            AppMethodBeat.m2505o(25088);
        }
    }

    /* renamed from: I */
    public final void mo69087I(boolean z, boolean z2) {
        AppMethodBeat.m2504i(25089);
        ArrayList arrayList = new ArrayList();
        arrayList.add("@search.tencent");
        arrayList.add("@sns.tencent");
        List<String> initData = getInitData();
        if (z) {
            arrayList.addAll(this.qBq);
            for (String str : initData) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        } else {
            arrayList.addAll(initData);
        }
        m77800b(arrayList, z2, true);
        AppMethodBeat.m2505o(25089);
    }

    public List<String> getInitData() {
        AppMethodBeat.m2504i(25090);
        ArrayList arrayList = new ArrayList();
        C9638aw.m17190ZK();
        List dsN = C18628c.m29083XR().dsN();
        dsN.remove(C1853r.m3846Yz());
        arrayList.addAll(dsN);
        AppMethodBeat.m2505o(25090);
        return arrayList;
    }

    public Activity getActivity() {
        return this.iWA;
    }

    public ListView getContentLV() {
        return this.mListView;
    }

    public LinkedList<String> getSelectedContact() {
        AppMethodBeat.m2504i(25093);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.qBq);
        AppMethodBeat.m2505o(25093);
        return linkedList;
    }

    public final boolean clR() {
        AppMethodBeat.m2504i(25094);
        if (this.qBq == null) {
            AppMethodBeat.m2505o(25094);
            return true;
        }
        boolean isEmpty = this.qBq.isEmpty();
        AppMethodBeat.m2505o(25094);
        return isEmpty;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mW */
    public final String mo69093mW(int i) {
        AppMethodBeat.m2504i(25095);
        C5445a Pn = this.qBi.getItem(i);
        if (Pn == null) {
            AppMethodBeat.m2505o(25095);
            return null;
        }
        C7616ad c7616ad = Pn.ehM;
        if (c7616ad == null) {
            AppMethodBeat.m2505o(25095);
            return null;
        }
        String str = c7616ad.field_username;
        AppMethodBeat.m2505o(25095);
        return str;
    }

    /* renamed from: CH */
    public static boolean m77794CH(int i) {
        return i == -1;
    }

    public void setIsMultiSelect(boolean z) {
        this.qBi.qAP = z;
    }

    /* renamed from: db */
    public final void mo37331db(List<String> list) {
        AppMethodBeat.m2504i(25096);
        m77800b(list, false, false);
        AppMethodBeat.m2505o(25096);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(25097);
        if (i == 1) {
            C5046bo.hideVKB(absListView);
        }
        AppMethodBeat.m2505o(25097);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.m2504i(25098);
        if (this.qBl == null || absListView == null || this.qBl.getHeight() <= 0 || this.iWA == null) {
            AppMethodBeat.m2505o(25098);
            return;
        }
        int height = this.qBl.getHeight() - this.iWA.getSupportActionBar().getHeight();
        int i4 = -this.qBl.getTop();
        if (i4 < 0) {
            AppMethodBeat.m2505o(25098);
            return;
        }
        this.qBk.setCameraShadowAlpha(((float) i4) / ((float) height));
        boolean z = this.qBl.getTop() < 0 && this.qBl.getTop() <= (-height);
        this.qBk.mo62691kD(z);
        AppMethodBeat.m2505o(25098);
    }

    /* renamed from: b */
    public final boolean mo39661b(C5445a c5445a) {
        AppMethodBeat.m2504i(25091);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(25091);
            return false;
        }
        boolean contains = this.qBp.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(25091);
        return contains;
    }

    /* renamed from: a */
    public final boolean mo7897a(C5445a c5445a) {
        AppMethodBeat.m2504i(25092);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(25092);
            return false;
        }
        boolean contains = this.qBq.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(25092);
        return contains;
    }
}
