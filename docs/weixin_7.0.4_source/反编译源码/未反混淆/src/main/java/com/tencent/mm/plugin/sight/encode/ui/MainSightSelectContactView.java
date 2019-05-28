package com.tencent.mm.plugin.sight.encode.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sight.encode.ui.d.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.contact.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MainSightSelectContactView extends FrameLayout implements OnScrollListener, a, l {
    public MMFragmentActivity iWA;
    public ListView mListView;
    boolean qAC = false;
    public int qBf;
    public d qBg;
    Animation qBh;
    public c qBi;
    private View qBj;
    public a qBk;
    public LinearLayout qBl;
    private View qBm;
    private int qBn = -1;
    private int qBo = -1;
    public HashSet<String> qBp;
    public HashSet<String> qBq;

    public MainSightSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainSightSelectContactView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMainSightContentView(a aVar) {
        this.qBk = aVar;
    }

    public void setEmptyBgView(View view) {
        this.qBj = view;
    }

    public void setSearchView(View view) {
        AppMethodBeat.i(25084);
        d dVar = this.qBg;
        dVar.qAX = view;
        dVar.qAV = (EditText) view.findViewById(R.id.l3);
        dVar.qAW = (TextView) view.findViewById(R.id.d21);
        dVar.qAV.setOnFocusChangeListener(dVar);
        dVar.qAV.addTextChangedListener(dVar);
        dVar.qAW.setOnClickListener(dVar);
        dVar.qAZ = (InputMethodManager) view.getContext().getSystemService("input_method");
        AppMethodBeat.o(25084);
    }

    public ListView getListView() {
        return this.mListView;
    }

    public final void clP() {
        AppMethodBeat.i(25085);
        if (this.qBl == null) {
            AppMethodBeat.o(25085);
            return;
        }
        this.qBl.getChildAt(0).setVisibility(0);
        this.qBj.setVisibility(8);
        I(true, false);
        this.qBk.clC();
        AppMethodBeat.o(25085);
    }

    public final void clO() {
        AppMethodBeat.i(25086);
        if (this.qBl == null) {
            AppMethodBeat.o(25086);
            return;
        }
        this.qBl.getChildAt(0).setVisibility(8);
        this.qBj.setVisibility(0);
        List list = this.qBi.qAO;
        list.remove("@search.tencent");
        list.remove("@sns.tencent");
        list.remove("@draft.tencent");
        b(list, false, true);
        this.qBk.clD();
        if (!this.qBk.DX()) {
            this.qBk.clE();
        }
        this.qBk.clF();
        AppMethodBeat.o(25086);
    }

    public final void clQ() {
        AppMethodBeat.i(25087);
        this.mListView.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(25083);
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
                            AppMethodBeat.o(25083);
                            return;
                        }
                    }
                    d -= i;
                    if (d > 0) {
                        MainSightSelectContactView.this.qBm = new View(MainSightSelectContactView.this.getContext());
                        MainSightSelectContactView.this.qBm.setLayoutParams(new LayoutParams(-1, d));
                        MainSightSelectContactView.this.qBm.setBackgroundResource(R.color.h4);
                        MainSightSelectContactView.this.mListView.addFooterView(MainSightSelectContactView.this.qBm);
                    }
                    AppMethodBeat.o(25083);
                    return;
                }
                AppMethodBeat.o(25083);
            }
        });
        AppMethodBeat.o(25087);
    }

    private void b(List<String> list, boolean z, boolean z2) {
        AppMethodBeat.i(25088);
        if (this.qAC) {
            AppMethodBeat.o(25088);
        } else if (list == null) {
            AppMethodBeat.o(25088);
        } else {
            if (z) {
                this.qBq.clear();
                this.qBp.clear();
                c.qAQ = true;
                c.qAR = false;
            }
            if (this.qBi != null) {
                this.qBi.aZ(list);
            }
            if (z2) {
                clQ();
                AppMethodBeat.o(25088);
                return;
            }
            if (this.qBm != null) {
                this.mListView.removeFooterView(this.qBm);
            }
            AppMethodBeat.o(25088);
        }
    }

    public final void I(boolean z, boolean z2) {
        AppMethodBeat.i(25089);
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
        b(arrayList, z2, true);
        AppMethodBeat.o(25089);
    }

    public List<String> getInitData() {
        AppMethodBeat.i(25090);
        ArrayList arrayList = new ArrayList();
        aw.ZK();
        List dsN = c.XR().dsN();
        dsN.remove(r.Yz());
        arrayList.addAll(dsN);
        AppMethodBeat.o(25090);
        return arrayList;
    }

    public Activity getActivity() {
        return this.iWA;
    }

    public ListView getContentLV() {
        return this.mListView;
    }

    public LinkedList<String> getSelectedContact() {
        AppMethodBeat.i(25093);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.qBq);
        AppMethodBeat.o(25093);
        return linkedList;
    }

    public final boolean clR() {
        AppMethodBeat.i(25094);
        if (this.qBq == null) {
            AppMethodBeat.o(25094);
            return true;
        }
        boolean isEmpty = this.qBq.isEmpty();
        AppMethodBeat.o(25094);
        return isEmpty;
    }

    /* Access modifiers changed, original: final */
    public final String mW(int i) {
        AppMethodBeat.i(25095);
        com.tencent.mm.ui.contact.a.a Pn = this.qBi.getItem(i);
        if (Pn == null) {
            AppMethodBeat.o(25095);
            return null;
        }
        ad adVar = Pn.ehM;
        if (adVar == null) {
            AppMethodBeat.o(25095);
            return null;
        }
        String str = adVar.field_username;
        AppMethodBeat.o(25095);
        return str;
    }

    public static boolean CH(int i) {
        return i == -1;
    }

    public void setIsMultiSelect(boolean z) {
        this.qBi.qAP = z;
    }

    public final void db(List<String> list) {
        AppMethodBeat.i(25096);
        b(list, false, false);
        AppMethodBeat.o(25096);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(25097);
        if (i == 1) {
            bo.hideVKB(absListView);
        }
        AppMethodBeat.o(25097);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.i(25098);
        if (this.qBl == null || absListView == null || this.qBl.getHeight() <= 0 || this.iWA == null) {
            AppMethodBeat.o(25098);
            return;
        }
        int height = this.qBl.getHeight() - this.iWA.getSupportActionBar().getHeight();
        int i4 = -this.qBl.getTop();
        if (i4 < 0) {
            AppMethodBeat.o(25098);
            return;
        }
        this.qBk.setCameraShadowAlpha(((float) i4) / ((float) height));
        boolean z = this.qBl.getTop() < 0 && this.qBl.getTop() <= (-height);
        this.qBk.kD(z);
        AppMethodBeat.o(25098);
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(25091);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(25091);
            return false;
        }
        boolean contains = this.qBp.contains(aVar.ehM.field_username);
        AppMethodBeat.o(25091);
        return contains;
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(25092);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(25092);
            return false;
        }
        boolean contains = this.qBq.contains(aVar.ehM.field_username);
        AppMethodBeat.o(25092);
        return contains;
    }
}
