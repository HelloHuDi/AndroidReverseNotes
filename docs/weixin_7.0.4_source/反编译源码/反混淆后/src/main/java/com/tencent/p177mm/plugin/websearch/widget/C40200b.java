package com.tencent.p177mm.plugin.websearch.widget;

import android.app.Activity;
import android.content.Context;
import android.support.p057v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.websearch.api.C14427x;
import com.tencent.p177mm.plugin.websearch.api.C22759r;
import com.tencent.p177mm.plugin.websearch.api.C29739g;
import com.tencent.p177mm.plugin.websearch.api.C29740h;
import com.tencent.p177mm.plugin.websearch.api.C29741i;
import com.tencent.p177mm.plugin.websearch.api.C29743y;
import com.tencent.p177mm.plugin.websearch.api.C40192f;
import com.tencent.p177mm.plugin.websearch.widget.view.C43855a;
import com.tencent.p177mm.plugin.websearch.widget.view.C43855a.C144421;
import com.tencent.p177mm.plugin.websearch.widget.view.C43855a.C169234;
import com.tencent.p177mm.plugin.websearch.widget.view.C43855a.C297612;
import com.tencent.p177mm.plugin.websearch.widget.view.C43855a.C297623;
import com.tencent.p177mm.plugin.websearch.widget.view.ServiceWidgetView;
import com.tencent.p177mm.plugin.websearch.widget.view.ServiceWidgetView.C14441a;
import com.tencent.p177mm.plugin.websearch.widget.view.ServiceWidgetView.C402072;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.websearch.widget.b */
public final class C40200b implements C29740h {
    /* renamed from: a */
    public final C40192f mo47979a(Context context, C22759r c22759r) {
        AppMethodBeat.m2504i(91428);
        C29750a c29750a = new C29750a(context, c22759r);
        AppMethodBeat.m2505o(91428);
        return c29750a;
    }

    /* renamed from: a */
    public final C29741i mo47980a(LinearLayout linearLayout, int i, Activity activity, C29739g c29739g) {
        AppMethodBeat.m2504i(91429);
        ServiceWidgetView serviceWidgetView = new ServiceWidgetView(linearLayout, i, activity, c29739g);
        View inflate = LinearLayout.inflate(serviceWidgetView.jbJ.getContext(), 2130970621, serviceWidgetView.jbJ);
        serviceWidgetView.pqm = inflate.findViewById(2131827367);
        serviceWidgetView.rap = (ViewPager) inflate.findViewById(2131823829);
        serviceWidgetView.udF = new C14441a(serviceWidgetView.hwd.getSupportFragmentManager());
        serviceWidgetView.rap.setAdapter(serviceWidgetView.udF);
        serviceWidgetView.rap.setOffscreenPageLimit(0);
        serviceWidgetView.rap.addOnPageChangeListener(new C402072());
        AppMethodBeat.m2505o(91429);
        return serviceWidgetView;
    }

    /* renamed from: a */
    public final int mo47978a(Activity activity, String str, String str2, List<C29743y> list, C14427x c14427x) {
        AppMethodBeat.m2504i(91430);
        C43855a cVT = C43855a.cVT();
        C36356d c36356d = new C36356d(activity, 2, true);
        int hashCode = c36356d.hashCode();
        c36356d.zFT = new C144421(list);
        c36356d.rBl = new C297612(list, c36356d);
        c36356d.rBm = new C297623(c14427x, hashCode);
        c36356d.zQf = new C169234(c14427x, hashCode);
        View inflate = View.inflate(activity, 2130970564, null);
        if (TextUtils.isEmpty(str)) {
            inflate.findViewById(2131820678).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(2131820678)).setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            inflate.findViewById(2131821245).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(2131821245)).setText(str2);
        }
        c36356d.zQy = true;
        c36356d.mo57234F(inflate, false);
        c36356d.cpD();
        cVT.udA.put(Integer.valueOf(hashCode), c36356d);
        AppMethodBeat.m2505o(91430);
        return hashCode;
    }
}
