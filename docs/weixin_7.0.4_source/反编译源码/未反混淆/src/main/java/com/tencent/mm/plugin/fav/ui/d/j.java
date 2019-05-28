package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.l.AnonymousClass2;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends a {
    private final int moM;
    private HashMap<String, SpannableString> mpj = new HashMap();

    public static class a extends b {
        ImageView iqT;
        ImageView moY;
        ImageView mpk;
        TextView mpl;
        TextView mpm;
        TextView mpn;
        TextView mpo;
        FrameLayout mpp;
    }

    public j(l lVar) {
        super(lVar);
        AppMethodBeat.i(74639);
        this.moM = com.tencent.mm.bz.a.al(lVar.context, R.dimen.hx);
        AppMethodBeat.o(74639);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b bVar;
        AppMethodBeat.i(74640);
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.layout.yj, null), aVar, gVar);
            aVar.iqT = (ImageView) view.findViewById(R.id.yk);
            aVar.mpl = (TextView) view.findViewById(R.id.bq_);
            aVar.mpm = (TextView) view.findViewById(R.id.bqa);
            aVar.mpn = (TextView) view.findViewById(R.id.bqb);
            aVar.mpo = (TextView) view.findViewById(R.id.bqc);
            aVar.moY = (ImageView) view.findViewById(R.id.bq8);
            aVar.mpk = (ImageView) view.findViewById(R.id.bq9);
            aVar.mpp = (FrameLayout) view.findViewById(R.id.bq7);
            bVar = aVar;
        } else {
            bVar = (a) view.getTag();
        }
        a(bVar, gVar);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        Object obj = null;
        LinkedList linkedList = gVar.field_favProto.wiv;
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
                ab.d("MicroMsg.FavRecordListItem", "hasThumb %s, firstRemarkIndex %d", Boolean.valueOf(z), Integer.valueOf(i4));
                if (linkedList.size() <= 0) {
                    ab.w("MicroMsg.FavRecordListItem", "dataList size is null");
                    AppMethodBeat.o(74640);
                } else {
                    a(bVar.mpl, bVar.mpm, (aar) linkedList.get(i4));
                    if (z) {
                        bVar.mpp.setVisibility(0);
                        bVar.iqT.setVisibility(0);
                        ImageView imageView = bVar.iqT;
                        aar aar = (aar) linkedList.get(i2);
                        switch (aar.dataType) {
                            case 2:
                                l lVar = this.mhy;
                                i = this.moM;
                                int i5 = this.moM;
                                if (imageView != null) {
                                    if (f.Mn()) {
                                        if (!(aar == null || gVar == null)) {
                                            String str = aar.mnd;
                                            if (str != null) {
                                                String[] strArr = null;
                                                if (aar.mnd != null) {
                                                    String[] strArr2 = (String[]) lVar.mkn.get(str);
                                                    if (strArr2 == null) {
                                                        strArr = new String[]{com.tencent.mm.plugin.fav.a.b.b(aar), com.tencent.mm.plugin.fav.a.b.c(aar)};
                                                        lVar.mkn.put(str, strArr);
                                                    } else {
                                                        strArr = strArr2;
                                                    }
                                                }
                                                lVar.mkm.a(imageView, strArr, null, R.raw.record_nopicture_icon, i, i5);
                                                if (strArr != null && strArr.length > 0) {
                                                    com.tencent.mm.kernel.g.RS().aa(new AnonymousClass2(strArr[0], gVar, aar));
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    imageView.setImageResource(R.drawable.ak_);
                                    break;
                                }
                                break;
                            case 4:
                            case 15:
                                this.mhy.b(imageView, aar, gVar, R.raw.app_attach_file_icon_video, this.moM, this.moM);
                                break;
                        }
                    }
                    bVar.mpp.setVisibility(8);
                    bVar.iqT.setVisibility(8);
                    if (i4 + 1 < linkedList.size()) {
                        bVar.mpn.setVisibility(0);
                        bVar.mpo.setVisibility(0);
                        a(bVar.mpn, bVar.mpo, (aar) linkedList.get(i4 + 1));
                    } else {
                        bVar.mpn.setVisibility(8);
                        bVar.mpo.setVisibility(8);
                    }
                    AppMethodBeat.o(74640);
                }
                return view;
            }
        }
    }

    private static void a(TextView textView, TextView textView2, aar aar) {
        AppMethodBeat.i(74641);
        if (aar.wgW) {
            textView.setVisibility(0);
            textView.setText(com.tencent.mm.pluginsdk.ui.e.j.b(textView.getContext(), aar.wgV, textView.getTextSize()));
        } else {
            ab.d("MicroMsg.FavRecordListItem", "has no datasrcname");
            textView.setVisibility(8);
        }
        ab.d("MicroMsg.FavRecordListItem", "field type %d", Integer.valueOf(aar.dataType));
        switch (aar.dataType) {
            case 1:
                textView2.setText(com.tencent.mm.pluginsdk.ui.e.j.b(textView2.getContext(), aar.desc, textView2.getTextSize()));
                AppMethodBeat.o(74641);
                return;
            case 2:
                textView2.setText(L(textView2.getContext(), R.string.bro));
                AppMethodBeat.o(74641);
                return;
            case 3:
                textView2.setText(L(textView2.getContext(), R.string.brw));
                AppMethodBeat.o(74641);
                return;
            case 4:
                textView2.setText(L(textView2.getContext(), R.string.brv));
                AppMethodBeat.o(74641);
                return;
            case 5:
                textView2.setText(L(textView2.getContext(), R.string.bru) + aar.title);
                AppMethodBeat.o(74641);
                return;
            case 6:
                String str;
                aay aay = aar.wgT.why;
                StringBuilder append = new StringBuilder().append(L(textView2.getContext(), R.string.brq));
                if (bo.isNullOrNil(aay.cIK)) {
                    str = aay.label;
                } else {
                    str = aay.cIK;
                }
                textView2.setText(append.append(str).toString());
                AppMethodBeat.o(74641);
                return;
            case 7:
                textView2.setText(L(textView2.getContext(), R.string.brr) + aar.title);
                AppMethodBeat.o(74641);
                return;
            case 8:
                textView2.setText(L(textView2.getContext(), R.string.brn) + aar.title);
                AppMethodBeat.o(74641);
                return;
            case 10:
                textView2.setText(L(textView2.getContext(), R.string.bpl) + aar.wgT.whC.title);
                AppMethodBeat.o(74641);
                return;
            case 15:
                textView2.setText(L(textView2.getContext(), R.string.brj));
                AppMethodBeat.o(74641);
                return;
            case 16:
                textView2.setText(L(textView2.getContext(), R.string.bp3));
                AppMethodBeat.o(74641);
                return;
            case 17:
                textView2.setText(L(textView2.getContext(), R.string.brt));
                AppMethodBeat.o(74641);
                return;
            case 19:
                textView2.setText(L(textView2.getContext(), R.string.brl) + aar.title);
                break;
        }
        AppMethodBeat.o(74641);
    }

    private static String L(Context context, int i) {
        AppMethodBeat.i(74642);
        String str = "[" + context.getResources().getString(i) + "]";
        AppMethodBeat.o(74642);
        return str;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74643);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74643);
    }
}
