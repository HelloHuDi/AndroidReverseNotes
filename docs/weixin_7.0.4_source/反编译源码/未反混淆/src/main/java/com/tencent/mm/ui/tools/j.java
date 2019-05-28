package com.tencent.mm.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMWebView;

public final class j implements OnItemClickListener {
    private OnDismissListener jbD;
    private Context mContext;
    private LayoutInflater mInflater;
    public k rBk;
    public c rBl;
    public d rBm;
    private l rBn;
    private a zFS;
    public com.tencent.mm.ui.base.n.a zFT;
    public b zFU;

    class a extends BaseAdapter {

        class a {
            TextView gsf;
            ImageView iNr;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        private a() {
        }

        /* synthetic */ a(j jVar, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(107704);
            int size = j.this.rBn.size();
            AppMethodBeat.o(107704);
            return size;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(107705);
            if (view == null) {
                view = j.this.mInflater.inflate(R.layout.ae0, viewGroup, false);
                a aVar2 = new a(this, (byte) 0);
                aVar2.gsf = (TextView) view.findViewById(R.id.cx);
                aVar2.iNr = (ImageView) view.findViewById(R.id.jb);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            MenuItem item = j.this.rBn.getItem(i);
            aVar.gsf.setText(item.getTitle());
            Drawable icon = j.this.rBn.getItem(i).getIcon();
            if (icon != null) {
                aVar.iNr.setVisibility(0);
                aVar.iNr.setImageDrawable(icon);
            } else if (j.this.zFT != null) {
                aVar.iNr.setVisibility(0);
                j.this.zFT.a(aVar.iNr, item);
            } else {
                aVar.iNr.setVisibility(8);
            }
            if (j.this.zFU != null) {
                j.this.zFU.a(aVar.gsf, item);
            }
            AppMethodBeat.o(107705);
            return view;
        }
    }

    public j(Context context) {
        AppMethodBeat.i(107706);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.rBk = new k(context);
        this.rBn = new l(context);
        AppMethodBeat.o(107706);
    }

    public final void a(View view, final OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        AppMethodBeat.i(107707);
        this.rBm = dVar;
        ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
        if (view instanceof AbsListView) {
            ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
            ((AbsListView) view).setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(107701);
                    j.this.rBn.clear();
                    ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
                    AdapterContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
                    onCreateContextMenuListener.onCreateContextMenu(j.this.rBn, view, adapterContextMenuInfo);
                    for (MenuItem menuItem : j.this.rBn.yvT) {
                        ((m) menuItem).yvW = adapterContextMenuInfo;
                    }
                    j.this.cuu();
                    AppMethodBeat.o(107701);
                    return true;
                }
            });
            AppMethodBeat.o(107707);
        } else if (view instanceof MMWebView) {
            ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
            view.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(107702);
                    ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
                    j.this.rBn.clear();
                    onCreateContextMenuListener.onCreateContextMenu(j.this.rBn, view, null);
                    j.this.cuu();
                    if (j.this.rBn.size() > 0) {
                        AppMethodBeat.o(107702);
                        return true;
                    }
                    AppMethodBeat.o(107702);
                    return false;
                }
            });
            AppMethodBeat.o(107707);
        } else {
            ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
            view.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(107703);
                    ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
                    j.this.rBn.clear();
                    onCreateContextMenuListener.onCreateContextMenu(j.this.rBn, view, null);
                    j.this.cuu();
                    AppMethodBeat.o(107703);
                    return true;
                }
            });
            AppMethodBeat.o(107707);
        }
    }

    public final void a(View view, int i, long j, OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        AppMethodBeat.i(107708);
        if ((this.mContext instanceof MMFragmentActivity) && ((MMFragmentActivity) this.mContext).isSwiping()) {
            ab.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
            AppMethodBeat.o(107708);
            return;
        }
        this.rBn.clear();
        AdapterContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        onCreateContextMenuListener.onCreateContextMenu(this.rBn, view, adapterContextMenuInfo);
        for (MenuItem menuItem : this.rBn.yvT) {
            ((m) menuItem).yvW = adapterContextMenuInfo;
        }
        cuu();
        this.rBm = dVar;
        AppMethodBeat.o(107708);
    }

    public final void a(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar, OnDismissListener onDismissListener) {
        AppMethodBeat.i(107709);
        if ((this.mContext instanceof MMFragmentActivity) && ((MMFragmentActivity) this.mContext).isSwiping()) {
            ab.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
            AppMethodBeat.o(107709);
            return;
        }
        this.jbD = onDismissListener;
        this.rBn.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.rBn, view, null);
        cuu();
        this.rBm = dVar;
        AppMethodBeat.o(107709);
    }

    public final void b(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        AppMethodBeat.i(107710);
        a(view, onCreateContextMenuListener, dVar, null);
        AppMethodBeat.o(107710);
    }

    public final void a(c cVar) {
        this.rBl = cVar;
    }

    public final void a(d dVar) {
        this.rBm = dVar;
    }

    public final void e(OnCancelListener onCancelListener) {
        AppMethodBeat.i(107711);
        this.rBk.setOnCancelListener(onCancelListener);
        AppMethodBeat.o(107711);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(107712);
        m mVar = (m) this.rBn.yvT.get(i);
        if (mVar.performClick()) {
            ab.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
            dismiss();
            AppMethodBeat.o(107712);
            return;
        }
        if (this.rBm != null) {
            this.rBm.onMMMenuItemSelected(mVar, i);
        }
        dismiss();
        AppMethodBeat.o(107712);
    }

    public final void dismiss() {
        AppMethodBeat.i(107713);
        if (this.rBk.isShowing()) {
            this.rBk.dismiss();
        }
        AppMethodBeat.o(107713);
    }

    public final Dialog cuu() {
        AppMethodBeat.i(107714);
        if (this.rBl != null) {
            this.rBn.clear();
            this.rBn = new l(this.mContext);
            this.rBl.a(this.rBn);
        }
        if (this.rBn.dzR()) {
            ab.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
            AppMethodBeat.o(107714);
            return null;
        }
        if (this.zFS == null) {
            this.zFS = new a(this, (byte) 0);
        }
        this.rBk.khG = this.zFS;
        this.rBk.vtI = this;
        this.rBk.setTitle(this.rBn.abz);
        this.rBk.setOnDismissListener(this.jbD);
        this.rBk.show();
        Dialog dialog = this.rBk;
        AppMethodBeat.o(107714);
        return dialog;
    }
}
