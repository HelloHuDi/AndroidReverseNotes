package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.C11052a;
import com.tencent.p177mm.plugin.game.model.C28226d;
import com.tencent.p177mm.plugin.game.model.C41285ad;
import com.tencent.p177mm.plugin.game.p731d.C12110ad;
import com.tencent.p177mm.plugin.game.p731d.C12123y;
import com.tencent.p177mm.plugin.game.p731d.C39188bb;
import com.tencent.p177mm.plugin.game.p731d.C43160bc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p639e.C5685b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.ui.GameIndexListView */
public class GameIndexListView extends LoadMoreRecyclerView {
    private static boolean nfC = true;
    private static boolean nfG;
    private static int nfI = 0;
    private static int nja = 0;
    private static int njj = 0;
    private View abB;
    private Context mContext;
    private Scroller mScroller;
    private float nfD;
    private int nfE;
    private boolean nfH;
    private ImageView nfJ;
    private ImageView nfK;
    C39228b njg;
    private C43160bc njh;
    private boolean nji = true;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexListView$1 */
    class C210201 implements C11052a {
        C210201() {
        }

        public final void aMC() {
            AppMethodBeat.m2504i(111969);
            GameIndexListView.m66837a(GameIndexListView.this);
            AppMethodBeat.m2505o(111969);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexListView$2 */
    class C282492 implements C1224a {
        C282492() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(111970);
            C4990ab.m7417i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                List list;
                GameIndexListView.this.njh = (C43160bc) c7472b.fsH.fsP;
                C43160bc b = GameIndexListView.this.njh;
                boolean c = GameIndexListView.this.nji;
                if (b == null || C5046bo.m7548ek(b.nbU)) {
                    list = null;
                } else {
                    LinkedList linkedList = new LinkedList();
                    if (c && !C5046bo.isNullOrNil(b.mZM)) {
                        C28226d c28226d = new C28226d();
                        c28226d.type = 2000;
                        c28226d.mVG = b.mZM;
                        linkedList.add(c28226d);
                    }
                    Iterator it = b.nbU.iterator();
                    while (it.hasNext()) {
                        C12110ad c12110ad = (C12110ad) it.next();
                        C28226d c28226d2;
                        if (c12110ad.mZQ != 7) {
                            c28226d2 = new C28226d();
                            c28226d2.type = c12110ad.mZQ;
                            c28226d2.position = c12110ad.mZN;
                            c28226d2.mVH = c12110ad;
                            linkedList.add(c28226d2);
                        } else if (!(c12110ad.naG == null || C5046bo.m7548ek(c12110ad.naG.mZK))) {
                            if (!C5046bo.isNullOrNil(c12110ad.naG.Title)) {
                                c28226d2 = new C28226d();
                                c28226d2.mVH = c12110ad;
                                c28226d2.type = 1000;
                                linkedList.add(c28226d2);
                            }
                            Iterator it2 = c12110ad.naG.mZK.iterator();
                            while (it2.hasNext()) {
                                C12123y c12123y = (C12123y) it2.next();
                                C28226d c28226d3 = new C28226d();
                                c28226d3.mVH = c12110ad;
                                c28226d3.type = 1001;
                                c28226d3.mVI = c12110ad.naG.mZK.indexOf(c12123y);
                                linkedList.add(c28226d3);
                            }
                            c28226d2 = new C28226d();
                            c28226d2.mVH = c12110ad;
                            c28226d2.type = 1002;
                            linkedList.add(c28226d2);
                        }
                    }
                    Object list2 = linkedList;
                }
                GameIndexListView.this.nji = false;
                C41285ad.m71915a(GameIndexListView.this.njh);
                if (!GameIndexListView.this.njh.nbW) {
                    GameIndexListView.this.mo22757fh(false);
                }
                if (!C5046bo.m7548ek(list2)) {
                    C39228b e = GameIndexListView.this.njg;
                    e.njl.addAll(list2);
                    e.aop.notifyChanged();
                }
            }
            AppMethodBeat.m2505o(111970);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexListView$a */
    public class C39227a extends C25373h {
        private final Drawable ahS;
        private int mSize;

        public C39227a(Resources resources) {
            AppMethodBeat.m2504i(111971);
            this.ahS = new ColorDrawable(resources.getColor(C25738R.color.f12022pr));
            this.mSize = resources.getDimensionPixelSize(C25738R.dimen.f9901jl);
            AppMethodBeat.m2505o(111971);
        }

        /* renamed from: a */
        public final void mo6920a(Canvas canvas, RecyclerView recyclerView, C31880s c31880s) {
            AppMethodBeat.m2504i(111972);
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount - 1; i++) {
                View childAt = recyclerView.getChildAt(i);
                View childAt2 = ((ViewGroup) childAt).getChildAt(0);
                if ((childAt2 instanceof GameBestSellingItemView) || (childAt2 instanceof GameBestSellingTitle) || (childAt2 instanceof GameFeedModuleTitle)) {
                    super.mo6920a(canvas, recyclerView, c31880s);
                } else {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int bottom = layoutParams.bottomMargin + childAt.getBottom();
                    this.ahS.setBounds(paddingLeft, bottom, width, this.mSize + bottom);
                    this.ahS.draw(canvas);
                }
            }
            AppMethodBeat.m2505o(111972);
        }

        /* renamed from: a */
        public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
            AppMethodBeat.m2504i(111973);
            rect.set(0, 0, 0, this.mSize);
            AppMethodBeat.m2505o(111973);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexListView$b */
    public class C39228b extends C41523a<C12181a> {
        LinkedList<C28226d> njl = new LinkedList();

        /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexListView$b$a */
        public class C12181a extends C41531v {
            public View contentView;

            public C12181a(View view) {
                super(view);
                AppMethodBeat.m2504i(111974);
                this.contentView = ((ViewGroup) view).getChildAt(0);
                AppMethodBeat.m2505o(111974);
            }
        }

        public C39228b() {
            AppMethodBeat.m2504i(111975);
            AppMethodBeat.m2505o(111975);
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(111976);
            int i2 = ((C28226d) this.njl.get(i)).type;
            AppMethodBeat.m2505o(111976);
            return i2;
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(111977);
            int size = this.njl.size();
            AppMethodBeat.m2505o(111977);
            return size;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m66837a(GameIndexListView gameIndexListView) {
        AppMethodBeat.m2504i(111985);
        gameIndexListView.bFn();
        AppMethodBeat.m2505o(111985);
    }

    public static void setSourceScene(int i) {
        nja = i;
    }

    public static int getSourceScene() {
        return nja;
    }

    public GameIndexListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111980);
        super.onFinishInflate();
        C4990ab.m7410d("MicroMsg.GameIndexListView", "onFinishInflate");
        this.nfE = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.mScroller = new Scroller(this.mContext);
        getContext();
        setLayoutManager(new LinearLayoutManager());
        this.njg = new C39228b();
        setAdapter(this.njg);
        mo66346b((C25373h) new C39227a(getResources()));
        setLoadingView(2130969708);
        setOnLoadingStateChangedListener(new C210201());
        mo22757fh(true);
        bFn();
        AppMethodBeat.m2505o(111980);
    }

    private void bFn() {
        C1332b c1332b;
        C5685b c5685b;
        AppMethodBeat.m2504i(111981);
        C1196a c1196a = new C1196a();
        C39188bb c39188bb = new C39188bb();
        if (this.njh != null) {
            c1332b = this.njh.nbV;
        } else {
            c1332b = null;
        }
        c39188bb.nbT = c1332b;
        c1196a.fsJ = c39188bb;
        c1196a.fsK = new C43160bc();
        c1196a.uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
        c1196a.fsI = 2943;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        C282492 c282492 = new C282492();
        if (this.mContext instanceof C5685b) {
            c5685b = (C5685b) this.mContext;
        } else {
            c5685b = null;
        }
        C1226w.m2656a(acD, c282492, false, c5685b);
        AppMethodBeat.m2505o(111981);
    }

    public static void setCanPulldown(boolean z) {
        nfG = z;
    }

    public static void setDefaultPadding(int i) {
        nfI = i;
    }

    public static void setInitPadding(int i) {
        njj = i;
        nfC = true;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(111982);
        C4990ab.m7410d("MicroMsg.GameIndexListView", "onLayout, changed = ".concat(String.valueOf(z)));
        super.onLayout(z, i, i2, i3, i4);
        if (nfC || this.abB == null || this.nfK == null || this.nfJ == null) {
            this.abB = getChildAt(0);
            if (this.abB != null) {
                this.abB.setPadding(0, njj, 0, 0);
                this.nfK = (ImageView) this.abB.findViewById(2131824535);
                this.nfJ = (ImageView) this.abB.findViewById(2131824486);
            }
            nfC = false;
        }
        AppMethodBeat.m2505o(111982);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(111983);
        boolean dispatchTouchEvent;
        if (!nfG || this.abB == null) {
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.m2505o(111983);
            return dispatchTouchEvent;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.nfH = false;
                this.nfD = motionEvent.getRawY();
                break;
            case 2:
                if (((LinearLayoutManager) getLayoutManager()).mo1780iQ() == 0 && this.abB != null && this.abB.getTop() == 0) {
                    dispatchTouchEvent = true;
                } else {
                    dispatchTouchEvent = false;
                }
                if (dispatchTouchEvent) {
                    if (this.nfH) {
                        AppMethodBeat.m2505o(111983);
                        return true;
                    }
                    int rawY = (int) (motionEvent.getRawY() - this.nfD);
                    if (this.abB.getPaddingTop() <= nfI + this.nfE) {
                        if (rawY > 0 && Math.abs(rawY) >= this.nfE) {
                            this.nfH = true;
                            this.mScroller.startScroll(0, this.abB.getPaddingTop(), 0, -this.abB.getPaddingTop(), 500);
                            this.nfJ.setClickable(true);
                            invalidate();
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            AppMethodBeat.m2505o(111983);
                            return true;
                        }
                    } else if (this.abB.getPaddingTop() >= (-this.nfE) && rawY < 0 && Math.abs(rawY) >= this.nfE) {
                        this.nfH = true;
                        this.mScroller.startScroll(0, 0, 0, nfI, 500);
                        invalidate();
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        AppMethodBeat.m2505o(111983);
                        return true;
                    }
                }
                break;
        }
        dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(111983);
        return dispatchTouchEvent;
    }

    public void computeScroll() {
        AppMethodBeat.m2504i(111984);
        if (this.abB == null) {
            AppMethodBeat.m2505o(111984);
            return;
        }
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            C4990ab.m7410d("MicroMsg.GameIndexListView", "computeScroll, currY = ".concat(String.valueOf(currY)));
            this.abB.setPadding(0, currY, 0, 0);
            float f = (((float) (nfI - currY)) / ((float) nfI)) * 255.0f;
            int i = 255 - ((int) f);
            currY = (int) f;
            this.nfK.setAlpha(i);
            this.nfJ.setAlpha(currY);
            invalidate();
        }
        AppMethodBeat.m2505o(111984);
    }
}
