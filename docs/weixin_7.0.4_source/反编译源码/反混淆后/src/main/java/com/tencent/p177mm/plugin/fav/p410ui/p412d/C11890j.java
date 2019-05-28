package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l.C207472;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.j */
public final class C11890j extends C20714a {
    private final int moM;
    private HashMap<String, SpannableString> mpj = new HashMap();

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.j$a */
    public static class C11891a extends C3084b {
        ImageView iqT;
        ImageView moY;
        ImageView mpk;
        TextView mpl;
        TextView mpm;
        TextView mpn;
        TextView mpo;
        FrameLayout mpp;
    }

    public C11890j(C45939l c45939l) {
        super(c45939l);
        AppMethodBeat.m2504i(74639);
        this.moM = C1338a.m2856al(c45939l.context, C25738R.dimen.f9853hx);
        AppMethodBeat.m2505o(74639);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c3084b;
        AppMethodBeat.m2504i(74640);
        Context context = viewGroup.getContext();
        if (view == null) {
            C3084b c11891a = new C11891a();
            view = mo36015a(View.inflate(context, 2130969512, null), c11891a, c27966g);
            c11891a.iqT = (ImageView) view.findViewById(2131821479);
            c11891a.mpl = (TextView) view.findViewById(2131823921);
            c11891a.mpm = (TextView) view.findViewById(2131823922);
            c11891a.mpn = (TextView) view.findViewById(2131823923);
            c11891a.mpo = (TextView) view.findViewById(2131823924);
            c11891a.moY = (ImageView) view.findViewById(2131823919);
            c11891a.mpk = (ImageView) view.findViewById(2131823920);
            c11891a.mpp = (FrameLayout) view.findViewById(2131823918);
            c3084b = c11891a;
        } else {
            c3084b = (C11891a) view.getTag();
        }
        mo36016a(c3084b, c27966g);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        Object obj = null;
        LinkedList linkedList = c27966g.field_favProto.wiv;
        Iterator it = linkedList.iterator();
        while (true) {
            Object obj2 = obj;
            int i4 = i;
            if (it.hasNext()) {
                switch (((aar) it.next()).dataType) {
                    case 1:
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 10:
                    case 11:
                    case 14:
                    case 16:
                    case 17:
                        if (obj2 == null) {
                            int obj3 = 1;
                            i = i3;
                            break;
                        }
                    case 2:
                    case 4:
                    case 15:
                        if (!z) {
                            z = true;
                            obj3 = obj2;
                            i2 = i3;
                            i = i4;
                            break;
                        }
                    default:
                        obj3 = obj2;
                        i = i4;
                        break;
                }
                i3++;
            } else {
                C4990ab.m7411d("MicroMsg.FavRecordListItem", "hasThumb %s, firstRemarkIndex %d", Boolean.valueOf(z), Integer.valueOf(i4));
                if (linkedList.size() <= 0) {
                    C4990ab.m7420w("MicroMsg.FavRecordListItem", "dataList size is null");
                    AppMethodBeat.m2505o(74640);
                } else {
                    C11890j.m19779a(c3084b.mpl, c3084b.mpm, (aar) linkedList.get(i4));
                    if (z) {
                        c3084b.mpp.setVisibility(0);
                        c3084b.iqT.setVisibility(0);
                        ImageView imageView = c3084b.iqT;
                        aar aar = (aar) linkedList.get(i2);
                        switch (aar.dataType) {
                            case 2:
                                C45939l c45939l = this.mhy;
                                i = this.moM;
                                int i5 = this.moM;
                                if (imageView != null) {
                                    if (C1445f.m3070Mn()) {
                                        if (!(aar == null || c27966g == null)) {
                                            String str = aar.mnd;
                                            if (str != null) {
                                                String[] strArr = null;
                                                if (aar.mnd != null) {
                                                    String[] strArr2 = (String[]) c45939l.mkn.get(str);
                                                    if (strArr2 == null) {
                                                        strArr = new String[]{C39037b.m66370b(aar), C39037b.m66379c(aar)};
                                                        c45939l.mkn.put(str, strArr);
                                                    } else {
                                                        strArr = strArr2;
                                                    }
                                                }
                                                c45939l.mkm.mo9922a(imageView, strArr, null, C1318a.record_nopicture_icon, i, i5);
                                                if (strArr != null && strArr.length > 0) {
                                                    C1720g.m3539RS().mo10302aa(new C207472(strArr[0], c27966g, aar));
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    imageView.setImageResource(C25738R.drawable.ak_);
                                    break;
                                }
                                break;
                            case 4:
                            case 15:
                                this.mhy.mo73788b(imageView, aar, c27966g, C1318a.app_attach_file_icon_video, this.moM, this.moM);
                                break;
                        }
                    }
                    c3084b.mpp.setVisibility(8);
                    c3084b.iqT.setVisibility(8);
                    if (i4 + 1 < linkedList.size()) {
                        c3084b.mpn.setVisibility(0);
                        c3084b.mpo.setVisibility(0);
                        C11890j.m19779a(c3084b.mpn, c3084b.mpo, (aar) linkedList.get(i4 + 1));
                    } else {
                        c3084b.mpn.setVisibility(8);
                        c3084b.mpo.setVisibility(8);
                    }
                    AppMethodBeat.m2505o(74640);
                }
                return view;
            }
        }
    }

    /* renamed from: a */
    private static void m19779a(TextView textView, TextView textView2, aar aar) {
        AppMethodBeat.m2504i(74641);
        if (aar.wgW) {
            textView.setVisibility(0);
            textView.setText(C44089j.m79293b(textView.getContext(), aar.wgV, textView.getTextSize()));
        } else {
            C4990ab.m7410d("MicroMsg.FavRecordListItem", "has no datasrcname");
            textView.setVisibility(8);
        }
        C4990ab.m7411d("MicroMsg.FavRecordListItem", "field type %d", Integer.valueOf(aar.dataType));
        switch (aar.dataType) {
            case 1:
                textView2.setText(C44089j.m79293b(textView2.getContext(), aar.desc, textView2.getTextSize()));
                AppMethodBeat.m2505o(74641);
                return;
            case 2:
                textView2.setText(C11890j.m19778L(textView2.getContext(), C25738R.string.bro));
                AppMethodBeat.m2505o(74641);
                return;
            case 3:
                textView2.setText(C11890j.m19778L(textView2.getContext(), C25738R.string.brw));
                AppMethodBeat.m2505o(74641);
                return;
            case 4:
                textView2.setText(C11890j.m19778L(textView2.getContext(), C25738R.string.brv));
                AppMethodBeat.m2505o(74641);
                return;
            case 5:
                textView2.setText(C11890j.m19778L(textView2.getContext(), C25738R.string.bru) + aar.title);
                AppMethodBeat.m2505o(74641);
                return;
            case 6:
                String str;
                aay aay = aar.wgT.why;
                StringBuilder append = new StringBuilder().append(C11890j.m19778L(textView2.getContext(), C25738R.string.brq));
                if (C5046bo.isNullOrNil(aay.cIK)) {
                    str = aay.label;
                } else {
                    str = aay.cIK;
                }
                textView2.setText(append.append(str).toString());
                AppMethodBeat.m2505o(74641);
                return;
            case 7:
                textView2.setText(C11890j.m19778L(textView2.getContext(), C25738R.string.brr) + aar.title);
                AppMethodBeat.m2505o(74641);
                return;
            case 8:
                textView2.setText(C11890j.m19778L(textView2.getContext(), C25738R.string.brn) + aar.title);
                AppMethodBeat.m2505o(74641);
                return;
            case 10:
                textView2.setText(C11890j.m19778L(textView2.getContext(), C25738R.string.bpl) + aar.wgT.whC.title);
                AppMethodBeat.m2505o(74641);
                return;
            case 15:
                textView2.setText(C11890j.m19778L(textView2.getContext(), C25738R.string.brj));
                AppMethodBeat.m2505o(74641);
                return;
            case 16:
                textView2.setText(C11890j.m19778L(textView2.getContext(), C25738R.string.bp3));
                AppMethodBeat.m2505o(74641);
                return;
            case 17:
                textView2.setText(C11890j.m19778L(textView2.getContext(), C25738R.string.brt));
                AppMethodBeat.m2505o(74641);
                return;
            case 19:
                textView2.setText(C11890j.m19778L(textView2.getContext(), C25738R.string.brl) + aar.title);
                break;
        }
        AppMethodBeat.m2505o(74641);
    }

    /* renamed from: L */
    private static String m19778L(Context context, int i) {
        AppMethodBeat.m2504i(74642);
        String str = "[" + context.getResources().getString(i) + "]";
        AppMethodBeat.m2505o(74642);
        return str;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74643);
        C11891a c11891a = (C11891a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c11891a.mgf, abh);
        AppMethodBeat.m2505o(74643);
    }
}
