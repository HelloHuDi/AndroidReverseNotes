package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.neattextview.textview.layout.C5782a;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C41764q;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.chatting.C40788j;
import com.tencent.p177mm.p612ui.chatting.C44288am;
import com.tencent.p177mm.p612ui.chatting.C44290ao;
import com.tencent.p177mm.p612ui.chatting.C44315r;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5394d.C5404f;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C11263c;
import com.tencent.p177mm.pluginsdk.model.C30080q;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e.C35837a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35838f;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.t */
public final class C23873t {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.t$d */
    static class C15760d extends C23865b {
        ImageView jOX;
        ImageView jOY;
        TextView jPN;
        ImageView jPO;

        C15760d() {
        }

        /* renamed from: fc */
        public final void mo27968fc(View view) {
            AppMethodBeat.m2504i(33073);
            if (this.jOR != null) {
                AppMethodBeat.m2505o(33073);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(2131821834);
            if (viewStub == null) {
                AppMethodBeat.m2505o(33073);
                return;
            }
            viewStub.inflate();
            this.jOR = view.findViewById(2131821856);
            this.jOX = (ImageView) this.jOR.findViewById(2131821404);
            this.gsf = (TextView) this.jOR.findViewById(2131820678);
            this.jPN = (TextView) this.jOR.findViewById(2131821858);
            this.jOY = (ImageView) this.jOR.findViewById(2131821843);
            this.jPO = (ImageView) this.jOR.findViewById(2131821859);
            this.jPd = (ImageView) this.jOR.findViewById(2131821860);
            AppMethodBeat.m2505o(33073);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.t$b */
    static class C23865b {
        TextView gsf;
        View jOR;
        ImageView jPd;

        C23865b() {
        }

        /* renamed from: fc */
        public void mo27968fc(View view) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.t$j */
    public static class C23867j extends C5378c {
        private static int jNf;
        private static int jNg = 0;
        private static int jNh = 0;
        private static int jNi = 0;
        private static int jNj;
        private static int pFp;
        private long jPG = 0;
        private boolean jPH = false;
        private C46650a yJI;
        private boolean zeB = false;
        private int zeC = 0;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (i == 285212721) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33086);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969033);
                C23875c c23875c = new C23875c();
                c23875c.enf = (TextView) view.findViewById(2131820587);
                c23875c.zbx = view.findViewById(2131820583);
                c23875c.jPr = (LinearLayout) view.findViewById(2131822453);
                c23875c.moo = (CheckBox) view.findViewById(2131820580);
                c23875c.iVh = view.findViewById(2131820586);
                c23875c.zbU = (TextView) view.findViewById(2131822454);
                view.setTag(c23875c);
            }
            C23867j.m36780hW(layoutInflater.getContext());
            AppMethodBeat.m2505o(33086);
            return view;
        }

        /* renamed from: hW */
        private static void m36780hW(Context context) {
            AppMethodBeat.m2504i(33087);
            if (jNi == 0) {
                jNi = context.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
                jNh = context.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo);
                jNg = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
                jNf = context.getResources().getDimensionPixelSize(C25738R.dimen.f10287wv);
                jNj = context.getResources().getDimensionPixelSize(C25738R.dimen.f10285wt);
                int gd = C1338a.m2868gd(context);
                int ge = C1338a.m2869ge(context);
                if (gd >= ge) {
                    gd = ge;
                }
                pFp = (int) (((double) (gd - ((int) (C1338a.getDensity(context) * 32.0f)))) / 2.35d);
            }
            AppMethodBeat.m2505o(33087);
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
        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33088);
            this.yJI = c46650a;
            C23867j.m36780hW(c46650a.yTx.getContext());
            C23875c c23875c = (C23875c) c5379a;
            for (C23874a c23874a : c23875c.jPu) {
                if (c23875c.jPu.indexOf(c23874a) != c23875c.jPu.size() - 1) {
                    C44290ao.m80047aj(c23874a.jOR, 1);
                } else {
                    C44290ao.m80047aj(c23874a.jOR, 2);
                }
                c23875c.jPr.removeView(c23874a.jOR);
            }
            c23875c.jPu.clear();
            C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c7620bi.field_msgId, c7620bi.field_content);
            String str2 = b.dJv;
            if (str2 == null || str2.length() == 0) {
                c23875c.zbU.setVisibility(8);
            } else {
                c23875c.zbU.setVisibility(0);
                mo11018b(c46650a, (View) c23875c.zbU, (Object) C40814ay.arL(str2));
            }
            List list = b.fjr;
            int size = list.size();
            if (size == 0) {
                c23875c.jPr.setVisibility(8);
                C23867j.m36774a(c23875c, -1, 0);
                AppMethodBeat.m2505o(33088);
                return;
            }
            int i2;
            View Ot;
            int dPe;
            C32224p c32224p;
            c23875c.jPr.setVisibility(0);
            C23867j.m36774a(c23875c, ((C32224p) list.get(0)).type, size);
            LayoutInflater activityLayoutInflater = c46650a.yTx.getActivityLayoutInflater();
            int size2 = c23875c.jPu.size() + 2;
            while (true) {
                i2 = size2;
                if (i2 >= size) {
                    break;
                }
                Ot = C44290ao.m80046Ot(1);
                if (Ot == null) {
                    Ot = activityLayoutInflater.inflate(2130969034, null);
                }
                c23875c.mo39647fd(Ot);
                size2 = i2 + 1;
            }
            if (size > 1) {
                Ot = C44290ao.m80046Ot(2);
                if (Ot == null) {
                    Ot = activityLayoutInflater.inflate(2130969035, null);
                }
                c23875c.mo39647fd(Ot);
                this.zeB = true;
            } else {
                this.zeB = false;
            }
            size2 = 0;
            while (true) {
                i2 = size2;
                if (i2 >= c23875c.jPu.size()) {
                    break;
                }
                ((C23874a) c23875c.jPu.get(i2)).jOR.setVisibility(8);
                size2 = i2 + 1;
            }
            C32224p c32224p2 = (C32224p) list.get(0);
            final C23875c c23875c2;
            if (c32224p2.type == 5) {
                C23867j.m36779ds(c23875c.zew.jPQ);
                C23867j.m36779ds(c23875c.zew.jPe);
                if (C42252ah.isNullOrNil(c32224p2.title)) {
                    c23875c.zew.jPi.setVisibility(8);
                } else {
                    c23875c.zew.jPi.mo15921ah(c32224p2.title);
                    c23875c.zew.jPi.getPaint().setFakeBoldText(true);
                    c23875c.zew.jPi.setVisibility(0);
                    c23875c.zew.jPi.setTextColor(this.yJI.yTx.getContext().getResources().getColor(C25738R.color.f12119t1));
                }
                if (size == 1) {
                    c23875c.zew.jPd.setBackgroundResource(C25738R.drawable.f6469f6);
                    c23875c.zew.jPe.setBackgroundResource(C25738R.drawable.f6586iz);
                } else {
                    c23875c.zew.jPd.setBackgroundResource(C25738R.drawable.f6445ee);
                    c23875c.zew.jPe.setBackgroundResource(C25738R.drawable.f6587j0);
                }
                str2 = C1192l.m2623kr(c32224p2.fjB);
                if (TextUtils.isEmpty(str2)) {
                    c23875c.zew.timeTv.setVisibility(8);
                } else {
                    c23875c.zew.timeTv.setVisibility(0);
                    c23875c.zew.timeTv.setText(str2);
                    c23875c.zew.timeTv.setTextColor(this.yJI.yTx.getContext().getResources().getColor(C25738R.color.f12119t1));
                }
                m36772a(c32224p2, c7620bi, i, b, c23875c.zew.jOR);
                c23875c.zew.jPd.setVisibility(8);
                c23875c2 = c23875c;
                m36778a(c32224p2.fjx, c23875c.zew.jOX, c7620bi.getType(), size > 1, pFp, new C35837a() {
                    public final void onFinish() {
                        AppMethodBeat.m2504i(33081);
                        c23875c2.zew.jPd.setVisibility(0);
                        c23875c2.zew.jPi.setTextColor(C23867j.this.yJI.yTx.getContext().getResources().getColor(C25738R.color.a69));
                        c23875c2.zew.timeTv.setTextColor(C23867j.this.yJI.yTx.getContext().getResources().getColor(C25738R.color.a69));
                        AppMethodBeat.m2505o(33081);
                    }
                });
                if (C1338a.m2860dm(this.yJI.yTx.getContext()) > 1.375f) {
                    c23875c.zew.jPi.setMaxLines(1);
                } else {
                    c23875c.zew.jPi.setMaxLines(2);
                }
            } else if (c32224p2.type == 8) {
                C23867j.m36779ds(c23875c.zex.jPQ);
                C23867j.m36779ds(c23875c.zex.jPe);
                if (size == 1) {
                    c23875c.zex.jPd.setBackgroundResource(C25738R.drawable.f6459ew);
                    c23875c.zex.jPe.setBackgroundResource(C25738R.drawable.f6586iz);
                    c23875c.zex.pFw.setBackgroundResource(C25738R.drawable.axc);
                } else {
                    c23875c.zex.jPd.setBackgroundResource(C25738R.drawable.f6446ef);
                    c23875c.zex.jPe.setBackgroundResource(C25738R.drawable.f6587j0);
                    c23875c.zex.pFw.setBackgroundResource(C25738R.drawable.f6460ex);
                }
                c23875c.zex.jPd.setVisibility(8);
                c23875c.zex.pFw.setVisibility(8);
                c23875c.zex.iNr.setBackgroundResource(C1318a.chatting_item_biz_pic_loading_icon);
                c23875c2 = c23875c;
                m36778a(c32224p2.fjx, c23875c.zex.jOX, c7620bi.getType(), size > 1, pFp, new C35837a() {
                    public final void onFinish() {
                        AppMethodBeat.m2504i(33083);
                        c23875c2.zex.jPd.setVisibility(0);
                        c23875c2.zex.pFw.setVisibility(0);
                        c23875c2.zex.iNr.setBackgroundResource(C1318a.chatting_item_biz_pic_icon);
                        AppMethodBeat.m2505o(33083);
                    }
                });
                m36772a(c32224p2, c7620bi, i, b, c23875c.zex.jOR);
            } else if (c32224p2.type == 7) {
                if (C42252ah.isNullOrNil(c32224p2.title)) {
                    c23875c.zey.gsf.setVisibility(8);
                } else {
                    c23875c.zey.gsf.setVisibility(0);
                    c23875c.zey.gsf.setText(c32224p2.title);
                }
                if (size > 1) {
                    c23875c.zey.jOR.setBackgroundResource(C25738R.drawable.f6577ip);
                } else {
                    c23875c.zey.jOR.setBackgroundResource(C25738R.drawable.f6578iq);
                }
                str2 = C1192l.m2623kr(c32224p2.fjB);
                if (TextUtils.isEmpty(str2)) {
                    c23875c.zey.ngD.setVisibility(4);
                } else {
                    c23875c.zey.ngD.setVisibility(0);
                    c23875c.zey.ngD.setText(str2);
                }
                Drawable drawable = c23875c.zey.jOY.getDrawable();
                if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                    ((AnimationDrawable) drawable).stop();
                }
                if ((c7620bi.field_msgId + "_0").equals(c23875c.zbz)) {
                    c23875c.zey.jOY.setImageResource(C25738R.drawable.f6569ig);
                    if (c23875c.zey.jOY.getDrawable() instanceof AnimationDrawable) {
                        ((AnimationDrawable) c23875c.zey.jOY.getDrawable()).start();
                    }
                } else {
                    c23875c.zey.jOY.setImageResource(C25738R.drawable.f6568if);
                }
                m36769a(c23875c.zey.jOY, c7620bi, 0);
                m36772a(c32224p2, c7620bi, i, b, c23875c.zey.jOR);
            } else if (c32224p2.type == 6) {
                C32224p c32224p3 = (C32224p) list.get(0);
                if (C42252ah.isNullOrNil(c32224p3.title)) {
                    c23875c.zez.gsf.setVisibility(8);
                } else {
                    c23875c.zez.gsf.setVisibility(0);
                    c23875c.zez.gsf.setText(c32224p3.title);
                }
                if (size > 1) {
                    c23875c.zez.jOR.setBackgroundResource(C25738R.drawable.f6577ip);
                } else {
                    c23875c.zez.jOR.setBackgroundResource(C25738R.drawable.f6578iq);
                }
                if (TextUtils.isEmpty(c32224p3.fjL)) {
                    c23875c.zez.jPN.setVisibility(8);
                } else {
                    c23875c.zez.jPN.setVisibility(0);
                    c23875c.zez.jPN.setText(c32224p3.fjL);
                }
                if (c32224p3.fjM == 2) {
                    c23875c.zez.jPO.setImageResource(C1318a.chatting_item_biz_kugou_music_watermark);
                } else {
                    c23875c.zez.jPO.setImageResource(C1318a.chatting_item_biz_qq_music_watermark);
                }
                m36769a(c23875c.zez.jOY, c7620bi, 0);
                m36772a(c32224p3, c7620bi, i, b, c23875c.zez.jOR);
                if ((c7620bi.field_msgId + "_0").equals(c23875c.zbz)) {
                    c23875c.zez.jOY.setImageResource(C1318a.chatting_item_biz_music_pause_loading_icon);
                } else {
                    c23875c.zez.jOY.setImageResource(C1318a.chatting_item_biz_music_play_loading_icon);
                }
                c23875c.zez.jPd.setVisibility(8);
                String str3 = c32224p3.fjx;
                ImageView imageView = c23875c.zez.jOX;
                int type = c7620bi.getType();
                int i3 = jNf;
                c23875c2 = c23875c;
                final C7620bi c7620bi2 = c7620bi;
                C23867j.m36777a(str3, imageView, type, i3, i3, "@S", new C35837a() {
                    public final void onFinish() {
                        AppMethodBeat.m2504i(33082);
                        c23875c2.zez.jPd.setVisibility(0);
                        if ((c7620bi2.field_msgId + "_0").equals(c23875c2.zbz)) {
                            c23875c2.zez.jOY.setImageResource(C25738R.drawable.f6566ic);
                            AppMethodBeat.m2505o(33082);
                            return;
                        }
                        c23875c2.zez.jOY.setImageResource(C25738R.drawable.f6567id);
                        AppMethodBeat.m2505o(33082);
                    }
                });
            } else if (c32224p2.type == 10) {
                if (C42252ah.isNullOrNil(c32224p2.title)) {
                    c23875c.zeA.jPi.setVisibility(8);
                } else {
                    c23875c.zeA.jPi.setVisibility(0);
                    c23875c.zeA.jPi.mo15921ah(C44089j.m79282a(this.yJI.yTx.getContext(), c32224p2.title, (int) c23875c.zeA.jPi.getTextSize()));
                    C5782a QV = c23875c.zeA.jPi.mo15918QV(C1338a.m2868gd(this.yJI.yTx.getContext()) - ((int) (C1338a.getDensity(this.yJI.yTx.getContext()) * 80.0f)));
                    if (QV != null) {
                        dPe = QV.dPe();
                    } else {
                        dPe = 0;
                    }
                    LayoutParams layoutParams = (LayoutParams) c23875c.zeA.jPi.getLayoutParams();
                    if (dPe == 1) {
                        layoutParams.gravity = 17;
                    } else {
                        layoutParams.gravity = 19;
                    }
                    c23875c.zeA.jPi.setLayoutParams(layoutParams);
                }
                if (size > 1) {
                    c23875c.zeA.jOR.setBackgroundResource(C25738R.drawable.f6577ip);
                    c23875c.zeA.jPU.setVisibility(8);
                } else {
                    c23875c.zeA.jOR.setBackgroundResource(C25738R.drawable.f6578iq);
                    c23875c.zeA.jPU.setVisibility(0);
                }
                m36772a(c32224p2, c7620bi, i, b, c23875c.zeA.jOR);
            } else {
                c23875c.zev.gsf.setVisibility(size > 1 ? 8 : 0);
                TextView textView = c23875c.zev.pFH;
                size2 = (size > 1 || C42252ah.isNullOrNil(c32224p2.fjz)) ? 8 : 0;
                textView.setVisibility(size2);
                c23875c.zev.pFv.setVisibility(size > 1 ? 0 : 8);
                c23875c.zev.pFw.setVisibility(8);
                if (size == 1) {
                    c23875c.zev.jPe.setBackgroundResource(C25738R.drawable.f6586iz);
                    c23875c.zev.gCY.setVisibility(0);
                } else {
                    c23875c.zev.gCY.setVisibility(C42252ah.isNullOrNil(c32224p2.fjx) ? 0 : 8);
                    c23875c.zev.jPe.setBackgroundResource(C25738R.drawable.f6587j0);
                    c23875c.zev.pFv.setTextColor(this.yJI.yTx.getContext().getResources().getColor(C25738R.color.f12119t1));
                    c23875c.zev.pFv.setBackgroundResource(C25738R.drawable.f6900uv);
                    c23875c.zev.pFv.getPaint().setFakeBoldText(true);
                }
                C23867j.m36779ds(c23875c.zev.jPQ);
                C23867j.m36779ds(c23875c.zev.jPe);
                int i4;
                if (C42252ah.isNullOrNil(c32224p2.fjx)) {
                    c23875c.zev.jPQ.setVisibility(8);
                    c23875c.zev.gsf.setVisibility(0);
                    c23875c.zev.pFH.setVisibility(C42252ah.isNullOrNil(c32224p2.fjz) ? 8 : 0);
                    if (size == 1) {
                        c23875c.zev.gCY.setBackgroundResource(C25738R.drawable.f6578iq);
                    } else {
                        c23875c.zev.gCY.setBackgroundResource(C25738R.drawable.f6577ip);
                    }
                    Ot = c23875c.zev.gCY;
                    dPe = jNg;
                    i4 = jNg;
                    Ot.setPadding(dPe, dPe, i4, i4);
                    c23875c.zev.jPe.setVisibility(8);
                } else {
                    c23875c.zev.jPQ.setVisibility(0);
                    final int i5 = size;
                    final C23875c c23875c3 = c23875c;
                    m36778a(c32224p2.fjx, c23875c.zev.jOX, c7620bi.getType(), true, pFp, new C35837a() {
                        public final void onFinish() {
                            AppMethodBeat.m2504i(33080);
                            if (i5 > 1) {
                                c23875c3.zev.pFv.setTextColor(C23867j.this.yJI.yTx.getContext().getResources().getColor(C25738R.color.a69));
                                c23875c3.zev.pFv.setBackgroundResource(C25738R.drawable.f6447eh);
                            }
                            c23875c3.zev.pFw.setVisibility(0);
                            AppMethodBeat.m2505o(33080);
                        }
                    });
                    c23875c.zev.gCY.setBackgroundResource(C25738R.drawable.b18);
                    Ot = c23875c.zev.gCY;
                    dPe = jNg;
                    i4 = jNh;
                    int i6 = jNg;
                    Ot.setPadding(dPe, i4, i6, i6);
                    c23875c.zev.jPe.setVisibility(0);
                }
                c23875c.zev.pFH.setText(c32224p2.fjz);
                c23875c.zev.gsf.setText(c32224p2.title);
                c23875c.zev.pFv.mo15921ah(c32224p2.title);
                if (!(c32224p2.fjA == 0 || c32224p2.fjA == 1)) {
                    c23875c.zev.pFv.setVisibility(4);
                }
                m36772a(c32224p2, c7620bi, i, b, c23875c.zev.jOR);
            }
            size2 = 1;
            while (true) {
                int i7 = size2;
                if (i7 >= size) {
                    break;
                }
                String ari;
                C40814ay c40814ay;
                C32224p c32224p4 = (C32224p) list.get(i7);
                C23874a c23874a2 = (C23874a) c23875c.jPu.get(i7 - 1);
                size2 = c32224p2.type;
                if (i7 != 1 || (size2 != 5 && size2 != 8 && size2 != 0)) {
                    c23874a2.jOS.setVisibility(0);
                    if (i7 > 1) {
                        c32224p = (C32224p) list.get(i7 - 1);
                        C32224p c32224p5 = (C32224p) list.get(i7);
                        if ((c32224p.type == 7 || c32224p.type == 5 || c32224p.type == 6 || !C42252ah.isNullOrNil(c32224p.fjx)) && (c32224p5.type == 7 || c32224p5.type == 5 || c32224p5.type == 6 || !C42252ah.isNullOrNil(c32224p5.fjx))) {
                            C23867j.m36765O(c23874a2.jOS, jNj);
                        } else {
                            C23867j.m36765O(c23874a2.jOS, jNg);
                        }
                        if (i7 == 1) {
                            if (i7 == size - 1) {
                                c23874a2.jOT.setPadding(0, jNg, 0, jNg);
                            } else {
                                c23874a2.jOT.setPadding(0, jNg, 0, jNi);
                            }
                        } else if (i7 == size - 1) {
                            c23874a2.jOT.setPadding(0, jNi, 0, jNg);
                        } else {
                            c23874a2.jOT.setPadding(0, jNi, 0, jNi);
                        }
                        m36775a(c23875c, c23874a2, c32224p4, c7620bi, i7, false);
                        c23874a2.gsf.setText(c32224p4.title);
                        c23874a2.gsf.setTextColor(c46650a.yTx.getMMResources().getColor(C25738R.color.f11782h4));
                        if (c32224p4.fjA != 0 || c32224p4.fjA == 1) {
                            c23874a2.jOW.setVisibility(0);
                            c23874a2.gsf.setTextColor(c46650a.yTx.getMMResources().getColor(C25738R.color.f11782h4));
                            if (c32224p4.type == 7) {
                                c23874a2.jOX.setVisibility(8);
                            } else if (!C42252ah.isNullOrNil(c32224p4.fjx)) {
                                c23874a2.jOX.setVisibility(0);
                                str2 = c32224p4.fjx;
                                ImageView imageView2 = c23874a2.jOX;
                                int type2 = c7620bi.getType();
                                int i8 = jNf;
                                final C23875c c23875c4 = c23875c;
                                final C23874a c23874a3 = c23874a2;
                                final C32224p c32224p6 = c32224p4;
                                final C7620bi c7620bi3 = c7620bi;
                                final int i9 = i7;
                                C23867j.m36777a(str2, imageView2, type2, i8, i8, "@S", new C35837a() {
                                    public final void onFinish() {
                                        AppMethodBeat.m2504i(33079);
                                        C23867j.m36776a(C23867j.this, c23875c4, c23874a3, c32224p6, c7620bi3, i9);
                                        AppMethodBeat.m2505o(33079);
                                    }
                                });
                            } else if (c32224p4.type == 5 || c32224p4.type == 6) {
                                c23874a2.jOX.setVisibility(0);
                                ImageView imageView3 = c23874a2.jOX;
                                size2 = jNf;
                                C25815a ahp = C32291o.ahp();
                                C17927a c17927a = new C17927a();
                                c17927a.ePF = true;
                                c17927a.ePT = C25738R.color.f11875k8;
                                C17927a ct = c17927a.mo33448ct(size2, size2);
                                ct.fHe = 4;
                                ahp.mo43769a("2130841060", imageView3, ct.ahG(), null, new C35836e());
                            } else {
                                c23874a2.jOW.setVisibility(8);
                            }
                        } else {
                            c23874a2.jOW.setVisibility(8);
                            c23874a2.gsf.setTextColor(c46650a.yTx.getMMResources().getColor(C25738R.color.f12092s0));
                        }
                        if (C42252ah.isNullOrNil(c32224p4.fjz) && c32224p4.type == 3) {
                            c23874a2.jOV.setText(c32224p4.fjz);
                            c23874a2.jOV.setVisibility(0);
                        } else {
                            c23874a2.jOV.setVisibility(8);
                        }
                        c23874a2.jOR.setVisibility(0);
                        ari = ((C36135d) c46650a.mo74857aF(C36135d.class)).ari(c32224p4.url);
                        if (TextUtils.isEmpty(ari)) {
                            c40814ay = new C40814ay(c7620bi, false, i, c32224p4.url, this.zeB, c46650a.dDw(), b.cMg, b.cMh);
                            m36773a(c40814ay, c32224p4, c7620bi);
                            c23874a2.jOR.setOnClickListener(mo11029h(c46650a));
                        } else {
                            C4990ab.m7411d("MicroMsg.ChattingItemBizFrom", "productId:%s", ari);
                            c40814ay = new C40814ay(c7620bi, false, i, c32224p4.url, this.zeB, c46650a.dDw(), b.cMg, b.cMh, c32224p4.title, ari, null, false, true);
                            c23874a2.jOR.setOnClickListener(mo11030i(c46650a));
                        }
                        c40814ay.unn = c7620bi.field_msgSvrId;
                        c40814ay.uno = i7;
                        c40814ay.ziA = c32224p4.type;
                        c23874a2.jOR.setTag(c40814ay);
                        if (C1192l.m2624mg(c32224p4.fjC)) {
                            m36770a(c32224p4, c23874a2.jOR);
                        }
                        m36771a(c32224p4, c23874a2.jOR, c7620bi.field_msgId, c7620bi.field_msgSvrId, i7);
                        c23874a2.jOR.setOnLongClickListener(mo11021c(c46650a));
                        c23874a2.jOR.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                        size2 = i7 + 1;
                    }
                } else if (size2 == 0 && C42252ah.isNullOrNil(((C32224p) list.get(0)).fjx)) {
                    c23874a2.jOS.setVisibility(0);
                } else {
                    c23874a2.jOS.setVisibility(8);
                    if (i7 == 1) {
                    }
                    m36775a(c23875c, c23874a2, c32224p4, c7620bi, i7, false);
                    c23874a2.gsf.setText(c32224p4.title);
                    c23874a2.gsf.setTextColor(c46650a.yTx.getMMResources().getColor(C25738R.color.f11782h4));
                    if (c32224p4.fjA != 0) {
                    }
                    c23874a2.jOW.setVisibility(0);
                    c23874a2.gsf.setTextColor(c46650a.yTx.getMMResources().getColor(C25738R.color.f11782h4));
                    if (c32224p4.type == 7) {
                    }
                    if (C42252ah.isNullOrNil(c32224p4.fjz)) {
                    }
                    c23874a2.jOV.setVisibility(8);
                    c23874a2.jOR.setVisibility(0);
                    ari = ((C36135d) c46650a.mo74857aF(C36135d.class)).ari(c32224p4.url);
                    if (TextUtils.isEmpty(ari)) {
                    }
                    c40814ay.unn = c7620bi.field_msgSvrId;
                    c40814ay.uno = i7;
                    c40814ay.ziA = c32224p4.type;
                    c23874a2.jOR.setTag(c40814ay);
                    if (C1192l.m2624mg(c32224p4.fjC)) {
                    }
                    m36771a(c32224p4, c23874a2.jOR, c7620bi.field_msgId, c7620bi.field_msgSvrId, i7);
                    c23874a2.jOR.setOnLongClickListener(mo11021c(c46650a));
                    c23874a2.jOR.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                    size2 = i7 + 1;
                }
                C23867j.m36765O(c23874a2.jOS, jNg);
                if (i7 == 1) {
                }
                m36775a(c23875c, c23874a2, c32224p4, c7620bi, i7, false);
                c23874a2.gsf.setText(c32224p4.title);
                c23874a2.gsf.setTextColor(c46650a.yTx.getMMResources().getColor(C25738R.color.f11782h4));
                if (c32224p4.fjA != 0) {
                }
                c23874a2.jOW.setVisibility(0);
                c23874a2.gsf.setTextColor(c46650a.yTx.getMMResources().getColor(C25738R.color.f11782h4));
                if (c32224p4.type == 7) {
                }
                if (C42252ah.isNullOrNil(c32224p4.fjz)) {
                }
                c23874a2.jOV.setVisibility(8);
                c23874a2.jOR.setVisibility(0);
                ari = ((C36135d) c46650a.mo74857aF(C36135d.class)).ari(c32224p4.url);
                if (TextUtils.isEmpty(ari)) {
                }
                c40814ay.unn = c7620bi.field_msgSvrId;
                c40814ay.uno = i7;
                c40814ay.ziA = c32224p4.type;
                c23874a2.jOR.setTag(c40814ay);
                if (C1192l.m2624mg(c32224p4.fjC)) {
                }
                m36771a(c32224p4, c23874a2.jOR, c7620bi.field_msgId, c7620bi.field_msgSvrId, i7);
                c23874a2.jOR.setOnLongClickListener(mo11021c(c46650a));
                c23874a2.jOR.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                size2 = i7 + 1;
            }
            if (((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(2)) {
                size2 = 0;
                while (true) {
                    dPe = size2;
                    if (dPe >= list.size()) {
                        break;
                    }
                    c32224p = (C32224p) list.get(0);
                    ((C20023b) C1720g.m3528K(C20023b.class)).mo6749a(c32224p.url, c32224p.type, 0, new Object[0]);
                    size2 = dPe + 1;
                }
            }
            AppMethodBeat.m2505o(33088);
        }

        /* renamed from: a */
        private void m36772a(C32224p c32224p, C7620bi c7620bi, int i, C32223o c32223o, View view) {
            C40814ay c40814ay;
            AppMethodBeat.m2504i(33089);
            String ari = ((C36135d) this.yJI.mo74857aF(C36135d.class)).ari(c32224p.url);
            if (TextUtils.isEmpty(ari)) {
                c40814ay = new C40814ay(c7620bi, false, i, c32224p.url, false, this.yJI.dDw(), c32223o.cMg, c32223o.cMh, c32224p.title);
                m36773a(c40814ay, c32224p, c7620bi);
                view.setOnClickListener(mo11029h(this.yJI));
            } else {
                C4990ab.m7411d("MicroMsg.ChattingItemBizFrom", "productId:%s", ari);
                c40814ay = new C40814ay(c7620bi, false, i, c32224p.url, false, this.yJI.dDw(), c32223o.cMg, c32223o.cMh, c32224p.title, ari, null, false, false);
                view.setOnClickListener(mo11030i(this.yJI));
            }
            c40814ay.unn = c7620bi.field_msgSvrId;
            c40814ay.uno = 0;
            c40814ay.ziA = c32224p.type;
            view.setTag(c40814ay);
            if (C1192l.m2624mg(c32224p.fjC)) {
                m36770a(c32224p, view);
            }
            m36771a(c32224p, view, c7620bi.field_msgId, c7620bi.field_msgSvrId, 0);
            view.setOnLongClickListener(mo11021c(this.yJI));
            view.setOnTouchListener(((C15612h) this.yJI.mo74857aF(C15612h.class)).dCZ());
            AppMethodBeat.m2505o(33089);
        }

        /* renamed from: ds */
        private static void m36779ds(View view) {
            AppMethodBeat.m2504i(33090);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = pFp;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(33090);
        }

        /* renamed from: M */
        private static void m36764M(View view, int i) {
            AppMethodBeat.m2504i(33091);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(33091);
        }

        /* renamed from: O */
        private static void m36765O(View view, int i) {
            AppMethodBeat.m2504i(33092);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.rightMargin = i;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(33092);
        }

        /* renamed from: a */
        private void m36775a(C23875c c23875c, final C23874a c23874a, C32224p c32224p, C7620bi c7620bi, int i, boolean z) {
            AppMethodBeat.m2504i(33093);
            if (c32224p.type == 5) {
                c23874a.jOY.setVisibility(0);
                c23874a.jOY.setImageResource(C25738R.drawable.axj);
                c23874a.jOY.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(33084);
                        c23874a.jOR.performClick();
                        AppMethodBeat.m2505o(33084);
                    }
                });
            } else if (c32224p.type == 6) {
                c23874a.jOY.setVisibility(0);
                if (z) {
                    if ((c7620bi.field_msgId + "_" + i).equals(c23875c.zbz)) {
                        c23874a.jOY.setImageResource(C25738R.drawable.f6566ic);
                    } else {
                        c23874a.jOY.setImageResource(C25738R.drawable.f6567id);
                    }
                } else if ((c7620bi.field_msgId + "_" + i).equals(c23875c.zbz)) {
                    c23874a.jOY.setImageResource(C1318a.chatting_item_biz_music_pause_loading_icon);
                } else {
                    c23874a.jOY.setImageResource(C1318a.chatting_item_biz_music_play_loading_icon);
                }
                m36769a(c23874a.jOY, c7620bi, i);
            } else if (c32224p.type == 7) {
                c23874a.jOY.setVisibility(0);
                Drawable drawable = c23874a.jOY.getDrawable();
                if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                    ((AnimationDrawable) drawable).stop();
                }
                if ((c7620bi.field_msgId + "_" + i).equals(c23875c.zbz)) {
                    c23874a.jOY.setImageResource(C25738R.drawable.f6569ig);
                    if (c23874a.jOY.getDrawable() instanceof AnimationDrawable) {
                        ((AnimationDrawable) c23874a.jOY.getDrawable()).start();
                    }
                } else {
                    c23874a.jOY.setImageResource(C25738R.drawable.f6568if);
                }
                m36769a(c23874a.jOY, c7620bi, i);
            } else {
                c23874a.jOY.setVisibility(8);
            }
            int fromDPToPix = C1338a.fromDPToPix(this.yJI.yTx.getContext(), 26);
            if (c32224p.type == 7) {
                fromDPToPix = C1338a.fromDPToPix(this.yJI.yTx.getContext(), 32);
            }
            C23867j.m36764M(c23874a.jOY, fromDPToPix);
            AppMethodBeat.m2505o(33093);
        }

        /* renamed from: a */
        private void m36769a(ImageView imageView, C7620bi c7620bi, int i) {
            AppMethodBeat.m2504i(33094);
            C5404f c5404f = new C5404f();
            c5404f.cvx = c7620bi.field_msgId;
            c5404f.zcZ = i;
            c5404f.cHz = c7620bi.field_content;
            imageView.setTag(c5404f);
            imageView.setOnClickListener(((C15612h) this.yJI.mo74857aF(C15612h.class)).dDa());
            AppMethodBeat.m2505o(33094);
        }

        /* renamed from: a */
        private static void m36768a(View view, C23865b c23865b, boolean z) {
            AppMethodBeat.m2504i(33095);
            if (z) {
                if (c23865b.jOR == null) {
                    c23865b.mo27968fc(view);
                }
                if (c23865b.jOR != null) {
                    c23865b.jOR.setVisibility(0);
                    AppMethodBeat.m2505o(33095);
                    return;
                }
            } else if (c23865b.jOR != null) {
                c23865b.jOR.setVisibility(8);
            }
            AppMethodBeat.m2505o(33095);
        }

        /* renamed from: a */
        private static void m36774a(C23875c c23875c, int i, int i2) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(33096);
            boolean z3 = i == 5;
            C23867j.m36768a(c23875c.jPr, c23875c.zew, z3);
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
            C23867j.m36768a(c23875c.jPr, c23875c.zex, z3);
            if (z3) {
                z = true;
            }
            if (i == 7) {
                z3 = true;
            } else {
                z3 = false;
            }
            C23867j.m36768a(c23875c.jPr, c23875c.zey, z3);
            if (z3) {
                z = true;
            }
            if (i == 6) {
                z3 = true;
            } else {
                z3 = false;
            }
            C23867j.m36768a(c23875c.jPr, c23875c.zez, z3);
            if (z3) {
                z = true;
            }
            if (i == 10) {
                z3 = true;
            } else {
                z3 = false;
            }
            C23867j.m36768a(c23875c.jPr, c23875c.zeA, z3);
            if (z3) {
                z3 = true;
            } else {
                z3 = z;
            }
            View view = c23875c.jPr;
            C23865b c23865b = c23875c.zev;
            if (z3 || i2 <= 0) {
                z2 = false;
            }
            C23867j.m36768a(view, c23865b, z2);
            AppMethodBeat.m2505o(33096);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33097);
            C40814ay c40814ay = (C40814ay) view.getTag();
            if (c40814ay == null) {
                AppMethodBeat.m2505o(33097);
                return false;
            }
            this.zeC = c40814ay.uno;
            int i = c40814ay.position;
            C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c7620bi.field_msgId, c7620bi.field_content);
            if (b == null) {
                C4990ab.m7420w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
                AppMethodBeat.m2505o(33097);
                return false;
            }
            this.jPH = false;
            if (this.zeC >= 0 && this.zeC < b.fjr.size() && C1192l.m2624mg(((C32224p) b.fjr.get(this.zeC)).fjC)) {
                this.jPH = true;
            }
            if (!(this.yJI.dFy() || C40788j.m70657aE(c7620bi))) {
                contextMenu.add(i, 111, 0, view.getContext().getString(C25738R.string.dr1));
            }
            if (C25985d.afj("favorite") && !this.jPH) {
                contextMenu.add(i, 126, 0, view.getContext().getString(C25738R.string.dcq));
            }
            AppMethodBeat.m2505o(33097);
            return true;
        }

        /* renamed from: a */
        private void m36773a(C40814ay c40814ay, C32224p c32224p, C7620bi c7620bi) {
            int i;
            AppMethodBeat.m2504i(33098);
            Bundle bundle = new Bundle();
            switch (C32798u.m53583ad(mo11017b(this.yJI, c7620bi), this.yJI.getTalkerUserName())) {
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
            bundle.putString("share_report_pre_msg_url", c32224p.url);
            bundle.putString("share_report_pre_msg_title", c32224p.title);
            bundle.putString("share_report_pre_msg_desc", c32224p.fjz);
            bundle.putString("share_report_pre_msg_icon_url", C1192l.m2619a(c32224p));
            bundle.putString("share_report_pre_msg_appid", "");
            bundle.putInt("share_report_from_scene", i);
            if (i == 5) {
                bundle.putString("share_report_biz_username", this.yJI.getTalkerUserName());
            }
            c40814ay.ziy = bundle;
            AppMethodBeat.m2505o(33098);
        }

        /* renamed from: a */
        private static void m36777a(String str, ImageView imageView, int i, int i2, int i3, String str2, C35837a c35837a) {
            String sy;
            AppMethodBeat.m2504i(33099);
            if (C41764q.ahs()) {
                sy = C41764q.m73703sy(str);
            } else {
                sy = str;
            }
            C25815a ahp = C32291o.ahp();
            C17927a c17927a = new C17927a();
            c17927a.ePV = C25738R.color.f11875k8;
            c17927a.ePH = true;
            c17927a = c17927a.mo33448ct(i2, i3);
            c17927a.fGV = new C35838f();
            c17927a.ePJ = C30080q.m47642v(sy, i, str2);
            ahp.mo43769a(sy, imageView, c17927a.ahG(), null, new C35836e(0, 0, 0, c35837a));
            AppMethodBeat.m2505o(33099);
        }

        /* renamed from: a */
        private void m36778a(String str, ImageView imageView, int i, boolean z, int i2, C35837a c35837a) {
            String sy;
            AppMethodBeat.m2504i(33100);
            if (C41764q.ahs()) {
                sy = C41764q.m73703sy(str);
            } else {
                sy = str;
            }
            int i3 = z ? C25738R.drawable.axd : C25738R.drawable.axb;
            int i4 = z ? C25738R.drawable.f6444ed : C25738R.drawable.f6443eb;
            int gd = C1338a.m2868gd(imageView.getContext()) - ((int) (((float) (((C15612h) this.yJI.mo74857aF(C15612h.class)).isInEditMode() ? 72 : 32)) * C1338a.getDensity(imageView.getContext())));
            C25815a ahp = C32291o.ahp();
            C17927a c17927a = new C17927a();
            c17927a.ePV = i4;
            c17927a.ePH = true;
            c17927a.ePX = String.valueOf(i3);
            C17927a ct = c17927a.mo33448ct(gd, i2);
            ct.fGV = new C35838f();
            ct.ePJ = C30080q.m47642v(sy, i, "@T");
            ahp.mo43769a(sy, imageView, ct.ahG(), null, new C35836e(i3, gd, i2, c35837a));
            AppMethodBeat.m2505o(33100);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33101);
            this.jPG = C42252ah.anT();
            String a;
            switch (menuItem.getItemId()) {
                case 111:
                    if (this.jPH) {
                        if (this.jPH) {
                            C44315r.m80100a(this.zeC, c46650a.yTx.getContext(), c7620bi.field_content, c7620bi.field_talker, c7620bi.field_msgId, c7620bi.field_msgSvrId);
                        } else {
                            C4990ab.m7420w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
                        }
                        AppMethodBeat.m2505o(33101);
                        break;
                    }
                    a = C23867j.m36767a(c7620bi, c46650a.yTx.getContext(), this.zeC);
                    if (!C42252ah.isNullOrNil(a)) {
                        Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                        intent.putExtra("Retr_Msg_content", a);
                        intent.putExtra("Retr_Msg_Type", 2);
                        intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.zeC);
                        intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                        intent.putExtra("Retr_MsgFromScene", 1);
                        a = c7620bi.field_talker;
                        String nW = C37922v.m64078nW(c7620bi.field_msgSvrId);
                        intent.putExtra("reportSessionId", nW);
                        C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                        y.mo53356j("prePublishId", "msg_" + c7620bi.field_msgSvrId);
                        y.mo53356j("preUsername", a);
                        y.mo53356j("preChatName", a);
                        y.mo53356j("preMsgIndex", Integer.valueOf(this.zeC));
                        y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
                        c46650a.startActivity(intent);
                    }
                case 114:
                    a = C23867j.m36767a(c7620bi, c46650a.yTx.getContext(), 0);
                    if (!C42252ah.isNullOrNil(a)) {
                        C44288am.m80032c(c7620bi, a, c46650a.yTx.getContext());
                    }
                    AppMethodBeat.m2505o(33101);
                    break;
                case 126:
                    C44315r.m80101a(this.jPG, this.zeC, c46650a.yTx.getContext(), c46650a.yTx, null, c7620bi);
                    AppMethodBeat.m2505o(33101);
                    break;
            }
            AppMethodBeat.m2505o(33101);
            return false;
        }

        /* renamed from: a */
        private static String m36767a(C7620bi c7620bi, Context context, int i) {
            AppMethodBeat.m2504i(33102);
            if (context == null) {
                C4990ab.m7420w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
                AppMethodBeat.m2505o(33102);
                return null;
            } else if (c7620bi == null) {
                C4990ab.m7420w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
                AppMethodBeat.m2505o(33102);
                return null;
            } else {
                String a = C1192l.m2618a(context, i, c7620bi.field_content, c7620bi.field_talker, c7620bi.field_msgId);
                AppMethodBeat.m2505o(33102);
                return a;
            }
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        private void m36770a(C32224p c32224p, View view) {
            AppMethodBeat.m2504i(33103);
            C44315r.m80103a(c32224p, view, this.yJI.getTalkerUserName());
            AppMethodBeat.m2505o(33103);
        }

        /* renamed from: a */
        private void m36771a(C32224p c32224p, View view, long j, long j2, int i) {
            AppMethodBeat.m2504i(33104);
            if (c32224p.type == 5 && ((C20023b) C1720g.m3528K(C20023b.class)).aVP()) {
                final int i2 = i;
                final long j3 = j;
                final long j4 = j2;
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(33085);
                        int intExtra = C23867j.this.yJI.yTx.getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK);
                        View findViewById = view.findViewById(2131821404);
                        Bundle bundle = new Bundle();
                        bundle.putInt("biz_video_scene", 0);
                        bundle.putInt("biz_video_subscene", intExtra);
                        bundle.putInt("geta8key_scene", 7);
                        C11263c.m18982a(C23867j.this.yJI.yTx.getContext(), j3, j4, i2, findViewById, bundle);
                        AppMethodBeat.m2505o(33085);
                    }
                });
            }
            AppMethodBeat.m2505o(33104);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.t$a */
    static class C23874a {
        TextView gsf;
        View jOR;
        View jOS;
        View jOT;
        TextView jOV;
        View jOW;
        ImageView jOX;
        ImageView jOY;

        C23874a() {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.t$c */
    static class C23875c extends C5379a {
        LinearLayout jPr;
        List<C23874a> jPu = new ArrayList();
        TextView zbU;
        C23879g zeA = new C23879g();
        C23878f zev = new C23878f();
        C23880h zew = new C23880h();
        C23877e zex = new C23877e();
        C23876i zey = new C23876i();
        C15760d zez = new C15760d();

        C23875c() {
            AppMethodBeat.m2504i(33071);
            AppMethodBeat.m2505o(33071);
        }

        /* renamed from: fd */
        public final C5379a mo39647fd(View view) {
            AppMethodBeat.m2504i(33072);
            LinearLayout linearLayout = this.jPr;
            C23874a c23874a = new C23874a();
            c23874a.jOR = view;
            c23874a.jOS = view.findViewById(2131821838);
            c23874a.jOT = view.findViewById(2131821839);
            c23874a.gsf = (TextView) view.findViewById(2131820678);
            c23874a.jOV = (TextView) view.findViewById(2131821841);
            c23874a.jOW = view.findViewById(2131821403);
            c23874a.jOX = (ImageView) view.findViewById(2131821404);
            c23874a.jOY = (ImageView) view.findViewById(2131821843);
            linearLayout.addView(view, linearLayout.getChildCount());
            this.jPu.add(c23874a);
            AppMethodBeat.m2505o(33072);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.t$i */
    static class C23876i extends C23865b {
        ImageView jOY;
        TextView ngD;

        C23876i() {
        }

        /* renamed from: fc */
        public final void mo27968fc(View view) {
            AppMethodBeat.m2504i(33078);
            if (this.jOR != null) {
                AppMethodBeat.m2505o(33078);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(2131821833);
            if (viewStub == null) {
                AppMethodBeat.m2505o(33078);
                return;
            }
            viewStub.inflate();
            this.jOR = view.findViewById(2131821874);
            this.gsf = (TextView) this.jOR.findViewById(2131820678);
            this.ngD = (TextView) this.jOR.findViewById(2131820988);
            this.jOY = (ImageView) this.jOR.findViewById(2131821843);
            AppMethodBeat.m2505o(33078);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.t$e */
    static class C23877e extends C23865b {
        ImageView iNr;
        ImageView jOX;
        View jPQ;
        ImageView jPe;
        ImageView pFw;

        C23877e() {
        }

        /* renamed from: fc */
        public final void mo27968fc(View view) {
            AppMethodBeat.m2504i(33074);
            if (this.jOR != null) {
                AppMethodBeat.m2505o(33074);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(2131821832);
            if (viewStub == null) {
                AppMethodBeat.m2505o(33074);
                return;
            }
            viewStub.inflate();
            this.jOR = view.findViewById(2131821861);
            this.jOX = (ImageView) this.jOR.findViewById(2131821404);
            this.jPd = (ImageView) this.jOR.findViewById(2131821860);
            this.jPe = (ImageView) this.jOR.findViewById(2131821855);
            this.pFw = (ImageView) this.jOR.findViewById(2131822456);
            this.iNr = (ImageView) this.jOR.findViewById(2131821864);
            this.jPQ = this.jOR.findViewById(2131821863);
            AppMethodBeat.m2505o(33074);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.t$f */
    static class C23878f extends C23865b {
        View gCY;
        ImageView jOX;
        View jPQ;
        ImageView jPe;
        TextView pFH;
        MMNeat7extView pFv;
        ImageView pFw;

        C23878f() {
        }

        /* renamed from: fc */
        public final void mo27968fc(View view) {
            AppMethodBeat.m2504i(33075);
            if (this.jOR != null) {
                AppMethodBeat.m2505o(33075);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(2131821830);
            if (viewStub == null) {
                AppMethodBeat.m2505o(33075);
                return;
            }
            viewStub.inflate();
            this.jOR = view.findViewById(2131821852);
            this.gsf = (TextView) this.jOR.findViewById(2131820678);
            this.jOX = (ImageView) this.jOR.findViewById(2131821404);
            this.jPQ = this.jOR.findViewById(2131822455);
            this.gCY = this.jOR.findViewById(2131822458);
            this.pFv = (MMNeat7extView) this.jOR.findViewById(2131822457);
            this.pFH = (TextView) this.jOR.findViewById(2131822459);
            this.jPe = (ImageView) this.jOR.findViewById(2131821855);
            this.pFw = (ImageView) this.jOR.findViewById(2131822456);
            AppMethodBeat.m2505o(33075);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.t$g */
    static class C23879g extends C23865b {
        View jPU;
        MMNeat7extView jPi;

        C23879g() {
        }

        /* renamed from: fc */
        public final void mo27968fc(View view) {
            AppMethodBeat.m2504i(33076);
            if (this.jOR != null) {
                AppMethodBeat.m2505o(33076);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(2131821835);
            if (viewStub == null) {
                AppMethodBeat.m2505o(33076);
                return;
            }
            viewStub.inflate();
            this.jOR = view.findViewById(2131821865);
            this.jPU = view.findViewById(2131820695);
            this.jPi = (MMNeat7extView) this.jOR.findViewById(2131820678);
            AppMethodBeat.m2505o(33076);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.t$h */
    static class C23880h extends C23865b {
        ImageView iNr;
        ImageView jOX;
        View jPQ;
        ImageView jPe;
        MMNeat7extView jPi;
        TextView timeTv;

        C23880h() {
        }

        /* renamed from: fc */
        public final void mo27968fc(View view) {
            AppMethodBeat.m2504i(33077);
            if (this.jOR != null) {
                AppMethodBeat.m2505o(33077);
                return;
            }
            ViewStub viewStub = (ViewStub) view.findViewById(2131821831);
            if (viewStub == null) {
                AppMethodBeat.m2505o(33077);
                return;
            }
            viewStub.inflate();
            this.jOR = view.findViewById(2131821868);
            this.jOX = (ImageView) this.jOR.findViewById(2131821404);
            this.jPd = (ImageView) this.jOR.findViewById(2131821860);
            this.jPe = (ImageView) this.jOR.findViewById(2131821855);
            this.iNr = (ImageView) this.jOR.findViewById(2131821872);
            this.jPi = (MMNeat7extView) this.jOR.findViewById(2131821185);
            this.timeTv = (TextView) this.jOR.findViewById(2131820988);
            this.jPQ = this.jOR.findViewById(2131821870);
            AppMethodBeat.m2505o(33077);
        }
    }
}
