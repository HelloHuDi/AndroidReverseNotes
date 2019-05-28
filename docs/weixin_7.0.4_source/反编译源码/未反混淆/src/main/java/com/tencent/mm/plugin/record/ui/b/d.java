package com.tencent.mm.plugin.record.ui.b;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.a;

public final class d implements b {
    Context context;
    int jLX;
    int jLY;

    public d(Context context) {
        this.context = context;
    }

    public final View eK(Context context) {
        AppMethodBeat.i(24372);
        View inflate = View.inflate(context, R.layout.anq, null);
        AppMethodBeat.o(24372);
        return inflate;
    }

    public final void a(View view, int i, final com.tencent.mm.plugin.record.ui.a.b bVar) {
        AppMethodBeat.i(24373);
        TextView textView = (TextView) view.findViewById(R.id.dx0);
        textView.setText(bVar.cAv.desc);
        j.h(textView, 1);
        textView.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(24370);
                final TextView textView = (TextView) view;
                SpannableString spannableString = new SpannableString(textView.getText());
                spannableString.setSpan(new BackgroundColorSpan(d.this.context.getResources().getColor(R.color.sz)), 0, textView.getText().length(), 33);
                textView.setText(spannableString);
                a aVar = new a(d.this.context, textView);
                aVar.zRZ = new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(24367);
                        contextMenu.add(d.this.context.getString(R.string.oy));
                        AppMethodBeat.o(24367);
                    }
                };
                aVar.rBm = new com.tencent.mm.ui.base.n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(24368);
                        if (i == 0) {
                            ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setText(textView.getText());
                            h.bP(d.this.context, d.this.context.getString(R.string.oz));
                        }
                        AppMethodBeat.o(24368);
                    }
                };
                aVar.zHM = new OnDismissListener() {
                    public final void onDismiss() {
                        AppMethodBeat.i(24369);
                        textView.setText(bVar.cAv.desc);
                        j.h(textView, 1);
                        AppMethodBeat.o(24369);
                    }
                };
                if (view.getTag(R.id.cy) instanceof int[]) {
                    int[] iArr = (int[]) view.getTag(R.id.cy);
                    aVar.dn(iArr[0], iArr[1]);
                } else {
                    aVar.dn(d.this.jLX, d.this.jLY);
                }
                AppMethodBeat.o(24370);
                return true;
            }
        });
        view.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(24371);
                if (motionEvent.getAction() == 0) {
                    d.this.jLX = (int) motionEvent.getRawX();
                    d.this.jLY = (int) motionEvent.getRawY();
                }
                AppMethodBeat.o(24371);
                return false;
            }
        });
        AppMethodBeat.o(24373);
    }

    public final void destroy() {
        this.context = null;
    }

    public final void pause() {
    }
}
