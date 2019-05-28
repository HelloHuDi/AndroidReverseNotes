package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bp.d;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.ui.chatting.c.b.h;

public final class aa extends c {
    private com.tencent.mm.ui.chatting.d.a yJI;

    final class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        protected TextView zfK;
        protected TextView zfL;
        protected TextView zfM;
        protected TextView zfN;
        protected TextView zfO;
        protected TextView zfP;
        protected ImageView zfQ;

        a() {
        }

        public final a ff(View view) {
            AppMethodBeat.i(33212);
            super.eP(view);
            this.zfK = (TextView) view.findViewById(R.id.asq);
            this.zfM = (TextView) view.findViewById(R.id.aso);
            this.zfL = (TextView) view.findViewById(R.id.asr);
            this.zfN = (TextView) view.findViewById(R.id.asp);
            this.zfO = (TextView) view.findViewById(R.id.asu);
            this.zfP = (TextView) view.findViewById(R.id.ass);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.zfQ = (ImageView) view.findViewById(R.id.ast);
            AppMethodBeat.o(33212);
            return this;
        }
    }

    public final boolean dHk() {
        return false;
    }

    public final boolean aH(int i, boolean z) {
        if (i == -1879048185) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(33213);
        if (view == null || view.getTag() == null) {
            view = new v(layoutInflater, R.layout.mt);
            view.setTag(new a().ff(view));
        }
        AppMethodBeat.o(33213);
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
        String str2;
        String str3;
        b bVar;
        AppMethodBeat.i(33214);
        this.yJI = aVar2;
        a aVar3 = (a) aVar;
        j ma = am.dhN().ma(biVar.field_msgId);
        String str4 = biVar.field_content;
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
            objArr[2] = Long.valueOf(biVar.field_msgId);
            objArr[3] = str;
            ab.e(str2, str3, objArr);
            bVar = null;
        } else {
            bVar = b.X(str4, biVar.field_reserved);
        }
        ay ayVar = new ay(biVar, aVar2.dFx(), i, null, 0);
        HardDeviceChattingItemView hardDeviceChattingItemView = (HardDeviceChattingItemView) aVar.jPL;
        if (bVar != null && (bVar.showType == 1 || bVar.fhn == 1)) {
            int i2;
            if (ah.isNullOrNil(bVar.fhi)) {
                str2 = bVar.color;
                str4 = bVar.fhf;
                if (bo.isNullOrNil(str2) || bo.isNullOrNil(str4)) {
                    ab.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", str2, str4);
                    str2 = "#ffffff";
                    str4 = "#ffffff";
                }
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(Color.parseColor(str4)));
                stateListDrawable.addState(new int[]{16842908}, new ColorDrawable(Color.parseColor(str4)));
                stateListDrawable.addState(new int[]{16842766}, new ColorDrawable(Color.parseColor(str2)));
                stateListDrawable.addState(new int[0], new ColorDrawable(Color.parseColor(str2)));
                hardDeviceChattingItemView.setBackgroundDrawable(stateListDrawable);
                bVar.fhi = "#ffffff";
                str2 = bVar.fhg;
                str3 = bVar.fhh;
                int i3 = R.color.a69;
                i2 = R.color.a69;
                if (!(ah.isNullOrNil(str2) || ah.isNullOrNil(str3))) {
                    try {
                        i3 = Color.parseColor(str2);
                        i2 = Color.parseColor(str3);
                    } catch (IllegalArgumentException e) {
                        ab.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
                    }
                }
                StateListDrawable stateListDrawable2 = new StateListDrawable();
                stateListDrawable2.addState(new int[]{16842919}, new ColorDrawable(i2));
                stateListDrawable2.addState(new int[]{16842908}, new ColorDrawable(i2));
                stateListDrawable2.addState(new int[]{16842766}, new ColorDrawable(i3));
                stateListDrawable2.addState(new int[0], new ColorDrawable(i3));
                aVar3.zfP.setBackgroundDrawable(stateListDrawable2);
            }
            str4 = bVar.fhi;
            if (aVar3 != null) {
                i2 = R.color.a69;
                if (!ah.isNullOrNil(str4)) {
                    try {
                        i2 = Color.parseColor(str4);
                    } catch (IllegalArgumentException e2) {
                        ab.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
                    }
                }
                aVar3.zfM.setTextColor(i2);
                aVar3.zfN.setTextColor(i2);
                aVar3.zfK.setTextColor(i2);
                aVar3.zfL.setTextColor(i2);
                aVar3.zfO.setTextColor(i2);
            }
            aVar3.zfM.setText(bVar.fhb);
            aVar3.zfN.setText(bVar.fgZ);
            aVar3.zfK.setText(bVar.fhd);
            aVar3.zfL.setText(bVar.fhc);
            aVar3.zfO.setText(bVar.fhe);
            if (ah.isNullOrNil(bVar.fhj)) {
                aVar3.zfQ.setVisibility(8);
            } else {
                aVar3.zfQ.setVisibility(0);
                com.tencent.mm.pluginsdk.ui.a.b.s(aVar3.zfQ, bVar.fhj);
            }
        }
        aVar.jPL.setOnLongClickListener(c(aVar2));
        aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
        aVar.jPL.setTag(ayVar);
        aVar.jPL.setOnClickListener(d(aVar2));
        AppMethodBeat.o(33214);
    }

    public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
        AppMethodBeat.i(33215);
        contextMenu.add(((ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
        AppMethodBeat.o(33215);
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        AppMethodBeat.i(33216);
        menuItem.getItemId();
        AppMethodBeat.o(33216);
        return false;
    }

    public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        boolean z = false;
        AppMethodBeat.i(33217);
        String str = biVar.field_content;
        b X = b.X(str, biVar.field_reserved);
        if (X == null) {
            ab.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
            AppMethodBeat.o(33217);
            return false;
        }
        ab.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", X.url);
        Intent intent;
        if (ah.isNullOrNil(X.url)) {
            if (!ah.isNullOrNil(X.fha)) {
                if (System.currentTimeMillis() - (((long) X.fhp) * 1000) >= 2592000000L) {
                    z = true;
                }
                if (!z) {
                    intent = new Intent();
                    intent.putExtra("key_rank_info", str);
                    intent.putExtra("key_rank_semi", biVar.field_reserved);
                    intent.putExtra("key_rank_title", X.fhk);
                    intent.putExtra("key_champion_info", X.fhl);
                    intent.putExtra("key_champion_coverimg", X.fhl);
                    intent.putExtra("rank_id", X.fha);
                    intent.putExtra("app_username", X.appName);
                    intent.putExtra("device_type", X.fho);
                    intent.putExtra("key_champioin_username", X.fhj);
                    d.b(aVar.yTx.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                    com.tencent.mm.plugin.sport.a.d.kT(28);
                    AppMethodBeat.o(33217);
                    return true;
                }
            }
            d.H(aVar.yTx.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
            AppMethodBeat.o(33217);
            return true;
        }
        intent = new Intent();
        intent.putExtra("rawUrl", X.url);
        d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(33217);
        return true;
    }
}
