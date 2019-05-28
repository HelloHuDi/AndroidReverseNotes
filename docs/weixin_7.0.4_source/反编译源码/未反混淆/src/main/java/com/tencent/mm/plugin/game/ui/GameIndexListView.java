package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.plugin.game.d.y;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
    b njg;
    private bc njh;
    private boolean nji = true;

    public class a extends h {
        private final Drawable ahS;
        private int mSize;

        public a(Resources resources) {
            AppMethodBeat.i(111971);
            this.ahS = new ColorDrawable(resources.getColor(R.color.pr));
            this.mSize = resources.getDimensionPixelSize(R.dimen.jl);
            AppMethodBeat.o(111971);
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
            AppMethodBeat.i(111972);
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount - 1; i++) {
                View childAt = recyclerView.getChildAt(i);
                View childAt2 = ((ViewGroup) childAt).getChildAt(0);
                if ((childAt2 instanceof GameBestSellingItemView) || (childAt2 instanceof GameBestSellingTitle) || (childAt2 instanceof GameFeedModuleTitle)) {
                    super.a(canvas, recyclerView, sVar);
                } else {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int bottom = layoutParams.bottomMargin + childAt.getBottom();
                    this.ahS.setBounds(paddingLeft, bottom, width, this.mSize + bottom);
                    this.ahS.draw(canvas);
                }
            }
            AppMethodBeat.o(111972);
        }

        public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
            AppMethodBeat.i(111973);
            rect.set(0, 0, 0, this.mSize);
            AppMethodBeat.o(111973);
        }
    }

    public class b extends android.support.v7.widget.RecyclerView.a<a> {
        LinkedList<d> njl = new LinkedList();

        public class a extends v {
            public View contentView;

            public a(View view) {
                super(view);
                AppMethodBeat.i(111974);
                this.contentView = ((ViewGroup) view).getChildAt(0);
                AppMethodBeat.o(111974);
            }
        }

        public b() {
            AppMethodBeat.i(111975);
            AppMethodBeat.o(111975);
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(111976);
            int i2 = ((d) this.njl.get(i)).type;
            AppMethodBeat.o(111976);
            return i2;
        }

        public final int getItemCount() {
            AppMethodBeat.i(111977);
            int size = this.njl.size();
            AppMethodBeat.o(111977);
            return size;
        }
    }

    static /* synthetic */ void a(GameIndexListView gameIndexListView) {
        AppMethodBeat.i(111985);
        gameIndexListView.bFn();
        AppMethodBeat.o(111985);
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
        AppMethodBeat.i(111980);
        super.onFinishInflate();
        ab.d("MicroMsg.GameIndexListView", "onFinishInflate");
        this.nfE = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.mScroller = new Scroller(this.mContext);
        getContext();
        setLayoutManager(new LinearLayoutManager());
        this.njg = new b();
        setAdapter(this.njg);
        b((h) new a(getResources()));
        setLoadingView((int) R.layout.a3s);
        setOnLoadingStateChangedListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a() {
            public final void aMC() {
                AppMethodBeat.i(111969);
                GameIndexListView.a(GameIndexListView.this);
                AppMethodBeat.o(111969);
            }
        });
        fh(true);
        bFn();
        AppMethodBeat.o(111980);
    }

    private void bFn() {
        com.tencent.mm.bt.b bVar;
        com.tencent.mm.vending.e.b bVar2;
        AppMethodBeat.i(111981);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        bb bbVar = new bb();
        if (this.njh != null) {
            bVar = this.njh.nbV;
        } else {
            bVar = null;
        }
        bbVar.nbT = bVar;
        aVar.fsJ = bbVar;
        aVar.fsK = new bc();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
        aVar.fsI = 2943;
        aVar.fsL = 0;
        aVar.fsM = 0;
        com.tencent.mm.ai.b acD = aVar.acD();
        AnonymousClass2 anonymousClass2 = new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(111970);
                ab.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    List list;
                    GameIndexListView.this.njh = (bc) bVar.fsH.fsP;
                    bc b = GameIndexListView.this.njh;
                    boolean c = GameIndexListView.this.nji;
                    if (b == null || bo.ek(b.nbU)) {
                        list = null;
                    } else {
                        LinkedList linkedList = new LinkedList();
                        if (c && !bo.isNullOrNil(b.mZM)) {
                            d dVar = new d();
                            dVar.type = 2000;
                            dVar.mVG = b.mZM;
                            linkedList.add(dVar);
                        }
                        Iterator it = b.nbU.iterator();
                        while (it.hasNext()) {
                            ad adVar = (ad) it.next();
                            d dVar2;
                            if (adVar.mZQ != 7) {
                                dVar2 = new d();
                                dVar2.type = adVar.mZQ;
                                dVar2.position = adVar.mZN;
                                dVar2.mVH = adVar;
                                linkedList.add(dVar2);
                            } else if (!(adVar.naG == null || bo.ek(adVar.naG.mZK))) {
                                if (!bo.isNullOrNil(adVar.naG.Title)) {
                                    dVar2 = new d();
                                    dVar2.mVH = adVar;
                                    dVar2.type = 1000;
                                    linkedList.add(dVar2);
                                }
                                Iterator it2 = adVar.naG.mZK.iterator();
                                while (it2.hasNext()) {
                                    y yVar = (y) it2.next();
                                    d dVar3 = new d();
                                    dVar3.mVH = adVar;
                                    dVar3.type = 1001;
                                    dVar3.mVI = adVar.naG.mZK.indexOf(yVar);
                                    linkedList.add(dVar3);
                                }
                                dVar2 = new d();
                                dVar2.mVH = adVar;
                                dVar2.type = 1002;
                                linkedList.add(dVar2);
                            }
                        }
                        Object list2 = linkedList;
                    }
                    GameIndexListView.this.nji = false;
                    com.tencent.mm.plugin.game.model.ad.a(GameIndexListView.this.njh);
                    if (!GameIndexListView.this.njh.nbW) {
                        GameIndexListView.this.fh(false);
                    }
                    if (!bo.ek(list2)) {
                        b e = GameIndexListView.this.njg;
                        e.njl.addAll(list2);
                        e.aop.notifyChanged();
                    }
                }
                AppMethodBeat.o(111970);
                return 0;
            }
        };
        if (this.mContext instanceof com.tencent.mm.vending.e.b) {
            bVar2 = (com.tencent.mm.vending.e.b) this.mContext;
        } else {
            bVar2 = null;
        }
        w.a(acD, anonymousClass2, false, bVar2);
        AppMethodBeat.o(111981);
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
        AppMethodBeat.i(111982);
        ab.d("MicroMsg.GameIndexListView", "onLayout, changed = ".concat(String.valueOf(z)));
        super.onLayout(z, i, i2, i3, i4);
        if (nfC || this.abB == null || this.nfK == null || this.nfJ == null) {
            this.abB = getChildAt(0);
            if (this.abB != null) {
                this.abB.setPadding(0, njj, 0, 0);
                this.nfK = (ImageView) this.abB.findViewById(R.id.c6v);
                this.nfJ = (ImageView) this.abB.findViewById(R.id.c5j);
            }
            nfC = false;
        }
        AppMethodBeat.o(111982);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(111983);
        boolean dispatchTouchEvent;
        if (!nfG || this.abB == null) {
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(111983);
            return dispatchTouchEvent;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.nfH = false;
                this.nfD = motionEvent.getRawY();
                break;
            case 2:
                if (((LinearLayoutManager) getLayoutManager()).iQ() == 0 && this.abB != null && this.abB.getTop() == 0) {
                    dispatchTouchEvent = true;
                } else {
                    dispatchTouchEvent = false;
                }
                if (dispatchTouchEvent) {
                    if (this.nfH) {
                        AppMethodBeat.o(111983);
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
                            AppMethodBeat.o(111983);
                            return true;
                        }
                    } else if (this.abB.getPaddingTop() >= (-this.nfE) && rawY < 0 && Math.abs(rawY) >= this.nfE) {
                        this.nfH = true;
                        this.mScroller.startScroll(0, 0, 0, nfI, 500);
                        invalidate();
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        AppMethodBeat.o(111983);
                        return true;
                    }
                }
                break;
        }
        dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(111983);
        return dispatchTouchEvent;
    }

    public void computeScroll() {
        AppMethodBeat.i(111984);
        if (this.abB == null) {
            AppMethodBeat.o(111984);
            return;
        }
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            ab.d("MicroMsg.GameIndexListView", "computeScroll, currY = ".concat(String.valueOf(currY)));
            this.abB.setPadding(0, currY, 0, 0);
            float f = (((float) (nfI - currY)) / ((float) nfI)) * 255.0f;
            int i = 255 - ((int) f);
            currY = (int) f;
            this.nfK.setAlpha(i);
            this.nfJ.setAlpha(currY);
            invalidate();
        }
        AppMethodBeat.o(111984);
    }
}
