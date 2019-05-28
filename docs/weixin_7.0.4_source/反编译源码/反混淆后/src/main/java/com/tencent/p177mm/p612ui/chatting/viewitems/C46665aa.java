package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.chatting.HardDeviceChattingItemView;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.aa */
public final class C46665aa extends C5378c {
    private C46650a yJI;

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.aa$a */
    final class C23818a extends C5379a {
        protected TextView zfK;
        protected TextView zfL;
        protected TextView zfM;
        protected TextView zfN;
        protected TextView zfO;
        protected TextView zfP;
        protected ImageView zfQ;

        C23818a() {
        }

        /* renamed from: ff */
        public final C23818a mo39627ff(View view) {
            AppMethodBeat.m2504i(33212);
            super.mo11031eP(view);
            this.zfK = (TextView) view.findViewById(2131822644);
            this.zfM = (TextView) view.findViewById(2131822642);
            this.zfL = (TextView) view.findViewById(2131822645);
            this.zfN = (TextView) view.findViewById(2131822643);
            this.zfO = (TextView) view.findViewById(2131822648);
            this.zfP = (TextView) view.findViewById(2131822646);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.zfQ = (ImageView) view.findViewById(2131822647);
            AppMethodBeat.m2505o(33212);
            return this;
        }
    }

    public final boolean dHk() {
        return false;
    }

    /* renamed from: aH */
    public final boolean mo11016aH(int i, boolean z) {
        if (i == -1879048185) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final View mo11005a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.m2504i(33213);
        if (view == null || view.getTag() == null) {
            view = new C44341v(layoutInflater, 2130969077);
            view.setTag(new C23818a().mo39627ff(view));
        }
        AppMethodBeat.m2505o(33213);
        return view;
    }

    /* renamed from: a */
    public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
        String str2;
        String str3;
        C8910b c8910b;
        AppMethodBeat.m2504i(33214);
        this.yJI = c46650a;
        C23818a c23818a = (C23818a) c5379a;
        C8909j ma = C14877am.dhN().mo27204ma(c7620bi.field_msgId);
        String str4 = c7620bi.field_content;
        if (ma == null || str4 == null) {
            boolean z;
            str2 = "MicroMsg.ChattingItemHardDeviceMsg";
            str3 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            if (ma == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str4;
            objArr[2] = Long.valueOf(c7620bi.field_msgId);
            objArr[3] = str;
            C4990ab.m7413e(str2, str3, objArr);
            c8910b = null;
        } else {
            c8910b = C8910b.m16058X(str4, c7620bi.field_reserved);
        }
        C40814ay c40814ay = new C40814ay(c7620bi, c46650a.dFx(), i, null, 0);
        HardDeviceChattingItemView hardDeviceChattingItemView = (HardDeviceChattingItemView) c5379a.jPL;
        if (c8910b != null && (c8910b.showType == 1 || c8910b.fhn == 1)) {
            int i2;
            if (C42252ah.isNullOrNil(c8910b.fhi)) {
                str2 = c8910b.color;
                str4 = c8910b.fhf;
                if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str4)) {
                    C4990ab.m7413e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", str2, str4);
                    str2 = "#ffffff";
                    str4 = "#ffffff";
                }
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(Color.parseColor(str4)));
                stateListDrawable.addState(new int[]{16842908}, new ColorDrawable(Color.parseColor(str4)));
                stateListDrawable.addState(new int[]{16842766}, new ColorDrawable(Color.parseColor(str2)));
                stateListDrawable.addState(new int[0], new ColorDrawable(Color.parseColor(str2)));
                hardDeviceChattingItemView.setBackgroundDrawable(stateListDrawable);
                c8910b.fhi = "#ffffff";
                str2 = c8910b.fhg;
                str3 = c8910b.fhh;
                int i3 = C25738R.color.a69;
                i2 = C25738R.color.a69;
                if (!(C42252ah.isNullOrNil(str2) || C42252ah.isNullOrNil(str3))) {
                    try {
                        i3 = Color.parseColor(str2);
                        i2 = Color.parseColor(str3);
                    } catch (IllegalArgumentException e) {
                        C4990ab.m7420w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
                    }
                }
                StateListDrawable stateListDrawable2 = new StateListDrawable();
                stateListDrawable2.addState(new int[]{16842919}, new ColorDrawable(i2));
                stateListDrawable2.addState(new int[]{16842908}, new ColorDrawable(i2));
                stateListDrawable2.addState(new int[]{16842766}, new ColorDrawable(i3));
                stateListDrawable2.addState(new int[0], new ColorDrawable(i3));
                c23818a.zfP.setBackgroundDrawable(stateListDrawable2);
            }
            str4 = c8910b.fhi;
            if (c23818a != null) {
                i2 = C25738R.color.a69;
                if (!C42252ah.isNullOrNil(str4)) {
                    try {
                        i2 = Color.parseColor(str4);
                    } catch (IllegalArgumentException e2) {
                        C4990ab.m7420w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
                    }
                }
                c23818a.zfM.setTextColor(i2);
                c23818a.zfN.setTextColor(i2);
                c23818a.zfK.setTextColor(i2);
                c23818a.zfL.setTextColor(i2);
                c23818a.zfO.setTextColor(i2);
            }
            c23818a.zfM.setText(c8910b.fhb);
            c23818a.zfN.setText(c8910b.fgZ);
            c23818a.zfK.setText(c8910b.fhd);
            c23818a.zfL.setText(c8910b.fhc);
            c23818a.zfO.setText(c8910b.fhe);
            if (C42252ah.isNullOrNil(c8910b.fhj)) {
                c23818a.zfQ.setVisibility(8);
            } else {
                c23818a.zfQ.setVisibility(0);
                C40460b.m69438s(c23818a.zfQ, c8910b.fhj);
            }
        }
        c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
        c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
        c5379a.jPL.setTag(c40814ay);
        c5379a.jPL.setOnClickListener(mo11022d(c46650a));
        AppMethodBeat.m2505o(33214);
    }

    /* renamed from: a */
    public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33215);
        contextMenu.add(((C40814ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
        AppMethodBeat.m2505o(33215);
        return false;
    }

    /* renamed from: a */
    public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33216);
        menuItem.getItemId();
        AppMethodBeat.m2505o(33216);
        return false;
    }

    /* renamed from: b */
    public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
        boolean z = false;
        AppMethodBeat.m2504i(33217);
        String str = c7620bi.field_content;
        C8910b X = C8910b.m16058X(str, c7620bi.field_reserved);
        if (X == null) {
            C4990ab.m7416i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
            AppMethodBeat.m2505o(33217);
            return false;
        }
        C4990ab.m7411d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", X.url);
        Intent intent;
        if (C42252ah.isNullOrNil(X.url)) {
            if (!C42252ah.isNullOrNil(X.fha)) {
                if (System.currentTimeMillis() - (((long) X.fhp) * 1000) >= 2592000000L) {
                    z = true;
                }
                if (!z) {
                    intent = new Intent();
                    intent.putExtra("key_rank_info", str);
                    intent.putExtra("key_rank_semi", c7620bi.field_reserved);
                    intent.putExtra("key_rank_title", X.fhk);
                    intent.putExtra("key_champion_info", X.fhl);
                    intent.putExtra("key_champion_coverimg", X.fhl);
                    intent.putExtra("rank_id", X.fha);
                    intent.putExtra("app_username", X.appName);
                    intent.putExtra("device_type", X.fho);
                    intent.putExtra("key_champioin_username", X.fhj);
                    C25985d.m41467b(c46650a.yTx.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                    C22162d.m33785kT(28);
                    AppMethodBeat.m2505o(33217);
                    return true;
                }
            }
            C25985d.m41448H(c46650a.yTx.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
            AppMethodBeat.m2505o(33217);
            return true;
        }
        intent = new Intent();
        intent.putExtra("rawUrl", X.url);
        C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(33217);
        return true;
    }
}
