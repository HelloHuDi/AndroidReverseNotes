package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.support.v4.widget.j;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h {

    static class a implements d {
        c ogG;

        a() {
        }

        public final void a(final Context context, ViewGroup viewGroup, final as asVar) {
            AppMethodBeat.i(42894);
            if (bo.isNullOrNil(asVar.name)) {
                ab.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
                viewGroup.setVisibility(8);
                AppMethodBeat.o(42894);
                return;
            }
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ScaleType.FIT_XY);
            x.h(imageView, asVar.name);
            if (!bo.isNullOrNil(asVar.content)) {
                imageView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(42893);
                        com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(asVar.nZn));
                        if (a.this.ogG != null) {
                            g.gu(a.this.ogG.ogM, 1);
                        }
                        com.tencent.mm.wallet_core.ui.e.n(context, asVar.content, true);
                        AppMethodBeat.o(42893);
                    }
                });
            }
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            viewGroup.addView(imageView);
            viewGroup.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(asVar.nZn));
            if (this.ogG != null) {
                g.gu(this.ogG.ogM, 0);
            }
            AppMethodBeat.o(42894);
        }
    }

    static class b implements d {
        c ogG;

        b() {
        }

        public final void a(final Context context, ViewGroup viewGroup, final as asVar) {
            AppMethodBeat.i(42897);
            if (bo.isNullOrNil(asVar.name)) {
                AppMethodBeat.o(42897);
                return;
            }
            TextView textView = new TextView(context);
            if (this.ogG == null || this.ogG.textColor == j.INVALID_ID) {
                textView.setTextColor(context.getResources().getColor(R.color.a4m));
            } else {
                textView.setTextColor(this.ogG.textColor);
            }
            if (this.ogG == null || this.ogG.textSize == j.INVALID_ID) {
                textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.dimen.kr));
            } else {
                textView.setTextSize(0, (float) this.ogG.textSize);
            }
            textView.setGravity(17);
            textView.setText(asVar.name);
            if (!bo.isNullOrNil(asVar.content)) {
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(42896);
                        com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(asVar.nZn));
                        if (asVar.nZo != 1) {
                            ((com.tencent.mm.pluginsdk.g) com.tencent.mm.kernel.g.K(com.tencent.mm.pluginsdk.g.class)).a(context, asVar.content, new n() {
                                public final void nZ(int i) {
                                    AppMethodBeat.i(42895);
                                    switch (i) {
                                        case -2:
                                        case 1:
                                            com.tencent.mm.wallet_core.ui.e.ag(context, asVar.content);
                                            break;
                                    }
                                    AppMethodBeat.o(42895);
                                }
                            }).show();
                            AppMethodBeat.o(42896);
                            return;
                        }
                        com.tencent.mm.wallet_core.ui.e.ae(context, asVar.content);
                        AppMethodBeat.o(42896);
                    }
                });
            }
            viewGroup.addView(textView, new LayoutParams(-2, -2));
            viewGroup.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(asVar.nZn));
            AppMethodBeat.o(42897);
        }
    }

    public static final class c {
        public boolean ogL = false;
        public int ogM = 0;
        public atb ogN;
        public int resourceId = 0;
        public int textColor = j.INVALID_ID;
        public int textSize = j.INVALID_ID;
    }

    static class e implements d {
        c ogG;

        e() {
        }

        public final void a(final Context context, ViewGroup viewGroup, final as asVar) {
            AppMethodBeat.i(42899);
            if (bo.isNullOrNil(asVar.name)) {
                AppMethodBeat.o(42899);
                return;
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.aan, viewGroup, true);
            TextView textView = (TextView) inflate.findViewById(R.id.d0j);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.d0i);
            if (bo.isNullOrNil(asVar.iconUrl)) {
                imageView.setVisibility(8);
            } else {
                x.h(imageView, asVar.iconUrl);
                imageView.setVisibility(0);
            }
            if (!(this.ogG == null || this.ogG.textColor == j.INVALID_ID)) {
                textView.setTextColor(this.ogG.textColor);
            }
            if (this.ogG == null || this.ogG.textSize == j.INVALID_ID) {
                textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.dimen.kr));
            } else {
                textView.setTextSize(0, (float) this.ogG.textSize);
            }
            textView.setGravity(17);
            textView.setText(asVar.name);
            if (!bo.isNullOrNil(asVar.content)) {
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(42898);
                        com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(asVar.nZn));
                        if (e.this.ogG != null) {
                            g.gu(e.this.ogG.ogM, 1);
                        }
                        if (e.this.ogG != null && e.this.ogG.ogL) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(13051, Integer.valueOf(e.this.ogG.ogM), Integer.valueOf(2), "", "", "", asVar.content, asVar.type, "", "", Integer.valueOf(e.this.ogG.resourceId));
                        }
                        if (asVar.type.equals("Native")) {
                            ab.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + asVar.content);
                            if ("weixin://festival/gotoshake".equalsIgnoreCase(asVar.content)) {
                                ab.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                            }
                        } else {
                            com.tencent.mm.wallet_core.ui.e.n(context, asVar.content, true);
                        }
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(2);
                        objArr[1] = asVar.content;
                        objArr[2] = e.this.ogG.ogN != null ? e.this.ogG.ogN.wwP : "";
                        hVar.e(16589, objArr);
                        AppMethodBeat.o(42898);
                    }
                });
            }
            viewGroup.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(asVar.nZn));
            if (this.ogG != null) {
                g.gu(this.ogG.ogM, 0);
            }
            AppMethodBeat.o(42899);
        }
    }

    interface d {
        void a(Context context, ViewGroup viewGroup, as asVar);
    }

    public static void a(Context context, ViewGroup viewGroup, as asVar, c cVar) {
        AppMethodBeat.i(42900);
        if (asVar == null) {
            AppMethodBeat.o(42900);
            return;
        }
        a(context, viewGroup, asVar, cVar, asVar.type);
        AppMethodBeat.o(42900);
    }

    public static void a(Context context, ViewGroup viewGroup, as asVar, c cVar, String str) {
        AppMethodBeat.i(42901);
        if (viewGroup == null || asVar == null) {
            AppMethodBeat.o(42901);
        } else if (asVar.erD == 0) {
            ab.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + asVar.erD);
            viewGroup.setVisibility(8);
            AppMethodBeat.o(42901);
        } else if (!asVar.type.equalsIgnoreCase(str)) {
            ab.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + asVar.type + ", " + str);
            viewGroup.setVisibility(8);
            AppMethodBeat.o(42901);
        } else if (str.equalsIgnoreCase("Text") || str.equalsIgnoreCase("Native")) {
            e eVar = new e();
            eVar.ogG = cVar;
            eVar.a(context, viewGroup, asVar);
            AppMethodBeat.o(42901);
        } else if (str.equalsIgnoreCase("Pic")) {
            a aVar = new a();
            aVar.ogG = cVar;
            aVar.a(context, viewGroup, asVar);
            AppMethodBeat.o(42901);
        } else {
            if (str.equalsIgnoreCase("Appid")) {
                b bVar = new b();
                bVar.ogG = cVar;
                bVar.a(context, viewGroup, asVar);
            }
            AppMethodBeat.o(42901);
        }
    }
}
