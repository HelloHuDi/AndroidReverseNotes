package com.tencent.p177mm.plugin.websearch.widget.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p057v4.app.C0336i;
import android.support.p057v4.app.C31856k;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.view.ViewPager;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p232b.p233a.C46877af;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.plugin.websearch.api.C29739g;
import com.tencent.p177mm.plugin.websearch.api.C29740h;
import com.tencent.p177mm.plugin.websearch.api.C29741i;
import com.tencent.p177mm.plugin.websearch.api.C29742q;
import com.tencent.p177mm.plugin.websearch.api.C29743y;
import com.tencent.p177mm.plugin.websearch.api.WidgetData;
import com.tencent.p177mm.plugin.websearch.widget.C40203d;
import com.tencent.p177mm.plugin.websearch.widget.C46409f;
import com.tencent.p177mm.plugin.websearch.widget.view.C43858b.C227798;
import com.tencent.p177mm.plugin.websearch.widget.view.C43858b.C297633;
import com.tencent.p177mm.plugin.websearch.widget.view.C43858b.C402096;
import com.tencent.p177mm.plugin.websearch.widget.view.C43858b.C40210a;
import com.tencent.p177mm.plugin.websearch.widget.view.C43858b.C438564;
import com.tencent.p177mm.plugin.websearch.widget.view.C43858b.C438575;
import com.tencent.p177mm.plugin.websearch.widget.view.C43858b.C438597;
import com.tencent.p177mm.plugin.websearch.widget.view.C43858b.C43860b;
import com.tencent.p177mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView */
public final class ServiceWidgetView implements C29741i {
    List<WidgetData> dataList;
    public MMActivity hwd;
    public LinearLayout jbJ;
    C29739g mJG;
    private int maxWidth;
    public View pqm;
    public ViewPager rap;
    public C14441a udF;
    List<C29743y> udG;
    C43860b udH = new C402061();

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView$a */
    public class C14441a extends C31856k {
        List<WidgetData> kFl = Collections.emptyList();
        private List<MyFragment> rdA = new ArrayList();

        public C14441a(C0336i c0336i) {
            super(c0336i);
            AppMethodBeat.m2504i(91491);
            AppMethodBeat.m2505o(91491);
        }

        /* renamed from: Iu */
        public final C43858b mo26693Iu(int i) {
            AppMethodBeat.m2504i(91492);
            if (i < 0 || i >= this.rdA.size()) {
                AppMethodBeat.m2505o(91492);
                return null;
            }
            C43858b c43858b = ((MyFragment) this.rdA.get(i)).udJ;
            AppMethodBeat.m2505o(91492);
            return c43858b;
        }

        public final int getItemPosition(Object obj) {
            AppMethodBeat.m2504i(91493);
            C43858b c43858b = ((MyFragment) obj).udJ;
            if (c43858b != null) {
                int indexOf = this.kFl.indexOf(c43858b.udY);
                if (indexOf >= 0) {
                    AppMethodBeat.m2505o(91493);
                    return indexOf;
                }
                AppMethodBeat.m2505o(91493);
                return -2;
            }
            AppMethodBeat.m2505o(91493);
            return -2;
        }

        public final Fragment getItem(final int i) {
            MyFragment myFragment;
            AppMethodBeat.m2504i(91494);
            if (i >= this.rdA.size()) {
                myFragment = new MyFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("data", (Parcelable) this.kFl.get(i));
                myFragment.setArguments(bundle);
                this.rdA.add(myFragment);
            } else {
                myFragment = (MyFragment) this.rdA.get(i);
            }
            C43858b c43858b = myFragment.udJ;
            MMActivity mMActivity = ServiceWidgetView.this.hwd;
            ServiceWidgetView serviceWidgetView = ServiceWidgetView.this;
            C43860b c43860b = ServiceWidgetView.this.udH;
            C144401 c144401 = new C40210a() {
                public final int cVV() {
                    AppMethodBeat.m2504i(91489);
                    if (C14441a.this.kFl == null) {
                        AppMethodBeat.m2505o(91489);
                        return 0;
                    }
                    int size = C14441a.this.kFl.size();
                    AppMethodBeat.m2505o(91489);
                    return size;
                }

                public final List<C29743y> cVW() {
                    return ServiceWidgetView.this.udG;
                }

                public final boolean cVX() {
                    return i > 0;
                }

                public final boolean hasNext() {
                    AppMethodBeat.m2504i(91490);
                    if (i < C14441a.this.kFl.size() - 1) {
                        AppMethodBeat.m2505o(91490);
                        return true;
                    }
                    AppMethodBeat.m2505o(91490);
                    return false;
                }
            };
            C29739g c29739g = ServiceWidgetView.this.mJG;
            WidgetData widgetData = (WidgetData) this.kFl.get(i);
            c43858b.hwd = mMActivity;
            c43858b.mJs = serviceWidgetView;
            c43858b.udH = c43860b;
            c43858b.udX = c144401;
            c43858b.mJG = c29739g;
            c43858b.udY = widgetData;
            if (i == ServiceWidgetView.this.rap.getCurrentItem()) {
                myFragment.udJ.setSelected(true);
            } else {
                myFragment.udJ.setSelected(false);
            }
            C4990ab.m7417i("ServiceWidgetView", "getItem %s, fragment %s", Integer.valueOf(i), myFragment.toString());
            AppMethodBeat.m2505o(91494);
            return myFragment;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(91495);
            if (this.kFl == null) {
                AppMethodBeat.m2505o(91495);
                return 0;
            }
            int size = this.kFl.size();
            AppMethodBeat.m2505o(91495);
            return size;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView$1 */
    class C402061 implements C43860b {
        C402061() {
        }

        /* renamed from: It */
        public final void mo63560It(int i) {
            AppMethodBeat.m2504i(91480);
            ServiceWidgetView.this.mo63557Iq(i);
            AppMethodBeat.m2505o(91480);
        }

        /* renamed from: a */
        public final void mo63561a(C43858b c43858b) {
            AppMethodBeat.m2504i(91481);
            if (c43858b == ServiceWidgetView.this.udF.mo26693Iu(ServiceWidgetView.this.rap.getCurrentItem())) {
                ServiceWidgetView.m68957a(ServiceWidgetView.this);
            }
            AppMethodBeat.m2505o(91481);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView$2 */
    public class C402072 implements OnPageChangeListener {
        public final void onPageScrolled(int i, float f, int i2) {
        }

        public final void onPageSelected(int i) {
            int i2 = 1;
            AppMethodBeat.m2504i(91482);
            C4990ab.m7417i("ServiceWidgetView", "opPageSelected %d", Integer.valueOf(i));
            ServiceWidgetView.this.mo63558Ir(i);
            ServiceWidgetView serviceWidgetView = ServiceWidgetView.this;
            for (int i3 = 0; i3 < serviceWidgetView.dataList.size(); i3++) {
                C43858b Iu = serviceWidgetView.udF.mo26693Iu(i3);
                if (Iu != null) {
                    boolean z;
                    if (i3 == serviceWidgetView.rap.getCurrentItem()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Iu.setSelected(z);
                }
            }
            ServiceWidgetView.this.udF.mo26693Iu(i).mo69542e((WidgetData) ServiceWidgetView.this.dataList.get(i));
            C43858b Iu2 = ServiceWidgetView.this.udF.mo26693Iu(i);
            if (Iu2.isLoading || Iu2.udZ != Iu2.udY) {
                i2 = 0;
            }
            if (i2 != 0) {
                ServiceWidgetView.m68957a(ServiceWidgetView.this);
            }
            ServiceWidgetView.this.mo63559Is(C1338a.fromDPToPix(ServiceWidgetView.this.hwd.mController.ylL, ((WidgetData) ServiceWidgetView.this.dataList.get(i)).ubt.height + 131));
            AppMethodBeat.m2505o(91482);
        }

        public final void onPageScrollStateChanged(int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView$MyFragment */
    public static class MyFragment extends Fragment {
        C43858b udJ = new C43858b();

        public MyFragment() {
            AppMethodBeat.m2504i(91484);
            AppMethodBeat.m2505o(91484);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            AppMethodBeat.m2504i(91485);
            C4990ab.m7417i("ServiceWidgetView", "onCreateView %s", toString());
            C43858b c43858b = this.udJ;
            c43858b.eAl = viewGroup;
            if (c43858b.udN == null) {
                if (c43858b.view == null) {
                    c43858b.view = LayoutInflater.from(c43858b.hwd.mController.ylL).inflate(2130970620, c43858b.eAl, false);
                    c43858b.udM = (LinearLayout) c43858b.view.findViewById(2131821064);
                    c43858b.udQ = c43858b.view.findViewById(2131825996);
                    c43858b.udL = c43858b.view.findViewById(2131827359);
                    c43858b.udT = (LinearLayout) c43858b.view.findViewById(2131827365);
                    c43858b.udU = (MoreFooter) c43858b.view.findViewById(2131827366);
                    c43858b.pNv = (TextView) c43858b.view.findViewById(2131822768);
                    c43858b.udR = c43858b.view.findViewById(2131827364);
                    c43858b.ueb = c43858b.view.findViewById(2131827358);
                    c43858b.uea = (ThreeDotsLoadingView) c43858b.view.findViewById(2131821325);
                    c43858b.uec = c43858b.view.findViewById(2131827362);
                    c43858b.udL.setVisibility(8);
                    c43858b.udM.setVisibility(8);
                    c43858b.cVZ();
                    c43858b.view.findViewById(2131827363).setOnClickListener(new C438564());
                    c43858b.view.findViewById(2131827361).setOnClickListener(new C438575());
                    c43858b.udM.setOnTouchListener(new C402096());
                    c43858b.udM.setOnClickListener(new C438597());
                    c43858b.udU.setOnClickLsn(c43858b.uee);
                    c43858b.pNv.setOnLongClickListener(new C227798());
                }
                c43858b.udN = ((C29740h) C1720g.m3528K(C29740h.class)).mo47979a(c43858b.eAl.getContext(), new C297633());
                c43858b.udN.cUS();
            }
            c43858b.mo69541cu();
            if (c43858b.gBF) {
                c43858b.cWa();
            }
            View view = this.udJ.view;
            AppMethodBeat.m2505o(91485);
            return view;
        }

        public void onResume() {
            AppMethodBeat.m2504i(91486);
            super.onResume();
            if (!(this.udJ == null || this.udJ.udY == null)) {
                this.udJ.onResume();
            }
            AppMethodBeat.m2505o(91486);
        }

        public void onPause() {
            AppMethodBeat.m2504i(91487);
            super.onPause();
            if (!(this.udJ == null || this.udJ.udY == null)) {
                this.udJ.onPause();
            }
            AppMethodBeat.m2505o(91487);
        }

        public void onDestroy() {
            AppMethodBeat.m2504i(91488);
            super.onDestroy();
            if (!(this.udJ == null || this.udJ.udY == null)) {
                this.udJ.onDestroy();
            }
            AppMethodBeat.m2505o(91488);
        }
    }

    public ServiceWidgetView(LinearLayout linearLayout, int i, Activity activity, C29739g c29739g) {
        AppMethodBeat.m2504i(91496);
        this.jbJ = linearLayout;
        this.hwd = (MMActivity) activity;
        this.maxWidth = i;
        this.mJG = c29739g;
        AppMethodBeat.m2505o(91496);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Ir */
    public final void mo63558Ir(int i) {
        AppMethodBeat.m2504i(91498);
        for (int i2 = 0; i2 < this.udG.size(); i2++) {
            C29743y c29743y = (C29743y) this.udG.get(i2);
            if (i2 == i) {
                c29743y.gBF = true;
            } else {
                c29743y.gBF = false;
            }
        }
        AppMethodBeat.m2505o(91498);
    }

    /* renamed from: c */
    public final void mo47982c(List<WidgetData> list, String str, String str2) {
        AppMethodBeat.m2504i(91499);
        this.dataList = list;
        if (list == null || list.isEmpty()) {
            mo63559Is(0);
            hide();
            cVU();
            AppMethodBeat.m2505o(91499);
            return;
        }
        WidgetData widgetData;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            widgetData = (WidgetData) it.next();
            C40203d.cVP();
            if (!C40203d.m68949a(widgetData)) {
                C4990ab.m7417i("ServiceWidgetView", "widget forbidden %s", widgetData);
                it.remove();
            }
        }
        if (list.isEmpty()) {
            mo63559Is(0);
            hide();
            cVU();
            AppMethodBeat.m2505o(91499);
            return;
        }
        int i;
        this.dataList = list;
        for (WidgetData widgetData2 : list) {
            if (widgetData2 != null) {
                widgetData2.ubv = str;
                widgetData2.query = str2;
                i = widgetData2.ubt.width;
                if (i != this.maxWidth) {
                    widgetData2.ubt.width = this.maxWidth;
                    widgetData2.ubt.height = (widgetData2.ubt.height * this.maxWidth) / i;
                    widgetData2.ubt.ubI = (widgetData2.ubt.ubI * this.maxWidth) / i;
                }
            }
        }
        C4990ab.m7417i("ServiceWidgetView", "update with %s", list);
        this.udF.kFl = list;
        this.udF.notifyDataSetChanged();
        if (this.udG == null) {
            this.udG = new ArrayList();
        }
        this.udG.clear();
        for (i = 0; i < this.dataList.size(); i++) {
            widgetData2 = (WidgetData) this.dataList.get(i);
            if (widgetData2 != null) {
                boolean z;
                C29743y c29743y = new C29743y();
                c29743y.iconUrl = widgetData2.ubs.iconUrl;
                c29743y.title = widgetData2.ubs.bCu;
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                c29743y.gBF = z;
                c29743y.desc = widgetData2.ubs.label;
                this.udG.add(c29743y);
            }
        }
        this.rap.setCurrentItem(0, false);
        for (int i2 = 0; i2 < list.size(); i2++) {
            C43858b Iu = this.udF.mo26693Iu(i2);
            if (Iu != null) {
                Iu.mo69542e((WidgetData) this.dataList.get(i2));
            }
        }
        mo63559Is(C1338a.fromDPToPix(this.hwd.mController.ylL, ((WidgetData) this.dataList.get(0)).ubt.height + 131));
        AppMethodBeat.m2505o(91499);
    }

    private void cVU() {
        AppMethodBeat.m2504i(91500);
        for (int i = 0; i < this.udF.getCount(); i++) {
            C43858b Iu = this.udF.mo26693Iu(i);
            if (Iu != null) {
                Iu.bcM();
            }
        }
        AppMethodBeat.m2505o(91500);
    }

    public final void cUT() {
        AppMethodBeat.m2504i(91501);
        mo63557Iq(this.rap.getCurrentItem() + 1);
        AppMethodBeat.m2505o(91501);
    }

    public final void cUU() {
        AppMethodBeat.m2504i(91502);
        this.rap.setCurrentItem(this.rap.getCurrentItem() - 1);
        AppMethodBeat.m2505o(91502);
    }

    /* renamed from: a */
    public final void mo47981a(final int i, C29742q c29742q) {
        AppMethodBeat.m2504i(91503);
        if (c29742q == this.udF.mo26693Iu(this.rap.getCurrentItem()) && i != this.rap.getHeight()) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(91483);
                    ServiceWidgetView.this.mo63559Is(i);
                    AppMethodBeat.m2505o(91483);
                }
            });
        }
        AppMethodBeat.m2505o(91503);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Is */
    public final void mo63559Is(int i) {
        AppMethodBeat.m2504i(91504);
        C4990ab.m7417i("ServiceWidgetView", "update viewpager height %d", Integer.valueOf(i));
        WidgetData widgetData = (WidgetData) this.dataList.get(this.rap.getCurrentItem());
        if (!(widgetData == null || widgetData.ubs.ubE)) {
            i -= C1338a.fromDPToPix(this.hwd.mController.ylL, 46);
        }
        LayoutParams layoutParams = (LayoutParams) this.rap.getLayoutParams();
        layoutParams.height = i;
        this.rap.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(91504);
    }

    public final void hide() {
        AppMethodBeat.m2504i(91505);
        this.jbJ.setVisibility(8);
        this.pqm.setVisibility(8);
        C43858b Iu = this.udF.mo26693Iu(this.rap.getCurrentItem());
        if (!(Iu == null || Iu.udY == null)) {
            Iu.hide();
        }
        AppMethodBeat.m2505o(91505);
    }

    public final void show() {
        AppMethodBeat.m2504i(91506);
        if (this.dataList == null || this.dataList.isEmpty()) {
            AppMethodBeat.m2505o(91506);
            return;
        }
        this.pqm.setVisibility(0);
        this.jbJ.setVisibility(0);
        C43858b Iu = this.udF.mo26693Iu(this.rap.getCurrentItem());
        if (!(Iu == null || Iu.udY == null || !Iu.gBF)) {
            Iu.onResume();
        }
        AppMethodBeat.m2505o(91506);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(91507);
        C43858b Iu = this.udF.mo26693Iu(this.rap.getCurrentItem());
        if (!(Iu == null || Iu.udY == null)) {
            Iu.onResume();
        }
        AppMethodBeat.m2505o(91507);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(91508);
        C43858b Iu = this.udF.mo26693Iu(this.rap.getCurrentItem());
        if (!(Iu == null || Iu.udY == null)) {
            Iu.onPause();
        }
        AppMethodBeat.m2505o(91508);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(91509);
        C43858b Iu = this.udF.mo26693Iu(this.rap.getCurrentItem());
        if (!(Iu == null || Iu.udY == null)) {
            Iu.onDestroy();
        }
        this.jbJ = null;
        this.hwd = null;
        AppMethodBeat.m2505o(91509);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Iq */
    public final void mo63557Iq(int i) {
        AppMethodBeat.m2504i(91497);
        WidgetData widgetData = (WidgetData) this.dataList.get(this.rap.getCurrentItem());
        if (i < 0 || i > this.dataList.size() - 1) {
            C46409f.m87355a(3, widgetData, null);
            AppMethodBeat.m2505o(91497);
            return;
        }
        C46409f.m87355a(2, widgetData, (WidgetData) this.dataList.get(i));
        if (i == this.dataList.indexOf(widgetData)) {
            C46877af fi = new C46877af().mo76050fh(widgetData.ubs.fpS).mo76051fi(widgetData.ubs.fpS);
            fi.cYE = 0;
            fi.mo76048ff(widgetData.query).mo76049fg(widgetData.ubv).ajK();
            AppMethodBeat.m2505o(91497);
            return;
        }
        C4990ab.m7417i("ServiceWidgetView", "switch widget to %d", Integer.valueOf(i));
        WidgetData widgetData2 = (WidgetData) this.dataList.get(i);
        C46877af fi2 = new C46877af().mo76050fh(widgetData.ubs.fpS).mo76051fi(widgetData2.ubs.fpS);
        fi2.cYE = 1;
        fi2.mo76048ff(widgetData2.query).mo76049fg(widgetData2.ubv).ajK();
        this.rap.setCurrentItem(i, true);
        mo63558Ir(i);
        AppMethodBeat.m2505o(91497);
    }

    /* renamed from: a */
    static /* synthetic */ void m68957a(ServiceWidgetView serviceWidgetView) {
        AppMethodBeat.m2504i(91510);
        C43858b Iu = serviceWidgetView.udF.mo26693Iu((serviceWidgetView.rap.getCurrentItem() + 1) % serviceWidgetView.udF.getCount());
        if (Iu != null) {
            if (Iu.udN != null) {
                Iu.udN.onResume();
            }
            Iu.cWa();
        }
        AppMethodBeat.m2505o(91510);
    }
}
