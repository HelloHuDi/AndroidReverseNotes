package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.p1210a.C37974a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p201az.C32323b;
import com.tencent.p177mm.p230g.p231a.C18384ro;
import com.tencent.p177mm.p230g.p231a.C26197mo;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.p612ui.base.RealAlphabetScrollBar;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar.C30374a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.plugin.setting.model.C39650l;
import com.tencent.p177mm.plugin.setting.model.C39650l.C348491;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C7286vl;
import com.tencent.p177mm.protocal.protobuf.bhr;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI */
public class UnfamiliarContactDetailUI extends MMActivity implements C1202f {
    public static final String emJ = new String(Character.toChars(123));
    private C44275p ejZ = null;
    private ArrayList<C21822b> hUW = new ArrayList();
    private boolean qjN;
    private boolean qjO;
    private boolean qjP;
    private RecyclerView qpG;
    private TextView qpH;
    private View qpI;
    private View qpJ;
    private View qpK;
    private View qpL;
    private TextView qpM;
    private C21809a qpN;
    private RealAlphabetScrollBar qpO;
    HashMap<String, Integer> qpP = new HashMap();
    private HashMap<Integer, String> qpQ = new HashMap();
    private HashSet<Integer> qpR = new HashSet();
    private C21816d qpS;
    private int qpT = -1;
    private HashSet<String> qpU = new HashSet();
    private C39650l qpV;
    private boolean qpW;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$f */
    static class C13241f {
        static int qqu;
        static int qqv;
        static int qqw;
        static int qqx;
        static int qqy;
        static int qqz;
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$2 */
    class C217982 implements AnimationListener {
        C217982() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(127633);
            UnfamiliarContactDetailUI.this.qpI.setVisibility(0);
            AppMethodBeat.m2505o(127633);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$3 */
    class C217993 implements Comparator<C21822b> {
        C217993() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(127634);
            int compareTo = ((C21822b) obj).qqd.compareTo(((C21822b) obj2).qqd);
            AppMethodBeat.m2505o(127634);
            return compareTo;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$5 */
    class C218025 implements OnMenuItemClickListener {
        C218025() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127637);
            UnfamiliarContactDetailUI.this.finish();
            AppMethodBeat.m2505o(127637);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$h */
    public interface C21804h {
        /* renamed from: a */
        void mo37272a(C21823e c21823e);

        /* renamed from: e */
        void mo37273e(HashSet hashSet);

        void onError();

        void onSuccess();
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$g */
    interface C21805g {
        void cjq();

        /* renamed from: fh */
        void mo37277fh(int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$11 */
    class C2180611 implements C21804h {
        long start = System.currentTimeMillis();

        C2180611() {
            AppMethodBeat.m2504i(127648);
            AppMethodBeat.m2505o(127648);
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(127649);
            C4990ab.m7417i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", Integer.valueOf(UnfamiliarContactDetailUI.this.hUW.size()), Long.valueOf(System.currentTimeMillis() - this.start));
            UnfamiliarContactDetailUI.this.qpH.setText(UnfamiliarContactDetailUI.this.getString(C25738R.string.eyf) + "(" + UnfamiliarContactDetailUI.this.hUW.size() + ")");
            if (UnfamiliarContactDetailUI.this.hUW.size() == 0) {
                UnfamiliarContactDetailUI.this.findViewById(2131827455).setVisibility(0);
                UnfamiliarContactDetailUI.this.findViewById(2131821099).setVisibility(8);
                UnfamiliarContactDetailUI.this.findViewById(2131821925).setVisibility(8);
                UnfamiliarContactDetailUI.this.qpM.setText(UnfamiliarContactDetailUI.this.getString(C25738R.string.cn1));
                AppMethodBeat.m2505o(127649);
                return;
            }
            UnfamiliarContactDetailUI.this.findViewById(2131827455).setVisibility(8);
            UnfamiliarContactDetailUI.this.findViewById(2131821925).setVisibility(0);
            if (UnfamiliarContactDetailUI.this.qpN != null) {
                UnfamiliarContactDetailUI.this.qpN.aop.notifyChanged();
            }
            AppMethodBeat.m2505o(127649);
        }

        public final void onError() {
            AppMethodBeat.m2504i(127650);
            C4990ab.m7412e("MicroMsg.UnfamiliarContactUI", "[onError]");
            UnfamiliarContactDetailUI.this.findViewById(2131827455).setVisibility(0);
            UnfamiliarContactDetailUI.this.findViewById(2131821099).setVisibility(8);
            UnfamiliarContactDetailUI.this.qpM.setText(UnfamiliarContactDetailUI.this.getString(C25738R.string.eyl));
            AppMethodBeat.m2505o(127650);
        }

        /* renamed from: a */
        public final void mo37272a(C21823e c21823e) {
            AppMethodBeat.m2504i(127651);
            C4990ab.m7417i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", c21823e.name());
            UnfamiliarContactDetailUI.this.findViewById(2131827455).setVisibility(0);
            UnfamiliarContactDetailUI.this.findViewById(2131821099).setVisibility(0);
            if (c21823e == C21823e.NORMAL) {
                UnfamiliarContactDetailUI.this.qpM.setText(UnfamiliarContactDetailUI.this.getString(C25738R.string.cn5));
                AppMethodBeat.m2505o(127651);
                return;
            }
            if (c21823e == C21823e.OVER_ONE_MIN) {
                UnfamiliarContactDetailUI.this.qpM.setText(UnfamiliarContactDetailUI.this.getString(C25738R.string.eym));
            }
            AppMethodBeat.m2505o(127651);
        }

        /* renamed from: e */
        public final void mo37273e(HashSet hashSet) {
            AppMethodBeat.m2504i(127652);
            String str = "MicroMsg.UnfamiliarContactUI";
            String str2 = "[onResult] size:%s";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(hashSet == null ? 0 : hashSet.size());
            C4990ab.m7417i(str, str2, objArr);
            if (hashSet != null) {
                UnfamiliarContactDetailUI.m33342a(UnfamiliarContactDetailUI.this, hashSet);
            }
            AppMethodBeat.m2505o(127652);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$8 */
    class C218078 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$8$2 */
        class C132402 implements C5279d {
            C132402() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(127643);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14546b(681, UnfamiliarContactDetailUI.this.qpS);
                UnfamiliarContactDetailUI.m33343a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.this.qpR, i);
                UnfamiliarContactDetailUI.m33348b(UnfamiliarContactDetailUI.this, false);
                if (UnfamiliarContactDetailUI.this.qpN != null) {
                    UnfamiliarContactDetailUI.this.qpN.aop.notifyChanged();
                }
                AppMethodBeat.m2505o(127643);
            }
        }

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$8$1 */
        class C218081 implements C36073c {
            C218081() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(127642);
                c44273l.mo70053a(0, UnfamiliarContactDetailUI.this.getString(C25738R.string.d7u), UnfamiliarContactDetailUI.this.getString(C25738R.string.e4_), UnfamiliarContactDetailUI.this.getResources().getDrawable(C1318a.circle_notreceive), false);
                c44273l.mo70053a(1, UnfamiliarContactDetailUI.this.getString(C25738R.string.d7v), UnfamiliarContactDetailUI.this.getString(C25738R.string.e4_), UnfamiliarContactDetailUI.this.getResources().getDrawable(C1318a.circle_notvisible), false);
                AppMethodBeat.m2505o(127642);
            }
        }

        C218078() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127644);
            C36356d c36356d = new C36356d(UnfamiliarContactDetailUI.this, 1, false);
            c36356d.rBl = new C218081();
            c36356d.rBm = new C132402();
            c36356d.cpD();
            AppMethodBeat.m2505o(127644);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$a */
    class C21809a extends C41523a {
        C21809a() {
        }

        /* renamed from: a */
        public final C41531v mo4976a(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(127654);
            C21810c c21810c = new C21810c(LayoutInflater.from(viewGroup.getContext()).inflate(2130970976, viewGroup, false));
            AppMethodBeat.m2505o(127654);
            return c21810c;
        }

        /* renamed from: a */
        public final void mo4977a(C41531v c41531v, int i) {
            AppMethodBeat.m2504i(127655);
            if (c41531v instanceof C21810c) {
                int i2;
                C21810c c21810c = (C21810c) c41531v;
                c21810c.qqh.setTag(Integer.valueOf(i));
                c21810c.apJ.setTag(Integer.valueOf(i));
                C21822b c21822b = (C21822b) UnfamiliarContactDetailUI.this.hUW.get(i);
                C40460b.m69434b((ImageView) c21810c.emP.getContentView(), c21822b.ehM.field_username);
                c21810c.jXx.setText(C44089j.m79293b(UnfamiliarContactDetailUI.this.mController.ylL, c21822b.eoz, c21810c.jXx.getTextSize()));
                c21810c.qqg.setVisibility(c21822b.ehM.mo16701Od() ? 0 : 8);
                ImageView imageView = c21810c.qqf;
                String str = c21822b.ehM.field_username;
                if (C21877n.qFA != null && UnfamiliarContactDetailUI.this.qpU.size() == 0) {
                    UnfamiliarContactDetailUI.this.qpU.addAll(C21877n.qFA.mo37359jT(5));
                }
                if (UnfamiliarContactDetailUI.this.qpU.contains(str)) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                if (UnfamiliarContactDetailUI.this.qpQ.containsKey(Integer.valueOf(i))) {
                    c21810c.qqe.setVisibility(0);
                    c21810c.qqe.setText((CharSequence) UnfamiliarContactDetailUI.this.qpQ.get(Integer.valueOf(i)));
                } else {
                    c21810c.qqe.setVisibility(8);
                }
                if (UnfamiliarContactDetailUI.this.qpW) {
                    c21810c.qqi.setPadding(c21810c.qqi.getPaddingLeft(), c21810c.qqi.getPaddingTop(), 0, c21810c.qqi.getPaddingBottom());
                    if (UnfamiliarContactDetailUI.this.qpR.contains(Integer.valueOf(i))) {
                        c21810c.moo.setChecked(true);
                    } else {
                        c21810c.moo.setChecked(false);
                    }
                    c21810c.qqh.setVisibility(0);
                    AppMethodBeat.m2505o(127655);
                    return;
                }
                c21810c.qqi.setPadding(c21810c.qqi.getPaddingLeft(), c21810c.qqi.getPaddingTop(), (int) UnfamiliarContactDetailUI.this.getResources().getDimension(C25738R.dimen.f9957ld), c21810c.qqi.getPaddingBottom());
                c21810c.qqh.setVisibility(8);
            }
            AppMethodBeat.m2505o(127655);
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(127656);
            int size = UnfamiliarContactDetailUI.this.hUW.size();
            AppMethodBeat.m2505o(127656);
            return size;
        }

        /* renamed from: Cr */
        public final C21822b mo37279Cr(int i) {
            AppMethodBeat.m2504i(127657);
            C21822b c21822b;
            if (UnfamiliarContactDetailUI.this.hUW.size() > i) {
                c21822b = (C21822b) UnfamiliarContactDetailUI.this.hUW.get(i);
                AppMethodBeat.m2505o(127657);
                return c21822b;
            }
            c21822b = new C21822b(new C7616ad());
            AppMethodBeat.m2505o(127657);
            return c21822b;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$c */
    class C21810c extends C41531v {
        View apJ;
        MaskLayout emP;
        TextView jXx;
        CheckBox moo;
        TextView qqe;
        ImageView qqf;
        ImageView qqg;
        LinearLayout qqh;
        LinearLayout qqi;

        public C21810c(View view) {
            super(view);
            AppMethodBeat.m2504i(127660);
            this.apJ = view;
            this.emP = (MaskLayout) view.findViewById(2131828382);
            this.jXx = (TextView) view.findViewById(2131828383);
            this.qqe = (TextView) view.findViewById(2131828381);
            this.qqf = (ImageView) view.findViewById(2131828384);
            this.qqg = (ImageView) view.findViewById(2131828385);
            this.qqh = (LinearLayout) view.findViewById(2131828386);
            this.moo = (CheckBox) view.findViewById(2131820932);
            this.qqi = (LinearLayout) view.findViewById(2131823475);
            this.qqh.setOnClickListener(new OnClickListener(UnfamiliarContactDetailUI.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(127658);
                    int intValue = ((Integer) view.getTag()).intValue();
                    C21810c.this.moo.setChecked(!C21810c.this.moo.isChecked());
                    if (C21810c.this.moo.isChecked()) {
                        UnfamiliarContactDetailUI.this.qpR.add(Integer.valueOf(intValue));
                    } else {
                        UnfamiliarContactDetailUI.this.qpR.remove(Integer.valueOf(intValue));
                    }
                    if (UnfamiliarContactDetailUI.this.qpR.size() == 0) {
                        UnfamiliarContactDetailUI.this.qpK.setEnabled(false);
                        UnfamiliarContactDetailUI.this.qpJ.setEnabled(false);
                        AppMethodBeat.m2505o(127658);
                        return;
                    }
                    UnfamiliarContactDetailUI.this.qpK.setEnabled(true);
                    UnfamiliarContactDetailUI.this.qpJ.setEnabled(true);
                    AppMethodBeat.m2505o(127658);
                }
            });
            view.setOnClickListener(new OnClickListener(UnfamiliarContactDetailUI.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(127659);
                    int intValue = ((Integer) view.getTag()).intValue();
                    C4990ab.m7417i("MicroMsg.UnfamiliarContactUI", "position:%s", Integer.valueOf(intValue), UnfamiliarContactDetailUI.this.qpN.mo37279Cr(intValue).eoz);
                    C21810c.m33371a(C21810c.this, r1, intValue);
                    AppMethodBeat.m2505o(127659);
                }
            });
            AppMethodBeat.m2505o(127660);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        static /* synthetic */ void m33371a(C21810c c21810c, C21822b c21822b, int i) {
            AppMethodBeat.m2504i(127661);
            if (c21822b == null) {
                AppMethodBeat.m2505o(127661);
                return;
            }
            String str;
            if (UnfamiliarContactDetailUI.this.qpW) {
                C13241f.qqy++;
            } else {
                C13241f.qqz++;
            }
            String str2 = c21822b.eoz;
            String str3 = c21822b.ehM.field_username;
            String str4 = c21822b.ehM.field_nickname;
            if (C5046bo.isNullOrNil(str2)) {
                C7575bv RB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15364RB(str3);
                if (!(RB == null || C5046bo.isNullOrNil(RB.field_encryptUsername))) {
                    str = RB.field_conRemark;
                    if (!C5046bo.isNullOrNil(str3)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str3);
                        intent.putExtra("Contact_RemarkName", str);
                        intent.putExtra("Contact_Nick", str4);
                        C24824b.gkE.mo38912c(intent, UnfamiliarContactDetailUI.this);
                        UnfamiliarContactDetailUI.this.qpT = i;
                    }
                    AppMethodBeat.m2505o(127661);
                }
            }
            str = str2;
            if (C5046bo.isNullOrNil(str3)) {
            }
            AppMethodBeat.m2505o(127661);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$10 */
    class C2181310 implements C30374a {
        C2181310() {
        }

        /* renamed from: kp */
        public final void mo17482kp(String str) {
            int i;
            AppMethodBeat.m2504i(127647);
            UnfamiliarContactDetailUI unfamiliarContactDetailUI = UnfamiliarContactDetailUI.this;
            if (unfamiliarContactDetailUI.qpP == null || !unfamiliarContactDetailUI.qpP.containsKey(str)) {
                i = -1;
            } else {
                i = ((Integer) unfamiliarContactDetailUI.qpP.get(str)).intValue();
            }
            C4990ab.m7417i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", str, Integer.valueOf(i));
            if (i != -1) {
                UnfamiliarContactDetailUI.this.qpG.mo61465bY(i);
            }
            AppMethodBeat.m2505o(127647);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$1 */
    class C218141 implements OnMenuItemClickListener {
        C218141() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127632);
            UnfamiliarContactDetailUI.this.qpW = !UnfamiliarContactDetailUI.this.qpW;
            UnfamiliarContactDetailUI.this.qpR.clear();
            UnfamiliarContactDetailUI.m33348b(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.this.qpW);
            if (UnfamiliarContactDetailUI.this.qpW) {
                UnfamiliarContactDetailUI.this.qpJ.setEnabled(false);
                UnfamiliarContactDetailUI.this.qpK.setEnabled(false);
                UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(C25738R.string.eyb));
            } else {
                UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(C25738R.string.eyh));
            }
            if (UnfamiliarContactDetailUI.this.qpN != null) {
                UnfamiliarContactDetailUI.this.qpN.aop.notifyChanged();
            }
            AppMethodBeat.m2505o(127632);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$6 */
    class C218156 implements C21805g {
        C218156() {
        }

        /* renamed from: fh */
        public final void mo37277fh(int i, int i2) {
            AppMethodBeat.m2504i(127638);
            C13241f.qqu += i;
            UnfamiliarContactDetailUI.m33350c(UnfamiliarContactDetailUI.this, false);
            UnfamiliarContactDetailUI.this.qpH.setText(UnfamiliarContactDetailUI.this.getString(C25738R.string.eyf) + "(" + UnfamiliarContactDetailUI.this.hUW.size() + ")");
            if (UnfamiliarContactDetailUI.this.qpN != null) {
                UnfamiliarContactDetailUI.this.qpN.aop.notifyChanged();
            }
            if (i2 < i) {
                C4990ab.m7421w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", Integer.valueOf(i2), Integer.valueOf(i));
                C30379h.m48461b(UnfamiliarContactDetailUI.this.mController.ylL, UnfamiliarContactDetailUI.this.getString(C25738R.string.eyc, new Object[]{Integer.valueOf(i - i2)}), "", true);
            }
            AppMethodBeat.m2505o(127638);
        }

        public final void cjq() {
            AppMethodBeat.m2504i(127639);
            UnfamiliarContactDetailUI.m33350c(UnfamiliarContactDetailUI.this, true);
            AppMethodBeat.m2505o(127639);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$d */
    class C21816d implements C1202f, Runnable {
        int index = 0;
        int oqN = 0;
        C21805g qql;
        Collection<Integer> qqm;
        int qqn = 0;
        LinkedList<String> qqo = new LinkedList();
        LinkedList<C3463b> qqp = new LinkedList();

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$d$1 */
        class C218171 implements Runnable {
            C218171() {
            }

            public final void run() {
                AppMethodBeat.m2504i(127662);
                if (C21816d.this.qql != null) {
                    C21816d.this.qql.mo37277fh(UnfamiliarContactDetailUI.this.qpR.size(), C21816d.this.qqn);
                    UnfamiliarContactDetailUI.this.qpR.clear();
                }
                AppMethodBeat.m2505o(127662);
            }
        }

        C21816d(Collection<Integer> collection, C21805g c21805g) {
            AppMethodBeat.m2504i(127663);
            this.qqm = collection;
            this.qql = c21805g;
            AppMethodBeat.m2505o(127663);
        }

        public final void run() {
            AppMethodBeat.m2504i(127664);
            this.oqN = this.qqm.size();
            for (Integer intValue : this.qqm) {
                int intValue2 = intValue.intValue();
                this.index++;
                int size = this.qqm.size();
                int i = this.index;
                if (UnfamiliarContactDetailUI.this.qpN != null) {
                    C7616ad c7616ad = UnfamiliarContactDetailUI.this.qpN.mo37279Cr(intValue2).ehM;
                    if (C7616ad.aox(c7616ad.field_username)) {
                        ((C37974a) C1720g.m3528K(C37974a.class)).mo60749ve(c7616ad.field_username);
                    } else {
                        C7286vl c7286vl = new C7286vl();
                        c7286vl.wcB = new bts().alV(C5046bo.nullAsNil(c7616ad.field_username));
                        this.qqp.add(new C3465a(4, c7286vl));
                        if (this.qqp.size() % 20 == 0 || i == size) {
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14541a(new C32323b(this.qqp), 0);
                            this.qqp.clear();
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(127664);
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(127665);
            if (c1207m.getType() == 681) {
                if (((C32323b) c1207m).fLr == null || ((C32323b) c1207m).fLr.fLu == null) {
                    C4990ab.m7412e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
                    AppMethodBeat.m2505o(127665);
                    return;
                }
                bhr bhr = ((C32323b) c1207m).fLr.fLu.fLw;
                if (bhr.Ret != 0 || bhr.wKS == null || bhr.wKS.wof == null) {
                    C4990ab.m7413e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", Integer.valueOf(bhr.Ret));
                    AppMethodBeat.m2505o(127665);
                    return;
                }
                List list = ((C32323b) c1207m).fLs;
                C4990ab.m7417i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", Integer.valueOf(list.size()), Integer.valueOf(bhr.wKS.wof.size()));
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= list.size()) {
                        break;
                    }
                    C3463b c3463b = (C3463b) list.get(i4);
                    if (c3463b.getCmdId() != 4) {
                        C4990ab.m7421w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", Integer.valueOf(c3463b.getCmdId()), c3463b.toString());
                    } else {
                        this.oqN--;
                        C7286vl c7286vl = (C7286vl) c3463b.oqT;
                        if (((Integer) r4.get(i4)).intValue() == 0) {
                            this.qqn++;
                            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(C1946aa.m4148a(c7286vl.wcB));
                            if (aoO != null) {
                                aoO.mo16677NC();
                                C1829bf.m3741a(aoO.field_username, null);
                                ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(aoO.field_username, aoO);
                                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX(aoO.field_username);
                                this.qqo.add(aoO.field_username);
                            }
                        } else {
                            C4990ab.m7413e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", r4.get(i4), C1946aa.m4148a(c7286vl.wcB));
                        }
                    }
                    i3 = i4 + 1;
                }
                if (this.oqN <= 0) {
                    Iterator it = this.qqo.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        Iterator it2 = UnfamiliarContactDetailUI.this.hUW.iterator();
                        while (it2.hasNext()) {
                            if (((C21822b) it2.next()).ehM.field_username.equals(str2)) {
                                it2.remove();
                            }
                        }
                    }
                    UnfamiliarContactDetailUI.m33344a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.this.hUW);
                    UnfamiliarContactDetailUI.this.runOnUiThread(new C218171());
                }
            }
            AppMethodBeat.m2505o(127665);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$12 */
    class C2181812 implements AnimationListener {
        C2181812() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(127653);
            UnfamiliarContactDetailUI.this.qpI.setVisibility(8);
            AppMethodBeat.m2505o(127653);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$7 */
    class C218197 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$7$1 */
        class C218031 implements DialogInterface.OnClickListener {
            C218031() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(127640);
                if (UnfamiliarContactDetailUI.this.qpS != null) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14539a(681, UnfamiliarContactDetailUI.this.qpS);
                    Runnable h = UnfamiliarContactDetailUI.this.qpS;
                    h.index = 0;
                    h.oqN = 0;
                    h.qqn = 0;
                    h.qqo.clear();
                    h.qqp.clear();
                    C7305d.xDG.remove(h);
                    if (h.qql != null) {
                        h.qql.cjq();
                    }
                    C7305d.post(h, "delete_contact_task");
                }
                UnfamiliarContactDetailUI.m33348b(UnfamiliarContactDetailUI.this, false);
                AppMethodBeat.m2505o(127640);
            }
        }

        C218197() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127641);
            C30379h.m48454a(UnfamiliarContactDetailUI.this.mController.ylL, true, UnfamiliarContactDetailUI.this.mController.ylL.getString(C25738R.string.eyk), UnfamiliarContactDetailUI.this.mController.ylL.getString(C25738R.string.avj), UnfamiliarContactDetailUI.this.mController.ylL.getString(C25738R.string.f9088p4), UnfamiliarContactDetailUI.this.mController.ylL.getString(C25738R.string.f9076or), new C218031(), null, C25738R.color.f11717ei, 0);
            AppMethodBeat.m2505o(127641);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$9 */
    class C218209 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$9$1 */
        class C218211 implements Runnable {
            C218211() {
            }

            public final void run() {
                AppMethodBeat.m2504i(127645);
                UnfamiliarContactDetailUI.this.qpN.aop.notifyChanged();
                AppMethodBeat.m2505o(127645);
            }
        }

        C218209() {
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.m2504i(127646);
            CheckBox checkBox = (CheckBox) UnfamiliarContactDetailUI.this.qpL.findViewById(2131820932);
            if (checkBox.isChecked()) {
                z = false;
            } else {
                z = true;
            }
            checkBox.setChecked(z);
            if (checkBox.isChecked()) {
                for (int i = 0; i < UnfamiliarContactDetailUI.this.hUW.size(); i++) {
                    UnfamiliarContactDetailUI.this.qpR.add(Integer.valueOf(i));
                }
            } else {
                UnfamiliarContactDetailUI.this.qpR.clear();
            }
            if (UnfamiliarContactDetailUI.this.qpR.size() > 0) {
                UnfamiliarContactDetailUI.this.qpK.setEnabled(true);
                UnfamiliarContactDetailUI.this.qpJ.setEnabled(true);
            } else {
                UnfamiliarContactDetailUI.this.qpK.setEnabled(false);
                UnfamiliarContactDetailUI.this.qpJ.setEnabled(false);
            }
            UnfamiliarContactDetailUI.this.qpG.post(new C218211());
            AppMethodBeat.m2505o(127646);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$b */
    class C21822b {
        C7616ad ehM;
        String eoz;
        String qqd;

        public C21822b(C7616ad c7616ad) {
            this.ehM = c7616ad;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$e */
    public enum C21823e {
        OVER_ONE_MIN,
        NORMAL;

        static {
            AppMethodBeat.m2505o(127668);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public UnfamiliarContactDetailUI() {
        AppMethodBeat.m2504i(127669);
        AppMethodBeat.m2505o(127669);
    }

    /* renamed from: c */
    static /* synthetic */ void m33350c(UnfamiliarContactDetailUI unfamiliarContactDetailUI, boolean z) {
        AppMethodBeat.m2504i(127679);
        unfamiliarContactDetailUI.m33355fE(z);
        AppMethodBeat.m2505o(127679);
    }

    public final int getLayoutId() {
        return 2130970648;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127670);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a(291, (C1202f) this);
        this.qjN = getIntent().getBooleanExtra("half_year_not_chat", false);
        this.qjO = getIntent().getBooleanExtra("half_year_not_response", false);
        this.qjP = getIntent().getBooleanExtra("has_not_same_chatroom", false);
        initView();
        this.qpV = new C39650l(this.qjN, this.qjO, this.qjP, new C2180611());
        C39650l c39650l = this.qpV;
        c39650l.qjX = System.currentTimeMillis();
        c39650l.qjW.mo37272a(C21823e.NORMAL);
        c39650l.eKj.mo10302aa(new C348491());
        AppMethodBeat.m2505o(127670);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127671);
        super.onResume();
        if (-1 != this.qpT) {
            Object obj;
            if (-1 == this.qpT) {
                obj = null;
            } else {
                C21822b c21822b = (C21822b) this.hUW.get(this.qpT);
                C7616ad c7616ad = c21822b.ehM;
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
                if (C7486a.m12942jh(aoO.field_type) || !C7486a.m12942jh(c7616ad.field_type)) {
                    c21822b.ehM = aoO;
                    obj = null;
                } else {
                    this.hUW.remove(this.qpT);
                    obj = 1;
                }
            }
            if (obj != null) {
                C13241f.qqv++;
            }
            this.qpT = -1;
        }
        this.qpU.clear();
        if (this.qpN != null) {
            this.qpN.aop.notifyChanged();
        }
        AppMethodBeat.m2505o(127671);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127672);
        super.onDestroy();
        int i = (this.qjO ? 4 : 0) | ((this.qjP ? 2 : 0) | (this.qjN ? 1 : 0));
        C7060h.pYm.mo8381e(14434, Integer.valueOf(i), Integer.valueOf(C13241f.qqv), Integer.valueOf(C13241f.qqu), Integer.valueOf(C13241f.qqz), Integer.valueOf(C13241f.qqw), Integer.valueOf(C13241f.qqy), Integer.valueOf(C13241f.qqx));
        C4990ab.m7417i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", Integer.valueOf(i), Integer.valueOf(C13241f.qqv), Integer.valueOf(C13241f.qqu), Integer.valueOf(C13241f.qqz), Integer.valueOf(C13241f.qqw), Integer.valueOf(C13241f.qqy), Integer.valueOf(C13241f.qqx));
        C13241f.qqu = 0;
        C13241f.qqv = 0;
        C13241f.qqw = 0;
        C13241f.qqx = 0;
        C13241f.qqy = 0;
        C13241f.qqz = 0;
        C1720g.m3540Rg().mo14546b(291, (C1202f) this);
        C1720g.m3540Rg().mo14546b(681, this.qpS);
        C39650l c39650l = this.qpV;
        C4990ab.m7417i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", Boolean.valueOf(c39650l.qjO), Boolean.valueOf(c39650l.qjN), Boolean.valueOf(c39650l.qjP));
        if (c39650l.qjV != null) {
            C1720g.m3540Rg().mo14546b(292, c39650l.qjV);
        }
        C7305d.xDG.remove(c39650l.mRunnable);
        c39650l.eKj.oAl.quit();
        AppMethodBeat.m2505o(127672);
    }

    public final void initView() {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(127673);
        super.initView();
        setMMTitle((int) C25738R.string.ecg);
        addTextOptionMenu(1, getString(C25738R.string.eyh), new C218141());
        setBackBtn(new C218025());
        findViewById(2131827452).setVisibility(this.qjN ? 0 : 8);
        View findViewById = findViewById(2131827453);
        if (this.qjP) {
            i = 0;
        } else {
            i = 8;
        }
        findViewById.setVisibility(i);
        View findViewById2 = findViewById(2131827454);
        if (!this.qjO) {
            i2 = 8;
        }
        findViewById2.setVisibility(i2);
        this.qpG = (RecyclerView) findViewById(2131827456);
        this.qpI = findViewById(2131823622);
        this.qpH = (TextView) findViewById(2131827451);
        this.qpS = new C21816d(this.qpR, new C218156());
        this.qpJ = findViewById(2131827460);
        this.qpJ.setOnClickListener(new C218197());
        this.qpK = findViewById(2131827459);
        this.qpK.setOnClickListener(new C218078());
        this.qpL = findViewById(2131827458);
        this.qpL.setOnClickListener(new C218209());
        this.qpM = (TextView) findViewById(2131821051);
        this.qpG.setLayoutManager(new LinearLayoutManager());
        this.qpN = new C21809a();
        this.qpG.setAdapter(this.qpN);
        this.qpO = (RealAlphabetScrollBar) findViewById(2131827457);
        this.qpO.setOnScrollBarTouchListener(new C2181310());
        AppMethodBeat.m2505o(127673);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(127674);
        if (i == 4) {
            onBackPressed();
            AppMethodBeat.m2505o(127674);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(127674);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(127675);
        C4990ab.m7416i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + c1207m.getType());
        if (!(i == 0 && i2 == 0)) {
            Toast.makeText(this, getString(C25738R.string.eyj), 1).show();
        }
        if (c1207m.getType() == 291) {
            m33355fE(false);
            this.qpU.clear();
            this.qpN.aop.notifyChanged();
        }
        AppMethodBeat.m2505o(127675);
    }

    /* renamed from: da */
    private void m33352da(List<C21822b> list) {
        AppMethodBeat.m2504i(127676);
        this.qpP.clear();
        this.qpQ.clear();
        int i = 0;
        String str = null;
        Iterator it = list.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                C21822b c21822b = (C21822b) it.next();
                if (emJ.equalsIgnoreCase(c21822b.qqd)) {
                    c21822b.qqd = "#";
                }
                str = c21822b.qqd;
                if (!str.equalsIgnoreCase(str2)) {
                    this.qpP.put(str.toUpperCase(), Integer.valueOf(i));
                    this.qpQ.put(Integer.valueOf(i), str.toUpperCase());
                }
                i++;
            } else {
                AppMethodBeat.m2505o(127676);
                return;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(127683);
        AppMethodBeat.m2505o(127683);
    }

    /* renamed from: fE */
    private void m33355fE(boolean z) {
        AppMethodBeat.m2504i(127677);
        C4990ab.m7417i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.ejZ = C44275p.m79966b(this, getString(C25738R.string.eye), true, null);
            AppMethodBeat.m2505o(127677);
            return;
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
        AppMethodBeat.m2505o(127677);
    }

    /* renamed from: b */
    static /* synthetic */ void m33348b(UnfamiliarContactDetailUI unfamiliarContactDetailUI, boolean z) {
        AppMethodBeat.m2504i(127678);
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, C25738R.anim.f8375cg);
            loadAnimation.setAnimationListener(new C217982());
            unfamiliarContactDetailUI.qpI.startAnimation(loadAnimation);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, C25738R.anim.f8373ce);
            loadAnimation.setAnimationListener(new C2181812());
            unfamiliarContactDetailUI.qpI.startAnimation(loadAnimation);
        }
        unfamiliarContactDetailUI.qpW = z;
        if (unfamiliarContactDetailUI.qpW) {
            unfamiliarContactDetailUI.updateOptionMenuText(1, unfamiliarContactDetailUI.getString(C25738R.string.eyb));
            AppMethodBeat.m2505o(127678);
            return;
        }
        unfamiliarContactDetailUI.updateOptionMenuText(1, unfamiliarContactDetailUI.getString(C25738R.string.eyh));
        ((CheckBox) unfamiliarContactDetailUI.qpL.findViewById(2131820932)).setChecked(false);
        AppMethodBeat.m2505o(127678);
    }

    /* renamed from: a */
    static /* synthetic */ void m33343a(UnfamiliarContactDetailUI unfamiliarContactDetailUI, final HashSet hashSet, final int i) {
        AppMethodBeat.m2504i(127680);
        unfamiliarContactDetailUI.m33355fE(true);
        if (i == 0) {
            C13241f.qqx += hashSet.size();
        } else if (i == 1) {
            C13241f.qqw += hashSet.size();
        }
        C7305d.post(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI$4$1 */
            class C218011 implements Runnable {
                C218011() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(127635);
                    UnfamiliarContactDetailUI.this.qpN.aop.notifyChanged();
                    UnfamiliarContactDetailUI.m33350c(UnfamiliarContactDetailUI.this, false);
                    AppMethodBeat.m2505o(127635);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(127636);
                LinkedList linkedList = new LinkedList();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    C21822b Cr = UnfamiliarContactDetailUI.this.qpN.mo37279Cr(((Integer) it.next()).intValue());
                    C4990ab.m7417i("MicroMsg.UnfamiliarContactUI", "username:%s index:%s", Cr.ehM.field_username, Integer.valueOf(i));
                    C18384ro c18384ro;
                    if (i == 0) {
                        c18384ro = new C18384ro();
                        c18384ro.cNw.cNy = false;
                        c18384ro.cNw.cNx = true;
                        c18384ro.cNw.username = Cr.ehM.field_username;
                        C4879a.xxA.mo10055m(c18384ro);
                        linkedList.add(Cr.ehM.field_username);
                    } else if (i == 1) {
                        Cr.ehM.mo16691NQ();
                        c18384ro = new C18384ro();
                        c18384ro.cNw.cNy = true;
                        c18384ro.cNw.cNx = false;
                        c18384ro.cNw.username = Cr.ehM.field_username;
                        C4879a.xxA.mo10055m(c18384ro);
                        C1855t.m3895k(Cr.ehM);
                    }
                }
                if (linkedList.size() > 0) {
                    C26197mo c26197mo = new C26197mo();
                    c26197mo.cIr.list = linkedList;
                    c26197mo.cIr.czE = 1;
                    c26197mo.cIr.cIs = 5;
                    C4879a.xxA.mo10055m(c26197mo);
                    AppMethodBeat.m2505o(127636);
                    return;
                }
                UnfamiliarContactDetailUI.this.runOnUiThread(new C218011());
                AppMethodBeat.m2505o(127636);
            }
        }, "handleSnsSetting");
        AppMethodBeat.m2505o(127680);
    }
}
