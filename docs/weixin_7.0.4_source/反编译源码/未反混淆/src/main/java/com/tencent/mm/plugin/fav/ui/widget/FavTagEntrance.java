package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class FavTagEntrance extends LinearLayout implements a {
    private long cHh = -1;
    private TextView mpW;
    private String mpX = String.valueOf(this.cHh);

    public FavTagEntrance(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(74700);
        AppMethodBeat.o(74700);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(74701);
        super.onFinishInflate();
        this.mpW = (TextView) findViewById(R.id.bsh);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(74699);
                Intent intent = new Intent();
                intent.putExtra("key_fav_scene", 1);
                intent.putExtra("key_fav_item_id", FavTagEntrance.this.cHh);
                b.b(FavTagEntrance.this.getContext(), ".ui.FavTagEditUI", intent);
                AppMethodBeat.o(74699);
            }
        });
        AppMethodBeat.o(74701);
    }

    public void setFavItemID(long j) {
        AppMethodBeat.i(74702);
        this.cHh = j;
        this.mpX = String.valueOf(j);
        AppMethodBeat.o(74702);
    }

    public void setTagContent(List<String> list) {
        AppMethodBeat.i(74703);
        if (this.mpW == null) {
            AppMethodBeat.o(74703);
            return;
        }
        CharSequence charSequence;
        Context context = getContext();
        if (context == null || list == null || list.isEmpty()) {
            charSequence = "";
        } else {
            String str = (String) list.get(0);
            String string = context.getResources().getString(R.string.brz);
            charSequence = str;
            for (int i = 1; i < list.size(); i++) {
                charSequence = charSequence + string + ((String) list.get(i));
            }
        }
        if (bo.isNullOrNil(charSequence)) {
            this.mpW.setText("");
            this.mpW.setHint(R.string.boc);
            AppMethodBeat.o(74703);
            return;
        }
        this.mpW.setText(j.b(getContext(), charSequence, this.mpW.getTextSize()));
        AppMethodBeat.o(74703);
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(74704);
        ab.d("MicroMsg.FavTagEntrence", "on notify change event %s, favIDStr %s", str, this.mpX);
        if (this.mpX.equals(str)) {
            g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(this.cHh);
            if (iE == null) {
                ab.w("MicroMsg.FavTagEntrence", "id[%d] info is null, return", Long.valueOf(this.cHh));
                AppMethodBeat.o(74704);
                return;
            }
            setTagContent(iE.field_tagProto.wiJ);
        }
        AppMethodBeat.o(74704);
    }
}
