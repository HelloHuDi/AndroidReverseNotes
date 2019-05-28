package android.support.p069v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.p057v4.widget.NestedScrollView;
import android.support.p057v4.widget.NestedScrollView.C0509b;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.p177mm.C25738R;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.app.AlertController */
public final class AlertController {
    /* renamed from: Ei */
    ListAdapter f798Ei;
    /* renamed from: IT */
    CharSequence f799IT;
    /* renamed from: TA */
    CharSequence f800TA;
    /* renamed from: TB */
    Message f801TB;
    /* renamed from: TC */
    Drawable f802TC;
    /* renamed from: TD */
    NestedScrollView f803TD;
    /* renamed from: TE */
    int f804TE = 0;
    /* renamed from: TF */
    TextView f805TF;
    /* renamed from: TG */
    View f806TG;
    /* renamed from: TH */
    int f807TH = -1;
    /* renamed from: TI */
    int f808TI;
    /* renamed from: TJ */
    int f809TJ;
    /* renamed from: TK */
    int f810TK;
    /* renamed from: TL */
    int f811TL;
    /* renamed from: TM */
    int f812TM;
    /* renamed from: TN */
    int f813TN;
    /* renamed from: TO */
    boolean f814TO;
    /* renamed from: TP */
    int f815TP = 0;
    /* renamed from: TQ */
    final OnClickListener f816TQ = new C05571();
    /* renamed from: Th */
    final C6218i f817Th;
    /* renamed from: Ti */
    final Window f818Ti;
    /* renamed from: Tj */
    final int f819Tj;
    /* renamed from: Tk */
    CharSequence f820Tk;
    /* renamed from: Tl */
    int f821Tl;
    /* renamed from: Tm */
    int f822Tm;
    /* renamed from: Tn */
    int f823Tn;
    /* renamed from: To */
    int f824To;
    /* renamed from: Tp */
    int f825Tp;
    /* renamed from: Tq */
    boolean f826Tq = false;
    /* renamed from: Tr */
    public Button f827Tr;
    /* renamed from: Ts */
    CharSequence f828Ts;
    /* renamed from: Tt */
    Message f829Tt;
    /* renamed from: Tu */
    Drawable f830Tu;
    /* renamed from: Tv */
    public Button f831Tv;
    /* renamed from: Tw */
    CharSequence f832Tw;
    /* renamed from: Tx */
    Message f833Tx;
    /* renamed from: Ty */
    Drawable f834Ty;
    /* renamed from: Tz */
    public Button f835Tz;
    final Context mContext;
    Handler mHandler;
    ListView mListView;
    View mView;
    /* renamed from: ma */
    TextView f836ma;
    /* renamed from: rP */
    Drawable f837rP;
    /* renamed from: sX */
    ImageView f838sX;

    /* renamed from: android.support.v7.app.AlertController$1 */
    class C05571 implements OnClickListener {
        C05571() {
        }

        public final void onClick(View view) {
            Message obtain;
            if (view == AlertController.this.f827Tr && AlertController.this.f829Tt != null) {
                obtain = Message.obtain(AlertController.this.f829Tt);
            } else if (view == AlertController.this.f831Tv && AlertController.this.f833Tx != null) {
                obtain = Message.obtain(AlertController.this.f833Tx);
            } else if (view != AlertController.this.f835Tz || AlertController.this.f801TB == null) {
                obtain = null;
            } else {
                obtain = Message.obtain(AlertController.this.f801TB);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController.this.mHandler.obtainMessage(1, AlertController.this.f817Th).sendToTarget();
        }
    }

    /* renamed from: android.support.v7.app.AlertController$3 */
    class C05583 implements Runnable {
        /* renamed from: TS */
        final /* synthetic */ View f738TS;
        /* renamed from: TT */
        final /* synthetic */ View f739TT;

        C05583(View view, View view2) {
            this.f738TS = view;
            this.f739TT = view2;
        }

        public final void run() {
            AlertController.m1238a(AlertController.this.f803TD, this.f738TS, this.f739TT);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$4 */
    class C05594 implements OnScrollListener {
        /* renamed from: TS */
        final /* synthetic */ View f741TS;
        /* renamed from: TT */
        final /* synthetic */ View f742TT;

        C05594(View view, View view2) {
            this.f741TS = view;
            this.f742TT = view2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AlertController.m1238a(absListView, this.f741TS, this.f742TT);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$5 */
    class C05605 implements Runnable {
        /* renamed from: TS */
        final /* synthetic */ View f744TS;
        /* renamed from: TT */
        final /* synthetic */ View f745TT;

        C05605(View view, View view2) {
            this.f744TS = view;
            this.f745TT = view2;
        }

        public final void run() {
            AlertController.m1238a(AlertController.this.mListView, this.f744TS, this.f745TT);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$RecycleListView */
    public static class RecycleListView extends ListView {
        /* renamed from: Ux */
        final int f746Ux;
        /* renamed from: Uy */
        final int f747Uy;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0554a.RecycleListView);
            this.f747Uy = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.f746Ux = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$a */
    public static class C0565a {
        /* renamed from: Ei */
        public ListAdapter f760Ei;
        /* renamed from: IT */
        public CharSequence f761IT;
        /* renamed from: PI */
        public Cursor f762PI;
        /* renamed from: TE */
        public int f763TE = 0;
        /* renamed from: TG */
        public View f764TG;
        /* renamed from: TH */
        public int f765TH = -1;
        /* renamed from: TU */
        public int f766TU = 0;
        /* renamed from: TV */
        public CharSequence f767TV;
        /* renamed from: TW */
        public Drawable f768TW;
        /* renamed from: TX */
        public DialogInterface.OnClickListener f769TX;
        /* renamed from: TY */
        public CharSequence f770TY;
        /* renamed from: TZ */
        public Drawable f771TZ;
        /* renamed from: Tk */
        public CharSequence f772Tk;
        /* renamed from: Tl */
        public int f773Tl;
        /* renamed from: Tm */
        public int f774Tm;
        /* renamed from: Tn */
        public int f775Tn;
        /* renamed from: To */
        public int f776To;
        /* renamed from: Tp */
        public int f777Tp;
        /* renamed from: Tq */
        public boolean f778Tq = false;
        /* renamed from: Ua */
        public DialogInterface.OnClickListener f779Ua;
        /* renamed from: Ub */
        public CharSequence f780Ub;
        /* renamed from: Uc */
        public Drawable f781Uc;
        /* renamed from: Ud */
        public DialogInterface.OnClickListener f782Ud;
        /* renamed from: Ue */
        public OnCancelListener f783Ue;
        /* renamed from: Uf */
        public OnDismissListener f784Uf;
        /* renamed from: Ug */
        public OnKeyListener f785Ug;
        /* renamed from: Uh */
        public CharSequence[] f786Uh;
        /* renamed from: Ui */
        public DialogInterface.OnClickListener f787Ui;
        /* renamed from: Uj */
        public boolean[] f788Uj;
        /* renamed from: Uk */
        public boolean f789Uk;
        /* renamed from: Ul */
        public boolean f790Ul;
        /* renamed from: Um */
        public OnMultiChoiceClickListener f791Um;
        /* renamed from: Un */
        public String f792Un;
        /* renamed from: Uo */
        public String f793Uo;
        /* renamed from: Up */
        public OnItemSelectedListener f794Up;
        /* renamed from: Uq */
        public boolean f795Uq = true;
        public boolean mCancelable;
        public final Context mContext;
        public final LayoutInflater mInflater;
        public View mView;
        /* renamed from: rP */
        public Drawable f796rP;

        /* renamed from: android.support.v7.app.AlertController$a$1 */
        class C05611 extends ArrayAdapter<CharSequence> {
            /* renamed from: Ur */
            final /* synthetic */ RecycleListView f748Ur;

            C05611(Context context, int i, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                this.f748Ur = recycleListView;
                super(context, i, 16908308, charSequenceArr);
            }

            public final View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                if (C0565a.this.f788Uj != null && C0565a.this.f788Uj[i]) {
                    this.f748Ur.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* renamed from: android.support.v7.app.AlertController$a$2 */
        class C05622 extends CursorAdapter {
            /* renamed from: Ur */
            final /* synthetic */ RecycleListView f750Ur;
            /* renamed from: Ut */
            private final int f752Ut;
            /* renamed from: Uu */
            private final int f753Uu;
            /* renamed from: Uv */
            final /* synthetic */ AlertController f754Uv;

            C05622(Context context, Cursor cursor, RecycleListView recycleListView, AlertController alertController) {
                this.f750Ur = recycleListView;
                this.f754Uv = alertController;
                super(context, cursor, false);
                Cursor cursor2 = getCursor();
                this.f752Ut = cursor2.getColumnIndexOrThrow(C0565a.this.f792Un);
                this.f753Uu = cursor2.getColumnIndexOrThrow(C0565a.this.f793Uo);
            }

            public final void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f752Ut));
                this.f750Ur.setItemChecked(cursor.getPosition(), cursor.getInt(this.f753Uu) == 1);
            }

            public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return C0565a.this.mInflater.inflate(this.f754Uv.f811TL, viewGroup, false);
            }
        }

        /* renamed from: android.support.v7.app.AlertController$a$3 */
        class C05633 implements OnItemClickListener {
            /* renamed from: Uv */
            final /* synthetic */ AlertController f756Uv;

            C05633(AlertController alertController) {
                this.f756Uv = alertController;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                C0565a.this.f787Ui.onClick(this.f756Uv.f817Th, i);
                if (!C0565a.this.f790Ul) {
                    this.f756Uv.f817Th.dismiss();
                }
            }
        }

        /* renamed from: android.support.v7.app.AlertController$a$4 */
        class C05644 implements OnItemClickListener {
            /* renamed from: Ur */
            final /* synthetic */ RecycleListView f757Ur;
            /* renamed from: Uv */
            final /* synthetic */ AlertController f759Uv;

            C05644(RecycleListView recycleListView, AlertController alertController) {
                this.f757Ur = recycleListView;
                this.f759Uv = alertController;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (C0565a.this.f788Uj != null) {
                    C0565a.this.f788Uj[i] = this.f757Ur.isItemChecked(i);
                }
                C0565a.this.f791Um.onClick(this.f759Uv.f817Th, i, this.f757Ur.isItemChecked(i));
            }
        }

        public C0565a(Context context) {
            this.mContext = context;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    /* renamed from: android.support.v7.app.AlertController$b */
    static final class C0566b extends Handler {
        /* renamed from: Uw */
        private WeakReference<DialogInterface> f797Uw;

        public C0566b(DialogInterface dialogInterface) {
            this.f797Uw = new WeakReference(dialogInterface);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f797Uw.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: android.support.v7.app.AlertController$c */
    static class C0567c extends ArrayAdapter<CharSequence> {
        public C0567c(Context context, int i, CharSequence[] charSequenceArr) {
            super(context, i, 16908308, charSequenceArr);
        }

        public final boolean hasStableIds() {
            return true;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    /* renamed from: android.support.v7.app.AlertController$2 */
    class C05682 implements C0509b {
        /* renamed from: TS */
        final /* synthetic */ View f840TS;
        /* renamed from: TT */
        final /* synthetic */ View f841TT;

        C05682(View view, View view2) {
            this.f840TS = view;
            this.f841TT = view2;
        }

        /* renamed from: a */
        public final void mo1231a(NestedScrollView nestedScrollView) {
            AlertController.m1238a(nestedScrollView, this.f840TS, this.f841TT);
        }
    }

    public AlertController(Context context, C6218i c6218i, Window window) {
        this.mContext = context;
        this.f817Th = c6218i;
        this.f818Ti = window;
        this.mHandler = new C0566b(c6218i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0554a.AlertDialog, C25738R.attr.f5690fv, 0);
        this.f808TI = obtainStyledAttributes.getResourceId(0, 0);
        this.f809TJ = obtainStyledAttributes.getResourceId(1, 0);
        this.f810TK = obtainStyledAttributes.getResourceId(2, 0);
        this.f811TL = obtainStyledAttributes.getResourceId(3, 0);
        this.f812TM = obtainStyledAttributes.getResourceId(4, 0);
        this.f813TN = obtainStyledAttributes.getResourceId(5, 0);
        this.f814TO = obtainStyledAttributes.getBoolean(6, true);
        this.f819Tj = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        obtainStyledAttributes.recycle();
        c6218i.mo14042fA();
    }

    /* renamed from: aQ */
    static boolean m1240aQ(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (AlertController.m1240aQ(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f799IT = charSequence;
        if (this.f805TF != null) {
            this.f805TF.setText(charSequence);
        }
    }

    /* renamed from: a */
    public final void mo1378a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f800TA = charSequence;
                this.f801TB = message;
                this.f802TC = drawable;
                return;
            case -2:
                this.f832Tw = charSequence;
                this.f833Tx = message;
                this.f834Ty = drawable;
                return;
            case -1:
                this.f828Ts = charSequence;
                this.f829Tt = message;
                this.f830Tu = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void setIcon(int i) {
        this.f837rP = null;
        this.f804TE = i;
        if (this.f838sX == null) {
            return;
        }
        if (i != 0) {
            this.f838sX.setVisibility(0);
            this.f838sX.setImageResource(this.f804TE);
            return;
        }
        this.f838sX.setVisibility(8);
    }

    /* renamed from: c */
    static ViewGroup m1241c(View view, View view2) {
        View inflate;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                inflate = ((ViewStub) view2).inflate();
            } else {
                inflate = view2;
            }
            return (ViewGroup) inflate;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            inflate = ((ViewStub) view).inflate();
        } else {
            inflate = view;
        }
        return (ViewGroup) inflate;
    }

    /* renamed from: a */
    static void m1238a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    /* renamed from: a */
    static void m1239a(Button button) {
        LayoutParams layoutParams = (LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
