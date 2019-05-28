package com.tencent.p177mm.plugin.record.p493ui.p494b;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3713b;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C43438b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.record.ui.b.d */
public final class C28843d implements C3713b {
    Context context;
    int jLX;
    int jLY;

    /* renamed from: com.tencent.mm.plugin.record.ui.b.d$2 */
    class C216212 implements OnTouchListener {
        C216212() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(24371);
            if (motionEvent.getAction() == 0) {
                C28843d.this.jLX = (int) motionEvent.getRawX();
                C28843d.this.jLY = (int) motionEvent.getRawY();
            }
            AppMethodBeat.m2505o(24371);
            return false;
        }
    }

    public C28843d(Context context) {
        this.context = context;
    }

    /* renamed from: eK */
    public final View mo8346eK(Context context) {
        AppMethodBeat.m2504i(24372);
        View inflate = View.inflate(context, 2130970484, null);
        AppMethodBeat.m2505o(24372);
        return inflate;
    }

    /* renamed from: a */
    public final void mo8344a(View view, int i, final C43438b c43438b) {
        AppMethodBeat.m2504i(24373);
        TextView textView = (TextView) view.findViewById(2131826907);
        textView.setText(c43438b.cAv.desc);
        C44089j.m79307h(textView, 1);
        textView.setOnLongClickListener(new OnLongClickListener() {

            /* renamed from: com.tencent.mm.plugin.record.ui.b.d$1$1 */
            class C216191 implements OnCreateContextMenuListener {
                C216191() {
                }

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    AppMethodBeat.m2504i(24367);
                    contextMenu.add(C28843d.this.context.getString(C25738R.string.f9082oy));
                    AppMethodBeat.m2505o(24367);
                }
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.m2504i(24370);
                final TextView textView = (TextView) view;
                SpannableString spannableString = new SpannableString(textView.getText());
                spannableString.setSpan(new BackgroundColorSpan(C28843d.this.context.getResources().getColor(C25738R.color.f12117sz)), 0, textView.getText().length(), 33);
                textView.setText(spannableString);
                C24088a c24088a = new C24088a(C28843d.this.context, textView);
                c24088a.zRZ = new C216191();
                c24088a.rBm = new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(24368);
                        if (i == 0) {
                            ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setText(textView.getText());
                            C30379h.m48464bP(C28843d.this.context, C28843d.this.context.getString(C25738R.string.f9083oz));
                        }
                        AppMethodBeat.m2505o(24368);
                    }
                };
                c24088a.zHM = new OnDismissListener() {
                    public final void onDismiss() {
                        AppMethodBeat.m2504i(24369);
                        textView.setText(c43438b.cAv.desc);
                        C44089j.m79307h(textView, 1);
                        AppMethodBeat.m2505o(24369);
                    }
                };
                if (view.getTag(2131820679) instanceof int[]) {
                    int[] iArr = (int[]) view.getTag(2131820679);
                    c24088a.mo22431dn(iArr[0], iArr[1]);
                } else {
                    c24088a.mo22431dn(C28843d.this.jLX, C28843d.this.jLY);
                }
                AppMethodBeat.m2505o(24370);
                return true;
            }
        });
        view.setOnTouchListener(new C216212());
        AppMethodBeat.m2505o(24373);
    }

    public final void destroy() {
        this.context = null;
    }

    public final void pause() {
    }
}
