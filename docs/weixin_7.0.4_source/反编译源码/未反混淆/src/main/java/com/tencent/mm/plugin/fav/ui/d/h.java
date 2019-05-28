package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.j;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.LinkedList;

public final class h extends a {
    private static int moM;

    public static class a extends b {
        View moS;
        View moT;
        View moU;
        View moV;
        View moW;
        ImageView moX;
        ImageView moY;
        View moZ;
        TextView mpa;
        TextView mpb;
        TextView mpc;
        ImageView mpd;
        TextView mpe;
        TextView mpf;
        TextView mpg;
        TextView mph;
    }

    public h(l lVar) {
        super(lVar);
        AppMethodBeat.i(74633);
        moM = com.tencent.mm.bz.a.al(lVar.context, R.dimen.hx);
        AppMethodBeat.o(74633);
    }

    /* JADX WARNING: Removed duplicated region for block: B:92:0x036b A:{LOOP_END, LOOP:3: B:90:0x0368->B:92:0x036b} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x03b5 A:{LOOP_END, LOOP:4: B:102:0x03af->B:104:0x03b5} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b bVar;
        AppMethodBeat.i(74634);
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.layout.yo, null), aVar, gVar);
            aVar.moS = view.findViewById(R.id.bqf);
            aVar.moT = view.findViewById(R.id.bqq);
            aVar.moU = view.findViewById(R.id.bqm);
            aVar.moV = view.findViewById(R.id.bqo);
            aVar.moW = view.findViewById(R.id.bqg);
            aVar.moX = (ImageView) view.findViewById(R.id.bqh);
            aVar.moZ = view.findViewById(R.id.bqi);
            aVar.moY = (ImageView) view.findViewById(R.id.bq8);
            aVar.mpa = (TextView) view.findViewById(R.id.bqj);
            aVar.mpb = (TextView) view.findViewById(R.id.bqk);
            aVar.mpc = (TextView) view.findViewById(R.id.bql);
            aVar.mpd = (ImageView) view.findViewById(R.id.bqr);
            aVar.mpe = (TextView) view.findViewById(R.id.bqs);
            aVar.mpf = (TextView) view.findViewById(R.id.bqt);
            aVar.mpg = (TextView) view.findViewById(R.id.bqn);
            aVar.mph = (TextView) view.findViewById(R.id.bqp);
            view.setTag(aVar);
            bVar = aVar;
        } else {
            bVar = (a) view.getTag();
        }
        a(bVar, gVar);
        LinkedList linkedList = gVar.field_favProto.wiv;
        if (linkedList.size() < 2) {
            ab.e("MicroMsg.Fav.FavNoteListItem", "no other item");
            AppMethodBeat.o(74634);
        } else {
            int i = -1;
            int i2 = 0;
            int size = linkedList.size();
            Object obj = null;
            int i3 = -1;
            Object obj2 = 1;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                int i6 = i2;
                aar aar;
                if (i5 < linkedList.size()) {
                    aar = (aar) linkedList.get(i5);
                    if (i5 != 0) {
                        if (aar.dataType == 2 || aar.dataType == 4 || aar.dataType == 15) {
                            i6++;
                            obj = 1;
                            if (i == -1) {
                                i = i5;
                            }
                        }
                        switch (aar.dataType) {
                            case 1:
                                if (bo.bc(aar.desc, "").trim().length() <= 0) {
                                    size--;
                                    break;
                                }
                            case 3:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 10:
                            case 11:
                            case 14:
                            case 16:
                            case 20:
                                i3 = i5;
                                break;
                            default:
                                obj2 = null;
                                break;
                        }
                    }
                    com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.b(aar));
                    if (!bVar2.exists()) {
                        l.b(gVar, aar);
                    } else if (aar.whb == null) {
                        ld ldVar = new ld();
                        ldVar.cGU.type = 10;
                        ldVar.cGU.field_localId = gVar.field_localId;
                        ldVar.cGU.path = j.w(bVar2.dMD());
                        com.tencent.mm.sdk.b.a.xxA.m(ldVar);
                    }
                    i2 = i6;
                    i4 = i5 + 1;
                } else {
                    Object obj3;
                    if (obj2 == null || size != 2) {
                        obj3 = null;
                    } else {
                        obj3 = 1;
                    }
                    String str;
                    String str2;
                    if (obj3 == null || i3 <= 0) {
                        bVar.moS.setVisibility(0);
                        bVar.moT.setVisibility(8);
                        bVar.moU.setVisibility(8);
                        bVar.moV.setVisibility(8);
                        ArrayList arrayList = new ArrayList();
                        CharSequence charSequence = null;
                        i4 = 1;
                        while (true) {
                            i3 = i4;
                            if (i3 < linkedList.size()) {
                                aar = (aar) linkedList.get(i3);
                                if (aar.dataType == 1) {
                                    String[] strArr;
                                    str = aar.desc;
                                    if (bo.isNullOrNil(str)) {
                                        strArr = null;
                                    } else {
                                        if (str.length() > 1000) {
                                            str = str.substring(0, 1000);
                                        }
                                        strArr = str.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace(" ", " ").split(IOUtils.LINE_SEPARATOR_UNIX);
                                    }
                                    if (strArr != null && strArr.length > 0) {
                                        int i7;
                                        CharSequence charSequence2;
                                        Object charSequence3;
                                        ArrayList arrayList2 = new ArrayList();
                                        i4 = 0;
                                        while (i4 < strArr.length) {
                                            if (bo.isNullOrNil(strArr[i4].trim())) {
                                                i4++;
                                            } else {
                                                arrayList2.add(strArr[i4]);
                                                str = "";
                                                for (size = i4 + 1; size < strArr.length; size++) {
                                                    str = str + strArr[size] + " ";
                                                }
                                                str = str.trim();
                                                if (str.length() > 0) {
                                                    arrayList2.add(str);
                                                }
                                                i7 = 0;
                                                if (arrayList2.size() > 0 || !bo.isNullOrNil(charSequence3)) {
                                                    charSequence2 = charSequence3;
                                                } else {
                                                    str = (String) arrayList2.get(0);
                                                    i7 = 1;
                                                }
                                                while (i7 < arrayList2.size()) {
                                                    arrayList.add(arrayList2.get(i7));
                                                    i7++;
                                                }
                                                charSequence3 = str;
                                            }
                                        }
                                        i4 = 0;
                                        str = "";
                                        while (size < strArr.length) {
                                        }
                                        str = str.trim();
                                        if (str.length() > 0) {
                                        }
                                        i7 = 0;
                                        if (arrayList2.size() > 0) {
                                        }
                                        charSequence2 = charSequence3;
                                        while (i7 < arrayList2.size()) {
                                        }
                                        charSequence3 = str;
                                    }
                                } else {
                                    Context context2 = view.getContext();
                                    str2 = "";
                                    switch (aar.dataType) {
                                        case 3:
                                        case 20:
                                            str = k.L(context2, R.string.brw) + " " + k.K(context2, (int) com.tencent.mm.plugin.fav.a.b.iu((long) aar.duration));
                                            break;
                                        case 5:
                                            str = k.L(context2, R.string.bru) + " " + aar.title;
                                            break;
                                        case 6:
                                            aay aay = aar.wgT.why;
                                            if (!k.Md(aay.cIK)) {
                                                str = k.L(context2, R.string.brq) + " " + aay.label;
                                                break;
                                            }
                                            str = k.L(context2, R.string.brq) + " " + aay.cIK;
                                            break;
                                        case 7:
                                            str = k.L(context2, R.string.brr) + " " + aar.title;
                                            break;
                                        case 8:
                                            str = k.L(context2, R.string.brn) + " " + aar.title;
                                            break;
                                        case 10:
                                            str = k.L(context2, R.string.bpl) + " " + aar.wgT.whC.title;
                                            break;
                                        case 16:
                                            str = k.L(context2, R.string.bp3);
                                            break;
                                        default:
                                            str = str2;
                                            break;
                                    }
                                    if (!bo.isNullOrNil(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                i4 = i3 + 1;
                            } else {
                                if (bo.isNullOrNil(charSequence3)) {
                                    bVar.mpb.setVisibility(8);
                                } else {
                                    bVar.mpb.setText(com.tencent.mm.pluginsdk.ui.e.j.b(bVar.mpb.getContext(), charSequence3, bVar.mpb.getTextSize()));
                                    bVar.mpb.setVisibility(0);
                                    if (arrayList.size() > 0) {
                                        bVar.mpb.setMaxLines(1);
                                    } else {
                                        bVar.mpb.setMaxLines(3);
                                    }
                                }
                                StringBuffer stringBuffer = new StringBuffer();
                                i4 = 0;
                                while (true) {
                                    i5 = i4;
                                    if (i5 < arrayList.size() && i5 < 2) {
                                        stringBuffer.append((String) arrayList.get(i5));
                                        stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
                                        i4 = i5 + 1;
                                    }
                                }
                                if (stringBuffer.length() != 0) {
                                    bVar.mpc.setText(com.tencent.mm.pluginsdk.ui.e.j.b(bVar.mpc.getContext(), stringBuffer.substring(0, stringBuffer.length() - 1), bVar.mpc.getTextSize()));
                                    bVar.mpc.setVisibility(0);
                                } else {
                                    bVar.mpc.setVisibility(8);
                                }
                                if (obj != null) {
                                    bVar.moW.setVisibility(0);
                                    aar aar2 = (aar) linkedList.get(i);
                                    if (((aar) linkedList.get(i)).dataType == 2) {
                                        ImageView imageView = bVar.moX;
                                        int i8 = moM;
                                        l.a(imageView, aar2, gVar, true, i8, i8);
                                        bVar.moY.setVisibility(8);
                                    } else {
                                        bVar.moY.setVisibility(0);
                                        l lVar = this.mhy;
                                        ImageView imageView2 = bVar.moX;
                                        String str3 = aar2.cvq;
                                        int i9 = moM;
                                        lVar.a(imageView2, aar2, gVar, str3, R.raw.app_attach_file_icon_video, i9, i9);
                                    }
                                    if (i6 > 1) {
                                        bVar.mpa.setText(view.getContext().getString(R.string.bp7, new Object[]{Integer.valueOf(i6)}));
                                        bVar.mpa.setVisibility(0);
                                        bVar.moZ.setVisibility(0);
                                    } else {
                                        bVar.mpa.setVisibility(8);
                                        bVar.moZ.setVisibility(8);
                                    }
                                } else {
                                    bVar.moW.setVisibility(8);
                                }
                            }
                        }
                    } else {
                        aar = (aar) linkedList.get(i3);
                        if (aar.dataType == 3) {
                            bVar.moS.setVisibility(8);
                            bVar.moT.setVisibility(8);
                            bVar.moU.setVisibility(0);
                            bVar.moV.setVisibility(8);
                            bVar.mpg.setText(k.K(this.mhy.context, (int) com.tencent.mm.plugin.fav.a.b.iu((long) aar.duration)));
                        } else if (aar.dataType == 20) {
                            bVar.moS.setVisibility(8);
                            bVar.moT.setVisibility(8);
                            bVar.moU.setVisibility(8);
                            bVar.moV.setVisibility(0);
                            bVar.mph.setText(k.K(this.mhy.context, (int) com.tencent.mm.plugin.fav.a.b.iu((long) aar.duration)));
                        } else {
                            CharSequence charSequence4;
                            str2 = null;
                            if (aar.dataType == 6) {
                                i5 = R.raw.app_attach_file_icon_location;
                                aay aay2 = aar.wgT.why;
                                str = aar.wgT.hHV;
                                Object charSequence42;
                                if (bo.isNullOrNil(str)) {
                                    if (k.Md(aay2.cIK)) {
                                        str = aay2.cIK;
                                    } else {
                                        charSequence42 = aay2.label;
                                    }
                                } else if (k.Md(aay2.cIK)) {
                                    str2 = aay2.cIK;
                                    charSequence42 = str;
                                }
                                str2 = aay2.label;
                                charSequence42 = str;
                            } else {
                                i5 = c.LX(aar.wgo);
                                charSequence42 = aar.title;
                                str2 = aar.desc;
                                if (bo.isNullOrNil(str2)) {
                                    str2 = com.tencent.mm.plugin.fav.a.b.aC((float) aar.wgu);
                                }
                            }
                            bVar.moU.setVisibility(8);
                            bVar.moV.setVisibility(8);
                            bVar.moS.setVisibility(8);
                            bVar.moT.setVisibility(0);
                            bVar.mpd.setImageResource(i5);
                            bVar.mpe.setText(charSequence42);
                            if (bo.isNullOrNil(str2)) {
                                bVar.mpf.setVisibility(8);
                            } else {
                                bVar.mpf.setText(str2);
                                bVar.mpf.setVisibility(0);
                            }
                        }
                    }
                    AppMethodBeat.o(74634);
                }
            }
        }
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74635);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74635);
    }
}
