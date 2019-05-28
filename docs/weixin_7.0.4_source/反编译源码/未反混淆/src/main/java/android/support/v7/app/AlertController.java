package android.support.v7.app;

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
import android.support.v4.widget.NestedScrollView;
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
import com.tencent.mm.R;
import java.lang.ref.WeakReference;

public final class AlertController {
    ListAdapter Ei;
    CharSequence IT;
    CharSequence TA;
    Message TB;
    Drawable TC;
    NestedScrollView TD;
    int TE = 0;
    TextView TF;
    View TG;
    int TH = -1;
    int TI;
    int TJ;
    int TK;
    int TL;
    int TM;
    int TN;
    boolean TO;
    int TP = 0;
    final OnClickListener TQ = new OnClickListener() {
        public final void onClick(View view) {
            Message obtain;
            if (view == AlertController.this.Tr && AlertController.this.Tt != null) {
                obtain = Message.obtain(AlertController.this.Tt);
            } else if (view == AlertController.this.Tv && AlertController.this.Tx != null) {
                obtain = Message.obtain(AlertController.this.Tx);
            } else if (view != AlertController.this.Tz || AlertController.this.TB == null) {
                obtain = null;
            } else {
                obtain = Message.obtain(AlertController.this.TB);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController.this.mHandler.obtainMessage(1, AlertController.this.Th).sendToTarget();
        }
    };
    final i Th;
    final Window Ti;
    final int Tj;
    CharSequence Tk;
    int Tl;
    int Tm;
    int Tn;
    int To;
    int Tp;
    boolean Tq = false;
    public Button Tr;
    CharSequence Ts;
    Message Tt;
    Drawable Tu;
    public Button Tv;
    CharSequence Tw;
    Message Tx;
    Drawable Ty;
    public Button Tz;
    final Context mContext;
    Handler mHandler;
    ListView mListView;
    View mView;
    TextView ma;
    Drawable rP;
    ImageView sX;

    /* renamed from: android.support.v7.app.AlertController$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ View TS;
        final /* synthetic */ View TT;

        AnonymousClass3(View view, View view2) {
            this.TS = view;
            this.TT = view2;
        }

        public final void run() {
            AlertController.a(AlertController.this.TD, this.TS, this.TT);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$4 */
    class AnonymousClass4 implements OnScrollListener {
        final /* synthetic */ View TS;
        final /* synthetic */ View TT;

        AnonymousClass4(View view, View view2) {
            this.TS = view;
            this.TT = view2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AlertController.a(absListView, this.TS, this.TT);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ View TS;
        final /* synthetic */ View TT;

        AnonymousClass5(View view, View view2) {
            this.TS = view;
            this.TT = view2;
        }

        public final void run() {
            AlertController.a(AlertController.this.mListView, this.TS, this.TT);
        }
    }

    public static class RecycleListView extends ListView {
        final int Ux;
        final int Uy;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.a.a.a.RecycleListView);
            this.Uy = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.Ux = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }
    }

    public static class a {
        public ListAdapter Ei;
        public CharSequence IT;
        public Cursor PI;
        public int TE = 0;
        public View TG;
        public int TH = -1;
        public int TU = 0;
        public CharSequence TV;
        public Drawable TW;
        public DialogInterface.OnClickListener TX;
        public CharSequence TY;
        public Drawable TZ;
        public CharSequence Tk;
        public int Tl;
        public int Tm;
        public int Tn;
        public int To;
        public int Tp;
        public boolean Tq = false;
        public DialogInterface.OnClickListener Ua;
        public CharSequence Ub;
        public Drawable Uc;
        public DialogInterface.OnClickListener Ud;
        public OnCancelListener Ue;
        public OnDismissListener Uf;
        public OnKeyListener Ug;
        public CharSequence[] Uh;
        public DialogInterface.OnClickListener Ui;
        public boolean[] Uj;
        public boolean Uk;
        public boolean Ul;
        public OnMultiChoiceClickListener Um;
        public String Un;
        public String Uo;
        public OnItemSelectedListener Up;
        public boolean Uq = true;
        public boolean mCancelable;
        public final Context mContext;
        public final LayoutInflater mInflater;
        public View mView;
        public Drawable rP;

        /* renamed from: android.support.v7.app.AlertController$a$1 */
        class AnonymousClass1 extends ArrayAdapter<CharSequence> {
            final /* synthetic */ RecycleListView Ur;

            AnonymousClass1(Context context, int i, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                this.Ur = recycleListView;
                super(context, i, 16908308, charSequenceArr);
            }

            public final View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                if (a.this.Uj != null && a.this.Uj[i]) {
                    this.Ur.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* renamed from: android.support.v7.app.AlertController$a$2 */
        class AnonymousClass2 extends CursorAdapter {
            final /* synthetic */ RecycleListView Ur;
            private final int Ut;
            private final int Uu;
            final /* synthetic */ AlertController Uv;

            AnonymousClass2(Context context, Cursor cursor, RecycleListView recycleListView, AlertController alertController) {
                this.Ur = recycleListView;
                this.Uv = alertController;
                super(context, cursor, false);
                Cursor cursor2 = getCursor();
                this.Ut = cursor2.getColumnIndexOrThrow(a.this.Un);
                this.Uu = cursor2.getColumnIndexOrThrow(a.this.Uo);
            }

            public final void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.Ut));
                this.Ur.setItemChecked(cursor.getPosition(), cursor.getInt(this.Uu) == 1);
            }

            public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return a.this.mInflater.inflate(this.Uv.TL, viewGroup, false);
            }
        }

        /* renamed from: android.support.v7.app.AlertController$a$3 */
        class AnonymousClass3 implements OnItemClickListener {
            final /* synthetic */ AlertController Uv;

            AnonymousClass3(AlertController alertController) {
                this.Uv = alertController;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a.this.Ui.onClick(this.Uv.Th, i);
                if (!a.this.Ul) {
                    this.Uv.Th.dismiss();
                }
            }
        }

        /* renamed from: android.support.v7.app.AlertController$a$4 */
        class AnonymousClass4 implements OnItemClickListener {
            final /* synthetic */ RecycleListView Ur;
            final /* synthetic */ AlertController Uv;

            AnonymousClass4(RecycleListView recycleListView, AlertController alertController) {
                this.Ur = recycleListView;
                this.Uv = alertController;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (a.this.Uj != null) {
                    a.this.Uj[i] = this.Ur.isItemChecked(i);
                }
                a.this.Um.onClick(this.Uv.Th, i, this.Ur.isItemChecked(i));
            }
        }

        public a(Context context) {
            this.mContext = context;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    static final class b extends Handler {
        private WeakReference<DialogInterface> Uw;

        public b(DialogInterface dialogInterface) {
            this.Uw = new WeakReference(dialogInterface);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.Uw.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, CharSequence[] charSequenceArr) {
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
    class AnonymousClass2 implements android.support.v4.widget.NestedScrollView.b {
        final /* synthetic */ View TS;
        final /* synthetic */ View TT;

        AnonymousClass2(View view, View view2) {
            this.TS = view;
            this.TT = view2;
        }

        public final void a(NestedScrollView nestedScrollView) {
            AlertController.a(nestedScrollView, this.TS, this.TT);
        }
    }

    public AlertController(Context context, i iVar, Window window) {
        this.mContext = context;
        this.Th = iVar;
        this.Ti = window;
        this.mHandler = new b(iVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, android.support.v7.a.a.a.AlertDialog, R.attr.fv, 0);
        this.TI = obtainStyledAttributes.getResourceId(0, 0);
        this.TJ = obtainStyledAttributes.getResourceId(1, 0);
        this.TK = obtainStyledAttributes.getResourceId(2, 0);
        this.TL = obtainStyledAttributes.getResourceId(3, 0);
        this.TM = obtainStyledAttributes.getResourceId(4, 0);
        this.TN = obtainStyledAttributes.getResourceId(5, 0);
        this.TO = obtainStyledAttributes.getBoolean(6, true);
        this.Tj = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        obtainStyledAttributes.recycle();
        iVar.fA();
    }

    static boolean aQ(View view) {
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
            if (aQ(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.IT = charSequence;
        if (this.TF != null) {
            this.TF.setText(charSequence);
        }
    }

    public final void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.TA = charSequence;
                this.TB = message;
                this.TC = drawable;
                return;
            case -2:
                this.Tw = charSequence;
                this.Tx = message;
                this.Ty = drawable;
                return;
            case -1:
                this.Ts = charSequence;
                this.Tt = message;
                this.Tu = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void setIcon(int i) {
        this.rP = null;
        this.TE = i;
        if (this.sX == null) {
            return;
        }
        if (i != 0) {
            this.sX.setVisibility(0);
            this.sX.setImageResource(this.TE);
            return;
        }
        this.sX.setVisibility(8);
    }

    static ViewGroup c(View view, View view2) {
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

    static void a(View view, View view2, View view3) {
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

    static void a(Button button) {
        LayoutParams layoutParams = (LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
