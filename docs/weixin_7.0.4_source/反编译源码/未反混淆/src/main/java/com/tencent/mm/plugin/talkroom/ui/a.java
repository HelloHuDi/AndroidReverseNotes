package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.o;

public final class a {
    private static final int[] gcc = new int[]{R.drawable.aab, R.drawable.aac, R.drawable.aad, R.drawable.aae, R.drawable.aaf, R.drawable.aag, R.drawable.aah};
    private static final int[] miN = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private Context context;
    private View miF;
    private View miG;
    private ImageView miH;
    private View miJ;
    private final ak miO = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(25888);
            super.handleMessage(message);
            a.this.szb.dismiss();
            AppMethodBeat.o(25888);
        }
    };
    private int saE;
    private o szb;
    private TextView szc;
    private ImageView szd;
    private View sze;

    public a(Context context) {
        AppMethodBeat.i(25889);
        this.context = context;
        this.saE = b.b(context, 180.0f);
        this.szb = new o(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.b27, null), -1, -2);
        this.miH = (ImageView) this.szb.getContentView().findViewById(R.id.br_);
        this.miJ = this.szb.getContentView().findViewById(R.id.brb);
        this.szc = (TextView) this.szb.getContentView().findViewById(R.id.brd);
        this.szd = (ImageView) this.szb.getContentView().findViewById(R.id.brc);
        this.sze = this.szb.getContentView().findViewById(R.id.f29);
        this.miF = this.szb.getContentView().findViewById(R.id.br7);
        this.miG = this.szb.getContentView().findViewById(R.id.bre);
        AppMethodBeat.o(25889);
    }
}
