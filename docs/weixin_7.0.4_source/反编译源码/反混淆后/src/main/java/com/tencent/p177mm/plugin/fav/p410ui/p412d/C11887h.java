package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18313ld;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C34172k;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.h */
public final class C11887h extends C20714a {
    private static int moM;

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.h$a */
    public static class C11888a extends C3084b {
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

    public C11887h(C45939l c45939l) {
        super(c45939l);
        AppMethodBeat.m2504i(74633);
        moM = C1338a.m2856al(c45939l.context, C25738R.dimen.f9853hx);
        AppMethodBeat.m2505o(74633);
    }

    /* JADX WARNING: Removed duplicated region for block: B:92:0x036b A:{LOOP_END, LOOP:3: B:90:0x0368->B:92:0x036b} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x03b5 A:{LOOP_END, LOOP:4: B:102:0x03af->B:104:0x03b5} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c3084b;
        AppMethodBeat.m2504i(74634);
        Context context = viewGroup.getContext();
        if (view == null) {
            C3084b c11888a = new C11888a();
            view = mo36015a(View.inflate(context, 2130969517, null), c11888a, c27966g);
            c11888a.moS = view.findViewById(2131823927);
            c11888a.moT = view.findViewById(2131823938);
            c11888a.moU = view.findViewById(2131823934);
            c11888a.moV = view.findViewById(2131823936);
            c11888a.moW = view.findViewById(2131823928);
            c11888a.moX = (ImageView) view.findViewById(2131823929);
            c11888a.moZ = view.findViewById(2131823930);
            c11888a.moY = (ImageView) view.findViewById(2131823919);
            c11888a.mpa = (TextView) view.findViewById(2131823931);
            c11888a.mpb = (TextView) view.findViewById(2131823932);
            c11888a.mpc = (TextView) view.findViewById(2131823933);
            c11888a.mpd = (ImageView) view.findViewById(2131823939);
            c11888a.mpe = (TextView) view.findViewById(2131823940);
            c11888a.mpf = (TextView) view.findViewById(2131823941);
            c11888a.mpg = (TextView) view.findViewById(2131823935);
            c11888a.mph = (TextView) view.findViewById(2131823937);
            view.setTag(c11888a);
            c3084b = c11888a;
        } else {
            c3084b = (C11888a) view.getTag();
        }
        mo36016a(c3084b, c27966g);
        LinkedList linkedList = c27966g.field_favProto.wiv;
        if (linkedList.size() < 2) {
            C4990ab.m7412e("MicroMsg.Fav.FavNoteListItem", "no other item");
            AppMethodBeat.m2505o(74634);
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
                                if (C5046bo.m7532bc(aar.desc, "").trim().length() <= 0) {
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
                    C5728b c5728b = new C5728b(C39037b.m66370b(aar));
                    if (!c5728b.exists()) {
                        C45939l.m85281b(c27966g, aar);
                    } else if (aar.whb == null) {
                        C18313ld c18313ld = new C18313ld();
                        c18313ld.cGU.type = 10;
                        c18313ld.cGU.field_localId = c27966g.field_localId;
                        c18313ld.cGU.path = C5736j.m8649w(c5728b.dMD());
                        C4879a.xxA.mo10055m(c18313ld);
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
                        c3084b.moS.setVisibility(0);
                        c3084b.moT.setVisibility(8);
                        c3084b.moU.setVisibility(8);
                        c3084b.moV.setVisibility(8);
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
                                    if (C5046bo.isNullOrNil(str)) {
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
                                            if (C5046bo.isNullOrNil(strArr[i4].trim())) {
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
                                                if (arrayList2.size() > 0 || !C5046bo.isNullOrNil(charSequence3)) {
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
                                            str = C34172k.m56021L(context2, C25738R.string.brw) + " " + C34172k.m56020K(context2, (int) C39037b.m66406iu((long) aar.duration));
                                            break;
                                        case 5:
                                            str = C34172k.m56021L(context2, C25738R.string.bru) + " " + aar.title;
                                            break;
                                        case 6:
                                            aay aay = aar.wgT.why;
                                            if (!C34172k.m56022Md(aay.cIK)) {
                                                str = C34172k.m56021L(context2, C25738R.string.brq) + " " + aay.label;
                                                break;
                                            }
                                            str = C34172k.m56021L(context2, C25738R.string.brq) + " " + aay.cIK;
                                            break;
                                        case 7:
                                            str = C34172k.m56021L(context2, C25738R.string.brr) + " " + aar.title;
                                            break;
                                        case 8:
                                            str = C34172k.m56021L(context2, C25738R.string.brn) + " " + aar.title;
                                            break;
                                        case 10:
                                            str = C34172k.m56021L(context2, C25738R.string.bpl) + " " + aar.wgT.whC.title;
                                            break;
                                        case 16:
                                            str = C34172k.m56021L(context2, C25738R.string.bp3);
                                            break;
                                        default:
                                            str = str2;
                                            break;
                                    }
                                    if (!C5046bo.isNullOrNil(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                i4 = i3 + 1;
                            } else {
                                if (C5046bo.isNullOrNil(charSequence3)) {
                                    c3084b.mpb.setVisibility(8);
                                } else {
                                    c3084b.mpb.setText(C44089j.m79293b(c3084b.mpb.getContext(), charSequence3, c3084b.mpb.getTextSize()));
                                    c3084b.mpb.setVisibility(0);
                                    if (arrayList.size() > 0) {
                                        c3084b.mpb.setMaxLines(1);
                                    } else {
                                        c3084b.mpb.setMaxLines(3);
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
                                    c3084b.mpc.setText(C44089j.m79293b(c3084b.mpc.getContext(), stringBuffer.substring(0, stringBuffer.length() - 1), c3084b.mpc.getTextSize()));
                                    c3084b.mpc.setVisibility(0);
                                } else {
                                    c3084b.mpc.setVisibility(8);
                                }
                                if (obj != null) {
                                    c3084b.moW.setVisibility(0);
                                    aar aar2 = (aar) linkedList.get(i);
                                    if (((aar) linkedList.get(i)).dataType == 2) {
                                        ImageView imageView = c3084b.moX;
                                        int i8 = moM;
                                        C45939l.m85278a(imageView, aar2, c27966g, true, i8, i8);
                                        c3084b.moY.setVisibility(8);
                                    } else {
                                        c3084b.moY.setVisibility(0);
                                        C45939l c45939l = this.mhy;
                                        ImageView imageView2 = c3084b.moX;
                                        String str3 = aar2.cvq;
                                        int i9 = moM;
                                        c45939l.mo73787a(imageView2, aar2, c27966g, str3, C1318a.app_attach_file_icon_video, i9, i9);
                                    }
                                    if (i6 > 1) {
                                        c3084b.mpa.setText(view.getContext().getString(C25738R.string.bp7, new Object[]{Integer.valueOf(i6)}));
                                        c3084b.mpa.setVisibility(0);
                                        c3084b.moZ.setVisibility(0);
                                    } else {
                                        c3084b.mpa.setVisibility(8);
                                        c3084b.moZ.setVisibility(8);
                                    }
                                } else {
                                    c3084b.moW.setVisibility(8);
                                }
                            }
                        }
                    } else {
                        aar = (aar) linkedList.get(i3);
                        if (aar.dataType == 3) {
                            c3084b.moS.setVisibility(8);
                            c3084b.moT.setVisibility(8);
                            c3084b.moU.setVisibility(0);
                            c3084b.moV.setVisibility(8);
                            c3084b.mpg.setText(C34172k.m56020K(this.mhy.context, (int) C39037b.m66406iu((long) aar.duration)));
                        } else if (aar.dataType == 20) {
                            c3084b.moS.setVisibility(8);
                            c3084b.moT.setVisibility(8);
                            c3084b.moU.setVisibility(8);
                            c3084b.moV.setVisibility(0);
                            c3084b.mph.setText(C34172k.m56020K(this.mhy.context, (int) C39037b.m66406iu((long) aar.duration)));
                        } else {
                            CharSequence charSequence4;
                            str2 = null;
                            if (aar.dataType == 6) {
                                i5 = C1318a.app_attach_file_icon_location;
                                aay aay2 = aar.wgT.why;
                                str = aar.wgT.hHV;
                                Object charSequence42;
                                if (C5046bo.isNullOrNil(str)) {
                                    if (C34172k.m56022Md(aay2.cIK)) {
                                        str = aay2.cIK;
                                    } else {
                                        charSequence42 = aay2.label;
                                    }
                                } else if (C34172k.m56022Md(aay2.cIK)) {
                                    str2 = aay2.cIK;
                                    charSequence42 = str;
                                }
                                str2 = aay2.label;
                                charSequence42 = str;
                            } else {
                                i5 = C45932c.m85252LX(aar.wgo);
                                charSequence42 = aar.title;
                                str2 = aar.desc;
                                if (C5046bo.isNullOrNil(str2)) {
                                    str2 = C39037b.m66368aC((float) aar.wgu);
                                }
                            }
                            c3084b.moU.setVisibility(8);
                            c3084b.moV.setVisibility(8);
                            c3084b.moS.setVisibility(8);
                            c3084b.moT.setVisibility(0);
                            c3084b.mpd.setImageResource(i5);
                            c3084b.mpe.setText(charSequence42);
                            if (C5046bo.isNullOrNil(str2)) {
                                c3084b.mpf.setVisibility(8);
                            } else {
                                c3084b.mpf.setText(str2);
                                c3084b.mpf.setVisibility(0);
                            }
                        }
                    }
                    AppMethodBeat.m2505o(74634);
                }
            }
        }
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74635);
        C11888a c11888a = (C11888a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c11888a.mgf, abh);
        AppMethodBeat.m2505o(74635);
    }
}
