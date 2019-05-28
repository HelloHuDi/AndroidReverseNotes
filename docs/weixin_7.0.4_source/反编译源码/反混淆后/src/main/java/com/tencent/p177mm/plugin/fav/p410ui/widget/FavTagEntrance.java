package com.tencent.p177mm.plugin.fav.p410ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavTagEntrance */
public class FavTagEntrance extends LinearLayout implements C4931a {
    private long cHh = -1;
    private TextView mpW;
    private String mpX = String.valueOf(this.cHh);

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavTagEntrance$1 */
    class C119171 implements OnClickListener {
        C119171() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74699);
            Intent intent = new Intent();
            intent.putExtra("key_fav_scene", 1);
            intent.putExtra("key_fav_item_id", FavTagEntrance.this.cHh);
            C39037b.m66371b(FavTagEntrance.this.getContext(), ".ui.FavTagEditUI", intent);
            AppMethodBeat.m2505o(74699);
        }
    }

    public FavTagEntrance(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(74700);
        AppMethodBeat.m2505o(74700);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(74701);
        super.onFinishInflate();
        this.mpW = (TextView) findViewById(2131824003);
        setOnClickListener(new C119171());
        AppMethodBeat.m2505o(74701);
    }

    public void setFavItemID(long j) {
        AppMethodBeat.m2504i(74702);
        this.cHh = j;
        this.mpX = String.valueOf(j);
        AppMethodBeat.m2505o(74702);
    }

    public void setTagContent(List<String> list) {
        AppMethodBeat.m2504i(74703);
        if (this.mpW == null) {
            AppMethodBeat.m2505o(74703);
            return;
        }
        CharSequence charSequence;
        Context context = getContext();
        if (context == null || list == null || list.isEmpty()) {
            charSequence = "";
        } else {
            String str = (String) list.get(0);
            String string = context.getResources().getString(C25738R.string.brz);
            charSequence = str;
            for (int i = 1; i < list.size(); i++) {
                charSequence = charSequence + string + ((String) list.get(i));
            }
        }
        if (C5046bo.isNullOrNil(charSequence)) {
            this.mpW.setText("");
            this.mpW.setHint(C25738R.string.boc);
            AppMethodBeat.m2505o(74703);
            return;
        }
        this.mpW.setText(C44089j.m79293b(getContext(), charSequence, this.mpW.getTextSize()));
        AppMethodBeat.m2505o(74703);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(74704);
        C4990ab.m7411d("MicroMsg.FavTagEntrence", "on notify change event %s, favIDStr %s", str, this.mpX);
        if (this.mpX.equals(str)) {
            C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(this.cHh);
            if (iE == null) {
                C4990ab.m7421w("MicroMsg.FavTagEntrence", "id[%d] info is null, return", Long.valueOf(this.cHh));
                AppMethodBeat.m2505o(74704);
                return;
            }
            setTagContent(iE.field_tagProto.wiJ);
        }
        AppMethodBeat.m2505o(74704);
    }
}
