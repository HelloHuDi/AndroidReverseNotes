package com.tencent.mm.plugin.readerapp.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bcn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ReaderAppSubscribeUI extends MMActivity {
    private ListView pEX;
    private a pEY;

    static class a extends BaseAdapter {
        private final Context context;
        final int[] pFa = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 4096, Utility.DEFAULT_STREAM_BUFFER_SIZE};
        int pFb;
        private String[] pFc = null;
        int pFd = 0;

        static class a {
            TextView gnB;
            CheckBox gnD;

            a() {
            }
        }

        public a(Context context, int i) {
            AppMethodBeat.i(76805);
            this.context = context;
            this.pFb = i;
            this.pFc = context.getString(R.string.di2).split(";");
            this.pFd = Bz(i);
            AppMethodBeat.o(76805);
        }

        public final int getCount() {
            return this.pFc.length;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(76806);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(this.context, R.layout.an4, null);
                aVar2.gnB = (TextView) view.findViewById(R.id.dv_);
                aVar2.gnD = (CheckBox) view.findViewById(R.id.dva);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.gnB.setText(this.pFc[i]);
            aVar.gnD.setChecked((this.pFb & this.pFa[i]) != 0);
            AppMethodBeat.o(76806);
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        private int Bz(int i) {
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(ReaderAppSubscribeUI readerAppSubscribeUI, int i) {
        AppMethodBeat.i(76812);
        readerAppSubscribeUI.By(i);
        AppMethodBeat.o(76812);
    }

    public final int getLayoutId() {
        return R.layout.an5;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(76807);
        super.onCreate(bundle);
        g.RP().Ry().set(868518890, (Object) "in");
        setMMTitle((int) R.string.az6);
        initView();
        AppMethodBeat.o(76807);
    }

    public final void initView() {
        AppMethodBeat.i(76808);
        this.pEY = new a(this, bo.h((Integer) g.RP().Ry().get(868518889, null)));
        this.pEX = (ListView) findViewById(R.id.dvb);
        this.pEX.setAdapter(this.pEY);
        this.pEX.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                AppMethodBeat.i(76802);
                a a = ReaderAppSubscribeUI.this.pEY;
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
                    h.g(ReaderAppSubscribeUI.this, R.string.az7, R.string.tz);
                }
                AppMethodBeat.o(76802);
            }
        });
        this.pEY.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(76803);
                ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this, ReaderAppSubscribeUI.this.pEY.pFb);
                AppMethodBeat.o(76803);
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(76804);
                c.a(ReaderAppSubscribeUI.this.pEX);
                AppMethodBeat.o(76804);
            }
        };
        AppMethodBeat.o(76808);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(76809);
        if (i == 4) {
            if (this.pEY != null) {
                By(this.pEY.pFb);
            }
            AppMethodBeat.o(76809);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(76809);
        return onKeyDown;
    }

    private void By(int i) {
        AppMethodBeat.i(76810);
        g.RP().Ry().set(868518889, Integer.valueOf(i));
        bcn bcn = new bcn();
        bcn.wGO = i;
        ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(43, bcn));
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "newsapp");
        intent.addFlags(67108864);
        com.tencent.mm.plugin.readerapp.b.a.gkE.c(intent, this);
        finish();
        AppMethodBeat.o(76810);
    }

    public void onResume() {
        AppMethodBeat.i(76811);
        super.onResume();
        this.pEY.notifyDataSetChanged();
        AppMethodBeat.o(76811);
    }
}
