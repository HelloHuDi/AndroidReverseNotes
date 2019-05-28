package com.tencent.mm.plugin.websearch.widget.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.g;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.q;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.widget.f;
import com.tencent.mm.plugin.websearch.widget.view.b.b;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ServiceWidgetView implements i {
    List<WidgetData> dataList;
    public MMActivity hwd;
    public LinearLayout jbJ;
    g mJG;
    private int maxWidth;
    public View pqm;
    public ViewPager rap;
    public a udF;
    List<y> udG;
    b udH = new b() {
        public final void It(int i) {
            AppMethodBeat.i(91480);
            ServiceWidgetView.this.Iq(i);
            AppMethodBeat.o(91480);
        }

        public final void a(b bVar) {
            AppMethodBeat.i(91481);
            if (bVar == ServiceWidgetView.this.udF.Iu(ServiceWidgetView.this.rap.getCurrentItem())) {
                ServiceWidgetView.a(ServiceWidgetView.this);
            }
            AppMethodBeat.o(91481);
        }
    };

    public class a extends k {
        List<WidgetData> kFl = Collections.emptyList();
        private List<MyFragment> rdA = new ArrayList();

        public a(android.support.v4.app.i iVar) {
            super(iVar);
            AppMethodBeat.i(91491);
            AppMethodBeat.o(91491);
        }

        public final b Iu(int i) {
            AppMethodBeat.i(91492);
            if (i < 0 || i >= this.rdA.size()) {
                AppMethodBeat.o(91492);
                return null;
            }
            b bVar = ((MyFragment) this.rdA.get(i)).udJ;
            AppMethodBeat.o(91492);
            return bVar;
        }

        public final int getItemPosition(Object obj) {
            AppMethodBeat.i(91493);
            b bVar = ((MyFragment) obj).udJ;
            if (bVar != null) {
                int indexOf = this.kFl.indexOf(bVar.udY);
                if (indexOf >= 0) {
                    AppMethodBeat.o(91493);
                    return indexOf;
                }
                AppMethodBeat.o(91493);
                return -2;
            }
            AppMethodBeat.o(91493);
            return -2;
        }

        public final Fragment getItem(final int i) {
            MyFragment myFragment;
            AppMethodBeat.i(91494);
            if (i >= this.rdA.size()) {
                myFragment = new MyFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("data", (Parcelable) this.kFl.get(i));
                myFragment.setArguments(bundle);
                this.rdA.add(myFragment);
            } else {
                myFragment = (MyFragment) this.rdA.get(i);
            }
            b bVar = myFragment.udJ;
            MMActivity mMActivity = ServiceWidgetView.this.hwd;
            ServiceWidgetView serviceWidgetView = ServiceWidgetView.this;
            b bVar2 = ServiceWidgetView.this.udH;
            AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.websearch.widget.view.b.a() {
                public final int cVV() {
                    AppMethodBeat.i(91489);
                    if (a.this.kFl == null) {
                        AppMethodBeat.o(91489);
                        return 0;
                    }
                    int size = a.this.kFl.size();
                    AppMethodBeat.o(91489);
                    return size;
                }

                public final List<y> cVW() {
                    return ServiceWidgetView.this.udG;
                }

                public final boolean cVX() {
                    return i > 0;
                }

                public final boolean hasNext() {
                    AppMethodBeat.i(91490);
                    if (i < a.this.kFl.size() - 1) {
                        AppMethodBeat.o(91490);
                        return true;
                    }
                    AppMethodBeat.o(91490);
                    return false;
                }
            };
            g gVar = ServiceWidgetView.this.mJG;
            WidgetData widgetData = (WidgetData) this.kFl.get(i);
            bVar.hwd = mMActivity;
            bVar.mJs = serviceWidgetView;
            bVar.udH = bVar2;
            bVar.udX = anonymousClass1;
            bVar.mJG = gVar;
            bVar.udY = widgetData;
            if (i == ServiceWidgetView.this.rap.getCurrentItem()) {
                myFragment.udJ.setSelected(true);
            } else {
                myFragment.udJ.setSelected(false);
            }
            ab.i("ServiceWidgetView", "getItem %s, fragment %s", Integer.valueOf(i), myFragment.toString());
            AppMethodBeat.o(91494);
            return myFragment;
        }

        public final int getCount() {
            AppMethodBeat.i(91495);
            if (this.kFl == null) {
                AppMethodBeat.o(91495);
                return 0;
            }
            int size = this.kFl.size();
            AppMethodBeat.o(91495);
            return size;
        }
    }

    public static class MyFragment extends Fragment {
        b udJ = new b();

        public MyFragment() {
            AppMethodBeat.i(91484);
            AppMethodBeat.o(91484);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            AppMethodBeat.i(91485);
            ab.i("ServiceWidgetView", "onCreateView %s", toString());
            b bVar = this.udJ;
            bVar.eAl = viewGroup;
            if (bVar.udN == null) {
                if (bVar.view == null) {
                    bVar.view = LayoutInflater.from(bVar.hwd.mController.ylL).inflate(R.layout.are, bVar.eAl, false);
                    bVar.udM = (LinearLayout) bVar.view.findViewById(R.id.nc);
                    bVar.udQ = bVar.view.findViewById(R.id.d9d);
                    bVar.udL = bVar.view.findViewById(R.id.e98);
                    bVar.udT = (LinearLayout) bVar.view.findViewById(R.id.e9d);
                    bVar.udU = (MoreFooter) bVar.view.findViewById(R.id.e9e);
                    bVar.pNv = (TextView) bVar.view.findViewById(R.id.aw4);
                    bVar.udR = bVar.view.findViewById(R.id.e9c);
                    bVar.ueb = bVar.view.findViewById(R.id.e97);
                    bVar.uea = (ThreeDotsLoadingView) bVar.view.findViewById(R.id.ue);
                    bVar.uec = bVar.view.findViewById(R.id.e9a);
                    bVar.udL.setVisibility(8);
                    bVar.udM.setVisibility(8);
                    bVar.cVZ();
                    bVar.view.findViewById(R.id.e9b).setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(91529);
                            b.b(b.this);
                            AppMethodBeat.o(91529);
                        }
                    });
                    bVar.view.findViewById(R.id.e9_).setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(91530);
                            b.c(b.this);
                            AppMethodBeat.o(91530);
                        }
                    });
                    bVar.udM.setOnTouchListener(new OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(91531);
                            b.this.udV[0] = motionEvent.getX();
                            b.this.udV[1] = motionEvent.getY();
                            AppMethodBeat.o(91531);
                            return false;
                        }
                    });
                    bVar.udM.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(91532);
                            b.this.udP = "tap_" + System.currentTimeMillis();
                            int i = (int) b.this.udV[0];
                            int i2 = (int) b.this.udV[1];
                            if (i < 2) {
                                i = 2;
                            }
                            if (i2 < 2) {
                                i2 = 2;
                            }
                            if (i2 > b.this.udM.getHeight() - 2) {
                                i2 = b.this.udM.getHeight() - 2;
                            }
                            b.this.udN.f(com.tencent.mm.plugin.appbrand.r.g.qa(i), com.tencent.mm.plugin.appbrand.r.g.qa(i2), b.this.udO, b.this.udP);
                            b.this.iv(false);
                            u.i("WidgetView", "tap event id %s, location x %f, y %f", b.this.udP, Float.valueOf(b.this.udV[0]), Float.valueOf(b.this.udV[1]));
                            AppMethodBeat.o(91532);
                        }
                    });
                    bVar.udU.setOnClickLsn(bVar.uee);
                    bVar.pNv.setOnLongClickListener(new OnLongClickListener() {
                        public final boolean onLongClick(View view) {
                            AppMethodBeat.i(91535);
                            if (b.this.udY != null && bp.dpL()) {
                                Context context = b.this.eAl.getContext();
                                AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.websearch.widget.b.a.a() {
                                    public final void cVR() {
                                        AppMethodBeat.i(91533);
                                        b.this.udN.adD(b.this.udO);
                                        AppMethodBeat.o(91533);
                                    }

                                    public final void cUT() {
                                        AppMethodBeat.i(91534);
                                        b.this.mJs.cUT();
                                        AppMethodBeat.o(91534);
                                    }
                                };
                                d dVar = new d(context, 2, true);
                                dVar.q("当前服务为体验版本，可以选择以下调试功能", 48);
                                dVar.rBl = new c() {
                                    public final void a(l lVar) {
                                        AppMethodBeat.i(91459);
                                        lVar.e(0, "打开调试");
                                        lVar.e(1, "切换服务提供商");
                                        AppMethodBeat.o(91459);
                                    }
                                };
                                dVar.rBm = new com.tencent.mm.plugin.websearch.widget.b.a.AnonymousClass2(anonymousClass1);
                                dVar.cpD();
                            }
                            AppMethodBeat.o(91535);
                            return true;
                        }
                    });
                }
                bVar.udN = ((h) com.tencent.mm.kernel.g.K(h.class)).a(bVar.eAl.getContext(), new r() {
                    public final void addView(View view) {
                        AppMethodBeat.i(91519);
                        b.this.udM.removeAllViews();
                        b.this.udM.addView(view);
                        AppMethodBeat.o(91519);
                    }

                    public final void removeView(View view) {
                        AppMethodBeat.i(91520);
                        b.this.udM.removeAllViews();
                        AppMethodBeat.o(91520);
                    }

                    public final void dw(String str, int i) {
                        AppMethodBeat.i(91521);
                        if (i == 3) {
                            if (b.this.isRetry) {
                                b.this.udL.setVisibility(8);
                                b.this.udM.setVisibility(8);
                                b.this.uec.setVisibility(0);
                                b.this.udR.setVisibility(8);
                            } else {
                                b.this.udL.setVisibility(0);
                                b.this.udM.setVisibility(8);
                                b.this.udR.setVisibility(8);
                            }
                        }
                        if (i != 1) {
                            b.this.isLoading = false;
                            if (b.this.udH != null) {
                                b.this.udH.a(b.this);
                            }
                            if (!b.this.gBF) {
                                b.this.udN.onPause();
                            }
                        }
                        AppMethodBeat.o(91521);
                    }

                    public final void g(String str, boolean z, String str2) {
                        AppMethodBeat.i(91522);
                        a(str, z, "", str2);
                        AppMethodBeat.o(91522);
                    }

                    public final void a(String str, boolean z, String str2, String str3) {
                        AppMethodBeat.i(91523);
                        u.i("WidgetView", "on tap callback eventId %s, consume %b, errMsg %s", str, Boolean.valueOf(z), str2);
                        if (str3.equals(b.this.udO) && str.equals(b.this.udP)) {
                            if (z) {
                                ab.i("WidgetView", "click event %s consumed by widget", b.this.udP);
                            } else {
                                b.b(b.this);
                            }
                            b.this.udP = null;
                        }
                        AppMethodBeat.o(91523);
                    }

                    public final void adG(String str) {
                        AppMethodBeat.i(91524);
                        if (str.equals(b.this.udO)) {
                            b.c(b.this);
                        }
                        AppMethodBeat.o(91524);
                    }

                    public final void gS(String str, String str2) {
                        AppMethodBeat.i(91525);
                        ab.i("WidgetView", "onSearchWAWidgetDataPush %s", str);
                        AppMethodBeat.o(91525);
                    }

                    public final void g(String str, String str2, String str3, int i) {
                        AppMethodBeat.i(91526);
                        if (str.equals(b.this.udO)) {
                            b.this.K(str2, str3, i);
                            AppMethodBeat.o(91526);
                            return;
                        }
                        ab.e("WidgetView", "callback for expired widget %s", str);
                        AppMethodBeat.o(91526);
                    }

                    public final void dx(String str, int i) {
                        AppMethodBeat.i(91527);
                        b.this.udY.ubt.height = i;
                        b.this.udN.a(b.this.udY, b.this.udO);
                        b.this.mJs.a(com.tencent.mm.bz.a.fromDPToPix(b.this.hwd.mController.ylL, i + 131), b.this);
                        AppMethodBeat.o(91527);
                    }

                    public final void cUV() {
                        AppMethodBeat.i(91528);
                        b.c(b.this);
                        AppMethodBeat.o(91528);
                    }
                });
                bVar.udN.cUS();
            }
            bVar.cu();
            if (bVar.gBF) {
                bVar.cWa();
            }
            View view = this.udJ.view;
            AppMethodBeat.o(91485);
            return view;
        }

        public void onResume() {
            AppMethodBeat.i(91486);
            super.onResume();
            if (!(this.udJ == null || this.udJ.udY == null)) {
                this.udJ.onResume();
            }
            AppMethodBeat.o(91486);
        }

        public void onPause() {
            AppMethodBeat.i(91487);
            super.onPause();
            if (!(this.udJ == null || this.udJ.udY == null)) {
                this.udJ.onPause();
            }
            AppMethodBeat.o(91487);
        }

        public void onDestroy() {
            AppMethodBeat.i(91488);
            super.onDestroy();
            if (!(this.udJ == null || this.udJ.udY == null)) {
                this.udJ.onDestroy();
            }
            AppMethodBeat.o(91488);
        }
    }

    public ServiceWidgetView(LinearLayout linearLayout, int i, Activity activity, g gVar) {
        AppMethodBeat.i(91496);
        this.jbJ = linearLayout;
        this.hwd = (MMActivity) activity;
        this.maxWidth = i;
        this.mJG = gVar;
        AppMethodBeat.o(91496);
    }

    /* Access modifiers changed, original: final */
    public final void Ir(int i) {
        AppMethodBeat.i(91498);
        for (int i2 = 0; i2 < this.udG.size(); i2++) {
            y yVar = (y) this.udG.get(i2);
            if (i2 == i) {
                yVar.gBF = true;
            } else {
                yVar.gBF = false;
            }
        }
        AppMethodBeat.o(91498);
    }

    public final void c(List<WidgetData> list, String str, String str2) {
        AppMethodBeat.i(91499);
        this.dataList = list;
        if (list == null || list.isEmpty()) {
            Is(0);
            hide();
            cVU();
            AppMethodBeat.o(91499);
            return;
        }
        WidgetData widgetData;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            widgetData = (WidgetData) it.next();
            com.tencent.mm.plugin.websearch.widget.d.cVP();
            if (!com.tencent.mm.plugin.websearch.widget.d.a(widgetData)) {
                ab.i("ServiceWidgetView", "widget forbidden %s", widgetData);
                it.remove();
            }
        }
        if (list.isEmpty()) {
            Is(0);
            hide();
            cVU();
            AppMethodBeat.o(91499);
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
        ab.i("ServiceWidgetView", "update with %s", list);
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
                y yVar = new y();
                yVar.iconUrl = widgetData2.ubs.iconUrl;
                yVar.title = widgetData2.ubs.bCu;
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                yVar.gBF = z;
                yVar.desc = widgetData2.ubs.label;
                this.udG.add(yVar);
            }
        }
        this.rap.setCurrentItem(0, false);
        for (int i2 = 0; i2 < list.size(); i2++) {
            b Iu = this.udF.Iu(i2);
            if (Iu != null) {
                Iu.e((WidgetData) this.dataList.get(i2));
            }
        }
        Is(com.tencent.mm.bz.a.fromDPToPix(this.hwd.mController.ylL, ((WidgetData) this.dataList.get(0)).ubt.height + 131));
        AppMethodBeat.o(91499);
    }

    private void cVU() {
        AppMethodBeat.i(91500);
        for (int i = 0; i < this.udF.getCount(); i++) {
            b Iu = this.udF.Iu(i);
            if (Iu != null) {
                Iu.bcM();
            }
        }
        AppMethodBeat.o(91500);
    }

    public final void cUT() {
        AppMethodBeat.i(91501);
        Iq(this.rap.getCurrentItem() + 1);
        AppMethodBeat.o(91501);
    }

    public final void cUU() {
        AppMethodBeat.i(91502);
        this.rap.setCurrentItem(this.rap.getCurrentItem() - 1);
        AppMethodBeat.o(91502);
    }

    public final void a(final int i, q qVar) {
        AppMethodBeat.i(91503);
        if (qVar == this.udF.Iu(this.rap.getCurrentItem()) && i != this.rap.getHeight()) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(91483);
                    ServiceWidgetView.this.Is(i);
                    AppMethodBeat.o(91483);
                }
            });
        }
        AppMethodBeat.o(91503);
    }

    /* Access modifiers changed, original: final */
    public final void Is(int i) {
        AppMethodBeat.i(91504);
        ab.i("ServiceWidgetView", "update viewpager height %d", Integer.valueOf(i));
        WidgetData widgetData = (WidgetData) this.dataList.get(this.rap.getCurrentItem());
        if (!(widgetData == null || widgetData.ubs.ubE)) {
            i -= com.tencent.mm.bz.a.fromDPToPix(this.hwd.mController.ylL, 46);
        }
        LayoutParams layoutParams = (LayoutParams) this.rap.getLayoutParams();
        layoutParams.height = i;
        this.rap.setLayoutParams(layoutParams);
        AppMethodBeat.o(91504);
    }

    public final void hide() {
        AppMethodBeat.i(91505);
        this.jbJ.setVisibility(8);
        this.pqm.setVisibility(8);
        b Iu = this.udF.Iu(this.rap.getCurrentItem());
        if (!(Iu == null || Iu.udY == null)) {
            Iu.hide();
        }
        AppMethodBeat.o(91505);
    }

    public final void show() {
        AppMethodBeat.i(91506);
        if (this.dataList == null || this.dataList.isEmpty()) {
            AppMethodBeat.o(91506);
            return;
        }
        this.pqm.setVisibility(0);
        this.jbJ.setVisibility(0);
        b Iu = this.udF.Iu(this.rap.getCurrentItem());
        if (!(Iu == null || Iu.udY == null || !Iu.gBF)) {
            Iu.onResume();
        }
        AppMethodBeat.o(91506);
    }

    public final void onResume() {
        AppMethodBeat.i(91507);
        b Iu = this.udF.Iu(this.rap.getCurrentItem());
        if (!(Iu == null || Iu.udY == null)) {
            Iu.onResume();
        }
        AppMethodBeat.o(91507);
    }

    public final void onPause() {
        AppMethodBeat.i(91508);
        b Iu = this.udF.Iu(this.rap.getCurrentItem());
        if (!(Iu == null || Iu.udY == null)) {
            Iu.onPause();
        }
        AppMethodBeat.o(91508);
    }

    public final void onDestroy() {
        AppMethodBeat.i(91509);
        b Iu = this.udF.Iu(this.rap.getCurrentItem());
        if (!(Iu == null || Iu.udY == null)) {
            Iu.onDestroy();
        }
        this.jbJ = null;
        this.hwd = null;
        AppMethodBeat.o(91509);
    }

    /* Access modifiers changed, original: final */
    public final void Iq(int i) {
        AppMethodBeat.i(91497);
        WidgetData widgetData = (WidgetData) this.dataList.get(this.rap.getCurrentItem());
        if (i < 0 || i > this.dataList.size() - 1) {
            f.a(3, widgetData, null);
            AppMethodBeat.o(91497);
            return;
        }
        f.a(2, widgetData, (WidgetData) this.dataList.get(i));
        if (i == this.dataList.indexOf(widgetData)) {
            af fi = new af().fh(widgetData.ubs.fpS).fi(widgetData.ubs.fpS);
            fi.cYE = 0;
            fi.ff(widgetData.query).fg(widgetData.ubv).ajK();
            AppMethodBeat.o(91497);
            return;
        }
        ab.i("ServiceWidgetView", "switch widget to %d", Integer.valueOf(i));
        WidgetData widgetData2 = (WidgetData) this.dataList.get(i);
        af fi2 = new af().fh(widgetData.ubs.fpS).fi(widgetData2.ubs.fpS);
        fi2.cYE = 1;
        fi2.ff(widgetData2.query).fg(widgetData2.ubv).ajK();
        this.rap.setCurrentItem(i, true);
        Ir(i);
        AppMethodBeat.o(91497);
    }

    static /* synthetic */ void a(ServiceWidgetView serviceWidgetView) {
        AppMethodBeat.i(91510);
        b Iu = serviceWidgetView.udF.Iu((serviceWidgetView.rap.getCurrentItem() + 1) % serviceWidgetView.udF.getCount());
        if (Iu != null) {
            if (Iu.udN != null) {
                Iu.udN.onResume();
            }
            Iu.cWa();
        }
        AppMethodBeat.o(91510);
    }
}
