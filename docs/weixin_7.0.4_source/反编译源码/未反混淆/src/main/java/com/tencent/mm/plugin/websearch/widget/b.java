package com.tencent.mm.plugin.websearch.widget;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.g;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView;
import com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView.a;
import com.tencent.mm.plugin.websearch.widget.view.a.AnonymousClass1;
import com.tencent.mm.plugin.websearch.widget.view.a.AnonymousClass2;
import com.tencent.mm.plugin.websearch.widget.view.a.AnonymousClass3;
import com.tencent.mm.plugin.websearch.widget.view.a.AnonymousClass4;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

public final class b implements h {
    public final f a(Context context, r rVar) {
        AppMethodBeat.i(91428);
        a aVar = new a(context, rVar);
        AppMethodBeat.o(91428);
        return aVar;
    }

    public final i a(LinearLayout linearLayout, int i, Activity activity, g gVar) {
        AppMethodBeat.i(91429);
        ServiceWidgetView serviceWidgetView = new ServiceWidgetView(linearLayout, i, activity, gVar);
        View inflate = LinearLayout.inflate(serviceWidgetView.jbJ.getContext(), R.layout.arf, serviceWidgetView.jbJ);
        serviceWidgetView.pqm = inflate.findViewById(R.id.e9f);
        serviceWidgetView.rap = (ViewPager) inflate.findViewById(R.id.bns);
        serviceWidgetView.udF = new a(serviceWidgetView.hwd.getSupportFragmentManager());
        serviceWidgetView.rap.setAdapter(serviceWidgetView.udF);
        serviceWidgetView.rap.setOffscreenPageLimit(0);
        serviceWidgetView.rap.addOnPageChangeListener(new OnPageChangeListener() {
            public final void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageSelected(int i) {
                int i2 = 1;
                AppMethodBeat.i(91482);
                ab.i("ServiceWidgetView", "opPageSelected %d", Integer.valueOf(i));
                ServiceWidgetView.this.Ir(i);
                ServiceWidgetView serviceWidgetView = ServiceWidgetView.this;
                for (int i3 = 0; i3 < serviceWidgetView.dataList.size(); i3++) {
                    b Iu = serviceWidgetView.udF.Iu(i3);
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
                ServiceWidgetView.this.udF.Iu(i).e((WidgetData) ServiceWidgetView.this.dataList.get(i));
                b Iu2 = ServiceWidgetView.this.udF.Iu(i);
                if (Iu2.isLoading || Iu2.udZ != Iu2.udY) {
                    i2 = 0;
                }
                if (i2 != 0) {
                    ServiceWidgetView.a(ServiceWidgetView.this);
                }
                ServiceWidgetView.this.Is(com.tencent.mm.bz.a.fromDPToPix(ServiceWidgetView.this.hwd.mController.ylL, ((WidgetData) ServiceWidgetView.this.dataList.get(i)).ubt.height + 131));
                AppMethodBeat.o(91482);
            }

            public final void onPageScrollStateChanged(int i) {
            }
        });
        AppMethodBeat.o(91429);
        return serviceWidgetView;
    }

    public final int a(Activity activity, String str, String str2, List<y> list, x xVar) {
        AppMethodBeat.i(91430);
        com.tencent.mm.plugin.websearch.widget.view.a cVT = com.tencent.mm.plugin.websearch.widget.view.a.cVT();
        d dVar = new d(activity, 2, true);
        int hashCode = dVar.hashCode();
        dVar.zFT = new AnonymousClass1(list);
        dVar.rBl = new AnonymousClass2(list, dVar);
        dVar.rBm = new AnonymousClass3(xVar, hashCode);
        dVar.zQf = new AnonymousClass4(xVar, hashCode);
        View inflate = View.inflate(activity, R.layout.apw, null);
        if (TextUtils.isEmpty(str)) {
            inflate.findViewById(R.id.cx).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(R.id.cx)).setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            inflate.findViewById(R.id.s9).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(R.id.s9)).setText(str2);
        }
        dVar.zQy = true;
        dVar.F(inflate, false);
        dVar.cpD();
        cVT.udA.put(Integer.valueOf(hashCode), dVar);
        AppMethodBeat.o(91430);
        return hashCode;
    }
}
