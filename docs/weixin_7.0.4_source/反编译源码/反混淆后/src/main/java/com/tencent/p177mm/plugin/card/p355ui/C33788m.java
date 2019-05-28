package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.card.model.C11286b;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.ui.m */
public final class C33788m extends BaseAdapter {
    private List<C11286b> kaW = new ArrayList();
    OnClickListener koa;
    boolean kob = false;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.card.ui.m$a */
    class C27621a {
        View jAp;
        TextView kne;
        TextView kog;
        TextView koh;
        ImageView koi;
        CheckBox koj;

        private C27621a() {
        }

        /* synthetic */ C27621a(C33788m c33788m, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.m$1 */
    class C337891 implements OnClickListener {
        C337891() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88683);
            String str = (String) view.getTag();
            if (!TextUtils.isEmpty(str)) {
                String substring;
                if (str.contains(";")) {
                    substring = str.substring(0, str.indexOf(";"));
                } else {
                    substring = str;
                }
                C30379h.m48453a(C33788m.this.mContext, true, substring, "", C33788m.this.mContext.getString(C25738R.string.add), C33788m.this.mContext.getString(C25738R.string.atb), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(88682);
                        Intent intent = new Intent("android.intent.action.DIAL");
                        intent.setFlags(268435456);
                        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(substring).toString()));
                        C33788m.this.mContext.startActivity(intent);
                        AppMethodBeat.m2505o(88682);
                    }
                }, null);
            }
            AppMethodBeat.m2505o(88683);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(88692);
        C11286b tg = m55239tg(i);
        AppMethodBeat.m2505o(88692);
        return tg;
    }

    public C33788m(Context context) {
        AppMethodBeat.m2504i(88685);
        this.mContext = context;
        AppMethodBeat.m2505o(88685);
    }

    public final void setData(List<C11286b> list) {
        AppMethodBeat.m2504i(88686);
        this.kaW.clear();
        this.kaW.addAll(list);
        AppMethodBeat.m2505o(88686);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(88687);
        int size = this.kaW.size();
        AppMethodBeat.m2505o(88687);
        return size;
    }

    /* renamed from: tg */
    private C11286b m55239tg(int i) {
        AppMethodBeat.m2504i(88688);
        C11286b c11286b = (C11286b) this.kaW.get(i);
        AppMethodBeat.m2505o(88688);
        return c11286b;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(88689);
        final C11286b tg = m55239tg(i);
        switch (tg.kcg) {
            case 2:
                view = View.inflate(this.mContext, 2130968897, null);
                TextView textView = (TextView) view.findViewById(2131821943);
                TextView textView2 = (TextView) view.findViewById(2131821944);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(2131821945);
                if (TextUtils.isEmpty(tg.kck)) {
                    linearLayout.setVisibility(8);
                } else {
                    linearLayout.setTag(tg.kck);
                    linearLayout.setOnClickListener(new C337891());
                    ((ImageView) view.findViewById(2131821946)).setBackgroundColor(C38736l.m65701Hn(tg.color));
                    linearLayout.setVisibility(0);
                }
                textView.setText(tg.title);
                textView2.setText(tg.kbW);
                AppMethodBeat.m2505o(88689);
                break;
            default:
                C27621a c27621a;
                boolean z;
                if (view != null) {
                    c27621a = (C27621a) view.getTag();
                } else {
                    c27621a = null;
                }
                if (view == null || r0 == null) {
                    view = View.inflate(this.mContext, 2130968898, null);
                    C27621a c27621a2 = new C27621a(this, (byte) 0);
                    c27621a2.kne = (TextView) view.findViewById(2131821951);
                    c27621a2.kog = (TextView) view.findViewById(2131821952);
                    c27621a2.koh = (TextView) view.findViewById(2131821948);
                    c27621a2.koi = (ImageView) view.findViewById(2131821950);
                    c27621a2.jAp = view.findViewById(2131821949);
                    c27621a2.koj = (CheckBox) view.findViewById(2131821953);
                    view.setTag(c27621a2);
                    c27621a = c27621a2;
                }
                c27621a.kne.setText(tg.title);
                if (tg.kci) {
                    c27621a.koj.setVisibility(0);
                    c27621a.koj.setChecked(tg.kcj);
                    c27621a.koj.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(88684);
                            if (((CheckBox) view).isChecked()) {
                                tg.kcj = true;
                                AppMethodBeat.m2505o(88684);
                                return;
                            }
                            tg.kcj = false;
                            AppMethodBeat.m2505o(88684);
                        }
                    });
                } else {
                    c27621a.koj.setVisibility(8);
                }
                if (TextUtils.isEmpty(tg.kbW)) {
                    c27621a.kog.setVisibility(4);
                } else {
                    c27621a.kog.setVisibility(0);
                    c27621a.kog.setText(tg.kbW);
                }
                if ((tg.vUW & 1) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    c27621a.kne.setGravity(17);
                    c27621a.kne.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12123t7));
                    c27621a.kog.setVisibility(8);
                } else {
                    c27621a.kne.setGravity(3);
                    c27621a.kne.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12109sr));
                }
                if (tg.kch) {
                    c27621a.koh.setVisibility(0);
                } else {
                    c27621a.koh.setVisibility(8);
                }
                c27621a.kog.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12108sq));
                if (C5046bo.isNullOrNil(tg.kKZ)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    c27621a.koi.setVisibility(0);
                    C45778m.m84644a(c27621a.koi, tg.kKZ, C1338a.fromDPToPix(this.mContext, 20), (int) C25738R.drawable.bcm, false);
                } else {
                    c27621a.koi.setVisibility(8);
                }
                if (i + 1 < getCount()) {
                    C33788m.m55237a(c27621a.jAp, m55239tg(i));
                    C33788m.m55237a(c27621a.jAp, m55239tg(i + 1));
                } else if (i + 1 == getCount()) {
                    if (this.kob) {
                        C33788m.m55238o(c27621a.jAp, true);
                    } else {
                        C33788m.m55238o(c27621a.jAp, false);
                    }
                }
                AppMethodBeat.m2505o(88689);
                break;
        }
        return view;
    }

    /* renamed from: a */
    private static void m55237a(View view, C11286b c11286b) {
        AppMethodBeat.m2504i(88690);
        if (c11286b == null) {
            AppMethodBeat.m2505o(88690);
            return;
        }
        C33788m.m55238o(view, c11286b.kch);
        AppMethodBeat.m2505o(88690);
    }

    /* renamed from: o */
    private static void m55238o(View view, boolean z) {
        AppMethodBeat.m2504i(88691);
        Rect dc = C45778m.m84648dc(view);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z) {
            view.setBackgroundResource(C25738R.drawable.f6900uv);
        } else {
            view.setBackgroundResource(C25738R.drawable.a_q);
        }
        view.setLayoutParams(layoutParams);
        C45778m.m84649k(view, dc);
        AppMethodBeat.m2505o(88691);
    }
}
