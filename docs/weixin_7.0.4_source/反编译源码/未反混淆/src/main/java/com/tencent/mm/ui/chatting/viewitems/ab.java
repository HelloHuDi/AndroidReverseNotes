package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.chatting.c.b.h;

public final class ab extends c {

    final class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        protected ImageView gvq;
        protected NoMeasuredTextView zfS;

        a() {
        }

        public final a fg(View view) {
            AppMethodBeat.i(33218);
            super.eP(view);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.gvq = (ImageView) view.findViewById(R.id.asl);
            this.zfS = (NoMeasuredTextView) view.findViewById(R.id.asn);
            AppMethodBeat.o(33218);
            return this;
        }
    }

    public final boolean dHk() {
        return false;
    }

    public final boolean aH(int i, boolean z) {
        if (i == -1879048183) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(33219);
        if (view == null || view.getTag() == null) {
            view = new v(layoutInflater, R.layout.ms);
            view.setTag(new a().fg(view));
        }
        AppMethodBeat.o(33219);
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
        b bVar;
        AppMethodBeat.i(33220);
        a aVar3 = (a) aVar;
        j ma = am.dhN().ma(biVar.field_msgId);
        String str2 = biVar.field_content;
        if (ma == null || str2 == null) {
            boolean z;
            String str3 = "MicrMsg.ChattingItemHardDeviceMsgLike";
            String str4 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            if (ma == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(biVar.field_msgId);
            objArr[3] = str;
            com.tencent.mm.sdk.platformtools.ab.e(str3, str4, objArr);
            bVar = null;
        } else {
            bVar = b.X(str2, biVar.field_reserved);
        }
        ay ayVar = new ay(biVar, aVar2.dFx(), i, null, 0);
        if (bVar != null && (bVar.showType == 2 || bVar.fhn == 2 || bVar.fhn == 4)) {
            com.tencent.mm.pluginsdk.ui.a.b.s(aVar3.gvq, bVar.fhr);
            aVar3.zfS.setTextSize(0, aVar2.yTx.getMMResources().getDimension(R.dimen.m5));
            aVar3.zfS.setTextColor(Color.parseColor("#BF000000"));
            aVar3.zfS.setEllipsize(TruncateAt.END);
            aVar3.zfS.setSingleLine(true);
            aVar3.zfS.setShouldEllipsize(true);
            aVar3.zfS.setText(com.tencent.mm.pluginsdk.ui.e.j.b(aVar2.yTx.getContext(), bVar.fhq));
        }
        aVar.jPL.setOnLongClickListener(c(aVar2));
        aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
        aVar.jPL.setTag(ayVar);
        aVar.jPL.setOnClickListener(d(aVar2));
        AppMethodBeat.o(33220);
    }

    public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
        AppMethodBeat.i(33221);
        contextMenu.add(((ay) view.getTag()).position, 100, 0, view.getContext().getString(R.string.am7));
        AppMethodBeat.o(33221);
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        AppMethodBeat.i(33222);
        menuItem.getItemId();
        AppMethodBeat.o(33222);
        return false;
    }

    public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        AppMethodBeat.i(33223);
        com.tencent.mm.sdk.platformtools.ab.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
        if (biVar == null) {
            com.tencent.mm.sdk.platformtools.ab.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
            AppMethodBeat.o(33223);
            return false;
        }
        String str = biVar.field_content;
        b X = b.X(str, biVar.field_reserved);
        if (X == null) {
            com.tencent.mm.sdk.platformtools.ab.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
            AppMethodBeat.o(33223);
            return false;
        }
        com.tencent.mm.sdk.platformtools.ab.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", X.url);
        if (ah.isNullOrNil(X.url)) {
            aw.ZK();
            Intent intent;
            if (c.XM().aoO(X.fhr).Ob()) {
                com.tencent.mm.sdk.platformtools.ab.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
            } else if (X.showType == 2) {
                if (ah.isNullOrNil(X.fha)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_is_latest", true);
                    intent2.putExtra("app_username", X.appName);
                    intent2.putExtra("device_type", X.fho);
                    intent2.putExtra("locate_to_username", X.fhr);
                    d.b(aVar.yTx.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent2);
                } else {
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
                    intent.putExtra("locate_to_username", X.fhr);
                    d.b(aVar.yTx.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                }
                com.tencent.mm.plugin.sport.a.d.kT(30);
            } else if (X.showType == 4) {
                intent = new Intent();
                intent.putExtra("username", X.fhr);
                intent.putExtra("app_username", "gh_43f2581f6fd6");
                d.b(aVar.yTx.getContext(), "exdevice", ".ui.ExdeviceProfileUI", intent);
                com.tencent.mm.plugin.sport.a.d.kT(29);
            }
            AppMethodBeat.o(33223);
            return false;
        }
        Intent intent3 = new Intent();
        intent3.putExtra("rawUrl", X.url);
        d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent3);
        AppMethodBeat.o(33223);
        return true;
    }
}
