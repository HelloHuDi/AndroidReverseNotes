package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.i;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.widget.EllipsizingTextView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public final class e extends LinearLayout implements OnClickListener {
    private String mAppId;
    private Context mContext;
    private LayoutInflater mInflater = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private int mXC;

    static class a {
        public String jumpUrl;
        public String mVB;
        public int mYy;

        public a(int i, String str, String str2) {
            this.mYy = i;
            this.jumpUrl = str;
            this.mVB = str2;
        }
    }

    public e(Context context) {
        super(context);
        AppMethodBeat.i(111736);
        this.mContext = context;
        setOrientation(1);
        AppMethodBeat.o(111736);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(af afVar, String str, int i, int i2) {
        AppMethodBeat.i(111737);
        if (afVar == null || bo.ek(afVar.naO)) {
            setVisibility(8);
            AppMethodBeat.o(111737);
            return;
        }
        this.mAppId = str;
        this.mXC = i2;
        Iterator it = afVar.naO.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (iVar != null) {
                com.tencent.mm.plugin.game.f.e.a.a aVar = new com.tencent.mm.plugin.game.f.e.a.a();
                TextView textView;
                TextView textView2;
                switch (iVar.mZQ) {
                    case 1:
                        if (iVar.mZO == null) {
                            break;
                        }
                        n(this);
                        View inflate = this.mInflater.inflate(R.layout.a2f, this, false);
                        textView = (TextView) inflate.findViewById(R.id.c0o);
                        textView2 = (TextView) inflate.findViewById(R.id.c0p);
                        EllipsizingTextView ellipsizingTextView = (EllipsizingTextView) inflate.findViewById(R.id.c0q);
                        ellipsizingTextView.setMaxLines(2);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.c0n);
                        textView.setText(j.b(this.mContext, iVar.mZM, textView.getTextSize()));
                        textView2.setText(j.b(this.mContext, iVar.mZO.Title, textView2.getTextSize()));
                        ellipsizingTextView.setText(j.b(this.mContext, iVar.mZO.Desc, ellipsizingTextView.getTextSize()));
                        if (bo.isNullOrNil(iVar.mZO.mZi)) {
                            imageView.setVisibility(8);
                        } else {
                            com.tencent.mm.plugin.game.f.e.bFH().a(imageView, iVar.mZO.mZi, aVar.bFI());
                        }
                        inflate.setTag(new a(iVar.mZN, iVar.mZO.mZj, iVar.mZL));
                        inflate.setOnClickListener(this);
                        addView(inflate);
                    case 2:
                        if (iVar.mZP == null) {
                            break;
                        }
                        n(this);
                        View inflate2 = this.mInflater.inflate(R.layout.a2g, this, false);
                        textView = (TextView) inflate2.findViewById(R.id.c0s);
                        textView2 = (TextView) inflate2.findViewById(R.id.c0u);
                        ImageView imageView2 = (ImageView) inflate2.findViewById(R.id.c0t);
                        textView.setText(j.b(this.mContext, iVar.mZM, textView.getTextSize()));
                        textView2.setText(j.b(this.mContext, iVar.mZP.Title, textView2.getTextSize()));
                        if (bo.isNullOrNil(iVar.mZP.mZi)) {
                            imageView2.setVisibility(8);
                        } else {
                            if (iVar.mZP.ndC == 1) {
                                aVar.nnP = true;
                                aVar.nnS = R.drawable.af_;
                            } else {
                                aVar.eQf = true;
                                aVar.nnS = R.drawable.af9;
                            }
                            com.tencent.mm.plugin.game.f.e.bFH().a(imageView2, iVar.mZP.mZi, aVar.bFI());
                        }
                        inflate2.setTag(new a(iVar.mZN, iVar.mZP.mZj, iVar.mZL));
                        inflate2.setOnClickListener(this);
                        addView(inflate2);
                    default:
                        if (i != 2) {
                            break;
                        }
                        com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1002, iVar.mZN, str, i2, com.tencent.mm.plugin.game.e.a.kY(iVar.mZL));
                        break;
                }
            }
        }
        AppMethodBeat.o(111737);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(111738);
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            ab.w("MicroMsg.GameBlockContentView", "getTag is null");
            AppMethodBeat.o(111738);
            return;
        }
        a aVar = (a) view.getTag();
        if (bo.isNullOrNil(aVar.jumpUrl)) {
            ab.w("MicroMsg.GameBlockContentView", "jumpUrl is null");
            AppMethodBeat.o(111738);
            return;
        }
        b.a(this.mContext, 10, 1002, aVar.mYy, c.t(this.mContext, aVar.jumpUrl, "game_center_mygame_comm"), this.mAppId, this.mXC, com.tencent.mm.plugin.game.e.a.kY(aVar.mVB));
        AppMethodBeat.o(111738);
    }

    private void n(ViewGroup viewGroup) {
        AppMethodBeat.i(111739);
        ImageView imageView = (ImageView) this.mInflater.inflate(R.layout.a3m, viewGroup, false);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = com.tencent.mm.bz.a.fromDPToPix(this.mContext, 20);
        imageView.setLayoutParams(marginLayoutParams);
        viewGroup.addView(imageView);
        AppMethodBeat.o(111739);
    }
}
