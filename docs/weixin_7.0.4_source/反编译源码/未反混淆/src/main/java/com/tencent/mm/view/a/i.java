package com.tencent.mm.view.a;

import a.f.b.j;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.view.SmileySubGrid;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class i extends x {
    com.tencent.mm.view.f.a Aaj;
    WeakReference<h> AbA;
    public boolean Abw;
    public int Abx;
    public boolean Aby;
    public f Abz;
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter";
    Context mContext;
    public int mCount;

    class a extends c {
        View AbC;
        ImageView AbD;
        TextView AbE;
        TextView AbF;

        public a(View view, int i) {
            super(view, i);
            AppMethodBeat.i(62998);
            this.AbC = view.findViewById(R.id.bep);
            this.AbD = (ImageView) view.findViewById(R.id.beq);
            this.AbE = (TextView) view.findViewById(R.id.ber);
            this.AbF = (TextView) view.findViewById(R.id.bes);
            this.AbD.setOnClickListener(new OnClickListener(i.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(62997);
                    if (((d) g.M(d.class)).getEmojiMgr().OT()) {
                        com.tencent.mm.plugin.emojicapture.api.c.h(i.this.mContext, null, com.tencent.mm.view.f.a.QK(i.this.Aaj.gOW));
                    }
                    AppMethodBeat.o(62997);
                }
            });
            AppMethodBeat.o(62998);
        }
    }

    class b extends c {
        TextView AbJ;
        View goc;

        public b(View view, int i) {
            super(view, i);
            AppMethodBeat.i(62999);
            this.goc = view.findViewById(R.id.eek);
            this.AbJ = (TextView) view.findViewById(R.id.eej);
            AppMethodBeat.o(62999);
        }
    }

    class c {
        RecommendView AbK;
        SmileySubGrid AbL;

        public c(View view, int i) {
            AppMethodBeat.i(63000);
            switch (i) {
                case 0:
                    this.AbK = (RecommendView) view;
                    AppMethodBeat.o(63000);
                    return;
                default:
                    this.AbL = (SmileySubGrid) view.findViewById(R.id.z0);
                    AppMethodBeat.o(63000);
                    return;
            }
        }
    }

    public i(com.tencent.mm.view.f.a aVar, Context context) {
        this.mContext = context;
        this.Aaj = aVar;
    }

    public final int getItemViewType(int i) {
        com.tencent.mm.view.f.a.a aVar;
        AppMethodBeat.i(63001);
        com.tencent.mm.view.c.a QI = this.Aaj.QI(i);
        String str = QI.kWz;
        boolean z = QI.Adm;
        if ("TAG_DEFAULT_TAB".equals(str)) {
            aVar = com.tencent.mm.view.f.a.a.DEFAULT;
        } else if (String.valueOf(EmojiGroupInfo.yas).equals(str) || String.valueOf(EmojiGroupInfo.yar).equals(str)) {
            aVar = com.tencent.mm.view.f.a.a.CUSTOM;
        } else if (!z) {
            aVar = com.tencent.mm.view.f.a.a.RECOMMEND;
        } else if ("capture".equals(str)) {
            aVar = com.tencent.mm.view.f.a.a.CAPTURE;
        } else {
            aVar = com.tencent.mm.view.f.a.a.STORE;
        }
        switch (aVar) {
            case RECOMMEND:
                AppMethodBeat.o(63001);
                return 0;
            case DEFAULT:
                if (this.Aaj.dNx() && i == 0) {
                    AppMethodBeat.o(63001);
                    return 3;
                }
                AppMethodBeat.o(63001);
                return 1;
            case CUSTOM:
                AppMethodBeat.o(63001);
                return 4;
            case CAPTURE:
                AppMethodBeat.o(63001);
                return 5;
            case STORE:
                AppMethodBeat.o(63001);
                return 6;
            default:
                int itemViewType = super.getItemViewType(i);
                AppMethodBeat.o(63001);
                return itemViewType;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        int intValue;
        c cVar;
        AppMethodBeat.i(63003);
        int itemViewType = getItemViewType(i);
        int i2 = (!this.Aaj.dNx() || i <= 0) ? i : i - 1;
        com.tencent.mm.view.c.a QI = this.Aaj.QI(i);
        if (view == null) {
            obj = null;
        } else {
            obj = view.getTag(R.id.ck);
        }
        if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
        } else {
            intValue = -1;
        }
        c cVar2;
        if (view == null || view.getTag() == null || intValue != itemViewType) {
            View t;
            switch (itemViewType) {
                case 0:
                    t = e.von.t(this.mContext, com.tencent.mm.sdk.platformtools.x.gu(this.Aaj.Gn));
                    cVar2 = new c(t, itemViewType);
                    break;
                case 3:
                    t = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.atr, null);
                    cVar2 = new b(t, itemViewType);
                    break;
                case 5:
                    t = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ty, null);
                    cVar2 = new a(t, itemViewType);
                    break;
                default:
                    t = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.atq, null);
                    cVar2 = new c(t, itemViewType);
                    break;
            }
            t.setTag(cVar2);
            t.setTag(R.id.ck, Integer.valueOf(itemViewType));
            cVar = cVar2;
            view = t;
        } else {
            cVar2 = (c) view.getTag();
            view.setTag(R.id.ck, Integer.valueOf(itemViewType));
            cVar = cVar2;
        }
        int i3 = this.Aaj.atl(QI.kWz).Adk;
        int i4 = QI.Adl;
        switch (itemViewType) {
            case 0:
                cVar.AbK.setProductID(QI.kWz);
                break;
            case 1:
                ListAdapter listAdapter;
                if (this.Aaj.dNx() && i == 1) {
                    this.Abz = new f(this.mContext, this.Aaj);
                    listAdapter = this.Abz;
                } else {
                    Object listAdapter2 = new d(this.mContext, this.Aaj);
                }
                cVar.AbL.setAdapter(listAdapter2);
                cVar.AbL.dMI();
                cVar.AbL.setCallback(QI.Adi.getSmileyPanelCallback());
                cVar.AbL.setOnTextOperationListener(QI.Adi.dNe());
                cVar.AbL.setNumColumns(QI.tVB);
                cVar.AbL.setColumnWidth(QI.getColumnWidth());
                cVar.AbL.setScrollbarFadingEnabled(false);
                cVar.AbL.setVerticalScrollBarEnabled(false);
                cVar.AbL.setSelector(R.drawable.uv);
                cVar.AbL.setHorizontalScrollBarEnabled(false);
                cVar.AbL.setLongClickable(false);
                cVar.AbL.setViewParent(QI.Adi.Adt);
                cVar.AbL.setPadding(0, i4, 0, 0);
                cVar.AbL.setVerticalSpacing(i3);
                cVar.AbL.j(com.tencent.mm.view.f.a.ati(QI.kWz), i2 - QI.jis, QI.Adj, QI.aRz(), QI.dMX());
                cVar.AbL.setIsShowPopWin(true);
                cVar.AbL.setScene(this.Aaj.gOW);
                listAdapter2.b(com.tencent.mm.view.f.a.ati(QI.kWz), QI.Adj, QI.aRz(), QI.dMX(), i2 - QI.jis, QI.tVA, QI.tVB);
                listAdapter2.Abf = QI.kWz;
                break;
            case 3:
                if (cVar instanceof b) {
                    b bVar = (b) cVar;
                    i3 = viewGroup.getWidth();
                    itemViewType = i.this.Aaj.atl(QI.kWz).Adk;
                    i4 = QI.Adl;
                    LayoutParams layoutParams = (LayoutParams) bVar.AbL.getLayoutParams();
                    layoutParams.width = (i3 / QI.tVB) * 3;
                    layoutParams.topMargin = i4;
                    layoutParams.height = (i.this.Aaj.Aee * QI.tVA) + ((QI.tVA - 1) * itemViewType);
                    bVar.AbL.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) bVar.AbJ.getLayoutParams();
                    layoutParams.height = i4;
                    bVar.AbJ.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) bVar.goc.getLayoutParams();
                    layoutParams.leftMargin = (i3 / QI.tVB) / 2;
                    layoutParams.topMargin = i.this.Aaj.Aee / 4;
                    layoutParams.bottomMargin = i.this.Aaj.Aee / 4;
                    bVar.goc.setLayoutParams(layoutParams);
                    h hVar = new h(i.this.mContext, i.this.Aaj);
                    bVar.AbL.setAdapter((ListAdapter) hVar);
                    bVar.AbL.setNumColumns(3);
                    bVar.AbL.setColumnWidth(QI.getColumnWidth());
                    bVar.AbL.setVerticalSpacing(itemViewType);
                    bVar.AbL.setOnTextOperationListener(QI.Adi.dNe());
                    SmileySubGrid smileySubGrid = bVar.AbL;
                    smileySubGrid.setOnItemClickListener(smileySubGrid.Aae);
                    bVar.AbL.setLongClickable(true);
                    bVar.AbL.setIsShowPopWin(true);
                    bVar.AbL.setVerticalScrollBarEnabled(false);
                    bVar.AbL.setScene(i.this.Aaj.gOW);
                    bVar.AbL.setScrollbarFadingEnabled(false);
                    bVar.AbL.setSelector(R.drawable.uv);
                    bVar.AbL.setHorizontalScrollBarEnabled(false);
                    bVar.AbL.setViewParent(QI.Adi.Adt);
                    hVar.b(com.tencent.mm.view.f.a.ati(QI.kWz), QI.Adj, QI.aRz(), QI.dMX() * QI.tVB, QI.jis, QI.tVA, 3);
                    hVar.update();
                    i.this.AbA = new WeakReference(hVar);
                    break;
                }
                break;
            case 4:
            case 6:
                e eVar = new e(this.mContext, this.Aaj);
                cVar.AbL.setAdapter((ListAdapter) eVar);
                cVar.AbL.dMI();
                cVar.AbL.setNumColumns(QI.tVB);
                cVar.AbL.setColumnWidth(QI.getColumnWidth());
                cVar.AbL.setScrollbarFadingEnabled(false);
                cVar.AbL.setHorizontalScrollBarEnabled(false);
                cVar.AbL.setVerticalScrollBarEnabled(false);
                cVar.AbL.setCallback(QI.Adi.getSmileyPanelCallback());
                cVar.AbL.setFastScrollEnabled(false);
                cVar.AbL.setViewParent(QI.Adi.Adt);
                cVar.AbL.setPadding(0, i4, 0, 0);
                cVar.AbL.setVerticalSpacing(i3 / 2);
                cVar.AbL.setIsShowPopWin(true);
                cVar.AbL.setScene(this.Aaj.gOW);
                cVar.AbL.j(com.tencent.mm.view.f.a.ati(QI.kWz), i - QI.jis, QI.Adj, QI.aRz(), QI.dMX());
                eVar.b(com.tencent.mm.view.f.a.ati(QI.kWz), QI.Adj, QI.dMW(), QI.dMX(), i - QI.jis, QI.tVA, QI.tVB);
                eVar.Abf = QI.kWz;
                if (eVar.zZZ != 23) {
                    if (eVar.zZZ == 25) {
                        if (eVar.Aal == null || bo.isNullOrNil(eVar.Aal.vmL) || (!ad.aox(eVar.Aal.vmL) && !t.mP(eVar.Aal.vmL))) {
                            if (ChatFooterPanel.vhl != eVar.scene) {
                                eVar.lbH = ((d) g.M(d.class)).getProvider().bY(false);
                                break;
                            }
                            eVar.lbH = ((d) g.M(d.class)).getProvider().bY(true);
                            break;
                        }
                        eVar.lbH = ((d) g.M(d.class)).getProvider().OC();
                        break;
                    }
                }
                eVar.lbH = ((d) g.M(d.class)).getProvider().kS(eVar.Abf);
                break;
                break;
            case 5:
                if (cVar instanceof a) {
                    a aVar = (a) cVar;
                    ArrayList bZ = com.tencent.mm.emoji.a.a.OB().bZ(i.this.Aaj.gOW == ChatFooterPanel.vhi);
                    if (!bo.ek(bZ)) {
                        aVar.AbL.setVisibility(0);
                        aVar.AbC.setVisibility(8);
                        intValue = i.this.Aaj.atl(QI.kWz).Adk;
                        i3 = QI.Adl;
                        b bVar2 = new b(i.this.mContext, i.this.Aaj);
                        aVar.AbL.setAdapter((ListAdapter) bVar2);
                        aVar.AbL.dMI();
                        aVar.AbL.setNumColumns(QI.tVB);
                        aVar.AbL.setColumnWidth(QI.getColumnWidth());
                        aVar.AbL.setScrollbarFadingEnabled(false);
                        aVar.AbL.setHorizontalScrollBarEnabled(false);
                        aVar.AbL.setVerticalScrollBarEnabled(false);
                        aVar.AbL.setCallback(QI.Adi.getSmileyPanelCallback());
                        aVar.AbL.setViewParent(QI.Adi.Adt);
                        aVar.AbL.setPadding(0, i3, 0, 0);
                        aVar.AbL.setVerticalSpacing(intValue / 2);
                        aVar.AbL.setIsShowPopWin(true);
                        aVar.AbL.setScene(i.this.Aaj.gOW);
                        aVar.AbL.j(com.tencent.mm.view.f.a.ati(QI.kWz), i - QI.jis, QI.Adj, QI.aRz(), QI.dMX());
                        bVar2.b(com.tencent.mm.view.f.a.ati(QI.kWz), QI.Adj, QI.dMW(), QI.dMX(), i - QI.jis, QI.tVA, QI.tVB);
                        bVar2.Abf = QI.kWz;
                        j.p(bZ, "emoji");
                        bVar2.Abh.addAll(bZ);
                        break;
                    }
                    aVar.AbL.setVisibility(8);
                    aVar.AbC.setVisibility(0);
                    break;
                }
                break;
        }
        AppMethodBeat.o(63003);
        return view;
    }

    public final int getCount() {
        return this.mCount;
    }

    public final void refreshData() {
        AppMethodBeat.i(63005);
        this.mCount = this.Aaj.dNs();
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "refresh data mCount:%d", Integer.valueOf(this.mCount));
        AppMethodBeat.o(63005);
    }

    public final void aJ(int i, boolean z) {
        AppMethodBeat.i(63006);
        this.Abx = i;
        if (this.Abx != 0 || z) {
            this.Aaj.dNy();
            if (this.AbA != null) {
                h hVar = (h) this.AbA.get();
                if (hVar != null) {
                    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "update at page " + this.Abx);
                    hVar.update();
                }
                AppMethodBeat.o(63006);
                return;
            }
        }
        this.Aby = true;
        AppMethodBeat.o(63006);
    }

    public final float getPageWidth(int i) {
        AppMethodBeat.i(63002);
        float f;
        if (this.Aaj.dNx() && i == 0) {
            f = 4.0f / ((float) this.Aaj.QI(i).tVB);
            AppMethodBeat.o(63002);
            return f;
        }
        f = super.getPageWidth(i);
        AppMethodBeat.o(63002);
        return f;
    }

    public final int getItemPosition(Object obj) {
        AppMethodBeat.i(63004);
        if (this.Abw) {
            ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "get item position always changed");
            AppMethodBeat.o(63004);
            return -2;
        }
        int itemPosition = super.getItemPosition(obj);
        AppMethodBeat.o(63004);
        return itemPosition;
    }
}
