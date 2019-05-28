package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.l;
import com.tencent.mm.af.o;
import com.tencent.mm.af.p;
import com.tencent.mm.at.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;

public final class t {

    static class d extends b {
        ImageView jOX;
        ImageView jOY;
        TextView jPN;
        ImageView jPO;

        d() {
        }

        public final void fc(View view) {
            AppMethodBeat.i(33073);
            if (this.jOR != null) {
                AppMethodBeat.o(33073);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.a7u);
            if (viewStub == null) {
                AppMethodBeat.o(33073);
                return;
            }
            viewStub.inflate();
            this.jOR = view.findViewById(R.id.a8f);
            this.jOX = (ImageView) this.jOR.findViewById(R.id.wj);
            this.gsf = (TextView) this.jOR.findViewById(R.id.cx);
            this.jPN = (TextView) this.jOR.findViewById(R.id.a8h);
            this.jOY = (ImageView) this.jOR.findViewById(R.id.a83);
            this.jPO = (ImageView) this.jOR.findViewById(R.id.a8i);
            this.jPd = (ImageView) this.jOR.findViewById(R.id.a8j);
            AppMethodBeat.o(33073);
        }
    }

    static class b {
        TextView gsf;
        View jOR;
        ImageView jPd;

        b() {
        }

        public void fc(View view) {
        }
    }

    public static class j extends c {
        private static int jNf;
        private static int jNg = 0;
        private static int jNh = 0;
        private static int jNi = 0;
        private static int jNj;
        private static int pFp;
        private long jPG = 0;
        private boolean jPH = false;
        private com.tencent.mm.ui.chatting.d.a yJI;
        private boolean zeB = false;
        private int zeC = 0;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (i == 285212721) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33086);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.ln);
                c cVar = new c();
                cVar.enf = (TextView) view.findViewById(R.id.ag);
                cVar.zbx = view.findViewById(R.id.ac);
                cVar.jPr = (LinearLayout) view.findViewById(R.id.ank);
                cVar.moo = (CheckBox) view.findViewById(R.id.a_);
                cVar.iVh = view.findViewById(R.id.af);
                cVar.zbU = (TextView) view.findViewById(R.id.anl);
                view.setTag(cVar);
            }
            hW(layoutInflater.getContext());
            AppMethodBeat.o(33086);
            return view;
        }

        private static void hW(Context context) {
            AppMethodBeat.i(33087);
            if (jNi == 0) {
                jNi = context.getResources().getDimensionPixelSize(R.dimen.nc);
                jNh = context.getResources().getDimensionPixelSize(R.dimen.lo);
                jNg = context.getResources().getDimensionPixelSize(R.dimen.l5);
                jNf = context.getResources().getDimensionPixelSize(R.dimen.wv);
                jNj = context.getResources().getDimensionPixelSize(R.dimen.wt);
                int gd = com.tencent.mm.bz.a.gd(context);
                int ge = com.tencent.mm.bz.a.ge(context);
                if (gd >= ge) {
                    gd = ge;
                }
                pFp = (int) (((double) (gd - ((int) (com.tencent.mm.bz.a.getDensity(context) * 32.0f)))) / 2.35d);
            }
            AppMethodBeat.o(33087);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:237:0x0a57  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x028a  */
        /* JADX WARNING: Removed duplicated region for block: B:241:0x0a77  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x02ec  */
        /* JADX WARNING: Removed duplicated region for block: B:252:0x0b22  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0329  */
        /* JADX WARNING: Removed duplicated region for block: B:269:0x038d A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0386  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x028a  */
        /* JADX WARNING: Removed duplicated region for block: B:237:0x0a57  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x02c8  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x02ec  */
        /* JADX WARNING: Removed duplicated region for block: B:241:0x0a77  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x02fb  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0329  */
        /* JADX WARNING: Removed duplicated region for block: B:252:0x0b22  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0386  */
        /* JADX WARNING: Removed duplicated region for block: B:269:0x038d A:{SYNTHETIC} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33088);
            this.yJI = aVar2;
            hW(aVar2.yTx.getContext());
            c cVar = (c) aVar;
            for (a aVar3 : cVar.jPu) {
                if (cVar.jPu.indexOf(aVar3) != cVar.jPu.size() - 1) {
                    ao.aj(aVar3.jOR, 1);
                } else {
                    ao.aj(aVar3.jOR, 2);
                }
                cVar.jPr.removeView(aVar3.jOR);
            }
            cVar.jPu.clear();
            o b = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.biz.a.a.class)).b(biVar.field_msgId, biVar.field_content);
            String str2 = b.dJv;
            if (str2 == null || str2.length() == 0) {
                cVar.zbU.setVisibility(8);
            } else {
                cVar.zbU.setVisibility(0);
                b(aVar2, (View) cVar.zbU, (Object) ay.arL(str2));
            }
            List list = b.fjr;
            int size = list.size();
            if (size == 0) {
                cVar.jPr.setVisibility(8);
                a(cVar, -1, 0);
                AppMethodBeat.o(33088);
                return;
            }
            int i2;
            View Ot;
            int dPe;
            p pVar;
            cVar.jPr.setVisibility(0);
            a(cVar, ((p) list.get(0)).type, size);
            LayoutInflater activityLayoutInflater = aVar2.yTx.getActivityLayoutInflater();
            int size2 = cVar.jPu.size() + 2;
            while (true) {
                i2 = size2;
                if (i2 >= size) {
                    break;
                }
                Ot = ao.Ot(1);
                if (Ot == null) {
                    Ot = activityLayoutInflater.inflate(R.layout.lo, null);
                }
                cVar.fd(Ot);
                size2 = i2 + 1;
            }
            if (size > 1) {
                Ot = ao.Ot(2);
                if (Ot == null) {
                    Ot = activityLayoutInflater.inflate(R.layout.lp, null);
                }
                cVar.fd(Ot);
                this.zeB = true;
            } else {
                this.zeB = false;
            }
            size2 = 0;
            while (true) {
                i2 = size2;
                if (i2 >= cVar.jPu.size()) {
                    break;
                }
                ((a) cVar.jPu.get(i2)).jOR.setVisibility(8);
                size2 = i2 + 1;
            }
            p pVar2 = (p) list.get(0);
            final c cVar2;
            if (pVar2.type == 5) {
                ds(cVar.zew.jPQ);
                ds(cVar.zew.jPe);
                if (ah.isNullOrNil(pVar2.title)) {
                    cVar.zew.jPi.setVisibility(8);
                } else {
                    cVar.zew.jPi.ah(pVar2.title);
                    cVar.zew.jPi.getPaint().setFakeBoldText(true);
                    cVar.zew.jPi.setVisibility(0);
                    cVar.zew.jPi.setTextColor(this.yJI.yTx.getContext().getResources().getColor(R.color.t1));
                }
                if (size == 1) {
                    cVar.zew.jPd.setBackgroundResource(R.drawable.f6);
                    cVar.zew.jPe.setBackgroundResource(R.drawable.iz);
                } else {
                    cVar.zew.jPd.setBackgroundResource(R.drawable.ee);
                    cVar.zew.jPe.setBackgroundResource(R.drawable.j0);
                }
                str2 = l.kr(pVar2.fjB);
                if (TextUtils.isEmpty(str2)) {
                    cVar.zew.timeTv.setVisibility(8);
                } else {
                    cVar.zew.timeTv.setVisibility(0);
                    cVar.zew.timeTv.setText(str2);
                    cVar.zew.timeTv.setTextColor(this.yJI.yTx.getContext().getResources().getColor(R.color.t1));
                }
                a(pVar2, biVar, i, b, cVar.zew.jOR);
                cVar.zew.jPd.setVisibility(8);
                cVar2 = cVar;
                a(pVar2.fjx, cVar.zew.jOX, biVar.getType(), size > 1, pFp, new com.tencent.mm.pluginsdk.ui.applet.e.a() {
                    public final void onFinish() {
                        AppMethodBeat.i(33081);
                        cVar2.zew.jPd.setVisibility(0);
                        cVar2.zew.jPi.setTextColor(j.this.yJI.yTx.getContext().getResources().getColor(R.color.a69));
                        cVar2.zew.timeTv.setTextColor(j.this.yJI.yTx.getContext().getResources().getColor(R.color.a69));
                        AppMethodBeat.o(33081);
                    }
                });
                if (com.tencent.mm.bz.a.dm(this.yJI.yTx.getContext()) > 1.375f) {
                    cVar.zew.jPi.setMaxLines(1);
                } else {
                    cVar.zew.jPi.setMaxLines(2);
                }
            } else if (pVar2.type == 8) {
                ds(cVar.zex.jPQ);
                ds(cVar.zex.jPe);
                if (size == 1) {
                    cVar.zex.jPd.setBackgroundResource(R.drawable.ew);
                    cVar.zex.jPe.setBackgroundResource(R.drawable.iz);
                    cVar.zex.pFw.setBackgroundResource(R.drawable.axc);
                } else {
                    cVar.zex.jPd.setBackgroundResource(R.drawable.ef);
                    cVar.zex.jPe.setBackgroundResource(R.drawable.j0);
                    cVar.zex.pFw.setBackgroundResource(R.drawable.ex);
                }
                cVar.zex.jPd.setVisibility(8);
                cVar.zex.pFw.setVisibility(8);
                cVar.zex.iNr.setBackgroundResource(R.raw.chatting_item_biz_pic_loading_icon);
                cVar2 = cVar;
                a(pVar2.fjx, cVar.zex.jOX, biVar.getType(), size > 1, pFp, new com.tencent.mm.pluginsdk.ui.applet.e.a() {
                    public final void onFinish() {
                        AppMethodBeat.i(33083);
                        cVar2.zex.jPd.setVisibility(0);
                        cVar2.zex.pFw.setVisibility(0);
                        cVar2.zex.iNr.setBackgroundResource(R.raw.chatting_item_biz_pic_icon);
                        AppMethodBeat.o(33083);
                    }
                });
                a(pVar2, biVar, i, b, cVar.zex.jOR);
            } else if (pVar2.type == 7) {
                if (ah.isNullOrNil(pVar2.title)) {
                    cVar.zey.gsf.setVisibility(8);
                } else {
                    cVar.zey.gsf.setVisibility(0);
                    cVar.zey.gsf.setText(pVar2.title);
                }
                if (size > 1) {
                    cVar.zey.jOR.setBackgroundResource(R.drawable.ip);
                } else {
                    cVar.zey.jOR.setBackgroundResource(R.drawable.iq);
                }
                str2 = l.kr(pVar2.fjB);
                if (TextUtils.isEmpty(str2)) {
                    cVar.zey.ngD.setVisibility(4);
                } else {
                    cVar.zey.ngD.setVisibility(0);
                    cVar.zey.ngD.setText(str2);
                }
                Drawable drawable = cVar.zey.jOY.getDrawable();
                if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                    ((AnimationDrawable) drawable).stop();
                }
                if ((biVar.field_msgId + "_0").equals(cVar.zbz)) {
                    cVar.zey.jOY.setImageResource(R.drawable.ig);
                    if (cVar.zey.jOY.getDrawable() instanceof AnimationDrawable) {
                        ((AnimationDrawable) cVar.zey.jOY.getDrawable()).start();
                    }
                } else {
                    cVar.zey.jOY.setImageResource(R.drawable.f8if);
                }
                a(cVar.zey.jOY, biVar, 0);
                a(pVar2, biVar, i, b, cVar.zey.jOR);
            } else if (pVar2.type == 6) {
                p pVar3 = (p) list.get(0);
                if (ah.isNullOrNil(pVar3.title)) {
                    cVar.zez.gsf.setVisibility(8);
                } else {
                    cVar.zez.gsf.setVisibility(0);
                    cVar.zez.gsf.setText(pVar3.title);
                }
                if (size > 1) {
                    cVar.zez.jOR.setBackgroundResource(R.drawable.ip);
                } else {
                    cVar.zez.jOR.setBackgroundResource(R.drawable.iq);
                }
                if (TextUtils.isEmpty(pVar3.fjL)) {
                    cVar.zez.jPN.setVisibility(8);
                } else {
                    cVar.zez.jPN.setVisibility(0);
                    cVar.zez.jPN.setText(pVar3.fjL);
                }
                if (pVar3.fjM == 2) {
                    cVar.zez.jPO.setImageResource(R.raw.chatting_item_biz_kugou_music_watermark);
                } else {
                    cVar.zez.jPO.setImageResource(R.raw.chatting_item_biz_qq_music_watermark);
                }
                a(cVar.zez.jOY, biVar, 0);
                a(pVar3, biVar, i, b, cVar.zez.jOR);
                if ((biVar.field_msgId + "_0").equals(cVar.zbz)) {
                    cVar.zez.jOY.setImageResource(R.raw.chatting_item_biz_music_pause_loading_icon);
                } else {
                    cVar.zez.jOY.setImageResource(R.raw.chatting_item_biz_music_play_loading_icon);
                }
                cVar.zez.jPd.setVisibility(8);
                String str3 = pVar3.fjx;
                ImageView imageView = cVar.zez.jOX;
                int type = biVar.getType();
                int i3 = jNf;
                cVar2 = cVar;
                final bi biVar2 = biVar;
                a(str3, imageView, type, i3, i3, "@S", new com.tencent.mm.pluginsdk.ui.applet.e.a() {
                    public final void onFinish() {
                        AppMethodBeat.i(33082);
                        cVar2.zez.jPd.setVisibility(0);
                        if ((biVar2.field_msgId + "_0").equals(cVar2.zbz)) {
                            cVar2.zez.jOY.setImageResource(R.drawable.ic);
                            AppMethodBeat.o(33082);
                            return;
                        }
                        cVar2.zez.jOY.setImageResource(R.drawable.id);
                        AppMethodBeat.o(33082);
                    }
                });
            } else if (pVar2.type == 10) {
                if (ah.isNullOrNil(pVar2.title)) {
                    cVar.zeA.jPi.setVisibility(8);
                } else {
                    cVar.zeA.jPi.setVisibility(0);
                    cVar.zeA.jPi.ah(com.tencent.mm.pluginsdk.ui.e.j.a(this.yJI.yTx.getContext(), pVar2.title, (int) cVar.zeA.jPi.getTextSize()));
                    com.tencent.neattextview.textview.layout.a QV = cVar.zeA.jPi.QV(com.tencent.mm.bz.a.gd(this.yJI.yTx.getContext()) - ((int) (com.tencent.mm.bz.a.getDensity(this.yJI.yTx.getContext()) * 80.0f)));
                    if (QV != null) {
                        dPe = QV.dPe();
                    } else {
                        dPe = 0;
                    }
                    LayoutParams layoutParams = (LayoutParams) cVar.zeA.jPi.getLayoutParams();
                    if (dPe == 1) {
                        layoutParams.gravity = 17;
                    } else {
                        layoutParams.gravity = 19;
                    }
                    cVar.zeA.jPi.setLayoutParams(layoutParams);
                }
                if (size > 1) {
                    cVar.zeA.jOR.setBackgroundResource(R.drawable.ip);
                    cVar.zeA.jPU.setVisibility(8);
                } else {
                    cVar.zeA.jOR.setBackgroundResource(R.drawable.iq);
                    cVar.zeA.jPU.setVisibility(0);
                }
                a(pVar2, biVar, i, b, cVar.zeA.jOR);
            } else {
                cVar.zev.gsf.setVisibility(size > 1 ? 8 : 0);
                TextView textView = cVar.zev.pFH;
                size2 = (size > 1 || ah.isNullOrNil(pVar2.fjz)) ? 8 : 0;
                textView.setVisibility(size2);
                cVar.zev.pFv.setVisibility(size > 1 ? 0 : 8);
                cVar.zev.pFw.setVisibility(8);
                if (size == 1) {
                    cVar.zev.jPe.setBackgroundResource(R.drawable.iz);
                    cVar.zev.gCY.setVisibility(0);
                } else {
                    cVar.zev.gCY.setVisibility(ah.isNullOrNil(pVar2.fjx) ? 0 : 8);
                    cVar.zev.jPe.setBackgroundResource(R.drawable.j0);
                    cVar.zev.pFv.setTextColor(this.yJI.yTx.getContext().getResources().getColor(R.color.t1));
                    cVar.zev.pFv.setBackgroundResource(R.drawable.uv);
                    cVar.zev.pFv.getPaint().setFakeBoldText(true);
                }
                ds(cVar.zev.jPQ);
                ds(cVar.zev.jPe);
                int i4;
                if (ah.isNullOrNil(pVar2.fjx)) {
                    cVar.zev.jPQ.setVisibility(8);
                    cVar.zev.gsf.setVisibility(0);
                    cVar.zev.pFH.setVisibility(ah.isNullOrNil(pVar2.fjz) ? 8 : 0);
                    if (size == 1) {
                        cVar.zev.gCY.setBackgroundResource(R.drawable.iq);
                    } else {
                        cVar.zev.gCY.setBackgroundResource(R.drawable.ip);
                    }
                    Ot = cVar.zev.gCY;
                    dPe = jNg;
                    i4 = jNg;
                    Ot.setPadding(dPe, dPe, i4, i4);
                    cVar.zev.jPe.setVisibility(8);
                } else {
                    cVar.zev.jPQ.setVisibility(0);
                    final int i5 = size;
                    final c cVar3 = cVar;
                    a(pVar2.fjx, cVar.zev.jOX, biVar.getType(), true, pFp, new com.tencent.mm.pluginsdk.ui.applet.e.a() {
                        public final void onFinish() {
                            AppMethodBeat.i(33080);
                            if (i5 > 1) {
                                cVar3.zev.pFv.setTextColor(j.this.yJI.yTx.getContext().getResources().getColor(R.color.a69));
                                cVar3.zev.pFv.setBackgroundResource(R.drawable.eh);
                            }
                            cVar3.zev.pFw.setVisibility(0);
                            AppMethodBeat.o(33080);
                        }
                    });
                    cVar.zev.gCY.setBackgroundResource(R.drawable.b18);
                    Ot = cVar.zev.gCY;
                    dPe = jNg;
                    i4 = jNh;
                    int i6 = jNg;
                    Ot.setPadding(dPe, i4, i6, i6);
                    cVar.zev.jPe.setVisibility(0);
                }
                cVar.zev.pFH.setText(pVar2.fjz);
                cVar.zev.gsf.setText(pVar2.title);
                cVar.zev.pFv.ah(pVar2.title);
                if (!(pVar2.fjA == 0 || pVar2.fjA == 1)) {
                    cVar.zev.pFv.setVisibility(4);
                }
                a(pVar2, biVar, i, b, cVar.zev.jOR);
            }
            size2 = 1;
            while (true) {
                int i7 = size2;
                if (i7 >= size) {
                    break;
                }
                String ari;
                ay ayVar;
                p pVar4 = (p) list.get(i7);
                a aVar4 = (a) cVar.jPu.get(i7 - 1);
                size2 = pVar2.type;
                if (i7 != 1 || (size2 != 5 && size2 != 8 && size2 != 0)) {
                    aVar4.jOS.setVisibility(0);
                    if (i7 > 1) {
                        pVar = (p) list.get(i7 - 1);
                        p pVar5 = (p) list.get(i7);
                        if ((pVar.type == 7 || pVar.type == 5 || pVar.type == 6 || !ah.isNullOrNil(pVar.fjx)) && (pVar5.type == 7 || pVar5.type == 5 || pVar5.type == 6 || !ah.isNullOrNil(pVar5.fjx))) {
                            O(aVar4.jOS, jNj);
                        } else {
                            O(aVar4.jOS, jNg);
                        }
                        if (i7 == 1) {
                            if (i7 == size - 1) {
                                aVar4.jOT.setPadding(0, jNg, 0, jNg);
                            } else {
                                aVar4.jOT.setPadding(0, jNg, 0, jNi);
                            }
                        } else if (i7 == size - 1) {
                            aVar4.jOT.setPadding(0, jNi, 0, jNg);
                        } else {
                            aVar4.jOT.setPadding(0, jNi, 0, jNi);
                        }
                        a(cVar, aVar4, pVar4, biVar, i7, false);
                        aVar4.gsf.setText(pVar4.title);
                        aVar4.gsf.setTextColor(aVar2.yTx.getMMResources().getColor(R.color.h4));
                        if (pVar4.fjA != 0 || pVar4.fjA == 1) {
                            aVar4.jOW.setVisibility(0);
                            aVar4.gsf.setTextColor(aVar2.yTx.getMMResources().getColor(R.color.h4));
                            if (pVar4.type == 7) {
                                aVar4.jOX.setVisibility(8);
                            } else if (!ah.isNullOrNil(pVar4.fjx)) {
                                aVar4.jOX.setVisibility(0);
                                str2 = pVar4.fjx;
                                ImageView imageView2 = aVar4.jOX;
                                int type2 = biVar.getType();
                                int i8 = jNf;
                                final c cVar4 = cVar;
                                final a aVar5 = aVar4;
                                final p pVar6 = pVar4;
                                final bi biVar3 = biVar;
                                final int i9 = i7;
                                a(str2, imageView2, type2, i8, i8, "@S", new com.tencent.mm.pluginsdk.ui.applet.e.a() {
                                    public final void onFinish() {
                                        AppMethodBeat.i(33079);
                                        j.a(j.this, cVar4, aVar5, pVar6, biVar3, i9);
                                        AppMethodBeat.o(33079);
                                    }
                                });
                            } else if (pVar4.type == 5 || pVar4.type == 6) {
                                aVar4.jOX.setVisibility(0);
                                ImageView imageView3 = aVar4.jOX;
                                size2 = jNf;
                                com.tencent.mm.at.a.a ahp = com.tencent.mm.at.o.ahp();
                                com.tencent.mm.at.a.a.c.a aVar6 = new com.tencent.mm.at.a.a.c.a();
                                aVar6.ePF = true;
                                aVar6.ePT = R.color.k8;
                                com.tencent.mm.at.a.a.c.a ct = aVar6.ct(size2, size2);
                                ct.fHe = 4;
                                ahp.a("2130841060", imageView3, ct.ahG(), null, new com.tencent.mm.pluginsdk.ui.applet.e());
                            } else {
                                aVar4.jOW.setVisibility(8);
                            }
                        } else {
                            aVar4.jOW.setVisibility(8);
                            aVar4.gsf.setTextColor(aVar2.yTx.getMMResources().getColor(R.color.s0));
                        }
                        if (ah.isNullOrNil(pVar4.fjz) && pVar4.type == 3) {
                            aVar4.jOV.setText(pVar4.fjz);
                            aVar4.jOV.setVisibility(0);
                        } else {
                            aVar4.jOV.setVisibility(8);
                        }
                        aVar4.jOR.setVisibility(0);
                        ari = ((com.tencent.mm.ui.chatting.c.b.d) aVar2.aF(com.tencent.mm.ui.chatting.c.b.d.class)).ari(pVar4.url);
                        if (TextUtils.isEmpty(ari)) {
                            ayVar = new ay(biVar, false, i, pVar4.url, this.zeB, aVar2.dDw(), b.cMg, b.cMh);
                            a(ayVar, pVar4, biVar);
                            aVar4.jOR.setOnClickListener(h(aVar2));
                        } else {
                            ab.d("MicroMsg.ChattingItemBizFrom", "productId:%s", ari);
                            ayVar = new ay(biVar, false, i, pVar4.url, this.zeB, aVar2.dDw(), b.cMg, b.cMh, pVar4.title, ari, null, false, true);
                            aVar4.jOR.setOnClickListener(i(aVar2));
                        }
                        ayVar.unn = biVar.field_msgSvrId;
                        ayVar.uno = i7;
                        ayVar.ziA = pVar4.type;
                        aVar4.jOR.setTag(ayVar);
                        if (l.mg(pVar4.fjC)) {
                            a(pVar4, aVar4.jOR);
                        }
                        a(pVar4, aVar4.jOR, biVar.field_msgId, biVar.field_msgSvrId, i7);
                        aVar4.jOR.setOnLongClickListener(c(aVar2));
                        aVar4.jOR.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCZ());
                        size2 = i7 + 1;
                    }
                } else if (size2 == 0 && ah.isNullOrNil(((p) list.get(0)).fjx)) {
                    aVar4.jOS.setVisibility(0);
                } else {
                    aVar4.jOS.setVisibility(8);
                    if (i7 == 1) {
                    }
                    a(cVar, aVar4, pVar4, biVar, i7, false);
                    aVar4.gsf.setText(pVar4.title);
                    aVar4.gsf.setTextColor(aVar2.yTx.getMMResources().getColor(R.color.h4));
                    if (pVar4.fjA != 0) {
                    }
                    aVar4.jOW.setVisibility(0);
                    aVar4.gsf.setTextColor(aVar2.yTx.getMMResources().getColor(R.color.h4));
                    if (pVar4.type == 7) {
                    }
                    if (ah.isNullOrNil(pVar4.fjz)) {
                    }
                    aVar4.jOV.setVisibility(8);
                    aVar4.jOR.setVisibility(0);
                    ari = ((com.tencent.mm.ui.chatting.c.b.d) aVar2.aF(com.tencent.mm.ui.chatting.c.b.d.class)).ari(pVar4.url);
                    if (TextUtils.isEmpty(ari)) {
                    }
                    ayVar.unn = biVar.field_msgSvrId;
                    ayVar.uno = i7;
                    ayVar.ziA = pVar4.type;
                    aVar4.jOR.setTag(ayVar);
                    if (l.mg(pVar4.fjC)) {
                    }
                    a(pVar4, aVar4.jOR, biVar.field_msgId, biVar.field_msgSvrId, i7);
                    aVar4.jOR.setOnLongClickListener(c(aVar2));
                    aVar4.jOR.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCZ());
                    size2 = i7 + 1;
                }
                O(aVar4.jOS, jNg);
                if (i7 == 1) {
                }
                a(cVar, aVar4, pVar4, biVar, i7, false);
                aVar4.gsf.setText(pVar4.title);
                aVar4.gsf.setTextColor(aVar2.yTx.getMMResources().getColor(R.color.h4));
                if (pVar4.fjA != 0) {
                }
                aVar4.jOW.setVisibility(0);
                aVar4.gsf.setTextColor(aVar2.yTx.getMMResources().getColor(R.color.h4));
                if (pVar4.type == 7) {
                }
                if (ah.isNullOrNil(pVar4.fjz)) {
                }
                aVar4.jOV.setVisibility(8);
                aVar4.jOR.setVisibility(0);
                ari = ((com.tencent.mm.ui.chatting.c.b.d) aVar2.aF(com.tencent.mm.ui.chatting.c.b.d.class)).ari(pVar4.url);
                if (TextUtils.isEmpty(ari)) {
                }
                ayVar.unn = biVar.field_msgSvrId;
                ayVar.uno = i7;
                ayVar.ziA = pVar4.type;
                aVar4.jOR.setTag(ayVar);
                if (l.mg(pVar4.fjC)) {
                }
                a(pVar4, aVar4.jOR, biVar.field_msgId, biVar.field_msgSvrId, i7);
                aVar4.jOR.setOnLongClickListener(c(aVar2));
                aVar4.jOR.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCZ());
                size2 = i7 + 1;
            }
            if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(2)) {
                size2 = 0;
                while (true) {
                    dPe = size2;
                    if (dPe >= list.size()) {
                        break;
                    }
                    pVar = (p) list.get(0);
                    ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).a(pVar.url, pVar.type, 0, new Object[0]);
                    size2 = dPe + 1;
                }
            }
            AppMethodBeat.o(33088);
        }

        private void a(p pVar, bi biVar, int i, o oVar, View view) {
            ay ayVar;
            AppMethodBeat.i(33089);
            String ari = ((com.tencent.mm.ui.chatting.c.b.d) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.d.class)).ari(pVar.url);
            if (TextUtils.isEmpty(ari)) {
                ayVar = new ay(biVar, false, i, pVar.url, false, this.yJI.dDw(), oVar.cMg, oVar.cMh, pVar.title);
                a(ayVar, pVar, biVar);
                view.setOnClickListener(h(this.yJI));
            } else {
                ab.d("MicroMsg.ChattingItemBizFrom", "productId:%s", ari);
                ayVar = new ay(biVar, false, i, pVar.url, false, this.yJI.dDw(), oVar.cMg, oVar.cMh, pVar.title, ari, null, false, false);
                view.setOnClickListener(i(this.yJI));
            }
            ayVar.unn = biVar.field_msgSvrId;
            ayVar.uno = 0;
            ayVar.ziA = pVar.type;
            view.setTag(ayVar);
            if (l.mg(pVar.fjC)) {
                a(pVar, view);
            }
            a(pVar, view, biVar.field_msgId, biVar.field_msgSvrId, 0);
            view.setOnLongClickListener(c(this.yJI));
            view.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCZ());
            AppMethodBeat.o(33089);
        }

        private static void ds(View view) {
            AppMethodBeat.i(33090);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = pFp;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.o(33090);
        }

        private static void M(View view, int i) {
            AppMethodBeat.i(33091);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.o(33091);
        }

        private static void O(View view, int i) {
            AppMethodBeat.i(33092);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.rightMargin = i;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.o(33092);
        }

        private void a(c cVar, final a aVar, p pVar, bi biVar, int i, boolean z) {
            AppMethodBeat.i(33093);
            if (pVar.type == 5) {
                aVar.jOY.setVisibility(0);
                aVar.jOY.setImageResource(R.drawable.axj);
                aVar.jOY.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(33084);
                        aVar.jOR.performClick();
                        AppMethodBeat.o(33084);
                    }
                });
            } else if (pVar.type == 6) {
                aVar.jOY.setVisibility(0);
                if (z) {
                    if ((biVar.field_msgId + "_" + i).equals(cVar.zbz)) {
                        aVar.jOY.setImageResource(R.drawable.ic);
                    } else {
                        aVar.jOY.setImageResource(R.drawable.id);
                    }
                } else if ((biVar.field_msgId + "_" + i).equals(cVar.zbz)) {
                    aVar.jOY.setImageResource(R.raw.chatting_item_biz_music_pause_loading_icon);
                } else {
                    aVar.jOY.setImageResource(R.raw.chatting_item_biz_music_play_loading_icon);
                }
                a(aVar.jOY, biVar, i);
            } else if (pVar.type == 7) {
                aVar.jOY.setVisibility(0);
                Drawable drawable = aVar.jOY.getDrawable();
                if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                    ((AnimationDrawable) drawable).stop();
                }
                if ((biVar.field_msgId + "_" + i).equals(cVar.zbz)) {
                    aVar.jOY.setImageResource(R.drawable.ig);
                    if (aVar.jOY.getDrawable() instanceof AnimationDrawable) {
                        ((AnimationDrawable) aVar.jOY.getDrawable()).start();
                    }
                } else {
                    aVar.jOY.setImageResource(R.drawable.f8if);
                }
                a(aVar.jOY, biVar, i);
            } else {
                aVar.jOY.setVisibility(8);
            }
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this.yJI.yTx.getContext(), 26);
            if (pVar.type == 7) {
                fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this.yJI.yTx.getContext(), 32);
            }
            M(aVar.jOY, fromDPToPix);
            AppMethodBeat.o(33093);
        }

        private void a(ImageView imageView, bi biVar, int i) {
            AppMethodBeat.i(33094);
            com.tencent.mm.ui.chatting.viewitems.d.f fVar = new com.tencent.mm.ui.chatting.viewitems.d.f();
            fVar.cvx = biVar.field_msgId;
            fVar.zcZ = i;
            fVar.cHz = biVar.field_content;
            imageView.setTag(fVar);
            imageView.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.h) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dDa());
            AppMethodBeat.o(33094);
        }

        private static void a(View view, b bVar, boolean z) {
            AppMethodBeat.i(33095);
            if (z) {
                if (bVar.jOR == null) {
                    bVar.fc(view);
                }
                if (bVar.jOR != null) {
                    bVar.jOR.setVisibility(0);
                    AppMethodBeat.o(33095);
                    return;
                }
            } else if (bVar.jOR != null) {
                bVar.jOR.setVisibility(8);
            }
            AppMethodBeat.o(33095);
        }

        private static void a(c cVar, int i, int i2) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(33096);
            boolean z3 = i == 5;
            a(cVar.jPr, cVar.zew, z3);
            if (z3) {
                z = true;
            } else {
                z = false;
            }
            if (i == 8) {
                z3 = true;
            } else {
                z3 = false;
            }
            a(cVar.jPr, cVar.zex, z3);
            if (z3) {
                z = true;
            }
            if (i == 7) {
                z3 = true;
            } else {
                z3 = false;
            }
            a(cVar.jPr, cVar.zey, z3);
            if (z3) {
                z = true;
            }
            if (i == 6) {
                z3 = true;
            } else {
                z3 = false;
            }
            a(cVar.jPr, cVar.zez, z3);
            if (z3) {
                z = true;
            }
            if (i == 10) {
                z3 = true;
            } else {
                z3 = false;
            }
            a(cVar.jPr, cVar.zeA, z3);
            if (z3) {
                z3 = true;
            } else {
                z3 = z;
            }
            View view = cVar.jPr;
            b bVar = cVar.zev;
            if (z3 || i2 <= 0) {
                z2 = false;
            }
            a(view, bVar, z2);
            AppMethodBeat.o(33096);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33097);
            ay ayVar = (ay) view.getTag();
            if (ayVar == null) {
                AppMethodBeat.o(33097);
                return false;
            }
            this.zeC = ayVar.uno;
            int i = ayVar.position;
            o b = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.biz.a.a.class)).b(biVar.field_msgId, biVar.field_content);
            if (b == null) {
                ab.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
                AppMethodBeat.o(33097);
                return false;
            }
            this.jPH = false;
            if (this.zeC >= 0 && this.zeC < b.fjr.size() && l.mg(((p) b.fjr.get(this.zeC)).fjC)) {
                this.jPH = true;
            }
            if (!(this.yJI.dFy() || com.tencent.mm.ui.chatting.j.aE(biVar))) {
                contextMenu.add(i, 111, 0, view.getContext().getString(R.string.dr1));
            }
            if (com.tencent.mm.bp.d.afj("favorite") && !this.jPH) {
                contextMenu.add(i, 126, 0, view.getContext().getString(R.string.dcq));
            }
            AppMethodBeat.o(33097);
            return true;
        }

        private void a(ay ayVar, p pVar, bi biVar) {
            int i;
            AppMethodBeat.i(33098);
            Bundle bundle = new Bundle();
            switch (u.ad(b(this.yJI, biVar), this.yJI.getTalkerUserName())) {
                case 1:
                    i = 3;
                    break;
                case 2:
                    i = 2;
                    break;
                case 6:
                case 7:
                    i = 5;
                    break;
                default:
                    i = 0;
                    break;
            }
            bundle.putString("share_report_pre_msg_url", pVar.url);
            bundle.putString("share_report_pre_msg_title", pVar.title);
            bundle.putString("share_report_pre_msg_desc", pVar.fjz);
            bundle.putString("share_report_pre_msg_icon_url", l.a(pVar));
            bundle.putString("share_report_pre_msg_appid", "");
            bundle.putInt("share_report_from_scene", i);
            if (i == 5) {
                bundle.putString("share_report_biz_username", this.yJI.getTalkerUserName());
            }
            ayVar.ziy = bundle;
            AppMethodBeat.o(33098);
        }

        private static void a(String str, ImageView imageView, int i, int i2, int i3, String str2, com.tencent.mm.pluginsdk.ui.applet.e.a aVar) {
            String sy;
            AppMethodBeat.i(33099);
            if (q.ahs()) {
                sy = q.sy(str);
            } else {
                sy = str;
            }
            com.tencent.mm.at.a.a ahp = com.tencent.mm.at.o.ahp();
            com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
            aVar2.ePV = R.color.k8;
            aVar2.ePH = true;
            aVar2 = aVar2.ct(i2, i3);
            aVar2.fGV = new com.tencent.mm.pluginsdk.ui.applet.f();
            aVar2.ePJ = com.tencent.mm.pluginsdk.model.q.v(sy, i, str2);
            ahp.a(sy, imageView, aVar2.ahG(), null, new com.tencent.mm.pluginsdk.ui.applet.e(0, 0, 0, aVar));
            AppMethodBeat.o(33099);
        }

        private void a(String str, ImageView imageView, int i, boolean z, int i2, com.tencent.mm.pluginsdk.ui.applet.e.a aVar) {
            String sy;
            AppMethodBeat.i(33100);
            if (q.ahs()) {
                sy = q.sy(str);
            } else {
                sy = str;
            }
            int i3 = z ? R.drawable.axd : R.drawable.axb;
            int i4 = z ? R.drawable.ed : R.drawable.eb;
            int gd = com.tencent.mm.bz.a.gd(imageView.getContext()) - ((int) (((float) (((com.tencent.mm.ui.chatting.c.b.h) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.h.class)).isInEditMode() ? 72 : 32)) * com.tencent.mm.bz.a.getDensity(imageView.getContext())));
            com.tencent.mm.at.a.a ahp = com.tencent.mm.at.o.ahp();
            com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
            aVar2.ePV = i4;
            aVar2.ePH = true;
            aVar2.ePX = String.valueOf(i3);
            com.tencent.mm.at.a.a.c.a ct = aVar2.ct(gd, i2);
            ct.fGV = new com.tencent.mm.pluginsdk.ui.applet.f();
            ct.ePJ = com.tencent.mm.pluginsdk.model.q.v(sy, i, "@T");
            ahp.a(sy, imageView, ct.ahG(), null, new com.tencent.mm.pluginsdk.ui.applet.e(i3, gd, i2, aVar));
            AppMethodBeat.o(33100);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33101);
            this.jPG = ah.anT();
            String a;
            switch (menuItem.getItemId()) {
                case 111:
                    if (this.jPH) {
                        if (this.jPH) {
                            r.a(this.zeC, aVar.yTx.getContext(), biVar.field_content, biVar.field_talker, biVar.field_msgId, biVar.field_msgSvrId);
                        } else {
                            ab.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
                        }
                        AppMethodBeat.o(33101);
                        break;
                    }
                    a = a(biVar, aVar.yTx.getContext(), this.zeC);
                    if (!ah.isNullOrNil(a)) {
                        Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                        intent.putExtra("Retr_Msg_content", a);
                        intent.putExtra("Retr_Msg_Type", 2);
                        intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.zeC);
                        intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                        intent.putExtra("Retr_MsgFromScene", 1);
                        a = biVar.field_talker;
                        String nW = v.nW(biVar.field_msgSvrId);
                        intent.putExtra("reportSessionId", nW);
                        com.tencent.mm.model.v.b y = v.Zp().y(nW, true);
                        y.j("prePublishId", "msg_" + biVar.field_msgSvrId);
                        y.j("preUsername", a);
                        y.j("preChatName", a);
                        y.j("preMsgIndex", Integer.valueOf(this.zeC));
                        y.j("sendAppMsgScene", Integer.valueOf(1));
                        aVar.startActivity(intent);
                    }
                case 114:
                    a = a(biVar, aVar.yTx.getContext(), 0);
                    if (!ah.isNullOrNil(a)) {
                        am.c(biVar, a, aVar.yTx.getContext());
                    }
                    AppMethodBeat.o(33101);
                    break;
                case 126:
                    r.a(this.jPG, this.zeC, aVar.yTx.getContext(), aVar.yTx, null, biVar);
                    AppMethodBeat.o(33101);
                    break;
            }
            AppMethodBeat.o(33101);
            return false;
        }

        private static String a(bi biVar, Context context, int i) {
            AppMethodBeat.i(33102);
            if (context == null) {
                ab.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
                AppMethodBeat.o(33102);
                return null;
            } else if (biVar == null) {
                ab.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
                AppMethodBeat.o(33102);
                return null;
            } else {
                String a = l.a(context, i, biVar.field_content, biVar.field_talker, biVar.field_msgId);
                AppMethodBeat.o(33102);
                return a;
            }
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        private void a(p pVar, View view) {
            AppMethodBeat.i(33103);
            r.a(pVar, view, this.yJI.getTalkerUserName());
            AppMethodBeat.o(33103);
        }

        private void a(p pVar, View view, long j, long j2, int i) {
            AppMethodBeat.i(33104);
            if (pVar.type == 5 && ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aVP()) {
                final int i2 = i;
                final long j3 = j;
                final long j4 = j2;
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(33085);
                        int intExtra = j.this.yJI.yTx.getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK);
                        View findViewById = view.findViewById(R.id.wj);
                        Bundle bundle = new Bundle();
                        bundle.putInt("biz_video_scene", 0);
                        bundle.putInt("biz_video_subscene", intExtra);
                        bundle.putInt("geta8key_scene", 7);
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.a(j.this.yJI.yTx.getContext(), j3, j4, i2, findViewById, bundle);
                        AppMethodBeat.o(33085);
                    }
                });
            }
            AppMethodBeat.o(33104);
        }
    }

    static class a {
        TextView gsf;
        View jOR;
        View jOS;
        View jOT;
        TextView jOV;
        View jOW;
        ImageView jOX;
        ImageView jOY;

        a() {
        }
    }

    static class c extends com.tencent.mm.ui.chatting.viewitems.c.a {
        LinearLayout jPr;
        List<a> jPu = new ArrayList();
        TextView zbU;
        g zeA = new g();
        f zev = new f();
        h zew = new h();
        e zex = new e();
        i zey = new i();
        d zez = new d();

        c() {
            AppMethodBeat.i(33071);
            AppMethodBeat.o(33071);
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a fd(View view) {
            AppMethodBeat.i(33072);
            LinearLayout linearLayout = this.jPr;
            a aVar = new a();
            aVar.jOR = view;
            aVar.jOS = view.findViewById(R.id.a7y);
            aVar.jOT = view.findViewById(R.id.a7z);
            aVar.gsf = (TextView) view.findViewById(R.id.cx);
            aVar.jOV = (TextView) view.findViewById(R.id.a81);
            aVar.jOW = view.findViewById(R.id.wi);
            aVar.jOX = (ImageView) view.findViewById(R.id.wj);
            aVar.jOY = (ImageView) view.findViewById(R.id.a83);
            linearLayout.addView(view, linearLayout.getChildCount());
            this.jPu.add(aVar);
            AppMethodBeat.o(33072);
            return this;
        }
    }

    static class i extends b {
        ImageView jOY;
        TextView ngD;

        i() {
        }

        public final void fc(View view) {
            AppMethodBeat.i(33078);
            if (this.jOR != null) {
                AppMethodBeat.o(33078);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.a7t);
            if (viewStub == null) {
                AppMethodBeat.o(33078);
                return;
            }
            viewStub.inflate();
            this.jOR = view.findViewById(R.id.a8x);
            this.gsf = (TextView) this.jOR.findViewById(R.id.cx);
            this.ngD = (TextView) this.jOR.findViewById(R.id.la);
            this.jOY = (ImageView) this.jOR.findViewById(R.id.a83);
            AppMethodBeat.o(33078);
        }
    }

    static class e extends b {
        ImageView iNr;
        ImageView jOX;
        View jPQ;
        ImageView jPe;
        ImageView pFw;

        e() {
        }

        public final void fc(View view) {
            AppMethodBeat.i(33074);
            if (this.jOR != null) {
                AppMethodBeat.o(33074);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.a7s);
            if (viewStub == null) {
                AppMethodBeat.o(33074);
                return;
            }
            viewStub.inflate();
            this.jOR = view.findViewById(R.id.a8k);
            this.jOX = (ImageView) this.jOR.findViewById(R.id.wj);
            this.jPd = (ImageView) this.jOR.findViewById(R.id.a8j);
            this.jPe = (ImageView) this.jOR.findViewById(R.id.a8e);
            this.pFw = (ImageView) this.jOR.findViewById(R.id.ann);
            this.iNr = (ImageView) this.jOR.findViewById(R.id.a8n);
            this.jPQ = this.jOR.findViewById(R.id.a8m);
            AppMethodBeat.o(33074);
        }
    }

    static class f extends b {
        View gCY;
        ImageView jOX;
        View jPQ;
        ImageView jPe;
        TextView pFH;
        MMNeat7extView pFv;
        ImageView pFw;

        f() {
        }

        public final void fc(View view) {
            AppMethodBeat.i(33075);
            if (this.jOR != null) {
                AppMethodBeat.o(33075);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.a7q);
            if (viewStub == null) {
                AppMethodBeat.o(33075);
                return;
            }
            viewStub.inflate();
            this.jOR = view.findViewById(R.id.a8b);
            this.gsf = (TextView) this.jOR.findViewById(R.id.cx);
            this.jOX = (ImageView) this.jOR.findViewById(R.id.wj);
            this.jPQ = this.jOR.findViewById(R.id.anm);
            this.gCY = this.jOR.findViewById(R.id.anp);
            this.pFv = (MMNeat7extView) this.jOR.findViewById(R.id.ano);
            this.pFH = (TextView) this.jOR.findViewById(R.id.anq);
            this.jPe = (ImageView) this.jOR.findViewById(R.id.a8e);
            this.pFw = (ImageView) this.jOR.findViewById(R.id.ann);
            AppMethodBeat.o(33075);
        }
    }

    static class g extends b {
        View jPU;
        MMNeat7extView jPi;

        g() {
        }

        public final void fc(View view) {
            AppMethodBeat.i(33076);
            if (this.jOR != null) {
                AppMethodBeat.o(33076);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.a7v);
            if (viewStub == null) {
                AppMethodBeat.o(33076);
                return;
            }
            viewStub.inflate();
            this.jOR = view.findViewById(R.id.a8o);
            this.jPU = view.findViewById(R.id.dd);
            this.jPi = (MMNeat7extView) this.jOR.findViewById(R.id.cx);
            AppMethodBeat.o(33076);
        }
    }

    static class h extends b {
        ImageView iNr;
        ImageView jOX;
        View jPQ;
        ImageView jPe;
        MMNeat7extView jPi;
        TextView timeTv;

        h() {
        }

        public final void fc(View view) {
            AppMethodBeat.i(33077);
            if (this.jOR != null) {
                AppMethodBeat.o(33077);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.a7r);
            if (viewStub == null) {
                AppMethodBeat.o(33077);
                return;
            }
            viewStub.inflate();
            this.jOR = view.findViewById(R.id.a8r);
            this.jOX = (ImageView) this.jOR.findViewById(R.id.wj);
            this.jPd = (ImageView) this.jOR.findViewById(R.id.a8j);
            this.jPe = (ImageView) this.jOR.findViewById(R.id.a8e);
            this.iNr = (ImageView) this.jOR.findViewById(R.id.a8v);
            this.jPi = (MMNeat7extView) this.jOR.findViewById(R.id.qm);
            this.timeTv = (TextView) this.jOR.findViewById(R.id.la);
            this.jPQ = this.jOR.findViewById(R.id.a8t);
            AppMethodBeat.o(33077);
        }
    }
}
