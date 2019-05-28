package com.tencent.p177mm.view.p645a;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.base.C46637x;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emojicapture.api.C20423c;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.RecommendView;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44081e;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.view.SmileySubGrid;
import com.tencent.p177mm.view.p1097f.C16067a;
import com.tencent.p177mm.view.p1097f.C16067a.C16066a;
import com.tencent.p177mm.view.p1627c.C44418a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p000a.p005f.p007b.C25052j;

/* renamed from: com.tencent.mm.view.a.i */
public final class C16042i extends C46637x {
    C16067a Aaj;
    WeakReference<C5737h> AbA;
    public boolean Abw;
    public int Abx;
    public boolean Aby;
    public C36883f Abz;
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter";
    Context mContext;
    public int mCount;

    /* renamed from: com.tencent.mm.view.a.i$a */
    class C16043a extends C16046c {
        View AbC;
        ImageView AbD;
        TextView AbE;
        TextView AbF;

        public C16043a(View view, int i) {
            super(view, i);
            AppMethodBeat.m2504i(62998);
            this.AbC = view.findViewById(2131823493);
            this.AbD = (ImageView) view.findViewById(2131823494);
            this.AbE = (TextView) view.findViewById(2131823495);
            this.AbF = (TextView) view.findViewById(2131823496);
            this.AbD.setOnClickListener(new OnClickListener(C16042i.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(62997);
                    if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35614OT()) {
                        C20423c.m31582h(C16042i.this.mContext, null, C16067a.m24368QK(C16042i.this.Aaj.gOW));
                    }
                    AppMethodBeat.m2505o(62997);
                }
            });
            AppMethodBeat.m2505o(62998);
        }
    }

    /* renamed from: com.tencent.mm.view.a.i$b */
    class C16045b extends C16046c {
        TextView AbJ;
        View goc;

        public C16045b(View view, int i) {
            super(view, i);
            AppMethodBeat.m2504i(62999);
            this.goc = view.findViewById(2131827594);
            this.AbJ = (TextView) view.findViewById(2131827593);
            AppMethodBeat.m2505o(62999);
        }
    }

    /* renamed from: com.tencent.mm.view.a.i$c */
    class C16046c {
        RecommendView AbK;
        SmileySubGrid AbL;

        public C16046c(View view, int i) {
            AppMethodBeat.m2504i(63000);
            switch (i) {
                case 0:
                    this.AbK = (RecommendView) view;
                    AppMethodBeat.m2505o(63000);
                    return;
                default:
                    this.AbL = (SmileySubGrid) view.findViewById(2131821507);
                    AppMethodBeat.m2505o(63000);
                    return;
            }
        }
    }

    public C16042i(C16067a c16067a, Context context) {
        this.mContext = context;
        this.Aaj = c16067a;
    }

    public final int getItemViewType(int i) {
        C16066a c16066a;
        AppMethodBeat.m2504i(63001);
        C44418a QI = this.Aaj.mo28456QI(i);
        String str = QI.kWz;
        boolean z = QI.Adm;
        if ("TAG_DEFAULT_TAB".equals(str)) {
            c16066a = C16066a.DEFAULT;
        } else if (String.valueOf(EmojiGroupInfo.yas).equals(str) || String.valueOf(EmojiGroupInfo.yar).equals(str)) {
            c16066a = C16066a.CUSTOM;
        } else if (!z) {
            c16066a = C16066a.RECOMMEND;
        } else if ("capture".equals(str)) {
            c16066a = C16066a.CAPTURE;
        } else {
            c16066a = C16066a.STORE;
        }
        switch (c16066a) {
            case RECOMMEND:
                AppMethodBeat.m2505o(63001);
                return 0;
            case DEFAULT:
                if (this.Aaj.dNx() && i == 0) {
                    AppMethodBeat.m2505o(63001);
                    return 3;
                }
                AppMethodBeat.m2505o(63001);
                return 1;
            case CUSTOM:
                AppMethodBeat.m2505o(63001);
                return 4;
            case CAPTURE:
                AppMethodBeat.m2505o(63001);
                return 5;
            case STORE:
                AppMethodBeat.m2505o(63001);
                return 6;
            default:
                int itemViewType = super.getItemViewType(i);
                AppMethodBeat.m2505o(63001);
                return itemViewType;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        int intValue;
        C16046c c16046c;
        AppMethodBeat.m2504i(63003);
        int itemViewType = getItemViewType(i);
        int i2 = (!this.Aaj.dNx() || i <= 0) ? i : i - 1;
        C44418a QI = this.Aaj.mo28456QI(i);
        if (view == null) {
            obj = null;
        } else {
            obj = view.getTag(2131820665);
        }
        if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
        } else {
            intValue = -1;
        }
        C16046c c16046c2;
        if (view == null || view.getTag() == null || intValue != itemViewType) {
            View t;
            switch (itemViewType) {
                case 0:
                    t = C44081e.von.mo7123t(this.mContext, C40619x.m70075gu(this.Aaj.f3007Gn));
                    c16046c2 = new C16046c(t, itemViewType);
                    break;
                case 3:
                    t = LayoutInflater.from(viewGroup.getContext()).inflate(2130970707, null);
                    c16046c2 = new C16045b(t, itemViewType);
                    break;
                case 5:
                    t = LayoutInflater.from(viewGroup.getContext()).inflate(2130969342, null);
                    c16046c2 = new C16043a(t, itemViewType);
                    break;
                default:
                    t = LayoutInflater.from(viewGroup.getContext()).inflate(2130970706, null);
                    c16046c2 = new C16046c(t, itemViewType);
                    break;
            }
            t.setTag(c16046c2);
            t.setTag(2131820665, Integer.valueOf(itemViewType));
            c16046c = c16046c2;
            view = t;
        } else {
            c16046c2 = (C16046c) view.getTag();
            view.setTag(2131820665, Integer.valueOf(itemViewType));
            c16046c = c16046c2;
        }
        int i3 = this.Aaj.atl(QI.kWz).Adk;
        int i4 = QI.Adl;
        switch (itemViewType) {
            case 0:
                c16046c.AbK.setProductID(QI.kWz);
                break;
            case 1:
                ListAdapter listAdapter;
                if (this.Aaj.dNx() && i == 1) {
                    this.Abz = new C36883f(this.mContext, this.Aaj);
                    listAdapter = this.Abz;
                } else {
                    Object listAdapter2 = new C36373d(this.mContext, this.Aaj);
                }
                c16046c.AbL.setAdapter(listAdapter2);
                c16046c.AbL.dMI();
                c16046c.AbL.setCallback(QI.Adi.getSmileyPanelCallback());
                c16046c.AbL.setOnTextOperationListener(QI.Adi.dNe());
                c16046c.AbL.setNumColumns(QI.tVB);
                c16046c.AbL.setColumnWidth(QI.getColumnWidth());
                c16046c.AbL.setScrollbarFadingEnabled(false);
                c16046c.AbL.setVerticalScrollBarEnabled(false);
                c16046c.AbL.setSelector(C25738R.drawable.f6900uv);
                c16046c.AbL.setHorizontalScrollBarEnabled(false);
                c16046c.AbL.setLongClickable(false);
                c16046c.AbL.setViewParent(QI.Adi.Adt);
                c16046c.AbL.setPadding(0, i4, 0, 0);
                c16046c.AbL.setVerticalSpacing(i3);
                c16046c.AbL.mo75098j(C16067a.ati(QI.kWz), i2 - QI.jis, QI.Adj, QI.aRz(), QI.dMX());
                c16046c.AbL.setIsShowPopWin(true);
                c16046c.AbL.setScene(this.Aaj.gOW);
                listAdapter2.mo28408b(C16067a.ati(QI.kWz), QI.Adj, QI.aRz(), QI.dMX(), i2 - QI.jis, QI.tVA, QI.tVB);
                listAdapter2.Abf = QI.kWz;
                break;
            case 3:
                if (c16046c instanceof C16045b) {
                    C16045b c16045b = (C16045b) c16046c;
                    i3 = viewGroup.getWidth();
                    itemViewType = C16042i.this.Aaj.atl(QI.kWz).Adk;
                    i4 = QI.Adl;
                    LayoutParams layoutParams = (LayoutParams) c16045b.AbL.getLayoutParams();
                    layoutParams.width = (i3 / QI.tVB) * 3;
                    layoutParams.topMargin = i4;
                    layoutParams.height = (C16042i.this.Aaj.Aee * QI.tVA) + ((QI.tVA - 1) * itemViewType);
                    c16045b.AbL.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) c16045b.AbJ.getLayoutParams();
                    layoutParams.height = i4;
                    c16045b.AbJ.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) c16045b.goc.getLayoutParams();
                    layoutParams.leftMargin = (i3 / QI.tVB) / 2;
                    layoutParams.topMargin = C16042i.this.Aaj.Aee / 4;
                    layoutParams.bottomMargin = C16042i.this.Aaj.Aee / 4;
                    c16045b.goc.setLayoutParams(layoutParams);
                    C5737h c5737h = new C5737h(C16042i.this.mContext, C16042i.this.Aaj);
                    c16045b.AbL.setAdapter((ListAdapter) c5737h);
                    c16045b.AbL.setNumColumns(3);
                    c16045b.AbL.setColumnWidth(QI.getColumnWidth());
                    c16045b.AbL.setVerticalSpacing(itemViewType);
                    c16045b.AbL.setOnTextOperationListener(QI.Adi.dNe());
                    SmileySubGrid smileySubGrid = c16045b.AbL;
                    smileySubGrid.setOnItemClickListener(smileySubGrid.Aae);
                    c16045b.AbL.setLongClickable(true);
                    c16045b.AbL.setIsShowPopWin(true);
                    c16045b.AbL.setVerticalScrollBarEnabled(false);
                    c16045b.AbL.setScene(C16042i.this.Aaj.gOW);
                    c16045b.AbL.setScrollbarFadingEnabled(false);
                    c16045b.AbL.setSelector(C25738R.drawable.f6900uv);
                    c16045b.AbL.setHorizontalScrollBarEnabled(false);
                    c16045b.AbL.setViewParent(QI.Adi.Adt);
                    c5737h.mo28408b(C16067a.ati(QI.kWz), QI.Adj, QI.aRz(), QI.dMX() * QI.tVB, QI.jis, QI.tVA, 3);
                    c5737h.update();
                    C16042i.this.AbA = new WeakReference(c5737h);
                    break;
                }
                break;
            case 4:
            case 6:
                C46716e c46716e = new C46716e(this.mContext, this.Aaj);
                c16046c.AbL.setAdapter((ListAdapter) c46716e);
                c16046c.AbL.dMI();
                c16046c.AbL.setNumColumns(QI.tVB);
                c16046c.AbL.setColumnWidth(QI.getColumnWidth());
                c16046c.AbL.setScrollbarFadingEnabled(false);
                c16046c.AbL.setHorizontalScrollBarEnabled(false);
                c16046c.AbL.setVerticalScrollBarEnabled(false);
                c16046c.AbL.setCallback(QI.Adi.getSmileyPanelCallback());
                c16046c.AbL.setFastScrollEnabled(false);
                c16046c.AbL.setViewParent(QI.Adi.Adt);
                c16046c.AbL.setPadding(0, i4, 0, 0);
                c16046c.AbL.setVerticalSpacing(i3 / 2);
                c16046c.AbL.setIsShowPopWin(true);
                c16046c.AbL.setScene(this.Aaj.gOW);
                c16046c.AbL.mo75098j(C16067a.ati(QI.kWz), i - QI.jis, QI.Adj, QI.aRz(), QI.dMX());
                c46716e.mo28408b(C16067a.ati(QI.kWz), QI.Adj, QI.dMW(), QI.dMX(), i - QI.jis, QI.tVA, QI.tVB);
                c46716e.Abf = QI.kWz;
                if (c46716e.zZZ != 23) {
                    if (c46716e.zZZ == 25) {
                        if (c46716e.Aal == null || C5046bo.isNullOrNil(c46716e.Aal.vmL) || (!C7616ad.aox(c46716e.Aal.vmL) && !C1855t.m3903mP(c46716e.Aal.vmL))) {
                            if (ChatFooterPanel.vhl != c46716e.scene) {
                                c46716e.lbH = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35625bY(false);
                                break;
                            }
                            c46716e.lbH = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35625bY(true);
                            break;
                        }
                        c46716e.lbH = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35611OC();
                        break;
                    }
                }
                c46716e.lbH = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35654kS(c46716e.Abf);
                break;
                break;
            case 5:
                if (c16046c instanceof C16043a) {
                    C16043a c16043a = (C16043a) c16046c;
                    ArrayList bZ = C32497a.m53203OB().mo53137bZ(C16042i.this.Aaj.gOW == ChatFooterPanel.vhi);
                    if (!C5046bo.m7548ek(bZ)) {
                        c16043a.AbL.setVisibility(0);
                        c16043a.AbC.setVisibility(8);
                        intValue = C16042i.this.Aaj.atl(QI.kWz).Adk;
                        i3 = QI.Adl;
                        C17067b c17067b = new C17067b(C16042i.this.mContext, C16042i.this.Aaj);
                        c16043a.AbL.setAdapter((ListAdapter) c17067b);
                        c16043a.AbL.dMI();
                        c16043a.AbL.setNumColumns(QI.tVB);
                        c16043a.AbL.setColumnWidth(QI.getColumnWidth());
                        c16043a.AbL.setScrollbarFadingEnabled(false);
                        c16043a.AbL.setHorizontalScrollBarEnabled(false);
                        c16043a.AbL.setVerticalScrollBarEnabled(false);
                        c16043a.AbL.setCallback(QI.Adi.getSmileyPanelCallback());
                        c16043a.AbL.setViewParent(QI.Adi.Adt);
                        c16043a.AbL.setPadding(0, i3, 0, 0);
                        c16043a.AbL.setVerticalSpacing(intValue / 2);
                        c16043a.AbL.setIsShowPopWin(true);
                        c16043a.AbL.setScene(C16042i.this.Aaj.gOW);
                        c16043a.AbL.mo75098j(C16067a.ati(QI.kWz), i - QI.jis, QI.Adj, QI.aRz(), QI.dMX());
                        c17067b.mo28408b(C16067a.ati(QI.kWz), QI.Adj, QI.dMW(), QI.dMX(), i - QI.jis, QI.tVA, QI.tVB);
                        c17067b.Abf = QI.kWz;
                        C25052j.m39376p(bZ, "emoji");
                        c17067b.Abh.addAll(bZ);
                        break;
                    }
                    c16043a.AbL.setVisibility(8);
                    c16043a.AbC.setVisibility(0);
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(63003);
        return view;
    }

    public final int getCount() {
        return this.mCount;
    }

    public final void refreshData() {
        AppMethodBeat.m2504i(63005);
        this.mCount = this.Aaj.dNs();
        C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "refresh data mCount:%d", Integer.valueOf(this.mCount));
        AppMethodBeat.m2505o(63005);
    }

    /* renamed from: aJ */
    public final void mo28410aJ(int i, boolean z) {
        AppMethodBeat.m2504i(63006);
        this.Abx = i;
        if (this.Abx != 0 || z) {
            this.Aaj.dNy();
            if (this.AbA != null) {
                C5737h c5737h = (C5737h) this.AbA.get();
                if (c5737h != null) {
                    C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "update at page " + this.Abx);
                    c5737h.update();
                }
                AppMethodBeat.m2505o(63006);
                return;
            }
        }
        this.Aby = true;
        AppMethodBeat.m2505o(63006);
    }

    public final float getPageWidth(int i) {
        AppMethodBeat.m2504i(63002);
        float f;
        if (this.Aaj.dNx() && i == 0) {
            f = 4.0f / ((float) this.Aaj.mo28456QI(i).tVB);
            AppMethodBeat.m2505o(63002);
            return f;
        }
        f = super.getPageWidth(i);
        AppMethodBeat.m2505o(63002);
        return f;
    }

    public final int getItemPosition(Object obj) {
        AppMethodBeat.m2504i(63004);
        if (this.Abw) {
            C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "get item position always changed");
            AppMethodBeat.m2505o(63004);
            return -2;
        }
        int itemPosition = super.getItemPosition(obj);
        AppMethodBeat.m2505o(63004);
        return itemPosition;
    }
}
