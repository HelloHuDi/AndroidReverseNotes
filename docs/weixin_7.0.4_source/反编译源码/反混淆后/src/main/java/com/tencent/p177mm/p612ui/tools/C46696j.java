package com.tencent.p177mm.p612ui.tools;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.p612ui.base.C30394k;
import com.tencent.p177mm.p612ui.base.C40671n.C36072a;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C40670b;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.tools.j */
public final class C46696j implements OnItemClickListener {
    private OnDismissListener jbD;
    private Context mContext;
    private LayoutInflater mInflater;
    public C30394k rBk;
    public C36073c rBl;
    public C5279d rBm;
    private C44273l rBn;
    private C30762a zFS;
    public C36072a zFT;
    public C40670b zFU;

    /* renamed from: com.tencent.mm.ui.tools.j$a */
    class C30762a extends BaseAdapter {

        /* renamed from: com.tencent.mm.ui.tools.j$a$a */
        class C5589a {
            TextView gsf;
            ImageView iNr;

            private C5589a() {
            }

            /* synthetic */ C5589a(C30762a c30762a, byte b) {
                this();
            }
        }

        private C30762a() {
        }

        /* synthetic */ C30762a(C46696j c46696j, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(107704);
            int size = C46696j.this.rBn.size();
            AppMethodBeat.m2505o(107704);
            return size;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C5589a c5589a;
            AppMethodBeat.m2504i(107705);
            if (view == null) {
                view = C46696j.this.mInflater.inflate(2130970123, viewGroup, false);
                C5589a c5589a2 = new C5589a(this, (byte) 0);
                c5589a2.gsf = (TextView) view.findViewById(2131820678);
                c5589a2.iNr = (ImageView) view.findViewById(2131820915);
                view.setTag(c5589a2);
                c5589a = c5589a2;
            } else {
                c5589a = (C5589a) view.getTag();
            }
            MenuItem item = C46696j.this.rBn.getItem(i);
            c5589a.gsf.setText(item.getTitle());
            Drawable icon = C46696j.this.rBn.getItem(i).getIcon();
            if (icon != null) {
                c5589a.iNr.setVisibility(0);
                c5589a.iNr.setImageDrawable(icon);
            } else if (C46696j.this.zFT != null) {
                c5589a.iNr.setVisibility(0);
                C46696j.this.zFT.mo5750a(c5589a.iNr, item);
            } else {
                c5589a.iNr.setVisibility(8);
            }
            if (C46696j.this.zFU != null) {
                C46696j.this.zFU.mo5751a(c5589a.gsf, item);
            }
            AppMethodBeat.m2505o(107705);
            return view;
        }
    }

    public C46696j(Context context) {
        AppMethodBeat.m2504i(107706);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.rBk = new C30394k(context);
        this.rBn = new C44273l(context);
        AppMethodBeat.m2505o(107706);
    }

    /* renamed from: a */
    public final void mo75005a(View view, final OnCreateContextMenuListener onCreateContextMenuListener, C5279d c5279d) {
        AppMethodBeat.m2504i(107707);
        this.rBm = c5279d;
        C4990ab.m7418v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
        if (view instanceof AbsListView) {
            C4990ab.m7418v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
            ((AbsListView) view).setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.m2504i(107701);
                    C46696j.this.rBn.clear();
                    C4990ab.m7418v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
                    AdapterContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
                    onCreateContextMenuListener.onCreateContextMenu(C46696j.this.rBn, view, adapterContextMenuInfo);
                    for (MenuItem menuItem : C46696j.this.rBn.yvT) {
                        ((C44274m) menuItem).yvW = adapterContextMenuInfo;
                    }
                    C46696j.this.cuu();
                    AppMethodBeat.m2505o(107701);
                    return true;
                }
            });
            AppMethodBeat.m2505o(107707);
        } else if (view instanceof MMWebView) {
            C4990ab.m7418v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
            view.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.m2504i(107702);
                    C4990ab.m7418v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
                    C46696j.this.rBn.clear();
                    onCreateContextMenuListener.onCreateContextMenu(C46696j.this.rBn, view, null);
                    C46696j.this.cuu();
                    if (C46696j.this.rBn.size() > 0) {
                        AppMethodBeat.m2505o(107702);
                        return true;
                    }
                    AppMethodBeat.m2505o(107702);
                    return false;
                }
            });
            AppMethodBeat.m2505o(107707);
        } else {
            C4990ab.m7418v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
            view.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.m2504i(107703);
                    C4990ab.m7418v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
                    C46696j.this.rBn.clear();
                    onCreateContextMenuListener.onCreateContextMenu(C46696j.this.rBn, view, null);
                    C46696j.this.cuu();
                    AppMethodBeat.m2505o(107703);
                    return true;
                }
            });
            AppMethodBeat.m2505o(107707);
        }
    }

    /* renamed from: a */
    public final void mo75004a(View view, int i, long j, OnCreateContextMenuListener onCreateContextMenuListener, C5279d c5279d) {
        AppMethodBeat.m2504i(107708);
        if ((this.mContext instanceof MMFragmentActivity) && ((MMFragmentActivity) this.mContext).isSwiping()) {
            C4990ab.m7420w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
            AppMethodBeat.m2505o(107708);
            return;
        }
        this.rBn.clear();
        AdapterContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        onCreateContextMenuListener.onCreateContextMenu(this.rBn, view, adapterContextMenuInfo);
        for (MenuItem menuItem : this.rBn.yvT) {
            ((C44274m) menuItem).yvW = adapterContextMenuInfo;
        }
        cuu();
        this.rBm = c5279d;
        AppMethodBeat.m2505o(107708);
    }

    /* renamed from: a */
    public final void mo75006a(View view, OnCreateContextMenuListener onCreateContextMenuListener, C5279d c5279d, OnDismissListener onDismissListener) {
        AppMethodBeat.m2504i(107709);
        if ((this.mContext instanceof MMFragmentActivity) && ((MMFragmentActivity) this.mContext).isSwiping()) {
            C4990ab.m7420w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
            AppMethodBeat.m2505o(107709);
            return;
        }
        this.jbD = onDismissListener;
        this.rBn.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.rBn, view, null);
        cuu();
        this.rBm = c5279d;
        AppMethodBeat.m2505o(107709);
    }

    /* renamed from: b */
    public final void mo75009b(View view, OnCreateContextMenuListener onCreateContextMenuListener, C5279d c5279d) {
        AppMethodBeat.m2504i(107710);
        mo75006a(view, onCreateContextMenuListener, c5279d, null);
        AppMethodBeat.m2505o(107710);
    }

    /* renamed from: a */
    public final void mo75007a(C36073c c36073c) {
        this.rBl = c36073c;
    }

    /* renamed from: a */
    public final void mo75008a(C5279d c5279d) {
        this.rBm = c5279d;
    }

    /* renamed from: e */
    public final void mo75012e(OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(107711);
        this.rBk.setOnCancelListener(onCancelListener);
        AppMethodBeat.m2505o(107711);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(107712);
        C44274m c44274m = (C44274m) this.rBn.yvT.get(i);
        if (c44274m.performClick()) {
            C4990ab.m7416i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
            dismiss();
            AppMethodBeat.m2505o(107712);
            return;
        }
        if (this.rBm != null) {
            this.rBm.onMMMenuItemSelected(c44274m, i);
        }
        dismiss();
        AppMethodBeat.m2505o(107712);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(107713);
        if (this.rBk.isShowing()) {
            this.rBk.dismiss();
        }
        AppMethodBeat.m2505o(107713);
    }

    public final Dialog cuu() {
        AppMethodBeat.m2504i(107714);
        if (this.rBl != null) {
            this.rBn.clear();
            this.rBn = new C44273l(this.mContext);
            this.rBl.mo5746a(this.rBn);
        }
        if (this.rBn.dzR()) {
            C4990ab.m7420w("MicroMsg.MMSubMenuHelper", "show, menu empty");
            AppMethodBeat.m2505o(107714);
            return null;
        }
        if (this.zFS == null) {
            this.zFS = new C30762a(this, (byte) 0);
        }
        this.rBk.khG = this.zFS;
        this.rBk.vtI = this;
        this.rBk.setTitle(this.rBn.abz);
        this.rBk.setOnDismissListener(this.jbD);
        this.rBk.show();
        Dialog dialog = this.rBk;
        AppMethodBeat.m2505o(107714);
        return dialog;
    }
}
