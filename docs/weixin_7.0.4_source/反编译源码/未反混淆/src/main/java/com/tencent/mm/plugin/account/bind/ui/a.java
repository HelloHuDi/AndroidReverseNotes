package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.p;

public final class a extends p<n> {
    private String gqn;
    a gsZ;
    private Context mContext;
    private String mFilter;
    private LayoutInflater mLayoutInflater = LayoutInflater.from(this.mContext);

    interface a {
        void mS(int i);
    }

    class b {
        ImageView eks;
        TextView gnh;
        String gta;
        TextView gtb;
        TextView gtc;
        View gtd;
        ProgressBar gte;
        int position;

        public b(View view) {
            AppMethodBeat.i(13643);
            this.eks = (ImageView) view.findViewById(R.id.c_a);
            this.gtb = (TextView) view.findViewById(R.id.c_b);
            this.gtd = view.findViewById(R.id.c_d);
            this.gnh = (TextView) view.findViewById(R.id.c_e);
            this.gte = (ProgressBar) view.findViewById(R.id.c_f);
            this.gtc = (TextView) view.findViewById(R.id.c_c);
            this.gtd.setOnClickListener(new OnClickListener(a.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(13642);
                    ab.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
                    if (a.this.gsZ != null) {
                        a.this.gsZ.mS(b.this.position);
                    }
                    AppMethodBeat.o(13642);
                }
            });
            AppMethodBeat.o(13643);
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(13649);
        n nVar = (n) obj;
        if (nVar == null) {
            nVar = new n();
        }
        nVar.d(cursor);
        AppMethodBeat.o(13649);
        return nVar;
    }

    public a(Context context, String str) {
        super(context, new n());
        AppMethodBeat.i(13644);
        this.gqn = str;
        this.mContext = context;
        AppMethodBeat.o(13644);
    }

    public final void KD() {
        AppMethodBeat.i(13645);
        KC();
        AppMethodBeat.o(13645);
    }

    public final void KC() {
        AppMethodBeat.i(13646);
        setCursor(((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).bi(this.mFilter, this.gqn));
        super.notifyDataSetChanged();
        AppMethodBeat.o(13646);
    }

    public final void vM(String str) {
        AppMethodBeat.i(13647);
        this.mFilter = bo.vA(str);
        bIf();
        KC();
        AppMethodBeat.o(13647);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(13648);
        if (view == null || view.getTag() == null) {
            view = this.mLayoutInflater.inflate(R.layout.a68, null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        n nVar = (n) getItem(i);
        if (nVar == null) {
            AppMethodBeat.o(13648);
        } else {
            bVar.position = i;
            bVar.gta = nVar.field_googlegmail;
            Bitmap a;
            switch (nVar.field_status) {
                case 0:
                case 2:
                    if (nVar.field_small_url != null) {
                        a = com.tencent.mm.ah.b.a(nVar.field_username, false, -1);
                    } else {
                        a = null;
                    }
                    if (a != null) {
                        bVar.eks.setImageBitmap(a);
                        break;
                    }
                    bVar.eks.setImageDrawable(com.tencent.mm.bz.a.g(this.mContext, R.raw.default_avatar));
                    break;
                case 1:
                    a = com.tencent.mm.ah.b.pP(nVar.field_googleid);
                    if (a != null) {
                        bVar.eks.setImageBitmap(a);
                        break;
                    }
                    bVar.eks.setImageDrawable(com.tencent.mm.bz.a.g(this.mContext, R.raw.default_avatar));
                    break;
            }
            if (TextUtils.isEmpty(nVar.field_googlename)) {
                bVar.gtb.setText(bo.anu(nVar.field_googlegmail));
            } else {
                bVar.gtb.setText(nVar.field_googlename);
            }
            switch (nVar.field_status) {
                case 0:
                    bVar.gtd.setClickable(true);
                    bVar.gtd.setBackgroundResource(R.drawable.fp);
                    bVar.gnh.setText(R.string.c8d);
                    bVar.gnh.setTextColor(this.mContext.getResources().getColor(R.color.a69));
                    break;
                case 1:
                    bVar.gtd.setClickable(true);
                    bVar.gtd.setBackgroundResource(R.drawable.fr);
                    bVar.gnh.setText(R.string.c8l);
                    bVar.gnh.setTextColor(this.mContext.getResources().getColor(R.color.t4));
                    break;
                case 2:
                    bVar.gtd.setClickable(false);
                    bVar.gtd.setBackgroundDrawable(null);
                    bVar.gnh.setText(R.string.c8f);
                    bVar.gnh.setTextColor(this.mContext.getResources().getColor(R.color.t4));
                    break;
            }
            switch (nVar.field_googlecgistatus) {
                case 0:
                    bVar.gnh.setVisibility(4);
                    bVar.gte.setVisibility(0);
                    break;
                case 1:
                    bVar.gtd.setClickable(false);
                    bVar.gtd.setBackgroundDrawable(null);
                    bVar.gnh.setVisibility(0);
                    bVar.gte.setVisibility(8);
                    bVar.gnh.setTextColor(this.mContext.getResources().getColor(R.color.t4));
                    switch (nVar.field_status) {
                        case 0:
                            bVar.gnh.setText(R.string.c8e);
                            break;
                        case 1:
                            bVar.gnh.setText(R.string.c8m);
                            break;
                    }
                    break;
                case 2:
                    bVar.gnh.setVisibility(0);
                    bVar.gte.setVisibility(8);
                    switch (nVar.field_status) {
                        case 0:
                            bVar.gnh.setText(R.string.c8d);
                            bVar.gnh.setTextColor(this.mContext.getResources().getColor(R.color.a69));
                            break;
                        case 1:
                            bVar.gnh.setText(R.string.c8l);
                            bVar.gnh.setTextColor(this.mContext.getResources().getColor(R.color.t4));
                            break;
                    }
                    break;
            }
            bVar.gtc.setText(nVar.field_googlegmail);
            AppMethodBeat.o(13648);
        }
        return view;
    }
}
