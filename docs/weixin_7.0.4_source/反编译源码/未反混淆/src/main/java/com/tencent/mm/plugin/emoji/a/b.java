package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.v;

public final class b {
    private final String TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    public View kRR;
    public String kRZ;
    public ImageView kSa;
    public ImageView kSb;
    public TextView klC;
    public Context mContext;

    public b(Context context) {
        AppMethodBeat.i(52719);
        this.mContext = context;
        this.kRR = v.hu(this.mContext).inflate(R.layout.uo, null);
        bju();
        AppMethodBeat.o(52719);
    }

    public b(Context context, View view) {
        AppMethodBeat.i(52720);
        this.mContext = context;
        this.kRR = view;
        bju();
        AppMethodBeat.o(52720);
    }

    private void bju() {
        AppMethodBeat.i(52721);
        if (this.kRR == null) {
            ab.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
            AppMethodBeat.o(52721);
            return;
        }
        this.kSa = (ImageView) this.kRR.findViewById(R.id.be7);
        this.klC = (TextView) this.kRR.findViewById(R.id.bgm);
        this.kSb = (ImageView) this.kRR.findViewById(R.id.bgg);
        AppMethodBeat.o(52721);
    }
}
