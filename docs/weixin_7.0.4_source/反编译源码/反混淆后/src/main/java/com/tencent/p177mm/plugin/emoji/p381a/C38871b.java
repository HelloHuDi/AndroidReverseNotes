package com.tencent.p177mm.plugin.emoji.p381a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.emoji.a.b */
public final class C38871b {
    private final String TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    public View kRR;
    public String kRZ;
    public ImageView kSa;
    public ImageView kSb;
    public TextView klC;
    public Context mContext;

    public C38871b(Context context) {
        AppMethodBeat.m2504i(52719);
        this.mContext = context;
        this.kRR = C5616v.m8409hu(this.mContext).inflate(2130969369, null);
        bju();
        AppMethodBeat.m2505o(52719);
    }

    public C38871b(Context context, View view) {
        AppMethodBeat.m2504i(52720);
        this.mContext = context;
        this.kRR = view;
        bju();
        AppMethodBeat.m2505o(52720);
    }

    private void bju() {
        AppMethodBeat.m2504i(52721);
        if (this.kRR == null) {
            C4990ab.m7420w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
            AppMethodBeat.m2505o(52721);
            return;
        }
        this.kSa = (ImageView) this.kRR.findViewById(2131823474);
        this.klC = (TextView) this.kRR.findViewById(2131823564);
        this.kSb = (ImageView) this.kRR.findViewById(2131823558);
        AppMethodBeat.m2505o(52721);
    }
}
