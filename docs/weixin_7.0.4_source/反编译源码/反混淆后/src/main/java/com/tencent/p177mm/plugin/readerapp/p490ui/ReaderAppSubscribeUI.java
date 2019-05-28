package com.tencent.p177mm.plugin.readerapp.p490ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.readerapp.p1654b.C46155a;
import com.tencent.p177mm.protocal.protobuf.bcn;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI */
public class ReaderAppSubscribeUI extends MMActivity {
    private ListView pEX;
    private C3683a pEY;

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI$a */
    static class C3683a extends BaseAdapter {
        private final Context context;
        final int[] pFa = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 4096, Utility.DEFAULT_STREAM_BUFFER_SIZE};
        int pFb;
        private String[] pFc = null;
        int pFd = 0;

        /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI$a$a */
        static class C3684a {
            TextView gnB;
            CheckBox gnD;

            C3684a() {
            }
        }

        public C3683a(Context context, int i) {
            AppMethodBeat.m2504i(76805);
            this.context = context;
            this.pFb = i;
            this.pFc = context.getString(C25738R.string.di2).split(";");
            this.pFd = m5997Bz(i);
            AppMethodBeat.m2505o(76805);
        }

        public final int getCount() {
            return this.pFc.length;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C3684a c3684a;
            AppMethodBeat.m2504i(76806);
            if (view == null) {
                C3684a c3684a2 = new C3684a();
                view = View.inflate(this.context, 2130970461, null);
                c3684a2.gnB = (TextView) view.findViewById(2131826843);
                c3684a2.gnD = (CheckBox) view.findViewById(2131826844);
                view.setTag(c3684a2);
                c3684a = c3684a2;
            } else {
                c3684a = (C3684a) view.getTag();
            }
            c3684a.gnB.setText(this.pFc[i]);
            c3684a.gnD.setChecked((this.pFb & this.pFa[i]) != 0);
            AppMethodBeat.m2505o(76806);
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        /* renamed from: Bz */
        private int m5997Bz(int i) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2;
                if (i3 >= this.pFa.length) {
                    return i4;
                }
                if ((this.pFa[i3] & i) != 0) {
                    i2 = i4 + 1;
                } else {
                    i2 = i4;
                }
                i3++;
            }
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.pFc[i];
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI$1 */
    class C395691 implements OnItemClickListener {
        C395691() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = 1;
            AppMethodBeat.m2504i(76802);
            C3683a a = ReaderAppSubscribeUI.this.pEY;
            if ((a.pFb & a.pFa[i]) != 0) {
                a.pFb &= a.pFa[i] ^ -1;
                a.pFd--;
                if (a.pFd < 0) {
                    a.pFd = 0;
                }
                a.notifyDataSetChanged();
            } else if (a.pFd < 3) {
                a.pFb |= a.pFa[i];
                a.pFd++;
                if (a.pFd > a.pFa.length) {
                    a.pFd = a.pFa.length;
                }
                a.notifyDataSetChanged();
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                C30379h.m48467g(ReaderAppSubscribeUI.this, C25738R.string.az7, C25738R.string.f9238tz);
            }
            AppMethodBeat.m2505o(76802);
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI$3 */
    class C395703 implements OnClickListener {
        C395703() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(76804);
            C4978c.m7375a(ReaderAppSubscribeUI.this.pEX);
            AppMethodBeat.m2505o(76804);
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI$2 */
    class C461572 implements OnMenuItemClickListener {
        C461572() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(76803);
            ReaderAppSubscribeUI.m86155a(ReaderAppSubscribeUI.this, ReaderAppSubscribeUI.this.pEY.pFb);
            AppMethodBeat.m2505o(76803);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m86155a(ReaderAppSubscribeUI readerAppSubscribeUI, int i) {
        AppMethodBeat.m2504i(76812);
        readerAppSubscribeUI.m86153By(i);
        AppMethodBeat.m2505o(76812);
    }

    public final int getLayoutId() {
        return 2130970462;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(76807);
        super.onCreate(bundle);
        C1720g.m3536RP().mo5239Ry().set(868518890, (Object) "in");
        setMMTitle((int) C25738R.string.az6);
        initView();
        AppMethodBeat.m2505o(76807);
    }

    public final void initView() {
        AppMethodBeat.m2504i(76808);
        this.pEY = new C3683a(this, C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(868518889, null)));
        this.pEX = (ListView) findViewById(2131826845);
        this.pEX.setAdapter(this.pEY);
        this.pEX.setOnItemClickListener(new C395691());
        this.pEY.notifyDataSetChanged();
        setBackBtn(new C461572());
        C395703 c395703 = new C395703();
        AppMethodBeat.m2505o(76808);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(76809);
        if (i == 4) {
            if (this.pEY != null) {
                m86153By(this.pEY.pFb);
            }
            AppMethodBeat.m2505o(76809);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(76809);
        return onKeyDown;
    }

    /* renamed from: By */
    private void m86153By(int i) {
        AppMethodBeat.m2504i(76810);
        C1720g.m3536RP().mo5239Ry().set(868518889, Integer.valueOf(i));
        bcn bcn = new bcn();
        bcn.wGO = i;
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(43, bcn));
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "newsapp");
        intent.addFlags(67108864);
        C46155a.gkE.mo38912c(intent, this);
        finish();
        AppMethodBeat.m2505o(76810);
    }

    public void onResume() {
        AppMethodBeat.m2504i(76811);
        super.onResume();
        this.pEY.notifyDataSetChanged();
        AppMethodBeat.m2505o(76811);
    }
}
