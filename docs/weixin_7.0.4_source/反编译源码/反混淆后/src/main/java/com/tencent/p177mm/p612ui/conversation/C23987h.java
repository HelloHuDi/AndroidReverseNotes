package com.tencent.p177mm.p612ui.conversation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.booter.notification.p841a.C37622h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p181af.C32222n;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p203bg.C32337g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p213cd.p214a.C1351a;
import com.tencent.p177mm.p213cd.p214a.C1354d;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p230g.p231a.C6458aa;
import com.tencent.p177mm.p230g.p711c.C6563at;
import com.tencent.p177mm.p612ui.C40862f;
import com.tencent.p177mm.p612ui.C40862f.C15880b;
import com.tencent.p177mm.p612ui.C40862f.C30702a;
import com.tencent.p177mm.p612ui.base.MMSlideDelView;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23597d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.base.NoMeasuredTextView;
import com.tencent.p177mm.p612ui.base.NoMeasuredTextView.C40667c;
import com.tencent.p177mm.p612ui.p613a.C5216a.C5215a;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.p761o.C7487a;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C20772b;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C43298a;
import com.tencent.p177mm.plugin.multitalk.model.C39419a;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p1079f.C46486g;
import com.tencent.p177mm.pluginsdk.p597ui.C14943d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.ui.conversation.h */
public final class C23987h extends C40862f<String, C7617ak> implements C4937b {
    protected List<String> elZ = null;
    private boolean gxV = false;
    protected C23600g jJO;
    protected C15521c jJP;
    protected C23597d jJR = MMSlideDelView.getItemStatusCallBack();
    private ListView mListView;
    boolean nNp = false;
    boolean riR = false;
    private float yDU = -1.0f;
    private float yDV = -1.0f;
    private float yDW = -1.0f;
    private ColorStateList[] yDX = new ColorStateList[5];
    HashMap<String, C23985d> yDY;
    public boolean yOf = false;
    C4931a yql = new C239796();
    private boolean zrm = true;
    C14943d zro;
    private boolean zrq = false;
    C4884c zrt = null;
    public String zrv = "";
    private final int zrx;
    private final int zry;
    private HashSet<String> ztA;
    private boolean ztB = false;
    HashMap<String, Integer> ztC = new HashMap();
    private HashMap<String, Integer> ztD = new HashMap();
    boolean ztE = false;
    HashSet<String> ztF;
    boolean ztG = false;
    private boolean ztH = false;
    private C40667c ztI = new C158691();
    public String ztJ = "";
    private String ztK;
    private Drawable ztL;
    ValueAnimator ztM;
    final C23986e ztN = new C23986e();
    private float ztO = -1.0f;
    private C23983a ztP;
    private long ztQ = 0;
    boolean ztR = false;
    private boolean ztx = false;
    private C42062sz zty = null;
    C23988b ztz = null;

    /* renamed from: com.tencent.mm.ui.conversation.h$1 */
    class C158691 implements C40667c {
        C158691() {
        }

        /* renamed from: a */
        public final CharSequence mo28106a(NoMeasuredTextView noMeasuredTextView, CharSequence charSequence, String str, int i, int i2) {
            Object str2;
            Object obj;
            AppMethodBeat.m2504i(34353);
            float textSize = noMeasuredTextView.getPaint().getTextSize();
            int fromDPToPix = C1338a.fromDPToPix(C23987h.this.context, i2);
            noMeasuredTextView.getPaint().setTextSize((float) fromDPToPix);
            float measureText = noMeasuredTextView.getPaint().measureText(" ".concat(String.valueOf(str2)));
            noMeasuredTextView.getPaint().setTextSize(textSize);
            int measuredWidth = (noMeasuredTextView.getMeasuredWidth() - noMeasuredTextView.getCompoundPaddingRight()) - noMeasuredTextView.getCompoundPaddingLeft();
            if (((double) measureText) >= ((double) measuredWidth) * 0.6d) {
                CharSequence ellipsize = TextUtils.ellipsize(charSequence, noMeasuredTextView.getPaint(), (float) (((double) measuredWidth) * 0.4d), TruncateAt.END);
                float measureText2 = noMeasuredTextView.getPaint().measureText(ellipsize.toString());
                noMeasuredTextView.getPaint().setTextSize((float) fromDPToPix);
                str2 = TextUtils.ellipsize(str2, noMeasuredTextView.getPaint(), (((float) measuredWidth) - measureText2) - 20.0f, TruncateAt.END);
                noMeasuredTextView.getPaint().setTextSize(textSize);
                obj = ellipsize;
            } else {
                CharSequence obj2 = TextUtils.ellipsize(charSequence, noMeasuredTextView.getPaint(), ((float) measuredWidth) - measureText, TruncateAt.END);
            }
            SpannableString b = C44089j.m79292b(C23987h.this.context, obj2 + " " + str2);
            ColorStateList h = C1338a.m2870h(C23987h.this.context, i);
            b.setSpan(new TextAppearanceSpan(null, 0, fromDPToPix, h, h), obj2.length() + 1, (obj2.length() + 1) + str2.length(), 33);
            AppMethodBeat.m2505o(34353);
            return b;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$6 */
    class C239796 implements C4931a {
        C239796() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(34359);
            C23987h.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(34359);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$7 */
    class C239807 implements OnClickListener {
        C239807() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34360);
            if (C23987h.this.mListView == null || C23987h.this.mListView.getOnItemClickListener() == null) {
                C4990ab.m7412e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
                AppMethodBeat.m2505o(34360);
            } else if (view.getTag() == null) {
                C4990ab.m7412e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
                AppMethodBeat.m2505o(34360);
            } else if (C23987h.this.yOf) {
                C23991f c23991f = (C23991f) view.getTag();
                int headerViewsCount = c23991f.position + C23987h.this.mListView.getHeaderViewsCount();
                C23987h.this.mListView.getOnItemClickListener().onItemClick(C23987h.this.mListView, view, headerViewsCount, C23987h.this.getItemId(c23991f.position));
                AppMethodBeat.m2505o(34360);
            } else {
                C4990ab.m7420w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
                AppMethodBeat.m2505o(34360);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$8 */
    class C239818 implements OnLongClickListener {
        C239818() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(34361);
            if (C23987h.this.mListView == null || C23987h.this.mListView.getOnItemLongClickListener() == null) {
                C4990ab.m7412e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
                AppMethodBeat.m2505o(34361);
                return false;
            } else if (view.getTag() == null) {
                C4990ab.m7412e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
                AppMethodBeat.m2505o(34361);
                return false;
            } else if (C23987h.this.yOf) {
                C23991f c23991f = (C23991f) view.getTag();
                int headerViewsCount = c23991f.position + C23987h.this.mListView.getHeaderViewsCount();
                boolean onItemLongClick = C23987h.this.mListView.getOnItemLongClickListener().onItemLongClick(C23987h.this.mListView, view, headerViewsCount, C23987h.this.getItemId(c23991f.position));
                AppMethodBeat.m2505o(34361);
                return onItemLongClick;
            } else {
                C4990ab.m7420w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
                AppMethodBeat.m2505o(34361);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$9 */
    class C239829 implements OnTouchListener {
        C239829() {
        }

        @TargetApi(21)
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(34362);
            view.findViewById(2131823147).getBackground().setHotspot(motionEvent.getX(), motionEvent.getY());
            AppMethodBeat.m2505o(34362);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$a */
    class C23983a {
        public String bCu;
        public String content;
        public int zrF;
        public String zrG;

        private C23983a() {
        }

        /* synthetic */ C23983a(C23987h c23987h, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$c */
    class C23984c {
        public View jJW = null;
        public TextView jJX = null;
        String username = "";
        public View ywu = null;
        boolean ztV = false;
        boolean ztW = false;
        boolean ztX = false;
        boolean ztY = false;
        boolean ztZ = false;
        public ImageView zua = null;
        public TextView zub = null;
        public View zuc = null;

        C23984c() {
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$d */
    class C23985d {
        public String eoz;
        public int klY;
        public boolean mgQ;
        public CharSequence nickName;
        public boolean yDZ;
        public CharSequence zrH;
        public CharSequence zrI;
        public int zrJ;
        public int zrK;
        public int zrL;
        public boolean zrM;
        public boolean zrN;
        public boolean zrP;
        public boolean zrQ;
        public boolean zrR;
        public boolean zrS;

        private C23985d() {
        }

        /* synthetic */ C23985d(C23987h c23987h, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$e */
    class C23986e {
        private C7616ad ehM;
        private boolean initialized;
        private String talker;
        private Integer zrU;

        public C23986e() {
            this.initialized = false;
            this.talker = null;
            this.initialized = false;
            this.ehM = null;
            this.zrU = null;
        }

        /* renamed from: ju */
        public final void mo39784ju(String str) {
            AppMethodBeat.m2504i(34363);
            this.talker = str;
            this.ehM = null;
            this.zrU = null;
            this.initialized = false;
            if (!C42252ah.isNullOrNil(str)) {
                this.initialized = true;
            }
            AppMethodBeat.m2505o(34363);
        }

        public final C7616ad dIK() {
            AppMethodBeat.m2504i(34364);
            if (this.initialized && this.ehM == null && C9638aw.m17179RK()) {
                C9638aw.m17190ZK();
                this.ehM = C18628c.m29078XM().aoO(this.talker);
            }
            C7616ad c7616ad = this.ehM;
            AppMethodBeat.m2505o(34364);
            return c7616ad;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$b */
    public interface C23988b {
        void dIJ();
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$3 */
    class C239893 implements Runnable {
        C239893() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34356);
            C23987h.m36971e(C23987h.this);
            AppMethodBeat.m2505o(34356);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$f */
    public static class C23991f {
        public ImageView ejo;
        public TextView jJV;
        public int position;
        public String username;
        public boolean yDZ;
        public NoMeasuredTextView yEc;
        public NoMeasuredTextView yEd;
        public NoMeasuredTextView yEe;
        public ImageView yEf;
        public ImageView yEg;
        public View yEh;
        public ImageView zrW;
        public ImageView zud;
        public ImageView zue;
        public C23984c zuf;
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$2 */
    class C239922 extends C4884c<C6458aa> {
        C239922() {
            AppMethodBeat.m2504i(34354);
            this.xxI = C6458aa.class.getName().hashCode();
            AppMethodBeat.m2505o(34354);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34355);
            C23987h.this.zrq = true;
            AppMethodBeat.m2505o(34355);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.h$4 */
    class C239934 implements AnimatorUpdateListener {
        C239934() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(34357);
            C23987h.this.ztL.setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
            AppMethodBeat.m2505o(34357);
        }
    }

    public C23987h(Context context, ListView listView, C30702a c30702a) {
        super(context, (short) 0);
        AppMethodBeat.m2504i(34365);
        this.mListView = listView;
        this.TAG = "MicroMsg.ConversationWithCacheAdapter";
        super.mo64391a(c30702a);
        this.yDX[0] = C1338a.m2870h(context, (int) C25738R.color.f12092s0);
        this.yDX[1] = C1338a.m2870h(context, (int) C25738R.color.a7y);
        this.yDX[3] = C1338a.m2870h(context, (int) C25738R.color.f12212w4);
        this.yDX[2] = C1338a.m2870h(context, (int) C25738R.color.a7v);
        this.yDX[2] = C1338a.m2870h(context, (int) C25738R.color.a7v);
        this.yDX[4] = C1338a.m2870h(context, (int) C25738R.color.f12120t3);
        if (C1338a.m2866gb(context)) {
            this.zry = context.getResources().getDimensionPixelSize(C25738R.dimen.f9772f8);
            this.zrx = context.getResources().getDimensionPixelSize(C25738R.dimen.f9773f9);
        } else if (C1338a.m2865ga(context)) {
            this.zry = context.getResources().getDimensionPixelSize(C25738R.dimen.f9771f7);
            this.zrx = context.getResources().getDimensionPixelSize(C25738R.dimen.f9773f9);
        } else {
            this.zry = context.getResources().getDimensionPixelSize(C25738R.dimen.f9770f6);
            this.zrx = context.getResources().getDimensionPixelSize(C25738R.dimen.f9774f_);
        }
        this.yDY = new HashMap();
        this.ztA = new HashSet();
        this.ztF = new HashSet();
        this.yDU = context.getResources().getDimension(C25738R.dimen.f9980m5);
        this.yDV = context.getResources().getDimension(C25738R.dimen.f9936kr);
        this.yDW = context.getResources().getDimension(C25738R.dimen.f10018nk);
        this.elZ = new ArrayList();
        this.elZ.add("qmessage");
        AppMethodBeat.m2505o(34365);
    }

    public final void setPerformItemClickListener(C23600g c23600g) {
        this.jJO = c23600g;
    }

    public final void setGetViewPositionCallback(C15521c c15521c) {
        this.jJP = c15521c;
    }

    /* renamed from: Pu */
    private static int m36960Pu(int i) {
        switch (i) {
            case 1:
            case 8:
                return C1318a.msg_state_sending;
            case 5:
                return C1318a.msg_state_failed;
            default:
                return -1;
        }
    }

    public final void dHz() {
        boolean z = true;
        AppMethodBeat.m2504i(34367);
        if (this.elZ == null) {
            this.elZ = new ArrayList();
        }
        this.elZ.clear();
        boolean z2 = (C1853r.m3822YD() & 32768) == 0;
        boolean YQ = C1853r.m3835YQ();
        if (!(z2 && YQ)) {
            z = false;
        }
        if (z != this.ztH) {
            if (z) {
                C9638aw.m17190ZK();
                mo10136a(5, (C7298n) C18628c.m29083XR(), (Object) "floatbottle");
            } else {
                C9638aw.m17190ZK();
                mo10136a(2, (C7298n) C18628c.m29083XR(), (Object) "floatbottle");
            }
            this.ztH = z;
        }
        if (this.ztH) {
            this.elZ.add("floatbottle");
        }
        this.elZ.add("qmessage");
        AppMethodBeat.m2505o(34367);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(34368);
        C4990ab.m7410d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.yOf);
        if (this.yOf) {
            this.yOf = false;
            super.pause();
            if (this.jJR != null) {
                this.jJR.bIp();
            }
            AppMethodBeat.m2505o(34368);
            return;
        }
        AppMethodBeat.m2505o(34368);
    }

    private void dIq() {
        AppMethodBeat.m2504i(34369);
        if (this.yDY == null) {
            AppMethodBeat.m2505o(34369);
            return;
        }
        for (Entry value : this.yDY.entrySet()) {
            ((C23985d) value.getValue()).zrH = null;
        }
        AppMethodBeat.m2505o(34369);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(34370);
        C4990ab.m7410d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.yOf);
        if (this.yOf) {
            AppMethodBeat.m2505o(34370);
            return;
        }
        boolean z;
        this.yOf = true;
        dHz();
        dII();
        C4990ab.m7416i(this.TAG, "newcursor resume syncNow ");
        this.ygr = true;
        mo64399pA(true);
        Time time = new Time();
        time.setToNow();
        String charSequence = C46486g.m87705a("MM/dd", time).toString();
        String dor = C4988aa.dor();
        if (this.zrv.equals(charSequence) && this.ztJ.equals(dor)) {
            z = false;
        } else {
            z = true;
        }
        this.zrv = charSequence;
        this.ztJ = dor;
        if (z) {
            dIq();
        }
        if (this.zrq && this.ztz != null) {
            this.ztz.dIJ();
            this.zrq = false;
            super.mo28048j(null, 1);
        }
        this.zty = new C42062sz();
        this.zty.cPf.cPh = true;
        C4879a.xxA.mo10055m(this.zty);
        AppMethodBeat.m2505o(34370);
    }

    private boolean dIG() {
        return this.ztK != null;
    }

    /* renamed from: a */
    public final void mo39787a(View view, int i, String str) {
        AppMethodBeat.m2504i(34371);
        if (view == null) {
            AppMethodBeat.m2505o(34371);
        } else if (this.ztK != null) {
            C4990ab.m7421w("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] has click! position:%s username:%s", Integer.valueOf(i), str);
            AppMethodBeat.m2505o(34371);
        } else {
            C4990ab.m7417i("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] position:%s username:%s", Integer.valueOf(i), str);
            this.ztK = str;
            C23991f c23991f = (C23991f) view.getTag();
            Resources resources = view.getContext().getResources();
            int i2 = (c23991f == null || !c23991f.yDZ) ? C25738R.color.f11904l6 : C25738R.color.f11883ki;
            this.ztL = new ColorDrawable(resources.getColor(i2));
            view.setBackground(this.ztL);
            AppMethodBeat.m2505o(34371);
        }
    }

    /* renamed from: Pv */
    public final void mo39785Pv(int i) {
        AppMethodBeat.m2504i(34372);
        if (dIG()) {
            C5004al.m7442n(new C239893(), (long) i);
            AppMethodBeat.m2505o(34372);
            return;
        }
        C4990ab.m7416i("MicroMsg.ConversationWithCacheAdapter", "[requestDismissClickStatus] pass!");
        AppMethodBeat.m2505o(34372);
    }

    public final void dIH() {
        AppMethodBeat.m2504i(34373);
        super.mo28048j(null, 1);
        AppMethodBeat.m2505o(34373);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C23991f c23991f;
        Object obj;
        AppMethodBeat.m2504i(34374);
        this.ztP = new C23983a(this, (byte) 0);
        C7617ak c7617ak = (C7617ak) getItem(i);
        String str = c7617ak.field_username;
        this.ztN.mo39784ju(str);
        if (!this.ztC.containsKey(str)) {
            this.ztC.put(str, Integer.valueOf(i));
        } else if (i != ((Integer) this.ztC.get(str)).intValue()) {
            HashMap hashMap;
            int i2;
            SparseArray[] dwA = dwA();
            if (this.ygs == null) {
                hashMap = null;
            } else {
                hashMap = this.ygs.ycB.dvq();
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (SparseArray sparseArray : dwA) {
                int i3 = 0;
                while (true) {
                    i2 = i3;
                    if (i2 >= sparseArray.size() || i2 >= 50) {
                    } else {
                        stringBuffer.append("[");
                        stringBuffer.append(i2);
                        stringBuffer.append(",");
                        stringBuffer.append(sparseArray.keyAt(i2));
                        stringBuffer.append(",");
                        stringBuffer.append((String) sparseArray.valueAt(i2));
                        stringBuffer.append("]");
                        i3 = i2 + 1;
                    }
                }
            }
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
            if (hashMap != null) {
                i2 = 0;
                for (Entry entry : hashMap.entrySet()) {
                    if (i2 >= 50) {
                        break;
                    }
                    i2++;
                    stringBuffer.append("[");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append(",");
                    if (entry.getValue() != null) {
                        stringBuffer.append(((C7617ak) entry.getValue()).field_username);
                    }
                    stringBuffer.append("]");
                }
                stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            String str2 = "MicroMsg.ConversationWithCacheAdapter";
            String str3 = "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d";
            Object[] objArr = new Object[5];
            objArr[0] = stringBuffer.toString();
            objArr[1] = str;
            objArr[2] = Integer.valueOf(i);
            objArr[3] = this.ztC.toString();
            objArr[4] = Integer.valueOf(hashMap != null ? hashMap.size() : 0);
            C4990ab.m7417i(str2, str3, objArr);
            if (!this.ztB) {
                C3163e.m5423vV(20);
                this.ztB = true;
            }
            if (System.currentTimeMillis() - this.ztQ > 3600000) {
                super.mo28048j(null, 1);
                this.ztQ = System.currentTimeMillis();
            }
        }
        if (view == null) {
            View a;
            c23991f = new C23991f();
            if (C1338a.m2865ga(this.context)) {
                a = C1742b.m3596SM().mo5274a((Activity) this.context, "R.layout.conversation_item_with_cache_large", 2130969244);
            } else if (C1338a.m2867gc(this.context)) {
                a = C1742b.m3596SM().mo5274a((Activity) this.context, "R.layout.conversation_item_with_cache_small", 2130969245);
            } else {
                a = C1742b.m3596SM().mo5274a((Activity) this.context, "R.layout.conversation_item_with_cache", 2130969243);
            }
            a.setTag(2131820679, new int[2]);
            a.setOnClickListener(new C239807());
            a.setOnLongClickListener(new C239818());
            c23991f.ejo = (ImageView) a.findViewById(2131821183);
            C40460b.m69434b(c23991f.ejo, str);
            C40459a c40459a = (C40459a) c23991f.ejo.getDrawable();
            if (this.zro != null) {
                this.zro.mo27290a(c40459a);
            }
            c23991f.yEc = (NoMeasuredTextView) a.findViewById(2131823149);
            c23991f.yEc.setLayoutCallback(this.ztI);
            c23991f.yEd = (NoMeasuredTextView) a.findViewById(2131823150);
            c23991f.zud = (ImageView) a.findViewById(2131823157);
            c23991f.yEe = (NoMeasuredTextView) a.findViewById(2131823151);
            c23991f.jJV = (TextView) a.findViewById(2131821067);
            c23991f.yEf = (ImageView) a.findViewById(2131823153);
            c23991f.yEh = a.findViewById(2131823148);
            c23991f.yEg = (ImageView) a.findViewById(2131823154);
            c23991f.zrW = (ImageView) a.findViewById(2131823155);
            c23991f.zue = (ImageView) a.findViewById(2131823152);
            c23991f.jJV.setBackgroundResource(C44385r.m80243ik(this.context));
            c23991f.zuf = new C23984c();
            a.setTag(c23991f);
            c23991f.yEe.setTextSize(0, (float) C1338a.m2856al(this.context, C25738R.dimen.f10016ni));
            c23991f.yEd.setTextSize(0, (float) C1338a.m2856al(this.context, C25738R.dimen.f10018nk));
            c23991f.yEc.setTextSize(0, (float) C1338a.m2856al(this.context, C25738R.dimen.f9980m5));
            this.ztO = c23991f.yEc.getTextSize();
            c23991f.yEe.setTextColor(this.yDX[0]);
            c23991f.yEd.setTextColor(this.yDX[4]);
            c23991f.yEc.setTextColor(this.yDX[3]);
            c23991f.yEe.setShouldEllipsize(true);
            c23991f.yEd.setShouldEllipsize(false);
            c23991f.yEc.setShouldEllipsize(true);
            c23991f.yEd.setGravity(5);
            obj = a;
        } else {
            c23991f = (C23991f) view.getTag();
            View obj2 = view;
        }
        C23985d i4 = mo39794i(c7617ak);
        c23991f.position = i;
        c23991f.username = str;
        boolean z = i4.yDZ && c7617ak.field_conversationTime != -1;
        c23991f.yDZ = z;
        if (i4.zrI == null) {
            i4.zrI = m36967b(c7617ak, (int) c23991f.yEe.getTextSize(), i4.zrP);
        }
        if (i4.zrH == null) {
            i4.zrH = m36974h(c7617ak);
        }
        if (i4.zrP) {
            c23991f.yEe.setTextColor(this.yDX[0]);
        } else {
            c23991f.yEe.setTextColor(this.yDX[i4.klY]);
        }
        C37622h.m63534iv(c23991f.yEe.getWidth());
        C37622h.m63535iw((int) c23991f.yEe.getTextSize());
        C37622h.m63525a(c23991f.yEe.getPaint());
        if (C1855t.m3903mP(str)) {
            c23991f.yEc.setCompoundRightDrawablesWithIntrinsicBounds((int) C1318a.open_im_main_logo);
            c23991f.yEc.setDrawRightDrawable(true);
        } else if (c23991f.yEc.yzV) {
            c23991f.yEc.setDrawRightDrawable(false);
        }
        int i5 = i4.zrJ;
        if (i5 != -1) {
            c23991f.yEe.setCompoundLeftDrawablesWithIntrinsicBounds(i5);
            c23991f.yEe.setDrawLeftDrawable(true);
            C4990ab.m7417i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", str, Integer.valueOf(i4.zrJ));
        } else {
            c23991f.yEe.setDrawLeftDrawable(false);
            c23991f.yEe.invalidate();
        }
        if (C7616ad.aox(c7617ak.field_username)) {
            this.ztN.mo39784ju(c7617ak.field_username);
            C7616ad dIK = this.ztN.dIK();
            String str4 = "";
            if (dIK != null) {
                str4 = ((C32873b) C1720g.m3528K(C32873b.class)).mo44306ba(dIK.field_openImAppid, dIK.field_descWordingId);
            }
            if (C42252ah.isNullOrNil(str4)) {
                c23991f.yEc.mo69968au(null, 0, 0);
            } else {
                if ("3552365301".equals(dIK.field_openImAppid)) {
                    str4 = "@".concat(String.valueOf(str4));
                }
                c23991f.yEc.mo69968au(str4, C25738R.color.f12111st, 14);
            }
        } else {
            C1855t.m3903mP(c7617ak.field_username);
            c23991f.yEc.mo69968au(null, 0, 0);
        }
        c23991f.yEc.setText(i4.nickName);
        LayoutParams layoutParams = c23991f.yEd.getLayoutParams();
        if (i4.zrH.length() >= 9) {
            if (layoutParams.width != this.zry) {
                layoutParams.width = this.zry;
                c23991f.yEd.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.zrx) {
            layoutParams.width = this.zrx;
            c23991f.yEd.setLayoutParams(layoutParams);
        }
        c23991f.yEd.setText(i4.zrH);
        c23991f.yEe.setText(i4.zrI);
        c23991f.zud.setVisibility(8);
        c23991f.yEf.setVisibility(8);
        if (((C20772b) C1720g.m3528K(C20772b.class)).mo36068Mp(str)) {
            c23991f.yEf.setVisibility(0);
            c23991f.yEf.setImageResource(C1318a.chat_force_notify_icon);
        } else {
            c23991f.yEf.setImageResource(C1318a.chat_mute_notify_title_icon);
            if (i4.mgQ) {
                if (i4.zrR) {
                    c23991f.yEf.setVisibility(0);
                }
            } else if (i4.zrN) {
                c23991f.yEf.setVisibility(0);
            }
        }
        C40460b.m69434b(c23991f.ejo, str);
        if (this.zrm) {
            if (c7617ak == null || c23991f == null || i4 == null) {
                C4990ab.m7420w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                c23991f.jJV.setVisibility(4);
                c23991f.yEh.setVisibility(4);
                ColorStateList colorStateList = (!C1855t.m3908mU(c7617ak.field_username) && i4.zrQ && (i4.zrL == 1 || i4.zrL == 2 || i4.zrL == 3)) ? this.yDX[2] : this.yDX[3];
                c23991f.yEc.setTextColor(colorStateList);
                if (!i4.zrQ || i4.zrK == 0) {
                    C4990ab.m7420w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
                } else {
                    i5 = C23987h.m36961a(c7617ak, i4);
                    if (i5 == 1) {
                        c23991f.yEh.setVisibility(0);
                    } else if (i5 == 2) {
                        i5 = c7617ak.field_unReadCount;
                        if (i5 > 99) {
                            c23991f.jJV.setText("");
                            c23991f.jJV.setBackgroundResource(C1318a.badge_count_more);
                            c23991f.jJV.setVisibility(0);
                        } else if (i5 > 0) {
                            c23991f.jJV.setText(c7617ak.field_unReadCount);
                            c23991f.jJV.setVisibility(0);
                            c23991f.jJV.setBackgroundResource(C44385r.m80243ik(this.context));
                        }
                        this.ztP.zrF = i5;
                    }
                }
            }
        }
        if (!i4.zrM && i4.yDZ && C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo15821f(c7617ak);
        }
        if (this.ztK != null && this.ztK.equals(str)) {
            C4990ab.m7417i("MicroMsg.ConversationWithCacheAdapter", "convertView:%s, clickUsername:%s", Integer.valueOf(obj2.hashCode()), this.ztK);
            obj2.findViewById(2131823147).setBackground(this.ztL);
        } else if (!i4.yDZ || c7617ak.field_conversationTime == -1) {
            obj2.findViewById(2131823147).setBackgroundResource(C25738R.drawable.f6641kp);
        } else {
            obj2.findViewById(2131823147).setBackgroundResource(C25738R.drawable.f6802r9);
        }
        if (VERSION.SDK_INT >= 21) {
            obj2.findViewById(2131823147).setOnTouchListener(new C239829());
        }
        C25985d.dlL();
        if (!(0 == C43298a.m77176a(c7617ak, 7, 0) || c7617ak.field_username.equals(this.zty.cPg.cPj))) {
            c7617ak.mo14743eE(C43298a.m77176a(c7617ak, 6, c7617ak.field_conversationTime));
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo15767a(c7617ak, c7617ak.field_username);
        }
        if (C32337g.fUs == null || !C32337g.fUs.mo4625tN(c7617ak.field_username)) {
            c23991f.yEg.setVisibility(8);
        } else {
            c23991f.yEg.setVisibility(0);
            if (c7617ak.field_username.equals(this.zty.cPg.cPj)) {
                c23991f.yEg.setImageResource(C1318a.talk_room_mic_speaking);
            } else {
                c23991f.yEg.setImageResource(C1318a.talk_room_mic_idle);
            }
        }
        if (C25859d.fUu == null || !C25859d.fUu.mo20565tQ(c7617ak.field_username)) {
            c23991f.zrW.setVisibility(8);
        } else {
            c23991f.zrW.setVisibility(0);
        }
        if (C1855t.m3896kH(c7617ak.field_username) && C1720g.m3528K(C39419a.class) != null && ((C39419a) C1720g.m3528K(C39419a.class)).mo55112RX(c7617ak.field_username)) {
            if (((C39419a) C1720g.m3528K(C39419a.class)).bRc() && ((C39419a) C1720g.m3528K(C39419a.class)).mo55133ff(c7617ak.field_username, C1853r.m3846Yz())) {
                c23991f.zue.setImageResource(C1318a.chatlist_multitalk_highlight_icon);
            } else {
                c23991f.zue.setImageResource(C1318a.chatlist_multitalk_icon);
            }
            c23991f.zue.setVisibility(0);
        } else {
            c23991f.zue.setVisibility(8);
        }
        this.ztP.content = String.valueOf(i4.zrI);
        this.ztP.bCu = i4.eoz;
        this.ztP.zrG = String.valueOf(i4.zrH);
        C23983a c23983a = this.ztP;
        C5215a.yqY.mo10714a(obj2, c23983a.bCu, c23983a.zrF, c23983a.zrG, c23983a.content);
        obj2.setAlpha(1.0f);
        AppMethodBeat.m2505o(34374);
        return obj2;
    }

    /* renamed from: a */
    private void m36964a(C23985d c23985d, C7616ad c7616ad) {
        AppMethodBeat.m2504i(34376);
        if (c23985d.mgQ && c23985d.eoz == null) {
            c23985d.nickName = this.context.getString(C25738R.string.ao1);
            AppMethodBeat.m2505o(34376);
        } else if (C7616ad.aox(c7616ad.field_username)) {
            c23985d.nickName = ((C32873b) C1720g.m3528K(C32873b.class)).mo44308e(C4996ah.getContext(), c23985d.eoz, C1338a.m2856al(this.context, C25738R.dimen.f9980m5));
            AppMethodBeat.m2505o(34376);
        } else {
            c23985d.nickName = C44089j.m79294b(this.context, c23985d.eoz, C1338a.m2856al(this.context, C25738R.dimen.f9980m5));
            AppMethodBeat.m2505o(34376);
        }
    }

    /* renamed from: a */
    static int m36961a(C7617ak c7617ak, C23985d c23985d) {
        AppMethodBeat.m2504i(34377);
        if (c7617ak == null || c7617ak.field_unReadCount <= 0) {
            if (c7617ak == null || (!(c7617ak.mo16714jl(8388608) || c7617ak.mo16714jl(2097152)) || c7617ak == null || c7617ak.field_unReadMuteCount <= 0)) {
                AppMethodBeat.m2505o(34377);
                return 0;
            }
            AppMethodBeat.m2505o(34377);
            return 1;
        } else if (!C1855t.m3956ny(c7617ak.field_username)) {
            if (C1855t.m3918nD(c7617ak.field_username)) {
                C9638aw.m17190ZK();
                if (!C18628c.m29072Ry().getBoolean(C5127a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    AppMethodBeat.m2505o(34377);
                    return 1;
                }
            }
            if (C1855t.m3922nH(c7617ak.field_username)) {
                C9638aw.m17190ZK();
                if (!C18628c.m29072Ry().getBoolean(C5127a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    AppMethodBeat.m2505o(34377);
                    return 1;
                }
            }
            if (c23985d.zrN && c23985d.zrS) {
                AppMethodBeat.m2505o(34377);
                return 1;
            } else if (c23985d.mgQ && c23985d.zrR) {
                AppMethodBeat.m2505o(34377);
                return 1;
            } else {
                AppMethodBeat.m2505o(34377);
                return 2;
            }
        } else if (!C30309s.aVO() || c7617ak.mo16714jl(16) || c7617ak.mo16714jl(64)) {
            AppMethodBeat.m2505o(34377);
            return 1;
        } else {
            AppMethodBeat.m2505o(34377);
            return 0;
        }
    }

    /* renamed from: FB */
    private static int m36959FB(String str) {
        int i = 1;
        AppMethodBeat.m2504i(34378);
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.m2505o(34378);
        return i;
    }

    public final void clearCache() {
        AppMethodBeat.m2504i(34379);
        if (this.yDY != null) {
            this.yDY.clear();
            this.ztG = true;
        }
        AppMethodBeat.m2505o(34379);
    }

    private static String aqV(String str) {
        AppMethodBeat.m2504i(34382);
        if (str == null || str.length() != 32) {
            AppMethodBeat.m2505o(34382);
            return null;
        }
        String Jh = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35600Jh(str);
        AppMethodBeat.m2505o(34382);
        return Jh;
    }

    public final C1354d dwz() {
        AppMethodBeat.m2504i(34383);
        C4990ab.m7410d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
        C9638aw.m17190ZK();
        C1354d c1354d = (C1354d) C18628c.m29083XR().mo15769a(C1855t.fkP, this.elZ, C7487a.ewS, true);
        AppMethodBeat.m2505o(34383);
        return c1354d;
    }

    /* renamed from: ao */
    public final ArrayList<C7617ak> mo28034ao(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(34384);
        C4990ab.m7411d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        C9638aw.m17190ZK();
        Cursor a = C18628c.m29083XR().mo15771a((ArrayList) arrayList, C1855t.fkP, this.elZ, C7487a.ewS);
        while (a.moveToNext()) {
            C7617ak c7617ak = new C7617ak();
            c7617ak.mo8995d(a);
            arrayList2.add(c7617ak);
        }
        a.close();
        AppMethodBeat.m2505o(34384);
        return arrayList2;
    }

    /* renamed from: a */
    public final SparseArray<String>[] mo28033a(HashSet<C15880b<String, C7617ak>> hashSet, SparseArray<String>[] sparseArrayArr) {
        AppMethodBeat.m2504i(34385);
        if (sparseArrayArr == null || sparseArrayArr.length <= 0 || !C1720g.m3531RK()) {
            AppMethodBeat.m2505o(34385);
        } else {
            C15880b c15880b;
            C4990ab.m7411d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", Integer.valueOf(hashSet.size()), Integer.valueOf(sparseArrayArr[0].size()));
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                c15880b = (C15880b) it.next();
                if (!(c15880b == null || c15880b.ygE == 5 || arrayList.contains(c15880b.object))) {
                    C4990ab.m7410d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + ((String) c15880b.object));
                    arrayList.add(c15880b.object);
                }
            }
            HashMap hashMap = new HashMap();
            C9638aw.m17190ZK();
            Cursor a = C18628c.m29083XR().mo15771a(arrayList, C1855t.fkP, this.elZ, C7487a.ewS);
            while (a.moveToNext()) {
                C7617ak c7617ak = new C7617ak();
                c7617ak.mo8995d(a);
                hashMap.put(c7617ak.field_username, c7617ak);
            }
            a.close();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                c15880b = (C15880b) it2.next();
                if (c15880b != null) {
                    if (c15880b.ygE != 5) {
                        boolean z;
                        String str = "MicroMsg.ConversationWithCacheAdapter";
                        StringBuilder append = new StringBuilder("evnet name,").append((String) c15880b.object).append("  event.newObj   ==");
                        if (hashMap.get(c15880b.object) == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        C4990ab.m7410d(str, append.append(z).toString());
                        c15880b.ygF = hashMap.get(c15880b.object);
                    } else {
                        c15880b.ygF = null;
                    }
                }
            }
            arrayList.clear();
            hashMap.clear();
            HashMap hashMap2 = new HashMap();
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                c15880b = (C15880b) it3.next();
                if (c15880b != null) {
                    m36963a(c15880b, sparseArrayArr[0], hashMap2);
                    if (c15880b.ygE != 5) {
                        hashMap2.put(c15880b.object, c15880b.ygF);
                    }
                }
            }
            AppMethodBeat.m2505o(34385);
        }
        return sparseArrayArr;
    }

    /* renamed from: d */
    private C7617ak m36969d(String str, HashMap<String, C7617ak> hashMap) {
        AppMethodBeat.m2504i(34386);
        C7617ak c7617ak;
        if (hashMap == null || !hashMap.containsKey(str)) {
            c7617ak = (C7617ak) mo64393cL(str);
            AppMethodBeat.m2505o(34386);
            return c7617ak;
        }
        c7617ak = (C7617ak) hashMap.get(str);
        AppMethodBeat.m2505o(34386);
        return c7617ak;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f5 A:{LOOP_END, LOOP:4: B:34:0x00f3->B:35:0x00f5} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private SparseArray<String> m36963a(C15880b<String, C7617ak> c15880b, SparseArray<String> sparseArray, HashMap<String, C7617ak> hashMap) {
        int i;
        AppMethodBeat.m2504i(34387);
        String str = (String) c15880b.object;
        int size = sparseArray.size();
        C7617ak c7617ak = (C7617ak) c15880b.ygF;
        int size2 = sparseArray.size();
        int i2 = 0;
        while (i2 < size2) {
            if (((String) sparseArray.get(i2)).equals(str)) {
                break;
            }
            i2++;
        }
        i2 = -1;
        C4990ab.m7411d("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d", str, Integer.valueOf(size), Integer.valueOf(i2));
        switch (c15880b.ygE) {
            case 2:
                if (c7617ak == null) {
                    C4990ab.m7412e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null");
                    if (i2 >= 0) {
                        C4990ab.m7413e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s", str);
                        while (i2 < size - 1) {
                            sparseArray.put(i2, sparseArray.get(i2 + 1));
                            i2++;
                        }
                        sparseArray.remove(size - 1);
                    }
                    AppMethodBeat.m2505o(34387);
                    break;
                } else if (i2 < 0) {
                    i2 = 0;
                    while (i2 < size) {
                        if (m36969d((String) sparseArray.get(i2), hashMap).field_flag > c7617ak.field_flag) {
                            i2++;
                        } else {
                            for (i = size; i > i2; i--) {
                                sparseArray.put(i, sparseArray.get(i - 1));
                            }
                            sparseArray.put(i2, str);
                        }
                    }
                    while (i > i2) {
                    }
                    sparseArray.put(i2, str);
                }
                break;
            case 5:
                if (i2 < 0) {
                    AppMethodBeat.m2505o(34387);
                    break;
                }
                while (i2 < size - 1) {
                    sparseArray.put(i2, sparseArray.get(i2 + 1));
                    i2++;
                }
                sparseArray.remove(size - 1);
        }
        if (i2 < 0) {
            C4990ab.m7412e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0");
            AppMethodBeat.m2505o(34387);
        } else {
            C7617ak d = m36969d(str, hashMap);
            if (c7617ak == null) {
                C4990ab.m7413e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s", str);
                while (i2 < size - 1) {
                    sparseArray.put(i2, sparseArray.get(i2 + 1));
                    i2++;
                }
                sparseArray.remove(size - 1);
                AppMethodBeat.m2505o(34387);
            } else {
                long j = d.field_flag;
                long j2 = c7617ak.field_flag;
                if (j == j2) {
                    AppMethodBeat.m2505o(34387);
                } else {
                    int i3;
                    Object obj;
                    boolean z;
                    if (j < j2) {
                        size2 = 0;
                        i3 = i2 - 1;
                        obj = 1;
                    } else {
                        size2 = i2 + 1;
                        i3 = size - 1;
                        obj = null;
                    }
                    int i4 = size2;
                    while (i4 <= i3) {
                        if (m36969d((String) sparseArray.get(i4), hashMap).field_flag <= c7617ak.field_flag) {
                            z = true;
                            C4990ab.m7417i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", Integer.valueOf(size2), Integer.valueOf(i3), Integer.valueOf(-1), Boolean.valueOf(z), Integer.valueOf(i2), str);
                            if (z) {
                                AppMethodBeat.m2505o(34387);
                            } else {
                                if (obj != null) {
                                    while (i2 > i4) {
                                        sparseArray.put(i2, sparseArray.get(i2 - 1));
                                        i2--;
                                    }
                                    i = i4;
                                } else {
                                    i = i4 - 1;
                                    while (i2 < i) {
                                        sparseArray.put(i2, sparseArray.get(i2 + 1));
                                        i2++;
                                    }
                                }
                                sparseArray.put(i, str);
                                AppMethodBeat.m2505o(34387);
                            }
                        } else {
                            i4++;
                        }
                    }
                    z = false;
                    C4990ab.m7417i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", Integer.valueOf(size2), Integer.valueOf(i3), Integer.valueOf(-1), Boolean.valueOf(z), Integer.valueOf(i2), str);
                    if (z) {
                    }
                }
            }
        }
        return sparseArray;
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        int i2 = 0;
        AppMethodBeat.m2504i(34388);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7411d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(34388);
            return;
        }
        String str = (String) obj;
        if (c7298n instanceof C7310be) {
            C4990ab.m7417i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", Integer.valueOf(i), str);
            if (!(!str.contains("@") || str.endsWith("@chatroom") || str.endsWith("@im.chatroom") || str.endsWith("@micromsg.qq.com") || C7616ad.aox(str))) {
                i2 = 1;
            }
            if (i2 != 0) {
                AppMethodBeat.m2505o(34388);
                return;
            }
            if (this.yDY != null) {
                if (!obj.equals("")) {
                    this.ztF.add(str);
                } else if (i == 5) {
                    this.ztG = true;
                    super.mo28048j(null, 1);
                    AppMethodBeat.m2505o(34388);
                    return;
                }
            }
            if (i == 3) {
                i = 2;
            }
            super.mo28048j(str, i);
            AppMethodBeat.m2505o(34388);
            return;
        }
        if (c7298n instanceof C7309bd) {
            C4990ab.m7411d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s, isIniting %b", Integer.valueOf(i), obj, Boolean.valueOf(this.nNp));
            if (this.nNp) {
                AppMethodBeat.m2505o(34388);
                return;
            }
            this.ztE = true;
            if (i == 5 || i == 2) {
                AppMethodBeat.m2505o(34388);
                return;
            } else if (this.yDY == null || !this.yDY.containsKey(str)) {
                AppMethodBeat.m2505o(34388);
                return;
            } else if (this.ztA != null) {
                this.ztA.add(str);
            }
        }
        AppMethodBeat.m2505o(34388);
    }

    private void dII() {
        AppMethodBeat.m2504i(34389);
        if (this.yDY == null || this.ztA == null || this.ztA.isEmpty()) {
            AppMethodBeat.m2505o(34389);
            return;
        }
        C4990ab.m7411d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", Integer.valueOf(this.ztA.size()));
        Iterator it = this.ztA.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            String str = (String) it.next();
            if (!(str == null || str.equals("") || !this.yDY.containsKey(str))) {
                C23985d c23985d = (C23985d) this.yDY.get(str);
                if (c23985d != null) {
                    this.ztN.mo39784ju(str);
                    boolean kH = C1855t.m3896kH(str);
                    C7616ad dIK = this.ztN.dIK();
                    if (dIK != null) {
                        String a = C1854s.m3861a(dIK, str, kH);
                        C4990ab.m7411d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", a, c23985d.eoz);
                        if (!(a == null || a.equals(c23985d.eoz))) {
                            c23985d.eoz = a;
                            m36964a(c23985d, dIK);
                            i = 1;
                        }
                        boolean DX = dIK.mo16673DX();
                        kH = dIK.dua == 0;
                        if (!(c23985d.zrN == DX && kH == c23985d.zrR)) {
                            c23985d.zrN = DX;
                            c23985d.zrR = kH;
                            c23985d.zrS = dIK.mo16674Kc();
                            C4990ab.m7411d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", str);
                            i2 = 1;
                            i = i2;
                        }
                    }
                }
            }
            i2 = i;
            i = i2;
        }
        if (i != 0) {
            notifyDataSetChanged();
        }
        this.ztA.clear();
        AppMethodBeat.m2505o(34389);
    }

    public final boolean dvr() {
        AppMethodBeat.m2504i(34390);
        boolean dvr = super.dvr();
        AppMethodBeat.m2505o(34390);
        return dvr;
    }

    public final boolean arV(String str) {
        AppMethodBeat.m2504i(34391);
        if (this.yDY == null || !this.yDY.containsKey(str)) {
            AppMethodBeat.m2505o(34391);
            return true;
        }
        AppMethodBeat.m2505o(34391);
        return false;
    }

    /* renamed from: Pw */
    public final void mo39786Pw(int i) {
        AppMethodBeat.m2504i(34392);
        if (i < 0 || i >= getCount()) {
            AppMethodBeat.m2505o(34392);
            return;
        }
        C6563at c6563at;
        try {
            c6563at = (C7617ak) getItem(i);
        } catch (NullPointerException e) {
            C4990ab.m7421w("MicroMsg.ConversationWithCacheAdapter", "preLoad position:%s is null!", Integer.valueOf(i));
            c6563at = null;
        }
        if (c6563at == null) {
            AppMethodBeat.m2505o(34392);
            return;
        }
        C40460b.diS().mo8232cQ(c6563at.field_username);
        AppMethodBeat.m2505o(34392);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(34393);
        if (!this.ztR) {
            super.notifyDataSetChanged();
            this.ztC.clear();
        }
        C4990ab.m7416i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
        AppMethodBeat.m2505o(34393);
    }

    /* renamed from: h */
    private CharSequence m36974h(C7617ak c7617ak) {
        AppMethodBeat.m2504i(34366);
        CharSequence charSequence;
        if (c7617ak.field_status == 1) {
            String string = this.context.getString(C25738R.string.cw8);
            AppMethodBeat.m2505o(34366);
            return string;
        } else if (c7617ak.field_conversationTime == Long.MAX_VALUE) {
            charSequence = "";
            AppMethodBeat.m2505o(34366);
            return charSequence;
        } else {
            charSequence = C14835h.m23089c(this.context, c7617ak.field_conversationTime, true);
            AppMethodBeat.m2505o(34366);
            return charSequence;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: i */
    public final C23985d mo39794i(C7617ak c7617ak) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(34375);
        String str = c7617ak.field_username;
        if (this.yDY != null) {
            C23985d c23985d = (C23985d) this.yDY.get(str);
            if (c23985d != null) {
                AppMethodBeat.m2505o(34375);
                return c23985d;
            }
        }
        C23985d c23985d2 = new C23985d(this, (byte) 0);
        this.ztN.mo39784ju(str);
        C7616ad dIK = this.ztN.dIK();
        if (dIK != null) {
            c23985d2.zrL = dIK.duk;
            c23985d2.zrK = (int) dIK.ewQ;
        } else {
            c23985d2.zrL = -1;
            c23985d2.zrK = -1;
        }
        if (dIK != null) {
            z = true;
        } else {
            z = false;
        }
        c23985d2.zrQ = z;
        if (dIK == null || !dIK.mo16674Kc()) {
            z = false;
        } else {
            z = true;
        }
        c23985d2.zrS = z;
        if (dIK == null || dIK.dua != 0) {
            z = false;
        } else {
            z = true;
        }
        c23985d2.zrR = z;
        c23985d2.mgQ = C1855t.m3901mN(str);
        if (c23985d2.mgQ && c23985d2.zrR && c7617ak.field_unReadCount > 0) {
            z = true;
        } else {
            z = false;
        }
        c23985d2.zrP = z;
        c23985d2.klY = 0;
        if (C23987h.m36959FB(c7617ak.field_msgType) == 34 && c7617ak.field_isSend == 0 && !C42252ah.isNullOrNil(c7617ak.field_content)) {
            String str2 = c7617ak.field_content;
            if (str.equals("qmessage") || str.equals("floatbottle") || str.equals("officialaccounts") || c7617ak.mo16714jl(2097152) || c7617ak.mo16714jl(8388608)) {
                String[] split = str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (split != null && split.length > 3) {
                    str2 = split[1] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[2] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[3];
                }
            }
            if (!new C42230n(str2).fWX) {
                c23985d2.klY = 1;
            }
        }
        if (C30309s.aVO() && C1855t.m3956ny(str)) {
            c23985d2.eoz = this.context.getResources().getString(C25738R.string.a_i);
        } else {
            c23985d2.eoz = C1854s.m3861a(dIK, str, c23985d2.mgQ);
        }
        m36964a(c23985d2, dIK);
        c23985d2.zrH = m36974h(c7617ak);
        c23985d2.zrJ = C23987h.m36960Pu(c7617ak.field_status);
        c23985d2.zrM = C1855t.m3881a(c7617ak);
        C9638aw.m17190ZK();
        c23985d2.yDZ = C18628c.m29083XR().mo15822g(c7617ak);
        if (dIK == null || !dIK.mo16673DX()) {
            z2 = false;
        }
        c23985d2.zrN = z2;
        if (this.yDY != null) {
            this.yDY.put(str, c23985d2);
        }
        AppMethodBeat.m2505o(34375);
        return c23985d2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private CharSequence m36967b(C7617ak c7617ak, int i, boolean z) {
        AppMethodBeat.m2504i(34380);
        if (C42252ah.isNullOrNil(c7617ak.field_editingMsg) || (c7617ak.field_atCount > 0 && (c7617ak.field_unReadCount > 0 || c7617ak.field_unReadMuteCount > 0))) {
            boolean ny;
            CharSequence spannableString;
            String mJ;
            if (C23987h.m36959FB(c7617ak.field_msgType) == Downloads.MIN_WAIT_FOR_NETWORK) {
                ny = C1855t.m3956ny(c7617ak.field_username);
                if (!ny) {
                    ny = c7617ak.mo16714jl(2097152);
                }
                if (!ny) {
                    ny = c7617ak.mo16714jl(8388608);
                }
                if (!ny) {
                    ny = c7617ak.mo16714jl(16777216);
                }
                if (!ny) {
                    ny = C1855t.m3922nH(c7617ak.field_username);
                }
                if (!ny) {
                    spannableString = new SpannableString(C44089j.m79305f(this.context, c7617ak.field_content, i));
                    AppMethodBeat.m2505o(34380);
                    return spannableString;
                }
            }
            if (C23987h.m36959FB(c7617ak.field_msgType) == 49) {
                mJ = C1854s.m3866mJ(c7617ak.field_digestUser);
                C8910b me = C8910b.m16064me(c7617ak.field_content);
                if (me == null || me.type != 40) {
                    if (me != null && me.type == 5) {
                        mJ = null;
                        try {
                            mJ = String.format(c7617ak.field_digest, new Object[]{C23987h.m36975j(c7617ak)});
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", e, "", new Object[0]);
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        if (C42252ah.isNullOrNil(mJ)) {
                            mJ = this.context.getString(C25738R.string.f9248u9);
                        }
                        spannableString = new SpannableString(C44089j.m79305f(this.context, stringBuilder.append(mJ).append(" ").append(me.title).toString(), i));
                        AppMethodBeat.m2505o(34380);
                        return spannableString;
                    } else if (me != null && me.type == 19) {
                        if (C42252ah.isNullOrNil(mJ)) {
                            spannableString = this.context.getString(C25738R.string.f9212t5);
                        } else {
                            spannableString = mJ + ": " + this.context.getString(C25738R.string.f9212t5);
                        }
                        c7617ak.mo14758jh(spannableString);
                        spannableString = C44089j.m79294b(this.context, spannableString, i);
                        AppMethodBeat.m2505o(34380);
                        return spannableString;
                    }
                } else if (C32222n.m52572mj(c7617ak.field_content).fju == 19) {
                    spannableString = C42252ah.isNullOrNil(mJ) ? this.context.getString(C25738R.string.f9212t5) : mJ + ": " + this.context.getString(C25738R.string.f9212t5);
                    c7617ak.mo14758jh(spannableString);
                    spannableString = C44089j.m79294b(this.context, spannableString, i);
                    AppMethodBeat.m2505o(34380);
                    return spannableString;
                }
            }
            CharSequence charSequence = c7617ak.field_digest;
            if (charSequence == null || !charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                int i2;
                String str = c7617ak.field_username;
                if (str.equals("qqmail")) {
                    C9638aw.m17190ZK();
                    if (C42252ah.m74624h((Integer) C18628c.m29072Ry().get(17, null)) == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        spannableString = this.context.getString(C25738R.string.e_7);
                        AppMethodBeat.m2505o(34380);
                        return spannableString;
                    }
                }
                if (str.equals("tmessage")) {
                    C9638aw.m17190ZK();
                    C5140bq RA = C18628c.m29086XU().mo15356RA("@t.qq.com");
                    if (RA == null || !RA.isEnable()) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 == 0) {
                        spannableString = this.context.getString(C25738R.string.e_7);
                        AppMethodBeat.m2505o(34380);
                        return spannableString;
                    }
                }
                if (c7617ak.field_msgType == null || !c7617ak.field_msgType.equals("64")) {
                    String str2;
                    if (c7617ak.field_msgType != null && (c7617ak.field_msgType.equals("47") || c7617ak.field_msgType.equals("1048625"))) {
                        str = C23987h.aqV(c7617ak.field_digest);
                        mJ = "";
                        if (C42252ah.isNullOrNil(str)) {
                            if (c7617ak.field_digest != null && c7617ak.field_digest.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                                mJ = c7617ak.field_digest.substring(0, c7617ak.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                                str = C23987h.aqV(c7617ak.field_digest.substring(c7617ak.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1).replace(" ", ""));
                                if (!C42252ah.isNullOrNil(str)) {
                                    str2 = "[" + str + "]";
                                    if (C42252ah.isNullOrNil(mJ)) {
                                        spannableString = C44089j.m79294b(this.context, (CharSequence) mJ, i);
                                        AppMethodBeat.m2505o(34380);
                                        return spannableString;
                                    }
                                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                                    spannableStringBuilder.append(C44089j.m79294b(this.context, (CharSequence) mJ, i));
                                    spannableStringBuilder.append(": ");
                                    spannableStringBuilder.append(str2);
                                    AppMethodBeat.m2505o(34380);
                                    return spannableStringBuilder;
                                }
                            }
                            str = this.context.getString(C25738R.string.f9100ph);
                            if (C42252ah.isNullOrNil(mJ)) {
                                mJ = str;
                            } else {
                                mJ = mJ + ": " + str;
                            }
                            c7617ak.mo14758jh(mJ);
                        } else {
                            spannableString = "[" + str + "]";
                            AppMethodBeat.m2505o(34380);
                            return spannableString;
                        }
                    }
                    if (!C42252ah.isNullOrNil(c7617ak.field_digest)) {
                        if (C42252ah.isNullOrNil(c7617ak.field_digestUser)) {
                            mJ = c7617ak.field_digest;
                        } else {
                            mJ = C23987h.m36975j(c7617ak);
                            try {
                                mJ = String.format(c7617ak.field_digest, new Object[]{mJ});
                            } catch (Exception e2) {
                            }
                        }
                        charSequence = mJ.replace(10, ' ');
                        SpannableStringBuilder spannableStringBuilder2;
                        if (!c7617ak.mo16714jl(33554432) && (c7617ak.field_unReadCount > 0 || c7617ak.field_unReadMuteCount > 0)) {
                            spannableString = new SpannableStringBuilder(this.context.getString(C25738R.string.etn));
                            spannableString.setSpan(new ForegroundColorSpan(-5569532), 0, spannableString.length(), 33);
                            spannableString.append(" ").append(C44089j.m79294b(this.context, charSequence, i));
                            AppMethodBeat.m2505o(34380);
                            return spannableString;
                        } else if (c7617ak.field_UnReadInvite <= 0) {
                            if (c7617ak.field_UnReadInvite < 4096) {
                                spannableString = this.context.getString(C25738R.string.cve, new Object[]{Integer.valueOf(c7617ak.field_UnReadInvite)});
                            } else {
                                spannableString = this.context.getString(C25738R.string.cvc);
                            }
                            spannableStringBuilder2 = new SpannableStringBuilder(spannableString);
                            spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
                            spannableStringBuilder2.append(" ").append(C44089j.m79294b(this.context, charSequence, i));
                            AppMethodBeat.m2505o(34380);
                            return spannableStringBuilder2;
                        } else if (c7617ak.field_atCount > 0 && (c7617ak.field_unReadCount > 0 || c7617ak.field_unReadMuteCount > 0)) {
                            spannableStringBuilder2 = new SpannableStringBuilder(this.context.getString(c7617ak.field_atCount < 4096 ? C25738R.string.cvd : C25738R.string.cvf));
                            spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
                            spannableStringBuilder2.append(" ").append(C44089j.m79294b(this.context, charSequence, i));
                            AppMethodBeat.m2505o(34380);
                            return spannableStringBuilder2;
                        } else if (!c7617ak.mo16714jl(16777216) || (c7617ak.field_unReadCount <= 0 && c7617ak.field_unReadMuteCount <= 0)) {
                            if (!z || (c7617ak.field_unReadCount <= 1 && c7617ak.field_unReadMuteCount <= 0)) {
                                if (C30309s.aVO() && C1855t.m3956ny(c7617ak.field_username)) {
                                    ny = c7617ak.mo16714jl(16);
                                    if (c7617ak.field_unReadCount > 1 || (!ny && c7617ak.field_unReadCount > 0)) {
                                        if (!ny) {
                                            spannableString = this.context.getString(C25738R.string.cvb, new Object[]{Integer.valueOf(c7617ak.field_unReadCount), charSequence});
                                        } else if (c7617ak.mo16714jl(32)) {
                                            mJ = this.context.getString(C25738R.string.cva, new Object[]{Integer.valueOf(c7617ak.field_unReadCount)});
                                            Drawable drawable = this.context.getResources().getDrawable(C25738R.drawable.axl);
                                            drawable.setBounds(0, 0, i, i);
                                            new SpannableString("@").setSpan(new C5664a(drawable), 0, 1, 33);
                                            spannableString = TextUtils.concat(new CharSequence[]{mJ, " ", r4, C44089j.m79294b(this.context, charSequence, i)});
                                            AppMethodBeat.m2505o(34380);
                                            return spannableString;
                                        } else {
                                            spannableString = this.context.getString(C25738R.string.cvg, new Object[]{Integer.valueOf(c7617ak.field_unReadCount), charSequence});
                                        }
                                    } else if (c7617ak.mo16714jl(32)) {
                                        Drawable drawable2 = this.context.getResources().getDrawable(C25738R.drawable.axl);
                                        drawable2.setBounds(0, 0, i, i);
                                        new SpannableString("@").setSpan(new C5664a(drawable2), 0, 1, 33);
                                        spannableString = TextUtils.concat(new CharSequence[]{r0, C44089j.m79294b(this.context, charSequence, i)});
                                        AppMethodBeat.m2505o(34380);
                                        return spannableString;
                                    }
                                }
                                spannableString = charSequence;
                            } else {
                                spannableString = this.context.getString(C25738R.string.cvg, new Object[]{Integer.valueOf(c7617ak.field_unReadCount), charSequence});
                            }
                            spannableString = C44089j.m79294b(this.context, spannableString, i);
                            AppMethodBeat.m2505o(34380);
                            return spannableString;
                        } else {
                            str2 = this.context.getString(C25738R.string.f8651b0);
                            charSequence = charSequence.replace(str2, "");
                            spannableString = new SpannableStringBuilder(str2);
                            spannableString.setSpan(new ForegroundColorSpan(-5569532), 0, spannableString.length(), 33);
                            spannableString.append(C44089j.m79294b(this.context, charSequence, i));
                            AppMethodBeat.m2505o(34380);
                            return spannableString;
                        }
                    }
                    mJ = C37622h.m63519a(c7617ak.field_isSend, c7617ak.field_username, c7617ak.field_content, C23987h.m36959FB(c7617ak.field_msgType), this.context);
                    charSequence = mJ.replace(10, ' ');
                    if (!c7617ak.mo16714jl(33554432)) {
                    }
                    if (c7617ak.field_UnReadInvite <= 0) {
                    }
                } else {
                    spannableString = c7617ak.field_content;
                    AppMethodBeat.m2505o(34380);
                    return spannableString;
                }
            }
            spannableString = new SpannableString(C44089j.m79303e(this.context, charSequence, (float) i));
            AppMethodBeat.m2505o(34380);
            return spannableString;
        }
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(this.context.getString(C25738R.string.cvh));
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder3.length(), 33);
        spannableStringBuilder3.append(" ").append(C44089j.m79294b(this.context, c7617ak.field_editingMsg, i));
        AppMethodBeat.m2505o(34380);
        return spannableStringBuilder3;
    }

    /* renamed from: j */
    private static String m36975j(C7617ak c7617ak) {
        AppMethodBeat.m2504i(34381);
        String displayName;
        if (c7617ak.field_isSend == 0 && C1855t.m3896kH(c7617ak.field_username)) {
            displayName = C1854s.getDisplayName(c7617ak.field_digestUser, c7617ak.field_username);
            AppMethodBeat.m2505o(34381);
            return displayName;
        }
        displayName = C1854s.m3866mJ(c7617ak.field_digestUser);
        AppMethodBeat.m2505o(34381);
        return displayName;
    }

    public final /* synthetic */ C1351a dvz() {
        AppMethodBeat.m2504i(34394);
        C7617ak c7617ak = new C7617ak();
        AppMethodBeat.m2505o(34394);
        return c7617ak;
    }

    /* renamed from: e */
    static /* synthetic */ void m36971e(C23987h c23987h) {
        AppMethodBeat.m2504i(34395);
        if (!c23987h.dIG()) {
            C4990ab.m7420w("MicroMsg.ConversationWithCacheAdapter", "is not need dismissClickStatus");
            AppMethodBeat.m2505o(34395);
        } else if (c23987h.ztM == null || !c23987h.ztM.isRunning()) {
            Object obj;
            for (int i = 0; i < c23987h.mListView.getChildCount(); i++) {
                View childAt = c23987h.mListView.getChildAt(i);
                if (childAt.getBackground() == c23987h.ztL) {
                    obj = childAt;
                    break;
                }
            }
            C4990ab.m7421w("MicroMsg.ConversationWithCacheAdapter", "[findClickStatusView] can't found click view! username:%s", c23987h.ztK);
            obj = null;
            if (obj == null) {
                c23987h.ztK = null;
                AppMethodBeat.m2505o(34395);
                return;
            }
            C4990ab.m7417i("MicroMsg.ConversationWithCacheAdapter", "[dismissClickStatus] %s username:%s", Integer.valueOf(obj.hashCode()), c23987h.ztK);
            final C23991f c23991f = (C23991f) obj.getTag();
            Resources resources = obj.getContext().getResources();
            int i2 = (c23991f == null || !c23991f.yDZ) ? C25738R.color.f11904l6 : C25738R.color.f11883ki;
            c23987h.ztL = new ColorDrawable(resources.getColor(i2));
            obj.setBackground(c23987h.ztL);
            String str = "alpha";
            int[] iArr = new int[2];
            iArr[0] = 220;
            if (c23991f.yDZ) {
                i2 = 100;
            } else {
                i2 = 0;
            }
            iArr[1] = i2;
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, iArr);
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
            ofPropertyValuesHolder.addUpdateListener(new C239934());
            ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(34358);
                    super.onAnimationEnd(animator);
                    C23987h.m36965a(C23987h.this, obj, c23991f);
                    C4990ab.m7416i("MicroMsg.ConversationWithCacheAdapter", "[dismissClickStatus] setBackground back!");
                    AppMethodBeat.m2505o(34358);
                }
            });
            ofPropertyValuesHolder.setDuration(60);
            if (c23987h.ztL != null) {
                ofPropertyValuesHolder.start();
                c23987h.ztM = ofPropertyValuesHolder;
            }
            AppMethodBeat.m2505o(34395);
        } else {
            C4990ab.m7421w("MicroMsg.ConversationWithCacheAdapter", "[dismissClickStatus] animation is running! %s", c23987h.ztK);
            AppMethodBeat.m2505o(34395);
        }
    }
}
