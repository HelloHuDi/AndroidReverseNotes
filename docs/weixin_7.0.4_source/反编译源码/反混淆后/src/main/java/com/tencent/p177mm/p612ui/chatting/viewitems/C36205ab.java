package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.base.NoMeasuredTextView;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ab */
public final class C36205ab extends C5378c {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ab$a */
    final class C36206a extends C5379a {
        protected ImageView gvq;
        protected NoMeasuredTextView zfS;

        C36206a() {
        }

        /* renamed from: fg */
        public final C36206a mo57089fg(View view) {
            AppMethodBeat.m2504i(33218);
            super.mo11031eP(view);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.gvq = (ImageView) view.findViewById(2131822639);
            this.zfS = (NoMeasuredTextView) view.findViewById(2131822641);
            AppMethodBeat.m2505o(33218);
            return this;
        }
    }

    public final boolean dHk() {
        return false;
    }

    /* renamed from: aH */
    public final boolean mo11016aH(int i, boolean z) {
        if (i == -1879048183) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final View mo11005a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.m2504i(33219);
        if (view == null || view.getTag() == null) {
            view = new C44341v(layoutInflater, 2130969076);
            view.setTag(new C36206a().mo57089fg(view));
        }
        AppMethodBeat.m2505o(33219);
        return view;
    }

    /* renamed from: a */
    public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
        C8910b c8910b;
        AppMethodBeat.m2504i(33220);
        C36206a c36206a = (C36206a) c5379a;
        C8909j ma = C14877am.dhN().mo27204ma(c7620bi.field_msgId);
        String str2 = c7620bi.field_content;
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
            objArr[2] = Long.valueOf(c7620bi.field_msgId);
            objArr[3] = str;
            C4990ab.m7413e(str3, str4, objArr);
            c8910b = null;
        } else {
            c8910b = C8910b.m16058X(str2, c7620bi.field_reserved);
        }
        C40814ay c40814ay = new C40814ay(c7620bi, c46650a.dFx(), i, null, 0);
        if (c8910b != null && (c8910b.showType == 2 || c8910b.fhn == 2 || c8910b.fhn == 4)) {
            C40460b.m69438s(c36206a.gvq, c8910b.fhr);
            c36206a.zfS.setTextSize(0, c46650a.yTx.getMMResources().getDimension(C25738R.dimen.f9980m5));
            c36206a.zfS.setTextColor(Color.parseColor("#BF000000"));
            c36206a.zfS.setEllipsize(TruncateAt.END);
            c36206a.zfS.setSingleLine(true);
            c36206a.zfS.setShouldEllipsize(true);
            c36206a.zfS.setText(C44089j.m79292b(c46650a.yTx.getContext(), c8910b.fhq));
        }
        c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
        c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
        c5379a.jPL.setTag(c40814ay);
        c5379a.jPL.setOnClickListener(mo11022d(c46650a));
        AppMethodBeat.m2505o(33220);
    }

    /* renamed from: a */
    public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33221);
        contextMenu.add(((C40814ay) view.getTag()).position, 100, 0, view.getContext().getString(C25738R.string.am7));
        AppMethodBeat.m2505o(33221);
        return false;
    }

    /* renamed from: a */
    public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33222);
        menuItem.getItemId();
        AppMethodBeat.m2505o(33222);
        return false;
    }

    /* renamed from: b */
    public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33223);
        C4990ab.m7416i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
        if (c7620bi == null) {
            C4990ab.m7416i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
            AppMethodBeat.m2505o(33223);
            return false;
        }
        String str = c7620bi.field_content;
        C8910b X = C8910b.m16058X(str, c7620bi.field_reserved);
        if (X == null) {
            C4990ab.m7416i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
            AppMethodBeat.m2505o(33223);
            return false;
        }
        C4990ab.m7411d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", X.url);
        if (C42252ah.isNullOrNil(X.url)) {
            C9638aw.m17190ZK();
            Intent intent;
            if (C18628c.m29078XM().aoO(X.fhr).mo16699Ob()) {
                C4990ab.m7416i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
            } else if (X.showType == 2) {
                if (C42252ah.isNullOrNil(X.fha)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_is_latest", true);
                    intent2.putExtra("app_username", X.appName);
                    intent2.putExtra("device_type", X.fho);
                    intent2.putExtra("locate_to_username", X.fhr);
                    C25985d.m41467b(c46650a.yTx.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent2);
                } else {
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
                    intent.putExtra("locate_to_username", X.fhr);
                    C25985d.m41467b(c46650a.yTx.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                }
                C22162d.m33785kT(30);
            } else if (X.showType == 4) {
                intent = new Intent();
                intent.putExtra("username", X.fhr);
                intent.putExtra("app_username", "gh_43f2581f6fd6");
                C25985d.m41467b(c46650a.yTx.getContext(), "exdevice", ".ui.ExdeviceProfileUI", intent);
                C22162d.m33785kT(29);
            }
            AppMethodBeat.m2505o(33223);
            return false;
        }
        Intent intent3 = new Intent();
        intent3.putExtra("rawUrl", X.url);
        C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent3);
        AppMethodBeat.m2505o(33223);
        return true;
    }
}
