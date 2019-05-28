package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b extends BaseAdapter {
    private String igi = r.Yz();
    List<e> lCD;
    Map<String, String> lCE;
    String lCF;
    d lCG;
    private String lCH;
    private boolean lCI = false;
    private a lCJ = new a();
    private OnClickListener lCK = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(20094);
            ab.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
            b.this.lCG.KI(b.this.uU(((Integer) view.getTag()).intValue()).lFy.field_username);
            AppMethodBeat.o(20094);
        }
    };
    private OnClickListener lCL = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(20095);
            b.this.lCG.KI(b.this.igi);
            AppMethodBeat.o(20095);
        }
    };
    private OnClickListener lCM = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(20096);
            b.this.lCG.bqa();
            AppMethodBeat.o(20096);
        }
    };
    private Context mContext;

    static final class b {
        public View gbS;
        public View jOT;
        public ImageView lCP;
        public NoMeasuredTextView lCQ;
        public TextView lCR;
        public TextView lCS;
        public ExdeviceLikeView lCT;
        public View lCU;
        public View lCV;
        public View lCW;
        public TextView lCX;
        public TextView ltX;

        b() {
        }
    }

    static final class a {
        public View goc;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(20108);
        e uU = uU(i);
        AppMethodBeat.o(20108);
        return uU;
    }

    public b(Context context, String str) {
        AppMethodBeat.i(20097);
        this.mContext = context;
        this.lCH = str;
        AppMethodBeat.o(20097);
    }

    private static void d(LinkedList<c> linkedList, String str) {
        AppMethodBeat.i(20098);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).field_username.equalsIgnoreCase(str)) {
                ab.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", ((c) it.next()).toString());
                it.remove();
            }
        }
        AppMethodBeat.o(20098);
    }

    private static boolean e(LinkedList<c> linkedList, String str) {
        AppMethodBeat.i(20099);
        try {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (((c) it.next()).field_username.equalsIgnoreCase(str)) {
                    AppMethodBeat.o(20099);
                    return true;
                }
            }
            AppMethodBeat.o(20099);
            return false;
        } catch (Exception e) {
            ab.d("MicroMsg.ExdeviceRankAdapter", e.toString());
            AppMethodBeat.o(20099);
            return false;
        }
    }

    private List<e> a(ArrayList<c> arrayList, ArrayList<d> arrayList2, boolean z) {
        a aVar;
        AppMethodBeat.i(20100);
        LinkedList linkedList = new LinkedList(arrayList);
        ArrayList arrayList3 = new ArrayList();
        d h = h(this.igi, arrayList2);
        if (h != null) {
            a aVar2 = this.lCJ;
            aVar2.lFy = h;
            aVar2.lFz = 3;
            if (h.field_score == 0) {
                ((com.tencent.mm.plugin.sport.a.b) g.K(com.tencent.mm.plugin.sport.a.b.class)).d((Activity) this.mContext, this.igi);
            }
        } else {
            aVar = this.lCJ;
            aVar.lFy = null;
            aVar.lCH = this.lCH;
            aVar.username = this.igi;
            aVar.lFz = 7;
        }
        if (z) {
            this.lCJ.auo = 2;
        } else {
            this.lCJ.auo = 1;
        }
        arrayList3.add(this.lCJ.bqg());
        aVar = this.lCJ;
        aVar.auo = 0;
        arrayList3.add(aVar.bqg());
        d(linkedList, this.igi);
        ArrayList arrayList4 = new ArrayList();
        ab.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", Integer.valueOf(linkedList.size()), linkedList.toString());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            h = (d) it.next();
            a aVar3 = this.lCJ;
            aVar3.lFy = h;
            aVar3.auo = 1;
            aVar3.lFz = 4;
            arrayList4.add(aVar3.bqg());
            if (linkedList.size() > 0 && e(linkedList, h.field_username)) {
                aVar3 = this.lCJ;
                aVar3.lFy = h;
                aVar3.auo = 1;
                aVar3.lFz = 2;
                arrayList3.add(aVar3.bqg());
                d(linkedList, h.field_username);
            }
        }
        if (linkedList.size() > 0) {
            it = linkedList.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                a aVar4 = this.lCJ;
                aVar4.username = cVar.field_username;
                aVar4.lCH = this.lCH;
                aVar4.lFy = null;
                aVar4.auo = 1;
                aVar4.lFz = 6;
                arrayList3.add(aVar4.bqg());
            }
        }
        if (arrayList3.size() > 2) {
            ((e) arrayList3.get(arrayList3.size() - 1)).lFz = (((e) arrayList3.get(arrayList3.size() - 1)).lFz | 2) | 1;
            aVar = this.lCJ;
            aVar.auo = 0;
            aVar.lFy = null;
            arrayList3.add(aVar.bqg());
        }
        if (arrayList4.size() > 1) {
            ((e) arrayList4.get(arrayList4.size() - 1)).lFz = 5;
        }
        arrayList3.addAll(arrayList4);
        ab.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", Integer.valueOf(arrayList2.size()), arrayList2.toString());
        ab.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", Integer.valueOf(arrayList3.size()), arrayList3.toString());
        AppMethodBeat.o(20100);
        return arrayList3;
    }

    public final List<e> b(ArrayList<c> arrayList, ArrayList<d> arrayList2, boolean z) {
        ArrayList arrayList3;
        ArrayList arrayList22;
        AppMethodBeat.i(20101);
        if (arrayList3 == null) {
            try {
                arrayList3 = new ArrayList();
            } catch (Exception e) {
                ab.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
                List<e> arrayList4 = new ArrayList();
                AppMethodBeat.o(20101);
                return arrayList4;
            }
        }
        if (arrayList22 == null) {
            arrayList22 = new ArrayList();
        }
        List a = a(arrayList3, arrayList22, z);
        AppMethodBeat.o(20101);
        return a;
    }

    public static d h(String str, ArrayList<d> arrayList) {
        AppMethodBeat.i(20102);
        if (arrayList == null) {
            AppMethodBeat.o(20102);
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equalsIgnoreCase(dVar.field_username)) {
                AppMethodBeat.o(20102);
                return dVar;
            }
        }
        AppMethodBeat.o(20102);
        return null;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final boolean isEnabled(int i) {
        return false;
    }

    public final int getCount() {
        AppMethodBeat.i(20103);
        if (this.lCD == null) {
            AppMethodBeat.o(20103);
            return 0;
        }
        int size = this.lCD.size();
        AppMethodBeat.o(20103);
        return size;
    }

    public final e uU(int i) {
        AppMethodBeat.i(20104);
        e eVar = (e) this.lCD.get(i);
        AppMethodBeat.o(20104);
        return eVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(20105);
        int i2 = uU(i).auo;
        AppMethodBeat.o(20105);
        return i2;
    }

    public static void finish() {
        AppMethodBeat.i(20106);
        ((com.tencent.mm.plugin.sport.a.b) g.K(com.tencent.mm.plugin.sport.a.b.class)).cwa();
        AppMethodBeat.o(20106);
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x026c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(20107);
        final d dVar = uU(i).lFy;
        e uU = uU(i);
        int itemViewType = getItemViewType(i);
        int i2 = uU.lFz;
        if (view != null) {
            switch (itemViewType) {
                case 1:
                case 2:
                    bVar = (b) view.getTag();
                    break;
                default:
                    bVar = null;
                    break;
            }
        }
        LayoutInflater from = LayoutInflater.from(this.mContext);
        switch (itemViewType) {
            case 0:
                view = from.inflate(R.layout.wq, viewGroup, false);
                a aVar = new a();
                aVar.goc = view.findViewById(R.id.bkz);
                view.setTag(aVar);
                bVar = null;
                break;
            case 1:
                view = from.inflate(R.layout.wp, viewGroup, false);
                bVar = new b();
                bVar.lCR = (TextView) view.findViewById(R.id.bky);
                break;
            case 2:
                view = from.inflate(R.layout.wr, viewGroup, false);
                bVar = new b();
                break;
            default:
                bVar = null;
                break;
        }
        if (bVar != null) {
            bVar.gbS = view.findViewById(R.id.nc);
            bVar.jOT = view.findViewById(R.id.be8);
            bVar.ltX = (TextView) view.findViewById(R.id.bkt);
            bVar.lCP = (ImageView) view.findViewById(R.id.bku);
            bVar.lCQ = (NoMeasuredTextView) view.findViewById(R.id.bkx);
            bVar.lCS = (TextView) view.findViewById(R.id.bjk);
            bVar.lCT = (ExdeviceLikeView) view.findViewById(R.id.bkw);
            bVar.lCU = view.findViewById(R.id.bkz);
            bVar.lCW = view.findViewById(R.id.bkv);
            bVar.lCV = view.findViewById(R.id.bkr);
            bVar.lCX = (TextView) view.findViewById(R.id.bl0);
            if (bVar.lCQ != null) {
                bVar.lCQ.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.h9));
                bVar.lCQ.setTextColor(this.mContext.getResources().getColor(R.color.nq));
                bVar.lCQ.setSingleLine(true);
                bVar.lCQ.setShouldEllipsize(true);
            }
            view.setTag(bVar);
        }
        if (!(dVar == null || bVar == null)) {
            if (this.igi.equalsIgnoreCase(dVar.field_username)) {
                this.lCI = true;
            } else {
                this.lCI = false;
            }
            if (itemViewType == 2) {
                bVar.ltX.setText(String.valueOf(dVar.field_ranknum));
                bVar.lCS.setText(String.valueOf(dVar.field_score));
                com.tencent.mm.pluginsdk.ui.a.b.r(bVar.lCP, dVar.field_username);
                bVar.gbS.setOnClickListener(this.lCL);
                bVar.lCX.setOnClickListener(this.lCM);
            } else {
                if (bVar.lCR != null) {
                    if ((i2 & 4) != 4) {
                        bVar.lCR.setVisibility(0);
                        bVar.lCR.setText(this.mContext.getResources().getString(R.string.bhn, new Object[]{Integer.valueOf(dVar.field_ranknum)}));
                    } else {
                        bVar.lCR.setVisibility(8);
                    }
                }
                if ((i2 & 2) == 2 || !dVar.field_username.equalsIgnoreCase(this.lCF) || this.igi.equalsIgnoreCase(this.lCF)) {
                    bVar.jOT.setBackgroundColor(this.mContext.getResources().getColor(R.color.nj));
                } else {
                    bVar.jOT.setBackgroundColor(this.mContext.getResources().getColor(R.color.nk));
                }
                if ((i2 & 1) == 1) {
                    bVar.lCU.setVisibility(8);
                } else {
                    bVar.lCU.setVisibility(0);
                }
                if (dVar.field_ranknum >= 100) {
                    bVar.ltX.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.ha));
                } else {
                    bVar.ltX.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.h_));
                }
                if ((i2 & 2) == 2) {
                    bVar.ltX.setText("");
                } else {
                    bVar.ltX.setText(dVar.field_ranknum);
                }
                if (dVar.field_score >= Downloads.MIN_WAIT_FOR_NETWORK) {
                    bVar.lCS.setTextColor(this.mContext.getResources().getColor(R.color.np));
                } else {
                    bVar.lCS.setTextColor(this.mContext.getResources().getColor(R.color.no));
                }
                bVar.lCS.setText(String.valueOf(dVar.field_score));
                com.tencent.mm.pluginsdk.ui.a.b.r(bVar.lCP, dVar.field_username);
                if (!this.lCI) {
                    aw.ZK();
                    if (!(com.tencent.mm.model.c.XM().aoJ(dVar.field_username) || this.lCE == null || bo.isNullOrNil((String) this.lCE.get(dVar.field_username)))) {
                        bVar.lCQ.setText(j.b(this.mContext, (CharSequence) this.lCE.get(dVar.field_username), bVar.lCQ.getTextSize()));
                        bVar.lCT.setLikeNum(dVar.field_likecount);
                        if (this.lCI) {
                            bVar.lCT.setSelfLikeState(dVar.field_selfLikeState);
                        } else if (dVar.field_likecount != 0) {
                            bVar.lCT.setSelfLikeState(1);
                        } else {
                            bVar.lCT.setSelfLikeState(0);
                        }
                        if (dVar.field_score <= 0 || this.lCI) {
                            bVar.lCT.setClickable(true);
                            bVar.lCT.setOnLikeViewClickListener(new com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView.a() {
                                public final void iE(int i) {
                                    AppMethodBeat.i(20092);
                                    ab.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", Integer.valueOf(i));
                                    if (b.this.lCG != null) {
                                        b.this.lCG.cd(dVar.field_username, i);
                                    }
                                    AppMethodBeat.o(20092);
                                }

                                public final boolean bpL() {
                                    AppMethodBeat.i(20093);
                                    if (b.this.lCG != null) {
                                        boolean KJ = b.this.lCG.KJ(dVar.field_username);
                                        AppMethodBeat.o(20093);
                                        return KJ;
                                    }
                                    AppMethodBeat.o(20093);
                                    return true;
                                }
                            });
                        } else {
                            bVar.lCT.setClickable(false);
                        }
                        bVar.lCV.setTag(Integer.valueOf(i));
                        bVar.lCV.setOnClickListener(this.lCK);
                        bVar.lCW.setTag(Integer.valueOf(i));
                        bVar.lCW.setOnClickListener(this.lCK);
                    }
                }
                bVar.lCQ.setText(j.b(this.mContext, s.mJ(dVar.field_username), bVar.lCQ.getTextSize()));
                bVar.lCT.setLikeNum(dVar.field_likecount);
                if (this.lCI) {
                }
                if (dVar.field_score <= 0) {
                }
                bVar.lCT.setClickable(true);
                bVar.lCT.setOnLikeViewClickListener(/* anonymous class already generated */);
                bVar.lCV.setTag(Integer.valueOf(i));
                bVar.lCV.setOnClickListener(this.lCK);
                bVar.lCW.setTag(Integer.valueOf(i));
                bVar.lCW.setOnClickListener(this.lCK);
            }
        }
        AppMethodBeat.o(20107);
        return view;
    }
}
