package com.tencent.mm.ui.conversation;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.c.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class h extends com.tencent.mm.ui.f<String, ak> implements com.tencent.mm.sdk.e.n.b {
    protected List<String> elZ = null;
    private boolean gxV = false;
    protected g jJO;
    protected com.tencent.mm.ui.base.MMSlideDelView.c jJP;
    protected com.tencent.mm.ui.base.MMSlideDelView.d jJR = MMSlideDelView.getItemStatusCallBack();
    private ListView mListView;
    boolean nNp = false;
    boolean riR = false;
    private float yDU = -1.0f;
    private float yDV = -1.0f;
    private float yDW = -1.0f;
    private ColorStateList[] yDX = new ColorStateList[5];
    HashMap<String, d> yDY;
    public boolean yOf = false;
    com.tencent.mm.sdk.e.k.a yql = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(34359);
            h.this.notifyDataSetChanged();
            AppMethodBeat.o(34359);
        }
    };
    private boolean zrm = true;
    com.tencent.mm.pluginsdk.ui.d zro;
    private boolean zrq = false;
    com.tencent.mm.sdk.b.c zrt = null;
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
    private com.tencent.mm.ui.base.NoMeasuredTextView.c ztI = new com.tencent.mm.ui.base.NoMeasuredTextView.c() {
        public final CharSequence a(NoMeasuredTextView noMeasuredTextView, CharSequence charSequence, String str, int i, int i2) {
            Object str2;
            Object obj;
            AppMethodBeat.i(34353);
            float textSize = noMeasuredTextView.getPaint().getTextSize();
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(h.this.context, i2);
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
            SpannableString b = j.b(h.this.context, obj2 + " " + str2);
            ColorStateList h = com.tencent.mm.bz.a.h(h.this.context, i);
            b.setSpan(new TextAppearanceSpan(null, 0, fromDPToPix, h, h), obj2.length() + 1, (obj2.length() + 1) + str2.length(), 33);
            AppMethodBeat.o(34353);
            return b;
        }
    };
    public String ztJ = "";
    private String ztK;
    private Drawable ztL;
    ValueAnimator ztM;
    final e ztN = new e();
    private float ztO = -1.0f;
    private a ztP;
    private long ztQ = 0;
    boolean ztR = false;
    private boolean ztx = false;
    private sz zty = null;
    b ztz = null;

    class a {
        public String bCu;
        public String content;
        public int zrF;
        public String zrG;

        private a() {
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }
    }

    class c {
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

        c() {
        }
    }

    class d {
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

        private d() {
        }

        /* synthetic */ d(h hVar, byte b) {
            this();
        }
    }

    class e {
        private ad ehM;
        private boolean initialized;
        private String talker;
        private Integer zrU;

        public e() {
            this.initialized = false;
            this.talker = null;
            this.initialized = false;
            this.ehM = null;
            this.zrU = null;
        }

        public final void ju(String str) {
            AppMethodBeat.i(34363);
            this.talker = str;
            this.ehM = null;
            this.zrU = null;
            this.initialized = false;
            if (!ah.isNullOrNil(str)) {
                this.initialized = true;
            }
            AppMethodBeat.o(34363);
        }

        public final ad dIK() {
            AppMethodBeat.i(34364);
            if (this.initialized && this.ehM == null && aw.RK()) {
                aw.ZK();
                this.ehM = com.tencent.mm.model.c.XM().aoO(this.talker);
            }
            ad adVar = this.ehM;
            AppMethodBeat.o(34364);
            return adVar;
        }
    }

    public interface b {
        void dIJ();
    }

    public static class f {
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
        public c zuf;
    }

    public h(Context context, ListView listView, com.tencent.mm.ui.f.a aVar) {
        super(context, (short) 0);
        AppMethodBeat.i(34365);
        this.mListView = listView;
        this.TAG = "MicroMsg.ConversationWithCacheAdapter";
        super.a(aVar);
        this.yDX[0] = com.tencent.mm.bz.a.h(context, (int) R.color.s0);
        this.yDX[1] = com.tencent.mm.bz.a.h(context, (int) R.color.a7y);
        this.yDX[3] = com.tencent.mm.bz.a.h(context, (int) R.color.w4);
        this.yDX[2] = com.tencent.mm.bz.a.h(context, (int) R.color.a7v);
        this.yDX[2] = com.tencent.mm.bz.a.h(context, (int) R.color.a7v);
        this.yDX[4] = com.tencent.mm.bz.a.h(context, (int) R.color.t3);
        if (com.tencent.mm.bz.a.gb(context)) {
            this.zry = context.getResources().getDimensionPixelSize(R.dimen.f8);
            this.zrx = context.getResources().getDimensionPixelSize(R.dimen.f9);
        } else if (com.tencent.mm.bz.a.ga(context)) {
            this.zry = context.getResources().getDimensionPixelSize(R.dimen.f7);
            this.zrx = context.getResources().getDimensionPixelSize(R.dimen.f9);
        } else {
            this.zry = context.getResources().getDimensionPixelSize(R.dimen.f6);
            this.zrx = context.getResources().getDimensionPixelSize(R.dimen.f_);
        }
        this.yDY = new HashMap();
        this.ztA = new HashSet();
        this.ztF = new HashSet();
        this.yDU = context.getResources().getDimension(R.dimen.m5);
        this.yDV = context.getResources().getDimension(R.dimen.kr);
        this.yDW = context.getResources().getDimension(R.dimen.nk);
        this.elZ = new ArrayList();
        this.elZ.add("qmessage");
        AppMethodBeat.o(34365);
    }

    public final void setPerformItemClickListener(g gVar) {
        this.jJO = gVar;
    }

    public final void setGetViewPositionCallback(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.jJP = cVar;
    }

    private static int Pu(int i) {
        switch (i) {
            case 1:
            case 8:
                return R.raw.msg_state_sending;
            case 5:
                return R.raw.msg_state_failed;
            default:
                return -1;
        }
    }

    public final void dHz() {
        boolean z = true;
        AppMethodBeat.i(34367);
        if (this.elZ == null) {
            this.elZ = new ArrayList();
        }
        this.elZ.clear();
        boolean z2 = (r.YD() & 32768) == 0;
        boolean YQ = r.YQ();
        if (!(z2 && YQ)) {
            z = false;
        }
        if (z != this.ztH) {
            if (z) {
                aw.ZK();
                a(5, (n) com.tencent.mm.model.c.XR(), (Object) "floatbottle");
            } else {
                aw.ZK();
                a(2, (n) com.tencent.mm.model.c.XR(), (Object) "floatbottle");
            }
            this.ztH = z;
        }
        if (this.ztH) {
            this.elZ.add("floatbottle");
        }
        this.elZ.add("qmessage");
        AppMethodBeat.o(34367);
    }

    public final void onPause() {
        AppMethodBeat.i(34368);
        ab.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.yOf);
        if (this.yOf) {
            this.yOf = false;
            super.pause();
            if (this.jJR != null) {
                this.jJR.bIp();
            }
            AppMethodBeat.o(34368);
            return;
        }
        AppMethodBeat.o(34368);
    }

    private void dIq() {
        AppMethodBeat.i(34369);
        if (this.yDY == null) {
            AppMethodBeat.o(34369);
            return;
        }
        for (Entry value : this.yDY.entrySet()) {
            ((d) value.getValue()).zrH = null;
        }
        AppMethodBeat.o(34369);
    }

    public final void onResume() {
        AppMethodBeat.i(34370);
        ab.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.yOf);
        if (this.yOf) {
            AppMethodBeat.o(34370);
            return;
        }
        boolean z;
        this.yOf = true;
        dHz();
        dII();
        ab.i(this.TAG, "newcursor resume syncNow ");
        this.ygr = true;
        pA(true);
        Time time = new Time();
        time.setToNow();
        String charSequence = com.tencent.mm.pluginsdk.f.g.a("MM/dd", time).toString();
        String dor = aa.dor();
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
            super.j(null, 1);
        }
        this.zty = new sz();
        this.zty.cPf.cPh = true;
        com.tencent.mm.sdk.b.a.xxA.m(this.zty);
        AppMethodBeat.o(34370);
    }

    private boolean dIG() {
        return this.ztK != null;
    }

    public final void a(View view, int i, String str) {
        AppMethodBeat.i(34371);
        if (view == null) {
            AppMethodBeat.o(34371);
        } else if (this.ztK != null) {
            ab.w("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] has click! position:%s username:%s", Integer.valueOf(i), str);
            AppMethodBeat.o(34371);
        } else {
            ab.i("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] position:%s username:%s", Integer.valueOf(i), str);
            this.ztK = str;
            f fVar = (f) view.getTag();
            Resources resources = view.getContext().getResources();
            int i2 = (fVar == null || !fVar.yDZ) ? R.color.l6 : R.color.ki;
            this.ztL = new ColorDrawable(resources.getColor(i2));
            view.setBackground(this.ztL);
            AppMethodBeat.o(34371);
        }
    }

    public final void Pv(int i) {
        AppMethodBeat.i(34372);
        if (dIG()) {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(34356);
                    h.e(h.this);
                    AppMethodBeat.o(34356);
                }
            }, (long) i);
            AppMethodBeat.o(34372);
            return;
        }
        ab.i("MicroMsg.ConversationWithCacheAdapter", "[requestDismissClickStatus] pass!");
        AppMethodBeat.o(34372);
    }

    public final void dIH() {
        AppMethodBeat.i(34373);
        super.j(null, 1);
        AppMethodBeat.o(34373);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        Object obj;
        AppMethodBeat.i(34374);
        this.ztP = new a(this, (byte) 0);
        ak akVar = (ak) getItem(i);
        String str = akVar.field_username;
        this.ztN.ju(str);
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
                        stringBuffer.append(((ak) entry.getValue()).field_username);
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
            ab.i(str2, str3, objArr);
            if (!this.ztB) {
                com.tencent.mm.plugin.fts.a.e.vV(20);
                this.ztB = true;
            }
            if (System.currentTimeMillis() - this.ztQ > 3600000) {
                super.j(null, 1);
                this.ztQ = System.currentTimeMillis();
            }
        }
        if (view == null) {
            View a;
            fVar = new f();
            if (com.tencent.mm.bz.a.ga(this.context)) {
                a = com.tencent.mm.kiss.a.b.SM().a((Activity) this.context, "R.layout.conversation_item_with_cache_large", (int) R.layout.ra);
            } else if (com.tencent.mm.bz.a.gc(this.context)) {
                a = com.tencent.mm.kiss.a.b.SM().a((Activity) this.context, "R.layout.conversation_item_with_cache_small", (int) R.layout.rb);
            } else {
                a = com.tencent.mm.kiss.a.b.SM().a((Activity) this.context, "R.layout.conversation_item_with_cache", (int) R.layout.r_);
            }
            a.setTag(R.id.cy, new int[2]);
            a.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(34360);
                    if (h.this.mListView == null || h.this.mListView.getOnItemClickListener() == null) {
                        ab.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
                        AppMethodBeat.o(34360);
                    } else if (view.getTag() == null) {
                        ab.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
                        AppMethodBeat.o(34360);
                    } else if (h.this.yOf) {
                        f fVar = (f) view.getTag();
                        int headerViewsCount = fVar.position + h.this.mListView.getHeaderViewsCount();
                        h.this.mListView.getOnItemClickListener().onItemClick(h.this.mListView, view, headerViewsCount, h.this.getItemId(fVar.position));
                        AppMethodBeat.o(34360);
                    } else {
                        ab.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
                        AppMethodBeat.o(34360);
                    }
                }
            });
            a.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(34361);
                    if (h.this.mListView == null || h.this.mListView.getOnItemLongClickListener() == null) {
                        ab.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
                        AppMethodBeat.o(34361);
                        return false;
                    } else if (view.getTag() == null) {
                        ab.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
                        AppMethodBeat.o(34361);
                        return false;
                    } else if (h.this.yOf) {
                        f fVar = (f) view.getTag();
                        int headerViewsCount = fVar.position + h.this.mListView.getHeaderViewsCount();
                        boolean onItemLongClick = h.this.mListView.getOnItemLongClickListener().onItemLongClick(h.this.mListView, view, headerViewsCount, h.this.getItemId(fVar.position));
                        AppMethodBeat.o(34361);
                        return onItemLongClick;
                    } else {
                        ab.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
                        AppMethodBeat.o(34361);
                        return false;
                    }
                }
            });
            fVar.ejo = (ImageView) a.findViewById(R.id.qk);
            com.tencent.mm.pluginsdk.ui.a.b.b(fVar.ejo, str);
            com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) fVar.ejo.getDrawable();
            if (this.zro != null) {
                this.zro.a(aVar);
            }
            fVar.yEc = (NoMeasuredTextView) a.findViewById(R.id.b6e);
            fVar.yEc.setLayoutCallback(this.ztI);
            fVar.yEd = (NoMeasuredTextView) a.findViewById(R.id.b6f);
            fVar.zud = (ImageView) a.findViewById(R.id.b6m);
            fVar.yEe = (NoMeasuredTextView) a.findViewById(R.id.b6g);
            fVar.jJV = (TextView) a.findViewById(R.id.nf);
            fVar.yEf = (ImageView) a.findViewById(R.id.b6i);
            fVar.yEh = a.findViewById(R.id.b6d);
            fVar.yEg = (ImageView) a.findViewById(R.id.b6j);
            fVar.zrW = (ImageView) a.findViewById(R.id.b6k);
            fVar.zue = (ImageView) a.findViewById(R.id.b6h);
            fVar.jJV.setBackgroundResource(com.tencent.mm.ui.tools.r.ik(this.context));
            fVar.zuf = new c();
            a.setTag(fVar);
            fVar.yEe.setTextSize(0, (float) com.tencent.mm.bz.a.al(this.context, R.dimen.ni));
            fVar.yEd.setTextSize(0, (float) com.tencent.mm.bz.a.al(this.context, R.dimen.nk));
            fVar.yEc.setTextSize(0, (float) com.tencent.mm.bz.a.al(this.context, R.dimen.m5));
            this.ztO = fVar.yEc.getTextSize();
            fVar.yEe.setTextColor(this.yDX[0]);
            fVar.yEd.setTextColor(this.yDX[4]);
            fVar.yEc.setTextColor(this.yDX[3]);
            fVar.yEe.setShouldEllipsize(true);
            fVar.yEd.setShouldEllipsize(false);
            fVar.yEc.setShouldEllipsize(true);
            fVar.yEd.setGravity(5);
            obj = a;
        } else {
            fVar = (f) view.getTag();
            View obj2 = view;
        }
        d i4 = i(akVar);
        fVar.position = i;
        fVar.username = str;
        boolean z = i4.yDZ && akVar.field_conversationTime != -1;
        fVar.yDZ = z;
        if (i4.zrI == null) {
            i4.zrI = b(akVar, (int) fVar.yEe.getTextSize(), i4.zrP);
        }
        if (i4.zrH == null) {
            i4.zrH = h(akVar);
        }
        if (i4.zrP) {
            fVar.yEe.setTextColor(this.yDX[0]);
        } else {
            fVar.yEe.setTextColor(this.yDX[i4.klY]);
        }
        com.tencent.mm.booter.notification.a.h.iv(fVar.yEe.getWidth());
        com.tencent.mm.booter.notification.a.h.iw((int) fVar.yEe.getTextSize());
        com.tencent.mm.booter.notification.a.h.a(fVar.yEe.getPaint());
        if (t.mP(str)) {
            fVar.yEc.setCompoundRightDrawablesWithIntrinsicBounds((int) R.raw.open_im_main_logo);
            fVar.yEc.setDrawRightDrawable(true);
        } else if (fVar.yEc.yzV) {
            fVar.yEc.setDrawRightDrawable(false);
        }
        int i5 = i4.zrJ;
        if (i5 != -1) {
            fVar.yEe.setCompoundLeftDrawablesWithIntrinsicBounds(i5);
            fVar.yEe.setDrawLeftDrawable(true);
            ab.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", str, Integer.valueOf(i4.zrJ));
        } else {
            fVar.yEe.setDrawLeftDrawable(false);
            fVar.yEe.invalidate();
        }
        if (ad.aox(akVar.field_username)) {
            this.ztN.ju(akVar.field_username);
            ad dIK = this.ztN.dIK();
            String str4 = "";
            if (dIK != null) {
                str4 = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).ba(dIK.field_openImAppid, dIK.field_descWordingId);
            }
            if (ah.isNullOrNil(str4)) {
                fVar.yEc.au(null, 0, 0);
            } else {
                if ("3552365301".equals(dIK.field_openImAppid)) {
                    str4 = "@".concat(String.valueOf(str4));
                }
                fVar.yEc.au(str4, R.color.st, 14);
            }
        } else {
            t.mP(akVar.field_username);
            fVar.yEc.au(null, 0, 0);
        }
        fVar.yEc.setText(i4.nickName);
        LayoutParams layoutParams = fVar.yEd.getLayoutParams();
        if (i4.zrH.length() >= 9) {
            if (layoutParams.width != this.zry) {
                layoutParams.width = this.zry;
                fVar.yEd.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.zrx) {
            layoutParams.width = this.zrx;
            fVar.yEd.setLayoutParams(layoutParams);
        }
        fVar.yEd.setText(i4.zrH);
        fVar.yEe.setText(i4.zrI);
        fVar.zud.setVisibility(8);
        fVar.yEf.setVisibility(8);
        if (((com.tencent.mm.plugin.forcenotify.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.forcenotify.a.b.class)).Mp(str)) {
            fVar.yEf.setVisibility(0);
            fVar.yEf.setImageResource(R.raw.chat_force_notify_icon);
        } else {
            fVar.yEf.setImageResource(R.raw.chat_mute_notify_title_icon);
            if (i4.mgQ) {
                if (i4.zrR) {
                    fVar.yEf.setVisibility(0);
                }
            } else if (i4.zrN) {
                fVar.yEf.setVisibility(0);
            }
        }
        com.tencent.mm.pluginsdk.ui.a.b.b(fVar.ejo, str);
        if (this.zrm) {
            if (akVar == null || fVar == null || i4 == null) {
                ab.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                fVar.jJV.setVisibility(4);
                fVar.yEh.setVisibility(4);
                ColorStateList colorStateList = (!t.mU(akVar.field_username) && i4.zrQ && (i4.zrL == 1 || i4.zrL == 2 || i4.zrL == 3)) ? this.yDX[2] : this.yDX[3];
                fVar.yEc.setTextColor(colorStateList);
                if (!i4.zrQ || i4.zrK == 0) {
                    ab.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
                } else {
                    i5 = a(akVar, i4);
                    if (i5 == 1) {
                        fVar.yEh.setVisibility(0);
                    } else if (i5 == 2) {
                        i5 = akVar.field_unReadCount;
                        if (i5 > 99) {
                            fVar.jJV.setText("");
                            fVar.jJV.setBackgroundResource(R.raw.badge_count_more);
                            fVar.jJV.setVisibility(0);
                        } else if (i5 > 0) {
                            fVar.jJV.setText(akVar.field_unReadCount);
                            fVar.jJV.setVisibility(0);
                            fVar.jJV.setBackgroundResource(com.tencent.mm.ui.tools.r.ik(this.context));
                        }
                        this.ztP.zrF = i5;
                    }
                }
            }
        }
        if (!i4.zrM && i4.yDZ && aw.RK()) {
            aw.ZK();
            com.tencent.mm.model.c.XR().f(akVar);
        }
        if (this.ztK != null && this.ztK.equals(str)) {
            ab.i("MicroMsg.ConversationWithCacheAdapter", "convertView:%s, clickUsername:%s", Integer.valueOf(obj2.hashCode()), this.ztK);
            obj2.findViewById(R.id.b6c).setBackground(this.ztL);
        } else if (!i4.yDZ || akVar.field_conversationTime == -1) {
            obj2.findViewById(R.id.b6c).setBackgroundResource(R.drawable.kp);
        } else {
            obj2.findViewById(R.id.b6c).setBackgroundResource(R.drawable.r9);
        }
        if (VERSION.SDK_INT >= 21) {
            obj2.findViewById(R.id.b6c).setOnTouchListener(new OnTouchListener() {
                @TargetApi(21)
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(34362);
                    view.findViewById(R.id.b6c).getBackground().setHotspot(motionEvent.getX(), motionEvent.getY());
                    AppMethodBeat.o(34362);
                    return false;
                }
            });
        }
        com.tencent.mm.bp.d.dlL();
        if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 7, 0) || akVar.field_username.equals(this.zty.cPg.cPj))) {
            akVar.eE(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 6, akVar.field_conversationTime));
            aw.ZK();
            com.tencent.mm.model.c.XR().a(akVar, akVar.field_username);
        }
        if (com.tencent.mm.bg.g.fUs == null || !com.tencent.mm.bg.g.fUs.tN(akVar.field_username)) {
            fVar.yEg.setVisibility(8);
        } else {
            fVar.yEg.setVisibility(0);
            if (akVar.field_username.equals(this.zty.cPg.cPj)) {
                fVar.yEg.setImageResource(R.raw.talk_room_mic_speaking);
            } else {
                fVar.yEg.setImageResource(R.raw.talk_room_mic_idle);
            }
        }
        if (com.tencent.mm.bh.d.fUu == null || !com.tencent.mm.bh.d.fUu.tQ(akVar.field_username)) {
            fVar.zrW.setVisibility(8);
        } else {
            fVar.zrW.setVisibility(0);
        }
        if (t.kH(akVar.field_username) && com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class) != null && ((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RX(akVar.field_username)) {
            if (((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).bRc() && ((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).ff(akVar.field_username, r.Yz())) {
                fVar.zue.setImageResource(R.raw.chatlist_multitalk_highlight_icon);
            } else {
                fVar.zue.setImageResource(R.raw.chatlist_multitalk_icon);
            }
            fVar.zue.setVisibility(0);
        } else {
            fVar.zue.setVisibility(8);
        }
        this.ztP.content = String.valueOf(i4.zrI);
        this.ztP.bCu = i4.eoz;
        this.ztP.zrG = String.valueOf(i4.zrH);
        a aVar2 = this.ztP;
        com.tencent.mm.ui.a.a.a.yqY.a(obj2, aVar2.bCu, aVar2.zrF, aVar2.zrG, aVar2.content);
        obj2.setAlpha(1.0f);
        AppMethodBeat.o(34374);
        return obj2;
    }

    private void a(d dVar, ad adVar) {
        AppMethodBeat.i(34376);
        if (dVar.mgQ && dVar.eoz == null) {
            dVar.nickName = this.context.getString(R.string.ao1);
            AppMethodBeat.o(34376);
        } else if (ad.aox(adVar.field_username)) {
            dVar.nickName = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).e(com.tencent.mm.sdk.platformtools.ah.getContext(), dVar.eoz, com.tencent.mm.bz.a.al(this.context, R.dimen.m5));
            AppMethodBeat.o(34376);
        } else {
            dVar.nickName = j.b(this.context, dVar.eoz, com.tencent.mm.bz.a.al(this.context, R.dimen.m5));
            AppMethodBeat.o(34376);
        }
    }

    static int a(ak akVar, d dVar) {
        AppMethodBeat.i(34377);
        if (akVar == null || akVar.field_unReadCount <= 0) {
            if (akVar == null || (!(akVar.jl(8388608) || akVar.jl(2097152)) || akVar == null || akVar.field_unReadMuteCount <= 0)) {
                AppMethodBeat.o(34377);
                return 0;
            }
            AppMethodBeat.o(34377);
            return 1;
        } else if (!t.ny(akVar.field_username)) {
            if (t.nD(akVar.field_username)) {
                aw.ZK();
                if (!com.tencent.mm.model.c.Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    AppMethodBeat.o(34377);
                    return 1;
                }
            }
            if (t.nH(akVar.field_username)) {
                aw.ZK();
                if (!com.tencent.mm.model.c.Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    AppMethodBeat.o(34377);
                    return 1;
                }
            }
            if (dVar.zrN && dVar.zrS) {
                AppMethodBeat.o(34377);
                return 1;
            } else if (dVar.mgQ && dVar.zrR) {
                AppMethodBeat.o(34377);
                return 1;
            } else {
                AppMethodBeat.o(34377);
                return 2;
            }
        } else if (!s.aVO() || akVar.jl(16) || akVar.jl(64)) {
            AppMethodBeat.o(34377);
            return 1;
        } else {
            AppMethodBeat.o(34377);
            return 0;
        }
    }

    private static int FB(String str) {
        int i = 1;
        AppMethodBeat.i(34378);
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.o(34378);
        return i;
    }

    public final void clearCache() {
        AppMethodBeat.i(34379);
        if (this.yDY != null) {
            this.yDY.clear();
            this.ztG = true;
        }
        AppMethodBeat.o(34379);
    }

    private static String aqV(String str) {
        AppMethodBeat.i(34382);
        if (str == null || str.length() != 32) {
            AppMethodBeat.o(34382);
            return null;
        }
        String Jh = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jh(str);
        AppMethodBeat.o(34382);
        return Jh;
    }

    public final com.tencent.mm.cd.a.d dwz() {
        AppMethodBeat.i(34383);
        ab.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
        aw.ZK();
        com.tencent.mm.cd.a.d dVar = (com.tencent.mm.cd.a.d) com.tencent.mm.model.c.XR().a(t.fkP, this.elZ, com.tencent.mm.o.a.ewS, true);
        AppMethodBeat.o(34383);
        return dVar;
    }

    public final ArrayList<ak> ao(ArrayList<String> arrayList) {
        AppMethodBeat.i(34384);
        ab.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        aw.ZK();
        Cursor a = com.tencent.mm.model.c.XR().a((ArrayList) arrayList, t.fkP, this.elZ, com.tencent.mm.o.a.ewS);
        while (a.moveToNext()) {
            ak akVar = new ak();
            akVar.d(a);
            arrayList2.add(akVar);
        }
        a.close();
        AppMethodBeat.o(34384);
        return arrayList2;
    }

    public final SparseArray<String>[] a(HashSet<com.tencent.mm.ui.f.b<String, ak>> hashSet, SparseArray<String>[] sparseArrayArr) {
        AppMethodBeat.i(34385);
        if (sparseArrayArr == null || sparseArrayArr.length <= 0 || !com.tencent.mm.kernel.g.RK()) {
            AppMethodBeat.o(34385);
        } else {
            com.tencent.mm.ui.f.b bVar;
            ab.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", Integer.valueOf(hashSet.size()), Integer.valueOf(sparseArrayArr[0].size()));
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                bVar = (com.tencent.mm.ui.f.b) it.next();
                if (!(bVar == null || bVar.ygE == 5 || arrayList.contains(bVar.object))) {
                    ab.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + ((String) bVar.object));
                    arrayList.add(bVar.object);
                }
            }
            HashMap hashMap = new HashMap();
            aw.ZK();
            Cursor a = com.tencent.mm.model.c.XR().a(arrayList, t.fkP, this.elZ, com.tencent.mm.o.a.ewS);
            while (a.moveToNext()) {
                ak akVar = new ak();
                akVar.d(a);
                hashMap.put(akVar.field_username, akVar);
            }
            a.close();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                bVar = (com.tencent.mm.ui.f.b) it2.next();
                if (bVar != null) {
                    if (bVar.ygE != 5) {
                        boolean z;
                        String str = "MicroMsg.ConversationWithCacheAdapter";
                        StringBuilder append = new StringBuilder("evnet name,").append((String) bVar.object).append("  event.newObj   ==");
                        if (hashMap.get(bVar.object) == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ab.d(str, append.append(z).toString());
                        bVar.ygF = hashMap.get(bVar.object);
                    } else {
                        bVar.ygF = null;
                    }
                }
            }
            arrayList.clear();
            hashMap.clear();
            HashMap hashMap2 = new HashMap();
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                bVar = (com.tencent.mm.ui.f.b) it3.next();
                if (bVar != null) {
                    a(bVar, sparseArrayArr[0], hashMap2);
                    if (bVar.ygE != 5) {
                        hashMap2.put(bVar.object, bVar.ygF);
                    }
                }
            }
            AppMethodBeat.o(34385);
        }
        return sparseArrayArr;
    }

    private ak d(String str, HashMap<String, ak> hashMap) {
        AppMethodBeat.i(34386);
        ak akVar;
        if (hashMap == null || !hashMap.containsKey(str)) {
            akVar = (ak) cL(str);
            AppMethodBeat.o(34386);
            return akVar;
        }
        akVar = (ak) hashMap.get(str);
        AppMethodBeat.o(34386);
        return akVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f5 A:{LOOP_END, LOOP:4: B:34:0x00f3->B:35:0x00f5} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SparseArray<String> a(com.tencent.mm.ui.f.b<String, ak> bVar, SparseArray<String> sparseArray, HashMap<String, ak> hashMap) {
        int i;
        AppMethodBeat.i(34387);
        String str = (String) bVar.object;
        int size = sparseArray.size();
        ak akVar = (ak) bVar.ygF;
        int size2 = sparseArray.size();
        int i2 = 0;
        while (i2 < size2) {
            if (((String) sparseArray.get(i2)).equals(str)) {
                break;
            }
            i2++;
        }
        i2 = -1;
        ab.d("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d", str, Integer.valueOf(size), Integer.valueOf(i2));
        switch (bVar.ygE) {
            case 2:
                if (akVar == null) {
                    ab.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null");
                    if (i2 >= 0) {
                        ab.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s", str);
                        while (i2 < size - 1) {
                            sparseArray.put(i2, sparseArray.get(i2 + 1));
                            i2++;
                        }
                        sparseArray.remove(size - 1);
                    }
                    AppMethodBeat.o(34387);
                    break;
                } else if (i2 < 0) {
                    i2 = 0;
                    while (i2 < size) {
                        if (d((String) sparseArray.get(i2), hashMap).field_flag > akVar.field_flag) {
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
                    AppMethodBeat.o(34387);
                    break;
                }
                while (i2 < size - 1) {
                    sparseArray.put(i2, sparseArray.get(i2 + 1));
                    i2++;
                }
                sparseArray.remove(size - 1);
        }
        if (i2 < 0) {
            ab.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0");
            AppMethodBeat.o(34387);
        } else {
            ak d = d(str, hashMap);
            if (akVar == null) {
                ab.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s", str);
                while (i2 < size - 1) {
                    sparseArray.put(i2, sparseArray.get(i2 + 1));
                    i2++;
                }
                sparseArray.remove(size - 1);
                AppMethodBeat.o(34387);
            } else {
                long j = d.field_flag;
                long j2 = akVar.field_flag;
                if (j == j2) {
                    AppMethodBeat.o(34387);
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
                        if (d((String) sparseArray.get(i4), hashMap).field_flag <= akVar.field_flag) {
                            z = true;
                            ab.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", Integer.valueOf(size2), Integer.valueOf(i3), Integer.valueOf(-1), Boolean.valueOf(z), Integer.valueOf(i2), str);
                            if (z) {
                                AppMethodBeat.o(34387);
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
                                AppMethodBeat.o(34387);
                            }
                        } else {
                            i4++;
                        }
                    }
                    z = false;
                    ab.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", Integer.valueOf(size2), Integer.valueOf(i3), Integer.valueOf(-1), Boolean.valueOf(z), Integer.valueOf(i2), str);
                    if (z) {
                    }
                }
            }
        }
        return sparseArray;
    }

    public final void a(int i, n nVar, Object obj) {
        int i2 = 0;
        AppMethodBeat.i(34388);
        if (obj == null || !(obj instanceof String)) {
            ab.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(34388);
            return;
        }
        String str = (String) obj;
        if (nVar instanceof be) {
            ab.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", Integer.valueOf(i), str);
            if (!(!str.contains("@") || str.endsWith("@chatroom") || str.endsWith("@im.chatroom") || str.endsWith("@micromsg.qq.com") || ad.aox(str))) {
                i2 = 1;
            }
            if (i2 != 0) {
                AppMethodBeat.o(34388);
                return;
            }
            if (this.yDY != null) {
                if (!obj.equals("")) {
                    this.ztF.add(str);
                } else if (i == 5) {
                    this.ztG = true;
                    super.j(null, 1);
                    AppMethodBeat.o(34388);
                    return;
                }
            }
            if (i == 3) {
                i = 2;
            }
            super.j(str, i);
            AppMethodBeat.o(34388);
            return;
        }
        if (nVar instanceof bd) {
            ab.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s, isIniting %b", Integer.valueOf(i), obj, Boolean.valueOf(this.nNp));
            if (this.nNp) {
                AppMethodBeat.o(34388);
                return;
            }
            this.ztE = true;
            if (i == 5 || i == 2) {
                AppMethodBeat.o(34388);
                return;
            } else if (this.yDY == null || !this.yDY.containsKey(str)) {
                AppMethodBeat.o(34388);
                return;
            } else if (this.ztA != null) {
                this.ztA.add(str);
            }
        }
        AppMethodBeat.o(34388);
    }

    private void dII() {
        AppMethodBeat.i(34389);
        if (this.yDY == null || this.ztA == null || this.ztA.isEmpty()) {
            AppMethodBeat.o(34389);
            return;
        }
        ab.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", Integer.valueOf(this.ztA.size()));
        Iterator it = this.ztA.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            String str = (String) it.next();
            if (!(str == null || str.equals("") || !this.yDY.containsKey(str))) {
                d dVar = (d) this.yDY.get(str);
                if (dVar != null) {
                    this.ztN.ju(str);
                    boolean kH = t.kH(str);
                    ad dIK = this.ztN.dIK();
                    if (dIK != null) {
                        String a = com.tencent.mm.model.s.a(dIK, str, kH);
                        ab.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", a, dVar.eoz);
                        if (!(a == null || a.equals(dVar.eoz))) {
                            dVar.eoz = a;
                            a(dVar, dIK);
                            i = 1;
                        }
                        boolean DX = dIK.DX();
                        kH = dIK.dua == 0;
                        if (!(dVar.zrN == DX && kH == dVar.zrR)) {
                            dVar.zrN = DX;
                            dVar.zrR = kH;
                            dVar.zrS = dIK.Kc();
                            ab.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", str);
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
        AppMethodBeat.o(34389);
    }

    public final boolean dvr() {
        AppMethodBeat.i(34390);
        boolean dvr = super.dvr();
        AppMethodBeat.o(34390);
        return dvr;
    }

    public final boolean arV(String str) {
        AppMethodBeat.i(34391);
        if (this.yDY == null || !this.yDY.containsKey(str)) {
            AppMethodBeat.o(34391);
            return true;
        }
        AppMethodBeat.o(34391);
        return false;
    }

    public final void Pw(int i) {
        AppMethodBeat.i(34392);
        if (i < 0 || i >= getCount()) {
            AppMethodBeat.o(34392);
            return;
        }
        at atVar;
        try {
            atVar = (ak) getItem(i);
        } catch (NullPointerException e) {
            ab.w("MicroMsg.ConversationWithCacheAdapter", "preLoad position:%s is null!", Integer.valueOf(i));
            atVar = null;
        }
        if (atVar == null) {
            AppMethodBeat.o(34392);
            return;
        }
        com.tencent.mm.pluginsdk.ui.a.b.diS().cQ(atVar.field_username);
        AppMethodBeat.o(34392);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(34393);
        if (!this.ztR) {
            super.notifyDataSetChanged();
            this.ztC.clear();
        }
        ab.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
        AppMethodBeat.o(34393);
    }

    private CharSequence h(ak akVar) {
        AppMethodBeat.i(34366);
        CharSequence charSequence;
        if (akVar.field_status == 1) {
            String string = this.context.getString(R.string.cw8);
            AppMethodBeat.o(34366);
            return string;
        } else if (akVar.field_conversationTime == Long.MAX_VALUE) {
            charSequence = "";
            AppMethodBeat.o(34366);
            return charSequence;
        } else {
            charSequence = com.tencent.mm.pluginsdk.f.h.c(this.context, akVar.field_conversationTime, true);
            AppMethodBeat.o(34366);
            return charSequence;
        }
    }

    /* Access modifiers changed, original: final */
    public final d i(ak akVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(34375);
        String str = akVar.field_username;
        if (this.yDY != null) {
            d dVar = (d) this.yDY.get(str);
            if (dVar != null) {
                AppMethodBeat.o(34375);
                return dVar;
            }
        }
        d dVar2 = new d(this, (byte) 0);
        this.ztN.ju(str);
        ad dIK = this.ztN.dIK();
        if (dIK != null) {
            dVar2.zrL = dIK.duk;
            dVar2.zrK = (int) dIK.ewQ;
        } else {
            dVar2.zrL = -1;
            dVar2.zrK = -1;
        }
        if (dIK != null) {
            z = true;
        } else {
            z = false;
        }
        dVar2.zrQ = z;
        if (dIK == null || !dIK.Kc()) {
            z = false;
        } else {
            z = true;
        }
        dVar2.zrS = z;
        if (dIK == null || dIK.dua != 0) {
            z = false;
        } else {
            z = true;
        }
        dVar2.zrR = z;
        dVar2.mgQ = t.mN(str);
        if (dVar2.mgQ && dVar2.zrR && akVar.field_unReadCount > 0) {
            z = true;
        } else {
            z = false;
        }
        dVar2.zrP = z;
        dVar2.klY = 0;
        if (FB(akVar.field_msgType) == 34 && akVar.field_isSend == 0 && !ah.isNullOrNil(akVar.field_content)) {
            String str2 = akVar.field_content;
            if (str.equals("qmessage") || str.equals("floatbottle") || str.equals("officialaccounts") || akVar.jl(2097152) || akVar.jl(8388608)) {
                String[] split = str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (split != null && split.length > 3) {
                    str2 = split[1] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[2] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[3];
                }
            }
            if (!new com.tencent.mm.modelvoice.n(str2).fWX) {
                dVar2.klY = 1;
            }
        }
        if (s.aVO() && t.ny(str)) {
            dVar2.eoz = this.context.getResources().getString(R.string.a_i);
        } else {
            dVar2.eoz = com.tencent.mm.model.s.a(dIK, str, dVar2.mgQ);
        }
        a(dVar2, dIK);
        dVar2.zrH = h(akVar);
        dVar2.zrJ = Pu(akVar.field_status);
        dVar2.zrM = t.a(akVar);
        aw.ZK();
        dVar2.yDZ = com.tencent.mm.model.c.XR().g(akVar);
        if (dIK == null || !dIK.DX()) {
            z2 = false;
        }
        dVar2.zrN = z2;
        if (this.yDY != null) {
            this.yDY.put(str, dVar2);
        }
        AppMethodBeat.o(34375);
        return dVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CharSequence b(ak akVar, int i, boolean z) {
        AppMethodBeat.i(34380);
        if (ah.isNullOrNil(akVar.field_editingMsg) || (akVar.field_atCount > 0 && (akVar.field_unReadCount > 0 || akVar.field_unReadMuteCount > 0))) {
            boolean ny;
            CharSequence spannableString;
            String mJ;
            if (FB(akVar.field_msgType) == Downloads.MIN_WAIT_FOR_NETWORK) {
                ny = t.ny(akVar.field_username);
                if (!ny) {
                    ny = akVar.jl(2097152);
                }
                if (!ny) {
                    ny = akVar.jl(8388608);
                }
                if (!ny) {
                    ny = akVar.jl(16777216);
                }
                if (!ny) {
                    ny = t.nH(akVar.field_username);
                }
                if (!ny) {
                    spannableString = new SpannableString(j.f(this.context, akVar.field_content, i));
                    AppMethodBeat.o(34380);
                    return spannableString;
                }
            }
            if (FB(akVar.field_msgType) == 49) {
                mJ = com.tencent.mm.model.s.mJ(akVar.field_digestUser);
                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(akVar.field_content);
                if (me == null || me.type != 40) {
                    if (me != null && me.type == 5) {
                        mJ = null;
                        try {
                            mJ = String.format(akVar.field_digest, new Object[]{j(akVar)});
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", e, "", new Object[0]);
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        if (ah.isNullOrNil(mJ)) {
                            mJ = this.context.getString(R.string.u9);
                        }
                        spannableString = new SpannableString(j.f(this.context, stringBuilder.append(mJ).append(" ").append(me.title).toString(), i));
                        AppMethodBeat.o(34380);
                        return spannableString;
                    } else if (me != null && me.type == 19) {
                        if (ah.isNullOrNil(mJ)) {
                            spannableString = this.context.getString(R.string.t5);
                        } else {
                            spannableString = mJ + ": " + this.context.getString(R.string.t5);
                        }
                        akVar.jh(spannableString);
                        spannableString = j.b(this.context, spannableString, i);
                        AppMethodBeat.o(34380);
                        return spannableString;
                    }
                } else if (com.tencent.mm.af.n.mj(akVar.field_content).fju == 19) {
                    spannableString = ah.isNullOrNil(mJ) ? this.context.getString(R.string.t5) : mJ + ": " + this.context.getString(R.string.t5);
                    akVar.jh(spannableString);
                    spannableString = j.b(this.context, spannableString, i);
                    AppMethodBeat.o(34380);
                    return spannableString;
                }
            }
            CharSequence charSequence = akVar.field_digest;
            if (charSequence == null || !charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                int i2;
                String str = akVar.field_username;
                if (str.equals("qqmail")) {
                    aw.ZK();
                    if (ah.h((Integer) com.tencent.mm.model.c.Ry().get(17, null)) == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        spannableString = this.context.getString(R.string.e_7);
                        AppMethodBeat.o(34380);
                        return spannableString;
                    }
                }
                if (str.equals("tmessage")) {
                    aw.ZK();
                    bq RA = com.tencent.mm.model.c.XU().RA("@t.qq.com");
                    if (RA == null || !RA.isEnable()) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 == 0) {
                        spannableString = this.context.getString(R.string.e_7);
                        AppMethodBeat.o(34380);
                        return spannableString;
                    }
                }
                if (akVar.field_msgType == null || !akVar.field_msgType.equals("64")) {
                    String str2;
                    if (akVar.field_msgType != null && (akVar.field_msgType.equals("47") || akVar.field_msgType.equals("1048625"))) {
                        str = aqV(akVar.field_digest);
                        mJ = "";
                        if (ah.isNullOrNil(str)) {
                            if (akVar.field_digest != null && akVar.field_digest.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                                mJ = akVar.field_digest.substring(0, akVar.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                                str = aqV(akVar.field_digest.substring(akVar.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1).replace(" ", ""));
                                if (!ah.isNullOrNil(str)) {
                                    str2 = "[" + str + "]";
                                    if (ah.isNullOrNil(mJ)) {
                                        spannableString = j.b(this.context, (CharSequence) mJ, i);
                                        AppMethodBeat.o(34380);
                                        return spannableString;
                                    }
                                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                                    spannableStringBuilder.append(j.b(this.context, (CharSequence) mJ, i));
                                    spannableStringBuilder.append(": ");
                                    spannableStringBuilder.append(str2);
                                    AppMethodBeat.o(34380);
                                    return spannableStringBuilder;
                                }
                            }
                            str = this.context.getString(R.string.ph);
                            if (ah.isNullOrNil(mJ)) {
                                mJ = str;
                            } else {
                                mJ = mJ + ": " + str;
                            }
                            akVar.jh(mJ);
                        } else {
                            spannableString = "[" + str + "]";
                            AppMethodBeat.o(34380);
                            return spannableString;
                        }
                    }
                    if (!ah.isNullOrNil(akVar.field_digest)) {
                        if (ah.isNullOrNil(akVar.field_digestUser)) {
                            mJ = akVar.field_digest;
                        } else {
                            mJ = j(akVar);
                            try {
                                mJ = String.format(akVar.field_digest, new Object[]{mJ});
                            } catch (Exception e2) {
                            }
                        }
                        charSequence = mJ.replace(10, ' ');
                        SpannableStringBuilder spannableStringBuilder2;
                        if (!akVar.jl(33554432) && (akVar.field_unReadCount > 0 || akVar.field_unReadMuteCount > 0)) {
                            spannableString = new SpannableStringBuilder(this.context.getString(R.string.etn));
                            spannableString.setSpan(new ForegroundColorSpan(-5569532), 0, spannableString.length(), 33);
                            spannableString.append(" ").append(j.b(this.context, charSequence, i));
                            AppMethodBeat.o(34380);
                            return spannableString;
                        } else if (akVar.field_UnReadInvite <= 0) {
                            if (akVar.field_UnReadInvite < 4096) {
                                spannableString = this.context.getString(R.string.cve, new Object[]{Integer.valueOf(akVar.field_UnReadInvite)});
                            } else {
                                spannableString = this.context.getString(R.string.cvc);
                            }
                            spannableStringBuilder2 = new SpannableStringBuilder(spannableString);
                            spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
                            spannableStringBuilder2.append(" ").append(j.b(this.context, charSequence, i));
                            AppMethodBeat.o(34380);
                            return spannableStringBuilder2;
                        } else if (akVar.field_atCount > 0 && (akVar.field_unReadCount > 0 || akVar.field_unReadMuteCount > 0)) {
                            spannableStringBuilder2 = new SpannableStringBuilder(this.context.getString(akVar.field_atCount < 4096 ? R.string.cvd : R.string.cvf));
                            spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
                            spannableStringBuilder2.append(" ").append(j.b(this.context, charSequence, i));
                            AppMethodBeat.o(34380);
                            return spannableStringBuilder2;
                        } else if (!akVar.jl(16777216) || (akVar.field_unReadCount <= 0 && akVar.field_unReadMuteCount <= 0)) {
                            if (!z || (akVar.field_unReadCount <= 1 && akVar.field_unReadMuteCount <= 0)) {
                                if (s.aVO() && t.ny(akVar.field_username)) {
                                    ny = akVar.jl(16);
                                    if (akVar.field_unReadCount > 1 || (!ny && akVar.field_unReadCount > 0)) {
                                        if (!ny) {
                                            spannableString = this.context.getString(R.string.cvb, new Object[]{Integer.valueOf(akVar.field_unReadCount), charSequence});
                                        } else if (akVar.jl(32)) {
                                            mJ = this.context.getString(R.string.cva, new Object[]{Integer.valueOf(akVar.field_unReadCount)});
                                            Drawable drawable = this.context.getResources().getDrawable(R.drawable.axl);
                                            drawable.setBounds(0, 0, i, i);
                                            new SpannableString("@").setSpan(new com.tencent.mm.ui.widget.a(drawable), 0, 1, 33);
                                            spannableString = TextUtils.concat(new CharSequence[]{mJ, " ", r4, j.b(this.context, charSequence, i)});
                                            AppMethodBeat.o(34380);
                                            return spannableString;
                                        } else {
                                            spannableString = this.context.getString(R.string.cvg, new Object[]{Integer.valueOf(akVar.field_unReadCount), charSequence});
                                        }
                                    } else if (akVar.jl(32)) {
                                        Drawable drawable2 = this.context.getResources().getDrawable(R.drawable.axl);
                                        drawable2.setBounds(0, 0, i, i);
                                        new SpannableString("@").setSpan(new com.tencent.mm.ui.widget.a(drawable2), 0, 1, 33);
                                        spannableString = TextUtils.concat(new CharSequence[]{r0, j.b(this.context, charSequence, i)});
                                        AppMethodBeat.o(34380);
                                        return spannableString;
                                    }
                                }
                                spannableString = charSequence;
                            } else {
                                spannableString = this.context.getString(R.string.cvg, new Object[]{Integer.valueOf(akVar.field_unReadCount), charSequence});
                            }
                            spannableString = j.b(this.context, spannableString, i);
                            AppMethodBeat.o(34380);
                            return spannableString;
                        } else {
                            str2 = this.context.getString(R.string.b0);
                            charSequence = charSequence.replace(str2, "");
                            spannableString = new SpannableStringBuilder(str2);
                            spannableString.setSpan(new ForegroundColorSpan(-5569532), 0, spannableString.length(), 33);
                            spannableString.append(j.b(this.context, charSequence, i));
                            AppMethodBeat.o(34380);
                            return spannableString;
                        }
                    }
                    mJ = com.tencent.mm.booter.notification.a.h.a(akVar.field_isSend, akVar.field_username, akVar.field_content, FB(akVar.field_msgType), this.context);
                    charSequence = mJ.replace(10, ' ');
                    if (!akVar.jl(33554432)) {
                    }
                    if (akVar.field_UnReadInvite <= 0) {
                    }
                } else {
                    spannableString = akVar.field_content;
                    AppMethodBeat.o(34380);
                    return spannableString;
                }
            }
            spannableString = new SpannableString(j.e(this.context, charSequence, (float) i));
            AppMethodBeat.o(34380);
            return spannableString;
        }
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(this.context.getString(R.string.cvh));
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder3.length(), 33);
        spannableStringBuilder3.append(" ").append(j.b(this.context, akVar.field_editingMsg, i));
        AppMethodBeat.o(34380);
        return spannableStringBuilder3;
    }

    private static String j(ak akVar) {
        AppMethodBeat.i(34381);
        String displayName;
        if (akVar.field_isSend == 0 && t.kH(akVar.field_username)) {
            displayName = com.tencent.mm.model.s.getDisplayName(akVar.field_digestUser, akVar.field_username);
            AppMethodBeat.o(34381);
            return displayName;
        }
        displayName = com.tencent.mm.model.s.mJ(akVar.field_digestUser);
        AppMethodBeat.o(34381);
        return displayName;
    }

    public final /* synthetic */ com.tencent.mm.cd.a.a dvz() {
        AppMethodBeat.i(34394);
        ak akVar = new ak();
        AppMethodBeat.o(34394);
        return akVar;
    }

    static /* synthetic */ void e(h hVar) {
        AppMethodBeat.i(34395);
        if (!hVar.dIG()) {
            ab.w("MicroMsg.ConversationWithCacheAdapter", "is not need dismissClickStatus");
            AppMethodBeat.o(34395);
        } else if (hVar.ztM == null || !hVar.ztM.isRunning()) {
            Object obj;
            for (int i = 0; i < hVar.mListView.getChildCount(); i++) {
                View childAt = hVar.mListView.getChildAt(i);
                if (childAt.getBackground() == hVar.ztL) {
                    obj = childAt;
                    break;
                }
            }
            ab.w("MicroMsg.ConversationWithCacheAdapter", "[findClickStatusView] can't found click view! username:%s", hVar.ztK);
            obj = null;
            if (obj == null) {
                hVar.ztK = null;
                AppMethodBeat.o(34395);
                return;
            }
            ab.i("MicroMsg.ConversationWithCacheAdapter", "[dismissClickStatus] %s username:%s", Integer.valueOf(obj.hashCode()), hVar.ztK);
            final f fVar = (f) obj.getTag();
            Resources resources = obj.getContext().getResources();
            int i2 = (fVar == null || !fVar.yDZ) ? R.color.l6 : R.color.ki;
            hVar.ztL = new ColorDrawable(resources.getColor(i2));
            obj.setBackground(hVar.ztL);
            String str = "alpha";
            int[] iArr = new int[2];
            iArr[0] = 220;
            if (fVar.yDZ) {
                i2 = 100;
            } else {
                i2 = 0;
            }
            iArr[1] = i2;
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, iArr);
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
            ofPropertyValuesHolder.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(34357);
                    h.this.ztL.setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
                    AppMethodBeat.o(34357);
                }
            });
            ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(34358);
                    super.onAnimationEnd(animator);
                    h.a(h.this, obj, fVar);
                    ab.i("MicroMsg.ConversationWithCacheAdapter", "[dismissClickStatus] setBackground back!");
                    AppMethodBeat.o(34358);
                }
            });
            ofPropertyValuesHolder.setDuration(60);
            if (hVar.ztL != null) {
                ofPropertyValuesHolder.start();
                hVar.ztM = ofPropertyValuesHolder;
            }
            AppMethodBeat.o(34395);
        } else {
            ab.w("MicroMsg.ConversationWithCacheAdapter", "[dismissClickStatus] animation is running! %s", hVar.ztK);
            AppMethodBeat.o(34395);
        }
    }
}
